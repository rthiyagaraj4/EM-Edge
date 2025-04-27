/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  //This file is saved on 25/10/2005.
  /*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
18/1/2021     12729 			  				Manickavasagam J 	AAKH-SCF-0487

---------------------------------------------------------------------------------------------------------------
*/

package ePH;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class ADRReportBean extends PhAdapter implements Serializable 
{
	String patient_id="";
	String order_id="";
	String order_line="";
	String adr_no = "";
	String weight="";
	String Diagnosis="";
	String drug_code="";
	String generic_code="";
	String trade_code="";
	String adrType="";
	String administeredBy="";
	String dosage = "";
	String batchID="";
	String expiryDate="";
	String manufacturerName="";
	String supplierName="";
	String OnsetDate="";
	String timeOnset="";
	String OnsetTime="";
	String ethnic_grp="";
	
	String ExtentReaction="";
	String DrugRelation="";
	String reactionStopped="";
	String reactionReappeared="";
	String AdditionalMedication="";
	String outcome="";

	String adr_treatment="";
	String adr_descp="";
	String Investigations="";
	String History="";
	String ReportedBy="";
	String VerifiedBy="";
	String DateTime="";
	String SignedBy="";
	String SignedDateTime="";

	String noOfDrugs="";
	ArrayList drugList = null;
	ArrayList drugDetails = null;
	ArrayList otherMedications = new ArrayList();
	ArrayList questionnaire	=new ArrayList();
	ArrayList oldquestionnaire=new ArrayList();
	int total_response_score;
	int total_num_responses;
	int response;
	String sys_idn_drug_rlsp="";
	String Allergy_type="";

	String drug_name1="";
	String patient_name="";
	String appl_user_id="";
	String appl_user_name="";
	String status_act="";
	String sourceOfInfo="";
	String certanity="";
	String hypersensitivity="";
	String addedFacility_id="";//Code added for added for 33963
	String adrStatus="";//code added for HSA-CRF-0005[40601] --Start
	String canErrorID="";
	String canErrorDate="";
	String canRemarks="";
	String canErrorIDTemp="";
	String canReason="";
	HashMap hmAdrStatusDtl = null;
	HashMap hmAdrReasons = null;//code added for HSA-CRF-0005[40601] --End

	 public ADRReportBean(){
        try {
            doCommon();
        }
        catch(Exception e){
		   e.printStackTrace();
		}
    }
	
	private void doCommon() throws Exception {
	}
	public HashMap getAdrStatusDtl(String key){//code added for HSA-CRF-0005[40601] --Start
		if(this.hmAdrStatusDtl!=null && this.hmAdrStatusDtl.containsKey(key))
			return (HashMap)this.hmAdrStatusDtl.get(key);
		else
			return null;
	}
	public String getAdrReasons(String key){
		if(this.hmAdrReasons!=null && this.hmAdrReasons.containsKey(key))
			return (String)this.hmAdrReasons.get(key);
		else
			return null;
	}//code added for HSA-CRF-0005[40601] --End
	//Start of Set Methods
	public void setStatusAct(String status_act){
		this.status_act=status_act;
	}
	public void setSourceOfInfo(String sourceOfInfo){
		this.sourceOfInfo=sourceOfInfo;
	}
	public void setCertanity(String certanity){
		this.certanity=certanity;
	}
	public void setHypersensitivity(String hypersensitivity){
		this.hypersensitivity=hypersensitivity;
	}

	public void setApplUserID(String appl_user_id){
		this.appl_user_id=appl_user_id;
	}
	public void setApplUserName(String appl_user_name){
		this.appl_user_name=appl_user_name;
	}

	public void setDrug_name1(String drug_name1){
		this.drug_name1=drug_name1;
	}

	public void setPatient_name(String patient_name){
		this.patient_name=patient_name;
	}


	public void setPatient_id(String patient_id){
		this.patient_id=patient_id;
	}
	
	public void setOrder_id(String order_id){
		this.order_id=order_id;
	}
	public void setOrder_line(String order_line){
		this.order_line=order_line;
	}
	public void setAdr_no(String adr_no)
	{
		this.adr_no=adr_no;
	}
	public void setWeight(String weight){
		this.weight=weight;
	}
	public void setDiagnosis(String Diagnosis){
		this.Diagnosis=Diagnosis;
	}
	public void setDrug_Code(String drug_code){
		this.drug_code=drug_code;
	}
	public void setGeneric_code(String generic_code){
		this.generic_code=generic_code;
	}
	public void setTrade_code(String trade_code){
		this.trade_code=trade_code;
	}
	
	public void setADRType(String adrType){
		this.adrType=adrType;
	}


	public void setAdministeredBy(String administeredBy){
		this.administeredBy=administeredBy;
	}
	
	public void setDosage(String dosage){
		this.dosage=dosage;
	}

	public void setBatchID(String batchID){
		this.batchID=batchID;
	}

	public void setExpiryDate(String expiryDate){
		this.expiryDate=expiryDate;
	}

	public void setManufacturerName(String manufacturerName){
		this.manufacturerName=manufacturerName;
	}

	public void setSupplierName(String supplierName){
		this.supplierName=supplierName;
	}

	public void setOnsetDate(String OnsetDate ){
		this.OnsetDate=OnsetDate;
	}
	public void setTimeOnset(String timeOnset ){
		this.timeOnset=timeOnset;
	}
	public void setOnsetTime(String OnsetTime ){
		this.OnsetTime=OnsetTime;
	}
	public void setExtentReaction(String ExtentReaction){
		this.ExtentReaction=ExtentReaction;
	}
	public void setDrugRelation(String DrugRelation){
		this.DrugRelation=DrugRelation;
	}
	public void setReactionStopped(String reactionStopped){
		this.reactionStopped=reactionStopped;
	}
	public void setReactionReappeared(String reactionReappeared){
		this.reactionReappeared=reactionReappeared;
	}

	public void setAdditionalMedication(String AdditionalMedication){
		this.AdditionalMedication=AdditionalMedication;
	}
	public void setOutcome(String outcome){
		this.outcome=outcome;
	}

	public void setadr_treatment(String adr_treatment ){
		this.adr_treatment=adr_treatment;
	}
	public void setadr_descp (String adr_descp  ){
		this.adr_descp =adr_descp;
	}
	public void setethnic_grp(String ethnic_grp){
		this.ethnic_grp=ethnic_grp;
	}

	public void setInvestigations(String Investigations ){
		this.Investigations=Investigations;
	}
	public void setHistory(String History ){
		this.History=History;
	}

	public void setReportedBy(String ReportedBy ){
		this.ReportedBy=ReportedBy;
	}
	public void setVerifiedBy(String VerifiedBy ){
		this.VerifiedBy=VerifiedBy;
	}
	public void setDateTime(String DateTime ){
		this.DateTime=DateTime;
	}
	
	public void setOtherMedications(ArrayList otherMedications ){
		this.otherMedications=otherMedications;
	}

	public void setSignedBy(String SignedBy ){
		this.SignedBy=SignedBy;
	}

	public void setSignedDateTime(String SignedDateTime ){
		this.SignedDateTime=SignedDateTime;
	} 
		
	public void setQuestionnaire(ArrayList questionnaire ){
		this.questionnaire=questionnaire;
	}

	public void setSys_idn_drug_rlsp(String sys_idn_drug_rlsp ){
		this.sys_idn_drug_rlsp=sys_idn_drug_rlsp;
	}

	public void setAllergy_type(String Allergy_type ){
		this.Allergy_type=Allergy_type;
	}
	public void setOldquestionnaire(ArrayList oldquestionnaire ){
		this.oldquestionnaire=oldquestionnaire;
	}
	/* Code added for added for 33963 -- Start */
	public void setaddedFacility_id(String addedFacility_id){
		this.addedFacility_id=addedFacility_id;
	}
	public String getaddedFacility_id(){ //Code added for added for 33963
		return this.addedFacility_id;
	}
	/* Code added for added for 33963 -- End */
	//code added for HSA-CRF-0005[40601] --Start
	public void setadrStatus(String adrStatus){
		this.adrStatus=adrStatus;
	}
	public String getadrStatus() {
		return this.adrStatus;
	}
	
	public void setcanErrorID(String canErrorID){
		this.canErrorID=canErrorID;
	}
	public String getcanErrorID() {
		return this.canErrorID;
	}
	public void setcanReason(String canReason){
		this.canReason=canReason;
	}
	public String getcanReason() {
		return this.canReason;
	}
	public void setcanErrorIDTemp(String canErrorIDTemp){
		this.canErrorIDTemp=canErrorIDTemp;
	}
	public String getcanErrorIDTemp() {
		return this.canErrorIDTemp;
	}	
	public void setcanErrorDate(String canErrorDate){
		this.canErrorDate=canErrorDate;
	}
	public String getcanErrorDate() {
		return this.canErrorDate;
	}
	
	public void setcanRemarks(String canRemarks){
		this.canRemarks=canRemarks;
	}
	public String getcanRemarks() {
		return this.canRemarks;
	}
	//code added for HSA-CRF-0005[40601] --Start
	//Start of Get Methods

	public String getStatusAct(){
		return this.status_act;
	}
	public String getSourceOfInfo(){
		return this.sourceOfInfo;
	}
	public String getCertanity(){
		return this.certanity;
	}
	public String getHypersensitivity(){
		return this.hypersensitivity;
	}
	public String getApplUserID(){
		return this.appl_user_id;
	}
	public String getApplUserName(){
		return this.appl_user_name;
	}
	public String getDrug_name1(){
		return this.drug_name1;
	}
	
	public String getPatient_name(){
		return this.patient_name;
	}
	
	public String getPatient_id(){
		return this.patient_id;
	}
	
	public String getOrder_id(){
		return this.order_id;
	}
	public String getOrder_line(){
		return this.order_line;
	}
	public String getAdr_no(){
		return this.adr_no;
	}
	public String getWeight(){
		return this.weight;
	}
	public String getDiagnosis(){
		return this.Diagnosis;
	}
	public String getDrug_Code(){
		return this.drug_code;
	}
	public String getGeneric_code(){
		return this.generic_code;
	}
	public String getTrade_code(){
		return this.trade_code;
	}

	public String getADRType(){
		return this.adrType;
	}
	public String getAdministeredBy(){
		return this.administeredBy;
	}

	public String getDosage(){
		return this.dosage;
	}

	public String getBatchID(){
		return this.batchID;
	}

	public String getExpiryDate(){
		return this.expiryDate;
	}
	public String getManufacturerName()	{
		return this.manufacturerName;
	}

	public String getSupplierName()	{
		return this.supplierName;
	}

	public String getOnsetDate(){
		return this.OnsetDate;
	}
	public String  getTimeOnset(){
		return this.timeOnset;
	}
	public String getOnsetTime(){
		return this.OnsetTime;
	}
	public String  getExtentReaction(){
		return this.ExtentReaction;
	}
	public String getDrugRelation(){
		return this.DrugRelation;
	}
	public String getReactionStopped(){
		return this.reactionStopped;
	}
	public String getReactionReappeared(){
		return this.reactionReappeared;
	}

	public String getAdditionalMedication()	{
		return this.AdditionalMedication;
	}
	public String getOutcome(){
		return this.outcome;
	}

	public String getadr_treatment(){
		return this.adr_treatment;
	}
	public String getadr_descp(){
		return this.adr_descp;
	}
	public String getethnic_grp(){
		return this.ethnic_grp;
	}

	public String getInvestigations(){
		return this.Investigations;
	}
	public String getHistory(){
		return this.History;
	}

	public String getReportedBy(){
		return this.ReportedBy;
	}
	public String getVerifiedBy(){
		return this.VerifiedBy;
	}
	public String getDateTime(){
		return this.DateTime;
	}
	
	public ArrayList getOtherMedications(){
		return this.otherMedications;
	}

	public String getSignedBy(){
		return this.SignedBy;
	}

	public String getSignedDateTime(){
		return this.SignedDateTime;
	}
	public ArrayList getQuestionnaire()	{
		return questionnaire;
	}
	public ArrayList getOldquestionnaire(){
		return oldquestionnaire;
	}
	public String getSys_idn_drug_rlsp(){
		return sys_idn_drug_rlsp;
	}

	public String getAllergy_type(){
		return Allergy_type;
	}
		

	//End of Get Methods

	//Validate Method
	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	//SetAll method
	public void setAll( Hashtable recordSet ) {
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;//code added for HSA-CRF-0005[40601]
			//setMode(CommonRepository.getCommonKeyValue("MODE_INSERT")) ;//code commented for HSA-CRF-0005[40601]
	
if(recordSet.containsKey("status_act"))
			setStatusAct((String)recordSet.get("status_act")) ;
if(recordSet.containsKey("sourceOfInfo"))
			setSourceOfInfo((String)recordSet.get("sourceOfInfo")) ;
if(recordSet.containsKey("certanity"))
			setCertanity((String)recordSet.get("certanity")) ;
if(recordSet.containsKey("hypersensitivity"))
			setHypersensitivity((String)recordSet.get("hypersensitivity")) ;

	if(recordSet.containsKey("appl_user_id"))
			setApplUserID((String)recordSet.get("appl_user_id")) ;
if(recordSet.containsKey("appl_user_name"))
			setApplUserName((String)recordSet.get("appl_user_name")) ;


		if(recordSet.containsKey("patient_name"))
			setPatient_name((String)recordSet.get("patient_name")) ;

		if(recordSet.containsKey("drug_name1"))
			setDrug_name1((String)recordSet.get("drug_name1")) ;

		if(recordSet.containsKey("patient_id"))
			setPatient_id((String)recordSet.get("patient_id")) ;
		if(recordSet.containsKey("order_id"))
			setOrder_id((String)recordSet.get("order_id")) ;
		if(recordSet.containsKey("order_line"))
			setOrder_line((String)recordSet.get("order_line")) ;
		if(recordSet.containsKey("adr_no"))
			setAdr_no((String)recordSet.get("adr_no")) ;
			/* Code added for added for 33963 -- Start */
		if(recordSet.containsKey("addedFacility_id")) 
			setaddedFacility_id((String)recordSet.get("addedFacility_id")) ;
			/* Code added for added for 33963 -- End */
		if(recordSet.containsKey("weight"))
			setWeight((String)recordSet.get("weight")) ;
		if(recordSet.containsKey("Diagnosis"))
			setDiagnosis((String)recordSet.get("Diagnosis")) ;
		if(recordSet.containsKey("drug_code"))
			setDrug_Code((String)recordSet.get("drug_code"));
		if(recordSet.containsKey("generic_code"))
			setGeneric_code((String)recordSet.get("generic_code")) ;
		if(recordSet.containsKey("trade_code"))
			setTrade_code((String)recordSet.get("trade_code")) ;
		if(recordSet.containsKey("adrType"))
			setADRType((String)recordSet.get("adrType")) ;
		if(recordSet.containsKey("administeredBy"))
		 setAdministeredBy((String)recordSet.get("administeredBy"));
		if(recordSet.containsKey("dosage"))
			setDosage((String)recordSet.get("dosage"));
		if(recordSet.containsKey("batchID"))
			setBatchID((String)recordSet.get("batchID"));
		if(recordSet.containsKey("expiryDate"))
			setExpiryDate((String)recordSet.get("expiryDate")) ;
		if(recordSet.containsKey("manufacturerName"))
			setManufacturerName((String)recordSet.get("manufacturerName")) ;
		if(recordSet.containsKey("supplierName"))
			setSupplierName((String)recordSet.get("supplierName")) ;

		if(recordSet.containsKey("OnsetDate"))
		 setOnsetDate((String)recordSet.get("OnsetDate"));
		if(recordSet.containsKey("timeOnset"))
		 setTimeOnset((String)recordSet.get("timeOnset"));
		if(recordSet.containsKey("OnsetTime"))
		 setOnsetTime((String)recordSet.get("OnsetTime"));
		if(recordSet.containsKey("ExtentReaction"))
		 setExtentReaction((String)recordSet.get("ExtentReaction"));

		if(recordSet.containsKey("DrugRelation"))
		 setDrugRelation((String)recordSet.get("DrugRelation"));	
		if(recordSet.containsKey("reactionStopped"))
		 setReactionStopped((String)recordSet.get("reactionStopped"));
		if(recordSet.containsKey("reactionReappeared"))
		 setReactionReappeared((String)recordSet.get("reactionReappeared"));
		if(recordSet.containsKey("AdditionalMedication"))
		 setAdditionalMedication((String)recordSet.get("AdditionalMedication"));
		if(recordSet.containsKey("outcome"))
		 setOutcome((String)recordSet.get("outcome"));
		if(recordSet.containsKey("adr_treatment"))
		 setadr_treatment((String)recordSet.get("adr_treatment"));
		if(recordSet.containsKey("adr_descp"))
		 setadr_descp((String)recordSet.get("adr_descp"));
		if(recordSet.containsKey("ethnic_grp"))
		 setethnic_grp((String)recordSet.get("ethnic_grp"));
		if(recordSet.containsKey("History"))
		 setHistory((String)recordSet.get("History"));
		if(recordSet.containsKey("outcome"))
		 setOutcome((String)recordSet.get("outcome"));
		if(recordSet.containsKey("Investigations"))
		 setInvestigations((String)recordSet.get("Investigations"));
		if(recordSet.containsKey("ReportedBy"))
		 setReportedBy((String)recordSet.get("ReportedBy"));
		if(recordSet.containsKey("VerifiedBy"))
		 setVerifiedBy((String)recordSet.get("VerifiedBy"));
		if(recordSet.containsKey("DateTime"))
		 setDateTime((String)recordSet.get("DateTime"));

		if(recordSet.containsKey("no_of_drugs")){
			noOfDrugs=(String)recordSet.get("no_of_drugs");
		}	
		if(recordSet.containsKey("sysiddrugrlsp"))
			setSys_idn_drug_rlsp((String)recordSet.get("sysiddrugrlsp"));
		if(recordSet.containsKey("allergytypecode"))
			setAllergy_type((String)recordSet.get("allergytypecode"));			
		if(recordSet.containsKey("adrStatus"))//code added for HSA-CRF-0005[40601] --Start
			setadrStatus((String)recordSet.get("adrStatus"));
		if(recordSet.containsKey("canErrorID"))
			setcanErrorID((String)recordSet.get("canErrorID"));
		if(recordSet.containsKey("canErrorDate"))
			setcanErrorDate((String)recordSet.get("canErrorDate"));
		if(recordSet.containsKey("canRemarks"))
			setcanRemarks((String)recordSet.get("canRemarks"));
		if(recordSet.containsKey("canReason"))
			setcanReason((String)recordSet.get("canReason"));
		if(recordSet.containsKey("SignedBy") && ((String)recordSet.get("adrStatus")).equals("E")  )//code added for HSA-CRF-0005[40601]
			setSignedBy((String)recordSet.get("SignedBy"));	//code added for HSA-CRF-0005[40601] --End
		int nod=0;
		if(!patient_id.equals("null") && patient_id.length()!=0 ) 
		nod = Integer.parseInt(noOfDrugs);
		String status = "";
		drugList = new ArrayList();
		for(int i=1;i<=nod;i++){
			if(recordSet.containsKey("ord_"+i)){
				status=(String)recordSet.get("ord_"+i);
			}
			if(status.equals("Y")){
				drugDetails = new ArrayList();
				drugDetails.add((String)recordSet.get("oth_drugCode_"+i));
				drugDetails.add((String)recordSet.get("oth_genericId_"+i));
				drugDetails.add((String)recordSet.get("oth_orderId_"+i));
				drugDetails.add((String)recordSet.get("oth_ordlneNum_"+i));
	
				drugList.add(drugDetails);
			}
		}
		setOtherMedications(drugList);
	}

	//Modify Method
	  public HashMap modify() {

		HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put("flag", "0");
        //code added for HSA-CRF-0005[40601] Starts
        HashMap commonData = new HashMap() ;
        adrCommonData(commonData);
        HashMap<String,Object> tabData = new HashMap<String,Object>() ;
		tabData.put( "COMMONDATA", commonData ) ;
		tabData.put( "properties", getProperties());
		HashMap<String, String> sqlMap = new HashMap<String, String>() ;
		try {
			sqlMap.put( "SQL_PH_ADRDRUG_REACT", PhRepository.getPhKeyValue( "SQL_PH_ADRDRUG_REACT" ) ) ;
			//sqlMap.put( "SQL_PH_ADRDRUG_HDR_UPDATE", PhRepository.getPhKeyValue( "SQL_PH_ADRDRUG_HDR_UPDATE" ) );
			//sqlMap.put( "SQL_PH_ADRDRUG_DTL_UPDATE", PhRepository.getPhKeyValue( "SQL_PH_ADRDRUG_DTL_UPDATE" ) ) ;
			//sqlMap.put( "SQL_PH_ADR_FACILITY_PARAM_UPDATE", PhRepository.getPhKeyValue( "SQL_PH_ADR_FACILITY_PARAM_UPDATE" ) ) ;
		}
		catch(Exception e){
			e.printStackTrace() ;
		}

		tabData.put("SQLMAP",sqlMap);
		map	=	updateTable(tabData);
		if( ((Boolean) map.get( "result" )).booleanValue() ){
			map.put( "message", getMessage(getLanguageId(),(String) map.get( "message" ),"PH") ) ;
		}
		else{
            map.put( "message", (map.get("message"))) ;
		}
		//code added for HSA-CRF-0005[40601] Ends
        return map ;
   }

	public void clear() {
		appl_user_id="";
		appl_user_name="";
		
	}
	//insert method
	public HashMap insert() {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( false ) ) ;
        map.put("flag", "0");
		HashMap commonData = new HashMap() ;

			//Added by Jyothi.G on 01/10/2010 to fix IN024115
			adrCommonData(commonData);	 //code added for HSA-CRF-0005[40601] moved to private method for reusable code  			

			HashMap tabData = new HashMap() ;
			tabData.put( "COMMONDATA", commonData ) ;
			tabData.put( "properties", getProperties());

			HashMap sqlMap = new HashMap() ;
			try {
				sqlMap.put( "SQL_PH_ADRDRUG_REACT", PhRepository.getPhKeyValue( "SQL_PH_ADRDRUG_REACT" ) ) ;
				sqlMap.put( "SQL_PH_ADRDRUG_HDR_INSERT", PhRepository.getPhKeyValue( "SQL_PH_ADRDRUG_HDR_INSERT" ) );
				sqlMap.put( "SQL_PH_ADRDRUG_DTL_INSERT", PhRepository.getPhKeyValue( "SQL_PH_ADRDRUG_DTL_INSERT" ) ) ;
				sqlMap.put( "SQL_PH_ADR_FACILITY_PARAM_UPDATE", PhRepository.getPhKeyValue( "SQL_PH_ADR_FACILITY_PARAM_UPDATE" ) ) ;
				sqlMap.put( "SQL_PH_ADRDRUG_HDR_DELETE", PhRepository.getPhKeyValue( "SQL_PH_ADRDRUG_HDR_DELETE" ) ) ;
				sqlMap.put( "SQL_PH_ADRDRUG_DTL_DELETE", PhRepository.getPhKeyValue( "SQL_PH_ADRDRUG_DTL_DELETE" ) ) ;
			}
			catch(Exception e){
				e.printStackTrace() ;
			}

			tabData.put("SQLMAP",sqlMap);
			map	=	updateTable(tabData);
			
			if( ((Boolean) map.get( "result" )).booleanValue() ){
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "message" ),"PH") ) ;
			}
			else{
                map.put( "message", (map.get("message"))) ;
			}
		return map;
	}

	//code added for HSA-CRF-0005[40601] Starts
	private void adrCommonData(HashMap commonData) {
		if(!getLanguageId().equals("en")){
			OnsetDate = com.ehis.util.DateUtils.convertDate(OnsetDate,"DMYHM",getLanguageId(),"en");
			DateTime = com.ehis.util.DateUtils.convertDate(DateTime,"DMYHM",getLanguageId(),"en");
			expiryDate = com.ehis.util.DateUtils.convertDate(expiryDate,"DMY",getLanguageId(),"en");
			canErrorDate = com.ehis.util.DateUtils.convertDate(canErrorDate,"DMY",getLanguageId(),"en");
		}
		//End
		if(addedFacility_id==null || addedFacility_id.equals(""))
			addedFacility_id = login_facility_id;
		commonData.put("patient_id",patient_id);
		commonData.put("order_id",order_id);
		commonData.put("order_line",order_line);
		commonData.put("adr_no",adr_no);
		commonData.put("addedFacility_id",addedFacility_id);//Code added for added for 33963			
		commonData.put("weight",weight);
		commonData.put("Diagnosis",Diagnosis);
		commonData.put("drug_code",drug_code);
		commonData.put("generic_code",generic_code);
		commonData.put("trade_code",trade_code);
		commonData.put("administeredBy",administeredBy);
		commonData.put("dosage",dosage);
		commonData.put("batchID",batchID);
		commonData.put("expiryDate",expiryDate);
		commonData.put("manufacturerName",manufacturerName);
		commonData.put("supplierName",supplierName);
		commonData.put("adrType",adrType);
		commonData.put("OnsetDate",OnsetDate);
		commonData.put("timeOnset",timeOnset);
		commonData.put("OnsetTime",OnsetTime);
		commonData.put("ExtentReaction",ExtentReaction);
		commonData.put("DrugRelation",DrugRelation);
		commonData.put("reactionStopped",reactionStopped);
		commonData.put("reactionReappeared",reactionReappeared);
		commonData.put("AdditionalMedication",AdditionalMedication);
		commonData.put("outcome",outcome);
		commonData.put("Investigations",Investigations);
		commonData.put("adr_treatment",adr_treatment);
		commonData.put("ethnic_grp",ethnic_grp);
		commonData.put("adr_descp",adr_descp);
		commonData.put("History",History);
		commonData.put("ReportedBy",ReportedBy);
		commonData.put("VerifiedBy",VerifiedBy);
		commonData.put("DateTime",DateTime);
		commonData.put( "login_by_id",			login_by_id ) ;
		commonData.put( "login_at_ws_no",		login_at_ws_no ) ;
		commonData.put( "login_facility_id",	login_facility_id ) ;
		commonData.put( "sys_idn_drug_rlsp",	sys_idn_drug_rlsp ) ;
		commonData.put( "Allergy_type",	Allergy_type ) ;
		commonData.put( "patient_name",	patient_name ) ;
		commonData.put( "drug_name1",	drug_name1 ) ;
		commonData.put( "appl_user_id",	appl_user_id ) ;
		commonData.put( "appl_user_name",	appl_user_name ) ;
		commonData.put( "status_act",	status_act ) ;
		commonData.put( "sourceOfInfo",	sourceOfInfo ) ;
		commonData.put( "certanity",	certanity ) ;
		commonData.put( "hypersensitivity",	hypersensitivity ) ;
		commonData.put("adrStatus",adrStatus);//code added for HSA-CRF-0005[40601] --Start			
		commonData.put("canErrorID",canErrorID);
		commonData.put("canErrorDate",canErrorDate);
		commonData.put("canRemarks",canRemarks);
		commonData.put("canReason",canReason);	 	  			
		commonData.put("SignedBy",SignedBy);	 //code added for HSA-CRF-0005[40601] --End	  			
		commonData.put("mode",mode);//niji
	}
	//code added for HSA-CRF-0005[40601] Ends

	public HashMap updateTable(HashMap tabData){
		HashMap map=new HashMap();
		HashMap commonData	=	new HashMap();
		HashMap sqlMap		=	new HashMap();
		HashMap qstMap		=	new HashMap();
		ArrayList qstList	=	new ArrayList();
		Connection connection	 =	null ;
		PreparedStatement pstmt1 =	null ;
		PreparedStatement pstmt2 =	null ;
		PreparedStatement pstmt3 =	null ;
		PreparedStatement pstmt4 =	null ;
		PreparedStatement pstmt6 =	null ;
		PreparedStatement pstmt7 =	null ;
		PreparedStatement pstmt8 =	null ;
		PreparedStatement pstmt9 =	null ;

		ResultSet resultSet			  =	null ;
		map.put( "result" ,false);
		try {
			commonData=(HashMap)tabData.get("COMMONDATA");
			sqlMap	=(HashMap)tabData.get("SQLMAP");
			String ADRNo="";
			//String sql_ph_adrdrug_hdr_insert =(String)sqlMap.get("SQL_PH_ADRDRUG_HDR_INSERT");  Removed for IN063877
			//String sql_ph_adrdrug_dtl_insert =(String)sqlMap.get("SQL_PH_ADRDRUG_DTL_INSERT");    Removed for IN063877
			String sql_ph_adrdrug_react=(String)sqlMap.get("SQL_PH_ADRDRUG_REACT");
			String sql_ph_adr_facility_param_update =(String)sqlMap.get("SQL_PH_ADR_FACILITY_PARAM_UPDATE");
			//String sql_ph_adrdrug_hdr_delete =(String)sqlMap.get("SQL_PH_ADRDRUG_HDR_DELETE");
			//String sql_ph_adrdrug_hdr_delete ="DELETE FROM PR_ADV_DRUG_REACTION WHERE ADR_NO=? and FACILITY_ID=?";//code commented for HSA-CRF-0005[40601]
			//String sql_ph_adrdrug_dtl_delete =(String)sqlMap.get("SQL_PH_ADRDRUG_DTL_DELETE");
			//String sql_ph_adrdrug_dtl_delete ="DELETE FROM PR_ADV_DRUG_REACTION_DTL WHERE ADR_NO=? and FACILITY_ID=?";//code commented for HSA-CRF-0005[40601]

			String login_facility_id=(String)commonData.get("login_facility_id");
			String drugCode			=(String)commonData.get("drug_code");
			String orderID			=(String)commonData.get("order_id");
			String orderLineNo		=(String)commonData.get("order_line");
			String adrNo			=(String)commonData.get("adr_no");
			String patient_name		=(String)commonData.get("patient_name");
			String drug_name1		=(String)commonData.get("drug_name1");
			String addedFacility_id	=(String)commonData.get("addedFacility_id");//Code added for added for 33963
			String mode	=(String)commonData.get("mode");//code added for HSA-CRF-0005[40601]
			if(orderID.equals("undefined")) 
				orderID="";
			if(adrNo == null) 
				adrNo = "";
			String genericCode		=(String)commonData.get("generic_code");
			int nResult1			=0;
			int nResult2			=1;
			String patient_id		=(String)commonData.get("patient_id");

			if(patient_id.equals("null")) 
				patient_id = "";
			connection	 =	  getConnection() ;
			//code commented for HSA-CRF-0005[40601] Start
			/*if(!(adrNo.equals("")) ){
				try{
					 if( ((String)commonData.get("adrStatus")).equals("E") ) { //Niji//code added for HSA-CRF-0005[40601] -- Start						
						SignedBy = (String)commonData.get("SignedBy") ;						
						setSignedBy(SignedBy);						
					} //code added for HSA-CRF-0005[40601] -- End								
					pstmt6	=	connection.prepareStatement(sql_ph_adrdrug_dtl_delete);
					pstmt6.setString(1,adrNo);
					pstmt6.setString(2,addedFacility_id); //login_facility_id replaced by addedFacility_id Removed for 33963 
					pstmt6.executeUpdate();

					pstmt7	=	connection.prepareStatement(sql_ph_adrdrug_hdr_delete);
					pstmt7.setString(1,adrNo);
					pstmt7.setString(2,addedFacility_id); //login_facility_id replaced by addedFacility_id Removed for 33963 
					pstmt7.executeUpdate();
					ADRNo = adrNo;
					closeStatement(pstmt6);
					closeStatement(pstmt7);
				}
				catch(Exception e){
				connection.rollback();
					e.printStackTrace() ;
					System.err.println("Delete failed :"+tabData);
				}

				try{
					pstmt4			 =	  connection.prepareStatement("update mp_patient set KNOWN_ALLERGY_YN ='Y' where patient_id =?");
					pstmt4.setString(1,patient_id);							
					nResult1 = pstmt4.executeUpdate();								
				}
				catch(Exception e){
					e.printStackTrace() ;
					System.err.println("UPDATE failed :"+tabData);
				}
			}*/
			//else {
			//code commented for HSA-CRF-0005[40601] End
			//code added for HSA-CRF-0005[40601] Start
			if(adrNo.equals("")){
				try{
					pstmt3	 =	connection.prepareStatement(sql_ph_adrdrug_react);
					pstmt3.setString(1,login_facility_id.trim());
					resultSet=pstmt3.executeQuery();
					if(resultSet.next()){
						ADRNo = resultSet.getString("NEXTNO");
					}
				}
				catch(Exception e){
					e.printStackTrace() ;
				}
			}
			else{
				ADRNo = adrNo;			
				SignedBy = (String)commonData.get("SignedBy") ;						
				setSignedBy(SignedBy);						
			}
			//code added for HSA-CRF-0005[40601] Ends
			if("1".equals(mode)){ //code added for HSA-CRF-0005[40601]

				String sql="INSERT INTO PR_ADV_DRUG_REACTION (ADR_NO,PATIENT_ID,DRUG_CODE,GENERIC_ID,TRADE_CODE,ADR_TYPE,ONSET_DATE_TIME,DURN_TO_ONSET_REACTION,DURN_TO_ONSET_REACTION_TYPE,EXTENT_OF_REACTION,DRUG_REACTION_RELATIONSHIP,REACTION_ON_STOP_OF_MEDN,REACTION_ON_REPETITION,ADDITIONAL_MEDN,OUTCOME,ADR_TREATMENT,RELEVANT_INVESTIGATION,RELEVANT_HISTORY,PREPARED_BY,VERIFIED_BY,PREPARED_DATE_TIME,SIGNED_BY,SIGNED_DATE_TIME,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORDER_ID,ORDER_LINE_NUM,WEIGHT,DIAG_TXT,DOSAGE,ADMIN_BY,BATCH_ID,EXPIRY_DATE,MANUFACTURER,SUPPLIER,ADR_DESCRIPTION,ETHNIC_GROUP,QA_DRUG_REACTION_RELATIONSHIP, ALLERGY_YN, ALLERGY_TYPE_CODE,PATIENT_NAME,DRUG_NAME,ADV_EVENT_TYPE_IND, STATUS, REACTION_CERTAINITY,SOURCE_OF_INFO,FACILITY_ID,CANCEL_ERROR_BY_ID,CANCEL_ERROR_DATE,CANCEL_ERROR_REMARKS,ADR_STATUS,CANCEL_ERR_REASON) VALUES (?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,?,decode(?,null,'N','Y'),?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?)" ;	// 'CANCEL_ERROR_BY_ID,CANCEL_ERROR_DATE,CANCEL_ERROR_REMARKS,ADR_STATUS,CANCEL_ERR_REASON' code added for HSA-CRF-0005[40601]  		
				String sql2="INSERT INTO PR_ADV_DRUG_REACTION_DTL (ADR_NO,OTH_DRUG_CODE,OTH_GENERIC_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORDER_ID,ORDER_LINE_NUM,FACILITY_ID) VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?)";
				//pstmt1			=	  connection.prepareStatement(sql_ph_adrdrug_hdr_insert);
				pstmt1				=	  connection.prepareStatement(sql);
				//pstmt2			=	  connection.prepareStatement(sql_ph_adrdrug_dtl_insert);
				pstmt2				=	  connection.prepareStatement(sql2);
				pstmt1.setString(1,ADRNo);
				pstmt1.setString(2,patient_id);
				pstmt1.setString(3,drugCode);
				pstmt1.setString(4,genericCode);
				pstmt1.setString(5,checkForNull((String)commonData.get("trade_code")));
				pstmt1.setString(6,checkForNull((String)commonData.get("adrType")));
				pstmt1.setString(7,checkForNull((String)commonData.get("OnsetDate")));
				pstmt1.setString(8,checkForNull((String)commonData.get("timeOnset")));
				pstmt1.setString(9,checkForNull((String)commonData.get("OnsetTime")));
				pstmt1.setString(10,checkForNull((String)commonData.get("ExtentReaction")));
				pstmt1.setString(11,checkForNull((String)commonData.get("DrugRelation")));
				pstmt1.setString(12,checkForNull((String)commonData.get("reactionStopped")));
				pstmt1.setString(13,checkForNull((String)commonData.get("reactionReappeared")));
				pstmt1.setString(14,checkForNull((String)commonData.get("AdditionalMedication")));
				pstmt1.setString(15,checkForNull((String)commonData.get("outcome")));
				pstmt1.setString(16,checkForNull((String)commonData.get("adr_treatment")));
				pstmt1.setString(17,checkForNull((String)commonData.get("Investigations")));
				pstmt1.setString(18,checkForNull((String)commonData.get("History")));
				pstmt1.setString(19,checkForNull((String)commonData.get("ReportedBy")));
				pstmt1.setString(20,checkForNull((String)commonData.get("VerifiedBy")));
				pstmt1.setString(21,checkForNull((String)commonData.get("DateTime")));
				pstmt1.setString(22,getSignedBy());
				pstmt1.setString(23,getSignedDateTime());
				// 22 signed by
				//23 signed date/time
				pstmt1.setString(24,(String)commonData.get("login_by_id"));
				pstmt1.setString(25,(String)commonData.get("login_at_ws_no"));
				pstmt1.setString(26,login_facility_id);
				pstmt1.setString(27,(String)commonData.get("login_by_id"));
				pstmt1.setString(28,(String)commonData.get("login_at_ws_no"));
				pstmt1.setString(29,login_facility_id);
				pstmt1.setString(30,orderID);
				pstmt1.setString(31,orderLineNo);
				pstmt1.setString(32,checkForNull((String)commonData.get("weight")));
				pstmt1.setString(33,checkForNull((String)commonData.get("Diagnosis")));
				//34 dosage
				pstmt1.setString(34,checkForNull((String)commonData.get("dosage")));
				pstmt1.setString(35,checkForNull((String)commonData.get("administeredBy")));
				pstmt1.setString(36,checkForNull((String)commonData.get("batchID")));
				pstmt1.setString(37,checkForNull((String)commonData.get("expiryDate")));
				pstmt1.setString(38,checkForNull((String)commonData.get("manufacturerName")));
				pstmt1.setString(39,checkForNull((String)commonData.get("supplierName")));
				pstmt1.setString(40,checkForNull((String)commonData.get("adr_descp")));
				pstmt1.setString(41,checkForNull((String)commonData.get("ethnic_grp")));
				pstmt1.setString(42,checkForNull((String)commonData.get("sys_idn_drug_rlsp")));
				pstmt1.setString(43,checkForNull((String)commonData.get("Allergy_type")));
				pstmt1.setString(44,checkForNull((String)commonData.get("Allergy_type")));
				pstmt1.setString(45,patient_name);
				pstmt1.setString(46,drug_name1);
				pstmt1.setString(47,(String)commonData.get("hypersensitivity"));
				if( ((String)commonData.get("adrStatus")).equals("E") || ((String)commonData.get("adrStatus")).equals("C"))// code added for HSA-CRF-0005[40601] -- Start
					 pstmt1.setString(48,(String)commonData.get("adrStatus") ); 
				else //code added for HSA-CRF-0005[40601] -- End 
					pstmt1.setString(48,(String)commonData.get("status_act"));
				pstmt1.setString(49,(String)commonData.get("certanity"));
				pstmt1.setString(50,(String)commonData.get("sourceOfInfo"));
				pstmt1.setString(51,addedFacility_id);//login_facility_id			
				pstmt1.setString(52,(String)commonData.get("canErrorID"));// code added for HSA-CRF-0005[40601] -- Start 
				pstmt1.setString(53,(String)commonData.get("canErrorDate"));
				pstmt1.setString(54,(String)commonData.get("canRemarks") );
				pstmt1.setString(55,(String)commonData.get("adrStatus") );
				pstmt1.setString(56,(String)commonData.get("canReason") );// code added for HSA-CRF-0005[40601] -- End 

				int nResult = pstmt1.executeUpdate();
				if(nResult>0 && adrNo.equals("")){
					try {
						pstmt4			 =	  connection.prepareStatement(sql_ph_adr_facility_param_update);
						pstmt4.setString(1,ADRNo);
						pstmt4.setString(2,login_facility_id.trim());
						nResult1 = pstmt4.executeUpdate();								
					}
					catch(Exception e){
						e.printStackTrace() ;
						System.err.println("INSERT failed :"+tabData+" ADRNo="+ADRNo);
					}
				}
				if(nResult>0){
					try{
						drugList = getOtherMedications();
						if(drugList.size()>0){
							for(int j=0;j<drugList.size();j++){
								drugDetails = (ArrayList)drugList.get(j);
								pstmt2.setString(1,ADRNo);
								pstmt2.setString(2,(String)drugDetails.get(0));
								pstmt2.setString(3,(String)drugDetails.get(1));				
								pstmt2.setString(4,(String)commonData.get("login_by_id"));
								pstmt2.setString(5,(String)commonData.get("login_at_ws_no"));
								pstmt2.setString(6,login_facility_id);
								pstmt2.setString(7,(String)commonData.get("login_by_id"));
								pstmt2.setString(8,(String)commonData.get("login_at_ws_no"));
								pstmt2.setString(9,login_facility_id);
								pstmt2.setString(10,(String)drugDetails.get(2));
								pstmt2.setString(11,(String)drugDetails.get(3));
								pstmt2.setString(12,addedFacility_id); //login_facility_id

								pstmt2.addBatch();
							}
							int[] batch_result1 = pstmt2.executeBatch();

							for (int i=0;i<batch_result1.length;i++ ) {
								if (batch_result1[i]<0  && batch_result1[i] != -2) {
									pstmt2.cancel();
									nResult2=0;
									throw new Exception("Other Medication insertion Failed");
								}
								else{
									nResult2=1;		
								}
							}
						}
					}
					catch(Exception e){
						 e.printStackTrace() ;
					}
				}
				closeStatement(pstmt2);
				closeStatement(pstmt1);

				qstList=getQuestionnaire();
				//code added for HSA-CRF-0005[40601] Starts
				/*if(adr_no!=null&&adr_no!=""){
					//pstmt9=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PR_ADV_DRUG_REACTION_QA_DELETE"));
					
					pstmt9=connection.prepareStatement("DELETE FROM PR_ADV_DRUG_REACTION_QA WHERE ADR_NO=? and FACILITY_ID=?");
					pstmt9.setString(1,adr_no);
					pstmt9.setString(2,addedFacility_id); //login_facility_id replaced by addedFacility_id Removed for 33963
					pstmt9.executeUpdate();
				}*/
				//code added for HSA-CRF-0005[40601] Ends

				//pstmt8=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PR_ADV_DRUG_REACTION_QA_INSERT"));
				pstmt8=connection.prepareStatement("insert into PR_ADV_DRUG_REACTION_QA(ADR_NO,QUESTION_CODE,RESPONSE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,FACILITY_ID) VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");
				String response="", code="";
				try{					
					for(int list=0;list<qstList.size();list++){
						qstMap=(HashMap)qstList.get(list);
						code=(String)qstMap.get("code");
						response=(String)qstMap.get("response");
						if(!(response==null)){
							pstmt8.setString(1,ADRNo);						
							pstmt8.setString(2,code);
							pstmt8.setString(3,response);
							pstmt8.setString(4,(String)commonData.get("login_by_id"));
							pstmt8.setString(5,(String)commonData.get("login_at_ws_no"));
							pstmt8.setString(6,login_facility_id);
							pstmt8.setString(7,(String)commonData.get("login_by_id"));
							pstmt8.setString(8,(String)commonData.get("login_at_ws_no"));
							pstmt8.setString(9,login_facility_id);
							pstmt8.setString(10,addedFacility_id);//login_facility_id
							pstmt8.executeUpdate();
						}
					}
				}
				catch(Exception e){
					e.printStackTrace() ;
				}
				if(nResult2>0){
					map.put( "result", new Boolean( true ) ) ;
					map.put( "flag", ADRNo ) ;
					map.put( "message","RECORD_INSERTED");
					connection.commit();
				}
				else{
					map.put( "result", new Boolean( false ) ) ;
					map.put( "flag", "0" ) ;
					map.put( "message","Transaction failed in inner ");
					connection.rollback();
				}
			}//code added for HSA-CRF-0005[40601]				
			else if ("2".equals(mode)){//code added for HSA-CRF-0005[40601] Starts
				String sqlUpdate="UPDATE  PR_ADV_DRUG_REACTION SET ADR_NO=?,PATIENT_ID=?,DRUG_CODE=?,GENERIC_ID=?,TRADE_CODE=?,ADR_TYPE=?,ONSET_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'),DURN_TO_ONSET_REACTION=?,DURN_TO_ONSET_REACTION_TYPE=?,EXTENT_OF_REACTION=?,DRUG_REACTION_RELATIONSHIP=?,REACTION_ON_STOP_OF_MEDN=?,REACTION_ON_REPETITION=?,ADDITIONAL_MEDN=?,OUTCOME=?,ADR_TREATMENT=?,RELEVANT_INVESTIGATION=?,RELEVANT_HISTORY=?,PREPARED_BY=?,VERIFIED_BY=?,PREPARED_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'),SIGNED_BY=?,SIGNED_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ORDER_ID=?,ORDER_LINE_NUM=?,WEIGHT=?,DIAG_TXT=?,DOSAGE=?,ADMIN_BY=?,BATCH_ID=?,EXPIRY_DATE=TO_DATE(?,'DD/MM/YYYY'),MANUFACTURER=?,SUPPLIER=?,ADR_DESCRIPTION=?,ETHNIC_GROUP=?,QA_DRUG_REACTION_RELATIONSHIP=?, ALLERGY_YN=decode(?,null,'N','Y'), ALLERGY_TYPE_CODE=?,PATIENT_NAME=?,DRUG_NAME=?,ADV_EVENT_TYPE_IND=?, STATUS=?, REACTION_CERTAINITY=?,SOURCE_OF_INFO=?,FACILITY_ID=?,CANCEL_ERROR_BY_ID=?,CANCEL_ERROR_DATE=TO_DATE(?,'DD/MM/YYYY HH24:MI'),CANCEL_ERROR_REMARKS=?,ADR_STATUS=?,CANCEL_ERR_REASON=? WHERE ADR_NO=? AND FACILITY_ID=?" ;  		
				String sql2Update="UPDATE  PR_ADV_DRUG_REACTION_DTL SET ADR_NO=?,OTH_DRUG_CODE=?,OTH_GENERIC_ID=?, MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ORDER_ID=?,ORDER_LINE_NUM=?,FACILITY_ID=? WHERE  ADR_NO=? AND FACILITY_ID=?";
				pstmt1				=	  connection.prepareStatement(sqlUpdate);
				//pstmt2			=	  connection.prepareStatement(sql_ph_adrdrug_dtl_insert);
				pstmt2				=	  connection.prepareStatement(sql2Update);
				pstmt1.setString(1,ADRNo);
				pstmt1.setString(2,patient_id);
				pstmt1.setString(3,drugCode);
				pstmt1.setString(4,genericCode);
				pstmt1.setString(5,checkForNull((String)commonData.get("trade_code")));
				pstmt1.setString(6,checkForNull((String)commonData.get("adrType")));
				pstmt1.setString(7,checkForNull((String)commonData.get("OnsetDate")));
				pstmt1.setString(8,checkForNull((String)commonData.get("timeOnset")));
				pstmt1.setString(9,checkForNull((String)commonData.get("OnsetTime")));
				pstmt1.setString(10,checkForNull((String)commonData.get("ExtentReaction")));
				pstmt1.setString(11,checkForNull((String)commonData.get("DrugRelation")));
				pstmt1.setString(12,checkForNull((String)commonData.get("reactionStopped")));
				pstmt1.setString(13,checkForNull((String)commonData.get("reactionReappeared")));
				pstmt1.setString(14,checkForNull((String)commonData.get("AdditionalMedication")));
				pstmt1.setString(15,checkForNull((String)commonData.get("outcome")));
				pstmt1.setString(16,checkForNull((String)commonData.get("adr_treatment")));
				pstmt1.setString(17,checkForNull((String)commonData.get("Investigations")));
				pstmt1.setString(18,checkForNull((String)commonData.get("History")));
				pstmt1.setString(19,checkForNull((String)commonData.get("ReportedBy")));
				pstmt1.setString(20,checkForNull((String)commonData.get("VerifiedBy")));
				pstmt1.setString(21,checkForNull((String)commonData.get("DateTime")));
				pstmt1.setString(22,getSignedBy());
				pstmt1.setString(23,getSignedDateTime());
				// 22 signed by
				//23 signed date/time
				/*pstmt1.setString(24,(String)commonData.get("login_by_id"));
				pstmt1.setString(25,(String)commonData.get("login_at_ws_no"));
				pstmt1.setString(26,login_facility_id);*/
				pstmt1.setString(24,(String)commonData.get("login_by_id"));
				pstmt1.setString(25,(String)commonData.get("login_at_ws_no"));
				pstmt1.setString(26,login_facility_id);
				pstmt1.setString(27,orderID);
				pstmt1.setString(28,orderLineNo);
				pstmt1.setString(29,checkForNull((String)commonData.get("weight")));
				pstmt1.setString(30,checkForNull((String)commonData.get("Diagnosis")));
				//34 dosage
				pstmt1.setString(31,checkForNull((String)commonData.get("dosage")));
				pstmt1.setString(32,checkForNull((String)commonData.get("administeredBy")));
				pstmt1.setString(33,checkForNull((String)commonData.get("batchID")));
				pstmt1.setString(34,checkForNull((String)commonData.get("expiryDate")));
				pstmt1.setString(35,checkForNull((String)commonData.get("manufacturerName")));
				pstmt1.setString(36,checkForNull((String)commonData.get("supplierName")));
				pstmt1.setString(37,checkForNull((String)commonData.get("adr_descp")));
				pstmt1.setString(38,checkForNull((String)commonData.get("ethnic_grp")));
				pstmt1.setString(39,checkForNull((String)commonData.get("sys_idn_drug_rlsp")));
				pstmt1.setString(40,checkForNull((String)commonData.get("Allergy_type")));
				pstmt1.setString(41,checkForNull((String)commonData.get("Allergy_type")));
				pstmt1.setString(42,patient_name);
				pstmt1.setString(43,drug_name1);
				pstmt1.setString(44,(String)commonData.get("hypersensitivity"));
				if( ((String)commonData.get("adrStatus")).equals("E") || ((String)commonData.get("adrStatus")).equals("C"))// code added for HSA-CRF-0005[40601] -- Start
					 pstmt1.setString(45,(String)commonData.get("adrStatus") ); 
				else //code added for HSA-CRF-0005[40601] -- End 
					pstmt1.setString(45,(String)commonData.get("status_act"));
				pstmt1.setString(46,(String)commonData.get("certanity"));
				pstmt1.setString(47,(String)commonData.get("sourceOfInfo"));
				pstmt1.setString(48,addedFacility_id);//login_facility_id			
				pstmt1.setString(49,(String)commonData.get("canErrorID"));// code added for HSA-CRF-0005[40601] -- Start 
				pstmt1.setString(50,(String)commonData.get("canErrorDate"));
				pstmt1.setString(51,(String)commonData.get("canRemarks") );
				pstmt1.setString(52,(String)commonData.get("adrStatus") );
				pstmt1.setString(53,(String)commonData.get("canReason") );// code added for HSA-CRF-0005[40601] -- End 
				pstmt1.setString(54,ADRNo);
				pstmt1.setString(55,login_facility_id);

				int nResultUpdate = pstmt1.executeUpdate();
				if(nResultUpdate>0){
					try{
						drugList = getOtherMedications();
						if(drugList.size()>0){
							for(int j=0;j<drugList.size();j++){
								drugDetails = (ArrayList)drugList.get(j);
								pstmt2.setString(1,ADRNo);
								pstmt2.setString(2,(String)drugDetails.get(0));
								pstmt2.setString(3,(String)drugDetails.get(1));				
								/*pstmt2.setString(4,(String)commonData.get("login_by_id"));
								pstmt2.setString(5,(String)commonData.get("login_at_ws_no"));
								pstmt2.setString(6,login_facility_id);*/
								pstmt2.setString(4,(String)commonData.get("login_by_id"));
								pstmt2.setString(5,(String)commonData.get("login_at_ws_no"));
								pstmt2.setString(6,login_facility_id);
								pstmt2.setString(7,(String)drugDetails.get(2));
								pstmt2.setString(8,(String)drugDetails.get(3));
								pstmt2.setString(9,addedFacility_id); //login_facility_id
								pstmt2.setString(10,ADRNo);
								pstmt2.setString(11,login_facility_id);
								pstmt2.addBatch();
							}
							int[] batch_result1 = pstmt2.executeBatch();

							for (int i=0;i<batch_result1.length;i++ ) {
								if (batch_result1[i]<0  && batch_result1[i] != -2) {
									pstmt2.cancel();
									nResult2=0;
									throw new Exception("Other Medication insertion Failed");
								}
								else{
									nResult2=1;		
								}
							}
						}
					}
					catch(Exception e){
						 e.printStackTrace() ;
					}
				}
				closeStatement(pstmt2);
				closeStatement(pstmt1);
				qstList=getQuestionnaire();

				/*pstmt8=connection.prepareStatement("UPDATE PR_ADV_DRUG_REACTION_QA SET ADR_NO=?,QUESTION_CODE=?,RESPONSE=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,FACILITY_ID=? WHERE ADR_NO=?");
				try{					
					for(int list=0;list<qstList.size();list++){
						String response="";
						qstMap=(HashMap)qstList.get(list);
						String code=(String)qstMap.get("code");
						response=(String)qstMap.get("response");
						if(!(response==null)){
							pstmt8.setString(1,ADRNo);						
							pstmt8.setString(2,code);
							pstmt8.setString(3,response);
							/*pstmt8.setString(4,(String)commonData.get("login_by_id"));
							pstmt8.setString(5,(String)commonData.get("login_at_ws_no"));
							pstmt8.setString(6,login_facility_id);*/
				/*			pstmt8.setString(4,(String)commonData.get("login_by_id"));
							pstmt8.setString(5,(String)commonData.get("login_at_ws_no"));
							pstmt8.setString(6,login_facility_id);
							pstmt8.setString(7,addedFacility_id);//login_facility_id
							pstmt8.setString(8,ADRNo);
							pstmt8.executeUpdate();
						}
					}
				}
				catch(Exception e){
					e.printStackTrace() ;
				}*/
//added for AAKH-SCF-0487 - start
				boolean adr_flag = false;
				String response="", code="";
					for(int list=0;list<qstList.size();list++){
						qstMap=(HashMap)qstList.get(list);
						code=(String)qstMap.get("code");
						response=(String)qstMap.get("response");
						if(!(response==null)){
							adr_flag = true;
							break;
						}
					}
				
				
				if(adr_no!=null && !adr_no.equals("")){
					
					
					pstmt9=connection.prepareStatement("DELETE FROM PR_ADV_DRUG_REACTION_QA WHERE ADR_NO=? and FACILITY_ID=?");
					pstmt9.setString(1,adr_no);
					pstmt9.setString(2,addedFacility_id);
					pstmt9.executeUpdate();
				
				}

				pstmt8=connection.prepareStatement("insert into PR_ADV_DRUG_REACTION_QA(ADR_NO,QUESTION_CODE,RESPONSE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,FACILITY_ID) VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");
				
				
				try{					

					if(adr_flag){
					for(int list=0;list<qstList.size();list++){
						qstMap=(HashMap)qstList.get(list);
						code=(String)qstMap.get("code");
						response=(String)qstMap.get("response");
						if(!(response==null)){
							pstmt8.setString(1,ADRNo);						
							pstmt8.setString(2,code);
							pstmt8.setString(3,response);
							pstmt8.setString(4,(String)commonData.get("login_by_id"));
							pstmt8.setString(5,(String)commonData.get("login_at_ws_no"));
							pstmt8.setString(6,login_facility_id);
							pstmt8.setString(7,(String)commonData.get("login_by_id"));
							pstmt8.setString(8,(String)commonData.get("login_at_ws_no"));
							pstmt8.setString(9,login_facility_id);
							pstmt8.setString(10,addedFacility_id);//login_facility_id
							pstmt8.executeUpdate();
						}
					}
				  }
				}
				catch(Exception e){
					e.printStackTrace() ;
				}
//added for AAKH-SCF-0487 - end
				if(nResult2>0){
					map.put( "result", new Boolean( true ) ) ;
					map.put( "flag", ADRNo ) ;
					map.put( "message","RECORD_INSERTED");
					connection.commit();
				}
				else{
					map.put( "result", new Boolean( false ) ) ;
					map.put( "flag", "0" ) ;
					map.put( "message","Transaction failed in inner ");
					connection.rollback();
				}
			}//code added for HSA-CRF-0005[40601] Ends
		}
		catch(Exception e){
			e.printStackTrace() ;
			System.err.println("UPDATETables failed :"+tabData);
		}
        finally{
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt1);
				closeStatement(pstmt2);
				closeStatement(pstmt3);
				closeStatement(pstmt4);
				closeStatement(pstmt6);
				closeStatement(pstmt7);
				closeStatement(pstmt8);
				closeStatement(pstmt9);
				closeConnection(connection);
			}
			catch(Exception exp){
				exp.printStackTrace();
			}
		}
		setSignedBy("");	
		setSignedDateTime("");
		return map;
	}
	//insert end

	public ArrayList getPatientDetails(String id){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT2") ) ;
			pstmt.setString(1,id);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("PATIENT_NAME"));
				records.add(resultSet.getString("AGE"));
				records.add(resultSet.getString("GENDER"));
			}
		}
		catch(Exception e){
			records.add(e.toString());
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

	public String getPatientIDLength(){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet			= pstmt.executeQuery(); 
			
			if( resultSet != null && resultSet.next() ) {
				pat_txt_length	=	checkForNull(resultSet.getString("PATIENT_ID_LENGTH"));
			}		
		}
		catch(Exception e){
			pat_txt_length	=e.toString();
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
		return pat_txt_length;	
	}

	public String getWeight(String order_id,int order_line_no){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String 	weight	=	"";

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ADR_SELECT5") ) ;
		    pstmt.setString(1,order_id);
            pstmt.setInt(2,order_line_no);
			resultSet			= pstmt.executeQuery(); 
			
			if( resultSet != null && resultSet.next() ) {
				weight	=	(String)resultSet.getString("WEIGHT");
			}		
		}
		catch(Exception e){
			weight	=e.toString();
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
		return weight;	
	}

	public ArrayList getDrugNames(String patient_id,String search_by,String search_str){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		
		try{

           if(search_by.equals("S"))
                search_str =search_str+"%";
		   else if(search_by.equals("C"))
                 search_str ="%"+search_str+"%";
		   else
			  search_str ="%"+search_str;

			connection	= getConnection() ;
			// pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ADR_SELECT1") ) ;
			pstmt		= connection.prepareStatement( "SELECT A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO,A.IV_PREP_YN,A.DRUG_CODE ,C.DRUG_DESC,A.DISPENSED_DRUGS,F.ROUTE_DESC,F.ROUTE_COLOR,(RTRIM(rtrim(to_char(A.DOSAGE, '999999990.999999'),'0'),'.'))||' '||G.SHORT_DESC||' , '||CHR(13)||DECODE(a.split_yn,'Y',NULL,H.FREQ_DESC||' , ')||CHR(13)||DURATION||' '||    I.DURN_DESC DOSAGE_DETAILS,TO_CHAR(A.START_DATE,'DD/MM/YYYY hh24:mi') START_DATE,TO_CHAR(A.END_DATE,'DD/MM/YYYY hh24:mi') END_DATE, A.PATIENT_CLASS,   D.PATIENT_NAME,E.PRACTITIONER_NAME,J.FACILITY_NAME,DECODE(P.ASSIGN_CARE_LOCN_TYPE, 'N',   L.LONG_DESC,'C',K.LONG_DESC) LOCATION,C.PRES_BASE_UOM,O.LAST_ACTION_REASON_DESC, A.HEIGHT,A.HEIGHT_UOM,A.WEIGHT,A.WEIGHT_UOM,A.PRESCRIBED_QTY,A.TOT_ISSUED_QTY,A.RETURNED_QTY,A.TOT_ADMINISTERED_QTY,A.DOSAGE_UOM_CODE,O.ORDER_UOM,R.ELAPSED_PRD_OF_ORD_FOR_ADR FROM PH_PATIENT_DRUG_PROFILE A, PH_GENERIC_NAME_LANG_VW B, PH_DRUG_LANG_VW C,MP_PATIENT D, AM_PRACTITIONER_LANG_VW E,PH_ROUTE_LANG_VW F,AM_UOM_LANG_VW G,AM_FREQUENCY_LANG_VW H, AM_DURATION_TYPE_LANG_VW I, SM_FACILITY_PARAM_LANG_VW J,OP_CLINIC_LANG_VW K,IP_NURSING_UNIT_LANG_VW L ,OR_ORDER_LINE O, PR_ENCOUNTER P,OR_ORDER Q, PH_PARAM_LANG_VW R  WHERE  Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID=? AND A.GENERIC_ID = B.GENERIC_ID  AND D.PATIENT_ID = A.PATIENT_ID AND A.DRUG_CODE = C.DRUG_CODE  AND E.PRACTITIONER_ID=A.PRES_PRACTITIONER_ID AND F.ROUTE_CODE = C.ROUTE_CODE  AND G.UOM_CODE = A.DOSAGE_UOM_CODE AND H.FREQ_CODE = A.FREQ_CODE  AND I.DURN_TYPE = A.DURN_TYPE AND J.FACILITY_ID = A.ORIG_FACILITY_ID AND K.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND K.CLINIC_CODE(+) = A.LOCN_CODE  AND L.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND L.NURSING_UNIT_CODE(+)= A.LOCN_CODE  AND A.ORIG_ORDER_ID=O.ORDER_ID AND A.ORIG_ORDER_LINE_NO=O.ORDER_LINE_NUM AND P.ENCOUNTER_ID=A.ENCOUNTER_ID AND P.FACILITY_ID=A.ORIG_FACILITY_ID AND A.END_DATE >= (SYSDATE - nvl(R.ELAPSED_PRD_OF_ORD_FOR_ADR,0))  AND CAN_DATE_TIME IS NULL AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = F.LANGUAGE_ID AND B.LANGUAGE_ID = G.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND K.LANGUAGE_ID(+) = ? AND L.LANGUAGE_ID(+) = ? and upper(c.drug_desc) like upper(?) UNION SELECT PATIENT_ID || '-'|| SRL_NO ORIG_ORDER_ID, 	SRL_NO ORIG_ORDER_LINE_NO, 	NULL IV_PREP_YN, DRUG_CODE, (select drug_desc from ph_drug where drug_code = NVL (a.drug_code, a.ext_drug_code)) DRUG_DESC,(select drug_desc from ph_drug where drug_code = nvl(a.drug_code,a.ext_drug_code)) DISPENSED_DRUGS, NULL ROUTE_DESC,NULL route_color ,NULL DOSAGE_DETAILS, to_char(START_DATE,'DD/MM/YYYY hh24:mi') START_DATE, to_char(END_DATE,'DD/MM/YYYY hh24:mi') END_DATE,'XT' PATIENT_CLASS, (select patient_name from mp_patient where patient_id = a.patient_id) PATIENT_NAME, PRACTITIONER_NAME PRACTITIONER_NAME, (select facility_name from sm_facility_param where facility_id = a.added_facility_id) FACILITY_NAME, NULL LOCATION, 	NULL PRES_BASE_UOM, INSTRUCTIONS LAST_ACTION_REASON_DESC, NULL HEIGHT, NULL HEIGHT_UOM, NULL WEIGHT, NULL WEIGHT_UOM, NULL PRESCRIBED_QTY, NULL TOT_ISSUED_QTY, NULL RETURNED_QTY, 	NULL TOT_ADMINISTERED_QTY, 	NULL DOSAGE_UOM_CODE, NULL ORDER_UOM, R.ELAPSED_PRD_OF_ORD_FOR_ADR ELAPSED_PRD_OF_ORD_FOR_ADR FROM ph_param r ,PH_PATIENT_EXT_DRUG_PROFILE a where PATIENT_ID = ? and upper(a.drug_desc) like upper(?)" ) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,getLanguageId());
			pstmt.setString(5,search_str);
			pstmt.setString(6,patient_id);
			pstmt.setString(7,search_str);
			
			
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				records.add(checkForNull(resultSet.getString("ORIG_ORDER_ID")));
				records.add(checkForNull(resultSet.getString("ORIG_ORDER_LINE_NO")));
				records.add(checkForNull(resultSet.getString("DRUG_CODE")));
				records.add(checkForNull(resultSet.getString("DRUG_DESC")));
				records.add(checkForNull(resultSet.getString("ROUTE_DESC")));
				records.add(checkForNull(resultSet.getString("DOSAGE_DETAILS")));		
				records.add(checkForNull(resultSet.getString("START_DATE")));
				records.add(checkForNull(resultSet.getString("END_DATE")));
				records.add(checkForNull(resultSet.getString("TOT_ISSUED_QTY")));		
				records.add(checkForNull(resultSet.getString("TOT_ADMINISTERED_QTY")));
				records.add(checkForNull(resultSet.getString("PRACTITIONER_NAME")));
				records.add(checkForNull(resultSet.getString("LOCATION")));	
				records.add(checkForNull(resultSet.getString("ROUTE_COLOR")));	// added for CRF RUT-CRF-0034.1[IN:037389]
			}		
		}
		catch(Exception e){
				records.add(e.toString());
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

	//Method to get the drug details for other medication.....
	  public ArrayList DrugsOtherMedication(String patient_id){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	OMDrugs		=	new ArrayList();
		
		try{
			connection	= getConnection() ;
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ADR_SELECT1A") ) ;
			pstmt = connection.prepareStatement("SELECT A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO,A.IV_PREP_YN,A.DRUG_CODE ,C.DRUG_DESC,A.DISPENSED_DRUGS,F.ROUTE_DESC,f.ROUTE_COLOR,(RTRIM(rtrim(to_char(A.DOSAGE, '999999990.999999'),'0'),'.'))||' '||G.SHORT_DESC||' , '||CHR(13)||DECODE(a.split_yn,'Y',NULL,H.FREQ_DESC||' , ')||CHR(13)||DURATION||' '||    I.DURN_DESC DOSAGE_DETAILS,TO_CHAR(A.START_DATE,'DD/MM/YYYY hh24:mi') START_DATE,TO_CHAR(A.END_DATE,'DD/MM/YYYY hh24:mi') END_DATE, A.PATIENT_CLASS,   D.PATIENT_NAME,E.PRACTITIONER_NAME,J.FACILITY_NAME,DECODE(P.ASSIGN_CARE_LOCN_TYPE, 'N',   L.LONG_DESC,'C',K.LONG_DESC) LOCATION,C.PRES_BASE_UOM,O.LAST_ACTION_REASON_DESC, A.HEIGHT,A.HEIGHT_UOM,A.WEIGHT,A.WEIGHT_UOM,A.PRESCRIBED_QTY,A.TOT_ISSUED_QTY,A.RETURNED_QTY,A.TOT_ADMINISTERED_QTY,A.DOSAGE_UOM_CODE,O.ORDER_UOM,R.ELAPSED_PRD_OF_ORD_FOR_ADR,A.GENERIC_ID FROM PH_PATIENT_DRUG_PROFILE A, PH_GENERIC_NAME_LANG_VW B, PH_DRUG_LANG_VW C,MP_PATIENT D, AM_PRACTITIONER_LANG_VW E,PH_ROUTE_LANG_VW F,AM_UOM_LANG_VW G,AM_FREQUENCY_LANG_VW H,    AM_DURATION_TYPE_LANG_VW I, SM_FACILITY_PARAM_LANG_VW J,OP_CLINIC_LANG_VW K,IP_NURSING_UNIT_LANG_VW L ,OR_ORDER_LINE O, PR_ENCOUNTER P,OR_ORDER Q, PH_PARAM_LANG_VW R  WHERE  Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID=? AND A.GENERIC_ID = B.GENERIC_ID  AND D.PATIENT_ID = A.PATIENT_ID AND A.DRUG_CODE = C.DRUG_CODE  AND E.PRACTITIONER_ID=A.PRES_PRACTITIONER_ID AND F.ROUTE_CODE = C.ROUTE_CODE  AND G.UOM_CODE = A.DOSAGE_UOM_CODE AND H.FREQ_CODE = A.FREQ_CODE  AND I.DURN_TYPE = A.DURN_TYPE AND J.FACILITY_ID = A.ORIG_FACILITY_ID AND K.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND K.CLINIC_CODE(+) = A.LOCN_CODE  AND L.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND L.NURSING_UNIT_CODE(+)= A.LOCN_CODE  AND A.ORIG_ORDER_ID=O.ORDER_ID AND A.ORIG_ORDER_LINE_NO=O.ORDER_LINE_NUM AND P.ENCOUNTER_ID=A.ENCOUNTER_ID AND P.FACILITY_ID=A.ORIG_FACILITY_ID AND A.END_DATE >= (SYSDATE - R.ELAPSED_PRD_OF_ORD_FOR_ADR) AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = F.LANGUAGE_ID AND B.LANGUAGE_ID = G.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND K.LANGUAGE_ID(+) = ? AND L.LANGUAGE_ID(+) = ?  ");// added for CRF RUT-CRF-0034.1[IN:037389]
			pstmt.setString(1,patient_id);
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,getLanguageId());
			
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				OMDrugs.add(checkForNull(resultSet.getString("DRUG_DESC")));
				OMDrugs.add(checkForNull(resultSet.getString("ROUTE_DESC")));
				OMDrugs.add(checkForNull(resultSet.getString("DOSAGE_DETAILS")));		
				OMDrugs.add(checkForNull(resultSet.getString("START_DATE")));
				OMDrugs.add(checkForNull(resultSet.getString("END_DATE")));
				OMDrugs.add(checkForNull(resultSet.getString("TOT_ISSUED_QTY")));		
				OMDrugs.add(checkForNull(resultSet.getString("TOT_ADMINISTERED_QTY")));
				OMDrugs.add(checkForNull(resultSet.getString("PRACTITIONER_NAME")));
				OMDrugs.add(checkForNull(resultSet.getString("LOCATION")));
				OMDrugs.add(checkForNull(resultSet.getString("ORIG_ORDER_ID")));
				OMDrugs.add(checkForNull(resultSet.getString("ORIG_ORDER_LINE_NO")));
				OMDrugs.add(checkForNull(resultSet.getString("DRUG_CODE")));
				OMDrugs.add(checkForNull(resultSet.getString("GENERIC_ID")));
				OMDrugs.add(checkForNull(resultSet.getString("ROUTE_COLOR"))); // added for CRF RUT-CRF-0034.1[IN:037389]
			}						
		}
		catch(Exception e){
			OMDrugs.add(e.toString());
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
		return OMDrugs;	
	}

    //To get the details of the suspensed drug....
	public ArrayList getDrugDetails(String order_id,int order_linenum){
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rset =null;
        ArrayList drugdetails=new ArrayList();
		try{
			conn		= getConnection() ;
			pstmt		= conn.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ADR_SELECT2") ) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,login_facility_id);
			pstmt.setString(4,getLanguageId());

			pstmt.setString(5,order_id);
			pstmt.setInt(6,order_linenum);
			pstmt.setString(7,getLanguageId());
			pstmt.setString(8,getLanguageId());
			pstmt.setString(9,getLanguageId());
			pstmt.setString(10,getLanguageId());
			pstmt.setString(11,getLanguageId());
			rset=pstmt.executeQuery();
			if(rset!=null){
				while(rset.next()){
					drugdetails.add(checkForNull(rset.getString("DRUG_DESC")));
					drugdetails.add(checkForNull(rset.getString("GENERIC_NAME")));
					drugdetails.add(checkForNull(rset.getString("STRENGTH_VALUE")));
					drugdetails.add(checkForNull(rset.getString("STRENGTH_UOM")));
					drugdetails.add(checkForNull(rset.getString("ROUTE_DESC")));
					drugdetails.add(checkForNull(rset.getString("FORM_DESC")));
					drugdetails.add(checkForNull(rset.getString("QTY_VALUE")));
					drugdetails.add(checkForNull(rset.getString("QTY_UNIT")));
					drugdetails.add(checkForNull(rset.getString("FREQ_DESC")));
					drugdetails.add(checkForNull(rset.getString("DURN_VALUE")));
					drugdetails.add(checkForNull(rset.getString("DURN_DESC")));
					drugdetails.add(checkForNull(rset.getString("START_DATE")));
					drugdetails.add(checkForNull(rset.getString("END_DATE")));
					drugdetails.add(checkForNull(rset.getString("GENERIC_ID")));
					drugdetails.add(checkForNull(rset.getString("ORDER_CATALOG_CODE")));
					drugdetails.add(checkForNull(rset.getString("ROUTE_COLOR")));// added for CRF RUT-CRF-0034.1[IN:037389] 
				}
			}
		}
		catch(Exception exp){
        	drugdetails.add(exp.toString());
			exp.printStackTrace();
		}
		finally{
			try{
				closeResultSet( rset ) ;
				closeStatement( pstmt ) ;
				closeConnection( conn );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return drugdetails;	
	}

    //To get the details of the suspensed drug....
	public ArrayList getExtDrugDetails(String patient_id,String srl_no){
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rset =null;

        ArrayList extDrugDetails=new ArrayList();

		try{
			conn		= getConnection() ;
			pstmt		= conn.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ADR_SELECT2_EXTDRUG") ) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,patient_id);
			pstmt.setString(4,srl_no);
			pstmt.setString(5,getLanguageId());
			pstmt.setString(6,getLanguageId());
			pstmt.setString(7,getLanguageId());
			pstmt.setString(8,getLanguageId());
			pstmt.setString(9,getLanguageId());
			pstmt.setString(10,getLanguageId());
			rset=pstmt.executeQuery();
			if(rset!=null){
				while(rset.next()){
					extDrugDetails.add(checkForNull(rset.getString("DRUG_DESC")));
					extDrugDetails.add(checkForNull(rset.getString("GENERIC_NAME")));
					extDrugDetails.add(checkForNull(rset.getString("STRENGTH_VALUE")));
					extDrugDetails.add(checkForNull(rset.getString("STRENGTH_UOM")));
					extDrugDetails.add("");//ROUTE_DESC
					extDrugDetails.add(checkForNull(rset.getString("FORM_DESC")));
					extDrugDetails.add("");//QTY_VALUE
					extDrugDetails.add("");//QTY_UNIT
					extDrugDetails.add("");// FREQ_DESC
					extDrugDetails.add("");//DURN_VALUE
					extDrugDetails.add("");//DURN_DESC
					extDrugDetails.add(checkForNull(rset.getString("START_DATE")));
					extDrugDetails.add(checkForNull(rset.getString("END_DATE")));
					extDrugDetails.add(checkForNull(rset.getString("GENERIC_ID")));
					extDrugDetails.add(checkForNull(rset.getString("ORDER_CATALOG_CODE")));
					extDrugDetails.add(checkForNull(rset.getString("ROUTE_COLOR")));// added for CRF RUT-CRF-0034.1[IN:037389] 
				}
			}
		}
		catch(Exception exp){
        	extDrugDetails.add(exp.toString());
			exp.printStackTrace();
		}
		finally{
			try{
				closeResultSet( rset ) ;
				closeStatement( pstmt ) ;
				closeConnection( conn );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return extDrugDetails;	
	}
   //To get the trade name of the suspected drug...
	public ArrayList getTradeDetails(String drug_code){
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rset =null;

        ArrayList tradedetails=new ArrayList();

		try{
			conn	= getConnection() ;
			pstmt		= conn.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ADR_SELECT3") ) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2,getLanguageId());

			rset=pstmt.executeQuery();

			if(rset!=null)	{
				while(rset.next()){
					tradedetails.add(checkForNull(rset.getString("SHORT_NAME")));
					tradedetails.add(checkForNull(rset.getString("TRADE_CODE")));
				}
			}
		}
		catch(Exception exp){
        	tradedetails.add(exp.toString());
			exp.printStackTrace();
		}
		 finally {
			try{
				closeResultSet( rset ) ;
				closeStatement( pstmt ) ;
				closeConnection( conn );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return tradedetails;	
	}

    //Tp get the diagnosis description
	public String getDiagnosisDescription(String order_id,int order_no){
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rset =null;
        String diagnosis="";

		try{
			conn	= getConnection() ;
			pstmt		= conn.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ADR_SELECT4") ) ;
			pstmt.setString(1,order_id);
			pstmt.setInt(2,order_no);

			rset=pstmt.executeQuery();
			if(rset!=null){
				while(rset.next()){
					diagnosis=checkForNull(rset.getString("DIAG_TEXT"));
				}
			}
		}
		catch(Exception exp){
			exp.printStackTrace();
		}
		 finally {
			try{
				closeResultSet( rset ) ;
				closeStatement( pstmt ) ;
				closeConnection( conn );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return diagnosis;	
	}

	public ArrayList loadAdministeredDate(String orderId,int orderLineNo){
	    Connection connection	 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet		 =		null ;
		ArrayList records		 =		new ArrayList();
		try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ADR_SELECT6" )) ;
			pstmt.setString(1,orderId);
			pstmt.setInt(2,orderLineNo);
			resultSet      = pstmt.executeQuery() ;
			while(resultSet.next()){
				records.add(checkForNull(resultSet.getString("ADMIN_DATE_TIME")));
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			try {
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

	public ArrayList loadDosageName(String orderId,int orderLineNo){
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList records					 =		new ArrayList();
		try {
			connection	 = getConnection() ;
			//pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ADR_SELECT7" )) ;
			//pstmt = connection.prepareStatement("SELECT (RTRIM(rtrim(to_char(QTY_VALUE, '999999990.999999'),'0'),'.')) QTY_VALUE,QTY_UNIT FROM OR_ORDER_LINE WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");

			pstmt = connection.prepareStatement("SELECT (RTRIM(rtrim(to_char(QTY_VALUE, '999999990.999999'),'0'),'.')) QTY_VALUE,PH_GET_UOM_DISPLAY('"+login_facility_id+"', QTY_UNIT, '"+getLanguageId()+"') QTY_UNIT FROM OR_ORDER_LINE WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");

			pstmt.setString(1,orderId);
			pstmt.setInt(2,orderLineNo);
			resultSet      = pstmt.executeQuery() ;
			if(resultSet.next()){
				records.add(checkForNull(resultSet.getString("QTY_VALUE")));
				records.add(checkForNull(resultSet.getString("QTY_UNIT")));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
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

	public ArrayList loadDosageDetails(String patientId,String orderId,String orderLineNo,String administeredDate) {
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList records					 =		new ArrayList();
		try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ADR_SELECT8" )) ;

			pstmt.setString(1,orderId);
			pstmt.setString(2,orderLineNo);
			pstmt.setString(3,patientId);
			pstmt.setString(4,administeredDate);
			resultSet      = pstmt.executeQuery() ;
			if(resultSet.next()){
				records.add(checkForNull(resultSet.getString("ADMIN_BY")));
				records.add(checkForNull(resultSet.getString("BATCH_ID")));
				records.add(checkForNull(resultSet.getString("EXPIRY_DATE")));
				records.add(checkForNull(resultSet.getString("TRADE_ID")));	
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
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

	public ArrayList loadADRTypes() {
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		HashMap records					 =		null;
		ArrayList result						 =		new ArrayList();
									
		try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ADR_SELECT13" )) ;
			pstmt.setString(1,getLanguageId());

			resultSet      = pstmt.executeQuery() ;
			while(resultSet.next()){
				records=new HashMap();
				records.put("code",(String)resultSet.getString("ADR_CODE"));
				records.put("desc",(String)resultSet.getString("ADR_DESC"));
				result.add(records);					
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
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

	public String onSetReactionTime(String onSetdate,String adminDate) {
	    Connection connection	 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet		 =		null ;
		String result			 =		"";
									
		try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ADR_SELECT9" )) ;
			pstmt.setString(1,onSetdate);
			pstmt.setString(2,adminDate);
			resultSet      = pstmt.executeQuery() ;

			if(resultSet.next()){
				result=(String)resultSet.getString("DAY_COMP");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
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

	public String loadOnsetDate(String onsetvalue,String onsettimetype,String adminsterDate) {
	    Connection connection	 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet		 =		null ;
		String result			 =		"";
		try {
			connection	 = getConnection() ;
			if(onsettimetype.equals("M"))
				pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ADR_SELECT10" )) ;
			else if(onsettimetype.equals("H"))
				pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ADR_SELECT11" )) ;
			else if(onsettimetype.equals("D"))
			pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ADR_SELECT12" )) ;

			pstmt.setString(1,adminsterDate);
			pstmt.setString(2,onsetvalue);
			resultSet      = pstmt.executeQuery() ;
				
			if(resultSet.next()){
				if(onsettimetype.equals("M"))
					result=(String)resultSet.getString("ONSET_DATE");
				else if(onsettimetype.equals("H"))
					result=(String)resultSet.getString("ONSET_DATE");
				else if(onsettimetype.equals("D"))
					result=(String)resultSet.getString("ONSET_DATE");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
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

	public ArrayList getAdrDetails(String patient_id,String adr_no,String reported_date_from,String reported_date_to,String reported_by,String signed_by,String suspected_drug,String status){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
	
		ArrayList	records		=	new ArrayList();
		String sqlQry     = "";
		String sqlQry1="", facility_id=""; 
		hmAdrStatusDtl = new HashMap();//code added for HSA-CRF-0005[40601] 
		HashMap tmpadrstsDtl = null;//code added for HSA-CRF-0005[40601] 
					
		try{
			connection			= getConnection() ;
			//	sqlQry				= PhRepository.getPhKeyValue("SQL_PH_ADRDRUG_QUERY_SELECT")  ;
			sqlQry="SELECT A.ORDER_ID ORDER_ID, A.ORDER_LINE_NUM ORDER_LINE_NUM,A.PATIENT_ID PATIENT_ID,TO_NUMBER(A.ADR_NO) ADR_NO,TO_CHAR(A.PREPARED_DATE_TIME,'DD/MM/YYYY HH24:MI') PREPARED_DATE_TIME,(SELECT APPL_USER_NAME  FROM SM_APPL_USER WHERE  APPL_USER_ID = a.VERIFIED_BY) VERIFIED_BY,(SELECT APPL_USER_NAME  FROM SM_APPL_USER WHERE APPL_USER_ID = a.SIGNED_BY) SIGNED_BY,A.DRUG_CODE DRUG_CODE,A.ADR_TYPE ADR_TYPE,A.WEIGHT WEIGHT,B.DRUG_DESC DRUG_DESC, C.ADR_DESC ADR_DESC,A.ETHNIC_GROUP ETHNIC_GROUP,A.PATIENT_NAME PATIENT_NAME,A.FACILITY_ID, F.facility_name,A.ADR_STATUS,(SELECT APPL_USER_NAME  FROM SM_APPL_USER WHERE  APPL_USER_ID = a.CANCEL_ERROR_BY_ID) CANCEL_ERROR_BY_ID ,TO_CHAR(CANCEL_ERROR_DATE,'DD/MM/YYYY HH24:MI') CANCEL_ERROR_DATE,A.CANCEL_ERROR_REMARKS,CANCEL_ERR_REASON,SIGNED_BY SIGNED_BY_ID FROM PR_ADV_DRUG_REACTION A,PH_DRUG_LANG_VW B, PH_ADR_TYPE_LANG_VW C, SM_FACILITY_PARAM_LANG_VW F, SM_APPL_USER G WHERE PATIENT_ID IS NOT NULL and a.facility_id = f.facility_id AND A.DRUG_CODE = B.DRUG_CODE AND A.ADR_TYPE = C.ADR_CODE AND PATIENT_ID = NVL(?,PATIENT_ID) AND ADR_NO = NVL(?,ADR_NO) AND VERIFIED_BY = NVL(?,VERIFIED_BY) AND A.DRUG_CODE = NVL(?,A.DRUG_CODE) AND TRUNC(PREPARED_DATE_TIME) BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID =? and f.language_id=? and g.language_id(+)=? and a.CANCEL_ERROR_BY_ID = g.APPL_USER_ID(+) " ;// AND A.FACILITY_ID = NVL(?,A.FACILITY_ID) removed from where clause for Multi falicity Bru-HIMS-CRF-089 [IN029955] , A.FACILITY_ID,F.facility_name added for 33963 and VERIFIED_BY replaced by  (SELECT APPL_USER_NAME  FROM SM_APPL_USER WHERE  APPL_USER_ID = a.VERIFIED_BY) VERIFIED_BY ,SIGNED_BY replaced by (SELECT APPL_USER_NAME  FROM SM_APPL_USER WHERE APPL_USER_ID = a.SIGNED_BY) SIGNED_BY and code added (SELECT APPL_USER_NAME  FROM SM_APPL_USER WHERE  APPL_USER_ID = a.CANCEL_ERROR_BY_ID) CANCEL_ERROR_BY_ID ,TO_CHAR(CANCEL_ERROR_DATE,'DD/MM/YYYY HH24:MI') CANCEL_ERROR_DATE,A.CANCEL_ERROR_REMARKS,CANCEL_ERR_REASON,SIGNED_BY SIGNED_BY_ID for HSA-CRF-0005[40601]

			sqlQry1=" UNION ALL SELECT A.ORDER_ID ORDER_ID, A.ORDER_LINE_NUM ORDER_LINE_NUM,A.PATIENT_ID PATIENT_ID,TO_NUMBER(A.ADR_NO) ADR_NO,TO_CHAR(A.PREPARED_DATE_TIME,'DD/MM/YYYY HH24:MI') PREPARED_DATE_TIME,(SELECT APPL_USER_NAME  FROM SM_APPL_USER WHERE  APPL_USER_ID = a.VERIFIED_BY) VERIFIED_BY,(SELECT APPL_USER_NAME  FROM SM_APPL_USER WHERE APPL_USER_ID = a.SIGNED_BY) SIGNED_BY			,A.DRUG_CODE DRUG_CODE,A.ADR_TYPE ADR_TYPE,A.WEIGHT WEIGHT,DRUG_NAME DRUG_DESC, C.ADR_DESC ADR_DESC,A.ETHNIC_GROUP ETHNIC_GROUP,A.PATIENT_NAME PATIENT_NAME,A.FACILITY_ID,F.facility_name,A.ADR_STATUS,	(SELECT APPL_USER_NAME  FROM SM_APPL_USER WHERE  APPL_USER_ID = a.CANCEL_ERROR_BY_ID)	CANCEL_ERROR_BY_ID, TO_CHAR(CANCEL_ERROR_DATE,'DD/MM/YYYY HH24:MI') CANCEL_ERROR_DATE,A.CANCEL_ERROR_REMARKS,CANCEL_ERR_REASON ,SIGNED_BY SIGNED_BY_ID FROM PR_ADV_DRUG_REACTION A, PH_ADR_TYPE_LANG_VW C, SM_FACILITY_PARAM_LANG_VW F, SM_APPL_USER G WHERE PATIENT_ID IS NULL and a.facility_id = f.facility_id AND ? IS NULL AND ? IS NULL AND A.DRUG_CODE IS NULL AND A.ADR_TYPE = C.ADR_CODE AND ADR_NO = NVL(?,ADR_NO) AND VERIFIED_BY = NVL(?,VERIFIED_BY) AND TRUNC(PREPARED_DATE_TIME) BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND C.LANGUAGE_ID = ? and f.language_id=? and g.language_id(+)=? and a.CANCEL_ERROR_BY_ID = g.APPL_USER_ID(+)"; // AND A.FACILITY_ID = NVL(?,A.FACILITY_ID)" removed from where clause for Multi falicity Bru-HIMS-CRF-089 [IN029955] , , A.FACILITY_ID,F.facility_name added for 33963 and  and VERIFIED_BY replaced by  (SELECT APPL_USER_NAME  FROM SM_APPL_USER WHERE  APPL_USER_ID = a.VERIFIED_BY) VERIFIED_BY ,SIGNED_BY replaced by (SELECT APPL_USER_NAME  FROM SM_APPL_USER WHERE APPL_USER_ID = a.SIGNED_BY) SIGNED_BY and code added (SELECT APPL_USER_NAME  FROM SM_APPL_USER WHERE  APPL_USER_ID = a.CANCEL_ERROR_BY_ID) CANCEL_ERROR_BY_ID ,TO_CHAR(CANCEL_ERROR_DATE,'DD/MM/YYYY HH24:MI') CANCEL_ERROR_DATE,A.CANCEL_ERROR_REMARKS,CANCEL_ERR_REASON,,SIGNED_BY SIGNED_BY_ID for HSA-CRF-0005[40601] 

			if (status.equals("S")){
				sqlQry = sqlQry + " AND SIGNED_BY = NVL(?,SIGNED_BY) AND ADR_STATUS ='S' "; //code 'AND ADR_STATUS ' added for HSA-CRF-0005[40601]    
				sqlQry1 = sqlQry1 + "AND SIGNED_BY = NVL(?,SIGNED_BY) AND ADR_STATUS ='S' "; //code 'AND ADR_STATUS ' added for HSA-CRF-0005[40601]    
			}
			else if(status.equals("U")){
				sqlQry = sqlQry + " AND SIGNED_BY IS NULL AND ADR_STATUS ='U' "  ;  //code 'AND ADR_STATUS ' added for HSA-CRF-0005[40601]   
				sqlQry1 = sqlQry1 + "AND SIGNED_BY IS NULL AND ADR_STATUS ='U' " ; //code 'AND ADR_STATUS ' added for HSA-CRF-0005[40601]   
			}
			else if(status.equals("C")){//code added for HSA-CRF-0005[40601] -- Start 
				sqlQry = sqlQry + " AND ADR_STATUS ='C' "  ;
				sqlQry1 = sqlQry1 + " AND ADR_STATUS ='C' " ;  
			}
			else if(status.equals("E")){
				sqlQry = sqlQry + " AND SIGNED_BY = NVL(?,SIGNED_BY) AND ADR_STATUS ='E' " ;  
				sqlQry1 = sqlQry1 + "AND SIGNED_BY = NVL(?,SIGNED_BY)  AND ADR_STATUS ='E' " ; 
			}
			else if( status.equals("A") && !signed_by.equals("") ){
				sqlQry = sqlQry + " AND SIGNED_BY = NVL(?,SIGNED_BY)  " ;  
				sqlQry1 = sqlQry1 + "AND SIGNED_BY = NVL(?,SIGNED_BY)  " ; 
			}	//code added for HSA-CRF-0005[40601] -- End 		
			sqlQry=sqlQry+sqlQry1+" order by ADR_NO";
			
			
			pstmt	= connection.prepareStatement(sqlQry);
			int count = 1;
			pstmt.setString(count++,patient_id);
			pstmt.setString(count++,adr_no);
			pstmt.setString(count++,reported_by);
			pstmt.setString(count++,suspected_drug);
			pstmt.setString(count++,reported_date_from); 
			pstmt.setString(count++,reported_date_to); 
			pstmt.setString(count++,getLanguageId());
			pstmt.setString(count++,getLanguageId());
			pstmt.setString(count++,getLanguageId());
		//	pstmt.setString(8,login_facility_id);
			if (status.equals("S") || status.equals("E") || ( status.equals("A") && !signed_by.equals("")) ){ //code  '|| status.equals("E") || ( status.equals("A") && !signed_by.equals(""))' added for HSA-CRF-0005[40601] -- End 
				pstmt.setString(count++,signed_by);
				pstmt.setString(count++,patient_id);
				pstmt.setString(count++,suspected_drug);
				pstmt.setString(count++,adr_no);
				pstmt.setString(count++,reported_by);
				pstmt.setString(count++,reported_date_from); 
				pstmt.setString(count++,reported_date_to); 
				pstmt.setString(count++,getLanguageId());
				pstmt.setString(count++,getLanguageId());
				pstmt.setString(count++,getLanguageId());
				//pstmt.setString(17,login_facility_id);
				pstmt.setString(count++,signed_by);
			}
			else{
				pstmt.setString(count++,patient_id);
				pstmt.setString(count++,suspected_drug);
				pstmt.setString(count++,adr_no);
				pstmt.setString(count++,reported_by);
				pstmt.setString(count++,reported_date_from); 
				pstmt.setString(count++,reported_date_to); 
				pstmt.setString(count++,getLanguageId());
				pstmt.setString(count++,getLanguageId());
				pstmt.setString(count++,getLanguageId());
				//pstmt.setString(16,login_facility_id);
			}

			resultSet	= pstmt.executeQuery(); 

			while( resultSet != null && resultSet.next() ) {
				facility_id = checkForNull(resultSet.getString("FACILITY_ID"));
				patient_id = checkForNull(resultSet.getString("PATIENT_ID"));
				adr_no = checkForNull(resultSet.getString("ADR_NO"));
				records.add(checkForNull(resultSet.getString("PATIENT_ID")));
				records.add(checkForNull(resultSet.getString("ADR_NO")));
				records.add(checkForNull(resultSet.getString("PREPARED_DATE_TIME")));
				records.add(checkForNull(resultSet.getString("VERIFIED_BY")));
				records.add(checkForNull(resultSet.getString("SIGNED_BY")));
				records.add(checkForNull(resultSet.getString("DRUG_CODE")));
				records.add(checkForNull(resultSet.getString("ADR_TYPE")));
				records.add(checkForNull(resultSet.getString("WEIGHT")));
				records.add(checkForNull(resultSet.getString("DRUG_DESC")));
				records.add(checkForNull(resultSet.getString("ORDER_ID")));
				records.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));
				records.add(checkForNull(resultSet.getString("ADR_DESC")));
				records.add(checkForNull(resultSet.getString("ETHNIC_GROUP"))); 
				records.add(checkForNull(resultSet.getString("PATIENT_NAME"))); 
				records.add(checkForNull(resultSet.getString("FACILITY_ID"))); 
				records.add(checkForNull(resultSet.getString("FACILITY_NAME"))); 
				records.add(checkForNull(resultSet.getString("ADR_STATUS"))); //code added for HSA-CRF-0005[40601] --Start			
				records.add(checkForNull(resultSet.getString("SIGNED_BY_ID"))); 
				tmpadrstsDtl = new HashMap();
				tmpadrstsDtl.put("ADR_STATUS", checkForNull(resultSet.getString("ADR_STATUS")));
				tmpadrstsDtl.put("CANCEL_ERROR_BY_ID",checkForNull(resultSet.getString("CANCEL_ERROR_BY_ID")));
				tmpadrstsDtl.put("CANCEL_ERROR_DATE",checkForNull(resultSet.getString("CANCEL_ERROR_DATE")));
				tmpadrstsDtl.put("CANCEL_ERROR_REMARKS",checkForNull(resultSet.getString("CANCEL_ERROR_REMARKS")));
				tmpadrstsDtl.put("CANCEL_ERR_REASON",checkForNull(resultSet.getString("CANCEL_ERR_REASON")));
				hmAdrStatusDtl.put(facility_id+patient_id+adr_no, tmpadrstsDtl); //code added for HSA-CRF-0005[40601] --End
				
			}			
		}
		catch(Exception e){
			records.add(e.toString());
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

	public ArrayList getAdrDrugDetails(String order_id,int order_line_num){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
	
		ArrayList	records		=	new ArrayList();
		
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ADRDRUG_DETAIL_SELECT")  );
			pstmt.setString(1,login_facility_id);
 			pstmt.setString(2,getLanguageId());

			pstmt.setString(3,login_facility_id);
 			pstmt.setString(4,getLanguageId());

			pstmt.setString(5,order_id);
			pstmt.setInt(6,order_line_num);
			pstmt.setString(7,getLanguageId());
			pstmt.setString(8,getLanguageId());
			pstmt.setString(9,getLanguageId());
			pstmt.setString(10,getLanguageId());
			pstmt.setString(11,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
					records.add(checkForNull(resultSet.getString("ORDER_CATALOG_CODE")));
					records.add(checkForNull(resultSet.getString("DRUG_DESC")));
					records.add(checkForNull(resultSet.getString("GENERIC_ID")));
					records.add(checkForNull(resultSet.getString("GENERIC_NAME")));
					records.add(checkForNull(resultSet.getString("STRENGTH_VALUE")));
					records.add(checkForNull(resultSet.getString("STRENGTH_UOM")));
					records.add(checkForNull(resultSet.getString("ROUTE_DESC")));
					records.add(checkForNull(resultSet.getString("FORM_DESC")));
					records.add(checkForNull(resultSet.getString("QTY_VALUE")));
					records.add(checkForNull(resultSet.getString("QTY_UNIT")));
					records.add(checkForNull(resultSet.getString("FREQ_CODE")));
					records.add(checkForNull(resultSet.getString("FREQ_DESC")));
					records.add(checkForNull(resultSet.getString("DURN_VALUE")));
					records.add(checkForNull(resultSet.getString("DURN_DESC")));
					records.add(checkForNull(resultSet.getString("START_DATE")));
					records.add(checkForNull(resultSet.getString("END_DATE")));
					records.add(checkForNull(resultSet.getString("TRADE_CODE")));
					records.add(checkForNull(resultSet.getString("ROUTE_COLOR"))); // added for CRF RUT-CRF-0034.1[IN:037389]
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

	public ArrayList getExtDrugAdrDetails(String patient_id, String order_id, String order_line_num, String adr_no){ //adr_no added for ML-BRU-SCF-1397 [IN:050181]
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
	
		ArrayList	records		=	new ArrayList();
		
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_EXT_ADRDRUG_DETAIL_SELECT")  );
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,patient_id);
			pstmt.setString(4,order_line_num);
			pstmt.setString(5,order_id);
			pstmt.setString(6,adr_no); //added for ML-BRU-SCF-1397 [IN:050181]
			pstmt.setString(7,getLanguageId());
			pstmt.setString(8,getLanguageId());
			pstmt.setString(9,getLanguageId());
			pstmt.setString(10,getLanguageId());
			pstmt.setString(11,getLanguageId());
			pstmt.setString(12,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				records.add(checkForNull(resultSet.getString("ORDER_CATALOG_CODE")));
				records.add(checkForNull(resultSet.getString("DRUG_DESC")));
				records.add(checkForNull(resultSet.getString("GENERIC_ID")));
				records.add(checkForNull(resultSet.getString("GENERIC_NAME")));
				records.add("");//STRENGTH_VALUE
				records.add("");//STRENGTH_UOM
				records.add("");//ROUTE_DESC
				records.add(checkForNull(resultSet.getString("FORM_DESC")));
				records.add("");//QTY_VALUE
				records.add("");//QTY_UNIT
				records.add("");//FREQ_CODE
				records.add("");//FREQ_DESC
				records.add("");//DURN_VALUE
				records.add("");//DURN_DESC
				records.add(checkForNull(resultSet.getString("START_DATE")));
				records.add(checkForNull(resultSet.getString("END_DATE")));
				records.add(checkForNull(resultSet.getString("TRADE_CODE")));
				records.add(checkForNull(resultSet.getString("ROUTE_COLOR")));// added for CRF RUT-CRF-0034.1[IN:037389] 
			}
		}
		catch(Exception e){
			e.printStackTrace();
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
	public ArrayList getAdrDrugs(String adr_no){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
	
		ArrayList	records		=	new ArrayList();
		ArrayList	recrds		=	null;
		try{
			connection			= getConnection() ;
			pstmt				= //connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ADRDRUG_CODES_SELECT")  );
			connection.prepareStatement("SELECT OTH_DRUG_CODE,ORDER_ID,ORDER_LINE_NUM FROM PR_ADV_DRUG_REACTION_DTL WHERE ADR_NO=? AND FACILITY_ID= ?");
			pstmt.setString(1,adr_no);
			pstmt.setString(2,login_facility_id);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				recrds		=	new ArrayList();
				recrds.add(resultSet.getString("OTH_DRUG_CODE"));
				recrds.add(resultSet.getString("ORDER_ID"));
				recrds.add(resultSet.getString("ORDER_LINE_NUM"));
				records.add(recrds);					
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

	public HashMap getAdrValues(String adr_no,String facility_id){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		PreparedStatement pstmt1 =	null ;
		ResultSet resultSet1		=	null ;
	
		String onsetDateTime = "";
		String onsetValue = "";
		String onsetType = "";
		String result = "";

		HashMap	adrValues	= new HashMap();

		try{
			connection			= getConnection() ;
			String sql="SELECT (RTRIM(rtrim(to_char(DOSAGE, '999999990.999999'),'0'),'.')) DOSAGE,BATCH_ID,MANUFACTURER,ADMIN_BY,TO_CHAR(EXPIRY_DATE,'DD/MM/YYYY') EXPIRY_DATE,SUPPLIER,TO_CHAR(ONSET_DATE_TIME,'DD/MM/YYYY HH24:MI') ONSET_DATE_TIME,DURN_TO_ONSET_REACTION,DURN_TO_ONSET_REACTION_TYPE,ADR_TYPE,EXTENT_OF_REACTION,DRUG_REACTION_RELATIONSHIP,REACTION_ON_STOP_OF_MEDN,REACTION_ON_REPETITION,ADDITIONAL_MEDN,OUTCOME,ADR_TREATMENT,RELEVANT_INVESTIGATION,RELEVANT_HISTORY,PREPARED_BY,TO_CHAR(PREPARED_DATE_TIME,'DD/MM/YYYY HH24:MI') PREPARED_DATE_TIME,ADR_DESCRIPTION,ETHNIC_GROUP,QA_DRUG_REACTION_RELATIONSHIP,ALLERGY_YN, A.ALLERGY_TYPE_CODE,C.LONG_DESC ALLERGY_TYPE_DESC, B.CERTAINITY_USER_DESC QA_DRUG_REACTION_RELNSHIP_DESC,ADV_EVENT_TYPE_IND, STATUS, REACTION_CERTAINITY,SOURCE_OF_INFO FROM PR_ADV_DRUG_REACTION A, PH_ADR_CERTAINITY_LANG_VW B, MR_ALLERGY_TYPE_LANG_VW C WHERE ADR_NO=? AND A.QA_DRUG_REACTION_RELATIONSHIP = B.CERTAINITY_CODE(+) AND B.LANGUAGE_ID(+) = ? AND A.ALLERGY_TYPE_CODE = C.ALLERGY_TYPE_CODE(+) AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID=?";
			//pstmt1				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ADRDRUG_HDR_SELECT")  );
			pstmt1				= connection.prepareStatement(sql );
			pstmt1.setString(1,adr_no);
			pstmt1.setString(2,getLanguageId());
			pstmt1.setString(3,getLanguageId());
			pstmt1.setString(4,facility_id);
			resultSet1	= pstmt1.executeQuery(); 
			while( resultSet1 != null && resultSet1.next() ) {
				adrValues.put("dosage",checkForNull(resultSet1.getString("DOSAGE")));
				adrValues.put("batch_id",checkForNull(resultSet1.getString("BATCH_ID")));
				adrValues.put("manufacturer",checkForNull(resultSet1.getString("MANUFACTURER")));
				adrValues.put("admin_by",checkForNull(resultSet1.getString("ADMIN_BY")));
				adrValues.put("expiry_date",checkForNull(resultSet1.getString("EXPIRY_DATE")));
				adrValues.put("supplier",checkForNull(resultSet1.getString("SUPPLIER")));
				adrValues.put("onset_date_time",checkForNull(resultSet1.getString("ONSET_DATE_TIME")));
				onsetDateTime = checkForNull(resultSet1.getString("ONSET_DATE_TIME"));
				adrValues.put("durn_to_onset_reaction",checkForNull(resultSet1.getString("DURN_TO_ONSET_REACTION")));
				onsetValue = checkForNull(resultSet1.getString("DURN_TO_ONSET_REACTION"));

				adrValues.put("durn_to_onset_reaction_type",checkForNull(resultSet1.getString("DURN_TO_ONSET_REACTION_TYPE")));
				onsetType = checkForNull(resultSet1.getString("DURN_TO_ONSET_REACTION_TYPE"));
				adrValues.put("adr_type",checkForNull(resultSet1.getString("ADR_TYPE")));
				adrValues.put("extent_of_reaction",checkForNull(resultSet1.getString("EXTENT_OF_REACTION")));
				adrValues.put("drug_reaction_relationship",checkForNull(resultSet1.getString("DRUG_REACTION_RELATIONSHIP")));
				adrValues.put("reaction_on_stop_of_medn",checkForNull(resultSet1.getString("REACTION_ON_STOP_OF_MEDN")));
				adrValues.put("reaction_on_repetition",checkForNull(resultSet1.getString("REACTION_ON_REPETITION")));
				adrValues.put("additional_medn",checkForNull(resultSet1.getString("ADDITIONAL_MEDN")));
				adrValues.put("outcome",checkForNull(resultSet1.getString("OUTCOME")));
				adrValues.put("adr_treatment",checkForNull(resultSet1.getString("ADR_TREATMENT")));
			
				adrValues.put("relevant_investigation",checkForNull(resultSet1.getString("RELEVANT_INVESTIGATION")));
				adrValues.put("relevant_history",checkForNull(resultSet1.getString("RELEVANT_HISTORY")));
				adrValues.put("prepared_by",checkForNull(resultSet1.getString("PREPARED_BY")));
				adrValues.put("prepared_date_time",checkForNull(resultSet1.getString("PREPARED_DATE_TIME")));
				adrValues.put("ADR_DESCRIPTION",checkForNull(resultSet1.getString("ADR_DESCRIPTION")));
				adrValues.put("ETHNIC_GROUP",checkForNull(resultSet1.getString("ETHNIC_GROUP")));
				adrValues.put("sys_id_rlsp_code",checkForNull(resultSet1.getString("QA_DRUG_REACTION_RELATIONSHIP")));
				adrValues.put("sys_id_rlsp_desc",checkForNull(resultSet1.getString("QA_DRUG_REACTION_RELNSHIP_DESC")));
				adrValues.put("allery_yn",checkForNull(resultSet1.getString("ALLERGY_YN")));
				adrValues.put("ALLERGY_TYPE_CODE",checkForNull(resultSet1.getString("ALLERGY_TYPE_CODE")));
				adrValues.put("ALLERGY_TYPE_DESC",checkForNull(resultSet1.getString("ALLERGY_TYPE_DESC")));
				adrValues.put("status_act",checkForNull(resultSet1.getString("STATUS")));
				adrValues.put("sourceOfInfo",checkForNull(resultSet1.getString("SOURCE_OF_INFO")));
				adrValues.put("certanity",checkForNull(resultSet1.getString("REACTION_CERTAINITY")));
				adrValues.put("hypersensitivity",checkForNull(resultSet1.getString("ADV_EVENT_TYPE_IND")));
				
				try{
					if(onsetType.equals("M"))
						pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ADR_SELECT14" )) ;
					else if(onsetType.equals("H"))
						pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ADR_SELECT15" )) ;
					else if(onsetType.equals("D"))
						pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ADR_SELECT16" )) ;
		
					pstmt.setString(1,onsetDateTime);
					pstmt.setString(2,onsetValue);
				
					resultSet      = pstmt.executeQuery() ;
						
					if(resultSet.next()){
						result=(String)resultSet.getString("ADMIN_DATE");
					}
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception e){
					e.printStackTrace() ;
				}
				adrValues.put("admin_date_time",checkForNull(result));
			}
		}
		catch(Exception e){
			e.printStackTrace() ;
			adrValues.put("error",e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return adrValues;	
	}

	public String getDiagnosis(String adr_no){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
	
		String diagnosis	= new String();

		try{
			connection			= getConnection() ;
			//pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ADRDRUG_HDR_SELECT1")  );
			pstmt				= connection.prepareStatement("SELECT DIAG_TXT FROM PR_ADV_DRUG_REACTION WHERE ADR_NO=? AND FACILITY_ID=? "  );
			pstmt.setString(1,adr_no);
			pstmt.setString(2,login_facility_id);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
					diagnosis = (checkForNull(resultSet.getString("DIAG_TXT")));
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
		return diagnosis;	
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

	public ArrayList LoadQuestionnaire(String b_mode,String b_adr_no,String b_verified_by){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date				= "";
		ArrayList loadquestionnaire	=new ArrayList();
		HashMap resvalues;
		try{
			connection				= getConnection() ;
			//String str_qry			= PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT5");
			//String str_qry=null;
			if(b_adr_no.equals("")){
				 //str_qry			= "SELECT QUESTION_CODE, QUESTION_DESC, YES_SCORE, NO_SCORE, NOT_KNOWN_SCORE, TO_CHAR(NULL) RESPONSE, SEQ_NO FROM PH_ADR_QUESTION_LANG_VW WHERE LANGUAGE_ID = 'en' ORDER BY SEQ_NO";
				 //pstmt.connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PR_ADV_DRUG_REACTION_QA_SELECT") );
				 pstmt=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PR_ADV_DRUG_REACTION_QA_SELECT"));
				 pstmt.setString(1,getLanguageId());
			}
			else{ 
				 //str_qry			= "SELECT QUESTION_CODE, QUESTION_DESC, YES_SCORE, NO_SCORE, NOT_KNOWN_SCORE, TO_CHAR(NULL) RESPONSE, SEQ_NO FROM PH_ADR_QUESTION_LANG_VW WHERE LANGUAGE_ID = 'en' AND QUESTION_CODE NOT IN (SELECT QUESTION_CODE FROM PR_ADV_DRUG_REACTION_QA WHERE ADR_NO = '"+b_adr_no+"') UNION ALL SELECT A.QUESTION_CODE, B.QUESTION_DESC, B.YES_SCORE, B.NO_SCORE, B.NOT_KNOWN_SCORE, A.RESPONSE, B.SEQ_NO FROM PH_ADR_QUESTION_LANG_VW B, PR_ADV_DRUG_REACTION_QA A WHERE a.ADR_NO = '"+b_adr_no+"' AND A.QUESTION_CODE = B.QUESTION_CODE AND B.LANGUAGE_ID = 'en' order by seq_no";
				//pstmt					= connection.prepareStatement(str_qry) ;
				//pstmt.connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PR_ADV_DRUG_REACTION_QA_SELECT1")  );
				//pstmt=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PR_ADV_DRUG_REACTION_QA_SELECT1"));
				pstmt=connection.prepareStatement("SELECT QUESTION_CODE, QUESTION_DESC, YES_SCORE, NO_SCORE, NOT_KNOWN_SCORE, TO_CHAR(NULL) RESPONSE, SEQ_NO FROM PH_ADR_QUESTION_LANG_VW WHERE LANGUAGE_ID = ? AND QUESTION_CODE NOT IN (SELECT QUESTION_CODE FROM PR_ADV_DRUG_REACTION_QA WHERE ADR_NO = ? AND FACILITY_ID=?) UNION ALL SELECT A.QUESTION_CODE, B.QUESTION_DESC, B.YES_SCORE, B.NO_SCORE, B.NOT_KNOWN_SCORE, A.RESPONSE, B.SEQ_NO FROM PH_ADR_QUESTION_LANG_VW B, PR_ADV_DRUG_REACTION_QA A WHERE a.ADR_NO = ? AND FACILITY_ID=? AND A.QUESTION_CODE = B.QUESTION_CODE AND B.LANGUAGE_ID = ? ORDER BY SEQ_NO");
				pstmt.setString(1,getLanguageId());
				pstmt.setString(2,b_adr_no);
				pstmt.setString(3,login_facility_id);
				pstmt.setString(4,b_adr_no);
				pstmt.setString(5,login_facility_id);
				pstmt.setString(6,getLanguageId());
			}
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null&&resultSet.next()){
				resvalues=new HashMap();
				resvalues.put("code",resultSet.getString("QUESTION_CODE"));
				resvalues.put("description",resultSet.getString("QUESTION_DESC"));
				resvalues.put("yscore",resultSet.getString("YES_SCORE"));
				resvalues.put("nscore",resultSet.getString("NO_SCORE"));
				resvalues.put("uscore",resultSet.getString("NOT_KNOWN_SCORE"));
				resvalues.put("response",resultSet.getString("RESPONSE"));
				loadquestionnaire.add(resvalues);
				resvalues=null;
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
		return loadquestionnaire;
	}

	public void updateQuestionnaire(String adrcode,String scorecode){
	   HashMap adrdata=(HashMap)questionnaire.get(Integer.parseInt(adrcode));   
	   if(scorecode.equals("1")){	 
			adrdata.put("response","Y");
	   }
	   else if(scorecode.equals("2")){
			adrdata.put("response","N");
	   }
	   else if(scorecode.equals("3")){
			adrdata.put("response","U");
	   }
		questionnaire.set(Integer.parseInt(adrcode),adrdata);
	}

	public String updateResscore(String qverifiedby){
		HashMap adrupdata=new HashMap();
		total_response_score=0;
		String		certainity_code	=null;
		for(int i=0;i<questionnaire.size();i++){
			adrupdata=(HashMap)questionnaire.get(i);
			if(adrupdata.get("response")!=null){
				total_num_responses++;
				if(adrupdata.get("response").equals("Y")){
					total_response_score=total_response_score+Integer.parseInt(adrupdata.get("yscore").toString());
				}
				else if(adrupdata.get("response").equals("N")){
					total_response_score=total_response_score+Integer.parseInt(adrupdata.get("nscore").toString());
				}
				else if(adrupdata.get("response").equals("U")){
					total_response_score=total_response_score+Integer.parseInt(adrupdata.get("uscore").toString());
				}
			}
		}
		if(total_num_responses >0){
			Connection connection       = null ;
			PreparedStatement pstmt     = null ;
			ResultSet resultSet         = null ;
		
			try{
				connection				= getConnection() ;
				//String str_qry			= PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT5");
				//String str_qry			= "select certainity_code from ph_adr_certainity where "+total_response_score+" between REL_SCORE_FROM and REL_SCORE_TO";
				//pstmt.connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PR_ADV_DRUG_REACTION_QA_SELECT2")  );
				pstmt=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PR_ADV_DRUG_REACTION_QA_SELECT2"));
				pstmt.setInt(1,total_response_score);
				pstmt.setString(2,getLanguageId());
				resultSet				= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					certainity_code=resultSet.getString("certainity_code");
					certainity_code=certainity_code+"~"+resultSet.getString("CERTAINITY_USER_DESC");
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
		return certainity_code;
	}

	public ArrayList certCodes(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date				= "";
		//questionnaire.clear();
		ArrayList certainityCodes	=new ArrayList();
		HashMap records				=null;
		try{
			connection				= getConnection() ;
			//String str_qry			= PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT5");
			//String str_qry			= "Select CERTAINITY_CODE,CERTAINITY_USER_DESC from PH_ADR_CERTAINITY_LANG_VW where language_id='en' order by certainity_code";
			pstmt=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PR_ADV_DRUG_REACTION_QA_SELECT3"));
			pstmt.setString(1,getLanguageId());
			resultSet				= pstmt.executeQuery();
			/*if(resultSet!=null && resultSet.next()){
					=resultSet.getString(1);
			}*/
			while(resultSet!=null&&resultSet.next()){
				records=new HashMap();
				records.put("code",resultSet.getString("CERTAINITY_CODE"));
				records.put("description",resultSet.getString("CERTAINITY_USER_DESC"));
				certainityCodes.add(records);
				records=null;
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
		return certainityCodes;
	}

	public void cancelQuestionnaire(){
		HashMap hmap=new HashMap();
		ArrayList qstlist=new ArrayList();
		qstlist=getQuestionnaire();
		for(int var=0;var<qstlist.size();var++){
			hmap=(HashMap)qstlist.get(var);
			hmap.put("response",null);
			qstlist.set(var,hmap);
		}
	}

	public ArrayList getEthnicNames(){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		
		try{
			connection	= getConnection() ;
			String sql="Select ethnic_group_code, short_desc from mp_ethnic_group_lang_vw where eff_status = 'E' and language_id = ? order by short_desc ";
			pstmt		= connection.prepareStatement(sql) ;
			pstmt.setString(1,getLanguageId());
			
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("ethnic_group_code"));
				records.add(resultSet.getString("short_desc"));
			}		
		}
		catch(Exception e){
			records.add(e.toString());
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

	public ArrayList checkToProceed(String login_user) {
		ArrayList result		= new ArrayList();
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
        try {
            connection = getConnection() ;
			//			To get the user name based on the login_id
			String sql="SELECT  A.APPL_USER_ID APPL_USER_ID, A.APPL_USER_NAME APPL_USER_NAME  FROM SM_APPL_USER_LANG_VW A, AM_PRACTITIONER_LANG_VW B WHERE A.FUNC_ROLE IS NOT NULL AND A.FUNC_ROLE = 'P' AND A.FUNC_ROLE_ID IS NOT NULL AND A.FUNC_ROLE_ID=B.PRACTITIONER_ID AND B.EFF_STATUS='E' AND A.EFF_STATUS='E' AND A.APPL_USER_ID LIKE UPPER(?) AND A.LANGUAGE_ID =? AND B.LANGUAGE_ID = A.LANGUAGE_ID ";

			//	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT31") ) ;
			pstmt = connection.prepareStatement(sql) ;
	
			pstmt.setString(1,login_user.trim());
			pstmt.setString(2,getLanguageId());
		    resultSet = pstmt.executeQuery() ;
	        if ( resultSet.next() ) {
				result.add(resultSet.getString("APPL_USER_ID"));
				result.add(resultSet.getString("APPL_USER_NAME"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return result;
	}

	public int getNoOfDecimals(){
		Connection oConnection		    = null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		int  iNoOfDecimals              = 0; 
		
		try {
			oConnection	= getConnection() ;
			oStatement	= oConnection.createStatement();
			oResultSet	= oStatement.executeQuery(" select NO_OF_DECIMALS from st_acc_entity_param");
			if(oResultSet!=null && oResultSet.next()){
				iNoOfDecimals = oResultSet.getString("NO_OF_DECIMALS")==null?0:Integer.parseInt(oResultSet.getString("NO_OF_DECIMALS"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ){
				e.printStackTrace() ;
			}
		}
		return iNoOfDecimals;
	}
	
	public ArrayList loadReasons(String app_trn_type) { //code added for HSA-CRF-0005[40601] -- Start
		ArrayList result		= new ArrayList();
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		hmAdrReasons = new HashMap();
			
        try {
            connection = getConnection() ;				
			pstmt = connection.prepareStatement("SELECT REASON_CODE,REASON_DESC,REMARKS FROM PH_MEDN_TRN_REASON WHERE EFF_STATUS='E' AND APPL_TRN_TYPE = ? ") ;	
			pstmt.setString(1,app_trn_type);	
			
		    resultSet = pstmt.executeQuery() ;
	        while( resultSet.next() ) {
				result.add(resultSet.getString("REASON_CODE"));
				result.add(resultSet.getString("REASON_DESC"));
				hmAdrReasons.put(resultSet.getString("REASON_CODE"),resultSet.getString("REMARKS"));				
			}
		}
		catch ( Exception e ) {			
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}		
		return result;
	} //code added for HSA-CRF-0005[40601] -- End 
}
