
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law. 
 *****************************************************************************
 *----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		         Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	?				?				?				?					?						?
12/02/2018		IN065426		Prathyusha P				 		                         ML-BRU-CRF-0469 [IN065426]           
07/01/2019		IN068344		Devindra				 		                             Required indication of different item types during dispense/order 
                                                                                             according to patient billing group.
07/01/2019	  	IN061197	     	Manickavasagam 		  									 GHL-CRF-0549 [IN068344] 
28/05/2019	    IN:067951	    Devindra			                                     MMS-KH-CRF-0016 
26/07/2019      IN:070451       B Haribabu          27/07/2019      Manickam                 ML-MMOH-CRF-1408
07/08/2019      IN:071108		B Haribabu                                                   ML-MMOH-CRF-1408
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
11/08/2019		IN070606	     	Manickavasagam 		  							 MMS-KH-CRF-0029 [IN70606] 
25/11/2019		IN071763		Shazana				25/11/2017								 NMC-JD-SCF-0030
4/12/2019		IN071728		Shazana														 SKR-SCF-1294
03/02/2020		IN072187		manickavasagam J												SKR-SCF-1309
28/2/2020		IN072421			Shazana													TBMC-SCF-0163
28/04/2020  	IN:071537       B Haribabu                                        			 GHL-CRF-0614
28/5/2020		IN072649			Shazana													SKR-SCF-1318
29/05/2020		IN072753        Prabha														NMC-JD-CRF-0046
06/08/2020      IN073464  		Prabha			04/08/2020         Manickam					SKR-SCF-1394
23/08/2020		IN073641		Manickavasagam			MMS-KH-CRF-0034 
30/08/2020		IN073795		Manickavasagam			MMS-KH-CRF-0034 
02/09/2020  IN073795                Manickavasagam J                       MMS-KH-CRF-0034.4[73844]
15/09/2020		IN:073757	        Manickavasagam J			     ML-MMOH-SCF-1596
5/11/2020		7510				Shazana										ML-BRU-SCF-2023
09/11/2020		7575	        Manickavasagam J			     ML-MMOH-CRF-1531
10/11/2020		6041				Shazana       							NMC-JD-CRF-0063
20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
23/12/2020		11525					Shazana												NMC-JD-CRF-0063
05/01/2021	 TFS id:7345 Haribabu	      06/01/2021       Manickavasagam J			     MMS-DM-CRF-0177
18/1/2021		IN:11429	        Manickavasagam J			     ML-MMOH-SCF-1692
15/02/2021		IN:14216	        Manickavasagam J			     SKR-SCF-1574
22/2/2021		11772					Shazana							MMS-DM-SCF-0732
3/1/2021		15131					Shazana												NMC-JD-CRF-0063
4/3/2021		15267					Manickavasagam J									ML-MMOH-SCF-1753
16/03/2021   IN15562         Manickavasagam J	 	   			ML-MMOH-SCF-1755
16/04/2021  	TFS id:-16341    Haribabu	 16/04/2021	 	 Manickavasagam J          NMC-JD-CRF-0097
13/05/2021  TFS id:-16701	     Manickavasagam J                               		     RBU-GHL-CRF-0004 
14/06/2021  TFS id:-16806	     Manickavasagam J                               		     ML-MMOH-SCF-1776
z01/11/2021  TFS id:-25733        Prabha 												Common-ICN-0075
18/11/2021		TFS-26007		 Prabha 														 GHL-SCF-1614
25/01/2022		TFS-27719		 Prabha													MMS-DM-CRF-0199
11/4/2022	26251					Shazana														SKR-SCF-1660
22-05-2022    AAKH-CRF-0140     PRATHYUSHA
02/06/2023		MMS-DM-CRF-0239	 Sushant Tambe			
26/06/2023		45530		     Sushant Tambe											ML-BRU-SCF-2229						
---------------------------------------------------------------------------------------------------------------------------------------------------------
 */ 
package ePH ;
import java.io.* ;
import java.util.* ; 
import java.sql.* ;
import javax.rmi.* ;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ; 
import javax.servlet.http.*;
import oracle.sql.*;
import eOR.*;
import eOR.Common.ChkDef; //Added for  HSA-CRF-0147.1  [IN:049419]-RameshGoli	
import ePH.Prescription.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat; 
public class PrescriptionBean_1 extends PhAdapter implements Serializable,eOR.SceduleFreqeuncyInterface {
	private String order_date				= null ; 
	private String OrderRemarks				= null ; 
	private String prn_yn					= null ; 
	protected ArrayList presDetails			= null ; 
	protected ArrayList presItemList		= null ; 
	protected ArrayList amendDetails		= null ; 
	protected ArrayList groupCode			= null ; 
	protected ArrayList orderCode			= null ; 
	protected ArrayList presHeader			= null ; 
	private HashMap scheduleFrequency		= null ;
	protected ArrayList groupRecord			= null ; 
	protected ArrayList OrderID				= null ;
	protected ArrayList orderDetails		= null ; 
	protected ArrayList DrugRemarks			= null ; 
	private int srlNo						= 0;
	protected ArrayList active_orders		= null ; 
	protected ArrayList diag_text			= null ; 
	protected ArrayList copy_prescriptions	= null ;
	protected ArrayList discPrescriptions	= null ;//Added for Bru-HIMS-CRF-403
	protected ArrayList all_drugs			= null ;
	private String AmendOrderRemarks		= null ; 
	private HashMap AmendAllergyRemarks		= null ; 
	private HashMap AmendDoseRemarks		= null ; 
	private HashMap AmendRxRemarks			= null ; 
	private String amendOrderID				= null ; 
	protected ArrayList amendDrugCodes		= null ; 
	private HashMap disp_locn_code			= null ;
	private HashMap Refill_Detail			= null ;
	protected String called_from			= null;
	protected HashMap old_order_det			= null;
	protected String patient_class			= null;
	protected HashMap amend_reason			= new HashMap();
	protected String age_group				= "";
	protected HashMap prn_remarks			= null;
	protected String prn_remarks_values		= null;
	protected String external_patient_id	= null;
	protected String external_ref_facility	= null;
	protected String external_ref_practitioner = null;
	protected String external_date_ref		= null;
	protected String external_remarks		= null;
	protected ArrayList ExternalPresDispCodes = null;
	protected ArrayList ExternalPresDispDesc  = null;
	protected ArrayList exist_orders		= null;
	private HashMap predefined_remarks		= null;
	private HashMap sliding_scale_freq	    = null;
	String locale= null;
	private String trn_group_ref= null;
	private String tokens_generated_yn= null;
	private HashMap schdMap = null;
	private ArrayList curr_medn_drugs = null;
	protected String refill_yn_from_param = null;
	protected String ord_facility_id = null;
	protected String act_patient_class_frm_hdr = null;
	protected String atc_allergy_alert_level = "N";
	protected String bl_decimalFormatString = "#0";
	protected String pat_specialty_code = null;
	protected int drug_profile_count = 0;
	protected int take_home_count    = 0;
	protected int diagnosis_size     = 0;
	protected String totalTaperQtyDisplay     = "N";
	protected String  order_line_number		  		 = null;/* code Added for ML-BRU-SCF-0190[32621] -- Start*/
	protected String  disp_locn_catg		 		 = null;
	protected HashSet  amend_order_line_number	 = null;/* code Added for ML-BRU-SCF-0190[32621] -- End*/
	protected String called_from_amend		= null;/*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/
	protected HashMap amend_reason_temp		= new HashMap(); 
	protected HashMap selectedPrevOrders		= null; 
	public ArrayList currentActiveOrders		= null;  // added for Bru-HIMS-CRF-265 [IN:032315]
	protected String discSel="";
	protected String print_mar_barcode_yn="N", print_mar_label_yn="N";//added for  added for MMS-QH-CRF-0080 [IN:038064]
	protected String CancelDiscConDupOrdersYN="N";//added for Bru-HIMS-CRF-265 [IN:032315] -- begin
	protected String disp_preg_record_yn="";
	protected String pregnency_yn="";
	protected String preg_trimester="";
	protected String witnessForVerbalOrder ="";		// Added for AAKH-CRF-0023[IN:038259] start
	protected String iv_calc_infuse_by ="D";
	private LinkedHashMap selectedCopyDrugs	= null ;//Added for BRU-HIMS-CRF-403  --start
	public ArrayList currentSelectedDrugs		= null;   
	protected ArrayList selecteddrugs = null; 
	protected ArrayList defaultDuration = null;
	protected HashMap  repeatDurationSet = null;
	protected ArrayList takeHomeDates = null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
	protected String print_ord_sht_rule_ind="";//Added for Bru-HIMS-CRF-393_1.0
	protected String  home_leave_checked = null;
	protected String  amend_alternate_yn = "N";//added for  JD-CRF-0198 [IN:058599]
	protected String can_discon_dup_orders_def_sel="N";//added for HSA-CRF-0151 [IN048468]
	protected HashMap hmDiscCancelledOrders = null; //Added for HSA-CRF-0138 [IN:048414]
	protected static String called_from_verbal_order ="N"; //added for PMG2012-CRF-0019 [IN:035859] AutoComplete-start//modified for ghl-crf-0509
	protected static String allow_priv_to_order_yn ="";
	protected static String default_prev_drug_sel ="";
	protected static String drug_seach_autocomplete_yn =""; //added for PMG2012-CRF-0019 [IN:035859] AutoComplete-end
	protected static String preview_rx_yn =""; //added for ML-MMOH-CRF-0341 [IN:057179]
	protected static String preview_auth_status_yn =""; //added for ML-MMOH-CRF-0343 [IN:057182] 
	protected String org_order_id = null;//added for JD-CRF-198
	protected String skip_duplicte_alert_ip_yn = ""; // Added for MO-CRF-20085.1 [IN057392]
	protected String skip_duplicte_alert_op_yn = ""; // Added for MO-CRF-20085.1 [IN057392]
	protected String alterAmendReason = "";//added for JD-CRF-198
	protected String overlap_period_for_op= "";//added for CRF-20085.1
	protected String overlap_period_for_ip= "";//added for CRF-20085.1
	protected String stock_install_yn = "N";// Added for Performance ML-MMOH-SCF-0684
	protected String disp_by_alt_form_yn = ""; //GHL-CRF-549
	protected String allow_alt_for_med_item = "N";// Added for GHL-CRF-0549 [IN:068344] - Start - Devindra
	protected ArrayList external_drugs_tmp = null; // Added for Inc#70652 - Start
	protected String encounter_id = ""; //added for MMS-KH-CRF-0029[IN070606]
	//Added for IN:070451 start
	private String weight = "";
	private String bsa = "";
	private HashMap nonPreferenceRemarks = new HashMap();//GHL-CRF-0618
   //Added for IN:072715  START
	private HashMap dose_remarks=new HashMap();
	private HashMap allergy_remarks=new HashMap();
	private HashMap dup_drug_remarks=new HashMap();
	private HashMap drug_inter_remarks=new HashMap();
	private HashMap food_inter_remarks=new HashMap();
	private HashMap lab_inter_remarks=new HashMap();
	private String take_home_medication_op = "";//added for NMC-JD-CRF-0063 START
	private String opDischMedInd="";
	private String patient_class_tkHome =""; //added for NMC-JD-CRF-0063
	private String opHomeMedicationVal = "";//added for NMC-JD-CRF-0063 [11525]
	//added for jd-crf-0220 start
	private String drugIndicationMdry="";
	//added for ml-mmoh-crf-1748 start
	private String amend_based_order_wise="N";
	// ML-MMOH-CRF-1823 US008- 43528 
	private String quotaLimitCalcReqYN="";
	private String activePrepApplQuotaYN="";
	private HashMap disease_inter_remarks=new HashMap();//Added for MMS-DM-CRF-0229
	
	public String getQuotaLimitCalcReqYN(){
		return quotaLimitCalcReqYN;
	}
	public void setQuotaLimitCalcReqYN(String quotaLimitCalcReqYN){
		this.quotaLimitCalcReqYN = quotaLimitCalcReqYN;
	}
	public String getActivePrepApplQuotaYN(){
		return activePrepApplQuotaYN;
	}
	public void setActivePrepApplQuotaYN(String activePrepApplQuotaYN){
		this.activePrepApplQuotaYN = activePrepApplQuotaYN;
	}
	// ML-MMOH-CRF-1823 US008- 43528 
	public String getAmend_based_order_wise() {
		return amend_based_order_wise;
	}
	public void setAmend_based_order_wise(String amend_based_order_wise) {
		this.amend_based_order_wise = amend_based_order_wise;
	}
	//added for ml-mmoh-crf-1748 end
	public String getDrugIndicationMdry() {
		return drugIndicationMdry;
	}
	public void setDrugIndicationMdry(String drugIndicationMdry) {
		this.drugIndicationMdry = drugIndicationMdry;
	}
	//added for jd-crf-0220 end
	public String getOpHomeMedicationVal() {
		return opHomeMedicationVal; 
	}
	public void setOpHomeMedicationVal(String opHomeMedicationVal) {
		this.opHomeMedicationVal = opHomeMedicationVal;
	}// [11525] END
	public String getPatient_class_tkHome() {
		return patient_class_tkHome; 
	}
	public void setPatient_class_tkHome(String patient_class_tkHome) {
		this.patient_class_tkHome = patient_class_tkHome;
	}
	public String getOpDischMedInd() {
		return opDischMedInd;
	}
	public void setOpDischMedInd(String opDischMedInd) {
		this.opDischMedInd = opDischMedInd;
	}
	public String getTakeHomeMedicationOp() {
		return take_home_medication_op;
	}
	public void setTakeHomeMedicationOp(String take_home_medication_op) {
		this.take_home_medication_op = take_home_medication_op;
	}//NMC-JD-CRF-0063 END
		//Added for IN:072715 END
		private HashMap nonPreferenceRemarksMedicalItem = new HashMap();//GHL-CRF-0618
		private String pre_alloc_appl_yn="";//Added for TFS id:7345
	public void setWeight(String weight) {
		this.weight = weight;
		System.out.println("weight"+weight);
	}
	public String getWeight() {
		return weight;
	}
	public void setBsa(String weight) {
		this.bsa =bsa; 
		System.out.println("bsa"+bsa);
	}
	public String getBsa() {
		return bsa;
	}
	PrescriptionBean presBean =null;
	public void setPresBean(PrescriptionBean presBean) {
		this.presBean = presBean;
	}
	//Added for IN:070451 end
	public ArrayList getExternal_drugs_tmp() {
		if(external_drugs_tmp==null)
			external_drugs_tmp = new ArrayList();
		return external_drugs_tmp;
	}
	public void setExternal_drugs_tmp(ArrayList external_drugs_tmp) {
		if(external_drugs_tmp==null)
			external_drugs_tmp = new ArrayList();
		this.external_drugs_tmp = external_drugs_tmp;
	} // Added for Inc#70652 - End
	protected int reconciliationapp_yn=0;//added for mms-kh-crf-0016
	protected ArrayList external_drugs = null; // Added for MMS-KH-CRF-0016 - Start
	String reconciliation_yn="N";//added for mms-kh-crf-0016
	
	public ArrayList getExternal_drugs() {
		if(external_drugs==null)
			external_drugs = new ArrayList();
		return external_drugs;
	}
	public void setExternal_drugs(ArrayList external_drugs) {
		this.external_drugs = external_drugs;
	} // Added for MMS-KH-CRF-0016 - End
	public String getAllowAltForMedItem() { 
		return allow_alt_for_med_item;
	}
	public void setAllowAltForMedItem(String allow_alt_for_med_item) {
		this.allow_alt_for_med_item = allow_alt_for_med_item;
	} // Added for GHL-CRF-0549 [IN:068344] - End - Devindra
// Added for MMS-KH-CRF-0016
	public int getReconciliationapp_yn() {
		return reconciliationapp_yn;
	}
	public void setReconciliationapp_yn(int reconciliationapp_yn) {
		this.reconciliationapp_yn = reconciliationapp_yn;
	}
	public String getReconciliation_yn() {
		return reconciliation_yn;
	}
	public void setReconciliation_yn(String reconciliation_yn) {
		this.reconciliation_yn = reconciliation_yn;
	}
	//added for mms-kh-crf-0016 end
	
	//added for MMS-KH-CRF-0029[IN070606] - start
	public void setEncounterId(String encounter_id){ 
		this.encounter_id = encounter_id;
	}
	public String getEncounterId(){
		return this.encounter_id;
	}
	//added for MMS-KH-CRF-0029[IN070606] - end
	//AAKH-CRF-0091 starts
	protected HashMap statDrug_Yn			= new HashMap();
	
	public HashMap getStatDrug_Yn() { 
		return statDrug_Yn;
	}
	public void setStatDrug_Yn(String drugcode,int srl_no,String stat_chk_yn) {
		this.statDrug_Yn.put("stat_"+drugcode+srl_no,stat_chk_yn);
		
	}
	
	//AAKH-CRF-0091 ends
// Added for Performance - start ML-MMOH-SCF-0684
	public void setStockInstalledYN(String stock_install_yn){
		this.stock_install_yn = stock_install_yn;
	}
	public String getStockInstalledYN(){
		return stock_install_yn;
	}
// Added for Performance - end
	//Added for AAKH-CRF-0094  start
	protected String paramVolumeCalc ="Y";		
	public String getParamVolumeCalc() {
		return paramVolumeCalc;
	}
	public void setParamVolumeCalc(String paramVolumeCalc) {
		this.paramVolumeCalc = paramVolumeCalc;
	}
//GHL-CRF-549 - start
	public void setParamDispByAltForm(String disp_by_alt_form_yn){
		this.disp_by_alt_form_yn = disp_by_alt_form_yn;
	}

	public String getParamDispByAltForm(){
		return disp_by_alt_form_yn;
	}
	//GHL-CRF-549 - end
	
	//Added for AAKH-CRF-0094 end
	
	
	DispMedicationAllStages all_stages =null;//Added for Bru-HIMS-CRF-072.1[IN 049144] start
	MedicationPlannerBean medplan_bean = null;
	
	public String getSkipDuplicateAlertIp_yn() { // Added for MO-CRF-20085.1 [IN057392] - Start
		return skip_duplicte_alert_ip_yn;
	}
	public void setSkipDuplicateAlertIp_yn(String skip_duplicte_alert_ip_yn) {
			this.skip_duplicte_alert_ip_yn = skip_duplicte_alert_ip_yn;
				}                                   
	public String getSkipDuplicateAlertOp_yn() { 
			return skip_duplicte_alert_op_yn;
				}
	public void setSkipDuplicateAlertOp_yn(String skip_duplicte_alert_op_yn) {
			this.skip_duplicte_alert_op_yn = skip_duplicte_alert_op_yn;
				}                                               // Added for MO-CRF-20085.1 [IN057392] - End
	/**
	 * @return the alterAmendReason//added for  JD-CRF-0198 [IN:058599]
	 */
	public String getAlterAmendReason() {
		return alterAmendReason;
	}

	/**
	 * @param alterAmendReason the alterAmendReason to set//added for  JD-CRF-0198 [IN:058599]
	 */
	public void setAlterAmendReason(String alterAmendReason) {
		this.alterAmendReason = alterAmendReason;
	}
	
	/**
	 * @return the amend_alternate_yn//added for  JD-CRF-0198 [IN:058599]
	 */
	public String getAmend_alternate_yn() {
		return amend_alternate_yn;
	}

	/**
	 * @param amend_alternate_yn the amend_alternate_yn to set//added for  JD-CRF-0198 [IN:058599]
	 */
	public void setAmend_alternate_yn(String amend_alternate_yn) {
		this.amend_alternate_yn = amend_alternate_yn;
	}

	public void setObject(MedicationPlannerBean medplan_bean) {
		this.medplan_bean = medplan_bean;
	}
	
	public void setObject(DispMedicationAllStages all_stages) {
		this.all_stages = all_stages;
	}//Added for Bru-HIMS-CRF-072.1[IN 049144] end

	public void setPreviewAuthStatus(String yes_no){ //added for ML-MMOH-CRF-0343 [IN:057182]
		this.preview_auth_status_yn = yes_no;
	}

	public String getPreviewAuthStatus(){ //added for ML-MMOH-CRF-0343 [IN:057182]
		return this.preview_auth_status_yn;
	}
	
	public void setDrugSeachAutocomplete_yn(String yes_no){ //added for PMG2012-CRF-0019 [IN:035859] AutoComplete -start
		this.drug_seach_autocomplete_yn = yes_no;
	}

	public String getDrugSeachAutocomplete_yn(){
		return this.drug_seach_autocomplete_yn;
	}
	public void setCalled_from_verbal_order(String yes_no){
		this.called_from_verbal_order = yes_no;
	}

	public String getCalled_from_verbal_order(){
		return this.called_from_verbal_order;
	}
	public void setAllow_priv_to_order_yn(String allow_priv_to_order_yn){
		this.allow_priv_to_order_yn = allow_priv_to_order_yn;
	}

	public String getDefaultPrevDrugSel(){
		return this.default_prev_drug_sel;
	}
	public void setDefaultPrevDrugSel(String default_prev_drug_sel){
		this.default_prev_drug_sel = default_prev_drug_sel;
	}

	public String getAllow_priv_to_order_yn(){
		return this.default_prev_drug_sel;
	} //added for PMG2012-CRF-0019 [IN:035859] AutoComplete -end

	public void setPreviewRxYN(String preview_rx_yn){ //added for ML-MMOH-CRF-0341 [IN:057179]
		this.preview_rx_yn = preview_rx_yn;
	}

	public String getPreviewRxYN(){ //added for ML-MMOH-CRF-0341 [IN:057179]
		return this.preview_rx_yn;
	} 
	
	protected String auditTrailReqYN = ""; //Added for HSA-CRF-0147.1 [IN:049419]-RameshGoli -start	
	public String getAuditTrailReqYN() {
		return auditTrailReqYN;
	}
	public void setAuditTrailReqYN(String auditTrailReqYN) {
		this.auditTrailReqYN = auditTrailReqYN;
	} //Added for HSA-CRF-0147.1 [IN:049419]-RameshGoli	-end
	
	public String getHome_leave_checked() {
		return home_leave_checked;
	}
	public void setHome_leave_checked(String home_leave_checked) {
		this.home_leave_checked = home_leave_checked;
	}
	public ArrayList getTakeHomeDates() {
		return takeHomeDates;
	}
	public void setTakeHomeDates(ArrayList takeHomeDates) {
		this.takeHomeDates = takeHomeDates;
	}//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end
	public HashMap getRepeatDurationSet() {
		return repeatDurationSet;
	}
	public void setRepeatDurationSet(HashMap repeatDurationSet) {
		this.repeatDurationSet = repeatDurationSet;
	}
	public ArrayList getDefaultDuration() {
		return defaultDuration;
	}
	public void setDefaultDuration(ArrayList defaultDuration) {
		this.defaultDuration = defaultDuration;
	}
	public ArrayList getSelecteddrugs() {
		return selecteddrugs;
	}
	public void setSelecteddrugs(ArrayList selecteddrugs) {
		this.selecteddrugs = selecteddrugs;//Added for BRU-HIMS-CRF-403 --end
	}
	
	public String getWitnessForVerbalOrder() {
		return witnessForVerbalOrder;
	}
	public void setWitnessForVerbalOrder(String witnessForVerbalOrder) {
		this.witnessForVerbalOrder = witnessForVerbalOrder;
	}												
	protected String witnessByUser ="";	
	public String getWitnessByUser() {
		return witnessByUser;
	}
	public void setWitnessByUser(String witnessByUser) {
		this.witnessByUser = witnessByUser;
	}	// Added for AAKH-CRF-0023[IN:038259] end
	protected String excludeADRAllergyAlert_yn ="";	// Added for HSA-SCF-0011 [IN:042444] start

	public String getExcludeADRAllergyAlert() {
		return excludeADRAllergyAlert_yn;
	}
	public void setExcludeADRAllergyAlert(String excludeADRAllergyAlert_yn) {
		this.excludeADRAllergyAlert_yn = excludeADRAllergyAlert_yn;
	}// Added for HSA-SCF-0011 [IN:042444] end

	public void setTotalTaperQtyDisplay(String totalTaperQtyDisplay) {
		this.totalTaperQtyDisplay = totalTaperQtyDisplay;
	}

	protected String copy_prev_ord_for_dish_medn ="";	//Added for BRU-HIMS-CRF-403 [IN:044541] start
	public String getCopyPrevOrderForDishargeMedn() {
		return copy_prev_ord_for_dish_medn;
	}
	public void setCopyPrevOrderForDishargeMedn(String copy_prev_ord_for_dish_medn) {
		this.copy_prev_ord_for_dish_medn = copy_prev_ord_for_dish_medn;
	}//Added for BRU-HIMS-CRF-403 [IN:044541] end

	public void setCancelDiscConDupOrders(String CancelDiscConDupOrdersYN) {
		 this.CancelDiscConDupOrdersYN=CancelDiscConDupOrdersYN;		 
	}
	public String getCancelDiscConDupOrders() {	
		return this.CancelDiscConDupOrdersYN;
	}//added for Bru-HIMS-CRF-265 [IN:032315] - end

	public void setCancelDiscConDupOrdersDefSelect(String can_discon_dup_orders_def_sel) { //Added for HSA-CRF-0151 [IN048468] -start
		 this.can_discon_dup_orders_def_sel=can_discon_dup_orders_def_sel;		 
	}
	public String getCancelDiscConDupOrdersDefSelect() {	
		return this.can_discon_dup_orders_def_sel; 
	}//added for HSA-CRF-0151 [IN048468] - end

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
	}/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/
	public void setOrderLineNumber(String order_line_number) {/* code Added for ML-BRU-SCF-0190[32621] -- Start*/
		 this.order_line_number=order_line_number;			
	}
	public String getOrderLineNumber() {	
		return this.order_line_number;
	}
	public void setDispLocnCatg(String disp_locn_catg) {
		 this.disp_locn_catg=disp_locn_catg;			
	}
	public String getDispLocnCatg() {	
		return this.disp_locn_catg;
	}
	public void setAmendOrderLineNumber(HashSet amend_order_line_number) {
		 this.amend_order_line_number=amend_order_line_number;			
	}
	public HashSet getAmendOrderLineNumber() {	
		return this.amend_order_line_number;
	}/* code Added for ML-BRU-SCF-0190[32621]-- End*/
	public void setPregnencyYN(String pregnency_yn) { // added for CRF RUT-CRF-0063[29601]
		 this.pregnency_yn=pregnency_yn;			
	}
	public String getPregnencyYN() {	
		return this.pregnency_yn;
	}
	public void setPregTrimester(String trimester) { // added for CRF RUT-CRF-0063[29601]
		 this.preg_trimester=trimester;			
	}
	public String getPregTrimester() {	
		return this.preg_trimester;
	}// adding end for CRF RUT-CRF-0063[29601]
	public ArrayList getCurrentSelectedDrugs() {//Added for BRU-HIMS-CRF-403 [IN:044541] start
		return currentSelectedDrugs;
	}
	public void setCurrentSelectedDrugs(ArrayList currentSelectedDrugs) {
		this.currentSelectedDrugs = currentSelectedDrugs;
	}//Added for BRU-HIMS-CRF-403 [IN:044541] End

	public HashMap getDiscCancelledOrders() {//Added for HSA-CRF-0138 [IN:048414] start
		if(hmDiscCancelledOrders==null)
			hmDiscCancelledOrders = new HashMap();
		return hmDiscCancelledOrders;
	}
	public void setDiscCancelledOrders(HashMap hmDiscCancelledOrders) {
		this.hmDiscCancelledOrders = hmDiscCancelledOrders;
	}//Added for HSA-CRF-0138 [IN:048414] End

//GHL-CRF-0618 - start
	public void setNonPrefernceRemarks(String item_code,String item_remarks){
		this.nonPreferenceRemarks.put(item_code,item_remarks);
	}

	public HashMap getNonPrefernceRemarks(){
		return nonPreferenceRemarks;
	}
//GHL-CRF-0618 - start
	public void setNonPrefernceRemarksMedicalItem(String item_code,String item_remarks){
		this.nonPreferenceRemarksMedicalItem.put(item_code,item_remarks);
	}

	public HashMap getNonPrefernceRemarksMedicalItem(){
		return nonPreferenceRemarksMedicalItem;
	}
//GHL-CRF-0618 - end
//GHL-CRF-0618 - end
	public void setPrintOrdShtRuleInd(String print_ord_sht_rule_ind) {//Added for Bru-HIMS-CRF-393_1.0
		 this.print_ord_sht_rule_ind=print_ord_sht_rule_ind;			
	}
	public String getPrintOrdShtRuleInd() {	
		return this.print_ord_sht_rule_ind;
	}
	public void setOverlapPeriodForIP(String overlap_period_for_ip) {	
		this.overlap_period_for_ip = overlap_period_for_ip;
	}
	public String getOverlapPeriodForIP() {	
		return this.overlap_period_for_ip;
	}
	public void setOverlapPeriodForOP(String overlap_period_for_op) {	
		this.overlap_period_for_op = overlap_period_for_op;
	}
	public String getOverlapPeriodForOP() {	
		return this.overlap_period_for_op;
	}
	
	//Added for TFS-16341-START
	public String getDefaultDispLocnCode() {
		return default_disp_locn_code;
	}
	
	public void setDefaultDispLocnCode(String default_disp_locn_code) {
		this.default_disp_locn_code = default_disp_locn_code;
	}
	
	private String default_disp_locn_code = "";
	//Added for TFS-16341-END
		//Added for TFS id:-16701
	private String call_ext_db_yn = "";
	public String getCalExtDBYN() {
		return call_ext_db_yn;
	}
	public void setCalExtDBYN(String call_ext_db_yn) {
		this.call_ext_db_yn = checkForNull(call_ext_db_yn,"Y");
	}
	public PrescriptionBean_1() {
        try {
			initialize();
			doCommon();
			int i=0;
			while (i < 12) {
				diag_text.add("");
				i++;
			}
        }
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void doCommon() throws Exception {
	}

	public void initialize() {
		presDetails			= new ArrayList();
		takeHomeDates			= new ArrayList();//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		amendDetails		= new ArrayList();
		copy_prescriptions		= new ArrayList();
		discPrescriptions		= new ArrayList();//Added for Bru-HIMS-CRF-403
		selecteddrugs		= new ArrayList();//Added for Bru-HIMS-CRF-403
		defaultDuration		= new ArrayList();//Added for Bru-HIMS-CRF-403
		repeatDurationSet		= new HashMap();//Added for Bru-HIMS-CRF-403
		external_drugs          = new ArrayList(); // Added for MMS-KH-CRF-0016
		external_drugs_tmp      = new ArrayList(); // added for Inc#70652
		amendDrugCodes			= new ArrayList();
		orderCode			= new ArrayList();
		groupCode			= new ArrayList();
		prn_remarks				= new HashMap();
		disp_locn_code			= new HashMap();
		scheduleFrequency	 = new HashMap();
		groupRecord			= new ArrayList();
		presHeader			= new ArrayList();
		OrderID				= new ArrayList();
		orderDetails		= new ArrayList();
		DrugRemarks			= new ArrayList();
		srlNo				= 0;
		active_orders		= new ArrayList();
		diag_text			= new ArrayList();
		presItemList		= new ArrayList();
		Refill_Detail			= new HashMap();
		prn_remarks_values		= "";	
		setDefaultValues();	
		selectedPrevOrders		= new HashMap(); //Added for BRU-HIMS-CRF-403 
		selectedCopyDrugs		= new LinkedHashMap(); //Added for BRU-HIMS-CRF-403 
		home_leave_checked = null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	}
	public void setselectedCopyDrugs(LinkedHashMap selectedCopyDrugs){//Added for BRU-HIMS-CRF-403  start
		this.selectedCopyDrugs = selectedCopyDrugs;
	}
	public LinkedHashMap getselectedCopyDrugs(){
		return this.selectedCopyDrugs;
	}
	public void setSelectedPrevOrders(HashMap selectedPrevOrders){
		this.selectedPrevOrders = selectedPrevOrders;
	}
	public HashMap getSelectedPrevOrders(){
		return this.selectedPrevOrders;
	}
	public void setATCAllergyLevel(String atc_allergy_alert_level){
		this.atc_allergy_alert_level = atc_allergy_alert_level;
	}
	public String getATCAllergyLevel(){
		return this.atc_allergy_alert_level;
	}
	public String getTotalTaperQtyDisplay() {
		return this.totalTaperQtyDisplay;
	}
	public void setPresItemList(ArrayList presItemList) {
		 this.presItemList=presItemList;
	}
	public ArrayList getPresItemList() {
		return this.presItemList;
	}
	public void setCalledFrom(String called_from) {
		 this.called_from=called_from;
	}
	public String getCalledFrom() {
		return this.called_from;
	}
	public void setchkforPRN(String prn_yn) {
		 this.prn_yn=prn_yn;
	}
	public String getchkforPRN() {
		return this.prn_yn;
	}
	public void setAgeGroup(String age_group) {
		this.age_group	=	age_group;
	}
	public String getAgeGroup() {
		return this.age_group;
	}
	public void setOldOrder(String drug_code, String order_id) {
		if(this.old_order_det==null)
			this.old_order_det = new HashMap();
		this.old_order_det.put(drug_code,order_id);
	}
	public void setPatientClass(String patient_class) {
		this.patient_class	=	patient_class;
	}
	public String getPatientClass() {
		return this.patient_class;
	}
	public HashMap getOldOrder() {
		return this.old_order_det;
	}
	public void setExitingOrders(ArrayList exist_orders) {
		this.exist_orders	=	exist_orders;
	}
	public ArrayList getExitingOrders() {
		return this.exist_orders;
	}
	public void setamendOrderID(String order_id){
		 this.amendOrderID=order_id;
	}
	public void setAmendOrderRemarks(String remarks){
		 this.AmendOrderRemarks=remarks;
	}
	public void setAmendAllergyRemarks(String srl_no,String remarks){
		 this.AmendAllergyRemarks.put(srl_no,remarks);
	}
	public void setAmendDoseRemarks(String srl_no,String remarks){
		  this.AmendDoseRemarks.put(srl_no,remarks);
	}
	public void setAmendRxRemarks(String srl_no,String remarks){
		  this.AmendRxRemarks.put(srl_no,remarks);
	}
	public void setPrescriptions(ArrayList copy_prescriptions) {
		this.copy_prescriptions	=	copy_prescriptions;
	}
	public ArrayList getPrescriptions() {
		if(this.copy_prescriptions == null)
			this.copy_prescriptions = new ArrayList();
		return this.copy_prescriptions;	
	}
	
	public void setdiscPrescriptions(ArrayList discPrescriptions) {//Added for Bru-HIMS-CRF-403--start
		this.discPrescriptions	=	discPrescriptions;
	}
	public ArrayList getdiscPrescriptions() {
		if(this.discPrescriptions == null)
			this.discPrescriptions = new ArrayList();
		return this.discPrescriptions;	
	}//Added for Bru-HIMS-CRF-403--end
	
	public ArrayList getLineDetails(){
		return this.all_drugs;
	}
	public String getamendOrderID(){
		return this.amendOrderID;
	}
	public String getAmendOrderRemarks(){
		return this.AmendOrderRemarks;
	}
	public HashMap getAmendAllergyRemarks(){
		 return this.AmendAllergyRemarks;
	}
	public HashMap getAmendDoseRemarks(){
		  return this.AmendDoseRemarks;
	}
	public HashMap getAmendRxRemarks(){
		 return this.AmendRxRemarks;
	}
	public ArrayList getCurrMednDrugs(){
		 return this.curr_medn_drugs;
	}
	public void getclearscheduleFrequency(String code){
		if(scheduleFrequency!=null && scheduleFrequency.containsKey(code)) {
			scheduleFrequency.remove(code);
		}
	}
	public ArrayList getamendDrugCodes(){
		 return amendDrugCodes;
	}
	public ArrayList getScheduleFrequencyStr(String code, String row_value){
		if(scheduleFrequency!=null){
			Object 	 scheduleFrequencyDatasObj	=  scheduleFrequency.get(code);
			if(scheduleFrequencyDatasObj == null)
				return new ArrayList();
			else
			return (ArrayList)scheduleFrequencyDatasObj;
		}
		else 
			return null;
	}
	public void setpresHeader(ArrayList head){
		this.presHeader	= head;
	}
	public ArrayList getpresHeader(){
		return this.presHeader;
	}
	public void setSrlNo(int srl_no){
		this.srlNo	= srl_no;
	}
	public int getSrlNo(){
		return this.srlNo;
	}
	public void setTakeHomeCount(int take_home_count){//added during PE by Naveen
		this.take_home_count	= take_home_count;
	}
	public int getTakeHomeCount(){
		return this.take_home_count;
	}

	public int getDrugProfileCount(){
		return this.drug_profile_count;
	}

	public int getDiagnosisSize(){
		return this.diagnosis_size;
	}
   public String getBLDecimalFormatString(){
		return this.bl_decimalFormatString;
	}//ends here
   public void setBLDecimalFormatString(String bl_decimalFormatString){
		this.bl_decimalFormatString= bl_decimalFormatString;
	}//ends here
	public void setDispLocation(String srl_no, String disp_locn_code ) {
		this.disp_locn_code.put(srl_no,disp_locn_code);
	}
	public void setpresDetails(HashMap details){
	//	this.presDetails.put(details);
	}
	public ArrayList getpresDetails()	{
		return this.presDetails;
	}
	public void setDiagText( ArrayList diag_text) {
		this.diag_text = diag_text;
	}
	public ArrayList getDiagText() {
		return this.diag_text;
	}
	public HashMap getDispLocation() {
		return this.disp_locn_code;
	}
	public String getDispLocation(String srl_no) {
		String disp_locn	=	"";
		if(disp_locn_code.containsKey(srl_no))
			disp_locn	=	(String)disp_locn_code.get(srl_no);
		return disp_locn;
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
	public void  setScheduleDates(HashMap schdMap){
		this.schdMap = schdMap;	
	}
	public HashMap getScheduleDates(){
		return this.schdMap;
	}
	public void setCurrMednDrugs(ArrayList curr_medn_drugs){
		 this.curr_medn_drugs = curr_medn_drugs;
	}
	public String getRefillYNFromParam(){
		return this.refill_yn_from_param;
	}
	public void setRefillYNFromParam(String refill_yn_from_param){
		this.refill_yn_from_param = refill_yn_from_param;
	}
	public void setActPatientClass_frm_Hdr(String act_patient_class_frm_hdr){
		this.act_patient_class_frm_hdr = act_patient_class_frm_hdr;
	}
	public String getIVCalcInfuseBy(){
		return this.iv_calc_infuse_by ;
	}
	public void setIVCalcInfuseBy(String iv_calc_infuse_by){
		this.iv_calc_infuse_by = iv_calc_infuse_by;
	}

	public String getActPatientClass_frm_Hdr(){
		return this.act_patient_class_frm_hdr;
	}
	
	//Added for TFS id:-16341 start
		private boolean default_disp_locn_select_appl=false;
		
		public boolean getDefaultDispLocnSelectAppl() {
			return default_disp_locn_select_appl;
		}

		public void setDefaultDispLocnSelectAppl(boolean default_disp_locn_select_appl) {
			this.default_disp_locn_select_appl = default_disp_locn_select_appl;
		}
	//Added for TFS id:-16341 end
		
		
//added for CRF-198 - start
	public void setParentOrderIdForAltOrder(String order_id){
		this.org_order_id = order_id;
	}
	public String getParentOrderIdForAltOrder(){
		return	this.org_order_id;
	}  
	//added for CRF-198 - end
	//Added for TFS id:7345 start
	public String getPreAllocApplYN() {
		return this.pre_alloc_appl_yn;
	}
	public void setPreAllocApplYN() {
		 Connection connection    = null;
		  PreparedStatement pstmt = null;
		  ResultSet resultSet        = null;
		  String pre_alloc_appl_yn="";
		 
		  try {
		      connection            = getConnection();
		 
		  pstmt = connection.prepareStatement("SELECT PRE_ALLOC_APPL FROM PH_FACILITY_PARAM WHERE FACILITY_ID = ?");
		  pstmt.setString(1,login_facility_id);
		  resultSet = pstmt.executeQuery() ;
		  if(resultSet!=null && resultSet.next()){                   
			  pre_alloc_appl_yn = resultSet.getString("PRE_ALLOC_APPL");   
		      if(pre_alloc_appl_yn==null)
		    	  pre_alloc_appl_yn="N";
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
		
		
		this.pre_alloc_appl_yn = pre_alloc_appl_yn;
	}
	//Added for TFS id:7345 end
	public boolean  setScheduleFrequencyStr(Hashtable ht){
		try{
			String code 			= (String)ht.get("code");
			ArrayList	  scheduleFrequencyDatas	=	(ArrayList)ht.get(code);
			if (scheduleFrequencyDatas == null){
				scheduleFrequencyDatas	=	new ArrayList();
				String duration_type 	= (String)ht.get("durationType");
				int repeat        		=  Integer.parseInt(checkForNull((String)ht.get("repeat"),"0"));
				ArrayList day_list	= new ArrayList();
				ArrayList day_names	= new ArrayList();
				ArrayList time_list	= new ArrayList();
				ArrayList dose_list	= new ArrayList();
				ArrayList<String> week_days	= new ArrayList<String>();
				String time_value	= (String)ht.get("time1");
				HashMap freq_char_list	 = new HashMap();
				String dose_val = null;
				String temp = null;
				freq_char_list.put("called_from",ht.get("called_from"));
				freq_char_list.put("repeat",repeat);
				freq_char_list.put("durationType",duration_type);
				freq_char_list.put("start_date_time",ht.get("start_date_time"));
				freq_char_list.put("end_date_time",ht.get("end_date_time"));
				locale= getLanguageId()==null?"en":getLanguageId();
				String start_day_param1 = com.ehis.util.DateUtils.convertDate((String)ht.get("start_day_param"), "DMY",locale, "en");
				week_days = getDayOfWeek(start_day_param1); 
				Connection connection	= null;
				PreparedStatement pstmt = null;
				ResultSet resultSet		= null;
				try{
					connection			= getConnection();
					pstmt	= connection.prepareStatement("Select RTRIM(rtrim(to_char(?, 'fm999999990.999999'),'0'),'.') DOSE_VAL from dual"); // 999999990.999999 changed to fm999999990.999999 for ARYU-SCF-0094

					for(int j=1 ; j <= repeat ; j++){
						if(duration_type.equals("D")){
							day_list.add("0");	
						}
						else{
							
							if(!ht.get("admin_day"+(j)).equals("")){
								day_list.add(ht.get("admin_day"+(j)));
							}else{
								day_list.add("0");
							}
						}	
						if(!duration_type.equals("D")){
							if(!ht.get("admin_day"+(j)).equals("")){
								temp = (String)ht.get("admin_day"+(j));
								if (temp == null || temp.equals("")){
									temp = "0";
								}
								if (!temp.equals("0")) {
									
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
						dose_val = ht.get("qty"+j) == null?"":(String)ht.get("qty"+j);//added for IN25920 --28/01/2011-- priya
						if(!(dose_val.equals(""))){
							try {
								pstmt.setString(1, dose_val);
								resultSet	= pstmt.executeQuery();
								if (resultSet != null && resultSet.next()){
										dose_val	=	resultSet.getString("DOSE_VAL");
									}
							} 
							catch(Exception e){
									e.printStackTrace();
							}
						}
						dose_list.add(dose_val); //added for IN25920 --28/01/2011-- priya -end
					}
				}
				catch(Exception e){
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
				scheduleFrequencyDatas.add(freq_char_list);
				scheduleFrequencyDatas.add(day_list);
				scheduleFrequencyDatas.add(day_names);
				scheduleFrequencyDatas.add(time_list);
				scheduleFrequencyDatas.add(dose_list);	
			}
			scheduleFrequency.put(code,scheduleFrequencyDatas);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	 public ArrayList<String> getDayOfWeek(String sDate) {
		String[] Days={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		ArrayList<String> dayList = new ArrayList<String>();	
		java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date d = new java.util.Date();
		try {
			if (sDate != null && !sDate.equals("")){			
				df.setLenient(false);
				d = df.parse(sDate);
				int x = d.getDay();
				int y = Days.length;
				for (int i = x;i<y ;i++ ){
					dayList.add(Days[i]);
					if (i==Days.length-1){
						for (int j = 0;j<x ;j++ ){
							dayList.add(Days[j]);
						}					
					}
			   }	   		
		   }
		} catch(java.text.ParseException e) {
			e.printStackTrace();
			return null;
		}
		return dayList; 
	}

	public void addScheduleFrequencyStr(ArrayList schedule,String code){
		scheduleFrequency.put(code,schedule);
	}

	public HashMap getscheduleFrequency(){
		return this.scheduleFrequency;

	}
	public void setActiveOrders(ArrayList active_order)	{
		this.active_orders	=	(ArrayList)active_order.clone();
	}

	public void setRefillDetail(String srl_no,HashMap Refill_Detail) {
		this.Refill_Detail.put(srl_no,Refill_Detail);
	}
	public HashMap getRefillDetail(String srl_no) {
		HashMap ref_det	=	new HashMap();
		if(this.Refill_Detail.containsKey(srl_no))
			ref_det	=	(HashMap)this.Refill_Detail.get(srl_no);
		return ref_det;
	}
	//Added for IN:069886
	public void removeRefillDetail(String srl_no) {
		if(this.Refill_Detail.containsKey(srl_no)){
			this.Refill_Detail.remove(srl_no);
		}
		}
		//Added for IN:069886
	public ArrayList getActiveOrders()	{
		return this.active_orders;
	}

	public int getHomeMecdicationYn(String encounter_id,String facility_id){//getting HomeMecdicationYn
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		encounter_id = encounter_id.trim();
		this.take_home_count             = 0;
		try{
			connection = getConnection() ;
			sql_query           = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT11");
			pstmt				= connection.prepareStatement(sql_query) ;

			if(encounter_id == "" || encounter_id == null ||encounter_id.equals("DUMMYENCOUNTERID"))
				encounter_id = "0";
			pstmt.setString(1,encounter_id);
			pstmt.setString(2,facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				this.take_home_count=resultSet.getInt(1);
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
		return this.take_home_count;
	}

	public boolean checkSplit(ArrayList frequencyValues) {
		boolean found		=	false;
		boolean firstTime	=	true;
		String tmp			=	"";
		String admin_qty	=	null;
		ArrayList dose_list	=   new ArrayList();
		if(frequencyValues!=null && frequencyValues.size()>0){				
			dose_list =  (ArrayList)frequencyValues.get(4);
			for(int n=0;n<dose_list.size();n++){
				admin_qty	= ((String)dose_list.get(n)).trim();
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

	public void setOrderDate(String order_date)	{//setting the order date for Current Rx
		this.order_date	=	order_date;
	}
	public String getOrderDate(){
		return this.order_date;
	}

	public void savePresRemarks(String remarks)	{
		this.OrderRemarks	=remarks;
	}
	public String getPresRemarks()	{//for getting the order remarks from bean
		return this.OrderRemarks;
	}

	public ArrayList getPrescribedRemarks(String orig_order_id,String orig_order_line_no) {
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		locale= getLanguageId()==null?"en":getLanguageId();
		
		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT5") ) ;
			pstmt.setString(1,orig_order_id);
			pstmt.setString(2,orig_order_line_no);
			pstmt.setString(3,locale);

			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
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
			records.add(e.toString());
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
		return records;	
	}

	public ArrayList loadAmendDetails(String order_id,String patient_id, String order_line_no,String called_from, String resp_id){
		Connection connection			 = null ;
		PreparedStatement pstmt			 = null ;
		PreparedStatement pstmt1			 = null ;
		PreparedStatement pstmt_sld			 = null ;
		PreparedStatement pstmt_oth			  = null ; //MO-GN-5533
		ResultSet resultSet				 = null ;
		ResultSet resultSetChk				 = null ;
		ResultSet resultSet1			 = null ;
		ResultSet resultSet_sld			 = null ;
		ResultSet	result				 = null ;
		ResultSet result_oth			 = null;//MO-GN-5533
		CallableStatement cstmt			 = null;
		String sql_query				 = "";
		String sql_query_oth			 = "";//MO-GN-5533
		presDetails						 = new ArrayList();
		amendDetails					 = new ArrayList();
		amendDrugCodes					 = new ArrayList();
		String sql_str					 = "";
		String disp_locn_code			 = "";
		String drug_end_date			 = "";
		String patient_class			 = "";
		String strength_value			 = "";
		String proc_qty_value		     = "";	
		String repeat_value				 = "";
		String dosage_type				 = "";
		String drugCode="";
		String source_code				 = ""; 
		String priority					 = ""; 
		String form_code				 = "";
		HashMap DrugDetails				 = new HashMap();
		HashMap presamendDetails		 = new HashMap();
		HashMap stock_dtls				 = null;
		String calc_dflt_dosage_by_htwt	 = "";
		String trade_code                = "";
		String date_str					 ="";
		String fract_dose_appl_yn		 = "";
		String bl_incl_excl_override_reason_code = "";
		String generic_id = "";
		int count_rx = 0;
		String freq_durn_value			  =  "";
		HashMap pat_dtls	= null;
		String	age			= null;
		String sex			= null;
		String age_in_mints			= null;
		String drug_db_duptherapy_yn   ="";
		String drug_db_allergy_check_yn = "";
		String atc_allergy_alert_level = "N"; //Code Added for	RUT-CRF-0065 IN 29603
		HashMap temp= null;
		locale= getLanguageId()==null?"en":getLanguageId();
		String preg_yn=getPregnencyYN();
		String trimester=getPregTrimester();
		String duplicate_check_at_atc_yn="";
		
		String ext_disp_appl_yn ="";//added for NMC-JD-CRF-0046
		
		try{
			connection = getConnection() ;
			String licence=(String)(PhLicenceRights.getKey());
			String act_pat_class = getActPatientClass_frm_Hdr();//added for for ML-BRU-SCF-0898 [IN:041176] -- begin
			if(act_pat_class==null||act_pat_class.equals(""))
				act_pat_class=getPatientClass();
			if( getAmend_based_order_wise().equals("N")  && getCalledFromAmend().equals("PH")  &&  getDispLocnCatg().equals("O"))//if condition and its statements added for  forML-BRU-SCF-0190[32621]/getAmend_based_order_wise ADDED FOR ML-MMOH-CRF-1748
				sql_str	=	"  AND OL.ORDER_LINE_NUM='"+getOrderLineNumber()+"'";
			/*else if(called_from.equals("RENEW_ORDER")) //Commented for Bru-HIMS-CRF-400 [IN:044502]
				if(!order_line_no.equals("")){
					sql_str	=	"  AND OL.ORDER_LINE_NUM='"+order_line_no+"'";
				}
				sql_str	=	"  AND (O.ORDER_ID || '_' ||OL.ORDER_LINE_NUM ) in (?)";
			}*/
			else if(!order_line_no.equals("")){
				sql_str	=	" AND OL.ORDER_LINE_NUM='"+order_line_no+"' AND OL.ORDER_LINE_STATUS IN('OS','RG','PO') ";
			}
			else if(!called_from.equals("RENEW_ORDER")){ //Added for Bru-HIMS-CRF-400 [IN:044502]
				if(getAmend_based_order_wise().equals("Y")){//getAmend_based_order_wise ADDED FOR ML-MMOH-CRF-1748
					sql_str	=	"  AND OL.ORDER_LINE_STATUS IN('OS','RG','VF') ";// ,'UC' Added for ML-BRU-SCF-1096
				}
				else{
					sql_str	=	"  AND OL.ORDER_LINE_STATUS IN('OS','RG','PO','VF','PS','UC') ";// ,'UC' Added for ML-BRU-SCF-1096
				}
			}//,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = D.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN added for mms-DM-crf-0204
			//if(licence.equals("PH")){
				sql_query = "SELECT  OL.ORDER_ID, OL.ORDER_LINE_NUM, D.DRUG_DESC,D.DRUG_CLASS,  D.PRES_BASE_UOM, D.FRACT_DOSE_ROUND_UP_YN,D.CALC_DEF_DOSAGE_YN, D.CONTENT_IN_PRES_BASE_UOM,D.STRENGTH_VALUE,D.STRENGTH_UOM,  D.STRENGTH_PER_PRES_UOM, D.STRENGTH_PER_VALUE_PRES_UOM,D.STOCK_UOM,D.PRN_DOSES_PRES_PRD_FILL,   OLPH.DOSAGE_TYPE,  OT.LONG_DESC,  PDP.DURN_TYPE ,  O.PATIENT_ID,  O.ENCOUNTER_ID,O.ORD_PRACT_ID,  FREQ.SCHEDULED_YN,  DECODE(FREQ.REPEAT_VALUE,  0,  1,  NULL,  1,  FREQ.REPEAT_VALUE) REPEAT_VALUE, FREQ.INTERVAL_VALUE, TO_CHAR(O.ORD_DATE_TIME,  'dd/mm/yyyy hh24:mi')ORD_DATE_TIME,  PR.PRACTITIONER_NAME,  DECODE(OL.PRIORITY,  'R',  'routine',  'U',  'urgent') PRIORITY,  O.CHILD_ORDER_YN,  O.SOURCE_TYPE,  O.SOURCE_CODE,  FREQ.FREQ_CODE,FREQ.INTERVAL_VALUE,  O.PERFORMING_DEPTLOC_CODE DISP_LOCN_CODE ,O.ORDER_STATUS,  DL.SHORT_DESC DISP_LOCN_DESC,  OL.ORDER_CATALOG_CODE DRUGCODE,  OL.QTY_VALUE,  OL.QTY_UNIT,  OL.DURN_VALUE,  DURTYPE.DURN_TYPE DURNTYPE, DURTYPE.DURN_DESC,  OL.CATALOG_DESC,  TO_CHAR(OL.START_DATE_TIME,  'dd/mm/yyyy hh24:mi')START_DATE_TIME,  FRM.FORM_DESC,  FRM.FORM_CODE, OL.ROUTE_CODE, RO.ROUTE_DESC,  FREQ.FREQ_DESC,  FREQ.FREQ_NATURE,  OL.LINE_FIELDS_DISPLAY_TEXT,  TO_CHAR(OL.END_DATE_TIME,  'dd/mm/yyyy hh24:mi')END_DATE_TIME,  OL.ORDER_LINE_NUM,OL.ORDER_QTY,  OL.ORDER_UOM,   (SELECT SHORT_DESC FROM AM_UOM_LANG_VW AM_UOM WHERE UOM_CODE=OL.QTY_UNIT AND AM_UOM.LANGUAGE_ID = ?) STRENGTH_UOM_DESC,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW AM_UOM WHERE UOM_CODE=OL.ORDER_UOM AND AM_UOM.LANGUAGE_ID = ?) STOCK_UOM_DESC,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW AM_UOM WHERE UOM_CODE=OL.QTY_UNIT AND AM_UOM.LANGUAGE_ID = ?) SHORT_DESC,  OL.CONT_ORDER_IND,  OL.REFILL_SINGLE_CONT_ORDER_YN,  OL.NUM_OF_REFILLS,  OL.PARENT_ORDER_LINE_NUM,  PDP.STRENGTH,  PDP.STRENGTH_UOM_CODE STRENGTHUOM,  DIAG_TEXT,  PDP.ALLERGY_OVERRIDE_REASON,  PDP.DOSAGE_LIMIT_OVERRIDE_REASON,  PDP.DUPLICATE_DRUG_OVERRIDE_REASON, PDP.INTERACTION_OVERRIDE_REASON, OLPH.TAPERED_YN,  GN.GENERIC_ID,  GN.GENERIC_NAME,  DECODE(PDP.ALLERGY_OVERRIDE_REASON,  NULL,  'N',  'Y')ALLERGY_YN ,  O.ORDER_TYPE_CODE,  OT.SHORT_DESC ORDERTYPEDESC,  PDP.SPLIT_YN,  PDP.SPLIT_DOSE_PREVIEW,  O.DISCHARGE_IND TAKEHOME,  DECODE(OL.CHILD_ORDER_YN,  'Y',  TO_CHAR(OL.START_DATE_TIME,  'dd/mm/yyyy hh24:mi')) REFILL_START_DATE_TIME,  DECODE(OL.CHILD_ORDER_YN,  'Y',  TO_CHAR(OL.END_DATE_TIME,  'dd/mm/yyyy hh24:mi')) REFILL_END_DATE_TIME,  PDP.PRESCRIBED_MODE,  PDP.HEIGHT, PDP.HEIGHT_UOM, PDP.WEIGHT, PDP.WEIGHT_UOM, PDP.BSA,O.PATIENT_CLASS, PDP.PRN_REMARKS,PDP.PRN_REMARKS_CODE, PDP.CONTRAIND_OVERRIDE_REASON, PDP.INTERACTION_OVERRIDE_REASON,  D.CALC_DOSG_BY_FREQ_DURN_YN,FRACT_DOSE_APPL_YN,D.ITEM_CODE,OLPH.BL_INCL_EXCL_OVERRIDE_VALUE,OLPH.BL_INCL_EXCL_OVERRIDE_REASON, D.IN_FORMULARY_YN, O.BILL_YN,OLPH.SLIDING_SCALE_YN, FREQ.REPEAT_DURN_TYPE FREQ_DURN_TYPE,ORDERING_FACILITY_ID,ph_get_ext_prod_drug_code(d.drug_code,ORDERING_FACILITY_ID)EXTERNAL_PRODUCT_ID, D.BILLABLE_ITEM_YN, OLPH.BUILD_MAR_YN,D.DEFAULT_DOSAGE_BY,OLPH.DRUG_INDICATION, D.NPB_DRUG_YN,O.HOME_LEAVE_MEDN_YN HOME_LEAVE,OLPH.PREGNANCY_OVERRIDE_REASON,D.PREG_CATEGORY_GROUP_CODE,D.PREG_EFFECT_FT,D.PREG_EFFECT_ST,D.PREG_EFFECT_TT,D.PREG_WARN_REQ_FT_YN,D.PREG_WARN_REQ_ST_YN,D.PREG_WARN_REQ_TT_YN,D.PREG_CATEGORY_CODE1,D.PREG_CATEGORY_CODE2,D.PREG_CATEGORY_CODE3,PG.CATEGORY_GROUP_DESC, OLPH.MAR_BARCODE_ID, O.TRN_GROUP_REF ,OL.PREV_ORDER_LINE_STATUS,DEFAULT_DOSAGE_BY_YN,OLPH.ALLOW_ALTERNATE_YN, LAB_INTERACT_OVERRIDE_REASON,FOOD_INTERACT_OVERRIDE_REASON,ALLERGY_OVERRIDE_REASON_CODE,DOSE_LIMIT_OVER_REASON_CODE,DUP_DRUG_OVERRIDE_REASON_CODE, INTER_OVERRIDE_REASON_CODE,LAB_INTER_OVERRIDE_REASON_CODE,FOOD_INTR_OVERRIDE_REASON_CODE,OLPH.ABUSE_EXISTS,OLPH.ABUSE_DRUG_OVERRIDE_REASON,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = D.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN,DISEASE_INTER_OVERRIDE_REASON,DISEASE_INTER_REASON_CODE   FROM  OR_ORDER O,OR_ORDER_TYPE_LANG_VW OT,AM_PRACTITIONER_LANG_VW PR,OR_ORDER_LINE OL,   PH_FORM_LANG_VW FRM,PH_ROUTE_LANG_VW RO,PH_GENERIC_NAME_LANG_VW GN,AM_FREQUENCY_LANG_VW FREQ,    AM_DURATION_TYPE_LANG_VW DURTYPE,AM_UOM_LANG_VW UOM,PH_PATIENT_DRUG_PROFILE PDP ,     PH_DISP_LOCN_LANG_VW DL,OR_ORDER_LINE_PH OLPH,PH_DRUG_LANG_VW D,PH_PREGN_CAT_GROUP_HDR PG WHERE O.ORDER_TYPE_CODE=OT.ORDER_TYPE_CODE AND  O.PERFORMING_DEPTLOC_CODE = DL.DISP_LOCN_CODE AND  O.ORD_PRACT_ID=PR.PRACTITIONER_ID   AND  OL.FORM_CODE=FRM.FORM_CODE AND  OL.ROUTE_CODE=RO.ROUTE_CODE   AND  OL.FREQ_CODE=FREQ.FREQ_CODE AND  OL.DURN_TYPE=DURTYPE.DURN_TYPE AND  OL.QTY_UNIT=UOM.UOM_CODE AND PDP.ORIG_ORDER_LINE_NO=OL.ORDER_LINE_NUM AND  PDP.ORIG_ORDER_ID=O.ORDER_ID AND  O.ORDER_ID=OL.ORDER_ID AND D.PREG_CATEGORY_GROUP_CODE = PG.CATEGORY_GROUP_CODE(+) ";//added DEFAULT_DOSAGE_BY_YN parameter for  AAKH-CRF-089 DRUG_INDICATION  Added for  ML-BRU-CRF-072[Inc:29938] Added OL.PREV_ORDER_LINE_STATUS for M;-BRU-SCF-1325,Modified for IN:072715
				//ALLOW_ALTERNATE_YN added for GHL-CRF-0549
				//LAB_INTERACT_OVERRIDE_REASON,FOOD_INTERACT_OVERRIDE_REASON added for MMS-KH-CRF-0029//DISEASE_INTER_OVERRIDE_REASON,DISEASE_INTER_REASON_CODE Added for MMS-DM-CRF-0229

				if(called_from.equals("RENEW_ORDER")) { //if block and else condition added for Bru-HIMS-CRF-400 [IN:044502]
					sql_query +="  AND (O.ORDER_ID || ',' ||OL.ORDER_LINE_NUM ) in ('"+order_id+"')";
				}
				else  {
					if(!getTotalTaperQtyDisplay().equals("Y"))
						sql_query += "AND O.ORDER_ID=? ";
					else
						sql_query += "AND (O.ORDER_ID=? OR OLPH.TAPER_ORDER_ID=?)";
				}
				sql_query +=	"AND  O.PATIENT_ID=? AND  GN.GENERIC_ID=PDP.GENERIC_ID AND    DL.FACILITY_ID=O.performing_facility_id AND   O.ORDER_ID=OLPH.ORDER_ID AND   D.DRUG_CODE=OL.ORDER_CATALOG_CODE AND OL.ORDER_LINE_NUM = OLPH.ORDER_LINE_NUM AND OT.LANGUAGE_ID = PR.LANGUAGE_ID AND OT.LANGUAGE_ID = FRM.LANGUAGE_ID AND OT.LANGUAGE_ID = RO.LANGUAGE_ID AND OT.LANGUAGE_ID = GN.LANGUAGE_ID AND OT.LANGUAGE_ID = FREQ.LANGUAGE_ID AND OT.LANGUAGE_ID = DURTYPE.LANGUAGE_ID AND OT.LANGUAGE_ID = UOM.LANGUAGE_ID AND OT.LANGUAGE_ID = DL.LANGUAGE_ID AND OT.LANGUAGE_ID = D.LANGUAGE_ID AND OT.LANGUAGE_ID = ?"+sql_str+" ORDER BY OL.ORDER_LINE_NUM"; //add DEFAULT_DOSAGE_BY for SKR-CRF-PHIS-003[IN028182] , OLPH.BUILD_MAR_YN added for SRR20056-SCF-7882 -29157 added HOME_LEAVE for the CRF Bru-HIMS-CRF-093[29960]
			/*}
			else{
				sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT21B") +sql_str+" ORDER BY OL.ORDER_LINE_NUM";
			}*/
			pstmt				= connection.prepareStatement(sql_query) ;
			int i=1;
			pstmt.setString(i++,patient_id);
			pstmt.setString(i++,getLanguageId());
			pstmt.setString(i++,getLanguageId());
			pstmt.setString(i++,patient_id);//pstmt.setString(i++,getLanguageId()); //Modified for MMS-DM-CRF-0239
			if(!called_from.equals("RENEW_ORDER")) //if condition Added for Bru-HIMS-CRF-400 [IN:044502]
				pstmt.setString(i++,order_id);
			if(getTotalTaperQtyDisplay().equals("Y"))
				pstmt.setString(i++,order_id);
			pstmt.setString(i++,patient_id);
			/*if(licence.equals("PH")){
				pstmt.setString(6,getLanguageId());
			}
			else*/
			pstmt.setString(i++,getLanguageId());
			resultSet			= pstmt.executeQuery();
			i=1;
			String order_line_num		 = "";
			ArrayList sldscale_tmpl_dtl = new ArrayList();
			String srl_no				= "";
			String range_from			= "";
			String range_to				= "";
			String admin_units			= "";
			String remarks				= "";
			String prn_remarks_code		= "";
			String consider_stock_for_pres_yn	="";
			String allow_pres_without_stock_yn	="";
			String drug_db_interface_yn	=""; 
			while(resultSet.next())	{
				DrugDetails				= new HashMap();
				presamendDetails		= new HashMap();
				disp_locn_code			= "";
				drug_end_date			= "";
				prn_remarks_values="";

				presamendDetails.put("SRL_NO",""+i);
				DrugDetails.put("SRL_NO",""+i);
				DrugDetails.put("DRUG_CODE",(resultSet.getString("DRUGCODE")==null ? "":resultSet.getString("DRUGCODE")));
				DrugDetails.put("ITEM_CODE",(resultSet.getString("ITEM_CODE")==null ? "":resultSet.getString("ITEM_CODE")));
				drugCode =resultSet.getString("DRUGCODE")==null ? "":resultSet.getString("DRUGCODE");
				if(!amendDrugCodes.contains(drugCode)){
					amendDrugCodes.add(drugCode);
					amendDrugCodes.add(i+"");
				}
				DrugDetails.put("SOURCE_CODE",(resultSet.getString("SOURCE_CODE")==null ? "":resultSet.getString("SOURCE_CODE")));
				source_code=DrugDetails.get("SOURCE_CODE").toString();
				DrugDetails.put("ORDERING_FACILITY_ID",(resultSet.getString("ORDERING_FACILITY_ID")==null ? "":resultSet.getString("ORDERING_FACILITY_ID"))); //SHYAMPRIYA
				ord_facility_id = resultSet.getString("ORDERING_FACILITY_ID")==null ? "":resultSet.getString("ORDERING_FACILITY_ID");
				//DrugDetails.put("ORDER_ID",order_id);
				DrugDetails.put("ORDER_ID",checkForNull(resultSet.getString("ORDER_ID")));
				order_line_num = checkForNull(resultSet.getString("ORDER_LINE_NUM"));
				DrugDetails.put("ORDER_LINE_NUM",order_line_num);
				order_line_no = checkForNull(resultSet.getString("ORDER_LINE_NUM"));
				DrugDetails.put("DRUG_DESC",(resultSet.getString("DRUG_DESC")==null ? "":resultSet.getString("DRUG_DESC")) );
				DrugDetails.put("DRUG_CLASS",(resultSet.getString("DRUG_CLASS")==null ? "":resultSet.getString("DRUG_CLASS")) );
				DrugDetails.put("LONG_DESC",(resultSet.getString("LONG_DESC")==null ? "":resultSet.getString("LONG_DESC")) );
				DrugDetails.put("PATIENT_ID",(resultSet.getString("PATIENT_ID")==null ? "":resultSet.getString("PATIENT_ID")));
				DrugDetails.put("ENCOUNTER_ID",(resultSet.getString("ENCOUNTER_ID")==null ? "":resultSet.getString("ENCOUNTER_ID")));
				DrugDetails.put("IN_FORMULARY_YN",(resultSet.getString("IN_FORMULARY_YN")==null ? "N":resultSet.getString("IN_FORMULARY_YN")));
				DrugDetails.put("PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")));
				DrugDetails.put("CALC_DOSG_BY_FREQ_DURN_YN",(resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")==null ? "":resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")));
				DrugDetails.put("BILL_YN",(resultSet.getString("BILL_YN")==null ? "":resultSet.getString("BILL_YN")));
				DrugDetails.put("CONTRAIND_OVERRIDE_REASON",(resultSet.getString("CONTRAIND_OVERRIDE_REASON")==null ? "":resultSet.getString("CONTRAIND_OVERRIDE_REASON")));
				DrugDetails.put("INTERACTION_OVERRIDE_REASON",(resultSet.getString("INTERACTION_OVERRIDE_REASON")==null ? "":resultSet.getString("INTERACTION_OVERRIDE_REASON")));
				DrugDetails.put("BL_OVERRIDE_EXCL_INCL_IND",(resultSet.getString("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":resultSet.getString("BL_INCL_EXCL_OVERRIDE_VALUE")));
				bl_incl_excl_override_reason_code = resultSet.getString("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":resultSet.getString("BL_INCL_EXCL_OVERRIDE_REASON");
				DrugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);
				DrugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC","");
				DrugDetails.put("EXTERNAL_PRODUCT_ID",(resultSet.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet.getString("EXTERNAL_PRODUCT_ID")) );
				DrugDetails.put("BILLABLE_ITEM_YN",(resultSet.getString("BILLABLE_ITEM_YN")==null ? "Y":resultSet.getString("BILLABLE_ITEM_YN")) );
				DrugDetails.put("BUILDMAR_YN",(resultSet.getString("BUILD_MAR_YN")==null ? "Y":resultSet.getString("BUILD_MAR_YN"))); //added for SRR20056-SCF-7882 -29157
				DrugDetails.put("DRUG_INDICATION",(resultSet.getString("DRUG_INDICATION")==null ? "":resultSet.getString("DRUG_INDICATION")) );//DRUG_INDICATION  Added for  ML-BRU-CRF-072[Inc:29938] 
				DrugDetails.put("NPB_DRUG_YN",(resultSet.getString("NPB_DRUG_YN")==null ? "":resultSet.getString("NPB_DRUG_YN")) );//NPB_DRUG_YN  Added for  ML-BRU-CRF-070[Inc:29935] 
				DrugDetails.put("PREG_DRUG_REMARKS",(resultSet.getString("PREGNANCY_OVERRIDE_REASON")==null ? "":resultSet.getString("PREGNANCY_OVERRIDE_REASON")) ); //added for  RUT-CRF-0063 [IN:029601] -start
				DrugDetails.put("ABUSE_OVERRIDE", (resultSet.getString("ABUSE_EXISTS")==null ? "":resultSet.getString("ABUSE_EXISTS")));//ADDED FOR AAKH-CRF-0140
				DrugDetails.put("abuse_drug_override_reason", (resultSet.getString("abuse_drug_override_reason")==null ? "":resultSet.getString("abuse_drug_override_reason")));//ADDED FOR AAKH-CRF-0140
				DrugDetails.put("abuse_override_remarks", (resultSet.getString("abuse_drug_override_reason")==null ? "":resultSet.getString("abuse_drug_override_reason")));//ADDED FOR AAKH-CRF-0140
				
				
				disp_locn_code = resultSet.getString("DISP_LOCN_CODE")==null ? "":resultSet.getString("DISP_LOCN_CODE"); //Added For NMC-JD-CRF-0046-Amend order
				
				DrugDetails.put("DISP_LOCN_CODE",disp_locn_code);//ADDED for ml-mmoh-crf-0863
				
				ext_disp_appl_yn = getExtDispYN(disp_locn_code);// added for NMC-JD-CRF-0046-Amend order
				

				DrugDetails.put("ALLOW_ALTERNATE_YN",(resultSet.getString("ALLOW_ALTERNATE_YN")==null ? "":resultSet.getString("ALLOW_ALTERNATE_YN")));//added for GHL-CRF-0549
				if(preg_yn.equals("Y")){
					DrugDetails.put("PREG_CATEGORY_GROUP_CODE",(resultSet.getString("PREG_CATEGORY_GROUP_CODE")==null ? "":resultSet.getString("PREG_CATEGORY_GROUP_CODE")));
					DrugDetails.put("CATEGORY_GROUP_DESC",(resultSet.getString("CATEGORY_GROUP_DESC")==null ? "":resultSet.getString("CATEGORY_GROUP_DESC")));
					if(trimester.equals("First Trimester")){
						DrugDetails.put("PREG_EFFECT",(resultSet.getString("PREG_EFFECT_FT")==null ? "":resultSet.getString("PREG_EFFECT_FT")));
						DrugDetails.put("PREG_WARN_REQ_YN",(resultSet.getString("PREG_WARN_REQ_FT_YN")==null ? "":resultSet.getString("PREG_WARN_REQ_FT_YN")));
						DrugDetails.put("PREG_CATEGORY_CODE",(resultSet.getString("PREG_CATEGORY_CODE1")==null ? "":resultSet.getString("PREG_CATEGORY_CODE1")));
					}
					else if(trimester.equals("Second Trimester")){
						DrugDetails.put("PREG_EFFECT",(resultSet.getString("PREG_EFFECT_ST")==null ? "":resultSet.getString("PREG_EFFECT_ST")));
						DrugDetails.put("PREG_WARN_REQ_YN",(resultSet.getString("PREG_WARN_REQ_ST_YN")==null ? "":resultSet.getString("PREG_WARN_REQ_ST_YN")));
						DrugDetails.put("PREG_CATEGORY_CODE",(resultSet.getString("PREG_CATEGORY_CODE2")==null ? "":resultSet.getString("PREG_CATEGORY_CODE2")));
					}
					else if(trimester.equals("Thrid Trimester")){
						DrugDetails.put("PREG_EFFECT",(resultSet.getString("PREG_EFFECT_TT")==null ? "":resultSet.getString("PREG_EFFECT_TT")));
						DrugDetails.put("PREG_WARN_REQ_YN",(resultSet.getString("PREG_WARN_REQ_TT_YN")==null ? "":resultSet.getString("PREG_WARN_REQ_TT_YN")));
						DrugDetails.put("PREG_CATEGORY_CODE",(resultSet.getString("PREG_CATEGORY_CODE3")==null ? "":resultSet.getString("PREG_CATEGORY_CODE3")));
					}
				}
				//adding end for  RUT-CRF-0063 [IN:029601]
				DrugDetails.put("MAR_BARCODE_ID",(resultSet.getString("MAR_BARCODE_ID")==null ? "":resultSet.getString("MAR_BARCODE_ID")));//added for MMS-QH-CRF-0080 [IN:038064] 
				DrugDetails.put("TRN_GROUP_REF",checkForNull(resultSet.getString("TRN_GROUP_REF")));
				if(this.trn_group_ref ==null || this.trn_group_ref.equals("")) //if block added for  [IN039258]
					setTrnGroupRef(resultSet.getString("TRN_GROUP_REF"));

				pstmt_sld	=	connection.prepareStatement("SELECT TEMPLATE_ID, SRL_NO, RANGE_FROM, RANGE_TO, ADMIN_UNITS, REMARKS FROM OR_ORDER_LINE_PH_SLD_SCALE WHERE ORDER_ID=? AND ORDER_LINE_NUM=? ORDER BY SRL_NO");
				pstmt_sld.setString(1,order_id);
				pstmt_sld.setString(2,order_line_num);
				resultSet_sld	=	pstmt_sld.executeQuery();
				if(resultSet_sld!=null){
					while(resultSet_sld.next()){ 
						srl_no = resultSet_sld.getString("SRL_NO")==null?"":resultSet_sld.getString("SRL_NO");           
						range_from = resultSet_sld.getString("RANGE_FROM")==null?"":resultSet_sld.getString("RANGE_FROM");       
						range_to = resultSet_sld.getString("RANGE_TO")==null?"":resultSet_sld.getString("RANGE_TO");         
						admin_units = resultSet_sld.getString("ADMIN_UNITS")==null?"":resultSet_sld.getString("ADMIN_UNITS");      
						remarks = resultSet_sld.getString("REMARKS")==null?"":resultSet_sld.getString("REMARKS");          
						if(remarks !=null || !remarks.equals(""))
							remarks = java.net.URLEncoder.encode(remarks,"UTF-8");	
						sldscale_tmpl_dtl.add(srl_no);
						sldscale_tmpl_dtl.add(range_from);
						sldscale_tmpl_dtl.add(range_to);
						sldscale_tmpl_dtl.add(admin_units);
						sldscale_tmpl_dtl.add(remarks);
						DrugDetails.put("TEMPLATE_ID",resultSet_sld.getString("TEMPLATE_ID")==null?"":resultSet_sld.getString("TEMPLATE_ID"));
					}
				}
				DrugDetails.put("SLDSCALE_TMPL_DTL",sldscale_tmpl_dtl);
				closeResultSet( resultSet_sld ) ;
				closeStatement( pstmt_sld ) ;

				DrugDetails.put("SLDSCALE_TMPL_DTL",sldscale_tmpl_dtl);
				if(!bl_incl_excl_override_reason_code.equals("")){
					pstmt1	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_AMEND_PRESCRIPTION_BL_ACTION_DESC_SELECT") ) ;
					
					pstmt1.setString(1,locale);
					pstmt1.setString(2,bl_incl_excl_override_reason_code);
					resultSet1		= pstmt1.executeQuery();
					
					while(resultSet1!=null && resultSet1.next() ) {
						DrugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",resultSet1.getString("ACTION_REASON_DESC")==null?"":resultSet1.getString("ACTION_REASON_DESC"));
					}
					closeResultSet( resultSet1 ) ;
					closeStatement( pstmt1 ) ;
				}

				prn_remarks_values= resultSet.getString("PRN_REMARKS")==null ? "":resultSet.getString("PRN_REMARKS");
				prn_remarks_code= resultSet.getString("PRN_REMARKS_CODE")==null ? "":resultSet.getString("PRN_REMARKS_CODE");

				sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TRADE_SELECT");
				pstmt1				= connection.prepareStatement(sql_query) ;
				pstmt1.setString(1,order_id);
				pstmt1.setString(2,order_line_no);
				pstmt1.setString(3,locale);
				result			= pstmt1.executeQuery();
				if(result!=null && result.next()){
					DrugDetails.put("TRADE_CODE",(result.getString("TRADE_CODE")==null ? "":result.getString("TRADE_CODE")) );
					DrugDetails.put("TRADE_NAME",(result.getString("TRADE_NAME")==null ? "":result.getString("TRADE_NAME")) );
				}
				else{
					DrugDetails.put("TRADE_CODE","");
					DrugDetails.put("TRADE_NAME","");
				}
				closeResultSet( result ) ;
				closeStatement( pstmt1 ) ;

				if(!prn_remarks_values.equals("")){
					temp=new HashMap();
					temp.put("prn_remarks_code",prn_remarks_code);
					temp.put("prn_remarks_dtl",prn_remarks_values);
					addPRNRemarks(drugCode, temp);
				}
				patient_class	=	(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS"));
				calc_dflt_dosage_by_htwt	= (resultSet.getString("CALC_DEF_DOSAGE_YN")==null ? "":resultSet.getString("CALC_DEF_DOSAGE_YN"));	
				sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT14A");//ATC_ALLERGY_ALERT_LEVEL Added for	RUT-CRF-0065 IN 29603

				pstmt1				= connection.prepareStatement(sql_query) ;
				pstmt1.setString(1,ord_facility_id); // priya
				result			= pstmt1.executeQuery();
				if(result!=null && result.next()){
					DrugDetails.put("MED_ADMIN_REQD_YN",(result.getString("MED_ADMIN_REQD_YN")==null ? "N":result.getString("MED_ADMIN_REQD_YN")) );
					prn_yn =result.getString("MANDATORY_REM_ON_PRN_FREQ_YN")==null ? "N":result.getString("MANDATORY_REM_ON_PRN_FREQ_YN");
					setchkforPRN(prn_yn);
					duplicate_check_at_atc_yn  = checkForNull(result.getString("DUPLICATE_CHECK_AT_ATC_YN"),"N");
					DrugDetails.put("DUPLICATE_CHECK_AT_ATC_YN",duplicate_check_at_atc_yn );
					DrugDetails.put("MANDATORY_REM_ON_PRN_FREQ_YN",(result.getString("MANDATORY_REM_ON_PRN_FREQ_YN")==null ? "N":result.getString("MANDATORY_REM_ON_PRN_FREQ_YN")) );
					DrugDetails.put("ALLOW_DUPLICATE_DRUG",(result.getString("ALLOW_DUPLICATE_DRUG")==null ? "Y":result.getString("ALLOW_DUPLICATE_DRUG")) );	
					if(patient_class.equals("IP")) {
						consider_stock_for_pres_yn	=	result.getString("IP_CONSIDER_STOCK_PRES_YN")==null ? "Y":result.getString("IP_CONSIDER_STOCK_PRES_YN");
						DrugDetails.put("CONSIDER_STOCK_FOR_PRES_YN",consider_stock_for_pres_yn );
						allow_pres_without_stock_yn	= result.getString("IP_PRES_WITHOUT_STOCK_YN")==null ? "Y":result.getString("IP_PRES_WITHOUT_STOCK_YN");
						DrugDetails.put("ALLOW_PRES_WITHOUT_STOCK_YN",allow_pres_without_stock_yn );
					}
					else {
						consider_stock_for_pres_yn	=	result.getString("CONSIDER_STOCK_FOR_PRES_YN")==null ? "Y":result.getString("CONSIDER_STOCK_FOR_PRES_YN");
						DrugDetails.put("CONSIDER_STOCK_FOR_PRES_YN",consider_stock_for_pres_yn );
						allow_pres_without_stock_yn	= result.getString("ALLOW_PRES_WITHOUT_STOCK_YN")==null ? "Y":result.getString("ALLOW_PRES_WITHOUT_STOCK_YN");
						DrugDetails.put("ALLOW_PRES_WITHOUT_STOCK_YN",allow_pres_without_stock_yn );
					}
					drug_db_duptherapy_yn = result.getString("DRUG_DB_DUPTHERAPY_YN")==null ? "N":result.getString("DRUG_DB_DUPTHERAPY_YN");//Modified for IN:071537
					drug_db_allergy_check_yn = result.getString("DRUG_DB_ALLERGY_CHECK_YN")==null ? "N":result.getString("DRUG_DB_ALLERGY_CHECK_YN");
					atc_allergy_alert_level = result.getString("ATC_ALLERGY_ALERT_LEVEL")==null ? "N":result.getString("ATC_ALLERGY_ALERT_LEVEL"); //Code Added for	RUT-CRF-0065 IN 29603
					drug_db_interface_yn = result.getString("DRUG_DB_INTERFACE_YN")==null ? "N":result.getString("DRUG_DB_INTERFACE_YN"); //Code Added for	RUT-CRF-0066 IN 29604
					//Added for IN:071537 start
					DrugDetails.put("DRUG_DB_DUPTHERAPY_YN",drug_db_duptherapy_yn);
					DrugDetails.put("DRUG_DB_ALLERGY_CHECK_YN",drug_db_allergy_check_yn);
					DrugDetails.put("DRUG_DB_INTERFACE_YN",drug_db_interface_yn);
					DrugDetails.put("DRUG_DB_INTERACT_CHECK_FLAG",(result.getString("DRUG_DB_INTERACT_CHECK_YN")==null ? "N":result.getString("DRUG_DB_INTERACT_CHECK_YN")));
					DrugDetails.put("DRUG_DB_DOSAGE_CHECK_FLAG",(result.getString("DRUG_DB_DOSECHECK_YN")==null ? "N":result.getString("DRUG_DB_DOSECHECK_YN")));
					DrugDetails.put("DRUG_DB_CONTRAIND_CHECK_FLAG",(result.getString("DRUG_DB_CONTRAIND_CHECK_YN")==null ? "N":result.getString("DRUG_DB_CONTRAIND_CHECK_YN")));
			//Added for IN:071537 end
				}
				closeResultSet( result ) ;
				closeStatement( pstmt1 ) ;

				pat_dtls	=	getPatientDetails(patient_id,drugCode);
				age			=	(String)pat_dtls.get("age");
				sex			=	((String)pat_dtls.get("sex"));
				age_in_mints			=	((String)pat_dtls.get("age_in_mints"));
				//age	=	age.trim();
				age_in_mints	=	age_in_mints.trim();
				sex	=	sex.substring(0,1);
				pstmt1	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80A") ) ;
				pstmt1.setString(1,sex);
				pstmt1.setString(2,age_in_mints);
				pstmt1.setString(3,drugCode);
				resultSet1		= pstmt1.executeQuery();
		
				while(resultSet1!=null && resultSet1.next() ) {
					age_group	=	resultSet1.getString("AGE_GROUP_CODE");
				}
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;

				DrugDetails.put("RECOMM_YN","N");
				DrugDetails.put("CALC_BY_IND","");
				DrugDetails.put("DOSAGE_STD","");
				DrugDetails.put("DOSAGE_UNIT","");
				DrugDetails.put("RECOMM_DOSAGE_BY","");
			
				DrugDetails.put("SLIDING_SCALE_YN",(resultSet.getString("SLIDING_SCALE_YN")==null ? "":resultSet.getString("SLIDING_SCALE_YN")));
				if(calc_dflt_dosage_by_htwt.trim().equals("Y") && age_group!=null && !age_group.equals("")) {
					sql_query		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT81");
					pstmt1			= connection.prepareStatement(sql_query) ;
					pstmt1.setString(1,drugCode);
					pstmt1.setString(2,age_group);
					result			= pstmt1.executeQuery();
					if(result!=null && result.next()) {
						DrugDetails.put("RECOMM_YN","Y");
						DrugDetails.put("CALC_BY_IND",(result.getString("CALC_BY_IND")));
						DrugDetails.put("DOSAGE_STD",(result.getString("DOSAGE_STD")));
						DrugDetails.put("DOSAGE_UNIT",(result.getString("DOSAGE_UNIT")));
						DrugDetails.put("RECOMM_DOSAGE_BY",(result.getString("LIMIT_IND")));
					} 
					closeResultSet( result ) ;
					closeStatement( pstmt1 ) ;
				} 

				date_str = resultSet.getString("ORD_DATE_TIME")==null ? "":resultSet.getString("ORD_DATE_TIME");
				if(!locale.equals("en"))
					date_str = com.ehis.util.DateUtils.convertDate(date_str, "DMYHM","en",locale);
				
				DrugDetails.put("ORD_DATE_TIME",date_str);
				DrugDetails.put("PRACTITIONER_NAME",(resultSet.getString("PRACTITIONER_NAME")==null ? "":resultSet.getString("PRACTITIONER_NAME")));
				DrugDetails.put("ORD_PRACT_ID",(resultSet.getString("ORD_PRACT_ID")==null ? "":resultSet.getString("ORD_PRACT_ID")));
				DrugDetails.put("PRIORITY",(resultSet.getString("PRIORITY")==null ? "":resultSet.getString("PRIORITY")));
				if(((String)DrugDetails.get("PRIORITY")).equals("routine"))  // RUT-CRF-0062 [IN029600]
					priority = "R";
				else if(((String)DrugDetails.get("PRIORITY")).equals("urgent"))
					priority = "U";
				DrugDetails.put("CHILD_ORDER_YN",(resultSet.getString("CHILD_ORDER_YN")==null ? "":resultSet.getString("CHILD_ORDER_YN")));
				DrugDetails.put("GENERIC_ID",(resultSet.getString("GENERIC_ID")==null ? "":resultSet.getString("GENERIC_ID")));
				generic_id = resultSet.getString("GENERIC_ID")==null ? "":resultSet.getString("GENERIC_ID");
				DrugDetails.put("FREQ_CODE",(resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")));
				DrugDetails.put("PRN_DOSES_PRES_PRD_FILL",(resultSet.getString("PRN_DOSES_PRES_PRD_FILL")==null ? "":resultSet.getString("PRN_DOSES_PRES_PRD_FILL")));			
				presamendDetails.put("DRUG_CODE",(resultSet.getString("DRUGCODE")==null ? "":resultSet.getString("DRUGCODE")));
				DrugDetails.put("QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")));
				DrugDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")) );
				DrugDetails.put("REPEAT_DURN_TYPE",(resultSet.getString("FREQ_DURN_TYPE")==null ? "":resultSet.getString("FREQ_DURN_TYPE")));//modified DURNTYPE to REPEAT_DURN_TYPE for ML-BRU-SCF-1887
				presamendDetails.put("QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")));
				proc_qty_value=resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE");
				DrugDetails.put("QTY_UNIT",(resultSet.getString("QTY_UNIT")==null ? "":resultSet.getString("QTY_UNIT")));
				DrugDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "1":resultSet.getString("DURN_VALUE")));
				presamendDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "1":resultSet.getString("DURN_VALUE")));
				DrugDetails.put("DURN_DESC",(resultSet.getString("DURN_DESC")==null ? "":resultSet.getString("DURN_DESC")));
				DrugDetails.put("CATALOG_DESC",(resultSet.getString("CATALOG_DESC")==null ? "":resultSet.getString("CATALOG_DESC")));
				date_str = resultSet.getString("START_DATE_TIME")==null ? "":resultSet.getString("START_DATE_TIME");
				if(!locale.equals("en"))
					date_str = com.ehis.util.DateUtils.convertDate(date_str, "DMYHM","en",locale);

				DrugDetails.put("START_DATE_TIME",date_str);
				DrugDetails.put("FORM_DESC",(resultSet.getString("FORM_DESC")==null ? "":resultSet.getString("FORM_DESC")));
				DrugDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")));
				DrugDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")));
				DrugDetails.put("FORM_CODE",(resultSet.getString("FORM_CODE")==null ? "":resultSet.getString("FORM_CODE")));
				form_code = DrugDetails.get("FORM_CODE").toString(); // RUT-CRF-0062 [IN029600]
				DrugDetails.put("FREQ_DESC",(resultSet.getString("FREQ_DESC")==null ? "":resultSet.getString("FREQ_DESC")));
				DrugDetails.put("FREQ_NATURE",(resultSet.getString("FREQ_NATURE")==null ? "":resultSet.getString("FREQ_NATURE")));		
				DrugDetails.put("LINE_FIELDS_DISPLAY_TEXT",(resultSet.getString("LINE_FIELDS_DISPLAY_TEXT")==null ? "":resultSet.getString("LINE_FIELDS_DISPLAY_TEXT")));
				date_str = resultSet.getString("END_DATE_TIME")==null ? "":resultSet.getString("END_DATE_TIME");
				if(!locale.equals("en"))
					date_str = com.ehis.util.DateUtils.convertDate(date_str, "DMYHM","en",locale);

				DrugDetails.put("END_DATE_TIME",date_str);
				DrugDetails.put("ORDER_QTY",(resultSet.getString("ORDER_QTY")==null ? "":resultSet.getString("ORDER_QTY")));
				DrugDetails.put("ORDER_UOM",(resultSet.getString("ORDER_UOM")==null ? "":resultSet.getString("ORDER_UOM")));
				DrugDetails.put("SHORT_DESC",(resultSet.getString("CATALOG_DESC")==null ? "":resultSet.getString("CATALOG_DESC")));
				DrugDetails.put("QTY_DESC",(resultSet.getString("SHORT_DESC")==null ? "":resultSet.getString("SHORT_DESC")));
				DrugDetails.put("CONT_ORDER_IND",(resultSet.getString("CONT_ORDER_IND")==null ? "":resultSet.getString("CONT_ORDER_IND")));
				DrugDetails.put("REFILL_SINGLE_CONT_ORDER_YN",(resultSet.getString("REFILL_SINGLE_CONT_ORDER_YN")==null ? "":resultSet.getString("REFILL_SINGLE_CONT_ORDER_YN")));
				DrugDetails.put("NUM_OF_REFILLS",(resultSet.getString("NUM_OF_REFILLS")==null ? "":resultSet.getString("NUM_OF_REFILLS")));
				DrugDetails.put("PARENT_ORDER_LINE_NUM",(resultSet.getString("PARENT_ORDER_LINE_NUM")==null ? "":resultSet.getString("PARENT_ORDER_LINE_NUM")));
				DrugDetails.put("STRENGTH",(resultSet.getString("STRENGTH")==null ? "":resultSet.getString("STRENGTH")));
				strength_value	=	(resultSet.getString("STRENGTH_VALUE")==null ? "":resultSet.getString("STRENGTH_VALUE"));
				DrugDetails.put("STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "":resultSet.getString("STRENGTH_VALUE")));
				DrugDetails.put("DEFAULT_DOSAGE_BY_YN",(resultSet.getString("DEFAULT_DOSAGE_BY_YN")==null ? "": resultSet.getString("DEFAULT_DOSAGE_BY_YN")));//Added DEFAULT_DOSAGE_BY_YN to make initial qty value is Empty AAKH-CRF-089
				DrugDetails.put("STRENGTH_UOM",(resultSet.getString("STRENGTH_UOM")==null ? "":resultSet.getString("STRENGTH_UOM")));
				DrugDetails.put("STRENGTH_DESC",(resultSet.getString("STRENGTH_UOM_DESC")==null ? "":resultSet.getString("STRENGTH_UOM_DESC")));
				DrugDetails.put("STRENGTHUOM",(resultSet.getString("STRENGTHUOM")==null ? "":resultSet.getString("STRENGTHUOM")));
				DrugDetails.put("DIAG_TEXT",(resultSet.getString("DIAG_TEXT")==null ? "":resultSet.getString("DIAG_TEXT")));
				DrugDetails.put("ACT_STRENGTH_VALUE",(resultSet.getString("STRENGTH")==null ? "":resultSet.getString("STRENGTH")));
				DrugDetails.put("QTY_DESC_CODE",(resultSet.getString("QTY_UNIT")==null ? "":resultSet.getString("QTY_UNIT")));
				DrugDetails.put("STOCK_UOM",(resultSet.getString("STOCK_UOM")==null ? "":resultSet.getString("STOCK_UOM")) );
				DrugDetails.put("STOCK_UOM_DESC",(resultSet.getString("STOCK_UOM_DESC")==null ? "":resultSet.getString("STOCK_UOM_DESC")) );
				presamendDetails.put("DIAG_TEXT",(resultSet.getString("DIAG_TEXT")==null ? "":resultSet.getString("DIAG_TEXT")));
				DrugDetails.put("ALLERGY_REMARKS",(resultSet.getString("ALLERGY_OVERRIDE_REASON")==null ? "":resultSet.getString("ALLERGY_OVERRIDE_REASON")));
				DrugDetails.put("DOSE_REMARKS",(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")==null ? "":resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")));
				DrugDetails.put("CURRENTRX_REMARKS",(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")==null ? "":resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")));
				DrugDetails.put("INTERACTION_REMARKS",(resultSet.getString("INTERACTION_OVERRIDE_REASON")==null ? "":resultSet.getString("INTERACTION_OVERRIDE_REASON")));
				DrugDetails.put("LAB_INTERACTION_REMARKS",(resultSet.getString("LAB_INTERACT_OVERRIDE_REASON")==null ? "":resultSet.getString("LAB_INTERACT_OVERRIDE_REASON")));//MMS-KH-CRF-0029
				DrugDetails.put("FOOD_INTERACTION_REMARKS",(resultSet.getString("FOOD_INTERACT_OVERRIDE_REASON")==null ? "":resultSet.getString("FOOD_INTERACT_OVERRIDE_REASON")));//MMS-KH-CRF-0029
				//Added for IN:072715  START
				DrugDetails.put("ALLERGY_REMARKS_CODE",(resultSet.getString("ALLERGY_OVERRIDE_REASON_CODE")==null ? "":resultSet.getString("ALLERGY_OVERRIDE_REASON_CODE")));
				DrugDetails.put("DOSE_REMARKS_CODE",(resultSet.getString("DOSE_LIMIT_OVER_REASON_CODE")==null ? "":resultSet.getString("DOSE_LIMIT_OVER_REASON_CODE")));
				DrugDetails.put("CURRENTRX_REMARKS_CODE",(resultSet.getString("DUP_DRUG_OVERRIDE_REASON_CODE")==null ? "":resultSet.getString("DUP_DRUG_OVERRIDE_REASON_CODE")));
				DrugDetails.put("INTERACTION_REMARKS_CODE",(resultSet.getString("INTER_OVERRIDE_REASON_CODE")==null ? "":resultSet.getString("INTER_OVERRIDE_REASON_CODE")));
				DrugDetails.put("LAB_INTERACTION_REMARKS_CODE",(resultSet.getString("LAB_INTER_OVERRIDE_REASON_CODE")==null ? "":resultSet.getString("LAB_INTER_OVERRIDE_REASON_CODE")));
				DrugDetails.put("FOOD_INTERACTION_REMARKS_CODE",(resultSet.getString("FOOD_INTR_OVERRIDE_REASON_CODE")==null ? "":resultSet.getString("FOOD_INTR_OVERRIDE_REASON_CODE")));
				//Added for IN:072715  END
				DrugDetails.put("DISEASE_INTERACTION_REMARKS",(resultSet.getString("DISEASE_INTER_OVERRIDE_REASON")==null ? "":resultSet.getString("DISEASE_INTER_OVERRIDE_REASON")));//Added for MMS-DM-CRF-0229
				DrugDetails.put("DISEASE_INTERACTION_REMARKS_CODE",(resultSet.getString("DISEASE_INTER_REASON_CODE")==null ? "":resultSet.getString("DISEASE_INTER_REASON_CODE")));//Added for MMS-DM-CRF-0229
				DrugDetails.put("GENERIC_NAME",(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME")));
				DrugDetails.put("TAPERED_YN",(resultSet.getString("TAPERED_YN")==null ? "":resultSet.getString("TAPERED_YN")));
				DrugDetails.put("DRUG_TAPERED_YN",(resultSet.getString("TAPERED_YN")==null ? "":resultSet.getString("TAPERED_YN")));
				DrugDetails.put("ORDER_TYPE_CODE",(resultSet.getString("ORDER_TYPE_CODE")==null ? "":resultSet.getString("ORDER_TYPE_CODE")));
				DrugDetails.put("ORDER_TYPE_DESC",(resultSet.getString("ORDERTYPEDESC")==null ? "":resultSet.getString("ORDERTYPEDESC")));
				DrugDetails.put("SPLIT_DOSE_YN",(resultSet.getString("SPLIT_YN")==null ? "":resultSet.getString("SPLIT_YN")));
				DrugDetails.put("SPLIT_DOSE_PREVIEW",(resultSet.getString("SPLIT_DOSE_PREVIEW")==null ? "":resultSet.getString("SPLIT_DOSE_PREVIEW")));
				DrugDetails.put("HEIGHT",(resultSet.getString("HEIGHT")==null ? "":resultSet.getString("HEIGHT")));
				DrugDetails.put("HEIGHT_UOM",(resultSet.getString("HEIGHT_UOM")==null ? "":resultSet.getString("HEIGHT_UOM")));
				DrugDetails.put("WEIGHT",(resultSet.getString("WEIGHT")==null ? "":resultSet.getString("WEIGHT")));
				DrugDetails.put("WEIGHT_UOM",(resultSet.getString("WEIGHT_UOM")==null ? "":resultSet.getString("WEIGHT_UOM")));
				DrugDetails.put("BSA",(resultSet.getString("BSA")==null ? "":resultSet.getString("BSA")));
				DrugDetails.put("TAKE_HOME",(resultSet.getString("TAKEHOME")==null ? "N":resultSet.getString("TAKEHOME")));
				DrugDetails.put("PRESCRIBED_MODE",(resultSet.getString("PRESCRIBED_MODE")==null ? "Q":resultSet.getString("PRESCRIBED_MODE")));
				DrugDetails.put("HOME_LEAVE",(resultSet.getString("HOME_LEAVE")==null ? "N":resultSet.getString("HOME_LEAVE")));// added HOME_LEAVE for the CRF Bru-HIMS-CRF-093[29960]

				date_str = resultSet.getString("REFILL_START_DATE_TIME")==null ? "":resultSet.getString("REFILL_START_DATE_TIME");
				if(!locale.equals("en"))
					date_str = com.ehis.util.DateUtils.convertDate(date_str, "DMYHM","en",locale);

				DrugDetails.put("REFILL_START_DATE_TIME",date_str);
				date_str = resultSet.getString("REFILL_END_DATE_TIME")==null ? "":resultSet.getString("REFILL_END_DATE_TIME");
				if(!locale.equals("en"))
					date_str = com.ehis.util.DateUtils.convertDate(date_str, "DMYHM","en",locale);
				DrugDetails.put("REFILL_END_DATE_TIME",date_str);
				DrugDetails.put("NUM_OF_REFILLS",(resultSet.getString("NUM_OF_REFILLS")==null ? "":resultSet.getString("NUM_OF_REFILLS")));
				DrugDetails.put("SCHEDULED_YN",(resultSet.getString("SCHEDULED_YN")==null ? "N":resultSet.getString("SCHEDULED_YN")));
				DrugDetails.put("DURN_TYPE",(resultSet.getString("DURN_TYPE")==null ? "D":resultSet.getString("DURN_TYPE")));
				repeat_value =resultSet.getString("REPEAT_VALUE")==null ? "1":resultSet.getString("REPEAT_VALUE");
				DrugDetails.put("REPEAT_VALUE",repeat_value);
				DrugDetails.put("INTERVAL_VALUE",(resultSet.getString("INTERVAL_VALUE")==null ? "1":resultSet.getString("INTERVAL_VALUE")));
				DrugDetails.put("PRES_BASE_UOM",(resultSet.getString("PRES_BASE_UOM")==null ? "":resultSet.getString("PRES_BASE_UOM")));
				fract_dose_appl_yn = resultSet.getString("FRACT_DOSE_APPL_YN")==null? "":resultSet.getString("FRACT_DOSE_APPL_YN");
				DrugDetails.put("FRACT_DOSE_APPL_YN",fract_dose_appl_yn);
				if(fract_dose_appl_yn.equals("Y")){
					DrugDetails.put("FRACT_DOSE_ROUND_UP_YN",(resultSet.getString("FRACT_DOSE_ROUND_UP_YN")==null ? "":resultSet.getString("FRACT_DOSE_ROUND_UP_YN")) );
				}
				else{
					DrugDetails.put("FRACT_DOSE_ROUND_UP_YN","N");
				}

				//DrugDetails.put("FRACT_DOSE_ROUND_UP_YN",(resultSet.getString("FRACT_DOSE_ROUND_UP_YN")==null ? "":resultSet.getString("FRACT_DOSE_ROUND_UP_YN")));
				DrugDetails.put("CONTENT_IN_PRES_BASE_UOM",(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null ? "":resultSet.getString("CONTENT_IN_PRES_BASE_UOM")));
				DrugDetails.put("STRENGTH_PER_PRES_UOM",(resultSet.getString("STRENGTH_PER_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_PRES_UOM")));
				DrugDetails.put("STRENGTH_PER_VALUE_PRES_UOM",(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")));
				//String tempStrengthVal = (String)DrugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
				//if(tempStrengthVal.equals("") || Float.parseFloat(tempStrengthVal) < 1) //codition commented on 12/03/2010 - priya
				//	DrugDetails.put("STRENGTH_PER_VALUE_PRES_UOM","1");
					
				dosage_type=resultSet.getString("DOSAGE_TYPE")==null ? "":resultSet.getString("DOSAGE_TYPE");
				DrugDetails.put("DOSAGE_TYPE",dosage_type);
				DrugDetails.put("ORI_DOSAGE_TYPE",dosage_type);
				
				if(strength_value==null || strength_value.equals("") || strength_value.equals("0") || fract_dose_appl_yn.equals("N")){
					DrugDetails.put("ORI_DOSAGE_TYPE","Q");
				}
				else{
					DrugDetails.put("ORI_DOSAGE_TYPE","S");
				}
				//DrugDetails.put("DEFAULT_DOSAGE_BY",(resultSet.getString("DEFAULT_DOSAGE_BY")==null ? "":resultSet.getString("DEFAULT_DOSAGE_BY"))); //add DEFAULT_DOSAGE_BY for SKR-CRF-PHIS-003[IN028182]
				DrugDetails.put("LICENCE",licence);
			
				//if(licence.equals("PH")){
					DrugDetails.put("DISP_LOCN_CODE",(resultSet.getString("DISP_LOCN_CODE")==null ? "":resultSet.getString("DISP_LOCN_CODE")));
					DrugDetails.put("DISP_LOCN_DESC",(resultSet.getString("DISP_LOCN_DESC")==null ? "":resultSet.getString("DISP_LOCN_DESC")));

					disp_locn_code	=	(resultSet.getString("DISP_LOCN_CODE")==null ? "":resultSet.getString("DISP_LOCN_CODE"));
				/*}else{
					DrugDetails.put("DISP_LOCN_CODE","");
					DrugDetails.put("DISP_LOCN_DESC","");
				}*/
				DrugDetails.put("ORDER_STATUS",(resultSet.getString("ORDER_STATUS")==null ? "":resultSet.getString("ORDER_STATUS")));
				DrugDetails.put("PREV_ORDER_STATUS",(resultSet.getString("PREV_ORDER_LINE_STATUS")==null ? "":resultSet.getString("PREV_ORDER_LINE_STATUS")));//Added for ML-BRU-SCF-1325
				ArrayList renew_dates	=	getRenewDates((resultSet.getString("DURN_VALUE")),order_id,(String)resultSet.getString("DRUGCODE"));
				if(renew_dates.size()==2) {
					drug_end_date	=	(String)renew_dates.get(1);
				}
			//	if(nationalityCheck(patient_id)) {
					//ArrayList stock_params	=	validateForStock(patient_class);
					//if(stock_params.size()!=0 && ((String)stock_params.get(0)).equals("Y") && ((String)stock_params.get(1)).equals("N")){
					if(consider_stock_for_pres_yn.equals("Y") && allow_pres_without_stock_yn.equals("N")){
						stock_dtls	=	chkStockAvail((String)resultSet.getString("DRUGCODE"),disp_locn_code,(resultSet.getString("ORDER_QTY")==null ? "":resultSet.getString("ORDER_QTY")),drug_end_date, trade_code);

						if(stock_dtls.size()!=0) {
							DrugDetails.put("STOCK_AVAILABLE_YN",(String)stock_dtls.get("STOCK_AVAILABLE_YN"));
							DrugDetails.put("AVAILABLE_STOCK",(String)stock_dtls.get("AVAILABLE_STOCK"));					
						}
						else {
							DrugDetails.put("STOCK_AVAILABLE_YN","N");
							DrugDetails.put("AVAILABLE_STOCK","0");
						}
					}
					if(this.pat_specialty_code==null || this.pat_specialty_code.equals("")) {
						getPat_specialty_code( ord_facility_id, (String) DrugDetails.get("ENCOUNTER_ID") );                       
					}	
					DrugDetails.put("PAT_SPECIALTY_CODE",this.pat_specialty_code );//PE corrections ends here
              
				DrugDetails.put("ORD_AUTH_REQD_YN","N");
				DrugDetails.put("ORD_SPL_APPR_REQD_YN","N");
				DrugDetails.put("ORD_COSIGN_REQD_YN","N");
				DrugDetails.put("ORD_AUTHORIZED_YN","N" );
				DrugDetails.put("ORD_APPROVED_YN","N");
				DrugDetails.put("ORD_COSIGNED_YN","N");
				DrugDetails.put("ORD_AUTHORIZED_PREV_YN","N");
				DrugDetails.put("QUOTA_LIMIT_ACCESS_YN","N"); // ML-MMOH-CRF-1823 US008- 43528 
				cstmt=connection.prepareCall("{call PH_ORDER_CATALOG_AUTH_RULE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");// ML-MMOH-CRF-1823 US008- 43528 
				cstmt.setString( 1, drugCode);
				cstmt.setString( 2, act_pat_class);// getPatientClass() replaced with act_pat_class for ML-BRU-SCF-0898 [IN:041176]
				cstmt.setString( 3, locale);
				cstmt.setString( 4, resp_id);
				cstmt.setString( 5, (String)DrugDetails.get("ORD_PRACT_ID"));
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
				cstmt.registerOutParameter(18, Types.VARCHAR ); // ML-MMOH-CRF-1823 US008- 43528 
				cstmt.execute() ;
		
				DrugDetails.put("ORD_AUTH_REQD_YN",(cstmt.getString(8)==null ? "N":cstmt.getString(8)));
				DrugDetails.put("ORD_SPL_APPR_REQD_YN",(cstmt.getString(9)==null ? "N":cstmt.getString(9)) );
				DrugDetails.put("ORD_COSIGN_REQD_YN",(cstmt.getString(10)==null ? "N":cstmt.getString(10)) );
				DrugDetails.put("ORD_AUTHORIZED_PREV_YN",(cstmt.getString(11)==null ? "N":cstmt.getString(11)) );
				DrugDetails.put("ORD_APPROVED_YN",(cstmt.getString(12)==null ? "N":cstmt.getString(12)) );
				DrugDetails.put("ORD_COSIGNED_YN",(cstmt.getString(13)==null ? "N":cstmt.getString(13)) );
				DrugDetails.put("ORD_AUTHORIZED_YN",(String)DrugDetails.get("ORD_AUTHORIZED_PREV_YN"));
				DrugDetails.put("QUOTA_LIMIT_ACCESS_YN",(cstmt.getString(18)==null ? "N":cstmt.getString(18)) ); // ML-MMOH-CRF-1823 US008- 43528 
				//ADDED FOR MO-SCF-5533 start
				sql_query_oth			= "select AUTH_YN from or_review_user_categories where  PRACTITIONER_ID=? AND ORDER_CATEGORY='PH'";
				pstmt_oth				= connection.prepareStatement(sql_query_oth) ;
				pstmt_oth.setString(1,(String)DrugDetails.get("ORD_PRACT_ID"));
				
				result_oth			= pstmt_oth.executeQuery();

				if(result_oth!=null && result_oth.next()) {
					
					DrugDetails.put("ORD_AUTHORIZED_YN_DURN", result_oth.getString("AUTH_YN")==null?"N":result_oth.getString("AUTH_YN"));
				}
				//ADDED FOR MO-SCF-5533 end
				try{
					closeStatement( cstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}	
				if(drug_db_interface_yn.equals("N") || DrugDetails.get("EXTERNAL_PRODUCT_ID").equals("") || drug_db_duptherapy_yn.equals("N")){ // Condition added for IN25957 --18/01/2011-- priya
					sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13D"); //SQL_PH_PRESCRIPTION_SELECT13C changed to SQL_PH_PRESCRIPTION_SELECT13D for MMS_BETA_0052 [IN:046303]
					pstmt1				= connection.prepareStatement(sql_query) ;
					pstmt1.setString(1,patient_id);
					pstmt1.setString(2,(String)DrugDetails.get("START_DATE_TIME"));
					pstmt1.setString(3,(String)DrugDetails.get("END_DATE_TIME"));
					pstmt1.setString(4,(String)DrugDetails.get("START_DATE_TIME"));
					pstmt1.setString(5,(String)DrugDetails.get("END_DATE_TIME"));
					pstmt1.setString(6,(String)DrugDetails.get("START_DATE_TIME"));
					pstmt1.setString(7,(String)DrugDetails.get("END_DATE_TIME"));
					pstmt1.setString(8,(String)DrugDetails.get("FREQ_CODE"));
					pstmt1.setString(9,generic_id);
					pstmt1.setString(10,getTrnGroupRef()); //Added for for MMS_BETA_0052 [IN:046303]
					count_rx = 0;
					resultSetChk			= pstmt1.executeQuery();
					if(resultSetChk!=null && resultSetChk.next())	{
						count_rx=resultSetChk.getInt(1);
					}
					closeResultSet( resultSetChk ) ;
					closeStatement( pstmt1 ) ;
					
					if(count_rx>1){
						DrugDetails.put("CURRENT_RX","Y");
					}
					else{
						DrugDetails.put("CURRENT_RX","N");
					}
				}
				else{
					DrugDetails.put("CURRENT_RX","N");
				}

				if((DrugDetails.get("EXTERNAL_PRODUCT_ID").equals("") && drug_db_allergy_check_yn.equals("Y") )||(drug_db_allergy_check_yn.equals("N"))){ // Condition added for IN25957 --18/01/2011-- priya
					String strAD_DA ="'DA', 'AD'";		// Added for HSA-SCF-0011 [IN:042444]
					if(getExcludeADRAllergyAlert().equals("Y")){ 	//Added for HSA-SCF-0011 [IN:042444]
						strAD_DA = "'DA'";}		// Added for HSA-SCF-0011 [IN:042444]
					sql_query	= "select count(*) from (SELECT   a.adv_reac_code allergy_type_code, b.long_desc allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a,  am_reaction_lang_vw b,pr_allergy_sensitivity C, PH_DRUG d, pr_adverse_event adr  WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type in( "+strAD_DA+")  AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code  AND a.patient_id = ? AND b.reaction_code(+) = a.adv_reac_code  AND b.language_id(+) =? and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO AND C.STATUS = 'A' AND( (adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) union ALL SELECT adv_reac_code allergy_type_code, OTHERS_REACTION allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a ,pr_allergy_sensitivity C , PH_DRUG d, pr_adverse_event adr WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type ='DA' AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code AND a.patient_id = ?  AND a.adv_reac_code  ='Oth'and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO and adr.ALLERGY_ALERT_BY <> 'A' AND C.STATUS = 'A'  AND ((adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')))";// Changed for RUT-CRF-0065.1 [IN:43255]
					pstmt1				= connection.prepareStatement(sql_query) ;
					pstmt1.setString(1,drugCode);
					pstmt1.setString(2,patient_id);
					pstmt1.setString(3,locale);
					pstmt1.setString(4,drugCode);
					pstmt1.setString(5,patient_id);
					int rec_count=0;
					resultSetChk			= pstmt1.executeQuery();
					if(resultSetChk!=null && resultSetChk.next()){
						rec_count=resultSetChk.getInt(1);
					}
					closeResultSet( resultSetChk ) ;
					closeStatement( pstmt1 ) ;
					if(rec_count>0){
						DrugDetails.put("ALLERGY_YN","Y");
					}
					else{
						DrugDetails.put("ALLERGY_YN","N");
						//Code Added for	RUT-CRF-0065 IN 29603 - Start
						String ATC_allergy="0";
						if(!atc_allergy_alert_level.equals("N")){
							pstmt1				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL_ALLERGY_CHECK"));
							pstmt1.setString(1,patient_id);
							pstmt1.setString(2,generic_id);
							pstmt1.setString(3,atc_allergy_alert_level);
							resultSetChk			= pstmt1.executeQuery();
							if(resultSetChk!=null && resultSetChk.next())
								ATC_allergy = resultSetChk.getString("ATC_CHECK_EXISTS");
							closeResultSet( resultSetChk ) ;
							closeStatement( pstmt1 ) ;
							if(ATC_allergy!=null && !ATC_allergy.equals("0")){
								DrugDetails.put("ALLERGY_YN","Y");
							}
							else
								DrugDetails.put("ALLERGY_YN","N");
						}//Code Added for	RUT-CRF-0065 IN 29603 - End
					}
				}
				else{
					DrugDetails.put("ALLERGY_YN","N");
				}
				//pstmt1				= connection.prepareStatement("select E.EXT_PROD_DRUG_CODE EXT_PROD_DRUG_CODE, D.DRUG_DESC DRUG_DESC from PH_DRUG_EXT_PROD_DRUG E,PH_DRUG_LANG_VW D where D.DRUG_CODE in (SELECT  DRUG_CODE FROM  PH_PATIENT_DRUG_PROFILE A WHERE   PATIENT_ID =? AND END_DATE >= to_date(?,'dd/mm/yyyy hh24:mi') AND  TO_DATE(?,'DD/MM/RRRR HH24:MI') BETWEEN  TO_DATE(START_DATE,'DD/MM/RRRR HH24:MI') AND  TO_DATE(END_DATE,'DD/MM/RRRR HH24:MI')   AND DISCONT_DATE_TIME IS NULL AND ON_HOLD_DATE_TIME IS NULL AND  CANCEL_YN='N' AND   STOP_YN='N' AND 'O'!=(SELECT FREQ_NATURE FROM AM_FREQUENCY WHERE FREQ_CODE=?) AND GENERIC_ID=?) and D.DRUG_CODE = E.DRUG_CODE AND D.LANGUAGE_ID=? and EFF_STATUS ='E' and product_id = (select DRUG_DB_PRODUCT_ID from ph_facility_param where facility_id = ?)");
				pstmt1				= connection.prepareStatement("select ph_get_ext_prod_drug_code(d.drug_code,?)  EXT_PROD_DRUG_CODE, D.DRUG_DESC DRUG_DESC from PH_DRUG_LANG_VW D where D.DRUG_CODE in (SELECT  DRUG_CODE FROM  PH_PATIENT_DRUG_PROFILE A WHERE   PATIENT_ID =? AND END_DATE >= to_date(?,'dd/mm/yyyy hh24:mi') AND  TO_DATE(?,'DD/MM/RRRR HH24:MI') BETWEEN  TO_DATE(START_DATE,'DD/MM/RRRR HH24:MI') AND  TO_DATE(END_DATE,'DD/MM/RRRR HH24:MI')   AND DISCONT_DATE_TIME IS NULL AND ON_HOLD_DATE_TIME IS NULL AND  CANCEL_YN='N' AND   STOP_YN='N' AND 'O'!=(SELECT FREQ_NATURE FROM AM_FREQUENCY WHERE FREQ_CODE=?) AND GENERIC_ID=?)  AND D.LANGUAGE_ID=? ");

				pstmt1.setString(1,ord_facility_id); 
				pstmt1.setString(2,patient_id);
				pstmt1.setString(3,(String)DrugDetails.get("START_DATE_TIME"));
				pstmt1.setString(4,(String)DrugDetails.get("START_DATE_TIME"));
				pstmt1.setString(5,(String)DrugDetails.get("FREQ_CODE"));
				pstmt1.setString(6,generic_id);
				pstmt1.setString(7,getLanguageId());
				//pstmt1.setString(7,ord_facility_id); //priya
				resultSetChk			= pstmt1.executeQuery();
				ArrayList ext_prod_ids = new ArrayList();
				while(resultSetChk.next())	{
					if(resultSetChk.getString("EXT_PROD_DRUG_CODE")!=null && !resultSetChk.getString("EXT_PROD_DRUG_CODE").equals("")){
						ext_prod_ids.add(resultSetChk.getString("DRUG_DESC"));
						ext_prod_ids.add(resultSetChk.getString("EXT_PROD_DRUG_CODE"));
					}
				}
				closeResultSet( resultSetChk ) ;
				closeStatement( pstmt1 ) ;
				DrugDetails.put("EXT_PROD_IDS",ext_prod_ids);
				//Added for IN:070451 start
				String factor;
				String calc_by_ind=(String)DrugDetails.get("CALC_BY_IND");
				String weight = (String)DrugDetails.get("WEIGHT");
				String bsa = (String)DrugDetails.get("BSA");
				if(!weight.equals(""))
				{
					setWeight(weight);
					if(!(presBean==null))
					{//null handled
					presBean.setWeight(weight);
					}
				}
				if(!bsa.equals(""))
				{
					setBsa(bsa);
					if(!(presBean==null)){//null handled
					presBean.setBsa(Float.parseFloat(bsa));
					}
				}
				//presBean.setBsa((float) Double.parseDouble(bsa));
				if(calc_by_ind.equalsIgnoreCase("W")){
					if(!weight.equals(""))
						factor =weight;
					else
						factor ="1";
				}
				else if(calc_by_ind.equalsIgnoreCase("B")){
					if(!bsa.equals(""))
						factor =bsa;
					else
						factor ="1";
					 System.out.println("bsa"+bsa);
				}
				else{
					factor ="1";
				}
				//Added for IN:070451 end

				cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//Modified for IN:070451 added out params
				cstmt.setString( 1, drugCode);
				cstmt.setString( 2, patient_id);
				cstmt.setString( 3, proc_qty_value);
				cstmt.setString( 4, repeat_value);
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
				//Modified for IN:070451 start
			/*	if((!bsa.equals("")) || (calc_by_ind.equalsIgnoreCase("A") ) || (calc_by_ind.equalsIgnoreCase("W"))){
					DrugDetails.put("LIMIT_IND",limit_ind); removed for ml-mmoh-crf-1914
				
				}
				else{
					DrugDetails.put("LIMIT_IND","Y");
				}*/
				if(calc_by_ind.equalsIgnoreCase("W") && weight !="" )
				{
				DrugDetails.put("LIMIT_IND",limit_ind);
				}

				else if(calc_by_ind.equalsIgnoreCase("B") && !bsa.equals("")){
				DrugDetails.put("LIMIT_IND",limit_ind);
				}

				else if(calc_by_ind.equalsIgnoreCase("A")){
				DrugDetails.put("LIMIT_IND",limit_ind);
				}

				else{
				DrugDetails.put("LIMIT_IND","Y");
				}
				//Modified for IN:070451 end
				DrugDetails.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );//Modified for IN:070451 
				DrugDetails.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );//Modified for IN:070451
				DrugDetails.put("MONO_GRAPH","");
				DrugDetails.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );//Modified for IN:070451
				DrugDetails.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );//Modified for IN:070451
				DrugDetails.put("DOSAGE_UNIT",cstmt.getString(12));
				//Added for IN:070451 start,Null handled againest IN:071108 start
				DrugDetails.put("MAX_DAILY_CEELING_DOSE",(cstmt.getString(13)==null ? "":cstmt.getString(13)));
				DrugDetails.put("MIN_DAILY_CEELING_DOSE",(cstmt.getString(14)==null ? "":cstmt.getString(14)));
				DrugDetails.put("MAX_UNIT_CEELING_DOSE",(cstmt.getString(15)==null ? "":cstmt.getString(15)));
				DrugDetails.put("MIN_UNIT_CEELING_DOSE",(cstmt.getString(16)==null ? "":cstmt.getString(16)));
				//Added for IN:070451 end,Null handled againest IN:071108 start
				
//				sql_query			= PhRepository.getPhKeyValue("");
				sql_query			= "select TEMPLATE_ID, SRL_NO, RANGE_FROM, RANGE_TO, ADMIN_UNITS, REMARKS from OR_ORDER_LINE_PH_SLD_SCALE where ORDER_ID =?";

				if(!order_line_no.equals(""))
					sql_query = sql_query + " and ORDER_LINE_NUM = ?";
	
				pstmt1				= connection.prepareStatement(sql_query) ;
				pstmt1.setString(1,order_id);

				if(!order_line_no.equals(""))
					pstmt1.setString(2,order_line_no);
				result			= pstmt1.executeQuery();
		
				ArrayList ALtemp = new ArrayList();
				while(result.next()){
					DrugDetails.put("TEMPLATE_ID",(result.getString("TEMPLATE_ID")==null ? "":result.getString("TEMPLATE_ID")) );
					ALtemp.add((result.getString("SRL_NO")==null ? "":result.getString("SRL_NO")));
					ALtemp.add((result.getString("RANGE_FROM")==null ? "":result.getString("RANGE_FROM")));
					ALtemp.add((result.getString("RANGE_TO")==null ? "":result.getString("RANGE_TO")));
					ALtemp.add((result.getString("ADMIN_UNITS")==null ? "":result.getString("ADMIN_UNITS")));
					remarks = result.getString("REMARKS")==null ? "":result.getString("REMARKS");          
					if(remarks !=null || !remarks.equals(""))
						remarks = java.net.URLEncoder.encode(remarks,"UTF-8");	
					ALtemp.add(remarks);
				}

				DrugDetails.put("SLDSCALE_TMPL_DTL",ALtemp);
				closeResultSet( result ) ;
				closeStatement( pstmt1 ) ;
				
				DrugDetails.put("FREQ_DURN_TYPE",(resultSet.getString("FREQ_DURN_TYPE")==null ? "":resultSet.getString("FREQ_DURN_TYPE")));
				
				if(!((String)DrugDetails.get("REPEAT_DURN_TYPE")).equals((String)DrugDetails.get("FREQ_DURN_TYPE"))){
					freq_durn_value = getFreqDurnConvValue((String)DrugDetails.get("FREQ_DURN_TYPE"),(String)DrugDetails.get("DURN_VALUE"),(String)DrugDetails.get("REPEAT_DURN_TYPE"));
				}else{
					freq_durn_value = (String)DrugDetails.get("DURN_VALUE");
				}
				DrugDetails.put("FREQ_DURN_VALUE",freq_durn_value);
				
				// RUT-CRF-0062 [IN029600]  Added to get Build MAR Rule -- begin
				String patClass="";
				if(getActPatientClass_frm_Hdr().toUpperCase().equals("IP") && (DrugDetails.get("TAKE_HOME").toString().toUpperCase().equals("D")||DrugDetails.get("TAKE_HOME").toString().toUpperCase().equals("Y")))
					patClass="DM";
				else
					patClass=getActPatientClass_frm_Hdr();
				DrugDetails.put("BUILD_MAR_RULE",getMARDefaulting(patClass,source_code,form_code,priority));
				if(limit_ind!=null && limit_ind.equals("N")){				
					DrugDetails.put("MONO_GRAPH",(cstmt.getString(9)==null ? "":cstmt.getString(9)) );
				}
				try{
					closeStatement( cstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
				//Added for	RUT-CRF-0066 IN[029604] - start
				DrugDetails.put("INTR_RESTRIC_TRN", "N");
				DrugDetails.put("INTERACTION_EXISTS", "N" );
				DrugDetails.put("DRUGINTRACTION_OVERRIDE","N");
				DrugDetails.put("INTR_ALERT", "N" );
				//DrugDetails.put("INTR_MSG_CONTENT", "" );
				if(!drug_db_interface_yn.equals("Y") || DrugDetails.get("EXTERNAL_PRODUCT_ID").equals("") ){ 
					ArrayList alDrugIntrDtlList = getDrugInteractionDtls(drugCode, form_code, generic_id,resultSet.getString("START_DATE_TIME"),resultSet.getString("END_DATE_TIME") , patient_id);
					if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
						DrugDetails.put("SEVERITY_LEVEL", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2) );
						DrugDetails.put("INTR_RESTRIC_TRN", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1) );
						DrugDetails.put("INTERACTION_DTL", alDrugIntrDtlList );
						DrugDetails.put("INTERACTION_EXISTS", "Y" );
						if(((String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1)).equals("Y") || ((String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2)).equals("H")){
							DrugDetails.put("INTR_ALERT", "Y" );
						}
					}
				}//Added for	RUT-CRF-0066 IN[029604] - end
				DrugDetails.put("EXT_DISP_APPL_YN", ext_disp_appl_yn);   //Added for NMC-JD-CRF-0046-Amend order
			//added for aakh-crf-0140 start
			DrugDetails.put("ABUSE_RESTRIC_TRN", "N");
			DrugDetails.put("ABUSE_EXISTS", "N" );
			DrugDetails.put("ABUSE_REMARKS","N");
			DrugDetails.put("ABUSE_ACTION", "N" );
			DrugDetails.put("ABUSE_TYPE", "N" );
			DrugDetails.put("ABUSE_DRUG_DESC","");
			DrugDetails.put("DRUG_CLASS_OR_DRUG_CODE","");
			
			//if(!drug_db_interface_yn.equals("Y") || DrugDetails.get("EXTERNAL_PRODUCT_ID").equals("") ){ 
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
					
				DrugDetails.put("DIAGNOSIS_FOUND_YN", resultSet.getString("DIAGNOSIS_FOUND_YN"));//added for mms-DM-crf-0204
				System.out.println("loadamendDetails"+resultSet.getString("DIAGNOSIS_FOUND_YN"));
				presDetails.add(DrugDetails);
				amendDetails.add(presamendDetails);
				i++;
			}
			//presDetails.add(DrugDetails);
			//amendDetails.add(presamendDetails);
			//added for aakh-crf-0140 end
			
			ArrayList unique_drugs	=	new ArrayList();
			HashMap position_ptr	=	new HashMap();
			String drug_code		=	"";
			String pos				=	"";
			for(int j=0; j<presDetails.size(); j++) {
				drug_code	=	(String)((HashMap)presDetails.get(j)).get("DRUG_CODE");
				if(!unique_drugs.contains(drug_code)) {
					unique_drugs.add(drug_code);
					((HashMap)presDetails.get(j)).put("FLAG","Y");
					position_ptr.put(drug_code,j+"");
				} 
				else {
					pos	=	(String)position_ptr.get(drug_code);
					position_ptr.put(drug_code,j+"");
					((HashMap)presDetails.get(j)).put("FLAG","Y");
					((HashMap)presDetails.get(Integer.parseInt(pos))).put("FLAG","N");
				}
			}
	//		DrugDetails.put("EXT_DISP_APPL_YN", ext_disp_appl_yn);   //Added for NMC-JD-CRF-0046-Amend order and moved to up
		} 
		catch ( Exception e ) {
			//presDetails.add("ERROR :"+e);
			DrugDetails.put("STOCK_AVAILABLE_YN","Y");
			DrugDetails.put("AVAILABLE_STOCK","1000");
			presDetails.add(DrugDetails);
			amendDetails.add(presamendDetails);
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( result );
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeResultSet( result_oth ) ;
				closeStatement( pstmt_oth ) ;
				closeStatement( pstmt ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return presDetails;
	}

	public HashMap loadDrugDetails(String priority,String take_home_medication,String locn_type,String locn_code,String facility_id, String drugCode,String patientClass,String patient_id,String sys_date,String srlNo, String order_set_code, String order_set_occur_num, String drug_db_interface_yn, String trade_code, String trade_name, String act_patient_class, String pract_id, String resp_id, String encounter_id,String home_leave_yn_val){//added home_leave_yn_val for Bru-HIMS-CRF-093[29960] -->
	System.out.println("-->>>loaddrugdetails--<2196");
		Connection connection				= null;
        PreparedStatement pstmt				= null;
		PreparedStatement pstmt_copy		= null;
        ResultSet resultSet					= null;
		ResultSet res_copy					= null;
		CallableStatement cstmt				= null;
		String sql_query					= null;
		String durn_value					= null;
		String durn_type					= null;
		String freq_code					= null;
		String repeat_durn_type				= null;
		String calc_dosg_by_freq_durn_yn	= null;
		String strength_value				= null;
		String qty_value					= null;
		String qty_desc_code				= null;
		String pres_base_uom				= null;
		String strength_uom					= null;
		String dosage_type					= null;
		String repeat_value					= null;
		String order_type_code				= null;
		String generic_id					= null;
		String end_date						= null;
		String item_code					= null;
		String fract_dose					= null;
		String content_in_pres_base_uom		= null;
		String strength_per_pres_uom		= null;
		String strength_per_value_pres_uom	= null;
		String form_code					= null;
		int index							= 0;
		String ord_det						= null;
		String order_id						= null;
		String ord_line						= null;
		String copied_ord_status			= null;
		String freq_nature					= "";
		String interval_value				= null;
		String formulary					= null;
		String calc_dflt_dosage_by_htwt		= null;
		String proc_qty_value				= null;
		String duplicate_check_at_atc_yn	= null;
		//String external_prod_id="";
		String date_str = null;
		String fract_dose_appl_yn = null;
		String wt_mand_yn = "";
		String ht_mand_yn = ""; //added for Bru-HIMS-CRF-079 IN[029945] 
		String performing_facility_id = null;
		String	srl_no = null;
		String	range_from = null;
		String	range_to = null;
		String	admin_units = null; 
		String	remarks = null;
		String external_product_id ="";
		ArrayList	sldscale_tmpl_dtl = new ArrayList();
		HashMap DrugDetails			= new HashMap();
		locale= getLanguageId()==null?"en":getLanguageId();
		String default_dosage_by		 = "";
		String drug_indication			 = "";
		String route_code="",route_desc="", route_color="";
		String preg_yn=getPregnencyYN();
		String trimester=getPregTrimester();
		String drug_class = "";
		boolean site_verbal_order=false;//added for ghl-crf-0509
		String ext_disp_appl_yn=""; // IN071763 
		String drug_desc_new = "" ; //Added for TFS id:7345
	    String billable_item_yn=""; //Added for ML-BRU-SCF-2229
		boolean site_alw_disp_loc_drug_search_appl=false;//added for NMC-JD-CRF-0197
		
		try {
			String act_pat_class = getActPatientClass_frm_Hdr();// RUT-CRF-0062 [IN029600]  Added to get Build MAR Rule -- begin
			if(act_pat_class==null||act_pat_class.equals(""))//IN301118-SCF No: MO-GN-5400. Duplicate Drug Check.
				act_pat_class="";
			 String buildMAR_rule_org = getMARDefaulting(act_pat_class,locn_code,form_code,priority);//added for skr-scf-1714
			System.out.println("2303 buildMAR_rule_org"+buildMAR_rule_org);
			if(getActPatientClass_frm_Hdr().toUpperCase().equals("IP") && (take_home_medication.toUpperCase().equals("Y") || take_home_medication.toUpperCase().equals("D"))){
				 act_pat_class = "OP";
			}
			//added for ML-MMOH-SCF-1646
			if(act_pat_class.equals("DC") && (take_home_medication.toUpperCase().equals("Y") || take_home_medication.toUpperCase().equals("D"))){
				 act_pat_class = "OP";
			}
			connection = getConnection() ;
			site_verbal_order = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","PLACED_VERBAL_ORDER_YN");//added for ghl-crf-0509
			site_alw_disp_loc_drug_search_appl = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","PH_DISP_LOC_DRUG_SEARCH");//added for NMC-JD-CRF-0197
		//	sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT1A");//diagnosis_found_yn added for mms-dm-crf-0204
			sql_query		=	"SELECT ITEM_CODE,DRUG_CODE, ph_get_ext_prod_drug_code(?,?) EXTERNAL_PRODUCT_ID, DRUG_DESC,STOCK_UOM_DESC, IN_FORMULARY_YN,GENERIC_ID,GENERIC_NAME,DRUG_CLASS,FORM_CODE,FORM_DESC,PH_DRUG_VW.ROUTE_CODE,PH_DRUG_VW.ROUTE_DESC,PRES_BASE_UOM,PRES_BASE_UOM_DESC,STRENGTH_VALUE,STRENGTH_UOM,STRENGTH_UOM_DESC,STRENGTH_PER_PRES_UOM,STRENGTH_PER_VALUE_PRES_UOM,PRES_CATG_CODE,TRADE_CODE,TRADE_NAME,CALC_DOSG_BY_FREQ_DURN_YN,IV_INGREDIENT_YN,IV_FLUID_YN,  INFUSE_OVER_VALUE,DEFAULT_ROUTE_YN,INFUSE_OVER_DURN_TYPE,FRACT_DOSE_ROUND_UP_YN,CONTENT_IN_PRES_BASE_UOM,PRN_DOSES_PRES_PRD_FILL,STOCK_UOM,STOCK_UOM_DESC,CALC_DEF_DOSAGE_YN,PT_COUN_REQD_YN,FRACT_DOSE_APPL_YN, WEIGHT_REC_APPL_AGE_GROUP,BILLABLE_ITEM_YN,B.ROUTE_COLOR,DEFAULT_DOSAGE_BY,DRUG_INDICATION,PREG_CATEGORY_GROUP_CODE,PREG_EFFECT_FT,PREG_EFFECT_ST,PREG_EFFECT_TT,PREG_WARN_REQ_FT_YN,PREG_WARN_REQ_ST_YN,PREG_WARN_REQ_TT_YN,PREG_CATEGORY_CODE1,PREG_CATEGORY_CODE2,PREG_CATEGORY_CODE3,C.CATEGORY_GROUP_DESC,DEFAULT_DOSAGE_BY_YN,PATIENT_STOCK_REQUIRED,DISP_ALT_FORM_YN,NVL(DRUG_SEARCH_BY,'G') DRUG_SEARCH_BY,NVL ((SELECT MAX (DECODE ((SELECT DISTINCT 'Y' FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id =  ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id =?  AND pr_diag.curr_status != 'E' AND pr_diag.curr_encounter_id = ?),NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = ph_drug_vw.drug_code AND ph_elig.eff_status = 'E'),'Y') diagnosis_found_yn FROM PH_DRUG_VW_LANG_VW PH_DRUG_VW,PH_ROUTE B,PH_PREGN_CAT_GROUP_HDR C WHERE DRUG_CODE=? AND NVL(trade_code,'X') = DECODE(?,NULL,NVL (trade_code, 'X'),?) AND LANG1 = ? AND  B.ROUTE_CODE = PH_DRUG_VW.ROUTE_CODE AND ph_drug_vw.PREG_CATEGORY_GROUP_CODE = c.CATEGORY_GROUP_CODE(+) "; //added DEFAULT_DOSAGE_BY_YN  for AAKH-CRF-089 //add DEFAULT_DOSAGE_BY for SKR-CRF-PHIS-003[IN028182] //AND DECODE(LANG2,NULL,?,LANG2)= ?  AND DECODE(LANG3,NULL,?,LANG3)= ?  //Pregnency related changes added for  RUT-CRF-0063 [IN:029601] and patient_stock_required added for GHL-CRF-0482,Modified for TFS id:7345 added new column drug_search_by in select statement
			//DISP_ALT_FORM_YN added for GHL-CRF-0549
			pstmt				= connection.prepareStatement(sql_query) ;
			System.out.println("encounter_id"+encounter_id);
			pstmt.setString(1,drugCode);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,patient_id);//added for mms-dm-crf-0204
			pstmt.setString(4,encounter_id);
			
			pstmt.setString(5,drugCode);
			pstmt.setString(6,trade_code);
			pstmt.setString(7,trade_code);
			pstmt.setString(8,locale);
			/*pstmt.setString(7,locale);
			pstmt.setString(8,locale);
			pstmt.setString(9,locale);
			pstmt.setString(10,locale); */  //commented for ph_drug_vw_lang_vw - language issue
			resultSet			= pstmt.executeQuery(); 
			if(resultSet.next()) {
				DrugDetails.put("SRL_NO",srlNo);
				DrugDetails.put("AMEND_YN","N");
				DrugDetails.put("rowVal",srlNo);
				DrugDetails.put("ORDER_SET_CODE",order_set_code);
				DrugDetails.put("ORDER_SET_OCCUR_NUM",order_set_occur_num);
				DrugDetails.put("DRUG_CODE", (resultSet.getString("DRUG_CODE")==null ? "":resultSet.getString("DRUG_CODE")) );
				DrugDetails.put("PATIENT_CLASS",patientClass);
				DrugDetails.put("TRADE_CODE",trade_code);
				DrugDetails.put("TRADE_NAME",trade_name);
				DrugDetails.put("SPLIT_DOSE_YN_VAL","N");
				DrugDetails.put("DISP_ALT_FORM_YN",resultSet.getString("DISP_ALT_FORM_YN"));//GHL-CRF-549 
				DrugDetails.put("PATIENT_STOCK_REQUIRED",(resultSet.getString("PATIENT_STOCK_REQUIRED")==null ? "N":resultSet.getString("PATIENT_STOCK_REQUIRED")));//added for GHL-CRF-0482
				item_code = resultSet.getString("ITEM_CODE")==null ? "":resultSet.getString("ITEM_CODE");
				DrugDetails.put("ITEM_CODE",item_code);
				DrugDetails.put("DRUG_DESC",(resultSet.getString("DRUG_DESC")==null ? "":resultSet.getString("DRUG_DESC")) );
				DrugDetails.put("IN_FORMULARY_YN",(resultSet.getString("IN_FORMULARY_YN")==null ? "N":resultSet.getString("IN_FORMULARY_YN")) );
				formulary	=	(resultSet.getString("IN_FORMULARY_YN")==null ? "N":resultSet.getString("IN_FORMULARY_YN"));
				DrugDetails.put("GENERIC_ID",(resultSet.getString("GENERIC_ID")==null ? "":resultSet.getString("GENERIC_ID")) );
				generic_id = resultSet.getString("GENERIC_ID");
				DrugDetails.put("GENERIC_NAME",(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME")) );
				DrugDetails.put("DRUG_CLASS",(resultSet.getString("DRUG_CLASS")==null ? "":resultSet.getString("DRUG_CLASS")) );
				drug_class=resultSet.getString("DRUG_CLASS");

				DrugDetails.put("FORM_CODE",(resultSet.getString("FORM_CODE")==null ? "":resultSet.getString("FORM_CODE")) );
				DrugDetails.put("FORM_DESC",(resultSet.getString("FORM_DESC")==null ? "":resultSet.getString("FORM_DESC")) );
				DrugDetails.put("PRES_BASE_UOM",(resultSet.getString("PRES_BASE_UOM")==null ? "":resultSet.getString("PRES_BASE_UOM")) );
				DrugDetails.put("PRES_BASE_UOM_DESC",(resultSet.getString("PRES_BASE_UOM_DESC")==null ? "":resultSet.getString("PRES_BASE_UOM_DESC")) );
				DrugDetails.put("ACT_STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE")) );
				DrugDetails.put("STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE")) );
				DrugDetails.put("DEFAULT_DOSAGE_BY_YN",(resultSet.getString("DEFAULT_DOSAGE_BY_YN")==null ? "": resultSet.getString("DEFAULT_DOSAGE_BY_YN")));//Added DEFAULT_DOSAGE_BY_YN to make initial qty value is Empty AAKH-CRF-089
				DrugDetails.put("STRENGTH_UOM",(resultSet.getString("STRENGTH_UOM")==null ? "":resultSet.getString("STRENGTH_UOM")) );
				DrugDetails.put("STRENGTH_UOM_DESC",(resultSet.getString("STRENGTH_UOM_DESC")==null ? "":resultSet.getString("STRENGTH_UOM_DESC")) );
				drug_desc_new=(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME"))+" "+(resultSet.getString("STRENGTH_VALUE")==null ? "":resultSet.getString("STRENGTH_VALUE"))+" "+(resultSet.getString("STRENGTH_UOM_DESC")==null ? "":resultSet.getString("STRENGTH_UOM_DESC"))+" "+(resultSet.getString("STOCK_UOM_DESC")==null ? "":resultSet.getString("STOCK_UOM_DESC"));//Added for TFS id:7345
				DrugDetails.put("DRUG_DESC_NEW",drug_desc_new );//Added for TFS id:7345
				DrugDetails.put("DRUG_SEARCH_BY",(resultSet.getString("DRUG_SEARCH_BY")==null ? "":resultSet.getString("DRUG_SEARCH_BY")) );//Added for TFS id:7345
				
				DrugDetails.put("STRENGTH_PER_PRES_UOM",(resultSet.getString("STRENGTH_PER_PRES_UOM")==null ? "1":resultSet.getString("STRENGTH_PER_PRES_UOM")) );
				DrugDetails.put("STRENGTH_PER_VALUE_PRES_UOM",(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null ? "1":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")) );
				DrugDetails.put("PRES_CATG_CODE",(resultSet.getString("PRES_CATG_CODE")==null ? "":resultSet.getString("PRES_CATG_CODE")) );
				DrugDetails.put("CALC_DOSG_BY_FREQ_DURN_YN",(resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")==null ? "":resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")) );
				DrugDetails.put("DEFAULT_ROUTE_YN",(resultSet.getString("DEFAULT_ROUTE_YN")==null ? "":resultSet.getString("DEFAULT_ROUTE_YN")) ); 
				route_code = resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE");
				route_desc = resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC");
				route_color = resultSet.getString("ROUTE_COLOR")==null ? "":resultSet.getString("ROUTE_COLOR");
				if(resultSet.getString("DEFAULT_ROUTE_YN")!=null && resultSet.getString("DEFAULT_ROUTE_YN").equals("Y")){ // if condition Added for RUT-CRF-0034 ICN 29927
					DrugDetails.put("ROUTE_CODE", route_code);
					DrugDetails.put("ROUTE_DESC",route_desc );
					DrugDetails.put("ROUTE_COLOR",route_color );  //Added for RUT-CRF-0034 ICN 29927
				}
				external_product_id  =resultSet.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet.getString("EXTERNAL_PRODUCT_ID"); 
				DrugDetails.put("EXTERNAL_PRODUCT_ID",external_product_id );                   
				DrugDetails.put("DEFAULT_DOSAGE_BY",(resultSet.getString("DEFAULT_DOSAGE_BY")==null ? "":resultSet.getString("DEFAULT_DOSAGE_BY"))); //add DEFAULT_DOSAGE_BY for SKR-CRF-PHIS-003[IN028182]
				default_dosage_by = resultSet.getString("DEFAULT_DOSAGE_BY")==null ? "":resultSet.getString("DEFAULT_DOSAGE_BY"); //add DEFAULT_DOSAGE_BY for SKR-CRF-PHIS-003[IN028182]
				drug_indication =resultSet.getString("DRUG_INDICATION")==null ? "":resultSet.getString("DRUG_INDICATION");//Added drug_indication for  ML-BRU-CRF-072[Inc:29938]
				DrugDetails.put("DRUG_INDICATION",drug_indication);//Added drug_indication for  ML-BRU-CRF-072[Inc:29938] 
				fract_dose_appl_yn = resultSet.getString("FRACT_DOSE_APPL_YN")==null? "":resultSet.getString("FRACT_DOSE_APPL_YN");
				DrugDetails.put("FRACT_DOSE_APPL_YN",fract_dose_appl_yn);
				if(fract_dose_appl_yn.equals("Y")){
					DrugDetails.put("FRACT_DOSE_ROUND_UP_YN",(resultSet.getString("FRACT_DOSE_ROUND_UP_YN")==null ? "":resultSet.getString("FRACT_DOSE_ROUND_UP_YN")) );
				}
				else{
					DrugDetails.put("FRACT_DOSE_ROUND_UP_YN","N");
				}
				DrugDetails.put("CONTENT_IN_PRES_BASE_UOM",(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null ? "":resultSet.getString("CONTENT_IN_PRES_BASE_UOM")) );
				DrugDetails.put("STOCK_UOM",(resultSet.getString("STOCK_UOM")==null ? "":resultSet.getString("STOCK_UOM")) );
				DrugDetails.put("STOCK_UOM_DESC",(resultSet.getString("STOCK_UOM_DESC")==null ? "":resultSet.getString("STOCK_UOM_DESC")) );
				DrugDetails.put("PRN_DOSES_PRES_PRD_FILL",(resultSet.getString("PRN_DOSES_PRES_PRD_FILL")==null ? "":resultSet.getString("PRN_DOSES_PRES_PRD_FILL")));
				DrugDetails.put("CALC_DEF_DOSAGE_YN",(resultSet.getString("CALC_DEF_DOSAGE_YN")==null ? "":resultSet.getString("CALC_DEF_DOSAGE_YN")));
				//added for  RUT-CRF-0063 [IN:029601]
                if(preg_yn.equals("Y")){
					DrugDetails.put("PREG_CATEGORY_GROUP_CODE",(resultSet.getString("PREG_CATEGORY_GROUP_CODE")==null ? "":resultSet.getString("PREG_CATEGORY_GROUP_CODE")));
					DrugDetails.put("CATEGORY_GROUP_DESC",(resultSet.getString("CATEGORY_GROUP_DESC")==null ? "":resultSet.getString("CATEGORY_GROUP_DESC")));
					if(trimester.equals("First Trimester")){
						DrugDetails.put("PREG_EFFECT",(resultSet.getString("PREG_EFFECT_FT")==null ? "":resultSet.getString("PREG_EFFECT_FT")));
						DrugDetails.put("PREG_WARN_REQ_YN",(resultSet.getString("PREG_WARN_REQ_FT_YN")==null ? "":resultSet.getString("PREG_WARN_REQ_FT_YN")));
						DrugDetails.put("PREG_CATEGORY_CODE",(resultSet.getString("PREG_CATEGORY_CODE1")==null ? "":resultSet.getString("PREG_CATEGORY_CODE1")));
					}
					else if(trimester.equals("Second Trimester")){
						DrugDetails.put("PREG_EFFECT",(resultSet.getString("PREG_EFFECT_ST")==null ? "":resultSet.getString("PREG_EFFECT_ST")));
						DrugDetails.put("PREG_WARN_REQ_YN",(resultSet.getString("PREG_WARN_REQ_ST_YN")==null ? "":resultSet.getString("PREG_WARN_REQ_ST_YN")));
						DrugDetails.put("PREG_CATEGORY_CODE",(resultSet.getString("PREG_CATEGORY_CODE2")==null ? "":resultSet.getString("PREG_CATEGORY_CODE2")));
					}
					else if(trimester.equals("Thrid Trimester")){
						DrugDetails.put("PREG_EFFECT",(resultSet.getString("PREG_EFFECT_TT")==null ? "":resultSet.getString("PREG_EFFECT_TT")));
						DrugDetails.put("PREG_WARN_REQ_YN",(resultSet.getString("PREG_WARN_REQ_TT_YN")==null ? "":resultSet.getString("PREG_WARN_REQ_TT_YN")));
						DrugDetails.put("PREG_CATEGORY_CODE",(resultSet.getString("PREG_CATEGORY_CODE3")==null ? "":resultSet.getString("PREG_CATEGORY_CODE3")));
					}
				}
				//adding end for  RUT-CRF-0063 [IN:029601]

				content_in_pres_base_uom	= resultSet.getString("CONTENT_IN_PRES_BASE_UOM");
				calc_dosg_by_freq_durn_yn	= resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")==null?"":resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN");
				strength_value				= resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE");
				strength_value				= strength_value.trim();
				pres_base_uom				= resultSet.getString("PRES_BASE_UOM");
				strength_uom				= resultSet.getString("STRENGTH_UOM");
				fract_dose					= (resultSet.getString("FRACT_DOSE_ROUND_UP_YN")==null ? "":resultSet.getString("FRACT_DOSE_ROUND_UP_YN"));
				strength_per_pres_uom		= (resultSet.getString("STRENGTH_PER_PRES_UOM")==null ? "1":resultSet.getString("STRENGTH_PER_PRES_UOM"));
				strength_per_value_pres_uom	= (resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null ? "1":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM"));
				form_code					= (resultSet.getString("FORM_CODE")==null ? "":resultSet.getString("FORM_CODE"));
				calc_dflt_dosage_by_htwt	= (resultSet.getString("CALC_DEF_DOSAGE_YN")==null ? "":resultSet.getString("CALC_DEF_DOSAGE_YN"));	
				DrugDetails.put("PT_COUN_REQD_YN", (resultSet.getString("PT_COUN_REQD_YN")==null ? "":resultSet.getString("PT_COUN_REQD_YN")));	
				if(strength_per_pres_uom.equals(""))
					strength_per_pres_uom="1";
				if(strength_per_value_pres_uom.equals("") || strength_per_value_pres_uom.equals("0")){
					strength_per_value_pres_uom="1";
					DrugDetails.put("STRENGTH_PER_VALUE_PRES_UOM",strength_per_value_pres_uom);
				}
				DrugDetails.put("BILLABLE_ITEM_YN", (resultSet.getString("BILLABLE_ITEM_YN")==null ? "":resultSet.getString("BILLABLE_ITEM_YN")));	
				System.out.println("DIAGNOSIS_FOUND_YN"+(resultSet.getString("DIAGNOSIS_FOUND_YN")==null ? "N":resultSet.getString("DIAGNOSIS_FOUND_YN")));
				DrugDetails.put("DIAGNOSIS_FOUND_YN",(resultSet.getString("DIAGNOSIS_FOUND_YN")==null ? "N":resultSet.getString("DIAGNOSIS_FOUND_YN")));
				
				billable_item_yn = resultSet.getString("BILLABLE_ITEM_YN")==null ? "":resultSet.getString("BILLABLE_ITEM_YN"); // Added for ML-BRU-SCF-2229
				System.out.println("billable_item_yn="+billable_item_yn);
			}	
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
			//AAKH-CRF-0091 starts
			String stat_drug_yn ="";
			if(getStatDrug_Yn().containsKey("stat_"+drugCode)){
				
				stat_drug_yn =(String)(getStatDrug_Yn().get("stat_"+drugCode)); 	
				
			}
			
					
			if(stat_drug_yn!=null && stat_drug_yn.equals("Y")){
				priority="U";
				DrugDetails.put("PRIORITY",priority);
				System.out.println("===1983==="+priority);
			}
			else{
				DrugDetails.put("PRIORITY",priority);
			}
			//DrugDetails.put("PRIORITY",priority);	
			//AAKH-CRF-0091 ends			
			DrugDetails.put("ORD_AUTH_REQD_YN","N");
			DrugDetails.put("ORD_SPL_APPR_REQD_YN","N");
			DrugDetails.put("ORD_COSIGN_REQD_YN","N");
			DrugDetails.put("ORD_AUTHORIZED_YN","N" );
			DrugDetails.put("ORD_APPROVED_YN","N");
			DrugDetails.put("ORD_COSIGNED_YN","N");
			DrugDetails.put("ORD_AUTHORIZED_PREV_YN","N");
			DrugDetails.put("QUOTA_LIMIT_ACCESS_YN","N");// ML-MMOH-CRF-1823 US008- 43528 
					
			if(this.pat_specialty_code ==null || this.pat_specialty_code.equals("")) {
                 getPat_specialty_code( facility_id, encounter_id);                       
			}	
			DrugDetails.put("PAT_SPECIALTY_CODE",this.pat_specialty_code );

			cstmt=connection.prepareCall("{call PH_ORDER_CATALOG_AUTH_RULE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");// ML-MMOH-CRF-1823 US008- 43528 
			cstmt.setString( 1, drugCode);
			cstmt.setString( 2, act_pat_class);  // patientClass changed to act_pat_class for ML-BRU-SCF-0898 [IN:041176]
			cstmt.setString( 3, locale);
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
			cstmt.registerOutParameter(18, Types.VARCHAR ); // ML-MMOH-CRF-1823 US008- 43528 
			cstmt.execute() ;
	
			DrugDetails.put("ORD_AUTH_REQD_YN",(cstmt.getString(8)==null ? "N":cstmt.getString(8)));
			DrugDetails.put("ORD_SPL_APPR_REQD_YN",(cstmt.getString(9)==null ? "N":cstmt.getString(9)) );
			DrugDetails.put("ORD_COSIGN_REQD_YN",(cstmt.getString(10)==null ? "N":cstmt.getString(10)) );
			DrugDetails.put("ORD_AUTHORIZED_PREV_YN",(cstmt.getString(11)==null ? "N":cstmt.getString(11)) );
			DrugDetails.put("ORD_APPROVED_YN",(cstmt.getString(12)==null ? "N":cstmt.getString(12)) );
			DrugDetails.put("ORD_COSIGNED_YN",(cstmt.getString(13)==null ? "N":cstmt.getString(13)) );
			DrugDetails.put("PAT_SPECIALTY_CODE",(cstmt.getString(14)==null ? "N":cstmt.getString(14)) );
			DrugDetails.put("ORD_AUTHORIZED_YN",(String)DrugDetails.get("ORD_AUTHORIZED_PREV_YN"));
			DrugDetails.put("QUOTA_LIMIT_ACCESS_YN",(cstmt.getString(18)==null ? "N":cstmt.getString(18)) ); //ML-MMOH-CRF-1823 - 43528
					
			//ADDED FOR MO-SCF-5533 start
			sql_query			= "select AUTH_YN from or_review_user_categories where  PRACTITIONER_ID=? AND ORDER_CATEGORY='PH'";
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,pract_id);
			
			resultSet			= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				
				DrugDetails.put("ORD_AUTHORIZED_YN_DURN", resultSet.getString("AUTH_YN")==null?"N":resultSet.getString("AUTH_YN"));
			}
			//ADDED FOR MO-SCF-5533 end
			
			try{
				closeStatement( cstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}

			//DrugDetails.put("BL_DECIMAL_FORMAT_STRING",getDecimalFormatString()); //priya --added for IN19010 --24/02/2010
			DrugDetails.put("BL_DECIMAL_FORMAT_STRING",this.bl_decimalFormatString); //priya --added for IN19010 --24/02/2010
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT2A");//Corrected During PE By Naveen SQL_PH_PRESCRIPTION_SELECT2A and SQL_PH_PRESCRIPTION_SELECT_CONSENT_DETAILS are merged

			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drugCode);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				DrugDetails.put("ORDER_CATALOG_CODE",(resultSet.getString("ORDER_CATALOG_CODE")==null ? "":resultSet.getString("ORDER_CATALOG_CODE")) );
				DrugDetails.put("SHORT_DESC",(resultSet.getString("SHORT_DESC")==null ? "":resultSet.getString("SHORT_DESC")) );
				DrugDetails.put("ORDER_TYPE_CODE",(resultSet.getString("ORDER_TYPE_CODE")==null ? "":resultSet.getString("ORDER_TYPE_CODE")) );
				order_type_code= resultSet.getString("ORDER_TYPE_CODE");
				DrugDetails.put("SECURITY_LEVEL",(resultSet.getString("SECURITY_LEVEL")==null ? "":resultSet.getString("SECURITY_LEVEL")) );
				DrugDetails.put("QTY_UOM",(resultSet.getString("QTY_UOM")==null ? "":resultSet.getString("QTY_UOM")) );
				DrugDetails.put("SPLIT_DOSE_YN",(resultSet.getString("SPLIT_DOSE_YN")==null ? "N":resultSet.getString("SPLIT_DOSE_YN")) );
				DrugDetails.put("SPLIT_DOSE","N");
				DrugDetails.put("TAPER_DOSE_YN",(resultSet.getString("TAPER_DOSE_YN")==null ? "":resultSet.getString("TAPER_DOSE_YN")) );
				DrugDetails.put("TAPER_UP",(resultSet.getString("TAPER_UP")==null ? "":resultSet.getString("TAPER_UP")) );
				DrugDetails.put("BILL_YN",(resultSet.getString("BILL_YN")==null ? "":resultSet.getString("BILL_YN")) );
				DrugDetails.put("QTY_REQD_YN",(resultSet.getString("QTY_REQD_YN")==null ? "N":resultSet.getString("QTY_REQD_YN")) );
				DrugDetails.put("REFILL_CONT_ORDER_YN",(resultSet.getString("REFILL_CONT_ORDER_YN")==null ? "N":resultSet.getString("REFILL_CONT_ORDER_YN")) );
				DrugDetails.put("CONSENT_REQD_YN",(resultSet.getString("CONSENT_REQD_YN")==null ? "N":resultSet.getString("CONSENT_REQD_YN")) );
				DrugDetails.put("CHART_RESULT_TYPE",(resultSet.getString("CHART_RESULT_TYPE")==null ? "N":resultSet.getString("CHART_RESULT_TYPE")) );
				DrugDetails.put("CHART_RESULT_TYPE",(resultSet.getString("CHART_RESULT_TYPE")==null ? "N":resultSet.getString("CHART_RESULT_TYPE")) );
				DrugDetails.put("RESULT_AUTH_REQD_YN",(resultSet.getString("RESULT_AUTH_REQD_YN")==null ? "N":resultSet.getString("RESULT_AUTH_REQD_YN")) );
				//DrugDetails.put("PH_DRUG_OVERLAP_PERIOD",(resultSet.getString("PH_DRUG_OVERLAP_PERIOD")==null ? "":resultSet.getString("PH_DRUG_OVERLAP_PERIOD")) );  // Added for MO-CRF-20085.1 [IN057392]
				if(DrugDetails.get("CONSENT_REQD_YN").equals("Y")){
					DrugDetails.put("CONSENT_STAGE",(resultSet.getString("CONSENT_STAGE")==null ?"":resultSet.getString("CONSENT_STAGE")) );
					if(resultSet.getString("CONSENT_STAGE")!=null && resultSet.getString("CONSENT_STAGE").equals("R"))
						DrugDetails.put("CONSENT_STATUS","P" );
					else
						DrugDetails.put("CONSENT_STATUS","");
					DrugDetails.put("NUM_OF_CONSENT_REQ_BO",(resultSet.getString("NUM_OF_CONSENT_REQ_BO")==null?"":resultSet.getString("NUM_OF_CONSENT_REQ_BO")) );
					DrugDetails.put("NUM_OF_CONSENT_REQ_BR",(resultSet.getString("NUM_OF_CONSENT_REQ_BR")==null?"":resultSet.getString("NUM_OF_CONSENT_REQ_BR")) );
				}
				else{
					DrugDetails.put("CONSENT_STAGE","");
					DrugDetails.put("CONSENT_STATUS","");
					DrugDetails.put("NUM_OF_CONSENT_REQ_BO","");
					DrugDetails.put("NUM_OF_CONSENT_REQ_BR","");
				}
				DrugDetails.put("ORDER_TYPE_DESC",resultSet.getString("order_type_desc"));
           }
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT3A")+ " ORDER BY  PATIENT_CLASS desc";//PE corrections ends here/*11/13/2008: this is added so as to fetch the correct record for the give Patient class */
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drugCode);
			pstmt.setString(2,act_pat_class); // patientClass changed to act_pat_class for ML-BRU-SCF-0898 [IN:041176]
			pstmt.setString(3,locale);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				DrugDetails.put("ACT_PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")) );
				DrugDetails.put("ORD_AUTH_LEVEL",(resultSet.getString("ORD_AUTH_LEVEL")==null ? "":resultSet.getString("ORD_AUTH_LEVEL")) );
				DrugDetails.put("CHK_FOR_MAX_DURN_ACTION",(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null ? "":resultSet.getString("CHK_FOR_MAX_DURN_ACTION")) );
				DrugDetails.put("PROMPT_MSG",(resultSet.getString("PROMPT_MSG")==null ? "":resultSet.getString("PROMPT_MSG")) );
				DrugDetails.put("MAX_DURN_VALUE",(resultSet.getString("MAX_DURN_VALUE")==null ? "":resultSet.getString("MAX_DURN_VALUE")) );
				DrugDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")) );//below code used to fetch qty_value,freq_code,durn_value,durn_type from order_catalog or copy prescription				
				if((getPrescriptions()!=null && getPrescriptions().contains(drugCode)) || (getExitingOrders()!=null && getExitingOrders().contains(drugCode)) ) {
					if(getPrescriptions()!=null && getPrescriptions().contains(drugCode)) {
						index		=	getPrescriptions().indexOf(drugCode);
						ord_det	=	(String)((getPrescriptions()).get(index-1));
						order_id	=	ord_det.substring(0,ord_det.indexOf(","));
						ord_line	=	ord_det.substring(ord_det.indexOf(",")+1,ord_det.length());
						DrugDetails.put("COPIED_DRUG_YN","Y");
					} 
					else if( getExitingOrders()!=null && getExitingOrders().contains(drugCode) ) {
						 index		=	getExitingOrders().indexOf(drugCode);
						 order_id	=	(String)((getExitingOrders()).get(index-2));
						 ord_line	=	(String)((getExitingOrders()).get(index-1));
						 DrugDetails.put("COPIED_DRUG_YN","Y"); //added while fixing IN26573 --22/02/2011-- priya
					}
					DrugDetails.put("ORDER_ID",order_id);
					DrugDetails.put("ORD_LINE",ord_line);

					pstmt_copy	=	connection.prepareStatement("SELECT a.FREQ_CODE,a.DURN_VALUE,a.DURN_TYPE,a.QTY_VALUE,a.QTY_UNIT,b.REPEAT_DURN_TYPE,c.SPLIT_YN, c.SPLIT_DOSE_PREVIEW,d.PRES_QTY_VALUE, d.PRES_QTY_UOM, d.SLIDING_SCALE_YN, b.repeat_value, b.interval_value, b.freq_nature, a.ORDER_QTY,a.ROUTE_CODE, d.DRUG_INDICATION  FROM OR_ORDER_LINE A, am_frequency b,ph_patient_drug_profile c,OR_ORDER_LINE_PH d  WHERE a.ORDER_ID=? AND a.ORDER_LINE_NUM=? and a.order_id =c.ORIG_ORDER_ID  and a.ORDER_LINE_NUM =c.orig_order_line_no and a.order_id =d.ORDER_ID  and a.ORDER_LINE_NUM =d.ORDER_LINE_NUM and a.freq_code = b.freq_code"); ;  //a.ROUTE_CODE added for  SKR-SCF-0586 [IN034375]
					String pres_qty_copy = null;
					pstmt_copy.setString(1,order_id);
					pstmt_copy.setString(2,ord_line);
					res_copy	=	pstmt_copy.executeQuery();
					if(res_copy!=null && res_copy.next()) {
						DrugDetails.put("QTY_VALUE",(res_copy.getString("QTY_VALUE")==null ? "":res_copy.getString("QTY_VALUE")) );
						DrugDetails.put("QTY_DESC_CODE",(res_copy.getString("QTY_UNIT")==null ? "":res_copy.getString("QTY_UNIT")) );
						DrugDetails.put("FREQ_CODE",(res_copy.getString("FREQ_CODE")==null ? "":res_copy.getString("FREQ_CODE")) );
						DrugDetails.put("DURN_VALUE",(res_copy.getString("DURN_VALUE")==null ? "1":res_copy.getString("DURN_VALUE")) );
						DrugDetails.put("DURN_TYPE",(res_copy.getString("DURN_TYPE")==null ? "D":res_copy.getString("DURN_TYPE")) );
						DrugDetails.put("REPEAT_DURN_TYPE",(res_copy.getString("REPEAT_DURN_TYPE")==null ? "D":res_copy.getString("REPEAT_DURN_TYPE")));
						//String am_repeat_value = res_copy.getString("REPEAT_VALUE")==null ? "1":res_copy.getString("REPEAT_VALUE");
						//String am_interval_value = res_copy.getString("INTERVAL_VALUE")==null ? "1":res_copy.getString("INTERVAL_VALUE");		//added while fixing  IN26267 --02/02/2011-- priya (to calc charge details of copied drugs from prev order)
						DrugDetails.put("ABSOL_QTY",(res_copy.getString("ORDER_QTY")==null ? "":res_copy.getString("ORDER_QTY")) ); //replaced PRES_QTY_VALUE with ORDER_QTY for IN26762 -- 14-03-2011 -- priya
						DrugDetails.put("REPEAT_VALUE",(res_copy.getString("REPEAT_VALUE")==null ? "1":res_copy.getString("REPEAT_VALUE")));
					    DrugDetails.put("INTERVAL_VALUE",(res_copy.getString("INTERVAL_VALUE")==null ? "1":res_copy.getString("INTERVAL_VALUE")));
						DrugDetails.put("FREQ_NATURE",(res_copy.getString("FREQ_NATURE")==null ? "":res_copy.getString("FREQ_NATURE")));
						DrugDetails.put("ROUTE_CODE",(res_copy.getString("ROUTE_CODE")==null ? "":res_copy.getString("ROUTE_CODE")));  //added for  SKR-SCF-0586 [IN034375]
						DrugDetails.put("DRUG_INDICATION",(res_copy.getString("DRUG_INDICATION")==null ? "":res_copy.getString("DRUG_INDICATION")));  //Added for ML-BRU-SCF-1333 [IN:049124]
						route_code      = res_copy.getString("ROUTE_CODE"); //added for  SKR-SCF-0586 [IN034375]

						durn_value		= res_copy.getString("DURN_VALUE");
						freq_code		= res_copy.getString("FREQ_CODE");
						durn_type		= res_copy.getString("DURN_TYPE");
						qty_value		= res_copy.getString("QTY_VALUE");
						qty_desc_code	= res_copy.getString("QTY_UNIT");
						proc_qty_value	= qty_value;
						
						DrugDetails.put("SPLIT_YN",res_copy.getString("SPLIT_YN"));
						DrugDetails.put("SPLIT_DOSE_PREVIEW",res_copy.getString("SPLIT_DOSE_PREVIEW"));
						DrugDetails.put("SLIDING_SCALE_YN",res_copy.getString("SLIDING_SCALE_YN")==null?"N":res_copy.getString("SLIDING_SCALE_YN")); 
						if(res_copy.getString("SLIDING_SCALE_YN")!=null && res_copy.getString("SLIDING_SCALE_YN").equals("Y")){
							pres_qty_copy = res_copy.getString("PRES_QTY_VALUE")==null?"":res_copy.getString("PRES_QTY_VALUE");
							if(pres_qty_copy != "" && content_in_pres_base_uom != null && content_in_pres_base_uom != "")
								pres_qty_copy = (Float.parseFloat(pres_qty_copy) / Float.parseFloat(content_in_pres_base_uom))+"";
							DrugDetails.put("PRES_QTY_VALUE",pres_qty_copy); 	DrugDetails.put("PRES_QTY_UOM",res_copy.getString("PRES_QTY_UOM")==null?"":res_copy.getString("PRES_QTY_UOM")); 
						}
					}
					closeResultSet( res_copy ) ;
					closeStatement( pstmt_copy ) ;//PE corrections ends here
					if(DrugDetails.get("SLIDING_SCALE_YN").equals("Y")){	//to get the sliding scale template details, for copy prescription
						pstmt_copy	=	connection.prepareStatement("SELECT TEMPLATE_ID, SRL_NO, RANGE_FROM, RANGE_TO, ADMIN_UNITS, REMARKS FROM OR_ORDER_LINE_PH_SLD_SCALE WHERE ORDER_ID=? AND ORDER_LINE_NUM=? ORDER BY SRL_NO");
						pstmt_copy.setString(1,order_id);
						pstmt_copy.setString(2,ord_line);
						res_copy	=	pstmt_copy.executeQuery();
						while(res_copy!=null && res_copy.next()){ 
							srl_no = res_copy.getString("SRL_NO")==null?"":res_copy.getString("SRL_NO");           
							range_from = res_copy.getString("RANGE_FROM")==null?"":res_copy.getString("RANGE_FROM");       
							range_to = res_copy.getString("RANGE_TO")==null?"":res_copy.getString("RANGE_TO");         
							admin_units = res_copy.getString("ADMIN_UNITS")==null?"":res_copy.getString("ADMIN_UNITS");      
							remarks = res_copy.getString("REMARKS")==null?"":res_copy.getString("REMARKS");          
							if(remarks !=null || !remarks.equals(""))
								remarks = java.net.URLEncoder.encode(remarks,"UTF-8");	
							sldscale_tmpl_dtl.add(srl_no);
							sldscale_tmpl_dtl.add(range_from);
							sldscale_tmpl_dtl.add(range_to);
							sldscale_tmpl_dtl.add(admin_units);
							sldscale_tmpl_dtl.add(remarks);
							DrugDetails.put("TEMPLATE_ID",res_copy.getString("TEMPLATE_ID")==null?"":res_copy.getString("TEMPLATE_ID"));
						}
						DrugDetails.put("SLDSCALE_TMPL_DTL",sldscale_tmpl_dtl);
						closeResultSet( res_copy ) ;
						closeStatement( pstmt_copy ) ;
					}		
				}
				else {//if condtion added for IN070786
					if((getPrescriptions()!=null && getPrescriptions().contains(drugCode)) || (getExternal_drugs_tmp()!=null && getExternal_drugs_tmp().contains(drugCode)) ){
						
						if((getExternal_drugs_tmp()!=null && getExternal_drugs_tmp().contains(drugCode))){
						index		=	getExternal_drugs_tmp().indexOf(drugCode);
						ord_det	=	(String)((getExternal_drugs_tmp()).get(index+1));
						}
						
						pstmt_copy	=	connection.prepareStatement("select ROUTE_CODE,FREQUENCY,DOSAGE_TYPE,QTY_VALUE,QTY_DESC from PH_PATIENT_EXT_DRUG_PROFILE where drug_code=? and patient_id=? and SRL_NO=?");
						pstmt_copy.setString(1,drugCode);
						pstmt_copy.setString(2,patient_id);
						pstmt_copy.setString(3,ord_det);
						
						res_copy	=	pstmt_copy.executeQuery();
						while(res_copy!=null && res_copy.next()){ 
							route_code = res_copy.getString("ROUTE_CODE")==null?"":res_copy.getString("ROUTE_CODE");           
							freq_code = res_copy.getString("FREQUENCY")==null?"":res_copy.getString("FREQUENCY");       
							dosage_type = res_copy.getString("DOSAGE_TYPE")==null?"":res_copy.getString("DOSAGE_TYPE");         
							qty_value = res_copy.getString("QTY_VALUE")==null?"":res_copy.getString("QTY_VALUE");   
							if(qty_value !=null && qty_value !=""){//added for mms-kh-crf-0016.1
								qty_value = res_copy.getString("QTY_VALUE")==null?"":res_copy.getString("QTY_VALUE"); 
							}
							else
								qty_value		= resultSet.getString("QTY_VALUE");
								
							   
							qty_desc_code = res_copy.getString("QTY_DESC")==null?"":res_copy.getString("QTY_DESC");          
							
							
						}
						
						closeResultSet( res_copy ) ;
						closeStatement( pstmt_copy ) ;
						
						DrugDetails.put("QTY_VALUE",qty_value );
						DrugDetails.put("QTY_DESC_CODE",qty_desc_code );
						DrugDetails.put("FREQ_CODE",freq_code);
						DrugDetails.put("ROUTE_CODE",route_code);
						DrugDetails.put("DOSAGE_TYPE",dosage_type);
					
					}
					else{DrugDetails.put("FREQ_CODE",(resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")) );
					DrugDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "1":resultSet.getString("DURN_VALUE")) );
					DrugDetails.put("DURN_TYPE",(resultSet.getString("DURN_TYPE")==null ? "D":resultSet.getString("DURN_TYPE")) );
					durn_value		= resultSet.getString("DURN_VALUE");
					freq_code		= resultSet.getString("FREQ_CODE");
					durn_type		= resultSet.getString("DURN_TYPE");
					qty_value		= resultSet.getString("QTY_VALUE");
					}
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			// get the atc classification based on generic id
			//sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT98");
			// SRR20056-SCF-7689 - Generic name is queried and defaulted (earlier it was code)
			// SRR20056-SCF-6437 - Logic change (removed ATC Level1, ATC Level 2, ATC Level 3)
			// Newly added ATC Level 5 and ATC Level 4, Attached mail in spira for logic details
			// Query changed new column referred as  ATC_CLASS_LEV4_CODE, ATC_CLASS_LEV5_CODE, GENERIC_ATC_NAME
			sql_query = "SELECT ATC_CLASS_LEV1_CODE, ATC_CLASS_LEV2_CODE, ATC_CLASS_LEV3_CODE, ATC_CLASS_LEV4_CODE,ATC_CLASS_LEV5_CODE, (SELECT GENERIC_NAME FROM  PH_GENERIC_NAME WHERE GENERIC_ID = A.GENERIC_ID) GENERIC_ATC_NAME FROM PH_GENERIC_NAME_BY_ATC_CLASS A WHERE A.GENERIC_ID=?";
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,generic_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				DrugDetails.put("ATC_CLASS_LEV1_CODE",(resultSet.getString("ATC_CLASS_LEV1_CODE")==null ? "":resultSet.getString("ATC_CLASS_LEV1_CODE")) );
				DrugDetails.put("ATC_CLASS_LEV2_CODE",(resultSet.getString("ATC_CLASS_LEV2_CODE")==null ? "":resultSet.getString("ATC_CLASS_LEV2_CODE")) );
				DrugDetails.put("ATC_CLASS_LEV3_CODE",(resultSet.getString("ATC_CLASS_LEV3_CODE")==null ? "":resultSet.getString("ATC_CLASS_LEV3_CODE")) );
				// SRR20056-SCF-7689 - Generic name is queried and defaulted (earlier it was code)
				// SRR20056-SCF-6437 - Logic change (removed ATC Level1, ATC Level 2, ATC Level 3)
				// Newly added ATC Level 5 and ATC Level 4, Attached mail in spira for logic details
				DrugDetails.put("ATC_CLASS_LEV4_CODE",(resultSet.getString("ATC_CLASS_LEV4_CODE")==null ? "":resultSet.getString("ATC_CLASS_LEV4_CODE")) );
				DrugDetails.put("ATC_CLASS_LEV5_CODE",(resultSet.getString("ATC_CLASS_LEV5_CODE")==null ? "":resultSet.getString("ATC_CLASS_LEV5_CODE")) );
				DrugDetails.put("GENERIC_ATC_NAME",(resultSet.getString("GENERIC_ATC_NAME")==null ? "":resultSet.getString("GENERIC_ATC_NAME")) );
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
            if(!DrugDetails.containsKey("ACT_PATIENT_CLASS")) {
				sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT3A");
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,drugCode);
				pstmt.setString(2,"*A");
				pstmt.setString(3,locale);

				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("ACT_PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")) );
					DrugDetails.put("ORD_AUTH_LEVEL",(resultSet.getString("ORD_AUTH_LEVEL")==null ? "":resultSet.getString("ORD_AUTH_LEVEL")) );
					DrugDetails.put("CHK_FOR_MAX_DURN_ACTION",(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null ? "":resultSet.getString("CHK_FOR_MAX_DURN_ACTION")) );
					DrugDetails.put("PROMPT_MSG",(resultSet.getString("PROMPT_MSG")==null ? "":resultSet.getString("PROMPT_MSG")) );
					DrugDetails.put("MAX_DURN_VALUE",(resultSet.getString("MAX_DURN_VALUE")==null ? "":resultSet.getString("MAX_DURN_VALUE")) );
					DrugDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")) );//below code used to fetch qty_value,freq_code,durn_value,durn_type from order_catalog or copy prescription
					if((getPrescriptions()!=null && getPrescriptions().contains(drugCode) )|| (getExitingOrders()!=null && getExitingOrders().contains(drugCode))){
						if(getPrescriptions()!=null && getPrescriptions().contains(drugCode)) {
							index		=	getPrescriptions().indexOf(drugCode);
							ord_det	=	(String)((getPrescriptions()).get(index-1));
							order_id	=	ord_det.substring(0,ord_det.indexOf(","));
							ord_line	=	ord_det.substring(ord_det.indexOf(",")+1,ord_det.length());
						} 
						else if(getExitingOrders()!=null && getExitingOrders().contains(drugCode) ) {
							index		=	getExitingOrders().indexOf(drugCode);
							order_id	=	(String)((getExitingOrders()).get(index-2));
							ord_line	=	(String)((getExitingOrders()).get(index-1));
						}
						pstmt_copy	=	connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT69"));
						pstmt_copy.setString(1,order_id);
						pstmt_copy.setString(2,ord_line);
						res_copy	=	pstmt_copy.executeQuery();
						if(res_copy!=null && res_copy.next()) {
							DrugDetails.put("FREQ_CODE",(res_copy.getString("FREQ_CODE")==null ? "":res_copy.getString("FREQ_CODE")) );
							DrugDetails.put("DURN_VALUE",(res_copy.getString("DURN_VALUE")==null ? "1":res_copy.getString("DURN_VALUE")) );
							DrugDetails.put("DURN_TYPE",(res_copy.getString("DURN_TYPE")==null ? "D":res_copy.getString("DURN_TYPE")) );
							DrugDetails.put("QTY_VALUE",(res_copy.getString("QTY_VALUE")==null ? "":res_copy.getString("QTY_VALUE")) );
							DrugDetails.put("QTY_DESC_CODE",(res_copy.getString("QTY_UNIT")==null ? "":res_copy.getString("QTY_UNIT")) );
							durn_value		= res_copy.getString("DURN_VALUE");
							freq_code		= res_copy.getString("FREQ_CODE");
							durn_type		= res_copy.getString("DURN_TYPE");
							qty_value		= res_copy.getString("QTY_VALUE");
							qty_desc_code	= res_copy.getString("QTY_UNIT");
							proc_qty_value	= qty_value;
						}
						closeResultSet( res_copy ) ;
						closeStatement( pstmt_copy ) ;
					} 
					else {
						durn_value		= resultSet.getString("DURN_VALUE")==null ? "1":resultSet.getString("DURN_VALUE");
						freq_code		= resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE");
						durn_type		= resultSet.getString("DURN_TYPE")==null ? "D":resultSet.getString("DURN_TYPE");
						if(!durn_type.equals("D"))
							durn_type = "D";
						qty_value		= resultSet.getString("QTY_VALUE");
						DrugDetails.put("FREQ_CODE",freq_code);
						DrugDetails.put("DURN_VALUE",durn_value);
						DrugDetails.put("DURN_TYPE",durn_type);
					}
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}//added on 12/01/2006 to get the values for Order_set drugs 
			if(!order_set_code.equals("")){
				pstmt_copy	=	connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT_DRUGVALUES_FROM_ORDERSET"));
				pstmt_copy.setString(1,order_set_code);
				pstmt_copy.setString(2,drugCode);
				pstmt_copy.setString(3,order_set_occur_num);
				res_copy	=	pstmt_copy.executeQuery();
				if(res_copy!=null && res_copy.next()) {
					durn_value		= res_copy.getString("DURN_VALUE")==null ? "1":res_copy.getString("DURN_VALUE");
					freq_code		= res_copy.getString("FREQ_CODE")==null ? "":res_copy.getString("FREQ_CODE");
					durn_type		= res_copy.getString("DURN_TYPE")==null ? "D":res_copy.getString("DURN_TYPE");
					qty_value		= res_copy.getString("QTY_VALUE");
					qty_desc_code	= res_copy.getString("QTY_UNIT");
					proc_qty_value	= qty_value;
					if(!durn_type.equals("D"))
						durn_type="D";
					DrugDetails.put("TAB_QTY_VALUE",(res_copy.getString("QTY_VALUE")==null ? "":res_copy.getString("QTY_VALUE")) );
					DrugDetails.put("FREQ_CODE",freq_code );
					DrugDetails.put("DURN_VALUE",durn_value );
					DrugDetails.put("DURN_TYPE",durn_type );
					DrugDetails.put("START_DATE",(res_copy.getString("START_DATE_TIME")==null ? "":res_copy.getString("START_DATE_TIME")) );
					DrugDetails.put("REQD_OR_OPT_IND",(res_copy.getString("REQD_OR_OPT_IND")==null ? "":res_copy.getString("REQD_OR_OPT_IND")) );
				}
				else{
					DrugDetails.put("REQD_OR_OPT_IND","");
				}
				closeResultSet( res_copy ) ;
				closeStatement( pstmt_copy ) ;
			}
			else{
				DrugDetails.put("REQD_OR_OPT_IND","");
			}	//get the standard dose based on age group
			HashMap pat_dtls	=	getPatientDetails(patient_id,drugCode);
			String	age			=	(String)pat_dtls.get("age");
			String	age_in_mints			=	(String)pat_dtls.get("age_in_mints");
			String gender			=	((String)pat_dtls.get("sex"));
			age	=	age.trim();
			gender	=	gender.substring(0,1).toUpperCase();
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRES_WEIGTH_CHECK_FLAG_SELECT");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drugCode);
			pstmt.setString(2,age_in_mints);
			pstmt.setString(3,gender);
			pstmt.setString(4,gender);
			pstmt.setString(5,drugCode);
			pstmt.setString(6,age_in_mints);
			pstmt.setString(7,gender);
			resultSet			= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				wt_mand_yn = resultSet.getString("WT_MAND_YN")==null?"N":resultSet.getString("WT_MAND_YN");
				ht_mand_yn = resultSet.getString("HT_MAND_YN")==null?"N":resultSet.getString("HT_MAND_YN"); //  added for Bru-HIMS-CRF-079 IN[029945] 
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
			if(wt_mand_yn.equals("Y") && ht_mand_yn.equals("Y")) //  added for Bru-HIMS-CRF-079 IN[029945]  - start
				DrugDetails.put("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG","Y");
			DrugDetails.put("WT_MAND_YN",wt_mand_yn); 
			DrugDetails.put("HT_MAND_YN",ht_mand_yn); 	//  added for Bru-HIMS-CRF-079 IN[029945] -end
			//DrugDetails.put("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG",wt_mand_yn); // commented for Bru-HIMS-CRF-079 IN[029945] 
			int count_rx		= 0;
			DrugDetails.put("LIMIT_IND","");
			DrugDetails.put("DAILY_DOSE","" );
			DrugDetails.put("UNIT_DOSE","" );
			DrugDetails.put("MONO_GRAPH","" );
			DrugDetails.put("MIN_DAILY_DOSE","" );
			DrugDetails.put("MIN_UNIT_DOSE","" );

			DrugDetails.put("RECOMM_YN","N");
			DrugDetails.put("CALC_BY_IND","");
			DrugDetails.put("DOSAGE_STD","");
			DrugDetails.put("DOSAGE_UNIT","");
			DrugDetails.put("RECOMM_DOSAGE_BY","");
			if(calc_dflt_dosage_by_htwt!=null && calc_dflt_dosage_by_htwt.trim().equals("Y") && age_group!=null && !age_group.equals("")) {
				sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT81");
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,drugCode);
				pstmt.setString(2,age_group);
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("RECOMM_YN","Y");
					DrugDetails.put("CALC_BY_IND",(resultSet.getString("CALC_BY_IND")));
					DrugDetails.put("DOSAGE_STD",(resultSet.getString("DOSAGE_STD")));
					DrugDetails.put("DOSAGE_UNIT",(resultSet.getString("DOSAGE_UNIT")));
					DrugDetails.put("RECOMM_DOSAGE_BY",(resultSet.getString("LIMIT_IND")));
				} 
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			//sql_query	= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT4A");
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT5A");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,sys_date);
			pstmt.setString(2,sys_date);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				DrugDetails.put("FUTURE_DATE",(resultSet.getString("FUTURE_DATE")) );
				DrugDetails.put("BACK_DATE",(resultSet.getString("BACK_DATE")) );
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT6A");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,freq_code);
			pstmt.setString(2,locale);
			resultSet			= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()){
				DrugDetails.put("FREQ_NATURE",(resultSet.getString("FREQ_NATURE")) );
				freq_nature		=	resultSet.getString("FREQ_NATURE")==null?"":resultSet.getString("FREQ_NATURE");
				if(resultSet.getString("FREQ_NATURE")!=null && ((resultSet.getString("FREQ_NATURE").equals("P")) || (resultSet.getString("FREQ_NATURE").equals("O")))){
					if(!(getPrescriptions() != null && getPrescriptions().contains(drugCode) || getExitingOrders()!=null &&  getExitingOrders().contains(drugCode))){ // if condition added for IN26267 reopen-- 07/02/2011-- priya (default durn was getting changed to 1 for copied prn orders)
						DrugDetails.put("DURN_VALUE","1");
						durn_value		=	"1";
					}
					DrugDetails.put("REPEAT_VALUE","1");	
					DrugDetails.put("ORIG_REPEAT_VALUE","1");
					DrugDetails.put("INTERVAL_VALUE","1");
					DrugDetails.put("FREQ_VALUE",(resultSet.getString("FREQ_VALUE")) );
					DrugDetails.put("FREQ_DESC",(resultSet.getString("FREQ_DESC")) );
					DrugDetails.put("SCHEDULED_YN",(resultSet.getString("SCHEDULED_YN")) );
					DrugDetails.put("REPEAT_DURN_TYPE","D");
					repeat_durn_type=	"D";
					repeat_value	=	"1";
					interval_value	=	"1";
				}
				else{
					repeat_durn_type =resultSet.getString("REPEAT_DURN_TYPE")==null?"D":resultSet.getString("REPEAT_DURN_TYPE");
					repeat_value	=	resultSet.getString("REPEAT_VALUE");
					interval_value	=	(resultSet.getString("INTERVAL_VALUE"));
					//if(!repeat_durn_type.equals("D"))
						//repeat_durn_type = "D";
					DrugDetails.put("REPEAT_VALUE",repeat_value);
					DrugDetails.put("INTERVAL_VALUE",interval_value);
					DrugDetails.put("REPEAT_DURN_TYPE",repeat_durn_type);
					DrugDetails.put("ORIG_REPEAT_VALUE",(resultSet.getString("REPEAT_VALUE")));
					DrugDetails.put("FREQ_VALUE",(resultSet.getString("FREQ_VALUE")) );
					DrugDetails.put("FREQ_DESC",(resultSet.getString("FREQ_DESC")) );
					DrugDetails.put("SCHEDULED_YN",(resultSet.getString("SCHEDULED_YN")) );
					if(interval_value==null)
						interval_value	=	"";

					if(interval_value.equals("") || interval_value.equals("0")) {
						interval_value	=	"1";
					}
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(durn_value==null || durn_value.equals("") || durn_value.equals("0")){ // added durn_value==null || durn_value.equals("") || for ICN 30815
				durn_value = "1";
				DrugDetails.put("DURN_VALUE","1");
			}

			if(order_set_code==null || order_set_code.equals("") || DrugDetails.get("START_DATE")==null || ((String)DrugDetails.get("START_DATE")).equals("")){
				if((getPrescriptions()!=null && getPrescriptions().contains(drugCode)) || (getExitingOrders()!=null && getExitingOrders().contains(drugCode)))	{
					String edate		= null;
					//sql_query			= PhRepository.getPhKeyValue("SQL_PH_RENEW_PRESCRIPTION_SELECT6");
					sql_query = "SELECT TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE, ORDER_LINE_STATUS FROM OR_ORDER_LINE WHERE ORDER_ID=? AND ORDER_LINE_NUM=?"; //added ORDER_LINE_STATUS for IN26573 --22/02/2011-- priya
					pstmt				= connection.prepareStatement(sql_query) ;				
					pstmt.setString(1,order_id);
					pstmt.setString(2,ord_line);
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next())	{
						edate	=	resultSet.getString("END_DATE");
						copied_ord_status = resultSet.getString("ORDER_LINE_STATUS");//added for IN26573 --22/02/2011-- priya
					}
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					if(copied_ord_status!=null && (copied_ord_status.equals("CN") || copied_ord_status.equals("DC"))){//added for IN26573 --22/02/2011-- priya
						DrugDetails.put("START_DATE",sys_date);
					}
					else{
						sys_date			= comp_date_time(edate,order_id,ord_line);
						DrugDetails.put("START_DATE",sys_date);
					}
				}
				else{
					DrugDetails.put("START_DATE",sys_date);
				}
			}
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7AA");
			pstmt				= connection.prepareStatement(sql_query) ;
			if(repeat_durn_type==null || repeat_durn_type.equals("")) //added for ML-MMOH-SCF-1646
				repeat_durn_type = "D";

			pstmt.setString(1,repeat_durn_type);
			pstmt.setString(2,sys_date);
			pstmt.setString(3,durn_value);
			pstmt.setString(4,repeat_durn_type);
			pstmt.setString(5,sys_date);
			pstmt.setString(6,durn_value);
			pstmt.setString(7,repeat_durn_type);
			pstmt.setString(8,sys_date);
			pstmt.setString(9,durn_value);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				DrugDetails.put("END_DATE",(resultSet.getString("END_DATE")) );
				end_date=resultSet.getString("END_DATE");
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT8A");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,durn_type);
			pstmt.setString(2,locale);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				DrugDetails.put("DURN_DESC",(resultSet.getString("DURN_DESC")) );
				DrugDetails.put("OR_DURN_DESC",(resultSet.getString("DURN_DESC")) );
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			if(getPrescriptions()!=null && getPrescriptions().contains(drugCode)) {
				pstmt_copy	=	connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT86"));
				pstmt_copy.setString(1,order_id);
				pstmt_copy.setString(2,ord_line);
				res_copy	=	pstmt_copy.executeQuery();
				if(res_copy!=null && res_copy.next()) {
					DrugDetails.put("DOSAGE_TYPE",(res_copy.getString("PRESCRIBED_MODE")==null ? "1":res_copy.getString("PRESCRIBED_MODE")));		
					DrugDetails.put("ORI_DOSAGE_TYPE",(res_copy.getString("PRESCRIBED_MODE")==null ? "1":res_copy.getString("PRESCRIBED_MODE")));	////added for IN25014 --15/11/2010-- priya
				}
				closeResultSet( res_copy ) ;
				closeStatement( pstmt_copy ) ;
				String episode_type = getActPatientClass_frm_Hdr()==null?"":getActPatientClass_frm_Hdr();//added while fixing  IN26267 --02/02/2011-- priya (to calc charge details of copied drugs from prev order)
				if(!(episode_type.equals(""))){
					episode_type = episode_type.substring(0,1);
				}
				String billing_qty_value = "";
				if(DrugDetails.get("FREQ_NATURE")!=null && !(((String)DrugDetails.get("FREQ_NATURE")).equals("")) && billable_item_yn.equals("Y")){ //&& billable_item_yn.equals("Y")  Condition added for ML-BRU-SCF-2229
					if( ((String)DrugDetails.get("FREQ_NATURE")).equals("P") ){
						billing_qty_value = (String)DrugDetails.get("ABSOL_QTY");
						setBillingDetail(DrugDetails,"A", billing_qty_value, (String)DrugDetails.get("QTY_DESC_CODE"), (String)DrugDetails.get("REPEAT_VALUE"), (String)DrugDetails.get("DURN_VALUE"), (String)DrugDetails.get("INTERVAL_VALUE"), patient_id, encounter_id, episode_type, sys_date, "", "","",take_home_medication);
					}
					else{
						
						billing_qty_value = (String)DrugDetails.get("QTY_VALUE");
						setBillingDetail(DrugDetails,(String)DrugDetails.get("DOSAGE_TYPE"), billing_qty_value, (String)DrugDetails.get("QTY_DESC_CODE"), (String)DrugDetails.get("REPEAT_VALUE"), (String)DrugDetails.get("DURN_VALUE"), (String)DrugDetails.get("INTERVAL_VALUE"), patient_id, encounter_id, episode_type, sys_date, "", "","",take_home_medication);
					}
				}	//added while fixing  IN26267-End
			} 
			if(calc_dosg_by_freq_durn_yn==null || calc_dosg_by_freq_durn_yn.equals("N")){
				if(!DrugDetails.containsKey("DOSAGE_TYPE")) {
					DrugDetails.put("DOSAGE_TYPE","A");					
				}
				DrugDetails.put("ORI_DOSAGE_TYPE","A");
				dosage_type="A";
			}
			else{
				if(strength_value.equals("0") || fract_dose_appl_yn.equals("N")){
					if(!DrugDetails.containsKey("DOSAGE_TYPE")) {
						DrugDetails.put("DOSAGE_TYPE","Q");						
					}
					DrugDetails.put("ORI_DOSAGE_TYPE","Q");
					dosage_type="Q";					
				}
				else{
					if(!DrugDetails.containsKey("DOSAGE_TYPE")) {
						DrugDetails.put("DOSAGE_TYPE","S");						
					}
					DrugDetails.put("ORI_DOSAGE_TYPE","S");	
					dosage_type="S";
				}
			}
			if(DrugDetails.get("COPIED_DRUG_YN")==null || ((String)DrugDetails.get("COPIED_DRUG_YN")).equals("N")){
				if(default_dosage_by!=null && !default_dosage_by.equals("") && !default_dosage_by.equals(dosage_type)){
					DrugDetails.put("DOSAGE_TYPE",default_dosage_by);
					dosage_type=default_dosage_by;					
				}
			}
			if( calc_dosg_by_freq_durn_yn==null || calc_dosg_by_freq_durn_yn.equals("N")) {
				if(!DrugDetails.containsKey("QTY_VALUE")) {
					DrugDetails.put("QTY_VALUE",qty_value);
					if(qty_desc_code==null || qty_desc_code.equals(""))//Added for SKR-SCF-1128
						 qty_desc_code=pres_base_uom;//Added for SKR-SCF-1128
					DrugDetails.put("QTY_DESC_CODE",qty_desc_code);//form_code changed to qty_desc_code 5.x issue ML-SD-SCF-3527 [IN:0557]
					//qty_desc_code=strength_uom; //Commented for 5.x issue ML-SD-SCF-3527 [IN:0557]
					proc_qty_value=qty_value;
				}
			}
			else if(strength_value==null || strength_value.equals("0") || strength_value.equals("") ||  fract_dose_appl_yn.equals("N") || dosage_type.equals("Q")){
				if(!DrugDetails.containsKey("QTY_VALUE")) {
					DrugDetails.put("QTY_VALUE",qty_value);
					DrugDetails.put("QTY_DESC_CODE",pres_base_uom);					
					qty_desc_code=pres_base_uom;
					proc_qty_value=qty_value;
				}
			}
			else{
				if(!DrugDetails.containsKey("QTY_VALUE")) {
					if(qty_value==null) // added for ML-MMOH-SCF-1646
						qty_value = "1";
					String strength_val= (Double.parseDouble(strength_value) * Double.parseDouble(qty_value))/Double.parseDouble(strength_per_value_pres_uom)+"";
					DecimalFormat dfTest = new DecimalFormat("##.####");
					strength_val = dfTest.format(Double.parseDouble(strength_val));
					DrugDetails.put("QTY_VALUE",strength_val);
					DrugDetails.put("QTY_DESC_CODE",strength_uom);
					proc_qty_value=strength_val;
					qty_desc_code=strength_uom;
				}
			}
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT9A");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,qty_desc_code);
			pstmt.setString(2,locale);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				DrugDetails.put("QTY_DESC",(resultSet.getString("SHORT_DESC")) );
				DrugDetails.put("OR_QTY_DESC",(resultSet.getString("SHORT_DESC")) );
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			//Added for IN:070451 start
			HashMap pat_dtl	=	getPatientDetails(patient_id,drugCode);
			String age_group			=	(String)pat_dtl.get("age_group")==null?"":(String)pat_dtls.get("age_group"); //Modified for GHL-SCF-1614
			System.out.println("age_group>>>>"+age_group);
			String factor;
			String calc_by_ind=(String)DrugDetails.get("CALC_BY_IND");
			
			if(calc_by_ind.equalsIgnoreCase("W")){
				if(!weight.equals(""))
					factor =weight;
				else
					factor ="1";
			}
			else if(calc_by_ind.equalsIgnoreCase("B")){
				if(!bsa.equals(""))
					factor =bsa;
				else
					factor ="1";
				 System.out.println("bsa"+bsa);
			}
			else{
				factor ="1";
			}
			//Added for IN:070451 end
	
			if(calc_dflt_dosage_by_htwt!=null && calc_dflt_dosage_by_htwt.trim().equals("Y") && age_group!=null && !age_group.equals("")){//Moved from above for SCF-7690[027798]-start
				cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//Added for IN:070451, Modified for IN:070451
				cstmt.setString( 1, drugCode);
				cstmt.setString( 2, patient_id);
				cstmt.setString( 3, proc_qty_value);
				cstmt.setString( 4, repeat_value);
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
		
				String daily_dose	= "";
				String unit_dose	= "";
				String limit_ind	= cstmt.getString( 8 );
				String mono_graph	= "";
				//Modified for IN:070451 start
				
				
				/*
				if((!bsa.equals("")) || (calc_by_ind.equalsIgnoreCase("A")) || (calc_by_ind.equalsIgnoreCase("W"))){
					DrugDetails.put("LIMIT_IND",limit_ind);
				
				}
				else{
					DrugDetails.put("LIMIT_IND","Y");
				}*/
				
				if(calc_by_ind.equalsIgnoreCase("W") && weight !="" )
				{
				DrugDetails.put("LIMIT_IND",limit_ind);
				}

				else if(calc_by_ind.equalsIgnoreCase("B") && !bsa.equals("")){
				DrugDetails.put("LIMIT_IND",limit_ind);
				}

				else if(calc_by_ind.equalsIgnoreCase("A")){
				DrugDetails.put("LIMIT_IND",limit_ind);
				}

				else{
				DrugDetails.put("LIMIT_IND","Y");
				}
				//Modified for IN:070451 end
				DrugDetails.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );//Modified for IN:070451
				DrugDetails.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );//Modified for IN:070451
				DrugDetails.put("MONO_GRAPH","");
				DrugDetails.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );//Modified for IN:070451
				DrugDetails.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );//Modified for IN:070451
				if(DrugDetails.get("DOSAGE_UNIT")==null || ((String)DrugDetails.get("DOSAGE_UNIT")).equals("")){
					DrugDetails.put("DOSAGE_UNIT",cstmt.getString(12));
				}
				//Added for IN:070451 start
				DrugDetails.put("MAX_DAILY_CEELING_DOSE",cstmt.getString(13)==null ? "":cstmt.getString(13));
				DrugDetails.put("MIN_DAILY_CEELING_DOSE",cstmt.getString(14)==null ? "":cstmt.getString(14));
				DrugDetails.put("MAX_UNIT_CEELING_DOSE",cstmt.getString(15)==null ? "":cstmt.getString(15));
				DrugDetails.put("MIN_UNIT_CEELING_DOSE",cstmt.getString(16)==null ? "":cstmt.getString(16));
				//Added for IN:070451 end
				//DrugDetails.put("DOSAGE_UNIT",(cstmt.getString(12)==null ? "":cstmt.getString(12)) );
				if(limit_ind!=null && limit_ind.equals("N")){
					daily_dose	= cstmt.getString( 6 );
					unit_dose	= cstmt.getString( 7 );
					mono_graph	= cstmt.getString( 9 );

					DrugDetails.put("RESULT",daily_dose+" : "+unit_dose+" : "+mono_graph);
					DrugDetails.put("MONO_GRAPH",(cstmt.getString(9)==null ? "":cstmt.getString(9)));
				}
				closeStatement( cstmt ) ;
			} //for SCF-7690 -incident no 027798- end

			String consider_stock_for_pres_yn	=	null;
			String allow_pres_without_stock_yn	=	null;
			String stock_installed				=	null;
			String drug_db_duptherapy_yn   ="N";
			String drug_db_allergy_check_yn = null;
			String atc_allergy_alert_level = "N"; //Code Added for	RUT-CRF-0065 IN 29603
			/* commented during PE By Naveen SQL_PH_PRESCRIPTION_SELECT14A and SQL_PH_DRUG_SEARCH_SELECT15 are merged.*/ //Commented Code removed
            sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT14A");//IN301118-SCF No: MO-GN-5400. Added Duplicate Drug Check OP Column 'ALLOW_DUPLICATE_DRUG_OP'. //atc_allergy_alert_level Added for	RUT-CRF-0065 IN 29603			
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				DrugDetails.put("MED_ADMIN_REQD_YN",(resultSet.getString("MED_ADMIN_REQD_YN")==null ? "N":resultSet.getString("MED_ADMIN_REQD_YN")) );
				DrugDetails.put("REFILL_YN",(resultSet.getString("REFILL_YN")==null ? "N":resultSet.getString("REFILL_YN")) );
				DrugDetails.put("MAX_REFILLS_FOR_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_REFILLS_FOR_PRES")) );
				DrugDetails.put("MAX_DURN_FOR_REFILL_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_DURN_FOR_REFILL_PRES")) );
				duplicate_check_at_atc_yn   = "N";
				duplicate_check_at_atc_yn  = resultSet.getString("DUPLICATE_CHECK_AT_ATC_YN")==null ? "N":resultSet.getString("DUPLICATE_CHECK_AT_ATC_YN");
			 	DrugDetails.put("DUPLICATE_CHECK_AT_ATC_YN",duplicate_check_at_atc_yn );	
				DrugDetails.put("ALLOW_DUPLICATE_DRUG",(resultSet.getString("ALLOW_DUPLICATE_DRUG")==null ? "Y":resultSet.getString("ALLOW_DUPLICATE_DRUG")) );				//IN301118-SCF No: MO-GN-5400. Duplicate Drug Check OP.
				DrugDetails.put("ALLOW_DUPLICATE_DRUG_OP",(resultSet.getString("ALLOW_DUPLICATE_DRUG_OP")==null ? "Y":resultSet.getString("ALLOW_DUPLICATE_DRUG_OP")) );
                prn_yn =resultSet.getString("MANDATORY_REM_ON_PRN_FREQ_YN")==null ? "N":resultSet.getString("MANDATORY_REM_ON_PRN_FREQ_YN");
				DrugDetails.put("MANDATORY_REM_ON_PRN_FREQ_YN",prn_yn); // added for IN23256 for displaying mandatory symbol for prn_remarks--12/08/2010-- priya
                drug_db_duptherapy_yn = resultSet.getString("drug_db_duptherapy_yn")==null ? "N":resultSet.getString("drug_db_duptherapy_yn");
				drug_db_allergy_check_yn = resultSet.getString("DRUG_DB_ALLERGY_CHECK_YN")==null ? "N":resultSet.getString("DRUG_DB_ALLERGY_CHECK_YN");
				atc_allergy_alert_level = resultSet.getString("atc_allergy_alert_level")==null?"N":resultSet.getString("atc_allergy_alert_level"); //Code Added for RUT-CRF-0065 IN29603
                setchkforPRN(prn_yn);
				if(patientClass.equals("IP")) {
					consider_stock_for_pres_yn	=	resultSet.getString("IP_CONSIDER_STOCK_PRES_YN")==null ? "Y":resultSet.getString("IP_CONSIDER_STOCK_PRES_YN");
					allow_pres_without_stock_yn	= resultSet.getString("IP_PRES_WITHOUT_STOCK_YN")==null ? "Y":resultSet.getString("IP_PRES_WITHOUT_STOCK_YN");
					DrugDetails.put("CONSIDER_STOCK_FOR_PRES_YN",consider_stock_for_pres_yn );
					DrugDetails.put("ALLOW_PRES_WITHOUT_STOCK_YN",allow_pres_without_stock_yn );
				}
				else {
					consider_stock_for_pres_yn	=	resultSet.getString("CONSIDER_STOCK_FOR_PRES_YN")==null ? "Y":resultSet.getString("CONSIDER_STOCK_FOR_PRES_YN");
					allow_pres_without_stock_yn	= resultSet.getString("ALLOW_PRES_WITHOUT_STOCK_YN")==null ? "Y":resultSet.getString("ALLOW_PRES_WITHOUT_STOCK_YN");
					DrugDetails.put("CONSIDER_STOCK_FOR_PRES_YN",consider_stock_for_pres_yn );
					DrugDetails.put("ALLOW_PRES_WITHOUT_STOCK_YN",allow_pres_without_stock_yn );
				}			
			}	
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;//PE corrections ends here

			//if((external_product_id.equals("")&& drug_db_interface_yn.equals("Y")&& drug_db_allergy_check_yn.equals("Y") )||(drug_db_allergy_check_yn.equals("N"))) // Condition added for IN25957 --18/01/2011-- priya //Commented this and added teh below condition for SKR-SCF-0372 [IN:030368]
			if(drug_db_interface_yn.equals("N") || external_product_id.equals("")){ 
				String strAD_DA ="'DA', 'AD'";		// Added for HSA-SCF-0011 [IN:042444]
				if(getExcludeADRAllergyAlert().equals("Y")){ 	//Added for HSA-SCF-0011 [IN:042444]
					strAD_DA = "'DA'";}		// Added for HSA-SCF-0011 [IN:042444]
				sql_query			= "select count(*) from (SELECT   a.adv_reac_code allergy_type_code, b.long_desc allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a,  am_reaction_lang_vw b,pr_allergy_sensitivity C, PH_DRUG d, pr_adverse_event adr  WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type in ("+strAD_DA+")  AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code  AND a.patient_id = ? AND b.reaction_code(+) = a.adv_reac_code  AND b.language_id(+) =? and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO AND C.STATUS = 'A' AND( (adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) union ALL SELECT adv_reac_code allergy_type_code, OTHERS_REACTION allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a ,pr_allergy_sensitivity C , PH_DRUG d, pr_adverse_event adr WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type ='DA' AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code AND a.patient_id = ?  AND a.adv_reac_code  ='Oth'and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO and adr.ALLERGY_ALERT_BY <> 'A' AND C.STATUS = 'A' AND ((adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) ) "; // a.adv_event_type = 'DA' changed as a.adv_event_type in ('DA','AD')RUT-SCF-0191.1 [IN:037367]// Changed for RUT-CRF-0065.1 [IN:43255]
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,drugCode);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,locale);
				pstmt.setString(4,drugCode);
				pstmt.setString(5,patient_id);
				
				int rec_count=0;
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					rec_count=resultSet.getInt(1);
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(rec_count>0){
					DrugDetails.put("ALLERGY_YN","Y");
				}
				else{
					DrugDetails.put("ALLERGY_YN","N");
					String ATC_allergy="0"; ;//Code Added for	RUT-CRF-0065 IN 29603 - Start
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
					}	//Code Added for	RUT-CRF-0065 IN 29603 - End
				}
			}
			else
				DrugDetails.put("ALLERGY_YN","N");
//commented the below query for performance ML-MMOH-SCF-0684
/*			
				
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT4"); // CHECK STOCK IS INSTALLED //required to tune
			pstmt				= connection.prepareStatement(sql_query) ;
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				if(checkForNull(resultSet.getString("COUNT")).equals("1")) {
					DrugDetails.put("STOCK_INSTALLED","Y");
					stock_installed		=	"Y";
				 }
				 else {
					DrugDetails.put("STOCK_INSTALLED","N");
					stock_installed		=	"N";
				 }
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			*/
//added for performance - start
			if(getStockInstalledYN()!=null && getStockInstalledYN().equals("Y")){
				DrugDetails.put("STOCK_INSTALLED","Y");
				stock_installed		=	"Y";
			}else{
				DrugDetails.put("STOCK_INSTALLED","N");
				stock_installed		=	"N";
			}
//added for performance - end
			//}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			DrugDetails.put("EXT_DDB_DSG_REASON","");
			DrugDetails.put("EXT_DDB_DUP_REASON","");
			DrugDetails.put("EXT_DDB_INT_REASON","");
			DrugDetails.put("EXT_DDB_CON_REASON","");
			DrugDetails.put("EXT_DDB_ALG_REASON","");
			LinkedHashMap hs = getselectedCopyDrugs();//Added for IN047995--START
			ArrayList tempList=new ArrayList();
			if(hs!=null && hs.size()>0){
				if(hs.containsKey(drugCode)){
					tempList=(ArrayList)hs.get(drugCode);
					DrugDetails.put("START_DATE",tempList.get(0));
					DrugDetails.put("END_DATE",tempList.get(1));
				}
			}//Added for IN047995--end
            //  if((external_product_id.equals("")&& drug_db_interface_yn.equals("Y")&& drug_db_duptherapy_yn.equals("Y") )||(drug_db_duptherapy_yn.equals("N"))){     //condition added for IN22902 --28/07/2010-- Naveen  
			if(drug_db_interface_yn.equals("N") || external_product_id.equals("") || drug_db_duptherapy_yn.equals("N") ){  
				sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13C");
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,patient_id);
				pstmt.setString(2,(String)DrugDetails.get("START_DATE"));
				pstmt.setString(3,(String)DrugDetails.get("END_DATE"));// Changed for ML-BRU-SCF-0811 [IN:039394] 
				pstmt.setString(4,(String)DrugDetails.get("START_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(5,(String)DrugDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(6,(String)DrugDetails.get("START_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(7,(String)DrugDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(8,(String)DrugDetails.get("FREQ_CODE"));
				pstmt.setString(9,generic_id);					
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next())	{
					count_rx=resultSet.getInt(1);
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(count_rx>0){
					DrugDetails.put("CURRENT_RX","Y");
				}
				else{
					DrugDetails.put("CURRENT_RX","N");
				}
			}
			else
				DrugDetails.put("CURRENT_RX","N");

			ArrayList	schedule	=	(ArrayList)this.getScheduleFrequencyStr(drugCode+srlNo,"0");
			if(schedule!=null && schedule.size() > 0) {
				 HashMap detail	=	(HashMap)schedule.get(0);
				 qty_value		=	detail.get("admin_qty") == null ? qty_value : detail.get("admin_qty").toString(); 
				 repeat_value		=	""+schedule.size();
			}
			else {
				repeat_value		=	repeat_value;
			}
			//calucalte total_qty
				float total_qty=0.0f;
				if(dosage_type.equals("A")){
					if( (proc_qty_value!=null && !(proc_qty_value.equals("")))){
						total_qty=Float.parseFloat(proc_qty_value);
					}
					DrugDetails.put("TOT_STRENGTH","0");
					DrugDetails.put("TOT_STRENGTH_UOM","");
					DrugDetails.put("DISPENSED_QTY",String.valueOf(total_qty));
					DrugDetails.put("DISPENSED_UOM",qty_desc_code);
					DrugDetails.put("BMS_QTY",String.valueOf(total_qty));
					DrugDetails.put("BMS_STRENGTH","");
					if(!DrugDetails.containsKey("PRES_QTY_VALUE")){
						DrugDetails.put("PRES_QTY_VALUE",proc_qty_value);
						DrugDetails.put("PRES_QTY_UOM",qty_desc_code);
					}
				}
				else if( dosage_type.equals("Q")){
					if( (proc_qty_value!=null && !(proc_qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
						String equal_value=(String)getConvFactor(strength_uom,qty_desc_code);
						if(!fract_dose.equals("Y")) {
							total_qty		=  (Float.parseFloat(proc_qty_value)*Float.parseFloat(durn_value)*Float.parseFloat(repeat_value)*Float.parseFloat(equal_value));
							total_qty		=	Float.parseFloat(Math.ceil(total_qty/(Float.parseFloat(content_in_pres_base_uom)))+"");			
							if(total_qty==0)
								total_qty	=	1;
						}
						else {
							String	tmp_qty	=	"";

							if( (Float.parseFloat(proc_qty_value)*Float.parseFloat(equal_value)) < Float.parseFloat(content_in_pres_base_uom)){
								tmp_qty	=	1+"";
							} 
							else {
								tmp_qty	=  ((Float.parseFloat(proc_qty_value)*Float.parseFloat(equal_value))/Float.parseFloat(content_in_pres_base_uom))+"";
							}
							total_qty		=  Float.parseFloat(tmp_qty) * Float.parseFloat(durn_value) * Float.parseFloat(repeat_value);
						}
						if(freq_nature.equals("F")) {
							total_qty	=	Float.parseFloat(Math.ceil(total_qty / Integer.parseInt(interval_value))+"");
						}
					}

				//get the conversion factor
					if(strength_value==null || strength_value.equals("0") || strength_value.equals("")) {
						DrugDetails.put("TOT_STRENGTH","0");
						DrugDetails.put("TOT_STRENGTH_UOM","");
						DrugDetails.put("EQUAL_VALUE","");
					}
					else{
						String equal_value=(String)getConvFactor(strength_uom,qty_desc_code);
						float tot_strength=0.0f;
						if(equal_value!=null && !(equal_value.equals(""))){
							tot_strength=total_qty*Integer.parseInt(equal_value);
						}
						DrugDetails.put("EQUAL_VALUE",equal_value);
						DrugDetails.put("TOT_STRENGTH",String.valueOf(tot_strength));
						DrugDetails.put("TOT_STRENGTH_UOM",strength_uom);
					}
					DrugDetails.put("DISPENSED_QTY",String.valueOf(total_qty));
					DrugDetails.put("DISPENSED_UOM",qty_desc_code);
					DrugDetails.put("BMS_QTY",String.valueOf(total_qty));
					DrugDetails.put("BMS_STRENGTH","");
					if(strength_value.equals("0")){
						DrugDetails.put("STRENGTH_VALUE","0");
						DrugDetails.put("STRENGTH_UOM","");
					}
					if(!DrugDetails.containsKey("PRES_QTY_VALUE")){
						DrugDetails.put("PRES_QTY_VALUE",qty_value);
						DrugDetails.put("PRES_QTY_UOM",qty_desc_code);
					}
				}
				else if(dosage_type.equals("S")){
					if(strength_per_pres_uom.equals(""))
						strength_per_pres_uom="1";
					if(strength_per_value_pres_uom.equals(""))
						strength_per_value_pres_uom="1";
					String tmp_qty	= "";
					if( (proc_qty_value!=null && !(proc_qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
						if(!fract_dose.equals("Y")) {	
							total_qty	=((Float.parseFloat(proc_qty_value)*Integer.parseInt(durn_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom)));
							total_qty		=new Float(Math.ceil(new Float(total_qty/Float.parseFloat(content_in_pres_base_uom)).floatValue())).floatValue();
						}
						else {
							float unit_qty		= (float)Math.ceil(Float.parseFloat(proc_qty_value)/Float.parseFloat(strength_per_pres_uom)) * (Float.parseFloat(strength_per_value_pres_uom));			
							tmp_qty				= (Math.ceil(unit_qty /Float.parseFloat(content_in_pres_base_uom))+"");
							total_qty			= (Float.parseFloat(tmp_qty) * Float.parseFloat(durn_value) * Float.parseFloat(repeat_value));
						}
						if(freq_nature.equals("F")) {
							total_qty	=	Float.parseFloat(Math.ceil(total_qty / Integer.parseInt(interval_value))+"");
						}
					}
					DrugDetails.put("TOT_STRENGTH",String.valueOf(total_qty));
					DrugDetails.put("TOT_STRENGTH_UOM",qty_desc_code);
					DrugDetails.put("DISPENSED_QTY",String.valueOf(total_qty));
					DrugDetails.put("DISPENSED_UOM",qty_desc_code);
					DrugDetails.put("BMS_QTY",String.valueOf(total_qty));
					DrugDetails.put("BMS_STRENGTH","");
					if(!DrugDetails.containsKey("PRES_QTY_VALUE")){
						DrugDetails.put("PRES_QTY_VALUE",qty_value);
						DrugDetails.put("PRES_QTY_UOM",qty_desc_code);
					}
				}
				if(DrugDetails.get("COPIED_DRUG_YN")==null || ((String)DrugDetails.get("COPIED_DRUG_YN")).equals("N")){
					HashMap sliding_scale_dtls = getSlidingScaleDetails(drugCode);
					if(sliding_scale_dtls.size() > 0) {
						total_qty	=	Float.parseFloat((String)DrugDetails.get("PRES_QTY_VALUE"));
						DrugDetails.put("SLIDING_SCALE_YN",(String)sliding_scale_dtls.get("APPL_SLIDING_SCALE_YN"));
					}
					else{
						DrugDetails.put("SLIDING_SCALE_YN","N");
					}
				}
				String slidingscale_yn = (String)DrugDetails.get("SLIDING_SCALE_YN");
				if(slidingscale_yn!=null &&slidingscale_yn.equals("Y") ){
					DrugDetails.put("ROUTE_CODE",route_code);
					DrugDetails.put("ROUTE_DESC",route_desc);
					DrugDetails.put("ROUTE_COLOR",route_color);

				}
				DrugDetails.put("REFILL_START_DATE","");
				DrugDetails.put("REFILL_END_DATE","");
				DrugDetails.put("AUTH_YN","N");
				DrugDetails.put("APPROVAL_YN","N");
				DrugDetails.put("COSIGN_YN","N");
				DrugDetails.put("AUTH_YN_VAL","N");
				DrugDetails.put("APPROVAL_YN_VAL","N");
				DrugDetails.put("COSIGN_YN_VAL","N");
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
				if(freq_nature.equals("P")) {//for PRN
					DrugDetails.put("DURN_TYPE","D");
				}
				if((String)DrugDetails.get("DURN_TYPE")==null)//|| (!((String)DrugDetails.get("DURN_TYPE")).equals("D"))
					DrugDetails.put("DURN_TYPE","D");
				if( (!dosage_type.equals("A"))&&(DrugDetails.get("TAPER_DOSE_YN").equals("Y") || DrugDetails.get("TAPER_UP").equals("Y"))){
					DrugDetails.put("PROVIDE_TAPER","Y");
					DrugDetails.put("SCH_OVER_YN","N");
				}
				else{
					DrugDetails.put("SCH_OVER_YN","Y");
					DrugDetails.put("PROVIDE_TAPER","N");
				}

				float ext_qty=Float.parseFloat(checkForNull((qty_value),"0")); // checkForNull Added for MMS-KH-CRF-0016
				int ext_repeat_value=1;
				if((repeat_value!=null && !(repeat_value.equals("")))  ){
					ext_repeat_value=Integer.parseInt(repeat_value);
				}
				float total_qty_value=ext_qty*ext_repeat_value;
				DrugDetails.put("TOTAL_QTY_VALUE",""+total_qty_value);

				//String drug_class=(String) getDrugClass(order_type_code);
				//String duplicate_yn="";
				/*==Code For Checking ATC Level-4 Duplication Checking..Based on the facility param Flag(duplicate_check_at_atc_yn)    6/7/2005*/ //  commented by naveen on 15Sep2010  procedure should be changed to work based on ATC classification.after changing code should be opened again //Commented cod removed
				String licence=(String)(PhLicenceRights.getKey());
				String disp_locn = null;
				String disp_locn_code = null;
				String disp_locn_desc = null;
				DrugDetails.put("LICENCE",licence);
				//added for NMC-JD-CRF-0063 [11525] START
				if(getOpHomeMedicationVal()!=null && !getOpHomeMedicationVal().equals("") && getOpHomeMedicationVal().equals("Y")){
					 setOpDischMedInd("Y");  
				}// 11525 END
				if(getTakeHomeMedicationOp()!=null && !getTakeHomeMedicationOp().equals("") && getTakeHomeMedicationOp().equals("Y") && getOpDischMedInd()!=null && !getOpDischMedInd().equals("") && getOpDischMedInd().equals("Y")){
					take_home_medication = "Y";
						System.out.println("take_home_medication: "+take_home_medication);  
				}//END
	//			System.out.println("getOpDischMedInd: "+getOpDischMedInd());   
//System.err.println("===getDispLocn========locn_type=========>"+locn_type+" locn_code="+locn_code+" login_facility_id="+login_facility_id+" drug_class="+drug_class+" drugCode="+drugCode+" order_type_code="+order_type_code+" act_patient_class="+act_patient_class+" take_home_medication="+take_home_medication+" home_leave_yn_val="+home_leave_yn_val+" patient_id="+patient_id+" encounter_id="+encounter_id);
				if(freq_nature.equals("O"))//added for MMS_BETA_0043 [IN:046240]  start
					priority="U";

				if(getExternalpatient_id() ==null || getExternalpatient_id().equals("") ) {					
					pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT16A") );
					pstmt.setString(1,locn_type);
					pstmt.setString(2,locn_code);
					pstmt.setString(3,login_facility_id);
					pstmt.setString(4,login_facility_id);
					pstmt.setString(5,drug_class);
					pstmt.setString(6,drugCode);
					pstmt.setString(7,order_type_code);
					pstmt.setString(8,act_patient_class);
					pstmt.setString(9,take_home_medication);
					pstmt.setString(10,priority);
					pstmt.setString(11,getLanguageId());
					pstmt.setString(12,"D");
					pstmt.setString(13,home_leave_yn_val);//added home_leave_yn_val for Bru-HIMS-CRF-093[29960] -->
					pstmt.setString(14,patient_id);
					pstmt.setString(15,encounter_id);
					//added for GHL-CRF-0509 start
					if(site_verbal_order){
						pstmt.setString(16,called_from_verbal_order);	
					}
					else
					{
						pstmt.setString(16,"Y");//added for GHL-CRF-0509
					}
					pstmt.setString(17,getOpDischMedInd());//added for NMC-JD-CRF-0063
					//added for GHL-CRF-0509 end
					resultSet = pstmt.executeQuery() ;
					if(resultSet!=null && resultSet.next()){
						disp_locn =resultSet.getString("DISP_LOCN");
//System.err.println("==disp_locn===============>"+disp_locn);
						if(disp_locn != null && disp_locn.length()>0){
							disp_locn_code = disp_locn.substring(0,disp_locn.indexOf('|'));
							if(disp_locn.indexOf('|',disp_locn.indexOf('|')+1) == -1){
								disp_locn_desc = disp_locn.substring(disp_locn.indexOf('|')+1);
								performing_facility_id = "";
							}
							else{
								disp_locn_desc = disp_locn.substring(disp_locn.indexOf('|')+1,disp_locn.lastIndexOf('|'));
								performing_facility_id = disp_locn.substring(disp_locn.lastIndexOf('|')+1);
							}
						}
					}
                    closeResultSet(resultSet);//added for PE issue
					closeStatement(pstmt);
					//closeResultSet(resultSet);//Commented for PE issue

					//Added for TFS-16341-Start
					
					if(getDefaultDispLocnSelectAppl() && (!getDefaultDispLocnCode().equals("") && getDefaultDispLocnCode()!=null))
					{
						disp_locn_code = getDefaultDispLocnCode();
						
		                pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT27") );
						pstmt.setString(1,disp_locn_code);
						pstmt.setString(2,login_facility_id);
						pstmt.setString(3,getLanguageId());
				
						resultSet = pstmt.executeQuery() ;
											
						if(resultSet!=null && resultSet.next()){					
							disp_locn_desc = resultSet.getString("SHORT_DESC");				
						}
						closeStatement(pstmt);
						closeResultSet(resultSet);
					
					}
					else if(site_alw_disp_loc_drug_search_appl) //added for NMC-JD-CRF-0197 
					{
						disp_locn_code = getDefaultDispLocnCode();
						
		                pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT27") );
						pstmt.setString(1,disp_locn_code);
						pstmt.setString(2,login_facility_id);
						pstmt.setString(3,getLanguageId());			
						resultSet = pstmt.executeQuery() ;											
						if(resultSet!=null && resultSet.next()){					
							disp_locn_desc = resultSet.getString("SHORT_DESC");				
						}
						closeStatement(pstmt);
						closeResultSet(resultSet);						
					}
					
					//Added for TFS-16341-End
					setDispLocation(srlNo,disp_locn_code);
					DrugDetails.put("DISP_LOCN_CODE",disp_locn_code);	
					DrugDetails.put("DISP_LOCN_DESC",disp_locn_desc);	
					DrugDetails.put("PERFORMING_FACILITY_ID",performing_facility_id);	
					DrugDetails.put("PRO_TEST",drugCode+"|"+disp_locn_code+"|"+ String.valueOf(total_qty)+"|"+"N"+"|"+end_date+"|"+"N");
					//if(nationalityCheck(patient_id)) {// nationality check starts
					ext_disp_appl_yn = getExtDispYN(disp_locn_code);// added for IN071763				
						if(consider_stock_for_pres_yn.equals("Y") && allow_pres_without_stock_yn.equals("N") && stock_installed.equals("Y") && ext_disp_appl_yn.equals("N")) {// modified for IN071763
							if(item_code!=null && !(item_code.equals(""))) {
								cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
								cstmt.setString( 1, item_code+"="+trade_code);
								cstmt.setString( 2, disp_locn_code);
								cstmt.setString( 3, String.valueOf(total_qty));
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
								DrugDetails.put("STOCK_AVAILABLE_YN",(String)(cstmt.getString(8)==null ? "Y":cstmt.getString(8)));
								DrugDetails.put("AVAILABLE_STOCK",(String.valueOf(cstmt.getInt(11))));
								try{
									closeStatement( cstmt ) ;
								}
								catch(Exception es){
									DrugDetails.put("STOCK_AVAILABLE_YN","N");
									DrugDetails.put("AVAILABLE_STOCK","0");
									es.printStackTrace() ;
								}//end of stock avail
							}
							else {
								DrugDetails.put("STOCK_AVAILABLE_YN","N");
								DrugDetails.put("AVAILABLE_STOCK","0");
							}
						} 
						//added for IN071763 
						else if (consider_stock_for_pres_yn.equals("Y") && allow_pres_without_stock_yn.equals("N") && stock_installed.equals("Y") && ext_disp_appl_yn.equals("Y")  ){
							System.out.println("external dispensing location");
							sql_query			= PhRepository.getPhKeyValue("SQL_PH_EXTERNAL_DISPENSING_QTY");
							pstmt				= connection.prepareStatement(sql_query) ;
							pstmt.setString(1,disp_locn_code);
							pstmt.setString(2,drugCode); 
							resultSet			= pstmt.executeQuery();
							//int count = 0; //Commented for common-icn-0048
							while(resultSet!=null && resultSet.next()){
								String available_stock = resultSet.getString("EXTERNAL_ITEM_QTY");
								int avlStock = Integer.parseInt(available_stock); 
								System.out.println("available_stock: "+available_stock);
								if(avlStock > 0){
									DrugDetails.put("STOCK_AVAILABLE_YN","Y");
									DrugDetails.put("AVAILABLE_STOCK",available_stock);
								}else{
									DrugDetails.put("STOCK_AVAILABLE_YN","N");
									DrugDetails.put("AVAILABLE_STOCK","0");
								}
							}
							closeResultSet( resultSet ) ;
							closeStatement( pstmt ) ;
						}//added for IN071763 
						else {
							DrugDetails.put("STOCK_AVAILABLE_YN","Y");
							DrugDetails.put("AVAILABLE_STOCK","5000");
						}
				}// nationality check ends
				else{	//For External Prescription 
					sql_query			= PhRepository.getPhKeyValue("SQL_PH_EXT_PRESCRIPTION_DISP_LOCN_SELECT");
					pstmt				= connection.prepareStatement(sql_query) ;
					pstmt.setString(1,facility_id);
					pstmt.setString(2,locale);
					resultSet			= pstmt.executeQuery();
					int count = 0;
					ExternalPresDispCodes	= new ArrayList();
					ExternalPresDispDesc	= new ArrayList();
					while(resultSet!=null && resultSet.next()){
						if(count==0){
							DrugDetails.put("DISP_LOCN_CODE",(resultSet.getString("DISP_LOCN_CODE")) );
							DrugDetails.put("DISP_LOCN_DESC",(resultSet.getString("SHORT_DESC")) );
							ExternalPresDispCodes.add(resultSet.getString("DISP_LOCN_CODE"));
							ExternalPresDispDesc.add(resultSet.getString("SHORT_DESC"));
						}
						else{
							ExternalPresDispCodes.add(resultSet.getString("DISP_LOCN_CODE"));
							ExternalPresDispDesc.add(resultSet.getString("SHORT_DESC"));
						}
						count ++;
					}

					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;

					sql_query			= PhRepository.getPhKeyValue("SQL_PH_EXT_PRESCRIPTION_DEFLT_DISP_LOCN_SELECT");
					
					pstmt				= connection.prepareStatement(sql_query) ;
					pstmt.setString(1,facility_id);
					pstmt.setString(2,locale);
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()){
						DrugDetails.put("DISP_LOCN_CODE",resultSet.getString("DFLT_EXT_RX_DISP_LOCN"));	
						DrugDetails.put("DISP_LOCN_DESC",resultSet.getString("SHORT_DESC"));	
						setDispLocation(srlNo,(String)DrugDetails.get("DISP_LOCN_CODE"));
					}
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					//if(nationalityCheck(patient_id)) {// nationality check starts
						if(consider_stock_for_pres_yn.equals("Y") && allow_pres_without_stock_yn.equals("N") && stock_installed.equals("Y")) {
							if(item_code!=null && !(item_code.equals(""))) {
								cstmt=null;
								cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
								cstmt.setString( 1, item_code+"="+trade_code);
								cstmt.setString( 2, (String)DrugDetails.get("DISP_LOCN_CODE"));
								cstmt.setString( 3, String.valueOf(total_qty));
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
								DrugDetails.put("STOCK_AVAILABLE_YN",(String)(cstmt.getString(8)==null ? "Y":cstmt.getString(8)));
								DrugDetails.put("AVAILABLE_STOCK",(String.valueOf(cstmt.getInt(11))));
								closeStatement( cstmt ) ;
							} //end of stock avail
							else {
								DrugDetails.put("STOCK_AVAILABLE_YN","N");
								DrugDetails.put("AVAILABLE_STOCK","0");
							}
						}
						else {
							DrugDetails.put("STOCK_AVAILABLE_YN","Y");
							DrugDetails.put("AVAILABLE_STOCK","5000");
						}
				}
			DrugDetails.put("freq_chng_durn_desc",repeat_durn_type);
			DrugDetails.put("freq_chng_durn_value",durn_value);
			/*String buildMAR_rule_org = getMARDefaulting(act_pat_class,locn_code,form_code,priority);//added for skr-scf-1714
		System.out.println("3821 buildMAR_rule_org"+buildMAR_rule_org);*/
			DrugDetails.put("BUILD_MAR_RULE_ORG",buildMAR_rule_org);//added for skr-scf-1714
			if((getActPatientClass_frm_Hdr().toUpperCase().equals("IP") || act_pat_class.toUpperCase().equals("OP")) && (take_home_medication.toUpperCase().equals("Y") || take_home_medication.toUpperCase().equals("D"))){
				 act_pat_class = "DM";
			}//IN301118-SCF No: MO-GN-5400. Duplicate Drug Check.
			String buildMAR_rule = getMARDefaulting(act_pat_class,locn_code,form_code,priority);
			DrugDetails.put("BUILD_MAR_RULE",buildMAR_rule);
			if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("CD")) //if block Added for MMS-QH-CRF-0080
				DrugDetails.put("BUILDMAR_YN", "Y");
			DrugDetails.put("INTR_RESTRIC_TRN", "N");//Added for	RUT-CRF-0066 IN[029604] - start
			DrugDetails.put("INTERACTION_EXISTS", "N" );
			DrugDetails.put("DRUGINTRACTION_OVERRIDE","N");
			DrugDetails.put("INTR_ALERT", "N" );
		/*	if( !drug_db_interface_yn.equals("Y") || DrugDetails.get("EXTERNAL_PRODUCT_ID")==null || ((String)DrugDetails.get("EXTERNAL_PRODUCT_ID")).equals("") ){ //commented for MMS-KH-CRF-0029 and moved to PrescriptionValidation.jsp
				ArrayList alDrugIntrDtlList = getDrugInteractionDtls(drugCode, form_code, generic_id,(String)DrugDetails.get("START_DATE"),(String)DrugDetails.get("END_DATE") , patient_id);
				
				if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
					DrugDetails.put("SEVERITY_LEVEL", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2) );
					DrugDetails.put("INTR_RESTRIC_TRN", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1) );
					DrugDetails.put("INTERACTION_DTL", alDrugIntrDtlList );
					DrugDetails.put("INTERACTION_EXISTS", "Y" );
					if(((String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1)).equals("Y") || ((String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2)).equals("H")){
						DrugDetails.put("INTR_ALERT", "Y" );
					}
				}
			} *///Added for	RUT-CRF-0066 IN[029604] - end // RUT-CRF-0062 [IN029600]  Added to get Build MAR Rule -- end
			if(!locale.equals("en")){
				date_str = (String)DrugDetails.get("START_DATE");
				date_str= com.ehis.util.DateUtils.convertDate(date_str, "DMYHM","en",locale);
				DrugDetails.put("START_DATE",date_str);
				date_str = (String)DrugDetails.get("END_DATE");
				date_str= com.ehis.util.DateUtils.convertDate(date_str, "DMYHM","en",locale);
				DrugDetails.put("END_DATE",date_str);
				date_str = (String)DrugDetails.get("FUTURE_DATE");
				date_str= com.ehis.util.DateUtils.convertDate(date_str, "DMYHM","en",locale);
				DrugDetails.put("FUTURE_DATE",date_str);
				date_str = (String)DrugDetails.get("BACK_DATE");
				date_str= com.ehis.util.DateUtils.convertDate(date_str, "DMYHM","en",locale);
				DrugDetails.put("BACK_DATE",date_str);
			}//end of dispense
			DrugDetails.put("REFILL_YN_FROM_PARAM",getRefillYNFromParam());
			//hs = getselectedCopyDrugs();//Added for Bru-HIMS-CRF-403--START
			if(DrugDetails.get("COPIED_DRUG_YN")!=null && ((String)DrugDetails.get("COPIED_DRUG_YN")).equals("Y") && hs!=null && hs.size()>0){
				if(hs.containsKey(drugCode)){
					tempList=(ArrayList)hs.get(drugCode);
					if(tempList.get(4).equals("Y")){
						DrugDetails.put("CURRENT_RX","Y");
						DrugDetails.put("CURRENTRX_OVERRIDE","Y");
						DrugDetails.put("Override_Check","Y");
						DrugDetails.put("CURRENTRX_REMARKS",tempList.get(2));
					}
					if(((String)tempList.get(5)).equals("w"))
						tempList.set(5,"W");
					else if(((String)tempList.get(5)).equals("M"))
						tempList.set(5,"L");
					else if(((String)tempList.get(5)).equals("d"))
						tempList.set(5,"D");
					else if(((String)tempList.get(5)).equals("Y"))
						tempList.set(5,"Y");
					DrugDetails.put("DURN_VALUE",tempList.get(3));
					DrugDetails.put("DURN_TYPE",tempList.get(5));
					DrugDetails.put("START_DATE",tempList.get(0));
					DrugDetails.put("END_DATE",tempList.get(1));
				}
			}
			else if(getDefaultDuration()!=null && getDefaultDuration().size()>0){
				String org_dur = (String)DrugDetails.get("DURN_VALUE");
				String drug_code = (String)DrugDetails.get("DRUG_CODE");
				String org_dur_desc = DrugDetails.get("DURN_TYPE")==null?"":(String)DrugDetails.get("DURN_TYPE");
				ArrayList new_dur = getDefaultDuration();
				ArrayList cal_dur  = null;
				if( !freq_nature.equalsIgnoreCase("O") &&  !org_dur_desc.equalsIgnoreCase("H") && !org_dur_desc.equalsIgnoreCase("M") ){
					cal_dur = caluculateDuaration(org_dur,org_dur_desc,(String)new_dur.get(0),(String)new_dur.get(1));
					DrugDetails.put("DURN_VALUE",cal_dur.get(0));
					DrugDetails.put("DURN_TYPE",cal_dur.get(1));
					repeatDurationSet.put(drug_code, cal_dur.get(1));
					DrugDetails.put("REPEAT_DURN_TYPE",cal_dur.get(1));
				}
			}//Added for Bru-HIMS-CRF-403--end
			DrugDetails.put("EXT_DISP_APPL_YN", ext_disp_appl_yn);   //Added for NMC-JD-CRF-0046
		} 
		catch ( Exception e ) {
			DrugDetails.put("STOCK_AVAILABLE_YN","Y");
			DrugDetails.put("AVAILABLE_STOCK","1000");
			e.printStackTrace() ;
			return DrugDetails;      
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( res_copy );
				closeStatement( pstmt ) ;
				closeStatement( pstmt_copy ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		 }
		DrugDetails.put("ABUSE_RESTRIC_TRN", "N");
		DrugDetails.put("abuse_EXISTS", "N" );
		DrugDetails.put("ABUSE_REMARKS","N");
		DrugDetails.put("ABUSE_ACTION", "N" );
		DrugDetails.put("ABUSE_TYPE", "N" );
		//if(!drug_db_interface_yn.equals("Y") || DrugDetails.get("EXTERNAL_PRODUCT_ID").equals("") ){ 
		String drugClass=getDrugClassByOrderId(drugCode);
		String drugdesc=getDrugDescByOrderId(drugCode);
			HashMap abuseDrugMap = getabusedetails(patient_id,drugCode,drugClass);
			System.err.println("3860drugclass"+drugClass);
			System.err.println("2130drugClass"+drugdesc);
			System.err.println("2130abuseDrugMap"+abuseDrugMap);
			
			DrugDetails.put("ABUSE_RESTRIC_TRN", abuseDrugMap.get("restrict_tran"));
			DrugDetails.put("ABUSE_EXISTS", "Y" );
			DrugDetails.put("abuse_drug_override_reason","");
			DrugDetails.put("ABUSE_OVERRIDE","N");
			DrugDetails.put("ABUSE_ACTION", abuseDrugMap.get("action_type_flag") );
			DrugDetails.put("ABUSE_TYPE", abuseDrugMap.get("restriction_type") );
			DrugDetails.put("ABUSE_DRUG_DESC", drugdesc );
			DrugDetails.put("DRUG_CLASS_OR_DRUG_CODE", abuseDrugMap.get("DRUG_CLASS_OR_DRUG_CODE"));
			
					
		return DrugDetails;
	}

	public void addDrugDetails(int pos,HashMap drugDetails)	{
		if(pos==999)
			this.presDetails.add(drugDetails);
		else
			this.presDetails.add(++pos,drugDetails);
	}
	public void removeNoStockDrug(String drug_code)	{
		if(presDetails!=null && presDetails.size()>0){
			for(int i=0; i<presDetails.size() ; i++){
				HashMap drugData=new HashMap();
				drugData=(HashMap) presDetails.get(i);
				String drugCode=(String) drugData.get("DRUG_CODE");
				if(drugCode.equals(drug_code)){
					presDetails.remove(i);
				}
			}
		}
	}

	public String getDrugClass(String order_type){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String drug_class="";
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT11A");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,order_type);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				drug_class = resultSet.getString("DRUG_CLASS");
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

	public HashMap chkStockAvail(String item_code,String disp_code,String total_qty,String end_date, String trade_code){//check the stock availability
		Connection connection       = null ;
        CallableStatement cstmt     = null ;
        ResultSet resultSet         = null ;
		HashMap stockValues			= new HashMap();
		try{
			connection = getConnection() ;
			cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, item_code+"="+trade_code);
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
			return stockValues;
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
		return stockValues;
	}//end of stock

	public HashMap populateFrequencyValues(String drug_code,String freq_code,String mode,String patient_class){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		HashMap frequency			= new HashMap();
		ArrayList FreqCode			= new ArrayList();
		ArrayList FreqDesc			= new ArrayList();
		ArrayList FreqNature			= new ArrayList();
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection = getConnection() ;
			if(mode!=null && mode.equals("taper"))
				//sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10B");// " AND (A.FREQ_NATURE<>'C' OR A.FREQ_NATURE<>'I' )" replaced with  "AND A.FREQ_NATURE<>'C'" for ICN 31700//Commented for HSA Performense issue
//query modified for  7295 HSA-SCF-0001  
				sql_query="SELECT DISTINCT A.FREQ_CODE,A.FREQ_DESC, A.FREQ_NATURE FROM AM_FREQUENCY_LANG_VW A, OR_FREQ_CATALOG_SCOPE B WHERE A.EFF_STATUS='E' AND A.FREQ_NATURE NOT IN ('C','Y') AND A.FREQ_CODE = B.FREQ_CODE AND ((A.SCHEDULED_YN='Y'  and exists (select 1 from am_frequency_admin_day_time c where b.freq_code = c.freq_code   and c.admin_facility_id in (?,'*A',?) ) )  OR (a.scheduled_yn = 'N') OR A.FREQ_NATURE IN ('P','O')) AND  /* A.REPEAT_DURN_TYPE IS NOT NULL AND A.INTERVAL_DURN_TYPE IS NOT NULL AND */ B.ORDER_CATALOG_CODE=? AND A.LANGUAGE_ID = ? ORDER BY 2";//added for HSA Performense issue,modified for SKR-SCF-1660
 
			else if(mode!=null && mode.equals("SlidingScale"))
				sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10B_IP");// " AND (A.FREQ_NATURE<>'C' OR A.FREQ_NATURE<>'I' )" replaced with  "AND A.FREQ_NATURE<>'C'" for ICN 31700
			else
				//sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10A");//Commented for HSA Performense issue
				//query modified for  7295 AND HSA-SCF-0001
			     //sql_query="SELECT DISTINCT A.FREQ_CODE,A.FREQ_DESC, A.FREQ_NATURE FROM AM_FREQUENCY_LANG_VW A, OR_FREQ_CATALOG_SCOPE B WHERE A.EFF_STATUS='E' AND A.FREQ_NATURE<>'C' AND A.FREQ_CODE = B.FREQ_CODE AND ((A.SCHEDULED_YN='Y'  and exists (select 1 from am_frequency_admin_day_time c where b.freq_code = c.freq_code   and c.admin_facility_id in (?,'*A',?) ) )  OR (a.scheduled_yn = 'N') OR A.FREQ_NATURE IN ('P','O')) AND  A.REPEAT_DURN_TYPE IS NOT NULL AND A.INTERVAL_DURN_TYPE IS NOT NULL AND B.ORDER_CATALOG_CODE=? AND A.LANGUAGE_ID = ? ORDER BY 2";//added for HSA Performense issue
			   	sql_query="SELECT DISTINCT A.FREQ_CODE,A.FREQ_DESC, A.FREQ_NATURE FROM AM_FREQUENCY_LANG_VW A, OR_FREQ_CATALOG_SCOPE B WHERE A.EFF_STATUS='E' AND A.FREQ_NATURE NOT IN ('C','Y') AND A.FREQ_CODE = B.FREQ_CODE AND ((A.SCHEDULED_YN='Y'  and exists (select 1 from am_frequency_admin_day_time c where b.freq_code = c.freq_code   and c.admin_facility_id in (?,'*A',?) ) )  OR (a.scheduled_yn = 'N') OR A.FREQ_NATURE IN ('P','O'))  AND B.ORDER_CATALOG_CODE=? AND A.LANGUAGE_ID = ? ORDER BY 2";//added for HSA Performense issue// AND  A.REPEAT_DURN_TYPE IS NOT NULL AND A.INTERVAL_DURN_TYPE IS NOT NULL removed for ML-MMOH-SCF-0865
			pstmt				= connection.prepareStatement(sql_query) ;
			if(ord_facility_id!=null && !(ord_facility_id.equals(""))){ // if-else condition added for IN20068 --18/03/2010-- priya
				pstmt.setString(1,ord_facility_id);
				pstmt.setString(2,ord_facility_id);
			}
			else{
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,login_facility_id);
			}
			pstmt.setString(3,drug_code);
			pstmt.setString(4,locale);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()) {
				FreqCode.add(resultSet.getString("FREQ_CODE"));
				FreqDesc.add(resultSet.getString("FREQ_DESC"));
				FreqNature.add(resultSet.getString("FREQ_NATURE"));
			}
			frequency.put("FreqCode",FreqCode);
			frequency.put("FreqDesc",FreqDesc);
			frequency.put("FreqNature",FreqNature);
		}
		catch ( Exception e ) {
			frequency.put("error",e);
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
		return frequency;
	}

	public String populateEndDate(String freq_nature,String start_date,String durn_value,String repeat_durn_type){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String end_date				="";
		try{
			connection = getConnection() ;
			//sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7AA");
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

	public String getOrderQty(HashMap ext_drugData,String qty_value,String dup_repeat,String durn, String interval_value,String dosage,String conv_factor,boolean split_chk) {
		String fract_dose						= (String)ext_drugData.get("FRACT_DOSE_ROUND_UP_YN");
		String dosage_type						= (String)ext_drugData.get("DOSAGE_TYPE");
		dosage_type								= dosage;
		String durn_value						= (String)ext_drugData.get("DURN_VALUE");
		durn_value								= durn;
		String repeat_value						=  (String)ext_drugData.get("REPEAT_VALUE")==null?"1":(String)ext_drugData.get("REPEAT_VALUE");
		String content_in_pres_base_uom			= (String)ext_drugData.get("CONTENT_IN_PRES_BASE_UOM")==null?"1":(String)ext_drugData.get("CONTENT_IN_PRES_BASE_UOM");;
		String strength_per_value_per_pres_uom	= (String)ext_drugData.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"1":(String)ext_drugData.get("STRENGTH_PER_VALUE_PRES_UOM");;
		String strength_per_pres_uom			= (String)ext_drugData.get("STRENGTH_PER_PRES_UOM")==null?"1":(String)ext_drugData.get("STRENGTH_PER_PRES_UOM");;
		String freq_nature			= (String)ext_drugData.get("FREQ_NATURE"); //added for SRR20056-SCF-6322 ICN 25704
		String ext_drug_code = (String)ext_drugData.get("DRUG_CODE")==null?"":(String)ext_drugData.get("DRUG_CODE");//Code added for IN21385 --25/05/2010 -- priya
		String ext_srl_no = (String)ext_drugData.get("SRL_NO")==null?"":(String)ext_drugData.get("SRL_NO");
		ArrayList	ext_schedule	=	(ArrayList)getScheduleFrequencyStr(ext_drug_code+ext_srl_no,"0");
		boolean ext_split_chk	=	checkSplit(ext_schedule);
		if(strength_per_pres_uom.equals("") || Float.parseFloat(strength_per_pres_uom) == 0)
			strength_per_pres_uom = "1";
		if(strength_per_value_per_pres_uom.equals("") || Float.parseFloat(strength_per_value_per_pres_uom) == 0)
			strength_per_value_per_pres_uom = "1";
		if(interval_value==null || interval_value.equals(""))
			interval_value	= (ext_drugData.get("INTERVAL_VALUE")==null || ((String)ext_drugData.get("INTERVAL_VALUE")).equals(""))?"1":(String)ext_drugData.get("INTERVAL_VALUE");//uncommented for ML-BRU-SCF-1907 and TBMC-SCF-0044
           if(interval_value==null || interval_value.equals("")) 
			 interval_value	= "1";
		String ord_qty							=	"";
		String	tmp_qty							=	"";
        repeat_value=dup_repeat;
		if(repeat_value==null || repeat_value.equals("") ){
			String freq_code =(String)ext_drugData.get("FREQ_CODE");
			Connection connection       = null ;
			PreparedStatement pstmt     = null ;
			ResultSet resultSet         = null ;
			try{
				connection = getConnection() ;
				pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT_REPEAT_VALUE")) ;
				pstmt.setString(1,freq_code);
				resultSet = pstmt.executeQuery();
				if(resultSet !=null && resultSet.next()){
					repeat_value=resultSet.getString("repeat_value");
				}
			}
			catch(Exception e){
				e.printStackTrace() ;
			}
			finally{
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

		 if(repeat_value==null || repeat_value.equals("") ){
			   repeat_value="1";
		 }
		 if(durn_value==null || durn_value.equals("") ){
			   durn_value="1";
		 }
		if(interval_value==null || interval_value.equals(""))
			interval_value	="1";
		if( ext_split_chk ) {  // split_chk changed to ext_split_chk for IN21385 --25/05/2010 -- priya
			repeat_value		=	"1";
		}
		try {
			if(dosage_type!=null && dosage_type.equals("A")){
				ord_qty	=	qty_value;
			} 
			else if(dosage_type!=null && dosage_type.equals("Q")){
				if(fract_dose.equals("N")) {
					//if(conv_factor.contains(".")) // added for SKR-SCF-0309.1  [IN030625] and removed for ML-MMOH-SCF-1692
						ord_qty		=  (Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value))*Float.parseFloat(repeat_value)* Float.parseFloat(conv_factor))+"";
					/*else //removed for ML-MMOH-SCF-1692
						ord_qty		=  ((Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value))*Float.parseFloat(repeat_value))/ Float.parseFloat(conv_factor))+"";    // Commented and Added for SKR-SCF-0309.1 [IN32493] and  SKR-SCF-0478 [IN30625] */
					ord_qty		=	Float.parseFloat(ord_qty)/(Float.parseFloat(content_in_pres_base_uom))+"";
					DecimalFormat dfTest = new DecimalFormat("##.####");
					ord_qty = dfTest.format(Double.parseDouble(ord_qty));
					ord_qty		=	Math.ceil(Float.parseFloat(ord_qty))+"";
					if(ord_qty.equals("0")){
						ord_qty	=	"1";
					}
				} 
				else {
					if(dosage_type.equals("Q")){ //if block added for IN25425 --09/12/2010-- priya
                     // qty_value		=   (Math.ceil((Float.parseFloat(qty_value))/(Float.parseFloat(content_in_pres_base_uom))))*(Float.parseFloat(content_in_pres_base_uom))+"";//commebnted for ML-BRU-SCF-1783 //replaced strength_per_value_per_pres_uom with content_in_pres_base_uom in both places for IN25763 --07/11/2011-- priya	
					 qty_value		=   Math.ceil((Float.parseFloat(qty_value))/(Float.parseFloat(content_in_pres_base_uom)))*(Float.parseFloat(content_in_pres_base_uom))+"";//Added for ML-BRU-SCF-1783(Removed Math.ceil) and reverted for ML-MMOH-SCF-1443
					}
					if( ((Float.parseFloat(qty_value)*Float.parseFloat(conv_factor)) < Float.parseFloat(content_in_pres_base_uom))  )  {
						tmp_qty	=	1+"";
					}
					else {
						if(Float.parseFloat(content_in_pres_base_uom)<1 || ((Float.parseFloat(qty_value)*Float.parseFloat(content_in_pres_base_uom)) < Float.parseFloat(conv_factor)))//if block and else condition added for ML-BRU-SCF-1190 [IN:045647] and OR condition added for ML-MMOH-SCF-1596
							tmp_qty	=  Math.ceil(Float.parseFloat(qty_value)/(Float.parseFloat(conv_factor)*Float.parseFloat(content_in_pres_base_uom)))+"";
						else
							tmp_qty	=  Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(conv_factor))/Float.parseFloat(content_in_pres_base_uom))+"";
					}
					 ord_qty	=  (Float.parseFloat(tmp_qty) *Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value))*Float.parseFloat(repeat_value))+"";
					 if( (Float.parseFloat(qty_value)*Float.parseFloat(conv_factor)) < Float.parseFloat(content_in_pres_base_uom)) {
						ord_qty	=  Math.ceil((Float.parseFloat(ord_qty)/* *(Float.parseFloat(qty_value)  */ ) /Float.parseFloat(content_in_pres_base_uom))+""; ////*(Float.parseFloat(qty_value) added for IN21601reopen --03/06/2010 -- priya //// It is commented for  IN22611 --13/07/2010-- priya
					}
				}
				ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(String.valueOf(ord_qty))));
				/*if(freq_nature.equals("F")) {
					ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(ord_qty) / Integer.parseInt(interval_value)));
				}*/
			} 
			else if(dosage_type!=null && dosage_type.equals("S")){
				if(fract_dose.equals("N")) {	
					//Calculating final order quantity-Multiply by strength_per_pres_value 
					ord_qty		=(Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value))*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))+"";

					ord_qty		=	(float)(Float.parseFloat(ord_qty)/(Float.parseFloat(strength_per_pres_uom) * Float.parseFloat(content_in_pres_base_uom)))+"";
					//DecimalFormat dfTest = new DecimalFormat("##.####");
					//ord_qty = Double.parseDouble(ord_qty)+"";
					//ord_qty = dfTest.format(Double.parseDouble(ord_qty));
					ord_qty		=	Math.ceil(Float.parseFloat(ord_qty))+"";
				}
				else {

					float unit_qty = 1.0f;
					// if block and else condition added for SRR20056-SCF-7514	27576
					float unit_dose_qty =(Float.parseFloat(strength_per_value_per_pres_uom) /Float.parseFloat(strength_per_pres_uom))*Float.parseFloat(qty_value);
					if(freq_nature.equals("O") || unit_dose_qty == Float.parseFloat(content_in_pres_base_uom) || (unit_dose_qty % Float.parseFloat(content_in_pres_base_uom)) == 0)
						unit_qty	=(float) Float.parseFloat(qty_value)/Float.parseFloat(strength_per_pres_uom);	
					else
						unit_qty	=(float) Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_per_pres_uom));
					
					tmp_qty			=   unit_qty * Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value)) * Integer.parseInt(repeat_value)+"";
					ord_qty			= ( Float.parseFloat(tmp_qty) *Float.parseFloat(strength_per_value_per_pres_uom))  /Float.parseFloat(content_in_pres_base_uom)+""; 
				}
				ord_qty=String.valueOf(Math.ceil(Float.parseFloat(String.valueOf(ord_qty))));
				/*if(freq_nature.equals("F")) {
					ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(ord_qty) / Integer.parseInt(interval_value)));
				}*/
			}
			if(ord_qty.equals("") || Float.parseFloat(ord_qty)==0) //if bloak added for KAUH-SCF-042
				ord_qty	=	"1";
		}
		catch(Exception e) {
			System.err.println("Error@@@ in PresBean getOrderQty >>>>>>>>>>> ext_drugData="+ext_drugData+" \n qty_value = "+qty_value+" >>> dup_repeat = "+dup_repeat+" >>> durn = "+durn+" >>> interval_value = "+interval_value+" >>> dosage = "+dosage+" >>> conv_factor = "+conv_factor+" >>> split_chk = "+split_chk);
			e.printStackTrace();
		}
		return ord_qty;
	}
public String getOrderQty(HashMap ext_drugData,String qty_value,String repeat_value,String durn_value,String dosage_type,String conv_factor){ //added for PMG2020-ICN-0001
		String fract_dose				=	(String)ext_drugData.get("FRACT_DOSE_ROUND_UP_YN");
		String content_in_pres_base_uom	=	(String)ext_drugData.get("CONTENT_IN_PRES_BASE_UOM");
		String strength_per_value_per_pres_uom	= (String)ext_drugData.get("STRENGTH_PER_VALUE_PRES_UOM");
		String strength_per_pres_uom			= (String)ext_drugData.get("STRENGTH_PER_PRES_UOM");
		String interval_value					= (String)ext_drugData.get("INTERVAL_VALUE");
		String freq_nature						= (String)ext_drugData.get("FREQ_NATURE");
		String ord_qty					=	"";
		String	tmp_qty					=	""; 
		try {
			if(dosage_type!=null && dosage_type.equals("A")){ 
				ord_qty	=	qty_value;
			}  
			else if(dosage_type!=null && dosage_type.equals("Q")){
				if(fract_dose != null && !fract_dose.equals("Y"))	{
					ord_qty		=  (Float.parseFloat(qty_value)*Float.parseFloat(durn_value)*Float.parseFloat(repeat_value)* Float.parseFloat(conv_factor))+"";
					ord_qty		=	Math.ceil(Float.parseFloat(ord_qty)/(Float.parseFloat(content_in_pres_base_uom)))+"";
					if(ord_qty.equals("0")){
						ord_qty	=	"1";
					}
				} 
				else{
					if( (Float.parseFloat(qty_value)*Float.parseFloat(conv_factor)) < Float.parseFloat(content_in_pres_base_uom))
						tmp_qty	=	1+"";
					else
						tmp_qty	=  Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(conv_factor))/Float.parseFloat(content_in_pres_base_uom))+"";
					ord_qty	=  (Float.parseFloat(tmp_qty) *Float.parseFloat(durn_value)*Float.parseFloat(repeat_value))+"";
				}
				ord_qty	=	String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				if(freq_nature != null && freq_nature.equals("F")){
					ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(ord_qty) / Integer.parseInt(interval_value)));
				}
			} 
			else if(dosage_type!=null && dosage_type.equals("S")){
				if(fract_dose != null && !fract_dose.equals("Y"))	{	
					ord_qty		=((Float.parseFloat(qty_value)*Float.parseFloat(durn_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))/(Float.parseFloat(strength_per_pres_uom)))+"";
					ord_qty		=	String.valueOf(Math.ceil(new Double(Float.parseFloat(ord_qty)/Float.parseFloat(content_in_pres_base_uom)).doubleValue()));
				}
				else{
					double unit_qty	= Math.ceil(Double.parseDouble(qty_value)/Double.parseDouble(strength_per_pres_uom)) * (Double.parseDouble(strength_per_value_per_pres_uom));
					tmp_qty			=  (Math.ceil(unit_qty /Float.parseFloat(content_in_pres_base_uom))+"");
					ord_qty			=  (Float.parseFloat(tmp_qty) * Float.parseFloat(durn_value)*Float.parseFloat(repeat_value))+"";					
				}
				ord_qty=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				if(freq_nature != null && freq_nature.equals("F")){
					ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(ord_qty) / Integer.parseInt(interval_value)));
				}
			}
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return ord_qty;
	}

	public float getTotalTaperQty(String drug_code,String srlNo, String callingMode,float taper_qty_value,float taper_repeat,float taper_durn, float taper_interval_value) {
		String fract_dose="", dosage_type="", freq_nature="", extdrugCode="",extSrlNo="",   qty_desc="", pres_base_uom="";//tapered_yn="", tapered_over="", Removed for IN063877
		ArrayList	ext_schedule=null;
		ArrayList dose_list=null;
		float content_in_pres_base_uom	=0;
		float strength_per_value_per_pres_uom	=0;
		float strength_per_pres_uom	=0;
		float totalTaperQty	=0;
		float unit_qty	 =	1;
		float taper_qty	 =	0;
		float qty_value	 =	1;
		float repeat_value	 =	1;
		float interval_value	 =	1;
		float durn_value	 =	1;
		float conv_factor	 =	1;
		boolean ext_split_chk;
		float tap_lvl_qty	 =	0;
		float tot_tap_lvl_qty	 =	0;
		ArrayList	presDetails	 = (ArrayList) getpresDetails();
		HashMap drugDetails =null;
		String freq_code ="";
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;

		boolean drugCharFound = false;
		try{
			if(presDetails!=null && presDetails.size()>0){
				connection = getConnection() ;
				pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT_REPEAT_VALUE")) ;
				for(int i=0;i<presDetails.size();i++){
					drugDetails		= (HashMap)presDetails.get(i);
					extdrugCode		= (String)drugDetails.get("DRUG_CODE");
					extSrlNo			= (String)drugDetails.get("SRL_NO");
					if(extdrugCode.equals(drug_code)){
						if((srlNo.equals(extSrlNo) && !callingMode.equals("TAP_LVL_CHANGE"))|| drugDetails.get("TAP_LVL_QTY")==null || ((String)drugDetails.get("TAP_LVL_QTY")).equals("")){
							if(!drugCharFound){
								fract_dose	= (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
								dosage_type	= (String)drugDetails.get("DOSAGE_TYPE");
								content_in_pres_base_uom	= Float.parseFloat(drugDetails.get("CONTENT_IN_PRES_BASE_UOM")==null?"1":(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM"));
								strength_per_value_per_pres_uom	= Float.parseFloat(drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"1":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM"));
								strength_per_pres_uom	=Float.parseFloat(drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"1":(String)drugDetails.get("STRENGTH_PER_PRES_UOM"));
								qty_desc			= (String)drugDetails.get("QTY_DESC_CODE")==null?"":(String)drugDetails.get("QTY_DESC_CODE"); 
								pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM")==null?"":(String)drugDetails.get("PRES_BASE_UOM");
								if(dosage_type.equals("Q"))
									conv_factor = Float.parseFloat(getConvFactor(qty_desc,pres_base_uom));

								if(strength_per_pres_uom == 0)
									strength_per_pres_uom = 1;
								if(strength_per_value_per_pres_uom == 0)
									strength_per_value_per_pres_uom = 1;
								drugCharFound=true;
							}
							//if(!tap_lvl_qty_found){
							//tapered_yn		= (String)ext_drugData.get("DRUG_TAPERED_YN")==null?"":(String)ext_drugData.get("DRUG_TAPERED_YN");
							//tapered_over	= (String)ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER"); 
							ext_schedule	=	(ArrayList)getScheduleFrequencyStr(extdrugCode+extSrlNo,"0");
							ext_split_chk	=	checkSplit(ext_schedule);
							if(ext_schedule != null && ext_schedule.size()>0)
								dose_list	= (ArrayList)ext_schedule.get(4);						
							else
								dose_list = null;
							repeat_value = Float.parseFloat(drugDetails.get("REPEAT_VALUE")==null?"1":(String)drugDetails.get("REPEAT_VALUE"));
							freq_code =(String)drugDetails.get("FREQ_CODE");
							freq_nature	= (String)drugDetails.get("FREQ_NATURE"); 
							interval_value	= Float.parseFloat((drugDetails.get("INTERVAL_VALUE")==null || ((String)drugDetails.get("INTERVAL_VALUE")).equals(""))?"1": (String)drugDetails.get("INTERVAL_VALUE"));
							qty_value	= Float.parseFloat((drugDetails.get("QTY_VALUE")==null || ((String)drugDetails.get("QTY_VALUE")).equals(""))?"1": (String)drugDetails.get("QTY_VALUE"));
							durn_value	= Float.parseFloat((drugDetails.get("DURN_VALUE")==null || ((String)drugDetails.get("DURN_VALUE")).equals(""))?"1": (String)drugDetails.get("DURN_VALUE"));

							String repeat_durn_type = (String) drugDetails.get("DURN_TYPE")==null?"D":(String) drugDetails.get("DURN_TYPE");
							String durn_desc_code = (String) drugDetails.get("DURN_DESC")==null?"D":(String) drugDetails.get("DURN_DESC");
							durn_value =	Float.parseFloat(getFreqDurnConvValue(repeat_durn_type,(int)durn_value+"",durn_desc_code));

							if(repeat_value==0 ){
								pstmt.setString(1,freq_code);

								resultSet = pstmt.executeQuery();
								if(resultSet !=null && resultSet.next()){
									repeat_value=resultSet.getFloat("repeat_value");
								}
								closeResultSet( resultSet ) ;
							}
							if(interval_value==0)
								interval_value=1;
							 if(repeat_value==0)
								   repeat_value=1;
							 if(durn_value==0 )
								   durn_value=1;
							if(ext_split_chk && dose_list!=null){
								repeat_value =	1;
								float temp_qty_value = 0;
								for(int m = 0;m<dose_list.size();m++){
									temp_qty_value+= Float.parseFloat((String)dose_list.get(m));
								}
								qty_value = temp_qty_value;
							}
							else if(dose_list!=null){
								 qty_value	=	Float.parseFloat(dose_list.get(0)==null?"1":(String)dose_list.get(0));
							}
							unit_qty	 =	1;
							taper_qty	 =	0;  //Modified for RUT-CRF-0088 [IN036978]
							//if((srlNo.equals(extSrlNo) && !callingMode.equals("TAP_LVL_CHANGE"))|| drugDetails.get("TAP_LVL_QTY")==null || ((String)drugDetails.get("TAP_LVL_QTY")).equals("")){
							if(callingMode!=null &&  callingMode.equals("ONCHANGE")){
								qty_value	 =	taper_qty_value;  
								repeat_value	 =	taper_repeat;
								interval_value	=taper_interval_value;
								durn_value= taper_durn;
							}
							else if(callingMode.equals("ONTAPER") || callingMode.equals("PREVTOTQTY")){  //Commented for RUT-CRF-0088 [IN036978]
								continue;
							}

							if(dosage_type!=null && dosage_type.equals("A")){
								/*taper_qty	=	Float.parseFloat((String)drugDetails.get("TOTTAPPERQTY")==null?"0":(String)drugDetails.get("TOTTAPPERQTY"));;   //Commented for RUT-CRF-0088 [IN036978]
								if(taper_qty == 0)
									totalTaperQty = Float.parseFloat((String)drugDetails.get("ABSOL_QTY")==null?"1":(String)drugDetails.get("ABSOL_QTY"));
								else //if condition & else block added for RUT-SCF-0213 [IN:037365]
									totalTaperQty = Float.parseFloat((String)drugDetails.get("TOTTAPPERQTY")==null?"1":(String)drugDetails.get("TOTTAPPERQTY")); //added for RUT-SCF-0155 [IN:033595]*/
								taper_qty = Float.parseFloat((String)drugDetails.get("ABSOL_QTY")==null?"1":(String)drugDetails.get("ABSOL_QTY"));  //Added for RUT-CRF-0088 [IN036978]
							} 
							else if(dosage_type!=null && dosage_type.equals("Q")){
								if(fract_dose.equals("N")) {
									taper_qty		= (float) (qty_value*Math.ceil(durn_value/interval_value)*repeat_value* conv_factor);
									DecimalFormat dfTest = new DecimalFormat("##.####");
									taper_qty = Float.parseFloat(dfTest.format(taper_qty));
								} 
								else {
									qty_value		=  (float) (Math.ceil(qty_value/content_in_pres_base_uom))*content_in_pres_base_uom; 
									if( (qty_value*conv_factor) <content_in_pres_base_uom){
										taper_qty	=	1;
									}
									else {
										taper_qty	= (float) Math.ceil((qty_value*conv_factor)/content_in_pres_base_uom);
									}

									 taper_qty	= (float) (taper_qty *Math.ceil(durn_value/interval_value)*repeat_value);
									 if( (qty_value*conv_factor) < content_in_pres_base_uom)	
										 taper_qty	=  (float) Math.ceil(taper_qty) /content_in_pres_base_uom; 
								}
								//totalTaperQty+=taper_qty;   //Commented for RUT-CRF-0088 [IN036978] //moved inside if block for RUT-SCF-0155 [IN:033595]
							} 
							else if(dosage_type!=null && dosage_type.equals("S")){
								if(fract_dose.equals("N")) {	
									taper_qty		= (float) (qty_value*Math.ceil(durn_value/interval_value)*repeat_value*strength_per_value_per_pres_uom);
								}
								else {
									float unit_dose_qty =(strength_per_value_per_pres_uom /strength_per_pres_uom)*qty_value;
									if(freq_nature.equals("O") || unit_dose_qty == content_in_pres_base_uom || (unit_dose_qty % content_in_pres_base_uom) == 0)
										unit_qty	=qty_value/strength_per_pres_uom;	
									else
										unit_qty	=(float) Math.ceil(qty_value/strength_per_pres_uom);	
									taper_qty	= (float) (unit_qty *Math.ceil(durn_value/interval_value) * repeat_value);
								}
								//totalTaperQty+=taper_qty; //Commented for RUT-CRF-0088 [IN036978] //moved inside if block for RUT-SCF-0155 [IN:033595]
							} 
							totalTaperQty+=taper_qty; //Commented for RUT-CRF-0088 [IN036978] //moved inside if block for RUT-SCF-0155 [IN:033595]
						}
						else{
							tap_lvl_qty = Float.parseFloat((String)drugDetails.get("TAP_LVL_QTY"));
							tot_tap_lvl_qty+=tap_lvl_qty; //Commented for RUT-CRF-0088 [IN036978] //moved inside if block for RUT-SCF-0155 [IN:033595]
						}
					}//if tapered drug code check
				} //for presDetails
				if(fract_dose.equals("N") && totalTaperQty>0) {
					if(dosage_type!=null && dosage_type.equals("Q")){
						totalTaperQty		=	totalTaperQty/content_in_pres_base_uom;   //Commented for RUT-CRF-0088 [IN036978]
					}
					else if(dosage_type!=null && dosage_type.equals("S")){
						totalTaperQty	=	(float)((totalTaperQty/strength_per_pres_uom)*content_in_pres_base_uom); //Commented for RUT-CRF-0088 [IN036978]
					}
				}
				totalTaperQty+=tot_tap_lvl_qty;
				if(totalTaperQty==0) //Commented for RUT-CRF-0088 [IN036978]
					totalTaperQty=1;
			} //if presDetails.size()>0
			totalTaperQty		=	(float) Math.ceil(totalTaperQty);  //Commented for RUT-CRF-0088 [IN036978]
		}
		catch(Exception e) {
			System.err.println("Error@@@ in PresBean getTotalTaperQty >>>>>>>>>>> presDetails="+presDetails+" \n qty_value = "+taper_qty_value+" >>> dup_repeat = "+taper_repeat+" >>> durn = "+taper_durn+" >>> interval_value = "+taper_interval_value+" >>> conv_factor = "+conv_factor);
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return totalTaperQty;
		//taper_qty		=	(float) Math.ceil(taper_qty);  //added for RUT-CRF-0088 [IN036978]
			//taperQty.put("TAP_LVL_QTY",taper_qty);  //added for RUT-CRF-0088 [IN036978]

		//return taper_qty; //added for RUT-CRF-0088 [IN036978]
	}

	public void setBillingDetail(HashMap drugDetails,String dosage_type, String qty_value, String qty_desc_code, String repeat_value, String durn_value, String interval_value, String patient_id, String encounter_id, String episode_type, String order_Date, String override_excl_incl_ind, String overriden_action_reason,String called_from, String take_home_medication){
		String drug_code = (String)drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
		String item_code = (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");
		String srlNo	 = (String)drugDetails.get("SRL_NO")==null?"":(String)drugDetails.get("SRL_NO");
		String pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM")==null?"":(String)drugDetails.get("PRES_BASE_UOM");
		String stock_uom = (String)drugDetails.get("STOCK_UOM")==null?"":(String)drugDetails.get("STOCK_UOM"); //ML-BRU-SCF-1798
		String disp_locn_code = (String)drugDetails.get("DISP_LOCN_CODE")==null?"":(String)drugDetails.get("DISP_LOCN_CODE");//ML-BRU-SCF-1798 
		//String content_in_pres_base_uom			= (String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM")==null?"1":(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM"); //Commented for Check Style Report
		String sch_size		= "";
		String conv_factor	= "";
		String episode_id = "";
		String visit_id = "";
		String total_charge_amt ="";
		String gross_charge_amt ="";// ADDED FOR ML-BRU-CRF-0469
	
		String patient_payable_amt = "";
		String approval_reqd_yn = "";
		String override_allowed_yn = "";
		String error_code ="";		 
		String sys_message_id ="";	
		String error_text = "";		
		String start_date  =(String)drugDetails.get("START_DATE")==null?"":(String)drugDetails.get("START_DATE");//Added for MMS-DM-CRF-0126.1
		String end_date    =(String)drugDetails.get("END_DATE")==null?"":(String)drugDetails.get("END_DATE");//Added for MMS-DM-CRF-0126.1
		String durn_value_in_days = "";//Added for MMS-DM-CRF-0126.1
		ArrayList	schedule	=	(ArrayList)getScheduleFrequencyStr(drug_code+srlNo,"0");

		Connection connection       = null ;
		CallableStatement cstmt = null ;
		PreparedStatement pstmt = null;
		ResultSet rsDecimalPlace= null;
		//int decimal_place = 0;
		ArrayList dose_list = null;
		//String decimalFormatString = "#0";  Removed for IN063877
		String ordered_qty ="";
		String base_uom = "";//ML-BRU-SCF-1798
		float base_to_disp_uom_equl = 0f;//ML-BRU-SCF-1798
		order_Date = order_Date+":00";
		if(episode_type !=null && episode_type.equals("X"))
			episode_type = "R";
		boolean split_chk	=	checkSplit(schedule);
		if(schedule.size() > 0) {
			dose_list	=	(ArrayList)schedule.get(4);
			if(!dosage_type.equals("A") && !(split_chk) && dose_list.size() > 0 && !called_from.equals("TAPER_QTY"))
				qty_value		=	(String)dose_list.get(0);
			sch_size		=	""+dose_list.size();
		}
		else {
			sch_size		=	repeat_value;
		}
		sch_size		=	repeat_value;
		if(dosage_type.equals("Q"))
			conv_factor = (String) getConvFactor(qty_desc_code,pres_base_uom);

		if(!called_from.equals("TAPER_QTY"))
			ordered_qty = getOrderQty(drugDetails,qty_value,sch_size,durn_value,interval_value, dosage_type,conv_factor,split_chk);
		else 
			ordered_qty = qty_value;
		//ML-BRU-SCF-1798 - start
		if(disp_locn_code!=null)
		 base_uom = getStoreDfltBaseUOM(disp_locn_code,item_code);

		if(base_uom==null)
			base_uom = "";
			//System.err.println("PrescriptionBean_1.java==base_uom=>"+base_uom+"stock_uom====>"+stock_uom);
		if(!base_uom.equals("")&& !base_uom.equals(stock_uom)){
		base_to_disp_uom_equl    =	getEqulValue( item_code, base_uom, stock_uom);
			
			ordered_qty = (Float.parseFloat(ordered_qty) * base_to_disp_uom_equl)+"";

			//System.err.println("PrescriptionBean_1.java==base_uom==3889=>"+base_uom+"stock_uom====>"+stock_uom+"==conv_factor==>"+conv_factor+"==base_to_disp_uom_equl==>"+base_to_disp_uom_equl+"==ordered_qty===>"+ordered_qty);
		}
//ML-BRU-SCF-1798 - end
	/*	if(!dosage_type.equals("A"))//Added for ML-BRU-SCF-1549 [IN:053429]
			ordered_qty = (Float.parseFloat(ordered_qty) * Float.parseFloat(content_in_pres_base_uom))+"";*///commended for BSP-SCF-0012 charging amount is displying incorect[IN005717]
//System.err.println("================Billing parameter======qty_value="+qty_value+" conv_factor="+conv_factor+" ordered_qty"+ordered_qty+"==content_in_pres_base_uom==>"+content_in_pres_base_uom);
		try{
			connection = getConnection() ;
			if(encounter_id!= null && !encounter_id.equals("")){
				episode_id = encounter_id;
				if(episode_type.equals("O")||episode_type.equals("E")){
					episode_id = encounter_id.substring(0,(encounter_id.length()-4));
					visit_id = encounter_id.substring(encounter_id.length()-4);
				}
			}
            String facility_id =   login_facility_id;
			if(drugDetails.containsKey("ORDERING_FACILITY_ID")){
                facility_id  =(String)drugDetails.get("ORDERING_FACILITY_ID");
			}
//System.err.println("================Billing parameter======facility_id="+facility_id+" episode_type="+episode_type+" patient_id"+patient_id+" episode_id="+episode_id+" order_Date="+order_Date+" ordered_qty="+ordered_qty+"override_excl_incl_ind="+override_excl_incl_ind+" overriden_action_reason="+overriden_action_reason+" take_home_medication="+take_home_medication+" item_code="+item_code);
			cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?,?,to_date(?,'dd/MM/yyyy hh24:mi:ss'),to_date(?,'dd/MM/yyyy hh24:mi:ss'),?)}");//added 3 new parameters for MMS-DM-CRF-126.1

			cstmt.setString( 1,facility_id );
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
			cstmt.setString( 54,override_excl_incl_ind );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
			cstmt.setString( 55, overriden_action_reason);  //p_overridden_action_reason	 --- Pass null or any value entered 
			cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
			cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
			cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text
            cstmt.setString(59, take_home_medication ); //take_home_medication
			cstmt.setString(60, start_date); //Added for MMS-DM-CRF-0126.1
			cstmt.setString(61, end_date ); //Added for MMS-DM-CRF-0126.1
			cstmt.setString(62, durn_value_in_days ); //Added for MMS-DM-CRF-0126.1
			cstmt.execute() ;
			total_charge_amt		= cstmt.getString(36);
			gross_charge_amt		= cstmt.getString(34);//p_gross_charge_amt// ADDED FOR ML-BRU-CRF-0469
			patient_payable_amt		= cstmt.getString(40);
			override_excl_incl_ind	= cstmt.getString(51)==null?"E":cstmt.getString(51);             
			approval_reqd_yn		= cstmt.getString(52)==null?"":cstmt.getString(52);   
			override_allowed_yn		= cstmt.getString(53)==null?"":cstmt.getString(53); 
			error_code				= cstmt.getString(56);
			sys_message_id			= cstmt.getString(57);
			error_text				= cstmt.getString(58);
			closeStatement( cstmt ) ;
//System.err.println("================Billing details======total_charge_amt="+total_charge_amt+" patient_payable_amt="+patient_payable_amt+" override_excl_incl_ind"+override_excl_incl_ind+" approval_reqd_yn="+approval_reqd_yn+" override_allowed_yn="+override_allowed_yn+" error_code="+error_code+" sys_message_id="+sys_message_id+" error_text="+error_text);
//commented during PE By Naveen 
			if(patient_payable_amt!=null && !patient_payable_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(this.bl_decimalFormatString);
				patient_payable_amt = dfTest.format(Double.parseDouble(patient_payable_amt));
			}
			if(total_charge_amt!=null && !total_charge_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(this.bl_decimalFormatString);
				total_charge_amt = dfTest.format(Double.parseDouble(total_charge_amt));
			}
			if(gross_charge_amt!=null && !gross_charge_amt.equals("")){// ADDED FOR ML-BRU-CRF-0469
				DecimalFormat dfTest = new DecimalFormat(this.bl_decimalFormatString);
				gross_charge_amt = dfTest.format(Double.parseDouble(gross_charge_amt));
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}

		drugDetails.put("BL_GROSS_CHARGE_AMT",gross_charge_amt);// ADDED FOR ML-BRU-CRF-0469
		drugDetails.put("BL_TOTAL_CHARGE_AMT",total_charge_amt);
		drugDetails.put("BL_PATIENT_PAYABLE_AMT",patient_payable_amt);
		if(!drugDetails.containsKey("BL_DEF_OVERRIDE_EXCL_INCL_IND")){
		      drugDetails.put("BL_DEF_OVERRIDE_EXCL_INCL_IND",override_excl_incl_ind);
		}
		//drugDetails.put("BL_OVERRIDE_EXCL_INCL_IND",override_excl_incl_ind); //priya
		drugDetails.put("BL_APPROVAL_REQD_YN",approval_reqd_yn);
        if(!drugDetails.containsKey("BL_OVERRIDE_ALLOWED_YN")){
		      drugDetails.put("BL_OVERRIDE_ALLOWED_YN",override_allowed_yn);
		}
		drugDetails.put("BL_ERROR_CODE",error_code);
		drugDetails.put("BL_SYS_MESSAGE_ID",sys_message_id);
		drugDetails.put("BL_ERROR_TEXT",error_text);
		//drugDetails.put("BL_DECIMAL_FORMAT_STRING",decimalFormatString);
		drugDetails.put("BL_DECIMAL_FORMAT_STRING",this.bl_decimalFormatString);
		return;
	}

	public HashMap getBillingDetailforPrev( String item_code,  String ordered_qty, String patient_id, String encounter_id, String episode_type, String order_Date, String take_home_medication, String override_excl_incl_ind, String overriden_action_reason,String facility_id){
		String episode_id = "";
		String visit_id = "";
		String total_charge_amt ="";
		String gross_charge_amt ="";// ADDED FOR ML-BRU-CRF-0469
		String patient_payable_amt = "";
		String approval_reqd_yn = "";
		String override_allowed_yn = "";
		String error_code ="";		 
		String sys_message_id ="";	
		String error_text = "";	
		HashMap hmChargeDtl = new HashMap();
		Connection connection       = null ;
		CallableStatement cstmt = null ;
		PreparedStatement pstmt = null;
		ResultSet rsDecimalPlace= null;
		//int decimal_place = 0;
	//	ArrayList dose_list = null;  Removed for IN063877
	//	String decimalFormatString = "#0";  Removed for IN063877
		order_Date = order_Date+":00";
		if(episode_type !=null && episode_type.equals("X"))
			episode_type = "R";
		try{
			connection = getConnection() ;
			if(encounter_id!= null && !encounter_id.equals("")){
				episode_id = encounter_id;
				if(episode_type.equals("O")||episode_type.equals("E")){
					episode_id = encounter_id.substring(0,(encounter_id.length()-4));
					visit_id = encounter_id.substring(encounter_id.length()-4);
				}
			}
//System.err.println("=========Preview=======Billing parameter======facility_id="+facility_id+" episode_type="+episode_type+" patient_id"+patient_id+" episode_id="+episode_id+" order_Date="+order_Date+" ordered_qty="+ordered_qty+"override_excl_incl_ind="+override_excl_incl_ind+" overriden_action_reason="+overriden_action_reason+" take_home_medication="+take_home_medication+" item_code="+item_code);
			cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?,?)}");
			cstmt.setString( 1,facility_id );
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
			cstmt.setString( 54,override_excl_incl_ind );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
			cstmt.setString( 55, overriden_action_reason);  //p_overridden_action_reason		 --- Pass null or any value entered 
			cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
			cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
			cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text
            cstmt.setString(59, take_home_medication ); //take_home_medication
			cstmt.execute() ;
			total_charge_amt		= cstmt.getString(36);
			gross_charge_amt		= cstmt.getString(34);// ADDED FOR ML-BRU-CRF-0469
			patient_payable_amt		= cstmt.getString(40);
			override_excl_incl_ind	= cstmt.getString(51)==null?"E":cstmt.getString(51);             
			approval_reqd_yn		= cstmt.getString(52)==null?"":cstmt.getString(52);   
			override_allowed_yn		= cstmt.getString(53)==null?"":cstmt.getString(53); 
			error_code				= cstmt.getString(56);
			sys_message_id			= cstmt.getString(57);
			error_text				= cstmt.getString(58);
			closeStatement( cstmt ) ;
//System.err.println("=======Preview=========Billing details======total_charge_amt="+total_charge_amt+" patient_payable_amt="+patient_payable_amt+" override_excl_incl_ind"+override_excl_incl_ind+" approval_reqd_yn="+approval_reqd_yn+" override_allowed_yn="+override_allowed_yn+" error_code="+error_code+" sys_message_id="+sys_message_id+" error_text="+error_text);
			if(patient_payable_amt!=null && !patient_payable_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(this.bl_decimalFormatString);
				patient_payable_amt = dfTest.format(Double.parseDouble(patient_payable_amt));
			}
			if(total_charge_amt!=null && !total_charge_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(this.bl_decimalFormatString);
				total_charge_amt = dfTest.format(Double.parseDouble(total_charge_amt));
			}
			if(gross_charge_amt!=null && !gross_charge_amt.equals("")){// ADDED FOR ML-BRU-CRF-0469
				DecimalFormat dfTest = new DecimalFormat(this.bl_decimalFormatString);
				gross_charge_amt = dfTest.format(Double.parseDouble(gross_charge_amt));
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		hmChargeDtl.put("BL_GROSS_CHARGE_AMT",gross_charge_amt);// ADDED FOR ML-BRU-CRF-0469
		hmChargeDtl.put("BL_TOTAL_CHARGE_AMT",total_charge_amt);
		hmChargeDtl.put("BL_PATIENT_PAYABLE_AMT",patient_payable_amt);
		return hmChargeDtl;
	}


	public ArrayList sortList() {//soriting the arraylist as per drug and srl_no
		if(presDetails!=null && presDetails.size()>0){
			groupCode.clear();
			HashMap drugData=new HashMap();
			for(int i=0; i<presDetails.size() ; i++){
				drugData=(HashMap) presDetails.get(i);
				String drugCode=(String) drugData.get("DRUG_CODE");
				if(!groupCode.contains(drugCode))
					groupCode.add(drugCode);
			}
		}
		return groupCode;
	}

	public ArrayList ordsortList() {
		if(presDetails!=null && presDetails.size()>0){
			orderCode.clear();
			for(int i=0; i<presDetails.size() ; i++){
				HashMap drugData=new HashMap();
				drugData=(HashMap) presDetails.get(i);
				String order_type_code=(String) drugData.get("ORDER_TYPE_CODE");
					if(!orderCode.contains(order_type_code))
						orderCode.add(order_type_code);
			}
		}
		return orderCode;
	}

	public ArrayList getDisplayList(String groupCode) {//for display the ordered list
		ArrayList displayList=new ArrayList();
		if(presDetails!=null && presDetails.size()>0){
			for(int i=0; i<presDetails.size() ; i++){
				HashMap drugData=new HashMap();
				drugData=(HashMap) presDetails.get(i);
				String drugCode=(String) drugData.get("DRUG_CODE");
				if(groupCode.equals(drugCode)){
					displayList.add(drugData);
				}
			}
		}
		return displayList;
	}

	public ArrayList OrdersortList( ArrayList recordList, String key ) {
		String keyVal[] = new String[recordList.size()];
		for(int i=0; i<recordList.size() ; i++) {// Take all the keys values and put it in the array
			HashMap hashMap = (HashMap) recordList.get(i) ;
			String keydata = (String) hashMap.get(key) ;
			keyVal[i] = keydata ;
		}
		for(int i=0 ; i< keyVal.length-1 ; i++ ) {// sort the key value array
			for(int j=0 ; j< keyVal.length-i-1 ; j++) {
				if( keyVal[j].compareTo(keyVal[j+1]) > 0 ) {
					String temp = keyVal[j] ;
					keyVal[j] = keyVal[j+1] ;
					keyVal[j+1] = temp ;
				}
			}
		}
		
		ArrayList sortedList = new ArrayList();// create a sorted ArrayList by picking with the sorted index
		for(int i=0 ; i< keyVal.length ; i++ ) {
			sortedList.add( recordList.get(findPosition(recordList, key, keyVal[i])));
		}
		return sortedList ;
	}

	private int findPosition(ArrayList recordList, String key, String keyVal) {
		for(int i=0 ; i<recordList.size() ; i++ ) {
			HashMap dataMap = (HashMap) recordList.get(i) ;
			if( ((String)dataMap.get(key)).equals(keyVal) )
				return i;
		}
		return -1;
	}

	public ArrayList groupingOrder(String patient_class) {
		groupRecord=new ArrayList();
		String record_gen="";
		HashMap drugData = null;
		if(presDetails!=null && presDetails.size()>0){
			for(int i=0; i<presDetails.size() ; i++){
				drugData=new HashMap();
				drugData=(HashMap) presDetails.get(i);
				record_gen=(String) drugData.get("RECORD_GEN");
				if(!patient_class.equals("IP")){
					if(!groupRecord.contains(record_gen))
						groupRecord.add(record_gen);
				}
				else{
					groupRecord.add(record_gen);
				}
				//groupRecord.add(record_gen);
			}
		}
		return groupRecord;
	}

	public ArrayList genOrderID(int groupSize,String patient_class) {
		if(!patient_class.trim().equals("IP") && patient_class.trim().equals("EM")) {
			patient_class = "OP";
		}
		OrderID =new ArrayList();
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT37");
			pstmt				= connection.prepareStatement(sql_query) ;
			for(int i=0;i<groupSize;i++){
				pstmt.setString(1,"PH");
				pstmt.setString(2,patient_class);
				pstmt.setString(3, login_facility_id); //thrid parameter for facility added for IN[032925]
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					OrderID.add((String)resultSet.getString("order_id"));
				}
				closeResultSet( resultSet ) ;
			}
		}
		catch ( Exception e ) {
			OrderID.add(e);
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){}
		}
		return OrderID;
	}

	public void genOrderDetails() {
		orderDetails=new ArrayList();
		if(groupRecord!=null && groupRecord.size()>0) {
			ArrayList orderDetailsData=new ArrayList();
			for(int j=0; j<presDetails.size(); j++) {
				HashMap drugData=new HashMap();
				drugData=(HashMap) presDetails.get(j);
				if(existingGroup(orderDetails,drugData) || taperOrders(drugData)) {
					appendExistingGroup(orderDetails,drugData);
				}
				else {
					orderDetailsData=new ArrayList();
					orderDetailsData.add(drugData);
					orderDetails.add(orderDetailsData);
				}
			}
		}
	}

	private void appendExistingGroup(ArrayList orderDetails,HashMap drugData){
		String record_gen		=	(String)drugData.get("RECORD_GEN");
		String tmp_record_gen	=	"";
		OuterLoop: for(int i=0; i<orderDetails.size(); i++) {
		ArrayList orderDetailsData	=	(ArrayList)orderDetails.get(i);
			for(int j=0; j<orderDetailsData.size(); j++) {
				HashMap record	=	(HashMap)orderDetailsData.get(j);
				tmp_record_gen	=	(String)record.get("RECORD_GEN");
				if(tmp_record_gen.equals(record_gen)) {
					orderDetailsData.add(drugData);	
					break OuterLoop;
				}
			}
		}
	}

	public boolean refillOrders(ArrayList orderlist, HashMap data) {
		boolean refill_drug		=	false;
		HashMap refill_detail	=	getRefillDetail((String) data.get("SRL_NO"));
		if(refill_detail.size()!=0) {
			refill_drug		=	true;
		}
		return refill_drug;
	}

	public boolean existingGroup(ArrayList orderlist, HashMap data) {
		String record_gen		=	(String)data.get("RECORD_GEN");
		String tmp_record_gen	=	"";
		boolean existing		=	false;
		for(int i=0; i<orderlist.size(); i++) {
			ArrayList order_dtl	=	(ArrayList)orderlist.get(i);
			for(int j=0; j<order_dtl.size(); j++) {
				HashMap record	=	(HashMap)order_dtl.get(j);
				tmp_record_gen	=	(String)record.get("RECORD_GEN");
				if(tmp_record_gen.equals(record_gen)) {
					existing	=	true;
					break;
				}
			}
		}
		return existing;
	}

	public boolean taperOrders(HashMap data) {
		boolean taper_yn		=	false;
		String taper_dose		=	(String)data.get("TAPPERED_OVER");
		if(taper_dose!=null && taper_dose.equals("Y"))
			taper_yn		=	true;
		return taper_yn;
	}

	public String genOrderDetailsforIP() {
		String debug="";
		orderDetails=new ArrayList();
		if(groupRecord!=null && groupRecord.size()>0){
			for(int j=0; j<presDetails.size(); j++){
				HashMap drugData=new HashMap();
				drugData=(HashMap) presDetails.get(j);
				ArrayList orderDetailsData=new ArrayList();
				orderDetailsData.add(drugData);
				orderDetails.add(orderDetailsData);
			}
		}
		return debug;
	}

	public ArrayList getOrderDetails() {
		return orderDetails;
	}
	public ArrayList getOrderID() {
		return OrderID;
	}

	public HashMap getPatientDetails(String patient_id,String drug_code)	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String	patient_name	=	"";
		String	sex				=	"";
		String	age				=	"";
		String	age_in_mints				=	"";
		HashMap	 pat_details	=	new HashMap();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT43A") ) ;
			pstmt.setString(1,patient_id);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				patient_name	=	resultSet.getString("PATIENT_NAME");
				sex				=	resultSet.getString("SEX");
				age				=	resultSet.getString("AGE");
				age_in_mints				=	resultSet.getString("AGE_IN_MINTS");
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			pat_details.put("patient_name",patient_name);
			pat_details.put("sex",sex);
			pat_details.put("age",age);
			pat_details.put("age_in_mints",age_in_mints);
			age_in_mints	=	age_in_mints.trim();
			sex	=	sex.substring(0,1);
			pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80A") ) ;
			pstmt.setString(1,sex);
			pstmt.setString(2,age_in_mints);
			pstmt.setString(3,drug_code);
			resultSet	= pstmt.executeQuery();
			
			while(resultSet!=null && resultSet.next() ) {
				age_group	=	resultSet.getString("AGE_GROUP_CODE");
			}
			setAgeGroup(age_group);
			pat_details.put("age_group",age_group);//Added for IN:070451
		}
		catch(Exception e){
			pat_details.put("error",e.toString());
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
		return pat_details;
	}

	public HashMap getPatientDetails_1(String patient_id)	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		HashMap	 pat_details	=	new HashMap();
		String localee			= getLanguageId()==null?"en":getLanguageId();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT43") ) ;
			pstmt.setString(1,localee);
			pstmt.setString(2,patient_id);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				pat_details.put("patient_name",resultSet.getString("PATIENT_NAME"));
				pat_details.put("sex",resultSet.getString("SEX"));
				pat_details.put("age",resultSet.getString("AGE"));
				pat_details.put("date_of_birth",resultSet.getString("DATE_OF_BIRTH"));
			}
		}
		catch(Exception e){
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

	public ArrayList getDuplicateDrugs(String patient_id,String generic_id)	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sql_str			=	"";
		String	start_date		=	"";
		String	end_date		=	"";
		String dosage				=	"";
		ArrayList dupDrugs	= new ArrayList();
		HashMap	record			= null;
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection			= getConnection() ;

			sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT59A");//  AND A.FACILITY_ID  = H.FACILITY_ID(+) AND A.ENCOUNTER_ID = H.ENCOUNTER_ID(+) - outer join added,  AND  D.FACILITY_ID = H.FACILITY_ID removed forMO-GN-5400 IN[030118]
			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,generic_id);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);

			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				record	=	new HashMap();
				start_date			=	resultSet.getString("START_DATE");
				end_date			=	resultSet.getString("END_DATE");
				dosage				=	resultSet.getString("DOSAGE")==null?"":resultSet.getString("DOSAGE");
				if(dosage.equals(""))
				   dosage="0";
				// the below code is to convert .x to 0.x
				if(Float.parseFloat(dosage) < 1)
					dosage = Float.parseFloat(dosage)+"";
				dosage=dosage.equals("0.0")?"":dosage;
				if(!locale.equals("en")){
					start_date = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM","en",locale);
					end_date = com.ehis.util.DateUtils.convertDate(end_date, "DMYHM","en",locale);
				}

				record.put("start_date",start_date);
				record.put("end_date",end_date);
				record.put("drug_desc",checkForNull(resultSet.getString("DRUG_DESC")));
				record.put("strength",checkForNull(resultSet.getString("STRENGTH")));
				record.put("strength_uom_desc",checkForNull(resultSet.getString("STRENGTH_UOM")));
				record.put("form_desc",checkForNull(resultSet.getString("FORM_CODE")));
				record.put("practitioner_name",checkForNull(resultSet.getString("PRACTITIONER_NAME")));
				record.put("location",checkForNull(resultSet.getString("LOCATION")));
				record.put("facility_name",checkForNull(resultSet.getString("FACILITY_NAME")));
				record.put("diag_text",checkForNull(resultSet.getString("DIAG_TEXT")));
				record.put("split_dose_prev",checkForNull(resultSet.getString("SPLIT_DOSE_PREVIEW")));
				record.put("order_id",checkForNull(resultSet.getString("ORIG_ORDER_ID")));
				record.put("order_line_no",checkForNull(resultSet.getString("ORIG_ORDER_LINE_NO")));
				record.put("freq_code",checkForNull(resultSet.getString("FREQ_CODE")));
				record.put("freq_desc",checkForNull(resultSet.getString("FREQ_DESC")));
				record.put("allergy_reason",checkForNull(resultSet.getString("ALLERGY_OVERRIDE_REASON")));
				record.put("dosage_reason",checkForNull(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")));
				record.put("duplicate_reason",checkForNull(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")));
				record.put("dosage",dosage);
				record.put("dosage_uom_code",checkForNull(resultSet.getString("DOSAGE_UOM_CODE")));
				record.put("perf_locn",checkForNull(resultSet.getString("PERF_LOCN")));
				record.put("per_facility_name",checkForNull(resultSet.getString("PER_FACILITY_NAME")));
				record.put("iv_prep_yn",resultSet.getString("IV_PREP_YN"));
				record.put("sliding_scale_yn",resultSet.getString("sliding_scale_yn"));
			
			    dupDrugs.add(record);
			}
		}
		catch(Exception e){
			dupDrugs.add(e.toString());
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
		return dupDrugs;
	}

	public ArrayList getPatientActiveOrders(String patient_id,String patient_class,String order_date,int take_home, String call_from){//call_from Added for Bru-HIMS-CRF-072.1[IN 049144]
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		StringBuilder sql_str		=	new StringBuilder();
		String	start_date			=	"";
		String	end_date			=	"";
		String discont_date_time	=	"";
		String dosage				=	"";
		ArrayList activeOrders	= new ArrayList();
		HashMap	record			= null;
		locale= getLanguageId()==null?"en":getLanguageId();
		StringBuilder sb = new StringBuilder();		//Added for Bru-HIMS-CRF-072.1[IN 049144]
		
		try{
			connection			= getConnection() ;
			sql_str.append("SELECT  /*+ INDEX(a ph_patient_drug_profile_pk)*/ A.DISCONT_DATE_TIME, A.PATIENT_ID,  A.ALLERGY_OVERRIDE_REASON,  A.DOSAGE_LIMIT_OVERRIDE_REASON,  A.DUPLICATE_DRUG_OVERRIDE_REASON,  A.ORIG_ORDER_ID,  A.ORIG_ORDER_LINE_NO, A.DOSAGE, A.DOSAGE_UOM_CODE, A.SPLIT_DOSE_PREVIEW,  A.FREQ_CODE,  G.FREQ_DESC,  A.PRES_PRACTITIONER_ID,  B.PRACTITIONER_NAME,  H.DISCHARGE_IND,A.DRUG_CODE,  C.DRUG_DESC,  C.IN_FORMULARY_YN, A.STRENGTH,  C.STRENGTH_UOM,  C.FORM_CODE,  TO_CHAR(A.START_DATE,  'DD/MM/YYYY hh24:mi') START_DATE,  TO_CHAR(A.END_DATE,  'DD/MM/YYYY hh24:mi') END_DATE,  A.DOSAGE,  A.DOSAGE_UOM_CODE,  A.PRESCRIBED_QTY,  A.DIAG_TEXT,  D.FACILITY_NAME,  A.PATIENT_CLASS,  DECODE( A.PATIENT_CLASS,  'IP',  F.LONG_DESC,  'EA',  F.LONG_DESC,  decode(h.DISCHARGE_IND,'D',f.long_desc,e.long_desc) ) LOCATION,I.SHORT_DESC PERF_LOCN,H.IV_PREP_YN,J.FACILITY_NAME PER_FACILITY_NAME,a.split_yn,k.SLIDING_SCALE_YN,A.TOT_ISSUED_QTY,(select order_uom from or_order_line where order_id = a.orig_order_id and order_line_num=a.orig_order_line_no) order_uom,ph_get_alternates(A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) alternates FROM   PH_PATIENT_DRUG_PROFILE A ,  AM_PRACTITIONER_LANG_VW B  ,  SM_FACILITY_PARAM_LANG_VW D,  OP_CLINIC_LANG_VW E,  IP_NURSING_UNIT_LANG_VW F,  (SELECT drug_desc drug_desc, drug_code drug_code, in_formulary_yn in_formulary_yn, strength_uom strength_uom, form_code form_code   FROM ph_drug_lang_vw   WHERE language_id = ?   UNION  SELECT NVL (short_name, long_name) drug_desc,   tpn_regimen_code drug_code, 'Y' in_formulary_yn,    NULL strength_uom, NULL form_code   FROM ph_tpn_regimen_lang_vw    WHERE  language_id = ?) c,   AM_FREQUENCY_LANG_VW G, OR_ORDER H,  PH_DISP_LOCN_LANG_VW I,SM_FACILITY_PARAM_LANG_VW J, or_order_line_ph k WHERE   A.PATIENT_ID =? AND   A.PRES_PRACTITIONER_ID = B.PRACTITIONER_ID(+) AND   A.FACILITY_ID = D.FACILITY_ID  AND   A.FACILITY_ID = E.FACILITY_ID (+) AND  A.LOCN_CODE = E.CLINIC_CODE(+) AND   A.FACILITY_ID = F.FACILITY_ID (+) AND   A.LOCN_CODE = F.NURSING_UNIT_CODE(+) AND   A.DRUG_CODE = C.DRUG_CODE  AND   A.FREQ_CODE=G.FREQ_CODE AND    A.ORIG_ORDER_ID= H.ORDER_ID and a.orig_order_id =k.order_id and a.ORIG_ORDER_LINE_NO =k.ORDER_LINE_NUM AND I.DISP_LOCN_CODE = H.PERFORMING_DEPTLOC_CODE AND H.PERFORMING_FACILITY_ID =I.FACILITY_ID AND H.PERFORMING_FACILITY_ID =J.FACILITY_ID AND A.PATIENT_ID=H.PATIENT_ID AND to_date(A.END_DATE,'dd/mm/yyyy hh24:mi') >= to_date(SYSDATE,'dd/mm/yyyy hh24:mi') AND  TO_DATE(SYSDATE,'DD/MM/RRRR HH24:MI') BETWEEN  TO_DATE(A.START_DATE,'DD/MM/RRRR HH24:MI') AND  TO_DATE(A.END_DATE,'DD/MM/RRRR HH24:MI')   AND A.DISCONT_DATE_TIME IS NULL AND   A.ON_HOLD_DATE_TIME IS NULL AND   A.CANCEL_YN='N' AND   A.STOP_YN='N' AND H.ORDER_TYPE_CODE !='MS'  AND D.LANGUAGE_ID = G.LANGUAGE_ID AND D.LANGUAGE_ID = I.LANGUAGE_ID AND D.LANGUAGE_ID = ? AND E.LANGUAGE_ID(+) = ? AND F.LANGUAGE_ID(+) = ? AND B.LANGUAGE_ID(+) = ? AND J.LANGUAGE_ID(+) = ? ");
			if(call_from.equals("MediPlan")){
				sql_str.append(" AND H.IV_PREP_YN IS NULL ");
			}
			sql_str.append(" ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO ");
			if(order_date.equals(""))
				order_date	    =	getOrderDate();
			pstmt				= connection.prepareStatement(sql_str.toString()) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);
			pstmt.setString(7,locale);
			pstmt.setString(8,locale);

			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				record	=	new HashMap();
				start_date			=	resultSet.getString("START_DATE");
				end_date			=	resultSet.getString("END_DATE");
				dosage				=	resultSet.getString("DOSAGE");
				discont_date_time	=	resultSet.getString("DISCONT_DATE_TIME");
				if(dosage != null && dosage != "" && Float.parseFloat(dosage) < 1)
					dosage				= Float.parseFloat(dosage)+"";

				if(!locale.equals("en")){
					start_date			= com.ehis.util.DateUtils.convertDate(start_date, "DMYHM","en",locale);
					end_date			= com.ehis.util.DateUtils.convertDate(end_date, "DMYHM","en",locale);
					discont_date_time	= com.ehis.util.DateUtils.convertDate(discont_date_time, "DMYHM","en",locale);
				}
				record.put("start_date",start_date);
				record.put("end_date",end_date);
				record.put("drug_desc",resultSet.getString("DRUG_DESC"));
				record.put("strength",resultSet.getString("STRENGTH"));
				record.put("strength_uom_desc",resultSet.getString("STRENGTH_UOM"));
				record.put("form_desc",resultSet.getString("FORM_CODE"));
				record.put("practitioner_name",resultSet.getString("PRACTITIONER_NAME"));
				record.put("location",resultSet.getString("LOCATION"));
				record.put("facility_name",resultSet.getString("FACILITY_NAME"));
				record.put("diag_text",resultSet.getString("DIAG_TEXT"));
				record.put("split_dose_prev",resultSet.getString("SPLIT_DOSE_PREVIEW"));
				record.put("order_id",resultSet.getString("ORIG_ORDER_ID"));
				record.put("order_line_no",resultSet.getString("ORIG_ORDER_LINE_NO"));
				record.put("iv_prep_yn",resultSet.getString("IV_PREP_YN"));
				record.put("freq_code",resultSet.getString("FREQ_CODE"));
				record.put("freq_desc",resultSet.getString("FREQ_DESC"));
				record.put("allergy_reason",resultSet.getString("ALLERGY_OVERRIDE_REASON"));
				record.put("dosage_reason",resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
				record.put("duplicate_reason",resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
				record.put("discont_date_time",discont_date_time);
				record.put("perf_locn",resultSet.getString("PERF_LOCN"));
				record.put("discharge_ind",resultSet.getString("DISCHARGE_IND"));
				record.put("in_formulary_yn",resultSet.getString("IN_FORMULARY_YN"));
				record.put("dosage",dosage);
				record.put("dosage_uom_code",resultSet.getString("DOSAGE_UOM_CODE"));
				record.put("per_facility_name",resultSet.getString("PER_FACILITY_NAME"));
				record.put("split_yn",resultSet.getString("split_yn"));
				record.put("sliding_scale_yn",resultSet.getString("SLIDING_SCALE_YN"));
				record.put("drug_code",resultSet.getString("DRUG_CODE"));// Added for Bru-HIMS-CRF-072.1[IN 049144]
				record.put("issued_qty",resultSet.getString("TOT_ISSUED_QTY"));// Added for Bru-HIMS-CRF-072.1[IN 049144]
				record.put("order_uom",checkForNull(resultSet.getString("order_uom")));// Added for Bru-HIMS-CRF-072.1[IN 049144]
				record.put("alternates",checkForNull(resultSet.getString("alternates"),"N"));// Added for Bru-HIMS-CRF-072.1[IN 049144]
				
				if(call_from.equals("MediPlan")){						 //Added for Bru-HIMS-CRF-072.1[IN 049144]
					sb.append("'"+checkForNull(resultSet.getString("DRUG_CODE"))+"',");	
					medplan_bean.getDosageDetails(resultSet.getString("DRUG_CODE"), resultSet.getString("DRUG_CODE"), resultSet.getString("ORIG_ORDER_ID"), resultSet.getString("ORIG_ORDER_LINE_NO"));
				}
				activeOrders.add(record);
			}
			if(call_from.equals("MediPlan") && sb.length()>3)//Added for Bru-HIMS-CRF-072.1[IN 049144]
				medplan_bean.getPrescribeDrugDetails(sb);
			setActiveOrders(activeOrders);
		}
		catch(Exception e){
			e.printStackTrace() ;
			activeOrders.add(e.toString());
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
		return activeOrders;
	}
	
	public ArrayList getPatientActiveOrdersForOT(String patient_id,String patient_class,int take_home)	{// Method to get the active orders when it is called from the OT .
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String sql_str				=	"";
		String start_date			=	"";
		String end_date				=	"";
		String discont_date_time	=	"";
		String dosage				=	"";
		StringBuffer append_qry		=	new StringBuffer();
		ArrayList activeOrders	= new ArrayList();
		HashMap	record			= null;
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection			= getConnection() ;
			append_qry.append("AND ( A.DRUG_CODE IN ( SELECT DRUG FROM OT_DRUGS_FOR_NOTIFICATION WHERE NOTIFY_PRE_ANESTHESIA_YN = 'Y' AND DEFN_TYPE='D') OR A.GENERIC_ID IN ( SELECT DRUG FROM OT_DRUGS_FOR_NOTIFICATION WHERE NOTIFY_PRE_ANESTHESIA_YN = 'Y' AND DEFN_TYPE='G'))");

			if(patient_class.equals("IP") ||take_home>0) 
				append_qry.append(" ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
			else 
				append_qry.append(" AND NVL(A.TOT_ISSUED_QTY, 0)-NVL(A.RETURNED_QTY,0)!=0 ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");

			sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT51")+append_qry.toString();
			
			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);

			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				record	=	new HashMap();
				start_date			=	resultSet.getString("START_DATE");
				end_date			=	resultSet.getString("END_DATE");
				dosage				=	resultSet.getString("DOSAGE")==null?"":resultSet.getString("DOSAGE");
				if(!dosage.equals("") && Float.parseFloat(dosage) < 1)
					dosage = Float.parseFloat(dosage)+"";
				if(!locale.equals("en")){
					start_date = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM","en",locale);
					end_date = com.ehis.util.DateUtils.convertDate(end_date, "DMYHM","en",locale);
					discont_date_time = com.ehis.util.DateUtils.convertDate(discont_date_time, "DMYHM","en",locale);
				}

				record.put("start_date",start_date);
				record.put("end_date",end_date);
				record.put("drug_desc",resultSet.getString("DRUG_DESC"));
				record.put("strength",resultSet.getString("STRENGTH"));
				record.put("strength_uom_desc",resultSet.getString("STRENGTH_UOM"));
				record.put("form_desc",resultSet.getString("FORM_CODE"));
				record.put("practitioner_name",resultSet.getString("PRACTITIONER_NAME"));
				record.put("location",resultSet.getString("LOCATION"));
				record.put("facility_name",resultSet.getString("FACILITY_NAME"));
				record.put("diag_text",resultSet.getString("DIAG_TEXT"));
				record.put("split_dose_prev",resultSet.getString("SPLIT_DOSE_PREVIEW"));
				record.put("order_id",resultSet.getString("ORIG_ORDER_ID"));
				record.put("order_line_no",resultSet.getString("ORIG_ORDER_LINE_NO"));
				record.put("iv_prep_yn",resultSet.getString("IV_PREP_YN"));
				record.put("freq_code",resultSet.getString("FREQ_CODE"));
				record.put("freq_desc",resultSet.getString("FREQ_DESC"));
				record.put("allergy_reason",resultSet.getString("ALLERGY_OVERRIDE_REASON"));
				record.put("dosage_reason",resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
				record.put("duplicate_reason",resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
				record.put("discont_date_time",resultSet.getString("DISCONT_DATE_TIME"));
				record.put("perf_locn",resultSet.getString("PERF_LOCN"));
				record.put("discharge_ind",resultSet.getString("DISCHARGE_IND"));
				record.put("in_formulary_yn",resultSet.getString("IN_FORMULARY_YN")==null?"":resultSet.getString("IN_FORMULARY_YN"));
				record.put("dosage",dosage);
				record.put("dosage_uom_code",resultSet.getString("DOSAGE_UOM_CODE"));
				
				activeOrders.add(record);
			}
		}
		catch(Exception e){
			e.printStackTrace() ;
			activeOrders.add(e.toString());
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
		return activeOrders;
	}

	public void genDrugRemarks(ArrayList drugremarks)	{
		this.DrugRemarks	=	drugremarks;
	}

	public ArrayList getDrugRemarks(){
		return this.DrugRemarks;
	}

	public void setAll( Hashtable recordSet ) {
		if(recordSet.get("mode") != null){
             mode = (String)recordSet.get("mode") ;
		}
	}

	public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
        return map ;
	}

	public HashMap modify() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "U R INTO MODIFY METHOD" ) ;

		Connection connection			= null ;
		PreparedStatement pstmt_modify = null ;
		PreparedStatement pstmt_modify_1 = null ;//added for ML-MMOH-SCF-1776
		PreparedStatement pstmt_insert = null ;
		PreparedStatement pstmt		= null ;
		PreparedStatement pstmt_clob	= null ;
		ResultSet rset_clob			= null ;
		ResultSet resultSet			= null ;

		boolean modify_rec_1			= false;
		boolean modify_rec_2			= false;
		boolean modify_rec_3			= false;
		boolean modify_rec_4			= false;
		String sql_string				= "";
		String sql_string_1				= "";//added for ML-MMOH-SCF-1776
		String drug_code="";
		String sch_strength	=	"";
		String dosage_type = "";
		String absol_qty = "";
		String prn_doses_pres_prn_fil="";
		String fract_dose = "";
		String qty_value = "";
		String repeat_value = "";
		String strength_per_value_per_pres_uom="";
		String strength_per_pres_uom = "";
		String strength_value="";
		String strength_uom = "";
		String pres_base_uom="";
		String in_order_qty="";
		String in_order_qty_strength="";
		String in_order_qty_uom="";
		String freq_nature = "";
		String calc_dosg_by_freq_durn_yn="";
		String split_dose_yn = "";
		String str_date = "";
		String order_status = "";
		String regn_reqd_yn = "";
		String line_status = "";
		String prn_remarks_code = "";
		String buildMAR_yn = ""; //added for SRR20056-SCF-7882 -29157
		String diagText="";
		String content_in_pres_base_uom="";
		ArrayList reason	=	null;
		String reason_code ="",reason_desc ="";
		String start_date	=	"";
		String durn_type	=	"";
		String end_date		=	"";
		String refill_drug_code		=	"";
		float interval_value =1;
		String order_format_values="";

		locale= getLanguageId()==null?"en":getLanguageId();
		HashMap modifyRecords			=	null;
		try{
			connection		= getConnection() ;
			boolean site_all_durn_app = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","ALL_DURN_TYPE_APP");//added for ML-MMOH-CRF-1531
			String durn_value				= "";
			String total_strength					= "";
			int rows								= 0;
			String action_seq_num					= "";
			ArrayList frequencyValues				= new ArrayList();
			HashMap chkValuescheduleFrequency		= this.getscheduleFrequency();
			HashMap DrugValues		=	null;
			String total_seq		=	null;
			if( getAmend_based_order_wise().equals("N") && !getCalledFromAmend().equals("PH")  &&  getDispLocnCatg().equals("OP")){	/* code Added for ML-BRU-SCF-0190[32621] -- Start*///getAmend_based_order_wise ADDED FOR ML-MMOH-CRF-1748
				ArrayList tempPresDetails = new ArrayList();						
				int j = 1;					
				for(int i=0;i<presDetails.size();i++){						
					if( getAmendOrderLineNumber().contains(new Integer(j)) ){  
						modifyRecords	=	(HashMap) presDetails.get(i);
						tempPresDetails.add(modifyRecords);	
					}	
					j++;	
				}						
				presDetails = new ArrayList();
			
				for(int i=0;i<tempPresDetails.size();i++){
					modifyRecords	=	(HashMap) tempPresDetails.get(i);
					presDetails.add(modifyRecords);
				}
			}		 /* code Added for ML-BRU-SCF-0190[32621] -- End*/
			if(!locale.equals("en")){
				str_date = "";
				for(int i=0;i<presDetails.size();i++){
					modifyRecords	=	(HashMap) presDetails.get(i);
					str_date = (String) modifyRecords.get("START_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
					}
					modifyRecords.put("START_DATE_TIME",str_date );
					str_date = (String) modifyRecords.get("END_DATE_TIME");	

					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
					}
					modifyRecords.put("END_DATE_TIME", str_date);
				}
			}
			//Added for Bru-HIMS-CRF-393_1.0-Start
			HashMap orderTypeDetails=new HashMap();
			String  order_type_code="";
			String patient_class="";
			HashSet keyset=new HashSet();
			for(int i=0;i<presDetails.size();i++){
				orderTypeDetails=(HashMap)presDetails.get(i);
				order_type_code=(String)orderTypeDetails.get("ORDER_TYPE_CODE");
				patient_class=(String)orderTypeDetails.get("PATIENT_CLASS");
				keyset.add(order_type_code);
			}
			setPrintOrdShtRuleInd(keyset,patient_class);
			//Added for Bru-HIMS-CRF-393_1.0-End
			// DELETE PH_MEDN_ADMIN STARTS 
			sql_string		=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_DELETE2");
			pstmt_modify	= connection.prepareStatement(sql_string) ;
			String amended_yn		=	"";
			for(int i=0;i<presDetails.size();i++){
				modifyRecords	=	(HashMap) presDetails.get(i);
				amended_yn		=	(String)modifyRecords.get("AMENDED_YN");//added for ML-BRU-SCF-0725 [IN:038336]
				if(amended_yn==null || !amended_yn.equals("Y"))//added for ML-BRU-SCF-0725 [IN:038336]
					continue;
				pstmt_modify.setString(1,login_facility_id);
				pstmt_modify.setString(2,(String)modifyRecords.get("ENCOUNTER_ID"));
				pstmt_modify.setString(3,(String)modifyRecords.get("PATIENT_ID"));
				pstmt_modify.setString(4,(String)modifyRecords.get("DRUG_CODE"));
				pstmt_modify.setString(5,(String)modifyRecords.get("ORDER_ID"));
				pstmt_modify.addBatch();
			}
			pstmt_modify.executeBatch();
			closeStatement( pstmt_modify ) ;
			if( getCalledFromAmend().equals("PH") ) //Moved out from inside the loop -//Added for HSA-CRF-0147.1 [IN:049419]-RameshGoli	 
				reason	= getAmendReasonTemp(amendOrderID);
			else 
				reason	= getAmendReason(amendOrderID);
			if(reason.size() > 1 ) {
				reason_code		=	(String)reason.get(1);
				reason_desc		=	(String)reason.get(2);
			} //moved out from inside the loop -end
			
			if(!"".equals(amendOrderID) && "Y".equals(getAuditTrailReqYN())){ //Added for HSA-CRF-0147.1 [IN:049419]-RameshGoli	 -end
				PreparedStatement	auditSeqPStmt = connection.prepareStatement("SELECT NVL(MAX(ACTION_SEQ_NUM),0)+1 FROM OR_ORDER_AMEND_REASON WHERE ORDER_ID = ?");
				auditSeqPStmt.setString(1,amendOrderID);				
				ResultSet auditSeqRs = auditSeqPStmt.executeQuery();				
				String amend_reason_seq ="";
				if (auditSeqRs.next()){
					amend_reason_seq	= ChkDef.defaultString(auditSeqRs.getString(1));
				}
				PreparedStatement	auditReasonPStmt = connection.prepareStatement("INSERT INTO OR_ORDER_AMEND_REASON ( ORDER_ID,ACTION_SEQ_NUM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORDER_AMEND_REASON) VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");
				auditReasonPStmt.setString(1,amendOrderID);
				auditReasonPStmt.setString(2, amend_reason_seq);
				auditReasonPStmt.setString(3, login_by_id);		
				auditReasonPStmt.setString(4, login_at_ws_no);				
				auditReasonPStmt.setString(5, login_facility_id);	
				auditReasonPStmt.setString(6, login_by_id);					
				auditReasonPStmt.setString(7, login_at_ws_no);
				auditReasonPStmt.setString(8, login_facility_id);
				auditReasonPStmt.setString(9, reason_desc);
				auditReasonPStmt.execute();
				closeStatement(auditReasonPStmt);
				closeStatement(auditSeqPStmt);
				
			} //Added for HSA-CRF-0147.1 [IN:049419]-RameshGoli	 -end

			// DELETE PH_MEDN_ADMIN ENDS
			// DELETE DRUG REMARKS OF OR_ORDER_LINE_FIELD_VALUES STARTS
			ArrayList drug_remarks	=	null;
			sql_string				=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_DELETE3");
			pstmt_modify			= connection.prepareStatement(sql_string) ;
			int	remarks_cnt			=	0;
			
			for(int i=0;i<presDetails.size();i++){
				modifyRecords	=	(HashMap) presDetails.get(i);
				drug_remarks	=	getPrescribedRemarks((String) modifyRecords.get("ORDER_ID"),(String)modifyRecords.get("ORDER_LINE_NUM")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
				
				if(DrugRemarks!=null &&  DrugRemarks.size()>0) { 
					remarks_cnt		= Integer.parseInt((String)((HashMap)DrugRemarks.get(i)).get("order_format_count"));
				}
				if(DrugRemarks!=null && DrugRemarks.size()!=0 && remarks_cnt>0) { //IN21380 corrected here -- 17/05/2010 -- priya
					pstmt_modify.setString(1,(String) modifyRecords.get("ORDER_ID")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
					pstmt_modify.setString(2,(String)modifyRecords.get("ORDER_LINE_NUM"));
					pstmt_modify.addBatch();
				} 
			}
			pstmt_modify.executeBatch();
			closeStatement( pstmt_modify ) ;
			// DELETE DRUG REMARKS OF OR_ORDER_LINE_FIELD_VALUES ENDS
			// DELETE SCHEDULE VALUES OF OR_ORDER_LINE_FIELD_VALUES STARTS
			//	sql_string				=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_DELETE4");
			sql_string = "DELETE FROM OR_ORDER_LINE_FIELD_VALUES WHERE ORDER_ID=? and ORDER_LINE_NUM=? AND ORDER_LINE_SEQ_NUM > 200";

			sql_string_1 = "SELECT COUNT(*) CUNT FROM OR_ORDER_LINE WHERE ORDER_ID=? and ORDER_LINE_NUM=? AND ORDER_LINE_STATUS IN('AL','IP')"; //added for ML-MMOH-SCF-1776

			pstmt_modify			= connection.prepareStatement(sql_string) ;
			pstmt_modify_1			= connection.prepareStatement(sql_string_1) ;
			HashMap orderStatusCode		=	new HashMap();
			//added for ML-MMOH-SCF-1776 - start
			for(int i=0;i<presDetails.size();i++){
				modifyRecords	=	(HashMap) presDetails.get(i);
				
				pstmt_modify_1.setString(1,(String) modifyRecords.get("ORDER_ID")); 
				pstmt_modify_1.setString(2,(String)modifyRecords.get("ORDER_LINE_NUM"));
				resultSet		=	pstmt_modify_1.executeQuery();
				if(resultSet!=null && resultSet.next()){
					 int cunt = resultSet.getInt("cunt");
					if(cunt>0){
						map.put( "message",  getMessage(locale,"ORDER_PROC_BY_OTHER_USER","PH") );
						System.err.println("ERROR IN AMEND NORMAL RX presDetails="+presDetails);
							map.put( "result", new Boolean( false ) ) ;
	                        map.put( "msgid_other_user",  "ORDER_PROC_BY_OTHER_USER");

	
						throw new Exception(getMessage(locale,"ORDER_PROC_BY_OTHER_USER","PH"));
					}
				}
			closeResultSet( resultSet );
			}
			closeStatement( pstmt_modify_1) ;	
			//added for ML-MMOH-SCF-1776 - end

			for(int i=0;i<presDetails.size();i++){
				modifyRecords	=	(HashMap) presDetails.get(i);
				amended_yn		=	(String)modifyRecords.get("AMENDED_YN");//added for ML-BRU-SCF-2023 start
				if(amended_yn==null || !amended_yn.equals("Y"))
					continue;//end
				pstmt_modify.setString(1,(String) modifyRecords.get("ORDER_ID")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
				pstmt_modify.setString(2,(String)modifyRecords.get("ORDER_LINE_NUM"));
				pstmt_modify.addBatch();
			}
			pstmt_modify.executeBatch();
			//int[] result_delete_3= pstmt_modify.executeBatch();
			closeStatement( pstmt_modify ) ;
			// DELETE SCHEDULE VALUES OF OR_ORDER_LINE_FIELD_VALUES ENDS

			pstmt			= connection.prepareStatement("select ORDER_STATUS_CODE, ORDER_STATUS_TYPE from or_order_status_code where order_status_type in ('00','03','05','10','25','58','56','30')") ;
			resultSet		= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				orderStatusCode.put(resultSet.getString("ORDER_STATUS_TYPE"),resultSet.getString("ORDER_STATUS_CODE"));
			}
			closeResultSet( resultSet );
			closeStatement( pstmt) ;

			// OR_ORDER update starts
			//sql_string		=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY1");
			
			sql_string		=	"UPDATE OR_ORDER SET MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? , ORDER_STATUS=?  WHERE  ORDER_ID=? ";
			modifyRecords	=	(HashMap) presDetails.get(0);
			order_status = (String) modifyRecords.get("ORDER_STATUS");
			pstmt			=	connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT19A")) ;
			pstmt.setString(1,(String) modifyRecords.get("ORDER_TYPE_CODE"));
			resultSet		=	pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				regn_reqd_yn=resultSet.getString(1);
			}
			closeResultSet( resultSet );
			closeStatement( pstmt) ;
			/*16076 - COMMENTED for this issue. In modify mode, dont change the status if order_status is 25 ie. RG
			if(order_status.equals("10") || order_status.equals("25")){
				if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y"))
					order_status="25";
				else
					order_status="10";
			}*/

			order_status = (String)orderStatusCode.get(order_status);
			pstmt_modify	= connection.prepareStatement(sql_string) ;
			pstmt_modify.setString(1,login_by_id);
			pstmt_modify.setString(2,login_at_ws_no);
			pstmt_modify.setString(3,login_facility_id);
			pstmt_modify.setString(4,order_status);
			pstmt_modify.setString(5,amendOrderID);			//changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]		
			rows			=	pstmt_modify.executeUpdate();
			closeStatement( pstmt_modify ) ;
			// OR_ORDER update ends

			// start: Retrieve all the refill orders of the main order
			//sql_string		=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT83");
			//sql_string		=	"SELECT ORDER_ID, ORDER_LINE_NUM, ORDER_CATALOG_CODE FROM OR_ORDER_LINE WHERE CHILD_ORDER_YN='Y' AND PARENT_ORDER_ID=?"; //AND  ORDER_CATALOG_CODE = ?
			sql_string		=	"SELECT order_id, order_line_num, order_catalog_code FROM or_order_line a WHERE a.child_order_yn = 'Y' AND ORDER_TYPE_CODE!='TDM' AND a.parent_order_id = ? AND a.order_catalog_code = ? AND (select freq_nature from am_frequency b, or_order_line c where c.order_id = a.parent_order_id and a.order_catalog_code = c.order_catalog_code and b.freq_code = c.freq_code) not in ('P', 'O','C')"; //added for MMS-SCF-0368 [IN:049746] and AND ORDER_TYPE_CODE!='TDM' added for ML-MMOH-SCF-1755
			pstmt			=	connection.prepareStatement(sql_string) ;
			pstmt.setString(1,(String) modifyRecords.get("ORDER_ID")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
			pstmt.setString(2,(String) modifyRecords.get("DRUG_CODE")); //Added for MMS-SCF-0368 [IN:049746]
			resultSet		=	pstmt.executeQuery();
			ArrayList refill_orders	=	new ArrayList();
			while(resultSet.next()) {
				refill_orders.add(checkForNull(resultSet.getString("ORDER_ID")));
				refill_orders.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));
				refill_orders.add(checkForNull(resultSet.getString("ORDER_CATALOG_CODE")));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;	// end: Retrieve all the refill orders of the main order
//added for BSB-SCF-0062-start

			if(refill_orders.size()>0){ 
				pstmt			= connection.prepareStatement("DELETE FROM OR_ORDER_LINE_FIELD_VALUES WHERE ORDER_ID=? and ORDER_LINE_NUM=? AND ORDER_LINE_SEQ_NUM > 200") ;
				for(int i=0;i<refill_orders.size();i+=3){
					if(presDetails.size()>0 && refill_orders.size()>0) {			
						pstmt.setString(1,(String)refill_orders.get(i)); 
						pstmt.setString(2,(String)refill_orders.get(i+1));
						pstmt.addBatch();
					}
				}
				pstmt.executeBatch();
				closeStatement( pstmt ) ;
			}
//added for BSB-SCF-0062-end			
				
			// OR_ORDER_LINE update starts	
			//sql_string		=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY2");
			sql_string		=	"UPDATE OR_ORDER_LINE SET QTY_VALUE=?,QTY_UNIT=?,FREQ_CODE=?, DURN_VALUE=?,DURN_TYPE=?, START_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), END_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ORDER_QTY=?,ORDER_UOM=?,AMD_PRACT_ID=?, AMD_DATE_TIME=SYSDATE, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, ROUTE_CODE=?, LINE_FIELDS_DISPLAY_TEXT=?,ORD_AUTH_REQD_YN=?,ORDER_LINE_STATUS=?,PRIORITY=?  WHERE  ORDER_ID=? AND ORDER_LINE_NUM=?";			//PRIORITY=? added for SKR-SCF-1302
			pstmt_modify	=	connection.prepareStatement(sql_string) ;
			String priority = "";//SKR-SCF-1302
			for(int i=0;i<presDetails.size();i++){
				modifyRecords	=	(HashMap) presDetails.get(i);
				order_status = (String) modifyRecords.get("ORDER_STATUS");
				pstmt_modify.setString(1,(String) modifyRecords.get("QTY_VALUE"));	
				pstmt_modify.setString(2,(String) modifyRecords.get("QTY_UNIT"));
				pstmt_modify.setString(3,(String) modifyRecords.get("FREQ_CODE"));
				pstmt_modify.setString(4,(String) modifyRecords.get("DURN_VALUE"));
				pstmt_modify.setString(5,(String) modifyRecords.get("DURN_TYPE"));	
				str_date = (String) modifyRecords.get("START_DATE_TIME");
				pstmt_modify.setString(6,str_date);			
				str_date = (String) modifyRecords.get("END_DATE_TIME");
				//added for SKR-SCF-1302 - start
				freq_nature		=	(String) modifyRecords.get("FREQ_NATURE");
				if(freq_nature.equals("O"))
					priority = "U";
				else
					priority = "R";	

				//added for SKR-SCF-1302 - end

				//if(!locale.equals("en"))
					//str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
				pstmt_modify.setString(7,str_date);
				//if(!locale.equals("en"))
					//str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
				pstmt_modify.setString(8,(String) modifyRecords.get("ORDER_QTY"));
				pstmt_modify.setString(9,(String) modifyRecords.get("ORDER_UOM"));
				pstmt_modify.setString(10,(String) modifyRecords.get("ORD_PRACT_ID")); //login_by_id cahnged to (String) modifyRecords.get("ORD_PRACT_ID") for ML-BRU-SCF-0318
				pstmt_modify.setString(11,login_by_id);
				pstmt_modify.setString(12,login_at_ws_no);
				pstmt_modify.setString(13,login_facility_id);					
				pstmt_modify.setString(14,(String) modifyRecords.get("ROUTE_CODE"));	
				String drug_rm = (String) modifyRecords.get("LINE_FIELDS_DISPLAY_TEXT"); //Commented for SKR-SCF-0343 [IN:029878]//uncommented for SKR-SCF-1318
				//drug_rm = drug_rm.substring(0,drug_rm.indexOf(":")+1); //Commented for SKR-SCF-0343 [IN:029878]
				order_format_values = ""; //Added for SKR-SCF-0343 [IN:029878] -Start
				if(DrugRemarks!=null && DrugRemarks.size()>0){
					for(int p=0; p<DrugRemarks.size(); p++) {
						DrugValues=(HashMap)DrugRemarks.get(p);
						total_seq	=	(String)DrugValues.get("order_format_count") ;
						if(total_seq!= null && total_seq.equals((String) modifyRecords.get("ORDER_LINE_NUM"))) {
							 order_format_values = (String)DrugValues.get("order_format_values")==null?"":(String)DrugValues.get("order_format_values");
							//pstmt_modify.setString(15,(String)DrugValues.get("order_format_values"));	
							break;
						}
					}//Added for SKR-SCF-0343 [IN:029878] -End
					//drug_rm = drug_rm + drug_remarks.get(0); //Commented for SKR-SCF-0343 [IN:029878]
					//pstmt_modify.setString(15,drug_rm);	 //Commented for SKR-SCF-0343 [IN:029878]
				}
				//added for SKR-SCF-1318 START
				if(order_format_values==null || order_format_values.equals("")){
					order_format_values = drug_rm;
				}//END
				pstmt_modify.setString(15,order_format_values);
				pstmt_modify.setString(16,(String) modifyRecords.get("ORD_AUTHORIZED_YN"));	

				pstmt			=	connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT19A")) ;
				pstmt.setString(1,(String) modifyRecords.get("ORDER_TYPE_CODE"));
				resultSet		=	pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					regn_reqd_yn=resultSet.getString(1);
				}
				closeResultSet( resultSet );
				closeStatement( pstmt) ;

				/*	16076 - COMMENTED for this issue. In modify mode, dont change the status if order_status is 25 ie. RG
				if(order_status.equals("10") || order_status.equals("25")){
					if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y")){
						order_status="25";
					}
					else{
						order_status="10";
					}
				}*/
				if(order_status.equals("03"))
					line_status= (String)orderStatusCode.get("03");
				else if(order_status.equals("05"))
					line_status=(String) orderStatusCode.get("05");
				else if(order_status.equals("10"))
					line_status=(String) orderStatusCode.get("10");
				else if(order_status.equals("25"))
					line_status= (String)orderStatusCode.get("25");
				else if(order_status.equals("00"))
					line_status= (String)orderStatusCode.get("00");
				else if(order_status.equals("30"))
					line_status= (String)orderStatusCode.get("30");

				/*if( insertRecords_2.get("BROUGHT_BY_PAT")!=null && ((String)insertRecords_2.get("BROUGHT_BY_PAT")).equals("Y")) {
					line_status	=	(String)orderStatusCode.get("58");
				}*/

				pstmt_modify.setString(17,line_status);
				pstmt_modify.setString(18,priority);//SKR-SCF-1302
				pstmt_modify.setString(19,(String) modifyRecords.get("ORDER_ID"));	//changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]//modified for SKR-SCF-1302
				pstmt_modify.setString(20,(String) modifyRecords.get("ORDER_LINE_NUM")); //modified for SKR-SCF-1302
				pstmt_modify.addBatch();
			}

			int[] result_modify_1= pstmt_modify.executeBatch();
			closeStatement( pstmt_modify ) ;
			for (int i=0;i<result_modify_1.length ;i++ ){
				if(result_modify_1[i]<0  && result_modify_1[i] != -2 ){
					modify_rec_1=false;
					break;
				}
				else{
					modify_rec_1=true;
				}
			}
			// update for refill starts here(OR_ORDER_LINE)
			sql_string		=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY2");
			pstmt_modify	=	connection.prepareStatement(sql_string) ;
			for(int i=0;i<refill_orders.size();i+=3){
				if(presDetails.size()>0 && refill_orders.size()>0) {
					refill_drug_code = (String)refill_orders.get(i+2);
					for(int j=0; j<presDetails.size(); j++){
						modifyRecords	=	(HashMap) presDetails.get(j);
						drug_code = (String) modifyRecords.get("DRUG_CODE");
						if(refill_drug_code.equals(drug_code)){
							break;
						}
					}
					freq_nature		=	(String) modifyRecords.get("FREQ_NATURE");
					if(i==0) {
						start_date		=	(String) modifyRecords.get("END_DATE_TIME");
					} 
					else {
						start_date		=	end_date;
					}
					//if(!locale.equals("en"))
						//start_date = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",locale,"en");

					durn_value		=	(String) modifyRecords.get("DURN_VALUE");
					durn_type		=	(String) modifyRecords.get("DURN_TYPE");
					end_date		=	populateEndDate(freq_nature,start_date,durn_value,durn_type);
					if(!locale.equals("en"))
						end_date = com.ehis.util.DateUtils.convertDate(end_date, "DMYHM",locale,"en");

System.err.println("PrescriptionBean_1.java===BSP-SCF-0096==5617==modifyRecords===>"+modifyRecords);
					pstmt_modify.setString(1,(String) modifyRecords.get("QTY_VALUE"));	
					pstmt_modify.setString(2,(String) modifyRecords.get("QTY_UNIT"));
					pstmt_modify.setString(3,(String) modifyRecords.get("FREQ_CODE"));
					pstmt_modify.setString(4,(String) modifyRecords.get("DURN_VALUE"));
					pstmt_modify.setString(5,(String) modifyRecords.get("DURN_TYPE"));					
					pstmt_modify.setString(6,start_date);			
					pstmt_modify.setString(7,end_date);
					pstmt_modify.setString(8,(String) modifyRecords.get("ORDER_QTY"));
					pstmt_modify.setString(9,(String) modifyRecords.get("ORDER_UOM"));
					pstmt_modify.setString(10,(String) modifyRecords.get("ORD_PRACT_ID")); //login_by_id cahnged to (String) modifyRecords.get("ORD_PRACT_ID") for ML-BRU-SCF-0318
					pstmt_modify.setString(11,login_by_id);
					pstmt_modify.setString(12,login_at_ws_no);
					pstmt_modify.setString(13,login_facility_id);					
					pstmt_modify.setString(14,(String) modifyRecords.get("ROUTE_CODE"));					
					pstmt_modify.setString(15,(String)refill_orders.get(i));					
					pstmt_modify.setString(16,(String)refill_orders.get(i+1));
					//pstmt_modify.setString(16,(String) modifyRecords.get("ORDER_LINE_NUM"));
					pstmt_modify.addBatch();
				}
			}

			int[] result_modify_1a= pstmt_modify.executeBatch();
			closeStatement( pstmt_modify ) ;
			for (int i=0;i<result_modify_1a.length ;i++ ){
				if(result_modify_1a[i]<0  && result_modify_1a[i] != -2 ){
					modify_rec_1=false;
					break;
				}
				else{
					modify_rec_1=true;
				}
			}
			// refill OR_ORDER_LINE update ends

			//start: get conversion value
			ArrayList orderToPresBaseConv	=	new ArrayList();
			for (int i=0;i<presDetails.size();i++ ){
				sql_string		=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53");
				pstmt			=	connection.prepareStatement(sql_string) ;
				pstmt.setString(1,(String)((HashMap) presDetails.get(i)).get("QTY_DESC_CODE"));
				pstmt.setString(2,(String)((HashMap) presDetails.get(i)).get("PRES_BASE_UOM"));
				pstmt.setString(3,(String)((HashMap) presDetails.get(i)).get("QTY_DESC_CODE"));
				pstmt.setString(4,(String)((HashMap) presDetails.get(i)).get("PRES_BASE_UOM"));
				resultSet		=	pstmt.executeQuery();
				if ( resultSet != null && resultSet.next() )
					orderToPresBaseConv.add(resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE"));
				else
					orderToPresBaseConv.add("1");
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}//end : get conversion value
//SKR-SCF-1302-start
			int priority_cunt = 0;
			for (int i=0;i<presDetails.size();i++ ){
				modifyRecords	=	(HashMap) presDetails.get(i);
				freq_nature = (String) modifyRecords.get("FREQ_NATURE")==null?"":(String) modifyRecords.get("FREQ_NATURE");
				priority_cunt = 0;
				pstmt			=	connection.prepareStatement("select count(*)cunt from or_order_line where order_Category='PH' and order_id=? and priority='U' ") ;
				pstmt.setString(1,(String) modifyRecords.get("ORDER_ID"));
				
				resultSet		=	pstmt.executeQuery();
				if(resultSet != null && resultSet.next())
					priority_cunt = resultSet.getInt("cunt");

				closeResultSet( resultSet ) ;
				if(priority_cunt>0){
					pstmt_modify	= connection.prepareStatement("update or_order set priority=? where order_id=?") ;
					pstmt_modify.setString(1,"U");
					pstmt_modify.setString(2,(String) modifyRecords.get("ORDER_ID"));
					rows			=	pstmt_modify.executeUpdate();
					closeStatement( pstmt_modify ) ;
				}else{
					pstmt_modify	= connection.prepareStatement("update or_order set priority=? where order_id=?") ;
					pstmt_modify.setString(1,"R");
					pstmt_modify.setString(2,(String) modifyRecords.get("ORDER_ID"));
					rows			=	pstmt_modify.executeUpdate();
					closeStatement( pstmt_modify ) ;
				}

				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
//SKR-SCF-1302-end
			// OR_ORDER_LINE_PH starts
			if(modify_rec_1){
				sch_strength		=	"1";
				split_dose_yn	=	"N";
				int col_cnt				=	1;
				sql_string				= "";                     

				pstmt_modify	=	null;
				sql_string		=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY3");
				pstmt_modify	=	connection.prepareStatement(sql_string) ;
				for(int i=0;i<presDetails.size();i++){
					col_cnt			=	1;
					drug_code="";                                   
					sch_strength	=	"";                            
					dosage_type = "";                              
					absol_qty = "";                                  
					prn_doses_pres_prn_fil="";                   
					fract_dose = "";                                 
					qty_value = "";                                  
					repeat_value = "";                              
					strength_per_value_per_pres_uom="";   
					strength_per_pres_uom = "";                
					pres_base_uom=""; 
					in_order_qty_strength = "";
					in_order_qty="";                                
					in_order_qty_uom="";  
					strength_value="";
					strength_uom = "";
					freq_nature = "";   
					total_strength = "";
					calc_dosg_by_freq_durn_yn="";
					split_dose_yn="N";
					interval_value=1;
					frequencyValues			= new ArrayList();
					modifyRecords	=	(HashMap) presDetails.get(i);

					frequencyValues	=	new ArrayList();
					if( ((String) modifyRecords.get("DOSAGE_TYPE")).equals("Q") && ((String) modifyRecords.get("STRENGTH"))!=null && !((String) modifyRecords.get("STRENGTH")).equals("0") && !((String) modifyRecords.get("STRENGTH")).equals("") ) {
						if( !((String) modifyRecords.get("STRENGTH_PER_PRES_UOM")).equals("") && !((String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")).equals("") ) {
							sch_strength	=	Math.ceil( (Float.parseFloat((String) modifyRecords.get("STRENGTH_PER_PRES_UOM")) / Float.parseFloat((String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")) ) * Float.parseFloat((String) modifyRecords.get("QTY_VALUE")))+"";
						}
					} 
					else if (((String) modifyRecords.get("DOSAGE_TYPE")).equals("S")){
						sch_strength	=	(String) modifyRecords.get("STRENGTH")==null?"1":(String) modifyRecords.get("STRENGTH");
							//sch_strength	=	(String) modifyRecords.get("QTY_VALUE");
					}

					if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0) {
						if(chkValuescheduleFrequency.containsKey((String) modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO")))
							frequencyValues = (ArrayList) chkValuescheduleFrequency.get((String) modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO"));
					}
					if(checkSplit(frequencyValues)) {
						split_dose_yn		=	"Y";
					}
					//below condtition added for ML-BRU-SCF-0098 [IN031837] 
					if( getCalledFromAmend().equals("PH") )  
						reason	= getAmendReasonTemp(amendOrderID);
					else 
						reason	= getAmendReason(amendOrderID);

					reason_code	=	"";
					reason_desc	=	"";

					if(reason.size() > 1 ) {
						reason_code		=	(String)reason.get(1);
						reason_desc		=	(String)reason.get(2);
					}
					dosage_type = (String) modifyRecords.get("DOSAGE_TYPE")==null?"":(String) modifyRecords.get("DOSAGE_TYPE");             
					freq_nature = (String) modifyRecords.get("FREQ_NATURE");              
					absol_qty = (String) modifyRecords.get("ABSOL_QTY")==null?"0":(String) modifyRecords.get("ABSOL_QTY");                 
					prn_doses_pres_prn_fil=(String) modifyRecords.get("PRN_DOSES_PRES_PRD_FILL")==null?"0":(String) modifyRecords.get("PRN_DOSES_PRES_PRD_FILL");  
					qty_value = (String) modifyRecords.get("QTY_VALUE");                 
					durn_value = (String) modifyRecords.get("DURN_VALUE");               
					repeat_value = (String) modifyRecords.get("REPEAT_VALUE");             
					interval_value = Float.parseFloat((String) modifyRecords.get("INTERVAL_VALUE")==null?"1":(String) modifyRecords.get("INTERVAL_VALUE"));             
					strength_per_value_per_pres_uom=(String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"1":(String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM"); 
					strength_per_pres_uom = (String) modifyRecords.get("STRENGTH_PER_PRES_UOM")==null?"1":(String) modifyRecords.get("STRENGTH_PER_PRES_UOM");
					pres_base_uom = (String) modifyRecords.get("PRES_BASE_UOM");
					fract_dose = (String) modifyRecords.get("FRACT_DOSE_ROUND_UP_YN")==null?"N":(String) modifyRecords.get("FRACT_DOSE_ROUND_UP_YN");
					strength_value			=	(String)modifyRecords.get("ACT_STRENGTH_VALUE");
					strength_uom = (String)modifyRecords.get("STRENGTH_UOM")==null?"":(String)modifyRecords.get("STRENGTH_UOM");
					calc_dosg_by_freq_durn_yn = (String)modifyRecords.get("CALC_DOSG_BY_FREQ_DURN_YN")==null?"N":(String)modifyRecords.get("CALC_DOSG_BY_FREQ_DURN_YN");
					buildMAR_yn = (String)modifyRecords.get("BUILDMAR_YN")==null?"N":(String)modifyRecords.get("BUILDMAR_YN");	//added for SRR20056-SCF-7882 -29157
					//split_dose_yn = (String)modifyRecords.get("SPLIT_DOSE_YN")==null?"":(String)modifyRecords.get("SPLIT_DOSE_YN");// Commented on 15/04/2010 -- priya
					content_in_pres_base_uom = (String)modifyRecords.get("CONTENT_IN_PRES_BASE_UOM");
					if(strength_per_pres_uom.equals(""))
						strength_per_pres_uom="1";
					in_order_qty_uom = pres_base_uom;
					if(split_dose_yn.equals("Y"))
						repeat_value="1";
					if((dosage_type!=null && dosage_type.equals("A")) || (freq_nature!=null && (freq_nature.equals("P") || freq_nature.equals("O")))){
						in_order_qty=(String) modifyRecords.get("ORDER_QTY");
						in_order_qty = (Float.parseFloat(in_order_qty) * Float.parseFloat(content_in_pres_base_uom))+"";
						in_order_qty_strength = in_order_qty;
						//in_order_qty_uom = (String) modifyRecords.get("ORDER_UOM"); changed for 13927 - 17/9/09
						in_order_qty_uom = pres_base_uom;
					}
					else if(dosage_type!=null && dosage_type.equals("Q")){
						if(fract_dose.equals("Y")){
							in_order_qty=Math.ceil(Float.parseFloat(qty_value))*Math.ceil(Float.parseFloat((String)orderToPresBaseConv.get(i)))*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)+"";
							in_order_qty_strength = Math.ceil(Float.parseFloat(qty_value))*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)+"";
						}
						else{
							in_order_qty=Float.parseFloat(qty_value)*Float.parseFloat((String)orderToPresBaseConv.get(i))*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)+"";
							in_order_qty_strength=Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)+"";
						}
					}
					else if(dosage_type!=null && dosage_type.equals("S")){
						if(fract_dose.equals("Y")){
							in_order_qty=(Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_per_pres_uom))*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))+"";
							in_order_qty_strength = in_order_qty;
						}
						else{
							in_order_qty=((Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))/Float.parseFloat(strength_per_pres_uom))+"";
							in_order_qty_strength = in_order_qty;
						}
					}

					if(!dosage_type.equals("S")){
						total_strength=in_order_qty_strength;
					}
					else if(Float.parseFloat(strength_per_pres_uom)>0 && (dosage_type!=null && dosage_type.equals("S"))){
						total_strength =Math.ceil(Float.parseFloat(in_order_qty_strength)*Float.parseFloat(strength_per_pres_uom)/Float.parseFloat(strength_per_value_per_pres_uom))+"";
					}
					else{
						total_strength = "";
					}

					/*if(!(Float.parseFloat(strength_per_pres_uom)>0 && calc_dosg_by_freq_durn_yn.equals("Y"))){
						in_order_qty= (String) modifyRecords.get("ORDER_QTY");
						in_order_qty_uom = (String) modifyRecords.get("ORDER_UOM");
					}-*/

					pstmt_modify.setString(col_cnt,(String) modifyRecords.get("DOSAGE_TYPE"));
					/*in insert, we r inserting "" into this col. col width is only 120, we have increased this column in ph_drug_profile to 400*/
					//pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("SPLIT_DOSE_PREVIEW"));				
					pstmt_modify.setString(++col_cnt,"");				
					pstmt_modify.setString(++col_cnt,split_dose_yn);
					pstmt_modify.setString(++col_cnt,total_strength);
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("STRENGTH"));
					pstmt_modify.setString(++col_cnt,strength_uom);
					pstmt_modify.setString(++col_cnt,total_strength);				
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ORDER_QTY"));
					pstmt_modify.setString(++col_cnt,in_order_qty);
					pstmt_modify.setString(++col_cnt,in_order_qty_uom);
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ALLERGY_REMARKS"));
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DOSE_REMARKS"));
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("CURRENTRX_REMARKS"));
					pstmt_modify.setString(++col_cnt,reason_code); // AMEND_REASON_CODE
					pstmt_modify.setString(++col_cnt,reason_desc); // AMEND_REASON
					pstmt_modify.setString(++col_cnt,login_by_id);
					pstmt_modify.setString(++col_cnt,login_at_ws_no);
					pstmt_modify.setString(++col_cnt,login_facility_id);
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("BL_OVERRIDE_EXCL_INCL_IND"));
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"));
					pstmt_modify.setString(++col_cnt,buildMAR_yn); //added for SRR20056-SCF-7882 -29157
					pstmt_modify.setString(++col_cnt,login_by_id);//Added for ML-BRU-SCF-0098 [IN031837]
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DRUG_INDICATION"));//Added for  ML-BRU-CRF-072[Inc:29938]DrugIndicationRemarks
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("PREG_REMARKS"));// added for CRF RUT-CRF-0063[29601]
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("INTERACTION_REMARKS")); //MMS-KH-CRF-0029
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("LAB_INTERACTION_REMARKS")); //MMS-KH-CRF-0029
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("FOOD_INTERACTION_REMARKS")); //MMS-KH-CRF-0029
					//Added for IN:072715 start
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ALLERGY_REMARKS_CODE"));
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DOSE_REMARKS_CODE"));
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("CURRENTRX_REMARKS_CODE"));
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("INTERACTION_REMARKS_CODE"));
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("LAB_INTERACTION_REMARKS_CODE"));
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("FOOD_INTERACTION_REMARKS_CODE"));
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ABUSE_OVERRIDE"));//ADDED FOR AAKH-CRF-0140
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("abuse_override_remarks"));//ADDED FOR AAKH-CRF-0140
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DISEASE_INTERACTION_REMARKS"));//Added for MMS-DM-CRF-0229
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DISEASE_INTERACTION_REMARKS_CODE"));//Added for MMS-DM-CRF-0229
					
					//Added for IN:072715 end
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ORDER_ID")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
					pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ORDER_LINE_NUM"));
					pstmt_modify.addBatch();
				}
			}
			int[] result_modify_2= pstmt_modify.executeBatch();
			closeStatement( pstmt_modify ) ;
			for (int i=0;i<result_modify_2.length ;i++ ){
				if(result_modify_2[i]<0  && result_modify_2[i] != -2 ){
					modify_rec_2=false;
					break;
				}
				else{
				modify_rec_2=true;
				}
			}
			// OR_ORDER_LINE_PH ends
			// start: update for refill(OR_ORDER_LINE_PH)
			sql_string		=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY3");
			pstmt_modify	=	connection.prepareStatement(sql_string) ;
			freq_nature	=	"";
			refill_drug_code		=	"";
			Float ordToPresBaseConv = new Float(1.0);

			for(int i=0;i<refill_orders.size();i+=3){
				if(presDetails.size()>0 && refill_orders.size()>0) {
					refill_drug_code = (String)refill_orders.get(i+2);
					for(int j=0; j<presDetails.size(); j++){
						modifyRecords	=	(HashMap) presDetails.get(j);
						drug_code = (String) modifyRecords.get("DRUG_CODE");
						ordToPresBaseConv = Float.parseFloat((String)orderToPresBaseConv.get(j));
						if(refill_drug_code.equals(drug_code)){
							break;
						}
					}
					drug_code="";                                   
					sch_strength	=	"";                            
					dosage_type = "";                              
					absol_qty = "";                                  
					prn_doses_pres_prn_fil="";                   
					fract_dose = "";                                 
					qty_value = "";                                  
					repeat_value = "";                              
					strength_per_value_per_pres_uom="";   
					strength_per_pres_uom = "";                
					pres_base_uom="";   
					in_order_qty_strength = "";
					in_order_qty="";                                
					in_order_qty_uom="";  
					strength_value="";
					strength_uom = "";
					freq_nature = "";   
					total_strength = "";
					calc_dosg_by_freq_durn_yn="";
					split_dose_yn="";
					interval_value=1;
					frequencyValues			= new ArrayList();
					if( ((String) modifyRecords.get("DOSAGE_TYPE")).equals("Q") && ((String) modifyRecords.get("STRENGTH"))!=null && !((String) modifyRecords.get("STRENGTH")).equals("0") && !((String) modifyRecords.get("STRENGTH")).equals("") ) {
						if( !((String) modifyRecords.get("STRENGTH_PER_PRES_UOM")).equals("") && !((String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")).equals("") ) {
							sch_strength	=	Math.ceil( (Float.parseFloat((String) modifyRecords.get("STRENGTH_PER_PRES_UOM")) / Float.parseFloat((String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")) ) * Float.parseFloat((String) modifyRecords.get("QTY_VALUE")))+"";
						}
					} 
					else if (((String) modifyRecords.get("DOSAGE_TYPE")).equals("S")){
						sch_strength	=	(String) modifyRecords.get("STRENGTH")==null?"1":(String) modifyRecords.get("STRENGTH");
							//sch_strength	=	(String) modifyRecords.get("QTY_VALUE");
					}

					if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0) {
						if(chkValuescheduleFrequency.containsKey((String) modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO")))
							frequencyValues = (ArrayList) chkValuescheduleFrequency.get((String) modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO"));
					}

					if(checkSplit(frequencyValues)) {
						split_dose_yn		=	"Y";
					}
					
					if( getCalledFromAmend().equals("PH") ) 
						reason	= getAmendReasonTemp(amendOrderID);
					else 
						reason	= getAmendReason(amendOrderID);

					reason_code	=	"";
					reason_desc	=	"";

					if(reason!=null && reason.size() > 1 ) {
						reason_code		=	(String)reason.get(1);
						reason_desc		=	(String)reason.get(2);
					}
					dosage_type = (String) modifyRecords.get("DOSAGE_TYPE")==null?"":(String) modifyRecords.get("DOSAGE_TYPE");             
					freq_nature = (String) modifyRecords.get("FREQ_NATURE");              
					absol_qty = (String) modifyRecords.get("ABSOL_QTY")==null?"0":(String) modifyRecords.get("ABSOL_QTY");                 
					prn_doses_pres_prn_fil=(String) modifyRecords.get("PRN_DOSES_PRES_PRD_FILL")==null?"0":(String) modifyRecords.get("PRN_DOSES_PRES_PRD_FILL");  
					qty_value = (String) modifyRecords.get("QTY_VALUE");                 
					durn_value = (String) modifyRecords.get("DURN_VALUE");               
					repeat_value = (String) modifyRecords.get("REPEAT_VALUE");             
					interval_value = Float.parseFloat((String) modifyRecords.get("INTERVAL_VALUE")==null?"1":(String) modifyRecords.get("INTERVAL_VALUE"));             
					strength_per_value_per_pres_uom=(String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"1":(String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM"); 
					strength_per_pres_uom = (String) modifyRecords.get("STRENGTH_PER_PRES_UOM")==null?"1":(String) modifyRecords.get("STRENGTH_PER_PRES_UOM");
					pres_base_uom = (String) modifyRecords.get("PRES_BASE_UOM");
					fract_dose = (String) modifyRecords.get("FRACT_DOSE_ROUND_UP_YN")==null?"N":(String) modifyRecords.get("FRACT_DOSE_ROUND_UP_YN");
					strength_value			=	(String)modifyRecords.get("ACT_STRENGTH_VALUE");
					strength_uom = (String)modifyRecords.get("STRENGTH_UOM")==null?"":(String)modifyRecords.get("STRENGTH_UOM");
					calc_dosg_by_freq_durn_yn = (String)modifyRecords.get("CALC_DOSG_BY_FREQ_DURN_YN")==null?"N":(String)modifyRecords.get("CALC_DOSG_BY_FREQ_DURN_YN");
					split_dose_yn = (String)modifyRecords.get("SPLIT_DOSE_YN")==null?"":(String)modifyRecords.get("SPLIT_DOSE_YN");
					buildMAR_yn = (String)modifyRecords.get("BUILDMAR_YN")==null?"N":(String)modifyRecords.get("BUILDMAR_YN"); //added for SRR20056-SCF-7882 -29157

					if(strength_per_pres_uom.equals(""))
						strength_per_pres_uom="1";

					in_order_qty_uom = pres_base_uom;
					if(split_dose_yn.equals("Y"))
						repeat_value="1";

					if((dosage_type!=null && dosage_type.equals("A")) || (freq_nature!=null && freq_nature.equals("P"))){
						in_order_qty=(String) modifyRecords.get("ORDER_QTY");
						in_order_qty_uom = (String) modifyRecords.get("ORDER_UOM");
						in_order_qty_strength = in_order_qty;
					}
					else if(dosage_type!=null && dosage_type.equals("Q")){
						if(fract_dose.equals("Y")){
							in_order_qty=Math.ceil(Float.parseFloat(qty_value))*ordToPresBaseConv*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)+"";
							in_order_qty_strength = in_order_qty=Math.ceil(Float.parseFloat(qty_value))*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)+"";
						}
						else{
							in_order_qty=Float.parseFloat(qty_value)*Math.ceil(ordToPresBaseConv)*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)+"";
							in_order_qty_strength = Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)+"";
						}
					}
					else if(dosage_type!=null && dosage_type.equals("S")){
						if(fract_dose.equals("Y")){
							in_order_qty=(Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_per_pres_uom))*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))+"";
							in_order_qty_strength = in_order_qty;
						}
						else{
							in_order_qty=((Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))/Float.parseFloat(strength_per_pres_uom))+"";
							in_order_qty_strength= in_order_qty;
						}
					}

					if(!dosage_type.equals("S")){
						total_strength=in_order_qty_strength;
					}
					else if(Float.parseFloat(strength_per_pres_uom)>0 && (dosage_type!=null && dosage_type.equals("S"))){
						total_strength =Math.ceil(Float.parseFloat(in_order_qty_strength)*Float.parseFloat(strength_per_pres_uom)/Float.parseFloat(strength_per_value_per_pres_uom))+"";
					}
					else{
						total_strength = "";
					}
					if(!(Float.parseFloat(strength_per_pres_uom)>0 && calc_dosg_by_freq_durn_yn.equals("Y"))){
						in_order_qty= (String) modifyRecords.get("ORDER_QTY");
						in_order_qty_uom = (String) modifyRecords.get("ORDER_UOM");
					}
					pstmt_modify.setString(1,(String) modifyRecords.get("DOSAGE_TYPE"));
					pstmt_modify.setString(2,(String) modifyRecords.get("SPLIT_DOSE_PREVIEW"));				
					pstmt_modify.setString(3,split_dose_yn);
					pstmt_modify.setString(4,total_strength);
					pstmt_modify.setString(5,(String) modifyRecords.get("STRENGTH"));
					pstmt_modify.setString(6,strength_uom);
					pstmt_modify.setString(7,total_strength);				
					pstmt_modify.setString(8,(String) modifyRecords.get("ORDER_QTY"));
					pstmt_modify.setString(9,in_order_qty);
					pstmt_modify.setString(10,in_order_qty_uom);
					pstmt_modify.setString(11,(String) modifyRecords.get("ALLERGY_REMARKS"));
					pstmt_modify.setString(12,(String) modifyRecords.get("DOSE_REMARKS"));
					pstmt_modify.setString(13,(String) modifyRecords.get("CURRENTRX_REMARKS"));
					pstmt_modify.setString(14,reason_code); // AMEND_REASON_CODE
					pstmt_modify.setString(15,reason_desc); // AMEND_REASON
					pstmt_modify.setString(16,login_by_id);
					pstmt_modify.setString(17,login_at_ws_no);
					pstmt_modify.setString(18,login_facility_id);
					pstmt_modify.setString(19,(String) modifyRecords.get("BL_OVERRIDE_EXCL_INCL_IND"));
					pstmt_modify.setString(20,(String) modifyRecords.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"));
					pstmt_modify.setString(21,buildMAR_yn); //added for SRR20056-SCF-7882 -29157
					pstmt_modify.setString(22,login_by_id);//Added for ML-BRU-SCF-0098 [IN031837]
					pstmt_modify.setString(23,(String) modifyRecords.get("DRUG_INDICATION"));//Added for  ML-BRU-CRF-072[Inc:29938]DrugIndicationRemarks
					pstmt_modify.setString(24,(String) modifyRecords.get("PREG_REMARKS"));// added for CRF RUT-CRF-0063[29601] for MMS-SCF-0161 [IN:044909]
					pstmt_modify.setString(25,(String) modifyRecords.get("INTERACTION_REMARKS")); //MMS-KH-CRF-0029
					pstmt_modify.setString(26,(String) modifyRecords.get("LAB_INTERACTION_REMARKS")); //MMS-KH-CRF-0029
					pstmt_modify.setString(27,(String) modifyRecords.get("FOOD_INTERACTION_REMARKS")); //MMS-KH-CRF-0029
					//Added for IN:072715 start
					pstmt_modify.setString(28,(String) modifyRecords.get("ALLERGY_REMARKS_CODE"));
					pstmt_modify.setString(29,(String) modifyRecords.get("DOSE_REMARKS_CODE"));
					pstmt_modify.setString(30,(String) modifyRecords.get("CURRENTRX_REMARKS_CODE"));
					pstmt_modify.setString(31,(String) modifyRecords.get("INTERACTION_REMARKS_CODE"));
					pstmt_modify.setString(32,(String) modifyRecords.get("LAB_INTERACTION_REMARKS_CODE"));
					pstmt_modify.setString(33,(String) modifyRecords.get("FOOD_INTERACTION_REMARKS_CODE"));
					pstmt_modify.setString(34,(String) modifyRecords.get("ABUSE_OVERRIDE"));//ADDED FOR AAKH-CRF-0140
					pstmt_modify.setString(35,(String) modifyRecords.get("abuse_override_remarks"));//ADDED FOR AAKH-CRF-0140
					pstmt_modify.setString(36,(String) modifyRecords.get("DISEASE_INTERACTION_REMARKS"));//Added for MMS-DM-CRF-0229
					pstmt_modify.setString(37,(String) modifyRecords.get("DISEASE_INTERACTION_REMARKS_CODE"));//Added for MMS-DM-CRF-0229
					
					//Added for IN:072715 end
					pstmt_modify.setString(38,(String)refill_orders.get(i)); //index changed for ML-MMOH-SCF-1753
					pstmt_modify.setString(39,(String)refill_orders.get(i+1) );//index changed for ML-MMOH-SCF-1753
					pstmt_modify.addBatch();
				}
			}
			int[] result_modify_OLPH= pstmt_modify.executeBatch();
			closeStatement( pstmt_modify ) ;
			for (int i=0;i<result_modify_OLPH.length ;i++ ){
				if(result_modify_OLPH[i]<0  && result_modify_OLPH[i] != -2 ){
					modify_rec_1=false;
					break;
				}
				else{
					modify_rec_1=true;
				}
			}
			// end: update for refill(OR_ORDER_LINE_PH)
			//deleting and inserting of OR_ORDER_LINE_PH_SLD_SCALE table starts
			if(modify_rec_1 && ((ArrayList)modifyRecords.get("SLDSCALE_TMPL_DTL")).size()>0) {
				boolean del_ph_sld_scale			= false;
				pstmt_modify	= null;
				sql_string		=	"DELETE FROM OR_ORDER_LINE_PH_SLD_SCALE WHERE ORDER_ID=? and ORDER_LINE_NUM=?";
				pstmt_modify	=	connection.prepareStatement(sql_string) ;
				for(int i=0;i<presDetails.size();i++){
					modifyRecords	=	(HashMap) presDetails.get(i);
					amended_yn		=	(String)modifyRecords.get("AMENDED_YN");//added for ML-BRU-SCF-0725 [IN:038336]
					if(amended_yn==null || !amended_yn.equals("Y"))//added for ML-BRU-SCF-0725 [IN:038336]
						continue;
					pstmt_modify.setString(1,(String) modifyRecords.get("ORDER_ID")); //ORDER_ID //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
					pstmt_modify.setString(2,(String)modifyRecords.get("ORDER_LINE_NUM")); 
					pstmt_modify.addBatch();
				}
				result_modify_1= pstmt_modify.executeBatch();
				closeStatement( pstmt_modify ) ;
				for (int i=0;i<result_modify_1.length ;i++ ){
					if(result_modify_1[i]<0  && result_modify_1[i] != -2 ){
						del_ph_sld_scale=false;
						break;
					}
					else{
						del_ph_sld_scale=true;
					}
				}
				if(del_ph_sld_scale){
					//sql_string		=	PhRepository.getPhKeyValue("");
					sql_string		=	"insert into OR_ORDER_LINE_PH_SLD_SCALE (ORDER_ID, ORDER_LINE_NUM, TEMPLATE_ID, SRL_NO, RANGE_FROM, RANGE_TO, ADMIN_UNITS, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
					pstmt_modify	=	connection.prepareStatement(sql_string) ;
					ArrayList sldscale_tmpl_dtl = new ArrayList();
					for(int i=0;i<presDetails.size();i++){
						modifyRecords	=	(HashMap) presDetails.get(i);
						amended_yn		=	(String)modifyRecords.get("AMENDED_YN");//added for ML-BRU-SCF-0725 [IN:038336]
						if(amended_yn==null || !amended_yn.equals("Y"))//added for ML-BRU-SCF-0725 [IN:038336]
							continue;
						sldscale_tmpl_dtl = (ArrayList)(modifyRecords.get("SLDSCALE_TMPL_DTL"));
						for(int k=0; k<sldscale_tmpl_dtl.size(); k=k+5){
							pstmt_modify.setString(1,(String) modifyRecords.get("ORDER_ID")); //ORDER_ID //changed amendOrderID -(String) modifyRecords.get("ORDER_ID") for IN[032679]
							pstmt_modify.setString(2,(String)modifyRecords.get("ORDER_LINE_NUM")); //ORDER_LINE_NUM
							pstmt_modify.setString(3,(String)modifyRecords.get("TEMPLATE_ID")); //TEMPLATE_ID
							pstmt_modify.setString(4,(String)sldscale_tmpl_dtl.get(k)); //SRL_NO
							pstmt_modify.setString(5,(String)sldscale_tmpl_dtl.get(k+1)); //RANGE_FROM
							pstmt_modify.setString(6,(String)sldscale_tmpl_dtl.get(k+2)); //RANGE_TO
							pstmt_modify.setString(7,(String)sldscale_tmpl_dtl.get(k+3)); //ADMIN_UNITS
							pstmt_modify.setString(8,(String)sldscale_tmpl_dtl.get(k+4)); //REMARKS
							pstmt_modify.setString(9,login_by_id); //ADDED_BY_ID
							pstmt_modify.setString(10,login_at_ws_no); //ADDED_AT_WS_NO
							pstmt_modify.setString(11,login_facility_id); //ADDED_FACILITY_ID
							pstmt_modify.setString(12,login_by_id); //MODIFIED_BY_ID
							pstmt_modify.setString(13,login_at_ws_no); //MODIFIED_AT_WS_NO
							pstmt_modify.setString(14,login_facility_id); //MODIFIED_FACILITY_ID
							pstmt_modify.addBatch();
						}
					}
				}
				result_modify_1= pstmt_modify.executeBatch();
				closeStatement( pstmt_modify ) ;
				for (int i=0;i<result_modify_1.length ;i++ ){
					if(result_modify_1[i]<0  && result_modify_1[i] != -2 ){
						modify_rec_1=false;
						break;
					}
					else{
						modify_rec_1=true;
					}
				}
			}
			//deleting and inserting of OR_ORDER_LINE_PH_SLD_SCALE table end...
			// PH_PATIENT_DRUG_PROFILE starts
				
				if(modify_rec_2){
					pstmt_modify	=	null;
					sql_string				= "";                     
					drug_code="";                                   
					sch_strength	=	"";                            
					dosage_type = "";                              
					absol_qty = "";                                  
					prn_doses_pres_prn_fil="";                   
					fract_dose = "";                                 
					qty_value = "";                                  
					repeat_value = "";                              
					strength_per_value_per_pres_uom="";   
					strength_per_pres_uom = "";                
					pres_base_uom="";                             
					in_order_qty="";                                
					freq_nature = "";                                
					split_dose_yn	=	"N";
					str_date="";
					interval_value=1;
					//sql_string		=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY4");
					sql_string		=	"UPDATE PH_PATIENT_DRUG_PROFILE SET START_DATE=TO_DATE(?,'DD/MM/YYYY HH24:MI'), END_DATE=TO_DATE(?,'DD/MM/YYYY HH24:MI'),STRENGTH=?, PRESCRIBED_QTY=?, DURATION=?, DURN_TYPE=?,DOSAGE=?,  DOSAGE_UOM_CODE=?, SPLIT_DOSE_PREVIEW=?, FREQ_CODE=?,DIAG_TEXT=?, DRUG_REMARKS=?, BROUGHT_BY_PATIENT_YN=?, DIAG_CODE1=?, DIAG_CODE1_CAUSE_IND=?, DIAG_CODE1_SCHEME=?, DIAG_CODE2=?, DIAG_CODE2_CAUSE_IND=?, DIAG_CODE2_SCHEME=?, DIAG_CODE3=?, DIAG_CODE3_CAUSE_IND=?, DIAG_CODE3_SCHEME=?, PRESCRIBED_MODE=?, ALLERGY_OVERRIDE_REASON=?,DOSAGE_LIMIT_OVERRIDE_REASON=?,  DUPLICATE_DRUG_OVERRIDE_REASON =?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,AMENDED_YN=?, AMEND_BY_ID=?, AMEND_DATE_TIME=SYSDATE, PRN_REMARKS=?, CONTRAIND_OVERRIDE_REASON=?, INTERACTION_OVERRIDE_REASON=?,ROUTE_CODE=?, PRN_REMARKS_CODE=?,SPLIT_YN = ?,ABUSE_EXISTS=?,ABUSE_DRUG_OVERRIDE_REASON=? WHERE PATIENT_ID=? AND ORIG_ORDER_ID=? AND ORIG_ORDER_LINE_NO=?";
					pstmt_modify	=	connection.prepareStatement(sql_string) ;
					int col_cnt			=	1;
					durn_value = "";
					prn_remarks_values="";
					
					for(int i=0;i<presDetails.size();i++){
						modifyRecords	=	(HashMap) presDetails.get(i);
						col_cnt			=	1;
						sch_strength = "";
						prn_remarks_values = "";
						str_date = (String) modifyRecords.get("START_DATE_TIME");
						//if(!locale.equals("en"))
							//str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
						pstmt_modify.setString(col_cnt, str_date); // start_date_time
						str_date = (String) modifyRecords.get("END_DATE_TIME");
						//if(!locale.equals("en"))
							//str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
						pstmt_modify.setString(++col_cnt,str_date);//END_DATE_TIME
						drug_code = (String) modifyRecords.get("DRUG_CODE")==null?"":(String) modifyRecords.get("DRUG_CODE");
						freq_nature = (String) modifyRecords.get("FREQ_NATURE"); 

						if( ((String) modifyRecords.get("DOSAGE_TYPE")).equals("Q") && ((String) modifyRecords.get("STRENGTH"))!=null && !((String) modifyRecords.get("STRENGTH")).equals("0") && !((String) modifyRecords.get("STRENGTH")).equals("")){
							if(modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")!=null && !((String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")).equals("")){
								sch_strength	=	Math.ceil( (Float.parseFloat((String) modifyRecords.get("STRENGTH_PER_PRES_UOM")) / Float.parseFloat((String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")) ) * Float.parseFloat((String) modifyRecords.get("QTY_VALUE")))+"";
							}
							else
								sch_strength= (String) modifyRecords.get("ACT_STRENGTH_VALUE");
						} 
						else if (((String) modifyRecords.get("DOSAGE_TYPE")).equals("S"))	{
								sch_strength	=	(String) modifyRecords.get("STRENGTH");
						}
						if((((String) modifyRecords.get("DOSAGE_TYPE"))!=null && ((String) modifyRecords.get("DOSAGE_TYPE")).equals("A")) || (freq_nature!=null && freq_nature.equals("P"))){
								sch_strength	=	(String) modifyRecords.get("ACT_STRENGTH_VALUE");
						}
						dosage_type = (String) modifyRecords.get("DOSAGE_TYPE");             
						absol_qty = (String) modifyRecords.get("ABSOL_QTY")==null?"0":(String) modifyRecords.get("ABSOL_QTY");                 
						prn_doses_pres_prn_fil=(String) modifyRecords.get("PRN_DOSES_PRES_PRD_FILL")==null?"0":(String) modifyRecords.get("PRN_DOSES_PRES_PRD_FILL");  
						qty_value = (String) modifyRecords.get("QTY_VALUE");                 
						durn_value = (String) modifyRecords.get("FREQ_DURN_VALUE")==null?(String) modifyRecords.get("DURN_VALUE"):(String)modifyRecords.get("FREQ_DURN_VALUE");//taken freq_durn_value for IN21648 --28/05/2010 --priya 
						interval_value = Float.parseFloat((String) modifyRecords.get("INTERVAL_VALUE")==null?"1":(String) modifyRecords.get("INTERVAL_VALUE"));            
						repeat_value = (String) modifyRecords.get("REPEAT_VALUE");             
						strength_per_value_per_pres_uom=(String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM"); 
						strength_per_pres_uom = (String) modifyRecords.get("STRENGTH_PER_PRES_UOM");
						pres_base_uom = (String) modifyRecords.get("PRES_BASE_UOM");
						fract_dose = (String) modifyRecords.get("FRACT_DOSE_ROUND_UP_YN")==null?"N":(String) modifyRecords.get("FRACT_DOSE_ROUND_UP_YN");
						split_dose_yn = (String)modifyRecords.get("SPLIT_DOSE_YN")==null?"":(String)modifyRecords.get("SPLIT_DOSE_YN");
						if(split_dose_yn.equals("Y"))
							repeat_value="1";
						if(strength_per_pres_uom == null || strength_per_pres_uom.equals(""))
							strength_per_pres_uom="1";

						if( ((String) modifyRecords.get("FREQ_NATURE")).equals("P") ) {
							HashMap PRNRemarks = new HashMap();
							PRNRemarks = this.getPRNRemarks(drug_code);
							if(PRNRemarks != null && PRNRemarks.size()>0){
								prn_remarks_code = (String)PRNRemarks.get("prn_remarks_code")==null?"":(String)PRNRemarks.get("prn_remarks_code");
								prn_remarks_values = (String)PRNRemarks.get("prn_remarks_dtl")==null?"":(String)PRNRemarks.get("prn_remarks_dtl");
								//prn_remarks_values = (String)this.getPRNRemarks(drug_code)==null?"":(String)this.getPRNRemarks(drug_code);
							}
						}
						PreparedStatement pstmt_am_uom_eqvl	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53")) ;
						String equl_value = "1";
						pstmt_am_uom_eqvl.setString(1,pres_base_uom);
						pstmt_am_uom_eqvl.setString(2,(String)modifyRecords.get("QTY_DESC_CODE"));
						pstmt_am_uom_eqvl.setString(3,pres_base_uom);
						pstmt_am_uom_eqvl.setString(4,(String)modifyRecords.get("QTY_DESC_CODE"));
						resultSet	= pstmt_am_uom_eqvl.executeQuery();
						if ( resultSet != null && resultSet.next() ) {
							equl_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
						}
						closeResultSet( resultSet ) ;
						closeStatement( pstmt_am_uom_eqvl ) ;

						if((dosage_type!=null && dosage_type.equals("A")) || (freq_nature!=null && freq_nature.equals("P"))){
							in_order_qty=(String) modifyRecords.get("ORDER_QTY");
							//if(dosage_type.equals("A")) //commented for ARYU-SCF-0104
								//in_order_qty = (Float.parseFloat(in_order_qty) *  Float.parseFloat((String)modifyRecords.get("CONTENT_IN_PRES_BASE_UOM")))+"";
						}
						else if(dosage_type!=null && dosage_type.equals("Q")){
							if(fract_dose.equals("Y")){
								in_order_qty=/*Math.ceil*/(Float.parseFloat(qty_value)*Float.parseFloat(equl_value))*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)+""; // Math.ceil commented while fixing IN23884 --06/12/2010-- priya
							}
							else{
								in_order_qty=Float.parseFloat(qty_value)*Float.parseFloat(equl_value)*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)+"";
							}
						//	in_order_qty=(String) modifyRecords.get("ORDER_QTY");
						}
						else if(dosage_type!=null && dosage_type.equals("S")){
							if(fract_dose.equals("Y")){
								in_order_qty=((Float.parseFloat(qty_value)/Float.parseFloat(strength_per_pres_uom))*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))+"";
							}
							else{
								in_order_qty=((Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))/Float.parseFloat(strength_per_pres_uom))+"";
							}
							//in_order_qty=(String) modifyRecords.get("ORDER_QTY");
						}
						pstmt_modify.setString(++col_cnt,sch_strength);  // strength
						pstmt_modify.setString(++col_cnt,in_order_qty);  // prescribed qty
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DURN_VALUE")); 
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DURN_TYPE"));		
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("QTY_VALUE"));	// dosage	
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("QTY_UNIT"));	// dosage uom	
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("SPLIT_DOSE_PREVIEW"));
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("FREQ_CODE"));  // frequency
						diagText	=	"";
						if(diag_text.size()>0){
							diagText	=	(String)diag_text.get(3)+"~"+(String)diag_text.get(7)+"~"+(String)diag_text.get(11);
						}
						pstmt_modify.setString(++col_cnt,diagText);  // diag text
						pstmt_modify.setString(++col_cnt,"");  // drug remarks
						pstmt_modify.setString(++col_cnt,"N");  // brought by patient
						if(diag_text.size()>0){
							pstmt_modify.setString(++col_cnt,(String)diag_text.get(0));
							pstmt_modify.setString(++col_cnt,(String)diag_text.get(1));
							pstmt_modify.setString(++col_cnt,(String)diag_text.get(2));
							pstmt_modify.setString(++col_cnt,(String)diag_text.get(4));
							pstmt_modify.setString(++col_cnt,(String)diag_text.get(5));
							pstmt_modify.setString(++col_cnt,(String)diag_text.get(6));
							pstmt_modify.setString(++col_cnt,(String)diag_text.get(8));
							pstmt_modify.setString(++col_cnt,(String)diag_text.get(9));
							pstmt_modify.setString(++col_cnt,(String)diag_text.get(10));
						}
						else{
							pstmt_modify.setString(++col_cnt,"");
							pstmt_modify.setString(++col_cnt,"");
							pstmt_modify.setString(++col_cnt,"");
							pstmt_modify.setString(++col_cnt,"");
							pstmt_modify.setString(++col_cnt,"");
							pstmt_modify.setString(++col_cnt,"");
							pstmt_modify.setString(++col_cnt,"");
							pstmt_modify.setString(++col_cnt,"");
							pstmt_modify.setString(++col_cnt,"");
						}
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DOSAGE_TYPE"));  // dosage type
						if((String) modifyRecords.get("EXT_DDB_ALG_REASON") == null ||  ((String)modifyRecords.get("EXT_DDB_ALG_REASON")).equals(""))
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ALLERGY_REMARKS"));
						else
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("EXT_DDB_ALG_REASON"));
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DOSE_REMARKS"));
						if((String) modifyRecords.get("EXT_DDB_DUP_REASON") == null ||  ((String)modifyRecords.get("EXT_DDB_DUP_REASON")).equals(""))
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("CURRENTRX_REMARKS"));
						else
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("EXT_DDB_DUP_REASON"));
						pstmt_modify.setString(++col_cnt,login_by_id);
						pstmt_modify.setString(++col_cnt,login_at_ws_no);
						pstmt_modify.setString(++col_cnt,login_facility_id);
						pstmt_modify.setString(++col_cnt,"Y");
						pstmt_modify.setString(++col_cnt, (String) modifyRecords.get("ORD_PRACT_ID")); // login_by_id changed to ORD_PRACT_ID for  ML-BRU-SCF-0318
						pstmt_modify.setString(++col_cnt,prn_remarks_values);
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("CONTRAIND_OVERRIDE_REASON"));
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("INTERACTION_OVERRIDE_REASON"));
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ROUTE_CODE"));
						pstmt_modify.setString(++col_cnt,prn_remarks_code);
						pstmt_modify.setString(++col_cnt,split_dose_yn);  //added for IN21602 --26/05/2010 -- priya
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ABUSE_OVERRIDE"));//ADDED FOR AAKH-CRF-0140
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("abuse_override_remarks")); //ADDED FOR AAKH-CRF-0140
						
						pstmt_modify.setString(++col_cnt,(String)modifyRecords.get("PATIENT_ID"));
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ORDER_ID")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
						pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ORDER_LINE_NUM"));
						pstmt_modify.addBatch();
					}
				
					int[] result_modify_3= pstmt_modify.executeBatch();
					closeStatement( pstmt_modify ) ;
					for (int i=0;i<result_modify_3.length ;i++ ){
						if(result_modify_3[i]<0  && result_modify_3[i] != -2 ){
							modify_rec_3=false;
							break;
						}
						else{
						modify_rec_3=true;
						}
					}
				}
				// PH_PATIENT_DRUG_PROFILE ends
				// start: updating refill order in PH_PATIENT_DRUG_PROFILE
				if(modify_rec_2){
					pstmt_modify	=	null;
					sql_string				= "";                     
					drug_code="";                                   
					sch_strength	=	"";                            
					dosage_type = "";                              
					absol_qty = "";                                  
					prn_doses_pres_prn_fil="";                   
					fract_dose = "";                                 
					qty_value = "";                                  
					repeat_value = "";                              
					strength_per_value_per_pres_uom="";   
					strength_per_pres_uom = "";                
					pres_base_uom="";                             
					in_order_qty="";                                
					freq_nature = "";                                
					split_dose_yn	=	"N";
					str_date="";
					interval_value=1;
					//sql_string		=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY4");
					//ABUSE_EXISTS,ABUSE_DRUG_OVERRIDE_REASON added for AAKH-CRF-0140
					sql_string		=	"UPDATE PH_PATIENT_DRUG_PROFILE SET START_DATE=TO_DATE(?,'DD/MM/YYYY HH24:MI'), END_DATE=TO_DATE(?,'DD/MM/YYYY HH24:MI'),STRENGTH=?, PRESCRIBED_QTY=ceil(?), DURATION=?, DURN_TYPE=?,DOSAGE=?,  DOSAGE_UOM_CODE=?, SPLIT_DOSE_PREVIEW=?, FREQ_CODE=?,DIAG_TEXT=?, DRUG_REMARKS=?, BROUGHT_BY_PATIENT_YN=?, DIAG_CODE1=?, DIAG_CODE1_CAUSE_IND=?, DIAG_CODE1_SCHEME=?, DIAG_CODE2=?, DIAG_CODE2_CAUSE_IND=?, DIAG_CODE2_SCHEME=?, DIAG_CODE3=?, DIAG_CODE3_CAUSE_IND=?, DIAG_CODE3_SCHEME=?, PRESCRIBED_MODE=?, ALLERGY_OVERRIDE_REASON=?,DOSAGE_LIMIT_OVERRIDE_REASON=?,  DUPLICATE_DRUG_OVERRIDE_REASON =?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,AMENDED_YN=?, AMEND_BY_ID=?, AMEND_DATE_TIME=SYSDATE, PRN_REMARKS=?, CONTRAIND_OVERRIDE_REASON=?, INTERACTION_OVERRIDE_REASON=?,ROUTE_CODE=? ,PRN_REMARKS_CODE=?  ,ABUSE_EXISTS=?,ABUSE_DRUG_OVERRIDE_REASON=? WHERE PATIENT_ID=? AND ORIG_ORDER_ID=? AND ORIG_ORDER_LINE_NO=?";
					pstmt_modify	=	connection.prepareStatement(sql_string) ;
					int col_cnt			=	1;
					durn_value = "";
					prn_remarks_values="";
					ordToPresBaseConv = new Float(1.0);
					for(int i=0;i<refill_orders.size();i+=3){
						if(presDetails.size()>0 && refill_orders.size()>0) {
							refill_drug_code = (String)refill_orders.get(i+2);
							for(int j=0; j<presDetails.size(); j++){
								modifyRecords	=	(HashMap) presDetails.get(j);
								drug_code = (String) modifyRecords.get("DRUG_CODE");
								//ordToPresBaseConv = Float.parseFloat((String)orderToPresBaseConv.get(j));
								if(refill_drug_code.equals(drug_code)){
									break;
								}
							}
							col_cnt			=	1;
							sch_strength = "";
							freq_nature = (String) modifyRecords.get("FREQ_NATURE");  
							if(i==0) {
								str_date		=	(String) modifyRecords.get("END_DATE_TIME");
							} 
							else {
								str_date		=	end_date;
							}
							//if(!locale.equals("en"))
								//str_date = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",locale,"en");
							durn_value		=	(String) modifyRecords.get("DURN_VALUE");
							durn_type		=	(String) modifyRecords.get("DURN_TYPE");
							end_date		=	populateEndDate(freq_nature,str_date,durn_value,durn_type);//Changed start_date as str_date for MMS-BETA-0044 
							//if(!locale.equals("en"))
								//end_date = com.ehis.util.DateUtils.convertDate(end_date, "DMYHM",locale,"en");
							drug_code = (String) modifyRecords.get("DRUG_CODE")==null?"":(String) modifyRecords.get("DRUG_CODE");
							if( ((String) modifyRecords.get("DOSAGE_TYPE")).equals("Q") && ((String) modifyRecords.get("STRENGTH"))!=null && !((String) modifyRecords.get("STRENGTH")).equals("0") && !((String) modifyRecords.get("STRENGTH")).equals("")){
								if(modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")!=null && !((String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")).equals("")){
									sch_strength	=	Math.ceil( (Float.parseFloat((String) modifyRecords.get("STRENGTH_PER_PRES_UOM")) / Float.parseFloat((String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")) ) * Float.parseFloat((String) modifyRecords.get("QTY_VALUE")))+"";
								}
								else
									sch_strength= (String) modifyRecords.get("ACT_STRENGTH_VALUE");
							} 
							else if (((String) modifyRecords.get("DOSAGE_TYPE")).equals("S"))	{
									sch_strength	=	(String) modifyRecords.get("STRENGTH");
							}
							if((((String) modifyRecords.get("DOSAGE_TYPE"))!=null && ((String) modifyRecords.get("DOSAGE_TYPE")).equals("A")) || (freq_nature!=null && freq_nature.equals("P"))){
									sch_strength	=	(String) modifyRecords.get("ACT_STRENGTH_VALUE");
							}
							dosage_type = (String) modifyRecords.get("DOSAGE_TYPE");  
							//freq_nature = (String) modifyRecords.get("FREQ_NATURE");              
							absol_qty = (String) modifyRecords.get("ABSOL_QTY")==null?"0":(String) modifyRecords.get("ABSOL_QTY");                 
							prn_doses_pres_prn_fil=(String) modifyRecords.get("PRN_DOSES_PRES_PRD_FILL")==null?"0":(String) modifyRecords.get("PRN_DOSES_PRES_PRD_FILL");  
							qty_value = (String) modifyRecords.get("QTY_VALUE");                 
							interval_value = Float.parseFloat((String) modifyRecords.get("INTERVAL_VALUE")==null?"1":(String) modifyRecords.get("INTERVAL_VALUE"));            
							repeat_value = (String) modifyRecords.get("REPEAT_VALUE");             
							strength_per_value_per_pres_uom=(String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM"); 
							strength_per_pres_uom = (String) modifyRecords.get("STRENGTH_PER_PRES_UOM");
							pres_base_uom = (String) modifyRecords.get("PRES_BASE_UOM");
							fract_dose = (String) modifyRecords.get("FRACT_DOSE_ROUND_UP_YN")==null?"N":(String) modifyRecords.get("FRACT_DOSE_ROUND_UP_YN");
							split_dose_yn = (String)modifyRecords.get("SPLIT_DOSE_YN")==null?"":(String)modifyRecords.get("SPLIT_DOSE_YN");
							if(split_dose_yn.equals("Y"))
								repeat_value="1";
							if(strength_per_pres_uom == null || strength_per_pres_uom.equals(""))
								strength_per_pres_uom="1";
							if( ((String) modifyRecords.get("FREQ_NATURE")).equals("P") ) {
								HashMap PRNRemarks = new HashMap();
								PRNRemarks = this.getPRNRemarks(drug_code);
								prn_remarks_code = (String)PRNRemarks.get("prn_remarks_code")==null?"":(String)PRNRemarks.get("prn_remarks_code");
								prn_remarks_values = (String)PRNRemarks.get("prn_remarks_dtl")==null?"":(String)PRNRemarks.get("prn_remarks_dtl");
								//prn_remarks_values = (String)this.getPRNRemarks(drug_code)==null?"":(String)this.getPRNRemarks(drug_code);
							}
							if((dosage_type!=null && dosage_type.equals("A")) || (freq_nature!=null && freq_nature.equals("P"))){
								in_order_qty=(String) modifyRecords.get("ORDER_QTY");
							}
							else if(dosage_type!=null && dosage_type.equals("Q")){
								if(fract_dose.equals("Y")){
									//*Math.ceil(ordToPresBaseConv)
									in_order_qty=Math.ceil(Float.parseFloat(qty_value))*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)+"";
								}
								else{
									//ordToPresBaseConv
									in_order_qty=Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)+"";
								}
							}
							else if(dosage_type!=null && dosage_type.equals("S")){
								if(fract_dose.equals("Y")){
									in_order_qty=(Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_per_pres_uom))*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))+"";
								}
								else{
									in_order_qty=((Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/interval_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))/Float.parseFloat(strength_per_pres_uom))+"";
								}
							}
							pstmt_modify.setString(col_cnt, str_date); // start_date_time
							pstmt_modify.setString(++col_cnt,end_date);//END_DATE_TIME
							pstmt_modify.setString(++col_cnt,sch_strength);  // strength
							pstmt_modify.setString(++col_cnt,in_order_qty);  // prescribed qty
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DURN_VALUE")); 
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DURN_TYPE"));		
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("QTY_VALUE"));	// dosage	
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("QTY_UNIT"));	// dosage uom	
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("SPLIT_DOSE_PREVIEW"));
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("FREQ_CODE"));  // frequency
							diagText	=	"";
							if(diag_text.size()>0){
								diagText	=	(String)diag_text.get(3)+"~"+(String)diag_text.get(7)+"~"+(String)diag_text.get(11);
							}
							pstmt_modify.setString(++col_cnt,diagText);  // diag text
							pstmt_modify.setString(++col_cnt,"");  // drug remarks
							pstmt_modify.setString(++col_cnt,"N");  // brought by patient
							if(diag_text.size()>0){
								pstmt_modify.setString(++col_cnt,(String)diag_text.get(0));
								pstmt_modify.setString(++col_cnt,(String)diag_text.get(1));
								pstmt_modify.setString(++col_cnt,(String)diag_text.get(2));
								pstmt_modify.setString(++col_cnt,(String)diag_text.get(4));
								pstmt_modify.setString(++col_cnt,(String)diag_text.get(5));
								pstmt_modify.setString(++col_cnt,(String)diag_text.get(6));
								pstmt_modify.setString(++col_cnt,(String)diag_text.get(8));
								pstmt_modify.setString(++col_cnt,(String)diag_text.get(9));
								pstmt_modify.setString(++col_cnt,(String)diag_text.get(10));
							}
							else{
								pstmt_modify.setString(++col_cnt,"");
								pstmt_modify.setString(++col_cnt,"");
								pstmt_modify.setString(++col_cnt,"");
								pstmt_modify.setString(++col_cnt,"");
								pstmt_modify.setString(++col_cnt,"");
								pstmt_modify.setString(++col_cnt,"");
								pstmt_modify.setString(++col_cnt,"");
								pstmt_modify.setString(++col_cnt,"");
								pstmt_modify.setString(++col_cnt,"");
							}
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DOSAGE_TYPE"));  // dosage type
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ALLERGY_REMARKS"));
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("DOSE_REMARKS"));
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("CURRENTRX_REMARKS"));
							pstmt_modify.setString(++col_cnt,login_by_id);
							pstmt_modify.setString(++col_cnt,login_at_ws_no);
							pstmt_modify.setString(++col_cnt,login_facility_id);
							pstmt_modify.setString(++col_cnt,"Y");
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ORD_PRACT_ID")); // login_by_id changed to ORD_PRACT_ID for  ML-BRU-SCF-0318
							pstmt_modify.setString(++col_cnt,prn_remarks_values);
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("CONTRAIND_OVERRIDE_REASON"));
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("INTERACTION_OVERRIDE_REASON"));
							pstmt_modify.setString(++col_cnt,(String) modifyRecords.get("ROUTE_CODE"));
							pstmt_modify.setString(++col_cnt,prn_remarks_code);
							pstmt_modify.setString(++col_cnt,(String)modifyRecords.get("PATIENT_ID"));
							pstmt_modify.setString(++col_cnt,(String)refill_orders.get(i));
							pstmt_modify.setString(++col_cnt,(String) refill_orders.get(i+1));
							pstmt_modify.addBatch();
						}
					}
					int[] result_modify_3= pstmt_modify.executeBatch();
					closeStatement( pstmt_modify ) ;
					for (int i=0;i<result_modify_3.length ;i++ ){
						if(result_modify_3[i]<0  && result_modify_3[i] != -2 ){
							modify_rec_3=false;
							break;
						}
						else{
						modify_rec_3=true;
						}
					}
				}
				// end: updating refill order in PH_PATIENT_DRUG_PROFILE
				// OR_ORDER_COMMENT INSERT STARTS
				pstmt_modify	=	null;			
				sql_string		= (String)PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56");
				pstmt_modify	= connection.prepareStatement(sql_string) ;
				pstmt_modify.setString(1,(String) modifyRecords.get("ORDER_ID")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
				resultSet		= pstmt_modify.executeQuery();
				if(resultSet!=null && resultSet.next()){
					action_seq_num	=	resultSet.getString(1);
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_modify ) ;

				String order_remarks	=	"";
				order_remarks	=	getPresRemarks();
				if((order_remarks!= null) && (!order_remarks.equals(""))){
					sql_string		= (String)PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5");
					pstmt_insert		= connection.prepareStatement(sql_string) ;
					pstmt_insert.setString(1,(String) modifyRecords.get("ORDER_ID")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
					pstmt_insert.setString(2,action_seq_num);
					pstmt_insert.setString(3,login_by_id);
					pstmt_insert.setString(4,login_at_ws_no);
					pstmt_insert.setString(5,login_facility_id);
					pstmt_insert.setString(6,login_by_id);
					pstmt_insert.setString(7,login_at_ws_no);
					pstmt_insert.setString(8,login_facility_id);
					rows = pstmt_insert.executeUpdate() ;
					closeStatement( pstmt_insert ) ;
					if(rows>0){
						sql_string		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57");
						pstmt_clob		= connection.prepareStatement(sql_string) ;
						pstmt_clob.setString(1,(String) modifyRecords.get("ORDER_ID")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
						pstmt_clob.setString(2,action_seq_num);
						resultSet		= pstmt_clob.executeQuery();
						Clob clb = null;
						BufferedWriter bw = null;
						while(resultSet!=null && resultSet.next())	{
							clb 			= (Clob) resultSet.getClob(1);
							bw 	= new BufferedWriter(clb.setCharacterStream(0));
							bw.write(order_remarks,0,order_remarks.length());
							bw.flush();
							bw.close();
						}
						closeResultSet( resultSet ) ;
						closeStatement( pstmt_clob ) ;
					}
				}
				// OR_ORDER_COMMENT INSERT ENDS
				// OR_ORDER_LINE_FIELD_VALUES INSERT STARTS ===== DRUG REMARKS
				int order_format_count	=	0;
				boolean entered			=	false;
				modify_rec_4			=	true;
				String  order_id, order_lune_num;
				pstmt_modify	=	null;
				sql_string		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT_FILED_VALUES");
				pstmt_modify	= connection.prepareStatement(sql_string) ;
				if(DrugRemarks!=null && DrugRemarks.size()>0){
					for(int p=0;p<presDetails.size();p++){
						modifyRecords	=	(HashMap) presDetails.get(p);
						order_id =(String)modifyRecords.get("ORDER_ID") ;
						order_lune_num = (String)modifyRecords.get("ORDER_LINE_NUM");
						for (int i=0;i<DrugRemarks.size() ;i++ ){
							DrugValues	=	(HashMap)DrugRemarks.get(i);
							//System.out.println("DrugValues"+DrugValues);
							//System.out.println("ext_srl_no"+(String)DrugValues.get("ext_srl_no"));
							if(getDispLocnCatg().equals("O")){//Added For  SKR-SCF-1706 Start
								if( getCalledFromAmend().equals("PH") && Integer.parseInt(order_lune_num)>1)
									{
									String EXT_SEQ_NO=(String)DrugValues.get("ext_srl_no");
									int INT_EXT_SEQ_NO=Integer.parseInt(EXT_SEQ_NO);
									INT_EXT_SEQ_NO=INT_EXT_SEQ_NO+1;
									
									if(!(order_id.equals((String)DrugValues.get("order_id")) && order_lune_num.equals(""+INT_EXT_SEQ_NO))){
										System.out.println("if");
										continue;
									}
									}
								else
									{
									if(!(order_id.equals((String)DrugValues.get("order_id")) && order_lune_num.equals((String)DrugValues.get("ext_srl_no")))){
										System.out.println("else if");
										continue;
									}
									}
							}
							else{
								{
									if(!(order_id.equals((String)DrugValues.get("order_id")) && order_lune_num.equals((String)DrugValues.get("ext_srl_no")))){
										System.out.println("else");
										continue;
									}
								}
							}//Added For  SKR-SCF-1706 END
							/*if(!(order_id.equals((String)DrugValues.get("order_id")) && order_lune_num.equals((String)DrugValues.get("ext_srl_no")))){
								System.out.println("if");
								continue;
							}*/
							total_seq	=	(String)DrugValues.get("order_format_count") ;
							order_format_count	=Integer.parseInt(total_seq);
							if(order_format_count!=0){
								for(int k=0;k<order_format_count;k++){
									entered	=	true;
									pstmt_modify.setString(1,"S");
									pstmt_modify.setString(2,""+(k+1));
									pstmt_modify.setString(3,(String)DrugValues.get("field_mnemonic"+k));
									pstmt_modify.setString(4,(String)DrugValues.get("field_type"+k));
									pstmt_modify.setString(5,(String)DrugValues.get("label_text"+k));
									pstmt_modify.setString(6,(String)DrugValues.get("field_values"+k));
									pstmt_modify.setString(7,"");
									pstmt_modify.setString(8,"");
									pstmt_modify.setString(9,(String)DrugValues.get("accept_option"+k));
									pstmt_modify.setString(10,login_by_id);
									pstmt_modify.setString(11,login_at_ws_no);
									pstmt_modify.setString(12,login_facility_id); 
									pstmt_modify.setString(13,login_by_id);
									pstmt_modify.setString(14,login_at_ws_no);
									pstmt_modify.setString(15,login_facility_id); 
									pstmt_modify.setString(16,(String)DrugValues.get("order_id"));
									//pstmt_modify.setString(17,""+(i+1));//Commented for ICN:34834_1
									if(getDispLocnCatg().equals("O")){//Added For ICN:34834_1-Start//OP CHANGED TO O FOR SKR-SCF-1706
										if( getCalledFromAmend().equals("PH"))
											pstmt_modify.setString(17,getOrderLineNumber());
										else
											pstmt_modify.setString(17,(String)DrugValues.get("ext_srl_no"));
									}
									else{
										 pstmt_modify.setString(17,""+(i+1));
									}//Added For ICN:34834_1-End
									pstmt_modify.addBatch();
								}
							}
						}
					}
					if(entered) {	
						int[] result_modify_4= pstmt_modify.executeBatch();
						closeStatement( pstmt_modify ) ;
						for (int i=0;i<result_modify_4.length ;i++ ){
							if(result_modify_4[i]<0  && result_modify_4[i] != -2 ){
								modify_rec_4=false;
								break;
							}
							else{
								modify_rec_4=true;
							}
						}
					}
				}
				// Schedule values insert - OR_ORDER_LINE_FIELD_VALUES starts
				boolean freq_values_found			= false;	
				pstmt_modify	=	null;
				//sql_string		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT_FILED_VALUES");
				sql_string		= "INSERT INTO OR_ORDER_LINE_FIELD_VALUES(ORDER_LINE_FIELD_LEVEL, ORDER_LINE_SEQ_NUM, ORDER_LINE_FIELD_MNEMONIC, ORDER_LINE_FIELD_TYPE, ORDER_LINE_LABEL_TEXT, ORDER_LINE_FIELD_VALUE, ORDER_LINE_DOSE_QTY_VALUE, ORDER_LINE_DOSE_QTY_UNIT, ACCEPT_OPTION, ORDER_LINE_FREQ_DAY,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,ORDER_ID,ORDER_LINE_NUM) VALUES(?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)";
				pstmt_modify	= connection.prepareStatement(sql_string) ;
				HashMap freq_char_list	 = null;	
				ArrayList day_list		 = null;
				ArrayList day_names		 = null;
				ArrayList time_list		 = null;
				ArrayList dose_list		 = null;
				String tmp_sch_dt, tmp_sch_time, sch_date_time="", sch_start_date_time;
				HashMap schd_week_hr_dates	=	null;
				ArrayList schd_date_time	=	null;
				int seqNo			=	200;
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Calendar cal = Calendar.getInstance(); 
				for(int i=0;i<presDetails.size();i++){
					modifyRecords	=	(HashMap) presDetails.get(i);
					amended_yn		=	(String)modifyRecords.get("AMENDED_YN");//added for ML-BRU-SCF-0725 [IN:038336]
					if(amended_yn==null || !amended_yn.equals("Y"))//added for ML-BRU-SCF-0725 [IN:038336]
						continue;
					frequencyValues	=	null;
					if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0) {
						
						if(chkValuescheduleFrequency.containsKey((String) modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO")))
							frequencyValues = (ArrayList) chkValuescheduleFrequency.get((String) modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO"));
					}
					if(frequencyValues!=null && frequencyValues.size()>0) {
						freq_char_list	= (HashMap)frequencyValues.get(0);
						day_list		= (ArrayList)frequencyValues.get(1);
						day_names		= (ArrayList)frequencyValues.get(2);
						time_list		= (ArrayList)frequencyValues.get(3);
						dose_list		= (ArrayList)frequencyValues.get(4);
						seqNo			=	200;
						//for(int n=0;n<frequencyValues.size();n++) {
						for(int n=0;n<day_list.size();n++) {
							freq_values_found	= true;
							 ++seqNo;
								
							//data=(HashMap)frequencyValues.get(n);
							pstmt_modify.setString(1,"S");
							pstmt_modify.setString(2,""+(seqNo));
							pstmt_modify.setString(3, "SCHED_ADMIN_TIME");
							pstmt_modify.setString(4,"C");
							pstmt_modify.setString(5,"D");
							//pstmt_modify.setString(6,(String)data.get("admin_time"));
							//pstmt_modify.setString(7,(String)data.get("admin_qty"));
							pstmt_modify.setString(6,(String)time_list.get(n));
							pstmt_modify.setString(7,(String)dose_list.get(n));
							pstmt_modify.setString(8,(String)modifyRecords.get("QTY_UNIT"));
							pstmt_modify.setString(9,"O");
							pstmt_modify.setInt(10,Integer.parseInt(day_list.get(n)+""));
							pstmt_modify.setString(11,login_by_id);
							pstmt_modify.setString(12,login_at_ws_no);
							pstmt_modify.setString(13,login_facility_id);
							pstmt_modify.setString(14,login_by_id);
							pstmt_modify.setString(15,login_at_ws_no);
							pstmt_modify.setString(16,login_facility_id);
							pstmt_modify.setString(17,(String) modifyRecords.get("ORDER_ID")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
							pstmt_modify.setString(18,(String) modifyRecords.get("ORDER_LINE_NUM"));
							pstmt_modify.addBatch();
						}
					}
					else{ //for interval frequency Code added for IN20564 --06/07/2010-- priya
						freq_values_found = true;
						tmp_sch_dt = "";
						tmp_sch_time = "";
						sch_date_time = "";
						seqNo			=	200;
						sch_start_date_time = "";
						schd_week_hr_dates  = getSchdDatesFrWeekHr(chkValuescheduleFrequency,presDetails,"UPDATE");

						schd_date_time	=	(ArrayList)schd_week_hr_dates.get((String)modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO")); //added +(String) modifyRecords.get("SRL_NO") for IN24521 --18/10/2010-- priya
						if(schd_date_time != null && schd_date_time.size()>0){
							sch_start_date_time = (String)schd_date_time.get(0);
							cal.setTime( dateFormat.parse( sch_start_date_time ) ); 
							cal.add( Calendar.DATE, 1 ); 
							sch_start_date_time = dateFormat.format(cal.getTime()); 
							for(int scdDt=0; scdDt<schd_date_time.size();scdDt++){
								sch_date_time = (String)schd_date_time.get(scdDt);
								if((!sch_date_time.equals("")) && (sch_date_time != null)){
										tmp_sch_dt    = sch_date_time.substring(0,10);
										tmp_sch_time = sch_date_time.substring(11,16);
										if(!tmp_sch_time.equals("")&&(tmp_sch_time!=null) && ( ((java.util.Date)dateFormat.parse(sch_date_time)).compareTo((java.util.Date)dateFormat.parse(sch_start_date_time)) < 0   )){
											freq_values_found = true;
											 ++seqNo;
											pstmt_modify.setString(1,"S");
											pstmt_modify.setString(2,""+(seqNo));
											pstmt_modify.setString(3, "SCHED_ADMIN_TIME");
											pstmt_modify.setString(4,"C");
											pstmt_modify.setString(5,"D");
											pstmt_modify.setString(6,tmp_sch_time);
											pstmt_modify.setString(7,(String) modifyRecords.get("QTY_VALUE"));
											pstmt_modify.setString(8,(String)modifyRecords.get("QTY_UNIT"));
											pstmt_modify.setString(9,"O");
											pstmt_modify.setInt(10,0);
											pstmt_modify.setString(11,login_by_id);
											pstmt_modify.setString(12,login_at_ws_no);
											pstmt_modify.setString(13,login_facility_id);
											pstmt_modify.setString(14,login_by_id);
											pstmt_modify.setString(15,login_at_ws_no);
											pstmt_modify.setString(16,login_facility_id);
											pstmt_modify.setString(17,(String) modifyRecords.get("ORDER_ID")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
											pstmt_modify.setString(18,(String) modifyRecords.get("ORDER_LINE_NUM"));
											pstmt_modify.addBatch();
										}
										else if(((java.util.Date)dateFormat.parse(sch_date_time)).compareTo((java.util.Date)dateFormat.parse(sch_start_date_time)) >= 0 ){
											break;
										}
									}
								}
							}
					} //Code added for IN20564 -end
				}
				if( freq_values_found ) {
					int[] result_insert_8= pstmt_modify.executeBatch();
					closeStatement( pstmt_modify ) ;
					for (int i=0;i<result_insert_8.length ;i++ ){
						if(result_insert_8[i]<0  && result_insert_8[i] != -2 ){
							modify_rec_4=false;
							break;
						}
						else{
							modify_rec_4=true;
						}
					}
				}
				else {
						modify_rec_4=true;
				}
				// Schedule values insert - OR_ORDER_LINE_FIELD_VALUES ends
				// OR_ORDER_LINE_FIELD_VALUES INSERT ENDS
//OR_ORDER_LINES_FIELD_VALUES indert start for ReFill Order
			if(modify_rec_4){
				if(refill_orders.size()>0){ 
				pstmt_modify	= connection.prepareStatement(sql_string) ;
				for(int i=0;i<refill_orders.size();i+=3)
				{
					modifyRecords	=	(HashMap) presDetails.get(i);
					amended_yn		=	(String)modifyRecords.get("AMENDED_YN");
					if(amended_yn==null || !amended_yn.equals("Y"))
						continue;
					frequencyValues	=	null;
					if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0) {
						
						if(chkValuescheduleFrequency.containsKey((String) modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO")))
							frequencyValues = (ArrayList) chkValuescheduleFrequency.get((String) modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO"));
					}
					if(frequencyValues!=null && frequencyValues.size()>0) {
						freq_char_list	= (HashMap)frequencyValues.get(0);
						day_list		= (ArrayList)frequencyValues.get(1);
						day_names		= (ArrayList)frequencyValues.get(2);
						time_list		= (ArrayList)frequencyValues.get(3);
						dose_list		= (ArrayList)frequencyValues.get(4);
						seqNo			=	200;
						for(int n=0;n<day_list.size();n++) {
							freq_values_found	= true;
							 ++seqNo;
								
							pstmt_modify.setString(1,"S");
							pstmt_modify.setString(2,""+(seqNo));
							pstmt_modify.setString(3, "SCHED_ADMIN_TIME");
							pstmt_modify.setString(4,"C");
							pstmt_modify.setString(5,"D");
							pstmt_modify.setString(6,(String)time_list.get(n));
							pstmt_modify.setString(7,(String)dose_list.get(n));
							pstmt_modify.setString(8,(String)modifyRecords.get("QTY_UNIT"));
							pstmt_modify.setString(9,"O");
							pstmt_modify.setInt(10,Integer.parseInt(day_list.get(n)+""));
							pstmt_modify.setString(11,login_by_id);
							pstmt_modify.setString(12,login_at_ws_no);
							pstmt_modify.setString(13,login_facility_id);
							pstmt_modify.setString(14,login_by_id);
							pstmt_modify.setString(15,login_at_ws_no);
							pstmt_modify.setString(16,login_facility_id);
							pstmt_modify.setString(17,(String)refill_orders.get(i)); 
							pstmt_modify.setString(18,(String)refill_orders.get(i+1));
							pstmt_modify.addBatch();
						}
					}
					else{ 
						freq_values_found = true;
						tmp_sch_dt = "";
						tmp_sch_time = "";
						sch_date_time = "";
						seqNo			=	200;
						sch_start_date_time = "";
						schd_week_hr_dates  = getSchdDatesFrWeekHr(chkValuescheduleFrequency,presDetails,"UPDATE");
						schd_date_time	=	(ArrayList)schd_week_hr_dates.get((String)modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO")); 
						if(schd_date_time != null && schd_date_time.size()>0){
							sch_start_date_time = (String)schd_date_time.get(0);
							cal.setTime( dateFormat.parse( sch_start_date_time ) ); 
							cal.add( Calendar.DATE, 1 ); 
							sch_start_date_time = dateFormat.format(cal.getTime()); 
							for(int scdDt=0; scdDt<schd_date_time.size();scdDt++){
								sch_date_time = (String)schd_date_time.get(scdDt);
								if((!sch_date_time.equals("")) && (sch_date_time != null)){
										tmp_sch_dt    = sch_date_time.substring(0,10);
										tmp_sch_time = sch_date_time.substring(11,16);
										if(!tmp_sch_time.equals("")&&(tmp_sch_time!=null) && ( ((java.util.Date)dateFormat.parse(sch_date_time)).compareTo((java.util.Date)dateFormat.parse(sch_start_date_time)) < 0   )){
											freq_values_found = true;
											 ++seqNo;
											pstmt_modify.setString(1,"S");
											pstmt_modify.setString(2,""+(seqNo));
											pstmt_modify.setString(3, "SCHED_ADMIN_TIME");
											pstmt_modify.setString(4,"C");
											pstmt_modify.setString(5,"D");
											pstmt_modify.setString(6,tmp_sch_time);
											pstmt_modify.setString(7,(String) modifyRecords.get("QTY_VALUE"));
											pstmt_modify.setString(8,(String)modifyRecords.get("QTY_UNIT"));
											pstmt_modify.setString(9,"O");
											pstmt_modify.setInt(10,0);
											pstmt_modify.setString(11,login_by_id);
											pstmt_modify.setString(12,login_at_ws_no);
											pstmt_modify.setString(13,login_facility_id);
											pstmt_modify.setString(14,login_by_id);
											pstmt_modify.setString(15,login_at_ws_no);
											pstmt_modify.setString(16,login_facility_id);
											pstmt_modify.setString(17,(String)refill_orders.get(i)); 
											pstmt_modify.setString(18,(String)refill_orders.get(i+1));
											pstmt_modify.addBatch();
										}
										else if(((java.util.Date)dateFormat.parse(sch_date_time)).compareTo((java.util.Date)dateFormat.parse(sch_start_date_time)) >= 0 ){
											break;
										}
									}
								}
							}
					} 
				}

					int[] result_modify_9= pstmt_modify.executeBatch();
					closeStatement( pstmt_modify ) ;
					for (int i=0;i<result_modify_9.length ;i++ ){
						if(result_modify_9[i]<0  && result_modify_9[i] != -2 ){
							modify_rec_4=false;
							break;
						}
						else{
							modify_rec_4=true;
						}
					}
				}
			}
	//or_order_line_fiel_values insert end for refill order - BSP-SCF-0062

 
				// PH_MEDN_ADMIN INSERT STARTS
				String med_admin_reqd_yn="",verf_reqd_bef_med_admin_yn="",stat_sch_time="",qty_unit="",equal_value="",in_order_uom="", fr_drug_code="";
				sch_strength					=	"";
				//HashMap data						=	null;
				ArrayList unique_schedules			=	new ArrayList();
				ArrayList tmp_drugs					=	new ArrayList();
				int duration	=	0;
				ArrayList stat_time		=	new ArrayList();
				boolean contains_stat = false;
				PreparedStatement pstmt_ph_drug_vw	 = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT64")) ;
				PreparedStatement pstmt_am_uom_eqvl   = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53")) ;
				int dose_seq_no = 1;
				order_id = amendOrderID;
				ArrayList stat_dtls  =	new ArrayList();
				pstmt_modify	=	null;
				sql_string		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT25A");
				pstmt_modify	= connection.prepareStatement(sql_string) ;
				pstmt_modify.setString(1,login_facility_id);

				resultSet	= pstmt_modify.executeQuery();
				if ( resultSet != null && resultSet.next() ) {
					med_admin_reqd_yn			= resultSet.getString("MED_ADMIN_REQD_YN")==null ? "N":resultSet.getString("MED_ADMIN_REQD_YN");
					verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_modify ) ;
				//if(getPatientClass().equals("IP") && med_admin_reqd_yn.equals("Y")){
				if( med_admin_reqd_yn!=null && med_admin_reqd_yn.equals("Y")){
					pstmt	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT24B")) ;
					//sql_string		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT8");
					sql_string = "INSERT INTO PH_MEDN_ADMIN (FACILITY_ID,ENCOUNTER_ID,SCH_DATE_TIME,ORD_DRUG_CODE,DOSAGE_SEQ_NO,ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PRACT_ID,SCH_DOSAGE_QTY,SCH_DOSAGE_UOM_CODE,SCH_STRENGTH,SCH_STRENGTH_UOM,SCH_ROUTE_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,VERIFY_REQD_YN,ADMINISTERED_YN,SLIDING_SCALE_YN, MAR_BARCODE_ID) VALUES (?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?)";
					pstmt_modify	= connection.prepareStatement(sql_string) ; 
					ArrayList tmp_sch_dt_tm =   new ArrayList();
					String sch_strength_uom, interval_value_temp, stkuom ;
					boolean first_flag = true;
					schd_week_hr_dates  = getSchdDatesFrWeekHr(chkValuescheduleFrequency,presDetails,"UPDATE");
					schd_date_time	=	(ArrayList)schd_week_hr_dates.get((String)modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO")); //added +(String) modifyRecords.get("SRL_NO") for IN24521 --18/10/2010-- priya
					for(int i=0;i<presDetails.size();i++){
						modifyRecords	=	(HashMap) presDetails.get(i);
						amended_yn		=	(String)modifyRecords.get("AMENDED_YN"); //added for ML-BRU-SCF-0725 [IN:038336]
						if(amended_yn==null || !amended_yn.equals("Y")) //added for ML-BRU-SCF-0725 [IN:038336]
							continue;

						buildMAR_yn = (String)modifyRecords.get("BUILDMAR_YN")==null?"N":(String)modifyRecords.get("BUILDMAR_YN"); //added for SRR20056-SCF-7882 -29157
						if(buildMAR_yn.equals("Y")){
							frequencyValues	=	new ArrayList();
							if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0) {
								if(chkValuescheduleFrequency.containsKey((String) modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO"))) {
									frequencyValues = (ArrayList) chkValuescheduleFrequency.get((String) modifyRecords.get("DRUG_CODE")+(String) modifyRecords.get("SRL_NO"));
								}
							}
							duration	=	Integer.parseInt((String) modifyRecords.get("FREQ_DURN_VALUE")==null?(String) modifyRecords.get("DURN_VALUE"):(String) modifyRecords.get("FREQ_DURN_VALUE")); //taken freq_durn_value  IN21648 --28/05/2010 --priya 
							if(frequencyValues != null && frequencyValues.size() > 0){
								freq_char_list	= (HashMap)frequencyValues.get(0);
								day_list		= (ArrayList)frequencyValues.get(1);
								day_names		= (ArrayList)frequencyValues.get(2);
								time_list		= (ArrayList)frequencyValues.get(3);
								dose_list		= (ArrayList)frequencyValues.get(4);
							}
							interval_value_temp = (String) modifyRecords.get("INTERVAL_VALUE")==null?"1":(String) modifyRecords.get("INTERVAL_VALUE");
							first_flag = true;
							//ML-MMOH-CRF-1531 -start
							durn_type		=	(String) modifyRecords.get("DURN_TYPE");
							String repeat_durn_type = (String)modifyRecords.get("FREQ_DURN_TYPE")==null?"":(String)modifyRecords.get("FREQ_DURN_TYPE");

							if(site_all_durn_app && freq_nature.equals("I") && (repeat_durn_type.equals("M")|| (repeat_durn_type.equals("H") && (durn_type.equals("L") || durn_type.equals("Y") )))){
								duration=Integer.parseInt((String)modifyRecords.get("DURN_VALUE")==null?"1":(String)modifyRecords.get("DURN_VALUE"));
							}
						//ML-MMOH-CRF-1531 - end
							for(int m=0;m<=duration;m++){
								if((m != 0) && (Integer.parseInt(interval_value_temp) > 1)){
									m = m+(Integer.parseInt(interval_value_temp) -1);
								}
								if(first_flag == false && Integer.parseInt(interval_value_temp)>1 && ((String) modifyRecords.get("FREQ_NATURE")).equals("F")){//Code added for IN24728 --20/11/2010-- priya// To make the schd time to start from immediate next day instead of next dose schd time for alt day freq if first day dose is lapsed 
									m =1;
								}
								if(freq_char_list != null && freq_char_list.size()>0){
									if(!freq_char_list.get("durationType").equals("D")){	
										tmp_sch_dt_tm.clear();
										int m1 = m;
										for(int tmpSch=0;tmpSch<day_list.size();tmpSch++){
											if (m >= duration) 
												m1 = 0;
											if((tmpSch+(m1*day_list.size())) < schd_date_time.size()) // condition added for IN21328 -- 18/05/2010 -- priya
												tmp_sch_dt_tm.add((String)schd_date_time.get(tmpSch+(m1*day_list.size())));
										}
									}
								}
								if(day_list!=null && day_list.size()>0) {
									freq_values_found=true;
									for(int n=0;n<day_list.size();n++){
										int dosage_seqNo	= 1;
										dosage_seqNo		= dosage_seqNo+n;
										str_date = (String) modifyRecords.get("START_DATE_TIME");
										if(freq_char_list.get("durationType").equals("D")){
											pstmt.setString(1,str_date);
											pstmt.setString(2,""+m);
											pstmt.setString(3,(String)time_list.get(n));
											pstmt.setString(4,str_date);
											pstmt.setString(5,""+m);
											pstmt.setString(6,(String)time_list.get(n));
											pstmt.setString(7,str_date);
											str_date = (String) modifyRecords.get("END_DATE_TIME");
											pstmt.setString(8,str_date);
											resultSet		= pstmt.executeQuery();
											if(resultSet!=null && resultSet.next()){
												sch_date_time	=	resultSet.getString(1);
												first_flag = true;
											}
											else
												first_flag = false;
											closeResultSet(resultSet);
										}
										else if(freq_char_list.get("durationType").equals("W") || freq_char_list.get("durationType").equals("L")){//OR condition added --18/03/2010-- priya
											if(n < tmp_sch_dt_tm.size())  // condition added for IN21328 -- 18/05/2010 -- priya
												sch_date_time = (String)tmp_sch_dt_tm.get(n);				
										}
										if(!tmp_drugs.contains((String) modifyRecords.get("DRUG_CODE"))) {
											unique_schedules	=	new ArrayList();
											tmp_drugs.add((String) modifyRecords.get("DRUG_CODE"));
										}
										if(sch_date_time!=null && !sch_date_time.equals("")){
											if(!unique_schedules.contains(sch_date_time)) {
												pstmt_modify.setString(1,login_facility_id);
												pstmt_modify.setString(2,(String) modifyRecords.get("ENCOUNTER_ID"));
												pstmt_modify.setString(3,sch_date_time);
												pstmt_modify.setString(4,(String) modifyRecords.get("DRUG_CODE"));
												pstmt_modify.setString(5,""+(dosage_seqNo));
												pstmt_modify.setString(6,(String) modifyRecords.get("ORDER_ID")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
												pstmt_modify.setString(7,(String) modifyRecords.get("ORDER_LINE_NUM"));
												pstmt_modify.setString(8,(String) modifyRecords.get("PATIENT_ID"));
												pstmt_modify.setString(9,(String) modifyRecords.get("ORD_PRACT_ID"));
												//pstmt_modify.setString(10,(String)data.get("admin_qty"));
												pstmt_modify.setString(10,(String)dose_list.get(n));
												pstmt_modify.setString(11,(String) modifyRecords.get("QTY_UNIT"));
												if( ((String) modifyRecords.get("DOSAGE_TYPE")).equals("Q") && ((String) modifyRecords.get("STRENGTH"))!=null && !((String) modifyRecords.get("STRENGTH")).equals("0") && !((String) modifyRecords.get("STRENGTH")).equals("") ) {
													sch_strength	=	Math.ceil( (Float.parseFloat((String) modifyRecords.get("STRENGTH_PER_PRES_UOM")) / Float.parseFloat((String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")) ) * Float.parseFloat((String) modifyRecords.get("QTY_VALUE")))+"";
												}
												else if (((String) modifyRecords.get("DOSAGE_TYPE")).equals("S"))	{
													sch_strength	=	(String) modifyRecords.get("STRENGTH");
												}
												pstmt_modify.setString(12,sch_strength);
												pstmt_modify.setString(13,(String) modifyRecords.get("STRENGTH_UOM"));
												pstmt_modify.setString(14,(String)modifyRecords.get("ROUTE_CODE"));
												pstmt_modify.setString(15,login_by_id);
												pstmt_modify.setString(16,login_at_ws_no);
												pstmt_modify.setString(17,login_facility_id);
												pstmt_modify.setString(18,login_by_id);
												pstmt_modify.setString(19,login_at_ws_no);
												pstmt_modify.setString(20,login_facility_id);
												pstmt_modify.setString(21,verf_reqd_bef_med_admin_yn);
												pstmt_modify.setString(22,"N");
												if(((ArrayList)modifyRecords.get("SLDSCALE_TMPL_DTL")).size()>0)
													pstmt_modify.setString(23,"Y");
												else
													pstmt_modify.setString(23,"N");
												pstmt_modify.setString(24,(String)modifyRecords.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064] 
					
												pstmt_modify.addBatch();

												unique_schedules.add(sch_date_time);
											}
										}
									}//freq -day_list for
								}//freq vals - day_list if
								freq_nature = (String) modifyRecords.get("FREQ_NATURE"); 
								if(freq_nature.equals("O") || freq_nature.equals("P")){
									freq_values_found=true;
									if(!stat_time.contains(stat_sch_time)) {
										contains_stat		=	true;
										dosage_type		=(String)modifyRecords.get("DOSAGE_TYPE");
										qty_unit			=(String)modifyRecords.get("QTY_DESC_CODE");
										strength_value		=(String)modifyRecords.get("ACT_STRENGTH_VALUE");
										strength_uom		=(String)modifyRecords.get("STRENGTH_UOM");
										pres_base_uom		=(String)modifyRecords.get("PRES_BASE_UOM");
										fr_drug_code = (String)modifyRecords.get("DRUG_CODE");
										//equal_value		=(String)modifyRecords.get("EQUAL_VALUE");  
										equal_value		= "1";
										stkuom			=	"";
										//pstmt		= connection.prepareStatement(sql_ph_prescription_select64) ;		
										pstmt_ph_drug_vw.setString(1,dosage_type);
										pstmt_ph_drug_vw.setString(2,in_order_qty);
										pstmt_ph_drug_vw.setString(3,in_order_qty);
										pstmt_ph_drug_vw.setString(4,drug_code);
										pstmt_ph_drug_vw.setString(5, language_id);
										pstmt_ph_drug_vw.setString(6, language_id);
										pstmt_ph_drug_vw.setString(7, language_id);
										pstmt_ph_drug_vw.setString(8, language_id);
										pstmt_ph_drug_vw.setString(9, language_id);

										resultSet=pstmt_ph_drug_vw.executeQuery();
										if (resultSet.next())	{
											stkuom	=	(String)resultSet.getString("stock_uom");
											if (stkuom!=null && !stkuom.equals(""))	{
												in_order_uom	=	stkuom;
											}
										}
										closeResultSet( resultSet ) ;
										closeStatement( pstmt_ph_drug_vw ) ;
										if(((String)modifyRecords.get("FREQ_NATURE")).equals("O")) {
											dose_seq_no	=	1;
											 in_order_qty		=(String)modifyRecords.get("QTY_VALUE");
											 in_order_uom		=(String)modifyRecords.get("QTY_DESC_CODE");
										} 
										else {
											if(!stat_dtls.contains((String) modifyRecords.get("ORDER_ID")) || !stat_dtls.contains(fr_drug_code)) { //changed order_id ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
												dose_seq_no		=	2;// changed dose_seq_no =1 to 2 for incident No:32773
												stat_dtls.add((String) modifyRecords.get("ORDER_ID")); //changed order_id ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
												stat_dtls.add(fr_drug_code);
											}
											else {
												dose_seq_no++;
											}
											 in_order_qty		=(String)modifyRecords.get("ORDER_QTY");
										}
										if(dosage_type!=null && dosage_type.equals("Q")){
											equal_value="1";
											pstmt_am_uom_eqvl.setString(1,pres_base_uom);
											pstmt_am_uom_eqvl.setString(2,qty_unit);
											pstmt_am_uom_eqvl.setString(3,pres_base_uom);
											pstmt_am_uom_eqvl.setString(4,qty_unit);
											resultSet	= pstmt_am_uom_eqvl.executeQuery();
											if ( resultSet != null && resultSet.next() ) {
												equal_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
											}
										}
										closeResultSet( resultSet ) ;
										closeStatement( pstmt_am_uom_eqvl ) ;
										if(((String)modifyRecords.get("FREQ_NATURE")).equals("O")) {
											stat_sch_time = (String)modifyRecords.get("START_DATE_TIME");
										} 
										else {
											if(stat_dtls.contains(fr_drug_code)) {
												if(stat_sch_time.equals("")) {
													stat_sch_time	=	(String)modifyRecords.get("START_DATE_TIME");
												} else {
													stat_sch_time	= getNextSchDateTime(connection,stat_sch_time,PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_SELECT5"));
												}
											} 
											else {
												stat_sch_time = (String)modifyRecords.get("START_DATE_TIME");
											}
											in_order_uom =(String)modifyRecords.get("STOCK_UOM");
										}

										pstmt_modify.setString(1,login_facility_id);
										pstmt_modify.setString(2,(String) modifyRecords.get("ENCOUNTER_ID"));
										pstmt_modify.setString(3,stat_sch_time);
										pstmt_modify.setString(4,fr_drug_code);
										pstmt_modify.setString(5,(dose_seq_no)+"");
										pstmt_modify.setString(6,(String) modifyRecords.get("ORDER_ID")); //changed order_id ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
										//pstmt_modify.setString(7,""+(i+1));//commentted for SKR-SCF-1149
										pstmt_modify.setString(7,""+(String) modifyRecords.get("ORDER_LINE_NUM"));// Added for SKR-SCF-1149
										pstmt_modify.setString(8,(String) modifyRecords.get("PATIENT_ID"));
										if( getExternalpatient_id()!= null && !getExternalpatient_id().equals("")){
											pstmt_modify.setString(9,login_by_id);
										}
										else{
											pstmt_modify.setString(9,(String)modifyRecords.get("ORD_PRACT_ID"));
										}
										//pstmt_insert.setString(9,ord_pract_id);
										pstmt_modify.setString(10,in_order_qty);
										pstmt_modify.setString(11,in_order_uom);
										sch_strength		=strength_value;
										sch_strength_uom	=strength_uom;
										if(dosage_type!=null && dosage_type.equals("S")){
											sch_strength=strength_value;
										}
										else{
												if(strength_value!=null &&  !strength_value.equals("") &&  !strength_value.equals("0")){ //if added for SKR-SCF-1309
											float tot_strn=(Float.parseFloat(in_order_qty))*(Float.parseFloat(strength_value))*(Float.parseFloat(equal_value));
											sch_strength=String.valueOf(tot_strn);
											}
											if(sch_strength.length()>11)
												sch_strength=sch_strength.substring(0,11);
										}
										pstmt_modify.setString(12,sch_strength);
										pstmt_modify.setString(13,sch_strength_uom);
										pstmt_modify.setString(14,(String)modifyRecords.get("ROUTE_CODE"));
										pstmt_modify.setString(15,login_by_id);
										pstmt_modify.setString(16,login_at_ws_no);
										pstmt_modify.setString(17,login_facility_id);
										pstmt_modify.setString(18,login_by_id);
										pstmt_modify.setString(19,login_at_ws_no);
										pstmt_modify.setString(20,login_facility_id);
										pstmt_modify.setString(21,verf_reqd_bef_med_admin_yn);
										pstmt_modify.setString(22,"N");
										if(((ArrayList)modifyRecords.get("SLDSCALE_TMPL_DTL")).size()>0)
											pstmt_modify.setString(23,"Y");
										else
											pstmt_modify.setString(23,"N");
										pstmt_modify.setString(24,(String)modifyRecords.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064] 
										pstmt_modify.addBatch();
										stat_time.add(stat_sch_time);
									}
								}
								else if(freq_nature.equals("I")){
									freq_values_found = true;
									tmp_sch_dt = "";
									int	dosage_seqNo = 1;
									//HashMap sched_date_time_wkhr = (HashMap)tabData.get("sched_date_time_wkhr");
										//ArrayList schedDateTimesWkHr = (ArrayList)schd_week_hr_dates.get(((String) modifyRecords.get("DRUG_CODE")));
									if(schd_date_time != null && schd_date_time.size()>0){
										for(int scdDt=0; scdDt<schd_date_time.size();scdDt++){
											sch_date_time = (String)schd_date_time.get(scdDt);
											if(tmp_sch_dt.equals(sch_date_time.substring(0,10))){
												dosage_seqNo++;
											}
											else{
												dosage_seqNo = 1;
											}
											tmp_sch_dt    = sch_date_time.substring(0,10);
											if(!tmp_drugs.contains((String) modifyRecords.get("DRUG_CODE"))) {
												unique_schedules	=	new ArrayList();
												tmp_drugs.add((String) modifyRecords.get("DRUG_CODE"));
											}

											if((!sch_date_time.equals("")) && (sch_date_time != null)){
												if(!unique_schedules.contains(sch_date_time)) {
													pstmt_modify.setString(1,login_facility_id);
													pstmt_modify.setString(2,(String) modifyRecords.get("ENCOUNTER_ID"));
													pstmt_modify.setString(3,sch_date_time);
													pstmt_modify.setString(4,(String) modifyRecords.get("DRUG_CODE"));
													pstmt_modify.setString(5,""+(dosage_seqNo));
													pstmt_modify.setString(6,(String) modifyRecords.get("ORDER_ID")); //changed amendOrderID ==> (String) modifyRecords.get("ORDER_ID") for IN[032679]
													pstmt_modify.setString(7,(String) modifyRecords.get("ORDER_LINE_NUM"));
													pstmt_modify.setString(8,(String) modifyRecords.get("PATIENT_ID"));
													pstmt_modify.setString(9,(String) modifyRecords.get("ORD_PRACT_ID"));
													pstmt_modify.setString(10,(String) modifyRecords.get("QTY_VALUE"));
													pstmt_modify.setString(11,(String) modifyRecords.get("QTY_UNIT"));
													if( ((String) modifyRecords.get("DOSAGE_TYPE")).equals("Q") && ((String) modifyRecords.get("STRENGTH"))!=null && !((String) modifyRecords.get("STRENGTH")).equals("0") && !((String) modifyRecords.get("STRENGTH")).equals("") ) {
														sch_strength	=	Math.ceil( (Float.parseFloat((String) modifyRecords.get("STRENGTH_PER_PRES_UOM")) / Float.parseFloat((String) modifyRecords.get("STRENGTH_PER_VALUE_PRES_UOM")) ) * Float.parseFloat((String) modifyRecords.get("QTY_VALUE")))+"";
													}
													else if (((String) modifyRecords.get("DOSAGE_TYPE")).equals("S"))	{
														sch_strength	=	(String) modifyRecords.get("STRENGTH");
													}
													pstmt_modify.setString(12,sch_strength);
													pstmt_modify.setString(13,(String) modifyRecords.get("STRENGTH_UOM"));
													pstmt_modify.setString(14,(String)modifyRecords.get("ROUTE_CODE"));
													pstmt_modify.setString(15,login_by_id);
													pstmt_modify.setString(16,login_at_ws_no);
													pstmt_modify.setString(17,login_facility_id);
													pstmt_modify.setString(18,login_by_id);
													pstmt_modify.setString(19,login_at_ws_no);
													pstmt_modify.setString(20,login_facility_id);
													pstmt_modify.setString(21,verf_reqd_bef_med_admin_yn);
													pstmt_modify.setString(22,"N");
													if(((ArrayList)modifyRecords.get("SLDSCALE_TMPL_DTL")).size()>0)
														pstmt_modify.setString(23,"Y");
													else
														pstmt_modify.setString(23,"N");
													pstmt_modify.setString(24,(String)modifyRecords.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064] 
													pstmt_modify.addBatch();

													unique_schedules.add(sch_date_time);
												}
											}
										}
									}
								}
							} //end - duration for loop
						} //end -if buildMAR_yn 
					} //end - presDetails for loop
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					if( freq_values_found ) {
						int[] result_insert_8= pstmt_modify.executeBatch();
						closeStatement( pstmt_modify ) ;
						for (int i=0;i<result_insert_8.length ;i++ ){
							if(result_insert_8[i]<0  && result_insert_8[i] != -2 ){
								modify_rec_4=false;
								break;
							}
						}
					}
				} // end -if med_admin_reqd_yn 
			// PH_MEDN_ADMIN INSERT ENDS
			if(modify_rec_1 && modify_rec_2 && modify_rec_3 && modify_rec_4){
				connection.commit();
				//connection.rollback();
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(locale,"RECORD_INSERTED","PH") ) ;
			}
			else{
				map.put( "message",  getMessage(locale,"TRANSACTION_FAILED","PH") );
				System.err.println("ERROR IN AMEND NORMAL RX presDetails="+presDetails);
				try{
					map.put( "result", new Boolean( false ) ) ;
					connection.rollback();
				}
				catch(Exception es){
					es.printStackTrace();
				}
			}
			amend_reason_temp = null; //Added for ML-BRU-SCF-0098 [IN031837]
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("ERROR IN AMEND NORMAL RX presDetails="+presDetails);
			try{
				connection.rollback();
			}
			catch(Exception es){
				e.printStackTrace();
			}
			map.put( "result", new Boolean( false ) ) ;
			
			if(map.containsKey("msgid_other_user")){ //if added for ML-MMOH-SCF-1776
				map.put( "message",  "ORDER_PROC_BY_OTHER_USER");
			}
			else{
				map.put( "message",  getMessage(locale,"TRANSACTION_FAILED","PH")+" @ Exception :"+e ) ;
			}
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt_modify ) ;
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_clob ) ;
				closeResultSet( rset_clob ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		map.put( "flag", "" ) ;
		return map ;
	}

	public String getDosageUOM(String drug_code){// function to return dosage uom
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String dosage_uom="";
		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT81"));
			pstmt.setString(1, drug_code);
			pstmt.setString(2, getAgeGroup());
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				dosage_uom	=	resultSet.getString("DOSAGE_UNIT");
			}
		}
		catch(Exception e) {
			dosage_uom=e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ }
		}
		return dosage_uom;
	}

	public HashMap insert() {
		locale= getLanguageId()==null?"en":getLanguageId();
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		ArrayList mandatory_flds	=	new ArrayList();
		HashMap schd_week_hr_dates	=	new HashMap();
		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);
		HashMap tabData	= new HashMap() ;
		HashMap sqlMap		= new HashMap() ;
		HashMap consumable_tabData	= new HashMap();
		HashMap consumable_sqlMap		= new HashMap();
		try {
			tabData.put("properties", getProperties() );
			ArrayList presItemList=  getPresItemList();
			if(presItemList!=null && presItemList.size()>0){
				HashMap itemDetail = new HashMap();
				consumable_tabData.put("properties", getProperties() );
				if(!locale.equals("en")){

					String str_date = "";
					for(int j=0;j<presItemList.size();j++){
						itemDetail = (HashMap) presItemList.get(j);
						str_date = (String)itemDetail.get("ORDERED_DATE");
						itemDetail.put("ORDERED_DATE", com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en"));
					}
				}
				consumable_tabData.put("presItemList",presItemList);
				consumable_tabData.put("mandatory_flds",mandatory_flds);
				consumable_tabData.put("called_from","RX");
				consumable_tabData.put("language_id",getLanguageId());
				consumable_tabData.put("nonPreferenceRemarksMedicalItem",getNonPrefernceRemarksMedicalItem());//GHL-CRF-0618
	//			System.err.println("Non item remak =7303=>"+getNonPrefernceRemarksMedicalItem());
				consumable_tabData.put("license",(String)(PhLicenceRights.getKey()));
				consumable_tabData.put("OrderRemarks",this.OrderRemarks);	//Added for ICN-64906
				consumable_sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT19A", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT19A") );
				consumable_sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT20A", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT20A") );
				consumable_sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT55", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT55") );
				consumable_sqlMap.put( "SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT") );
				consumable_sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT1", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT1") );
				consumable_sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT2", "INSERT INTO OR_ORDER_LINE (ORDER_ID,ORDER_LINE_NUM,ORDER_CATALOG_CODE,CATALOG_DESC,CATALOG_SYNONYM,ORDER_CATALOG_NATURE,ORDER_TYPE_CODE,ORDER_CATEGORY,ORD_DATE_TIME,PRIORITY,ORD_AUTH_REQD_YN,ORD_AUTH_REASON,ORD_APPR_REQD_YN,ORD_COSIGN_REQD_YN,START_DATE_TIME,FORM_CODE,ROUTE_CODE,QTY_VALUE,QTY_UNIT,FREQ_CODE,DURN_VALUE,DURN_TYPE,LINE_FIELDS_DISPLAY_TEXT,ITEM_NARRATION,NEXT_SCHED_DATE,END_DATE_TIME,AUTO_STOP_DATE_TIME,ORDER_QTY,ORDER_UOM,APPT_REQD_YN,APPT_DATE_TIME,APPT_REF_NUM,RESULT_APPLICABLE_YN,BILL_YN,BILLED_YN,CONT_ORDER_IND,REFILL_SINGLE_CONT_ORDER_YN,NUM_OF_REFILLS,CHILD_ORDER_YN,PARENT_ORDER_ID,PARENT_ORDER_LINE_NUM,ORDER_SET_ID,ORDER_SET_LINE_NUM,ORD_PRACT_ID,ORD_SET_DATE_TIME,AMD_PRACT_ID,AMD_DATE_TIME,HOLD_PRACT_ID,HOLD_DATE_TIME,RESUME_PRACT_ID,RESUME_DATE_TIME,DISC_PRACT_ID,DISC_DATE_TIME,CAN_PRACT_ID,CAN_DATE_TIME,ACCESSION_NUM,ACCESSION_LINE_NUM,ORDER_LINE_STATUS,RESULT_LINE_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORD_CONSENT_REQD_YN,CAN_LINE_REASON,CATALOG_SYNONYM_DC,CATALOG_SYNONYM_AD,RESULT_AUTH_REQD_YN,ORD_QUOTA_LIMIT_YN) VALUES (?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?)" );
				consumable_sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT3",  "INSERT INTO OR_ORDER_LINE_PH (ORDER_ID,ORDER_LINE_NUM,GENERIC_ID,FORM_CODE,TRADE_CODE,FORMULARY_ITEM_YN,DOSAGE_TYPE,SPLIT_DRUG_PREVIEW,TOT_STRENGTH,TOT_STRENGTH_UOM,INFUSE_OVER,INFUSE_OVER_UNIT,INFUSION_RATE,INFUSION_VOL_STR_UNIT,INFUSION_PER_UNIT,BROUGHT_BY_PATIENT_YN,CUR_DRUG_YN,REFILL_DRUG_YN,DISPENSING_LOC_TYPE,DISPENSING_LOC,DISPENSING_STORE,IP_FILL_PROCESS,IP_FILL_PRD_AHEAD,NEXT_FILL_DATE,LAST_FILL_QTY,DISPENSED_QTY,BMS_QTY,BMS_STRENGTH,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SPLIT_DOSE_YN,QTY_VALUE_SPLIT_DOSE,QTY_UNIT_SPLIT_DOSE,STRENGTH_VALUE,STRENGTH_UOM,PRES_QTY_VALUE,PRES_QTY_UOM,ALLERGY_OVERRIDE_REASON,DOSAGE_LIMIT_OVERRIDE_REASON,DUPLICATE_DRUG_OVERRIDE_REASON,PATIENT_BROUGHT_MEDICATION_YN,AMEND_REASON_CODE, AMEND_REASON,PAT_COUNS_REQD_YN, PAT_COUNS_ORD_PRACT_ID,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,BUILD_MAR_YN,DRUG_INDICATION,PREGNANCY_OVERRIDE_REASON,ITEM_REMARKS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );	//Added for GHL-CRF-0470
				consumable_sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT4", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT4") );
				consumable_sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT56", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56") );	//Added for ICN-64906
				consumable_sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT5", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5") );		//Added for ICN-64906
				consumable_sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT57", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57") );	//Added for ICN-64906				
			}
			ArrayList OrderDetails = this.getOrderDetails();
			ArrayList OrderHeader = this.getpresHeader();
			ArrayList OrderID	= (ArrayList) this.getOrderID();
			HashMap HeaderRecords= null;
			ArrayList HeaderDetail =null;
			HashMap DetailRecords= null;
			String str_date, order_id;
			HashMap orderID_Priotiry = new HashMap();

			if(!locale.equals("en")){
				for (int i=0;i<OrderHeader.size() ;i++ ){
					HeaderRecords=(HashMap)OrderHeader.get(i);
					str_date = (String)HeaderRecords.get("ORDER_DATE_TIME")==null?"":(String)HeaderRecords.get("ORDER_DATE_TIME");
					if(!str_date.equals(""))
						HeaderRecords.put("ORDER_DATE_TIME", com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en"));
				}
			}
			for (int i=0;i<OrderID.size() ;i++ ){
				HeaderDetail=(ArrayList)OrderDetails.get(i);
				order_id			=(String) OrderID.get(i);
				orderID_Priotiry.put(order_id,"R");
				for(int j=0;j<HeaderDetail.size();j++){
					//DetailRecords= new HashMap();
					DetailRecords = (HashMap) HeaderDetail.get(j);
					if(((String)DetailRecords.get("PRIORITY")).equalsIgnoreCase("Urgent") || ((String)DetailRecords.get("PRIORITY")).equalsIgnoreCase("U"))//Modified for Bru-HIMS-CRF-400 [IN:044502]
						orderID_Priotiry.put(order_id,"U");
					if(((String)DetailRecords.get("PRIORITY")).equalsIgnoreCase("routine") || ((String)DetailRecords.get("PRIORITY")).equalsIgnoreCase("R"))//Added for Bru-HIMS-CRF-400 [IN:044502]
						orderID_Priotiry.put(order_id,"R");
		
					if(!locale.equals("en")){
						if((String)DetailRecords.get("START_DATE") !=null){
							str_date = (String)DetailRecords.get("START_DATE");
							DetailRecords.put("START_DATE", com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en"));
						}
						str_date = (String)DetailRecords.get("START_DATE_TIME");
						DetailRecords.put("START_DATE_TIME", com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en"));

						if((String)DetailRecords.get("END_DATE") !=null){
							str_date = (String)DetailRecords.get("END_DATE");
							DetailRecords.put("END_DATE", com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en"));
						}
						str_date = (String)DetailRecords.get("END_DATE_TIME");
						DetailRecords.put("END_DATE_TIME", com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en"));
					}
				}
			}
			//Added for Bru-HIMS-CRF-393_1.0-Start
			ArrayList header_rec=new ArrayList();
			HashMap orderTypeDetails=new HashMap();
			String  order_type_code="";
			String patient_class="";
			HashSet keyset=new HashSet();
			for(int i=0;i<OrderDetails.size();i++){
				 header_rec = (ArrayList)OrderDetails.get(i);
				for(int j=0;j<header_rec.size();j++){
					orderTypeDetails=(HashMap)header_rec.get(j);
					order_type_code=(String)orderTypeDetails.get("ORDER_TYPE_CODE");
					patient_class=(String)orderTypeDetails.get("PATIENT_CLASS");
					keyset.add(order_type_code);
				}
			}
			if(consumable_tabData.size()>0){
				print_ord_sht_rule_ind=(String)consumable_tabData.get("ORDER_TYPE_CODE");
				keyset.add(order_type_code);
			}
			setPrintOrdShtRuleInd(keyset,patient_class);//Added for Bru-HIMS-CRF-393_1.0-End
			tabData.put("OrderID",OrderID);
			tabData.put("orderID_Priotiry",orderID_Priotiry);
			tabData.put("OrderDetails", OrderDetails);
			tabData.put("OrderHeader",OrderHeader);
			tabData.put("OrderRemarks",this.OrderRemarks);
			tabData.put("diag_text",this.diag_text);
			tabData.put("DrugRemarks",this.getDrugRemarks());
			tabData.put("ScheduleFreq",this.getscheduleFrequency());
			tabData.put("disp_location",this.getDispLocation());
			tabData.put("license",(String)(PhLicenceRights.getKey()));
			tabData.put("mandatory_flds",mandatory_flds);
			tabData.put("called_from",this.called_from);
			tabData.put("old_order_det",this.old_order_det);
			tabData.put("nonPreferenceRemarksDrug",getNonPrefernceRemarks());//GHL-CRF-0618
			tabData.put("pre_alloc_appl_yn",getPreAllocApplYN());	//MMS-MD-SCF-0170
			tabData.put("language_id",locale);
			tabData.put("totalTaperQtyDisplay",getTotalTaperQtyDisplay());
			tabData.put("print_mar_barcode_yn",getPrintMarBarcode()); //Added for MMS-QH-CRF-0080 [IN:038064]
			tabData.put("print_mar_label_yn",getPrintMarLabel());//Added for MMS-QH-CRF-0080 [IN:038064]
			tabData.put("DiscCancelledOrders", getDiscCancelledOrders());//Added for HSA-CRF-0138 [IN:048414]
			tabData.put("AmendAlternateDrug", getAmend_alternate_yn());//added for  JD-CRF-0198 [IN:058599]
			tabData.put("alterAmendReason", getAlterAmendReason());//added for  JD-CRF-0198 [IN:058599]
			//code added for PRN Remarks
			 
			 tabData.put("prn_remarks",this.prn_remarks);
			//code added for External Prescription ..
			if(getExternalpatient_id()==null || getExternalpatient_id().equals("") ){ 
				tabData.put("external_pres_flag","false");
			}
			else{
				tabData.put("external_pres_flag","true");
			}
			//stem.out.println("prn_remarks_values=" + prn_remarks_values);
			tabData.put("external_ref_facility",this.external_ref_facility);
			tabData.put("external_date_ref",this.external_date_ref);
			tabData.put("external_ref_practitioner",this.external_ref_practitioner);
			tabData.put("external_remarks",this.external_remarks);
			tabData.put("consumable_tabData",consumable_tabData);
			schd_week_hr_dates = getSchdDatesFrWeekHr(this.getscheduleFrequency(),this.getOrderDetails(),"CREATE");
			tabData.put("sched_date_time_wkhr",schd_week_hr_dates);
			tabData.put("witnessByUser",getWitnessByUser()); // Added for AAKH-CRF-0023[IN:038259]

			tabData.put("placed_from_verbal_order",called_from_verbal_order);//added for GHL-CRF-0509
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT54", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT20A", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT20A") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT19A", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT19A") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT55", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT55") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT56", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT56A", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56A") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT57", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT53", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT24B", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT24B") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT25A", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT25A") );
			/* 63 has been added for temporary working of the bean.....these values are from ph_drug and hence can be retrieved initially itself */ 
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT64", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT64") );

			//queries added for work load ....
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT72",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT72") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT73",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT73") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_MODIFY7",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY7") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT74",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT74") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT75",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT75") );
			sqlMap.put( "SQL_PH_SLIDING_SCALE_SELECT5",PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_SELECT5") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT") );

			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT_SLD_SCALE", "insert into OR_ORDER_LINE_PH_SLD_SCALE (ORDER_ID, ORDER_LINE_NUM, TEMPLATE_ID, SRL_NO, RANGE_FROM, RANGE_TO, ADMIN_UNITS, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)" );

			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT1", "INSERT INTO OR_ORDER (ORDER_ID,ORDER_TYPE_CODE,ORDER_CATEGORY,CONTR_SYS_ID,PATIENT_ID,PATIENT_CLASS,ORDERING_FACILITY_ID,ENCOUNTER_ID,EPISODE_ID,EPISODE_VISIT_NUM,SOURCE_TYPE,SOURCE_CODE,DISCHARGE_IND,ORD_DATE_TIME,ORD_PRACT_ID,PRIORITY,ORD_AUTH_REQD_YN,ORD_AUTH_LEVEL,ORD_AUTH_BY_PRACT_ID,ORD_AUTH_DATE_TIME,ORD_APPR_REQD_YN,ORD_APPR_BY_USER_ID,ORD_APPR_DATE_TIME,ORD_COSIGN_REQD_YN,ORD_COSIGN_LEVEL,ORD_COSIGN_BY_PRACT_ID,ORD_COSIGN_DATE_TIME,ORD_PRINT_DATE_TIME,BILL_YN,CONT_ORDER_IND,PERFORMING_FACILITY_ID,PERFORMING_SYS_ID,PERFORMING_DEPTLOC_TYPE,PERFORMING_DEPTLOC_CODE,PERFORMING_PRACT_ID,RESULT_AUTH_REQD_YN,CHILD_ORDER_YN,PARENT_ORDER_ID,ORDER_SET_YN,ORDER_SET_ID,IV_PREP_YN,ORDER_FIELDS_DISPLAY_TEXT,ORDER_STATUS,RESULT_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORD_CONSENT_REQD_YN,ORD_CONSENT_BY_ID,ORD_CONSENT_BY_DATE_TIME,CAN_REASON,REF_FACILITY_ID,REF_DATE_TIME,REF_SENT_PRACT_ID,REF_RECIEVED_REMARKS,REF_RECIEVED_PRACT_ID,REF_RECIEVED_DATE_TIME,TRN_GROUP_REF,ORD_QUOTA_LIMIT_YN) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?)");
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT2", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT2") );
			//sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT3", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT3") );
			//ABUSE_EXISTS,ABUSE_DRUG_OVERRIDE_REASON added for AAKH-CRF-0140	        
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT3", "INSERT INTO OR_ORDER_LINE_PH (ORDER_ID,ORDER_LINE_NUM,GENERIC_ID,FORM_CODE,TRADE_CODE,FORMULARY_ITEM_YN,DOSAGE_TYPE,SPLIT_DRUG_PREVIEW,TOT_STRENGTH,TOT_STRENGTH_UOM,INFUSE_OVER,INFUSE_OVER_UNIT,INFUSION_RATE,INFUSION_VOL_STR_UNIT,INFUSION_PER_UNIT,BROUGHT_BY_PATIENT_YN,CUR_DRUG_YN,REFILL_DRUG_YN,DISPENSING_LOC_TYPE,DISPENSING_LOC,DISPENSING_STORE,IP_FILL_PROCESS,IP_FILL_PRD_AHEAD,NEXT_FILL_DATE,LAST_FILL_QTY,DISPENSED_QTY,BMS_QTY,BMS_STRENGTH,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SPLIT_DOSE_YN,QTY_VALUE_SPLIT_DOSE,QTY_UNIT_SPLIT_DOSE,STRENGTH_VALUE,STRENGTH_UOM,PRES_QTY_VALUE,PRES_QTY_UOM,ALLERGY_OVERRIDE_REASON,DOSAGE_LIMIT_OVERRIDE_REASON,DUPLICATE_DRUG_OVERRIDE_REASON,INTERACTION_OVERRIDE_REASON,PATIENT_BROUGHT_MEDICATION_YN,AMEND_REASON_CODE, AMEND_REASON,PAT_COUNS_REQD_YN, PAT_COUNS_ORD_PRACT_ID,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,BUILD_MAR_YN,SLIDING_SCALE_YN,  TAPERED_YN, TAPER_ORDER_ID, TAPER_ORDER_LINE_NUM,DRUG_INDICATION,PREGNANCY_OVERRIDE_REASON, MAR_BARCODE_ID, TAPER_SEQ_NO, DISC_CANCELLED_ORDERS,ALTERNATE_AMEND_REASON,PLACED_FROM_VERBAL_ORDER,DOSAGE_CHANGE_YN,ALLOW_ALTERNATE_YN ,LAB_INTERACT_OVERRIDE_REASON,FOOD_INTERACT_OVERRIDE_REASON,ALLERGY_OVERRIDE_REASON_CODE,DOSE_LIMIT_OVER_REASON_CODE,DUP_DRUG_OVERRIDE_REASON_CODE,INTER_OVERRIDE_REASON_CODE,LAB_INTER_OVERRIDE_REASON_CODE,FOOD_INTR_OVERRIDE_REASON_CODE,NOT_PREFERED_ITEM_REM_CODE,ABUSE_EXISTS,ABUSE_DRUG_OVERRIDE_REASON,QUOTA_CURR_VALUE,DISEASE_INTER_REASON_CODE,DISEASE_INTER_OVERRIDE_REASON) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)");//DRUG_INDICATION  Added for  ML-BRU-CRF-072[Inc:29938]  // DISC_CANCELLED_ORDERS added for HSA-CRF-0138 [IN:048414]//placed_from_verbal_order ADDED FOR GHL-CRF-0509,Modified for IN:072715//QUOTA_CURR_VALUE ADDED FOR MLMO_CRF-01823
			//ALLOW_ALTERNATE_YN added for GHL-CRF-549
			//FOOD_INTERACT_OVERRIDE_REASON and LAB_INTERACT_OVERRIDE_REASON  addedf or MMS-KH-CRF-0029DISEASE_INTER_OVERRIDE_REASON,DISEASE_INTER_OVERRIDE_REASON_CODE Added for MMS-DM-CRF-0229
			//sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT4", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT4") );//commented on 09/1/2006 to insert PRN_REMARKS in PH_PATIENT_DRUG_PROFILE			
			//ABUSE_EXISTS,ABUSE_DRUG_OVERRIDE_REASON added for AAKH-CRF-0140
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT4", "INSERT INTO PH_PATIENT_DRUG_PROFILE (PATIENT_ID,SRL_NO,FACILITY_ID,ENCOUNTER_ID,PATIENT_CLASS,LOCN_TYPE,LOCN_CODE,ROOM_TYPE,ROOM_NO,BED_NO,BED_CLASS,BED_TYPE,SPECIALITY_CODE,ATTEND_PRACTITIONER_ID,PRES_PRACTITIONER_ID,DRUG_CODE,GENERIC_ID,START_DATE,END_DATE,SPLIT_YN,TAPERED_YN,STRENGTH,STRENGTH_UOM_CODE,DOSAGE,DOSAGE_UOM_CODE,SPLIT_DOSE_PREVIEW,FREQ_CODE,DURATION,PRESCRIBED_QTY,DIAG_TEXT,DRUG_REMARKS,IV_PREP_YN,INFUSE_OVER,INFUSE_OVER_UNIT,INFUSION_RATE,INFUSION_VOL_STR_UNIT,INFUSION_PER_UNIT,AMENDED_YN,AMEND_BY_ID,AMEND_DATE_TIME,CANCEL_YN,CANCEL_BY_ID,CANCEL_DATE_TIME,TRN_TYPE_IND,ORIG_FACILITY_ID,ORIG_ORDER_ID,ORIG_ORDER_LINE_NO,TOT_ISSUED_QTY,BROUGHT_BY_PATIENT_YN,ON_HOLD_DATE_TIME,ON_HOLD_BY_ID,ON_HOLD_REASON_CODE,DISCONT_DATE_TIME,DISCONT_BY_ID,DISCONT_REASON_CODE,STOP_YN,STOP_DATE_TIME,STOP_PRACTITIONER_ID,STOP_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ROUTE_CODE,ALLERGY_OVERRIDE_REASON,DOSAGE_LIMIT_OVERRIDE_REASON,IV_INGREDIENTS,DURN_TYPE,DISPENSED_DRUGS,ALTERNATE_GENERIC_ID,DISP_REMARKS,DUPLICATE_DRUG_OVERRIDE_REASON,REFILL_YN,FORM_CODE,DIAG_CODE1,DIAG_CODE1_CAUSE_IND,DIAG_CODE1_SCHEME,DIAG_CODE2,DIAG_CODE2_CAUSE_IND,DIAG_CODE2_SCHEME,DIAG_CODE3,DIAG_CODE3_CAUSE_IND,DIAG_CODE3_SCHEME,PRESCRIBED_MODE,HEIGHT,HEIGHT_UOM,WEIGHT,WEIGHT_UOM,BSA,ALLERGIC_YN,BMI, PRN_REMARKS,SLIDING_SCALE_REMARKS,CONTRAIND_OVERRIDE_REASON, INTERACTION_OVERRIDE_REASON, DRUG_DB_PRODUCT_ID,PRN_REMARKS_CODE,PATIENT_STOCK_YN,ABUSE_EXISTS,ABUSE_DRUG_OVERRIDE_REASON) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );//PATIENT_STOCK_YN added for GHL-CRF-0482
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT5", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT6", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT6") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT7", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT8", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT8") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT9",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT9") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT10",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT10") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT11",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT11") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT12",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT12") );
			sqlMap.put( "SQL_PH_RENEW_PRESCRIPTION_INSERT1",PhRepository.getPhKeyValue("SQL_PH_RENEW_PRESCRIPTION_INSERT1") );
			sqlMap.put( "SQL_PH_RENEW_PRESCRIPTION_INSERT2",PhRepository.getPhKeyValue("SQL_PH_RENEW_PRESCRIPTION_INSERT2") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_MODIFY8",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY8") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_MODIFY9",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY9") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_MODIFY6",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY6") );
			sqlMap.put( "SQL_PH_GEN_MARDARCODEID",PhRepository.getPhKeyValue("SQL_PH_GEN_MARDARCODEID") );  //added for  MMS-QH-CRF-0080 [IN:038064]
			sqlMap.put( "SQL_CURR_QUOTA_LIMIT_UPDATE",PhRepository.getPhKeyValue("SQL_CURR_QUOTA_LIMIT_UPDATE") );//ADDED FOR MLMO_CRF-01823
			sqlMap.put( "consumable_sqlMap",consumable_sqlMap);
			//System.err.println("================tabData====>"+tabData);
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_PRESCRIPTION" ),PrescriptionHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			System.out.println("tabdata 7863"+tabData);
			argArray[1] = sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
			HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(locale,(String) result.get( "msgid" ),"PH"));
				setTrnGroupRef((String)result.get("trn_group_ref"));
				setTokensGeneratedYN((String)result.get("tokens_generated_yn"));
			}
			else {
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(locale,"EXCEPTION_OCCURED_WHILE_INSERTION","PH")+" : "+(String)map.get("flag") ) ;
			}
		}
		catch(Exception e) {
			map.put("message",e.toString());
			e.printStackTrace() ;
		}
		return map ;
	}

	public HashMap delete() {
		 HashMap map = new HashMap() ;
		 map.put( "result", new Boolean( true ) ) ;
		 map.put( "message", "No deletion allowed here.." ) ;
		 return map ;
	}

	public String getConvFactor(String strength,String qty_uom)	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sql_str;
		String equl_value		= "1";
		try{
			connection			= getConnection() ;
			sql_str				= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53");
			pstmt				= connection.prepareStatement(sql_str) ;

			pstmt.setString(1,strength);
			pstmt.setString(2,qty_uom);
			pstmt.setString(3,strength);
			pstmt.setString(4,qty_uom);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				equl_value	=	resultSet.getString("EQVL_VALUE");
			}
		}
		catch(Exception e){
			equl_value=e.toString();
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
		return equl_value;
	}


	public String getAmendRemarks(String order_id)	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String  AmendRemarks="";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT22A") ) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				AmendRemarks = resultSet.getString("order_comment")==null ? "":resultSet.getString("order_comment");
				this.setAmendOrderRemarks(AmendRemarks);
			}
		}
		catch(Exception e){
			AmendRemarks=e.toString();
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
		return AmendRemarks;
	}

	public boolean doPrinting(Object request,Object response, String locn_code, String patient_class, String prescriptionPrint, String NarcoticPrint, String MARLabelPrint,String patient_id) {	//code 'String patient_id' added for SKR-SCF-0915[IN046734]	
        Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList all_orders	    =(ArrayList)OrderID.clone();
		ArrayList narcotic_nos      = new ArrayList();
	   try{
			connection = getConnection() ;
			String amendOrdID	=	getamendOrderID();
			if(all_orders== null || all_orders.size() == 0){
				if(!amendOrdID.equals(""))
					all_orders.add(amendOrdID);
			}
			if((NarcoticPrint.toUpperCase()).equals("Y")){
				pstmt				= connection.prepareStatement("select NARCO_NO from or_order_line_ph where order_id between ? and ? and NARCO_NO is not null") ;
				pstmt.setString(1,(String)all_orders.get(0));
				pstmt.setString(2,(String)all_orders.get(all_orders.size()-1));
                resultSet			= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					narcotic_nos.add(resultSet.getString("NARCO_NO"));
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
			if(patient_class.equals("IP")) {
				if((prescriptionPrint.toUpperCase()).equals("Y")){
					onlineReports 	= new ecis.utils.OnlineReports() ;
					report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHBOPPRS_IP") ;
					report2.addParameter("p_facility_id", login_facility_id) ;
					report2.addParameter("p_module_id", "PH") ;
					report2.addParameter("p_report_id", "PHBOPPRS_IP") ;
					report2.addParameter("p_fm_order_id", (String)all_orders.get(0)) ;
					report2.addParameter("p_to_order_id", (String)all_orders.get(all_orders.size()-1)) ;
					report2.addParameter("p_locncode", locn_code) ;
					report2.addParameter("p_patclass", patient_class) ;
					report2.addParameter("p_user_name", login_by_id) ;
					report2.addParameter("p_language_id", getLanguageId()) ;
					report2.addParameter("p_patient_id", patient_id) ;//code added for SKR-SCF-0915[IN046734]  
					onlineReports.add( report2) ;
					onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
				}
				if((NarcoticPrint.toUpperCase()).equals("Y")){
					onlineReports 	= new ecis.utils.OnlineReports() ; //moved outside from for loop for KAUH-SCF-043
					for(int i=0;i<narcotic_nos.size();i++){
						report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHRNARFORM") ;
						report2.addParameter("p_report_id", "PHRNARFORM") ;
						//report2.addParameter("P_FR_ORDER_ID", (String)all_orders.get(0)) ;
						//report2.addParameter("P_TO_ORDER_ID", (String)all_orders.get(all_orders.size()-1)) ;
						report2.addParameter("P_LANGUAGE_ID", getLanguageId()) ;
						report2.addParameter("P_FACILITY_ID", login_facility_id) ;
						report2.addParameter("P_NARCOTIC_NO", (String)narcotic_nos.get(i)) ;
						report2.addParameter("P_REPRINT", "N") ;
						report2.addParameter("p_patient_id", patient_id) ;//code added for SKR-SCF-0915[IN046734]  
						onlineReports.add( report2) ;
					}
					onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );  //moved outside from for loop for KAUH-SCF-043
				}
			} 
			else if(patient_class.equals("XT")) {
				if((prescriptionPrint.toUpperCase()).equals("Y")){
					if((getCustomerID()).equals("SRR") || (getCustomerID()).equals("SKR")){ // (getCustomerID()).equals("SKR") added for SCF-0369
						//String order_id=(String)all_orders.get(0);				
						onlineReports 	= new ecis.utils.OnlineReports() ;
						report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHBOPPEX") ;
						report2.addParameter("p_facility_id", login_facility_id) ;
						report2.addParameter("p_module_id", "PH") ;
						report2.addParameter("p_report_id", "PHBOPPEX") ;
						report2.addParameter("p_trn_group_ref", this.trn_group_ref) ;
						report2.addParameter("p_order_id", "") ;//Order id is not given importance for SRR as reports are printed based on trn_group_ref
						report2.addParameter("p_locncode", locn_code) ;
						report2.addParameter("p_patclass", patient_class) ;
						report2.addParameter("p_user_name", login_by_id) ;
						report2.addParameter("p_language_id", getLanguageId()) ;
						report2.addParameter("p_patient_id", patient_id) ;//code added for SKR-SCF-0915[IN046734]
						onlineReports.add( report2) ;
						onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
					}
					else{
						String order_id;
						onlineReports 	= new ecis.utils.OnlineReports() ;  //moved outside from for loop for KAUH-SCF-043
						for(int i=0;i<all_orders.size();i++){
							order_id=(String)all_orders.get(i);
							report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHBOPPEX") ;
							report2.addParameter("p_facility_id", login_facility_id) ;
							report2.addParameter("p_module_id", "PH") ;
							report2.addParameter("p_report_id", "PHBOPPEX") ;
							report2.addParameter("p_order_id", order_id) ;
							report2.addParameter("p_patclass", patient_class) ;
							report2.addParameter("p_user_name", login_by_id) ;
							report2.addParameter("p_language_id", getLanguageId()) ;
							report2.addParameter("p_patient_id", patient_id) ;//code added for SKR-SCF-0915[IN046734]
							onlineReports.add( report2) ;
						}
						onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );  //moved outside from for loop for KAUH-SCF-043
					}
				}
				/*if((NarcoticPrint.toUpperCase()).equals("Y")){
					ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
					ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHRNARFORM") ;
					report2.addParameter("p_report_id", "PHRNARFORM") ;
					report2.addParameter("P_FR_ORDER_ID", (String)all_orders.get(0)) ;
					report2.addParameter("P_TO_ORDER_ID", (String)all_orders.get(all_orders.size()-1)) ;
					report2.addParameter("p_language_id", getLanguageId()) ;
					onlineReports.add( report2) ;
					onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
				}*/
			}
			else {
				if(all_orders!=null && all_orders.size()>0){
					if((prescriptionPrint.toUpperCase()).equals("Y")){
						if((getCustomerID()).equals("SRR") || (getCustomerID()).equals("SKR")){ // (getCustomerID()).equals("SKR") added for SCF-0369
							//String order_id=(String)all_orders.get(0);				
							onlineReports 	= new ecis.utils.OnlineReports() ;
							report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHBOPPRS") ;
							report2.addParameter("p_facility_id", login_facility_id) ;
							report2.addParameter("p_module_id", "PH") ;
							report2.addParameter("p_report_id", "PHBOPPRS") ;
							report2.addParameter("p_trn_group_ref", this.trn_group_ref) ;
							report2.addParameter("p_order_id", "") ;//Order id is not given importance for SRR as reports are printed based on trn_group_ref
							report2.addParameter("p_locncode", locn_code) ;
							report2.addParameter("p_patclass", patient_class) ;
							report2.addParameter("p_user_name", login_by_id) ;
							report2.addParameter("p_language_id", getLanguageId()) ;
							report2.addParameter("p_patient_id", patient_id) ;//code added for SKR-SCF-0915[IN046734]
							onlineReports.add( report2) ;
							onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
						}
						else{
							String order_id;
							onlineReports 	= new ecis.utils.OnlineReports() ;  //moved outside from for loop for KAUH-SCF-043
							for(int i=0;i<all_orders.size();i++){
								order_id=(String)all_orders.get(i);				
								report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHBOPPRS") ;
								report2.addParameter("p_facility_id", login_facility_id) ;
								report2.addParameter("p_module_id", "PH") ;
								report2.addParameter("p_report_id", "PHBOPPRS") ;
								report2.addParameter("p_trn_group_ref", this.trn_group_ref) ;
								report2.addParameter("p_order_id", order_id) ;
								report2.addParameter("p_locncode", locn_code) ;
								report2.addParameter("p_patclass", patient_class) ;
								report2.addParameter("p_user_name", login_by_id) ;
								report2.addParameter("p_language_id", getLanguageId()) ;
								report2.addParameter("p_patient_id", patient_id) ;
								onlineReports.add( report2) ;
							}
							onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );  //moved outside from for loop for KAUH-SCF-043
						}
					}
					if((NarcoticPrint.toUpperCase()).equals("Y")){
						/*ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
						ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHRNARFORM") ;
						report2.addParameter("p_report_id", "PHRNARFORM") ;
						report2.addParameter("P_FR_ORDER_ID", (String)all_orders.get(0)) ;
						report2.addParameter("P_TO_ORDER_ID", (String)all_orders.get(all_orders.size()-1)) ;
						report2.addParameter("p_language_id", getLanguageId()) ;
						onlineReports.add( report2) ;
						onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );	*/
						onlineReports 	= new ecis.utils.OnlineReports() ;  //moved outside from for loop for KAUH-SCF-043
						for(int i=0;i<narcotic_nos.size();i++){
							report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHRNARFORM") ;
							report2.addParameter("p_report_id", "PHRNARFORM") ;
							report2.addParameter("P_LANGUAGE_ID", getLanguageId()) ;
							report2.addParameter("P_FACILITY_ID", login_facility_id) ;
							report2.addParameter("P_NARCOTIC_NO", (String)narcotic_nos.get(i)) ;
							report2.addParameter("P_REPRINT", "N") ;
							report2.addParameter("p_patient_id", patient_id) ;//code added for SKR-SCF-0915[IN046734]  
							onlineReports.add( report2) ;
						}
						onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );  //moved outside from for loop for KAUH-SCF-043
					}
				}
			}
			if(MARLabelPrint.equals("Y")){ //if block Added for MMS-QH-CRF-0080 [IN:038064]
				ArrayList MAROrderLines = new ArrayList();
				pstmt				= connection.prepareStatement("SELECT ORDER_ID, ORDER_LINE_NUM FROM OR_ORDER_LINE_PH WHERE ORDER_ID BETWEEN ? AND ? AND BUILD_MAR_YN='Y'") ;
				pstmt.setString(1,(String)all_orders.get(0));
				pstmt.setString(2,(String)all_orders.get(all_orders.size()-1));
                resultSet			= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					MAROrderLines.add(resultSet.getString("ORDER_ID"));
					MAROrderLines.add(resultSet.getString("ORDER_LINE_NUM"));
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;

				onlineReports 	= new ecis.utils.OnlineReports() ;
				for(int i=0;i<MAROrderLines.size();i+=2){
					report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHPRMARLBL") ;
					report2.addParameter("p_report_id", "PHPRMARLBL") ;
					report2.addParameter("P_LANGUAGE_ID", getLanguageId()) ;
					report2.addParameter("P_FACILITY_ID", login_facility_id) ;
					report2.addParameter("P_ORDER_ID", (String)MAROrderLines.get(i)) ;
					report2.addParameter("P_ORDER_LINE_NUM", (String)MAROrderLines.get(i+1)) ;
					report2.addParameter("p_patient_id", patient_id) ;//code added for SKR-SCF-0915[IN046734]  
					onlineReports.add( report2) ;
				}
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response ); 
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
		return true;
	}

	public void clear() {
		if(presDetails!=null && presDetails.size()>0) {
			super.clear() ;
			order_date		= null;
			OrderRemarks		= null;
			if(amendDetails!=null)//Added if Condition for HSA-SCF-0036[IN 50011]
				print_ord_sht_rule_ind="";
			if(presDetails!=null)
				presDetails.clear();
			if(amendDetails!=null)
				amendDetails.clear();
			if(groupCode!=null)
				groupCode.clear();
			if(orderCode!=null)
				orderCode.clear();
			if(presHeader!=null)
				presHeader.clear();
			if(scheduleFrequency!=null)
				scheduleFrequency.clear();
			if(groupRecord!=null)
				groupRecord.clear();
			if(OrderID!=null)
				OrderID.clear();
			if(orderDetails!=null)
				orderDetails.clear();
			if(DrugRemarks!=null)
				DrugRemarks.clear();
			srlNo= 0;
			AmendOrderRemarks	= null;
			if(AmendAllergyRemarks!=null)
				AmendAllergyRemarks.clear();
			if(AmendDoseRemarks!=null)
				AmendDoseRemarks.clear();
			if(AmendRxRemarks!=null)
				AmendRxRemarks.clear();
			amendOrderID		= null;
			if(amendDrugCodes!=null)
				amendDrugCodes.clear();
			if(disp_locn_code!=null)
				disp_locn_code.clear();
			if(presDetails!=null)
				Refill_Detail.clear();
			schdMap = null;
			ord_facility_id = null;
			take_home_count=0;
		}
		OrderRemarks		= null;
		copy_prescriptions  = null;
		discPrescriptions  = null;//Added for Bru-HIMS-CRF-403
		selecteddrugs  = null;//Added for Bru-HIMS-CRF-403
		defaultDuration		= null;//Added for Bru-HIMS-CRF-403
		all_drugs			= null;
		old_order_det		= null;
		age_group			=	null;
		prn_remarks			= null;
		prn_remarks_values	= null;
		ExternalPresDispCodes	= null;
		ExternalPresDispDesc	= null;
		exist_orders			=	null;
		trn_group_ref		= null;	
		tokens_generated_yn		= null;	
		prn_yn					= null ; 

		presItemList		= null ; 
		amend_reason			= null;
		age_group				=	null;
		/*external_patient_id	= null;- Commented for not to clear External Prescription details while loading the prescription from Trascribe External Prescription ICN 29846
		external_ref_facility	= null;
		external_ref_practitioner = null;
		external_date_ref		= null;*/
		predefined_remarks		= null;
		sliding_scale_freq	    = null;
		schdMap = null;
		curr_medn_drugs = null;
		refill_yn_from_param = null;
		ord_facility_id = null;
		act_patient_class_frm_hdr = null;
		pat_specialty_code = null;
		drug_profile_count = 0;
		take_home_count    = 0;
		diagnosis_size     = 0;
		witnessByUser ="";
		hmDiscCancelledOrders = null;  //Added for HSA-CRF-0138 [IN:048414]
		called_from_verbal_order = ""; //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
		org_order_id = null;//added for JD-CRF-198
		amend_alternate_yn="N";//added for  JD-CRF-0198 [IN:058599]
		alterAmendReason = "";//added for  JD-CRF-0198 [IN:058599]
		allow_alt_for_med_item = ""; // Added for GHL-CRF-0549 [IN:068344] - Devindra
		external_drugs = null; // Added for MMS-KH-CRF-0016
		external_drugs_tmp      = null; // added for Inc#70652
		encounter_id = null;//MMS-KH-CRF-0029[IN070606]
		if(nonPreferenceRemarks!=null) //GHL-CRF-0618
			nonPreferenceRemarks.clear();
		if(nonPreferenceRemarksMedicalItem!=null) //GHL-CRF-0618
			nonPreferenceRemarksMedicalItem.clear();
//Added for IN:072715 start
		dose_remarks= new HashMap();
		allergy_remarks= new HashMap();
		dup_drug_remarks= new HashMap();
		drug_inter_remarks= new HashMap();
		food_inter_remarks= new HashMap();
		lab_inter_remarks= new HashMap();
		disease_inter_remarks =new HashMap();//Added for MMS-DM-CRF-0229
		//added for NMC-JD-CRF-0063
		take_home_medication_op=null;
		opDischMedInd = null;
		patient_class_tkHome = null;//NMC-JD-CRF-0063
		//Added for IN:072715 end
		pre_alloc_appl_yn =null;//Added for TFS id:7345
		default_disp_locn_code=null; //Added for TFS-16341
	}
	
	public void copyPresClear(){// Added by Manickavasagam J for SCF-7540
		copy_prescriptions=new ArrayList();
		selecteddrugs = new ArrayList();//Added for Bru-HIMS-CRF-403
		discPrescriptions = new ArrayList(); //Added for Bru-HIMS-CRF-403
	}
	
	public void copyDiscPresClear(){//Added for BRU-HIMS-CRF-403 
		discPrescriptions  =  new ArrayList();
		selecteddrugs = new ArrayList();
	}
	
	public ArrayList getRenewDates(String duration,String order_id, String drug_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList renew_dates		=	new ArrayList(2);
	
		try{
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RENEW_PRESCRIPTION_SELECT1")) ;
			pstmt.setString(1,duration);
			pstmt.setString(2,order_id);
			pstmt.setString(3,drug_code);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				renew_dates.add(checkForNull((String)resultSet.getString("START_DATE")));
				renew_dates.add(checkForNull((String)resultSet.getString("END_DATE")));
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
		return renew_dates;
	}

	public HashMap getPreviousOrders(String patient_class,String pract_id,String patient_id,String ord_status,String ord_frm,String ord_to,String from,String to, String drug_desc,String group_by, String drug_priv_appln_yn,String p_resp_id, String log_pract_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ResultSet resultSet_meta	=	null;

		String append_str			= "";
		HashMap total_result		= new HashMap();
		ArrayList result			= new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 10;
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;
		String start_date="";
		String end_date="", ord_date="";
		ArrayList curr_alphabets	= new ArrayList();
		locale= getLanguageId()==null?"en":getLanguageId();
		if(drug_desc==null || drug_desc.equals(""))
			drug_desc = "%";
		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
		
		try {
			connection = getConnection() ;
			if(patient_class.equals("B")) 
				append_str	= " AND A.PATIENT_CLASS IN ('IP','OP','EM','XT') ";
			else 
				append_str	= " AND A.PATIENT_CLASS=? ";	// COMMON-ICN-0184

			if(ord_status.equals("A")) 
				append_str	=append_str+ " AND B.ORDER_LINE_STATUS IN ('DF','CN','DC','DP','OS','AL','IP','VF','RG','UC','DD','DE') "; //added 'UC' for Incident No:033118 //DE,DD added for MMS-DM-CRF-0199
			else if(ord_status.equals("AL"))
				append_str	= append_str+ " AND B.ORDER_LINE_STATUS IN ('AL','IP') ";
			else if(ord_status.equals("OS"))
				append_str	= append_str+" AND B.ORDER_LINE_STATUS IN ('OS','VF','RG') ";
			else  
				append_str	= append_str+ " AND B.ORDER_LINE_STATUS=? "; // '"+ord_status.trim()+"' "; COMMON-ICN-0184

			if(!pract_id.equals("")) 
				append_str	= append_str +" AND A.ORD_PRACT_ID=?"; //+pract_id.trim()+"' ";

			if(!patient_id.equals("")) 
				append_str	=  append_str+" AND A.PATIENT_ID=?"; //'"+patient_id.trim()+"' ";
			int bindCount=0;
			if(group_by.equals("DR")) {
				//String repQryStr = "SELECT A.IV_PREP_YN,B.ORDER_ID, B.ORDER_LINE_NUM,B.ORDER_CATALOG_CODE, H.DRUG_DESC CATALOG_DESC,DECODE(SUBSTR(B.CATALOG_DESC,1,1),?,0,1) DUP_DESC,B.QTY_VALUE,B.QTY_UNIT,B.FREQ_CODE, decode(j.split_yn, 'Y',c.freq_desc || ' (Divided)',c.freq_desc) FREQ_DESC, B.DURN_VALUE,B.DURN_TYPE,E.DURN_DESC, TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY hh24:mi') START_DATE, TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY hh24:mi')END_DATE, A.SOURCE_CODE, K.PRACTITIONER_NAME ORD_PRACT_ID,DECODE(A.SOURCE_TYPE,'N',   F.LONG_DESC,G.LONG_DESC) LOCATION,B.ORDER_LINE_STATUS,h.DISCONTINUED_YN,I.SLIDING_SCALE_YN,OR_GET_PRIV_APPL_YN(?,?,'OR',h.drug_code,?,b.order_type_code,'PH') PRIV_APPL_YN,H.APPL_TO_VERBAL_ORDER_YN  FROM OR_ORDER A, OR_ORDER_LINE B, AM_FREQUENCY_LANG_VW C, AM_DURATION_TYPE_LANG_VW E, IP_NURSING_UNIT_LANG_VW F, OP_CLINIC_LANG_VW G, PH_DRUG_LANG_VW H , OR_ORDER_LINE_PH I, ph_patient_drug_profile j, AM_PRACTITIONER_LANG_VW K WHERE A.ORDER_ID   = B.ORDER_ID AND I.ORDER_ID = B.ORDER_ID AND I.ORDER_LINE_NUM = B.ORDER_LINE_NUM AND i.order_id = j.orig_order_id AND i.order_line_num = j.ORIG_ORDER_LINE_NO	 AND C.FREQ_CODE  = B.FREQ_CODE AND E.DURN_TYPE     = B.DURN_TYPE AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND G.CLINIC_CODE(+)=A.SOURCE_CODE AND H.drug_code = b.order_catalog_code AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/YYYY') AND  TO_DATE(?,'DD/MM/YYYY') + 0.99999 AND A.ORDER_CATEGORY='PH' AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = ? AND F.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ? AND H.DRUG_YN ='Y' AND H.LANGUAGE_ID(+) = ? AND K.PRACTITIONER_ID = A.ORD_PRACT_ID AND K.LANGUAGE_ID(+) = ?"; //changed B.CATALOG_DESC to H.DRUG_DESC and PH_DRUG to PH DRUG_LANG_VW for IN23333 --24/08/2010-- priya  // H.APPL_TO_VERBAL_ORDER_YN Added for ML-BRU-SCF-0958 [IN:042045]
				String repQryStr = "SELECT a.iv_prep_yn, b.order_id, b.order_line_num,b.order_catalog_code, (SELECT drug_desc FROM ph_drug_lang_vw  WHERE drug_code = h.drug_code AND language_id = ?)  catalog_desc,DECODE (SUBSTR (b.catalog_desc, 1, 1), ?, 0, 1) dup_desc, b.qty_value, b.qty_unit, b.freq_code, DECODE (j.split_yn, 'Y', (SELECT freq_desc  FROM am_frequency_lang_vw c  WHERE c.freq_code = b.freq_code AND c.language_id = ?)  || ' (Divided)',  (SELECT freq_desc  FROM am_frequency_lang_vw c WHERE c.freq_code = b.freq_code AND c.language_id = ?))  freq_desc, b.durn_value, b.durn_type,(SELECT e.durn_desc FROM am_duration_type_lang_vw e WHERE e.durn_type = b.durn_type AND e.language_id = ?) durn_desc, TO_CHAR (b.start_date_time, 'DD/MM/YYYY hh24:mi') start_date, TO_CHAR (b.end_date_time, 'DD/MM/YYYY hh24:mi') end_date, a.source_code, (SELECT k.practitioner_name  FROM am_practitioner_lang_vw k WHERE k.practitioner_id = a.ord_pract_id AND k.language_id(+) = ?)  ord_pract_id, DECODE ( a.source_type,'N', (SELECT f.long_desc FROM ip_nursing_unit_lang_vw f  WHERE     f.nursing_unit_code(+) = a.source_code  AND a.ordering_facility_id = f.facility_id(+)  AND f.language_id(+) = ?), (SELECT g.long_desc  FROM op_clinic_lang_vw g  WHERE     g.clinic_code(+) = a.source_code  AND a.ordering_facility_id = g.facility_id(+)  AND g.language_id(+) = ?)) LOCATION, b.order_line_status,  h.discontinued_yn, i.sliding_scale_yn, or_get_priv_appl_yn (?, ?, 'OR', h.drug_code, ?, b.order_type_code, 'PH')  priv_appl_yn, h.appl_to_verbal_order_yn  FROM or_order a, or_order_line b, or_order_line_ph i, ph_patient_drug_profile j, ph_drug h WHERE  a.order_id = b.order_id  AND i.order_id = b.order_id AND i.order_line_num = b.order_line_num  AND i.order_id = j.orig_order_id  AND i.order_line_num = j.orig_order_line_no  AND a.ord_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY')  AND TO_DATE ( ?, 'DD/MM/YYYY') + 0.99999 AND h.drug_code = b.order_catalog_code AND h.drug_yn = 'Y'  AND a.order_category = 'PH' ";
				//mofied for SKR-SCF-1574 performance
				//SQL_PH_PRESCRIPTION_SELECT68A
				pstmt	   = connection.prepareStatement( repQryStr+append_str+" ORDER BY DUP_DESC, B.CATALOG_DESC,a.ord_date_time desc, B.ORDER_ID , B.ORDER_LINE_NUM") ;
				
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,drug_desc);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);

				pstmt.setString(++bindCount,log_pract_id);
				pstmt.setString(++bindCount,p_resp_id);
				pstmt.setString(++bindCount,drug_priv_appln_yn);
				pstmt.setString(++bindCount,ord_frm);
				pstmt.setString(++bindCount,ord_to);
				
			
			}
			else {
				//String repQryStr = "SELECT A.IV_PREP_YN,B.ORDER_ID,B.ORDER_LINE_NUM,B.ORDER_CATALOG_CODE,H.DRUG_DESC CATALOG_DESC,B.QTY_VALUE,B.QTY_UNIT,B.FREQ_CODE,decode(j.split_yn, 'Y', c.freq_desc||' (Divided)',c.freq_desc) FREQ_DESC,B.DURN_VALUE,TO_CHAR(A.ORD_DATE_TIME,'DD/MM/YYYY hh24:mi')ORD_DATE_TIME,B.DURN_TYPE,E.DURN_DESC,TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY hh24:mi') START_DATE, TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY hh24:mi')END_DATE, A.SOURCE_CODE,K.PRACTITIONER_NAME ORD_PRACT_ID,DECODE(A.SOURCE_TYPE,'N',F.LONG_DESC,G.LONG_DESC) LOCATION,B.ORDER_LINE_STATUS,h.DISCONTINUED_YN,I.SLIDING_SCALE_YN,OR_GET_PRIV_APPL_YN(?,?,'OR',h.drug_code,?,b.order_type_code,'PH') PRIV_APPL_YN,H.APPL_TO_VERBAL_ORDER_YN FROM OR_ORDER A,OR_ORDER_LINE B,AM_FREQUENCY_LANG_VW C,AM_DURATION_TYPE_LANG_VW E,IP_NURSING_UNIT_LANG_VW F,  OP_CLINIC_LANG_VW G , PH_DRUG_LANG_VW H, OR_ORDER_LINE_PH I, ph_patient_drug_profile j, AM_PRACTITIONER_LANG_VW K WHERE A.ORDER_ID   = B.ORDER_ID AND I.ORDER_ID = B.ORDER_ID AND I.ORDER_LINE_NUM = B.ORDER_LINE_NUM AND i.order_id = j.orig_order_id AND i.order_line_num = j.ORIG_ORDER_LINE_NO	AND C.FREQ_CODE  = B.FREQ_CODE AND E.DURN_TYPE     = B.DURN_TYPE AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND G.CLINIC_CODE(+)=A.SOURCE_CODE AND H.DRUG_CODE = B.ORDER_CATALOG_CODE AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') + 0.99999 AND  A.ORDER_CATEGORY='PH' AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = ? AND F.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ? AND H.DRUG_YN ='Y' AND H.LANGUAGE_ID(+) = ? AND K.PRACTITIONER_ID = A.ORD_PRACT_ID AND K.LANGUAGE_ID(+) = ?";//changed B.CATALOG_DESC to H.DRUG_DESC and PH_DRUG to PH DRUG_LANG_VW for IN23333 --24/08/2010-- priya // H.APPL_TO_VERBAL_ORDER_YN Added for ML-BRU-SCF-0958 [IN:042045]
				//SQL_PH_PRESCRIPTION_SELECT70
				//pstmt	   = connection.prepareStatement( repQryStr+append_str+" ORDER BY B.ORDER_ID DESC, B.ORDER_LINE_NUM, B.CATALOG_DESC") ;
			String repQryStr ="SELECT a.iv_prep_yn, b.order_id, b.order_line_num, b.order_catalog_code,(SELECT drug_desc FROM ph_drug_lang_vw  WHERE drug_code = h.drug_code AND language_id = ?) catalog_desc, b.qty_value, b.qty_unit, b.freq_code, DECODE (j.split_yn, 'Y', (SELECT freq_desc FROM am_frequency_lang_vw c  WHERE c.freq_code = b.freq_code AND c.language_id = ?)   || ' (Divided)', (SELECT freq_desc  FROM am_frequency_lang_vw c  WHERE c.freq_code = b.freq_code AND c.language_id = ?)) freq_desc, b.durn_value,  TO_CHAR (a.ord_date_time, 'DD/MM/YYYY hh24:mi') ord_date_time,  b.durn_type,  (SELECT e.durn_desc  FROM am_duration_type_lang_vw e  WHERE e.durn_type = b.durn_type AND e.language_id = ?) durn_desc,  TO_CHAR (b.start_date_time, 'DD/MM/YYYY hh24:mi') start_date, TO_CHAR (b.end_date_time, 'DD/MM/YYYY hh24:mi') end_date, a.source_code, (SELECT k.practitioner_name  FROM am_practitioner_lang_vw k  WHERE k.practitioner_id = a.ord_pract_id AND k.language_id(+) = ?)ord_pract_id, DECODE (a.source_type, 'N', (SELECT f.long_desc FROM ip_nursing_unit_lang_vw f WHERE f.nursing_unit_code(+) = a.source_code  AND a.ordering_facility_id = f.facility_id(+)  AND f.language_id(+) = ?), (SELECT g.long_desc  FROM op_clinic_lang_vw g  WHERE g.clinic_code(+) = a.source_code  AND a.ordering_facility_id = g.facility_id(+)   AND g.language_id(+) = ?)  ) LOCATION, b.order_line_status, h.discontinued_yn, i.sliding_scale_yn, or_get_priv_appl_yn (?, ?, 'OR', h.drug_code, ?, b.order_type_code, 'PH' ) priv_appl_yn, h.appl_to_verbal_order_yn  FROM or_order a,  or_order_line b, ph_drug h, or_order_line_ph i, ph_patient_drug_profile j  WHERE a.order_id = b.order_id   AND i.order_id = b.order_id   AND i.order_line_num = b.order_line_num    AND i.order_id = j.orig_order_id    AND i.order_line_num = j.orig_order_line_no   AND h.drug_code = b.order_catalog_code    AND a.ord_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY')  AND TO_DATE (?, 'DD/MM/YYYY') + 0.99999  AND a.order_category = 'PH'  AND h.drug_yn = 'Y' "; 
			//modified for SKR-SCF-1574 - performance

				
				pstmt	   = connection.prepareStatement( repQryStr+append_str+" ORDER BY a.ord_date_time desc, B.ORDER_ID , B.ORDER_LINE_NUM, B.CATALOG_DESC") ;

				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);//10
				pstmt.setString(++bindCount,log_pract_id);
				pstmt.setString(++bindCount,p_resp_id);
				pstmt.setString(++bindCount,drug_priv_appln_yn);
				pstmt.setString(++bindCount,ord_frm);
				pstmt.setString(++bindCount,ord_to);
		
			}
			if(!patient_class.equals("B")) 
				pstmt.setString(++bindCount,patient_class.trim());
			if((!ord_status.equals("A") && !ord_status.equals("AL") && !ord_status.equals("OS")))
				pstmt.setString(++bindCount,ord_status.trim());
			if(!pract_id.equals("")) 
				pstmt.setString(++bindCount,pract_id.trim());
			if(!patient_id.equals("")) 
				pstmt.setString(++bindCount,patient_id.trim());
			resultSet = pstmt.executeQuery();
			result.add("link");// added for previous orders  performance tuning
			while ( resultSet != null && resultSet.next() && i <= end+1 ) { // && i <= end+1  added for copy previous order performance tuning
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
					count++ ;
               if(i<=end) {
				   // adding end
					result.add((String)resultSet.getString("ORDER_LINE_STATUS"));//1
					result.add((String)resultSet.getString("ORDER_ID"));//2
					result.add((String)resultSet.getString("ORDER_LINE_NUM"));//3
					result.add((String)resultSet.getString("ORDER_CATALOG_CODE"));//4
					result.add((String)resultSet.getString("CATALOG_DESC"));//5
					result.add((String)resultSet.getString("QTY_VALUE"));//6
					result.add((String)resultSet.getString("QTY_UNIT"));//7
					result.add((String)resultSet.getString("FREQ_CODE"));//8
					result.add((String)resultSet.getString("FREQ_DESC"));//9
					result.add((String)resultSet.getString("DURN_VALUE"));//10
					result.add((String)resultSet.getString("DURN_TYPE"));//11
					result.add((String)resultSet.getString("DURN_DESC"));//12
					start_date= (String)resultSet.getString("START_DATE");
					end_date= (String)resultSet.getString("END_DATE");
					if(!locale.equals("en")){
						start_date = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM","en",locale);
						end_date = com.ehis.util.DateUtils.convertDate(end_date, "DMYHM","en",locale);
					}
					result.add(start_date);//13
					result.add(end_date);//14
					result.add((String)resultSet.getString("SOURCE_CODE"));//15
					result.add((String)resultSet.getString("ORD_PRACT_ID"));//16
					result.add((String)resultSet.getString("LOCATION"));//17
					result.add((String)resultSet.getString("IV_PREP_YN"));//18

					if(group_by.equals("PR")) {
						ord_date = (String)resultSet.getString("ORD_DATE_TIME");
						if(!locale.equals("en")){
							ord_date = com.ehis.util.DateUtils.convertDate(ord_date, "DMYHM","en",locale);
						}
						result.add(ord_date);//19
					
					}

					result.add((String)resultSet.getString("DISCONTINUED_YN"));//20
					result.add((String)resultSet.getString("SLIDING_SCALE_YN"));//21
					result.add((String)resultSet.getString("PRIV_APPL_YN"));//22
                    result.add(checkForNull((String)resultSet.getString("APPL_TO_VERBAL_ORDER_YN")));//23 Added for ML-BRU-SCF-0958 [IN:042045]

					if(!curr_alphabets.contains((resultSet.getString("CATALOG_DESC")).substring(0,1)))
					   curr_alphabets.add( (resultSet.getString("CATALOG_DESC")).substring(0,1) );
				}
			}
			all_drugs	=	new ArrayList();
			boolean taper_dup = false;
			String ord_id ="";
			String ord_cat_code = "";
			String ord_id1 ="";
			String ord_cat_code1 = "";
			resultSet_meta	= pstmt.executeQuery() ;
			while( resultSet_meta != null && resultSet_meta.next() ) {
				taper_dup = false;
				for(int indx=0; indx<all_drugs.size(); indx+=2){
					ord_id = (String)all_drugs.get(indx);
					ord_id = ord_id.substring(0, ord_id.indexOf(','));
					ord_cat_code = (String)all_drugs.get(indx+1);
					ord_id1 = (String)resultSet_meta.getString("ORDER_ID");
					ord_cat_code1 =  (String)resultSet_meta.getString("ORDER_CATALOG_CODE");
					if(ord_id.equals(ord_id1) && ord_cat_code.equals(ord_cat_code1)){
						taper_dup = true;
						break;
					}
				}
				if(!taper_dup){
					all_drugs.add((String)resultSet_meta.getString("ORDER_ID")+","+((String)resultSet_meta.getString("ORDER_LINE_NUM")));
					all_drugs.add((String)resultSet_meta.getString("ORDER_CATALOG_CODE"));
				}
			}
			if( start != 1 )// added for previous orders  performance tuning -Start
				prevnextlink = prevnextlink + "<td align='right' id='Navigation'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 10 ){
				prevnextlink = prevnextlink + "<td align='right' id='Navigation'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"')\">Next</a>" ;
			}
			if(result!=null)	{					
				result.set(0,prevnextlink);				
			}// added for previous orders  performance tuning - end
			total_result.put("RESULT",result);
		}
		catch ( Exception e ) {				
			e.printStackTrace() ;
		 }
		 finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet_meta ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return total_result;
	}
	
	public void clearCopiedDrugs(String drug_code) {
		if(this.getPrescriptions()!=null){
			int index	=	(this.getPrescriptions()).indexOf(drug_code);
			if(index!=-1 && this.getPrescriptions().size() >=index) {
				if(this.getPrescriptions().contains(this.getPrescriptions().get(index-1)) &&
					this.getPrescriptions().contains(drug_code) ) {
					this.getPrescriptions().remove(this.getPrescriptions().get(index-1));
					this.getPrescriptions().remove(drug_code);
				}
			}
		}
	}

	public ArrayList getPreviewOrders(String patient_class,String pract_id,String patient_id,String ord_status,String ord_frm,String ord_to, String order_id, String rx_type,String from_date,String to_date){//Added from_date,to_date for Bru-HIMS-CRF-403--end
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        PreparedStatement pstmt1     = null ;//Added for Bru-HIMS-CRF-403
        PreparedStatement pstmt2     = null ;//Added for Bru-HIMS-CRF-403
        ResultSet resultSet         = null ;
        ResultSet rs         = null ;//Added for Bru-HIMS-CRF-403
        ResultSet rs1        = null ;//Added for Bru-HIMS-CRF-403
		ArrayList result			= new ArrayList();
		String append_str			= "";
		String extprodid  			= "";//Added for Bru-HIMS-CRF-403
		String count = "";//Added for Bru-HIMS-CRF-403
		locale= getLanguageId()==null?"en":getLanguageId();
		try {
			if((rx_type==null ||( rx_type.equals(""))) || ((rx_type!=null &&!( rx_type.equals(""))) && !order_id.equals("") )){
				connection = getConnection() ;
				if(patient_class.equals("B")) 
					append_str	= " AND A.PATIENT_CLASS IN ('IP','OP','EM','XT') ";
				else 
					append_str	= " AND A.PATIENT_CLASS=? ";	// COMMON-ICN-0184

				if(ord_status.equals("A")) 
					append_str	=append_str+ " AND B.ORDER_LINE_STATUS IN ('DF','CN','DC','DP','OS','AL','IP','VF','RG','UC') ";//Added UC for Bru-HIMS-CRF-403
				else 
					append_str	=append_str+ " AND B.ORDER_LINE_STATUS=? "; // COMMON-ICN-0184

				if(!pract_id.equals("")) 
					append_str	= append_str+" AND A.ORD_PRACT_ID=? "; // COMMON-ICN-0184

				if(!patient_id.equals("")) 
					append_str	=append_str+ " AND A.PATIENT_ID=? "; // COMMON-ICN-0184

				if(!order_id.equals(""))
					append_str	=append_str+ " AND A.ORDER_ID=? ";

				pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT68")+append_str+" ORDER BY a.ord_date_time DESC, b.order_id, b.order_line_num, b.catalog_desc") ;//Modified for Bru-HIMS-CRF-403
				int pstcount=1;
				pstmt.setString(pstcount,"%");
				pstmt.setString(++pstcount,login_facility_id);
				pstmt.setString(++pstcount,locale);
				pstmt.setString(++pstcount,ord_frm);
				pstmt.setString(++pstcount,ord_to);
				pstmt.setString(++pstcount,locale);
				pstmt.setString(++pstcount,locale);
				pstmt.setString(++pstcount,locale);
				pstmt.setString(++pstcount,locale);//Added for Bru-HIMS-CRF-403
				if(!patient_class.equals("B")) 
					pstmt.setString(++pstcount,patient_class.trim()); // COMMON-ICN-0184
				if(!ord_status.equals("A")) 
					pstmt.setString(++pstcount,ord_status.trim());
				if(!pract_id.equals("")) 
					pstmt.setString(++pstcount,pract_id.trim());
				if(!patient_id.equals("")) 
					pstmt.setString(++pstcount,patient_id.trim());
				if(!order_id.equals(""))
					pstmt.setString(++pstcount,order_id.trim()); // COMMON-ICN-0184
				
				resultSet			= pstmt.executeQuery();
				while(resultSet != null && resultSet.next() )	{
					//	if(getPrescriptions().contains(((String)resultSet.getString("ORDER_ID"))+","+((String)resultSet.getString("ORDER_LINE_NUM")))   
					if(rx_type!=null &&!( rx_type.equals(""))) {
						result.add((String)resultSet.getString("ORDER_LINE_STATUS"));
						result.add((String)resultSet.getString("ORDER_ID"));
						result.add((String)resultSet.getString("ORDER_LINE_NUM"));
						result.add((String)resultSet.getString("ORDER_CATALOG_CODE"));
						result.add((String)resultSet.getString("CATALOG_DESC"));
						result.add((String)resultSet.getString("QTY_VALUE"));
						result.add((String)resultSet.getString("QTY_UNIT"));
						result.add((String)resultSet.getString("FREQ_CODE"));
						result.add((String)resultSet.getString("FREQ_DESC"));
						result.add((String)resultSet.getString("DURN_VALUE"));
						result.add((String)resultSet.getString("DURN_TYPE"));
						result.add((String)resultSet.getString("DURN_DESC"));
						result.add((String)resultSet.getString("START_DATE"));
						result.add((String)resultSet.getString("END_DATE"));
						result.add((String)resultSet.getString("SOURCE_CODE"));
						result.add((String)resultSet.getString("ORD_PRACT_ID"));
						result.add((String)resultSet.getString("LOCATION"));
						result.add((String)resultSet.getString("ord_date_time"));//Added for Bru-HIMS-CRF-403--start
						result.add((String)resultSet.getString("generic_id"));
						pstmt1	   = connection.prepareStatement("select (ph_get_ext_prod_drug_code(?,?))extprodid  from  dual" );
						pstmt1.setString(1,(String)resultSet.getString("ORDER_CATALOG_CODE"));
						pstmt1.setString(2,login_facility_id);
						rs = pstmt1.executeQuery();
						if(rs.next()){
							extprodid = rs.getString("extprodid")==null?"":rs.getString("extprodid");
						}
						result.add(extprodid);
						pstmt2	   = connection.prepareStatement("SELECT  COUNT(ROWID) count FROM  PH_PATIENT_DRUG_PROFILE A WHERE   PATIENT_ID =?  AND  (TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE AND  END_DATE OR TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE AND  END_DATE OR  START_DATE BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND  TO_DATE(?,'DD/MM/YYYY HH24:MI') OR  END_DATE BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND  TO_DATE(?,'DD/MM/YYYY HH24:MI')) AND DISCONT_DATE_TIME IS NULL AND ON_HOLD_DATE_TIME IS NULL AND  CANCEL_YN='N' AND   STOP_YN='N' AND 'O'!=(SELECT FREQ_NATURE FROM AM_FREQUENCY WHERE FREQ_CODE=?) AND GENERIC_ID=?");
						pstmt2.setString(1,patient_id);
						pstmt2.setString(2,from_date);
						pstmt2.setString(3,to_date);
						pstmt2.setString(4,from_date);			
						pstmt2.setString(5,to_date);
						pstmt2.setString(6,from_date);			
						pstmt2.setString(7,to_date);
						pstmt2.setString(8,(String)resultSet.getString("FREQ_CODE"));
						pstmt2.setString(9,(String)resultSet.getString("generic_id"));	
						rs1 = pstmt2.executeQuery();
						if(rs1.next()){
							count = rs1.getString("count")==null?"":rs1.getString("count");
						}
						if(count!=null && !count.equals("0")){
							result.add("Y");
						}
						else
							result.add("N");//Added for Bru-HIMS-CRF-403--end
					}
					else{
						if(getPrescriptions()!=null && getPrescriptions().contains(((String)resultSet.getString("ORDER_ID"))+","+((String)resultSet.getString("ORDER_LINE_NUM")))){
							result.add((String)resultSet.getString("ORDER_LINE_STATUS"));
							result.add((String)resultSet.getString("ORDER_ID"));
							result.add((String)resultSet.getString("ORDER_LINE_NUM"));
							result.add((String)resultSet.getString("ORDER_CATALOG_CODE"));
							result.add((String)resultSet.getString("CATALOG_DESC"));
							result.add((String)resultSet.getString("QTY_VALUE"));
							result.add((String)resultSet.getString("QTY_UNIT"));
							result.add((String)resultSet.getString("FREQ_CODE"));
							result.add((String)resultSet.getString("FREQ_DESC"));
							result.add((String)resultSet.getString("DURN_VALUE"));
							result.add((String)resultSet.getString("DURN_TYPE"));
							result.add((String)resultSet.getString("DURN_DESC"));
							result.add((String)resultSet.getString("START_DATE"));
							result.add((String)resultSet.getString("END_DATE"));
							result.add((String)resultSet.getString("SOURCE_CODE"));
							result.add((String)resultSet.getString("ORD_PRACT_ID"));
							result.add((String)resultSet.getString("LOCATION"));
							result.add((String)resultSet.getString("ord_date_time"));//Added for Bru-HIMS-CRF-403--start
							result.add((String)resultSet.getString("generic_id"));
							pstmt1	   = connection.prepareStatement("select (ph_get_ext_prod_drug_code(?,?))extprodid  from  dual" );
							pstmt1.setString(1,(String)resultSet.getString("ORDER_CATALOG_CODE"));
							pstmt1.setString(2,login_facility_id);
							rs = pstmt1.executeQuery();
							if(rs.next()){
								extprodid = rs.getString("extprodid")==null?"":rs.getString("extprodid");
							}
							result.add(extprodid);
							pstmt2	   = connection.prepareStatement("SELECT  COUNT(ROWID) count FROM  PH_PATIENT_DRUG_PROFILE A WHERE   PATIENT_ID =?  AND  (TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE AND  END_DATE OR TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE AND  END_DATE OR  START_DATE BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND  TO_DATE(?,'DD/MM/YYYY HH24:MI') OR  END_DATE BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND  TO_DATE(?,'DD/MM/YYYY HH24:MI')) AND DISCONT_DATE_TIME IS NULL AND ON_HOLD_DATE_TIME IS NULL AND  CANCEL_YN='N' AND   STOP_YN='N' AND 'O'!=(SELECT FREQ_NATURE FROM AM_FREQUENCY WHERE FREQ_CODE=?) AND GENERIC_ID=?");
							pstmt2.setString(1,patient_id);
							pstmt2.setString(2,from_date);
							pstmt2.setString(3,to_date);
							pstmt2.setString(4,from_date);			
							pstmt2.setString(5,to_date);
							pstmt2.setString(6,from_date);			
							pstmt2.setString(7,to_date);
							pstmt2.setString(8,(String)resultSet.getString("FREQ_CODE"));
							pstmt2.setString(9,(String)resultSet.getString("generic_id"));	
							rs1 = pstmt2.executeQuery();
							if(rs1.next()){
								count = rs1.getString("count")==null?"":rs1.getString("count");
							}
							if(count!=null && !count.equals("0")){
								result.add("Y");
							}
							else
								result.add("N");
						}
					}
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
		return result;
	}

	public ArrayList validateForStock(String patient_class){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList stock_params	=	new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT15") );
			pstmt.setString(1,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
				if(patient_class.equals("IP")) {
					stock_params.add(resultSet.getString("IP_CONSIDER_STOCK_PRES_YN"));
					stock_params.add(resultSet.getString("IP_PRES_WITHOUT_STOCK_YN"));
				} 
				else {
					stock_params.add(resultSet.getString("CONSIDER_STOCK_FOR_PRES_YN"));
					stock_params.add(resultSet.getString("ALLOW_PRES_WITHOUT_STOCK_YN"));
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
				es.printStackTrace() ;
			}
		}
		return stock_params;
	}
	
	public ArrayList getParameterValues(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList param_values		= new ArrayList(2);
		String split_drug_based_auth_yn="";//added for ml-mmoh-crf-0864
		String reconciliation_yn="N";//ADDED FOR MMS-KH-CRF-0016
		//String drug_indication_mdry="";//added for jd-crf-0220
		try{
			connection				= getConnection() ;
			//SPLIT_DRUG_BASED_AUTH_YN added for ml-mmoh-crf-0864 
			//reconciliation_yn added for mms-kh-crf-0016
			//DRUG_INDICATION_MDRY ADDED FOR JD-CRF-0220
			//AMEND_ORD_WISE_DISP_MED added for ml-mmoh-scf-1748
			pstmt					= connection.prepareStatement("SELECT ALLOW_MEDN_ORDER_WITHOUT_DIAG, 'Y' ALLOW_MEDN_ORDER_WITHOUT_WT,DISP_CHARGE_DTL_IN_RX_YN, DISP_CHARGE_DTL_IN_DRUG_LKP_YN, DISP_PRICE_TYPE_IN_DRUG_LKP, DC_MAR_APPL_YN, EM_MAR_APPL_YN, IP_MAR_APPL_YN, OP_MAR_APPL_YN, DISCH_MED_MAR_APPL_YN,SPLIT_BASED_PRIORITY_YN, SPLIT_BASED_DRUG_CLASS_YN, NARCOTIC_APRVL_FORM_REQ_YN,PRINT_NARCOTIC_FORM_BY_DEFAULT,RX_QTY_BY_PRES_BASE_UOM_YN, atc_allergy_alert_level, CAN_DISCON_DUP_ORDERS,ALLOW_MEDN_ORD_WITHOUT_DIAG_DD, print_mar_label_yn, print_mar_barcode_yn, VERBAL_ORDER_WITNESS_YN,DISP_RX_DURATION_YN, DIAG_FOR_MEDN_ORDER_BY, CAN_DISCON_DUP_ORDERS_DEF_SEL, DEFAULT_PREV_DRUG_SEL, PREVIEW_RX_YN,SKIP_DUPLICATE_ALERT_IP_YN,SKIP_DUPLICATE_ALERT_OP_YN, DISP_PREV_VITAL_SIGNS_YN,SPLIT_DRUG_BASED_AUTH_YN,ALLOW_ALT_FOR_MEDICAL_ITEM_YN,RECONCILIATION_YN,DRUG_INDICATION_MDRY,AMEND_ORD_WISE_DISP_MED,QUOTA_LIMIT_CALC_REQ_YN,ACITVE_PREP_APPL_QUOTA_YN FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?") ;//added DISP_RX_DURATION_YN for  BRU-HIMS-CRF-403 added ALLOW_MEDN_ORD_WITHOUT_DIAG_DD for CRF MMS-QH-CRF-0068 [IN:037980] // ALLOW_ALT_FOR_MEDICAL_ITEM_YN Added for GHL-CRF-0549 [IN:068344] - Devindra // ML-MMOH-CRF-1823 US008- 43528  
			pstmt.setString(1,login_facility_id);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				param_values.add(checkForNull(resultSet.getString("ALLOW_MEDN_ORDER_WITHOUT_DIAG")));//0
				param_values.add(checkForNull(resultSet.getString("ALLOW_MEDN_ORDER_WITHOUT_WT")));//1
				param_values.add(checkForNull(resultSet.getString("DISP_CHARGE_DTL_IN_RX_YN")));//2
				param_values.add(checkForNull(resultSet.getString("DISP_CHARGE_DTL_IN_DRUG_LKP_YN")));//3
				param_values.add(checkForNull(resultSet.getString("DISP_PRICE_TYPE_IN_DRUG_LKP")));//4
				param_values.add(checkForNull(resultSet.getString("DC_MAR_APPL_YN")));//5
				param_values.add(checkForNull(resultSet.getString("EM_MAR_APPL_YN")));//6
				param_values.add(checkForNull(resultSet.getString("IP_MAR_APPL_YN")));//7
				param_values.add(checkForNull(resultSet.getString("OP_MAR_APPL_YN")));//8
				param_values.add(checkForNull(resultSet.getString("DISCH_MED_MAR_APPL_YN")));//9
				param_values.add(checkForNull(resultSet.getString("SPLIT_BASED_PRIORITY_YN")));//10
				param_values.add(checkForNull(resultSet.getString("SPLIT_BASED_DRUG_CLASS_YN")));//11
				param_values.add(checkForNull(resultSet.getString("NARCOTIC_APRVL_FORM_REQ_YN")));//12
				param_values.add(checkForNull(resultSet.getString("PRINT_NARCOTIC_FORM_BY_DEFAULT")));//13
				param_values.add(checkForNull(resultSet.getString("RX_QTY_BY_PRES_BASE_UOM_YN")));//14
				param_values.add(checkForNull(resultSet.getString("atc_allergy_alert_level"),"N"));//15	
				param_values.add(checkForNull(resultSet.getString("ALLOW_MEDN_ORD_WITHOUT_DIAG_DD")));//16// added for CRF MMS-QH-CRF-0068 [IN:037980]
				param_values.add(checkForNull(resultSet.getString("print_mar_label_yn")));//17// added for  MMS-QH-CRF-0080 [IN:038064]
				param_values.add(checkForNull(resultSet.getString("print_mar_barcode_yn")));//18// added for  MMS-QH-CRF-0080 [IN:038064]
				param_values.add(checkForNull(resultSet.getString("DISP_RX_DURATION_YN")));//19// added for  BRU-HIMS-CRF-403
				param_values.add(checkForNull(resultSet.getString("DIAG_FOR_MEDN_ORDER_BY")));//20// added for MMS-SCF-0325 [IN:048069]
				param_values.add(checkForNull(resultSet.getString("DEFAULT_PREV_DRUG_SEL")));//21//added for PMG2012-CRF-0019 [IN:035859] AutoComplete
				param_values.add(checkForNull(resultSet.getString("PREVIEW_RX_YN"),"N"));//22 //added for ML-MMOH-CRF-0341 [IN:057179]
				param_values.add(checkForNull(resultSet.getString("DISP_PREV_VITAL_SIGNS_YN"),"N"));//23 //added for ML-MMOH-CRF-0346 [IN:057185]	

								
				split_drug_based_auth_yn=(checkForNull(resultSet.getString("SPLIT_DRUG_BASED_AUTH_YN"),"N"));//24 //added for ML-MMOH-CRF-0864 
				reconciliation_yn=(checkForNull(resultSet.getString("RECONCILIATION_YN"),"N"));
				//setReconciliation_yn(reconciliation_yn);//added for mms-kh-crf-0016
				//param_values.add(checkForNull(resultSet.getString("DRUG_INDICATION_MDRY"),"N"));//added for jd-crf-0220 removed for amend
				setPrintMarLabel(checkForNull(resultSet.getString("print_mar_label_yn"),"N"));// added for  MMS-QH-CRF-0080 [IN:038064]
				setPrintMarBarcode(checkForNull(resultSet.getString("print_mar_barcode_yn"),"N"));// added for  MMS-QH-CRF-0080 [IN:038064]
				setATCAllergyLevel(checkForNull(resultSet.getString("atc_allergy_alert_level"),"N"));
				setCancelDiscConDupOrders(checkForNull(resultSet.getString("CAN_DISCON_DUP_ORDERS"),"N")); //added for Bru-HIMS-CRF-265 [IN:032315]
				setWitnessForVerbalOrder(checkForNull(resultSet.getString("VERBAL_ORDER_WITNESS_YN"),"N"));	// Added for AAKH-CRF-0023[IN:038259]
				setCancelDiscConDupOrdersDefSelect(checkForNull(resultSet.getString("CAN_DISCON_DUP_ORDERS_DEF_SEL"),"N")); //added for Bru-HIMS-CRF-265 [IN:032315]
				setDefaultPrevDrugSel(checkForNull(resultSet.getString("DEFAULT_PREV_DRUG_SEL"),"")); //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
				setPreviewRxYN(checkForNull(resultSet.getString("PREVIEW_RX_YN"),"N")); //added for ML-MMOH-CRF-0341 [IN:057179]
				setSkipDuplicateAlertIp_yn(checkForNull(resultSet.getString("SKIP_DUPLICATE_ALERT_IP_YN"),"N")); // Added for MO-CRF-20085.1 [IN057392]
				setSkipDuplicateAlertOp_yn(checkForNull(resultSet.getString("SKIP_DUPLICATE_ALERT_OP_YN"),"N")); // Added for MO-CRF-20085.1 [IN057392]
				setAllowAltForMedItem(checkForNull(resultSet.getString("ALLOW_ALT_FOR_MEDICAL_ITEM_YN"),"N")); // Added for GHL-CRF-0549 [IN:068344] - Devindra
				setDrugIndicationMdry(checkForNull(resultSet.getString("DRUG_INDICATION_MDRY"),"N"));//added for JD-CRF-0220
				setAmend_based_order_wise(checkForNull(resultSet.getString("AMEND_ORD_WISE_DISP_MED"),"N"));//added for ml-mmoh-crf-1748
				setQuotaLimitCalcReqYN(checkForNull(resultSet.getString("QUOTA_LIMIT_CALC_REQ_YN"),"N")); // ML-MMOH-CRF-1823 US008- 43528 
				setActivePrepApplQuotaYN(checkForNull(resultSet.getString("ACITVE_PREP_APPL_QUOTA_YN"),"N"));//ML-MMOH-CRF-1823 - 43528
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			//pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("")) ;
			//pstmt					= connection.prepareStatement("select MAX_DURN_FOR_IP_PRES, 'R' CHK_FOR_IP_MAX_DURN_ACTION, MAX_DURN_FOR_OP_PRES, 'R' CHK_FOR_OP_MAX_DURN_ACTION, MAX_DURN_FOR_DM_PRES, 'R' CHK_FOR_DM_MAX_DURN_ACTION, TRADE_DISPLAY_YN,MAX_LENGTH_PRN_REASON,REFILL_YN, DRUG_INTERACTION_CHECK_YN,DISP_NO_PREG_DTL_YN, IV_CALC_INFUSE_BY, MEDN_ORDER_BY from ph_param where MODULE_ID=?") ;//added DISP_NO_PREG_DTL_YN for CRF RUT-CRF-0063[29601]
			pstmt					= connection.prepareStatement("select MAX_DURN_FOR_IP_PRES, 'R' CHK_FOR_IP_MAX_DURN_ACTION, MAX_DURN_FOR_OP_PRES, 'R' CHK_FOR_OP_MAX_DURN_ACTION, MAX_DURN_FOR_DM_PRES, 'R' CHK_FOR_DM_MAX_DURN_ACTION, TRADE_DISPLAY_YN,MAX_LENGTH_PRN_REASON,REFILL_YN, DRUG_INTERACTION_CHECK_YN,DISP_NO_PREG_DTL_YN, IV_CALC_INFUSE_BY, MEDN_ORDER_BY,INFUSION_OVER_APP_YN, DISP_ALT_FORM_YN  from ph_param where MODULE_ID=?") ;//added INFUSION_OVER_APP_YN for CRF AAKH-CRF-0094
//DISP_ALT_FORM_YN added for GHL-CRF-0549
						pstmt.setString(1,"PH");
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				param_values.add(checkForNull(resultSet.getString("MAX_LENGTH_PRN_REASON")));//24
				param_values.add(checkForNull(resultSet.getString("MAX_DURN_FOR_IP_PRES")));//25
				param_values.add(checkForNull(resultSet.getString("CHK_FOR_IP_MAX_DURN_ACTION")));//26
				param_values.add(checkForNull(resultSet.getString("MAX_DURN_FOR_OP_PRES")));//27
				param_values.add(checkForNull(resultSet.getString("CHK_FOR_OP_MAX_DURN_ACTION")));//28
				param_values.add(checkForNull(resultSet.getString("MAX_DURN_FOR_DM_PRES")));//29
				param_values.add(checkForNull(resultSet.getString("CHK_FOR_DM_MAX_DURN_ACTION")));//30
				param_values.add(checkForNull(resultSet.getString("TRADE_DISPLAY_YN")));//31
				param_values.add(checkForNull(resultSet.getString("DRUG_INTERACTION_CHECK_YN")));//32
				param_values.add(checkForNull(resultSet.getString("MEDN_ORDER_BY")));//33 //added for PMG2012-CRF-0019 [IN:035859] AutoComplete -start
				setRefillYNFromParam(checkForNull(resultSet.getString("REFILL_YN"))); 
				setIVCalcInfuseBy(checkForNull(resultSet.getString("IV_CALC_INFUSE_BY"),"D")); 
				setParamVolumeCalc(checkForNull(resultSet.getString("INFUSION_OVER_APP_YN"),"Y")); //Added for AAKH-CRF-0094
				setParamDispByAltForm(checkForNull(resultSet.getString("DISP_ALT_FORM_YN"),"N")); //added for GHL-CRF-0549
			}
			closeResultSet( resultSet ) ;//added for PMG2012-CRF-0019 [IN:035859] AutoComplete -start
			closeStatement( pstmt ) ;
			pstmt					= connection.prepareStatement("SELECT ALLOW_PRIV_TO_ORDER_YN FROM OR_PARAM") ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				param_values.add(checkForNull(resultSet.getString("ALLOW_PRIV_TO_ORDER_YN")));//34
				setAllow_priv_to_order_yn(checkForNull(resultSet.getString("ALLOW_PRIV_TO_ORDER_YN")));
			}//added for PMG2012-CRF-0019 [IN:035859] AutoComplete -end
			param_values.add(checkForNull(split_drug_based_auth_yn));//35 added for ml-mmoh-crf-0864
			param_values.add(reconciliation_yn);//36 added for mms-kh-crf-0016
			
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
		return param_values;
	}

	public ArrayList checkDiagnosis(String patient_id, String encounter_id, String diag_for_medn_order_by){ // encounter_id, diag_for_medn_order_by Added for MMS-SCF-0325 
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList diagnosis			= new ArrayList();
		this.diagnosis_size         =0;
		try{
			connection				= getConnection() ;
			String sql = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT78");
			if(diag_for_medn_order_by.equals("E") && !getActPatientClass_frm_Hdr().equals("XT"))
				sql  = sql + " AND CURR_ENCOUNTER_ID =? ";
			pstmt	= connection.prepareStatement(sql) ;
			pstmt.setString(1,patient_id );
			if(diag_for_medn_order_by.equals("E")  && !getActPatientClass_frm_Hdr().equals("XT"))
				pstmt.setString(2,encounter_id );
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				diagnosis.add(checkForNull(resultSet.getString("DIAG_CODE")));
				diagnosis.add(checkForNull(resultSet.getString("CAUSE_INDICATOR")));
				diagnosis.add(checkForNull(resultSet.getString("DIAG_CODE_SCHEME")));
				diagnosis.add(checkForNull(resultSet.getString("DIAG_DESC")));
			}
			if(diagnosis.size() > 1) {
				int i	= diagnosis.size();
				while(i<12) {
					diagnosis.add("");
					i++;
				}
				this.diagnosis_size =i;
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
		return diagnosis;
	}

	public void setAmendReason(String key, ArrayList values) {
		if(amend_reason==null )
			this.amend_reason = new HashMap();
		this.amend_reason.put(key,values);
	}

	public HashMap getAmendReason() {
		return this.amend_reason;
	}

	public ArrayList getAmendReason(String key) {
		ArrayList reason	=	new ArrayList();

		if(amend_reason!=null && amend_reason.containsKey(key)) {
			reason	=	(ArrayList)amend_reason.get(key);
		}
		return reason;
	}

	public void clearAmendReason(String key) {
		 if(this.amend_reason!=null && this.amend_reason.containsKey(key)) {
			 this.amend_reason.remove(key);
		 }
	}

	public HashMap getPredefinedRemarks(){
		return this.predefined_remarks;
	}

	public void setPredefinedRemarks(String route_code,String form_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		predefined_remarks			= new HashMap();
		locale= getLanguageId()==null?"en":getLanguageId();

		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_SELECT1")) ;
			pstmt.setString(1,form_code );
			pstmt.setString(2,route_code );
			pstmt.setString(3,locale );
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				predefined_remarks.put(checkForNull(resultSet.getString("REMARK_CODE")),checkForNull(resultSet.getString("REMARK_DESC")));				
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
			catch(Exception es){es.printStackTrace();}
        }
	}

	public HashMap getSlidingScaleDetails(String drug_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		HashMap sliding_scale_dtls	= new HashMap();
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_SELECT2")) ;
			pstmt.setString(1,drug_code );
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sliding_scale_dtls.put("APPL_SLIDING_SCALE_YN",resultSet.getString("APPL_SLIDING_SCALE_YN"));				
				sliding_scale_dtls.put("SPLIT_DOSE_YN",resultSet.getString("SPLIT_DOSE_YN"));				
				sliding_scale_dtls.put("TAPER_DOSE_YN",resultSet.getString("TAPER_DOSE_YN"));				
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
		return sliding_scale_dtls;
	}

	public ArrayList getQuantityDtlsFromPTCL(String order_catalog_code){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList qty_details	= new ArrayList();
		locale= getLanguageId()==null?"en":getLanguageId();

		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_SELECT4")) ;
			pstmt.setString(1,order_catalog_code );
			pstmt.setString(2,locale );
			resultSet	= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				qty_details.add(resultSet.getString("QTY_UOM"));				
				qty_details.add(resultSet.getString("SHORT_DESC"));				
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
		return qty_details;
	}

	public HashMap getSlidingScaleFreq(){
		return this.sliding_scale_freq;
	}

	public void setSlidingScaleFreq(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		sliding_scale_freq	= new HashMap();
		locale= getLanguageId()==null?"en":getLanguageId();

		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_SELECT3")) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			resultSet				= pstmt.executeQuery();
			ArrayList freq_dtls		= null;
			while(resultSet!=null && resultSet.next()){
				freq_dtls		= new ArrayList();
				freq_dtls.add(resultSet.getString("FREQ_CODE"));
				freq_dtls.add(resultSet.getString("FREQ_DESC"));
				freq_dtls.add(resultSet.getString("REPEAT_DURN_TYPE"));
				freq_dtls.add(resultSet.getString("DURN_DESC"));
				sliding_scale_freq.put(resultSet.getString("FREQ_CODE"),freq_dtls);											
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

	
	public ArrayList checkRefillOrder(String order_id) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList refill_dtls		= new ArrayList(2);	
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT84")) ;
			pstmt.setString(1,order_id);

			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				refill_dtls.add(checkForNull(resultSet.getString("CHILD_ORDER_YN"))); 
				refill_dtls.add(checkForNull(resultSet.getString("NUM_OF_REFILLS"))); 			
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
		return refill_dtls;
	}

	public String getPatientAllergy(String patient_id,String order_id){
		Connection connection         = null ;
        PreparedStatement pstmt       = null ;
        ResultSet resultSet           = null ;
		String result					=	null ;
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT23B")) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,order_id);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				result = resultSet.getString("ALLERGY_YN");
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
		return result;
	}

	public void getProfileCount(String patient_id){
		Connection connection         = null ;
        PreparedStatement pstmt       = null ;
        ResultSet resultSet           = null ;
		 drug_profile_count			  =	0 ;
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT85")) ;
			pstmt.setString(1,patient_id);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				drug_profile_count = resultSet.getInt("COUNT");
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

	public String getSlidingScalePRNFreq(){
		Connection connection         = null ;
        PreparedStatement pstmt       = null ;
        ResultSet resultSet           = null ;
		String sliding_scale_prn_freq =	null ;
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT15")) ;
			pstmt.setString(1,locale);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sliding_scale_prn_freq = resultSet.getString("FREQ_CODE");
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
		return sliding_scale_prn_freq;
	}

	public String populateEndDateForSlidingScale(String start_date, String durn_value, String durn_type) {
		Connection connection		= null;
        CallableStatement cstmt		= null;
		String end_date				= "";
		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call ph_iv_ret_end_date(?,?,?,?)}");
			cstmt.setString(1, start_date);
			cstmt.setInt(2, Integer.parseInt(durn_value));
			cstmt.setString(3, durn_type);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.execute();
			end_date	= cstmt.getString(4);
		}
		catch (Exception e) {
			end_date = e.toString();
			e.printStackTrace();
		}
		finally {
			try {
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return end_date;
	}

	public String getDispLocn(String formulary, String patient_class, String priority, String drug_code, String locn_type, String locn_code, String take_home, String order_type, String drug_class,String home_leave_yn_val,String patient_id,String encounter_id) {
	System.out.println("getDispLocn"); //added for NMC-JD-CRF-0063
		PreparedStatement pstmt_select		= null;
		ResultSet resultSet					= null;
		Connection connection				= null;
		String perf_deptloc_code ="";
		locale= getLanguageId()==null?"en":getLanguageId();
		boolean site_verbal_order=false;//added for ghl-crf-0509
		
		try {
			connection	= getConnection();
			site_verbal_order = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","PLACED_VERBAL_ORDER_YN");//added for ghl-crf-0509
			if(formulary==null || formulary.equals("null")) {
				formulary	=	"N";
			}
			//added for NMC-JD-CRF-0063
			if(getTakeHomeMedicationOp()!=null && !getTakeHomeMedicationOp().equals("") && getTakeHomeMedicationOp().equals("Y") && getOpDischMedInd()!=null && !getOpDischMedInd().equals("") && getOpDischMedInd().equals("Y")){
				take_home = "Y";
					System.out.println("take_home: "+take_home);  
			}//END
			System.out.println("take_home: "+take_home);  
			System.out.println("getOpDischMedInd: "+getOpDischMedInd());  
//System.err.println("===getDispLocn========formulary=========>"+formulary+" patient_class="+patient_class+" priority="+priority+" drug_code="+drug_code+" locn_type="+locn_type+" take_home="+take_home+" order_type="+order_type+" drug_class="+drug_class+" home_leave_yn_val="+home_leave_yn_val+" patient_id="+patient_id+" encounter_id="+encounter_id);
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
			pstmt_select.setString(13,home_leave_yn_val);//added home_leave_yn_val for Bru-HIMS-CRF-093[29960]
			pstmt_select.setString(14,patient_id);
			pstmt_select.setString(15,encounter_id);
			if(site_verbal_order){
				pstmt_select.setString(16,called_from_verbal_order);	
			}
			else
			{
				pstmt_select.setString(16,"Y");//added for GHL-CRF-0509
			}
			pstmt_select.setString(17,getOpDischMedInd());//added for NMC-JD-CRF-0063
			resultSet = pstmt_select.executeQuery() ;
						
			if(resultSet!=null && resultSet.next()){
				perf_deptloc_code =resultSet.getString("DISP_LOCN");
			}
//System.err.println("=perf_deptloc_code============>"+perf_deptloc_code);
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
	
	public String getFreqNature(String freq_code){
		Connection connection         = null ;
        PreparedStatement pstmt       = null ;
        ResultSet resultSet           = null ;
		String freq_nature			 = "";
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT88")) ;
			pstmt.setString(1,freq_code);				
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				freq_nature	=	resultSet.getString("FREQ_NATURE");
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
		return freq_nature;
	}

	public int loadallergydetail(String patient_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		int num    =0;
		try{
			connection		= getConnection() ;
			sql_query		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT89");
			pstmt			= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,patient_id);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				num = resultSet.getInt(1);
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
		return num;
	}

	public String comp_date_time(String end_date,String order_id,String order_line_num){
		String start_date="";
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sys_date1="";
		int count=0;
		try{
			connection				= getConnection() ;
			String str_qry	= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT25");
			String str_qry1	= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT26");
			pstmt					= connection.prepareStatement(str_qry) ;
			pstmt.setString(1,end_date.trim());
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				count=resultSet.getInt(1);
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			pstmt					= connection.prepareStatement(str_qry1) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				end_date	=	resultSet.getString("end_date");
				sys_date1=	resultSet.getString("curr_date");	
			}
		
			if(count >=1){ //System date greater than end_date of selected medication
				start_date = sys_date1;
			}
			else{
				if(getCurrMednDrugs()!=null && getCurrMednDrugs().size()>0){ //if condition added for ICN 30815
					Iterator iter = getCurrMednDrugs().iterator();
					String next_elt ="";
					while(iter.hasNext()){
						next_elt = (String) iter.next();
						if(next_elt.equals(order_id+"$"+order_line_num)){
							start_date = sys_date1;
							break;
						 }
					 }
				}
				if(!(start_date.equals(sys_date1)))
					 start_date = end_date;
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
		return start_date;
	}

	public String getAlternateDispLocn(String disp_locn){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			=	"";
		String disp_locn_code		=	"";
		int count					= 0;
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection		= getConnection() ;
			sql_query		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT93");// to check the current dispense location working hours matches sysdate
			pstmt			= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,disp_locn);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
					count	= resultSet.getInt(1);
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			// to get the alternate dispense location code 
			if(count==0) {
				sql_query		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT94");			
				pstmt			= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,disp_locn);
				pstmt.setString(2,login_facility_id);
				pstmt.setString(3,locale);
				resultSet		= pstmt.executeQuery();				

				if(resultSet!=null && resultSet.next()){
					disp_locn_code	=	resultSet.getString("ALT_DISP_LOCN_CODE");
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
		return disp_locn_code;
	}
	
	public void addPRNRemarks(String drug_code,HashMap remarks){//code added for PRN Remarks
		if(prn_remarks==null)
			prn_remarks = new HashMap();
		if(prn_remarks.containsKey(drug_code)){
			prn_remarks.remove(drug_code);	
		}
		prn_remarks.put(drug_code,remarks);
	}

	public HashMap getPRNRemarks(String drug_code){
		if(prn_remarks !=null){
			HashMap remarks = new HashMap();
			remarks = (HashMap)prn_remarks.get(drug_code);
			return remarks;
		}
		else 
			return null;
	}

	public void removePRNRemarks(String drug_code){	//Added  Method for SKR-SCF-0647[Inc:35263]
		if(prn_remarks!=null && prn_remarks.containsKey(drug_code))
			prn_remarks.remove(drug_code);
	}

	public void setExternalpatient_id(String external_patient_id){	//code added for external prescription
		this.external_patient_id = external_patient_id;
	}

	public String  getExternalpatient_id(){
		return external_patient_id;
	}

	public void setExternalreffacility(String external_ref_facility)	{
		this.external_ref_facility = external_ref_facility;
	}

	public String getExternalreffacility()	{
		return external_ref_facility;
	}

	public void setExternalRefpractitioner(String external_ref_practitioner){
		this.external_ref_practitioner = external_ref_practitioner;
	}

	public String getExternalRefpractitioner(){
		return external_ref_practitioner;
	}

	public void setExternalDateref(String external_date_ref){
		this.external_date_ref		= external_date_ref;
	}

	public String getExternalDateref(){
		return external_date_ref;
	}

	public void setExternalRemarks(String external_remarks){
		this.external_remarks	= external_remarks;
	}

	public String getExternalRemarks(){
		return external_remarks;
	}
	
	public ArrayList getExternalPresDispCodes(){
		return ExternalPresDispCodes;
	}

	public ArrayList getExternalPresDispDesc(){
		return ExternalPresDispDesc;
	}

	public ArrayList getPatientDtl(String patient_id) {
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		ArrayList	ptdtls	=	new ArrayList() ;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT103") ) ;
			pstmt.setString(1,patient_id);
			resultSet	= pstmt.executeQuery();
			while( resultSet != null && resultSet.next() ) {
				ptdtls.add(checkForNull(resultSet.getString("PATIENT_NAME")));
				ptdtls.add(checkForNull(resultSet.getString("AGE")));
				ptdtls.add(checkForNull(resultSet.getString("SEX")));
				ptdtls.add(checkForNull(resultSet.getString("ORD_PRACT_ID")));
				ptdtls.add(checkForNull(resultSet.getString("Source_code")));
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
				es.printStackTrace() ;
			}
		}
		return ptdtls;	
	}

	public ArrayList loadAmendDetailsForTPN(String order_id,String patient_id, String order_line_no,String called_from)     {
	   	Connection connection			 = null ;
        PreparedStatement pstmt			 = null ;
        ResultSet resultSet				 = null ;
		ResultSet resultSet1			 = null ;
		ResultSet	result				 = null ;
		CallableStatement cstmt			 = null;
		String sql_query				 = "";
		presDetails						 = new ArrayList();
		amendDetails					 = new ArrayList();
		String disp_locn_code			 = "";
		String drug_end_date			 = "";
		String patient_class			 = "";
		String strength_value			 = "";
		HashMap DrugDetails				 = new HashMap();
		HashMap presamendDetails		 = new HashMap();
		HashMap stock_dtls				 =	null;
		String calc_dflt_dosage_by_htwt	 =	"";
		String trade_code = "";
		ArrayList stock_params = null;
		HashMap pat_dtls	= null;
		String	age			= null;
		String	age_in_mints			= null;
		String sex			= null;
		String drugCode = null;

		try{
			connection  = getConnection() ;

			String licence = (String)(PhLicenceRights.getKey());
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TPN_SELECT21A");

			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,patient_id);
			//if(licence.equals("PH")){
				pstmt.setString(3,login_facility_id);
			//}
			resultSet			= pstmt.executeQuery();
			int i=1;

			while(resultSet.next())	{
				DrugDetails				= new HashMap();
				presamendDetails		= new HashMap();
				disp_locn_code			= "";
				drug_end_date			= "";

				presamendDetails.put("SRL_NO",""+i);
				DrugDetails.put("SRL_NO",""+i);
				DrugDetails.put("DRUG_CODE",(resultSet.getString("DRUGCODE")==null ? "":resultSet.getString("DRUGCODE")));
				drugCode=(String) resultSet.getString("DRUGCODE");
				if(!amendDrugCodes.contains(drugCode)){
					amendDrugCodes.add(drugCode);
					amendDrugCodes.add(i+"");
				}

				DrugDetails.put("ORDER_LINE_NUM",checkForNull(resultSet.getString("ORDER_LINE_NUM")));
				DrugDetails.put("DRUG_DESC",(resultSet.getString("SHORT_NAME")==null ? "":resultSet.getString("SHORT_NAME")) );
				DrugDetails.put("LONG_DESC",(resultSet.getString("LONG_DESC")==null ? "":resultSet.getString("LONG_DESC")) );
				DrugDetails.put("PATIENT_ID",(resultSet.getString("PATIENT_ID")==null ? "":resultSet.getString("PATIENT_ID")));
				DrugDetails.put("ENCOUNTER_ID",(resultSet.getString("ENCOUNTER_ID")==null ? "":resultSet.getString("ENCOUNTER_ID")));
				DrugDetails.put("PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")));
				patient_class	=	(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS"));
				calc_dflt_dosage_by_htwt	= "";	

				sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT14A");
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,login_facility_id);
				result			= pstmt.executeQuery();
				if(result!=null && result.next()){
					DrugDetails.put("MED_ADMIN_REQD_YN",(result.getString("MED_ADMIN_REQD_YN")==null ? "N":result.getString("MED_ADMIN_REQD_YN")) );
					prn_yn =result.getString("MANDATORY_REM_ON_PRN_FREQ_YN")==null ? "N":result.getString("MANDATORY_REM_ON_PRN_FREQ_YN");
					setchkforPRN(prn_yn);
				}
				try{
					closeResultSet( result ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				pat_dtls	=	getPatientDetails(patient_id,drugCode);
				age			=	(String)pat_dtls.get("age");
				sex			=	((String)pat_dtls.get("sex"));
				age_in_mints			=	((String)pat_dtls.get("age_in_mints"));

				age_in_mints	=	age_in_mints.trim();
				age	=	age.trim();
				sex	=	sex.substring(0,1);

				pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80A") ) ;
				pstmt.setString(1,sex);
				pstmt.setString(2,age_in_mints);
				pstmt.setString(3,drugCode);
				resultSet1		= pstmt.executeQuery();
				
				while(resultSet1!=null && resultSet1.next() ) {
					age_group	=	resultSet1.getString("AGE_GROUP_CODE");
				}
				try{
					closeResultSet( resultSet1 ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				DrugDetails.put("RECOMM_YN","N");
				DrugDetails.put("LIMIT_IND","");
				DrugDetails.put("DOSAGE_STD","");
				DrugDetails.put("DOSAGE_UNIT","");
				DrugDetails.put("RECOMM_DOSAGE_BY","");
				if(calc_dflt_dosage_by_htwt!=null && calc_dflt_dosage_by_htwt.trim().equals("Y") && age_group!=null && !age_group.equals("")) {
					sql_query		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT81");
					pstmt			= connection.prepareStatement(sql_query) ;
					pstmt.setString(1,drugCode);
					pstmt.setString(2,age_group);
					result			= pstmt.executeQuery();
					if(result!=null && result.next()) {
						DrugDetails.put("RECOMM_YN","Y");
						DrugDetails.put("CALC_BY_IND",(result.getString("CALC_BY_IND")));
						DrugDetails.put("DOSAGE_STD",(result.getString("DOSAGE_STD")));
						DrugDetails.put("DOSAGE_UNIT",(result.getString("DOSAGE_UNIT")));
						DrugDetails.put("RECOMM_DOSAGE_BY",(result.getString("LIMIT_IND")));
					} 
					try{
						closeResultSet( result ) ;
						closeStatement( pstmt ) ;
					}catch(Exception es){
						es.printStackTrace() ;
					}
				} 

				DrugDetails.put("ORD_DATE_TIME",(resultSet.getString("ORD_DATE_TIME")==null ? "":resultSet.getString("ORD_DATE_TIME")));
				DrugDetails.put("PRACTITIONER_NAME",(resultSet.getString("PRACTITIONER_NAME")==null ? "":resultSet.getString("PRACTITIONER_NAME")));
				DrugDetails.put("ORD_PRACT_ID",(resultSet.getString("ORD_PRACT_ID")==null ? "":resultSet.getString("ORD_PRACT_ID")));
				DrugDetails.put("PRIORITY",(resultSet.getString("PRIORITY")==null ? "":resultSet.getString("PRIORITY")));
				DrugDetails.put("CHILD_ORDER_YN",(resultSet.getString("CHILD_ORDER_YN")==null ? "":resultSet.getString("CHILD_ORDER_YN")));
				DrugDetails.put("GENERIC_ID","");
				DrugDetails.put("FREQ_CODE","");
				DrugDetails.put("PRN_DOSES_PRES_PRD_FILL","");			
				DrugDetails.put("QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")));
				DrugDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")) );
				DrugDetails.put("REPEAT_DURN_TYPE","");

				presamendDetails.put("DRUG_CODE",(resultSet.getString("DRUGCODE")==null ? "":resultSet.getString("DRUGCODE")));
				presamendDetails.put("QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")));
				presamendDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "1":resultSet.getString("DURN_VALUE")));


				DrugDetails.put("QTY_UNIT",(resultSet.getString("QTY_UNIT")==null ? "":resultSet.getString("QTY_UNIT")));
				DrugDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "1":resultSet.getString("DURN_VALUE")));

				DrugDetails.put("DURN_DESC","");
				DrugDetails.put("CATALOG_DESC",(resultSet.getString("CATALOG_DESC")==null ? "":resultSet.getString("CATALOG_DESC")));
				DrugDetails.put("START_DATE_TIME",(resultSet.getString("START_DATE_TIME")==null ? "":resultSet.getString("START_DATE_TIME")));
				DrugDetails.put("FORM_DESC","");
				DrugDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")));
				DrugDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")));
				DrugDetails.put("FORM_CODE","");
				DrugDetails.put("FREQ_DESC","");
				DrugDetails.put("FREQ_NATURE","");			
				DrugDetails.put("LINE_FIELDS_DISPLAY_TEXT",(resultSet.getString("LINE_FIELDS_DISPLAY_TEXT")==null ? "":resultSet.getString("LINE_FIELDS_DISPLAY_TEXT")));
				DrugDetails.put("END_DATE_TIME",(resultSet.getString("END_DATE_TIME")==null ? "":resultSet.getString("END_DATE_TIME")));
				DrugDetails.put("ORDER_QTY",(resultSet.getString("ORDER_QTY")==null ? "":resultSet.getString("ORDER_QTY")));
				DrugDetails.put("ORDER_UOM",(resultSet.getString("ORDER_UOM")==null ? "":resultSet.getString("ORDER_UOM")));
				DrugDetails.put("SHORT_DESC",(resultSet.getString("CATALOG_DESC")==null ? "":resultSet.getString("CATALOG_DESC")));
				DrugDetails.put("QTY_DESC",(resultSet.getString("SHORT_DESC")==null ? "":resultSet.getString("SHORT_DESC")));
				DrugDetails.put("CONT_ORDER_IND",(resultSet.getString("CONT_ORDER_IND")==null ? "":resultSet.getString("CONT_ORDER_IND")));
				DrugDetails.put("REFILL_SINGLE_CONT_ORDER_YN",(resultSet.getString("REFILL_SINGLE_CONT_ORDER_YN")==null ? "":resultSet.getString("REFILL_SINGLE_CONT_ORDER_YN")));
				DrugDetails.put("NUM_OF_REFILLS",(resultSet.getString("NUM_OF_REFILLS")==null ? "":resultSet.getString("NUM_OF_REFILLS")));
				DrugDetails.put("PARENT_ORDER_LINE_NUM",(resultSet.getString("PARENT_ORDER_LINE_NUM")==null ? "":resultSet.getString("PARENT_ORDER_LINE_NUM")));
				DrugDetails.put("STRENGTH",(resultSet.getString("STRENGTH")==null ? "":resultSet.getString("STRENGTH")));

				strength_value	=	"";
				DrugDetails.put("STRENGTH_VALUE","");
				DrugDetails.put("STRENGTH_UOM","");
				DrugDetails.put("STRENGTH_DESC","");
				DrugDetails.put("STRENGTHUOM",(resultSet.getString("STRENGTHUOM")==null ? "":resultSet.getString("STRENGTHUOM")));
				DrugDetails.put("DIAG_TEXT",(resultSet.getString("DIAG_TEXT")==null ? "":resultSet.getString("DIAG_TEXT")));
				DrugDetails.put("ACT_STRENGTH_VALUE",(resultSet.getString("STRENGTH")==null ? "":resultSet.getString("STRENGTH")));
				DrugDetails.put("QTY_DESC_CODE",(resultSet.getString("QTY_UNIT")==null ? "":resultSet.getString("QTY_UNIT")));
				DrugDetails.put("STOCK_UOM","" );
				DrugDetails.put("STOCK_UOM_DESC","" );
				
				presamendDetails.put("DIAG_TEXT",(resultSet.getString("DIAG_TEXT")==null ? "":resultSet.getString("DIAG_TEXT")));

				DrugDetails.put("ALLERGY_REMARKS",(resultSet.getString("ALLERGY_OVERRIDE_REASON")==null ? "":resultSet.getString("ALLERGY_OVERRIDE_REASON")));
				DrugDetails.put("DOSE_REMARKS",(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")==null ? "":resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")));
				DrugDetails.put("CURRENTRX_REMARKS",(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")==null ? "":resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")));
				DrugDetails.put("GENERIC_NAME","");			
				DrugDetails.put("TAPERED_YN",(resultSet.getString("TAPERED_YN")==null ? "":resultSet.getString("TAPERED_YN")));
				DrugDetails.put("ORDER_TYPE_CODE",(resultSet.getString("ORDER_TYPE_CODE")==null ? "":resultSet.getString("ORDER_TYPE_CODE")));
				DrugDetails.put("ORDER_TYPE_DESC",(resultSet.getString("ORDERTYPEDESC")==null ? "":resultSet.getString("ORDERTYPEDESC")));
				DrugDetails.put("SPLIT_DOSE_PREVIEW",(resultSet.getString("SPLIT_DOSE_PREVIEW")==null ? "":resultSet.getString("SPLIT_DOSE_PREVIEW")));
				DrugDetails.put("HEIGHT",(resultSet.getString("HEIGHT")==null ? "":resultSet.getString("HEIGHT")));
				DrugDetails.put("HEIGHT_UOM",(resultSet.getString("HEIGHT_UOM")==null ? "":resultSet.getString("HEIGHT_UOM")));
				DrugDetails.put("WEIGHT",(resultSet.getString("WEIGHT")==null ? "":resultSet.getString("WEIGHT")));
				DrugDetails.put("WEIGHT_UOM",(resultSet.getString("WEIGHT_UOM")==null ? "":resultSet.getString("WEIGHT_UOM")));
				DrugDetails.put("BSA",(resultSet.getString("BSA")==null ? "":resultSet.getString("BSA")));
				DrugDetails.put("TAKE_HOME",(resultSet.getString("TAKEHOME")==null ? "N":resultSet.getString("TAKEHOME")));
				DrugDetails.put("PRESCRIBED_MODE",(resultSet.getString("PRESCRIBED_MODE")==null ? "Q":resultSet.getString("PRESCRIBED_MODE")));
				DrugDetails.put("REFILL_START_DATE_TIME",(resultSet.getString("REFILL_START_DATE_TIME")==null ? "":resultSet.getString("REFILL_START_DATE_TIME")));
				DrugDetails.put("REFILL_END_DATE_TIME",(resultSet.getString("REFILL_END_DATE_TIME")==null ? "":resultSet.getString("REFILL_END_DATE_TIME")));	
				DrugDetails.put("NUM_OF_REFILLS",(resultSet.getString("NUM_OF_REFILLS")==null ? "":resultSet.getString("NUM_OF_REFILLS")));
				DrugDetails.put("SCHEDULED_YN","");
				DrugDetails.put("DURN_TYPE","");
				DrugDetails.put("REPEAT_VALUE","");
				DrugDetails.put("INTERVAL_VALUE","");
				DrugDetails.put("PRES_BASE_UOM",(resultSet.getString("PRES_BASE_UNIT")==null ? "":resultSet.getString("PRES_BASE_UNIT")));
				DrugDetails.put("FRACT_DOSE_ROUND_UP_YN","");
				DrugDetails.put("CONTENT_IN_PRES_BASE_UOM",(resultSet.getString("CONTENT_IN_BASE_UNIT")==null ? "":resultSet.getString("CONTENT_IN_BASE_UNIT")));
				DrugDetails.put("STRENGTH_PER_PRES_UOM","");
				DrugDetails.put("STRENGTH_PER_VALUE_PRES_UOM","");
				DrugDetails.put("DOSAGE_TYPE",(resultSet.getString("DOSAGE_TYPE")==null ? "1":resultSet.getString("DOSAGE_TYPE")));
				DrugDetails.put("ORI_DOSAGE_TYPE",(resultSet.getString("DOSAGE_TYPE")==null ? "1":resultSet.getString("DOSAGE_TYPE")));

				if(strength_value==null || strength_value.equals("") || strength_value.equals("0")){
					DrugDetails.put("ORI_DOSAGE_TYPE","Q");
				}
				else{
					DrugDetails.put("ORI_DOSAGE_TYPE","S");
				}

				DrugDetails.put("LICENCE",licence);
			
				//if(licence.equals("PH")){
					DrugDetails.put("DISP_LOCN_CODE",(resultSet.getString("DISP_LOCN_CODE")==null ? "":resultSet.getString("DISP_LOCN_CODE")));
					DrugDetails.put("DISP_LOCN_DESC",(resultSet.getString("DISP_LOCN_DESC")==null ? "":resultSet.getString("DISP_LOCN_DESC")));

					disp_locn_code	=	(resultSet.getString("DISP_LOCN_CODE")==null ? "":resultSet.getString("DISP_LOCN_CODE"));
				/*}
				else{
					DrugDetails.put("DISP_LOCN_CODE","");
					DrugDetails.put("DISP_LOCN_DESC","");
				}*/

				ArrayList renew_dates	=	(getRenewDates((resultSet.getString("DURN_VALUE")),order_id,(String)resultSet.getString("DRUGCODE")));
				if(renew_dates.size()==2) {
					drug_end_date	=	(String)renew_dates.get(1);
				}
		
			//	if(nationalityCheck(patient_id)) {
					stock_params	=	validateForStock(patient_class);
					if(stock_params.size()!=0 && ((String)stock_params.get(0)).equals("Y") && ((String)stock_params.get(1)).equals("N")){
						stock_dtls	=	chkStockAvail((String)resultSet.getString("DRUGCODE"),disp_locn_code,(resultSet.getString("ORDER_QTY")==null ? "":resultSet.getString("ORDER_QTY")),drug_end_date, trade_code);
		
						if(stock_dtls.size()!=0) {
							DrugDetails.put("STOCK_AVAILABLE_YN",(String)stock_dtls.get("STOCK_AVAILABLE_YN"));
							DrugDetails.put("AVAILABLE_STOCK",(String)stock_dtls.get("AVAILABLE_STOCK"));					
						} else {
							DrugDetails.put("STOCK_AVAILABLE_YN","N");
							DrugDetails.put("AVAILABLE_STOCK","0");
						}
					}
			/*	} 
				else {
					DrugDetails.put("STOCK_AVAILABLE_YN","Y");
					DrugDetails.put("AVAILABLE_STOCK","0");
				}*/
				presDetails.add(DrugDetails);
				amendDetails.add(presamendDetails);

				i++;
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}catch(Exception es){
				es.printStackTrace() ;
			}

			ArrayList unique_drugs	=	new ArrayList();
			HashMap position_ptr	=	new HashMap();
			String drug_code		=	"";
			String pos				=	"";

			for(int j=0; j<presDetails.size(); j++) {
				drug_code	=	(String)((HashMap)presDetails.get(j)).get("DRUG_CODE");

				if(!unique_drugs.contains(drug_code)) {
					unique_drugs.add(drug_code);
					((HashMap)presDetails.get(j)).put("FLAG","Y");
					position_ptr.put(drug_code,j+"");
					
				} 
				else {
					pos	=	(String)position_ptr.get(drug_code);
					position_ptr.put(drug_code,j+"");
					((HashMap)presDetails.get(j)).put("FLAG","Y");
					((HashMap)presDetails.get(Integer.parseInt(pos))).put("FLAG","N");
				}
			}
		} 
		catch ( Exception e ) {
			DrugDetails.put("STOCK_AVAILABLE_YN","Y");
			DrugDetails.put("AVAILABLE_STOCK","1000");
			presDetails.add(DrugDetails);
			amendDetails.add(presamendDetails);
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( result );
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return presDetails;
	}

	public ArrayList getPatientDetailsTre(String patient_id)	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		HashMap	 pat_details	=	new HashMap();
		ArrayList pat_detail = new ArrayList();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT43") ) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patient_id);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				pat_details.put("patient_name",resultSet.getString("PATIENT_NAME"));
				pat_details.put("sex",resultSet.getString("SEX"));
				pat_details.put("age",resultSet.getString("AGE"));
				//pat_details.put("age_in_mints",resultSet.getString("AGE_IN_MINTS"));
				pat_detail.add(pat_details);
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
				es.printStackTrace() ;
			}
		}
		return pat_detail;
	}

	public String getOorderIdForTDMDtls(String patient_id,String drug_code)	{
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
		}
		catch(Exception e){
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
		return order_id;
	}

	public HashMap getApplicableOrders(String facility_id){// orders applicability from ph parameter facility... 
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		HashMap appl_orders			= new HashMap();
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT3")) ;
			pstmt.setString(1,facility_id);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				appl_orders.put("COMP_RX_APPL_YN",resultSet.getString("COMP_RX_APPL_YN"));				
				appl_orders.put("IV_RX_APPL_YN",resultSet.getString("IV_RX_APPL_YN"));				
				appl_orders.put("ONCOLOGY_RX_APPL_YN",resultSet.getString("ONCOLOGY_RX_APPL_YN"));				
				appl_orders.put("TPN_RX_APPL_YN",resultSet.getString("TPN_RX_APPL_YN"));				
				appl_orders.put("TDM_APPL_YN",resultSet.getString("TDM_APPL_YN"));	
				appl_orders.put("MANDATORY_REM_ON_PRN_FREQ_YN",resultSet.getString("MANDATORY_REM_ON_PRN_FREQ_YN"));	
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
		return appl_orders;
	}

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
		return count;
	}

	public ArrayList getSlidingScaleTmpl(String drugCode){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList SlidingScaleTmpl			= new ArrayList();
		HashMap result			= new HashMap();
		locale= getLanguageId()==null?"en":getLanguageId();

		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_TEMPLATE_ID")) ;
			pstmt.setString(1, drugCode);
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result = new HashMap();
				result.put("TEMPLATE_ID",resultSet.getString("TEMPLATE_ID"));
				result.put("TEMPLATE_DESC",resultSet.getString("TEMPLATE_DESC"));	
				result.put("RANGE_UOM_CODE",resultSet.getString("RANGE_UOM_CODE"));						
				result.put("ADMIN_UNITS_UOM_CODE",resultSet.getString("ADMIN_UNITS_UOM_CODE"));
				SlidingScaleTmpl.add(result);
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
		return SlidingScaleTmpl;

	}

	public ArrayList getSlidingScaleTmplDtl(String templateId){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList SlidingScaleTmplDtl			= new ArrayList();
		HashMap result			= new HashMap();
		locale= getLanguageId()==null?"en":getLanguageId();

		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_TEMPLATE_DETAILS")) ;
			pstmt.setString(1,templateId);
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result = new HashMap();
				result.put("SRL_NO",resultSet.getFloat("SRL_NO")+"");
				result.put("RANGE_FROM",resultSet.getFloat("RANGE_FROM")+"");
				result.put("RANGE_TO",resultSet.getFloat("RANGE_TO")+"");	
				result.put("ADMIN_UNITS",resultSet.getFloat("ADMIN_UNITS")+"");	
				result.put("REMARKS",resultSet.getString("REMARKS"));
				SlidingScaleTmplDtl.add(result);
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
		return SlidingScaleTmplDtl;
	}

	public String getNextSchDateTime(Connection connection , String sch_date_time,String SQL_PH_SLIDING_SCALE_SELECT5){
		PreparedStatement pstmt  = null ;
        ResultSet resultSet      = null ;
		String result	 = "" ;
		try{
			pstmt					= connection.prepareStatement(SQL_PH_SLIDING_SCALE_SELECT5) ;
			pstmt.setString(1,sch_date_time);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				result = resultSet.getString("SCH_DATE_TIME");
			}
		}
		catch ( Exception e ) {
            e.printStackTrace() ;
		}
		finally {
            try{
                 closeResultSet( resultSet ) ;
                 closeStatement( pstmt ) ;                 
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }
		return result;
	}

	public HashMap getSchdDatesFrWeekHr(HashMap scheduleFrequency,ArrayList orderDetails,String mode){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList headerList		= null;
		ArrayList schdDateTime		= null;
		HashMap	  schdData			= null;
		HashMap   drugDetails		= null;
		HashMap   schDateTimeWkHr	= new HashMap();
		String    duration_type		= null;
		String	  start_date_time	= null;
		String	  start_date		= null;
		String	  start_time		= null;
		String    drgCode			= null;
		String    tmp_drug_code		= null;
		String    schd_date_time	= null;
		String    durn_type			= "D";
		String	  interval_value	= "1";		
		String	  frequency_nature	= "F";
		int	      durn_value		= 1;
		ArrayList day_list			= null;
		ArrayList day_names			= null;
		ArrayList time_list			= null;
		String srl_no = "", strDurnValue=""; //added for IN24521 --18/10/2010-- priya
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT103")) ;
			if(scheduleFrequency != null && scheduleFrequency.size()>0){
				Set DrugCodesSet		= scheduleFrequency.keySet();
				Iterator   drgCdeItr	= DrugCodesSet.iterator();
				ArrayList schdDetails = null;
				while(drgCdeItr.hasNext()){
					schdDateTime		= new ArrayList(); // Initialized for IN22656 --14/07/2010-- priya 
					drgCode = (String)drgCdeItr.next();
					tmp_drug_code = drgCode.substring(0,drgCode.length()-1);
					if(scheduleFrequency.containsKey(drgCode)){
						try{
							for(int ordDtls = 0;ordDtls<orderDetails.size();ordDtls++){
								if(mode.equals("CREATE")){
									headerList		= (ArrayList) orderDetails.get(ordDtls);
								}
								else if(mode.equals("UPDATE")){
									headerList		= 	orderDetails;
								}

								for(int hl=0;hl<headerList.size();hl++){
									drugDetails	=(HashMap)headerList.get(hl);
									srl_no = (String)drugDetails.get("SRL_NO"); //added for IN24521 --18/10/2010-- priya
									if(drgCode.equals((String)drugDetails.get("DRUG_CODE")+srl_no)) { //added for IN23963 --28/10/2010-- priya
										if(mode.equals("CREATE")){
											start_date_time = (String)drugDetails.get("START_DATE");
											strDurnValue = (String)drugDetails.get("freq_chng_durn_value");
											if(strDurnValue==null || strDurnValue.equals(""))
												strDurnValue = (String)drugDetails.get("FREQ_DURN_VALUE");
											durn_value		=  Integer.parseInt(strDurnValue);
										}
										else if(mode.equals("UPDATE")){
											start_date_time = (String)drugDetails.get("START_DATE_TIME");
											durn_value		=  Integer.parseInt((String)drugDetails.get("FREQ_DURN_VALUE"));
										}
										start_date      = start_date_time.substring(0,10);
										start_time      = start_date_time.substring(11,start_date_time.length());
										interval_value	= (String)drugDetails.get("INTERVAL_VALUE");
										break; 
									}
								}
							}
						}
						catch(Exception chkE){
							chkE.printStackTrace() ;
						}

						schdDetails = (ArrayList)scheduleFrequency.get(drgCode);
						if(schdDetails!=null && schdDetails.size()>0){
							schdData=(HashMap)schdDetails.get(0);

							duration_type	= (String)schdData.get("durationType");
							day_list	=	(ArrayList)schdDetails.get(1);
							day_names	=	(ArrayList)schdDetails.get(2);
							time_list	=	(ArrayList)schdDetails.get(3);										
							if(duration_type.equals("W")){
								for(int dv=0;dv<durn_value;dv++){
									if((dv != 0) && (Integer.parseInt(interval_value) > 1)){
										dv = dv+(Integer.parseInt(interval_value) -1);
									}

									for(int dl=0;dl<day_names.size();dl++){
										pstmt.setString(1,start_date);
										pstmt.setString(2,(dv*7)+"");
										pstmt.setString(3,(String)day_names.get(dl));
										pstmt.setString(4,start_date);
										pstmt.setString(5,(String)time_list.get(dl));
										pstmt.setString(6,start_time);
										pstmt.setString(7,(start_date+" "+(String)time_list.get(dl)));
										pstmt.setString(8,(dv*7)+"");
										pstmt.setString(9,(start_date+" "+(String)time_list.get(dl)));
										pstmt.setString(10,(dv*7)+"");
										pstmt.setString(11,(String)day_names.get(dl));
										pstmt.setString(12,(start_date+" "+(String)time_list.get(dl)));
										pstmt.setString(13,(dv*7)+"");
										pstmt.setString(14,(String)day_names.get(dl));
										resultSet	= pstmt.executeQuery();
										if(resultSet!=null && resultSet.next()){
											schd_date_time = resultSet.getString("NextDay");
											schdDateTime.add(schd_date_time);
										}
										closeResultSet( resultSet ) ;
									}
								}
							}
							else if(duration_type.equals("L")){
								for(int dv=0;dv<durn_value;dv++){
									for(int dl=0;dl<day_list.size();dl++){
										schd_date_time = populateEndDate(frequency_nature,start_date_time,(Integer.parseInt(day_list.get(dl)+"")+(dv*30)+""),"D");
										schd_date_time = schd_date_time.substring(0,10)+" "+(String)time_list.get(dl);
										schdDateTime.add(schd_date_time);
									}
								}
							}
					   }
					}
					schDateTimeWkHr.put(drgCode,schdDateTime);  //added  +srl_no for IN23963 --28/10/2010-- priya 
				}
			}
			//else{
				String tmp_durn_value      = "1";
				String freq_code		   = "";
				String interval_durn_type  = "";
				String freq_chng_durn_desc = "";
				pstmt					= connection.prepareStatement("select  INTERVAL_DURN_TYPE from am_frequency  where freq_code =?");
				for(int ordDtls = 0;ordDtls<orderDetails.size();ordDtls++){
					//schdDateTime		= new ArrayList(); // Initialized for IN22656 --14/07/2010-- priya // commented for AAKH-SCF-0271 [IN:059863]
					interval_durn_type  = "";
					if(mode.equals("CREATE")){
						headerList		= (ArrayList) orderDetails.get(ordDtls);
					}
					else if(mode.equals("UPDATE")){
						headerList		= 	orderDetails;
					}

					for(int hl=0;hl<headerList.size();hl++){
						schdDateTime		= new ArrayList(); // Initialized for IN22656 --14/07/2010-- priya // added here for AAKH-SCF-0271 [IN:059863] (for op order id only single order only will create so OP it will not initailize above)
						drugDetails	=(HashMap)headerList.get(hl);

						if(mode.equals("CREATE")){
							start_date_time = (String)drugDetails.get("START_DATE");
							durn_type		= (String)drugDetails.get("DURN_TYPE");
							freq_chng_durn_desc =  (String)drugDetails.get("freq_chng_durn_desc");
						}
						else if(mode.equals("UPDATE")){
							start_date_time = (String)drugDetails.get("START_DATE_TIME");
							durn_type   	= (String)drugDetails.get("FREQ_DURN_TYPE");
							freq_chng_durn_desc = (String)drugDetails.get("DURN_TYPE");
						}

						start_date      = start_date_time.substring(0,10);
						start_time      = start_date_time.substring(11,start_date_time.length());
						durn_value		= Integer.parseInt((String)drugDetails.get("DURN_VALUE"));
						interval_value	= (String)drugDetails.get("INTERVAL_VALUE");
						frequency_nature= (String)drugDetails.get("FREQ_NATURE");
						drgCode			= (String)drugDetails.get("DRUG_CODE");
						freq_code		= (String)drugDetails.get("FREQ_CODE");
						srl_no = (String)drugDetails.get("SRL_NO"); //added for IN24521 --18/10/2010-- priya
					//} // Commented for  SKR-SCF-0225	29331
                    if(frequency_nature.equals("I")) {
						pstmt.setString(1,freq_code);
							resultSet	= pstmt.executeQuery();
						if(resultSet!=null && resultSet.next()){
							interval_durn_type = resultSet.getString("INTERVAL_DURN_TYPE");
						}
				  
						if(!interval_durn_type.equals(freq_chng_durn_desc)){
							if(interval_durn_type.equals("H")&& freq_chng_durn_desc.equals("D"))
								durn_value =durn_value*24;
							else if(interval_durn_type.equals("H")&& freq_chng_durn_desc.equals("W"))
								durn_value =durn_value*24*7;
							else if(interval_durn_type.equals("H")&& freq_chng_durn_desc.equals("L")) //added for ML-MMOH-CRF-1531 -start
								durn_value =durn_value*24*30;
							else if(interval_durn_type.equals("H")&& freq_chng_durn_desc.equals("Y"))
								durn_value =durn_value*24*365;   //added for ML-MMOH-CRF-1531 -end
							else if(interval_durn_type.equals("M")&& freq_chng_durn_desc.equals("H"))
								durn_value =durn_value*60;
							else if(interval_durn_type.equals("M")&& freq_chng_durn_desc.equals("D"))
								durn_value =durn_value*60*24;
							else if(interval_durn_type.equals("M")&& freq_chng_durn_desc.equals("W"))
								durn_value =durn_value*60*24*7;
							else if(interval_durn_type.equals("M")&& freq_chng_durn_desc.equals("L")) //added for ML-MMOH-CRF-1531 -start
								durn_value =durn_value*60*24*30;
							else if(interval_durn_type.equals("M")&& freq_chng_durn_desc.equals("Y"))
								durn_value =durn_value*60*24*365; //added for ML-MMOH-CRF-1531 -end
						}
						for(int i=0;i< (int) Math.ceil((durn_value/Float.parseFloat(interval_value)));i++){ //replaced Integer.parseInt with Float.parseFloat and ceiled the value for IN23945  --24/09/2010-- priya
							tmp_durn_value = (i*Integer.parseInt(interval_value))+"";
							schd_date_time = populateEndDate(frequency_nature,start_date_time,tmp_durn_value,durn_type);
							schdDateTime.add(schd_date_time);
						}
						schDateTimeWkHr.put(drgCode+srl_no,schdDateTime); //added +srl_no for IN24521 --18/10/2010-- priya
					}
				} // added for  SKR-SCF-0225	29331
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
		return schDateTimeWkHr;
	}

	public String getFreqDurnConvValue(String repeat_durn_type, String durn_value, String freq_change_durn_type){
		float drn_val_rept_drn_type = Float.parseFloat(durn_value);
		int tmp_drn_val_rept_drn_type	= 0;
		if(repeat_durn_type != freq_change_durn_type){
			if(repeat_durn_type.equals("M")){
				if(freq_change_durn_type.equals("H"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * 60;	
				else if(freq_change_durn_type.equals("D"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * (24 * 60);	
				else if(freq_change_durn_type.equals("W"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * (7 * 24 * 60);	
				else if(freq_change_durn_type.equals("L"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * (30 * 24 * 60);	
				else if(freq_change_durn_type.equals("Y"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * (365 * 24 * 60);	
		   } 
		   else if(repeat_durn_type.equals("H")){
				if(freq_change_durn_type.equals("M"))
					drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(60+"")));
				else if(freq_change_durn_type.equals("D"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * 24;	
				else if(freq_change_durn_type.equals("W"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * 7 * 24;	
				else if(freq_change_durn_type.equals("L"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * 30 * 24;	
				else if(freq_change_durn_type.equals("Y"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * 365 * 24;	
		   }
		   else if(repeat_durn_type.equals("D")){
				if(freq_change_durn_type.equals("M"))
					drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat((24*60)+"")));
				else if(freq_change_durn_type.equals("H"))
					drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(24+"")));
				else if(freq_change_durn_type.equals("W"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * 7 ;	
				else if(freq_change_durn_type.equals("L"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * 30 ;	
				else if(freq_change_durn_type.equals("Y"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * 365 ;	
		   }
		   else if(repeat_durn_type.equals("W")){
				if(freq_change_durn_type.equals("M"))
					drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat((7*24*60)+"")));
				else if(freq_change_durn_type.equals("H"))
					drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat((7*24)+"")));
				else if(freq_change_durn_type.equals("D"))
					drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(7+"")));
				else if(freq_change_durn_type.equals("L"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * 4;	
				else if(freq_change_durn_type.equals("Y"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * 52;	
		   }
		   else if(repeat_durn_type.equals("L")){
				if(freq_change_durn_type.equals("M"))
					drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat((30*24*60)+"")));
				else if(freq_change_durn_type.equals("H"))
					drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat((30*24)+"")));
				else if(freq_change_durn_type.equals("D"))
					drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(30+"")));
				else if(freq_change_durn_type.equals("W"))
					drn_val_rept_drn_type = new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(4+"")));
				else if(freq_change_durn_type.equals("Y"))
					drn_val_rept_drn_type = Integer.parseInt(durn_value) * 12;	
			}	
		}
		tmp_drn_val_rept_drn_type = new Float(drn_val_rept_drn_type).intValue();
		return tmp_drn_val_rept_drn_type+"";
	}

   public void getPat_specialty_code(String Ord_facility_id,String encounter_id ) throws Exception{	
        Connection connection			= null ;
        PreparedStatement pstmt			= null ;
        ResultSet resultSet				= null;
		 pat_specialty_code             = "";

		try{
			connection = getConnection() ; 
			pstmt			= connection.prepareStatement("select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?") ;
			pstmt.setString(1,Ord_facility_id);
			pstmt.setString(2,encounter_id);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				pat_specialty_code = resultSet.getString("SPECIALTY_CODE")==null ?"":resultSet.getString("SPECIALTY_CODE");
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
	
	public ArrayList getDrugInteractionDtls(String drug_code, String form_code, String generic_id, String start_date, String end_date, String patient_id ){//getDrugInteractionDtls Added for	RUT-CRF-0066 IN[029604] - start
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
		PreparedStatement pstmt1     = null ; //MMS-KH-CRF-0029[IN070606]
		PreparedStatement pstmt2     = null ; //MMS-KH-CRF-0029[IN070606]
		PreparedStatement pstmt3     = null ; //MMS-KH-CRF-0029[IN070606]
		PreparedStatement pstmt4	 = null;  //MMS-KH-CRF-0034
        String sql_query="";//, MARDefaulting ="";  Removed for IN063877
		ResultSet resultSet = null;
		ResultSet resultSet1 = null; //MMS-KH-CRF-0029[IN070606]
		ResultSet resultSet2 = null; //MMS-KH-CRF-0029[IN070606]
		ResultSet resultSet3 = null; //MMS-KH-CRF-0029[IN070606]
		ResultSet resultSet4 = null; //MMS-KH-CRF-0034
		HashMap  hmDrugIntrDtl = null;
		ArrayList  hmDrugIntrDtllst = new ArrayList();
		StringBuffer drugCodelist = new StringBuffer();
		//StringBuffer drugCodelist2 = new StringBuffer();
		StringBuffer genericIdlist = new StringBuffer();
		//StringBuffer genericIdlist2 = new StringBuffer();
		StringBuffer formCodelist = new StringBuffer();
		String restrict_transaction = "N";
		String severity_level = "";

	//	ArrayList prescriptionDetails	=	getpresDetails();  Removed for IN063877
		HashMap drugDetails = null;
		String stDrugCode, stGenericId, stStartDate, stEndDate, stFormCode="";
		String drugCode_List="", genericId_list="", formCode_list="";//drugCode_List2="", genericId_list2="", Removed for IN063877
		boolean active_drug = false;
		try{
			connection = getConnection() ;
			  boolean CDS_FOR_CONTRAST_YN =CommonBean.isSiteSpecific(connection, "PH","CDS_FOR_CONTRAST_YN");//added for MMS-KH-CRF-0020
			  //MMS-KH-CRF-0029 - start and moved from down to up
				pstmt1      = connection.prepareStatement("select ds_ingredient_chk(?,?,TO_DATE (?, 'dd/mm/yyyy hh24:mi' ),TO_DATE (?, 'dd/mm/yyyy hh24:mi' ),?,?,?) food_yn from dual") ; // 2 parameter added for MMS-KH-CRF-0029

				pstmt4      = connection.prepareStatement("select  RL_DRUG_INTR_ABN_RESULT_YN(?,?,?,?) alert_flag  from dual") ; //added for MMS-KH-CRF-0034

				pstmt2 = connection.prepareStatement("SELECT count(*) count from or_order a ,or_order_line b where a.order_id = b.order_id and a.order_category='LB' and a.patient_id=? and  a.encounter_id = ? /*AND  ( TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE_TIME AND  MODIFIED_DATE OR TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE_TIME AND  MODIFIED_DATE OR START_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/YYYY HH24:MI')  AND TO_DATE(?,'DD/MM/YYYY HH24:MI') OR MODIFIED_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY HH24:MI') AND TO_DATE(?,'DD/MM/YYYY HH24:MI')) */ and b.order_catalog_code = ? and b.order_line_status not in ('CD','CN','DC','HD')");
				pstmt3 = connection.prepareStatement("SELECT COUNT (*) cunt FROM rl_request_header a, rl_request_detail b WHERE a.specimen_no = b.specimen_no and   a.patient_id = b.patient_id AND a.operating_facility_id = b.operating_facility_id AND b.operating_facility_id = ? AND b.patient_id = ? AND a.encounter_id = ? AND nvl(b.cancelled_yn,'N') = 'N' AND b.RESULT_STATUS NOT IN('R','P') AND b.test_code = (select test_code from rl_test_code where order_catalog_code = ?) ");//added for MMS-CRF-0029
				//MMS-KH-CRF-0029 - end
				//select test_code from rl_test_code where order_catalog_code = ? added for MMS-KH-CRF-0034
				System.err.println("presDetails==10453===>" + presDetails);
				System.err.println("presDetails==10454===>" + patient_id);
			if(presDetails!=null && presDetails.size()>0){
				sql_query			= "SELECT count(*) active_drug FROM DUAL WHERE TO_DATE (?, 'dd/mm/yyyy hh24:mi') BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi' ) OR  TO_DATE (?, 'dd/mm/yyyy hh24:mi') BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi' ) OR  TO_DATE (?, 'dd/mm/yyyy hh24:mi') BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi' ) OR  TO_DATE (?, 'dd/mm/yyyy hh24:mi') BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi' )";// Changed for ML-BRU-SCF-0811 [IN:039394], //IN071728   
				pstmt		= connection.prepareStatement( sql_query ) ;
		//		//MMS-KH-CRF-0029[IN070606] - start
	//			pstmt1      = connection.prepareStatement("select ds_ingredient_chk(?,?,TO_DATE (?, 'dd/mm/yyyy hh24:mi' ),TO_DATE (?, 'dd/mm/yyyy hh24:mi' ),?) food_yn from dual") ;
	//			pstmt2 = connection.prepareStatement("SELECT count(*) count from or_order a ,or_order_line b where a.order_id = b.order_id and a.order_category='LB' and a.patient_id=? and  a.encounter_id = ? /*AND  ( TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE_TIME AND  MODIFIED_DATE OR TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE_TIME AND  MODIFIED_DATE OR START_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/YYYY HH24:MI')  AND TO_DATE(?,'DD/MM/YYYY HH24:MI') OR MODIFIED_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY HH24:MI') AND TO_DATE(?,'DD/MM/YYYY HH24:MI')) */ and b.order_catalog_code = ? and b.order_line_status not in ('CD','CN','DC','HD')");
				//MMS-KH-CRF-0029[IN070606] - end
				String durn_value=""; //MMS-KH-CRF-0029
				String durn_type = ""; //MMS-KH-CRF-0029
				String freq_nature = "";//MMS-KH-CRF-0029
				String patient_class = "";//MMS-KH-CRF-0029
				for(int i=0;i<presDetails.size();i++){
					drugDetails		= (HashMap)presDetails.get(i);
					stDrugCode		= (String)drugDetails.get("DRUG_CODE");
					stGenericId			= (String)drugDetails.get("GENERIC_ID");		
					stFormCode			= (String)drugDetails.get("FORM_CODE");		
					patient_class		= (String)drugDetails.get("PATIENT_CLASS");	 //MMS-KH-CRF-0029
					if(patient_class!=null && !patient_class.equals(""))  //MMS-KH-CRF-0029
						setPatientClass(patient_class);
					//if(!stDrugCode.equals(drug_code) ){ //commented for MMS-KH-CRF-0029
						stStartDate			= (String)drugDetails.get("START_DATE");
						stEndDate			= (String)drugDetails.get("END_DATE");
						if(end_date==null){ //MMS-KH-CRF-0029 - start
							durn_value		=	(String) drugDetails.get("DURN_VALUE");
							durn_type		=	(String) drugDetails.get("DURN_TYPE");
							freq_nature		=   (String) drugDetails.get("freq_nature");

							end_date		=	populateEndDate(freq_nature,start_date,durn_value,durn_type);
							stEndDate = end_date;
						} //MMS-KH-CRF-0029 - end
						if(!locale.equals("en")){
							stStartDate= com.ehis.util.DateUtils.convertDate(stStartDate, "DMYHM",locale,"en");
							stEndDate= com.ehis.util.DateUtils.convertDate(stEndDate, "DMYHM",locale,"en");
						}
						//added for IN071728, IN071727, IN072421
						if(!locale.equals("en")){
							start_date= com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",locale,"en");
							end_date= com.ehis.util.DateUtils.convertDate(end_date, "DMYHM",locale,"en");
						}
						System.err.println("PrescriptionBean_1.java=====start_date====>"+start_date+"==stStartDate===>"+stStartDate+"===stEndDate==>"+stEndDate+"==end_date==>"+end_date+"==patient_id==>"+patient_id+"==generic_id==>"+generic_id+"==drug_code==>"+drug_code+"==form_code==>"+form_code+"===stDrugCode===>" + stDrugCode + "====stGenericId===>" + stGenericId + "===stFormCode===>" + stFormCode);
						pstmt.setString(1,start_date);
						pstmt.setString(2,stStartDate);
						pstmt.setString(3,stEndDate);
						pstmt.setString(4,end_date);
						pstmt.setString(5,stStartDate);
						pstmt.setString(6,stEndDate);
						pstmt.setString(7,stStartDate);
						pstmt.setString(8,start_date);
						pstmt.setString(9,end_date);
						pstmt.setString(10,stEndDate);// Added for ML-BRU-SCF-0811 [IN:039394] 
						pstmt.setString(11,start_date);// Added for ML-BRU-SCF-0811 [IN:039394]
						pstmt.setString(12,end_date);// Added for ML-BRU-SCF-0811 [IN:039394]
						resultSet	= pstmt.executeQuery(); 
						if( resultSet != null && resultSet.next() ) {
							active_drug	=	((resultSet.getInt("ACTIVE_DRUG"))>0);
						}	
						if(active_drug){
							drugCodelist.append("'"+stDrugCode+"', ");
							//drugCodelist2.append(" DECODE ('"+stDrugCode+stFormCode+"', intr_code2||form_code2, intr_code2||form_code2, '"+ stDrugCode+"*A'), ");
							genericIdlist.append(" '"+stGenericId+"', ");
							//genericIdlist2.append(" DECODE ('"+stGenericId+stFormCode+"', intr_code2||form_code2, intr_code2||form_code2, '"+ stGenericId+"*A'), ");
							formCodelist.append("'"+stFormCode+"', ");
						}
						closeResultSet( resultSet ) ;//GHL-ICN-0084
					//}
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}

			sql_query			= "SELECT distinct(drug_code) drug_code, generic_id, form_code FROM PH_PATIENT_DRUG_PROFILE A WHERE  PATIENT_ID =? AND  ( TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE AND  END_DATE OR TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE AND  END_DATE OR START_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY HH24:MI')  AND TO_DATE(?,'DD/MM/YYYY HH24:MI') OR END_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY HH24:MI') AND TO_DATE(?,'DD/MM/YYYY HH24:MI')) AND DISCONT_DATE_TIME IS NULL AND ON_HOLD_DATE_TIME IS NULL AND  CANCEL_YN='N' AND   STOP_YN='N' "; // Changed for ML-BRU-SCF-0811 [IN:039394],// IN071728 
			pstmt					= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,start_date);
			pstmt.setString(3,end_date);	
			pstmt.setString(4,start_date);
			pstmt.setString(5,end_date);
			pstmt.setString(6,start_date);// Added for ML-BRU-SCF-0811 [IN:039394] 
			pstmt.setString(7,end_date);//  Added for ML-BRU-SCF-0811 [IN:039394] 

			resultSet			= pstmt.executeQuery();

			if(resultSet!= null){
				while(resultSet.next()){
					drugCodelist.append(" '"+resultSet.getString("drug_code")+ "', ");
					//drugCodelist2.append(" DECODE ('"+resultSet.getString("drug_code")+resultSet.getString("form_code")+"', intr_code2||form_code2, intr_code2||form_code2, '"+ resultSet.getString("drug_code")+"*A'), ");
					//genericIdlist1.append(" DECODE ('"+resultSet.getString("generic_id")+resultSet.getString("form_code")+"', intr_code1||form_code1, intr_code1||form_code1, '"+ resultSet.getString("drug_code")+"*A'), ");
					//genericIdlist2.append(" DECODE ('"+resultSet.getString("generic_id")+resultSet.getString("form_code")+"', intr_code2||form_code2, intr_code2||form_code2, '"+ resultSet.getString("generic_id")+"*A'), ");
					genericIdlist.append("'"+resultSet.getString("generic_id")+"', ");
					formCodelist.append("'"+resultSet.getString("form_code")+"', ");
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ; //GHL-ICN-0084
			
			
			//added for mms-kh-crf-0020 start
			if(CDS_FOR_CONTRAST_YN){
			//closeStatement( pstmt ) ;
			
			//sql_query			= "SELECT distinct d.PH_DRUG_CODE,generic_id, p.form_code from rd_items_consumed a,rd_request b,or_order c, rd_items d,ph_drug p,or_order_line h, rd_exams i where b.OPERATING_FACILITY_ID = c.PERFORMING_FACILITY_ID and b.order_id = c.order_id and a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and h.START_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI')AND TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND (   TO_DATE (?, 'DD/MM/YYYY HH24:MI') BETWEEN h.START_DATE_TIME AND h.END_DATE_TIME OR TO_DATE (?, 'DD/MM/YYYY HH24:MI') BETWEEN h.START_DATE_TIME AND h.END_DATE_TIME OR h.END_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI')AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')or h.END_DATE_TIME is null)  and a.REQUEST_NUM = b.REQUEST_NUM and a.item_code = d.item_code and a.STORE_TYPE = 'DR' AND B.PATIENT_ID=C.PATIENT_ID AND C.PATIENT_ID=? and d.PH_DRUG_CODE=p.DRUG_CODE and c.order_category='RD' and c.order_id=h.order_id and a.exam_code = i.exam_code and i.order_catalog_code = h.order_catalog_code";
			sql_query			= "SELECT distinct d.PH_DRUG_CODE,generic_id, p.form_code from rd_items_consumed a,rd_request b,or_order c, rd_items d,ph_drug p,or_order_line h, rd_exams i where b.OPERATING_FACILITY_ID = c.PERFORMING_FACILITY_ID and b.order_id = c.order_id and a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID  and a.REQUEST_NUM = b.REQUEST_NUM and a.item_code = d.item_code and a.STORE_TYPE = 'DR' AND B.PATIENT_ID=C.PATIENT_ID AND C.PATIENT_ID=? and d.PH_DRUG_CODE=p.DRUG_CODE and c.order_category='RD' and c.order_id=h.order_id and a.exam_code = i.exam_code and i.order_catalog_code = h.order_catalog_code";
			//and h.START_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI')AND TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND (   TO_DATE (?, 'DD/MM/YYYY HH24:MI') BETWEEN h.START_DATE_TIME AND h.END_DATE_TIME OR TO_DATE (?, 'DD/MM/YYYY HH24:MI') BETWEEN h.START_DATE_TIME AND h.END_DATE_TIME OR h.END_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI')AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')or h.END_DATE_TIME is null) removed for MMS-KH-SCF-0054
			pstmt					= connection.prepareStatement(sql_query) ;
			//pstmt.setString(1,start_date);//COMMENTED for MMS-KH-SCF-0054
			//pstmt.setString(2,end_date);	//COMMENTED for MMS-KH-SCF-0054
			//pstmt.setString(3,start_date);//COMMENTED for MMS-KH-SCF-0054
			//pstmt.setString(4,end_date);//COMMENTED for MMS-KH-SCF-0054
			//pstmt.setString(5,start_date);//COMMENTED for MMS-KH-SCF-0054
			//pstmt.setString(6,end_date); //COMMENTED for MMS-KH-SCF-0054
			pstmt.setString(1,patient_id);//7 changed 1 for MMS-KH-SCF-0054
			resultSet			= pstmt.executeQuery();
			if(resultSet!= null){
				while(resultSet.next()){
					drugCodelist.append(" '"+resultSet.getString("PH_DRUG_CODE")+ "', ");
					//drugCodelist2.append(" DECODE ('"+resultSet.getString("drug_code")+resultSet.getString("form_code")+"', intr_code2||form_code2, intr_code2||form_code2, '"+ resultSet.getString("drug_code")+"*A'), ");
					//genericIdlist1.append(" DECODE ('"+resultSet.getString("generic_id")+resultSet.getString("form_code")+"', intr_code1||form_code1, intr_code1||form_code1, '"+ resultSet.getString("drug_code")+"*A'), ");
					//genericIdlist2.append(" DECODE ('"+resultSet.getString("generic_id")+resultSet.getString("form_code")+"', intr_code2||form_code2, intr_code2||form_code2, '"+ resultSet.getString("generic_id")+"*A'), ");
					genericIdlist.append("'"+resultSet.getString("GENERIC_ID")+"', ");
					formCodelist.append("'"+resultSet.getString("FORM_CODE")+"', ");
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			}
			else{
				
				closeStatement( pstmt ) ;	
			}
			//added for mms-kh-crf-0020  END
//System.err.println("=============drugCodelist1===========>"+drugCodelist1+" LENGTH===>"+drugCodelist1.length()+" SUBSTRING="+drugCodelist1.toString().substring(0, drugCodelist1.length()-2));
			if(drugCodelist.length()>0){
				formCodelist.append("'*A', ");
				drugCode_List = drugCodelist.toString().substring(0, drugCodelist.length()-2);
				//drugCode_List2 = drugCodelist2.toString().substring(0, drugCodelist2.length()-2);
				genericId_list = genericIdlist.toString().substring(0, genericIdlist.length()-2);
				//genericId_list2 = genericIdlist2.toString().substring(0, genericIdlist2.length()-2);
				formCode_list = formCodelist.toString().substring(0, formCodelist.length()-2);
			}
System.err.println("====patient_id====>"+patient_id+"======drugCode_List=====>"+drugCode_List+"drugCodelist.length()===>"+drugCodelist.length()+"genericId_list===>"+genericId_list+" formCode_list="+formCode_list);
			if(drugCodelist.length()>0){
//REVERTED FOR SKR-SCF-1684 
				sql_query      = "select intr_type1, intr_type2, intr_code, form_code, form_desc, intr_name, intr_severity_level, intr_signif_level, intr_prob_level, intr_restrt_yn, intr_remarks,drug_inter_type, LAB_ORD_CHK_UPTO_NO_OF_DAYS from ( select row_number() over (partition by generic_id1,generic_id2 order by intr_type1, intr_type2 ) line_srl_no, form_code, intr_type1, intr_type2, intr_code, intr_code1, generic_id1, generic_id2, form_desc, intr_name, intr_name2, intr_severity_level, intr_signif_level, intr_prob_level, intr_restrt_yn, intr_remarks,drug_inter_type, LAB_ORD_CHK_UPTO_NO_OF_DAYS   from ( SELECT row_number() over (partition by intr_type1 || intr_type2 || intr_code1 || intr_code2 order by (form_code1 || FORM_CODE2) desc) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code,intr_code1 intr_code1,d1.generic_id generic_id1,d2.generic_id generic_id2, form_code2 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d2.drug_desc intr_name, d1.drug_desc intr_name2,b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks,'D' drug_inter_type ,LAB_ORD_CHK_UPTO_NO_OF_DAYS  FROM ph_drug_interaction b, ph_drug_lang_vw d1, ph_drug_lang_vw d2 WHERE intr_type1 = ? AND intr_type2 = ? AND b.intr_code1 = d1.drug_code AND b.intr_code2 = d2.drug_code AND intr_code1 = ? AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND intr_code2 IN ("+drugCode_List+") AND form_code2 IN ("+formCode_list+") AND d1.language_id = ? AND d2.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT row_number() over (partition by intr_type1 || intr_type2 || intr_code1 || intr_code2 order by (form_code1 || FORM_CODE2) desc) srl_no, b.intr_type1, b.intr_type2, b.intr_code1 intr_code,intr_code2 intr_code1,d1.generic_id generic_id1,d2.generic_id generic_id2, form_code1 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code1 AND language_id = d1.language_id) ) form_desc, d1.drug_desc intr_name, d2.drug_desc intr_name2,b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks ,'D' drug_inter_type, LAB_ORD_CHK_UPTO_NO_OF_DAYS FROM ph_drug_interaction b, ph_drug_lang_vw d1, ph_drug_lang_vw d2 WHERE intr_type1 = ? AND intr_type2 = ? AND b.intr_code1 = d1.drug_code AND b.intr_code2 = d2.drug_code AND intr_code1 IN ("+drugCode_List+") AND form_code1 IN ("+formCode_list+") AND intr_code2 = ? AND form_code2 = DECODE (?, form_code2, form_code2, '*A') AND d1.language_id = ? AND d2.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT row_number() over (partition by intr_type1 || intr_type2 || intr_code1 || intr_code2 order by (form_code1 || FORM_CODE2) desc) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code,intr_code1 intr_code1,d1.generic_id generic_id1,d2.generic_id generic_id2, form_code2 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d3.drug_desc intr_name, d1.generic_name intr_name2 ,b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks,'G' drug_inter_type, LAB_ORD_CHK_UPTO_NO_OF_DAYS  FROM ph_drug_interaction b, ph_generic_name_lang_vw d1, ph_generic_name_lang_vw d2, ph_drug_lang_vw d3 WHERE intr_type1 = ? AND intr_type2 = ? AND b.intr_code1 = d1.generic_id AND b.intr_code2 = d2.generic_id and D3.GENERIC_ID = D2.GENERIC_ID and d3.drug_code in ("+drugCode_List+") AND d3.language_id=d2.language_id AND intr_code1 = ? AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND intr_code2 IN ("+genericId_list+") AND form_code2 IN ("+formCode_list+") AND d1.language_id = ? AND d2.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT row_number() over (partition by intr_type1 || intr_type2 || intr_code1 || intr_code2 order by (form_code1 || FORM_CODE2) desc) srl_no, b.intr_type1, b.intr_type2, intr_code1 intr_code,intr_code2 intr_code1,d1.generic_id generic_id1,d2.generic_id generic_id2, form_code1 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code1 AND language_id = d1.language_id) ) form_desc, d3.drug_desc intr_name,d2.generic_name intr_name2,b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks ,'G' drug_inter_type, LAB_ORD_CHK_UPTO_NO_OF_DAYS FROM ph_drug_interaction b, ph_generic_name_lang_vw d1, ph_generic_name_lang_vw d2, ph_drug_lang_vw d3 WHERE intr_type1 = ? AND intr_type2 = ? AND b.intr_code1 = d1.generic_id AND b.intr_code2 = d2.generic_id and D3.GENERIC_ID = D1.GENERIC_ID and d3.drug_code in ("+drugCode_List+") AND d3.language_id=d2.language_id AND intr_code1 IN ("+genericId_list+") AND form_code1 IN ("+formCode_list+") AND intr_code2 = ? AND form_code2 = DECODE (?, form_code2, form_code2, '*A') AND d1.language_id = ? AND d2.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1  || intr_type2 || intr_code1  || intr_code2 ORDER BY (   form_code1  || form_code2) DESC)  srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code,  intr_code1 intr_code1, d1.generic_id generic_id1, d2.INGREDIENT_CODE generic_id2, form_code2 form_code,  DECODE (form_code1,'*A', 'All', (SELECT form_desc  FROM ph_form_lang_vw  WHERE form_code = b.form_code2  AND language_id = d1.language_id) ) form_desc,  d2.short_desc intr_name, d1.drug_desc intr_name2, b.intr_severity_level, b.intr_signif_level,  b.intr_prob_level, intr_restrt_yn, intr_remarks,'O' drug_inter_type, LAB_ORD_CHK_UPTO_NO_OF_DAYS  FROM ph_drug_interaction b,  ph_drug_lang_vw d1,  ds_ingredient d2 WHERE intr_type1 = 'D'  AND intr_type2 = 'F'  AND b.intr_code1 = d1.drug_code  AND b.intr_code2 = d2.INGREDIENT_CODE AND intr_code1 = ?  AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND d1.language_id = ?  AND b.eff_status = 'E' UNION ALL SELECT  ROW_NUMBER () OVER (PARTITION BY    intr_type1  || intr_type2  || intr_code1 || intr_code2 ORDER BY (   form_code1  || form_code2) DESC)  srl_no,  b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1,  d2.INGREDIENT_CODE generic_id2, form_code2 form_code,  DECODE (form_code1, '*A', 'All',(SELECT form_desc  FROM ph_form_lang_vw  WHERE form_code = b.form_code2  AND language_id = d1.language_id)  ) form_desc, d2.short_desc intr_name, d1.generic_name intr_name2,  b.intr_severity_level, b.intr_signif_level, b.intr_prob_level,  intr_restrt_yn, intr_remarks,'O' drug_inter_type, LAB_ORD_CHK_UPTO_NO_OF_DAYS FROM ph_drug_interaction b, ph_generic_name_lang_vw d1,  ds_ingredient d2,  ph_drug_lang_vw d3 WHERE intr_type1 = 'G'  AND intr_type2 = 'F'  AND b.intr_code1 = d1.generic_id  AND b.intr_code2 = d2.INGREDIENT_CODE  AND d3.generic_id = d1.generic_id  AND d3.generic_id = b.intr_code1 AND d3.drug_code IN ("+drugCode_List+")  AND d3.language_id = d1.language_id  AND intr_code1 = ?  AND form_code1 = DECODE (?, form_code1, form_code1, '*A')  AND d1.language_id = ?  AND d3.language_id = ?  AND b.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1  || intr_type2  || intr_code1 || intr_code2 ORDER BY (form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code,intr_code1 intr_code1, d1.generic_id generic_id1, d2.ORDER_CATALOG_CODE generic_id2, form_code2 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc  FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id)  ) form_desc, d2.short_desc intr_name, d1.drug_desc intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks,'L' drug_inter_type, LAB_ORD_CHK_UPTO_NO_OF_DAYS  FROM ph_drug_interaction b, ph_drug_lang_vw d1 ,or_order_catalog d2  WHERE intr_type1 = 'D' AND intr_type2 = 'L'  and d2.order_category='LB' AND b.intr_code1 = d1.drug_code   AND b.intr_code2 =  d2.order_catalog_code AND intr_code1 = ?  AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND d1.language_id = ? AND b.eff_status = 'E'   AND d2.EFF_STATUS = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1  || intr_type2  || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC)  srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1, d2.order_catalog_code generic_id2, form_code2 form_code,  DECODE (form_code1,'*A', 'All', (SELECT form_desc FROM ph_form_lang_vw  WHERE form_code = b.form_code2  AND language_id = d1.language_id)  ) form_desc, d2.short_desc intr_name, d1.generic_name intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks,'L' drug_inter_type, LAB_ORD_CHK_UPTO_NO_OF_DAYS  FROM ph_drug_interaction b, ph_generic_name_lang_vw d1, or_order_catalog d2, ph_drug_lang_vw d3  WHERE intr_type1 = 'G'  AND intr_type2 = 'L'  and d2.order_category='LB' AND b.intr_code1 = d1.generic_id  AND b.intr_code2 = d2.order_catalog_code  AND d3.generic_id = d1.generic_id AND d3.generic_id = b.intr_code1  AND d3.language_id = d1.language_id   AND intr_code1 = ?  AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND d1.language_id = ?  AND d3.language_id = ?  AND b.eff_status = 'E'  AND d2.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1  || intr_type2  || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC)  srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1, d2.TERM_CODE generic_id2, form_code2 form_code,  DECODE (form_code1,'*A', 'All', (SELECT form_desc FROM ph_form_lang_vw  WHERE form_code = b.form_code2  AND language_id = d1.language_id)  ) form_desc, d2.TERM_CODE_SHORT_DESC intr_name, d1.generic_name intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks,'I' drug_inter_type, lab_ord_chk_upto_no_of_days  FROM ph_drug_interaction b, ph_generic_name_lang_vw d1,PR_DIAGNOSIS d2 WHERE intr_type1 = 'G' AND intr_type2 = 'I' AND b.intr_code1 = d1.generic_id AND B.TERM_SET_ID =D2.TERM_SET_ID AND b.intr_code2 = d2.TERM_CODE AND D2.PATIENT_ID =? AND D2.CURR_ENCOUNTER_ID =? AND intr_code1 = ?  AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND d1.language_id = ? AND b.eff_status = 'E'  AND d2.CURR_STATUS = 'A' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1  || intr_type2  || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC)  srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.drug_desc generic_id1, d2.TERM_CODE generic_id2, form_code2 form_code,  DECODE (form_code1,'*A', 'All', (SELECT form_desc FROM ph_form_lang_vw  WHERE form_code = b.form_code2  AND language_id = d1.language_id)  ) form_desc, d2.TERM_CODE_SHORT_DESC intr_name, d1.drug_desc intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks,'I' drug_inter_type, lab_ord_chk_upto_no_of_days  FROM ph_drug_interaction b, ph_drug_lang_vw d1,PR_DIAGNOSIS d2 WHERE intr_type1 = 'D' AND intr_type2 = 'I' AND b.intr_code1 = d1.drug_code AND B.TERM_SET_ID =D2.TERM_SET_ID AND b.intr_code2 = d2.TERM_CODE AND D2.PATIENT_ID =? AND D2.CURR_ENCOUNTER_ID =? AND intr_code1 = ?  AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND d1.language_id = ? AND b.eff_status = 'E'  AND d2.CURR_STATUS = 'A' ) where srl_no = 1 order by drug_inter_type) where line_srl_no = 1" ; // IN ("+drugCode_List+") modified - FD-RUT-CRF-0066.1 [IN036975] drug_inter_type added for MMS-KH-CRF-0029 
		//		sql_query      = "SELECT intr_type1, intr_type2, intr_code, form_code, form_desc, intr_name, intr_severity_level, intr_signif_level, intr_prob_level, intr_restrt_yn, intr_remarks, drug_inter_type, lab_ord_chk_upto_no_of_days FROM (SELECT   ROW_NUMBER () OVER (PARTITION BY generic_id1, generic_id2 ORDER BY intr_type1, intr_type2) line_srl_no, form_code, intr_type1, intr_type2, intr_code, intr_code1, generic_id1, generic_id2, form_desc, intr_name, intr_name2, intr_severity_level, intr_signif_level, intr_prob_level, intr_restrt_yn, intr_remarks, drug_inter_type, lab_ord_chk_upto_no_of_days FROM (SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1 || intr_type2 || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1, d2.generic_id generic_id2, form_code2 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d2.drug_desc intr_name, d1.drug_desc intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks, 'D' drug_inter_type, lab_ord_chk_upto_no_of_days FROM ph_drug_interaction b, ph_drug_lang_vw d1, ph_drug_lang_vw d2 WHERE intr_type1 = ? AND intr_type2 = ? AND b.intr_code1 = d1.drug_code AND b.intr_code2 = d2.drug_code AND intr_code1 = ? AND form_code1 = DECODE (?, form_code1, form_code1, '*A' ) AND intr_code2 IN (?) AND form_code2 IN (?) AND d1.language_id = ? AND d2.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1 || intr_type2 || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, b.intr_code1 intr_code, intr_code2 intr_code1, d1.generic_id generic_id1, d2.generic_id generic_id2, form_code1 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code1 AND language_id = d1.language_id) ) form_desc, d1.drug_desc intr_name, d2.drug_desc intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks, 'D' drug_inter_type, lab_ord_chk_upto_no_of_days FROM ph_drug_interaction b, ph_drug_lang_vw d1, ph_drug_lang_vw d2 WHERE intr_type1 = ? AND intr_type2 = ? AND b.intr_code1 = d1.drug_code AND b.intr_code2 = d2.drug_code AND intr_code1 IN (?) AND form_code1 IN (?) AND intr_code2 = ? AND form_code2 = DECODE (?, form_code2, form_code2, '*A' ) AND d1.language_id = ? AND d2.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1 || intr_type2 || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1, d2.generic_id generic_id2, form_code2 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d3.drug_desc intr_name, d1.generic_name intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks, 'G' drug_inter_type, lab_ord_chk_upto_no_of_days FROM ph_drug_interaction b, ph_generic_name_lang_vw d1, ph_generic_name_lang_vw d2, ph_drug_lang_vw d3 WHERE intr_type1 = ? AND intr_type2 = ? AND b.intr_code1 = d1.generic_id AND b.intr_code2 = d2.generic_id AND d3.generic_id = d2.generic_id AND d3.drug_code IN (?) AND d3.language_id = d2.language_id AND intr_code1 = ? AND form_code1 = DECODE (?, form_code1, form_code1, '*A' ) AND intr_code2 IN (?) AND form_code2 IN (?) AND d1.language_id = ? AND d2.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1 || intr_type2 || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code1 intr_code, intr_code2 intr_code1, d1.generic_id generic_id1, d2.generic_id generic_id2, form_code1 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code1 AND language_id = d1.language_id) ) form_desc, d3.drug_desc intr_name, d2.generic_name intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks, 'G' drug_inter_type, lab_ord_chk_upto_no_of_days FROM ph_drug_interaction b, ph_generic_name_lang_vw d1, ph_generic_name_lang_vw d2, ph_drug_lang_vw d3 WHERE intr_type1 = ? AND intr_type2 = ? AND b.intr_code1 = d1.generic_id AND b.intr_code2 = d2.generic_id AND d3.generic_id = d1.generic_id AND d3.drug_code IN (?) AND d3.language_id = d2.language_id AND intr_code1 IN (?) AND form_code1 IN (?) AND intr_code2 = ? AND form_code2 = DECODE (?, form_code2, form_code2, '*A' ) AND d1.language_id = ? AND d2.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1 || intr_type2 || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1, d2.ingredient_code generic_id2, form_code2 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d2.short_desc intr_name, d1.drug_desc intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks, 'O' drug_inter_type, lab_ord_chk_upto_no_of_days FROM ph_drug_interaction b, ph_drug_lang_vw d1, ds_ingredient d2 WHERE intr_type1 = 'D' AND intr_type2 = 'F' AND b.intr_code1 = d1.drug_code AND b.intr_code2 = d2.ingredient_code AND intr_code1 = ? AND form_code1 = DECODE (?, form_code1, form_code1, '*A' ) AND d1.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1 || intr_type2 || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1, d2.ingredient_code generic_id2, form_code2 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d2.short_desc intr_name, d1.generic_name intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks, 'O' drug_inter_type, lab_ord_chk_upto_no_of_days FROM ph_drug_interaction b, ph_generic_name_lang_vw d1, ds_ingredient d2, ph_drug_lang_vw d3 WHERE intr_type1 = 'G' AND intr_type2 = 'F' AND b.intr_code1 = d1.generic_id AND b.intr_code2 = d2.ingredient_code AND d3.generic_id = d1.generic_id AND d3.generic_id = b.intr_code1 AND d3.drug_code IN (?) AND d3.language_id = d1.language_id AND intr_code1 = ? AND form_code1 = DECODE (?, form_code1, form_code1, '*A' ) AND d1.language_id = ? AND d3.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1 || intr_type2 || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1, d2.order_catalog_code generic_id2, form_code2 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d2.short_desc intr_name, d1.drug_desc intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks, 'L' drug_inter_type, lab_ord_chk_upto_no_of_days FROM ph_drug_interaction b, ph_drug_lang_vw d1, or_order_catalog d2 WHERE intr_type1 = 'D' AND intr_type2 = 'L' AND d2.order_category = 'LB' AND b.intr_code1 = d1.drug_code AND b.intr_code2 = d2.order_catalog_code AND intr_code1 = ? AND form_code1 = DECODE (?, form_code1, form_code1, '*A' ) AND d1.language_id = ? AND b.eff_status = 'E' AND d2.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1 || intr_type2 || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1, d2.order_catalog_code generic_id2, form_code2 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d2.short_desc intr_name, d1.generic_name intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks, 'L' drug_inter_type, lab_ord_chk_upto_no_of_days FROM ph_drug_interaction b, ph_generic_name_lang_vw d1, or_order_catalog d2, ph_drug_lang_vw d3 WHERE intr_type1 = 'G' AND intr_type2 = 'L' AND d2.order_category = 'LB' AND b.intr_code1 = d1.generic_id AND b.intr_code2 = d2.order_catalog_code AND d3.generic_id = d1.generic_id AND d3.generic_id = b.intr_code1 AND d3.language_id = d1.language_id AND intr_code1 = ? AND form_code1 = DECODE (?, form_code1, form_code1, '*A' ) AND d1.language_id = ? AND d3.language_id = ? AND b.eff_status = 'E' AND d2.eff_status = 'E') WHERE srl_no = 1 ORDER BY drug_inter_type) WHERE line_srl_no = 1" ; //Added for COMMON-ICN-0075
	
//Query Food and Lab Union ALL added for MMS-KH-CRF-0029
//modified again for MMS-KH-CRF-0029
//LAB_ORD_CHK_UPTO_NO_OF_DAYS added for MMS-KH-CRF-0034
				pstmt		   = connection.prepareStatement(sql_query) ;
				int count =1;
				//MMS-KH-CRF-0034
				String lab_ord_chk_upto = "" ; 
				String alert_flag_yn    = ""; 
				String return_flag_yn = "";
				String test_result  = ""; //MMS-KH-CRF-0034.2
				String test_result_value = "";//MMS-KH-CRF-0034.2
				pstmt.setString(count++,"D"); //intr_type1 
				pstmt.setString(count++, "D"); //intr_type2
				pstmt.setString(count++, drug_code); //intr_code1
				pstmt.setString(count++, form_code); //intr_code1
				//pstmt.setString(count++,drugCode_List); //Added for COMMON-ICN-0075//REVERTED FOR SKR-SCF-1684 
			//	pstmt.setString(count++,formCode_list);  //Added for COMMON-ICN-0075//REVERTED FOR SKR-SCF-1684 
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,"D"); //intr_type1 
				pstmt.setString(count++, "D"); //intr_type2
			//	pstmt.setString(count++,drugCode_List); //Added for COMMON-ICN-0075//REVERTED FOR SKR-SCF-1684 
			//	pstmt.setString(count++,formCode_list);  //Added for COMMON-ICN-0075//REVERTED FOR SKR-SCF-1684 
				pstmt.setString(count++, drug_code); //intr_code2
				pstmt.setString(count++, form_code); //intr_code2
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,"G"); //intr_type1 
				pstmt.setString(count++, "G"); //intr_type2
			//	pstmt.setString(count++,drugCode_List); //Added for COMMON-ICN-0075//REVERTED FOR SKR-SCF-1684 
				pstmt.setString(count++, generic_id); //intr_code1
				pstmt.setString(count++, form_code); //intr_code1
			//	pstmt.setString(count++,genericId_list); //Added for COMMON-ICN-0075//REVERTED FOR SKR-SCF-1684 
			//	pstmt.setString(count++,formCode_list);  //Added for COMMON-ICN-0075//REVERTED FOR SKR-SCF-1684 
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,getLanguageId());
				pstmt.setString(count++,"G"); //intr_type1 
				pstmt.setString(count++, "G"); //intr_type2
			//	pstmt.setString(count++,drugCode_List); //Added for COMMON-ICN-0075//REVERTED FOR SKR-SCF-1684 
			//	pstmt.setString(count++,genericId_list); //Added for COMMON-ICN-0075//REVERTED FOR SKR-SCF-1684 
			//	pstmt.setString(count++,formCode_list);  //Added for COMMON-ICN-0075//REVERTED FOR SKR-SCF-1684 
				pstmt.setString(count++,generic_id); //intr_code2
				pstmt.setString(count++,form_code); //intr_code2
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,getLanguageId()); 
// MMS-KH-CRF-0029[IN070606] -start
				pstmt.setString(count++,drug_code); 
				pstmt.setString(count++,form_code); 
				pstmt.setString(count++,getLanguageId()); 
			//	pstmt.setString(count++,drugCode_List); //Added for COMMON-ICN-0075 //REVERTED FOR SKR-SCF-1684 

				pstmt.setString(count++,generic_id); 
				pstmt.setString(count++,form_code); 
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,getLanguageId()); 

				pstmt.setString(count++,drug_code); 
				pstmt.setString(count++,form_code); 
				pstmt.setString(count++,getLanguageId()); 


				pstmt.setString(count++,generic_id); 
				pstmt.setString(count++,form_code); 
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,getLanguageId()); 
// MMS-KH-CRF-0029[IN070606] -end
//Adding start for MMS-DM-CRF-0229
                pstmt.setString(count++,patient_id); 
				pstmt.setString(count++,getEncounterId());
				pstmt.setString(count++,generic_id); 
				pstmt.setString(count++,form_code); 
				pstmt.setString(count++,getLanguageId());

				pstmt.setString(count++,patient_id); 
				pstmt.setString(count++,getEncounterId());
				pstmt.setString(count++,drug_code); 
				pstmt.setString(count++,form_code); 
				pstmt.setString(count++,getLanguageId());//Adding end for MMS-DM-CRF-0229
				resultSet	= pstmt.executeQuery();
	// MMS-KH-CRF-0029[IN070606] -start			
				String intr_type2 = "";
				String food_flag_yn = "N";
				String food_code = "";
				String lab_code = "";
				String lab_flag_yn = "N";
				int lab_flag_count = 0;
				String startDate = ""; //MMS-KH-CRF-0029
				String endDate = ""; //MMS-KH-CRF-0029
				String encounter_id = getEncounterId();
				if(encounter_id==null)
					encounter_id = "";
// MMS-KH-CRF-0029[IN070606] -end
				if(resultSet!= null){
					while(resultSet.next()){
						hmDrugIntrDtl = new HashMap();
		// MMS-KH-CRF-0029[IN070606] -start
						 intr_type2 = resultSet.getString("INTR_TYPE2")==null?"":resultSet.getString("INTR_TYPE2");
					 System.err.println(" PrescriptionBean_1.java=====10241=intr_type2==>"+intr_type2);
						if(!intr_type2.equals("F") && !intr_type2.equals("L")){//modified for MMS-KH-CRF-0029
						
							hmDrugIntrDtl.put("INTR_TYPE1",resultSet.getString("INTR_TYPE1")); //0
							hmDrugIntrDtl.put("INTR_TYPE2",resultSet.getString("INTR_TYPE2"));
							hmDrugIntrDtl.put("intr_code",resultSet.getString("intr_code"));
							hmDrugIntrDtl.put("intr_name",resultSet.getString("intr_name")); //3
							hmDrugIntrDtl.put("severity_level",resultSet.getString("intr_severity_level")); //4
							hmDrugIntrDtl.put("significant_level",resultSet.getString("intr_signif_level"));
							hmDrugIntrDtl.put("probability",resultSet.getString("intr_prob_level"));
							hmDrugIntrDtl.put("restrict_transaction",resultSet.getString("INTR_RESTRT_YN"));//7
							hmDrugIntrDtl.put("interaction_desc",resultSet.getString("INTR_REMARKS")); //8
							hmDrugIntrDtl.put("form_desc",resultSet.getString("form_desc")); //9    FD-RUT-CRF-0066.1 [IN036975]
							
							if(restrict_transaction.equals("N"))
								restrict_transaction = resultSet.getString("INTR_RESTRT_YN"); 
							if(!severity_level.equals("H"))
								severity_level = resultSet.getString("intr_severity_level"); 
							
							hmDrugIntrDtllst.add(hmDrugIntrDtl);
						
						}// MMS-KH-CRF-0029[IN070606] -end
						else{
							if(intr_type2.equals("F") || intr_type2.equals("L")){//added for MMS-KH-CRF-0029
							startDate = start_date.substring(0,10); //MMS-KH-CRF-0029
							endDate   = end_date.substring(0,10); //MMS-KH-CRF-0029
								
										if(intr_type2.equals("L")){
										//MMS-KH-CRF-0034
										lab_ord_chk_upto = "";
										alert_flag_yn	 = "";
										return_flag_yn	 = "NN";
										test_result = "";	//MMS-KH-CRF-0034.2
										test_result_value = ""; //MMS-KH-CRF-0034.2

										lab_code  = (String)resultSet.getString("intr_code")==null?"":(String)resultSet.getString("intr_code");

										lab_ord_chk_upto = (String)resultSet.getString("LAB_ORD_CHK_UPTO_NO_OF_DAYS")==null?"":(String)resultSet.getString("LAB_ORD_CHK_UPTO_NO_OF_DAYS");//MMS-KH-CRF-0034

										lab_flag_yn = "N";
										lab_flag_count = 0;
										pstmt2.setString( 1, patient_id);
										pstmt2.setString( 2, encounter_id);
										/*pstmt2.setString( 3, start_date);
										pstmt2.setString( 4, end_date);
										pstmt2.setString( 5, start_date);
										pstmt2.setString( 6, end_date);
										pstmt2.setString( 7, start_date);
										pstmt2.setString( 8, end_date); */
										pstmt2.setString( 3, lab_code);

										resultSet2	= pstmt2.executeQuery();
										if(resultSet2!=null && resultSet2.next()){
											lab_flag_count = resultSet2.getInt("count");
											if(lab_flag_count>0)
											lab_flag_yn = "Y";
										}  
										closeResultSet( resultSet2 ) ; //Added for Common-ICN-0075
									//added for MMS-KH-CRF-0034
										if(lab_ord_chk_upto!= null && !lab_ord_chk_upto.equals("")){

											pstmt4.setString( 1, getLoginFacilityId());
											pstmt4.setString( 2, patient_id);
											pstmt4.setString( 3, lab_code);
											pstmt4.setInt( 4,Integer.parseInt(lab_ord_chk_upto));
											resultSet4	= pstmt4.executeQuery();
											if(resultSet4!=null && resultSet4.next()){
												test_result = resultSet4.getString("alert_flag")==null?"":resultSet4.getString("alert_flag");
											//MMS-KH-CRF-0034.2
												String result[] = test_result.split("~");
												if(result.length>1){
													return_flag_yn = result[0];
													test_result_value = result[1];
												}
												else
													return_flag_yn = test_result;
									//MMS-KH-CRF-0034.2 - end
					//	System.err.println("PrescriptionBean_1.java===return_flag_yn==10408===>"+return_flag_yn+"==test_result===>"+test_result);
											}
											
											closeResultSet( resultSet4 ) ; //Added for Common-ICN-0075
										}
										if(return_flag_yn!=null && !return_flag_yn.equals("") && (return_flag_yn.equals("YY") || return_flag_yn.equals("YN") || return_flag_yn.equals("NY"))){ //modified for //MMS-KH-CRF-0034.2
											
											lab_flag_yn = "Y";
										}
										//System.err.println("lab_flag_yn==10361==>"+lab_flag_yn);
										//if(lab_flag_yn.equals("N")){ //MMS-KH-CRF-0029 - start
										if(return_flag_yn.equals("NN") || (lab_flag_yn.equals("N"))){ //modified for //MMS-KH-CRF-0034.2
											pstmt3.setString( 1, getLoginFacilityId());
											pstmt3.setString( 2, patient_id);
											pstmt3.setString( 3, encounter_id);
											pstmt3.setString( 4, lab_code);
											resultSet3	= pstmt3.executeQuery();
											if(resultSet3!=null && resultSet3.next()){
												lab_flag_count = resultSet3.getInt("cunt");
												if(lab_flag_count>0)
													lab_flag_yn = "Y";
											}

										}//MMS-KH-CRF-0029 - end
										closeResultSet( resultSet2 ) ;
										closeResultSet( resultSet3 ) ;//MMS-KH-CRF-0029 
										closeResultSet( resultSet4 ) ;
											
										if(lab_flag_yn.equals("Y")){ //modified for MMS-KH-CRF-0029
											hmDrugIntrDtl.put("INTR_TYPE1",resultSet.getString("INTR_TYPE1")); //0
											hmDrugIntrDtl.put("INTR_TYPE2",resultSet.getString("INTR_TYPE2"));
											hmDrugIntrDtl.put("intr_code",resultSet.getString("intr_code"));
											hmDrugIntrDtl.put("intr_name",resultSet.getString("intr_name")); //3
											hmDrugIntrDtl.put("severity_level",resultSet.getString("intr_severity_level")); //4
											hmDrugIntrDtl.put("significant_level",resultSet.getString("intr_signif_level"));
											hmDrugIntrDtl.put("probability",resultSet.getString("intr_prob_level"));
											hmDrugIntrDtl.put("restrict_transaction",resultSet.getString("INTR_RESTRT_YN"));//7
											hmDrugIntrDtl.put("interaction_desc",resultSet.getString("INTR_REMARKS")); //8
											hmDrugIntrDtl.put("form_desc",resultSet.getString("form_desc")); //9    FD-RUT-CRF-0066.1 [IN036975]
											hmDrugIntrDtl.put("return_flag_yn",return_flag_yn);//MMS-KH-CRF-0034.2
											hmDrugIntrDtl.put("test_result_value",test_result_value);//MMS-KH-CRF-0034.2
											if(restrict_transaction.equals("N"))
												restrict_transaction = resultSet.getString("INTR_RESTRT_YN"); 
											if(!severity_level.equals("H"))
												severity_level = resultSet.getString("intr_severity_level"); 
								
											hmDrugIntrDtllst.add(hmDrugIntrDtl);
											}
										}
								 
								 else {
									 if(intr_type2.equals("F")){
								food_code  = (String)resultSet.getString("intr_code")==null?"":(String)resultSet.getString("intr_code");
								food_flag_yn = "N";

								pstmt1.setString( 1, getLoginFacilityId());
								pstmt1.setString( 2, patient_id);
								pstmt1.setString( 3, startDate); //MMS-KH-CRF-0029
								pstmt1.setString( 4, endDate); //MMS-KH-CRF-0029
								pstmt1.setString( 5, food_code);
								pstmt1.setString( 6, encounter_id);//added for MMS-KH-CRF-0029
								pstmt1.setString( 7, getPatientClass());//added for MMS-KH-CRF-0029
								
System.err.println("getLoginFacilityId()=====10257=>"+getLoginFacilityId()+"==patient_id====>"+patient_id+"==startDate==>"+startDate+"==endDate===>"+endDate+"==food_code===>"+food_code+"==encounter_id===>"+encounter_id+"==patient_class===>"+patient_class+"==getPatientClass()===>"+getPatientClass());

								resultSet1	= pstmt1.executeQuery();
								if(resultSet1!=null && resultSet1.next()){ 
									food_flag_yn = (String)resultSet1.getString("food_yn")==null?"N":(String)resultSet1.getString("food_yn");
								}
								closeResultSet( resultSet1 ) ;
								if(food_flag_yn.equals("Y")){
								
									hmDrugIntrDtl.put("INTR_TYPE1",resultSet.getString("INTR_TYPE1")); //0
									hmDrugIntrDtl.put("INTR_TYPE2",resultSet.getString("INTR_TYPE2"));
									hmDrugIntrDtl.put("intr_code",resultSet.getString("intr_code"));
									hmDrugIntrDtl.put("intr_name",resultSet.getString("intr_name")); //3
									hmDrugIntrDtl.put("severity_level",resultSet.getString("intr_severity_level")); //4
									hmDrugIntrDtl.put("significant_level",resultSet.getString("intr_signif_level"));
									hmDrugIntrDtl.put("probability",resultSet.getString("intr_prob_level"));
									hmDrugIntrDtl.put("restrict_transaction",resultSet.getString("INTR_RESTRT_YN"));//7
									hmDrugIntrDtl.put("interaction_desc",resultSet.getString("INTR_REMARKS")); //8
									hmDrugIntrDtl.put("form_desc",resultSet.getString("form_desc")); //9    FD-RUT-CRF-0066.1 [IN036975]

									if(restrict_transaction.equals("N"))
										restrict_transaction = resultSet.getString("INTR_RESTRT_YN"); 
									if(!severity_level.equals("H"))
										severity_level = resultSet.getString("intr_severity_level"); 
						
									hmDrugIntrDtllst.add(hmDrugIntrDtl);
									}
									}
								 }
								}
						}
					}
					hmDrugIntrDtllst.add(severity_level);
					hmDrugIntrDtllst.add(restrict_transaction);
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		} 
		finally {
           	try{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ; 
				closeResultSet( resultSet2 ) ;// MMS-KH-CRF-0029[IN070606]  - start
				closeResultSet( resultSet3 ) ; 
				closeResultSet( resultSet4 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;// MMS-KH-CRF-0029[IN070606]  - start
				closeStatement( pstmt2 ) ;
				closeStatement( pstmt3 ) ;//MMS-KH-CRF-0029
				closeStatement( pstmt4 ) ;//MMS-KH-CRF-0029
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
        }
		return hmDrugIntrDtllst;	
	}//Added for	RUT-CRF-0066 IN[029604] -end

	public HashMap getPatientActiveOrdersForDC(String patient_id,String patient_class,String order_date,int take_home,String generic_ids,String from_date,String to_date)	{//Added from_date,to_date for BRU-HIMS-CRF-403 //added dor Bru-HIMS-CRF-265 [IN:032315] -- begin //ArryList changed to HashMap for HSA-CRF-0151 [IN:048468]
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String sql_str				=	"", append_qry="";
		String perf_locn			=	"";
		ArrayList activeOrders	= new ArrayList();
	//	ArrayList tmpActiveRecords = null; //added for HSA-CRF-0151 [IN:048468]  Removed for IN063877
		HashMap	record			= null;
		HashMap<String, ArrayList> hmGericIdBasedRecords = new HashMap(); //added for HSA-CRF-0151 [IN:048468]
		String generic_id = "";
		try{
			connection			= getConnection() ;
			String license=((String)(PhLicenceRights.getKey())).trim();
			//if(generic_ids!=null) //Commented for HSA-CRF-0151 [IN:048468]
			append_qry=" and c.GENERIC_ID in("+generic_ids+") AND a.generic_id =c.generic_id";   // added mapping with patient_drug_profile

			if(patient_class.equals("IP") ||take_home>0)
				append_qry	=	append_qry+" ORDER BY gn.generic_name, A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO,A.END_DATE DESC"; //gn.generic_name added for HSA-CRF-0151 [IN:048468]
			else 
				append_qry	=	append_qry+" ORDER BY gn.generic_name, A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO, A.END_DATE DESC"; //gn.generic_name added for HSA-CRF-0151 [IN:048468]

			if(license.equals("PH"))
				sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT104")+append_qry; //ph_generic_name_lang_vw added for HSA-CRF-0151 [IN:048468]
			else
				sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT105")+append_qry; //ph_generic_name_lang_vw added for HSA-CRF-0151 [IN:048468]
			if(order_date.equals(""))
				order_date	=	getOrderDate();

			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,getLoginFacilityId());
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,take_home+"");
			pstmt.setString(4,patient_id);
			if(license.equalsIgnoreCase("PH")){//Added for BRU-HIMS-CRF-403 --start
				pstmt.setString(5,from_date);
				pstmt.setString(6,to_date);
				pstmt.setString(7,from_date);
				pstmt.setString(8,to_date);
				pstmt.setString(9,from_date);
				pstmt.setString(10,to_date);
				pstmt.setString(11,getLanguageId());
				pstmt.setString(12,getLanguageId());
				pstmt.setString(13,getLanguageId());
				pstmt.setString(14,getLanguageId());
				//if(generic_id!=null) //Commented for HSA-CRF-0151 [IN:048468]
				//pstmt.setString(15,generic_ids);
			}//Added for BRU-HIMS-CRF-403 --end
			else{
				pstmt.setString(5,getLanguageId());
				pstmt.setString(6,getLanguageId());
				pstmt.setString(7,getLanguageId());
				pstmt.setString(8,getLanguageId());
				//if(generic_id!=null) //Commented for HSA-CRF-0151 [IN:048468]
					//pstmt.setString(9,generic_ids);
			}
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				record	=	new HashMap();
				generic_id = checkForNull(resultSet.getString("GENERIC_ID"),""); //added for HSA-CRF-0151 [IN:048468]
				if(!hmGericIdBasedRecords.containsKey(generic_id)) //added for HSA-CRF-0151 [IN:048468]
					activeOrders = new ArrayList();

				record.put("start_date",checkForNull(resultSet.getString("START_DATE"),""));
				record.put("end_date",checkForNull(resultSet.getString("END_DATE"),""));
				record.put("drug_desc",checkForNull(resultSet.getString("DRUG_DESC"),""));
				record.put("strength",checkForNull(resultSet.getString("STRENGTH"),""));
				record.put("split_dose_prev",checkForNull(resultSet.getString("SPLIT_DOSE_PREVIEW"),""));
				record.put("strength_uom_desc",checkForNull(resultSet.getString("STRENGTH_UOM"),""));
				record.put("form_desc",checkForNull(resultSet.getString("FORM_CODE"),""));
				record.put("practitioner_name",checkForNull(resultSet.getString("PRACTITIONER_NAME"),""));
				record.put("facility_name",checkForNull(resultSet.getString("FACILITY_NAME"),""));
				record.put("diag_text",checkForNull(resultSet.getString("DIAG_TEXT"),""));
				record.put("location",checkForNull(resultSet.getString("LOCATION"),""));
				record.put("order_id",checkForNull(resultSet.getString("ORIG_ORDER_ID"),""));
				record.put("order_line_no",checkForNull(resultSet.getString("ORIG_ORDER_LINE_NO"),""));
				record.put("freq_code",checkForNull(resultSet.getString("FREQ_CODE"),""));
				record.put("freq_desc",checkForNull(resultSet.getString("FREQ_DESC"),""));
				record.put("allergy_reason",checkForNull(resultSet.getString("ALLERGY_OVERRIDE_REASON"),""));
				record.put("dosage_reason",checkForNull(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"),""));
				record.put("duplicate_reason",checkForNull(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"),""));
				record.put("discont_date_time",checkForNull(resultSet.getString("DISCONT_DATE_TIME"),""));
				if(license.equals("PH"))
					perf_locn			=	checkForNull(resultSet.getString("PERF_LOCN"),"");
				else
					perf_locn			=	"";
				record.put("perf_locn",perf_locn);
				record.put("iv_prep_yn",checkForNull(resultSet.getString("IV_PREP_YN"),""));
				record.put("discharge_ind",checkForNull(resultSet.getString("DISCHARGE_IND"),""));
				record.put("in_formulary_yn",checkForNull(resultSet.getString("IN_FORMULARY_YN"),""));
				record.put("dosage",checkForNull(resultSet.getString("DOSAGE"),""));
				record.put("dosage_uom_desc",checkForNull(resultSet.getString("DOSAGE_UOM_DESC"),""));
				record.put("order_status_type",checkForNull(resultSet.getString("ORDER_STATUS_TYPE"),""));
				record.put("drug_code",checkForNull(resultSet.getString("DRUG_CODE"),""));
				record.put("sliding_scale",checkForNull(resultSet.getString("SLIDING_SCALE_YN"),""));
				activeOrders.add(record);

				hmGericIdBasedRecords.put(generic_id, activeOrders); //added for HSA-CRF-0151 [IN:048468]
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
			setActiveOrders(activeOrders);
		}
		catch(Exception e){
			System.err.println("===sql_str====>"+sql_str);
			e.printStackTrace() ;
			activeOrders.add(e.toString());
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
		return hmGericIdBasedRecords; //activeOrders changed to hmGericIdBasedRecords for HSA-CRF-0151 [IN:048468]
	}
	
	public ArrayList getCurrentActiveOrders(){
		return currentActiveOrders;
	}	

	public void setCurrentActiveOrders(ArrayList currActiveOrders){
		currentActiveOrders=new ArrayList();
		currentActiveOrders=currActiveOrders;
	}
	
	public String getMARDefaulting(String patient_class,String source_code,String form_code, String priority){// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- begin
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
		return MARDefaulting;
	}// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- end

	private String setDefaultValues(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        String sql_query="";
		ResultSet resultSet = null;
		String totTaperQtyDisp = "";
		try{
			connection = getConnection() ;
			sql_query      = "select crit_field_val,crit_field_id from PH_DISP_MEDN_DFLT where function_id in (?,?,?,?,?) and facility_id = decode(?, facility_id, facility_id,'*A')  and crit_field_id in (?,?,?)";
			pstmt		   = connection.prepareStatement(sql_query) ;
			pstmt.setString(1,"RX");
			pstmt.setString(2,"RX_ADR_ALLERGY");
			pstmt.setString(3,"NORMAL_RX");
			pstmt.setString(4,getLoginFacilityId());
			pstmt.setString(5,"TOTALTAPERQTY");
			pstmt.setString(6,"EXCLUDE_ADR_FROM_ALLERGY");
			pstmt.setString(7,"COPY_PREV_ORD_FOR_DISH_MEDN");
			pstmt.setString(8,"DRUG_SEACH_AUTOCOMPLETE_YN"); //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
			pstmt.setString(9,"PREVIEW_AUTH_STATUS_YN"); //added for ML-MMOH-CRF-0343 [IN:057182]
			
			resultSet	= pstmt.executeQuery();

			while(resultSet!= null && resultSet.next()) {
				if(resultSet.getString("CRIT_FIELD_ID").equals("TOTALTAPERQTY"))
					setTotalTaperQtyDisplay(checkForNull(resultSet.getString("CRIT_FIELD_VAL")));
				else if(resultSet.getString("CRIT_FIELD_ID").equals("EXCLUDE_ADR_FROM_ALLERGY"))//Added for HSA-SCF-0011 [IN:042444]
					setExcludeADRAllergyAlert(checkForNull(resultSet.getString("CRIT_FIELD_VAL")));
				else if(resultSet.getString("CRIT_FIELD_ID").equals("COPY_PREV_ORD_FOR_DISH_MEDN"))//Added for BRU-HIMS-CRF-403 [IN:044541]
					setCopyPrevOrderForDishargeMedn(checkForNull(resultSet.getString("CRIT_FIELD_VAL")));
				else if(resultSet.getString("CRIT_FIELD_ID").equals("DRUG_SEACH_AUTOCOMPLETE_YN"))//added for PMG2012-CRF-0019 [IN:035859] AutoComplete
					setDrugSeachAutocomplete_yn(checkForNull(resultSet.getString("CRIT_FIELD_VAL")));
				else if(resultSet.getString("CRIT_FIELD_ID").equals("PREVIEW_AUTH_STATUS_YN"))//Added for  ML-MMOH-CRF-0343 [IN:057182]
					setPreviewAuthStatus(checkForNull(resultSet.getString("CRIT_FIELD_VAL")));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
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
		return totTaperQtyDisp;
	}

	public String getCustomerID()throws Exception	{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rsCustomerID		= null;
		String customer_id			= "";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("SELECT CUSTOMER_ID FROM SM_SITE_PARAM WHERE SITE_ID = 'DS'");
			rsCustomerID = pstmt.executeQuery();
			if(rsCustomerID.next()){
				customer_id = rsCustomerID.getString("CUSTOMER_ID")==null?"":rsCustomerID.getString("CUSTOMER_ID");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsCustomerID ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return customer_id;
	}

	public boolean getAllergyConfDtls(String patient_id, String encounter_id) { //added for RUT-CRF-0064.1 [IN:041799]
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		boolean pt_allergy_conf_reqd = false;
		String allergy_conf_reqd_yn = "N", allergy_conf_reqd_yn_MR = "N";
		try{
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_GET_ALLERGY_CONF")) ;
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				allergy_conf_reqd_yn_MR = checkForNull(resultSet.getString("ALLERGY_CONF_REQD_YN"));
			}
			if(allergy_conf_reqd_yn_MR.equals("Y")){
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCIPTION_GET_ALLERGY_CONF")) ;
				pstmt.setString(1,login_facility_id);

				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next())	{
					allergy_conf_reqd_yn = checkForNull(resultSet.getString("ALLERGY_CONF_REQD_YN"));
				}
				if(allergy_conf_reqd_yn.equals("Y")){
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCIPTION_GET_PATIENT_ALLERGY_CONF")) ;
					pstmt.setString(1,patient_id);
					pstmt.setString(2,encounter_id);

					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next() && resultSet.getInt("ALLERGY_COUNT")>0)	{
						pt_allergy_conf_reqd	=	false;
					}
					else
						pt_allergy_conf_reqd = true;
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
		return pt_allergy_conf_reqd;
	}

	public String[] getExcpectedDate(String Patientid)throws Exception{   //Added for Bru-HIMS-CRF-403--start
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rs		= null;
		String expected_date			= "", start_date="", end_date="";
		String defDates[] = new String[3];
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("SELECT TO_CHAR (expected_discharge_date, 'DD/MM/YYYY HH24:MI' ) expected_discharge_date, TO_CHAR((CASE WHEN (expected_discharge_date> sysdate) then expected_discharge_date else sysdate end), 'DD/MM/YYYY HH24:MI' ) start_date, TO_CHAR ((CASE WHEN (expected_discharge_date> sysdate) then expected_discharge_date else sysdate end) + 1, 'DD/MM/YYYY HH24:MI') end_date FROM ip_discharge_advice WHERE patient_id = ? AND cancellation_date_time IS NULL  ");//Added CANCELLATION_DATE_TIME for IN047960 //Modified MM TO MI for IN047960
			pstmt.setString(1,Patientid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				expected_date = rs.getString("EXPECTED_DISCHARGE_DATE")==null?"":rs.getString("EXPECTED_DISCHARGE_DATE");
				start_date = rs.getString("START_DATE")==null?"":rs.getString("START_DATE");
				end_date = rs.getString("END_DATE")==null?"":rs.getString("END_DATE");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		defDates[0]=expected_date;
		defDates[1]=start_date;
		defDates[2]=end_date;
		return defDates;
	}
	
	public ArrayList checkdup()throws Exception	{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rs		= null;
		ArrayList extdetails = new ArrayList();
		try {
			connection	= getConnection() ;
			
			pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT14A")) ;
			pstmt.setString(1,login_facility_id);
				
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()) {
				extdetails.add(rs.getString("drug_db_duptherapy_yn"));
				extdetails.add(rs.getString("drug_db_interface_yn"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return extdetails;
	}
	
	public ArrayList caluculateDuaration(String org_dur,String org_dur_desc,String dur_value,String dur_desc){
		ArrayList cal_dur=new ArrayList();
		String temp = null;
		
		if(org_dur==null || org_dur.trim().length()==0){
			cal_dur.add(dur_value);
			cal_dur.add(dur_desc);
		}
		else if(org_dur_desc.equals(dur_desc)){
			cal_dur.add(dur_value);
			cal_dur.add(dur_desc);
		}
		else if(org_dur_desc.equals("W") && dur_desc.equals("D")){
			temp = String.valueOf(Math.ceil((Double.parseDouble(dur_value)/7)));
			cal_dur.add(temp);
			cal_dur.add(org_dur_desc);
		}
		else if(org_dur_desc.equals("L") && dur_desc.equals("D")){
			temp = String.valueOf(Math.ceil((Double.parseDouble(dur_value)/30)));
			cal_dur.add(temp);
			cal_dur.add(org_dur_desc);
		}
		else if(org_dur_desc.equals("Y") && dur_desc.equals("D")){
			temp = String.valueOf(Math.ceil((Double.parseDouble(dur_value)/365)));
			cal_dur.add(temp);
			cal_dur.add(org_dur_desc);
		}
		else if(org_dur_desc.equals("D") && dur_desc.equals("W")){
			cal_dur.add(dur_value);
			cal_dur.add(dur_desc);
		}
		else if(org_dur_desc.equals("L") && dur_desc.equals("W")){
			temp = String.valueOf(Math.ceil(((Double.parseDouble(dur_value)*7))/30));
			cal_dur.add(temp);
			cal_dur.add(org_dur_desc);
		}
		else if(org_dur_desc.equals("Y") && dur_desc.equals("W")){
			temp = String.valueOf(Math.ceil((Double.parseDouble(dur_value)*7))/365);
			cal_dur.add(temp);
			cal_dur.add(org_dur_desc);
		}
		else if(dur_desc.equals("L") && (org_dur_desc.equals("D") || org_dur_desc.equals("W"))){
			cal_dur.add(dur_value);
			cal_dur.add(dur_desc);
		}
		else if(org_dur_desc.equals("Y") && dur_desc.equals("L")){
			temp = String.valueOf(Math.ceil(((Double.parseDouble(dur_value)*30))/365));
			cal_dur.add(temp);
			cal_dur.add(org_dur_desc);
		}
		else if(dur_desc.equals("Y") && (org_dur_desc.equals("D") || org_dur_desc.equals("W") || org_dur_desc.equals("L"))){
			cal_dur.add(dur_value);
			cal_dur.add(dur_desc);
		}
		return cal_dur;
	}

	public void setPrintOrdShtRuleInd(HashSet order_type_code,String patient_class){//Added for Bru-HIMS-CRF-393_1.0
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String print_ord_sht_rule_ind = getPrintOrdShtRuleInd()==null ? "": getPrintOrdShtRuleInd();//null checked for ARYU-SCF-0035
		
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

	public void getOrderCatalogAuthRule(HashMap DrugDetails, String act_pat_class, String resp_id, String pract_id, String patient_id, String priority){//Added for HSA-CRF-0150 [IN:048467]
		Connection connection       = null ;
		CallableStatement cstmt			 = null;
		String sql_query="";
		PreparedStatement pstmt		= null;
        ResultSet resultSet		= null;
		
		try{
			connection		= getConnection() ;
			cstmt=connection.prepareCall("{call PH_ORDER_CATALOG_AUTH_RULE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");// ML-MMOH-CRF-1823 US008- 43528 
			cstmt.setString( 1, (String)DrugDetails.get("DRUG_CODE"));
			cstmt.setString( 2, act_pat_class);
			cstmt.setString( 3, locale);
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
			cstmt.setString( 15, patient_id);
			cstmt.setString( 16, getOrderDate());
			cstmt.setString( 17, priority);
			cstmt.registerOutParameter(18, Types.VARCHAR ); // ML-MMOH-CRF-1823 US008- 43528 
			cstmt.execute() ;

			DrugDetails.put("ORD_AUTH_REQD_YN",(cstmt.getString(8)==null ? "N":cstmt.getString(8)));
			DrugDetails.put("ORD_SPL_APPR_REQD_YN",(cstmt.getString(9)==null ? "N":cstmt.getString(9)) );
			DrugDetails.put("ORD_COSIGN_REQD_YN",(cstmt.getString(10)==null ? "N":cstmt.getString(10)) );
			DrugDetails.put("ORD_AUTHORIZED_PREV_YN",(cstmt.getString(11)==null ? "N":cstmt.getString(11)) );
			DrugDetails.put("ORD_APPROVED_YN",(cstmt.getString(12)==null ? "N":cstmt.getString(12)) );
			DrugDetails.put("ORD_COSIGNED_YN",(cstmt.getString(13)==null ? "N":cstmt.getString(13)) );
			DrugDetails.put("ORD_AUTHORIZED_YN",(String)DrugDetails.get("ORD_AUTHORIZED_PREV_YN"));
			DrugDetails.put("QUOTA_LIMIT_ACCESS_YN",(cstmt.getString(18)==null ? "N":cstmt.getString(18)) ); //ML-MMOH-CRF-1823 - 43528
			closeStatement( cstmt ) ;
			//ADDED FOR MO-SCF-5533 start
				sql_query			= "select AUTH_YN from or_review_user_categories where  PRACTITIONER_ID=? AND ORDER_CATEGORY='PH'";
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,pract_id);
				
				resultSet			= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					
					DrugDetails.put("ORD_AUTHORIZED_YN_DURN", resultSet.getString("AUTH_YN")==null?"N":resultSet.getString("AUTH_YN"));
				}
				//ADDED FOR MO-SCF-5533 end
			
			
			
		}
		catch(Exception es){
			es.printStackTrace() ;
		}
		finally {
			try{
				closeStatement( cstmt ) ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
	}

	public int chkfortaperingCount(String order_id){//Added for ML-BRU-SCF-1458 [IN:052366]
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		int taperCount = 0;
		try{
			connection		= getConnection() ;
			pstmt			= connection.prepareStatement("SELECT COUNT(ORDER_ID) TAPERCOUNT FROM OR_ORDER_LINE_PH WHERE ORDER_ID =? AND TAPERED_YN='Y'") ;
			pstmt.setString(1,order_id);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				taperCount=resultSet.getInt("TAPERCOUNT");
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
		return taperCount;
	}
	//Adding start for KDAH-SCF-0382
	public  boolean DisableNormalRxButton(){

		boolean disable_button =false;
		Connection connection       = null ;
		try{
			connection = getConnection() ;
			disable_button=eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","RX_RELEASE_DISABLE_YN");
		 }catch(Exception ex){
			System.err.println("Exception in isSiteSpecific - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				closeConnection( connection );
			}
			catch(Exception fe){
				fe.printStackTrace();
			}
		}
			return disable_button;
	}
	//Adding end for KDAH-SCF-0382
	//AAKH-CRF-0091
public boolean callingSchedule(String start_date,String time_list,String locale){
		
		boolean date = false;
		
		try{
			
			 int indx_date_time=0;
			// int indx_time=0;  Removed for IN063877
			 String start_date_only="";
			 String start_time_only="";
			 
			 
			 indx_date_time= start_date.indexOf(" ");
			 start_date_only= start_date.substring(0, indx_date_time);
			
		
			 start_time_only=start_date.substring(indx_date_time+1,start_date.length());
			 
			 
			 java.text.SimpleDateFormat date_format=new SimpleDateFormat("HH:mm");
			 java.util.Date date_1= date_format.parse(start_time_only);
			 java.util.Date date_2= date_format.parse(time_list);
		     
		     
		     date=date_1.after(date_2);
			
		
				
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return date;
	}
//added for performace ML-MMOH-SCF-0684
	public String setStockInstalledYN(){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String stock_installed		= "N";
		try{
			connection		= getConnection() ;
			pstmt			= connection.prepareStatement("SELECT COUNT(ROWID) COUNT FROM SM_MODULE WHERE MODULE_ID='ST' AND INSTALL_YN='Y'") ;
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				if(checkForNull(resultSet.getString("COUNT")).equals("1")) {
					stock_installed		=	"Y";
				 }
				 else {
					stock_installed		=	"N";
				 }
			}
			setStockInstalledYN(stock_installed);
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
		return stock_installed;
	}
//ML-BRU-SCF-1798 - start
	public String getStoreDfltBaseUOM(String store_code,String drug_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String base_uom			= "";
		try {
            connection	= getConnection() ;

			pstmt		= connection.prepareStatement("SELECT GEN_UOM_CODE FROM ST_ITEM_STORE a, mm_item b, st_item c WHERE STOCK_ITEM_YN = 'Y' AND a.STORE_CODE = ? AND a.ITEM_CODE = ? AND a.EFF_STATUS = 'E' and b.EFF_STATUS='E' and a.item_code =b.item_code and a.item_code =c.item_code") ;
			pstmt.setString(1,store_code);
			pstmt.setString(2,drug_code);
            resultSet	= pstmt.executeQuery();
			if (resultSet.next()){
				base_uom =checkForNull(resultSet.getString("GEN_UOM_CODE"));
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
		return base_uom;
	}

	public float getEqulValue (String item_code,String uom_code,String equl_uom_code){
		if(uom_code!=null && equl_uom_code!=null && uom_code.equals(equl_uom_code)){
			return 1;
		}
		else{
			Connection connection	= null;
			PreparedStatement pstmt	= null;
			ResultSet resultSet		= null;	
			float eqvl_value		= 0f;

			try {
				connection	= getConnection() ;
			  
				pstmt		= connection.prepareStatement( "select PH_calculate_equl_val(ITEM_CODE,UOM_CODE,EQVL_UOM_CODE) EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=? and EFF_STATUS = 'E' ") ;

				pstmt.setString(1,item_code);
				pstmt.setString(2,uom_code);
				pstmt.setString(3,equl_uom_code);
				resultSet	= pstmt.executeQuery() ;
				
				if (resultSet.next()){
					eqvl_value = resultSet.getFloat("EQVL_VALUE");		
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
			return eqvl_value;
		}
	}////ML-BRU-SCF-1798 -end
//added for GHL-CRF-0482 - start
	public String getPatientStockYN(String patient_id,String facility_id,String encounter_id,String drug_code,String language_id){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		PreparedStatement pstmt1    = null ;
		//PreparedStatement pstmt2    = null ;
		ResultSet resultSet         = null ;
		ResultSet resultSet1        = null ;
		//ResultSet resultSet2        = null ;
		String batch_id				= "";
		String expiry_date			= "";
		String trade_id				= "";
		String order_id				= "";
		String patient_stock_yn		= "N";
		boolean disp_alert_flag		= false;
//		boolean entry_flag			= false;
		String disp_qty             = "0";
		String tot_admin_qty		= "0";
//		String sql					= "";
//		String tot_admin_qty_for_pat_stock="0";
		String admin_qty			= "0";
		String tot_disp_qty			= "0";
		String patient_stock		= "0";
		String returnedqty			= "0";
		String tot_ret_qty			= "0";
		String disp_uom				= "";//GHL-CRF-0482
		try{ 
			connection		= getConnection() ;
			pstmt			= connection.prepareStatement("SELECT c.order_id,batch_id,TO_CHAR(EXPIRY_DATE,'DD/MM/YYYY') expiry_date,trade_id,SUM (a.disp_qty) disp_qty, sum(NVL(a.returned_qty,0)) returnedqty,DISP_QTY_UOM FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c,ph_patient_drug_profile d  WHERE a.facility_id = b.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND b.facility_id = c.facility_id  AND b.disp_no = c.disp_no AND c.patient_id=d.patient_id and c.order_id=d.orig_order_id and b.order_id=d.orig_order_id and B.ORDER_LINE_NO = D.ORIG_ORDER_LINE_NO AND c.patient_id =? AND c.facility_id = ? AND c.encounter_id = ? AND a.drug_code = ? AND ((c.PATIENT_CLASS = 'IP' AND WARD_ACKNOWLEDGE = 'A') OR c.PATIENT_CLASS = 'OP' ) AND (d.patient_stock_completed is null OR d.patient_stock_completed='N')  GROUP BY c.order_id,batch_id, expiry_date, trade_id,DISP_QTY_UOM ") ;
			//DISP_QTY_UOM added for GHL-CRF-0482
//			String drug_code_val = "";
			pstmt.setString(1,patient_id);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,encounter_id);
			pstmt.setString(4,drug_code);
			resultSet		= pstmt.executeQuery();
			while( resultSet != null && resultSet.next() ) {
				order_id	= resultSet.getString("order_id");
				batch_id	= resultSet.getString("batch_id");
				expiry_date = resultSet.getString("expiry_date");
				trade_id    = resultSet.getString("trade_id");
				disp_qty    = resultSet.getString("disp_qty")==null?"0":resultSet.getString("disp_qty");
				returnedqty = resultSet.getString("returnedqty")==null?"0":resultSet.getString("returnedqty");
				tot_ret_qty = (Float.parseFloat(tot_ret_qty) + Float.parseFloat(returnedqty) )+"";
				tot_disp_qty =  (Float.parseFloat(tot_disp_qty) + Float.parseFloat(disp_qty) )+"";
				disp_uom	 = resultSet.getString("DISP_QTY_UOM")==null?"":resultSet.getString("DISP_QTY_UOM");// GHL-CRF-0482
				if(Float.parseFloat(disp_qty)>0){
				//pstmt1			= connection.prepareStatement("SELECT   sum((CASE WHEN c.dosage_type = 'S' THEN CEIL (  ( (b.admin_dosage_qty) / d.strength_value )/ d.content_in_pres_base_uom ) ELSE CEIL (  (b.admin_dosage_qty) / d.content_in_pres_base_uom ) END ) ) tot_admin_qty FROM ph_medn_admin a, ph_medn_admin_dtl b, or_order_line_ph c, (SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom, strength_value FROM ph_drug_lang_vw WHERE language_id = ? AND drug_code = ?) d   WHERE a.encounter_id = b.encounter_id AND a.ord_drug_code = b.ord_drug_code AND a.sch_date_time = b.sch_date_time AND a.order_id = b.batch_order_id AND a.order_id = c.order_id /*AND a.dosage_seq_no = b.dosage_seq_no*/ AND a.patient_id = ? and a.encounter_id = ? AND batch_order_id = ? /*AND a.order_line_num = c.order_line_num AND a.admin_recorded_yn = 'Y' */ and batch_id = ? and expiry_date=to_date(?,'dd/mm/yyyy') AND b.item_code = ?  AND b.admin_drug_code = d.drug_code  GROUP BY batch_id, expiry_date, trade_id, b.admin_dosage_qty, c.dosage_type, d.strength_value, d.content_in_pres_base_uom") ;	

				pstmt1			= connection.prepareStatement("SELECT   SUM ((CASE WHEN (SELECT dosage_type FROM or_order_line_ph WHERE order_id = b.order_id AND ROWNUM <= 1) = 'S' THEN CEIL (  ((b.admin_dosage_qty) / d.strength_value) / d.content_in_pres_base_uom ) ELSE CEIL ((b.admin_dosage_qty) / d.content_in_pres_base_uom) END ) ) tot_admin_qty  FROM ph_medn_admin_dtl b,(SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom, strength_value FROM ph_drug_lang_vw WHERE language_id = ? AND drug_code = ?) d WHERE b.encounter_id = ? AND b.batch_order_id =? AND batch_id = ? AND expiry_date = TO_DATE (?, 'dd/mm/yyyy') AND b.item_code = ? AND b.admin_drug_code = d.drug_code GROUP BY batch_id, expiry_date, trade_id, b.admin_dosage_qty, d.strength_value, d.content_in_pres_base_uom") ;	
				
//System.err.println("PrescriptionBean_1.java=====drug_code======>"+drug_code+"==patient_id==>"+patient_id+"==encounter_id==>"+encounter_id+"==order_id==>"+order_id+"==batch_id==>"+batch_id+"==expiry_date===>"+expiry_date+"");
				pstmt1.setString(1,language_id);
				pstmt1.setString(2,drug_code);
				//pstmt1.setString(3,patient_id);
				pstmt1.setString(3,encounter_id);
				pstmt1.setString(4,order_id);
				pstmt1.setString(5,batch_id);
				pstmt1.setString(6,expiry_date);
				pstmt1.setString(7,drug_code);
				resultSet1	= pstmt1.executeQuery();
				while(resultSet1!=null && resultSet1.next()){
					admin_qty = resultSet1.getString("tot_admin_qty")==null?"0":resultSet1.getString("tot_admin_qty");
					tot_admin_qty = (Float.parseFloat(tot_admin_qty)+Float.parseFloat(admin_qty)) +"";
				}
				if(Float.parseFloat(disp_qty)>(Float.parseFloat(tot_admin_qty)-Float.parseFloat(returnedqty))){
						disp_alert_flag = true;
				}
					closeResultSet( resultSet1 ) ;
					closeStatement( pstmt1 ) ;
				}
			}
			/*sql = "SELECT SUM((CASE WHEN c.dosage_type = 'S' THEN CEIL (  ((b.admin_dosage_qty) / d.strength_value)/ d.content_in_pres_base_uom) ELSE CEIL ((b.admin_dosage_qty) / d.content_in_pres_base_uom) END ) ) tot_admin_qty FROM ph_medn_admin a, ph_medn_admin_dtl b, or_order_line_ph c, (SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom, strength_value FROM ph_drug_lang_vw WHERE language_id = ? AND drug_code = ?) d,         or_order e, ph_patient_drug_profile f WHERE a.encounter_id = b.encounter_id AND a.ord_drug_code = b.ord_drug_code AND a.sch_date_time = b.sch_date_time  AND a.order_id = b.order_id AND a.order_id = c.order_id AND a.dosage_seq_no = b.dosage_seq_no AND a.patient_id = e.patient_id AND a.patient_id = f.patient_id AND a.encounter_id = e.encounter_id AND a.encounter_id = f.encounter_id AND a.order_id = e.order_id AND a.order_id = f.orig_order_id AND e.order_id = f.orig_order_id     AND a.order_line_num = c.order_line_num AND a.order_line_num = f.orig_order_line_no  AND b.admin_drug_code = d.drug_code AND a.patient_id = ? AND a.encounter_id = ? AND a.admin_recorded_yn = 'Y' AND e.order_status = 'DF' AND f.patient_stock_yn = 'Y'  AND (patient_stock_completed is null OR patient_stock_completed='N') AND b.item_code = ? GROUP BY b.order_id, batch_id, expiry_date, trade_id, b.admin_dosage_qty, c.dosage_type,d.strength_value, d.content_in_pres_base_uom";
			if(disp_alert_flag){
				pstmt2			= connection.prepareStatement(sql);
				pstmt2.setString(1,language_id);
				pstmt2.setString(2,drug_code);
				pstmt2.setString(3,patient_id);
				pstmt2.setString(4,encounter_id);
				pstmt2.setString(5,drug_code);
				resultSet2	= pstmt2.executeQuery();
				while(resultSet2!=null && resultSet2.next()){
					admin_qty = resultSet2.getString("tot_admin_qty")==null?"0":resultSet2.getString("tot_admin_qty");
					tot_admin_qty_for_pat_stock = (Float.parseFloat(tot_admin_qty_for_pat_stock)+Float.parseFloat(admin_qty)) +"";
				}
				tot_admin_qty  = (Float.parseFloat(tot_admin_qty_for_pat_stock)+Float.parseFloat(tot_admin_qty) )+"";
			} */
			if(Float.parseFloat(tot_disp_qty)>0 && Float.parseFloat(tot_admin_qty)==0){
				disp_alert_flag = true;
			}
			 patient_stock = (Float.parseFloat(tot_disp_qty) - Float.parseFloat(tot_admin_qty) - Float.parseFloat(tot_ret_qty) )+"";
			if(disp_alert_flag)
				patient_stock_yn = "Y";
			else
				patient_stock_yn = "N";
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return patient_stock_yn+"~"+patient_stock+"~"+disp_uom; // GHL-CRF-0482
	}//added for GHL-CRF-0482 - end
//ARYU-CRF-014 - start
	public ArrayList getAdminScheduleTime(String freq_code){
	
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
//		String stock_installed		= "N";
		ArrayList addScheduleTime = new ArrayList();
		try{
			connection		= getConnection() ;
			pstmt			= connection.prepareStatement("SELECT   TO_CHAR (admin_time, 'HH24:MI') admin_time FROM am_frequency_admin_day_time WHERE freq_code = ? AND admin_facility_id = NVL ((SELECT admin_facility_id FROM am_frequency_admin_day_time WHERE freq_code = ? AND admin_facility_id = ? and ROWNUM<=1), '*A') ORDER BY admin_time") ;
			
			pstmt.setString(1,freq_code);
			pstmt.setString(2,freq_code);
			pstmt.setString(3,login_facility_id);

			resultSet		= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())	{
				addScheduleTime.add(resultSet.getString("admin_time"));
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
		return addScheduleTime;

	}
	//ARYU-CRF-014 - end
//GHL-CRF-0549 - start
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
	//added for mms-kh-crf-0016 start
	
	public int getPreviousdrugData(String facility_id,String act_patient_class,String bed_num,String room_num,String patient_id,String encounter_id,String location_type,String location_code,int medication_rec,String patient_class){
		String sql="";
		int count=0;
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;		 
		String recn_done_yn = "N";
		
			try {
			connection			= getConnection();
			if(act_patient_class.equals("IP")&& medication_rec>0){				
				sql="select count(*) from PH_PATIENT_DRUG_PROFILE where facility_id=? and patient_id=? and encounter_id=? and locn_type=? and locn_code=? and PATIENT_CLASS='OP'";			
				pstmt				= connection.prepareStatement(sql);			
				pstmt.setString(1, facility_id);
				pstmt.setString(2, patient_id);
				pstmt.setString(3, encounter_id);
				pstmt.setString(4, location_type);
				pstmt.setString(5, location_code);
		
				
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					count=resultSet.getInt(1);
				}

			}else if(act_patient_class.equals("IP")){
				sql="select nvl(recn_done_yn,'N') recn_done_yn from PH_PATIENT_EXTR_DRUG_CTRLS where patient_id=? and encounter_id=? and facility_id=?";			
				pstmt				= connection.prepareStatement(sql);				
				pstmt.setString(1, patient_id);
				pstmt.setString(2, encounter_id);
				pstmt.setString(3, facility_id);
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					recn_done_yn=resultSet.getString("recn_done_yn");
				}
				if("Y".equals(recn_done_yn))//MMS-DM-SCF-0732   
					count = 0;
			
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
		//setReconciliationapp_yn(count);
		return count;
	}
	//added for mms-kh-crf-0016 end
	
	public HashMap getMRPreviousOrders(String patient_class,String pract_id,String patient_id,String ord_status,String ord_frm,String ord_to,String from,String to, String drug_desc,String group_by, String drug_priv_appln_yn,String p_resp_id, String log_pract_id){ // Added for MMS-KH-CRF-0016 - Start
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ResultSet resultSet_meta	=	null;

		String append_str			= "";
		HashMap total_result		= new HashMap();
		ArrayList result			= new ArrayList();
		//String prevnextlink			= ""; //Commented for common-icn-0048
		int query_result_size		= 10;
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;
		String start_date="";
		String end_date="", ord_date="";
		ArrayList curr_alphabets	= new ArrayList();
		locale= getLanguageId()==null?"en":getLanguageId();
		if(drug_desc==null || drug_desc.equals(""))
			drug_desc = "%";
		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
		
		try {
			connection = getConnection() ;
			if(patient_class.equals("B")) 
				append_str	= " AND A.PATIENT_CLASS IN ('IP','OP','EM','XT') ";
			else 
				append_str	= " AND A.PATIENT_CLASS='"+patient_class.trim()+"' ";	

			if(ord_status.equals("A")) 
				append_str	=append_str+ " AND B.ORDER_LINE_STATUS IN ('DF','CN','DC','DP','OS','AL','IP','VF','RG','UC','DD','DE') "; //added 'UC' for Incident No:033118
			else if(ord_status.equals("AL"))
				append_str	= append_str+ " AND B.ORDER_LINE_STATUS IN ('AL','IP') ";
			else if(ord_status.equals("OS"))
				append_str	= append_str+" AND B.ORDER_LINE_STATUS IN ('OS','VF','RG') ";
			else  
				append_str	= append_str+ " AND B.ORDER_LINE_STATUS='"+ord_status.trim()+"' ";

			//if(!pract_id.equals("")) //COMMENTED FOR MMS-KH-CRF-0016.1
			//	append_str	= append_str +" AND A.ORD_PRACT_ID=?";//COMMENTED FOR MMS-KH-CRF-0016.1

			if(!patient_id.equals("")) 
				append_str	=  append_str+" AND A.PATIENT_ID=?"; 
			int bindCount=0;
			//h.content_in_pres_base_uom,c.freq_nature,i.dosage_type added for IN070786
				String repQryStr = "SELECT j.strength,a.iv_prep_yn, b.order_id, b.order_line_num, b.order_catalog_code, h.drug_desc catalog_desc, b.qty_value, b.qty_unit, b.freq_code, DECODE (j.split_yn, 'Y', c.freq_desc || ' (Divided)', c.freq_desc ) freq_desc, b.durn_value, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY hh24:mi') ord_date_time, b.durn_type, e.durn_desc, TO_CHAR (b.start_date_time, 'DD/MM/YYYY hh24:mi') start_date, TO_CHAR (b.end_date_time, 'DD/MM/YYYY hh24:mi') end_date, a.source_code, k.practitioner_name ord_pract_id, DECODE (a.source_type, 'N', f.long_desc, g.long_desc) LOCATION1, DECODE (a.source_type, 'N', ip_get_desc.ip_nursing_unit (j.orig_facility_id, a.orig_source_code, h.language_id, '1'), op_get_desc.op_clinic (j.orig_facility_id, j.locn_code,h.language_id,'1')) LOCATION, b.order_line_status, h.discontinued_yn, i.sliding_scale_yn, or_get_priv_appl_yn (?, ?, 'OR', h.drug_code, ?, b.order_type_code, 'PH' ) priv_appl_yn, h.appl_to_verbal_order_yn, j.tot_administered_qty admin_qty, j.tot_issued_qty disp_qty, b.order_qty, b.order_uom, a.ordering_facility_id, l.order_status_type, j.dosage_uom_code,j.generic_id,h.content_in_pres_base_uom,c.freq_nature,i.dosage_type FROM or_order a, or_order_line b, am_frequency_lang_vw c, am_duration_type_lang_vw e, ip_nursing_unit_lang_vw f, op_clinic_lang_vw g, ph_drug_lang_vw h, or_order_line_ph i, ph_patient_drug_profile j, am_practitioner_lang_vw k, or_order_status_code_lang_vw l WHERE a.order_id = b.order_id AND i.order_id = b.order_id AND i.order_line_num = b.order_line_num AND i.order_id = j.orig_order_id AND i.order_line_num = j.orig_order_line_no AND c.freq_code = b.freq_code AND e.durn_type = b.durn_type AND f.nursing_unit_code(+) = a.source_code AND g.clinic_code(+) = a.source_code AND h.drug_code = b.order_catalog_code AND a.ordering_facility_id = f.facility_id(+) AND a.ordering_facility_id = g.facility_id(+) AND a.ord_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY') + 0.99999 AND a.order_category = 'PH' AND c.language_id = e.language_id AND c.language_id = l.language_id AND c.language_id = ? AND f.language_id(+) = ? AND g.language_id(+) = ? AND h.drug_yn = 'Y' AND h.language_id(+) = ? AND k.practitioner_id = a.ord_pract_id AND k.language_id(+) = ? AND l.language_id(+) = ? AND b.order_line_status = l.order_status_code"; //Location modified for SKR-SCF-1394
			
				pstmt	   = connection.prepareStatement( repQryStr+append_str+" ORDER BY a.ord_date_time desc, B.ORDER_ID , B.ORDER_LINE_NUM, B.CATALOG_DESC") ;
				pstmt.setString(++bindCount,log_pract_id);
				pstmt.setString(++bindCount,p_resp_id);
				pstmt.setString(++bindCount,drug_priv_appln_yn);
				pstmt.setString(++bindCount,ord_frm);
				pstmt.setString(++bindCount,ord_to);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);
				pstmt.setString(++bindCount,locale);//10
				
		//	if(!pract_id.equals("")) //COMMENTED FOR MMS-KH-CRF-0016.1
		//		pstmt.setString(++bindCount,pract_id.trim());//COMMENTED FOR MMS-KH-CRF-0016.1
			if(!patient_id.equals("")) 
				pstmt.setString(++bindCount,patient_id.trim());
			resultSet = pstmt.executeQuery();
			while ( resultSet != null && resultSet.next()) {
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
					count++ ;
					result.add((String)resultSet.getString("ORDER_LINE_STATUS"));//0
					result.add((String)resultSet.getString("ORDER_ID"));//1
					result.add((String)resultSet.getString("ORDER_LINE_NUM"));//2
					result.add((String)resultSet.getString("ORDER_CATALOG_CODE"));//3
					result.add((String)resultSet.getString("CATALOG_DESC"));//4
					result.add((String)resultSet.getString("QTY_VALUE"));//5
					result.add((String)resultSet.getString("QTY_UNIT"));//6
					result.add((String)resultSet.getString("FREQ_CODE"));//7
					result.add((String)resultSet.getString("FREQ_DESC"));//8
					result.add((String)resultSet.getString("DURN_VALUE"));//9
					result.add((String)resultSet.getString("DURN_TYPE"));//10
					result.add((String)resultSet.getString("DURN_DESC"));//11
					start_date= (String)resultSet.getString("START_DATE");
					end_date= (String)resultSet.getString("END_DATE");
					if(!locale.equals("en")){
						start_date = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM","en",locale);
						end_date = com.ehis.util.DateUtils.convertDate(end_date, "DMYHM","en",locale);
					}
					result.add(start_date);//12
					result.add(end_date);//13
					result.add((String)resultSet.getString("SOURCE_CODE"));//14
					result.add((String)resultSet.getString("ORD_PRACT_ID"));//15
					result.add((String)resultSet.getString("LOCATION"));//16
					result.add((String)resultSet.getString("IV_PREP_YN"));//17

					if(group_by.equals("PR")) {
						ord_date = (String)resultSet.getString("ORD_DATE_TIME");
						if(!locale.equals("en")){
							ord_date = com.ehis.util.DateUtils.convertDate(ord_date, "DMYHM","en",locale);
						}
						result.add(ord_date);//18
					
					}

					result.add((String)resultSet.getString("DISCONTINUED_YN"));//19
					result.add((String)resultSet.getString("SLIDING_SCALE_YN"));//20
					result.add((String)resultSet.getString("PRIV_APPL_YN"));//21
                    result.add(checkForNull((String)resultSet.getString("APPL_TO_VERBAL_ORDER_YN")));//22
                    result.add(checkForNull((String)resultSet.getString("ADMIN_QTY")));//23
                    result.add(checkForNull((String)resultSet.getString("DISP_QTY"))); //24
                    result.add(checkForNull((String)resultSet.getString("ORDER_QTY")));//25
                    result.add(checkForNull((String)resultSet.getString("ORDER_UOM")));//26
                    result.add(checkForNull((String)resultSet.getString("ORDERING_FACILITY_ID")));//27
                    result.add(checkForNull((String)resultSet.getString("ORDER_STATUS_TYPE")));//28
                    result.add(checkForNull((String)resultSet.getString("DOSAGE_UOM_CODE")));//29
                    result.add(checkForNull((String)resultSet.getString("GENERIC_ID")));//30                    

					if(!curr_alphabets.contains((resultSet.getString("CATALOG_DESC")).substring(0,1)))
					   curr_alphabets.add( (resultSet.getString("CATALOG_DESC")).substring(0,1) );
					result.add(checkForNull((String)resultSet.getString("CONTENT_IN_PRES_BASE_UOM")));//31 
					result.add(checkForNull((String)resultSet.getString("FREQ_NATURE")));//32  
					result.add(checkForNull((String)resultSet.getString("DOSAGE_TYPE")));//33  
					result.add(checkForNull((String)resultSet.getString("STRENGTH")));//33  
					
			}
			all_drugs	=	new ArrayList();
			boolean taper_dup = false;
			String ord_id ="";
			String ord_cat_code = "";
			String ord_id1 ="";
			String ord_cat_code1 = "";
			resultSet_meta	= pstmt.executeQuery() ;
			while( resultSet_meta != null && resultSet_meta.next() ) {
				taper_dup = false;
				for(int indx=0; indx<all_drugs.size(); indx+=2){
					ord_id = (String)all_drugs.get(indx);
					ord_id = ord_id.substring(0, ord_id.indexOf(','));
					ord_cat_code = (String)all_drugs.get(indx+1);
					ord_id1 = (String)resultSet_meta.getString("ORDER_ID");
					ord_cat_code1 =  (String)resultSet_meta.getString("ORDER_CATALOG_CODE");
					if(ord_id.equals(ord_id1) && ord_cat_code.equals(ord_cat_code1)){
						taper_dup = true;
						break;
					}
				}
				if(!taper_dup){
					all_drugs.add((String)resultSet_meta.getString("ORDER_ID")+","+((String)resultSet_meta.getString("ORDER_LINE_NUM")));
					all_drugs.add((String)resultSet_meta.getString("ORDER_CATALOG_CODE"));
				}
			}
			total_result.put("RESULT",result);
		}
		catch ( Exception e ) {				
			e.printStackTrace() ;
		 }
		 finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet_meta ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return total_result;
	} // Added for MMS-KH-CRF-0016 - End
		//added for SKR-SCF-1239 - start
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
					return curr_locn;
		}
	}
		//added for SKR-SCF-1239 - end
//added for IN070786 START

public void updateExternalDrugStatuesFromRecn(String patient_id,String encounter_id,String chk_status,String no_extrnal_drug){
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSetChk				 = null ;
	ResultSet resultSet		= null;
	//String curr_locn		= ""; //Commented for common-icn-0048
	String updateSql="";
	String insertSql="";
	PreparedStatement pstmt1 = null;

	try {
		connection			= getConnection();
		pstmt				= connection.prepareStatement("SELECT COUNT (*)FROM PH_PATIENT_EXTR_DRUG_CTRLS WHERE patient_id = ? AND encounter_id = ? AND facility_id=?");
		pstmt.setString(1, patient_id);
		pstmt.setString(2, encounter_id);
		pstmt.setString(3, login_facility_id);
		int rec_count=0;
		resultSetChk			= pstmt.executeQuery();
		if(resultSetChk!=null && resultSetChk.next()){
			rec_count=resultSetChk.getInt(1);
		}
		closeResultSet( resultSetChk ) ;
		closeStatement( pstmt ) ;
		if(rec_count>0){
			updateSql="UPDATE PH_PATIENT_EXTR_DRUG_CTRLS SET RECN_DONE_YN = ? ,OLD_RECN_DONE_YN = ? ,NO_EXTRNAL_DRUG = ?,modified_by_id = ?,modified_date = SYSDATE,modified_at_ws_no = ?,modified_facility_id = ? WHERE patient_id = ? AND encounter_id = ? AND facility_id=?";
			pstmt1				= connection.prepareStatement(updateSql);
			if(rec_count>0){//added for MMS-DM-SCF-0732 
				chk_status="Y"; 
			}//END
			pstmt1.setString(1, chk_status);
			pstmt1.setString(2, chk_status);
			pstmt1.setString(3, no_extrnal_drug);
			pstmt1.setString(4, login_by_id);		
			pstmt1.setString(5, login_at_ws_no);				
			pstmt1.setString(6, login_facility_id);	
			pstmt1.setString(7, patient_id);
			pstmt1.setString(8, encounter_id);
			pstmt1.setString(9, login_facility_id);	
			pstmt1.executeUpdate();
			connection.commit();
		}
		else{
			insertSql="INSERT INTO PH_PATIENT_EXTR_DRUG_CTRLS (patient_id, encounter_id,RECN_DONE_YN,OLD_RECN_DONE_YN,NO_EXTRNAL_DRUG,facility_id, added_by_id, added_date,added_at_ws_no, added_facility_id, modified_by_id,modified_date, modified_at_ws_no, modified_facility_id)VALUES (?,?,?,?,?, ?,?, SYSDATE, ?,?, ?, SYSDATE,?, ?)";
			pstmt1				= connection.prepareStatement(insertSql);
			pstmt1.setString(1, patient_id);
			pstmt1.setString(2, encounter_id);
			pstmt1.setString(3, chk_status);
			pstmt1.setString(4, chk_status);
			pstmt1.setString(5, no_extrnal_drug);
			pstmt1.setString(6, login_facility_id);
			pstmt1.setString(7, login_by_id);		
			pstmt1.setString(8, login_at_ws_no);				
			pstmt1.setString(9, login_facility_id);	
			pstmt1.setString(10, login_by_id);					
			pstmt1.setString(11, login_at_ws_no);
			pstmt1.setString(12, login_facility_id);
			pstmt1.executeUpdate();
			connection.commit();
		}
		 
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	    finally {
		try {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeStatement(pstmt1);
			closeConnection(connection);
		}
		catch(Exception es){ 
			es.printStackTrace();
		}
				
	}	
}
public void updateExternalDrugStatues(String patient_id,String encounter_id,String chk_status,String no_extrnal_drug){

	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSetChk				 = null ;
	ResultSet resultSet		= null;
	//String curr_locn		= ""; //Commented for common-icn-0048
	String updateSql="";
	String insertSql="";
	PreparedStatement pstmt1 = null;

	try {
		connection			= getConnection();
		pstmt				= connection.prepareStatement("SELECT COUNT (*)FROM PH_PATIENT_EXTR_DRUG_CTRLS WHERE patient_id = ? AND encounter_id = ? AND facility_id=?");
		pstmt.setString(1, patient_id);
		pstmt.setString(2, encounter_id);
		pstmt.setString(3, login_facility_id);
		int rec_count=0;
		resultSetChk			= pstmt.executeQuery();
		if(resultSetChk!=null && resultSetChk.next()){
			rec_count=resultSetChk.getInt(1);
		}
		closeResultSet( resultSetChk ) ;
		closeStatement( pstmt ) ;
		if(rec_count>0){
			updateSql="UPDATE PH_PATIENT_EXTR_DRUG_CTRLS SET NO_EXTRNAL_DRUG = ?,modified_by_id = ?,modified_date = SYSDATE,modified_at_ws_no = ?,modified_facility_id = ? WHERE patient_id = ? AND encounter_id = ? AND facility_id=?";
			pstmt1				= connection.prepareStatement(updateSql);
			pstmt1.setString(1, chk_status);
			pstmt1.setString(2, login_by_id);		
			pstmt1.setString(3, login_at_ws_no);				
			pstmt1.setString(4, login_facility_id);	
			pstmt1.setString(5, patient_id);
			pstmt1.setString(6, encounter_id);
			pstmt1.setString(7, login_facility_id);	
			pstmt1.execute();
			connection.commit();
		}
		else{
			insertSql="INSERT INTO PH_PATIENT_EXTR_DRUG_CTRLS (patient_id, encounter_id, NO_EXTRNAL_DRUG,facility_id, added_by_id, added_date,added_at_ws_no, added_facility_id, modified_by_id,modified_date, modified_at_ws_no, modified_facility_id)VALUES (?,?, ?, ?,?, SYSDATE, ?,?, ?, SYSDATE,?, ?)";
			pstmt1				= connection.prepareStatement(insertSql);
			pstmt1.setString(1, patient_id);
			pstmt1.setString(2, encounter_id);
			pstmt1.setString(3, chk_status);
			pstmt1.setString(4, login_facility_id);
			pstmt1.setString(5, login_by_id);		
			pstmt1.setString(6, login_at_ws_no);				
			pstmt1.setString(7, login_facility_id);	
			pstmt1.setString(8, login_by_id);					
			pstmt1.setString(9, login_at_ws_no);
			pstmt1.setString(10, login_facility_id);
			pstmt1.executeQuery();
			connection.commit();
		}
		 
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	    finally {
		try {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeStatement(pstmt1);
			closeConnection(connection);
		}
		catch(Exception es){ 
			es.printStackTrace();
		}
				
	}
}


public String extDrugApplicableYN(String patient_id,String encounter_id){
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	String no_extrnal_drug		= "";
try{
	connection			= getConnection();
	pstmt				= connection.prepareStatement("SELECT NO_EXTRNAL_DRUG FROM PH_PATIENT_EXTR_DRUG_CTRLS WHERE patient_id = ? AND encounter_id = ? AND facility_id= ?");
	pstmt.setString(1, patient_id);
	pstmt.setString(2, encounter_id);
	pstmt.setString(3,login_facility_id);
	resultSet	= pstmt.executeQuery();
	if (resultSet != null && resultSet.next()) {
		no_extrnal_drug = resultSet.getString("NO_EXTRNAL_DRUG")==null?"":resultSet.getString("NO_EXTRNAL_DRUG");
		 			 
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
	return no_extrnal_drug;
}


public String reconciliationDoneyn(String patient_id,String encounter_id){
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	String no_extrnal_drug		= "";
try{
	connection			= getConnection();
	pstmt				= connection.prepareStatement("SELECT RECN_DONE_YN FROM PH_PATIENT_EXTR_DRUG_CTRLS WHERE patient_id = ? AND encounter_id = ? AND facility_id= ?");
	pstmt.setString(1, patient_id);
	pstmt.setString(2, encounter_id);
	pstmt.setString(3,login_facility_id);
	resultSet	= pstmt.executeQuery();
	if (resultSet != null && resultSet.next()) {
		no_extrnal_drug = resultSet.getString("RECN_DONE_YN")==null?"":resultSet.getString("RECN_DONE_YN");
		 			 
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
	return no_extrnal_drug;
}
//ADDED FOR IN070786 END

//added for IN071763  
public String getExtDispYN(String store_code)
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
		if(ext_disp_appl_yn==null)
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
}//added for IN071763 
 //added for TBMC-SCF-0167
public String getFreqDurnType(String freq_code){

	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	String freq_durn_type="";
	try {
		connection			= getConnection();
	
	pstmt = connection.prepareStatement("select REPEAT_DURN_TYPE from am_frequency where freq_code=?");
	pstmt.setString(1,freq_code);


	resultSet = pstmt.executeQuery() ;
						
	if(resultSet!=null && resultSet.next()){					
 		freq_durn_type = resultSet.getString("REPEAT_DURN_TYPE");	
		if(freq_durn_type==null)
			freq_durn_type="";
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
	return freq_durn_type;
}
//GHL-CRF-0618 - start
	public ArrayList getNotPreferenceItemRemarks(){
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		ArrayList arr = new ArrayList();
		//String ext_disp_appl_yn="";
		locale= getLanguageId()==null?"en":getLanguageId();
		try {
			connection			= getConnection();
			pstmt = connection.prepareStatement("SELECT   REASON_CODE, REASON_DESC FROM PH_MEDN_TRN_REASON_LANG_VW PH_MEDN_TRN_REASON WHERE APPL_TRN_TYPE='NP' AND EFF_STATUS  = 'E' AND LANGUAGE_ID = ?");
			pstmt.setString(1,locale);
			resultSet = pstmt.executeQuery() ;
							
			while(resultSet!=null && resultSet.next()){					
				arr.add(resultSet.getString("REASON_CODE"));	
				arr.add(resultSet.getString("REASON_DESC"));
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

		return arr;

	}

	public String getUserName(String user_id){

		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String user_name="";
		locale= getLanguageId()==null?"en":getLanguageId();
		try {
			connection			= getConnection();
			pstmt = connection.prepareStatement("SELECT APPL_USER_NAME,APP_PASSWORD.DECRYPT(PIN_NO) PIN_NO  FROM SM_APPL_USER_LANG_VW SM_APPL_USER WHERE APPL_user_id =? AND LANGUAGE_ID = ?");
			pstmt.setString(1,user_id);
			pstmt.setString(2,locale);
			resultSet = pstmt.executeQuery() ;
							
			if(resultSet!=null && resultSet.next()){					
				user_name = resultSet.getString("APPL_USER_NAME");
			}
		}catch(Exception e) {
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

		return user_name;
	}
	//GHL-CRF-0618 - end
//Added for IN:072715 START
public String getOverrideRemarks(String trn_type, String reason_code){
	String remarks="";
	if(trn_type.equals("BD")){
		if(dose_remarks.containsKey(reason_code))
			remarks=(String) dose_remarks.get(reason_code);
		else{
			setOverRideRemarks(trn_type);
			remarks=(String) dose_remarks.get(reason_code);
		}
			
	}
	else if(trn_type.equals("AO")){
		if(allergy_remarks.containsKey(reason_code))
			remarks=(String) allergy_remarks.get(reason_code);
		else{
			setOverRideRemarks(trn_type);
			remarks=(String) allergy_remarks.get(reason_code);
		}
	}
	else if(trn_type.equals("DP")){
		if(dup_drug_remarks.containsKey(reason_code))
			remarks=(String) dup_drug_remarks.get(reason_code);
		else{
			setOverRideRemarks(trn_type);
			remarks=(String) dup_drug_remarks.get(reason_code);
		}
	} 
	else if(trn_type.equals("DD")){
		if(drug_inter_remarks.containsKey(reason_code))
			remarks=(String) drug_inter_remarks.get(reason_code);
		else{
			setOverRideRemarks(trn_type);
			remarks=(String) drug_inter_remarks.get(reason_code);
		}
	}
	else if(trn_type.equals("DF")){
		if(food_inter_remarks.containsKey(reason_code))
			remarks=(String) food_inter_remarks.get(reason_code);
		else{
			setOverRideRemarks(trn_type);
			remarks=(String) food_inter_remarks.get(reason_code);
		}
	}
	else if(trn_type.equals("DL")){
		if(lab_inter_remarks.containsKey(reason_code))
			remarks=(String) lab_inter_remarks.get(reason_code);
		else{
			setOverRideRemarks(trn_type);
			remarks=(String) lab_inter_remarks.get(reason_code);
		}
	}else if(trn_type.equals("DI")){//Added for MMS-DM-CRF-0229
		if(disease_inter_remarks.containsKey(reason_code))
			remarks=(String) disease_inter_remarks.get(reason_code);
		else{
			setOverRideRemarks(trn_type);
			remarks=(String) disease_inter_remarks.get(reason_code);
		}
	}
	return remarks;
}

public void setOverRideRemarks(String trn_type){
	
	String temp_code="";
	String temp_remarks="";
	
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	//String ext_disp_appl_yn=""; //Commented for common-icn-0048
	try {
		connection			= getConnection();
	
	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("PH_OVERRIDE_REMARKS") );
	pstmt.setString(1,trn_type);
	resultSet = pstmt.executeQuery() ;
						
	while(resultSet!=null && resultSet.next()){					
		
		 temp_code = resultSet.getString("REASON_CODE");
		 temp_remarks = resultSet.getString("REMARKS");
		if(trn_type.equals("BD"))
			this.dose_remarks.put(temp_code, temp_remarks);
		if(trn_type.equals("AO"))
			this.allergy_remarks.put(temp_code, temp_remarks);
		if(trn_type.equals("DP"))
			this.dup_drug_remarks.put(temp_code, temp_remarks);
		if(trn_type.equals("DD"))
			this.drug_inter_remarks.put(temp_code, temp_remarks);
		if(trn_type.equals("DF"))
			this.food_inter_remarks.put(temp_code, temp_remarks);
		if(trn_type.equals("DL"))
			this.lab_inter_remarks.put(temp_code, temp_remarks);
		if(trn_type.equals("DI"))//Added for MMS-DM-CRF-0229
			this.disease_inter_remarks.put(temp_code, temp_remarks);
		
		
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
	
	
	
}
//Added for IN:072715 END
//added for MMs-KH-CRF-0034.4
public String getLabTestResult(String order_id,String order_line_no,String drug_code,String lab_code)
{
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	String lab_test_result="";
	try {
		connection			= getConnection();
	
	pstmt = connection.prepareStatement( "SELECT lab_test_result FROM or_order_drug_interaction WHERE ordering_module_id = 'PH' AND order_id = ? AND order_line_num = ? AND order_catalog_code = ? AND drug_interaction_code = ?");
	pstmt.setString(1,order_id);
	pstmt.setString(2,order_line_no);
	pstmt.setString(3,lab_code);
	pstmt.setString(4,drug_code);

	resultSet = pstmt.executeQuery() ;
						
	if(resultSet!=null && resultSet.next()){					
		
		lab_test_result = resultSet.getString("lab_test_result");	
		if(lab_test_result==null)
			lab_test_result="";
		
		
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

	return lab_test_result;
}
//added for NMC-JD-CRF-0063
public String getOPDisMedLocation()
{
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	String opDisMedLocn="";
	try {
		connection			= getConnection();
	
	pstmt = connection.prepareStatement( "select OP_DISCH_MED_DISP_LOCN from PH_FACILITY_PARAM WHERE FACILITY_ID=? ");
	pstmt.setString(1,login_facility_id);
	
	resultSet = pstmt.executeQuery() ;
						
	if(resultSet!=null && resultSet.next()){					
		
		opDisMedLocn = resultSet.getString("OP_DISCH_MED_DISP_LOCN");	
		if(opDisMedLocn==null)
			opDisMedLocn="";
		
		
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

	return opDisMedLocn;
}

		//ADDED FOR NMC-JD-CRF-0063		
		public String getStoreDesc(String store_code){
			
			Connection connection	= null;
			PreparedStatement pstmt = null;
			ResultSet resultSet		= null;
			String store_desc="";
			
			try {
				connection			= getConnection();
			
			pstmt = connection.prepareStatement("select SHORT_DESC from ph_disp_locn where DISP_LOCN_CODE=? and facility_id=?");

			pstmt.setString(1,store_code);
			pstmt.setString(2,login_facility_id);
			resultSet = pstmt.executeQuery() ;
								
			if(resultSet!=null && resultSet.next()){					
				
				store_desc = resultSet.getString("SHORT_DESC");	
				if(store_desc==null)
					store_desc="";
				
				
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
			return store_desc;
		}
		//NMC-JD-CRF-0063 [15131]
		public String getPrEncounterPatientClass(String patient_id, String encounter_id)
		{ 
			Connection connection	= null;
			PreparedStatement pstmt = null;
			ResultSet resultSet		= null;
			String actual_patient_class="";
			try {
				connection			= getConnection();
			
			pstmt = connection.prepareStatement( "SELECT DECODE(PATIENT_CLASS, 'IP','I','DC','D','OP','O','EM','E','XT','R') ENC_PATIENT_CLASS FROM PR_ENCOUNTER WHERE PATIENT_ID=? AND ENCOUNTER_ID = ? ");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,encounter_id); 
			
			resultSet = pstmt.executeQuery() ;
								
			if(resultSet!=null && resultSet.next()){					
				
				actual_patient_class = resultSet.getString("ENC_PATIENT_CLASS");	
				if(actual_patient_class==null)
					actual_patient_class="";
				
				
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

			return actual_patient_class;
		}//END
		
		//Added for TFS-16341-Start
		
		public void defaultDispLocnSelectAppl(){
			Connection connection = null ;
			PreparedStatement pstmt = null;
			ResultSet resultSet		= null;
			String pre_alloc="";
			boolean default_disp_locn_select_appl		=false;
			try {
				connection = getConnection() ;
				default_disp_locn_select_appl = eCommon.Common.CommonBean.isSiteSpecific(connection,"PH","PH_DISP_LOCN_SELECT_APPL");
				pstmt = connection.prepareStatement("SELECT PRE_ALLOC_APPL FROM PH_FACILITY_PARAM WHERE facility_id = ? ");
				pstmt.setString(1,login_facility_id);
				resultSet = pstmt.executeQuery() ;
				
				if(resultSet!=null && resultSet.next()){					
					pre_alloc = resultSet.getString("PRE_ALLOC_APPL");	
					if(pre_alloc==null)
						pre_alloc="N";
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try{
					
					closeConnection( connection );
				}catch(Exception es){
					es.printStackTrace();
				}
			}
			if(default_disp_locn_select_appl && pre_alloc.equals("Y")){
				default_disp_locn_select_appl = true;
				setDefaultDispLocnSelectAppl(default_disp_locn_select_appl);
			}
			else
			{
				default_disp_locn_select_appl = false;
				setDefaultDispLocnSelectAppl(default_disp_locn_select_appl);
			}
		}
		//Added for TFS id:-16341 end
		//added for aakh-crf-0140 start

		public HashMap getabusedetails(String patient_id,String drug_code,String drug_class){//finding the Height/Weight/uom Values
			Connection connection       = null ;
			PreparedStatement pstmt     = null ;
			ResultSet resultSet         = null ;
			String sql_query			= "";
			HashMap aduseDetails	= new HashMap(); 
			
		//	int		i	=	0;
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
						System.out.println("22799aduseDetails"+aduseDetails);
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
							System.out.println("22817aduseDetails"+aduseDetails);
							
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

		public String getDrugInstructions(String order_id,String order_line_no){
			Connection connection			= null ;
			PreparedStatement pstmt			= null ;
			ResultSet resultSet				= null ;
			String drug_instructions		= "";
			String temp_drugremark_desc		= "";
			String temp_drugremark_Label    = "";
			PreparedStatement pstmt1		= null ;
			ResultSet resultSet1			= null ;

			try{
				connection = getConnection() ;
				pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_REMARKS3")) ;
				pstmt1			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_REMARKS4")) ;	
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_no);
				resultSet			= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					if(resultSet.getString("ORDER_LINE_FIELD_VALUE")!= null){
						temp_drugremark_desc = (resultSet.getString("ORDER_LINE_FIELD_VALUE"));
						temp_drugremark_Label= (resultSet.getString("ORDER_LINE_LABEL_TEXT"));
						pstmt1.setString(1,temp_drugremark_desc);
						pstmt1.setString(2,getLanguageId());
						resultSet1	= pstmt1.executeQuery();
						while(resultSet1!=null && resultSet1.next()){
							if(resultSet1.getString("REMARK_DESC")!= null)
								temp_drugremark_desc = checkForNull(resultSet1.getString("REMARK_DESC"));
						}
						closeResultSet(resultSet1);
						drug_instructions = drug_instructions + (temp_drugremark_Label +" : "+ temp_drugremark_desc+"\n");
					}
				}
			}
			catch ( Exception e ) {
				e.printStackTrace() ;
			} 
			finally {
				try{
					closeResultSet( resultSet1 ) ;
					closeResultSet( resultSet ) ;
					closeStatement( pstmt1 ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
			}
			return drug_instructions;
		}
		public String getSlidingScaleRemarks(String order_id,String order_line_no){
			Connection connection			= null ;
			PreparedStatement pstmt			= null ;
			ResultSet resultSet				= null ;
			String sliding_scale_remarks	= "";
			
			try{
				connection = getConnection() ;

				pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_REMARKS5")) ;
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_no);
				resultSet		= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					sliding_scale_remarks=  checkForNull(resultSet.getString("SLIDING_SCALE_REMARKS"));		
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
			return sliding_scale_remarks;
		}
		// ML-MMOH-CRF-1823 US008- 43528  START
		public ArrayList getQuotaLimitValue( String drugId, String specialityCd) {
			 Connection connection    = null;
			 PreparedStatement pstmt = null;
			 ResultSet resultSet        = null;
			 ArrayList quotaLimitDtls = new ArrayList();
			  try {
				  		connection            = getConnection();
				  		pstmt = connection.prepareStatement("SELECT SET_LIMIT_BY, QUOTA_LIMIT,QUOTA_CURR_VALUE FROM PH_DRUG_QUOTA_LIMIT WHERE DRUG_CODE=? AND SPECIALITY_CODE=? ");
				  		pstmt.setString(1,drugId);
				  		pstmt.setString(2,specialityCd);
				  		//pstmt.setString(3,setLimitByType);
				  		//pstmt.setString(4,facilityId);
				  		resultSet = pstmt.executeQuery() ;
						 
				  		if(resultSet!=null && resultSet.next()){                   
				  			quotaLimitDtls.add(resultSet.getString("SET_LIMIT_BY"));
				  			quotaLimitDtls.add(resultSet.getString("QUOTA_LIMIT"));
							quotaLimitDtls.add(resultSet.getString("QUOTA_CURR_VALUE"));
						 }
			} catch(Exception e) {
			  e.printStackTrace();
			} finally {
				  try {
				      closeResultSet(resultSet);
				      closeStatement(pstmt);
				      closeConnection(connection);
				  }
				  catch(Exception es){
				      es.printStackTrace();
				  }
			 }   
			//  System.out.println("quotaLimitDtls..................."+quotaLimitDtls);
			return quotaLimitDtls;
		}
		
			public String getSpecialtyCode(String pract_id) throws Exception{	
	        Connection connection			= null ;
	        PreparedStatement pstmt			= null ;
	        ResultSet resultSet				= null;
			 pat_specialty_code             = "";

			try{
				connection = getConnection() ; 
				pstmt			= connection.prepareStatement("select PRIMARY_SPECIALITY_CODE from am_practitioner where  PRACTITIONER_ID =?") ;
				pstmt.setString(1,pract_id);
				
				resultSet		= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()) {
					pat_specialty_code = resultSet.getString("PRIMARY_SPECIALITY_CODE")==null ?"":resultSet.getString("PRIMARY_SPECIALITY_CODE");
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
			return pat_specialty_code;
		}
		// ML-MMOH-CRF-1823 US008- 43528  END
		public String getActQuotaDrugValue(String patinet_id,String spec_code,String drug_code){
		System.err.println("insidegetActQuotaDrugValue@@ ");
		 Connection con			= null;  
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String curr_quota_value ="";
		try{
		con = getConnection() ;
		pstmt				= con.prepareStatement("SELECT B.QUOTA_CURR_VALUE QUOTA_CURR_VALUE FROM PH_PATIENT_DRUG_PROFILE A, OR_ORDER_LINE_PH B WHERE A.ORIG_ORDER_ID = B.ORDER_ID AND A.ORIG_ORDER_LINE_NO = B.ORDER_LINE_NUM AND A.PATIENT_ID =?  AND A.DRUG_CODE =? AND A.SPECIALITY_CODE =? AND TO_DATE (A.END_DATE, 'DD/MM/YYYY HH24:MI') >= TO_DATE (SYSDATE, 'DD/MM/YYYY HH24:MI') AND TO_DATE (SYSDATE, 'DD/MM/RRRR HH24:MI') BETWEEN TO_DATE (A.START_DATE, 'DD/MM/RRRR HH24:MI') AND TO_DATE (A.END_DATE, 'DD/MM/RRRR HH24:MI') AND A.DISCONT_DATE_TIME IS NULL AND A.ON_HOLD_DATE_TIME IS NULL AND A.CANCEL_YN = 'N' AND A.STOP_YN = 'N' and QUOTA_CURR_VALUE is not null ORDER BY A.ADDED_DATE DESC");
		pstmt.setString(1,patinet_id.trim());
		pstmt.setString(2,drug_code.trim());
		pstmt.setString(3,spec_code.trim());
				resultSet	= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
				     curr_quota_value     = resultSet.getString( "QUOTA_CURR_VALUE")==null?"":resultSet.getString( "QUOTA_CURR_VALUE");
					 System.err.println("curr_quota_value@@==="+curr_quota_value);
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
		
			return curr_quota_value;	
   }

}



