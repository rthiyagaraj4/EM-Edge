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
28/10/2020                  IN:074177            B Haribabu                                                  GHL-ICN-0079
13/05/2021  				TFS id:-16701	     Manickavasagam J                               		     RBU-GHL-CRF-0004 
--------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package ePH ;
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.ExternalProductLink.*;

public class ExternalProductLinkBean extends PhAdapter implements Serializable {
	private String finalgeneric="";
	private HashMap exProduct=new HashMap();
	private ArrayList<String> allergyDrugList  = null;
	private ArrayList<String> healthInteractionDrugList  = null;
	private String externalDB = "";
	CIMSExternalDataBaseBean CIMSBean;
	FDBExternalDataBaseBean FDBBean;
	private String extDrugDBOverrideReason ="";
	private HashMap dataExists = new HashMap(); // Added for HSA-ICN-0010
	
	HashMap drugProduct=null; //used for interactions
	ArrayList drug_list =new ArrayList();
	ArrayList doseCheckParams =null;
	HashMap doseCheckParamsHash = new HashMap(); //Added in January 2014 for CIMS Dosage

	HashMap drugInfos =  new HashMap();
	ArrayList alergyDrugCodes = null;
	HashMap DDInteractions=null;
	String duplicateResult = null;
	HashMap dosageCheck  =new HashMap();;
	HashMap DrugAlergies  = null;
	HashMap contraIndications  = null;
	HashMap externalDBCheckResult = null;
	HashMap extDBCheckResultALL = new HashMap();
	StringBuffer sbf_data = new StringBuffer(); // Added in June 2012
	String dosageCheckYN="", dupTheraphyCheckYN="",drugInteracCheckYN="",drugContraIndCheckYN="",drugAllergyCheckYN=""; //declared as global for SKR-SCF-0613.1,SKR-SCF-0617.1, SKR-SCF-0669

	private String disp_before_start_date_yn="";//Added for COMMON-ICN-0120 [40745]
	private String disp_before_no_of_days="";//Added for COMMON-ICN-0120 [40745]
	private String disp_beyond_earliest_start_yn="";//Added for COMMON-ICN-0120 [40745]
	private String disp_beyond_no_of_days="";//Added for COMMON-ICN-0120 [40745]
	public String getDisp_before_start_date_yn() {
		return disp_before_start_date_yn;
	}
	public void setDisp_before_start_date_yn(String disp_before_start_date_yn) {
		this.disp_before_start_date_yn = disp_before_start_date_yn;
	}
	public String getDisp_before_no_of_days() {
		return disp_before_no_of_days;
	}
	public void setDisp_before_no_of_days(String disp_before_no_of_days) {
		this.disp_before_no_of_days = disp_before_no_of_days;
	}
	public String getDisp_beyond_earliest_start_yn() {
		return disp_beyond_earliest_start_yn;
	}
	public void setDisp_beyond_earliest_start_yn(String disp_beyond_earliest_start_yn) {
		this.disp_beyond_earliest_start_yn = disp_beyond_earliest_start_yn;
	}
	public String getDisp_beyond_no_of_days() {
		return disp_beyond_no_of_days;
	}
	public void setDisp_beyond_no_of_days(String disp_beyond_no_of_days) {
		this.disp_beyond_no_of_days = disp_beyond_no_of_days;
	}
	private Hashtable recordSet		= new Hashtable();

	public ExternalProductLinkBean() {
		//Constructor
		try {
			doCommon() ;
		}
		catch(Exception e) {e.printStackTrace();}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
		externalDB = "";
		dataExists = new HashMap(); // Added for HSA-ICN-0010
		doseCheckParamsHash=new HashMap();//Added for IN:074177
		doseCheckParams=new ArrayList();//Added for IN:074177
	}

	/* Over-ridden Adapter methods endS here */
	public void setInteractions(HashMap tmp){
		this.DDInteractions=tmp;
	}

	public HashMap getInteractions(){
		return this.DDInteractions;
	}

	public void setDoseCheckParams(ArrayList doseCheckParams){
		this.doseCheckParams=doseCheckParams;
	}

	public ArrayList getDoseCheckParams(){
		return this.doseCheckParams;
	}

	public void setDoseCheckParamsHash(ArrayList doseCheckParams, String extProdId){
		this.doseCheckParamsHash.put(extProdId, doseCheckParams);
	}

	public HashMap getDoseCheckParamsHash(){
		return this.doseCheckParamsHash;
	}

	public HashMap getContraIndications(){
		return this.contraIndications;
	}

	public HashMap getDrugAlergies(){
		return this.DrugAlergies;
	}
	public void setExtDrugDBOverrideReason(String overrideReason){
		this.extDrugDBOverrideReason = overrideReason;
	}

	public String getExtDrugDBOverrideReason(){
		return this.extDrugDBOverrideReason;
	}

	public HashMap getDosageCheck(String prod_id, String srlNo){
		String prodID = prod_id+srlNo;

		if(dosageCheck.containsKey(prodID))
			return (HashMap)this.dosageCheck.get(prodID);
		else
			return null;
	}

	public void setDosageCheck(String prod_id, String srlNo, HashMap dosageCheckMsgs){
		String prodID = prod_id+srlNo;
		this.dosageCheck.put(prodID, dosageCheckMsgs);
		HashMap drugResults = null;
		if(extDBCheckResultALL!=null && extDBCheckResultALL.containsKey(prodID)){
			drugResults = (HashMap)extDBCheckResultALL.get(prodID);
			drugResults.put("DOSECHECK", dosageCheckMsgs);
			extDBCheckResultALL.put(prodID, drugResults);
		}
		else{
			if(extDBCheckResultALL==null)
				extDBCheckResultALL = new HashMap();
			if(!extDBCheckResultALL.containsKey(prodID)){
				drugResults = new HashMap();
				drugResults.put("DOSECHECK", dosageCheckMsgs);
				extDBCheckResultALL.put(prodID, drugResults);
			}
		}
	}
	public void removeDosageCheck(String prod_id, String srlNo){
		String prodID = prod_id+srlNo;
		this.dosageCheck.remove(prodID);
		if(extDBCheckResultALL!=null && extDBCheckResultALL.containsKey(prodID)){
			HashMap drugResults = (HashMap)extDBCheckResultALL.get(prodID);
			drugResults.remove("DOSECHECK");
			extDBCheckResultALL.put(prodID, drugResults);
		}
	}

	public void removeSelectedDrugonAmend(String extDrugId){
		int i=0;
		for(i=0;i<drug_list.size();i++){
			if(drug_list.get(i).equals(extDrugId)) {
				drug_list.remove(i);
				break;
			}
		}
		if(!drug_list.contains(extDrugId))
			drugProduct.remove(extDrugId);
	}

