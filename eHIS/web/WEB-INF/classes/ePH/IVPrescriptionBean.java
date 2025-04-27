/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Rev.Date     Rev.By		Description
--------------------------------------------------------------------------------------------------------
23/02/2018	IN066779		Sharanraj	23/02/2018	  Chandra       ML-MMOH-CRF-1000.1
05/02/2019	IN068344	     	Manickavasagam 		  			GHL-CRF-0549 [IN068344] 
13/08/2019      IN070987   		Manickavasagam J     			 SKR-SCF-1254
04/09/2019      IN:071108		    manickavasagam                                          ML-MMOH-CRF-1408
05/09/2019      IN070451   B Haribabu   06/09/2019     Manickam     ML-MMOH-CRF-1408
24/10/2019		INO71514	Shazana							  				SKR-SCF-1276
04/06/2020      IN072753           Prabha											   NMC-JD-CRF-0046
30/06/2020      IN:072715          Haribabu     30/06/2020     Manickavasagam J        MMS-DM-CRF-0165
02/07/2020      IN:073352    Haribabu                               Regression - PHIS-PH-Alpha - Unable to Release Rx
08/10/2020  	IN074073        	Manickavasagam J                                    SKR-SCF-1440
2/12/2020			6041			Shazana       					NMC-JD-CRF-0063
06/01/2021		 TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
21/04/2023       43411             Sreenadh         Ramesh      MMS-KH-SCF-0200
13/7/2023      TFS-46322      hariharan             Ramesh goil            COMMON-ICN-0310
--------------------------------------------------------------------------------------------------------
*/
package ePH;
import java.io.*;	   
import java.util.*;
import java.sql.*;
//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
import javax.servlet.*;
import javax.servlet.http.*;
import ePH.Common.*;
import eCommon.Common.*;
import ePH.IVPrescription.*;
import oracle.sql.*;
import eOR.*;
import eOR.Common.ChkDef;
import java.text.DecimalFormat;
import java.text.*;
import java.text.SimpleDateFormat;
 
public class IVPrescriptionBean extends PhAdapter implements Serializable, eOR.SceduleFreqeuncyInterface {
	private String order_date			= "";
	private String patient_class		= "";
	private String patient_id			= "";
	private String encounter_id			= "";
	private String drugCodes			= "";
	private String freqNature			= "";
	private String repeat_value			= "";
	private String int_value			= "";
	private String infRate_srlNo		= "";
	private String order_status			= "10";
	private String orderID				= "";
	private String packSize				= "";
	private String stock_uom			= "";
	private String AmendOrderRemarks	= "";
	private String order_type_flag      = ""; 

    private String ORDER_CATALOG_CODE	= "";
	private	String CATALOG_DESC			= "";
	private	String START_DATE_TIME		= "";
	private	String END_DATE_TIME		= "";
	private	String START_DATE			= "";
	private	String END_DATE				= "";

	private	String DURN_VALUE			= "";
	private	String DURN_TYPE			= "";
	private	String QTY_VALUE			= "";
	private	String QTY_UNIT				= "";
	private	String INFUSE_OVER			= "";
	private	String INFUSION_RATE		= "";
	private	String ORDER_LINE_NUM		= "";
	private	String freq_code			= "";
	private	String DOSAGE				= "";
	private	String VOLUME				= "";
	private String admin_rate			= "";
	private String fluid_remarks		= "";
	private String fluid_flag			= "";

	private int srlNo					= 0;
	private int presc_mode				= 0;
	private ArrayList diagText			= new ArrayList(12);
	private ArrayList drugDetails		= new ArrayList();
	private ArrayList DrugRemarks		= new ArrayList();
	private HashMap scheduleFrequency	= new HashMap();
	private HashMap FluidDetails		= new HashMap();
	private HashMap amendFluidDetails	= null;
	private ArrayList presDetails		= new ArrayList();
	private ArrayList amendDetails		= new ArrayList();
	private ArrayList amendDrugCodes	= new ArrayList();
	private HashMap AmendAllergyRemarks	= new HashMap();
	private HashMap AmendDoseRemarks	= new HashMap();
	private HashMap AmendRxRemarks		= new HashMap();
	private String license				= "";

	private String or_mode				= "";
	private String ivtype				= "";
	private ArrayList drug_stock_dtls	= new ArrayList();
	private ArrayList AllFluids			= new ArrayList(); 
	private String locn_type			= "";
	private String locn_code			= "";
	private String pract_id				= "";
	private String order_priority		= "";
	private String height				= "";
	private String height_uom			= "";
	private String weight				= "";
	private String weight_uom			= "";
	private String bsa					= "";
	private String bmi					= "";
	private String allergic_yn			= "";
	String  order_id1                   = "";
	private String ivpb					= "N";
	private String ivprep				= "";
	protected HashMap amend_reason1			= new HashMap();//IN066779
	protected String called_from_amend		= null;//IN066779
	protected HashMap amend_reason_temp		= new HashMap();////IN066779
	//Addeed for ml-mmoh-crf-0863 start
	private String disp_locn_code="";    
	private String take_home_medication_op = "";//added for NMC-JD-CRF-0063 
	private String opDischMedInd="";
 
 
	public String getTakeHomeMedicationOp() {
		return take_home_medication_op;
	}
	public void setTakeHomeMedicationOp(String take_home_medication_op) {
		this.take_home_medication_op = take_home_medication_op;
	}
	public String getOpDischMedInd() {
		return opDischMedInd;
	}
	public void setOpDischMedInd(String opDischMedInd) {
		this.opDischMedInd = opDischMedInd;
	}//END
	public String getDisp_locn_code() {
		return disp_locn_code;
	}
	public void setDisp_locn_code(String disp_locn_code) {
		this.disp_locn_code = disp_locn_code;
	}
	//Addeed for ml-mmoh-crf-0863 end
	
	
   //added for NMC-JD-CRF-0046 start
	private String displocn="";
	
	public String getDisplocn() {
		return displocn;
	}
	public void setDisplocn(String displocn) {
		this.displocn = displocn;
	}
    //added for NMC-JD-CRF-0046 end
	
	
	//Added for IN:070451 start
	private String called_from_iv_amend = "";
	public String getCalledFromIVAmend() {
		return called_from_iv_amend;
	}
	public void setCalledFromIVAmend(String called_from_iv_amend) {
		this.called_from_iv_amend = called_from_iv_amend;
	}
	private String iv_ordered_qty = "";

	public String getIVOrderedQty() {
		return iv_ordered_qty;
	}
	public void setIVOrderedQty(String iv_ordered_qty) {
		this.iv_ordered_qty = iv_ordered_qty;
	}
	//Added for IN:070451 end
	private String ext_db_interface_yn	= "N";
	private String drug_db_product_id   = "";
    private String ext_dosage_chk_yn	= "N";

	private HashMap curr_drug_dtls		 = new HashMap();
	private ArrayList existing_iv_orders = new ArrayList();
	private ArrayList orderSetValues	 = new ArrayList();
	private String  comptabile_fluid_yn	 = "N";
	private String Drg_Trade_Codes_Arr[];
	private String Fld_Trade_Code		= "";
	private String buildMAR_yn		= "";
	private String trn_group_ref		= "";
	private String tokens_generated_yn		= "";
	private String age_group				=	"";
	private boolean isCopyOrder				=	false;
	private HashMap schdMap					= null;
	private HashMap MFRRecs					= null;
	private HashMap MFRRecs_fluid			= new HashMap();
	private String MFRYN					= "N";

	private String resp_id					= "";
	private String drug_priv_appln_yn		= "";
	private String take_home_medication		= "";
	private String perf_facility_id	=	"";
	private String atc_allergy_alert_level = "N";
	protected String print_mar_barcode_yn="N", print_mar_label_yn="N";//added for  added for MMS-QH-CRF-0080 [IN:038064]
	protected String iv_calc_infuse_by ="D";		
	public String getIVCalcInfuseBy(){
		return this.iv_calc_infuse_by ;
	}
	public void setIVCalcInfuseBy(String iv_calc_infuse_by){
		this.iv_calc_infuse_by = iv_calc_infuse_by;
	}
	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		super.setProperties(properties);
	}
	//Added for AAKH-CRF-0094  start
		protected String paramVolumeCalc ="Y";		
		public String getParamVolumeCalc() {
			return paramVolumeCalc;
		}
		public void setParamVolumeCalc(String paramVolumeCalc) {
			this.paramVolumeCalc = paramVolumeCalc;
		}
		
		//Added for AAKH-CRF-0094 end
	
	private String pre_alloc_appl_yn = ""; //Added for MMS-DM-CRF-0177
	
	//added for IN23838 --05/10/2010-- priya
	private String dosage_type = "";
	private String qty_value = "";
	private String qty_unit = "";
	private String print_ord_sht_rule_ind="";//Added for Bru-HIMS-CRF-393_1.0
	private String excludeADRAllergyAlert_yn = ""; // Added for HSA-SCF-0011 [IN:042444] start
	private HashMap hmOrdAuthReqDtl = new HashMap(); // Added for ML-MMOH-CRF-0343 [IN:057182]
	public String getExcludeADRAllergyAlert() {
		return excludeADRAllergyAlert_yn;
	}
	public void setExcludeADRAllergyAlert(String excludeADRAllergyAlert_yn) {
		this.excludeADRAllergyAlert_yn = excludeADRAllergyAlert_yn;
	}									// Added for HSA-SCF-0011 [IN:042444] end

	/*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/
	PrescriptionBean_1 presbeanobj = null;
	IVPiggyBackBean    backbeanobj=  null;
	
	public void setObject(PrescriptionBean_1 presbean) {
		presbeanobj = presbean;
	}
	public void setObject(IVPiggyBackBean ivbackbean) {
		backbeanobj = ivbackbean;
	}
	/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/	
	public void setPrintMarBarcode(String print_mar_barcode_yn) { //added for  added for MMS-QH-CRF-0080 [IN:038064]
		 this.print_mar_barcode_yn=print_mar_barcode_yn;		 
	}
	public String getPrintMarBarcode() {	 //added for  added for MMS-QH-CRF-0080 [IN:038064]
		return this.print_mar_barcode_yn;
	}
	public void setPrintMarLabel(String print_mar_label_yn) { //added for  added for MMS-QH-CRF-0080 [IN:038064]
		 this.print_mar_label_yn=print_mar_label_yn;		 
	}
	public String getPrintMarLabel() {	 //added for  added for MMS-QH-CRF-0080 [IN:038064]
		return this.print_mar_label_yn;
	}

	public void setATCAllergyLevel(String atc_allergy_alert_level){
		this.atc_allergy_alert_level = atc_allergy_alert_level;	
	}

	public String getATCAllergyLevel(){
		return this.atc_allergy_alert_level;
	}

	public void setDosage_type(String dosage_type){
		this.dosage_type = dosage_type;
	}

	public String getDosage_type(){
		return this.dosage_type;
	}

	public void setOrdAuthReqYN(String drug_code, String ord_auth_reqd_yn){//added for ML-MMOH-CRF-0343 [IN:057182]
		if(!this.hmOrdAuthReqDtl.containsKey(drug_code))
			this.hmOrdAuthReqDtl.put(drug_code, ord_auth_reqd_yn);
	}

	public HashMap getOrdAuthReqDtl(){//added for ML-MMOH-CRF-0343 [IN:057182]
		return this.hmOrdAuthReqDtl;
	}

	public String getOrdAuthReqYN(String drug_code){//added for ML-MMOH-CRF-0343 [IN:057182]
		return (String)this.hmOrdAuthReqDtl.get(drug_code);
	}

	public void clearOrdAuthReqYN(String drug_code){//added for ML-MMOH-CRF-0343 [IN:057182]
		hmOrdAuthReqDtl.clear();
	}

	public void setQty_value(String qty_value){
		this.qty_value = qty_value;
	}

	public String getQty_value(){
		return this.qty_value;
	}

	public void setQty_unit(String qty_unit){
		this.qty_unit = qty_unit;
	}

	public String getQty_unit()	{
		return this.qty_unit;
	}
/*==========================================================================================================*/

	public void setRespId(String resp_id) {
		this.resp_id	=	resp_id;
	}

	public void setDrugPrivApplnYN(String drug_priv_appln_yn) {
		this.drug_priv_appln_yn	=	drug_priv_appln_yn;
	}

	public void setAgeGroup(String age_group) {
		this.age_group	=	age_group;
	}

	public String getAgeGroup() {
		return this.age_group;
	}

	public void setTrnGroupRef(String trn_group_ref){
		this.trn_group_ref = trn_group_ref;
	}
	public String getTrnGroupRef(){
		return trn_group_ref;
	}
	public void setTokensGeneratedYN(String tokens_generated_yn){
		this.tokens_generated_yn = tokens_generated_yn;
	}
	public String getTokensGeneratedYN(){
		return tokens_generated_yn;
	}
	public void setMFRYN(String MfrYn){
		MFRYN = MfrYn;
	}
	public void setFldTradeCode(String 	trade_code){
		this.Fld_Trade_Code = trade_code;
	}

	public void setDrgTradeCodesArray(String Drg_Trade_Codes){
		this.Drg_Trade_Codes_Arr = Drg_Trade_Codes.split(",");
	}
		
	public String getFluidCompatibility(){
		return this.comptabile_fluid_yn;
	}

	public void setOrderSetValues(ArrayList orderSetValues){
		this.orderSetValues = orderSetValues;
	}

	public ArrayList getOrderSetValues(){
		return this.orderSetValues;
	}

	public void setAllExistingIVOrders(ArrayList exstngIVOrders){
		this.existing_iv_orders = exstngIVOrders;
	}

	public ArrayList getAllExistingIVOrders(){
		return this.existing_iv_orders;
	}

	public void setORDER_CATALOG_CODE(String ORDER_CATALOG_CODE){
		this.ORDER_CATALOG_CODE = ORDER_CATALOG_CODE;
	}

	public String getORDER_CATALOG_CODE(){
		return this.ORDER_CATALOG_CODE;
	}
	public void setCATALOG_DESC(String CATALOG_DESC){
		this.CATALOG_DESC = CATALOG_DESC;
	}

	public String getCATALOG_DESC(){
		return this.CATALOG_DESC;
	}
	
	public void setTakeHomeMedication(String take_home_medication){
		this.take_home_medication = take_home_medication;
	}
	public String getTakeHomeMedication(){
		return this.take_home_medication;
	}
	
	public void setSTART_DATE_TIME(String START_DATE_TIME){
		this.START_DATE_TIME = START_DATE_TIME;
	}

	public String getSTART_DATE_TIME(){
		return this.START_DATE_TIME;
	}
	
	public void setEND_DATE_TIME(String END_DATE_TIME){
		this.END_DATE_TIME = END_DATE_TIME;
	}

	public String getEND_DATE_TIME(){
		return this.END_DATE_TIME;
	}


	public void setDURN_VALUE(String DURN_VALUE){
		this.DURN_VALUE = DURN_VALUE;
	}

	public String getDURN_VALUE(){
		return this.DURN_VALUE;
	}
	public void setDURN_TYPE(String DURN_TYPE){
		this.DURN_TYPE = DURN_TYPE;
	}

	public String getDURN_TYPE(){
		return this.DURN_TYPE;
	}

   public void setOrder_type_flag(String order_type_flag){
		this.order_type_flag = order_type_flag;
	}


	public String getOrder_type_flag(){
		return this.order_type_flag;
	}

	public void setSTART_DATE(String START_DATE){
		this.START_DATE = START_DATE;
	}

	public String getSTART_DATE(){
		return this.START_DATE;
	}
	
	public void setEND_DATE(String END_DATE){
		this.END_DATE = END_DATE;
	}

	public String getEND_DATE(){
		return this.END_DATE;
	}


	public void setQTY_VALUE(String QTY_VALUE){
		this.QTY_VALUE = QTY_VALUE;
	}

	public String getQTY_VALUE(){
		return this.QTY_VALUE;
	}
	public void setQTY_UNIT(String QTY_UNIT){
		this.QTY_UNIT = QTY_UNIT;
	}

	public String getQTY_UNIT(){
		return this.QTY_UNIT;
	}
	public void setINFUSE_OVER(String INFUSE_OVER){
		this.INFUSE_OVER = INFUSE_OVER;
	}

	public String getINFUSE_OVER(){
		return this.INFUSE_OVER;

	}

	public void setDOSAGE(String DOSAGE){
		this.DOSAGE = DOSAGE;
	}

	public String getDOSAGE(){
		return this.DOSAGE;

	}
	public void setVOLUME(String VOLUME){
		this.VOLUME = VOLUME;

	}

	public String getVOLUME(){
		return this.VOLUME;
	}

	public void setINFUSION_RATE(String INFUSION_RATE){
		this.INFUSION_RATE = INFUSION_RATE;
	}

	public String getINFUSION_RATE(){
		return this.INFUSION_RATE;

	}
	public void setORDER_LINE_NUM(String ORDER_LINE_NUM){
		this.ORDER_LINE_NUM = ORDER_LINE_NUM;
	}

	public String getORDER_LINE_NUM(){
		return this.ORDER_LINE_NUM;

	}

	public void setIS_COPY_ORDER(boolean copyOrder){
		isCopyOrder = copyOrder;
	}

	//code added for setting IVType..on 11/5/2004

	public void setIVType(String ivtype){
		this.ivtype = ivtype;
	}

	public void setIVPrep(String ivprep){
		this.ivprep	=	ivprep;
	}

	public String getIVPrep(){
		return this.ivprep;
	}
	
	public void setIVPB(String ivpb){
		this.ivpb = ivpb;
	}
	
	public String getIVPB(){
		return this.ivpb;
	}

	public String getIVType(){
		return this.ivtype;
	}
	public IVPrescriptionBean() {
        try {
			int i=0;
			while (i < 12) {
				diagText.add("");
				i++;
			}
            doCommon();
        }catch(Exception e) {}
	}
	
	public String getOrMode(){
		return this.or_mode;
	}

	public void setCurrDrugDetails(HashMap curr_drug_dtls) {
		this.curr_drug_dtls	=	curr_drug_dtls;
	}

	public HashMap getCurrDrugDetails() {
		return this.curr_drug_dtls;
	}

	public void setOrMode(String or_mode){
		this.or_mode = or_mode;
	}

	public void setLocationType(String locn_type) {
		this.locn_type	=	locn_type;
	}

	public void setPriority(String order_priority) {
		this.order_priority	=	order_priority;
	}
	
	public void setBSA(String bsa) {
		this.bsa	=	bsa;
	}

	public String getBSA() {
		return this.bsa;
	}

	public void setBMI(String bmi) {
		this.bmi	=	bmi;
	}

	public String getBMI() {
		return this.bmi;
	}


	public void setAllergic(String allergic_yn) {
		this.allergic_yn	=	allergic_yn;
	}

	public void setFluidFlag(String flag) {
		this.fluid_flag=flag;
	}
	public String getFluidFlag() {
		 return fluid_flag;
	}
	
	public String getAllergic() {
		return this.allergic_yn;
	}

	public String getPriority() {
		return this.order_priority;
	}

	public String getLocationType() {
		return this.locn_type;
	}

	public void setLocationCode(String locn_code) {
		this.locn_code	=	locn_code;
	}

	public String getLocationCode() {
		return this.locn_code;
	}

	public void setPractionerID(String pract_id) {
		this.pract_id	=	pract_id;
	}

	public String getPractitionerID(){
		return this.pract_id;
	}

	public String getAmendOrderRemarks(){
		if(this.AmendOrderRemarks == null)
			this.AmendOrderRemarks="";
		return this.AmendOrderRemarks;
	}

	public void setAmendRemarks(String remarks)	{
		this.AmendOrderRemarks=remarks;
	}

	public void setDiagText(ArrayList diagText) {
		this.diagText = new ArrayList();
		this.diagText = diagText;
	}

	public ArrayList getDiagText() {
		return this.diagText;
	}

	public String getLicense() {
		return (String)(PhLicenceRights.getKey());
	}

	public ArrayList getamendDrugCodes() {
		return this.amendDrugCodes;
	}

	public ArrayList getpresDetails() {
		return this.presDetails;
	}

	public void setAmendAllergyRemarks(String srl_no,String remarks) {
		this.AmendAllergyRemarks.put(srl_no,remarks);
	}

	public void setAmendDoseRemarks(String srl_no,String remarks) {
		this.AmendDoseRemarks.put(srl_no,remarks);
	}

	public void setAmendRxRemarks(String srl_no,String remarks) {
		this.AmendRxRemarks.put(srl_no,remarks);
	}

	public HashMap getAmendAllergyRemarks() {
		return this.AmendAllergyRemarks;
	}

	public HashMap getAmendDoseRemarks() {
		return this.AmendDoseRemarks;
	}

	public HashMap getAmendRxRemarks() {
		return this.AmendRxRemarks;
	}

	public void setHeight(String height) {
		this.height	=	height;
	}

	public String getHeight() {
		return this.height;
	}
	
	public void setHeightUOM(String height_uom) {
		this.height_uom	=	height_uom;
	}

	public String getHeightUOM() {
		return this.height_uom;
	}
	
	public void setWeightUOM(String weight_uom) {
		this.weight_uom	=	weight_uom;
	}

	public String getWeightUOM() {
		return this.weight_uom;
	}

	public void setWeight(String weight) {
		this.weight	=	weight;
	}

	public String getWeight() {
		return this.weight; //modified for ML-MMOH-CRF-1408
	}

	private void doCommon() throws Exception {
	}

	
	public void setFREQ_CODE(String freq_code){
		this.freq_code = freq_code;
	}
	public String getFREQ_CODE(){
		return this.freq_code;
	}

	public void setAdminRate(String admin_rate){
		this.admin_rate = admin_rate;
	}
	public String getAdminRate(){
		return this.admin_rate;
	}
	public void setExternalDrugDataBaseInterface_yn(String ext_db_interface_yn){
		this.ext_db_interface_yn = ext_db_interface_yn;
	}
	public String getExternalDrugDataBaseInterface_yn(){
		return this.ext_db_interface_yn;

	}
    public void setDrug_DB_Product_id(String drug_db_product_id){
		this.drug_db_product_id = drug_db_product_id;
	}
	public String getDrug_DB_Product_id(){
		return this.drug_db_product_id;

	}
	public void setExternalDosageYN(String ext_dosage_chk_yn){
		this.ext_dosage_chk_yn = ext_dosage_chk_yn;
	}
	public String getExternalDosageYN(){
		return this.ext_dosage_chk_yn;
	}

	public void  setScheduleDates(HashMap schdMap){
		this.schdMap = schdMap;	
	}

	public HashMap getScheduleDates(){
		return this.schdMap;
	}
	public void setPrintOrdShtRuleInd(String print_ord_sht_rule_ind) {//Added for Bru-HIMS-CRF-393_1.0
		this.print_ord_sht_rule_ind=print_ord_sht_rule_ind;			
	}
	public String getPrintOrdShtRuleInd() {	
		return this.print_ord_sht_rule_ind;
	}
	
	//Added for MMS-DM-CRF-0177
	public String getPreAllocApplYN() {
		return pre_alloc_appl_yn;
	}
	public void setPreAllocApplYN(String pre_alloc_appl_yn) {
		this.pre_alloc_appl_yn = pre_alloc_appl_yn;
	}
	//Added for MMS-DM-CRF-0177
	
	/*IN066779 Starts*/
	public void setAmendReason1(String key, ArrayList values) {
		if(amend_reason1==null )
			this.amend_reason1 = new HashMap();
		this.amend_reason1.put(key,values);
	}
	
	public HashMap getAmendReason1() {
		return this.amend_reason1;
	}

	public ArrayList getAmendReason1(String key) {
		ArrayList reason	=	new ArrayList();

		if(amend_reason1!=null && amend_reason1.containsKey(key)) {
			reason	=	(ArrayList)amend_reason1.get(key);
		}
		return reason;
	}

	public void clearAmendReason1(String key) {
		 if(this.amend_reason1!=null && this.amend_reason1.containsKey(key)) {
			 this.amend_reason1.remove(key);
		 }
	}

	public void setCalledFromAmend(String called_from_amend) {
		 this.called_from_amend=called_from_amend;		 
	}
	public String getCalledFromAmend() {	
		return this.called_from_amend;
	}
	public void setAmendReasonTemp(String key, ArrayList values) { 	
		if(amend_reason_temp==null ){
			this.amend_reason_temp = new HashMap();
		}
		this.amend_reason_temp.put(key,values);
	}	
	public ArrayList getAmendReasonTemp(String key) {  
		ArrayList reason	=	new ArrayList();		
		if(amend_reason_temp!=null && amend_reason_temp.containsKey(key)) {
			reason	=	(ArrayList)amend_reason_temp.get(key);
		}		
		return reason;
	}	
	/*IN066779 Ends*/
	public void clear() {
		super.clear();
		order_date			= "";
		patient_class		= "";
		patient_id			= "";
		encounter_id		= "";
		drugCodes			= "";
		freqNature			= "";
		repeat_value		= "";
		int_value			= "";
		dosage_type = "";
		infRate_srlNo		= "";
		order_status		= "10";
		orderID				= "";
		packSize			= "";
		stock_uom			= "";
		srlNo				= 0;
		presc_mode			= 0;
		diagText			= new ArrayList(12);
		drugDetails			= new ArrayList();
		DrugRemarks			= new ArrayList();
		scheduleFrequency	= new HashMap();
		FluidDetails		= new HashMap();
		presDetails			= new ArrayList();
		amendDetails		= new ArrayList();
		amendDrugCodes		= new ArrayList();
		AllFluids			= new ArrayList();
		amendFluidDetails	= new HashMap();
		or_mode				= "";
		drug_stock_dtls		= new ArrayList();	
		height				= "";
		weight				= "";
		order_priority		= "";
		curr_drug_dtls		= new HashMap();
		admin_rate			= "";
		fluid_remarks		= "";
		orderSetValues		= new ArrayList();
		tokens_generated_yn = "";
		trn_group_ref		= "";
		MFRYN				= "N";
		MFRRecs				= new HashMap();
		MFRRecs_fluid		= new HashMap();
		Drg_Trade_Codes_Arr = null;
		AmendDoseRemarks = new HashMap();
		take_home_medication ="";//added for NMC-JD-CRF-0063
		opDischMedInd="";
		take_home_medication_op ="";
	}

	public void setFluidRemarks(String fluid_remarks) {
		this.fluid_remarks = fluid_remarks;
	}

	public String getFluidRemarks() {
		return this.fluid_remarks;
	}

	public void setDrugRemarks(ArrayList drugremarks) {
		this.DrugRemarks = drugremarks;
	}

	public ArrayList getDrugRemarks() {
		return this.DrugRemarks;
	}

	private void setPackSize(String packSize) {
		this.packSize = packSize;
	}

	
	private String getPackSize() {
		return this.packSize;
	}

	private void setStockUOM(String stock_uom) {
		this.stock_uom = stock_uom;
	}

	private String getStockUOM() {
		return this.stock_uom;
	}

	public int getPrescMode() {
		return this.presc_mode;
	}

	public void setPrescMode(int presc_mode) {
		this.presc_mode = presc_mode;
	}

	public void genDrugRemarks(ArrayList drugremarks) {
		this.DrugRemarks = drugremarks;
	}
	public void setOrderId1(String order_id){
		this.order_id1=order_id;
	}
	public String getOrderId1(){
		return this.order_id1;
	}
	public void setMFRRecs(HashMap MFRRecs){
		this.MFRRecs=MFRRecs;
	}
	public HashMap getMFRRecs(){
		return this.MFRRecs;
	}

	public void setMFRRecs_fluids(HashMap MFRRecs, String fluidCode){
		this.MFRRecs_fluid.put(fluidCode,MFRRecs);
	}
	public HashMap getMFRRecs_fluids(String fluidCode){
		if(MFRRecs_fluid != null && MFRRecs_fluid.size()>0){
			if(fluidCode.equals(""))
				return this.MFRRecs_fluid;
			else
				return (HashMap)MFRRecs_fluid.get(fluidCode);
		}else
			return MFRRecs_fluid;
	}
	
	public ArrayList getMFRRecsView(String order_id,String locale){
		
		String SQL_PH_MFR_SELECT = "select TOT_STRENGTH, TOT_STRENGTH_UOM, INFUSE_OVER, INFUSE_OVER_UNIT, INFUSION_RATE, INFUSION_VOL_STR_UNIT ,am_get_desc.am_uom(INFUSION_VOL_STR_UNIT, ? , 2 ) INFUSION_VOL_STR_UNIT_DESC,INFUSION_PER_UNIT, ADMIN_RATE_DETAIL, TO_CHAR (SCH_START_DATE_TIME, 'DD/MM/YYYY HH24:MI') START_DATE_TIME, TO_CHAR (SCH_END_DATE_TIME, 'DD/MM/YYYY HH24:MI') END_DATE_TIME, GAP_DURATION_IN_HRS from OR_ORDER_LINE_PH_MFR where  ORDER_ID=?";
		//Add locale and   am_get_desc.am_uom(INFUSION_VOL_STR_UNIT, ? , 2 ) INFUSION_VOL_STR_UNIT_DESC for SKR-SCF-215.1

		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList MFRRecord = new ArrayList();
		HashMap MFRRecDetail = null;
		try{
			connection = getConnection() ;

			pstmt				= connection.prepareStatement(SQL_PH_MFR_SELECT) ;

			// Changed for SKR-sCF-215.1
			pstmt.setString(1,locale);	
			pstmt.setString(2,order_id);

			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				MFRRecDetail = new HashMap();
				MFRRecDetail.put("TOT_STRENGTH",resultSet.getString("TOT_STRENGTH"));
				MFRRecDetail.put("TOT_STRENGTH_UOM",resultSet.getString("TOT_STRENGTH_UOM"));
				MFRRecDetail.put("INFUSE_OVER",resultSet.getString("INFUSE_OVER"));
				MFRRecDetail.put("INFUSE_OVER_UNIT",resultSet.getString("INFUSE_OVER_UNIT"));
				MFRRecDetail.put("INFUSION_RATE",resultSet.getString("INFUSION_RATE"));
				MFRRecDetail.put("INFUSION_VOL_STR_UNIT",resultSet.getString("INFUSION_VOL_STR_UNIT"));
				MFRRecDetail.put("INFUSION_PER_UNIT",resultSet.getString("INFUSION_PER_UNIT"));
				MFRRecDetail.put("ADMIN_RATE_DETAIL",resultSet.getString("ADMIN_RATE_DETAIL"));
				MFRRecDetail.put("START_DATE_TIME",resultSet.getString("START_DATE_TIME"));
				MFRRecDetail.put("END_DATE_TIME",resultSet.getString("END_DATE_TIME"));
				MFRRecDetail.put("GAP_DURATION_IN_HRS",resultSet.getString("GAP_DURATION_IN_HRS"));
				MFRRecDetail.put("INFUSION_VOL_STR_UNIT_DESC",resultSet.getString("INFUSION_VOL_STR_UNIT_DESC")) ;//Add INFUSION_VOL_STR_UNIT_DESC for SKR-SCF-215.1

				MFRRecord.add(MFRRecDetail);
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
				es.printStackTrace() ;
			}
		}
		return MFRRecord;
	}

	public void setAll(Hashtable recordSet) {
		AllFluids = new ArrayList();
		if(recordSet.containsKey("mode")){
			setMode((String)recordSet.get("mode")) ;
		}
		if(recordSet.containsKey("FLUID_CODE1")){
			if(!((String)recordSet.get("FLUID_CODE1")).equals("") && ((String)recordSet.get("SELECT1")).equals("Y")) {
				setFluidDetails ((String)recordSet.get("FLUID_CODE1"),"","","","");	// CRF-0062 NEWLY ADDED
				AllFluids.add(getFluidDetails());
			}
		}
		if(recordSet.containsKey("FLUID_CODE2")){
			if(!((String)recordSet.get("FLUID_CODE2")).equals("")&& ((String)recordSet.get("SELECT2")).equals("Y")) {
				setFluidDetails ((String)recordSet.get("FLUID_CODE2"),"","","","");	// CRF-0062 NEWLY ADDED
				AllFluids.add(getFluidDetails());
			}
		}
		if(recordSet.containsKey("FLUID_CODE3")){
			if(!((String)recordSet.get("FLUID_CODE3")).equals("")&& ((String)recordSet.get("SELECT3")).equals("Y")) {
				setFluidDetails ((String)recordSet.get("FLUID_CODE3"),"","","","");	// CRF-0062 NEWLY ADDED
				AllFluids.add(getFluidDetails());
			}
		}
		if(recordSet.containsKey("FLUID_CODE4")){
			if(!((String)recordSet.get("FLUID_CODE4")).equals("")&& ((String)recordSet.get("SELECT4")).equals("Y")) {
				setFluidDetails ((String)recordSet.get("FLUID_CODE4"),"","","","");	// CRF-0062 NEWLY ADDED
				AllFluids.add(getFluidDetails());
			}
		}
		if(recordSet.containsKey("FLUID_CODE5")){
			if(!((String)recordSet.get("FLUID_CODE5")).equals("")&& ((String)recordSet.get("SELECT5")).equals("Y")) {
				setFluidDetails ((String)recordSet.get("FLUID_CODE5"),"","","","");	// CRF-0062 NEWLY ADDED
				AllFluids.add(getFluidDetails());
			}
		}
		if(recordSet.containsKey("FLUID_CODE6")){
			if(!((String)recordSet.get("FLUID_CODE6")).equals("")&& ((String)recordSet.get("SELECT6")).equals("Y")) {
				setFluidDetails ((String)recordSet.get("FLUID_CODE6"),"","","","");	// CRF-0062 NEWLY ADDED
				AllFluids.add(getFluidDetails());
			}
		}
		
		if(recordSet.containsKey("ORDER_CATALOG_CODE"))
			setORDER_CATALOG_CODE((String)recordSet.get("ORDER_CATALOG_CODE")) ;

		if(recordSet.containsKey("CATALOG_DESC"))
			setCATALOG_DESC((String)recordSet.get("CATALOG_DESC")) ;

		if(recordSet.containsKey("START_DATE_TIME"))
			setSTART_DATE_TIME((String)recordSet.get("START_DATE_TIME")) ;

		if(recordSet.containsKey("END_DATE_TIME"))
			setEND_DATE_TIME((String)recordSet.get("END_DATE_TIME")) ;

		if(recordSet.containsKey("START_DATE"))
			setSTART_DATE((String)recordSet.get("START_DATE")) ;

		if(recordSet.containsKey("END_DATE"))
			setEND_DATE((String)recordSet.get("END_DATE")) ;

		if(recordSet.containsKey("DURN_VALUE"))
			setDURN_VALUE((String)recordSet.get("DURN_VALUE")) ;

		if(recordSet.containsKey("DURN_TYPE"))
			setDURN_TYPE((String)recordSet.get("DURN_TYPE")) ;

		if(recordSet.containsKey("QTY_VALUE"))
			setQTY_VALUE((String)recordSet.get("QTY_VALUE")) ;

		if(recordSet.containsKey("QTY_UNIT"))
			setQTY_UNIT((String)recordSet.get("QTY_UNIT")) ;

		if(recordSet.containsKey("INFUSE_OVER"))
			setINFUSE_OVER((String)recordSet.get("INFUSE_OVER")) ;

		if(recordSet.containsKey("INFUSION_RATE"))
			setINFUSION_RATE((String)recordSet.get("INFUSION_RATE")) ;

		if(recordSet.containsKey("ORDER_LINE_NUM"))
			setORDER_LINE_NUM((String)recordSet.get("ORDER_LINE_NUM")) ;
	}

	public void setFrequencyNature(String freqNature) {
		this.freqNature = freqNature;
	}

	public void setRepeatValue(String repeat_value) {
		this.repeat_value = repeat_value;
	}

	public void setIntervalValue(String int_value) {
		this.int_value = int_value;
	}

	public void setOrderStatus(String order_status) {
		this.order_status = order_status;
	}

	public void setPatId(String patient_id) {
		this.patient_id = patient_id;
	}

	public void setEncId(String encounter_id) {
		this.encounter_id = encounter_id;
	}

	public void setPatientClass(String patient_class) {
		this.patient_class = patient_class;
	}

	public ArrayList getDrugStockDtls() {
		return this.drug_stock_dtls;
	}
    
	public void setDrugCodes(String drugCodes) {
		this.drugCodes = this.drugCodes +  drugCodes;
	}

	public void setAllFluids(ArrayList Fluids){
		this.AllFluids = Fluids;
	}

	public ArrayList getAllFluids(){
		return this.AllFluids;
	}
	
	public void removeDrugCode(String drug_code) {
	
		String avlDrugCodes	= getDrugCodes();
		StringTokenizer st = new StringTokenizer(avlDrugCodes, ",");
		String newDrugCodes = "";
		while (st.hasMoreTokens()) {
			String thisToken = st.nextToken();
			if (!(thisToken.equals(drug_code))) {
				newDrugCodes = newDrugCodes + thisToken + ",";
			}
		}
		this.drugCodes = "";
		setDrugCodes(newDrugCodes);
	}

	public void setInfRate(String srlNo, String infRate) {
		if (infRate.equals(""))
			this.infRate_srlNo = "";
		else
			this.infRate_srlNo = srlNo + ":" + infRate;
	}

	public ArrayList getDrugDetails() {
		return this.drugDetails;
	}

	public String getPatId() {
		return this.patient_id;
	}

	public String getEncId() {
		return this.encounter_id;
	}

	public String getOrderStatus() {
		return this.order_status;
	}

	public void setOrderDate(String order_date) {		
		this.order_date = order_date;
	}

	public String getOrderDate() {
		return this.order_date;
	}

	public String getPatientClass() {
		return this.patient_class;
	}

	public String getDrugCodes() {
		return this.drugCodes;
	}

	public String getFrequencyNature() {
		return this.freqNature;
	}

	public String getRepeatValue() {
		return this.repeat_value;
	}

	public String getIntervalValue() {
		return this.int_value;
	}

	public String getInfRate(String srlNo, int mode) {
		String retVal = "";
		if (mode == 1) {
			String temp = this.infRate_srlNo;
			if (!temp.equals("")) {
				temp = temp.substring(0, temp.indexOf(':'));
				retVal = temp;
			}
		}
		else if (mode == 2) {
			String temp = this.infRate_srlNo;
			if (!temp.equals("")) {
				temp = temp.substring(0, temp.indexOf(':'));
				if (temp.equals(srlNo)) {
					temp = this.infRate_srlNo;
					retVal = temp.substring(temp.indexOf(':')+1, temp.length());
				}
			}
		}
		else if (mode == 3) {
			retVal = this.infRate_srlNo;
		}
		return retVal;
	}

	private String checkNullResult(String inputString, String defaultValue) {
		return (inputString==null) ? defaultValue : inputString;
	}

	public void removeDrugFromList(int srlNo, String drug_code) {
		removeDrugCode(drug_code);
		ArrayList temp = getDrugDetails();

		temp.remove(srlNo);
		temp.add(srlNo, new HashMap());
		this.drugDetails = temp;
		if(!this.FluidDetails.equals("")){this.FluidDetails = new HashMap();}
	}

	public boolean doPrinting(Object request,Object response, String locn_code, String patient_class, String prescriptionPrint, String NarcoticPrint, String MARLabelPrint,String patient_id) {//code 'String patient_id' added for SKR-SCF-0915[IN046734]
		String order_id				= getOrderID();
		String facility_id			= getLoginFacilityId();
		String iv_prep				= getIVPrep();
		String to_oder_id			= "";
		String order_id1			= getOrderId1();
		ArrayList narcotic_nos      = new ArrayList();

		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;

		if(order_id1 == ""){
			to_oder_id=order_id;
		}
		if(order_id != order_id1 && order_id1 != ""){
			to_oder_id=order_id;
			order_id=order_id1;
		}
		else if(order_id.equals(order_id1)){
			to_oder_id=order_id;
			order_id=order_id1;
		}
		this.order_id1="";
		if(prescriptionPrint.equals("Y")){
			ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports();
			ecis.utils.OnlineReport report2			= new ecis.utils.OnlineReport(facility_id, "PH", "PHPRDPRESIVCONT");
			report2.addParameter("p_facility_id", facility_id);
			report2.addParameter("p_iv_prep_yn", iv_prep);
			report2.addParameter("p_module_id", "PH");
			report2.addParameter("p_report_id","PHPRDPRESIVCONT");
			report2.addParameter("p_order_id", order_id);
			report2.addParameter("p_order_id1",to_oder_id);
			report2.addParameter("p_locncode", locn_code);
			report2.addParameter("p_patclass", patient_class);
			report2.addParameter("p_user_name", login_by_id);
			report2.addParameter("p_language_id", getLanguageId());
			report2.addParameter("p_patient_id", patient_id);//code added for SKR-SCF-0915[IN046734]
			onlineReports.add(report2);
			//String ReportOutput = 
			onlineReports.execute((HttpServletRequest)request, (HttpServletResponse)response);
		}
		 if((NarcoticPrint.toUpperCase()).equals("Y")){
			try{
				connection = getConnection() ;
				pstmt				= connection.prepareStatement("select NARCO_NO from or_order_line_ph where order_id between ? and ? and NARCO_NO is not null") ;
				pstmt.setString(1,order_id);
				pstmt.setString(2,to_oder_id);
				resultSet			= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					narcotic_nos.add(resultSet.getString("NARCO_NO"));
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
					es.printStackTrace() ;
				}
			}
		}

		if((NarcoticPrint.toUpperCase()).equals("Y")){
			/*ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
			ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHRNARFORM") ;
			report2.addParameter("p_report_id", "PHRNARFORM") ;
			report2.addParameter("P_FR_ORDER_ID", order_id) ;
			report2.addParameter("P_TO_ORDER_ID", to_oder_id) ;
			report2.addParameter("p_language_id", getLanguageId()) ;
			onlineReports.add( report2) ;
			onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
			*/
			for(int i=0;i<narcotic_nos.size();i++){
				ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
				ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHRNARFORM") ;
				report2.addParameter("p_report_id", "PHRNARFORM") ;
				report2.addParameter("P_LANGUAGE_ID", getLanguageId()) ;
				report2.addParameter("P_FACILITY_ID", facility_id) ;
				report2.addParameter("P_NARCOTIC_NO", (String)narcotic_nos.get(i)) ;
				report2.addParameter("P_REPRINT", "N") ;
				report2.addParameter("p_patient_id", patient_id);//code added for SKR-SCF-0915[IN046734]
				onlineReports.add( report2) ;
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
			}
		}
		if(MARLabelPrint.equals("Y") && (iv_prep.equals("1") || iv_prep.equals("3") || iv_prep.equals("5"))){ //if block Added for MMS-QH-CRF-0080 [IN:038064]
			ArrayList MAROrders = new ArrayList();
			String ord_id="";
			try{
				connection = getConnection() ;
				pstmt				= connection.prepareStatement("SELECT ORDER_ID FROM OR_ORDER_LINE_PH WHERE ORDER_ID BETWEEN ? AND ? AND BUILD_MAR_YN='Y' ") ;
				pstmt.setString(1,order_id);
				pstmt.setString(2,to_oder_id);
				resultSet			= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					ord_id = checkForNull(resultSet.getString("ORDER_ID"));
					if( !ord_id.equals("") && !MAROrders.contains(ord_id))
						MAROrders.add(ord_id);
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
					es.printStackTrace() ;
				}
			}
			String report_id="";
			ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;  
			for(int i=0;i<MAROrders.size();i++){
				if(iv_prep.equals("1"))
					report_id="PHPRMARWALBL" ;
				else if(iv_prep.equals("3"))
					report_id="PHPRMARINTLBL" ;
				else if(iv_prep.equals("5"))
					report_id= "PHPRMARWOALBL" ;
				ecis.utils.OnlineReport MARreport= new ecis.utils.OnlineReport( login_facility_id, "PH", report_id) ;
				MARreport.addParameter("p_report_id", report_id) ;
				MARreport.addParameter("P_LANGUAGE_ID", getLanguageId()) ;
				MARreport.addParameter("P_FACILITY_ID", login_facility_id) ;
				MARreport.addParameter("P_ORDER_ID", (String)MAROrders.get(i)) ;
				MARreport.addParameter("p_patient_id", patient_id);//code added for SKR-SCF-0915[IN046734]
				onlineReports.add( MARreport) ;
			}
			onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response ); 
		}		
		return true;
	}

	public String getOrderID() {
		return this.orderID;
	}
	
	public void setOrderID(String order_id){
		this.orderID = order_id;
	}

	public String getBuildMAR_yn() {
		return this.buildMAR_yn;
	}
	
	public void setBuildMAR_yn(String buildMAR_yn){
		this.buildMAR_yn = buildMAR_yn;
	}

	public void setOrderID() {

		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT37"));
			pstmt.setString(1, "PH");
			pstmt.setString(2, getPatientClass());
			pstmt.setString(3, login_facility_id); //thrid parameter for facility added for IN[032925]
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				this.orderID = resultSet.getString("order_id");
			}
		}
		catch(Exception e) {
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

	public ArrayList getFrequency(){
		Connection connection	= null;
        PreparedStatement psmt	= null;
        ResultSet resultSet		= null;
		ArrayList frequency		= new ArrayList();
		try {
			connection	= getConnection();
			psmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DEFFREQFORIV_SELECT")); // Added for Bru-HIMS-CRF-384[IN:041642] start
			psmt.setString(1, getLanguageId());
			psmt.setString(2, login_facility_id);
			resultSet	= psmt.executeQuery();
			if(resultSet.next()) {
				frequency.add(resultSet.getString("FREQ_CODE"));
				frequency.add(resultSet.getString("FREQ_DESC"));
			}
			else{ // Added for Bru-HIMS-CRF-384[IN:041642] end
				psmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT14"));
				psmt.setString(1, getLanguageId());
				resultSet	= psmt.executeQuery();
				if(resultSet.next()) {
					frequency.add(resultSet.getString("FREQ_CODE"));
					frequency.add(resultSet.getString("FREQ_DESC"));
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(psmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return frequency;
	}

	public ArrayList getEqvlUOM(String uom_code, String base_uom) {
		Connection connection	= null;
        PreparedStatement pstmt = null;
        ResultSet resultSet		= null;
		ArrayList eqvlUOM		= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT4"));
			pstmt.setString(1, uom_code.trim());
			pstmt.setString(2, base_uom.trim());
			pstmt.setString(3, base_uom.trim());
			pstmt.setString(4, uom_code.trim());
			pstmt.setString(5, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				eqvlUOM.add(resultSet.getString("EQVL_UOM_CODE"));
				eqvlUOM.add(resultSet.getString("SHORT_DESC"));
				eqvlUOM.add(resultSet.getString("EQVL_VALUE"));
			}
		}
		catch (Exception e) {
			eqvlUOM.add(e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return eqvlUOM;
	}

	public boolean getScheduledFreqYN(String freq_code) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		boolean sched_yn		= false;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT7"));
			pstmt.setString(1, freq_code);
			resultSet	= pstmt.executeQuery();

			if (resultSet.next()) {
				setRepeatValue(checkNullResult(resultSet.getString("REPEAT_VALUE"), "1"));
				setIntervalValue(checkNullResult(resultSet.getString("INTERVAL_VALUE"), "1"));
				setFrequencyNature(resultSet.getString("FREQ_NATURE"));
				if (resultSet.getString("SCHEDULED_YN").equals("Y"))
					sched_yn = true;
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
			catch(Exception es) {}
		}
		return sched_yn;
	}

	public ArrayList populateDurnValues() {
		Connection connection	= null;
        CallableStatement cstmt	= null;
        ResultSet resultSet		= null;
		ArrayList durnList		= new ArrayList();

		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call PH_IVFREQ(?,?,?,?)}");
			cstmt.setString(1, getFrequencyNature());
		
			cstmt.setString(2, getIntervalValue());
			
			cstmt.setString(3, getPatientClass());
			
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.execute();
			String durn_list	= cstmt.getString(4);
			
			if(durn_list==null)
				durn_list	=	"";
			StringTokenizer st	= new StringTokenizer(durn_list, "|");
			while(st.hasMoreTokens()) {
				durnList.add(st.nextToken());
			}
		}
		catch (Exception e) {
			durnList.add(e.toString());
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return durnList;
	}

	public String getLocationDesc(String patient_class,String locn_code) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String locn_desc		=	"";

		try {
			connection	= getConnection();

			if(patient_class.equals("IP")||patient_class.equals("DC"))
				pstmt	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT41"));
			else if (patient_class.equals("OP")||patient_class.equals("EM"))
				pstmt	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT42"));

			pstmt.setString(1, getLoginFacilityId());
			pstmt.setString(2, locn_code);
			pstmt.setString(3, getLanguageId());
			resultSet	= pstmt.executeQuery();
			if (resultSet.next()) {
				locn_desc = checkNullResult(resultSet.getString("LONG_DESC"), "-");
			}
		}
		catch(Exception e) {
			locn_desc = e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return locn_desc;
	}

	public ArrayList getPatientDetails(String patient_id) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		ArrayList pat_details	= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT43"));
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patient_id);
			resultSet	= pstmt.executeQuery();
			if (resultSet.next()) {
				pat_details.add(checkNullResult(resultSet.getString("PATIENT_NAME"), "-"));
				pat_details.add(checkNullResult(resultSet.getString("SEX"), "-"));
				pat_details.add(checkNullResult(resultSet.getString("AGE"), "-"));
			}
			else {
				pat_details.add("-");
				pat_details.add("-");
				pat_details.add("-");
			}
		}
		catch(Exception e) {
			pat_details.add(e.toString());
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return pat_details;
	}
	public HashMap getPatientDetails(String patient_id,String drug_code)	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String	patient_name	=	"";
		String	sex				=	"";
		String	age				=	"";
		HashMap	 pat_details	=	new HashMap();
		String age_in_mints="";//added for ml-mmoh-crf-0978

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT43A") ) ;
			pstmt.setString(1,patient_id);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				patient_name	=	resultSet.getString("PATIENT_NAME");
				sex				=	resultSet.getString("SEX");
				age				=	resultSet.getString("AGE");
				age_in_mints=resultSet.getString("AGE_IN_MINTS");// added for ml-mmoh-crf-0978
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}catch(Exception es){
				es.printStackTrace() ;
			}
			pat_details.put("patient_name",patient_name);
			pat_details.put("sex",sex);
			pat_details.put("age",age);
			pat_details.put("age_in_mints",age_in_mints);// added for ml-mmoh-crf-0978
			

			age	=	age.trim();
			//sex	=	sex.substring(0,1);
			
			pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80A") ) ;
			pstmt.setString(1,sex);
			pstmt.setString(2,age_in_mints);// added for ml-mmoh-crf-0978
			pstmt.setString(3,drug_code);
			resultSet	= pstmt.executeQuery();
			
			while(resultSet!=null && resultSet.next() ) {
				age_group	=	resultSet.getString("AGE_GROUP_CODE");
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}catch(Exception es){
				es.printStackTrace() ;
			}

			setAgeGroup(age_group);

		}catch(Exception e){
				pat_details.put("error",e.toString());
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
		return pat_details;
	}
	public ArrayList populateFrequencyValues() {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList frequency		= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT5"));
			pstmt.setString(1, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				frequency.add(resultSet.getString("FREQ_CODE"));
				frequency.add(resultSet.getString("FREQ_DESC"));
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
			catch(Exception es) {}
		}
		return frequency;
	}

	public ArrayList loadContFreq() {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList frequency		= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT5A"));
			pstmt.setString(1, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				frequency.add(resultSet.getString("FREQ_CODE"));
				frequency.add(resultSet.getString("FREQ_DESC"));
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
			catch(Exception es) {}
		}
		return frequency;

	}

	public String getOrderType(String drug_code) {
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		String order_catalog_code	= "";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT6"));
			pstmt.setString(1, drug_code);
			resultSet	= pstmt.executeQuery();

			if (resultSet.next()) {
				order_catalog_code = checkNullResult(resultSet.getString("ORDER_TYPE_CODE"), "");
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
			catch(Exception es) {}
		}
		return order_catalog_code;
	}

	public String populateEndDate(String start_date, String durn_value, String durn_type) {
		Connection connection		= null;
        CallableStatement cstmt		= null;
        ResultSet resultSet			= null;
		String end_date				= "";
		if(getOrder_type_flag().equals("Existing")){
            setSTART_DATE_TIME(start_date);
         }
		try {
			if(!durn_value.equals("") && !start_date.equals("") && !durn_type.equals("")){
				connection	= getConnection();
				cstmt=connection.prepareCall("{call ph_iv_ret_end_date(?,?,?,?)}");
				cstmt.setString(1, start_date);
				cstmt.setFloat(2, Float.parseFloat(durn_value));
				cstmt.setString(3, durn_type);
				cstmt.registerOutParameter(4, Types.VARCHAR);
				cstmt.execute();
				end_date	= cstmt.getString(4);
			}
			else{
				end_date = "";
				//System.err.println("populateEndDate() - One of these values are blank start_date, durn_value, durn_type => "+ start_date+" , "+durn_value+" , "+durn_type);
			}
		}
		catch (Exception e) {
			end_date = e.toString();
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return end_date;
	}

	public String getFormatId(String order_category,String order_type_code,String order_catalog_code) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String format_id		=	"";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT46"));
			pstmt.setString(1, order_category);
			pstmt.setString(2, order_type_code);
			pstmt.setString(3, order_catalog_code);
			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				format_id	=	resultSet.getString("FORMAT_ID");
			}
		}
		catch(Exception e) {
			format_id = e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return format_id;
	}

	public ArrayList getPresValues(String form_code,String route_code,String order_catalog_code) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String remarks_code		= "";
		String remarks_desc		= "";
		ArrayList pres_values	= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT48"));
			pstmt.setString(1,order_catalog_code);
			pstmt.setString(2,form_code);
			pstmt.setString(3,route_code);
			pstmt.setString(4,getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				remarks_code = resultSet.getString("REMARK_CODE");
				remarks_desc = resultSet.getString("REMARK_DESC");

				pres_values.add(remarks_code);
				pres_values.add(remarks_desc);
			}

			if(pres_values.size() == 0)	{
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT49"));
				pstmt.setString(1, getLanguageId());
				resultSet	= pstmt.executeQuery();

				while (resultSet.next()) {
					remarks_code = resultSet.getString("REMARK_CODE");
					remarks_desc = resultSet.getString("REMARK_DESC");
					pres_values.add(remarks_code);
					pres_values.add(remarks_desc);
				}
			}
		}
		catch(Exception e) {
			pres_values.add(e.toString());
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return pres_values;
	}
public HashMap freqValidate(String freq_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String freq_value			= "";
		String freq_nature			= "";
		String interval_value		= "";
		String interval_durn_type	= "";
		String repeat_value			= "";
		String schedule_yn			= "";
		String repeat_durn_type		= "";
		HashMap freqValues			= new HashMap();
		try{
			connection					= getConnection() ;

		//	sql_query					= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT6A");
			sql_query = "SELECT FREQ_CODE,FREQ_DESC,SCHEDULED_YN,FREQ_NATURE,REPEAT_VALUE, REPEAT_DURN_TYPE, INTERVAL_VALUE,INTERVAL_DURN_TYPE,DECODE(FREQ_NATURE,'F',(CASE WHEN INTERVAL_DURN_TYPE='H' AND REPEAT_DURN_TYPE ='H' AND REPEAT_VALUE =1 AND INTERVAL_VALUE <>0 THEN (24/INTERVAL_VALUE) WHEN INTERVAL_DURN_TYPE='H' AND REPEAT_DURN_TYPE ='H' AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (REPEAT_VALUE/INTERVAL_VALUE) WHEN INTERVAL_DURN_TYPE='M' AND REPEAT_DURN_TYPE ='M' AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (REPEAT_VALUE/INTERVAL_VALUE) WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE <>0 AND INTERVAL_VALUE =1 THEN REPEAT_VALUE WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE =1 AND INTERVAL_VALUE <>0 THEN (0) WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (0)  END),'I',(CASE WHEN INTERVAL_DURN_TYPE='H' AND REPEAT_DURN_TYPE ='H' AND REPEAT_VALUE =1 AND INTERVAL_VALUE <>0 THEN ceil(repeat_value / interval_value) WHEN INTERVAL_DURN_TYPE='H' AND REPEAT_DURN_TYPE ='H' AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (REPEAT_VALUE/INTERVAL_VALUE) WHEN INTERVAL_DURN_TYPE='M' AND REPEAT_DURN_TYPE ='M' AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (REPEAT_VALUE/INTERVAL_VALUE) WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE <>0 AND INTERVAL_VALUE =1 THEN REPEAT_VALUE WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE =1 AND INTERVAL_VALUE <>0 THEN (0) WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (0)  END)) FREQ_VALUE FROM AM_FREQUENCY_LANG_VW AM_FREQUENCY WHERE FREQ_CODE =? AND LANGUAGE_ID = ? GROUP BY FREQ_CODE,FREQ_DESC,SCHEDULED_YN, FREQ_NATURE,REPEAT_VALUE, REPEAT_DURN_TYPE, INTERVAL_VALUE, INTERVAL_DURN_TYPE";
			pstmt						= null;
			resultSet					= null;
			pstmt						= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,freq_code);
			pstmt.setString(2, getLanguageId());
			resultSet					= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next())
				{
					repeat_value		= resultSet.getString("REPEAT_VALUE");
					interval_value		= resultSet.getString("INTERVAL_VALUE");
					interval_durn_type	= resultSet.getString("INTERVAL_DURN_TYPE");
					freq_nature			= resultSet.getString("FREQ_NATURE");
					freq_value			= resultSet.getString("FREQ_VALUE");
					schedule_yn			= resultSet.getString("SCHEDULED_YN");
					repeat_durn_type	= resultSet.getString("REPEAT_DURN_TYPE");

				}
	
			freqValues.put("freq_nature",freq_nature);
			freqValues.put("interval_value",interval_value);
			freqValues.put("interval_durn_type",interval_durn_type);
			freqValues.put("repeat_value",repeat_value);
			freqValues.put("schedule_yn",schedule_yn);
			freqValues.put("repeat_durn_type",repeat_durn_type);

			if(freq_nature.equals("O")){
				freqValues.put("freq_value","1");
				freqValues.put("repeat_durn_type","D");
				freqValues.put("interval_value","1");
				freqValues.put("repeat_value","1");
			}
			else{
				freqValues.put("freq_value",freq_value);
			}

	    }
		catch ( Exception e ) {
				freqValues.put("error",e);
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

		return freqValues;

  }

	/*public String populateEndDate(String freq_nature, String start_date, String durn_value, String repeat_durn_type) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
        ResultSet resultSet		= null;
		String end_date			= "";

		try {
			connection = getConnection();
			if (freq_nature.equals("O")) {
				connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7A"));
			} else {
				connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7AA"));
			}

			pstmt.setString(1,repeat_durn_type);
			pstmt.setString(2,start_date);
			pstmt.setString(3,durn_value);
			pstmt.setString(4,repeat_durn_type);
			pstmt.setString(5,start_date);
			pstmt.setString(6,durn_value);
			pstmt.setString(7,repeat_durn_type);
			pstmt.setString(8,start_date);
			pstmt.setString(9,durn_value);
			resultSet = pstmt.executeQuery();

			if(resultSet.next()) {
				end_date=resultSet.getString("END_DATE");
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
		return end_date;
	}*/

	public String populateEndDate(String freq_nature,String start_date,String durn_value,String repeat_durn_type){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String end_date				="";
		try{
			connection = getConnection() ;
//			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7AA");
			sql_query        = "SELECT TO_CHAR((CASE WHEN 'D' = ? THEN (TO_DATE(?, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?) WHEN 'W' = ? THEN (TO_DATE(?, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)*7 WHEN 'L' = ? THEN (TO_DATE(?, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)*30 WHEN 'Y' = ? THEN (TO_DATE(?, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)*365 WHEN 'H' = ? THEN (TO_DATE(?, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)/24  WHEN 'M' = ? THEN (TO_DATE(?, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)/(24*60)END), 'DD/MM/RRRR HH24:MI') END_DATE FROM DUAL";

			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,repeat_durn_type);
			pstmt.setString(2,start_date);
			pstmt.setString(3,durn_value);
			pstmt.setString(4,repeat_durn_type);
			pstmt.setString(5,start_date);
			pstmt.setString(6,durn_value);
			pstmt.setString(7,repeat_durn_type);
			pstmt.setString(8,start_date);
			pstmt.setString(9,durn_value);
			pstmt.setString(10,repeat_durn_type);
			pstmt.setString(11,start_date);
			pstmt.setString(12,durn_value);
			pstmt.setString(13,repeat_durn_type);
			pstmt.setString(14,start_date);
			pstmt.setString(15,durn_value);
			pstmt.setString(16,repeat_durn_type);
			pstmt.setString(17,start_date);
			pstmt.setString(18,durn_value);


			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				end_date=resultSet.getString("END_DATE");
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
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
				es.printStackTrace() ;
			}
		}
		return end_date;
	}

	public void amendDrugs(int srlNo, String drug_code, Hashtable amendDetails) {
		try{
			ArrayList temp  = getDrugDetails();
			HashMap tempMap = (HashMap)temp.get(srlNo);

			if (!(amendDetails.get("INFUSION_VALUE").equals("")) && getInfRate(Integer.toString(srlNo), 3).equals(""))
				setInfRate(Integer.toString(srlNo), (String)amendDetails.get("INFUSION_VALUE"));
			else if (amendDetails.get("INFUSION_VALUE").toString().equals("") && getInfRate(Integer.toString(srlNo), 1).equals(Integer.toString(srlNo))) 
				setInfRate(Integer.toString(srlNo), (String)amendDetails.get("INFUSION_VALUE"));

			// code changed for checking null....
			String dup_drug_desc="";
			if(amendDetails.containsKey("DUP_DRUG_DESC"))
				dup_drug_desc	= amendDetails.get("DUP_DRUG_DESC").toString();
			String allergy_desc="";
			if(amendDetails.containsKey("ALLERGY_DESC"))
				allergy_desc		= amendDetails.get("ALLERGY_DESC").toString();
			String exceed_dose_desc	="";
			if(amendDetails.containsKey("EXCEED_DOSE_DESC"))
				exceed_dose_desc	= amendDetails.get("EXCEED_DOSE_DESC").toString();
			//Added for IN:072715 start
			String allergy_remarks_code="";
			if(amendDetails.containsKey("allergy_remarks_code"))
				allergy_remarks_code	= amendDetails.get("allergy_remarks_code").toString();
			String dose_remarks_code="";
			if(amendDetails.containsKey("dose_remarks_code"))
				dose_remarks_code		= amendDetails.get("dose_remarks_code").toString();
			String currentrx_remarks_code	="";
			if(amendDetails.containsKey("currentrx_remarks_code"))
				currentrx_remarks_code	= amendDetails.get("currentrx_remarks_code").toString();
			String abuse_override_remarks="";
			String abuse_override="";
			if(amendDetails.containsKey("ABUSE_OVERRIDE"))
				abuse_override_remarks	= amendDetails.get("abuse_override_remarks").toString();
			abuse_override=amendDetails.get("ABUSE_OVERRIDE").toString();
			System.out.println(" 2141abuse_override"+amendDetails.get("abuse_override_remarks"));
			System.out.println("abuse_override_remarks"+amendDetails.get("ABUSE_OVERRIDE"));
			
			//Added for IN:072715 end
			
			String drug_indication="";
			if(amendDetails.containsKey("DrugIndicationRemarks"))
				drug_indication		= amendDetails.get("DrugIndicationRemarks").toString();
			String mono_graph	="";
			if(amendDetails.containsKey("MONO_GRAPH"))
				mono_graph	= amendDetails.get("MONO_GRAPH").toString();
			if(drug_indication!=null && !drug_indication.equals(""))
				drug_indication = java.net.URLDecoder.decode(drug_indication,"UTF-8"); ;
			tempMap.put("CURRENTRX_REMARKS", dup_drug_desc);
			tempMap.put("ALLERGY_REMARKS", allergy_desc);
			tempMap.put("DOSE_REMARKS", exceed_dose_desc);
			tempMap.put("MONO_GRAPH", mono_graph);//Added for IN:070451 
			//Added for IN:072715 start
			tempMap.put("ALLERGY_REMARKS_CODE", allergy_remarks_code);
			tempMap.put("DOSE_REMARKS_CODE", dose_remarks_code);
			tempMap.put("CURRENTRX_REMARKS_CODE", currentrx_remarks_code);
			tempMap.put("abuse_override_remarks", abuse_override_remarks);
			System.out.println(" in bean abuse_override_remarks"+abuse_override_remarks);
			tempMap.put("ABUSE_OVERRIDE", abuse_override);
			//Added for IN:072715 end

			if((!allergy_desc.equals("")) && checkForNull(tempMap.get("ALLERGY_OVERRIDE").toString()).equals("N"));
				tempMap.put("ALLERGY_OVERRIDE", "Y");

			if((!exceed_dose_desc.equals("")) && checkForNull(tempMap.get("DOSE_OVERRIDE").toString()).equals("N"));
				tempMap.put("DOSE_OVERRIDE", "Y");

			if((!dup_drug_desc.equals("")) && checkForNull(tempMap.get("CURRENTRX_OVERRIDE").toString()).equals("N"));
				tempMap.put("CURRENTRX_OVERRIDE", "Y");

				if((!abuse_override_remarks.equals("")) && checkForNull(tempMap.get("ABUSE_OVERRIDE").toString()).equals("N"));
				
				tempMap.put("ABUSE_OVERRIDE", "Y");
				tempMap.put("DAILY_DOSE", amendDetails.get("DAILY_DOSE"));
			tempMap.put("UNIT_DOSE", amendDetails.get("UNIT_DOSE"));
			tempMap.put("LIMIT_IND", amendDetails.get("LIMIT_IND"));
			tempMap.put("ALLERGY_YN", amendDetails.get("ALLERGY_YN"));
			tempMap.put("CURRENT_RX", amendDetails.get("CURRENT_RX"));
			tempMap.put("SRL_NO", amendDetails.get("SRL_NO"));
			//tempMap.put("STRENGTH_UOM", amendDetails.get("STRENGTH_UOM"));
			//tempMap.put("STRENGTH_UOM_DESC", amendDetails.get("STRENGTH_UOM_DESC"));
			tempMap.put("FORM_CODE", amendDetails.get("FORM_CODE"));
			tempMap.put("QTY_VALUE", amendDetails.get("STRENGTH_VALUE"));
			tempMap.put("INFUSION_VALUE", amendDetails.get("INFUSION_VALUE"));
			tempMap.put("FREQ_CODE", amendDetails.get("FREQ_CODE"));
			//tempMap.put("ORD_APPROVED_YN", amendDetails.get("ORD_APPROVED_YN"));//three are commented for //added for ML-MMOH-CRF-0343 [IN:057182]
			//tempMap.put("ORD_AUTHORIZED_YN", amendDetails.get("ORD_AUTHORIZED_YN"));
			//tempMap.put("ORD_COSIGNED_YN", amendDetails.get("ORD_COSIGNED_YN"));
			tempMap.put("DOSAGE_TYPE", amendDetails.get("DOSAGE"));
			tempMap.put("BMS_QTY", amendDetails.get("BMS_QTY"));
			tempMap.put("DFLT_QTY_UOM", amendDetails.get("DFLT_QTY_UOM"));
			tempMap.put("TAB_QTY_VALUE", amendDetails.get("TAB_QTY_VALUE"));
			tempMap.put("OR_QTY_DESC", amendDetails.get("STR_DESC"));
			tempMap.put("DRUG_INDICATION", drug_indication); //Added for  ML-BRU-CRF-072[Inc:29938]
			tempMap.put("AMEND_YN", "Y");
			String calc_dose_based_on=checkForNull(amendDetails.get("CALC_DOSE_BASED_ON").toString());
			if (amendDetails.get("DOSAGE").toString().equals("S")) {
				tempMap.put("STRENGTH", amendDetails.get("STRENGTH_VALUE"));
				tempMap.put("STRENGTHUOM", amendDetails.get("STRENGTH_UOM"));
				tempMap.put("BMS_QTY", amendDetails.get("BMS_QTY"));
			}
			else if (amendDetails.get("DOSAGE").toString().equals("Q")) {
				tempMap.put("PRES_QTY_VALUE", amendDetails.get("STRENGTH_VALUE"));
				tempMap.put("QTY_DESC", amendDetails.get("STRENGTH_UOM"));
				tempMap.put("QTY_DESC_CODE", amendDetails.get("STRENGTH_UOM"));
			}
			if(amendDetails.containsKey("INFUSION_UOM")) {
				tempMap.put("INFUSION_UOM", amendDetails.get("INFUSION_UOM"));
				tempMap.put("dr_flow_unit", amendDetails.get("dr_flow_unit"));
			}
			
			tempMap.put("CALC_DOSE_BASED_ON",calc_dose_based_on);
			if(calc_dose_based_on.equals("B")){
				tempMap.put("CALC_DOSE_VALUE", checkForNull(amendDetails.get("CALC_DOSE_VALUE").toString()));
				tempMap.put("CALC_DOSE_BY", checkForNull(amendDetails.get("CALC_DOSE_BY").toString()));
				tempMap.put("QTY_VALUE", checkForNull(amendDetails.get("strength_value_wt_bsa").toString()));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList getPatientActiveOrders(String patient_id,String patient_class,String order_date,int take_home) {
		Connection connection		= null;
		PreparedStatement pstmt		= null;
		ResultSet resultSet			= null;
		String start_date			= "";
		String end_date				= "";
		String drug_desc			= "";
		String strength				= "";
		String split_dose_prev		= "";
		String strength_uom_desc	= "";
		String form_desc			= "";
		String practitioner_name	= "";
		String facility_name		= "";
		String diag_text			= "";
		String location				= "";
		String order_id				= "";
		String order_line_no		= "";
		String freq_code			= "";
		String freq_desc			= "";
		String allergy_reason		= "";
		String dosage_reason		= "";
		String duplicate_reason		= "";
		String append_qry			= "";

		ArrayList activeOrders		= new ArrayList();
		HashMap	record				= null;

		try {
			connection	= getConnection();

			if(patient_class.equals("IP") ||take_home>0) {
				append_qry	=	" ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO";
			}
			else {
				append_qry	=	" AND NVL(A.TOT_ISSUED_QTY, 0)-NVL(A.RETURNED_QTY,0)!=0 ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO";
			}

			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT51")+append_qry);
			pstmt.setString(1, patient_id);
			pstmt.setString(2, getLanguageId());
			pstmt.setString(3, getLanguageId());
			pstmt.setString(4, getLanguageId());
			pstmt.setString(5, getLanguageId());

			resultSet	= pstmt.executeQuery();

			while (resultSet != null && resultSet.next()) {
				record	=	new HashMap();
				start_date			= resultSet.getString("START_DATE");
				end_date			= resultSet.getString("END_DATE");
				drug_desc			= resultSet.getString("DRUG_DESC");
				strength			= resultSet.getString("STRENGTH");
				split_dose_prev		= resultSet.getString("SPLIT_DOSE_PREVIEW");
				strength_uom_desc	= resultSet.getString("STRENGTH_UOM");
				form_desc			= resultSet.getString("FORM_CODE");
				practitioner_name	= resultSet.getString("PRACTITIONER_NAME");
				facility_name		= resultSet.getString("FACILITY_NAME");
				diag_text			= resultSet.getString("DIAG_TEXT");
				location			= resultSet.getString("LOCATION");
				order_id			= resultSet.getString("ORIG_ORDER_ID");
				order_line_no		= resultSet.getString("ORIG_ORDER_LINE_NO");
				freq_code			= resultSet.getString("FREQ_CODE");
				freq_desc			= resultSet.getString("FREQ_DESC");
				allergy_reason		= resultSet.getString("ALLERGY_OVERRIDE_REASON");
				dosage_reason		= resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON");
				duplicate_reason	= resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON");

//				com.ehis.util.DateUtils.convertDate((String)orderDetails.get("ORD_DATE"),"DMYHM",getLanguageId(),"en")
				if(!getLanguageId().equals("en")){
					record.put("start_date",com.ehis.util.DateUtils.convertDate(start_date,"DMYHM","en",getLanguageId()));
					record.put("end_date",com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",getLanguageId()));
				}else{	   
					record.put("start_date",start_date);
					record.put("end_date",end_date);
				}
				record.put("drug_desc",drug_desc);
				record.put("strength",strength);
				record.put("strength_uom_desc",strength_uom_desc);
				record.put("form_desc",form_desc);
				record.put("practitioner_name",practitioner_name);
				record.put("location",location);
				record.put("facility_name",facility_name);
				record.put("diag_text",diag_text);
				record.put("split_dose_prev",split_dose_prev);
				record.put("order_id",order_id);
				record.put("order_line_no",order_line_no);
				record.put("freq_code",freq_code);
				record.put("freq_desc",freq_desc);
				record.put("allergy_reason",allergy_reason);
				record.put("dosage_reason",dosage_reason);
				record.put("duplicate_reason",duplicate_reason);
				activeOrders.add(record);
			}
		}
		catch(Exception e) {
			activeOrders.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return activeOrders;
	}

	public boolean checkForStock() {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		boolean STinstalled		= false;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT1"));
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				STinstalled = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return STinstalled;
	}

	public ArrayList getStockDetails(String drug_code, String mode) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		ArrayList STinstalled	= new ArrayList();
		try {
			connection	= getConnection();
			if (mode.equals("1")) {
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT2"));
				pstmt.setString(1, drug_code);
				pstmt.setString(2, getLanguageId());
				resultSet	= pstmt.executeQuery();
				while (resultSet.next()) {
					STinstalled.add(checkNullResult(resultSet.getString("CONTENT_IN_PRES_BASE_UOM"), ""));
					setPackSize(checkNullResult(resultSet.getString("CONTENT_IN_PRES_BASE_UOM"), ""));
					STinstalled.add(checkNullResult(resultSet.getString("PRES_BASE_UOM"), ""));
					STinstalled.add(checkNullResult(resultSet.getString("SHORT_DESC"), ""));
					setStockUOM(checkNullResult(resultSet.getString("STOCK_UOM"), ""));
				}
			}
			else if (mode.equals("2")) {
//				connection	= getConnection();
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT3"));
				pstmt.setString(1, getLanguageId());
				resultSet	= pstmt.executeQuery();
				while (resultSet.next()) {
					STinstalled.add(checkNullResult(resultSet.getString("UOM_CODE"), ""));
					STinstalled.add(checkNullResult(resultSet.getString("SHORT_DESC"), ""));
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception while checking for Stock module");
			e.printStackTrace();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) { }
		}
		return STinstalled;
	}
// Pack Size
	public String getPackSize(String drug_code)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String pack_size		= "";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT2"));
			pstmt.setString(1, drug_code);
			pstmt.setString(2, getLanguageId());
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				pack_size	=	resultSet.getString("CONTENT_IN_PRES_BASE_UOM");
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
			pack_size=e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return pack_size;
	}
	// stock uom
	public String getStockUOM(String drug_code)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String stock_uom		= "";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT82"));
			pstmt.setString(1, drug_code);
			pstmt.setString(2, getLanguageId());
			pstmt.setString(3, getLanguageId());
			pstmt.setString(4, getLanguageId());
			pstmt.setString(5, getLanguageId());
			pstmt.setString(6, getLanguageId());

			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				stock_uom	=	resultSet.getString("STOCK_UOM_DESC");
			}
		} catch(Exception e) {
			stock_uom=e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ }
		}
		return stock_uom;
	}

	public String getInfuseOverValue(String drug_code,String pres_drug_code) {//Pres_drug_code added for ML-MMOH-CRF-1223
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		PreparedStatement pstmt1			 = null;//Added for ML-MMOH-CRF-1223
		ResultSet resultSet1			 = null;//Added for ML-MMOH-CRF-1223
		String infuse_over		= "";
		String param_volume_cal=getParamVolumeCalc();//aDDED FOR AAKH-CRF-0094
		String default_fluid_infuse_over = "";//Added for ML-MMOH-CRF-1223
		
		try {
			connection			= getConnection();
			 boolean default_comp_fluid_falg = isSiteSpecific("PH","DEFAULT_COMP_FLUID_INF_OVER"); //added for SKR-SCF-1440
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT9"));
			pstmt.setString(1, drug_code);
			
			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				if(param_volume_cal.equals("Y")){//if else condition added FOR AAKH-CRF-0094
				    infuse_over	=	resultSet.getString("INFUSE_OVER_VALUE");
				}else{
					infuse_over="0";
				}
				//Adding start for ML-MMOH-CRF-1223
				System.err.println("param_volume_cal@@@==="+param_volume_cal+"pres_drug_code==="+pres_drug_code);
         if(param_volume_cal.equals("Y") && default_comp_fluid_falg && !pres_drug_code.equals("")){ //default_comp_fluid_falg added for SKR-SCF-1440

			    pstmt1		= connection.prepareStatement(" SELECT DEFAULT_INFUSE_OVER_VALUE FROM PH_DRUG_COMPATIBILITY_FLUID WHERE DRUG_CODE =? AND FLUID_CODE=? AND EFF_STATUS ='E' ");
			    pstmt1.setString(1, pres_drug_code);
			    pstmt1.setString(2, drug_code);
			    resultSet1	= pstmt1.executeQuery();
					if(resultSet1!=null && resultSet1.next()) {
						default_fluid_infuse_over =  resultSet1.getString("DEFAULT_INFUSE_OVER_VALUE")==null ? "":resultSet1.getString("DEFAULT_INFUSE_OVER_VALUE");
					}
			  closeResultSet(resultSet1);
			  closeStatement(pstmt1);
					//if(default_fluid_infuse_over.equals("0"))
					//	default_fluid_infuse_over ="";
					System.err.println("default_fluid_infuse_over@@@@====="+default_fluid_infuse_over);
					//  if(!default_fluid_infuse_over.equals("")){
						 infuse_over =default_fluid_infuse_over;
					//  }
         } 
			  //Adding end for ML-MMOH-CRF-1223
				infuse_over	= infuse_over + "::"+resultSet.getString("INFUSE_OVER_DURN_TYPE");

			}
			if(resultSet != null) { closeResultSet(resultSet);  }
			if(pstmt != null)	  { closeStatement(pstmt);  }

			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT11"));
			pstmt.setString(1, drug_code);
			
			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				infuse_over	= infuse_over + "::"+ resultSet.getString("STOCK_UOM");
				infuse_over	= infuse_over + "::"+ resultSet.getString("CONTENT_IN_PRES_BASE_UOM");
					setPackSize(checkForNull(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")));
			}

		}
		catch(Exception e) {
			infuse_over=e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeResultSet(resultSet1);//Added for ML-MMOH-CRF-1223
			    closeStatement(pstmt1);//Added for ML-MMOH-CRF-1223
				closeConnection(connection);
			}
			catch(Exception es){ }
		}
		return infuse_over;
	}

	// getting pres_base_uom from ph_drug
	public String getPresBase(String drug_code)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String pres_base		= "";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT10"));

			pstmt.setString(1, drug_code);
			pstmt.setString(2, getLanguageId());
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				pres_base	=	resultSet.getString("SHORT_DESC");
				pres_base  = pres_base + "::"+resultSet.getString("PRES_BASE_UOM");
			}
		}
		catch(Exception e) {
			pres_base=e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ }
		}
		return pres_base;
	}

	public String getConvFactor(String strength,String qty_uom)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String equl_value		= "";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53"));

			pstmt.setString(1, strength);
			pstmt.setString(2, qty_uom);
			pstmt.setString(3, strength);
			pstmt.setString(4, qty_uom);
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				equl_value	=	resultSet.getString("EQVL_VALUE");
			}
		}
		catch(Exception e) {
			equl_value=e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ }
		}
		return equl_value;
	}

	public HashMap getAmendFluidDetails(){
		return this.amendFluidDetails;
	}


	public ArrayList loadAmendDetails(String order_id, String patient_id,String act_pat_class) {    // RUT-CRF-0062 Added actual patient class to get the Build MAR Value
		presDetails						 = new ArrayList();
		amendDetails					 = new ArrayList();
		Connection connection			 = null;
		PreparedStatement pstmt			 = null;
		ResultSet resultSet				 = null;
		ResultSet resultSet1				 = null;
		ResultSet resultSet3				 = null;
		CallableStatement cstmt			 = null;

		String dosage_type				 = "";
		String strength_value			 = "";
		String qty_value				 = "";
		String calc_dflt_dosage_by_htwt = "";
		String  source_code="", form_code="",priority="", take_home_medication="";  // RUT-CRF-0062 [IN029600]
	// added for ml-mmoh-crf-0978
		String Build_MAR_Rule = "", drugCode="", limit_ind, proc_qty_value="", ATC_allergy, atc_allergy_alert_level,age,  sex,age_in_mints, sql_query;					
		HashMap pat_dtls = null;
		HashMap DrugDetails			= new HashMap();
		HashMap presamendDetails	= new HashMap();
		String external_dosage_override_reason		= "";
		String external_duplicate_override_reason	= "";	
		String external_interaction_override_reason = "";
		String external_contra_override_reason		= "";
		String external_alergy_override_reason		= "";
		String ext_prod_id							= "";
		String generic_id							= "";
		String start_date						= "";
		boolean call_external_checks	 = false;
		try {
			connection	= getConnection() ;
			String licence=(String)(PhLicenceRights.getKey());
			if(licence.equals("PH"))
				//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT21A_IV_AMEND"));
				//PD.STRENGTH_VALUE added for NMC-JD-CRF-0026 
				//OLP.ABUSE_EXISTS,OLP.ABUSE_DRUG_OVERRIDE_REASON added for aakh-crf-0140
				pstmt		=connection.prepareStatement("SELECT OLP.ABUSE_EXISTS,OLP.ABUSE_DRUG_OVERRIDE_REASON,PD.STRENGTH_VALUE,OLP.STRENGTH_UOM, OL.ROUTE_CODE,OLP.STRENGTH_VALUE STRENGTH_PER_PRES_UOM,PD.CONTENT_IN_PRES_BASE_UOM, PD.STRENGTH_PER_VALUE_PRES_UOM,PD.PRES_BASE_UOM, OLP.TOT_INFUSION_OVER, OLP.TOT_INFUSION_OVER_UNIT,OL.ORD_COSIGN_REQD_YN, OL.ORD_APPR_REQD_YN, OL.ORD_AUTH_REQD_YN, OLP.DOSAGE_TYPE, PD.IV_FLUID_YN, PD.IV_INGREDIENT_YN,OT.LONG_DESC,  PDP.DURN_TYPE ,O.PATIENT_ID,  O.ENCOUNTER_ID,  FREQ.SCHEDULED_YN,  DECODE(FREQ.REPEAT_VALUE,  0,  1,  NULL,  1,  FREQ.REPEAT_VALUE) REPEAT_VALUE,  TO_CHAR(O.ORD_DATE_TIME,  'dd/mm/yyyy hh24:mi')ORD_DATE_TIME,  PR.PRACTITIONER_NAME,  DECODE(O.PRIORITY,  'R',  'routine',  'U',  'urgent') PRIORITY,  O.CHILD_ORDER_YN,  O.SOURCE_TYPE,  O.SOURCE_CODE,  O.PERFORMING_DEPTLOC_CODE DISP_LOCN_CODE ,  DL.SHORT_DESC DISP_LOCN_DESC,  OL.ORDER_CATALOG_CODE DRUGCODE,  OL.QTY_VALUE,  OL.QTY_UNIT,OL.ORDER_UOM,  OL.DURN_VALUE,  DURTYPE.DURN_TYPE DURNTYPE,  DURTYPE.DURN_DESC,  OL.CATALOG_DESC,  TO_CHAR(OL.START_DATE_TIME,  'dd/mm/yyyy hh24:mi')START_DATE_TIME,  FRM.FORM_DESC,  FRM.FORM_CODE,  RO.ROUTE_DESC,FREQ.FREQ_CODE,  FREQ.FREQ_DESC,  FREQ.FREQ_NATURE,  OL.LINE_FIELDS_DISPLAY_TEXT,  TO_CHAR(OL.END_DATE_TIME,  'dd/mm/yyyy hh24:mi')END_DATE_TIME,  OL.ORDER_QTY,  UOM.SHORT_DESC,  OL.CONT_ORDER_IND,  OL.REFILL_SINGLE_CONT_ORDER_YN,  OL.NUM_OF_REFILLS,  OL.PARENT_ORDER_LINE_NUM,  PDP.STRENGTH,  PDP.STRENGTH_UOM_CODE STRENGTHUOM,  DIAG_TEXT,PDP.DIAG_CODE1, PDP.DIAG_CODE2, PDP.DIAG_CODE3,  PDP.ALLERGY_OVERRIDE_REASON,  PDP.DOSAGE_LIMIT_OVERRIDE_REASON,  PDP.DUPLICATE_DRUG_OVERRIDE_REASON, PDP.INFUSE_OVER, PDP.INFUSE_OVER_UNIT, PDP.INFUSION_PER_UNIT, PDP.INFUSION_RATE, PDP.INFUSION_VOL_STR_UNIT, PDP.TAPERED_YN,  GN.GENERIC_ID,  GN.GENERIC_NAME,  DECODE(PDP.ALLERGY_OVERRIDE_REASON,  NULL,  'N',  'Y')ALLERGY_YN ,  O.ORDER_TYPE_CODE,  OT.SHORT_DESC ORDERTYPEDESC,  PDP.SPLIT_DOSE_PREVIEW,  O.DISCHARGE_IND TAKEHOME,  DECODE(OL.CHILD_ORDER_YN,  'Y',  TO_CHAR(OL.START_DATE_TIME,  'dd/mm/yyyy hh24:mi')) REFILL_START_DATE_TIME,  DECODE(OL.CHILD_ORDER_YN,  'Y',  TO_CHAR(OL.END_DATE_TIME,  'dd/mm/yyyy hh24:mi')) REFILL_END_DATE_TIME,  PDP.PRESCRIBED_MODE,  PDP.HEIGHT  HEIGHT,  PDP.WEIGHT  WEIGHT, PDP.BSA  BSA,PDP.HEIGHT_UOM   HEIGHT_UOM,PDP.WEIGHT_UOM   WEIGHT_UOM,O.PATIENT_CLASS ,PDP.INTERACTION_OVERRIDE_REASON,PDP.CONTRAIND_OVERRIDE_REASON, PH_GET_EXT_PROD_DRUG_CODE(PD.DRUG_CODE,?) EXTERNAL_PRODUCT_ID, PDP.DRUG_DB_PRODUCT_ID, OLP.BUILD_MAR_YN, PD.CALC_DEF_DOSAGE_YN, PD.ITEM_CODE, PDP.DOSAGE, PDP.DOSAGE_UOM_CODE,OLP.CALC_DOSE_BY, OLP.CALC_DOSE_BASED_ON, OLP.CALC_DOSE_VALUE,OLP.DRUG_INDICATION, OLP.MAR_BARCODE_ID,ALLOW_ALTERNATE_YN,OLP.ALLERGY_OVERRIDE_REASON_CODE,OLP.DOSE_LIMIT_OVER_REASON_CODE,OLP.DUP_DRUG_OVERRIDE_REASON_CODE,OLP.INTER_OVERRIDE_REASON_CODE,OLP.LAB_INTER_OVERRIDE_REASON_CODE,OLP.FOOD_INTR_OVERRIDE_REASON_CODE FROM    OR_ORDER O,OR_ORDER_TYPE OT,AM_PRACTITIONER PR,OR_ORDER_LINE OL, PH_FORM FRM,PH_ROUTE RO,PH_GENERIC_NAME GN,AM_FREQUENCY FREQ,   AM_DURATION_TYPE DURTYPE,AM_UOM UOM,PH_PATIENT_DRUG_PROFILE PDP ,  PH_DISP_LOCN DL , PH_DRUG PD ,OR_ORDER_LINE_PH OLP WHERE OL.ORDER_CATALOG_CODE=PD.DRUG_CODE AND O.ORDER_TYPE_CODE=OT.ORDER_TYPE_CODE AND  O.PERFORMING_DEPTLOC_CODE = DL.DISP_LOCN_CODE AND  O.ORD_PRACT_ID=PR.PRACTITIONER_ID   AND  OL.FORM_CODE=FRM.FORM_CODE(+) AND  OL.ROUTE_CODE=RO.ROUTE_CODE(+)   AND  OL.FREQ_CODE=FREQ.FREQ_CODE(+) AND  OL.DURN_TYPE=DURTYPE.DURN_TYPE(+) AND   OLP.STRENGTH_UOM=UOM.UOM_CODE(+) AND    PDP.ORIG_ORDER_ID=O.ORDER_ID AND  O.ORDER_ID=OL.ORDER_ID AND OL.ORDER_ID=OLP.ORDER_ID AND   OL.ORDER_LINE_NUM = OLP.ORDER_LINE_NUM AND  GN.GENERIC_ID = PD.GENERIC_ID AND O.ORDER_ID=? AND  O.PATIENT_ID=? AND  GN.GENERIC_ID=PDP.GENERIC_ID AND DL.FACILITY_ID=?");//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]//allow_alternaet_yn added for GHL-CRF-0549,Modified for IN:072715 Added ALLERGY_OVERRIDE_REASON_CODE,DOSE_LIMIT_OVER_REASON_CODE,DUP_DRUG_OVERRIDE_REASON_CODE
			else{
				//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT21B_IV_AMEND"));
				//PD.STRENGTH_VALUE added for NMC-JD-CRF-0026
                  //OLP.ABUSE_EXISTS,OLP.ABUSE_DRUG_OVERRIDE_REASON added for aakh-crf-0140
				pstmt		= connection.prepareStatement("SELECT  OLP.ABUSE_EXISTS,OLP.ABUSE_DRUG_OVERRIDE_REASON,PD.STRENGTH_VALUE,OLP.STRENGTH_UOM,OL.ROUTE_CODE,  OLP.STRENGTH_VALUE STRENGTH_PER_PRES_UOM,PD.CONTENT_IN_PRES_BASE_UOM, PD.STRENGTH_PER_VALUE_PRES_UOM,PD.PRES_BASE_UOM,OLP.TOT_INFUSION_OVER, OLP.TOT_INFUSION_OVER_UNIT,OL.ORD_COSIGN_REQD_YN, OL.ORD_APPR_REQD_YN, OL.ORD_AUTH_REQD_YN, OLP.DOSAGE_TYPE, PD.IV_FLUID_YN, PD.IV_INGREDIENT_YN,OT.LONG_DESC,  PDP.DURN_TYPE ,O.PATIENT_ID,  O.ENCOUNTER_ID,  FREQ.SCHEDULED_YN,  DECODE(FREQ.REPEAT_VALUE,  0,  1,  NULL,  1,  FREQ.REPEAT_VALUE) REPEAT_VALUE,  TO_CHAR(O.ORD_DATE_TIME,  'dd/mm/yyyy hh24:mi')ORD_DATE_TIME,  PR.PRACTITIONER_NAME,  DECODE(O.PRIORITY,  'R',  'routine',  'U',  'urgent') PRIORITY,  O.CHILD_ORDER_YN,  O.SOURCE_TYPE,  O.SOURCE_CODE,    OL.ORDER_CATALOG_CODE DRUGCODE,  OL.QTY_VALUE,  OL.QTY_UNIT,  OL.DURN_VALUE,  DURTYPE.DURN_TYPE DURNTYPE,  DURTYPE.DURN_DESC,  OL.CATALOG_DESC,  TO_CHAR(OL.START_DATE_TIME,  'dd/mm/yyyy hh24:mi')START_DATE_TIME,  FRM.FORM_DESC,  FRM.FORM_CODE,  RO.ROUTE_DESC,FREQ.FREQ_CODE,  FREQ.FREQ_DESC,  FREQ.FREQ_NATURE,  OL.LINE_FIELDS_DISPLAY_TEXT,  TO_CHAR(OL.END_DATE_TIME,  'dd/mm/yyyy hh24:mi')END_DATE_TIME,  OL.ORDER_QTY,  UOM.SHORT_DESC,  OL.CONT_ORDER_IND,  OL.REFILL_SINGLE_CONT_ORDER_YN,  OL.NUM_OF_REFILLS,  OL.PARENT_ORDER_LINE_NUM,  PDP.STRENGTH,  PDP.STRENGTH_UOM_CODE STRENGTHUOM,  DIAG_TEXT,PDP.DIAG_CODE1, PDP.DIAG_CODE2, PDP.DIAG_CODE3,  PDP.ALLERGY_OVERRIDE_REASON,  PDP.DOSAGE_LIMIT_OVERRIDE_REASON,  PDP.DUPLICATE_DRUG_OVERRIDE_REASON, PDP.INFUSE_OVER, PDP.INFUSE_OVER_UNIT, PDP.INFUSION_PER_UNIT, PDP.INFUSION_RATE, PDP.INFUSION_VOL_STR_UNIT, PDP.TAPERED_YN,  GN.GENERIC_ID,  GN.GENERIC_NAME,  DECODE(PDP.ALLERGY_OVERRIDE_REASON,  NULL,  'N',  'Y')ALLERGY_YN ,  O.ORDER_TYPE_CODE,  OT.SHORT_DESC ORDERTYPEDESC,  PDP.SPLIT_DOSE_PREVIEW,  O.DISCHARGE_IND TAKEHOME,  DECODE(OL.CHILD_ORDER_YN,  'Y',  TO_CHAR(OL.START_DATE_TIME,  'dd/mm/yyyy hh24:mi')) REFILL_START_DATE_TIME,  DECODE(OL.CHILD_ORDER_YN,  'Y',  TO_CHAR(OL.END_DATE_TIME,  'dd/mm/yyyy hh24:mi')) REFILL_END_DATE_TIME,  PDP.PRESCRIBED_MODE,  PDP.HEIGHT HEIGHT,  PDP.WEIGHT WEIGHT, PDP.BSA BSA,PDP.HEIGHT_UOM HEIGHT_UOM,PDP.WEIGHT_UOM  WEIGHT_UOM,O.PATIENT_CLASS ,PDP.INTERACTION_OVERRIDE_REASON,PDP.CONTRAIND_OVERRIDE_REASON,PH_GET_EXT_PROD_DRUG_CODE(PD.DRUG_CODE,?) EXTERNAL_PRODUCT_ID,PDP.DRUG_DB_PRODUCT_ID, OLP.BUILD_MAR_YN, PD.CALC_DEF_DOSAGE_YN, PD.ITEM_CODE,OLP.CALC_DOSE_BY, OLP.CALC_DOSE_BASED_ON, OLP.CALC_DOSE_VALUE,OLP.DRUG_INDICATION, OLP.MAR_BARCODE_ID,ALLOW_ALTERNATE_YN,OLP.ALLERGY_OVERRIDE_REASON_CODE,OLP.DOSE_LIMIT_OVER_REASON_CODE,OLP.DUP_DRUG_OVERRIDE_REASON_CODE,OLP.INTER_OVERRIDE_REASON_CODE,OLP.LAB_INTER_OVERRIDE_REASON_CODE,OLP.FOOD_INTR_OVERRIDE_REASON_CODE  FROM    OR_ORDER O,OR_ORDER_TYPE OT,AM_PRACTITIONER PR,OR_ORDER_LINE OL,    PH_FORM FRM,PH_ROUTE RO,PH_GENERIC_NAME GN,AM_FREQUENCY FREQ,   AM_DURATION_TYPE DURTYPE,AM_UOM UOM,PH_PATIENT_DRUG_PROFILE PDP ,   PH_DRUG PD ,OR_ORDER_LINE_PH OLP WHERE OL.ORDER_CATALOG_CODE=PD.DRUG_CODE AND O.ORDER_TYPE_CODE=OT.ORDER_TYPE_CODE AND  O.ORD_PRACT_ID=PR.PRACTITIONER_ID   AND  OL.FORM_CODE=FRM.FORM_CODE(+) AND  OL.ROUTE_CODE=RO.ROUTE_CODE(+)   AND  OL.FREQ_CODE=FREQ.FREQ_CODE(+) AND  OL.DURN_TYPE=DURTYPE.DURN_TYPE(+) AND    OLP.STRENGTH_UOM=UOM.UOM_CODE(+) AND     PDP.ORIG_ORDER_ID=O.ORDER_ID AND  O.ORDER_ID=OL.ORDER_ID AND OL.ORDER_ID=OLP.ORDER_ID AND   OL.ORDER_LINE_NUM = OLP.ORDER_LINE_NUM AND GN.GENERIC_ID = PD.GENERIC_ID AND  O.ORDER_ID=? AND  O.PATIENT_ID=? AND  GN.GENERIC_ID=PDP.GENERIC_ID");//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]//allow_alternaet_yn added for GHL-CRF-0549,Modified for IN:072715 Added ALLERGY_OVERRIDE_REASON_CODE,DOSE_LIMIT_OVER_REASON_CODE,DUP_DRUG_OVERRIDE_REASON_CODE
			}
			this.setOrderID(order_id);
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,order_id);
			pstmt.setString(3,patient_id);
			if(licence.equals("PH"))
				pstmt.setString(4,login_facility_id);

			resultSet	= pstmt.executeQuery();
			int i=1;
			drugDetails						 = new ArrayList();
			while(resultSet.next()) {
				
				form_code=resultSet.getString("FORM_CODE")==null?"":resultSet.getString("FORM_CODE");// RUT-CRF-0062 [IN029600] -- Begin
				priority=resultSet.getString("PRIORITY")==null?"":resultSet.getString("PRIORITY");
				priority = priority.equals("routine") ? "R":priority;
				priority = priority.equals("urgent")  ? "U":priority;   
				take_home_medication=resultSet.getString("TAKEHOME")==null?"":resultSet.getString("TAKEHOME");// RUT-CRF-0062 [IN029600] -- End
				
				if((resultSet.getString("IV_FLUID_YN")).equals("Y")){
					amendFluidDetails	= new HashMap();
					amendFluidDetails.put("DRUG_DESC",(resultSet.getString("LONG_DESC")==null ? "":resultSet.getString("LONG_DESC")) );
					amendFluidDetails.put("PATIENT_ID",(resultSet.getString("PATIENT_ID")==null ? "":resultSet.getString("PATIENT_ID")));
					amendFluidDetails.put("ENCOUNTER_ID",(resultSet.getString("ENCOUNTER_ID")==null ? "":resultSet.getString("ENCOUNTER_ID")));
					amendFluidDetails.put("PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")));
					amendFluidDetails.put("ORD_DATE_TIME",(resultSet.getString("ORD_DATE_TIME")==null ? "":resultSet.getString("ORD_DATE_TIME")));
					amendFluidDetails.put("PRACTITIONER_NAME",(resultSet.getString("PRACTITIONER_NAME")==null ? "":resultSet.getString("PRACTITIONER_NAME")));
					amendFluidDetails.put("PRIORITY",(resultSet.getString("PRIORITY")==null ? "":resultSet.getString("PRIORITY")));
					amendFluidDetails.put("CHILD_ORDER_YN",(resultSet.getString("CHILD_ORDER_YN")==null ? "":resultSet.getString("CHILD_ORDER_YN")));
					amendFluidDetails.put("DRUG_CODE",(resultSet.getString("DRUGCODE")==null ? "":resultSet.getString("DRUGCODE")));
					amendFluidDetails.put("ITEM_CODE",(resultSet.getString("ITEM_CODE")==null ? "":resultSet.getString("ITEM_CODE")));
					amendFluidDetails.put("QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")));
					amendFluidDetails.put("REPEAT_DURN_TYPE",(resultSet.getString("DURNTYPE")==null ? "":resultSet.getString("DURNTYPE")));
					amendFluidDetails.put("QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")));
					amendFluidDetails.put("QTY_UNIT",(resultSet.getString("QTY_UNIT")==null ? "":resultSet.getString("QTY_UNIT")));
					amendFluidDetails.put("ORDER_UOM",(resultSet.getString("ORDER_UOM")==null ? "":resultSet.getString("ORDER_UOM")));
					amendFluidDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")));
					amendFluidDetails.put("DURN_DESC",(resultSet.getString("DURN_DESC")==null ? "":resultSet.getString("DURN_DESC")));
					amendFluidDetails.put("CATALOG_DESC",(resultSet.getString("CATALOG_DESC")==null ? "":resultSet.getString("CATALOG_DESC")));
					amendFluidDetails.put("BUILD_MAR_YN",(resultSet.getString("BUILD_MAR_YN")==null ? "N":resultSet.getString("BUILD_MAR_YN")));		//added for SRR20056-SCF-7882 -29157			
					if(!getLanguageId().equals("en")){
						amendFluidDetails.put("START_DATE_TIME",com.ehis.util.DateUtils.convertDate((resultSet.getString("START_DATE_TIME")==null ? "":resultSet.getString("START_DATE_TIME")),"DMYHM",getLanguageId(),"en"));
						amendFluidDetails.put("END_DATE_TIME",com.ehis.util.DateUtils.convertDate((resultSet.getString("END_DATE_TIME")==null ? "":resultSet.getString("END_DATE_TIME")),"DMYHM",getLanguageId(),"en"));
					}
					else{
						amendFluidDetails.put("START_DATE_TIME",(resultSet.getString("START_DATE_TIME")==null ? "":resultSet.getString("START_DATE_TIME")));
						amendFluidDetails.put("END_DATE_TIME",(resultSet.getString("END_DATE_TIME")==null ? "":resultSet.getString("END_DATE_TIME")));
					}
					amendFluidDetails.put("FORM_DESC",(resultSet.getString("FORM_DESC")==null ? "":resultSet.getString("FORM_DESC")));
					amendFluidDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")));
					amendFluidDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")));
					amendFluidDetails.put("FORM_CODE",(resultSet.getString("FORM_CODE")==null ? "":resultSet.getString("FORM_CODE")));
					amendFluidDetails.put("FREQ_CODE",(resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")));
					amendFluidDetails.put("FREQ_DESC",(resultSet.getString("FREQ_DESC")==null ? "":resultSet.getString("FREQ_DESC")));
					amendFluidDetails.put("LINE_FIELDS_DISPLAY_TEXT",(resultSet.getString("LINE_FIELDS_DISPLAY_TEXT")==null ? "":resultSet.getString("LINE_FIELDS_DISPLAY_TEXT")));
					amendFluidDetails.put("ORDER_QTY",(resultSet.getString("ORDER_QTY")==null ? "":resultSet.getString("ORDER_QTY")));
					amendFluidDetails.put("SHORT_DESC",(resultSet.getString("SHORT_DESC")==null ? "":resultSet.getString("SHORT_DESC")));
					amendFluidDetails.put("CONT_ORDER_IND",(resultSet.getString("CONT_ORDER_IND")==null ? "":resultSet.getString("CONT_ORDER_IND")));
					amendFluidDetails.put("REFILL_SINGLE_CONT_ORDER_YN",(resultSet.getString("REFILL_SINGLE_CONT_ORDER_YN")==null ? "":resultSet.getString("REFILL_SINGLE_CONT_ORDER_YN")));
					amendFluidDetails.put("NUM_OF_REFILLS",(resultSet.getString("NUM_OF_REFILLS")==null ? "":resultSet.getString("NUM_OF_REFILLS")));
					amendFluidDetails.put("PARENT_ORDER_LINE_NUM",(resultSet.getString("PARENT_ORDER_LINE_NUM")==null ? "":resultSet.getString("PARENT_ORDER_LINE_NUM")));
					amendFluidDetails.put("STRENGTH",(resultSet.getString("STRENGTH")==null ? "":resultSet.getString("STRENGTH")));
					amendFluidDetails.put("STRENGTHUOM",(resultSet.getString("STRENGTHUOM")==null ? "":resultSet.getString("STRENGTHUOM")));
					amendFluidDetails.put("DIAG_TEXT",(resultSet.getString("DIAG_TEXT")==null ? "":resultSet.getString("DIAG_TEXT")));
					amendFluidDetails.put("ALLERGY_OVERRIDE_REASON",(resultSet.getString("ALLERGY_OVERRIDE_REASON")==null ? "":resultSet.getString("ALLERGY_OVERRIDE_REASON")));
					amendFluidDetails.put("DOSAGE_LIMIT_OVERRIDE_REASON",(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")==null ? "":resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")));
					amendFluidDetails.put("DUPLICATE_DRUG_OVERRIDE_REASON",(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")==null ? "":resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")));
					this.setAmendRxRemarks(String.valueOf(i),resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")==null ? "":resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
					this.setAmendAllergyRemarks(String.valueOf(i),resultSet.getString("ALLERGY_OVERRIDE_REASON")==null ? "":resultSet.getString("ALLERGY_OVERRIDE_REASON"));
					this.setAmendDoseRemarks(String.valueOf(i),resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")==null ? "":resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
					amendFluidDetails.put("INFUSE_OVER",(resultSet.getString("INFUSE_OVER")==null ? "":resultSet.getString("INFUSE_OVER")));
					amendFluidDetails.put("INFUSION_RATE",(resultSet.getString("INFUSION_RATE")==null ? "":resultSet.getString("INFUSION_RATE")));
					amendFluidDetails.put("INFUSE_OVER_UNIT",(resultSet.getString("INFUSE_OVER_UNIT")==null ? "":resultSet.getString("INFUSE_OVER_UNIT")));
					amendFluidDetails.put("TOT_INFUSION_OVER",(resultSet.getString("TOT_INFUSION_OVER")==null ? "":resultSet.getString("TOT_INFUSION_OVER")));
					amendFluidDetails.put("TOT_INFUSION_OVER_UNIT",(resultSet.getString("TOT_INFUSION_OVER_UNIT")==null ? "":resultSet.getString("TOT_INFUSION_OVER_UNIT")));
	
					amendFluidDetails.put("GENERIC_NAME",(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME")));			
					amendFluidDetails.put("ORDER_TYPE_CODE",(resultSet.getString("ORDER_TYPE_CODE")==null ? "":resultSet.getString("ORDER_TYPE_CODE")));			
					amendFluidDetails.put("SPLIT_DOSE_PREVIEW",(resultSet.getString("SPLIT_DOSE_PREVIEW")==null ? "":resultSet.getString("SPLIT_DOSE_PREVIEW")));
					amendFluidDetails.put("HEIGHT",(resultSet.getString("HEIGHT")==null ? "":resultSet.getString("HEIGHT")));
					amendFluidDetails.put("WEIGHT",(resultSet.getString("WEIGHT")==null ? "":resultSet.getString("WEIGHT")));
					amendFluidDetails.put("BSA",(resultSet.getString("BSA")==null ? "":resultSet.getString("BSA")));
					amendFluidDetails.put("WEIGHT_UOM",(resultSet.getString("WEIGHT_UOM")==null ? "":resultSet.getString("WEIGHT_UOM")));
					amendFluidDetails.put("HEIGHT_UOM",(resultSet.getString("HEIGHT_UOM")==null ? "":resultSet.getString("HEIGHT_UOM")));
					setBSA((resultSet.getString("BSA")==null ? "1":resultSet.getString("BSA")));//Added for IN:070451
					setWeight((resultSet.getString("WEIGHT")==null ? "1":resultSet.getString("WEIGHT")));//Added for IN:070451

					amendFluidDetails.put("TAKE_HOME",(resultSet.getString("TAKEHOME")==null ? "N":resultSet.getString("TAKEHOME")));		
					amendFluidDetails.put("REFILL_START_DATE_TIME",(resultSet.getString("REFILL_START_DATE_TIME")==null ? "":resultSet.getString("REFILL_START_DATE_TIME")));
					amendFluidDetails.put("REFILL_END_DATE_TIME",(resultSet.getString("REFILL_END_DATE_TIME")==null ? "":resultSet.getString("REFILL_END_DATE_TIME")));	
					amendFluidDetails.put("SCH_OVER_YN",(resultSet.getString("SCHEDULED_YN")==null ? "N":resultSet.getString("SCHEDULED_YN")));
					amendFluidDetails.put("DURN_TYPE",(resultSet.getString("DURNTYPE")==null ? "D":resultSet.getString("DURNTYPE")));
					amendFluidDetails.put("REPEAT_VALUE",(resultSet.getString("REPEAT_VALUE")==null ? "1":resultSet.getString("REPEAT_VALUE")));
					amendFluidDetails.put("DOSAGE_UOM_CODE",(resultSet.getString("DOSAGE_UOM_CODE")==null ? "":resultSet.getString("DOSAGE_UOM_CODE")));
					amendFluidDetails.put("EXTERNAL_PRODUCT_ID","A");

					amendFluidDetails.put("FLUID_PACK_SIZE",(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null ? "":resultSet.getString("CONTENT_IN_PRES_BASE_UOM")));

//added during PE By Naveen
					amendFluidDetails.put("IV_INGREDIENT_YN",(resultSet.getString("IV_INGREDIENT_YN")==null ? "":resultSet.getString("IV_INGREDIENT_YN")));
					amendFluidDetails.put("IV_FLUID_YN",(resultSet.getString("IV_FLUID_YN")==null ? "":resultSet.getString("IV_FLUID_YN")));
					amendFluidDetails.put("SOURCE_CODE",(resultSet.getString("SOURCE_CODE")==null ? "":resultSet.getString("SOURCE_CODE"))); // RUT-CRF-0062 [IN029600] Added to get Build MAR Rule
					amendFluidDetails.put("DRUG_INDICATION",(resultSet.getString("DRUG_INDICATION")==null ? "":resultSet.getString("DRUG_INDICATION")));//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]
					if(licence.equals("PH")){
						amendFluidDetails.put("DISP_LOCN_CODE",(resultSet.getString("DISP_LOCN_CODE")==null ? "":resultSet.getString("DISP_LOCN_CODE")));
						amendFluidDetails.put("DISP_LOCN_DESC",(resultSet.getString("DISP_LOCN_DESC")==null ? "":resultSet.getString("DISP_LOCN_DESC")));
					}
					else{
						amendFluidDetails.put("DISP_LOCN_CODE","");
						amendFluidDetails.put("DISP_LOCN_DESC","");
					}
					if(act_pat_class.toUpperCase().equals("IP") && (take_home_medication.toUpperCase().equals("D")||take_home_medication.toUpperCase().equals("Y"))){
						act_pat_class="DM";
					}
					Build_MAR_Rule=getMARDefaulting(act_pat_class,source_code,form_code,priority);
					amendFluidDetails.put("BUILD_MAR_RULE",Build_MAR_Rule);// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- End
					amendFluidDetails.put("MAR_BARCODE_ID",(resultSet.getString("MAR_BARCODE_ID")==null?"":resultSet.getString("MAR_BARCODE_ID")));//added for MMS-QH-CRF-0080 [IN:038064] 
					presDetails.add(amendFluidDetails);
				}
				else{
					DrugDetails			= new HashMap();
					presamendDetails	= new HashMap();
					call_external_checks	 = false;
					generic_id = resultSet.getString("GENERIC_ID")==null?"":resultSet.getString("GENERIC_ID");
					
					DrugDetails.put("GENERIC_ID",generic_id);
					DrugDetails.put("STRENGTH_PER_PRES_UOM",(resultSet.getString("STRENGTH_PER_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_PRES_UOM")));
					DrugDetails.put("STRENGTH_PER_VALUE_PRES_UOM",(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")));
					DrugDetails.put("CONTENT_IN_PRES_BASE_UOM",(checkForNull(resultSet.getString("CONTENT_IN_PRES_BASE_UOM"))));
					
					dosage_type = resultSet.getString("DOSAGE_TYPE")==null ? "":resultSet.getString("DOSAGE_TYPE");
					DrugDetails.put("DOSAGE_TYPE",dosage_type);
					if(!dosage_type.equals(""))
						setDosage_type(dosage_type);
					
					DrugDetails.put("DRUG_DESC",(resultSet.getString("CATALOG_DESC")==null ? "":resultSet.getString("CATALOG_DESC")) );
					DrugDetails.put("PATIENT_ID",(resultSet.getString("PATIENT_ID")==null ? "":resultSet.getString("PATIENT_ID")));
					DrugDetails.put("ENCOUNTER_ID",(resultSet.getString("ENCOUNTER_ID")==null ? "":resultSet.getString("ENCOUNTER_ID")));
					DrugDetails.put("PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")));
					DrugDetails.put("ORD_DATE_TIME",(resultSet.getString("ORD_DATE_TIME")==null ? "":resultSet.getString("ORD_DATE_TIME")));
					DrugDetails.put("PRACTITIONER_NAME",(resultSet.getString("PRACTITIONER_NAME")==null ? "":resultSet.getString("PRACTITIONER_NAME")));
					DrugDetails.put("PRIORITY",(resultSet.getString("PRIORITY")==null ? "":resultSet.getString("PRIORITY")));
					DrugDetails.put("CHILD_ORDER_YN",(resultSet.getString("CHILD_ORDER_YN")==null ? "":resultSet.getString("CHILD_ORDER_YN")));
					DrugDetails.put("DRUG_CODE",(resultSet.getString("DRUGCODE")==null ? "":resultSet.getString("DRUGCODE")));
					DrugDetails.put("ITEM_CODE",(resultSet.getString("ITEM_CODE")==null ? "":resultSet.getString("ITEM_CODE")));
					DrugDetails.put("ALLOW_ALTERNATE_YN",resultSet.getString("ALLOW_ALTERNATE_YN")==null?"":resultSet.getString("ALLOW_ALTERNATE_YN"));//GHL-CRF-0549
					drugCode=(String) resultSet.getString("DRUGCODE");
					if(!amendDrugCodes.contains(drugCode)){
							amendDrugCodes.add(drugCode);
					}
					presamendDetails.put("DRUG_CODE",(resultSet.getString("DRUGCODE")==null ? "":resultSet.getString("DRUGCODE")));
					presamendDetails.put("ITEM_CODE",(resultSet.getString("ITEM_CODE")==null ? "":resultSet.getString("ITEM_CODE")));

					qty_value = resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE");
					DrugDetails.put("QTY_VALUE",qty_value);
					DrugDetails.put("REPEAT_DURN_TYPE",(resultSet.getString("DURNTYPE")==null ? "":resultSet.getString("DURNTYPE")));

					presamendDetails.put("QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")));


					DrugDetails.put("QTY_UNIT",(resultSet.getString("QTY_UNIT")==null ? "":resultSet.getString("QTY_UNIT")));
					DrugDetails.put("ORDER_UOM",(resultSet.getString("ORDER_UOM")==null ? "":resultSet.getString("ORDER_UOM")));
					DrugDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")));
					presamendDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")));

					DrugDetails.put("DURN_DESC",(resultSet.getString("DURN_DESC")==null ? "":resultSet.getString("DURN_DESC")));
					DrugDetails.put("CATALOG_DESC",(resultSet.getString("CATALOG_DESC")==null ? "":resultSet.getString("CATALOG_DESC")));
				    if(!getLanguageId().equals("en")){
						DrugDetails.put("START_DATE_TIME",com.ehis.util.DateUtils.convertDate((resultSet.getString("START_DATE_TIME")==null ? "":resultSet.getString("START_DATE_TIME")),"DMYHM",getLanguageId(),"en"));
						DrugDetails.put("END_DATE_TIME",com.ehis.util.DateUtils.convertDate((resultSet.getString("END_DATE_TIME")==null ? "":resultSet.getString("END_DATE_TIME")),"DMYHM",getLanguageId(),"en"));
					}
					else{
						DrugDetails.put("START_DATE_TIME",(resultSet.getString("START_DATE_TIME")==null ? "":resultSet.getString("START_DATE_TIME")));
						DrugDetails.put("END_DATE_TIME",(resultSet.getString("END_DATE_TIME")==null ? "":resultSet.getString("END_DATE_TIME")));
					}
					start_date = (String)DrugDetails.get("START_DATE_TIME");

					DrugDetails.put("FORM_DESC",(resultSet.getString("FORM_DESC")==null ? "":resultSet.getString("FORM_DESC")));
					DrugDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")));
					DrugDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")));
					DrugDetails.put("FORM_CODE",(resultSet.getString("FORM_CODE")==null ? "":resultSet.getString("FORM_CODE")));
					DrugDetails.put("FREQ_DESC",(resultSet.getString("FREQ_DESC")==null ? "":resultSet.getString("FREQ_DESC")));
					DrugDetails.put("LINE_FIELDS_DISPLAY_TEXT",(resultSet.getString("LINE_FIELDS_DISPLAY_TEXT")==null ? "":resultSet.getString("LINE_FIELDS_DISPLAY_TEXT")));
					DrugDetails.put("ORDER_QTY",(resultSet.getString("ORDER_QTY")==null ? "":resultSet.getString("ORDER_QTY")));
					DrugDetails.put("SHORT_DESC",(resultSet.getString("SHORT_DESC")==null ? "":resultSet.getString("SHORT_DESC")));
					DrugDetails.put("OR_QTY_DESC",(resultSet.getString("SHORT_DESC")==null ? "":resultSet.getString("SHORT_DESC")));
					DrugDetails.put("PRES_BASE_UOM",(resultSet.getString("QTY_UNIT")==null ? "":resultSet.getString("QTY_UNIT")));
					DrugDetails.put("CONT_ORDER_IND",(resultSet.getString("CONT_ORDER_IND")==null ? "":resultSet.getString("CONT_ORDER_IND")));
					DrugDetails.put("REFILL_SINGLE_CONT_ORDER_YN",(resultSet.getString("REFILL_SINGLE_CONT_ORDER_YN")==null ? "":resultSet.getString("REFILL_SINGLE_CONT_ORDER_YN")));
					DrugDetails.put("NUM_OF_REFILLS",(resultSet.getString("NUM_OF_REFILLS")==null ? "":resultSet.getString("NUM_OF_REFILLS")));
					DrugDetails.put("PARENT_ORDER_LINE_NUM",(resultSet.getString("PARENT_ORDER_LINE_NUM")==null ? "":resultSet.getString("PARENT_ORDER_LINE_NUM")));
					DrugDetails.put("STRENGTH_UOM",(resultSet.getString("STRENGTH")==null ? "":resultSet.getString("STRENGTH")));					
					DrugDetails.put("ACT_STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "":resultSet.getString("STRENGTH_VALUE")));//ADDED FOR NMC-JD-CRF-0026
					
					strength_value = resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE");

				    DrugDetails.put("STRENGTH_VALUE",strength_value);
					
					DrugDetails.put("STRENGTH_UOM_DESC",(resultSet.getString("STRENGTHUOM")==null ? "":resultSet.getString("STRENGTHUOM")));
					DrugDetails.put("DIAG_TEXT",(resultSet.getString("DIAG_TEXT")==null ? "":resultSet.getString("DIAG_TEXT")));

					presamendDetails.put("DIAG_TEXT",(resultSet.getString("DIAG_TEXT")==null ? "":resultSet.getString("DIAG_TEXT")));
					DrugDetails.put("ALLERGY_OVERRIDE_REASON",(resultSet.getString("ALLERGY_OVERRIDE_REASON")==null ? "":resultSet.getString("ALLERGY_OVERRIDE_REASON")));
					DrugDetails.put("DOSAGE_LIMIT_OVERRIDE_REASON",(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")==null ? "":resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")));
					DrugDetails.put("DUPLICATE_DRUG_OVERRIDE_REASON",(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")==null ? "":resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")));

					//Added for IN:072715  START
					DrugDetails.put("ALLERGY_REMARKS_CODE",(resultSet.getString("ALLERGY_OVERRIDE_REASON_CODE")==null ? "":resultSet.getString("ALLERGY_OVERRIDE_REASON_CODE")));
					DrugDetails.put("DOSE_REMARKS_CODE",(resultSet.getString("DOSE_LIMIT_OVER_REASON_CODE")==null ? "":resultSet.getString("DOSE_LIMIT_OVER_REASON_CODE")));
					DrugDetails.put("CURRENTRX_REMARKS_CODE",(resultSet.getString("DUP_DRUG_OVERRIDE_REASON_CODE")==null ? "":resultSet.getString("DUP_DRUG_OVERRIDE_REASON_CODE")));
					//Added for IN:072715  END
					this.setAmendRxRemarks(String.valueOf(i),resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")==null ? "":resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
					this.setAmendAllergyRemarks(String.valueOf(i),resultSet.getString("ALLERGY_OVERRIDE_REASON")==null ? "":resultSet.getString("ALLERGY_OVERRIDE_REASON"));
					this.setAmendDoseRemarks(String.valueOf(i),resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")==null ? "":resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));

					DrugDetails.put("GENERIC_NAME",(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME")));			DrugDetails.put("TAPERED_YN",(resultSet.getString("TAPERED_YN")==null ? "":resultSet.getString("TAPERED_YN")));
					DrugDetails.put("ORDER_TYPE_CODE",(resultSet.getString("ORDER_TYPE_CODE")==null ? "":resultSet.getString("ORDER_TYPE_CODE")));			DrugDetails.put("ORDER_TYPE_DESC",(resultSet.getString("ORDERTYPEDESC")==null ? "":resultSet.getString("ORDERTYPEDESC")));
				    DrugDetails.put("SPLIT_DOSE_PREVIEW",(resultSet.getString("SPLIT_DOSE_PREVIEW")==null ? "":resultSet.getString("SPLIT_DOSE_PREVIEW")));

					DrugDetails.put("HEIGHT",(resultSet.getString("HEIGHT")==null ? "":resultSet.getString("HEIGHT")));

					DrugDetails.put("WEIGHT",(resultSet.getString("WEIGHT")==null ? "":resultSet.getString("WEIGHT")));
					DrugDetails.put("BSA",(resultSet.getString("BSA")==null ? "":resultSet.getString("BSA")));
					DrugDetails.put("HEIGHT_UOM",(resultSet.getString("HEIGHT_UOM")==null ? "":resultSet.getString("HEIGHT_UOM")));
					DrugDetails.put("WEIGHT_UOM",(resultSet.getString("WEIGHT_UOM")==null ? "":resultSet.getString("WEIGHT_UOM")));

					DrugDetails.put("TAKE_HOME",(resultSet.getString("TAKEHOME")==null ? "N":resultSet.getString("TAKEHOME")));			
					DrugDetails.put("PRESCRIBED_MODE",(resultSet.getString("PRESCRIBED_MODE")==null ? "Q":resultSet.getString("PRESCRIBED_MODE")));
				    DrugDetails.put("REFILL_START_DATE_TIME",(resultSet.getString("REFILL_START_DATE_TIME")==null ? "":resultSet.getString("REFILL_START_DATE_TIME")));
					DrugDetails.put("REFILL_END_DATE_TIME",(resultSet.getString("REFILL_END_DATE_TIME")==null ? "":resultSet.getString("REFILL_END_DATE_TIME")));			
					DrugDetails.put("NUM_OF_REFILLS",(resultSet.getString("NUM_OF_REFILLS")==null ? "":resultSet.getString("NUM_OF_REFILLS")));
					DrugDetails.put("SCH_OVER_YN",(resultSet.getString("SCHEDULED_YN")==null ? "N":resultSet.getString("SCHEDULED_YN")));
					DrugDetails.put("DURN_TYPE",(resultSet.getString("DURNTYPE")==null ? "D":resultSet.getString("DURNTYPE")));
					DrugDetails.put("ORD_AUTH_REQD_YN",(resultSet.getString("ORD_AUTH_REQD_YN")==null ? "N":resultSet.getString("ORD_AUTH_REQD_YN")));
					DrugDetails.put("DOSAGE_UOM_CODE",(resultSet.getString("DOSAGE_UOM_CODE")==null ? "N":resultSet.getString("DOSAGE_UOM_CODE")));
					//added for aakh-crf-0140
					DrugDetails.put("ABUSE_OVERRIDE", (resultSet.getString("ABUSE_EXISTS")==null ? "":resultSet.getString("ABUSE_EXISTS")));//ADDED FOR AAKH-CRF-0140
					DrugDetails.put("abuse_drug_override_reason", (resultSet.getString("abuse_drug_override_reason")==null ? "":resultSet.getString("abuse_drug_override_reason")));//ADDED FOR AAKH-CRF-0140
					DrugDetails.put("abuse_override_remarks", (resultSet.getString("abuse_drug_override_reason")==null ? "":resultSet.getString("abuse_drug_override_reason")));//ADDED FOR AAKH-CRF-0140
					System.out.println("abuse_override_remarks in ivprescriptionbean 2900"+resultSet.getString("abuse_drug_override_reason"));
					setOrdAuthReqYN((String)DrugDetails.get("DRUG_CODE"),(String)DrugDetails.get("ORD_AUTH_REQD_YN")); //added for ML-MMOH-CRF-0343 [IN:057182]

					DrugDetails.put("ORD_APPR_REQD_YN",(resultSet.getString("ORD_APPR_REQD_YN")==null ? "N":resultSet.getString("ORD_APPR_REQD_YN")));
				    DrugDetails.put("ORD_COSIGN_REQD_YN",(resultSet.getString("ORD_COSIGN_REQD_YN")==null ? "N":resultSet.getString("ORD_COSIGN_REQD_YN")));
					repeat_value = resultSet.getString("REPEAT_VALUE")==null ? "1":resultSet.getString("REPEAT_VALUE");
					DrugDetails.put("REPEAT_VALUE",repeat_value);
					calc_dflt_dosage_by_htwt	= (resultSet.getString("CALC_DEF_DOSAGE_YN")==null ? "":resultSet.getString("CALC_DEF_DOSAGE_YN"));					
					DrugDetails.put("BUILD_MAR_YN",(resultSet.getString("BUILD_MAR_YN")==null ? "N":resultSet.getString("BUILD_MAR_YN")));					
					if(licence.equals("PH")){
						DrugDetails.put("DISP_LOCN_CODE",(resultSet.getString("DISP_LOCN_CODE")==null ? "":resultSet.getString("DISP_LOCN_CODE")));
						DrugDetails.put("DISP_LOCN_DESC",(resultSet.getString("DISP_LOCN_DESC")==null ? "":resultSet.getString("DISP_LOCN_DESC")));
					}
					else{
						DrugDetails.put("DISP_LOCN_CODE","");
						DrugDetails.put("DISP_LOCN_DESC","");
					}
					DrugDetails.put("AMEND_YN","Y");
					ext_prod_id	=	(resultSet.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet.getString("EXTERNAL_PRODUCT_ID"));
					DrugDetails.put("EXTERNAL_PRODUCT_ID",ext_prod_id);
					DrugDetails.put("ORD_SPL_APPR_REQD_YN","N");
					DrugDetails.put("ORD_COSIGN_REQD_YN","N");
					DrugDetails.put("CONSENT_REQD_YN","N");
					DrugDetails.put("CALC_DOSE_BY",resultSet.getString("CALC_DOSE_BY")==null ? "":resultSet.getString("CALC_DOSE_BY"));	
					DrugDetails.put("CALC_DOSE_BASED_ON",resultSet.getString("CALC_DOSE_BY")==null ? "":resultSet.getString("CALC_DOSE_BASED_ON"));	
					DrugDetails.put("CALC_DOSE_VALUE",resultSet.getString("CALC_DOSE_BY")==null ? "":resultSet.getString("CALC_DOSE_VALUE"));	
					DrugDetails.put("DRUG_INDICATION",resultSet.getString("DRUG_INDICATION")==null ? "":resultSet.getString("DRUG_INDICATION"));//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]						

//added during PE By Naveen
					DrugDetails.put("IV_INGREDIENT_YN",(resultSet.getString("IV_INGREDIENT_YN")==null ? "":resultSet.getString("IV_INGREDIENT_YN")));
					DrugDetails.put("IV_FLUID_YN",(resultSet.getString("IV_FLUID_YN")==null ? "":resultSet.getString("IV_FLUID_YN")));
					
					String strAD_DA ="'DA', 'AD'";		// Added for HSA-SCF-0011 [IN:042444]
					if(getExcludeADRAllergyAlert().equals("Y")){ 	//Added for HSA-SCF-0011 [IN:042444]
						strAD_DA = "'DA'";}		// Added for HSA-SCF-0011 [IN:042444]
					pstmt			= connection.prepareStatement("select count(*) from (SELECT   a.adv_reac_code allergy_type_code, b.long_desc allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a,  am_reaction_lang_vw b,pr_allergy_sensitivity C, PH_DRUG d , pr_adverse_event adr WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type in( "+strAD_DA+")  AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code  AND a.patient_id = ? AND b.reaction_code(+) = a.adv_reac_code  AND b.language_id(+) =? and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO AND C.STATUS = 'A' AND( (adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) union ALL SELECT adv_reac_code allergy_type_code, OTHERS_REACTION allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a ,pr_allergy_sensitivity C , PH_DRUG d, pr_adverse_event adr WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type ='DA' AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code AND a.patient_id = ?  AND a.adv_reac_code  ='Oth'and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO and adr.ALLERGY_ALERT_BY <> 'A' AND C.STATUS = 'A' AND ((adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) )");// Changed for RUT-CRF-0065.1 [IN:43255]
					pstmt.setString(1,generic_id);
					pstmt.setString(2,getPatId());
					pstmt.setString(3,getLanguageId());
					pstmt.setString(4,generic_id);
					pstmt.setString(5,getPatId());

					int rec_count	=0;
					resultSet1		= pstmt.executeQuery();

					if(resultSet1!=null && resultSet1.next()) {
						rec_count=resultSet1.getInt(1);
					}

					if(rec_count>0) {
						DrugDetails.put("ALLERGY_YN","Y");
					} 
					else {
						DrugDetails.put("ALLERGY_YN","N");
						//Code Added for	RUT-CRF-0065 IN 29603 - Start
						ATC_allergy="0";
						atc_allergy_alert_level = getATCAllergyLevel();
						if(!atc_allergy_alert_level.equals("N")){
							pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL_ALLERGY_CHECK"));
							pstmt.setString(1,patient_id);
							pstmt.setString(2,generic_id);
							pstmt.setString(3,atc_allergy_alert_level);
							resultSet3			= pstmt.executeQuery();  //changed resultSet to resultSet3
							if(resultSet3!=null && resultSet3.next())
								ATC_allergy = resultSet3.getString("ATC_CHECK_EXISTS");
							closeResultSet( resultSet3 ) ;
							closeStatement( pstmt ) ;
							if(ATC_allergy!=null && !ATC_allergy.equals("0")){
								DrugDetails.put("ALLERGY_YN","Y");
							}
							else
								DrugDetails.put("ALLERGY_YN","N");
						}
						//Code Added for	RUT-CRF-0065 IN 29603 - End					
					}
							   
					try{
						closeResultSet( resultSet1 ) ;
						closeStatement( pstmt ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}

					int count_rx	= 0;
					pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13"));
					pstmt.setString(1, getPatId());
					pstmt.setString(2, generic_id);
					pstmt.setString(3, (String)DrugDetails.get("START_DATE_TIME"));// Changed for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(4, (String)DrugDetails.get("END_DATE_TIME"));// Added for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(5, (String)DrugDetails.get("START_DATE_TIME"));// Added for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(6, (String)DrugDetails.get("END_DATE_TIME"));// Added for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(7, (String)DrugDetails.get("START_DATE_TIME"));// Added for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(8, (String)DrugDetails.get("END_DATE_TIME"));// Added for ML-BRU-SCF-0811 [IN:039394]
					resultSet1			= pstmt.executeQuery();
					if(resultSet1 !=null && resultSet1.next())
						count_rx=resultSet1.getInt(1);

					if(resultSet1 != null)
						closeResultSet(resultSet1);
					if(pstmt	 != null) 
						closeStatement(pstmt);

					if(count_rx>1) {
						DrugDetails.put("CURRENT_RX","Y");
					} 
					else {
						DrugDetails.put("CURRENT_RX","N");
					}
					DrugDetails.put("COUNT_RX",count_rx+"");


			/* Procedure to calculate monograph values --------*/
					pat_dtls	=	getPatientDetails(patient_id,drugCode);
					age			=	(String)pat_dtls.get("age");
					sex			=	((String)pat_dtls.get("sex"));
					age_in_mints  =((String)pat_dtls.get("age_in_mints"));// added for ml-mmoh-crf-0978
					age	=	age.trim();
					String calc_by_ind="";//Added for IN:070451
					String factor="";//Added for IN:070451
					//sex	=	sex.substring(0,1);
					pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80A") ) ;
					pstmt.setString(1,sex);
					pstmt.setString(2,age_in_mints);// added for ml-mmoh-crf-0978
					pstmt.setString(3,drugCode);
					resultSet1	= pstmt.executeQuery();
					
					while(resultSet1!=null && resultSet1.next() ) {
						age_group	=	resultSet1.getString("AGE_GROUP_CODE");
					}
					closeResultSet( resultSet1 ) ;
					closeStatement( pstmt ) ;

					if(calc_dflt_dosage_by_htwt.trim().equals("Y") && !age_group.equals("")) {
						sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT81");
						pstmt				= connection.prepareStatement(sql_query) ;
						pstmt.setString(1,drugCode);
						pstmt.setString(2,age_group);
						resultSet1			= pstmt.executeQuery();

						if(resultSet1!=null && resultSet1.next()) {
							DrugDetails.put("RECOMM_YN","Y");
							DrugDetails.put("CALC_BY_IND",(resultSet1.getString("CALC_BY_IND")));
							 calc_by_ind=resultSet1.getString("CALC_BY_IND");//Added for IN:070451
							DrugDetails.put("DOSAGE_STD",(resultSet1.getString("DOSAGE_STD")));
							DrugDetails.put("DOSAGE_UNIT",(resultSet1.getString("DOSAGE_UNIT")));
							DrugDetails.put("RECOMM_DOSAGE_BY",(resultSet1.getString("LIMIT_IND")));
						} 
						else {
							DrugDetails.put("RECOMM_YN","N");
							DrugDetails.put("CALC_BY_IND","");
							DrugDetails.put("DOSAGE_STD","");
							DrugDetails.put("DOSAGE_UNIT","");
							DrugDetails.put("RECOMM_DOSAGE_BY","");
						}
						closeResultSet( resultSet1 ) ;
						closeStatement( pstmt ) ;
					}
					else {
						DrugDetails.put("CALC_BY_IND","");
						DrugDetails.put("RECOMM_YN","N");
						DrugDetails.put("DOSAGE_STD","");
						DrugDetails.put("DOSAGE_UNIT","");
					}				

					if(dosage_type.equals("Q")) {
						proc_qty_value=qty_value;
					} 
					else if(dosage_type.equals("S")) {
						proc_qty_value=strength_value;
					}
					//Added for IN:070451 start
					if(calc_by_ind.equalsIgnoreCase("W")){
						 factor =weight;
						 proc_qty_value=String.valueOf((Double.parseDouble(proc_qty_value)/Double.parseDouble(weight)));
					}
					else if(calc_by_ind.equalsIgnoreCase("B")){
						 factor =bsa;
						 proc_qty_value=String.valueOf((Double.parseDouble(proc_qty_value)/Double.parseDouble(bsa)));
						 System.out.println("bsa"+bsa);
					}
					else 
					   factor="1";
					setCalledFromIVAmend("AMEND");//Added for IN:070451 
					setIVOrderedQty(proc_qty_value);//Added for IN:070451 
					   //Added for IN:070451 end
					cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//Modified for IN:070451
					cstmt.setString(1, drugCode);
					cstmt.setString(2, patient_id);
					cstmt.setString(3, proc_qty_value);
					cstmt.setString(4, repeat_value);
					cstmt.setString(5, dosage_type);
					cstmt.registerOutParameter(6, Types.VARCHAR);
					cstmt.registerOutParameter(7, Types.VARCHAR);
					cstmt.registerOutParameter(8, Types.VARCHAR);
					cstmt.registerOutParameter(9, Types.VARCHAR);
					cstmt.registerOutParameter(10, Types.VARCHAR);
					cstmt.registerOutParameter(11, Types.VARCHAR);
					cstmt.registerOutParameter(12, Types.VARCHAR);
					//Added for IN:070451 start
					cstmt.registerOutParameter(13, Types.VARCHAR );
					cstmt.registerOutParameter(14, Types.VARCHAR );
					cstmt.registerOutParameter(15, Types.VARCHAR );
					cstmt.registerOutParameter(16, Types.VARCHAR );
					cstmt.setString( 17, factor);
					//Added for IN:070451 start
					cstmt.execute();

					limit_ind		= cstmt.getString(8);

					DrugDetails.put("LIMIT_IND",limit_ind);
					DrugDetails.put("DAILY_DOSE",(cstmt.getString(6)==null ? "0":cstmt.getString(6)));
					DrugDetails.put("UNIT_DOSE",(cstmt.getString(7)==null ? "0":cstmt.getString(7)));
					DrugDetails.put("MONO_GRAPH","");
					DrugDetails.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "0":cstmt.getString(10)));
					DrugDetails.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "0":cstmt.getString(11)));
					DrugDetails.put("DOSAGE_UNIT", (cstmt.getString(12)==null ? "":cstmt.getString(12)));
					//Added for IN:070451 start
					DrugDetails.put("MAX_DAILY_CEELING_DOSE",(cstmt.getString(13)==null ? "":cstmt.getString(13)) );
					DrugDetails.put("MIN_DAILY_CEELING_DOSE",(cstmt.getString(14)==null ? "":cstmt.getString(14)) );
					DrugDetails.put("MAX_UNIT_CEELING_DOSE",(cstmt.getString(15)==null ? "":cstmt.getString(15)) );
					DrugDetails.put("MIN_UNIT_CEELING_DOSE",(cstmt.getString(16)==null ? "":cstmt.getString(16)) );
					//Added for IN:070451 end
					if(limit_ind!=null && limit_ind.equals("N")) {

						/*DrugDetails.put("DAILY_DOSE", (cstmt.getString(6)==null ? "":cstmt.getString(6)));
						DrugDetails.put("UNIT_DOSE", (cstmt.getString(7)==null ? "":cstmt.getString(7)));
						DrugDetails.put("MIN_DAILY_DOSE", (cstmt.getString(10)==null ? "":cstmt.getString(10)));
						DrugDetails.put("MIN_UNIT_DOSE", (cstmt.getString(11)==null ? "":cstmt.getString(11)));
						DrugDetails.put("DOSAGE_UNIT", (cstmt.getString(12)==null ? "":cstmt.getString(12)));*/
						DrugDetails.put("MONO_GRAPH", (cstmt.getString(9)==null ? "":cstmt.getString(9)));
					}
					/* else {
						DrugDetails.put("DAILY_DOSE",(cstmt.getString(6)==null ? "0":cstmt.getString(6)));
						DrugDetails.put("UNIT_DOSE",(cstmt.getString(7)==null ? "0":cstmt.getString(7)));
						DrugDetails.put("MONO_GRAPH","");
						DrugDetails.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "0":cstmt.getString(10)));
						DrugDetails.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "0":cstmt.getString(11)));
						DrugDetails.put("DOSAGE_UNIT", (cstmt.getString(12)==null ? "":cstmt.getString(12)));
					}*/

					/* procedure calling ends here ----------------*/

					DrugDetails.put("INTERACTION_OVERRIDE_REASON",(resultSet.getString("INTERACTION_OVERRIDE_REASON")==null ? "":resultSet.getString("INTERACTION_OVERRIDE_REASON")));
					DrugDetails.put("CONTRAIND_OVERRIDE_REASON",(resultSet.getString("CONTRAIND_OVERRIDE_REASON")==null ? "":resultSet.getString("CONTRAIND_OVERRIDE_REASON")));

					external_dosage_override_reason			= (resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")==null ? "":resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
					external_duplicate_override_reason		= (resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")==null ? "":resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
					external_interaction_override_reason	= (resultSet.getString("INTERACTION_OVERRIDE_REASON")==null ? "":resultSet.getString("INTERACTION_OVERRIDE_REASON"));
					external_contra_override_reason			= (resultSet.getString("CONTRAIND_OVERRIDE_REASON")==null ? "":resultSet.getString("CONTRAIND_OVERRIDE_REASON"));	
					external_alergy_override_reason			= (resultSet.getString("ALLERGY_OVERRIDE_REASON")==null ? "":resultSet.getString("ALLERGY_OVERRIDE_REASON"));

		            DrugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",external_dosage_override_reason);
					DrugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",external_duplicate_override_reason);
					DrugDetails.put("EXTERNAL_INTERACTION_OVERRIDE_REASON",external_interaction_override_reason);
					DrugDetails.put("EXTERNAL_CONTRA_OVERRIDE_REASON",external_contra_override_reason);
					DrugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON",external_alergy_override_reason);

					DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",(external_dosage_override_reason == "" ?"N":"Y"));
					DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",(external_duplicate_override_reason == "" ?"N":"Y"));
					DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",(external_interaction_override_reason == "" ?"N":"Y"));
					DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",(external_contra_override_reason == "" ?"N":"Y"));
					DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN",(external_alergy_override_reason == "" ?"N":"Y"));
					DrugDetails.put("SRL_NO",i+"");


					//code for checking whether fdb checks are applicapable or not.
					if(ext_db_interface_yn.equals("Y") && !ext_prod_id.equals("")){
					  call_external_checks =true;
					}
					else{
						  call_external_checks =false;  
					 } 
			/*   PERFORM_EXTERNAL_DATABASE_CHECKS   will indicate whether  module shiuld perform External checks(FDB)or module checks
					 external checks
					 ===============
					 1.duplicate
					 2.drug interaction
					 3.contra-indication
					 
					 internal checks
					 ===============
					 1.duplictae check
					 2.overdose check	*/

					// code written to check whether fdb checks to be performed or PH module checks should be performed
					if(!call_external_checks ) {
						DrugDetails.put("PERFORM_EXTERNAL_DATABASE_CHECKS","N");
					}
					else{				
						DrugDetails.put("PERFORM_EXTERNAL_DATABASE_CHECKS","Y"); 
					}
					DrugDetails.put("DRUG_DB_PRODUCT_ID",(resultSet.getString("DRUG_DB_PRODUCT_ID")==null ? "":resultSet.getString("DRUG_DB_PRODUCT_ID")));	
					// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- Begin
					if(act_pat_class.toUpperCase().equals("IP") && (take_home_medication.toUpperCase().equals("D") || take_home_medication.toUpperCase().equals("Y"))){
						act_pat_class="DM";
					}
					Build_MAR_Rule=getMARDefaulting(act_pat_class,source_code,form_code,priority);
					DrugDetails.put("BUILD_MAR_RULE",Build_MAR_Rule);
					presamendDetails.put("BUILD_MAR_RULE",Build_MAR_Rule);	// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- End
					amendFluidDetails.put("MAR_BARCODE_ID",(resultSet.getString("MAR_BARCODE_ID")==null?"":resultSet.getString("MAR_BARCODE_ID")));//added for MMS-QH-CRF-0080 [IN:038064] 
					DrugDetails.put("ABUSE_RESTRIC_TRN", "N");
					DrugDetails.put("ABUSE_EXISTS", "N" );
					DrugDetails.put("ABUSE_REMARKS","N");
					DrugDetails.put("ABUSE_ACTION", "N" );
					DrugDetails.put("ABUSE_TYPE", "N" );
					DrugDetails.put("ABUSE_DRUG_DESC", "" );
					DrugDetails.put("DRUG_CLASS_OR_DRUG_CODE", "");
				
					
					if(DrugDetails.get("EXTERNAL_PRODUCT_ID").equals("") ){ 
					String drugClass=getDrugClassByOrderId(drugCode);
					String drugdesc=getDrugDescByOrderId(drugCode);
						HashMap abuseDrugMap = getabusedetails(patient_id,drugCode,drugClass);
						if(abuseDrugMap.size()>0){
						DrugDetails.put("ABUSE_RESTRIC_TRN", abuseDrugMap.get("restrict_tran"));
						DrugDetails.put("ABUSE_EXISTS", "Y" );
						DrugDetails.put("ABUSE_REMARKS",abuseDrugMap.get("remarks"));
						DrugDetails.put("ABUSE_ACTION", abuseDrugMap.get("action_type_flag") );
						DrugDetails.put("ABUSE_TYPE", abuseDrugMap.get("restriction_type") );
						DrugDetails.put("ABUSE_DRUG_DESC", drugdesc );
						DrugDetails.put("DRUG_CLASS_OR_DRUG_CODE", abuseDrugMap.get("DRUG_CLASS_OR_DRUG_CODE"));
						}
					}
					presDetails.add(DrugDetails);
					amendDetails.add(presamendDetails);
					drugDetails.add(DrugDetails);
					i++;
				}
			}
		}
		catch (Exception e) {
			presDetails.add("ERROR :"+e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return presDetails;
	}

	public void setDrugDetails(String drugList, String pract_id, String resp_id, String act_pat_class,String priority, String source_code,String take_home_medication) {  // CRF-0062 NEWLY ADDED ARGUMENTS
		System.out.println("3261 drugList"+drugList);
		if(getIVPB().equals("Y")){
			drugDetails = new ArrayList();
		}
		String drug_codes = getDrugCodes();
		if(drug_codes.indexOf(drugList) == -1)
			setDrugCodes(drugList);
		String start_date	= "";

	/*	if(getOrder_type_flag().equals("Existing"))
			 start_date	= getSTART_DATE_TIME();
		else
			 start_date	= getOrderDate();  */

		start_date	= getOrderDate(); 

		if(start_date==null || start_date.equals(""))
			start_date	= getSTART_DATE_TIME();

		String patientClass = getPatientClass();
		HashMap	tmp_hash	= new HashMap();
		String tmp_code		= "";
		String trade_code	= "";
		String trade_name	= "", drugCode = "";
		int trade_count		= 0;
		StringTokenizer st	= new StringTokenizer(drugList, ",");

		Connection connection			 = null;
		PreparedStatement pstmt			 = null;
		ResultSet resultSet				 = null;
		CallableStatement cstmt			 = null;
		boolean	found			 = false;

		HashMap crntRxDrugDetails		 = new HashMap();
		String  exst_generic_id			 = "";

		while (st.hasMoreTokens()) {
			drugCode = st.nextToken();
			found			=	false;
			if(Drg_Trade_Codes_Arr != null){
				if(trade_count < Drg_Trade_Codes_Arr.length){
					trade_code = Drg_Trade_Codes_Arr[trade_count];					
					trade_name = Drg_Trade_Codes_Arr[trade_count++];
				}
				else{
					trade_code = "";
					trade_name = "";
				}
			}
			for(int i=0; i<drugDetails.size(); i++) {
				tmp_hash	=	(HashMap)drugDetails.get(i);
				tmp_hash.get("ABUSE_EXISTS");
				tmp_hash.get("abuse_override_remarks");
				System.out.println("3314 tmp_hash"+tmp_hash);
				System.out.println("3314 tmp_hash"+tmp_hash.get("abuse_override_remarks"));
				
				tmp_code	=	checkForNull((String)tmp_hash.get("DRUG_CODE"));
				if(tmp_code.equals(drugCode)){
					found	=	true;
					break;
				}
			}
		
			if(found)
				break;
			srlNo++;			
			String durn_value				 = "";
			String durn_type				 = "";
			String freq_code				 = "";
			String repeat_durn_type			 = "";
			String schedule_yn				 = "";
			String calc_dosg_by_freq_durn_yn = "";
			String strength_value			 = "";
			String qty_value				 = "";
			String qty_desc_code			 = "";
			String pres_base_uom			 = "";
			String strength_uom				 = "";
			String dosage_type				 = "";
			String repeat_value				 = "";
			String order_type_code			 = "";
			String generic_id				 = "";
			String sDrugCode				 = "";
			String sQtyValue				 = "";
			String sQtyUom					 = "";
			String sDurnValue				 = "";
			String sDurnType				 = "";
			String sFreqCode				 = "";
			String sReqRopt					 = "";
			String ext_prod_id               = "";
			String calc_dflt_dosage_by_htwt = "";
			String  def_dosage_yn= "";				//Added for AAKH-CRF-0089 
			boolean call_external_checks	 = false;
			String drug_desc_new = ""; //Added for MMS-DM-CRF-0177
			//String ext_dup_theraphy_check	 = "N";
			//String ext_dosage_check			 = "N";	
			HashMap DrugDetails			= new HashMap();
			try {
				connection	= getConnection();
				if(orderSetValues.size() >0 ){
					for(int i=0; i<orderSetValues.size(); i=i+8){
						if(orderSetValues.get(i).equals(drugCode)){
							sDrugCode		 = (String)orderSetValues.get(i);
							sQtyValue		 = (String)orderSetValues.get(i+1);
							sQtyUom			 = (String)orderSetValues.get(i+2);
							sFreqCode		 = (String)orderSetValues.get(i+3);
							sDurnValue		 = (String)orderSetValues.get(i+4);
							sDurnType		 = (String)orderSetValues.get(i+5);
							sReqRopt		 = (String)orderSetValues.get(i+6);
						}
					}
				}
				DrugDetails.put("REQD_OR_OPT_IND",sReqRopt);
				//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT1A"));
				pstmt		= connection.prepareStatement("SELECT ITEM_CODE,DRUG_CODE, ph_get_ext_prod_drug_code(?,?) EXTERNAL_PRODUCT_ID, DRUG_DESC,STOCK_UOM_DESC, IN_FORMULARY_YN,GENERIC_ID,GENERIC_NAME,DRUG_CLASS,FORM_CODE,FORM_DESC,B.ROUTE_CODE,B.ROUTE_DESC,PRES_BASE_UOM,PRES_BASE_UOM_DESC,STRENGTH_VALUE,STRENGTH_UOM,STRENGTH_UOM_DESC,STRENGTH_PER_PRES_UOM,STRENGTH_PER_VALUE_PRES_UOM,PRES_CATG_CODE,TRADE_CODE,TRADE_NAME,CALC_DOSG_BY_FREQ_DURN_YN,IV_INGREDIENT_YN,IV_FLUID_YN,  INFUSE_OVER_VALUE,INFUSE_OVER_DURN_TYPE,FRACT_DOSE_ROUND_UP_YN,CONTENT_IN_PRES_BASE_UOM,PRN_DOSES_PRES_PRD_FILL,STOCK_UOM,STOCK_UOM_DESC,CALC_DEF_DOSAGE_YN,PT_COUN_REQD_YN,FRACT_DOSE_APPL_YN, WEIGHT_REC_APPL_AGE_GROUP,BILLABLE_ITEM_YN BILLABLE_ITEM_YN,DEFAULT_DOSAGE_BY,DRUG_INDICATION, DEFAULT_ROUTE_YN,B.ROUTE_COLOR,DEFAULT_DOSAGE_BY_YN, DISP_ALT_FORM_YN, DRUG_SEARCH_BY,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ? AND pr_diag.curr_status != 'E' AND pr_diag.curr_encounter_id = ? ), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = PH_DRUG_VW.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN FROM PH_DRUG_VW_LANG_VW PH_DRUG_VW,ph_route_lang_vw b WHERE DRUG_CODE=? AND NVL(trade_code,'X') = DECODE(?,NULL,NVL (trade_code, 'X'),?) AND LANG1 = ? and PH_DRUG_VW.ROUTE_CODE=B.ROUTE_CODE  and PH_DRUG_VW.LANG1=B.LANGUAGE_ID ");
				 // pstmt.setString(1, patient_id);  
				pstmt.setString(1, drugCode);   // MMS-KH-SCF-0200
				//pstmt.setString(2, getEncId());
				pstmt.setString(2, login_facility_id);  //MMS-KH-SCF-0200
				 // pstmt.setString(3, drugCode);
				pstmt.setString(3, patient_id);  //MMS-KH-SCF-0200     
				// pstmt.setString(4, login_facility_id);
				pstmt.setString(4, getEncId()) ;  //MMS-KH-SCF-0200
				pstmt.setString(5, drugCode);
				pstmt.setString(6, trade_code);
				pstmt.setString(7, trade_code);
				pstmt.setString(8, getLanguageId());
				/*pstmt.setString(7, getLanguageId());
				pstmt.setString(8, getLanguageId());
				pstmt.setString(9, getLanguageId());
				pstmt.setString(10, getLanguageId());*/ //commented for ph_drug_vw_lang_vw - language issue
				resultSet	= pstmt.executeQuery();
			//	System.out.println("values 1.drug code="+drugCode+", 2.login id="+login_facility_id+", 3.trade code="+trade_code+",4.lang id="+getLanguageId());
				if(resultSet.next()) {
					DrugDetails.put("SRL_NO",srlNo+"");
					DrugDetails.put("AMEND_YN", "N");
					DrugDetails.put("rowVal",srlNo+"");
					DrugDetails.put("DRUG_CODE", (resultSet.getString("DRUG_CODE")==null ? "":resultSet.getString("DRUG_CODE")));
					DrugDetails.put("ITEM_CODE", (resultSet.getString("ITEM_CODE")==null ? "":resultSet.getString("ITEM_CODE")));
					DrugDetails.put("DISP_ALT_FORM_YN",resultSet.getString("DISP_ALT_FORM_YN")==null?"N":resultSet.getString("DISP_ALT_FORM_YN"));//GHL-CRF-549 
					ext_prod_id	=	resultSet.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet.getString("EXTERNAL_PRODUCT_ID");		
					DrugDetails.put("EXTERNAL_PRODUCT_ID", ext_prod_id);
					DrugDetails.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);
					DrugDetails.put("PATIENT_CLASS", patientClass);
					DrugDetails.put("DRUG_DESC",(resultSet.getString("DRUG_DESC")==null ? "":resultSet.getString("DRUG_DESC")));
					DrugDetails.put("IN_FORMULARY_YN",(resultSet.getString("IN_FORMULARY_YN")==null ? "":resultSet.getString("IN_FORMULARY_YN")));
					DrugDetails.put("GENERIC_ID",(resultSet.getString("GENERIC_ID")==null ? "":resultSet.getString("GENERIC_ID")));
					generic_id = resultSet.getString("GENERIC_ID");
					DrugDetails.put("GENERIC_NAME",(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME")));
					DrugDetails.put("DRUG_CLASS",(resultSet.getString("DRUG_CLASS")==null ? "":resultSet.getString("DRUG_CLASS")));
					DrugDetails.put("FORM_CODE",(resultSet.getString("FORM_CODE")==null ? "":resultSet.getString("FORM_CODE")));
					DrugDetails.put("FORM_DESC",(resultSet.getString("FORM_DESC")==null ? "":resultSet.getString("FORM_DESC")));
					DrugDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")));
					DrugDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")));
					DrugDetails.put("PRES_BASE_UOM",(resultSet.getString("PRES_BASE_UOM")==null ? "":resultSet.getString("PRES_BASE_UOM")));
					DrugDetails.put("PRES_BASE_UOM_DESC",(resultSet.getString("PRES_BASE_UOM_DESC")==null ? "":resultSet.getString("PRES_BASE_UOM_DESC")));
					DrugDetails.put("ACT_STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE")));
					DrugDetails.put("STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE")));
					DrugDetails.put("STRENGTH_UOM",(resultSet.getString("STRENGTH_UOM")==null ? "":resultSet.getString("STRENGTH_UOM")));
					DrugDetails.put("STRENGTH_UOM_DESC",(resultSet.getString("STRENGTH_UOM_DESC")==null ? "":resultSet.getString("STRENGTH_UOM_DESC")));
					DrugDetails.put("STRENGTH_PER_PRES_UOM",(resultSet.getString("STRENGTH_PER_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_PRES_UOM")));
					DrugDetails.put("STRENGTH_PER_VALUE_PRES_UOM",(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")));
					DrugDetails.put("CONTENT_IN_PRES_BASE_UOM",(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null ? "":resultSet.getString("CONTENT_IN_PRES_BASE_UOM")));					
					DrugDetails.put("STOCK_UOM",(resultSet.getString("STOCK_UOM")==null ? "":resultSet.getString("STOCK_UOM")));					
					DrugDetails.put("STOCK_UOM_DESC",(resultSet.getString("STOCK_UOM_DESC")==null ? "":resultSet.getString("STOCK_UOM_DESC")));
					DrugDetails.put("PRES_CATG_CODE",(resultSet.getString("PRES_CATG_CODE")==null ? "":resultSet.getString("PRES_CATG_CODE")));
					DrugDetails.put("TRADE_CODE",(resultSet.getString("TRADE_CODE")==null ? "":resultSet.getString("TRADE_CODE")));
					DrugDetails.put("TRADE_NAME",(resultSet.getString("TRADE_NAME")==null ? "":resultSet.getString("TRADE_NAME")));
					DrugDetails.put("CALC_DOSG_BY_FREQ_DURN_YN",(resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")==null ? "":resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")));
					DrugDetails.put("FRACT_DOSE_APPL_YN",(resultSet.getString("FRACT_DOSE_APPL_YN")==null ? "":resultSet.getString("FRACT_DOSE_APPL_YN")));
					DrugDetails.put("FRACT_DOSE_ROUND_UP_YN",(resultSet.getString("FRACT_DOSE_ROUND_UP_YN")==null ? "":resultSet.getString("FRACT_DOSE_ROUND_UP_YN")));
					DrugDetails.put("DRUG_INDICATION",(resultSet.getString("DRUG_INDICATION")==null ? "":resultSet.getString("DRUG_INDICATION")));//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]
//added during PE By Naveen

					DrugDetails.put("IV_INGREDIENT_YN",(resultSet.getString("IV_INGREDIENT_YN")==null ? "":resultSet.getString("IV_INGREDIENT_YN")));
					DrugDetails.put("IV_FLUID_YN",(resultSet.getString("IV_FLUID_YN")==null ? "":resultSet.getString("IV_FLUID_YN")));		
					calc_dflt_dosage_by_htwt	= (resultSet.getString("CALC_DEF_DOSAGE_YN")==null ? "":resultSet.getString("CALC_DEF_DOSAGE_YN"));	
					calc_dosg_by_freq_durn_yn = resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN");
					strength_value			  = resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE");
					strength_value			  = strength_value.trim();
					pres_base_uom			  = resultSet.getString("PRES_BASE_UOM");
					strength_uom			  = resultSet.getString("STRENGTH_UOM");
					def_dosage_yn			  = resultSet.getString("DEFAULT_DOSAGE_BY_YN");		//Added For AAKH-CRF-0089
					DrugDetails.put("DEF_DOSAGE_YN",(def_dosage_yn==null ? "":def_dosage_yn));		//Added For AAKH-CRF-0089
					DrugDetails.put("DRUG_SEARCH_BY",(resultSet.getString("DRUG_SEARCH_BY")==null ? "G":resultSet.getString("DRUG_SEARCH_BY")) );//Added for MMS-DM-CRF-0177
					drug_desc_new=(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME"))+" "+(resultSet.getString("STRENGTH_VALUE")==null ? "":resultSet.getString("STRENGTH_VALUE"))+" "+(resultSet.getString("STRENGTH_UOM_DESC")==null ? "":resultSet.getString("STRENGTH_UOM_DESC"))+" "+(resultSet.getString("STOCK_UOM_DESC")==null ? "":resultSet.getString("STOCK_UOM_DESC"));//Added for MMS-DM-CRF-0177
					DrugDetails.put("DRUG_DESC_NEW",drug_desc_new );//Added for MMS-DM-CRF-0177
					DrugDetails.put("DIAGNOSIS_FOUND_YN",resultSet.getString("DIAGNOSIS_FOUND_YN")==null ? "N":resultSet.getString("DIAGNOSIS_FOUND_YN") );
					
					DrugDetails.put("ABUSE_RESTRIC_TRN", "N");
					DrugDetails.put("ABUSE_EXISTS", "N" );
					DrugDetails.put("ABUSE_REMARKS","N");
					DrugDetails.put("ABUSE_ACTION", "N" );
					DrugDetails.put("ABUSE_TYPE", "N" );
					//DrugDetails.put("ABUSE_TYPE", "N" );
					
					 
					String drugClass=getDrugClassByOrderId(drugCode);
					String drugdesc=getDrugDescByOrderId(drugCode);
						HashMap abuseDrugMap = getabusedetails(patient_id,drugCode,drugClass);
					System.err.println("2130drugClass"+drugClass);
				System.err.println("2130drugClass"+drugdesc);
				System.err.println("2130abuseDrugMap"+abuseDrugMap);
				if(abuseDrugMap.size()>0){
					
						DrugDetails.put("ABUSE_RESTRIC_TRN", abuseDrugMap.get("restrict_tran"));
						DrugDetails.put("ABUSE_EXISTS", "Y" );
						DrugDetails.put("ABUSE_REMARKS",abuseDrugMap.get("remarks"));
						DrugDetails.put("ABUSE_ACTION", abuseDrugMap.get("action_type_flag") );
						DrugDetails.put("ABUSE_TYPE", abuseDrugMap.get("restriction_type") );
						DrugDetails.put("ABUSE_DRUG_DESC", drugdesc );
						DrugDetails.put("DRUG_CLASS_OR_DRUG_CODE", abuseDrugMap.get("DRUG_CLASS_OR_DRUG_CODE"));
						
						
					}
				}

				if(resultSet != null) {closeResultSet(resultSet);}
				if(pstmt	 != null) {closeStatement(pstmt);}

				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT2A"));
				//SQL_PH_PRESCRIPTION_SELECT_CONSENT_DETAILS and SQL_PH_PRESCRIPTION_SELECT2A are merged during PE By naveen

				pstmt.setString(1, drugCode);
				pstmt.setString(2, getLanguageId());
				pstmt.setString(3, getLanguageId());
				resultSet	= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("ORDER_CATALOG_CODE",(resultSet.getString("ORDER_CATALOG_CODE")==null ? "":resultSet.getString("ORDER_CATALOG_CODE")));
					DrugDetails.put("SHORT_DESC",(resultSet.getString("SHORT_DESC")==null ? "":resultSet.getString("SHORT_DESC")));
					DrugDetails.put("ORDER_TYPE_CODE",(resultSet.getString("ORDER_TYPE_CODE")==null ? "":resultSet.getString("ORDER_TYPE_CODE")));
					order_type_code = resultSet.getString("ORDER_TYPE_CODE");
					DrugDetails.put("SECURITY_LEVEL",(resultSet.getString("SECURITY_LEVEL")==null ? "":resultSet.getString("SECURITY_LEVEL")));
         // added the below if-else condition to prevent overriding of default value on load in amend mode --for IN23838 -- 05/10/2010-- priya
					if(!(getOrder_type_flag().equals("amend")||getOrder_type_flag().equals("Existing"))){
						DrugDetails.put("QTY_UOM",(resultSet.getString("QTY_UOM")==null ? "":resultSet.getString("QTY_UOM")));
					}
					else
					{
						DrugDetails.put("QTY_UOM",getQty_unit());
					}
//					split_dose_yn	= resultSet.getString("SPLIT_DOSE_YN")==null ? "N":resultSet.getString("SPLIT_DOSE_YN");
					DrugDetails.put("SPLIT_DOSE_YN",(resultSet.getString("SPLIT_DOSE_YN")==null ? "N":resultSet.getString("SPLIT_DOSE_YN")));
					DrugDetails.put("SPLIT_DOSE","N");
					DrugDetails.put("TAPER_DOSE_YN",(resultSet.getString("TAPER_DOSE_YN")==null ? "":resultSet.getString("TAPER_DOSE_YN")));
					DrugDetails.put("BILL_YN",(resultSet.getString("BILL_YN")==null ? "":resultSet.getString("BILL_YN")));
					DrugDetails.put("QTY_REQD_YN",(resultSet.getString("QTY_REQD_YN")==null ? "N":resultSet.getString("QTY_REQD_YN")));
					DrugDetails.put("REFILL_CONT_ORDER_YN",(resultSet.getString("REFILL_CONT_ORDER_YN")==null ? "N":resultSet.getString("REFILL_CONT_ORDER_YN")));
					DrugDetails.put("CONSENT_REQD_YN",(resultSet.getString("CONSENT_REQD_YN")==null ? "N":resultSet.getString("CONSENT_REQD_YN")));
					DrugDetails.put("CHART_RESULT_TYPE",(resultSet.getString("CHART_RESULT_TYPE")==null ? "N":resultSet.getString("CHART_RESULT_TYPE")));
					DrugDetails.put("CHART_RESULT_TYPE",(resultSet.getString("CHART_RESULT_TYPE")==null ? "N":resultSet.getString("CHART_RESULT_TYPE")));
					DrugDetails.put("RESULT_AUTH_REQD_YN",(resultSet.getString("RESULT_AUTH_REQD_YN")==null ? "N":resultSet.getString("RESULT_AUTH_REQD_YN")));

					if(DrugDetails.get("CONSENT_REQD_YN").equals("Y")){							
							DrugDetails.put("CONSENT_STAGE",(resultSet.getString("CONSENT_STAGE")==null ?"":resultSet.getString("CONSENT_STAGE")) );
							if(resultSet.getString("CONSENT_STAGE")!=null && resultSet.getString("CONSENT_STAGE").equals("R"))
								DrugDetails.put("CONSENT_STATUS","P" );
							else
								DrugDetails.put("CONSENT_STATUS","");
							DrugDetails.put("NUM_OF_CONSENT_REQ_BO",(resultSet.getString("NUM_OF_CONSENT_REQ_BO")==null?"":resultSet.getString("NUM_OF_CONSENT_REQ_BO")) );
							DrugDetails.put("NUM_OF_CONSENT_REQ_BR",(resultSet.getString("NUM_OF_CONSENT_REQ_BR")==null?"":resultSet.getString("NUM_OF_CONSENT_REQ_BR")) );
					}else{
						DrugDetails.put("CONSENT_STAGE","");
						DrugDetails.put("CONSENT_STATUS","");
						DrugDetails.put("NUM_OF_CONSENT_REQ_BO","");
						DrugDetails.put("NUM_OF_CONSENT_REQ_BR","");
					}

					DrugDetails.put("ORDER_TYPE_DESC",resultSet.getString("ORDER_TYPE_DESC"));
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
//commented during PE By Naveen
				/*pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10C"));
				pstmt.setString(1, order_type_code);
				pstmt.setString(2, getLanguageId());
				resultSet	= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("ORDER_TYPE_DESC",resultSet.getString("SHORT_DESC"));
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}*/
				//if((!getOrder_type_flag().equals("Existing")) || isCopyOrder){//commented for ML-MMOH-CRF-0343 [IN:057182]
					DrugDetails.put("ORD_AUTH_REQD_YN","");
					DrugDetails.put("ORD_SPL_APPR_REQD_YN","");
					DrugDetails.put("ORD_COSIGN_REQD_YN","");
					DrugDetails.put("ORD_AUTHORIZED_YN","" );
					DrugDetails.put("ORD_APPROVED_YN","");
					DrugDetails.put("ORD_COSIGNED_YN","");
					DrugDetails.put("ORD_AUTHORIZED_PREV_YN","");
					pstmt				= connection.prepareStatement("select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?") ;
					pstmt.setString(1,login_facility_id);
					pstmt.setString(2,getEncId());
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()) {
						DrugDetails.put("PAT_SPECIALTY_CODE",(resultSet.getString("SPECIALTY_CODE")==null ? "":resultSet.getString("SPECIALTY_CODE")) );
					}
					try{
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}

					cstmt=connection.prepareCall("{call PH_ORDER_CATALOG_AUTH_RULE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					cstmt.setString( 1, drugCode);
					cstmt.setString( 2, patientClass);
					cstmt.setString( 3, getLanguageId());
					cstmt.setString( 4, resp_id);
					cstmt.setString( 5, pract_id);
					cstmt.setString( 6, "");
					cstmt.setString( 7, "PH");
					cstmt.registerOutParameter(8, Types.VARCHAR );
					cstmt.registerOutParameter(9, Types.VARCHAR );
					cstmt.registerOutParameter(10, Types.VARCHAR );
					cstmt.registerOutParameter(11, Types.VARCHAR );
					cstmt.registerOutParameter(12, Types.VARCHAR );
					cstmt.registerOutParameter(13, Types.VARCHAR );
					cstmt.setString( 14, (String)DrugDetails.get("PAT_SPECIALTY_CODE"));
					cstmt.registerOutParameter(14, Types.VARCHAR );
					cstmt.setString( 15, patient_id);// Added for Bru-HIMS-CRF-385 [IN:041644]
					cstmt.setString( 16, getOrderDate());// Added for Bru-HIMS-CRF-385 [IN:041644]
					cstmt.setString( 17, priority);// Added for HSA-CRF-0150 [IN:048467]
					cstmt.registerOutParameter(18, Types.VARCHAR ); // ML-MMOH-CRF-1823 US008- 43528 // 51033
					cstmt.execute() ;
					DrugDetails.put("ORD_AUTH_REQD_YN",(cstmt.getString(8)==null ? "":cstmt.getString(8)));
					DrugDetails.put("ORD_SPL_APPR_REQD_YN",(cstmt.getString(9)==null ? "":cstmt.getString(9)) );
					DrugDetails.put("ORD_COSIGN_REQD_YN",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );
					DrugDetails.put("ORD_AUTHORIZED_PREV_YN",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );
					DrugDetails.put("ORD_APPROVED_YN",(cstmt.getString(12)==null ? "":cstmt.getString(12)) );
					DrugDetails.put("ORD_COSIGNED_YN",(cstmt.getString(13)==null ? "":cstmt.getString(13)) );
					DrugDetails.put("ORD_AUTHORIZED_YN",(String)DrugDetails.get("ORD_AUTHORIZED_PREV_YN"));
					try{
						closeStatement( cstmt ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}
					//Code added for the CRF "PMG20089-CRF-0084"  Id:  3897 on 18-Sep-2008
					
			/*		cstmt=connection.prepareCall("{call OR_CHECK_SPLTY_FORCE_AUTH(?,?,?,?,?,?,?)}");
					cstmt.setString(1,pract_id);
					cstmt.setString(2,(String)DrugDetails.get("PAT_SPECIALTY_CODE"));
					cstmt.setString(3,drugCode);
					cstmt.setString(4,(String)DrugDetails.get("ORD_AUTHORIZED_PREV_YN"));
					cstmt.registerOutParameter(5, Types.VARCHAR ); //P_FORCE_AUTH_yn
					cstmt.registerOutParameter(6, Types.VARCHAR ); //P_SPECIALITY_CODE
					cstmt.registerOutParameter(7, Types.VARCHAR ); //P_ALLOW_AUTH_YN 
					cstmt.execute();
			
					DrugDetails.put("ORD_AUTH_REQD_YN",(cstmt.getString(5)==null ? "":cstmt.getString(5)));
					DrugDetails.put("CATALOG_SPLTY_CODE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
					DrugDetails.put("ORD_AUTHORIZED_YN",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );

					try{
						closeStatement( cstmt ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}*/
				//}//commented for ML-MMOH-CRF-0343 [IN:057182]

				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT3A"));
				pstmt.setString(1, drugCode);
				pstmt.setString(2, patientClass);
				pstmt.setString(3, getLanguageId());
				resultSet	= pstmt.executeQuery();
				
				if(resultSet!=null && resultSet.next()) {
				
					DrugDetails.put("ACT_PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")));
					//DrugDetails.put("ORD_AUTH_REQD_YN",(resultSet.getString("ORD_AUTH_REQD_YN")==null ? "N":resultSet.getString("ORD_AUTH_REQD_YN"))); 
					//DrugDetails.put("ORD_SPL_APPR_REQD_YN",(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null ? "N":resultSet.getString("ORD_SPL_APPR_REQD_YN")));
					//DrugDetails.put("ORD_COSIGN_REQD_YN",(resultSet.getString("ORD_COSIGN_REQD_YN")==null ? "N":resultSet.getString("ORD_COSIGN_REQD_YN")));
					DrugDetails.put("ORD_AUTH_LEVEL",(resultSet.getString("ORD_AUTH_LEVEL")==null ? "":resultSet.getString("ORD_AUTH_LEVEL")));
					DrugDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")));
					DrugDetails.put("FREQ_CODE",(resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")));
					DrugDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")) );
					DrugDetails.put("DURN_TYPE",(resultSet.getString("DURN_TYPE")==null ? "":resultSet.getString("MAX_DURN_TYPE")));
					DrugDetails.put("CHK_FOR_MAX_DURN_ACTION",(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null ? "":resultSet.getString("CHK_FOR_MAX_DURN_ACTION")));
					DrugDetails.put("PROMPT_MSG",(resultSet.getString("PROMPT_MSG")==null ? "":resultSet.getString("PROMPT_MSG")));
					DrugDetails.put("MAX_DURN_VALUE",(resultSet.getString("MAX_DURN_VALUE")==null ? "":resultSet.getString("MAX_DURN_VALUE")));
					durn_value	= resultSet.getString("DURN_VALUE");
					freq_code	= resultSet.getString("FREQ_CODE");
					durn_type	= resultSet.getString("DURN_TYPE");
					qty_value	= resultSet.getString("QTY_VALUE");
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				if(!DrugDetails.containsKey("ACT_PATIENT_CLASS")) {

					pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT3A")) ;
					pstmt.setString(1,drugCode);
					pstmt.setString(2,"*A");
					pstmt.setString(3, getLanguageId());
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()) {
						DrugDetails.put("ACT_PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")) );
						DrugDetails.put("ORD_AUTH_REQD_YN",(resultSet.getString("ORD_AUTH_REQD_YN")==null ? "N":resultSet.getString("ORD_AUTH_REQD_YN")) ); // comment removed for ML-MMOH-CRF-0343
						//DrugDetails.put("ORD_SPL_APPR_REQD_YN",(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null ? "N":resultSet.getString("ORD_SPL_APPR_REQD_YN")) );
						//DrugDetails.put("ORD_COSIGN_REQD_YN",(resultSet.getString("ORD_COSIGN_REQD_YN")==null ? "N":resultSet.getString("ORD_COSIGN_REQD_YN")) );

						DrugDetails.put("ORD_AUTH_LEVEL",(resultSet.getString("ORD_AUTH_LEVEL")==null ? "":resultSet.getString("ORD_AUTH_LEVEL")) );
						DrugDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")) );
						//DrugDetails.put("QTY_UOM",(resultSet.getString("QTY_UOM")==null ? "":resultSet.getString("QTY_UOM")) );
						DrugDetails.put("FREQ_CODE",(resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")) );
						DrugDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")) );
						DrugDetails.put("DURN_TYPE",(resultSet.getString("DURN_TYPE")==null ? "":resultSet.getString("DURN_TYPE")) );
						DrugDetails.put("CHK_FOR_MAX_DURN_ACTION",(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null ? "":resultSet.getString("CHK_FOR_MAX_DURN_ACTION")) );
						DrugDetails.put("PROMPT_MSG",(resultSet.getString("PROMPT_MSG")==null ? "":resultSet.getString("PROMPT_MSG")) );
						DrugDetails.put("MAX_DURN_VALUE",(resultSet.getString("MAX_DURN_VALUE")==null ? "":resultSet.getString("MAX_DURN_VALUE")) );
						durn_value		= resultSet.getString("DURN_VALUE");
						freq_code		= resultSet.getString("FREQ_CODE");
						durn_type		= resultSet.getString("DURN_TYPE");
						qty_value		= resultSet.getString("QTY_VALUE");
					}

				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
     
				if(sDrugCode.equals(drugCode)){
					qty_value		= sQtyValue;
					freq_code		= sFreqCode;
					durn_value		= sDurnValue;
					durn_type		= sDurnType;
				}

				String strAD_DA ="'DA', 'AD'";		// Added for HSA-SCF-0011 [IN:042444]
				if(getExcludeADRAllergyAlert().equals("Y")){ 	//Added for HSA-SCF-0011 [IN:042444]
					strAD_DA = "'DA'";}		// Added for HSA-SCF-0011 [IN:042444]
				String sql = "select count(*) from (SELECT   a.adv_reac_code allergy_type_code, b.long_desc allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a,  am_reaction_lang_vw b,pr_allergy_sensitivity C, PH_DRUG d, pr_adverse_event adr  WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type in("+strAD_DA+")  AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code  AND a.patient_id = ? AND b.reaction_code(+) = a.adv_reac_code  AND b.language_id(+) =? and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO AND C.STATUS = 'A' AND( (adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) union ALL SELECT adv_reac_code allergy_type_code, OTHERS_REACTION allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a ,pr_allergy_sensitivity C , PH_DRUG d, pr_adverse_event adr WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type ='DA' AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code AND a.patient_id = ?  AND a.adv_reac_code  ='Oth'and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO and adr.ALLERGY_ALERT_BY <> 'A' AND C.STATUS = 'A' AND ((adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) )";// Changed for RUT-CRF-0065.1 [IN:43255]
				pstmt			= connection.prepareStatement(sql);
				pstmt.setString(1,drugCode);
				pstmt.setString(2,getPatId());
				pstmt.setString(3,getLanguageId());
				pstmt.setString(4,drugCode);
				pstmt.setString(5,getPatId());

				int rec_count	=0;
				resultSet		= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					rec_count=resultSet.getInt(1);
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;

				if(rec_count>0) {
					DrugDetails.put("ALLERGY_YN","Y");
				} 
				else {
					DrugDetails.put("ALLERGY_YN","N");
					//Code Added for	RUT-CRF-0065 IN 29603 - Start
					String ATC_allergy="0";
					String atc_allergy_alert_level = getATCAllergyLevel();
					if(!atc_allergy_alert_level.equals("N")){
						pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL_ALLERGY_CHECK"));
						pstmt.setString(1,patient_id);
						pstmt.setString(2,generic_id);
						pstmt.setString(3,atc_allergy_alert_level);
						resultSet			= pstmt.executeQuery();
						if(resultSet!=null && resultSet.next())
							ATC_allergy = resultSet.getString("ATC_CHECK_EXISTS");
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
						if(ATC_allergy!=null && !ATC_allergy.equals("0")){
							DrugDetails.put("ALLERGY_YN","Y");
						}
						else
							DrugDetails.put("ALLERGY_YN","N");
					}
					//Code Added for	RUT-CRF-0065 IN 29603 - End
				}
			   			   
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT5A"));
				pstmt.setString(1, start_date);
				pstmt.setString(2, start_date);
				resultSet	= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					if(!getLanguageId().equals("en")){
						DrugDetails.put("FUTURE_DATE",com.ehis.util.DateUtils.convertDate((resultSet.getString("FUTURE_DATE")),"DMYHM","en",getLanguageId()));
						DrugDetails.put("BACK_DATE",com.ehis.util.DateUtils.convertDate((resultSet.getString("BACK_DATE")),"DMYHM","en",getLanguageId()));
					}
					else{
						DrugDetails.put("FUTURE_DATE",(resultSet.getString("FUTURE_DATE")));
						DrugDetails.put("BACK_DATE",(resultSet.getString("BACK_DATE")));
					}
				}

				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
//				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT6A"));
				pstmt		= connection.prepareStatement("SELECT FREQ_CODE,FREQ_DESC,SCHEDULED_YN,FREQ_NATURE,REPEAT_VALUE, REPEAT_DURN_TYPE, INTERVAL_VALUE,INTERVAL_DURN_TYPE,DECODE(FREQ_NATURE,'F',(CASE WHEN INTERVAL_DURN_TYPE='H' AND REPEAT_DURN_TYPE ='H' AND REPEAT_VALUE =1 AND INTERVAL_VALUE <>0 THEN (24/INTERVAL_VALUE) WHEN INTERVAL_DURN_TYPE='H' AND REPEAT_DURN_TYPE ='H' AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (REPEAT_VALUE/INTERVAL_VALUE) WHEN INTERVAL_DURN_TYPE='M' AND REPEAT_DURN_TYPE ='M' AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (REPEAT_VALUE/INTERVAL_VALUE) WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE <>0 AND INTERVAL_VALUE =1 THEN REPEAT_VALUE WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE =1 AND INTERVAL_VALUE <>0 THEN (0) WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (0)  END),'I',(CASE WHEN INTERVAL_DURN_TYPE='H' AND REPEAT_DURN_TYPE ='H' AND REPEAT_VALUE =1 AND INTERVAL_VALUE <>0 THEN ceil(repeat_value / interval_value) WHEN INTERVAL_DURN_TYPE='H' AND REPEAT_DURN_TYPE ='H' AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (REPEAT_VALUE/INTERVAL_VALUE) WHEN INTERVAL_DURN_TYPE='M' AND REPEAT_DURN_TYPE ='M' AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (REPEAT_VALUE/INTERVAL_VALUE) WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE <>0 AND INTERVAL_VALUE =1 THEN REPEAT_VALUE WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE =1 AND INTERVAL_VALUE <>0 THEN (0) WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (0)  END)) FREQ_VALUE FROM AM_FREQUENCY_LANG_VW AM_FREQUENCY WHERE FREQ_CODE =? AND LANGUAGE_ID = ? GROUP BY FREQ_CODE,FREQ_DESC,SCHEDULED_YN, FREQ_NATURE,REPEAT_VALUE, REPEAT_DURN_TYPE, INTERVAL_VALUE, INTERVAL_DURN_TYPE");
				if(getOrder_type_flag().equals("amend")||getOrder_type_flag().equals("Existing")){
                      freq_code=getFREQ_CODE(); 
				}
				
	  		    pstmt.setString(1, freq_code);
				pstmt.setString(2, getLanguageId());
     			resultSet	= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("REPEAT_VALUE",(resultSet.getString("REPEAT_VALUE")));
					DrugDetails.put("INTERVAL_VALUE",(resultSet.getString("INTERVAL_VALUE")));
					DrugDetails.put("FREQ_NATURE",(resultSet.getString("FREQ_NATURE")));
					DrugDetails.put("FREQ_VALUE",(resultSet.getString("FREQ_VALUE")));
					DrugDetails.put("FREQ_DESC",(resultSet.getString("FREQ_DESC")));
					DrugDetails.put("SCHEDULED_YN",(resultSet.getString("SCHEDULED_YN")));
					DrugDetails.put("REPEAT_DURN_TYPE",(resultSet.getString("REPEAT_DURN_TYPE")));
					repeat_durn_type=resultSet.getString("REPEAT_DURN_TYPE");
					schedule_yn=resultSet.getString("SCHEDULED_YN");
					repeat_value=checkNullResult(resultSet.getString("REPEAT_VALUE"), "1");
				}
				
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7A"));
				pstmt.setString(1, repeat_durn_type);
				pstmt.setString(2, start_date);
				pstmt.setString(3, durn_value);
				pstmt.setString(4, repeat_durn_type);
				pstmt.setString(5, start_date);
				pstmt.setString(6, durn_value);
				pstmt.setString(7, repeat_durn_type);
				pstmt.setString(8, start_date);
				pstmt.setString(9, durn_value);
				resultSet	= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
				    if(!getLanguageId().equals("en"))
						DrugDetails.put("END_DATE",com.ehis.util.DateUtils.convertDate((resultSet.getString("END_DATE")),"DMYHM",getLanguageId(),"en"));
					else
						DrugDetails.put("END_DATE",(resultSet.getString("END_DATE")));
				}

			    //if(!getLanguageId().equals("en"))
				//	DrugDetails.put("START_DATE",com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",getLanguageId(),"en"));  // Commented for LEAP-INT-PH-SCF-14826 [IN:057866]
				//else
					DrugDetails.put("START_DATE",start_date);

				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT8A"));
				pstmt.setString(1, durn_type);
				pstmt.setString(2, getLanguageId());
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("DURN_DESC",(resultSet.getString("DURN_DESC")));
					DrugDetails.put("OR_DURN_DESC",(resultSet.getString("DURN_DESC")));
				}

//				if(sDrugCode.equals(drugCode)){
//							DrugDetails.put("DOSAGE_TYPE","Q");
//							DrugDetails.put("ORI_DOSAGE_TYPE","Q");
//							dosage_type="Q";
//				} else {
	
			
				if(calc_dosg_by_freq_durn_yn==null || calc_dosg_by_freq_durn_yn.equals("N")) {
					/*DrugDetails.put("DOSAGE_TYPE","A");
					DrugDetails.put("ORI_DOSAGE_TYPE","A");
					dosage_type="A";*/
					//It is observed that, there is no concept "A"(absolute) in IV.So it is commented and new code added below (3 lines)-Abdul-21/07/10
					DrugDetails.put("DOSAGE_TYPE","Q");
					DrugDetails.put("ORI_DOSAGE_TYPE","Q");
					dosage_type="Q";
				} 
				else {
					if(strength_value.equals("0")) {
						DrugDetails.put("DOSAGE_TYPE","Q");
						DrugDetails.put("ORI_DOSAGE_TYPE","Q");
						dosage_type="Q";
					} 
					else {
					/*	DrugDetails.put("DOSAGE_TYPE","S");
						DrugDetails.put("ORI_DOSAGE_TYPE","S");
						dosage_type="S"; */
						//replaced "S" with getDosage_type() for IN23838 IVPB -- 05/10/2010-- priya
						if(!getDosage_type().equals("")){ // Added if/else for SRR20056-SCF-6783 IN026333 "DOSAGE_TYPE" was empty in getDosage_type() for IV with additives
							DrugDetails.put("DOSAGE_TYPE",getDosage_type());
							dosage_type=getDosage_type();
						}
						else{
							dosage_type="S";
							DrugDetails.put("DOSAGE_TYPE","S");
						}
						DrugDetails.put("ORI_DOSAGE_TYPE","S");
					} 
				}
				
				String proc_qty_value="";
				if(sDrugCode.equals(drugCode)){
					DrugDetails.put("QTY_VALUE",qty_value);
					DrugDetails.put("QTY_DESC_CODE",qty_value);
					DrugDetails.put("QTY_UOM",sQtyUom);
					qty_desc_code=sQtyUom;
					proc_qty_value=qty_value;
				}
				else {
					//if(strength_value==null || strength_value.equals("0") || strength_value.equals("")) {
					if(!((String)DrugDetails.get("DOSAGE_TYPE")).equals("S")){
						//DrugDetails.put("QTY_VALUE",qty_value); //replaced qty_value with getQty_value() for IN23838 IVPB -- 05/10/2010-- priya
						if(!getQty_value().equals(""))  // Added if/else for SRR20056-SCF-6783 IN026333 "DOSAGE_TYPE" was empty in getDosage_type() for IV with additives 
							DrugDetails.put("QTY_VALUE", getQty_value());
						else
							DrugDetails.put("QTY_VALUE",qty_value);
						DrugDetails.put("QTY_DESC_CODE",pres_base_uom);
						qty_desc_code=pres_base_uom;
						proc_qty_value=qty_value;
					}
					else { 

					//	DrugDetails.put("QTY_VALUE",strength_value); //replaced strength_value with getQty_value() for IN23838 IVPB -- 05/10/2010-- priya
						if(!getQty_value().equals("")) // Added if/else for SRR20056-SCF-6783 IN026333 "DOSAGE_TYPE" was empty in getDosage_type() for IV with additives
							DrugDetails.put("QTY_VALUE", getQty_value());
						else
							DrugDetails.put("QTY_VALUE",strength_value);
						DrugDetails.put("QTY_DESC_CODE",strength_uom);
						qty_desc_code=strength_uom;
						proc_qty_value=strength_value;
					}
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT9A"));
				pstmt.setString(1, qty_desc_code);
				pstmt.setString(2, getLanguageId());
				resultSet	= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("QTY_DESC",(resultSet.getString("SHORT_DESC")));
					DrugDetails.put("OR_QTY_DESC",(resultSet.getString("SHORT_DESC")));
				}

				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT14A"));
				pstmt.setString(1, login_facility_id);
				resultSet			= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("REFILL_YN",(resultSet.getString("REFILL_YN")==null ? "N":resultSet.getString("REFILL_YN")));
					DrugDetails.put("MAX_REFILLS_FOR_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_REFILLS_FOR_PRES")));
					DrugDetails.put("MAX_DURN_FOR_REFILL_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_DURN_FOR_REFILL_PRES")));
					DrugDetails.put("ALLOW_DUPLICATE_DRUG",(resultSet.getString("ALLOW_DUPLICATE_DRUG")==null ? "":resultSet.getString("ALLOW_DUPLICATE_DRUG")));
					DrugDetails.put("ALLOW_DUPLICATE_DRUG_OP",(resultSet.getString("ALLOW_DUPLICATE_DRUG_OP")==null ? "":resultSet.getString("ALLOW_DUPLICATE_DRUG_OP")));//IN30118-SCF No: MO-GN-5400. Assigning OutPatient Duplicate Drug Check.
				}

				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

/*=============================================*/	

			//code for checking whether fdb checks are applicapable or not.
				 if(ext_db_interface_yn.equals("Y") && !ext_prod_id.equals("")){
					call_external_checks =true;
				 }
				 else{
					call_external_checks =false;  
				 } 
/*
       PERFORM_EXTERNAL_DATABASE_CHECKS   will indicate whether  module shiuld perform External checks(FDB)or module checks
         external checks
		 ===============
		 1.duplicate
		 2.drug interaction
		 3.contra-indication
		 
		 internal checks
		 ===============
		 1.duplictae check
		 2.overdose check
*/

    // code written to check whether fdb checks to be performed or PH module checks should be performed
				if(!call_external_checks ) {
					DrugDetails.put("PERFORM_EXTERNAL_DATABASE_CHECKS","N");
				}
				else{				
					DrugDetails.put("PERFORM_EXTERNAL_DATABASE_CHECKS","Y"); 
				}	 
				//DrugDetails.put("EXTERNAL_OVERRIDE_REASON","");

				DrugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON","");
				DrugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON","");
				DrugDetails.put("EXTERNAL_INTERACTION_OVERRIDE_REASON","");
				DrugDetails.put("EXTERNAL_CONTRA_OVERRIDE_REASON","");
				DrugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON","");

				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN","N");
				pstmt				= connection.prepareStatement("select PDP.ALLERGY_OVERRIDE_REASON,  PDP.DOSAGE_LIMIT_OVERRIDE_REASON,  PDP.DUPLICATE_DRUG_OVERRIDE_REASON from PH_PATIENT_DRUG_PROFILE PDP where ORIG_ORDER_ID = ? and ORIG_ORDER_LINE_NO=2");// order_line_no=2 coz reason would be there only for drugs
//				System.out.println("<<<<<<<<getOrderID()=getORDER_LINE_NUM()="+getOrderID()+"<<<<<<<<");
				pstmt.setString(1,getOrderID() );

				resultSet			= pstmt.executeQuery();
				String temp_override_reason = "";
				if(resultSet!=null && resultSet.next()) {
					
					temp_override_reason = checkNullResult(resultSet.getString("ALLERGY_OVERRIDE_REASON"), "");
					DrugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON",temp_override_reason);
					DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",temp_override_reason.equals("")?"N":"Y");

					temp_override_reason = checkNullResult(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"), "");
					DrugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",temp_override_reason);
					DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",temp_override_reason.equals("")?"N":"Y");

					temp_override_reason = checkNullResult(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"), "");
					DrugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",temp_override_reason);
					DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",temp_override_reason.equals("")?"N":"Y");
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
				pstmt				= connection.prepareStatement("select ABUSE_EXISTS,ABUSE_DRUG_OVERRIDE_REASON from or_order_line_ph where order_id=? and ORDER_LINE_NUM=2");// order_line_no=2 coz reason would be there only for drugs
				System.out.println("<<<<<<<<getOrderID()=getORDER_LINE_NUM()="+getOrderID()+"<<<<<<<<");
				pstmt.setString(1,getOrderID() );
				resultSet			= pstmt.executeQuery();
				String abuse_exists = "";
				String abuse_override_remarks = "";
				if(resultSet!=null && resultSet.next()) {
					abuse_exists= checkNullResult(resultSet.getString("ABUSE_EXISTS"), "");
					abuse_override_remarks= checkNullResult(resultSet.getString("ABUSE_DRUG_OVERRIDE_REASON"), "");
					DrugDetails.put("ABUSE_EXISTS",abuse_exists);
					DrugDetails.put("abuse_drug_override_reason",abuse_override_remarks);
				}
					
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

//PDP.ALLERGY_OVERRIDE_REASON,  PDP.DOSAGE_LIMIT_OVERRIDE_REASON,  PDP.DUPLICATE_DRUG_OVERRIDE_REASON,

	//ends here   
	/*=============================================*/			
				HashMap pat_dtls	=	getPatientDetails(patient_id,drugCode);
				String	age			=	(String)pat_dtls.get("age");
				String	age_in_mints			=	(String)pat_dtls.get("age_in_mints");// added for ml-mmoh-crf-0978
				String sex			=	((String)pat_dtls.get("sex"));
				age	=	age.trim();
				if(sex!=null && !sex.equals("") && sex.length()>1)
					sex	=	sex.substring(0,1);
//	System.err.println("@3417 in IVBean >>> patient_id = "+patient_id+" >> drugCode = "+drugCode+" >> age = "+age+" >> sex = "+sex);
		
				pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80A") ) ;
				pstmt.setString(1,sex);
				pstmt.setString(2,age_in_mints);// added for ml-mmoh-crf-0978
				pstmt.setString(3,drugCode);
				resultSet	= pstmt.executeQuery();
				
				while(resultSet!=null && resultSet.next() ) {
					age_group	=	resultSet.getString("AGE_GROUP_CODE");
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
				String calc_by_ind = ""; //ML-MMOH-CRF-1408
				if(calc_dflt_dosage_by_htwt.trim().equals("Y") && !age_group.equals("")) {
			
					String sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT81");
					pstmt				= connection.prepareStatement(sql_query) ;
					pstmt.setString(1,drugCode);
					pstmt.setString(2,age_group);
					resultSet			= pstmt.executeQuery();

					if(resultSet!=null && resultSet.next()) {
						calc_by_ind = resultSet.getString("CALC_BY_IND"); //ML-MMOH-CRF-1408			
						DrugDetails.put("RECOMM_YN","Y");
						DrugDetails.put("CALC_BY_IND",(resultSet.getString("CALC_BY_IND")));
						DrugDetails.put("DOSAGE_STD",(resultSet.getString("DOSAGE_STD")));
						DrugDetails.put("DOSAGE_UNIT",checkForNull(resultSet.getString("DOSAGE_UNIT")));
						DrugDetails.put("RECOMM_DOSAGE_BY",(resultSet.getString("LIMIT_IND")));
					} 
					else {
						DrugDetails.put("RECOMM_YN","N");
						DrugDetails.put("CALC_BY_IND","");
						DrugDetails.put("DOSAGE_STD","");
						DrugDetails.put("DOSAGE_UNIT","");
						DrugDetails.put("RECOMM_DOSAGE_BY","");
					}
					try{
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}
				} 
				else {
					DrugDetails.put("CALC_BY_IND","");
					DrugDetails.put("RECOMM_YN","N");
					DrugDetails.put("DOSAGE_STD","");
					DrugDetails.put("DOSAGE_UNIT","");
				}				
			//call max dosage limit proc
		//added for ML-MMOH-CRF-1408 - start
		String factor = "";
		String temp_qty = "";
		String weight   = "";
		String height   = "";
		String bsa		= "";

		weight = getWeight();
		bsa = getBSA();

		if(weight==null)weight="";
		if(height==null)height="";
		if(bsa==null)bsa="";

		if(calc_by_ind.equalsIgnoreCase("W")){
			if(!weight.equals(""))
				factor =weight;
			else
				factor ="1";
		}
		else if(calc_by_ind.equalsIgnoreCase("B")){
			if(!bsa.equals(""))
				factor =String.valueOf(bsa);
			else
				factor ="1";
		}
		else{
			factor = "1";
		}

		if(calc_by_ind.equalsIgnoreCase("W")){
			if(weight!=null && !weight.equals("")){
				 temp_qty =  (Float.parseFloat(proc_qty_value)/Float.parseFloat(weight))+"";
			}
		}else if(calc_by_ind.equalsIgnoreCase("B")){
			if(bsa!=null && !bsa.equals("")){
				temp_qty = (Float.parseFloat(proc_qty_value)/Float.parseFloat(bsa))+"";
			}
		}
		if(temp_qty==null || temp_qty.equals(""))
			temp_qty = qty_value;
			//Added for IN:070451 start
		String called_from =getCalledFromIVAmend()==null ? "" :getCalledFromIVAmend();
		String ordered_qty =getIVOrderedQty()==null ? "0" :getIVOrderedQty();
		System.out.println("called_from"+called_from);
		System.out.println("ordered_qty"+ordered_qty);
		if(called_from.equalsIgnoreCase("AMEND")){
			temp_qty = ordered_qty;
		}
		//Added for IN:070451 start
			DrugDetails.put("DAILY_DOSE","");
			DrugDetails.put("UNIT_DOSE","");
			DrugDetails.put("MONO_GRAPH","");
			DrugDetails.put("MIN_DAILY_DOSE","");
			DrugDetails.put("MIN_UNIT_DOSE","");
			DrugDetails.put("DOSAGE_UNIT","");
	//added for ML-MMOH-CRF-1408 - end 
	System.err.println("drugCode==>"+drugCode+"==patient_id===>"+patient_id+"==temp_qty==>"+temp_qty+"==factor===>"+factor+"==dosage_type===>"+dosage_type+"==proc_qty_value===>"+proc_qty_value);
/*==============================================================================================================*/
					if(calc_dflt_dosage_by_htwt!=null && calc_dflt_dosage_by_htwt.trim().equals("Y") && age_group!=null && !age_group.equals("")){ //if condition added for ML-MMOH-CRF-1408
					cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					cstmt.setString(1, drugCode);
					cstmt.setString(2, patient_id);
					cstmt.setString(3, temp_qty); //modified proc_qty_value to temp_qty for ML-MMOH-CRF-1408 
					cstmt.setString(4, "1");
					cstmt.setString(5, dosage_type);
					cstmt.registerOutParameter(6, Types.VARCHAR);
					cstmt.registerOutParameter(7, Types.VARCHAR);
					cstmt.registerOutParameter(8, Types.VARCHAR);
					cstmt.registerOutParameter(9, Types.VARCHAR);
					cstmt.registerOutParameter(10, Types.VARCHAR);
					cstmt.registerOutParameter(11, Types.VARCHAR);
					cstmt.registerOutParameter(12, Types.VARCHAR);
					//Added for IN:070451 start
					cstmt.registerOutParameter(13, Types.VARCHAR );
					cstmt.registerOutParameter(14, Types.VARCHAR );
					cstmt.registerOutParameter(15, Types.VARCHAR );
					cstmt.registerOutParameter(16, Types.VARCHAR );
					cstmt.setString( 17, factor);
					//Added for IN:070451 end
					cstmt.execute();
	//				String daily_dose		= "";
	//				String unit_dose		= "";
	//				String min_daily_dose	= "";
	//				String min_unit_dose	= "";
					String limit_ind		= cstmt.getString(8)==null?"Y":cstmt.getString(8); //null handled for ML-MMOH-CRF-1408
	//				String mono_graph		= "";
	//				String dosage_unit		= "";
				
					//Modified for IN:070451 start
					DrugDetails.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)));
					DrugDetails.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)));
					DrugDetails.put("MONO_GRAPH","");
					DrugDetails.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)));
					DrugDetails.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)));
					//Modified for IN:070451 end
					DrugDetails.put("DOSAGE_UNIT",checkForNull(cstmt.getString(12)));
					//added for ML-MMOH-CRF-1408 - IN:070451 start
					DrugDetails.put("MAX_DAILY_CEELING_DOSE",cstmt.getString(13)==null ? "":cstmt.getString(13));
					DrugDetails.put("MIN_DAILY_CEELING_DOSE",cstmt.getString(14)==null ? "":cstmt.getString(14));
					DrugDetails.put("MAX_UNIT_CEELING_DOSE",cstmt.getString(15)==null ? "":cstmt.getString(15));
					DrugDetails.put("MIN_UNIT_CEELING_DOSE",cstmt.getString(16)==null ? "":cstmt.getString(16));
					//added for ML-MMOH-CRF-1408 IN:070451 end
					
					if(limit_ind!=null && limit_ind.equals("N")) {
						DrugDetails.put("MONO_GRAPH", (cstmt.getString(9)==null ? "":cstmt.getString(9)));
					}
					//commented the below line for ML-MMOH-CRF-1408 - start
				/*	if(call_external_checks){
							DrugDetails.put("LIMIT_IND",limit_ind);
						
					}
					else {
						DrugDetails.put("LIMIT_IND","Y"); 
					} */ 
					//commented the below line for ML-MMOH-CRF-1408 - end
					DrugDetails.put("LIMIT_IND",limit_ind);
					closeStatement( cstmt ) ;
					}
//                if(!call_external_checks){
					int count_rx	= 0;
					pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13"));
					pstmt.setString(1, getPatId());
					pstmt.setString(2, generic_id);
					pstmt.setString(3, (String)DrugDetails.get("START_DATE"));// Changed for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(4, (String)DrugDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(5, (String)DrugDetails.get("START_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(6, (String)DrugDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(7, (String)DrugDetails.get("START_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(8, (String)DrugDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
					
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next())
						count_rx=resultSet.getInt(1);

					if(resultSet != null)
						closeResultSet(resultSet);
					if(pstmt	 != null) 
						closeStatement(pstmt);

					if(count_rx>0) {
						DrugDetails.put("CURRENT_RX","Y");
					} 
					else {
						DrugDetails.put("CURRENT_RX","N");
					}

					DrugDetails.put("COUNT_RX",count_rx+"");

					if(generic_id == null){generic_id = "";}

					for(int crnt_rx = 0;crnt_rx<drugDetails.size();crnt_rx++){
						crntRxDrugDetails = (HashMap)drugDetails.get(crnt_rx);
						exst_generic_id	  = (String)crntRxDrugDetails.get("GENERIC_ID");
						if(exst_generic_id == null) {exst_generic_id = "";}
					
						if(!exst_generic_id.equals("") && !generic_id.equals("")){
							if(exst_generic_id.equals(generic_id)){
								DrugDetails.put("CURRENT_RX","Y");
							}
						}
					}
/*==============================================================================================================*/

				//calucalte total_qty
			/*	}
				else{
                   DrugDetails.put("CURRENT_RX","N");
				}*/

				if(dosage_type.equals("A")) {
					float total_qty=0.0f;
					if((qty_value!=null && !(qty_value.equals("")))) {
						total_qty=Float.parseFloat(qty_value);
					}
					DrugDetails.put("TOT_STRENGTH","0");
					DrugDetails.put("TOT_STRENGTH_UOM","");
					DrugDetails.put("DISPENSED_QTY",String.valueOf(total_qty));
					DrugDetails.put("DISPENSED_UOM",qty_desc_code);
					DrugDetails.put("BMS_QTY",String.valueOf(total_qty));
					DrugDetails.put("BMS_STRENGTH","");
					DrugDetails.put("PRES_QTY_VALUE",qty_value);
					DrugDetails.put("PRES_QTY_UOM",qty_desc_code);
				} 
				else if (dosage_type.equals("Q")) {
					float total_qty=0.0f;
					if((qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals(""))) ) {
						total_qty=Float.parseFloat(qty_value);
					}
					//get the conversion factor
					if(strength_value==null || strength_value.equals("0") || strength_value.equals("")) {
						DrugDetails.put("TOT_STRENGTH","0");
						DrugDetails.put("TOT_STRENGTH_UOM","");
						DrugDetails.put("EQUAL_VALUE","");
					}
					else {
						String equal_value=(String)getConvFactor(strength_uom,qty_desc_code);
						float tot_strength=0.0f;
						if(equal_value!=null && !(equal_value.equals(""))) {
							tot_strength=total_qty*Integer.parseInt(equal_value);
						}

						DrugDetails.put("EQUAL_VALUE", equal_value);
						DrugDetails.put("TOT_STRENGTH",String.valueOf(tot_strength));
						DrugDetails.put("TOT_STRENGTH_UOM",strength_uom);
					}
					DrugDetails.put("DISPENSED_QTY",String.valueOf(total_qty));
					DrugDetails.put("DISPENSED_UOM",qty_desc_code);
					DrugDetails.put("BMS_QTY",String.valueOf(total_qty));
					DrugDetails.put("BMS_STRENGTH","");
					DrugDetails.put("STRENGTH_VALUE","0");
					DrugDetails.put("STRENGTH_UOM","");
					DrugDetails.put("PRES_QTY_VALUE",qty_value);
					DrugDetails.put("PRES_QTY_UOM",qty_desc_code);
				}
				else if (dosage_type.equals("S")) {
					float total_qty=0.0f;
					if((qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals(""))) ) {
						total_qty=Float.parseFloat(qty_value);
					}
					DrugDetails.put("TOT_STRENGTH",String.valueOf(total_qty));
					DrugDetails.put("TOT_STRENGTH_UOM",qty_desc_code);
					DrugDetails.put("DISPENSED_QTY",String.valueOf(total_qty));
					DrugDetails.put("DISPENSED_UOM",qty_desc_code);
					DrugDetails.put("BMS_QTY",String.valueOf(total_qty));
					DrugDetails.put("BMS_STRENGTH","");
					DrugDetails.put("PRES_QTY_VALUE",qty_value);
					DrugDetails.put("PRES_QTY_UOM",qty_desc_code);
				}

				DrugDetails.put("REFILL_START_DATE","");
				DrugDetails.put("REFILL_END_DATE","");
				DrugDetails.put("AUTH_YN","N");
				DrugDetails.put("APPROVAL_YN","N");
				DrugDetails.put("COSIGN_YN","N");
			  	//DrugDetails.put("ORD_AUTHORIZED_YN","N"); 
				DrugDetails.put("ORD_APPROVED_YN","N");
				DrugDetails.put("ORD_COSIGNED_YN","N");
				DrugDetails.put("ALLOW_REFILL","N");
				DrugDetails.put("NO_REFILL","0");
				DrugDetails.put("ADMIN_TIME","");
				DrugDetails.put("ADMIN_QTY","");
				DrugDetails.put("RECORD_GEN","");
				DrugDetails.put("ALLERGY_OVERRIDE","N");
				DrugDetails.put("DOSE_OVERRIDE","N");
				DrugDetails.put("CURRENTRX_OVERRIDE","N");
				DrugDetails.put("ALLERGY_REMARKS","");
				DrugDetails.put("DOSE_REMARKS","");
				DrugDetails.put("CURRENTRX_REMARKS","");
				DrugDetails.put("TAPPERED_OVER","N");
				DrugDetails.put("DFLT_QTY_UOM","");
				DrugDetails.put("START_DATE_TIME",start_date);
				DrugDetails.put("START_DATE",start_date);
				//Added for IN:072715 
				DrugDetails.put("ALLERGY_REMARKS_CODE", "");
				DrugDetails.put("DOSE_REMARKS_CODE", "");
				DrugDetails.put("CURRENTRX_REMARKS_CODE", "");
				//Added for IN:072715
				/*DrugDetails.put("CALC_DOSE_BY","KG");
				DrugDetails.put("CALC_DOSE_BASED_ON","D");
				DrugDetails.put("CALC_DOSE_VALUE","1");*/

				if((!dosage_type.equals("A")) &&  schedule_yn.equals("Y"))
					DrugDetails.put("SCH_OVER_YN","Y");
				else 
					DrugDetails.put("SCH_OVER_YN","N");

				float ext_qty=0;
				int ext_repeat_value=0;
				int ext_durn=0;
				if(qty_value!=null && !qty_value.equals(""))
					ext_qty=Float.parseFloat(qty_value);
				if(repeat_value!=null && !repeat_value.equals(""))
					ext_repeat_value=Integer.parseInt(repeat_value);
				if(durn_value!=null && !durn_value.equals(""))
					ext_durn=Integer.parseInt(durn_value);
				float total_qty_value=ext_qty*ext_repeat_value*ext_durn;
				DrugDetails.put("TOTAL_QTY_VALUE",""+total_qty_value);
				if(act_pat_class.equals("IP") && (take_home_medication.toUpperCase().equals("D") || take_home_medication.toUpperCase().equals("Y"))){
				act_pat_class="DM";
				}
				DrugDetails.put("BUILD_MAR_RULE",getMARDefaulting(act_pat_class,source_code,DrugDetails.get("FORM_CODE").toString(),priority));  // CRF-0062 ADDED TO GET BUILD MAR RULE
			}
			catch(Exception e) {
				DrugDetails.put("error",e);
				e.printStackTrace();
			}
			finally {
				try {
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeStatement(cstmt);
					closeConnection(connection);
				}
				catch(Exception es){
					es.printStackTrace();
				}
			}
			this.setCurrDrugDetails(DrugDetails);
			drugDetails.add(DrugDetails);
			if(!this.FluidDetails.equals("")){
				this.FluidDetails = new HashMap();
			}

		}
	}

	public void setFluidDetails(String fluidCode,String pat_class, String priority, String source_code,String take_home_medication) {  // CRF-0062 Added pat_class, priority, source_code
		String start_date	= "";
			//getOrderDate();
		if(getOrder_type_flag().equals("Existing"))
			 start_date	= getSTART_DATE_TIME();
		else
			 start_date	= getOrderDate(); 

	
		String patientClass = getPatientClass();

		Connection connection			 = null;
		PreparedStatement pstmt			 = null;
		ResultSet resultSet				 = null;
		CallableStatement cstmt			 = null;

		String durn_value				 = "";
		String durn_type				 = "";
		String freq_code				 = "";
		String repeat_durn_type			 = "";
		String schedule_yn				 = "";
		String calc_dosg_by_freq_durn_yn = "";
		String strength_value			 = "";
		String qty_value				 = "";
		String qty_desc_code			 = "";
		String pres_base_uom			 = "";
		String strength_uom				 = "";
		String dosage_type				 = "";
		String repeat_value				 = "";
		String order_type_code			 = "";
		String generic_id				 = "";
		String orderSetQty_unit			 = "";
		String drug_desc_new = ""; //Added for MMS-DM-CRF-0177
	//	String drug_indication			 = "";  Removed for IN063877

		FluidDetails	= new HashMap();
		try {
			connection	= getConnection();

//			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT1A"));

			pstmt = connection.prepareStatement("SELECT ITEM_CODE,DRUG_CODE, DRUG_CLASS, ph_get_ext_prod_drug_code(?,?) EXTERNAL_PRODUCT_ID, DRUG_DESC,STOCK_UOM_DESC, IN_FORMULARY_YN,GENERIC_ID,GENERIC_NAME,DRUG_CLASS,FORM_CODE,FORM_DESC,ROUTE_CODE,ROUTE_DESC,PRES_BASE_UOM,PRES_BASE_UOM_DESC,STRENGTH_VALUE,STRENGTH_UOM,STRENGTH_UOM_DESC,STRENGTH_PER_PRES_UOM,STRENGTH_PER_VALUE_PRES_UOM,PRES_CATG_CODE,TRADE_CODE,TRADE_NAME,CALC_DOSG_BY_FREQ_DURN_YN,IV_INGREDIENT_YN,IV_FLUID_YN,  INFUSE_OVER_VALUE,INFUSE_OVER_DURN_TYPE,FRACT_DOSE_ROUND_UP_YN,CONTENT_IN_PRES_BASE_UOM,PRN_DOSES_PRES_PRD_FILL,STOCK_UOM,STOCK_UOM_DESC,CALC_DEF_DOSAGE_YN,PT_COUN_REQD_YN,FRACT_DOSE_APPL_YN, WEIGHT_REC_APPL_AGE_GROUP,DRUG_INDICATION,DISP_ALT_FORM_YN,DRUG_SEARCH_BY FROM PH_DRUG_VW_LANG_VW PH_DRUG_VW WHERE DRUG_CODE=? AND NVL(trade_code,'X') = DECODE(?,NULL,NVL (trade_code, 'X'),?) AND LANG1 = ?");//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938] // AND DECODE(LANG2,NULL,?,LANG2)= ? AND  DECODE(LANG3,NULL,?,LANG3)= ? -removed for ph_drug_vw_lang_vw - language issue //Added for MMS-DM-CRF-0177


			pstmt.setString(1, fluidCode);
			pstmt.setString(2, login_facility_id);
			pstmt.setString(3, fluidCode);
			pstmt.setString(4, Fld_Trade_Code);
			pstmt.setString(5, Fld_Trade_Code);
			pstmt.setString(6, getLanguageId());
			/*pstmt.setString(7, getLanguageId());
			pstmt.setString(8, getLanguageId());
			pstmt.setString(9, getLanguageId());
			pstmt.setString(10, getLanguageId());*/  //commented for ph_drug_vw_lang_vw - language issue
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				FluidDetails.put("DRUG_CODE", (resultSet.getString("DRUG_CODE")==null ? "":resultSet.getString("DRUG_CODE")));
				FluidDetails.put("DRUG_CLASS", (resultSet.getString("DRUG_CLASS")==null ? "":resultSet.getString("DRUG_CLASS")));
				FluidDetails.put("ITEM_CODE", (resultSet.getString("ITEM_CODE")==null ? "":resultSet.getString("ITEM_CODE")));
				FluidDetails.put("EXTERNAL_PRODUCT_ID", (resultSet.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet.getString("EXTERNAL_PRODUCT_ID")));
				FluidDetails.put("PATIENT_CLASS",patientClass);
				FluidDetails.put("DRUG_DESC",(resultSet.getString("DRUG_DESC")==null ? "":resultSet.getString("DRUG_DESC")));
				FluidDetails.put("IN_FORMULARY_YN",(resultSet.getString("IN_FORMULARY_YN")==null ? "":resultSet.getString("IN_FORMULARY_YN")));
				FluidDetails.put("GENERIC_ID",(resultSet.getString("GENERIC_ID")==null ? "":resultSet.getString("GENERIC_ID")));
				generic_id = resultSet.getString("GENERIC_ID");
				FluidDetails.put("GENERIC_NAME",(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME")));
				FluidDetails.put("FORM_CODE",(resultSet.getString("FORM_CODE")==null ? "":resultSet.getString("FORM_CODE")));
				FluidDetails.put("FORM_DESC",(resultSet.getString("FORM_DESC")==null ? "":resultSet.getString("FORM_DESC")));
				FluidDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")));
				FluidDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")));
				FluidDetails.put("PRES_BASE_UOM",(resultSet.getString("PRES_BASE_UOM")==null ? "":resultSet.getString("PRES_BASE_UOM")));
				FluidDetails.put("PRES_BASE_UOM_DESC",(resultSet.getString("PRES_BASE_UOM_DESC")==null ? "":resultSet.getString("PRES_BASE_UOM_DESC")));
				FluidDetails.put("ACT_STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE")));
				FluidDetails.put("STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE")));
				FluidDetails.put("STRENGTH_UOM",(resultSet.getString("STRENGTH_UOM")==null ? "":resultSet.getString("STRENGTH_UOM")));
				FluidDetails.put("STRENGTH_UOM_DESC",(resultSet.getString("STRENGTH_UOM_DESC")==null ? "":resultSet.getString("STRENGTH_UOM_DESC")));
				FluidDetails.put("STRENGTH_PER_PRES_UOM",(resultSet.getString("STRENGTH_PER_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_PRES_UOM")));
				FluidDetails.put("STRENGTH_PER_VALUE_PRES_UOM",(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")));
				FluidDetails.put("PRES_CATG_CODE",(resultSet.getString("PRES_CATG_CODE")==null ? "":resultSet.getString("PRES_CATG_CODE")));
				FluidDetails.put("TRADE_CODE",(resultSet.getString("TRADE_CODE")==null ? "":resultSet.getString("TRADE_CODE")));
				FluidDetails.put("TRADE_NAME",(resultSet.getString("TRADE_NAME")==null ? "":resultSet.getString("TRADE_NAME")));
				FluidDetails.put("CALC_DOSG_BY_FREQ_DURN_YN",(resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")==null ? "":resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")));

				FluidDetails.put("FLUID_PACK_SIZE",(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null ? "":resultSet.getString("CONTENT_IN_PRES_BASE_UOM")));
				FluidDetails.put("FLUID_STOCK_UOM",(resultSet.getString("STOCK_UOM")==null ? "":resultSet.getString("STOCK_UOM")));
				FluidDetails.put("FLUID_FRACT_DOSE_ROUND_UP_YN",(resultSet.getString("FRACT_DOSE_ROUND_UP_YN")==null ? "":resultSet.getString("FRACT_DOSE_ROUND_UP_YN")));
//added during PE By Naveen
				
				FluidDetails.put("DISP_ALT_FORM_YN",(resultSet.getString("DISP_ALT_FORM_YN")==null ? "":resultSet.getString("DISP_ALT_FORM_YN")));//GHL-CRF-0549

				FluidDetails.put("IV_INGREDIENT_YN",(resultSet.getString("IV_INGREDIENT_YN")==null ? "":resultSet.getString("IV_INGREDIENT_YN")));
				FluidDetails.put("IV_FLUID_YN",(resultSet.getString("IV_FLUID_YN")==null ? "":resultSet.getString("IV_FLUID_YN")));
				FluidDetails.put("DRUG_INDICATION",resultSet.getString("DRUG_INDICATION")==null ? "":resultSet.getString("DRUG_INDICATION"));
				
				FluidDetails.put("DRUG_SEARCH_BY",resultSet.getString("DRUG_SEARCH_BY")==null ? "G":resultSet.getString("DRUG_SEARCH_BY")); //Added for MMS-DM-CRF-0177
				drug_desc_new=(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME"))+" "+(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE"))+" "+(resultSet.getString("STRENGTH_UOM_DESC")==null ? "":resultSet.getString("STRENGTH_UOM_DESC"))+" "+(resultSet.getString("STOCK_UOM_DESC")==null ? "":resultSet.getString("STOCK_UOM_DESC"));//Added for MMS-DM-CRF-0177
				FluidDetails.put("DRUG_DESC_NEW",drug_desc_new );//Added for MMS-DM-CRF-0177
				
				
				calc_dosg_by_freq_durn_yn = resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN");
				strength_value			  = resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE");
				strength_value			  = strength_value.trim();
				pres_base_uom			  = resultSet.getString("PRES_BASE_UOM");
				strength_uom			  = resultSet.getString("STRENGTH_UOM");
			}
			if(resultSet != null) {closeResultSet(resultSet);}
			if(pstmt	 != null) {closeStatement(pstmt);}

			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT2A"));
			pstmt.setString(1, fluidCode);
			pstmt.setString(2, getLanguageId());
			pstmt.setString(3, getLanguageId());
			resultSet	= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				FluidDetails.put("ORDER_CATALOG_CODE",(resultSet.getString("ORDER_CATALOG_CODE")==null ? "":resultSet.getString("ORDER_CATALOG_CODE")));
				FluidDetails.put("SHORT_DESC",(resultSet.getString("SHORT_DESC")==null ? "":resultSet.getString("SHORT_DESC")));
				FluidDetails.put("ORDER_TYPE_CODE",(resultSet.getString("ORDER_TYPE_CODE")==null ? "":resultSet.getString("ORDER_TYPE_CODE")));
				order_type_code= resultSet.getString("ORDER_TYPE_CODE");
				FluidDetails.put("SECURITY_LEVEL",(resultSet.getString("SECURITY_LEVEL")==null ? "":resultSet.getString("SECURITY_LEVEL")));
				FluidDetails.put("QTY_UOM",(resultSet.getString("QTY_UOM")==null ? "":resultSet.getString("QTY_UOM")));
//				split_dose_yn=resultSet.getString("SPLIT_DOSE_YN")==null ? "N":resultSet.getString("SPLIT_DOSE_YN");
				FluidDetails.put("SPLIT_DOSE_YN",(resultSet.getString("SPLIT_DOSE_YN")==null ? "N":resultSet.getString("SPLIT_DOSE_YN")));
				FluidDetails.put("SPLIT_DOSE","N");
				FluidDetails.put("TAPER_DOSE_YN",(resultSet.getString("TAPER_DOSE_YN")==null ? "":resultSet.getString("TAPER_DOSE_YN")));
				FluidDetails.put("BILL_YN",(resultSet.getString("BILL_YN")==null ? "":resultSet.getString("BILL_YN")));
				FluidDetails.put("QTY_REQD_YN",(resultSet.getString("QTY_REQD_YN")==null ? "N":resultSet.getString("QTY_REQD_YN")));
				FluidDetails.put("REFILL_CONT_ORDER_YN",(resultSet.getString("REFILL_CONT_ORDER_YN")==null ? "N":resultSet.getString("REFILL_CONT_ORDER_YN")));
				FluidDetails.put("CONSENT_REQD_YN",(resultSet.getString("CONSENT_REQD_YN")==null ? "N":resultSet.getString("CONSENT_REQD_YN")));
				FluidDetails.put("CHART_RESULT_TYPE",(resultSet.getString("CHART_RESULT_TYPE")==null ? "N":resultSet.getString("CHART_RESULT_TYPE")));
				FluidDetails.put("CHART_RESULT_TYPE",(resultSet.getString("CHART_RESULT_TYPE")==null ? "N":resultSet.getString("CHART_RESULT_TYPE")));
				FluidDetails.put("RESULT_AUTH_REQD_YN",(resultSet.getString("RESULT_AUTH_REQD_YN")==null ? "N":resultSet.getString("RESULT_AUTH_REQD_YN")));
               if(FluidDetails.get("CONSENT_REQD_YN").equals("Y")){
				   FluidDetails.put("CONSENT_STAGE",(resultSet.getString("CONSENT_STAGE")==null ?"":resultSet.getString("CONSENT_STAGE")) );
					if(resultSet.getString("CONSENT_STAGE")!=null && resultSet.getString("CONSENT_STAGE").equals("R"))
						FluidDetails.put("CONSENT_STATUS","P" );
					else
						FluidDetails.put("CONSENT_STATUS","");
					FluidDetails.put("NUM_OF_CONSENT_REQ_BO",(resultSet.getString("NUM_OF_CONSENT_REQ_BO")==null?"":resultSet.getString("NUM_OF_CONSENT_REQ_BO")) );
					FluidDetails.put("NUM_OF_CONSENT_REQ_BR",(resultSet.getString("NUM_OF_CONSENT_REQ_BR")==null?"":resultSet.getString("NUM_OF_CONSENT_REQ_BR")) );
			   }
			   else{
				    FluidDetails.put("CONSENT_STAGE","");
					FluidDetails.put("CONSENT_STATUS","");
					FluidDetails.put("NUM_OF_CONSENT_REQ_BO","");
					FluidDetails.put("NUM_OF_CONSENT_REQ_BR","");
			   }

             FluidDetails.put("ORDER_TYPE_DESC",resultSet.getString("ORDER_TYPE_DESC"));

			}
			if(resultSet != null) {
				closeResultSet(resultSet);
			}
			if(pstmt	 != null) {
				closeStatement(pstmt);
			}

			/*if(FluidDetails.get("CONSENT_REQD_YN").equals("Y")){
				pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT_CONSENT_DETAILS")) ;
				pstmt.setString(1,fluidCode);
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()) {
					FluidDetails.put("CONSENT_STAGE",(resultSet.getString("CONSENT_STAGE")==null ?"":resultSet.getString("CONSENT_STAGE")) );
					if(resultSet.getString("CONSENT_STAGE")!=null && resultSet.getString("CONSENT_STAGE").equals("R"))
						FluidDetails.put("CONSENT_STATUS","P" );
					else
						FluidDetails.put("CONSENT_STATUS","");
					FluidDetails.put("NUM_OF_CONSENT_REQ_BO",(resultSet.getString("NUM_OF_CONSENT_REQ_BO")==null?"":resultSet.getString("NUM_OF_CONSENT_REQ_BO")) );
					FluidDetails.put("NUM_OF_CONSENT_REQ_BR",(resultSet.getString("NUM_OF_CONSENT_REQ_BR")==null?"":resultSet.getString("NUM_OF_CONSENT_REQ_BR")) );

				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}catch(Exception es){
					es.printStackTrace() ;
				}
			}
			else{
				FluidDetails.put("CONSENT_STAGE","");
				FluidDetails.put("CONSENT_STATUS","");
				FluidDetails.put("NUM_OF_CONSENT_REQ_BO","");
				FluidDetails.put("NUM_OF_CONSENT_REQ_BR","");
			}

			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10C"));
			pstmt.setString(1, order_type_code);
			pstmt.setString(2, getLanguageId());
			resultSet	= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				FluidDetails.put("ORDER_TYPE_DESC",resultSet.getString("SHORT_DESC"));
			}

			if(resultSet != null) {closeResultSet(resultSet);}
			if(pstmt	 != null) {closeStatement(pstmt);}
			*/
/*
				FluidDetails.put("ORD_AUTH_REQD_YN","");
				FluidDetails.put("ORD_SPL_APPR_REQD_YN","");
				FluidDetails.put("ORD_COSIGN_REQD_YN","");
				FluidDetails.put("ORD_AUTHORIZED_YN","" );
				FluidDetails.put("ORD_APPROVED_YN","");
				FluidDetails.put("ORD_COSIGNED_YN","");
				FluidDetails.put("ORD_AUTHORIZED_PREV_YN","");
System.err.println("@@@IVFLUID fluidCode="+fluidCode+" patientClass="+patientClass+" getLanguageId()="+getLanguageId()+" resp_id="+resp_id+" pract_id="+pract_id+" getEncId()="+getEncId()+" login_facility_id="+login_facility_id);
				cstmt=connection.prepareCall("{call PH_ORDER_CATALOG_AUTH_RULE(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				cstmt.setString( 1, fluidCode);
				cstmt.setString( 2, patientClass);
				cstmt.setString( 3, getLanguageId());
				cstmt.setString( 4, resp_id);
				cstmt.setString( 5, pract_id);
				cstmt.setString( 6, "");
				cstmt.setString( 7, "PH");
				cstmt.registerOutParameter(8, Types.VARCHAR );
				cstmt.registerOutParameter(9, Types.VARCHAR );
				cstmt.registerOutParameter(10, Types.VARCHAR );
				cstmt.registerOutParameter(11, Types.VARCHAR );
				cstmt.registerOutParameter(12, Types.VARCHAR );
				cstmt.registerOutParameter(13, Types.VARCHAR );
				cstmt.execute() ;
		
				FluidDetails.put("ORD_AUTH_REQD_YN",(cstmt.getString(8)==null ? "":cstmt.getString(8)));
				FluidDetails.put("ORD_SPL_APPR_REQD_YN",(cstmt.getString(9)==null ? "":cstmt.getString(9)) );
				FluidDetails.put("ORD_COSIGN_REQD_YN",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );
				FluidDetails.put("ORD_AUTHORIZED_PREV_YN",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );
				FluidDetails.put("ORD_APPROVED_YN",(cstmt.getString(12)==null ? "":cstmt.getString(12)) );
				FluidDetails.put("ORD_COSIGNED_YN",(cstmt.getString(13)==null ? "":cstmt.getString(13)) );
				try{
					closeStatement( cstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
				//Code added for the CRF "PMG20089-CRF-0084"  Id:  3897 on 18-Sep-2008
				pstmt				= connection.prepareStatement("select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?") ;
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,getEncId());
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()) {
					FluidDetails.put("PAT_SPECIALTY_CODE",(resultSet.getString("SPECIALTY_CODE")==null ? "":resultSet.getString("SPECIALTY_CODE")) );
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
				cstmt=connection.prepareCall("{call OR_CHECK_SPLTY_FORCE_AUTH(?,?,?,?,?,?,?)}");
				cstmt.setString(1,pract_id);
				cstmt.setString(2,(String)FluidDetails.get("PAT_SPECIALTY_CODE"));
				cstmt.setString(3,fluidCode);
				cstmt.setString(4,(String)FluidDetails.get("ORD_AUTHORIZED_PREV_YN"));
				cstmt.registerOutParameter(5, Types.VARCHAR ); //P_FORCE_AUTH_yn
				cstmt.registerOutParameter(6, Types.VARCHAR ); //P_SPECIALITY_CODE
				cstmt.registerOutParameter(7, Types.VARCHAR ); //P_ALLOW_AUTH_YN 
				cstmt.execute();
		
				//FluidDetails.put("ORD_AUTH_REQD_YN",(cstmt.getString(5)==null ? "":cstmt.getString(5)));
				FluidDetails.put("CATALOG_SPLTY_CODE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
				FluidDetails.put("ORD_AUTHORIZED_YN",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );

				try{
					closeStatement( cstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
*/
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT3A"));
			pstmt.setString(1, fluidCode);
			pstmt.setString(2, patientClass);
			pstmt.setString(3, getLanguageId());
			resultSet	= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				FluidDetails.put("ACT_PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")) );
				//FluidDetails.put("ORD_AUTH_REQD_YN",(resultSet.getString("ORD_AUTH_REQD_YN")==null ? "N":resultSet.getString("ORD_AUTH_REQD_YN")));
				//FluidDetails.put("ORD_SPL_APPR_REQD_YN",(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null ? "N":resultSet.getString("ORD_SPL_APPR_REQD_YN")));
				//FluidDetails.put("ORD_COSIGN_REQD_YN",(resultSet.getString("ORD_COSIGN_REQD_YN")==null ? "N":resultSet.getString("ORD_COSIGN_REQD_YN")));
				FluidDetails.put("ORD_AUTH_LEVEL",(resultSet.getString("ORD_AUTH_LEVEL")==null ? "":resultSet.getString("ORD_AUTH_LEVEL")));
				FluidDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")));
				FluidDetails.put("FREQ_CODE",(resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")));
				FluidDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")));
				FluidDetails.put("DURN_TYPE",(resultSet.getString("DURN_TYPE")==null ? "":resultSet.getString("MAX_DURN_TYPE")));
				FluidDetails.put("CHK_FOR_MAX_DURN_ACTION",(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null ? "":resultSet.getString("CHK_FOR_MAX_DURN_ACTION")));
				FluidDetails.put("PROMPT_MSG",(resultSet.getString("PROMPT_MSG")==null ? "":resultSet.getString("PROMPT_MSG")));
				FluidDetails.put("MAX_DURN_VALUE",(resultSet.getString("MAX_DURN_VALUE")==null ? "":resultSet.getString("MAX_DURN_VALUE")));
				durn_value	= resultSet.getString("DURN_VALUE");
				freq_code	= resultSet.getString("FREQ_CODE");
				durn_type	= resultSet.getString("DURN_TYPE");
				qty_value	= resultSet.getString("QTY_VALUE");
			}

			if(resultSet != null) {closeResultSet(resultSet);}
			if(pstmt	 != null) {closeStatement(pstmt);}
			
			// To get make the orderset values as defualt when selected from orderSet


			if(orderSetValues.size() > 0){
				for(int i=0; i<orderSetValues.size(); i=i+8){

					if(orderSetValues.get(i).equals(fluidCode)){
						qty_value		 = (String)orderSetValues.get(i+1);
						orderSetQty_unit = (String)orderSetValues.get(i+2);
						freq_code		 = (String)orderSetValues.get(i+3);
						durn_value		 = (String)orderSetValues.get(i+4);
						durn_type		 = (String)orderSetValues.get(i+5);
					}
				}
			}

			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT4A"));
			pstmt.setString(1,fluidCode);
			pstmt.setString(2,getPatId());
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,fluidCode);
			pstmt.setString(5,getPatId());
			int rec_count	=0;
			resultSet		= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				rec_count=resultSet.getInt(1);
			}
            if(resultSet != null) {closeResultSet(resultSet);}
		    if(pstmt	 != null) {closeStatement(pstmt);}

			if(rec_count>0) {
				FluidDetails.put("ALLERGY_YN","Y");
			} else {
				FluidDetails.put("ALLERGY_YN","N");
				//Code Added for	RUT-CRF-0065 IN 29603 - Start
				String ATC_allergy="0";
				String atc_allergy_alert_level = getATCAllergyLevel();
				if(!atc_allergy_alert_level.equals("N")){
					pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL_ALLERGY_CHECK"));
					pstmt.setString(1,patient_id);
					pstmt.setString(2,generic_id);
					pstmt.setString(3,atc_allergy_alert_level);
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next())
						ATC_allergy = resultSet.getString("ATC_CHECK_EXISTS");
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					if(ATC_allergy!=null && !ATC_allergy.equals("0")){
						FluidDetails.put("ALLERGY_YN","Y");
					}
					else
						FluidDetails.put("ALLERGY_YN","N");
				}
				//Code Added for	RUT-CRF-0065 IN 29603 - End
			}
      
            if(resultSet != null) {closeResultSet(resultSet);}
		    if(pstmt	 != null) {closeStatement(pstmt);}

		    pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT5A"));
			  
				  
		    pstmt.setString(1, start_date);
		    pstmt.setString(2, start_date); 
			resultSet	= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()){
				if(!getLanguageId().equals("en")){
					FluidDetails.put("FUTURE_DATE",com.ehis.util.DateUtils.convertDate((resultSet.getString("FUTURE_DATE")),"DMYHM","en",getLanguageId()));
					FluidDetails.put("BACK_DATE",com.ehis.util.DateUtils.convertDate((resultSet.getString("BACK_DATE")),"DMYHM","en",getLanguageId()));				
				}
				else{
					FluidDetails.put("FUTURE_DATE",(resultSet.getString("FUTURE_DATE")));
					FluidDetails.put("BACK_DATE",(resultSet.getString("BACK_DATE")));
				}
			}

			if(resultSet != null) {closeResultSet(resultSet);}
			if(pstmt	 != null) {closeStatement(pstmt);}

			//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT6A"));
			pstmt		= connection.prepareStatement( "SELECT FREQ_CODE,FREQ_DESC,SCHEDULED_YN,FREQ_NATURE,REPEAT_VALUE, REPEAT_DURN_TYPE, INTERVAL_VALUE,INTERVAL_DURN_TYPE,DECODE(FREQ_NATURE,'F',(CASE WHEN INTERVAL_DURN_TYPE='H' AND REPEAT_DURN_TYPE ='H' AND REPEAT_VALUE =1 AND INTERVAL_VALUE <>0 THEN (24/INTERVAL_VALUE) WHEN INTERVAL_DURN_TYPE='H' AND REPEAT_DURN_TYPE ='H' AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (REPEAT_VALUE/INTERVAL_VALUE) WHEN INTERVAL_DURN_TYPE='M' AND REPEAT_DURN_TYPE ='M' AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (REPEAT_VALUE/INTERVAL_VALUE) WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE <>0 AND INTERVAL_VALUE =1 THEN REPEAT_VALUE WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE =1 AND INTERVAL_VALUE <>0 THEN (0) WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (0)  END),'I',(CASE WHEN INTERVAL_DURN_TYPE='H' AND REPEAT_DURN_TYPE ='H' AND REPEAT_VALUE =1 AND INTERVAL_VALUE <>0 THEN ceil(repeat_value / interval_value) WHEN INTERVAL_DURN_TYPE='H' AND REPEAT_DURN_TYPE ='H' AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (REPEAT_VALUE/INTERVAL_VALUE) WHEN INTERVAL_DURN_TYPE='M' AND REPEAT_DURN_TYPE ='M' AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (REPEAT_VALUE/INTERVAL_VALUE) WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE <>0 AND INTERVAL_VALUE =1 THEN REPEAT_VALUE WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE =1 AND INTERVAL_VALUE <>0 THEN (0) WHEN (INTERVAL_DURN_TYPE =('D') AND REPEAT_DURN_TYPE =('D') OR INTERVAL_DURN_TYPE =('W') AND REPEAT_DURN_TYPE =('W') OR INTERVAL_DURN_TYPE =('L') AND REPEAT_DURN_TYPE =('L')) AND REPEAT_VALUE <>0 AND INTERVAL_VALUE <>0 THEN (0)  END)) FREQ_VALUE FROM AM_FREQUENCY_LANG_VW AM_FREQUENCY WHERE FREQ_CODE =? AND LANGUAGE_ID = ? GROUP BY FREQ_CODE,FREQ_DESC,SCHEDULED_YN, FREQ_NATURE,REPEAT_VALUE, REPEAT_DURN_TYPE, INTERVAL_VALUE, INTERVAL_DURN_TYPE");
			pstmt.setString(1, freq_code);
			pstmt.setString(2, getLanguageId());
			resultSet	= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				FluidDetails.put("REPEAT_VALUE",(resultSet.getString("REPEAT_VALUE")));
				FluidDetails.put("INTERVAL_VALUE",(resultSet.getString("INTERVAL_VALUE")));
				FluidDetails.put("FREQ_NATURE",(resultSet.getString("FREQ_NATURE")));
				FluidDetails.put("FREQ_VALUE",(resultSet.getString("FREQ_VALUE")));
				FluidDetails.put("FREQ_DESC",(resultSet.getString("FREQ_DESC")));
				FluidDetails.put("SCHEDULED_YN",(resultSet.getString("SCHEDULED_YN")));
				FluidDetails.put("REPEAT_DURN_TYPE",(resultSet.getString("REPEAT_DURN_TYPE")));
				repeat_durn_type=resultSet.getString("REPEAT_DURN_TYPE");
				schedule_yn=resultSet.getString("SCHEDULED_YN");
				repeat_value=checkNullResult(resultSet.getString("REPEAT_VALUE"), "1");
			}
 
			if(resultSet != null) {closeResultSet(resultSet);}
			if(pstmt	 != null) {closeStatement(pstmt);}

			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7A"));
			pstmt.setString(1, repeat_durn_type);
			pstmt.setString(2, start_date);
			pstmt.setString(3, durn_value);
			pstmt.setString(4, repeat_durn_type);
			pstmt.setString(5, start_date);
			pstmt.setString(6, durn_value);
			pstmt.setString(7, repeat_durn_type);
			pstmt.setString(8, start_date);
			pstmt.setString(9, durn_value);
			resultSet	= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
			   if(!getLanguageId().equals("en")){
			      FluidDetails.put("END_DATE",com.ehis.util.DateUtils.convertDate(resultSet.getString("END_DATE"),"DMYHM","en",getLanguageId()));				   
			   }
			   else{
				  FluidDetails.put("END_DATE",(resultSet.getString("END_DATE")));
			   }
			}

			if(getOrder_type_flag().equals("Existing")){
			   if(!getLanguageId().equals("en")){
			      FluidDetails.put("START_DATE",com.ehis.util.DateUtils.convertDate(getSTART_DATE_TIME(),"DMYHM","en",getLanguageId()));				   
			   }else{
				  FluidDetails.put("START_DATE",getSTART_DATE_TIME());
			   }
			}
			else{
			   if(!getLanguageId().equals("en")){
			      FluidDetails.put("START_DATE",com.ehis.util.DateUtils.convertDate(start_date,"DMYHM","en",getLanguageId()));				   
			   }
			   else{
				  FluidDetails.put("START_DATE",start_date);
			   }
			}

			if(!getLanguageId().equals("en")){
				FluidDetails.put("END_DATE",com.ehis.util.DateUtils.convertDate(getEND_DATE_TIME(),"DMYHM","en",getLanguageId()));
			}
			else{
				FluidDetails.put("END_DATE",getEND_DATE_TIME());
			}
			if(!getLanguageId().equals("en")){
	    	    FluidDetails.put("START_DATE",com.ehis.util.DateUtils.convertDate(getSTART_DATE_TIME(),"DMYHM","en",getLanguageId()));				   
			}
			else{
				FluidDetails.put("START_DATE",getSTART_DATE_TIME());
			}

			if(resultSet != null) {closeResultSet(resultSet);}
			if(pstmt	 != null) {closeStatement(pstmt);}

			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT8A"));
			pstmt.setString(1, durn_type);
			pstmt.setString(2, getLanguageId());
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				FluidDetails.put("DURN_DESC",(resultSet.getString("DURN_DESC")));
				FluidDetails.put("OR_DURN_DESC",(resultSet.getString("DURN_DESC")));
			}

			// for order set dosage type
			if(orderSetValues.size() > 0){
				if(orderSetValues.get(0).equals(fluidCode)){
					FluidDetails.put("DOSAGE_TYPE","Q");
					FluidDetails.put("ORI_DOSAGE_TYPE","Q");
					dosage_type="Q";
				}
			}else{
				if(calc_dosg_by_freq_durn_yn==null || calc_dosg_by_freq_durn_yn.equals("N")) {
					/*FluidDetails.put("DOSAGE_TYPE","A");
					FluidDetails.put("ORI_DOSAGE_TYPE","A");
					dosage_type="A";*/
					//It is observed that, there is no concept "A"(absolute) in IV.So it is commented and new code added below (3 lines)-Abdul-28/07/10
					FluidDetails.put("DOSAGE_TYPE","Q");
					FluidDetails.put("ORI_DOSAGE_TYPE","Q");
					dosage_type="Q";
				} else {
					if(strength_value.equals("0")) {
						FluidDetails.put("DOSAGE_TYPE","Q");
						FluidDetails.put("ORI_DOSAGE_TYPE","Q");
						dosage_type="Q";
					} else {
						FluidDetails.put("DOSAGE_TYPE","S");
						FluidDetails.put("ORI_DOSAGE_TYPE","S");
						dosage_type="S";
					}
				}
			}

			String proc_qty_value="";

			// for order set dosage values.
			if(orderSetValues.size() > 0){
				if(orderSetValues.get(0).equals(fluidCode)){
					FluidDetails.put("QTY_VALUE",qty_value);
					FluidDetails.put("QTY_DESC_CODE","");
					qty_desc_code=orderSetQty_unit;
					proc_qty_value=qty_value;
				}
			}
			else{
				if(strength_value==null || strength_value.equals("0") || strength_value.equals("")) {
					FluidDetails.put("QTY_VALUE",qty_value);
					FluidDetails.put("QTY_DESC_CODE","");
					qty_desc_code=pres_base_uom;
					proc_qty_value=qty_value;
				} 
				else {
					FluidDetails.put("QTY_VALUE",strength_value);
					FluidDetails.put("QTY_DESC_CODE","");
					proc_qty_value=strength_value;
					qty_desc_code=strength_uom;
				}
			}

			if(resultSet != null) {closeResultSet(resultSet);}
			if(pstmt	 != null) {closeStatement(pstmt);}

			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT9A"));
			pstmt.setString(1, qty_desc_code);
			pstmt.setString(2, getLanguageId());
			resultSet	= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				FluidDetails.put("QTY_DESC",(resultSet.getString("SHORT_DESC")));
				FluidDetails.put("OR_QTY_DESC",(resultSet.getString("SHORT_DESC")));
			}

			if(resultSet != null) {closeResultSet(resultSet);}
			if(pstmt	 != null) {closeStatement(pstmt);}

			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT14A"));
			pstmt.setString(1, login_facility_id);
			resultSet			= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				FluidDetails.put("REFILL_YN",(resultSet.getString("REFILL_YN")==null ? "N":resultSet.getString("REFILL_YN")));
				FluidDetails.put("MAX_REFILLS_FOR_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_REFILLS_FOR_PRES")));
				FluidDetails.put("MAX_DURN_FOR_REFILL_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_DURN_FOR_REFILL_PRES")));
				FluidDetails.put("ALLOW_DUPLICATE_DRUG",(resultSet.getString("ALLOW_DUPLICATE_DRUG")==null ? "0":resultSet.getString("ALLOW_DUPLICATE_DRUG")));
				FluidDetails.put("ALLOW_DUPLICATE_DRUG_OP",(resultSet.getString("ALLOW_DUPLICATE_DRUG_OP")==null ? "0":resultSet.getString("ALLOW_DUPLICATE_DRUG_OP")));//IN30118-SCF No: MO-GN-5400. Assigning OutPatient Duplicate Drug Check.
			}
			
			if(resultSet != null) {closeResultSet(resultSet);}
			if(pstmt	 != null) {closeStatement(pstmt);}

			//call max dosage limit proc

			cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, fluidCode);
			cstmt.setString(2, patient_id);
			cstmt.setString(3, proc_qty_value);
			cstmt.setString(4, repeat_value);
			cstmt.setString(5, dosage_type);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.registerOutParameter(12, Types.VARCHAR);
			cstmt.execute();

			String limit_ind	= cstmt.getString(8);

			FluidDetails.put("LIMIT_IND",limit_ind);
			FluidDetails.put("DAILY_DOSE",(cstmt.getString(6)==null ? "0":cstmt.getString(6)));
			FluidDetails.put("UNIT_DOSE",(cstmt.getString(7)==null ? "0":cstmt.getString(7)));
			FluidDetails.put("MONO_GRAPH","");
			FluidDetails.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "0":cstmt.getString(10)));
			FluidDetails.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "0":cstmt.getString(11)) );
			FluidDetails.put("DOSAGE_UNIT",checkForNull(cstmt.getString(12)));
			if(limit_ind!=null && limit_ind.equals("N")) {

				/*FluidDetails.put("DAILY_DOSE", (cstmt.getString(6)==null ? "":cstmt.getString(6)));
				FluidDetails.put("UNIT_DOSE", (cstmt.getString(7)==null ? "":cstmt.getString(7)));
				FluidDetails.put("MIN_DAILY_DOSE", (cstmt.getString(10)==null ? "":cstmt.getString(10)));
				FluidDetails.put("MIN_UNIT_DOSE", (cstmt.getString(11)==null ? "":cstmt.getString(11)));
				FluidDetails.put("DOSAGE_UNIT", (cstmt.getString(12)==null ? "":cstmt.getString(12)));*/
				FluidDetails.put("MONO_GRAPH", (cstmt.getString(9)==null ? "":cstmt.getString(9)));
			}
			/*else {
				FluidDetails.put("DAILY_DOSE",(cstmt.getString(6)==null ? "0":cstmt.getString(6)));
				FluidDetails.put("UNIT_DOSE",(cstmt.getString(7)==null ? "0":cstmt.getString(7)));
				FluidDetails.put("MONO_GRAPH","");
				FluidDetails.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "0":cstmt.getString(10)));
				FluidDetails.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "0":cstmt.getString(11)) );
				FluidDetails.put("DOSAGE_UNIT", (cstmt.getString(12)==null ? "":cstmt.getString(12)));
			}*/

			int count_rx	= 0;
			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13"));
			pstmt.setString(1, getPatId());
			pstmt.setString(2, generic_id);
			pstmt.setString(3, (String)FluidDetails.get("START_DATE"));// Changed for ML-BRU-SCF-0811 [IN:039394]
			pstmt.setString(4, (String)FluidDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
			pstmt.setString(5, (String)FluidDetails.get("START_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
			pstmt.setString(6, (String)FluidDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
			pstmt.setString(7, (String)FluidDetails.get("START_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
			pstmt.setString(8, (String)FluidDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				count_rx=resultSet.getInt(1);
			}

			if(resultSet != null) {closeResultSet(resultSet);}
			if(pstmt	 != null) {closeStatement(pstmt);}

			if(count_rx>0) {
				FluidDetails.put("CURRENT_RX","Y");
			} else {
				FluidDetails.put("CURRENT_RX","N");
			}
			//calucalte total_qty

			if(dosage_type.equals("A")) {
				float total_qty=0.0f;
				if((qty_value!=null && !(qty_value.equals("")))) {
					total_qty=Float.parseFloat(qty_value);
				}
				FluidDetails.put("TOT_STRENGTH","0");
				FluidDetails.put("TOT_STRENGTH_UOM","");
				FluidDetails.put("DISPENSED_QTY",String.valueOf(total_qty));
				FluidDetails.put("DISPENSED_UOM",qty_desc_code);
				FluidDetails.put("BMS_QTY",String.valueOf(total_qty));
				FluidDetails.put("BMS_STRENGTH","");
				FluidDetails.put("PRES_QTY_VALUE",qty_value);
				FluidDetails.put("PRES_QTY_UOM",qty_desc_code);
			} 
			else if (dosage_type.equals("Q")) {
				float total_qty=0.0f;
				if((qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals(""))) ) {
					total_qty=Float.parseFloat(qty_value);
				}
				//get the conversion factor
				if(strength_value==null || strength_value.equals("0") || strength_value.equals("")) {
					FluidDetails.put("TOT_STRENGTH","0");
					FluidDetails.put("TOT_STRENGTH_UOM","");
					FluidDetails.put("EQUAL_VALUE","");
				} 
				else {
					String equal_value=(String)getConvFactor(strength_uom,qty_desc_code);
					float tot_strength=0.0f;
					if(equal_value!=null && !(equal_value.equals(""))) {
						tot_strength=total_qty*Integer.parseInt(equal_value);
					}

					FluidDetails.put("EQUAL_VALUE",equal_value);
					FluidDetails.put("TOT_STRENGTH",String.valueOf(tot_strength));
					FluidDetails.put("TOT_STRENGTH_UOM",strength_uom);
				}
				FluidDetails.put("DISPENSED_QTY",String.valueOf(total_qty));
				FluidDetails.put("DISPENSED_UOM",qty_desc_code);
				FluidDetails.put("BMS_QTY",String.valueOf(total_qty));
				FluidDetails.put("BMS_STRENGTH","");
				FluidDetails.put("STRENGTH_VALUE","0");
				FluidDetails.put("STRENGTH_UOM","");
				FluidDetails.put("PRES_QTY_VALUE",qty_value);
				FluidDetails.put("PRES_QTY_UOM",qty_desc_code);
			} 
			else if (dosage_type.equals("S")) {
				float total_qty=0.0f;
				if((qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals(""))) ) {
					total_qty=Float.parseFloat(qty_value);
				}
				FluidDetails.put("TOT_STRENGTH",String.valueOf(total_qty));
				FluidDetails.put("TOT_STRENGTH_UOM",qty_desc_code);
				FluidDetails.put("DISPENSED_QTY",String.valueOf(total_qty));
				FluidDetails.put("DISPENSED_UOM",qty_desc_code);
				FluidDetails.put("BMS_QTY",String.valueOf(total_qty));
				FluidDetails.put("BMS_STRENGTH","");
				FluidDetails.put("PRES_QTY_VALUE",qty_value);
				FluidDetails.put("PRES_QTY_UOM",qty_desc_code);
			}
			FluidDetails.put("REFILL_START_DATE","");
			FluidDetails.put("REFILL_END_DATE","");
			FluidDetails.put("AUTH_YN","N");
			FluidDetails.put("APPROVAL_YN","N");
			FluidDetails.put("COSIGN_YN","N");
			FluidDetails.put("ORD_AUTHORIZED_YN","N");
			FluidDetails.put("ORD_APPROVED_YN","N");
			FluidDetails.put("ORD_COSIGNED_YN","N");
			FluidDetails.put("ALLOW_REFILL","N");
			FluidDetails.put("NO_REFILL","0");
			FluidDetails.put("ADMIN_TIME","");
			FluidDetails.put("ADMIN_QTY","");
			FluidDetails.put("RECORD_GEN","");
			FluidDetails.put("ALLERGY_OVERRIDE","N");
			FluidDetails.put("DOSE_OVERRIDE","N");
			FluidDetails.put("CURRENTRX_OVERRIDE","N");
			FluidDetails.put("ALLERGY_REMARKS","");
			FluidDetails.put("DOSE_REMARKS","");
			FluidDetails.put("CURRENTRX_REMARKS","");
			FluidDetails.put("TAPPERED_OVER","N");
			FluidDetails.put("DFLT_QTY_UOM","");
			//Added for IN:072715 
			FluidDetails.put("ALLERGY_REMARKS_CODE", "");
			FluidDetails.put("DOSE_REMARKS_CODE", "");
			FluidDetails.put("CURRENTRX_REMARKS_CODE", "");
			//Added for IN:072715 
			//FluidDetails.put("BUILD_MAR_YN",getBuildMAR_yn());  CRF-0062 REMOVED AND ADDED BASED ON BUILD MAR RULE

			if((!dosage_type.equals("A")) &&  schedule_yn.equals("Y")) {
				FluidDetails.put("SCH_OVER_YN","Y");
			}
			else {
				FluidDetails.put("SCH_OVER_YN","N");
			}

			// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- Begin
			if(pat_class.equals("IP") && (take_home_medication.toUpperCase().equals("D") || take_home_medication.toUpperCase().equals("Y"))){
				pat_class="DM";
			}
			String Build_MAR_Rule=getMARDefaulting(pat_class,source_code,FluidDetails.get("FORM_CODE").toString(),priority);
			FluidDetails.put("BUILD_MAR_RULE",Build_MAR_Rule);
			if(Build_MAR_Rule.equals("CE")||Build_MAR_Rule.equals("CD"))
				FluidDetails.put("BUILD_MAR_YN","Y");
			else
				FluidDetails.put("BUILD_MAR_YN","N");
		}
		catch(Exception e) {
			FluidDetails.put("error",e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
	}

	public ArrayList getCompFluidDetails(String drug_code,String pract_id,String resp_id) throws Exception{
	
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet				= null;
		ArrayList dfltFluidDetails = new ArrayList();
		
		try{
			connection	= getConnection();
			//pstmt_select = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_COMP_FLUID_LIST_FOR_SINGLE_DRUG"));
			String sql_query = "select a.fluid_code, b.DRUG_DESC, B.CONTENT_IN_PRES_BASE_UOM, a.DEFAULT_YN, c.trade_code, (SELECT short_name FROM am_trade_name_lang_vw WHERE language_id = ? AND trade_id = c.trade_code) trade_name from PH_DRUG_COMPATIBILITY_FLUID a,PH_DRUG_LANG_VW B, ph_trade_name_for_drug c ,or_order_catalog d where a.fluid_code = c.drug_code(+) and c.eff_status(+)='E' and a.drug_code =? and a.fluid_code = b.DRUG_CODE and a.drug_code =d.order_catalog_code and B.LANGUAGE_ID = ? and a.eff_status='E' AND B.DISCONTINUED_YN='N' and or_get_priv_appl_yn(?,?,'OR',a.fluid_code,?,d.ORDER_TYPE_CODE,'PH') ='Y' order by 2";

			pstmt_select = connection.prepareStatement(sql_query);
			pstmt_select.setString(1, getLanguageId());
			pstmt_select.setString(2, drug_code);
			pstmt_select.setString(3, getLanguageId());
			pstmt_select.setString(4, pract_id); // COMMON-ICN-0184
			pstmt_select.setString(5, resp_id); // COMMON-ICN-0184
			pstmt_select.setString(6, drug_priv_appln_yn); // COMMON-ICN-0184
			resultSet	= pstmt_select.executeQuery();

			if(resultSet != null){
				while(resultSet.next()){
			
					dfltFluidDetails.add(checkNullResult(resultSet.getString(1), ""));
					dfltFluidDetails.add(checkNullResult(resultSet.getString(2), ""));
					dfltFluidDetails.add(checkNullResult(resultSet.getString(3), ""));
					dfltFluidDetails.add(checkNullResult(resultSet.getString(4), ""));
					dfltFluidDetails.add(checkNullResult(resultSet.getString(5), ""));
					dfltFluidDetails.add(checkNullResult(resultSet.getString(6), ""));
					dfltFluidDetails.add(checkNullResult(resultSet.getString(1),"")+checkNullResult(resultSet.getString(5), ""));
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet );
				closeStatement(pstmt_select);
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return dfltFluidDetails;
	}

	public ArrayList getCompFluidDetailsForMultipeDrugs(String sel_drg_codes,String pract_id,String resp_id){
		Connection connection		= null;
		CallableStatement	cstmt	= null ;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet				= null;
		String cmp_fld_codes		= "";
		String exist_test_str		= "";
		String curr_test_str		= "";
		String sql_str		= "";
		boolean exists_yn = false;
		ArrayList dfltFluidDetails = new ArrayList();
		try {
			connection	= getConnection();

			cstmt=connection.prepareCall("{call PH_Get_Fluid_Code (?,?)}");
			cstmt.setString( 1, sel_drg_codes.toString());
			cstmt.registerOutParameter(2, Types.VARCHAR );
			cstmt.execute() ;
			cmp_fld_codes = cstmt.getString(2)==null?"":cstmt.getString(2);
			if(!cmp_fld_codes.equals("")){
				//cmp_fld_codes= cmp_fld_codes.substring(1,cmp_fld_codes.length()-1);
				sql_str = "SELECT distinct  a.fluid_code,b.drug_desc, b.content_in_pres_base_uom, a.default_yn, c.trade_code, (SELECT short_name FROM am_trade_name_lang_vw WHERE language_id = ? AND trade_id = c.trade_code) trade_name FROM ph_drug_compatibility_fluid a, ph_drug_lang_vw b, ph_trade_name_for_drug c,or_order_catalog d WHERE a.fluid_code = c.drug_code(+) AND c.eff_status(+) = 'E' AND a.fluid_code = b.drug_code and a.drug_code =d.order_catalog_code  AND b.language_id = ? AND a.fluid_code  in (?) AND a.eff_status = 'E' AND b.discontinued_yn = 'N' and or_get_priv_appl_yn('"+ pract_id +"','"+ resp_id +"','OR',a.fluid_code,'"+drug_priv_appln_yn+"',d.ORDER_TYPE_CODE,'PH') ='Y' ORDER BY 2";

				sql_str = sql_str.substring(0,sql_str.lastIndexOf("?"))+cmp_fld_codes+sql_str.substring(sql_str.lastIndexOf("?")+1);
				//pstmt_select = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_COMP_FLUID_LIST_FOR_MULTI_DRUGS"));
				pstmt_select = connection.prepareStatement(sql_str);
				pstmt_select.setString(1, getLanguageId());
				//pstmt_select.setString(2, cmp_fld_codes);
				pstmt_select.setString(2, getLanguageId());
				resultSet	= pstmt_select.executeQuery();
				if(resultSet != null){
					while(resultSet.next()){
						exists_yn = false;
						for(int i=0; i<dfltFluidDetails.size();i+=7){
							exist_test_str = (String)dfltFluidDetails.get(i+6);
							curr_test_str = checkNullResult(resultSet.getString("fluid_code"), "")+checkNullResult(resultSet.getString("trade_code"),"");
							if(exist_test_str.equals(curr_test_str)){
								exists_yn = true;
								break;
							}
						}
						if(!exists_yn){
							dfltFluidDetails.add(checkNullResult(resultSet.getString("fluid_code"), ""));
							dfltFluidDetails.add(checkNullResult(resultSet.getString("drug_desc"), ""));
							dfltFluidDetails.add(checkNullResult(resultSet.getString("content_in_pres_base_uom"), ""));
							dfltFluidDetails.add(checkNullResult(resultSet.getString("default_yn"), ""));
							dfltFluidDetails.add(checkNullResult(resultSet.getString("trade_code"), ""));
							dfltFluidDetails.add(checkNullResult(resultSet.getString("trade_name"), ""));
							dfltFluidDetails.add(checkNullResult(resultSet.getString("fluid_code"), "")+checkNullResult(resultSet.getString("trade_code"), ""));
						}
					}
				}
				this.comptabile_fluid_yn = "Y";
			}
			else{
				this.comptabile_fluid_yn = "N";
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt_select);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return dfltFluidDetails;
	}

	public HashMap chkMaxDosageLimit(String drugCode,String patient_id,String qty_value,String dosage_type,String repeat_value, String factor){//Modified for IN:070451 added factor
		Connection connection       = null ;
        CallableStatement cstmt     = null ;
        ResultSet resultSet         = null ;
		HashMap dosage_dtl			= new HashMap();

		try{
			connection = getConnection() ;

			cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//Modified for IN:070451
			cstmt.setString( 1, drugCode);
			cstmt.setString( 2, patient_id);
			cstmt.setString( 3, qty_value);
			cstmt.setString( 4, repeat_value);//Modified for IN:070451
			cstmt.setString( 5, dosage_type);
			cstmt.registerOutParameter(6, Types.VARCHAR );
			cstmt.registerOutParameter(7, Types.VARCHAR );
			cstmt.registerOutParameter(8, Types.VARCHAR );
			cstmt.registerOutParameter(9, Types.VARCHAR );
			cstmt.registerOutParameter(10, Types.VARCHAR );
			cstmt.registerOutParameter(11, Types.VARCHAR );
			cstmt.registerOutParameter(12, Types.VARCHAR );
			//Added for IN:070451 start
			cstmt.registerOutParameter(13, Types.VARCHAR );
			cstmt.registerOutParameter(14, Types.VARCHAR );
			cstmt.registerOutParameter(15, Types.VARCHAR );
			cstmt.registerOutParameter(16, Types.VARCHAR );
			cstmt.setString( 17, factor);
			//Added for IN:070451 end
			cstmt.execute() ;

			String limit_ind	= cstmt.getString( 8 );
			dosage_dtl.put("LIMIT_IND",limit_ind);
			dosage_dtl.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
			dosage_dtl.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );
			dosage_dtl.put("MONO_GRAPH","");
			dosage_dtl.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );
			dosage_dtl.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );
			if(limit_ind!=null && limit_ind.equals("N")){
				/*dosage_dtl.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
				dosage_dtl.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );
				dosage_dtl.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );
				dosage_dtl.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );*/
				dosage_dtl.put("MONO_GRAPH",(cstmt.getString(9)==null ? "":cstmt.getString(9)) );

			}
			/*else{
				dosage_dtl.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
				dosage_dtl.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );
				dosage_dtl.put("MONO_GRAPH",(cstmt.getString(9)==null ? "":cstmt.getString(9)));
				dosage_dtl.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );
				dosage_dtl.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );
			}*/
			try{
				closeStatement( cstmt ) ;
			}catch(Exception es){
				es.printStackTrace() ;
			}
		 }catch ( Exception e ) {
			dosage_dtl.put("error",e);
			e.printStackTrace() ;

		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return dosage_dtl;
	}

	public HashMap getAuthorizationReqd(String resp_id, String pract_id) throws Exception {
		Connection connection 	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet 	= null;
		HashMap authValues		= new HashMap();

 		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT50"));
			pstmt.setString(1,pract_id);
			pstmt.setString(2,resp_id);
			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				authValues.put("AUTH_YN",(resultSet.getString("AUTH_YN")==null ? "N":resultSet.getString("AUTH_YN")));
			}else{
                authValues.put("AUTH_YN", "N");
			}

			if(resultSet != null) {closeResultSet(resultSet);}
			if(pstmt	 != null) {closeStatement(pstmt);}

			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT50A"));
			pstmt.setString(1,pract_id);
			pstmt.setString(2,resp_id);
			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				authValues.put("SPL_APPR_YN",(resultSet.getString("SPL_APPR_YN")==null ? "N":resultSet.getString("SPL_APPR_YN")));
			}else{
                 authValues.put("SPL_APPR_YN", "N");
			}

			if(resultSet != null) {closeResultSet(resultSet);}
			if(pstmt	 != null) {closeStatement(pstmt);}

			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT50B"));
			pstmt.setString(1,pract_id);
			pstmt.setString(2,resp_id);
			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				authValues.put("COSIGN_YN",(resultSet.getString("COSIGN_YN")==null ? "N":resultSet.getString("COSIGN_YN")));
			}else{
                 authValues.put("COSIGN_YN", "N");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			authValues.put("error", e);
		}
		finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return authValues;
	}

	public Hashtable loadQtyDetails(String form_code) {
		Hashtable qty_values	= new Hashtable();
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String uom_code			= "";
		String uom_desc			= "";
		String dflt_uom_yn		= "";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT12A"));
			pstmt.setString(1,form_code);
			pstmt.setString(2, getLanguageId());
			pstmt.setString(3,form_code);
			pstmt.setString(4,form_code);
			pstmt.setString(5,form_code);
			pstmt.setString(6, getLanguageId());
			pstmt.setString(7,form_code);
			pstmt.setString(8,form_code);
			pstmt.setString(9,form_code);
			pstmt.setString(10, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet != null && resultSet.next()) {
				uom_code	=	resultSet.getString("UOM_CODE");
				uom_desc	=	resultSet.getString("SHORT_DESC");
				dflt_uom_yn =	resultSet.getString("QTY_UOM_YN");

				if(dflt_uom_yn.equals("Y")) {
					qty_values.put("dflt_code", uom_code);
				}
				qty_values.put(uom_code, uom_desc);
			}
		}
		catch(Exception e) {
			qty_values.put("Exception", e.toString());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				qty_values.put("Exception",es.toString());
			}
		}
		return qty_values;
	}

/* The following function is to fetch the quantity unit of measurement for a given drug given in the drug master table. added on 30-10-2004 by srijagadeesh.*/

	public Hashtable listQtyDetails(String drug_code) {
		Hashtable qty_values	= new Hashtable();
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String uom_code			= "";
		String uom_desc			= "";
		String dflt_uom_yn		= "";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT15A"));
			pstmt.setString(1,drug_code);
			pstmt.setString(2,drug_code);
			pstmt.setString(3, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet != null && resultSet.next()) {
				uom_code	=	resultSet.getString("UOM_CODE");
				uom_desc	=	resultSet.getString("SHORT_DESC");
				dflt_uom_yn =	resultSet.getString("QTY_UOM_YN");

				if(dflt_uom_yn.equals("Y")) {
					qty_values.put("dflt_code", uom_code);
				}
				qty_values.put(uom_code, uom_desc);
			}
		}
		catch(Exception e) {
			qty_values.put("Exception", e.toString());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				qty_values.put("Exception",es.toString());
			}
		}
		return qty_values;
	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap();
		map.put("result", new Boolean(true ));
		map.put("message", "success..");

		return map;
	}


	public HashMap getFluidDetails() {
		return this.FluidDetails;
	}

	public HashMap ivFluidsInsert() {	

		HashMap map=new HashMap();			
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in modify.." ) ;
		map.put( "flag", "0" ) ;
	
		Connection connection					= null;
		PreparedStatement pstmt_select			= null;
		CallableStatement cstmt_insert			= null;  
		ResultSet resultSet						= null;
		String freq_code						=	"";

		String patient_id					=	getPatId();
		String patient_class				=	getPatientClass();
		String encounter_id					=	getEncId();
		try {
			connection			=	getConnection();

			String perf_locn_code	=	"";
			String perf_locn_type	=	"";
		//	String per_facility_id  =   "";  Removed for IN063877
			/*if(license!=null && !license.equals("PHBASIC")) {
				cstmt_insert = connection.prepareCall("{call PH_RET_DISPLOCNIV(?,?,?,?,?,?,?)}");
				cstmt_insert.setString(1, login_facility_id);
				cstmt_insert.setString(2, locn_type);
				cstmt_insert.setString(3, locn_code);
				cstmt_insert.setString(4, "N");
				cstmt_insert.setString(5, getPriority());
				cstmt_insert.registerOutParameter(6, Types.VARCHAR);
				cstmt_insert.registerOutParameter(7, Types.VARCHAR);
				cstmt_insert.execute();
				perf_locn_code	= cstmt_insert.getString(6);
				perf_locn_type	= cstmt_insert.getString(7);

			} else {
				perf_locn_code	= locn_code;
				perf_locn_type	= locn_type;
			}*/



		//	if(license!=null && !license.equals("PHBASIC")) { //commented for SKR-SCF-0356
			if(getLicense()!=null && !getLicense().equals("PHBASIC")){ //newly added for SKR-SCF-0356
				//cstmt_insert = connection.prepareCall("{call PH_RET_DISPLOCNIV(?,?,?,?,?,?,?)}");
				/*cstmt_insert=connection.prepareCall("{call Ph_Ret_Spl_Ord_Disp_Locn(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); // 12th parameter added for Bru-HIMS-CRF-347 [IN:037862]
				cstmt_insert.setString(1, login_facility_id);
				cstmt_insert.setString(2, locn_type);
				cstmt_insert.setString(3, locn_code);
				cstmt_insert.setString(4, "N");				
				cstmt_insert.setString(5, getPriority());


				cstmt_insert.setString(6, "5");
				cstmt_insert.setString(7, getLanguageId());
				cstmt_insert.registerOutParameter(8, Types.VARCHAR);
				cstmt_insert.registerOutParameter(9, Types.VARCHAR);
				cstmt_insert.registerOutParameter(10, Types.VARCHAR);
				cstmt_insert.registerOutParameter(11, Types.VARCHAR);
				cstmt_insert.setString(12,""); // added for Bru-HIMS-CRF-347 [IN:037862]
				cstmt_insert.setString(13,getPatId());//added for MMS-QH-CRF-0048 [IN:037704]
			    cstmt_insert.setString(14,getEncId());//added for MMS-QH-CRF-0048 [IN:037704]
				cstmt_insert.execute();

				perf_locn_code	= cstmt_insert.getString(8);
				perf_locn_type  = cstmt_insert.getString(9); 
				per_facility_id = cstmt_insert.getString(11); 
			
				if(cstmt_insert != null) {
					closeStatement(cstmt_insert);
					cstmt_insert=null;
				}*/ //Commented and values passed at fluid level - Bru-HIMS-CRF-347 [IN:037862]
			}
			else {
				perf_locn_code	= locn_code;
				perf_locn_type	= locn_type;
				
			}

			/*pstmt_select	=	null;
			pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54"));
			resultSet		= pstmt_select.executeQuery();

			if (resultSet.next()) {
				sys_date = resultSet.getString("SYS_DATE_TIME");
			}*/
			
			ArrayList frequency	=	getFrequency();
			//Added for Bru-HIMS-CRF-393_1.0-Start
			HashMap record=new HashMap();
			String order_type="";
			HashSet keyset=new HashSet();
			for(int i=0; i<AllFluids.size(); i++ ){
				record		=	(HashMap)AllFluids.get(i);
				order_type	=	(String)record.get("ORDER_TYPE_CODE");
				keyset.add(order_type);
			}
			setPrintOrdShtRuleInd(keyset,getPatientClass());
			//Added for Bru-HIMS-CRF-393_1.0-End
			if(frequency.size() > 0 ) {
				freq_code	=	(String)frequency.get(0);
			}	

			// used while printing report
			setIVPrep("5");
			/*if(!getLanguageId().equals("en")){
				this.order_date = com.ehis.util.DateUtils.convertDate(this.getOrderDate(),"DMYHM",getLanguageId(),"en");
			}
			//order_date is stored as english. so no change is need.- abdul-22/7/2010. */ 

			HashMap tabData = new HashMap();
		
			//tabData.put("perf_locn_code",perf_locn_code);  Commented and values passed at fluid level - Bru-HIMS-CRF-347 [IN:037862]
			//tabData.put("perf_locn_type",perf_locn_type);
			tabData.put("sys_date",this.getOrderDate());
			tabData.put("patient_id",patient_id);
			tabData.put("patient_class",patient_class);
			tabData.put("encounter_id",encounter_id);
			tabData.put("AllFluids",AllFluids);
			tabData.put("freq_code", freq_code);
			tabData.put("locn_type", locn_type);
			tabData.put("locn_code", locn_code);
			tabData.put("pract_id", pract_id);		
			tabData.put("priority", getPriority());		
			tabData.put("diag_Text", getDiagText());		
			tabData.put("PROPERTIES", getProperties());
			tabData.put("height",height);
			tabData.put("height_uom",height_uom);
			tabData.put("weight",weight);
			tabData.put("weight_uom",weight_uom);
			tabData.put("bsa",bsa);
			tabData.put("bmi",bmi);
			tabData.put("login_facility_id",login_facility_id);
			tabData.put("login_by_id",login_by_id);
			tabData.put("login_at_ws_no",login_at_ws_no);
			tabData.put("allergic_yn",allergic_yn);
			tabData.put("remarks",AmendOrderRemarks);
			tabData.put("lang_id",getLanguageId());
			//tabData.put("per_facility_id",per_facility_id);
			tabData.put("TAKEHOME_MEDN",getTakeHomeMedication());   // CRF-0062
			tabData.put("BUILD_MAR_YN",getBuildMAR_yn());  // CRF-0062  BUILD_MAR_YN Value will be inserted to all the fluids based on the first fluid selected. 
			tabData.put("print_mar_barcode_yn",getPrintMarBarcode()); //Added for MMS-QH-CRF-0080 [IN:038064]
			tabData.put("print_mar_label_yn",getPrintMarLabel());//Added for MMS-QH-CRF-0080 [IN:038064]
			tabData.put("iv_calc_infuse_by",getIVCalcInfuseBy());//Added for SKR-CRF-0035
			HashMap sqlMap	=	new HashMap();
			sqlMap.put("SQL_PH_IVPRESCRIPTION_SELECT2",PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT2"));
			sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT1",PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT1"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT2",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT2A"));		
//			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT3A",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT3A"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT3A","INSERT INTO OR_ORDER_LINE_PH(ORDER_ID,ORDER_LINE_NUM,GENERIC_ID,FORM_CODE,TRADE_CODE,FORMULARY_ITEM_YN,DOSAGE_TYPE,SPLIT_DRUG_PREVIEW,TOT_STRENGTH,TOT_STRENGTH_UOM,INFUSE_OVER,INFUSE_OVER_UNIT,INFUSION_RATE,INFUSION_VOL_STR_UNIT,INFUSION_PER_UNIT,BROUGHT_BY_PATIENT_YN,CUR_DRUG_YN,REFILL_DRUG_YN,DISPENSING_LOC_TYPE,DISPENSING_LOC,DISPENSING_STORE,IP_FILL_PROCESS,IP_FILL_PRD_AHEAD,NEXT_FILL_DATE,LAST_FILL_QTY,DISPENSED_QTY,BMS_QTY,BMS_STRENGTH,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SPLIT_DOSE_YN,QTY_VALUE_SPLIT_DOSE,QTY_UNIT_SPLIT_DOSE,STRENGTH_VALUE,STRENGTH_UOM,PRES_QTY_VALUE,PRES_QTY_UOM,ALLERGY_OVERRIDE_REASON,DOSAGE_LIMIT_OVERRIDE_REASON,DUPLICATE_DRUG_OVERRIDE_REASON,TOT_INFUSION_OVER, TOT_INFUSION_OVER_UNIT,ADMIN_RATE_DETAIL,CHNGD_FLUID_REMARKS,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,BUILD_MAR_YN,MFR_YN,MFR_REMARKS,ORIG_INFUSE_OVER,ORIG_INFUSION_RATE,DRUG_INDICATION,PRES_INFUSION_RATE,PRES_INFUSION_QTY_UNIT, MAR_BARCODE_ID,ALLOW_ALTERNATE_YN,ABUSE_EXISTS,ABUSE_DRUG_OVERRIDE_REASON) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938] & SKR-SCF-0543 [IN:033153] Added Column PRES_INFUSION_RATE , PRES_INFUSION_QTY_UNIT,Modified for IN:073352 removed ALLERGY_OVERRIDE_REASON_CODE,DOSE_LIMIT_OVER_REASON_CODE,DUP_DRUG_OVERRIDE_REASON_CODE
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT4",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT4"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT55",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT55"));		
			sqlMap.put("SQL_PH_IVPRESCRIPTION_SELECT8",PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT8"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT25A",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT25A"));		
			sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT2",PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT2"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT72",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT72"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT73",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT73"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT9",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT9"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_MODIFY6",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY6"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT10",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT10"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_MODIFY7",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY7"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT74",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT74"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT75",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT75"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT11",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT11"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_MODIFY8",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY8"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT12",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT12"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_MODIFY9",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY9"));				
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT56",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT5",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT57",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57"));	
			sqlMap.put("SQL_PH_AMEND_IVPRES_SELECT2",PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES_SELECT2"));
			sqlMap.put("SQL_PH_AMEND_IVPRES_SELECT3",PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES_SELECT3"));
		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT53",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53"));
			sqlMap.put("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT"));
			sqlMap.put("SQL_PH_IVPRESCRIPTION_MFR_INSERT",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_MFR_INSERT"));// OR_ORDER_LINE_PH_MFR
			sqlMap.put( "SQL_PH_GEN_MARDARCODEID",PhRepository.getPhKeyValue("SQL_PH_GEN_MARDARCODEID") );  //added for  MMS-QH-CRF-0080 [IN:038064]

		//	sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT_CONSENT_DETAILS",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT_CONSENT_DETAILS") );

			String result	=	validateFluidStock(tabData,AllFluids);

			if((result.trim()).equals("")) {

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_IVPRESCRIPTION" ),IVPrescriptionHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				map = (HashMap)(busObj.getClass().getMethod("ivFluidsInsert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if(((Boolean) map.get("result")).booleanValue() ) {
					map.put("message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH"));
					setTrnGroupRef((String)map.get("trn_group_ref"));
					setTokensGeneratedYN((String)map.get("tokens_generated_yn"));

				}
				else {
					map.put("message", map.get("msgid"));
				}
			} 
			else {
				map.put("result", new Boolean(false));
				map.put("message", result);
				map.put("flag", "INSUFFICIENT_STOCK");
			}

		}
		catch (Exception e) {
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				  closeStatement( pstmt_select ) ;
				  closeStatement( cstmt_insert ) ;
				  closeResultSet( resultSet ) ;			 
				  closeConnection( connection );
			}
			catch(Exception ee ) {
				ee.printStackTrace();
				map.put("message", ee.getMessage());
			}
		}
		return map;
	}

	public HashMap ivFluidsModify(){	
	
		HashMap map=new HashMap();			
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in modify.." ) ;
		map.put( "flag", "0" ) ;
	
		Connection connection					= null;

		PreparedStatement pstmt_select			= null;
		CallableStatement cstmt_insert			= null;  
		ResultSet resultSet						= null;
		String freq_code						=	"";
		String patient_id					=	getPatId();
		String patient_class				=	getPatientClass();
		String encounter_id					=	getEncId();

		try {
			connection			=	getConnection();

			String perf_locn_code	=	"";
			String perf_locn_type	=	"";
			if(license!=null && !license.equals("PHBASIC")) {
				cstmt_insert = connection.prepareCall("{call PH_RET_DISPLOCNIV(?,?,?,?,?,?,?)}");
				cstmt_insert.setString(1, login_facility_id);
				cstmt_insert.setString(2, locn_type);
				cstmt_insert.setString(3, locn_code);
				cstmt_insert.setString(4, "N");
				cstmt_insert.setString(5, getPriority());
				cstmt_insert.registerOutParameter(6, Types.VARCHAR);
				cstmt_insert.registerOutParameter(7, Types.VARCHAR);
				cstmt_insert.execute();

				perf_locn_code	= cstmt_insert.getString(6);
				perf_locn_type	= cstmt_insert.getString(7);
			} 
			else {
				perf_locn_code	= locn_code;
				perf_locn_type	= locn_type;
			}

			/*pstmt_select	=	null;
			pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54"));
			resultSet		= pstmt_select.executeQuery();

			if (resultSet.next()) {
				sys_date = resultSet.getString("SYS_DATE_TIME");
			}*/
			
			ArrayList frequency	=	getFrequency();
			if(frequency.size() > 0 ) {
				freq_code	=	(String)frequency.get(0);
			}	

			// used while printing report
			setIVPrep("5");
			if(!getLanguageId().equals("en")){
				this.order_date = com.ehis.util.DateUtils.convertDate(this.getOrderDate(),"DMYHM",getLanguageId(),"en");
			}
			
			HashMap record=new HashMap(); //Added for Bru-HIMS-CRF-393_1.0-Start
			String order_type="";
			HashSet keyset=new HashSet();
			for(int i=0; i<AllFluids.size(); i++ ){
				record		    =	(HashMap)AllFluids.get(i);
				order_type	    =	(String)record.get("ORDER_TYPE_CODE");
				keyset.add(order_type);
			}
			setPrintOrdShtRuleInd(keyset,getPatientClass()); //Added for Bru-HIMS-CRF-393_1.0-End
			HashMap tabData = new HashMap();
			tabData.put("order_id",getOrderID());
			tabData.put("perf_locn_code",perf_locn_code);
			tabData.put("perf_locn_type",perf_locn_type);
			tabData.put("sys_date",this.getOrderDate());
			tabData.put("patient_id",patient_id);
			tabData.put("patient_class",patient_class);
			tabData.put("encounter_id",encounter_id);
			tabData.put("AllFluids",AllFluids);
			tabData.put("freq_code", freq_code);
			tabData.put("locn_type", locn_type);
			tabData.put("locn_code", locn_code);
			tabData.put("pract_id", pract_id);		
			tabData.put("priority", getPriority());		
			tabData.put("diag_Text", getDiagText());		
			tabData.put("PROPERTIES", getProperties());
			tabData.put("height",height);
			tabData.put("height_uom",height_uom);
			tabData.put("weight",weight);
			tabData.put("weight_uom",weight_uom);
			tabData.put("bsa",bsa);
			tabData.put("bmi",bmi);
			tabData.put("login_facility_id",login_facility_id);
			tabData.put("login_by_id",login_by_id);
			tabData.put("login_at_ws_no",login_at_ws_no);
			tabData.put("allergic_yn",allergic_yn);
			tabData.put("remarks",AmendOrderRemarks);
			tabData.put("lang_id",getLanguageId());
			tabData.put("BUILD_MAR_YN",getBuildMAR_yn());  //RUT-CRF-0062
			/*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/
			ArrayList reason	=	null;
			String reason_code	=	"";
			String reason_desc	=	"";
			
			if(presbeanobj!=null){	
				if( (presbeanobj.getCalledFromAmend()).equals("PH") )  
					 reason	= presbeanobj.getAmendReasonTemp(getOrderID());
				else 
					 reason	= presbeanobj.getAmendReason(getOrderID());
									
					if(reason!=null && reason.size() > 1 ) {
					reason_code		=	(String)reason.get(1);
					reason_desc		=	(String)reason.get(2);							
				}
			}
			
			tabData.put("AMEND_REASON_CODE",reason_code);  
			tabData.put("AMEND_REASON",reason_desc);  
			tabData.put("print_mar_barcode_yn",getPrintMarBarcode()); //Added for MMS-QH-CRF-0080 [IN:038064]
			tabData.put("print_mar_label_yn",getPrintMarLabel());//Added for MMS-QH-CRF-0080 [IN:038064]
			tabData.put("iv_calc_infuse_by",getIVCalcInfuseBy());//Added for SKR-CRF-0035
				
			/*IN066779 Starts*/
			ArrayList AMNDreason	=	null;
			String amnd_Reason="";
			String amend_Order_Id="";
			System.out.println("getOrderID()---------"+getOrderID());
			if( getCalledFromAmend().equals("PH") )
				AMNDreason=getAmendReasonTemp(getOrderID());
			else
				AMNDreason=getAmendReason1(getOrderID());
			
			amend_Order_Id=(String)AMNDreason.get(0);
			amnd_Reason=(String)AMNDreason.get(2);
			
			tabData.put("AMEND_ORDER_ID",amend_Order_Id);
			tabData.put("AMEND_ORDER_REASON",amnd_Reason);
			
			/*IN066779 ends*/
			
			/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/
			HashMap sqlMap	=	new HashMap();
			sqlMap.put("SQL_PH_IVPRESCRIPTION_SELECT2",PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT2"));
			sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE1",PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE1"));		
			sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE5",PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE5"));		
			//sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE3",PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE3"));		
			//added for aakh-crf-0140
			sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE3","UPDATE OR_ORDER_LINE_PH SET SPLIT_DRUG_PREVIEW=?,TOT_STRENGTH=?,TOT_STRENGTH_UOM=?,INFUSE_OVER=?,INFUSE_OVER_UNIT=?,INFUSION_RATE=?,INFUSION_VOL_STR_UNIT=?,INFUSION_PER_UNIT=?,BMS_QTY=?,BMS_STRENGTH=?,SPLIT_DOSE_YN=?,PRES_QTY_VALUE=?,PRES_QTY_UOM=?,TOT_INFUSION_OVER=?,TOT_INFUSION_OVER_UNIT=?,AMEND_REASON_CODE=?,AMEND_REASON=?,CHNGD_FLUID_REMARKS=?,ADMIN_RATE_DETAIL=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,MFR_REMARKS=?,ORIG_INFUSE_OVER=?,ORIG_INFUSION_RATE=?,BUILD_MAR_YN=?,AMENDED_BY_ID =?,AMENDED_DATE =SYSDATE,DRUG_INDICATION=? , PRES_INFUSION_RATE=? , PRES_INFUSION_QTY_UNIT=? ,ABUSE_EXISTS=?,ABUSE_DRUG_OVERRIDE_REASON=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=? ");//MFR_REMARKS,ORIG_INFUSE_OVER,ORIG_INFUSION_RATE,AMENDED_BY_ID and AMENDED_DATE added for ML-BRU-SCF-0098 [IN031837] & DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938] & SKR-SCF-0543 [IN:033153] Added Column PRES_INFUSION_RATE , PRES_INFUSION_QTY_UNIT	
			
			sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE4",PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE4"));	
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT55",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT55"));		
			sqlMap.put("SQL_PH_IVPRESCRIPTION_SELECT8",PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT8"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT25A",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT25A"));

			sqlMap.put("SQL_PH_IVPRESCRIPTION_DELETE_MEDN_ADMIN",PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_DELETE_MEDN_ADMIN"));
			sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT2",PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT2"));

			sqlMap.put("SQL_PH_IVPRESCRIPTION_DELETE_OR_ORDER_COMMENT",PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_DELETE_OR_ORDER_COMMENT"));
		  
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT72",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT72"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT73",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT73"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT74",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT74"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT75",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT75"));		
			
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT56",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT5",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5"));		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT57",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57"));		

			sqlMap.put("SQL_PH_AMEND_IVPRES_SELECT2",PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES_SELECT2"));
			sqlMap.put("SQL_PH_AMEND_IVPRES_SELECT3",PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES_SELECT3"));
		
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT53",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53"));
			sqlMap.put("SQL_PH_IVPRESCRIPTION_MFR_DELETE", "DELETE FROM OR_ORDER_LINE_PH_MFR WHERE ORDER_ID=?");
			sqlMap.put("SQL_PH_IVPRESCRIPTION_MFR_INSERT",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_MFR_INSERT"));// OR_ORDER_LINE_PH_MFR 

			String result	=	validateFluidStock(tabData,AllFluids);

			if((result.trim()).equals("")) {

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_IVPRESCRIPTION" ),IVPrescriptionHome.class,getLocalEJB());

				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;
				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				map = (HashMap)(busObj.getClass().getMethod("ivFluidsModify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if(((Boolean) map.get("result")).booleanValue() ) {
					map.put("message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH"));

				} 
				else {
					map.put("message", map.get("msgid"));
				}
			} 
			else {
				map.put("result", new Boolean(false));
				map.put("message", result);
				map.put("flag", "INSUFFICIENT_STOCK");
			}

		}
		catch (Exception e) {
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				  closeStatement( pstmt_select ) ;
				  closeStatement( cstmt_insert ) ;
				  closeResultSet( resultSet ) ;			 
				  closeConnection( connection );
			}
			catch(Exception ee ) {
				ee.printStackTrace();
				map.put("message", ee.getMessage());
			}
		}
		return map;
	}

	public HashMap insert() {	
	
		HashMap map=new HashMap();			

		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in modify.." ) ;
		map.put( "flag", "0" ) ;	

		return map;
	}

	public HashMap delete() {	
	
		HashMap map=new HashMap();			
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in modify.." ) ;
		map.put( "flag", "0" ) ;	

		return map;
	}

	public void clearscheduleFrequency(String code){
		if(scheduleFrequency.containsKey(code)) {
			scheduleFrequency.remove(code);
		}
	}

	public void resetscheduleFrequency() {
		this.scheduleFrequency = new HashMap();
	}

	public boolean setScheduleFrequencyStr(Hashtable ht) {
		try {
			//System.out.println("ht at 4904 in setScheduleFrequencyStr of IVPresBean ---|"+ht);
		/*	String code 			= (String)ht.get("code");
			String duration_type 	= (String)ht.get("durationType");
			int repeat				= Integer.parseInt((String)ht.get("repeat"));
			String row_value		= (String)ht.get("row_value");
			scheduleFrequency		= new HashMap();
			ArrayList scheduleFrequencyDatas = new ArrayList();

			for(int j=1; j <= repeat; j++) {
		
				HashMap hashMap	= new HashMap();
				hashMap.put("admin_day_or_time","H");
				hashMap.put("duration_type",duration_type);
				hashMap.put("start_time_assign","");
				hashMap.put("repeat",String.valueOf(repeat));
				hashMap.put("row_value",row_value);
				hashMap.put("admin_time",(String)ht.get("time"+j));
				hashMap.put("admin_qty",(String)ht.get("qty"+j));
				scheduleFrequencyDatas.add(hashMap);
			}
			scheduleFrequency.put(code,scheduleFrequencyDatas); 
			return true;*/
			
			String code 			= (String)ht.get("code");

		/*	String duration_type 	= (String)ht.get("durationType");
			int repeat				= Integer.parseInt((String)ht.get("repeat"));
			String row_value		= (String)ht.get("row_value");		*/
			ArrayList scheduleFrequencyDatas	=	new ArrayList();
			scheduleFrequencyDatas	=	(ArrayList)ht.get(code);
			if (scheduleFrequencyDatas == null){
				scheduleFrequencyDatas	=	new ArrayList();
				String duration_type 	= (String)ht.get("durationType");
				int repeat        		=  Integer.parseInt(checkForNull((String)ht.get("repeat"),"0"));
				//String row_value		= (String)ht.get("row_value");	
				ArrayList day_list	= new ArrayList();
				ArrayList day_names	= new ArrayList();
				ArrayList time_list	= new ArrayList();
				ArrayList dose_list	= new ArrayList();
				ArrayList<String> week_days	= new ArrayList<String>();
				String time_value	= (String)ht.get("time1");
				HashMap freq_char_list	 = new HashMap();
				freq_char_list.put("called_from",ht.get("called_from"));
				freq_char_list.put("repeat",repeat);
				freq_char_list.put("durationType",duration_type);
				freq_char_list.put("start_date_time",ht.get("start_day_param"));
				freq_char_list.put("end_date_time",ht.get("end_date_time"));
				week_days = getDayOfWeek((String)ht.get("start_day_param")); 
					for(int j=1 ; j <= repeat ; j++){
						if(duration_type.equals("D")){
							day_list.add("0");	
						}else{
							if(!ht.get("admin_day"+(j)).equals("")){
								day_list.add(ht.get("admin_day"+(j)));
							}else{
								day_list.add("0");
							}
						}	
						if(!duration_type.equals("D")){
							if(!ht.get("admin_day"+(j)).equals(""))
							{
								String temp = (String)ht.get("admin_day"+(j));
								if (temp == null || temp.equals(""))
								{
									temp = "0";
								}

								if (!temp.equals("0"))
								{
									if(duration_type.equals("L")){
										if(Integer.parseInt(temp)>7)
                                             temp =(((Integer.parseInt(temp)-1)%7)+1)+"";
									}
									day_names.add(week_days.get((Integer.parseInt(temp))-1));
								}
								
							}
						}
						if(!ht.get("time"+j).equals("")){
							time_value	= (String)ht.get("time"+j);
						}
						time_list.add(time_value);
						dose_list.add((String)ht.get("qty"+j));
					}
				scheduleFrequencyDatas.add(freq_char_list);
				scheduleFrequencyDatas.add(day_list);
				scheduleFrequencyDatas.add(day_names);
				scheduleFrequencyDatas.add(time_list);
				scheduleFrequencyDatas.add(dose_list);					
			}

/*			HashMap scheduleFrequencyDatas	=	new HashMap();
			ArrayList day_list	= new ArrayList();
			ArrayList day_names	= new ArrayList();
			ArrayList time_list	= new ArrayList();
			ArrayList dose_list	= new ArrayList();
			String time_value	= (String)ht.get("time1");
			HashMap freq_char_list	 = new HashMap();
			freq_char_list.put("repeat",repeat);
			freq_char_list.put("durationType",duration_type);
			for(int j=1 ; j <= repeat ; j++){
				if(duration_type.equals("D")){
					day_list.add("0");	
				}else{
					day_list.add(j+2);
				}	
				if(!ht.get("admin_day"+(j+1)).equals("")){
					day_names.add((String)ht.get("dayDisplay"+(ht.get("admin_day"+(j+1)))));
				}
				if(!ht.get("time"+j).equals("")){
					time_value	= (String)ht.get("time"+j);
				}
				time_list.add(time_value);
				dose_list.add((String)ht.get("qty"+j));
			}
			scheduleFrequencyDatas.add(freq_char_list);
			scheduleFrequencyDatas.add(day_list);
			scheduleFrequencyDatas.add(day_names);
			scheduleFrequencyDatas.add(time_list);
			scheduleFrequencyDatas.add(dose_list);*/
			scheduleFrequency.clear(); // priya
			scheduleFrequency.put(code,scheduleFrequencyDatas);

			return true; 
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<String> getDayOfWeek(String sDate) 
	{
		String[] Days={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		ArrayList<String> dayList = new ArrayList<String>();	
		java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date d = new java.util.Date();
		try 
		{
			if (sDate != null && !sDate.equals(""))
			{			
			  df.setLenient(false);
			  d = df.parse(sDate);
			  //java.util.Calendar c=java.util.Calendar.getInstance();		 
			  int x = d.getDay();
			  int y = Days.length;
			   for (int i = x;i<y ;i++ )
			   {
					dayList.add(Days[i]);
					if (i==Days.length-1)
					{
						for (int j = 0;j<x ;j++ )
						{
							dayList.add(Days[j]);
						}					
					}
			   }	   		
		   }
		} catch(java.text.ParseException e) {
		  System.out.println("Wrong Date Entered.");
		  return null;
		}
		return dayList; 
	}
    
	public HashMap getscheduleFrequency() {
		return this.scheduleFrequency;
	}

	public ArrayList getScheduleFrequencyStr(String code, String row_value) {
		Object scheduleFrequencyDatasObj = scheduleFrequency.get(code);

		if(scheduleFrequencyDatasObj == null)
			return new ArrayList();
		else
			return (ArrayList)scheduleFrequencyDatasObj;
	}

	public String getPrescriptionRemarks(String remark_code){
		String remarks ="";
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		try{
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRES_REMARKS")) ;
			pstmt.setString(1,remark_code);
			pstmt.setString(2, getLanguageId());
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				remarks = (String)resultSet.getString("REMARK_DESC");
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
		return remarks.trim();
    }

	public String checkPreScheduled(String freq_code) {
	
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String pre_sch_yn			= "";
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT66")) ;
			pstmt.setString(1,freq_code);
			resultSet				= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()){
					pre_sch_yn	=	resultSet.getString("TOTAL");
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
		return pre_sch_yn;
	}

	public HashMap releaseCompoundRx() {
		System.out.println("releaseCompoundRx");  //ADDED FOR NMC-JD-CRF-0063
		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "test");

		Connection connection					= null;
		PreparedStatement pstmt_insert			= null;
		PreparedStatement pstmt_select			= null;
		ResultSet         resultSet				= null;
		CallableStatement cstmt_insert			= null;
		PreparedStatement pstmt_clob			= null;
		PreparedStatement pstmt_workload		= null;
		PreparedStatement workload_insert       = null;	 
		PreparedStatement work_insert_month     = null;	 
		PreparedStatement work_insert_loc       = null; 
		PreparedStatement work_insert_loc_mon   = null;	 
	    ResultSet 		  resultSet_workload    = null;
		ArrayList drugRemarks                   = null;
		HashMap scheduleFreq					= null;
    	int count							    =	0;
		String order_id				= getOrderID();
		String order_type			=	"";
		String perf_locn_code		=	"";
		String perf_locn_type		=	"";
		String short_desc			=	"";
		String priority				=  getPriority();
		HashMap record				= null;
		String stock_result			=	"";
		String ord_consent_reqd_yn	=	"N";
		String take_home_op ="N";//ADDED FOR NMC-JD-CRF-0063

		drugRemarks		= getDrugRemarks();
		scheduleFreq	= getscheduleFrequency();
		
		HashSet keyset=new HashSet(); //Added for Bru-HIMS-CRF-393_1.0-Start
	//	HashMap orderTypeDetails=new HashMap();  Removed for IN063877
		String order_type_code="";
		order_type_code		=(String)((HashMap)drugDetails.get(0)).get("ORDER_TYPE_CODE");
		keyset.add(order_type_code);
		setPrintOrdShtRuleInd(keyset,getPatientClass());	//Added for Bru-HIMS-CRF-393_1.0-End

		if(priority.equals("")) {
			priority			=	"R";
		}
		try {
			connection = getConnection();
			/*if(!getLanguageId().equals("en")){  //commented for IN23904 reopen --27/09/2010 -- priya (Conversion done in PrescriptionComp Frames.jsp)
				order_date = com.ehis.util.DateUtils.convertDate(order_date,"DMYHM",getLanguageId(),"en");				   
			}*/
			//Added for NMC-JD-CRF-0063
			if(getTakeHomeMedicationOp()==null){
				setTakeHomeMedicationOp("N"); 
			}
			if(getTakeHomeMedicationOp().equals("Y") && getTakeHomeMedicationOp()!=null && !getTakeHomeMedicationOp().equals("") && getOpDischMedInd()!=null && !getOpDischMedInd().equals("") && getOpDischMedInd().equals("Y")){
				take_home_op ="Y";
			}
			System.out.println("getTakeHomeMedicationOp: "+getTakeHomeMedicationOp());//added for NMC-JD-CRF-0063
			System.out.println("take_home_op: "+take_home_op);
			System.out.println("getOpDischMedInd: "+getOpDischMedInd());
			if(drugDetails.size() > 0) {
				//if(license!=null && !license.equals("PHBASIC")) {
				if(getLicense()!=null && !getLicense().equals("PHBASIC")){ //newly added for SKR-SCF-0356
					//cstmt_insert = connection.prepareCall("{call PH_RET_DISPLOCNIV(?,?,?,?,?,?,?)}");
					cstmt_insert = connection.prepareCall("{call Ph_Ret_Spl_Ord_Disp_Locn(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); // 12th parameter added for Bru-HIMS-CRF-347 [IN:037862],NMC-JD-CRF-0063
					cstmt_insert.setString(1, login_facility_id);
					cstmt_insert.setString(2, getLocationType());
					cstmt_insert.setString(3, getLocationCode());
					if(getTakeHomeMedicationOp().equals("Y")){//added for NMC-JD-CRF-0063
						cstmt_insert.setString(4, take_home_op);
					}else{
						cstmt_insert.setString(4, getTakeHomeMedication()); 
					}
					
					cstmt_insert.setString(5,priority);
					cstmt_insert.setString(6, "6");	
					cstmt_insert.setString(7, getLanguageId());
					
					cstmt_insert.registerOutParameter(8, Types.VARCHAR);
					cstmt_insert.registerOutParameter(9, Types.VARCHAR);
					cstmt_insert.registerOutParameter(10, Types.VARCHAR);
					cstmt_insert.registerOutParameter(11, Types.VARCHAR);
					cstmt_insert.setString(12,""); // added for Bru-HIMS-CRF-347 [IN:037862]
					cstmt_insert.setString(13,getPatId());//added for MMS-QH-CRF-0048 [IN:037704]
					cstmt_insert.setString(14,getEncId());//added for MMS-QH-CRF-0048 [IN:037704]
					cstmt_insert.setString(15,getOpDischMedInd());//added for NMC-JD-CRF-0063
					cstmt_insert.execute();
					
					perf_locn_code	= cstmt_insert.getString(8);
					this.perf_facility_id	= cstmt_insert.getString(11);
					
					/*perf_locn_code	= cstmt_insert.getString(8);
					perf_locn_type	= cstmt_insert.getString(9);
					perf_locn_type	= cstmt_insert.getString(10);*/
				} 
				else {
					perf_locn_code	= getLocationCode();
					perf_locn_type	= getLocationType();
				}
				order_type	=	(String)((HashMap)drugDetails.get(0)).get("ORDER_TYPE_CODE");
				stock_result		=	validateCompStock(getPatientClass(),perf_locn_code,drugDetails);

				if(stock_result.equals("")) {
					pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT"));
					resultSet		= pstmt_select.executeQuery();

					if (resultSet.next()) {
						trn_group_ref = resultSet.getString("TRN_GROUP_REF");
					}
					try{
						closeStatement(pstmt_select);
						closeResultSet(resultSet);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					/*for(int i=0; i<drugDetails.size(); i++ ) { //commented by abdul on 08/10/2010.cause it is not applicable to comp.rx
						record		=	(HashMap)drugDetails.get(i);
						if (record.get("CONSENT_REQD_YN").toString().equals("Y")){
							ord_consent_reqd_yn = "Y";
							break;
						}
					}*/
					// OR_ORDER
					pstmt_insert	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT1"));
					pstmt_insert.setString(++count, order_id);				// ORDER_ID
					pstmt_insert.setString(++count, order_type);			// ORDER_TYPE_CODE
					pstmt_insert.setString(++count, "PH");					//ORDER_CATEGORY
					pstmt_insert.setString(++count, "PH");					//CONTR_SYS_ID
					pstmt_insert.setString(++count, getPatId());			//PATIENT_ID
					pstmt_insert.setString(++count, getPatientClass());			//PATIENT_CLASS
					pstmt_insert.setString(++count, login_facility_id);		//ORDERING_FACILITY_ID
					pstmt_insert.setString(++count, getEncId());			//ENCOUNTER_ID
					pstmt_insert.setString(++count, getEncId());			//EPISODE_ID
					pstmt_insert.setString(++count, "");					//EPISODE_VISIT_NUM
					pstmt_insert.setString(++count, getLocationType());			//SOURCE_TYPE
					pstmt_insert.setString(++count, getLocationCode());			//SOURCE_CODE

					if(getTakeHomeMedication().equals("Y")){
						pstmt_insert.setString(++count, "D");
					}
					else{
						pstmt_insert.setString(++count, "");					//DISCHARGE_IND
					}
					pstmt_insert.setString(++count, order_date);			//ORD_DATE_TIME
					pstmt_insert.setString(++count, getPractitionerID());			//ORD_PRACT_ID
					pstmt_insert.setString(++count, priority);		//PRIORITY
					pstmt_insert.setString(++count, "N");				//ORD_AUTH_REQD_YN
					pstmt_insert.setString(++count, "");					//ORD_AUTH_LEVEL
					//pstmt_insert.setString(++count, getPractitionerID());			//ORD_AUTH_BY_PRACT_ID
					pstmt_insert.setString(++count, "");			//ORD_AUTH_BY_PRACT_ID
					pstmt_insert.setString(++count, order_date);			//ORD_AUTH_DATE_TIME
					pstmt_insert.setString(++count, "N");				//ORD_APPR_REQD_YN
					pstmt_insert.setString(++count, "");					//ORD_APPR_BY_USER_ID
					pstmt_insert.setString(++count, null);				//ORD_APPR_DATE_TIME
					pstmt_insert.setString(++count, "N");				//ORD_COSIGN_REQD_YN
					pstmt_insert.setString(++count, "");					//ORD_COSIGN_LEVEL
					pstmt_insert.setString(++count, "");					//ORD_COSIGN_BY_PRACT_ID
					pstmt_insert.setString(++count, null);				//ORD_COSIGN_DATE_TIME
					pstmt_insert.setString(++count, null);				//ORD_PRINT_DATE_TIME
					pstmt_insert.setString(++count, "N");				//BILL_YN
					pstmt_insert.setString(++count, "CO");				//CONT_ORDER_IND
					pstmt_insert.setString(++count, this.perf_facility_id);	//PERFORMING_FACILITY_ID
					pstmt_insert.setString(++count, "PH");				//PERFORMING_SYS_ID
					pstmt_insert.setString(++count, perf_locn_type);		//PERFORMING_DEPTLOC_TYPE
					pstmt_insert.setString(++count, perf_locn_code);		//PERFORMING_DEPTLOC_CODE
					pstmt_insert.setString(++count, pract_id);			//PERFORMING_PRACT_ID
					pstmt_insert.setString(++count, "N");				//RESULT_AUTH_REQD_YN
					pstmt_insert.setString(++count, "N");				//CHILD_ORDER_YN
					pstmt_insert.setString(++count, "");					//PARENT_ORDER_ID
					pstmt_insert.setString(++count, "N");				//ORDER_SET_YN
					pstmt_insert.setString(++count, "");					//ORDER_SET_ID
					pstmt_insert.setString(++count, "6");					//IV_PREP_YN
					pstmt_insert.setString(++count, "");					//ORDER_FIELDS_DISPLAY_TEXT
					pstmt_insert.setString(++count, "OS");				//ORDER_STATUS
					pstmt_insert.setString(++count, "");					//RESULT_STATUS
					pstmt_insert.setString(++count, login_by_id);		//ADDED_BY_ID
					pstmt_insert.setString(++count, login_at_ws_no);		//ADDED_AT_WS_NO
					pstmt_insert.setString(++count, login_facility_id);	//ADDED_FACILITY_ID
					pstmt_insert.setString(++count, login_by_id);		//MODIFIED_BY_ID
					pstmt_insert.setString(++count, login_at_ws_no);		//MODIFIED_AT_WS_NO
					pstmt_insert.setString(++count, login_facility_id);	//MODIFIED_FACILITY_ID
					pstmt_insert.setString(++count, ord_consent_reqd_yn);				//ORD_CONSENT_REQD_YN
					pstmt_insert.setString(++count, "");					//ORD_CONSENT_BY_ID
					pstmt_insert.setString(++count, null);				//ORD_CONSENT_BY_DATE_TIME
					pstmt_insert.setString(++count, "");					//CAN_REASON
					pstmt_insert.setString(++count, trn_group_ref);					//trn_group_ref
					int result			= pstmt_insert.executeUpdate();

					//OR_ORDER_LINE
				if(result > 0){
						if( pstmt_insert !=	null) {	closeStatement(pstmt_insert	);} 
						pstmt_insert		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT2A"));
						//pstmt_select		=	null;
						//pstmt_select		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT_CONSENT_DETAILS"));

						for(int i=0; i<drugDetails.size(); i++ ) {
							count		=	0;
							record		=	(HashMap)drugDetails.get(i);				

							if( ((String)record.get("SHORT_DESC")).length() > 39) {
								short_desc	=	((String)record.get("SHORT_DESC")).substring(0,39);
							} 
							else {
								short_desc	=	((String)record.get("SHORT_DESC"));
							}
							/*pstmt_select.setString(1,(String)record.get("DRUG_CODE"));
							resultSet			= pstmt_select.executeQuery();
							if(resultSet!=null && resultSet.next()) {
								record.put("CONSENT_REQD_YN",(resultSet.getString("CONSENT_REQD_YN")==null?"N":resultSet.getString("CONSENT_REQD_YN")) );
								record.put("CONSENT_STAGE",(resultSet.getString("CONSENT_STAGE")==null ? "":resultSet.getString("CONSENT_STAGE")) );
								if(resultSet.getString("CONSENT_STAGE")!=null && resultSet.getString("CONSENT_STAGE").equals("R"))
									record.put("CONSENT_STATUS","P" );
								else
									record.put("CONSENT_STATUS","");
								record.put("NUM_OF_CONSENT_REQ_BO",(resultSet.getString("NUM_OF_CONSENT_REQ_BO")==null?"":resultSet.getString("NUM_OF_CONSENT_REQ_BO")) );
								record.put("NUM_OF_CONSENT_REQ_BR",(resultSet.getString("NUM_OF_CONSENT_REQ_BR")==null?"":resultSet.getString("NUM_OF_CONSENT_REQ_BR")) );
							}
							if(resultSet != null) {
								closeResultSet( resultSet );
							}*/

							/* pstmt_select.setString(1, (String)record.get("DRUG_CODE"));
							resultSet	= pstmt_select.executeQuery();
							if (resultSet.next()) {
								order_uom	=	(resultSet.getString("STOCK_UOM"));
							} */
							
							pstmt_insert.setString(++count, order_id);								// ORDER_ID
							pstmt_insert.setString(++count, (i+1)+"");									// ORDER_LINE_NUM
							pstmt_insert.setString(++count, (String)record.get("DRUG_CODE"));			//ORDER_CATALOG_CODE
							pstmt_insert.setString(++count, short_desc);								//CATALOG_DESC
							pstmt_insert.setString(++count, short_desc);								//CATALOG_SYNONYM
							pstmt_insert.setString(++count, "");										//ORDER_CATALOG_NATURE
							pstmt_insert.setString(++count, (String)record.get("ORDER_TYPE_CODE"));	//ORDER_TYPE_CODE
							pstmt_insert.setString(++count, "PH");									//ORDER_CATEGORY
							pstmt_insert.setString(++count, order_date);								//ORD_DATE_TIME
							pstmt_insert.setString(++count, priority);							//PRIORITY
							pstmt_insert.setString(++count, "N");									//ORD_AUTH_REQD_YN
							pstmt_insert.setString(++count, "");										//ORD_AUTH_REASON
							pstmt_insert.setString(++count, "N");									//ORD_APPR_REQD_YN
							pstmt_insert.setString(++count, "N");									//ORD_COSIGN_REQD_YN
							pstmt_insert.setString(++count, (String)record.get("START_DATE"));		//START_DATE_TIME
							pstmt_insert.setString(++count, (String)record.get("FORM_CODE"));		//FORM_CODE
							pstmt_insert.setString(++count, (String)record.get("ROUTE_CODE"));		//ROUTE_CODE
							pstmt_insert.setString(++count, (String)record.get("DOSAGE_VALUE"));		// QTY_VALUE

							/*if(((String)record.get("STRENGTH_UOM")).equals("")) {
								qty_uom		= (String)record.get("QTY_DESC_CODE");
							} else {
								qty_uom		= (String)record.get("STRENGTH_UOM");
							}*/

							pstmt_insert.setString(++count,(String)record.get("DOSAGE_UOM") );	//QTY_UOM
							pstmt_insert.setString(++count, (String)record.get("FREQ_CODE"));	//FREQ_CODE
							pstmt_insert.setString(++count, (String)record.get("DURN_VALUE"));	//DURN_VALUE
							pstmt_insert.setString(++count, (String)record.get("DURN_TYPE"));	//DURN_TYPE
							pstmt_insert.setString(++count, "");										//LINE_FIELDS_DISPLAY_TEXT
							pstmt_insert.setString(++count, "");								//ITEM_NARRATION				
							pstmt_insert.setString(++count, null);								//NEXT_SCHED_DATE
							pstmt_insert.setString(++count, (String)record.get("END_DATE"));	//END_DATE
							pstmt_insert.setString(++count, null);								//AUTO_STOP_DATE_TIME
							pstmt_insert.setString(++count, (String)record.get("ORDER_QTY"));	//ORDER_QTY
							pstmt_insert.setString(++count, (String)record.get("ORDER_UOM"));	//ORDER_UOM
							pstmt_insert.setString(++count, "N");								//APPT_REQD_YN
							pstmt_insert.setString(++count, null);								//APPT_DATE_TIME
							pstmt_insert.setString(++count, "");			//APPT_REF_NUM
							pstmt_insert.setString(++count, "N");			//RESULT_APPLICABLE_YN
							pstmt_insert.setString(++count, "N");			//BILL_YN
							pstmt_insert.setString(++count, "N");			//BILLED_YN
							pstmt_insert.setString(++count, "CO");			//CONT_ORDER_IND
							pstmt_insert.setString(++count, "N");			//REFILL_SINGLE_CONT_ORDER_YN
							pstmt_insert.setString(++count, "");				//NUM_OF_REFILLS
							pstmt_insert.setString(++count, "N");			//CHILD_ORDER_YN
							pstmt_insert.setString(++count, "");				//PARENT_ORDER_ID
							pstmt_insert.setString(++count, "");				//PARENT_ORDER_LINE_NUM
							pstmt_insert.setString(++count, "");				//ORDER_SET_ID
							pstmt_insert.setString(++count, "");				//ORDER_SET_LINE_NUM
							pstmt_insert.setString(++count, getPractitionerID());		//ORD_PRACT_ID
							pstmt_insert.setString(++count, null);			//ORD_SET_DATE_TIME
							pstmt_insert.setString(++count, "");				//AMD_PRACT_ID
							pstmt_insert.setString(++count, null);			//AMD_DATE_TIME
							pstmt_insert.setString(++count, "");				//HOLD_PRACT_ID
							pstmt_insert.setString(++count, null);			//HOLD_DATE_TIME
							pstmt_insert.setString(++count, "");				//RESUME_PRACT_ID
							pstmt_insert.setString(++count, null);			//RESUME_DATE_TIME
							pstmt_insert.setString(++count, "");				//DISC_PRACT_ID		
							pstmt_insert.setString(++count, null);			//DISC_DATE_TIME
							pstmt_insert.setString(++count, "");				//CAN_PRACT_ID
							pstmt_insert.setString(++count, null);			//CAN_DATE_TIME
							pstmt_insert.setString(++count, "");				//ACCESSION_NUM
							pstmt_insert.setString(++count, "");				//ACCESSION_LINE_NUM
							pstmt_insert.setString(++count, "OS");			//ORDER_LINE_STATUS
							pstmt_insert.setString(++count, "");				//RESULT_LINE_STATUS
							pstmt_insert.setString(++count, login_by_id);	//ADDED_BY_ID
							pstmt_insert.setString(++count, login_at_ws_no); //ADDED_AT_WS_NO
							pstmt_insert.setString(++count, login_facility_id); //ADDED_FACILITY_ID
							pstmt_insert.setString(++count, login_by_id);		//MODIFIED_BY_ID
							pstmt_insert.setString(++count, login_at_ws_no);		//MODIFIED_AT_WS_NO
							pstmt_insert.setString(++count, login_facility_id);	//MODIFIED_FACILITY_ID
							//pstmt_insert.setString(++count, (String)record.get("CONSENT_REQD_YN"));				//ORD_CONSENT_REQD_YN
							pstmt_insert.setString(++count, ord_consent_reqd_yn);	//ORD_CONSENT_REQD_YN
							pstmt_insert.setString(++count, "");					//CAN_LINE_REASON
							pstmt_insert.setString(++count, short_desc);			//CATALOG_SYNONYM_DC
							pstmt_insert.setString(++count, short_desc);			//CATALOG_SYNONYM_AD
							pstmt_insert.setString(++count, "N");				//RESULT_AUTH_REQD_YN
							pstmt_insert.setString(++count,(String)record.get("CONSENT_STAGE")); //ORD_CONSENT_STAGE
							pstmt_insert.setString(++count,(String)record.get("CONSENT_STATUS")); //ORD_CONSENT_STATUS
							pstmt_insert.setString(++count,(String)record.get("NUM_OF_CONSENT_REQ_BO")); //NUM_OF_CONSENT_REQ_BO
							pstmt_insert.setString(++count,(String)record.get("NUM_OF_CONSENT_REQ_BR")); //NUM_OF_CONSENT_REQ_BR
							pstmt_insert.addBatch();
						}
						try{
							closeResultSet( resultSet ) ;
							closeStatement( pstmt_select ) ;
						}
						catch(Exception es){
							es.printStackTrace() ;
						}
						int[] batch_result = pstmt_insert.executeBatch();
						for (int i=0;i<batch_result.length;i++ ) {
							if (batch_result[i]<0  && batch_result[i] != -2) {
								result = 0;
								pstmt_insert.cancel();
								throw new Exception("OR ORDER Line Failed");
							}
							else{
									result = 1;
							}
						}
					}

					// PH_MEDN_ADMIN
					/*if(result > 0){
						String med_admin_reqd_yn			=	"";
						String verf_reqd_bef_med_admin_yn	=	"";
						String duration						= (String)record.get("");
						ArrayList unique_drugs				= new ArrayList(4);
						ArrayList frequencyValues			= null;
						int dosage_seqNo					=	0;
						pstmt_select		=	null;
						boolean freq_values_found	= false;

						 
						pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT8"));
						pstmt_select.setString(1, login_facility_id);
						resultSet			= pstmt_select.executeQuery();
						if(resultSet.next()) {
							med_admin_reqd_yn	=	(resultSet.getString("MED_ADMIN_REQD_YN"));
						}
						if(med_admin_reqd_yn == null){med_admin_reqd_yn="";}
						resultSet		= null;
						pstmt_select	=	null;
						pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT25A"));
						pstmt_select.setString(1, login_facility_id);
						resultSet		= pstmt_select.executeQuery();
						if (resultSet.next()) {
							verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
						}

						pstmt_select		=	null;
						pstmt_select		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT2"));

						pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT2"));

						pstmt_select1 = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT24A"));
						
						for(int i=0; i<drugDetails.size(); i++ ) {
							record		=	(HashMap)drugDetails.get(i);		

							//order_id		=	(String)record.get("ORDER_ID");
							if( (patient_class.equals("IP") || patient_class.equals("EM"))&& med_admin_reqd_yn.equals("Y")) {
								int fr_durn_value	= Integer.parseInt(record.get("DURN_VALUE").toString());		
								if(!unique_drugs.contains((String)record.get("DRUG_CODE"))) {
									unique_drugs.add((String)record.get("DRUG_CODE"));
									dosage_seqNo	=	0;
								}
						   pstmt_select.setString(1, (String)record.get("DRUG_CODE"));
							resultSet	= pstmt_select.executeQuery();
							if (resultSet.next()) {
								order_uom	=	(resultSet.getString("STOCK_UOM"));
							}
							if (scheduleFreq.size()>0) {
								//debug += "\nfr_drug_code : " + (String)fluidDetails.get("DRUG_CODE");
								 if (scheduleFreq.containsKey((String)record.get("DRUG_CODE")))
									frequencyValues = (ArrayList)scheduleFreq.get((String)record.get("DRUG_CODE"));
							}

							for (int m=0; m<fr_durn_value; m++) {
							   if (frequencyValues.size() > 0) {

								   freq_values_found = true;
								   for (int n=0; n<frequencyValues.size(); n++) {
												count		=	0;
												dosage_seqNo		= 1;
												dosage_seqNo			= dosage_seqNo+n;
												HashMap data			= (HashMap)frequencyValues.get(n);
												String admin_time		= (String)data.get("admin_time");
											//	String admin_qty		= (String)data.get("admin_qty");
												String sch_date_time	= "";
												String start_date_time =(String)record.get("START_DATE");
												//debug += "dosage_type : "+dosage_type;
												//debug += "qty_unit : "+qty_unit;
												//debug += "strength_value : "+strength_value;
												//debug += "strength_uom : "+strength_uom;
												//debug += "pres_base_uom : "+pres_base_uom;

												resultSet		= null;
												pstmt_select1.setString(1, start_date_time);
												pstmt_select1.setString(2, ""+m);
												pstmt_select1.setString(3, admin_time);
												resultSet = pstmt_select1.executeQuery();

												if (resultSet.next()) {
													sch_date_time = resultSet.getString(1);
												}

								pstmt_insert.setString(++count, login_facility_id);	//FACILITY_ID
								pstmt_insert.setString(++count, getEncId());		//ENCOUNTER_ID
								pstmt_insert.setString(++count, sch_date_time);			//SCH_DATE_TIME
								pstmt_insert.setString(++count, (String)record.get("DRUG_CODE")); //ORD_DRUG_CODE
								pstmt_insert.setString(++count, ++dosage_seqNo+ "");				// DOSAGE SEQ No
								pstmt_insert.setString(++count, order_id);				//ORDER_ID
								pstmt_insert.setString(++count, (i+1)+"");				// ORDER LINE NUM
								pstmt_insert.setString(++count, getPatId());				//PATIENT_ID
								pstmt_insert.setString(++count, pract_id);				//PRACT_ID
								pstmt_insert.setString(++count, "Y");					//IV_ADMIN_YN
								pstmt_insert.setString(++count, "");
								pstmt_insert.setString(++count,(String)record.get("QTY_VALUE"));			//SCH_DOSAGE_QTY
								pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));				//SCH_DOSAGE_UOM_CODE
								pstmt_insert.setString(++count, (String)record.get("STRENGTH_VALUE")); //SCH_STRENGTH
								pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM")); //SCH_STRENGTH_UOM
								pstmt_insert.setString(++count, (String)record.get("ROUTE_CODE"));   //SCH_ROUTE_CODE 
								pstmt_insert.setString(++count, ""); //SCH_INFUSION_RATE
								pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));		//SCH_INFUSION_VOL_STR_UNIT
								pstmt_insert.setString(++count, "H");  //SCH_INFUSION_PER_UNIT
								pstmt_insert.setString(++count, verf_reqd_bef_med_admin_yn);
								pstmt_insert.setString(++count, login_by_id);
								pstmt_insert.setString(++count, login_at_ws_no);
								pstmt_insert.setString(++count, login_facility_id);
								pstmt_insert.setString(++count, login_by_id);
								pstmt_insert.setString(++count, login_at_ws_no);
								pstmt_insert.setString(++count, login_facility_id);
								pstmt_insert.setString(++count, "");
								pstmt_insert.setString(++count, "H");			//SCH_INFUSION_PERIOD_UNIT
								pstmt_insert.addBatch();
								
								}
				
							   }
							 }
							}
						}

						int[] batch_result5 = pstmt_insert.executeBatch();
						for (int i=0;i<batch_result5.length; i++ ) {
							if (batch_result5[i]<0  && batch_result5[i] != -2) {
									result = 0;
									pstmt_insert.cancel();
									throw new Exception("PH Medn admin Failed");
							}else{
									result = 1;
							}
						}
					}*/	
					//	OR_ORDER_COMMENT Insert
					if(result > 0){		
						String action_seq_num		= "";
						String order_comment		=	getAmendOrderRemarks();

						if(resultSet != null) 
							closeResultSet( resultSet );

						pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56"));
						pstmt_select.setString(1, order_id);
						resultSet		= pstmt_select.executeQuery();

						if(resultSet.next()) {
							action_seq_num = resultSet.getString(1);
						}
						if(resultSet != null)
							closeResultSet( resultSet );
						if(pstmt_insert	!= null) 
							closeStatement( pstmt_insert );

						pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5"));
						pstmt_insert.setString(1, order_id);
						pstmt_insert.setString(2, action_seq_num);
						pstmt_insert.setString(3, login_by_id);
						pstmt_insert.setString(4, login_at_ws_no);
						pstmt_insert.setString(5, login_facility_id);
						pstmt_insert.setString(6, login_by_id);
						pstmt_insert.setString(7, login_at_ws_no);
						pstmt_insert.setString(8, login_facility_id);
						result = pstmt_insert.executeUpdate();
			
						if(result>0){
							pstmt_clob		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57"));
							pstmt_clob.setString(1,order_id);
							pstmt_clob.setString(2,action_seq_num);
							ResultSet rset_clob =pstmt_clob.executeQuery();
							if(rset_clob!=null){
								while(rset_clob.next()){
									Clob clb 			= (Clob) rset_clob.getClob(1);
									BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
									bw.write(order_comment,0,order_comment.length());
									bw.flush();
									bw.close();
								}
							}
							if(rset_clob!=null)
								closeResultSet( rset_clob );
							if(pstmt_clob	!= null) 
								closeStatement( pstmt_clob );
						}
					}

					// OR_ORDER_LINE_PH
					if(result > 0){
						if(pstmt_insert	!= null) {  closeStatement( pstmt_insert );}
						//pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT3A"));
						//modified for aakh-crf-0140
						pstmt_insert = connection.prepareStatement("INSERT INTO OR_ORDER_LINE_PH (ORDER_ID,ORDER_LINE_NUM,GENERIC_ID,FORM_CODE,TRADE_CODE,FORMULARY_ITEM_YN,DOSAGE_TYPE,SPLIT_DRUG_PREVIEW,TOT_STRENGTH,TOT_STRENGTH_UOM,INFUSE_OVER,INFUSE_OVER_UNIT,INFUSION_RATE,INFUSION_VOL_STR_UNIT,INFUSION_PER_UNIT,BROUGHT_BY_PATIENT_YN,CUR_DRUG_YN,REFILL_DRUG_YN,DISPENSING_LOC_TYPE,DISPENSING_LOC,DISPENSING_STORE,IP_FILL_PROCESS,IP_FILL_PRD_AHEAD,NEXT_FILL_DATE,LAST_FILL_QTY,DISPENSED_QTY,BMS_QTY,BMS_STRENGTH,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SPLIT_DOSE_YN,QTY_VALUE_SPLIT_DOSE,QTY_UNIT_SPLIT_DOSE,STRENGTH_VALUE,STRENGTH_UOM,PRES_QTY_VALUE,PRES_QTY_UOM,ALLERGY_OVERRIDE_REASON,DOSAGE_LIMIT_OVERRIDE_REASON,DUPLICATE_DRUG_OVERRIDE_REASON,TOT_INFUSION_OVER, TOT_INFUSION_OVER_UNIT,ADMIN_RATE_DETAIL,CHNGD_FLUID_REMARKS,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,BUILD_MAR_YN,COMP_RX_BASED_ON,RATIO_PERC_FACTOR,CMP_RX_FINAL_PROD_QTY, CMP_RX_FINAL_PROD_UOM,CMP_RX_REQD_QTY,DRUG_INDICATION, MAR_BARCODE_ID,ALLERGY_OVERRIDE_REASON_CODE,DOSE_LIMIT_OVER_REASON_CODE,DUP_DRUG_OVERRIDE_REASON_CODE,ABUSE_EXISTS,ABUSE_DRUG_OVERRIDE_REASON) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?)");//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938],Modified for IN:072715 Added ALLERGY_OVERRIDE_REASON_CODE,DOSE_LIMIT_OVER_REASON_CODE,DUP_DRUG_OVERRIDE_REASON_CODE

						float total_strength		= 0.0f;
						for(int i=0; i<drugDetails.size(); i++ ) {
							count		=	0;
							record		=	(HashMap)drugDetails.get(i);	

							if(!((String)record.get("STRENGTH_VALUE")).equals("") && !((String)record.get("STRENGTH_VALUE")).equals("0")) {
								total_strength		= (Float.parseFloat((String)record.get("STRENGTH_VALUE"))*Float.parseFloat((String)record.get("DURN_VALUE")));
							}
							
							/*pstmt_select.setString(1, (String)record.get("DRUG_CODE"));
							resultSet	= pstmt_select.executeQuery();
							if (resultSet.next()) {
								order_uom	=	(resultSet.getString("STOCK_UOM"));
							}*/
							//System.out.println("=RATIO_PERCENTAGE="+(String)record.get("RATIO_PERCENTAGE")+",=PRES_BY_BASE="+(String)record.get("PRES_BY_BASE"));
							
							pstmt_insert.setString(++count, order_id);							//ORDER_ID
							pstmt_insert.setString(++count, (i+1)+"");							//ORDER_LINE_NUM
							pstmt_insert.setString(++count, (String)record.get("GENERIC_ID"));	//GENERIC_ID
							pstmt_insert.setString(++count, (String)record.get("FORM_CODE"));		//FORM_CODE
							pstmt_insert.setString(++count, ""); //TRADE_CODE
							if(record.get("IN_FORMULARY_YN")!=null && !((String)record.get("IN_FORMULARY_YN")).equals("")){
								pstmt_insert.setString(++count, (String)record.get("IN_FORMULARY_YN"));
							}else{
								pstmt_insert.setString(++count, "N");											//FORMULARY_ITEM_YN
							}
							pstmt_insert.setString(++count, (String)record.get("DOSAGE_TYPE"));				//DOSAGE_TYPE
							pstmt_insert.setString(++count, "");											//SPLIT_DRUG_PREVIEW
							pstmt_insert.setString(++count, new Float(total_strength).intValue()+"");		//TOT_STRENGTH
							pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM"));					//TOT_STRENGTH_UOM
							pstmt_insert.setString(++count, "");			//INFUSE_OVER
							pstmt_insert.setString(++count, "");			//INFUSE_OVER_UNIT
							pstmt_insert.setString(++count, "");			//INFUSION_RATE
							pstmt_insert.setString(++count, "");			//INFUSION_VOL_STR_UNIT
							pstmt_insert.setString(++count, "");			//INFUSION_PER_UNIT
							pstmt_insert.setString(++count, "N");			//BROUGHT_BY_PATIENT_YN
							pstmt_insert.setString(++count, "N");			//CUR_DRUG_YN
							pstmt_insert.setString(++count, "N");			//REFILL_DRUG_YN
							pstmt_insert.setString(++count, "");					//DISPENSING_LOC_TYPE
							pstmt_insert.setString(++count, "");					//DISPENSING_LOC
							pstmt_insert.setString(++count, "");					//DISPENSING_STORE
							pstmt_insert.setString(++count, "");					//IP_FILL_PROCESS
							pstmt_insert.setString(++count, "");					//IP_FILL_PRD_AHEAD
							pstmt_insert.setString(++count, null);				//NEXT_FILL_DATE
							pstmt_insert.setString(++count, "");					//LAST_FILL_QTY
							pstmt_insert.setString(++count, "");					//DISPENSED_QTY
							pstmt_insert.setString(++count, (String)record.get("ORDER_QTY"));			//BMS_QTY
							pstmt_insert.setString(++count, new Float(total_strength).intValue()+"");		//BMS_STRENGTH	
							pstmt_insert.setString(++count, login_by_id);
							pstmt_insert.setString(++count, login_at_ws_no);
							pstmt_insert.setString(++count, login_facility_id);
							pstmt_insert.setString(++count, login_by_id);
							pstmt_insert.setString(++count, login_at_ws_no);
							pstmt_insert.setString(++count, login_facility_id);
							pstmt_insert.setString(++count, "N");								//SPLIT_DOSE_YN
							pstmt_insert.setString(++count, (String)record.get("QTY_VALUE"));	//QTY_VALUE_SPLIT_DOSE
							pstmt_insert.setString(++count, (String)record.get("QTY_UOM"));		//QTY_UNIT_SPLIT_DOSE
							pstmt_insert.setString(++count, (String)record.get("STRENGTH_VALUE"));	//STRENGTH_VALUE
							pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM"));		//STRENGTH_UOM
							pstmt_insert.setString(++count, (String)record.get("ABSOL_QTY"));	//PRES_QTY_VALUE
							pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));	//PRES_QTY_UOM
							pstmt_insert.setString(++count, (String)record.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON
							pstmt_insert.setString(++count, (String)record.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
							pstmt_insert.setString(++count, (String)record.get("CURRENTRX_REMARKS")); //DUPLICATE_DRUG_OVERRIDE_REASON
							pstmt_insert.setString(++count, ""); //TOT_INFUSION_OVER
							pstmt_insert.setString(++count, ""); //TOT_INFUSION_OVER_UNIT
							pstmt_insert.setString(++count, "");  //ADMIN_RATE
							pstmt_insert.setString(++count, "");  //CHANGED FLUID REMARKS 	
							pstmt_insert.setString(++count, (String)record.get("BL_INCL_EXCL_OVERRIDE_VALUE"));  //BL_INCL_EXCL_OVERRIDE_VALUE	
							pstmt_insert.setString(++count, (String)record.get("BL_INCL_EXCL_OVERRIDE_REASON"));  //BL_INCL_EXCL_OVERRIDE_REASON 	
							pstmt_insert.setString(++count, getBuildMAR_yn());  //BuildMAR_yn
							pstmt_insert.setString(++count, (String)record.get("PRES_BY_BASE"));  //Prescribing By
							pstmt_insert.setString(++count, (String)record.get("RATIO_PERCENTAGE"));  // Ratio/Percentage Value
							pstmt_insert.setString(++count, (String)record.get("TOTAL_QTY"));  // Total Quantity
							pstmt_insert.setString(++count, (String)record.get("TOTAL_QTY_UOM"));  // UOM of the total quantity
							pstmt_insert.setString(++count, (String)record.get("REQD_QTY"));  // Required percentage of the drug
							pstmt_insert.setString(++count, (String)record.get("DRUG_INDICATION"));
							pstmt_insert.setString(++count, "");//added for MMS-QH-CRF-0080 [IN:038064]
							//Added for IN:072715
							pstmt_insert.setString(++count, (String)record.get("ALLERGY_REMARKS_CODE"));
							pstmt_insert.setString(++count, (String)record.get("DOSE_REMARKS_CODE")); 
							pstmt_insert.setString(++count, (String)record.get("CURRENTRX_REMARKS_CODE"));
							pstmt_insert.setString(++count, (String)record.get("ABUSE_OVERRIDE")); //added for aakh-crf-0140
							pstmt_insert.setString(++count, (String)record.get("abuse_override_remarks"));//added for aakh-crf-0140
							System.out.println("abuse_override_remarks 6842"+(String)record.get("abuse_override_remarks"));
							System.out.println("ABUSE_EXISTS 6842"+(String)record.get("ABUSE_OVERRIDE"));
							
							//Added for IN:072715
							pstmt_insert.addBatch();
						}
						
						int[] batch_result = pstmt_insert.executeBatch();

						for (int i=0;i<batch_result.length;i++ ) {
							if (batch_result[i]<0  && batch_result[i] != -2) {
								result = 0;	
								pstmt_insert.cancel();
								throw new Exception("OR ORDER Line PH Failed");
							}
							else{
									result = 1;
							}
						}
						if(pstmt_insert	!= null) 
							closeStatement( pstmt_insert );
					}

					//OR_ORDER_LINE_FIELD_VALUES
					if(result > 0){
						boolean enter_loop = false;
						/*pstmt_delete=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_DELETE_FIELD_VALUES_A"));
						pstmt_delete.setString(1, order_id);
						try{
							pstmt_delete.executeUpdate();
						}
						catch(Exception e){
						   System.err.println("exceptioin at line no:4437"+e.toString());
						}*/
						pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7"));
						pstmt_insert.clearBatch();
						if(drugRemarks.size()>0) {
							int order_format_count	= 0;
							for (int i=0;i<drugRemarks.size();i++ ) {
								HashMap DrugValues = (HashMap)drugRemarks.get(i);
								String total_seq	= (String)DrugValues.get("order_format_count");
								order_format_count	= Integer.parseInt(total_seq);
								
								for(int k=0;k<order_format_count;k++) {
									enter_loop = true;
									pstmt_insert.setString(1, order_id);
									pstmt_insert.setString(2, "" + (i+1));
									pstmt_insert.setString(3, "S");
									pstmt_insert.setString(4, "" + (k+1));
									pstmt_insert.setString(5, (String)DrugValues.get("field_mnemonic"+k));
									pstmt_insert.setString(6, (String)DrugValues.get("field_type"+k));
									pstmt_insert.setString(7, (String)DrugValues.get("label_text"+k));
									pstmt_insert.setString(8, (String)DrugValues.get("field_values"+k));
									pstmt_insert.setString(9, "");
									pstmt_insert.setString(10, "");
									pstmt_insert.setString(11, (String)DrugValues.get("accept_option"+k));

									pstmt_insert.setString(12, login_by_id);
									pstmt_insert.setString(13, login_at_ws_no);
									pstmt_insert.setString(14, login_facility_id);
									pstmt_insert.setString(15, login_by_id);
									pstmt_insert.setString(16, login_at_ws_no);
									pstmt_insert.setString(17, login_facility_id);
									pstmt_insert.addBatch();
								}
							}
							if(enter_loop) {
								int[] batch_result1 = pstmt_insert.executeBatch();
								for (int i=0;i<batch_result1.length;i++ ) {
									if (batch_result1[i]<0  && batch_result1[i] != -2) {
										result=0;
										break;
									}
									else {
										result=1;
									}
								}
							} 
							else {
								result=1;
							}
						} 
						else {
							result=1;
						}
						if(pstmt_insert	!= null) {  
							closeStatement( pstmt_insert );
						}
					}
					String split_dose_preview="";
					if (result>0) {
						boolean freq_values_found	= false;
						//pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7"));
						pstmt_insert = connection.prepareStatement("INSERT INTO OR_ORDER_LINE_FIELD_VALUES (ORDER_ID,ORDER_LINE_NUM,ORDER_LINE_FIELD_LEVEL,ORDER_LINE_SEQ_NUM,ORDER_LINE_FIELD_MNEMONIC,ORDER_LINE_FIELD_TYPE,ORDER_LINE_LABEL_TEXT,ORDER_LINE_FIELD_VALUE,ORDER_LINE_DOSE_QTY_VALUE,ORDER_LINE_DOSE_QTY_UNIT,ACCEPT_OPTION,ORDER_LINE_FREQ_DAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");

						ArrayList frequencyValues = new ArrayList();
						HashMap drugDetails1=new HashMap();
						drugDetails1 = (HashMap)drugDetails.get(0);

						if (scheduleFreq.size()>0) {
							if (scheduleFreq.containsKey((String)drugDetails1.get("DRUG_CODE")))
								frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails1.get("DRUG_CODE"));
						}

						HashMap freq_char_list	= new HashMap();
						ArrayList day_list		= new ArrayList();
						ArrayList day_names		= new ArrayList();
						ArrayList time_list		= new ArrayList();
						ArrayList dose_list		= new ArrayList();
						if (frequencyValues.size()>0) {
							freq_char_list	= (HashMap)frequencyValues.get(0);
							day_list		= (ArrayList)frequencyValues.get(1);
							day_names		= (ArrayList)frequencyValues.get(2);
							time_list		= (ArrayList)frequencyValues.get(3);
							dose_list		= (ArrayList)frequencyValues.get(4);
						}
						for(int frStr = 0;frStr<day_list.size();frStr++){
							if(!freq_char_list.get("durationType").equals("D")){
								split_dose_preview = split_dose_preview + "Day "+day_list.get(frStr);
								split_dose_preview = split_dose_preview + " - ";
								split_dose_preview = split_dose_preview + day_names.get(frStr);
								split_dose_preview = split_dose_preview + " - ";
							}
							split_dose_preview = split_dose_preview + time_list.get(frStr);
							split_dose_preview = split_dose_preview + " - ";
							split_dose_preview = split_dose_preview + dose_list.get(frStr);
							split_dose_preview = split_dose_preview + " "+(String)record.get("DOSAGE_UOM");
							split_dose_preview = split_dose_preview + "; ";
						}
						for(int n=0;n<day_list.size();n++) {
							freq_values_found	= true;
							int seqNo			= 200;
							seqNo				= seqNo + n;

							//					HashMap data		= (HashMap)frequencyValues.get(n);
							//					String admin_time	= (String)data.get("admin_time");
							//					String admin_qty	= (String)data.get("admin_qty");
							String durn_desc	= (String)record.get("DOSAGE_UOM");
							pstmt_insert.setString(1, order_id);
							pstmt_insert.setString(2, "1");
							pstmt_insert.setString(3, "S");
							pstmt_insert.setString(4, seqNo + "");
							pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
							pstmt_insert.setString(6, "C");
							pstmt_insert.setString(7, "D");
							//					pstmt_insert.setString(8, admin_time);
							//					pstmt_insert.setString(9, admin_qty);
							pstmt_insert.setString(8, (String)time_list.get(n));
							pstmt_insert.setString(9, (String)dose_list.get(n));
							pstmt_insert.setString(10, durn_desc);
							pstmt_insert.setString(11, "O");
							pstmt_insert.setInt(12,Integer.parseInt(day_list.get(n)+""));
							pstmt_insert.setString(13, login_by_id);
							pstmt_insert.setString(14, login_at_ws_no);
							pstmt_insert.setString(15, login_facility_id);
							pstmt_insert.setString(16, login_by_id);
							pstmt_insert.setString(17, login_at_ws_no);
							pstmt_insert.setString(18, login_facility_id);
							pstmt_insert.addBatch();
						}

						if (freq_values_found) {
							int[] batch_result = pstmt_insert.executeBatch();
							for (int i=0;i<batch_result.length;i++ ) {
								if (batch_result[i]<0  && batch_result[i] != -2) {
									result=0;
									break;
								}
								else {
									result=1;
								}
							}
						} 
						else {
							result=1;
						}
						if(pstmt_insert	!= null)
							closeStatement( pstmt_insert );
					}

					// PH_PATIENT_DRUG_PROFILE 
					if(result > 0){
System.out.println("PH_PATIENT_DRUG_PROFILE7013");
						pstmt_insert		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT4"));
						//pstmt_insert		= connection.prepareStatement("INSERT INTO PH_PATIENT_DRUG_PROFILE (PATIENT_ID,SRL_NO,FACILITY_ID,ENCOUNTER_ID,PATIENT_CLASS,LOCN_TYPE,LOCN_CODE,ROOM_TYPE,ROOM_NO,BED_NO,BED_CLASS,BED_TYPE,SPECIALITY_CODE,ATTEND_PRACTITIONER_ID,PRES_PRACTITIONER_ID,DRUG_CODE,GENERIC_ID,START_DATE,END_DATE,SPLIT_YN,TAPERED_YN,STRENGTH,STRENGTH_UOM_CODE,DOSAGE,DOSAGE_UOM_CODE,SPLIT_DOSE_PREVIEW,FREQ_CODE,DURATION,PRESCRIBED_QTY,DIAG_TEXT,DRUG_REMARKS,IV_PREP_YN,INFUSE_OVER,INFUSE_OVER_UNIT,INFUSION_RATE,INFUSION_VOL_STR_UNIT,INFUSION_PER_UNIT,AMENDED_YN,AMEND_BY_ID,AMEND_DATE_TIME,CANCEL_YN,CANCEL_BY_ID,CANCEL_DATE_TIME,TRN_TYPE_IND,ORIG_FACILITY_ID,ORIG_ORDER_ID,ORIG_ORDER_LINE_NO,TOT_ISSUED_QTY,BROUGHT_BY_PATIENT_YN,ON_HOLD_DATE_TIME,ON_HOLD_BY_ID,ON_HOLD_REASON_CODE,DISCONT_DATE_TIME,DISCONT_BY_ID,DISCONT_REASON_CODE,STOP_YN,STOP_DATE_TIME,STOP_PRACTITIONER_ID,STOP_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ROUTE_CODE,ALLERGY_OVERRIDE_REASON,DOSAGE_LIMIT_OVERRIDE_REASON,IV_INGREDIENTS,DURN_TYPE,DISPENSED_DRUGS,ALTERNATE_GENERIC_ID,DISP_REMARKS,DUPLICATE_DRUG_OVERRIDE_REASON,REFILL_YN,FORM_CODE,DIAG_CODE1,DIAG_CODE1_CAUSE_IND,DIAG_CODE1_SCHEME,DIAG_CODE2,DIAG_CODE2_CAUSE_IND,DIAG_CODE2_SCHEME,DIAG_CODE3,DIAG_CODE3_CAUSE_IND,DIAG_CODE3_SCHEME,PRESCRIBED_MODE,HEIGHT,HEIGHT_UOM,WEIGHT,WEIGHT_UOM,BSA,ALLERGIC_YN,BMI,INTERACTION_OVERRIDE_REASON,CONTRAIND_OVERRIDE_REASON,DRUG_DB_PRODUCT_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

						int srl_NO			= 0;
						String diag_text	= "";
						String perform_external_database_checks="";

						if(diagText.size()>0) {
							diag_text = (String)diagText.get(3)+"~"+(String)diagText.get(7)+"~"+(String)diagText.get(11);
						}
						
						pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT55"));
						pstmt_select.setString(1, getPatId());						
						//pstmt_select.setString(2, login_facility_id);			
						resultSet		= pstmt_select.executeQuery();
						if(resultSet.next()) {
							srl_NO = resultSet.getInt("NEXT_SRL_NO");
						}
						if(resultSet != null) {closeResultSet( resultSet );}
						if(pstmt_select	!= null) {  closeStatement( pstmt_select );}

						for(int i=0; i<drugDetails.size(); i++ ) {
							record		=	(HashMap)drugDetails.get(i);		
							System.out.println("7037record"+record);
							count		=	0;
							diag_text	= "";
							perform_external_database_checks	=(String)record.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
							/*pstmt_select.setString(1, (String)record.get("DRUG_CODE"));
							resultSet	= pstmt_select.executeQuery();
							if (resultSet.next()) {
								order_uom	=	(resultSet.getString("STOCK_UOM"));
							}*/
						
							if(i> 0) {
								++srl_NO;
							} 

							pstmt_insert.setString(++count, getPatId());				//PATIENT_ID
							pstmt_insert.setString(++count, srl_NO + "");				//SRL_NO
							pstmt_insert.setString(++count, login_facility_id);			//FACILITY_ID
							pstmt_insert.setString(++count, getEncId());				//ENCOUNTER_ID
							pstmt_insert.setString(++count, getPatientClass());				//PATIENT_CLASS
							pstmt_insert.setString(++count, getLocationType());					//LOCN_TYPE
							pstmt_insert.setString(++count, getLocationCode());					//LOCN_CODE
							pstmt_insert.setString(++count, "");						 // room_type
							pstmt_insert.setString(++count, "");						// room no
							pstmt_insert.setString(++count, "");						// bed no
							pstmt_insert.setString(++count, "");						// bed class
							pstmt_insert.setString(++count, "");						// bed type
							pstmt_insert.setString(++count, "");						// speciality code
							pstmt_insert.setString(++count, getPractitionerID());					// attend practioner
							pstmt_insert.setString(++count, getPractitionerID());					// pres practitioner
							pstmt_insert.setString(++count, (String)record.get("DRUG_CODE"));  //DRUG_CODE
							pstmt_insert.setString(++count, (String)record.get("GENERIC_ID"));  //GENERIC_ID
							pstmt_insert.setString(++count, (String)record.get("START_DATE"));		//START_DATE
							pstmt_insert.setString(++count, (String)record.get("END_DATE"));		//END_DATE
							pstmt_insert.setString(++count, "N");		//SPLIT_YN
							pstmt_insert.setString(++count, "N");		//TAPERED_YN
							if( !((String)record.get("STRENGTH_VALUE")).equals("") && !((String)record.get("STRENGTH_VALUE")).equals("0")) {
								pstmt_insert.setString(++count, (String)record.get("STRENGTH_VALUE"));	//STRENGTH
								pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM"));		//STRENGTH_UOM_CODE
							}
							else {
								pstmt_insert.setString(++count, "");	//STRENGTH
								pstmt_insert.setString(++count, "");		//STRENGTH_UOM_CODE
							}
							pstmt_insert.setString(++count, (String)record.get("DOSAGE_VALUE"));	//DOSAGE
							pstmt_insert.setString(++count, (String)record.get("DOSAGE_UOM"));		//DOSAGE_UOM_CODE				
							
							pstmt_insert.setString(++count, split_dose_preview);				//SPLIT_DOSE_PREVIEW
							pstmt_insert.setString(++count, (String)record.get("FREQ_CODE"));							//FREQ_CODE 
							pstmt_insert.setString(++count, (String)record.get("DURN_VALUE"));  //DURATION
							pstmt_insert.setString(++count, (String)record.get("ABSOL_QTY"));						//PRESCRIBED_QTY
							pstmt_insert.setString(++count, diag_text);  //DIAG_TEXT
							pstmt_insert.setString(++count, ""); // drug remarks				
							pstmt_insert.setString(++count, "6"); //IV_PREP_YN
							pstmt_insert.setString(++count, ""); //INFUSE_OVER
							pstmt_insert.setString(++count,"");
							pstmt_insert.setString(++count, ""); //INFUSION_RATE
							pstmt_insert.setString(++count, ""); //INFUSION_VOL_STR_UNIT
							pstmt_insert.setString(++count, "");  // infusion per unit			
							pstmt_insert.setString(++count, "N"); // amend_yn
							pstmt_insert.setString(++count, ""); // amend by id
							pstmt_insert.setString(++count, null); // amend_date
							pstmt_insert.setString(++count, "N");  // cancel yn
							pstmt_insert.setString(++count, "");  // cancel by id
							pstmt_insert.setString(++count, null); // cancel date
							pstmt_insert.setString(++count, "P"); //TRN_TYPE_IND 
							pstmt_insert.setString(++count, login_facility_id);
							pstmt_insert.setString(++count, order_id); // orig order id
							pstmt_insert.setString(++count, (i+1)+"");  // line no
							pstmt_insert.setString(++count, "");  // tot issued qty
							pstmt_insert.setString(++count, "N"); //BROUGHT_BY_PATIENT_YN
							pstmt_insert.setString(++count, null); //ON_HOLD_DATE_TIME
							pstmt_insert.setString(++count, ""); //ON_HOLD_BY_ID
							pstmt_insert.setString(++count, ""); //ON_HOLD_REASON_CODE 
							pstmt_insert.setString(++count, null); //DISCONT_DATE_TIME
							pstmt_insert.setString(++count, ""); //DISCONT_BY_ID 
							pstmt_insert.setString(++count, ""); //DISCONT_REASON_CODE
							pstmt_insert.setString(++count, "N"); //STOP_YN
							pstmt_insert.setString(++count, null); //STOP_DATE_TIME
							pstmt_insert.setString(++count, ""); //STOP_PRACTIONER_ID
							pstmt_insert.setString(++count, ""); //STOP_REMARKS
							pstmt_insert.setString(++count, login_by_id);
							pstmt_insert.setString(++count, login_at_ws_no);
							pstmt_insert.setString(++count, login_facility_id);
							pstmt_insert.setString(++count, login_by_id);
							pstmt_insert.setString(++count, login_at_ws_no);
							pstmt_insert.setString(++count, login_facility_id);

							pstmt_insert.setString(++count, (String)record.get("ROUTE_CODE"));  //ROUTE_CODE
					
							if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN")).equals("Y")){
								pstmt_insert.setString(++count, (String)record.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
							}
							else if(!((String)record.get("ALLERGY_REMARKS")).equals("")){
								pstmt_insert.setString(++count, (String)record.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON
							}
							else {
								pstmt_insert.setString(++count, "");
							}

							if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
								pstmt_insert.setString(++count, (String)record.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"));
							}
							else if(!((String)record.get("DOSE_REMARKS")).equals("")){
								pstmt_insert.setString(++count, (String)record.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON				
							}
							else{
								pstmt_insert.setString(++count, "");
							}

							/*if(perform_external_database_checks.equals("N")){
								pstmt_insert.setString(++count, (String)record.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON
								pstmt_insert.setString(++count, (String)record.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
							}else{
								if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN")).equals("Y")){
										pstmt_insert.setString(++count, (String)record.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
								}else{
										pstmt_insert.setString(++count, "");
								}
								if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
										pstmt_insert.setString(++count, (String)record.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"));
								}else{
										pstmt_insert.setString(++count, "");
								}
							}*/
							
							pstmt_insert.setString(++count, ""); //IV_INGREDIENTS
							pstmt_insert.setString(++count, (String)record.get("DURN_TYPE"));   //DURN_TYPE
							pstmt_insert.setString(++count, ""); //DISPENSED_DRUGS
							pstmt_insert.setString(++count, ""); //ALTERNATE_GENERIC_ID
							pstmt_insert.setString(++count, ""); //DISP_REMARKS 

							if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
								pstmt_insert.setString(++count, (String)record.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"));
							}
							else if(!((String)record.get("CURRENTRX_REMARKS")).equals("")){
								pstmt_insert.setString(++count, (String)record.get("CURRENTRX_REMARKS")); //DUPLICATE_DRUG_OVERRIDE_REASON				
							}
							else{
								pstmt_insert.setString(++count, "");
							}
							/*if(perform_external_database_checks.equals("N")){	
								pstmt_insert.setString(++count, (String)record.get("CURRENTRX_REMARKS")); //CURRENTRX_REMARKS 
							}else{
								if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
										pstmt_insert.setString(++count, (String)record.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"));
								}else{
										pstmt_insert.setString(++count, "");
								}
							}*/
							pstmt_insert.setString(++count, "N"); //REFILL_YN 
							pstmt_insert.setString(++count, (String)record.get("FORM_CODE")); //FORM_CODE
							//DIAG_CODES
							if(diagText.size()>0) {
								pstmt_insert.setString(++count, (String)diagText.get(0));
								pstmt_insert.setString(++count, (String)diagText.get(1));
								pstmt_insert.setString(++count, (String)diagText.get(2));
								pstmt_insert.setString(++count, (String)diagText.get(4));
								pstmt_insert.setString(++count, (String)diagText.get(5));
								pstmt_insert.setString(++count, (String)diagText.get(6));
								pstmt_insert.setString(++count, (String)diagText.get(8));
								pstmt_insert.setString(++count, (String)diagText.get(9));
								pstmt_insert.setString(++count, (String)diagText.get(10));
							}
							else {
								pstmt_insert.setString(++count, "");
								pstmt_insert.setString(++count, "");
								pstmt_insert.setString(++count, "");
								pstmt_insert.setString(++count, "");
								pstmt_insert.setString(++count, "");
								pstmt_insert.setString(++count, "");
								pstmt_insert.setString(++count, "");
								pstmt_insert.setString(++count, "");
								pstmt_insert.setString(++count, "");
							}

							pstmt_insert.setString(++count, (String)record.get("DOSAGE_TYPE")); //PRESCRIBED_MODE
							pstmt_insert.setString(++count, height);
							pstmt_insert.setString(++count, height_uom);
							pstmt_insert.setString(++count, weight);
							pstmt_insert.setString(++count, weight_uom);
							pstmt_insert.setString(++count, bsa);
							pstmt_insert.setString(++count, allergic_yn);
							pstmt_insert.setString(++count, bmi);
							if(perform_external_database_checks.equals("N")){	
								pstmt_insert.setString(++count, ""); //EXTERNAL_INTERACTION_OVERRIDE_REASON 
							}
							else{
								if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN")).equals("Y")){
									pstmt_insert.setString(++count, (String)record.get("EXTERNAL_INTERACTION_OVERRIDE_REASON"));
								}
								else{
									pstmt_insert.setString(++count, "");
								}
							}
							if(perform_external_database_checks.equals("N")){	
								pstmt_insert.setString(++count, ""); //EXTERNAL_INTERACTION_OVERRIDE_REASON 
							}
							else{
								if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN")).equals("Y")){
									pstmt_insert.setString(++count, (String)record.get("EXTERNAL_CONTRA_OVERRIDE_REASON"));
								}
								else{
									pstmt_insert.setString(++count, "");
								}
							}
							System.out.println("7262record"+record);
							pstmt_insert.setString(++count, (String)record.get("DRUG_DB_PRODUCT_ID"));
							pstmt_insert.setString(++count, (String)record.get("ABUSE_OVERRIDE"));//ADDED FOR AAKH-CRF-0140
							pstmt_insert.setString(++count, (String)record.get("abuse_override_remarks"));//ADDED FOR AAKH-CRF-0140
							
							pstmt_insert.addBatch();
						}
						int[] batch_result2 = pstmt_insert.executeBatch();
						for (int i=0;i<batch_result2.length; i++ ) {
							if (batch_result2[i]<0  && batch_result2[i] != -2) {
								result = 0;
								pstmt_insert.cancel();
								throw new Exception("Patient Drug Profile Failed");
							}
							else{
								result = 1;
							}
						}
						if(pstmt_insert	!= null)  
							closeStatement( pstmt_insert );
					}

					// WORK LOAD STATUS
					if(result > 0){			
						String dly_count						 = "";
						String monthly_count					 = "";
						String dly_count_loc					 = "";
						String monthly_count_loc				 = "";

						int totalOrder	=	1;
							//orderDetails.size() + drugList.size();
						int totalDrugs	  =	1;
							totalDrugs	+= getDrugDetails().size();
						
						String patient_Class	= getPatientClass();
						String locationType		= getLocationType();
						String locationCode		= getLocationCode();
								
						pstmt_workload		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT72")) ;
						pstmt_workload.setString(1,getPractitionerID());
						pstmt_workload.setString(2,login_facility_id);
						pstmt_workload.setString(3,patient_Class);

						resultSet_workload  	= pstmt_workload.executeQuery() ;

						while (resultSet_workload.next()){
								dly_count		= (resultSet_workload.getString("DLYCOUNT")).trim();				
							}
						
						if(resultSet_workload != null) {closeResultSet( resultSet_workload );}
						if(pstmt_workload	!= null) {  closeStatement( pstmt_workload );}

						pstmt_workload		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT73")) ;
						pstmt_workload.setString(1,getPractitionerID());
						pstmt_workload.setString(2,login_facility_id);
						pstmt_workload.setString(3,patient_Class);

						resultSet_workload  	= pstmt_workload.executeQuery() ;
						while (resultSet_workload.next()){
							monthly_count			=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
						}
						if(resultSet_workload != null) 
							closeResultSet( resultSet_workload );
						if(pstmt_workload	!= null) 
							closeStatement( pstmt_workload );
					
						if(dly_count.equals("0")){
							workload_insert		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT9")) ;
							workload_insert.setString( 1, getPractitionerID());
							workload_insert.setString( 2, login_facility_id);
							workload_insert.setString( 3, patient_Class);
							workload_insert.setString( 4,String.valueOf(totalOrder));
							workload_insert.setString( 5,String.valueOf(totalDrugs));
							workload_insert.setString( 6, login_by_id);
							workload_insert.setString( 7, login_at_ws_no);
							workload_insert.setString( 8, login_facility_id);
							workload_insert.setString( 9, login_by_id);
							workload_insert.setString( 10, login_at_ws_no);
							workload_insert.setString( 11, login_facility_id);
							workload_insert.executeUpdate();
						} 
						else {
							workload_insert		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY6")) ;
							workload_insert.setString( 1,String.valueOf(totalOrder));
							workload_insert.setString( 2,String.valueOf(totalDrugs));
							workload_insert.setString( 3, login_by_id);
							workload_insert.setString( 4, login_at_ws_no);
							workload_insert.setString( 5, login_facility_id);
							workload_insert.setString( 6, getPractitionerID());
							workload_insert.setString( 7, login_facility_id);
							workload_insert.setString( 8, patient_Class);
							workload_insert.executeUpdate();
						}
					
						if(monthly_count.equals("0")) {
							work_insert_month		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT10")) ;
							work_insert_month.setString( 1, getPractitionerID());
							work_insert_month.setString( 2, login_facility_id);
							work_insert_month.setString( 3, patient_Class);
							work_insert_month.setString( 4,String.valueOf(totalOrder));
							work_insert_month.setString( 5,String.valueOf(totalDrugs));
							work_insert_month.setString( 6, login_by_id);
							work_insert_month.setString( 7, login_at_ws_no);
							work_insert_month.setString( 8, login_facility_id);
							work_insert_month.setString( 9, login_by_id);
							work_insert_month.setString( 10, login_at_ws_no);
							work_insert_month.setString( 11, login_facility_id);
							work_insert_month.executeUpdate();
						} 
						else {
							work_insert_month		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY7")) ;
							work_insert_month.setString( 1,String.valueOf(totalOrder));
							work_insert_month.setString( 2,String.valueOf(totalDrugs));
							work_insert_month.setString( 3, login_by_id);
							work_insert_month.setString( 4, login_at_ws_no);
							work_insert_month.setString( 5, login_facility_id);
							work_insert_month.setString( 6, getPractitionerID());
							work_insert_month.setString( 7, login_facility_id);
							work_insert_month.setString( 8, patient_Class);
							work_insert_month.executeUpdate();
						}
						pstmt_workload			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT74")) ;
						pstmt_workload.setString(1,locationType);
						pstmt_workload.setString(2,login_facility_id);
						pstmt_workload.setString(3,locationCode);
						resultSet_workload  	= pstmt_workload.executeQuery() ;

						while (resultSet_workload.next()){
							dly_count_loc	= (resultSet_workload.getString("DLYCOUNT")).trim();				
						}
						
						if(resultSet_workload != null) 
							closeResultSet( resultSet_workload );
						if(pstmt_workload	!= null) 
							closeStatement( pstmt_workload );

						pstmt_workload			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT75")) ;
						pstmt_workload.setString(1,locationType);
						pstmt_workload.setString(2,login_facility_id);
						pstmt_workload.setString(3,locationCode);

						resultSet_workload  	= pstmt_workload.executeQuery() ;
						while (resultSet_workload.next()){
							monthly_count_loc		=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
						}
						if(resultSet_workload != null) 
							closeResultSet( resultSet_workload );
						if(pstmt_workload	!= null) 
							closeStatement( pstmt_workload );
					
						if(dly_count_loc.equals("0")) {
							work_insert_loc = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT11")) ;
							work_insert_loc.setString(1,login_facility_id);
							work_insert_loc.setString(2, locationType);
							work_insert_loc.setString(3, locationCode);
							work_insert_loc.setString(4,String.valueOf(totalOrder));
							work_insert_loc.setString(5,String.valueOf(totalDrugs));
							work_insert_loc.setString(6, login_by_id);
							work_insert_loc.setString(7, login_at_ws_no);
							work_insert_loc.setString(8, login_facility_id);
							work_insert_loc.setString(9, login_by_id);
							work_insert_loc.setString(10, login_at_ws_no);
							work_insert_loc.setString(11, login_facility_id);
							work_insert_loc.executeUpdate();
						}
						else {
							work_insert_loc = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY8")) ;
							work_insert_loc.setString(1,String.valueOf(totalOrder));
							work_insert_loc.setString(2,String.valueOf(totalDrugs));
							work_insert_loc.setString(3, login_by_id);
							work_insert_loc.setString(4, login_at_ws_no);
							work_insert_loc.setString(5, login_facility_id);
							work_insert_loc.setString(6, locationType);
							work_insert_loc.setString(7, login_facility_id);
							work_insert_loc.setString(8, locationCode);
							work_insert_loc.executeUpdate();
						}

						if(monthly_count_loc.equals("0")) {
							work_insert_loc_mon =  connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT12")) ;
							work_insert_loc_mon.setString(1,login_facility_id);
							work_insert_loc_mon.setString(2, locationType);
							work_insert_loc_mon.setString(3, locationCode);
							work_insert_loc_mon.setString(4,String.valueOf(totalOrder));
							work_insert_loc_mon.setString(5,String.valueOf(totalDrugs));
							work_insert_loc_mon.setString(6, login_by_id);
							work_insert_loc_mon.setString(7, login_at_ws_no);
							work_insert_loc_mon.setString(8, login_facility_id);
							work_insert_loc_mon.setString(9, login_by_id);
							work_insert_loc_mon.setString(10, login_at_ws_no);
							work_insert_loc_mon.setString(11, login_facility_id);
							work_insert_loc_mon.executeUpdate();
						}
						else {
							work_insert_loc_mon =  connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY9")) ;
							work_insert_loc_mon.setString(1,String.valueOf(totalOrder));
							work_insert_loc_mon.setString(2,String.valueOf(totalDrugs));
							work_insert_loc_mon.setString(3, login_by_id);
							work_insert_loc_mon.setString(4, login_at_ws_no);
							work_insert_loc_mon.setString(5, login_facility_id);
							work_insert_loc_mon.setString(6, locationType);
							work_insert_loc_mon.setString(7, login_facility_id);
							work_insert_loc_mon.setString(8, locationCode);
							work_insert_loc_mon.executeUpdate();
						}
					}
					result = 1;
					String auto_order_regn_err = "";
					String tokens_generated_yn = "";
					if (result>0) {
						if((getPatientClass().equals("OP") || getPatientClass().equals("EM")) && !trn_group_ref.equals("")){
							cstmt_insert=connection.prepareCall("{call ph_auto_order_regn(?,?,?,?,?,?)}");
							cstmt_insert.setString( 1, trn_group_ref);
							cstmt_insert.setString( 2, getPatId());
							cstmt_insert.setString( 3, login_facility_id);
							cstmt_insert.setString( 4, getEncId());
							cstmt_insert.registerOutParameter(5, Types.VARCHAR );
							cstmt_insert.registerOutParameter(6, Types.VARCHAR );
							cstmt_insert.execute() ;

							tokens_generated_yn = cstmt_insert.getString(5)==null ? "":cstmt_insert.getString(5);
							auto_order_regn_err = cstmt_insert.getString(6)==null ? "":cstmt_insert.getString(6);
							try{
								closeResultSet( resultSet ) ;
								closeStatement( cstmt_insert ) ;
							}
							catch(Exception es){
								es.printStackTrace() ;
							}
						}
					}
					if (auto_order_regn_err.equals("")) {
						map.put("result", new Boolean(true));
						map.put("msgid", getMessage(getLanguageId(),"RECORD_INSERTED","PH"));
						setTrnGroupRef(trn_group_ref);
						setTokensGeneratedYN(tokens_generated_yn);
						connection.commit();
					}
					else {
						map.put("msgid", auto_order_regn_err);
						connection.rollback();
						System.err.println("Exception in Work Load functions... map="+map);
					}
				}
				if(stock_result.equals("")) {
					map.put("result", new Boolean(true));
					map.put("message", getMessage(getLanguageId(),"RECORD_INSERTED","PH"));

					connection.commit();
				}
				else {
					map.put("result", new Boolean(false));
					map.put("message", getMessage(getLanguageId(),"INSUFFICIENT_STOCK","PH"));
					map.put("flag","INSUFFICIENT_STOCK");
				}
			}
		}
		catch(Exception e) {
			try {
				connection.rollback();
				throw new Exception(this + " : " + e.getMessage());
			}
			catch (Exception ee) {
				map.put("msgid", ee.getMessage());
			}
			map.put("msgid", e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resultSet );
				closeStatement(pstmt_insert	);
				closeStatement(cstmt_insert);
				closeStatement(pstmt_select);
				closeStatement(pstmt_workload);
				closeStatement(workload_insert);		 
				closeStatement(work_insert_month);		 
				closeStatement(work_insert_loc)	;	 
				closeStatement(work_insert_loc_mon);	 
				closeResultSet(resultSet_workload );
				closeConnection(connection) ;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}	
		return map;
	}

	public HashMap prepareOrderDetails(Hashtable submitData) {
		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "test");
		
		//Connection connection	= null;
		//PreparedStatement pstmt = null;
		//ResultSet resultSet		= null;
		String ord_auth_reqd_yn		= "N";
		String ord_appr_reqd_yn		= "N";
		String ord_cosign_reqd_yn	= "N";
		String ord_consent_reqd_yn	= "N";
		String drug_desc 			= "";
		String drug_code 			= "";
		String freqDurnType			= "";
		HashMap schd_week_hr_dates	=	new HashMap();
        ArrayList temp =new ArrayList();
		temp = getDrugDetails();
	
		if (temp.size() != 0) {
			for (int i=0; i<temp.size(); i++) {
				HashMap tempMap = (HashMap)temp.get(i);

				if (tempMap.size() != 0) {
					drug_desc = drug_desc + tempMap.get("DRUG_DESC").toString() + "|";
					//for ivpb only, in ivpb only one drug one fluid wil be there. - for multi freq crf
					drug_code = tempMap.get("DRUG_CODE").toString();
					
					if (tempMap.get("ORD_AUTH_REQD_YN") != null && tempMap.get("ORD_AUTH_REQD_YN").toString().equals("Y"))
						ord_auth_reqd_yn = "Y";

					if (tempMap.get("ORD_SPL_APPR_REQD_YN") != null && tempMap.get("ORD_SPL_APPR_REQD_YN").toString().equals("Y"))
						ord_appr_reqd_yn = "Y";

					if (tempMap.get("ORD_COSIGN_REQD_YN") != null && tempMap.get("ORD_COSIGN_REQD_YN").toString().equals("Y"))
						ord_cosign_reqd_yn = "Y";

					if (tempMap.get("CONSENT_REQD_YN") != null && tempMap.get("CONSENT_REQD_YN").toString().equals("Y"))
						ord_consent_reqd_yn = "Y";
				}
			}
		}
		String fluid_desc = getFluidDetails().get("DRUG_DESC").toString();
		
		HashSet keyset=new HashSet(); //Added for Bru-HIMS-CRF-393_1.0-Start
		keyset.add((String)submitData.get("ORDER_TYPE_CODE"));
		setPrintOrdShtRuleInd(keyset,getPatientClass());	//Added for Bru-HIMS-CRF-393_1.0-End
		HashMap orderDetails = new HashMap();
		orderDetails.put("ORDER_ID", getOrderID());
		orderDetails.put("IV_PB", getIVPB());
		orderDetails.put("ORDER_TYPE_CODE", submitData.get("ORDER_TYPE_CODE"));
		orderDetails.put("PATIENT_ID", getPatId());
		orderDetails.put("PATIENT_CLASS", getPatientClass());
		orderDetails.put("ENCOUNTER_ID", getEncId());
		orderDetails.put("SOURCE_TYPE", submitData.get("LOCN_TYPE"));
		orderDetails.put("SOURCE_CODE", submitData.get("LOCN_CODE"));
		orderDetails.put("BED_NUM", submitData.get("BED_NUM"));
		orderDetails.put("ROOM_NUM", submitData.get("ROOM_NUM"));
		orderDetails.put("INFUSE_OVER_UNIT", submitData.get("INFUSE_OVER_UNIT"));//INO71514
		String locn_code  = (String)submitData.get("LOCN_CODE");//SKR-SCF-1254 - start
			String source_code = "";
			if(getPatientClass().equals("IP")){
				 source_code = getCurrentLocn(patient_id,encounter_id);
				 if(source_code==null)
					 source_code="";
				 if( !source_code.equals("") && !source_code.equals(locn_code))
					orderDetails.put("SOURCE_CODE",source_code);
			}

		if(getOrder_type_flag().equals("Existing")){    //Converted date for IN23819 -- 21/09/2010-- priya
            orderDetails.put("ORD_DATE", com.ehis.util.DateUtils.convertDate(getSysdate(),"DMYHM","en",getLanguageId()));
		}
		else{
		    orderDetails.put("ORD_DATE", submitData.get("ord_date_time"));	
		}
	   if(!getLanguageId().equals("en")){
		   orderDetails.put("ORD_DATE", com.ehis.util.DateUtils.convertDate((String)orderDetails.get("ORD_DATE"),"DMYHM",getLanguageId(),"en"));
		   orderDetails.put("START_DATE", com.ehis.util.DateUtils.convertDate((String)submitData.get("START_DATE"),"DMYHM",getLanguageId(),"en"));
		   orderDetails.put("END_DATE", com.ehis.util.DateUtils.convertDate((String)submitData.get("END_DATE"),"DMYHM",getLanguageId(),"en"));
	   }
	   else{
		  orderDetails.put("START_DATE", submitData.get("START_DATE"));
		  orderDetails.put("END_DATE", submitData.get("END_DATE"));
	   }
//System.out.println("===========submitData================="+submitData);
		orderDetails.put("ORD_PRACT_ID", submitData.get("PRACT_ID"));
		orderDetails.put("PRIORITY", submitData.get("PRIORITY"));
		orderDetails.put("ORD_AUTH_REQD_YN", ord_auth_reqd_yn);
		orderDetails.put("ORD_APPR_REQD_YN", ord_appr_reqd_yn);
		orderDetails.put("ORD_COSIGN_REQD_YN", ord_cosign_reqd_yn);
		orderDetails.put("ORDER_STATUS", getOrderStatus());
		orderDetails.put("ORD_CONSENT_REQD_YN", ord_consent_reqd_yn);
		orderDetails.put("IV_INGREDIANTS", fluid_desc + "|" + drug_desc);
		orderDetails.put("SCH_INFUSION_RATE", submitData.get("INFUSION_VALUE") );
		orderDetails.put("SCH_INFUSION_VOL_STR_UNIT", submitData.get("EQVL_UOM_CODE"));
		orderDetails.put("SCH_INFUSION_PERIOD", submitData.get("INFUSION_VALUE")  );
		orderDetails.put("SCH_INFUSION_PERIOD_UNIT", submitData.get("INFUSION_UOM"));
		orderDetails.put("INFUSE_OVER", submitData.get("infusion_over_insert_value") );
		
		//INO71514 START
		if(submitData.get("INFUSE_OVER_UNIT")!=null){ 
			orderDetails.put("INFUSE_OVER_UNIT", submitData.get("INFUSE_OVER_UNIT")); 
		}else
		{
			orderDetails.put("INFUSE_OVER_UNIT", submitData.get("INFUSION_PERIOD_UOM"));			
		}
		//INO71514 END

		
		
		orderDetails.put("FLUID_UNIT_QTY", submitData.get("STOCK_VALUE")   );
//((String)((HashMap)((ArrayList)getDrugDetails.get(0))).get("DRUG_CODE"))
		if(((String)((HashMap)getFluidDetails()).get("DRUG_CODE")).equals(drug_code) && ((String)((HashMap)getFluidDetails()).get("DOSAGE_TYPE")).equals("S")) {
			orderDetails.put("FLUID_UNIT_QTY_UOM", (String)((HashMap)getFluidDetails()).get("STRENGTH_UOM"));
		}
		else{
			orderDetails.put("FLUID_UNIT_QTY_UOM", submitData.get("STOCK_UOM_CODE"));
		}
//		orderDetails.put("FLUID_UNIT_QTY_UOM", submitData.get("STOCK_UOM_CODE"));
		getScheduledFreqYN((String)submitData.get("FREQUENCY"));
		orderDetails.put("FREQ_NATURE", getFrequencyNature());
		orderDetails.put("REP_INTERVAL", getRepeatValue() );
		orderDetails.put("INT_VALUE", getIntervalValue() );
		orderDetails.put("FREQ_CODE", submitData.get("FREQUENCY"));
		orderDetails.put("HEIGHT", submitData.get("HEIGHT"));
		orderDetails.put("HEIGHT_UNIT", submitData.get("HEIGHT_UNIT"));
		orderDetails.put("WEIGHT", submitData.get("WEIGHT"));
		orderDetails.put("WEIGHT_UNIT", submitData.get("WEIGHT_UNIT"));
		orderDetails.put("BSA", submitData.get("BSA"));
		orderDetails.put("BMI", submitData.get("BMI"));
		orderDetails.put("BSA_UNIT", submitData.get("BSA_UNIT"));
		orderDetails.put("TAKEHOME_MEDN", submitData.get("TH_MEDN"));
		orderDetails.put("DURN_UNIT", submitData.get("DURN_UNIT"));
		//Added for  ML-BRU-CRF-072[Inc:29938] 
		if(submitData.get("DURN_VALUE")==null || ((String)submitData.get("DURN_VALUE")).equals(""))
			orderDetails.put("DURN_VALUE", "0" );
		else
			orderDetails.put("DURN_VALUE", submitData.get("DURN_VALUE") );
		
		orderDetails.put("BASE_UOM", getStockUOM());
		orderDetails.put("PACK_SIZE", getPackSize() );

		String temp_mfr_remarks=(String)submitData.get("mfr_remarks")==null?"":(String)submitData.get("mfr_remarks");
		if(!temp_mfr_remarks.equals("")){
			try	{
				temp_mfr_remarks=java.net.URLDecoder.decode(temp_mfr_remarks,"UTF-8");
			}
			catch (UnsupportedEncodingException except)	{
				except.printStackTrace();
			}
		}			
		orderDetails.put("MFR_REMARKS",temp_mfr_remarks);
		if(getIVPB().equals("Y")){
			HashMap freqDet = getscheduleFrequency();
			orderDetails.put("DURN_VALUE_ACT", (String)submitData.get("DURN_VALUE") );
			if(((String)orderDetails.get("FREQ_NATURE")).equals("I")){
				HashMap freqNature			=(HashMap)freqValidate((String)submitData.get("FREQUENCY"));
				orderDetails.put("IntervalFreqDet", freqNature );
				freqDurnType =  (String)freqNature.get("interval_durn_type");
			}
			else{
				freqDurnType = (String)(((HashMap)(((ArrayList)freqDet.get(drug_code)).get(0))).get("durationType"));
			}

			if(freqDurnType.equals((String)submitData.get("DURN_UNIT"))){
				orderDetails.put("DURN_VALUE",(String)submitData.get("DURN_VALUE"));
			}
			else{
				int durn_calc = getDurationCalc((String)submitData.get("DURN_UNIT"),(String)submitData.get("DURN_VALUE"),freqDurnType);
				orderDetails.put("DURN_VALUE",durn_calc+"" );
				HashMap drugDetail = (HashMap)((ArrayList)getDrugDetails()).get(0);
				drugDetail.put("DURN_VALUE",durn_calc+"");
				HashMap fluidDetail = getFluidDetails();
				fluidDetail.put("DURN_VALUE",durn_calc+"");
			}
		}
		
		//code added for setting Prescribed qty...on 12/5/2004
		if(getIVType().equals("IVD"))
			orderDetails.put("IVType" , getIVType());
		//ended..
	
		if(getIVType().equals("IVD")){
				orderDetails.put("IV_PRESC", submitData.get("IV_PRESC_YN").toString());
		}
		else{
			if (submitData.get("IV_PRESC_YN").toString().equals("Y"))
				orderDetails.put("IV_PRESC", "I");
			else
				orderDetails.put("IV_PRESC", "N");
		}
	
		if(getIVPB().equals("Y")) {
			if(((String)orderDetails.get("IV_PRESC")).equals("I")) {
				setIVPrep("4");
			} 
			else {
				setIVPrep("3");
			}
            orderDetails.put("QTY_VALUE", getDOSAGE());
			orderDetails.put("vehicle_volume", getVOLUME());
			 
		} 
		else if(((String)orderDetails.get("IVType")).equals("IVD")){
			if(((String)orderDetails.get("IV_PRESC")).equals("I")) {
				setIVPrep("2");
			}
			else {
				setIVPrep("1");
			}
			orderDetails.put("vehicle_volume", getVOLUME());
		} 
		orderDetails.put("BUILD_MAR_YN", submitData.get("buildMAR_yn").toString());  //CRF-0062

		/*try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT8"));
			pstmt.setString(1, login_facility_id);
			resultSet	= pstmt.executeQuery();

			if(resultSet.next()) {
				orderDetails.put("MED_ADMIN_REQD_YN", checkNullResult(resultSet.getString("MED_ADMIN_REQD_YN"), "N"));
			}
		}
		catch(Exception e) {
			System.err.println("Error while getting MED_ADMIN_REQD_YN" + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				System.err.println("Error while getting MED_ADMIN_REQD_YN" + es);
			}
		}*/
		orderDetails.put("MFR_Recs",getMFRRecs());
		orderDetails.put("MFR_YN",MFRYN);
		if(MFRYN.equals("Y")){
		/*	orderDetails.put("SCH_INFUSION_RATE", submitData.get("INFUSION_VALUE") );
			orderDetails.put("SCH_INFUSION_VOL_STR_UNIT", submitData.get("EQVL_UOM_CODE"));
			orderDetails.put("SCH_INFUSION_PERIOD_UNIT", submitData.get("INFUSION_UOM"));
*/
			orderDetails.put("INFUSE_OVER", getMFRRecs().get("totFlowDurnHrs") );
			
			if(!getLanguageId().equals("en")){
				orderDetails.put("START_DATE",com.ehis.util.DateUtils.convertDate((String)getMFRRecs().get("flowStartDate"),"DMYHM",getLanguageId(),"en"));
				orderDetails.put("END_DATE",com.ehis.util.DateUtils.convertDate((String)getMFRRecs().get("flowEndDate"),"DMYHM",getLanguageId(),"en"));
			}
			else{
				orderDetails.put("START_DATE", getMFRRecs().get("flowStartDate") );
				orderDetails.put("END_DATE", getMFRRecs().get("flowEndDate") );
			}
			orderDetails.put("DURN_VALUE", getMFRRecs().get("totDurnHrs") );
		}
		String take_home_medn_op="N";
		if(getTakeHomeMedicationOp()==null || getTakeHomeMedicationOp().equals("")){//Added for NMC-JD-CRF-0063 START
			setTakeHomeMedicationOp("N");  
		}
		if(getTakeHomeMedicationOp().equals("Y") && getOpDischMedInd().equals("Y") && !getOpDischMedInd().equals("") && getOpDischMedInd()!=null){
			take_home_medn_op="Y";
		}
		
		orderDetails.put("OP_DISCH_MED_IND", getOpDischMedInd()); 
		orderDetails.put("TAKEHOMEMED_OP", take_home_medn_op);//END 
		orderDetails.put("TAKE_HOME_OP_SITESPECIFIC", getTakeHomeMedicationOp()); 
		boolean site_alw_disp_loc_drug_search_appl = isSiteSpecific("PH","PH_DISP_LOC_DRUG_SEARCH"); //added for NMC-JD-CRF-0197
		if(site_alw_disp_loc_drug_search_appl) {  //added for NMC-JD-CRF-0197
			orderDetails.put("DISP_LOC_CODE1",getDisp_locn_code());															 
		}
		System.out.println("orderDetails: "+orderDetails);  //ADDED FOR NMC-JD-CRF-0063
		HashMap commonData = new HashMap();
		commonData.put("login_by_id",		login_by_id);
		commonData.put("login_at_ws_no",	login_at_ws_no);
		commonData.put("login_facility_id",	login_facility_id);

		HashMap tabData = new HashMap();
		tabData.put("COMMONDATA", commonData);
		tabData.put("PROPERTIES", getProperties());
		tabData.put("ORDERDETAILS", orderDetails);
		tabData.put("SCHEDULEFREQ", getscheduleFrequency());
		tabData.put("FLUIDDETAILS", getFluidDetails());
		tabData.put("DRUGDETAILS", getDrugDetails());
		tabData.put("DRUGREMARKS", getDrugRemarks());

		tabData.put("DIAG_TEXT", getDiagText());
		tabData.put("LICENSE",(String)(PhLicenceRights.getKey()));
		String or_mode ="";
		if(submitData.get("OR_MODE")!=null){
			or_mode = (String)submitData.get("OR_MODE");
		}
		tabData.put("OR_MODE",or_mode);
		boolean scheduled_drug=getScheduledFreqYN((String)(getFluidDetails().get("FREQ_CODE")));
		if(scheduled_drug)
			tabData.put("SCHEDULED_DRUG","Y");
		else
			tabData.put("SCHEDULED_DRUG","N");
		
		tabData.put("ORDER_COMMENTS",getAmendOrderRemarks());
		tabData.put("allergic_yn",submitData.get("allergic_yn"));
		if(getIVPB().equals("Y")){
			if(((String)orderDetails.get("FREQ_NATURE")).equals("I")){
				schd_week_hr_dates = getSchdDatesFrWeekHrInterval(getscheduleFrequency(),getDrugDetails(),orderDetails,"CREATE");
			}
			else{
				schd_week_hr_dates = getSchdDatesFrWeekHr(getscheduleFrequency(),getDrugDetails(),"CREATE");
			}
			tabData.put("sched_date_time_wkhr",schd_week_hr_dates);
		}
// MFRYN is a global variable that is set from validation page		
		if(MFRYN.equals("Y")){
			getAdminRateReleaseMFR(tabData);
		}
		getAdminRateRelease(tabData);
		tabData.put("Admin_rate",getAdminRate());

		tabData.put("fluid_remarks",getFluidRemarks());
		tabData.put("lang_id",getLanguageId());
		tabData.put("print_mar_barcode_yn",getPrintMarBarcode()); //Added for MMS-QH-CRF-0080 [IN:038064]
		tabData.put("print_mar_label_yn",getPrintMarLabel());//Added for MMS-QH-CRF-0080 [IN:038064]
		tabData.put("iv_calc_infuse_by",getIVCalcInfuseBy());//Added for SKR-CRF-0035

		String result = "";
		result	=	validateStock(orderDetails,getFluidDetails(),getDrugDetails());
		if((result.trim()).equals("")){
			HashMap sqlMap = new HashMap();
			try {
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT20A",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT20A"));
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT19A",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT19A"));
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT54",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54"));
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT56",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56"));
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT24A",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT24A"));
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT53",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53"));
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT25A",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT25A"));
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT55",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT55"));
				sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT1",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT1"));
				sqlMap.put("SQL_PH_PRESCRIPTION_INSERT2",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT2A"));
//				sqlMap.put("SQL_PH_PRESCRIPTION_INSERT3A",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT3A")); new column added MFR_YN
				//modified for aakh-crf-0140
				sqlMap.put("SQL_PH_PRESCRIPTION_INSERT3A",	"INSERT INTO OR_ORDER_LINE_PH (ORDER_ID,ORDER_LINE_NUM,GENERIC_ID,FORM_CODE,TRADE_CODE,FORMULARY_ITEM_YN,DOSAGE_TYPE,SPLIT_DRUG_PREVIEW,TOT_STRENGTH,TOT_STRENGTH_UOM,INFUSE_OVER,INFUSE_OVER_UNIT,INFUSION_RATE,INFUSION_VOL_STR_UNIT,INFUSION_PER_UNIT,BROUGHT_BY_PATIENT_YN,CUR_DRUG_YN,REFILL_DRUG_YN,DISPENSING_LOC_TYPE,DISPENSING_LOC,DISPENSING_STORE,IP_FILL_PROCESS,IP_FILL_PRD_AHEAD,NEXT_FILL_DATE,LAST_FILL_QTY,DISPENSED_QTY,BMS_QTY,BMS_STRENGTH,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SPLIT_DOSE_YN,QTY_VALUE_SPLIT_DOSE,QTY_UNIT_SPLIT_DOSE,STRENGTH_VALUE,STRENGTH_UOM,PRES_QTY_VALUE,PRES_QTY_UOM,ALLERGY_OVERRIDE_REASON,DOSAGE_LIMIT_OVERRIDE_REASON,DUPLICATE_DRUG_OVERRIDE_REASON,TOT_INFUSION_OVER, TOT_INFUSION_OVER_UNIT,ADMIN_RATE_DETAIL,CHNGD_FLUID_REMARKS,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,BUILD_MAR_YN,MFR_YN,CALC_DOSE_BASED_ON,CALC_DOSE_VALUE,CALC_DOSE_BY,MFR_REMARKS,ORIG_INFUSE_OVER,ORIG_INFUSION_RATE,DRUG_INDICATION,PRES_INFUSION_RATE,PRES_INFUSION_QTY_UNIT, MAR_BARCODE_ID,ALLOW_ALTERNATE_YN,ALLERGY_OVERRIDE_REASON_CODE,DOSE_LIMIT_OVER_REASON_CODE,DUP_DRUG_OVERRIDE_REASON_CODE,ABUSE_EXISTS,ABUSE_DRUG_OVERRIDE_REASON) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938] & SKR-SCF-0543 [IN:033153] Added Column PRES_INFUSION_RATE , PRES_INFUSION_QTY_UNIT,Modified for IN:072715 Added ALLERGY_OVERRIDE_REASON_CODE,DOSE_LIMIT_OVER_REASON_CODE,DUP_DRUG_OVERRIDE_REASON_CODE
				sqlMap.put("SQL_PH_PRESCRIPTION_INSERT4",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT4"));
				sqlMap.put("SQL_PH_PRESCRIPTION_INSERT5",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5"));
				sqlMap.put("SQL_PH_PRESCRIPTION_INSERT6",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT6"));
				sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT2",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT2"));
				sqlMap.put("SQL_PH_PRESCRIPTION_INSERT7",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7"));
				sqlMap.put("SQL_PH_IVPRESCRIPTION_UPDATE1", PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_UPDATE1"));
				sqlMap.put("SQL_PH_IVPRESCRIPTION_UPDATE2", PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_UPDATE2"));
				sqlMap.put("SQL_PH_IVPRESCRIPTION_UPDATE3", PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_UPDATE3"));
				sqlMap.put("SQL_PH_PRESCRIPTION_DELETE_FIELD_VALUES_A",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_DELETE_FIELD_VALUES_A"));
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT57",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57"));
				sqlMap.put("SQL_PH_AMEND_IVPRES_SELECT2",PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES_SELECT2"));
				sqlMap.put("SQL_PH_AMEND_IVPRES_SELECT3",PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES_SELECT3"));

				//queries added for work load ....
				sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT72",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT72") );
				sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT73",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT73") );
				sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT9",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT9") );
				sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT10",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT10") );

				sqlMap.put( "SQL_PH_PRESCRIPTION_MODIFY7",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY7") );
				sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT74",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT74") );
				sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT75",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT75") );
				sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT11",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT11") );
				sqlMap.put( "SQL_PH_PRESCRIPTION_MODIFY8",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY8") );
				sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT12",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT12") );
				sqlMap.put( "SQL_PH_PRESCRIPTION_MODIFY9",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY9") );
				sqlMap.put( "SQL_PH_PRESCRIPTION_MODIFY6",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY6") );
				sqlMap.put( "SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT") );
				sqlMap.put("SQL_PH_IVPRESCRIPTION_MFR_INSERT",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_MFR_INSERT"));// OR_ORDER_LINE_PH_MFR 
			//	sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT_CONSENT_DETAILS",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT_CONSENT_DETAILS") );
				sqlMap.put( "SQL_PH_GEN_MARDARCODEID",PhRepository.getPhKeyValue("SQL_PH_GEN_MARDARCODEID") );  //added for  MMS-QH-CRF-0080 [IN:038064]
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_IVPRESCRIPTION" ),IVPrescriptionHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if(((Boolean) map.get("result")).booleanValue() ) {
					map.put("message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH"));
					setTrnGroupRef((String)map.get("trn_group_ref"));
					setTokensGeneratedYN((String)map.get("tokens_generated_yn"));

				} else {
					map.put("message", map.get("msgid"));
				}
			}
			catch (Exception e) {
				map.put("message", e.getMessage());
				e.printStackTrace();
			}
			map.put("flag", map.get("flag"));
		}
		else {
			map.put("result", new Boolean(false));
			map.put("message", result);
			map.put("flag", "INSUFFICIENT_STOCK");
		}
		return map;
	}

	public String validateStock(HashMap orderDetails,HashMap fluidDetails,ArrayList drugList) {

		String fluid_ord_qty	= "";
		String message			= "";
		String avl_qty			= "0";
		HashMap stock_dtls	=	new HashMap();
		CallableStatement cstmt_insert	= null; 
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet				= null;
		drug_stock_dtls	= new ArrayList();
		try {
			connection = getConnection() ;
			// Stock Check Against Fluid Starts
			String freq_nature		= (String)orderDetails.get("FREQ_NATURE");
			String end_date			= (String)orderDetails.get("END_DATE");
			String location_type	= (String)orderDetails.get("SOURCE_TYPE");
			String location_code	= (String)orderDetails.get("SOURCE_CODE");
			String priority			= (String)orderDetails.get("PRIORITY");
			String iv_pb			= "N";

			if(orderDetails.get("IV_PB")!=null){
				iv_pb = (String)orderDetails.get("IV_PB");
			}
			float duration			= 0.0f;
			int rep_interval			=	1;
			int int_value				=	1;
			if(orderDetails.get("REP_INTERVAL")!=null && !((String)orderDetails.get("REP_INTERVAL")).equals("")) {
				rep_interval			=	Integer.parseInt((String)orderDetails.get("REP_INTERVAL"));
			}
		
			if(orderDetails.get("INT_VALUE")!=null && !((String)orderDetails.get("INT_VALUE")).equals("")) {
				int_value			=	Integer.parseInt((String)orderDetails.get("INT_VALUE"));
			}
			duration 		= Float.parseFloat((String)orderDetails.get("DURN_VALUE"));
			if(iv_pb.equals("Y")) {
				duration		=	(duration/24);	// multi frq crf changes need to be done
			}

			float fld_unit_qty = Float.parseFloat(orderDetails.get("FLUID_UNIT_QTY").toString());
			//int pack_size			= Integer.parseInt((String)orderDetails.get("PACK_SIZE"));
			float pack_size			= Float.parseFloat((String)orderDetails.get("PACK_SIZE")); //changed Integer to float for Incident no:33048

			if (freq_nature.equals("I")) {			
				if(license!=null && !license.equals("PHBASIC")) {
					fluid_ord_qty = ((fld_unit_qty*duration*(24/int_value))/pack_size)+"";
				} 
				else {
					fluid_ord_qty = ((fld_unit_qty*duration*(24/int_value)))+"";
				}
			}
			else if (freq_nature.equals("F") || freq_nature.equals("C")) {
				if(license!=null && !license.equals("PHBASIC")) {
					fluid_ord_qty = ((fld_unit_qty*rep_interval*duration)/pack_size)+"";
				} 
				else {
					fluid_ord_qty = ((fld_unit_qty*rep_interval*duration))+"";
				}
			} 
			else if (freq_nature.equals("O")) {
				if(license!=null && !license.equals("PHBASIC")) {
					fluid_ord_qty = ((fld_unit_qty)/pack_size)+"";
				}
				else {
					fluid_ord_qty = (fld_unit_qty)+"";
				}
			}

			if(((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){
				float dur1		= 0.0f;
				if(((String)orderDetails.get("MFR_YN")).equals("Y")){
					dur1	=	Float.parseFloat((String)orderDetails.get("totFlowDurnHrs")==null?"0":(String)orderDetails.get("totFlowDurnHrs"));
				}
				else{
					dur1		= ((duration / (Float.parseFloat((String)orderDetails.get("INFUSE_OVER"))))*100)/100 ;
				}
				fluid_ord_qty	= (Math.ceil((Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY"))*dur1) / Float.parseFloat((String)fluidDetails.get("FLUID_PACK_SIZE"))))+"";
			}
			// Derive the store code
			String perf_locn_code	=	"";

			if(license!=null && !license.equals("PHBASIC")) {
				cstmt_insert = connection.prepareCall("{call PH_RET_DISPLOCNIV(?,?,?,?,?,?,?)}");
				cstmt_insert.setString(1, login_facility_id);
				cstmt_insert.setString(2, location_type);
				cstmt_insert.setString(3, location_code);
				cstmt_insert.setString(4, (String)orderDetails.get("TAKEHOME_MEDN"));
				cstmt_insert.setString(5, priority);
				cstmt_insert.registerOutParameter(6, Types.VARCHAR);
				cstmt_insert.registerOutParameter(7, Types.VARCHAR);
				cstmt_insert.execute();
				perf_locn_code	= cstmt_insert.getString(6);
			}
			else {
				perf_locn_code	= location_code;
			}
			// Quantity is validated against parameter facility flags
			ArrayList stock_params	=	validateForStock(patient_class);
			if(stock_params.size()!=0 && ((String)stock_params.get(0)).equals("Y") && ((String)stock_params.get(1)).equals("N")){
				stock_dtls	=	chkStockAvail((String)fluidDetails.get("DRUG_CODE"),perf_locn_code,fluid_ord_qty,end_date);

				if(stock_dtls.size()!=0) {
						avl_qty	=	(String)stock_dtls.get("AVAILABLE_STOCK");
				}

				if(Float.parseFloat(fluid_ord_qty) > Float.parseFloat(avl_qty)){
					message	=	"INSUFFICIENT_STOCK";
					drug_stock_dtls.add(((String)fluidDetails.get("SHORT_DESC")));
					drug_stock_dtls.add("F");
					drug_stock_dtls.add(avl_qty);
					drug_stock_dtls.add(fluid_ord_qty);
					if(license!=null && !license.equals("PHBASIC")) {
						drug_stock_dtls.add((String)orderDetails.get("BASE_UOM"));
					} else {
						drug_stock_dtls.add((String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
					}
					
				}
			}
			// Stock Check Against Fluid Ends
			// Stock Check Against Ingredients Starts
			HashMap drugDetails					=	null;
			float  ing_unit_qty					=	0.0f;
			String ing_order_uom				=	"";
			String qty_unit						=	"";
			String equl_value					=	"";
			String strength_per_value_pres_uom	=	"";
			String strength_per_pres_uom		=	"";
			String content_in_pres_base_uom		=	"";
			String dosage_type					=	"";

			float ing_order_qty = 0.0f;
			float in_tot_qty	= 0.0f;

			if(getLicense().equals("PHBASIC"))
				content_in_pres_base_uom		=	"1";

			if(!iv_pb.equals("Y")) {
				duration		=	 ((duration / (Float.parseFloat((String)orderDetails.get("INFUSE_OVER"))))*100)/100 ;
			}

			for(int j=1;j<=drugList.size();j++) {
				drugDetails		= (HashMap)drugList.get(j-1);
				if(drugDetails.size() != 0){
					ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
					ing_order_uom	= (String)drugDetails.get("PRES_BASE_UOM");
					qty_unit		= (String)drugDetails.get("QTY_DESC_CODE");
					dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");

					strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
					strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
					content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
					if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
						content_in_pres_base_uom =	"1";

					if (dosage_type.equals("S")) {
							ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));

							in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
		// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
						if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
							if (freq_nature.equals("I")) {
								ing_order_qty = in_tot_qty*(24/int_value)*duration;
							}
							else if (freq_nature.equals("F") || freq_nature.equals("C")) {
								ing_order_qty = in_tot_qty*rep_interval*duration;
							}
							else if (freq_nature.equals("O")) {
								ing_order_qty = in_tot_qty;
							}
						}	// Ends (not for IVD)
						if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
							ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
						} 
						else {
							ing_order_qty	=   new Double(Math.ceil((in_tot_qty*duration)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
						}
					}	
					else  {							
						equl_value	= "1";
						pstmt_select 		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53"));
						pstmt_select.setString(1, ing_order_uom);
						pstmt_select.setString(2, qty_unit);
						pstmt_select.setString(3, ing_order_uom);
						pstmt_select.setString(4, qty_unit);
						resultSet	= pstmt_select.executeQuery();

						if (resultSet.next()) {
							equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
						}

						in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
		// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
						if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
							if (freq_nature.equals("I")) {
								ing_order_qty = in_tot_qty*duration*(24/int_value);
							}
							else if (freq_nature.equals("F") || freq_nature.equals("C")) {
								ing_order_qty = in_tot_qty*rep_interval*duration;
							}
							else if (freq_nature.equals("O")) {
								ing_order_qty = in_tot_qty;
							}
						}	// Ends (Not for IVD)
						if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
							ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
						} 
						else {
							ing_order_qty	=   new Double(Math.ceil((in_tot_qty*duration)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
						}
					}
					if(stock_params.size()!=0 && ((String)stock_params.get(0)).equals("Y") && ((String)stock_params.get(1)).equals("N")){
						stock_dtls	=	chkStockAvail((String)drugDetails.get("DRUG_CODE"),perf_locn_code,ing_order_qty+"",end_date);

						if(stock_dtls.size()!=0) {
							avl_qty	=	(String)stock_dtls.get("AVAILABLE_STOCK");
						}
						if(ing_order_qty > Float.parseFloat(avl_qty)){
							message	=	"INSUFFICIENT_STOCK";								
							drug_stock_dtls.add(((String)drugDetails.get("SHORT_DESC")));
							drug_stock_dtls.add("I");
							drug_stock_dtls.add(avl_qty);
							drug_stock_dtls.add(ing_order_qty+"");
							drug_stock_dtls.add(getStockUOM((String)drugDetails.get("DRUG_CODE")));
						}
					}
				}	
			}
		// Stock Check Against Ingredient Ends
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeStatement( cstmt_insert ) ;
				closeResultSet( resultSet );
				closeStatement(pstmt_select);
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return message;
	}

	public String validateCompStock(String patient_class, String perf_locn_code,ArrayList drugDetail) {
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet				= null;

		HashMap stock_dtls		= new HashMap();
		HashMap record			= null;
			drug_stock_dtls		= new ArrayList();
		String message			= "";
		String avl_qty			= "0";
		int order_qty			= 0;

		try {
			connection = getConnection() ;
			// Quantity is validated against parameter facility flags
			ArrayList stock_params	=	validateForStock(patient_class);
			if(stock_params.size()!=0 && ((String)stock_params.get(0)).equals("Y") && ((String)stock_params.get(1)).equals("N")){
				for(int i=0; i<drugDetail.size(); i++ ) {
					record		=	(HashMap)drugDetail.get(i);	
					order_qty	=	Integer.parseInt((String)record.get("ABSOL_QTY"));
					stock_dtls	=	chkStockAvail((String)record.get("DRUG_CODE"),perf_locn_code,order_qty+"",(String)record.get("END_DATE"));
					if(stock_dtls.size()!=0) {
						avl_qty	=	(String)stock_dtls.get("AVAILABLE_STOCK");
					}
					if( order_qty > Float.parseFloat(avl_qty)){
						message	=	"INSUFFICIENT_STOCK";
						drug_stock_dtls.add(((String)record.get("SHORT_DESC")));
						drug_stock_dtls.add("D");
						drug_stock_dtls.add(avl_qty);
						drug_stock_dtls.add(order_qty+"");
						drug_stock_dtls.add(getStockUOM((String)record.get("DRUG_CODE")));				
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet );
				closeStatement(pstmt_select);
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return message;
	}

	public String validateFluidStock(HashMap tabData,ArrayList fluidDetails) {
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet				= null;
		HashMap stock_dtls		= new HashMap();
		HashMap record			= null;
			drug_stock_dtls		= new ArrayList();
		String message			= "";
		String avl_qty			= "0";
		float tot_order_qty		= 0;	
		ArrayList unique_drugs	= new ArrayList();

		try {
			connection = getConnection() ;
			String patient_class	=	(String) tabData.get("patient_class");
			//String perf_locn_code	=	(String) tabData.get("perf_locn_code"); // Commented and added for Bru-HIMS-CRF-347 [IN:037862]
			String perf_locn_code	=""; 
			// Quantity is validated against parameter facility flags
			ArrayList stock_params	=	validateForStock(patient_class);
			if(stock_params.size()!=0 && ((String)stock_params.get(0)).equals("Y") && ((String)stock_params.get(1)).equals("N")){
				for(int i=0; i<AllFluids.size(); i++ ) {
					record		=	(HashMap)AllFluids.get(i);	
					// order qty calculation
					int duration	= Integer.parseInt((String)record.get("DURN_VALUE"));
					float dur1		= ((duration / (Float.parseFloat((String)record.get("INFUSE_OVER"))))*100)/100 ;
					float order_qty	= Float.parseFloat(Math.ceil((Float.parseFloat((String)record.get("QTY_VALUE"))*dur1) / Float.parseFloat((String)record.get("FLUID_PACK_SIZE")))+"");
					
					if(unique_drugs.contains((String)record.get("DRUG_CODE"))) {
						tot_order_qty	+=	order_qty;
					} 
					else {
						unique_drugs.add((String)record.get("DRUG_CODE"));
						tot_order_qty	=	order_qty;
						perf_locn_code=record.get("DISP_LOCN_CODE").toString(); // added for Bru-HIMS-CRF-347 [IN:037862] - to get the values at drug level
						stock_dtls	=	chkStockAvail((String)record.get("DRUG_CODE"),perf_locn_code,order_qty+"",(String)record.get("END_DATE"));
						if(stock_dtls.size()!=0) {
							avl_qty	=	(String)stock_dtls.get("AVAILABLE_STOCK");
						}
					}

					if( tot_order_qty > Float.parseFloat(avl_qty)){
						message	=	"INSUFFICIENT_STOCK";
						if(!drug_stock_dtls.contains(((String)record.get("SHORT_DESC")))) {
							drug_stock_dtls.add(((String)record.get("SHORT_DESC")));
							drug_stock_dtls.add("F");
							drug_stock_dtls.add(avl_qty);
							drug_stock_dtls.add(tot_order_qty+"");
							drug_stock_dtls.add(getStockUOM((String)record.get("DRUG_CODE")));				
						} 
						else {
							int index	=	drug_stock_dtls.indexOf(((String)record.get("SHORT_DESC")));
							drug_stock_dtls.set(index+3,tot_order_qty+"");
						}
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet );
				closeStatement(pstmt_select);
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return message;
	}

	 public ArrayList validateForStock(String patient_class){
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		ArrayList stock_params		= new ArrayList();
		String consider_stock		= null;
		String allow_without_stock  = null;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT15") );
			pstmt.setString(1,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
				if(patient_class.equals("IP")) {
					consider_stock		=		resultSet.getString("IP_CONSIDER_STOCK_PRES_YN");
					allow_without_stock  =		resultSet.getString("IP_PRES_WITHOUT_STOCK_YN");
				} else {
					consider_stock		=	resultSet.getString("CONSIDER_STOCK_FOR_PRES_YN");
					allow_without_stock  = resultSet.getString("ALLOW_PRES_WITHOUT_STOCK_YN");
				}
				stock_params.add(consider_stock);
				stock_params.add(allow_without_stock);
			}
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}
		}
		return stock_params;
	}

	//check the stock availability
  public HashMap chkStockAvail(String item_code,String disp_code,String total_qty,String end_date){
		Connection connection       = null ;
        CallableStatement cstmt     = null ;
        ResultSet resultSet         = null ;

		HashMap stockValues			= new HashMap();
		
		try{
			connection = getConnection() ;
			cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, item_code);
			cstmt.setString( 2, disp_code);
			cstmt.setString( 3, total_qty);
			cstmt.setString( 4, "Y");
			cstmt.setString( 5, end_date);
			cstmt.setString( 6, "N");
			cstmt.setString( 7, "");
			cstmt.registerOutParameter(8, Types.VARCHAR );
			cstmt.registerOutParameter(9, Types.VARCHAR );
			cstmt.registerOutParameter(10, Types.VARCHAR );
			cstmt.registerOutParameter(11, Types.INTEGER );
			cstmt.registerOutParameter(12, Types.VARCHAR );
			cstmt.registerOutParameter(13, Types.VARCHAR );
			cstmt.registerOutParameter(14, Types.VARCHAR );
			cstmt.registerOutParameter(15, Types.VARCHAR );
			cstmt.registerOutParameter(16, Types.VARCHAR );
			cstmt.registerOutParameter(17, Types.VARCHAR );
			cstmt.registerOutParameter(18, Types.VARCHAR );
			cstmt.registerOutParameter(19, Types.VARCHAR );
			cstmt.execute() ;
			stockValues.put("STOCK_AVAILABLE_YN",(String)(cstmt.getString(8)==null ? "Y":cstmt.getString(8)));
			stockValues.put("AVAILABLE_STOCK",(String.valueOf(cstmt.getInt(11))));
		}
		catch ( Exception e ) {
				stockValues.put("STOCK_AVAILABLE_YN","N");
				stockValues.put("AVAILABLE_STOCK","0");
		} finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}catch(Exception es){}
        }
		return stockValues;
	}
//end of stock

// load frequency values of compound prescription
	 public ArrayList loadFrequency(){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		ArrayList freq_vals		= new ArrayList();

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMP_PRESCRIPTION_SELECT1") );
			pstmt = connection.prepareStatement( "SELECT DISTINCT A.FREQ_CODE,A.FREQ_DESC FROM AM_FREQUENCY_LANG_VW A, OR_FREQUENCY_SCOPE B WHERE A.EFF_STATUS='E' AND (A.FREQ_NATURE<>'C' AND A.FREQ_NATURE<>'I' and A.FREQ_NATURE<>'P' and A.FREQ_NATURE<>'O') AND A.FREQ_CODE = B.FREQ_CODE AND B.ORDER_CATEGORY = 'PH' AND B.FREQ_SCOPE_YN = 'Y' AND A.SCHEDULED_YN='Y' AND A.LANGUAGE_ID = ? ORDER BY 2" );
			pstmt.setString(1, getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
					freq_vals.add(checkForNull(resultSet.getString("FREQ_CODE")));
					freq_vals.add(checkForNull(resultSet.getString("FREQ_DESC")));
			}
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}
		}
		return freq_vals;
	}

// check parameter values for duplicate medication
	 public String checkDuplicateYN(){
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String allow_duplicate	= null;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT14A") );
			pstmt.setString(1,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
					allow_duplicate		=		resultSet.getString("ALLOW_DUPLICATE_DRUG");
			}
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}
		}
		return allow_duplicate;
	}

	public ArrayList getDuplicateDrugs(String patient_id,String generic_id)	{

		Connection connection		=  null;
		PreparedStatement pstmt		=  null;
		ResultSet resultSet			=  null;
		String sql_str				=	"";
		String start_date			=	"";
		String end_date				=	"";
		String drug_desc			=	"";
		String strength				=	"";
		String strength_uom_desc	=	"";
		String form_desc			=	"";
		String practitioner_name	=	"";
		String facility_name		=	"";
		String diag_text			=	"";
		String location				=	"";
		String split_dose_prev		=	"";
		String order_id				=	"";
		String order_line_no		=	"";
		String freq_code			=	"";
		String freq_desc			=	"";
		String allergy_reason		=	"";
		String dosage_reason		=	"";
		String duplicate_reason		=	"";

		ArrayList dupDrugs		= new ArrayList();
		HashMap	record			= null;

		try{
		connection			= getConnection() ;

		sql_str				=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT59");
		pstmt				= connection.prepareStatement(sql_str) ;
		pstmt.setString(1,patient_id);
		pstmt.setString(2,generic_id);
		pstmt.setString(3, getLanguageId());
		pstmt.setString(4, getLanguageId());
		pstmt.setString(5, getLanguageId());

		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
				record	=	new HashMap();
				start_date			=	resultSet.getString("START_DATE");
				end_date			=	resultSet.getString("END_DATE");
				drug_desc			=	resultSet.getString("DRUG_DESC");
				split_dose_prev		=	resultSet.getString("SPLIT_DOSE_PREVIEW");
				strength			=	resultSet.getString("STRENGTH");
				strength_uom_desc	=	resultSet.getString("STRENGTH_UOM");
				form_desc			=	resultSet.getString("FORM_CODE");
				practitioner_name	=	resultSet.getString("PRACTITIONER_NAME");
				facility_name		=	resultSet.getString("FACILITY_NAME");
				diag_text			=	resultSet.getString("DIAG_TEXT");
				location			=	resultSet.getString("LOCATION");
				order_id			=	resultSet.getString("ORIG_ORDER_ID");
				order_line_no		=	resultSet.getString("ORIG_ORDER_LINE_NO");
				freq_code			=	resultSet.getString("FREQ_CODE");
				freq_desc			=	resultSet.getString("FREQ_DESC");
				allergy_reason		=	resultSet.getString("ALLERGY_OVERRIDE_REASON");
				dosage_reason		=	resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON");
				duplicate_reason	=	resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON");

				if(!getLanguageId().equals("en")){
					record.put("start_date",com.ehis.util.DateUtils.convertDate(start_date,"DMYHM","en",getLanguageId()));					 
					record.put("end_date",com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",getLanguageId()));
				}
				else{	   
					record.put("start_date",start_date);
					record.put("end_date",end_date);
				}

				record.put("drug_desc",drug_desc);
				record.put("strength",strength);
				record.put("strength_uom_desc",strength_uom_desc);
				record.put("form_desc",form_desc);
				record.put("practitioner_name",practitioner_name);
				record.put("location",location);
				record.put("facility_name",facility_name);
				record.put("diag_text",diag_text);
				record.put("split_dose_prev",split_dose_prev);
				record.put("order_id",order_id);
				record.put("order_line_no",order_line_no);
				record.put("freq_code",freq_code);
				record.put("freq_desc",freq_desc);
				record.put("allergy_reason",allergy_reason);
				record.put("dosage_reason",dosage_reason);
				record.put("duplicate_reason",duplicate_reason);

				dupDrugs.add(record);
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return dupDrugs;
	}

	public ArrayList getExistingIVRecords(String order_id, String answer,String act_pat_class){

		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		PreparedStatement pstmt1	= null ;
		CallableStatement cstmt		= null ;
		ResultSet resultSet			= null ;
		ResultSet resultSet1		= null ;
		
		String sql_str				= "";

		String ORDER_CATALOG_CODE	= "";
		String CATALOG_DESC			= "";
		String START_DATE_TIME		= "";
		String END_DATE_TIME		= "";
		String DURN_VALUE			= "";
		String DURN_TYPE			= "";
		String QTY_VALUE			= "";
		String QTY_UNIT				= "";
		String ORDER_UOM			= "";
		String INFUSE_OVER			= "";
		String INFUSION_RATE		= "";
		String ORDER_LINE_NUM		= "";
		String FREQ_CODE			= "";
		String INFUSION_PER_UNIT	="";
		String INF_PERIOD_UNIT		="";
		String CHNGD_FLUID_REMARKS	="";
		String ORD_AUTH_REQD_YN		= "";
		String ORD_APPR_REQD_YN		="";
		String ORD_COSIGN_REQD_YN	="";
		String BUILDMAR_YN			="";
		String calc_dflt_dosage_by_htwt	="";
		String dosage_type			="";
		String strength_value		="";
		String freq_nature			="";
		String freq_value			="";
		String interval_value		="";
		String repeat_value			="";
		String schedule_yn			="";
		String repeat_durn_type		="";
		String drug_class			="";
		String mfr_yn				="";
		String calc_dose_by			=""; 
		String calc_dose_based_on	=""; 
		String calc_dose_value		=""; 
		String mfr_remarks			=""; 
		String pres_base_uom = "";
		String strength_per_value_pres_uom = "";
		String source_code="", priority="", form_code="", take_home_medication="";  // CRF-0062
		String perf_locn_code=""; //added for Bru-HIMS-CRF-347 [IN:037862]
		String drug_indication = "";

		ArrayList existingIVRecrds	= new ArrayList();
		HashMap record				= null;

		try{
			connection = getConnection();

//			sql_str			=	PhRepository.getPhKeyValue("SQL_PH_RENEW_IVPRES_SELECT1");
		//	sql_str			=	"SELECT A.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,A.CATALOG_DESC  CATALOG_DESC,A.FREQ_CODE FREQ_CODE, TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:mi')START_DATE_TIME,TO_CHAR(A.END_DATE_TIME,'DD/MM/YYYY hh24:mi') END_DATE_TIME,A.DURN_VALUE DURN_VALUE,A.DURN_TYPE DURN_TYPE,A.QTY_VALUE QTY_VALUE,A.QTY_UNIT QTY_UNIT,A.ORDER_UOM,B.INFUSE_OVER INFUSE_OVER,B.INFUSION_RATE INFUSION_RATE,B.ORDER_LINE_NUM ORDER_LINE_NUM, B.INFUSION_PER_UNIT INFUSION_PER_UNIT,B.CHNGD_FLUID_REMARKS CHNGD_FLUID_REMARKS,A.ORD_AUTH_REQD_YN, A.ORD_APPR_REQD_YN,A.ORD_COSIGN_REQD_YN, B.BUILD_MAR_YN, d.CALC_DEF_DOSAGE_YN, d.STRENGTH_VALUE, b.DOSAGE_TYPE FROM OR_ORDER_LINE A,OR_ORDER_LINE_PH B, OR_ORDER C, ph_drug d, ph_patient_drug_profile e WHERE A.ORDER_ID=C.ORDER_ID AND A.ORDER_ID=B.ORDER_ID AND A.ORDER_LINE_NUM=B.ORDER_LINE_NUM AND e.order_id =B.ORDER_ID and  AND d.drug_code = a.order_catalog_code AND A.ORDER_ID=? ORDER BY A.ORDER_LINE_NUM";
		//	sql_str			="SELECT   A.ORDER_CATALOG_CODE ORDER_CATALOG_CODE, A.CATALOG_DESC CATALOG_DESC, A.FREQ_CODE FREQ_CODE,          TO_CHAR (A.START_DATE_TIME, 'DD/MM/YYYY HH24:MI') START_DATE_TIME,TO_CHAR (A.END_DATE_TIME, 'DD/MM/YYYY HH24:MI') END_DATE_TIME,A.DURN_VALUE DURN_VALUE, A.DURN_TYPE DURN_TYPE,A.QTY_VALUE QTY_VALUE, A.QTY_UNIT QTY_UNIT, A.ORDER_UOM, B.ORIG_INFUSE_OVER INFUSE_OVER, B.ORIG_INFUSION_RATE INFUSION_RATE,B.ORDER_LINE_NUM ORDER_LINE_NUM,B.INFUSION_PER_UNIT INFUSION_PER_UNIT, B.CHNGD_FLUID_REMARKS CHNGD_FLUID_REMARKS, A.ORD_AUTH_REQD_YN,A.ORD_APPR_REQD_YN, A.ORD_COSIGN_REQD_YN, B.BUILD_MAR_YN, D.CALC_DEF_DOSAGE_YN, D.STRENGTH_VALUE, B.DOSAGE_TYPE,E.INFUSION_PER_UNIT INF_PERIOD_UNIT, E.DOSAGE_UOM_CODE, D.DRUG_CLASS, B.MFR_YN,B.CALC_DOSE_BY, B.CALC_DOSE_BASED_ON, B.CALC_DOSE_VALUE,B.MFR_REMARKS, D.PRES_BASE_UOM,D.STRENGTH_PER_VALUE_PRES_UOM FROM OR_ORDER_LINE A, OR_ORDER_LINE_PH B,OR_ORDER C,  PH_DRUG D, PH_PATIENT_DRUG_PROFILE E    WHERE A.ORDER_ID = C.ORDER_ID AND A.ORDER_ID = B.ORDER_ID      AND A.ORDER_LINE_NUM = B.ORDER_LINE_NUM  AND E.ORIG_ORDER_ID = B.ORDER_ID  AND E.ORIG_ORDER_LINE_NO = B.ORDER_LINE_NUM      AND D.DRUG_CODE = A.ORDER_CATALOG_CODE   AND A.ORDER_ID = ? ORDER BY A.ORDER_LINE_NUM"; ////added D.PRES_BASE_UOM and D.STRENGTH_PER_VALUE_PRES_UOM for IN23747 --13/09/2010-- priya
		// RUT-CRF-0062 [IN029600] Added C.PATIENT_CLASS,C.SOURCE_CODE,C.PRIORITY,A.FORM_CODE,C.DISCHARGE_IND to get Build MAR Rule -- Begin
		//sql_str = "SELECT   A.ORDER_CATALOG_CODE ORDER_CATALOG_CODE, D.DRUG_DESC CATALOG_DESC, A.FREQ_CODE FREQ_CODE,TO_CHAR (A.START_DATE_TIME, 'DD/MM/YYYY HH24:MI') START_DATE_TIME,TO_CHAR (A.END_DATE_TIME, 'DD/MM/YYYY HH24:MI') END_DATE_TIME,A.DURN_VALUE DURN_VALUE, A.DURN_TYPE DURN_TYPE,A.QTY_VALUE QTY_VALUE, A.QTY_UNIT QTY_UNIT, A.ORDER_UOM, B.ORIG_INFUSE_OVER INFUSE_OVER, B.ORIG_INFUSION_RATE INFUSION_RATE,B.ORDER_LINE_NUM ORDER_LINE_NUM,   B.INFUSION_PER_UNIT INFUSION_PER_UNIT, B.CHNGD_FLUID_REMARKS CHNGD_FLUID_REMARKS,  A.ORD_AUTH_REQD_YN,A.ORD_APPR_REQD_YN, A.ORD_COSIGN_REQD_YN, B.BUILD_MAR_YN, D.CALC_DEF_DOSAGE_YN, 		   D.STRENGTH_VALUE, B.DOSAGE_TYPE,E.INFUSION_PER_UNIT INF_PERIOD_UNIT, E.DOSAGE_UOM_CODE, D.DRUG_CLASS,    B.MFR_YN,B.CALC_DOSE_BY, B.CALC_DOSE_BASED_ON, B.CALC_DOSE_VALUE,B.MFR_REMARKS, D.PRES_BASE_UOM,D.STRENGTH_PER_VALUE_PRES_UOM FROM OR_ORDER_LINE A, OR_ORDER_LINE_PH B,OR_ORDER C,   ph_drug_lang_vw D, 		   PH_PATIENT_DRUG_PROFILE E    WHERE A.ORDER_ID = C.ORDER_ID AND A.ORDER_ID = B.ORDER_ID AND A.ORDER_LINE_NUM = B.ORDER_LINE_NUM  AND E.ORIG_ORDER_ID = B.ORDER_ID  AND E.ORIG_ORDER_LINE_NO = B.ORDER_LINE_NUM      AND D.DRUG_CODE = A.ORDER_CATALOG_CODE  AND A.ORDER_ID = ? and d.language_id =? ORDER BY A.ORDER_LINE_NUM"; //query modified for IN25940 --19/01/2011-- priya (replaced ph_drug with ph_drug_lang_vw and taken drug_desc from ph_drug_lang_vw)
			//STRENGTH_UOM ADDED FOR NMC-JD-CRF-0026
		  //sql_str = "SELECT   A.ORDER_CATALOG_CODE ORDER_CATALOG_CODE, D.DRUG_DESC CATALOG_DESC, A.FREQ_CODE FREQ_CODE,TO_CHAR (A.START_DATE_TIME, 'DD/MM/YYYY HH24:MI') START_DATE_TIME,TO_CHAR (A.END_DATE_TIME, 'DD/MM/YYYY HH24:MI') END_DATE_TIME,A.DURN_VALUE DURN_VALUE, A.DURN_TYPE DURN_TYPE,A.QTY_VALUE QTY_VALUE, A.QTY_UNIT QTY_UNIT, A.ORDER_UOM, B.ORIG_INFUSE_OVER INFUSE_OVER, B.ORIG_INFUSION_RATE INFUSION_RATE,B.ORDER_LINE_NUM ORDER_LINE_NUM,   B.INFUSION_PER_UNIT INFUSION_PER_UNIT, B.CHNGD_FLUID_REMARKS CHNGD_FLUID_REMARKS,  A.ORD_AUTH_REQD_YN,A.ORD_APPR_REQD_YN, A.ORD_COSIGN_REQD_YN, B.BUILD_MAR_YN, D.CALC_DEF_DOSAGE_YN,  D.STRENGTH_VALUE, B.DOSAGE_TYPE,E.INFUSION_PER_UNIT INF_PERIOD_UNIT, E.DOSAGE_UOM_CODE, D.DRUG_CLASS, B.MFR_YN,B.CALC_DOSE_BY, B.CALC_DOSE_BASED_ON, B.CALC_DOSE_VALUE,B.MFR_REMARKS, D.PRES_BASE_UOM,D.STRENGTH_PER_VALUE_PRES_UOM,C.SOURCE_CODE,C.PRIORITY,A.FORM_CODE,C.DISCHARGE_IND TAKE_HOME,B.DRUG_INDICATION,C.PERFORMING_DEPTLOC_CODE,  DL.SHORT_DESC  DISP_LOCN_DESC,C.PERFORMING_FACILITY_ID, ALLOW_ALTERNATE_YN,D.STRENGTH_UOM   FROM OR_ORDER_LINE A, OR_ORDER_LINE_PH B,OR_ORDER C, ph_drug_lang_vw D, PH_PATIENT_DRUG_PROFILE E, PH_DISP_LOCN DL WHERE A.ORDER_ID = C.ORDER_ID AND A.ORDER_ID = B.ORDER_ID AND A.ORDER_LINE_NUM = B.ORDER_LINE_NUM  AND E.ORIG_ORDER_ID = B.ORDER_ID  AND E.ORIG_ORDER_LINE_NO = B.ORDER_LINE_NUM AND C.PERFORMING_DEPTLOC_CODE = DL.DISP_LOCN_CODE AND C.PERFORMING_FACILITY_ID = DL.FACILITY_ID AND  D.DRUG_CODE = A.ORDER_CATALOG_CODE  AND A.ORDER_ID = ? and d.language_id =? ORDER BY A.ORDER_LINE_NUM"; //query modified for IN25940 --19/01/2011-- priya (replaced ph_drug with ph_drug_lang_vw and taken drug_desc from ph_drug_lang_vw) //Code Added For SKR-CRF-PHIS-003[IN028182] & B.DRUG_INDICATION is  Added for  ML-BRU-CRF-072[Inc:29938]  C.PERFORMING_DEPTLOC_CODE Added for Bru-HIMS-CRF-347 [IN:037862],C.PERFORMING_FACILITY_ID Added for MMS Internal Testing
//ALLOW_ALTERNATE_YN added for GHL-CRF-0549
			sql_str = "SELECT   A.ORDER_CATALOG_CODE ORDER_CATALOG_CODE, D.DRUG_DESC CATALOG_DESC, A.FREQ_CODE FREQ_CODE,TO_CHAR (A.START_DATE_TIME, 'DD/MM/YYYY HH24:MI') START_DATE_TIME,TO_CHAR (A.END_DATE_TIME, 'DD/MM/YYYY HH24:MI') END_DATE_TIME,A.DURN_VALUE DURN_VALUE, A.DURN_TYPE DURN_TYPE,A.QTY_VALUE QTY_VALUE, A.QTY_UNIT QTY_UNIT, A.ORDER_UOM, B.ORIG_INFUSE_OVER INFUSE_OVER, B.ORIG_INFUSION_RATE INFUSION_RATE,B.ORDER_LINE_NUM ORDER_LINE_NUM,   B.INFUSION_PER_UNIT INFUSION_PER_UNIT, B.CHNGD_FLUID_REMARKS CHNGD_FLUID_REMARKS,  A.ORD_AUTH_REQD_YN,A.ORD_APPR_REQD_YN, A.ORD_COSIGN_REQD_YN, B.BUILD_MAR_YN, D.CALC_DEF_DOSAGE_YN,  D.STRENGTH_VALUE, B.DOSAGE_TYPE,E.INFUSION_PER_UNIT INF_PERIOD_UNIT, E.DOSAGE_UOM_CODE, D.DRUG_CLASS, B.MFR_YN,B.CALC_DOSE_BY, B.CALC_DOSE_BASED_ON, B.CALC_DOSE_VALUE,B.MFR_REMARKS, D.PRES_BASE_UOM,D.STRENGTH_PER_VALUE_PRES_UOM,C.SOURCE_CODE,C.PRIORITY,A.FORM_CODE,C.DISCHARGE_IND TAKE_HOME,B.DRUG_INDICATION,C.PERFORMING_DEPTLOC_CODE,  DL.SHORT_DESC  DISP_LOCN_DESC,C.PERFORMING_FACILITY_ID, ALLOW_ALTERNATE_YN,D.STRENGTH_UOM,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ? AND pr_diag.curr_status != 'E' AND pr_diag.curr_encounter_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = d.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN   FROM OR_ORDER_LINE A, OR_ORDER_LINE_PH B,OR_ORDER C, ph_drug_lang_vw D, PH_PATIENT_DRUG_PROFILE E, PH_DISP_LOCN DL WHERE A.ORDER_ID = C.ORDER_ID AND A.ORDER_ID = B.ORDER_ID AND A.ORDER_LINE_NUM = B.ORDER_LINE_NUM  AND E.ORIG_ORDER_ID = B.ORDER_ID  AND E.ORIG_ORDER_LINE_NO = B.ORDER_LINE_NUM AND C.PERFORMING_DEPTLOC_CODE = DL.DISP_LOCN_CODE AND C.PERFORMING_FACILITY_ID = DL.FACILITY_ID AND  D.DRUG_CODE = A.ORDER_CATALOG_CODE  AND A.ORDER_ID = ? and d.language_id =? ORDER BY A.ORDER_LINE_NUM";//NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = PH_DRUG_VW.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN"; //query modified for IN25940 --19/01/2011-- priya (replaced ph_drug with ph_drug_lang_vw and taken drug_desc from ph_drug_lang_vw) //Code Added For SKR-CRF-PHIS-003[IN028182] & B.DRUG_INDICATION is  Added for  ML-BRU-CRF-072[Inc:29938]  C.PERFORMING_DEPTLOC_CODE Added for Bru-HIMS-CRF-347 [IN:037862],C.PERFORMING_FACILITY_ID Added for MMS Internal Testing

			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,getEncId());
			System.out.println("8694 getEncId()"+getEncId());
			pstmt.setString(3,order_id);
			pstmt.setString(4,getLanguageId());

			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				record = new HashMap();
				
                ORDER_CATALOG_CODE	= checkForNull(resultSet.getString("ORDER_CATALOG_CODE"));
				CATALOG_DESC		= checkForNull(resultSet.getString("CATALOG_DESC"));
				START_DATE_TIME		= checkForNull(resultSet.getString("START_DATE_TIME"));
				END_DATE_TIME		= checkForNull(resultSet.getString("END_DATE_TIME"));
				DURN_VALUE			= checkForNull(resultSet.getString("DURN_VALUE"));
				DURN_TYPE			= checkForNull(resultSet.getString("DURN_TYPE"));
				QTY_VALUE			= checkForNull(resultSet.getString("QTY_VALUE"));
				QTY_UNIT			= checkForNull(resultSet.getString("QTY_UNIT"));
				ORDER_UOM			= checkForNull(resultSet.getString("ORDER_UOM"));
				INFUSE_OVER			= checkForNull(resultSet.getString("INFUSE_OVER"));
				INFUSION_RATE		= checkForNull(resultSet.getString("INFUSION_RATE"));
				ORDER_LINE_NUM		= checkForNull(resultSet.getString("ORDER_LINE_NUM"));
				INFUSION_PER_UNIT	= checkForNull(resultSet.getString("INFUSION_PER_UNIT"));
				INF_PERIOD_UNIT		= checkForNull(resultSet.getString("INF_PERIOD_UNIT"));
				FREQ_CODE			= checkForNull(resultSet.getString("FREQ_CODE"));
				CHNGD_FLUID_REMARKS = checkForNull(resultSet.getString("CHNGD_FLUID_REMARKS"));
				ORD_AUTH_REQD_YN	= checkForNull(resultSet.getString("ORD_AUTH_REQD_YN"));
				ORD_APPR_REQD_YN	= checkForNull(resultSet.getString("ORD_APPR_REQD_YN"));
				ORD_COSIGN_REQD_YN  = checkForNull(resultSet.getString("ORD_COSIGN_REQD_YN"));
				BUILDMAR_YN			= checkForNull(resultSet.getString("BUILD_MAR_YN"));
				calc_dflt_dosage_by_htwt			= checkForNull(resultSet.getString("CALC_DEF_DOSAGE_YN"));
				dosage_type			= checkForNull(resultSet.getString("DOSAGE_TYPE"));
				strength_value		= checkForNull(resultSet.getString("STRENGTH_VALUE"));
				drug_class			= checkForNull(resultSet.getString("DRUG_CLASS"));
				mfr_yn				= checkForNull(resultSet.getString("MFR_YN"));
				calc_dose_value		= checkForNull(resultSet.getString("CALC_DOSE_VALUE"));
				calc_dose_by		= checkForNull(resultSet.getString("CALC_DOSE_BY"));
				calc_dose_based_on	= checkForNull(resultSet.getString("CALC_DOSE_BASED_ON"));
				mfr_remarks			= checkForNull(resultSet.getString("MFR_REMARKS"));
				pres_base_uom = checkForNull(resultSet.getString("PRES_BASE_UOM")); //added for IN23747 --13/09/2010-- priya
				strength_per_value_pres_uom = resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM"); //added for IN23745 --16/09/2010-- priya
				perf_locn_code = resultSet.getString("PERFORMING_DEPTLOC_CODE");  // added for Bru-HIMS-CRF-347 [IN:037862]
				if(mfr_remarks!=null && !mfr_remarks.equals(""))
					mfr_remarks=java.net.URLEncoder.encode(mfr_remarks,"UTF-8");
                setFREQ_CODE(FREQ_CODE); 
				setFluidRemarks(CHNGD_FLUID_REMARKS);
			// RUT-CRF-0062 [IN029600] --To get Build MAR Rule -- begin
				source_code = resultSet.getString("SOURCE_CODE")==null?"":resultSet.getString("SOURCE_CODE"); 
				priority 	= resultSet.getString("PRIORITY")==null?"":resultSet.getString("PRIORITY"); 
				form_code 	= resultSet.getString("FORM_CODE")==null?"":resultSet.getString("FORM_CODE"); 
				take_home_medication= resultSet.getString("TAKE_HOME")==null?"":resultSet.getString("TAKE_HOME"); 
				drug_indication= resultSet.getString("DRUG_INDICATION")==null?"":resultSet.getString("DRUG_INDICATION"); //DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]
			// RUT-CRF-0062 [IN029600] --To get Build MAR Rule -- end
				record.put("ORDER_CATALOG_CODE",ORDER_CATALOG_CODE);
				record.put("CATALOG_DESC",CATALOG_DESC);
				record.put("ALLOW_ALTERNATE_YN",resultSet.getString("ALLOW_ALTERNATE_YN")==null?"":resultSet.getString("ALLOW_ALTERNATE_YN"));//GHL-CRF-0549
				record.put("STRENGTH_UOM",resultSet.getString("STRENGTH_UOM")==null?"":resultSet.getString("STRENGTH_UOM"));//added for NMC-JD-CRF-0026
				
/*=============================================================================================================*/
//added for IN24251 --16/12/2010-- priya (to default to current date time if answer is "Y")
					if(answer == null)
						answer = "";
					if(answer.equals("Y")){
						java.util.Date end_time_as_sys_time = new java.util.Date();
						java.text.SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
						String new_end_time = dateFormat.format( (end_time_as_sys_time));
						END_DATE_TIME = comp_date_time(new_end_time,order_id,ORDER_LINE_NUM); 
					}
/*=============================================================================================================*/

				if(!getLanguageId().equals("en")){
					record.put("START_DATE_TIME",com.ehis.util.DateUtils.convertDate(START_DATE_TIME,"DMYHM","en",getLanguageId()));
					record.put("END_DATE_TIME",com.ehis.util.DateUtils.convertDate(END_DATE_TIME,"DMYHM","en",getLanguageId()));
				}
				else{	   
					record.put("START_DATE_TIME",START_DATE_TIME);
					record.put("END_DATE_TIME",END_DATE_TIME);
				}

				record.put("DURN_VALUE",DURN_VALUE);
				record.put("DURN_TYPE",DURN_TYPE);
				record.put("QTY_VALUE",QTY_VALUE);
				record.put("QTY_UNIT",QTY_UNIT);
				record.put("ORDER_UOM",ORDER_UOM);
				record.put("INFUSE_OVER",INFUSE_OVER);
				record.put("INFUSION_RATE",INFUSION_RATE);
				record.put("ORDER_LINE_NUM",ORDER_LINE_NUM);
				record.put("FREQ_CODE",FREQ_CODE);
				record.put("INFUSION_PER_UNIT",INFUSION_PER_UNIT);
				record.put("INF_PERIOD_UNIT",INF_PERIOD_UNIT);

				record.put("ORD_AUTH_REQD_YN",ORD_AUTH_REQD_YN);
				record.put("ORD_APPR_REQD_YN",ORD_APPR_REQD_YN);
				record.put("ORD_COSIGN_REQD_YN",ORD_COSIGN_REQD_YN);
				record.put("BUILD_MAR_YN",BUILDMAR_YN);
				record.put("DOSAGE_TYPE",dosage_type);
				record.put("STRENGTH_VALUE",strength_value);
				record.put("DRUG_CLASS",drug_class);
				record.put("MFR_YN",mfr_yn);
				record.put("CALC_DOSE_BASED_ON",calc_dose_based_on);
				record.put("CALC_DOSE_BY",calc_dose_by);
				record.put("CALC_DOSE_VALUE",calc_dose_value);
				record.put("MFR_REMARKS",mfr_remarks);
				record.put("PRES_BASE_UOM",pres_base_uom); //added for IN23747 --13/09/2010-- priya
				record.put("STRENGTH_PER_VALUE_PRES_UOM",strength_per_value_pres_uom); //added for IN23745 --16/09/2010-- priya
				record.put("DOSAGE_UOM_CODE", ((String)resultSet.getString("DOSAGE_UOM_CODE"))==null?"":(String)resultSet.getString("DOSAGE_UOM_CODE"));
				record.put("DRUG_INDICATION",drug_indication);//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]
				record.put("DISP_LOCN_CODE",perf_locn_code); // added for Bru-HIMS-CRF-347 [IN:037862]
				record.put("DISP_LOCN_DESC",resultSet.getString("DISP_LOCN_DESC")); // added for Bru-HIMS-CRF-347 [IN:037862]
				record.put("PER_FACILITY_ID",resultSet.getString("PERFORMING_FACILITY_ID"));//Added for MMS Internal Testing
				record.put("DIAGNOSIS_FOUND_YN",resultSet.getString("DIAGNOSIS_FOUND_YN"));
				
				/* Procedure to calculate monograph values --------*/
				HashMap pat_dtls	=	getPatientDetails(patient_id,ORDER_CATALOG_CODE);
				String	age			=	(String)pat_dtls.get("age");
				String sex			=	((String)pat_dtls.get("sex"));
				String	age_in_mints			=	(String)pat_dtls.get("age_in_mints");//added for ml-mmoh-crf-0978
				age	=	age.trim();
				//sex	=	sex.substring(0,1);
				
				pstmt1	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80A") ) ;
				pstmt1.setString(1,sex);
				pstmt1.setString(2,age_in_mints);////added for ml-mmoh-crf-0978
				pstmt1.setString(3,ORDER_CATALOG_CODE);
				resultSet1	= pstmt1.executeQuery();
				
				while(resultSet1!=null && resultSet1.next() ) {
					age_group	=	resultSet1.getString("AGE_GROUP_CODE");
				}
				try{
					closeResultSet( resultSet1 ) ;
					closeStatement( pstmt1 ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}/* MFR recs..............*/
				if(((String)record.get("MFR_YN")).equals("Y")){
					MFRYN = "Y";
					pstmt1	= connection.prepareStatement("select SL_NO, TOT_STRENGTH, TOT_STRENGTH_UOM, INFUSE_OVER, INFUSE_OVER_UNIT, INFUSION_RATE, INFUSION_VOL_STR_UNIT, INFUSION_PER_UNIT, ADMIN_RATE_DETAIL, to_char(SCH_START_DATE_TIME,'DD/MM/YYYY hh24:mi')START_DATE_TIME, to_char(SCH_END_DATE_TIME,'DD/MM/YYYY hh24:mi')END_DATE_TIME, GAP_DURATION_IN_HRS from OR_ORDER_LINE_PH_MFR where ORDER_ID=?") ;
					pstmt1.setString(1,order_id);
					resultSet1	= pstmt1.executeQuery();
					HashMap mfrRec		= new HashMap();
					ArrayList mfrRecs	= new ArrayList();
					float tot_volume	= 0.0f;
					float tot_flow_drun = 0.0f;
					float tot_durn = 0.0f;
					String ord_start_date = "";
					String ord_end_date = "";
					String inhr = "";
					String min = "";
					String hr = "";
					String tot_strength = "";
					Double Dtemp = null;
					int i1=0;
					while(resultSet1!=null && resultSet1.next() ) {
						i1 = i1+1;
						mfrRecs= new ArrayList();
				
						tot_strength = resultSet1.getString("TOT_STRENGTH");
						tot_volume		= tot_volume + Float.parseFloat(tot_strength);
						mfrRecs.add(tot_strength);//1
						mfrRecs.add(resultSet1.getString("INFUSION_RATE"));//2
						mfrRecs.add(resultSet1.getString("INFUSION_PER_UNIT"));//3

						inhr = resultSet1.getString("INFUSE_OVER");
						tot_flow_drun	= tot_flow_drun + Float.parseFloat(inhr);
						if(inhr.indexOf(".") != -1){
							hr = inhr.substring(0,inhr.indexOf("."));
							Dtemp = new Double(inhr);
							Dtemp = Dtemp*60;
							Dtemp = (Dtemp%60);

							min = Math.round(Dtemp)+""; 
							if(min.indexOf(".") != -1)
								min = min.substring(0,min.indexOf("."));  
						}
						else{
							hr = inhr;
							min = "";
						}
						hr = hr.equals("")?"0":hr;
						min = min.equals("")?"0":min;

						mfrRecs.add(hr);//4
						mfrRecs.add(min);//5
						mfrRecs.add(inhr);//6
						if(i1==1){
							ord_start_date = resultSet1.getString("START_DATE_TIME");
							mfrRecs.add(ord_start_date);
						}
						else
							mfrRecs.add(resultSet1.getString("START_DATE_TIME"));//7
						
						ord_end_date = resultSet1.getString("END_DATE_TIME");
						mfrRecs.add(ord_end_date);//8
						
						inhr = resultSet1.getString("GAP_DURATION_IN_HRS")==null?"0":resultSet1.getString("GAP_DURATION_IN_HRS");
						tot_durn		= tot_durn + Float.parseFloat(inhr);
						if(inhr.indexOf(".") != -1){
							hr = inhr.substring(0,inhr.indexOf("."));
							Dtemp = new Double(inhr);
							Dtemp = Dtemp*60;
							Dtemp = (Dtemp%60);

							min = Math.round(Dtemp)+""; 
							if(min.indexOf(".") != -1)
								min = min.substring(0,min.indexOf("."));  
						}
						else{
							hr = inhr;
							min = "";
						}
						hr = hr.equals("")?"0":hr;
						min = min.equals("")?"0":min;
						mfrRecs.add(hr);//9
						mfrRecs.add(min);//10
						mfrRecs.add(inhr);//11
						mfrRec.put("MFR"+i1,mfrRecs);
						mfrRec.put("totRec",i1+"");
					}
					tot_durn = tot_durn + tot_flow_drun;
					mfrRec.put("totInfVolume",tot_volume+"");
					mfrRec.put("totFlowDurn","");
					mfrRec.put("totDuration","");
					mfrRec.put("totFlowDurnHrs",tot_flow_drun+"");
					mfrRec.put("totDurnHrs",tot_durn+"");
					mfrRec.put("flowStartDate",ord_start_date);
					mfrRec.put("flowEndDate",ord_end_date);
					setMFRRecs(mfrRec);
					setMFRRecs_fluids(mfrRec,ORDER_CATALOG_CODE);
					/*record.put("TOT_VOLUME",tot_volume+"");
					record.put("TOT_FLOW_DRUN",tot_flow_drun+"");
					record.put("TOT_DURN",tot_durn+"");*/
					try{
						closeResultSet( resultSet1 ) ;
						closeStatement( pstmt1 ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}
					//record.put("MFR_RECS", mfrRecs);
				}
				HashMap freqNature	=(HashMap)freqValidate(FREQ_CODE);
				if(freqNature.size()>0){
					freq_nature		= (String)freqNature.get("freq_nature");
					freq_value		= (String)freqNature.get("freq_value");
					interval_value	= (String)freqNature.get("interval_value");
					repeat_value	= (String)freqNature.get("repeat_value");
					schedule_yn		= (String)freqNature.get("schedule_yn");
					repeat_durn_type= (String)freqNature.get("repeat_durn_type");
				}
				record.put("FREQ_NATURE",freq_nature);
				record.put("FREQ_VALUE",freq_value);
				record.put("INTERVAL_VALUE",interval_value);
				record.put("REPEAT_VALUE",repeat_value);
				record.put("SCHEDULE_YN",schedule_yn);
				record.put("REPEAT_DURN_TYPE",repeat_durn_type);

				if(calc_dflt_dosage_by_htwt.trim().equals("Y") && !age_group.equals("")) {
			
					String sql_query	= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT81");
					pstmt				= connection.prepareStatement(sql_query) ;
					pstmt.setString(1,ORDER_CATALOG_CODE);
					pstmt.setString(2,age_group);
					resultSet1			= pstmt.executeQuery();

					if(resultSet1!=null && resultSet1.next()) {
						record.put("RECOMM_YN","Y");
						record.put("CALC_BY_IND",(resultSet1.getString("CALC_BY_IND")));
						record.put("DOSAGE_STD",(resultSet1.getString("DOSAGE_STD")));
						record.put("DOSAGE_UNIT",checkForNull(resultSet1.getString("DOSAGE_UNIT")));
						record.put("RECOMM_DOSAGE_BY",(resultSet1.getString("LIMIT_IND")));
					} 
					else {
						record.put("RECOMM_YN","N");
						record.put("CALC_BY_IND","");
						record.put("DOSAGE_STD","");
						record.put("DOSAGE_UNIT","");
						record.put("RECOMM_DOSAGE_BY","");
					}
					try{
						closeResultSet( resultSet1 ) ;
						closeStatement( pstmt ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}
				} 
				else {
					record.put("CALC_BY_IND","");
					record.put("RECOMM_YN","N");
					record.put("DOSAGE_STD","");
					record.put("DOSAGE_UNIT","");
				}				
				String proc_qty_value="";
				if(dosage_type.equals("Q")) {
					proc_qty_value=QTY_VALUE;
				} 
				else if(dosage_type.equals("S")) {
					proc_qty_value=strength_value;
				}

				cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit(?,?,?,?,?,?,?,?,?,?,?,?)}");
				cstmt.setString(1, ORDER_CATALOG_CODE);
				cstmt.setString(2, patient_id);
				cstmt.setString(3, proc_qty_value);
				cstmt.setString(4, repeat_value);
				cstmt.setString(5, dosage_type);
				cstmt.registerOutParameter(6, Types.VARCHAR);
				cstmt.registerOutParameter(7, Types.VARCHAR);
				cstmt.registerOutParameter(8, Types.VARCHAR);
				cstmt.registerOutParameter(9, Types.VARCHAR);
				cstmt.registerOutParameter(10, Types.VARCHAR);
				cstmt.registerOutParameter(11, Types.VARCHAR);
				cstmt.registerOutParameter(12, Types.VARCHAR);
				cstmt.execute();
				String limit_ind		= cstmt.getString(8);

				record.put("LIMIT_IND",limit_ind);
				record.put("DAILY_DOSE",(cstmt.getString(6)==null ? "0":cstmt.getString(6)));
				record.put("UNIT_DOSE",(cstmt.getString(7)==null ? "0":cstmt.getString(7)));
				record.put("MONO_GRAPH","");
				record.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "0":cstmt.getString(10)));
				record.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "0":cstmt.getString(11)));
				record.put("DOSAGE_UNIT",checkForNull(cstmt.getString(12)));
				if(limit_ind!=null && limit_ind.equals("N")) {
					/*DrugDetails.put("DAILY_DOSE", (cstmt.getString(6)==null ? "":cstmt.getString(6)));
					DrugDetails.put("UNIT_DOSE", (cstmt.getString(7)==null ? "":cstmt.getString(7)));
					DrugDetails.put("MIN_DAILY_DOSE", (cstmt.getString(10)==null ? "":cstmt.getString(10)));
					DrugDetails.put("MIN_UNIT_DOSE", (cstmt.getString(11)==null ? "":cstmt.getString(11)));
					DrugDetails.put("DOSAGE_UNIT", (cstmt.getString(12)==null ? "":cstmt.getString(12)));*/
					record.put("MONO_GRAPH", (cstmt.getString(9)==null ? "":cstmt.getString(9)));
				}
				/* else {
					DrugDetails.put("DAILY_DOSE",(cstmt.getString(6)==null ? "0":cstmt.getString(6)));
					DrugDetails.put("UNIT_DOSE",(cstmt.getString(7)==null ? "0":cstmt.getString(7)));
					DrugDetails.put("MONO_GRAPH","");
					DrugDetails.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "0":cstmt.getString(10)));
					DrugDetails.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "0":cstmt.getString(11)));
					DrugDetails.put("DOSAGE_UNIT", (cstmt.getString(12)==null ? "":cstmt.getString(12)));
				}*/

				/* procedure calling ends here ----------------*/

			// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- Begin
				if( act_pat_class.toUpperCase().equals("IP") && (take_home_medication.toUpperCase().equals("D") || take_home_medication.toUpperCase().equals("Y"))){
					act_pat_class="DM";
				}
				record.put("BUILD_MAR_RULE",getMARDefaulting(act_pat_class,source_code,form_code,priority));
			// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- End
				existingIVRecrds.add(record);
			}
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( cstmt ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return existingIVRecrds;
	}

	public boolean checkSplit(ArrayList frequencyValues) {
	
		boolean found		=	false;
		boolean firstTime	=	true;
		String tmp			=	"";
		String admin_qty	=	null;
		//HashMap data		=	null;
		ArrayList dose_list	=   new ArrayList();
		if(frequencyValues!=null && frequencyValues.size()>0){		
			dose_list =  (ArrayList)frequencyValues.get(4);
			for(int n=0;n<frequencyValues.size();n++){
				//data	=(HashMap)frequencyValues.get(n);
				//admin_qty	= ((String)data.get("admin_qty")).trim();

				admin_qty	= ((String)dose_list.get(0)).trim();
				if(firstTime) {
					tmp			=	admin_qty;
					firstTime	=	false;
				}
				else if(!tmp.equals(admin_qty)) {
					found		=	true;
				}
			}
		}
		return found;
	}

	public String getSysdate(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date				= "";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT5");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date=resultSet.getString(1);
			}
		}
		catch ( Exception e ) {
			sys_date = sys_date + e.toString();
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
		return sys_date;
	}

	public String getAmendRemarks(String order_id)	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String  AmendRemarks	= "";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT22A") ) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				AmendRemarks = resultSet.getString("order_comment")==null ? "":resultSet.getString("order_comment");
				this.setAmendRemarks(AmendRemarks);
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return AmendRemarks;
	}

	public String comp_date_time(String end_date,String order_id,String order_line_num){

	Connection connection       = null ;
    PreparedStatement pstmt     = null ;
    ResultSet resultSet         = null ;
	String start_date			= "";
	String sys_date1			= "";
	int count=0;
	
	try{
			connection		= getConnection() ;
			String str_qry	= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT25");
			String str_qry1	= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT26");

			pstmt					= connection.prepareStatement(str_qry) ;
			pstmt.setString(1,end_date.trim());
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				count=resultSet.getInt(1);
			}

			if(resultSet !=	null) {closeResultSet( resultSet );}
			if(pstmt	 !=	null) {closeStatement( pstmt ) ;}

			pstmt					= connection.prepareStatement(str_qry1) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				end_date	=	resultSet.getString("end_date");
				sys_date1=	resultSet.getString("curr_date");	
			}

			 if(count >=1){
					start_date = sys_date1;
			 }else {
				 start_date = end_date;
			 }
		}catch ( Exception e ) {
				   e.printStackTrace() ;

		}finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){}
				}
	return start_date;
	}

	public int administered_yn(String order_id,String encounter_id){

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;		
		String sql_str			= "";
		int administered_yn		= 0;
		
		try{
			connection = getConnection();

			sql_str			=	PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES_SELECT1");
			pstmt			= connection.prepareStatement(sql_str) ;
			
			pstmt.setString(1,order_id);
			pstmt.setString(2,encounter_id);
			
			resultSet	= pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next() ) {
					administered_yn			 =resultSet.getInt("count");
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return administered_yn;
	}
/*---10/4/2004--------*/

	public HashMap prepareAmendOrderDetails(Hashtable submitData){
	     
		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "test");
		
		Connection connection		= null;
		PreparedStatement pstmt		= null;
		ResultSet resultSet			= null;
		String ord_auth_reqd_yn		= "N";
		String ord_appr_reqd_yn		= "N";
		String ord_cosign_reqd_yn	= "N";
		String ord_consent_reqd_yn	= "N";
		String drug_desc 			= "";
		String dosage_type 			= "";
		
		String drug_code 			= "";
		String freqDurnType			= "";
		HashMap schd_week_hr_dates	=	new HashMap();     
        
		ArrayList temp =new ArrayList();
		temp = getDrugDetails();

		if (temp.size() != 0) {
			for (int i=0; i<temp.size(); i++) {
				HashMap tempMap = (HashMap)temp.get(i);

				if (tempMap.size() != 0) {
					drug_desc = drug_desc + tempMap.get("DRUG_DESC").toString() + "|";
//for ivpb only, in ivpb only one drug one fluid wil be there. - for multi freq crf
					drug_code = tempMap.get("DRUG_CODE").toString();

					if (tempMap.get("ORD_AUTH_REQD_YN")!= null && tempMap.get("ORD_AUTH_REQD_YN").toString().equals("Y"))
						ord_auth_reqd_yn = "Y";

					if (tempMap.get("ORD_SPL_APPR_REQD_YN")!= null && tempMap.get("ORD_SPL_APPR_REQD_YN").toString().equals("Y"))
						ord_appr_reqd_yn = "Y";

					if (tempMap.get("ORD_COSIGN_REQD_YN")!= null && tempMap.get("ORD_COSIGN_REQD_YN").toString().equals("Y"))
						ord_cosign_reqd_yn = "Y";

					if (tempMap.get("CONSENT_REQD_YN")!= null && tempMap.get("CONSENT_REQD_YN").toString().equals("Y"))
						ord_consent_reqd_yn = "Y";
				}
			}
		}
		String fluid_desc = getFluidDetails().get("DRUG_DESC").toString();
		HashMap orderDetails = new HashMap();
		
		HashSet keyset=new HashSet(); //Added for Bru-HIMS-CRF-393_1.0-Start
		keyset.add((String)submitData.get("ORDER_TYPE_CODE"));
		setPrintOrdShtRuleInd(keyset,getPatientClass()); 	//Added for Bru-HIMS-CRF-393_1.0-End
		orderDetails.put("ORDER_ID", getOrderID());
		orderDetails.put("IV_PB", getIVPB());
        orderDetails.put("ORDER_TYPE_CODE", submitData.get("ORDER_TYPE_CODE"));
		orderDetails.put("PATIENT_ID", getPatId());
		orderDetails.put("PATIENT_CLASS", getPatientClass());
		orderDetails.put("ENCOUNTER_ID", getEncId());
		orderDetails.put("SOURCE_TYPE", submitData.get("LOCN_TYPE"));
		orderDetails.put("SOURCE_CODE", submitData.get("LOCN_CODE"));
		orderDetails.put("INFUSE_OVER_UNIT", "H");
		orderDetails.put("BED_NUM", submitData.get("BED_NUM"));
		orderDetails.put("ROOM_NUM", submitData.get("ROOM_NUM"));
		/*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/
			ArrayList reason	=	null;
			String reason_code	=	"";
			String reason_desc	=	"";
			if(presbeanobj!=null){
				String amendCalledFrom = presbeanobj.getCalledFromAmend();
				if( amendCalledFrom!=null && amendCalledFrom.equals("PH") )  
					reason	= presbeanobj.getAmendReasonTemp(getOrderID());				
				else 
					reason	= presbeanobj.getAmendReason(getOrderID());
				
				if(reason!=null && reason.size() > 1 ) {
					reason_code		=	(String)reason.get(1);
					reason_desc		=	(String)reason.get(2);							
				}		
			}			
			orderDetails.put("AMEND_REASON_CODE",reason_code); 
			orderDetails.put("AMEND_REASON",reason_desc); 
			
			/*IN066779 Starts*/
			ArrayList AMNDreason	=	null;
			String amnd_Reason="";
			String amend_Order_Id="";
			if( getCalledFromAmend().equals("PH") )
				AMNDreason=getAmendReasonTemp(getOrderID());
			else
				AMNDreason=getAmendReason1(getOrderID());
			
			amend_Order_Id=(String)AMNDreason.get(0);
			amnd_Reason=(String)AMNDreason.get(2);
			
			orderDetails.put("AMEND_ORDER_ID",amend_Order_Id);
			orderDetails.put("AMEND_ORDER_REASON",amnd_Reason);
			
			/*IN066779 ends*/
		
		/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/
		String temp_mfr_remarks=(String)submitData.get("mfr_remarks")==null?"":(String)submitData.get("mfr_remarks");
		if(!temp_mfr_remarks.equals("")){
			try{
				temp_mfr_remarks=java.net.URLDecoder.decode(temp_mfr_remarks,"UTF-8");
			}
			catch (UnsupportedEncodingException except){
				except.printStackTrace();
			}
		}
		orderDetails.put("MFR_REMARKS",temp_mfr_remarks);
		
		if(getOrder_type_flag().equals("Existing"))
            orderDetails.put("ORD_DATE", getSysdate());
		else
			orderDetails.put("ORD_DATE", submitData.get("START_DATE"));
    
	   if(!getLanguageId().equals("en")){
		   orderDetails.put("ORD_DATE", com.ehis.util.DateUtils.convertDate((String)orderDetails.get("ORD_DATE"),"DMYHM",getLanguageId(),"en"));
		   orderDetails.put("START_DATE", com.ehis.util.DateUtils.convertDate((String)submitData.get("START_DATE"),"DMYHM",getLanguageId(),"en"));
		   orderDetails.put("END_DATE", com.ehis.util.DateUtils.convertDate((String)submitData.get("END_DATE"),"DMYHM",getLanguageId(),"en"));
	   }
	   else{
		  orderDetails.put("START_DATE", submitData.get("START_DATE"));
		  orderDetails.put("END_DATE", submitData.get("END_DATE"));
	   }

		orderDetails.put("ORD_PRACT_ID", submitData.get("PRACT_ID"));
		orderDetails.put("PRIORITY", submitData.get("PRIORITY"));
		orderDetails.put("ORD_AUTH_REQD_YN", ord_auth_reqd_yn);
		orderDetails.put("ORD_APPR_REQD_YN", ord_appr_reqd_yn);
		orderDetails.put("ORD_COSIGN_REQD_YN", ord_cosign_reqd_yn);
		orderDetails.put("ORDER_STATUS", getOrderStatus());
		orderDetails.put("ORD_CONSENT_REQD_YN", ord_consent_reqd_yn);
		orderDetails.put("IV_INGREDIANTS", fluid_desc + "|" + drug_desc);
		orderDetails.put("SCH_INFUSION_RATE", submitData.get("INFUSION_VALUE") );
		orderDetails.put("SCH_INFUSION_VOL_STR_UNIT", submitData.get("EQVL_UOM_CODE"));
		orderDetails.put("SCH_INFUSION_PERIOD", submitData.get("INFUSION_VALUE")  );
		orderDetails.put("SCH_INFUSION_PERIOD_UNIT", submitData.get("INFUSION_UOM"));
		orderDetails.put("INFUSE_OVER", submitData.get("infusion_over_insert_value") );
		orderDetails.put("INFUSE_OVER_UNIT", submitData.get("INFUSION_PERIOD_UOM"));
		orderDetails.put("FLUID_UNIT_QTY", submitData.get("STOCK_VALUE")   );

		orderDetails.put("FLUID_UNIT_QTY_UOM", submitData.get("STOCK_UOM_CODE"));
		orderDetails.put("FREQ_NATURE", getFrequencyNature());
		orderDetails.put("REP_INTERVAL", getRepeatValue() );
		orderDetails.put("INT_VALUE", getIntervalValue() );
		orderDetails.put("FREQ_CODE", submitData.get("FREQUENCY"));
		orderDetails.put("HEIGHT", submitData.get("HEIGHT"));
		orderDetails.put("HEIGHT_UNIT", submitData.get("HEIGHT_UNIT"));
		orderDetails.put("WEIGHT", submitData.get("WEIGHT"));
		orderDetails.put("WEIGHT_UNIT", submitData.get("WEIGHT_UNIT"));
		orderDetails.put("BSA", submitData.get("BSA"));
		orderDetails.put("BMI", submitData.get("BMI"));
		orderDetails.put("BSA_UNIT", submitData.get("BSA_UNIT"));
		orderDetails.put("TAKEHOME_MEDN", submitData.get("TH_MEDN"));
		orderDetails.put("DURN_UNIT", submitData.get("DURN_UNIT"));
		orderDetails.put("DURN_VALUE", submitData.get("DURN_VALUE") );
		orderDetails.put("DRUG_INDICATION", submitData.get("DRUG_INDICATION") );
		orderDetails.put("BASE_UOM", getStockUOM());
		orderDetails.put("PACK_SIZE", getPackSize() );
	
		if(getIVPB().equals("Y")){
			dosage_type = (String)submitData.get("dosage_type");// dosage_type added for issue 24668
			HashMap freqDet = getscheduleFrequency();
			orderDetails.put("DURN_VALUE_ACT", (String)submitData.get("DURN_VALUE") );
			
			if(((String)orderDetails.get("FREQ_NATURE")).equals("I")){
				HashMap freqNature			=(HashMap)freqValidate((String)submitData.get("FREQUENCY"));
				orderDetails.put("IntervalFreqDet", freqNature );
				freqDurnType =  (String)freqNature.get("interval_durn_type"); 
			}
			else{
				freqDurnType = (String)(((HashMap)(((ArrayList)freqDet.get(drug_code)).get(0))).get("durationType"));
			}
			
			HashMap drugDetail = (HashMap)((ArrayList)getDrugDetails()).get(0);
			// dosage_type added for issue 24668
			drugDetail.put("DOSAGE_TYPE",dosage_type+"");

			if(freqDurnType.equals((String)submitData.get("DURN_UNIT"))){
				orderDetails.put("DURN_VALUE",(String)submitData.get("DURN_VALUE"));
			}
			else{
				int durn_calc = getDurationCalc((String)submitData.get("DURN_UNIT"),(String)submitData.get("DURN_VALUE"),freqDurnType);
				orderDetails.put("DURN_VALUE",durn_calc+"" );
				drugDetail.put("DURN_VALUE",durn_calc+"");
				HashMap fluidDetail = getFluidDetails();
				fluidDetail.put("DURN_VALUE",durn_calc+"");
			}
		}                                      

		if(getIVType().equals("IVD"))
			orderDetails.put("IVType" , getIVType());
			
		if(getIVType().equals("IVD")){
				orderDetails.put("IV_PRESC", submitData.get("IV_PRESC_YN").toString());
		}
		else{
			if (submitData.get("IV_PRESC_YN").toString().equals("Y"))
				orderDetails.put("IV_PRESC", "I");
			else
				orderDetails.put("IV_PRESC", "N");
		}
	
		if(getIVPB().equals("Y")) {
			if(((String)orderDetails.get("IV_PRESC")).equals("I")) {
				setIVPrep("4");
			}
			else {
				setIVPrep("3");
			}
			orderDetails.put("QTY_VALUE", getDOSAGE());
			orderDetails.put("vehicle_volume", getVOLUME());
		}
		else if(((String)orderDetails.get("IVType")).equals("IVD")){
			if(((String)orderDetails.get("IV_PRESC")).equals("I")) {
				setIVPrep("2");
			}
			else {
				setIVPrep("1");
			}
			orderDetails.put("vehicle_volume", getVOLUME());
		} 
	
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT8"));
			pstmt.setString(1, login_facility_id);
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				orderDetails.put("MED_ADMIN_REQD_YN", checkNullResult(resultSet.getString("MED_ADMIN_REQD_YN"), "N"));
			}
				orderDetails.put("BUILD_MAR_YN",getBuildMAR_yn());
		}
		catch(Exception e) {
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
		orderDetails.put("MFR_Recs",getMFRRecs());
		orderDetails.put("MFR_YN",MFRYN);
		if(MFRYN.equals("Y")){
			orderDetails.put("INFUSE_OVER", getMFRRecs().get("totFlowDurnHrs") );
			orderDetails.put("START_DATE", getMFRRecs().get("flowStartDate") );
			orderDetails.put("END_DATE", getMFRRecs().get("flowEndDate") );
			orderDetails.put("DURN_VALUE", getMFRRecs().get("totDurnHrs") );
		}
		HashMap commonData = new HashMap();
		commonData.put("login_by_id",		login_by_id);
		commonData.put("login_at_ws_no",	login_at_ws_no);
		commonData.put("login_facility_id",	login_facility_id);
		HashMap tabData = new HashMap();
		tabData.put("COMMONDATA", commonData);
		tabData.put("PROPERTIES", getProperties());
		tabData.put("ORDERDETAILS", orderDetails);

		tabData.put("SCHEDULEFREQ", getscheduleFrequency());
		tabData.put("FLUIDDETAILS", getFluidDetails());
		tabData.put("DRUGDETAILS", getDrugDetails());
		tabData.put("DRUGREMARKS", getDrugRemarks());

		tabData.put("DIAG_TEXT", getDiagText());
		tabData.put("LICENSE",(String)(PhLicenceRights.getKey()));
		
		String or_mode ="";
		if(submitData.get("OR_MODE")!=null){
			or_mode = (String)submitData.get("OR_MODE");
		}
		tabData.put("OR_MODE",or_mode);
		boolean scheduled_drug=getScheduledFreqYN((String)(getFluidDetails().get("FREQ_CODE")));
		if(scheduled_drug)
			tabData.put("SCHEDULED_DRUG","Y");
		else
			tabData.put("SCHEDULED_DRUG","N");
		
		tabData.put("ORDER_COMMENTS",getAmendOrderRemarks());
		tabData.put("allergic_yn",submitData.get("allergic_yn"));
		if(getIVPB().equals("Y")){
			HashMap drugDet = (HashMap)((ArrayList)getDrugDetails()).get(0);
			if(!getLanguageId().equals("en")){
//			   drugDet.put("ORD_DATE", com.ehis.util.DateUtils.convertDate((String)drugDet.get("ORD_DATE"),"DMYHM","en",getLanguageId()));
			   drugDet.put("START_DATE", com.ehis.util.DateUtils.convertDate((String)submitData.get("START_DATE"),"DMYHM",getLanguageId(),"en"));
			   drugDet.put("START_DATE_TIME", com.ehis.util.DateUtils.convertDate((String)submitData.get("START_DATE"),"DMYHM",getLanguageId(),"en"));
			   drugDet.put("END_DATE", com.ehis.util.DateUtils.convertDate((String)submitData.get("END_DATE"),"DMYHM",getLanguageId(),"en"));
			}
			else{
				  drugDet.put("START_DATE", submitData.get("START_DATE"));
				  drugDet.put("START_DATE_TIME", submitData.get("START_DATE"));
				  drugDet.put("END_DATE", submitData.get("END_DATE"));
			}
			
			if(((String)orderDetails.get("FREQ_NATURE")).equals("I")){
				schd_week_hr_dates = getSchdDatesFrWeekHrInterval(getscheduleFrequency(),getDrugDetails(),orderDetails,"UPDATE");
			}else{
				schd_week_hr_dates = getSchdDatesFrWeekHr(getscheduleFrequency(),getDrugDetails(),"UPDATE");
			}
			tabData.put("sched_date_time_wkhr",schd_week_hr_dates);

		} 
		if(MFRYN.equals("Y")){
			getAdminRateReleaseMFR(tabData);
		}
		getAdminRateRelease(tabData);
		tabData.put("Admin_rate",getAdminRate());
		tabData.put("fluid_remarks",getFluidRemarks());
		tabData.put("lang_id",getLanguageId());
		tabData.put("print_mar_barcode_yn",getPrintMarBarcode()); //Added for MMS-QH-CRF-0080 [IN:038064]
		tabData.put("print_mar_label_yn",getPrintMarLabel());//Added for MMS-QH-CRF-0080 [IN:038064]
		if(((String)orderDetails.get("IVType")).equals("IVD"))//Added for SKR-CRF-0035
			tabData.put("iv_calc_infuse_by",getIVCalcInfuseBy());

		String result = "";
		result	=	validateStock(orderDetails,getFluidDetails(),getDrugDetails());

		if((result.trim()).equals("")) {
			HashMap sqlMap = new HashMap();
			try {
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT20A",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT20A"));//2
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT19A",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT19A"));//3
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT54",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54"));//1
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT56",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56"));//10
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT24A",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT24A"));//19
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT53",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53"));//6
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT25A",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT25A"));//17&20
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT55",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT55"));//8

		/*----------for prescription_qty calculation------------*/
				sqlMap.put("SQL_PH_AMEND_IVPRES_SELECT2",	PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES_SELECT2"));//8
				sqlMap.put("SQL_PH_AMEND_IVPRES_SELECT3",	PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES_SELECT3"));//8
        /*----------ends here------------------------------------*/
		/*update----------------*/
				sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE1",	PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE1"));//or_order//4
				sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE2",	PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE2"));//or_order_line//5
				//sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE3",PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE3"));//or_order_line_ph//7
				
				sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE3","	UPDATE OR_ORDER_LINE_PH SET SPLIT_DRUG_PREVIEW=?,TOT_STRENGTH=?,TOT_STRENGTH_UOM=?,INFUSE_OVER=?,INFUSE_OVER_UNIT=?,INFUSION_RATE=?,INFUSION_VOL_STR_UNIT=?,INFUSION_PER_UNIT=?,BMS_QTY=?,BMS_STRENGTH=?,SPLIT_DOSE_YN=?,PRES_QTY_VALUE=?,PRES_QTY_UOM=?,TOT_INFUSION_OVER=?,TOT_INFUSION_OVER_UNIT=?,AMEND_REASON_CODE=?,AMEND_REASON=?,CHNGD_FLUID_REMARKS=?,ADMIN_RATE_DETAIL=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE,  MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,DOSAGE_TYPE=?,CALC_DOSE_BASED_ON=?, CALC_DOSE_VALUE=?, CALC_DOSE_BY=?,MFR_REMARKS=?,ORIG_INFUSE_OVER=?,ORIG_INFUSION_RATE=?,BUILD_MAR_YN =?,AMENDED_BY_ID =?,AMENDED_DATE =SYSDATE, DRUG_INDICATION=? , PRES_INFUSION_RATE=? , PRES_INFUSION_QTY_UNIT=?, ALLERGY_OVERRIDE_REASON_CODE=?, DOSE_LIMIT_OVER_REASON_CODE=?, DUP_DRUG_OVERRIDE_REASON_CODE=?,ABUSE_EXISTS=?,ABUSE_DRUG_OVERRIDE_REASON=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=? ");//AMENDED_BY_ID and AMENDED_DATE added for ML-BRU-SCF-0098 [IN031837] & SKR-SCF-0543 [IN:033153] Added Column PRES_INFUSION_RATE , PRES_INFUSION_QTY_UNIT,Modified for IN:072715 Added ALLERGY_OVERRIDE_REASON_CODE,DOSE_LIMIT_OVER_REASON_CODE,DUP_DRUG_OVERRIDE_REASON_CODE
				sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE4",	PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE4"));//ph_patient_drug_profile//9
				sqlMap.put("SQL_PH_IVPRESCRIPTION_MFR_INSERT",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_MFR_INSERT"));// OR_ORDER_LINE_PH_MFR 10

				sqlMap.put("SQL_PH_IVPRESCRIPTION_MFR_DELETE", "DELETE FROM OR_ORDER_LINE_PH_MFR WHERE ORDER_ID=?");
		/*update----------------*/
       /*insert----------------*/
				sqlMap.put("SQL_PH_PRESCRIPTION_INSERT5",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5"));//11
		/*insert----------------*/				
       /*insert&delete-------------------*/
				
				sqlMap.put("SQL_PH_IVPRESCRIPTION_DELETE_MEDN_ADMIN",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_DELETE_MEDN_ADMIN"));//15
				sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT2",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT2"));//16&18
				sqlMap.put("SQL_PH_PRESCRIPTION_DELETE_FIELD_VALUES_A",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_DELETE_FIELD_VALUES_A"));	//13
				sqlMap.put("SQL_PH_PRESCRIPTION_INSERT7",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7"));//14
		/*insert&delete------------------*/
				sqlMap.put("SQL_PH_PRESCRIPTION_SELECT57",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57"));//12	
				//sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT_CONSENT_DETAILS",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT_CONSENT_DETAILS") );
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_IVPRESCRIPTION" ),IVPrescriptionHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;
				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();
				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if(((Boolean) map.get("result")).booleanValue() ) {
					map.put("message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH"));
				} 
				else {
					map.put("message", map.get("msgid"));
				}
			}
			catch (Exception e) {
				map.put("message", e.getMessage());
				e.printStackTrace();
			}
/*			finally {
				try {
//					if(remote != null )
//						remote.remove();
				}
				catch(Exception ee ) {
					System.err.println(ee.getMessage());
					map.put("message", ee.getMessage());
				}
			}*/
			map.put("flag", map.get("flag"));
		} 
		else {
			map.put("result", new Boolean(false));
			map.put("message", result);
			map.put("flag", "INSUFFICIENT_STOCK");
		}
		
		return map;
	}

public HashMap getQtyValue(String PatientId, String OrgOrderId, String OrgOrderLineNum) {

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sql_str			= "";

		String dosage_type		= "";
		String qty_value		= "";
		String strengthUom		= "";

		HashMap record = new HashMap();

		try{
		connection = getConnection();

		sql_str			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT90");
		
 	    pstmt			= connection.prepareStatement(sql_str) ;

		pstmt.setString(1,PatientId);
		pstmt.setString(2,OrgOrderId);
		pstmt.setString(3,OrgOrderLineNum);
        try{
		    resultSet	= pstmt.executeQuery();
        }catch(Exception e) {
			   e.printStackTrace() ;
		 }

		while ( resultSet != null && resultSet.next() ) {
			
				dosage_type = resultSet.getString("PRESCRIBED_MODE");
	
				qty_value	= resultSet.getString("DOSAGE");
				strengthUom = resultSet.getString("DOSAGE_UOM_CODE");

				record.put("dosage_type",dosage_type);
				record.put("qty_value",qty_value);
				record.put("strengthUom",strengthUom);
		}

		}catch(Exception e){
				record.put("Error",e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}
		}
		return record;
	}

/*--10/7/2004---*/
//getting HomeMecdicationYn
public int getHomeMecdicationYn(String encounter_id,String facility_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		int rec_count=0;
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT11");
			pstmt				= null;
			resultSet			= null;
			pstmt				= connection.prepareStatement(sql_query) ;
			double enc_id=Double.parseDouble(encounter_id);
			pstmt.setDouble(1,enc_id);
			pstmt.setString(2,facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				rec_count=resultSet.getInt(1);
			}
		}catch ( Exception e ) {
                e.printStackTrace() ;
		} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){}
         }

		return rec_count;
}

	public ArrayList getFreqDet(String order_id,String order_line_no){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		ArrayList freq_det			=	new ArrayList();
		String	field_value			=	"";
		String	qty_value			=	"";
		String	qty_unit			=	"";
		String	freq_day			=	"";

		try{
		connection			= getConnection() ;
		sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT61");
		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,order_id);
		pstmt.setString(2,order_line_no);

		resultSet			= pstmt.executeQuery();
		while(resultSet!=null && resultSet.next())	{
			field_value		=	resultSet.getString("ORDER_LINE_FIELD_VALUE")==null?"":resultSet.getString("ORDER_LINE_FIELD_VALUE");
			qty_value		=	resultSet.getString("ORDER_LINE_DOSE_QTY_VALUE")==null?"":resultSet.getString("ORDER_LINE_DOSE_QTY_VALUE");
			qty_unit		=	resultSet.getString("ORDER_LINE_DOSE_QTY_UNIT")==null?"":resultSet.getString("ORDER_LINE_DOSE_QTY_UNIT");
			freq_day		=	resultSet.getString("ORDER_LINE_FREQ_DAY")==null?"":resultSet.getString("ORDER_LINE_FREQ_DAY");

			freq_det.add(field_value);
			freq_det.add(qty_value);
			freq_det.add(qty_unit);
			freq_det.add(freq_day);
		}

		}catch ( Exception e ) {
                e.printStackTrace() ;
         } finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){}
              }


		return freq_det;
}

public String getFractDoseRndyn(String drug_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String fract_dose			= "";

		try{
			connection			= getConnection() ;
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES_SELECT2");

			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drug_code);

			resultSet			= pstmt.executeQuery();
		
			while(resultSet!=null && resultSet.next()){
				fract_dose = resultSet.getString("fract_dose_round_up_yn");
			}

		}catch ( Exception e ) {
                e.printStackTrace() ;
         } finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){}
			     }

		return fract_dose;
	}

// function to fetch the unit of measurement for gram in AM 

	public ArrayList getExistingUom(String uom_id){

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		
		String sql_str			= "";

		String UOM_CODE			= "";
		String EQVL_UOM_CODE	= "";
		String EQVL_VALUE		= "";

		ArrayList existingUom	= new ArrayList();
		HashMap record = null;

		try{
		connection = getConnection();

	//	sql_str			= PhRepository.getPhKeyValue("SQL_PH_DRUG_UOM_SELECT1");
	sql_str=     ("select  UOM_CODE, EQVL_UOM_CODE, EQVL_VALUE from AM_UOM_EQVL where  EQVL_UOM_CODE = UPPER(?) ORDER BY EQVL_VALUE");//added for ARYU-SCF-0074
		pstmt			= connection.prepareStatement(sql_str) ;
		pstmt.setString(1,uom_id);
		
		resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				   record = new HashMap();
					
					UOM_CODE =resultSet.getString("UOM_CODE");
					EQVL_UOM_CODE = resultSet.getString("EQVL_UOM_CODE");
					EQVL_VALUE = resultSet.getString("EQVL_VALUE");

					record.put("UOM_CODE",UOM_CODE);
					record.put("EQVL_UOM_CODE",EQVL_UOM_CODE);
					record.put("EQVL_VALUE",EQVL_VALUE);
					
					existingUom.add(record);
			}
		}catch(Exception e){
				existingUom.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}
		}
		return existingUom;
	}

// function getOrdersetCodes() fetches the fluid and drugcodes defined for the selected order set.  
	public ArrayList getOrdersetCodes(String order_set_code){
		Connection connection		= null;
        PreparedStatement psmt		= null;
        ResultSet resultSet			= null;
		CallableStatement	cstmt	= null ;
		ArrayList orderSetCodes		= new ArrayList();
		ArrayList orderSetValues	= new ArrayList();
		String cmp_fld_codes		= "";
		StringBuffer sel_drg_codes	= new StringBuffer();

		try {
			connection	= getConnection();
			psmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT17"));
			psmt.setString(1, order_set_code);
			resultSet	= psmt.executeQuery();
			while(resultSet.next()) {
				orderSetCodes.add(resultSet.getString("ORDER_CATALOG_CODE"));
				orderSetValues.add(resultSet.getString("ORDER_CATALOG_CODE"));
				orderSetValues.add(resultSet.getString("QTY_VALUE")== null ? "" :resultSet.getString("QTY_VALUE"));
				orderSetValues.add(resultSet.getString("QTY_UNIT")== null ? "" :resultSet.getString("QTY_UNIT"));
				orderSetValues.add(resultSet.getString("FREQ_CODE")== null ? "" :resultSet.getString("FREQ_CODE"));
				orderSetValues.add(resultSet.getString("DURN_VALUE")== null ? "" :resultSet.getString("DURN_VALUE"));
				orderSetValues.add(resultSet.getString("DURN_TYPE")== null ? "" :resultSet.getString("DURN_TYPE"));
				orderSetValues.add(resultSet.getString("REQD_OR_OPT_IND")== null ? "" :resultSet.getString("REQD_OR_OPT_IND"));
				orderSetValues.add(resultSet.getString("REL_START_DATE_TIME")== null ? "" :resultSet.getString("REL_START_DATE_TIME"));
			}
			setOrderSetValues(orderSetValues);

			for(int i=1;i<orderSetCodes.size();i++){
				if(sel_drg_codes.length()>0)
					sel_drg_codes.append(",");
				sel_drg_codes.append(orderSetCodes.get(i));
			}

			cstmt=connection.prepareCall("{call  PH_Get_Fluid_Code (?,?)}");
			cstmt.setString( 1, sel_drg_codes.toString());
			cstmt.registerOutParameter(2, Types.VARCHAR );
			cstmt.execute() ;
			cmp_fld_codes = cstmt.getString(2);
			if (cmp_fld_codes == null){ cmp_fld_codes = "";}

			if(!cmp_fld_codes.equals("")){
				StringTokenizer st = new StringTokenizer(cmp_fld_codes, ",");
				String thisToken = "";
				while (st.hasMoreTokens()) {
					thisToken = st.nextToken();
					thisToken = thisToken.substring(1,thisToken.length()-1);
					if (thisToken.equals((String)orderSetCodes.get(0))) {
						this.comptabile_fluid_yn = "Y";
						break;
					}
				}
			}else{
				this.comptabile_fluid_yn = "N";
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(psmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return orderSetCodes;
	}

	public HashMap getOrderSetDrugs(String orderset_drug) {

		Connection connection				= null ;
		PreparedStatement pstmt				= null ;
		ResultSet resultSet					= null ;
		
		String drug_code					= "";
		String drug_desc					= "";
		String form_code					= "";
		String strength_value				= "";
		String strength_uom					= "";
		String strength_per_pres_uom		= "";
		String strength_per_value_pres_uom  = "";
		String pres_base_uom				= "";
		String route_code					= "";
		String content_in_pres_base_uom		= "";
		
		HashMap record = new HashMap();

		try{
			connection = getConnection();

    	    pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT18"));

			pstmt.setString(1,orderset_drug);
			pstmt.setString(2, getLanguageId());

			resultSet	= pstmt.executeQuery();

			while ( resultSet != null && resultSet.next() ) {
			
				drug_code					= resultSet.getString("DRUG_CODE");
				drug_desc					= resultSet.getString("DRUG_DESC");
				form_code					= resultSet.getString("FORM_CODE");
				strength_value				= resultSet.getString("STRENGTH_VALUE");
				strength_uom				= resultSet.getString("STRENGTH_UOM");
				strength_per_pres_uom		= resultSet.getString("STRENGTH_PER_PRES_UOM");
				strength_per_value_pres_uom = resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM");
				pres_base_uom				= resultSet.getString("PRES_BASE_UOM");
				route_code					= resultSet.getString("ROUTE_CODE");
				content_in_pres_base_uom	= resultSet.getString("CONTENT_IN_PRES_BASE_UOM");

				record.put("drug_code",drug_code);
				record.put("drug_desc",drug_desc);
				record.put("form_code",form_code);
				record.put("strength_value",strength_value);
				record.put("strength_uom",strength_uom);
				record.put("strength_per_pres_uom",strength_per_pres_uom);
				record.put("strength_per_value_pres_uom",strength_per_value_pres_uom);
				record.put("pres_base_uom",pres_base_uom);
				record.put("route_code",route_code);
				record.put("content_in_pres_base_uom",content_in_pres_base_uom);
			}

		}catch(Exception e){
				record.put("Error in getting orderset drug values :",e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}
		}
		return record;
	}

	public String getDrugDesc(String drug_code) {
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		String drug_desc			= "";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT6A"));
			pstmt.setString(1, drug_code);
			pstmt.setString(2, getLanguageId());
			resultSet	= pstmt.executeQuery();

			if (resultSet.next()) {
				drug_desc = resultSet.getString("DRUG_DESC");
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
			catch(Exception es) {}
		}
		return drug_desc;
	}
	
	public void getAdminRateRelease(HashMap tabData) {
		String weight			= "";
		String infuse_over		= "";
		String infuse_over_unit	= "";
		HashMap order_details   = new HashMap();
		String strength			= ""; 
		String uom_id			= "";
		ArrayList uom_details	= null;
		float admin_rate		= 0.0f;
		float tmp_admin_rate	= 0.0f;
		String admin_rate_uom	= "";
		ArrayList drugList = null;
		StringBuffer strBuffer = null;
		HashMap drugDetails	= null;
		try {
				order_details		= (HashMap)tabData.get("ORDERDETAILS");
				weight				= (String)order_details.get("WEIGHT");
				infuse_over			= (String)order_details.get("INFUSE_OVER");
				infuse_over_unit	= (String)order_details.get("INFUSE_OVER_UNIT");
				
				if(weight != null && !weight.equals("0.00") && !weight.equals("") && infuse_over != null && !infuse_over.equals("")){

					drugList = (ArrayList)tabData.get("DRUGDETAILS");
					strBuffer = new StringBuffer("");
	
					if (drugList.size() != 0) {
						for (int i=0; i<drugList.size(); i++) {
							drugDetails	= (HashMap)drugList.get(i);

							if(drugDetails.get("DOSAGE_TYPE") !=null && drugDetails.get("DOSAGE_TYPE").equals("S") ){
						
							uom_id = (String)drugDetails.get("STRENGTH_UOM");
							admin_rate_uom  = (String)drugDetails.get("STRENGTH_UOM");
							uom_details	= getExistingUom(uom_id);
							strength = (String)drugDetails.get("QTY_VALUE");
							if(infuse_over_unit.equals("H") || infuse_over_unit.equals("M")){

								  if(!getDOSAGE().equals("")){
									strength = getDOSAGE();
								  }
							}
											
							if(infuse_over_unit.equals("M")){
								admin_rate	= Float.parseFloat(strength)/(Float.parseFloat(infuse_over)* Float.parseFloat(weight));
							}else{
								admin_rate	= Float.parseFloat(strength)/(Float.parseFloat(infuse_over)* Float.parseFloat(weight)*60);
							}
							
							if(admin_rate < 1){
								for(int j=0; j<uom_details.size(); j++){
									HashMap uom_values = null;
									uom_values = (HashMap)uom_details.get(j);
									tmp_admin_rate = admin_rate * Float.parseFloat((String)uom_values.get("EQVL_VALUE"));
									admin_rate_uom = (String)uom_values.get("EQVL_UOM_CODE");
									if(tmp_admin_rate >=1) break;
								}
							}else{
								tmp_admin_rate =admin_rate;
							}	
						if(tmp_admin_rate!=0) {	
							String rate		=	tmp_admin_rate+"";	
							int index		=	rate.indexOf(".");
							int tot_len		=	rate.length();
							if(tot_len>=index+3) {
								tmp_admin_rate	=	Float.parseFloat(rate.substring(0,index+3));

							}
						}

						if(tmp_admin_rate<1) {
								continue; 
						} else {
							if(strBuffer.length()!=0) strBuffer.append(" , ");
							else strBuffer.append(" Admin Rate: ");
							strBuffer.append(drugDetails.get("GENERIC_NAME"));
							strBuffer.append(" ");
							strBuffer.append(tmp_admin_rate);
							strBuffer.append(" ");
							strBuffer.append(admin_rate_uom);
							strBuffer.append("/kg/min");
						  }
					}
				}
			  }
				setAdminRate(strBuffer.toString());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAdminRateReleaseMFR(HashMap tabData) {

		String weight			= "";
		String infuse_over		= "";
		String infuse_over_unit	= "";
		HashMap order_details   = new HashMap();
		String strength			= ""; 
		String uom_id			= "";
		ArrayList uom_details	= null;
		float admin_rate		= 0.0f;
		float tmp_admin_rate	= 0.0f;
		String admin_rate_uom	= "";
		HashMap mfrRecs = new HashMap();
		String totRecs = "";
		ArrayList rec = new ArrayList();
		ArrayList drugList = null;
		StringBuffer strBuffer = null;
		HashMap drugDetails = null;
		try {
				
			order_details		= (HashMap)tabData.get("ORDERDETAILS");

			weight				= (String)order_details.get("WEIGHT");
			mfrRecs = (HashMap)order_details.get("MFR_Recs");
			totRecs = (String)mfrRecs.get("totRec");
			for(int k=1; k<= Integer.parseInt(totRecs); k++){
				rec			= (ArrayList)mfrRecs.get("MFR"+k);
				infuse_over			= (String)rec.get(5);
				infuse_over_unit	= (String)order_details.get("INFUSE_OVER_UNIT");
				if(weight != null && !weight.equals("0.00") && !weight.equals("") && infuse_over != null && !infuse_over.equals("")){

					drugList = (ArrayList)tabData.get("DRUGDETAILS");
					strBuffer = new StringBuffer("");
	
					if (drugList.size() != 0) {
						for (int i=0; i<drugList.size(); i++) {
							drugDetails	= (HashMap)drugList.get(i);
							if(drugDetails.get("DOSAGE_TYPE") !=null && drugDetails.get("DOSAGE_TYPE").equals("S") ){
						
							uom_id = (String)drugDetails.get("STRENGTH_UOM");
							admin_rate_uom  = (String)drugDetails.get("STRENGTH_UOM");
							uom_details	= getExistingUom(uom_id);
							strength = (String)drugDetails.get("QTY_VALUE");
							if(infuse_over_unit.equals("H") || infuse_over_unit.equals("M")){

								  if(!getDOSAGE().equals("")){
									strength = getDOSAGE();
								  }
							}
											
							if(infuse_over_unit.equals("M")){
								admin_rate	= Float.parseFloat(strength)/(Float.parseFloat(infuse_over)* Float.parseFloat(weight));
							}else{
								admin_rate	= Float.parseFloat(strength)/(Float.parseFloat(infuse_over)* Float.parseFloat(weight)*60);
							}
							if(admin_rate < 1){
								for(int j=0; j<uom_details.size(); j++){
									HashMap uom_values = null;
									uom_values = (HashMap)uom_details.get(j);
									tmp_admin_rate = admin_rate * Float.parseFloat((String)uom_values.get("EQVL_VALUE"));
									admin_rate_uom = (String)uom_values.get("EQVL_UOM_CODE");
									if(tmp_admin_rate >=1) break;
								}
							}else{
								tmp_admin_rate =admin_rate;
							}	
						if(tmp_admin_rate!=0) {	
							String rate		=	tmp_admin_rate+"";	
							int index		=	rate.indexOf(".");
							int tot_len		=	rate.length();
							if(tot_len>=index+3) {
								tmp_admin_rate	=	Float.parseFloat(rate.substring(0,index+3));

							}
						}
						if(tmp_admin_rate<1) {
								continue; 
						} else {
							if(strBuffer.length()!=0) strBuffer.append(" , ");
							else strBuffer.append(" Admin Rate: ");
							strBuffer.append(drugDetails.get("GENERIC_NAME"));
							strBuffer.append(" ");
							strBuffer.append(tmp_admin_rate);
							strBuffer.append(" ");
							strBuffer.append(admin_rate_uom);
							strBuffer.append("/kg/min");
						  }
					}
				}
			  }
//				setAdminRate(strBuffer.toString());
				rec.add(strBuffer.toString());
			}else{
				rec.add("");
			}
			mfrRecs.put("MFR"+k,rec);
				}
			order_details.put("MFR_Recs",mfrRecs);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/*=====12/29/2004==================================================*/
   public HashMap ChkAdMixture(){
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String iv_admixture_appl_yn	= "";
		HashMap result				= new HashMap();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt.setString(1,getLoginFacilityId());
			
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()) {
                 iv_admixture_appl_yn =resultSet.getString("IV_ADMIXTURE_APPL_YN");
			     result.put("IV_ADMIXTURE_APPL_YN",iv_admixture_appl_yn);
				 result.put("ALERT_PRACTITIONER_YN",resultSet.getString("ALERT_PRACTITIONER_YN"));
			}
		
            if(iv_admixture_appl_yn.equals("Y")) {
			  pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT92") );
			  pstmt.setString(1,getLoginFacilityId());
			  resultSet = pstmt.executeQuery() ;
			
			  if (resultSet != null && resultSet.next()){
				result.put("time_flag",resultSet.getString(1));
			  }
			}
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
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
		return result;
	}

	public String ChkWorkingHours(String disp_locn_code){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String working_hours_flag ="";
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "SELECT 'X'FROM PH_disp_locn WHERE FACILITY_ID=? and disp_locn_code=? group by WORKING_HOURS_To,WORKING_HOURS_FROM having to_char(sysdate,'hh24:mi')  between to_char(WORKING_HOURS_FROM,'hh24:mi') and to_char(WORKING_HOURS_To,'hh24:mi')");
			pstmt.setString(1,getLoginFacilityId());
			pstmt.setString(2,disp_locn_code);
			resultSet = pstmt.executeQuery() ;

			if (resultSet != null && resultSet.next()){
				working_hours_flag = resultSet.getString(1);
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
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
				es.printStackTrace();
			}
		}
		return working_hours_flag;
	}

	public HashMap getDrugDtls(String drug_code) {
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		HashMap drug_dtls	        = new HashMap();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT6C"));
			pstmt.setString(1, drug_code);
			resultSet	= pstmt.executeQuery();

			if (resultSet.next()) {
				drug_dtls.put("ORDER_TYPE_CODE",resultSet.getString("ORDER_TYPE_CODE"));
				drug_dtls.put("ROUTE_CODE",resultSet.getString("ROUTE_CODE"));
				drug_dtls.put("FORM_CODE",resultSet.getString("FORM_CODE"));
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
			catch(Exception es) {}
		}
		return drug_dtls;
	}

	public ArrayList getCompDrugDtls(String order_id,String act_pat_class){  // RUT-CRF-0062 Added act_pat_class to get the Build MAR Rule
	    Connection connection		= null;
        PreparedStatement pstmt		= null;
		PreparedStatement pstmt1	= null;
		PreparedStatement pstmt2	= null;
        ResultSet resultSet			= null;
        ResultSet resultSet1		= null;
        ResultSet resultSet2		= null;
		HashMap drug_dtls	        = null;
		ArrayList comp_drugs        = new ArrayList();
		String form_code			= "";
		String priority				= "";
		String locn_code			= "";
		String take_home_medication = "";
		int count_rx	= 0;
		try {
			connection	= getConnection();
//			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_COMP_PRESCRIPTION_SELECT2"));
//pstmt		= connection.prepareStatement(" SELECT ORDER_CATALOG_CODE,CATALOG_DESC,A.FREQ_CODE,D.REPEAT_VALUE,QTY_VALUE,QTY_UNIT,DURN_VALUE,ORDER_QTY,ORDER_UOM,TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE_TIME,TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE_TIME,FORM_DESC,STRENGTH_VALUE,STRENGTH_UOM,ph_get_ext_prod_drug_code(b.drug_code,?)EXTERNAL_PRODUCT_ID ,E.ALLERGY_OVERRIDE_REASON,E.DOSAGE_LIMIT_OVERRIDE_REASON,E.DUPLICATE_DRUG_OVERRIDE_REASON,E.INTERACTION_OVERRIDE_REASON,E.CONTRAIND_OVERRIDE_REASON FROM OR_ORDER_LINE A,PH_DRUG B,PH_FORM C,AM_FREQUENCY D,PH_PATIENT_DRUG_PROFILE E WHERE A.ORDER_CATALOG_CODE=B.DRUG_CODE AND A.FORM_CODE=C.FORM_CODE AND A.FREQ_CODE = D.FREQ_CODE AND  ORDER_ID=? and a.order_id=e.orig_order_id and a.order_line_num =e.orig_order_line_no ORDER BY A.ORDER_LINE_NUM");
			//pstmt		= connection.prepareStatement(" SELECT A.ORDER_CATALOG_CODE,CATALOG_DESC,A.FREQ_CODE,D.REPEAT_VALUE,QTY_VALUE,QTY_UNIT,DURN_VALUE,ORDER_QTY,ORDER_UOM, TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE_TIME,TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE_TIME, FORM_DESC,B.STRENGTH_VALUE, B.STRENGTH_UOM,ph_get_ext_prod_drug_code(b.drug_code,?)EXTERNAL_PRODUCT_ID ,E.ALLERGY_OVERRIDE_REASON, E.DOSAGE_LIMIT_OVERRIDE_REASON,E.DUPLICATE_DRUG_OVERRIDE_REASON,E.INTERACTION_OVERRIDE_REASON,E.CONTRAIND_OVERRIDE_REASON, F.BUILD_MAR_YN, A.ORDER_LINE_NUM,B.GENERIC_ID,E.PATIENT_ID,B.PRES_BASE_UOM  FROM OR_ORDER_LINE A,PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,AM_FREQUENCY_LANG_VW D,PH_PATIENT_DRUG_PROFILE E, OR_ORDER_LINE_PH F  WHERE A.ORDER_CATALOG_CODE=B.DRUG_CODE AND A.FORM_CODE=C.FORM_CODE  AND A.FREQ_CODE = D.FREQ_CODE AND  A.ORDER_ID=? AND A.ORDER_ID = F.ORDER_ID and a.order_id=e.orig_order_id and a.order_line_num =e.orig_order_line_no AND b.language_id = c.language_id AND b.language_id = d.language_id AND b.language_id = ? AND F.order_id=e.orig_order_id and f.order_line_num =e.orig_order_line_no ORDER BY A.ORDER_LINE_NUM");
			//  RUT-CRF-0062 [IN029600]Build MAR Rule  - Added FORM_CODE, LOCN_CODE, PRIORITY in query -- begin
			pstmt		= connection.prepareStatement(" SELECT A.ORDER_CATALOG_CODE,CATALOG_DESC,A.FREQ_CODE,D.REPEAT_VALUE,QTY_VALUE,QTY_UNIT,DURN_VALUE,ORDER_QTY,ORDER_UOM, TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE_TIME,TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE_TIME,A.PRIORITY,FORM_CODE,FORM_DESC,E.LOCN_CODE,B.STRENGTH_VALUE, B.STRENGTH_UOM,ph_get_ext_prod_drug_code(b.drug_code,?)EXTERNAL_PRODUCT_ID ,E.ALLERGY_OVERRIDE_REASON, E.DOSAGE_LIMIT_OVERRIDE_REASON,E.DUPLICATE_DRUG_OVERRIDE_REASON,E.INTERACTION_OVERRIDE_REASON,E.CONTRAIND_OVERRIDE_REASON, F.BUILD_MAR_YN, A.ORDER_LINE_NUM,B.GENERIC_ID,E.PATIENT_ID,B.PRES_BASE_UOM,G.DISCHARGE_IND TAKEHOME,F.DRUG_INDICATION, A.ROUTE_CODE   FROM OR_ORDER_LINE A,PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,AM_FREQUENCY_LANG_VW D,PH_PATIENT_DRUG_PROFILE E, OR_ORDER_LINE_PH F,OR_ORDER G  WHERE A.ORDER_CATALOG_CODE=B.DRUG_CODE AND A.FORM_CODE=C.FORM_CODE  AND A.FREQ_CODE = D.FREQ_CODE AND  A.ORDER_ID=? AND A.ORDER_ID = F.ORDER_ID AND A.ORDER_ID=G.ORDER_ID and a.order_id=e.orig_order_id and a.order_line_num =e.orig_order_line_no AND b.language_id = c.language_id AND b.language_id = d.language_id AND b.language_id = ? AND F.order_id=e.orig_order_id and f.order_line_num =e.orig_order_line_no ORDER BY A.ORDER_LINE_NUM");//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]
			//  RUT-CRF-0062 [IN029600]Build MAR Rule  - Added FORM_CODE, LOCN_CODE, PRIORITY in query -- end
			pstmt1			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13"));
			pstmt2			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT4A"));

			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, order_id);
			pstmt.setString(3, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while(resultSet.next()) {
                drug_dtls=new HashMap();
				count_rx	= 0;
				drug_dtls.put("ORDER_CATALOG_CODE",resultSet.getString("ORDER_CATALOG_CODE"));
				drug_dtls.put("CATALOG_DESC",resultSet.getString("CATALOG_DESC"));
				drug_dtls.put("FREQ_CODE",resultSet.getString("FREQ_CODE"));
				drug_dtls.put("QTY_VALUE",resultSet.getString("QTY_VALUE"));
				drug_dtls.put("QTY_UNIT",resultSet.getString("QTY_UNIT"));
				drug_dtls.put("DURN_VALUE",resultSet.getString("DURN_VALUE"));
				drug_dtls.put("ORDER_QTY",resultSet.getString("ORDER_QTY"));
				drug_dtls.put("ORDER_UOM",resultSet.getString("ORDER_UOM"));
				drug_dtls.put("ORDER_LINE_NUM",resultSet.getString("ORDER_LINE_NUM"));
				drug_dtls.put("ROUTE_CODE",resultSet.getString("ROUTE_CODE"));
				
				if(!getLanguageId().equals("en")){
					drug_dtls.put("START_DATE_TIME",com.ehis.util.DateUtils.convertDate(resultSet.getString("START_DATE_TIME"),"DMYHM","en",getLanguageId()));
					drug_dtls.put("END_DATE_TIME",com.ehis.util.DateUtils.convertDate(resultSet.getString("END_DATE_TIME"),"DMYHM","en",getLanguageId()));
				}
				else{	   
					drug_dtls.put("START_DATE_TIME",resultSet.getString("START_DATE_TIME"));
					drug_dtls.put("END_DATE_TIME",resultSet.getString("END_DATE_TIME"));
				}
				
				form_code=resultSet.getString("FORM_CODE")==null?"":resultSet.getString("FORM_CODE");  
				locn_code=resultSet.getString("LOCN_CODE")==null?"":resultSet.getString("LOCN_CODE");  
				priority=resultSet.getString("PRIORITY")==null?"":resultSet.getString("PRIORITY");  
				take_home_medication=resultSet.getString("TAKEHOME")==null?"":resultSet.getString("TAKEHOME");  
				// RUT-CRF-0062 [IN029600] to get Build MAR Rule in drug level -- end
				drug_dtls.put("FORM_DESC",resultSet.getString("FORM_DESC"));
				drug_dtls.put("STRENGTH_VALUE",resultSet.getString("STRENGTH_VALUE"));
				drug_dtls.put("STRENGTH_UOM",resultSet.getString("STRENGTH_UOM"));
				drug_dtls.put("REPEAT_VALUE",resultSet.getString("REPEAT_VALUE"));
				drug_dtls.put("EXTERNAL_PRODUCT_ID",checkForNull(resultSet.getString("EXTERNAL_PRODUCT_ID")));
				drug_dtls.put("ALLERGY_OVERRIDE_REASON",checkForNull(resultSet.getString("ALLERGY_OVERRIDE_REASON")));
				drug_dtls.put("DOSAGE_LIMIT_OVERRIDE_REASON",checkForNull(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")));
				drug_dtls.put("DUPLICATE_DRUG_OVERRIDE_REASON",checkForNull(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")));
				drug_dtls.put("INTERACTION_OVERRIDE_REASON",checkForNull(resultSet.getString("INTERACTION_OVERRIDE_REASON")));
				drug_dtls.put("CONTRAIND_OVERRIDE_REASON",checkForNull(resultSet.getString("CONTRAIND_OVERRIDE_REASON")));
				drug_dtls.put("BUILD_MAR_YN",checkForNull(resultSet.getString("BUILD_MAR_YN")));
				drug_dtls.put("DRUG_INDICATION",checkForNull(resultSet.getString("DRUG_INDICATION")));//Added for  ML-BRU-CRF-072[Inc:29938]
				drug_dtls.put("ALLERGY_REMARKS",checkForNull(resultSet.getString("ALLERGY_OVERRIDE_REASON")));
				drug_dtls.put("DOSE_REMARKS",checkForNull(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")));
				drug_dtls.put("CURRENTRX_REMARKS",checkForNull(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")));

				drug_dtls.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",checkForNull(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")));
				drug_dtls.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",checkForNull(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")));
				drug_dtls.put("EXTERNAL_INTERACTION_OVERRIDE_REASON",checkForNull(resultSet.getString("INTERACTION_OVERRIDE_REASON")));
				drug_dtls.put("EXTERNAL_CONTRA_OVERRIDE_REASON",checkForNull(resultSet.getString("CONTRAIND_OVERRIDE_REASON")));
				drug_dtls.put("EXTERNAL_ALERGY_OVERRIDE_REASON",checkForNull(resultSet.getString("ALLERGY_OVERRIDE_REASON")));

				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN","N");
				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN","N");
				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN","N");
				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN","N");

				pstmt1.setString(1, resultSet.getString("PATIENT_ID"));
				pstmt1.setString(2, resultSet.getString("GENERIC_ID"));
				pstmt1.setString(3, resultSet.getString("START_DATE_TIME"));
				pstmt1.setString(4, resultSet.getString("END_DATE_TIME"));// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt1.setString(5, resultSet.getString("START_DATE_TIME"));// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt1.setString(6, resultSet.getString("END_DATE_TIME"));// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt1.setString(7, resultSet.getString("START_DATE_TIME"));// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt1.setString(8, resultSet.getString("END_DATE_TIME")); // Added for ML-BRU-SCF-0811 [IN:039394]
				
				resultSet1			= pstmt1.executeQuery();

				if(resultSet1!=null && resultSet1.next())
					count_rx=resultSet1.getInt(1);

				closeResultSet(resultSet1);
				closeStatement(pstmt1);

				if(count_rx>1) {
					drug_dtls.put("CURRENT_RX","Y");
				}
				else {
					drug_dtls.put("CURRENT_RX","N");
				}
				drug_dtls.put("COUNT_RX",count_rx);

/*					cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit(?,?,?,?,?,?,?,?,?,?,?,?)}");
					cstmt.setString(1, drugCode);
					cstmt.setString(2, patient_id);
					cstmt.setString(3, proc_qty_value);
					cstmt.setString(4, "1");
					cstmt.setString(5, dosage_type);
					cstmt.registerOutParameter(6, Types.VARCHAR);
					cstmt.registerOutParameter(7, Types.VARCHAR);
					cstmt.registerOutParameter(8, Types.VARCHAR);
					cstmt.registerOutParameter(9, Types.VARCHAR);
					cstmt.registerOutParameter(10, Types.VARCHAR);
					cstmt.registerOutParameter(11, Types.VARCHAR);
					cstmt.registerOutParameter(12, Types.VARCHAR);
					cstmt.execute();
	//				String daily_dose		= "";
	//				String unit_dose		= "";
	//				String min_daily_dose	= "";
	//				String min_unit_dose	= "";
					String limit_ind		= cstmt.getString(8);
	//				String mono_graph		= "";
	//				String dosage_unit		= "";
					drug_dtls.put("LIMIT_IND",limit_ind);

					drug_dtls.put("DAILY_DOSE",(cstmt.getString(6)==null ? "0":cstmt.getString(6)));
					drug_dtls.put("UNIT_DOSE",(cstmt.getString(7)==null ? "0":cstmt.getString(7)));
					drug_dtls.put("MONO_GRAPH","");
					drug_dtls.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "0":cstmt.getString(10)));
					drug_dtls.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "0":cstmt.getString(11)));
					drug_dtls.put("DOSAGE_UNIT", (cstmt.getString(12)==null ? "":cstmt.getString(12)));
					if(limit_ind!=null && limit_ind.equals("N")) {
						drug_dtls.put("MONO_GRAPH", (cstmt.getString(9)==null ? "":cstmt.getString(9)));
					}*/
				pstmt2.setString(1,resultSet.getString("GENERIC_ID"));
				pstmt2.setString(2,resultSet.getString("PATIENT_ID"));
				pstmt2.setString(3,getLanguageId());
				pstmt2.setString(4,resultSet.getString("GENERIC_ID"));
				pstmt2.setString(5,resultSet.getString("PATIENT_ID"));

				int rec_count	=0;
				resultSet2		= pstmt2.executeQuery();

				if(resultSet2!=null && resultSet2.next()) {
					rec_count=resultSet2.getInt(1);
				}
				closeResultSet(resultSet2);
				closeStatement(pstmt2);

				if(rec_count>0) {
					drug_dtls.put("ALLERGY_YN","Y");
				} 
				else {
					drug_dtls.put("ALLERGY_YN","N");
						//Code Added for	RUT-CRF-0065 IN 29603 - Start
						String ATC_allergy="0";
						String atc_allergy_alert_level = getATCAllergyLevel();
						if(!atc_allergy_alert_level.equals("N")){
							pstmt1				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL_ALLERGY_CHECK"));
							pstmt1.setString(1,patient_id);
							pstmt1.setString(2,resultSet.getString("GENERIC_ID"));
							pstmt1.setString(3,atc_allergy_alert_level);
							resultSet1			= pstmt1.executeQuery();
							if(resultSet1!=null && resultSet1.next())
								ATC_allergy = resultSet1.getString("ATC_CHECK_EXISTS");
							closeResultSet( resultSet1 ) ;
							closeStatement( pstmt1 ) ;
							if(ATC_allergy!=null && !ATC_allergy.equals("0")){
								drug_dtls.put("ALLERGY_YN","Y");
							}
							else
								drug_dtls.put("ALLERGY_YN","N");
						}
						//Code Added for	RUT-CRF-0065 IN 29603 - End
				}

				drug_dtls.put("PRES_BASE_UOM",resultSet.getString("PRES_BASE_UOM"));
			// RUT-CRF-0062 [IN029600]  Added to get Build MAR Rule -- begin
				if(act_pat_class.toUpperCase().equals("IP") && (take_home_medication.toUpperCase().equals("D") || take_home_medication.toUpperCase().equals("Y"))){
					act_pat_class="DM";
				}
				drug_dtls.put("BUILD_MAR_RULE",getMARDefaulting(act_pat_class,locn_code,form_code,priority));
				comp_drugs.add(drug_dtls);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeResultSet(resultSet1);
				closeStatement(pstmt);
				closeStatement(pstmt1);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}

		return comp_drugs;
	}

	public HashMap releaseAmendCompoundRx1(HashMap record){
   	  Connection connection					= null;
	  PreparedStatement pstmt_update		= null;
	  ResultSet         resultSet			= null;
	  int result                            = 0;
	  HashMap map = new HashMap();
	  map.put("result", new Boolean(false));
	  map.put("flag", "test");
	  try {
			connection		= getConnection();
			pstmt_update	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_COMP_PRESCRIPTION_AMEND1"));
			pstmt_update.setString(1, (String)record.get("DOSAGE"));        // QTY_VALUE
			pstmt_update.setString(2, (String)record.get("FREQ_CODE"));  	// FREQ_CODE
			pstmt_update.setString(3, (String)record.get("DURN_VALUE"));	// DURN_VALUE
			pstmt_update.setString(4, (String)record.get("START_DATE"));	// START_DATE_TIME
			pstmt_update.setString(5, (String)record.get("END_DATE"));		// END_DATE_TIME
			pstmt_update.setString(6,  getPractitionerID());			    // AMD_PRACT_ID
			pstmt_update.setString(7,  login_by_id);		                //MODIFIED_BY_ID
			pstmt_update.setString(8,  login_at_ws_no);						//MODIFIED_AT_WS_NO
			pstmt_update.setString(9,  login_facility_id);					//MODIFIED_FACILITY_ID
			pstmt_update.setString(10, (String)record.get("ORDER_ID"));	    // ORDER_ID
		
	        result = pstmt_update.executeUpdate();
		    if (result>0) {
				map.put("result", new Boolean(true));
				map.put("message", getMessage(getLanguageId(),"RECORD_INSERTED","PH"));
			   	connection.commit();
			} 
			else {
				connection.rollback();
				System.err.println("Exception in update or_order_line... record="+record);
			}
			
		}catch(Exception e) {
			map.put("msgid", e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt_update);
				closeConnection(connection);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}		
 return map;
}

public ArrayList populateAllergyDetails(String generic_id,String patient_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		ArrayList details			= new ArrayList();
		try{
			connection				= getConnection() ;
			sql_query				= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT58");
			pstmt					= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,generic_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3, getLanguageId());
			pstmt.setString(4,generic_id);
			pstmt.setString(5,patient_id);
			/*pstmt.setString(6, getLanguageId());
			pstmt.setString(7,generic_id);
			pstmt.setString(8,patient_id);
			pstmt.setString(9, getLanguageId());*/

			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				HashMap AllergyDetails		= new HashMap();	
				AllergyDetails.put("ALLERGY_TYPE_CODE",resultSet.getString("ALLERGY_TYPE_CODE"));
				AllergyDetails.put("ALLERGIC_INDICATIONS",resultSet.getString("ALLERGIC_INDICATIONS"));
				AllergyDetails.put("REAC_DATE",resultSet.getString("REAC_DATE"));
				AllergyDetails.put("ALLERGY_ALERT_BY",checkForNull(resultSet.getString("ALLERGY_ALERT_BY")));// Added for RUT-CRF-0065.1 [IN:43255]
				AllergyDetails.put("CAUSATIVE_SUBSTANCE",checkForNull(resultSet.getString("CAUSATIVE_SUBSTANCE")));// Added for RUT-CRF-0065.1 [IN:43255]
				details.add(AllergyDetails);
			}

		 }catch ( Exception e ) {
				details.add("Error"+e);
                e.printStackTrace() ;

		} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){}
       }
		return details;
}

	public HashMap getAddDrugInfo(String drug_code) {
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		HashMap Drugdtls            = new HashMap(); 
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT5C"));
			pstmt.setString(1, drug_code);
			resultSet	= pstmt.executeQuery();

			while(resultSet.next()) {
				Drugdtls.put("IV_INGREDIENT_YN",resultSet.getString("IV_INGREDIENT_YN"));
				Drugdtls.put("IV_FLUID_YN",resultSet.getString("IV_FLUID_YN"));
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
			catch(Exception es) {}
		}
		return Drugdtls;
	}

	public void	chkequalityofDrugs(){
		HashMap drugdetail=(HashMap)drugDetails.get(0);
		String DrugCode=(String)drugdetail.get("DRUG_CODE");
		String FluidCode=(String)FluidDetails.get("DRUG_CODE");

		if(DrugCode.equals(FluidCode)){
			FluidDetails=null;
		}
	}

	public HashMap getDrugReasons(String order_id,String order_line_num,String ext_prod_id) {
	   	Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		HashMap Drugdtls            = new HashMap(); 
		String  extDbInteface		= getExternalDrugDataBaseInterface_yn();
		//String	sqlQry				= "";
		if (ext_prod_id ==  null)
			ext_prod_id = "";
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement("SELECT P.ALLERGY_OVERRIDE_REASON,P.DOSAGE_LIMIT_OVERRIDE_REASON,P.DUPLICATE_DRUG_OVERRIDE_REASON,P.INTERACTION_OVERRIDE_REASON,P.CONTRAIND_OVERRIDE_REASON,OP.ABUSE_DRUG_OVERRIDE_REASON FROM  PH_PATIENT_DRUG_PROFILE P,OR_ORDER_LINE_PH OP WHERE ORDER_ID=ORIG_ORDER_ID AND ORDER_LINE_NUM=ORIG_ORDER_LINE_NO  AND ORIG_ORDER_ID = ? AND ORIG_ORDER_LINE_NO = ?");
			

			pstmt.setString(1, order_id);
			pstmt.setString(2, order_line_num);
			resultSet	= pstmt.executeQuery();

			while(resultSet.next()) {
				if(extDbInteface.equals("Y") && !(ext_prod_id.equals(""))){
					Drugdtls.put("ALLERGY_OVERRIDE_REASON",resultSet.getString("ALLERGY_OVERRIDE_REASON"));
					Drugdtls.put("EXTERNAL_ALERGY_OVERRIDE_REASON",resultSet.getString("ALLERGY_OVERRIDE_REASON"));
					Drugdtls.put("DOSAGE_LIMIT_OVERRIDE_REASON",resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
					Drugdtls.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
					Drugdtls.put("DUPLICATE_DRUG_OVERRIDE_REASON",resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
					Drugdtls.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
					Drugdtls.put("INTERACTION_OVERRIDE_REASON",resultSet.getString("INTERACTION_OVERRIDE_REASON"));
					Drugdtls.put("CONTRAIND_OVERRIDE_REASON",resultSet.getString("CONTRAIND_OVERRIDE_REASON"));
				}
				else{
					Drugdtls.put("ALLERGY_OVERRIDE_REASON",resultSet.getString("ALLERGY_OVERRIDE_REASON"));
					Drugdtls.put("DOSAGE_LIMIT_OVERRIDE_REASON",resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
					Drugdtls.put("DUPLICATE_DRUG_OVERRIDE_REASON",resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
					
					Drugdtls.put("ABUSE_DRUG_OVERRIDE_REASON",resultSet.getString("ABUSE_DRUG_OVERRIDE_REASON"));
					
				}
			}
			//Added for IN:072715 start
			pstmt.clearBatch();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_REASON_CODE_SELECT"));
			pstmt.setString(1, order_id);
			pstmt.setString(2, order_line_num);
			resultSet	= pstmt.executeQuery();
			while(resultSet.next()) {
				Drugdtls.put("ALLERGY_REMARKS_CODE",resultSet.getString("ALLERGY_OVERRIDE_REASON_CODE"));
				Drugdtls.put("DOSE_REMARKS_CODE",resultSet.getString("DOSE_LIMIT_OVER_REASON_CODE"));
				Drugdtls.put("CURRENTRX_REMARKS_CODE",resultSet.getString("DUP_DRUG_OVERRIDE_REASON_CODE"));
			}
			//Added for IN:072715 end
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
		return Drugdtls;
	}

// for ammendnig  remarks 

	public ArrayList getPrescribedRemarks(String orig_order_id,String orig_order_line_no) {
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		
		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_SELECT7") ) ;		

			pstmt.setString(1,orig_order_id);
			pstmt.setString(2,orig_order_line_no);
			pstmt.setString(3, getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() )			{
				if((resultSet.getString("ORDER_LINE_FIELD_MNEMONIC")).equals("PRES_REMARKS")) {
					if(resultSet.getString("REMARK_DESC")!=null) {
						records.add(resultSet.getString("REMARK_DESC"));
					}
				} 
				else {
					if(resultSet.getString("ORDER_LINE_FIELD_VALUE")!=null) {
						records.add(resultSet.getString("ORDER_LINE_FIELD_VALUE"));
					}
				}
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}		
		return records;			
	}

	public HashMap releaseAmendCompoundRx(HashMap record){	

	    String order_id	 = (String)record.get("ORDER_ID");
		int noOfDrugs = Integer.parseInt((String)record.get("NO_OF_DRUGS"));

		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "");
		map.put("msgid", "");
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		PreparedStatement pstmt_select1	= null;
		PreparedStatement pstmt_select2	= null;
		PreparedStatement pstmt_select3	= null;

		PreparedStatement pstmt_insert	= null,pstmt_update_order_line_ph=null,pstmt_update_patient_drug_profile=null;
		PreparedStatement pstmt_update=null,pstmt_update_non_scheduled_drug	= null,pstmt_delete=null,pstmt_clob=null;
		CallableStatement cstmt_insert	= null;     
		ResultSet resultSet				= null;
		ArrayList drugDetails			= getDrugDetails();
		ArrayList drugRemarks			= getDrugRemarks();
		HashMap scheduleFreq			= getscheduleFrequency();

		String allergy_override_reason			= "";
		String duplicate_drug_override_reason	= "";
		String interaction_override_reason		= "";
		String contraind_override_reason		= "";
		String dosage_limit_override_reason		= "";
		HashMap drgDtls							= null;
		
		HashSet keyset=new HashSet(); //Added for Bru-HIMS-CRF-393_1.0-Start
	//	HashMap orderTypeDetails=new HashMap();  Removed for IN063877
		String order_type_code="";
		order_type_code		=(String)((HashMap)drugDetails.get(0)).get("ORDER_TYPE_CODE");
		keyset.add(order_type_code);
		setPrintOrdShtRuleInd(keyset,getPatientClass());		//Added for Bru-HIMS-CRF-393_1.0-End
		try{
 //	OR_ORDER
			connection	= getConnection() ;
			pstmt_insert	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE1"));
			pstmt_insert.setString(1, "6");
			pstmt_insert.setString(2, "");
			pstmt_insert.setString(3, login_by_id);
			pstmt_insert.setString(4, login_at_ws_no);
			pstmt_insert.setString(5, login_facility_id);
			pstmt_insert.setString(6, order_id);
			int result=0;
			try{
			    result			= pstmt_insert.executeUpdate();
			}
			catch(Exception e){
				result=0;
				connection.rollback();
				e.printStackTrace();
			}

			if(pstmt_insert != null){ closeStatement(pstmt_insert); }

// OR_ORDER_LINE
		if (result>0){ 
				
				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_COMP_PRESCRIPTION_AMEND1"));
				pstmt_insert.clearBatch();
				for(int j=1;j<=noOfDrugs;j++){

					pstmt_insert.setString(1, (String)record.get("DOSAGE"));        // QTY_VALUE
					pstmt_insert.setString(2, (String)record.get("FREQ_CODE"));  	// FREQ_CODE
					pstmt_insert.setString(3, (String)record.get("DURN_VALUE"));	// DURN_VALUE
					pstmt_insert.setString(4, (String)record.get("ORD_QTY"+j));	    // ORDER_QTY
					pstmt_insert.setString(5, (String)record.get("START_DATE"));	// START_DATE_TIME
					pstmt_insert.setString(6, (String)record.get("END_DATE"));		// END_DATE_TIME
					pstmt_insert.setString(7,  getPractitionerID());			    // AMD_PRACT_ID
					pstmt_insert.setString(8,  login_by_id);		                //MODIFIED_BY_ID
					pstmt_insert.setString(9,  login_at_ws_no);						//MODIFIED_AT_WS_NO
					pstmt_insert.setString(10, login_facility_id);					//MODIFIED_FACILITY_ID
					pstmt_insert.setString(11, (String)record.get("ORDER_ID"));	    // ORDER_ID
					pstmt_insert.setString(12, (j)+"");	    // ORDER_ID

					pstmt_insert.addBatch();
				}
				
			try{
				int[] batch_result = pstmt_insert.executeBatch();

				for (int i=0;i<batch_result.length;i++) {
					if(batch_result[i] < 0  && batch_result[i] != -2 ) {
						result = 0;
						connection.rollback();
						break;
					} else {
						result = 1;
					}
				}
				}catch(Exception e){
						result = 0;
					   e.printStackTrace();
				 }
			if(pstmt_insert != null){ closeStatement(pstmt_insert); }
		}

//OR_ORDER_LINE_PH
	   if (result>0) {
		   	
				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_COMP_PRESCRIPTION_AMEND2"));
				pstmt_insert.clearBatch();
				for(int j=1;j<=noOfDrugs;j++){
                  
						pstmt_insert.setString(1, (String)record.get("ORD_QTY"+j)); //PRES_QTY_VALUE
						pstmt_insert.setString(2, login_by_id);
					    pstmt_insert.setString(3, login_at_ws_no);
					    pstmt_insert.setString(4, login_facility_id);
						pstmt_insert.setString(5, order_id);
						pstmt_insert.setString(6, (j)+"");
						pstmt_insert.addBatch();
					
				}
				try{
				int[] batch_result = pstmt_insert.executeBatch();

				for (int i=0;i<batch_result.length;i++) {
					if(batch_result[i] < 0  && batch_result[i] != -2 ) {
						result = 0;
						connection.rollback();
						break;
					}
					else {
						result = 1;
					}
				}
				}catch(Exception e){
			        e.printStackTrace();
			   }
			if(pstmt_insert != null){ closeStatement(pstmt_insert); }
	   }
	 
 
	//PH_PATIENT_DRUG_PROFILE

	if(result>0){
				//pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_COMP_PRESCRIPTION_AMEND3"));
// update query modified we should change in repository 13/05/2009

				pstmt_insert =connection.prepareStatement("UPDATE PH_PATIENT_DRUG_PROFILE SET PRESCRIBED_QTY=?,FREQ_CODE=?,DURATION=?,DURN_TYPE=?,START_DATE=to_date(?, 'dd/mm/yyyy hh24:mi'),END_DATE=to_date(?, 'dd/mm/yyyy hh24:mi'),MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,DOSAGE_LIMIT_OVERRIDE_REASON=?,ALLERGY_OVERRIDE_REASON=?,DUPLICATE_DRUG_OVERRIDE_REASON=?,INTERACTION_OVERRIDE_REASON=?,CONTRAIND_OVERRIDE_REASON=? WHERE ORIG_ORDER_ID=? AND ORIG_ORDER_LINE_NO=?");
System.out.println("10943 drgDtls"+drgDtls);
				pstmt_insert.clearBatch();
				for(int j=1;j<=noOfDrugs;j++){

					allergy_override_reason			= "";
					duplicate_drug_override_reason	= "";
					interaction_override_reason		= "";
					contraind_override_reason		= "";
					dosage_limit_override_reason	= "";
					drgDtls							= null;

					 for(int drDtl = 1; drDtl<=drugDetails.size();drDtl++){
						drgDtls = (HashMap)drugDetails.get(drDtl-1);

						if(drgDtls.get("SRL_NO").equals(j+"")){
								
							if(((String)drgDtls.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN")).equals("Y")){
									allergy_override_reason = (String)drgDtls.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
							}else if(!((String)drgDtls.get("ALLERGY_REMARKS")).equals("")){
									allergy_override_reason = (String)drgDtls.get("ALLERGY_REMARKS"); //ALLERGY_OVERRIDE_REASON
							}else {
									allergy_override_reason =  "";
							}


							if(((String)drgDtls.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
									dosage_limit_override_reason = (String)drgDtls.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");
							}else if(!((String)drgDtls.get("DOSE_REMARKS")).equals("")){
									dosage_limit_override_reason = (String)drgDtls.get("DOSE_REMARKS"); //DOSAGE_LIMIT_OVERRIDE_REASON			
							}else{
									dosage_limit_override_reason = "";
							}

							if(((String)drgDtls.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
									duplicate_drug_override_reason = (String)drgDtls.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
							}else if(!((String)drgDtls.get("CURRENTRX_REMARKS")).equals("")){
									duplicate_drug_override_reason = (String)drgDtls.get("CURRENTRX_REMARKS"); //DUPLICATE_DRUG_OVERRIDE_REASON	
							}else{
									duplicate_drug_override_reason = "";
							}

//							allergy_override_reason			= (String)drgDtls.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
//							duplicate_drug_override_reason	= (String)drgDtls.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
							interaction_override_reason		= (String)drgDtls.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
							contraind_override_reason		= (String)drgDtls.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
							break;
						}
					 }
					pstmt_insert.setString(1, (String)record.get("ORD_QTY"+j)); //PRES_QTY_VALUE
					pstmt_insert.setString(2, (String)record.get("FREQ_CODE")); //FREQ_CODE
					pstmt_insert.setString(3, (String)record.get("DURN_VALUE"));//DURATION 
					pstmt_insert.setString(4, (String)record.get("DURN_TYPE"));//DURATION 
					pstmt_insert.setString(5, (String)record.get("START_DATE"));//START_DATE
					pstmt_insert.setString(6, (String)record.get("END_DATE"));//END_DATE
					pstmt_insert.setString(7, login_by_id);//MODIFIED_BY_ID
					pstmt_insert.setString(8, login_at_ws_no);//MODIFIED_AT_WS_NO
					pstmt_insert.setString(9, login_facility_id);//MODIFIED_FACILITY_ID
//dosage_limit_override_reason	=	(String)drug_dtls.get("DOSAGE_LIMIT_OVERRIDE_REASON");
					pstmt_insert.setString(10, dosage_limit_override_reason);

					pstmt_insert.setString(11, allergy_override_reason);
					pstmt_insert.setString(12, duplicate_drug_override_reason);
					pstmt_insert.setString(13, interaction_override_reason);
					pstmt_insert.setString(14, contraind_override_reason);

					pstmt_insert.setString(15, (String)record.get("ORDER_ID"));//ORG_ORDER_ID
					pstmt_insert.setString(16,(j)+""); 	

					pstmt_insert.addBatch();
					
				}
				try{
				int[] batch_result = pstmt_insert.executeBatch();

				for (int i=0;i<batch_result.length;i++) {
					if(batch_result[i] < 0  && batch_result[i] != -2 ) {
						result = 0;
						connection.rollback();
						break;
					} else {
						result = 1;
					}
				}
				}catch(Exception e){
						result = 0;
					   e.printStackTrace();
				}
			if(pstmt_insert != null){ closeStatement(pstmt_insert); }	
			}

 //OR_ORDER_COMMENT
if (result>0) {
	 			String action_seq_num		= "";

				pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56"));
				pstmt_select.setString(1, order_id);
				resultSet		= pstmt_select.executeQuery();

				if(resultSet.next()) {
					action_seq_num = resultSet.getString(1);
				}

				if(resultSet	!= null){ closeResultSet( resultSet ); }
				if(pstmt_select != null){ closeStatement(pstmt_select); }

				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5"));
				pstmt_insert.setString(1, order_id);
				pstmt_insert.setString(2, action_seq_num);
				pstmt_insert.setString(3, login_by_id);
				pstmt_insert.setString(4, login_at_ws_no);
				pstmt_insert.setString(5, login_facility_id);
				pstmt_insert.setString(6, login_by_id);
				pstmt_insert.setString(7, login_at_ws_no);
				pstmt_insert.setString(8, login_facility_id);
				result = pstmt_insert.executeUpdate();
				if(pstmt_insert != null){ closeStatement(pstmt_insert); }

				if(result>0){
				
					pstmt_clob		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57"));
					pstmt_clob.setString(1,order_id);
					pstmt_clob.setString(2,action_seq_num);

					ResultSet rset_clob =pstmt_clob.executeQuery();
					if(rset_clob!=null){
						while(rset_clob.next()){
						    	Clob clb 			= (Clob) rset_clob.getClob(1);
							BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
							//bw.write(order_comment,0,order_comment.length());
							bw.flush();
							bw.close();
						}
					}					
				if(rset_clob	!= null){ closeResultSet( rset_clob ); }
				if(pstmt_clob != null){ closeStatement(pstmt_clob); }
				}

		}

//OR_ORDER_LINE_FIELD_VALUES

			if (result>0) {

				pstmt_delete=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_DELETE_FIELD_VALUES_A"));
				pstmt_delete.setString(1, order_id);
				try{
				    pstmt_delete.executeUpdate();
				}
				catch(Exception e){
			        e.printStackTrace();
				}
				if(pstmt_delete != null){ 
					closeStatement(pstmt_delete); 
				}
				
	            boolean enter_loop = false;
				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7"));
				pstmt_insert.clearBatch();
				if(drugRemarks.size()>0) {
					int order_format_count	= 0;
					for (int i=0;i<drugRemarks.size();i++ ) {
						HashMap DrugValues = (HashMap)drugRemarks.get(i);

						String total_seq	= (String)DrugValues.get("order_format_count");
						order_format_count	= Integer.parseInt(total_seq);

						for(int k=0;k<order_format_count;k++) {
							enter_loop = true;
							pstmt_insert.setString(1, order_id);
							pstmt_insert.setString(2, "" + (i+1));
							pstmt_insert.setString(3, "S");
							pstmt_insert.setString(4, "" + (k+1));
							pstmt_insert.setString(5, (String)DrugValues.get("field_mnemonic"+k));
							pstmt_insert.setString(6, (String)DrugValues.get("field_type"+k));
							pstmt_insert.setString(7, (String)DrugValues.get("label_text"+k));
							pstmt_insert.setString(8, (String)DrugValues.get("field_values"+k));
							pstmt_insert.setString(9, "");
							pstmt_insert.setString(10, "");
							pstmt_insert.setString(11, (String)DrugValues.get("accept_option"+k));

							pstmt_insert.setString(12, login_by_id);
							pstmt_insert.setString(13, login_at_ws_no);
							pstmt_insert.setString(14, login_facility_id);
							pstmt_insert.setString(15, login_by_id);
							pstmt_insert.setString(16, login_at_ws_no);
							pstmt_insert.setString(17, login_facility_id);
							pstmt_insert.addBatch();
						}
					}
					if(enter_loop) {
						int[] batch_result1 = pstmt_insert.executeBatch();
						for (int i=0;i<batch_result1.length;i++ ) {
							if (batch_result1[i]<0  && batch_result1[i] != -2) {
								result=0;
								break;
							}
							else{
								result=1;
							}
						}
					} 
					else {
						result=1;
					}
				} 
				else {
					result=1;
				}
				if(pstmt_insert	!= null) {  
					closeStatement( pstmt_insert );
				}
		  }
// FREQUENCY VALUES ....
			if (result>0) {
				boolean freq_values_found	= false;
				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7"));


				ArrayList frequencyValues = new ArrayList();

                HashMap drugDetails1=new HashMap();
                drugDetails1 = (HashMap)drugDetails.get(0);
			      
		        if (scheduleFreq.size()>0) {
					 if (scheduleFreq.containsKey((String)drugDetails1.get("DRUG_CODE")))
					   	frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails1.get("DRUG_CODE"));
			    	}

				if (frequencyValues.size()>0) {
					for(int n=0;n<frequencyValues.size();n++) {
						freq_values_found	= true;
						int seqNo			= 200;
						seqNo				= seqNo + n;

						HashMap data		= (HashMap)frequencyValues.get(n);
						String admin_time	= (String)data.get("admin_time");
						String admin_qty	= (String)data.get("admin_qty");
						String durn_desc	= "";
             
						pstmt_insert.setString(1, order_id);
						pstmt_insert.setString(2, "1");
						pstmt_insert.setString(3, "S");
						pstmt_insert.setString(4, seqNo + "");
						pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
						pstmt_insert.setString(6, "C");
						pstmt_insert.setString(7, "D");
						pstmt_insert.setString(8, admin_time);
						pstmt_insert.setString(9, admin_qty);
						pstmt_insert.setString(10, durn_desc);
						pstmt_insert.setString(11, "O");
						pstmt_insert.setString(12, login_by_id);
						pstmt_insert.setString(13, login_at_ws_no);
						pstmt_insert.setString(14, login_facility_id);
						pstmt_insert.setString(15, login_by_id);
						pstmt_insert.setString(16, login_at_ws_no);
						pstmt_insert.setString(17, login_facility_id);
						pstmt_insert.addBatch();
					}
				}

				if (freq_values_found) {
					try{
					int[] batch_result = pstmt_insert.executeBatch();
						

					for (int i=0;i<batch_result.length;i++ ) {
						if (batch_result[i]<0  && batch_result[i] != -2) {
							result=0;
							break;
						}
						else {
							result=1;
						}
					}
                    }catch(Exception e)  
					{
					 e.printStackTrace();
					}
				}
				else {
					result=1;
				}
				if(pstmt_insert != null){ closeStatement(pstmt_insert); }
			}


 //PH_MEDN_ADMIN
/*
if(result>0){
			boolean freq_values_found = false;
            pstmt_delete=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_DELETE_MEDN_ADMIN"));
			pstmt_delete.setString(1, order_id);
			pstmt_delete.setString(2, login_facility_id);
			pstmt_delete.executeUpdate();
			
			pstmt_insert.clearBatch();
			
			String med_admin_reqd_yn			=	"";
			String verf_reqd_bef_med_admin_yn	=	"";
			ArrayList unique_drugs				= new ArrayList(4);
			ArrayList frequencyValues			= null;
			int dosage_seqNo					=	0;
			pstmt_select		=	null;
		
             
			pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT8"));
			pstmt_select.setString(1, login_facility_id);
			resultSet			= pstmt_select.executeQuery();
           	if(resultSet.next()) {
				med_admin_reqd_yn	=	(resultSet.getString("MED_ADMIN_REQD_YN"));
			}

           	if(med_admin_reqd_yn == null){med_admin_reqd_yn="";}
			resultSet		= null;
			pstmt_select	=	null;
			pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT25A"));
			pstmt_select.setString(1, login_facility_id);
			resultSet		= pstmt_select.executeQuery();
			if (resultSet.next()) {
				verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
			}

			pstmt_select		=	null;
			pstmt_select		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT2"));

			pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT2"));

			pstmt_select1 = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT24A"));
		
			for(int i=0; i<drugDetails.size(); i++ ) {
				record		=	(HashMap)drugDetails.get(i);		

//				order_id		=	(String)record.get("ORDER_ID");
				if( (patient_class.equals("IP") || patient_class.equals("EM"))&& med_admin_reqd_yn.equals("Y")) {
							
				if(!unique_drugs.contains((String)record.get("DRUG_CODE"))) {
						unique_drugs.add((String)record.get("DRUG_CODE"));
						dosage_seqNo	=	0;
					}
			   pstmt_select.setString(1, (String)record.get("DRUG_CODE"));
				resultSet	= pstmt_select.executeQuery();
				if (resultSet.next()) {
					order_uom	=	(resultSet.getString("STOCK_UOM"));
				}

				if (scheduleFreq.size()>0) {
					//debug += "\nfr_drug_code : " + (String)fluidDetails.get("DRUG_CODE");

					 if (scheduleFreq.containsKey((String)record.get("DRUG_CODE")))
					   	frequencyValues = (ArrayList)scheduleFreq.get((String)record.get("DRUG_CODE"));
			    }

				for (int m=0; m<fr_durn_value; m++) {
				   if (frequencyValues.size() > 0) {

					   freq_values_found = true;
					   for (int n=0; n<frequencyValues.size(); n++) {
					   				count		=	0;
					    			dosage_seqNo		= 1;
									dosage_seqNo			= dosage_seqNo+n;
									HashMap data			= (HashMap)frequencyValues.get(n);
									String admin_time		= (String)data.get("admin_time");
								//	String admin_qty		= (String)data.get("admin_qty");
									String sch_date_time	= "";
									//String start_date_time =(String)record.get("START_DATE");
//System.err.println("start_date_time====1====="+start_date_time);
									//debug += "dosage_type : "+dosage_type;
									//debug += "qty_unit : "+qty_unit;
									//debug += "strength_value : "+strength_value;
									//debug += "strength_uom : "+strength_uom;
									//debug += "pres_base_uom : "+pres_base_uom;

									resultSet		= null;
									pstmt_select1.setString(1, start_date_time);
									pstmt_select1.setString(2, ""+m);
									pstmt_select1.setString(3, admin_time);
									resultSet = pstmt_select1.executeQuery();

									if (resultSet.next()) {
										sch_date_time = resultSet.getString(1);
									}
//System.err.println("sch_date_time ---"+m+" --n-- "+n+" -- "+sch_date_time);
					pstmt_insert.setString(++count, login_facility_id);	//FACILITY_ID
					pstmt_insert.setString(++count, getEncId());		//ENCOUNTER_ID
					pstmt_insert.setString(++count, sch_date_time);			//SCH_DATE_TIME
					pstmt_insert.setString(++count, (String)record.get("DRUG_CODE")); //ORD_DRUG_CODE
					pstmt_insert.setString(++count, dosage_seqNo+ "");				// DOSAGE SEQ No
					pstmt_insert.setString(++count, order_id);				//ORDER_ID
					pstmt_insert.setString(++count, (i+1)+"");				// ORDER LINE NUM
					pstmt_insert.setString(++count, getPatId());				//PATIENT_ID
					pstmt_insert.setString(++count, pract_id);				//PRACT_ID
					pstmt_insert.setString(++count, "Y");					//IV_ADMIN_YN
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count,(String)record.get("QTY_VALUE"));			//SCH_DOSAGE_QTY
					pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));				//SCH_DOSAGE_UOM_CODE
					pstmt_insert.setString(++count, (String)record.get("STRENGTH_VALUE")); //SCH_STRENGTH
					pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM")); //SCH_STRENGTH_UOM
					pstmt_insert.setString(++count, (String)record.get("ROUTE_CODE"));   //SCH_ROUTE_CODE 
					pstmt_insert.setString(++count, ""); //SCH_INFUSION_RATE
					pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));		//SCH_INFUSION_VOL_STR_UNIT
					pstmt_insert.setString(++count, "H");  //SCH_INFUSION_PER_UNIT
					pstmt_insert.setString(++count, verf_reqd_bef_med_admin_yn);
					pstmt_insert.setString(++count, login_by_id);
					pstmt_insert.setString(++count, login_at_ws_no);
					pstmt_insert.setString(++count, login_facility_id);
					pstmt_insert.setString(++count, login_by_id);
					pstmt_insert.setString(++count, login_at_ws_no);
					pstmt_insert.setString(++count, login_facility_id);
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, "H");			//SCH_INFUSION_PERIOD_UNIT
					pstmt_insert.addBatch();
					
					}
	
				   }
				 }
				}
			}

			int[] batch_result5 = pstmt_insert.executeBatch();
			for (int i=0;i<batch_result5.length; i++ ) {
				if (batch_result5[i]<0  && batch_result5[i] != -2) {
						result = 0;
						pstmt_insert.cancel();
						throw new Exception("PH Medn admin Failed");
				}else{
						result = 1;
				}
			}

	/*
	System.err.println("Phmednadmin --");
				    String order_uom="";
					boolean freq_values_found = false;
                    pstmt_delete=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_DELETE_MEDN_ADMIN"));
					pstmt_delete.setString(1, order_id);
					pstmt_delete.setString(2, login_facility_id);
					pstmt_delete.executeUpdate();
					
					pstmt_insert.clearBatch();

					//debug += "med_admin_reqd_yn : " + med_admin_reqd_yn;
					//debug += "patient_class : " + patient_class;

				
			String med_admin_reqd_yn			=	"";
			String verf_reqd_bef_med_admin_yn	=	"";
			ArrayList unique_drugs				= new ArrayList(4);
			int dosage_seqNo					=	0;
			pstmt_select		=	null;
             
			pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT8"));
			pstmt_select.setString(1, login_facility_id);
			resultSet			= pstmt_select.executeQuery();
           	if(resultSet.next()) {
				med_admin_reqd_yn	=	(resultSet.getString("MED_ADMIN_REQD_YN"));
			}
           	if(med_admin_reqd_yn == null){med_admin_reqd_yn="";}
			resultSet		= null;
			pstmt_select	=	null;
			pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT25A"));
			pstmt_select.setString(1, login_facility_id);
			resultSet		= pstmt_select.executeQuery();
			if (resultSet.next()) {
				verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
			}

			pstmt_select		=	null;
			pstmt_select		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT2"));

			pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT2"));
			
			for(int i=0; i<drugDetails.size(); i++ ) {
				record		=	(HashMap)drugDetails.get(i);		
				int count		=	0;
//				order_id		=	(String)record.get("ORDER_ID");
				if( (patient_class.equals("IP") || patient_class.equals("EM"))&& med_admin_reqd_yn.equals("Y")) {
					int fr_durn_value	= Integer.parseInt(record.get("DURN_VALUE").toString());		
					if(!unique_drugs.contains((String)record.get("DRUG_CODE"))) {
						unique_drugs.add((String)record.get("DRUG_CODE"));
						dosage_seqNo	=	0;
					}
			   pstmt_select.setString(1, (String)record.get("DRUG_CODE"));
				resultSet	= pstmt_select.executeQuery();
				if (resultSet.next()) {
					order_uom	=	(resultSet.getString("STOCK_UOM"));
				}


					pstmt_insert.setString(++count, login_facility_id);	//FACILITY_ID
					pstmt_insert.setString(++count, getEncId());		//ENCOUNTER_ID
					pstmt_insert.setString(++count, (String)record.get("START_DATE"));			//SCH_DATE_TIME
					pstmt_insert.setString(++count, (String)record.get("DRUG_CODE")); //ORD_DRUG_CODE
					pstmt_insert.setString(++count, ++dosage_seqNo+ "");				// DOSAGE SEQ No
					pstmt_insert.setString(++count, order_id);				//ORDER_ID
					pstmt_insert.setString(++count, (i+1)+"");				// ORDER LINE NUM
					pstmt_insert.setString(++count, getPatId());				//PATIENT_ID
					pstmt_insert.setString(++count, pract_id);				//PRACT_ID
					pstmt_insert.setString(++count, "Y");					//IV_ADMIN_YN
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count,(String)record.get("QTY_VALUE"));			//SCH_DOSAGE_QTY
					pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));				//SCH_DOSAGE_UOM_CODE
					pstmt_insert.setString(++count, (String)record.get("STRENGTH_VALUE")); //SCH_STRENGTH
					pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM")); //SCH_STRENGTH_UOM
					pstmt_insert.setString(++count, (String)record.get("ROUTE_CODE"));   //SCH_ROUTE_CODE 
					pstmt_insert.setString(++count, ""); //SCH_INFUSION_RATE
					pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM")); //SCH_INFUSION_VOL_STR_UNIT
					pstmt_insert.setString(++count, "H");  //SCH_INFUSION_PER_UNIT
					pstmt_insert.setString(++count, verf_reqd_bef_med_admin_yn);
					pstmt_insert.setString(++count, login_by_id);
					pstmt_insert.setString(++count, login_at_ws_no);
					pstmt_insert.setString(++count, login_facility_id);
					pstmt_insert.setString(++count, login_by_id);
					pstmt_insert.setString(++count, login_at_ws_no);
					pstmt_insert.setString(++count, login_facility_id);
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, "H");			//SCH_INFUSION_PERIOD_UNIT
					pstmt_insert.addBatch();
				}
			}

			int[] batch_result5 = pstmt_insert.executeBatch();
			for (int i=0;i<batch_result5.length; i++ ) {
				if (batch_result5[i]<0  && batch_result5[i] != -2) {
						result = 0;
						pstmt_insert.cancel();
						throw new Exception("PH Medn admin Failed");
				}else{
						result = 1;
				}
			}
*/
//	}
		map.put("result", new Boolean(true));
		map.put("msgid", "RECORD_INSERTED");
		connection.commit();
  
    }
		catch(Exception e) {
			try {
				connection.rollback();
		        e.printStackTrace();
			}
			catch (Exception ee) {
				map.put("msgid", ee.getMessage());
			}
			map.put("msgid", e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resultSet );
				closeStatement(pstmt_insert);
				closeStatement(pstmt_select);
				closeStatement(pstmt_select1);
				closeStatement(pstmt_select2);
				closeStatement(pstmt_select3);
				closeStatement(cstmt_insert);				
				closeStatement(pstmt_update);
				closeStatement(pstmt_update_non_scheduled_drug);
				closeStatement(pstmt_delete);
				closeStatement(pstmt_clob);
				closeStatement(pstmt_update_order_line_ph);
				closeStatement(pstmt_update_patient_drug_profile);
				closeConnection( connection );
				
			}
			catch(Exception fe) {
				fe.printStackTrace();
			}
		}

		return map;
	}

// getOrderIdForTDMDtls(String patient_id,String drug_code) returns the latest order id for which TDM is registered.
public String getOrderIdForTDMDtls(String patient_id,String drug_code)	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String	order_id		= "";		
		
		try{
		connection			= getConnection() ;
		pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT100") ) ;
		pstmt.setString(1,patient_id);
		pstmt.setString(2,drug_code);
		resultSet	= pstmt.executeQuery();
		if ( resultSet != null && resultSet.next() ) {
				order_id	=	resultSet.getString("ORDER_ID");
				
		}
		
 }catch(Exception e){
			 e.printStackTrace() ;	
 }finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				 es.printStackTrace() ;
			}
		}
return order_id;
}

	public ArrayList getIvLegends() {
		Connection connection	= null;
        PreparedStatement pstmt = null;
        ResultSet resultSet		= null;
		ArrayList ivLegends		= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT127"));
			pstmt.setString(1, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				ivLegends.add(checkForNull(resultSet.getString("IV_DRUG_FLUID_CONTINUOUS_LG")));
				ivLegends.add(checkForNull(resultSet.getString("IV_WITHOUT_ADDITIVES_LG")));
				ivLegends.add(checkForNull(resultSet.getString("IV_DRUG_FLUID_INTERMITTENT_LG")));
			}
		}
		catch (Exception e) {
			ivLegends.add(e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return ivLegends;
	}
// function will return the common compatible fluids for the selected Ingredients at a given time
	public HashMap getCompatibleFluids(){
		Connection connection	= null;
        PreparedStatement pstmt = null;
        ResultSet resultSet		= null;
		HashMap comp_flds = new HashMap();

		try {
			connection	= getConnection();
//			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT127"));
			pstmt		= connection.prepareStatement("SELECT ");
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
//				ivLegends.add(checkForNull(resultSet.getString("IV_DRUG_FLUID_CONTINUOUS_LG")));
//				ivLegends.add(checkForNull(resultSet.getString("IV_WITHOUT_ADDITIVES_LG")));
//				ivLegends.add(checkForNull(resultSet.getString("IV_DRUG_FLUID_INTERMITTENT_LG")));
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
			catch(Exception es) {}
		}
		return comp_flds;
	}

	public ArrayList getDrugPrices(String drugCode,String qty_value){
	
		Connection connection	= null;
		CallableStatement cstmt	= null;
		ArrayList drug_price_values = new ArrayList();

		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call GET_CHARGE_DTLS_MAT_ITEM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			cstmt.setString(1, login_facility_id);
			cstmt.setString(2, "PH");
			cstmt.setString(3, "I");
			cstmt.setString(4, patient_id);
			cstmt.setString(5, encounter_id);
			cstmt.setString(6, encounter_id);
			cstmt.setString(7, "");
			cstmt.setString(8, "");
			cstmt.setString(9, "SAL");
			cstmt.setString(10, getOrderDate());
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.registerOutParameter(12, Types.VARCHAR); 
			cstmt.registerOutParameter(13, Types.VARCHAR); 
			cstmt.registerOutParameter(14, Types.VARCHAR); 
			cstmt.setString(15, drugCode); 
			cstmt.registerOutParameter(16, Types.VARCHAR);
			cstmt.registerOutParameter(17, Types.VARCHAR); 
			cstmt.setString(18, "S"); 
			cstmt.registerOutParameter(19, Types.VARCHAR);
			cstmt.setString(20, qty_value); 
			cstmt.setString(21, "");
			cstmt.registerOutParameter(22, Types.VARCHAR);
			cstmt.setString(23, "");
			cstmt.setString(24, "");
			cstmt.setString(25, "");
			cstmt.setString(26, "");
			cstmt.setString(27, "");
			cstmt.registerOutParameter(28, Types.VARCHAR);
			cstmt.registerOutParameter(29, Types.VARCHAR);
			cstmt.registerOutParameter(30, Types.VARCHAR);
			cstmt.registerOutParameter(31, Types.VARCHAR);
			cstmt.registerOutParameter(32, Types.VARCHAR);
			cstmt.registerOutParameter(33, Types.VARCHAR);
			cstmt.registerOutParameter(34, Types.VARCHAR);
			cstmt.registerOutParameter(35, Types.VARCHAR);
			cstmt.registerOutParameter(36, Types.VARCHAR);
			cstmt.registerOutParameter(37, Types.VARCHAR);
			cstmt.registerOutParameter(38, Types.VARCHAR);
			cstmt.registerOutParameter(39, Types.VARCHAR);
			cstmt.registerOutParameter(40, Types.VARCHAR);
			cstmt.registerOutParameter(41, Types.VARCHAR);
			cstmt.registerOutParameter(42, Types.VARCHAR);
			cstmt.registerOutParameter(43, Types.VARCHAR);
			cstmt.registerOutParameter(44, Types.VARCHAR);
			cstmt.registerOutParameter(45, Types.VARCHAR);
			cstmt.setString(46, "");
			cstmt.setString(47, "");
			cstmt.setString(48, "");
			cstmt.registerOutParameter(49, Types.VARCHAR);
			cstmt.registerOutParameter(50, Types.VARCHAR);
			cstmt.registerOutParameter(51, Types.VARCHAR);
			cstmt.setString(52, "Y");
			cstmt.setString(53, "Y");
			cstmt.registerOutParameter(54, Types.VARCHAR);
			cstmt.registerOutParameter(55, Types.VARCHAR);
			cstmt.registerOutParameter(56, Types.VARCHAR);

			cstmt.execute();

			drug_price_values.add(cstmt.getString(34));
			drug_price_values.add(cstmt.getString(45));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return drug_price_values;
	}

	public ArrayList getOrderDispenseLocation(String location_type,String location_code,String take_home_medication,String priority,String iv_prep_yn,String drug_code,String patient_id,String encounter_id) {   // drug_code - optional parameter added to get Dispense Location @ IV-Fluid Drug level Bru-HIMS-CRF-347 [IN:037862] 
		System.out.println("getOrderDispenseLocation");  //ADDED FOR NMC-JD-CRF-0063
		Connection connection	= null;
        CallableStatement cstmt	= null;
        ResultSet resultSet		= null;
		ArrayList disp_locn		= new ArrayList();
		System.out.println("getTakeHomeMedicationOp: "+getTakeHomeMedicationOp());//ADDED FOR NMC-JD-CRF-0063
		System.out.println("take_home_medication: "+take_home_medication); 
		System.out.println("getopDischmed: "+getOpDischMedInd());
		//added for NMC-JD-CRF-0063
		if(getOpDischMedInd()==null || getOpDischMedInd().equals("")){
			setOpDischMedInd("N"); 
		}
			System.out.println("getopDischmed: "+getOpDischMedInd());//added for NMC-JD-CRF-0063
		if(getTakeHomeMedicationOp()!=null && !getTakeHomeMedicationOp().equals("") && getTakeHomeMedicationOp().equals("Y") && getOpDischMedInd()!=null && !getOpDischMedInd().equals("") && getOpDischMedInd().equals("Y")){
			take_home_medication = "Y"; 
		}//END
		//System.out.println("getTakeHomeMedicationOp: "+getTakeHomeMedicationOp());
		System.out.println("take_home_medication: "+take_home_medication); 
		System.out.println("getopDischmed: "+getOpDischMedInd());
 		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call Ph_Ret_Spl_Ord_Disp_Locn(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");  // added for Bru-HIMS-CRF-347 [IN:037862],NMC-JD-CRF-0063
			cstmt.setString(1, login_facility_id);
			cstmt.setString(2, location_type);
			cstmt.setString(3, location_code);
			cstmt.setString(4, take_home_medication);
			cstmt.setString(5, priority);
			cstmt.setString(6, iv_prep_yn);	
			cstmt.setString(7, getLanguageId());
			
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.setString(12,drug_code);//added for MMS-QH-CRF-0048 [IN:037704]
			cstmt.setString(13,patient_id);//added for MMS-QH-CRF-0048 [IN:037704]
			cstmt.setString(14,encounter_id);//added for MMS-QH-CRF-0048 [IN:037704]
			cstmt.setString(15,getOpDischMedInd());//added for NMC-JD-CRF-0063
			cstmt.execute();

			disp_locn.add(cstmt.getString(8)==null?"":cstmt.getString(8));
			disp_locn.add(cstmt.getString(9)==null?"":cstmt.getString(9));
			disp_locn.add(cstmt.getString(10)==null?"":cstmt.getString(10));
			disp_locn.add(cstmt.getString(11)==null?"":cstmt.getString(11));
			System.out.println("disp_locn: "+disp_locn);  //added for NMC-JD-CRF-0063
//			String durn_list	= cstmt.getString(4);
			
			/*if(durn_list==null)
				durn_list	=	"";
			StringTokenizer st	= new StringTokenizer(durn_list, "|");
			while(st.hasMoreTokens()) {
				durnList.add(st.nextToken());
			}*/
		}
		catch (Exception e) {
			disp_locn.add(e.toString());
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return disp_locn;
	}
//*********************** ends *********************

public int getADRCount(String patient_id,String drug_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		int count					= 0;
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT102")) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,drug_code);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				count = resultSet.getInt("count");			
			}
			
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace();
			}
        }
		return count;
	}
	public void setBillingDetail(HashMap drugDetails, String episode_type, String patient_id, String encounter_id, String drug_code, String ordered_qty,String discharge_yn){
		Connection connection       = null ;
		CallableStatement cstmt		= null ;
		PreparedStatement pstmt		= null;
		ResultSet rsDecimalPlace	= null;
		int decimal_place			= 0;
		String decimalFormatString	= "#0";
		String order_Date			= getOrderDate()+":00";
		/*if(!getLanguageId().equals("en")){
			order_Date= com.ehis.util.DateUtils.convertDate(order_Date,"DMYHMS",getLanguageId(),"en");
		}		
System.err.println("@@10660==order date == "+order_Date);*/
		String item_code			= (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");
		String episode_id			= "";
		String visit_id				= "";
		String total_charge_amt		= "";
		String patient_payable_amt	= "";
		String approval_reqd_yn		= "";
		String override_allowed_yn	= "";
		String bl_included_IE		= "";
		String error_code			= "";		 
		String sys_message_id		= "";	
		String error_text			= "";
		String billable_item_yn     = "";
		String bl_incl_excl_override_value = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");
		String overriden_action_reason = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");
		String gross_amt      = ""; // Added for ML-BRU-CRF-0469 [IN:065426]
			//callin billing procedure
		try{
			connection = getConnection() ;
			if(encounter_id!= null && !encounter_id.equals("")){
				episode_id = encounter_id;
				if(episode_type.equals("O")||episode_type.equals("E")){
					episode_id = encounter_id.substring(0,(encounter_id.length()-4));
					visit_id = encounter_id.substring(encounter_id.length()-4);
				}
			}
          billable_item_yn  = (String)getBillableItemYN(item_code)==null?"N":(String)getBillableItemYN(item_code);

          if(billable_item_yn.equals("Y")){
					cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?,?)}");
	//System.err.println("=login_facility_id===="+login_facility_id+"==episode_type==="+episode_type+"==patient_id===="+patient_id+"=episode_id===="+episode_id+"==visit_id==="+visit_id+"==order_Date===="+order_Date+"===item_code===="+item_code+"=====ordered_qty====="+ordered_qty+"===bl_incl_excl_override_value====="+bl_incl_excl_override_value+"==overriden_action_reason====="+overriden_action_reason);
					cstmt.setString( 1, login_facility_id);
					cstmt.setString( 2, "PH");	//module id
					cstmt.setString( 3, "");	//
					cstmt.setString( 4, "");	//
					cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
					cstmt.setString( 6, patient_id); //patient_id
					cstmt.setString( 7, episode_id);  //episode_id
					cstmt.setString( 8, visit_id);  //p_visit_id  
					cstmt.setString( 9, null); //p_dummy1 - null
					cstmt.setString( 10, null); //p_dummy12 - null
					cstmt.setString( 11, "SAL"); //p_transaction_type
					cstmt.setString( 12, order_Date); //p_charge_date_time	--Service Data and time
					cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
					cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
					cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
					cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null

					cstmt.setString( 17, item_code);  //p_item_code

					cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
					cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 

					cstmt.setString( 20, "S");  //p_serv_panel_ind

					cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 

					cstmt.setString( 22,ordered_qty );  //qty served
					cstmt.setString( 23, null);  //p_charge_amt  

					cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost

					cstmt.setString( 25,null );  //p_store_code -- Store Code from where issued
					cstmt.setString( 26, null);  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
					cstmt.setString( 27,null );  //p_oth_disc_perc if any other manual discount is given from transaction
					cstmt.setString( 28, null);  //p_source_doc_ref		null for Sale
					cstmt.setString( 29,null );  //p_source_doc_ref_line	null for Sale

					cstmt.registerOutParameter(30, Types.NUMERIC ); //p_base_qty
					cstmt.registerOutParameter(31, Types.NUMERIC ); //p_base_rate
					cstmt.registerOutParameter(32, Types.NUMERIC ); //p_addl_factor
					cstmt.registerOutParameter(33, Types.NUMERIC ); //p_base_charge_amt       
					cstmt.registerOutParameter(34, Types.NUMERIC ); //p_GROSS_CHARGE_AMT      
					cstmt.registerOutParameter(35, Types.NUMERIC ); //p_DISC_AMT              
					cstmt.registerOutParameter(36, Types.NUMERIC ); //p_NET_CHARGE_AMT     --- Total Charge Amt   
					cstmt.registerOutParameter(37, Types.NUMERIC ); //p_disc_perc             
					cstmt.registerOutParameter(38, Types.NUMERIC ); //p_PAT_GROSS_CHARGE_AMT  
					cstmt.registerOutParameter(39, Types.NUMERIC ); //p_PAT_DISC_AMT          
					cstmt.registerOutParameter(40, Types.NUMERIC ); //P_PAT_NET_CHARGE_AMT   --- Patient Payable Amt 
					cstmt.registerOutParameter(41, Types.NUMERIC ); //p_CUST_GROSS_CHARGE_AMT 
					cstmt.registerOutParameter(42, Types.NUMERIC ); //p_CUST_DISC_AMT         
					cstmt.registerOutParameter(43, Types.NUMERIC ); //p_CUST_NET_CHARGE_AMT   
					cstmt.registerOutParameter(44, Types.VARCHAR ); //p_SPLIT_IND             
					cstmt.registerOutParameter(45, Types.NUMERIC ); //p_curr_availed          
					cstmt.registerOutParameter(46, Types.VARCHAR ); //p_credit_auth_ref       
					cstmt.registerOutParameter(47, Types.VARCHAR ); //P_PAT_PAID_AMT --- Patient Paid Amt

					cstmt.setString( 48,null );  //p_dummy4 (IN OUT )
					cstmt.setString( 49, null);  //p_batch_prices  (IN OUT )
					
					cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
					cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
					cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
					cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?
					if(bl_incl_excl_override_value.equals("SEL")){
						cstmt.setString( 54,"" );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
					}else{
						cstmt.setString( 54,bl_incl_excl_override_value );
					}
					cstmt.setString( 55, overriden_action_reason);  //p_overridden_action_reason		 --- Pass null or any value entered 

					cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
					cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
					cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text
					cstmt.setString( 59, discharge_yn);

					cstmt.execute() ;
					gross_amt		        = cstmt.getString(34); // Added for ML-BRU-CRF-0469 [IN:065426]
					total_charge_amt		= cstmt.getString(36);
					patient_payable_amt		= cstmt.getString(40);
					bl_included_IE	        = cstmt.getString(51)==null?"":cstmt.getString(51);             
					approval_reqd_yn		= cstmt.getString(52)==null?"":cstmt.getString(52);   
					override_allowed_yn		= cstmt.getString(53)==null?"":cstmt.getString(53); 
					error_code				= cstmt.getString(56);
					sys_message_id			= cstmt.getString(57);
					error_text				= cstmt.getString(58);
	//	System.err.println("@@GET_CHARGE_DTLS_MAT_ITEM Returns total_charge_amt="+total_charge_amt+" patient_payable_amt="+patient_payable_amt+" bl_included_IE="+bl_included_IE+" approval_reqd_yn="+approval_reqd_yn+" error_code="+error_code+" sys_message_id="+sys_message_id+" error_text="+error_text+" override_allowed_yn="+override_allowed_yn);
					closeStatement( cstmt ) ;

					pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_BLCORE_GET_DECIMAL_PLACE"));
					pstmt.setString(1,login_facility_id);
					rsDecimalPlace = pstmt.executeQuery();
					if(rsDecimalPlace.next())
						decimal_place = rsDecimalPlace.getInt("decimal_place");
					closeStatement( pstmt ) ;
					closeResultSet( rsDecimalPlace ) ;

					if(decimal_place > 0)
						decimalFormatString = decimalFormatString+".";

					for(int i=1;i<=decimal_place;i++){
						decimalFormatString = decimalFormatString+"0";
					}

					if(patient_payable_amt!=null && !patient_payable_amt.equals("")){
						DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
						patient_payable_amt = dfTest.format(Double.parseDouble(patient_payable_amt));
					}
					if(total_charge_amt!=null && !total_charge_amt.equals("")){
						DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
						total_charge_amt = dfTest.format(Double.parseDouble(total_charge_amt));
					}
					if(gross_amt!=null && !gross_amt.equals("")){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
						DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
						gross_amt = dfTest.format(Double.parseDouble(gross_amt));
					} // ML-BRU-CRF-0469 [IN:065426] - End

		  }


		}
		catch(Exception e){
			error_text = "Error in Proc";
			e.printStackTrace();
		}
		finally{
			try{
				closeStatement( cstmt ) ;
				closeStatement( pstmt ) ;
				closeResultSet( rsDecimalPlace ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
        if(billable_item_yn.equals("Y")){
			drugDetails.put("BL_CHARGE_AMT",total_charge_amt);
			drugDetails.put("BL_PATIENT_PAYABLE",patient_payable_amt);

			if(!drugDetails.containsKey("BL_INCL_EXCL_VALUE"))
				  drugDetails.put("BL_INCL_EXCL_VALUE",bl_included_IE);		

			drugDetails.put("BL_APPRVL_REQD_YN",approval_reqd_yn);
			if(!drugDetails.containsKey("BL_OVERRIDE_ALLOWED_YN"))
				drugDetails.put("BL_OVERRIDE_ALLOWED_YN",override_allowed_yn);		

			drugDetails.put("BL_ERROR_CODE",error_code);
			drugDetails.put("BL_SYS_MESSAGE_ID",sys_message_id);
			drugDetails.put("BL_ERROR_TEXT",error_text);
			drugDetails.put("BL_DECIMAL_FORMAT_STRING",decimalFormatString);
			drugDetails.put("BL_GROSS_AMT",gross_amt); // Added for ML-BRU-CRF-0469 [IN:065426]
		}
			
			drugDetails.put("BILLABLE_ITEM_YN",billable_item_yn);
		
		return;
	}

	public ArrayList getParamMaxDurnDet(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		ArrayList param_values_MaxDurn = new ArrayList();
		try{
			connection = getConnection() ;
			pstmt					= connection.prepareStatement("select MAX_DURN_FOR_IP_PRES, 'R' CHK_FOR_IP_MAX_DURN_ACTION, MAX_DURN_FOR_OP_PRES, 'R' CHK_FOR_OP_MAX_DURN_ACTION, MAX_DURN_FOR_DM_PRES, 'R' CHK_FOR_DM_MAX_DURN_ACTION, TRADE_DISPLAY_YN from ph_param where MODULE_ID='PH'") ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				param_values_MaxDurn.add(checkForNull(resultSet.getString("MAX_DURN_FOR_IP_PRES")));
				param_values_MaxDurn.add(checkForNull(resultSet.getString("CHK_FOR_IP_MAX_DURN_ACTION")));
				param_values_MaxDurn.add(checkForNull(resultSet.getString("MAX_DURN_FOR_OP_PRES")));
				param_values_MaxDurn.add(checkForNull(resultSet.getString("CHK_FOR_OP_MAX_DURN_ACTION")));
				param_values_MaxDurn.add(checkForNull(resultSet.getString("MAX_DURN_FOR_DM_PRES")));
				param_values_MaxDurn.add(checkForNull(resultSet.getString("CHK_FOR_DM_MAX_DURN_ACTION")));
				param_values_MaxDurn.add(checkForNull(resultSet.getString("TRADE_DISPLAY_YN")));
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		catch( Exception e ) {
            e.printStackTrace() ;
		}
		finally{
			try{
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}

			return param_values_MaxDurn;
	}

	public ArrayList getAllUOMs(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		ArrayList uom_values		= new ArrayList();
		try
		{
			connection = getConnection() ;
			pstmt					= connection.prepareStatement("select UOM_CODE, SHORT_DESC from am_uom_lang_vw where EFF_STATUS ='E' and LANGUAGE_ID =? order by 2 ") ;
			pstmt.setString(1,getLanguageId());
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null)
			{
				while(resultSet.next())
				{
					uom_values.add(checkForNull(resultSet.getString("UOM_CODE")));
					uom_values.add(checkForNull(resultSet.getString("SHORT_DESC")));
				}
			}
			try
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es)
			{
				es.printStackTrace() ;
			}
		}
		catch( Exception e ) 
		{
            e.printStackTrace() ;
		}
		//Closed Connection
		finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace();
			}
        }

			return uom_values;
	}
	public HashMap getSchdDatesFrWeekHr(HashMap scheduleFrequency,ArrayList orderDetails,String mode){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		//ArrayList dayDisplayList	= new ArrayList();
		ArrayList headerList		= new ArrayList();
		ArrayList schdDateTime		= new ArrayList();
		HashMap	  schdData			= new HashMap();
		HashMap   drugDetails		= new HashMap();
		HashMap   schDateTimeWkHr	= new HashMap();
		String    duration_type		= "";
		String	  start_date_time	= "";
		String	  start_date		= "";
		String	  start_time		= "";
		String    drgCode			= "";
		String    tmp_drug_code		= "";
		String    schd_date_time	= "";
		String    durn_type			= "D";
		String	  interval_value	= "1";		
		String	  frequency_nature	= "F";
		int	      durn_value		= 1;
		ArrayList day_list			= new ArrayList();
		ArrayList day_names			= new ArrayList();
		ArrayList time_list			= new ArrayList();

		try{
			connection				= getConnection() ;
			//String sql_query		= "SELECT CASE WHEN MOD(NEXT_DAY(TO_DATE(?,'DD/MM/YYYY')+?, ?) - TO_DATE(?,'DD/MM/YYYY'),7) = 0      THEN  CASE WHEN TO_DATE(?,'HH24:MI') > TO_DATE(?,'HH24:MI')	  THEN TO_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')+?,'DD/MM/YYYY HH24:MI')     ELSE TO_CHAR(NEXT_DAY(TO_DATE(?,'DD/MM/YYYY HH24:MI')+?, ?),'DD/MM/YYYY HH24:MI')    END      ELSE TO_CHAR(NEXT_DAY(TO_DATE(?,'DD/MM/YYYY HH24:MI')+?, ?),'DD/MM/YYYY HH24:MI') END NEXTDAY FROM DUAL ";
//System.out.println("@10890 >>>> scheduleFrequency = "+scheduleFrequency+"<> orderDetails = "+orderDetails+" <> mode = "+mode+"<>");
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT103")) ;
			if(scheduleFrequency != null && scheduleFrequency.size()>0){
				Set DrugCodesSet		= scheduleFrequency.keySet();
				Iterator   drgCdeItr	= DrugCodesSet.iterator();
				while(drgCdeItr.hasNext()){
					drgCode = (String)drgCdeItr.next();
//					tmp_drug_code = drgCode.substring(0,drgCode.length()-1);
					tmp_drug_code = drgCode;
					if(scheduleFrequency.containsKey(drgCode)){

							try{
								for(int ordDtls = 0;ordDtls<orderDetails.size();ordDtls++){
									/*if(mode.equals("CREATE")){
										headerList		= (ArrayList) orderDetails.get(ordDtls);
									}else if(mode.equals("UPDATE")){
										headerList		= 	orderDetails;
									}
									for(int hl=0;hl<headerList.size();hl++){*/
										drugDetails	= new HashMap();
//										drugDetails	= (HashMap)headerList.get(hl);
										drugDetails	= (HashMap)orderDetails.get(ordDtls);
										if(tmp_drug_code.equals((String)drugDetails.get("DRUG_CODE"))){
											if(mode.equals("CREATE")){
												start_date_time = (String)drugDetails.get("START_DATE");
											}else if(mode.equals("UPDATE")){
												start_date_time = (String)drugDetails.get("START_DATE_TIME");
											}
											start_date      = start_date_time.substring(0,10);
											start_time      = start_date_time.substring(11,start_date_time.length());
											durn_value		= Integer.parseInt((String)drugDetails.get("DURN_VALUE"));
											interval_value	= (String)drugDetails.get("INTERVAL_VALUE");
											break;
										}
								//	}
								 }
								}catch(Exception chkE){
									System.out.println("at 9523 --- "+chkE.toString());
									chkE.printStackTrace() ;
								}

						ArrayList schdDetails = (ArrayList)scheduleFrequency.get(drgCode);

						schdData=(HashMap)schdDetails.get(0);
						duration_type	= (String)schdData.get("durationType");
						day_list	=	(ArrayList)schdDetails.get(1);
						day_names	=	(ArrayList)schdDetails.get(2);
						time_list	=	(ArrayList)schdDetails.get(3);	
					//	duration_type	= "M";
						if(duration_type.equals("W")){


						/*	for(int ab=0;ab<schdDetails.size();ab++) {
								schdData=(HashMap)schdDetails.get(ab);
								if(ab == 0){
									for(int ddl=1;ddl<=7;ddl++){
										dayDisplayList.add((String)schdData.get("dayDisplay"+ddl));
									}
								}
								if(!((String)schdData.get("admin_time")).equals("")){
									time_list.add((String)schdData.get("admin_time"));										
								}
								if(!((String)schdData.get("admin_day")).equals("")){
									day_names.add((String)schdData.get("admin_day"));
								}
							}*/

							for(int dv=0;dv<durn_value;dv++){
								if((dv != 0) && (Integer.parseInt(interval_value) > 1)){
									dv = dv+(Integer.parseInt(interval_value) -1);
								}

								for(int dl=0;dl<day_names.size();dl++){
//									for(int tl=0;tl<time_list.size();tl++){
	//System.out.println("start_date="+start_date+"=dv="+dv+"==day_names.get(dl)=="+day_names.get(dl)+"==time_list.get(dl)=="+time_list.get(dl)+"==start_time=="+start_time+"==start_date=="+start_date);
										pstmt.setString(1,start_date);
										pstmt.setString(2,(dv*7)+"");
//										pstmt.setString(3,(String)dayDisplayList.get(Integer.parseInt((String)day_names.get(dl))-1));
										pstmt.setString(3,(String)day_names.get(dl));
										pstmt.setString(4,start_date);
										pstmt.setString(5,(String)time_list.get(dl));
										pstmt.setString(6,start_time);
										pstmt.setString(7,(start_date+" "+(String)time_list.get(dl)));
										pstmt.setString(8,(dv*7)+"");
										pstmt.setString(9,(start_date+" "+(String)time_list.get(dl)));
										pstmt.setString(10,(dv*7)+"");
//										pstmt.setString(11,(String)dayDisplayList.get(Integer.parseInt((String)day_names.get(dl))-1));
										pstmt.setString(11,(String)day_names.get(dl));
										pstmt.setString(12,(start_date+" "+(String)time_list.get(dl)));
										pstmt.setString(13,(dv*7)+"");
//										pstmt.setString(14,(String)dayDisplayList.get(Integer.parseInt((String)day_names.get(dl))-1));
										pstmt.setString(14,(String)day_names.get(dl));

										resultSet	= pstmt.executeQuery();
										if(resultSet!=null && resultSet.next()){
											schd_date_time = resultSet.getString("NextDay");
											schdDateTime.add(schd_date_time);
										}
									//}
								}
							}
						}else if(duration_type.equals("L")){

							for(int dv=0;dv<durn_value;dv++){
								for(int dl=0;dl<day_list.size();dl++){
									/*if((dv != 0) && (Integer.parseInt(interval_value) > 1)){
										dv = dv+(Integer.parseInt(interval_value) -1);
									}*/
									schd_date_time = populateEndDate(frequency_nature,start_date_time,(Integer.parseInt(day_list.get(dl)+"")+(dv*30)+""),"D");
									schd_date_time = schd_date_time.substring(0,10)+" "+(String)time_list.get(dl);
									schdDateTime.add(schd_date_time);

								}
							}
						}
					}
				//	drgCode = drgCode.substring(0,drgCode.length()-1);
					schDateTimeWkHr.put(drgCode,schdDateTime);
				}
			}else{
				String tmp_durn_value  = "1";
				for(int ordDtls = 0;ordDtls<orderDetails.size();ordDtls++){
					if(mode.equals("CREATE")){
						headerList		= (ArrayList) orderDetails.get(ordDtls);
					}else if(mode.equals("UPDATE")){
						headerList		= 	orderDetails;
					}

					for(int hl=0;hl<headerList.size();hl++){
						drugDetails	= new HashMap();
						drugDetails	=(HashMap)headerList.get(hl);

						//drugDetails	=orderDetails;
						if(mode.equals("CREATE")){
							start_date_time = (String)drugDetails.get("START_DATE");
						}else if(mode.equals("UPDATE")){
							start_date_time = (String)drugDetails.get("START_DATE_TIME");
						}

						start_date      = start_date_time.substring(0,10);
						start_time      = start_date_time.substring(11,start_date_time.length());
						durn_value		= Integer.parseInt((String)drugDetails.get("DURN_VALUE"));
						interval_value	= (String)drugDetails.get("INTERVAL_VALUE");
						durn_type		= (String)drugDetails.get("DURN_TYPE");
						frequency_nature= (String)drugDetails.get("FREQ_NATURE");
						drgCode			= (String)drugDetails.get("DRUG_CODE");
					}

					for(int i=0;i<(durn_value/Integer.parseInt(interval_value));i++){
						tmp_durn_value = (i*Integer.parseInt(interval_value))+"";
						schd_date_time = populateEndDate(frequency_nature,start_date_time,tmp_durn_value,durn_type);
						schdDateTime.add(schd_date_time);
					}
					drgCode = drgCode.substring(0,drgCode.length()-1);
					schDateTimeWkHr.put(drgCode,schdDateTime);
				}
		}
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}catch(Exception es){
			es.printStackTrace() ;
		}
	}
	catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace();
			}
        }
	return schDateTimeWkHr;
	}

	public HashMap getSchdDatesFrWeekHrInterval(HashMap scheduleFrequency,ArrayList drugDetail,HashMap orderDetails, String mode){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList headerList		= new ArrayList();
		ArrayList schdDateTime		= new ArrayList();
		HashMap   drugDetails		= new HashMap();
		HashMap   schDateTimeWkHr	= new HashMap();
		String	  start_date_time	= "";
		String	  start_date		= "";
		String	  start_time		= "";
		String    drgCode			= "";
		String    schd_date_time	= "";
		String    durn_type			= "D";
		String	  interval_value	= "1";		
		String	  frequency_nature	= "F";
		int	      durn_value		= 1;

		try{
			connection				= getConnection() ;
			
			pstmt					= connection.prepareStatement("SELECT CASE WHEN MOD(NEXT_DAY(TO_DATE(?,'DD/MM/YYYY')+?, ?) - TO_DATE(?,'DD/MM/YYYY'),7) = 0      THEN  CASE WHEN TO_DATE(?,'HH24:MI') > TO_DATE(?,'HH24:MI')	  THEN TO_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')+?,'DD/MM/YYYY HH24:MI')     ELSE TO_CHAR(NEXT_DAY(TO_DATE(?,'DD/MM/YYYY HH24:MI')+?, ?),'DD/MM/YYYY HH24:MI')    END      ELSE TO_CHAR(NEXT_DAY(TO_DATE(?,'DD/MM/YYYY HH24:MI')+?, ?),'DD/MM/YYYY HH24:MI') END NEXTDAY FROM DUAL") ;					

				String tmp_durn_value  = "1";
				String interval_durn_type  = "";
				String freq_chng_durn_desc  = "";

				for(int ordDtls = 0;ordDtls<drugDetail.size();ordDtls++){
					if(mode.equals("CREATE")){
						headerList		= (ArrayList) drugDetail;//.get(ordDtls);
					}else if(mode.equals("UPDATE")){
						headerList		= 	drugDetail;
					}
					for(int hl=0;hl<headerList.size();hl++){
						drugDetails	= new HashMap();
						drugDetails	=(HashMap)headerList.get(hl);


						//drugDetails	=orderDetails;
						if(mode.equals("CREATE")){
//							start_date_time = (String)drugDetails.get("START_DATE");
							start_date_time = (String)orderDetails.get("START_DATE"); // pre date_time, shedule wasnt going right. incident 25910
							
							durn_type		= (String)drugDetails.get("DURN_TYPE");
							freq_chng_durn_desc =  (String)((HashMap)orderDetails.get("IntervalFreqDet")).get("interval_durn_type");
						}else if(mode.equals("UPDATE")){
							start_date_time = (String)drugDetails.get("START_DATE_TIME");
							durn_type   	= (String)drugDetails.get("FREQ_DURN_TYPE");
							freq_chng_durn_desc = (String)drugDetails.get("DURN_TYPE");
						}

						start_date      = start_date_time.substring(0,10);
						start_time      = start_date_time.substring(11,start_date_time.length());
						durn_value		= Integer.parseInt((String)drugDetails.get("DURN_VALUE"));
						interval_value	= (String)drugDetails.get("INTERVAL_VALUE");

						interval_value	= (String)((HashMap)orderDetails.get("IntervalFreqDet")).get("interval_value");

						durn_type		= (String)drugDetails.get("DURN_TYPE");
						frequency_nature= (String)orderDetails.get("FREQ_NATURE");
						drgCode			= (String)drugDetails.get("DRUG_CODE");
						freq_code		= (String)orderDetails.get("FREQ_CODE");

					}

			

					 if(frequency_nature.equals("I")) {

						interval_durn_type = (String)((HashMap)orderDetails.get("IntervalFreqDet")).get("interval_durn_type");


							if(!interval_durn_type.equals(freq_chng_durn_desc) && !mode.equals("UPDATE")){
									 if(interval_durn_type.equals("H")&& freq_chng_durn_desc.equals("D")){
										durn_value =durn_value*24;
									}else if(interval_durn_type.equals("H")&& freq_chng_durn_desc.equals("W")){
										durn_value =durn_value*24*7;
									}else if(interval_durn_type.equals("M")&& freq_chng_durn_desc.equals("H")){
										durn_value =durn_value*60;
									}else if(interval_durn_type.equals("M")&& freq_chng_durn_desc.equals("D")){
										durn_value =durn_value*60*24;
									}else if(interval_durn_type.equals("M")&& freq_chng_durn_desc.equals("W")){
										durn_value =durn_value*60*24*7;
									}

							}

							for(int i=0;i<(int) Math.ceil((durn_value/Float.parseFloat(interval_value)));i++){ //replaced Integer.parseInt with Float.parseFloat and ceiled the value for IN25538  --23/02/2011-- priya

								tmp_durn_value = (i*Integer.parseInt(interval_value))+"";

								schd_date_time = populateEndDate(frequency_nature,start_date_time,tmp_durn_value,(String)((HashMap)orderDetails.get("IntervalFreqDet")).get("interval_durn_type"));

								schdDateTime.add(schd_date_time);
							}
							schDateTimeWkHr.put(drgCode,schdDateTime);


							
				    }
				}
		
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}catch(Exception es){
			es.printStackTrace() ;
		}
	}
	catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace();
			}
        }
	return schDateTimeWkHr;
	}

	public ArrayList getEquvalentUOMConversionValue(String finalUOM,String drugUOM,String drugCode)
	{
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		PreparedStatement pstmt1    = null ;
		PreparedStatement pstmt2    = null ;
		ResultSet resultSet         = null ;
		ResultSet resultSet1        = null ;
		ResultSet resultSet2        = null ;
		ArrayList equvalentValues	= new ArrayList();
		try
		{
			connection = getConnection() ;
			if(!drugUOM.equals(finalUOM))
			{
				pstmt					= connection.prepareStatement("SELECT A.EQVL_VALUE FROM AM_UOM_EQVL A WHERE A.EQVL_UOM_CODE=? AND A.UOM_CODE=?") ;
				pstmt.setString(1,drugUOM);
				pstmt.setString(2,finalUOM);
				resultSet				= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next())
				{			
					equvalentValues.add(checkForNull(resultSet.getString("EQVL_VALUE")));
					equvalentValues.add("DEVIDE");
				
				}
				else
				{
					pstmt1					= connection.prepareStatement("SELECT A.EQVL_VALUE FROM AM_UOM_EQVL A WHERE A.EQVL_UOM_CODE=? AND A.UOM_CODE=?") ;
					pstmt1.setString(1,finalUOM);
					pstmt1.setString(2,drugUOM);			
					resultSet1				= pstmt1.executeQuery();
					if(resultSet1!=null && resultSet1.next())
					{			
						equvalentValues.add(checkForNull(resultSet1.getString("EQVL_VALUE")));
						equvalentValues.add("MULTIPLY");
					
					}
					try
					{
						closeResultSet( resultSet1 ) ;
						closeStatement( pstmt1 ) ;
					}
					catch(Exception es1)
					{
					es1.printStackTrace() ;
					}
				}
			}
			else
			{
				equvalentValues.add("1");
				equvalentValues.add("MULTIPLY");
			}
			pstmt2					= connection.prepareStatement("SELECT CONTENT_IN_PRES_BASE_UOM,STOCK_UOM from PH_DRUG WHERE DRUG_CODE=?") ;
			pstmt2.setString(1,drugCode);
			resultSet2				= pstmt2.executeQuery();
			if(resultSet2!=null && resultSet2.next())
			{			
				equvalentValues.add(resultSet2.getString("CONTENT_IN_PRES_BASE_UOM")==null?"1":resultSet2.getString("CONTENT_IN_PRES_BASE_UOM"));
				equvalentValues.add(resultSet2.getString("STOCK_UOM")==null?"":resultSet2.getString("STOCK_UOM"));
				
				
			}
			try
			{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt2 ) ;
				closeConnection( connection );
			}
			catch(Exception es)
			{
				es.printStackTrace() ;
			}
		}
		catch( Exception e ) 
		{
			e.printStackTrace() ;
		}finally {
				try{
					closeResultSet( resultSet ) ;
					closeResultSet( resultSet2 ) ;
					closeStatement( pstmt ) ;
					closeStatement( pstmt2 ) ;
					closeConnection( connection );
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
		}
		
		return equvalentValues;
	}

	public ArrayList getContentInPresBaseUOMValue(String drugCode)
	{
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		ArrayList content	= new ArrayList();
		try
		{
			connection = getConnection() ;
			pstmt					= connection.prepareStatement("SELECT CONTENT_IN_PRES_BASE_UOM,STOCK_UOM from PH_DRUG WHERE DRUG_CODE=?") ;
			pstmt.setString(1,drugCode);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())
			{			
				content.add(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null?"1":resultSet.getString("CONTENT_IN_PRES_BASE_UOM"));
				content.add(resultSet.getString("STOCK_UOM")==null?"":resultSet.getString("STOCK_UOM"));								
			}
			try
			{
				closeResultSet( resultSet ) ;			
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es)
			{
				es.printStackTrace() ;
			}

		}
		catch( Exception e ) 
		{
			e.printStackTrace() ;
		}finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
		}
		
		return content;
	}

	public int getDurationCalc(String durn_unit, String durn_value, String durationType){

		int duration = Integer.parseInt(durn_value);
		int duration_calc = 0;

		if(!durn_unit.equals(durationType)){
			if(durationType.equals("L")){ //if freq is month
				if(durn_unit.equals("Y"))
					duration_calc = duration*12;
			}
			if(durationType.equals("W")){ //if freq is week
				if(durn_unit.equals("L"))
					duration_calc = duration*4;
				if(durn_unit.equals("Y"))
					duration_calc = duration*52;
			}
			if(durationType.equals("D")){ //if freq is days
				if(durn_unit.equals("W"))
					duration_calc = duration*7;
				if(durn_unit.equals("L"))
					duration_calc = duration*30;
				if(durn_unit.equals("Y"))
					duration_calc = duration*365;
			}
			if(durationType.equals("H")){ //if freq is hours
				if(durn_unit.equals("D"))
					duration_calc = duration * 24;
				if(durn_unit.equals("W"))
					duration_calc = duration * 7 * 24;
			}
			if(durationType.equals("M")){ //if freq is min
				if(durn_unit.equals("H"))
					duration_calc = duration * 60;
				if(durn_unit.equals("D"))
					duration_calc = duration * 24 * 60;
			}

		}
//System.out.println("@@@--duration_calc---"+duration_calc);
		if(duration_calc == 0)
			duration_calc = duration;
		return duration_calc;
	}	

	
	public ArrayList getNarc_nos(String order_id)
	{
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		ArrayList narc_nos	        = new ArrayList();
		 try{
				connection = getConnection() ;

				pstmt				= connection.prepareStatement("select NARCO_NO from or_order_line_ph where order_id =? and NARCO_NO is not null") ;

				pstmt.setString(1,order_id);
				
                resultSet			= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					 narc_nos.add(resultSet.getString("NARCO_NO"));
				}
		   }catch ( Exception e ) {
				e.printStackTrace() ;
		   }finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
			}
		
		return narc_nos;
	}

public String getBillableItemYN (String drug_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String billable_item_yn	= "";
		try {

            connection	= getConnection() ;
          	pstmt		= connection.prepareStatement( "select BILLABLE_ITEM_YN from ph_drug where drug_CODE=? ") ;

			pstmt.setString(1,drug_code);			
		
            resultSet	= pstmt.executeQuery() ;
			
			if (resultSet.next()){
				billable_item_yn = resultSet.getString("BILLABLE_ITEM_YN");				
				
			}
			
		}catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
				}catch(Exception es){es.printStackTrace();}
		}
		return billable_item_yn;
	}
	// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- begin
	
	public String getMARDefaulting(String patient_class,String source_code,String form_code, String priority){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        String sql_query="", MARDefaulting ="";
		ResultSet resultSet = null;
		try{
			connection = getConnection() ;
			sql_query      = PhRepository.getPhKeyValue("SQL_BUILD_MAR_RULE");
			pstmt		   = connection.prepareStatement(sql_query) ;
			pstmt.setString(1,getLoginFacilityId());
			pstmt.setString(2,patient_class);
			pstmt.setString(3,source_code);
			pstmt.setString(4,form_code);
			pstmt.setString(5,priority);
			resultSet	= pstmt.executeQuery();

			while(resultSet.next()) {
				MARDefaulting = resultSet.getString(1);
			}
					
		}
		catch ( Exception e ) {
			e.printStackTrace();
			
		} finally {
           	try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
        }
		return MARDefaulting;
	}
// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- end

public String getDrugIndication(String drug_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String drug_indication	=null;
		try {
            connection	= getConnection() ;
          	pstmt		= connection.prepareStatement( "select DRUG_INDICATION from ph_drug where drug_CODE=? ") ;
			pstmt.setString(1,drug_code);			
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				drug_indication = resultSet.getString("DRUG_INDICATION");				
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
				}catch(Exception es){es.printStackTrace();}
		}
		return drug_indication;
	}
	public void setPrintOrdShtRuleInd(HashSet order_type_code,String patient_class){//Added for Bru-HIMS-CRF-393_1.0
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String print_ord_sht_rule_ind = getPrintOrdShtRuleInd();
		Iterator iterator =order_type_code.iterator();
		StringBuffer sbf=new StringBuffer();
		String print_option_sql,print_ord_sht_rule_ind_tmp="";
		String print_ord_sht_rule_ind_tmp1,print_ord_sht_rule_ind_tmp2="";
		try{
			while(iterator.hasNext()){
				print_ord_sht_rule_ind_tmp1=(String)iterator.next();
				sbf.append("'").append(print_ord_sht_rule_ind_tmp1).append("'").append(",");
				print_ord_sht_rule_ind_tmp2=sbf.toString();
				int index=print_ord_sht_rule_ind_tmp2.lastIndexOf(",");
				print_ord_sht_rule_ind_tmp2=print_ord_sht_rule_ind_tmp2.substring(0,index);
			}
			connection		= getConnection() ;
			print_option_sql="SELECT PRINT_ORD_SHT_RULE_IND FROM OR_ORDER_TYPE_ROUTING WHERE ORDER_TYPE_CODE in ("+print_ord_sht_rule_ind_tmp2+") AND PATIENT_CLASS=DECODE(?,PATIENT_CLASS, PATIENT_CLASS, '*A') AND OPERATING_FACILITY_ID=?";
			pstmt			= connection.prepareStatement(print_option_sql) ;
			pstmt.setString(1,patient_class);
			pstmt.setString(2,login_facility_id);
			resultSet		= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())	{
				print_ord_sht_rule_ind_tmp=resultSet.getString("PRINT_ORD_SHT_RULE_IND")==null ? "C" :resultSet.getString("PRINT_ORD_SHT_RULE_IND");
				if(print_ord_sht_rule_ind.equals("") || print_ord_sht_rule_ind_tmp.equals("C"))
					setPrintOrdShtRuleInd(print_ord_sht_rule_ind_tmp);
				else if(print_ord_sht_rule_ind_tmp.equals("S") && !print_ord_sht_rule_ind.equals("C"))
					setPrintOrdShtRuleInd(print_ord_sht_rule_ind_tmp);
				else if(!print_ord_sht_rule_ind.equals("C") && !print_ord_sht_rule_ind.equals("S"))
					setPrintOrdShtRuleInd(print_ord_sht_rule_ind_tmp);
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
	}
	//added for ml-mmoh-crf-0863 start
		public String getAuthAmendPres(String disp_locn_code) {
			Connection connection       = null ;
			PreparedStatement pstmt     = null ;
			ResultSet resultSet         = null ;
			String sql_query=null;
			String auth_amend_pres_yn			= "";
			try{
				connection				= getConnection() ;
				
				sql_query= PhRepository.getPhKeyValue("SELECT_AUTH_AMEND_PRES") ;
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1, login_facility_id) ;
				pstmt.setString(2, disp_locn_code) ;
				pstmt.setString(3, login_by_id) ;
				pstmt.setString(4, language_id);

				resultSet = pstmt.executeQuery() ;

				if(resultSet!=null && resultSet.next()){
					auth_amend_pres_yn	=	resultSet.getString("AUTH_AMEND_PRES_YN");
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
					es.printStackTrace() ;
				}
			}
			return auth_amend_pres_yn;
		}
		public String getOrderStatusUsingOrderId(String orderId) {
			Connection connection       = null ;
			PreparedStatement pstmt     = null ;
			ResultSet resultSet         = null ;
			String sql_query=null;
			String orderStatus			= "";
			try{
				connection				= getConnection() ;
				
				sql_query= "SELECT ORDER_STATUS FROM OR_ORDER WHERE ORDER_ID= ?" ;
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1, orderId) ;
								resultSet = pstmt.executeQuery() ;

				if(resultSet!=null && resultSet.next()){
					orderStatus	=	resultSet.getString("ORDER_STATUS");
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
					es.printStackTrace() ;
				}
			}
			return orderStatus;
		}

		//added for ml-mmoh-crf-0863 end
		//added for ml-mmoh-crf-0978 start
		public String getUOMDesc (String uom_code){
			Connection connection	= null;
	        PreparedStatement pstmt	= null;
	        ResultSet resultSet		= null;	
			String short_desc		= "";
			try {
	            connection	= getConnection() ;
				//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
				pstmt		= connection.prepareStatement( "select SHORT_DESC from am_uom_lang_vw where UOM_CODE=? and  LANGUAGE_ID=?") ;
				pstmt.setString(1,uom_code);
				pstmt.setString(2,language_id);
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
					}catch(Exception es){es.printStackTrace();}
			}
			return short_desc;
		}
		public boolean isSiteSpecific(String moduleId, String functionalityId){ //Added for MO-CRF-20103 [IN:055441] - Start
			boolean site=false;
		    Connection con	= null;  
	        try{
	        	con =			getConnection();		
	        	site = eCommon.Common.CommonBean.isSiteSpecific(con,moduleId,functionalityId);	
			}
	        catch(Exception e){
	            e.printStackTrace();
	        }
			finally{
				try{
				closeConnection(con);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			return site;
	   }
		//added for ml-mmoh-crf-0978 end
//added for GHL-CRF-0549 - start
		public String getParamDispByAltForm(){
			Connection connection	= null;
	        PreparedStatement pstmt	= null;
	        ResultSet resultSet		= null;	
			String disp_by_alt_form_param	= "N";
			try {
	            connection	= getConnection() ;
				pstmt		= connection.prepareStatement( "select DISP_ALT_FORM_YN from PH_PARAM where MODULE_ID=?") ;
				pstmt.setString(1,"PH");
	            resultSet	= pstmt.executeQuery() ;
				if(resultSet!=null && resultSet.next()){
					disp_by_alt_form_param = checkForNull(resultSet.getString("DISP_ALT_FORM_YN"),"N");				
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
					}catch(Exception es){es.printStackTrace();}
			}
			return disp_by_alt_form_param;

		}

	public String getItemType(String item_code){
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String low_cost_item_yn		= "N";
		String high_margin_item_yn  = "N";
		String innovator_item_yn		= "N";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement("select LOW_COST_ITEM,INNOVATOR_ITEM,HIGH_MARGIN_ITEM FROM MM_ITEM WHERE ITEM_CODE=? ");
			pstmt.setString(1, item_code);
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
			 low_cost_item_yn = resultSet.getString("LOW_COST_ITEM")==null?"N":resultSet.getString("LOW_COST_ITEM");
			 high_margin_item_yn = resultSet.getString("HIGH_MARGIN_ITEM")==null?"N":resultSet.getString("HIGH_MARGIN_ITEM");
			 innovator_item_yn = resultSet.getString("INNOVATOR_ITEM")==null?"N":resultSet.getString("INNOVATOR_ITEM");
			 
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}
		
		return low_cost_item_yn+"~"+high_margin_item_yn+"~"+innovator_item_yn;	
	}
//GHL-CRF-0549 - end
		//added for SKR-SCF-1254 - start
public String getCurrentLocn(String patient_id,String encounter_id){

		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String curr_locn		= "";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement("select NURSING_UNIT_CODE from ip_open_encounter where  patient_class='IP' and patient_id=? and ENCOUNTER_ID=? ");
			pstmt.setString(1, patient_id);
			pstmt.setString(2, encounter_id);
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
			 curr_locn = resultSet.getString("NURSING_UNIT_CODE")==null?"":resultSet.getString("NURSING_UNIT_CODE");
			 			 
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}
		
		return curr_locn;
	
}
public String getDispLocn(String patient_class, String priority, String drug_code, String locn_type, String locn_code, String take_home, String order_type, String drug_class,String home_leave_yn_val,String patient_id,String encounter_id) {
		PreparedStatement pstmt_select		= null;
		ResultSet resultSet					= null;
		Connection connection				= null;
		String perf_deptloc_code =""; 
		//Added for NMC-JD-CRF-0063
		System.out.println("getTakeHomeMedicationOp- getDispLocn(): "+getTakeHomeMedicationOp());
		System.out.println("getOpDischMedInd: "+getOpDischMedInd());
		//added for NMC-JD-CRF-0063
		if(getTakeHomeMedicationOp()!=null && !getTakeHomeMedicationOp().equals("") && getTakeHomeMedicationOp().equals("Y") && getOpDischMedInd()!=null && !getOpDischMedInd().equals("") && getOpDischMedInd().equals("Y")){
			take_home = "Y";
				System.out.println("take_home: "+take_home);  
		}//END
		try {
			connection	= getConnection();
			pstmt_select = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT16A") );
			pstmt_select.setString(1,locn_type);
			pstmt_select.setString(2,locn_code);
			pstmt_select.setString(3,login_facility_id);
			pstmt_select.setString(4,login_facility_id);
			pstmt_select.setString(5,drug_class);
			pstmt_select.setString(6,drug_code);
			pstmt_select.setString(7,order_type);
			pstmt_select.setString(8,patient_class);
			pstmt_select.setString(9,take_home);
			pstmt_select.setString(10,priority);
			pstmt_select.setString(11,getLanguageId());
			pstmt_select.setString(12,"D");
			pstmt_select.setString(13,home_leave_yn_val);
			pstmt_select.setString(14,patient_id);
			pstmt_select.setString(15,encounter_id);
			pstmt_select.setString(16,"Y");
			pstmt_select.setString(17,getOpDischMedInd());//added for NMC-JD-CRF-0063
			resultSet = pstmt_select.executeQuery() ;
						
			if(resultSet!=null && resultSet.next()){
				perf_deptloc_code =resultSet.getString("DISP_LOCN");
			}

			closeStatement(pstmt_select);
			closeResultSet(resultSet);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt_select);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return perf_deptloc_code;
	}
//added for SKR-SCF-1254 - end
public String getExtDispYN(String store_code)  //Start for nmc-jd-crf-0046
{
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	String ext_disp_appl_yn="";
	
	try {
		connection			= getConnection();
	
	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_EXTERNAL_DISPENSING") );
	pstmt.setString(1,login_facility_id);
	pstmt.setString(2,store_code);
	
	resultSet = pstmt.executeQuery() ;

	if(resultSet!=null && resultSet.next()){					
		
		ext_disp_appl_yn = resultSet.getString("EXT_DISP_YN");	
		
	}
		if(ext_disp_appl_yn==null || ext_disp_appl_yn.equals(""))
		{
			ext_disp_appl_yn="N";
		
		}
		
	
	} catch(Exception e) {
		e.printStackTrace();
	}
	    finally {
		try {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception es){ 
			es.printStackTrace();
		}
	}
	return ext_disp_appl_yn; 
}
//End of NMC-JD-CRF-0046

//Added for MMS-DM-CRF-0177
public String setPreAllocAppl()
{
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	String pre_alloc_appl="";
	
	try {
		connection			= getConnection();
	
	pstmt = connection.prepareStatement("SELECT PRE_ALLOC_APPL FROM PH_FACILITY_PARAM WHERE FACILITY_ID = ?");
	pstmt.setString(1,login_facility_id);
	resultSet = pstmt.executeQuery() ;
	if(resultSet!=null && resultSet.next()){					
		pre_alloc_appl = resultSet.getString("PRE_ALLOC_APPL");	
		if(pre_alloc_appl==null)
			pre_alloc_appl="N";
		
		setPreAllocApplYN(pre_alloc_appl);
	}
	
} catch(Exception e) {
	e.printStackTrace();
}
    finally {
	try { 
		closeResultSet(resultSet);
		closeStatement(pstmt);
		closeConnection(connection);
	}
	catch(Exception es){ 
		es.printStackTrace();
	}
   }	
return pre_alloc_appl;
}
//Added for MMS-DM-CRF-0177

//added for NMC-JD-CRF-0063
public ArrayList getAmendDetails(String order_id){

	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	//String dischInd		= ""; //Commented for common-icn-0048
	//String patient_class =""; //Commented for common-icn-0048
	//String discharge_ind = "";  //Commented for common-icn-0048
	ArrayList amendDetailsList	        = new ArrayList();

	try { 
		connection			= getConnection();
			pstmt				= connection.prepareStatement("select OP_DISCH_IND,PATIENT_CLASS,DISCHARGE_IND from or_order where order_id=?");
			pstmt.setString(1, order_id);
			resultSet	= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				amendDetailsList.add(resultSet.getString("OP_DISCH_IND")); 
				amendDetailsList.add(resultSet.getString("PATIENT_CLASS")); 
				amendDetailsList.add(resultSet.getString("DISCHARGE_IND"));  
			}
	} catch(Exception e) {
		e.printStackTrace();
	}
	    finally {
		try {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception es){ 
			es.printStackTrace();
		}
	}
	
	return amendDetailsList;

}

//added for aakh-crf-0140 start

		public HashMap getabusedetails(String patient_id,String drug_code,String drug_class){//finding the Height/Weight/uom Values
			Connection connection       = null ;
			PreparedStatement pstmt     = null ;
			ResultSet resultSet         = null ;
			String sql_query			= "";
			HashMap aduseDetails	= new HashMap();
			
			//int		i	=	0; COMMON-ICN-0310
			try{
				connection = getConnection() ;
				
				sql_query        = "select RESTRICT_TRAN_TYPE,RESTRICTION_TYPE,ACTION_TYPE_FLAG,REMARKS,DRUG_CLASS_OR_DRUG_CODE from PH_DRUG_ABUSE_PAT_MST  where DRUG_CLASS_OR_DRUG_CODE=? and PATIENT_ID=?";
				
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,drug_code);
				pstmt.setString(2,patient_id);
				resultSet			= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
						aduseDetails.put("restrict_tran",(String)resultSet.getString("RESTRICT_TRAN_TYPE"));
						aduseDetails.put("restriction_type",(String)resultSet.getString("RESTRICTION_TYPE"));
						aduseDetails.put("action_type_flag",(String)resultSet.getString("ACTION_TYPE_FLAG"));
						aduseDetails.put("remarks",(String)resultSet.getString("REMARKS"));
						aduseDetails.put("DRUG_CLASS_OR_DRUG_CODE",(String)resultSet.getString("DRUG_CLASS_OR_DRUG_CODE"));
						
					} 
					else {
						sql_query        = "select RESTRICT_TRAN_TYPE,RESTRICTION_TYPE,ACTION_TYPE_FLAG,REMARKS,DRUG_CLASS_OR_DRUG_CODE from PH_DRUG_ABUSE_PAT_MST  where DRUG_CLASS_OR_DRUG_CODE=? and PATIENT_ID=?";
						
						pstmt				= connection.prepareStatement(sql_query) ;
						pstmt.setString(1,drug_class);
						pstmt.setString(2,patient_id);
						resultSet			= pstmt.executeQuery();
						if(resultSet!=null && resultSet.next() ) {
							aduseDetails.put("restrict_tran",(String)resultSet.getString("RESTRICT_TRAN_TYPE"));
							aduseDetails.put("restriction_type",(String)resultSet.getString("RESTRICTION_TYPE"));
							aduseDetails.put("action_type_flag",(String)resultSet.getString("ACTION_TYPE_FLAG"));
							aduseDetails.put("remarks",(String)resultSet.getString("REMARKS"));
							aduseDetails.put("DRUG_CLASS_OR_DRUG_CODE",(String)resultSet.getString("DRUG_CLASS_OR_DRUG_CODE"));
							
							
						} 
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
					es.printStackTrace() ;
				}
			}
			return aduseDetails;
		}
		public String getDrugClassByOrderId(String drugCode){
			Connection connection       = null ;
	        PreparedStatement pstmt     = null ;
	        ResultSet resultSet         = null ;
			String sql_query			= "";
			String drug_class="";
			try{
				connection = getConnection() ;
				sql_query        = "select DRUG_CLASS from ph_drug where drug_code=?";
				pstmt				= connection.prepareStatement(sql_query) ;
				System.out.println("drugCode.trim()"+drugCode.trim());
				pstmt.setString(1,drugCode.trim());
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					drug_class = resultSet.getString("DRUG_CLASS");
					System.out.println("drugCode.trim()"+drug_class.trim());
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
					es.printStackTrace() ;
				}
			}
			return drug_class;
		}
		
		public String getDrugDescByOrderId(String drugCode){
			Connection connection       = null ;
	        PreparedStatement pstmt     = null ;
	        ResultSet resultSet         = null ;
			String sql_query			= "";
			String drug_class="";
			try{
				connection = getConnection() ;
				sql_query        = "select DRUG_DESC from ph_drug where drug_code=?";
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,drugCode);
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					drug_class = resultSet.getString("DRUG_DESC");
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
					es.printStackTrace() ;
				}
			}
			return drug_class;
		}



		//added for aakh-crf-0140 end

}
