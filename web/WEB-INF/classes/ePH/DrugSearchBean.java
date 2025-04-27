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
10/01/2019	  	IN068344	     	Manickavasagam 		  								GHL-CRF-0549 [IN068344] 
07/03/2019	IN069337     Haribabu	  		  							 Need to show Generic name in drug search lookup
09/04/2019	IN069511     Haribabu	     		 						 Available Quantity for drugs need to take from interface table
30/06/2020	IN072347	Shazana												GHL-CRF-0619  
29/05/2020		IN:072092	        Manickavasagam J			     GHL-CRF-0618
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
07/11/2020  IN7565         Prabha         07/11/2020	  Manickavasagam J  UOM Code displayed in the Preferred drug window
10/11/2020		6041				Shazana       							NMC-JD-CRF-0063
01/12/2020  IN8219         Prabha	  	  12/01/2020	  Manickavasagam J    MMS-DM-CRF-0177
04/01/2021	 TFS id:7345 Haribabu	      04/01/2021       Manickavasagam J			     MMS-DM-CRF-0177
21/01/2021	 TFS-12204          Prabha      21/01/2021	  Manickavasagam J         MMS-DM-CRF-0177
03/02/2021	 TFS-15266          Haribabu   03/02/2021     Manickavasagam J           NMC-JD-SCF-0159
08/03/2021	 TFS-15611          Haribabu    08/03/2021	  Manickavasagam J         NMC-JD-ICN-0017
16/04/2021  	TFS id:-16341    Haribabu	 16/04/2021	 	 Manickavasagam J          NMC-JD-CRF-0097
18/10/2021  	TFS id:-24323    Manickavasagam J	 18/10/2021	 	           NMC-JD-CRF-0124
25/01/2022		TFS-27864		 Prabha										   MMS-JU-SCF-0200
01/04/2022	TFS-28777		Ramesh												MMS-DM-SCF-0806	
--------------------------------------------------------------------------------------------------------------------
*/
 package ePH ;  
import java.io.* ;
import java.util.* ;

import javax.servlet.http.HttpServletRequest;//Added for MMS-DM-CRF-0177

import java.sql.* ;
//import javax.rmi.PortableRemoteObject ; 
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import webbeans.eCommon.ConnectionManager;//Added for MMS-DM-CRF-0177
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;
import java.text.DecimalFormat;

public class  DrugSearchBean extends PhAdapter implements Serializable {

	private String iv_medication_type		=   "";	 // IV Medication Type	
	private String drugorfluid				=   "";
	private String res_by_service			=   "";
	private String in_formulary_yn			=   "";
	private String service_code				=   "";
	private String patient_class			=   "";
    private String non_essential_restricted	=   null;
	private String drug_type				=   null; 
	private String ingredient				=   null;
	private String fluid					=   null;
	private String compound					=   null;
	private String affects_pregnancy		=   null;
	private String affects_lab_results		=   null;
	private String affects_breast_feed		=   null;
	private String formulary				=   null;
	private String drug_class				=   null;
	private String schedule_id				=   null;
	private String scope					=   null;
	private String manufacturer_short_name	=   null;
	private String manufacturer_code		=   null;
	private String search_by				=   null;
	private String code						=	null;
	private String name						=   null;
	private String form_code				=   null;
	private String strength_value			=   null;
	private String strength_uom				=   null;
	private String route_code				=   null;
	private Hashtable selectedDrugsList		=   null;
	// This is useful to idenitify from which function it has been called...
	private String identity					=	null;
	private String drug_search_by           =   null;
	private String order_type_code			=   null;
	private Hashtable disabledDrugs			=	null;
	private String discharge_yn				= "";
	private String priority					= "R";
	protected String patient_id				= "";
	protected String encounter_id			= "";
	protected String source_code			= "";
	private String store_desc				= "";
	private String store_code				= "";
	protected String sel_drg_codes			= "";
	protected String iv_prep_yn			    = "";
	protected String source_type			= "";
	protected String calledfrom				= "";	
	protected String disp_locn_code         = ""; 
	protected String date_of_brith			= ""; 
	protected String gender					= ""; 
    protected String episode_type			= "";
    protected String itemCode				= "";
	private ArrayList billingCheckValues	= null;
	private HashMap	external_disp_yn	    = new HashMap();//Added for IN069511
	private HashMap	sameGenericItems	    = new HashMap();//Added for TFS id:7345
	private HashMap	sameGenericItemsdata	    = new HashMap();//Added for TFS id:7345
	private String bl_disp_charge_dtl_in_drug_lkp_yn ="";
	private String bl_disp_price_type_in_drug_lkp ="";
	private String bl_install_yn ="";
	private String priviligeDrugCheck ="";
	private String practitionerId ="";
	private String resp_id ="";
	private String npb_drug =""; // code added for Bru-HIMS-CRF-070 [IN029935]
	private String home_leave_yn ="";//added home_leave_yn_val for Bru-HIMS-CRF-093[29960] -->
	private String generic_id_alternate = "";//added for  JD-CRF-0198 [IN:058599]
	//Declared Strength variables  on 21/Sept/2010-
	 String strength ="";
	 String strength1 ="";
	 String strength2 ="";
	public int iNoOfDecimals=0;
	HashMap selected_drug = new HashMap(); //GHL-CRF-0549
    private boolean ext_disp_appl=false;//Added for IN069511
  //added for NMC-JD-CRF-0063 START
    private String take_home_medication_op = "";
    private String opDischMedInd = "";
    private String opDisMedLocn="";

    private String p_episode_type="";//mms-dm-crf-0209.1
    private String p_episode_id="";//mms-dm-crf-0209.1
    private String p_visit_id="";//mms-dm-crf-0209.1
    
   /* private String p_generic_code  ="";//mms-dm-crf-0209.1
    private String p_strength_value   ="";//mms-dm-crf-0209.1
    private String p_strength_uom="";//mms-dm-crf-0209.1
    private String p_form_code="";//mms-dm-crf-0209.1
    private String p_item_code="";//mms-dm-crf-0209.1
    
    */

/*	public String getP_item_code() {
		return p_item_code;
	}


	public void setP_item_code(String p_item_code) {
		this.p_item_code = p_item_code;
	}
*/

	public String getP_episode_type() {
		return p_episode_type;
	}


	/*public String getP_generic_code() {
		return p_generic_code;
	}


	public void setP_generic_code(String p_generic_code) {
		this.p_generic_code = p_generic_code;
	}


	public String getP_strength_value() {
		return p_strength_value;
	}


	public void setP_strength_value(String p_strength_value) {
		this.p_strength_value = p_strength_value;
	}


	public String getP_strength_uom() {
		return p_strength_uom;
	}


	public void setP_strength_uom(String p_strength_uom) {
		this.p_strength_uom = p_strength_uom;
	}


	public String getP_form_code() {
		return p_form_code;
	}


	public void setP_form_code(String p_form_code) {
		this.p_form_code = p_form_code;
	}*/


	public void setP_episode_type(String p_episode_type) {
		this.p_episode_type = p_episode_type;
	}


	public String getP_episode_id() {
		return p_episode_id;
	}


	public void setP_episode_id(String p_episode_id) {
		this.p_episode_id = p_episode_id;
	}


	public String getP_visit_id() {
		return p_visit_id;
	}


	public void setP_visit_id(String p_visit_id) {
		this.p_visit_id = p_visit_id;
	}


	public String getOpDisMedLocn() {
		return opDisMedLocn;
	}


	public void setOpDisMedLocn(String opDisMedLocn) {
		this.opDisMedLocn = opDisMedLocn;
	}


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
	}//NMC-JD-CRF-0063 end
	
	 private String search_by_generic_or_trade=""; //Added for NMC-JD-SCF-0159
	private String generic_or_trade_code="";  //Added for NMC-JD-SCF-0159
    public String getSearchByGenericOrTrade() {   //Added for NMC-JD-SCF-0159
		return search_by_generic_or_trade;
	}

	public void setSearchByGenericOrTrade(String search_by_generic_or_trade) {  //Added for NMC-JD-SCF-0159
		this.search_by_generic_or_trade = search_by_generic_or_trade;
	}
	public String getGenericOrTradeCode() {  //Added for NMC-JD-SCF-0159
		return generic_or_trade_code;
	}
	public void setGenericOrTradeCode(String generic_or_trade_code) {  //Added for NMC-JD-SCF-0159
		this.generic_or_trade_code = generic_or_trade_code;
	}
	protected static String called_from_verbal_order ="";
	//GHL-CRF-0618 - start
	private String blg_grp_id = ""; 
	private String	 formulary_code			= ""; 
	private String	 formulary_type         = "";	
	private boolean formulary_blng_app	    = false;//GHL-CRF-0618
	private ArrayList  itemGenericType = new ArrayList();//GHL-CRF-0618
	//GHL-CRF-0618 - end
	private boolean pre_alloc_appl=false; //Added for MMS-DM-CRF-0177
	//Added for TFS id:-16341 start
	private boolean default_disp_locn_select_appl=false;
	
	public boolean getDefaultDispLocnSelectAppl() {
		return default_disp_locn_select_appl;
	}


	public void setDefaultDispLocnSelectAppl(boolean default_disp_locn_select_appl) {
		this.default_disp_locn_select_appl = default_disp_locn_select_appl;
	}
//Added for TFS id:-16341 end

	/**
	 * @return the generic_id_alternate//added for  JD-CRF-0198 [IN:058599]
	 */
	public String getGeneric_id_alternate() {
		return generic_id_alternate;
	}


	/**
	 * @param generic_id_alternate the generic_id_alternate to set//added for  JD-CRF-0198 [IN:058599]
	 */
	public void setGeneric_id_alternate(String generic_id_alternate) {
		this.generic_id_alternate = generic_id_alternate;
	}


	public String getPriviligeDrugCheck() {
		return this.priviligeDrugCheck;
	}

	
	public void setPriviligeDrugCheck(String priviligeDrugCheck) {
		this.priviligeDrugCheck = priviligeDrugCheck;
	}
	public String getPractitionerId() {
		return this.practitionerId;
	}
	
	public void setPractitionerId(String practitionerId) {
		this.practitionerId = practitionerId;
	}
	public String getRespId() {
		return this.resp_id;
	}
//added for GHL-CRF-0618 - start
	public void setFormularyCode(String formulary_code){
		this.formulary_code = formulary_code;
	}

	public String getFormularyCode(){
		return formulary_code;
	}
	public void setFormularyBlngGrpType(String formulary_type){
		this.formulary_type = formulary_type;
	}

	public String getFormularyBlngGrpType(){
		return formulary_type;
	}

//added for GHL-CRF-0618 - end
	public void setRespId(String resp_id) {
		this.resp_id = resp_id;
	}
	public String getBl_install_yn() {
		return bl_install_yn;
	}

	
	public void setBl_install_yn(String bl_install_yn) {
		this.bl_install_yn = bl_install_yn;
	}

	public String getBl_disp_price_type_in_drug_lkp() {
		return bl_disp_price_type_in_drug_lkp;
	}
//GHL-CRF-0618 - start
	public void setBillingGrpId(String blg_grp_id){
		this.blg_grp_id = blg_grp_id;
	}
	public String getBillingGrpId(){
		return blg_grp_id;
	}
	public void setItemGenericType(String item_type){
	  this.itemGenericType.add(item_type);
	}

	public ArrayList getItemGenericType(){
	 return this.itemGenericType;
	}

//GHL-CRF-0618 - end	
	public void setBl_disp_price_type_in_drug_lkp(
			String bl_disp_price_type_in_drug_lkp) {
		this.bl_disp_price_type_in_drug_lkp = bl_disp_price_type_in_drug_lkp;
	}

	public String getBl_disp_charge_dtl_in_drug_lkp_yn() {
		return bl_disp_charge_dtl_in_drug_lkp_yn;
	}

	
	public void setBl_disp_charge_dtl_in_drug_lkp_yn(
			String bl_disp_charge_dtl_in_drug_lkp_yn) {
		this.bl_disp_charge_dtl_in_drug_lkp_yn = bl_disp_charge_dtl_in_drug_lkp_yn;
	}
	
	public void setCalled_from_verbal_order(String yes_no)
	{
		this.called_from_verbal_order = yes_no;
	}

	public String getCalled_from_verbal_order()
	{
		return this.called_from_verbal_order;
	}

	public int getNoOfDecimals() {
		return this.iNoOfDecimals;
	}

	public DrugSearchBean() {
	  try {
			doCommon();
	  }catch(Exception e){
		e.printStackTrace();
	  }
    }
	/* code added for Bru-HIMS-CRF-070 [IN029935] --Start --*/
	public String getNPBDrug() {
		return this.npb_drug;
	}
	
	public void setNPBDrug(String npb_drug) {
		this.npb_drug = npb_drug;		
	}
	/* code added for Bru-HIMS-CRF-070 [IN029935] --End --*/

    public void clear() {
		super.clear() ;
		disabledDrugs		= null;
		selectedDrugsList	= null;
		patient_class		= null;
		selected_drug	    = new HashMap();//GHL-CRF-0549
		patient_id			=	"";
		iv_medication_type	=   "";
		drugorfluid			=   "";
		res_by_service		=   "";
		in_formulary_yn		=   "";
		service_code		=   "";
		patient_class		=   "";
		source_code         =   "";
		sel_drg_codes		=   "";
		iv_prep_yn		    =   "";
		source_type		    =   "";
		calledfrom          =   "";
		disp_locn_code      =   "";
 		date_of_brith		=   "";
		gender				=   "";
		practitionerId		=	"";
		//GHL-CRF-0618 - start
		blg_grp_id			=   ""; 
		formulary_code		=	"";
		formulary_type		=   "";
		//GHL-CRF-0618 - end
		external_disp_yn    = new HashMap(); //Added for IN069511
		itemGenericType	    = new ArrayList();//GHL-CRF-0618
		take_home_medication_op="";//added for NMC-JD-CRF-0063 START
		opDischMedInd = "";//END
		sameGenericItems    = new HashMap();//Added for TFS id:7345
		sameGenericItemsdata = new HashMap();//Added for TFS id:7345
		search_by_generic_or_trade="";//Added for NMC-JD-SCF-0159
		generic_or_trade_code="";//Added for NMC-JD-SCF-0159
		
   }
	public void doCommon() throws Exception {
	}

	public void initialize() {

		non_essential_restricted=   "B";                                  
		drug_type				=   "A"; // All                           
		ingredient				=   "B";                                  
		fluid					=   "B";                                  
		compound				=   "B";                                  
		affects_pregnancy		=   "B";                                  
		affects_lab_results		=   "B";                                  
		affects_breast_feed		=   "B";                                  
		formulary				=   "B";                                  
		drug_class				=   "";                                   
		schedule_id				=   "";                                   
		scope					=   "";                                   
		manufacturer_short_name	=   "";                                   
		manufacturer_code		=   "";                                   
		search_by				=   "";                                           
		code					=	"";                                           
		name					=   "";                                           
		form_code				=   "";                                           
		strength_value			=   "";                                           
		strength_uom			=   "";                                           
		route_code				=   "";                                           
		selectedDrugsList		=   new Hashtable();
		identity				=	""; 
		drug_search_by          =   "";
		order_type_code			=   "";                                           
		disabledDrugs			=   new Hashtable(); 
		patient_id				=	"";
		source_code				=   ""; 
		iv_prep_yn				=   ""; 
		source_type				=   ""; 
		calledfrom              =   ""; 
		disp_locn_code          =   "";
		date_of_brith			=   "";
		gender					=   "";
	}

	
	public void setDischargeYN(String discharge_yn){
		this.discharge_yn = discharge_yn;
	}

	public void setStoreDesc(String store_desc) {
		this.store_desc	=	store_desc;
	}
	
	public String getStoreDesc(){
		return this.store_desc;
	}
	
	public void setStoreCode(String store_code) {
		this.store_code	=	store_code;
	}
	
	public String getStoreCode(){
		return this.store_code;
	}
  public void setItemCode(String itemCode) {
		this.itemCode	=	itemCode;
	}
	
	public String getItemCode(){
		return this.itemCode;
	}
	public String getDischargeYN(){
		return this.discharge_yn;
	}
	//added below methods for Bru-HIMS-CRF-093[29960] -->
	public void setHomeLeaveYN(String home_leave_yn){
		this.home_leave_yn = home_leave_yn;
	}
	public String getHomeLeaveYN(){
		return this.home_leave_yn;
	}
	//adding end for Bru-HIMS-CRF-093[29960] -->
	
	public String getSearchBy(){
		return this.search_by;
	}

	public void setSearchBy(String search_by){
		this.search_by = search_by;
	}

	public String getDrugSearchBy(){
		return this.drug_search_by;
	}

	public void setDrugSearchBy(String drug_search_by){
		this.drug_search_by = drug_search_by;
	}
	
	public void setPatientId(String patient_id) {
		this.patient_id	=	patient_id;
	}

	public String getPatientId() {
		return this.patient_id;
	}
	public void setEpisodeType(String episode_type) {
		this.episode_type	=	episode_type;
	}

	public String getEpisodeType() {
		return this.episode_type;
	}
	public String getEncounterId() {
		return this.encounter_id;
	}

	public void setEncounterId(String encounter_id) {
		this.encounter_id	=	encounter_id;
	}

	public String getDOB() {
		return this.date_of_brith;
	}

	public void setDOB(String date_of_brith) {
		this.date_of_brith	=	date_of_brith;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender	=	gender;
	}
	
	public void setPriority(String priority){
		this.priority = priority;
	}
	public String getPriority(){
		return this.priority;
	}

	public void setsource_type(String source_type) {
		this.source_type	=	source_type;
	}

	public String getsource_type() {
		return this.source_type;
	}

	public void setsource_code(String source_code) {
		this.source_code	=	source_code;
	}

	public String getsource_code() {
		return this.source_code;
	}

	public void setIv_prep_yn(String iv_prep_yn) {
		this.iv_prep_yn	=	iv_prep_yn;
	}

	public String getIv_prep_yn() {
		return this.iv_prep_yn;
	}
    
	public void setcalledfrom(String calledfrom) {
		this.calledfrom	=	calledfrom;
	}

	public String getcalledfrom() {
		return this.calledfrom;
	}


	// This Method will be called on cancelling the order from medication order...
	public void removeDrugCode(String drug_code){
		Enumeration enum1= selectedDrugsList.keys() ;
		while(enum1.hasMoreElements()){
			String drug_code_in_ht = (String)enum1.nextElement();
			drug_code_in_ht = drug_code_in_ht.substring(0,drug_code_in_ht.length()-1);
			if((drug_code.trim()).equals(drug_code_in_ht.trim())){
				selectedDrugsList.remove(drug_code.trim());
				selected_drug.remove(drug_code.trim());
			}
		}
	}

	public String getIVMedicationType(){
		return iv_medication_type;
	}

	public void setIVMedciationType(String iv_medication_type){
		this.iv_medication_type = iv_medication_type;
	}

	public String getNonEssentialRestricted(){
		if (non_essential_restricted==null){
			non_essential_restricted="";
		}
		return non_essential_restricted;
	}

	public String getIngredient(){
		if (ingredient==null){
			ingredient="";
		}
		return ingredient;
	}

	public String getFluid(){
		if (fluid==null){
			fluid="";
		}
		return fluid;
	}

	public String getScheduleID(){
		if (schedule_id==null){
			schedule_id="";
		}
		return schedule_id;
	}

	public String getAffectsBreastFeed(){
		if (affects_breast_feed==null){
			affects_breast_feed="";
		}
		return affects_breast_feed;
	}

	public String getAffectsLabResults(){
		if (affects_lab_results==null){
			affects_lab_results="";
		}
		return affects_lab_results;
	}

	public String getAffectsPregnancy(){
		if (affects_pregnancy==null){
			affects_pregnancy="";
		}
		return affects_pregnancy;
	}

	public String getFormulary(){
		if (formulary==null){
			formulary="";
		}
		return formulary;
	}

	public String getCompound(){
		if (compound==null){
			compound="";
		}
		return compound;
	}

	public String getDrugType(){
		if (drug_type==null){
			drug_type="";
		}
		return drug_type;
	}

	public String getDrugClass(){
		if (drug_class==null){
			drug_class="";
		}
		return drug_class;
	}

	public String getScope(){
		if (scope==null){
			scope="";
		}
		return scope;
	}

	public String getManufacturerCode(){
		if (manufacturer_code==null){
			manufacturer_code = "";
		}
		return manufacturer_code;
	}

	public String getManufacturerShortName(){
		if (manufacturer_short_name==null){
			manufacturer_short_name = "";
		}
		return manufacturer_short_name;
	}


	public String getDrugOrFluid(){
		return drugorfluid;
	}

	public void setDrugOrFluid(String drugorfluid){
		this.drugorfluid = drugorfluid;
	}


	public String getIdentity(){
		return identity;
	}
	public void setIdentity(String identity){
		if(identity==null)
			identity = "General";
		else if(identity.equals("null"))
			identity = "General";

		this.identity = identity;
	}
	public void setOrderTypeCode(String order_type_code){
		this.order_type_code = order_type_code;
	}
	


	public void setServiceCode(String service_code){
		this.service_code = service_code;
	}
	public void setResByService(String res_by_service){
		this.res_by_service = res_by_service;
	}

	public void setInFormulary(String in_formulary_yn){
		this.in_formulary_yn = in_formulary_yn;
	}
	public String getInFormulary(){
		return this.in_formulary_yn;
	}

	public void setPatientClass(String patient_class){
		this.patient_class = patient_class;
	}

   public void setDispLocnCode(String disp_locn_code){
		this.disp_locn_code = disp_locn_code;
	}
//GHL-CRF-0549 - start
	public void setSelectedDrug(String drug_code){
		this.selected_drug.put(drug_code,"Y");
	}

	 public HashMap getSelectedDrug(){
		return selected_drug;
	}
//GHL-CRF-0549 - end   
   public String getDispLocnCode(){
		return disp_locn_code;
	}

	public String getOrderTypeCode(){
		return this.order_type_code;
	}

	public String getPatientClass(){
		if(patient_class==null){
			patient_class="IP";
		}
		return patient_class;
	}
	//Added for IN069511
	public boolean isExt_disp_appl() {
		return ext_disp_appl;
	}

	public void setExt_disp_appl(boolean ext_disp_appl) {
		this.ext_disp_appl = ext_disp_appl;
	}
	//Added for IN069511
//GHL-CRF-061 - start
	public void setFormularyBlngApp(boolean formulary_blng_app){
		this.formulary_blng_app = formulary_blng_app;
	}
	boolean getFormularyBlngApp(){
		return this.formulary_blng_app;
	}
	//GHL-CRF-061 - end
	
	//Added for MMS-DM-CRF-0177
	
    public boolean getPreAllocAppl() {
        return pre_alloc_appl;
    }
    public void setPreAllocAppl(boolean pre_alloc_appl) {
        this.pre_alloc_appl = pre_alloc_appl;
    }
    
    //Added for MMS-DM-CRF-0177