	public void storeDrugIds(String patientid, String orderid,ArrayList exProd,ArrayList drugDesc, ArrayList doseCheckParams, String startdate, String enddate, String dupTheraphyCheckYN, String extDrugId){
		System.err.println("=========== ML-MMOH-SCF-0684 entered into storeDrugIds patientid--=========="+patientid+"orderid==="+orderid+"extDrugId==="+extDrugId+"login_by_id=="+login_by_id+"login_at_ws_no==="+login_at_ws_no+"=====System.currentTimeMillis()===>"+System.currentTimeMillis());
		// This is to be used before calling the getDDinteractions method. This method sets the drug list after retrieving from medicom tables
		//drugProductList is populated here
		//first clear the already existing hashmap
		drugProduct     = new HashMap();
		drug_list       = new ArrayList();
		allergyDrugList = new ArrayList();
		healthInteractionDrugList = new ArrayList();/* Added in JUNE 2012 - New changes - Health Care Interaction */
	//	HashMap doseCheckParamsHashInternal = new HashMap(); // Added in January 2014 for CIMS - Dosage Checks  Removed for IN063877
	//	ArrayList checkDosageList = new ArrayList();  // Added in January 2014 for CIMS - Dosage Checks  Removed for IN063877

		if(doseCheckParams !=null && doseCheckParams.size()>0)
			setDoseCheckParamValues(doseCheckParams);
		Connection connection=null;
		ResultSet rs=null;
		PreparedStatement pstmt =null;
		try{
			connection = getConnection() ;
			setDispBeyondBeforeValues();//Added for COMMON-ICN-0120 [40745]
			if (exProd.size()==0){
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_EXT_PROD_LINK_SELECT10" )) ;//Performance - Patient ID to be passed
				pstmt = connection.prepareStatement( "SELECT   c.drug_Desc, ph_get_ext_prod_drug_code(c.drug_code,?)EXTERNAL_PRODUCT_ID FROM    PH_PATIENT_DRUG_PROFILE A ,   PH_DRUG C WHERE    A.PATIENT_ID =? AND   A.DRUG_CODE = C.DRUG_CODE AND (TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  A.START_DATE AND  A.END_DATE OR TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  A.START_DATE AND  A.END_DATE OR  A.START_DATE BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND  TO_DATE(?,'DD/MM/YYYY HH24:MI') OR  A.END_DATE BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND  TO_DATE(?,'DD/MM/YYYY HH24:MI'))  AND   A.DISCONT_DATE_TIME IS NULL AND   A.ON_HOLD_DATE_TIME IS NULL AND   A.CANCEL_YN='N' AND   A.STOP_YN='N'  and  ph_get_ext_prod_drug_code(c.drug_code,?) is not null union SELECT b.drug_desc, ph_get_ext_prod_drug_code(b.drug_code,?) external_product_id  FROM OR_ORDER_LINE A, PH_DRUG B, OR_ORDER_LINE_PH G, OR_ORDER H,PH_DISP_DTL_TMP I   WHERE A.ORDER_ID = H.ORDER_ID AND A.ORDER_ID= G.ORDER_ID AND   A.ORDER_LINE_NUM=G.ORDER_LINE_NUM  AND    A.ORDER_CATALOG_CODE=B.DRUG_CODE   AND   A.ORDER_LINE_NUM=I.ORDER_LINE_NO(+) AND   A.ORDER_ID=I.ORDER_ID(+) AND   Ph_Check_Ord_Date_Dispensing(A.START_DATE_TIME,A.END_DATE_TIME,?,?,?,?,?)=1   AND  A.ORDER_TYPE_CODE IN (SELECT ORDER_TYPE_CODE FROM PH_ORDER_TYPE_FOR_DRUG_CLASS  WHERE   DRUG_CLASS = 'G'  OR DRUG_CLASS = 'N'  OR DRUG_CLASS = 'C'  )   AND A.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE  WHERE  ORDER_STATUS_TYPE IN ('10','30','56','36')) AND H.patient_id= ? AND A.ORDER_ID=NVL(?,A.ORDER_ID) and ph_get_ext_prod_drug_code(b.drug_code,?) is not null") ;//Performance - Patient ID to be passed , next time this need to be synchronized and put in repository//Modify PH_CHECK_ORD_DATE_DISPENSING for COMMON-ICN-0120 [40745]
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,patientid);
				pstmt.setString(3,startdate);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(4,enddate);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(5,startdate);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(6,enddate);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(7,startdate);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(8,enddate);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(9,login_facility_id); //added for SRR20056-SCF-7635 IN027714
				pstmt.setString(10,login_facility_id); //added for SRR20056-SCF-7635 IN027714
				pstmt.setString(11,login_facility_id);
				pstmt.setString(12,getDisp_before_start_date_yn());//Added for COMMON-ICN-0120 [40745]
				pstmt.setString(13,getDisp_before_no_of_days());//Added for COMMON-ICN-0120 [40745]
				pstmt.setString(14,getDisp_beyond_earliest_start_yn());//Added for COMMON-ICN-0120 [40745]
				pstmt.setString(15,getDisp_beyond_no_of_days());//Added for COMMON-ICN-0120 [40745]
				pstmt.setString(16,patientid); //added for Performance-Patient
				pstmt.setString(17,orderid);
				pstmt.setString(18,login_facility_id);
				rs=pstmt.executeQuery();
				//First execute the current rx query and retrieve the external_product_ids
				while (rs.next()){
					if(externalDB.equals("CIMS")){
						drugProduct.put(rs.getString("EXTERNAL_PRODUCT_ID").substring(rs.getString("EXTERNAL_PRODUCT_ID").indexOf("::")+2, rs.getString("EXTERNAL_PRODUCT_ID").length()),rs.getString("DRUG_DESC"));
					}
					else{
						drugProduct.put(rs.getString("EXTERNAL_PRODUCT_ID"),rs.getString("DRUG_DESC"));
					}
					drug_list.add(rs.getString("EXTERNAL_PRODUCT_ID"));
				}
			}
			else{
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_EXT_PROD_LINK_SELECT11" )) ; // Added start & end date in query
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,patientid);
				pstmt.setString(3,startdate);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(4,enddate);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(5,startdate);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(6,enddate);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(7,startdate);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(8,enddate);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(9,login_facility_id);
				rs=pstmt.executeQuery();
						//First execute the current rx query and retrieve the external_product_ids
				while (rs.next()){
					if(externalDB.equals("CIMS")){					       
						drugProduct.put(rs.getString("EXTERNAL_PRODUCT_ID").substring(rs.getString("EXTERNAL_PRODUCT_ID").indexOf("::")+2, rs.getString("EXTERNAL_PRODUCT_ID").length()),rs.getString("DRUG_DESC"));
					}
					else{
						drugProduct.put(rs.getString("EXTERNAL_PRODUCT_ID"),rs.getString("DRUG_DESC"));
					}
					drug_list.add(rs.getString("EXTERNAL_PRODUCT_ID"));
				}

				for (int i=0;i<exProd.size();i++ ){
					if(externalDB.equals("CIMS")){
						drugProduct.put(((String)exProd.get(i)).substring(((String)exProd.get(i)).indexOf("::")+2, ((String)exProd.get(i)).length()),(String)drugDesc.get(i));
					}
					else{
						drugProduct.put((String)exProd.get(i),(String)drugDesc.get(i));
					}
					drug_list.add((String)exProd.get(i));
				}
			}
			if(externalDB.equals("CIMS")){
				// Added in January 2014 for CIMS Dosage
				/*for (int i=0;i<drug_list.size();i++ ){
						doseCheckParamsHashInternal =  getDoseCheckParamsHash();
						if(doseCheckParamsHashInternal!=null && doseCheckParamsHashInternal.size()>0) {
							if(doseCheckParamsHashInternal.containsKey((((String)drug_list.get(i)).substring(((String)drug_list.get(i)).indexOf("::")+2, ((String)drug_list.get(i)).length())))){
								checkDosageList = (ArrayList)doseCheckParamsHashInternal.get((((String)drug_list.get(i)).substring(((String)drug_list.get(i)).indexOf("::")+2, ((String)drug_list.get(i)).length())) );
							}
						}
						setDoseCheckParamsHash(getDoseCheckParams(), ((String)drug_list.get(i)).substring(((String)drug_list.get(i)).indexOf("::")+2, ((String)drug_list.get(i)).length()));
				}*/// Till here - added in January 2014 for CIMS Dosage
				setDoseCheckParamsHash(getDoseCheckParams(), extDrugId.substring(extDrugId.indexOf("::")+2, extDrugId.length()));
System.err.println("before calling CIMS close result==="+patientid+"login_by_id=="+login_by_id+"login_at_ws_no==="+login_at_ws_no+"exProd=="+exProd+"drug_list=="+drug_list+"doseCheckParamsHash==="+doseCheckParamsHash+"==extDrugId=====>"+extDrugId);
				//CIMSBean.generatePresRequest(exProd,drug_list);
				CIMSBean.generatePresRequest(exProd,drug_list,doseCheckParamsHash);
				CIMSBean.generateCompleteRequest(dupTheraphyCheckYN); /* Added in JUNE 2012 - to complete the request - prescribing */
				/* Added in JUNE 2012 - New changes - Health Care Interaction */
				if(drugContraIndCheckYN !=null && drugContraIndCheckYN.equals("Y")){  //if condition added for SKR-SCF-0613.1,SKR-SCF-0617.1, SKR-SCF-0669					
				
				 if(dataExists!=null && dataExists.containsKey(patientid+"@HI")){ // if else Added for HSA-ICN-0010 - Start
					 healthInteractionDrugList = (ArrayList)dataExists.get(patientid+"@HI"); 
				 }
				 else{
					healthInteractionDrugList = getHealthInteractionDrugList(patientid);
					dataExists.put(patientid+"@HI", healthInteractionDrugList); // Added for 
				 } // if else Added for HSA-ICN-0010 - End
					if(healthInteractionDrugList!=null)
						CIMSBean.generateDrugHealthRequest(healthInteractionDrugList); /* Added in JUNE 2012 - New changes - Health Care Interaction */
				}
				//System.err.println("== ML-MMOH-SCF-0684 drugAllergyCheckYN"+drugAllergyCheckYN);
				if(drugAllergyCheckYN !=null && drugAllergyCheckYN.equals("Y")) {
					
				if(dataExists!=null && dataExists.containsKey(patientid+"@AD")){ // if else Added for HSA-ICN-0010 - Start
						 allergyDrugList = (ArrayList)dataExists.get(patientid+"@AD");
				}
				else{
						 allergyDrugList = CIMSBean.getAllergyDrugList(patientid);
						 dataExists.put(patientid+"@AD", allergyDrugList); 
				} // if else Added for HSA-ICN-0010 - End
					 
					CIMSBean.generateAllergyRequest(allergyDrugList);
				}
				//CIMSBean.loadCIMSDetails();
				CIMSBean.closeRequest();  /* Added in JUNE 2012 - to complete the request - prescribing */
				//System.err.println("patientidafter close result==="+patientid+"login_by_id=="+login_by_id+"login_at_ws_no==="+login_at_ws_no);
	  			StringBuffer sbf = CIMSBean.loadCIMSDetails(patientid,login_by_id,login_at_ws_no);  // required later to parse, added in June 2012//arguments added for 7295
			//	System.err.println("sbf@@@@@==="+sbf);
				if(sbf !=null && !sbf.equals("") && sbf.length()>0 ){
				   setStoreResult(sbf);  // required later to parse, added in June 2012
				}
				//System.err.println("aftersetstoreresult close result==="+patientid+"login_by_id=="+login_by_id+"login_at_ws_no==="+login_at_ws_no);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {   
			}
		}
