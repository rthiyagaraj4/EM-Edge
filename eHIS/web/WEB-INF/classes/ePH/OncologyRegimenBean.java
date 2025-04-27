/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
---------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Rev.Date     Rev.By		Description
--------------------------------------------------------------------------------------------------------
23/02/2018	IN066779		Sharanraj	23/02/2018	  Chandra       ML-MMOH-CRF-1000.1
05/03/2019	IN068344	     	Manickavasagam 		  			GHL-CRF-0549 [IN068344] 
12/08/2019  IN:070451       B Haribabu   12/08/2019   Manickavasagam  ML-MMOH-CRF-1408
01/06/2020  IN072753        Prabha								   NMC-JD-CRF-0046
25/06/2020  IN:072715        Haribabu    25/06/2020   Haribabu      MMS-DM-CRF-0165
14/12/2020			6041	Shazana       	14/12/2020		Manickavasagam J	NMC-JD-CRF-0063
13/7/2023      TFS-46322      hariharan             Ramesh goil            COMMON-ICN-0310
--------------------------------------------------------------------------------------------------------
 */
package ePH;

import oracle.sql.*; 
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import ePH.Common.*;
import eCommon.Common.*;
import eOR.*;
import eOR.Common.ChkDef;//IN066779
import java.text.DecimalFormat;

public class OncologyRegimenBean extends PhAdapter implements Serializable, eOR.SceduleFreqeuncyInterface {

	private String order_date			= "";
	private String patient_class		= "";
	private String patient_id			= "";
	private String encounter_id			= "";
	private String problem_ind			= "";
	private String freqNature			= "";
	private String repeat_value			= "";
	private String int_value			= "";
	private String infRate_srlNo		= "";
	private String order_remarks		= "";
	private String catalog_short_desc   = "";
	private String order_status			= "10";
	private String Freq_code            = "";
	private String DefaultFluidremarks  = "";
	String  initial_order_id            ="";
	
	private ArrayList diagText			= new ArrayList(12);
	private String orderID				= "";
	private HashMap hashMapFreq			= new HashMap();
	private HashMap hashMapDurn_value	= new HashMap();
	private HashMap hashMapDurn_type	= new HashMap();
	private int srlNo					= 0;
	private ArrayList drugDetails		= new ArrayList();
	private ArrayList existingCYTORecrds= new ArrayList();
	private ArrayList DrugRemarks		= new ArrayList();
	private ArrayList fluidRemarks		= new ArrayList();
	private ArrayList drugCodes			= new ArrayList();
	private ArrayList doseUoms		= new ArrayList();

	private HashMap scheduleFrequency	= new HashMap();
	private HashMap compFluidDetails	= new HashMap();
	private HashMap FluidDetails		= new HashMap();
	private HashMap dosageUOM		    = new HashMap();
	private String debugString			= "";
	private String trn_group_ref= "";
	private String tokens_generated_yn= "";
	private HashMap schdMap = null;
	//for fdb check
	private String ext_db_interface_yn	= "N";
	//private String prev_drug_code = "";
	private String perf_facility_id = "";
	private String buildMAR_yn = "";
	private String print_ord_sht_rule_ind="";//Added for Bru-HIMS-CRF-393_1.0
	private String excludeADRAllergyAlert_yn = "";	// Added for HSA-SCF-0011 [IN:042444] start
	private HashMap cycleFreq = new HashMap();//ML-MMOH-CRF-0345
	private String end_date = "";//ML-MMOH-CRF-0345
	private String start_date = "";//ML-MMOH-CRF-0345
	//ML-MMOH-CRF-1014 - start
	private HashMap MFRRecs					= null;
	private HashMap MFRRecs_fluid			= new HashMap();
	private String MFRYN					= "N";
	private String serial_no				= "";
	private String mfr_remark_for_drug		= "";
	private HashMap mfr_remark				= new HashMap(); 
	private String drug_code				= "";
    private String drug_code_1				= "";
   	private HashMap MFRRecs_for_drugbased	= new HashMap(); 
//ML-MMOH-CRF-1014 - end
	protected HashMap amend_reason1			= new HashMap();//IN066779
	protected String order_Id="";//IN066779
	//Added for IN:070451 start
	private String weight;
	private String bsa;
	//Added for IN:072715  START
		private HashMap dose_remarks=new HashMap();
		private HashMap allergy_remarks=new HashMap();
		private HashMap dup_drug_remarks=new HashMap();
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
	//Added for IN:072715 END
	public String getDispLocnCode() { //START OF NMC-JD-CRF-0046
		return disp_locn_code;
	}
	public void setDispLocnCode(String disp_locn_code) {  
	
		this.disp_locn_code = disp_locn_code;
	}

	private String disp_locn_code;    //END OF NMC-JD-CRF-0046
	public void setWeight(String weight) {
		this.weight = checkForNull(weight, "1");
	}
	public String getWeight() {
		return weight;
	}
	public void setBsa(String bsa) {
		this.bsa =checkForNull(bsa, "1"); 
	}
	public String getBsa() {
		return bsa;
	}
	//Added for IN:070451 end
	public String getExcludeADRAllergyAlert() {
		return excludeADRAllergyAlert_yn;
	}
	public void setExcludeADRAllergyAlert(String excludeADRAllergyAlert_yn) {
		this.excludeADRAllergyAlert_yn = excludeADRAllergyAlert_yn;
	}									// Added for HSA-SCF-0011 [IN:042444] end

	/*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/
	PrescriptionBean_1 presbeanobj = null;
	
	public void setObject(PrescriptionBean_1 presbean) {
		presbeanobj = presbean;
	}
	/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/	
//ML-MMOH-CRF-0345 - start
	public void setCycleDetails(String drug_code,HashMap cycleFrequency){
		this.cycleFreq.put(drug_code,cycleFrequency);
	}
	public HashMap getCycleDetails() {
		return this.cycleFreq;
	}
	public void setOrderEndDate(String end_date){
		this.end_date = end_date;
	}
	public String getOrderEndDate() {
		return this.end_date;
	}
	public void setAmendOrderStartAndEndDate(String startend_date){
		this.start_date = startend_date;
	}
	public String getAmendOrderStartDate() {
		return this.start_date;
	}
//ML-MMOH-CRF-0345 - end
//ML-MMOH-CRF-1014 - start
	public void setdrugCode(String drug_code){
	     this.drug_code = drug_code;
	}
    	public String getdrugCode()
	{
		return this.drug_code;
	}
	public void setSerialNo(String srl_no)
	{
		this.serial_no=srl_no;
	}
	public String getSerialNo(){
	  return this.serial_no;
	}

	public void setMFRRecs(HashMap MFRRecs){
		drug_code_1 = getdrugCode();
		drug_code_1 = getdrugCode()+this.serial_no; 
//System.err.println("drug_code_1=====133==>"+drug_code_1);		
		this.MFRRecs.put(drug_code_1,MFRRecs);
		
	}
	public HashMap getMFRRecs(){
		drug_code_1 = getdrugCode();
	drug_code_1 = getdrugCode()+this.serial_no;
     MFRRecs_for_drugbased =(HashMap)MFRRecs.get(drug_code_1)==null?new HashMap():(HashMap)MFRRecs.get(drug_code_1);  //CRF-673.2 - drug_code_1
		return this.MFRRecs_for_drugbased;

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
	
	public void setMFRYN(String MfrYn){
		MFRYN = MfrYn;
	}



	public void setmfr_remark(String drug_code_1,String mfr_remark){
	  	drug_code_1 = drug_code_1+this.serial_no;

		this.mfr_remark.put(drug_code_1,mfr_remark);
 	}
	public HashMap getmfr_remark(){
      		return mfr_remark;	 
	}
	public String getMFRRemarkForDrug(){
		
		drug_code_1 = getdrugCode()+this.serial_no;
		return this.mfr_remark_for_drug = (String)mfr_remark.get(drug_code_1);
	}
//ML-MMOH-CRF-1014 - end
	public String getDebugString() {
		return this.debugString;
	}

	public String existsscheduleFrequency(String drugcode){

		if (scheduleFrequency.containsKey(drugcode)){
			return "Y";
		}
		else{	
			return "N";
		}
	}

	public void setDebugString(String debugString) {
		this.debugString = debugString;
	}

	public HashMap getDosageUOMS(){
		return this.dosageUOM;
	}

	public void setDosageUOMS(HashMap dosageUOM){
		this.dosageUOM = dosageUOM;
	}

	public OncologyRegimenBean() {
        try {
			int i=0;
			while (i < 12) {
				diagText.add("");
				i++;
			}
            doCommon();
        }
		catch(Exception e) {
			e.printStackTrace() ;
		}
	}

	public void setDiagText(ArrayList diagText) {
		this.diagText = new ArrayList();
		this.diagText = diagText;
	}

	public ArrayList getDiagText() {
		return this.diagText;
	}

	private void doCommon() throws Exception {
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
	public void  setScheduleDates(HashMap schdMap)
	{
		this.schdMap = schdMap;	
	}
	public HashMap getScheduleDates()
	{
		return this.schdMap;
	}
	
	public void clear() {

		super.clear();
		order_date			= "";
		patient_class		= "";
		patient_id			= "";
		encounter_id		= "";
		infRate_srlNo		= "";
		freqNature			= "";
		repeat_value		= "";
		int_value			= "";
		problem_ind			= "";
		order_remarks		= "";
		catalog_short_desc	= "";
		hashMapFreq			= new HashMap();
		hashMapDurn_value	= new HashMap();
		hashMapDurn_type	= new HashMap();
		compFluidDetails	= new HashMap();
		cycleFreq			= new HashMap();//ML-MMOH-CRF-0345
		order_status		= "10";
		srlNo				= 0;
		drugCodes			= new ArrayList();
		drugDetails			= new ArrayList();
		existingCYTORecrds	= new ArrayList();
		DrugRemarks			= new ArrayList();
		fluidRemarks		= new ArrayList();
		doseUoms			= new ArrayList();
		diagText			= new ArrayList(12);
		FluidDetails		= null;
		DefaultFluidremarks = "";
		buildMAR_yn = "";
		MFRYN				= "N";//ML-MMOH-CRF-1014 - start
		MFRRecs				= new HashMap();
		MFRRecs_fluid		= new HashMap();
		MFRRecs_for_drugbased = new HashMap();
		mfr_remark			  = new HashMap();
		drug_code			= "";
		mfr_remark_for_drug = "";//ML-MMOH-CRF-1014 - end
		//Added for IN:072715 start
		dose_remarks= new HashMap();
		allergy_remarks= new HashMap();
		dup_drug_remarks= new HashMap();
		take_home_medication_op = "";//added for NMC-JD-CRF-0063 START
		opDischMedInd="";//END
		
		//Added for IN:072715 end
	}

	public ArrayList getDrugRemarks() {
		return this.DrugRemarks;
	}

	public ArrayList getFluidRemarks() {
			return this.fluidRemarks;
	}


	public void genDrugRemarks(ArrayList drugremarks) {
		this.DrugRemarks = drugremarks;
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

	public void setOrderDate(String order_date) {
		this.order_date = order_date;
	}

	public void setPatientClass(String patient_class) {
		
		this.patient_class = patient_class;
	}

	public void setProblemInd(String problem_ind) {
		this.problem_ind = problem_ind;
	}
	
	public void setDrugCodes(ArrayList drugCodes) {

		if(drugCodes!=null && drugCodes.size()>=3){ //changed 2 to 3 for ML-MMOH-CRF-1227.1
			for(int i=0; i<drugCodes.size();i++){
				this.drugCodes.add(drugCodes.get(i));
				this.drugCodes.add(drugCodes.get(++i));
				this.drugCodes.add(drugCodes.get(++i)); //ML-MMOH-CRF-1227.1
			}
		}
	}
	public void setPresRemarks(String order_remarks) {
		this.order_remarks = order_remarks;
	}
	public void setDrugRemarks(ArrayList drug_remarks) {
		this.DrugRemarks = drug_remarks;
	}
	public void setFluidRemarks(ArrayList fluid_remarks) {
		this.fluidRemarks = fluid_remarks;
	}
	public void setCatalogDesc(String catalog_desc) {
		this.catalog_short_desc = catalog_desc;
	}
	public void setFreq_code(String Freq_code) {
		this.Freq_code = Freq_code;
	}
	public String getFreq_code() {
		return this.Freq_code;
	}   
	public void setBuildMAR_yn(String buildMAR_yn) {
		this.buildMAR_yn = buildMAR_yn;
	}
	public String getBuildMAR_yn() {
		return this.buildMAR_yn;
	}   
	public void setDefaultFluidremarks(String DefaultFluidremarks) {
		this.DefaultFluidremarks = DefaultFluidremarks;
	}
	public String getDefaultFluidremarks() {
		return this.DefaultFluidremarks;
	}

	public void removeDrugCode(String drug_code, String ocurrance_num) {
		ArrayList avlDrugCodes	= getDrugCodes();
		ArrayList newDrugList	= new ArrayList();
	/*	StringTokenizer st = new StringTokenizer(avlDrugCodes, ",");
		String newDrugCodes = "";
		while (st.hasMoreTokens()) {
			String thisToken = st.nextToken();
			if (!(thisToken.equals(drug_code))) {
				newDrugCodes = newDrugCodes + thisToken + ",";
			}
		}*/
		for(int i=0; i<avlDrugCodes.size(); i++){
			if(!(((String)avlDrugCodes.get(i)).equals(drug_code) && ((String)avlDrugCodes.get(i+1)).equals(ocurrance_num))){
				newDrugList.add(avlDrugCodes.get(i));
				newDrugList.add(avlDrugCodes.get(++i));//ML-MMOH-CRF-1227.1
				newDrugList.add(avlDrugCodes.get(++i));
			}
			else
				i=i+2; //changed i++ to i+2 for ML-MMOH-CRF-1227.1
		}
		this.drugCodes =new ArrayList();
		setDrugCodes(newDrugList);
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

    public ArrayList getExistingCYTORecords() {
		return this.existingCYTORecrds;
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

	public String getOrderDate() {
		return this.order_date;
	}

	public String getPatientClass() {
		
		return this.patient_class;
	}

	public ArrayList getDrugCodes() {
		return this.drugCodes;
	}

	public String getFrequencyNature() {
		return this.freqNature;
	}

	public String getRepeatValue() {
		return this.repeat_value;
	}

	public String getPresRemarks() {
		return this.order_remarks;
	}

	public HashMap getCompFluidDetails() {
		return this.compFluidDetails;
	}

	public String getCatalogDesc() {
		return this.catalog_short_desc;
	}


	public String getIntervalValue() {
		return this.int_value;
	}

	public void setPrintOrdShtRuleInd(String print_ord_sht_rule_ind) {//Added for Bru-HIMS-CRF-393_1.0
		this.print_ord_sht_rule_ind=print_ord_sht_rule_ind;			
	}
	public String getPrintOrdShtRuleInd() {	
		return this.print_ord_sht_rule_ind;
	}
	
	public String getProblemInd() {
		return this.problem_ind;
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

	public void removeDrugFromList(int srlNo, String drug_code, String ocurrance_num) {
		removeDrugCode(drug_code, ocurrance_num);
		ArrayList temp = getDrugDetails();
		temp.remove(srlNo);
		temp.add(srlNo, new HashMap());
		this.drugDetails = temp;
		//HashMap	crntRxDrugDetails = new HashMap();
		HashMap	ind_drg_dtls	  = new HashMap();
		Connection connection	  = null;
		//String	exst_generic_id	  = "";
		PreparedStatement pstmt_pres_select13C	= null;
		ResultSet resultSet						= null;
		int count_rx	= 0;

        try{
			connection				= getConnection();
//			pstmt_pres_select13C	= 	connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13C"));
			pstmt_pres_select13C	= 	connection.prepareStatement("SELECT  COUNT(ROWID) FROM  PH_PATIENT_DRUG_PROFILE A WHERE   PATIENT_ID =? AND END_DATE >= to_date(?,'dd/mm/yyyy hh24:mi') AND  TO_DATE(?,'DD/MM/RRRR HH24:MI') BETWEEN  TO_DATE(START_DATE,'DD/MM/RRRR HH24:MI') AND  TO_DATE(END_DATE,'DD/MM/RRRR HH24:MI')   AND DISCONT_DATE_TIME IS NULL AND ON_HOLD_DATE_TIME IS NULL AND  CANCEL_YN='N' AND   STOP_YN='N' AND GENERIC_ID=?");


			for(int i=0;i<drugDetails.size();i++){
				ind_drg_dtls = (HashMap)drugDetails.get(i);

				if(ind_drg_dtls !=null && ind_drg_dtls.size()>0){
					count_rx	= 0;
					try{
						pstmt_pres_select13C.setString(1, getPatId());
						pstmt_pres_select13C.setString(2, getOrderDate());
						pstmt_pres_select13C.setString(3, getOrderDate());
//						pstmt_pres_select13C.setString(4, getFreq_code());
						pstmt_pres_select13C.setString(4, (String)ind_drg_dtls.get("GENERIC_ID"));

						resultSet			= pstmt_pres_select13C.executeQuery();
						if(resultSet!=null && resultSet.next()) {
							count_rx=resultSet.getInt(1);
						}

						if(count_rx>0) {
							ind_drg_dtls.put("CURRENT_RX","Y");
						} else {
							ind_drg_dtls.put("CURRENT_RX","N");
						}

					/*	for(int crnt_rx = 0;crnt_rx<drugDetails.size();crnt_rx++){
							crntRxDrugDetails = (HashMap)drugDetails.get(crnt_rx);
							if(crntRxDrugDetails != null && crntRxDrugDetails.size()>0){
								//if(!((String)ind_drg_dtls.get("DRUG_CODE")).equals((String)crntRxDrugDetails.get("DRUG_CODE"))){
									exst_generic_id	  = (String)crntRxDrugDetails.get("GENERIC_ID");
System.out.println("exst_generic_id ----|"+exst_generic_id);
									if(exst_generic_id.equals((String)ind_drg_dtls.get("GENERIC_ID"))){
										ind_drg_dtls.put("CURRENT_RX","Y");
									}
								//}
							}
						}*/
					}catch(Exception ex){
						ex.printStackTrace() ;
						System.out.println("Inside deletion ---"+ex.toString());
					}
					finally{
						try{
							closeResultSet( resultSet ) ;
						}
						catch(Exception es){
							es.printStackTrace() ;
						}
					}
				}
			}

		  }catch(Exception topEx){
			topEx.printStackTrace();
		  }finally{
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt_pres_select13C ) ;
					closeConnection( connection );
				}
				catch(Exception etop){
					etop.printStackTrace() ;
				}
		  }
	}
	public void addToDrugCodes(String drugCode){
		int occuranceNum = 0;
			if(drugCodes != null && drugCodes.size()>0){
				for(int i=0;i<drugCodes.size();i=i+3){ //changed 2 to 3 for ML-MMOH-CRF-1227.1
					occuranceNum = Integer.parseInt((String)drugCodes.get(i+1));
				}
				occuranceNum++;
			}
		this.drugCodes.add(drugCode);
		this.drugCodes.add(occuranceNum+"");
		this.drugCodes.add(occuranceNum+""); // ML-MMOH-CRF-1227.1
	}
	public void addToDrugCodes(String drugCode,String occuranceNum,String dosage_type_seq_no){ //dosage_type_seq_no added for ML-MMOH-CRF-1227.1
		//int occuranceNum = 0;
			//if(drugCodes != null && drugCodes.size()>0){
				//for(int i=0;i<drugCodes.size();i=i+2){
					//occuranceNum = Integer.parseInt((String)drugCodes.get(i+1));
				//}
				//occuranceNum++;
			//}
		this.drugCodes.add(drugCode);
		this.drugCodes.add(occuranceNum);
		this.drugCodes.add(dosage_type_seq_no); //added for ML-MMOH-CRF-1227.1

	}
	
	public String getDummyOrderID(){
		return	initial_order_id;
	}

	public void setDummyOrderID(String order_id){
         this.initial_order_id=order_id;
	}

	public void setExternalDrugDataBaseInterface_yn(String ext_db_interface_yn){
		this.ext_db_interface_yn = ext_db_interface_yn;
	}
	public String getExternalDrugDataBaseInterface_yn(){
		return this.ext_db_interface_yn;

	}
	public ArrayList getDoseUom(){

		Connection connection	= null;
		Statement stmt = null;
		ResultSet resultSet		= null;
//		doseUoms		= new ArrayList();
		try {
			if(doseUoms == null || doseUoms.size() < 1){
				connection	= getConnection();
				stmt		= connection.createStatement();	
				resultSet	= stmt.executeQuery("select uom_code code from am_uom where UPPER(uom_code) in ('G', 'MG', 'MCG', 'NCG')");
				while(resultSet.next()) {
					doseUoms.add(resultSet.getString("code"));
				}
			}

		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( stmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return doseUoms;
	}
	public String doPrinting(Object request,Object response, String locn_code, String patient_class,String prescriptionPrint, String NarcoticPrint, String patient_id) {//code 'String patient_id' added for SKR-SCF-0915[IN046734]
   
		String facility_id	= getLoginFacilityId();
		String fr_order_id= "";
		String to_order_id  = "";
		Connection connection       = null ;
	    PreparedStatement pstmt     = null ;
	    ResultSet resultSet         = null ;
	   	String sql_query	    	= "";
		String ReportOutput         = "";
		ArrayList order_ids         = new ArrayList();
		ArrayList narcotic_nos      = new ArrayList();
		
		try{
			connection 	= getConnection() ;
			if( patient_class == ""){
				sql_query  	= PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_ORDERIDS_SELECT1");	
			}
			else{
				sql_query  	= PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_ORDERIDS_SELECT");
			}
			pstmt	   	= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,initial_order_id);
			resultSet   = pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				order_ids.add(resultSet.getString("ORDER_ID"));
			}

			 if((NarcoticPrint.toUpperCase()).equals("Y")){
				   try{
						connection = getConnection() ;

						pstmt				= connection.prepareStatement("select NARCO_NO from or_order_line_ph where order_id between ? and ? and NARCO_NO is not null") ;

						pstmt.setString(1,(String)order_ids.get(0));
						pstmt.setString(2,(String)order_ids.get((order_ids.size()-1)));
						resultSet			= pstmt.executeQuery();
						while(resultSet!=null && resultSet.next()){
							narcotic_nos.add(resultSet.getString("NARCO_NO"));
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
			 }
			
			this.initial_order_id="";
			
			if(order_ids != null && order_ids.size() > 0){
				if(prescriptionPrint.equals("Y")){
					fr_order_id=(String)order_ids.get(0);
					to_order_id=(String)order_ids.get((order_ids.size()-1));

					ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports();
					ecis.utils.OnlineReport report2			= new ecis.utils.OnlineReport(facility_id, "PH", "PHBOPPCYTO");
					
					report2.addParameter("p_facility_id", facility_id);
					report2.addParameter("p_module_id", "PH");
					report2.addParameter("p_report_id", "PHBOPPCYTO");
					report2.addParameter("p_fm_order_id", fr_order_id);
					report2.addParameter("p_to_order_id", to_order_id);
					report2.addParameter("p_locncode", locn_code);
					report2.addParameter("p_patclass", patient_class);
					report2.addParameter("p_user_name", login_by_id);
					report2.addParameter("p_language_id", getLanguageId());
					report2.addParameter("p_patient_id", patient_id);//code added for SKR-SCF-0915[IN046734]
					onlineReports.add(report2);
					ReportOutput = onlineReports.execute((HttpServletRequest)request, (HttpServletResponse)response);
				}
				if((NarcoticPrint.toUpperCase()).equals("Y")){
					/*ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
					ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHRNARFORM") ;
					report2.addParameter("p_report_id", "PHRNARFORM") ;
					report2.addParameter("P_FR_ORDER_ID", fr_order_id) ;
					report2.addParameter("P_TO_ORDER_ID", to_order_id) ;
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
		return ReportOutput;
	}
	
	public String getOrderID() {
		return this.orderID;
	}

	public HashMap getRegimenValues(String service_code) {
		Connection connection       = null ;
	    PreparedStatement pstmt     = null ;
	    ResultSet resultSet         = null ;
	    HashMap regimenValues	    = new HashMap();
		String sql_query	    	= "";
		try{
			connection 	= getConnection() ;
			sql_query  	= PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_SERVICE_SELECT");
			pstmt	   	= connection.prepareStatement(sql_query) ;
			pstmt.setString(1, service_code);
			resultSet   = pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				regimenValues.put("regimen_yn", (resultSet.getString("regimen_yn")==null ? "N":resultSet.getString("regimen_yn")) );
				regimenValues.put("tpn_yn", (resultSet.getString("tpn_yn")==null ? "N":resultSet.getString("tpn_yn")) );
				regimenValues.put("indicator_desc", (resultSet.getString("indicator_desc")==null ? "":resultSet.getString("indicator_desc")) );
				regimenValues.put("problem_ind", (resultSet.getString("problem_ind")==null ? "":resultSet.getString("problem_ind")) );

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
		return regimenValues;
	}

	public ArrayList getStageValues(String problem_ind) {
		Connection connection       = null ;
	    PreparedStatement pstmt     = null ;
	    ResultSet resultSet         = null ;
	    ArrayList stageValues	    = new ArrayList();
		try{
			connection 	= getConnection() ;
			pstmt	   	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_STAGE_SELECT")) ;
			pstmt.setString(1, problem_ind);
			pstmt.setString(2, getLanguageId());
			resultSet   = pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				String record[] = new String[2];
				record[0] = (resultSet.getString("stage_code")==null ? "":resultSet.getString("stage_code")) ;
				record[1] = (resultSet.getString("short_desc")==null ? "":resultSet.getString("short_desc"));
				stageValues.add(record) ;
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
				es.printStackTrace() ;
			}
		}
		return stageValues;
	}

	public ArrayList getIntentionValues(String problem_ind) {
		Connection connection       = null ;
	    PreparedStatement pstmt     = null ;
	    ResultSet resultSet         = null ;
	    ArrayList intentionValues	= new ArrayList();
		try{
			connection 	= getConnection() ;
			pstmt	   	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_INTENTION_SELECT")) ;
			pstmt.setString(1, problem_ind);
			pstmt.setString(2, getLanguageId());

			resultSet   = pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				String record[] = new String[2];
				record[0] = (resultSet.getString("intention_code")==null ? "":resultSet.getString("intention_code")) ;
				record[1] = (resultSet.getString("short_desc")==null ? "":resultSet.getString("short_desc"));
				intentionValues.add(record) ;
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
		return intentionValues;
	}


  	public ArrayList getRegimen(String source_type,String source_code,String service_code,String pract_id,String Pract_type,String patient_class,String patient_id) {
		Connection connection       = null ;
	    PreparedStatement pstmt     = null ;
	    ResultSet resultSet         = null ;
	    ArrayList regimenValues	= new ArrayList();
		try{
			connection 	= getConnection() ;
			pstmt	   	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_SELECT")) ;
			pstmt.setString(1, "PH");
			pstmt.setString(2, login_facility_id);
			pstmt.setString(3, login_facility_id);
			pstmt.setString(4, source_type);
			pstmt.setString(5, source_type);
			pstmt.setString(6, source_code);
			pstmt.setString(7, source_code);
			pstmt.setString(8, service_code);
			pstmt.setString(9, service_code);
			pstmt.setString(10,pract_id );
			pstmt.setString(11,pract_id );
			pstmt.setString(12,null);
			pstmt.setString(13,Pract_type );
			pstmt.setString(14,patient_class );
			pstmt.setString(15,patient_id);
			pstmt.setString(16, getLanguageId());

			resultSet   = pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				String record[] = new String[2];
					record[0] = (resultSet.getString("order_catalog_code")==null ? "":resultSet.getString("order_catalog_code")) ;
					record[1] = (resultSet.getString("short_desc")==null ? "":resultSet.getString("short_desc"));
					regimenValues.add(record) ;
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
		return regimenValues;
	}


	public String setOrderID(String order_category) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String order_id			= null;
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT37"));
			pstmt.setString(1, order_category);
			pstmt.setString(2, getPatientClass());
			pstmt.setString(3, login_facility_id); //thrid parameter for facility added for IN[032925]
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				order_id	 = resultSet.getString("order_id");
				this.orderID = order_id;
			}
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return order_id;
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return sched_yn;
	}

	public String getLocationDesc(String patient_class,String locn_code) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String locn_desc		=	"";

		try {
			connection	= getConnection();

			//if(patient_class.equals("IP") || patient_class.equals("EA"))
			if(patient_class.equals("IP") || patient_class.equals("DC"))
				pstmt	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT41"));
			else if (patient_class.equals("OP") || patient_class.equals("EM"))
				pstmt	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT42"));

			pstmt.setString(1, getLoginFacilityId());
			pstmt.setString(2, locn_code);
			pstmt.setString(3, getLanguageId());

			resultSet	= pstmt.executeQuery();
			if (resultSet!=null && resultSet.next()) {
				locn_desc = resultSet.getString("LONG_DESC");
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
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
		String	age_in_mints				=	"";//ML-MMOH-CRF-1408
		String	age_group				=	"";
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
				age_in_mints				=	resultSet.getString("AGE_IN_MINTS");//ML-MMOH-CRF-1408

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
			pat_details.put("age_in_mints",age_in_mints); //added for ML-MMOH-CRF-1408

			age_in_mints	=	age_in_mints.trim();//added for ML-MMOH-CRF-1408
			sex	=	sex.substring(0,1);
			
			pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80A") ) ;
			pstmt.setString(1,sex);
			pstmt.setString(2,age_in_mints); //modified age to age_in_mints for  ML-MMOH-CRF-1408
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

			pat_details.put("age_group",age_group);

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

	public ArrayList populateFrequencyValues(String order_catalog_code) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList frequency		= new ArrayList();

		try {
			connection	= getConnection();
            String sql_query="";
			String patient_class=getPatientClass();
			boolean site_spec = isSiteSpecific("OR", "OR_ORDER_SET");//ML-MMOH-CRF-0345
			if(patient_class!=null && !patient_class.equals("")){
				if(site_spec){//ML-MMOH-CRF-0345
				sql_query = "SELECT DISTINCT A.FREQ_CODE,A.FREQ_DESC, A.FREQ_NATURE FROM AM_FREQUENCY_LANG_VW A, OR_FREQ_CATALOG_SCOPE B , am_frequency_admin_day_time c WHERE A.EFF_STATUS='E' AND FREQ_NATURE = 'Y' AND A.FREQ_CODE = B.FREQ_CODE AND (A.SCHEDULED_YN='Y' and b.freq_code = c.freq_code and c.admin_facility_id in (?,'*A',?)) AND B.ORDER_CATALOG_CODE=? AND A.LANGUAGE_ID = ? ORDER BY 2";
				}else{
					sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10A_IP");
				
				}
				pstmt		= connection.prepareStatement(sql_query);
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,login_facility_id);
				pstmt.setString(3,order_catalog_code);
				pstmt.setString(4, getLanguageId());

				resultSet	= pstmt.executeQuery();

				while (resultSet.next()) {
					frequency.add(resultSet.getString("FREQ_CODE"));
					frequency.add(resultSet.getString("FREQ_DESC"));
				}
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
				es.printStackTrace() ;
			}
		}
		return frequency;
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
			}

			pstmt		= null;
			resultSet	= null;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT50A"));
			pstmt.setString(1,pract_id);
			pstmt.setString(2,resp_id);
			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				authValues.put("SPL_APPR_YN",(resultSet.getString("SPL_APPR_YN")==null ? "N":resultSet.getString("SPL_APPR_YN")));
			}

			pstmt		= null;
			resultSet	= null;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT50B"));
			pstmt.setString(1,pract_id);
			pstmt.setString(2,resp_id);
			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				authValues.put("COSIGN_YN",(resultSet.getString("COSIGN_YN")==null ? "N":resultSet.getString("COSIGN_YN")));
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

	public String getOrderType(String drug_code) {
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		String order_type_code	= "";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT6"));
			pstmt.setString(1, drug_code);
			resultSet	= pstmt.executeQuery();

			if (resultSet.next()) {
				order_type_code = checkNullResult(resultSet.getString("ORDER_TYPE_CODE"), "");
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
				es.printStackTrace() ;
			}
		}
		return order_type_code;
	}

/*	public String populateEndDate(String start_date, String durn_value, String durn_type) {
		Connection connection		= null;
        CallableStatement cstmt		= null;
        ResultSet resultSet			= null;
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
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return end_date;
	}*/


	public String populateEndDate(String start_date,String durn_value,String repeat_durn_type){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String end_date				="";
		try{
			/*if(!getLanguageId().equals("en")){ //  if block Added for RollForward from SRR - SRR20056-SCF-9376 [IN056775]
				start_date=com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",getLanguageId(),"en");				   
			}*/
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
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
				//pstmt.setString(1,form_code);
				//pstmt.setString(2,route_code);
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return pres_values;
	}


	public String getDfltIVRouteCode() {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String dfltIVRouteCode	= "";
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT5"));
			pstmt.setString(1, getLanguageId());
			resultSet	= pstmt.executeQuery();
			while (resultSet!=null && resultSet.next()) {
				dfltIVRouteCode = resultSet.getString("DFLT_IV_ROUTE_CODE");
			}
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return dfltIVRouteCode;
	}

	public void amendDrugs(int srlNo, Hashtable amendDetails) {

		ArrayList temp = getDrugDetails();		
		HashMap tempMap = (HashMap)temp.get(srlNo);
		tempMap.put("stage", amendDetails.get("stage"));
		tempMap.put("intention", amendDetails.get("intention"));
		tempMap.put("regimen_code", amendDetails.get("regimen_code"));
		tempMap.put("dose", amendDetails.get("totalDose"));
		tempMap.put("drug_unit", amendDetails.get("drug_unit"));
		tempMap.put("CALC_DOSE_BASED_ON", amendDetails.get("CALC_DOSE_BASED_ON"));
		tempMap.put("DOSAGE_TYPE",amendDetails.get("dosage_type"));
		if(!(((String)amendDetails.get("CALC_DOSE_BASED_ON")).equals("D"))){

			tempMap.put("calc_dose", amendDetails.get("dose"));
			tempMap.put("calc_dose_uom", amendDetails.get("doseUom"));
			tempMap.put("calc_dose_by", amendDetails.get("caclDoseBy_unit"));
		}
		else{
			if(((String)amendDetails.get("dosage_type")).equals("Q"))
			{

				tempMap.put("calc_dose", "0");
				tempMap.put("calc_dose_uom", "");
				tempMap.put("calc_dose_by", "");
			}
			else
			{

				tempMap.put("calc_dose", "0");
				tempMap.put("calc_dose_uom", amendDetails.get("doseUom"));
				tempMap.put("calc_dose_by", amendDetails.get("caclDoseBy_unit"));
			}
		}
		tempMap.put("drug_unit_code", amendDetails.get("drug_unit_code"));			
		tempMap.put("amend_fluid_code", amendDetails.get("amend_fluid_code"));		
		tempMap.put("amend_fluid_name", amendDetails.get("amend_fluid_name"));		
		tempMap.put("amend_stock_value", amendDetails.get("amend_stock_value"));

		tempMap.put("amend_stock_uom", amendDetails.get("amend_stock_uom")	);
		tempMap.put("amend_stock_uom_code", amendDetails.get("stock_uom_code")	);
		tempMap.put("amend_stock_uom_val", amendDetails.get("amend_stock_uom_val")	);	

		tempMap.put("amend_infusion_period_value", amendDetails.get("amend_infusion_period_value"));		
		tempMap.put("amend_infusion_period_uom", amendDetails.get("amend_infusion_period_uom"));	
		tempMap.put("amend_infusion_rate", amendDetails.get("amend_infusion_rate"));

		tempMap.put("amend_durn_value", amendDetails.get("amend_durn_value"));		
		
		tempMap.put("amend_durn_unit", amendDetails.get("amend_durn_unit"));		
		if(!getLanguageId().equals("en")){
			tempMap.put("amend_start_date", com.ehis.util.DateUtils.convertDate((String)amendDetails.get("amend_start_date"),"DMYHM",getLanguageId(),"en"));		
			tempMap.put("amend_end_date", com.ehis.util.DateUtils.convertDate((String)amendDetails.get("amend_end_date"),"DMYHM",getLanguageId(),"en"));
		}
		else{
			tempMap.put("amend_start_date", amendDetails.get("amend_start_date"));		
			tempMap.put("amend_end_date", amendDetails.get("amend_end_date"));
		}
		tempMap.put("DrugIndicationRemarks", amendDetails.get("DrugIndicationRemarks"));	
		tempMap.put("amend_frequency", amendDetails.get("amend_frequency"));		
		tempMap.put("amend_sched_medn_yn",amendDetails.get("amend_sched_medn_yn"));	
		tempMap.put("amend_repeat_value",amendDetails.get("amend_repeat_value"));	
		tempMap.put("amend_calc_unit", amendDetails.get("amend_calc_unit")	);
		tempMap.put("AMEND_YN", "Y");

		tempMap.put("APPROVAL_YN_VAL", amendDetails.get("approval_yn_val"));
		tempMap.put("AUTH_YN_VAL", amendDetails.get("auth_yn_val"));
		tempMap.put("COSIGN_YN_VAL", amendDetails.get("cosign_yn_val"));
		tempMap.put("IV_PREP_YN", amendDetails.get("iv_presc_yn"));
		String drug_desc=(String)tempMap.get("DRUG_DESC");
		String fluid_desc=(String)amendDetails.get("amend_fluid_name");

		tempMap.put("IV_INGREDIANTS", drug_desc+ "|" +fluid_desc  );
		tempMap.put("DefaultFluidchanged",amendDetails.get("DefaultFluidchanged"));
		
		if(amendDetails.get("fluid_frame_display_yn").equals("Y")){
			HashMap fluid_details =(HashMap)getFluidDetails(); 
			fluid_details.put("DefaultFluidremarks",getDefaultFluidremarks());
		}
	}

	public ArrayList getPatientActiveOrders(String patient_id) {
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

		ArrayList activeOrders		= new ArrayList();
		HashMap	record				= null;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT51"));
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
			catch(Exception es) {
			es.printStackTrace() ;
			}
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
			e.printStackTrace() ;
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){
			es.printStackTrace() ;
			}
		}
		return STinstalled;
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
			pstmt.setString(10,getLanguageId());

			resultSet	= pstmt.executeQuery();

			while (resultSet != null && resultSet.next()) {
				uom_code	=	resultSet.getString("UOM_CODE");
				uom_desc	=	resultSet.getString("SHORT_DESC");
				dflt_uom_yn =	resultSet.getString("qty_uom_yn");

				if(dflt_uom_yn.equals("Y")) {
					qty_values.put("dflt_code",uom_code);
				}
				qty_values.put(uom_code,uom_desc);
			}
		}
		catch(Exception e) {
			qty_values.put("Exception",e.toString());
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

	public ArrayList getStockDetails(String drug_code, String mode) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		ArrayList STinstalled	= new ArrayList();

		try {
			if (mode.equals("1")) {
				connection	= getConnection();
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT2"));
				pstmt.setString(1, drug_code);
				pstmt.setString(2, getLanguageId());
				resultSet	= pstmt.executeQuery();
				while (resultSet.next()) {
					STinstalled.add(checkNullResult(resultSet.getString("CONTENT_IN_PRES_BASE_UOM"), ""));
					STinstalled.add(checkNullResult(resultSet.getString("PRES_BASE_UOM"), ""));
					STinstalled.add(checkNullResult(resultSet.getString("SHORT_DESC"), ""));
				}
			}
			else if (mode.equals("2")) {
				connection	= getConnection();
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
			e.printStackTrace() ;
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return STinstalled;
	}

	public boolean ItemLinkcheck(String regCode)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String item_code = "";
		boolean item_linked_yn = true;

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_ITEM_LINK_SELECT"));

			pstmt.setString(1, regCode);
			resultSet	= pstmt.executeQuery();
			while(resultSet.next()) {
				item_code	=	resultSet.getString("ITEM_CODE");
				if(item_code==null || item_code.equals("")){
					item_linked_yn = false;
					break;
				}
			}
		}
		catch(Exception e) {
			item_linked_yn=false;
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ 
			es.printStackTrace() ;
			}
		}
		return item_linked_yn;
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
			catch(Exception es){ 
			es.printStackTrace() ;
			}
		}
		return equl_value;
	}

	public void setDrugDetails(String drugList,Hashtable hash) {
		String order_type_flag	=	(String)hash.get("order_type_flag");
		String order_id	=	(String)hash.get("order_id");//Added for IN:070451
		if(!order_type_flag.equals("Existing") && drugCodes.size()==0)
			setComponentDrugCodes(drugList,order_type_flag);
		// RUT-CRF-0062 [IN029600] -- begin
		String source_code=hash.get("source_code").toString();
		String priority	= hash.get("priority").toString();
		String act_pat_class	= hash.get("act_pat_class").toString();
		String take_home_medication	= hash.get("take_home_medication").toString();
		// RUT-CRF-0062 [IN029600] -- end
		String atc_allergy_alert_level	= hash.get("atc_allergy_alert_level").toString(); // RUT-CRF-0065 [IN029603]
		String strAD_DA ="'DA', 'AD'";// Added for HSA-SCF-0011 [IN:042444]  start
		if(getExcludeADRAllergyAlert().equals("Y")){
			strAD_DA = "'DA'";}		// Added for HSA-SCF-0011 [IN:042444] end
		String start_date	= getOrderDate();
		if(!getLanguageId().equals("en")){  //if block Added for RollForward from SRR - SRR20056-SCF-10519 [IN:057071]
			start_date = com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",getLanguageId(),"en");
		}
		String patientClass = getPatientClass();
		Connection connection			 = null;
		PreparedStatement pstmt_pres_select1A			 = null;
		PreparedStatement pstmt_pres_select2A			 = null;
		PreparedStatement pstmt_pres_select10C			 = null;
		PreparedStatement pstmt_pres_select3A			 = null;
		PreparedStatement pstmt_pres_select4A			 = null;
		PreparedStatement pstmt_pres_select5A			 = null;
		PreparedStatement pstmt_pres_select6A			 = null;
		PreparedStatement pstmt_pres_select7A			 = null;
		PreparedStatement pstmt_pres_select8A			 = null;
		PreparedStatement pstmt_pres_select9A			 = null;
		PreparedStatement pstmt_pres_select14A			 = null;
		PreparedStatement pstmt_pres_select13C			 = null;
		PreparedStatement pstmt_onco_reg_select1		 = null;
		PreparedStatement pstmt_amend_IV_select2		 = null;
		PreparedStatement pstmt_route_select		 = null;
		PreparedStatement pstmt_age_value_select     =null; // Added for ML-MMOH-CRF-0345 [IN:057441]
		PreparedStatement pstmt_age_value_select_all = null; // Added for ML-MMOH-CRF-0345 [IN:057441]
		PreparedStatement pstmt_age_value_select_default = null; // Added for ML-MMOH-CRF-0345 [IN:057441]
		PreparedStatement pstmt		 = null;
		ResultSet resultSet				 = null;
		ResultSet resultSet1				 = null;
		CallableStatement cstmt			 = null;
		String ext_prod_id				 = "";
		String calc_dflt_dosage_by_htwt				 = "";
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
		String repeat_value				 = "0";
		String order_type_code			 = "";
		String generic_id				 = "";
		String flag1                     = "N";
		String age_group                 = "";
//		String drug_indication			 = "";//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938] Removed for IN063877
		HashMap eqvlValues = new HashMap();
		boolean call_external_checks	 = false;
		HashMap crntRxDrugDetails		 = new HashMap();
		String  exst_generic_id			 = "";
		HashMap	tmp_hash				 = new HashMap();
		boolean	found					 = false;
		String  tmp_code				 = "";
		String  tmp_ocurrance_num		 = "";
		String form_code				 ="" ; // RUT-CRF-0062 [IN029600]
		String fract_dose_appl_yn		 ="" ; 
		String strength_per_value_pres_uom		 ="" ; 
		String age =  ""; // Added for ML-MMOH-CRF-0345 [IN:057441]
		String gender = ""; // Added for  ML-MMOH-CRF-0345 [IN:057441]
		String or_dosage_type = ""; //ML-MMOH-CRF-1227.1
		String sqlQueryorderSet    = "";//ML-MMOH-CRF-1227.1
		String dosage_type_seq_no  = "";//ML-MMOH-CRF-1227.1

		try {
			
			connection	= getConnection();

			//pstmt_pres_select1A		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT1A"));
			pstmt_pres_select1A		= connection.prepareStatement("SELECT ITEM_CODE,DRUG_CODE, ph_get_ext_prod_drug_code(?,?) EXTERNAL_PRODUCT_ID, DRUG_DESC,STOCK_UOM_DESC, IN_FORMULARY_YN,GENERIC_ID,GENERIC_NAME,DRUG_CLASS,FORM_CODE,FORM_DESC,B.ROUTE_CODE,B.ROUTE_DESC,PRES_BASE_UOM,PRES_BASE_UOM_DESC,STRENGTH_VALUE,STRENGTH_UOM,STRENGTH_UOM_DESC,STRENGTH_PER_PRES_UOM,STRENGTH_PER_VALUE_PRES_UOM,PRES_CATG_CODE,TRADE_CODE,TRADE_NAME,CALC_DOSG_BY_FREQ_DURN_YN,IV_INGREDIENT_YN,IV_FLUID_YN,  INFUSE_OVER_VALUE,INFUSE_OVER_DURN_TYPE,FRACT_DOSE_ROUND_UP_YN,CONTENT_IN_PRES_BASE_UOM,PRN_DOSES_PRES_PRD_FILL,STOCK_UOM,STOCK_UOM_DESC,CALC_DEF_DOSAGE_YN,PT_COUN_REQD_YN,FRACT_DOSE_APPL_YN, WEIGHT_REC_APPL_AGE_GROUP,BILLABLE_ITEM_YN BILLABLE_ITEM_YN,DEFAULT_DOSAGE_BY,DRUG_INDICATION, DEFAULT_ROUTE_YN,B.ROUTE_COLOR,DEFAULT_DOSAGE_BY_YN, DISP_ALT_FORM_YN, DRUG_SEARCH_BY,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ? AND pr_diag.curr_status != 'E' AND pr_diag.curr_encounter_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = PH_DRUG_VW.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN  FROM PH_DRUG_VW_LANG_VW PH_DRUG_VW,ph_route_lang_vw b WHERE DRUG_CODE=? AND NVL(trade_code,'X') = DECODE(?,NULL,NVL (trade_code, 'X'),?) AND LANG1 = ?  and PH_DRUG_VW.ROUTE_CODE=B.ROUTE_CODE  and PH_DRUG_VW.LANG1=B.LANGUAGE_ID ");
			//NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N','Y' )) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = PH_DRUG_VW.drug_code and ph_elig.eff_status = 'E'),'Y') DIAGNOSIS_FOUND_YN
			pstmt_pres_select2A		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT2A"));
			pstmt_pres_select10C		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10C"));
			pstmt_pres_select3A		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT3A"));
			pstmt_pres_select4A			= connection.prepareStatement("select count(*) from (SELECT   a.adv_reac_code allergy_type_code, b.long_desc allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a,  am_reaction_lang_vw b,pr_allergy_sensitivity C, PH_DRUG d, pr_adverse_event adr  WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type in( "+strAD_DA+")  AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code  AND a.patient_id = ? AND b.reaction_code(+) = a.adv_reac_code  AND b.language_id(+) =? and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO AND C.STATUS = 'A' AND( (adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) union ALL SELECT adv_reac_code allergy_type_code, OTHERS_REACTION allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a ,pr_allergy_sensitivity C , PH_DRUG d, pr_adverse_event adr WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type ='DA' AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code AND a.patient_id = ?  AND a.adv_reac_code  ='Oth'and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO and adr.ALLERGY_ALERT_BY <> 'A' AND C.STATUS = 'A' AND ((adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) )");// Changed for RUT-CRF-0065.1 [IN:43255]
			pstmt_pres_select5A		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT5A"));
			pstmt_pres_select6A		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT6A"));
			pstmt_pres_select7A		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7A"));
			pstmt_pres_select8A				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT8A"));
			pstmt_pres_select9A		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT9A"));
			pstmt_pres_select14A				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT14A"));
//			pstmt_pres_select13C			= 	connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13C"));
			pstmt_pres_select13C	= 	connection.prepareStatement("SELECT  COUNT(ROWID) FROM  PH_PATIENT_DRUG_PROFILE A WHERE   PATIENT_ID =? AND (TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE AND  END_DATE OR TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE AND  END_DATE OR  START_DATE BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND  TO_DATE(?,'DD/MM/YYYY HH24:MI') OR  END_DATE BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND  TO_DATE(?,'DD/MM/YYYY HH24:MI'))  AND DISCONT_DATE_TIME IS NULL AND ON_HOLD_DATE_TIME IS NULL AND  CANCEL_YN='N' AND   STOP_YN='N' AND GENERIC_ID=?");// Changed for ML-BRU-SCF-0811 [IN:039394] 
			pstmt_onco_reg_select1		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_DRUG_SELECT1"));
			pstmt_amend_IV_select2		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES_SELECT2"));
//			pstmt_route_select		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_DRUG_ROUTE_SELECT"));
			if(isSiteSpecific("OR", "OR_ORDER_SET")){ //ML-MMOH-CRF-1227.1
			sqlQueryorderSet        = "select a.route_code, b.route_desc,a.FREQ_CODE, a.DURN_VALUE, a.DURN_TYPE,b.route_color,a.dosage_type,a.qty_value,REQD_OR_OPT_IND from or_order_set_component a, ph_route_lang_vw b where a.order_set_code=? and order_catalog_code=? and a.route_code=b.route_code and a.ocurrance_num = ? and b.language_id=? and dosage_type is null UNION select a.route_code, b.route_desc,a.FREQ_CODE, a.DURN_VALUE, a.DURN_TYPE,b.route_color,a.dosage_type,a.qty_value, NULL from OR_ORDER_SET_COMP_BY_DSG_TYPE a, ph_route_lang_vw b where   a.order_set_code=? and a.order_catalog_code=? and a.route_code=b.route_code and DOSAGE_TYPE_SEQ_NO=? and a.ocurrance_num = ? and b.language_id=?" ;

			}else{ 
			//pstmt_route_select		= connection.prepareStatement("select a.route_code, b.route_desc,a.FREQ_CODE, a.DURN_VALUE, a.DURN_TYPE,b.route_color,a.dosage_type,a.qty_value from or_order_set_component a, ph_route_lang_vw b where a.order_set_code=? and order_catalog_code=? and a.route_code=b.route_code and a.ocurrance_num = ? and b.language_id=?");// b.route_color added for CRF RUT-CRF-0034.1[IN:037389] // a.dosage_type,a.qty_value Added for ML-MMOH-CRF-0345 [IN:057441] 
			sqlQueryorderSet        = "select a.route_code, b.route_desc,a.FREQ_CODE, a.DURN_VALUE, a.DURN_TYPE,b.route_color,a.dosage_type,a.qty_value,REQD_OR_OPT_IND from or_order_set_component a, ph_route_lang_vw b where a.order_set_code=? and order_catalog_code=? and a.route_code=b.route_code and a.ocurrance_num = ? and b.language_id=?";
			}
			//pstmt_route_select		= connection.prepareStatement("select a.route_code, b.route_desc,a.FREQ_CODE, a.DURN_VALUE, a.DURN_TYPE,b.route_color,a.dosage_type,a.qty_value from or_order_set_component a, ph_route_lang_vw b where a.order_set_code=? and order_catalog_code=? and a.route_code=b.route_code and a.ocurrance_num = ? and b.language_id=?");// b.route_color added for CRF RUT-CRF-0034.1[IN:037389] // a.dosage_type,a.qty_value Added for ML-MMOH-CRF-0345 [IN:057441] 
			pstmt_route_select		= connection.prepareStatement(sqlQueryorderSet);
			pstmt_age_value_select  = connection.prepareStatement("SELECT a.route_code, b.route_desc, a.freq_code, a.durn_value, a.durn_type, b.route_color, a.qty_value FROM or_order_set_comp_by_age_grp a, ph_route_lang_vw b, am_age_group c WHERE a.order_set_code = ? AND order_catalog_code = ? AND a.route_code = b.route_code AND a.ocurrance_num = ? AND b.language_id = ? AND a.age_group = c.age_group_code AND ((c.gender IS NULL) OR (UPPER (c.gender) = UPPER (?))) AND ? BETWEEN DECODE (c.age_unit, 'N', c.min_age, 'H', c.min_age * 60, 'D', c.min_age * 24 * 60, 'M', c.min_age * 30 * 24 * 60, 'Y', c.min_age * 365 * 24 * 60 ) AND DECODE (c.age_unit, 'N', c.max_age, 'H', c.max_age * 60, 'D', c.max_age * 24 * 60, 'M', c.max_age * 30 * 24 * 60, 'Y', c.max_age * 365 * 24 * 60 ) "); // Added for ML-MMOH-CRF-0345 [IN:057441] // AND ROWNUM = 1 removed and order_set_seq_num replaced with ocurrance_num for ML-MMOH-CRF-0987.1 [IN:066306]
			pstmt_age_value_select_all = connection.prepareStatement("SELECT a.route_code, b.route_desc, a.freq_code, a.durn_value, a.durn_type, b.route_color, a.qty_value FROM or_order_set_comp_by_age_grp a, ph_route_lang_vw b WHERE a.order_set_code = ? AND order_catalog_code = ? AND a.route_code = b.route_code AND a.ocurrance_num = ? AND b.language_id = ? AND a.age_group = '*A' "); // Added for ML-MMOH-CRF-0345 [IN:057441] // AND ROWNUM = 1 removed and order_set_seq_num replaced with ocurrance_num for ML-MMOH-CRF-0987.1 [IN:066306]
			pstmt_age_value_select_default =connection.prepareStatement("SELECT dosage_type FROM or_order_set_component WHERE order_set_code = ? AND order_catalog_code = ? AND ocurrance_num = ?"); // Added for ML-MMOH-CRF-0345 [IN:057441]
			for(int i=0; i<drugCodes.size(); i++) {
				found	=	false;
				eqvlValues = new HashMap();
				String drugCode = (String)drugCodes.get(i);
				String ocurrance_num = (String)drugCodes.get(++i);
				dosage_type_seq_no = "";
				for(int dupChk=0; dupChk<drugDetails.size(); dupChk++) {
					tmp_hash	=	(HashMap)drugDetails.get(dupChk);
					if(tmp_hash != null && tmp_hash.size()>0){
						tmp_code			=	checkForNull((String)tmp_hash.get("DRUG_CODE"));
						tmp_ocurrance_num	=	checkForNull((String)tmp_hash.get("OCURRANCE_NUM"));
						if(tmp_code.equals(drugCode) && tmp_ocurrance_num.equals(ocurrance_num)){
							found	=	true;
							break;
						}
					}
				}
				i++; //added for ML-MMOH-CRF-1227.1
				if(found)
					continue;

			  dosage_type_seq_no = (String)drugCodes.get(i);//added for ML-MMOH-CRF-1227.1
				srlNo++;


				String comp_freq_code = drugCode+"_freq_code";
				String comp_durn_value = drugCode+"_durn_value";
				String comp_durn_type = drugCode+"_durn_type";
				if(drugCode!=null && !drugCode.equals("")){
					comp_freq_code	=	(String)hashMapFreq.get(comp_freq_code);
					comp_durn_value	=   (String)hashMapDurn_value.get(comp_durn_value);
					comp_durn_type	=   (String)hashMapDurn_type.get(comp_durn_type);
				}
				durn_value				 = "";      
				durn_type				 = "";      
				freq_code				 = "";      
				repeat_durn_type			 = "";      
				schedule_yn				 = "";      
				calc_dosg_by_freq_durn_yn = "";      
				strength_value			 = "";      
				qty_value				 = "";      
				qty_desc_code			 = "";      
				pres_base_uom			 = "";      
				strength_uom				 = "";      
				dosage_type				 = "";      
				repeat_value				 = "1";//Modified for IN:070451  canged value from o to 1   
				order_type_code			 = "";      
				generic_id				 = "";      
				flag1                     = "N";  
				or_dosage_type			 = ""; //ML-MMOH-CRF-1227.1

				HashMap DrugDetails			= new HashMap();
				resultSet	= null;
				pstmt_pres_select1A.setString(1, drugCode);
				pstmt_pres_select1A.setString(2, login_facility_id);
				pstmt_pres_select1A.setString(3, patient_id);
				pstmt_pres_select1A.setString(4, getEncId());
				System.out.println("2139 getEncId()"+getEncId());
				
				pstmt_pres_select1A.setString(5, drugCode);
				pstmt_pres_select1A.setString(6, "");
				pstmt_pres_select1A.setString(7, "");
				pstmt_pres_select1A.setString(8, getLanguageId());	
				resultSet	= pstmt_pres_select1A.executeQuery();

				if(resultSet.next()) {
					DrugDetails.put("SRL_NO",srlNo+"");
					DrugDetails.put("OCURRANCE_NUM",ocurrance_num);
					DrugDetails.put("AMEND_YN", "N");
					DrugDetails.put("rowVal",srlNo+"");
					DrugDetails.put("comp_freq_code", comp_freq_code);
					DrugDetails.put("comp_durn_value", comp_durn_value);
					DrugDetails.put("comp_durn_type", comp_durn_type);					
					String stage		= (hash.get("stage").toString()==null ? "":hash.get("stage").toString());
					DrugDetails.put("stage", stage);
					String intention	= (hash.get("intention").toString()==null ? "":hash.get("intention").toString());
					DrugDetails.put("intention", intention);
					String regimen_code	= (hash.get("regimen").toString()==null ? "":hash.get("regimen").toString());
					DrugDetails.put("regimen_code", regimen_code);
					String dose			= (hash.get("dose").toString()==null ? "":hash.get("dose").toString());
					DrugDetails.put("dose", dose);				
					DrugDetails.put("DISP_ALT_FORM_YN",resultSet.getString("DISP_ALT_FORM_YN")==null?"N":resultSet.getString("DISP_ALT_FORM_YN"));//GHL-CRF-549 
					DrugDetails.put("DRUG_CODE", (resultSet.getString("DRUG_CODE")==null ? "":resultSet.getString("DRUG_CODE")));
					DrugDetails.put("ITEM_CODE", (resultSet.getString("ITEM_CODE")==null ? "":resultSet.getString("ITEM_CODE")));

					ext_prod_id	=	resultSet.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet.getString("EXTERNAL_PRODUCT_ID");
					fract_dose_appl_yn	=	resultSet.getString("FRACT_DOSE_APPL_YN")==null ? "":resultSet.getString("FRACT_DOSE_APPL_YN");
					strength_per_value_pres_uom	=	resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null ? "1":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM");
					DrugDetails.put("FRACT_DOSE_APPL_YN", fract_dose_appl_yn);
					DrugDetails.put("STRENGTH_PER_VALUE_PRES_UOM", strength_per_value_pres_uom);
					DrugDetails.put("EXTERNAL_PRODUCT_ID", ext_prod_id);
					DrugDetails.put("PATIENT_CLASS", patientClass);
					DrugDetails.put("DRUG_DESC",(resultSet.getString("DRUG_DESC")==null ? "":resultSet.getString("DRUG_DESC")));
					DrugDetails.put("STOCK_UOM",(resultSet.getString("STOCK_UOM")==null ? "":resultSet.getString("STOCK_UOM")));					
					DrugDetails.put("CONTENT_IN_PRES_BASE_UOM",(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null ? "":resultSet.getString("CONTENT_IN_PRES_BASE_UOM")));
					DrugDetails.put("IN_FORMULARY_YN",(resultSet.getString("IN_FORMULARY_YN")==null ? "N":resultSet.getString("IN_FORMULARY_YN")));
					DrugDetails.put("GENERIC_ID",(resultSet.getString("GENERIC_ID")==null ? "":resultSet.getString("GENERIC_ID")));
					generic_id = resultSet.getString("GENERIC_ID");
					DrugDetails.put("GENERIC_NAME",(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME")));
					DrugDetails.put("DRUG_CLASS",(resultSet.getString("DRUG_CLASS")==null ? "":resultSet.getString("DRUG_CLASS")));
					DrugDetails.put("FORM_CODE",(resultSet.getString("FORM_CODE")==null ? "":resultSet.getString("FORM_CODE")));
					form_code=DrugDetails.get("FORM_CODE").toString(); // RUT-CRF-0062 [IN029600]
					DrugDetails.put("FORM_DESC",(resultSet.getString("FORM_DESC")==null ? "":resultSet.getString("FORM_DESC")));
					DrugDetails.put("PRES_BASE_UOM",(resultSet.getString("PRES_BASE_UOM")==null ? "":resultSet.getString("PRES_BASE_UOM")));					
					DrugDetails.put("PRES_BASE_UOM_DESC",(resultSet.getString("PRES_BASE_UOM_DESC")==null ? "":resultSet.getString("PRES_BASE_UOM_DESC")));
					DrugDetails.put("ACT_STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE")));
					DrugDetails.put("STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE")));
					DrugDetails.put("STRENGTH_UOM",(resultSet.getString("STRENGTH_UOM")==null ? "":resultSet.getString("STRENGTH_UOM")));
					DrugDetails.put("STRENGTH_UOM_DESC",(resultSet.getString("STRENGTH_UOM_DESC")==null ? "":resultSet.getString("STRENGTH_UOM_DESC")));					
					DrugDetails.put("STRENGTH_PER_PRES_UOM",(resultSet.getString("STRENGTH_PER_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_PRES_UOM")));					
					DrugDetails.put("STRENGTH_PER_VALUE_PRES_UOM",(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")));
					DrugDetails.put("PRES_CATG_CODE",(resultSet.getString("PRES_CATG_CODE")==null ? "":resultSet.getString("PRES_CATG_CODE")));
					DrugDetails.put("TRADE_CODE",(resultSet.getString("TRADE_CODE")==null ? "":resultSet.getString("TRADE_CODE")));
					DrugDetails.put("TRADE_NAME",(resultSet.getString("TRADE_NAME")==null ? "":resultSet.getString("TRADE_NAME")));		
					DrugDetails.put("CALC_DOSG_BY_FREQ_DURN_YN",(resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")==null ? "":resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")));
					DrugDetails.put("IV_INGREDIENT_YN",(resultSet.getString("IV_INGREDIENT_YN")==null ? "N":resultSet.getString("IV_INGREDIENT_YN")));					
					DrugDetails.put("DRUG_INFUSE_OVER_VALUE",(resultSet.getString("INFUSE_OVER_VALUE")==null ? "":resultSet.getString("INFUSE_OVER_VALUE")));					
					DrugDetails.put("DRUG_INFUSE_OVER_DURN_TYPE",(resultSet.getString("INFUSE_OVER_DURN_TYPE")==null ? "":resultSet.getString("INFUSE_OVER_DURN_TYPE")));			
					DrugDetails.put("IV_FLUID_YN",(resultSet.getString("IV_FLUID_YN")==null ? "N":resultSet.getString("IV_FLUID_YN")));
					DrugDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")));
					DrugDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")));
					DrugDetails.put("DRUG_INDICATION",(resultSet.getString("DRUG_INDICATION")==null ? "":resultSet.getString("DRUG_INDICATION")));//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]
					DrugDetails.put("ROUTE_COLOR",(resultSet.getString("ROUTE_COLOR")==null ? "":resultSet.getString("ROUTE_COLOR")));// added for CRF RUT-CRF-0034.1[IN:037389]
					calc_dosg_by_freq_durn_yn = resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN");
					calc_dflt_dosage_by_htwt	= (resultSet.getString("CALC_DEF_DOSAGE_YN")==null ? "":resultSet.getString("CALC_DEF_DOSAGE_YN"));				
					strength_value			  = resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE");
					strength_value			  = strength_value.trim();
					pres_base_uom			  = resultSet.getString("PRES_BASE_UOM");
					strength_uom			  = resultSet.getString("STRENGTH_UOM");
					DrugDetails.put("DIAGNOSIS_FOUND_YN",resultSet.getString("DIAGNOSIS_FOUND_YN")==null ? "N":resultSet.getString("DIAGNOSIS_FOUND_YN") );
					System.out.println("2214 DIAGNOSIS_FOUND_YN"+resultSet.getString("DIAGNOSIS_FOUND_YN"));
				}
				closeResultSet( resultSet ) ;
				
				if(isSiteSpecific("OR", "OR_ORDER_SET")){ //ML-MMOH-CRF-1227.1 - start
					pstmt_route_select.setString(1,drugList);
					pstmt_route_select.setString(2,drugCode);
					pstmt_route_select.setString(3,ocurrance_num);
					pstmt_route_select.setString(4,getLanguageId());
					pstmt_route_select.setString(5,drugList);
					pstmt_route_select.setString(6,drugCode);
					pstmt_route_select.setString(7,dosage_type_seq_no);
					pstmt_route_select.setString(8,ocurrance_num);
					pstmt_route_select.setString(9,getLanguageId());
				}else{ //ML-MMOH-CRF-1227.1 - end
					pstmt_route_select.setString(1,drugList);
					pstmt_route_select.setString(2,drugCode);
					pstmt_route_select.setString(3,ocurrance_num);
					pstmt_route_select.setString(4,getLanguageId());
				}

				resultSet	= pstmt_route_select.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")));
					DrugDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")));
					DrugDetails.put("COMP_FREQ_CODE", (resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")));
					DrugDetails.put("COMP_DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")) );
					DrugDetails.put("COMP_DURN_TYPE",(resultSet.getString("DURN_TYPE")==null ? "":resultSet.getString("DURN_TYPE")));
					DrugDetails.put("ROUTE_COLOR",(resultSet.getString("route_color")==null ? "":resultSet.getString("route_color")));// added for CRF RUT-CRF-0034.1[IN:037389]
					DrugDetails.put("OR_DOSAGE_TYPE",(resultSet.getString("dosage_type")==null ? "":resultSet.getString("dosage_type"))); // added for ML-MMOH-CRF-0345 [IN:057441] 
                                        DrugDetails.put("OR_QTY_VALUE",(resultSet.getString("qty_value")==null ? "":resultSet.getString("qty_value"))); // added for ML-MMOH-CRF-0345 [IN:057441]
					DrugDetails.put("def_freq_code",(resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")));//ML-MMOH-CRF-1014 - start
						DrugDetails.put("def_durn_type",(resultSet.getString("DURN_TYPE")==null ? "":resultSet.getString("DURN_TYPE")));
						DrugDetails.put("def_durn_value",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")));//ML-MMOH-CRF-1014 - end
						
						DrugDetails.put("REQD_OR_OPT_IND",(resultSet.getString("REQD_OR_OPT_IND")==null ? "":resultSet.getString("REQD_OR_OPT_IND")));
						pstmt_pres_select6A.setString(1, (String)DrugDetails.get("COMP_FREQ_CODE"));
					
					
					pstmt_pres_select6A.setString(2, getLanguageId());
					resultSet	= pstmt_pres_select6A.executeQuery();

					if(resultSet!=null && resultSet.next()) {
						DrugDetails.put("REPEAT_VALUE",(resultSet.getString("REPEAT_VALUE")));
						DrugDetails.put("INTERVAL_VALUE",(resultSet.getString("INTERVAL_VALUE")));
						DrugDetails.put("FREQ_NATURE",(resultSet.getString("FREQ_NATURE")));
						DrugDetails.put("FREQ_VALUE",(resultSet.getString("FREQ_VALUE")));
						DrugDetails.put("FREQ_DESC",(resultSet.getString("FREQ_DESC")));
						DrugDetails.put("SCHEDULED_YN",(resultSet.getString("SCHEDULED_YN")));
						repeat_durn_type=resultSet.getString("REPEAT_DURN_TYPE");
						DrugDetails.put("REPEAT_DURN_TYPE",repeat_durn_type);
						//repeat_durn_type=resultSet.getString("REPEAT_DURN_TYPE");
						schedule_yn=resultSet.getString("SCHEDULED_YN");
						repeat_value=checkNullResult(resultSet.getString("REPEAT_VALUE"), "1");
					}

					closeResultSet( resultSet ) ;

					}	
			else{ // else part Added for ML-MMOH-CRF-0345 [IN:057441]  - Start
				boolean exists = false;
						if(getPatientDetails(patient_id, drugCode).size()>0){
					gender = (String) getPatientDetails(patient_id, drugCode).get("sex");
					if(gender.length()>0)
						gender = (gender.toUpperCase()).substring(0,1);
					age = (String) getPatientDetails(patient_id, drugCode).get("age");
					age = String.valueOf(Integer.valueOf(age)*60*24);
				}
					pstmt_age_value_select.setString(1, drugList);
					pstmt_age_value_select.setString(2, drugCode);
					pstmt_age_value_select.setString(3,ocurrance_num); // srlNo replaced with ocurrance_num for ML-MMOH-CRF-0987.1 [IN:066306]
				    pstmt_age_value_select.setString(4, language_id);
					pstmt_age_value_select.setString(5,gender);
					pstmt_age_value_select.setString(6,age );
					   
					resultSet = pstmt_age_value_select.executeQuery();
				
				if(resultSet!=null && resultSet.next()) {
					exists = true;
					DrugDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")));
					DrugDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")));
					DrugDetails.put("COMP_FREQ_CODE", (resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")));
					DrugDetails.put("COMP_DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")) );
					DrugDetails.put("COMP_DURN_TYPE",(resultSet.getString("DURN_TYPE")==null ? "":resultSet.getString("DURN_TYPE")));
					DrugDetails.put("ROUTE_COLOR",(resultSet.getString("route_color")==null ? "":resultSet.getString("route_color")));
					DrugDetails.put("OR_DOSAGE_TYPE","A");  
					DrugDetails.put("OR_QTY_VALUE",resultSet.getString("qty_value")==null ? "":resultSet.getString("QTY_VALUE"));
				}	
				else{
					pstmt_age_value_select_all.setString(1, drugList);
					pstmt_age_value_select_all.setString(2, drugCode);
					pstmt_age_value_select_all.setString(3, ocurrance_num); // srlNo replaced with ocurrance_num for ML-MMOH-CRF-0987.1 [IN:066306]
					pstmt_age_value_select_all.setString(4, language_id);
					resultSet = pstmt_age_value_select_all.executeQuery();
							if(resultSet!=null && resultSet.next()){
								 exists = true;
								 DrugDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")));
									DrugDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")));
									DrugDetails.put("COMP_FREQ_CODE", (resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")));
									DrugDetails.put("COMP_DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")) );
									DrugDetails.put("COMP_DURN_TYPE",(resultSet.getString("DURN_TYPE")==null ? "":resultSet.getString("DURN_TYPE")));
									DrugDetails.put("ROUTE_COLOR",(resultSet.getString("route_color")==null ? "":resultSet.getString("route_color")));// added for CRF RUT-CRF-0034.1[IN:037389]
									DrugDetails.put("OR_DOSAGE_TYPE","A");  
									DrugDetails.put("OR_QTY_VALUE",resultSet.getString("qty_value")==null ? "":resultSet.getString("QTY_VALUE"));
							} 
							else{
								pstmt_age_value_select_default.setString(1, drugList);
								pstmt_age_value_select_default.setString(2, drugCode);
								pstmt_age_value_select_default.setString(3, ocurrance_num);
								resultSet = pstmt_age_value_select_default.executeQuery();
								if(resultSet!=null && resultSet.next()){
									DrugDetails.put("OR_DOSAGE_TYPE",resultSet.getString("dosage_type")==null ? "":resultSet.getString("dosage_type"));
								}
							}
						closeResultSet( resultSet ) ;
					}
						if(exists){
						pstmt_pres_select6A.setString(1, (String)DrugDetails.get("COMP_FREQ_CODE"));
						pstmt_pres_select6A.setString(2, getLanguageId());
						resultSet	= pstmt_pres_select6A.executeQuery();

						if(resultSet!=null && resultSet.next()) {
							DrugDetails.put("REPEAT_VALUE",(resultSet.getString("REPEAT_VALUE")));
							DrugDetails.put("INTERVAL_VALUE",(resultSet.getString("INTERVAL_VALUE")));
							DrugDetails.put("FREQ_NATURE",(resultSet.getString("FREQ_NATURE")));
							DrugDetails.put("FREQ_VALUE",(resultSet.getString("FREQ_VALUE")));
							DrugDetails.put("FREQ_DESC",(resultSet.getString("FREQ_DESC")));
							DrugDetails.put("SCHEDULED_YN",(resultSet.getString("SCHEDULED_YN")));
							repeat_durn_type=resultSet.getString("REPEAT_DURN_TYPE");
							DrugDetails.put("REPEAT_DURN_TYPE",repeat_durn_type);
							//repeat_durn_type=resultSet.getString("REPEAT_DURN_TYPE");
							schedule_yn=resultSet.getString("SCHEDULED_YN");
							repeat_value=checkNullResult(resultSet.getString("REPEAT_VALUE"), "1");
						}
					  }
					
					closeResultSet( resultSet ) ;
				} // else part Added for ML-MMOH-CRF-0345 [IN:057441]  - End

				closeResultSet( resultSet ) ;
											 
				pstmt_pres_select2A.setString(1, drugCode);
				pstmt_pres_select2A.setString(2, getLanguageId());
				pstmt_pres_select2A.setString(3, getLanguageId());
				resultSet	= pstmt_pres_select2A.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("ORDER_CATALOG_CODE",(resultSet.getString("ORDER_CATALOG_CODE")==null ? "":resultSet.getString("ORDER_CATALOG_CODE")));
					DrugDetails.put("SHORT_DESC",(resultSet.getString("SHORT_DESC")==null ? "":resultSet.getString("SHORT_DESC")));
					DrugDetails.put("ORDER_TYPE_CODE",(resultSet.getString("ORDER_TYPE_CODE")==null ? "":resultSet.getString("ORDER_TYPE_CODE")));
					order_type_code = resultSet.getString("ORDER_TYPE_CODE");
					DrugDetails.put("SECURITY_LEVEL",(resultSet.getString("SECURITY_LEVEL")==null ? "":resultSet.getString("SECURITY_LEVEL")));
					DrugDetails.put("QTY_UOM",(resultSet.getString("QTY_UOM")==null ? "":resultSet.getString("QTY_UOM")));
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
				}

				closeResultSet( resultSet ) ;
				pstmt_pres_select10C.setString(1, order_type_code);
				pstmt_pres_select10C.setString(2, getLanguageId());
				resultSet	= pstmt_pres_select10C.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("ORDER_TYPE_DESC",resultSet.getString("SHORT_DESC"));
				}
				closeResultSet( resultSet ) ;

				//Code added for the CRF "PMG20089-CRF-0084"  Id:  3897 on 18-Sep-2008
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

				//logic added to change the logic to Authorize
				DrugDetails.put("ORD_AUTH_REQD_YN","");
				DrugDetails.put("ORD_SPL_APPR_REQD_YN","");
				DrugDetails.put("ORD_COSIGN_REQD_YN","");
				DrugDetails.put("ORD_AUTHORIZED_YN","" );
				DrugDetails.put("ORD_APPROVED_YN","");
				DrugDetails.put("ORD_COSIGNED_YN","");
				DrugDetails.put("ORD_AUTHORIZED_PREV_YN","");

				cstmt=connection.prepareCall("{call PH_ORDER_CATALOG_AUTH_RULE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				cstmt.setString( 1, drugCode);
				cstmt.setString( 2, (String)hash.get("patient_class"));
				cstmt.setString( 3, getLanguageId());
				cstmt.setString( 4, (String)hash.get("resp_id"));
				cstmt.setString( 5, (String)hash.get("pract_id"));
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
				pstmt_pres_select3A.setString(1, drugCode);
				pstmt_pres_select3A.setString(2, patientClass);
				pstmt_pres_select3A.setString(3, getLanguageId());
				resultSet	= pstmt_pres_select3A.executeQuery();
					
				if(resultSet!=null && resultSet.next()) {
					flag1="Y";
					DrugDetails.put("ACT_PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")));
					//DrugDetails.put("ORD_AUTH_REQD_YN",(resultSet.getString("ORD_AUTH_REQD_YN")==null ? "N":resultSet.getString("ORD_AUTH_REQD_YN")));
					//DrugDetails.put("ORD_SPL_APPR_REQD_YN",(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null ? "N":resultSet.getString("ORD_SPL_APPR_REQD_YN")));
					//DrugDetails.put("ORD_COSIGN_REQD_YN",(resultSet.getString("ORD_COSIGN_REQD_YN")==null ? "N":resultSet.getString("ORD_COSIGN_REQD_YN")));
					DrugDetails.put("ORD_AUTH_LEVEL",(resultSet.getString("ORD_AUTH_LEVEL")==null ? "":resultSet.getString("ORD_AUTH_LEVEL")));
					DrugDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")));
					freq_code= resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE");
					setFreq_code(freq_code);
					DrugDetails.put("FREQ_CODE",freq_code);
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
				else if( flag1.equals("N")){
					pstmt_pres_select3A.setString(1, drugCode);
					pstmt_pres_select3A.setString(2, "*A");
					pstmt_pres_select3A.setString(3, getLanguageId());
					resultSet	= pstmt_pres_select3A.executeQuery();
					if(resultSet!=null && resultSet.next()) {
						flag1="Y";
						DrugDetails.put("ACT_PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")));
						//DrugDetails.put("ORD_AUTH_REQD_YN",(resultSet.getString("ORD_AUTH_REQD_YN")==null ? "N":resultSet.getString("ORD_AUTH_REQD_YN")));
						//DrugDetails.put("ORD_SPL_APPR_REQD_YN",(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null ? "N":resultSet.getString("ORD_SPL_APPR_REQD_YN")));
						//DrugDetails.put("ORD_COSIGN_REQD_YN",(resultSet.getString("ORD_COSIGN_REQD_YN")==null ? "N":resultSet.getString("ORD_COSIGN_REQD_YN")));
						DrugDetails.put("ORD_AUTH_LEVEL",(resultSet.getString("ORD_AUTH_LEVEL")==null ? "":resultSet.getString("ORD_AUTH_LEVEL")));
						DrugDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")));
						freq_code= resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE");
						setFreq_code(freq_code);
						DrugDetails.put("FREQ_CODE",freq_code);
						//DrugDetails.put("FREQ_CODE",(resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")));
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

				}
					if(comp_freq_code == null){	
						DrugDetails.put("comp_freq_code",freq_code);
					}
					if(comp_durn_value == null){DrugDetails.put("comp_durn_value",durn_value);}
					if(comp_durn_type == null){	DrugDetails.put("comp_durn_type",durn_type);}
				closeResultSet( resultSet ) ;
				pstmt_pres_select4A.setString(1,drugCode);
				pstmt_pres_select4A.setString(2,getPatId());
				pstmt_pres_select4A.setString(3,getLanguageId());
				pstmt_pres_select4A.setString(4,drugCode);
				pstmt_pres_select4A.setString(5,getPatId());
				int rec_count	=0;
				resultSet		= pstmt_pres_select4A.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					rec_count=resultSet.getInt(1);
				}
				closeResultSet( resultSet ) ;
				if(rec_count>0) {
					DrugDetails.put("ALLERGY_YN","Y");
				}
				else {
					DrugDetails.put("ALLERGY_YN","N");
					//Code Added for	RUT-CRF-0065 IN 29603 - Start
					String ATC_allergy="0";
					if(!atc_allergy_alert_level.equals("N")){
						PreparedStatement pstmt1				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL_ALLERGY_CHECK"));
						pstmt1.setString(1,getPatId());
						pstmt1.setString(2,generic_id);
						pstmt1.setString(3,atc_allergy_alert_level);
						resultSet			= pstmt1.executeQuery();
						if(resultSet!=null && resultSet.next())
							ATC_allergy = resultSet.getString("ATC_CHECK_EXISTS");
						closeResultSet( resultSet ) ;
						closeStatement( pstmt1 ) ;
						if(ATC_allergy!=null && !ATC_allergy.equals("0")){
							DrugDetails.put("ALLERGY_YN","Y");
						}
						else
							DrugDetails.put("ALLERGY_YN","N");
					}
					//Code Added for	RUT-CRF-0065 IN 29603 - End
				}
				pstmt_pres_select5A.setString(1, start_date);
				pstmt_pres_select5A.setString(2, start_date);
				resultSet	= pstmt_pres_select5A.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					if(!getLanguageId().equals("en")){ //if condition and else block Added for RollForward from SRR - SRR20056-SCF-10519 [IN:057071]
						DrugDetails.put("FUTURE_DATE",com.ehis.util.DateUtils.convertDate((resultSet.getString("FUTURE_DATE")),"DMYHM",getLanguageId(),"en")); 
						DrugDetails.put("BACK_DATE",com.ehis.util.DateUtils.convertDate((resultSet.getString("BACK_DATE")),"DMYHM",getLanguageId(),"en"));
					}
					else{
						DrugDetails.put("FUTURE_DATE",(resultSet.getString("FUTURE_DATE")));
						DrugDetails.put("BACK_DATE",(resultSet.getString("BACK_DATE")));
					}
				}

				closeResultSet( resultSet ) ;
				pstmt_pres_select7A.setString(1, repeat_durn_type);
				pstmt_pres_select7A.setString(2, start_date);
				pstmt_pres_select7A.setString(3, durn_value);
				pstmt_pres_select7A.setString(4, repeat_durn_type);
				pstmt_pres_select7A.setString(5, start_date);
				pstmt_pres_select7A.setString(6, durn_value);
				pstmt_pres_select7A.setString(7, repeat_durn_type);
				pstmt_pres_select7A.setString(8, start_date);
				pstmt_pres_select7A.setString(9, durn_value);
				resultSet	= pstmt_pres_select7A.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					if(!getLanguageId().equals("en")){
						//DrugDetails.put("END_DATE",com.ehis.util.DateUtils.convertDate((resultSet.getString("END_DATE")),"DMYHM",getLanguageId(),"en")); //commented for RollForward from SRR - SRR20056-SCF-10519 [IN:057071]
						DrugDetails.put("END_DATE",resultSet.getString("END_DATE"));//added for for RollForward from SRR - SRR20056-SCF-10519 [IN:057071]
					}
					else{
						DrugDetails.put("END_DATE",com.ehis.util.DateUtils.convertDate((resultSet.getString("END_DATE")),"DMYHM",getLanguageId(),"en"));
					}
				}
				
				/*if(!getLanguageId().equals("en")){
					DrugDetails.put("START_DATE",com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",getLanguageId(),"en"));
				}
				else{*/ //commented for RollForward from SRR - SRR20056-SCF-10519 [IN:057071]
					DrugDetails.put("START_DATE",start_date);
				//}//commented for RollForward from SRR - SRR20056-SCF-10519 [IN:057071]

				closeResultSet( resultSet ) ;
				pstmt_pres_select8A.setString(1, durn_type);
				pstmt_pres_select8A.setString(2, getLanguageId());
				resultSet			= pstmt_pres_select8A.executeQuery();
				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("DURN_DESC",(resultSet.getString("DURN_DESC")));
					DrugDetails.put("OR_DURN_DESC",(resultSet.getString("DURN_DESC")));
				}

				if(calc_dosg_by_freq_durn_yn==null || calc_dosg_by_freq_durn_yn.equals("N")) {
					DrugDetails.put("DOSAGE_TYPE","A");
					DrugDetails.put("ORI_DOSAGE_TYPE","A");
					dosage_type="A";
				}
				else {
					if(strength_value.equals("0")|| fract_dose_appl_yn.equals("N")) {
						DrugDetails.put("DOSAGE_TYPE","Q");
						DrugDetails.put("ORI_DOSAGE_TYPE","Q");
						dosage_type="Q";
					}
					else {
						DrugDetails.put("DOSAGE_TYPE","S");
						DrugDetails.put("ORI_DOSAGE_TYPE","S");
						dosage_type="S";
					}
				}

				String proc_qty_value="";

				if( calc_dosg_by_freq_durn_yn.equals("N")) {
					if(!DrugDetails.containsKey("QTY_VALUE")) {
						DrugDetails.put("QTY_VALUE",qty_value);
						DrugDetails.put("QTY_DESC_CODE",form_code);
						qty_desc_code=form_code;
						proc_qty_value=qty_value;
					}
				}
				else if(strength_value==null || strength_value.equals("0") || strength_value.equals("") ||  fract_dose_appl_yn.equals("N")){
					if(!DrugDetails.containsKey("QTY_VALUE")) {
						DrugDetails.put("QTY_VALUE",qty_value);
						DrugDetails.put("QTY_DESC_CODE",pres_base_uom);					
						qty_desc_code=pres_base_uom;
						proc_qty_value=qty_value;
					}
				}
				else {
					if(!DrugDetails.containsKey("QTY_VALUE")) {
						String strength_val= (Double.parseDouble(strength_value) * Double.parseDouble(qty_value))/Double.parseDouble(strength_per_value_pres_uom)+"";
						DecimalFormat dfTest = new DecimalFormat("##.####");
						strength_val = dfTest.format(Double.parseDouble(strength_val));
						DrugDetails.put("QTY_VALUE",strength_val);
						DrugDetails.put("QTY_DESC_CODE",strength_uom);
						proc_qty_value=strength_val;
						qty_desc_code=strength_uom;
					}
				}

				closeResultSet( resultSet ) ;
				pstmt_pres_select9A.setString(1, qty_desc_code);
				pstmt_pres_select9A.setString(2, getLanguageId());
				resultSet	= pstmt_pres_select9A.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("QTY_DESC",(resultSet.getString("SHORT_DESC")));
					DrugDetails.put("OR_QTY_DESC",(resultSet.getString("SHORT_DESC")));
				}

				closeResultSet( resultSet ) ;
				pstmt_pres_select14A.setString(1, login_facility_id);
				resultSet			= pstmt_pres_select14A.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("REFILL_YN",(resultSet.getString("REFILL_YN")==null ? "N":resultSet.getString("REFILL_YN")));
					DrugDetails.put("MAX_REFILLS_FOR_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_REFILLS_FOR_PRES")));
					DrugDetails.put("MAX_DURN_FOR_REFILL_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_DURN_FOR_REFILL_PRES")));
				}
				closeResultSet( resultSet ) ;

			/* To get Recommonded dose details --------*/
				HashMap pat_dtls	=	getPatientDetails(patient_id,drugCode);
				age_group			=	(String)pat_dtls.get("age_group");
				String factor; //Added for IN:070451
				String calc_by_ind =""; //Added for IN:070451

				DrugDetails.put("RECOMM_YN","N");
				DrugDetails.put("CALC_BY_IND","");
				DrugDetails.put("DOSAGE_STD","");
				DrugDetails.put("DOSAGE_UNIT","");
				DrugDetails.put("RECOMM_DOSAGE_BY","");
				if(calc_dflt_dosage_by_htwt.trim().equals("Y") && !age_group.equals("")) {
			
					String sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT81");
					pstmt				= connection.prepareStatement(sql_query) ;
					pstmt.setString(1,drugCode);
					pstmt.setString(2,age_group);
					resultSet1			= pstmt.executeQuery();

					if(resultSet1!=null && resultSet1.next()) {
									
						DrugDetails.put("RECOMM_YN","Y");
						DrugDetails.put("CALC_BY_IND",(resultSet1.getString("CALC_BY_IND")));
						DrugDetails.put("DOSAGE_STD",(resultSet1.getString("DOSAGE_STD")));
						DrugDetails.put("DOSAGE_UNIT",(resultSet1.getString("DOSAGE_UNIT")));
						DrugDetails.put("RECOMM_DOSAGE_BY",(resultSet1.getString("LIMIT_IND")));
						calc_by_ind =resultSet1.getString("CALC_BY_IND");//Added for IN:070451
					} 
					try{
						closeResultSet( resultSet1 ) ;
						closeStatement( pstmt ) ;
					}catch(Exception es){
						es.printStackTrace() ;
					}
				
				}
				proc_qty_value="";

				if(dosage_type.equals("Q")) {
					proc_qty_value=qty_value;
				}
				else if(dosage_type.equals("S")) {
					proc_qty_value=strength_value;
				}
				//Added for IN:070451 start
				if(calc_by_ind.equalsIgnoreCase("W")){
					 factor =weight;
				}
				else if(calc_by_ind.equalsIgnoreCase("B")){
					 factor =bsa;
					 System.out.println("bsa"+bsa);
				}
				else
					factor="1";
				if(order_type_flag.equals("Existing")){
				try{
					
					pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_RPEAT_VALUE_SELECT")) ;
					pstmt.setString(1,order_id);
					resultSet	= pstmt.executeQuery();
					if ( resultSet != null && resultSet.next() ) {
						repeat_value=resultSet.getString("repeat_value");
						proc_qty_value=resultSet.getString("qty_value");
						dosage_type=resultSet.getString("dosage_type");
						proc_qty_value=(Double.parseDouble(proc_qty_value))/(Double.parseDouble(factor))+"";

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally{
					try {
						closeResultSet(resultSet);
						closeStatement(pstmt);
						
					}
					catch(Exception es){
						es.printStackTrace() ;
					}
				}
				}
				//Added for IN:070451 end	
				cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//Modified for IN:070451 added 5 parameter
				cstmt.setString( 1, drugCode);
				cstmt.setString( 2, getPatId());
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
				DrugDetails.put("LIMIT_IND",checkForNull(limit_ind)); // checkForNull Added for ML-MMOH-CRF-1225

				DrugDetails.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );//Modified for IN:070451 default value changed from zero to empty
				DrugDetails.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );//Modified for IN:070451 default value changed from zero to empty
				DrugDetails.put("MONO_GRAPH","");
				DrugDetails.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );//Modified for IN:070451 default value changed from zero to empty
				DrugDetails.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );//Modified for IN:070451 default value changed from zero to empty
				DrugDetails.put("DOSAGE_UNIT",(cstmt.getString(12)==null ? "":cstmt.getString(12)) );
				//Added for IN:070451 start
				DrugDetails.put("max_daily_ceeling_dose",(cstmt.getString(13)==null ? "":cstmt.getString(13)) );
				DrugDetails.put("min_daily_ceeling_dose",(cstmt.getString(14)==null ? "":cstmt.getString(14)) );
				DrugDetails.put("max_unit_ceeling_dose",(cstmt.getString(15)==null ? "":cstmt.getString(15)) );
				DrugDetails.put("min_unit_ceeling_dose",(cstmt.getString(16)==null ? "":cstmt.getString(16)) );
				//Added for IN:070451 end
				if(limit_ind!=null && limit_ind.equals("N")){
					daily_dose	= cstmt.getString( 6 );
					unit_dose	= cstmt.getString( 7 );
					mono_graph	= cstmt.getString( 9 );
					DrugDetails.put("MONO_GRAPH",(cstmt.getString(9)==null ? "":cstmt.getString(9)) );
				}

	/********************3/21/2005*****************************/
				int count_rx	= 0;
				pstmt_pres_select13C.setString(1, getPatId());
				pstmt_pres_select13C.setString(2, (String)DrugDetails.get("START_DATE"));// Changed for ML-BRU-SCF-0811 [IN:039394] 
				pstmt_pres_select13C.setString(3, (String)DrugDetails.get("END_DATE"));// Changed for ML-BRU-SCF-0811 [IN:039394] 
				pstmt_pres_select13C.setString(4, (String)DrugDetails.get("START_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394] 
				pstmt_pres_select13C.setString(5, (String)DrugDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394] 
				pstmt_pres_select13C.setString(6, (String)DrugDetails.get("START_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394] 
				pstmt_pres_select13C.setString(7, (String)DrugDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394] 
				pstmt_pres_select13C.setString(8, generic_id);
				resultSet			= pstmt_pres_select13C.executeQuery();
				if(resultSet!=null && resultSet.next()) {
					count_rx=resultSet.getInt(1);
				}
				if(count_rx>0) {
					DrugDetails.put("CURRENT_RX","Y");
				}
				else {
					DrugDetails.put("CURRENT_RX","N");
				}
		
				for(int crnt_rx = 0;crnt_rx<drugDetails.size();crnt_rx++){
					crntRxDrugDetails = (HashMap)drugDetails.get(crnt_rx);
					if(crntRxDrugDetails != null && crntRxDrugDetails.size()>0){
						exst_generic_id	  = (String)crntRxDrugDetails.get("GENERIC_ID")==null?"":(String)crntRxDrugDetails.get("GENERIC_ID");
						if(exst_generic_id.equals(generic_id)){
							DrugDetails.put("CURRENT_RX","Y");
						}
					}
				}
				//calucalte total_qty

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
				else if(dosage_type.equals("Q")) {
					float total_qty=0.0f;
					if((qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals(""))) ) {
						total_qty=Float.parseFloat(qty_value)*Integer.parseInt(durn_value)*Integer.parseInt(repeat_value);
					}
					//get the conversion factor
					if(strength_value==null || strength_value.equals("0") || strength_value.equals("")) {
						DrugDetails.put("TOT_STRENGTH","0");
						DrugDetails.put("TOT_STRENGTH_UOM","");
						
					}
					else {
						float tot_strength=0.0f;
				
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
				else if(dosage_type.equals("S")) {
					float total_qty=0.0f;
					if((qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals(""))) ) {
						total_qty=Float.parseFloat(qty_value)*Integer.parseInt(durn_value)*Integer.parseInt(repeat_value);
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

				if((!dosage_type.equals("A")) &&  schedule_yn.equals("Y")) {
					DrugDetails.put("SCH_OVER_YN","Y");
				}
				else {
					DrugDetails.put("SCH_OVER_YN","N");
				}

				float total_qty_value=0;
				if ( ( qty_value!=null && !qty_value.equals("")) && (repeat_value!=null && !repeat_value.equals("")) && (durn_value!=null && !durn_value.equals(""))){
					float ext_qty=Float.parseFloat(qty_value);
					int ext_repeat_value=Integer.parseInt(repeat_value);
					int ext_durn=Integer.parseInt(durn_value);

					total_qty_value=ext_qty*ext_repeat_value*ext_durn;
				}

				DrugDetails.put("TOTAL_QTY_VALUE",""+total_qty_value);

/*fetching eqvl conversion factor for G, mg, mcg, ncg against pres_base_uom*/ 
				String temeqvl = "";
				ArrayList tempDoseUoms = getDoseUom();
				for(int k = 0; k < tempDoseUoms.size(); k++){
					if(((String)tempDoseUoms.get(k)).equals((String)DrugDetails.get("PRES_QTY_UOM"))){
						eqvlValues.put((String)tempDoseUoms.get(k), "1");
					}
					else{
						temeqvl = getConvFactor((String)tempDoseUoms.get(k),(String)DrugDetails.get("PRES_QTY_UOM"));
						eqvlValues.put((String)tempDoseUoms.get(k), temeqvl==null?"":temeqvl);
					}
				}
				DrugDetails.put("EQVL_VALUES",eqvlValues);

				resultSet	= null;
				pstmt_onco_reg_select1.setString(1,((String)DrugDetails.get("DRUG_CODE")));
				pstmt_onco_reg_select1.setString(2, getLanguageId());
				resultSet	= pstmt_onco_reg_select1.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("DEFLT_FLUID_CODE",(resultSet.getString("DRUG_CODE")));
					DrugDetails.put("DEFLT_FLUID_ITEMCODE",(resultSet.getString("ITEM_CODE")));
					DrugDetails.put("DEFLT_FLUID_DESC",(resultSet.getString("DRUG_DESC")));
					DrugDetails.put("DEFLT_FLUID_FORM_CODE",(resultSet.getString("FORM_CODE")));
					DrugDetails.put("DEFLT_FLUID_ROUTE_CODE",(resultSet.getString("ROUTE_CODE")));
					DrugDetails.put("DEFLT_FLUID_PRES_BASE_UOM",(resultSet.getString("PRES_BASE_UOM")));
				}

				closeResultSet( resultSet ) ;
				pstmt_amend_IV_select2.setString(1,((String)DrugDetails.get("DRUG_CODE")));
				resultSet	= pstmt_amend_IV_select2.executeQuery();

				if(resultSet!=null && resultSet.next()) {	
					DrugDetails.put("FRACT_DOSE_ROUND_UP_YN",(resultSet.getString("fract_dose_round_up_yn")));
				}

			/*	if(ext_db_interface_yn.equals("Y")){
					if(ext_prod_id.equals("")){
						call_external_checks =false;
					}
					else{
						 call_external_checks =true;
					}

				}
				else{
					call_external_checks =false;  
				} */

//				if(ext_db_interface_yn.equals("Y") && !ext_prod_id.equals("")){
				if(ext_db_interface_yn.equals("Y")){
					call_external_checks =true;
				}else{
					call_external_checks =false;  
				} 
		/*
			   PERFORM_EXTERNAL_DATABASE_CHECKS   will indicate whether  module should perform External checks(FDB)or module checks
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
					 
				DrugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON","");
				DrugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON","");
				DrugDetails.put("EXTERNAL_INTERACTION_OVERRIDE_REASON","");
				DrugDetails.put("EXTERNAL_CONTRA_OVERRIDE_REASON","");
				DrugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON","");

				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN","N");
				DrugDetails.put("DRUG_DB_PRODUCT_ID","");

				DrugDetails.put("freq_chng_durn_desc",repeat_durn_type);
				DrugDetails.put("PROCESS_YN","N");
		//ends here   
		// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- begin
			if(act_pat_class.toUpperCase().equals("IP") && (take_home_medication.toUpperCase().equals("Y")||take_home_medication.toUpperCase().equals("D")))
				act_pat_class="DM";
				String Build_MAR_Rule=getMARDefaulting(act_pat_class,source_code,form_code,priority);
				DrugDetails.put("BUILD_MAR_RULE",Build_MAR_Rule);
				if(Build_MAR_Rule.equals("CE")||Build_MAR_Rule.equals("CD"))
					DrugDetails.put("buildMAR_yn","Y");
				else
					DrugDetails.put("buildMAR_yn","N");
			// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- End
				drugDetails.add(DrugDetails);
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt_pres_select1A);
				closeStatement(pstmt_pres_select2A);			
				closeStatement(pstmt_pres_select10C);			 
				closeStatement(pstmt_pres_select3A);			
				closeStatement(pstmt_pres_select4A);			 
				closeStatement(pstmt_pres_select5A);			 
				closeStatement(pstmt_pres_select6A);			
				closeStatement(pstmt_pres_select7A);			
				closeStatement(pstmt_pres_select8A);			
				closeStatement(pstmt_pres_select9A);			
				closeStatement(pstmt_pres_select14A);			 
				closeStatement(pstmt_pres_select13C);			 
				closeStatement(pstmt_onco_reg_select1);		 
				closeStatement(pstmt_amend_IV_select2);		
				closeStatement(cstmt);
				closeStatement(pstmt_age_value_select); // Added for ML-MMOH-CRF-0345 [IN:057441] 
				closeStatement(pstmt_age_value_select_all); // Added for ML-MMOH-CRF-0345 [IN:057441]
				closeStatement(pstmt_age_value_select_default); // Added for ML-MMOH-CRF-0345 [IN:057441]
				closeConnection(connection);
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
	}

	// Added for Order Set
	private void setComponentDrugCodes(String drugList, String order_type_flag) {

		Connection connection			 = null;
		PreparedStatement pstmt			 = null;
		ResultSet resultSet				 = null;
		String order_catalog_code 		 = "";
		String ocurrance_num 		 = "";
		String freq_code			     = "", durn_value = "";
		String durn_type			     = "";
		String age                       = ""; // Added for ML-MMOH-CRF-0987.1 [IN:066306]
		String gender                    = ""; // Added for ML-MMOH-CRF-0987.1 [IN:066306]
		String dosage_type_seq_no		 = ""; //added for ML-MMOH-CRF-1227.1
		try{
			connection	= getConnection();
			if(!order_type_flag.equals("Existing")){
			/* if(isSiteSpecific("OR", "OR_ORDER_SET")) // if condition Added for ML-MMOH-CRF-0345 [IN:057441]  // commented for ML-MMOH-CRF-0987.1 [IN:066306]
				pstmt		= connection.prepareStatement("SELECT a.order_catalog_code order_catalog_code,a.order_type_code order_type_code, a.reqd_or_opt_ind reqd_or_opt_ind,freq_code, a.qty_unit qty_unit,a.durn_value durn_value,a.durn_type durn_type, rel_start_date_time start_time,b.short_desc short_desc, a.ocurrance_num  FROM or_order_set_component a ,or_order_catalog_lang_vw b WHERE a.order_catalog_code = b.order_catalog_code  AND a.order_set_code = ? and b.order_category = 'PH' AND b.language_id = ? ORDER BY order_set_seq_num,a.ocurrance_num"); */
			if(isSiteSpecific("OR", "OR_ORDER_SET")){ // Added for ML-MMOH-CRF-0987.1 [IN:066306]  - Start
				
				if(getPatientDetails(patient_id, "").size()>0){
					gender = (String) getPatientDetails(patient_id, "").get("sex");
					if(gender.length()>0)
						gender = (gender.toUpperCase()).substring(0,1);
					age = (String) getPatientDetails(patient_id, "").get("age");
					age = String.valueOf(Integer.valueOf(age)*60*24);
				} 
				
				pstmt		= connection.prepareStatement("SELECT a.order_catalog_code order_catalog_code, a.order_set_code order_set_code, freq_code, a.durn_value durn_value, a.durn_type durn_type, rel_start_date_time start_time, b.short_desc short_desc, a.ocurrance_num,dosage_type_seq_no FROM or_order_set_comp_by_age_grp a, or_order_catalog_lang_vw b,am_age_group c WHERE a.order_catalog_code = b.order_catalog_code AND a.order_set_code = ? AND b.order_category = 'PH' AND b.language_id = ? AND a.age_group = c.age_group_code AND ((c.gender IS NULL) OR (UPPER (c.gender) = UPPER (?))) AND ? BETWEEN DECODE (c.age_unit, 'N', c.min_age, 'H', c.min_age * 60, 'D', c.min_age * 24 * 60, 'M', c.min_age * 30 * 24 * 60, 'Y', c.min_age * 365 * 24 * 60 ) AND DECODE (c.age_unit, 'N', c.max_age, 'H', c.max_age * 60, 'D', c.max_age * 24 * 60, 'M', c.max_age * 30 * 24 * 60, 'Y', c.max_age * 365 * 24 * 60 ) ORDER BY order_set_seq_num, a.ocurrance_num");
				
				pstmt.setString(1, drugList);
				pstmt.setString(2, getLanguageId());
				pstmt.setString(3, gender);
				pstmt.setString(4, age);
				resultSet	= pstmt.executeQuery();
				
			   if(resultSet==null || !resultSet.isBeforeFirst()){
				   pstmt		= connection.prepareStatement("(SELECT a.order_catalog_code order_catalog_code,freq_code, a.durn_value durn_value, a.durn_type durn_type, rel_start_date_time start_time, b.short_desc short_desc, a.ocurrance_num,a.order_set_seq_num,order_set_seq_num dosage_type_seq_no FROM or_order_set_component a, or_order_catalog_lang_vw b WHERE a.order_catalog_code = b.order_catalog_code AND a.order_set_code = ? AND b.order_category = 'PH' AND b.language_id = ? AND a.dosage_type is NULL /*NVL(a.dosage_type,'XX') <> 'A' */) UNION (SELECT a.order_catalog_code order_catalog_code, freq_code, a.durn_value durn_value, a.durn_type durn_type,rel_start_date_time start_time, b.short_desc short_desc, a.ocurrance_num, a.order_set_seq_num,dosage_type_seq_no FROM OR_ORDER_SET_COMP_BY_DSG_TYPE a, or_order_catalog_lang_vw b  WHERE a.order_catalog_code = b.order_catalog_code AND a.order_set_code = ? AND b.order_category = 'PH' AND b.language_id = ? AND NVL (a.dosage_type, 'XX') <> 'A') UNION (SELECT a.order_catalog_code order_catalog_code,freq_code, a.durn_value durn_value, a.durn_type durn_type, rel_start_date_time start_time, b.short_desc short_desc, a.ocurrance_num,a.order_set_seq_num,dosage_type_seq_no FROM or_order_set_comp_by_age_grp a, or_order_catalog_lang_vw b WHERE a.order_catalog_code = b.order_catalog_code AND a.order_set_code = ? AND b.order_category = 'PH' AND b.language_id = ? AND a.age_group = '*A') ORDER BY order_set_seq_num,dosage_type_seq_no,ocurrance_num");//a.dosage_type is NULL and union OR_ORDER_SET_COMP_BY_DSG_TYPE  added for ML-MMOH-CRF-1227.1 
				   pstmt.setString(1, drugList);
				   pstmt.setString(2, getLanguageId());
				   pstmt.setString(3, drugList);
				   pstmt.setString(4, getLanguageId());
   				   pstmt.setString(5, drugList);
				   pstmt.setString(6, getLanguageId());

				   resultSet	= pstmt.executeQuery();
			   }
			   else{
				   resultSet = null;
				   pstmt		= connection.prepareStatement("(SELECT a.order_catalog_code order_catalog_code,freq_code, a.durn_value durn_value, a.durn_type durn_type, rel_start_date_time start_time, b.short_desc short_desc, a.ocurrance_num,a.order_set_seq_num,order_set_seq_num dosage_type_seq_no FROM or_order_set_component a, or_order_catalog_lang_vw b WHERE a.order_catalog_code = b.order_catalog_code AND a.order_set_code = ? AND b.order_category = 'PH' AND b.language_id = ? AND a.dosage_type is NULL /*NVL(a.dosage_type,'XX') <> 'A' */) UNION (SELECT a.order_catalog_code order_catalog_code, freq_code, a.durn_value durn_value, a.durn_type durn_type,rel_start_date_time start_time, b.short_desc short_desc, a.ocurrance_num, a.order_set_seq_num,dosage_type_seq_no FROM OR_ORDER_SET_COMP_BY_DSG_TYPE a, or_order_catalog_lang_vw b  WHERE a.order_catalog_code = b.order_catalog_code AND a.order_set_code = ? AND b.order_category = 'PH' AND b.language_id = ? AND NVL (a.dosage_type, 'XX') <> 'A') UNION (SELECT a.order_catalog_code order_catalog_code,freq_code, a.durn_value durn_value, a.durn_type durn_type, rel_start_date_time start_time, b.short_desc short_desc, a.ocurrance_num,a.order_set_seq_num,dosage_type_seq_no FROM or_order_set_comp_by_age_grp a, or_order_catalog_lang_vw b, am_age_group c WHERE a.order_catalog_code = b.order_catalog_code AND a.order_set_code = ? AND b.order_category = 'PH' AND b.language_id = ? AND a.age_group = c.age_group_code AND ((c.gender IS NULL) OR (UPPER (c.gender) = UPPER (?))) AND ? BETWEEN DECODE (c.age_unit, 'N', c.min_age, 'H', c.min_age * 60, 'D', c.min_age * 24 * 60, 'M', c.min_age * 30 * 24 * 60, 'Y', c.min_age * 365 * 24 * 60 ) AND DECODE (c.age_unit, 'N', c.max_age, 'H', c.max_age * 60, 'D', c.max_age * 24 * 60, 'M', c.max_age * 30 * 24 * 60, 'Y', c.max_age * 365 * 24 * 60 )) ORDER BY order_set_seq_num,dosage_type_seq_no, ocurrance_num");//a.dosage_type is NULL added for ML-MMOH-CRF-1227.1
				   pstmt.setString(1, drugList);
				   pstmt.setString(2, getLanguageId());
				   pstmt.setString(3, drugList);
				   pstmt.setString(4, getLanguageId());
   				   pstmt.setString(5, drugList);
				   pstmt.setString(6, getLanguageId());
				   pstmt.setString(7, gender);
					pstmt.setString(8, age);

				   resultSet	= pstmt.executeQuery();
				   
			   }
		  }	 // Added for ML-MMOH-CRF-0987.1 [IN:066306]  - End
				
			else{
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_DRUG_SELECT"));
				//String sql ="SELECT a.order_catalog_code order_catalog_code,a.order_type_code order_type_code, a.reqd_or_opt_ind reqd_or_opt_ind,freq_code, a.qty_unit qty_unit,a.durn_value durn_value,a.durn_type durn_type, rel_start_date_time start_time,b.short_desc short_desc, a.ocurrance_num  FROM or_order_set_component a ,or_order_catalog_lang_vw b WHERE a.order_catalog_code = b.order_catalog_code  AND a.order_set_code = ? and b.order_category = 'PH' AND b.language_id = ? and a.ROUTE_CODE is not null ORDER BY order_set_seq_num";
				//pstmt		= connection.prepareStatement(sql);
				pstmt.setString(1, drugList);
				pstmt.setString(2, getLanguageId());
				resultSet	= pstmt.executeQuery();
			}
				while(resultSet!=null && resultSet.next()) {
					order_catalog_code = (resultSet.getString("order_catalog_code")==null ? "":resultSet.getString("order_catalog_code"));
					ocurrance_num = (resultSet.getString("OCURRANCE_NUM")==null ? "":resultSet.getString("OCURRANCE_NUM"));
					freq_code 		   = (resultSet.getString("freq_code")==null ? "":resultSet.getString("freq_code"));
					durn_type 		   = (resultSet.getString("durn_type")==null ? "":resultSet.getString("durn_type"));
					durn_value 		   = (resultSet.getString("durn_value")==null ? "":resultSet.getString("durn_value"));
					catalog_short_desc = (resultSet.getString("short_desc")==null ? "":resultSet.getString("short_desc"));
					dosage_type_seq_no = (resultSet.getString("DOSAGE_TYPE_SEQ_NO")==null ? "":resultSet.getString("DOSAGE_TYPE_SEQ_NO")); //ML-MMOH-CRF-1227.1
					setCatalogDesc(catalog_short_desc);

					drugCodes.add(order_catalog_code);
					drugCodes.add(ocurrance_num);
					drugCodes.add(dosage_type_seq_no); //ML-MMOH-CRF-1227.1

					hashMapFreq.put(order_catalog_code+"_freq_code", freq_code);
					hashMapDurn_value.put(order_catalog_code+"_durn_value", durn_value);
					hashMapDurn_type.put(order_catalog_code+"_durn_type", durn_type);
//System.out.println("@@@Oncology -setComponentDrugCodes---hashMapDurn_value= "+hashMapDurn_value+"----hashMapDurn_type----"+hashMapDurn_type);
				}

			}
			else{
				//String sql ="SELECT a.order_catalog_code order_catalog_code,a.order_type_code order_type_code, a.freq_code, a.qty_unit qty_unit,a.durn_value durn_value, a.durn_type durn_type, b.short_desc short_desc, a.ocurrance_num  FROM or_order_line a ,or_order_catalog_lang_vw b, or_order_set_component c WHERE a.order_catalog_code = b.order_catalog_code  AND a.ORDER_SET_ID = ? and b.order_category = 'PH' AND b.language_id = ? and c.ORDER_SET_CODE = (select order_catalog_code from or_order_line where order_id = ?) and a.OCURRANCE_NUM = c.OCURRANCE_NUM and a.ORDER_CATALOG_CODE = c.ORDER_CATALOG_CODE and a.ROUTE_CODE is not null ORDER BY a.order_id, a.order_line_num";
			   /* if(isSiteSpecific("OR", "OR_ORDER_SET")) // if condition Added for ML-MMOH-CRF-0345 [IN:057441]
					pstmt   =	connection.prepareStatement("SELECT a.order_catalog_code order_catalog_code, a.order_type_code order_type_code, a.freq_code, a.qty_unit qty_unit, a.durn_value durn_value, a.durn_type durn_type, b.short_desc short_desc, a.ocurrance_num FROM or_order_line a, or_order_catalog_lang_vw b, or_order_set_component c WHERE a.order_catalog_code = b.order_catalog_code AND a.order_set_id = ? AND b.order_category = 'PH' AND b.language_id = ? AND c.order_set_code = (SELECT order_catalog_code FROM or_order_line WHERE order_id = ?) AND a.ocurrance_num = c.ocurrance_num AND a.order_catalog_code = c.order_catalog_code ORDER BY a.order_id, a.order_line_num");*/ // commented for ML-MMOH-CRF-0987.1 [IN:066306]  
				if(isSiteSpecific("OR", "OR_ORDER_SET")){ // Added for for ML-MMOH-CRF-0987.1 [IN:066306] - Start
					pstmt   =	connection.prepareStatement("(SELECT a.order_catalog_code order_catalog_code, a.order_type_code order_type_code, a.freq_code, a.qty_unit qty_unit, a.durn_value durn_value, a.durn_type durn_type, b.short_desc short_desc, a.ocurrance_num,a.order_id,a.order_line_num FROM or_order_line a, or_order_catalog_lang_vw b, or_order_set_comp_by_age_grp c WHERE a.order_catalog_code = b.order_catalog_code AND a.order_set_id = ? AND b.order_category = 'PH' AND b.language_id = ? AND c.order_set_code = (SELECT order_catalog_code FROM or_order_line WHERE order_id = ?) /*AND a.ocurrance_num = c.ocurrance_num*/ AND a.order_catalog_code = c.order_catalog_code) UNION (SELECT a.order_catalog_code order_catalog_code, a.order_type_code order_type_code, a.freq_code, a.qty_unit qty_unit, a.durn_value durn_value, a.durn_type durn_type, b.short_desc short_desc, a.ocurrance_num,a.order_id,a.order_line_num FROM or_order_line a, or_order_catalog_lang_vw b, or_order_set_component c WHERE a.order_catalog_code = b.order_catalog_code AND a.order_set_id = ? AND b.order_category = 'PH' AND b.language_id = ? AND c.order_set_code = (SELECT order_catalog_code FROM or_order_line WHERE order_id = ?) /*AND a.ocurrance_num = c.ocurrance_num */ AND a.order_catalog_code = c.order_catalog_code AND DOSAGE_TYPE IS NULL AND  NVL(c.dosage_type,'XX') <> 'A') UNION (SELECT a.order_catalog_code order_catalog_code, a.order_type_code order_type_code, a.freq_code, a.qty_unit qty_unit,        a.durn_value durn_value, a.durn_type durn_type, b.short_desc short_desc, a.ocurrance_num, a.order_id, a.order_line_num FROM or_order_line a, or_order_catalog_lang_vw b, or_order_set_comp_by_dsg_type c WHERE a.order_catalog_code = b.order_catalog_code AND a.order_set_id = ? AND b.order_category = 'PH' AND b.language_id = ? AND c.order_set_code = (SELECT order_catalog_code  FROM or_order_line WHERE order_id = ?) /*AND a.ocurrance_num = c.ocurrance_num */ AND a.order_catalog_code = c.order_catalog_code AND NVL (c.dosage_type, 'XX') <> 'A') ORDER BY order_id, order_line_num");
					//In query union added for ML-MMOH-CRF-1227.1
					pstmt.setString(1, drugList);
					pstmt.setString(2, getLanguageId());
					pstmt.setString(3, drugList);
					pstmt.setString(4, drugList);
					pstmt.setString(5, getLanguageId());
					pstmt.setString(6, drugList);
					pstmt.setString(7, drugList); //ML-MMOH-CRF-1227.1
					pstmt.setString(8, getLanguageId());//ML-MMOH-CRF-1227.1
					pstmt.setString(9, drugList);//ML-MMOH-CRF-1227.1
					resultSet	= pstmt.executeQuery();
						
				} // Added for for ML-MMOH-CRF-0987.1 [IN:066306] - End
				else{
					pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_DRUG_SELECT"));
				pstmt.setString(1, drugList);
				pstmt.setString(2, getLanguageId());
				pstmt.setString(3, drugList);

				resultSet	= pstmt.executeQuery();
				}

				while(resultSet!=null && resultSet.next()) {
					order_catalog_code = (resultSet.getString("order_catalog_code")==null ? "":resultSet.getString("order_catalog_code"));
					ocurrance_num = (resultSet.getString("OCURRANCE_NUM")==null ? "":resultSet.getString("OCURRANCE_NUM"));
					freq_code 		   = (resultSet.getString("freq_code")==null ? "":resultSet.getString("freq_code"));
					durn_type 		   = (resultSet.getString("durn_type")==null ? "":resultSet.getString("durn_type"));
					durn_value 		   = (resultSet.getString("durn_value")==null ? "":resultSet.getString("durn_value"));
					catalog_short_desc = (resultSet.getString("short_desc")==null ? "":resultSet.getString("short_desc"));
					setCatalogDesc(catalog_short_desc);

					drugCodes.add(order_catalog_code);
					drugCodes.add(ocurrance_num);
					drugCodes.add(ocurrance_num); //added for ML-MMOH-CRF-1227.1

					hashMapFreq.put(order_catalog_code+"_freq_code", freq_code);
					hashMapDurn_value.put(order_catalog_code+"_durn_value", durn_value);
					hashMapDurn_type.put(order_catalog_code+"_durn_type", durn_type);
//System.out.println("@@@Oncology -setComponentDrugCodes-existing--hashMapDurn_value= "+hashMapDurn_value+"----hashMapDurn_type----"+hashMapDurn_type);
				}

			}
		
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		finally{
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
	}

	public void setFluidDetails(String fluidCode,String drug_code,String ocurrance_num) {

		String start_date	= getOrderDate();
		String patientClass = getPatientClass();
		Connection connection			 = null;
		PreparedStatement pstmt			 = null;
		ResultSet resultSet				 = null;
		PreparedStatement pstmt1			 = null;//Added for ML-MMOH-CRF-1223
		ResultSet resultSet1			 = null;//Added for ML-MMOH-CRF-1223
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
		String default_fluid_infuse_over = "";//Added for ML-MMOH-CRF-1223
		boolean site_spec = isSiteSpecific("PH", "DEFAULT_COMP_FLUID_INF_OVER");//ML-MMOH-CRF-1223

		FluidDetails	= new HashMap();
		try {
			connection	= getConnection();
			pstmt		= null;
			resultSet	= null;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT1A"));
			pstmt.setString(1, fluidCode);
			pstmt.setString(2, login_facility_id);
			pstmt.setString(3, fluidCode);
			pstmt.setString(4, "");
			pstmt.setString(5, "");
			pstmt.setString(6, getLanguageId());
			/*pstmt.setString(7, getLanguageId());
			pstmt.setString(8, getLanguageId());
			pstmt.setString(9, getLanguageId());
			pstmt.setString(10, getLanguageId());*/  //commented for ph_drug_vw_lang_vw - language issue

			resultSet	= pstmt.executeQuery();

			if(resultSet.next()) {
				FluidDetails.put("DRUG_CODE", (resultSet.getString("DRUG_CODE")==null ? "":resultSet.getString("DRUG_CODE")));
				FluidDetails.put("ITEM_CODE", (resultSet.getString("ITEM_CODE")==null ? "":resultSet.getString("ITEM_CODE")));
				FluidDetails.put("STOCK_UOM",( resultSet.getString("STOCK_UOM")==null ? "":resultSet.getString("STOCK_UOM")));
				
				FluidDetails.put("EXTERNAL_PRODUCT_ID", (resultSet.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet.getString("EXTERNAL_PRODUCT_ID")));
				FluidDetails.put("PATIENT_CLASS",patientClass);
				FluidDetails.put("DRUG_DESC",(resultSet.getString("DRUG_DESC")==null ? "":resultSet.getString("DRUG_DESC")));
				FluidDetails.put("IN_FORMULARY_YN",(resultSet.getString("IN_FORMULARY_YN")==null ? "N":resultSet.getString("IN_FORMULARY_YN")));
				FluidDetails.put("GENERIC_ID",(resultSet.getString("GENERIC_ID")==null ? "":resultSet.getString("GENERIC_ID")));
				generic_id = resultSet.getString("GENERIC_ID");
				FluidDetails.put("GENERIC_NAME",(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME")));
				FluidDetails.put("FORM_CODE",(resultSet.getString("FORM_CODE")==null ? "":resultSet.getString("FORM_CODE")));
				FluidDetails.put("FORM_DESC",(resultSet.getString("FORM_DESC")==null ? "":resultSet.getString("FORM_DESC")));
				FluidDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")));
				FluidDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")));
				FluidDetails.put("CONTENT_IN_PRES_BASE_UOM",(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null ? "1":resultSet.getString("CONTENT_IN_PRES_BASE_UOM")));
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
				FluidDetails.put("INFUSE_OVER_VALUE",(resultSet.getString("INFUSE_OVER_VALUE")==null ? "":resultSet.getString("INFUSE_OVER_VALUE")));
				FluidDetails.put("INFUSE_OVER_DURN_TYPE",(resultSet.getString("INFUSE_OVER_DURN_TYPE")==null ? "":resultSet.getString("INFUSE_OVER_DURN_TYPE")));
				calc_dosg_by_freq_durn_yn = resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN");
				strength_value			  = resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE");
				strength_value			  = strength_value.trim();
				pres_base_uom			  = resultSet.getString("PRES_BASE_UOM");
				strength_uom			  = resultSet.getString("STRENGTH_UOM");
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);
//Adding start for ML-MMOh-CRF-1223
   if(site_spec){
			pstmt1		= connection.prepareStatement(" SELECT DEFAULT_INFUSE_OVER_VALUE FROM PH_DRUG_COMPATIBILITY_FLUID WHERE DRUG_CODE =? AND FLUID_CODE=? AND EFF_STATUS ='E' ");
			pstmt1.setString(1, drug_code);
			pstmt1.setString(2, fluidCode);
			resultSet1	= pstmt1.executeQuery();
			if(resultSet1!=null && resultSet1.next()) {
				default_fluid_infuse_over =  resultSet1.getString("DEFAULT_INFUSE_OVER_VALUE")==null ? "":resultSet1.getString("DEFAULT_INFUSE_OVER_VALUE");
			}
			closeResultSet(resultSet1);
			closeStatement(pstmt1);
			if(default_fluid_infuse_over.equals("0"))
				default_fluid_infuse_over ="";
//System.err.println("default_fluid_infuse_over in onco bean @@@3151===="+default_fluid_infuse_over);
             // if(!default_fluid_infuse_over.equals("")){
                  FluidDetails.put("INFUSE_OVER_VALUE",default_fluid_infuse_over);
			 // }
   }
			  //Adding end for ML-MMOH-CRF-1223
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
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10C"));
			pstmt.setString(1, order_type_code);
			pstmt.setString(2, getLanguageId());
			resultSet	= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				FluidDetails.put("ORDER_TYPE_DESC",resultSet.getString("SHORT_DESC"));
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);

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

			closeResultSet(resultSet);
			closeStatement(pstmt);
			String strAD_DA ="'DA', 'AD'";// Added for HSA-SCF_001 [IN:042444] start
			if(getExcludeADRAllergyAlert().equals("Y")){
				strAD_DA = "'DA'";}		// Added for HSA-SCF-0011 [IN:042444] end
			pstmt			= connection.prepareStatement("select count(*) from (SELECT   a.adv_reac_code allergy_type_code, b.long_desc allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a,  am_reaction_lang_vw b,pr_allergy_sensitivity C, PH_DRUG d, pr_adverse_event adr  WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type in( "+strAD_DA+")  AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code  AND a.patient_id = ? AND b.reaction_code(+) = a.adv_reac_code  AND b.language_id(+) =? and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO AND C.STATUS = 'A' AND( (adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) union ALL SELECT adv_reac_code allergy_type_code, OTHERS_REACTION allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a ,pr_allergy_sensitivity C , PH_DRUG d, pr_adverse_event adr WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type = 'DA' AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code AND a.patient_id = ?  AND a.adv_reac_code  ='Oth'and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO and adr.ALLERGY_ALERT_BY <> 'A' AND C.STATUS = 'A' AND ((adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) )"); // a.adv_event_type = 'DA' changed as a.adv_event_type in ('DA','AD')RUT-SCF-0191.1 [IN:037367]// Changed for RUT-CRF-0065.1 [IN:43255]
			pstmt.setString(1, fluidCode);
			pstmt.setString(2, getPatId());
			pstmt.setString(3, getLanguageId());
			pstmt.setString(4, fluidCode);
			pstmt.setString(5, getPatId());
			int rec_count	=0;
			resultSet		= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				rec_count=resultSet.getInt(1);
			}

			if(rec_count>0) {
				FluidDetails.put("ALLERGY_YN","Y");
			}
			else {
				FluidDetails.put("ALLERGY_YN","N");
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT5A"));
			if(!getLanguageId().equals("en")){ // Added for RollForward from SRR - SRR20056-SCF-9376 [IN056775]
				start_date=com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",getLanguageId(),"en");				   
			}
			pstmt.setString(1, start_date);
			pstmt.setString(2, start_date);
			resultSet	= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				FluidDetails.put("FUTURE_DATE",(resultSet.getString("FUTURE_DATE")));
				FluidDetails.put("BACK_DATE",(resultSet.getString("BACK_DATE")));
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT6A"));
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

			closeResultSet(resultSet);
			closeStatement(pstmt);
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
				   FluidDetails.put("END_DATE",com.ehis.util.DateUtils.convertDate(resultSet.getString("END_DATE"),"DMYHM",getLanguageId(),"en"));				   
				}
				else{
				   FluidDetails.put("END_DATE",(resultSet.getString("END_DATE")));
				}
			}
		    /*if(!getLanguageId().equals("en")){
		       FluidDetails.put("START_DATE",com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",getLanguageId(),"en"));				   
		    }
			else{*/
			   FluidDetails.put("START_DATE",start_date);
		    //}

			closeResultSet(resultSet);
			closeStatement(pstmt);
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT8A"));
			pstmt.setString(1, durn_type);
			pstmt.setString(2, getLanguageId());
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				FluidDetails.put("DURN_DESC",(resultSet.getString("DURN_DESC")));
				FluidDetails.put("OR_DURN_DESC",(resultSet.getString("DURN_DESC")));
			}

			if(calc_dosg_by_freq_durn_yn==null || calc_dosg_by_freq_durn_yn.equals("N")) {
				FluidDetails.put("DOSAGE_TYPE","A");
				FluidDetails.put("ORI_DOSAGE_TYPE","A");
				dosage_type="A";
			}
			else {
				if(strength_value.equals("0")) {
					FluidDetails.put("DOSAGE_TYPE","Q");
					FluidDetails.put("ORI_DOSAGE_TYPE","Q");
					dosage_type="Q";
				}
				else {
					FluidDetails.put("DOSAGE_TYPE","S");
					FluidDetails.put("ORI_DOSAGE_TYPE","S");
					dosage_type="S";
				}
			}

			if(strength_value==null || strength_value.equals("0") || strength_value.equals("")) {

				FluidDetails.put("QTY_VALUE",qty_value);
				FluidDetails.put("QTY_DESC_CODE","");
				qty_desc_code=pres_base_uom;
			}
			else {

				FluidDetails.put("QTY_VALUE",strength_value);
				FluidDetails.put("QTY_DESC_CODE","");
				qty_desc_code=strength_uom;
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT9A"));
			pstmt.setString(1, qty_desc_code);
			pstmt.setString(2, getLanguageId());
			resultSet	= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				FluidDetails.put("QTY_DESC",(resultSet.getString("SHORT_DESC")));
				FluidDetails.put("OR_QTY_DESC",(resultSet.getString("SHORT_DESC")));
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT14A"));
			pstmt.setString(1, login_facility_id);
			resultSet			= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				FluidDetails.put("REFILL_YN",(resultSet.getString("REFILL_YN")==null ? "N":resultSet.getString("REFILL_YN")));
				FluidDetails.put("MAX_REFILLS_FOR_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_REFILLS_FOR_PRES")));
				FluidDetails.put("MAX_DURN_FOR_REFILL_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_DURN_FOR_REFILL_PRES")));
			}
			
			closeResultSet(resultSet);
			closeStatement(pstmt);
			int count_rx	= 0;
//			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13C"));
			pstmt	= 	connection.prepareStatement("SELECT  COUNT(ROWID) FROM  PH_PATIENT_DRUG_PROFILE A WHERE   PATIENT_ID =? AND END_DATE >= to_date(?,'dd/mm/yyyy hh24:mi') AND  TO_DATE(?,'DD/MM/RRRR HH24:MI') BETWEEN  TO_DATE(START_DATE,'DD/MM/RRRR HH24:MI') AND  TO_DATE(END_DATE,'DD/MM/RRRR HH24:MI')   AND DISCONT_DATE_TIME IS NULL AND ON_HOLD_DATE_TIME IS NULL AND  CANCEL_YN='N' AND   STOP_YN='N' AND GENERIC_ID=?");
			pstmt.setString(1, getPatId());
			if(!getLanguageId().equals("en")){ // If Block Added for RollForward from SRR - SRR20056-SCF-9376 [IN056775]
				pstmt.setString(2, com.ehis.util.DateUtils.convertDate(getOrderDate(),"DMYHM",getLanguageId(),"en"));
				pstmt.setString(3, com.ehis.util.DateUtils.convertDate(getOrderDate(),"DMYHM",getLanguageId(),"en"));
			 }
			else{
				pstmt.setString(2, getOrderDate());
				pstmt.setString(3, getOrderDate());
            }
//			pstmt.setString(4, getFreq_code());
			pstmt.setString(4, generic_id);


			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				count_rx=resultSet.getInt(1);
			}
			if(count_rx>0) {
				FluidDetails.put("CURRENT_RX","Y");
			}
			else {
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
			else if(dosage_type.equals("Q")) {
				float total_qty=0.0f;
				if((qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals(""))) ) {
					total_qty=Float.parseFloat(qty_value)*Integer.parseInt(durn_value)*Integer.parseInt(repeat_value);
				}
				//get the conversion factor
				if(strength_value==null || strength_value.equals("0") || strength_value.equals("")) {
					FluidDetails.put("TOT_STRENGTH","0");
					FluidDetails.put("TOT_STRENGTH_UOM","");

				}
				else {
					float tot_strength=0.0f;
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
			else if(dosage_type.equals("S")) {
				float total_qty=0.0f;
				if((qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals(""))) ) {
					total_qty=Float.parseFloat(qty_value)*Integer.parseInt(durn_value)*Integer.parseInt(repeat_value);
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
			FluidDetails.put("AUTH_YN_VAL","N");
			FluidDetails.put("APPROVAL_YN_VAL","N");
			FluidDetails.put("COSIGN_YN_VAL","N");
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
			FluidDetails.put("OCURRANCE_NUM",ocurrance_num);

			if((!dosage_type.equals("A")) &&  schedule_yn.equals("Y")) {
				FluidDetails.put("SCH_OVER_YN","Y");
			}
			else {
				FluidDetails.put("SCH_OVER_YN","N");
			}
		
			float total_qty_value=0;
			if ( ( qty_value!=null && !qty_value.trim().equals("")) && (repeat_value!=null && !repeat_value.trim().equals("")) && (durn_value!=null && !durn_value.trim().equals(""))){
				float ext_qty=Float.parseFloat(qty_value);
				int ext_repeat_value=Integer.parseInt(repeat_value);
				int ext_durn=Integer.parseInt(durn_value);
				 total_qty_value=ext_qty*ext_repeat_value*ext_durn;
			}

			FluidDetails.put("TOTAL_QTY_VALUE",""+total_qty_value);

		}
		catch(Exception e) {
			FluidDetails.put("error",e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeResultSet(resultSet1);
			    closeStatement(pstmt1);
				closeStatement(pstmt);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		// Add it to the Main HashMap Key is the Drug/Fluid Code
		compFluidDetails.put(drug_code+"_"+ocurrance_num,FluidDetails);

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

	public HashMap getscheduleFrequency() {
		return this.scheduleFrequency;
	}

	public void resetscheduleFrequency() {
		this.scheduleFrequency = new HashMap();
	}

	public boolean setScheduleFrequencyStr(Hashtable ht) {

		try {
			String code 			= (String)ht.get("code");
		//	String duration_type 	= (String)ht.get("durationType");
		//	int repeat				= Integer.parseInt((String)ht.get("repeat"));
		//	String row_value		= (String)ht.get("row_value");
		//	String start_date_time	= (String)ht.get("start_date_time");

			ArrayList scheduleFrequencyDatas	=	new ArrayList();
					  scheduleFrequencyDatas	=	(ArrayList)ht.get(code);

				if (scheduleFrequencyDatas == null)
				{
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
		
/*			ArrayList day_list	= new ArrayList();
			ArrayList day_names	= new ArrayList();
			ArrayList time_list	= new ArrayList();
			ArrayList dose_list	= new ArrayList();
			String time_value	= (String)ht.get("time1");
			HashMap freq_char_list	 = new HashMap();

			freq_char_list.put("repeat",repeat);
			freq_char_list.put("durationType",duration_type);
			freq_char_list.put("start_date_time",start_date_time);
			freq_char_list.put("end_date_time","");
			
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
			scheduleFrequencyDatas.add(dose_list);
*/

			/*for(int j=1; j <= repeat; j++) {
				HashMap hashMap	= new HashMap();
				hashMap.put("admin_day_or_time","H");
				hashMap.put("duration_type",duration_type);
				hashMap.put("start_time_assign","");
				hashMap.put("repeat",String.valueOf(repeat));
				hashMap.put("row_value",row_value);
				hashMap.put("admin_time",(String)ht.get("time"+j));
				hashMap.put("admin_qty",(String)ht.get("qty"+j));
				scheduleFrequencyDatas.add(hashMap);
			}*/
			scheduleFrequency.put(code,scheduleFrequencyDatas);
			return true;
		}
		catch(Exception e) {
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

	public ArrayList getScheduleFrequencyStr(String code) {
		Object scheduleFrequencyDatasObj = scheduleFrequency.get(code);

		if(scheduleFrequencyDatasObj == null)
			return new ArrayList();
		else
			return (ArrayList)scheduleFrequencyDatasObj;
	}

	public ArrayList getScheduleFrequencyStr(String code,String code1) {
		Object scheduleFrequencyDatasObj = scheduleFrequency.get(code);

		if(scheduleFrequencyDatasObj == null)
			return new ArrayList();
		else
			return (ArrayList)scheduleFrequencyDatasObj;
	}

	public ArrayList getDoseValues(String drug_code, String patient_id) {
		ArrayList doseValues			= new ArrayList();
		Connection connection 			= null ;
		CallableStatement cstmt			= null;
		PreparedStatement pstmt			= null;
		String qty_value				= "";
		ResultSet resultSet				= null;

		try{
			connection 	= getConnection() ;
			cstmt=connection.prepareCall("{call PH_CALC_DEF_DOSAGE(?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, drug_code);
			cstmt.setString(2, patient_id);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.execute();

			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_SELECT4"));
			pstmt.setString(1,drug_code);
			resultSet			= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				qty_value	=	resultSet.getString("QTY_VALUE");
			}

			if( !(cstmt.getString(3)).equals("1")) {
				qty_value	=	cstmt.getString(3);
			}

			doseValues.add( qty_value);
			doseValues.add( cstmt.getString(4)==null ? "":cstmt.getString(4)); 
			doseValues.add( (cstmt.getString(5)==null ? "0":cstmt.getString(5)));
			doseValues.add( (cstmt.getString(6)==null ? "0":cstmt.getString(6)));
			doseValues.add( (cstmt.getString(7)==null ? "":cstmt.getString(7)));
			doseValues.add( (cstmt.getString(8)==null ? "":cstmt.getString(8)));
			doseValues.add( (cstmt.getString(9)==null ? "":cstmt.getString(9)));
			if(!dosageUOM.containsKey(drug_code)) // condition added for IN27290 --24/05/2011-- priya
			{
				dosageUOM.put(drug_code,cstmt.getString(9));
			}

		}catch(Exception e){
			e.printStackTrace() ;
		}
		finally{
			try {
				closeStatement(cstmt);
				closeStatement(pstmt);
				closeConnection(connection);
				}
			catch(Exception ex) {
				ex.printStackTrace() ;
			}
		}
		return doseValues;
	}

	public HashMap chkMaxDosageLimit(String drugCode,String patient_id,String qty_value,String dosage_type,String repeat_value){
		Connection connection       = null ;
        CallableStatement cstmt     = null ;
        PreparedStatement pstmt = null ;//Added for IN:070451
		ResultSet resultSet		= null ;
        ResultSet resultSet1         = null ;//Added for IN:070451
		HashMap dosage_dtl			= new HashMap();
		//Added for IN:070451 start
		HashMap pat_dtls	=	getPatientDetails(patient_id,drugCode);
		String age_group			=	(String)pat_dtls.get("age_group");
		String factor="";
		String calc_by_ind ="";
		if( !age_group.equals("")) {
			try {
				connection = getConnection() ;
				String sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT81");
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,drugCode);
				pstmt.setString(2,age_group);
				resultSet1			= pstmt.executeQuery();

				if(resultSet1!=null && resultSet1.next()) {
				 calc_by_ind =resultSet1.getString("CALC_BY_IND");
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				try {
					closeResultSet(resultSet1);
					closeStatement(pstmt);
					closeConnection(connection);
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
			}
	
			
		
		}
		if(calc_by_ind.equalsIgnoreCase("W")){
			 factor =weight;
		}
		else if(calc_by_ind.equalsIgnoreCase("B")){
			 factor =bsa;
			 System.out.println("bsa"+bsa);
		}
		else 
		   factor="1";
		//Added for IN:070451 end   
		try{
			
			connection = getConnection() ;
			cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//Modified for IN:070451 added 5 parameters
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
			dosage_dtl.put("LIMIT_IND",checkForNull(limit_ind)); // checkForNull Added for ML-MMOH-CRF-1225
			dosage_dtl.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
			dosage_dtl.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );
			dosage_dtl.put("MONO_GRAPH","");
			dosage_dtl.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );
			dosage_dtl.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );
			if(limit_ind!=null && limit_ind.equals("N")){
				dosage_dtl.put("MONO_GRAPH",(cstmt.getString(9)==null ? "":cstmt.getString(9)) );

			}
			try{
				closeStatement( cstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		 }
		 catch ( Exception e ) {
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

	public HashMap prepareOrderDetails(Hashtable submitData) {
		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "test");

		String drug_desc 			= "";

		ArrayList temp = getDrugDetails();
		HashMap orderDetails = new HashMap();
		String cycle_freq_yn = "";//ML-MMOH-CRF-0345
		String prev_drug_code = "";//ML-MMOH-CRF-0345
		//int cycle_order_cunt = 0; //Commented for Check Style Report.
		String cycle_order_index = "";//ML-MOH-CRF-0345
		if (temp.size() != 0) {
			String order_id		= setOrderID("CS");		 //dummy order_id generation
			orderDetails.put("ORDER_ID"+"DUMMY", order_id);
			for (int i=0; i<temp.size(); i++) {
				HashMap tempMap = (HashMap)temp.get(i);
                    
				cycle_freq_yn = (String)tempMap.get("CYCLE_FREQ_YN")==null?"":(String)tempMap.get("CYCLE_FREQ_YN");                    
				if (tempMap.size() != 0) {
					drug_desc = drug_desc + tempMap.get("DRUG_DESC").toString() + "|";

					order_id		= setOrderID("PH"); // Order Id Gen.
					this.initial_order_id=order_id;
					String drug_code	= (String)tempMap.get("DRUG_CODE");
					String ocurrance_num	= (String)tempMap.get("OCURRANCE_NUM");
					if(cycle_freq_yn.equals("Y")){ //added for //ML-MMOH-CRF-0345
					cycle_order_index = (String)tempMap.get("CYCLE_INDEX");
						
					/*	if(prev_drug_code.equals(drug_code))
							cycle_order_cunt++;
						else
							cycle_order_cunt=0; */

						orderDetails.put("ORDER_ID_CYCLE"+drug_code+ocurrance_num+cycle_order_index, order_id);
					}else{
						orderDetails.put("ORDER_ID"+drug_code+ocurrance_num, order_id);

					}
					prev_drug_code = drug_code;
				}
			}
		}
	
		ArrayList header_rec=getDrugDetails(); //Added for Bru-HIMS-CRF-393_1.0-Start
		HashMap orderTypeDetails=new HashMap();
		String  order_type_code="";
//		String patient_class=""; Removed for IN063877
		HashSet keyset=new HashSet();
		for(int i=0;i<header_rec.size();i++){
			orderTypeDetails=(HashMap)header_rec.get(i);
			order_type_code=(String)orderTypeDetails.get("ORDER_TYPE_CODE");
			keyset.add(order_type_code);
		}
		setPrintOrdShtRuleInd(keyset,getPatientClass());//Added for Bru-HIMS-CRF-393_1.0-End
		HashMap commonData = new HashMap();
		commonData.put("priority", submitData.get("priority"));
		commonData.put("height", submitData.get("height"));
		commonData.put("height_unit", submitData.get("height_unit"));
		commonData.put("weight", submitData.get("weight"));
		commonData.put("weight_unit", submitData.get("weight_unit"));
		commonData.put("bsa", submitData.get("bsa"));
		commonData.put("bsa_unit", submitData.get("bsa_unit"));
		commonData.put("bmi", submitData.get("bmi"));
		commonData.put("th_medn", submitData.get("th_medn"));
		commonData.put("take_home_medication", submitData.get("take_home_medication"));
		commonData.put("iv_presc_yn", submitData.get("iv_presc_yn"));
		commonData.put("regimen_code", submitData.get("regimen_code"));
		commonData.put("Intention_code", submitData.get("Intention_code"));
		commonData.put("stage_code", submitData.get("stage_code"));
		commonData.put("patient_id", getPatId());
		commonData.put("patient_class", getPatientClass());
		commonData.put("encounter_id", getEncId());
		commonData.put("pract_id", submitData.get("pract_id"));
		commonData.put("pract_name", submitData.get("pract_name"));
		commonData.put("locn_type", submitData.get("locn_type"));
		commonData.put("locn_code", submitData.get("locn_code"));
		//commonData.put("buildMAR_yn", getBuildMAR_yn()); // CRF-0062

		if(!getLanguageId().equals("en")){
			commonData.put("order_date", com.ehis.util.DateUtils.convertDate((String)submitData.get("order_date"),"DMYHM",getLanguageId(),"en"));
		}
		else{	   
			commonData.put("order_date", submitData.get("order_date"));
		}
		commonData.put("catalog_short_desc", getCatalogDesc());
		commonData.put("header_comments",getPresRemarks());
		commonData.put("properties", getProperties());
		commonData.put("login_by_id",		login_by_id);
		commonData.put("login_at_ws_no",	login_at_ws_no);
		commonData.put("login_facility_id",	login_facility_id);

		HashMap tabData = new HashMap();
		tabData.put("commondata", commonData);
		tabData.put("orderdetails", orderDetails);
		tabData.put("drugRemarks",getDrugRemarks());
		tabData.put("fluidremarks",this.getFluidRemarks());

		tabData.put("schedulefreq", getscheduleFrequency());
		tabData.put("drugdetails", getDrugDetails());
		tabData.put("fluiddetails", compFluidDetails);
		tabData.put("Mfr_rec_details",this.MFRRecs);// added for CRF-1014
    	tabData.put("mfr_remarks_details", getmfr_remark()); // added for CRF-1014

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
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT57",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT63",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT63"));

			sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT1",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT1"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT2",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT2"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT3B",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT3B"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT4",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT4"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT5",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT6",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT6"));
			sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT2",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT2"));
			sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT3",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT3")); // Added for ML-MMOH-CRF-1225
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT7",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT10",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT10"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT12",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT12"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT73",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT73"));
			sqlMap.put("SQL_PH_PRESCRIPTION_MODIFY7",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY7"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT75",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT75"));
			sqlMap.put("SQL_PH_PRESCRIPTION_MODIFY9",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY9"));
			sqlMap.put("SQL_PH_ONCOLOGY_UNIT",			PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_UNIT"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT72",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT72"));
			sqlMap.put("SQL_PH_PRESCRIPTION_MODIFY6",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY6"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT9",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT9"));
			sqlMap.put("SQL_PH_PRESCRIPTION_MODIFY8",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY8"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT11",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT11"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT74",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT74"));
			sqlMap.put("SQL_PH_ONCOLOGY_REGIMEN_DRUG_SELECT3",	PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_DRUG_SELECT3"));
			sqlMap.put("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try{
// Remove this code when the values r inserted properly in the concerned tables and put the code in the  EJB
			HashMap result = insertData( tabData, sqlMap ) ;
// Till here

			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", "Exception While Insertion") ;
			map.put("flag","Exception While Insertion") ;
			Boolean tmp=(Boolean)result.get("result");

			if(tmp.booleanValue())	{

				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
				setTrnGroupRef((String)result.get("trn_group_ref"));
				setTokensGeneratedYN((String)result.get("tokens_generated_yn"));
			}
			else {
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( false ) ) ;

				map.put( "message", getMessage(getLanguageId(),"EXCEPTION_OCCURED_WHILE_INSERTION","PH")+" : "+(String)map.get("flag") +" : "+(String)map.get("msgid")) ;
			}
		}
		catch (Exception e) {
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		return map;
	} // prepareOrderDetails

/*======================AMEND===========================================*/
	public HashMap prepareAmendOrderDetails(Hashtable submitData){
		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "test");

		String order_id		        = "";		
		ArrayList temp				= getExistingCYTORecords();

		HashMap orderDetails		= new HashMap();
		String drug_code = "";
		String ocurrance_num = "";
		if (temp.size() != 0) {
			for (int i=0; i<temp.size()-2; i++) {
				HashMap tempMap = (HashMap)temp.get(i);

				if (tempMap.size() != 0) {
					
					drug_code	= (String)tempMap.get("ORDER_CATALOG_CODE");
					ocurrance_num	= (String)tempMap.get("OCURRANCE_NUM");
                    order_id            = (String)tempMap.get("ORDER_ID");
					orderDetails.put("ORDER_ID"+drug_code+ocurrance_num, order_id);
				}
			}
		}

		ArrayList header_rec=getDrugDetails(); //Added for Bru-HIMS-CRF-393_1.0-Start
		HashMap orderTypeDetails=new HashMap();
		String  order_type_code="";
//		String patient_class=""; Removed for IN063877
		HashSet keyset=new HashSet();
	   for(int i=0;i<header_rec.size();i++){
			orderTypeDetails=(HashMap)header_rec.get(i);
			order_type_code=(String)orderTypeDetails.get("ORDER_TYPE_CODE");
			keyset.add(order_type_code);
		}
		setPrintOrdShtRuleInd(keyset,getPatientClass());//Added for Bru-HIMS-CRF-393_1.0-End
		HashMap commonData = new HashMap();
		commonData.put("priority", submitData.get("priority"));
		commonData.put("height", submitData.get("height"));
		commonData.put("height_unit", submitData.get("height_unit"));
		commonData.put("weight", submitData.get("weight"));
		commonData.put("weight_unit", submitData.get("weight_unit"));
		commonData.put("bsa", submitData.get("bsa"));
		commonData.put("bsa_unit", submitData.get("bsa_unit"));
		commonData.put("bmi", submitData.get("bmi"));
		commonData.put("th_medn", submitData.get("th_medn"));
		commonData.put("take_home_medication", submitData.get("take_home_medication"));
		commonData.put("iv_presc_yn", submitData.get("iv_presc_yn"));
		commonData.put("regimen_code", submitData.get("regimen_code"));
		commonData.put("Intention_code", submitData.get("Intention_code"));
		commonData.put("stage_code", submitData.get("stage_code"));
		commonData.put("patient_id", getPatId());
		commonData.put("patient_class", getPatientClass());
		commonData.put("encounter_id", getEncId());
		commonData.put("pract_id", submitData.get("pract_id"));
		commonData.put("pract_name", submitData.get("pract_name"));
		commonData.put("locn_type", submitData.get("locn_type"));
		commonData.put("locn_code", submitData.get("locn_code"));
		commonData.put("order_date", submitData.get("order_date"));
		commonData.put("catalog_short_desc", getCatalogDesc());
		commonData.put("header_comments",getPresRemarks());
		commonData.put("properties", getProperties());
		commonData.put("login_by_id",		login_by_id);
		commonData.put("login_at_ws_no",	login_at_ws_no);
		commonData.put("login_facility_id",	login_facility_id);
		//commonData.put("buildMAR_yn", getBuildMAR_yn());  // CRF-0062

		HashMap tabData = new HashMap();
		tabData.put("commondata", commonData);
		tabData.put("orderdetails", orderDetails);
		tabData.put("drugRemarks",this.getDrugRemarks());
		tabData.put("fluidremarks",this.getFluidRemarks());
		tabData.put("schedulefreq", getscheduleFrequency());
		tabData.put("drugdetails", getDrugDetails());
		tabData.put("fluiddetails", compFluidDetails);
		tabData.put("Mfr_rec_details",this.MFRRecs);// added for CRF-1014
    	tabData.put("mfr_remarks_details", getmfr_remark()); // added for CRF-1014

		HashMap sqlMap = new HashMap();
		try {
				
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT24A",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT24A"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT53",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT25A",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT25A"));				
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT57",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT63",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT63"));				
			sqlMap.put("SQL_PH_PRESCRIPTION_MODIFY7",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY7"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT75",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT75"));
			sqlMap.put("SQL_PH_PRESCRIPTION_MODIFY9",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY9"));
			sqlMap.put("SQL_PH_ONCOLOGY_UNIT",			PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_UNIT"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT72",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT72"));
			sqlMap.put("SQL_PH_PRESCRIPTION_MODIFY6",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY6"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT9",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT9"));
			sqlMap.put("SQL_PH_PRESCRIPTION_MODIFY8",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY8"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT11",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT11"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT74",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT74")); 
			sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE1",	PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE1"));//or_order//4
			sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE2",	PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE2"));//or_order_line//5
			
			//sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE3",	PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE3"));//or_order_line_ph//7
			
			sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE3"," UPDATE OR_ORDER_LINE_PH SET SPLIT_DRUG_PREVIEW=?,TOT_STRENGTH=?,TOT_STRENGTH_UOM=?,INFUSE_OVER=?,INFUSE_OVER_UNIT=?,INFUSION_RATE=?,INFUSION_VOL_STR_UNIT=?,INFUSION_PER_UNIT=?,BMS_QTY=?,BMS_STRENGTH=?,SPLIT_DOSE_YN=?,PRES_QTY_VALUE=?,PRES_QTY_UOM=?,TOT_INFUSION_OVER=?,TOT_INFUSION_OVER_UNIT=?,AMEND_REASON_CODE=?,AMEND_REASON=?,CHNGD_FLUID_REMARKS=?,ADMIN_RATE_DETAIL=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,CALC_DOSE=?,CALC_DOSE_UOM=?,CALC_DOSE_BY=?,CALC_DOSE_BASED_ON=?,DOSAGE_TYPE=?,ORIG_INFUSE_OVER=?,ORIG_INFUSION_RATE=? , BUILD_MAR_YN=?,AMENDED_BY_ID =?, AMENDED_DATE =SYSDATE,DRUG_INDICATION=?,MFR_REMARKS = ?,ALLERGY_OVERRIDE_REASON_CODE=?,DOSE_LIMIT_OVER_REASON_CODE=?,DUP_DRUG_OVERRIDE_REASON_CODE=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=? ");// AMENDED_BY_ID and AMENDED_DATE  fields added for ML-BRU-SCF-0098 [IN031837]"); & DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938],Modified for IN:072715
//MFR_REMARKS added for ML-MMOH-CRF-1014
			sqlMap.put("SQL_PH_AMEND_IVPRES__UPDATE4",	PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE4"));//ph_patient_drug_profile//9		
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT5",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5"));//11							
			sqlMap.put("SQL_PH_IVPRESCRIPTION_DELETE_MEDN_ADMIN",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_DELETE_MEDN_ADMIN"));//15
			sqlMap.put("SQL_PH_IVPRESCRIPTION_DELETE_PH_MEDN_ADMIN_SCH_DTL",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_DELETE_PH_MEDN_ADMIN_SCH_DTL"));// Added for ML-MMOH-CRF-1225
			sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT2",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT2"));//16&18
			sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT3",	PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT3")); // Added for ML-MMOH-CRF-1225
			sqlMap.put("SQL_PH_PRESCRIPTION_DELETE_FIELD_VALUES_A",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_DELETE_FIELD_VALUES_A"));	//13
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT7",	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7"));//
			sqlMap.put("SQL_PH_ONCOLOGY_ORD_CMT_DELETE",PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_ORD_CMT_DELETE"));//14				
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT57",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57"));//12	


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try{

			HashMap result = updateData( tabData, sqlMap ) ;
			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", "Exception While Insertion") ;
			map.put("flag","Exception While Insertion") ;
			Boolean tmp=(Boolean)result.get("result");

			if(tmp.booleanValue())	{
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
			}
			else {
				
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(getLanguageId(),"EXCEPTION_OCCURED_WHILE_INSERTION","PH")+" : "+(String)map.get("flag") ) ;
			}

		}
		catch (Exception e) {
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
/*======================================================================*/

	public HashMap insertData( HashMap tabData, HashMap sqlMap ) {
		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "0");
		map.put("msgid", "INSERT");

		Connection connection					= null;
		PreparedStatement pstmt_select			= null;
		PreparedStatement pstmt_insert			= null;
		PreparedStatement pstmt_pres_select53	= null;
		PreparedStatement pstmt_pres_select55	= null;

		PreparedStatement pstmt_workload		= null;
		PreparedStatement workload_insert		= null;
		PreparedStatement work_insert_month		= null;
		PreparedStatement work_insert_loc		 = null;
		PreparedStatement work_insert_loc_mon	= null;

		CallableStatement cstmt_insert			= null;
		PreparedStatement pstmt_clob			= null;
		ResultSet rset_clob						= null;
		ResultSet resultSet						= null;

		ResultSet resultSet_workload			= null;
		int result								= 0;
		String monthly_count					= "";
		String monthly_count_loc				= "";

		try {

			HashMap orderDetails	= (HashMap)tabData.get("orderdetails");
			HashMap commonData		= (HashMap)tabData.get("commondata");
			HashMap	scheduleFreq	= (HashMap) tabData.get("schedulefreq");
			HashMap	fluidDetails	= (HashMap)tabData.get("fluiddetails");
			ArrayList drugList		= (ArrayList)tabData.get("drugdetails");
			ArrayList drugRemarks	= (ArrayList)tabData.get("drugRemarks");
			ArrayList fluidRemarks	= (ArrayList)tabData.get("fluidremarks");
			String login_by_id		= (String)commonData.get("login_by_id");
			String login_at_ws_no	= (String)commonData.get("login_at_ws_no");
			String login_facility_id= (String)commonData.get("login_facility_id");
			String header_comments	= (String)commonData.get("header_comments");
			String priority			= (String)commonData.get("priority");
			String height			= (String)commonData.get("height");
			String height_unit		= (String)commonData.get("height_unit");
			String weight			= (String)commonData.get("weight");
			String weight_unit		= (String)commonData.get("weight_unit");
			String bsa				= (String)commonData.get("bsa");
			String bmi				= (String)commonData.get("bmi");
			String patient_id		= (String)commonData.get("patient_id");
			String patient_class	= (String)commonData.get("patient_class");
			String encounter_id		= (String)commonData.get("encounter_id");
			String pract_id			= (String)commonData.get("pract_id");
			String location_type	= (String)commonData.get("locn_type");
			String location_code	= (String)commonData.get("locn_code");
			String order_date		= (String)commonData.get("order_date");
			String take_home_medication	= (String)commonData.get("take_home_medication");
			String catalog_short_desc= (String)commonData.get("catalog_short_desc");
			HashMap Mfr_details      = (HashMap)tabData.get("Mfr_rec_details");//ML-MMOH-CRF-1014 
			HashMap mfr_remarks 	= (HashMap)tabData.get("mfr_remarks_details"); //ML-MMOH-CRF-1014 
			String buildMAR_yn= "";  // CRF-0062 VALUE WILL BE TAKEN AT DRUG LEVEL
			String drug_desc 			= "";
			String sys_date				= "";
			String ord_status			= "";
			String freq_nature			= "";
			String line_display_text	= "";
			String in_qty_value			= "";
			String in_qty_unit			= "";
			String in_order_qty			= "";
			String in_tot_strength		= "";
			String in_tot_strength_uom	= "";
			String in_bms_qty			= "";
			String in_strength_value	= "";
			String in_strength_uom		= "";
			String in_pres_qty_value	= "";
			String in_pres_qty_uom		= "";
			String dosage_type			= "";
			String qty_unit				= "";
			String repeat_value			= "";
			String durn_value			= "";
			String durn_desc			= "";
			String strength_value		= "";
			String strength_uom			= "";
			String pres_base_uom		= "";
			String strength_per_pres_uom= "";
			String strength_per_value_pres_uom  = "";
			String comb_ord_qty					= "";
			String equl_value					= "";
			String dose							= "";
			String calc_dose					= "";
			String calc_dose_uom				= "";
			String calc_dose_by					= "";
			String calc_dose_based_on			= "";
			String dose_calc					= "";
			String amend_stock_value			= "";
			String amend_durn_value				= "0";
			String amend_infusion_period_value	= "";
			String amend_infusion_period_uom	= "";
			String amend_infusion_rate			= "";
			String amend_durn_unit				= "";
			String amend_end_date				= "";
			String amend_start_date				= "";
			String amend_frequency				= "";
			String amend_repeat_value			= "";
			String freq_value					= "";
			String repeat_durn_type				= "";
			String auth_yn_val					= "N", approval_yn_val = "N";
			String cosign_yn_val				= "N";
			String or_order_catalog_desc		= "";
			String dummy_order_type_code		= "";
			String pack_size					= "";
			String order_qty					= "";
			String content_in_pres_base_uom		= "";						
			String ing_order_uom				= "";
			String stock_uom					= "";
			String infusion_vol_str_unit		= "";
			String ocurrance_num				= "";
			String uomDisplay					= "";
			String drug_indication				= "";//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]

			int line_no							= 0;
			float ord_qty						= 0.0f;
			float ord_qty_value					= 0.0f;
			float fluid_qty						= 0.0f;
			float fluid_qty_value				= 0.0f;
			int total_line_num					= 0;
			int totalOrder						= 0;
			float ing_unit_qty					= 0.0f;
			float ing_order_qty					= 0.0f;
			String tot_infuse_over				= "";
			String fld_tot_strength				= "";
			String fld_strength_value			= "";
			String trn_group_ref				= "";

			HashMap freq_char_list				= new HashMap();
			ArrayList day_list					= new ArrayList();
			ArrayList day_names					= new ArrayList();
			ArrayList time_list					= new ArrayList();
			ArrayList dose_list					= new ArrayList();
			HashMap schd_week_hr_dates			= new HashMap();
			String freq_chng_durn_desc			= "";
			String	temp_durn_value				= "";
			String cycle_freq_yn				= "";//added for ML-MMOH-CRF-0345 

			connection							= getConnection();
			connection.setAutoCommit(false);
			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT54"));
			resultSet		= pstmt_select.executeQuery();

			if (resultSet.next()) {
				sys_date = resultSet.getString(1);
			}
			try{
				closeStatement(pstmt_select);
				closeResultSet(resultSet);
			}
			catch(Exception e){
				e.printStackTrace();
			}

			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT"));
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

			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_REGIMEN_DRUG_SELECT3"));
			pstmt_select.setString(1,(String) commonData.get("regimen_code"));
			pstmt_select.setString(2, getLanguageId());
			try{
			   resultSet		= pstmt_select.executeQuery();
			}
			catch(Exception e){
				System.out.println("error while executing==SQL_PH_ONCOLOGY_REGIMEN_DRUG_SELECT3 regimen_code="+(String) commonData.get("regimen_code"));
				e.printStackTrace();
			}
			if (resultSet!=null && resultSet.next()) {
				or_order_catalog_desc = resultSet.getString("SHORT_DESC");
				dummy_order_type_code = resultSet.getString("ORDER_TYPE_CODE");
			}
			try{
				closeStatement(pstmt_select);
				closeResultSet(resultSet);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			HashMap orderStatusCode	= new HashMap();
			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT20A"));
			resultSet		= pstmt_select.executeQuery();

			while (resultSet.next()) {
				orderStatusCode.put(resultSet.getString("ORDER_STATUS_TYPE"),resultSet.getString("ORDER_STATUS_CODE"));
			}
			try{
				closeStatement(cstmt_insert);
				closeStatement(pstmt_select);
				closeResultSet(resultSet);
			}
			catch(Exception e){
				e.printStackTrace();
			}

			//pstmt_insert	= connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT1"));
			pstmt_insert	= connection.prepareStatement("INSERT INTO OR_ORDER (ORDER_ID, ORDER_TYPE_CODE, ORDER_CATEGORY, CONTR_SYS_ID, PATIENT_ID, PATIENT_CLASS, ORDERING_FACILITY_ID, ENCOUNTER_ID, EPISODE_ID, EPISODE_VISIT_NUM, SOURCE_TYPE, SOURCE_CODE, DISCHARGE_IND, ORD_DATE_TIME, ORD_PRACT_ID, PRIORITY, ORD_AUTH_REQD_YN, ORD_AUTH_LEVEL, ORD_AUTH_BY_PRACT_ID, ORD_AUTH_DATE_TIME, ORD_APPR_REQD_YN, ORD_APPR_BY_USER_ID, ORD_APPR_DATE_TIME, ORD_COSIGN_REQD_YN, ORD_COSIGN_LEVEL, ORD_COSIGN_BY_PRACT_ID, ORD_COSIGN_DATE_TIME, ORD_PRINT_DATE_TIME, BILL_YN, CONT_ORDER_IND, PERFORMING_FACILITY_ID, PERFORMING_SYS_ID, PERFORMING_DEPTLOC_TYPE, PERFORMING_DEPTLOC_CODE, PERFORMING_PRACT_ID, RESULT_AUTH_REQD_YN, CHILD_ORDER_YN, PARENT_ORDER_ID, ORDER_SET_YN, ORDER_SET_ID, IV_PREP_YN, ORDER_FIELDS_DISPLAY_TEXT, ORDER_STATUS, RESULT_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, ORD_CONSENT_REQD_YN, ORD_CONSENT_BY_ID, ORD_CONSENT_BY_DATE_TIME, CAN_REASON, TRN_GROUP_REF, CATALOG_SPLTY_CODE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), ?, ?, ?, ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), ?, ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), to_date(?, 'dd/mm/yyyy hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), ?,?,?)");
			
//OR_ORDER Insertion
			ArrayList temp = drugList;
			if (temp!=null && temp.size() != 0) {
/*==============================dummy record insertion starts======================*/
			
				String drug_code		  ="DUMMY";
				String dummy_order_id			  =orderDetails.get("ORDER_ID"+drug_code).toString();
				String order_type_code	  ="";
				String ord_auth_reqd_yn   ="N";
				String ord_appr_reqd_yn   ="N";
				String ord_cosign_reqd_yn ="N";
				String regn_reqd_yn		  ="N";
				String ord_consent_reqd_yn="N";
				auth_yn_val		  ="N";
				approval_yn_val	  ="N";
				cosign_yn_val	  ="N";
				ord_auth_reqd_yn	  ="N";				
				ord_appr_reqd_yn	  ="N";				
				ord_cosign_reqd_yn ="N";				
				ord_consent_reqd_yn="N";                 
				auth_yn_val 		  ="N";				
				approval_yn_val 	  ="N";				
				cosign_yn_val 	  ="N";				
								
				 if(dummy_order_id!=null && !dummy_order_id.equals("")){
					pstmt_insert.setString(1, dummy_order_id);
					pstmt_insert.setString(2, dummy_order_type_code);
					pstmt_insert.setString(3, "PH");
					pstmt_insert.setString(4, "PH");
					pstmt_insert.setString(5, getPatId());
					pstmt_insert.setString(6, patient_class);
					pstmt_insert.setString(7, login_facility_id);
					pstmt_insert.setString(8, encounter_id);
					pstmt_insert.setString(9, encounter_id);
					pstmt_insert.setString(10, "");
					pstmt_insert.setString(11, location_type);
					pstmt_insert.setString(12, location_code);
					pstmt_insert.setString(13, "");
					pstmt_insert.setString(14, order_date);
					pstmt_insert.setString(15, pract_id);
					pstmt_insert.setString(16, priority);
					pstmt_insert.setString(17, ord_auth_reqd_yn);
					pstmt_insert.setString(18, "");

					if (ord_auth_reqd_yn.equals("Y")) {
						pstmt_insert.setString(19, pract_id);
						pstmt_insert.setString(20, sys_date);
					}
					else {
						pstmt_insert.setString(19, "");
						pstmt_insert.setString(20, null);
					}

					pstmt_insert.setString(21, ord_appr_reqd_yn);

					if (ord_appr_reqd_yn.equals("Y")) {
						pstmt_insert.setString(22, pract_id);
						pstmt_insert.setString(23, sys_date);
					}
					else {
						pstmt_insert.setString(22, "");
						pstmt_insert.setString(23, null);
					}

					pstmt_insert.setString(24, ord_cosign_reqd_yn);
					pstmt_insert.setString(25, "");

					if (ord_cosign_reqd_yn.equals("Y")) {
						pstmt_insert.setString(26, pract_id);

						pstmt_insert.setString(27, sys_date);
					}
					else {
						pstmt_insert.setString(26, "");
						pstmt_insert.setString(27, null);
					}
					pstmt_insert.setString(28, null);
					pstmt_insert.setString(29, "N");
					pstmt_insert.setString(30, "CO");
					pstmt_insert.setString(31, this.perf_facility_id); //login_facility_id
					pstmt_insert.setString(32, "PH");
					pstmt_insert.setString(33, location_type);
					pstmt_insert.setString(34, null);
					pstmt_insert.setString(35, pract_id);
					pstmt_insert.setString(36, "N");
					pstmt_insert.setString(37, "N");
					pstmt_insert.setString(38, "");
					pstmt_insert.setString(39, "N");
					pstmt_insert.setString(40,null);
					pstmt_insert.setString(41,null);
					pstmt_insert.setString(42, "");
					pstmt_insert.setString(43, "OS");
					pstmt_insert.setString(44, "");
					pstmt_insert.setString(45, login_by_id);
					pstmt_insert.setString(46, login_at_ws_no);
					pstmt_insert.setString(47, login_facility_id);
					pstmt_insert.setString(48, login_by_id);
					pstmt_insert.setString(49, login_at_ws_no);
					pstmt_insert.setString(50, login_facility_id);
					pstmt_insert.setString(51, ord_consent_reqd_yn);

					if (ord_consent_reqd_yn.equals("Y")) {
						pstmt_insert.setString(52, pract_id);
						pstmt_insert.setString(53, sys_date);
					} 
					else {
						pstmt_insert.setString(52, "");
						pstmt_insert.setString(53, null);
					}
					pstmt_insert.setString(54, "");
					pstmt_insert.setString(55, trn_group_ref); //trn_group_ref
					pstmt_insert.setString(56, (String)commonData.get("CATALOG_SPLTY_CODE")); //CATALOG_SPLTY_CODE
					pstmt_insert.addBatch();
				}  
/*===================dummy record insertion ends here===========================*/
				pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT19A"));
			//ML-MMOH-CRF-0345 - start
				String order_id			 = "";
				//int cycle_order_cunt	 = 0;//Commented for Check Style Report.
				String prev_drug_code 	 = "";
				String cycle_order_index = "";
				for (int i=0; i<temp.size(); i++) {
					HashMap tempMap = (HashMap)temp.get(i);
					if (tempMap!=null && tempMap.size() != 0) {
						drug_desc = drug_desc + tempMap.get("DRUG_DESC").toString() + "|";
						drug_code		  =(String)tempMap.get("DRUG_CODE");
						ocurrance_num		  =(String)tempMap.get("OCURRANCE_NUM");
					//added for ML-MMOH-CRF-0345	- start	
						cycle_freq_yn = (String)tempMap.get("CYCLE_FREQ_YN")==null?"":(String)tempMap.get("CYCLE_FREQ_YN");
						cycle_order_index = (String)tempMap.get("CYCLE_INDEX");
					//added for CRF-435	- start				
						if(cycle_freq_yn.equals("Y")){ 
							/*if(prev_drug_code.equals(drug_code))
								cycle_order_cunt++;
							else
								cycle_order_cunt=0;*/

							order_id			  = orderDetails.get("ORDER_ID_CYCLE"+drug_code+ocurrance_num+cycle_order_index).toString();
						}else{
							  order_id			  = orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
						}
						prev_drug_code = drug_code;
					//added for CRF-435 - end
						order_type_code	  =tempMap.get("ORDER_TYPE_CODE").toString();
						ord_auth_reqd_yn   ="N";
						ord_appr_reqd_yn   ="N";
						ord_cosign_reqd_yn ="N";
						regn_reqd_yn		  ="N";
						ord_consent_reqd_yn="N";
						auth_yn_val		  ="N";
						approval_yn_val	  ="N";
						cosign_yn_val	  ="N";

						pstmt_select.setString(1, order_type_code);
						resultSet		= pstmt_select.executeQuery();

						if (resultSet.next()) {
							regn_reqd_yn = resultSet.getString(1);
						}
						closeResultSet(resultSet);

						if (tempMap.get("ORD_AUTH_REQD_YN").toString().equals("Y"))
							ord_auth_reqd_yn = "Y";

						if (tempMap.get("ORD_SPL_APPR_REQD_YN").toString().equals("Y"))
							ord_appr_reqd_yn = "Y";

						if (tempMap.get("ORD_COSIGN_REQD_YN").toString().equals("Y"))
							ord_cosign_reqd_yn = "Y";


						if (tempMap.get("CONSENT_REQD_YN").toString().equals("Y"))
							ord_consent_reqd_yn = "Y";

					  if (tempMap.get("AUTH_YN_VAL").toString().equals("Y"))
							auth_yn_val 	= "Y";
					 
						if (tempMap.get("APPROVAL_YN_VAL").toString().equals("Y"))
							approval_yn_val 	= "Y";
						if (tempMap.get("COSIGN_YN_VAL").toString().equals("Y"))
							cosign_yn_val 	= "Y";

						if( (ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("N"))){
							ord_status="10";
						}
						else if ((ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("Y"))) {
							if(approval_yn_val!=null && approval_yn_val.equals("Y"))
								ord_status	=	"10";
							else
								ord_status	=	"05";
						}
						else if ((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("N"))) {
							if(auth_yn_val!=null && auth_yn_val.equals("Y"))
								ord_status	=	"10";
							else
								ord_status	="03";
						}
						else if((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("Y"))){
							if((approval_yn_val!=null) && (approval_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val.equals("Y")) ){
								ord_status="10";
							}
							else if(approval_yn_val!=null && approval_yn_val.equals("Y")){
								ord_status="03";
							}
							else {
								ord_status="05";
							}
						}
                       if(tempMap.containsKey("CONSENT_REQD_YN") && tempMap.get("CONSENT_REQD_YN")!=null&&tempMap.containsKey("CONSENT_STAGE") && tempMap.get("CONSENT_STAGE")!=null){

						if(tempMap.get("CONSENT_REQD_YN").equals("Y") && tempMap.get("CONSENT_STAGE").equals("A")){
							order_status = "00"; //PC - Pending consent
						}
					   }
						pstmt_insert.setString(1, order_id);
						pstmt_insert.setString(2, order_type_code);
						pstmt_insert.setString(3, "PH");
						pstmt_insert.setString(4, "PH");
						pstmt_insert.setString(5, getPatId());
						pstmt_insert.setString(6, patient_class);
						pstmt_insert.setString(7, login_facility_id);
						pstmt_insert.setString(8, encounter_id);
						pstmt_insert.setString(9, encounter_id);
						pstmt_insert.setString(10, "");
						pstmt_insert.setString(11, location_type);
						pstmt_insert.setString(12, location_code);
						if(location_type.equals("N")&&patient_class.equals("OP")){
						   pstmt_insert.setString(13, "D");
						}else{
							pstmt_insert.setString(13, "");
						}						
						pstmt_insert.setString(14, order_date);
						pstmt_insert.setString(15, pract_id);
						pstmt_insert.setString(16, priority);
						pstmt_insert.setString(17, ord_auth_reqd_yn);
						pstmt_insert.setString(18, "");
						if (ord_auth_reqd_yn.equals("Y")) {
							pstmt_insert.setString(19, pract_id);
							pstmt_insert.setString(20, sys_date);
						}
						else {
							pstmt_insert.setString(19, "");
							pstmt_insert.setString(20, null);
						}

						pstmt_insert.setString(21, ord_appr_reqd_yn);

						if (ord_appr_reqd_yn.equals("Y")) {
							pstmt_insert.setString(22, pract_id);
							pstmt_insert.setString(23, sys_date);
						}
						else {
							pstmt_insert.setString(22, "");
							pstmt_insert.setString(23, null);
						}

						pstmt_insert.setString(24, ord_cosign_reqd_yn);

						pstmt_insert.setString(25, "");

						if (ord_cosign_reqd_yn.equals("Y")) {
							pstmt_insert.setString(26, pract_id);

							pstmt_insert.setString(27, sys_date);
						}
						else {
							pstmt_insert.setString(26, "");
							pstmt_insert.setString(27, null);
						}
						pstmt_insert.setString(28, null);
						pstmt_insert.setString(29, "N");
						pstmt_insert.setString(30, "CO");
						pstmt_insert.setString(31,  this.perf_facility_id);
						pstmt_insert.setString(32, "PH");
						pstmt_insert.setString(33, location_type);
						//pstmt_insert.setString(34, perf_locn_code);
						pstmt_insert.setString(34, (String)tempMap.get("PERF_LOCN_CODE"));
						pstmt_insert.setString(35, pract_id);
						pstmt_insert.setString(36, "N");
						pstmt_insert.setString(37, "N");
						pstmt_insert.setString(38, "");
						pstmt_insert.setString(39, "Y");
						pstmt_insert.setString(40,dummy_order_id);
						pstmt_insert.setString(41,(String)tempMap.get("IV_PREP_YN"));
						pstmt_insert.setString(42, "");

						if(ord_status.equals("10") || ord_status.equals("25")) {
							if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y"))
								ord_status="25";
							else
								ord_status="10";
							}

						if(ord_status.equals("03"))
							ord_status = (String)orderStatusCode.get("03");
						else if(ord_status.equals("05"))
							ord_status =(String) orderStatusCode.get("05");
						else if(ord_status.equals("10"))
							ord_status =(String) orderStatusCode.get("10");
						else if(ord_status.equals("25"))
							ord_status = (String)orderStatusCode.get("25");
						else if(ord_status.equals("00"))
							ord_status = (String)orderStatusCode.get("00");

						pstmt_insert.setString(43, ord_status);
						pstmt_insert.setString(44, "");
						pstmt_insert.setString(45, login_by_id);
						pstmt_insert.setString(46, login_at_ws_no);
						pstmt_insert.setString(47, login_facility_id);
						pstmt_insert.setString(48, login_by_id);
						pstmt_insert.setString(49, login_at_ws_no);
						pstmt_insert.setString(50, login_facility_id);
						pstmt_insert.setString(51, ord_consent_reqd_yn);

						if (ord_consent_reqd_yn.equals("Y")) {
							pstmt_insert.setString(52, pract_id);
							pstmt_insert.setString(53, sys_date);
						
						} else {
							pstmt_insert.setString(52, "");
							pstmt_insert.setString(53, null);
						
						}
						pstmt_insert.setString(54, "");
						pstmt_insert.setString(55, trn_group_ref); //trn_group_ref
						pstmt_insert.setString(56, (String)commonData.get("CATALOG_SPLTY_CODE")); //CATALOG_SPLTY_CODE
						pstmt_insert.addBatch();
					}
				}
				try{
					closeStatement(pstmt_select);
					closeResultSet(resultSet);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				int[] batch_result = pstmt_insert.executeBatch();
				for (int i=0;i<batch_result.length;i++) {
					if(batch_result[i] < 0  && batch_result[i] != -2 ) {
						result = 0;
						break;
					}
					else {
						result = 1;
					}
				}
			}
				// Header Level Comments
		
			if (header_comments!=null && header_comments.length() > 0 && temp!=null && temp.size() != 0) {

				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT5"));
				pstmt_clob		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT57"));
			//added for ML-MMOH-CRF-0345	- start	
				String order_id = "";
				String prev_drug_code = "";
				String cycle_order_index = "";//added for CRF-345	
				//int cycle_order_cunt = 0;//Commented for Check Style Report.
			//added for ML-MMOH-CRF-0345	- end				
				for (int i=0; i<temp.size(); i++) {
					HashMap tempMap = (HashMap)temp.get(i);
					cycle_freq_yn = "";//added for ML-MMOH-CRF-0345
					if (tempMap!=null && tempMap.size() != 0) {
						String drug_code		= (String)tempMap.get("DRUG_CODE");
						ocurrance_num		= (String)tempMap.get("OCURRANCE_NUM");
				//added for CRF-435	- start						
						cycle_freq_yn = (String)tempMap.get("CYCLE_FREQ_YN")==null?"":(String)tempMap.get("CYCLE_FREQ_YN");
						if(cycle_freq_yn.equals("Y")){ 

							cycle_order_index = (String)tempMap.get("CYCLE_INDEX");
							/* if(prev_drug_code.equals(drug_code))
								cycle_order_cunt++;
							 else
								cycle_order_cunt=0; */

						 order_id			  = orderDetails.get("ORDER_ID_CYCLE"+drug_code+ocurrance_num+cycle_order_index).toString();	

						}else{
							  order_id			  = orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
						}
					//added for CRF-435 - end

						pstmt_insert.setString(1, order_id);
						pstmt_insert.setString(2, "1"); // For Insert it will be "1"
						pstmt_insert.setString(3, login_by_id);
						pstmt_insert.setString(4, login_at_ws_no);
						pstmt_insert.setString(5, login_facility_id);
						pstmt_insert.setString(6, login_by_id);
						pstmt_insert.setString(7, login_at_ws_no);
						pstmt_insert.setString(8, login_facility_id);
						result = pstmt_insert.executeUpdate();
						if(result > 0 ){
							pstmt_clob.setString(1,order_id);
							pstmt_clob.setString(2,"1"); // Action_seq_num
							rset_clob=pstmt_clob.executeQuery();

							if(rset_clob!=null){
								while(rset_clob.next()){
									Clob clb 			= (Clob) rset_clob.getClob(1);
									BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
									bw.write(header_comments,0,header_comments.length());
									bw.flush();
									bw.close();
								}
								result = 1;
							}
						}
						prev_drug_code		= drug_code;//ML-MMOH-CRF-0345 
					}
				}
			}

				// Insertion in or_order_line
			if (result>0) {
				String sql_or_order_line_insert="INSERT INTO OR_ORDER_LINE (ORDER_ID,ORDER_LINE_NUM,ORDER_CATALOG_CODE,CATALOG_DESC,CATALOG_SYNONYM,ORDER_CATALOG_NATURE,ORDER_TYPE_CODE,ORDER_CATEGORY,ORD_DATE_TIME,PRIORITY,ORD_AUTH_REQD_YN,ORD_AUTH_REASON,ORD_APPR_REQD_YN,ORD_COSIGN_REQD_YN,START_DATE_TIME,FORM_CODE,ROUTE_CODE,QTY_VALUE,QTY_UNIT,FREQ_CODE,DURN_VALUE,DURN_TYPE,LINE_FIELDS_DISPLAY_TEXT,ITEM_NARRATION,NEXT_SCHED_DATE,END_DATE_TIME,AUTO_STOP_DATE_TIME,ORDER_QTY,ORDER_UOM,APPT_REQD_YN,APPT_DATE_TIME,APPT_REF_NUM,RESULT_APPLICABLE_YN,BILL_YN,BILLED_YN,CONT_ORDER_IND,REFILL_SINGLE_CONT_ORDER_YN,NUM_OF_REFILLS,CHILD_ORDER_YN,PARENT_ORDER_ID,PARENT_ORDER_LINE_NUM,ORDER_SET_ID,ORDER_SET_LINE_NUM,ORD_PRACT_ID,ORD_SET_DATE_TIME,AMD_PRACT_ID,AMD_DATE_TIME,HOLD_PRACT_ID,HOLD_DATE_TIME,RESUME_PRACT_ID,RESUME_DATE_TIME,DISC_PRACT_ID,DISC_DATE_TIME,CAN_PRACT_ID,CAN_DATE_TIME,ACCESSION_NUM,ACCESSION_LINE_NUM,ORDER_LINE_STATUS,RESULT_LINE_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORD_CONSENT_REQD_YN,CAN_LINE_REASON,CATALOG_SYNONYM_DC,CATALOG_SYNONYM_AD,RESULT_AUTH_REQD_YN,OCURRANCE_NUM, CATALOG_SPLTY_CODE) VALUES (?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?)";
				pstmt_insert = connection.prepareStatement(sql_or_order_line_insert);
				//pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT2"));
				pstmt_insert.clearBatch();

				if(drugList!=null && drugList.size() > 0){
					/*============dummy record insertion starts=================================*/
					String dummy_order_id	= orderDetails.get("ORDER_ID"+"DUMMY").toString();   

					pstmt_insert.setString(1, dummy_order_id);
					pstmt_insert.setString(2, "1");
					pstmt_insert.setString(3, (String) commonData.get("regimen_code"));
					pstmt_insert.setString(4,or_order_catalog_desc);
					pstmt_insert.setString(5, or_order_catalog_desc);
					pstmt_insert.setString(6, "S");
					pstmt_insert.setString(7, dummy_order_type_code);
					pstmt_insert.setString(8, "PH");
					pstmt_insert.setString(9, order_date);
					pstmt_insert.setString(10, priority);
					pstmt_insert.setString(11, "N");
					pstmt_insert.setString(12, "");
					pstmt_insert.setString(13, "N");
					pstmt_insert.setString(14, "N");
					pstmt_insert.setString(15, "");
					pstmt_insert.setString(16, "");
					pstmt_insert.setString(17, "");
					pstmt_insert.setString(18, "");
					pstmt_insert.setString(19, "");
					pstmt_insert.setString(20, "");
					pstmt_insert.setString(21, "");
					pstmt_insert.setString(22, "");
					pstmt_insert.setString(23, "");
					pstmt_insert.setString(24, "");
					pstmt_insert.setString(25, null);
					pstmt_insert.setString(26, "");
					pstmt_insert.setString(27, null);
					pstmt_insert.setString(28, "");
					pstmt_insert.setString(29, "");
					pstmt_insert.setString(30, "N");
					pstmt_insert.setString(31, null);
					pstmt_insert.setString(32, "");
					pstmt_insert.setString(33, "N");
					pstmt_insert.setString(34, "N");
					pstmt_insert.setString(35, "N");
					pstmt_insert.setString(36, "CO");
					pstmt_insert.setString(37, "N");
					pstmt_insert.setString(38, "");
					pstmt_insert.setString(39, "N");
					pstmt_insert.setString(40, "");
					pstmt_insert.setString(41, "");
					pstmt_insert.setString(42, "");
					pstmt_insert.setString(43, "");
					pstmt_insert.setString(44, pract_id);
					pstmt_insert.setString(45, null);
					pstmt_insert.setString(46, "");
					pstmt_insert.setString(47, null);
					pstmt_insert.setString(48, "");
					pstmt_insert.setString(49, null);
					pstmt_insert.setString(50, "");
					pstmt_insert.setString(51, null);
					pstmt_insert.setString(52, "");
					pstmt_insert.setString(53, null);
					pstmt_insert.setString(54, "");
					pstmt_insert.setString(55, null);
					pstmt_insert.setString(56, "");
					pstmt_insert.setString(57, "");
					pstmt_insert.setString(58, "OS");
					pstmt_insert.setString(59, "");
					pstmt_insert.setString(60, login_by_id);
					pstmt_insert.setString(61, login_at_ws_no);
					pstmt_insert.setString(62, login_facility_id);
					pstmt_insert.setString(63, login_by_id);
					pstmt_insert.setString(64, login_at_ws_no);
					pstmt_insert.setString(65, login_facility_id);
					pstmt_insert.setString(66,  "N");
					pstmt_insert.setString(67, "");
					
					catalog_short_desc	= "";
					
					pstmt_insert.setString(68, or_order_catalog_desc);
					pstmt_insert.setString(69, or_order_catalog_desc);
					pstmt_insert.setString(70, "N");
					pstmt_insert.setString(71, null);
					pstmt_insert.setString(72, (String)commonData.get("CATALOG_SPLTY_CODE")); //CATALOG_SPLTY_CODE
					pstmt_insert.addBatch();
					
					/*============dummy record insertion ends here=====================================*/
					pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT19A"));
					pstmt_pres_select53 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
				//ML-MMOH-CRF-0345 - start
					String order_id = "";
					String prev_drug_code = "";
					String mfr_yn = "N";//ML-MMOH-CRF-1014
					//int cycle_order_cunt = 0; //Commented for Check Style Report.
					String cycle_order_index = "";//added for ML-MMOH-CRF-0345	
					for(int j=0;j<drugList.size();j++) {
						HashMap drugDetails = (HashMap)drugList.get(j);
						cycle_freq_yn = "";//ML-MMOH-CRF-0345
						if (drugDetails!=null && drugDetails.size() != 0) {
							line_no = 0;
							auth_yn_val = "N" ;
							approval_yn_val = "N";
							cosign_yn_val = "N";
							mfr_yn = "N";//ML-MMOH-CRF-1014
							String ord_auth_reqd_yn = "N";
							String ord_appr_reqd_yn = "N";
							String ord_cosign_reqd_yn="N";
							String ord_consent_reqd_yn="N";
							String drug_code		= (String)drugDetails.get("DRUG_CODE");
							ocurrance_num		= (String)drugDetails.get("OCURRANCE_NUM");
							mfr_yn				= (String)drugDetails.get("mfr_yn")==null?"N":(String)drugDetails.get("mfr_yn");//ML-MMOH-CRF-1014
							cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
							//added for CRF-345	- start				
							if(cycle_freq_yn.equals("Y")){ 
								  
								cycle_order_index = (String)drugDetails.get("CYCLE_INDEX");

							/*	 if(prev_drug_code.equals(drug_code))
									cycle_order_cunt++;
								 else
									cycle_order_cunt=0; */

								 order_id			  = orderDetails.get("ORDER_ID_CYCLE"+drug_code+ocurrance_num+cycle_order_index).toString();

								}else{
									 order_id			  = orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
								}
							//added for CRF-345 - end
							String order_type_code	= drugDetails.get("ORDER_TYPE_CODE").toString();
							String regn_reqd_yn		= "N";
							amend_stock_value= (String)drugDetails.get("amend_stock_value")==null?"":(String)drugDetails.get("amend_stock_value");
							amend_infusion_period_value = (String)drugDetails.get("amend_infusion_period_value"==null?"":(String)drugDetails.get("amend_infusion_period_value"));
							amend_infusion_period_uom = (String)drugDetails.get("amend_infusion_period_uom")==null?"":(String)drugDetails.get("amend_infusion_period_uom");
							amend_durn_value = (String)drugDetails.get("amend_durn_value")==null?"":(String)drugDetails.get("amend_durn_value");
temp_durn_value = amend_durn_value;
							if(amend_durn_value==null) 
								amend_durn_value = "0";					   
							
							amend_durn_unit = (String)drugDetails.get("amend_durn_unit")==null?"":(String)drugDetails.get("amend_durn_unit");
							amend_start_date = (String)drugDetails.get("amend_start_date")==null?"":(String)drugDetails.get("amend_start_date");
							amend_end_date = (String)drugDetails.get("amend_end_date")==null?"":(String)drugDetails.get("amend_end_date");
							amend_frequency = (String)drugDetails.get("amend_frequency")==null?"":(String)drugDetails.get("amend_frequency");
							amend_repeat_value = (String)drugDetails.get("amend_repeat_value")==null?"":(String)drugDetails.get("amend_repeat_value");
						//	ML-MMOH-CRF-0345 - start
							if(cycle_freq_yn.equals("Y")){ 
							amend_start_date = (String)drugDetails.get("CYCLE_START_DATE")==null?"":(String)drugDetails.get("CYCLE_START_DATE");
							amend_end_date = (String)drugDetails.get("CYCLE_END_DATE")==null?"":(String)drugDetails.get("CYCLE_END_DATE");
							freq_chng_durn_desc = (String)drugDetails.get("CYCLE_FREQ_DURN_TYPE")==null?"D":(String)drugDetails.get("CYCLE_FREQ_DURN_TYPE");
							}
						// ML-MMOH-CRF-0345 - end
							
							dose 			= (String)drugDetails.get("dose");
							if(dose==null) 	dose = "";

							freq_chng_durn_desc =	(String)drugDetails.get("freq_chng_durn_desc");
							
							if(!freq_chng_durn_desc.equals(amend_durn_unit)){
								temp_durn_value = (String)getFreqDurnConvValue(freq_chng_durn_desc,amend_durn_value,amend_durn_unit);

							}

							resultSet		= null;
							pstmt_select.setString(1, order_type_code);
							resultSet		= pstmt_select.executeQuery();
								if (resultSet.next()) {
								regn_reqd_yn = resultSet.getString(1);
							}

							if (drugDetails.get("ORD_AUTH_REQD_YN").toString().equals("Y"))
								ord_auth_reqd_yn = "Y";

							if (drugDetails.get("ORD_SPL_APPR_REQD_YN").toString().equals("Y"))
								ord_appr_reqd_yn = "Y";

							if (drugDetails.get("ORD_COSIGN_REQD_YN").toString().equals("Y"))
								ord_cosign_reqd_yn = "Y";

							if (drugDetails.get("CONSENT_REQD_YN").toString().equals("Y"))
								ord_consent_reqd_yn = "Y";

							if (drugDetails.get("AUTH_YN_VAL").toString().equals("Y"))
								auth_yn_val 	= "Y";
							if (drugDetails.get("APPROVAL_YN_VAL").toString().equals("Y"))
								approval_yn_val 	= "Y";
							if (drugDetails.get("COSIGN_YN_VAL").toString().equals("Y"))
								cosign_yn_val 	= "Y";

							if( (ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("N"))){
								ord_status="10";
							}
							else if ((ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("Y"))) {
								if(approval_yn_val!=null && approval_yn_val.equals("Y"))
									ord_status	=	"10";
								else
									ord_status	=	"05";
							}
							else if ((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("N"))) {
								if(auth_yn_val!=null && auth_yn_val.equals("Y"))
									ord_status	=	"10";
								else
									ord_status	="03";
							}
							else if((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("Y"))){
								if((approval_yn_val!=null) && (approval_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val.equals("Y")) ){
									ord_status="10";
								}
								else if(approval_yn_val!=null && approval_yn_val.equals("Y")){
									ord_status="03";
								}
								else {
									ord_status="05";
								}
							}
							if(drugDetails.containsKey("CONSENT_REQD_YN") && drugDetails.get("CONSENT_REQD_YN")!=null&& drugDetails.containsKey("CONSENT_STAGE") && drugDetails.get("CONSENT_STAGE")!=null){
								if(drugDetails.get("CONSENT_REQD_YN").equals("Y") && drugDetails.get("CONSENT_STAGE").equals("A")){
									order_status = "00"; //PC - Pending consent
								}
							}
							if(ord_status.equals("10") || ord_status.equals("25")) {
								if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y"))
									ord_status="25";
								else
									ord_status="10";
							}

							if(ord_status.equals("03"))
								ord_status = (String)orderStatusCode.get("03");
							else if(ord_status.equals("05"))
								ord_status =(String) orderStatusCode.get("05");
							else if(ord_status.equals("10"))
								ord_status =(String) orderStatusCode.get("10");
							else if(ord_status.equals("25"))
								ord_status = (String)orderStatusCode.get("25");
							else if(ord_status.equals("00"))
								ord_status = (String)orderStatusCode.get("00");

						// If Fluid Details are there add it

							if (fluidDetails!=null && fluidDetails.size() > 0) {
								HashMap tempFluidMap = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);

								if (tempFluidMap!=null && tempFluidMap.size()>0) {
									strength_uom	= (String)tempFluidMap.get("STRENGTH_UOM");
									pres_base_uom	= (String)tempFluidMap.get("PRES_BASE_UOM");
									strength_per_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_PRES_UOM");
									strength_per_value_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM");
									dosage_type		= (String)tempFluidMap.get("DOSAGE_TYPE");
									freq_nature	= (String)tempFluidMap.get("FREQ_NATURE")==null?"F":(String)tempFluidMap.get("FREQ_NATURE");
									repeat_durn_type	= (String)tempFluidMap.get("REPEAT_DURN_TYPE")==null?"D":(String)tempFluidMap.get("REPEAT_DURN_TYPE");
									freq_value	= (String)tempFluidMap.get("FREQ_VALUE")==null?"0":(String)tempFluidMap.get("FREQ_VALUE");
									repeat_value	= (String)tempFluidMap.get("REPEAT_VALUE")==null?"0":(String)tempFluidMap.get("REPEAT_VALUE");

									pack_size	= (String)tempFluidMap.get("FLUID_PACK_SIZE");
									stock_uom	= (String)tempFluidMap.get("STOCK_UOM");

									if(!amend_stock_value.equals("")&&amend_stock_value!=null){
										order_qty	= (Math.ceil((Float.parseFloat(amend_stock_value)) / Float.parseFloat(pack_size)))+"";	
//										order_qty		= (Math.ceil((Float.parseFloat(order_qty)) * (Float.parseFloat(amend_durn_value))*(Float.parseFloat(amend_repeat_value))))+"";
										order_qty		= (Math.ceil((Float.parseFloat(order_qty)) * (Float.parseFloat(temp_durn_value))*(Float.parseFloat(amend_repeat_value))))+"";
										order_qty=new Float(order_qty).intValue()+"";	
										in_qty_unit 	= pres_base_uom ;
									}
									if(ord_qty==0) 
										ord_qty 			= 0.0f;
									if(ord_qty_value==0) 
										ord_qty_value 		= 0.0f;
									if(fluid_qty==0) 
										fluid_qty 			= 0.0f;
									if(fluid_qty_value==0) 
										fluid_qty_value 	= 0.0f;

									pstmt_insert.setString(1, order_id);
									line_no++;
									total_line_num++;
									pstmt_insert.setString(2, String.valueOf(line_no));

									pstmt_insert.setString(3, (String)tempFluidMap.get("DRUG_CODE"));
									pstmt_insert.setString(4, (String)tempFluidMap.get("SHORT_DESC"));
									pstmt_insert.setString(5, (String)tempFluidMap.get("SHORT_DESC"));
									pstmt_insert.setString(6, "A");
									pstmt_insert.setString(7, (String)tempFluidMap.get("ORDER_TYPE_CODE"));
									pstmt_insert.setString(8, "PH");

									pstmt_insert.setString(9, order_date);
									pstmt_insert.setString(10, priority);
									pstmt_insert.setString(11, ord_auth_reqd_yn);
									pstmt_insert.setString(12, "");
									pstmt_insert.setString(13, ord_consent_reqd_yn);
									pstmt_insert.setString(14, ord_cosign_reqd_yn);

									pstmt_insert.setString(15, amend_start_date);
									pstmt_insert.setString(16, (String)tempFluidMap.get("FORM_CODE"));
									pstmt_insert.setString(17, (String)tempFluidMap.get("ROUTE_CODE"));

									in_qty_value	= String.valueOf(fluid_qty_value);
									in_qty_unit 	= pres_base_uom ;

									if(in_qty_value==null) in_qty_value	= "";
									if(in_qty_unit==null) in_qty_unit	= "";
									ord_qty			= fluid_qty;
									equl_value		= "";
									pstmt_insert.setString(18, amend_stock_value);
									pstmt_insert.setString(19, in_qty_unit);
									pstmt_insert.setString(20, amend_frequency);
//ML-MMOH-CRF-1014 - start
									if(mfr_yn.equals("Y")){
										HashMap Mfr_rec_details =(HashMap)Mfr_details.get(drug_code+ocurrance_num);
										System.err.println("OncologyRegimenBean.java===Mfr_rec_details==5028=>"+Mfr_rec_details);
										if(Mfr_rec_details!=null && Mfr_rec_details.size() > 0)
											pstmt_insert.setString(21, ((String)((HashMap)Mfr_details.get(drug_code+ocurrance_num)).get("totDurnHrs")));	
										else
											pstmt_insert.setString(21, amend_durn_value);

										
									}else{
										pstmt_insert.setString(21, amend_durn_value);
									}
//ML-MMOH-CRF-1014 - end
									pstmt_insert.setString(22, amend_durn_unit);

									line_display_text		= "";

									if (drugRemarks!=null && drugRemarks.size() > 0) {
										HashMap DrugValues = (HashMap)drugRemarks.get(0);

										line_display_text = (String)DrugValues.get("order_format_values");
										if(line_display_text.length() > 499)
											line_display_text = line_display_text.substring(0,499);
									}
									else {
										line_display_text = "";
									}
									pstmt_insert.setString(23, line_display_text);
									pstmt_insert.setString(24, "");
									pstmt_insert.setString(25, null);
									pstmt_insert.setString(26, amend_end_date);
									pstmt_insert.setString(27, null);
									tempFluidMap.put("FINAL_ORD_QTY",order_qty+"");

									pstmt_insert.setString(28, order_qty);
									pstmt_insert.setString(29, stock_uom);
									pstmt_insert.setString(30, "N");
									pstmt_insert.setString(31, null);
									pstmt_insert.setString(32, "");
									pstmt_insert.setString(33, "N");
									pstmt_insert.setString(34, "N");
									pstmt_insert.setString(35, "N");
									pstmt_insert.setString(36, "CO");
									pstmt_insert.setString(37, "N");
									pstmt_insert.setString(38, "");
									pstmt_insert.setString(39, "N");
									pstmt_insert.setString(40, "");
									pstmt_insert.setString(41, "");

									pstmt_insert.setString(42, dummy_order_id);
									pstmt_insert.setString(43, "");
									pstmt_insert.setString(44, pract_id);
									pstmt_insert.setString(45, null);
									pstmt_insert.setString(46, "");
									pstmt_insert.setString(47, null);
									pstmt_insert.setString(48, "");
									pstmt_insert.setString(49, null);
									pstmt_insert.setString(50, "");
									pstmt_insert.setString(51, null);
									pstmt_insert.setString(52, "");
									pstmt_insert.setString(53, null);
									pstmt_insert.setString(54, "");
									pstmt_insert.setString(55, null);
									pstmt_insert.setString(56, "");
									pstmt_insert.setString(57, "");
									pstmt_insert.setString(58, ord_status);
									pstmt_insert.setString(59, "");
									pstmt_insert.setString(60, login_by_id);
									pstmt_insert.setString(61, login_at_ws_no);
									pstmt_insert.setString(62, login_facility_id);
									pstmt_insert.setString(63, login_by_id);
									pstmt_insert.setString(64, login_at_ws_no);
									pstmt_insert.setString(65, login_facility_id);

									pstmt_insert.setString(66,  ord_consent_reqd_yn);
									pstmt_insert.setString(67, "");
								  
									catalog_short_desc = (String)tempFluidMap.get("DRUG_DESC");
									if(catalog_short_desc!=null && catalog_short_desc.length()>39){
									   catalog_short_desc=catalog_short_desc.substring(0,39);
									 }
									 else{
										 catalog_short_desc=catalog_short_desc;
									 }
									if(catalog_short_desc==null || catalog_short_desc.equals(""))
									catalog_short_desc	= "";

									
									pstmt_insert.setString(68, catalog_short_desc);
									pstmt_insert.setString(69, catalog_short_desc);
									pstmt_insert.setString(70, "N");
									if(cycle_freq_yn.equals("Y")) //ML-MMOH-CRF-1227.1
										pstmt_insert.setString(71, (String)drugDetails.get("CYCLE_OCURRANCE_NUM"));
									else
									pstmt_insert.setString(71, ocurrance_num);
									pstmt_insert.setString(72, (String)commonData.get("CATALOG_SPLTY_CODE")); //CATALOG_SPLTY_CODE
									pstmt_insert.addBatch();
								}
							}

							dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
							qty_unit		= (String)drugDetails.get("QTY_DESC_CODE");
							repeat_value	= (String)drugDetails.get("REPEAT_VALUE")==null?"0":(String)drugDetails.get("REPEAT_VALUE");
							durn_value		= (String)drugDetails.get("DURN_VALUE");
							durn_desc		= (String)drugDetails.get("amend_durn_type");//durn_desc		= (String)drugDetails.get("DURN_TYPE");//priya
							strength_value	= (String)drugDetails.get("ACT_STRENGTH_VALUE");
							strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
							pres_base_uom	= (String)drugDetails.get("PRES_BASE_UOM");
							strength_per_pres_uom = (String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"0":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
							strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");

							freq_nature	= (String)drugDetails.get("FREQ_NATURE")==null?"F":(String)drugDetails.get("FREQ_NATURE");
							repeat_durn_type = (String)drugDetails.get("REPEAT_DURN_TYPE")==null?"D":(String)drugDetails.get("REPEAT_DURN_TYPE");
							freq_value	= (String)drugDetails.get("FREQ_VALUE")==null?"0":(String)drugDetails.get("FREQ_VALUE");
							stock_uom			= (String)drugDetails.get("STOCK_UOM");

					
							// calculation of the freq_value -ASRN;
							String int_value_tmp=(String)drugDetails.get("INTERVAL_VALUE")==null?"1":(String)drugDetails.get("INTERVAL_VALUE");

							// For Drug Based
							if (dosage_type.equals("Q")) {
								dose	= dose;
							}
							/*---------order qty calculation--------------------------------*/
							String fract_dose    = (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
							strength_per_pres_uom		= (String)drugDetails.get("STRENGTH_PER_PRES_UOM");
							content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
							if (dosage_type.equals("S")) {
								//for Strength based
								ing_unit_qty	= Float.parseFloat((String)drugDetails.get("dose"));

								float in_tot_qty	= 0.0f;
								if(fract_dose.equals("Y")){
								  in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
								}
								else{
									in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
								}    

								if (freq_nature.equals("I")) {
									ing_order_qty = in_tot_qty*(Float.parseFloat(durn_value))*(24/(Float.parseFloat(int_value_tmp)));
								}
								else if (freq_nature.equals("F") || freq_nature.equals("Y") || freq_nature.equals("C")) {//freq_nature.equals("Y") added  for ML-MMOH-CRF-0345
//									ing_order_qty = in_tot_qty*(Float.parseFloat(repeat_value))*(Float.parseFloat(amend_durn_value));
									ing_order_qty = in_tot_qty*(Float.parseFloat(repeat_value))*(Float.parseFloat(temp_durn_value));

								}
								else if (freq_nature.equals("O") || freq_nature.equals("P")) {
									ing_order_qty = in_tot_qty;
								}
								ing_order_qty	=   new Double(Math.ceil((ing_order_qty)/Float.parseFloat(content_in_pres_base_uom))).floatValue();							
					   
							} 
							else{//for quantity based
								ing_unit_qty	= Float.parseFloat((String)drugDetails.get("dose"));

								equl_value	= "1";
								resultSet			= null;
								//pstmt_pres_select53 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
								pstmt_pres_select53.setString(1, ing_order_uom);
								pstmt_pres_select53.setString(2, qty_unit);
								pstmt_pres_select53.setString(3, ing_order_uom);
								pstmt_pres_select53.setString(4, qty_unit);
								resultSet	= pstmt_pres_select53.executeQuery();
								if (resultSet.next()) {
									equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
								}
								float in_tot_qty	= 0.0f;

								if(fract_dose.equals("Y")){
									in_tot_qty	=new Double(Math.ceil(ing_unit_qty/(Float.parseFloat(content_in_pres_base_uom)))).floatValue() * Float.parseFloat(equl_value);						
								}
								else{
									in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
								}

								if (freq_nature.equals("I")) {
									ing_order_qty = in_tot_qty*(Float.parseFloat(durn_value))*(24/(Float.parseFloat(int_value_tmp)));
								}
								else if (freq_nature.equals("F") || freq_nature.equals("Y") || freq_nature.equals("C")) {//freq_nature.equals("Y")  added for ML-MMOH-CRF-0345
//									ing_order_qty = in_tot_qty*(Float.parseFloat(repeat_value))*(Float.parseFloat(amend_durn_value));
									ing_order_qty = in_tot_qty*(Float.parseFloat(repeat_value))*(Float.parseFloat(temp_durn_value));

								}
								else if (freq_nature.equals("O") || freq_nature.equals("P")) {
									ing_order_qty = in_tot_qty;
								}                 

								if(!fract_dose.equals("Y")){
									ing_order_qty	=   new Double(Math.ceil((ing_order_qty)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
								}
							}

							line_no++;
							total_line_num++;
							prev_drug_code = drug_code; //added for ML-MMOH-CRF-0345
							pstmt_insert.setString(1, order_id);
							pstmt_insert.setString(2, String.valueOf(line_no));
							pstmt_insert.setString(3, (String)drugDetails.get("DRUG_CODE"));
							pstmt_insert.setString(4, (String)drugDetails.get("SHORT_DESC"));
							pstmt_insert.setString(5, (String)drugDetails.get("SHORT_DESC"));
							pstmt_insert.setString(6, "A");
							pstmt_insert.setString(7, (String)drugDetails.get("ORDER_TYPE_CODE"));
							pstmt_insert.setString(8, "PH");
							pstmt_insert.setString(9, order_date);
							pstmt_insert.setString(10, priority);
							pstmt_insert.setString(11, (String)drugDetails.get("ORD_AUTH_REQD_YN"));
							pstmt_insert.setString(12, "");
							pstmt_insert.setString(13, (String)drugDetails.get("ORD_SPL_APPR_REQD_YN"));
							pstmt_insert.setString(14, (String)drugDetails.get("ORD_COSIGN_REQD_YN"));
							pstmt_insert.setString(15, amend_start_date);
							pstmt_insert.setString(16, (String)drugDetails.get("FORM_CODE"));
							pstmt_insert.setString(17, (String)drugDetails.get("ROUTE_CODE"));

							if (dosage_type.equals("Q"))
								in_qty_value	= String.valueOf(ord_qty_value);
							in_qty_unit 	= pres_base_uom ;

							if(in_qty_value==null) 
								in_qty_value	= "";
							if(in_qty_unit==null) 
								in_qty_unit	= "";
							ord_qty				= ord_qty;
							equl_value		= "";
							pstmt_insert.setString(18, (String)drugDetails.get("dose"));
							pstmt_insert.setString(19, (String)drugDetails.get("drug_unit_code"));
							pstmt_insert.setString(20, amend_frequency);
							pstmt_insert.setString(21, amend_durn_value);
							pstmt_insert.setString(22, amend_durn_unit);

							line_display_text		= "";
							if (drugRemarks!=null && drugRemarks.size() > 0) {
								if (drugRemarks.size() > j) {
									HashMap DrugValues = (HashMap)drugRemarks.get(j);
									line_display_text = (String)DrugValues.get("order_format_values");
									if(line_display_text.length() > 499)
										line_display_text = line_display_text.substring(0,499);
								}
								else {
									line_display_text = "";
								}
							}	
							else {
								line_display_text = "";
							}

							pstmt_insert.setString(23, line_display_text);
							pstmt_insert.setString(24, "");
							pstmt_insert.setString(25, null);
							pstmt_insert.setString(26, amend_end_date);
							pstmt_insert.setString(27, null);
							drugDetails.put("FINAL_ORD_QTY",ing_order_qty+"");
							pstmt_insert.setString(28, ing_order_qty+"");					
							pstmt_insert.setString(29, stock_uom); 

							pstmt_insert.setString(30, "N");
							pstmt_insert.setString(31, null);
							pstmt_insert.setString(32, "");
							pstmt_insert.setString(33, "N");
							pstmt_insert.setString(34, "N");
							pstmt_insert.setString(35, "N");
							pstmt_insert.setString(36, "CO");
							pstmt_insert.setString(37, "N");
							pstmt_insert.setString(38, "");
							pstmt_insert.setString(39, "N");
							pstmt_insert.setString(40, "");
							pstmt_insert.setString(41, "");
							pstmt_insert.setString(42, dummy_order_id);
							pstmt_insert.setString(43, "");
							pstmt_insert.setString(44, pract_id);
							pstmt_insert.setString(45, null);
							pstmt_insert.setString(46,"");
							pstmt_insert.setString(47, null);
							pstmt_insert.setString(48, "");
							pstmt_insert.setString(49, null);
							pstmt_insert.setString(50, "");
							pstmt_insert.setString(51, null);
							pstmt_insert.setString(52, "");

							pstmt_insert.setString(53, null);
							pstmt_insert.setString(54, "");
							pstmt_insert.setString(55, null);
							pstmt_insert.setString(56, "");
							pstmt_insert.setString(57, "");
							pstmt_insert.setString(58, ord_status);
							pstmt_insert.setString(59, "");
							pstmt_insert.setString(60, login_by_id);
							pstmt_insert.setString(61, login_at_ws_no);
							pstmt_insert.setString(62, login_facility_id);
							pstmt_insert.setString(63, login_by_id);
							pstmt_insert.setString(64, login_at_ws_no);
							pstmt_insert.setString(65, login_facility_id);

							pstmt_insert.setString(66, (String)drugDetails.get("CONSENT_REQD_YN"));
							pstmt_insert.setString(67, "");
							catalog_short_desc = (String)drugDetails.get("DRUG_DESC");
							if(catalog_short_desc!=null && catalog_short_desc.length()>39){
							   catalog_short_desc=catalog_short_desc.substring(0,39);
							}
							else{
							   catalog_short_desc=catalog_short_desc;
							}
							if(catalog_short_desc==null || catalog_short_desc.equals(""))
							catalog_short_desc	= "";								
							pstmt_insert.setString(68, catalog_short_desc);
							pstmt_insert.setString(69, catalog_short_desc);
							pstmt_insert.setString(70, "N");
							if(cycle_freq_yn.equals("Y"))//ML-MMOH-CRF-1227.1
								pstmt_insert.setString(71, (String)drugDetails.get("CYCLE_OCURRANCE_NUM"));
							else
							pstmt_insert.setString(71, ocurrance_num);
							pstmt_insert.setString(72, (String)drugDetails.get("CATALOG_SPLTY_CODE")); //CATALOG_SPLTY_CODE
							pstmt_insert.addBatch();
						}
					}
					
						int[] batch_result = pstmt_insert.executeBatch();
					
					for (int i=0;i<batch_result.length;i++) {
						if(batch_result[i] < 0  && batch_result[i] != -2 ) {
							result = 0;
							break;
						} 
						else {
							result = 1;
						}
					}
					
				}
			}
	//INSERT INTO OR_ORDER_LINE_PH
			if (result>0) {
			//	pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT3B"));
			pstmt_insert = connection.prepareStatement("INSERT INTO or_order_line_ph (order_id, order_line_num, generic_id, form_code, trade_code, formulary_item_yn, dosage_type, split_drug_preview, tot_strength, tot_strength_uom, infuse_over, infuse_over_unit, infusion_rate, infusion_vol_str_unit, infusion_per_unit, brought_by_patient_yn, cur_drug_yn, refill_drug_yn, dispensing_loc_type, dispensing_loc, dispensing_store, ip_fill_process, ip_fill_prd_ahead, next_fill_date, last_fill_qty, dispensed_qty, bms_qty, bms_strength, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, split_dose_yn, qty_value_split_dose, qty_unit_split_dose, strength_value, strength_uom, pres_qty_value, pres_qty_uom, allergy_override_reason, dosage_limit_override_reason, duplicate_drug_override_reason, patient_brought_medication_yn, amend_reason_code, amend_reason, pat_couns_reqd_yn, intention_code, stage_code, tot_infusion_over, tot_infusion_over_unit, chngd_fluid_remarks, build_mar_yn, bl_incl_excl_override_value, bl_incl_excl_override_reason, calc_dose, calc_dose_uom, calc_dose_by, calc_dose_based_on, orig_infuse_over, orig_infusion_rate, drug_indication, mfr_yn, mfr_remarks, allow_alternate_yn,ALLERGY_OVERRIDE_REASON_CODE,DOSE_LIMIT_OVER_REASON_CODE,DUP_DRUG_OVERRIDE_REASON_CODE ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,? )");//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938],Modified for IN:072715
		//MFR_YN and MFR_REMARKS added for ML-MMOH-CRF-1014
				pstmt_insert.clearBatch();
				if(drugList!=null && drugList.size() > 0) {
					pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
			//ML-MMOH-CRF-0345 - start
					String order_id = "";
					//int cycle_order_cunt = 0; //Commented for Check Style Report.
					String 	cycle_order_index = "";//ML-MMOH-CRF-0345
					String prev_drug_code = "";
					String mfr_yn		  = "";//ML-MMOH-CRF-1014
					String mfr_remarks_insert = "";//ML-MMOH-CRF-1014
					String allow_alternate = "";//GHL-CRF-0549
			//ML-MMOH-CRF-0345 - end
					for(int j=0;j<drugList.size();j++) {
						HashMap drugDetails = (HashMap)drugList.get(j);
						cycle_freq_yn = "";//ML-MMOH-CRF-0345
						mfr_yn		  = "";//ML-MMOH-CRF-1014
						allow_alternate = "N";//GHL-CRF-0549
						if(drugDetails!=null && drugDetails.size() > 0){
							line_no = 0;
							String drug_code		= (String)drugDetails.get("DRUG_CODE");
							ocurrance_num		= (String)drugDetails.get("OCURRANCE_NUM");
							allow_alternate	= (String)drugDetails.get("allow_alternate")==null?"N":(String)drugDetails.get("allow_alternate");//GHL-CRF-0549
						//ML-MMOH-CRF-0345 - start
							cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
								if(cycle_freq_yn.equals("Y")){ 
										cycle_order_index = (String)drugDetails.get("CYCLE_INDEX");
									
									 /*if(prev_drug_code.equals(drug_code))
										cycle_order_cunt++;
									 else
										cycle_order_cunt=0;*/

								 order_id			  = orderDetails.get("ORDER_ID_CYCLE"+drug_code+ocurrance_num+cycle_order_index).toString();
				
								}else{
									  order_id			  = orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
								}
							//added for CRF-345 - end

							dose 			= (String)drugDetails.get("dose")==null?"1":(String)drugDetails.get("dose");
							prev_drug_code  = drug_code;//ML-MMOH-CRF-0345
							calc_dose 			= 
							(String)drugDetails.get("calc_dose")==null?"":(String)drugDetails.get("calc_dose");
							calc_dose_uom 			= (String)drugDetails.get("calc_dose_uom")==null?"":(String)drugDetails.get("calc_dose_uom");
							calc_dose_by 			= (String)drugDetails.get("calc_dose_by")==null?"":(String)drugDetails.get("calc_dose_by");
							calc_dose_based_on		= (String)drugDetails.get("CALC_DOSE_BASED_ON")==null?"B":(String)drugDetails.get("CALC_DOSE_BASED_ON");

							amend_stock_value= (String)drugDetails.get("amend_stock_value");
							amend_infusion_period_value = (String)drugDetails.get("amend_infusion_period_value");
							amend_infusion_period_uom = (String)drugDetails.get("amend_infusion_period_uom");
							amend_infusion_rate = (String)drugDetails.get("amend_infusion_rate");
							amend_durn_value = (String)drugDetails.get("amend_durn_value")==null?"0":(String)drugDetails.get("amend_durn_value");
							temp_durn_value = amend_durn_value;
							amend_durn_unit = (String)drugDetails.get("amend_durn_unit");
							amend_end_date = (String)drugDetails.get("amend_end_date");
							amend_start_date = (String)drugDetails.get("amend_start_date");
							amend_frequency = (String)drugDetails.get("amend_frequency");
							amend_repeat_value	= (String)drugDetails.get("amend_repeat_value");
							dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
							strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
							pres_base_uom	= (String)drugDetails.get("PRES_BASE_UOM");
							drug_indication	= (String)drugDetails.get("DRUG_INDICATION");//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]
							mfr_yn			= (String)drugDetails.get("mfr_yn")==null?"N":(String)drugDetails.get("mfr_yn");//ML-MMOH-CRF-1014 - start
							if(mfr_yn.equals("Y")){
								mfr_remarks_insert = (String)mfr_remarks.get(drug_code+ocurrance_num)==null?"":(String)mfr_remarks.get(drug_code+ocurrance_num);
							}//ML-MMOH-CRF-1014 - end
							freq_chng_durn_desc =	(String)drugDetails.get("freq_chng_durn_desc");
							
							if(!freq_chng_durn_desc.equals(amend_durn_unit)){
								temp_durn_value = (String)getFreqDurnConvValue(freq_chng_durn_desc,amend_durn_value,amend_durn_unit);

							}

							infusion_vol_str_unit="";
							if(dosage_type.equals("S")) {
								infusion_vol_str_unit=strength_uom;
							}
							else{                              
								infusion_vol_str_unit=pres_base_uom;
							}

							tot_infuse_over="";
							if(amend_infusion_period_value!=null && !amend_infusion_period_value.equals("")&& !amend_infusion_rate.equals("")&&amend_infusion_rate!=null){
								
//								tot_infuse_over=(Float.parseFloat(amend_infusion_period_value)*Float.parseFloat(amend_infusion_rate)*Integer.parseInt(amend_durn_value)*Integer.parseInt(amend_repeat_value))+"";

							tot_infuse_over=(Float.parseFloat(amend_infusion_period_value)*Float.parseFloat(amend_infusion_rate)*Integer.parseInt(temp_durn_value)*Integer.parseInt(amend_repeat_value))+"";

							}

							if (fluidDetails!=null  && fluidDetails.size() != 0) {
								HashMap tempFluidMap = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);
				
								if (tempFluidMap!=null && tempFluidMap.size() != 0) {
									if(tempFluidMap.size() > 0 ){
										dosage_type		= (String)tempFluidMap.get("DOSAGE_TYPE");
										qty_unit		= (String)tempFluidMap.get("QTY_DESC_CODE");
										repeat_value	= (String)tempFluidMap.get("REPEAT_VALUE")==null?"0":(String)tempFluidMap.get("REPEAT_VALUE");
										durn_value		= (String)tempFluidMap.get("DURN_VALUE");
										durn_desc		= (String)tempFluidMap.get("DURN_TYPE");
										strength_value	= (String)tempFluidMap.get("ACT_STRENGTH_VALUE");
										strength_uom	= (String)tempFluidMap.get("STRENGTH_UOM");
										pres_base_uom	= (String)tempFluidMap.get("PRES_BASE_UOM");
										strength_per_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_PRES_UOM");
										strength_per_value_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM");
										infusion_vol_str_unit=pres_base_uom;
										
										resultSet			= null;
										pstmt_select.setString(1, amend_frequency);
										pstmt_select.setString(2, dose);
										pstmt_select.setString(3, amend_stock_value);
			//							pstmt_select.setString(4, amend_durn_value);
										pstmt_select.setString(4, temp_durn_value);



										resultSet	= pstmt_select.executeQuery();

										if (resultSet.next()) {
											comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
										}

										if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
											StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
											while(stQty.hasMoreTokens()){
												ord_qty				  =  Float.parseFloat(stQty.nextToken());
												ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
												fluid_qty			  =  Float.parseFloat(stQty.nextToken());
												fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
											}
										}
										if(ord_qty==0) 
											ord_qty 			= 0.0f;
										if(ord_qty_value==0) 
											ord_qty_value 		= 0.0f;
										if(fluid_qty==0) 
											fluid_qty 			= 0.0f;
										if(fluid_qty_value==0) 
											fluid_qty_value 	= 0.0f;


										in_qty_value	= String.valueOf(fluid_qty_value);
										in_qty_unit 	= pres_base_uom ;

										if(in_qty_value==null) 
											in_qty_value	= "";
										if(in_qty_unit==null) 
											in_qty_unit	= "";
										ord_qty				= fluid_qty;
										equl_value			= "";
										//Only Quantity based for Fluid
										in_tot_strength		= ""; // for Qty_based
										in_tot_strength_uom	= ""; // for Qty_based
										in_bms_qty			= String.valueOf(ord_qty)	; //Equivalent to qty_value
										in_strength_value	= in_tot_strength;
										in_strength_uom		= in_tot_strength_uom;
										in_pres_qty_value	= new Float(Float.parseFloat(in_bms_qty)).intValue()+""; 	//Equivalent to bms_qty
				
										in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit
								  /*==code for calculating TOTAL STRENGTH======*/
										if(dosage_type.equals("S")){
											fld_strength_value = (String)tempFluidMap.get("STRENGTH_VALUE");
				//							fld_tot_strength    =(Math.ceil(Float.parseFloat(fld_strength_value)*Float.parseFloat(amend_durn_value)*Float.parseFloat(amend_repeat_value)))+"";

											fld_tot_strength    =(Math.ceil(Float.parseFloat(fld_strength_value)*Float.parseFloat(temp_durn_value)*Float.parseFloat(amend_repeat_value)))+"";

										}
									 /*===============ends here================*/
										pstmt_insert.setString(1, order_id);

										pstmt_insert.setInt(2, ++line_no);
										pstmt_insert.setString(3, (String)tempFluidMap.get("GENERIC_ID"));
										pstmt_insert.setString(4, (String)tempFluidMap.get("FORM_CODE"));
										pstmt_insert.setString(5, "");
										pstmt_insert.setString(6, (String)tempFluidMap.get("IN_FORMULARY_YN"));
										pstmt_insert.setString(7, (String)tempFluidMap.get("DOSAGE_TYPE"));
										pstmt_insert.setString(8, "");
										pstmt_insert.setString(9, fld_tot_strength);
										pstmt_insert.setString(10, in_tot_strength_uom);
										pstmt_insert.setString(11, amend_infusion_period_value);
										pstmt_insert.setString(12,amend_infusion_period_uom);
										pstmt_insert.setString(13, amend_infusion_rate);
										pstmt_insert.setString(14, infusion_vol_str_unit);
										pstmt_insert.setString(15,amend_infusion_period_uom);
										pstmt_insert.setString(16, "N");
										pstmt_insert.setString(17, "N");
										pstmt_insert.setString(18, "N");
										pstmt_insert.setString(19, "P");
										pstmt_insert.setString(20, (String)drugDetails.get("PERF_LOCN_CODE"));
										pstmt_insert.setString(21, "");
										pstmt_insert.setString(22, "");
										pstmt_insert.setString(23, "");
										pstmt_insert.setString(24, null);
										pstmt_insert.setString(25, "");
										pstmt_insert.setString(26, "");

										pstmt_insert.setString(27, (String)tempFluidMap.get("FINAL_ORD_QTY"));
										pstmt_insert.setString(28, fld_tot_strength);

										pstmt_insert.setString(29, login_by_id);
										pstmt_insert.setString(30, login_at_ws_no);
										pstmt_insert.setString(31, login_facility_id);
										pstmt_insert.setString(32, login_by_id);
										pstmt_insert.setString(33, login_at_ws_no);
										pstmt_insert.setString(34, login_facility_id);
										pstmt_insert.setString(35, (String)tempFluidMap.get("SPLIT_DOSE"));

										if (((String)tempFluidMap.get("SPLIT_DOSE")) !=null && ((String)tempFluidMap.get("SPLIT_DOSE")).equals("Y")) {
											pstmt_insert.setString(36, (String)tempFluidMap.get("QTY_VALUE"));
											pstmt_insert.setString(37, "");

										}
										else {
											pstmt_insert.setString(36, "");
											pstmt_insert.setString(37, "");
										}
										if(dosage_type.equals("S")){
											pstmt_insert.setString(38,(String)tempFluidMap.get("STRENGTH_VALUE"));
										}
										else{
										 pstmt_insert.setString(38,"");

										}
										pstmt_insert.setString(39, in_strength_uom);
										tempFluidMap.put("CALC_PRES_QTY_VAL",in_pres_qty_value);//added for IN26008 --20/01/2011-- Naveen
										pstmt_insert.setString(40, in_pres_qty_value);
										pstmt_insert.setString(41, in_pres_qty_uom);

										pstmt_insert.setString(42,"");
										pstmt_insert.setString(43, "");
										pstmt_insert.setString(44, "");
										pstmt_insert.setString(45,take_home_medication);
										pstmt_insert.setString(46,"");
										pstmt_insert.setString(47,"");
										pstmt_insert.setString(48,"");
										pstmt_insert.setString(49,(String)commonData.get("Intention_code"));
										pstmt_insert.setString(50,(String)commonData.get("stage_code"));
										pstmt_insert.setString(51,tot_infuse_over);
										pstmt_insert.setString(52,amend_infusion_period_uom);
										pstmt_insert.setString(53,(String)tempFluidMap.get("DefaultFluidremarks"));
										//pstmt_insert.setString(54,buildMAR_yn); //CRF-0062
										pstmt_insert.setString(54,(String)drugDetails.get("buildMAR_yn"));  //CRF-0062
										pstmt_insert.setString(55,(String)tempFluidMap.get("BL_INCL_EXCL_OVERRIDE_VALUE"));
										pstmt_insert.setString(56,(String)tempFluidMap.get("BL_INCL_EXCL_OVERRIDE_REASON"));
										if(calc_dose.equals(""))
											calc_dose = "0";
										pstmt_insert.setString(57,calc_dose);
										pstmt_insert.setString(58,calc_dose_uom);
										pstmt_insert.setString(59,calc_dose_by);
										pstmt_insert.setString(60,calc_dose_based_on);//CALC_DOSE_BASED_ON
										pstmt_insert.setString(61,amend_infusion_period_value); //ORIG_INFUSE_OVER
										pstmt_insert.setString(62,amend_infusion_rate); //ORIG_INFUSION_RATE
										pstmt_insert.setString(63,drug_indication);//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]
										pstmt_insert.setString(64,mfr_yn);//ML-MMOH-CRF-1014
										pstmt_insert.setString(65,mfr_remarks_insert);//ML-MMOH-CRF-1014
										pstmt_insert.setString(66,"N");//GHL-CRF-0549
									//Added for IN:072715  start
										pstmt_insert.setString(67,"");
										pstmt_insert.setString(68,"");
										pstmt_insert.setString(69,"");
										//Added for IN:072715  end
										pstmt_insert.addBatch();
							/*INSERTION MFR Details PRESCRIPTION INTO OR_ORDER_LINE_PH_MFR Start********** */
                   					PreparedStatement pstmt_insert_Mfr		         = null;
                    				HashMap Mfr_rec_details =(HashMap)Mfr_details.get(drug_code+ocurrance_num); 
System.err.println("OncologyRegimenBean.java==5561===Mfr_details==>"+Mfr_details+"==Mfr_rec_details===>"+Mfr_rec_details);
									String tot_rec = ""; 
									if(Mfr_rec_details != null && Mfr_rec_details.size() > 0 ){
										tot_rec =(String)Mfr_rec_details.get("totRec");
										ArrayList Mfr_rec = new ArrayList();
						 				for(int k=1;k<=Integer.parseInt(tot_rec);k++){
											Mfr_rec	= (ArrayList)Mfr_rec_details.get("MFR"+k);
											pstmt_insert_Mfr = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_MFR_INSERT"));
										pstmt_insert_Mfr.setString(1, order_id); // ORDER_ID
										pstmt_insert_Mfr.setString(2, "1"); //ORDER_LINE_NUM
										pstmt_insert_Mfr.setString(3, k+""); //SL_NO
										pstmt_insert_Mfr.setString(4, (String)Mfr_rec.get(0)); //TOT_STRENGTH - volume
										pstmt_insert_Mfr.setString(5, (String)drugDetails.get("FLUID_UNIT_QTY_UOM")); //TOT_STRENGTH_UOM
										pstmt_insert_Mfr.setString(6, (String)Mfr_rec.get(5)); //INFUSE_OVER
										pstmt_insert_Mfr.setString(7, (String)Mfr_rec.get(2)); //INFUSE_OVER_UNIT 
										pstmt_insert_Mfr.setString(8, (String)Mfr_rec.get(1)); //INFUSION_RATE
										pstmt_insert_Mfr.setString(9,  (String)drugDetails.get("FLUID_UNIT_QTY_UOM")); //INFUSION_VOL_STR_UNIT
										pstmt_insert_Mfr.setString(10, (String)Mfr_rec.get(2)); //INFUSION_PER_UNIT
										pstmt_insert_Mfr.setString(11,(String)Mfr_rec.get(10) ); //GAP_DURATION_IN_HRS
										pstmt_insert_Mfr.setString(12,""); //ADMIN_RATE_DETAIL
										pstmt_insert_Mfr.setString(13, (String)Mfr_rec.get(6)); //START_DATE_TIME 
										pstmt_insert_Mfr.setString(14, (String)Mfr_rec.get(7)); //END_DATE_TIME 
										pstmt_insert_Mfr.setString(15, login_by_id); //ADDED_BY_ID
										pstmt_insert_Mfr.setString(16, login_at_ws_no); //ADDED_AT_WS_NO
										pstmt_insert_Mfr.setString(17, login_facility_id); //ADDED_FACILITY_ID
										pstmt_insert_Mfr.setString(18, login_by_id); //MODIFIED_BY_ID
										pstmt_insert_Mfr.setString(19, login_at_ws_no); //MODIFIED_AT_WS_NO
										pstmt_insert_Mfr.setString(20, login_facility_id); // MODIFIED_FACILITY_ID
										pstmt_insert_Mfr.executeUpdate();
									}
							
								
									try{
										closeStatement(pstmt_insert_Mfr);
									}
									catch(Exception es){
										es.printStackTrace() ;
									}
								 }
//ML-MMOH-CRF-1014 - end
									}
								}
							}
			
							dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
							qty_unit		= (String)drugDetails.get("QTY_DESC_CODE");
							repeat_value	= (String)drugDetails.get("amend_repeat_value")==null?"0":(String)drugDetails.get("amend_repeat_value");
							durn_value		= (String)drugDetails.get("DURN_VALUE");
							durn_desc		= (String)drugDetails.get("DURN_TYPE");
							strength_value	= (String)drugDetails.get("ACT_STRENGTH_VALUE");
							strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
							pres_base_uom	= (String)drugDetails.get("PRES_BASE_UOM");
							strength_per_pres_uom = (String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"0":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
							strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");		
							amend_infusion_period_value=(String)drugDetails.get("amend_infusion_period_value");				
							amend_infusion_rate = (String)drugDetails.get("amend_infusion_rate");
		// For Drug Based

							if (dosage_type.equals("S")) {
								if(!strength_per_value_pres_uom.equals("0") && !strength_per_pres_uom.equals("0") && !repeat_value.equals("0") && !dose.equals("")){
//	CRF_SRR20056-CRF-0537.1  For handling the Decimals REMOVED Math.Ceil
//dose_calc	= ( Math.ceil( (((Double.parseDouble(strength_per_value_pres_uom)) * ((Double.parseDouble(dose)) * (Double.parseDouble(repeat_value))))  / (Double.parseDouble(strength_per_pres_uom)) )))+"";
									dose_calc	= ( (((Double.parseDouble(strength_per_value_pres_uom)) * ((Double.parseDouble(dose)) * (Double.parseDouble(repeat_value))))  / (Double.parseDouble(strength_per_pres_uom)) ))+"";
									in_qty_value = String.valueOf(Math.ceil( ((Double.parseDouble(dose))/(Double.parseDouble(strength_value)))));
									//in_order_qty =  String.valueOf( Math.ceil(((Double.parseDouble(in_qty_value)) * (Double.parseDouble(amend_durn_value))))  );
									in_order_qty =  String.valueOf( (Double.parseDouble(dose_calc)) * (Double.parseDouble(temp_durn_value)));
									in_strength_value	= String.valueOf( Math.ceil( ((Double.parseDouble(strength_per_value_pres_uom)) * (Double.parseDouble(dose)) * (Double.parseDouble(repeat_value)))));
						
									if(in_strength_value!=null)
//										in_tot_strength		= String.valueOf( Math.ceil( ((Double.parseDouble(in_strength_value)) *  (Double.parseDouble(amend_durn_value)))));

									in_tot_strength		= String.valueOf( Math.ceil( ((Double.parseDouble(in_strength_value)) *  (Double.parseDouble(temp_durn_value)))));

						}
							}
							if (dosage_type.equals("Q")) {
								
								pstmt_select.setString(1, amend_frequency);
								pstmt_select.setString(2, dose);
								pstmt_select.setString(3, amend_stock_value);
			//					pstmt_select.setString(4, amend_durn_value);
								pstmt_select.setString(4, temp_durn_value);

								
								resultSet	= pstmt_select.executeQuery();
								if (resultSet.next()) {
									comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
								}
							if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
									StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");							
									while(stQty.hasMoreTokens()){
										ord_qty				  =  Float.parseFloat(stQty.nextToken());
										ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
										fluid_qty			  =  Float.parseFloat(stQty.nextToken());
										fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
									}
								}
							}

							if (dosage_type.equals("Q"))
								in_qty_value	= String.valueOf(ord_qty_value);

							in_qty_unit 	= pres_base_uom ;
							if(in_qty_value==null)
								in_qty_value	= "";
							if(in_qty_unit==null) 
								in_qty_unit	= "";
							equl_value		= "";
							if(dosage_type.equals("Q")) {
								in_tot_strength		= ""; // for Qty_based
								in_tot_strength_uom	= ""; // for Qty_based
								in_bms_qty			= String.valueOf(ord_qty); //Equivalent to qty_value
								in_strength_value	= in_tot_strength;
								in_strength_uom		= in_tot_strength_uom;
// for decimal crf jan-09-2010	in_pres_qty_value	= new Float(Float.parseFloat(in_bms_qty)).intValue()+"";
								in_pres_qty_value	= new Float(Float.parseFloat(in_bms_qty))+"";
								in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit

							} 
							else if(dosage_type.equals("S")) {
								in_tot_strength_uom	= strength_uom;
								in_bms_qty			= String.valueOf(in_order_qty); //Equivalent to qty_value
								in_strength_uom		= in_tot_strength_uom;
//for decimal crf jan-09-2010	in_pres_qty_value	= new Float(Float.parseFloat(in_bms_qty)).intValue()+""; 	//Equivalent to bms_qty
								in_pres_qty_value	= new Float(Float.parseFloat(in_bms_qty))+""; 	//Equivalent to bms_qty

								in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit

							}
							pstmt_insert.setString(1, order_id);
							pstmt_insert.setInt(2, ++line_no);
							pstmt_insert.setString(3, (String)drugDetails.get("GENERIC_ID"));
							pstmt_insert.setString(4, (String)drugDetails.get("FORM_CODE"));
							pstmt_insert.setString(5, "");
							pstmt_insert.setString(6, (String)drugDetails.get("IN_FORMULARY_YN"));
							pstmt_insert.setString(7, (String)drugDetails.get("DOSAGE_TYPE"));
							pstmt_insert.setString(8, "");
							pstmt_insert.setString(9, in_tot_strength);
							pstmt_insert.setString(10, in_tot_strength_uom);
							pstmt_insert.setString(11, amend_infusion_period_value);
							pstmt_insert.setString(12,amend_infusion_period_uom);
							pstmt_insert.setString(13, amend_infusion_rate);
							pstmt_insert.setString(14, infusion_vol_str_unit);
							pstmt_insert.setString(15, amend_infusion_period_uom);
							pstmt_insert.setString(16, "N");
							pstmt_insert.setString(17, "N");
							pstmt_insert.setString(18, "N");
							pstmt_insert.setString(19, "P");
							pstmt_insert.setString(20,(String)drugDetails.get("PERF_LOCN_CODE"));
							pstmt_insert.setString(21, "");
							pstmt_insert.setString(22, "");
							pstmt_insert.setString(23, "");
							pstmt_insert.setString(24, null);
							pstmt_insert.setString(25, "");
							pstmt_insert.setString(26, "");//to be checked dispensed qty

							pstmt_insert.setString(27, (String)drugDetails.get("FINAL_ORD_QTY"));
							pstmt_insert.setString(28, in_tot_strength);
							pstmt_insert.setString(29, login_by_id);
							pstmt_insert.setString(30, login_at_ws_no);
							pstmt_insert.setString(31, login_facility_id);
							pstmt_insert.setString(32, login_by_id);
							pstmt_insert.setString(33, login_at_ws_no);
							pstmt_insert.setString(34, login_facility_id);

							pstmt_insert.setString(35, (String)drugDetails.get("SPLIT_DOSE"));
							if (((String)drugDetails.get("SPLIT_DOSE")) !=null && ((String)drugDetails.get("SPLIT_DOSE")).equals("Y")) {
								pstmt_insert.setString(36, (String)drugDetails.get("QTY_VALUE"));
								pstmt_insert.setString(37, (String)drugDetails.get("QTY_DESC_CODE"));
							}
							else {
								pstmt_insert.setString(36, "");
								pstmt_insert.setString(37, "");
							}

							pstmt_insert.setString(38, in_strength_value);
							pstmt_insert.setString(39, in_strength_uom);
							drugDetails.put("CALC_PRES_QTY_VAL",in_pres_qty_value);//added for IN26008 --20/01/2011-- Naveen
							pstmt_insert.setString(40, in_pres_qty_value);
							pstmt_insert.setString(41, in_pres_qty_uom);							
							
							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN")).equals("Y")){ //EXTERNAL_ALERGY_OVERRIDE_REASON
								pstmt_insert.setString(42, (String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
							}
							else if(((String)drugDetails.get("ALLERGY_YN")).equals("Y")){ //EXTERNAL_ALERGY_OVERRIDE_REASON	
								pstmt_insert.setString(42, (String)drugDetails.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON :
							}
							else{
								pstmt_insert.setString(42, "");
							}
							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
								pstmt_insert.setString(43,(String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")); //EXTERNAL_DOSAGE_OVERRIDE_REASON
							}
							else if(((String)drugDetails.get("LIMIT_IND")).equals("N")){ //changed Y to N for ML-MMOH-CRF-1408
								pstmt_insert.setString(43,(String)drugDetails.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
							}
							else{
								pstmt_insert.setString(43,""); 
							}	
							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
								pstmt_insert.setString(44, (String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")); //EXTERNAL_DUPLICATE_OVERRIDE_REASON
							}
							else if(((String)drugDetails.get("CURRENT_RX")).equals("Y")){
								pstmt_insert.setString(44, (String)drugDetails.get("CURRENTRX_REMARKS")); // currentrx remarks
							}
							else{
								pstmt_insert.setString(44, "");
							}

							pstmt_insert.setString(45,take_home_medication);

							pstmt_insert.setString(46,"");
							pstmt_insert.setString(47,"");
							pstmt_insert.setString(48,"");
							pstmt_insert.setString(49,(String)commonData.get("Intention_code"));
							pstmt_insert.setString(50,(String)commonData.get("stage_code"));
							pstmt_insert.setString(51,tot_infuse_over);
							pstmt_insert.setString(52,amend_infusion_period_uom.trim());
							pstmt_insert.setString(53,"");
							//pstmt_insert.setString(54,buildMAR_yn); //CRF-0062
							pstmt_insert.setString(54,(String)drugDetails.get("buildMAR_yn"));  //CRF-0062
							pstmt_insert.setString(55,(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE"));
							pstmt_insert.setString(56,(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON"));

							if(calc_dose.equals(""))
								calc_dose = "0";
							pstmt_insert.setString(57,calc_dose);
							pstmt_insert.setString(58,calc_dose_uom);
							pstmt_insert.setString(59,calc_dose_by);
							pstmt_insert.setString(60,calc_dose_based_on);
							pstmt_insert.setString(61,amend_infusion_period_value); //ORIG_INFUSE_OVER
							pstmt_insert.setString(62,amend_infusion_rate); //ORIG_INFUSION_RATE
							pstmt_insert.setString(63,drug_indication);//DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]
							pstmt_insert.setString(64,mfr_yn);//ML-MMOH-CRF-1014
							pstmt_insert.setString(65,mfr_remarks_insert);//ML-MMOH-CRF-1014
							pstmt_insert.setString(66,allow_alternate);//GHL-CRF-0549
							//Added for IN:072715 start
							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN")).equals("Y")){ 
								pstmt_insert.setString(67,"");
							}
							else if(((String)drugDetails.get("ALLERGY_YN")).equals("Y")){ 
								pstmt_insert.setString(67, (String)drugDetails.get("ALLERGY_REMARKS_CODE")); 
							}
							else{
								pstmt_insert.setString(67, "");
							}
							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
								pstmt_insert.setString(68,""); 
							}
							else if(((String)drugDetails.get("LIMIT_IND")).equals("N")){ 
								pstmt_insert.setString(68,(String)drugDetails.get("DOSE_REMARKS_CODE")); 
							}
							else{
								pstmt_insert.setString(68,""); 
							}	
							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
								pstmt_insert.setString(69,""); 
							}
							else if(((String)drugDetails.get("CURRENT_RX")).equals("Y")){
								pstmt_insert.setString(69, (String)drugDetails.get("CURRENTRX_REMARKS_CODE")); 
							}
							else{
								pstmt_insert.setString(69, "");
							}
							//Added for IN:072715 end
							pstmt_insert.addBatch();
						}
					}  
					int[] batch_result = pstmt_insert.executeBatch();
					for (int i=0;i<batch_result.length;i++) {
						if(batch_result[i] < 0  && batch_result[i] != -2 ) {
							result = 0;
							break;
						} 
						else {
							result = 1;
						}
					}
				}
			}

			// NEW CRF 766 starts here, drug and fluid details are inserted in two separate lines.
			HashMap tempFluidMap		= new HashMap();
			String perform_external_database_checks = "N";
			String split_dose_uom = "";
			//int srl_NO		= 0;
			//int line_num	=	0;

//Insert into ph_patient_drug_profile			
			if(result > 0 ){
				if (drugList!=null  && drugList.size() !=0) {
					line_no = 0;
					pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT4"));
				  
					pstmt_insert.clearBatch();
					pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
					pstmt_pres_select55	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT55"));
					String split_dose_preview	= "";
					

					resultSet		= null;
					pstmt_pres_select55.setString(1, patient_id);
					resultSet		= pstmt_pres_select55.executeQuery();
					int srl_NO		= 0;
					int tmp_srl_NO		= 0;
					if(resultSet.next()) {
						srl_NO = resultSet.getInt("NEXT_SRL_NO");
						tmp_srl_NO = srl_NO;
					}
			//ML-MMOH-CRF-0345 - start
					String order_id = "";
					String prev_drug_code = "";
					String mfr_yn	= "";
					//int cycle_order_cunt = 0; //Commented for Check Style Report.
					String 	cycle_order_index = "";//ML-MMOH-CRF-0345
					for(int j=0;j<drugList.size();j++) {
						line_no = 0;
						HashMap drugDetails = (HashMap)drugList.get(j);
						cycle_freq_yn = "";			//ML-MMOH-CRF-0345 
						if(result > 0 && drugDetails!=null && drugDetails.size() >0){
							perform_external_database_checks = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
							String drug_code			= (String)drugDetails.get("DRUG_CODE");
							ocurrance_num			= (String)drugDetails.get("OCURRANCE_NUM");
							mfr_yn					= (String)drugDetails.get("mfr_yn")==null?"N":(String)drugDetails.get("mfr_yn");
						//ML-MMOH-CRF-0345 - start
							cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
								if(cycle_freq_yn.equals("Y")){ 
									cycle_order_index = (String)drugDetails.get("CYCLE_INDEX");
									 /*if(prev_drug_code.equals(drug_code))
										cycle_order_cunt++;
									 else
										cycle_order_cunt=0;
									 */

									 order_id			  = orderDetails.get("ORDER_ID_CYCLE"+drug_code+ocurrance_num+cycle_order_index).toString();
								System.err.println("Inside ph_patient_drug_profile==order_id======>"+order_id);
								}else{
									  order_id			  = orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
								}
								
							//added for ML-MMOH-CRF-0345 - end
				
							prev_drug_code	= drug_code;			//ML-MMOH-CRF-0345
							//String order_id				= orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
							dose 						= (String)drugDetails.get("dose");
							strength_value				= (String)drugDetails.get("ACT_STRENGTH_VALUE");
							repeat_value				= (String)drugDetails.get("REPEAT_VALUE");
							amend_infusion_period_value = (String)drugDetails.get("amend_infusion_period_value");
							amend_infusion_period_uom 	= (String)drugDetails.get("amend_infusion_period_uom");
							amend_infusion_rate 	= (String)drugDetails.get("amend_infusion_rate");	
							amend_durn_value 			= (String)drugDetails.get("amend_durn_value")==null?"0":(String)drugDetails.get("amend_durn_value");
							amend_durn_unit 			= (String)drugDetails.get("amend_durn_unit");
							amend_frequency 			= (String)drugDetails.get("amend_frequency");
							amend_end_date = (String)drugDetails.get("amend_end_date"); //added for SRR20056-SCF-7257 IN27448
							amend_start_date = (String)drugDetails.get("amend_start_date"); //added for SRR20056-SCF-7257 IN27448
							dosage_type					= (String)drugDetails.get("DOSAGE_TYPE");
							dose 						= (String)drugDetails.get("dose")==null?"0":(String)drugDetails.get("dose");
							amend_stock_value= (String)drugDetails.get("amend_stock_value");
							freq_chng_durn_desc =	(String)drugDetails.get("freq_chng_durn_desc");
							if(cycle_freq_yn.equals("Y")){ //added for ML-MMOH-CRF-0345 - start
							amend_start_date = (String)drugDetails.get("CYCLE_START_DATE")==null?"":(String)drugDetails.get("CYCLE_START_DATE");
							amend_end_date = (String)drugDetails.get("CYCLE_END_DATE")==null?"":(String)drugDetails.get("CYCLE_END_DATE");
							freq_chng_durn_desc = (String)drugDetails.get("CYCLE_FREQ_DURN_TYPE")==null?"D":(String)drugDetails.get("CYCLE_FREQ_DURN_TYPE");
							}//added for ML-MMOH-CRF-0345 - end
							
							temp_durn_value = (String)getFreqDurnConvValue(freq_chng_durn_desc,amend_durn_value,amend_durn_unit);

							if(fluidDetails!=null && fluidDetails.size() > 0)
								tempFluidMap = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);

								if(tempFluidMap!=null && tempFluidMap.size() > 0){
							
									strength_uom					= (String)tempFluidMap.get("STRENGTH_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_UOM");
									pres_base_uom				= (String)tempFluidMap.get("PRES_BASE_UOM")==null?"0":(String)tempFluidMap.get("PRES_BASE_UOM");
									strength_per_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_PRES_UOM");
									strength_per_value_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM");
									dosage_type		= (String)tempFluidMap.get("DOSAGE_TYPE")==null?"":(String)tempFluidMap.get("DOSAGE_TYPE");

// fluid insertion starts

									in_qty_unit 	= pres_base_uom ;
									resultSet			= null;
									pstmt_select.setString(1, amend_frequency);
									pstmt_select.setString(2, dose);
									pstmt_select.setString(3, amend_stock_value);
						//			pstmt_select.setString(4, amend_durn_value);
									pstmt_select.setString(4, temp_durn_value);

									resultSet	= pstmt_select.executeQuery();

									if (resultSet.next()) {
											comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
									}

									if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
													
										StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
										while(stQty.hasMoreTokens()){
											ord_qty				  =  Float.parseFloat(stQty.nextToken());
											ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
											fluid_qty			  =  Float.parseFloat(stQty.nextToken());
											fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
										}
									}

									if(dosage_type.equals("Q")) {
										strength_uom				="";
										strength_per_pres_uom	    ="";
										strength_per_value_pres_uom	="";
									}
									else if(dosage_type.equals("S")) {
									//	if((HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num)!=null && ((HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num)).size() > 0){
										
											resultSet			= null;
											pstmt_select.setString(1, amend_frequency);
											pstmt_select.setString(2, dose);
											pstmt_select.setString(3, amend_stock_value);
											pstmt_select.setString(4, amend_durn_value);
											resultSet	= pstmt_select.executeQuery();

											if (resultSet.next()) {
												comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
											}
											if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
													
												StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
												while(stQty.hasMoreTokens()){
													ord_qty				  =  Float.parseFloat(stQty.nextToken());
													ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
													fluid_qty			  =  Float.parseFloat(stQty.nextToken());
													fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());

												}
											}
											if(ord_qty==0) 
												ord_qty 			= 0.0f;
											if(ord_qty_value==0) 
												ord_qty_value 		= 0.0f;
											if(fluid_qty==0) 
												fluid_qty 			= 0.0f;
											if(fluid_qty_value==0) 
												fluid_qty_value 	= 0.0f;

											in_qty_value	= String.valueOf(fluid_qty_value);
											
											if(in_qty_value==null) 
												in_qty_value	= "";
											if(in_qty_unit==null) 
												in_qty_unit	= "";
											ord_qty				= fluid_qty;
											equl_value			= "";
											//Only Quantity based for Fluid
											in_tot_strength		= ""; // for Qty_based
											in_tot_strength_uom	= ""; // for Qty_based
											in_bms_qty			= String.valueOf(ord_qty)	; //Equivalent to qty_value
											in_strength_value	= in_tot_strength;
											in_strength_uom		= in_tot_strength_uom;
											in_pres_qty_value	= in_bms_qty; 	//Equivalent to bms_qty
											in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit


									//	} 
									//	else { //drugbased
											/*			
											if(!strength_per_value_pres_uom.equals("0") && !strength_per_pres_uom.equals("0") && !repeat_value.equals("0")){
												dose_calc	= String.valueOf( Math.ceil( (((Double.parseDouble(strength_per_value_pres_uom)) * ((Double.parseDouble(dose)) * (Double.parseDouble(repeat_value))))  / (Double.parseDouble(strength_per_pres_uom)) )));

			System.out.println("@@@sri:::4996  strength_per_value_pres_uom=  "+strength_per_value_pres_uom+"=dose="+dose+"=repeat_value="+repeat_value+"=strength_per_pres_uom="+strength_per_pres_uom);

			System.out.println("@@@sri:::======="+((Double.parseDouble(strength_per_value_pres_uom)) * ((Double.parseDouble(dose)) * (Double.parseDouble(repeat_value)))));
			System.out.println("@@@sri:::======="+(((Double.parseDouble(strength_per_value_pres_uom)) * ((Double.parseDouble(dose)) * (Double.parseDouble(repeat_value))))  / (Double.parseDouble(strength_per_pres_uom)) ));
											}
											if (dose_calc==null || dose_calc.equals("")){
												dose_calc="0";
											}
			System.out.println("@@@sri::dose==="+dose);
											if(dose!=null && !dose.equals("")){					
													
			System.out.println("@@@sri:4999:: dose available==dose_calc="+dose_calc + " == amend_durn_value="+amend_durn_value);								in_qty_value = String.valueOf(dose_calc);
			//										in_order_qty =  String.valueOf( Math.ceil(((Double.parseDouble(in_qty_value)) * (Double.parseDouble(amend_durn_value))))  );
								in_order_qty =  String.valueOf( Math.ceil(((Double.parseDouble(in_qty_value)) * (Double.parseDouble(temp_durn_value))))  );


												in_strength_value	= String.valueOf( Math.ceil( ((Double.parseDouble(strength_per_value_pres_uom)) * (Double.parseDouble(dose)) * (Double.parseDouble(repeat_value)))));
												if(in_strength_value!=null)
						//							in_tot_strength		= String.valueOf( Math.ceil( ((Double.parseDouble(in_strength_value)) *  (Double.parseDouble(amend_durn_value)))));
													in_tot_strength		= String.valueOf( Math.ceil( ((Double.parseDouble(in_strength_value)) *  (Double.parseDouble(temp_durn_value)))));

											}
			System.out.println("@@@sri:5006:: drugggg in_order_qty==="+in_order_qty + " ,,,, in_tot_strength="+in_tot_strength);*/
										//}
									}

									if(dosage_type.equals("Q")) {
										if(fluidDetails!=null && fluidDetails.size() > 0){
											ord_qty				= fluid_qty;
										}
										in_tot_strength		= ""; // for Qty_based
										in_tot_strength_uom	= ""; // for Qty_based
										in_strength_value	= in_tot_strength;
										in_strength_uom		= in_tot_strength_uom;				
										in_pres_qty_value	= new Float(ord_qty)+"";


									}
									else if(dosage_type.equals("S")) {

													
										in_tot_strength_uom	= strength_uom;
										in_strength_value	= in_tot_strength;
										in_strength_uom		= in_tot_strength_uom;
									//	in_pres_qty_value	= new Float(in_order_qty).intValue()+"";
//										in_pres_qty_value	= new Float(ord_qty).intValue+"";
										in_pres_qty_value	= new Float(ord_qty)+"";

									}

		//System.out.println("in_pres_qty_value=at 5442 ="+in_pres_qty_value);
									/*resultSet		= null;
									pstmt_pres_select55.setString(1, patient_id);
									resultSet		= pstmt_pres_select55.executeQuery();
									int srl_NO		= 0;
									int tmp_srl_NO		= 0;
									if(resultSet.next()) {
										srl_NO = resultSet.getInt("NEXT_SRL_NO");
										tmp_srl_NO = srl_NO;
									}*/
									
									pstmt_insert.setString(1, patient_id);
//									pstmt_insert.setString(2, srl_NO + "");
									pstmt_insert.setString(2, (tmp_srl_NO++) + "");
									pstmt_insert.setString(3, login_facility_id);
									pstmt_insert.setString(4, encounter_id);
									pstmt_insert.setString(5, patient_class);
									pstmt_insert.setString(6, location_type);
									pstmt_insert.setString(7, location_code);
									pstmt_insert.setString(8, "");
									pstmt_insert.setString(9, "");
									pstmt_insert.setString(10, "");
									pstmt_insert.setString(11, "");
									pstmt_insert.setString(12, "");
									pstmt_insert.setString(13, "");
									pstmt_insert.setString(14, pract_id);
									pstmt_insert.setString(15, pract_id);

									 // Put the Drug Details
									pstmt_insert.setString(16, (String)tempFluidMap.get("DRUG_CODE"));
									pstmt_insert.setString(17, (String)tempFluidMap.get("GENERIC_ID"));
									pstmt_insert.setString(18, amend_start_date);
									pstmt_insert.setString(19, amend_end_date);
									split_dose_preview	= "";

									HashMap doseUOM=getDosageUOMS();
									String uom="";
									if (doseUOM.containsKey( (String)tempFluidMap.get("DRUG_CODE") ) ){
										uom=(String)doseUOM.get((String)tempFluidMap.get("DRUG_CODE"));
									}
									else if(fluidDetails.size() > 0){
									   uom=pres_base_uom;
									}
									split_dose_uom = "";
									if(tempFluidMap.size() > 0){
										 split_dose_uom  =  pres_base_uom;
									}else if (doseUOM.containsKey( (String)tempFluidMap.get("DRUG_CODE") ) ){
										  split_dose_uom = (String)doseUOM.get((String)tempFluidMap.get("DRUG_CODE"));
									}
		
									uomDisplay = getUomDisplay(login_facility_id, split_dose_uom);
									ArrayList frequencyValues	= new ArrayList();
									if (scheduleFreq.size()>0) {
										if(scheduleFreq.containsKey((String)drugDetails.get("DRUG_CODE")+(String)drugDetails.get("OCURRANCE_NUM"))){
											frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails.get("DRUG_CODE")+(String)drugDetails.get("OCURRANCE_NUM"));
										}
									}                

									if (frequencyValues.size()>0) {
										freq_char_list	= (HashMap)frequencyValues.get(0);
										day_list		= (ArrayList)frequencyValues.get(1);
										day_names		= (ArrayList)frequencyValues.get(2);
										time_list		= (ArrayList)frequencyValues.get(3);
										dose_list		= (ArrayList)frequencyValues.get(4);

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
//											split_dose_preview = split_dose_preview + " "+split_dose_uom;
											split_dose_preview = split_dose_preview + " "+uomDisplay;
											split_dose_preview = split_dose_preview + "; ";
										}
										/*for (int n=0; n<frequencyValues.size(); n++) {
											HashMap data		= (HashMap)frequencyValues.get(n);
											split_dose_preview	= split_dose_preview + (String)data.get("admin_time")+" = "+(String)data.get("admin_qty")+ " "+split_dose_uom+" | ";
										}*/
									}


									if (split_dose_preview.length()>1499) {
										split_dose_preview = split_dose_preview.substring(0, 1499);
									}
									else {
										split_dose_preview = split_dose_preview;
									}

									pstmt_insert.setString(20, "N");
									pstmt_insert.setString(21, "N");
									pstmt_insert.setString(22, (String)tempFluidMap.get("STRENGTH_VALUE"));
									pstmt_insert.setString(23, (String)tempFluidMap.get("STRENGTH_UOM"));
									pstmt_insert.setString(24, amend_stock_value);  //(String)drugDetails.get("dose")
									pstmt_insert.setString(25, (String)tempFluidMap.get("PRES_BASE_UOM")); //uom 
									pstmt_insert.setString(26, split_dose_preview);
									pstmt_insert.setString(27, amend_frequency);
									pstmt_insert.setString(28, amend_durn_value);
									
										
									//pstmt_insert.setString(29, in_pres_qty_value); //replaced in_pres_qty_value with CALC_PRES_QTY_VAL value for IN26008 --20/01/2011-- Naveen
									if(mfr_yn.equals("Y")){
										pstmt_insert.setString(29, (String)drugDetails.get("STOCK_VALUE"));
									}else{
										pstmt_insert.setString(29, (String)tempFluidMap.get("CALC_PRES_QTY_VAL"));
									}
									String diag_text = "";
									pstmt_insert.setString(30, diag_text);
									pstmt_insert.setString(31, "");
									pstmt_insert.setString(32,(String)drugDetails.get("IV_PREP_YN"));
									pstmt_insert.setString(33, amend_infusion_period_value);
									pstmt_insert.setString(34, amend_infusion_period_uom);
									pstmt_insert.setString(35, amend_infusion_rate);
									if(amend_infusion_period_value!=null && !amend_infusion_period_value.equals("")){
										pstmt_insert.setString(36,pres_base_uom );
									}
									else{
									   pstmt_insert.setString(36,"" ); 

									}
									pstmt_insert.setString(37, amend_infusion_period_uom);
									pstmt_insert.setString(38, "N");
									pstmt_insert.setString(39, "");
									pstmt_insert.setString(40, null);
									pstmt_insert.setString(41, "N");
									pstmt_insert.setString(42, "");
									pstmt_insert.setString(43, null);
									pstmt_insert.setString(44, "P");
									pstmt_insert.setString(45, login_facility_id);
									pstmt_insert.setString(46, order_id);
									pstmt_insert.setString(47, String.valueOf(++line_no));
									pstmt_insert.setString(48, "");
									pstmt_insert.setString(49, "N");
									pstmt_insert.setString(50, null);
									pstmt_insert.setString(51, "");
									pstmt_insert.setString(52, "");
									pstmt_insert.setString(53, null);
									pstmt_insert.setString(54, "");
									pstmt_insert.setString(55, "");
									pstmt_insert.setString(56, "N");
									pstmt_insert.setString(57, null);
									pstmt_insert.setString(58, "");
									pstmt_insert.setString(59, "");
									pstmt_insert.setString(60, login_by_id);
									pstmt_insert.setString(61, login_at_ws_no);
									pstmt_insert.setString(62, login_facility_id);
									pstmt_insert.setString(63, login_by_id);
									pstmt_insert.setString(64, login_at_ws_no);
									pstmt_insert.setString(65, login_facility_id);

							/*		if (tempFluidMap!=null && tempFluidMap.size() > 0) {
										pstmt_insert.setString(66, (String)tempFluidMap.get("ROUTE_CODE"));
									} 
									else { // Put the Drug Details*/
										pstmt_insert.setString(66, (String)tempFluidMap.get("ROUTE_CODE"));
									//}

								/*	if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN")).equals("Y")){ //EXTERNAL_ALERGY_OVERRIDE_REASON
										pstmt_insert.setString(67, (String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
									}else if(((String)drugDetails.get("ALLERGY_YN")).equals("Y")){ //EXTERNAL_ALERGY_OVERRIDE_REASON	
										pstmt_insert.setString(67, (String)drugDetails.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON :
									}else{ */
										pstmt_insert.setString(67, "");
								//	}					

								/*	if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
										pstmt_insert.setString(68,(String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")); //EXTERNAL_DOSAGE_OVERRIDE_REASON
									}else if(((String)drugDetails.get("LIMIT_IND")).equals("Y")){
										pstmt_insert.setString(68,(String)drugDetails.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
									}else{ */
										pstmt_insert.setString(68,""); 
								//	}			

									/*if(perform_external_database_checks.equals("N")){					
											pstmt_insert.setString(67, (String)drugDetails.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON :
									}
									else{
										if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN")).equals("Y")){ //EXTERNAL_ALERGY_OVERRIDE_REASON
											pstmt_insert.setString(67, (String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
										}
										else{
											pstmt_insert.setString(67, "");
										}
									}
			
									if(perform_external_database_checks.equals("N")){
											pstmt_insert.setString(68,(String)drugDetails.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
									}
									else{
										if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
											pstmt_insert.setString(68,(String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")); //EXTERNAL_DOSAGE_OVERRIDE_REASON
										}
										else{
											pstmt_insert.setString(68,""); 
										}
									}*/


									pstmt_insert.setString(69, (String)drugDetails.get("IV_INGREDIANTS"));
									pstmt_insert.setString(70, amend_durn_unit);
									pstmt_insert.setString(71, "");
									pstmt_insert.setString(72, "");
									pstmt_insert.setString(73, "");

								/*	if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
										pstmt_insert.setString(74, (String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")); //EXTERNAL_DUPLICATE_OVERRIDE_REASON
									}else if(((String)drugDetails.get("CURRENT_RX")).equals("Y")){
										pstmt_insert.setString(74, (String)drugDetails.get("CURRENTRX_REMARKS")); // currentrx remarks
									}else{*/
										pstmt_insert.setString(74, "");
								//	}
								/*	if(perform_external_database_checks.equals("N")){
										pstmt_insert.setString(74, (String)drugDetails.get("CURRENTRX_REMARKS")); // currentrx remarks
									}
									else{
										if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
											pstmt_insert.setString(74, (String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")); //EXTERNAL_DUPLICATE_OVERRIDE_REASON
										}
										else{
											pstmt_insert.setString(74, "");
										}
									}*/

									pstmt_insert.setString(75, "N");
							/*		if (tempFluidMap!=null && tempFluidMap.size() > 0) {
										pstmt_insert.setString(76, (String)tempFluidMap.get("FORM_CODE"));
									} 
									else { // Put the drug for_code  */
										pstmt_insert.setString(76, (String)tempFluidMap.get("FORM_CODE"));
									//}

									pstmt_insert.setString(77, "");
									pstmt_insert.setString(78, "");
									pstmt_insert.setString(79, "");
									pstmt_insert.setString(80, "");
									pstmt_insert.setString(81, "");
									pstmt_insert.setString(82, "");
									pstmt_insert.setString(83, "");
									pstmt_insert.setString(84, "");
									pstmt_insert.setString(85, "");

							/*		if (tempFluidMap!=null && tempFluidMap.size() > 0) {
										pstmt_insert.setString(86, (String)tempFluidMap.get("DOSAGE_TYPE"));
									} 
									else {  */
										pstmt_insert.setString(86, (String)tempFluidMap.get("DOSAGE_TYPE"));
									//}
									pstmt_insert.setString(87,height);
									pstmt_insert.setString(88,height_unit);
									pstmt_insert.setString(89,weight);
									pstmt_insert.setString(90,weight_unit);
									pstmt_insert.setString(91,bsa);
									pstmt_insert.setString(92,"N");
									pstmt_insert.setString(93,bmi);
								//	pstmt_insert.setString(94,(String)drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON")); //EXTERNAL_INTERACTION_OVERRIDE_REASON
								//	pstmt_insert.setString(95,(String)drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON")); //EXTERNAL_CONTRA_OVERRIDE_REASON
								//	pstmt_insert.setString(96,(String)drugDetails.get("DRUG_DB_PRODUCT_ID")); //DRUG_DB_PRODUCT_ID
								
									pstmt_insert.setString(94,""); //EXTERNAL_INTERACTION_OVERRIDE_REASON
									pstmt_insert.setString(95,""); //EXTERNAL_CONTRA_OVERRIDE_REASON
									pstmt_insert.setString(96,""); //DRUG_DB_PRODUCT_ID
									pstmt_insert.setString(97,""); //EXTERNAL_CONTRA_OVERRIDE_REASON
									pstmt_insert.setString(98,""); //DRUG_DB_PRODUCT_ID
									pstmt_insert.addBatch();
// fluid insertion ends

						}

						/*	if(tempFluidMap!=null && tempFluidMap.size() > 0){
							
								strength_uom					= (String)tempFluidMap.get("STRENGTH_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_UOM");
								pres_base_uom				= (String)tempFluidMap.get("PRES_BASE_UOM")==null?"0":(String)tempFluidMap.get("PRES_BASE_UOM");
								strength_per_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_PRES_UOM");
								strength_per_value_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM");
								dosage_type		= (String)tempFluidMap.get("DOSAGE_TYPE")==null?"":(String)tempFluidMap.get("DOSAGE_TYPE");
							}
							else{*/
								strength_uom	= (String)drugDetails.get("STRENGTH_UOM")==null?"0":(String)drugDetails.get("STRENGTH_UOM");
								pres_base_uom	= (String)drugDetails.get("PRES_BASE_UOM")==null?"0":(String)drugDetails.get("PRES_BASE_UOM");
								strength_per_pres_uom = (String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"0":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
								strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
								dosage_type		= (String)drugDetails.get("DOSAGE_TYPE")==null?"":(String)drugDetails.get("DOSAGE_TYPE");
								repeat_value	= (String)drugDetails.get("REPEAT_VALUE")==null?"0":(String)drugDetails.get("REPEAT_VALUE");
							//}

							in_qty_unit 	= pres_base_uom ;
							resultSet			= null;
							pstmt_select.setString(1, amend_frequency);
							pstmt_select.setString(2, dose);
							pstmt_select.setString(3, amend_stock_value);
				//			pstmt_select.setString(4, amend_durn_value);
							pstmt_select.setString(4, temp_durn_value);

							resultSet	= pstmt_select.executeQuery();

							if (resultSet.next()) {
									comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
							}
							if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
											
								StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
								while(stQty.hasMoreTokens()){
									ord_qty				  =  Float.parseFloat(stQty.nextToken());
									ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
									fluid_qty			  =  Float.parseFloat(stQty.nextToken());
									fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
								}
							}
							if(dosage_type.equals("Q")) {
								strength_uom				="";
								strength_per_pres_uom	    ="";
								strength_per_value_pres_uom	="";
							}
							else if(dosage_type.equals("S")) {
							/*	if((HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num)!=null && ((HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num)).size() > 0){
								
								/*	resultSet			= null;
									pstmt_select.setString(1, amend_frequency);
									pstmt_select.setString(2, dose);
									pstmt_select.setString(3, amend_stock_value);
									pstmt_select.setString(4, amend_durn_value);
									resultSet	= pstmt_select.executeQuery();

									if (resultSet.next()) {
										comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
									}
									if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
											
										StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
										while(stQty.hasMoreTokens()){
											ord_qty				  =  Float.parseFloat(stQty.nextToken());
											ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
											fluid_qty			  =  Float.parseFloat(stQty.nextToken());
											fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
										}
									}
									if(ord_qty==0) 
										ord_qty 			= 0.0f;
									if(ord_qty_value==0) 
										ord_qty_value 		= 0.0f;
									if(fluid_qty==0) 
										fluid_qty 			= 0.0f;
									if(fluid_qty_value==0) 
										fluid_qty_value 	= 0.0f;

									in_qty_value	= String.valueOf(fluid_qty_value);
									
									if(in_qty_value==null) 
										in_qty_value	= "";
									if(in_qty_unit==null) 
										in_qty_unit	= "";
									ord_qty				= fluid_qty;
									equl_value			= "";
									//Only Quantity based for Fluid
									in_tot_strength		= ""; // for Qty_based
									in_tot_strength_uom	= ""; // for Qty_based
									in_bms_qty			= String.valueOf(ord_qty)	; //Equivalent to qty_value
									in_strength_value	= in_tot_strength;
									in_strength_uom		= in_tot_strength_uom;
									in_pres_qty_value	= in_bms_qty; 	//Equivalent to bms_qty
									in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit
System.out.println("@@@sri::: fluidddddddd ord_qty==="+ord_qty);
								} 
								else { //drugbased
									*/			
									if(!strength_per_value_pres_uom.equals("0") && !strength_per_pres_uom.equals("0") && !repeat_value.equals("0")){
										dose_calc	= String.valueOf(  (((Double.parseDouble(strength_per_value_pres_uom)) * ((Double.parseDouble(dose)) * (Double.parseDouble(repeat_value))))  / (Double.parseDouble(strength_per_pres_uom)) ));



									}
									if (dose_calc==null || dose_calc.equals("")){
										dose_calc="0";
									}
									if(dose!=null && !dose.equals("")){					
											
										in_qty_value = String.valueOf(dose_calc);
//										in_order_qty =  String.valueOf( Math.ceil(((Double.parseDouble(in_qty_value)) * (Double.parseDouble(amend_durn_value))))  );
										in_order_qty =  String.valueOf( ((Double.parseDouble(in_qty_value)) * (Double.parseDouble(temp_durn_value)))  );

										in_strength_value	= String.valueOf( Math.ceil( ((Double.parseDouble(strength_per_value_pres_uom)) * (Double.parseDouble(dose)) * (Double.parseDouble(repeat_value)))));
										if(in_strength_value!=null)
				//							in_tot_strength		= String.valueOf( Math.ceil( ((Double.parseDouble(in_strength_value)) *  (Double.parseDouble(amend_durn_value)))));
											in_tot_strength		= String.valueOf( Math.ceil( ((Double.parseDouble(in_strength_value)) *  (Double.parseDouble(temp_durn_value)))));

									}
								//}
							}

							if(dosage_type.equals("Q")) {
								if(fluidDetails!=null && fluidDetails.size() > 0){
									ord_qty				= fluid_qty;
								}
								in_tot_strength		= ""; // for Qty_based
								in_tot_strength_uom	= ""; // for Qty_based
								in_strength_value	= in_tot_strength;
								in_strength_uom		= in_tot_strength_uom;				
								in_pres_qty_value	= new Float(ord_qty)+"";

							}
							else if(dosage_type.equals("S")) {

											
								in_tot_strength_uom	= strength_uom;
								in_strength_value	= in_tot_strength;
								in_strength_uom		= in_tot_strength_uom;
								in_pres_qty_value	= new Float(in_order_qty)+"";
							}


//							resultSet		= null;
//							pstmt_pres_select55.setString(1, patient_id);
//							resultSet		= pstmt_pres_select55.executeQuery();
//							int srl_NO		= 0;
//							if(resultSet.next()) {
//								srl_NO = resultSet.getInt("NEXT_SRL_NO");
//							}
							
							pstmt_insert.setString(1, patient_id);
//							pstmt_insert.setString(2, srl_NO + "");
							pstmt_insert.setString(2, (tmp_srl_NO++) + "");
							pstmt_insert.setString(3, login_facility_id);
							pstmt_insert.setString(4, encounter_id);
							pstmt_insert.setString(5, patient_class);
							pstmt_insert.setString(6, location_type);
							pstmt_insert.setString(7, location_code);
							pstmt_insert.setString(8, "");
							pstmt_insert.setString(9, "");
							pstmt_insert.setString(10, "");
							pstmt_insert.setString(11, "");
							pstmt_insert.setString(12, "");
							pstmt_insert.setString(13, "");
							pstmt_insert.setString(14, pract_id);
							pstmt_insert.setString(15, pract_id);

							 // Put the Drug Details
							pstmt_insert.setString(16, (String)drugDetails.get("DRUG_CODE"));
							pstmt_insert.setString(17, (String)drugDetails.get("GENERIC_ID"));
							pstmt_insert.setString(18, amend_start_date);
							pstmt_insert.setString(19, amend_end_date);
							split_dose_preview	= "";

							HashMap doseUOM=getDosageUOMS();
							String uom="";
							if (doseUOM.containsKey( (String)drugDetails.get("DRUG_CODE") ) ){
								uom=(String)doseUOM.get((String)drugDetails.get("DRUG_CODE"));
							}
							else if(fluidDetails.size() > 0){
							   uom=pres_base_uom;
							}
							//String split_dose_uom = "";
							if(tempFluidMap != null && tempFluidMap.size() > 0){
							  //   split_dose_uom  =  pres_base_uom;
							}else if (doseUOM.containsKey( (String)drugDetails.get("DRUG_CODE") ) ){
								  split_dose_uom = (String)doseUOM.get((String)drugDetails.get("DRUG_CODE"));
							}
					
							uomDisplay = getUomDisplay(login_facility_id, split_dose_uom);

							ArrayList frequencyValues	= new ArrayList();
							if (scheduleFreq.size()>0) {
								if(scheduleFreq.containsKey((String)drugDetails.get("DRUG_CODE")+(String)drugDetails.get("OCURRANCE_NUM"))){
									frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails.get("DRUG_CODE")+(String)drugDetails.get("OCURRANCE_NUM"));
								}
							}                

							if (frequencyValues.size()>0) {
								freq_char_list	= (HashMap)frequencyValues.get(0);
								day_list		= (ArrayList)frequencyValues.get(1);
								day_names		= (ArrayList)frequencyValues.get(2);
								time_list		= (ArrayList)frequencyValues.get(3);
								dose_list		= (ArrayList)frequencyValues.get(4);

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
//									split_dose_preview = split_dose_preview + " "+split_dose_uom;
									split_dose_preview = split_dose_preview + " "+uomDisplay;
									split_dose_preview = split_dose_preview + "; ";
								}
								/*for (int n=0; n<frequencyValues.size(); n++) {
									HashMap data		= (HashMap)frequencyValues.get(n);
									split_dose_preview	= split_dose_preview + (String)data.get("admin_time")+" = "+(String)data.get("admin_qty")+ " "+split_dose_uom+" | ";
								}*/
							}


							if (split_dose_preview.length()>1499) {
								split_dose_preview = split_dose_preview.substring(0, 1499);
							}
							else {
								split_dose_preview = split_dose_preview;
							}

							pstmt_insert.setString(20, "N");
							pstmt_insert.setString(21, "N");
							pstmt_insert.setString(22, (String)drugDetails.get("STRENGTH_VALUE"));
							pstmt_insert.setString(23, (String)drugDetails.get("STRENGTH_UOM"));
							pstmt_insert.setString(24,(String)drugDetails.get("dose"));
							pstmt_insert.setString(25, uom);
							pstmt_insert.setString(26, split_dose_preview);
							pstmt_insert.setString(27, amend_frequency);
							pstmt_insert.setString(28, amend_durn_value);
						//pstmt_insert.setString(29, in_pres_qty_value); //replaced in_pres_qty_value with CALC_PRES_QTY_VAL value for IN26008 --20/01/2011-- Naveen
						   pstmt_insert.setString(29, (String)drugDetails.get("CALC_PRES_QTY_VAL"));
							String diag_text = "";
							pstmt_insert.setString(30, diag_text);
							pstmt_insert.setString(31, "");
							pstmt_insert.setString(32,(String)drugDetails.get("IV_PREP_YN"));
							pstmt_insert.setString(33, amend_infusion_period_value);
							pstmt_insert.setString(34, amend_infusion_period_uom);
							pstmt_insert.setString(35, amend_infusion_rate);
							if(amend_infusion_period_value!=null && !amend_infusion_period_value.equals("")){
								pstmt_insert.setString(36,pres_base_uom );
							}
							else{
							   pstmt_insert.setString(36,"" ); 

							}
							pstmt_insert.setString(37, amend_infusion_period_uom);
							pstmt_insert.setString(38, "N");
							pstmt_insert.setString(39, "");
							pstmt_insert.setString(40, null);
							pstmt_insert.setString(41, "N");
							pstmt_insert.setString(42, "");
							pstmt_insert.setString(43, null);
							pstmt_insert.setString(44, "P");
							pstmt_insert.setString(45, login_facility_id);
							pstmt_insert.setString(46, order_id);
							pstmt_insert.setString(47, String.valueOf(++line_no));
							pstmt_insert.setString(48, "");
							pstmt_insert.setString(49, "N");
							pstmt_insert.setString(50, null);
							pstmt_insert.setString(51, "");
							pstmt_insert.setString(52, "");
							pstmt_insert.setString(53, null);
							pstmt_insert.setString(54, "");
							pstmt_insert.setString(55, "");
							pstmt_insert.setString(56, "N");
							pstmt_insert.setString(57, null);
							pstmt_insert.setString(58, "");
							pstmt_insert.setString(59, "");
							pstmt_insert.setString(60, login_by_id);
							pstmt_insert.setString(61, login_at_ws_no);
							pstmt_insert.setString(62, login_facility_id);
							pstmt_insert.setString(63, login_by_id);
							pstmt_insert.setString(64, login_at_ws_no);
							pstmt_insert.setString(65, login_facility_id);

					/*		if (tempFluidMap!=null && tempFluidMap.size() > 0) {
								pstmt_insert.setString(66, (String)tempFluidMap.get("ROUTE_CODE"));
							} 
							else { // Put the Drug Details*/
								pstmt_insert.setString(66, (String)drugDetails.get("ROUTE_CODE"));
							//}

							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN")).equals("Y")){ //EXTERNAL_ALERGY_OVERRIDE_REASON
								pstmt_insert.setString(67, (String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
							}else if(((String)drugDetails.get("ALLERGY_YN")).equals("Y")){ //EXTERNAL_ALERGY_OVERRIDE_REASON	
								pstmt_insert.setString(67, (String)drugDetails.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON :
							}else{
								pstmt_insert.setString(67, "");
							}					

							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
								pstmt_insert.setString(68,(String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")); //EXTERNAL_DOSAGE_OVERRIDE_REASON
							}else if(((String)drugDetails.get("LIMIT_IND")).equals("N")){// Exsting bug fixed ,Modified for IN:072715
								pstmt_insert.setString(68,(String)drugDetails.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
							}else{
								pstmt_insert.setString(68,""); 
							}			

							/*if(perform_external_database_checks.equals("N")){					
									pstmt_insert.setString(67, (String)drugDetails.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON :
							}
							else{
								if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN")).equals("Y")){ //EXTERNAL_ALERGY_OVERRIDE_REASON
									pstmt_insert.setString(67, (String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
								}
								else{
									pstmt_insert.setString(67, "");
								}
							}
			
							if(perform_external_database_checks.equals("N")){
									pstmt_insert.setString(68,(String)drugDetails.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
							}
							else{
								if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
									pstmt_insert.setString(68,(String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")); //EXTERNAL_DOSAGE_OVERRIDE_REASON
								}
								else{
									pstmt_insert.setString(68,""); 
								}
							}*/


							pstmt_insert.setString(69, (String)drugDetails.get("IV_INGREDIANTS"));
							pstmt_insert.setString(70, amend_durn_unit);
							pstmt_insert.setString(71, "");
							pstmt_insert.setString(72, "");
							pstmt_insert.setString(73, "");

							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
								pstmt_insert.setString(74, (String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")); //EXTERNAL_DUPLICATE_OVERRIDE_REASON
							}else if(((String)drugDetails.get("CURRENT_RX")).equals("Y")){
								pstmt_insert.setString(74, (String)drugDetails.get("CURRENTRX_REMARKS")); // currentrx remarks
							}else{
								pstmt_insert.setString(74, "");
							}
						/*	if(perform_external_database_checks.equals("N")){
								pstmt_insert.setString(74, (String)drugDetails.get("CURRENTRX_REMARKS")); // currentrx remarks
							}
							else{
								if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
									pstmt_insert.setString(74, (String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")); //EXTERNAL_DUPLICATE_OVERRIDE_REASON
								}
								else{
									pstmt_insert.setString(74, "");
								}
							}*/

							pstmt_insert.setString(75, "N");
					/*		if (tempFluidMap!=null && tempFluidMap.size() > 0) {
								pstmt_insert.setString(76, (String)tempFluidMap.get("FORM_CODE"));
							} 
							else { // Put the drug for_code  */
								pstmt_insert.setString(76, (String)drugDetails.get("FORM_CODE"));
							//}

							pstmt_insert.setString(77, "");
							pstmt_insert.setString(78, "");
							pstmt_insert.setString(79, "");
							pstmt_insert.setString(80, "");
							pstmt_insert.setString(81, "");
							pstmt_insert.setString(82, "");
							pstmt_insert.setString(83, "");
							pstmt_insert.setString(84, "");
							pstmt_insert.setString(85, "");

					/*		if (tempFluidMap!=null && tempFluidMap.size() > 0) {
								pstmt_insert.setString(86, (String)tempFluidMap.get("DOSAGE_TYPE"));
							} 
							else {  */
								pstmt_insert.setString(86, (String)drugDetails.get("DOSAGE_TYPE"));
							//}
							pstmt_insert.setString(87,height);
							pstmt_insert.setString(88,height_unit);
							pstmt_insert.setString(89,weight);
							pstmt_insert.setString(90,weight_unit);
							pstmt_insert.setString(91,bsa);
							pstmt_insert.setString(92,"N");
							pstmt_insert.setString(93,bmi);
							pstmt_insert.setString(94,(String)drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON")); //EXTERNAL_INTERACTION_OVERRIDE_REASON
							pstmt_insert.setString(95,(String)drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON")); //EXTERNAL_CONTRA_OVERRIDE_REASON
							pstmt_insert.setString(96,(String)drugDetails.get("DRUG_DB_PRODUCT_ID")); //DRUG_DB_PRODUCT_ID
							pstmt_insert.setString(97,"");
							pstmt_insert.setString(98,"");
							pstmt_insert.addBatch();

						//	result = pstmt_insert.executeUpdate();
						}
					}
					int[] batch_result = pstmt_insert.executeBatch();
					for (int i=0;i<batch_result.length;i++) {
						if(batch_result[i] < 0  && batch_result[i] != -2 ) {
							result = 0;
							break;
						} 
						else {
							result = 1;
						}
					}
				} // End of drugList
			}

		// Drug Remarks/Fluid Remarks  Insertion in OR_ORDER_LINE_FIELD_VALUES
			if(result > 0 ){
				int order_format_count=	0;
				String drug_code	= "";
				String order_id		= "";
				String total_seq	= "";
                String order_line_no="";//added for MMS-KH-SCF-0062
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT7"));
				pstmt_insert.clearBatch();
				// Fluid Remarks
				if(fluidRemarks!=null && fluidRemarks.size()>0) {
					for (int i=0;i<fluidRemarks.size() ;i++ ){
						HashMap fluidValues= new HashMap();
						cycle_freq_yn = "";			//ML-MMOH-CRF-0345
						fluidValues=(HashMap)fluidRemarks.get(i);
						total_seq=(String)fluidValues.get("order_format_fluid_count") ;
						order_format_count=Integer.parseInt(total_seq);
						for(int k=0;k<order_format_count;k++){
							drug_code	= (String)fluidValues.get("drug_code");
							ocurrance_num	= (String)fluidValues.get("OCURRANCE_NUM");
							//added for MMS-KH-SCF-0062 START
							HashMap tempFluidMap_drug = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);
							if (tempFluidMap_drug !=null && tempFluidMap_drug.size() != 0 ){
								order_line_no="2";
							}
							else{
								order_line_no="1";
							}////added for MMS-KH-SCF-0062 END
							cycle_freq_yn = (String)fluidValues.get("CYCLE_FREQ_YN")==null?"":(String)fluidValues.get("CYCLE_FREQ_YN");//uncommented for MMS-KH-CRF-0059
							//cycle_freq_yn = "Y";
							//added for ML-MMOH-CRF-0345 - start			
								if(cycle_freq_yn.equals("Y")){ 
									  order_id			  = orderDetails.get("ORDER_ID_CYCLE"+drug_code+ocurrance_num+i).toString();				
								}else{
									  order_id			  = orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
								}
							//added for ML-MMOH-CRF-0345 - start					
			
							pstmt_insert.setString(1,order_id);
							pstmt_insert.setString(2,order_line_no); // order_line_num////added for MMS-KH-SCF-0062
							pstmt_insert.setString(3,"S");
							pstmt_insert.setString(4,""+(k+1));
							pstmt_insert.setString(5,(String)fluidValues.get("field_mnemonic"+k));
							pstmt_insert.setString(6,(String)fluidValues.get("field_type"+k));
							pstmt_insert.setString(7,(String)fluidValues.get("label_text"+k));
							pstmt_insert.setString(8,(String)fluidValues.get("field_values"+k));
							pstmt_insert.setString(9,"");
							pstmt_insert.setString(10,"");
							pstmt_insert.setString(11,(String)fluidValues.get("accept_option"+k));
							pstmt_insert.setString(12,login_by_id);
							pstmt_insert.setString(13,login_at_ws_no);
							pstmt_insert.setString(14,login_facility_id);
							pstmt_insert.setString(15,login_by_id);
							pstmt_insert.setString(16,login_at_ws_no);
							pstmt_insert.setString(17,login_facility_id);
							pstmt_insert.addBatch();
						}
					}
				}

//COMMENTED FOR  for MMS-KH-SCF-0062 START
/*
if(drugRemarks!=null && drugRemarks.size()>0) {
	pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT7"));
	System.out.println("in side drugRemarks remarks drugRemarks="+drugRemarks);
	for (int i=0;i<drugRemarks.size() ;i++ ){
		HashMap DrugValues= new HashMap();
		DrugValues=(HashMap)drugRemarks.get(i);
		System.out.println("in side drugRemarks remarks DrugValues="+DrugValues);
		total_seq=(String)DrugValues.get("order_format_count") ;
		cycle_freq_yn = (String)DrugValues.get("CYCLE_FREQ_YN")==null?"":(String)DrugValues.get("CYCLE_FREQ_YN");//ADDED for MMS-KH-CRF-0059
		order_format_count=Integer.parseInt(total_seq);
System.out.println("--DrugValues------ order_format_count="+order_format_count);
		for(int k=0;k<order_format_count;k++){
			drug_code	= (String)DrugValues.get("drug_code");
			ocurrance_num	= (String)DrugValues.get("OCURRANCE_NUM");
			//added for CRF-345	- start				
				if(cycle_freq_yn.equals("Y")){ 
					  order_id			  = orderDetails.get("ORDER_ID_CYCLE"+drug_code+ocurrance_num+i).toString();				
				}else{
					  order_id			  = orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
				}
			//added for CRF-345 - end
System.out.println("--DrugValues------ order_id="+order_id);
			pstmt_insert.setString(1,order_id);
			pstmt_insert.setString(2,"1"); // order_line_num
			pstmt_insert.setString(3,"S");
			pstmt_insert.setString(4,""+(k+1));
			pstmt_insert.setString(5,(String)DrugValues.get("field_mnemonic"+k));
			pstmt_insert.setString(6,(String)DrugValues.get("field_type"+k));
			pstmt_insert.setString(7,(String)DrugValues.get("label_text"+k));
			pstmt_insert.setString(8,(String)DrugValues.get("field_values"+k));
			pstmt_insert.setString(9,"");
			pstmt_insert.setString(10,"");
			pstmt_insert.setString(11,(String)DrugValues.get("accept_option"+k));

							pstmt_insert.setString(12,login_by_id);
							pstmt_insert.setString(13,login_at_ws_no);
							pstmt_insert.setString(14,login_facility_id);
							pstmt_insert.setString(15,login_by_id);
							pstmt_insert.setString(16,login_at_ws_no);
							pstmt_insert.setString(17,login_facility_id);
							pstmt_insert.addBatch();
						}
					}
				}
*/	
//COMMENTED FOR MMS-KH-SCF-0062 END	
				if((drugRemarks!=null && drugRemarks.size()>0) || (fluidRemarks!=null && fluidRemarks.size()>0)){
					int[] batch_result = pstmt_insert.executeBatch();
System.out.println("--DrugValues------ batch_result="+batch_result);
			
					for (int i=0;i<batch_result.length ;i++ ){

						if(batch_result[i]<0  && batch_result[i] != -2 ){
							result= 0 ;
							break;
						}
						else {
							result = 1;
						}
					}
			   }
			} // result
	  // Frequency Insertion in OR_ORDER_LINE_FIELD_VALUES 
			if(result > 0){
				if (orderDetails!=null  && orderDetails.size() !=0) {
					boolean freq_values_found	= false;
					pstmt_insert=null;

//					pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT7"));
					pstmt_insert = connection.prepareStatement("INSERT INTO OR_ORDER_LINE_FIELD_VALUES (ORDER_ID,ORDER_LINE_NUM,ORDER_LINE_FIELD_LEVEL,ORDER_LINE_SEQ_NUM,ORDER_LINE_FIELD_MNEMONIC,ORDER_LINE_FIELD_TYPE,ORDER_LINE_LABEL_TEXT,ORDER_LINE_FIELD_VALUE,ORDER_LINE_DOSE_QTY_VALUE,ORDER_LINE_DOSE_QTY_UNIT,ACCEPT_OPTION,ORDER_LINE_FREQ_DAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ADMIN_WEEK,ADMIN_MONTH) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)");//ADMIN_WEEK,ADMIN_MONTH added for ML-MMOH-CRF-0345
					pstmt_insert.clearBatch();
					//ML-MMOH-CRF-0345 - start
					//int cycle_order_cunt		= 0; //Commented for Check Style Report.
					String cycle_order_index = ""; //ML-MMOH-CRF-0345
					String prev_drug_code		= "";
					ArrayList cycle_time_list   = null;
					cycle_freq_yn				= "";
					//String cycle_freq_durn_type = "";
					//String cycle_start_date     = "";
					//String cycle_end_date		= "";
					//String cycle_day_list		= "";
					//ML-MMOH-CRF-0345 - end
					for(int j=0;j<(orderDetails.size()-1);j++) {
						HashMap drugDetails = (HashMap)drugList.get(j);
						/*if(drugDetails == null || drugDetails.size() <1){
							for(int k=j+1; k<drugList.size(); k++ ){
								if(((HashMap)drugList.get(k)) != null && ((HashMap)drugList.get(k)).size() >0)
									drugDetails = (HashMap)drugList.get(k);
							}
						}changed here on 17Mar2010*/
						if(drugDetails == null || drugDetails.size() <1 ||drugDetails.get("PROCESS_YN").toString().equals("Y")){

							for(int k=j+1; k<drugList.size(); k++ ){

								if(((HashMap)drugList.get(k)) != null && ((HashMap)drugList.get(k)).size() >0){
									drugDetails = (HashMap)drugList.get(k);
									//if (drugDetails != null && drugDetails.size() >0 && !(drugDetails.get("DRUG_CODE").toString().equals(prev_drug_code)))
									if (drugDetails != null && drugDetails.size() >0 && !(drugDetails.get("PROCESS_YN").toString().equals("Y")))
									{
										//prev_drug_code = drugDetails.get("DRUG_CODE").toString();
										drugDetails.put("PROCESS_YN","Y");
										break;
									}		
								}
							}
						}
						//ML-MMOH-CRF-0345 - start
						cycle_freq_yn = "";
						String order_id = "";
						String cycle_day = "";
						String cycle_week = "";
						String cycle_month = "";
						String cycle_freq_durn_desc = "";
						//ML-MMOH-CRF-0345 - end
						if(drugDetails!=null && drugDetails.size() >0 ){
							String drug_code			= (String)drugDetails.get("DRUG_CODE");
							ocurrance_num			= (String)drugDetails.get("OCURRANCE_NUM");
						//added for ML-MMOH-CRF-0345 - start
							cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
											
								if(cycle_freq_yn.equals("Y")){ 
									cycle_time_list = (ArrayList)drugDetails.get("TIME_LIST");
									 cycle_day= (String)drugDetails.get("DAY_LIST")==null?"1":(String)drugDetails.get("DAY_LIST");
									  cycle_freq_durn_desc = 	(String)drugDetails.get("CYCLE_FREQ_DURN_TYPE")==null?"D":(String)drugDetails.get("CYCLE_FREQ_DURN_TYPE");
									  System.err.println("cycle_freq_durn_desc==========6680===>"+cycle_freq_durn_desc);
									if(cycle_freq_durn_desc.equals("W")){
									cycle_week =  (String)drugDetails.get("CYCLE_NO")==null?"1":(String)drugDetails.get("CYCLE_NO");
									cycle_month = "";
									}
									else{
										if(cycle_freq_durn_desc.equals("L")){
										 cycle_month =   (String)drugDetails.get("CYCLE_NO")==null?"1":(String)drugDetails.get("CYCLE_NO");
										cycle_week = "";
										}
									}

									 /*if(prev_drug_code.equals(drug_code))
										cycle_order_cunt++;
									 else
										cycle_order_cunt=0; */
										cycle_order_index = (String)drugDetails.get("CYCLE_INDEX");
									 order_id			  = orderDetails.get("ORDER_ID_CYCLE"+drug_code+ocurrance_num+cycle_order_index).toString();
									
								}else{
 									 order_id			  = orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
								}
								prev_drug_code = drug_code;
							//added for ML-MMOH-CRF-0345 - end
							HashMap chkValuescheduleFrequency=scheduleFreq;
							ArrayList frequencyValues = new ArrayList();
							if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
								if(chkValuescheduleFrequency.containsKey(drug_code+ocurrance_num))
									frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code+ocurrance_num);
							}

							dosage_type					= (String)drugDetails.get("DOSAGE_TYPE");
							if(fluidDetails!=null && fluidDetails.size() > 0){
									tempFluidMap = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);
							}

							if(tempFluidMap!=null && tempFluidMap.size() > 0){
								strength_uom	= (String)tempFluidMap.get("PRES_BASE_UOM");
							}
							else{
								if(dosage_type.equals("Q")){
									strength_uom	= (String)drugDetails.get("PRES_BASE_UOM");
								}
								else{
									strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
								}
							}	

						//freq_values_found=false;
								freq_char_list	= new HashMap();
								day_list		= new ArrayList();
								time_list		= new ArrayList();
								dose_list		= new ArrayList();
							if(frequencyValues != null && frequencyValues.size() > 0){
								freq_char_list	= (HashMap)frequencyValues.get(0);
								day_list		= (ArrayList)frequencyValues.get(1);
								day_names		= (ArrayList)frequencyValues.get(2);
								time_list		= (ArrayList)frequencyValues.get(3);
								dose_list		= (ArrayList)frequencyValues.get(4);
							}
							if(frequencyValues!=null && frequencyValues.size()>0 && !cycle_freq_yn.equals("Y")){//!cycle_freq_yn.equals("Y") added for ML-MMOH-CRF-0345
						//		for(int n=0;n<frequencyValues.size();n++){
								for(int n=0;n<day_list.size();n++) {
									freq_values_found = true;

									int seqNo=200;
									seqNo= seqNo+n+1;//+1 added for MMS-KH-SCF-0062
									durn_desc = "";
/*									HashMap data=new HashMap();
									data=(HashMap)frequencyValues.get(n);

									String admin_time=(String)data.get("admin_time");
									String admin_qty=(String)data.get("admin_qty");*/
									durn_desc=strength_uom;
									pstmt_insert.setString(1,order_id);
									pstmt_insert.setString(2,"1");
									pstmt_insert.setString(3,"S");
									pstmt_insert.setString(4,""+(seqNo));
									pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
									pstmt_insert.setString(6,"C");
									pstmt_insert.setString(7,"D");
//									pstmt_insert.setString(8,admin_time);
//									pstmt_insert.setString(9,admin_qty);
									pstmt_insert.setString(8,(String)time_list.get(n));
									pstmt_insert.setString(9,(String)dose_list.get(n));
									pstmt_insert.setString(10,durn_desc);
									pstmt_insert.setString(11,"O");
									pstmt_insert.setInt(12,Integer.parseInt(day_list.get(n)+""));
									pstmt_insert.setString(13,login_by_id);
									pstmt_insert.setString(14,login_at_ws_no);
									pstmt_insert.setString(15,login_facility_id);
									pstmt_insert.setString(16,login_by_id);
									pstmt_insert.setString(17,login_at_ws_no);
									pstmt_insert.setString(18,login_facility_id);
									pstmt_insert.setString(19,"");//CRF-345
									pstmt_insert.setString(20,"");//CRF-345
									pstmt_insert.addBatch();
								}
							}else{ //ML-MMOH-CRF-0345 - start
							
								if(cycle_freq_yn.equals("Y")){

									for(int n=0;n<cycle_time_list.size();n++){
										freq_values_found = true;
										int seqNo=200;
										seqNo= seqNo+n+1;//+1 added for MMS-KH-SCF-0062
										durn_desc = "";
										durn_desc=strength_uom;
										pstmt_insert.setString(1,order_id);
										pstmt_insert.setString(2,"1");
										pstmt_insert.setString(3,"S");
										pstmt_insert.setString(4,""+(seqNo));
										pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
										pstmt_insert.setString(6,"C");
										pstmt_insert.setString(7,"D");
										pstmt_insert.setString(8,(String)cycle_time_list.get(n));
										pstmt_insert.setString(9,(String)drugDetails.get("dose"));
										pstmt_insert.setString(10,durn_desc);
										pstmt_insert.setString(11,"O");
										pstmt_insert.setInt(12,Integer.parseInt(cycle_day));
										pstmt_insert.setString(13,login_by_id);
										pstmt_insert.setString(14,login_at_ws_no);
										pstmt_insert.setString(15,login_facility_id);
										pstmt_insert.setString(16,login_by_id);
										pstmt_insert.setString(17,login_at_ws_no);
										pstmt_insert.setString(18,login_facility_id);
										pstmt_insert.setString(19,cycle_week);//CRF-345
										pstmt_insert.setString(20,cycle_month);//CRF-345
										pstmt_insert.addBatch();
									}
								}
							//ML-MMOH-CRF-0345 - end
							}
						}
					}

					if(freq_values_found){
						int[] batch_result = pstmt_insert.executeBatch();
				
						for (int i=0;i<batch_result.length ;i++ ){
							if(batch_result[i]<0  && batch_result[i] != -2 ){
								result= 0 ;
								break;
							} 
							else {
								result = 1;
							}
						}
					}
				}
			}
	
			if(result > 0){
				resultSet		= null;
				pstmt_select	= null;
				String  verf_reqd_bef_med_admin_yn  = "N";
				String  med_admin_reqd_yn 			= "N";
				String iv_prep_yn					= "N";
				ArrayList schd_date_time			= new ArrayList();
				ArrayList tmp_sch_dt_tm				= new ArrayList();
				String admin_time					= "";
				String admin_qty					= "";
				ArrayList tmp_drg_al				= new ArrayList();
				String drug_qty_unit				= "";

				pstmt_select = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT25A"));
				pstmt_select.clearBatch();
				pstmt_select.setString(1,login_facility_id);
				resultSet	= pstmt_select.executeQuery();
				if ( resultSet != null && resultSet.next() ) {
					verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
					med_admin_reqd_yn	= resultSet.getString("MED_ADMIN_REQD_YN")==null ? "N":resultSet.getString("MED_ADMIN_REQD_YN");
				}
				//if(buildMAR_yn.equals("Y"))
					if (drugList!=null  && drugList.size() !=0) {
						boolean freq_values_found	= false;
						int fluid_line_num = 0;
						int drug_line_num  = 0;
						pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT2"));
						pstmt_insert.clearBatch();
						tmp_drg_al.add(drugList);
						//schd_week_hr_dates = getSchdDatesFrWeekHr(this.getscheduleFrequency(),tmp_drg_al,"CREATE");//ML-MMOH-CRF-01014
				//ML-MMOH-CRF-0345 - start
						String order_id = "";
						//int cycle_order_cunt = 0; //Commented for Check Style Report.
						String cycle_order_index = "";//ML-MMOH-CRF-0345
						String prev_drug_code = "";
						ArrayList unique_schedules  = null;
						ArrayList cycle_time_list   = null;
						cycle_freq_yn	    = "";
						String cycle_freq_durn_type = "";
						String cycle_start_date     = "";
						String cycle_end_date		= "";
						String mfr_yn				= "";//ML-MMOH-CRF-01014
						//String cycle_day_list		= "";
				//ML-MMOH-CRF-0345 - end						
						for(int j=0;j<drugList.size();j++) {
							fluid_line_num = 0;
							drug_line_num  = 0;
							//ML-MMOH-CRF-0345 - start
							cycle_freq_yn = "";
							mfr_yn		  = "";//ML-MMOH-CRF-01014
							unique_schedules	=	new ArrayList();
							//ML-MMOH-CRF-0345 - end
							HashMap drugDetails = (HashMap)drugList.get(j);
							if(drugDetails!=null && drugDetails.size()>0){//ML-MMOH-CRF-01014
							buildMAR_yn=drugDetails.get("buildMAR_yn")==null?"":drugDetails.get("buildMAR_yn").toString(); //CRF-0062
							mfr_yn		= (String)drugDetails.get("mfr_yn")==null?"N":(String)drugDetails.get("mfr_yn");//ML-MMOH-CRF-01014
						
							if(buildMAR_yn.equals("Y"))
					 	    {	
							iv_prep_yn = (String)drugDetails.get("IV_PREP_YN");
							if(!mfr_yn.equals("Y")){//ML-MMOH-CRF-01014
								schd_week_hr_dates = getSchdDatesFrWeekHr(this.getscheduleFrequency(),tmp_drg_al,"CREATE");
							}
							if(drugDetails!=null && drugDetails.size() >0 && iv_prep_yn.equals("9")){
								++fluid_line_num;
								++drug_line_num;


								String drug_code			= (String)drugDetails.get("DRUG_CODE");
								       ocurrance_num		= (String)drugDetails.get("OCURRANCE_NUM");
							//	String order_id				= orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
							//ML-MMOH-CRF-0345 - start
							 cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
							 cycle_freq_durn_type = (String)drugDetails.get("CYCLE_FREQ_DURN_TYPE")==null?"":(String)drugDetails.get("CYCLE_FREQ_DURN_TYPE");
								if(cycle_freq_yn.equals("Y")){ 
									 cycle_time_list = (ArrayList)drugDetails.get("TIME_LIST");
									 cycle_order_index = (String)drugDetails.get("CYCLE_INDEX");
									/* if(prev_drug_code.equals(drug_code))
										cycle_order_cunt++;
									 else
										cycle_order_cunt=0; */

									 order_id			  = orderDetails.get("ORDER_ID_CYCLE"+drug_code+ocurrance_num+cycle_order_index).toString();
								}else{
 									 order_id			  = orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
								}
						//added for ML-MMOH-CRF-0345  - end
							
								        pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
										schd_date_time	    = (ArrayList)schd_week_hr_dates.get(drug_code);
										prev_drug_code		= drug_code;//ML-MMOH-CRF-0345
								if(fluidDetails!=null && fluidDetails.size() > 0)
									tempFluidMap = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);

								if (tempFluidMap!=null && tempFluidMap.size() > 0){
									++drug_line_num;
								}
								HashMap chkValuescheduleFrequency	=	scheduleFreq;

								ArrayList frequencyValues = new ArrayList();
								if(chkValuescheduleFrequency.size()>0){
									if(chkValuescheduleFrequency.containsKey(drug_code+ocurrance_num))
										frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code+ocurrance_num);
								}
								
								if(frequencyValues != null && frequencyValues.size() > 0){
									freq_char_list	= (HashMap)frequencyValues.get(0);
									day_list		= (ArrayList)frequencyValues.get(1);
									day_names		= (ArrayList)frequencyValues.get(2);
									time_list		= (ArrayList)frequencyValues.get(3);
									dose_list		= (ArrayList)frequencyValues.get(4);
								}

								int fr_durn_value = 0;
								durn_value 			= (String)drugDetails.get("amend_durn_value");
								qty_unit			= "";
								drug_qty_unit		= "";

								 if (tempFluidMap!=null && tempFluidMap.size() > 0){
									qty_unit= (String)tempFluidMap.get("QTY_UOM");
								 }
								 else{
									dosage_type=(String)drugDetails.get("DOSAGE_TYPE"); 
									if(dosage_type.equals("Q") || dosage_type.equals("A")){
									   qty_unit=(String)drugDetails.get("QTY_UOM");
									}
									else{
									   qty_unit=(String)drugDetails.get("STRENGTH_UOM");
									}
								 }

								dosage_type=(String)drugDetails.get("DOSAGE_TYPE"); 
								if(dosage_type.equals("Q") || dosage_type.equals("A")){
								   drug_qty_unit=(String)drugDetails.get("QTY_UOM");
								}
								else{
								   drug_qty_unit=(String)drugDetails.get("STRENGTH_UOM");
								}
								//String amend_durn_type = (String)drugDetails.get("amend_durn_type");
								if(durn_value!=null && (!(durn_value.equals("")))){
									fr_durn_value=Integer.parseInt(durn_value);
/*===============================================================================================================*/
										//Below one is commented for the issue - SRR20056-SCF-7789 [IN:028242] by Suresh Kumar T
										/*if(amend_durn_type.equals("W"))
											fr_durn_value = fr_durn_value*7;
										if(amend_durn_type.equals("L"))
											fr_durn_value = fr_durn_value*30;
										if(amend_durn_type.equals("Y"))
											fr_durn_value = fr_durn_value*365;	  */
/*===============================================================================================================*/
								}
								String interval_value=(String)drugDetails.get("INTERVAL_VALUE")==null?"1":(String)drugDetails.get("INTERVAL_VALUE");
								//ML-MMOH-CRF-0345 - start
								cycle_start_date     = (String)drugDetails.get("CYCLE_START_DATE")==null?"":(String)drugDetails.get("CYCLE_START_DATE");
								cycle_end_date       = (String)drugDetails.get("CYCLE_END_DATE")==null?"":(String)drugDetails.get("CYCLE_END_DATE");
								//ML-MMOH-CRF-0345 - end
								if(fr_durn_value!=0){
  								     //for the issue - SRR20056-SCF-7789 [IN:028242] by Suresh Kumar T , removed = [for(int m=0;m<=fr_durn_value;m++)] in the for conditon
									for(int m=0;m<=fr_durn_value;m++){
										if((m != 0) && (Integer.parseInt(interval_value) > 1)){
											m = m+(Integer.parseInt(interval_value) -1);
										}
										
										if(freq_char_list != null && freq_char_list.size()>0 && !cycle_freq_yn.equals("Y")){//&& !cycle_freq_yn.equals("Y") added for ML-MMOH-CRF-0345
											if(!freq_char_list.get("durationType").equals("D")){	
										//		int m1 = m;
										//if(m>=fr_durn_value)
										//	m1=0;
												tmp_sch_dt_tm.clear();
												for(int tmpSch=0;tmpSch<day_list.size();tmpSch++){

													if((tmpSch+(m*day_list.size()))<schd_date_time.size())
														tmp_sch_dt_tm.add((String)schd_date_time.get(tmpSch+(m*day_list.size())));
												}
											}
										}
									//	if(frequencyValues!=null && frequencyValues.size()>0){
										//	pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT24A"));
											pstmt_select	= connection.prepareStatement("SELECT    TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') + ?, 'DD/MM/YYYY') || ' '|| ? scheduled_date_time FROM DUAL  WHERE    to_date(TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') +?,'DD/MM/YYYY') || ?, 'DD/MM/YYYY HH24:MI') BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')");
											//for(int n=0;n<frequencyValues.size();n++){
											if(cycle_freq_yn.equals("Y")){
												for(int n=0;n<cycle_time_list.size();n++){
												freq_values_found = true;
												int dosage_seqNo=1;
												dosage_seqNo= dosage_seqNo+n;
												
												/*HashMap data=new HashMap();
												data=(HashMap)frequencyValues.get(n);
												String admin_time=(String)data.get("admin_time");
												String admin_qty=(String)data.get("admin_qty");*/
												
												String sch_date_time="";
												resultSet			= null;
												admin_time			=(String)cycle_time_list.get(n);
												order_date			=  cycle_start_date;

												//admin_qty			=(String)dose_list.get(n);										
												if(cycle_freq_durn_type.equals("D") || cycle_freq_durn_type.equals("W") || cycle_freq_durn_type.equals("L")){	
													pstmt_select.setString(1, order_date);
													pstmt_select.setString(2, ""+m);
													pstmt_select.setString(3, admin_time);
													pstmt_select.setString(4, order_date);
													pstmt_select.setString(5, ""+m);
													pstmt_select.setString(6, admin_time);
													pstmt_select.setString(7, order_date);
													pstmt_select.setString(8,cycle_end_date);
													resultSet = pstmt_select.executeQuery();
								
													if (resultSet.next()) {
														sch_date_time = resultSet.getString(1);
													}
												}

												if(sch_date_time!= null && !(sch_date_time.equals("")))
												{
													if(!unique_schedules.contains(sch_date_time)) {
												if (tempFluidMap!=null && tempFluidMap.size() > 0){


														pstmt_insert.setString(1,login_facility_id);
														pstmt_insert.setString(2,encounter_id);
														pstmt_insert.setString(3,sch_date_time);
														pstmt_insert.setString(4,(String)tempFluidMap.get("DRUG_CODE"));
														pstmt_insert.setString(5,""+(dosage_seqNo));
														pstmt_insert.setString(6,order_id);
														pstmt_insert.setString(7,String.valueOf(fluid_line_num));
														pstmt_insert.setString(8,patient_id);
														pstmt_insert.setString(9,pract_id);
														pstmt_insert.setString(10, "Y");
														pstmt_insert.setString(11, (String)drugDetails.get("IV_INGREDIANTS"));
														pstmt_insert.setString(12,admin_qty);
														pstmt_insert.setString(13,qty_unit);
														pstmt_insert.setString(14,admin_qty);
														pstmt_insert.setString(15,qty_unit);
													//	if (tempFluidMap!=null && tempFluidMap.size() > 0)
															pstmt_insert.setString(16,(String)tempFluidMap.get("ROUTE_CODE"));
													//	else
														//	pstmt_insert.setString(16,(String)drugDetails.get("ROUTE_CODE"));

														pstmt_insert.setString(17,(String)drugDetails.get("amend_infusion_rate"));//SCH_INFUSION_RATE

														pstmt_insert.setString(18,(String)tempFluidMap.get("PRES_BASE_UOM") );
														pstmt_insert.setString(19, (String)drugDetails.get("amend_infusion_period_uom"));
														pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
														pstmt_insert.setString(21,login_by_id);
														pstmt_insert.setString(22,login_at_ws_no);
														pstmt_insert.setString(23,login_facility_id);
														pstmt_insert.setString(24,login_by_id);
														pstmt_insert.setString(25,login_at_ws_no);
														pstmt_insert.setString(26,login_facility_id);
														pstmt_insert.setString(27, (String)drugDetails.get("amend_infusion_period_value"));
														pstmt_insert.setString(28, (String)drugDetails.get("amend_infusion_period_uom"));
														pstmt_insert.setString(29,""); //MAR_BARCODE_ID MMS-QH-CRF-0080 [IN:038064]

														pstmt_insert.addBatch();
													}

												pstmt_insert.setString(1,login_facility_id);
												pstmt_insert.setString(2,encounter_id);
												pstmt_insert.setString(3,sch_date_time);
												pstmt_insert.setString(4,drug_code);
												pstmt_insert.setString(5,""+(dosage_seqNo));
												pstmt_insert.setString(6,order_id);
												pstmt_insert.setString(7,String.valueOf(drug_line_num));
												pstmt_insert.setString(8,patient_id);
												pstmt_insert.setString(9,pract_id);
												pstmt_insert.setString(10, "Y");
												pstmt_insert.setString(11, (String)drugDetails.get("IV_INGREDIANTS"));
												pstmt_insert.setString(12,(String)drugDetails.get("dose"));
												pstmt_insert.setString(13,drug_qty_unit);
												pstmt_insert.setString(14,(String)drugDetails.get("dose"));
												pstmt_insert.setString(15,drug_qty_unit);
											/*	pstmt_insert.setString(12,admin_qty);
												pstmt_insert.setString(13,qty_unit);
												pstmt_insert.setString(14,admin_qty);
												pstmt_insert.setString(15,qty_unit);*/

											/*	if (tempFluidMap!=null && tempFluidMap.size() > 0)
													pstmt_insert.setString(16,(String)tempFluidMap.get("ROUTE_CODE"));
												else*/
													pstmt_insert.setString(16,(String)drugDetails.get("ROUTE_CODE"));

												pstmt_insert.setString(17,(String)drugDetails.get("amend_infusion_rate"));//SCH_INFUSION_RATE
												pstmt_insert.setString(18,(String)drugDetails.get("PRES_BASE_UOM") );
												pstmt_insert.setString(19, (String)drugDetails.get("amend_infusion_period_uom"));
												pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
												pstmt_insert.setString(21,login_by_id);
												pstmt_insert.setString(22,login_at_ws_no);
												pstmt_insert.setString(23,login_facility_id);
												pstmt_insert.setString(24,login_by_id);
												pstmt_insert.setString(25,login_at_ws_no);											pstmt_insert.setString(26,login_facility_id);
												pstmt_insert.setString(27, (String)drugDetails.get("amend_infusion_period_value"));
												pstmt_insert.setString(28, (String)drugDetails.get("amend_infusion_period_uom"));
												pstmt_insert.setString(29,""); //MAR_BARCODE_ID MMS-QH-CRF-0080 [IN:038064]
												pstmt_insert.addBatch();
												unique_schedules.add(sch_date_time); //ML-MMOH-CRF-0345
											  }
											 } //priya
											}									
											}else{
											   if(frequencyValues!=null && frequencyValues.size()>0){
												for(int n=0;n<day_list.size();n++){
												freq_values_found = true;
												int dosage_seqNo=1;
												dosage_seqNo= dosage_seqNo+n;
												String sch_date_time="";
												resultSet			= null;
												admin_time			=(String)time_list.get(n);
												admin_qty			=(String)dose_list.get(n);										
												if(freq_char_list.get("durationType").equals("D")){	
													pstmt_select.setString(1, order_date);
													pstmt_select.setString(2, ""+m);
													pstmt_select.setString(3, admin_time);
													pstmt_select.setString(4, order_date);
													pstmt_select.setString(5, ""+m);
													pstmt_select.setString(6, admin_time);
													pstmt_select.setString(7, order_date);
													pstmt_select.setString(8,(String)drugDetails.get("amend_end_date"));
													resultSet = pstmt_select.executeQuery();
								
													if (resultSet.next()) {
														sch_date_time = resultSet.getString(1);
													}
											    }else if((freq_char_list.get("durationType").equals("W")) || (freq_char_list.get("durationType").equals("M"))){
													if(tmp_sch_dt_tm.size()>0)
														sch_date_time = (String)tmp_sch_dt_tm.get(n);				
												}
												if(sch_date_time!= null && !(sch_date_time.equals("")))
												{
													if(!unique_schedules.contains(sch_date_time)) {
													if (tempFluidMap!=null && tempFluidMap.size() > 0){
														pstmt_insert.setString(1,login_facility_id);
														pstmt_insert.setString(2,encounter_id);
														pstmt_insert.setString(3,sch_date_time);
														pstmt_insert.setString(4,(String)tempFluidMap.get("DRUG_CODE"));
														pstmt_insert.setString(5,""+(dosage_seqNo));
														pstmt_insert.setString(6,order_id);
														pstmt_insert.setString(7,String.valueOf(fluid_line_num));
														pstmt_insert.setString(8,patient_id);
														pstmt_insert.setString(9,pract_id);
														pstmt_insert.setString(10, "Y");
														pstmt_insert.setString(11, (String)drugDetails.get("IV_INGREDIANTS"));
														pstmt_insert.setString(12,admin_qty);
														pstmt_insert.setString(13,qty_unit);
														pstmt_insert.setString(14,admin_qty);
														pstmt_insert.setString(15,qty_unit);
														pstmt_insert.setString(16,(String)tempFluidMap.get("ROUTE_CODE"));
														pstmt_insert.setString(17,(String)drugDetails.get("amend_infusion_rate"));//SCH_INFUSION_RATE
														pstmt_insert.setString(18,(String)tempFluidMap.get("PRES_BASE_UOM") );
														pstmt_insert.setString(19, (String)drugDetails.get("amend_infusion_period_uom"));
														pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
														pstmt_insert.setString(21,login_by_id);
														pstmt_insert.setString(22,login_at_ws_no);
														pstmt_insert.setString(23,login_facility_id);
														pstmt_insert.setString(24,login_by_id);
														pstmt_insert.setString(25,login_at_ws_no);
														pstmt_insert.setString(26,login_facility_id);
														pstmt_insert.setString(27, (String)drugDetails.get("amend_infusion_period_value"));
														pstmt_insert.setString(28, (String)drugDetails.get("amend_infusion_period_uom"));
														pstmt_insert.setString(29,""); //MAR_BARCODE_ID MMS-QH-CRF-0080 [IN:038064]

														pstmt_insert.addBatch();
													}

												pstmt_insert.setString(1,login_facility_id);
												pstmt_insert.setString(2,encounter_id);
												pstmt_insert.setString(3,sch_date_time);
												pstmt_insert.setString(4,drug_code);
												pstmt_insert.setString(5,""+(dosage_seqNo));
												pstmt_insert.setString(6,order_id);
												pstmt_insert.setString(7,String.valueOf(drug_line_num));
												pstmt_insert.setString(8,patient_id);
												pstmt_insert.setString(9,pract_id);
												pstmt_insert.setString(10, "Y");
												pstmt_insert.setString(11, (String)drugDetails.get("IV_INGREDIANTS"));
												pstmt_insert.setString(12,(String)drugDetails.get("dose"));
												pstmt_insert.setString(13,drug_qty_unit);
												pstmt_insert.setString(14,(String)drugDetails.get("dose"));
												pstmt_insert.setString(15,drug_qty_unit);
											/*	pstmt_insert.setString(12,admin_qty);
												pstmt_insert.setString(13,qty_unit);
												pstmt_insert.setString(14,admin_qty);
												pstmt_insert.setString(15,qty_unit);*/

											/*	if (tempFluidMap!=null && tempFluidMap.size() > 0)
													pstmt_insert.setString(16,(String)tempFluidMap.get("ROUTE_CODE"));
												else*/
													pstmt_insert.setString(16,(String)drugDetails.get("ROUTE_CODE"));

												pstmt_insert.setString(17,(String)drugDetails.get("amend_infusion_rate"));//SCH_INFUSION_RATE
												pstmt_insert.setString(18,(String)drugDetails.get("PRES_BASE_UOM") );
												pstmt_insert.setString(19, (String)drugDetails.get("amend_infusion_period_uom"));
												pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
												pstmt_insert.setString(21,login_by_id);
												pstmt_insert.setString(22,login_at_ws_no);
												pstmt_insert.setString(23,login_facility_id);
												pstmt_insert.setString(24,login_by_id);
												pstmt_insert.setString(25,login_at_ws_no);											pstmt_insert.setString(26,login_facility_id);
												pstmt_insert.setString(27, (String)drugDetails.get("amend_infusion_period_value"));
												pstmt_insert.setString(28, (String)drugDetails.get("amend_infusion_period_uom"));
												pstmt_insert.setString(29,""); //MAR_BARCODE_ID MMS-QH-CRF-0080 [IN:038064]
												pstmt_insert.addBatch();
												unique_schedules.add(sch_date_time);
											  }
											 } //priya
											}
											}else{//ML-MMOH-CRF-01014 -start
											//System.err.println("OncologyRegimenBean.java==7507==sch_date_time====>"+mfr_yn+"==drugDetails==>"+drugDetails);
											if(mfr_yn.equals("Y")){
												String sch_date_time = (String)drugDetails.get("START_DATE");
											//	System.err.println("sch_date_time====>"+sch_date_time+"==tempFluidMap.size()==>"+tempFluidMap.size()+"==unique_schedules==>"+unique_schedules);
											if(!unique_schedules.contains(sch_date_time)) {
												freq_values_found = true;
													if (tempFluidMap!=null && tempFluidMap.size() > 0){
														pstmt_insert.setString(1,login_facility_id);
														pstmt_insert.setString(2,encounter_id);
														pstmt_insert.setString(3,sch_date_time);
														pstmt_insert.setString(4,(String)tempFluidMap.get("DRUG_CODE"));
														pstmt_insert.setString(5,"1");
														pstmt_insert.setString(6,order_id);
														pstmt_insert.setString(7,String.valueOf(fluid_line_num));
														pstmt_insert.setString(8,patient_id);
														pstmt_insert.setString(9,pract_id);
														pstmt_insert.setString(10, "Y");
														pstmt_insert.setString(11, (String)drugDetails.get("IV_INGREDIANTS"));
														pstmt_insert.setString(12,(String)drugDetails.get("STOCK_VALUE"));
														pstmt_insert.setString(13,qty_unit);
														pstmt_insert.setString(14,(String)drugDetails.get("STOCK_VALUE"));
														pstmt_insert.setString(15,qty_unit);
														pstmt_insert.setString(16,(String)tempFluidMap.get("ROUTE_CODE"));
														pstmt_insert.setString(17,(String)drugDetails.get("amend_infusion_rate"));//SCH_INFUSION_RATE
														pstmt_insert.setString(18,(String)tempFluidMap.get("PRES_BASE_UOM") );
														pstmt_insert.setString(19, (String)drugDetails.get("amend_infusion_period_uom"));
														pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
														pstmt_insert.setString(21,login_by_id);
														pstmt_insert.setString(22,login_at_ws_no);
														pstmt_insert.setString(23,login_facility_id);
														pstmt_insert.setString(24,login_by_id);
														pstmt_insert.setString(25,login_at_ws_no);
														pstmt_insert.setString(26,login_facility_id);
														pstmt_insert.setString(27, (String)drugDetails.get("amend_infusion_period_value"));
														pstmt_insert.setString(28, (String)drugDetails.get("amend_infusion_period_uom"));
														pstmt_insert.setString(29,""); 
														pstmt_insert.addBatch();
													}

												pstmt_insert.setString(1,login_facility_id);
												pstmt_insert.setString(2,encounter_id);
												pstmt_insert.setString(3,sch_date_time);
												pstmt_insert.setString(4,drug_code);
												pstmt_insert.setString(5,"1");
												pstmt_insert.setString(6,order_id);
												pstmt_insert.setString(7,String.valueOf(drug_line_num));
												pstmt_insert.setString(8,patient_id);
												pstmt_insert.setString(9,pract_id);
												pstmt_insert.setString(10, "Y");
												pstmt_insert.setString(11, (String)drugDetails.get("IV_INGREDIANTS"));
												pstmt_insert.setString(12,(String)drugDetails.get("dose"));
												pstmt_insert.setString(13,drug_qty_unit);
												pstmt_insert.setString(14,(String)drugDetails.get("dose"));
												pstmt_insert.setString(15,drug_qty_unit);
											/*	pstmt_insert.setString(12,admin_qty);
												pstmt_insert.setString(13,qty_unit);
												pstmt_insert.setString(14,admin_qty);
												pstmt_insert.setString(15,qty_unit);*/

											/*	if (tempFluidMap!=null && tempFluidMap.size() > 0)
													pstmt_insert.setString(16,(String)tempFluidMap.get("ROUTE_CODE"));
												else*/
													pstmt_insert.setString(16,(String)drugDetails.get("ROUTE_CODE"));

												pstmt_insert.setString(17,(String)drugDetails.get("amend_infusion_rate"));//SCH_INFUSION_RATE
												pstmt_insert.setString(18,(String)drugDetails.get("PRES_BASE_UOM") );
												pstmt_insert.setString(19, (String)drugDetails.get("amend_infusion_period_uom"));
												pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
												pstmt_insert.setString(21,login_by_id);
												pstmt_insert.setString(22,login_at_ws_no);
												pstmt_insert.setString(23,login_facility_id);
												pstmt_insert.setString(24,login_by_id);
												pstmt_insert.setString(25,login_at_ws_no);											pstmt_insert.setString(26,login_facility_id);
												pstmt_insert.setString(27, (String)drugDetails.get("amend_infusion_period_value"));
												pstmt_insert.setString(28, (String)drugDetails.get("amend_infusion_period_uom"));
												pstmt_insert.setString(29,""); //MAR_BARCODE_ID MMS-QH-CRF-0080 [IN:038064]
												pstmt_insert.addBatch();
												unique_schedules.add(sch_date_time);
											  }
											
											} 
											}//else
											}
										}
									} // m
								} // fr_durn_value
							}
						} // drug List
						} // drug List
						if(freq_values_found){
							try{
								int[] batch_result = pstmt_insert.executeBatch();
								for (int i=0;i<batch_result.length ;i++ ){
									if(batch_result[i]<0  && batch_result[i] != -2 ){
										result= 0 ;
									} 
									else {
										result = 1;
									}
								}
							}
							catch (Exception e)	{
								map.put("result",new Boolean(false));
								map.put("flag",e.getMessage());
								return map;
							}
						}
					//}  CRF-0062
				}
			}
				
							
			if(result > 0 && isSiteSpecific("OR", "OR_ORDER_SET")){ // Added for ML-MMOH-CRF-1225 - Start (isSiteSpecific("OR", "OR_ORDER_SET") this is created for ML-MMOH-CRF-0345 and Chages for ML-MMOH-CRF-1225 is required based on 345 CRF Only.)

				resultSet		= null;
				pstmt_select	= null;				
				ArrayList schd_date_time			= new ArrayList();
				ArrayList tmp_sch_dt_tm				= new ArrayList();
				String admin_time					= "";
				String admin_qty					= "";
				ArrayList tmp_drg_al				= new ArrayList();
				String drug_qty_unit				= "";
			
					if (drugList!=null  && drugList.size() !=0) {
						boolean freq_values_found	= false;
						int fluid_line_num = 0;
						int drug_line_num  = 0;
						pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT3"));
						pstmt_insert.clearBatch();
						tmp_drg_al.add(drugList);						
						String order_id = "";						
						String cycle_order_index = "";
						String prev_drug_code = "";
						ArrayList unique_schedules  = null;
						ArrayList cycle_time_list   = null;
						cycle_freq_yn	    = "";
						String cycle_freq_durn_type = "";
						String cycle_start_date     = "";
						String cycle_end_date		= "";
						String mfr_yn				= "";												
						for(int j=0;j<drugList.size();j++) {
							fluid_line_num = 0;
							drug_line_num  = 0;							
							cycle_freq_yn = "";
							mfr_yn		  = "";
							unique_schedules	=	new ArrayList();							
							HashMap drugDetails = (HashMap)drugList.get(j);
							if(drugDetails!=null && drugDetails.size()>0){					
							mfr_yn		= (String)drugDetails.get("mfr_yn")==null?"N":(String)drugDetails.get("mfr_yn");
																				
							if(!mfr_yn.equals("Y")){
								schd_week_hr_dates = getSchdDatesFrWeekHr(this.getscheduleFrequency(),tmp_drg_al,"CREATE");
							}
							if(drugDetails!=null && drugDetails.size() >0){
								++fluid_line_num;
								++drug_line_num;

								String drug_code			= (String)drugDetails.get("DRUG_CODE");
								       ocurrance_num		= (String)drugDetails.get("OCURRANCE_NUM");							
							 cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
							 cycle_freq_durn_type = (String)drugDetails.get("CYCLE_FREQ_DURN_TYPE")==null?"":(String)drugDetails.get("CYCLE_FREQ_DURN_TYPE");
								if(cycle_freq_yn.equals("Y")){ 
									 cycle_time_list = (ArrayList)drugDetails.get("TIME_LIST");
									 cycle_order_index = (String)drugDetails.get("CYCLE_INDEX");									

									 order_id			  = orderDetails.get("ORDER_ID_CYCLE"+drug_code+ocurrance_num+cycle_order_index).toString();
								}else{
 									 order_id			  = orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
								}					
							
								        pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
										schd_date_time	    = (ArrayList)schd_week_hr_dates.get(drug_code);
										prev_drug_code		= drug_code;
								if(fluidDetails!=null && fluidDetails.size() > 0)
									tempFluidMap = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);

								if (tempFluidMap!=null && tempFluidMap.size() > 0){
									++drug_line_num;
								}
								HashMap chkValuescheduleFrequency	=	scheduleFreq;

								ArrayList frequencyValues = new ArrayList();
								if(chkValuescheduleFrequency.size()>0){
									if(chkValuescheduleFrequency.containsKey(drug_code+ocurrance_num))
										frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code+ocurrance_num);
								}
								
								if(frequencyValues != null && frequencyValues.size() > 0){
									freq_char_list	= (HashMap)frequencyValues.get(0);
									day_list		= (ArrayList)frequencyValues.get(1);
									day_names		= (ArrayList)frequencyValues.get(2);
									time_list		= (ArrayList)frequencyValues.get(3);
									dose_list		= (ArrayList)frequencyValues.get(4);
								}

								int fr_durn_value = 0;
								durn_value 			= (String)drugDetails.get("amend_durn_value");
								qty_unit			= "";
								drug_qty_unit		= "";

								 if (tempFluidMap!=null && tempFluidMap.size() > 0){
									qty_unit= (String)tempFluidMap.get("QTY_UOM");
								 }
								 else{
									dosage_type=(String)drugDetails.get("DOSAGE_TYPE"); 
									if(dosage_type.equals("Q") || dosage_type.equals("A")){
									   qty_unit=(String)drugDetails.get("QTY_UOM");
									}
									else{
									   qty_unit=(String)drugDetails.get("STRENGTH_UOM");
									}
								 }

								dosage_type=(String)drugDetails.get("DOSAGE_TYPE"); 
								if(dosage_type.equals("Q") || dosage_type.equals("A")){
								   drug_qty_unit=(String)drugDetails.get("QTY_UOM");
								}
								else{
								   drug_qty_unit=(String)drugDetails.get("STRENGTH_UOM");
								}								
								if(durn_value!=null && (!(durn_value.equals("")))){
									fr_durn_value=Integer.parseInt(durn_value);
								}
								String interval_value=(String)drugDetails.get("INTERVAL_VALUE")==null?"1":(String)drugDetails.get("INTERVAL_VALUE");								
								cycle_start_date     = (String)drugDetails.get("CYCLE_START_DATE")==null?"":(String)drugDetails.get("CYCLE_START_DATE");
								cycle_end_date       = (String)drugDetails.get("CYCLE_END_DATE")==null?"":(String)drugDetails.get("CYCLE_END_DATE");								
								if(fr_durn_value!=0){  								    
									for(int m=0;m<=fr_durn_value;m++){
										if((m != 0) && (Integer.parseInt(interval_value) > 1)){
											m = m+(Integer.parseInt(interval_value) -1);
										}
										
										if(freq_char_list != null && freq_char_list.size()>0 && !cycle_freq_yn.equals("Y")){
											if(!freq_char_list.get("durationType").equals("D")){										
												tmp_sch_dt_tm.clear();
												for(int tmpSch=0;tmpSch<day_list.size();tmpSch++){

													if((tmpSch+(m*day_list.size()))<schd_date_time.size())
														tmp_sch_dt_tm.add((String)schd_date_time.get(tmpSch+(m*day_list.size())));
												}
											}
										}									
											pstmt_select	= connection.prepareStatement("SELECT    TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') + ?, 'DD/MM/YYYY') || ' '|| ? scheduled_date_time FROM DUAL  WHERE    to_date(TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') +?,'DD/MM/YYYY') || ?, 'DD/MM/YYYY HH24:MI') BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')");										
											if(cycle_freq_yn.equals("Y")){
												for(int n=0;n<cycle_time_list.size();n++){
												freq_values_found = true;
												int dosage_seqNo=1;
												dosage_seqNo= dosage_seqNo+n;																														
												String sch_date_time="";
												resultSet			= null;
												admin_time			=(String)cycle_time_list.get(n);
												order_date			=  cycle_start_date;														
												if(cycle_freq_durn_type.equals("D") || cycle_freq_durn_type.equals("W") || cycle_freq_durn_type.equals("L")){	
													pstmt_select.setString(1, order_date);
													pstmt_select.setString(2, ""+m);
													pstmt_select.setString(3, admin_time);
													pstmt_select.setString(4, order_date);
													pstmt_select.setString(5, ""+m);
													pstmt_select.setString(6, admin_time);
													pstmt_select.setString(7, order_date);
													pstmt_select.setString(8,cycle_end_date);
													resultSet = pstmt_select.executeQuery();
								
													if (resultSet.next()) {
														sch_date_time = resultSet.getString(1);
													}
												}

												if(sch_date_time!= null && !(sch_date_time.equals("")))
												{
													if(!unique_schedules.contains(sch_date_time)) {
												
													if (tempFluidMap!=null && tempFluidMap.size() > 0){
														pstmt_insert.setString(1,login_facility_id);
														pstmt_insert.setString(2,encounter_id);
														pstmt_insert.setString(3,sch_date_time);
														pstmt_insert.setString(4,(String)tempFluidMap.get("DRUG_CODE"));
														pstmt_insert.setString(5,""+(dosage_seqNo));
														pstmt_insert.setString(6,order_id);
														pstmt_insert.setString(7,String.valueOf(fluid_line_num));
														pstmt_insert.setString(8,patient_id);
														pstmt_insert.setString(9,pract_id);														
														pstmt_insert.setString(10,admin_qty);
														pstmt_insert.setString(11,qty_unit);
														pstmt_insert.setString(12,admin_qty);
														pstmt_insert.setString(13,qty_unit);																																							
														pstmt_insert.setString(14,login_by_id);
														pstmt_insert.setString(15,login_at_ws_no);
														pstmt_insert.setString(16,login_facility_id);
														pstmt_insert.setString(17,login_by_id);
														pstmt_insert.setString(18,login_at_ws_no);
														pstmt_insert.setString(19,login_facility_id);														
														pstmt_insert.addBatch();
													}

												pstmt_insert.setString(1,login_facility_id);
												pstmt_insert.setString(2,encounter_id);
												pstmt_insert.setString(3,sch_date_time);
												pstmt_insert.setString(4,drug_code);
												pstmt_insert.setString(5,""+(dosage_seqNo));
												pstmt_insert.setString(6,order_id);
												pstmt_insert.setString(7,String.valueOf(drug_line_num));
												pstmt_insert.setString(8,patient_id);
												pstmt_insert.setString(9,pract_id);												
												pstmt_insert.setString(10,(String)drugDetails.get("dose"));
												pstmt_insert.setString(11,drug_qty_unit);
												pstmt_insert.setString(12,(String)drugDetails.get("dose"));
												pstmt_insert.setString(13,drug_qty_unit);																																		
												pstmt_insert.setString(14,login_by_id);
												pstmt_insert.setString(15,login_at_ws_no);
												pstmt_insert.setString(16,login_facility_id);
												pstmt_insert.setString(17,login_by_id);
												pstmt_insert.setString(18,login_at_ws_no);											
												pstmt_insert.setString(19,login_facility_id);												
												pstmt_insert.addBatch();
												unique_schedules.add(sch_date_time);
											  }
											 }
											}									
											}else{
											   if(frequencyValues!=null && frequencyValues.size()>0){
												for(int n=0;n<day_list.size();n++){
												freq_values_found = true;
												int dosage_seqNo=1;
												dosage_seqNo= dosage_seqNo+n;
												String sch_date_time="";
												resultSet			= null;
												admin_time			=(String)time_list.get(n);
												admin_qty			=(String)dose_list.get(n);										
												if(freq_char_list.get("durationType").equals("D")){	
													pstmt_select.setString(1, order_date);
													pstmt_select.setString(2, ""+m);
													pstmt_select.setString(3, admin_time);
													pstmt_select.setString(4, order_date);
													pstmt_select.setString(5, ""+m);
													pstmt_select.setString(6, admin_time);
													pstmt_select.setString(7, order_date);
													pstmt_select.setString(8,(String)drugDetails.get("amend_end_date"));
													resultSet = pstmt_select.executeQuery();
								
													if (resultSet.next()) {
														sch_date_time = resultSet.getString(1);
													}
											    }else if((freq_char_list.get("durationType").equals("W")) || (freq_char_list.get("durationType").equals("M"))){
													if(tmp_sch_dt_tm.size()>0)
														sch_date_time = (String)tmp_sch_dt_tm.get(n);				
												}
												if(sch_date_time!= null && !(sch_date_time.equals("")))
												{
													if(!unique_schedules.contains(sch_date_time)) {
												if (tempFluidMap!=null && tempFluidMap.size() > 0){
														pstmt_insert.setString(1,login_facility_id);
														pstmt_insert.setString(2,encounter_id);
														pstmt_insert.setString(3,sch_date_time);
														pstmt_insert.setString(4,(String)tempFluidMap.get("DRUG_CODE"));
														pstmt_insert.setString(5,""+(dosage_seqNo));
														pstmt_insert.setString(6,order_id);
														pstmt_insert.setString(7,String.valueOf(fluid_line_num));
														pstmt_insert.setString(8,patient_id);
														pstmt_insert.setString(9,pract_id);														
														pstmt_insert.setString(10,admin_qty);
														pstmt_insert.setString(11,qty_unit);
														pstmt_insert.setString(12,admin_qty);
														pstmt_insert.setString(13,qty_unit);																												
														pstmt_insert.setString(14,login_by_id);
														pstmt_insert.setString(15,login_at_ws_no);
														pstmt_insert.setString(16,login_facility_id);
														pstmt_insert.setString(17,login_by_id);
														pstmt_insert.setString(18,login_at_ws_no);
														pstmt_insert.setString(19,login_facility_id);														                                                    
														pstmt_insert.addBatch();
												    }										       
												pstmt_insert.setString(1,login_facility_id);
												pstmt_insert.setString(2,encounter_id);
												pstmt_insert.setString(3,sch_date_time);
												pstmt_insert.setString(4,drug_code);
												pstmt_insert.setString(5,""+(dosage_seqNo));
												pstmt_insert.setString(6,order_id);
												pstmt_insert.setString(7,String.valueOf(drug_line_num));
												pstmt_insert.setString(8,patient_id);
												pstmt_insert.setString(9,pract_id);												
												pstmt_insert.setString(10,(String)drugDetails.get("dose"));
												pstmt_insert.setString(11,drug_qty_unit);
												pstmt_insert.setString(12,(String)drugDetails.get("dose"));
												pstmt_insert.setString(13,drug_qty_unit);																							
												pstmt_insert.setString(14,login_by_id);
												pstmt_insert.setString(15,login_at_ws_no);
												pstmt_insert.setString(16,login_facility_id);
												pstmt_insert.setString(17,login_by_id);
												pstmt_insert.setString(18,login_at_ws_no);											
												pstmt_insert.setString(19,login_facility_id);												
												pstmt_insert.addBatch();
												unique_schedules.add(sch_date_time);
											  }
											 }
											}
											}else{											
											if(mfr_yn.equals("Y")){
												String sch_date_time = (String)drugDetails.get("START_DATE");											
											if(!unique_schedules.contains(sch_date_time)) {
												freq_values_found = true;
													if (tempFluidMap!=null && tempFluidMap.size() > 0){
														pstmt_insert.setString(1,login_facility_id);
														pstmt_insert.setString(2,encounter_id);
														pstmt_insert.setString(3,sch_date_time);
														pstmt_insert.setString(4,(String)tempFluidMap.get("DRUG_CODE"));
														pstmt_insert.setString(5,"1");
														pstmt_insert.setString(6,order_id);
														pstmt_insert.setString(7,String.valueOf(fluid_line_num));
														pstmt_insert.setString(8,patient_id);
														pstmt_insert.setString(9,pract_id);														
														pstmt_insert.setString(10,(String)drugDetails.get("STOCK_VALUE"));
														pstmt_insert.setString(11,qty_unit);
														pstmt_insert.setString(12,(String)drugDetails.get("STOCK_VALUE"));
														pstmt_insert.setString(13,qty_unit);																												
														pstmt_insert.setString(14,login_by_id);
														pstmt_insert.setString(15,login_at_ws_no);
														pstmt_insert.setString(16,login_facility_id);
														pstmt_insert.setString(17,login_by_id);
														pstmt_insert.setString(18,login_at_ws_no);
														pstmt_insert.setString(19,login_facility_id);														 
														pstmt_insert.addBatch();
													}

												pstmt_insert.setString(1,login_facility_id);
												pstmt_insert.setString(2,encounter_id);
												pstmt_insert.setString(3,sch_date_time);
												pstmt_insert.setString(4,drug_code);
												pstmt_insert.setString(5,"1");
												pstmt_insert.setString(6,order_id);
												pstmt_insert.setString(7,String.valueOf(drug_line_num));
												pstmt_insert.setString(8,patient_id);
												pstmt_insert.setString(9,pract_id);												
												pstmt_insert.setString(10,(String)drugDetails.get("dose"));
												pstmt_insert.setString(11,drug_qty_unit);
												pstmt_insert.setString(12,(String)drugDetails.get("dose"));
												pstmt_insert.setString(13,drug_qty_unit);																																	
												pstmt_insert.setString(14,login_by_id);
												pstmt_insert.setString(15,login_at_ws_no);
												pstmt_insert.setString(16,login_facility_id);
												pstmt_insert.setString(17,login_by_id);
												pstmt_insert.setString(18,login_at_ws_no);											
												pstmt_insert.setString(19,login_facility_id);												
												pstmt_insert.addBatch();
												unique_schedules.add(sch_date_time);
											  }
											
											} 
											}
											}
										}
									}
								}							
						} 
						} 
						if(freq_values_found){
							try{
								int[] batch_result = pstmt_insert.executeBatch();
								for (int i=0;i<batch_result.length ;i++ ){
									if(batch_result[i]<0  && batch_result[i] != -2 ){
										result= 0 ;
									} 
									else {
										result = 1;
									}
								}
							}
							catch (Exception e)	{
								map.put("result",new Boolean(false));
								map.put("flag",e.getMessage());
								return map;
							}
						}					
				}
			} // Added for ML-MMOH-CRF-1225 - End
	
			String dly_count		= "";						
			String dly_count_loc	= "";
			int totalDrugs			=	1;
			totalDrugs			+= drugList.size();                            
			totalOrder			=(orderDetails.size()-1);

			if(result > 0){ 
				pstmt_workload		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT72")) ;
				pstmt_workload.setString(1,pract_id);
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,patient_class);

				resultSet_workload  	= pstmt_workload.executeQuery() ;

				while (resultSet_workload.next()){
					dly_count		= (resultSet_workload.getString("DLYCOUNT")).trim();				
				}
				closeResultSet(resultSet_workload);
				closeStatement(pstmt_workload);

				pstmt_workload		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT73")) ;
				pstmt_workload.setString(1,pract_id);
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,patient_class);

				resultSet_workload  	= pstmt_workload.executeQuery() ;
				while (resultSet_workload.next()){
					monthly_count			=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
				}
				closeResultSet(resultSet_workload);
				closeStatement(pstmt_workload);

				if(dly_count.equals("0")){
					workload_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT9")) ;
					workload_insert.setString( 1, pract_id);
					workload_insert.setString( 2, login_facility_id);
					workload_insert.setString( 3, patient_class);
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
				else{
					workload_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY6")) ;
					workload_insert.setString( 1,String.valueOf(totalOrder));
					workload_insert.setString( 2,String.valueOf(totalDrugs));
					workload_insert.setString( 3, login_by_id);
					workload_insert.setString( 4, login_at_ws_no);
					workload_insert.setString( 5, login_facility_id);
					workload_insert.setString( 6, pract_id);
					workload_insert.setString( 7, login_facility_id);
					workload_insert.setString( 8, patient_class);
					workload_insert.executeUpdate();

				}

// Insertion into PH_MTHLY_DO_WORKLOAD starts here
				if(monthly_count.equals("0")){
					work_insert_month		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT10")) ;
					work_insert_month.setString( 1, pract_id);
					work_insert_month.setString( 2, login_facility_id);
					work_insert_month.setString( 3, patient_class);
					work_insert_month.setString( 4,String.valueOf(totalOrder));
					work_insert_month.setString( 5,String.valueOf(total_line_num));
					work_insert_month.setString( 6, login_by_id);
					work_insert_month.setString( 7, login_at_ws_no);
					work_insert_month.setString( 8, login_facility_id);
					work_insert_month.setString( 9, login_by_id);
					work_insert_month.setString( 10, login_at_ws_no);
					work_insert_month.setString( 11, login_facility_id);
					result = work_insert_month.executeUpdate();
				}
				else{
					work_insert_month		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY7")) ;
					work_insert_month.setString( 1,String.valueOf(totalOrder));
					work_insert_month.setString( 2,String.valueOf(total_line_num));
					work_insert_month.setString( 3, login_by_id);
					work_insert_month.setString( 4, login_at_ws_no);
					work_insert_month.setString( 5, login_facility_id);
					work_insert_month.setString( 6, pract_id);
					work_insert_month.setString( 7, login_facility_id);
					work_insert_month.setString( 8, patient_class);
					result =  work_insert_month.executeUpdate();
				}
				closeResultSet(resultSet_workload);
				closeStatement(pstmt_workload);
			
				pstmt_workload			= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT74")) ;	
				pstmt_workload.setString(1,location_type);
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,location_code);
				resultSet_workload  	= pstmt_workload.executeQuery() ;
				while (resultSet_workload.next()){
					dly_count_loc	= (resultSet_workload.getString("DLYCOUNT")).trim();				
				}
				closeResultSet(resultSet_workload);
				closeStatement(pstmt_workload);

				pstmt_workload			= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT75")) ;
				pstmt_workload.setString(1,location_type);
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,location_code);

				resultSet_workload  	= pstmt_workload.executeQuery() ;
				while (resultSet_workload.next()){
						monthly_count_loc		=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
				}
				closeResultSet(resultSet_workload);
				closeStatement(pstmt_workload);

// Insertion into PH_MTHLY_LOC_WORKLOAD starts here

				if(dly_count_loc.equals("0")){
					work_insert_loc = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT11")) ;
					work_insert_loc.setString(1,login_facility_id);
					work_insert_loc.setString(2, location_type);
					work_insert_loc.setString(3, location_code);
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
				else{
					work_insert_loc = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY8")) ;
					work_insert_loc.setString(1,String.valueOf(totalOrder));
					work_insert_loc.setString(2,String.valueOf(totalDrugs));
					work_insert_loc.setString(3, login_by_id);
					work_insert_loc.setString(4, login_at_ws_no);
					work_insert_loc.setString(5, login_facility_id);
					work_insert_loc.setString(6, location_type);
					work_insert_loc.setString(7, login_facility_id);
					work_insert_loc.setString(8, location_code);
					work_insert_loc.executeUpdate();
				}

				if(monthly_count_loc.equals("0")){
					work_insert_loc_mon =  connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT12")) ;
					work_insert_loc_mon.setString(1,login_facility_id);
					work_insert_loc_mon.setString(2, location_type);
					work_insert_loc_mon.setString(3, location_code);
					work_insert_loc_mon.setString(4,String.valueOf(totalOrder));
					work_insert_loc_mon.setString(5,String.valueOf(total_line_num));
					work_insert_loc_mon.setString(6, login_by_id);
					work_insert_loc_mon.setString(7, login_at_ws_no);
					work_insert_loc_mon.setString(8, login_facility_id);
					work_insert_loc_mon.setString(9, login_by_id);
					work_insert_loc_mon.setString(10, login_at_ws_no);
					work_insert_loc_mon.setString(11, login_facility_id);
					result = work_insert_loc_mon.executeUpdate();
				}
				else{
					work_insert_loc_mon =  connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY9")) ;
					work_insert_loc_mon.setString(1,String.valueOf(totalOrder));
					work_insert_loc_mon.setString(2,String.valueOf(total_line_num));
					work_insert_loc_mon.setString(3, login_by_id);
					work_insert_loc_mon.setString(4, login_at_ws_no);
					work_insert_loc_mon.setString(5, login_facility_id);
					work_insert_loc_mon.setString(6, location_type);
					work_insert_loc_mon.setString(7, login_facility_id);
					work_insert_loc_mon.setString(8, location_code);
					result = work_insert_loc_mon.executeUpdate();
					
				}
			}

			String auto_order_regn_err = "";
			String tokens_generated_yn = "";
			if (result>0 && (patient_class.equals("OP") || patient_class.equals("EM")) && !trn_group_ref.equals("")) {
				cstmt_insert=connection.prepareCall("{call ph_auto_order_regn(?,?,?,?,?,?)}");

				cstmt_insert.setString( 1, trn_group_ref);
				cstmt_insert.setString( 2, patient_id);
				cstmt_insert.setString( 3, login_facility_id);
				cstmt_insert.setString( 4, encounter_id);
				cstmt_insert.registerOutParameter(5, Types.VARCHAR );
				cstmt_insert.registerOutParameter(6, Types.VARCHAR );
				cstmt_insert.execute() ;

				tokens_generated_yn = cstmt_insert.getString(5)==null ? "":cstmt_insert.getString(5);
				auto_order_regn_err = cstmt_insert.getString(6)==null ? "":cstmt_insert.getString(6);
				try{
					closeResultSet( resultSet ) ;
					closeStatement( cstmt_insert ) ;
				}catch(Exception es){
					es.printStackTrace() ;
				}
			}
			if (auto_order_regn_err.equals("")) {
				
				map.put("result", new Boolean(true));
				map.put("msgid", "RECORD_INSERTED");
				map.put("trn_group_ref", trn_group_ref);
				map.put("tokens_generated_yn", tokens_generated_yn);
				connection.commit();
			} 
			else {
				map.put("result", new Boolean(false));
				map.put("msgid", "auto_order_regn_err");
				connection.rollback();
			}
		} 
		catch(Exception e){
			e.printStackTrace() ;
		}
		finally{
			try{
				closeResultSet( rset_clob);
				closeResultSet( resultSet);
				closeResultSet( resultSet_workload);

				closeStatement( pstmt_insert ) ;
				closeStatement( cstmt_insert ) ;
				closeStatement( pstmt_clob ) ;
				closeStatement( pstmt_select ) ;
				closeStatement( pstmt_workload ) ;
				closeStatement( work_insert_month ) ;
				closeStatement( work_insert_loc_mon ) ;
				closeStatement( pstmt_pres_select53 ) ;
				closeStatement( pstmt_pres_select55 ) ;
				closeConnection(connection );
			}
			catch(Exception e){
			   e.printStackTrace() ;
			}
		}
		return map;
	}

	public HashMap updateData( HashMap tabData, HashMap sqlMap){

		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "0");
		map.put("msgid", "MODIFY");

		Connection connection					= null;
		PreparedStatement pstmt_select			= null;
		PreparedStatement pstmt_update			= null;
		PreparedStatement pstmt_insert			= null;
		PreparedStatement pstmt_delete			= null;

		PreparedStatement pstmt_clob			= null;
		ResultSet rset_clob						= null;
		ResultSet resultSet						= null;
		int result								= 0;
		String catalog_short_desc               = ""; 

		try {
			connection					= getConnection() ;
			HashMap orderDetails		= (HashMap)tabData.get("orderdetails");
			HashMap commonData			= (HashMap)tabData.get("commondata");
			HashMap	scheduleFreq		= (HashMap) tabData.get("schedulefreq");
			HashMap	fluidDetails		= (HashMap)tabData.get("fluiddetails");
			ArrayList drugList			= (ArrayList)tabData.get("drugdetails");
			ArrayList drugRemarks		= (ArrayList)tabData.get("drugRemarks");
			ArrayList fluidRemarks		= (ArrayList)tabData.get("fluidremarks");
			String login_by_id			= (String)commonData.get("login_by_id");
			String login_at_ws_no		= (String)commonData.get("login_at_ws_no");
			String login_facility_id	= (String)commonData.get("login_facility_id");
			String header_comments		= (String)commonData.get("header_comments");
			String order_date	        = (String)commonData.get("order_date");
			String buildMAR_yn			= "";  // CRF-0062 VALUE WILL BE TAKEN AT DRUG LEVEL
			HashMap mfr_remarks 	= (HashMap)tabData.get("mfr_remarks_details"); //ML-MMOH-CRF-1014
			HashMap Mfr_details      = (HashMap)tabData.get("Mfr_rec_details");//ML-MMOH-CRF-1014 

			String freq_nature			= "";
			String in_qty_value			= "";
			String in_qty_unit			= "";
			String in_order_qty			= "";
			String in_tot_strength		= "";
			String in_tot_strength_uom	= "";
			String in_bms_qty			= "";
			String in_strength_value	= "";
			String in_strength_uom		= "";
			String in_pres_qty_value	= "";
			String in_pres_qty_uom		= "";

			String dosage_type			= "";
			String qty_unit				= "";
			String repeat_value			= "";
			String durn_value			= "";
			String durn_desc			= "";
			String strength_value		= "";
			String strength_uom			= "";
			String pres_base_uom		= "";
			String strength_per_pres_uom= "";
			String strength_per_value_pres_uom = "";
			String comb_ord_qty 		= "";
			String equl_value			= "";
			String infusion_vol_str_unit ="";
			String dose					= "";
			String dose_calc			= "";
			String amend_stock_value	= "";
			String amend_durn_value 	= "0";
			String amend_infusion_period_value = "";
			String amend_infusion_period_uom = "";
			String amend_infusion_rate  = "";
			String amend_durn_unit 		= "";
			String amend_end_date 		= "";
			String amend_start_date 	= "";
			String amend_frequency 		= "";
			String amend_repeat_value	= "";
			String freq_value			= "";
			String drug_indication		= "";
			String repeat_durn_type		= "";
			float ord_qty				= 0.0f;
			float ord_qty_value			= 0.0f;
			float fluid_qty     		= 0.0f;
			float fluid_qty_value		= 0.0f;
			int line_no 				= 0;
			String fld_tot_strength     = "";
			String fld_strength_value   = "";
			String content_in_pres_base_uom	="";	
			String order_qty		    ="";
			String stock_uom            ="";
			String tot_infuse_over      ="";
			String pract_id		        = (String)commonData.get("pract_id");
			String drug_code    = "";
			String ocurrance_num    = "";
			String order_id = "";
			String uomDisplay = "";
			String cycle_freq_yn	    = ""; //Added for CRF-345
			
			HashMap freq_char_list				= new HashMap();
			ArrayList day_list					= new ArrayList();
			ArrayList day_names					= new ArrayList();
			ArrayList time_list					= new ArrayList();
			ArrayList dose_list					= new ArrayList();
			HashMap schd_week_hr_dates			= new HashMap();

			
			/*IN066779 Starts*/
			ArrayList AMNDreason	=	null;
			String amnd_Reason="";
			String amend_Order_Id="";
			
			AMNDreason=getAmendReason1(order_Id);
			amend_Order_Id=(String)AMNDreason.get(0);
			amnd_Reason=(String)AMNDreason.get(2);
			
			
			if(!"".equals(amend_Order_Id)){ 
				PreparedStatement	auditSeqPStmt = connection.prepareStatement("SELECT NVL(MAX(ACTION_SEQ_NUM),0)+1 FROM OR_ORDER_AMEND_REASON WHERE ORDER_ID = ?");
				auditSeqPStmt.setString(1,amend_Order_Id);				
				ResultSet auditSeqRs = auditSeqPStmt.executeQuery();				
				String amend_reason_seq ="";
				if (auditSeqRs.next()){
					amend_reason_seq	= ChkDef.defaultString(auditSeqRs.getString(1));
				}
				PreparedStatement	auditReasonPStmt = connection.prepareStatement("INSERT INTO OR_ORDER_AMEND_REASON ( ORDER_ID,ACTION_SEQ_NUM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORDER_AMEND_REASON) VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");
				auditReasonPStmt.setString(1,amend_Order_Id);
				auditReasonPStmt.setString(2, amend_reason_seq);
				auditReasonPStmt.setString(3, login_by_id);		
				auditReasonPStmt.setString(4, login_at_ws_no);				
				auditReasonPStmt.setString(5, login_facility_id);	
				auditReasonPStmt.setString(6, login_by_id);					
				auditReasonPStmt.setString(7, login_at_ws_no);
				auditReasonPStmt.setString(8, login_facility_id);
				auditReasonPStmt.setString(9, amnd_Reason);
				auditReasonPStmt.execute();
				closeStatement(auditReasonPStmt);
				closeStatement(auditSeqPStmt);
				
			}
			
			/*IN066779 ends*/

			
			
			//OR_ORDER UPDATION
			ArrayList temp = drugList;
			pstmt_update	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE1"));



			for(int j=0;j<drugList.size();j++) {
				HashMap drugDetails = (HashMap)drugList.get(j);

				drug_code    = (String)drugDetails.get("DRUG_CODE");
				ocurrance_num    = (String)drugDetails.get("OCURRANCE_NUM");	
				//order_id     = orderDetails.get("ORDER_ID"+drug_code+ocurrance_num) == null ? "" : orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
				order_id     = orderDetails.get("ORDER_ID"+drugDetails.get("DRUG_CODE").toString()+drugDetails.get("OCURRANCE_NUM").toString()) == null ? "" : orderDetails.get("ORDER_ID"+drugDetails.get("DRUG_CODE").toString()+drugDetails.get("OCURRANCE_NUM").toString()).toString();				
				pstmt_update.setString(1,(String)drugDetails.get("IV_PREP_YN"));
				pstmt_update.setString(2, (String)drugDetails.get("PERF_LOCN_CODE"));
				pstmt_update.setString(3, login_by_id);
				pstmt_update.setString(4, login_at_ws_no);
				pstmt_update.setString(5, login_facility_id);
				pstmt_update.setString(6, order_id);

				pstmt_update.addBatch();
				
				
			}

			int[] batch_result = pstmt_update.executeBatch();					
			for (int i=0;i<batch_result.length;i++) {
				if(batch_result[i] < 0  && batch_result[i] != -2 ) {
					result = 0;
					break;
				}
				else {
					result = 1;
				}
			}
            //OR_ORDER_LINE UPDATION

			if (result>0) {
				pstmt_update = connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE2"));
				pstmt_update.clearBatch();
				String mfr_yn	= "N";//ML-MMOH-CRF-1014
				if(drugList!=null && drugList.size() > 0){
					pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
					for(int j=0;j<drugList.size();j++) {
						HashMap drugDetails = (HashMap)drugList.get(j);						
						cycle_freq_yn	    = "";//Added for ML-MMOH-CRF-0345
						if (drugDetails!=null && drugDetails.size() != 0) {
							line_no = 0;
							drug_code		= (String)drugDetails.get("DRUG_CODE");
							ocurrance_num		= (String)drugDetails.get("OCURRANCE_NUM");
							order_id			= orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
							amend_stock_value= (String)drugDetails.get("amend_stock_value");
							amend_infusion_period_value = (String)drugDetails.get("amend_infusion_period_value");
							amend_infusion_period_uom = (String)drugDetails.get("amend_infusion_period_uom");
							amend_durn_value = (String)drugDetails.get("amend_durn_value")==null?"0":(String)drugDetails.get("amend_durn_value");
							amend_durn_unit		 = (String)drugDetails.get("amend_durn_unit");    
							amend_start_date	 = (String)drugDetails.get("amend_start_date");	
							amend_end_date		 = (String)drugDetails.get("amend_end_date");		
							amend_frequency		 = (String)drugDetails.get("amend_frequency");
							amend_repeat_value	 = (String)drugDetails.get("amend_repeat_value");	
							dose 				 = (String)drugDetails.get("dose")==null?"0":(String)drugDetails.get("dose");
							mfr_yn				 = (String)drugDetails.get("mfr_yn")==null?"N":(String)drugDetails.get("mfr_yn");//ML-MMOH-CRF-1014
						//ML-MMOH-CRF-0345- start
							cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
							freq_nature	= (String)drugDetails.get("FREQ_NATURE")==null?"F":(String)drugDetails.get("FREQ_NATURE");//ML-MMOH-CRF-0345
							if(cycle_freq_yn.equals("Y")){
								amend_start_date	 = (String)drugDetails.get("CYCLE_START_DATE");	
								amend_end_date		 = (String)drugDetails.get("CYCLE_END_DATE");		
							}//ML-MMOH-CRF-0345- end
							float ing_unit_qty	 = 0.0f;
							float ing_order_qty	 = 0.0f;
							String pack_size     ="";
							String ing_order_uom = "";								
							   
							if (fluidDetails!=null && fluidDetails.size() != 0) {
								HashMap tempFluidMap = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);
								if (tempFluidMap!=null && tempFluidMap.size() != 0) {
									if(tempFluidMap.size() > 0 ){
										strength_uom	= (String)tempFluidMap.get("STRENGTH_UOM");
										stock_uom	= (String)tempFluidMap.get("STOCK_UOM");
										pres_base_uom	= (String)tempFluidMap.get("PRES_BASE_UOM");
										strength_per_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_PRES_UOM");
										strength_per_value_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM");
										dosage_type		= (String)tempFluidMap.get("DOSAGE_TYPE");
										freq_nature	= (String)tempFluidMap.get("FREQ_NATURE")==null?"F":(String)tempFluidMap.get("FREQ_NATURE");
										repeat_durn_type	= (String)tempFluidMap.get("REPEAT_DURN_TYPE")==null?"D":(String)tempFluidMap.get("REPEAT_DURN_TYPE");
										freq_value	= (String)tempFluidMap.get("FREQ_VALUE")==null?"0":(String)tempFluidMap.get("FREQ_VALUE");
										repeat_value	= (String)tempFluidMap.get("REPEAT_VALUE")==null?"0":(String)tempFluidMap.get("REPEAT_VALUE");
										line_no++;
										pstmt_update.setString(1, amend_frequency.trim());
										if(mfr_yn.equals("Y")){//ML-MMOH-CRF-1014 - start
										HashMap Mfr_rec_details =(HashMap)Mfr_details.get(drug_code+ocurrance_num);
										System.err.println("OncologyRegimenBean.java===Mfr_rec_details==7973=>"+Mfr_rec_details);
										if(Mfr_rec_details!=null && Mfr_rec_details.size() > 0)
											pstmt_update.setString(2, ((String)((HashMap)Mfr_details.get(drug_code+ocurrance_num)).get("totDurnHrs")));	
										else
											pstmt_update.setString(2, amend_durn_value);

										
										}else{ //ML-MMOH-CRF-1014 - end
											pstmt_update.setString(2, amend_durn_value.trim());
										}
										pstmt_update.setString(3, amend_durn_unit.trim());
										pstmt_update.setString(4, amend_start_date.trim());
										pstmt_update.setString(5, amend_end_date.trim());

										pack_size	= (String)tempFluidMap.get("FLUID_PACK_SIZE");
										
										if(!amend_stock_value.equals("")&&amend_stock_value!=null){
											order_qty	= (Math.ceil((Float.parseFloat(amend_stock_value)) / Float.parseFloat(pack_size)))+"";	
											order_qty		= (Math.ceil((Float.parseFloat(order_qty)) * (Float.parseFloat(amend_durn_value))*(Float.parseFloat(amend_repeat_value))))+"";	
											order_qty=new Float(order_qty).intValue()+"";	
											in_qty_unit 	= pres_base_uom ;
										}

										tempFluidMap.put("FINAL_ORD_QTY",order_qty+"");
										pstmt_update.setString(6, order_qty.trim());
										pstmt_update.setString(7, stock_uom);
										pstmt_update.setString(8, pract_id); // login_by_id changed to pract_id for  ML-BRU-SCF-0318
										pstmt_update.setString(9, login_by_id);
										pstmt_update.setString(10, login_at_ws_no);
										pstmt_update.setString(11, login_facility_id);
										pstmt_update.setString(12, ((String)tempFluidMap.get("DRUG_CODE")).trim());

										String fluid_short_desc=(String)tempFluidMap.get("SHORT_DESC");

										if(fluid_short_desc!=null && fluid_short_desc.length()>38){
											fluid_short_desc=fluid_short_desc.substring(0,38);
										}
										else{
											fluid_short_desc=fluid_short_desc;
										}

										pstmt_update.setString(13, fluid_short_desc);
										pstmt_update.setString(14, fluid_short_desc);
										pstmt_update.setString(15, ((String)tempFluidMap.get("ORDER_TYPE_CODE")).trim());
										pstmt_update.setString(16, ((String)tempFluidMap.get("FORM_CODE")).trim());
										pstmt_update.setString(17, ((String)tempFluidMap.get("ROUTE_CODE")).trim());
										pstmt_update.setString(18, amend_stock_value.trim());
										pstmt_update.setString(19, in_qty_unit.trim());

										catalog_short_desc = (String)tempFluidMap.get("DRUG_DESC");
										if(catalog_short_desc!=null && catalog_short_desc.length()>38){
										 catalog_short_desc=catalog_short_desc.substring(0,38);
										}
										else{
											catalog_short_desc=catalog_short_desc;
										}
										if(catalog_short_desc==null || catalog_short_desc.equals(""))
											catalog_short_desc	= "";
				
										pstmt_update.setString(20, catalog_short_desc);
										pstmt_update.setString(21, catalog_short_desc);
										drug_code    = (String)tempFluidMap.get("DRUG_CODE"); 
										pstmt_update.setString(22, order_id.trim());
										pstmt_update.setString(23, String.valueOf(line_no));
										pstmt_update.addBatch();	
									}
								}
							}
	
							dosage_type					= (String)drugDetails.get("DOSAGE_TYPE");
							qty_unit					= (String)drugDetails.get("QTY_DESC_CODE");
							repeat_value				= (String)drugDetails.get("REPEAT_VALUE")==null?"0":(String)drugDetails.get("REPEAT_VALUE");
							durn_value					= (String)drugDetails.get("DURN_VALUE");
							durn_desc					= (String)drugDetails.get("DURN_TYPE");
							strength_value				= (String)drugDetails.get("ACT_STRENGTH_VALUE");
							strength_uom				= (String)drugDetails.get("STRENGTH_UOM");
							pres_base_uom				= (String)drugDetails.get("PRES_BASE_UOM");
							stock_uom			= (String)drugDetails.get("STOCK_UOM");
							strength_per_pres_uom		= (String)drugDetails.get("STRENGTH_PER_PRES_UOM");
							content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM")==null?"0":(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
							strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
							freq_nature	= (String)drugDetails.get("FREQ_NATURE")==null?"F":(String)drugDetails.get("FREQ_NATURE");
							repeat_durn_type = (String)drugDetails.get("REPEAT_DURN_TYPE")==null?"D":(String)drugDetails.get("REPEAT_DURN_TYPE");
							freq_value	= (String)drugDetails.get("FREQ_VALUE")==null?"0":(String)drugDetails.get("FREQ_VALUE");
							drug_indication	= (String)drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");

							String int_value_tmp =(String)drugDetails.get("INTERVAL_VALUE");
							String fract_dose    = (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
							qty_unit		 = (String)drugDetails.get("QTY_DESC_CODE");
							ing_order_uom = (String)drugDetails.get("STRENGTH_UOM");
							if (int_value_tmp==null){
								int_value_tmp="1";
							}

					
							if (dosage_type.equals("S")) {//for Strength based
								ing_unit_qty	= Float.parseFloat((String)drugDetails.get("dose"));
								float in_tot_qty	= 0.0f;
								if(fract_dose.equals("Y")){
									in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
								}
								else{
									  in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
								}    



								if (freq_nature.equals("I")) {
									ing_order_qty = in_tot_qty*(Float.parseFloat(durn_value))*(24/(Float.parseFloat(int_value_tmp)));
								}
								else if (freq_nature.equals("F") || freq_nature.equals("C")) {
									ing_order_qty = in_tot_qty*(Float.parseFloat(repeat_value))*(Float.parseFloat(amend_durn_value));
								}
								else if (freq_nature.equals("O") || freq_nature.equals("P")) {
									ing_order_qty = in_tot_qty;
								}
								ing_order_qty	=   new Double(Math.ceil((ing_order_qty)/Float.parseFloat(content_in_pres_base_uom))).floatValue();							
							} 
							else{//for quantity based
								ing_unit_qty	= Float.parseFloat((String)drugDetails.get("dose"));

								equl_value	= "1";
								resultSet			= null;
								pstmt_select.setString(1, ing_order_uom);
								pstmt_select.setString(2, qty_unit);
								pstmt_select.setString(3, ing_order_uom);
								pstmt_select.setString(4, qty_unit);
								resultSet	= pstmt_select.executeQuery();
								if (resultSet.next()) {
									equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
								}

								float in_tot_qty	= 0.0f;

								if(fract_dose.equals("Y")){
									in_tot_qty	=new Double(Math.ceil(ing_unit_qty/(Float.parseFloat(content_in_pres_base_uom)))).floatValue() * Float.parseFloat(equl_value);						
								}
								else{
									in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
								}

								if (freq_nature.equals("I")) {
									ing_order_qty = in_tot_qty*(Float.parseFloat(durn_value))*(24/(Float.parseFloat(int_value_tmp)));
								}
								else if (freq_nature.equals("F") || freq_nature.equals("C")) {
									ing_order_qty = in_tot_qty*(Float.parseFloat(repeat_value))*(Float.parseFloat(amend_durn_value));
								}
								else if (freq_nature.equals("O") || freq_nature.equals("P")) {
									ing_order_qty = in_tot_qty;
								}                 

								if(!fract_dose.equals("Y")){
									ing_order_qty	=   new Double(Math.ceil((ing_order_qty)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									
								}
							}
							drugDetails.put("FINAL_ORD_QTY",ing_order_qty+"");

							line_no++;
							pstmt_update.setString(1, amend_frequency);
							pstmt_update.setString(2, amend_durn_value);
							pstmt_update.setString(3, amend_durn_unit);
							pstmt_update.setString(4, amend_start_date);
							pstmt_update.setString(5, amend_end_date);
							pstmt_update.setString(6, String.valueOf(ing_order_qty));					  
							pstmt_update.setString(7, stock_uom);
							pstmt_update.setString(8, login_by_id);
							pstmt_update.setString(9, login_by_id);
							pstmt_update.setString(10,login_at_ws_no);
							pstmt_update.setString(11,login_facility_id);
							pstmt_update.setString(12, (String)drugDetails.get("DRUG_CODE"));
							pstmt_update.setString(13, (String)drugDetails.get("SHORT_DESC"));
							pstmt_update.setString(14, (String)drugDetails.get("SHORT_DESC"));
							pstmt_update.setString(15, (String)drugDetails.get("ORDER_TYPE_CODE"));
							pstmt_update.setString(16, (String)drugDetails.get("FORM_CODE"));
							pstmt_update.setString(17, (String)drugDetails.get("ROUTE_CODE"));
							pstmt_update.setString(18, (String)drugDetails.get("dose"));
							pstmt_update.setString(19, (String)drugDetails.get("drug_unit_code"));
							catalog_short_desc = (String)drugDetails.get("DRUG_DESC");

							if(catalog_short_desc!=null && catalog_short_desc.length()>39){ 
								catalog_short_desc=catalog_short_desc.substring(0,39);
							}
							else{
								catalog_short_desc=catalog_short_desc;
							}
							if(catalog_short_desc==null || catalog_short_desc.equals(""))
								catalog_short_desc	= "";
						 
							pstmt_update.setString(20, catalog_short_desc);
							pstmt_update.setString(21,catalog_short_desc);
							pstmt_update.setString(22, order_id);
							pstmt_update.setString(23, String.valueOf(line_no));	

							pstmt_update.addBatch();
					   }
					}
					try{
						int[] batch_result1 = pstmt_update.executeBatch();				
						for (int i=0;i<batch_result1.length;i++) {
							if(batch_result1[i] < 0  && batch_result1[i] != -2 ) {
								result = 0;
								break;
							} else {
								result = 1;
							}
						}
					}
					catch(Exception e){
						e.printStackTrace() ;
					}
				}
			}
//OR_ORDER_LINE_PH  UPDATION 
			if (result>0) {
				pstmt_update = connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE3"));
				pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
				pstmt_update.clearBatch();
				String mfr_remarks_insert = "";//ML-MMOH-CRF-1014
				String mfr_yn			  = "";//ML-MMOH-CRF-1014
				for(int j=0;j<drugList.size();j++) {
					HashMap drugDetails = (HashMap)drugList.get(j);
					if(drugDetails!=null && drugDetails.size() > 0){
						mfr_remarks_insert = "";//ML-MMOH-CRF-1014
						mfr_yn = "";//ML-MMOH-CRF-1014
						line_no = 0;
						drug_code		= (String)drugDetails.get("DRUG_CODE");
						ocurrance_num		= (String)drugDetails.get("OCURRANCE_NUM");
						order_id			= orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
						dose 		      = (String)drugDetails.get("dose")==null?"0":(String)drugDetails.get("dose");
						amend_stock_value       = (String)drugDetails.get("amend_stock_value");
						amend_infusion_period_value = (String)drugDetails.get("amend_infusion_period_value");
						amend_infusion_period_uom = (String)drugDetails.get("amend_infusion_period_uom");
						amend_infusion_rate     = (String)drugDetails.get("amend_infusion_rate");
						amend_durn_value  = (String)drugDetails.get("amend_durn_value")==null?"0":(String)drugDetails.get("amend_durn_value");
						amend_durn_unit = (String)drugDetails.get("amend_durn_unit");
						amend_end_date = (String)drugDetails.get("amend_end_date");
						amend_start_date = (String)drugDetails.get("amend_start_date");
						mfr_yn			 = (String)drugDetails.get("mfr_yn")==null?"":(String)drugDetails.get("mfr_yn");//ML-MMOH-CRF-1014 - start
						if(mfr_yn.equals("Y")){
							mfr_remarks_insert 	= (String)mfr_remarks.get(drug_code+ocurrance_num)==null?"":(String)mfr_remarks.get(drug_code+ocurrance_num);
						}//ML-MMOH-CRF-1014 - end
					//ML-MMOH-CRF-0345- start
						cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");//ML-MMOH-CRF-0345
						if(cycle_freq_yn.equals("Y")){
							amend_start_date	 = (String)drugDetails.get("CYCLE_START_DATE");	
							amend_end_date		 = (String)drugDetails.get("CYCLE_END_DATE");		
						}
						//ML-MMOH-CRF-0345- end
						amend_frequency = (String)drugDetails.get("amend_frequency");
						amend_repeat_value	= (String)drugDetails.get("amend_repeat_value");
						dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
						pres_base_uom	= (String)drugDetails.get("PRES_BASE_UOM");
						strength_uom	= (String)drugDetails.get("STRENGTH_UOM");						
						infusion_vol_str_unit="";
						if(dosage_type.equals("S")){
							infusion_vol_str_unit=strength_uom;
						}
						else {
							infusion_vol_str_unit=pres_base_uom;

						}

						tot_infuse_over="";
						if(amend_infusion_period_value!=null && !amend_infusion_period_value.equals("")&& !amend_infusion_rate.equals("")&&amend_infusion_rate!=null){                    
							tot_infuse_over=(Float.parseFloat(amend_infusion_period_value)*Float.parseFloat(amend_infusion_rate)*Integer.parseInt(amend_durn_value)*Integer.parseInt(amend_repeat_value))+"";
						 }
						ArrayList reason	=	null;
						String reason_code	=	"";
						String reason_desc	=	"";
						if(presbeanobj!=null){
							if((presbeanobj.getCalledFromAmend()).equals("PH") ) 								
								 reason	= presbeanobj.getAmendReasonTemp(order_id);								
							else 
								 reason	= presbeanobj.getAmendReason(order_id);							
								
							if(reason!=null && reason.size() > 1 ) {
								reason_code		=	(String)reason.get(1);
								reason_desc		=	(String)reason.get(2);							
							}
						}

						if (fluidDetails!=null  && fluidDetails.size() != 0) {
							HashMap tempFluidMap = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);
							if (tempFluidMap!=null && tempFluidMap.size() != 0) {
								if(tempFluidMap.size() > 0 ){

									dosage_type		= (String)tempFluidMap.get("DOSAGE_TYPE");
									qty_unit		= (String)tempFluidMap.get("QTY_DESC_CODE");
									repeat_value	= (String)tempFluidMap.get("REPEAT_VALUE")==null?"0":(String)tempFluidMap.get("REPEAT_VALUE");
									durn_value		= (String)tempFluidMap.get("DURN_VALUE");
									durn_desc		= (String)tempFluidMap.get("DURN_TYPE");
									strength_value	= (String)tempFluidMap.get("ACT_STRENGTH_VALUE");
									strength_uom	= (String)tempFluidMap.get("STRENGTH_UOM");
									pres_base_uom	= (String)tempFluidMap.get("PRES_BASE_UOM");
									strength_per_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_PRES_UOM");
									strength_per_value_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM");	
									infusion_vol_str_unit=pres_base_uom;

									resultSet			= null;
									pstmt_select.setString(1, amend_frequency);
									pstmt_select.setString(2, dose);
									pstmt_select.setString(3, amend_stock_value);
									pstmt_select.setString(4, amend_durn_value);

									resultSet	= pstmt_select.executeQuery();

									if (resultSet.next()) {
										comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
									}
									if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
										StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
										while(stQty.hasMoreTokens()){
											ord_qty				  =  Float.parseFloat(stQty.nextToken());
											ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
											fluid_qty			  =  Float.parseFloat(stQty.nextToken());
											fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
										}
									}

									in_qty_value	= String.valueOf(fluid_qty_value);
									in_qty_unit 	= pres_base_uom ;
									if(in_qty_value==null) 
										in_qty_value	= "";
									if(in_qty_unit==null) 
										in_qty_unit	= "";
									ord_qty				= fluid_qty;

									equl_value			= "";
									//Only Quantity based for Fluid
									in_tot_strength		= ""; // for Qty_based
									in_tot_strength_uom	= ""; // for Qty_based
									in_bms_qty			= String.valueOf(ord_qty)	; //Equivalent to qty_value
									in_strength_value	= in_tot_strength;
									in_strength_uom		= in_tot_strength_uom;

//FOR DECIMAL CRF 5/1/2010	in_pres_qty_value	= new Float(Float.parseFloat(in_bms_qty)).intValue()+""; 	//Equivalent to bms_qty
									in_pres_qty_value	= new Float(Float.parseFloat(in_bms_qty))+""; 	//Equivalent to bms_qty
									in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit
							  /*==code for calculating TOTAL STRENGTH======*/
									if(dosage_type.equals("S")){
										fld_strength_value = (String)tempFluidMap.get("STRENGTH_VALUE");
										fld_tot_strength    =(Math.ceil(Float.parseFloat(fld_strength_value)*Float.parseFloat(amend_durn_value)*Float.parseFloat(amend_repeat_value)))+"";

									}
								 /*===============ends here================*/

									pstmt_update.setString(1, "");
									pstmt_update.setString(2, fld_tot_strength);
									pstmt_update.setString(3, in_tot_strength_uom);
									pstmt_update.setString(4, amend_infusion_period_value);
									pstmt_update.setString(5,amend_infusion_period_uom);
									pstmt_update.setString(6, amend_infusion_rate);
									pstmt_update.setString(7, infusion_vol_str_unit);
									pstmt_update.setString(8,amend_infusion_period_uom);
									pstmt_update.setString(9, (String)tempFluidMap.get("FINAL_ORD_QTY"));
									pstmt_update.setString(10, fld_tot_strength);
									pstmt_update.setString(11, (String)tempFluidMap.get("SPLIT_DOSE")); 
									pstmt_update.setString(12, in_pres_qty_value);
									pstmt_update.setString(13, in_pres_qty_uom);
									pstmt_update.setString(14,tot_infuse_over);
									pstmt_update.setString(15,amend_infusion_period_uom);
									pstmt_update.setString(16,reason_code);//Amend_reason_code Added for ML-BRU-SCF-0098[IN031837]									
									pstmt_update.setString(17,reason_desc);// reason_desc Added for ML-BRU-SCF-0098 [IN031837]
									pstmt_update.setString(18,(String)tempFluidMap.get("DefaultFluidremarks"));
									pstmt_update.setString(19,"");
									pstmt_update.setString(20, login_by_id);
									pstmt_update.setString(21, login_at_ws_no);
									pstmt_update.setString(22, login_facility_id);
									pstmt_update.setString(23, drugDetails.get("calc_dose")==null?"":(String)drugDetails.get("calc_dose"));
									pstmt_update.setString(24, drugDetails.get("calc_dose_uom")==null?"":(String)drugDetails.get("calc_dose_uom"));
									pstmt_update.setString(25, drugDetails.get("calc_dose_by")==null?"":(String)drugDetails.get("calc_dose_by"));
									pstmt_update.setString(26, drugDetails.get("CALC_DOSE_BASED_ON")==null?"":(String)drugDetails.get("CALC_DOSE_BASED_ON"));
									pstmt_update.setString(27, dosage_type);
									pstmt_update.setString(28, amend_infusion_period_value);//ORIG_INFUSE_OVER
									pstmt_update.setString(29, amend_infusion_rate); //ORIG_INFUSION_RATE
									//pstmt_update.setString(30, buildMAR_yn);
									pstmt_update.setString(30, drugDetails.get("buildMAR_yn").toString()); //CRF-0062
									pstmt_update.setString(31,login_by_id );//login_by_id Added for ML-BRU-SCF-0098 [IN031837]
									pstmt_update.setString(32,"");
									pstmt_update.setString(33, mfr_remarks_insert);//ML-MMOH-CRF-1014
									// Modified for IN:072715 start
									pstmt_update.setString(34,"");
									pstmt_update.setString(35,"");
									pstmt_update.setString(36,"");
									
									pstmt_update.setString(37, order_id);
									pstmt_update.setInt(38, ++line_no);
                                    // Modified for IN:072715 end
									pstmt_update.addBatch();

									pstmt_delete =         connection.prepareStatement("DELETE FROM OR_ORDER_LINE_PH_MFR WHERE ORDER_ID=?");
								pstmt_delete.setString(1, order_id);
								pstmt_delete.executeUpdate(); //int del = pstmt_delete.executeUpdate(); //Modified for Common-icn-0060
								try{
									closeStatement(pstmt_delete);
								}
								catch(Exception es){
									es.printStackTrace() ;
								}
                 
							  PreparedStatement  pstmt_update_Mfr =  connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_MFR_INSERT"));
	                   			HashMap Mfr_rec_details =(HashMap)Mfr_details.get(drug_code+ocurrance_num);
								String tot_rec = "";  
			                    if(Mfr_rec_details != null && Mfr_rec_details.size() > 0 ){
			                    tot_rec =(String)Mfr_rec_details.get("totRec");
								ArrayList Mfr_rec = new ArrayList();
							      for(int k=1;k<=Integer.parseInt(tot_rec);k++){
									Mfr_rec	= (ArrayList)Mfr_rec_details.get("MFR"+k);
				                    pstmt_update_Mfr = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_MFR_INSERT"));
									pstmt_update_Mfr.setString(1, order_id); // ORDER_ID
									pstmt_update_Mfr.setString(2, "1"); //ORDER_LINE_NUM
									pstmt_update_Mfr.setString(3, k+""); //SL_NO
									pstmt_update_Mfr.setString(4, (String)Mfr_rec.get(0)); //TOT_STRENGTH - volume
									pstmt_update_Mfr.setString(5, pres_base_uom); //TOT_STRENGTH_UOM
									pstmt_update_Mfr.setString(6, (String)Mfr_rec.get(5)); //INFUSE_OVER
									pstmt_update_Mfr.setString(7, (String)Mfr_rec.get(2)); //INFUSE_OVER_UNIT 
									pstmt_update_Mfr.setString(8, (String)Mfr_rec.get(1)); //INFUSION_RATE
									pstmt_update_Mfr.setString(9,  pres_base_uom); //INFUSION_VOL_STR_UNIT
									pstmt_update_Mfr.setString(10, (String)Mfr_rec.get(2)); //INFUSION_PER_UNIT
									pstmt_update_Mfr.setString(11,(String)Mfr_rec.get(10) ); //GAP_DURATION_IN_HRS
									pstmt_update_Mfr.setString(12,""); //ADMIN_RATE_DETAIL
									pstmt_update_Mfr.setString(13, com.ehis.util.DateUtils.convertDate((String)Mfr_rec.get(6),"DMYHM",getLanguageId(),"en")); //START_DATE_TIME
									pstmt_update_Mfr.setString(14, com.ehis.util.DateUtils.convertDate((String)Mfr_rec.get(7),"DMYHM",getLanguageId(),"en")); //END_DATE_TIME
									pstmt_update_Mfr.setString(15, login_by_id); //ADDED_BY_ID
									pstmt_update_Mfr.setString(16, login_at_ws_no); //ADDED_AT_WS_NO
									pstmt_update_Mfr.setString(17, login_facility_id); //ADDED_FACILITY_ID
									pstmt_update_Mfr.setString(18, login_by_id); //MODIFIED_BY_ID
									pstmt_update_Mfr.setString(19, login_at_ws_no); //MODIFIED_AT_WS_NO
									pstmt_update_Mfr.setString(20, login_facility_id); // MODIFIED_FACILITY_ID
									pstmt_update_Mfr.executeUpdate();
								
									}
						
									try{
										closeStatement(pstmt_update_Mfr);
									}
									catch(Exception es){
										es.printStackTrace() ;
									}
									}


								}
							}
						}
		
						dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
						qty_unit		= (String)drugDetails.get("QTY_DESC_CODE");
						repeat_value	= (String)drugDetails.get("REPEAT_VALUE")==null?"0":(String)drugDetails.get("REPEAT_VALUE");
						durn_value		= (String)drugDetails.get("DURN_VALUE");
						durn_desc		= (String)drugDetails.get("DURN_TYPE");
						strength_value	= (String)drugDetails.get("ACT_STRENGTH_VALUE");
						strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
						pres_base_uom	= (String)drugDetails.get("PRES_BASE_UOM");
						strength_per_pres_uom = (String)drugDetails.get("STRENGTH_PER_PRES_UOM");
						strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");			amend_infusion_period_value=(String)drugDetails.get("amend_infusion_period_value");				
						amend_infusion_rate = (String)drugDetails.get("amend_infusion_rate");

	// For Drug Based
						if (dosage_type.equals("Q")) {
							dose	= dose;
						}
						else if (dosage_type.equals("S")) {
							if(!strength_per_value_pres_uom.equals("0") && !strength_per_pres_uom.equals("0") && !repeat_value.equals("0") && !dose.equals("")){
								dose_calc	= ( Math.ceil( (((Double.parseDouble(strength_per_value_pres_uom)) * ((Double.parseDouble(dose)) * (Double.parseDouble(repeat_value))))  / (Double.parseDouble(strength_per_pres_uom)) )))+"";
							}
							if (dose_calc==null || dose_calc.equals("")){
								dose_calc="0";
							}
							if(dose!=null && !dose.equals("")){
								
								in_qty_value = String.valueOf(Math.ceil( ((Double.parseDouble(dose))/(Double.parseDouble(strength_value)))));						
								//in_order_qty =  String.valueOf( Math.ceil(((Double.parseDouble(in_qty_value)) * (Double.parseDouble(amend_durn_value))))  );
								in_order_qty =  String.valueOf( Double.parseDouble(dose_calc) * Double.parseDouble(amend_durn_value));
								in_strength_value	= String.valueOf( Math.ceil( ((Double.parseDouble(strength_per_value_pres_uom)) * (Double.parseDouble(dose)) * (Double.parseDouble(repeat_value)))));
								if(in_strength_value!=null)
									in_tot_strength		= String.valueOf( Math.ceil( ((Double.parseDouble(in_strength_value)) *  (Double.parseDouble(amend_durn_value)))));
							}
						}
						if (dosage_type.equals("Q")) {
							
							resultSet			= null;
							//pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
							pstmt_select.setString(1, amend_frequency);
							pstmt_select.setString(2, dose);
							pstmt_select.setString(3, amend_stock_value);
							pstmt_select.setString(4, amend_durn_value);
							
							resultSet	= pstmt_select.executeQuery();
							if (resultSet.next()) {
								comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
							}
							if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
								StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
								while(stQty.hasMoreTokens()){
									ord_qty				  =  Float.parseFloat(stQty.nextToken());
									ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
									fluid_qty			  =  Float.parseFloat(stQty.nextToken());
									fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
								}
							}
							if(ord_qty==0) 
								ord_qty 			= 0.0f;
							if(ord_qty_value==0) 
								ord_qty_value 		= 0.0f;
							if(fluid_qty==0) 
								fluid_qty 			= 0.0f;
							if(fluid_qty_value==0) 
								fluid_qty_value 	= 0.0f;
						}

						if (dosage_type.equals("Q"))
							in_qty_value	= String.valueOf(ord_qty_value);

						in_qty_unit 	= pres_base_uom ;
						if(in_qty_value==null)
							in_qty_value	= "";
						if(in_qty_unit==null) 
							in_qty_unit	= "";
						ord_qty				= ord_qty;
						equl_value		= "";
		
						if(dosage_type.equals("Q")) {
							in_tot_strength		= ""; // for Qty_based
							in_tot_strength_uom	= ""; // for Qty_based
							in_bms_qty			= String.valueOf(ord_qty); //Equivalent to qty_value
							in_strength_value	= in_tot_strength;
							in_strength_uom		= in_tot_strength_uom;
//DECIMAL CRF 5/1/2010		in_pres_qty_value	= new Float(Float.parseFloat(in_bms_qty)).intValue()+"";
							in_pres_qty_value	= new Float(Float.parseFloat(in_bms_qty))+"";
							in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit

						} 
						else if(dosage_type.equals("S")) {
							in_tot_strength_uom	= strength_uom;
							in_bms_qty			= String.valueOf(in_order_qty); //Equivalent to qty_value
							in_strength_uom		= in_tot_strength_uom;
//DECIMAL CRF 5/1/2010		in_pres_qty_value	= new Float(Float.parseFloat(in_bms_qty)).intValue()+""; 	//Equivalent to bms_qty
							in_pres_qty_value	= new Float(Float.parseFloat(in_bms_qty))+""; 	//Equivalent to bms_qty
							in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit
						}

						pstmt_update.setString(1, "");
						pstmt_update.setString(2, in_tot_strength);
						pstmt_update.setString(3, in_tot_strength_uom);
						pstmt_update.setString(4, amend_infusion_period_value);
						pstmt_update.setString(5,amend_infusion_period_uom);
						pstmt_update.setString(6, amend_infusion_rate);
						pstmt_update.setString(7, infusion_vol_str_unit);
						pstmt_update.setString(8,amend_infusion_period_uom);
						pstmt_update.setString(9, (String)drugDetails.get("FINAL_ORD_QTY"));
						pstmt_update.setString(10, in_tot_strength);
						pstmt_update.setString(11, (String)drugDetails.get("SPLIT_DOSE"));		 
						pstmt_update.setString(12, in_pres_qty_value);
						pstmt_update.setString(13, in_pres_qty_uom);
						pstmt_update.setString(14,tot_infuse_over);
						pstmt_update.setString(15,amend_infusion_period_uom);
						pstmt_update.setString(16,reason_code);//reason_code Added for ML-BRU-SCF-0098 [IN031837]
						pstmt_update.setString(17,reason_desc);// reason_desc Added for ML-BRU-SCF-0098 [IN031837]
						pstmt_update.setString(18,"");
						pstmt_update.setString(19,"");				   
						pstmt_update.setString(20, login_by_id);
						pstmt_update.setString(21, login_at_ws_no);
						pstmt_update.setString(22, login_facility_id);
						pstmt_update.setString(23, drugDetails.get("calc_dose")==null?"":(String)drugDetails.get("calc_dose"));
						pstmt_update.setString(24, drugDetails.get("calc_dose_uom")==null?"":(String)drugDetails.get("calc_dose_uom"));
						pstmt_update.setString(25, drugDetails.get("calc_dose_by")==null?"":(String)drugDetails.get("calc_dose_by"));
						pstmt_update.setString(26, drugDetails.get("CALC_DOSE_BASED_ON")==null?"B":(String)drugDetails.get("CALC_DOSE_BASED_ON"));
						pstmt_update.setString(27, dosage_type);
						pstmt_update.setString(28, amend_infusion_period_value);//ORIG_INFUSE_OVER
						pstmt_update.setString(29, amend_infusion_rate); //ORIG_INFUSION_RATE
						//pstmt_update.setString(30, buildMAR_yn);
						pstmt_update.setString(30, drugDetails.get("buildMAR_yn").toString()); //CRF-0062
						pstmt_update.setString(31, login_by_id);//login_by_id Added for ML-BRU-SCF-0098 [IN031837]
						pstmt_update.setString(32,"");
						pstmt_update.setString(33, mfr_remarks_insert);//ML-MMOH-CRF-1014
						// Modified for IN:072715 start
						if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN")).equals("Y")){
							pstmt_update.setString(34,"");
						}
						else if(((String)drugDetails.get("ALLERGY_YN")).equals("Y")){ 
							pstmt_update.setString(34, (String)drugDetails.get("ALLERGY_REMARKS_CODE")); 
						}
						else{
							pstmt_update.setString(34, "");
						}
						if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
							pstmt_update.setString(35,"");
						}
						else if(((String)drugDetails.get("LIMIT_IND")).equals("N")){ 
							pstmt_update.setString(35,(String)drugDetails.get("DOSE_REMARKS_CODE")); 
						}
						else{
							pstmt_update.setString(35,""); 
						}	
						if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
							pstmt_update.setString(36,""); 
						}
						else if(((String)drugDetails.get("CURRENT_RX")).equals("Y")){
							pstmt_update.setString(36, (String)drugDetails.get("CURRENTRX_REMARKS_CODE")); 
						}
						else{
							pstmt_update.setString(36, "");
						}
						
						pstmt_update.setString(37, order_id);
						pstmt_update.setInt(38,++line_no);	
						// Modified for IN:072715 end
						pstmt_update.addBatch(); 
						//if(presbeanobj != null) //This condition added for ML-BRU-SCF-0098 [IN031837]
						//	presbeanobj.clear();
					}
				}  
				try{
					int[] batch_result2 = pstmt_update.executeBatch();				
					for (int i=0;i<batch_result2.length;i++) {
						if(batch_result2[i] < 0  && batch_result2[i] != -2 ) {
							result = 0;
							break;
						}
						else {
							result = 1;
						}
					}	
				}
				catch(Exception e){
					e.printStackTrace() ;
				}
			}
			 //PH_PATIENT_DRUG_PROFILE 
			String split_dose_preview="";
			String uom="";
			HashMap tempFluidMap		= new HashMap();
			if(result>0){
				if (drugList!=null  && drugList.size() !=0) {
					pstmt_update = connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE4"));
					pstmt_update.clearBatch();
					pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
					for(int j=0;j<drugList.size();j++) {
						HashMap drugDetails = (HashMap)drugList.get(j);
						if(result > 0 && drugDetails!=null && drugDetails.size() >0){
							line_no = 0;
							drug_code			= (String)drugDetails.get("DRUG_CODE");

							ocurrance_num			= (String)drugDetails.get("OCURRANCE_NUM");
							order_id				= orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
							dose 						= (String)drugDetails.get("dose");
							strength_value				= (String)drugDetails.get("ACT_STRENGTH_VALUE");
							amend_infusion_period_value = (String)drugDetails.get("amend_infusion_period_value");
							amend_infusion_period_uom 	= (String)drugDetails.get("amend_infusion_period_uom");
							amend_infusion_rate 	= (String)drugDetails.get("amend_infusion_rate");	
							amend_durn_value 			= (String)drugDetails.get("amend_durn_value")==null?"0":(String)drugDetails.get("amend_durn_value");
							amend_durn_unit 			= (String)drugDetails.get("amend_durn_unit");
							amend_frequency 			= (String)drugDetails.get("amend_frequency");
							amend_repeat_value			= (String)drugDetails.get("amend_repeat_value");
							dosage_type					= (String)drugDetails.get("DOSAGE_TYPE");
							dose 						= (String)drugDetails.get("dose")==null?"0":(String)drugDetails.get("dose");
							amend_stock_value= (String)drugDetails.get("amend_stock_value");

							if(fluidDetails!=null && fluidDetails.size() > 0)
								tempFluidMap = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);

				// fluid details updation in a separate line started here.				
								if(tempFluidMap!=null && tempFluidMap.size() > 0){
								
									strength_uom					= (String)tempFluidMap.get("STRENGTH_UOM")==null?"":(String)tempFluidMap.get("STRENGTH_UOM");
									pres_base_uom				= (String)tempFluidMap.get("PRES_BASE_UOM")==null?"":(String)tempFluidMap.get("PRES_BASE_UOM");
									strength_per_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_PRES_UOM");
									strength_per_value_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM");
									dosage_type		= (String)tempFluidMap.get("DOSAGE_TYPE")==null?"":(String)tempFluidMap.get("DOSAGE_TYPE");
								

									in_qty_unit 	= pres_base_uom ;
									if(dosage_type.equals("Q")) {
										strength_uom				="";
										strength_per_pres_uom	    ="";
										strength_per_value_pres_uom	="";
										
									}
									else if(dosage_type.equals("S")) {
										//if(fluidDetails!=null && fluidDetails.size() > 0){
											
											resultSet			= null;
											//pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
											pstmt_select.setString(1, amend_frequency);
											pstmt_select.setString(2, dose);
											pstmt_select.setString(3, amend_stock_value);
											pstmt_select.setString(4, amend_durn_value);
											resultSet	= pstmt_select.executeQuery();

											if (resultSet.next()) {
												comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
											}
											if(comb_ord_qty!=null && !comb_ord_qty.equals("")){

												StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
												while(stQty.hasMoreTokens()){
													ord_qty				  =  Float.parseFloat(stQty.nextToken());
													ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
													fluid_qty			  =  Float.parseFloat(stQty.nextToken());
													fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
												}
											}
											if(ord_qty==0) 
												ord_qty 					= 0.0f;
											if(ord_qty_value==0) 
												ord_qty_value 		= 0.0f;
											if(fluid_qty==0) 
												fluid_qty 				= 0.0f;
											if(fluid_qty_value==0) 
												fluid_qty_value 	= 0.0f;

											in_qty_value	= String.valueOf(fluid_qty_value);
											
											if(in_qty_value==null) in_qty_value	= "";
											if(in_qty_unit==null) in_qty_unit	= "";
											ord_qty				= fluid_qty;
											equl_value			= "";
											//Only Quantity based for Fluid
											in_tot_strength		= ""; // for Qty_based
											in_tot_strength_uom	= ""; // for Qty_based
											in_bms_qty			= String.valueOf(ord_qty)	; //Equivalent to qty_value
											in_strength_value	= in_tot_strength;
											in_strength_uom		= in_tot_strength_uom;
											in_pres_qty_value	= in_bms_qty; 	//Equivalent to bms_qty
											in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit

										//} 
										//else { //drugbased
											/*			
											if(!strength_per_value_pres_uom.equals("0") && !strength_per_pres_uom.equals("0") && !repeat_value.equals("0"))
												dose_calc	= String.valueOf( Math.ceil( (((Double.parseDouble(strength_per_value_pres_uom)) * ((Double.parseDouble(dose)) * (Double.parseDouble(repeat_value))))  / (Double.parseDouble(strength_per_pres_uom)) )));
											if (dose_calc==null || dose_calc.equals("")){
											  dose_calc="0";
											}
											if(dose!=null && !dose.equals("")){				
												in_qty_value = String.valueOf(dose_calc);
												in_order_qty =  String.valueOf( Math.ceil(((Double.parseDouble(in_qty_value)) * (Double.parseDouble(amend_durn_value))))  );

												in_strength_value	= String.valueOf( Math.ceil( ((Double.parseDouble(strength_per_value_pres_uom)) * (Double.parseDouble(dose)) * (Double.parseDouble(repeat_value)))));
												if(in_strength_value!=null)
													in_tot_strength		= String.valueOf( Math.ceil( ((Double.parseDouble(in_strength_value)) *  (Double.parseDouble(amend_durn_value)))));
											}*/
										//}
									}

									if(dosage_type.equals("Q")) {
													
										in_tot_strength		= ""; // for Qty_based
										in_tot_strength_uom	= ""; // for Qty_based
										in_strength_value	= in_tot_strength;
										in_strength_uom		= in_tot_strength_uom;				
										in_pres_qty_value	= new Float(ord_qty)+"";
									} 
									else if(dosage_type.equals("S")) {
			
										in_tot_strength_uom	= strength_uom;
										in_strength_value	= in_tot_strength;
										in_strength_uom		= in_tot_strength_uom;
										//in_pres_qty_value	= new Float(in_order_qty).intValue()+"";
									}
									pstmt_update.setString(1, amend_start_date);
									pstmt_update.setString(2, amend_end_date);
									pstmt_update.setString(3, "N"); 
					/*=====================================================================*/

									HashMap doseUOM=getDosageUOMS();
									uom="";
									split_dose_preview = "";
									if (doseUOM.containsKey( (String)tempFluidMap.get("DRUG_CODE") ) ){
										uom=(String)doseUOM.get((String)tempFluidMap.get("DRUG_CODE"));
									}
									else if(tempFluidMap.size() > 0){
										uom=pres_base_uom;
									}
									else{
										uom=uom;  
									}
									uomDisplay = getUomDisplay(login_facility_id, uom);
									ArrayList frequencyValues	= new ArrayList();
									if (scheduleFreq.size()>0) {
										if(scheduleFreq.containsKey((String)drugDetails.get("DRUG_CODE")+(String)drugDetails.get("OCURRANCE_NUM"))){
											frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails.get("DRUG_CODE")+(String)drugDetails.get("OCURRANCE_NUM"));
										}
									}                

									if (frequencyValues.size()>0) {

										freq_char_list	= (HashMap)frequencyValues.get(0);
										day_list		= (ArrayList)frequencyValues.get(1);
										day_names		= (ArrayList)frequencyValues.get(2);
										time_list		= (ArrayList)frequencyValues.get(3);
										dose_list		= (ArrayList)frequencyValues.get(4);

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
											split_dose_preview = split_dose_preview + " "+uomDisplay;
											split_dose_preview = split_dose_preview + "; ";
										}

										/*for (int n=0; n<frequencyValues.size(); n++) {
											HashMap data		= (HashMap)frequencyValues.get(n);
											split_dose_preview	= split_dose_preview + (String)data.get("admin_time") + " = " + (String)data.get("admin_qty") +  " "+ uom+ " | ";
										}*/
									}

									if (split_dose_preview.length()>1499) {
										split_dose_preview = split_dose_preview.substring(0,1499);
									}
									else {
										split_dose_preview = split_dose_preview;
									}

									pstmt_update.setString(4, split_dose_preview);
									pstmt_update.setString(5, amend_frequency);
									pstmt_update.setString(6, amend_durn_unit);
									pstmt_update.setString(7, amend_durn_value);
									pstmt_update.setString(8, in_pres_qty_value);
									pstmt_update.setString(9,(String)drugDetails.get("IV_PREP_YN"));
									pstmt_update.setString(10, amend_infusion_period_value);
									pstmt_update.setString(11, amend_infusion_period_uom);
									pstmt_update.setString(12, amend_infusion_rate);
									if(amend_infusion_period_value!=null && !amend_infusion_period_value.equals("")){
										 pstmt_update.setString(13,pres_base_uom );
									}
									else{
									  pstmt_update.setString(13,"" ); 

									}
									pstmt_update.setString(14, amend_infusion_period_uom);
									pstmt_update.setString(15, "Y");
									pstmt_update.setString(16, pract_id); // login_by_id changed to pract_id for  ML-BRU-SCF-0318
									pstmt_update.setString(17, "");
									pstmt_update.setString(18, login_by_id);
									pstmt_update.setString(19, login_at_ws_no);
									pstmt_update.setString(20, login_facility_id);		   
									pstmt_update.setString(21,(String)tempFluidMap.get("STRENGTH_VALUE"));
									pstmt_update.setString(22, (String)tempFluidMap.get("STRENGTH_UOM"));
									pstmt_update.setString(23,amend_stock_value);  //dose
									pstmt_update.setString(24, (String)tempFluidMap.get("PRES_BASE_UOM")); //uom
								//	if (tempFluidMap!=null && tempFluidMap.size() > 0) {
										pstmt_update.setString(25, (String)tempFluidMap.get("DOSAGE_TYPE"));
								/*	} else {
										pstmt_update.setString(25, (String)drugDetails.get("DOSAGE_TYPE"));
									}*/
									pstmt_update.setString(26, (String)tempFluidMap.get("DRUG_CODE"));
									pstmt_update.setString(27, (String)tempFluidMap.get("GENERIC_ID"));
									pstmt_update.setString(28, (String)drugDetails.get("IV_INGREDIANTS"));

		//							pstmt_update.setString(29, (String)drugDetails.get("ALLERGY_OVERRIDE_REASON"));

								/*	if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN")).equals("Y")){ //EXTERNAL_ALERGY_OVERRIDE_REASON
											pstmt_update.setString(29, (String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
									}else if(((String)drugDetails.get("ALLERGY_YN")).equals("Y")){					
											pstmt_update.setString(29, (String)drugDetails.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON :
									}else{ */
											pstmt_update.setString(29, "");
								//	}

		//							pstmt_update.setString(30, (String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON"));

								/*	if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
											pstmt_update.setString(30,(String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")); //EXTERNAL_DOSAGE_OVERRIDE_REASON
									}else if(((String)drugDetails.get("LIMIT_IND")).equals("N")){
											pstmt_update.setString(30,(String)drugDetails.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
									}else{  */
											pstmt_update.setString(30,""); //DOSAGE_LIMIT_OVERRIDE_REASON
								//	}

		//							pstmt_update.setString(31, (String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON"));

								/*	if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
										pstmt_update.setString(31, (String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")); //EXTERNAL_DUPLICATE_OVERRIDE_REASON
									}else if(((String)drugDetails.get("CURRENT_RX")).equals("Y")){
										pstmt_update.setString(31, (String)drugDetails.get("CURRENTRX_REMARKS")); // currentrx remarks
									}else{  */
										pstmt_update.setString(31, ""); // currentrx remarks							
								//	}

								//	pstmt_update.setString(32, (String)drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON"));
								//	pstmt_update.setString(33, (String)drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON"));
									pstmt_update.setString(32, "");
									pstmt_update.setString(33, "");

									pstmt_update.setString(34, patient_id);
									pstmt_update.setString(35, order_id);
									pstmt_update.setString(36, String.valueOf(++line_no));	
									
									pstmt_update.addBatch(); 
								}

						/*	if(tempFluidMap!=null && tempFluidMap.size() > 0){
								
								strength_uom					= (String)tempFluidMap.get("STRENGTH_UOM")==null?"":(String)tempFluidMap.get("STRENGTH_UOM");
								pres_base_uom				= (String)tempFluidMap.get("PRES_BASE_UOM")==null?"":(String)tempFluidMap.get("PRES_BASE_UOM");
								strength_per_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_PRES_UOM");
								strength_per_value_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM");
								dosage_type		= (String)tempFluidMap.get("DOSAGE_TYPE")==null?"":(String)tempFluidMap.get("DOSAGE_TYPE");
								
							}
							else{*/
								strength_uom	= (String)drugDetails.get("STRENGTH_UOM")==null?"":(String)drugDetails.get("STRENGTH_UOM");
								pres_base_uom	= (String)drugDetails.get("PRES_BASE_UOM")==null?"":(String)drugDetails.get("PRES_BASE_UOM");
								strength_per_pres_uom = (String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"0":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
								strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"0":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
								dosage_type		= (String)drugDetails.get("DOSAGE_TYPE")==null?"":(String)drugDetails.get("DOSAGE_TYPE");
								repeat_value	= (String)drugDetails.get("REPEAT_VALUE")==null?"0":(String)drugDetails.get("REPEAT_VALUE");
							//}

							in_qty_unit 	= pres_base_uom ;
							if(dosage_type.equals("Q")) {
								strength_uom				="";
								strength_per_pres_uom	    ="";
								strength_per_value_pres_uom	="";
								
							}
							else if(dosage_type.equals("S")) {
								/*
								if(fluidDetails!=null && fluidDetails.size() > 0){
									
									resultSet			= null;
									//pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
									pstmt_select.setString(1, amend_frequency);
									pstmt_select.setString(2, dose);
									pstmt_select.setString(3, amend_stock_value);
									pstmt_select.setString(4, amend_durn_value);
									resultSet	= pstmt_select.executeQuery();

									if (resultSet.next()) {
										comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
									}
System.out.println("comb_ord_qty in amend at 8835 =====|"+comb_ord_qty);
									if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
												
										StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
										while(stQty.hasMoreTokens()){
											ord_qty				  =  Float.parseFloat(stQty.nextToken());
											ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
											fluid_qty			  =  Float.parseFloat(stQty.nextToken());
											fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
										}
									}
									if(ord_qty==0) 
										ord_qty 					= 0.0f;
									if(ord_qty_value==0) 
										ord_qty_value 		= 0.0f;
									if(fluid_qty==0) 
										fluid_qty 				= 0.0f;
									if(fluid_qty_value==0) 
										fluid_qty_value 	= 0.0f;

									in_qty_value	= String.valueOf(fluid_qty_value);
System.out.println("in_qty_value at 8856 in amend ----|"+in_qty_value);									
									if(in_qty_value==null) in_qty_value	= "";
									if(in_qty_unit==null) in_qty_unit	= "";
System.out.println("ord_qty at 8859 in amend ----|"+ord_qty);									
								//	ord_qty				= fluid_qty;
System.out.println("ord_qty at 8861 in amend ----|"+ord_qty);									
									equl_value			= "";
									//Only Quantity based for Fluid
									in_tot_strength		= ""; // for Qty_based
									in_tot_strength_uom	= ""; // for Qty_based
									in_bms_qty			= String.valueOf(ord_qty)	; //Equivalent to qty_value
									in_strength_value	= in_tot_strength;
									in_strength_uom		= in_tot_strength_uom;
									in_pres_qty_value	= in_bms_qty; 	//Equivalent to bms_qty
									in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit
								} 
								else { //drugbased
									*/			



									if(!strength_per_value_pres_uom.equals("0") && !strength_per_pres_uom.equals("0") && !repeat_value.equals("0"))
										dose_calc	= String.valueOf( (((Double.parseDouble(strength_per_value_pres_uom)) * ((Double.parseDouble(dose)) * (Double.parseDouble(repeat_value))))  / (Double.parseDouble(strength_per_pres_uom)) ));
									if (dose_calc==null || dose_calc.equals("")){
									  dose_calc="0";
									}
									if(dose!=null && !dose.equals("")){				

										in_qty_value = String.valueOf(dose_calc);
										in_order_qty =  String.valueOf( ((Double.parseDouble(in_qty_value)) * (Double.parseDouble(amend_durn_value)))  );

										in_strength_value	= String.valueOf( Math.ceil( ((Double.parseDouble(strength_per_value_pres_uom)) * (Double.parseDouble(dose)) * (Double.parseDouble(repeat_value)))));
										if(in_strength_value!=null)
											in_tot_strength		= String.valueOf( Math.ceil( ((Double.parseDouble(in_strength_value)) *  (Double.parseDouble(amend_durn_value)))));
									}
								//}
							}

							if(dosage_type.equals("Q")) {
											
								in_tot_strength		= ""; // for Qty_based
								in_tot_strength_uom	= ""; // for Qty_based
								in_strength_value	= in_tot_strength;
								in_strength_uom		= in_tot_strength_uom;				
								in_pres_qty_value	= new Float(ord_qty)+"";
							} 
							else if(dosage_type.equals("S")) {

								in_tot_strength_uom	= strength_uom;
								in_strength_value	= in_tot_strength;
								in_strength_uom		= in_tot_strength_uom;
								in_pres_qty_value	= new Float(in_order_qty)+"";

							}
							pstmt_update.setString(1, amend_start_date);
							pstmt_update.setString(2, amend_end_date);
							pstmt_update.setString(3, "N"); 
			/*=====================================================================*/

							HashMap doseUOM=getDosageUOMS();
							//String uom="";
							split_dose_preview = "";
//System.out.println("tempFluidMap ---|"+tempFluidMap);							
						/*	if(tempFluidMap.size() <= 0){
								if (doseUOM.containsKey( (String)drugDetails.get("DRUG_CODE") ) ){
									uom=(String)doseUOM.get((String)drugDetails.get("DRUG_CODE"));
								}
								else if(tempFluidMap.size() > 0){
								//	uom=pres_base_uom;
								}
								else{
									uom=uom;  
								}
							}*/

							if (doseUOM.containsKey( (String)drugDetails.get("DRUG_CODE") ) ){
								uom=(String)doseUOM.get((String)drugDetails.get("DRUG_CODE"));
							}else{
								uom=strength_uom;  
							}
							

							uomDisplay	 = getUomDisplay(login_facility_id, uom);
							String drug_dose_uom = "";
							if (doseUOM.containsKey( (String)drugDetails.get("DRUG_CODE") ) ){
								drug_dose_uom=(String)doseUOM.get((String)drugDetails.get("DRUG_CODE"));
							}
							ArrayList frequencyValues	= new ArrayList();
							if (scheduleFreq.size()>0) {
								if(scheduleFreq.containsKey((String)drugDetails.get("DRUG_CODE")+(String)drugDetails.get("OCURRANCE_NUM"))){
									frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails.get("DRUG_CODE")+(String)drugDetails.get("OCURRANCE_NUM"));
								}
							}                

							if (frequencyValues.size()>0) {

								freq_char_list	= (HashMap)frequencyValues.get(0);
								day_list		= (ArrayList)frequencyValues.get(1);
								day_names		= (ArrayList)frequencyValues.get(2);
								time_list		= (ArrayList)frequencyValues.get(3);
								dose_list		= (ArrayList)frequencyValues.get(4);

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
									split_dose_preview = split_dose_preview + " "+uomDisplay;
									split_dose_preview = split_dose_preview + "; ";
								}

								/*for (int n=0; n<frequencyValues.size(); n++) {
									HashMap data		= (HashMap)frequencyValues.get(n);
									split_dose_preview	= split_dose_preview + (String)data.get("admin_time") + " = " + (String)data.get("admin_qty") +  " "+ uom+ " | ";
								}*/
							}

							if (split_dose_preview.length()>1499) {
								split_dose_preview = split_dose_preview.substring(0,1499);
							}
							else {
								split_dose_preview = split_dose_preview;
							}

							pstmt_update.setString(4, split_dose_preview);
							pstmt_update.setString(5, amend_frequency);
							pstmt_update.setString(6, amend_durn_unit);
							pstmt_update.setString(7, amend_durn_value);
							pstmt_update.setString(8, in_pres_qty_value);
							pstmt_update.setString(9,(String)drugDetails.get("IV_PREP_YN"));
							pstmt_update.setString(10, amend_infusion_period_value);
							pstmt_update.setString(11, amend_infusion_period_uom);
							pstmt_update.setString(12, amend_infusion_rate);
							if(amend_infusion_period_value!=null && !amend_infusion_period_value.equals("")){
								 pstmt_update.setString(13,pres_base_uom );
							}
							else{
							  pstmt_update.setString(13,"" ); 

							}
							pstmt_update.setString(14, amend_infusion_period_uom);
							pstmt_update.setString(15, "Y");
							pstmt_update.setString(16,login_by_id );
							pstmt_update.setString(17, "");
							pstmt_update.setString(18, login_by_id);
							pstmt_update.setString(19, login_at_ws_no);
							pstmt_update.setString(20, login_facility_id);		   
							pstmt_update.setString(21,(String)drugDetails.get("STRENGTH_VALUE"));
							pstmt_update.setString(22, (String)drugDetails.get("STRENGTH_UOM"));
							pstmt_update.setString(23,(String)drugDetails.get("dose"));
							pstmt_update.setString(24, drug_dose_uom); //uom
							/* if (tempFluidMap!=null && tempFluidMap.size() > 0) {
								pstmt_update.setString(25, (String)tempFluidMap.get("DOSAGE_TYPE"));
							} else {*/
								pstmt_update.setString(25, (String)drugDetails.get("DOSAGE_TYPE"));
							//}
							pstmt_update.setString(26, (String)drugDetails.get("DRUG_CODE"));
							pstmt_update.setString(27, (String)drugDetails.get("GENERIC_ID"));
							pstmt_update.setString(28, (String)drugDetails.get("IV_INGREDIANTS"));

//							pstmt_update.setString(29, (String)drugDetails.get("ALLERGY_OVERRIDE_REASON"));

							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN")).equals("Y")){ //EXTERNAL_ALERGY_OVERRIDE_REASON
									pstmt_update.setString(29, (String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
							}else if(((String)drugDetails.get("ALLERGY_YN")).equals("Y")){					
									pstmt_update.setString(29, (String)drugDetails.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON :
							}else{
									pstmt_update.setString(29, "");
							}

//							pstmt_update.setString(30, (String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON"));

							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
									pstmt_update.setString(30,(String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")); //EXTERNAL_DOSAGE_OVERRIDE_REASON
							}else if(((String)drugDetails.get("LIMIT_IND")).equals("N")){
									pstmt_update.setString(30,(String)drugDetails.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
							}else{
									pstmt_update.setString(30,""); //DOSAGE_LIMIT_OVERRIDE_REASON
							}

//							pstmt_update.setString(31, (String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON"));

							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
								pstmt_update.setString(31, (String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")); //EXTERNAL_DUPLICATE_OVERRIDE_REASON
							}else if(((String)drugDetails.get("CURRENT_RX")).equals("Y")){
								pstmt_update.setString(31, (String)drugDetails.get("CURRENTRX_REMARKS")); // currentrx remarks
							}else{
								pstmt_update.setString(31, ""); // currentrx remarks							
							}

							pstmt_update.setString(32, (String)drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON"));
							pstmt_update.setString(33, (String)drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON"));
							pstmt_update.setString(34, patient_id);
							pstmt_update.setString(35, order_id);
							pstmt_update.setString(36, String.valueOf(++line_no));
							try{   
								pstmt_update.addBatch(); 
							//	result = pstmt_update.executeUpdate();						
							}
							catch(Exception e){
								e.printStackTrace() ;
							}
						}
					 }
	 				try{
						int[] batch_result2 = pstmt_update.executeBatch();				
						for (int i=0;i<batch_result2.length;i++) {
							if(batch_result2[i] < 0  && batch_result2[i] != -2 ) {
								result = 0;
								break;
							}
							else {
								result = 1;
							}
						}	
					}
					catch(Exception e){
						e.printStackTrace() ;
					}
				} // End of drugList
		   }
             //OR_ORDER_COMMENT
			if (header_comments!=null && header_comments.length() > 0 && temp!=null && temp.size() != 0) {
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT5"));
				pstmt_delete = connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_ORD_CMT_DELETE"));
				pstmt_clob		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT57"));
				for (int i=0; i<temp.size(); i++) {
					HashMap tempMap = (HashMap)temp.get(i);
					if (tempMap!=null && tempMap.size() != 0) {
						drug_code		= (String)tempMap.get("DRUG_CODE");
						ocurrance_num		= (String)tempMap.get("OCURRANCE_NUM");
						order_id			= orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
						pstmt_delete.setString(1,order_id);
						pstmt_delete.executeUpdate();
						pstmt_insert.setString(1, order_id);
						pstmt_insert.setString(2, "1"); // For Insert it will be "1"
						pstmt_insert.setString(3, login_by_id);
						pstmt_insert.setString(4, login_at_ws_no);
						pstmt_insert.setString(5, login_facility_id);
						pstmt_insert.setString(6, login_by_id);
						pstmt_insert.setString(7, login_at_ws_no);
						pstmt_insert.setString(8, login_facility_id);
						result = pstmt_insert.executeUpdate();
						if(result > 0 ){
							pstmt_clob.setString(1,order_id);
							pstmt_clob.setString(2,"1"); // Action_seq_num
							rset_clob=pstmt_clob.executeQuery();

							if(rset_clob!=null){
								while(rset_clob.next()){
									Clob clb 			= (Clob) rset_clob.getClob(1);
									BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
									bw.write(header_comments,0,header_comments.length());
									bw.flush();
									bw.close();
								}
								result = 1;
							}
						}
					}
				
				}
			}
				 //debug = "";

			if(result > 0){
				resultSet							= null;
				pstmt_select						= null;
				String  verf_reqd_bef_med_admin_yn  = "N";
				String  med_admin_reqd_yn 			= "N";
				String iv_prep_yn					=  "";
				ArrayList schd_date_time			= new ArrayList();
				ArrayList tmp_sch_dt_tm				= new ArrayList();
				String admin_time					= "";
				String admin_qty					= "";
				ArrayList tmp_drg_al				= new ArrayList();
				String drug_qty_unit				= "";
				//ML-MMOH-CRF-0345- start
				cycle_freq_yn				= "";
				String cycle_freq_durn_type			= "";
				ArrayList cycle_time_list           = null;
				//ML-MMOH-CRF-0345- end
				pstmt_select = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT25A"));
				pstmt_select.clearBatch();
				pstmt_select.setString(1,login_facility_id);
				resultSet	= pstmt_select.executeQuery();
				if ( resultSet != null && resultSet.next() ) {
					verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
					med_admin_reqd_yn	= resultSet.getString("MED_ADMIN_REQD_YN")==null ? "N":resultSet.getString("MED_ADMIN_REQD_YN");
				}
				//if(med_admin_reqd_yn.equals("Y") && patient_class.equals("IP")){
				//if(buildMAR_yn.equals("Y")){  CRF-0062
					if (drugList!=null  && drugList.size() !=0) {
						boolean freq_values_found	= false;
						int fluid_line_num = 0;
						int drug_line_num  = 0;
						String mfr_yn	   = "";//ML-MMOH-CRF-1014
						pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT2"));			
						pstmt_delete = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_DELETE_MEDN_ADMIN"));							
						pstmt_insert.clearBatch();
						//pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT24A"));
						pstmt_select	= connection.prepareStatement("SELECT    TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') + ?, 'DD/MM/YYYY') || ' '|| ? scheduled_date_time FROM DUAL  WHERE    to_date(TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') +?,'DD/MM/YYYY') || ?, 'DD/MM/YYYY HH24:MI') BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')");
						tmp_drg_al.add(drugList);
						//schd_week_hr_dates = getSchdDatesFrWeekHr(this.getscheduleFrequency(),tmp_drg_al,"UPDATE");//commented for ML-MMOH-CRF-1014
						for(int j=0;j<drugList.size();j++) {
							fluid_line_num = 0;
							drug_line_num  = 0;
							HashMap drugDetails = (HashMap)drugList.get(j);
							buildMAR_yn=drugDetails.get("buildMAR_yn")==null?"":drugDetails.get("buildMAR_yn").toString();  // CRF-0062
							mfr_yn = (String)drugDetails.get("mfr_yn")==null?"":(String)drugDetails.get("mfr_yn");//ML-MMOH-CRF-1014 - start
							if(!mfr_yn.equals("Y")){
								schd_week_hr_dates = getSchdDatesFrWeekHr(this.getscheduleFrequency(),tmp_drg_al,"UPDATE");
							}//ML-MMOH-CRF-1014 - end
						//ML-MMOH-CRF-0345- start
							cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
							if(cycle_freq_yn.equals("Y")) 
							  cycle_time_list = (ArrayList)drugDetails.get("TIME_LIST");
						//ML-MMOH-CRF-0345- start
							if(buildMAR_yn.equals("Y")){  //CRF-0062
								iv_prep_yn = (String)drugDetails.get("IV_PREP_YN");
								if(drugDetails!=null && drugDetails.size() >0){
									++fluid_line_num;
									++drug_line_num;
									drug_code			= (String)drugDetails.get("DRUG_CODE");
									ocurrance_num		= (String)drugDetails.get("OCURRANCE_NUM");
									order_id			= orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
									pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
									schd_date_time	    = (ArrayList)schd_week_hr_dates.get(drug_code);
								//ML-MMOH-CRF-0345- start
									cycle_freq_yn       = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
									cycle_freq_durn_type = (String)drugDetails.get("CYCLE_FREQ_DURN_TYPE")==null?"":(String)drugDetails.get("CYCLE_FREQ_DURN_TYPE");
									if(cycle_freq_yn.equals("Y")) 
									 cycle_time_list = (ArrayList)drugDetails.get("TIME_LIST");
								//ML-MMOH-CRF-0345- end
									pstmt_delete.setString(1, order_id);
									pstmt_delete.setString(2, login_facility_id);
									pstmt_delete.executeUpdate();

									if(iv_prep_yn.equals("9")){
										if(fluidDetails!=null && fluidDetails.size() > 0)
											tempFluidMap = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);
		
										if (tempFluidMap!=null && tempFluidMap.size() > 0){
											++drug_line_num;
										}
										HashMap chkValuescheduleFrequency=scheduleFreq;
										ArrayList frequencyValues = new ArrayList();
										if(chkValuescheduleFrequency.size()>0){
											if(chkValuescheduleFrequency.containsKey(drug_code+ocurrance_num))
												frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code+ocurrance_num);
										}

										if(frequencyValues != null && frequencyValues.size() > 0){
											freq_char_list	= (HashMap)frequencyValues.get(0);
											day_list		= (ArrayList)frequencyValues.get(1);
											day_names		= (ArrayList)frequencyValues.get(2);
											time_list		= (ArrayList)frequencyValues.get(3);
											dose_list		= (ArrayList)frequencyValues.get(4);
										}

										int fr_durn_value = 0;
										durn_value 			= (String)drugDetails.get("amend_durn_value");
										qty_unit			= "";
										dosage_type         = "";
										drug_qty_unit		= "";

										 if (tempFluidMap!=null && tempFluidMap.size() > 0){
											 
											qty_unit= (String)tempFluidMap.get("QTY_UOM");
										 }
										 else{
											dosage_type=(String)drugDetails.get("DOSAGE_TYPE"); 
											if(dosage_type.equals("Q") || dosage_type.equals("A")){
											   qty_unit=(String)drugDetails.get("QTY_UOM");
											}
											else{
											   qty_unit=(String)drugDetails.get("STRENGTH_UOM");
											}
										 }

										dosage_type=(String)drugDetails.get("DOSAGE_TYPE"); 
										if(dosage_type.equals("Q") || dosage_type.equals("A")){
										   drug_qty_unit=(String)drugDetails.get("QTY_UOM");
										}
										else{
										   drug_qty_unit=(String)drugDetails.get("STRENGTH_UOM");
										}
										String amend_durn_type = (String)drugDetails.get("amend_durn_type"); //priya
										if(durn_value!=null && (!(durn_value.equals("")))){
											fr_durn_value=Integer.parseInt(durn_value);
											if(amend_durn_type.equals("W"))
												fr_durn_value = fr_durn_value*7;
											if(amend_durn_type.equals("L"))
												fr_durn_value = fr_durn_value*30;
											if(amend_durn_type.equals("Y"))
												fr_durn_value = fr_durn_value*365;
											}
								
											String interval_value=(String)drugDetails.get("INTERVAL_VALUE")==null?"1":(String)drugDetails.get("INTERVAL_VALUE");
											
											if(fr_durn_value!=0){
												for(int m=0;m<=fr_durn_value;m++){
													if((m != 0) && (Integer.parseInt(interval_value) > 1)){
													m = m+(Integer.parseInt(interval_value) -1);
												}

												if(freq_char_list != null && freq_char_list.size()>0){
													if(!freq_char_list.get("durationType").equals("D")){	
														tmp_sch_dt_tm.clear();
														for(int tmpSch=0;tmpSch<day_list.size();tmpSch++){
														  if((tmpSch+(m*day_list.size()))<schd_date_time.size())
															tmp_sch_dt_tm.add((String)schd_date_time.get(tmpSch+(m*day_list.size())));
														}
													}
												}
												if(frequencyValues!=null && frequencyValues.size()>0){
						
													//for(int n=0;n<frequencyValues.size();n++){
													for(int n=0;n<day_list.size();n++){
														freq_values_found = true;
														int dosage_seqNo=1;
														dosage_seqNo= dosage_seqNo+n;

	/*													HashMap data=new HashMap();
														data=(HashMap)frequencyValues.get(n);
														String admin_time=(String)data.get("admin_time");
														String admin_qty=(String)data.get("admin_qty");*/

														String sch_date_time="";
														admin_time			=(String)time_list.get(n);
														admin_qty			=(String)dose_list.get(n);
														resultSet			= null;
														if(freq_char_list.get("durationType").equals("D")){	
															pstmt_select.setString(1, order_date);
															pstmt_select.setString(2, ""+m);
															pstmt_select.setString(3, admin_time);
															pstmt_select.setString(4, order_date);
															pstmt_select.setString(5, ""+m);
															pstmt_select.setString(6, admin_time);
															pstmt_select.setString(7, order_date);
															pstmt_select.setString(8,(String)drugDetails.get("amend_end_date"));
															resultSet = pstmt_select.executeQuery();

															if (resultSet.next()) {
																sch_date_time = resultSet.getString(1);
															}
															if(resultSet!=null)
																closeResultSet( resultSet ) ;

														}
														else if((freq_char_list.get("durationType").equals("W")) || (freq_char_list.get("durationType").equals("M"))){
															if(tmp_sch_dt_tm.size()>0)
																sch_date_time = (String)tmp_sch_dt_tm.get(n);				
														}	
														if(sch_date_time!= null && !(sch_date_time.equals(""))){
															if (tempFluidMap!=null && tempFluidMap.size() > 0){
												
																pstmt_insert.setString(1,login_facility_id);
																pstmt_insert.setString(2,encounter_id);
																pstmt_insert.setString(3,sch_date_time);
																pstmt_insert.setString(4,(String)tempFluidMap.get("DRUG_CODE"));
																pstmt_insert.setString(5,""+(dosage_seqNo));
																pstmt_insert.setString(6,order_id);
																pstmt_insert.setString(7,String.valueOf(fluid_line_num));
																pstmt_insert.setString(8,patient_id);
																pstmt_insert.setString(9,pract_id);
																pstmt_insert.setString(10, "Y");
																pstmt_insert.setString(11, (String)drugDetails.get("IV_INGREDIANTS"));
																pstmt_insert.setString(12,admin_qty);
																pstmt_insert.setString(13,qty_unit);
																pstmt_insert.setString(14,admin_qty);
																pstmt_insert.setString(15,qty_unit);
															//	if (tempFluidMap!=null && tempFluidMap.size() > 0)
																	pstmt_insert.setString(16,(String)tempFluidMap.get("ROUTE_CODE"));
															//	else
																//	pstmt_insert.setString(16,(String)drugDetails.get("ROUTE_CODE"));

																pstmt_insert.setString(17,(String)drugDetails.get("amend_infusion_rate"));//SCH_INFUSION_RATE

																pstmt_insert.setString(18,(String)tempFluidMap.get("PRES_BASE_UOM") );
																pstmt_insert.setString(19, (String)drugDetails.get("amend_infusion_period_uom"));
																pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
																pstmt_insert.setString(21,login_by_id);
																pstmt_insert.setString(22,login_at_ws_no);
																pstmt_insert.setString(23,login_facility_id);
																pstmt_insert.setString(24,login_by_id);
																pstmt_insert.setString(25,login_at_ws_no);
																pstmt_insert.setString(26,login_facility_id);
																pstmt_insert.setString(27, (String)drugDetails.get("amend_infusion_period_value"));
																pstmt_insert.setString(28, (String)drugDetails.get("amend_infusion_period_uom"));
																pstmt_insert.setString(29, ""); //MAR_BARCODE_ID MMS-QH-CRF-0080 [IN:038064]

																pstmt_insert.addBatch();
															}


															pstmt_insert.setString(1,login_facility_id);
															pstmt_insert.setString(2,encounter_id);
															pstmt_insert.setString(3,sch_date_time);
															pstmt_insert.setString(4,drug_code);
															pstmt_insert.setString(5,""+(dosage_seqNo));
															pstmt_insert.setString(6,order_id);
															pstmt_insert.setString(7,String.valueOf(drug_line_num));
															pstmt_insert.setString(8,patient_id);
															pstmt_insert.setString(9,pract_id);
															pstmt_insert.setString(10, "Y");
															pstmt_insert.setString(11, (String)drugDetails.get("IV_INGREDIANTS"));
															pstmt_insert.setString(12,(String)drugDetails.get("dose"));
															pstmt_insert.setString(13,drug_qty_unit);
															pstmt_insert.setString(14,(String)drugDetails.get("dose"));
															pstmt_insert.setString(15,drug_qty_unit);

														/*	pstmt_insert.setString(12,admin_qty);
															pstmt_insert.setString(13,qty_unit);
															pstmt_insert.setString(14,admin_qty);
															pstmt_insert.setString(15,qty_unit);*/
															/*if (tempFluidMap!=null && tempFluidMap.size() > 0)
																pstmt_insert.setString(16,(String)tempFluidMap.get("ROUTE_CODE"));
															else*/
																pstmt_insert.setString(16,(String)drugDetails.get("ROUTE_CODE"));

															pstmt_insert.setString(17,(String)drugDetails.get("amend_infusion_rate"));//SCH_INFUSION_RATE

															pstmt_insert.setString(18,(String)drugDetails.get("PRES_BASE_UOM") );
															pstmt_insert.setString(19, (String)drugDetails.get("amend_infusion_period_uom"));
															pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
															pstmt_insert.setString(21,login_by_id);
															pstmt_insert.setString(22,login_at_ws_no);
															pstmt_insert.setString(23,login_facility_id);
															pstmt_insert.setString(24,login_by_id);
															pstmt_insert.setString(25,login_at_ws_no);	
															pstmt_insert.setString(26,login_facility_id);
															pstmt_insert.setString(27, (String)drugDetails.get("amend_infusion_period_value"));
															pstmt_insert.setString(28, (String)drugDetails.get("amend_infusion_period_uom"));
															pstmt_insert.setString(29, ""); //MAR_BARCODE_ID MMS-QH-CRF-0080 [IN:038064]
															pstmt_insert.addBatch();
														}//priya
													}
												}else{//ML-MMOH-CRF-0345- start
													if(cycle_time_list!=null && cycle_time_list.size()>0){
													for(int n=0;n<cycle_time_list.size();n++){
														int dosage_seqNo=1;
														dosage_seqNo= dosage_seqNo+n;

														String sch_date_time="";
														admin_time			=(String)cycle_time_list.get(n);
														//admin_qty			=(String)dose_list.get(n);
														resultSet			= null;
														if(cycle_freq_durn_type.equals("D")||cycle_freq_durn_type.equals("W")||cycle_freq_durn_type.equals("L")){	
															pstmt_select.setString(1, (String)drugDetails.get("amend_start_date"));
															pstmt_select.setString(2, ""+m);
															pstmt_select.setString(3, admin_time);
															pstmt_select.setString(4, (String)drugDetails.get("amend_start_date"));
															pstmt_select.setString(5, ""+m);
															pstmt_select.setString(6, admin_time);
															pstmt_select.setString(7, (String)drugDetails.get("amend_start_date"));
															pstmt_select.setString(8,(String)drugDetails.get("amend_end_date"));
															resultSet = pstmt_select.executeQuery();

															if (resultSet.next()) {
																sch_date_time = resultSet.getString(1);
															}
															if(resultSet!=null)
																closeResultSet( resultSet ) ;

														}
															
														if(sch_date_time!= null && !(sch_date_time.equals(""))){
															if (tempFluidMap!=null && tempFluidMap.size() > 0){
												
																pstmt_insert.setString(1,login_facility_id);
																pstmt_insert.setString(2,encounter_id);
																pstmt_insert.setString(3,sch_date_time);
																pstmt_insert.setString(4,(String)tempFluidMap.get("DRUG_CODE"));
																pstmt_insert.setString(5,""+(dosage_seqNo));
																pstmt_insert.setString(6,order_id);
																pstmt_insert.setString(7,String.valueOf(fluid_line_num));
																pstmt_insert.setString(8,patient_id);
																pstmt_insert.setString(9,pract_id);
																pstmt_insert.setString(10, "Y");
																pstmt_insert.setString(11, (String)drugDetails.get("IV_INGREDIANTS"));
																pstmt_insert.setString(12,admin_qty);
																pstmt_insert.setString(13,qty_unit);
																pstmt_insert.setString(14,admin_qty);
																pstmt_insert.setString(15,qty_unit);
																pstmt_insert.setString(16,(String)tempFluidMap.get("ROUTE_CODE"));
																pstmt_insert.setString(17,(String)drugDetails.get("amend_infusion_rate"));//SCH_INFUSION_RATE
															pstmt_insert.setString(18,(String)tempFluidMap.get("PRES_BASE_UOM") );
																pstmt_insert.setString(19, (String)drugDetails.get("amend_infusion_period_uom"));
																pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
																pstmt_insert.setString(21,login_by_id);
																pstmt_insert.setString(22,login_at_ws_no);
																pstmt_insert.setString(23,login_facility_id);
																pstmt_insert.setString(24,login_by_id);
																pstmt_insert.setString(25,login_at_ws_no);
																pstmt_insert.setString(26,login_facility_id);
																pstmt_insert.setString(27, (String)drugDetails.get("amend_infusion_period_value"));
																pstmt_insert.setString(28, (String)drugDetails.get("amend_infusion_period_uom"));
																pstmt_insert.setString(29, ""); //MAR_BARCODE_ID MMS-QH-CRF-0080 [IN:038064]

																pstmt_insert.addBatch();
															}


															pstmt_insert.setString(1,login_facility_id);
															pstmt_insert.setString(2,encounter_id);
															pstmt_insert.setString(3,sch_date_time);
															pstmt_insert.setString(4,drug_code);
															pstmt_insert.setString(5,""+(dosage_seqNo));
															pstmt_insert.setString(6,order_id);
															pstmt_insert.setString(7,String.valueOf(drug_line_num));
															pstmt_insert.setString(8,patient_id);
															pstmt_insert.setString(9,pract_id);
															pstmt_insert.setString(10, "Y");
															pstmt_insert.setString(11, (String)drugDetails.get("IV_INGREDIANTS"));
															pstmt_insert.setString(12,(String)drugDetails.get("dose"));
															pstmt_insert.setString(13,drug_qty_unit);
															pstmt_insert.setString(14,(String)drugDetails.get("dose"));
															pstmt_insert.setString(15,drug_qty_unit);
															pstmt_insert.setString(16,(String)drugDetails.get("ROUTE_CODE"));
															pstmt_insert.setString(17,(String)drugDetails.get("amend_infusion_rate"));//SCH_INFUSION_RATE

															pstmt_insert.setString(18,(String)drugDetails.get("PRES_BASE_UOM") );
															pstmt_insert.setString(19, (String)drugDetails.get("amend_infusion_period_uom"));
															pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
															pstmt_insert.setString(21,login_by_id);
															pstmt_insert.setString(22,login_at_ws_no);
															pstmt_insert.setString(23,login_facility_id);
															pstmt_insert.setString(24,login_by_id);
															pstmt_insert.setString(25,login_at_ws_no);	
															pstmt_insert.setString(26,login_facility_id);
															pstmt_insert.setString(27, (String)drugDetails.get("amend_infusion_period_value"));
															pstmt_insert.setString(28, (String)drugDetails.get("amend_infusion_period_uom"));
															pstmt_insert.setString(29, ""); 
															pstmt_insert.addBatch();
														}//priya
													}//ML-MMOH-CRF-0345- end
													}
												}
											} // m
										} // fr_durn_value
									}
								}
							} // drug List
						} // drug List

						if(freq_values_found){
							try{
								int[] batch_result4 = pstmt_insert.executeBatch();
								for (int i=0;i<batch_result4.length ;i++ ){
									if(batch_result4[i]<0  && batch_result4[i] != -2 ){
										result= 0 ;
									}
									else {
										result = 1;
									}
								}
							}
							catch (Exception e){
								e.printStackTrace() ;
								map.put("result",new Boolean(false));
								map.put("flag",e.getMessage());
								return map;
							}
						}
					}
				//} CRF-0062
			}
				//debug = "";
			if(result > 0 && isSiteSpecific("OR", "OR_ORDER_SET")){ // Added for ML-MMOH-CRF-1225 - Start (isSiteSpecific("OR", "OR_ORDER_SET") this is created for ML-MMOH-CRF-0345 and Chages for ML-MMOH-CRF-1225 is required based on 345 CRF Only.)
				resultSet							= null;
				pstmt_select						= null;			
				String iv_prep_yn					=  "";
				ArrayList schd_date_time			= new ArrayList();
				ArrayList tmp_sch_dt_tm				= new ArrayList();
				String admin_time					= "";
				String admin_qty					= "";
				ArrayList tmp_drg_al				= new ArrayList();
				String drug_qty_unit				= "";			
				cycle_freq_yn				= "";
				String cycle_freq_durn_type			= "";
				ArrayList cycle_time_list           = null;													
				
				if (drugList!=null  && drugList.size() !=0) {

						boolean freq_values_found	= false;
						int fluid_line_num = 0;
						int drug_line_num  = 0;
						String mfr_yn	   = "";
						pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT3"));			
						pstmt_delete = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_DELETE_PH_MEDN_ADMIN_SCH_DTL"));							
						pstmt_insert.clearBatch();	
						pstmt_delete.clearBatch();
						pstmt_select	= connection.prepareStatement("SELECT    TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') + ?, 'DD/MM/YYYY') || ' '|| ? scheduled_date_time FROM DUAL  WHERE    to_date(TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') +?,'DD/MM/YYYY') || ?, 'DD/MM/YYYY HH24:MI') BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')");
						tmp_drg_al.add(drugList);										
						for(int j=0;j<drugList.size();j++) {
							fluid_line_num = 0;
							drug_line_num  = 0;
							freq_values_found	= true;
							HashMap drugDetails = (HashMap)drugList.get(j);							
							mfr_yn = (String)drugDetails.get("mfr_yn")==null?"":(String)drugDetails.get("mfr_yn");
							if(!mfr_yn.equals("Y")){
								schd_week_hr_dates = getSchdDatesFrWeekHr(this.getscheduleFrequency(),tmp_drg_al,"UPDATE");
							}						
							cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
							if(cycle_freq_yn.equals("Y")) 
							  cycle_time_list = (ArrayList)drugDetails.get("TIME_LIST");													
								iv_prep_yn = (String)drugDetails.get("IV_PREP_YN");
								if(drugDetails!=null && drugDetails.size() >0){
									++fluid_line_num;
									++drug_line_num;
									drug_code			= (String)drugDetails.get("DRUG_CODE");
									ocurrance_num		= (String)drugDetails.get("OCURRANCE_NUM");
									order_id			= orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
									pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
									schd_date_time	    = (ArrayList)schd_week_hr_dates.get(drug_code);								
									cycle_freq_yn       = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
									cycle_freq_durn_type = (String)drugDetails.get("CYCLE_FREQ_DURN_TYPE")==null?"":(String)drugDetails.get("CYCLE_FREQ_DURN_TYPE");
									if(cycle_freq_yn.equals("Y")) 
									   cycle_time_list = (ArrayList)drugDetails.get("TIME_LIST");								
									pstmt_delete.setString(1, order_id);
									pstmt_delete.setString(2, login_facility_id);
									pstmt_delete.executeUpdate();
									
										if(fluidDetails!=null && fluidDetails.size() > 0)
											tempFluidMap = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);
		
										if (tempFluidMap!=null && tempFluidMap.size() > 0){
											++drug_line_num;
										}
										HashMap chkValuescheduleFrequency=scheduleFreq;
										ArrayList frequencyValues = new ArrayList();
										if(chkValuescheduleFrequency.size()>0){
											if(chkValuescheduleFrequency.containsKey(drug_code+ocurrance_num))
												frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code+ocurrance_num);
										}

										if(frequencyValues != null && frequencyValues.size() > 0){
											freq_char_list	= (HashMap)frequencyValues.get(0);
											day_list		= (ArrayList)frequencyValues.get(1);
											day_names		= (ArrayList)frequencyValues.get(2);
											time_list		= (ArrayList)frequencyValues.get(3);
											dose_list		= (ArrayList)frequencyValues.get(4);
										}

										int fr_durn_value = 0;
										durn_value 			= (String)drugDetails.get("amend_durn_value");
										qty_unit			= "";
										dosage_type         = "";
										drug_qty_unit		= "";

										 if (tempFluidMap!=null && tempFluidMap.size() > 0){
											 
											qty_unit= (String)tempFluidMap.get("QTY_UOM");
										 }
										 else{
											dosage_type=(String)drugDetails.get("DOSAGE_TYPE"); 
											if(dosage_type.equals("Q") || dosage_type.equals("A")){
											   qty_unit=(String)drugDetails.get("QTY_UOM");
											}
											else{
											   qty_unit=(String)drugDetails.get("STRENGTH_UOM");
											}
										 }

										dosage_type=(String)drugDetails.get("DOSAGE_TYPE"); 
										if(dosage_type.equals("Q") || dosage_type.equals("A")){
										   drug_qty_unit=(String)drugDetails.get("QTY_UOM");
										}
										else{
										   drug_qty_unit=(String)drugDetails.get("STRENGTH_UOM");
										}
										String amend_durn_type = (String)drugDetails.get("amend_durn_type");
										if(durn_value!=null && (!(durn_value.equals("")))){
											fr_durn_value=Integer.parseInt(durn_value);
											if(amend_durn_type.equals("W"))
												fr_durn_value = fr_durn_value*7;
											if(amend_durn_type.equals("L"))
												fr_durn_value = fr_durn_value*30;
											if(amend_durn_type.equals("Y"))
												fr_durn_value = fr_durn_value*365;
											}
								
											String interval_value=(String)drugDetails.get("INTERVAL_VALUE")==null?"1":(String)drugDetails.get("INTERVAL_VALUE");
											
											if(fr_durn_value!=0){
												for(int m=0;m<=fr_durn_value;m++){
													if((m != 0) && (Integer.parseInt(interval_value) > 1)){
													m = m+(Integer.parseInt(interval_value) -1);
												}

												if(freq_char_list != null && freq_char_list.size()>0){
													if(!freq_char_list.get("durationType").equals("D")){	
														tmp_sch_dt_tm.clear();
														for(int tmpSch=0;tmpSch<day_list.size();tmpSch++){
														  if((tmpSch+(m*day_list.size()))<schd_date_time.size())
															tmp_sch_dt_tm.add((String)schd_date_time.get(tmpSch+(m*day_list.size())));
														}
													}
												}
												if(frequencyValues!=null && frequencyValues.size()>0){
																			
													for(int n=0;n<day_list.size();n++){
														freq_values_found = true;
														int dosage_seqNo=1;
														dosage_seqNo= dosage_seqNo+n;
														String sch_date_time="";
														admin_time			=(String)time_list.get(n);
														admin_qty			=(String)dose_list.get(n);
														resultSet			= null;
														if(freq_char_list.get("durationType").equals("D")){	
															pstmt_select.setString(1, order_date);
															pstmt_select.setString(2, ""+m);
															pstmt_select.setString(3, admin_time);
															pstmt_select.setString(4, order_date);
															pstmt_select.setString(5, ""+m);
															pstmt_select.setString(6, admin_time);
															pstmt_select.setString(7, order_date);
															pstmt_select.setString(8,(String)drugDetails.get("amend_end_date"));
															resultSet = pstmt_select.executeQuery();

															if (resultSet.next()) {
																sch_date_time = resultSet.getString(1);
															}
															if(resultSet!=null)
																closeResultSet( resultSet ) ;

														}
														else if((freq_char_list.get("durationType").equals("W")) || (freq_char_list.get("durationType").equals("M"))){
															if(tmp_sch_dt_tm.size()>0)
																sch_date_time = (String)tmp_sch_dt_tm.get(n);				
														}	
														if(sch_date_time!= null && !(sch_date_time.equals(""))){
															if (tempFluidMap!=null && tempFluidMap.size() > 0){
												
																pstmt_insert.setString(1,login_facility_id);
																pstmt_insert.setString(2,encounter_id);
																pstmt_insert.setString(3,sch_date_time);
																pstmt_insert.setString(4,(String)tempFluidMap.get("DRUG_CODE"));
																pstmt_insert.setString(5,""+(dosage_seqNo));
																pstmt_insert.setString(6,order_id);
																pstmt_insert.setString(7,String.valueOf(fluid_line_num));
																pstmt_insert.setString(8,patient_id);
																pstmt_insert.setString(9,pract_id);																
																pstmt_insert.setString(10,admin_qty);
																pstmt_insert.setString(11,qty_unit);
																pstmt_insert.setString(12,admin_qty);
																pstmt_insert.setString(13,qty_unit);																																														
																pstmt_insert.setString(14,login_by_id);
																pstmt_insert.setString(15,login_at_ws_no);
																pstmt_insert.setString(16,login_facility_id);
																pstmt_insert.setString(17,login_by_id);
																pstmt_insert.setString(18,login_at_ws_no);
																pstmt_insert.setString(19,login_facility_id);																
																pstmt_insert.addBatch();
															}


															pstmt_insert.setString(1,login_facility_id);
															pstmt_insert.setString(2,encounter_id);
															pstmt_insert.setString(3,sch_date_time);
															pstmt_insert.setString(4,drug_code);
															pstmt_insert.setString(5,""+(dosage_seqNo));
															pstmt_insert.setString(6,order_id);
															pstmt_insert.setString(7,String.valueOf(drug_line_num));
															pstmt_insert.setString(8,patient_id);
															pstmt_insert.setString(9,pract_id);															
															pstmt_insert.setString(10,(String)drugDetails.get("dose"));
															pstmt_insert.setString(11,drug_qty_unit);
															pstmt_insert.setString(12,(String)drugDetails.get("dose"));
															pstmt_insert.setString(13,drug_qty_unit);												
															pstmt_insert.setString(14,login_by_id);
															pstmt_insert.setString(15,login_at_ws_no);
															pstmt_insert.setString(16,login_facility_id);
															pstmt_insert.setString(17,login_by_id);
															pstmt_insert.setString(18,login_at_ws_no);	
															pstmt_insert.setString(19,login_facility_id);															
															pstmt_insert.addBatch();
														}
													}
												}else{
													if(cycle_time_list!=null && cycle_time_list.size()>0){
													for(int n=0;n<cycle_time_list.size();n++){
														int dosage_seqNo=1;
														dosage_seqNo= dosage_seqNo+n;

														String sch_date_time="";
														admin_time			=(String)cycle_time_list.get(n);														
														resultSet			= null;
														if(cycle_freq_durn_type.equals("D")||cycle_freq_durn_type.equals("W")||cycle_freq_durn_type.equals("L")){	
															pstmt_select.setString(1, (String)drugDetails.get("amend_start_date"));
															pstmt_select.setString(2, ""+m);
															pstmt_select.setString(3, admin_time);
															pstmt_select.setString(4, (String)drugDetails.get("amend_start_date"));
															pstmt_select.setString(5, ""+m);
															pstmt_select.setString(6, admin_time);
															pstmt_select.setString(7, (String)drugDetails.get("amend_start_date"));
															pstmt_select.setString(8,(String)drugDetails.get("amend_end_date"));
															resultSet = pstmt_select.executeQuery();

															if (resultSet.next()) {
																sch_date_time = resultSet.getString(1);
															}
															if(resultSet!=null)
																closeResultSet( resultSet ) ;

														}
															
														if(sch_date_time!= null && !(sch_date_time.equals(""))){
															if (tempFluidMap!=null && tempFluidMap.size() > 0){
												
																pstmt_insert.setString(1,login_facility_id);
																pstmt_insert.setString(2,encounter_id);
																pstmt_insert.setString(3,sch_date_time);
																pstmt_insert.setString(4,(String)tempFluidMap.get("DRUG_CODE"));
																pstmt_insert.setString(5,""+(dosage_seqNo));
																pstmt_insert.setString(6,order_id);
																pstmt_insert.setString(7,String.valueOf(fluid_line_num));
																pstmt_insert.setString(8,patient_id);
																pstmt_insert.setString(9,pract_id);																
																pstmt_insert.setString(10,admin_qty);
																pstmt_insert.setString(11,qty_unit);
																pstmt_insert.setString(12,admin_qty);
																pstmt_insert.setString(13,qty_unit);																
																pstmt_insert.setString(14,login_by_id);
																pstmt_insert.setString(15,login_at_ws_no);
																pstmt_insert.setString(16,login_facility_id);
																pstmt_insert.setString(17,login_by_id);
																pstmt_insert.setString(18,login_at_ws_no);
																pstmt_insert.setString(19,login_facility_id);																
																pstmt_insert.addBatch();
															}														
															pstmt_insert.setString(1,login_facility_id);
															pstmt_insert.setString(2,encounter_id);
															pstmt_insert.setString(3,sch_date_time);
															pstmt_insert.setString(4,drug_code);
															pstmt_insert.setString(5,""+(dosage_seqNo));
															pstmt_insert.setString(6,order_id);
															pstmt_insert.setString(7,String.valueOf(drug_line_num));
															pstmt_insert.setString(8,patient_id);
															pstmt_insert.setString(9,pract_id);
															pstmt_insert.setString(10,(String)drugDetails.get("dose"));
															pstmt_insert.setString(11,drug_qty_unit);
															pstmt_insert.setString(12,(String)drugDetails.get("dose"));
															pstmt_insert.setString(13,drug_qty_unit);																														
															pstmt_insert.setString(14,login_by_id);
															pstmt_insert.setString(15,login_at_ws_no);
															pstmt_insert.setString(16,login_facility_id);
															pstmt_insert.setString(17,login_by_id);
															pstmt_insert.setString(18,login_at_ws_no);	
															pstmt_insert.setString(19,login_facility_id);															
															pstmt_insert.addBatch();
													 }
												        }
													}
												}
											} // m
										} // fr_durn_value									
							  }							
						}

						if(freq_values_found){
							try{
								int[] batch_result4 = pstmt_insert.executeBatch();
								for (int i=0;i<batch_result4.length ;i++ ){
									if(batch_result4[i]<0  && batch_result4[i] != -2 ){
										result= 0 ;
									}
									else {
										result = 1;
									}
								}
							}
							catch (Exception e){
								e.printStackTrace() ;
								map.put("result",new Boolean(false));
								map.put("flag",e.getMessage());
								return map;
							}
						}
				}
									
			} // Added for ML-MMOH-CRF-1225 - End
					// Drug Remarks/Fluid Remarks  Insertion
			if(result > 0 ){
				int order_format_count=	0;
				drug_code	= "";
				order_id		= "";
				String total_seq	= "";

				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT7"));
				pstmt_delete=connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_DELETE_FIELD_VALUES_A"));
				if (drugList!=null  && drugList.size() !=0) {
					for(int j=0;j<drugList.size();j++) {
						HashMap drugDetails = (HashMap)drugList.get(j);
						if(drugDetails!=null && drugDetails.size() >0){
							drug_code			= (String)drugDetails.get("DRUG_CODE");
							ocurrance_num			= (String)drugDetails.get("OCURRANCE_NUM");
							order_id				= orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
//Adding start for IN066779
							PreparedStatement	auditSeqPStmt = connection.prepareStatement("SELECT NVL(MAX(ACTION_SEQ_NUM),0)+1 FROM OR_ORDER_AMEND_REASON WHERE ORDER_ID = ?");
									auditSeqPStmt.setString(1,order_id);				
									ResultSet auditSeqRs = auditSeqPStmt.executeQuery();				
									String amend_reason_seq ="";
									if (auditSeqRs.next()){
										amend_reason_seq	= ChkDef.defaultString(auditSeqRs.getString(1));
									}
									PreparedStatement	auditReasonPStmt = connection.prepareStatement("INSERT INTO OR_ORDER_AMEND_REASON ( ORDER_ID,ACTION_SEQ_NUM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORDER_AMEND_REASON) VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");
									auditReasonPStmt.setString(1,order_id);
									auditReasonPStmt.setString(2, amend_reason_seq);
									auditReasonPStmt.setString(3, login_by_id);		
									auditReasonPStmt.setString(4, login_at_ws_no);				
									auditReasonPStmt.setString(5, login_facility_id);	
									auditReasonPStmt.setString(6, login_by_id);					
									auditReasonPStmt.setString(7, login_at_ws_no);
									auditReasonPStmt.setString(8, login_facility_id);
									auditReasonPStmt.setString(9, amnd_Reason);
									auditReasonPStmt.execute();
									closeStatement(auditReasonPStmt);
									closeStatement(auditSeqPStmt);
						//Adding end for IN066779

							pstmt_delete.setString(1, order_id);
						
							try{
								pstmt_delete.executeUpdate();
							}
							catch(Exception e){
								e.printStackTrace() ;
							}
						}
					}
				}
				pstmt_insert.clearBatch();
				// Fluid Remarks
				if(fluidRemarks!=null && fluidRemarks.size()>0) {
					for (int i=0;i<fluidRemarks.size() ;i++ ){
						HashMap fluidValues= new HashMap();
						fluidValues=(HashMap)fluidRemarks.get(i);
						total_seq=(String)fluidValues.get("order_format_fluid_count") ;
						order_format_count=Integer.parseInt(total_seq);
						for(int k=0;k<order_format_count;k++){
							drug_code	= (String)fluidValues.get("drug_code");
							ocurrance_num	= (String)fluidValues.get("OCURRANCE_NUM");
							order_id	= orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();

							pstmt_insert.setString(1,order_id);
							pstmt_insert.setString(2,"1"); // order_line_num
							pstmt_insert.setString(3,"S");
							pstmt_insert.setString(4,""+(k+1));
							pstmt_insert.setString(5,(String)fluidValues.get("field_mnemonic"+k));
							pstmt_insert.setString(6,(String)fluidValues.get("field_type"+k));
							pstmt_insert.setString(7,(String)fluidValues.get("label_text"+k));
							pstmt_insert.setString(8,(String)fluidValues.get("field_values"+k));
							pstmt_insert.setString(9,"");
							pstmt_insert.setString(10,"");
							pstmt_insert.setString(11,(String)fluidValues.get("accept_option"+k));
							pstmt_insert.setString(12,login_by_id);
							pstmt_insert.setString(13,login_at_ws_no);
							pstmt_insert.setString(14,login_facility_id);
							pstmt_insert.setString(15,login_by_id);
							pstmt_insert.setString(16,login_at_ws_no);
							pstmt_insert.setString(17,login_facility_id);
							pstmt_insert.addBatch();
						}
					}
				}
System.out.println("ONCOLOGY---AMEND------ drugRemarks="+drugRemarks);

				if(drugRemarks!=null && drugRemarks.size()>0) {
					for (int i=0;i<drugRemarks.size() ;i++ ){
						HashMap DrugValues= new HashMap();
						DrugValues=(HashMap)drugRemarks.get(i);
						total_seq=(String)DrugValues.get("order_format_count") ;
						order_format_count=Integer.parseInt(total_seq);
System.out.println("--DrugValues------ order_format_count="+order_format_count);
						for(int k=0;k<order_format_count;k++){
							drug_code	= (String)DrugValues.get("drug_code");
							ocurrance_num	= (String)DrugValues.get("OCURRANCE_NUM");
							order_id	= orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
System.out.println("--DrugValues------ order_id="+order_id);
							pstmt_insert.setString(1,order_id);
							pstmt_insert.setString(2,"2"); // order_line_num
							pstmt_insert.setString(3,"S");
							pstmt_insert.setString(4,""+(k+1));
							pstmt_insert.setString(5,(String)DrugValues.get("field_mnemonic"+k));
							pstmt_insert.setString(6,(String)DrugValues.get("field_type"+k));
							pstmt_insert.setString(7,(String)DrugValues.get("label_text"+k));
							pstmt_insert.setString(8,(String)DrugValues.get("field_values"+k));
							pstmt_insert.setString(9,"");
							pstmt_insert.setString(10,"");
							pstmt_insert.setString(11,(String)DrugValues.get("accept_option"+k));

							pstmt_insert.setString(12,login_by_id);
							pstmt_insert.setString(13,login_at_ws_no);
							pstmt_insert.setString(14,login_facility_id);
							pstmt_insert.setString(15,login_by_id);
							pstmt_insert.setString(16,login_at_ws_no);
							pstmt_insert.setString(17,login_facility_id);
							pstmt_insert.addBatch();
						}
					}
				}
		 
				if((drugRemarks!=null && drugRemarks.size()>0) || (fluidRemarks!=null && fluidRemarks.size()>0)){
					int[] batch_result5 = pstmt_insert.executeBatch();
			
					for (int i=0;i<batch_result5.length ;i++ ){
						if(batch_result5[i]<0  && batch_result5[i] != -2 ){
							result= 0 ;
							break;
						} else {
							result = 1;
						}
					}
			   }
		  } // result
						 
				  // Frequency Insertion
		  if(result > 0){
				if (orderDetails!=null  && orderDetails.size() !=0) {
					boolean freq_values_found	= false;
					pstmt_insert=null;
				//ML-MMOH-CRF-0345- start
					String cycle_day = "";
					String cycle_week = "";
					String cycle_month = "";
					String cycle_freq_durn_desc = "";
					ArrayList cycle_time_list = null;
				//ML-MMOH-CRF-0345- end
//					pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT7"));
					pstmt_insert = connection.prepareStatement("INSERT INTO OR_ORDER_LINE_FIELD_VALUES (ORDER_ID,ORDER_LINE_NUM,ORDER_LINE_FIELD_LEVEL,ORDER_LINE_SEQ_NUM,ORDER_LINE_FIELD_MNEMONIC,ORDER_LINE_FIELD_TYPE,ORDER_LINE_LABEL_TEXT,ORDER_LINE_FIELD_VALUE,ORDER_LINE_DOSE_QTY_VALUE,ORDER_LINE_DOSE_QTY_UNIT,ACCEPT_OPTION,ORDER_LINE_FREQ_DAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ADMIN_WEEK,ADMIN_MONTH) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)");
					//admin_week,admin_month added for ML-MMOH-CRF-0345
					pstmt_insert.clearBatch();
					for(int j=0;j<(orderDetails.size());j++) { //replaced orderDetails.size()-1 by orderDetails.size() for IN23322 reopen -- 04/10/2010-- priya

						if( j < (drugList.size())){
							HashMap drugDetails = (HashMap)drugList.get(j);

							if(drugDetails!=null && drugDetails.size() >0){
								drug_code			= (String)drugDetails.get("DRUG_CODE");
								ocurrance_num			= (String)drugDetails.get("OCURRANCE_NUM");
							//ML-MMOH-CRF-0345- start
								cycle_freq_yn		= (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
								if(cycle_freq_yn.equals("Y")){ 
									cycle_time_list = (ArrayList)drugDetails.get("TIME_LIST");
									 cycle_day= (String)drugDetails.get("DAY_LIST")==null?"1":(String)drugDetails.get("DAY_LIST");
									  cycle_freq_durn_desc = 	(String)drugDetails.get("CYCLE_FREQ_DURN_TYPE")==null?"D":(String)drugDetails.get("CYCLE_FREQ_DURN_TYPE");
									  System.err.println("cycle_freq_durn_desc==========6680===>"+cycle_freq_durn_desc);
									if(cycle_freq_durn_desc.equals("W")){
									cycle_week =  (String)drugDetails.get("CYCLE_NO")==null?"1":(String)drugDetails.get("CYCLE_NO");
									cycle_month = "";
									}
									else{
										if(cycle_freq_durn_desc.equals("L")){
										 cycle_month =   (String)drugDetails.get("CYCLE_NO")==null?"1":(String)drugDetails.get("CYCLE_NO");
										cycle_week = "";
										}
									}
								}//ML-MMOH-CRF-0345- end
								order_id				= orderDetails.get("ORDER_ID"+drug_code+ocurrance_num).toString();
								HashMap chkValuescheduleFrequency=scheduleFreq;
								ArrayList frequencyValues = new ArrayList();
								if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
									if(chkValuescheduleFrequency.containsKey(drug_code+ocurrance_num))
										frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code+ocurrance_num);
								}
								dosage_type					= (String)drugDetails.get("DOSAGE_TYPE");
								if(fluidDetails!=null && fluidDetails.size() > 0)
										tempFluidMap = (HashMap)fluidDetails.get(drug_code+"_"+ocurrance_num);
								if(dosage_type.equals("Q")) {
									if(tempFluidMap!=null && tempFluidMap.size() > 0)
										strength_uom	= (String)tempFluidMap.get("STRENGTH_UOM");
									else
										strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
								}	

								freq_values_found=false;

								freq_char_list	= new HashMap();
								day_list		= new ArrayList();
								time_list		= new ArrayList();
								dose_list		= new ArrayList();
								if(frequencyValues != null && frequencyValues.size() > 0){
									freq_char_list	= (HashMap)frequencyValues.get(0);
									day_list		= (ArrayList)frequencyValues.get(1);
									day_names		= (ArrayList)frequencyValues.get(2);
									time_list		= (ArrayList)frequencyValues.get(3);
									dose_list		= (ArrayList)frequencyValues.get(4);
								}
								if(frequencyValues!=null && frequencyValues.size()>0 && !cycle_freq_yn.equals("Y")){//!cycle_freq_yn.equals added for ML-MMOH-CRF-0345- start
			
								//	for(int n=0;n<frequencyValues.size();n++){
									for(int n=0;n<day_list.size();n++) {
										freq_values_found = true;
			
										int seqNo=200;
										seqNo= seqNo+n;
										durn_desc = "";
								/*		HashMap data=new HashMap();
											data=(HashMap)frequencyValues.get(n);
			
											String admin_time=(String)data.get("admin_time");
											String admin_qty=(String)data.get("admin_qty");*/
										
										durn_desc=strength_uom;

										pstmt_insert.setString(1,order_id);
										pstmt_insert.setString(2,"1");
										pstmt_insert.setString(3,"S");
										pstmt_insert.setString(4,""+(seqNo));
										pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
										pstmt_insert.setString(6,"C");
										pstmt_insert.setString(7,"D");
/*										pstmt_insert.setString(8,admin_time);
										pstmt_insert.setString(9,admin_qty);*/
										pstmt_insert.setString(8,(String)time_list.get(n));
										pstmt_insert.setString(9,(String)dose_list.get(n));
										pstmt_insert.setString(10,durn_desc);
										pstmt_insert.setString(11,"O");
										pstmt_insert.setInt(12,Integer.parseInt(day_list.get(n)+""));
										pstmt_insert.setString(13,login_by_id);
										pstmt_insert.setString(14,login_at_ws_no);
										pstmt_insert.setString(15,login_facility_id);
										pstmt_insert.setString(16,login_by_id);
										pstmt_insert.setString(17,login_at_ws_no);
										pstmt_insert.setString(18,login_facility_id);
										pstmt_insert.setString(19,"");//ML-MMOH-CRF-0345
										pstmt_insert.setString(20,"");//ML-MMOH-CRF-0345
										pstmt_insert.addBatch();
									}
								}else{
								//ML-MMOH-CRF-0345 - start
System.err.println("cycle_freq_yn==>"+cycle_freq_yn+"==cycle_time_list==>"+cycle_time_list);							
								if(cycle_freq_yn.equals("Y")){

									for(int n=0;n<cycle_time_list.size();n++){
										freq_values_found = true;
										int seqNo=200;
										seqNo= seqNo+n;
										durn_desc = "";
										durn_desc=strength_uom;
										pstmt_insert.setString(1,order_id);
										pstmt_insert.setString(2,"1");
										pstmt_insert.setString(3,"S");
										pstmt_insert.setString(4,""+(seqNo));
										pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
										pstmt_insert.setString(6,"C");
										pstmt_insert.setString(7,"D");
										pstmt_insert.setString(8,(String)cycle_time_list.get(n));
										pstmt_insert.setString(9,(String)drugDetails.get("dose"));
										pstmt_insert.setString(10,durn_desc);
										pstmt_insert.setString(11,"O");
										pstmt_insert.setInt(12,Integer.parseInt(cycle_day));
										pstmt_insert.setString(13,login_by_id);
										pstmt_insert.setString(14,login_at_ws_no);
										pstmt_insert.setString(15,login_facility_id);
										pstmt_insert.setString(16,login_by_id);
										pstmt_insert.setString(17,login_at_ws_no);
										pstmt_insert.setString(18,login_facility_id);
										pstmt_insert.setString(19,cycle_week);//CRF-345
										pstmt_insert.setString(20,cycle_month);//CRF-345
										pstmt_insert.addBatch();
									}
								}
							//ML-MMOH-CRF-0345 - end
								}
							}
						}
					}
	
					if(freq_values_found){
						int[] batch_result6 = pstmt_insert.executeBatch();
				
						for (int i=0;i<batch_result6.length ;i++ ){
							if(batch_result6[i]<0  && batch_result6[i] != -2 ){
								result= 0 ;
								break;
							} 
							else {
								result = 1;
							}
						}
					}
			
				}
			}
			if (result>0) {
				map.put("result", new Boolean(true));
				map.put("msgid", "RECORD_INSERTED");
				connection.commit();
			}
			else {
				connection.rollback();
			} 

		}
		catch(Exception e){
			try{
				connection.rollback();
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_clob ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
        }
		return map;
	}

	public HashMap delete() {
		 HashMap map = new HashMap() ;
		 map.put( "result", new Boolean( true ) ) ;
		 map.put( "message", "No deletion allowed here.." ) ;
		 return map ;
	}
	public HashMap modify() {
		 HashMap map = new HashMap() ;
		 map.put( "result", new Boolean( true ) ) ;
		 map.put( "message", "No Modification allowed here.." ) ;
		 return map ;
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
				es.printStackTrace() ;
			}
        }
		return pre_sch_yn;
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
//			for(int n=0;n<frequencyValues.size();n++){
			for(int n=0;n<dose_list.size();n++){
//				data	=(HashMap)frequencyValues.get(n);
//				admin_qty	= ((String)data.get("admin_qty")).trim();
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

	public HashMap  getOrderQty(HashMap drugDetails){
		
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet				= null;
		HashMap ord_qty_values			= new HashMap();
		String  ord_qty				    = "" ;
		String  ord_qty_value			= "" ;
		String  fluid_qty				 = "" ;
		String  fluid_qty_value			= "" ;
		try {
			connection 	= getConnection() ;
			String freq_nature=(String)drugDetails.get("FREQ_NATURE")==null?"F":(String)drugDetails.get("FREQ_NATURE");

			String amend_frequency=(String)drugDetails.get("amend_frequency");
			String dose=(String)drugDetails.get("dose");
			String amend_stock_value=(String)drugDetails.get("amend_stock_value");
			String repeat_durn_type=(String)drugDetails.get("REPEAT_DURN_TYPE")==null?"D":(String)drugDetails.get("REPEAT_DURN_TYPE");
			String amend_durn_value = (String)drugDetails.get("amend_durn_value")==null?"":(String)drugDetails.get("amend_durn_value");
			String comb_ord_qty 		= "";
			String calc_durn_value		= "";

			// calculation of the freq_value;
			if(freq_nature.equals("F") && (repeat_durn_type.equals("D") || repeat_durn_type.equals("M"))){
				calc_durn_value	 = ( Math.ceil( (Double.parseDouble(amend_durn_value))  / (Double.parseDouble((String)drugDetails.get("INTERVAL_VALUE"))) ))+"";
			}
			else if(freq_nature.equals("F") && (repeat_durn_type.equals("W") )){
				calc_durn_value	 = String.valueOf( Math.ceil( (Double.parseDouble(amend_durn_value))  / (7 * (Double.parseDouble((String)drugDetails.get("INTERVAL_VALUE"))) )));
			}
			else{
				calc_durn_value			= amend_durn_value;
			}
									
			resultSet			= null;
			pstmt_select 		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_UNIT"));
			pstmt_select.setString(1, amend_frequency);
			pstmt_select.setString(2, dose);
			pstmt_select.setString(3, amend_stock_value);
			pstmt_select.setString(4, calc_durn_value);

			resultSet	= pstmt_select.executeQuery();

			if (resultSet.next()) {
				comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
			}

			if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
				StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
				while(stQty.hasMoreTokens()){
					ord_qty				  =  (String)stQty.nextToken();
					ord_qty_value		  =  (String)stQty.nextToken();
					fluid_qty			  =  (String)stQty.nextToken();
					fluid_qty_value		  =  (String)stQty.nextToken();
				}
				ord_qty_values.put("ord_qty",ord_qty);
				ord_qty_values.put("ord_qty_value",ord_qty_value);
				ord_qty_values.put("fluid_qty",fluid_qty);
				ord_qty_values.put("fluid_qty_value",fluid_qty_value);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt_select ) ;
			closeConnection( connection );
		   }
		   catch(Exception es){
				es.printStackTrace() ;
		   }
		}
		return ord_qty_values;
	}

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
			pack_size=e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ 
				es.printStackTrace() ;
			}
		}
		return pack_size;
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
		}
		catch(Exception e) {
			stock_uom=e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ 
			 es.printStackTrace() ;
			 }
		}
		return stock_uom;
	}

	public void clearscheduleFrequency(String code){
		if(scheduleFrequency.containsKey(code)) {
			scheduleFrequency.remove(code);
		}
	}

	public String getDurnType(String freq_code)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String durn_type		= "";	

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_DRUG_SELECT2"));
			pstmt.setString(1, freq_code);

			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				durn_type	=	resultSet.getString("REPEAT_DURN_TYPE")==null?"D":resultSet.getString("REPEAT_DURN_TYPE");
			}
		}
		catch(Exception e) {
			durn_type=e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ 
			 es.printStackTrace() ;}
		}
		return durn_type;
	}

	/* public HashMap ChkAdMixture(){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String iv_admixture_appl_yn="";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt.setString(1,getLoginFacilityId());
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                 iv_admixture_appl_yn =resultSet.getString("IV_ADMIXTURE_APPL_YN");
			     result.put("IV_ADMIXTURE_APPL_YN",iv_admixture_appl_yn);
				 result.put("ALERT_PRACTITIONER_YN",resultSet.getString("ALERT_PRACTITIONER_YN"));

			}
            if(iv_admixture_appl_yn.equals("Y")){
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT92") );
				pstmt.setString(1,getLoginFacilityId());
				resultSet = pstmt.executeQuery() ;

				if (resultSet != null && resultSet.next()){
					result.put("time_flag",resultSet.getString(1));				
				}
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
				es.printStackTrace();
			}
		}
		return result;
	}*/

 public HashMap ChkDiscrete(String facility_id,String encounter_id,String note_type){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String contr_module_id="PH";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("SELECT  distinct to_char(TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi:ss') TEST_OBSERV_DT_TM FROM ca_encntr_discr_msr WHERE ? = facility_id(+) and encounter_id = ? and discr_msr_panel_or_form_id = ? and CONTR_MODULE_ID =? ");			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,note_type);
			pstmt.setString(4,contr_module_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                
				 result.put("TEST_OBSERV_DT_TM",resultSet.getString("TEST_OBSERV_DT_TM"));
				
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
				es.printStackTrace();
			}
		}
		return result;
	}
	
	public HashMap ChkAPatientAge(String patient_id){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("SELECT TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH,SEX FROM MP_PATIENT WHERE PATIENT_ID=?");
			pstmt.setString(1,patient_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                
				 result.put("DATE_OF_BIRTH",resultSet.getString("DATE_OF_BIRTH"));
				 result.put("SEX",resultSet.getString("SEX"));
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
				es.printStackTrace();
			}
		}
		return result;
	}
	
    public HashMap ChkScreeningDetails(String facility_id,String encounter_id,String note_type){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String accession_num="";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("SELECT ACCESSION_NUM FROM CA_ENCNTR_NOTE WHERE FACILITY_ID=? AND ENCOUNTER_ID =? AND NOTE_TYPE=?");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,note_type);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                 accession_num =resultSet.getString("ACCESSION_NUM");
			     result.put("ACCESSION_NUM",accession_num);
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
				es.printStackTrace();
			}
		}
		return result;
}

 public HashMap ChkAdMixture(){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String cdr_admixture_appl_yn="";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
		//	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
		pstmt = connection.prepareStatement("select CDR_ADMIXTURE_APPL_YN,IV_ADMIXTURE_APPL_YN,ALERT_PRACTITIONER_YN,ONCOLOGY_SCREENING_TYPE,ONCOLOGY_SCREENING_FORM_ID from ph_facility_param where FACILITY_ID=?");
		                                     

			pstmt.setString(1,getLoginFacilityId());
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                 cdr_admixture_appl_yn =resultSet.getString("CDR_ADMIXTURE_APPL_YN");
			     result.put("CDR_ADMIXTURE_APPL_YN",cdr_admixture_appl_yn);
				 result.put("ALERT_PRACTITIONER_YN",resultSet.getString("ALERT_PRACTITIONER_YN"));
				 result.put("IV_ADMIXTURE_APPL_YN",resultSet.getString("IV_ADMIXTURE_APPL_YN"));
				 result.put("ONCOLOGY_SCREENING_TYPE",resultSet.getString("ONCOLOGY_SCREENING_TYPE"));
				 result.put("ONCOLOGY_SCREENING_FORM_ID",resultSet.getString("ONCOLOGY_SCREENING_FORM_ID"));

			}
            if(cdr_admixture_appl_yn.equals("Y")){
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT92") );
				pstmt.setString(1,getLoginFacilityId());
				resultSet = pstmt.executeQuery() ;

				if (resultSet != null && resultSet.next()){
					result.put("time_flag",resultSet.getString(1));				
				}
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
				es.printStackTrace();
			}
		}
		return result;
	}

 /*======================AMEND =============================================*/
	public HashMap getExistingCYTOOrderDetails(String order_id){
		Connection connection	     = null ;
		PreparedStatement pstmt      = null ;
		ResultSet resultSet		     = null ;
		HashMap Order_Header = new HashMap();
		String order_set_id="";
		try{
			connection = getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_SELECT6")) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				order_set_id=resultSet.getString("ORDER_SET_ID");

			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_ORDER_HEADER_SELECT")) ;
			pstmt.setString(1,order_set_id);
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next() ) {
				Order_Header.put("PRIORITY",resultSet.getString("PRIORITY")==null?"":resultSet.getString("PRIORITY"));
				Order_Header.put("ORD_DATE_TIME",resultSet.getString("ORD_DATE_TIME")==null?"":resultSet.getString("ORD_DATE_TIME"));
				Order_Header.put("PRACTITIONER_NAME",resultSet.getString("PRACTITIONER_NAME")==null?"":resultSet.getString("PRACTITIONER_NAME"));
				Order_Header.put("HEIGHT",resultSet.getString("HEIGHT")==null?"":resultSet.getString("HEIGHT"));
				Order_Header.put("HEIGHT_UOM",resultSet.getString("HEIGHT_UOM")==null?"":resultSet.getString("HEIGHT_UOM"));
				Order_Header.put("WEIGHT",resultSet.getString("WEIGHT")==null?"":resultSet.getString("WEIGHT"));
				Order_Header.put("WEIGHT_UOM",resultSet.getString("WEIGHT_UOM")==null?"":resultSet.getString("WEIGHT_UOM"));
				Order_Header.put("BSA",resultSet.getString("BSA")==null?"":resultSet.getString("BSA"));
				Order_Header.put("DIAG_TEXT",resultSet.getString("DIAG_TEXT")==null?"":resultSet.getString("DIAG_TEXT"));
				Order_Header.put("TAKE_HOME",resultSet.getString("TAKE_HOME")==null?"":resultSet.getString("TAKE_HOME"));
			}
		}
		catch(Exception es){
			es.printStackTrace() ;
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
		return Order_Header;
	}

	public void setExistingCYTORecords(String order_id,String act_pat_class,String source_code, String priority, String atc_allergy_alert_level){  // RUT-CRF-0062 [IN029600]  NEWLY ADDED act_pat_class, source_code, priority TO GET BUILD MAR RULE
		Connection connection	     = null ;
		PreparedStatement pstmt      = null ;
		ResultSet resultSet		     = null ;
		PreparedStatement pstmt1     = null ;
		ResultSet resultSet1		 = null ;
		PreparedStatement pstmt2     = null ;
		ResultSet resultSet2		 = null ;
		PreparedStatement pstmt_pres_select13C	= null;
		ResultSet resultSet3		    		= null ;
		PreparedStatement pstmt_pres_select4A	= null;
		ResultSet resultSet4		    		= null ;

		String sql_str               = "";
		String sql_str1              = "";
		String sql_str2              = "";
		String sql_drg_prfl			 = "";
		String ORDER_ID         	 = "";
		String ORDER_CATALOG_CODE	 = "";
		String ORDER_SET_ID			 = "";
		String ORDER_ID1         	 = "";
		String ORDER_LINE_NUM1		 = "";
		String ORDER_LINE_NUM		 = "";
		String IV_FLUID_YN           = "";
		String IV_INGREDIENT_YN      = "";
		String REGIMEN_CODE            = "";
		int    SRL_NO                = 0; 
		String order_set_id1         ="";
		String OCURRANCE_NUM		=	"";
		String take_home_medication		=	"";  //added for RUT-CRF-0062 
		String generic_id		=	"";  //added for RUT-CRF-0065
		
		//String source_code= "",form_code="",priority="", pat_class="";   // RUT-CRF-0062 [IN029600] COMMENTED
		HashMap record= null;
		HashMap record1=null;
		HashMap	ordId_drgCode		= new HashMap();
		int count_rx	= 0;
		int rec_count	= 0;

		try{
			connection = getConnection();
			sql_str			=	PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_SELECT6");
			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				order_set_id1=resultSet.getString("ORDER_SET_ID");

			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			sql_str			=	PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_SELECT1");
			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,order_set_id1);
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				record = new HashMap();

				ORDER_ID			= resultSet.getString("ORDER_ID")==null?"":resultSet.getString("ORDER_ID");
				record.put("ORDER_ID",resultSet.getString("ORDER_ID")==null?"":resultSet.getString("ORDER_ID"));				
				record.put("ORDER_LINE_NUM",resultSet.getString("ORDER_LINE_NUM")==null?"":resultSet.getString("ORDER_LINE_NUM"));
				record.put("ORDER_CATALOG_CODE",resultSet.getString("ORDER_CATALOG_CODE")==null?"":resultSet.getString("ORDER_CATALOG_CODE"));
				ordId_drgCode.put(ORDER_ID,resultSet.getString("ORDER_CATALOG_CODE"));
				record.put("CATALOG_DESC",resultSet.getString("CATALOG_DESC")==null?"":resultSet.getString("CATALOG_DESC"));
				record.put("OCURRANCE_NUM",resultSet.getString("OCURRANCE_NUM")==null?"":resultSet.getString("OCURRANCE_NUM"));

				if(!getLanguageId().equals("en")){
					record.put("START_DATE_TIME",com.ehis.util.DateUtils.convertDate(resultSet.getString("START_DATE_TIME"),"DMYHM","en",getLanguageId()));
					record.put("END_DATE_TIME",com.ehis.util.DateUtils.convertDate(resultSet.getString("END_DATE_TIME"),"DMYHM","en",getLanguageId()));
				}
				else{	   
					record.put("START_DATE_TIME",resultSet.getString("START_DATE_TIME"));
					record.put("END_DATE_TIME",resultSet.getString("END_DATE_TIME"));
				}
				record.put("QTY_VALUE",resultSet.getString("QTY_VALUE"));
				record.put("QTY_UNIT",resultSet.getString("QTY_UNIT"));
				record.put("FREQ_CODE",resultSet.getString("FREQ_CODE"));
				record.put("DURN_VALUE",resultSet.getString("DURN_VALUE"));
				record.put("DURN_TYPE",resultSet.getString("DURN_TYPE"));
				record.put("ORDER_SET_ID",resultSet.getString("ORDER_SET_ID"));
				record.put("IV_PREP_YN",resultSet.getString("IV_PREP_YN"));

				record.put("CURRENT_RX","N");
				record.put("LIMIT_IND","Y");
				record.put("ALLERGY_YN","N");
				record.put("EXTERNAL_ALERGY_OVERRIDE_REASON","");
				record.put("EXTERNAL_DOSAGE_OVERRIDE_REASON","");
				record.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON","");
				record.put("EXTERNAL_INTERACTION_OVERRIDE_REASON","");
				record.put("EXTERNAL_CONTRA_OVERRIDE_REASON","");
	/*			record.put("SOURCE_CODE",resultSet.getString("SOURCE_CODE")==null?"":resultSet.getString("SOURCE_CODE"));
				record.put("PRIORITY",resultSet.getString("PRIORITY")==null?"":resultSet.getString("PRIORITY"));
				record.put("FORM_CODE",resultSet.getString("FORM_CODE")==null?"":resultSet.getString("FORM_CODE"));
				record.put("PATIENT_CLASS",resultSet.getString("PATIENT_CLASS")==null?"":resultSet.getString("PATIENT_CLASS"));
				pat_class=record.get("PATIENT_CLASS").toString();
				source_code=record.get("SOURCE_CODE").toString();
				form_code=record.get("FORM_CODE").toString();
				priority=record.get("PRIORITY").toString();*/
				String form_code=resultSet.getString("FORM_CODE")==null?"":resultSet.getString("FORM_CODE");
				take_home_medication = resultSet.getString("DISCHARGE_IND")==null?"":resultSet.getString("DISCHARGE_IND");	
				if( act_pat_class.toUpperCase().equals("IP") && (take_home_medication.toUpperCase().equals("D") || take_home_medication.toUpperCase().equals("Y")))
					act_pat_class="DM";
				record.put("BUILD_MAR_RULE",getMARDefaulting(act_pat_class,source_code,form_code,priority));				
				/* code added for RUT-CRF-0062--End  */	
				if(!ORDER_ID.equals("")) {
					existingCYTORecrds.add(record);
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			ORDER_ID			="";
			ORDER_LINE_NUM		="";
			
//			sql_str			    =	PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_SELECT2");
			sql_str = "SELECT  INFUSE_OVER ,INFUSION_RATE , INFUSION_PER_UNIT ,CHNGD_FLUID_REMARKS,INTENTION_CODE, STAGE_CODE ,INFUSION_VOL_STR_UNIT , ALLERGY_OVERRIDE_REASON, DOSAGE_LIMIT_OVERRIDE_REASON, DUPLICATE_DRUG_OVERRIDE_REASON,INTERACTION_OVERRIDE_REASON,CALC_DOSE,CALC_DOSE_UOM,CALC_DOSE_BY,CALC_DOSE_BASED_ON,DOSAGE_TYPE, BUILD_MAR_YN,ALLERGY_OVERRIDE_REASON_CODE,DOSE_LIMIT_OVER_REASON_CODE,DUP_DRUG_OVERRIDE_REASON_CODE FROM OR_ORDER_LINE_PH  WHERE ORDER_ID=? AND ORDER_LINE_NUM=?";// Modified for IN:072715
			sql_str1			=	PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_SELECT3");
			sql_str2			=	PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_SELECT5");
	
			pstmt			    = connection.prepareStatement(sql_str1) ;        
			if(existingCYTORecrds.size()>0){
				record          = (HashMap)existingCYTORecrds.get(0);
				ORDER_SET_ID    = (String)record.get("ORDER_SET_ID");
				pstmt.setString(1,ORDER_SET_ID);
				resultSet	= pstmt.executeQuery();
				if ( resultSet != null && resultSet.next() ) {
					REGIMEN_CODE  = resultSet.getString("ORDER_CATALOG_CODE");
				}
			}		
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			pstmt			    = connection.prepareStatement(sql_str2) ;
			for(int j=0;j<existingCYTORecrds.size();j++){  
				record			  = (HashMap)existingCYTORecrds.get(j);	
				if(record.size()>0){
					ORDER_CATALOG_CODE  = (String)record.get("ORDER_CATALOG_CODE");
					pstmt.setString(1,ORDER_CATALOG_CODE);			
					resultSet	= pstmt.executeQuery();
					if ( resultSet != null && resultSet.next()) {
						IV_FLUID_YN       = resultSet.getString("IV_FLUID_YN");
						IV_INGREDIENT_YN  = resultSet.getString("IV_INGREDIENT_YN");			
					}	
					record.put("IV_FLUID_YN",IV_FLUID_YN);
					record.put("IV_INGREDIENT_YN",IV_INGREDIENT_YN);
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			pstmt			    = connection.prepareStatement(sql_str) ;
			for(int i=0;i<existingCYTORecrds.size();i++){
				
				record				= (HashMap)existingCYTORecrds.get(i);
				ORDER_ID			= (String)record.get("ORDER_ID");
				ORDER_LINE_NUM		= (String)record.get("ORDER_LINE_NUM");					 
				
				pstmt.setString(1,ORDER_ID);
				pstmt.setString(2,ORDER_LINE_NUM);
				resultSet	= pstmt.executeQuery();

				if ( resultSet != null && resultSet.next() ) {
					record.put("INFUSE_OVER",resultSet.getString("INFUSE_OVER")==null?"":resultSet.getString("INFUSE_OVER"));
					record.put("INFUSION_RATE",resultSet.getString("INFUSION_RATE")==null?"":resultSet.getString("INFUSION_RATE"));				
					record.put("INFUSION_PER_UNIT",resultSet.getString("INFUSION_PER_UNIT")==null?"":resultSet.getString("INFUSION_PER_UNIT"));
					record.put("CHNGD_FLUID_REMARKS",resultSet.getString("CHNGD_FLUID_REMARKS")==null?"":resultSet.getString("CHNGD_FLUID_REMARKS"));
					record.put("INTENTION_CODE",resultSet.getString("INTENTION_CODE")==null?"":resultSet.getString("INTENTION_CODE"));
					record.put("STAGE_CODE",resultSet.getString("STAGE_CODE")==null?"":resultSet.getString("STAGE_CODE"));
					record.put("REGIMEN_CODE",REGIMEN_CODE);
					record.put("INFUSION_VOL_STR_UNIT",resultSet.getString("INFUSION_VOL_STR_UNIT")==null?"":resultSet.getString("INFUSION_VOL_STR_UNIT"));
					record.put("ALLERGY_OVERRIDE_REASON",resultSet.getString("ALLERGY_OVERRIDE_REASON")==null?"":resultSet.getString("ALLERGY_OVERRIDE_REASON"));
					record.put("DOSAGE_LIMIT_OVERRIDE_REASON",resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
					record.put("DUPLICATE_DRUG_OVERRIDE_REASON",resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
					record.put("INTERACTION_OVERRIDE_REASON",resultSet.getString("INTERACTION_OVERRIDE_REASON")==null?"":resultSet.getString("INTERACTION_OVERRIDE_REASON"));
					//Added for IN:072715 start
					record.put("ALLERGY_REMARKS_CODE",resultSet.getString("ALLERGY_OVERRIDE_REASON_CODE")==null?"":resultSet.getString("ALLERGY_OVERRIDE_REASON_CODE"));
					record.put("DOSE_REMARKS_CODE",resultSet.getString("DOSE_LIMIT_OVER_REASON_CODE")==null?"":resultSet.getString("DOSE_LIMIT_OVER_REASON_CODE"));
					record.put("CURRENTRX_REMARKS_CODE",resultSet.getString("DUP_DRUG_OVERRIDE_REASON_CODE")==null?"":resultSet.getString("DUP_DRUG_OVERRIDE_REASON_CODE"));
					//Added for IN:072715 end
					record.put("CALC_DOSE",resultSet.getString("CALC_DOSE")==null?"":resultSet.getString("CALC_DOSE"));
					record.put("CALC_DOSE_UOM",resultSet.getString("CALC_DOSE_UOM")==null?"":resultSet.getString("CALC_DOSE_UOM"));
					record.put("CALC_DOSE_BY",resultSet.getString("CALC_DOSE_BY")==null?"":resultSet.getString("CALC_DOSE_BY"));
					record.put("CALC_DOSE_BASED_ON",resultSet.getString("CALC_DOSE_BASED_ON")==null?"B":resultSet.getString("CALC_DOSE_BASED_ON"));
					record.put("DOSAGE_TYPE",resultSet.getString("DOSAGE_TYPE")==null?"":resultSet.getString("DOSAGE_TYPE"));
					record.put("buildMAR_yn",resultSet.getString("BUILD_MAR_YN")==null?"":resultSet.getString("BUILD_MAR_YN"));  // RUT-CRF-0062 [IN029600]
					if(getBuildMAR_yn()==null || getBuildMAR_yn().equals(""))
						setBuildMAR_yn(resultSet.getString("BUILD_MAR_YN"));
				}      
			}
			HashMap record_flag= new HashMap();
			HashMap fluids= new HashMap();

			int n=existingCYTORecrds.size();
			for(int i=0;i<n;i++){
				record	  = (HashMap)existingCYTORecrds.get(i);
				ORDER_ID	  = (String)record.get("ORDER_ID");
				ORDER_LINE_NUM  = (String)record.get("ORDER_LINE_NUM");
				for(int j=i+1;j<n;j++){
					record1	            = (HashMap)existingCYTORecrds.get(j);
					ORDER_ID1	        = (String)record1.get("ORDER_ID");
					ORDER_LINE_NUM1     = (String)record1.get("ORDER_LINE_NUM");
					ORDER_CATALOG_CODE  = (String)record.get("ORDER_CATALOG_CODE");
					if(ORDER_ID == null){ORDER_ID ="";}
					if(ORDER_ID1 == null){ORDER_ID1 ="";}
					if(ORDER_LINE_NUM1 == null){ORDER_LINE_NUM1 ="";}
					if(ORDER_LINE_NUM == null){ORDER_LINE_NUM ="";}

					if(ORDER_ID.equals(ORDER_ID1)&& !ORDER_LINE_NUM1.equals(ORDER_LINE_NUM)){

						existingCYTORecrds.set(i,record1);
						existingCYTORecrds.set(j,record);
						record_flag.put(ORDER_ID,ORDER_ID);
						fluids.put(ORDER_CATALOG_CODE,ORDER_CATALOG_CODE);
						break;
					}
				}
			}
			existingCYTORecrds.add(record_flag);
			existingCYTORecrds.add(fluids);
			n=existingCYTORecrds.size();

			for(int i=0;i<n-2;i++){
				record				= (HashMap)existingCYTORecrds.get(i);
				ORDER_CATALOG_CODE  = (String)record.get("ORDER_CATALOG_CODE");
				if(fluids.containsKey(ORDER_CATALOG_CODE)){
					SRL_NO=SRL_NO;	                
				}
				else{
					SRL_NO=SRL_NO+1;
					record.put("AMEND_SRL_NO",SRL_NO+"");
				}        
			}
			setComponentDrugCodes(order_set_id1,"Existing");

			n=existingCYTORecrds.size();

			for(int i=0;i<n;i++){
				record	  = (HashMap)existingCYTORecrds.get(i);
				if(record.containsKey("ORDER_SET_ID")){
					ORDER_ID	  = (String)record.get("ORDER_ID");
					ORDER_LINE_NUM  = (String)record.get("ORDER_LINE_NUM");
					OCURRANCE_NUM  = (String)record.get("OCURRANCE_NUM");
					ORDER_CATALOG_CODE  = (String)record.get("ORDER_CATALOG_CODE");
					if(!drugCodes.contains(ordId_drgCode.get(ORDER_ID))){
						//addToDrugCodes((String)record.get("ORDER_CATALOG_CODE")); code comented by kiran 
						addToDrugCodes((String)record.get("ORDER_CATALOG_CODE"),OCURRANCE_NUM,OCURRANCE_NUM); //OCURRANCE_NUM added for ML-MMOH-CRF-1227.1
					}
				}
			}

			sql_drg_prfl			 = "SELECT GENERIC_ID, ALLERGY_OVERRIDE_REASON,DOSAGE_LIMIT_OVERRIDE_REASON,DUPLICATE_DRUG_OVERRIDE_REASON,INTERACTION_OVERRIDE_REASON,CONTRAIND_OVERRIDE_REASON FROM PH_PATIENT_DRUG_PROFILE WHERE ORIG_ORDER_ID=? AND ORIG_ORDER_LINE_NO=?";

			pstmt2			    = connection.prepareStatement(sql_drg_prfl) ;
//			pstmt_pres_select13C			= 	connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13C"));
			//pstmt_pres_select13C	= 	connection.prepareStatement("SELECT  COUNT(ROWID) FROM  PH_PATIENT_DRUG_PROFILE A WHERE   PATIENT_ID =? AND END_DATE >= to_date(?,'dd/mm/yyyy hh24:mi') AND  TO_DATE(?,'DD/MM/RRRR HH24:MI') BETWEEN  TO_DATE(START_DATE,'DD/MM/RRRR HH24:MI') AND  TO_DATE(END_DATE,'DD/MM/RRRR HH24:MI')   AND DISCONT_DATE_TIME IS NULL AND ON_HOLD_DATE_TIME IS NULL AND  CANCEL_YN='N' AND   STOP_YN='N' AND GENERIC_ID=?");
			pstmt_pres_select13C	= 	connection.prepareStatement("SELECT  COUNT(ROWID) FROM  PH_PATIENT_DRUG_PROFILE A WHERE   PATIENT_ID =? AND END_DATE >= to_date(?,'dd/mm/yyyy hh24:mi') AND  TO_DATE(?,'DD/MM/RRRR HH24:MI') BETWEEN  START_DATE AND END_DATE  AND DISCONT_DATE_TIME IS NULL AND ON_HOLD_DATE_TIME IS NULL AND  CANCEL_YN='N' AND   STOP_YN='N' AND GENERIC_ID=?"); //modified for IN066782
			String strAD_DA ="'DA', 'AD'";	// Added for HSA-SCF_001 [IN:042444] start
			if(getExcludeADRAllergyAlert().equals("Y")){
				strAD_DA = "'DA'";}		// Added for HSA-SCF-0011 [IN:042444] end
			pstmt_pres_select4A			= connection.prepareStatement("select count(*) from (SELECT   a.adv_reac_code allergy_type_code, b.long_desc allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a,  am_reaction_lang_vw b,pr_allergy_sensitivity C, PH_DRUG d, pr_adverse_event adr  WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type in( "+strAD_DA+")  AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code  AND a.patient_id = ? AND b.reaction_code(+) = a.adv_reac_code  AND b.language_id(+) =? and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO AND C.STATUS = 'A' AND( (adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) union ALL SELECT adv_reac_code allergy_type_code, OTHERS_REACTION allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a ,pr_allergy_sensitivity C , PH_DRUG d, pr_adverse_event adr WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type ='DA' AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code AND a.patient_id = ?  AND a.adv_reac_code  ='Oth'and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO and adr.ALLERGY_ALERT_BY <> 'A' AND C.STATUS = 'A' AND ((adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) )");// Changed for RUT-CRF-0065.1 [IN:43255]
				
				for(int j=0;j<existingCYTORecrds.size();j++){  
					record			  = (HashMap)existingCYTORecrds.get(j);

					ORDER_ID			= (String)record.get("ORDER_ID");
					ORDER_LINE_NUM		= (String)record.get("ORDER_LINE_NUM");					 

					pstmt2.setString(1,ORDER_ID);
					pstmt2.setString(2,ORDER_LINE_NUM);

					resultSet2	= pstmt2.executeQuery();
					if ( resultSet2 != null && resultSet2.next() ) {
							record.put("EXTERNAL_ALERGY_OVERRIDE_REASON",resultSet2.getString("ALLERGY_OVERRIDE_REASON")==null?"":resultSet2.getString("ALLERGY_OVERRIDE_REASON"));
							record.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",resultSet2.getString("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":resultSet2.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
							record.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",resultSet2.getString("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":resultSet2.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
							record.put("EXTERNAL_INTERACTION_OVERRIDE_REASON",resultSet2.getString("INTERACTION_OVERRIDE_REASON")==null?"":resultSet2.getString("INTERACTION_OVERRIDE_REASON"));
							record.put("EXTERNAL_CONTRA_OVERRIDE_REASON",resultSet2.getString("CONTRAIND_OVERRIDE_REASON")==null?"":resultSet2.getString("CONTRAIND_OVERRIDE_REASON"));
							record.put("ALLERGY_OVERRIDE_REASON",resultSet2.getString("ALLERGY_OVERRIDE_REASON")==null?"":resultSet2.getString("ALLERGY_OVERRIDE_REASON"));
							record.put("DOSAGE_LIMIT_OVERRIDE_REASON",resultSet2.getString("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":resultSet2.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
							record.put("DUPLICATE_DRUG_OVERRIDE_REASON",resultSet2.getString("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":resultSet2.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
							record.put("GENERIC_ID",resultSet2.getString("GENERIC_ID")==null?"":resultSet2.getString("GENERIC_ID"));
							generic_id = (String)record.get("GENERIC_ID");
							count_rx	= 0;
							pstmt_pres_select13C.setString(1, getPatId());
							pstmt_pres_select13C.setString(2, getOrderDate());
							pstmt_pres_select13C.setString(3, getOrderDate());
//							pstmt_pres_select13C.setString(4, (String)record.get("FREQ_CODE"));
							pstmt_pres_select13C.setString(4, (String)record.get("GENERIC_ID"));
							resultSet3			= pstmt_pres_select13C.executeQuery();
							if(resultSet3!=null && resultSet3.next()) {
								count_rx=resultSet3.getInt(1);
							}

							if(count_rx>1) {
								record.put("CURRENT_RX","Y");
							}
							else {
								record.put("CURRENT_RX","N");
							}

							pstmt_pres_select4A.setString(1, (String)record.get("ORDER_CATALOG_CODE"));
							pstmt_pres_select4A.setString(2, getPatId());
							pstmt_pres_select4A.setString(3, getLanguageId());
							pstmt_pres_select4A.setString(4, (String)record.get("ORDER_CATALOG_CODE"));
							pstmt_pres_select4A.setString(5, getPatId());
							rec_count	=0;
							resultSet4		= pstmt_pres_select4A.executeQuery();

							if(resultSet4!=null && resultSet4.next()) {
								rec_count=resultSet4.getInt(1);
							}
							closeResultSet( resultSet4 ) ;

							if(rec_count>0) {
								record.put("ALLERGY_YN","Y");
							}
							else {
								record.put("ALLERGY_YN","N");
								//Code Added for	RUT-CRF-0065 IN 29603 - Start
								String ATC_allergy="0";
								if(!atc_allergy_alert_level.equals("N")){
									pstmt1				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL_ALLERGY_CHECK"));
									pstmt1.setString(1,getPatId());
									pstmt1.setString(2,generic_id);
									pstmt1.setString(3,atc_allergy_alert_level);
									resultSet4			= pstmt1.executeQuery();
									if(resultSet4!=null && resultSet4.next())
										ATC_allergy = resultSet4.getString("ATC_CHECK_EXISTS");
									closeResultSet( resultSet4 ) ;
									closeStatement( pstmt1 ) ;
									if(ATC_allergy!=null && !ATC_allergy.equals("0")){
										record.put("ALLERGY_YN","Y");
									}
									else
										record.put("ALLERGY_YN","N");
								}
								//Code Added for	RUT-CRF-0065 IN 29603 - End
							}
						}
				}

		}
		catch(Exception e){
			existingCYTORecrds.add(e.toString());
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt2 ) ;
				closeResultSet( resultSet3 ) ;
				closeStatement( pstmt_pres_select13C ) ;
				closeResultSet( resultSet4 ) ;
				closeStatement( pstmt_pres_select4A ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}       
	}


	public ArrayList populateAllergyDetails(String generic_id,String patient_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		ArrayList details			= new ArrayList();
		try{
			connection					= getConnection() ;
			sql_query					= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT58");
			pstmt						= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,generic_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3, getLanguageId());
			pstmt.setString(4,generic_id);
			pstmt.setString(5,patient_id);

			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				HashMap AllergyDetails		= new HashMap();	
				AllergyDetails.put("ALLERGY_TYPE_CODE",resultSet.getString("ALLERGY_TYPE_CODE"));
				AllergyDetails.put("ALLERGIC_INDICATIONS",resultSet.getString("ALLERGIC_INDICATIONS"));
				AllergyDetails.put("REAC_DATE",resultSet.getString("REAC_DATE"));
				AllergyDetails.put("ALLERGY_ALERT_BY",checkForNull(resultSet.getString("ALLERGY_ALERT_BY")));// Added for RUT-CRF-0065.1 [IN:43255]
				AllergyDetails.put("CAUSATIVE_SUBSTANCE",checkForNull(resultSet.getString("CAUSATIVE_SUBSTANCE")));// Added for RUT-CRF-0065.1 [IN:43255]
				details.add(AllergyDetails);
			}
		 }
		 catch ( Exception e ) {
			details.add("Error"+e);
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
		return details;
   }

   public ArrayList getDuplicateDrugs(String patient_id,String generic_id)	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sql_str			=	"";
		String	start_date		=	"";
		String	end_date		=	"";
		String	drug_desc		=	"";
		String	strength		=	"";
		String	strength_uom_desc	=	"";
		String	form_desc			=	"";
		String	practitioner_name	=	"";
		String	facility_name		=	"";
		String	diag_text			=	"";
		String location				=	"";
		String split_dose_prev		=	"";
		String order_id				=	"";
		String order_line_no		=	"";
		String freq_code			=	"";
		String freq_desc			=	"";
		String allergy_reason		=	"";
		String dosage_reason		=	"";
		String duplicate_reason		=	"";
		String dosage				=	"";
		String dosage_uom_code		=	"";
		ArrayList dupDrugs	= new ArrayList();
		HashMap	record			= null;
		try{
			connection			= getConnection() ;

			sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT59");
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
				dosage				=	resultSet.getString("DOSAGE");
				dosage_uom_code		=	resultSet.getString("DOSAGE_UOM_CODE");

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
				record.put("dosage",dosage);
				record.put("dosage_uom_code",dosage_uom_code);
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

	public ArrayList getPrescribedRemarks(String orig_order_id,String orig_order_line_no) {
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		
		try{
			connection	= getConnection() ;
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_SELECT7") ) ;			
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT5") ) ;			
			pstmt.setString(1,orig_order_id);
			pstmt.setString(2,orig_order_line_no);
			pstmt.setString(3, getLanguageId());
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
				field_value		=	resultSet.getString("ORDER_LINE_FIELD_VALUE");
				qty_value		=	resultSet.getString("ORDER_LINE_DOSE_QTY_VALUE");
				qty_unit		=	resultSet.getString("ORDER_LINE_DOSE_QTY_UNIT");
				freq_day		=	resultSet.getString("ORDER_LINE_FREQ_DAY");

				freq_det.add(field_value);
				freq_det.add(qty_value);
				freq_det.add(qty_unit);
				freq_det.add(freq_day);
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
				es.printStackTrace() ;
			}
		}
		return freq_det;
	}

	 public String getrepeat_value(String freq_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String  sql_query			= "";		
		String	repeat_value		= "";
		try{
			connection			= getConnection() ;
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT7");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,freq_code);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				repeat_value	=	resultSet.getString("REPEAT_VALUE");
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
				es.printStackTrace() ;
			}
		}
		return repeat_value;
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
		return fract_dose;
	}

	public ArrayList getOrderDispenseLocationForCyto(String location_type,String location_code,String take_home_medication,String priority,String iv_prep_yn,String drug_code,String patient_id,String encounter_id ) {//added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
		Connection connection	= null;
        CallableStatement cstmt	= null;
        ResultSet resultSet		= null;
		ArrayList disp_locn		= new ArrayList();
		//added for NMC-JD-CRF-0063
				if(getOpDischMedInd()==null || getOpDischMedInd().equals("")){
					setOpDischMedInd("N"); 
				}
				if(getTakeHomeMedicationOp()!=null && !getTakeHomeMedicationOp().equals("") && getTakeHomeMedicationOp().equals("Y") && getOpDischMedInd()!=null && !getOpDischMedInd().equals("") && getOpDischMedInd().equals("Y")){
					take_home_medication = "Y"; 
				}//END
				
		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call Ph_Ret_Spl_Ord_Disp_Locn(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//modified for NMC-JD-CRF-0063
//System.err.println("@@10951 in bean login_facility_id=="+login_facility_id+"==location_type=="+location_type+"==location_code=="+location_code+"==take_home_medication=="+take_home_medication+"==priority=="+priority+"==iv_prep_yn=="+iv_prep_yn+"==getLanguageId=="+getLanguageId()+"patient_id="+patient_id+" encounter_id="+encounter_id);			
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
			cstmt.setString(12,drug_code);//added  for MMS-QH-CRF-0048 [IN:037704]
			cstmt.setString(13, patient_id);//added for MMS-QH-CRF-0048 [IN:037704]
			cstmt.setString(14, encounter_id);//added for MMS-QH-CRF-0048 [IN:037704]
			cstmt.setString(15,getOpDischMedInd());//added for NMC-JD-CRF-0063
			cstmt.execute();

			disp_locn.add(cstmt.getString(8));
			disp_locn.add(cstmt.getString(9));
			disp_locn.add(cstmt.getString(10));
			this. perf_facility_id = cstmt.getString(11);

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
			catch(Exception es) {
                es.printStackTrace() ;
			}
		}
		return disp_locn;
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

	public void setBillingDetail(HashMap drugDetails, String episode_type, String patient_id, String encounter_id, String drug_code, String ordered_qty,String take_home_medication){
		Connection connection       = null ;
		CallableStatement cstmt = null ;
		PreparedStatement pstmt = null;
		ResultSet rsDecimalPlace= null;
		int decimal_place = 0;
		String decimalFormatString = "#0";
		//String order_Date = getOrderDate()+":00";
		String order_Date = getOrderDate()+":00";
		if(!getLanguageId().equals("en")){
			order_Date= com.ehis.util.DateUtils.convertDate(order_Date,"DMYHMS",getLanguageId(),"en");
		}
		String item_code			= (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");
		String episode_id			= "";
		String visit_id				= "";
		String total_charge_amt		= "";
		String patient_payable_amt  = "";
		String approval_reqd_yn		= "";
		String override_allowed_yn	= "";
		String bl_included_IE		= "";
		String error_code			= "";		 
		String sys_message_id		= "";	
		String error_text			= "";
		String billable_item_yn     = "";
		String bl_incl_excl_override_value  = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");
		String overriden_action_reason		= (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");
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

			//System.err.println("@@ONCOLOGY GET_CHARGE_DTLS_MAT_ITEM Parameters login_facility_id="+login_facility_id+" episode_type="+episode_type+" PatientId="+patient_id+" episode_id="+episode_id+" visit_id="+visit_id+" Date="+ order_Date+" item_code="+item_code+" qty_served="+ordered_qty+" bl_incl_excl_override_value="+bl_incl_excl_override_value+" overriden_action_reason="+overriden_action_reason);
			billable_item_yn  = (String)getBillableItemYN(item_code)==null?"N":(String)getBillableItemYN(item_code);

           if(billable_item_yn.equals("Y")){
				cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?,?)}");
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

				cstmt.setString( 54,bl_incl_excl_override_value );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
				cstmt.setString( 55, overriden_action_reason);  //p_overridden_action_reason		 --- Pass null or any value entered 

				cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
				cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
				cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text
				cstmt.setString( 59, take_home_medication);

				cstmt.execute() ;
				gross_amt		        =cstmt.getString(34); // Added for ML-BRU-CRF-0469 [IN:065426]
				total_charge_amt		=cstmt.getString(36);
				patient_payable_amt		= cstmt.getString(40);
				bl_included_IE	= cstmt.getString(51)==null?"":cstmt.getString(51);             
				approval_reqd_yn		= cstmt.getString(52)==null?"":cstmt.getString(52);   
				override_allowed_yn		= cstmt.getString(53)==null?"":cstmt.getString(53); 

				error_code		= cstmt.getString(56);
				sys_message_id	= cstmt.getString(57);
				error_text		= cstmt.getString(58);
				//System.err.println("@@GET_CHARGE_DTLS_MAT_ITEM Returns total_charge_amt="+total_charge_amt+" patient_payable_amt="+patient_payable_amt+" bl_included_IE="+bl_included_IE+" approval_reqd_yn="+approval_reqd_yn+" error_code="+error_code+" sys_message_id="+sys_message_id+" error_text="+error_text+" override_allowed_yn="+override_allowed_yn);
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

		//drugDetails.put("BL_INCL_EXCL_VALUE",bl_included_IE);
		drugDetails.put("BL_APPRVL_REQD_YN",approval_reqd_yn);
		//drugDetails.put("BL_OVERRIDE_ALLOWED_YN",override_allowed_yn);
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
									}*/
									headerList		= (ArrayList) orderDetails.get(ordDtls);

									for(int hl=0;hl<headerList.size();hl++){
										drugDetails	= new HashMap();
										drugDetails	= (HashMap)headerList.get(hl);									

										String occ_num = (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");
										if(tmp_drug_code.equals((String)drugDetails.get("DRUG_CODE")+occ_num)){
											if(mode.equals("CREATE")){
												start_date_time = (String)drugDetails.get("START_DATE");
											}
											else if(mode.equals("UPDATE")){
												start_date_time = (String)drugDetails.get("START_DATE");
											}
											if(start_date_time == null || start_date_time.equals(""))
												start_date_time = start_date; 
											start_date      = start_date_time.substring(0,10);
											start_time      = start_date_time.substring(11,start_date_time.length());
											durn_value		= Integer.parseInt((String)drugDetails.get("DURN_VALUE"));
											durn_value		= Integer.parseInt((String)drugDetails.get("amend_durn_value")); 	
											interval_value	= (String)drugDetails.get("INTERVAL_VALUE");
											break;
										}
									}
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
						}else if(duration_type.equals("M")){

							for(int dv=0;dv<durn_value;dv++){
								for(int dl=0;dl<day_list.size();dl++){
									if((dv != 0) && (Integer.parseInt(interval_value) > 1)){
										dv = dv+(Integer.parseInt(interval_value) -1);
									}
									schd_date_time = populateEndDate(start_date_time,(Integer.parseInt(day_list.get(dl)+"")+(dv*30)+""),"D");
									schd_date_time = schd_date_time.substring(0,10)+" "+(String)time_list.get(dl);
									schdDateTime.add(schd_date_time);

								}
							}
						}
					}
					if(!duration_type.equals("D")){
						drgCode = drgCode.substring(0,drgCode.length()-1);
						schDateTimeWkHr.put(drgCode,schdDateTime);
					}

				}
			}else{
				String tmp_durn_value  = "1";
				for(int ordDtls = 0;ordDtls<orderDetails.size();ordDtls++){
					/*if(mode.equals("CREATE")){//commented for ML-MMOH-CRF-0345
						headerList		= (ArrayList) orderDetails.get(ordDtls);
					}else if(mode.equals("UPDATE")){
						headerList		= 	orderDetails;
					} */
					headerList		= (ArrayList) orderDetails.get(ordDtls);

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
						schd_date_time = populateEndDate(start_date_time,tmp_durn_value,durn_type);
						schdDateTime.add(schd_date_time);
					}
					drgCode = drgCode.substring(0,drgCode.length()-1);
					schDateTimeWkHr.put(drgCode,schdDateTime);
				}
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

		public Hashtable loadDurnDesc(){

		Hashtable	durn_values  = new Hashtable();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String	durn_code		= "";
		String	durn_desc		= "";
		String  locale= getLanguageId()==null?"en":getLanguageId();

		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13A") ) ;
			pstmt.setString(1, locale);
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				durn_code	=	resultSet.getString("DURN_TYPE");
				durn_desc	=	resultSet.getString("DURN_DESC");
				durn_values.put(durn_code,durn_desc);
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}catch(Exception es){
				es.printStackTrace() ;
			}

		}catch(Exception e){
			durn_values.put("Exception",e.toString());
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){ 
				durn_values.put("Exception",es.toString());
			}
		}
		return durn_values;
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
		
		return working_hours_flag;
	}


	public String getFreqDurnConvValue(String repeat_durn_type, String durn_value, String freq_change_durn_type){
		//int drn_val_rept_drn_type = Integer.parseInt(durn_value);
		float drn_val_rept_drn_type = Float.parseFloat(durn_value);
		int tmp_drn_val_rept_drn_type	= 0;
		if(repeat_durn_type != freq_change_durn_type){
				if(repeat_durn_type.equals("M")){
					if(freq_change_durn_type.equals("H")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * 60;	
					}else if(freq_change_durn_type.equals("D")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * (24 * 60);	
					}else if(freq_change_durn_type.equals("W")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * (7 * 24 * 60);	
					}else if(freq_change_durn_type.equals("L")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * (30 * 7 * 24 * 60);	
					}else if(freq_change_durn_type.equals("Y")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * (365 * 24 * 60);	
					}
			   } else if(repeat_durn_type.equals("H")){
					if(freq_change_durn_type.equals("M")){
//						drn_val_rept_drn_type = Math.ceil((Float.parseFloat(durn_value)/Float.parseFloat(60))+"");	
						drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(60+"")));
					}else if(freq_change_durn_type.equals("D")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * 24;	
					}else if(freq_change_durn_type.equals("W")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * 7 * 24;	
					}else if(freq_change_durn_type.equals("L")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * 30 * 24;	
					}else if(freq_change_durn_type.equals("Y")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * 365 * 24;	
					}
			   }else if(repeat_durn_type.equals("D")){
					if(freq_change_durn_type.equals("M")){
//						drn_val_rept_drn_type = Math.ceil(Integer.parseInt(durn_value)/(24*60));	
						drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat((24*60)+"")));
					}else if(freq_change_durn_type.equals("H")){
//						drn_val_rept_drn_type = Math.ceil(Integer.parseInt(durn_value)/24);	
						drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(24+"")));
					}else if(freq_change_durn_type.equals("W")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * 7 ;	
					}else if(freq_change_durn_type.equals("L")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * 30 ;	
					}else if(freq_change_durn_type.equals("Y")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * 365 ;	
					}
			   }else if(repeat_durn_type.equals("W")){
					if(freq_change_durn_type.equals("M")){
//						drn_val_rept_drn_type = Math.ceil(Integer.parseInt(durn_value)/(7*24*60));
						drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat((7*24*60)+"")));
					}else if(freq_change_durn_type.equals("H")){
//						drn_val_rept_drn_type = Math.ceil(Integer.parseInt(durn_value)/(7*24));	
						drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat((7*24)+"")));
					}else if(freq_change_durn_type.equals("D")){
//						drn_val_rept_drn_type = Math.ceil(Integer.parseInt(durn_value)/7);	
						drn_val_rept_drn_type =	new Float(Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(7+"")));
					}else if(freq_change_durn_type.equals("L")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * 4;	
					}else if(freq_change_durn_type.equals("Y")){
						drn_val_rept_drn_type = Integer.parseInt(durn_value) * 52;	
					}
			   }	
		}
		tmp_drn_val_rept_drn_type = new Float(drn_val_rept_drn_type).intValue();
		return tmp_drn_val_rept_drn_type+"";
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


	public String getDrugRemarks(String remark_code){
		String remarks ="";
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String locale= getLanguageId()==null?"en":getLanguageId();

		try{
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRES_REMARKS")) ;
			pstmt.setString(1,remark_code);
			pstmt.setString(2,locale);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				remarks = (String)resultSet.getString("REMARK_DESC");
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
		return remarks.trim();
	}
	public String getMARDefaulting(String patient_class,String source_code,String form_code, String priority){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        String sql_query="", MARDefaulting ="";
		ResultSet resultSet = null;
		System.out.println(patient_class+"::"+source_code+"::"+form_code+"::"+priority);
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
				System.out.println("Build MAR Rule :"+MARDefaulting);
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
	public String getActionText(String form_code, String route_code){ //Add this method for SKR-CRF-0006[IN029561]	
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		String action_text			        = "";
		String locale= getLanguageId()==null?"en":getLanguageId();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "SELECT ACTION_TEXT_LABEL FROM PH_ROUTE_FOR_FORM_LANG_VW WHERE FORM_CODE=? AND ROUTE_CODE=? and  LANGUAGE_ID=? ") ;
			
			pstmt.setString(1,form_code);
			pstmt.setString(2,route_code);
			pstmt.setString(3,locale);		

			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				action_text = checkForNull(resultSet.getString("ACTION_TEXT_LABEL"));
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
		return action_text;
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
	}//Added for Bru-HIMS-CRF-393_1.0-End
	public boolean isSiteSpecific(String moduleId, String functionalityId){ //Added for ML-MMOH-CRF-0345 [IN:057441] - Start
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
	} //Added for ML-MMOH-CRF-0345 [IN:057441] - End
		public String getSysdatePlusDays(String start_date,String days){  // Added for ML-MMOH-SCF-0690 - Start
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sys_date_plus_days="";
		try{
			connection				= getConnection() ;
			String str_qry			= "SELECT TO_CHAR(to_date(?,'dd/mm/yyyy hh24:mi')+?,'DD/MM/YYYY hh24:mi') SYS_DATE_PLUS_DAYS FROM DUAL";
			pstmt					= connection.prepareStatement(str_qry) ;

			pstmt.setString(1, start_date);			
			pstmt.setString(2, days);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date_plus_days	= resultSet.getString("SYS_DATE_PLUS_DAYS");	
			}
		
		}catch ( Exception e ) {
			sys_date_plus_days+=e.toString();
			System.err.println( "Error sys_date_plus_days  :"+e ) ;
			e.printStackTrace() ;
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){}
		}
		return sys_date_plus_days;
	}

	public String getTooltipStringFrFreq(String drug_code,String srl_no,String no_of_cycle,String dose,String dose_uom){//dose_uom added for ML-MMOH-CRF-1004
	
		//HashMap freq_char_list	    = new HashMap();
		String day_list		        = "";
		ArrayList time_list	        = new ArrayList();
		ArrayList cycle_time_list   = new ArrayList();
		//String	   dosage			= "";
		String tootTipTable			= "";
		String class_value			= "  class=TIP";
		String cycle_start_date     = "";
		String cycle_end_date		= "";

		HashMap hm_details			= null;
		HashMap hm					= getCycleDetails();
		String time = "";
		String cycle_checked_yn		= "";//ML-MMOH-CRF-1004
//System.err.println("OncologyRegimenBean.java========hm=======11347====>"+hm);

		if(hm!=null && hm.size()>0){
			hm_details = (HashMap)hm.get(drug_code+srl_no);
		}
	//	if(tt_r_ps.equals("toolTip")){
				tootTipTable = tootTipTable+"<table border=1 cellpadding=0 cellspacing=0 align=center>";
				tootTipTable = tootTipTable+"<tr>";
				tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"Start Date"+"&nbsp;</td>";
				tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"Time"+"&nbsp;</td>";
				tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"Dosage"+"&nbsp;</td>";
			
				tootTipTable = tootTipTable+"</tr>";
		
				for(int i=0;i<Integer.parseInt(no_of_cycle);i++){
						cycle_checked_yn = "";//ML-MMOH-CRF-1004
					if(hm_details!=null){
						time_list	= (ArrayList)hm_details.get("cycle_"+i);
						cycle_time_list		= (ArrayList)time_list.get(0);
						day_list			= (String)time_list.get(1);
						cycle_start_date  =  (String)time_list.get(3);
						cycle_end_date =   (String)time_list.get(4);
						cycle_checked_yn = (String)time_list.get(5);//ML-MMOH-CRF-1004
						time = Arrays.toString(cycle_time_list.toArray())	;

					}
					if(cycle_checked_yn==null)//ML-MMOH-CRF-1004
						cycle_checked_yn = "";
					if(cycle_checked_yn.equals("Y")){//ML-MMOH-CRF-1004
					tootTipTable	= tootTipTable+"<tr>";
					tootTipTable	= tootTipTable+"<td "+class_value+">&nbsp;"+cycle_start_date+"&nbsp;</td>";
					tootTipTable	= tootTipTable+"<td "+class_value+">&nbsp;"+time+"&nbsp;</td>";
						tootTipTable	= tootTipTable+"<td "+class_value+">&nbsp;"+dose +" "+dose_uom+"&nbsp;</td>";
					tootTipTable	= tootTipTable+"</tr>";
					}
					
			}
			tootTipTable = tootTipTable+"</table>";
		//}
//System.err.println("OncologyRegimenBean.java===11380==tootTipTable=====>"+tootTipTable);
		return tootTipTable;
	}
	public HashMap loadCycleFreqDetails(String freq_code,String facility_id,String repeat_durn_type,String repeat_value,String start_date,String drug_code,String srl_no)
	{
	    Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sys_date_plus_days	= "";
		String order_by				= ""; 
		ArrayList adminDayList		= new ArrayList();
		ArrayList adminTimeList		= new ArrayList();
		ArrayList adminCycle		= new ArrayList();
		ArrayList cycleList			= new ArrayList();
		String	end_date			= "";
		String	admin_day           = "";
		String	admin_time          = "";
		String	admin_cycle         = "";
		//String start_date_time		= start_date;
		
		int	recCount				= 0;
		int	rowCount				= 0;
		int prev_admin_cycle		= 0;
		int curr_admin_cycle		= 0;
		HashMap  hm					= new HashMap();
		try{
			connection				= getConnection() ;
			String str_qry ="select ADMIN_DAY_OR_TIME,ADMIN_DAY,to_char(ADMIN_TIME,'HH24:MI')ADMIN_TIME,ADMIN_WEEK,ADMIN_MONTH from AM_FREQUENCY_ADMIN_DAY_TIME where freq_code=?  and admin_facility_id in (?,'*A') ";
		if(repeat_durn_type.equals("D")){
		  order_by = " order by ADMIN_DAY,ADMIN_TIME";
		}
		if(repeat_durn_type.equals("W")){
		  order_by = " order by ADMIN_WEEK,ADMIN_TIME";
		}
		if(repeat_durn_type.equals("L")){
		  order_by = " order by ADMIN_MONTH,ADMIN_TIME";
		}
		pstmt	= connection.prepareStatement(str_qry+order_by) ;
		pstmt.setString(1, freq_code);			
		pstmt.setString(2, facility_id);
		resultSet				= pstmt.executeQuery();
		while(resultSet!=null && resultSet.next()){
			admin_time	= resultSet.getString("ADMIN_TIME");
			admin_day	= resultSet.getString("ADMIN_DAY");
			rowCount++;
			
			if(repeat_durn_type.equals("W") || repeat_durn_type.equals("L")){
				if(repeat_durn_type.equals("W"))
				  admin_cycle = resultSet.getString("ADMIN_WEEK");
				else
				  admin_cycle = resultSet.getString("ADMIN_MONTH");
			}
			adminTimeList.add(admin_time);
			if(rowCount%Integer.parseInt(repeat_value)==0){
				cycleList.add(adminTimeList);
				cycleList.add(admin_day);
				if(repeat_durn_type.equals("W") || repeat_durn_type.equals("L"))
					cycleList.add(admin_cycle);
				else
					cycleList.add("");
				if(repeat_durn_type.equals("W")){
				curr_admin_cycle = Integer.parseInt(admin_cycle);
					/*if(recCount==0){
						start_date = getSysdatePlusDays(start_date,(Integer.parseInt(admin_day)-1)+"");
					}*/
					if(recCount!=0){
						start_date = getSysdatePlusDays(start_date,((((curr_admin_cycle-prev_admin_cycle)*7))+Integer.parseInt(admin_day))+"");
					}
				}
				else{
					if(repeat_durn_type.equals("L")){
					curr_admin_cycle = Integer.parseInt(admin_cycle);
					/*	if(recCount==0){
							start_date = getSysdatePlusDays(start_date,(Integer.parseInt(admin_day)-1)+"");
						} */
						if(recCount!=0){
							start_date = getSysdatePlusDays(start_date,((((curr_admin_cycle-prev_admin_cycle)*30))+Integer.parseInt(admin_day))+"");
						}
				     }else{
						curr_admin_cycle = Integer.parseInt(admin_day);
					/*	if(recCount==0){
							start_date = getSysdatePlusDays(start_date,(Integer.parseInt(admin_day)-1)+"");
						}*/
						if(recCount!=0){
							start_date = getSysdatePlusDays(start_date,(curr_admin_cycle-prev_admin_cycle)+"");
						}
					 }
				  }
  				prev_admin_cycle = curr_admin_cycle;
				end_date = getSysdatePlusDays(start_date,"1");
				cycleList.add(start_date);
				cycleList.add(end_date);
				cycleList.add("Y");//ML-MMOH-CRF-1004
				hm.put("cycle_"+recCount,cycleList);
				recCount++;
				 adminDayList = new ArrayList();
				 adminTimeList= new ArrayList();
				 cycleList    = new ArrayList();
				 adminCycle   = new ArrayList();

			}
		}
		setOrderEndDate(end_date);
		}catch ( Exception e ) {
			sys_date_plus_days+=e.toString();
			System.err.println( "Error sys_date_plus_days  :"+e ) ;
			e.printStackTrace() ;
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){}
		}
		//System.err.println("OncologyRegimenBean.java======11495==================>"+hm);
		setCycleDetails(drug_code+srl_no,hm);
		return hm;
	}

public HashMap loadAmendCycleFreqDetails(String freq_code,String facility_id,String repeat_durn_type,String repeat_value,String start_date,String drug_code,String srl_no,String order_id)
	{
	    Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		PreparedStatement pstmt1     = null ;
		ResultSet resultSet1         = null ;
		//String sys_date_plus_days	= "";
		String order_by				= ""; 
		ArrayList adminDayList		= new ArrayList();
		ArrayList adminTimeList		= new ArrayList();
		ArrayList adminCycle		= new ArrayList();
		ArrayList cycleList			= new ArrayList();
		String	end_date_time			= "";
		String	admin_day           = "";
		String	admin_time          = "";
		String	admin_cycle         = "";
		String start_date_time		= "";
		
		int	recCount				= 0;
		int	rowCount				= 0;
		//int prev_admin_cycle		= 0;
		//int curr_admin_cycle		= 0;
		HashMap  hm					= new HashMap();
		try{
			connection				= getConnection() ;
		String qry     = "SELECT TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI')START_DATE_TIME, TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE_TIME FROM OR_ORDER_LINE WHERE ORDER_ID = ? AND ORDER_LINE_NUM='1' AND ROWNUM <=1 ";
		
		String str_qry ="SELECT ORDER_LINE_FIELD_VALUE,ORDER_LINE_FREQ_DAY,ADMIN_WEEK,ADMIN_MONTH FROM or_order_line_field_values WHERE order_id=? AND order_line_num ='1' AND ORDER_LINE_SEQ_NUM>=200 AND ORDER_LINE_FIELD_MNEMONIC='SCHED_ADMIN_TIME'";

		
		if(repeat_durn_type.equals("D")){
		  order_by = " order by ORDER_LINE_FREQ_DAY,ORDER_LINE_FIELD_VALUE";
		}
		if(repeat_durn_type.equals("W")){
		  order_by = " order by ADMIN_WEEK,ORDER_LINE_FIELD_VALUE";
		}
		if(repeat_durn_type.equals("L")){
		  order_by = " order by ADMIN_MONTH,ORDER_LINE_FIELD_VALUE";
		}
		pstmt1	= connection.prepareStatement(qry) ;
		pstmt1.setString(1, order_id);
		resultSet1				= pstmt1.executeQuery();
		//System.err.println("qry===11612==========>"+qry);
		if(resultSet1!=null && resultSet1.next()){
		 start_date_time = resultSet1.getString("START_DATE_TIME");
		 end_date_time   = resultSet1.getString("END_DATE_TIME");
		}
		//System.err.println("start_date_time===11617==========>"+start_date_time+"==end_date_time=>"+end_date_time+"==order_id==>"+order_id);
		pstmt	= connection.prepareStatement(str_qry+order_by) ;
		//System.err.println("str_qry+order_by=============>"+str_qry+order_by);
		pstmt.setString(1, order_id);			
		
		resultSet				= pstmt.executeQuery();
		while(resultSet!=null && resultSet.next()){
			admin_time	= resultSet.getString("ORDER_LINE_FIELD_VALUE");
			admin_day	= resultSet.getString("ORDER_LINE_FREQ_DAY");
			rowCount++;
			
			if(repeat_durn_type.equals("W") || repeat_durn_type.equals("L")){
				if(repeat_durn_type.equals("W"))
				  admin_cycle = resultSet.getString("ADMIN_WEEK");
				else
				  admin_cycle = resultSet.getString("ADMIN_MONTH");
			}

			adminTimeList.add(admin_time);
//System.err.println("rowCount===>"+rowCount+"==rowCount==>"+rowCount+"==repeat_value==>"+repeat_value+"==repeat_durn_type==>"+repeat_durn_type);
			if(rowCount%Integer.parseInt(repeat_value)==0){
				
				cycleList.add(adminTimeList);
				cycleList.add(admin_day);

				if(repeat_durn_type.equals("W") || repeat_durn_type.equals("L"))
					cycleList.add(admin_cycle);
				else
					cycleList.add("");

				
				cycleList.add(start_date_time);
				cycleList.add(end_date_time);
				cycleList.add("Y");//ML-MMOH-CRF-1004
				hm.put("cycle_"+recCount,cycleList);
				recCount++;
				 adminDayList = new ArrayList();
				 adminTimeList= new ArrayList();
				 cycleList    = new ArrayList();
				 adminCycle   = new ArrayList();

			}
		}
		setAmendOrderStartAndEndDate(start_date_time+'~'+end_date_time);
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}finally {
			try{
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){}
		}
		//System.err.println("OncologyRegimenBean.java======11495==================>"+hm);
		setCycleDetails(drug_code+srl_no,hm);
		
		return hm;
	}
	public int getMaxCycle(String freq_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String  sql_query			= "";		
		int	no_of_cycle				= 0;
		try{
			connection			= getConnection() ;
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT7");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,freq_code);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				no_of_cycle	=	resultSet.getInt("MAX_NO_OF_CYCLE");
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
				es.printStackTrace() ;
			}
		}
		return no_of_cycle;
	}
//ML-MMOH-CRF-1014 -start
	public ArrayList getFrequency(){
		Connection connection	= null;
        PreparedStatement psmt	= null;
        ResultSet resultSet		= null;
		ArrayList frequency		= new ArrayList();
		try {
			connection	= getConnection();
			psmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DEFFREQFORIV_SELECT")); 
			psmt.setString(1, getLanguageId());
			psmt.setString(2, login_facility_id);
			resultSet	= psmt.executeQuery();
			if(resultSet.next()) {
				frequency.add(resultSet.getString("FREQ_CODE"));
				frequency.add(resultSet.getString("FREQ_DESC"));
			}
			else{ 
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


	public ArrayList getMFRRecsView(String order_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList MFRRecord = new ArrayList();
		HashMap MFRRecDetail = null;
		try{
			connection = getConnection() ;

		//	pstmt				= connection.prepareStatement(SQL_PH_MFR_SELECT) ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ONCO_MFR_VIEW_SELECT")) ;

			pstmt.setString(1,order_id);
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
				MFRRecord.add(MFRRecDetail);
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
		return MFRRecord;
	}
	public String getMfrRemarks(String orig_order_id) { 
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String mfr_remarks = "";
		
		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( "SELECT MFR_REMARKS FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?" ) ;
			pstmt.setString(1,orig_order_id);
			pstmt.setString(2,"1");
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
					mfr_remarks = checkForNull(resultSet.getString("MFR_REMARKS"));
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
				es.printStackTrace();
			}
		}

		return mfr_remarks;	
	}

	public ArrayList getExistingOncoIVRecords(String order_id){

		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		PreparedStatement pstmt1	= null ;
		CallableStatement cstmt		= null ;
		ResultSet resultSet			= null ;
		ResultSet resultSet1		= null ;
		//String sql_str				= ""; commented for unused Variable
		String mfr_yn				="";
		String mfr_remarks			=""; 
		
		ArrayList existingOncoIVRecrds	= new ArrayList();


		try{
			connection = getConnection();
			pstmt				= connection.prepareStatement("SELECT MFR_YN,MFR_REMARKS FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM ='1'") ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery();

			if ( resultSet != null && resultSet.next() ) {
				mfr_yn				= resultSet.getString("MFR_YN")==null?"N":resultSet.getString("MFR_YN");
				mfr_remarks			= resultSet.getString("MFR_REMARKS");
				//if(mfr_remarks!=null && !mfr_remarks.equals(""))
				//	mfr_remarks=java.net.URLEncoder.encode(mfr_remarks,"UTF-8");
	
				
				if(mfr_yn.equals("Y")){
					
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
						}else{
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
						}else
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
						}else{
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
						System.err.println("OncologyRegimenBean.java=====17447===mfrRecs=======>"+mfrRecs);					
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
						setmfr_remark(getdrugCode(),mfr_remarks);
					try{
						closeResultSet( resultSet1 ) ;
						closeStatement( pstmt1 ) ;
					}catch(Exception es){
						es.printStackTrace() ;
					}
				
				}

				
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
		return existingOncoIVRecrds;
	}
	//ML-MMOH-CRF-1014 -end
		/*IN066779 Starts*/
	public void setAmendReason1(String key, ArrayList values) {
		if(amend_reason1==null )
			this.amend_reason1 = new HashMap();
		this.order_Id=key;
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
	/*IN066779 Ends*/
//GHL-CRF-0549 - START
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
	
	//NMC-JD-CRF-0046---start
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
	}
	//NMS-JD-CRF-0046---end
	
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
		
		return remarks;
	}

	public void setOverRideRemarks(String trn_type){
		
		String temp_code="";
		String temp_remarks="";	
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		//String ext_disp_appl_yn=""; COMMON-ICN-0310
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
}