/*	This method will return the order_type values for displaying in combo box in case this
	search is called from medication order.
*/
	public ArrayList getOrderTypeValues(){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList arrListOrderType=new ArrayList();
		try {
			connection = getConnection() ;
			// For Order Type
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT14") );
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
				arrListOrderType.add(resultSet.getString("ORDER_TYPE_CODE"));
				arrListOrderType.add(resultSet.getString("SHORT_DESC"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return arrListOrderType;
	}

	public String getDecimalFormatString(){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet rsDecimalPlace = null ;
		String decimalFormatString = "#0";
		int decimal_place= 0;
		try {
			connection = getConnection() ;
			// For Order Type
			//pstmt = connection.prepareStatement("SELECT BLCORE.GET_DECIMAL_PLACE(?) decimal_place FROM dual");
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
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( rsDecimalPlace ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return decimalFormatString;
	}

//code added on 25/4/2004 to set drug name default.....
	public String getDefaultDrugSetting(){
		Connection connection = null ;
		PreparedStatement pstmt_drug = null ;
		ResultSet resultSet_drug = null ;
		String setDrugName		= "";
		try {
			connection = getConnection() ;
			// For Order Type
			pstmt_drug = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT19") );
			resultSet_drug = pstmt_drug.executeQuery() ;
			while (resultSet_drug != null && resultSet_drug.next()){
				setDrugName	= resultSet_drug.getString("MEDN_ORDER_BY");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet_drug ) ;
				closeStatement( pstmt_drug ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return setDrugName;
	}
//ended...
//	This method will returns the data for displaying in combo boxes
	public ArrayList getAllDefaultValues(){

		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		ArrayList arrListAll		= new ArrayList();
		ArrayList arrListForm		= new ArrayList();
		ArrayList arrListStrength	= new ArrayList();
		ArrayList arrListRoute		= new ArrayList();
		ArrayList arrListSchedule	= new ArrayList();
		ArrayList arrListLocation	= new ArrayList();
		try {
			connection = getConnection() ;
			// For form
		/*	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT4") );
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
				arrListForm.add(resultSet.getString("FORM_CODE"));
				arrListForm.add(resultSet.getString("FORM_DESC"));
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			// For route
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT6") );
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
				arrListRoute.add(resultSet.getString("ROUTE_CODE"));
				arrListRoute.add(resultSet.getString("ROUTE_DESC"));
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);*/
			// For uom
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT5") );
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
				arrListStrength.add(resultSet.getString("UOM_CODE"));
				arrListStrength.add(resultSet.getString("SHORT_DESC"));
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			//For schedule
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT7") );
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
				arrListSchedule.add(resultSet.getString("SCHEDULE_ID"));
				arrListSchedule.add(resultSet.getString("SCHEDULE_DESC"));
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			//For Dispense location
			/*pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT9") );
			pstmt.setString(1,login_facility_id.trim());
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
				arrListLocation.add(resultSet.getString("DISP_LOCN_CODE"));
				arrListLocation.add(resultSet.getString("SHORT_DESC"));
			}*/
			arrListLocation.add("");
			arrListLocation.add("");
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
		arrListAll.add(arrListForm);
		arrListAll.add(arrListRoute);
		arrListAll.add(arrListStrength);
		arrListAll.add(arrListSchedule);
		arrListAll.add(arrListLocation);
		return arrListAll;
	}

	public void setOtherCriteriaData(Hashtable otherDataList){

		clearMainCriteriaData();
		clearOtherCriteriaData();
		non_essential_restricted	=	(String)otherDataList.get("non_essential_restricted");
		drug_type					=	(String)otherDataList.get("drug_type");
		ingredient					=	(String)otherDataList.get("ingredient");
		fluid						=	(String)otherDataList.get("fluid");
		compound					=	(String)otherDataList.get("compound");
		affects_pregnancy			=	(String)otherDataList.get("affects_pregnancy");
		affects_lab_results			=	(String)otherDataList.get("affects_lab_results");
		affects_breast_feed			=	(String)otherDataList.get("affects_breast_feed");
		formulary					=	(String)otherDataList.get("formulary");
		drug_class					=	(String)otherDataList.get("drug_class");
		if (drug_class==null){
			drug_class = "";
		}
		else {
			if (drug_class.equals("C")){
				drug_class = "Controlled";
			}
			else if (drug_class.equals("N")){
				drug_class = "Narcotic";
			}
			else if (drug_class.equals("G")){
				drug_class = "General";
			}
		}
		schedule_id					=	(String)otherDataList.get("schedule_id");
		scope						=	(String)otherDataList.get("scope");
		manufacturer_short_name		=	(String)otherDataList.get("manufacturer_short_name");
		manufacturer_code			=	(String)otherDataList.get("manufacturer_code");

	}

	public void setMainCriteriaData(Hashtable mainDataList) throws Exception{
		clearMainCriteriaData();
		search_by		=(String)mainDataList.get("search_by");
		code			=(String)mainDataList.get("code");
		name			=(String)mainDataList.get("name");
		form_code		=(String)mainDataList.get("form_code");
		strength_value	=(String)mainDataList.get("strength_value");
		strength_uom	=(String)mainDataList.get("strength_uom");
		route_code		=(String)mainDataList.get("route_code");
		identity		=(String)mainDataList.get("identity");
		drug_search_by	=(String)mainDataList.get("drug_search_by");

		if (identity.equals("MedicationOrder")){
			order_type_code = (String)mainDataList.get("order_type_code");
			res_by_service  = (String)mainDataList.get("res_by_service");
			service_code  = (String)mainDataList.get("service_code");
			in_formulary_yn  = (String)mainDataList.get("in_formulary_yn");
		}
		else{
			order_type_code = "";
			res_by_service  = "";
			service_code  = "";
			in_formulary_yn = "";
		}
	}

	public void storeSelectedDrugs(Hashtable drugs){

		ArrayList drugDet = null;
		if(drugs != null){
			for (int i=1;i<drugs.size() ; i++){
				if(drugs.get("select"+i) != null){
					String select = (String)drugs.get("select"+i);
					if (select.equals("E")){
						drugDet = new ArrayList();
						drugDet.add((String)drugs.get("drug_code"+(i)));
						drugDet.add((String)drugs.get("trade_code"+(i)));
						drugDet.add(java.net.URLEncoder.encode((String)drugs.get("trade_name"+(i))));
						selectedDrugsList.put((String)drugs.get("drug_code"+(i))+(String)drugs.get("line_no"+(i)),drugDet);
					}
					else{
						selectedDrugsList.remove((String)drugs.get("drug_code"+(i))+(String)drugs.get("line_no"+(i)));
					}
				}
			}
		}
	}

	public Hashtable getSelectedDrugs(){
		return selectedDrugsList;
	}

	public void resetSelectedDrugsList(){
		selectedDrugsList= new Hashtable();
	}

	public void clearMainCriteriaData(){
		search_by		=	"";
		name			=	"";
		form_code		=	"";
		strength_value	=	"";
		strength_uom	=	"";
		route_code		=	"";
		identity		=	"";
		order_type_code =   "";
		res_by_service	=	"";
		drug_search_by  =   "";
	}

	public void clearOtherCriteriaData(){
		non_essential_restricted	=	"B";
		drug_type					=   "A";
		ingredient					=	"B";
		fluid						=	"B";
		compound					=	"B";
		affects_pregnancy			=	"B";
		affects_lab_results			=	"B";
		affects_breast_feed			=	"B";
		formulary					=	"B";
		drug_class					=	"";
		schedule_id					=	"";
		scope						=	"";
		manufacturer_short_name		=	"";
		manufacturer_code			=	"";
	}

	// Search by drug characteristics
	public ArrayList searchBasedOnDataSelected(String from , String to, String bl_install_yn, String disp_charge_dtl_in_drug_lkp_yn, String disp_price_type_in_drug_lkp,String priviligeDrugCheck, String practitionerId, String resp_id, String drug_priv_ssn_yn)throws Exception{
		priviligeDrugCheck = getPriviligeDrugCheck();
		setRespId(resp_id);
		sameGenericItems = new HashMap();//Added for TFS id:7345
		sameGenericItemsdata = new HashMap();//Added for TFS id:7345
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		CallableStatement cstmt = null ;
		ResultSet resultSet		= null ;
		String generic_id="",drug_id="",trade_id="",pract_type="";
	//	String priv_applin_yn	=	"";   Removed for IN063877
		ArrayList records		= new ArrayList();
		String prevnextlink		= "";
		int query_result_size	= 10;
		int start				= 0 ;
		int end					= 0 ;
		String diagnosisEncountLevel = "N";
		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if(identity.equals("MedicationOrder")){
			query_result_size = 10;//5 changed to 10 
		}
		else{
			query_result_size = 10;
		}

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;

		String generic_name		="";
		String drug_desc		="";
		String trade_desc		="";
		String synonym ="";
		String temp_manufacturer_short_name="";
		episode_type= getPatientClass();
		if(episode_type !=null && (!episode_type.equals("")))
			episode_type = episode_type.substring(0,1);

		if(episode_type !=null && episode_type.equals("X"))
			episode_type = "R";
		if(getDischargeYN().equals("Y") || getDischargeYN().equals("D")) //Added for mms-dm-crf-0209.1
			episode_type = "I";
		String item_code		= "";
		

		long count				= 0;
		long i					= 0;
		double strength1_value  = 0;
		String queryAppend		= "";

		try {
			diagnosisEncountLevel=getDiagnosisLevel();
			connection = getConnection() ;
		
			if (strength_value.equals(""))
				strength1_value = 0;
			else
				strength1_value = Double.parseDouble(strength_value);
			String decimalFormatString ="";
		   if ( bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y")&& identity.equals("MedicationOrder")){
				decimalFormatString = getDecimalFormatString();
			}
			if(identity.equals("General")){
				if (search_by.equals("C")){
					queryAppend = "AND snm.DRUG_CODE=PH_DRUG_VW.DRUG_CODE AND snm.EFF_STATUS='E' AND upper(SNM.DRUG_SYNONYM_DESC) LIKE upper(?) AND snm.LANGUAGE_ID=LANG1";
				}
				else 
					queryAppend = "AND snm.DRUG_CODE(+)=PH_DRUG_VW.DRUG_CODE AND snm.EFF_STATUS(+)='E' AND upper(SNM.DRUG_SYNONYM_DESC(+)) LIKE upper(?) AND snm.LANGUAGE_ID(+)=LANG1";

				if (strength1_value > 0)
				{
					queryAppend += " and STRENGTH_VALUE = ? ";
				}

				if (search_by.equals("A")){
					//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ALL_DRUG_SEARCH_SELECT"));
					//pstmt = connection.prepareStatement( "SELECT DRUG_CODE, ITEM_CODE, DRUG_DESC, FORM_CODE, FORM_DESC, STRENGTH_VALUE, STRENGTH_UOM, STRENGTH_UOM_DESC,STRENGTH_PER_PRES_UOM, STRENGTH_PER_VALUE_PRES_UOM,PRES_BASE_UOM,ROUTE_CODE, ROUTE_DESC,TRADE_NAME,GENERIC_NAME,GENERIC_ID,PRES_BASE_UOM,IN_FORMULARY_YN,TRADE_CODE, DRUG_CLASS FROM  PH_DRUG_VW_LANG_VW PH_DRUG_VW WHERE DISCONTINUED_YN = 'N' AND UPPER(GENERIC_ID) LIKE UPPER(?) AND (UPPER(GENERIC_NAME) LIKE UPPER(?) OR UPPER(DRUG_DESC) LIKE UPPER(?) OR UPPER(NVL(TRADE_NAME,'X')) LIKE UPPER(?)) AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(FORM_CODE) LIKE UPPER(?) AND UPPER(ROUTE_CODE) LIKE UPPER(?)   AND NVL(STRENGTH_UOM,'X') LIKE UPPER(?) AND NVL(DRUG_CLASS,'X') LIKE ? AND NVL(SCHEDULE_ID,'X') LIKE UPPER(?) AND NVL(RESTRICTED_DRUG_YN,'X') LIKE DECODE(?,'B',RESTRICTED_DRUG_YN,?) AND NVL(DRUG_TYPE,'X') LIKE DECODE(?,'A',DRUG_TYPE,?) AND NVL(IV_INGREDIENT_YN,'X') LIKE DECODE(?,'B',IV_INGREDIENT_YN,?) AND NVL(IV_FLUID_YN,'X') LIKE DECODE(?,'B',IV_FLUID_YN,?) AND NVL(COMPOUND_DRUG_YN,'X') LIKE DECODE(?,'B',COMPOUND_DRUG_YN,?) AND NVL(IN_FORMULARY_YN,'X') LIKE DECODE(?,'B',IN_FORMULARY_YN,?) AND NVL(AFFECTS_PREGNANCY_YN,'X') LIKE DECODE(?,'B',AFFECTS_PREGNANCY_YN,?) AND NVL(AFFECTS_LAB_RESULTS_YN,'X') LIKE DECODE(?,'B',AFFECTS_LAB_RESULTS_YN,?) AND NVL(AFFECTS_BREAST_FEEDING_YN,'X') LIKE DECODE(?,'B',AFFECTS_BREAST_FEEDING_YN,?) AND  UPPER(NVL(MANUFACTURER_ID,'X')) LIKE UPPER(?) AND UPPER(NVL(MANUFACTURER_NAME,'X')) LIKE UPPER(?) AND   UPPER(NVL(TRADE_CODE,'X')) LIKE UPPER(?) AND LANG1 = ? AND DECODE(LANG2,NULL,?,LANG2)= ? AND  DECODE(LANG3,NULL,?,LANG3)= ? ORDER BY DRUG_DESC,FORM_DESC");

					//pstmt = connection.prepareStatement( "SELECT DRUG_CODE, ITEM_CODE, DRUG_DESC, FORM_CODE, FORM_DESC, STRENGTH_VALUE, STRENGTH_UOM, STRENGTH_UOM_DESC,STRENGTH_PER_PRES_UOM, STRENGTH_PER_VALUE_PRES_UOM,PRES_BASE_UOM,ROUTE_CODE, ROUTE_DESC,TRADE_NAME,GENERIC_NAME,GENERIC_ID,PRES_BASE_UOM,IN_FORMULARY_YN,TRADE_CODE, DRUG_CLASS,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id ='"+getLanguageId()+"' ) stock_uom_desc,ph_get_ext_prod_drug_code(PH_DRUG_VW.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID FROM  PH_DRUG_VW_LANG_VW PH_DRUG_VW WHERE DISCONTINUED_YN = 'N' AND UPPER(GENERIC_ID) LIKE UPPER(?) AND (UPPER(GENERIC_NAME) LIKE UPPER(?) OR UPPER(DRUG_DESC) LIKE UPPER(?) OR UPPER(NVL(TRADE_NAME,'X')) LIKE UPPER(?)) AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(FORM_CODE) LIKE UPPER(?) AND UPPER(ROUTE_CODE) LIKE UPPER(?)   AND NVL(STRENGTH_UOM,'X') LIKE UPPER(?) AND NVL(DRUG_CLASS,'X') LIKE ? AND NVL(SCHEDULE_ID,'X') LIKE UPPER(?) AND NVL(RESTRICTED_DRUG_YN,'X') LIKE DECODE(?,'B',RESTRICTED_DRUG_YN,?) AND NVL(DRUG_TYPE,'X') LIKE DECODE(?,'A',DRUG_TYPE,?) AND NVL(IV_INGREDIENT_YN,'X') LIKE DECODE(?,'B',IV_INGREDIENT_YN,?) AND NVL(IV_FLUID_YN,'X') LIKE DECODE(?,'B',IV_FLUID_YN,?) AND NVL(COMPOUND_DRUG_YN,'X') LIKE DECODE(?,'B',COMPOUND_DRUG_YN,?) AND NVL(IN_FORMULARY_YN,'X') LIKE DECODE(?,'B',IN_FORMULARY_YN,?) AND NVL(AFFECTS_PREGNANCY_YN,'X') LIKE DECODE(?,'B',AFFECTS_PREGNANCY_YN,?) AND NVL(AFFECTS_LAB_RESULTS_YN,'X') LIKE DECODE(?,'B',AFFECTS_LAB_RESULTS_YN,?) AND NVL(AFFECTS_BREAST_FEEDING_YN,'X') LIKE DECODE(?,'B',AFFECTS_BREAST_FEEDING_YN,?) AND  UPPER(NVL(MANUFACTURER_ID,'X')) LIKE UPPER(?) AND UPPER(NVL(MANUFACTURER_NAME,'X')) LIKE UPPER(?) AND   UPPER(NVL(TRADE_CODE,'X')) LIKE UPPER(?)  AND LANG1 = ? AND DECODE(LANG2,NULL,?,LANG2)= ? AND  DECODE(LANG3,NULL,?,LANG3)= ? "+queryAppend+" ORDER BY DRUG_DESC,FORM_DESC");
						//ADDED FOR PH_DRUG_VW.STRENGTH_UOM DRUG_STRENGTH	GHL-CRF-0548
					pstmt = connection.prepareStatement( "SELECT DISTINCT PH_DRUG_VW.DRUG_CODE,PH_DRUG_VW.STRENGTH_UOM DRUG_STRENGTH, ITEM_CODE, DRUG_DESC, FORM_CODE, FORM_DESC, STRENGTH_VALUE, PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',STRENGTH_UOM,'"+getLanguageId()+"') STRENGTH_UOM, STRENGTH_UOM_DESC,STRENGTH_PER_PRES_UOM, STRENGTH_PER_VALUE_PRES_UOM,PRES_BASE_UOM,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',PRES_BASE_UOM,'"+getLanguageId()+"') PRES_BASE_UOM1,ph_drug_vw.route_code, ph_drug_vw.route_desc,TRADE_NAME,GENERIC_NAME,GENERIC_ID,PRES_BASE_UOM,IN_FORMULARY_YN,TRADE_CODE, DRUG_CLASS,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id ='"+getLanguageId()+"' ) stock_uom_desc,ph_get_ext_prod_drug_code(PH_DRUG_VW.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID,E.ROUTE_COLOR,PH_DRUG_VW.DRUG_SEARCH_BY FROM  PH_DRUG_VW_LANG_VW PH_DRUG_VW, PH_DRUG_SYNONYM_lang snm,ph_route_lang_vw e WHERE DRUG_YN = 'Y' AND DISCONTINUED_YN = 'N' AND UPPER(GENERIC_ID) LIKE UPPER(?) AND (UPPER(GENERIC_NAME) LIKE UPPER(?) OR UPPER(DRUG_DESC) LIKE UPPER(?) OR UPPER(NVL(TRADE_NAME,'X')) LIKE UPPER(?)) AND UPPER(PH_DRUG_VW.DRUG_CODE) LIKE UPPER(?) AND UPPER(FORM_CODE) LIKE UPPER(?) AND UPPER(ph_drug_vw.ROUTE_CODE) LIKE UPPER(?)   AND NVL(STRENGTH_UOM,'X') LIKE UPPER(?) AND NVL(DRUG_CLASS,'X') LIKE ? AND NVL(SCHEDULE_ID,'X') LIKE UPPER(?) AND NVL(RESTRICTED_DRUG_YN,'X') LIKE DECODE(?,'B',RESTRICTED_DRUG_YN,?) AND NVL(DRUG_TYPE,'X') LIKE DECODE(?,'A',DRUG_TYPE,?) AND NVL(IV_INGREDIENT_YN,'X') LIKE DECODE(?,'B',IV_INGREDIENT_YN,?) AND NVL(IV_FLUID_YN,'X') LIKE DECODE(?,'B',IV_FLUID_YN,?) AND NVL(COMPOUND_DRUG_YN,'X') LIKE DECODE(?,'B',COMPOUND_DRUG_YN,?) AND NVL(IN_FORMULARY_YN,'X') LIKE DECODE(?,'B',IN_FORMULARY_YN,?) AND NVL(AFFECTS_PREGNANCY_YN,'X') LIKE DECODE(?,'B',AFFECTS_PREGNANCY_YN,?) AND NVL(AFFECTS_LAB_RESULTS_YN,'X') LIKE DECODE(?,'B',AFFECTS_LAB_RESULTS_YN,?) AND NVL(AFFECTS_BREAST_FEEDING_YN,'X') LIKE DECODE(?,'B',AFFECTS_BREAST_FEEDING_YN,?) AND  UPPER(NVL(MANUFACTURER_ID,'X')) LIKE UPPER(?) AND UPPER(NVL(MANUFACTURER_NAME,'X')) LIKE UPPER(?) AND   UPPER(NVL(TRADE_CODE,'X')) LIKE UPPER(?)  AND LANG1 = ? AND DECODE(LANG2,NULL,?,LANG2)= ? AND  DECODE(LANG3,NULL,?,LANG3)= ? AND ph_drug_vw.LANG1 = e.LANGUAGE_ID AND ph_drug_vw.ROUTE_CODE= e.ROUTE_CODE "+queryAppend+" ORDER BY DRUG_DESC,FORM_DESC");// addedph_drug_vw.route_code, ph_drug_vw.route_desc ,E.ROUTE_COLOR AND ph_drug_vw.LANG1 = e.LANGUAGE_ID AND ph_drug_vw.ROUTE_CODE= e.ROUTE_CODE ,ph_route_lang_vw e for CRF RUT-CRF-0034.1[IN:037389],Modified for TFS id:7345 added DRUG_SEARCH_BY column
				}
				else{
					//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT")+" ORDER BY DRUG_DESC,FORM_DESC");
					//pstmt = connection.prepareStatement( "SELECT DRUG_CODE, ITEM_CODE, DRUG_DESC, FORM_CODE, FORM_DESC, STRENGTH_VALUE, STRENGTH_UOM, STRENGTH_UOM_DESC,STRENGTH_PER_PRES_UOM, STRENGTH_PER_VALUE_PRES_UOM,PRES_BASE_UOM,ROUTE_CODE, ROUTE_DESC,TRADE_NAME,GENERIC_NAME,GENERIC_ID,PRES_BASE_UOM,IN_FORMULARY_YN,TRADE_CODE,ITEM_CODE, DRUG_CLASS ,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id ='"+getLanguageId()+"' ) stock_uom_desc,ph_get_ext_prod_drug_code(PH_DRUG_VW.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID FROM  PH_DRUG_VW_LANG_VW PH_DRUG_VW WHERE DISCONTINUED_YN = 'N' AND UPPER(GENERIC_ID) LIKE UPPER(?) AND UPPER(GENERIC_NAME) LIKE UPPER(?) AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND UPPER(FORM_CODE) LIKE UPPER(?) AND UPPER(ROUTE_CODE) LIKE UPPER(?)   AND NVL(STRENGTH_UOM,'X') LIKE UPPER(?) AND NVL(DRUG_CLASS,'X') LIKE ? AND NVL(SCHEDULE_ID,'X') LIKE UPPER(?) AND NVL(RESTRICTED_DRUG_YN,'X') LIKE DECODE(?,'B',RESTRICTED_DRUG_YN,?) AND NVL(DRUG_TYPE,'X') LIKE DECODE(?,'A',DRUG_TYPE,?) AND NVL(IV_INGREDIENT_YN,'X') LIKE DECODE(?,'B',IV_INGREDIENT_YN,?) AND NVL(IV_FLUID_YN,'X') LIKE DECODE(?,'B',IV_FLUID_YN,?) AND NVL(COMPOUND_DRUG_YN,'X') LIKE DECODE(?,'B',COMPOUND_DRUG_YN,?) AND NVL(IN_FORMULARY_YN,'X') LIKE DECODE(?,'B',IN_FORMULARY_YN,?) AND NVL(AFFECTS_PREGNANCY_YN,'X') LIKE DECODE(?,'B',AFFECTS_PREGNANCY_YN,?) AND NVL(AFFECTS_LAB_RESULTS_YN,'X') LIKE DECODE(?,'B',AFFECTS_LAB_RESULTS_YN,?) AND NVL(AFFECTS_BREAST_FEEDING_YN,'X') LIKE DECODE(?,'B',AFFECTS_BREAST_FEEDING_YN,?) AND  UPPER(NVL(MANUFACTURER_ID,'X')) LIKE UPPER(?) AND UPPER(NVL(MANUFACTURER_NAME,'X')) LIKE UPPER(?) AND   UPPER(NVL(TRADE_CODE,'X')) LIKE UPPER(?) AND  UPPER(NVL(TRADE_NAME,'X')) LIKE UPPER(?) AND LANG1 = ? AND DECODE(LANG2,NULL,?,LANG2)= ? AND  DECODE(LANG3,NULL,?,LANG3)= ? "+queryAppend+" ORDER BY DRUG_DESC,FORM_DESC");
					//PH_DRUG_VW.STRENGTH_UOM DRUG_STRENGTH FOR GHL-CRF-0548
					pstmt = connection.prepareStatement( "SELECT DISTINCT PH_DRUG_VW.DRUG_CODE, PH_DRUG_VW.STRENGTH_UOM DRUG_STRENGTH,ITEM_CODE, DRUG_DESC, FORM_CODE, FORM_DESC, STRENGTH_VALUE, PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',STRENGTH_UOM,'"+getLanguageId()+"') STRENGTH_UOM, STRENGTH_UOM_DESC,STRENGTH_PER_PRES_UOM, STRENGTH_PER_VALUE_PRES_UOM,PRES_BASE_UOM,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',PRES_BASE_UOM,'"+getLanguageId()+"') PRES_BASE_UOM1,ph_drug_vw.route_code, ph_drug_vw.route_desc,TRADE_NAME,GENERIC_NAME,GENERIC_ID,PRES_BASE_UOM,IN_FORMULARY_YN,TRADE_CODE,ITEM_CODE, DRUG_CLASS ,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id ='"+getLanguageId()+"' ) stock_uom_desc,ph_get_ext_prod_drug_code(PH_DRUG_VW.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID,E.ROUTE_COLOR,PH_DRUG_VW.DRUG_SEARCH_BY FROM  PH_DRUG_VW_LANG_VW PH_DRUG_VW, PH_DRUG_SYNONYM_lang snm,ph_route_lang_vw e WHERE DRUG_YN = 'Y' AND DISCONTINUED_YN = 'N' AND UPPER(GENERIC_ID) LIKE UPPER(?) AND UPPER(GENERIC_NAME) LIKE UPPER(?) AND UPPER(PH_DRUG_VW.DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND UPPER(FORM_CODE) LIKE UPPER(?) AND UPPER(ph_drug_vw.ROUTE_CODE) LIKE UPPER(?)   AND NVL(STRENGTH_UOM,'X') LIKE UPPER(?) AND NVL(DRUG_CLASS,'X') LIKE ? AND NVL(SCHEDULE_ID,'X') LIKE UPPER(?) AND NVL(RESTRICTED_DRUG_YN,'X') LIKE DECODE(?,'B',RESTRICTED_DRUG_YN,?) AND NVL(DRUG_TYPE,'X') LIKE DECODE(?,'A',DRUG_TYPE,?) AND NVL(IV_INGREDIENT_YN,'X') LIKE DECODE(?,'B',IV_INGREDIENT_YN,?) AND NVL(IV_FLUID_YN,'X') LIKE DECODE(?,'B',IV_FLUID_YN,?) AND NVL(COMPOUND_DRUG_YN,'X') LIKE DECODE(?,'B',COMPOUND_DRUG_YN,?) AND NVL(IN_FORMULARY_YN,'X') LIKE DECODE(?,'B',IN_FORMULARY_YN,?) AND NVL(AFFECTS_PREGNANCY_YN,'X') LIKE DECODE(?,'B',AFFECTS_PREGNANCY_YN,?) AND NVL(AFFECTS_LAB_RESULTS_YN,'X') LIKE DECODE(?,'B',AFFECTS_LAB_RESULTS_YN,?) AND NVL(AFFECTS_BREAST_FEEDING_YN,'X') LIKE DECODE(?,'B',AFFECTS_BREAST_FEEDING_YN,?) AND  UPPER(NVL(MANUFACTURER_ID,'X')) LIKE UPPER(?) AND UPPER(NVL(MANUFACTURER_NAME,'X')) LIKE UPPER(?) AND   UPPER(NVL(TRADE_CODE,'X')) LIKE UPPER(?) AND  UPPER(NVL(TRADE_NAME,'X')) LIKE UPPER(?) AND LANG1 = ? AND DECODE(LANG2,NULL,?,LANG2)= ? AND  DECODE(LANG3,NULL,?,LANG3)= ? AND ph_drug_vw.LANG1 = e.LANGUAGE_ID AND ph_drug_vw.ROUTE_CODE= e.ROUTE_CODE "+queryAppend+" ORDER BY DRUG_DESC,FORM_DESC");// addedph_drug_vw.route_code, ph_drug_vw.route_desc ,E.ROUTE_COLOR AND ph_drug_vw.LANG1 = e.LANGUAGE_ID AND ph_drug_vw.ROUTE_CODE= e.ROUTE_CODE ,ph_route_lang_vw e for CRF RUT-CRF-0034.1[IN:037389],Modified for TFS id:7345 added DRUG_SEARCH_BY column
				}


				if (search_by.equals("G")){
					drug_id="";
					drug_desc="%";
					generic_id=code;
					if(drug_search_by.equals("S"))
						generic_name = name+"%";  
					else if(drug_search_by.equals("C"))
						generic_name = "%"+name+"%";
					else                    
						generic_name = "%"+name;
					//generic_name = "%"+name+"%";
					trade_id="";
					trade_desc="%";
					synonym="%";
				}
				else if (search_by.equals("D")){
					drug_id=code;
					//drug_desc="%"+name+"%";
					if(drug_search_by.equals("S"))
						drug_desc = name+"%";  
					else if(drug_search_by.equals("C"))
						drug_desc = "%"+name+"%";
					else                      
						drug_desc = "%"+name;

					generic_id="";
					generic_name = "%";
					trade_id="";
					trade_desc="%";
					synonym="%";
				}
				else if (search_by.equals("T")){
					drug_id="";
					drug_desc="%";
					generic_id="";
					generic_name = "%";
					trade_id=code;
					//trade_desc="%"+name+"%";
					if(drug_search_by.equals("S"))
						trade_desc = name+"%";  
					else if(drug_search_by.equals("C"))
						trade_desc = "%"+name+"%";
					else                    
						trade_desc = "%"+name;
					synonym="%";
				}
				else if (search_by.equals("C")){
					drug_id="";
					drug_desc="%";
					generic_id="";
					generic_name = "%";
					trade_id="%";
					trade_desc="%";
					if(drug_search_by.equals("S"))
						synonym = name+"%";  
					else if(drug_search_by.equals("C"))
						synonym = "%"+name+"%";
					else                    
						synonym = "%"+name;
				}
				else if (search_by.equals("A")){
					drug_id		="";
					generic_id	="";
					trade_id	="";
					if(drug_search_by.equals("S")){
						drug_desc = name+"%";  
						trade_desc = name+"%"; 
						generic_name = name+"%";  
						synonym = name+"%";  
					}
					else if(drug_search_by.equals("C")){
						drug_desc = "%"+name+"%";
						trade_desc = "%"+name+"%";
						generic_name = "%"+name+"%";
						synonym = "%"+name+"%";
					}
					else{                      
						drug_desc = "%"+name;
						trade_desc = "%"+name;
						generic_name = "%"+name;
						synonym = "%"+name;
					}
				}

				if (generic_id.equals(""))
					generic_id = "%";
				if (drug_id.equals(""))
					drug_id = "%";
				if (trade_id.equals(""))
					trade_id = "%";
				if (form_code.equals(""))
					form_code	=	"%";
				if (route_code.equals(""))
					route_code	=	"%";
				
				if (strength_uom.equals(""))
					strength_uom = "%";
				if (drug_class.equals(""))
					drug_class = "%";
				if (schedule_id.equals(""))
					schedule_id = "%";
				if (manufacturer_code.equals(""))
					manufacturer_code = "%";
				if (manufacturer_short_name.equals(""))
					temp_manufacturer_short_name = "%";
				else
					temp_manufacturer_short_name = manufacturer_short_name;

				if(!getGeneric_id_alternate().equals("null") && !getGeneric_id_alternate().equals(""))//added for  JD-CRF-0198 [IN:058599]
					generic_id = getGeneric_id_alternate();
				if (search_by.equals("A")){
					pstmt.setString(1,generic_id.trim());
					pstmt.setString(2,generic_name.trim());
					pstmt.setString(3,drug_desc.trim());
					pstmt.setString(4,trade_desc.trim());
					pstmt.setString(5,drug_id.trim());
					pstmt.setString(6,form_code.trim());
					pstmt.setString(7,route_code.trim());
					pstmt.setString(8,strength_uom.trim());
					pstmt.setString(9,drug_class.trim());
					pstmt.setString(10,schedule_id.trim());
					pstmt.setString(11,non_essential_restricted.trim());
					pstmt.setString(12,non_essential_restricted.trim());
					pstmt.setString(13,drug_type);
					pstmt.setString(14,drug_type);
					pstmt.setString(15,ingredient.trim());
					pstmt.setString(16,ingredient.trim());
					pstmt.setString(17,fluid.trim());
					pstmt.setString(18,fluid.trim());
					pstmt.setString(19,compound.trim());
					pstmt.setString(20,compound.trim());
					pstmt.setString(21,formulary.trim());
					pstmt.setString(22,formulary.trim());
					pstmt.setString(23,affects_pregnancy.trim());
					pstmt.setString(24,affects_pregnancy.trim());
					pstmt.setString(25,affects_lab_results.trim());
					pstmt.setString(26,affects_lab_results.trim());
					pstmt.setString(27,affects_breast_feed.trim());
					pstmt.setString(28,affects_breast_feed.trim());
					pstmt.setString(29,manufacturer_code.trim());
					pstmt.setString(30,temp_manufacturer_short_name.trim());
					pstmt.setString(31,trade_id.trim());
					pstmt.setString(31,trade_id.trim());
					pstmt.setString(32,getLanguageId());
					pstmt.setString(33,getLanguageId());
					pstmt.setString(34,getLanguageId());
					pstmt.setString(35,getLanguageId());
					pstmt.setString(36,getLanguageId());
					pstmt.setString(37,synonym);
					if (strength1_value > 0)
					{
						pstmt.setDouble(38,strength1_value);
					}
				}
				else{
					pstmt.setString(1,generic_id.trim());
					pstmt.setString(2,generic_name.trim());
					pstmt.setString(3,drug_id.trim());
					pstmt.setString(4,drug_desc.trim());
					pstmt.setString(5,form_code.trim());
					pstmt.setString(6,route_code.trim());
					//pstmt.setString(7,strength_value.trim());
					pstmt.setString(7,strength_uom.trim());
					pstmt.setString(8,drug_class.trim());
					pstmt.setString(9,schedule_id.trim());
					pstmt.setString(10,non_essential_restricted.trim());
					pstmt.setString(11,non_essential_restricted.trim());
					pstmt.setString(12,drug_type);
					pstmt.setString(13,drug_type);
					pstmt.setString(14,ingredient.trim());
					pstmt.setString(15,ingredient.trim());
					pstmt.setString(16,fluid.trim());
					pstmt.setString(17,fluid.trim());
					pstmt.setString(18,compound.trim());
					pstmt.setString(19,compound.trim());
					pstmt.setString(20,formulary.trim());
					pstmt.setString(21,formulary.trim());
					pstmt.setString(22,affects_pregnancy.trim());
					pstmt.setString(23,affects_pregnancy.trim());
					pstmt.setString(24,affects_lab_results.trim());
					pstmt.setString(25,affects_lab_results.trim());
					pstmt.setString(26,affects_breast_feed.trim());
					pstmt.setString(27,affects_breast_feed.trim());
					pstmt.setString(28,manufacturer_code.trim());
					pstmt.setString(29,temp_manufacturer_short_name.trim());
					pstmt.setString(30,trade_id.trim());
					pstmt.setString(31,trade_desc.trim());
					pstmt.setString(32,getLanguageId());
					pstmt.setString(33,getLanguageId());
					pstmt.setString(34,getLanguageId());
					pstmt.setString(35,getLanguageId());
					pstmt.setString(36,getLanguageId());
					pstmt.setString(37,synonym);
					if (strength1_value > 0){
						pstmt.setDouble(38,strength1_value);
					}
					//System.out.println("==1036==generic_id=="+generic_id+"==generic_name=="+generic_name+"==drug_id=="+drug_id+"==drug_desc=="+drug_desc+"==form_code=="+form_code+"==route_code=="+route_code+"==strength_uom=="+strength_uom+"==drug_class=="+drug_class+"==schedule_id=="+schedule_id+"==non_essential_restricted=="+non_essential_restricted+"==drug_type=="+drug_type+"==drug_type=="+drug_type+"==ingredient=="+ingredient+"==ingredient=="+ingredient+"==fluid=="+fluid+"==fluid=="+fluid+"===compound=="+compound+"==compound=="+compound+"==formulary=="+formulary+"==formulary=="+formulary+"==affects_pregnancy=="+affects_pregnancy+"==affects_pregnancy=="+affects_pregnancy+"==affects_lab_results=="+affects_lab_results+"==affects_lab_results=="+affects_lab_results+"==affects_breast_feed=="+affects_breast_feed+"==affects_breast_feed=="+affects_breast_feed+"==manufacturer_code=="+manufacturer_code+"==temp_manufacturer_short_name=="+temp_manufacturer_short_name+"==trade_id=="+trade_id+"==trade_desc=="+trade_desc+"==getLanguageId=="+getLanguageId()+"strength1_value=="+strength1_value);
				}

				resultSet = pstmt.executeQuery() ;
			}
			else if (identity.equals("MedicationOrder")){
				String strAppend = "";
				String cmp_fld_codes = "";
				String cmp_fld_flag  = "Y";
				if (search_by.equals("C")){
					queryAppend = "AND snm.DRUG_CODE=B.DRUG_CODE AND snm.EFF_STATUS='E' AND upper(SNM.DRUG_SYNONYM_DESC) LIKE upper(?) AND snm.LANGUAGE_ID=B.LANGUAGE_ID";
				}
				else 
					queryAppend = "AND snm.DRUG_CODE(+)=B.DRUG_CODE AND snm.EFF_STATUS(+)='E' AND upper(SNM.DRUG_SYNONYM_DESC(+)) LIKE upper(?) AND snm.LANGUAGE_ID(+)=B.LANGUAGE_ID";

				if (strength1_value > 0){
					queryAppend += " and STRENGTH_VALUE = ? ";
				}
				
				if( getNPBDrug()!=null && getNPBDrug().equals("E") )/* code added for Bru-HIMS-CRF-070 [IN029935] --Start --*/	
					queryAppend += " and exists( select 1 from ph_npb_drug_request where patient_id='"+getPatientId()+"' and REQUEST_STATUS='P' AND APPROVED_DRUG_CODE=B.DRUG_CODE and trunc(DRUG_VALIDITY_DATE) >= trunc(sysdate) AND B.NPB_DRUG_YN = 'Y' )";
				else 
					queryAppend += " and B.NPB_DRUG_YN = 'N' ";	/* code added for Bru-HIMS-CRF-070 [IN029935] --End --*/		

			// Executing procedure PH_Get_Fluid_Code for finding the compatible fluid list by passing the drug codes
				if(getDrugOrFluid().equals("F") || getDrugOrFluid().equals("C")){

					if(!sel_drg_codes.equals("")){
						cstmt=connection.prepareCall("{call  PH_Get_Fluid_Code (?,?)}");
						cstmt.setString( 1, sel_drg_codes);
						cstmt.registerOutParameter(2, Types.VARCHAR );
						cstmt.execute() ;
						cmp_fld_codes = cstmt.getString(2);
						if (cmp_fld_codes == null){ 
							cmp_fld_codes = "";cmp_fld_flag  = "N";
						}
						try{
							closeStatement( cstmt ) ;
						}catch(Exception es){
							es.printStackTrace();
						}

					}
					else{
						cmp_fld_flag  = "N";
					}
				}
				else if(getDrugOrFluid().equals("IVF")){
					cmp_fld_flag  = "Y";
				}
			// Procedure ends here

			    pstmt	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT22B"));
			    pstmt.setString(1, practitionerId); //login_by_id replaced with practitionerId  for ML-BRU-SCF-0958 [IN:042045]

			    resultSet	= pstmt.executeQuery();
			    if (resultSet != null && resultSet.next()) {
					pract_type=resultSet.getString("PRACT_TYPE");

				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
		
		//FOR FILTRING VALUES BASED APPL_TO_VERBAL_ORDER_YN FLAG IN PH_DRUG----11/25/2004
				if(pract_type.equals("NS")){
					strAppend = " AND B.APPL_TO_VERBAL_ORDER_YN='Y' ";
				}

				if (search_by.equals("G")){
					drug_id		=	"";
					drug_desc	=	"%";
					generic_id	=	code;
					//generic_name = "%"+name+"%";
					if(drug_search_by.equals("S"))
						generic_name = name+"%";  
					else if(drug_search_by.equals("C"))
						generic_name = "%"+name+"%";
					else                     
						generic_name = "%"+name;
					
					trade_id	= "";
					trade_desc	= "%";
					synonym	= "%";
				}
				else if (search_by.equals("D")){
					drug_id		=	code;
					//drug_desc	=	 "%"+name+"%";
					if(drug_search_by.equals("S"))
						drug_desc = name+"%";  
					else if(drug_search_by.equals("C"))
                         drug_desc = "%"+name+"%";
					else                       
						drug_desc = "%"+name;

					generic_id	=	"";
					generic_name = "%";
					trade_id	=	"";
					trade_desc	=	"%";
					synonym	=	"%";
				}
				else if (search_by.equals("T")){
					drug_id		=	"";
					drug_desc	=	"%";
					generic_id	=	"";
					generic_name = "%";
					trade_id	 =	code;
					//trade_desc	 =	 "%"+name+"%";
					if(drug_search_by.equals("S"))
						trade_desc = name+"%";  
					else if(drug_search_by.equals("C"))
						trade_desc = "%"+name+"%";
					else                      
						trade_desc = "%"+name;
					synonym = "%";
				}
				else if (search_by.equals("C")){
					drug_id="";
					drug_desc="%";
					generic_id="";
					generic_name = "%";
					trade_id="%";
					trade_desc="%";
					if(drug_search_by.equals("S"))
						synonym = name+"%";  
					else if(drug_search_by.equals("C"))
						synonym = "%"+name+"%";
					else                    
						synonym = "%"+name;
				}
				else if (search_by.equals("A")){
					drug_id		=	"";
					generic_id	=	"";
					trade_id	 =	"";
			
					if(drug_search_by.equals("S")){
					   drug_desc = name+"%";
					   trade_desc = name+"%";
   					   generic_name = name+"%";
   					   synonym = name+"%";
					}
					else if(drug_search_by.equals("C")){
					    drug_desc = "%"+name+"%";
					    trade_desc = "%"+name+"%";
					    generic_name = "%"+name+"%";
					    synonym = "%"+name+"%";
					}
					else {
                        drug_desc = "%"+name;
                        trade_desc = "%"+name;
                        generic_name = "%"+name;
                        synonym = "%"+name;
					}
				}
				if(!getGeneric_id_alternate().equals("null")&& !getGeneric_id_alternate().equals(""))//added for  JD-CRF-0198 [IN:058599]
					generic_id = getGeneric_id_alternate();
				if(getIVMedicationType().equals("IVA") || getIVMedicationType().equals("") ){
					if(getDrugOrFluid().equals("D")){		//Drug
//						strAppend = " AND J.DFLT_IV_ROUTE_CODE = B.ROUTE_CODE  AND ( (B.IV_FLUID_YN='N' AND B.IV_INGREDIENT_YN='Y') OR (B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='Y') ) ";
						strAppend = " AND DECODE(J.DFLT_IV_ROUTE_CODE,NULL,'X',J.DFLT_IV_ROUTE_CODE) IN (SELECT PRFF.ROUTE_CODE FROM PH_ROUTE_FOR_FORM PRFF WHERE PRFF.FORM_CODE = B.FORM_CODE)  AND ( (B.IV_FLUID_YN='N' AND B.IV_INGREDIENT_YN='Y') OR (B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='Y') ) ";
						
					}
					else if(getDrugOrFluid().equals("F") || getDrugOrFluid().equals("IVF")){	//F - Fluid,  IVF -  IVFluids(without additivs)
						//strAppend = " AND DECODE(J.DFLT_IV_ROUTE_CODE,NULL,'X',J.DFLT_IV_ROUTE_CODE) IN (SELECT PRFF.ROUTE_CODE FROM PH_ROUTE_FOR_FORM PRFF WHERE PRFF.FORM_CODE = B.FORM_CODE)  AND B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='N'  ";
						strAppend = " AND B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='N'  ";
					}
					else if(getDrugOrFluid().equals("C")){  // Cyto
						strAppend = " AND DECODE(J.DFLT_IV_ROUTE_CODE,NULL,'X',J.DFLT_IV_ROUTE_CODE) IN (SELECT PRFF.ROUTE_CODE FROM PH_ROUTE_FOR_FORM PRFF WHERE PRFF.FORM_CODE = B.FORM_CODE) AND B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='N'  AND B.IV_FLUID_FOR_ONCO_YN='Y'";
					}
					else if(getDrugOrFluid().equals("CO")){  // Compounding
						strAppend = " AND B.APPL_FOR_COMPOUNDING_RX_YN = 'Y'";
					} else {

                         if(getcalledfrom().equals("DIRECT")){
							strAppend = strAppend +"  and DISP_VIA_PRES_ONLY_YN ='N' ";
						 }

						//strAppend = " AND B.ROUTE_CODE = K.ROUTE_CODE(+) ";
						//Normal Rx lookup.
					}
				}
				else if(getIVMedicationType().equals("IVD")){
					if(getDrugOrFluid().equals("D")){		//Drug
						strAppend = " AND DECODE(J.DFLT_IV_ROUTE_CODE,NULL,'X',J.DFLT_IV_ROUTE_CODE) IN (SELECT PRFF.ROUTE_CODE FROM PH_ROUTE_FOR_FORM PRFF WHERE PRFF.FORM_CODE = B.FORM_CODE) AND ((B.IV_FLUID_YN='N' AND B.IV_INGREDIENT_YN='Y') OR (B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='Y'))";
					}
					else if(getDrugOrFluid().equals("F")){	//Fluid
						strAppend = " AND DECODE(J.DFLT_IV_ROUTE_CODE,NULL,'X',J.DFLT_IV_ROUTE_CODE) IN (SELECT PRFF.ROUTE_CODE FROM PH_ROUTE_FOR_FORM PRFF WHERE PRFF.FORM_CODE = B.FORM_CODE) AND B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='N' ";
					}
				}

				if(res_by_service==null){
					res_by_service="";
				}
				if(res_by_service.equals("Y")){
					strAppend =strAppend+ " AND B.GENERIC_ID IN (SELECT DISTINCT GENERIC_ID FROM PH_GENERIC_NAME_FOR_SERVICE WHERE SERVICE_CODE LIKE DECODE(?,NULL,'%',SERVICE_CODE))";
				}

				if(in_formulary_yn==null){
					in_formulary_yn="";
				}
				else if(in_formulary_yn.equals("Y")){
					strAppend =strAppend+ " AND B.IN_FORMULARY_YN='Y' ";
				}
				else if (in_formulary_yn.equals("N")){
					strAppend =strAppend+ " AND B.IN_FORMULARY_YN='N' ";
				}
				
				if(!order_type_code.trim().equals("")) {
					strAppend =strAppend+ " AND A.ORDER_TYPE_CODE= ? ";
				} 

				if(!cmp_fld_codes.equals("")){
					strAppend =strAppend+ " AND NVL(B.DRUG_CODE,F.DRUG_CODE) in (";
					//strAppend =strAppend+ " AND B.DRUG_CODE in (";
					strAppend =strAppend+ cmp_fld_codes;
					strAppend =strAppend+ " )";
				}
/*=================================================================================*/
				if(getCalled_from_verbal_order().equals("Y")){
					strAppend = " AND B.APPL_TO_VERBAL_ORDER_YN='Y' ";
				}
/*=================================================================================*/

				if(!cmp_fld_flag.equals("N")){	

					String qryAppend ="";
					String sqlQry ="";
					String encounterId = getEncounterId(); // Added for 51127
					System.out.println("Encounter ID = "+encounterId);
					if (priviligeDrugCheck.equals("S")){
						qryAppend = " AND or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') = 'Y' ";
					}
					if (search_by.equals("A")){
						//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ALL_DRUG_SEARCH_ORDER_TYPE_SELECT")+strAppend +" ORDER BY B.DRUG_DESC,C.FORM_DESC");
						//System.out.println("==1170==="+PhRepository.getPhKeyValue("SQL_PH_ALL_DRUG_SEARCH_ORDER_TYPE_SELECT")+strAppend +" ORDER BY B.DRUG_DESC,C.FORM_DESC");
						//sqlQry ="SELECT  B.DRUG_CODE,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,B.STRENGTH_UOM,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM, D.SHORT_DESC STRENGTH_UOM_DESC, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN, or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') PRIV_APPL_YN ,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id =b.language_id ) stock_uom_desc,ph_get_ext_prod_drug_code(B.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,AM_UOM_LANG_VW D,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_CATALOG_BY_PTCL_LANG_VW I,PH_PARAM_LANG_VW J WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' 	AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND D.UOM_CODE(+) = B.STRENGTH_UOM AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  AND B.GENERIC_ID = NVL(?,B.GENERIC_ID)	AND (UPPER(H.GENERIC_NAME) LIKE UPPER(NVL(?,H.GENERIC_NAME)) OR UPPER(B.DRUG_DESC) LIKE UPPER(NVL(?,B.DRUG_DESC)) OR NVL(UPPER(G.SHORT_NAME),'X') LIKE DECODE(UPPER(?),'X',NVL(UPPER(G.SHORT_NAME),'X'),UPPER(?))) AND UPPER(B.DRUG_CODE) =UPPER(NVL(?,B.DRUG_CODE)) AND UPPER(B.FORM_CODE) = UPPER(NVL(?,B.FORM_CODE))  AND B.ROUTE_CODE = NVL(?,B.ROUTE_CODE) AND NVL(F.TRADE_CODE,'X') LIKE DECODE(?,'X',NVL(F.TRADE_CODE,'X'),?)AND NVL(B.STRENGTH_UOM,'X') LIKE DECODE(?,'X',B.STRENGTH_UOM,?)  AND  I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE "+qryAppend+" AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ?"+strAppend +" "+queryAppend+" ORDER BY B.DRUG_DESC,C.FORM_DESC";
/*Added for PE by Naveen 1.PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',B.STRENGTH_UOM) STRENGTH_UOM
                          2.PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',PRES_BASE_UOM) PRES_BASE_UOM1,*/
						//sqlQry ="SELECT  B.DRUG_CODE,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',B.STRENGTH_UOM) STRENGTH_UOM ,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',b.PRES_BASE_UOM) PRES_BASE_UOM1, D.SHORT_DESC STRENGTH_UOM_DESC, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN, or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') PRIV_APPL_YN ,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id =b.language_id ) stock_uom_desc,ph_get_ext_prod_drug_code(B.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,AM_UOM_LANG_VW D,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_CATALOG_BY_PTCL_LANG_VW I,PH_PARAM_LANG_VW J WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' 	AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND D.UOM_CODE(+) = B.STRENGTH_UOM AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  AND B.GENERIC_ID = NVL(?,B.GENERIC_ID)	AND (UPPER(H.GENERIC_NAME) LIKE UPPER(NVL(?,H.GENERIC_NAME)) OR UPPER(B.DRUG_DESC) LIKE UPPER(NVL(?,B.DRUG_DESC)) OR NVL(UPPER(G.SHORT_NAME),'X') LIKE DECODE(UPPER(?),'X',NVL(UPPER(G.SHORT_NAME),'X'),UPPER(?))) AND UPPER(B.DRUG_CODE) =UPPER(NVL(?,B.DRUG_CODE)) AND UPPER(B.FORM_CODE) = UPPER(NVL(?,B.FORM_CODE))  AND B.ROUTE_CODE = NVL(?,B.ROUTE_CODE) AND NVL(F.TRADE_CODE,'X') LIKE DECODE(?,'X',NVL(F.TRADE_CODE,'X'),?)AND NVL(B.STRENGTH_UOM,'X') LIKE DECODE(?,'X',B.STRENGTH_UOM,?)  AND  I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE "+qryAppend+" AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ?"+strAppend +" "+queryAppend+" ORDER BY B.DRUG_DESC,C.FORM_DESC";
//, D.SHORT_DESC STRENGTH_UOM_DESC
						// B.STRENGTH_UOM DRUG_STRENGTH, ADDED FOR GHL-CRF-0548
						//Modified for TFS id:7345 start
						if(getPreAllocAppl()){
                        	System.out.println("Inside mms-177 changes");
                        	if(search_by_generic_or_trade.equals("G")){  //Added for NMC-JD-SCF-0159 - Start
                        		//sqlQry ="SELECT distinct B.DRUG_CODE,B.STRENGTH_UOM DRUG_STRENGTH,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',B.STRENGTH_UOM,'"+getLanguageId()+"') STRENGTH_UOM ,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',b.PRES_BASE_UOM,'"+getLanguageId()+"') PRES_BASE_UOM1, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT DISTINCT 'Y' FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ? AND pr_diag.curr_status!='E'  ##DIAGNOSISLEVEL## ), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN, or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') PRIV_APPL_YN ,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id =b.language_id ) stock_uom_desc,ph_get_ext_prod_drug_code(B.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID,B.BILLABLE_ITEM_YN, B.NPB_DRUG_YN,E.ROUTE_COLOR,B.DRUG_SEARCH_BY FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_ORDER_CATALOG_BY_PTCL I,PH_PARAM J, PH_DRUG_SYNONYM_lang snm  WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  AND B.GENERIC_ID = NVL(?,B.GENERIC_ID)	AND H.GENERIC_ID=? AND UPPER(B.DRUG_CODE) =UPPER(NVL(?,B.DRUG_CODE)) AND UPPER(B.FORM_CODE) = UPPER(NVL(?,B.FORM_CODE))  AND B.ROUTE_CODE = NVL(?,B.ROUTE_CODE) AND NVL(F.TRADE_CODE,'X') LIKE DECODE(?,'X',NVL(F.TRADE_CODE,'X'),?)AND NVL(B.STRENGTH_UOM,'X') LIKE DECODE(?,'X',B.STRENGTH_UOM,?)  AND  I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE "+qryAppend+" AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID   AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ?  AND G.LANGUAGE_ID(+) = ?"+strAppend +" "+queryAppend+" ORDER BY h.generic_name,C.FORM_DESC";// added E.ROUTE_COLOR for CRF RUT-CRF-0034.1[IN:037389]-end //pr_diag.curr_status!='E' added for MMS-JU-SCF-0200  //pr_diag.CURR_ENCOUNTER_ID added MMS-DM-SCF-0806
                        	//modified for MMS-DM-CRF-0209.1
                        		sqlQry ="SELECT distinct B.DRUG_CODE,B.STRENGTH_UOM DRUG_STRENGTH,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',B.STRENGTH_UOM,'"+getLanguageId()+"') STRENGTH_UOM ,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',b.PRES_BASE_UOM,'"+getLanguageId()+"') PRES_BASE_UOM1, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT DISTINCT 'Y' FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ? AND pr_diag.curr_status!='E'  ##DIAGNOSISLEVEL## ), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN, or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') PRIV_APPL_YN ,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id =b.language_id ) stock_uom_desc,ph_get_ext_prod_drug_code(B.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID,B.BILLABLE_ITEM_YN, B.NPB_DRUG_YN,E.ROUTE_COLOR,B.DRUG_SEARCH_BY,bl_get_item_agreement_yn (?,?,?,?,?,?,?,b.item_code) bl_agreed_item_yn,NVL ((SELECT 'Y' FROM mm_item WHERE item_code = b.drug_code AND category_code = 'G'),'N') mm_generic_item_yn, NVL ((SELECT 'Y' FROM mm_item WHERE item_code = b.drug_code AND category_code = 'B'AND alternate_yn = 'Y'),'N') mm_brand_item_yn,(  select min(expiry_date_or_receipt_date) from st_item_batch where item_code =b.drug_code  ) expiry_date FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_ORDER_CATALOG_BY_PTCL I,PH_PARAM J, PH_DRUG_SYNONYM_lang snm  WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  AND B.GENERIC_ID = NVL(?,B.GENERIC_ID)	AND H.GENERIC_ID=? AND UPPER(B.DRUG_CODE) =UPPER(NVL(?,B.DRUG_CODE)) AND UPPER(B.FORM_CODE) = UPPER(NVL(?,B.FORM_CODE))  AND B.ROUTE_CODE = NVL(?,B.ROUTE_CODE) AND NVL(F.TRADE_CODE,'X') LIKE DECODE(?,'X',NVL(F.TRADE_CODE,'X'),?)AND NVL(B.STRENGTH_UOM,'X') LIKE DECODE(?,'X',B.STRENGTH_UOM,?)  AND  I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE "+qryAppend+" AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID   AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ?  AND G.LANGUAGE_ID(+) = ?"+strAppend +" "+queryAppend+"ORDER BY (CASE WHEN bl_agreed_item_yn = 'Y' THEN 1 ELSE 0  END) DESC,(CASE WHEN mm_generic_item_yn = 'Y' THEN 1 ELSE 0 END) DESC,(CASE WHEN mm_brand_item_yn = 'Y' THEN 1 ELSE 0 END) DESC,expiry_date asc, b.drug_desc, c.form_desc ";// added E.ROUTE_COLOR for CRF RUT-CRF-0034.1[IN:037389]-end //pr_diag.curr_status!='E' added for MMS-JU-SCF-0200  //pr_diag.CURR_ENCOUNTER_ID added MMS-DM-SCF-0806
								
                        		
                        		
                        		//B.STOCK_UOM added for NMC-JD-CRF-0124
                        	}
                        	else if(search_by_generic_or_trade.equals("T")){
                        		//modified for MMS-DM-CRF-0209.1
                        		sqlQry ="SELECT distinct B.DRUG_CODE,B.STRENGTH_UOM DRUG_STRENGTH,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',B.STRENGTH_UOM,'"+getLanguageId()+"') STRENGTH_UOM ,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',b.PRES_BASE_UOM,'"+getLanguageId()+"') PRES_BASE_UOM1, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT  DISTINCT 'Y' FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ? AND pr_diag.curr_status!='E'  ##DIAGNOSISLEVEL## ), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN, or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') PRIV_APPL_YN ,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id =b.language_id ) stock_uom_desc,ph_get_ext_prod_drug_code(B.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID,B.BILLABLE_ITEM_YN, B.NPB_DRUG_YN,E.ROUTE_COLOR,B.DRUG_SEARCH_BY,bl_get_item_agreement_yn (?,?,?,?,?,?,?,b.item_code) bl_agreed_item_yn,NVL ((SELECT 'Y' FROM mm_item WHERE item_code = b.drug_code AND category_code = 'G'),'N') mm_generic_item_yn, NVL ((SELECT 'Y' FROM mm_item WHERE item_code = b.drug_code AND category_code = 'B'AND alternate_yn = 'Y'),'N') mm_brand_item_yn,(  select min(expiry_date_or_receipt_date) from st_item_batch where item_code =b.drug_code  ) expiry_date FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_ORDER_CATALOG_BY_PTCL I,PH_PARAM J, PH_DRUG_SYNONYM_lang snm  WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  AND B.GENERIC_ID = NVL(?,B.GENERIC_ID)	AND G.TRADE_ID=? AND b.drug_search_by = 'T' AND UPPER(B.DRUG_CODE) =UPPER(NVL(?,B.DRUG_CODE)) AND UPPER(B.FORM_CODE) = UPPER(NVL(?,B.FORM_CODE))  AND B.ROUTE_CODE = NVL(?,B.ROUTE_CODE) AND NVL(F.TRADE_CODE,'X') LIKE DECODE(?,'X',NVL(F.TRADE_CODE,'X'),?)AND NVL(B.STRENGTH_UOM,'X') LIKE DECODE(?,'X',B.STRENGTH_UOM,?)  AND  I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE "+qryAppend+" AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID   AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ?  AND G.LANGUAGE_ID(+) = ?"+strAppend +" "+queryAppend+" ORDER BY (CASE WHEN bl_agreed_item_yn = 'Y' THEN 1 ELSE 0  END) DESC,(CASE WHEN mm_generic_item_yn = 'Y' THEN 1 ELSE 0 END) DESC,(CASE WHEN mm_brand_item_yn = 'Y' THEN 1 ELSE 0 END) DESC,expiry_date asc, b.drug_desc, c.form_desc";// added E.ROUTE_COLOR for CRF RUT-CRF-0034.1[IN:037389]-end //modified for NMC-JD-ICN-0017 //pr_diag.curr_status!='E' added for MMS-JU-SCF-0200 //pr_diag.CURR_ENCOUNTER_ID added MMS-DM-SCF-0806
								//B.STOCK_UOM added for NMC-JD-CRF-0124
                        	}
                        	else{//modified for MMS-DM-CRF-0209.1
                        	sqlQry ="SELECT distinct B.DRUG_CODE,B.STRENGTH_UOM DRUG_STRENGTH,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',B.STRENGTH_UOM,'"+getLanguageId()+"') STRENGTH_UOM ,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',b.PRES_BASE_UOM,'"+getLanguageId()+"') PRES_BASE_UOM1, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT DISTINCT 'Y' FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ? AND pr_diag.curr_status!='E'  ##DIAGNOSISLEVEL## ), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN, or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') PRIV_APPL_YN ,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id =b.language_id ) stock_uom_desc,ph_get_ext_prod_drug_code(B.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID,B.BILLABLE_ITEM_YN, B.NPB_DRUG_YN,E.ROUTE_COLOR,B.DRUG_SEARCH_BY,bl_get_item_agreement_yn (?,?,?,?,?,?,?,b.item_code) bl_agreed_item_yn,NVL ((SELECT 'Y' FROM mm_item WHERE item_code = b.drug_code AND category_code = 'G'),'N') mm_generic_item_yn, NVL ((SELECT 'Y' FROM mm_item WHERE item_code = b.drug_code AND category_code = 'B'AND alternate_yn = 'Y'),'N') mm_brand_item_yn,(  select min(expiry_date_or_receipt_date) from st_item_batch where item_code =b.drug_code  ) expiry_date FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_ORDER_CATALOG_BY_PTCL I,PH_PARAM J, PH_DRUG_SYNONYM_lang snm  WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  AND B.GENERIC_ID = NVL(?,B.GENERIC_ID)	AND (UPPER(H.GENERIC_NAME) LIKE UPPER(NVL(?,H.GENERIC_NAME))  OR (NVL(UPPER(G.SHORT_NAME),'X') LIKE DECODE(UPPER(?),'X',NVL(UPPER(G.SHORT_NAME),'X'),UPPER(?)) and B.DRUG_SEARCH_BY='T')) AND UPPER(B.DRUG_CODE) =UPPER(NVL(?,B.DRUG_CODE)) AND UPPER(B.FORM_CODE) = UPPER(NVL(?,B.FORM_CODE))  AND B.ROUTE_CODE = NVL(?,B.ROUTE_CODE) AND NVL(F.TRADE_CODE,'X') LIKE DECODE(?,'X',NVL(F.TRADE_CODE,'X'),?)AND NVL(B.STRENGTH_UOM,'X') LIKE DECODE(?,'X',B.STRENGTH_UOM,?)  AND  I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE "+qryAppend+" AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID   AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ?  AND G.LANGUAGE_ID(+) = ?"+strAppend +" "+queryAppend+" ORDER BY (CASE WHEN bl_agreed_item_yn = 'Y' THEN 1 ELSE 0  END) DESC,(CASE WHEN mm_generic_item_yn = 'Y' THEN 1 ELSE 0 END) DESC,(CASE WHEN mm_brand_item_yn = 'Y' THEN 1 ELSE 0 END) DESC,expiry_date asc, b.drug_desc, c.form_desc";// added E.ROUTE_COLOR for CRF RUT-CRF-0034.1[IN:037389]-end //pr_diag.curr_status!='E' added for MMS-JU-SCF-0200 //pr_diag.CURR_ENCOUNTER_ID added MMS-DM-SCF-0806
							//B.STOCK_UOM added for NMC-JD-CRF-0124
                        	} //Added for NMC-JD-SCF-0159 - End
                        }
                        else{//modified for mms-dm-crf-0209.1
                        	sqlQry ="SELECT distinct B.DRUG_CODE,B.STRENGTH_UOM DRUG_STRENGTH,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',B.STRENGTH_UOM,'"+getLanguageId()+"') STRENGTH_UOM ,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',b.PRES_BASE_UOM,'"+getLanguageId()+"') PRES_BASE_UOM1, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT DISTINCT 'Y' FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ? AND pr_diag.curr_status!='E'  ##DIAGNOSISLEVEL## ), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN, or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') PRIV_APPL_YN ,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id =b.language_id ) stock_uom_desc,ph_get_ext_prod_drug_code(B.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID,B.BILLABLE_ITEM_YN, B.NPB_DRUG_YN,E.ROUTE_COLOR,B.DRUG_SEARCH_BY FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_ORDER_CATALOG_BY_PTCL I,PH_PARAM J, PH_DRUG_SYNONYM_lang snm  WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  AND B.GENERIC_ID = NVL(?,B.GENERIC_ID)	AND (UPPER(H.GENERIC_NAME) LIKE UPPER(NVL(?,H.GENERIC_NAME)) OR UPPER(B.DRUG_DESC) LIKE UPPER(NVL(?,B.DRUG_DESC)) OR NVL(UPPER(G.SHORT_NAME),'X') LIKE DECODE(UPPER(?),'X',NVL(UPPER(G.SHORT_NAME),'X'),UPPER(?))) AND UPPER(B.DRUG_CODE) =UPPER(NVL(?,B.DRUG_CODE)) AND UPPER(B.FORM_CODE) = UPPER(NVL(?,B.FORM_CODE))  AND B.ROUTE_CODE = NVL(?,B.ROUTE_CODE) AND NVL(F.TRADE_CODE,'X') LIKE DECODE(?,'X',NVL(F.TRADE_CODE,'X'),?)AND NVL(B.STRENGTH_UOM,'X') LIKE DECODE(?,'X',B.STRENGTH_UOM,?)  AND  I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE "+qryAppend+" AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID   AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ?  AND G.LANGUAGE_ID(+) = ?"+strAppend +" "+queryAppend+" ORDER BY b.drug_desc, c.form_desc";// added E.ROUTE_COLOR for CRF RUT-CRF-0034.1[IN:037389]-end //pr_diag.curr_status!='E' added for MMS-JU-SCF-0200 //pr_diag.CURR_ENCOUNTER_ID added MMS-DM-SCF-0806
                        }
						//Modified for TFS id:7345 end
						
						
						if("Y".equals(diagnosisEncountLevel) && !(encounterId.equals("") || encounterId.equals(null))){ //&& !(getEncounterId().isEmpty()) Added for 51127
							sqlQry=sqlQry.replaceAll("##DIAGNOSISLEVEL##"," AND pr_diag.CURR_ENCOUNTER_ID="+getEncounterId()+"");
						}else{
							sqlQry=sqlQry.replaceAll("##DIAGNOSISLEVEL##"," ");
						}
						
						pstmt = connection.prepareStatement(sqlQry);
					}
					else{
					//	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_ORDER_TYPE_SELECT")+strAppend +" ORDER BY B.DRUG_DESC,C.FORM_DESC");
					
						//pstmt = connection.prepareStatement( "SELECT /*+ ORDERED */ B.DRUG_CODE,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,B.STRENGTH_UOM,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM, D.SHORT_DESC STRENGTH_UOM_DESC, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN, or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') PRIV_APPL_YN  FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,AM_UOM_LANG_VW D,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_CATALOG_BY_PTCL_LANG_VW I,PH_PARAM_LANG_VW J WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' 	AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND D.UOM_CODE(+) = B.STRENGTH_UOM AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  AND B.GENERIC_ID = NVL(?,B.GENERIC_ID)	AND UPPER(B.DRUG_CODE) =UPPER(NVL(?,B.DRUG_CODE))   AND   I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE "+qryAppend+" AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ?"+strAppend +" ORDER BY B.DRUG_DESC,C.FORM_DESC");
						//sqlQry ="SELECT  B.DRUG_CODE,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,B.STRENGTH_UOM,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM, D.SHORT_DESC STRENGTH_UOM_DESC, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN,						or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') PRIV_APPL_YN  ,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id =b.language_id ) stock_uom_desc,ph_get_ext_prod_drug_code(b.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,AM_UOM_LANG_VW D,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_CATALOG_BY_PTCL_LANG_VW I,PH_PARAM_LANG_VW J WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' 	AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND D.UOM_CODE(+) = B.STRENGTH_UOM AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  AND B.GENERIC_ID = NVL(?,B.GENERIC_ID)	AND UPPER(H.GENERIC_NAME) LIKE UPPER(NVL(?,H.GENERIC_NAME))AND UPPER(B.DRUG_CODE) =UPPER(NVL(?,B.DRUG_CODE))AND UPPER(B.DRUG_DESC) LIKE UPPER(NVL(?,B.DRUG_DESC)) AND UPPER(B.FORM_CODE) = UPPER(NVL(?,B.FORM_CODE))  AND B.ROUTE_CODE = NVL(?,B.ROUTE_CODE) AND NVL(F.TRADE_CODE,'X') LIKE DECODE(?,'X',F.TRADE_CODE,?)AND NVL(B.STRENGTH_UOM,'X') LIKE DECODE(?,'X',B.STRENGTH_UOM,?) AND NVL(UPPER(G.SHORT_NAME),'X') LIKE DECODE(UPPER(?),'X',UPPER(G.SHORT_NAME),UPPER(?)) AND  I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE "+qryAppend+ " AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ?"+strAppend +" "+queryAppend+" ORDER BY B.DRUG_DESC,C.FORM_DESC";
						//sqlQry ="SELECT  B.DRUG_CODE,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',B.STRENGTH_UOM) STRENGTH_UOM,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',B.PRES_BASE_UOM) PRES_BASE_UOM1, D.SHORT_DESC STRENGTH_UOM_DESC, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN,						or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') PRIV_APPL_YN  ,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id =b.language_id ) stock_uom_desc,ph_get_ext_prod_drug_code(b.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,AM_UOM_LANG_VW D,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_CATALOG_BY_PTCL_LANG_VW I,PH_PARAM_LANG_VW J WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' 	AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND D.UOM_CODE(+) = B.STRENGTH_UOM AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  AND B.GENERIC_ID = NVL(?,B.GENERIC_ID)	AND UPPER(H.GENERIC_NAME) LIKE UPPER(NVL(?,H.GENERIC_NAME))AND UPPER(B.DRUG_CODE) =UPPER(NVL(?,B.DRUG_CODE))AND UPPER(B.DRUG_DESC) LIKE UPPER(NVL(?,B.DRUG_DESC)) AND UPPER(B.FORM_CODE) = UPPER(NVL(?,B.FORM_CODE))  AND B.ROUTE_CODE = NVL(?,B.ROUTE_CODE) AND NVL(F.TRADE_CODE,'X') LIKE DECODE(?,'X',F.TRADE_CODE,?)AND NVL(B.STRENGTH_UOM,'X') LIKE DECODE(?,'X',B.STRENGTH_UOM,?) AND NVL(UPPER(G.SHORT_NAME),'X') LIKE DECODE(UPPER(?),'X',UPPER(G.SHORT_NAME),UPPER(?)) AND  I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE "+qryAppend+ " AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ?"+strAppend +" "+queryAppend+" ORDER BY B.DRUG_DESC,C.FORM_DESC";
// B.STRENGTH_UOM DRUG_STRENGTH, ADDED FOR GHL-CRF-0548
						sqlQry ="SELECT DISTINCT B.DRUG_CODE,B.STRENGTH_UOM DRUG_STRENGTH,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',B.STRENGTH_UOM,'"+getLanguageId()+"') STRENGTH_UOM,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM,PH_GET_UOM_DISPLAY('"+getLoginFacilityId ()+"',B.PRES_BASE_UOM,'"+getLanguageId()+"') PRES_BASE_UOM1,  B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT DISTINCT 'Y' FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ? AND pr_diag.curr_status!='E' ##DIAGNOSISLEVEL## ), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN, or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') PRIV_APPL_YN  ,PROMPT_ALERT_PREFERRED_DRUG,(select short_desc from am_uom_lang_vw where uom_code =stock_uom and language_id =b.language_id ) stock_uom_desc,ph_get_ext_prod_drug_code(b.drug_code,'"+getLoginFacilityId ()+"')EXTERNAL_PRODUCT_ID,B.BILLABLE_ITEM_YN, B.NPB_DRUG_YN,E.ROUTE_COLOR,B.DRUG_SEARCH_BY FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_ORDER_CATALOG_BY_PTCL I,PH_PARAM J, PH_DRUG_SYNONYM_lang snm WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' 	AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE   AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  AND B.GENERIC_ID = NVL(?,B.GENERIC_ID)	AND UPPER(H.GENERIC_NAME) LIKE UPPER(NVL(?,H.GENERIC_NAME))AND UPPER(B.DRUG_CODE) =UPPER(NVL(?,B.DRUG_CODE))AND UPPER(B.DRUG_DESC) LIKE UPPER(NVL(?,B.DRUG_DESC)) AND UPPER(B.FORM_CODE) = UPPER(NVL(?,B.FORM_CODE))  AND B.ROUTE_CODE = NVL(?,B.ROUTE_CODE) AND NVL(F.TRADE_CODE,'X') LIKE DECODE(?,'X',F.TRADE_CODE,?)AND NVL(B.STRENGTH_UOM,'X') LIKE DECODE(?,'X',B.STRENGTH_UOM,?) AND NVL(UPPER(G.SHORT_NAME),'X') LIKE DECODE(UPPER(?),'X',UPPER(G.SHORT_NAME),UPPER(?)) AND  I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE "+qryAppend+ " AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID   AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ?  AND G.LANGUAGE_ID(+) = ?"+strAppend +" "+queryAppend+" ORDER BY B.DRUG_DESC,C.FORM_DESC";// added E.ROUTE_COLOR for CRF RUT-CRF-0034.1[IN:037389],Modified for TFS id:7345 added DRUG_SEARCH_BY column //pr_diag.curr_status!='E' added for MMS-JU-SCF-0200
						
						if("Y".equals(diagnosisEncountLevel) && !(encounterId.equals("") || encounterId.equals(null))){ //&& !(getEncounterId().isEmpty()) Added for 51127
							sqlQry=sqlQry.replaceAll("##DIAGNOSISLEVEL##"," AND pr_diag.CURR_ENCOUNTER_ID="+getEncounterId()+"");
						}else{
							sqlQry=sqlQry.replaceAll("##DIAGNOSISLEVEL##"," ");
						}
						 System.out.println("1624 searchBasedOnDataSelected"+sqlQry);
						pstmt = connection.prepareStatement( sqlQry);
					}
setP_episode_type(episode_type);//added for mms-dm-crf-0209.1
System.out.println("encounter_id---->"+encounter_id.length()+"<------------");
if(encounter_id.length()<=0){
	setP_visit_id("");//added for mms-dm-crf-0209.1
	setP_episode_id("");//added for mms-dm-crf-0209.1
}else{
setP_visit_id(encounter_id.substring(encounter_id.length()-4));//added for mms-dm-crf-0209.1
setP_episode_id(encounter_id.substring(0,(encounter_id.length()-4)));//added for mms-dm-crf-0209.1
}
System.err.println("=1628 =sqlQry====="+sqlQry);
					strength_uom =strength_uom+ "%";
					trade_id =trade_id+"%";
					int cnt	=	1;
					if (search_by.equals("A")){
						pstmt.setString(cnt,getPatientId());
						pstmt.setString(++cnt,getDOB());
						pstmt.setString(++cnt,getGender());
						System.err.println("1636 @@@@getPatientId==>"+getPatientId()+"-->getDOB()-->"+getDOB()+"-->getGender()-->"+getGender()+"==>practitionerId--->"+practitionerId+"-->resp_id--->"+resp_id+"-->drug_priv_appl_yn_from_session--->"+drug_priv_ssn_yn+"generic_id.trim()-->"+generic_id.trim()+"-->generic_name.trim()-->"+generic_name.trim()+"-->drug_desc.trim()-->"+drug_desc.trim()+"-->trade_desc.trim()-->"+trade_desc.trim()+"-->trade_desc.trim()-->"+trade_desc.trim()+"-->drug_id.trim()-->"+drug_id.trim()+"-->form_code.trim()-->"+form_code.trim()+"-->route_code.trim()-->"+route_code.trim()+"-->trade_id.trim()-->"+trade_id.trim()+"-->trade_id.trim()-->"+trade_id.trim()+"-->strength_uom.trim()-->"+strength_uom.trim()+"-->strength_uom.trim()-->"+strength_uom.trim());
						pstmt.setString(++cnt,practitionerId);
						pstmt.setString(++cnt,resp_id);
						pstmt.setString(++cnt,drug_priv_ssn_yn);
            //Added for mms-dm-crf-0209.1 start	
						if(getPreAllocAppl() && (search_by_generic_or_trade.equals("G") || search_by_generic_or_trade.equals("T")) && (!generic_or_trade_code.equals(""))){ //Added for NMC-JD-SCF-0159
							pstmt.setString(++cnt,login_facility_id.trim());//1
							pstmt.setString(++cnt,episode_type.trim());//2
							pstmt.setString(++cnt,getPatientId().trim());//3
							if(encounter_id.length()<=0) 
							{
								pstmt.setString(++cnt,"");//4
								pstmt.setString(++cnt,"");//5
							}
							else{
								
								pstmt.setString(++cnt,encounter_id.substring(0,(encounter_id.length()-4)));//4
								pstmt.setString(++cnt,encounter_id.substring(encounter_id.length()-4));//5
							}
							
							pstmt.setString(++cnt,getEncounterId().trim());//6
							pstmt.setString(++cnt,"");//7
							//pstmt.setString(++cnt,item_code.trim());//8
						System.out.println("generic_or_trade_code"+generic_or_trade_code);
						}//Added for mms-dm-crf-0209.1 end
						
						pstmt.setString(++cnt,generic_id.trim());
						if(getPreAllocAppl() && (search_by_generic_or_trade.equals("G") || search_by_generic_or_trade.equals("T")) && (!generic_or_trade_code.equals(""))){ //Added for NMC-JD-SCF-0159
							pstmt.setString(++cnt,generic_or_trade_code.trim());
						System.out.println("generic_or_trade_code"+generic_or_trade_code);
						}
						else{ //Added for NMC-JD-SCF-0159
						pstmt.setString(++cnt,generic_name.trim());
						//Modified for TFS id:7345 start
						if(!getPreAllocAppl()){
							pstmt.setString(++cnt,drug_desc.trim());
						}
						//Modified for TFS id:7345 end
						pstmt.setString(++cnt,trade_desc.trim());
						pstmt.setString(++cnt,trade_desc.trim());
						} //Added for NMC-JD-SCF-0159
						pstmt.setString(++cnt,drug_id.trim());
						pstmt.setString(++cnt,form_code.trim());
						pstmt.setString(++cnt,route_code.trim());
						pstmt.setString(++cnt,trade_id.trim());
						pstmt.setString(++cnt,trade_id.trim());
						pstmt.setString(++cnt,strength_uom.trim());
						pstmt.setString(++cnt,strength_uom.trim());
						pstmt.setString(++cnt,getPatientClass().trim());
						if (priviligeDrugCheck.equals("S")){ //in drug search Self Privilige Drugs Selected
							pstmt.setString(++cnt,practitionerId);
							pstmt.setString(++cnt,resp_id);
							pstmt.setString(++cnt,drug_priv_ssn_yn);
						}
					}

					else{
						pstmt.setString(cnt,getPatientId());
						pstmt.setString(++cnt,getDOB());
						pstmt.setString(++cnt,getGender());

						//System.err.println("@@@@getPatientId==>"+getPatientId()+"-->getDOB()-->"+getDOB()+"-->getGender()-->"+getGender()+"==>practitionerId--->"+practitionerId+"-->resp_id--->"+resp_id+"-->drug_priv_appl_yn_from_session--->"+drug_priv_ssn_yn+"generic_id.trim()-->"+generic_id.trim()+"-->generic_name.trim()-->"+generic_name.trim()+"drug_id.trim()-->"+drug_id.trim()+"-->drug_desc.trim()-->"+drug_desc.trim()+"-->trade_desc.trim()-->"+trade_desc.trim()+"-->trade_desc.trim()-->"+trade_desc.trim()+"-->drug_id.trim()-->"+drug_id.trim()+"-->form_code.trim()-->"+form_code.trim()+"-->route_code.trim()-->"+route_code.trim()+"-->trade_id.trim()-->"+trade_id.trim()+"-->trade_id.trim()-->"+trade_id.trim()+"-->strength_uom.trim()-->"+strength_uom.trim()+"-->strength_uom.trim()-->"+strength_uom.trim()+"-->trade_desc.trim()-->"+trade_desc.trim()+"-->trade_desc.trim()-->"+trade_desc.trim()+"-->getPatientClass().trim()-->"+getPatientClass().trim());
						pstmt.setString(++cnt,practitionerId);
						pstmt.setString(++cnt,resp_id);
						pstmt.setString(++cnt,drug_priv_ssn_yn);						
						pstmt.setString(++cnt,generic_id.trim());
						pstmt.setString(++cnt,generic_name.trim());
						pstmt.setString(++cnt,drug_id.trim());
						pstmt.setString(++cnt,drug_desc.trim());
						pstmt.setString(++cnt,form_code.trim());
						pstmt.setString(++cnt,route_code.trim());
						pstmt.setString(++cnt,trade_id.trim());
						pstmt.setString(++cnt,trade_id.trim());
						pstmt.setString(++cnt,strength_uom.trim());
						pstmt.setString(++cnt,strength_uom.trim());
						pstmt.setString(++cnt,trade_desc.trim());
						pstmt.setString(++cnt,trade_desc.trim());
						pstmt.setString(++cnt,getPatientClass().trim());
						if (priviligeDrugCheck.equals("S")){ //in drug search self Privilige Drugs Selected
							pstmt.setString(++cnt,practitionerId);
							pstmt.setString(++cnt,resp_id);
							pstmt.setString(++cnt,drug_priv_ssn_yn);
						}
					}

					pstmt.setString(++cnt,getLanguageId());
				//	pstmt.setString(++cnt,getLanguageId());
					pstmt.setString(++cnt,getLanguageId());
					if(!order_type_code.trim().equals("")) {
						pstmt.setString(++cnt,order_type_code.trim());
					}
					if(res_by_service.equals("Y")){
						if(service_code!=null){
							service_code = service_code.trim();
						}
						pstmt.setString(++cnt,service_code);
					}
					pstmt.setString(++cnt,synonym);
					if (strength1_value > 0){
						pstmt.setDouble(++cnt,strength1_value);
					}
					resultSet = pstmt.executeQuery() ;
				}
				else{
					records.add("link");
					return records;
				}
			}

			records.add("link");
			String key="";//Added for TFS id:7345
			String current_item_code="";//Added for TFS id:7345
			boolean stock_uom_app = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","GROUP_BY_STOCK_UOM");//NMC-JD-CRF-0124
			while ( resultSet!=null && resultSet.next() && i <= end+1 ){
			//Modified for TFS id:7345 start
				  if(stock_uom_app){ //if condition added for NMC-JD-CRF-0124 
				   key=checkForNull(resultSet.getString("GENERIC_ID"))+checkForNull(resultSet.getString("STRENGTH_VALUE"))+checkForNull(resultSet.getString("STRENGTH_UOM"))+checkForNull(resultSet.getString("FORM_CODE"))+checkForNull(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM"))+checkForNull(resultSet.getString("STOCK_UOM_DESC")); //stock uom and strength_per_value_pres_uom added for NMC-JD-CRF-0124 //STOCK_UOM modified to STOCK_UOM_DESC
				 
				  }else{
				  key=checkForNull(resultSet.getString("GENERIC_ID"))+checkForNull(resultSet.getString("STRENGTH_VALUE"))+checkForNull(resultSet.getString("STRENGTH_UOM"))+checkForNull(resultSet.getString("FORM_CODE"));
				  }
				  current_item_code=checkForNull(resultSet.getString("ITEM_CODE"));
			
				boolean flag=true;
				if(getPreAllocAppl()){
				if(sameGenericItems.containsKey(key)){
					String itemcodes=(String) sameGenericItems.get(key);
					itemcodes=itemcodes+'$'+current_item_code;
					sameGenericItems.put(key, itemcodes);
					flag=false;
				}
				else{
					sameGenericItems.put(key, current_item_code);
				}
				}
System.out.println("sameGenericItems----------"+sameGenericItems);
				if(flag){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else { i++;
					count++ ;
				}
			}
				if(i <= end || !flag) {
					String[] strArray=new String[36];//32 CHANGED TO 33  FOR GHL-CRF-0548, CHANGED 33 TO 36 for TFS id:7345
				//Modified for TFS id:7345 end		
					//{
						//priv_applin_yn = resultSet.getString("PRIV_APPL_YN")==null?"":resultSet.getString("PRIV_APPL_YN");
					//}
					item_code = resultSet.getString("ITEM_CODE")==null?"":resultSet.getString("ITEM_CODE");
					itemCode = item_code;
					setItemCode(itemCode);
					strArray[0]	= resultSet.getString("DRUG_CODE")==null?"":resultSet.getString("DRUG_CODE");
					strArray[1]	= resultSet.getString("DRUG_DESC")==null?"":resultSet.getString("DRUG_DESC");

					if (resultSet.getString("STRENGTH_PER_PRES_UOM")!=null && !(resultSet.getString("STRENGTH_PER_PRES_UOM")).equals("0") ){
						strength=resultSet.getString("STRENGTH_PER_PRES_UOM");
						//System.err.println("strength====1443===>" +strength);
						//Added If-Condition for Strength Column in Drug lookup on 21/sept/2010---For incidents number--23841,23724,23792 ===By Sandhya.
						if(strength!=null && !strength.equals("") && Float.parseFloat(strength) <1){
							strength = Float.parseFloat(strength)+"";
						}
						//System.err.println("strength====1448===>" +strength);
						strArray[2]	= strength+" "+resultSet.getString("STRENGTH_UOM")+" / "+resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")+" "+resultSet.getString("PRES_BASE_UOM1");
						//System.err.println("strArray[2]==1439 bean===>" +strArray[2]);
					}
					else{
						strArray[2]	= "";
					}
                   if(identity.equals("MedicationOrder")){  
					  strArray[3]	=resultSet.getString("STRENGTH_UOM")==null?"":resultSet.getString("STRENGTH_UOM");	
				   }
				   else{
					  strArray[3]	= resultSet.getString("STRENGTH_UOM_DESC")==null?"":resultSet.getString("STRENGTH_UOM_DESC");
				   }
					strArray[4]	= resultSet.getString("FORM_CODE")==null?"":resultSet.getString("FORM_CODE");
					strArray[5]	= resultSet.getString("FORM_DESC")==null?"":resultSet.getString("FORM_DESC");
					strArray[6]	= resultSet.getString("ROUTE_CODE")==null?"":resultSet.getString("ROUTE_CODE");

					strArray[7]	= resultSet.getString("ROUTE_DESC")==null?"":resultSet.getString("ROUTE_DESC");
					strArray[8]	= resultSet.getString("GENERIC_NAME")==null?"":resultSet.getString("GENERIC_NAME");

					strArray[9]	= checkForNull(resultSet.getString("GENERIC_ID"));
					strArray[10]= checkForNull(resultSet.getString("TRADE_CODE"));
					strArray[11]= checkForNull(resultSet.getString("TRADE_NAME"));
					strArray[12]= checkForNull(resultSet.getString("PRES_BASE_UOM"));
					strArray[13]= checkForNull(resultSet.getString("IN_FORMULARY_YN"));
					
					String in_formulary_yn = strArray[13];
					String reimburse_yn="";
					String imported_yn = "";
					String unit_price = "";
					String sys_message_id = "";
					String error_code="";
					String error_text="";
					String episode_id = "";// Added for JD-CRF-0191
					String visit_id = ""; // Added for JD-CRF-0191
					String encounter_id="";// Added for JD-CRF-0191
					//System.err.println("==@@@1431=identity=="+identity+"==bl_install_yn=="+bl_install_yn+"==disp_charge_dtl_in_drug_lkp_yn=="+disp_charge_dtl_in_drug_lkp_yn+"==in_formulary_yn=="+in_formulary_yn+" login_facility_id="+login_facility_id+" episode_type="+episode_type+" item_code="+item_code);
					if(identity.equals("MedicationOrder")&& bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y") ){
						if(getDischargeYN().equals("Y") || getDischargeYN().equals("D")) //Added for [IN:045637]
							episode_type = "I";
						try{
							encounter_id= getEncounterId();// Added for JD-CRF-0191
							if(encounter_id.length()<=0)  // if else condition added for BSP-SCF-0022 - Start
							{
								episode_id ="";
								visit_id ="";
							}
							else{
								episode_id =encounter_id.substring(0,(encounter_id.length()-4));  // Added for  JD-CRF-0191
								visit_id =encounter_id.substring(encounter_id.length()-4);        // Added for  JD-CRF-0191	
							} // if else condition added for BSP-SCF-0022  - End
							
							cstmt=connection.prepareCall("{call  BL_PROC_ITEM_VALIDATIONS_MP.BL_GET_ITEM_DETAILS_MM (?,?,?,?,?,TO_DATE(to_char(sysdate,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); // three more '?' added for JD-CRF-0191
							cstmt.setString( 1, login_facility_id);
							cstmt.setString( 2, episode_type); //'O'-Outpatient,'E'-Emergency ,'D'-Daycare,'I'-Inpatient,'R'-External
							cstmt.setString( 3, item_code);
							cstmt.setString( 4, ""); // p_trade_id	--If Batch level price is required (null as of now)
							cstmt.setString( 5, ""); // p_batch_id  --If Batch level price is required (null as of now
							//cstmt.setString( 6, getSysdatetimesec()); // p_date
							cstmt.registerOutParameter(6, Types.VARCHAR );	//ESSENTIAL_YN 
							cstmt.registerOutParameter(7, Types.VARCHAR );	//P_REIMBURSABLE_YN Y --Reimbursible
							cstmt.registerOutParameter(8, Types.VARCHAR );	//P_REIMBURSABLE  P --> partially   F --> Fully
							cstmt.registerOutParameter(9, Types.VARCHAR ); //P_IMPORTED_YN	Y  --> Imported
							cstmt.registerOutParameter(10, Types.NUMERIC ); //PUBLIC_PRICE
							cstmt.registerOutParameter(11, Types.NUMERIC ); //P_BASE_PRICE	--Sale price as defined in billing by item/batch for respective passed Episode Type
							cstmt.registerOutParameter(12, Types.NUMERIC ); //P_REIMBURSABLE_AMT
							cstmt.registerOutParameter(13, Types.VARCHAR ); //P_REIM_OVERRIDE
							cstmt.registerOutParameter(14, Types.VARCHAR ); //P_ERROR_CODE
							cstmt.registerOutParameter(15, Types.VARCHAR ); //P_SYS_MESSAGE_ID
							cstmt.registerOutParameter(16, Types.VARCHAR ); //P_ERROR_TEXT
							cstmt.setString( 17, getPatientId()); //Added for JD-CRF-0191 - Start// wrongly mapped index position - BSP-SCF-0004-created and resolved EMs
							cstmt.setString( 18, episode_id);  
							cstmt.setString( 19, visit_id);  //Added for JD-CRF-0191 - End //BSP-SCF-0004-created and resolved EMs
							cstmt.execute() ;

							reimburse_yn	= cstmt.getString(7);
							imported_yn		= cstmt.getString(9);
							unit_price		= cstmt.getString(11);
							error_code		= cstmt.getString(14);
							sys_message_id	= cstmt.getString(15) == null ? "" : cstmt.getString(15);
							error_text		= cstmt.getString(16);
							closeStatement( cstmt );
							if(disp_price_type_in_drug_lkp.equals("P")){
								if (sys_message_id.equals("BL9647")){
									sys_message_id = "";
									error_code  =null;
									error_text=null;
								}
							}							

							if(disp_price_type_in_drug_lkp.equals("P") && (error_code ==null  && error_text==null && sys_message_id.equals("") )){
								 encounter_id = getEncounterId();  // Declared as String in BL_GET_ITEM_DETAILS_MM for JD-CRF-191
								 episode_id = ""; // Declared as String in BL_GET_ITEM_DETAILS_MM for JD-CRF-191
								 visit_id = ""; // Declared as String in BL_GET_ITEM_DETAILS_MM for JD-CRF-191
								if(encounter_id!= null && !encounter_id.equals("")){
									episode_id = encounter_id;
									if(episode_type.equals("O")||episode_type.equals("E")){
										episode_id = encounter_id.substring(0,(encounter_id.length()-4));
										visit_id = encounter_id.substring(encounter_id.length()-4);
									}
								}

								cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(to_char(sysdate,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
								cstmt.setString( 1, login_facility_id);
								cstmt.setString( 2, "PH");	//module id
								cstmt.setString( 3, "");	//
								cstmt.setString( 4, "");	//
								cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
								cstmt.setString( 6, getPatientId()); //patient_id
								cstmt.setString( 7, episode_id);  //episode_id
								cstmt.setString( 8, visit_id);  //p_visit_id  
								cstmt.setString( 9, ""); //p_dummy1 - null
								cstmt.setString( 10, ""); //p_dummy12 - null
								cstmt.setString( 11, "SAL"); //p_transaction_type
								//cstmt.setString( 12, getSysdatetimesec()); //p_charge_date_time	--Service Data and time
								cstmt.registerOutParameter(12, Types.VARCHAR ); //p_day_type_code - null
								cstmt.registerOutParameter(13, Types.VARCHAR ); //Y --p_day_type_desc - null
								cstmt.registerOutParameter(14, Types.VARCHAR ); // p_time_type_code - null
								cstmt.registerOutParameter(15, Types.VARCHAR ); //p_time_type_desc  - null

								cstmt.setString( 16, item_code);  //p_item_code

								cstmt.registerOutParameter(17, Types.VARCHAR ); //p_item_desc 
								cstmt.registerOutParameter(18, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 
								cstmt.setString( 19, "S");  //p_serv_panel_ind
								cstmt.registerOutParameter(20, Types.VARCHAR ); //p_serv_panel_code 
								cstmt.setString( 21,"1" );  //qty served
								cstmt.setString( 22, "");  //p_charge_amt  
								cstmt.registerOutParameter(23, Types.NUMERIC ); //p_avg_unit_cost

								cstmt.setString( 24,"" );  //p_store_code -- Store Code from where issued
								cstmt.setString( 25, "");  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
								cstmt.setString( 26,"" );  //p_oth_disc_perc if any other manual discount is given from transaction
								cstmt.setString( 27, "");  //p_source_doc_ref		null for Sale
								cstmt.setString( 28,"" );  //p_source_doc_ref_line	null for Sale

								cstmt.registerOutParameter(29, Types.NUMERIC ); //p_base_qty
								cstmt.registerOutParameter(30, Types.NUMERIC ); //p_base_rate
								cstmt.registerOutParameter(31, Types.NUMERIC ); //p_addl_factor
								cstmt.registerOutParameter(32, Types.NUMERIC ); //p_base_charge_amt       
								cstmt.registerOutParameter(33, Types.NUMERIC ); //p_GROSS_CHARGE_AMT      
								cstmt.registerOutParameter(34, Types.NUMERIC ); //p_DISC_AMT              
								cstmt.registerOutParameter(35, Types.NUMERIC ); //p_NET_CHARGE_AMT     --- Total Charge Amt   
								cstmt.registerOutParameter(36, Types.NUMERIC ); //p_disc_perc             
								cstmt.registerOutParameter(37, Types.NUMERIC ); //p_PAT_GROSS_CHARGE_AMT  
								cstmt.registerOutParameter(38, Types.NUMERIC ); //p_PAT_DISC_AMT          
								cstmt.registerOutParameter(39, Types.NUMERIC ); //P_PAT_NET_CHARGE_AMT   --- Patient Payable Amt 
								cstmt.registerOutParameter(40, Types.NUMERIC ); //p_CUST_GROSS_CHARGE_AMT 
								cstmt.registerOutParameter(41, Types.NUMERIC ); //p_CUST_DISC_AMT         
								cstmt.registerOutParameter(42, Types.NUMERIC ); //p_CUST_NET_CHARGE_AMT   
								cstmt.registerOutParameter(43, Types.VARCHAR ); //p_SPLIT_IND             
								cstmt.registerOutParameter(44, Types.NUMERIC ); //p_curr_availed          
								cstmt.registerOutParameter(45, Types.VARCHAR ); //p_credit_auth_ref       
								cstmt.registerOutParameter(46, Types.VARCHAR ); //P_PAT_PAID_AMT --- Patient Paid Amt

								cstmt.setString( 47,"" );  //p_dummy4 (IN OUT )
								cstmt.setString( 48, "");  //p_batch_prices  (IN OUT )
								
								cstmt.registerOutParameter(49, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
								cstmt.registerOutParameter(50, Types.VARCHAR ); //p_excl_incl_ind	--- Excluded(E)/Null or included(I)
								cstmt.registerOutParameter(51, Types.VARCHAR ); //p_approval_reqd_yn	--- approval is required or not?
								cstmt.registerOutParameter(52, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?

								cstmt.setString( 53,"" );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
								cstmt.setString( 54, "");  //p_overridden_action_reason		 --- Pass null or any value entered 

								cstmt.registerOutParameter(55, Types.VARCHAR ); //p_err_code
								cstmt.registerOutParameter(56, Types.VARCHAR ); //p_sys_message_id
								cstmt.registerOutParameter(57, Types.VARCHAR ); //p_error_text

								cstmt.execute() ;
								unit_price		= cstmt.getString(39);
								error_code		= cstmt.getString(55);
								sys_message_id	= cstmt.getString(56);
								error_text		= cstmt.getString(57);
								//System.err.println("=22===unit_price===="+unit_price+"==error_code===="+error_code+"==sys_message_id===="+sys_message_id+"==error_text===="+error_text);
							}
						}catch(Exception e){
							error_text = "Error in Proc";
							unit_price = "";
							e.printStackTrace();
						}
						finally{
							closeStatement( cstmt ) ;
						}
						if(unit_price!=null && !unit_price.equals("")){
							
							DecimalFormat df = new DecimalFormat(decimalFormatString);
							unit_price = df.format(Double.parseDouble(unit_price));
						}
					}
					strArray[14] = reimburse_yn;
					strArray[15] = imported_yn;
					strArray[16]= unit_price;
					strArray[17]= error_code;
					strArray[18]= sys_message_id;
					strArray[19]= error_text;
					if(identity.equals("MedicationOrder")){
						strArray[20]= checkForNull(resultSet.getString("DIAGNOSIS_FOUND_YN"));
						strArray[22]= checkForNull(resultSet.getString("APPL_FOR_AGE_GRP_YN"));
						strArray[23]= checkForNull(resultSet.getString("DISP_MULTI_STRENGTH_YN"));
						strArray[24]= checkForNull(resultSet.getString("DISP_ALT_FORM_YN"));
						strArray[25]= checkForNull(resultSet.getString("PRIV_APPL_YN"));
						//strArray[25]= priv_applin_yn;
					}
					else{
						strArray[20]= "";
						strArray[22]= "";
						strArray[23]= "";
						strArray[24]= "";
						strArray[25]= "";
					}

					strArray[21]= checkForNull(resultSet.getString("DRUG_CLASS"));
					strArray[26]=checkForNull(resultSet.getString("PROMPT_ALERT_PREFERRED_DRUG"));
					strArray[27]=checkForNull(resultSet.getString("stock_uom_desc"));
					strArray[28]=resultSet.getString("EXTERNAL_PRODUCT_ID");
					if(identity.equals("MedicationOrder")){
						strArray[29]=checkForNull(resultSet.getString("BILLABLE_ITEM_YN"));
						strArray[30]=checkForNull(resultSet.getString("NPB_DRUG_YN"),"N");
					}
					else{
						strArray[29]="";
						strArray[30]="";
					}

                    strArray[31]=resultSet.getString("ROUTE_COLOR");// added for CRF RUT-CRF-0034.1[IN:037389]-end
                    strArray[32]=resultSet.getString("DRUG_STRENGTH");//ADDED FOR GHL-CRF-0548
                    strArray[33]=key;//Added for TFS id:7345
                    strArray[34]=checkForNull(resultSet.getString("DRUG_SEARCH_BY"));//Added for TFS id:7345
                    strArray[35]=checkForNull(strength);//Added for TFS id:7345
                    //Added for TFS id:7345 start
                    if(getPreAllocAppl()){
                    sameGenericItemsdata.put(itemCode, strArray);
                    }
                    if(flag){
                    records.add( strArray );
                    }
					//Added for TFS id:7345 end
				//System.err.println("strArray[0]---"+strArray[0]+"--strArray[1]--"+strArray[1]+"--strArray[2]--"+strArray[2]+"--strArray[3]--"+strArray[3]+"--strArray[4]--"+strArray[4]+"--strArray[5]--"+strArray[5]+"--strArray[6]--"+strArray[6]+"--strArray[7]--"+strArray[7]+"--strArray[8]--"+strArray[8]+"-strArray[9]"+strArray[9]+"--strArray[10]--"+strArray[10]+"--strArray[11]--"+strArray[11]+"--strArray[12]--"+strArray[12]+"--strArray[13]--"+strArray[14]+"--strArray[14]--"+strArray[14]+"--strArray[15]--"+strArray[15]+"--strArray[16]--"+strArray[16]+"--strArray[17]"+strArray[17]+"--strArray[18]--"+strArray[18]+"--strArray[19]--"+strArray[19]+"--strArray[20]--"+strArray[20]+"--strArray[21]--"+strArray[21]+"--strArray[22]--"+strArray[22]+"--strArray[23]--"+strArray[23]+"--strArray[24]--"+strArray[24]+"--strArray[25]--"+strArray[25]);
				//System.err.println("strArray[26]---"+strArray[26]+"--strArray[27]--"+strArray[27]+"--strArray[28]--"+strArray[28]);
				}
			}
			/*	if( count > 10 )
					 ;*/

			if( start != 1 )
				//prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLinkForDrug('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+priviligeDrugCheck+"');\">Previous&nbsp;&nbsp;</a>" ;
				prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLinkForDrug('"+(start-query_result_size)+"','"+(end-query_result_size)+"');\">Previous&nbsp;&nbsp;</a>" ;

			int intCount=0;
			if(identity.equals("MedicationOrder")){
				intCount = 10;//5 changed to 10 
			}
			else{
				intCount = 10;
			}
			if( count > intCount )
					//prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLinkForDrug('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+priviligeDrugCheck+"');\">Next</a>";
					prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLinkForDrug('"+(start+query_result_size)+"','"+(end+query_result_size)+"');\">Next</a>";
			records.set(0,prevnextlink);
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		System.out.println("records-------"+records);
		return records;
	}

	//Search by ATC
	public ArrayList searchBasedOnATCClassfication(String Classification,String from , String to, String bl_install_yn, String disp_charge_dtl_in_drug_lkp_yn, String disp_price_type_in_drug_lkp ,String priviligeDrugCheck, String practitionerId, String resp_id, String drug_priv_ssn_yn)throws Exception{ //,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn ADDED for INC 28155
		
		priviligeDrugCheck = getPriviligeDrugCheck();
		setRespId(resp_id);

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		CallableStatement cstmt = null ;
		ResultSet resultSet		= null ;
		StringTokenizer stClassification = new StringTokenizer(Classification,"|");
		ArrayList records=new ArrayList();
		String episode_type= getPatientClass();
		if(episode_type !=null && (!episode_type.equals("")))
			episode_type = episode_type.substring(0,1);

		if(episode_type !=null && episode_type.equals("X"))
			episode_type = "R";
		String item_code = "";
		String diagnosisEncountLevel="N";

		if (stClassification.countTokens() == 10){
			String lev1= (stClassification.nextToken()).trim();
			stClassification.nextToken();
			//String lev1desc= stClassification.nextToken();
			String lev2= stClassification.nextToken();
			stClassification.nextToken();
			//String lev2desc= stClassification.nextToken();
			String lev3= stClassification.nextToken();
			stClassification.nextToken();
			//String lev3desc= stClassification.nextToken();
			String lev4= stClassification.nextToken();
			stClassification.nextToken();
			//String lev4desc= stClassification.nextToken();
			String lev5= stClassification.nextToken();
			//String lev5desc= stClassification.nextToken();

//			String strAppendForNullCheck="";
			String strAppend = "";
			if (!lev2.equals(" ")){
				strAppend =strAppend+ " AND B.ATC_CLASS_LEV2_CODE = ? " ;
			}
			if (! lev3.equals(" ")){
				strAppend =strAppend+ " AND B.ATC_CLASS_LEV3_CODE = ? " ;
			}
			if (! lev4.equals(" ")){
				strAppend =strAppend+ " AND B.ATC_CLASS_LEV4_CODE = ? " ;
			}
			if (!lev5.equals(" ")){
				strAppend =strAppend+ " AND B.ATC_CLASS_LEV5_CODE = ? " ;
			}	
			//ATC Classification Drug Search - Duplicates record appearing [IN:030413]
			strAppend =strAppend+" AND LANG1 = ? AND DECODE(LANG2,NULL,?,LANG2)= ? AND  DECODE(LANG3,NULL,?,LANG3)= ? ";

			String prevnextlink			= "";
			int query_result_size		= 10;
			int start = 0 ;
			int end = 0 ;

			if ( from == null || from.equals(""))
				start = 1 ;
			else
				start = Integer.parseInt( from  ) ;

			if ( to == null || to.equals(""))
				end =query_result_size;
			else
				end = Integer.parseInt( to ) ;
			long count=0;
			long i = 0;
			try {
				connection = getConnection() ;
				diagnosisEncountLevel= getDiagnosisLevel();				
				int intcount=1;
//new code written during PE by Naveen  issue:method called in Loop
			String decimalFormatString =""  ; 
				 if ( bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y")&& identity.equals("MedicationOrder")){
			           decimalFormatString = getDecimalFormatString();
			     }
				if (identity.equals("General")){
					String queryString=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT13")+strAppend +" ORDER BY A.DRUG_DESC";
					if("Y".equals(diagnosisEncountLevel)){
						queryString=queryString.replaceAll("##DIAGNOSISLEVEL##"," AND pr_diag.CURR_ENCOUNTER_ID="+getEncounterId()+"");
					}else{
						queryString=queryString.replaceAll("##DIAGNOSISLEVEL##"," ");
					}
					pstmt = connection.prepareStatement(queryString );	
					pstmt.setString(intcount++,getPatientId());
					pstmt.setString(intcount++,getDOB());
					pstmt.setString(intcount++,getGender());
					pstmt.setString(intcount++,getLoginFacilityId());	//added for INC 28155 
					pstmt.setString(intcount++,getLoginFacilityId());	//added for INC 28155 
				}
				else if (identity.equals("MedicationOrder")){
					/*
						IVA - IV Admixture
						IVD - IV Direct
						THIS IS NOT TAKEN CARE NOW.....So getIVMedicationType() will always be empty Beacuse of this it won't enter into else part.
					*/								
					if(getIVMedicationType().equals("IVA") || getIVMedicationType().equals("") ){
						if(getDrugOrFluid().equals("D")){		// DRUG
							strAppend =strAppend+ " AND E.DFLT_IV_ROUTE_CODE = A.ROUTE_CODE AND ((A.IV_FLUID_YN='N' AND A.IV_INGREDIENT_YN='Y') OR (A.IV_FLUID_YN='Y' AND A.IV_INGREDIENT_YN='Y'))  ";
							
						}
						else if(getDrugOrFluid().equals("F")){	// FLUID
							strAppend =strAppend+ " AND E.DFLT_IV_ROUTE_CODE = A.ROUTE_CODE AND A.IV_FLUID_YN='Y' AND A.IV_INGREDIENT_YN='N' ";
						}
						else if(getDrugOrFluid().equals("C")){  // Cyto
							strAppend = strAppend+" AND E.DFLT_IV_ROUTE_CODE = A.ROUTE_CODE AND A.IV_FLUID_YN='Y' AND A.IV_INGREDIENT_YN='N' AND A.IV_FLUID_FOR_ONCO_YN='Y'";
						}else{
							if(getcalledfrom().equals("DIRECT")){
							strAppend = strAppend +"  and DISP_VIA_PRES_ONLY_YN ='N' ";
						    }
						}
					}
					else if(getIVMedicationType().equals("IVD")){
						if(getDrugOrFluid().equals("D")){		// DRUG
							strAppend = strAppend+" AND E.DFLT_IV_ROUTE_CODE = A.ROUTE_CODE AND ((A.IV_FLUID_YN='N' AND A.IV_INGREDIENT_YN='Y') OR (A.IV_FLUID_YN='Y' AND A.IV_INGREDIENT_YN='Y')) ";
						}
						else if(getDrugOrFluid().equals("F")){	// FLUID
							strAppend =strAppend+ " AND E.DFLT_IV_ROUTE_CODE = A.ROUTE_CODE AND A.IV_FLUID_YN='Y' AND A.IV_INGREDIENT_YN='N' ";
						}
					}

					String strAppendForServiceCode = "";
					if (res_by_service==null){
						res_by_service= "";
					}
					if(res_by_service.equals("Y")){
						strAppend =strAppend+ " AND B.GENERIC_ID IN (SELECT DISTINCT GENERIC_ID FROM PH_GENERIC_NAME_FOR_SERVICE WHERE SERVICE_CODE LIKE DECODE(?,NULL,'%',SERVICE_CODE))";
					}

					if(in_formulary_yn==null){
						in_formulary_yn="";
					}
					else if(in_formulary_yn.equals("Y")){
						strAppend =strAppend+ " AND A.IN_FORMULARY_YN='Y' ";
					}
					else if (in_formulary_yn.equals("N")){
						strAppend =strAppend+ " AND A.IN_FORMULARY_YN='N' ";
					}
					//Added for INC 28155 -start
					if (priviligeDrugCheck.equals("S")){
						strAppend = strAppend+" AND or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') = 'Y' ";
					}
					
					
					//Added for INC 28155 -end
					String queryString=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_ORDER_TYPE_ATC_SELECT") + strAppend + strAppendForServiceCode +" ORDER BY A.DRUG_DESC";
					if("Y".equals(diagnosisEncountLevel)){
						queryString=queryString.replaceAll("##DIAGNOSISLEVEL##"," AND pr_diag.CURR_ENCOUNTER_ID="+getEncounterId()+"");
					}else{
						queryString=queryString.replaceAll("##DIAGNOSISLEVEL##"," ");
					}
							
					pstmt = connection.prepareStatement( queryString );
					
					
					
					order_type_code =order_type_code+ "%";
					pstmt.setString(intcount++,getPatientId());
					pstmt.setString(intcount++,getDOB());
					pstmt.setString(intcount++,getGender());
					pstmt.setString(intcount++,practitionerId);		//added for INC 28155 -get  or_get_priv_appl_yn  
					pstmt.setString(intcount++,resp_id);		//added for INC 28155 -get  or_get_priv_appl_yn
					pstmt.setString(intcount++,drug_priv_ssn_yn);	//added for INC 28155 -get  or_get_priv_appl_yn
					pstmt.setString(intcount++,getLoginFacilityId());	//added for INC 28155 -get  or_get_priv_appl_yn
					pstmt.setString(intcount++,order_type_code);
					pstmt.setString(intcount++,order_type_code);
					if (priviligeDrugCheck.equals("S")){ //in drug search Self Privilige Drugs Selected //added for INC 28155
						pstmt.setString(intcount++,practitionerId);
						pstmt.setString(intcount++,resp_id);
						pstmt.setString(intcount++,drug_priv_ssn_yn);
					}
				}
				
				pstmt.setString(intcount,lev1);
				if (identity.equals("MedicationOrder")){
					pstmt.setString(++intcount,getPatientClass().trim());
				}
				if (!lev2.equals(" ")){
					pstmt.setString(++intcount,lev2);
				}
				if (!lev3.equals(" ")){
					pstmt.setString(++intcount,lev3);
				}
				if (!lev4.equals(" ")){
					pstmt.setString(++intcount,lev4);
				}
				if (!lev5.equals(" ")){
					pstmt.setString(++intcount,lev5);
				}
				if(res_by_service.equals("Y") && identity.equals("MedicationOrder")){
					if(service_code!=null){
						service_code = service_code.trim();
					}
					pstmt.setString(++intcount,service_code);
				}
				
				//ATC Classification Drug Search - Duplicates record appearing [IN:030413]
				pstmt.setString(++intcount,getLanguageId());
				pstmt.setString(++intcount,getLanguageId());
				pstmt.setString(++intcount,getLanguageId());
				pstmt.setString(++intcount,getLanguageId());
				pstmt.setString(++intcount,getLanguageId());
				// Till here

				resultSet = pstmt.executeQuery() ;
				records.add("link");
				while ( resultSet!= null && resultSet.next() && i <= end+1 ){
					if( start != 1 && (i+1) < start ) {
						i++;
						continue;
					}
					else i++;
					count++ ;
					if(i <= end ) {
						

						String[] strArray=new String[33];//changed size for 30 to 32 for CRF RUT-CRF-0034.1[IN:037389] 32 CHANGED TO 33 FOR GHL-CRF-0548
						if (identity.equals("MedicationOrder")){
							item_code	= checkForNull(resultSet.getString("ITEM_CODE"));
						}
						strArray[0]	= checkForNull(resultSet.getString("DRUG_CODE"));
						strArray[1]	= checkForNull(resultSet.getString("DRUG_DESC"));
						strArray[2]	= checkForNull(resultSet.getString("STRENGTH_VALUE"));
						strArray[3]	= checkForNull(resultSet.getString("STRENGTH_UOM_DESC"));
						strArray[4]	= checkForNull(resultSet.getString("FORM_CODE"));
						strArray[5]	= checkForNull(resultSet.getString("FORM_DESC"));
						strArray[6]	= checkForNull(resultSet.getString("ROUTE_CODE"));
						strArray[7]	= checkForNull(resultSet.getString("ROUTE_DESC"));
						strArray[8]	= checkForNull(resultSet.getString("GENERIC_NAME")) ;
						strArray[9]	= checkForNull(resultSet.getString("GENERIC_ID"));
						strArray[10]= checkForNull(resultSet.getString("TRADE_CODE"));
						strArray[11]= checkForNull(resultSet.getString("TRADE_NAME"));
						strArray[12]= checkForNull(resultSet.getString("PRES_BASE_UOM"));
						strArray[13]= checkForNull(resultSet.getString("IN_FORMULARY_YN"));

						String in_formulary_yn = strArray[13];
						String reimburse_yn="";
						String imported_yn = "";
						String unit_price = "";
						String sys_message_id = "";
						String error_code="";
						String error_text="";
						String episode_id = "";// Added for JD-CRF-0191
						String visit_id = ""; // Added for JD-CRF-0191
						String encounter_id="";// Added for JD-CRF-0191
						if(identity.equals("MedicationOrder")&& bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){
						if(getDischargeYN().equals("Y") || getDischargeYN().equals("D")) //Added for [IN:045637]
							episode_type = "I";
	
							try{
								encounter_id= getEncounterId();// Added for JD-CRF-0191
								episode_id = encounter_id.substring(0,(encounter_id.length()-4));  // Added for  JD-CRF-0191
								visit_id = encounter_id.substring(encounter_id.length()-4);        // Added for  JD-CRF-0191
								cstmt=connection.prepareCall("{call  BL_PROC_ITEM_VALIDATIONS_MP.BL_GET_ITEM_DETAILS_MM (?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); // three more '?' added for JD-CRF-191
								cstmt.setString( 1, login_facility_id); 
								cstmt.setString( 2, episode_type); //'O'-Outpatient,'E'-Emergency ,'D'-Daycare,'I'-Inpatient,'R'-External
								cstmt.setString( 3, item_code);
								cstmt.setString( 4, ""); // p_trade_id	--If Batch level price is required (null as of now)
								cstmt.setString( 5, ""); // p_batch_id  --If Batch level price is required (null as of now
								cstmt.setString( 6, getSysdatetimesec()); // p_date
								cstmt.registerOutParameter(7, Types.VARCHAR );	//ESSENTIAL_YN 
								cstmt.registerOutParameter(8, Types.VARCHAR );	//P_REIMBURSABLE_YN Y --Reimbursible
								cstmt.registerOutParameter(9, Types.VARCHAR );	//P_REIMBURSABLE  P --> partially   F --> Fully
								cstmt.registerOutParameter(10, Types.VARCHAR ); //P_IMPORTED_YN	Y  --> Imported
								cstmt.registerOutParameter(11, Types.NUMERIC ); //PUBLIC_PRICE
								cstmt.registerOutParameter(12, Types.NUMERIC ); //P_BASE_PRICE	--Sale price as defined in billing by item/batch for respective passed Episode Type
								cstmt.registerOutParameter(13, Types.NUMERIC ); //P_REIMBURSABLE_AMT
								cstmt.registerOutParameter(14, Types.VARCHAR ); //P_REIM_OVERRIDE
								cstmt.registerOutParameter(15, Types.VARCHAR ); //P_ERROR_CODE
								cstmt.registerOutParameter(16, Types.VARCHAR ); //P_SYS_MESSAGE_ID
								cstmt.registerOutParameter(17, Types.VARCHAR ); //P_ERROR_TEXT
								cstmt.setString( 18, getPatientId()); //Added for JD-CRF-0191 - Start
								cstmt.setString( 19, episode_id);  
								cstmt.setString( 20, visit_id);  //Added for JD-CRF-0191 - End 
								cstmt.execute() ;

								reimburse_yn	= cstmt.getString(8);
								imported_yn		= cstmt.getString(10);
								unit_price		= cstmt.getString(12);
								error_code		= cstmt.getString(15);
								sys_message_id	= cstmt.getString(16);
								error_text		= cstmt.getString(17);
	

								closeStatement( cstmt );

								if(disp_price_type_in_drug_lkp.equals("P") && (error_code ==null && sys_message_id==null && error_text==null)){
									 encounter_id = getEncounterId(); // Declared as String in BL_GET_ITEM_DETAILS_MM for JD-CRF-191
									 episode_id = "";  // Declared as String in BL_GET_ITEM_DETAILS_MM for JD-CRF-191
									 visit_id = ""; // Declared as String in BL_GET_ITEM_DETAILS_MM for JD-CRF-191
									if(encounter_id!= null && !encounter_id.equals("")){
										episode_id = encounter_id;
										if(episode_type.equals("O")||episode_type.equals("E")){
											episode_id = encounter_id.substring(0,(encounter_id.length()-4));
											visit_id = encounter_id.substring(encounter_id.length()-4);
										}
									}
	
									cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
									cstmt.setString( 1, login_facility_id);
									cstmt.setString( 2, "PH");	//module id
									cstmt.setString( 3, "");	//
									cstmt.setString( 4, "");	//
									cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
									cstmt.setString( 6, getPatientId()); //patient_id
									cstmt.setString( 7, episode_id);  //episode_id
									cstmt.setString( 8, visit_id);  //p_visit_id  
									cstmt.setString( 9, ""); //p_dummy1 - null
									cstmt.setString( 10, ""); //p_dummy12 - null
									cstmt.setString( 11, "SAL"); //p_transaction_type
									cstmt.setString( 12, getSysdatetimesec()); //p_charge_date_time	--Service Data and time

									cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
									cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
									cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
									cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null

									cstmt.setString( 17, item_code);  //p_item_code

									cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
									cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 

									cstmt.setString( 20, "S");  //p_serv_panel_ind

									cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 

									cstmt.setString( 22,"1" );  //qty served
									cstmt.setString( 23, "");  //p_charge_amt  

									cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost

									cstmt.setString( 25,"" );  //p_store_code -- Store Code from where issued
									cstmt.setString( 26, "");  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
									cstmt.setString( 27,"" );  //p_oth_disc_perc if any other manual discount is given from transaction
									cstmt.setString( 28, "");  //p_source_doc_ref		null for Sale
									cstmt.setString( 29,"" );  //p_source_doc_ref_line	null for Sale

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

									cstmt.setString( 48,"" );  //p_dummy4 (IN OUT )
									cstmt.setString( 49, "");  //p_batch_prices  (IN OUT )
									
									cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
									cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
									cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
									cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?

									cstmt.setString( 54,"" );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
									cstmt.setString( 55, "");  //p_overridden_action_reason		 --- Pass null or any value entered 

									cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
									cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
									cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text

									cstmt.execute() ;
									unit_price		= cstmt.getString(40);
									error_code		= cstmt.getString(56);
									sys_message_id	= cstmt.getString(57);
									error_text		= cstmt.getString(58);
	
								}
							}catch(Exception e){
								error_text = "Error in Proc";
								unit_price = "";
								e.printStackTrace();
							}
							finally{
								closeStatement( cstmt ) ;
							}
							if(unit_price!=null){
								//corrected for PE by NAveen
								//String decimalFormatString = getDecimalFormatString();
								DecimalFormat df = new DecimalFormat(decimalFormatString);
								unit_price = df.format(Double.parseDouble(unit_price));
							}

						}
						strArray[14] = reimburse_yn;
						strArray[15] = imported_yn;
						strArray[16]= unit_price;
						strArray[17]= error_code;
						strArray[18]= sys_message_id;
						strArray[19]= error_text;
						
						if(identity.equals("MedicationOrder")){
							strArray[20]= checkForNull(resultSet.getString("DIAGNOSIS_FOUND_YN"));
							strArray[22]= checkForNull(resultSet.getString("APPL_FOR_AGE_GRP_YN"));
							strArray[23]= checkForNull(resultSet.getString("DISP_MULTI_STRENGTH_YN"));							
							strArray[24]= checkForNull(resultSet.getString("DISP_ALT_FORM_YN"));							
							strArray[25]= checkForNull(resultSet.getString("DRUG_PRIV_GRP_YN")); //ADDED for INC 28155 
						}
						else{
							strArray[20]= "";
							strArray[22]= "";
							strArray[23]= "";
							strArray[24]= "";
							strArray[25]= ""; //ADDED for INC 28155 
							
						}
						strArray[21]= checkForNull(resultSet.getString("DRUG_CLASS"));
						//ADDED for INC 28155 -Start
						strArray[26]=checkForNull(resultSet.getString("PROMPT_ALERT_PREFERRED_DRUG"));
						strArray[27]=checkForNull(resultSet.getString("stock_uom_desc"));
						strArray[28]=resultSet.getString("EXTERNAL_PRODUCT_ID");
						if(identity.equals("MedicationOrder")){
							strArray[29]=checkForNull(resultSet.getString("BILLABLE_ITEM_YN"));
						}
						else{
							strArray[29]="";
						}
						strArray[30]="";// added for CRF RUT-CRF-0034.1[IN:037389]
						strArray[31]=resultSet.getString("ROUTE_COLOR");// added for CRF RUT-CRF-0034.1[IN:037389]
						strArray[32]=resultSet.getString("DRUG_STRENGTH");//ADDED FOR GHL-CRF-0548
						//ADDED for INC 28155 -END
						records.add( strArray );
						//System.err.println("strArray[0]-- 2076-"+strArray[0]+"--strArray[1]--"+strArray[1]+"--strArray[2]--"+strArray[2]+"--strArray[3]--"+strArray[3]+"--strArray[4]--"+strArray[4]+"--strArray[5]--"+strArray[5]+"--strArray[6]--"+strArray[6]+"--strArray[7]--"+strArray[7]+"--strArray[8]--"+strArray[8]+"-strArray[9]"+strArray[9]+"--strArray[10]--"+strArray[10]+"--strArray[11]--"+strArray[11]+"--strArray[12]--"+strArray[12]+"--strArray[13]--"+strArray[14]+"--strArray[14]--"+strArray[14]+"--strArray[15]--"+strArray[15]+"--strArray[16]--"+strArray[16]+"--strArray[17]"+strArray[17]+"--strArray[18]--"+strArray[18]+"--strArray[19]--"+strArray[19]+"--strArray[20]--"+strArray[20]+"--strArray[21]--"+strArray[21]+"--strArray[22]--"+strArray[22]+"--strArray[23]--"+strArray[23]+"--strArray[24]--"+strArray[24]+"--strArray[25]--"+strArray[25]);
					}
				}
				if( start != 1 )
					prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLinkForATC('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+Classification+"');\">Previous&nbsp;&nbsp;</a>" ;
					//prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLinkForATC('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+Classification+"');\">Previous&nbsp;&nbsp;</a>" ;
				if( count > 10 )
					prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLinkForATC('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+Classification+"');\">Next</a>" ;
	                 //prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLinkForATC('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+Classification+"');\">Next</a>";
					records.set(0,prevnextlink);

			}
			catch ( Exception e ){
				e.printStackTrace() ;
				throw e ;
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
		}
		else if (stClassification.countTokens() == 1){
			records.add("cancel");
		}
		return records;
	}

/*  =====commented as the By pharma classification tab has removed=====
	public ArrayList searchBasedOnPharmacoClassfication(String Classification,String from , String to, String bl_install_yn, String disp_charge_dtl_in_drug_lkp_yn, String disp_price_type_in_drug_lkp)throws Exception{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		CallableStatement cstmt = null ;
		ResultSet resultSet		= null ;
		String episode_type= getPatientClass();
		if(episode_type !=null && (!episode_type.equals("")))
			episode_type = episode_type.substring(0,1);

		if(episode_type !=null && episode_type.equals("X"))
			episode_type = "R";
		String item_code = "";

		StringTokenizer stClassification = new StringTokenizer(Classification,"|");

		ArrayList records=new ArrayList();
		if (stClassification.countTokens() == 6){
			String lev1= (stClassification.nextToken()).trim();
//			String lev1desc= stClassification.nextToken();
			String lev2= stClassification.nextToken();
//			String lev2desc= stClassification.nextToken();
			String lev3= stClassification.nextToken();
//			String lev3desc= stClassification.nextToken();
			
//			String strAppendForNullCheck="";
			String strAppend = "";
			if (!lev2.equals(" ")){
				strAppend =strAppend+ " AND B.DRUG_CLASS_DTL_GROUP_NO_1 = ? " ;
			}
			if (! lev3.equals(" ")){
				strAppend =strAppend+ " AND B.DRUG_CLASS_DTL_GROUP_NO_2 = ? " ;
			}
			
			String prevnextlink			= "";
			int query_result_size		= 15;
			int start = 0 ;
			int end = 0 ;

			if ( from == null || from.equals(""))
				start = 1 ;
			else
				start = Integer.parseInt( from  ) ;

			if ( to == null || to.equals(""))
				end =query_result_size;
			else
				end = Integer.parseInt( to ) ;
			long count=0;
			long i = 0;
			try {
				connection = getConnection() ;
				int intcount=1;
				if (identity.equals("General")){
					pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT13A")+strAppend +" ORDER BY A.DRUG_DESC");
					pstmt.setString(intcount++,getPatientId());
					pstmt.setString(intcount++,getDOB());
					pstmt.setString(intcount++,getGender());
					
				}
				else if (identity.equals("MedicationOrder")){

					if(getIVMedicationType().equals("IVA") || getIVMedicationType().equals("") ){
						
						if(getDrugOrFluid().equals("D")){		// DRUG
							strAppend =strAppend+ " AND E.DFLT_IV_ROUTE_CODE = A.ROUTE_CODE AND A.IV_FLUID_YN='N' AND A.IV_INGREDIENT_YN='Y' ";
							
						}
						else if(getDrugOrFluid().equals("F")){	// FLUID
							strAppend =strAppend+ " AND E.DFLT_IV_ROUTE_CODE = A.ROUTE_CODE AND A.IV_FLUID_YN='Y' AND A.IV_INGREDIENT_YN='N' ";
						}
						else if(getDrugOrFluid().equals("C")){  // Cyto
							strAppend =strAppend+ " AND E.DFLT_IV_ROUTE_CODE = A.ROUTE_CODE AND A.IV_FLUID_YN='Y' AND A.IV_INGREDIENT_YN='N' AND A.IV_FLUID_FOR_ONCO_YN='Y'";
						}else{
							if(getcalledfrom().equals("DIRECT")){
							strAppend = strAppend +" and  DISP_VIA_PRES_ONLY_YN ='N' ";
						    }
						}
					}
					else if(getIVMedicationType().equals("IVD")){
						if(getDrugOrFluid().equals("D")){		// DRUG
							strAppend =strAppend+ " AND E.DFLT_IV_ROUTE_CODE = A.ROUTE_CODE AND ((A.IV_FLUID_YN='N' AND A.IV_INGREDIENT_YN='Y') OR (A.IV_FLUID_YN='Y' AND A.IV_INGREDIENT_YN='Y')) ";
						}
						else if(getDrugOrFluid().equals("F")){	// FLUID
							strAppend =strAppend+ " AND E.DFLT_IV_ROUTE_CODE = A.ROUTE_CODE AND A.IV_FLUID_YN='Y' AND A.IV_INGREDIENT_YN='N' ";
						}
					}

					String strAppendForServiceCode = "";
					if (res_by_service==null){
						res_by_service= "";
					}
					if(res_by_service.equals("Y")){
						strAppend =strAppend+ " AND B.GENERIC_ID IN (SELECT DISTINCT GENERIC_ID FROM PH_GENERIC_NAME_FOR_SERVICE WHERE SERVICE_CODE LIKE DECODE(?,NULL,'%',SERVICE_CODE))";
					}

					if(in_formulary_yn==null){
						in_formulary_yn="";
					}else if(in_formulary_yn.equals("Y")){
						strAppend =strAppend+ " AND A.IN_FORMULARY_YN='Y' ";
					}else if (in_formulary_yn.equals("N")){
						strAppend =strAppend+ " AND A.IN_FORMULARY_YN='N' ";
					}

					pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_ORDER_TYPE_PHARMA_SELECT") + strAppend + strAppendForServiceCode +" ORDER BY A.DRUG_DESC" );
					order_type_code =order_type_code+ "%";
					pstmt.setString(intcount++,getPatientId());
					pstmt.setString(intcount++,getDOB());
					pstmt.setString(intcount++,getGender());
					pstmt.setString(intcount++,order_type_code);
					pstmt.setString(intcount++,order_type_code);
				}
				pstmt.setString(intcount,lev1);
				if (identity.equals("MedicationOrder")){
					pstmt.setString(++intcount,getPatientClass().trim());
				}
				if (!lev2.equals(" ")){
					pstmt.setString(++intcount,lev2);
				}
				if (!lev3.equals(" ")){
					pstmt.setString(++intcount,lev3);

				}
				
				if(res_by_service.equals("Y") && identity.equals("MedicationOrder")){
					if(service_code!=null){
						service_code = service_code.trim();
					}
					pstmt.setString(++intcount,service_code);

				}
				resultSet = pstmt.executeQuery() ;
				records.add("link");
					while (resultSet!=null &&  resultSet.next() && i <= end+1 ){
						if( start != 1 && (i+1) < start ) {
							i++;
							continue;
						}
						else i++;
						count++ ;
						if(i <= end ) {

							String[] strArray=new String[23];
							if (resultSet.getString("DRUG_CODE")!=null){
								strArray[0]	= resultSet.getString("DRUG_CODE");
							}else{
								strArray[0]	= "";
							}
							if (resultSet.getString("DRUG_DESC")!=null){
								strArray[1]	= resultSet.getString("DRUG_DESC");
							}else{
								strArray[1]	= "";
							}
							if (resultSet.getString("STRENGTH_VALUE")!=null){
								strArray[2]	= resultSet.getString("STRENGTH_VALUE");
							}else{
								strArray[2]	= "";
							}
							if (resultSet.getString("STRENGTH_UOM_DESC")!=null){
								strArray[3]	= resultSet.getString("STRENGTH_UOM_DESC");
							}else{
								strArray[3]	= "";
							}
							if (resultSet.getString("FORM_CODE")!=null){
								strArray[4]	= resultSet.getString("FORM_CODE");
							}else{
								strArray[4]	= "";
							}
							if (resultSet.getString("FORM_DESC")!=null){
								strArray[5]	= resultSet.getString("FORM_DESC");
							}else{
								strArray[5]	= "";
							}
							if (resultSet.getString("ROUTE_CODE")!=null){
								strArray[6]	= resultSet.getString("ROUTE_CODE");
							}else{
								strArray[6]	= "";
							}
							if (resultSet.getString("ROUTE_DESC")!=null){
								strArray[7]	= resultSet.getString("ROUTE_DESC");
							}else{
								strArray[7]	= "";
							}
							if (resultSet.getString("GENERIC_NAME")!=null){
								strArray[8]	= resultSet.getString("GENERIC_NAME");
							}else{
								strArray[8]	= "";
							}
							strArray[9]	= checkForNull(resultSet.getString("GENERIC_ID"));
							//strArray[10]= checkForNull(resultSet.getString("TRADE_NAME"));
							//strArray[11]= checkForNull(resultSet.getString("PRES_BASE_UOM"));							
							strArray[10]= checkForNull(resultSet.getString("TRADE_CODE"));
							strArray[11]= checkForNull(resultSet.getString("TRADE_NAME"));
							strArray[12]= checkForNull(resultSet.getString("PRES_BASE_UOM"));
							strArray[13]= checkForNull(resultSet.getString("IN_FORMULARY_YN"));
					String in_formulary_yn = strArray[13];
					String reimburse_yn="";
					String imported_yn = "";
					String unit_price = "";
					String sys_message_id = "";
					String error_code="";
					String error_text="";

					if(identity.equals("MedicationOrder")&& bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){

						try{
							cstmt=connection.prepareCall("{call  BL_PROC_ITEM_VALIDATIONS_MP.BL_GET_ITEM_DETAILS_MM (?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?)}");
							cstmt.setString( 1, login_facility_id);
							cstmt.setString( 2, episode_type); //'O'-Outpatient,'E'-Emergency ,'D'-Daycare,'I'-Inpatient,'R'-External
							cstmt.setString( 3, item_code);
							cstmt.setString( 4, ""); // p_trade_id	--If Batch level price is required (null as of now)
							cstmt.setString( 5, ""); // p_batch_id  --If Batch level price is required (null as of now
							cstmt.setString( 6, getSysdatetimesec()); // p_date
							cstmt.registerOutParameter(7, Types.VARCHAR );	//ESSENTIAL_YN 
							cstmt.registerOutParameter(8, Types.VARCHAR );	//P_REIMBURSABLE_YN Y --Reimbursible
							cstmt.registerOutParameter(9, Types.VARCHAR );	//P_REIMBURSABLE  P --> partially   F --> Fully
							cstmt.registerOutParameter(10, Types.VARCHAR ); //P_IMPORTED_YN	Y  --> Imported
							cstmt.registerOutParameter(11, Types.NUMERIC ); //PUBLIC_PRICE
							cstmt.registerOutParameter(12, Types.NUMERIC ); //P_BASE_PRICE	--Sale price as defined in billing by item/batch for respective passed Episode Type
							cstmt.registerOutParameter(13, Types.NUMERIC ); //P_REIMBURSABLE_AMT
							cstmt.registerOutParameter(14, Types.VARCHAR ); //P_ERROR_CODE
							cstmt.registerOutParameter(15, Types.VARCHAR ); //P_SYS_MESSAGE_ID
							cstmt.registerOutParameter(16, Types.VARCHAR ); //P_ERROR_TEXT
							cstmt.execute() ;

							reimburse_yn	= cstmt.getString(8);
							imported_yn		= cstmt.getString(10);
							unit_price		= cstmt.getString(12);
							error_code		= cstmt.getString(14);
							sys_message_id	= cstmt.getString(15);
							error_text		= cstmt.getString(16);


							closeStatement( cstmt );

							if(disp_price_type_in_drug_lkp.equals("P") && (error_code ==null && sys_message_id==null && error_text==null)){
								String encounter_id = getEncounterId();
								String episode_id = "";
								String visit_id = "";
								if(encounter_id!= null && !encounter_id.equals("")){
									episode_id = encounter_id;
									if(episode_type.equals("O")||episode_type.equals("E")){
										episode_id = encounter_id.substring(0,(encounter_id.length()-4));
										visit_id = encounter_id.substring(encounter_id.length()-4);
									}
								}

								cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
								cstmt.setString( 1, login_facility_id);
								cstmt.setString( 2, "PH");	//module id
								cstmt.setString( 3, "");	//
								cstmt.setString( 4, "");	//
								cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
								cstmt.setString( 6, getPatientId()); //patient_id
								cstmt.setString( 7, episode_id);  //episode_id
								cstmt.setString( 8, visit_id);  //p_visit_id  
								cstmt.setString( 9, ""); //p_dummy1 - null
								cstmt.setString( 10, ""); //p_dummy12 - null
								cstmt.setString( 11, "SAL"); //p_transaction_type
								cstmt.setString( 12, getSysdatetimesec()); //p_charge_date_time	--Service Data and time

								cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
								cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
								cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
								cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null

								cstmt.setString( 17, item_code);  //p_item_code

								cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
								cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 

								cstmt.setString( 20, "S");  //p_serv_panel_ind

								cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 

								cstmt.setString( 22,"1" );  //qty served
								cstmt.setString( 23, "");  //p_charge_amt  

								cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost

								cstmt.setString( 25,"" );  //p_store_code -- Store Code from where issued
								cstmt.setString( 26, "");  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
								cstmt.setString( 27,"" );  //p_oth_disc_perc if any other manual discount is given from transaction
								cstmt.setString( 28, "");  //p_source_doc_ref		null for Sale
								cstmt.setString( 29,"" );  //p_source_doc_ref_line	null for Sale

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

								cstmt.setString( 48,"" );  //p_dummy4 (IN OUT )
								cstmt.setString( 49, "");  //p_batch_prices  (IN OUT )
								
								cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
								cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
								cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
								cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?

								cstmt.setString( 54,"" );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
								cstmt.setString( 55, "");  //p_overridden_action_reason		 --- Pass null or any value entered 

								cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
								cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
								cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text

								cstmt.execute() ;
								unit_price		= cstmt.getString(40);
								error_code		= cstmt.getString(56);
								sys_message_id	= cstmt.getString(57);
								error_text		= cstmt.getString(58);

							}
						}catch(Exception e){
							error_text = "Error in Proc";
							unit_price = "";
							e.printStackTrace();
						}
						finally{
							closeStatement( cstmt ) ;
						}
						if(unit_price!=null){
							String decimalFormatString = getDecimalFormatString();
							DecimalFormat df = new DecimalFormat(decimalFormatString);
							unit_price = df.format(Double.parseDouble(unit_price));
						}

					}
					strArray[14] = reimburse_yn;
					strArray[15] = imported_yn;
					strArray[16]= unit_price;
					strArray[17]= error_code;
					strArray[18]= sys_message_id;
					strArray[19]= error_text;
					if(identity.equals("MedicationOrder")){
						strArray[20]= checkForNull(resultSet.getString("DIAGNOSIS_FOUND_YN"));
						strArray[22]= checkForNull(resultSet.getString("APPL_FOR_AGE_GRP_YN"));
					}
					else{
						strArray[20]= "";
						strArray[22]= "";
					}
					strArray[21]= checkForNull(resultSet.getString("DRUG_CLASS"));
							

							records.add( strArray );
					}
				}
				if( start != 1 )
					prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLinkForATC('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+Classification+"');\">Previous&nbsp;&nbsp;</a>" ;

				if( count > 15 )
					prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLinkForATC('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+Classification+"');\">Next</a>" ;
				records.set(0,prevnextlink);
			}
			catch ( Exception e ){
				e.printStackTrace() ;
				throw e ;
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
		}else if (stClassification.countTokens() == 1){
			records.add("cancel");
		}
		return records;
	}
*/

	// The following two functions will be called if drug search will be called from medication order
	public void setDrugsAsDisabled(String drug_codes){
		StringBuffer bfr_drug_codes = new StringBuffer();
		if (drug_codes!=null){
			StringTokenizer stdrug_codes = new StringTokenizer(drug_codes,",");
			if(stdrug_codes.hasMoreTokens()) {
			while (stdrug_codes.hasMoreTokens()){
				String drug_code = stdrug_codes.nextToken();

				if (!drug_code.equals("")){
					bfr_drug_codes.append(drug_code);
					bfr_drug_codes.append(",");
				}

				disabledDrugs.put(drug_code.trim(),drug_code.trim());
			}
			} else {
				disabledDrugs.put(drug_codes.trim(),drug_codes.trim());
			}
			sel_drg_codes = bfr_drug_codes.toString();
			if(sel_drg_codes.length()>0){
				sel_drg_codes = sel_drg_codes.substring(0,sel_drg_codes.length()-1);
			}

		}
	}
	public Hashtable getDrugsAsDisabled(){
		return disabledDrugs;
	}

	public void removeSelectedDrug(String drug_code) {
			if(disabledDrugs.containsKey(drug_code)) {
				disabledDrugs.remove(drug_code);
			}
	}

	public ArrayList validateForStock(){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList stock_params	=	new ArrayList();
		String consider_stock		=	null;
		String allow_without_stock  =	null;
		String disp_charge_dtl_in_drug_lkp_yn = "";
		String disp_price_type_in_drug_lkp = "";
		//String patient_class = getPatientClass(); 

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT15") );
			pstmt.setString(1,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
				if(patient_class.equals("IP")) {
					consider_stock		=		resultSet.getString("IP_CONSIDER_STOCK_PRES_YN");
					allow_without_stock  =		resultSet.getString("IP_PRES_WITHOUT_STOCK_YN");
				} 
				else {
					consider_stock		=	resultSet.getString("CONSIDER_STOCK_FOR_PRES_YN");
					allow_without_stock  = resultSet.getString("ALLOW_PRES_WITHOUT_STOCK_YN");
				}
				disp_charge_dtl_in_drug_lkp_yn  = resultSet.getString("DISP_CHARGE_DTL_IN_DRUG_LKP_YN")==null?"":resultSet.getString("DISP_CHARGE_DTL_IN_DRUG_LKP_YN");
				disp_price_type_in_drug_lkp  = resultSet.getString("DISP_PRICE_TYPE_IN_DRUG_LKP")==null?"":resultSet.getString("DISP_PRICE_TYPE_IN_DRUG_LKP");
				stock_params.add(consider_stock);
				stock_params.add(allow_without_stock);
				stock_params.add(disp_charge_dtl_in_drug_lkp_yn);
				stock_params.add(disp_price_type_in_drug_lkp);
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
		return stock_params;
	}
//	consider_stock,allow_pres_without_stock_yn are added during PE corrections by naveen
/* 5.10 version & Modified to handle Special orders*/
	public ArrayList checkStock(String drug_code, String trade_code, String drug_class,String order_type,String consider_stock,String allow_pres_without_stock_yn,String patient_id,String encounter_id){
		System.out.println("checkStock- DrugSearchBean");  //added for NMC-JD-CRF-0063
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		CallableStatement cstmt = null ;
		ResultSet resultSet		= null ;
		String disp_locn		= "";
		String store_code		= "";
		String store_desc		= "";
		String iv_prep_yn		= getIv_prep_yn();
		ArrayList result		= new ArrayList();

		String priority			= getPriority();
		String source_type		= getsource_type();
		String p_err_msg        =""; 
		boolean site_verbal_order=false;//added for ghl-crf-0509
		boolean site_alw_disp_loc_drug_search_appl=false;//added for NMC-JD-CRF-0197
		boolean ext_disp_appl=isExt_disp_appl();//Added for IN069511
		String ext_disp_appl_yn="";//Added for IN069511
		if(priority==null)
			priority	=	"R";
		//added for NMC-JD-CRF-0063
		if(getTakeHomeMedicationOp()==null || getTakeHomeMedicationOp().equals("")){ 
			setTakeHomeMedicationOp("N"); 
		}
		if(getOpDischMedInd()==null || getOpDischMedInd()==""){
			setOpDischMedInd("N");
		} 
		if(getTakeHomeMedicationOp()!=null && !getTakeHomeMedicationOp().equals("") && getTakeHomeMedicationOp().equals("Y") && getOpDischMedInd()!=null && !getOpDischMedInd().equals("") && getOpDischMedInd().equals("Y")){
			discharge_yn = "Y";
			
		}//END
		System.out.println("getTakeHomeMedicationOp: "+getTakeHomeMedicationOp());//added for NMC-JD-CRF-0063
		System.out.println("discharge_yn: "+discharge_yn);
		System.out.println("getopDischMed: "+getOpDischMedInd()); //added for NMC-JD-CRF-0063
		try { 
			connection = getConnection() ;
			 site_verbal_order = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","PLACED_VERBAL_ORDER_YN");//added for ghl-crf-0509
			 site_alw_disp_loc_drug_search_appl = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","PH_DISP_LOC_DRUG_SEARCH");//added for NMC-JD-CRF-0197
			if(!(getDefaultDispLocnSelectAppl() && getPreAllocAppl())){//Added for TFS id:-16341
			 if(!(getcalledfrom().equals("DIRECT")) && !(site_alw_disp_loc_drug_search_appl)) {
					if(iv_prep_yn==null || iv_prep_yn.equals("")){
						
						//System.err.println("==called1==patient_class="+patient_class+",discharge_yn="+discharge_yn+",priority="+priority+",source_type="+source_type+",getsource_code()="+getsource_code()+",drug_class="+drug_class+",drug_code="+drug_code+",order_type="+order_type);
						pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT16A") );
						pstmt.setString(1,source_type);
						pstmt.setString(2,getsource_code().trim());
						pstmt.setString(3,login_facility_id);
						pstmt.setString(4,login_facility_id);
						pstmt.setString(5,drug_class);
						pstmt.setString(6,drug_code);
						pstmt.setString(7,order_type);
						pstmt.setString(8,patient_class);
						pstmt.setString(9,discharge_yn);
						pstmt.setString(10,priority);
						pstmt.setString(11,getLanguageId());
						pstmt.setString(12,"D");
						pstmt.setString(13,home_leave_yn);//added home_leave_yn_val for Bru-HIMS-CRF-093[29960]
						pstmt.setString(14,patient_id);//added home_leave_yn_val for Bru-HIMS-CRF-093[29960]
						pstmt.setString(15,encounter_id);//added home_leave_yn_val for Bru-HIMS-CRF-093[29960]
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
							System.err.println("==disp_locn=="+disp_locn);//uncommented for NMC-JD-CRF-0063
							if(disp_locn!=null && !disp_locn.equals("")){
								store_code = disp_locn.substring(0,disp_locn.indexOf("|"));
								store_desc = disp_locn.substring(disp_locn.indexOf("|")+1);
							}
							//System.err.println("==storecode1=="+store_code);
							//System.err.println("==store_desc1=="+store_desc);
						}
						closeStatement(pstmt);
						closeResultSet(resultSet);
					}
					else{
						cstmt=connection.prepareCall("{call  Ph_Ret_Spl_Ord_Disp_Locn(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//modidifed for NMC-JD-CRF-0063
						//System.err.println("==Ph_Ret_Spl_Ord_Disp_Locn==login_facility_id="+login_facility_id+",source_type="+source_type+",getsource_code="+getsource_code()+",discharge_yn="+discharge_yn+",drug_code="+drug_code+",patient_id="+patient_id+",encounter_id="+encounter_id);
						cstmt.setString( 1,login_facility_id);
						cstmt.setString( 2,source_type);
						cstmt.setString( 3, getsource_code().trim());
						cstmt.setString( 4, discharge_yn);
						cstmt.setString( 5, priority);
						cstmt.setString( 6, iv_prep_yn);
						cstmt.setString( 7, getLanguageId());
						cstmt.registerOutParameter(8, Types.VARCHAR );
						cstmt.registerOutParameter(9, Types.VARCHAR );
						cstmt.registerOutParameter(10, Types.VARCHAR );
						cstmt.registerOutParameter(11, Types.VARCHAR );
						cstmt.setString(12,drug_code);//added for MMS-QH-CRF-0048 [IN:037704]
						cstmt.setString(13,patient_id);//added for MMS-QH-CRF-0048 [IN:037704]
						cstmt.setString(14,encounter_id);//added for MMS-QH-CRF-0048 [IN:037704]
						cstmt.setString(15,getOpDischMedInd());//added for NMC-JD-CRF-0063 
						cstmt.execute() ;
						store_code = cstmt.getString(8);
						store_desc = cstmt.getString(10);
						System.err.println("==store_code=="+store_code+" store_desc="+store_desc);//uncommented for NMC-JD-CRF-0063
						closeStatement(cstmt) ;
					}
			}
			else{			
                pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT27") );
				pstmt.setString(1,getDispLocnCode());
				pstmt.setString(2,login_facility_id);
				pstmt.setString(3,getLanguageId());
		
				resultSet = pstmt.executeQuery() ;
									
				if(resultSet!=null && resultSet.next()){					
					store_code = getDispLocnCode();
					store_desc = resultSet.getString("SHORT_DESC");				
				}
				closeStatement(pstmt);
				closeResultSet(resultSet);
			}
		}//Added for TFS id:-16341 start
		else{
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT27") );
			pstmt.setString(1,getDispLocnCode());
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			resultSet = pstmt.executeQuery() ;
			
			if(resultSet!=null && resultSet.next()){					
				store_code = getDispLocnCode();
				store_desc = resultSet.getString("SHORT_DESC");				
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			
		}//Added for TFS id:-16341 end
			setStoreCode(store_code);
			setStoreDesc(store_desc);
//System.err.println("=drug_code===="+drug_code+"="+trade_code);			
//System.err.println("=store_code===="+store_code);			
//System.err.println("=sysdate===="+getSysdate());		
			cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, drug_code+"="+trade_code);
			cstmt.setString( 2, store_code);
			cstmt.setString( 3, "1");
			cstmt.setString( 4, "Y");
			cstmt.setString( 5, getSysdate());
			cstmt.setString( 6, "N");
			cstmt.setString( 7, "");
			cstmt.registerOutParameter(8, Types.VARCHAR );
			cstmt.registerOutParameter(9, Types.VARCHAR );
			cstmt.registerOutParameter(10, Types.VARCHAR );
			cstmt.registerOutParameter(11, Types.DOUBLE );
			cstmt.registerOutParameter(12, Types.VARCHAR );
			cstmt.registerOutParameter(13, Types.VARCHAR );
			cstmt.registerOutParameter(14, Types.VARCHAR );
			cstmt.registerOutParameter(15, Types.VARCHAR );
			cstmt.registerOutParameter(16, Types.VARCHAR );
			cstmt.registerOutParameter(17, Types.VARCHAR );
			cstmt.registerOutParameter(18, Types.VARCHAR );
			cstmt.registerOutParameter(19, Types.VARCHAR );
			cstmt.execute() ;


			p_err_msg = (String)(cstmt.getString(19)==null ? "":cstmt.getString(19));

			result.add((String)(cstmt.getString(8)==null ? "Y":cstmt.getString(8)));
			//Modified for IN069511 Start
			double avail_stock=0;
			if(!ext_disp_appl){
			 avail_stock = cstmt.getDouble(11);
			 ext_disp_appl_yn = "N";
			}
			else{
				if(external_disp_yn.containsKey(store_code)){
					ext_disp_appl_yn = (String)external_disp_yn.get(store_code);
				}else{
					ext_disp_appl_yn = getExtDispYN(store_code);
				}
				if(ext_disp_appl_yn.equals("Y")){
					
					pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_EXTERNAL_DISPENSING_QTY") );
					pstmt.setString(1,store_code);
					pstmt.setString(2,drug_code);

					resultSet = pstmt.executeQuery() ;
										
					if(resultSet!=null && resultSet.next()){					
							avail_stock = resultSet.getDouble("EXTERNAL_ITEM_QTY");
					}
					System.out.println("avail_stock=====>"+avail_stock);
					closeStatement(pstmt);
					closeResultSet(resultSet);
				}
				else{
					avail_stock = cstmt.getDouble(11);
				}
				 
			}
			//Modified for IN069511 End
			if(avail_stock<=0)
				avail_stock	=	0;
			if( !ext_disp_appl && !p_err_msg.equals("")){ // !ext_disp_appl Added for IN069511 - DGB Issues
				avail_stock	=	0;
			}

			result.add(avail_stock+"");
			result.add(store_desc);
			//ArrayList stock_params	=	validateForStock();
			if( consider_stock.equals("Y") ) {
					//if( ((String)stock_params.get(1)).equals("N") && avail_stock<=0)
//corrected during PE corrections By Naveen
					if( allow_pres_without_stock_yn.equals("N") && avail_stock<=0)
						result.add("disabled");
					else
						result.add("enabled");
			}
			else {
				result.add("enabled");
			}
			result.add(store_code);
			result.add(ext_disp_appl_yn);//Added for IN069511
//System.err.println("=result===="+result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return result;
	}

/* Till Here */
/*Old
	public ArrayList checkStock(String drug_code, String trade_code){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		CallableStatement cstmt = null ;
		ResultSet resultSet		= null ;
		String disp_locn		= "";
		String store_code		= "";
		String store_desc		= "";
		ArrayList result		= new ArrayList();
		String priority			=	getPriority();
		if(priority==null)
			priority	=	"R";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT16") );
			if(patient_class.equals("IP") || discharge_yn.equals("Y")){
				pstmt.setString(1,"N");
			}else{
				pstmt.setString(1,"C");
			}
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,getsource_code().trim());
			resultSet = pstmt.executeQuery() ;

			if(resultSet!=null && resultSet.next()){
				if(patient_class.equals("OP")) {
					  if(discharge_yn.equals("Y")) {
							disp_locn	=	resultSet.getString("DISCH_ORD_DISP_LOCN_CODE");
					   }else if(priority.equals("R")) {
							disp_locn	=	resultSet.getString("RTN_ORD_DISP_LOCN_CODE");
					  }else if(priority.equals("U")) {
							disp_locn	=	resultSet.getString("STAT_ORD_DISP_LOCN_CODE");
					  }
				}else{
					 if(priority.equals("R")) {
						disp_locn	=	resultSet.getString("RTN_ORD_DISP_LOCN_CODE");
					  }
					  else if(priority.equals("U")) {
						disp_locn	=	resultSet.getString("STAT_ORD_DISP_LOCN_CODE");
					  }
				}
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT17") );
			pstmt.setString(1,disp_locn);
			pstmt.setString(2,login_facility_id);
			resultSet = pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				store_code = resultSet.getString("STORE_CODE");
				store_desc = resultSet.getString("LONG_DESC");
			}

			setStoreDesc(store_desc);
			setStoreCode(store_code);
			cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, drug_code+"="+trade_code);
			cstmt.setString( 2, store_code);
			cstmt.setString( 3, "1");
			cstmt.setString( 4, "Y");
			cstmt.setString( 5, getSysdate());
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

			result.add((String)(cstmt.getString(8)==null ? "Y":cstmt.getString(8)));
			int avail_stock = cstmt.getInt(11);

			if(avail_stock<=0)
				avail_stock	=	0;

			result.add(avail_stock+"");
			result.add(store_desc);
			ArrayList stock_params	=	validateForStock();
			if( ((String)stock_params.get(0)).equals("Y") ) {
					if( ((String)stock_params.get(1)).equals("N") && avail_stock<=0)
						result.add("disabled");
					else
						result.add("enabled");
			} else {
				result.add("enabled");
			}
			

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return result;
	}
	*/
	public String getSysdate(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date				= "";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date=resultSet.getString("SYS_DATE");
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
            }catch(Exception es){
				es.printStackTrace();
			}
        }
		return sys_date;
	}

	public String getSysdatetimesec(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date_time_sec				= "";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date_time_sec=resultSet.getString("SYS_DATE_TIME_SEC");
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
		return sys_date_time_sec;
	}

/*	public boolean nationalityCheck(String patient_id) { 
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		boolean nationality_yn		= false;
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT18")) ;
			pstmt.setString(1,patient_id);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				if( resultSet.getInt("COUNT") > 0) {
					nationality_yn	=	true;
				}
			}
		}catch ( Exception e ) {
			System.err.println( "Error while checking nationality  :"+e ) ;
            e.printStackTrace() ;
		}finally {
            try{
                 closeResultSet( resultSet ) ;
                 closeStatement( pstmt ) ;
                 closeConnection( connection );
            }catch(Exception es){es.printStackTrace();}
        }
		return nationality_yn;
	}
*/
	public ArrayList showStockValues(String item_code, String trade_code) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList stock_values		= new ArrayList();;
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT20")) ;
			//pstmt					= connection.prepareStatement("SELECT A.STORE_CODE,B.SHORT_DESC,SUM(A.QTY_ON_HAND-COMMITTED_QTY) AVL_QTY FROM ST_ITEM_BATCH A, PH_DISP_LOCN_LANG_VW B, ST_ITEM_STORE C WHERE A.ITEM_CODE=? AND A.EXPIRY_DATE_OR_RECEIPT_DATE>=SYSDATE AND A.STORE_CODE=B.STORE_CODE AND  A.TRADE_ID = NVL(?,A.TRADE_ID) AND B.LANGUAGE_ID = ? AND C.STORE_CODE = A.STORE_CODE AND C.ITEM_CODE = A.ITEM_CODE AND C.EFF_STATUS = 'E' AND C.PHY_INV_ID IS NULL GROUP BY A.STORE_CODE,B.SHORT_DESC") ;
			//pstmt					= connection.prepareStatement("SELECT a.store_code, b.short_desc,  SUM (a.qty_on_hand - committed_qty) avl_qty FROM st_item_batch a, ph_disp_locn_lang_vw b, st_item_store c, st_item d WHERE a.item_code = ?  AND ( (  d.USE_AFTER_EXPIRY_YN = 'N'  AND a.expiry_date_or_receipt_date >= SYSDATE ) OR ( d.USE_AFTER_EXPIRY_YN = 'Y' ) )  AND a.store_code = b.store_code  AND a.trade_id = NVL (?, a.trade_id)  AND b.language_id = ?  AND c.store_code = a.store_code  AND c.item_code = a.item_code  AND c.eff_status = 'E'  AND c.phy_inv_id IS NULL AND d.item_code = a.item_code and a.SUSPENDED_YN ='N' GROUP BY a.store_code, b.short_desc") ;
			pstmt.setString(1,item_code);
			pstmt.setString(2,trade_code);
			pstmt.setString(3,getLanguageId());
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				stock_values.add(resultSet.getString("STORE_CODE"));
				stock_values.add(resultSet.getString("SHORT_DESC"));
				stock_values.add(resultSet.getString("AVL_QTY"));				
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
		return stock_values;
	}

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
		return stock_uom;
	}

	public String getExternalProductId(String drug_code) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String external_product_id  = "";
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_EXT_PRODUCT_ID")) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2,login_facility_id.trim());
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				external_product_id = resultSet.getString("EXTERNAL_PRODUCT_ID");
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
		return external_product_id;
	}
//strength_value AND drug_stringth_uom added for ghl-crf-0548,
	public ArrayList searchForAltDrugs(String generic_code,String route_code,String drug_code, String bl_install_yn, String disp_charge_dtl_in_drug_lkp_yn, String disp_price_type_in_drug_lkp, String store_code,String strength_value,String drug_strength_uom)throws Exception{ //store_code added for MMS-DM-CRF-0009 [IN:054440]

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		CallableStatement cstmt = null ;
		ResultSet resultSet		= null ;
		String episode_type= getPatientClass();
		String multi_strengh_applicable=displayByMultiStrength(drug_code);//ADDED FOR GHL-CRF-0548
		
		if(episode_type !=null && (!episode_type.equals("")))
			episode_type = episode_type.substring(0,1);

		if(episode_type !=null && episode_type.equals("X"))
			episode_type = "R";
		String item_code = "";
		int index=0;
		ArrayList records=new ArrayList();
		double avail_stock = 0;
		String[] strArray = null;
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_ALT_DRUG")); Commented by Naveen on 18/Nov/2010 for the incident num:25007(Getting UOM Desc in thai)
			//Query Modified By Naveen===for the incident num:25007 
			//GHL-CRF-0618 - start
			String append_query = "";
			if(!this.formulary_blng_app)
			append_query = "and DRUG_CODE !=?";
			
			//GHL-CRF-061 - end
			
			//added for ghl-crf-0548 start
			if(multi_strengh_applicable.equals("S") && !drug_strength_uom.equals("") && !strength_value.equals("") && !strength_value.equals("0") ){
			
			pstmt = connection.prepareStatement( "SELECT DRUG_CODE , ITEM_CODE, DRUG_DESC, STRENGTH_PER_PRES_UOM, STRENGTH_UOM_DESC, FORM_CODE,FORM_DESC, ROUTE_CODE, ROUTE_DESC, GENERIC_NAME,GENERIC_ID, TRADE_CODE, TRADE_NAME, PH_GET_UOM_DISPLAY(?,PRES_BASE_UOM,?) PRES_BASE_UOM, PH_GET_UOM_DISPLAY(?,STRENGTH_UOM,?) STRENGTH_UOM, STRENGTH_PER_VALUE_PRES_UOM, IN_FORMULARY_YN, NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(PH_DRUG_VW.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, ph_get_stock_avail_qty(ph_drug_vw.DRUG_CODE || decode(ph_drug_vw.TRADE_CODE, null, '', '='|| ph_drug_vw.TRADE_CODE), ?, ?, ?, TO_DATE(?,'dd/mm/yyyy hh24:mi'), ?, ? ) avail_qty, a.short_desc stock_uom_desc  FROM ph_drug_vw_lang_vw ph_drug_vw, am_uom_lang_vw a WHERE GENERIC_ID = ? AND ROUTE_CODE = ?  /*AND DRUG_CODE !=? */" +append_query+ "AND ph_drug_vw.strength_value =? and ph_drug_vw.strength_uom=? and NPB_DRUG_YN <> 'Y' and  ph_drug_vw.stock_uom = a.uom_code(+)  AND LANG1 = ? AND DECODE(LANG2,NULL,?,LANG2)= ? AND DECODE(LANG3,NULL,?,LANG3)= ? and a.language_id = ?  ORDER BY avail_qty desc, DRUG_DESC"); 
			}else{
				pstmt = connection.prepareStatement( "SELECT DRUG_CODE , ITEM_CODE, DRUG_DESC, STRENGTH_PER_PRES_UOM, STRENGTH_UOM_DESC, FORM_CODE,FORM_DESC, ROUTE_CODE, ROUTE_DESC, GENERIC_NAME,GENERIC_ID, TRADE_CODE, TRADE_NAME, PH_GET_UOM_DISPLAY(?,PRES_BASE_UOM,?) PRES_BASE_UOM, PH_GET_UOM_DISPLAY(?,STRENGTH_UOM,?) STRENGTH_UOM, STRENGTH_PER_VALUE_PRES_UOM, IN_FORMULARY_YN, NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(PH_DRUG_VW.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, ph_get_stock_avail_qty(ph_drug_vw.DRUG_CODE || decode(ph_drug_vw.TRADE_CODE, null, '', '='|| ph_drug_vw.TRADE_CODE), ?, ?, ?, TO_DATE(?,'dd/mm/yyyy hh24:mi'), ?, ? ) avail_qty, a.short_desc stock_uom_desc  FROM ph_drug_vw_lang_vw ph_drug_vw, am_uom_lang_vw a WHERE GENERIC_ID = ? AND ROUTE_CODE = ? /*AND DRUG_CODE !=? */"+append_query+ " and NPB_DRUG_YN <> 'Y' and  ph_drug_vw.stock_uom = a.uom_code(+) AND LANG1 = ? AND DECODE(LANG2,NULL,?,LANG2)= ? AND DECODE(LANG3,NULL,?,LANG3)= ? and a.language_id = ? ORDER BY avail_qty desc, DRUG_DESC");
			}
			//added for ghl-crf-0548 end

			//Query modified  for IN23171 to display uom code or desc based on param_facility value --09/08/2010-- priya 
			pstmt.setString(++index,login_facility_id.trim());
			pstmt.setString(++index,getLanguageId());
			pstmt.setString(++index,login_facility_id.trim());
			pstmt.setString(++index,getLanguageId());
			pstmt.setString(++index,getPatientId());
			pstmt.setString(++index,getDOB());
			pstmt.setString(++index,getGender());
			pstmt.setString(++index,store_code);
			pstmt.setString(++index,"1");
			pstmt.setString(++index,"Y");
			pstmt.setString(++index, getSysdate());
			pstmt.setString(++index, "N");
			pstmt.setString(++index, "");
			pstmt.setString(++index,generic_code.trim());
			pstmt.setString(++index,route_code.trim());
			if(!this.formulary_blng_app) //GHL-CRF-0618 
			pstmt.setString(++index,drug_code.trim());
          //added for ghl-crf-0548 start
			if(multi_strengh_applicable.equals("S") && !drug_strength_uom.equals("") && !strength_value.equals("") && !strength_value.equals("0")){
				pstmt.setString(++index,strength_value);
				pstmt.setString(++index,drug_strength_uom);
				
			}
			//added for ghl-crf-0548 end
			pstmt.setString(++index,getLanguageId());
			pstmt.setString(++index,getLanguageId());
			pstmt.setString(++index,getLanguageId());
			pstmt.setString(++index,getLanguageId());
			pstmt.setString(++index,getLanguageId());
			pstmt.setString(++index,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet!=null &&  resultSet.next()){
				item_code = checkForNull(resultSet.getString("ITEM_CODE"));
				strArray=new String[25]; //size increased from 23 to 25 for MMS-DM-CRF-0009 [IN:054440]
				strArray[0]	= resultSet.getString("DRUG_CODE");
				strArray[1]	= resultSet.getString("DRUG_DESC");
				if (resultSet.getString("STRENGTH_PER_PRES_UOM")!=null && !(resultSet.getString("STRENGTH_PER_PRES_UOM")).equals("0") ){
					strength1=resultSet.getString("STRENGTH_PER_PRES_UOM");
					strArray[2]	= strength1+"~"+resultSet.getString("STRENGTH_UOM")+"~/~"+resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")+"~"+resultSet.getString("PRES_BASE_UOM");
					//System.err.println("strArray[2]==3070 bean===>" +strArray[2]);
				}
				else{
					strArray[2]	= "";
				}
				strArray[3]	= checkForNull(resultSet.getString("STRENGTH_UOM_DESC"));
				strArray[4]	= checkForNull(resultSet.getString("FORM_CODE"));
				strArray[5]	= checkForNull(resultSet.getString("FORM_DESC"));
				strArray[6]	= checkForNull(resultSet.getString("ROUTE_CODE"));
				strArray[7]	= checkForNull(resultSet.getString("ROUTE_DESC"));
				strArray[8]	= checkForNull(resultSet.getString("GENERIC_NAME"));
				strArray[9]	= checkForNull(resultSet.getString("GENERIC_ID"));
				strArray[10]= checkForNull(resultSet.getString("TRADE_CODE"));
				strArray[11]= checkForNull(resultSet.getString("TRADE_NAME"));
				strArray[12]= checkForNull(resultSet.getString("PRES_BASE_UOM"));
				strArray[13]= checkForNull(resultSet.getString("IN_FORMULARY_YN"));

				String in_formulary_yn = strArray[13];
				String reimburse_yn="";
				String imported_yn = "";
				String unit_price = "";
				String sys_message_id = "";
				String error_code="";
				String error_text="";
				String episode_id = "";// Added for JD-CRF-0191
				String visit_id = ""; // Added for JD-CRF-0191
				String encounter_id="";// Added for JD-CRF-0191

					if(identity.equals("MedicationOrder")&& bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){
						if(getDischargeYN().equals("Y") || getDischargeYN().equals("D")) //Added for [IN:045637]
							episode_type = "I";

						try{
							
							encounter_id= getEncounterId();// Added for JD-CRF-0191
							//episode_id = encounter_id.substring(0,(encounter_id.length()-4));  // Added for  JD-CRF-0191
							//visit_id = encounter_id.substring(encounter_id.length()-4);        // Added for  JD-CRF-0191
							//added for ghl-crf-0548 start
							if(encounter_id!= null && !encounter_id.equals("")){
								episode_id = encounter_id;
								if(episode_type.equals("O")||episode_type.equals("E")){
									episode_id = encounter_id.substring(0,(encounter_id.length()-4));
									visit_id = encounter_id.substring(encounter_id.length()-4);
								}
							}
							//added for ghl-crf-0548 end
							cstmt=connection.prepareCall("{call  BL_PROC_ITEM_VALIDATIONS_MP.BL_GET_ITEM_DETAILS_MM (?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); // three more '?' added for JD-CRF-191
							cstmt.setString( 1, login_facility_id);
							cstmt.setString( 2, episode_type); //'O'-Outpatient,'E'-Emergency ,'D'-Daycare,'I'-Inpatient,'R'-External
							cstmt.setString( 3, item_code);
							cstmt.setString( 4, ""); // p_trade_id	--If Batch level price is required (null as of now)
							cstmt.setString( 5, ""); // p_batch_id  --If Batch level price is required (null as of now
							cstmt.setString( 6, getSysdatetimesec()); // p_date
							cstmt.registerOutParameter(7, Types.VARCHAR );	//ESSENTIAL_YN 
							cstmt.registerOutParameter(8, Types.VARCHAR );	//P_REIMBURSABLE_YN Y --Reimbursible
							cstmt.registerOutParameter(9, Types.VARCHAR );	//P_REIMBURSABLE  P --> partially   F --> Fully
							cstmt.registerOutParameter(10, Types.VARCHAR ); //P_IMPORTED_YN	Y  --> Imported
							cstmt.registerOutParameter(11, Types.NUMERIC ); //PUBLIC_PRICE
							cstmt.registerOutParameter(12, Types.NUMERIC ); //P_BASE_PRICE	--Sale price as defined in billing by item/batch for respective passed Episode Type
							cstmt.registerOutParameter(13, Types.NUMERIC ); //P_REIMBURSABLE_AMT
							cstmt.registerOutParameter(14, Types.VARCHAR ); //P_REIM_OVERRIDE
							cstmt.registerOutParameter(15, Types.VARCHAR ); //P_ERROR_CODE
							cstmt.registerOutParameter(16, Types.VARCHAR ); //P_SYS_MESSAGE_ID
							cstmt.registerOutParameter(17, Types.VARCHAR ); //P_ERROR_TEXT
							cstmt.setString( 18, getPatientId()); //Added for JD-CRF-0191 - Start
							cstmt.setString( 19, episode_id);  
							cstmt.setString( 20, visit_id);  //Added for JD-CRF-0191 - End 
							cstmt.execute() ;

							reimburse_yn	= cstmt.getString(8);
							imported_yn		= cstmt.getString(10);
							unit_price		= cstmt.getString(12);
							error_code		= cstmt.getString(15);
							sys_message_id	= cstmt.getString(16);
							error_text		= cstmt.getString(17);


							closeStatement( cstmt );

							if(disp_price_type_in_drug_lkp.equals("P") && (error_code ==null && sys_message_id==null && error_text==null)){
							    encounter_id = getEncounterId(); // Declared as String in BL_GET_ITEM_DETAILS_MM for JD-CRF-191
								episode_id = ""; // Declared as String in BL_GET_ITEM_DETAILS_MM for JD-CRF-191
								visit_id = ""; // Declared as String in BL_GET_ITEM_DETAILS_MM for JD-CRF-191
								if(encounter_id!= null && !encounter_id.equals("")){
									episode_id = encounter_id;
									if(episode_type.equals("O")||episode_type.equals("E")){
										episode_id = encounter_id.substring(0,(encounter_id.length()-4));
										visit_id = encounter_id.substring(encounter_id.length()-4);
									}
								}

								cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
								cstmt.setString( 1, login_facility_id);
								cstmt.setString( 2, "PH");	//module id
								cstmt.setString( 3, "");	//
								cstmt.setString( 4, "");	//
								cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
								cstmt.setString( 6, getPatientId()); //patient_id
								cstmt.setString( 7, episode_id);  //episode_id
								cstmt.setString( 8, visit_id);  //p_visit_id  
								cstmt.setString( 9, ""); //p_dummy1 - null
								cstmt.setString( 10, ""); //p_dummy12 - null
								cstmt.setString( 11, "SAL"); //p_transaction_type
								cstmt.setString( 12, getSysdatetimesec()); //p_charge_date_time	--Service Data and time

								cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
								cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
								cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
								cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null

								cstmt.setString( 17, item_code);  //p_item_code

								cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
								cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 

								cstmt.setString( 20, "S");  //p_serv_panel_ind

								cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 

								cstmt.setString( 22,"1" );  //qty served
								cstmt.setString( 23, "");  //p_charge_amt  

								cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost

								cstmt.setString( 25,"" );  //p_store_code -- Store Code from where issued
								cstmt.setString( 26, "");  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
								cstmt.setString( 27,"" );  //p_oth_disc_perc if any other manual discount is given from transaction
								cstmt.setString( 28, "");  //p_source_doc_ref		null for Sale
								cstmt.setString( 29,"" );  //p_source_doc_ref_line	null for Sale

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

								cstmt.setString( 48,"" );  //p_dummy4 (IN OUT )
								cstmt.setString( 49, "");  //p_batch_prices  (IN OUT )
								
								cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
								cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
								cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
								cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?

								cstmt.setString( 54,"" );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
								cstmt.setString( 55, "");  //p_overridden_action_reason		 --- Pass null or any value entered 

								cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
								cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
								cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text

								cstmt.execute() ;
								unit_price		= cstmt.getString(40);
								error_code		= cstmt.getString(56);
								sys_message_id	= cstmt.getString(57);
								error_text		= cstmt.getString(58);

							}
						}
						catch(Exception e){
							error_text = "Error in Proc";
							unit_price = "";
							e.printStackTrace();
						}
						finally{
							closeStatement( cstmt ) ;
						}
						if(unit_price!=null){
							String decimalFormatString = getDecimalFormatString();
							DecimalFormat df = new DecimalFormat(decimalFormatString);
							unit_price = df.format(Double.parseDouble(unit_price));
						}

					}
					strArray[14] = reimburse_yn;
					strArray[15] = imported_yn;
					strArray[16]= unit_price;
					strArray[17]= error_code;
					strArray[18]= sys_message_id;
					strArray[19]= error_text;
					if(identity.equals("MedicationOrder")){
						strArray[20]= checkForNull(resultSet.getString("DIAGNOSIS_FOUND_YN"));
						strArray[22]= checkForNull(resultSet.getString("APPL_FOR_AGE_GRP_YN"));
					}
					else{
						strArray[20]= "";
						strArray[22]= "";
					}
					strArray[21]= checkForNull(resultSet.getString("DRUG_CLASS"));	
					avail_stock = resultSet.getDouble("AVAIL_QTY"); //added for for MMS-DM-CRF-0009 [IN:054440] -start
					strArray[23]= avail_stock+"";				
					strArray[24]= checkForNull(resultSet.getString("STOCK_UOM_DESC")); //added for for MMS-DM-CRF-0009 [IN:054440] -end				
					records.add( strArray );
				}
			}
			catch ( Exception e ){
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
		return records;
	}

	public String getAlert_YN(String drug_code)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String prompt_alert_yn	= "";
		String prompt_alert_msg	= "";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_NAME_SELECT1"));
			pstmt.setString(1, drug_code);

			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {

				prompt_alert_yn	=	resultSet.getString("PROMPT_ALERT_YN");
				if(prompt_alert_yn.equals("Y"))
				{
                 prompt_alert_msg	=	resultSet.getString("PROMPT_ALERT_MSG");
				 if(prompt_alert_msg==null)
					 prompt_alert_msg="";

				}else
				{
					 prompt_alert_msg="";
				}
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
		return prompt_alert_msg;
	}

	public String getAlertForPreferredDrug_YN(String drug_code)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String prompt_alert_yn	= "";
		String qryString ="SELECT PROMPT_ALERT_PREFERRED_DRUG FROM PH_DRUG WHERE DRUG_CODE = ?";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(qryString);
			pstmt.setString(1, drug_code);

			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				prompt_alert_yn	=	resultSet.getString("PROMPT_ALERT_PREFERRED_DRUG")==null?"":resultSet.getString("PROMPT_ALERT_PREFERRED_DRUG");		
				if (prompt_alert_yn == "" || prompt_alert_yn == null)
				{
					prompt_alert_yn = "N";
				}
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
		return prompt_alert_yn;
	}

	public String getAlertForItemYN(String facility_id)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String prompt_alert_yn	= "";
		String qryString ="SELECT PROMPT_ALERT_FPR_PREF_CHK_YN FROM PH_FACILITY_PARAM WHERE FACILITY_ID = ?";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(qryString);
			pstmt.setString(1, facility_id);

			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				prompt_alert_yn	=	resultSet.getString("PROMPT_ALERT_FPR_PREF_CHK_YN")==null?"":resultSet.getString("PROMPT_ALERT_FPR_PREF_CHK_YN");		
				
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
		return prompt_alert_yn;
	}	
	
	public String returnEpisodeType(){
		String  episodeType= getPatientClass();
		if(episodeType !=null && (!episodeType.equals("")))
			episodeType = episodeType.substring(0,1);

		if(episodeType !=null && episodeType.equals("X"))
			episodeType = "R";
		//String item_code = "";
		return episodeType;
	}

	public String returnEpisodeID(String episode_type,String encounter_id){	  
		String episode_id="";;
		if(encounter_id!= null && !encounter_id.equals(""))
			episode_id = encounter_id;
		if(episode_type.equals("O")||episode_type.equals("E")){
			episode_id = encounter_id.substring(0,(encounter_id.length()-4)); 
		}
		return episode_id; 
	}

	public String returnVisitID(String episode_type,String encounter_id){
		String visit_id = "";
		if(episode_type.equals("O")||episode_type.equals("E"))
		visit_id = encounter_id.substring(encounter_id.length()-4);
		return visit_id;								
	}

	public ArrayList returnBillingPreferenceCheckValues(String facility_id,String patient_id,String episodeType, String episodeId,String visitId,String encounter_id,String itemCode){
		Connection connection	= null ;
		CallableStatement cstmt = null ;
		billingCheckValues = new ArrayList();
		String billPrefenceCheck_YN	= "";
		String preferenceBasisInd	= "";
		String preferredItemCode	= "";
		String errorCode			= "";
		String sysMessageId			= "";
		String errorText			= "";
		String bl_priority			= "";
			

		try {
			connection			= getConnection();
			//System.err.println("@@@bean3714-->facility_id-->"+facility_id+"-->patient_id-->"+patient_id+"-->episodeType-->"+episodeType+"-->episodeId-->"+episodeId+"-->visitId-->"+visitId+"-->encounter_id-->"+encounter_id+"-->itemCode-->"+itemCode);
			cstmt=connection.prepareCall("{call  BLCOMMON.BL_MM_PREF_LOC_ITEM_FOR_IMP(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, facility_id);
			cstmt.setString( 2, patient_id); 
			cstmt.setString( 3, episodeType);
			cstmt.setString( 4, episodeId);
			cstmt.setString( 5, visitId);
			cstmt.setString( 6, encounter_id); 
			cstmt.setString( 7, itemCode);
			cstmt.registerOutParameter(8, Types.VARCHAR );	
			cstmt.registerOutParameter(9, Types.VARCHAR );	
			cstmt.registerOutParameter(10, Types.VARCHAR ); 

			cstmt.registerOutParameter(11, Types.VARCHAR ); 
			cstmt.registerOutParameter(12, Types.VARCHAR ); 
			cstmt.registerOutParameter(13, Types.VARCHAR ); 
			cstmt.registerOutParameter(14, Types.VARCHAR ); 
			cstmt.execute();
			billPrefenceCheck_YN	= cstmt.getString(8);
			preferenceBasisInd		= cstmt.getString(9);
			preferredItemCode		= cstmt.getString(10);
			bl_priority		= cstmt.getString(11);
			errorCode		= cstmt.getString(12);
			sysMessageId	= cstmt.getString(13);
			errorText		= cstmt.getString(14);
			//System.err.println("@@billPrefenceCheck_YN- 3274->"+billPrefenceCheck_YN+"-->preferenceBasisInd-->"+preferenceBasisInd+"-->preferredItemCode-->"+preferredItemCode+"-->error_code-->"+errorCode+"-->sysMessageId-->"+sysMessageId+"-->errorText-->"+errorText);
			billingCheckValues.add(billPrefenceCheck_YN);
			billingCheckValues.add(preferenceBasisInd);
			billingCheckValues.add(preferredItemCode);
			billingCheckValues.add(bl_priority);
			billingCheckValues.add(errorCode);
			billingCheckValues.add(sysMessageId);
			billingCheckValues.add(errorText);
		} 
		catch(Exception e) {
			//System.err.println("Exception raised in the procedure BLCOMMON.BL_MM_PREF_LOC_ITEM_FOR_IMP-->"+e);
			//e.printStackTrace();//commented for reduce log size
			billingCheckValues = null;
			return billingCheckValues;
		}
		finally {
			try {
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return billingCheckValues;
	 }

	public ArrayList getPreferredDrugDetails(String item_code){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList preferredDrugDetails = new ArrayList();
		String qryString =	"SELECT DRUG_CODE, DRUG_DESC, DRUG_CLASS, TRADE_CODE, TRADE_NAME, FORM_CODE, FORM_DESC, STRENGTH_UOM, STRENGTH_PER_PRES_UOM,STRENGTH_PER_VALUE_PRES_UOM,PRES_BASE_UOM, STOCK_UOM_DESC  FROM PH_DRUG_VW_LANG_VW PH_DRUG_VW  WHERE ITEM_CODE = ?   AND LANG1 = ?  AND LANG2 =?  AND LANG3 = ?";
		
		try {
			connection = getConnection() ;
			// For Order Type
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT14") );
			pstmt = connection.prepareStatement(qryString);
			pstmt.setString(1,item_code);
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
				preferredDrugDetails.add(resultSet.getString("DRUG_CODE"));
				preferredDrugDetails.add(resultSet.getString("DRUG_DESC"));
				preferredDrugDetails.add(resultSet.getString("DRUG_CLASS"));
				preferredDrugDetails.add(resultSet.getString("TRADE_CODE"));
				preferredDrugDetails.add(resultSet.getString("TRADE_NAME"));
				preferredDrugDetails.add(resultSet.getString("FORM_CODE"));
				preferredDrugDetails.add(resultSet.getString("FORM_DESC"));
				preferredDrugDetails.add(resultSet.getString("STRENGTH_UOM"));
				preferredDrugDetails.add(resultSet.getString("STRENGTH_PER_PRES_UOM"));
				preferredDrugDetails.add(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM"));
				preferredDrugDetails.add(resultSet.getString("PRES_BASE_UOM"));
				preferredDrugDetails.add(resultSet.getString("STOCK_UOM_DESC"));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return preferredDrugDetails;
	}

	public String getGenericId(String drug_code){
		String generic_id ="";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String qryString =	"SELECT GENERIC_ID FROM PH_DRUG WHERE DRUG_CODE =?";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(qryString);
			pstmt.setString(1,drug_code);
			resultSet=pstmt.executeQuery();
			if(resultSet != null && resultSet.next()){
			generic_id=resultSet.getString("GENERIC_ID");				
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
				es.printStackTrace();
			}
		}

		return generic_id;
	}
	public ArrayList getPreferredGenericDrugDetails(String generic_id, String item_code){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList preferredDrugGenericDetails = new ArrayList();
		String qryString =	"SELECT DRUG_CODE, DRUG_DESC , DRUG_CLASS , TRADE_CODE , TRADE_NAME , FORM_CODE , FORM_DESC , PRES_BASE_UOM , STOCK_UOM_DESC , STRENGTH_PER_PRES_UOM , STRENGTH_PER_VALUE_PRES_UOM , STRENGTH_UOM   FROM MM_ITEM A, PH_DRUG_VW_LANG_VW B  WHERE A.ITEM_CODE = B.ITEM_CODE  AND A.IMPORTED_ITEM_YN = 'N'    AND B.GENERIC_ID =?  AND B.ITEM_CODE <> ? AND B.LANG1 = ? AND B.LANG2 = ? AND B.LANG3 = ?  ";
		try {
			connection = getConnection() ;
			// For Order Type
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT14") );
			pstmt = connection.prepareStatement(qryString);
			pstmt.setString(1,generic_id);
			pstmt.setString(2,item_code);
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,getLanguageId());
			pstmt.setString(5,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
				preferredDrugGenericDetails.add(resultSet.getString("DRUG_CODE"));
				preferredDrugGenericDetails.add(resultSet.getString("DRUG_DESC"));
				preferredDrugGenericDetails.add(resultSet.getString("DRUG_CLASS"));
				preferredDrugGenericDetails.add(resultSet.getString("TRADE_CODE"));
				preferredDrugGenericDetails.add(resultSet.getString("TRADE_NAME"));
				preferredDrugGenericDetails.add(resultSet.getString("FORM_CODE"));
				preferredDrugGenericDetails.add(resultSet.getString("FORM_DESC"));
				preferredDrugGenericDetails.add(resultSet.getString("STRENGTH_UOM"));
				preferredDrugGenericDetails.add(resultSet.getString("STRENGTH_PER_PRES_UOM"));
				preferredDrugGenericDetails.add(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM"));
				preferredDrugGenericDetails.add(resultSet.getString("PRES_BASE_UOM"));
				preferredDrugGenericDetails.add(resultSet.getString("STOCK_UOM_DESC"));
				
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
		return preferredDrugGenericDetails;
	}

	public ArrayList searchBasedOnDataSelected_preferred(String from , String to, String bl_install_yn, String disp_charge_dtl_in_drug_lkp_yn, String disp_price_type_in_drug_lkp, String genericId, String drugCode,String billingSpecificIndex,String drug_priv_ssn_yn,String billingPriority)throws Exception{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		CallableStatement cstmt = null ;
		ResultSet resultSet		= null ;
		String generic_id="",drug_id="",trade_id="",pract_type="";

		ArrayList records=new ArrayList();
	//	String prevnextlink			= "";  Removed for IN063877 
		int query_result_size		= 10;
		int start = 0 ;
		int end = 0 ;

		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if(identity.equals("MedicationOrder")){
			query_result_size = 10;//5 changed to 10 
		}
		else{
			query_result_size = 10;
		}

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;

		String generic_name="";
		String drug_desc="";
		String trade_desc="";
		String temp_manufacturer_short_name="";
		String episode_type= getPatientClass();
		if(episode_type !=null && (!episode_type.equals("")))
			episode_type = episode_type.substring(0,1);

		if(episode_type !=null && episode_type.equals("X"))
			episode_type = "R";
		String item_code = "";
		String encounter_id = getEncounterId();
		String episode_id = "";
		String visit_id = "";
		String sql = "";
		if(encounter_id!= null && !encounter_id.equals("")){
			episode_id = encounter_id;
			if(episode_type.equals("O")||episode_type.equals("E")){
				episode_id = encounter_id.substring(0,(encounter_id.length()-4));
				visit_id = encounter_id.substring(encounter_id.length()-4);
			}
		}
		
	//	long count=0;  Removed for IN063877
	//	long i = 0; Removed for IN063877

		try {
			connection = getConnection() ;
			if(identity.equals("General")){
				if (search_by.equals("A")){
					pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ALL_DRUG_SEARCH_SELECT"));
					//pstmt = connection.prepareStatement( "SELECT DRUG_CODE, ITEM_CODE, DRUG_DESC, FORM_CODE, FORM_DESC, STRENGTH_VALUE, STRENGTH_UOM, STRENGTH_UOM_DESC,STRENGTH_PER_PRES_UOM, STRENGTH_PER_VALUE_PRES_UOM,PRES_BASE_UOM,ROUTE_CODE, ROUTE_DESC,TRADE_NAME,GENERIC_NAME,GENERIC_ID,PRES_BASE_UOM,IN_FORMULARY_YN,TRADE_CODE, DRUG_CLASS FROM  PH_DRUG_VW_LANG_VW PH_DRUG_VW WHERE DISCONTINUED_YN = 'N' AND UPPER(GENERIC_ID) LIKE UPPER(?) AND (UPPER(GENERIC_NAME) LIKE UPPER(?) OR UPPER(DRUG_DESC) LIKE UPPER(?) OR UPPER(NVL(TRADE_NAME,'X')) LIKE UPPER(?)) AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(FORM_CODE) LIKE UPPER(?) AND UPPER(ROUTE_CODE) LIKE UPPER(?)   AND NVL(STRENGTH_UOM,'X') LIKE UPPER(?) AND NVL(DRUG_CLASS,'X') LIKE ? AND NVL(SCHEDULE_ID,'X') LIKE UPPER(?) AND NVL(RESTRICTED_DRUG_YN,'X') LIKE DECODE(?,'B',RESTRICTED_DRUG_YN,?) AND NVL(DRUG_TYPE,'X') LIKE DECODE(?,'A',DRUG_TYPE,?) AND NVL(IV_INGREDIENT_YN,'X') LIKE DECODE(?,'B',IV_INGREDIENT_YN,?) AND NVL(IV_FLUID_YN,'X') LIKE DECODE(?,'B',IV_FLUID_YN,?) AND NVL(COMPOUND_DRUG_YN,'X') LIKE DECODE(?,'B',COMPOUND_DRUG_YN,?) AND NVL(IN_FORMULARY_YN,'X') LIKE DECODE(?,'B',IN_FORMULARY_YN,?) AND NVL(AFFECTS_PREGNANCY_YN,'X') LIKE DECODE(?,'B',AFFECTS_PREGNANCY_YN,?) AND NVL(AFFECTS_LAB_RESULTS_YN,'X') LIKE DECODE(?,'B',AFFECTS_LAB_RESULTS_YN,?) AND NVL(AFFECTS_BREAST_FEEDING_YN,'X') LIKE DECODE(?,'B',AFFECTS_BREAST_FEEDING_YN,?) AND  UPPER(NVL(MANUFACTURER_ID,'X')) LIKE UPPER(?) AND UPPER(NVL(MANUFACTURER_NAME,'X')) LIKE UPPER(?) AND   UPPER(NVL(TRADE_CODE,'X')) LIKE UPPER(?) AND LANG1 = ? AND DECODE(LANG2,NULL,?,LANG2)= ? AND  DECODE(LANG3,NULL,?,LANG3)= ? ORDER BY DRUG_DESC,FORM_DESC");
				}
				else{
					pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT")+" ORDER BY DRUG_DESC,FORM_DESC");
				}

				if (search_by.equals("G")){
					drug_id="";
					drug_desc="%";
					generic_id=code;
					if(drug_search_by.equals("S"))
						generic_name = name+"%";  
					else if(drug_search_by.equals("C"))
						generic_name = "%"+name+"%";
					else                    
						generic_name = "%"+name;
					//generic_name = "%"+name+"%";
					trade_id="";
					trade_desc="%";
				}
				else if (search_by.equals("D")){
					drug_id=code;
					//drug_desc="%"+name+"%";
					if(drug_search_by.equals("S"))
						drug_desc = name+"%";  
					else if(drug_search_by.equals("C"))
						drug_desc = "%"+name+"%";
					else                      
						drug_desc = "%"+name;

					generic_id="";
					generic_name = "%";
					trade_id="";
					trade_desc="%";
				}
				else if (search_by.equals("T")){
					drug_id="";
					drug_desc="%";
					generic_id="";
					generic_name = "%";
					trade_id=code;
					//trade_desc="%"+name+"%";
					if(drug_search_by.equals("S"))
						trade_desc = name+"%";  
					else if(drug_search_by.equals("C"))
						trade_desc = "%"+name+"%";
					else                    
						trade_desc = "%"+name;
				}
				else if (search_by.equals("A")){
					drug_id		="";
					generic_id	="";
					trade_id	="";
					if(drug_search_by.equals("S")){
						drug_desc = name+"%";  
						trade_desc = name+"%"; 
						generic_name = name+"%";  
					}
					else if(drug_search_by.equals("C")){
						drug_desc = "%"+name+"%";
						trade_desc = "%"+name+"%";
						generic_name = "%"+name+"%";
					}
					else{                      
						drug_desc = "%"+name;
						trade_desc = "%"+name;
						generic_name = "%"+name;
					}
				}
				if (generic_id.equals(""))
					generic_id = "%";
				if (drug_id.equals(""))
					drug_id = "%";
				if (trade_id.equals(""))
					trade_id = "%";
				if (form_code.equals(""))
					form_code	=	"%";
				if (route_code.equals(""))
					route_code	=	"%";
				if (strength_value.equals(""))
					strength_value = "%";
				if (strength_uom.equals(""))
					strength_uom = "%";
				if (drug_class.equals(""))
					drug_class = "%";
				if (schedule_id.equals(""))
					schedule_id = "%";
				if (manufacturer_code.equals(""))
					manufacturer_code = "%";
				if (manufacturer_short_name.equals(""))
					temp_manufacturer_short_name = "%";
				else
					temp_manufacturer_short_name = manufacturer_short_name;

				if (search_by.equals("A")){
					pstmt.setString(1,generic_id.trim());
					pstmt.setString(2,generic_name.trim());
					pstmt.setString(3,drug_desc.trim());
					pstmt.setString(4,trade_desc.trim());
					pstmt.setString(5,drug_id.trim());
					pstmt.setString(6,form_code.trim());
					pstmt.setString(7,route_code.trim());
					pstmt.setString(8,strength_uom.trim());
					pstmt.setString(9,drug_class.trim());
					pstmt.setString(10,schedule_id.trim());
					pstmt.setString(11,non_essential_restricted.trim());
					pstmt.setString(12,non_essential_restricted.trim());
					pstmt.setString(13,drug_type);
					pstmt.setString(14,drug_type);
					pstmt.setString(15,ingredient.trim());
					pstmt.setString(16,ingredient.trim());
					pstmt.setString(17,fluid.trim());
					pstmt.setString(18,fluid.trim());
					pstmt.setString(19,compound.trim());
					pstmt.setString(20,compound.trim());
					pstmt.setString(21,formulary.trim());
					pstmt.setString(22,formulary.trim());
					pstmt.setString(23,affects_pregnancy.trim());
					pstmt.setString(24,affects_pregnancy.trim());
					pstmt.setString(25,affects_lab_results.trim());
					pstmt.setString(26,affects_lab_results.trim());
					pstmt.setString(27,affects_breast_feed.trim());
					pstmt.setString(28,affects_breast_feed.trim());
					pstmt.setString(29,manufacturer_code.trim());
					pstmt.setString(30,temp_manufacturer_short_name.trim());
					pstmt.setString(31,trade_id.trim());
					pstmt.setString(32,getLanguageId());
					pstmt.setString(33,getLanguageId());
					pstmt.setString(34,getLanguageId());
					pstmt.setString(35,getLanguageId());
					pstmt.setString(36,getLanguageId());
				}
				else{
					pstmt.setString(1,generic_id.trim());
					pstmt.setString(2,generic_name.trim());
					pstmt.setString(3,drug_id.trim());
					pstmt.setString(4,drug_desc.trim());
					pstmt.setString(5,form_code.trim());
					pstmt.setString(6,route_code.trim());
					//pstmt.setString(7,strength_value.trim());
					pstmt.setString(7,strength_uom.trim());
					pstmt.setString(8,drug_class.trim());
					pstmt.setString(9,schedule_id.trim());
					pstmt.setString(10,non_essential_restricted.trim());
					pstmt.setString(11,non_essential_restricted.trim());
					pstmt.setString(12,drug_type);
					pstmt.setString(13,drug_type);
					pstmt.setString(14,ingredient.trim());
					pstmt.setString(15,ingredient.trim());
					pstmt.setString(16,fluid.trim());
					pstmt.setString(17,fluid.trim());
					pstmt.setString(18,compound.trim());
					pstmt.setString(19,compound.trim());
					pstmt.setString(20,formulary.trim());
					pstmt.setString(21,formulary.trim());
					pstmt.setString(22,affects_pregnancy.trim());
					pstmt.setString(23,affects_pregnancy.trim());
					pstmt.setString(24,affects_lab_results.trim());
					pstmt.setString(25,affects_lab_results.trim());
					pstmt.setString(26,affects_breast_feed.trim());
					pstmt.setString(27,affects_breast_feed.trim());
					pstmt.setString(28,manufacturer_code.trim());
					pstmt.setString(29,temp_manufacturer_short_name.trim());
					pstmt.setString(30,trade_id.trim());
					pstmt.setString(31,trade_desc.trim());
					pstmt.setString(32,getLanguageId());
					pstmt.setString(33,getLanguageId());
					pstmt.setString(34,getLanguageId());
					pstmt.setString(35,getLanguageId());
					pstmt.setString(36,getLanguageId());
				}
				resultSet = pstmt.executeQuery() ;
			}
			else if (identity.equals("MedicationOrder")){
				String strAppend = "";
				String cmp_fld_codes = "";
				String cmp_fld_flag  = "Y";
			// Executing procedure PH_Get_Fluid_Code for finding the compatible fluid list by passing the drug codes
				if(getDrugOrFluid().equals("F") || getDrugOrFluid().equals("C")){

					if(!sel_drg_codes.equals("")){
						cstmt=connection.prepareCall("{call  PH_Get_Fluid_Code (?,?)}");
						cstmt.setString( 1, sel_drg_codes);
						cstmt.registerOutParameter(2, Types.VARCHAR );
						cstmt.execute() ;
						cmp_fld_codes = cstmt.getString(2);
						if (cmp_fld_codes == null){ 
							cmp_fld_codes = "";cmp_fld_flag  = "N";
						}
						try{
							closeStatement( cstmt ) ;
						}catch(Exception es){
							es.printStackTrace();
						}

					}
					else{
						cmp_fld_flag  = "N";
					}
				}
				else if(getDrugOrFluid().equals("IVF")){
					cmp_fld_flag  = "Y";
				}
			// Procedure ends here

			    pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT22B"));
			    pstmt.setString(1, login_by_id);

			    resultSet	= pstmt.executeQuery();
			    if (resultSet != null && resultSet.next()) {
					pract_type=resultSet.getString("PRACT_TYPE");
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
		
				//FOR FILTRING VALUES BASED APPL_TO_VERBAL_ORDER_YN FLAG IN PH_DRUG----11/25/2004
				if(pract_type.equals("NS")){
					strAppend = " AND B.APPL_TO_VERBAL_ORDER_YN='Y' ";
				}
				if (search_by.equals("G")){
					drug_id		=	"";
					drug_desc	=	"%";
					generic_id	=	code;
					//generic_name = "%"+name+"%";
					if(drug_search_by.equals("S"))
						generic_name = name+"%";  
					else if(drug_search_by.equals("C"))
						generic_name = "%"+name+"%";
					else                     
						generic_name = "%"+name;
					
					trade_id	= "";
					trade_desc	= "%";
				}
				else if (search_by.equals("D")){
					drug_id		=	code;
					//drug_desc	=	 "%"+name+"%";
					if(drug_search_by.equals("S"))
						drug_desc = name+"%";  
					else if(drug_search_by.equals("C"))
                         drug_desc = "%"+name+"%";
					else                       
						drug_desc = "%"+name;

					generic_id	=	"";
					generic_name = "%";
					trade_id	=	"";
					trade_desc	=	"%";
				}
				else if (search_by.equals("T")){
					drug_id		=	"";
					drug_desc	=	"%";
					generic_id	=	"";
					generic_name = "%";
					trade_id	 =	code;
					//trade_desc	 =	 "%"+name+"%";
					if(drug_search_by.equals("S"))
						trade_desc = name+"%";  
					else if(drug_search_by.equals("C"))
						trade_desc = "%"+name+"%";
					else                      
						trade_desc = "%"+name;
				}
				else if (search_by.equals("A")){
					drug_id		=	"";
					generic_id	=	"";
					trade_id	 =	"";
			
					if(drug_search_by.equals("S")){
					   drug_desc = name+"%";
					   trade_desc = name+"%";
   					   generic_name = name+"%";
					}
					else if(drug_search_by.equals("C")){
					    drug_desc = "%"+name+"%";
					    trade_desc = "%"+name+"%";
					    generic_name = "%"+name+"%";
					}
					else {
                        drug_desc = "%"+name;
                        trade_desc = "%"+name;
                        generic_name = "%"+name;
					}
				}
				if(getIVMedicationType().equals("IVA") || getIVMedicationType().equals("") ){
					if(getDrugOrFluid().equals("D")){		//Drug
					//strAppend = " AND J.DFLT_IV_ROUTE_CODE = B.ROUTE_CODE  AND ( (B.IV_FLUID_YN='N' AND B.IV_INGREDIENT_YN='Y') OR (B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='Y') ) ";
						strAppend = " AND DECODE(J.DFLT_IV_ROUTE_CODE,NULL,'X',J.DFLT_IV_ROUTE_CODE) IN (SELECT PRFF.ROUTE_CODE FROM PH_ROUTE_FOR_FORM PRFF WHERE PRFF.FORM_CODE = B.FORM_CODE)  AND ( (B.IV_FLUID_YN='N' AND B.IV_INGREDIENT_YN='Y') OR (B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='Y') ) ";
						
					}
					else if(getDrugOrFluid().equals("F") || getDrugOrFluid().equals("IVF")){	//F - Fluid,  IVF -  IVFluids(without additivs)
						strAppend = " AND DECODE(J.DFLT_IV_ROUTE_CODE,NULL,'X',J.DFLT_IV_ROUTE_CODE) IN (SELECT PRFF.ROUTE_CODE FROM PH_ROUTE_FOR_FORM PRFF WHERE PRFF.FORM_CODE = B.FORM_CODE)  AND B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='N'  ";
					}
					else if(getDrugOrFluid().equals("C")){  // Cyto
						strAppend = " AND DECODE(J.DFLT_IV_ROUTE_CODE,NULL,'X',J.DFLT_IV_ROUTE_CODE) IN (SELECT PRFF.ROUTE_CODE FROM PH_ROUTE_FOR_FORM PRFF WHERE PRFF.FORM_CODE = B.FORM_CODE) AND B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='N'  AND B.IV_FLUID_FOR_ONCO_YN='Y'";
					}
					else if(getDrugOrFluid().equals("CO")){  // Compounding
						strAppend = " AND B.APPL_FOR_COMPOUNDING_RX_YN = 'Y'";
					} else {

                         if(getcalledfrom().equals("DIRECT")){
							strAppend = strAppend +"  and DISP_VIA_PRES_ONLY_YN ='N' ";
						 }

						//strAppend = " AND B.ROUTE_CODE = K.ROUTE_CODE(+) ";
						//Normal Rx lookup.
					}
				}
				else if(getIVMedicationType().equals("IVD")){
					if(getDrugOrFluid().equals("D")){		//Drug
						strAppend = " AND DECODE(J.DFLT_IV_ROUTE_CODE,NULL,'X',J.DFLT_IV_ROUTE_CODE) IN (SELECT PRFF.ROUTE_CODE FROM PH_ROUTE_FOR_FORM PRFF WHERE PRFF.FORM_CODE = B.FORM_CODE) AND ((B.IV_FLUID_YN='N' AND B.IV_INGREDIENT_YN='Y') OR (B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='Y'))";
					}
					else if(getDrugOrFluid().equals("F")){	//Fluid
						strAppend = " AND DECODE(J.DFLT_IV_ROUTE_CODE,NULL,'X',J.DFLT_IV_ROUTE_CODE) IN (SELECT PRFF.ROUTE_CODE FROM PH_ROUTE_FOR_FORM PRFF WHERE PRFF.FORM_CODE = B.FORM_CODE) AND B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='N' ";
					}
				}

				if(res_by_service==null){
					res_by_service="";
				}
				if(res_by_service.equals("Y")){
					strAppend =strAppend+ " AND B.GENERIC_ID IN (SELECT DISTINCT GENERIC_ID FROM PH_GENERIC_NAME_FOR_SERVICE WHERE SERVICE_CODE LIKE DECODE(?,NULL,'%',SERVICE_CODE))";
				}

				if(in_formulary_yn==null){
					in_formulary_yn="";
				}
				else if(in_formulary_yn.equals("Y")){
					strAppend =strAppend+ " AND B.IN_FORMULARY_YN='Y' ";
				}
				else if (in_formulary_yn.equals("N")){
					strAppend =strAppend+ " AND B.IN_FORMULARY_YN='N' ";
				}
				
				/*if(!order_type_code.trim().equals("")) {
					strAppend =strAppend+ " AND A.ORDER_TYPE_CODE= ? ";
				} */

				if(!cmp_fld_codes.equals("")){
					strAppend =strAppend+ " AND NVL(B.DRUG_CODE,F.DRUG_CODE) in (";
					//strAppend =strAppend+ " AND B.DRUG_CODE in (";
					strAppend =strAppend+ cmp_fld_codes;
					strAppend =strAppend+ " )";
				}

			if(getCalled_from_verbal_order().equals("Y"))
				{
					strAppend = " AND B.APPL_TO_VERBAL_ORDER_YN='Y' ";
				}

				if(!cmp_fld_flag.equals("N")){
					//pstmt = connection.prepareStatement( //PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_ORDER_TYPE_SELECT")+strAppend +" ORDER BY B.DRUG_DESC,C.FORM_DESC");
					if (billingSpecificIndex.equals("S")){
						pstmt = connection.prepareStatement( "SELECT /*+ ORDERED */ B.DRUG_CODE,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,B.STRENGTH_UOM,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM, D.SHORT_DESC STRENGTH_UOM_DESC, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,(select short_desc from am_uom where uom_code=b.pres_base_uom) pres_base_uom_desc, B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN, or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') DRUG_PRIV_GRP_YN,B.NPB_DRUG_YN   FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,AM_UOM_LANG_VW D,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_CATALOG_BY_PTCL_LANG_VW I,PH_PARAM_LANG_VW J WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' 	AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND D.UOM_CODE(+) = B.STRENGTH_UOM AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  	AND UPPER(B.DRUG_CODE) =UPPER(NVL(?,B.DRUG_CODE))   AND   I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE and blcommon.bl_mm_pref_loc_item_exist(?,?,?,?,?,?,B.DRUG_CODE,trunc(SYSDATE),?) = 'I' AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ?"+strAppend +" ORDER BY B.DRUG_DESC,C.FORM_DESC"); //PRES_BASE_UOM_DESC added for IN7565 
					}
					else if (billingSpecificIndex.equals("G")){
						//pstmt = connection.prepareStatement( "SELECT /*+ ORDERED */ B.DRUG_CODE,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,B.STRENGTH_UOM,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM, D.SHORT_DESC STRENGTH_UOM_DESC, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN, or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') DRUG_PRIV_GRP_YN  FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,AM_UOM_LANG_VW D,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_CATALOG_BY_PTCL_LANG_VW I,PH_PARAM_LANG_VW J, MM_ITEM K WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N'  and k.item_code = b.item_code  AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' 	AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND D.UOM_CODE(+) = B.STRENGTH_UOM AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID  	AND B.ITEM_CODE <> ?   AND   I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND K.IMPORTED_ITEM_YN = ?  AND B.GENERIC_ID = NVL (?, B.GENERIC_ID) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE and blcommon.bl_mm_pref_loc_item_exist(?,?,?,?,?,?,B.DRUG_CODE,trunc(SYSDATE),?) = 'I' AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ?"+strAppend +" ORDER BY B.DRUG_DESC,C.FORM_DESC"); 
                        sql="SELECT /*+ ORDERED */ B.DRUG_CODE,B.DRUG_DESC,B.FORM_CODE,C.FORM_DESC,B.STRENGTH_VALUE,B.STRENGTH_UOM,B.STRENGTH_PER_PRES_UOM, B.STRENGTH_PER_VALUE_PRES_UOM,B.PRES_BASE_UOM, D.SHORT_DESC STRENGTH_UOM_DESC, B.ROUTE_CODE,E.ROUTE_DESC,F.TRADE_CODE,G.SHORT_NAME  TRADE_NAME, B.GENERIC_ID,H.GENERIC_NAME,B.PRES_BASE_UOM,(select short_desc from am_uom where uom_code=b.pres_base_uom) pres_base_uom_desc,B.IN_FORMULARY_YN,TRADE_CODE,B.ITEM_CODE,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN, B.DRUG_CLASS, (select Ph_Drug_Appl_For_Pat_age_grp(B.DRUG_CODE,?,?) from dual) appl_for_age_grp_yn, B.DISP_MULTI_STRENGTH_YN, B.DISP_ALT_FORM_YN, or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') DRUG_PRIV_GRP_YN,B.NPB_DRUG_YN  FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,AM_UOM_LANG_VW D,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, PH_GENERIC_NAME_LANG_VW H,  OR_CATALOG_BY_PTCL_LANG_VW I,PH_PARAM_LANG_VW J WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N'  AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND D.UOM_CODE(+) = B.STRENGTH_UOM AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND H.GENERIC_ID = B.GENERIC_ID AND B.ITEM_CODE <> ?  AND I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND B.GENERIC_ID = NVL (?, B.GENERIC_ID) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE and blcommon.bl_mm_pref_loc_item_exist(?,?,?,?,?,?,B.DRUG_CODE,trunc(SYSDATE),?) = 'I' AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ?"+strAppend +" ORDER BY B.DRUG_DESC,C.FORM_DESC"; //PRES_BASE_UOM_DESC added for IN7565
						
						pstmt = connection.prepareStatement(sql);
					}
					//}
                    // System.err.println("sql----->"+sql);
                    // System.err.println("strAppend----->"+strAppend);
                    
					strength_uom =strength_uom+ "%";
					trade_id =trade_id+"%";

					int cnt	=	1;
					pstmt.setString(cnt,getPatientId());
					pstmt.setString(++cnt,getDOB());
					pstmt.setString(++cnt,getGender());
					pstmt.setString(++cnt,getPractitionerId()); //for or_get_priv_appl_yn
					pstmt.setString(++cnt,getRespId());//for or_get_priv_appl_yn
					pstmt.setString(++cnt,drug_priv_ssn_yn);//for or_get_priv_appl_yn
					pstmt.setString(++cnt,drugCode.trim());
					pstmt.setString(++cnt,getPatientClass().trim());
					if (billingSpecificIndex.equals("G"))
						pstmt.setString(++cnt,genericId);
	
					pstmt.setString(++cnt,login_facility_id);//1
					pstmt.setString(++cnt,getPatientId());//2
					pstmt.setString(++cnt,episode_type);//3
					pstmt.setString(++cnt,episode_id);//4
					pstmt.setString(++cnt,visit_id);//5
					pstmt.setString(++cnt,encounter_id);//6
					//pstmt.setString(++cnt,drugCode.trim());//7				
					pstmt.setString(++cnt,billingPriority);//8
					pstmt.setString(++cnt,getLanguageId());
					pstmt.setString(++cnt,getLanguageId());
					pstmt.setString(++cnt,getLanguageId());

//					if(!order_type_code.trim().equals("")) {
//					pstmt.setString(++cnt,order_type_code.trim());
//
//					}
					if(res_by_service.equals("Y")){
					    if(service_code!=null){
							service_code = service_code.trim();
						}
						pstmt.setString(++cnt,service_code);
					}
                    
				//	System.err.println("@@3959 getPatientId()--->"+getPatientId()+"-->getDOB()--->"+getDOB()+"-->getGender()--->"+getGender()+"-->practitioner id -->"+getPractitionerId()+"-->resp id -->"+getRespId()+"-->drug_priv_ssn_yn -->"+drug_priv_ssn_yn+"-->drugCode--->"+drugCode.trim()+"-->getPatientClass--->"+getPatientClass().trim()+"-->billingSpecificIndex--->"+billingSpecificIndex+"-->genericId--->"+genericId+"-->login_facility_id--->"+login_facility_id+"-->getPatientId()--->"+getPatientId()+"-->episode_type--->"+episode_type+"-->episode_id--->"+episode_id+"-->billingPriority--->"+billingPriority+"-->getLanguageId()--->"+getLanguageId()+"-->getLanguageId()--->"+getLanguageId()+"-->getLanguageId()--->"+getLanguageId());
					
					resultSet = pstmt.executeQuery() ;
         		}
				else{
					records.add("link");
					return records;
				}
			}

			while ( resultSet.next() ){
					//String[] strArray=new String[26];
					String[] strArray=new String[27];
					item_code = resultSet.getString("ITEM_CODE")==null?"":resultSet.getString("ITEM_CODE");
					itemCode = item_code;
					setItemCode(itemCode);
					strArray[0]	= resultSet.getString("DRUG_CODE")==null?"":resultSet.getString("DRUG_CODE");
					strArray[1]	= resultSet.getString("DRUG_DESC")==null?"":resultSet.getString("DRUG_DESC");
					if (resultSet.getString("STRENGTH_PER_PRES_UOM")!=null && !(resultSet.getString("STRENGTH_PER_PRES_UOM")).equals("0") ){
						strength2=resultSet.getString("STRENGTH_PER_PRES_UOM");
						strArray[2]	= strength2+" "+resultSet.getString("STRENGTH_UOM_DESC")+" / "+resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")+" "+resultSet.getString("PRES_BASE_UOM_DESC"); /*Modified for IN7565 STRENGTH_UOM changed to STRENGTH_UOM_DESC and PRES_BASE_UOM changed to PRES_BASE_UOM_DESC*/
						//System.err.println("strength2======bean=====4097====>" +strength2);
					}
					else{
						strArray[2]	= "";
					}

					strArray[3]	= resultSet.getString("STRENGTH_UOM_DESC")==null?"":resultSet.getString("STRENGTH_UOM_DESC");
					strArray[4]	= resultSet.getString("FORM_CODE")==null?"":resultSet.getString("FORM_CODE");
					strArray[5]	= resultSet.getString("FORM_DESC")==null?"":resultSet.getString("FORM_DESC");
					strArray[6]	= resultSet.getString("ROUTE_CODE")==null?"":resultSet.getString("ROUTE_CODE");

					strArray[7]	= resultSet.getString("ROUTE_DESC")==null?"":resultSet.getString("ROUTE_DESC");
					strArray[8]	= resultSet.getString("GENERIC_NAME")==null?"":resultSet.getString("GENERIC_NAME");

					strArray[9]	= checkForNull(resultSet.getString("GENERIC_ID"));
					strArray[10]= checkForNull(resultSet.getString("TRADE_CODE"));
					strArray[11]= checkForNull(resultSet.getString("TRADE_NAME"));
					strArray[12]= checkForNull(resultSet.getString("PRES_BASE_UOM"));
					strArray[13]= checkForNull(resultSet.getString("IN_FORMULARY_YN"));
					String in_formulary_yn = strArray[13];
					String reimburse_yn="";
					String imported_yn = "";
					String unit_price = "";
					String sys_message_id = "";
					String error_code="";
					String error_text="";
                  //System.err.println("===identity=="+identity+"==bl_install_yn=="+bl_install_yn+"==disp_charge_dtl_in_drug_lkp_yn=="+disp_charge_dtl_in_drug_lkp_yn+"==in_formulary_yn=="+in_formulary_yn);

					if(identity.equals("MedicationOrder")&& bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){
						if(getDischargeYN().equals("Y") || getDischargeYN().equals("D")) //Added for [IN:045637] //Added for [IN:045637]
							episode_type = "I";
						try{
							encounter_id= getEncounterId();// Added for JD-CRF-0191
							episode_id = encounter_id.substring(0,(encounter_id.length()-4));  // Added for  JD-CRF-0191
							visit_id = encounter_id.substring(encounter_id.length()-4);        // Added for  JD-CRF-0191
							cstmt=connection.prepareCall("{call  BL_PROC_ITEM_VALIDATIONS_MP.BL_GET_ITEM_DETAILS_MM (?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); // three more '?' added for JD-CRF-191
							cstmt.setString( 1, login_facility_id);
							cstmt.setString( 2, episode_type); //'O'-Outpatient,'E'-Emergency ,'D'-Daycare,'I'-Inpatient,'R'-External
							cstmt.setString( 3, item_code);
							cstmt.setString( 4, ""); // p_trade_id	--If Batch level price is required (null as of now)
							cstmt.setString( 5, ""); // p_batch_id  --If Batch level price is required (null as of now
							cstmt.setString( 6, getSysdatetimesec()); // p_date
							cstmt.registerOutParameter(7, Types.VARCHAR );	//ESSENTIAL_YN 
							cstmt.registerOutParameter(8, Types.VARCHAR );	//P_REIMBURSABLE_YN Y --Reimbursible
							cstmt.registerOutParameter(9, Types.VARCHAR );	//P_REIMBURSABLE  P --> partially   F --> Fully
							cstmt.registerOutParameter(10, Types.VARCHAR ); //P_IMPORTED_YN	Y  --> Imported
							cstmt.registerOutParameter(11, Types.NUMERIC ); //PUBLIC_PRICE
							cstmt.registerOutParameter(12, Types.NUMERIC ); //P_BASE_PRICE	--Sale price as defined in billing by item/batch for respective passed Episode Type
							cstmt.registerOutParameter(13, Types.NUMERIC ); //P_REIMBURSABLE_AMT
							cstmt.registerOutParameter(14, Types.VARCHAR ); //P_REIM_OVERRIDE
							cstmt.registerOutParameter(15, Types.VARCHAR ); //P_ERROR_CODE
							cstmt.registerOutParameter(16, Types.VARCHAR ); //P_SYS_MESSAGE_ID
							cstmt.registerOutParameter(17, Types.VARCHAR ); //P_ERROR_TEXT
							cstmt.setString( 18, getPatientId()); //Added for JD-CRF-0191 - Start
							cstmt.setString( 19, episode_id);  
							cstmt.setString( 20, visit_id);  //Added for JD-CRF-0191 - End 
							cstmt.execute() ;

							reimburse_yn	= cstmt.getString(8);
							imported_yn		= cstmt.getString(10);
							unit_price		= cstmt.getString(12);
							error_code		= cstmt.getString(15);
							sys_message_id	= cstmt.getString(16);
							error_text		= cstmt.getString(17);
                            //System.err.println("=11====login_facility_id===="+login_facility_id+"==episode_type===="+episode_type+"==item_code===="+item_code+"===getSysdatetimesec===="+getSysdatetimesec()+"==reimburse_yn===="+reimburse_yn+"==imported_yn===="+imported_yn+"==unit_price===="+unit_price+"==error_code==="+error_code+"==sys_message_id===="+sys_message_id+"==error_text===="+error_text);
							closeStatement( cstmt );
							if(disp_price_type_in_drug_lkp.equals("P") && (error_code ==null && sys_message_id==null && error_text==null)){
								 encounter_id = getEncounterId();
								//String episode_id = "";
								//String visit_id = "";
								if(encounter_id!= null && !encounter_id.equals("")){
									episode_id = encounter_id;
									if(episode_type.equals("O")||episode_type.equals("E")){
										episode_id = encounter_id.substring(0,(encounter_id.length()-4));
										visit_id = encounter_id.substring(encounter_id.length()-4);
									}
								}
								cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
								cstmt.setString( 1, login_facility_id);
								cstmt.setString( 2, "PH");	//module id
								cstmt.setString( 3, "");	//
								cstmt.setString( 4, "");	//
								cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
								cstmt.setString( 6, getPatientId()); //patient_id
								cstmt.setString( 7, episode_id);  //episode_id
								cstmt.setString( 8, visit_id);  //p_visit_id  
								cstmt.setString( 9, ""); //p_dummy1 - null
								cstmt.setString( 10, ""); //p_dummy12 - null
								cstmt.setString( 11, "SAL"); //p_transaction_type
								cstmt.setString( 12, getSysdatetimesec()); //p_charge_date_time	--Service Data and time

								cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
								cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
								cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
								cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null
								cstmt.setString( 17, item_code);  //p_item_code
								cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
								cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 
								cstmt.setString( 20, "S");  //p_serv_panel_ind
								cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 
								cstmt.setString( 22,"1" );  //qty served
								cstmt.setString( 23, "");  //p_charge_amt  
								cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost
								cstmt.setString( 25,"" );  //p_store_code -- Store Code from where issued
								cstmt.setString( 26, "");  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
								cstmt.setString( 27,"" );  //p_oth_disc_perc if any other manual discount is given from transaction
								cstmt.setString( 28, "");  //p_source_doc_ref		null for Sale
								cstmt.setString( 29,"" );  //p_source_doc_ref_line	null for Sale
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

								cstmt.setString( 48,"" );  //p_dummy4 (IN OUT )
								cstmt.setString( 49, "");  //p_batch_prices  (IN OUT )
								cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
								cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind	--- Excluded(E)/Null or included(I)
								cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn	--- approval is required or not?
								cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?
								cstmt.setString( 54,"" );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
								cstmt.setString( 55, "");  //p_overridden_action_reason		 --- Pass null or any value entered 
								cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
								cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
								cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text

								cstmt.execute() ;
								unit_price		= cstmt.getString(40);
								error_code		= cstmt.getString(56);
								sys_message_id	= cstmt.getString(57);
								error_text		= cstmt.getString(58);
                            //System.err.println("=22===unit_price===="+unit_price+"==error_code===="+error_code+"==sys_message_id===="+sys_message_id+"==error_text===="+error_text);
							}
						}
						catch(Exception e){
							error_text = "Error in Proc";
							unit_price = "";
							e.printStackTrace();
						}
						finally{
							closeStatement( cstmt ) ;
						}
						if(unit_price!=null && !unit_price.equals("")){
							String decimalFormatString = getDecimalFormatString();
							DecimalFormat df = new DecimalFormat(decimalFormatString);
							unit_price = df.format(Double.parseDouble(unit_price));
						}
					}
					strArray[14] = reimburse_yn;
					strArray[15] = imported_yn;
					strArray[16]= unit_price;
					strArray[17]= error_code;
					strArray[18]= sys_message_id;
					strArray[19]= error_text;
					if(identity.equals("MedicationOrder")){
						strArray[20]= checkForNull(resultSet.getString("DIAGNOSIS_FOUND_YN"));
						strArray[22]= checkForNull(resultSet.getString("APPL_FOR_AGE_GRP_YN"));
						strArray[23]= checkForNull(resultSet.getString("DISP_MULTI_STRENGTH_YN"));
						strArray[24]= checkForNull(resultSet.getString("DISP_ALT_FORM_YN"));
						strArray[25]= checkForNull(resultSet.getString("DRUG_PRIV_GRP_YN"));
						strArray[26]= checkForNull(resultSet.getString("NPB_DRUG_YN"),"N");
					}
					else{
						strArray[20]= "";
						strArray[22]= "";
						strArray[23]= "";
						strArray[24]= "";
						strArray[25]= "";
						strArray[26]= "";
					}

					strArray[21]= checkForNull(resultSet.getString("DRUG_CLASS"));
					records.add( strArray );
				//}
			}

			//if( start != 1 )
				//prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLinkForDrug('"+(start-query_result_size)+"','"+(end-query_result_size)+"');\">Previous&nbsp;&nbsp;</a>" ;
			//int intCount=0;
			//if(identity.equals("MedicationOrder")){
				//intCount = 5;
			//}
			//else{
				//intCount = 10;
			//}
			//if( count > intCount )
					//prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLinkForDrug('"+(start+query_result_size)+"','"+(end+query_result_size)+"');\">Next</a>" ;
			//records.set(0,prevnextlink);
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}

		return records;
	}

	public String getDefaultPriviligeDrugSelection(String facility_id){
	
		String defaultPriviligeDrugSelection ="";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		String qryString =	"SELECT DEFAULT_PREV_DRUG_SEL FROM PH_FACILITY_PARAM WHERE FACILITY_ID =?";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(qryString);
			pstmt.setString(1,facility_id);
			resultSet=pstmt.executeQuery();
			if(resultSet != null && resultSet.next()){
			defaultPriviligeDrugSelection=resultSet.getString("DEFAULT_PREV_DRUG_SEL");				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}

	return defaultPriviligeDrugSelection;
	}

	public String getOrderTypeCode(String drug_code){
	
		String orderTypeCode ="";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		String qryString =	"SELECT ORDER_TYPE_CODE FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE  = ?";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(qryString);
			pstmt.setString(1,drug_code);
			resultSet=pstmt.executeQuery();
			if(resultSet != null && resultSet.next()){
			orderTypeCode=resultSet.getString("ORDER_TYPE_CODE");				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}

		return orderTypeCode;
	}

	public String getpreviligeGroupDrug_ordering_YN(String practitioner_id, String login_id,String itemCode,String order_type,String priv_appl_yn){
		Connection connection	= null ;
		CallableStatement cstmt = null ;
		String drugPreviligecheckVlaue_ordering_YN = "";	

		try {
				connection			= getConnection();

				cstmt=connection.prepareCall("{call  OR_GET_PRIV_APPL_YN(?,?,?,?,?,?,?)}");
				//cstmt=connection.prepareCall("{call  OR_GET_PRIV_APPL_YN(?,?,?,?,?,?,?)}");
				cstmt.setString( 1, practitioner_id);
				cstmt.setString( 2, login_id); 
				cstmt.setString( 3, "OR");
				cstmt.setString( 4, itemCode);
				cstmt.setString( 5, priv_appl_yn);
				cstmt.setString( 6, order_type); 
				cstmt.setString( 7, "PH");
				//cstmt.registerOutParameter(8, Types.VARCHAR );	
				cstmt.execute();
				drugPreviligecheckVlaue_ordering_YN	= cstmt.getString(8);
				
						
				
			} catch(Exception e) {
				System.err.println("Exception raised in the procedure OR_GET_PRIV_APPL_YN-->"+e);
				e.printStackTrace();
				drugPreviligecheckVlaue_ordering_YN = "";
				return drugPreviligecheckVlaue_ordering_YN;
			}
			finally {
				try {
					closeStatement(cstmt);
					closeConnection(connection);
				}
				catch(Exception es){
					es.printStackTrace();
				}
			}
			return drugPreviligecheckVlaue_ordering_YN;
	 }

	public String getDrugPrivilegeYN(){
	
		String drugPrivilegeYN ="";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		String qryString =	"SELECT ALLOW_PRIV_TO_ORDER_YN FROM OR_PARAM";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(qryString);
			//pstmt.setString(1,drug_code);
			resultSet=pstmt.executeQuery();
			if(resultSet != null && resultSet.next()){
			drugPrivilegeYN=resultSet.getString("ALLOW_PRIV_TO_ORDER_YN");				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}

	return drugPrivilegeYN;
	}

	public void setNoOfDecimals() 
	{
		Connection oConnection		    = null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		
		try 
		{
			oConnection	= getConnection() ;
			oStatement	= oConnection.createStatement();

			oResultSet	= oStatement.executeQuery(" select NO_OF_DECIMALS from st_acc_entity_param");

			if(oResultSet!=null && oResultSet.next())
			{
				iNoOfDecimals = oResultSet.getString("NO_OF_DECIMALS")==null?0:Integer.parseInt(oResultSet.getString("NO_OF_DECIMALS"));
			}
		}catch ( Exception e ) 
		{
			e.printStackTrace() ;
		}
		finally 
		{
			try
			{
				closeResultSet( oResultSet ) ;
				closeStatement( oStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ) 
			{
				e.printStackTrace() ;
			}
		}
	}
	public String getStockUOM1(String drug_code)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String stock_uom		= "";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement("select gen_uom_code from mm_item where item_code =?");
			pstmt.setString(1, drug_code);
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				stock_uom	=	resultSet.getString("gen_uom_code");
			}
		} catch(Exception e) {
			stock_uom=e.toString();
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
		return stock_uom;
	}
	
	public String getNPBReqForPatient(String patient_id){
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String NPBReqExist		= "N";
		int NPBCount = 0;

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement("select count(*) NPBCount from ph_npb_drug_request where patient_id=? and REQUEST_STATUS='P' and trunc(DRUG_VALIDITY_DATE) >= trunc(sysdate)");
			pstmt.setString(1, patient_id);
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				NPBCount	=	resultSet.getInt("NPBCount");
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
		if(NPBCount>0)
			NPBReqExist="Y";
		return NPBReqExist;	
	}
//added for GHL-CRF-0548 START
	public String displayByMultiStrength(String drugCode){
		Connection connection = null ;
		PreparedStatement pstmt_drug = null ;
		ResultSet resultSet_drug = null ;
		String disp_multi_strength_yn="",disp_alt_form_yn		= "";
		String result="";
		try {
			connection = getConnection() ;
			pstmt_drug = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_DISP_MULTI_STRENGTH") );
			pstmt_drug.setString(1,drugCode );
			resultSet_drug = pstmt_drug.executeQuery() ;
			while (resultSet_drug != null && resultSet_drug.next()){
				disp_alt_form_yn	= checkForNull(resultSet_drug.getString("DISP_ALT_FORM_YN"));
				disp_multi_strength_yn	= checkForNull(resultSet_drug.getString("DISP_MULTI_STRENGTH_YN"));
			}
			if(disp_alt_form_yn.equals("Y")){
				
				if(disp_multi_strength_yn.equals("S") ){
					result="S";
				}
				else{
					result="M";	
				}
			}
			else{
				result="M";
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet_drug ) ;
				closeStatement( pstmt_drug ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return result;
	}
	//added for GHL-CRF-0548 END
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

	public String getItemTypeApp(){
	
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		PreparedStatement pstmt1 = null;
		ResultSet resultSet1		= null;

		String blg_grp_id		= "";
		String encounter_id = "";
		String episode_id  ="";
		String visit_id	   ="";
		String item_type_app="";
		try {
			connection			= getConnection();
			if(patient_class.equals("IP"))
				episode_type="I";				
			else if(patient_class.equals("OP"))
				episode_type="O";
			else if(patient_class.equals("EM"))
				episode_type="E";
			else if(patient_class.equals("DC")) //GHL-549
				episode_type="D";
						
			if(getDischargeYN().equals("Y") || getDischargeYN().equals("D")) 
				episode_type = "I"; //modified 
				
				encounter_id= getEncounterId();
				if(encounter_id.length()<=0) 
				{
					episode_id =""; 
					visit_id ="";
				}
				else{
					episode_id =encounter_id.substring(0,(encounter_id.length()-4));  
					visit_id =encounter_id.substring(encounter_id.length()-4);        
				}
	
				if(episode_type.equals("I") || episode_type.equals("D")) //modified for GHL-CRF-0549
					episode_id =encounter_id;

			if(episode_type.equals("I") || episode_type.equals("D")){
				pstmt				= connection.prepareStatement("SELECT BLNG_GRP_ID FROM BL_EPISODE_FIN_DTLS WHERE OPERATING_FACILITY_ID = ? AND EPISODE_TYPE=? AND EPISODE_ID = ? ");
			}else{
				pstmt				= connection.prepareStatement("SELECT BLNG_GRP_ID FROM BL_VISIT_FIN_DTLS WHERE OPERATING_FACILITY_ID = ? AND EPISODE_TYPE=? AND EPISODE_ID =? ");
			}

			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, episode_type);
			pstmt.setString(3, episode_id);

			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
			 blg_grp_id = resultSet.getString("BLNG_GRP_ID")==null?"":resultSet.getString("BLNG_GRP_ID");
			 
			 setBillingGrpId(blg_grp_id);	//GHL-CRF-0618 
			}
			if(!blg_grp_id.equals("")){
				pstmt1 = connection.prepareStatement("select ITEM_TYPE_APPLICABLE  from BL_BLNG_GRP where BLNG_GRP_ID=?");
			pstmt1.setString(1,blg_grp_id);
			resultSet1	= pstmt1.executeQuery();

			if (resultSet1 != null && resultSet1.next()) {
			 item_type_app = resultSet1.getString("ITEM_TYPE_APPLICABLE")==null?"":resultSet1.getString("ITEM_TYPE_APPLICABLE");
			}
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

	return item_type_app;
	}
//GHL-CRF-0549 - end
	// Added for NMC-JD-CRF-0001 start
	public String getDisplayGenericNameApp(String facility_id){
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String display_generic_name_yn ="";
		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement("select GENERIC_NAME_DISPLY_YN from PH_FACILITY_PARAM where facility_id=?");
			pstmt.setString(1, facility_id);
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				display_generic_name_yn = resultSet.getString("GENERIC_NAME_DISPLY_YN");	
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
		return display_generic_name_yn;
	}
   //Added for NMC-JD-CRF-0001 end
	//Added for IN069511 Start
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
			
			this.external_disp_yn.put(store_code,ext_disp_appl_yn);
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
	//Added for IN069511 end	
   
	//GHL-CRF-0618 - start
	public String getFormularyBillingGrpCode(String blng_grp_id){
	
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String formulary_code="";
		String blng_grp_type = "";
		try {
			connection			= getConnection();
		
		pstmt = connection.prepareStatement("SELECT FORMULARY_CODE,BLNG_GRP_TYPE FROM PH_FORMULARY_BLNG_GRP WHERE  BLNG_GRP_ID=? and facility_id=?");

		pstmt.setString(1,blng_grp_id);
		pstmt.setString(2,login_facility_id);
		resultSet = pstmt.executeQuery() ;
							
		if(resultSet!=null && resultSet.next()){					
			
			formulary_code = resultSet.getString("FORMULARY_CODE");	
			blng_grp_type  = resultSet.getString("BLNG_GRP_TYPE");	
			if(formulary_code==null)
				formulary_code="";
			if(blng_grp_type==null)
				blng_grp_type = "";
	
			setFormularyCode(formulary_code);
			setFormularyBlngGrpType(blng_grp_type);
			formulary_code = formulary_code+"~"+blng_grp_type;
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
		return formulary_code;
	}

		public HashMap getFormularyBillingGrpCodeDtl(String formulary_code,String blng_grp_id,String item_type){ //blng_grp_id,item_type added for GHL-SCF-1527
	
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String item_code="";
		String preference="";
		String item_type_value = "";
		HashMap preferenceItem = new HashMap();

		try {
			connection			= getConnection();
		
		pstmt = connection.prepareStatement("SELECT item_code, preference,ITEM_TYPE FROM ph_formulary_blng_grp a, ph_formulary_blng_grp_dtl b WHERE a.formulary_code = b.formulary_code and a.blng_grp_type = b.blng_grp_type  AND a.formulary_code = ? AND a.facility_id = ? AND BLNG_GRP_ID=? AND ITEM_TYPE=? AND eff_status = 'E'");
		pstmt.setString(1,formulary_code);
		pstmt.setString(2,login_facility_id);
		pstmt.setString(3,blng_grp_id);
		pstmt.setString(4,item_type);
//blng_grp_id,item_type added for GHL-SCF-1527
		resultSet = pstmt.executeQuery() ;
							
			while(resultSet!=null && resultSet.next()){					
				
				item_code = resultSet.getString("ITEM_CODE");	
				preference = resultSet.getString("PREFERENCE");	
				item_type_value  = resultSet.getString("ITEM_TYPE");	
				if(item_code==null)
					item_code="";
				if(preference==null)
					preference = "";
				if(!item_code.equals("")){
					preferenceItem.put(item_code,preference);
					if(getItemGenericType()!=null && getItemGenericType().size()>0){
						if(!getItemGenericType().contains(item_type_value))
							setItemGenericType(item_type_value);
					}else{
							setItemGenericType(item_type_value);
					}
				}
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
		return preferenceItem;
	}
	//GHL-CRF-0618 - end
		//GHL-CRF-0619 START
		public ArrayList getDrugProfileDtls(String patient_id,String generic_id,String encounter_id){ 
			Connection connection = null ;
			PreparedStatement pstmt = null ;
			ResultSet resultSet = null ;
			PreparedStatement pstmt1 = null ;
			ResultSet resultSet1 = null ;
			boolean drug_flag =false;

			ArrayList drugDetailsList = new ArrayList();
			String qryString =	"SELECT   a.start_date, a.drug_code, c.drug_desc,(SELECT reason_desc FROM ph_medn_trn_reason_lang_vw ph_medn_trn_reason WHERE appl_trn_type = 'NP' AND reason_code = o.not_prefered_item_rem_code  AND eff_status = 'E' AND language_id = ?) remarks FROM ph_patient_drug_profile a, or_order b, or_order_line_ph o, ph_drug c  WHERE a.orig_order_id = b.order_id AND a.orig_order_id = o.order_id  AND a.orig_order_line_no = o.ORDER_LINE_NUM AND b.order_id = o.order_id AND a.patient_id = b.patient_id  AND a.encounter_id = b.encounter_id  AND a.drug_code = c.drug_code  AND a.patient_id = ? AND a.generic_id = ? AND a.encounter_id = ? AND b.order_status NOT IN ('CN', 'DC') ORDER BY a.start_date DESC";

			String qryString1 =	"SELECT a.start_date, a.drug_code, d.drug_desc,(SELECT reason_desc FROM ph_medn_trn_reason_lang_vw ph_medn_trn_reason WHERE appl_trn_type = 'NP' AND reason_code = c.NOT_PREFERED_ITEM_REM_CODE  AND eff_status = 'E' AND language_id = ?) remarks FROM ph_patient_drug_profile a, ph_disp_hdr b, ph_disp_dtl c, ph_drug d  WHERE a.orig_order_id = b.order_id AND a.orig_order_id = c.order_id  AND a.orig_order_line_no = c.ORDER_LINE_NO AND b.order_id = c.order_id AND a.patient_id = b.patient_id  AND a.encounter_id = b.encounter_id  AND a.drug_code = d.drug_code  AND a.patient_id = ?  AND a.encounter_id = ?  AND a.generic_id = ? ORDER BY DELIVERED_DATE_TIME DESC,c.SRL_NO DESC";// Desc added for delivered_date_time //modified for GHL-ICN-0086
			 
			try{
				connection = getConnection() ;
				
				pstmt1 = connection.prepareStatement(qryString1);
				pstmt1.setString(1,getLanguageId());
				pstmt1.setString(2,patient_id);
				pstmt1.setString(3,encounter_id); 
				pstmt1.setString(4,generic_id);
			
				resultSet1 = pstmt1.executeQuery() ;
				while (resultSet1 != null && resultSet1.next()){
					HashMap orderDetailsMap=new HashMap();
					orderDetailsMap.put("START_DATE",resultSet1.getString( "START_DATE" ));
					orderDetailsMap.put("DRUG_CODE",resultSet1.getString( "DRUG_CODE" ));
					orderDetailsMap.put("DRUG_DESC",resultSet1.getString( "DRUG_DESC" ));
					orderDetailsMap.put("REMARKS",resultSet1.getString( "REMARKS" ));

					drugDetailsList.add(orderDetailsMap);
					drug_flag = true;
				}
System.err.println("drug_flag===>"+drug_flag);
				if(!drug_flag){

				pstmt = connection.prepareStatement(qryString);
				pstmt.setString(1,getLanguageId());
				pstmt.setString(2,patient_id);
				pstmt.setString(3,generic_id);
				pstmt.setString(4,encounter_id); 
			
				resultSet = pstmt.executeQuery() ;
				while (resultSet != null && resultSet.next()){
					HashMap orderDetailsMap=new HashMap();
					orderDetailsMap.put("START_DATE",resultSet.getString( "START_DATE" ));
					orderDetailsMap.put("DRUG_CODE",resultSet.getString( "DRUG_CODE" ));
					orderDetailsMap.put("DRUG_DESC",resultSet.getString( "DRUG_DESC" ));
					orderDetailsMap.put("REMARKS",resultSet.getString( "REMARKS" ));

					drugDetailsList.add(orderDetailsMap);						
				}
				}
				  
			}catch(Exception e){
				e.printStackTrace() ;
			}
			finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeResultSet( resultSet1 ) ;
					closeStatement( pstmt1 ) ;
					closeConnection( connection );
				}catch(Exception es){
					es.printStackTrace();
				}
			} 
	//		System.out.println("drugDetailsList: "+drugDetailsList);
			return drugDetailsList; 
		}
		
		//added for GHL-CRF-0619 END	
		
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
	
	public String getListValuesNew(String locale){
		ArrayList form_params=new ArrayList();
		
		String form_select="";
		String sql="SELECT form_code code, form_desc description FROM ph_form_lang_vw ph_form WHERE eff_status = 'E' AND language_id = ? ORDER BY 2";
		form_params.add(locale);
		
		return getListValues(sql, form_params, form_select);
	}
	
	public String getPreAllocStatusYN(){
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String pre_alloc="";
		String alw_disp_loc_drug_search_yn = "N"; //for NMC-JD-CRF-0197 and it will split and taken in front end
		try {
			connection			= getConnection();
			pstmt = connection.prepareStatement("SELECT nvl(PRE_ALLOC_APPL,'N') PRE_ALLOC_APPL, nvl(ALW_DISP_LOC_DRUG_SEARCH_YN,'N') ALW_DISP_LOC_DRUG_SEARCH_YN FROM PH_FACILITY_PARAM WHERE facility_id = ? ");  //Appended ALW_DISP_LOC_DRUG_SEARCH_YN for NMC-JD-CRF-0197 and it will split and taken in front end
			pstmt.setString(1,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			
			if(resultSet!=null && resultSet.next()){					
				pre_alloc = resultSet.getString("PRE_ALLOC_APPL");	
				if(pre_alloc==null)
					pre_alloc="N";

				alw_disp_loc_drug_search_yn = resultSet.getString("ALW_DISP_LOC_DRUG_SEARCH_YN");	
				if(alw_disp_loc_drug_search_yn==null)
					alw_disp_loc_drug_search_yn="N";
			}

			// Append and send for front end to split and take NMC-JD-CRF-0197 as both are related.
			pre_alloc = pre_alloc +"$"+alw_disp_loc_drug_search_yn;
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
	return 	pre_alloc;
}
	
//Added for MMS-DM-CRF-0177
//Added for TFS id:7345 start	
	public String[] getPreAllocatedDrug(String key,String order_type,String consider_stock,String allow_pres_without_stock_yn,String patient_id,String encounter_id){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		CallableStatement cstmt = null ;
		ResultSet resultSet		= null ;
		/*PreparedStatement oPreparedStmt = null ;//added for mms-dm-crf-0209.1
		ResultSet oResultSet = null ;//added for mms-dm-crf-0209.1
		
		PreparedStatement oPreparedStmt1 = null ;//added for mms-dm-crf-0209.1
		ResultSet oResultSet1 = null ;//added for mms-dm-crf-0209.1
		
	*/	
		String disp_locn		= "";
		String store_code		= "";
		String store_desc		= "";
		String iv_prep_yn		= getIv_prep_yn();
		//ArrayList result		= new ArrayList(); //Commented for Common-icn-0048

		String priority			= getPriority();
		String source_type		= getsource_type();
		//String p_err_msg        =""; //Commented for Common-icn-0048
		boolean site_verbal_order=false;//added for ghl-crf-0509
		if(priority==null)
			priority	=	"R";
		String item_codes=(String)sameGenericItems.get(key);
		String store_codes="";
		StringTokenizer item_codes_to_process=new StringTokenizer(item_codes,"$");
	//	setP_item_code(item_codes_to_process.nextToken());
		int items_count=item_codes_to_process.countTokens();

		String item_code="";
		
if(items_count>1){
 if(!getDefaultDispLocnSelectAppl()){//Added for TFS id:-16341
	while(item_codes_to_process.hasMoreTokens()){

		 item_code=item_codes_to_process.nextToken();
		String[] strArray=(String[])sameGenericItemsdata.get(item_code);
		String drug_code		= strArray[0];
		//String trade_code= strArray[10]==null?"":strArray[10];  //Commented for Common-icn-0048
		String drug_class=strArray[21];
		if(order_type==null || order_type.equals(""))
			order_type = getOrderTypeCode(drug_code);
		try {
			connection = getConnection() ;
			 site_verbal_order = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","PLACED_VERBAL_ORDER_YN");//added for ghl-crf-0509
			if(!getcalledfrom().equals("DIRECT")) {
					if(iv_prep_yn==null || iv_prep_yn.equals("")){

						pstmt = connection.prepareStatement("SELECT PH_DISP_STOCK_LOCN(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) DISP_LOCN from dual");  //Modified for TFS-7345
						pstmt.setString(1,source_type);
						pstmt.setString(2,getsource_code().trim());
						pstmt.setString(3,login_facility_id);
						pstmt.setString(4,login_facility_id);
						pstmt.setString(5,drug_class);
						pstmt.setString(6,drug_code);
						pstmt.setString(7,order_type);
						pstmt.setString(8,patient_class);
						pstmt.setString(9,discharge_yn);
						pstmt.setString(10,priority);
						pstmt.setString(11,getLanguageId());
						pstmt.setString(12,"D");
						pstmt.setString(13,home_leave_yn);//added home_leave_yn_val for Bru-HIMS-CRF-093[29960]
						pstmt.setString(14,patient_id);//added home_leave_yn_val for Bru-HIMS-CRF-093[29960]
						pstmt.setString(15,encounter_id);//added home_leave_yn_val for Bru-HIMS-CRF-093[29960]
						//added for GHL-CRF-0509 start
						if(site_verbal_order){
							pstmt.setString(16,called_from_verbal_order);	
						}
						else
						{
							pstmt.setString(16,"Y");//added for GHL-CRF-0509
						}
						//added for GHL-CRF-0509 end
						resultSet = pstmt.executeQuery() ;
									
						if(resultSet!=null && resultSet.next()){
							disp_locn =resultSet.getString("DISP_LOCN");
							//System.err.println("==disp_locn=="+disp_locn);
							if(disp_locn!=null && !disp_locn.equals("")){
								store_code = disp_locn.substring(0,disp_locn.indexOf("|"));
								store_desc = disp_locn.substring(disp_locn.indexOf("|")+1);
							}
							//System.err.println("==storecode1=="+store_code);
							//System.err.println("==store_desc1=="+store_desc);
						}
						closeStatement(pstmt);
						closeResultSet(resultSet);
					}
					else{
						cstmt=connection.prepareCall("{call  Ph_Ret_Spl_Ord_Disp_Locn(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						//System.err.println("==Ph_Ret_Spl_Ord_Disp_Locn==login_facility_id="+login_facility_id+",source_type="+source_type+",getsource_code="+getsource_code()+",discharge_yn="+discharge_yn+",drug_code="+drug_code+",patient_id="+patient_id+",encounter_id="+encounter_id);
						cstmt.setString( 1,login_facility_id);
						cstmt.setString( 2,source_type);
						cstmt.setString( 3, getsource_code().trim());
						cstmt.setString( 4, discharge_yn);
						cstmt.setString( 5, priority);
						cstmt.setString( 6, iv_prep_yn);
						cstmt.setString( 7, getLanguageId());
						cstmt.registerOutParameter(8, Types.VARCHAR );
						cstmt.registerOutParameter(9, Types.VARCHAR );
						cstmt.registerOutParameter(10, Types.VARCHAR );
						cstmt.registerOutParameter(11, Types.VARCHAR );
						cstmt.setString(12,drug_code);//added for MMS-QH-CRF-0048 [IN:037704]
						cstmt.setString(13,patient_id);//added for MMS-QH-CRF-0048 [IN:037704]
						cstmt.setString(14,encounter_id);//added for MMS-QH-CRF-0048 [IN:037704]
						cstmt.execute() ;
						store_code = cstmt.getString(8);
						store_desc = cstmt.getString(10);
						//System.err.println("==store_code=="+store_code+" store_desc="+store_desc);
						closeStatement(cstmt) ;
					}
			}
			else{			
                pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT27") );
				pstmt.setString(1,getDispLocnCode());
				pstmt.setString(2,login_facility_id);
				pstmt.setString(3,getLanguageId());
		
				resultSet = pstmt.executeQuery() ;
									
				if(resultSet!=null && resultSet.next()){					
					store_code = getDispLocnCode();
					store_desc = resultSet.getString("SHORT_DESC");				
				}
				closeStatement(pstmt);
				closeResultSet(resultSet);
			}
			setStoreCode(store_code);
			setStoreDesc(store_desc);
		}

		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		if(store_codes.equals("")){
			store_codes=store_code+"";
		}
		else{
		store_codes=store_codes+"$"+store_code;
		}
}
}//Added for TFS id:-16341 start
else{
	store_code=getDispLocnCode();
	for(int i=0;i<items_count;i++){
		if(i==0){
			store_codes=store_code+"";
		}
		else{
		store_codes=store_codes+"$"+store_code;
		}
	}
	
}
//Added for TFS id:-16341 end
	CallableStatement callableStatement = null;
	String pre_aloc_drug="";
	try {
		connection=getConnection();
		/*boolean default_aggred_item_app		=false;
		try {
			
			default_aggred_item_app =eCommon.Common.CommonBean.isSiteSpecific(connection,"PH","AGGRED_ITEM_APP");
		}catch(Exception e){
			e.printStackTrace();
		}*/
		

	/*	String sqlString1="select STRENGTH_VALUE,STRENGTH_UOM, FORM_CODE,GENERIC_ID from ph_drug where drug_code=?";
		oPreparedStmt1	= connection.prepareStatement(sqlString1);
		oPreparedStmt1.setString(1, getP_item_code());					
		
		oResultSet1	= oPreparedStmt1.executeQuery();
		if(oResultSet1 !=null){
			while(oResultSet1.next()){	
				   setP_generic_code(checkForNull(oResultSet1.getString("GENERIC_ID")));//added for mms-dm-crf-0209.1
				  setP_strength_uom(checkForNull(oResultSet1.getString("STRENGTH_UOM")));//added for mms-dm-crf-0209.1
				  setP_strength_value(checkForNull(oResultSet1.getString("STRENGTH_VALUE")));//added for mms-dm-crf-0209.1
				  setP_form_code(checkForNull(oResultSet1.getString("FORM_CODE")));//added for mms-dm-crf-0209.1
				  
				
			}
		}*/
	
	//if(!default_aggred_item_app){
		callableStatement	= connection.prepareCall("{ call PH_PRE_ALLOCATE_DRUG (?,?,?,?,?,?,?,?,?,?) }");//Modified for NMC-JD-CRF-0097.1 ADD 2 OUT PARAM
	callableStatement.registerOutParameter(1, Types.VARCHAR);
	callableStatement.setString(1, store_codes);
	callableStatement.registerOutParameter(2, Types.VARCHAR);
	callableStatement.setString(2, item_codes);
	callableStatement.setString(3, getLoginFacilityId());
	callableStatement.registerOutParameter(4, Types.VARCHAR);//Added for NMC-JD-CRF-0097.1 
	callableStatement.registerOutParameter(5, Types.VARCHAR);//Added for NMC-JD-CRF-0097.1 
	callableStatement.setString(6,getP_episode_type());					
	callableStatement.setString(7,getPatientId());	
	callableStatement.setString(8,  getP_episode_id());					
	callableStatement.setString(9, getP_visit_id());					
	callableStatement.setString(10, getEncounterId());
	callableStatement.execute();
	pre_aloc_drug=checkForNull((String)callableStatement.getString(2));

//	} 
/*	else{
		String sqlString="SELECT PH_PRE_ALLC_LEAST_EXP_ITEM (?,?,?,?,?,?,?,?,?,?,?) item_value FROM dual";
		
		
		oPreparedStmt	= connection.prepareStatement(sqlString);
		oPreparedStmt.setString(1, getLoginFacilityId());					
		oPreparedStmt.setString(2,getP_episode_type());					
		oPreparedStmt.setString(3,getPatientId());	
		oPreparedStmt.setString(4,  getP_episode_id());					
		oPreparedStmt.setString(5, getP_visit_id());					
		oPreparedStmt.setString(6, getEncounterId());
		oPreparedStmt.setString(7, getP_generic_code());	
		oPreparedStmt.setString(8, getP_strength_value());	
		oPreparedStmt.setString(9, getP_strength_uom());	
		oPreparedStmt.setString(10, getP_form_code());	
		oPreparedStmt.setString(11, getStoreCode());	
		
		//oPreparedStmt.setString(7, item_codes);					
		//oPreparedStmt.setString(8, store_codes);	
		oResultSet	= oPreparedStmt.executeQuery();
		if(oResultSet !=null){
			while(oResultSet.next()){	
				pre_aloc_drug=oResultSet.getString("item_value");	
				if(pre_aloc_drug==null) 
					pre_aloc_drug="";
			}
		}
	}  */
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		try{
			closeStatement(callableStatement);
			/*closeResultSet( oResultSet1 ) ;
			closeStatement( oPreparedStmt1  ) ;
			closeResultSet( oResultSet ) ;
			closeStatement( oPreparedStmt ) ;*/
			closeConnection( connection );
		}
		catch(Exception es){
			es.printStackTrace();
		}
	}
	String[] strtmp=(String[])sameGenericItemsdata.get(pre_aloc_drug);

	return strtmp;
	//here need to call procedure
}
else{
	return (String[])sameGenericItemsdata.get(item_codes);
}
		//return result;
	}
	//Added for TFS id:7345 end		
	
	//Added for MMS-DM-CRF-0177
	public ArrayList getListValuesForForm(String code,String from) throws Exception{
		
		String sql="";
		if(from.equals("G"))
			 sql="SELECT form_code code, form_desc description FROM ph_form_lang_vw ph_form WHERE form_code in (SELECT DISTINCT FORM_CODE FROM PH_DRUG WHERE GENERIC_ID = ?) and eff_status = 'E' AND language_id = ? ORDER BY 2";
		else if(from.equals("T")) //Modified for NMC-JD-SCF-0159
			sql="SELECT form_code code, form_desc description FROM ph_form_lang_vw ph_form WHERE form_code in (SELECT DISTINCT FORM_CODE FROM PH_DRUG_VW  WHERE TRADE_CODE =?) and eff_status = 'E' AND language_id = ? ORDER BY 2";
		else //Modified for NMC-JD-SCF-0159
			sql = "SELECT FORM_CODE CODE, FORM_DESC DESCRIPTION FROM PH_FORM_LANG_VW PH_FORM WHERE EFF_STATUS='E' and upper(FORM_CODE) like upper(?) and upper(FORM_DESC) like upper(?) AND LANGUAGE_ID = ?";	
		ArrayList result		=	new ArrayList();
		if((from.equals("G") || from.equals("T"))){ //Modified for NMC-JD-SCF-0159
			String chkParameters[]={code,getLanguageId()};
			result = fetchRecords(sql,chkParameters);
		}
		else{ //Modified for NMC-JD-SCF-0159
			String chkParameters[]={code,code,getLanguageId()};
			result = fetchRecords(sql,chkParameters);
		}
		
		
		
		return result;
	}
	
	public ArrayList getListValuesForStrength(String code,String from) throws Exception{
	
		String sql="";
		if(from.equals("G"))
			 sql="SELECT UOM_CODE code, SHORT_DESC description FROM AM_UOM_LANG_VW WHERE UOM_CODE IN (SELECT DISTINCT STRENGTH_UOM FROM PH_DRUG WHERE GENERIC_ID = ?) AND STRENGTH_UOM_YN='Y' AND EFF_STATUS='E' ORDER BY 2";
		else if(from.equals("T"))  //Modified for NMC-JD-SCF-0159
			sql="SELECT UOM_CODE code, SHORT_DESC description FROM AM_UOM_LANG_VW WHERE UOM_CODE IN (SELECT DISTINCT STRENGTH_UOM FROM PH_DRUG_VW  WHERE TRADE_CODE =?) AND STRENGTH_UOM_YN='Y' AND EFF_STATUS='E' ORDER BY 2" ;
		else
			sql="SELECT UOM_CODE code, SHORT_DESC description FROM AM_UOM WHERE STRENGTH_UOM_YN='Y' AND EFF_STATUS='E' ORDER BY 2";
		ArrayList result		=	new ArrayList();
		if((from.equals("G") || from.equals("T"))){  //Modified for NMC-JD-SCF-0159
			String chkParameters[]={code};
			result = fetchRecords(sql,chkParameters);
		}
		else{  //Modified for NMC-JD-SCF-0159
			String chkParameters[]={};
			result = fetchRecords(sql,chkParameters);
		}
		return result;
	}
	//Added for MMS-DM-CRF-0177
	//Added for TFS id:-16341 start
	public String getDefaultDispLocn(){
		Connection connection = null ;
		PreparedStatement pstmt_displocn = null ;
		ResultSet resultSet_displocn = null ;
		String disp_locn		= "";
		try {
			connection = getConnection() ;
			pstmt_displocn = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DFLT_DISP_LOCN_CODE_SELECT") );
			pstmt_displocn.setString(1,login_facility_id);
			resultSet_displocn = pstmt_displocn.executeQuery() ;
			while (resultSet_displocn != null && resultSet_displocn.next()){
				disp_locn	= resultSet_displocn.getString("DFLT_DISP_LOCN");
				setDispLocnCode(disp_locn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet_displocn ) ;
				closeStatement( pstmt_displocn ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return disp_locn;
	}
	public boolean defaultDispLocnSelectAppl(){
		Connection connection = null ;
		
		boolean default_disp_locn_select_appl		=false;
		try {
			connection = getConnection() ;
			default_disp_locn_select_appl = eCommon.Common.CommonBean.isSiteSpecific(connection,"PH","PH_DISP_LOCN_SELECT_APPL");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		setDefaultDispLocnSelectAppl(default_disp_locn_select_appl);
		return default_disp_locn_select_appl;
	}
	
	//Added for TFS id:-16341 end
	public String getDiagnosisLevel(){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String diagnosisEncountLevel	= "N";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "SELECT DIAG_ENC_LEVEL FROM MR_PARAMETER" );
			
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
				diagnosisEncountLevel	= resultSet.getString("DIAG_ENC_LEVEL");				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return diagnosisEncountLevel;
	}
}