System.err.println("========== ML-MMOH-SCF-0684 FDB STOREIDS Ends=== ====drug_list="+drug_list+"patientid==="+patientid+"login_by_id=="+login_by_id+"login_at_ws_no==="+login_at_ws_no+"==extDrugId====>"+extDrugId+"=====System.currentTimeMillis()===>"+System.currentTimeMillis());
	}

	// Added in June 2012
	public void setStoreResult(StringBuffer sbf) {
		//this.sbf_data=new StringBuffer();   //Added in June 2012
		if(this.sbf_data !=null)
			this.sbf_data.delete(0, (this.sbf_data).length());
		this.sbf_data= sbf;			//Added in June 2012
	}

	public StringBuffer getStoreResult(){
		return this.sbf_data;
	}

	// //Added in June 2012  - till here 
	public HashMap getExternalDBChecks(ArrayList reqChecks, String extDrugId, String patientid, String orderid,ArrayList exProdIds,ArrayList drugDesc, ArrayList doseCheckParams, String StoreIds, String startdate, String enddate)throws Exception, Exception{// Added startdate,enddate for ML-BRU-SCF-0811 [IN:039394]
	//	boolean checkResult = false;  Removed for IN063877
		HashMap doseCheckResult=null;
		externalDBCheckResult = new HashMap();
		dosageCheckYN="";
		dupTheraphyCheckYN="";
		drugInteracCheckYN="";
		drugContraIndCheckYN="";
		drugAllergyCheckYN="";
		getProdID();
		if(reqChecks!=null && reqChecks.size()>0){
			dosageCheckYN = (String)reqChecks.get(0);
			dupTheraphyCheckYN = (String)reqChecks.get(1);
			drugInteracCheckYN = (String)reqChecks.get(2);
			drugContraIndCheckYN = (String)reqChecks.get(3);
			drugAllergyCheckYN = (String)reqChecks.get(4);
		}
		//if(drugAllergyCheckYN!=null && drugAllergyCheckYN.equals("Y")) 
		if(drugAllergyCheckYN!=null && drugAllergyCheckYN.equals("Y")  && externalDB!=null && !externalDB.equals("CIMS"))  //HSA-ICN-0010
			setAllergyDrugCodes(patientid);
		try{
			if(externalDB.equals("CIMS"))
				CIMSBean        = new CIMSExternalDataBaseBean();
			else if(externalDB.equals("FDB"))
				FDBBean			= new FDBExternalDataBaseBean();
//System.err.println("ML-MMOH-SCF-0684 StoreIds===="+StoreIds+"patientid==="+patientid+"login_by_id=="+login_by_id+"login_at_ws_no==="+login_at_ws_no);
			if(StoreIds==null || StoreIds.equals("Y")){
				//System.err.println(" ML-MMOH-SCF-0684 patientid while calling storeDrugIds==== "+patientid+"orderid==="+orderid+"exProdIds==="+exProdIds+"drugDesc==="+drugDesc+"doseCheckParams==="+doseCheckParams+"startdate==="+startdate+"enddate==="+enddate+"dupTheraphyCheckYN==="+dupTheraphyCheckYN+"extDrugId===="+extDrugId+"login_by_id=="+login_by_id+"login_at_ws_no==="+login_at_ws_no);
				storeDrugIds(patientid, orderid, exProdIds, drugDesc, doseCheckParams,startdate,enddate, dupTheraphyCheckYN, extDrugId);
			}else if (doseCheckParams!=null && doseCheckParams.size()>0){
				//System.err.println("ML-MMOH-SCF-0684 whilecalling setDoseCheckParamValues====="+doseCheckParams+"patientid=="+patientid+"login_by_id=="+login_by_id+"login_at_ws_no==="+login_at_ws_no);
				setDoseCheckParamValues(doseCheckParams);
			}

			if(externalDB.equals("FDB")){
				if(dosageCheckYN !=null && dosageCheckYN.equals("Y")){
					doseCheckResult = FDBBean.getDosageCheckResult(getDoseCheckParams());
					if(doseCheckResult!=null)
						externalDBCheckResult.put("DOSECHECK",doseCheckResult);
				}
				if(dupTheraphyCheckYN !=null && dupTheraphyCheckYN.equals("Y")){
					duplicateResult =(String) FDBBean.getDuplicateTherapyResult(this.drug_list, extDrugId);
					if(duplicateResult!=null)
						externalDBCheckResult.put("DUPCHECK",duplicateResult);
				}
				if(drugInteracCheckYN !=null && drugInteracCheckYN.equals("Y")){
					DDInteractions = (HashMap) FDBBean.getDDInteractionsResult(extDrugId, drugProduct);
					if(DDInteractions!=null)
						externalDBCheckResult.put("INTRACHECK",DDInteractions);
				}
				if(drugContraIndCheckYN !=null && drugContraIndCheckYN.equals("Y")){
					ArrayList icd9code = getEqvTermCodes(patientid);
					if(icd9code!=null && icd9code.size()>0){
						contraIndications = (HashMap) FDBBean.getContraIndCheckResult(extDrugId, icd9code);
					if(contraIndications!=null)
						externalDBCheckResult.put("CONTRACHECK",contraIndications);
					}
				}
				 if(drugAllergyCheckYN !=null && drugAllergyCheckYN.equals("Y")){
					 if(this.alergyDrugCodes!=null && this.alergyDrugCodes.size()>0){
						if(DrugAlergies==null || DrugAlergies.size()==0)
							DrugAlergies = (HashMap)FDBBean.getDrugAlergyCheckResult(exProdIds, this.alergyDrugCodes);
						if(DrugAlergies!=null)
							externalDBCheckResult.put("ALLERGYCHECK",DrugAlergies);
					 }
				}
			}
			else if(externalDB.equals("CIMS")){
				/*if(dosageCheckYN !=null && dosageCheckYN.equals("Y")){
				}*/
				String ext_prod_id_without_delim = "";
				StringBuffer dup_drug_det_sbf_result = null;
				//HashMap drugProduct = new HashMap(); //commented for common-icn-0048
				//Added in January 2014 - CIMS Dosage  Checks
				StringBuffer dosage_drug_det_sbf_result = getStoreResult();//;(StringBuffer)getWithoutDosageWarningXML(getStoreResult(), ext_prod_id_without_delim);
				dup_drug_det_sbf_result=dosage_drug_det_sbf_result;   //IN066787- Performance

//System.err.println("--dup_drug_det_sbf_result=>"+dup_drug_det_sbf_result+"--Length--"+dup_drug_det_sbf_result.length()+"dosage_drug_det_sbf_result==="+dosage_drug_det_sbf_result);

				//if(dup_drug_det_sbf_result!=null && !dup_drug_det_sbf_result.equals("null") && !dup_drug_det_sbf_result.equals("")) {
			if(dosage_drug_det_sbf_result != null && !dosage_drug_det_sbf_result.equals("") && dosage_drug_det_sbf_result.length()>0){// added for MIMS -- May 2018
//System.err.println("dup_drug_det_sbf_result@@@ in side null==="+dup_drug_det_sbf_result);
					if( (dupTheraphyCheckYN !=null && dupTheraphyCheckYN.equals("Y")) || (drugInteracCheckYN !=null && drugInteracCheckYN.equals("Y")) || (drugAllergyCheckYN !=null && drugAllergyCheckYN.equals("Y")) || (drugContraIndCheckYN!=null && drugContraIndCheckYN.equals("Y"))){    //uncomment for NEW Added MIMS Coding 2018
				 	/* Added in JUNE 2012 - New changes - Health Care Interaction */
					duplicateResult = "";
//System.err.println("ML-MMOH-SCF-0684  External Bean - duplicateResult"+duplicateResult+"==getStoreResult()"+getStoreResult()+"patientid==="+patientid+"login_by_id=="+login_by_id+"login_at_ws_no==="+login_at_ws_no);												 
					if(extDrugId.indexOf("::")!=-1)
						ext_prod_id_without_delim = extDrugId.substring(extDrugId.indexOf("::")+2);
					else
					    ext_prod_id_without_delim  = extDrugId;
//System.err.println("ML-MMOH-SCF-0684  External Bean - ext_prod_id_without_delim"+ext_prod_id_without_delim);
					 //dup_drug_det_sbf_result = (StringBuffer)getContentXML(getStoreResult(), ext_prod_id_without_delim, drugProduct);
 					 //dup_drug_det_sbf_result = (StringBuffer)getContentXML(dosage_drug_det_sbf_result, ext_prod_id_without_delim, drugProduct);

//System.err.println("-- External ext_prod_id_without_delim====="+ext_prod_id_without_delim);

					 if( (dupTheraphyCheckYN !=null && dupTheraphyCheckYN.equals("Y")) || (drugInteracCheckYN !=null && drugInteracCheckYN.equals("Y")) ||  (drugContraIndCheckYN!=null && drugContraIndCheckYN.equals("Y"))) {  //added for speed up , not to call when only allergy is set - 16092019

						HashMap alert_reqd = (HashMap)getInteractionCheck(dup_drug_det_sbf_result, ext_prod_id_without_delim, reqChecks);//passed reqchecks for condition based to speed up - 16092019
						if(alert_reqd!=null && alert_reqd.size()>0) {
							if((Boolean)alert_reqd.get("DUPCHECK"))
								externalDBCheckResult.put("DUPCHECK","DUPLICATE CHECK");	 // return is hashmap, so to identify
							if((Boolean)alert_reqd.get("INTRACHECK"))
								externalDBCheckResult.put("INTRACHECK",alert_reqd);	 // return is hashmap, so to identify
							if((Boolean)alert_reqd.get("HEALTHINTRACHECK"))                         //drugContraIndCheckYN   //IN066787- Performance
								externalDBCheckResult.put("HEALTHINTRACHECK",alert_reqd);	 // return is hashmap, so to identify   //IN066787- Performance
	///System.err.println("------Externalproduct"+externalDBCheckResult);
						}
					}  //added for speed up , not to call when only allergy is set - 16092019
					// Added till here - June 2012
					/* Added in JUNE 2012 - New changes - Health Care Interaction -- Till here*/
				}
			/*	if(drugInteracCheckYN !=null && drugInteracCheckYN.equals("Y")){
//System.err.println("==========drugInteracCheckYN");
					ArrayList<String> alInterMsg		= CIMSBean.getInteractionMessage();
					HashMap finalresult=new HashMap();
					ArrayList<String> alInterDrugList	= CIMSBean.getInterDrugList();
					ArrayList<String> alInterMsgTemp	= new ArrayList<String>();
					for(int i=0,j=0;i<alInterMsg.size();i++,j++){
						alInterMsgTemp = new ArrayList<String>();
						alInterMsgTemp.add(alInterMsg.get(i));
System.err.println("drugProduct .. SUHAIL..."+drugProduct);
						finalresult.put((String)drugProduct.get(alInterDrugList.get(j))+"&nbsp  ------- &nbsp;"+(String)drugProduct.get(alInterDrugList.get(++j)),alInterMsgTemp);	
					}
//System.err.println("==========finalresult"+finalresult);
					setInteractions(finalresult);
					externalDBCheckResult.put("INTRACHECK",getInteractions());
				}*/
				//if(drugContraIndCheckYN !=null && drugContraIndCheckYN.equals("Y")){

//System.err.println("==CIMSBean.getHealthInteractionMessage()"+CIMSBean.getHealthInteractionMessage());
					/* Added in JUNE 2012 - New changes - Health Care Interaction */
				//	if(CIMSBean.getHealthInteractionMessage()!=null) //IN066787- Performance
				//		externalDBCheckResult.put("HEALTHINTRACHECK",CIMSBean.getHealthInteractionMessage()); //IN066787- Performance
					 /* Added in JUNE 2012 - New changes - Health Care Interaction */ 
				//}
				if(drugAllergyCheckYN !=null && drugAllergyCheckYN.equals("Y")){
					/*ArrayList drugs = new ArrayList();
					drugs.add(extDrugId);
					DrugAlergies = (HashMap)CIMSBean.getAllergyMessage(drugs);
					if(DrugAlergies!=null)
						externalDBCheckResult.put("ALLERGYCHECK",DrugAlergies);*/
					// Added in June 2012
					HashMap allergy_alert_reqd = (HashMap)getAllergyCheck(dup_drug_det_sbf_result, ext_prod_id_without_delim);
					if(allergy_alert_reqd!=null && allergy_alert_reqd.size()>0) {
						if((Boolean)allergy_alert_reqd.get("ALLERGYCHECK"))
							externalDBCheckResult.put("ALLERGYCHECK","ALLERGY CHECK");	 // return is hashmap, so to identify
					}
				}
				 //if(dosageCheckYN !=null && dosageCheckYN.equals("Y")){
					 //january 2014...once MIMS send the proper details (after their development), it needs to be checked here and set it  for the symbol to appear if dosage is available
				//}  
				}
			}
//System.err.println("==========At LAST");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//extDBCheckResultALL.put(extDrugId, externalDBCheckResult);
System.err.println("==========ML-MMOH-SCF-0684 FDB Resut ====patientid==="+patientid+"login_by_id=="+login_by_id+"login_at_ws_no==="+login_at_ws_no);
		return externalDBCheckResult;
	}

	/* Added in JUNE 2012 - New changes - Health Care Interaction  - CIMS */
	public ArrayList<String> getHealthInteractionDrugList(String patient_id){
		ArrayList<String> icd10code = new ArrayList<String>();

		try{
			Connection connection	= null ;
			PreparedStatement pstmt = null ;
			ResultSet resultSet		= null ;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement("SELECT TERM_CODE FROM pr_diagnosis WHERE patient_id= ?  AND CURR_STATUS='A'  AND   TERM_SET_ID='ICD10'") ;
				pstmt.setString(1,patient_id);
				resultSet = pstmt.executeQuery() ;
				while(resultSet.next()) { 
					 icd10code.add(resultSet.getString("TERM_CODE"));
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
					es.printStackTrace() ;
				}
			}
		}
		catch(Exception exp){
			exp.printStackTrace();
		}
		return icd10code;
	}

	// added in January  - 2014 - CIMS Dosage
	public StringBuffer getWithoutDosageWarningXML(StringBuffer xmlData, String exp_prodid){
		StringBuffer sbXmlData = CIMSBean.getWithoutDosageWarningXML(xmlData, exp_prodid); 
		return sbXmlData;
	}

	// added in June - 2012
	public StringBuffer getContentXML(StringBuffer xmlData, String exp_prodid, HashMap drugProduct){
		StringBuffer sbXmlData = CIMSBean.getContentXML(xmlData, exp_prodid, drugProduct); 
		return sbXmlData;
	}

	public HashMap getInteractionCheck(StringBuffer dup_drug_det_sbf_result, String exp_prodid, ArrayList reqChecks) { //passed reqchecks for condition based to speed up - 16092019
		HashMap alert_reqd = CIMSBean.getInteraction(dup_drug_det_sbf_result, exp_prodid, reqChecks);  //passed reqchecks for condition based to speed up - 16092019
	   return alert_reqd;
	}

	// Till here June - 2012
	public HashMap getExternalDBCheckResult(String extDrugId, String srl_no){
		String prodID = extDrugId+srl_no;
		if(extDBCheckResultALL.containsKey(prodID))
			return (HashMap)extDBCheckResultALL.get(prodID);
		else
			return null;
	}
	public void setExternalDBCheckResult(String extDrugId, String srl_no, HashMap externalDBCheckResult){
		String prodID = extDrugId+srl_no;
		HashMap temResult=externalDBCheckResult;
		if(extDBCheckResultALL==null)
			extDBCheckResultALL = new HashMap();
		if(extDBCheckResultALL.containsKey(prodID)){
			if(((HashMap)extDBCheckResultALL.get(prodID)).containsKey("DOSECHECK") && !externalDBCheckResult.containsKey("DOSECHECK"))
				temResult.put("DOSECHECK",(HashMap)((HashMap)extDBCheckResultALL.get(prodID)).get("DOSECHECK"));
		}
		extDBCheckResultALL.put(prodID,temResult);
	}

	public HashMap getExternalDBDrugInfo(String ExtDrugId)throws Exception{
		//drugInfos = new HashMap();
		if(drugInfos == null || !drugInfos.containsKey(ExtDrugId)){
			try{
				if(FDBBean == null )
					FDBBean			= new FDBExternalDataBaseBean();;
				HashMap drugInfo = (HashMap)FDBBean.getExternalDBDrugInfo(ExtDrugId);
				if(drugInfo !=null && drugInfo.containsKey(ExtDrugId))
					drugInfos.put(ExtDrugId,(HashMap)drugInfo.get(ExtDrugId));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return (HashMap)drugInfos.get(ExtDrugId);
	}
	
	/*============================code added for drug alergy check===================================*/
	public void  setAllergyDrugCodes(String patient_id){
		if(this.alergyDrugCodes == null || this.alergyDrugCodes.size()==0){
			this.alergyDrugCodes = new ArrayList();
			Connection connection = null ;
			PreparedStatement pstmt = null ;
			ResultSet resultSet = null ;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement("SELECT DISTINCT ext_prod_drug_code FROM (SELECT ext_prod_drug_code  FROM pr_adverse_event_reaction a, pr_allergy_sensitivity c, ph_drug_ext_prod_drug b, ph_drug d, pr_adverse_event e WHERE a.adv_event_type = 'DA' AND a.patient_id = ? AND d.drug_code IS NOT NULL AND d.drug_code = b.drug_code AND a.allergen_code = d.generic_id AND b.product_id = 'FDB' AND b.eff_status = 'E' AND a.status = 'A' AND a.patient_id = c.patient_id AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = c.adv_event_type AND a.allergen_code = c.allergen_code AND a.adv_event_srl_no = c.adv_event_srl_no AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.adv_event_dtl_srl_no = e.adv_event_dtl_srl_no AND c.status = 'A' AND NVL (e.drug_code, d.drug_code) = d.drug_code UNION ALL SELECT ext_prod_drug_code FROM pr_adverse_event_reaction a, pr_allergy_sensitivity c, ph_drug_ext_prod_drug b, ph_drug d, pr_adverse_event e WHERE a.adv_event_type = 'DA' AND a.patient_id = ? AND a.adv_reac_code = 'Oth' AND d.drug_code IS NOT NULL AND d.drug_code = b.drug_code AND a.allergen_code = d.generic_id AND b.product_id = 'FDB' AND b.eff_status = 'E' AND a.status = 'A' AND a.patient_id = c.patient_id AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = c.adv_event_type AND a.allergen_code = c.allergen_code AND a.adv_event_srl_no = c.adv_event_srl_no AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.adv_event_dtl_srl_no = e.adv_event_dtl_srl_no AND NVL (e.drug_code, d.drug_code) = d.drug_code AND c.status = 'A')") ;
				pstmt.setString(1,patient_id);
				pstmt.setString(2,patient_id);
				resultSet = pstmt.executeQuery() ;
				while(resultSet.next()) { 
					this.alergyDrugCodes.add(resultSet.getString("EXT_PROD_DRUG_CODE"));
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
					es.printStackTrace() ;
				}
			}
		}
	}

	public ArrayList  getEqvTermCodes(String patient_id){
		ArrayList icd9code = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_EXT_PROD_LINK_SELECT13" )) ;
			pstmt.setString(1,patient_id);
			resultSet = pstmt.executeQuery() ;
			while(resultSet.next()) { 
				icd9code.add(resultSet.getString("EQUIVALENT_TERM_CODE"));
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
				es.printStackTrace() ;
			}
		}
		return icd9code;
	}
   /*=================================ends here=======================================================*/
	public ArrayList getExternalRoutes(){
		ArrayList result=new ArrayList();
		return result;
	}

	/* Function specific methods start */
	public  String isParamSet(){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String result="N";
		try {
			connection = getConnection() ;
			//this query checks if external database link parameter is set to 'Y' in PH_PARAM
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_EXT_PROD_LINK_SELECT2" )) ;
			resultSet = pstmt.executeQuery() ;
			if  (resultSet.next()) { 
				result="Y";
				}
		}
			
		catch ( Exception e ) {
			e.printStackTrace() ;
			result="N";
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {   
				result="N";
			}
		}
		return result;
	}
	public HashMap returnExProduct(){
		return exProduct;
	}

	public void setDoseCheckParamValues(ArrayList dosageCheckParams){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String patient_id =  "", ext_dose_uom="", dose_uom="";
		String route_code			= "", ext_route_code="";	 //Added in January 2014 for CIMS - Dosage checks
		//String duration_type		= "", freq_nature = "",   interval_value = ""; 		 //Added in January 2014 for CIMS - Dosage checks
		//if(dosageCheckParams != null && dosageCheckParams.size() == 8){
		if(dosageCheckParams != null && dosageCheckParams.size() == 12){
			patient_id	= (String) dosageCheckParams.get(0);		//patient_id
			dose_uom	= (String) dosageCheckParams.get(5);		//dosage UOM(eHIS)
			route_code	= (String) dosageCheckParams.get(8);		//Added in January 2014 for CIMS - Dosage checks
			//duration_type	= (String) dosageCheckParams.get(9);		//Added in January 2014 for CIMS - Dosage checks 
			//freq_nature		= (String) dosageCheckParams.get(10);		//Added in January 2014 for CIMS - Dosage checks 
			//interval_value	= (String) dosageCheckParams.get(11);		//Added in January 2014 for CIMS - Dosage checks 
		}
		long age_in_days = 0;
		String age_in_year_month_days = ""; //FOR CIMS
		String sex = ""; //FOR CIMS
		try{
			connection = getConnection() ;
			//sql_query        = PhRepository.getPhKeyValue("SQL_PH_EXT_PROD_LINK_PATIENT_AGE_SELECT");
			sql_query			 =  "SELECT (TRUNC(SYSDATE) - TRUNC(DATE_OF_BIRTH)) AGE_IN_DAYS, SEX, MP_GET_AGE_YMDH(DATE_OF_BIRTH) AGE_IN_DAYS_MONTH  FROM MP_PATIENT WHERE PATIENT_ID=?"; // January 2014, move this query to PhRepository
			//sql_query        = "SELECT (Trunc(sysdate) - Trunc(date_of_birth)) age_in_days FROM mp_patient WHERE patient_id=?";
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,patient_id);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				if(externalDB!=null && externalDB.equals("CIMS"))	  //Added in January 2014 for CIMS Dosage
					age_in_year_month_days = resultSet.getString("AGE_IN_DAYS_MONTH");
				else 
					age_in_days = resultSet.getInt("age_in_days");
				sex		= checkForNull(resultSet.getString("SEX"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			//sql_query        = "SELECT DRUG_DATABASE_UOM_CODE FROM am_uom WHERE UOM_CODE = ?";
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_EXT_PROD_LINK_DOSE_UOM_SELECT");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,dose_uom);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				ext_dose_uom = resultSet.getString("DRUG_DATABASE_UOM_CODE")==null?"":resultSet.getString("DRUG_DATABASE_UOM_CODE");
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			//Added for CIMS, if required to make it condition based - CIMS - Dosage checks later based on dosage Y or N
			if(route_code!=null && !route_code.equals("") && (externalDB!=null && externalDB.equals("CIMS")) ) { // as of now only required for CIMS
				//sql_query			= "SELECT ROUTE_DESC FROM ph_route WHERE route_code = ?";
				sql_query			= "SELECT EXT_ROUTE_CODE FROM ph_route WHERE route_code = ?";
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,route_code);
				resultSet			= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					ext_route_code = resultSet.getString("EXT_ROUTE_CODE")==null?"":resultSet.getString("EXT_ROUTE_CODE");
					if(ext_route_code!=null && !ext_route_code.equals(""))
						route_code = ext_route_code; //send the External route code
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				dosageCheckParams.set(8,route_code);	//reinitialize with description	
			}
			dosageCheckParams.add(ext_dose_uom);
			if(externalDB!=null && externalDB.equals("CIMS"))	  //Added in January 2014 for CIMS Dosage
				dosageCheckParams.add(age_in_year_month_days);
			else
			    dosageCheckParams.add(age_in_days+"");  //FDB
			dosageCheckParams.add(sex); //newly added in January 2014 CIMS Dosage Checks
			setDoseCheckParams(dosageCheckParams);
		}
		catch(Exception es){
			es.printStackTrace() ;
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

	public  ArrayList getDrugList(String gCode,String exgCode){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();
		try {
			String tmp=populateMEDICOMtable(exgCode);
			if (tmp.equals("NODATA")){
				return result;
			}
			connection = getConnection() ;
			//this query returns all drugs associated with a particular generic id
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_EXT_PROD_LINK_SELECT1" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,login_facility_id);			
			pstmt.setString(3,gCode);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result.add(resultSet.getString("COMPOUND_DRUG_YN"));
				result.add(resultSet.getString("ROUTE_CODE"));
				result.add(resultSet.getString("FORM_CODE"));
				result.add(resultSet.getString("ROUTE_DESC"));
				result.add(resultSet.getString("FORM_DESC"));
				result.add(resultSet.getString("DRUG_DESC"));
				result.add(resultSet.getString("DRUG_CODE"));
				result.add(resultSet.getString("EXTERNAL_PRODUCT_ID"));
				result.add(resultSet.getString("FROMDB"));
				result.add(resultSet.getString("EXT_ROUTE_CODE"));
				result.add(resultSet.getString("EXT_ROUTE_DESC"));
				result.add(resultSet.getString("EXT_DRUG_DESC"));
				result.add(this.finalgeneric);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {   
				es.printStackTrace() ;
			}
		}
		return result;

	}

	private String populateMEDICOMtable(String gcode){
		//here we loop thru the exproduct hash map and store it in the temp table
		String result="Y";
		/*String atleastonerow="N";
		
		//in case the external generic id is say 1234..
		//we check if 1234 is already present in the db
			
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		PreparedStatement pstmt1 = null ;
		PreparedStatement pstmt2 = null ;
		PreparedStatement pstmt3=null;
		ResultSet resultSet = null ;
		ResultSet resultSet2 = null ;
		ResultSet resultset3=null;
		Object route=null;
		Object dcode=null;
		Object ddesc=null;
			try {
				connection = getConnection() ;
				//this query returns all drugs associated with a particular generic id

				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_EXT_PROD_LINK_SELECT5" )) ;
				pstmt.setString(1,gcode);

				pstmt2 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_EXT_PROD_LINK_SELECT7" )) ;


				resultSet = pstmt.executeQuery() ;

				if  (!resultSet.next()) { 

					//setSearchMethod - setSearchType - setDrugSearchFilter - setSearchText 
					
					//populate the hashmap from the api
					DispensableDrugSearch bean=new DispensableDrugSearch();
					bean.setSearchMethod(2);//Exhaustive Search
					bean.setSearchType(2);//no phonetic search
					bean.setDrugSearchFilter(2);//for all drugs (generic,branded and packaged)
					bean.setSearchText(gcode);//the generic name

					
					exProduct=bean.getGenericSearchResult();
					if (exProduct.isEmpty())
					{
						//means no data was retrieved from the external database
						result="NODATA";
						return result;
					}
				
					//we have to insert into the table from the hashmap
					Set	key_set		=	exProduct.keySet();
					Iterator itr	=	key_set.iterator();
					pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_EXT_PROD_LINK_SELECT6" )) ;
					 while(itr.hasNext())  
					{
						//retrieve values for that key
						route=itr.next();
						HashMap drugs=(HashMap)exProduct.get(route);
						//loop through drugs 
						Set	drugids		=	drugs.keySet();
						Iterator itr1	=	drugids.iterator();
						while(itr1.hasNext())  
						{
							//Here we check if the drug code already exists in the database and we do not populate
							dcode=itr1.next();
							ddesc=drugs.get(dcode);

							pstmt2.setString(1,dcode.toString());
							resultSet2 = pstmt2.executeQuery() ;
							if (!resultSet2.next())
							{
								pstmt1.setString(1,gcode);
								pstmt1.setString(2,route.toString());
								pstmt1.setString(3,dcode.toString());
								pstmt1.setString(4,ddesc.toString());
								pstmt1.addBatch();
								atleastonerow="Y";
							}

						}	closeResultSet(resultSet2);
						
					}
					if (atleastonerow.equals("Y"))
					{
							int[] result1=pstmt1.executeBatch();
							for ( int k=0;k<result1.length ;k++ ){
								// A number greater than or equal to zero  indicates success
								// A number -2 indicates that command is successful but number of rows updated is unknow
								// If it won't satisfy any of the above cancel the statement and throw an exception
								if(result1[k]<0  && result1[k] != -2 ){
									pstmt1.cancel();
									connection.rollback();
									result="N";
									return result;
								}		
							}

					}
					else{	
						//not even one row was inserted and so we have to retrieve the already existing generic name and send it back to the jsp page for the lookup query
						pstmt3 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_EXT_PROD_LINK_SELECT8" )) ;
						pstmt3.setString(1,dcode.toString());
						resultset3=pstmt3.executeQuery();
						if (resultset3.next()){
							this.finalgeneric=resultset3.getString("GENERIC_ID");
							result="ALTGENERIC";
							return result;
						}
				}
				connection.commit();
			}
				
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			result=e.toString();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				//closeResultSet( resultSet2 ) ;
				closeResultSet( resultset3) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2 ) ;
				closeStatement( pstmt3 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {  
				es.printStackTrace() ;
			}
		
		}*/
		//comented by naveen on 7/17/2006 
		return result;
	}

	public String getLoggedInFacility() {
		return login_facility_id;
	}

	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

	public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed 
		recordSet is nothing but a hashtable containing all form values	*/
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		this.recordSet = recordSet;
	}

	public HashMap modify() {
		//HashMap result=new HashMap();
		HashMap tabData=new HashMap();
		HashMap sqlMap=new HashMap();
		HashMap map=new HashMap();

		int totalRows;

		tabData.put("flag","test flag");
		tabData.put("result",new Boolean(true));
		tabData.put("message","message");

		tabData.put( "PROPERTIES", getProperties() );
		//get the totalrows and run a loop up to totalrows time and then sort the data
		
		totalRows=Integer.parseInt((String)recordSet.get("totalrows"));
		ArrayList DrugCodearray=new ArrayList();
		ArrayList ExCodearray=new ArrayList();
		String chk, dcode, extid;
		for (int i=1;i<=totalRows ;i++ ){
			chk=(String)recordSet.get("chkRECORD"+i);
			dcode=(String)recordSet.get("DRUGCODE"+i);
			extid=(String)recordSet.get("EXTPRODUCTID"+i);

			if ( chk.equals("on") ){
				//The record is selected and so we add the details to arraylists
				DrugCodearray.add(dcode);
				ExCodearray.add(extid);
			}
		}
		tabData.put("DRUGCODES",DrugCodearray);
		tabData.put("EXCODES",ExCodearray);
		tabData.put("LOGIN_BY_ID",login_by_id);
		tabData.put("LOGIN_AT_WS_NO",login_at_ws_no);
		tabData.put("LOGIN_FACILITY_ID",login_facility_id);
		try{
			sqlMap.put("SQLDRUGUPDATE", PhRepository.getPhKeyValue( "SQL_PH_EXT_PROD_LINK_UPDATE1" ) );
			/*ExternalProductLinkHome home=null;
			ExternalProductLinkRemote remote=null;
			InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue( "JNDI_PH_EXT_PROD_LINK" ) ) ;
			home  = (ExternalProductLinkHome) PortableRemoteObject.narrow( object, ExternalProductLinkHome.class ) ;
			remote = home.create() ; 
			map=remote.modify(tabData,sqlMap);*/
			//Object home = com.medicom.ESLP.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_EXT_PROD_LINK" ),ExternalProductLinkHome.class,getLocalEJB());
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_EXT_PROD_LINK" ),ExternalProductLinkHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
			map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) map.get( "result")).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"Common") ) ;
			else
				map.put( "message", (String)map.get("msgid") ) ;
		}
		catch (Exception e){
			map.put("result",new Boolean(false));
			map.put("message",e.toString());
		}
		return map;
	}

	private HashMap localUpdate( HashMap tabData , HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Modify" ) ;
		Connection connection	= null ;
		PreparedStatement pstmt_update=null;
		ArrayList DrugCodearray=new ArrayList();
		ArrayList ExCodearray=new ArrayList();
		ResultSet resultSet = null ;
		int count=0;
		int tmpcount=0;
		DrugCodearray=(ArrayList)tabData.get("DRUGCODES");
		ExCodearray=(ArrayList)tabData.get("EXCODES");
		String user=(String)tabData.get("LOGIN_BY_ID");
		String wsno=(String)tabData.get("LOGIN_AT_WS_NO");
		String facility=(String)tabData.get("LOGIN_FACILITY_ID");
		try {
			 connection	= getConnection() ;
			 count=DrugCodearray.size();
			 pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQLDRUGUPDATE"));
			for (int i=0;i<count ;i++ ){
				pstmt_update.setString(1,(String)ExCodearray.get(i));
				pstmt_update.setString(2,user);
				pstmt_update.setString(3,wsno);
				pstmt_update.setString(4,facility);
				pstmt_update.setString(5,(String)DrugCodearray.get(i));
				tmpcount =pstmt_update.executeUpdate() ;
				if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Updation into Ph External Product" );
					return map;
				}
				else{
					map.put( "result", new Boolean( true) ) ;
					map.put( "msgid", "RECORD_INSERTED") ;
				}
			}
			connection.commit();
		}//end of try
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Exception in EJB during insertion into ph external product " +e) ;

		}
		finally {
			try {
				closeResultSet(resultSet);	
				closeStatement( pstmt_update) ;
				closeConnection( connection );
				//closeConnection( connection, (Properties)tabData.get( "properties" ) );
				connection.rollback();
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map ;
	}

	public String getProdID(){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		// if(this.externalDB == null || this.externalDB.equals("")) condition ----- Added for SRR20056-SCF-7354
		if(this.externalDB == null || this.externalDB.equals("")){
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( "SELECT DRUG_DB_PRODUCT_ID FROM PH_FACILITY_PARAM WHERE FACILITY_ID = ?") ;
				pstmt.setString(1,login_facility_id);
				resultSet = pstmt.executeQuery() ;
				while (resultSet.next()) {
					this.externalDB = checkForNull((String)resultSet.getString("DRUG_DB_PRODUCT_ID"));
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
					es.printStackTrace() ;
				}
			}
		} //Added for SRR20056-SCF-7354
		return this.externalDB;
	}

	public HashMap getDrugProduct(){
		return this.drugProduct;
	}

	public HashMap getAllergyCheck(StringBuffer dup_drug_det_sbf_result, String exp_prodid) {
		HashMap allergy_alert_reqd = CIMSBean.getAllergyCheck(dup_drug_det_sbf_result, exp_prodid); 
	   return allergy_alert_reqd;
	}
//Added for TFS id:-16701 start	
	public HashMap getExternalDBChecksNew(ArrayList reqChecks, String extDrugId)throws Exception, Exception{

		//HashMap doseCheckResult=null; //commented for common-icn-0048
		externalDBCheckResult = new HashMap();
		dosageCheckYN="";
		dupTheraphyCheckYN="";
		drugInteracCheckYN="";
		drugContraIndCheckYN="";
		drugAllergyCheckYN="";
		getProdID();
		if(reqChecks!=null && reqChecks.size()>0){
			dosageCheckYN = (String)reqChecks.get(0);
			dupTheraphyCheckYN = (String)reqChecks.get(1);
			drugInteracCheckYN = (String)reqChecks.get(2);
			drugContraIndCheckYN = (String)reqChecks.get(3);
			drugAllergyCheckYN = (String)reqChecks.get(4);
		}
		
		try{
			
		
			 if(externalDB.equals("CIMS")){
				
				String ext_prod_id_without_delim = "";
				StringBuffer dup_drug_det_sbf_result = null;
				//HashMap drugProduct = new HashMap(); //Commented for common-icn-0048
				StringBuffer dosage_drug_det_sbf_result = getStoreResult();
				dup_drug_det_sbf_result=dosage_drug_det_sbf_result; 

if(dosage_drug_det_sbf_result != null && !dosage_drug_det_sbf_result.equals("") && dosage_drug_det_sbf_result.length()>0){
					if( (dupTheraphyCheckYN !=null && dupTheraphyCheckYN.equals("Y")) || (drugInteracCheckYN !=null && drugInteracCheckYN.equals("Y")) || (drugAllergyCheckYN !=null && drugAllergyCheckYN.equals("Y")) || (drugContraIndCheckYN!=null && drugContraIndCheckYN.equals("Y"))){    
					duplicateResult = "";
					if(extDrugId.indexOf("::")!=-1)
						ext_prod_id_without_delim = extDrugId.substring(extDrugId.indexOf("::")+2);
					else
					    ext_prod_id_without_delim  = extDrugId;


					 if( (dupTheraphyCheckYN !=null && dupTheraphyCheckYN.equals("Y")) || (drugInteracCheckYN !=null && drugInteracCheckYN.equals("Y")) ||  (drugContraIndCheckYN!=null && drugContraIndCheckYN.equals("Y"))) {  

						HashMap alert_reqd = (HashMap)getInteractionCheck(dup_drug_det_sbf_result, ext_prod_id_without_delim, reqChecks);
						if(alert_reqd!=null && alert_reqd.size()>0) {
							if((Boolean)alert_reqd.get("DUPCHECK"))
								externalDBCheckResult.put("DUPCHECK","DUPLICATE CHECK");	
							if((Boolean)alert_reqd.get("INTRACHECK"))
								externalDBCheckResult.put("INTRACHECK",alert_reqd);	 
							if((Boolean)alert_reqd.get("HEALTHINTRACHECK"))                        
								externalDBCheckResult.put("HEALTHINTRACHECK",alert_reqd);	 
	///System.err.println("------Externalproduct"+externalDBCheckResult);
						}
					} 
				}
			
				
				if(drugAllergyCheckYN !=null && drugAllergyCheckYN.equals("Y")){
					
					HashMap allergy_alert_reqd = (HashMap)getAllergyCheck(dup_drug_det_sbf_result, ext_prod_id_without_delim);
					if(allergy_alert_reqd!=null && allergy_alert_reqd.size()>0) {
						if((Boolean)allergy_alert_reqd.get("ALLERGYCHECK"))
							externalDBCheckResult.put("ALLERGYCHECK","ALLERGY CHECK");	 
					}
				}
				
				}
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return externalDBCheckResult;
	}
//Added for TFS id:-16701 end
	public void setDispBeyondBeforeValues(){//Added for COMMON-ICN-0120 [40745]
        Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String sql = "";
	try{
				connection			= getConnection() ;
		 sql ="SELECT disp_before_start_date_yn, disp_before_no_of_days, disp_beyond_earliest_start_yn, disp_beyond_no_of_days FROM ph_facility_param WHERE facility_id = ?";
		 pstmt				= connection.prepareStatement(sql) ;
				pstmt.setString(1, login_facility_id.trim());
				System.err.println("login_facility_id=="+login_facility_id.trim());
				resultSet	= pstmt.executeQuery();
				if (resultSet!=null && resultSet.next()) {
					setDisp_before_start_date_yn(resultSet.getString("disp_before_start_date_yn")==null?"":resultSet.getString("disp_before_start_date_yn"));
					setDisp_before_no_of_days(resultSet.getString("disp_before_no_of_days")==null?"":resultSet.getString("disp_before_no_of_days"));
					setDisp_beyond_earliest_start_yn(resultSet.getString("disp_beyond_earliest_start_yn")==null?"":resultSet.getString("disp_beyond_earliest_start_yn"));
					setDisp_beyond_no_of_days(resultSet.getString("disp_beyond_no_of_days")==null?"":resultSet.getString("disp_beyond_no_of_days"));
					 System.err.println("disp_before_start_date_yn ==="+getDisp_before_start_date_yn()+"disp_before_no_of_days=="+getDisp_before_no_of_days()+"disp_beyond_earliest_start_yn==="+getDisp_beyond_earliest_start_yn()+"disp_beyond_no_of_days==="+getDisp_beyond_no_of_days());	 
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
	}//Added for COMMON-ICN-0120 [40745]
}
