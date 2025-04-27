/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
10/01/2019	  	IN068344	     	Manickavasagam 		  			GHL-CRF-0549 [IN068344] 
09/08/2019      IN070605		 prathyusha  MMS-KH-CRF-0028
13/08/2019      IN070605		 Devindra   MMS-KH-CRF-0028 
03/01/2020      		 PRATHYUSHA NMC-JD-SCF-0047
28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
15/4/2022		TFS25857		Shazana												SKR-SCF-1646
15/4/2022		TFS25858		Shazana												SKR-SCF-1647
17/05/2023	    IN43751		    Sushant Tambe		                 ML-BRU-SCF-2223
13/7/2023      TFS-46322          hariharan                    Ramesh goil            COMMON-ICN-0310
18/07/2023		IN47797			Sushant Tambe						 ML-MMOH-SCF-2478
04/08/2023		IN48286			Sushant Tambe						 COMMON-ICN-0152
06/09/2023		IN48897			Sushant Tambe						 COMMON-ICN-0170

 *****************************************************************************************************************/
package ePH ;
import java.io.Serializable ;
import java.util.* ;  
import java.sql.* ; 
import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.DispMedication.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
 
public class DispMedicationAllStages extends PhAdapter implements Serializable {

	protected HashMap patient_det			= new HashMap();
	protected String debug					= "";
	protected ArrayList	multi_drugs			= new ArrayList();
	protected String curr_date				= "";
	protected String curr_date_time			= "";
	protected String pract_id				= "";
	protected String pract_name				= "";
	private   String rertddisp_location		= "";
	protected HashMap token_vals			= new HashMap();
	protected ArrayList	reason				= null;
	protected HashMap reason_vals			= new HashMap();
	protected HashMap fill_remarks			= new HashMap();
	protected HashMap delivery_remarks		= new HashMap();
	protected HashMap	allocatefill_remarks= new HashMap();	
	protected HashMap editLabel			    = new HashMap();
	private HashMap order_det			    = new HashMap();
    private HashMap billing_reason__det     = new HashMap();
	private HashMap dd_values			    = new HashMap();	
	protected HashMap IR_FLAG_VALUE			= new HashMap();
	protected ArrayList hold_drugs			= new ArrayList();
	protected ArrayList filling_det			= new ArrayList();
	protected ArrayList stock_items			= new ArrayList();
	protected HashMap	drug_stock			= new HashMap();
	protected String module_id				= "";
	protected String uom					= "";
	protected String taper					= "";
	protected HashMap item_store			= new HashMap();
	protected boolean multi_found			= false;
	protected HashMap first_time_validate	= new HashMap();
	protected String pharmacist_id			= ""; 
	protected Hashtable forDispensing		= new Hashtable();
	protected HashMap	stock_availability	= new HashMap();
	protected HashMap	stock_batches		= new HashMap();
	protected ArrayList tpn_values			= new ArrayList();
	protected ArrayList tpn_details			= new ArrayList();
	protected String tpn_qty				= "";
	protected String tpn_qty_uom			= "";
	protected String tpn_pres_qty           = "";
	protected String over_vol				= "";
	protected String over_vol_uom           = "";
	DispMedicationBean disp_bean			= null;
	protected ArrayList disp_nos			= null;
	protected String fillPersonName			= "";
	String bl_interface_yn					= "N"; 
	protected String osmolarity_volume      =  "";
    protected ArrayList cons_item_det		= new ArrayList();
	protected HashMap issueUomQty			= new HashMap();
	private ArrayList alEditLabelPairValues	= new ArrayList();
	private String sPerformPractId			= "";
	boolean bUpdateDTLTable					= false;
	private boolean bEditDispLabelAfterDisp	= false;
	private boolean bPRNOrAbsOrder			= false;
	private boolean bDecimalAllowedParamYN	= false;
	protected ArrayList noOfPrints			    = new ArrayList(); //added For RUT-CRF-0067
	private String authUserId			= "";  //RUT-CRF-0035 [IN029926]
	private String userAuthPINReqYN		= "";  //RUT-CRF-0035 [IN029926]
	//private String authUserName		= "";  //RUT-CRF-0035 [IN029926]   Removed for IN063877
	protected HashMap editableLabel			    = new HashMap(); //Added for Bru-HIMS-CRF-414 [IN:045554]

	protected HashMap charge_dtls			= new HashMap();
	protected HashMap hmAltDrugRemarks		= new HashMap(); //Added for Bru-HIMS-CRF-082 [IN:029948]
	protected HashMap hmDrugPenaltyDtls		= new HashMap(); //Added for JD-CRF-0170.1 [IN:040204]
	private int	iNoOfDecimals				= 0;
	MedicationPlannerBean medplan_bean		= null;// Added for Bru-HIMS-CRF-072.1[IN 049144]
	private String st_no_of_decimals = "0";  // added for AAKH-SCF-0113 [IN:048937] -start
	private String st_disp_decimal_dtls_yn = "N";
	private String default_bms_disp_loc = "";// Added for HSA-CRF-0113 [IN:048166] 
	protected String dispTranSeqNo = "";//added for MMS-QH-CRF-0201 [IN:052255] 
	protected HashMap totalPrint = new HashMap();  // Added for TTMWM-SCF-0184  - Start
	protected HashMap orderCheckedYn = new HashMap(); // Added for MMS-KH-CRF-0028 [IN070605] - Start
	//GHL-CRF-0618 - start
	private String formulary_code = "";
	private String formulary_type = "";
	private String blg_grp_id	  = "";
	private ArrayList  itemGenericType = new ArrayList();//GHL-CRF-0618
	private HashMap nonPreferenceRemarks = new HashMap();//GHL-CRF-0618
//MMS-KH-CRF-0030 - start
	private HashMap altItem = new HashMap();
	private	HashMap	addBarcode		 = new HashMap();
	private HashMap selectedAltDrug = new HashMap();
	private HashMap tot_alt_scan_qty = new HashMap();
	private HashMap barcode_scan_qty = new HashMap();
	private boolean display_insurance_status = false ;//Added for TH-KW-CRF-0012
	private String insurance_patient_yn ="N";//Added for TH-KW-CRF-0012
	private HashMap insuranceStatus =new HashMap();//Added for TH-KW-CRF-0012
//MMS-KH-CRF-0030 - end
    private String refillOrderStr  =""; //Added For MOHE-CRF-0069
    private ArrayList alSalDocDtls = null;//added for TH-KW-CRF-0020.3
	private HashMap drugCount =new HashMap();//Added for MMS-DM-CRF-0174.5
    public ArrayList getSalDocDtls(){ 
		return this.alSalDocDtls;
	}
	public void setSalDocDtls(ArrayList alSalDocDtls){ 
		this.alSalDocDtls = alSalDocDtls;
	}
	//GHL-CRF-0618 - end
	public void setOrderCheckedYn(String key,String value){
		orderCheckedYn.put(key,value);
	}
	public String getOrderCheckedYn(String key){
		 if(orderCheckedYn.containsKey(key)){
			 return (String)orderCheckedYn.get(key);
		 }
		 else
			 return "";
	}
	
	// Added for MMS-KH-CRF-0028 [IN070605] - End
    
	public HashMap getTotalPrint() {
		return totalPrint;
	}


	public void setTotalPrint(HashMap totalPrint) {
		this.totalPrint = totalPrint;
	}  // Added for TTMWM-SCF-0184  - End
	public String getDispTranSeqNo() {//added for MMS-QH-CRF-0201 [IN:052255] 
		return dispTranSeqNo;
	}


	public void setDispTranSeqNo(String dispTranSeqNo) {//added for MMS-QH-CRF-0201 [IN:052255] 
		this.dispTranSeqNo = dispTranSeqNo;
	}
	public String getDefaultBmsDispLoc() { //Added for HSA-CRF-0113 [IN:048166] 
		return default_bms_disp_loc;
	}
	public void setDefaultBmsDispLoc(String default_bms_disp_loc) {//Added for HSA-CRF-0113 [IN:048166] 
		this.default_bms_disp_loc = default_bms_disp_loc;
	}
	public String getSt_no_of_decimals() {
		return st_no_of_decimals;
	}
	public void setSt_no_of_decimals(String st_no_of_decimals) {
		this.st_no_of_decimals = st_no_of_decimals;
	}
	public String getSt_disp_decimal_dtls_yn() {
		return st_disp_decimal_dtls_yn;
	}
	public void setSt_disp_decimal_dtls_yn(String st_disp_decimal_dtls_yn) {
		this.st_disp_decimal_dtls_yn = st_disp_decimal_dtls_yn;
	} //added for AAKH-SCF-0113 [IN:048937] -end

	public DispMedicationAllStages() {
		try {
			doCommon();
		}
		catch(Exception e) {e.printStackTrace();}
	}

	/* Over-ridden Adapter methods start here */

	public void clearPenaltyDtls() {
		if(this.hmDrugPenaltyDtls!=null)
			this.hmDrugPenaltyDtls.clear();
	}
	public void setObject(DispMedicationBean disp_bean) {
		this.disp_bean = disp_bean;
	}
	public void setObject(MedicationPlannerBean medplan_bean) {// Added for Bru-HIMS-CRF-072.1[IN 049144]
		this.medplan_bean = medplan_bean;
	}
	public void setModuleId(String module_id) {
		this.module_id	=	module_id;
	}

	public String getModuleId() {
		return this.module_id;
	}

	public boolean getBEditDispLabelAfterDisp(){
		return this.bEditDispLabelAfterDisp;
	}

	public void setAlEditLabelPairValues(ArrayList alEditLabelPairValues){
		this.alEditLabelPairValues	=	alEditLabelPairValues;
	}
	public ArrayList getAlEditLabelPairValues(){
		return this.alEditLabelPairValues;
	}
	public void clearAlEditLabelPairValues(){
		alEditLabelPairValues = new ArrayList();
	}

	public void setSPerformPractId(String sPerformPractId){
		this.sPerformPractId	=	sPerformPractId;
	}
	public String getSPerformPractId(){
		return this.sPerformPractId;
	}
//===code added for display taper gif on allocation,filling ,verification,delivery screens==
    public void setTapervalue(String taper) {
		this.taper	=	taper;
	}

	public String getTapervalue() {
		return this.taper;
	}
//====ends here==============

	public void setDrugUom(String uom){
		this.uom	=	uom;
	}
	public String getDrugUom(){
		return this.uom;
	}

	public int getINoOfDecimals(){
		return this.iNoOfDecimals;
	}

	public void setBUpdateDTLTable(boolean bUpdateDTLTable){
		this.bUpdateDTLTable	=	bUpdateDTLTable;
	}
	public boolean getBUpdateDTLTable(){
		return this.bUpdateDTLTable;
	}

	public void setDDValues(HashMap dd_values) {
		this.dd_values	=	dd_values;
	}

	public HashMap getDDValues() {
		return this.dd_values;
	}

	/*public void setConsumableDetails(ArrayList cons_item_det) {
		this.cons_item_det	=	cons_item_det;
	}*/

	public ArrayList getConsumableDetails() {
		return this.cons_item_det;
	}

	public void setTokenVals(String order_id, String token_no) {
		this.token_vals.put(order_id, token_no);
	}

	public HashMap getTokenVals(){
		return this.token_vals;
	}
	
	public void clearTokenVals(){
		token_vals.clear();
	}
/*=added on 11/25/2004 for inserting NEXT COLLECTION FROM in dispmedicationprintdialog.jsp=======*/
	public void setReRtdDispLocnCode(String rertddisp_location){
		this.rertddisp_location = rertddisp_location;
	}
	public String getReRtdDispLocnCode(){
		return rertddisp_location;
	}

	public void setBLInterfaceYN(String bl_interface_yn){
		this.bl_interface_yn = bl_interface_yn;
	}
	public String getBLInterfaceYN(){
		return checkForNull(bl_interface_yn);
	}

	public void setFirstTime(String order_id,boolean first_time) {
		first_time_validate.put(order_id,first_time+"");
	}

	public String getFirstTime(String order_id) {
		String first_time	=	"";
		if(first_time_validate.containsKey(order_id))
			first_time	=	(String)first_time_validate.get(order_id);
		return first_time;
	}

	public String getPharmacistID(){
		this.pharmacist_id = login_by_id.trim();
		return this.pharmacist_id;
	}

	public void setMultiFound(boolean val) {
		this.multi_found	=	val;
	}

	public boolean getMultiFound() {
		return this.multi_found;
	}

	public boolean getBDecimalAllowedParamYN() {
		return this.bDecimalAllowedParamYN;
	}

	public void setBPRNOrAbsOrder(boolean bPRNOrAbsOrder) {
		this.bPRNOrAbsOrder	=	bPRNOrAbsOrder;
	}

	public boolean getBPRNOrAbsOrder() {
		return this.bPRNOrAbsOrder;
	}
//Adding start For MOHE-CRF-0069
	public void setRefillOrderStr(String refillStr) {
		this.refillOrderStr	=	refillStr;
	}

	public String getRefillOrderStr() {
		return this.refillOrderStr	;
	}
	//Adding end For MOHE-CRF-0069

    public void setIssueUomQty(String key,String issue_uom_qty) {
		this.issueUomQty.put(key,issue_uom_qty);
	}

	public HashMap getIssueUomQty(){
		return this.issueUomQty;
	}

    public void setAltDrugRemarks(String key,String alt_drug_remarks) {
		this.hmAltDrugRemarks.put(key,alt_drug_remarks);
	}
    public void removeAltDrugRemarks(String key) {
		if(this.hmAltDrugRemarks.containsKey(key))
			this.hmAltDrugRemarks.remove(key);
	}

	public HashMap getAltDrugRemarks(){
		return this.hmAltDrugRemarks;
	}

	public String getAltDrugRemarks(String key){
		if(this.hmAltDrugRemarks.containsKey(key))
			return (String)this.hmAltDrugRemarks.get(key);
		else
			return "";
	}

	public void setStockAvailability(String order_line_no, String item_code) {
		ArrayList items	=	new ArrayList();

		if(stock_availability.containsKey(order_line_no)) {
			items	=	(ArrayList)stock_availability.get(order_line_no);
			if(!items.contains(item_code))
				items.add(item_code);
		}
		else {
			items.add(item_code);
		}
		stock_availability.put(order_line_no,items);
	}
	
	public boolean checkStockAvailability(String order_line_no, String item_code) {
		boolean result	=	false;

		if(stock_availability.containsKey(order_line_no)) {
			ArrayList items	=	(ArrayList)stock_availability.get(order_line_no);
			if(items.contains(item_code))
			result		=	true;
		}
		return result;
	}

	public void storeStockAvailability(String key, ArrayList batch_dtls) {
		this.stock_batches.put(key,batch_dtls);
	}
	public void setDisplayInsStatus(Connection con){//Adding start for TH-KW-CRF-0012
		 this.display_insurance_status = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISPLSY_INSURANCE_STATUS");
	}
	public boolean getDisplayInsStatus( ){
	    return display_insurance_status;
	}
	public void setInsurancePatient(String insurance_patient){
		this.insurance_patient_yn =insurance_patient;
	}
	public String getInsurancePatient(){
		 return insurance_patient_yn;
	}//Adding end for TH-KW-CRF-0012

	public ArrayList getStockAvailability(String key) {
		ArrayList batch_dtls	=	new ArrayList();
		if(stock_batches.containsKey(key))
			batch_dtls			=	(ArrayList)stock_batches.get(key);

		return batch_dtls;
	}
	public void setDrugCount(String drug_code){//Adding start for MMS-DM-CRF-0174.5
		String drug_count ="";
		int temp_drug_count =1;
		if(drugCount.containsKey(drug_code)){
			temp_drug_count =Integer.parseInt((String)drugCount.get(drug_code));
		    temp_drug_count =temp_drug_count+1;
           drug_count = temp_drug_count+"";
		    drugCount.put(drug_code,drug_count);
		}else{
			drug_count =temp_drug_count+"";
			drugCount.put(drug_code,drug_count);
		}
	}
	public String getDrugCount(String drug_code){
		String drug_count ="";
		if(drugCount.containsKey(drug_code))
			drug_count =(String)drugCount.get(drug_code);

		return drug_count;

	}//Adding end for MMS-DM-CRF-0174.5
	

	public void setFilling(String patient_id, String order_id) {
		ArrayList drug_detail	=	new ArrayList();
		HashMap	alt_drug_det	=	new HashMap();

		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				Set	key_set		=	order.keySet();
				Iterator itr	=	key_set.iterator();
				while(itr.hasNext())  {
					String	order_line_no	=	(String)itr.next();
					if(order.containsKey(order_line_no)) {
						HashMap order_detail	=	(HashMap)order.get(order_line_no);
						if(order_detail.containsKey("drug_det"))
							drug_detail	=	(ArrayList)order_detail.get("drug_det");
						if(order_detail.containsKey("alt_drug_det")) 
							alt_drug_det	=	(HashMap)order_detail.get("alt_drug_det");
						if( (drug_detail.size() > 1) || (alt_drug_det.size() > 1) ){
							String key	=	patient_id+order_id+order_line_no;
							filling_det.add(key);
						}
					}
				}
			}
		}
	}

	public boolean getFilling(String patient_id, String order_id, String order_line_no ) {
		String key	=	patient_id+order_id+order_line_no;

		if(filling_det.contains(key))
			return true;
		else
			return false;

	}

	public void setOrderDetails(String key,String end_date) {
		this.order_det.put(key,end_date);
	}

	public HashMap getOrderDetails(){
		return this.order_det;
	}


	public void setBiilingReasonDetails(String key,HashMap det) {
		this.billing_reason__det.put(key,det);
	}

	public HashMap getBiilingReasonDetails(){
		return this.billing_reason__det;
	}


	public void addItems(String drug_code, String item_code) {
		if(!drug_stock.containsKey(drug_code)) {
			stock_items	=	new ArrayList();
			if(!stock_items.contains(item_code)) {
				stock_items.add(item_code);
				drug_stock.put(drug_code,stock_items);
			}
		} 
		else {
			ArrayList stock	= (ArrayList)drug_stock.get(drug_code);
			if(!stock.contains(item_code)) 
				stock.add(item_code);
		}
	}
	
	public void setStockItems(String drug_code, ArrayList stock_items) {
		if(!item_store.containsKey(drug_code)) {
			item_store.put(drug_code,stock_items);
		}
		else{//added ELSE CONDITION by Ganga for ML-BRU-SCF-0905
			if(stock_items.size()==0)
				item_store.put(drug_code,stock_items);
		}
	}
	
	public void setDispNos(ArrayList disp_nos) {
		this.disp_nos	=	disp_nos;
	}

	public ArrayList getDispNos() {
		return this.disp_nos;
	}

	public ArrayList getStockItems(String drug_code) {
		if(item_store.containsKey(drug_code)){
		   ArrayList stk_items	=	(ArrayList)item_store.get(drug_code);
		   return stk_items;
		}
		else{
           ArrayList stk_items	= new ArrayList();
		   return stk_items;
		}
	}
	
	public void removeItems(String drug_code) {
		if(drug_stock.containsKey(drug_code)) {
			stock_items	=	new ArrayList();
			drug_stock.put(drug_code,stock_items);
		}
	}

	public ArrayList getItems(String drug_code) {
		ArrayList items	=	new ArrayList();
		if(drug_stock.containsKey(drug_code))
			items	=	(ArrayList)drug_stock.get(drug_code);
		return items;
	}

	public ArrayList getReason() {
		this.pharmacist_id = login_by_id.trim();
		return this.reason;
	}

	public void setRemarks(String reason, String remarks, String recno) {
		ArrayList reason_recs			=	new ArrayList();
		reason_recs.add(recno);
		reason_recs.add(reason);
		reason_recs.add(remarks);
		reason_vals.put(recno,reason_recs);
	}

	//code added by senthilkumar on 17/4/2004 for filling remarks...
	public void setFillingRemarks(String reason, String remarks, String recno) {
		ArrayList fill			=	new ArrayList();
		fill.add(recno);
		fill.add(reason);
		fill.add(remarks);
		fill_remarks.put(recno,fill);
	}

	public void clearFillRemarks(String recno) {
		if(this.fill_remarks.containsKey(recno)) {
			this.fill_remarks.remove(recno);
		}
	}
	
	public ArrayList getFillReason(String record_line_id) {
		ArrayList reason_recs			=	new ArrayList();
		if(this.fill_remarks.containsKey(record_line_id)) {
			reason_recs	=	(ArrayList)fill_remarks.get(record_line_id);
		}
		else{
			reason_recs.add("");
			reason_recs.add("");
			reason_recs.add("");
		}
		return reason_recs;
	}

	public void setDeliveryFillingRemarks(String reason, String remarks, String recno) {
		ArrayList fill			=	new ArrayList();
		fill.add(recno);
		fill.add(reason);
		fill.add(remarks);
		delivery_remarks.put(recno,fill);
	}

	public void clearDeliveryFillRemarks(String recno) {
		if(this.delivery_remarks.containsKey(recno)) {
			this.delivery_remarks.remove(recno);
		}
	}
	
	public ArrayList getDeliveryFillReason(String record_line_id) {
		ArrayList del_reason_recs			=	new ArrayList();
		if(this.delivery_remarks.containsKey(record_line_id)) {
			del_reason_recs	=	(ArrayList)delivery_remarks.get(record_line_id);
		}
		else{
			del_reason_recs.add("");
			del_reason_recs.add("");
			del_reason_recs.add("");
		}
		return del_reason_recs;
	}

	public void setAllocateFillingRemarks(String reason, String remarks, String recno) {
		ArrayList fill			=	new ArrayList();
		fill.add(recno);
		fill.add(reason);
		fill.add(remarks);
		allocatefill_remarks.put(recno,fill);
	}

	public void clearAllocateFillRemarks(String recno) {
		if(this.allocatefill_remarks.containsKey(recno)) {
			this.allocatefill_remarks.remove(recno);
		}
	}
	
	//RUT-CRF-0035 [IN029926] -- begin
	public String getUserAuthPINRequiredYN(){
		return this.userAuthPINReqYN;
	}

	public void setUserAuthPINRequiredYN(String userAuthPINReqYN){
		this.userAuthPINReqYN=userAuthPINReqYN;
	}
	
	public String getAuthUserID(){
		return this.authUserId;
	}

	public void setAuthUserID(String authUserId){
		this.authUserId=authUserId;
	}
	
	//RUT-CRF-0035 [IN029926] -- end
	public ArrayList getAllocateFillReason(String record_line_id) {
		ArrayList all_reason_recs			=	new ArrayList();
		
		if(this.allocatefill_remarks.containsKey(record_line_id)) {
			all_reason_recs	=	(ArrayList)allocatefill_remarks.get(record_line_id);
		}
		else{
			all_reason_recs.add("");
			all_reason_recs.add("");
			all_reason_recs.add("");
		}
		return all_reason_recs;
	}

	public String getRemarks(String code,String appl_trn){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String remarks			= "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_REASON_REMARKS")) ;
			pstmt.setString(1,code);
			pstmt.setString(2,appl_trn);
			pstmt.setString(3,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				remarks		=	resultSet.getString("REMARKS");		
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
		return remarks;
	}
	//...ended

	//code added for all stages findings values....

	public void setAllStagesFillingRemarks(String reason, String remarks, String recno) {
		ArrayList fill			=	new ArrayList();
		fill.add(recno);
		fill.add(reason);
		fill.add(remarks);
		allocatefill_remarks.put(recno,fill);
	}


	public void clearAllStagesFillRemarks(String recno) {
		if(this.allocatefill_remarks.containsKey(recno)) {
			this.allocatefill_remarks.remove(recno);
		}
	}
	
	public ArrayList getAllStageFillReason(String record_line_id) {
		ArrayList all_reason_recs			=	new ArrayList();
		
		if(this.allocatefill_remarks.containsKey(record_line_id)) {
			all_reason_recs	=	(ArrayList)allocatefill_remarks.get(record_line_id);
		}else
		{
			all_reason_recs.add("");
			all_reason_recs.add("");
			all_reason_recs.add("");
		}
		
		return all_reason_recs;
	}

	//ended...
	public void setTPNValues(ArrayList values ) {
		this.tpn_values	=	values;
	}

	public ArrayList getTPNValues() {
		return this.tpn_values;
	}
	public void setTPNDetails(ArrayList details ) {
		this.tpn_details	=	details;
	}

	public ArrayList setTPNDetails() {
		return this.tpn_details;
	}
	public void setTPNQty(String qty) {
		this.tpn_qty	=	qty;
	}

	public String getTPNQty() {
		return this.tpn_qty;
	}

	public void setTPNQtyUOM(String tpn_qty_uom) {
		this.tpn_qty_uom	=	tpn_qty_uom;
	}

	public String getTPNQtyUOM() {
		return this.tpn_qty_uom;
	}
	public void setTPNPresQty(String tpn_pres_qty) {
		this.tpn_pres_qty	=	tpn_pres_qty;
	}

	public String getTPNPresQty() {
		return this.tpn_pres_qty;
	}
	
	public void setOverageVol(String over_vol) {
		this.over_vol	=	over_vol;
	}

	public String getOverageVol() {
		return this.over_vol;
	}
	 public void setNoOfPrints(ArrayList noOfPrints) {
		this.noOfPrints	=	noOfPrints;
	}

	public ArrayList getNoOfPrints() {
		return this.noOfPrints;
	}
	public void setOverageVolUom(String over_vol_uom) {
		this.over_vol_uom	=	over_vol_uom;
	}

	public String getOverageVolUom() {
		return this.over_vol_uom;
	}

	public void setOsmolarityVol(String osmolarity_volume) {
		this.osmolarity_volume	=	osmolarity_volume;
	}

	public String getOsmolarityVol() {
		return this.osmolarity_volume;
	}
//MMS-KH-CRF-0030 - start
	public void setAltItems(String key,ArrayList arr ){
		this.altItem.put(key,arr);
	}

	public HashMap getAltItems(){
		return altItem;	
	}

	public void addAltBarcode(String key,ArrayList barcode_id){
	  this.addBarcode.put(key,barcode_id);
	}

	public HashMap getAltBarcode(){
  	  return addBarcode;
	}
	public void setSelectedAltDrug(String key,String drug_code){
		this.selectedAltDrug.put(key,drug_code);
	}
	public HashMap getSelectedAltDrug(){
  	  return selectedAltDrug;
	}

	public void setBarcodeQty(String key,String qty){
		this.barcode_scan_qty.put(key,qty);
	}
 
	public HashMap getBarcodeQty(){
		return barcode_scan_qty;
	}

	public void setAltDrugScanQty(String key,String qty){
		this.tot_alt_scan_qty.put(key,qty);
	} 
	public HashMap getAltDrugScanQty(){
	   return tot_alt_scan_qty;
	}
//MMS-KH-CRF-0030 - end

	public ArrayList getBeanReason(String recno) {
		ArrayList reason_recs			=	new ArrayList();
		
		if(this.reason_vals.containsKey(recno)) {
			reason_recs	=	(ArrayList)reason_vals.get(recno);
		}
		return reason_recs;
	}


	public void setHold(String order_id, String order_line_no) {
		String key	=	order_id+order_line_no;
		if(!hold_drugs.contains(key)) {
			hold_drugs.add(key);
		}
	}

	public ArrayList getHold() {
		return this.hold_drugs;
	}

	public boolean checkHold(String order_id, String order_line_no) {
		String key	=	order_id+order_line_no;
		boolean result = false;
		if(hold_drugs.contains(key))
			result = true;
		return result;
	}

	public void clearRemarks(String recno) {
		if(this.reason_vals.containsKey(recno)) {
			this.reason_vals.remove(recno);
		}
	}

	public void clearHold(String order_id,String order_line_no) {
		String key	=	order_id+order_line_no;
		if(hold_drugs.contains(key))
			hold_drugs.remove(key);
	}

	public void setCurrDate(String curr_date)	{
		this.curr_date	=	curr_date;
	}

	public String getCurrDate()	{
		return this.curr_date;
	}

	public void setCurrDateTime(String curr_date_time)	{
		this.curr_date_time	=	curr_date_time;
	}

	public String getCurrDateTime()	{
		return this.curr_date_time;
	}
	
	
	public void setPractitionerID(String pract_id)	{
		this.pract_id	=	pract_id;
	}

	public String getPractitionerID()	{
		return this.pract_id;
	}

	public void setPractitionerName(String pract_name)	{
		this.pract_name	=	pract_name;
	}

	public String getPractitionerName()	{
		return this.pract_name;
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

	public void setNonPrefernceRemarks(String item_code,String item_remarks,String order_id,String order_line_no){ //modified for GHL-CRF-0619
		this.nonPreferenceRemarks.put(order_id+order_line_no+item_code,item_remarks);
	}

	public HashMap getNonPrefernceRemarks(){
		return nonPreferenceRemarks;
	}


//added for GHL-CRF-0618 - end


	public void addPatient(String patient_id)	{
		if(!patient_det.containsKey(patient_id))	{
			patient_det.put(patient_id,new HashMap());
		}
	}

	public void addPrescription(String patient_id,String order_id)	{
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);

			if(!prescription.containsKey(order_id))	{
				//prescription.put(order_id,new HashMap()); //Commented for  SKR-SCF-0716 [IN036163]
				prescription.put(order_id,new LinkedHashMap()); //Added for SKR-SCF-0716 [IN036163]
				patient_det.put(patient_id,prescription);
				setFirstTime(order_id,true);
			}
		}
	}

	public void addDrugs(String patient_id, String order_id, String drug_code, String alt_drug_yn,String order_line_no)	{
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				//HashMap order	=	(HashMap)prescription.get(order_id); //Commented for SKR-SCF-0716 [IN036163]
				HashMap order	=	new LinkedHashMap(); //Added for SKR-SCF-0716 [IN036163]
				order=(HashMap)prescription.get(order_id);
				if(!order.containsKey(order_line_no))	{
					HashMap drug_detail	=	new HashMap();
					drug_detail.put("drug_det",new ArrayList());
					drug_detail.put("drug_code",drug_code);
					drug_detail.put("tot_qty","");
					if(alt_drug_yn.equals("Y")) {
						drug_detail.put("alt_drugs",new ArrayList());
						drug_detail.put("alt_drug_det",new HashMap());
					}
					order.put(order_line_no,drug_detail);
					prescription.put(order_id,order);
					patient_det.put(patient_id,prescription);
				}
			}
		}
	}

	public void setDrugQuantity(String patient_id,String order_id,String order_line_no,double qty) {
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_det	=	(HashMap)order.get(order_line_no);
					if(drug_det.containsKey("tot_qty"))	{
						drug_det.put("tot_qty",""+qty);
					}
				}
			}
		}
	}
	
	public String getDrugQuantity(String patient_id,String order_id,String order_line_no) {
		String qty	=	"0"; // "" changed to "0" for MMS-DM-SCF-0083
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_det	=	(HashMap)order.get(order_line_no);
					if(drug_det.containsKey("tot_qty"))	{
						qty	=	(String)drug_det.get("tot_qty")==""?"0":(String)drug_det.get("tot_qty"); // ==""?"0":(String)drug_det.get("tot_qty") Added for MMS-DM-SCF-0083
					}
				}
			}
		}
		return qty;
	}
	
	public String getTPNDrugQuantity(String order_id,String order_line_no){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String qty			= "";
		double qty1			=0;
		try {

            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_DTL_DISP_QTY_SELECT")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
            resultSet	= pstmt.executeQuery() ;
			
			while (resultSet.next()){
				qty		=	resultSet.getString("DISP_QTY");
				if(qty!=null){	
					if(!qty.equals("")){
						qty1=qty1+Double.parseDouble(qty);
					}
				}
			}
			qty=qty1+"";
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
		return qty;
	}

	public String getStockQuantity(String patient_id,String order_id,String order_line_no,String item_code, String batch_id,String expiry_date,String bin_location) {
		String qty			=	"";
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_det	=	(HashMap)order.get(order_line_no);
					if(drug_det.containsKey("drug_det"))	{
						ArrayList item_det	=	(ArrayList)drug_det.get("drug_det");						
						if(item_det.contains(item_code) && item_det.contains(batch_id) &&  item_det.contains(expiry_date) && item_det.contains(bin_location)) {
							int index	=	item_det.indexOf(batch_id);
							qty			=	(String)item_det.get(index+2);
						}
					}
				}
			}
		}
		return qty;
	}

	public String checkStockQuantity(String patient_id,String order_id,String order_line_no) {
		String item			=	"";
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_det	=	(HashMap)order.get(order_line_no);
					if(drug_det.containsKey("drug_det"))	{
						ArrayList item_det	=	(ArrayList)drug_det.get("drug_det");
						if(item_det.size()!=0) {
							item		=	(String)item_det.get(0);
						}
					}
				}
			}
		}
		return item;
	}


	public String getAlternateStockQuantity(String patient_id,String order_id,String order_line_no,String alt_code,String item_code, String batch_id,String expiry_date,String bin_location) {
		String qty			=	"";
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_det	=	(HashMap)order.get(order_line_no);
					if(drug_det.containsKey("alt_drug_det"))	{
						HashMap item_det	=	(HashMap)drug_det.get("alt_drug_det");
						if(item_det.containsKey(alt_code)) {
							ArrayList qty_det	=	(ArrayList)item_det.get(alt_code);
							if(qty_det.contains(item_code) && qty_det.contains(batch_id) &&  qty_det.contains(expiry_date) && qty_det.contains(bin_location)) {
								int index	=	qty_det.indexOf(batch_id);
								qty	=	(String)qty_det.get(index+2);
							}
						}
					}
				}
			}
		}
		return qty;
	}
	public String checkAlternateStockQuantity(String patient_id,String order_id,String order_line_no,String item_code) {
		String item			=	"";
			if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
				if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
					if(order.containsKey(order_line_no))	{
					HashMap drug_det	=	(HashMap)order.get(order_line_no);
						if(drug_det.containsKey("alt_drug_det"))	{
						HashMap item_det	=	(HashMap)drug_det.get("alt_drug_det");
						if(item_det.containsKey(item_code)) {
							ArrayList qty_det	=	(ArrayList)item_det.get(item_code);
							if(qty_det.size() !=0 ) {
								item	=	(String)qty_det.get(0);
								}
							}
						}
					}
				}
			}
		return item;
	}

	public ArrayList getAlternateDrugLinkReqd(String patient_id,String order_id,String order_line_no, int bms) {
		ArrayList item_qty	=	new ArrayList();
		int  qty			=	0;
		String item_code = "";
		ArrayList qty_det = null;
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_det	=	(HashMap)order.get(order_line_no);
					if(drug_det.containsKey("alt_drug_det"))	{
						HashMap item_det	=	(HashMap)drug_det.get("alt_drug_det");
						Set	key_set		=	item_det.keySet();
						Iterator itr	=	key_set.iterator();
						while(itr.hasNext()) {
							item_code	=	(String)itr.next();
							if(item_det.containsKey(item_code)) {
								qty_det	=	(ArrayList)item_det.get(item_code);
								for(int i=0; i<qty_det.size(); i+=9){
									qty	+=	Integer.parseInt((String)qty_det.get(i+3));
								}
								if(qty_det.size() !=0)
									item_qty.add(item_code);
							}
						}
					}
				}
			}
		}
		if(qty!=bms)
			item_qty	=	new ArrayList();
		return item_qty;
	}

	public int getTotalAlternateStockQty(String patient_id,String order_id,String order_line_no) {
		int  qty			=	0;
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_det	=	(HashMap)order.get(order_line_no);
					if(drug_det.containsKey("alt_drug_det"))	{
						HashMap item_det	=	(HashMap)drug_det.get("alt_drug_det");
						Set	key_set		=	item_det.keySet();
						Iterator itr	=	key_set.iterator();
						while(itr.hasNext()) {
							String item_code	=	(String)itr.next();
							if(item_det.containsKey(item_code)) {
								ArrayList qty_det	=	(ArrayList)item_det.get(item_code);
								for(int i=0; i<qty_det.size(); i+=9){
									qty	+=	Double.valueOf((String)qty_det.get(i+3)).intValue();
								}
							}
						}
					}
				}
			}
		}
		return qty;
	}

	public int getTotalStockQty(String patient_id,String order_id,String order_line_no) {
		int  qty			=	0;
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_det	=	(HashMap)order.get(order_line_no);
					if(drug_det.containsKey("drug_det"))	{
						ArrayList item_det	=	(ArrayList)drug_det.get("drug_det");
						for(int i=0; i<item_det.size(); i+=10){	 //9->10 for MMS-SCF-0040 [IN:041888]
							qty	+=	Double.valueOf((String)item_det.get(i+3)).intValue();
						}
					}
				}
			}
		}
		return qty;
	}

	public void setDrugDetail(String patient_id,String order_id,String order_line_no,ArrayList drug_detail) {
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_det	=	(HashMap)order.get(order_line_no);
					if(drug_det.containsKey("drug_det"))	{
						drug_det.put("drug_det",drug_detail);
					}
				}
			}
		}
	}

	public void setAlternateDrugDetail(String patient_id,String order_id,String order_line_no,ArrayList drug_detail,String alt_drug_code) {
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_record	=	(HashMap)order.get(order_line_no);
					if(drug_record.containsKey("alt_drug_det"))	{
						HashMap drug_det	=	(HashMap)drug_record.get("alt_drug_det");
						drug_det.put(alt_drug_code,drug_detail);
					}
				}
			}
		}
	}

	public void checkAlternateDetail(String patient_id,String order_id,String order_line_no)	{
		ArrayList multi		=	this.getMultiDrugs(patient_id,order_id,order_line_no);

		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_record	=	(HashMap)order.get(order_line_no);
					if(drug_record.containsKey("alt_drug_det"))	{
						HashMap drug_det	=	(HashMap)drug_record.get("alt_drug_det");
						Set	key_set		=	drug_det.keySet();
						Iterator itr	=	key_set.iterator();
						if(itr.hasNext())  {
							String	alt_code	=	(String)itr.next();
							if(!multi.contains(alt_code))
								drug_det.remove(alt_code);
						}
					}
				}
			}
		}
	}

	public String getAlternateDrugQuantity(String patient_id,String order_id,String order_line_no, String alt_drug_code){
		String qty		=	"";
		int quantity	=	0;

		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription!=null && prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order!=null && order.containsKey(order_line_no))	{
					HashMap drug_det	=	(HashMap)order.get(order_line_no);
					if(drug_det!=null && drug_det.containsKey("alt_drug_det"))	{
						HashMap alt_drug_det	=	(HashMap)drug_det.get("alt_drug_det");
						if(alt_drug_det!=null && alt_drug_det.containsKey(alt_drug_code))	{
							ArrayList alt_drug_record	=	(ArrayList) alt_drug_det.get(alt_drug_code);
							if(alt_drug_record!=null && alt_drug_record.size()>0){
								for(int i=0; i<alt_drug_record.size(); i+=10){  //9->10 for MMS-SCF-0040 [IN:041888]
									quantity	+=	Integer.parseInt((String)alt_drug_record.get(i+3));
									//uom		=(String)alt_drug_record.get(i+4);
								}
							}
						}
					}
				}
			}
		}
		if(quantity!=0)
			qty	=	quantity+"";
		return qty;
	}

	public ArrayList getAllAlternateDrugDetail(String patient_id,String order_id,String order_line_no, String alt_drug_code) {
		ArrayList	all_detail	=	new ArrayList();
		multi_drugs	=	this.getMultiDrugs(patient_id,order_id,order_line_no);
		for(int i=0; i<multi_drugs.size(); i+=5)	{
			String 	alt_code	=	(String)multi_drugs.get(i);
			if(!alt_code.equals(alt_drug_code)) {
				ArrayList detail	=	this.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_code);
				if(detail.size() != 0 )
					all_detail.add(detail);
			}
		}
		return all_detail;
	}

	public ArrayList getAlternateDrugDetail(String patient_id,String order_id,String order_line_no, String alt_drug_code) {
		ArrayList	alternate_drug_detail	=	new ArrayList();
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
				if(prescription.containsKey(order_id))	{
					HashMap order	=	(HashMap)prescription.get(order_id);
					if(order.containsKey(order_line_no))	{
					HashMap drug_record	=	(HashMap)order.get(order_line_no);
					if(drug_record.containsKey("alt_drug_det"))	{
						HashMap drug_det	=	(HashMap)drug_record.get("alt_drug_det");
						if(drug_det.containsKey(alt_drug_code))	{
							alternate_drug_detail	=	(ArrayList)drug_det.get(alt_drug_code);
						}
					}
				}
			}
		}
		return alternate_drug_detail;
	}

	public ArrayList getDrugDetail(String patient_id,String order_id,String order_line_no) {

		ArrayList drug_detail		=	new ArrayList();
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap	drug_det	=	(HashMap)order.get(order_line_no);
					drug_detail			=	(ArrayList)drug_det.get("drug_det");
				}
			}
		}
		return drug_detail;
	}

	public boolean getQuantity(String patient_id,String order_id) {
		boolean qty_found	=	false;
		ArrayList drug_detail	=	new ArrayList();
		HashMap	alt_drug_det	=	new HashMap();
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				Set	key_set		=	order.keySet();
				Iterator itr	=	key_set.iterator();
				while(itr.hasNext())  {
					String	order_line_no	=	(String)itr.next();
					if(order.containsKey(order_line_no)) {
						HashMap order_detail	=	(HashMap)order.get(order_line_no);
						if(order_detail.containsKey("drug_det"))
							drug_detail	=	(ArrayList)order_detail.get("drug_det");
						if(order_detail.containsKey("alt_drug_det")) 
							alt_drug_det	=	(HashMap)order_detail.get("alt_drug_det");
						if( (drug_detail.size() > 1) || (alt_drug_det.size() >= 1) ){
							qty_found	=	true;
							break;
						}
					}
				}
			}
		}
		return qty_found;
	}


	public HashMap getCompleteDispense(String patient_id, String order_id) throws Exception {
		ArrayList alloc_detail			=	new ArrayList();
		ArrayList fill_detail			=	new ArrayList();
		ArrayList del_detail			=	new ArrayList();
		ArrayList alloc_detail_tmp		=	new ArrayList();
		ArrayList fill_detail_tmp		=	new ArrayList();
		String filling_status		=	disp_bean.getFillingStatus();
		HashMap dispense			=	new HashMap();

		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				Set	key_set		=	order.keySet();
				Iterator itr	=	key_set.iterator();
				while(itr.hasNext())  {
					String	order_line_no	=	(String)itr.next();
					HashMap order_detail	=	(HashMap)order.get(order_line_no);
					ArrayList drug_detail	=	(ArrayList)order_detail.get("drug_det");
					
					ArrayList alt_detail	=	new ArrayList();
					
					if(order_detail.containsKey("alt_drugs"))
						alt_detail	=	(ArrayList)order_detail.get("alt_drugs");

					if( drug_detail.size()!=0) {
						HashMap	detail	=	new HashMap();
						detail.put("order_id",order_id);						
						detail.put("order_line_no",order_line_no);
						detail.put("pres_drug_code",(String)order_detail.get("drug_code"));
						detail.put("disp_drug_code",(String)order_detail.get("drug_code"));
						detail.put("disp_qty",(String)order_detail.get("tot_qty"));
					if(order_detail.containsKey("stock_disp_uom")) // Added for ML-BRU-SCF-1799 - Start
						detail.put("disp_uom_code", (String)order_detail.get("stock_disp_uom"));
					else // Added for ML-BRU-SCF-1799 - End
						detail.put("disp_uom_code",(String)drug_detail.get(4));
						detail.put("batch_record",(ArrayList)order_detail.get("drug_det"));

						if(filling_status.equals("A")) {
							//if(this.getFilling(patient_id,order_id,order_line_no) && (disp_bean.getDeliveryDetails().size() !=0) )
							if(disp_bean.getDeliveryDetails().size() !=0) {
								fill_detail.add(detail);
								del_detail.add(detail);
							}
							else if(this.getFilling(patient_id,order_id,order_line_no))
								fill_detail_tmp.add(detail);
							else 
								alloc_detail_tmp.add(detail);
						}
						else if(filling_status.equals("B")) {
							//if(this.getFilling(patient_id,order_id,order_line_no) && (disp_bean.getDeliveryDetails().size() !=0) ) 
							if(disp_bean.getDeliveryDetails().size() !=0){
								alloc_detail.add(detail);
								del_detail.add(detail);
							}
							else if(this.getFilling(patient_id,order_id,order_line_no) && (disp_bean.getDeliveryDetails().size() ==0))
								alloc_detail_tmp.add(detail);
							else
								fill_detail_tmp.add(detail);
						}
						else if(filling_status.equals("X")) {
							if(disp_bean.getDeliveryDetails().size() !=0 ) {
									alloc_detail.add(detail);
									del_detail.add(detail);
							}
							else {
								alloc_detail_tmp.add(detail);
							}
						}
					}
					else {
						if(alt_detail.size()!=0) {
							HashMap	alt_drug_det = null;
							HashMap		detail = null;
							String alt_drug_code ,  alt_disp_drug_qty;
							for(int i=0; i<alt_detail.size(); i+=5) {
								alt_drug_code	 =	(String)alt_detail.get(i);
								alt_disp_drug_qty = getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code);
								String temp_alt_drug_qty    =getAlternateDrugQtyForCharge(patient_id,order_id,order_line_no,alt_drug_code); //Added for ML-BRU-SCF-1803 - (Issue Found During Regression)
								if(alt_disp_drug_qty!=null && !alt_disp_drug_qty.equals("")){
									detail	=	new HashMap();
									detail.put("order_id",order_id);						
									detail.put("order_line_no",order_line_no);
									detail.put("pres_drug_code",(String)order_detail.get("drug_code"));
									detail.put("disp_drug_code",alt_drug_code);								
									if( temp_alt_drug_qty !=null && !temp_alt_drug_qty.equals("") && !temp_alt_drug_qty.equals("0"))//Added if else condition for ML-BRU-SCF-1803 - (Issue Found During Regression)
										detail.put("disp_qty",temp_alt_drug_qty);
									else									
									detail.put("disp_qty",getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code));
									detail.put("disp_uom_code",(String)alt_detail.get(i+2));
				
									alt_drug_det	=	(HashMap)order_detail.get("alt_drug_det");
									detail.put("batch_record",(ArrayList)alt_drug_det.get(alt_drug_code));

									if(filling_status.equals("A")) {
										//if(this.getFilling(patient_id,order_id,order_line_no) && (disp_bean.getDeliveryDetails().size() !=0) ) 
										if(disp_bean.getDeliveryDetails().size() !=0) {
											fill_detail.add(detail);
											del_detail.add(detail);
										}
										else if(this.getFilling(patient_id,order_id,order_line_no))
											fill_detail_tmp.add(detail);
										else 
											alloc_detail_tmp.add(detail);
									}
									else if(filling_status.equals("B")) {
										//if(this.getFilling(patient_id,order_id,order_line_no) && (disp_bean.getDeliveryDetails().size() !=0) ) 
										if(disp_bean.getDeliveryDetails().size() !=0){
											alloc_detail.add(detail);
											del_detail.add(detail);
										}
										else if(this.getFilling(patient_id,order_id,order_line_no) && (disp_bean.getDeliveryDetails().size() ==0))
											alloc_detail_tmp.add(detail);
										else
											fill_detail_tmp.add(detail);

									}
									else if(filling_status.equals("X")) {
										if(disp_bean.getDeliveryDetails().size() !=0 ) {
												alloc_detail.add(detail);
												del_detail.add(detail);
										}
										else {
											alloc_detail_tmp.add(detail);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		dispense.put("alloc_detail",alloc_detail);
		dispense.put("fill_detail",fill_detail);
		dispense.put("alloc_detail_tmp",alloc_detail_tmp);
		dispense.put("fill_detail_tmp",fill_detail_tmp);
		dispense.put("del_detail",del_detail);

		return dispense;
	}	


	public HashMap getAllocation(String patient_id,String order_id) throws Exception {
		ArrayList alloc_detail	=	new ArrayList();
		HashMap allocation	=	new HashMap();
		if(patient_det.containsKey(patient_id))	{
				HashMap prescription	=	(HashMap)patient_det.get(patient_id);
				if(prescription.containsKey(order_id))	{
					HashMap order	=	(HashMap)prescription.get(order_id);
					Set	key_set		=	order.keySet();
					Iterator itr	=	key_set.iterator();
					while(itr.hasNext())  {
						String	order_line_no	=	(String)itr.next();
						HashMap order_detail	=	(HashMap)order.get(order_line_no);
						ArrayList drug_detail	=	(ArrayList)order_detail.get("drug_det");
						ArrayList alt_detail	=	new ArrayList();
						
						if(order_detail.containsKey("alt_drugs"))
							alt_detail	=	(ArrayList)order_detail.get("alt_drugs");
						
						if( drug_detail.size()!=0) {
							HashMap	detail	=	new HashMap();
							detail.put("order_id",order_id);						
							detail.put("order_line_no",order_line_no);
							detail.put("pres_drug_code",(String)order_detail.get("drug_code"));
							detail.put("disp_drug_code",(String)order_detail.get("drug_code"));
							detail.put("disp_qty",(String)order_detail.get("tot_qty"));
						if(order_detail.containsKey("stock_disp_uom")) // Added for ML-BRU-SCF-1799 - Start
							detail.put("disp_uom_code", (String)order_detail.get("stock_disp_uom"));
						else // Added for ML-BRU-SCF-1799 - End
							detail.put("disp_uom_code",(String)drug_detail.get(4));
							detail.put("batch_record",(ArrayList)order_detail.get("drug_det"));
							alloc_detail.add(detail);
						}
						else {
							if(alt_detail.size()!=0) {
							  for(int i=0; i<alt_detail.size(); i+=5) {
								String alt_drug_code		=	(String)alt_detail.get(i);
								String alt_drug_disp_qty	=getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code);
								String temp_alt_drug_qty    =getAlternateDrugQtyForCharge(patient_id,order_id,order_line_no,alt_drug_code);//Added for MlBRU-SCF-1803

								if(!alt_drug_disp_qty.equals("")&&alt_drug_disp_qty!=null){
									HashMap		detail	=	new HashMap();
									detail.put("order_id",order_id);						
									detail.put("order_line_no",order_line_no);
									detail.put("pres_drug_code",(String)order_detail.get("drug_code"));
									detail.put("disp_drug_code",alt_drug_code);
									if( temp_alt_drug_qty !=null && !temp_alt_drug_qty.equals("") && !temp_alt_drug_qty.equals("0"))//Added if else condition for ML-BRU-SCF-1803
										detail.put("disp_qty",temp_alt_drug_qty);//modified for ML-MMOH-SCF-2478 //Modified for ML-BRU-SCF-2223  detail.put("disp_qty",alt_drug_disp_qty); // Old - detail.put("disp_qty",temp_alt_drug_qty); 
									else
									    detail.put("disp_qty",getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code));
									detail.put("disp_uom_code",(String)alt_detail.get(i+2));				
									HashMap	alt_drug_det	=	(HashMap)order_detail.get("alt_drug_det");
									detail.put("batch_record",(ArrayList)alt_drug_det.get(alt_drug_code));
									alloc_detail.add(detail);
								}
							}
						}
					}
				}
			}
		}
		allocation.put("detail",alloc_detail);
		return allocation;
	}	

	public HashMap getPatient()	{
		return this.patient_det;
	}

	public void clear() {
		super.clear() ;
		multi_drugs			=	new ArrayList();
		reason				=	new ArrayList();
		reason_vals			=	new HashMap();
		fill_remarks		=	new HashMap();
		delivery_remarks	=	new HashMap();
		allocatefill_remarks=   new HashMap();
		editLabel			=	new HashMap();		
		hold_drugs			=	new ArrayList();
		filling_det			=	new ArrayList();
		forDispensing		=	new Hashtable();
		multi_found			=	false;
		first_time_validate	=	new HashMap();
		drug_stock			=	new HashMap();
		patient_det			=	new HashMap();	// added by raghunath on 28/08/2003
		tpn_qty				=	"";
		tpn_values			=	new ArrayList();
		tpn_qty_uom			=	"";		
		disp_nos			=	new ArrayList();
		fillPersonName		=	"";
		token_vals			=	new HashMap();
        taper				=   "";
		tpn_pres_qty		=   "";
		over_vol			=	"";
		over_vol_uom		=   "";
		//bl_interface_yn		=  "N";
		osmolarity_volume   =  "";
		cons_item_det       =  new ArrayList();
		item_store			=  new HashMap();
		issueUomQty         =  new HashMap();
		charge_dtls		    =  new HashMap();
		noOfPrints		    =  new ArrayList();//Code Added For RUT-CRF-0067 
		hmAltDrugRemarks    =  new HashMap();// Added For Bru-HIMS-CRF-082 [IN:029948]
		hmDrugPenaltyDtls    =  new HashMap();// Added For Bru-HIMS-CRF-082 [IN:029948]
		editableLabel			=	null;		//added for Bru-HIMS-CRF-414 [IN:045554]
		totalPrint           = new HashMap(); // Added for TTMWM-SCF-0184
		orderCheckedYn = new HashMap(); // Added for MMS-KH-CRF-0028 [IN070605]
		//GHL-CRF-0618 - start
		formulary_type = "";  
		formulary_code = "";
		blg_grp_id	   = "";
		itemGenericType	    = new ArrayList();//GHL-CRF-0618
		nonPreferenceRemarks = new HashMap();//GHL-CRF-0618
		//GHL-CRF-0618 - end
		//MMS-KH-CRF-0034.4 - start
		altItem			 = new HashMap();
		addBarcode		 = new HashMap();
		selectedAltDrug	 = new HashMap();
		barcode_scan_qty = new HashMap();
		tot_alt_scan_qty = new HashMap(); 
		refillOrderStr  ="";//Added For MOHE-CRF-0069
		//MMS-KH-CRF-0034.4 - end
		insurance_patient_yn ="";//Added for TH-KW-CRF-0012
		insuranceStatus =new HashMap();//Added for TH-KW-CRF-0012
	}

	public void clearHoldvaluesOnRefresh() {
         hold_drugs			=	new ArrayList();
		 cons_item_det      =   new ArrayList();
		 item_store			=   new HashMap();
		 issueUomQty         =  new HashMap();
		// first_time_validate =	new HashMap();
   }

   public void clearPatient(String patient_id)	{
		if(patient_det.containsKey(patient_id))	{
			patient_det.remove(patient_id);
		}
	}

	public void clearPrescription(String patient_id,String order_id) {
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				prescription.remove(order_id);				
			}
		}
        cons_item_det		= new ArrayList();
	}

	public void clearDrugDet(String patient_id,String order_id, String order_line_no) {
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_detail	=	(HashMap)order.get(order_line_no);
					if(drug_detail.containsKey("drug_det")) {
						drug_detail.put("drug_det",new ArrayList());
						drug_detail.put("tot_qty","");
						if(drug_detail.containsKey("alt_drug_det"))
							drug_detail.put("alt_drug_det",new HashMap());
					}
				}
			}
		}
	}


	public void clearAltDrugs(String patient_id,String order_id, String order_line_no) {
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_detail	=	(HashMap)order.get(order_line_no);
					if(drug_detail.containsKey("alt_drugs")) {
						drug_detail.put("alt_drugs",new ArrayList());
					}
				}	
			}
		}
	}

	public void setMultiDrugs(String patient_id,String order_id, String order_line_no,ArrayList multi_drugs)	{
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_detail	=	(HashMap)order.get(order_line_no);
					drug_detail.put("alt_drugs",multi_drugs);
					drug_detail.put("drug_det",new ArrayList());
					drug_detail.put("tot_qty","");
				}
			}
		}
	}

	public ArrayList getMultiDrugs(String patient_id,String order_id,String order_line_no) {
		ArrayList alt_drugs	=	new ArrayList();

		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
			HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
				HashMap drug_detail	=	(HashMap)order.get(order_line_no);
					if(drug_detail.containsKey("alt_drugs")) {
						alt_drugs	=	(ArrayList)drug_detail.get("alt_drugs");
					}
				}
			}
		}
		return alt_drugs;
	}

	public String getDebug() {
		return this.debug;
	}

	public void loadReason() throws Exception{

	   	Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String reason_code		=	"";
		String reason_desc		=	"";
		String sys_date			=	"";
		String sys_date_time	=	"";
		//String remarks			=   "";
		reason		=	new ArrayList();
		try {

            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT15")) ;
			pstmt.setString(1,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				reason_code		=	resultSet.getString("REASON_CODE");
				reason_desc		=	resultSet.getString("REASON_DESC");
				//remarks      	=	resultSet.getString("REMARKS");
				//if(remarks==null)
					 //remarks="";
				reason.add(reason_code);
				reason.add(reason_desc);
				//reason.add(remarks);
			}

			pstmt		= null;
			resultSet	= null;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT25")) ;
			resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				sys_date		=	resultSet.getString("TODAY");
				sys_date_time	=	resultSet.getString("TODAY_DATE_TIME");
			}
			this.setCurrDate(sys_date);
			this.setCurrDateTime(sys_date_time);

		}catch ( Exception e ) {
			e.printStackTrace() ;
			reason.add(e);
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
	}

	public boolean checkTokenSeries(String disp_locn) throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		boolean token_yn			= false;
		try {

            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT51")) ;
			pstmt.setString(1,disp_locn);
			pstmt.setString(2,login_facility_id);
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				token_yn		=	true;
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}	
		return token_yn;
	}

	public boolean checkStock(String drug_code,String store_code, String qty_reqd,String eff_date) throws Exception {
		Connection connection		=null;
        PreparedStatement pstmt		=null;
		PreparedStatement pstmt1	=null;
        ResultSet resultSet			=null;
		ResultSet resultSet_1		=null;
		CallableStatement cstmt		=null ;
		String item_code			="";
		boolean item_found			=false;
		try {
			connection	= getConnection() ;
			pstmt		=	connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT55"));
			pstmt1		=	connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT63"));
			pstmt.setString(1,drug_code);
			resultSet	=	pstmt.executeQuery();

			while(resultSet.next()) {
				item_code	=	resultSet.getString("INVENTORY_ITEM_CODE");
				pstmt1.setString(1,item_code);
				resultSet_1	=	pstmt1.executeQuery();
				if(resultSet_1.next()) {
					item_found	=	true;
					break;
				}
			}
			closeResultSet( resultSet ) ;
			closeResultSet( resultSet_1);
			closeStatement( pstmt ) ;
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeResultSet( resultSet_1);
			closeStatement( pstmt ) ;
			closeStatement( pstmt1 );
			closeStatement( cstmt ) ;
			closeConnection( connection ); 
		}	
		return item_found;
	}

	public String getItemCost(String item_code,String store_code, String qty_reqd,String eff_date) throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		CallableStatement cstmt = null ;
		String item_cost		=	"";
		try {
			connection	= getConnection() ;
			cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, item_code );
			cstmt.setString( 2, store_code );
			cstmt.setString( 3, qty_reqd );
			cstmt.setString( 4, "N" );
			cstmt.setString( 5, eff_date);
			cstmt.setString( 6, "Y");
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
			item_cost	=	(String)(cstmt.getString(10));
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection ); 
		}
		return item_cost;
	}

	public String getStoreDesc(String store_code) throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String store_desc		=	"";
		try {

            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT39")) ;
			pstmt.setString(1,store_code);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				store_desc		=	resultSet.getString("STORE_DESC");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return store_desc;
	}

	public String getPatientClass(String disp_no) throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String patient_class	=	"";
		try {

            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT69")) ;
			pstmt.setString(1,disp_no);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				patient_class		=		resultSet.getString("PATIENT_CLASS");
				patient_class		= patient_class +	"::"+resultSet.getString("PATIENT_ID");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return patient_class;
	}

	public HashMap getDB_DrugDetail(String order_id,String order_line_no,String end_date) throws Exception {
	
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ResultSet resultSet_1	= null;

		String disp_drug_code		=	"";
		String item_code			=	"";
		String batch_id				=	"";
		String expiry_date			=	"";
		String disp_qty				=	"";
		String disp_qty_uom			=	"";
		String drug_desc			=	"";
		String form_code			=	"";
		String strength_value		=	"";
		String strength_uom			=	"";
		String bin_location_code	=	"";
		String trade_id				=	"";
		String item_cost			=	"";
		String drug_code			=	"", base_uom="";

		HashMap	drug_detail			=	new HashMap();
		HashMap alt_detail			=	new HashMap();
		ArrayList multi_drug_detail	=	new ArrayList();
		ArrayList gen_drug_detail	=	new ArrayList();
		ArrayList unique_drugs		=	new ArrayList();
		boolean proceed				=	true;
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT65")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				if(resultSet.getString("COUNT").equals("0"))
					proceed		=	false;
			}
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			
			if(proceed) {
				pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT46")) ;
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_no);
				pstmt.setString(3,getLanguageId());
				resultSet	= pstmt.executeQuery() ;
				while(resultSet.next()){
						
					disp_drug_code	=	checkForNull(resultSet.getString("DISP_DRUG_CODE"));
					drug_desc		=	checkForNull(resultSet.getString("DRUG_DESC"));
					form_code		=	checkForNull(resultSet.getString("FORM_CODE"));
					strength_value	=	checkForNull(resultSet.getString("STRENGTH_VALUE"));
					strength_uom	=	checkForNull(resultSet.getString("STRENGTH_UOM"));

					multi_drug_detail.add(disp_drug_code);
					multi_drug_detail.add(drug_desc);
					multi_drug_detail.add(form_code);
					multi_drug_detail.add(strength_value);
					multi_drug_detail.add(strength_uom);
				}
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;

			}
		/*	pstmt		=	null;
			resultSet	=	null;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT58")) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()) {
//				doc_no		=	checkForNull(resultSet.getString("DOC_NO"));
//				doc_type	=	checkForNull(resultSet.getString("DOC_TYPE"));
			}*/
		
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT45")) ;
			//pstmt		= connection.prepareStatement("SELECT a.drug_code, a.item_code, a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date, disp_qty, disp_qty_uom, order_id, order_line_num, b.bin_location_code, b.trade_id FROM ph_disp_drug_batch_tmp a, st_item_batch b WHERE a.store_code = b.store_code AND a.item_code = b.item_code AND a.batch_id = b.batch_id AND a.expiry_date = b.expiry_date_or_receipt_date AND a.bin_location_code = b.bin_location_code  AND order_id = ? AND order_line_num = ? ORDER BY order_id, order_line_num") ; 

			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
            resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				drug_code			=	checkForNull(resultSet.getString("DRUG_CODE"));
				item_code			=	checkForNull(resultSet.getString("ITEM_CODE"));
				batch_id			=	checkForNull(resultSet.getString("BATCH_ID"));
				expiry_date			=	checkForNull(resultSet.getString("EXPIRY_DATE"));
				disp_qty			=	checkForNull(resultSet.getString("DISP_QTY"));
				disp_qty_uom		=	checkForNull(resultSet.getString("DISP_QTY_UOM"));
				bin_location_code	=	checkForNull(resultSet.getString("BIN_LOCATION_CODE"));
				trade_id			=	checkForNull(resultSet.getString("TRADE_ID"));
				base_uom			=	checkForNull(resultSet.getString("GEN_UOM_CODE"));
				item_cost			=	getItemCost(item_code,disp_bean.getStoreCode(),disp_qty,end_date);
				if(multi_drug_detail.size() > 1) {			
					if(!unique_drugs.contains(drug_code)) {
						gen_drug_detail	=	new ArrayList();
						unique_drugs.add(drug_code);

						gen_drug_detail.add(item_code);	//0
						gen_drug_detail.add(batch_id);	//1
						gen_drug_detail.add(expiry_date);	//2
						gen_drug_detail.add(disp_qty);	//3
						gen_drug_detail.add(disp_qty_uom);	//4
						gen_drug_detail.add("");	//6
						gen_drug_detail.add(trade_id);	//7
						gen_drug_detail.add(bin_location_code);	//8
						gen_drug_detail.add(item_cost);	//9
						gen_drug_detail.add(base_uom);	//9 //item_cost is changed as base_uom for [IN:049778]
						alt_detail.put(drug_code,gen_drug_detail);
					}
					else {
						gen_drug_detail.add(item_code);
						gen_drug_detail.add(batch_id);
						gen_drug_detail.add(expiry_date);
						gen_drug_detail.add(disp_qty);
						gen_drug_detail.add(disp_qty_uom);
						gen_drug_detail.add("");
						gen_drug_detail.add(trade_id);
						gen_drug_detail.add(bin_location_code);
						gen_drug_detail.add(item_cost); //9
						gen_drug_detail.add(base_uom); //9//item_cost is changed as base_uom for [IN:049778]
						alt_detail.put(drug_code,gen_drug_detail);
					}
				} 
				else {
					gen_drug_detail.add(item_code);
					gen_drug_detail.add(batch_id);
					gen_drug_detail.add(expiry_date);
					gen_drug_detail.add(disp_qty);
					gen_drug_detail.add(disp_qty_uom);
					gen_drug_detail.add("");
					gen_drug_detail.add(trade_id);
					gen_drug_detail.add(bin_location_code);
					gen_drug_detail.add(item_cost); //8
					gen_drug_detail.add(base_uom); //9//item_cost is changed as base_uom for [IN:049778]
				}
			}
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			drug_detail.put("multi_detail",multi_drug_detail);
			drug_detail.put("main_detail",gen_drug_detail);
			drug_detail.put("alt_detail",alt_detail);

		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeResultSet( resultSet_1) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}

		return drug_detail;
	}

	public ArrayList getItemAndTradeName(String item_code, String batch_id) throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String	trade_name		=	"";
		String manufacturer_name =	"";
		ArrayList item_det		=	new ArrayList();
		try {

            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT44")) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,item_code);
			pstmt.setString(3,batch_id);
			pstmt.setString(4,getLanguageId());
			pstmt.setString(5,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				trade_name				=	checkForNull(resultSet.getString("TRADE_NAME"));
				manufacturer_name		=	checkForNull(resultSet.getString("MANUFACTURER_NAME"));
				
				item_det.add(trade_name);
				item_det.add(manufacturer_name);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return item_det;
	}

	public LinkedHashMap getStockAlternateDrugs(String store_code,String qty_reqd, String eff_expiry, String generic_id, String drug,String strength_val,String main_screen_alt_yn) throws Exception {//HashMap changed to LinkedHashMap for MMS-DM-CRF-0009 [IN:054440]
		Connection connection			=   null;
        PreparedStatement pstmt			=   null;
        ResultSet resultSet				=   null;
		String drug_code				=	"";
		String drug_desc				=	"";
		String strength_value			=	"";
		String strength_uom				=	"";
		String form_code				=	"";
		String form_desc				=	"";
		String item_code				=	"";
		String item_desc				=	"";
		String avail_qty				=	"";
		String prev_drug_code			=	"";
		String external_product_id		=	"";
		String stock_uom				= "";   //newly added for ML-BRU-SCF-0179 [IN:032578]
		HashMap	drug_detail				=	new HashMap();
		LinkedHashMap alt_drugs				=	new LinkedHashMap(); //HashMap changed to LinkedHashMap for MMS-DM-CRF-0009 [IN:054440]
		ArrayList item_detail			=	new ArrayList();
		ArrayList qty_detail			=	new ArrayList();
		String multi_strengh_applicable=displayByMultiStrength(drug);//ADDED FOR GHL-CRF-0548
		try {
            connection	= getConnection() ;
           // pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_QUEUE_MGMT_SELECT34")) ;// AND A.DISP_MULTI_STRENGTH_YN='Y' REMOVED
	    
            if(multi_strengh_applicable.equals("S")){
            pstmt		= connection.prepareStatement("SELECT A.DRUG_CODE, A.GENERIC_ID, A.DRUG_DESC, ph_get_ext_prod_drug_code(a.drug_code,?)EXTERNAL_PRODUCT_ID , A.STRENGTH_VALUE, A.STRENGTH_UOM, c.SHORT_DESC, A.FORM_CODE, d.FORM_DESC, A.ROUTE_CODE, e.ROUTE_DESC ,f.INVENTORY_ITEM_CODE, (SELECT SHORT_DESC FROM MM_ITEM_LANG_VW WHERE ITEM_CODE=f.INVENTORY_ITEM_CODE AND LANGUAGE_ID = ? ) ITEM_DESCRIPTION, Ph_Ret_Stock_Avail_Status(F.INVENTORY_ITEM_CODE,?,?,'Y', ? ,'N',NULL ) AVAILABLE_QTY ,A.STOCK_UOM FROM PH_DRUG_LANG_VW A,PH_DRUG_LANG_VW B,am_uom_LANG_VW c,ph_form_LANG_VW d,ph_route_LANG_VW e,PH_INVENTORY_ITEM_FOR_DRUG f WHERE A.GENERIC_ID=B.GENERIC_ID AND A.ROUTE_CODE=B.ROUTE_CODE AND (( B.DISP_ALT_FORM_YN='N' AND b.FORM_code=a.form_code ) OR B.DISP_ALT_FORM_YN='Y') AND a.STRENGTH_UOM=c.uom_code AND d.form_code=a.form_code AND a.route_code=e.route_code AND ( EXISTS (SELECT 'Y' FROM am_uom_eqvl WHERE uom_code = a.strength_uom AND eqvl_uom_code = b.strength_uom UNION SELECT 'Y' FROM am_uom_eqvl WHERE uom_code = b.strength_uom AND eqvl_uom_code = a.strength_uom ) or a.strength_uom = b.strength_uom) AND A.STRENGTH_VALUE<>0 AND A.DRUG_CODE=f.DRUG_CODE(+) AND A.GENERIC_ID=? AND B.DRUG_CODE=? AND a.NPB_DRUG_YN <>'Y'      and a.strength_value = ? AND a.language_id = b.language_id AND a.language_id = c.language_id AND a.language_id = d.language_id AND a.language_id = e.language_id AND a.language_id = ? order by to_number(nvl(available_qty,0))desc, A.DRUG_DESC");
	        }
	        else{
	        	
	       
            pstmt		= connection.prepareStatement("SELECT A.DRUG_CODE, A.GENERIC_ID, A.DRUG_DESC, ph_get_ext_prod_drug_code(a.drug_code,?)EXTERNAL_PRODUCT_ID , A.STRENGTH_VALUE, A.STRENGTH_UOM, c.SHORT_DESC, A.FORM_CODE, d.FORM_DESC, A.ROUTE_CODE, e.ROUTE_DESC ,f.INVENTORY_ITEM_CODE, (SELECT SHORT_DESC FROM MM_ITEM_LANG_VW WHERE ITEM_CODE=f.INVENTORY_ITEM_CODE AND LANGUAGE_ID = ? ) ITEM_DESCRIPTION, Ph_Ret_Stock_Avail_Status(F.INVENTORY_ITEM_CODE,?,?,'Y', ? ,'N',NULL ) AVAILABLE_QTY ,A.STOCK_UOM FROM PH_DRUG_LANG_VW A,PH_DRUG_LANG_VW B,am_uom_LANG_VW c,ph_form_LANG_VW d,ph_route_LANG_VW e,PH_INVENTORY_ITEM_FOR_DRUG f WHERE A.GENERIC_ID=B.GENERIC_ID AND A.ROUTE_CODE=B.ROUTE_CODE AND (( B.DISP_ALT_FORM_YN='N' AND b.FORM_code=a.form_code ) OR B.DISP_ALT_FORM_YN='Y') AND a.STRENGTH_UOM=c.uom_code AND d.form_code=a.form_code AND a.route_code=e.route_code AND ( EXISTS (SELECT 'Y' FROM am_uom_eqvl WHERE uom_code = a.strength_uom AND eqvl_uom_code = b.strength_uom UNION SELECT 'Y' FROM am_uom_eqvl WHERE uom_code = b.strength_uom AND eqvl_uom_code = a.strength_uom ) or a.strength_uom = b.strength_uom) AND A.STRENGTH_VALUE<>0 AND A.DRUG_CODE=f.DRUG_CODE(+) AND A.GENERIC_ID=? AND B.DRUG_CODE=? AND a.NPB_DRUG_YN <>'Y' AND a.language_id = b.language_id AND a.language_id = c.language_id AND a.language_id = d.language_id AND a.language_id = e.language_id AND a.language_id = ? order by to_number(nvl(available_qty,0))desc, A.DRUG_DESC");
	        }
            pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,store_code);
			pstmt.setString(4,qty_reqd);
			pstmt.setString(5,eff_expiry);
			pstmt.setString(6,generic_id);
			pstmt.setString(7,drug);
			  if(multi_strengh_applicable.equals("S")){
				  pstmt.setString(8,strength_val);
				  pstmt.setString(9,getLanguageId());
			  }
			  else
				  pstmt.setString(8,getLanguageId());

            resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				drug_code				=	resultSet.getString("DRUG_CODE");
				if((!drug.equals(drug_code) && main_screen_alt_yn.equals("Y")) || main_screen_alt_yn.equals("N") ){ //if added for MMS-KH-CRF-0030
						drug_desc				=	resultSet.getString("DRUG_DESC");
						strength_value			=	checkForNull(resultSet.getString("STRENGTH_VALUE"));
						strength_uom			=	checkForNull(resultSet.getString("STRENGTH_UOM"));
						form_code				=	checkForNull(resultSet.getString("FORM_CODE"));
						form_desc				=	checkForNull(resultSet.getString("FORM_DESC"));
						item_code				=	checkForNull(resultSet.getString("INVENTORY_ITEM_CODE"));
						item_desc				=	checkForNull(resultSet.getString("ITEM_DESCRIPTION"));
						avail_qty				=	checkForNull(resultSet.getString("AVAILABLE_QTY"));
						external_product_id		=	checkForNull(resultSet.getString("EXTERNAL_PRODUCT_ID"));
						stock_uom				=   checkForNull(resultSet.getString("STOCK_UOM"));  //newly added for ML-BRU-SCF-0179 [IN:032578]
					if(!avail_qty.equals("")) {
						if(!drug_code.equals(prev_drug_code)) {
							drug_detail		=	new HashMap();
							item_detail		=	new ArrayList();
							qty_detail		=	new ArrayList();

							item_detail.add(item_code);
							item_detail.add(item_desc);
							qty_detail.add(avail_qty);

							drug_detail.put("DRUG_CODE",drug_code);
							drug_detail.put("DRUG_DESC",drug_desc);
							drug_detail.put("STRENGTH_VALUE",strength_value);
							drug_detail.put("STRENGTH_UOM",strength_uom);
							drug_detail.put("FORM_CODE",form_code);
							drug_detail.put("FORM_DESC",form_desc);
							drug_detail.put("ITEM",item_detail);
							drug_detail.put("AVAIL_QTY",qty_detail);
							drug_detail.put("EXTERNAL_PRODUCT_ID",external_product_id);
							drug_detail.put("STOCK_UOM",stock_uom);   //newly added for ML-BRU-SCF-0179 [IN:032578]
							prev_drug_code	=	drug_code;
						}
						else {
							item_detail.add(item_code);
							item_detail.add(item_desc);
							qty_detail.add(avail_qty);

							drug_detail.put("AVAIL_QTY",qty_detail);
							drug_detail.put("ITEM",item_detail);
						}
						alt_drugs.put(drug_code,drug_detail);
					}
				}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return alt_drugs;
	}

	public ArrayList loadItems(String drug_code) throws Exception{
		
	   	Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String item_code		=	"";
		String item_desc		=	"";
		ArrayList items			=	new ArrayList();
		try {

            connection	= getConnection() ;
			if(disp_bean.getAdmixtureType().equals("S")){
				pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT37A")) ;
			}
			else{
				pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT37")) ;
			}
			pstmt.setString(1,drug_code);
			pstmt.setString(2,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				item_code		=	resultSet.getString("ITEM_CODE");
				item_desc		=	resultSet.getString("ITEM_DESC");
				items.add(item_code);
				items.add(item_desc);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			items.add(e);
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return items;
	}

	private void doCommon() throws Exception {
	}

	/* Over-ridden Adapter methods end here */

	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

	// setAll method to set all the values
	public void setAll(Hashtable recordSet) {
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		forDispensing = recordSet;
	}

	public HashMap modify() {
		HashMap map=new HashMap();
		map = completeDispensing();			
		return map;
	}

	public HashMap completeDispensing(){
		if(alSalDocDtls !=null && alSalDocDtls.size()>0)
			alSalDocDtls.clear(); 
			
		System.out.println("2319 completeDispensing");
			String login_id=login_by_id;  // Added for RUT-CRF-0035 [IN029926]  -- begin 
			if("Y".equals(getUserAuthPINRequiredYN())){  // Based on this flag, the User ID Captured with PIN will be updated
				login_by_id=getAuthUserID();
			} //  RUT-CRF-0035 [IN029926]  -- end 
		HashMap map=new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in modify.." ) ;
		map.put( "flag", "0" ) ;		
		String filling_status		=	"";
		String seq_first			=	"";
		String seq_second			=	"";
		String first_status			=	"";
		String sec_status			=	"";
		String order_id				=   "";
		String order_line_num		=   "";
		//DispMedicationHome   home	= null;
		//DispMedicationRemote remote	= null;
		try{
			ArrayList orderLineData				= new ArrayList() ;
			ArrayList orderLineData1			= new ArrayList() ;
			ArrayList patientDrugProfileData	= new ArrayList() ;
			ArrayList resultStatusFlags			= new ArrayList() ;
			ArrayList dispAllocTMP				= new ArrayList();
			ArrayList dispFillTMP				= new ArrayList();
			ArrayList dispAlloc					= new ArrayList();
			ArrayList dispFill					= new ArrayList();
			ArrayList dispDel					= new ArrayList();
			HashMap dispense					= new HashMap();
			HashMap tabData						= new HashMap();
			HashMap sqlMap						= new HashMap();
			ArrayList unique_orders				= new ArrayList();
			ArrayList not_allocated				= new ArrayList();
			HashMap complete_status				= new HashMap();
			HashMap order_quanties				= new HashMap();
			HashMap alloc_complete_status		= new HashMap();
			HashMap complete_order_reason		= new HashMap();
			//String tapered_yn, taper_order_id, taper_order_line_num, taper_order, taper_ord_status=""; //Commented for RUT-CRF-0088 [IN036978]
			HashMap alloc_bms_chk				= new HashMap();// Added for MO-GN-5434 [IN:043669] start
			ArrayList alBMSOrderValues			= new ArrayList();
			ArrayList alBMSOrderIds				= new ArrayList();
			HashMap hmBMSValues					= new HashMap();
			String sBMSQty						= "0";
			String alloc_bms_chk_val_temp ="N";//Added for MO-GN-5434 [IN:043669] end // Changed for ML-BRU-SCF-1187 [IN:045600]
			HashMap alloc_bms_chk_val 			=new HashMap();
			
			filling_status				=	disp_bean.getFillingStatus();

			if(filling_status.equals("A")) {
			   seq_first	=	"fill_status";
			   seq_second	=	"alloc_status";
			   first_status	=	"IP";
			   sec_status	=	"AL";
			}
			else if(filling_status.equals("B")) {
			   seq_first	=	"alloc_status";
			   seq_second	=	"fill_status";
			   first_status	=	"AL";
			   sec_status	=	"IP";
			}
			for(int i=0;i<forDispensing.size();i++){
				alloc_bms_chk_val_temp ="N";
				if(forDispensing.containsKey("order_line_num"+(i+1)) && ((String)forDispensing.get("deliveryChecked_"+(i+1))).equals("Y")){ // && ((String)forDispensing.get("deliveryChecked_"+(i+1))).equals("Y") added for MMS-KH-CRF-0028 [IN070605] 
					//Commented for RUT-CRF-0088 [IN036978]
					/*tapered_yn =forDispensing.get("taper_order_yn"+(i+1))==null?"":(String)forDispensing.get("taper_order_yn"+(i+1));   //Commented for RUT-CRF-0088 [IN036978] 
					taper_order_id=forDispensing.get("taper_order_id"+(i+1))==null?"":(String)forDispensing.get("taper_order_id"+(i+1));
					taper_order_line_num =forDispensing.get("taper_order_line_num"+(i+1))==null?"":(String)forDispensing.get("taper_order_line_num"+(i+1));
					taper_order="N";
					if(tapered_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){
						for(int ordL=0; ordL<orderLineData.size();ordL+=10){
							if(((String)orderLineData.get(ordL+3)).equals(taper_order_id) && ((String)orderLineData.get(ordL+4)).equals(taper_order_line_num)){
								taper_order="Y";
								break;
							}
						}
					}
					else
						taper_order="N";*/
					// Added for MO-GN-5434 [IN:043669] start
					if(disp_bean.disp_level.equals("P")){
						order_id =(String)forDispensing.get("order_id"+(i+1));
					} 
					else {
						order_id =(String)forDispensing.get("order_id");
					}
					if(forDispensing.containsKey("alloc_bms_chk_"+(i+1))){
						alloc_bms_chk_val_temp =forDispensing.get("alloc_bms_chk_"+(i+1)) == null?"":(String)forDispensing.get("alloc_bms_chk_"+(i+1));// Added for [IN:045295] start //alloc_bms_chk_val_temp Changed for ML-BRU-SCF-1187 [IN:045600]
						if(disp_bean.disp_level.equals("P") && alloc_bms_chk_val_temp.equals("Y")) {
							alloc_bms_chk_val.put(((String)forDispensing.get("order_id"+(i+1)))+((String)forDispensing.get("order_line_num"+(i+1))),"Y"); // Changed for ML-BRU-SCF-1187 [IN:045600]
						}
						else{
							alloc_bms_chk_val.put(((String)forDispensing.get("order_id")+(i+1))+((String)forDispensing.get("order_line_num"+(i+1))),"N"); // Changed for ML-BRU-SCF-1187 [IN:045600]
						}
					}
					else{
						alloc_bms_chk_val.put(((String)forDispensing.get("order_id"+(i+1)))+((String)forDispensing.get("order_line_num"+(i+1))),"N"); // Changed for ML-BRU-SCF-1187 [IN:045600]
					} 
					if(forDispensing.get("bms_qty"+(i+1)) != null && (((String)forDispensing.get("allocateyn_"+(i+1))).equals("Y") || alloc_bms_chk_val_temp.equals("Y"))){
						sBMSQty = forDispensing.get("bms_qty"+(i+1)).toString();
						hmBMSValues.put(order_id+"~"+forDispensing.get("order_line_num"+(i+1)).toString(),sBMSQty);
						if( Double.parseDouble(sBMSQty) > 0){
							alBMSOrderValues	= new ArrayList();
							alBMSOrderValues.add(order_id);
							alBMSOrderValues.add((String)forDispensing.get("order_line_num"+(i+1)));
							alBMSOrderIds.add(alBMSOrderValues);
							disp_bean.setAlBMSOrderIds(alBMSOrderIds);
						}
					}
					else
						hmBMSValues.put(order_id+"~"+forDispensing.get("order_line_num"+(i+1)).toString(),"0");		//Added for MO-GN-5434 [IN:043669] end
				if(forDispensing.get("hold"+(i+1))==null || ((String)forDispensing.get("hold"+(i+1))).equals("")){
					if( forDispensing.get("alloc_status"+(i+1))!=null && forDispensing.get("fill_status"+(i+1))!=null) {
						//if( ((((String)forDispensing.get("alloc_status"+(i+1))).equals("P") || ((String)forDispensing.get("fill_status"+(i+1))).equals("P")) && (((String)forDispensing.get("del_detail"+(i+1))).equals("Y")))|| taper_order.equals("Y") ){   //Commented for RUT-CRF-0088 [IN036978] 
						if( ((((String)forDispensing.get("alloc_status"+(i+1))).equals("P") || ((String)forDispensing.get("fill_status"+(i+1))).equals("P")) && (((String)forDispensing.get("del_detail"+(i+1))).equals("Y"))) ){
							orderLineData.add("N");						// N - Not Hold and allocated				
							patientDrugProfileData.add("N");			
						}
						else{
							orderLineData.add("NN");					// NN - Not Hold and Not Allocated
							patientDrugProfileData.add("NN");
							
							alloc_bms_chk_val_temp = (String)alloc_bms_chk_val.get(order_id+forDispensing.get("order_line_num"+(i+1)));// Added for ML-BRU-SCF-1187 [IN:045600]
							if(disp_bean.disp_level.equals("P") && (alloc_bms_chk_val_temp == null || alloc_bms_chk_val_temp.equals("N"))) { //alloc_bms_chk_val_temp Changed for ML-BRU-SCF-1187 [IN:045600]
								not_allocated.add((String)forDispensing.get("order_id"+(i+1))+(String)forDispensing.get("order_line_num"+(i+1)));
							} 
							else if(alloc_bms_chk_val_temp==null || alloc_bms_chk_val_temp.equals("N")){ //alloc_bms_chk_val_temp Changed for ML-BRU-SCF-1187 [IN:045600]
								not_allocated.add((String)forDispensing.get("order_id")+(String)forDispensing.get("order_line_num"+(i+1)));
							}
							// Added for MO-GN-5434 [IN:043669] start
							if(forDispensing.containsKey("alloc_bms_chk_"+(i+1))){
								if(disp_bean.disp_level.equals("P")) {
									alloc_bms_chk.put(((String)forDispensing.get("order_id"+(i+1)))+((String)forDispensing.get("order_line_num"+(i+1))),(String)forDispensing.get("alloc_bms_chk_"+(i+1)));
								}
								else{
									alloc_bms_chk.put(((String)forDispensing.get("order_id"))+((String)forDispensing.get("order_line_num"+(i+1))),(String)forDispensing.get("alloc_bms_chk_"+(i+1)));
								}
							}//Added for MO-GN-5434 [IN:043669] end
						}
					}
					else if( forDispensing.get("alloc_status"+(i+1))==null && forDispensing.get("fill_status"+(i+1))!=null) {
						if( (((String)forDispensing.get("fill_status"+(i+1))).equals("P")) && (((String)forDispensing.get("del_detail"+(i+1))).equals("Y"))){
							orderLineData.add("N");						// N - Not Hold and allocated				
							patientDrugProfileData.add("N");			
						}
						else{
							orderLineData.add("NN");					// NN - Not Hold and Not Allocated
							patientDrugProfileData.add("NN");
							alloc_bms_chk_val_temp = (String)alloc_bms_chk_val.get(order_id+forDispensing.get("order_line_num"+(i+1))); // Added for ML-BRU-SCF-1187 [IN:045600]
							if(disp_bean.disp_level.equals("P") && (alloc_bms_chk_val_temp==null || alloc_bms_chk_val_temp.equals("N"))) { // && alloc_bms_chk_val.equals("N") Added for MO-GN-5434 [IN:043669] //alloc_bms_chk_val_temp Changed for ML-BRU-SCF-1187 [IN:045600]
								not_allocated.add((String)forDispensing.get("order_id"+(i+1))+(String)forDispensing.get("order_line_num"+(i+1)));
							}
							else if(alloc_bms_chk_val_temp==null || alloc_bms_chk_val_temp.equals("N")){  // && alloc_bms_chk_val.equals("N") Added for MO-GN-5434 [IN:043669]
								not_allocated.add((String)forDispensing.get("order_id")+(String)forDispensing.get("order_line_num"+(i+1)));
							}

						}
					}
					else if( forDispensing.get("alloc_status"+(i+1))!=null && forDispensing.get("fill_status"+(i+1))==null) {
						if( (((String)forDispensing.get("alloc_status"+(i+1))).equals("P")) && (((String)forDispensing.get("del_detail"+(i+1))).equals("Y")) ){
							orderLineData.add("N");						// N - Not Hold and allocated				
							patientDrugProfileData.add("N");			
						}
						else{
							orderLineData.add("NN");					// NN - Not Hold and Not Allocated
							patientDrugProfileData.add("NN");
							alloc_bms_chk_val_temp = (String)alloc_bms_chk_val.get(order_id+forDispensing.get("order_line_num"+(i+1))); // Added for ML-BRU-SCF-1187 [IN:045600]
							if(disp_bean.disp_level.equals("P") && (alloc_bms_chk_val_temp==null || alloc_bms_chk_val_temp.equals("N"))) {  // && alloc_bms_chk_val.equals("N") Added for MO-GN-5434 [IN:043669] //alloc_bms_chk_val_temp Changed for ML-BRU-SCF-1187 [IN:045600]
								not_allocated.add((String)forDispensing.get("order_id"+(i+1))+(String)forDispensing.get("order_line_num"+(i+1)));
							} 
							else if(alloc_bms_chk_val_temp==null || alloc_bms_chk_val_temp.equals("N")){  // && alloc_bms_chk_val.equals("N") Added for MO-GN-5434 [IN:043669]
								not_allocated.add((String)forDispensing.get("order_id")+(String)forDispensing.get("order_line_num"+(i+1)));
							}
						}
					}
				}
				else{
					orderLineData.add("Y");							// Y - Hold
					patientDrugProfileData.add("Y");
					alloc_bms_chk_val_temp = (String)alloc_bms_chk_val.get(order_id+forDispensing.get("order_line_num"+(i+1))); // Added for ML-BRU-SCF-1187 [IN:045600]
					if(disp_bean.disp_level.equals("P") && (alloc_bms_chk_val_temp==null || alloc_bms_chk_val_temp.equals("N"))) {  // && alloc_bms_chk_val.equals("N") Added for MO-GN-5434 [IN:043669] //alloc_bms_chk_val_temp Changed for ML-BRU-SCF-1187 [IN:045600]
						not_allocated.add((String)forDispensing.get("order_id"+(i+1))+(String)forDispensing.get("order_line_num"+(i+1)));
					} 
					else if(alloc_bms_chk_val_temp==null || alloc_bms_chk_val_temp.equals("N")){  // && alloc_bms_chk_val.equals("N") Added for MO-GN-5434 [IN:043669] //alloc_bms_chk_val_temp Changed for ML-BRU-SCF-1187 [IN:045600]
						not_allocated.add((String)forDispensing.get("order_id")+(String)forDispensing.get("order_line_num"+(i+1)));
					}
				}

				orderLineData.add(login_by_id.trim());
				patientDrugProfileData.add(login_by_id.trim());					

				ArrayList reason = this.getBeanReason((i+1)+"");
				if(reason.size()>=2){
					patientDrugProfileData.add((String)reason.get(1));
					orderLineData.add((String)reason.get(2));
				}
				else{
					patientDrugProfileData.add("");
					orderLineData.add("");
				}
				patientDrugProfileData.add((String)forDispensing.get("patient_id"));

				if(disp_bean.disp_level.equals("P")) {
					orderLineData.add((String)forDispensing.get("order_id"+(i+1)));
					patientDrugProfileData.add((String)forDispensing.get("order_id"+(i+1)));
					order_id=(String)forDispensing.get("order_id"+(i+1));
				}
				else {
					orderLineData.add((String)forDispensing.get("order_id"));
					patientDrugProfileData.add((String)forDispensing.get("order_id"));
					order_id=(String)forDispensing.get("order_id");
				}

				orderLineData.add((String)forDispensing.get("order_line_num"+(i+1)));
				order_line_num=(String)forDispensing.get("order_line_num"+(i+1));
				patientDrugProfileData.add((String)forDispensing.get("order_line_num"+(i+1)));
				setOrderCheckedYn(order_id+"@"+order_line_num, "Y");// Added for MMS-KH-CRF-0028 [IN070605]
				if( ((String)forDispensing.get("del_detail"+(i+1))).equals("Y") ) {
					//if(!taper_order.equals("Y")){		//Commented for RUT-CRF-0088 [IN036978] 7->6
					if( ((String)forDispensing.get("bms_qty"+(i+1))).equals("0") || ((String)forDispensing.get("bms_qty"+(i+1))).equals("0.0")){
						orderLineData.add("DF");
						//taper_ord_status = "DP";//Commented for RUT-CRF-0088 [IN036978]
					}
					else{//modified for NMC-JD-SCF-0047
						//taper_ord_status = "DP";//Commented for RUT-CRF-0088 [IN036978]
						String currentStatus=getOrderstatus(order_id,order_line_num);
						String temp_pres_qty=(String)forDispensing.get("pres_qty"+(i+1));
						String temp_bms_qty=(String)forDispensing.get("bms_qty"+(i+1));
				//		System.out.println(currentStatus+"currentStatus 2403 IncludeZeroQty"+(String)forDispensing.get("IncludeZeroQty"));
				//		System.out.println(((String)forDispensing.get("pres_qty"+(i+1)))+"pres_qty 2404");
				//		System.out.println(((String)forDispensing.get("bms_qty"+(i+1)))+"pres_qty 2405");
					if(temp_pres_qty.equals(temp_bms_qty) && !((String)forDispensing.get("IncludeZeroQty")).equals("Y") ){
						orderLineData.add(currentStatus);	
					}
					else orderLineData.add("DP");
					}
					/*}//Commented for RUT-CRF-0088 [IN036978]
					else{
						orderLineData.add(taper_ord_status);
					}*/
				}
				else {
					if(forDispensing.get(seq_first+(i+1))!=null && ((String)forDispensing.get(seq_first+(i+1))).equals("P") ) {
						orderLineData.add(first_status);
					}
					else if(forDispensing.get(seq_second+(i+1))!=null && ((String)forDispensing.get(seq_first+(i+1))).equals("P") ) {
						orderLineData.add(sec_status);
					}
					else {
						orderLineData.add("OS");
					}
					
				}	
				if( forDispensing.get("bms_qty"+(i+1))!=null) {
					orderLineData.add((String)forDispensing.get("bms_qty"+(i+1)));
					orderLineData.add((String)forDispensing.get("bms_strength"+(i+1)));
				}
				if( !(forDispensing.get("CompleteOrder"+(i+1))!=null && forDispensing.get("CompleteOrder"+(i+1)).equals(""))) {					
					orderLineData.add((String)forDispensing.get("CompleteOrder"+(i+1)));	complete_status.put((order_id+order_line_num),"Y");	
					complete_order_reason.put((order_id+order_line_num),(String)forDispensing.get("ComplteOrderReason"+(i+1)));
				}
				else {
					orderLineData.add("N");
					complete_status.put((order_id+order_line_num),"N");
				}
				order_quanties.put((order_id+order_line_num),(String)forDispensing.get("pres_qty"+(i+1)));
				if( !(forDispensing.get("alloc_strength"+(i+1))!=null && forDispensing.get("alloc_strength"+(i+1)).equals(""))) {					
					alloc_complete_status.put((order_id+order_line_num),"Y");	
				}
				else {
					alloc_complete_status.put((order_id+order_line_num),"N");
				}

				if( !(forDispensing.get("release_flag"+(i+1))!=null && forDispensing.get("release_flag"+(i+1)).equals(""))) {					
					resultStatusFlags.add((String)forDispensing.get("release_flag"+(i+1)));						
				}
				else{
					resultStatusFlags.add("N");
				}
				//orderLineData.add(taper_order); //Commented for RUT-CRF-0088 [IN036978]
		 
				if(forDispensing.containsKey("pat_reqd_"+(i+1))){
					if(((String)forDispensing.get("pat_reqd_"+(i+1))).trim().equals("C")){
						orderLineData1.add((String)forDispensing.get("pat_reqd_"+(i+1))==null?"":(String)forDispensing.get("pat_reqd_"+(i+1)));	
						if(disp_bean.disp_level.equals("P")) {
							orderLineData1.add((String)forDispensing.get("order_id"+(i+1)));
						}
						else {
							orderLineData1.add((String)forDispensing.get("order_id"));
						}
						orderLineData1.add((String)forDispensing.get("order_line_num"+(i+1)));
					}
				}
			}
		}

		if(disp_bean.disp_level.equals("P")) {
			for(int i=0;i<orderLineData.size();i=i+9){ //10 -> 9 for RUT-CRF-0088 [IN036978]
				if(!unique_orders.contains(((String)orderLineData.get(i+3)).trim())) {
					unique_orders.add(((String)orderLineData.get(i+3)).trim());
					dispense =	this.getCompleteDispense( (String)forDispensing.get("patient_id"),((String)orderLineData.get(i+3)).trim());

					ArrayList arrListAlloc		= (ArrayList)dispense.get("alloc_detail");
					ArrayList arrListFill		= (ArrayList)dispense.get("fill_detail");
					ArrayList arrListAllocTMP	= (ArrayList)dispense.get("alloc_detail_tmp");
					ArrayList arrListFillTMP	= (ArrayList)dispense.get("fill_detail_tmp");
					ArrayList arrListDel		= (ArrayList)dispense.get("del_detail");

					if(arrListAlloc.size() != 0) {
						for(int j=0;j<arrListAlloc.size();j++){
							HashMap hmAllocRecord = (HashMap)arrListAlloc.get(j);
							order_id       =(String)hmAllocRecord.get("order_id");
							order_line_num =(String)hmAllocRecord.get("order_line_no");
							if(complete_status.containsKey(order_id+order_line_num) ||alloc_complete_status.containsKey(order_id+order_line_num)){

								if(complete_status.get(order_id+order_line_num).equals("N") ||alloc_complete_status.get(order_id+order_line_num).equals("Y")){
									if(!not_allocated.contains((String)hmAllocRecord.get("order_id")+(String)hmAllocRecord.get("order_line_no"))) {
										dispAlloc.add(hmAllocRecord.get("order_id"));
										dispAlloc.add(hmAllocRecord.get("order_line_no"));
										dispAlloc.add(hmAllocRecord.get("pres_drug_code"));
										dispAlloc.add(hmAllocRecord.get("disp_drug_code"));
										dispAlloc.add(hmAllocRecord.get("disp_qty"));
										dispAlloc.add(hmAllocRecord.get("disp_uom_code"));
										dispAlloc.add((ArrayList)hmAllocRecord.get("batch_record"));
									}
								}
							}
						}
					}

					if(arrListFill.size() != 0) {
						for(int j=0;j<arrListFill.size();j++){
							HashMap hmFillRecord = (HashMap)arrListFill.get(j);
							order_id       =(String)hmFillRecord.get("order_id");
							order_line_num =(String)hmFillRecord.get("order_line_no");	
							if(complete_status.containsKey(order_id+order_line_num) ||alloc_complete_status.containsKey(order_id+order_line_num)){

								if(complete_status.get(order_id+order_line_num).equals("N")||alloc_complete_status.get(order_id+order_line_num).equals("Y")){			
									if(!not_allocated.contains((String)hmFillRecord.get("order_id")+(String)hmFillRecord.get("order_line_no"))) {
										dispFill.add(hmFillRecord.get("order_id"));
										dispFill.add(hmFillRecord.get("order_line_no"));
										dispFill.add(hmFillRecord.get("pres_drug_code"));
										dispFill.add(hmFillRecord.get("disp_drug_code"));
										dispFill.add(hmFillRecord.get("disp_qty"));
										dispFill.add(hmFillRecord.get("disp_uom_code"));
										dispFill.add((ArrayList)hmFillRecord.get("batch_record"));
								   }
							   }
						   }
						}
					}

					if(arrListAllocTMP.size() != 0) {
						for(int j=0;j<arrListAllocTMP.size();j++){
							HashMap hmAllocRecord = (HashMap)arrListAllocTMP.get(j);
							order_id       =(String)hmAllocRecord.get("order_id");
							order_line_num =(String)hmAllocRecord.get("order_line_no");
							if(complete_status.containsKey(order_id+order_line_num) ||alloc_complete_status.containsKey(order_id+order_line_num)){
								if(complete_status.get(order_id+order_line_num).equals("N")||alloc_complete_status.get(order_id+order_line_num).equals("Y")){
									if(!not_allocated.contains((String)hmAllocRecord.get("order_id")+(String)hmAllocRecord.get("order_line_no"))) {
										dispAllocTMP.add(hmAllocRecord.get("order_id"));
										dispAllocTMP.add(hmAllocRecord.get("order_line_no"));
										dispAllocTMP.add(hmAllocRecord.get("pres_drug_code"));
										dispAllocTMP.add(hmAllocRecord.get("disp_drug_code"));
										dispAllocTMP.add(hmAllocRecord.get("disp_qty"));
										dispAllocTMP.add(hmAllocRecord.get("disp_uom_code"));
										dispAllocTMP.add((ArrayList)hmAllocRecord.get("batch_record"));
								   }
								}
							}
						}
					}

					if(arrListFillTMP.size() != 0) {
						for(int j=0;j<arrListFillTMP.size();j++){
							HashMap hmFillRecord = (HashMap)arrListFillTMP.get(j);
							order_id       =(String)hmFillRecord.get("order_id");
							order_line_num =(String)hmFillRecord.get("order_line_no");
							if(complete_status.containsKey(order_id+order_line_num) ||alloc_complete_status.containsKey(order_id+order_line_num)){

								if(complete_status.get(order_id+order_line_num).equals("N")||alloc_complete_status.get(order_id+order_line_num).equals("Y")){
									if(!not_allocated.contains((String)hmFillRecord.get("order_id")+(String)hmFillRecord.get("order_line_no"))) {
										dispFillTMP.add(hmFillRecord.get("order_id"));
										dispFillTMP.add(hmFillRecord.get("order_line_no"));
										dispFillTMP.add(hmFillRecord.get("pres_drug_code"));
										dispFillTMP.add(hmFillRecord.get("disp_drug_code"));
										dispFillTMP.add(hmFillRecord.get("disp_qty"));
										dispFillTMP.add(hmFillRecord.get("disp_uom_code"));
										dispFillTMP.add((ArrayList)hmFillRecord.get("batch_record"));
									}
								}
							}
						}
					}

					if(arrListDel.size() != 0 ){
						for(int j=0;j<arrListDel.size();j++){
							HashMap hmDelRecord = (HashMap)arrListDel.get(j);
							if(!not_allocated.contains((String)hmDelRecord.get("order_id")+(String)hmDelRecord.get("order_line_no"))) {
								dispDel.add(hmDelRecord.get("order_id"));
								dispDel.add(hmDelRecord.get("order_line_no"));
							}
						}
					}
				}
			}
		} 
		else {
			dispense =	this.getCompleteDispense( (String)forDispensing.get("patient_id"),(String)forDispensing.get("order_id"));
			ArrayList arrListAlloc		= (ArrayList)dispense.get("alloc_detail");
			ArrayList arrListFill		= (ArrayList)dispense.get("fill_detail");
			ArrayList arrListAllocTMP	= (ArrayList)dispense.get("alloc_detail_tmp");
			ArrayList arrListFillTMP	= (ArrayList)dispense.get("fill_detail_tmp");
			ArrayList arrListDel		= (ArrayList)dispense.get("del_detail");

			if(arrListAlloc.size() != 0) {
				for(int j=0;j<arrListAlloc.size();j++){
					HashMap hmAllocRecord = (HashMap)arrListAlloc.get(j);
					order_id       =(String)hmAllocRecord.get("order_id");
					order_line_num =(String)hmAllocRecord.get("order_line_no");
					if(complete_status.containsKey(order_id+order_line_num) ||alloc_complete_status.containsKey(order_id+order_line_num)){

						if(complete_status.get(order_id+order_line_num).equals("N")||alloc_complete_status.get(order_id+order_line_num).equals("Y")){
							if(!not_allocated.contains((String)hmAllocRecord.get("order_id")+(String)hmAllocRecord.get("order_line_no"))) {
								dispAlloc.add(hmAllocRecord.get("order_id"));
								dispAlloc.add(hmAllocRecord.get("order_line_no"));
								dispAlloc.add(hmAllocRecord.get("pres_drug_code"));
								dispAlloc.add(hmAllocRecord.get("disp_drug_code"));
								dispAlloc.add(hmAllocRecord.get("disp_qty"));
								dispAlloc.add(hmAllocRecord.get("disp_uom_code"));
								dispAlloc.add((ArrayList)hmAllocRecord.get("batch_record"));
							}
						}
					}
				}
			}

			if(arrListFill.size() != 0) {
				for(int j=0;j<arrListFill.size();j++){
					HashMap hmFillRecord = (HashMap)arrListFill.get(j);
					order_id       =(String)hmFillRecord.get("order_id");
					order_line_num =(String)hmFillRecord.get("order_line_no");
					if(complete_status.containsKey(order_id+order_line_num) ||alloc_complete_status.containsKey(order_id+order_line_num)){
						if(complete_status.get(order_id+order_line_num).equals("N")||alloc_complete_status.get(order_id+order_line_num).equals("Y")){
							if(!not_allocated.contains((String)hmFillRecord.get("order_id")+(String)hmFillRecord.get("order_line_no"))) {
								dispFill.add(hmFillRecord.get("order_id"));
								dispFill.add(hmFillRecord.get("order_line_no"));
								dispFill.add(hmFillRecord.get("pres_drug_code"));
								dispFill.add(hmFillRecord.get("disp_drug_code"));
								dispFill.add(hmFillRecord.get("disp_qty"));
								dispFill.add(hmFillRecord.get("disp_uom_code"));
								dispFill.add((ArrayList)hmFillRecord.get("batch_record"));
							}
						}
					}
				}
			}

			if(arrListAllocTMP.size() != 0) {
				for(int j=0;j<arrListAllocTMP.size();j++){
					HashMap hmAllocRecord = (HashMap)arrListAllocTMP.get(j);
					order_id       =(String)hmAllocRecord.get("order_id");
					order_line_num =(String)hmAllocRecord.get("order_line_no");
					if(complete_status.containsKey(order_id+order_line_num) ||alloc_complete_status.containsKey(order_id+order_line_num)){
						if(complete_status.get(order_id+order_line_num).equals("N")||alloc_complete_status.get(order_id+order_line_num).equals("Y")){
							if(!not_allocated.contains((String)hmAllocRecord.get("order_id")+(String)hmAllocRecord.get("order_line_no"))) {
								dispAllocTMP.add(hmAllocRecord.get("order_id"));
								dispAllocTMP.add(hmAllocRecord.get("order_line_no"));
								dispAllocTMP.add(hmAllocRecord.get("pres_drug_code"));
								dispAllocTMP.add(hmAllocRecord.get("disp_drug_code"));
								dispAllocTMP.add(hmAllocRecord.get("disp_qty"));
								dispAllocTMP.add(hmAllocRecord.get("disp_uom_code"));
								dispAllocTMP.add((ArrayList)hmAllocRecord.get("batch_record"));
							}
						}
					}
				}
			}

			if(arrListFillTMP.size() != 0) {
				for(int j=0;j<arrListFillTMP.size();j++){
					HashMap hmFillRecord = (HashMap)arrListFillTMP.get(j);
					order_id       =(String)hmFillRecord.get("order_id");
					order_line_num =(String)hmFillRecord.get("order_line_no");
					if(complete_status.containsKey(order_id+order_line_num) ||alloc_complete_status.containsKey(order_id+order_line_num)){
						if(complete_status.get(order_id+order_line_num).equals("N")||alloc_complete_status.get(order_id+order_line_num).equals("Y")){
							if(!not_allocated.contains((String)hmFillRecord.get("order_id")+(String)hmFillRecord.get("order_line_no"))) {
								dispFillTMP.add(hmFillRecord.get("order_id"));
								dispFillTMP.add(hmFillRecord.get("order_line_no"));
								dispFillTMP.add(hmFillRecord.get("pres_drug_code"));
								dispFillTMP.add(hmFillRecord.get("disp_drug_code"));
								dispFillTMP.add(hmFillRecord.get("disp_qty"));
								dispFillTMP.add(hmFillRecord.get("disp_uom_code"));
								dispFillTMP.add((ArrayList)hmFillRecord.get("batch_record"));
							}
						}
					}
				}
			}

			if(arrListDel.size() != 0 ){
				for(int j=0;j<arrListDel.size();j++){
					HashMap hmDelRecord = (HashMap)arrListDel.get(j);
					if(!not_allocated.contains((String)hmDelRecord.get("order_id")+(String)hmDelRecord.get("order_line_no"))) {
						dispDel.add(hmDelRecord.get("order_id"));
						dispDel.add(hmDelRecord.get("order_line_no"));
					}
				}
			}
		}

			tabData.put( "properties", getProperties() );
			tabData.put( "disp_stage", disp_bean.getDispStage());
			tabData.put( "facility_id", login_facility_id.trim() );
			tabData.put( "login_at_ws_no", login_at_ws_no.trim());
			tabData.put( "login_by_id", login_by_id.trim());
			tabData.put( "funct_role_id",disp_bean.getFunctRollID( login_by_id));
			tabData.put( "disp_locn_code", disp_bean.getDispLocnCode().trim() );
			tabData.put( "patient_class", disp_bean.getDispLocnCatg().trim() );
			tabData.put( "today",disp_bean.getTodaysDate());
			tabData.put( "source_code",forDispensing.get("source_code"));
			tabData.put( "source_type",forDispensing.get("source_type"));
			tabData.put( "ordering_facility_id",disp_bean.getOrderingFacility());
			tabData.put( "ord_date_time",forDispensing.get("ord_date_time"));
			tabData.put( "dateTime",disp_bean.getTodaysDateTime());
			tabData.put( "performing_pract_id",forDispensing.get("performing_pract_id"));
			tabData.put( "patient_id", forDispensing.get("patient_id"));
			tabData.put( "encounter_id", disp_bean.getEncounterID());
			tabData.put( "delivery_applicable", disp_bean.getDeliveryApplicable());//checkDeliveryApplicability
			tabData.put( "orderLineData", orderLineData );
			tabData.put( "orderLineData1", orderLineData1 );
			tabData.put( "resultStatusFlags", resultStatusFlags );
			tabData.put( "alloc_complete_status", alloc_complete_status );
			tabData.put( "patientDrugProfileData", patientDrugProfileData );
			tabData.put( "dispAlloc", dispAlloc );
			tabData.put( "dispFill", dispFill );
			tabData.put( "dispAllocTMP", dispAllocTMP );
			tabData.put( "dispFillTMP", dispFillTMP );
			tabData.put( "dispDel", dispDel );
			tabData.put("stock",disp_bean.stock_installed+"");
			tabData.put("store_code",disp_bean.getStoreCode());
			tabData.put("filling_status",filling_status);
			tabData.put("token_yn",disp_bean.getIssueTokenOnRegnYN());
			tabData.put("Token_Queue_date",disp_bean.getQueueDate());
			tabData.put("token_series_code",disp_bean.getTokenSeriesCode());
			tabData.put("delivery_details",disp_bean.getDeliveryDetails());
			tabData.put("token_vals",token_vals);
			tabData.put("mode",getMode());
			tabData.put("order_quanties",order_quanties);
			//code added for all stages...on 27/4/2004
			tabData.put("fillingRemarks",fill_remarks);
			tabData.put("deliveryRemarks",delivery_remarks);
			tabData.put("editLabel",editLabel);
			tabData.put("allocatefill_remarks",allocatefill_remarks);
			tabData.put("func_role_id",disp_bean.getFunctRollID(login_by_id.trim()));
			tabData.put("complte_order_reason",complete_order_reason);//complte order reason code
			tabData.put( "LanguageId",getLanguageId());
			tabData.put( "DispBillingStage",disp_bean.getDispBillStage()); // getDispBillingStage changed to getDispBillStage for SRR20056-SCF-7639 ICN027720
			tabData.put( "billing_interface_yn",getBLInterfaceYN());//checkforbillinginterface());
			tabData.put("BL_REASONS",getBiilingReasonDetails());
			tabData.put("DISP_CASH_COLL_STAGE", disp_bean.getDispCashCollStage());
			tabData.put("CONSUMABLES_DET", getConsumableDetails());
            tabData.put("DISP_LEVEL", disp_bean.disp_level);
			tabData.put("BLInterfaceYN",getBLInterfaceYN());
			tabData.put("ORDER_ID_ORDER_DATE",disp_bean.getOrderIDOrderDate());
			//tabData.put( "ISSUE_UOM_QTY", issueUomQty);
			if(disp_bean.issue_by_uom.equals("I")){
			   tabData.put( "ISSUE_UOM_QTY", this.issueUomQty);
			}
			tabData.put("ORDER_ID_ATTENDED_PRACT_ID",disp_bean.getorder_id_Attended_pract_id());
			tabData.put("CHARGE_DTLS",this.charge_dtls);
			tabData.put("ALTDRUGREMARKS",getAltDrugRemarks());//Added for Bru-HIMS-CRF-082 [IN:029948]
			tabData.put( "alloc_bms_chk", alloc_bms_chk);//Added for MO-GN-5434 [IN:043669]
			tabData.put("BMSValues",hmBMSValues);//Added for MO-GN-5434 [IN:043669]
			tabData.put("ValuesChanged",disp_bean.getValuesChanged()+"");//Added for MO-GN-5434 [IN:043669]
			tabData.put("fill_list",disp_bean.getFillList());//Added for MO-GN-5434 [IN:043669]
			tabData.put( "alloc_bms_chk_val", alloc_bms_chk_val); // Added for ML-BRU-SCF-1187 [IN:045600]
			tabData.put( "autoCompletePartialDisp", disp_bean.getAutoCompletePartialDisp()); // Added forJD-CRF-0179 [IN:41211]
			tabData.put( "st_no_of_decimals", getSt_no_of_decimals()); // Added for AAKH-SCF-0113 [IN:048937]
			tabData.put("editableLabel",editableLabel);//added for Bru-HIMS-CRF-414 [IN:045554]
			tabData.put("allow_edit_disp_label", disp_bean.getAllowEditDispLabel());//added for Bru-HIMS-CRF-414 [IN:045554]
			tabData.put("editableLabelLangId", disp_bean.getEditableLabelLangId());//added for Bru-HIMS-CRF-414 
			tabData.put( "hshmedplan", medplan_bean.getMedPlan_DrugDetails()); // Added for  Bru-HIMS-CRF-072.1[IN 049144] starts // Anitha Coding
			tabData.put( "hshmedplanlocal", medplan_bean.getMedPlan_Local_DrugDetails()); 
			tabData.put( "arrMedPlanSeqNo", medplan_bean.getMediPlanSeqNo()); 
			tabData.put("strMedPlanYN", disp_bean.getMedicationPlannerYN());//Added for [IN:051507]
			tabData.put( "isMedValuesChanged", medplan_bean.isMedValuesChanged()+""); // Added for  Bru-HIMS-CRF-072.1[IN 049144] ends
			tabData.put("iqviaIntegrationFlag", disp_bean.getIqvia_integration_yn()); //MOHE-CRF-0026.1 START
			tabData.put( "postAuthStatusData", forDispensing.get("postAuthStatusData"));
			tabData.put( "authStatusCompleted_yn", forDispensing.get("authStatusCompleted_yn"));//END 
			tabData.put( "settlement_id", forDispensing.get("settlement_id")); //END 
			tabData.put("barcode_2d_applicable_yn",disp_bean.get2DBarcodeApplicable());//Added for MMS-DM-CRF-0174.5
			tabData.put("hm2dBarcode",disp_bean.get2DBarCodeForDrug());//Added for MMS-DM-CRF-0174.5
			
			//ended....
			tabData.put("approvalNo",disp_bean.getApprovalNo()); //Added for AAKH-CRF-0117
			tabData.put("barcode_remarks",disp_bean.getManualBarcodeRemarks());//Added for MMS-DM-CRF-0157.1
			sqlMap.put("SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE"));
			sqlMap.put("SQL_OR_ORDER_LINE_PH_UPDATE",PhRepository.getPhKeyValue("SQL_OR_ORDER_LINE_PH_UPDATE"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_UPDATE"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_ORDER_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_ORDER_UPDATE"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_ORDER_UPDATE1",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_ORDER_UPDATE1"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_ORDER_LINE_PH_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_ORDER_LINE_PH_UPDATE"));
			//sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_TMP_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_TMP_INSERT"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_TMP_INSERT","INSERT INTO PH_DISP_HDR_TMP (DISP_TMP_NO, FACILITY_ID,DISP_LOCN_CODE,ORDER_ID,RECORD_DATE_TIME,FILL_PROC_ID,ORDERING_FACILITY_ID,ORD_DATE_TIME,PATIENT_ID,ENCOUNTER_ID,PATIENT_CLASS,LOCN_TYPE,LOCN_CODE,SPECIALITY_CODE,ATTEND_PRACTITIONER_ID,PRES_PHYSICIAN_ID,DISPENSED_DATE_TIME, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,FILLED_BY_NAME , DISPENSED_BY,ROOM_NO, BED_NO, BED_CLASS, BED_TYPE) VALUES(?,?,?,?,SYSDATE,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,sysdate,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?)");
			sqlMap.put("SQL_PH_DISP_MEDICATION_DRUG_BATCH_TMP_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DRUG_BATCH_TMP_INSERT"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_DISP_DTL_TMP_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DISP_DTL_TMP_INSERT"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT33",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT33"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_INSERT"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT"));						
			sqlMap.put("SQL_PH_DISP_MEDICATION_HDR_COUNT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT47"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HDR_DELETE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DELETE3"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_DTL_DELETE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DELETE2"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_BATCH_DELETE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DELETE1"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_UPDATE"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT56",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT56"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT57",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT57"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT58",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT58"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT59",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT59"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT67",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT67"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT68",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT68"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT137",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT137"));			
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE2",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE2"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE3",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE3"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE4",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE4"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE5",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE5"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE6",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE6"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE7",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE7"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE8",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE8"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE9",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE9"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE10",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE10"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE11",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE11"));			
			sqlMap.put("SQL_PH_DISP_MEDI_EDIT_INSTRUCTIONS" , PhRepository.getPhKeyValue("SQL_PH_DISP_MEDI_EDIT_INSTRUCTIONS"));	
			sqlMap.put("SQL_PH_DISP_MEDI_EDIT_INT_RESULTS" , PhRepository.getPhKeyValue("SQL_PH_DISP_MEDI_EDIT_INT_RESULTS"));	
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE12",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE12"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE13",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE13"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT45",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT45"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE14",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE14"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_ORDER_LINE_SELECT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_ORDER_LINE_SELECT"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_ORDER_LINE_SELECT1",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_ORDER_LINE_SELECT1"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT135",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT135"));
			sqlMap.put("SQL_PH_TDM_PRES_SELECT3",PhRepository.getPhKeyValue("SQL_PH_TDM_PRES_SELECT3"));
			sqlMap.put("SQL_PH_TDM_PRES_SELECT4",PhRepository.getPhKeyValue("SQL_PH_TDM_PRES_SELECT4"));
			sqlMap.put("SQL_PH_TDM_PRES_SELECT5",PhRepository.getPhKeyValue("SQL_PH_TDM_PRES_SELECT5"));
			sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT1",PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT1"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT37",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT37"));
			sqlMap.put("SQL_PH_TDM_PRES_SELECT6",PhRepository.getPhKeyValue("SQL_PH_TDM_PRES_SELECT6"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT2",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT2"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT145",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT145"));
			sqlMap.put("SQL_OR_ORDER_LINE_PH_UPDATE1",PhRepository.getPhKeyValue("SQL_OR_ORDER_LINE_PH_UPDATE1"));
           	sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT152",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT152"));
			sqlMap.put("SQL_OR_ORDER_LINE_PH_UPDATE2",PhRepository.getPhKeyValue("SQL_OR_ORDER_LINE_PH_UPDATE2"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT159",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT159"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT160",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT160"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT167",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT167"));
			sqlMap.put("SQL_OR_ORDER_LINE_PH_UPDATE2A",PhRepository.getPhKeyValue("SQL_OR_ORDER_LINE_PH_UPDATE2A"));

		//added for BL interface on 4/22/2006
		    sqlMap.put("SQL_PH_DISP_MEDICATION_BL_SELECT1",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1"));	
			sqlMap.put("SQL_PH_DISP_MEDICATION_BL_SELECT2",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT2"));
			sqlMap.put("SQL_PH_MEDICATION_PLAN_INSERT", PhRepository.getPhKeyValue("SQL_PH_MEDICATION_PLAN_INSERT"));// Added for  Bru-HIMS-CRF-072.1[IN 049144] start
			sqlMap.put("SQL_PH_MED_PLAN_ID_SEQ", PhRepository.getPhKeyValue("SQL_PH_MED_PLAN_ID_SEQ"));
			sqlMap.put("SQL_PH_MEDICATION_PLAN_UPDATE", PhRepository.getPhKeyValue("SQL_PH_MEDICATION_PLAN_UPDATE"));
			sqlMap.put("SQL_PH_MEDICATION_PLAN_UPDATE1", PhRepository.getPhKeyValue("SQL_PH_MEDICATION_PLAN_UPDATE1"));
			sqlMap.put("SQL_PH_MEDICATION_PLAN_INSERT_CHECK", PhRepository.getPhKeyValue("SQL_PH_MEDICATION_PLAN_INSERT_CHECK"));// Added for  Bru-HIMS-CRF-072.1[IN 049144] end
			if(disp_bean.getAllowEditDispLabel().equals("Y")){//if block Added for Bru-HIMS-CRF-414 [IN:045554]
				sqlMap.put("SQL_PH_DISP_LABEL_UPDATE", PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_UPDATE"));
				sqlMap.put("SQL_PH_DISP_LABEL_INSERT", PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_INSERT"));
				sqlMap.put("SQL_PH_DISP_LABEL_SELECT_DISP_DTL", PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_SELECT_DISP_DTL"));
				sqlMap.put("SQL_PH_DISP_LABEL_SELECT_COUNT", PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_SELECT_COUNT"));
			}
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_DISP_MEDICATION") ) ;
			home  = (DispMedicationHome) PortableRemoteObject.narrow( object, DispMedicationHome.class ) ;
			remote = home.create() ;
			HashMap result = remote.modify( tabData, sqlMap ) ;
			*/
          
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_DISP_MEDICATION" ),DispMedicationHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
            IR_FLAG_VALUE = new HashMap();

			HashMap result = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if(result.containsKey("IR_FLAG")){
				IR_FLAG_VALUE = (HashMap)result.get("IR_FLAG");
				setIR_FLAG_VALUE(IR_FLAG_VALUE);
			}
            if(getBLInterfaceYN().equals("Y")){//checkforbillinginterface
				if(result.containsKey("BILLING_DET")){				
					disp_bean.setBILLING_DET((String)result.get("BILLING_DET"));
					disp_bean.setBLDocSrlNo((String)result.get("BLDocSrlNo"));//added for mms-dm-scf-0575
				}
			}

			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put( "result", new Boolean( true ) ) ;		
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
				map.put("flag","0");
				if(result.containsKey("print_seq_no"))//Added for RUT-CRF-0061
					disp_bean.setPrintSeqNo(result.get("print_seq_no").toString());
				if(result.containsKey("mediplan_seq_no")){//Added for Bru-HIMS-CRF-072.1[IN 049144]
					medplan_bean.clearMediPlanSeqNo();
					medplan_bean.setMediPlanSeqNo(result.get("mediplan_seq_no").toString());
					
				}
				if(result.containsKey("SAL_DOC_DTLS")  ){
					setSalDocDtls((ArrayList)result.get("SAL_DOC_DTLS"));
					
					if(alSalDocDtls != null && alSalDocDtls.size()>0){
						StringBuffer sbSalDocDtls = new StringBuffer();
						for(int i=0; i<alSalDocDtls.size(); i++){
							
							if(i>0)
								sbSalDocDtls.append(" , ");
							sbSalDocDtls.append(alSalDocDtls.get(i));
						}
						
						map.put("dispNos", sbSalDocDtls.toString());
					}
				} //Added for AMS-CRF-0079 [IN:050762] -end
				
				disp_bean.delivery_details	=	new ArrayList();
				clear();
				disp_bean.setAlOrderLineDataForEditLables(orderLineData);//added for ML-BRU-SCF-1872
			}
			else{	
				String msg_id= (String)result.get("msgid");
				String orig_msg_id = msg_id; //Added for for MMS-SCF-0306 [IN:047499]- start
				String message="";
				int index = msg_id.indexOf(":-");
				if(index== -1)
					index = msg_id.length();
				//msg_id=msg_id.substring(24,(msg_id.length()));//24->32 //Commented for for MMS-SCF-0306 [IN:047499]
				msg_id=msg_id.substring(32,index);//for MMS-SCF-0306 [IN:047499] -end
				if(msg_id.equals("ORDER_PROC_BY_OTHER_USER")|| msg_id.equals("BATCH_RECORD_NOT_FOUND")||msg_id.equals("NEGATIVE_STOCK")||msg_id.equals("SUSPENDED_BATCH")||msg_id.equals("INSUFFICIENT_BATCH_QTY")){
					index = orig_msg_id.indexOf(":- :"); //for MMS-SCF-0306 [IN:047499] -start
					if(index >0)
						message = getMessage(getLanguageId(),msg_id,"PH")+" for "+ orig_msg_id.substring(index+4, orig_msg_id.length());
					else
						message = getMessage(getLanguageId(),msg_id,"PH");
					map.put( "message", message) ;//for MMS-SCF-0306 [IN:047499] -end
				}
				else{
					msg_id= (String)result.get("msgid");
					msg_id = msg_id.replace("javax.ejb.EJBException:","");
					map.put( "message", msg_id ) ;
				}
				map.put("flag",result.get("flag"));
			}
			if("Y".equals(getUserAuthPINRequiredYN()))  // Added for RUT-CRF-0035 [IN029926] 
				login_by_id=login_id;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

	public HashMap callinsertNextCollDate(HashMap values){
		HashMap map						 = new HashMap();
		HashMap tabData					 = new HashMap();
		HashMap sqlMap					 = new HashMap();
		HashMap result					 = new HashMap();
		String currr_satge				 = (String)values.get("curr_stage");
		HashMap order_det				 =  new HashMap();
		try{
             if(currr_satge.equals("D")){
				order_det=(HashMap)disp_bean.getDEL_IR_FLAG_VALUE();
			 }
			 else{
				order_det=(HashMap)this.getIR_FLAG_VALUE();
			 }
			tabData.put("order_id" , (String)values.get("order_id"));
			tabData.put("order_line_no" , (String)values.get("order_line_no"));
			tabData.put("next_collection_date" , (String)values.get("next_collection_date"));
			tabData.put("bmsReasonCode" , (String)values.get("bmsReasonCode"));
			tabData.put("" , (String)values.get("next_collection_date"));
			//ReRtdDispLocnCode
			tabData.put("ReRtdDispLocnCode" ,(String)values.get("ReRtdDispLocnCode"));
			tabData.put("disp_no" ,(String)values.get("disp_no"));
			tabData.put("srl_no" ,(String)values.get("srl_no"));
			tabData.put("flag" ,(String)values.get("flag"));
			tabData.put("referral_facility" ,(String)values.get("referral_facility"));
			tabData.put("referral_remarks" ,(String)values.get("referral_remarks"));
			tabData.put("practioner_id" ,(String)values.get("practioner_id"));			
			tabData.put( "properties", getProperties() );
			tabData.put( "facility_id", login_facility_id.trim() );
			tabData.put( "login_at_ws_no", login_at_ws_no.trim());
			tabData.put( "login_by_id", login_by_id.trim());
			tabData.put( "ORDER_DET", order_det);
			
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE1",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE1"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_OR_ORDER_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_OR_ORDER_UPDATE"));			
			sqlMap.put("SQL_PH_DISP_MEDICATION_DTL_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DTL_UPDATE"));			
            sqlMap.put("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_UPDATE"));	
			sqlMap.put("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_LINE_UPDATE1",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_LINE_UPDATE1"));			//sqlMap.put("SQL_PH_OVERRIDE_BMS_SELECT2",PhRepository.getPhKeyValue("SQL_PH_OVERRIDE_BMS_SELECT2"));
			//sqlMap.put("SQL_PH_OVERRIDE_BMS_UPDATE2",PhRepository.getPhKeyValue("SQL_PH_OVERRIDE_BMS_UPDATE2"));
			
			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", "in modify.." ) ;
			map.put( "flag", "0" ) ;		
		
			//DispMedicationHome   home	= null;
			//DispMedicationRemote remote	= null;
			
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_DISP_MEDICATION") ) ;

			home  = (DispMedicationHome) PortableRemoteObject.narrow( object, DispMedicationHome.class ) ;
			remote = home.create() ;
			result = remote.insert( tabData, sqlMap ) ;*/

            Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_DISP_MEDICATION" ),DispMedicationHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
           

			result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			}catch(Exception e){
				e.printStackTrace();
			}
			return result;
	}

	public void setIR_FLAG_VALUE(HashMap IR_FLAG_VALUE){
		this.IR_FLAG_VALUE = IR_FLAG_VALUE;
	}

	public HashMap getIR_FLAG_VALUE(){
		return IR_FLAG_VALUE;
	}

	private String checkNullResult(String inputString, String defaultValue) {
		return (inputString==null) ? defaultValue : inputString;
	}

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
		else	{
			resultSet	=	null;
			pstmt.setString(1,eqvl_uom_code.trim());
			pstmt.setString(2,uom_code.trim());
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() )
			eqvl_value	=	resultSet.getString("eqvl_value");

		}
	}catch(Exception e){
			eqvl_value=e.toString();
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

	//getting the EQVL
public ArrayList getLastDispense(String order_id, String order_line){

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		ArrayList last_dispensed	= new ArrayList(2);
		//String dispensed_info		=	"";
		String sys_date_equals		=	"N";
		StringBuffer dispensed_info		=	new StringBuffer();

		 String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ph_labels = java.util.ResourceBundle.getBundle( "ePH.resources.Labels",loc);

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_IP_MEDICATION_SELECT13") ) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,order_id.trim());
			pstmt.setString(3,order_line.trim());
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				//Date conversion has done for LAST DISPENSED DATE Regarding incident num:25317 on 3/DEC/2010==By Sandhya
				String lastdispenseddate="";
				lastdispenseddate=resultSet.getString("LAST_DISPENSED_DATE");
				
				if(!getLanguageId().equals("en")){
					lastdispenseddate = com.ehis.util.DateUtils.convertDate(lastdispenseddate, "DMYHM","en",locale);
				} //Ends
			     dispensed_info.append(ph_labels.getString("ePH.LastDispensedDate.label"));
				 dispensed_info.append(lastdispenseddate);
				 dispensed_info.append("\n");
				 dispensed_info.append(ph_labels.getString("ePH.LastDispensedBy.label"));
				 dispensed_info.append(resultSet.getString("MODIFIED_BY_ID"));
			
				if( (resultSet.getString("LAST_DISP_DATE")).equals(disp_bean.getTodaysDate())) {
					sys_date_equals	=	"Y";
				}

				last_dispensed.add(dispensed_info.toString());
				last_dispensed.add(sys_date_equals);
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
		return last_dispensed;
	}

	/***To find the alternate Drugs *****/
	public ArrayList getAlternateDrugs(String drug_code,String generic_id)	{

		Connection connection       = null ;
		PreparedStatement pstmt		= null;
		ResultSet resultSet			= null;
		String route_code			=	"";
		String form_code			=	"";
		String disp_alt_form_yn		=	"";
		String strength_uom			=	"";
		String c_drug_code			=	"";
		String c_drug_desc			=	"";
		String c_strength_value		=	"";
		String c_strength_uom		=	"";
		String c_strength_uom_desc	=	"";
		String c_form_code			=	"";
		String c_form_desc			=	"";
		String c_route_code			=	"";
		String c_route_desc			=	"";
		String c_external_prod_id   =	"";
		String sql_query			=	"";
		String eqvl_value			=	"";
		String stock_uom			=  ""; //newly added for ML-BRU-SCF-0179 [IN:032578]
		HashMap drug_detail			=	null;
		ArrayList alternate_drugs	=	new ArrayList();

		try	{
			connection			= getConnection() ;

			sql_query			= PhRepository.getPhKeyValue("SQL_PH_DISP_QUEUE_MGMT_SELECT20");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drug_code);
			resultSet			=   pstmt.executeQuery();

			if(resultSet.next())	{
				route_code			=	checkForNull(resultSet.getString("ROUTE_CODE"));
				form_code			=	checkForNull(resultSet.getString("FORM_CODE"));
				disp_alt_form_yn	=	checkForNull(resultSet.getString("DISP_ALT_FORM_YN"));
				strength_uom		=	checkForNull(resultSet.getString("STRENGTH_UOM"));
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(disp_alt_form_yn.equals("Y")){
				sql_query				= PhRepository.getPhKeyValue("SQL_PH_DISP_QUEUE_MGMT_SELECT21");
				pstmt				= connection.prepareStatement(sql_query) ;
			   
				pstmt.setString(1,login_facility_id.trim());
				pstmt.setString(2,generic_id);
				pstmt.setString(3,drug_code);
				pstmt.setString(4,route_code);
				pstmt.setString(5,getLanguageId());
				pstmt.setString(6,getLanguageId());
				pstmt.setString(7,getLanguageId());
				pstmt.setString(8,getLanguageId());
				pstmt.setString(9,getLanguageId());
			}
			else if(disp_alt_form_yn.equals("N")){
				sql_query			= PhRepository.getPhKeyValue("SQL_PH_DISP_QUEUE_MGMT_SELECT22");
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,login_facility_id.trim());
				pstmt.setString(2,generic_id);
				pstmt.setString(3,drug_code);
				pstmt.setString(4,form_code);
				pstmt.setString(5,route_code);
				pstmt.setString(6,getLanguageId());
				pstmt.setString(7,getLanguageId());
				pstmt.setString(8,getLanguageId());
				pstmt.setString(9,getLanguageId());
				pstmt.setString(10,getLanguageId());
			}		
			if(disp_alt_form_yn.equals("Y") || disp_alt_form_yn.equals("N")){ 
				resultSet			=   pstmt.executeQuery();
				while(resultSet.next())	{
					eqvl_value			=	"";

					c_drug_code			=	checkForNull(resultSet.getString("DRUG_CODE"));
					c_drug_desc			=	checkForNull(resultSet.getString("DRUG_DESC"));
					c_strength_value	=	checkForNull(resultSet.getString("STRENGTH_VALUE"));
					c_strength_uom		=	checkForNull(resultSet.getString("STRENGTH_UOM"));
					c_strength_uom_desc	=	checkForNull(resultSet.getString("STRENGTH_UOM_DESC"));
					c_form_code			=	checkForNull(resultSet.getString("FORM_CODE"));
					c_form_desc			=	checkForNull(resultSet.getString("FORM_DESC"));
					c_route_code		=	checkForNull(resultSet.getString("ROUTE_CODE"));
					c_route_desc		=	checkForNull(resultSet.getString("ROUTE_DESC"));
					c_external_prod_id	=	checkForNull(resultSet.getString("EXTERNAL_PRODUCT_ID"));
					stock_uom			=	checkForNull(resultSet.getString("STOCK_UOM"));    //newly added for 32578

					if(!strength_uom.equals(c_strength_uom))	{
						eqvl_value	=	getEqvlValue(strength_uom, c_strength_uom);
						if(!eqvl_value.equals(""))	{
							drug_detail		=	new HashMap();
							drug_detail.put("DRUG_CODE",c_drug_code);
							drug_detail.put("DRUG_DESC",c_drug_desc);
							drug_detail.put("STRENGTH_VALUE",c_strength_value);
							drug_detail.put("STRENGTH_UOM",c_strength_uom);
							drug_detail.put("STRENGTH_UOM_DESC",c_strength_uom_desc);
							drug_detail.put("FORM_CODE",c_form_code);
							drug_detail.put("FORM_DESC",c_form_desc);
							drug_detail.put("ROUTE_CODE",c_route_code);
							drug_detail.put("ROUTE_DESC",c_route_desc);
							drug_detail.put("EXTERNAL_PRODUCT_ID",c_external_prod_id);
							drug_detail.put("STOCK_UOM",stock_uom);  //newly added for ML-BRU-SCF-0179 [IN:032578]
							if(!c_strength_value.equals("0"))
								alternate_drugs.add(drug_detail);
						}
					}
					else{
						drug_detail		=	new HashMap();
						drug_detail.put("DRUG_CODE",c_drug_code);
						drug_detail.put("DRUG_DESC",c_drug_desc);
						drug_detail.put("STRENGTH_VALUE",c_strength_value);
						drug_detail.put("STRENGTH_UOM",c_strength_uom);
						drug_detail.put("STRENGTH_UOM_DESC",c_strength_uom_desc);
						drug_detail.put("FORM_CODE",c_form_code);
						drug_detail.put("FORM_DESC",c_form_desc);
						drug_detail.put("ROUTE_CODE",c_route_code);
						drug_detail.put("ROUTE_DESC",c_route_desc);
						drug_detail.put("EXTERNAL_PRODUCT_ID",c_external_prod_id);
						drug_detail.put("STOCK_UOM",stock_uom);  //newly added for ML-BRU-SCF-0179 [IN:032578]

						if(!c_strength_value.equals("0"))
							alternate_drugs.add(drug_detail);
					}
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
			alternate_drugs.add(e.toString());
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
		return alternate_drugs;
	}

/*** To get the drug related values***/

	public HashMap getExceedDoseDet(String drugCode,String patient_id,String qty_value,String durn_value,String ord_qty) {
		Connection connection       = null ;
        CallableStatement cstmt     = null ;
        ResultSet resultSet         = null ;
		HashMap dosage_dtl			= new HashMap();

		try{
			connection = getConnection() ;
			cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit(?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, drugCode);
			cstmt.setString( 2, patient_id);
			cstmt.setString( 3, qty_value);
			cstmt.setString( 4, durn_value);
			cstmt.setString( 5, ord_qty);

			cstmt.registerOutParameter(6, Types.VARCHAR );
			cstmt.registerOutParameter(7, Types.VARCHAR );
			cstmt.registerOutParameter(8, Types.VARCHAR );
			cstmt.registerOutParameter(9, Types.VARCHAR );
			cstmt.registerOutParameter(10, Types.VARCHAR );
			cstmt.execute() ;
			String limit_ind	= cstmt.getString( 8 );
			
			if(limit_ind!=null && limit_ind.equals("N")){
				dosage_dtl.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
				dosage_dtl.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );
				dosage_dtl.put("MONO_GRAPH",(cstmt.getString(9)==null ? "":cstmt.getString(9)) );
				dosage_dtl.put("DOSAGE_UNIT",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );

			}
			else{
				dosage_dtl.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
				dosage_dtl.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );
				dosage_dtl.put("MONO_GRAPH","");
				dosage_dtl.put("DOSAGE_UNIT",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );
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
				es.printStackTrace();
			}
		}
		return dosage_dtl;
	}

/*
public HashMap getReqdPrintReports(String disp_locn,ArrayList order_ids, String patient_class,String disp_level) throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		HashMap reqd_reports	=	new HashMap();
		String sPrintBalSheetDispLocn = "N";
		String disp_no = "";
		String order_id			= order_ids.get(0)!= null? order_ids.get(0).toString():"";

		try {
            connection	= getConnection() ;

			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT50")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,disp_locn);
			resultSet	= pstmt.executeQuery() ;

			while(resultSet.next()) {
				disp_no	=	checkForNull(resultSet.getString("DISP_NO"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			reqd_reports.put("disp_no",disp_no);
			
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT50A")) ;

			String sDispNoFrmTmp =  "";

			for(int i=0; i<order_ids.size(); i++)
			{
				pstmt.setString(1,(String)order_ids.get(i));
				pstmt.setString(2,disp_locn);
				pstmt.setString(3,login_facility_id);
				resultSet	= pstmt.executeQuery() ;

				if(resultSet.next()) {
					sDispNoFrmTmp	=	checkForNull(resultSet.getString("DISP_TMP_NO"));
				}
				if(!sDispNoFrmTmp.equals("") && !disp_nos.contains(sDispNoFrmTmp)) {
					disp_nos.add(sDispNoFrmTmp);
				}
				closeResultSet( resultSet ) ;
			}
			closeStatement( pstmt ) ;
			Collections.sort(disp_nos);
			if(disp_level.equals("P")) {
				reqd_reports.put("disp_nos",disp_nos);
			} 
			else {
				reqd_reports.put("DispNoFrmTmp",sDispNoFrmTmp);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return reqd_reports;
}

public HashMap checkFillReport(ArrayList order_ids,String disp_locn,String disp_level) throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		//String disp_sheet_yn	=	"";
		String disp_no			=	"";
		HashMap print_reqd		=	new HashMap();
		ArrayList disp_nos		=	new ArrayList();

		try {
            connection	= getConnection() ;

            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT176")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,disp_locn);
            resultSet	= pstmt.executeQuery() ;

			if(resultSet.next())
			{
				print_reqd.put("ALLOC_DISP_SHEET_DEFAULT_YN",	checkForNull(resultSet.getString("ALLOC_DISP_SHEET_DEFAULT_YN")));
				print_reqd.put("ALLOC_DISP_LABEL_DEFAULT_YN",	checkForNull(resultSet.getString("ALLOC_DISP_LABEL_DEFAULT_YN")));
				print_reqd.put("ALLOC_DRUG_LABEL_DEFAULT_YN",	checkForNull(resultSet.getString("ALLOC_DRUG_LABEL_DEFAULT_YN")));
				print_reqd.put("DEL_DISP_SHEET_DEFAULT_YN",	checkForNull(resultSet.getString("DEL_DISP_SHEET_DEFAULT_YN")));
				print_reqd.put("DEL_DISP_LABEL_DEFAULT_YN",	checkForNull(resultSet.getString("DEL_DISP_LABEL_DEFAULT_YN")));
				print_reqd.put("DEL_DRUG_LABEL_DEFAULT_YN",	checkForNull(resultSet.getString("DEL_DRUG_LABEL_DEFAULT_YN")));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;


			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT50A")) ;

			for(int i=0; i<order_ids.size(); i++)
			{
				pstmt.setString(1,(String)order_ids.get(i));
				pstmt.setString(2,disp_locn);
				pstmt.setString(3,login_facility_id);
				resultSet	= pstmt.executeQuery() ;

				if(resultSet.next()) {
					disp_no	=	checkForNull(resultSet.getString("DISP_TMP_NO"));
				}
				if(!disp_no.equals("") && !disp_nos.contains(disp_no)) {
					disp_nos.add(disp_no);
				}
				closeResultSet( resultSet ) ;
			}
			closeStatement( pstmt ) ;
			
			Collections.sort(disp_nos);

			if(disp_level.equals("P")) {
				print_reqd.put("disp_no",disp_nos);

			} else {

				print_reqd.put("disp_no",disp_no);
			}
			//print_reqd.put("disp_sheet",disp_sheet_yn);
		 
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return print_reqd;
}
*/
	public HashMap getDispenseNumbers(String print_seq_no,String disp_level) throws Exception {//Arguments changed for [IN:047652]
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String disp_no			=	"";
		HashMap reqd_reports	=	new HashMap();
		ArrayList disp_nos		=	new ArrayList();
		String sDispStage		= disp_bean.getDispStage();
		String delivery_applicable = disp_bean.getDeliveryApplicable();//checkDeliveryApplicability
		ArrayList disp_stage			=disp_bean.getDispMedStages();//added for SKR-SCF-0611 [IN:034816] . Getting Disp Stages.

		try {
            connection	= getConnection() ;
			if(sDispStage.equals("D") || sDispStage.equals("AS") || sDispStage.equals("DF") ||  (disp_stage.get(disp_stage.size()-1).equals(sDispStage) && !delivery_applicable.equals("Y"))) {//||  (disp_stage.get(disp_stage.size()-1).equals(sDispStage) && !delivery_applicable.equals("Y")) added for SKR-SCF-0611 [IN:034816]
				pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT50")) ;
				pstmt.setString(1,print_seq_no);//Added for [IN:047652]
				pstmt.setString(2,print_seq_no);//Added for [IN:047652]
				resultSet	= pstmt.executeQuery() ;

				while(resultSet.next()) {
					disp_no	=	checkForNull(resultSet.getString("DISP_NO"));
				//}commented while condition for ML-BRU-SCF-1075[Inc  44015]
				
				if(!disp_no.equals("") && !disp_nos.contains(disp_no)) 
				  disp_nos.add(disp_no);
			  }//Ending while condition here for ML-BRU-SCF-1075[Inc  44015]
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
	
				if(disp_level.equals("P")) {
					Collections.sort(disp_nos);
					reqd_reports.put("disp_no",disp_nos);
				}
				else {
					reqd_reports.put("disp_no",disp_no);
				}
			}
			else{
			//if(reqd_reports.size()==0){
				pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT50A")) ;
				pstmt.setString(1,print_seq_no);//Added for [IN:047652]
				pstmt.setString(2,print_seq_no);//Added for [IN:047652]
				resultSet	= pstmt.executeQuery() ;
                while(resultSet.next()){//added for ML-BRU-SCF-0992 [IN:042805] 
				//if(resultSet.next()) {//Commented for ML-BRU-SCF-0992 [IN:042805] 
					disp_no	=	checkForNull(resultSet.getString("DISP_NO"));// Changed DISP_TMP_NO as DISP_NO for [IN:047652]
					if(!disp_no.equals("") && !disp_nos.contains(disp_no)){ //code moved within the while loop for AMS-SCF-0300[48310] --Start
						disp_nos.add(disp_no);
					} //code moved within the while loop for AMS-SCF-0300[48310] --End 
				}				
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				
				Collections.sort(disp_nos);

				if(disp_level.equals("P")) {
					reqd_reports.put("disp_no",disp_nos);
				}
				else {
					reqd_reports.put("disp_no",disp_no);
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return reqd_reports;
	}

	public HashMap getDrugValues(String drug_code)	{

		Connection connection       = null ;
		PreparedStatement pstmt		= null;
		ResultSet resultSet			= null;
		HashMap	drug_values			= new HashMap();
		String generic_id			=	"";
		String generic_name			=	"";
		String form_code			=	"";
		String form_desc			=	"";
		String route_code			=	"";
		String route_desc			=	"";

		try	{
		String sql_query			= PhRepository.getPhKeyValue("SQL_PH_DISP_QUEUE_MGMT_SELECT28");

		connection			= getConnection() ;
		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,drug_code);
		pstmt.setString(2,getLanguageId());
		pstmt.setString(3,getLanguageId());
		pstmt.setString(4,getLanguageId());
		pstmt.setString(5,getLanguageId());
		pstmt.setString(6,getLanguageId());
		resultSet			=   pstmt.executeQuery();

			if(resultSet.next())	{
				generic_id			=	resultSet.getString("GENERIC_ID");
				generic_name		=	resultSet.getString("GENERIC_NAME");
				form_code			=	resultSet.getString("FORM_CODE");
				form_desc			=	resultSet.getString("FORM_DESC");
				route_code			=	resultSet.getString("ROUTE_CODE");
				route_desc			=	resultSet.getString("ROUTE_DESC");

				drug_values.put("generic_id",generic_id);
				drug_values.put("generic_name",generic_name);
				drug_values.put("form_code",form_code);
				drug_values.put("form_desc",form_desc);
				drug_values.put("route_code",route_code);
				drug_values.put("route_desc",route_desc);

				}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;


		} catch ( Exception e ) {
				drug_values.put("error",e.toString());
		} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                   }catch(Exception es){es.printStackTrace();}
          }

	return drug_values;
	}
/**** Drug values ends ***/
	public ArrayList getDrugDetails(String patient_class,String locn_code,String order_id,String drug_code,String order_line_no) {
		
		Connection connection       = null ;
		PreparedStatement pstmt		= null;
		ResultSet resultSet			= null;		
 		HashMap record				=	new HashMap();
		ArrayList tot_record		=	new ArrayList();

		try	{
			//String sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT62");

			//String sql_query			="SELECT B.ORDER_LINE_NUM ORDER_LINE_NUM, Ph_Getlocn_Name(?,?,?,?) LOCN_DESC, A.PATIENT_NAME, A.PATIENT_ID, GET_AGE(A.DATE_OF_BIRTH) AGE, DECODE(A.SEX,'M','male','F','female','U','unknown') GENDER, B.ORDER_ID, TO_CHAR(B.ORD_DATE_TIME,'DD/MM/YYYY') ORD_DATE_TIME, decode(c.Drug_yn,'N','',I.FORM_CODE) || ' ' || C.DRUG_DESC || ' ' ||  (RTRIM(rtrim(to_char(decode (c.strength_value,'0','','0.0','',null,'',c.strength_value), '999999990.999999'),'0'),'.')) || ' ' || PH_GET_UOM_DISPLAY('"+login_facility_id+"',C.STRENGTH_UOM) FORM_DRUG, decode( k.SLIDING_SCALE_YN ,'Y','Sliding',(RTRIM (RTRIM (TO_CHAR (b.qty_value, '999999990.999999'), '0'), '.') )|| ' ' || ph_get_uom_display ('"+login_facility_id+"', b.qty_unit) ) DOSAGE, decode(c.Drug_yn,'N','',J.ROUTE_DESC)ROUTE_DESC, DECODE((SELECT COUNT(*) FROM OR_ORDER_LINE_FIELD_VALUES WHERE ORDER_ID=? AND ORDER_LINE_NUM=B.ORDER_LINE_NUM AND ORDER_LINE_FIELD_MNEMONIC='SCHED_ADMIN_TIME'),0,d.freq_desc,d.freq_desc) FREQ_DESC, TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY hh24:mi') START_DATE_TIME, TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY hh24:mi') END_DATE_TIME, decode(k.MFR_YN,'Y',(floor(b.durn_value*60/60)||':'||round( mod(b.durn_value*60,60),0)),b.durn_value) || ' ' || e.durn_desc DURATION,B.ORDER_QTY || ' ' ||  F.SHORT_DESC ORDER_QTY, DECODE(B.LINE_FIELDS_DISPLAY_TEXT, '', '', 'Instructions : ' || Ph_Replaceinstructions(B.LINE_FIELDS_DISPLAY_TEXT)) LINE_FIELDS_DISPLAY_TEXT,G.PRACTITIONER_NAME,PH_SPlITDOSE(?,B.ORDER_LINE_NUM) DOSAGE_DTLS,K.ALLERGY_OVERRIDE_REASON,K.DOSAGE_LIMIT_OVERRIDE_REASON,	K.DUPLICATE_DRUG_OVERRIDE_REASON, H.DISCHARGE_IND,c.DRUG_YN   FROM MP_PATIENT A, OR_ORDER_LINE B, PH_DRUG_LANG_VW C, AM_FREQUENCY_LANG_VW D, AM_DURATION_TYPE_LANG_VW E, AM_UOM_LANG_VW F, AM_PRACTITIONER_LANG_VW G, OR_ORDER H, PH_FORM_LANG_VW I, PH_ROUTE_LANG_VW J, OR_ORDER_LINE_PH K WHERE I.FORM_CODE=B.FORM_CODE AND J.ROUTE_CODE=B.ROUTE_CODE AND H.PATIENT_ID=A.PATIENT_ID AND H.ORDER_ID=B.ORDER_ID AND K.ORDER_ID=B.ORDER_ID AND K.ORDER_LINE_NUM=B.ORDER_LINE_NUM AND C.DRUG_CODE=B.ORDER_CATALOG_CODE AND B.FREQ_CODE=D.FREQ_CODE AND B.DURN_TYPE=E.DURN_TYPE AND B.ORD_PRACT_ID=G.PRACTITIONER_ID AND B.ORDER_UOM=F.UOM_CODE AND B.ORDER_ID=? AND B.ORDER_CATALOG_CODE like(?) AND B.ORDER_LINE_NUM like(?) AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = I.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID AND C.LANGUAGE_ID = J.LANGUAGE_ID AND C.LANGUAGE_ID = ?";
			String sql_query			="SELECT B.ORDER_LINE_NUM ORDER_LINE_NUM, Ph_Getlocn_Name(?,?,?,?) LOCN_DESC, A.PATIENT_NAME, A.PATIENT_ID, GET_AGE(A.DATE_OF_BIRTH) AGE, DECODE(A.SEX,'M','male','F','female','U','unknown') GENDER, B.ORDER_ID, TO_CHAR(B.ORD_DATE_TIME,'DD/MM/YYYY') ORD_DATE_TIME, decode(c.Drug_yn,'N','',I.form_desc) || ' ' || C.DRUG_DESC || ' ' ||  (RTRIM(rtrim(to_char(decode (c.strength_value,'0','','0.0','',null,'',c.strength_value), '999999990.999999'),'0'),'.')) || ' ' || PH_GET_UOM_DISPLAY('"+login_facility_id+"',C.STRENGTH_UOM,'"+getLanguageId()+"') FORM_DRUG, decode( k.SLIDING_SCALE_YN ,'Y','Sliding',(RTRIM (RTRIM (TO_CHAR (b.qty_value, '999999990.999999'), '0'), '.') )|| ' ' || ph_get_uom_display ('"+login_facility_id+"', b.qty_unit,'"+getLanguageId()+"') ) DOSAGE, decode(c.Drug_yn,'N','',J.ROUTE_DESC)ROUTE_DESC, DECODE((SELECT COUNT(*) FROM OR_ORDER_LINE_FIELD_VALUES WHERE ORDER_ID=? AND ORDER_LINE_NUM=B.ORDER_LINE_NUM AND ORDER_LINE_FIELD_MNEMONIC='SCHED_ADMIN_TIME'),0,d.freq_desc,d.freq_desc) FREQ_DESC, TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY hh24:mi') START_DATE_TIME, TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY hh24:mi') END_DATE_TIME, decode(k.MFR_YN,'Y',(floor(b.durn_value*60/60)||':'||round( mod(b.durn_value*60,60),0)),b.durn_value) || ' ' || e.durn_desc DURATION,B.ORDER_QTY || ' ' ||  F.SHORT_DESC ORDER_QTY, DECODE(B.LINE_FIELDS_DISPLAY_TEXT, '', '', 'Instructions : ' || Ph_Replaceinstructions(B.LINE_FIELDS_DISPLAY_TEXT)) LINE_FIELDS_DISPLAY_TEXT,G.PRACTITIONER_NAME, decode(FREQ_NATURE,'I','',ph_get_dosage_display(?,B.ORDER_LINE_NUM,'"+login_facility_id+"',?,?,'','D'))  DOSAGE_DTLS,L.ALLERGY_OVERRIDE_REASON,L.DOSAGE_LIMIT_OVERRIDE_REASON,	L.DUPLICATE_DRUG_OVERRIDE_REASON, H.DISCHARGE_IND,c.DRUG_YN, L.SPLIT_YN, h.iv_prep_yn,j.ROUTE_COLOR,K.ALTERNATE_AMEND_REASON   FROM MP_PATIENT A, OR_ORDER_LINE B, PH_DRUG_LANG_VW C, AM_FREQUENCY_LANG_VW D, AM_DURATION_TYPE_LANG_VW E, AM_UOM_LANG_VW F, AM_PRACTITIONER_LANG_VW G, OR_ORDER H, PH_FORM_LANG_VW I, PH_ROUTE_LANG_VW J, OR_ORDER_LINE_PH K, PH_PATIENT_DRUG_PROFILE L WHERE I.FORM_CODE=B.FORM_CODE AND J.ROUTE_CODE=B.ROUTE_CODE AND H.PATIENT_ID=A.PATIENT_ID AND H.ORDER_ID=B.ORDER_ID AND K.ORDER_ID=B.ORDER_ID AND K.ORDER_LINE_NUM=B.ORDER_LINE_NUM AND L.ORIG_ORDER_ID = B.ORDER_ID AND L.ORIG_ORDER_LINE_NO = B.ORDER_LINE_NUM AND C.DRUG_CODE=B.ORDER_CATALOG_CODE AND B.FREQ_CODE=D.FREQ_CODE AND B.DURN_TYPE=E.DURN_TYPE AND B.ORD_PRACT_ID=G.PRACTITIONER_ID AND B.ORDER_UOM=F.UOM_CODE AND B.ORDER_ID=? AND B.ORDER_CATALOG_CODE like(?) AND B.ORDER_LINE_NUM like(?) AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = I.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID AND C.LANGUAGE_ID = J.LANGUAGE_ID AND C.LANGUAGE_ID = ?"; //query modified [replaced PH_SPlITDOSE(?,B.ORDER_LINE_NUM) with (select split_dose_preview from ph_patient_drug_profile where orig_order_id =? and ORIG_ORDER_LINE_NO =B.ORDER_LINE_NUM) for DOSAGE_DTLS] for IN23960 --01/10/2010-- priya // replaced again with ph_get_dosage_display(?,B.ORDER_LINE_NUM,'"+login_facility_id+"',?,?) for IN24784 --10/12/2010-- priya // added L.SPLIT_YN and  L.ORIG_ORDER_ID = B.ORDER_ID AND L.ORIG_ORDER_LINE_NO = B.ORDER_LINE_NUM for IN25545 --20/12/2010-- priya //I.form_code replaced with I.form_desc ML-BRU-SCF-0417 [IN:035080]// added j.ROUTE_COLOR for CRF RUT-CRF-0034.1[IN:037389]  //Added ,'','D' in ph_get_dosage_display for ML-BRU-SCF-1032 [IN:043723],Modified for IN:073485 

			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,patient_class);
			pstmt.setString(2,locn_code);
			pstmt.setString(3,login_facility_id);
			pstmt.setString(4,getLanguageId());
			pstmt.setString(5,order_id);
			pstmt.setString(6,order_id);
			pstmt.setString(7,drug_code);
			pstmt.setString(8,drug_code);
			pstmt.setString(9,order_id);
			pstmt.setString(10,drug_code);
			pstmt.setString(11,order_line_no);
			pstmt.setString(12,getLanguageId());
			
			resultSet			=   pstmt.executeQuery();
			while(resultSet.next())	{
				
				record				=	new HashMap();
				record.put("patient_id",checkForNull(resultSet.getString("PATIENT_ID")));
				record.put("patient_name",checkForNull(resultSet.getString("PATIENT_NAME")));
				record.put("age",checkForNull(resultSet.getString("AGE")));
				record.put("sex",checkForNull(resultSet.getString("GENDER")));
				record.put("ord_id",checkForNull(resultSet.getString("ORDER_ID")));
				record.put("order_line_num",checkForNull(resultSet.getString("ORDER_LINE_NUM")));
				record.put("ord_date_time",checkForNull(resultSet.getString("ORD_DATE_TIME")));
				record.put("form_drug",checkForNull(resultSet.getString("FORM_DRUG")));
				record.put("dosage",checkForNull(resultSet.getString("DOSAGE")));
				record.put("route_desc",checkForNull(resultSet.getString("ROUTE_DESC")));
				record.put("freq_desc",checkForNull(resultSet.getString("FREQ_DESC")));
				record.put("start_date",checkForNull(resultSet.getString("START_DATE_TIME")));
				record.put("end_date",checkForNull(resultSet.getString("END_DATE_TIME")));
				record.put("duration",checkForNull(resultSet.getString("DURATION")));
				record.put("order_qty",checkForNull(resultSet.getString("ORDER_QTY")));
				record.put("pract_name",checkForNull(resultSet.getString("PRACTITIONER_NAME")));
				record.put("dosage_dtls",checkForNull(resultSet.getString("DOSAGE_DTLS")));
				record.put("allergy_reason",checkForNull(resultSet.getString("ALLERGY_OVERRIDE_REASON")));
				record.put("exceed_dose_reason",checkForNull(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")));
				record.put("duplicate_reason",checkForNull(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")));
				record.put("discharge_ind",checkForNull(resultSet.getString("DISCHARGE_IND")));
				record.put("drug_yn",checkForNull(resultSet.getString("DRUG_YN")));
				record.put("split_yn",checkForNull(resultSet.getString("SPLIT_YN")));
				record.put("iv_prep_yn",checkForNull(resultSet.getString("IV_PREP_YN")));
				record.put("route_color",checkForNull(resultSet.getString("ROUTE_COLOR")));// added for CRF RUT-CRF-0034.1[IN:037389] 
				record.put("alternate_amend_reason",checkForNull(resultSet.getString("ALTERNATE_AMEND_REASON")));
                tot_record.add(record);
			}
			if(tot_record.size()==0){
				sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT62A");

				pstmt			= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,patient_class);
				pstmt.setString(2,locn_code);
				pstmt.setString(3,login_facility_id);
				pstmt.setString(4,getLanguageId());
				pstmt.setString(5,order_id);
				pstmt.setString(6,order_id);
				pstmt.setString(7,drug_code);
				pstmt.setString(8,getLanguageId());
				resultSet			=   pstmt.executeQuery();

				if(resultSet.next()){

					record.put("patient_id",checkForNull(resultSet.getString("PATIENT_ID")));
					record.put("patient_name",checkForNull(resultSet.getString("PATIENT_NAME")));
					record.put("age",checkForNull(resultSet.getString("AGE")));
					record.put("sex",checkForNull(resultSet.getString("GENDER")));
					record.put("ord_id",checkForNull(resultSet.getString("ORDER_ID")));
					record.put("order_line_num",checkForNull(resultSet.getString("ORDER_LINE_NUM")));
					record.put("ord_date_time",checkForNull(resultSet.getString("ORD_DATE_TIME")));
					record.put("form_drug",checkForNull(resultSet.getString("FORM_DRUG")));
					record.put("dosage",checkForNull(resultSet.getString("DOSAGE")));
					record.put("route_desc",checkForNull(resultSet.getString("ROUTE_DESC")));
					record.put("freq_desc",checkForNull(resultSet.getString("FREQ_DESC")));
					record.put("start_date",checkForNull(resultSet.getString("START_DATE_TIME")));
					record.put("end_date",checkForNull(resultSet.getString("END_DATE_TIME")));
					record.put("duration",checkForNull(resultSet.getString("DURATION")));
					record.put("order_qty",checkForNull(resultSet.getString("ORDER_QTY")));
					record.put("pract_name",checkForNull(resultSet.getString("PRACTITIONER_NAME")));
					record.put("dosage_dtls",checkForNull(resultSet.getString("DOSAGE_DTLS")));
					record.put("allergy_reason",checkForNull(resultSet.getString("ALLERGY_OVERRIDE_REASON")));
					record.put("exceed_dose_reason",checkForNull(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")));
					record.put("duplicate_reason",checkForNull(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")));
					record.put("discharge_ind",checkForNull(resultSet.getString("DISCHARGE_IND")));
					record.put("drug_yn","N");
					record.put("iv_prep_yn",checkForNull(resultSet.getString("IV_PREP_YN")));
					record.put("route_color",checkForNull(resultSet.getString("ROUTE_COLOR")));// added for CRF RUT-CRF-0034.1[IN:037389] 
					record.put("alternate_amend_reason",checkForNull(resultSet.getString("ALTERNATE_AMEND_REASON")));
					record.put("total_daily_fluid",checkForNull(resultSet.getString("TOTAL_DAILY_FLUID")==null?"":resultSet.getString("TOTAL_DAILY_FLUID")));//added for ML-MMOH-CRF-1013
					record.put("enteral_feeding",checkForNull(resultSet.getString("ENTERAL_FEEDING")==null?"":resultSet.getString("ENTERAL_FEEDING")));//added for ML-MMOH-CRF-1013
					tot_record.add(record); 

				}
			}
		} 
		catch ( Exception e ) {
			record.put("error",e.toString());
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

		return tot_record;
	}
	
	public ArrayList getPresRemarks(String orig_order_id,String orig_order_line_no) {
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		
		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT5") ) ;
			pstmt.setString(1,orig_order_id);
			pstmt.setString(2,orig_order_line_no);
			pstmt.setString(3,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				if((resultSet.getString("ORDER_LINE_FIELD_MNEMONIC")).equals("PRES_REMARKS")) {
					if(resultSet.getString("REMARK_DESC")!=null) {
						records.add(resultSet.getString("REMARK_DESC"));
					}
				} else {
					if(resultSet.getString("ORDER_LINE_FIELD_VALUE")!=null) {
						records.add(resultSet.getString("ORDER_LINE_FIELD_VALUE"));
					}
				}
			}						
		}catch(Exception e){
				records.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();
			}
		}
		return records;	
	}
	/***To check the Multi Strengh YN****/
	public String checkMultiStrength(String drug_code)	{

		Connection connection       = null ;
		PreparedStatement pstmt		= null;
		ResultSet resultSet			= null;
		String multi_strength_yn	=	"";
		String param_multi_strength_yn	=	"";
		String drug_multi_strength_yn	=	"";
		String NPBDrug = "";
		String from_param="";//added for ghl-crf-0548
		String disp_alt_form_yn="";//added for ghl-crf-0548
		try	{
			String sql_query			= PhRepository.getPhKeyValue("SQL_PH_DISP_QUEUE_MGMT_SELECT16");
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drug_code);
			resultSet			=   pstmt.executeQuery();
			if(resultSet.next())	{
				param_multi_strength_yn		=	resultSet.getString("PARAM_YN");//modified for ghl-crf-0548
				drug_multi_strength_yn		=	resultSet.getString("DRUG_YN");
				NPBDrug		=	resultSet.getString("NPB_DRUG_YN");
				from_param=   resultSet.getString("FROM_PARAM");//ADDED FOR GHL-CRF-0548
				disp_alt_form_yn=resultSet.getString("DISP_ALT_FORM_YN");//ADDED FOR GHL-CRF-0548
				if( !from_param.equals("N") && !disp_alt_form_yn.equals("N") && (param_multi_strength_yn.equals("Y") || param_multi_strength_yn.equals("M") || param_multi_strength_yn.equals("S") || param_multi_strength_yn.equals("N")) && (drug_multi_strength_yn.equals("Y")  || drug_multi_strength_yn.equals("S") || drug_multi_strength_yn.equals("M") ||  drug_multi_strength_yn.equals("N"))   && !NPBDrug.equals("Y")) {//MODIFIED FOR GHL-CRF-0548
					
					multi_strength_yn	=	"Y";
				}
				else 
					multi_strength_yn	=	"N";
			}
		} 
		catch ( Exception e ) {
			multi_strength_yn	=	e.toString();
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
		return multi_strength_yn;
	}

	public HashMap loadHoldRemarks(String order_id, String order_line_no)	{
		Connection connection			= null ;
		PreparedStatement pstmt			= null;
		ResultSet resultSet				= null;
		HashMap	hold_remarks			=	new HashMap();
		String	hold_by_id				=	"";
		String  hold_by_date			=	"";
		String hold_reason				=	"";
		String hold_reason_desc			=	"";
		try	{
			String sql_query			= PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT28");
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet			=   pstmt.executeQuery();
			if(resultSet.next())	{
				hold_by_id			=	resultSet.getString("ON_HOLD_BY_ID");
				hold_by_date		=	resultSet.getString("ON_HOLD_DATE_TIME");
				hold_reason			=	resultSet.getString("ON_HOLD_REASON_CODE");
				hold_reason_desc	=	resultSet.getString("LAST_ACTION_REASON_DESC");
				hold_remarks.put("hold_by_id",hold_by_id);
				hold_remarks.put("hold_by_date",hold_by_date);
				hold_remarks.put("hold_reason",hold_reason);
				hold_remarks.put("hold_reason_desc",hold_reason_desc);
			}
		}
		catch ( Exception e ) {
			hold_remarks.put("error",e.toString());
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
		return hold_remarks;
	}

	public ArrayList loadFillRemarks(String trn_check) throws Exception{

	   	Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String reason_code		=	"";
		String reason_desc		=	"";
		ArrayList fillCode		=	new ArrayList();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_IP_FILL_REMARKS_SELECT6A")) ;
			pstmt.setString(1,trn_check);
			pstmt.setString(2,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				reason_code		=	resultSet.getString("REASON_CODE");
				reason_desc		=	resultSet.getString("REASON_DESC");
				fillCode.add(reason_code);
				fillCode.add(reason_desc);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			reason.add(e);
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}		
		return fillCode;
	}

//added on 18/04/2004 for filling person name
	public void setFillPersonName(String fillPersonName){
		this.fillPersonName = fillPersonName;
	}

	public String getFillPersonName(){
		return fillPersonName;
	}

	public String getFilledPersonName(){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String filled_user		= "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DIRECT_DISPENSING_SELECT11")) ;
			pstmt.setString(1,login_by_id.trim());
			pstmt.setString(2,getLanguageId());

            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				filled_user		=	resultSet.getString("APPL_USER_NAME");	
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
		return filled_user;
	}

	public String getIVFlag(String order_id) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String iv_prep_yn		= "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT27")) ;
			pstmt.setString(1,order_id);
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				iv_prep_yn		=	resultSet.getString("iv_prep_yn")==null?"":resultSet.getString("iv_prep_yn");				
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
		return iv_prep_yn;
	}

	public String getPatientName(String patient_id){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String patient_name		= "";
	
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT43")) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patient_id);
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
			patient_name		=	resultSet.getString("PATIENT_NAME");	
			
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
		return patient_name;
	}

	public String getPractitionerName(String pract_id){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String pact_name		= "";
	
		try {
            connection	= getConnection() ;
           // pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_EDIT_LABEL")) ; Commented on 15/Nov/2010 ===By Sandhya for the incident num:24949
            pstmt		= connection.prepareStatement( "SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW  WHERE PRACTITIONER_ID = ? and language_id = ?") ;
			pstmt.setString(1,pract_id);
			pstmt.setString(2,language_id);
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				pact_name		=	resultSet.getString("PRACTITIONER_NAME");	
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
		return pact_name;
	}

	public HashMap getEditableLabel(){
		return this.editableLabel;
	}
	public void setEditableLabel(ArrayList editLab,String key){
		if(this.editableLabel == null)
			this.editableLabel = new HashMap();
		this.editableLabel.put(key,editLab);
	}

	public void clearEditableLabel(String key) {
		if(this.editLabel.containsKey(key)) {
			 this.editableLabel.remove(key);
		}
	}

	public ArrayList getEditableLabelValues(String record_line_id) {
		ArrayList edit_recs_values		=	null;
		if(this.editableLabel!=null && this.editableLabel.containsKey(record_line_id)) {
			edit_recs_values	=	(ArrayList)editableLabel.get(record_line_id);
		}
		return edit_recs_values;
	}


	public void setEditLabel(ArrayList editLab,String key){
		editLabel.put(key,editLab);
	}

	public void clearEditLabel(String key) {
		if(this.editLabel.containsKey(key)) {
			 this.editLabel.remove(key);
		}
	}
	
	/*public ArrayList getEditLabel(String record_line_id) {
		ArrayList edit_recs			=	new ArrayList();
		if(this.editLabel.containsKey(record_line_id)) {
			edit_recs	=	(ArrayList)editLabel.get(record_line_id);
		}
		else{
			edit_recs.add(""); //0
			edit_recs.add("");
			edit_recs.add("");
			edit_recs.add("");
			edit_recs.add("");
			edit_recs.add("");
			edit_recs.add("");
			edit_recs.add("");
			edit_recs.add("");
			edit_recs.add(""); //9			
			edit_recs.add("");	
			edit_recs.add("");	//11
			edit_recs.add("");	//12
		}	
		return edit_recs;
	}*/ //commented -not used

	public ArrayList getEditLabelValues(String record_line_id) {
		ArrayList edit_recs_values		=	new ArrayList();
		if(this.editLabel.containsKey(record_line_id)) {
			edit_recs_values	=	(ArrayList)editLabel.get(record_line_id);
		}
		return edit_recs_values;
	}

	public HashMap loadLabels(){
		HashMap labels			  = new HashMap();		
		ArrayList caution		  = new ArrayList();
		ArrayList spl_instruction = new ArrayList();
		ArrayList spl_instruction2 = new ArrayList();
		String sec_lang_id = "";

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		
		try{
			connection			= getConnection() ;
			/*********** Initialize the values for Caution***************/
			pstmt		= null;
			resultSet	= null;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT8") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				HashMap data=new HashMap();
				data.put( "label_text_id",checkForNull(resultSet.getString( "label_text_id" )) ) ;
				data.put( "label_text_1",checkForNull(resultSet.getString( "label_text_1" )) ) ;
				data.put( "label_text_2",checkForNull(resultSet.getString( "label_text_2" )) ) ;
				caution.add(data);
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			
			/*********** Initialize the values for Special Instruction***************/
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT9") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				HashMap data=new HashMap();
				data.put( "label_text_id",checkForNull(resultSet.getString( "label_text_id" )) ) ;
				data.put( "label_text_1",checkForNull(resultSet.getString( "label_text_1" )) ) ;
				spl_instruction.add(data);
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);

		// Added by Senthil kumar J on 15/4/2004
		/*********** Initialize the values for Special Instruction2***************/
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT9A") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				HashMap data=new HashMap();
				data.put( "label_text_id",checkForNull(resultSet.getString( "LABEL_TEXT_ID" )) ) ;
				data.put( "label_text_2",checkForNull(resultSet.getString( "LABEL_TEXT_2" )) ) ;
				spl_instruction2.add(data);
			}

			closeStatement(pstmt);
			closeResultSet(resultSet);
			pstmt		= connection.prepareStatement( "SELECT LANGUAGE_ID FROM SM_LANGUAGE WHERE EFF_STATUS = 'E' AND PRIMARY_LANG_YN = 'N' AND ROWNUM < 2" ) ;
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				sec_lang_id = checkForNull(resultSet.getString( "LANGUAGE_ID" ))  ;
			}
	//  ended...	
		} 
		catch ( Exception e )	{
			labels.put( "erorr :",e.toString());
				try{
					e.printStackTrace() ;
					throw e ;
				}
				catch(Exception es){es.printStackTrace();
				}
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
		labels.put( "sec_lang_id",sec_lang_id );
		labels.put( "caution",caution );
		labels.put( "spl_instruction",spl_instruction );
		labels.put( "spl_instruction2",spl_instruction2 );
		return labels;
	}

	public void getDispEditLabeldetails(String order_id,String order_line_num,String drug_code ){ //drug_code newly added for ML-BRU-SCF-0179 [IN:032578]
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		//String pact_name		= "";
		String cau_instructions	="";
		String spl_instructions	="";
		String pat_instructions	="";
		String cau_instructions_loc	="";
		String spl_instructions_loc	="";
		String pat_instructions_loc	="";
		String pres_remark_code ="";
		String drug_indication	= "";

		boolean bResultAvailable = false,remarks_flag = false;//code 'remarks_flag = false' added for RUT-SCF-0294[IN043113]
	
		try {
            connection	= getConnection() ;
            //pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT163")) ;
            pstmt		= connection.prepareStatement( "select LABEL_CAU_INSTRN1_ENG,LABEL_SPL_INSTRN1_ENG,LABEL_PAT_INSTRN1_ENG,PRES_REMARK_CODE,LABEL_CAU_INSTRN1_LOC, LABEL_SPL_INSTRN1_LOC, LABEL_PAT_INSTRN1_LOC,DRUG_INDICATION FROM ph_disp_dtl_tmp WHERE order_id=? AND ORDER_LINE_NO =? AND DISP_DRUG_CODE=?") ; //newly added AND DISP_DRUG_CODE by manickam //Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
        	pstmt.setString(3,drug_code);  //newly added for ML-BRU-SCF-0179 [IN:032578]
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				bResultAvailable = true;
			}
			else{
				 pstmt		= null;
				 pstmt		= connection.prepareStatement( "select LABEL_CAU_INSTRN1_ENG,LABEL_SPL_INSTRN1_ENG,LABEL_PAT_INSTRN1_ENG,PRES_REMARK_CODE,DRUG_INDICATION,LABEL_CAU_INSTRN1_LOC, LABEL_SPL_INSTRN1_LOC, LABEL_PAT_INSTRN1_LOC FROM ph_disp_dtl WHERE order_id=? AND ORDER_LINE_NO =? AND DISP_DRUG_CODE=?") ; //newly added AND DISP_DRUG_CODE by manickam
				 pstmt.setString(1,order_id);
				 pstmt.setString(2,order_line_num);
				 pstmt.setString(3,drug_code);  //newly added for ML-BRU-SCF-0179 [IN:032578]
			     resultSet	= pstmt.executeQuery() ;
				 if(resultSet.next()){
					bResultAvailable = true;
				 }
			}			
           if(!bResultAvailable){//code added for RUT-SCF-0294[IN043113] --Start
				remarks_flag = true;
				pstmt		= null;	
				
				pstmt		= connection.prepareStatement(" SELECT CAUTION_LABEL_TEXT_ID_1 LABEL_CAU_INSTRN1_ENG ,SPL_INSTR_LABEL_TEXT_ID LABEL_SPL_INSTRN1_ENG,  (SELECT  LABEL_TEXT_1  FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE  LABEL_TEXT_ID = A.CAUTION_LABEL_TEXT_ID_1  AND  LABEL_TEXT_TYPE ='C' AND LANGUAGE_ID = (SELECT LANGUAGE_ID FROM SM_LANGUAGE WHERE EFF_STATUS = 'E' AND PRIMARY_LANG_YN = 'N' AND ROWNUM < 2)) LABEL_CAU_INSTRN1_LOC, (SELECT  LABEL_TEXT_1  FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE  LABEL_TEXT_ID= A.SPL_INSTR_LABEL_TEXT_ID AND  LABEL_TEXT_TYPE ='S' AND LANGUAGE_ID = ( SELECT LANGUAGE_ID FROM SM_LANGUAGE WHERE EFF_STATUS = 'E' AND PRIMARY_LANG_YN = 'N' AND ROWNUM < 2) ) LABEL_SPL_INSTRN1_LOC,HOW_TO_TAKE_TEXT LABEL_PAT_INSTRN1_ENG, DRUG_INDICATION FROM PH_DRUG A WHERE DRUG_CODE = ? ");				
									
				pstmt.setString(1,drug_code); 
				resultSet	= pstmt.executeQuery() ;
				if(resultSet.next()){
					bResultAvailable = true;
				}		   
		   } //code added for RUT-SCF-0294[IN043113] --End
			if(bResultAvailable){
				do{
					cau_instructions	=resultSet.getString("LABEL_CAU_INSTRN1_ENG")==null?"":resultSet.getString("LABEL_CAU_INSTRN1_ENG");
					spl_instructions	=resultSet.getString("LABEL_SPL_INSTRN1_ENG")==null?"":resultSet.getString("LABEL_SPL_INSTRN1_ENG");
					pat_instructions	=resultSet.getString("LABEL_PAT_INSTRN1_ENG")==null?"":resultSet.getString("LABEL_PAT_INSTRN1_ENG");			
					if(!remarks_flag)//code added for RUT-SCF-0294[IN043113] 
						pres_remark_code  =resultSet.getString("PRES_REMARK_CODE")==null?"":resultSet.getString("PRES_REMARK_CODE");
					drug_indication  =resultSet.getString("DRUG_INDICATION")==null?"":resultSet.getString("DRUG_INDICATION");//Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]
					cau_instructions_loc	=resultSet.getString("LABEL_CAU_INSTRN1_LOC")==null?"":resultSet.getString("LABEL_CAU_INSTRN1_LOC");
					spl_instructions_loc	=resultSet.getString("LABEL_SPL_INSTRN1_LOC")==null?"":resultSet.getString("LABEL_SPL_INSTRN1_LOC");
					if(!remarks_flag)	//code added for RUT-SCF-0294[IN043113] 
					pat_instructions_loc	=resultSet.getString("LABEL_PAT_INSTRN1_LOC")==null?"":resultSet.getString("LABEL_PAT_INSTRN1_LOC");
					else//code added for RUT-SCF-0294[IN043113] 
					pat_instructions_loc  = pat_instructions; //code added for RUT-SCF-0294[IN043113] 
				}
				while (resultSet.next());
			}

			if(!cau_instructions.equals("")||!spl_instructions.equals("")||!pat_instructions.equals("")|| !pres_remark_code.equals("")){
				ArrayList edit_recs				= new ArrayList();
				edit_recs.add(cau_instructions);
				edit_recs.add("");
				edit_recs.add(spl_instructions);
				edit_recs.add("");
				edit_recs.add(pat_instructions);	
				edit_recs.add(cau_instructions_loc);
				edit_recs.add("");
				edit_recs.add(spl_instructions_loc);
				edit_recs.add("");
				edit_recs.add(pat_instructions_loc);	
				edit_recs.add(pres_remark_code);
				edit_recs.add(drug_indication);//Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]
				edit_recs.add(drug_code);
				this.setEditLabel( edit_recs,(order_id+"_"+drug_code+"_"+order_line_num).trim());//drug_code newly added for ML-BRU-SCF-0179 [IN:032578]
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

	public String getDosageDetails(String order_id,String order_line_no,String drug_code){
		String dosagedetails		= "";
		
		Connection connection		= null;
        PreparedStatement pstmt_1	= null;
        PreparedStatement pstmt_2	= null;
        PreparedStatement pstmt_3	= null;
        ResultSet rset_1			= null;	
		ResultSet rset_2			= null;	
		ResultSet rset_3			= null;	
		String calc_dosg_by_freq	= "";
		String tmp_string			= "";
		String tmp_qty				= "";
		String tmp					= "";
		String divided				= "";
		boolean firstTime	=	true;
		boolean found		=	false;
		boolean entered		=	false;
		
		try {
            connection	= getConnection() ;
            pstmt_1 = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT62")) ;
			pstmt_2	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT1"));
			
			pstmt_1.setString(1,order_id);
			pstmt_1.setString(2,order_line_no);
			rset_1	=	pstmt_1.executeQuery();

			pstmt_2.setString(1,drug_code);
			pstmt_2.setString(2,getLanguageId());
			pstmt_2.setString(3,getLanguageId());
			pstmt_2.setString(4,getLanguageId());
			pstmt_2.setString(5,getLanguageId());
			pstmt_2.setString(6,getLanguageId());

			rset_2	=	pstmt_2.executeQuery();
			
			if(rset_2.next()){
				calc_dosg_by_freq	=	checkForNull(rset_2.getString("CALC_DOSG_BY_FREQ_DURN_YN"));
			}
			while(rset_1.next()) {
				entered			=	true;
				divided		=	checkForNull(rset_1.getString("ORDER_LINE_DOSE_QTY_VALUE"));
				if(firstTime) {
					tmp			=	divided;
					firstTime	=	false;
				} 
				else if(!tmp.equals(divided)) {
					found		=	true;
				}
			}

			pstmt_3 = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT72")) ;
			pstmt_3.setString(1,order_id);
			pstmt_3.setString(2,order_line_no);
			pstmt_3.setString(3,getLanguageId());
			rset_3	=	pstmt_3.executeQuery();

			while(rset_3.next()){

			if(!entered) {
					if(calc_dosg_by_freq.equals("N")) {
						dosagedetails  = (checkForNull(rset_3.getString("FREQ_DESC"))+" "+checkForNull(rset_3.getString("DURN_VALUE"))+" "+checkForNull(rset_3.getString("DURN_DESC")));
						
					} else {
						dosagedetails = (checkForNull(rset_3.getString("QTY_VALUE"))+" "+checkForNull(rset_3.getString("QTY_UNIT"))+" "+checkForNull(rset_3.getString("FREQ_DESC"))+" "+checkForNull(rset_3.getString("DURN_VALUE"))+" "+checkForNull(rset_3.getString("DURN_DESC")));
					}
				} 
				else  {
					if(found) { 
						tmp_string	= "<label style='color:red'>(Divided) </label>";
						tmp_qty		= checkForNull(rset_3.getString("QTY_VALUE"));
					}
					else {
						tmp_string	= "";
						tmp_qty		= divided;
					}
					if(calc_dosg_by_freq.equals("N")) {
						dosagedetails = (checkForNull(rset_3.getString("FREQ_DESC"))+" "+checkForNull(rset_3.getString("DURN_VALUE"))+" "+checkForNull(rset_3.getString("DURN_DESC")));
						
					} 
					else {
						dosagedetails = (tmp_qty+" "+tmp_string+" "+checkForNull(rset_3.getString("QTY_UNIT"))+"  "+checkForNull(rset_3.getString("FREQ_DESC"))+" "+checkForNull(rset_3.getString("DURN_VALUE"))+" "+checkForNull(rset_3.getString("DURN_DESC")));
					}
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( rset_1 ) ;
				closeResultSet( rset_2 ) ;
				closeResultSet( rset_3 ) ;
				closeStatement( pstmt_1 ) ;
				closeStatement( pstmt_2 ) ;
				closeStatement( pstmt_3 ) ;
				closeConnection( connection ); 
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return dosagedetails;
	}
	

/*	public ArrayList getInstructions(String drug_code,String order_id,String order_line_no){
		Connection connection		= null;
        PreparedStatement pstmt		= null;
		PreparedStatement pstmt_int	= null;
        ResultSet resultSet			= null;	
		ArrayList instructions_res 	= new ArrayList();
		ArrayList instructions		= new ArrayList();
		ArrayList	temp = new ArrayList();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDI_EDIT_INSTRUCTIONS")) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2,drug_code);
			pstmt.setString(3,order_id);
			pstmt.setString(4,order_line_no);
			pstmt.setString(5,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				instructions_res.add(checkForNull((String)resultSet.getString("CAUTION_LABEL_TEXT_ID_1")));	
				//instructions_res.add(checkForNull((String)resultSet.getString("CAUTION_LABEL_TEXT_ID_2")));	
				instructions_res.add(checkForNull((String)resultSet.getString("SPL_INSTR_LABEL_TEXT_ID")));	
				//instructions_res.add(checkForNull((String)resultSet.getString("SPL_INSTR_LABEL_TEXT_ID1")));	
				instructions_res.add(checkForNull((String)resultSet.getString("HOW_TO_TAKE_TEXT")));
				//instructions_res.add(checkForNull((String)resultSet.getString("HOW_TO_TAKE_TEXT_LOCAL")));		
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			String tempString ="XX";
			if(instructions_res.size() > 0){	
				pstmt_int		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDI_EDIT_INT_RESULTS")) ;
				for(int i=0;i<2;i++){					
					if( (!(((String)instructions_res.get(i)).equals(tempString))) && (!( (((String)instructions_res.get(i))=="") || ( ((String)instructions_res.get(i)).equals("")  ) )))					{
					    resultSet		= null;
						pstmt_int.setString(1,(String)instructions_res.get(i));
						pstmt_int.setString(2,getLanguageId());
						resultSet	= pstmt_int.executeQuery() ;
						while (resultSet.next()){
						temp = new ArrayList();
						temp.add((String)resultSet.getString("LABEL_TEXT_1"));	
						temp.add((String)resultSet.getString("LABEL_TEXT_2"));
						temp.add((String)resultSet.getString("LABEL_TEXT_1_LOC_LANG"));
						temp.add((String)resultSet.getString("LABEL_TEXT_2_LOC_LANG"));
						/*if(i < 2){
							temp.add(instructions_res.get(4));
							temp.add(instructions_res.get(5));
						}else{
							temp.add("");
						}*/
/*						instructions.add(temp);

						}
					}else{
						temp = new ArrayList();
                        instructions.add(temp);
					}              
					tempString = (String)instructions_res.get(i);
				}
               temp = new ArrayList();
			   temp.add(instructions_res.get(2));
			 //  temp.add(instructions_res.get(5));
			   instructions.add(temp);
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt_int ) ;
				closeConnection( connection ); 
				}catch(Exception es){es.printStackTrace();}
		}
		return instructions;
	}*/	//ends here

	public ArrayList getInstructions(String drug_code,String order_id,String order_line_no){
		Connection connection		= null;
        PreparedStatement pstmt		= null;
		PreparedStatement pstmt1	= null;
		PreparedStatement pstmt_int	= null;
        ResultSet resultSet			= null;	
		ArrayList instructions_res 	= new ArrayList();
		ArrayList instructions		= new ArrayList();
		ArrayList	temp            = new ArrayList();
		ArrayList  lang_ids         = new ArrayList();
		String sTemptext = "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("SELECT B.CAUTION_LABEL_TEXT_ID_1,B.CAUTION_LABEL_TEXT_ID_2, B.SPL_INSTR_LABEL_TEXT_ID,B.SPL_INSTR_LABEL_TEXT_ID1,B.HOW_TO_TAKE_TEXT,B.HOW_TO_TAKE_TEXT_LOCAL FROM PH_DRUG B, OR_ORDER_LINE C WHERE  B.DRUG_CODE=? AND C.ORDER_ID=? AND C.ORDER_LINE_NUM=?");  //  C.ORDER_CATALOG_CODE=? AND -removed for ML-SCF-0300 [34012]
			//pstmt.setString(1,drug_code);
			pstmt.setString(1,drug_code);
			pstmt.setString(2,order_id);
			pstmt.setString(3,order_line_no);
			//pstmt.setString(5,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				instructions_res.add(checkForNull((String)resultSet.getString("CAUTION_LABEL_TEXT_ID_1")));	
				instructions_res.add(checkForNull((String)resultSet.getString("SPL_INSTR_LABEL_TEXT_ID")));	
				sTemptext =java.net.URLEncoder.encode(checkForNull((String)resultSet.getString("HOW_TO_TAKE_TEXT")),"UTF-8"); 
				instructions_res.add(sTemptext);
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			//String tempString ="XX";
			if(instructions_res.size() > 0){	
				//pstmt_int		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDI_EDIT_INT_RESULTS")) ;
				pstmt_int		= connection.prepareStatement("SELECT LABEL_TEXT_1, language_id FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_ID=? /*and rownum<3*/ and ordby < 3 ");
				for(int i=0;i<2;i++){					
					if( (!((((String)instructions_res.get(i))==null) || (((String)instructions_res.get(i)).equals(""))))){
					    resultSet		= null;
						pstmt_int.setString(1,(String)instructions_res.get(i));
						//pstmt_int.setString(2,getLanguageId());
						resultSet	= pstmt_int.executeQuery() ;
						temp			= new ArrayList();
						lang_ids        = new ArrayList();
						while (resultSet.next()){							
							temp.add((String)instructions_res.get(i));	//added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
							sTemptext =java.net.URLEncoder.encode(checkForNull((String)resultSet.getString("LABEL_TEXT_1")),"UTF-8"); 
							temp.add(sTemptext);	
							temp.add((String)resultSet.getString("language_id"));	
							lang_ids.add(resultSet.getString("language_id"));
						}
						instructions.add(temp);
					}
					else{
						temp = new ArrayList();
                        instructions.add(temp);
					}              
					//tempString = (String)instructions_res.get(i);
				}
                closeStatement(pstmt);
			    closeResultSet(resultSet);
				temp = new ArrayList();
				pstmt_int		= connection.prepareStatement("select HOW_TO_TAKE_TEXT from ph_drug_lang_vw where drug_code =? and language_id=?");
				if(lang_ids.size() == 0){	
					lang_ids.add(getLanguageId());
                     pstmt1 =connection.prepareStatement("select language_id  from sm_language where  eff_status='E'  and PRIMARY_LANG_YN ='N' order by seq_no");
                     resultSet	= pstmt1.executeQuery() ;
					 if(resultSet.next()){
						lang_ids.add((String)resultSet.getString("language_id"));
				    }
				}
				for(int i=0;i<lang_ids.size();i++){
					resultSet		= null;
					pstmt_int.setString(1,drug_code);
					pstmt_int.setString(2,(String)lang_ids.get(i));
					resultSet	= pstmt_int.executeQuery() ;
					while (resultSet.next()){							
						sTemptext =java.net.URLEncoder.encode(checkForNull((String)resultSet.getString("HOW_TO_TAKE_TEXT")),"UTF-8"); 
						temp.add(sTemptext);
						temp.add((String)lang_ids.get(i));
					}
				}
				//temp.add(instructions_res.get(2));
				//temp.add(instructions_res.get(5));
			   instructions.add(temp);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt_int ) ;
				closeStatement( pstmt1 );
				closeConnection( connection ); 
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return instructions;
	}

	//code for Allow Drug in Dose....on 29/4/2004
	public String getAllDrugDosage(String order_id, String order_line_no,String disp_locn_code) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String allow_drug_dosage= "";
		String line_status		=	"";

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_ALL_DRUG_DOSAGE")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,disp_locn_code);
			pstmt.setString(3,login_by_id);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				allow_drug_dosage		=	resultSet.getString("CHANGE_DOSE_DURN_VERIFY_YN");			
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			if(allow_drug_dosage.equals("Y")) {
				pstmt		=	connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT57A"));
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_no);
				resultSet	= pstmt.executeQuery() ;
				
				if (resultSet!=null && resultSet.next()){
					line_status	=	checkForNull(resultSet.getString("ORDER_LINE_STATUS"));	
					if(!line_status.equals("OS") && !line_status.equals("VF") && !line_status.equals("RG") && !line_status.equals("UC")) { //UC added for  ML-BRU-SCF-1096 [IN:044470]
						allow_drug_dosage	=	"N";
					}
				}
				else {
					allow_drug_dosage	=	"N";
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
				es.printStackTrace();
			}
		}
		return allow_drug_dosage;

	}

	public HashMap getPackSize(String drug_code) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		HashMap pack_dtls		= new HashMap();

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT87")) ;
		  // String str ="SELECT CONTENT_IN_PRES_BASE_UOM,STOCK_UOM,STRENGTH_PER_VALUE_PRES_UOM ,ph_get_ext_prod_drug_code(drug_code,?)EXTERNAL_PRODUCT_ID  FROM PH_DRUG WHERE DRUG_CODE=?";
		  // pstmt		= connection.prepareStatement(str);
			
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,drug_code);

            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				pack_dtls.put("PACK_SIZE",checkForNull(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")));				
				pack_dtls.put("STOCK_UOM",checkForNull(resultSet.getString("STOCK_UOM")));	
				pack_dtls.put("STRENGTH_PER_VALUE_PRES_UOM",checkForNull(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")));	
				pack_dtls.put("EXTERNAL_PRODUCT_ID",checkForNull(resultSet.getString("external_product_id")));
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
		return pack_dtls;
	}

	public String getPresDetails(String order_id) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String pres_details		= "";
		String location			= "";

		try {
            connection	= getConnection() ;
            /* Added for ML-MMOH-CRF-0532 [IN061327] start */
            boolean siteOrder = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","ORDER_LOCATION");
           

            if(siteOrder){
	     pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT89_ORDER")) ;
                         }
else      {  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT89")) ;}
            /* Added for ML-MMOH-CRF-0532 [IN061327] end */		
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,order_id);
			pstmt.setString(5,getLanguageId());
			pstmt.setString(6,getLanguageId());
			pstmt.setString(7,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
                location		=	checkForNull(resultSet.getString("LOCATION"));

				java.util.Locale loc					= new java.util.Locale(getLanguageId());
				java.util.ResourceBundle common_labels  = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
				
				pres_details	=	common_labels.getString("Common.OrderingPractitioner.label")+" : "+resultSet.getString("PRACTITIONER_NAME")+"\n"+ common_labels.getString("Common.OrderingLocation.label")+" : "+location;
				if(resultSet.getString("AUTH_BY_NAME")!=null && !(resultSet.getString("AUTH_BY_NAME").equals(""))){			
				     pres_details= pres_details  +"\n" +  common_labels.getString("Common.authorizedby.label") +"  : "+ resultSet.getString("AUTH_BY_NAME");	
				}
				if(resultSet.getString("APPR_BY_NAME")!=null && !(resultSet.getString("APPR_BY_NAME").equals(""))){			
				     pres_details= pres_details  +"\n" +  common_labels.getString("Common.Approved.label") +"  : "+ resultSet.getString("APPR_BY_NAME");	
				}
				if(resultSet.getString("COSIGN_BY_NAME")!=null && !(resultSet.getString("COSIGN_BY_NAME").equals(""))){			
				     pres_details= pres_details  +"\n" + common_labels.getString("Common.Cosigned.label")+""+  common_labels.getString("Common.by.label") +"  : "+ resultSet.getString("COSIGN_BY_NAME");	
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
				es.printStackTrace();
			}
		}
		return pres_details;
	}

	public ArrayList getDispenseLocns() throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String	disp_locn_code	=	"";
		String disp_locn_desc   =	"";
		 
		ArrayList displocns		=	new ArrayList();
		try {

            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_PRINT_DIALOG_SELECT")) ;

			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				disp_locn_code				=	checkForNull(resultSet.getString("DISP_LOCN_CODE"));//DISP_LOCN_CODE
				disp_locn_desc		=	checkForNull(resultSet.getString("SHORT_DESC"));//SHORT_DESC
				
				displocns.add(disp_locn_code);
				displocns.add(disp_locn_desc);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}	
		return displocns;
	}

    public int CheckBMSYN(String order_id, String order_line_no) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		int count				= 0;

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT175")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next())
				count = resultSet.getInt("cnt");
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
//Function getPatCounsReqdyn() returns the status of PAT_COUNS_REQD_YN for the corresponding order_id and order_line_no

	public String getPatCounsReqdyn(String order_id, String order_line_no) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String pat_couns_reqd_yn =	"";

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT99")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				pat_couns_reqd_yn = resultSet.getString("PAT_COUNS_REQD_YN");
				if(pat_couns_reqd_yn == null) pat_couns_reqd_yn="N";
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
		return pat_couns_reqd_yn;
	}

//Function getPatCounsReqd() returns the status of PAT_COUNS_REQD_YN for the corresponding drug_code from the ph_grug table
	public String getPatCounsReqd(String drug_code) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String pt_couns_reqd_yn =	"";

		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT113")) ;
			pstmt.setString(1,drug_code);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				pt_couns_reqd_yn = resultSet.getString("PT_COUN_REQD_YN");
				if(pt_couns_reqd_yn == null) pt_couns_reqd_yn="N";
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
		return pt_couns_reqd_yn;
	}

	public String getChngdFluidRemarks(String strOrderIdIn,String strOrderLineNumIn){
		Connection cnChnFldRmks	= null;
        PreparedStatement pstChnFldRmks = null;
        ResultSet rsChnFldRmks = null;
		String strChgdFldRmks = "";

		try{
            cnChnFldRmks		= getConnection() ;
            pstChnFldRmks		= cnChnFldRmks.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDI_CH_FLD_RMKS") );
			pstChnFldRmks.setString(1,strOrderIdIn);
			pstChnFldRmks.setString(2,strOrderLineNumIn);
			rsChnFldRmks	= pstChnFldRmks.executeQuery() ;
			
			if (rsChnFldRmks.next())
				strChgdFldRmks = rsChnFldRmks.getString("CHNGD_FLUID_REMARKS");
		}
		catch ( Exception e ){
			e.printStackTrace() ;			
		}
		finally{
			try{
				closeResultSet( rsChnFldRmks ) ;
				closeStatement( pstChnFldRmks ) ;
				closeConnection( cnChnFldRmks ); 
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
	
		return strChgdFldRmks;
	}
	public String getOrderId(String disp_no,String curr_stage) throws Exception{
		
		String order_id				= "";
        Connection connection			= null ;
        PreparedStatement pstmt			= null ;
        ResultSet resultSet				= null;

        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT139") ) ;
			
			pstmt.setString(1,curr_stage);
			pstmt.setString(2,disp_no);
			pstmt.setString(3,login_facility_id);
			pstmt.setString(4,curr_stage);
			pstmt.setString(5,disp_no);
			pstmt.setString(6,login_facility_id);
		    resultSet = pstmt.executeQuery() ;

            if ( resultSet != null && resultSet.next() ) {
				order_id	=	resultSet.getString("ORDER_ID");
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return order_id;
	}

	public String getFractRoundupYN(String drug_code) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String fract_roundup_yn		=	"";

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT92")) ;
			pstmt.setString(1,drug_code);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				fract_roundup_yn	=	resultSet.getString("FRACT_DOSE_ROUND_UP_YN");	
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
		return fract_roundup_yn;
	}

	public HashMap getqtyvalue(String drug_code,String order_id,String order_line_num) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		HashMap alt_dtls		= new HashMap();
		String freq_code        = "";

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT121")) ;
			pstmt.setString(1,drug_code);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				alt_dtls.put("STRENGTH_VALUE",checkForNull(resultSet.getString("STRENGTH_VALUE")));	
				alt_dtls.put("STRENGTH_PER_VALUE_PRES_UOM",checkForNull(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")));
						
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			 pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT122")) ;
			 pstmt.setString(1,order_id);
			 pstmt.setString(2,order_line_num);
             resultSet	= pstmt.executeQuery() ;
			 if (resultSet.next()){
				alt_dtls.put("QTY_VALUE",checkForNull(resultSet.getString("QTY_VALUE")));
				freq_code=checkForNull(resultSet.getString("FREQ_CODE"));
				alt_dtls.put("FREQ_CODE",freq_code);
				
					
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT124")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				alt_dtls.put("SPLIT_DOSE_YN",checkForNull(resultSet.getString("SPLIT_DOSE_YN")));
				alt_dtls.put("DOSAGE_TYPE",checkForNull(resultSet.getString("DOSAGE_TYPE")));
				alt_dtls.put("TOT_STRENGTH",checkForNull(resultSet.getString("TOT_STRENGTH")));


			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			if(freq_code!=null && (!freq_code.equals(""))){
				pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES_SELECT3")) ;
				pstmt.setString(1,freq_code);
				
				resultSet	= pstmt.executeQuery() ;
				if (resultSet.next()){
					alt_dtls.put("repeat_value",checkForNull(resultSet.getString("repeat_value")));
						
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
				es.printStackTrace();
			}
		}
		return alt_dtls;
	}

	public String getOrderqty(String order_id,String order_line_num) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String order_qty		=	"";

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT123")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				order_qty	=	resultSet.getString("ORDER_QTY");	
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
		return order_qty;
	}
//this function is used check whether the drug is being taperd or not 
	public HashMap chkfortapering(String order_id,String order_catalog_code,String order_line_num, String patient_id) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		int	count				= 0;
		String taper_dose_yn	= "N";
		String taper_up			= "N";
		taper					= "";
		HashMap taperValues=new HashMap();

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT131")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,order_catalog_code);//order_line_num
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				count	=	resultSet.getInt("TOTAL");
				taperValues.put("COUNT", count);
				taperValues.put("TOT_QTY",resultSet.getInt("TOT_QTY"));
			}
            closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			if(count>1){
                pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT132")) ;
				pstmt.setString(1,order_catalog_code);
				resultSet	= pstmt.executeQuery() ;
				if (resultSet.next()){
					taper_dose_yn	=	resultSet.getString("TAPER_DOSE_YN");
					taper_up		=	resultSet.getString("TAPER_UP");
				} 

				if(taper_up !=null  && taper_up.equals("Y")){
					 taper ="UP";
				}
				else if(taper_dose_yn !=null &&taper_dose_yn.equals("Y") ){
					 taper ="DOWN";
				}
			}
			setTapervalue(taper);
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
		return taperValues;
	}

// added last 4 functions for the  Remarks to be displayed. 

	public String getPRNInstructions(String order_id,String order_line_no)throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String prn_remarks		= "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_PRN_REMARKS")) ;
	//		pstmt		= connection.prepareStatement("SELECT PRN_REMARKS FROM PH_PATIENT_DRUG_PROFILE WHERE ORIG_ORDER_ID = (?) AND ORIG_ORDER_LINE_NO = (?)");
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
            resultSet	= pstmt.executeQuery() ;
			while (resultSet !=null && resultSet.next()){
				prn_remarks	= checkForNull(resultSet.getString("PRN_REMARKS"));		
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return prn_remarks;
	}

	public String getPrescriptionInstructions(String order_id){
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;
		String prescription_instructions= "";
		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT22A")) ;
			pstmt.setString(1,order_id);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				prescription_instructions=  checkForNull(resultSet.getString("ORDER_COMMENT"));		
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
		return prescription_instructions;
	}

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

	public String getPharmacistInstructions(String order_id,String order_line_no,String from_disp){
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;
		StringBuffer pharmacist_instructions= new StringBuffer(); //String changed to StringBuffer for ML-BRU-SCF-1563 [IN:053848]
		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_REMARKS2B")) ;//added for ML-BRU-SCF-1563 [IN:053848] -start
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				pharmacist_instructions.append(checkForNull(resultSet.getString("ALLOCATE_TASK_FINDING")));
				if(pharmacist_instructions.length()>0)
					pharmacist_instructions.append("\n");
				pharmacist_instructions.append(checkForNull(resultSet.getString("FILL_TASK_FINDING")));
				if(pharmacist_instructions.length()>0)
					pharmacist_instructions.append("\n");
				pharmacist_instructions.append(checkForNull(resultSet.getString("DELIVERY_TASK_FINDING")));
			}//added for ML-BRU-SCF-1563 [IN:053848] -end
			if(pharmacist_instructions.length()==0){ //if condition added for ML-BRU-SCF-1563 [IN:053848]
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(from_disp.equals("N"))
					pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_REMARKS2")) ;
				else
					pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_REMARKS2A")) ;
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_no);
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					pharmacist_instructions.append(checkForNull(resultSet.getString("ALLOCATE_TASK_FINDING")));
					if(pharmacist_instructions.length()>0)//new line character added cinditionaly for ML-BRU-SCF-1563 [IN:053848]
						pharmacist_instructions.append("\n");
					pharmacist_instructions.append(checkForNull(resultSet.getString("FILL_TASK_FINDING")));
					if(pharmacist_instructions.length()>0)
						pharmacist_instructions.append("\n");
					pharmacist_instructions.append(checkForNull(resultSet.getString("DELIVERY_TASK_FINDING")));
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
		return pharmacist_instructions.toString();
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


	public String getVerificationRemarks(String order_id,String order_line_no){
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;
		String verify_remarks	= "";
		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_REMARKS6")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){				
				verify_remarks= checkForNull(resultSet.getString("VERIFY_REMARKS"));
			}
		}
		catch ( Exception e ) {
			System.err.println("===order_id====>"+order_id+" ====order_line_no="+order_line_no);
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
		return verify_remarks;
	}

	public ArrayList getDispSrlNO(String disp_no,String curr_stage) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		ArrayList alt_dtls		= new ArrayList();
		String allow_zero_qty_YN=disp_bean.getStrIncludeZeroAllocQtyItemsForIP();//added for ml-bru-crf-0473

		/*	A--->allocation/filling
		    D---->delivery/allstages*/
		try {
            connection	= getConnection() ;
			if(allow_zero_qty_YN.equals("Y"))//if else added for ml-bru-crf-0473
            pstmt		= connection.prepareStatement("select dtl_serial_num S_NO from ph_disp_dtl_tmp  where ?='A' and DISP_TMP_NO=? and facility_id=? union all  select SRL_NO S_NO from ph_disp_dtl  where ?='D' and DISP_NO=? and facility_id=?  union all  select SRL_NO S_NO from ph_disp_cons_dtl  where DISP_NO=? and facility_id=? ") ;
			else
			 pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT136")) ;
			//pstmt		= connection.prepareStatement("select s_no from( SELECT dtl_serial_num s_no, order_line_no  FROM ph_disp_dtl_tmp  WHERE ? = 'A'    AND disp_tmp_no = ?    AND facility_id = ?    AND disp_qty > 0  UNION ALL SELECT srl_no s_no, order_line_no   FROM ph_disp_dtl  WHERE ? = 'D' AND disp_no = ? AND facility_id = ? AND disp_qty > 0) order by s_no desc ");
			pstmt.setString(1,curr_stage);
			pstmt.setString(2,disp_no);
			pstmt.setString(3,login_facility_id);
			pstmt.setString(4,curr_stage);
			pstmt.setString(5,disp_no);
			pstmt.setString(6,login_facility_id);
			pstmt.setString(7,disp_no);//Added for [IN:047652]
			pstmt.setString(8,login_facility_id);//Added for [IN:047652]

            resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null){
				while(resultSet.next()){
					alt_dtls.add(resultSet.getString("S_NO"));	
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
				es.printStackTrace();
			}
		}
		return alt_dtls;
	}

	public ArrayList getOrderLineFieldValues(String order_id) {
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		ArrayList order_line_field_values	= new ArrayList();	

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT138")) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				order_line_field_values.add(resultSet.getString("ORDER_LINE_FIELD_VALUE"));	
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
		return order_line_field_values;
   }
//this function is used get repeat value for In with additives
 //repaetvalue=duration/infuseover
   public int getRepeatValue(String order_id) {
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		int repaat_value					=0;

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT140")) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				repaat_value=resultSet.getInt("RepeatValue");	
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
		return repaat_value;
   }

	public ArrayList getpendingorders(String patient_id,String ordering_facility_code, String Disp_locn_code,String called_from) {
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		ArrayList pendingorders				= new ArrayList();	
		//String next_link					= "";
		//String next_link_str				= "";	
		String Disp_locn_code1="";
		
		if(disp_bean == null)
			disp_bean = new DispMedicationBean(); //Added for COMMON-ICN-0152-TF[48287]
		
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT147")) ;			
			
			//Modiied Query for getting Uncollected Status in Pending orders regarding incident num:24496 on 18/Oct/2010====By Naveen
			// pstmt		= connection.prepareStatement("SELECT DISTINCT a.order_id,TO_CHAR (a.ord_date_time, 'dd/mm/yyyy hh24:mi') ord_date_time,a.ord_date_time ord_dt_time, c.token_serial_no token_series_num,d.description token_series_desc,f.short_desc order_status_desc,DECODE (?,e.disp_locn_code, '!' || e.short_desc,e.short_desc) s_disp_locn, g.drug_desc drug_desc,TO_CHAR (b.start_date_time, 'dd/mm/yyyy hh24:mi') start_date,b.order_line_status line_status,TO_CHAR (c.queue_date, 'dd/mm/yyyy') token_date, a.performing_deptloc_code disp_locn_code,h.facility_name ord_facility_name, (case when (a.performing_deptloc_code = nvl(d.disp_locn_code,a.performing_deptloc_code) )then ( select short_desc from ph_disp_locn_lang_vw where disp_locn_code= a.performing_deptloc_code and language_id =?) else (select short_desc from ph_disp_locn_lang_vw where disp_locn_code= d.disp_locn_code and language_id =?) end )  disp_locn FROM or_order a,ph_ord_for_disp_queue c,ph_token_series_lang_vw d,ph_disp_locn_lang_vw e,or_order_status_code_lang_vw f, or_order_line b,ph_drug_lang_vw g,sm_facility_param_lang_vw h WHERE a.patient_id = ? AND a.performing_deptloc_code = NVL (?, a.performing_deptloc_code) AND f.order_status_code = b.order_line_status AND (TO_NUMBER (f.order_status_type) < 58 or TO_NUMBER (f.order_status_type) ='94') AND a.order_id = c.order_id(+) AND a.patient_id = c.patient_id(+) AND c.facility_id = d.facility_id(+) AND c.disp_locn_code = d.disp_locn_code(+) AND c.token_series_code = d.token_series_code(+) AND e.facility_id = a.performing_facility_id AND e.disp_locn_code = a.performing_deptloc_code AND a.order_id = b.order_id AND b.order_catalog_code = g.drug_code AND ph_check_ord_date_dispensing (b.start_date_time, b.end_date_time, ?) = 1 AND g.language_id = ? AND e.language_id = ? AND f.language_id(+) = ? AND a.ordering_facility_id = h.facility_id AND a.ordering_facility_id = NVL (?, a.ordering_facility_id) AND h.language_id = ? ORDER BY s_disp_locn, c.token_serial_no, a.order_id") ;	//sql moved to repository for SRR20056-SCF-7781	28178
			
			pstmt.setString(1,Disp_locn_code); 
			pstmt.setString(2,getLanguageId()); 
			pstmt.setString(3,getLanguageId()); 
			pstmt.setString(4,patient_id); 
			if(called_from.equals("Dispensing")) 
				Disp_locn_code1=""; 
			else 
				Disp_locn_code1=Disp_locn_code; 
			pstmt.setString(5,Disp_locn_code1); 
			pstmt.setString(6,login_facility_id); 
			pstmt.setString(7,disp_bean.getDisp_before_start_date_yn()); //Added for COMMON-ICN-0120 [40745]  
			pstmt.setString(8,disp_bean.getDisp_before_no_of_days()); //Added for COMMON-ICN-0120 [40745] 
			pstmt.setString(9,disp_bean.getDisp_beyond_earliest_start_yn()); //Added for COMMON-ICN-0120 [40745] 
			pstmt.setString(10,disp_bean.getDisp_beyond_no_of_days()); //Added for COMMON-ICN-0120 [40745] 
			pstmt.setString(11,getLanguageId()); 
			pstmt.setString(12,getLanguageId()); 
			pstmt.setString(13,getLanguageId()); 
			pstmt.setString(14,ordering_facility_code); 
			pstmt.setString(15,getLanguageId()); 
			resultSet	= pstmt.executeQuery() ; 
			while(resultSet.next()){
				pendingorders.add(resultSet.getString("order_id"));
				pendingorders.add(resultSet.getString("drug_desc"));
				pendingorders.add(resultSet.getString("start_date"));
				pendingorders.add(resultSet.getString("order_status_desc"));
				pendingorders.add((resultSet.getString("token_series_desc")==null ? "":resultSet.getString("token_series_desc")));
				pendingorders.add((resultSet.getString("token_series_num")==null ? "":resultSet.getString("token_series_num")));						
				pendingorders.add((resultSet.getString("token_date")==null ? "":resultSet.getString("token_date")));
				pendingorders.add(resultSet.getString("disp_locn"));
				pendingorders.add(resultSet.getString("disp_locn_code"));
				pendingorders.add(resultSet.getString("ord_facility_name"));
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
		return pendingorders;
   }

	public ArrayList getpendingRefillorders(String patient_id,String order_id) {
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		ArrayList pendingrefillorders		= new ArrayList();	
		
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT157")) ;			
			pstmt.setString(1,patient_id);
			pstmt.setString(2,order_id);
			
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				pendingrefillorders.add(resultSet.getString("ORDER_ID"));
				pendingrefillorders.add(resultSet.getString("START_DATE_TIME"));
				pendingrefillorders.add(resultSet.getString("END_DATE_TIME"));				
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
		return pendingrefillorders;
   }

	//public int getBalanceMedicationcount(String disp_no)throws Exception{
	public String getBalanceMedicationDispNos(ArrayList disp_nos)throws Exception{ //method chenged for Bru-HIMS-CRF-415 [IN:045556]
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
		StringBuffer dispNosForBMS=new StringBuffer();
		StringBuffer dispNos=new StringBuffer();
		String stDispNosForBMS = "";
		int i=0;
        try {
			connection = getConnection() ;
			dispNos.append(" ( ");
			for(i=0;i<disp_nos.size();i++){
				if(i>0)
					dispNos.append(",");
				dispNos.append((String)disp_nos.get(i));
			}
			dispNos.append(" ) ");
			pstmt = connection.prepareStatement("SELECT  b.DISP_TMP_NO FROM or_order_line a, ph_disp_dtl_tmp b WHERE a.order_id = b.order_id AND a.order_line_num = b.order_line_no AND b.BMS_QTY>0 AND b.DISP_TMP_NO in "+dispNos +" order by DISP_TMP_NO ");
		    resultSet = pstmt.executeQuery() ;
			i=0;
            while ( resultSet != null && resultSet.next() ) {
				if(i>0)
					dispNosForBMS.append(",");
				dispNosForBMS.append(resultSet.getInt("DISP_TMP_NO") );
				i++;
			}
			if(i==0){
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
				dispNos.delete(0, dispNos.length());//Added for  KAUH Production upgrade [IN:049692] -start
				dispNos.append(" ( ");
				for(i=0;i<disp_nos.size();i++){
					if(i>0)
						dispNos.append(",");
					dispNos.append("'"+(String)disp_nos.get(i)+"'");
				}
				dispNos.append(" ) ");//added for KAUH Production upgrade [IN:049692] end
				pstmt = connection.prepareStatement("SELECT to_number(b.disp_no) disp_no FROM or_order_line a ,ph_disp_dtl b WHERE a.order_id =b.order_id AND a.order_line_num=b.order_line_no AND order_line_status='DP' AND b.disp_no in "+dispNos +" order by disp_no ");
				resultSet = pstmt.executeQuery() ;
				i=0;
				while ( resultSet != null && resultSet.next() ) {
					if(i>0)
						dispNosForBMS.append(",");
					dispNosForBMS.append(resultSet.getInt("DISP_NO") );
					i++;
				}
			}
			if(i>0)
				stDispNosForBMS = dispNosForBMS.toString();
		}
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
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
		return stDispNosForBMS;
	}

	//method fpr getiing complete order reasons
	public ArrayList getCompleteReasonCodes() {
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		ArrayList complete_reason_codes		= new ArrayList();	
		try {
            connection	= getConnection() ;
           	pstmt		= connection.prepareStatement( "SELECT reason_code,reason_desc FROM ph_medn_trn_reason WHERE appl_trn_type='CO' AND eff_status='E'");

			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				complete_reason_codes.add(resultSet.getString("reason_code"));				
				complete_reason_codes.add(resultSet.getString("reason_desc"));								
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
		return complete_reason_codes;
   }
	//code added for Billing interface(sriraj--thailand) on 4/22/2006
	public String checkforbillinginterface()throws Exception{
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet			    = null;	
		bl_interface_yn					= "N";
		try{
			connection = getConnection() ;
			pstmt_select = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT2")) ;
			pstmt_select.setString(1,login_facility_id);
			resultSet				= pstmt_select.executeQuery();
			if (resultSet.next() ) {
				bl_interface_yn=resultSet.getString("BL_INTERFACE_YN");
				if(bl_interface_yn==null){
					bl_interface_yn="N";
				}
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		finally{
			    closeResultSet( resultSet ) ;
				closeStatement( pstmt_select ) ;
				closeConnection( connection );
		}
		setBLInterfaceYN(bl_interface_yn);
		return bl_interface_yn;
	}

/*	public HashMap callItemChargeDtls(String patient_id,String encounter_id,String sal_trn_type,String item_code,String item_qty)throws Exception{
			
		Connection connection = null;
		CallableStatement callableStatement = null;
		HashMap message = new HashMap();
		
		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, login_facility_id);
			callableStatement.setString(2, patient_id);
			callableStatement.setString(3, "ST");
			callableStatement.setString(4, encounter_id);
			callableStatement.setString(5, sal_trn_type);
			callableStatement.setString(6, disp_bean.getTodaysDate());
			callableStatement.setString(7, item_code);
			callableStatement.setString(8, disp_bean.getStoreCode());
			callableStatement.setInt(9, Integer.parseInt(item_qty));
			callableStatement.setString(10, ";");
			callableStatement.registerOutParameter(11, Types.VARCHAR);
			callableStatement.registerOutParameter(12, Types.VARCHAR);
			callableStatement.registerOutParameter(13, Types.VARCHAR);
			callableStatement.registerOutParameter(14, Types.VARCHAR);
			callableStatement.registerOutParameter(15, Types.FLOAT);
			callableStatement.registerOutParameter(16, Types.FLOAT);
			callableStatement.registerOutParameter(17, Types.FLOAT);
			callableStatement.registerOutParameter(18, Types.FLOAT);
			callableStatement.registerOutParameter(19, Types.FLOAT);
			callableStatement.registerOutParameter(20, Types.FLOAT);
			callableStatement.registerOutParameter(21, Types.FLOAT);
			callableStatement.registerOutParameter(22, Types.FLOAT);
			callableStatement.registerOutParameter(23, Types.FLOAT);
			callableStatement.registerOutParameter(24, Types.FLOAT);
			callableStatement.registerOutParameter(25, Types.FLOAT);
			callableStatement.registerOutParameter(26, Types.FLOAT);
			callableStatement.registerOutParameter(27, Types.FLOAT);
			callableStatement.registerOutParameter(28, Types.FLOAT);
			callableStatement.registerOutParameter(29, Types.VARCHAR);
			callableStatement.registerOutParameter(30, Types.FLOAT);
			callableStatement.registerOutParameter(31, Types.VARCHAR);
			callableStatement.registerOutParameter(32, Types.VARCHAR);
			callableStatement.registerOutParameter(33, Types.VARCHAR);
			callableStatement.registerOutParameter(34, Types.VARCHAR);

			callableStatement.execute();
			
			message.put("daytypecode" , checkForNull((String)callableStatement.getString(11)));
			message.put("daytypedesc" , checkForNull((String)callableStatement.getString(12)));
			message.put("timetypecode" , checkForNull((String)callableStatement.getString(13)));
			message.put("timetypedesc" , checkForNull((String)callableStatement.getString(14)));
			message.put("baseqty" , callableStatement.getFloat(15)+"");			
			message.put("baserate" , callableStatement.getString(16)+"");
			message.put("addlfactor" ,callableStatement.getString(17)+"");
			message.put("grosschargeamt" , callableStatement.getString(18)+"");
			message.put("discountamt" , callableStatement.getString(20)+"");
			message.put("netchargeamt" , callableStatement.getString(21)+"");
			message.put("discountper" , callableStatement.getString(22)+"");
			message.put("patgrosschargeamt" , callableStatement.getString(23)+"");
			message.put("patdiscamt" , callableStatement.getString(24)+"");
			message.put("patnetamt" , callableStatement.getString(25)+"");
			message.put("custgrosschargeamt" , callableStatement.getString(26)+"");
			message.put("custdiscamt" , callableStatement.getString(27)+"");
			message.put("custnewamt" , callableStatement.getString(28)+"");			
			message.put("insind" , checkForNull((String)callableStatement.getString(29)));
			message.put("error_id" , checkForNull((String)callableStatement.getString(33)));
			message.put("error_msg" , checkForNull((String)callableStatement.getString(34)));

		}
		catch(Exception exception){
			
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		return message;
	}*/


	public String getEncounterPatientClass(String encounter_id, String patient_id) throws Exception{  //patient_id added for [IN:035667] 
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String patient_class	= "";
		try {
            encounter_id =checkForNull(encounter_id);
			 if(encounter_id ==null || encounter_id.equals("null"))
			    encounter_id="";
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1")) ;
			pstmt.setString(1,	login_facility_id.trim());
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,patient_id); //added for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				patient_class = checkForNull(resultSet.getString("ENC_PATIENT_CLASS"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		return patient_class;
	}

	public HashMap callItemChargeDtls(String patient_id,String encounter_id,String sal_trn_type,String item_code,double item_qty,String batch_str,String sysdate,String store_code,String bl_override_excl_incl_ind,String bl_incl_excl_override_reason_code,String order_id,String order_line_no,String disp_stage,String dischargeIND)throws Exception{
		//System.err.println("@@@@DISPMEDICATIONALLSTAGES callItemChargeDtls patient_id="+patient_id+" encounter_id="+encounter_id+" sal_trn_type="+sal_trn_type+" item_code="+item_code+" item_qty="+item_qty+" batch_str="+batch_str+" sysdate="+sysdate+" store_code="+store_code+" bl_override_excl_incl_ind="+bl_override_excl_incl_ind+" bl_incl_excl_override_reason_code="+bl_incl_excl_override_reason_code+" order_id="+order_id+" order_line_no="+order_line_no+" disp_stage="+disp_stage+" dischargeIND="+dischargeIND);
		Connection connection				= null;
		CallableStatement callableStatement = null;
		HashMap message						= new HashMap();
		PreparedStatement pstmt1			= null;
        ResultSet resultSet					= null;
		String total_charge_amt				= "";
		String patient_payable_amt			= "";
		String grosschargeamt				= "";
		PreparedStatement pstmt				= null;
		ResultSet rsDecimalPlace			= null;
		int decimal_place					= 0;
		String decimalFormatString			= "#0";
		String doc_no						= "";   
		String doc_type						= "";  
		String doc_srl_no					= "";
		String disp_billing_stage           ="";
		String bl_drugPenaltyStr           =""; //Added for JD-CRF-0170.1 [IN:040204]-Start
//		String bl_ruleDtails           =""; Removed for IN063877
		String  tmpToken=""; //bl_ruleCode = "",  Removed for IN063877
		String stKey = order_id+"~"+order_line_no+"~"+item_code;
		ArrayList alTempPenaltyDtls = null;
		StringTokenizer stokenDrugPenalty=null;
		StringTokenizer stokenTempDtls=null;
	//	StringTokenizer stokenRuleDtls = null;//JD-CRF-0170.1 [IN:040204] -end  Removed for IN063877
		encounter_id =checkForNull(encounter_id);
	    if(encounter_id ==null || encounter_id.equals("null"))
			    encounter_id="";

		if(sal_trn_type.equals(""))
			sal_trn_type="R";
		try{

           String worksheet_yn						 = "N";
		   String ord_type						     = disp_bean.getOrderType();
		  if(disp_stage.equals("A")||disp_stage.equals("F")||disp_stage.equals("D")){
			   disp_billing_stage=disp_bean.getDispBillStage(); // getDisp_Bill_Stage changed to getDispBillStage for SRR20056-SCF-7639ICN027720 
			   if(ord_type.equals("IVAA")||ord_type.equals("IVIA")||ord_type.equals("CA")||ord_type.equals("TA")||ord_type.equals("CO")){
					worksheet_yn  ="Y";        
			   }
		   }
           connection = getConnection();
           if(((disp_stage.equals("A")||disp_stage.equals("F"))&&worksheet_yn.equals("N")&&disp_billing_stage.equals("A"))||(disp_stage.equals("D")&&disp_billing_stage.equals("A"))){ 
				pstmt1		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;			
				pstmt1.setString(1,login_facility_id.trim());
				pstmt1.setString(2,store_code);
				pstmt1.setString(3,order_id);
				pstmt1.setString(4,order_line_no);
				pstmt1.setString(5,item_code);
				resultSet	= pstmt1.executeQuery() ;
				if(resultSet.next()){
					doc_no     = checkForNull(resultSet.getString("DOC_NO"));
					doc_type   = checkForNull(resultSet.getString("DOC_TYPE"));
					doc_srl_no = checkForNull(resultSet.getString("doc_srl_no"));
				}
				closeStatement(pstmt1) ;
				closeResultSet(resultSet);
		   }
			if(ord_type.equals("TD")){
				doc_srl_no = "2";
			}
//System.err.println("@@@@DISPMEDICATIONALLSTAGES callItemChargeDtls disp_billing_stage="+disp_billing_stage+" doc_type="+doc_type+" doc_no="+doc_no+" doc_srl_no="+doc_srl_no);
			
			callableStatement	= connection.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }"); // ?,? Added for MMS-MD-SCF-0102
			callableStatement.setString(1, disp_bean.getOrderingFacility()+"|"+login_facility_id);
			callableStatement.setString(2, patient_id);
			callableStatement.setString(3, "PH");
			callableStatement.setString(4, encounter_id);
			callableStatement.setString(5, sal_trn_type);
			callableStatement.setString(6, sysdate);
			callableStatement.setString(7, item_code);
			callableStatement.setString(8, store_code);
			callableStatement.setDouble(9,item_qty);
			callableStatement.setString(10, batch_str);
			callableStatement.registerOutParameter(11, Types.VARCHAR);
			callableStatement.registerOutParameter(12, Types.VARCHAR);
			callableStatement.registerOutParameter(13, Types.VARCHAR);
			callableStatement.registerOutParameter(14, Types.VARCHAR);
			callableStatement.registerOutParameter(15, Types.FLOAT);
			callableStatement.registerOutParameter(16, Types.FLOAT);
			callableStatement.registerOutParameter(17, Types.FLOAT);
			callableStatement.registerOutParameter(18, Types.FLOAT);
			callableStatement.registerOutParameter(19, Types.FLOAT);
			callableStatement.registerOutParameter(20, Types.FLOAT);
			callableStatement.registerOutParameter(21, Types.FLOAT);
			callableStatement.registerOutParameter(22, Types.FLOAT);
			callableStatement.registerOutParameter(23, Types.FLOAT);
			callableStatement.registerOutParameter(24, Types.FLOAT);
			callableStatement.registerOutParameter(25, Types.FLOAT);
			callableStatement.registerOutParameter(26, Types.FLOAT);
			callableStatement.registerOutParameter(27, Types.FLOAT);
			callableStatement.registerOutParameter(28, Types.FLOAT);
			callableStatement.registerOutParameter(29, Types.VARCHAR);
			callableStatement.registerOutParameter(30, Types.FLOAT);
			callableStatement.registerOutParameter(31, Types.VARCHAR);
			callableStatement.registerOutParameter(32, Types.VARCHAR);
			callableStatement.registerOutParameter(33, Types.VARCHAR);
			callableStatement.registerOutParameter(34, Types.VARCHAR);
			callableStatement.registerOutParameter(35, Types.VARCHAR);
			callableStatement.registerOutParameter(36, Types.VARCHAR);
			callableStatement.registerOutParameter(37, Types.VARCHAR);
			callableStatement.registerOutParameter(38, Types.VARCHAR);
			if(bl_override_excl_incl_ind.equals("")){
				callableStatement.setString(39, "");
			    callableStatement.setString(40, "");
			}
			else{
				callableStatement.setString(39, bl_override_excl_incl_ind);
			    callableStatement.setString(40, bl_incl_excl_override_reason_code);
			}

			callableStatement.setString(41, "N"); //Internal Adjestment
			callableStatement.setString(42, doc_type);
			callableStatement.setString(43, doc_no);
			callableStatement.setString(44, doc_srl_no);
			callableStatement.setString(45, dischargeIND);
			callableStatement.registerOutParameter(46, Types.VARCHAR); //added for JD-CRF-0170.1 [IN:040204]
			callableStatement.setString(47,order_id);//added for MMS-MD-SCF-0102
			callableStatement.setString(48, order_line_no);//added for MMS-MD-SCF-0102
			callableStatement.execute();
			
			grosschargeamt        = callableStatement.getString(19);
			total_charge_amt      = callableStatement.getString(21);
			patient_payable_amt   = checkForNull(callableStatement.getString(25),"0");

			message.put("error_id" , checkForNull((String)callableStatement.getString(33)));
			message.put("error_msg" , checkForNull((String)callableStatement.getString(34)));
			
			message.put("approval_reqd_yn" , checkForNull((String)callableStatement.getString(36),"N"));
			message.put("override_allowed_yn" , checkForNull((String)callableStatement.getString(37),""));
			message.put("pat_paid_amt" , checkForNull((String)callableStatement.getString(38)));
			message.put("pat_paid_flag" , checkForNull((String)callableStatement.getString(30)));
			bl_drugPenaltyStr = checkForNull((String)callableStatement.getString(46)); //added for JD-CRF-0170.1 [IN:040204] -Start
			if(!bl_drugPenaltyStr.equals("")){
				bl_drugPenaltyStr = bl_drugPenaltyStr.substring(0,bl_drugPenaltyStr.length()-1);//rule_code#hdr_lvl_min_amt#hdr_lvl_max_amt#blng_serv_code#serv_item_code#dtl_lvl_min_amt#dtl_lvl_max_amt#addlchargeamount@
				bl_drugPenaltyStr = bl_drugPenaltyStr.replaceAll("#"," #");
				stokenDrugPenalty	=	new StringTokenizer((String)bl_drugPenaltyStr,"@"); 
				alTempPenaltyDtls = new ArrayList();
				while(stokenDrugPenalty.hasMoreTokens()){
					stokenTempDtls = new StringTokenizer((String)stokenDrugPenalty.nextToken(), "#");
					while(stokenTempDtls.hasMoreTokens()){
						tmpToken = (String)stokenTempDtls.nextToken();
						if(stokenTempDtls.hasMoreTokens())
							tmpToken = tmpToken.substring(0,tmpToken.length()-1);
						//if(tmpToken.equals("#"))
						//	tmpToken = "";
						alTempPenaltyDtls.add(tmpToken);
					}
				}
				hmDrugPenaltyDtls.put(stKey, alTempPenaltyDtls);

			}	//added for JD-CRF-0170.1 [IN:040204] -End
//System.err.println("=<><><><><><><><><><>message="+message);

          /*If p_payment_flag  = 0 then 
                     Fully paid                                      -- Allow dispense
            Elsif p_payment_flag   = 1 then
                     Adjustement/Exemption/Written of service        -- Allow Dispense
            Elsif p_payment_flag   =2 then
                     Agreement done for Installment                  -- Allow Dispanse
            Elsif p_payment_flag   =3 then
                     Partial Payment done.                           -- Donot Allow Dispense as agreed by Vinod...
            End if;*/
           String excl_incl_ind ="";
			excl_incl_ind = checkForNull((String)callableStatement.getString(35),"");
            if(patient_payable_amt!=null && !patient_payable_amt.equals("")&&grosschargeamt!=null && !grosschargeamt.equals("")){  
				if( Float.parseFloat(patient_payable_amt)== Float.parseFloat(grosschargeamt)&& excl_incl_ind.equals("")){
					excl_incl_ind ="E";
				}
			}

			message.put("excl_incl_ind" ,excl_incl_ind);
            pstmt = connection.prepareStatement("SELECT BLCORE.GET_DECIMAL_PLACE(?) decimal_place FROM dual");
			pstmt.setString(1,login_facility_id);
			rsDecimalPlace = pstmt.executeQuery();
			if(rsDecimalPlace.next())
				decimal_place = rsDecimalPlace.getInt("decimal_place");
			closeStatement( pstmt ) ;
			closeResultSet(rsDecimalPlace);

			if(decimal_place > 0)
				decimalFormatString = decimalFormatString+".";

			for(int i=1;i<=decimal_place;i++){
				decimalFormatString = decimalFormatString+"0";
			}

			if(patient_payable_amt!=null && !patient_payable_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				patient_payable_amt = dfTest.format(Double.parseDouble(patient_payable_amt));
				message.put("patnetamt" ,patient_payable_amt+"");
				charge_dtls.put(order_id+order_line_no+item_code,patient_payable_amt+"");
			}
			if(total_charge_amt!=null && !total_charge_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				total_charge_amt = dfTest.format(Double.parseDouble(total_charge_amt));
				message.put("netchargeamt" ,total_charge_amt+"");
			}

			if(grosschargeamt!=null && !grosschargeamt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				grosschargeamt = dfTest.format(Double.parseDouble(grosschargeamt));
				message.put("grosschargeamt" ,grosschargeamt+"");
			}

			message.put("BL_DECIMAL_FORMAT_STRING",decimalFormatString);
			message.put("BATCH_STRING",batch_str);
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
			closeResultSet( resultSet ) ;
			closeStatement( pstmt1 ) ;
		}
//System.err.println("==message===="+message);
		return message;
	}
	//BL interface ends here 
    public HashMap getchargedetails(String patient_id ,String order_id, String order_line_no,String encounter_id,String sal_trn_type,String dischargeIND ){
		//System.err.println("@@@@DISPMEDICATIONALLSTAGES getchargedetails patient_id="+patient_id+" encounter_id="+encounter_id+" sal_trn_type="+sal_trn_type+" order_id="+order_id+" order_line_no="+order_line_no+" dischargeIND="+dischargeIND);
        HashMap result								= new HashMap();
        Connection connection						= null;  		
		PreparedStatement pstmt					= null;
		ResultSet resultSet						= null;
		try{
			StringBuffer batch_str						 = new StringBuffer();
			HashMap charge_det							 = new HashMap();
			String disp_stage							 = disp_bean.getDispStage();	
			String bl_override_excl_incl_ind			 = "";
			String bl_incl_excl_override_reason_code	 = "";
			String worksheet_yn						 = "N";
			 //String disp_stage							 =disp_bean.getDispStage();

			String ord_type						     = disp_bean.getOrderType();

			if(ord_type.equals("IVAA")||ord_type.equals("IVIA")||ord_type.equals("CA")||ord_type.equals("CO")){
				worksheet_yn                   ="Y";        
			}
			connection = getConnection();

			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT162"));
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				bl_override_excl_incl_ind         = checkForNull(resultSet.getString("BL_INCL_EXCL_OVERRIDE_VALUE"));
				bl_incl_excl_override_reason_code = checkForNull(resultSet.getString("BL_INCL_EXCL_OVERRIDE_REASON"));				
			}

			if(worksheet_yn.equals("N")|| disp_bean.getDispStage().equals("D")){
				 multi_drugs                   = (ArrayList)this.getMultiDrugs( patient_id,order_id,order_line_no);
				 ArrayList alt_drug_det        = new ArrayList();
				 HashMap drug_det               =new HashMap();//Added for ML-bru-scf-1803
				
				  double  item_qty				   = 0;	
				  double equvl_value               =1;
				  if(multi_drugs.size()>0){
					  for(int j=0; j<multi_drugs.size(); j+=5)	{
							 batch_str				 = new StringBuffer();
							 item_qty				 = 0;
							 String alt_drug_code	 = (String)multi_drugs.get(j);
							 alt_drug_det			 = this.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
							 equvl_value			 = getEquvlValue1(alt_drug_code) ;
							if(getBillableItemYN(alt_drug_code).equals("Y")) {
								if(patient_det.containsKey(patient_id))	{//Adding start for ML-BRU-SCF-1803
			               HashMap prescription	=	(HashMap)patient_det.get(patient_id);
								if(prescription.containsKey(order_id))	{
									HashMap order	=	(HashMap)prescription.get(order_id);
									if(order.containsKey(order_line_no))	{
									HashMap drug_record	=	(HashMap)order.get(order_line_no);
									if(drug_record.containsKey("alt_drug_det"))	{
										 drug_det	=	(HashMap)drug_record.get("alt_drug_det");
									 }
									}
								   }
								}  //Adding end for ML-BRU-SCF-1803

								for(int i=0; i<alt_drug_det.size(); i+=10){  //9->10 for MMS-SCF-0040 [IN:041888]
								//if(drug_det.containsKey(alt_drug_code+order_id+order_line_no)){//Adding start for ML-BRU-SCF-1803
									
									//item_qty   = item_qty+Double.parseDouble((String)drug_det.get(alt_drug_code+order_id+order_line_no)); //commented for ML-BRU-SCF-1841
									//System.err.println("DispMedicationAllStages.java===5983=item_qty======>"+item_qty);
							//	}else{//Adding end for ML-BRU-SCF-1803
									item_qty   = item_qty+Double.parseDouble((String)alt_drug_det.get(i+3)); 
								//}
									batch_str.append(alt_drug_det.get(i+6)).append(";").append(alt_drug_det.get(i+1)).append(";").append(alt_drug_det.get(i+2)).append(";").append(alt_drug_det.get(i+7)).append(";").append((Double.parseDouble((String)alt_drug_det.get(i+3))*(equvl_value))+"").append(";");
								}
							//	if(!disp_bean.issue_by_uom.equals("I"))
							//	item_qty	= (item_qty)*(equvl_value); //Commented for : MMS-SCF-0137 [IN:044603] and uncommented for SCF-1841
								charge_det	= (HashMap)callItemChargeDtls(patient_id,encounter_id,sal_trn_type,alt_drug_code,item_qty,batch_str.toString(),disp_bean.getTodaysDate(),disp_bean.getStoreCode(),"","",order_id,order_line_no,disp_stage,dischargeIND);
								result.put(alt_drug_code,charge_det);  
			//System.err.println("========<><><><><><>========charge_det="+charge_det);

							}
						}
				   }
				   else{
						ArrayList drug_details              = (ArrayList)this.getDrugDetail(patient_id,order_id,order_line_no);
						batch_str                           = new StringBuffer();
						item_qty				            = 0;	
						String flag                         = "N";
						String Charge_Pat_For_Spill_Qty_YN  = disp_bean.getChargePatForSpillQtyYN();
						//GENERIC;BATCH01;17/05/2008;DB;27;
						  // trade;batchid,exp_date,bin_loc,req_qty 
						 //C02BPRAHCL1MGTBA, SW, 24/03/2008, 1, P030, , GENERIC, DB, 0.704101
						 //0                  1   2          3   4    5  6        7   8 
						//callItemChargeDtls(patient_id,encounter_id,sal_trn_type,item_code,item_qty,bacthString)
						if(drug_details.size()>0){
							 String worksheet_id_1= disp_bean.getWorksheetID();
							 double spilqtyavail  = 0;
							 if(worksheet_id_1!=null && !worksheet_id_1.equals("")){
								  spilqtyavail = disp_bean.getSPILQTYAVAIL(order_id,order_line_no,login_facility_id,worksheet_id_1);
							 }

							 if(getBillableItemYN((String)drug_details.get(0)).equals("Y")) {
								 equvl_value = getEquvlValue1((String)drug_details.get(0)) ;
									for(int i=0; i<drug_details.size(); i+=10){ //9->10 for MMS-SCF-0040 [IN:041888]
										if(Charge_Pat_For_Spill_Qty_YN.equals("Y")&&flag.equals("N")&& spilqtyavail>0){
											flag     = "Y";
											item_qty = item_qty+spilqtyavail;
											batch_str.append(drug_details.get(i+6)).append(";").append(drug_details.get(i+1)).append(";").append(drug_details.get(i+2)).append(";").append(drug_details.get(i+7)).append(";").append((spilqtyavail*equvl_value)+"").append(";");
										}
										if(drug_details.get(i+3)!=null)
											item_qty  = item_qty+Double.parseDouble((String)drug_details.get(i+3));
										batch_str.append(drug_details.get(i+6)).append(";").append(drug_details.get(i+1)).append(";").append(drug_details.get(i+2)).append(";").append(drug_details.get(i+7)).append(";").append((Double.parseDouble((String)drug_details.get(i+3))*equvl_value)).append(";");
									}
									//item_qty   = (item_qty)*(equvl_value);  Commented for MMS-SCF-0137 [IN:044603]
			//System.err.println("@@@@DISPMEDICATIONALLSTAGES getchargedetails callItemChargeDtls patient_id="+patient_id+" encounter_id="+encounter_id+" sal_trn_type="+sal_trn_type+" item_code="+drug_details.get(0)+" item_qty="+item_qty+" batch_str="+batch_str+" disp_bean.getTodaysDate()="+disp_bean.getTodaysDate()+" disp_bean.getStoreCode()="+disp_bean.getStoreCode()+" bl_override_excl_incl_ind="+bl_override_excl_incl_ind+" bl_incl_excl_override_reason_code="+bl_incl_excl_override_reason_code+" order_id="+order_id+" order_line_no="+order_line_no+" disp_stage="+disp_stage+" dischargeIND="+dischargeIND);

									charge_det = (HashMap)callItemChargeDtls(patient_id,encounter_id,sal_trn_type,(String)drug_details.get(0),item_qty,batch_str.toString(),disp_bean.getTodaysDate(),disp_bean.getStoreCode(),bl_override_excl_incl_ind,bl_incl_excl_override_reason_code,order_id,order_line_no,disp_stage,dischargeIND);
									result.put(drug_details.get(0),charge_det);
	//System.err.println("========<><><><><><>========charge_det="+charge_det);
							 }
						}
				 }
			}
			else{

				Hashtable ht_ws_alloc_qty		  =   null;
				Hashtable ht_ws_allocated_batches = disp_bean.getHTWSAllocateBatches();

				ht_ws_alloc_qty     = (Hashtable)disp_bean.getHTWSAllocatedQty();
				ht_ws_alloc_qty		= (Hashtable)ht_ws_alloc_qty.get(order_line_no);
				int count			= 0;
				double ws_tot_qty	= 0;
				String ws_item_code = "";
				String ws_drug_code = "";
				String Charge_Pat_For_Spill_Qty_YN  =disp_bean.getChargePatForSpillQtyYN();
				double equvl_value  =1;

				if(ht_ws_allocated_batches.get(order_line_no) != null){
					ArrayList arr_list              = (ArrayList)ht_ws_allocated_batches.get(order_line_no);
					Hashtable ht_drug_details	    = disp_bean.getAllDrugDetails();
					ArrayList arr_list_drug_details = (ArrayList)ht_drug_details.get(order_line_no);
					String qty_avail_from_spillage  = (String)arr_list_drug_details.get(3);
					String flag                     = "N";
					for (int i=0;i<arr_list.size();i=i+15){

						 ws_item_code = (String)arr_list.get(i);
						 ws_drug_code = (String)arr_list.get(i+2);
						 equvl_value = getEquvlValue1(ws_item_code) ;
						
						if(ht_ws_alloc_qty.get(ws_item_code+ws_drug_code) != null){
							ArrayList arr_list_alloc_qty = (ArrayList)ht_ws_alloc_qty.get(ws_item_code+ws_drug_code);
							/*for (int jj=0;jj<arr_list_alloc_qty.size();jj++){
								ws_tot_qty += Integer.parseInt((String)arr_list_alloc_qty.get(jj));
							}*/

							if(Charge_Pat_For_Spill_Qty_YN.equals("Y")&&flag.equals("N")&&!qty_avail_from_spillage.equals("")){	        
								batch_str.append(arr_list.get(i+10)).append(";").append(arr_list.get(i+1)).append(";").append(arr_list.get(i+7)).append(";").append(arr_list.get(i+8)).append(";").append((Double.parseDouble(qty_avail_from_spillage)*equvl_value)+"").append(";");
							}


							flag ="Y";
						   ws_tot_qty += Double.parseDouble((String)arr_list_alloc_qty.get(count));
						   batch_str.append(arr_list.get(i+10)).append(";").append(arr_list.get(i+1)).append(";").append(arr_list.get(i+7)).append(";").append(arr_list.get(i+8)).append(";").append((Double.parseDouble((String)arr_list_alloc_qty.get(count))*equvl_value)+"").append(";");
						   count++;
						}					
					}
					if(Charge_Pat_For_Spill_Qty_YN.equals("Y")){
						   ws_tot_qty +=Double.parseDouble(qty_avail_from_spillage);
					}
					//ws_tot_qty =ws_tot_qty*equvl_value; Commented for MMS-SCF-0137 [IN:044603]
					 if(getBillableItemYN(ws_item_code).equals("Y")) {
			//System.err.println("@@@@DISPMEDICATIONALLSTAGES getchargedetails callItemChargeDtls patient_id="+patient_id+" encounter_id="+encounter_id+" sal_trn_type="+sal_trn_type+" ws_item_code="+ws_item_code+" ws_tot_qty="+ws_tot_qty+" batch_str="+batch_str+" disp_bean.getTodaysDate()="+disp_bean.getTodaysDate()+" ,disp_bean.getStoreCode()="+disp_bean.getStoreCode()+" bl_override_excl_incl_ind="+bl_override_excl_incl_ind+" bl_incl_excl_override_reason_code="+bl_incl_excl_override_reason_code+" order_id="+order_id+" order_line_no="+order_line_no+" disp_stage="+disp_stage+" dischargeIND="+dischargeIND);
						charge_det =(HashMap)callItemChargeDtls(patient_id,encounter_id,sal_trn_type,ws_item_code,ws_tot_qty,batch_str.toString(),disp_bean.getTodaysDate(),disp_bean.getStoreCode(),bl_override_excl_incl_ind,bl_incl_excl_override_reason_code,order_id,order_line_no,disp_stage,dischargeIND);
	//System.err.println("========<><><><><><>========charge_det="+charge_det);
						result.put(ws_item_code,charge_det);
				   }
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeConnection(connection);
			    closeResultSet( resultSet ) ;
			    closeStatement( pstmt ) ;
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return result;
	}

	//BL interface ends here 

	public HashMap getbatchString(String patient_id ,String order_id, String order_line_no,String drug_code){

		 HashMap batch_details         = new HashMap();
		 Connection connection			    =	null ;
		 PreparedStatement pstmt			=	null ;
		 ResultSet resultSet				=	null ;
        try{
			 multi_drugs                   = (ArrayList)this.getMultiDrugs( patient_id,order_id,order_line_no);
			 ArrayList alt_drug_det        = new ArrayList();
			 String trade_name			   = "";
			 connection					   = getConnection() ;
			// pstmt						   = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT164")) ;Code Commented for [IN037289].
			 ArrayList temp			       = new ArrayList();
							
			if(multi_drugs.size()>0){
				for(int j=0; j<multi_drugs.size(); j+=5)	{
					String alt_drug_code	 =(String)multi_drugs.get(j);
				//Commented due to checkstyle	 String alt_drug_desc	 =(String)multi_drugs.get(j+1);
					alt_drug_det			 = this.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
				    temp			       = new ArrayList();
					for(int i=0; i<alt_drug_det.size(); i+=10){  //9->10 for MMS-SCF-0040 [IN:041888]
						trade_name=(String)alt_drug_det.get(i+6); 
						/*pstmt.setString(1,(String)alt_drug_det.get(i+6)); 
						pstmt.setString(2,getLanguageId());
						resultSet				= pstmt.executeQuery();
						if(resultSet!=null && resultSet.next()){
							trade_name = resultSet.getString("LONG_NAME");			
						}*/ //Commented for [IN037289]
						temp.add(trade_name);
						temp.add(alt_drug_det.get(i+1));
						temp.add(alt_drug_det.get(i+3));
						//if(!alt_drug_det.get(i+4).equals(alt_drug_det.get(i+9)))//if condition added for ML-BRU-SCF-1433.1 [IN:058589] //4 is dispensing uom and 9 is base uom when base uom and disp uom r != then disp uom should display
							//temp.add(alt_drug_det.get(i+4));	
						//else
							temp.add(alt_drug_det.get(i+9));	//4->9 for MMS-SCF-0040 [IN:041888]	
					}
					batch_details.put(order_id+order_line_no+alt_drug_code,temp);
				}
			}
			else{
				ArrayList drug_details          = (ArrayList)this.getDrugDetail(patient_id,order_id,order_line_no);
				if(drug_details.size()>0){
				    temp			       = new ArrayList();
					for(int i=0; i<drug_details.size(); i+=10){  //9->10 for MMS-SCF-0040 [IN:041888]
						trade_name=(String)drug_details.get(i+6); 
						/*pstmt.setString(1,(String)drug_details.get(i+6)); 
						pstmt.setString(2,getLanguageId());
						resultSet				= pstmt.executeQuery();
						if(resultSet!=null && resultSet.next()){
							trade_name = resultSet.getString("LONG_NAME");			
						} */ //Commented [IN037289]
						temp.add(trade_name);
						temp.add(drug_details.get(i+1));
						temp.add(drug_details.get(i+3));
						temp.add(drug_details.get(i+9));//4->9 for MMS-SCF-0040 [IN:041888]
					}	
					batch_details.put(order_id+order_line_no+drug_code,temp);
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
		return batch_details;
	}

   public ArrayList getOtherRefFacility() { 
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		ArrayList	ref_facility	=	new ArrayList() ;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT110B"));
			pstmt.setString(1,getLanguageId());
			resultSet	        = pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next() ) {
				ref_facility.add(resultSet.getString("hcare_setting_type_code"));
				ref_facility.add(resultSet.getString("short_desc"));
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
		return ref_facility;	
	}	

	public HashMap getOverrideremarks(String order_id ,String order_line_no) { 
		Connection connection					=	null ;
		PreparedStatement pstmt					=	null ;
		ResultSet resultSet						=	null ;        
		HashMap	overrideremarks					=	new HashMap() ;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT154"));
			
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);

			resultSet	        = pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next() ) {
				if(resultSet.getString("DRUG_DB_PRODUCT_ID")!=null)
					overrideremarks.put("DRUG_DB_PRODUCT_ID",resultSet.getString("DRUG_DB_PRODUCT_ID"));
				if(resultSet.getString("ALLERGY_OVERRIDE_REASON")!=null)
					overrideremarks.put("ALLERGY_OVERRIDE_REASON",resultSet.getString("ALLERGY_OVERRIDE_REASON"));
				if(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")!=null)
					overrideremarks.put("DOSAGE_LIMIT_OVERRIDE_REASON",resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
				if(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")!=null)
					overrideremarks.put("DUPLICATE_DRUG_OVERRIDE_REASON",resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
				if(resultSet.getString("INTERACTION_OVERRIDE_REASON")!=null)
					overrideremarks.put("INTERACTION_OVERRIDE_REASON",resultSet.getString("INTERACTION_OVERRIDE_REASON"));
				if(resultSet.getString("CONTRAIND_OVERRIDE_REASON")!=null)
					overrideremarks.put("CONTRAIND_OVERRIDE_REASON",resultSet.getString("CONTRAIND_OVERRIDE_REASON"));
//added for MMS-KH-CRF-0029 - start
				if(resultSet.getString("LAB_INTERACT_OVERRIDE_REASON")!=null) 
					overrideremarks.put("LAB_INTERACT_OVERRIDE_REASON",resultSet.getString("LAB_INTERACT_OVERRIDE_REASON"));
				if(resultSet.getString("FOOD_INTERACT_OVERRIDE_REASON")!=null)
					overrideremarks.put("FOOD_INTERACT_OVERRIDE_REASON",resultSet.getString("FOOD_INTERACT_OVERRIDE_REASON"));
//added for MMS-KH-CRF-0029 - end
                if(resultSet.getString("DISEASE_INTER_OVERRIDE_REASON")!=null)//Added for MMS-DM-CRF-0229
					overrideremarks.put("DISEASE_INTER_OVERRIDE_REASON",resultSet.getString("DISEASE_INTER_OVERRIDE_REASON"));//Added for MMS-DM-CRF-0229
			}						
		}
		catch(Exception e){
			System.err.println("===order_id====>"+order_id+" ====order_line_no="+order_line_no);
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
		return overrideremarks;	
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
            }catch(Exception es){
				es.printStackTrace();
			}
        }
		return count;
	}

	public ArrayList getPrescriptionRemarks(String drug_code) { 
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		ArrayList	pres_remark		=	new ArrayList() ;

		try{       
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT158"));
			pstmt.setString(1,drug_code);
			pstmt.setString(2,getLanguageId());
			resultSet	        = pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next() ) {               
				pres_remark.add(resultSet.getString("REMARK_CODE"));
				pres_remark.add(resultSet.getString("REMARK_DESC"));
				pres_remark.add(resultSet.getString("DEFAULT_REMARK_YN"));
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
			}catch(Exception es){es.printStackTrace();
			}
		}
		return pres_remark;	
	}	

	public String getPrescriptionRemark(String order_id,String order_line_num) { 
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		String pres_remark_code     =   "";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT160"));
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			pstmt.setString(3,getLanguageId());//Added for ICN:34205
			resultSet	        = pstmt.executeQuery();
			
			if( resultSet != null && resultSet.next() ) {
				pres_remark_code= resultSet.getString("ORDER_LINE_FIELD_VALUE")==null?"":resultSet.getString("ORDER_LINE_FIELD_VALUE");			
							
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
		return pres_remark_code;	

	}	

	public String getItemForAdmixPrepCharges(String iv_prep_yn) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String item_for_admx_prep_chrg		= "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT165")) ;
			pstmt.setString(1,iv_prep_yn);
            resultSet	= pstmt.executeQuery() ;

			while (resultSet.next()){
				item_for_admx_prep_chrg		=	resultSet.getString("ITEM_FOR_ADMX_PREP_CHRG");				
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
		return item_for_admx_prep_chrg;
	}

	public String getDfltOvrgVol(String tpn_non_std_regimen_code){
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		String dflt_overge_volume			= "";

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT170")) ;			

			pstmt.setString(1,tpn_non_std_regimen_code);

			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				dflt_overge_volume = checkForNull(resultSet.getString("OVERAGE_VOLUME"));
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
		return dflt_overge_volume;
   }

   public HashMap getBillingDetails(String disp_locn_code ,String tpn_worksheet_id,String patient_id,String bl_encounter_id,String bl_patient_class,String sysdate,String order_id,String disp_stage,String dischargeIND) { 
		Connection connection					=	null ;
		PreparedStatement pstmt					=	null ;
		ResultSet resultSet						=	null ;        
		HashMap  chareg_det                     =	new HashMap() ;
		String item_code                        =   "";
		String issued_qty                       =   "";
		StringBuffer batch_str				    =   new StringBuffer();
		HashMap  bl_det                         =   new HashMap();
		float tot_gross_charge_amt              =   0;
		float tot_pat_payable_amt               =   0; 
		String err_msg							=   ""; 
		String decimalFormatString			    =   "";	
		String tot_gross_charge_amount_str		=	"";
		String tot_groos_pat_payable_str		=	"";
		String doc_type_code					=	"";
		String doc_no							=	"";
		String doc_srl_no						=	"";
		//Commented due to checkstyle String pat_paid_yn                      =   "N";

		try{
			connection		= getConnection() ;
            pstmt		    = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT172")) ;
			pstmt.setString(1,disp_locn_code);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,tpn_worksheet_id);

            resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){

                 item_code     = resultSet.getString("DISP_ITEM_CODE");
				 issued_qty    = resultSet.getString("BATCH1_QTY");
                 doc_type_code = resultSet.getString("doc_type_code");
				 doc_no		   = resultSet.getString("doc_no");
				 doc_srl_no	   = resultSet.getString("doc_srl_no");
				 batch_str				  = new StringBuffer();
				 batch_str.append(resultSet.getString("TRADE_ID1")).append(";").append(resultSet.getString("BATCH_ID1")).append(";").append(resultSet.getString("EXPIRY_DATE1")).append(";").append(resultSet.getString("BIN_LOCATION_CODE1")).append(";").append(issued_qty).append(";");

                 chareg_det  = (HashMap)this.callTPNDeliveryItemChargeDtls(patient_id,bl_encounter_id,bl_patient_class,item_code,Integer.parseInt(issued_qty),batch_str.toString(), sysdate,disp_locn_code,doc_type_code,doc_no,doc_srl_no,dischargeIND,order_id); // order_id Added for MMS-MD-SCF-0102

                 decimalFormatString         = (String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
				 err_msg   = (String)chareg_det.get("error_msg");
				 if(err_msg.equals("")){
//System.err.println("===1111=====chareg_det===="+chareg_det);				
                     tot_gross_charge_amt = tot_gross_charge_amt + Float.parseFloat((String)chareg_det.get("grosschargeamt"));
					 tot_pat_payable_amt  = tot_pat_payable_amt  + Float.parseFloat((String)chareg_det.get("patnetamt"));
//System.err.println("===1111=====tot_gross_charge_amt===="+tot_gross_charge_amt+" tot_pat_payable_amt="+tot_pat_payable_amt);				
				 }
                // if()
                 // pat_paid_yn ="Y";
			}
			DecimalFormat dfTest = new DecimalFormat(decimalFormatString);

            tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amt);
			tot_groos_pat_payable_str	 = dfTest.format(tot_pat_payable_amt);

			bl_det.put("TOT_GROSS_CHRG_AMT",tot_gross_charge_amount_str);
			bl_det.put("TOT_PAT_PAYABLE_AMT",tot_groos_pat_payable_str);
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
		return bl_det;
   }

   public HashMap callTPNDeliveryItemChargeDtls(String patient_id,String encounter_id,String sal_trn_type,String item_code,int item_qty,String batch_str,String sysdate,String store_code,String doc_type,String doc_no,String doc_srl_no,String dischargeIND,String order_id)throws Exception{ // order_id Added for MMS-MD-SCF-0102
	   //System.out.println("dischargeIND in tpndeliveryitem==>> "+dischargeIND);
			
		Connection connection				= null;
		CallableStatement callableStatement = null;
		HashMap message						= new HashMap();
		PreparedStatement pstmt1			= null;
        ResultSet resultSet					= null;
		String total_charge_amt				= "";
		String patient_payable_amt			= "";
		String grosschargeamt				= "";
		PreparedStatement pstmt				= null;
		ResultSet rsDecimalPlace			= null;
		int decimal_place					= 0;
		String decimalFormatString			= "#0";
		String disp_billing_stage           ="";
		String bl_drugPenaltyStr           =""; //Added for JD-CRF-0170.1 [IN:040204]-Start
	//	String bl_ruleDtails           ="";  Removed for IN063877
	//	String bl_ruleCode = "";  Removed for IN063877
		String stKey = item_code;//order_id+"~"+order_line_no+"~"+item_code;
		ArrayList alTempPenaltyDtls = null;
		StringTokenizer stokenDrugPenalty=null;
		StringTokenizer stokenTempDtls=null;
	//	StringTokenizer stokenRuleDtls = null;//JD-CRF-0170.1 [IN:040204] -end  Removed for IN063877
		
		//System.err.println("=<><><><><>callTPNDeliveryItemChargeDtls<><><><><>disp_bean.getOrderingFacility()="+disp_bean.getOrderingFacility()+"=login_facility_id===="+login_facility_id+"==patient_id====="+patient_id+"===encounter_id======"+encounter_id+"===sal_trn_type====="+sal_trn_type+"===="+item_code+"===item_qty===="+item_qty+"==batch_str===="+batch_str+"===store_code===="+store_code+"==doc_type==="+doc_type+"===doc_no=="+doc_no+"==sysdate====="+sysdate+"==doc_srl_no==="+doc_srl_no);

		try{
            disp_billing_stage=disp_bean.getDispBillStage(); // getDisp_Bill_Stage changed to getDispBillStage for SRR20056-SCF-7639ICN027720 
			connection = getConnection();	
			callableStatement	= connection.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }"); //?,? Added for MMS-MD-SCF-0102
			callableStatement.setString(1, disp_bean.getOrderingFacility()+"|"+login_facility_id);
			callableStatement.setString(2, patient_id);
			callableStatement.setString(3, "PH");
			callableStatement.setString(4, encounter_id);
			callableStatement.setString(5, sal_trn_type);
			callableStatement.setString(6, sysdate);
			callableStatement.setString(7, item_code);
			callableStatement.setString(8, store_code);
			callableStatement.setInt(9,item_qty);
			callableStatement.setString(10, batch_str);
			callableStatement.registerOutParameter(11, Types.VARCHAR);
			callableStatement.registerOutParameter(12, Types.VARCHAR);
			callableStatement.registerOutParameter(13, Types.VARCHAR);
			callableStatement.registerOutParameter(14, Types.VARCHAR);
			callableStatement.registerOutParameter(15, Types.FLOAT);
			callableStatement.registerOutParameter(16, Types.FLOAT);
			callableStatement.registerOutParameter(17, Types.FLOAT);
			callableStatement.registerOutParameter(18, Types.FLOAT);
			callableStatement.registerOutParameter(19, Types.FLOAT);
			callableStatement.registerOutParameter(20, Types.FLOAT);
			callableStatement.registerOutParameter(21, Types.FLOAT);
			callableStatement.registerOutParameter(22, Types.FLOAT);
			callableStatement.registerOutParameter(23, Types.FLOAT);
			callableStatement.registerOutParameter(24, Types.FLOAT);
			callableStatement.registerOutParameter(25, Types.FLOAT);
			callableStatement.registerOutParameter(26, Types.FLOAT);
			callableStatement.registerOutParameter(27, Types.FLOAT);
			callableStatement.registerOutParameter(28, Types.FLOAT);
			callableStatement.registerOutParameter(29, Types.VARCHAR);
			callableStatement.registerOutParameter(30, Types.FLOAT);
			callableStatement.registerOutParameter(31, Types.VARCHAR);
			callableStatement.registerOutParameter(32, Types.VARCHAR);
			callableStatement.registerOutParameter(33, Types.VARCHAR);
			callableStatement.registerOutParameter(34, Types.VARCHAR);
			callableStatement.registerOutParameter(35, Types.VARCHAR);
			callableStatement.registerOutParameter(36, Types.VARCHAR);
			callableStatement.registerOutParameter(37, Types.VARCHAR);
			callableStatement.registerOutParameter(38, Types.VARCHAR);
			//if(bl_override_excl_incl_ind.equals("")){
			callableStatement.setString(39, "");
			callableStatement.setString(40, "");
			/*}else{
				callableStatement.setString(39, bl_override_excl_incl_ind);
			    callableStatement.setString(40, bl_incl_excl_override_reason_code);
			}*/

			callableStatement.setString(41, "N"); //Internal Adjestment
			if(disp_billing_stage.equals("A")){
				callableStatement.setString(42, doc_type);
				callableStatement.setString(43, doc_no);
				callableStatement.setString(44, doc_srl_no);
			}
			else{
				callableStatement.setString(42, "");
				callableStatement.setString(43, "");
				callableStatement.setString(44, "");
			}
			callableStatement.setString(45, dischargeIND);
			callableStatement.registerOutParameter(46, Types.VARCHAR); //added for JD-CRF-0170.1 [IN:040204]
			callableStatement.setString(47,order_id);//added for MMS-MD-SCF-0102
			callableStatement.setString(48, "1");//added for MMS-MD-SCF-0102
			callableStatement.execute();
			
			//message.put("daytypecode" , checkForNull((String)callableStatement.getString(11)));
			//message.put("daytypedesc" , checkForNull((String)callableStatement.getString(12)));
			//message.put("timetypecode" , checkForNull((String)callableStatement.getString(13)));
			//message.put("timetypedesc" , checkForNull((String)callableStatement.getString(14)));
			//message.put("baseqty" , callableStatement.getFloat(15)+"");			
			//message.put("baserate" , callableStatement.getString(16)+"");
			//message.put("addlfactor" ,callableStatement.getString(17)+"");
			grosschargeamt        = callableStatement.getString(19);
			//message.put("discountamt" , callableStatement.getString(20)+"");
			total_charge_amt      = callableStatement.getString(21);
			//message.put("discountper" , callableStatement.getString(22)+"");
			//message.put("patgrosschargeamt" , callableStatement.getString(23)+"");
			//message.put("patdiscamt" , callableStatement.getString(24)+"");
			patient_payable_amt   = checkForNull(callableStatement.getString(25),"0");
			//message.put("custgrosschargeamt" , callableStatement.getString(26)+"");
			//message.put("custdiscamt" , callableStatement.getString(27)+"");
			//message.put("custnewamt" , callableStatement.getString(28)+"");			
			//message.put("insind" , checkForNull((String)callableStatement.getString(29)));
			message.put("error_id" , checkForNull((String)callableStatement.getString(33)));
			message.put("error_msg" , checkForNull((String)callableStatement.getString(34)));
			message.put("excl_incl_ind" , checkForNull((String)callableStatement.getString(35),""));
			message.put("approval_reqd_yn" , checkForNull((String)callableStatement.getString(36),"N"));
			message.put("override_allowed_yn" , checkForNull((String)callableStatement.getString(37),""));
			message.put("pat_paid_amt" , checkForNull((String)callableStatement.getString(38)));

			bl_drugPenaltyStr = checkForNull((String)callableStatement.getString(46)); //added for JD-CRF-0170.1 [IN:040204] -Start
			if(!bl_drugPenaltyStr.equals("")){
				bl_drugPenaltyStr = bl_drugPenaltyStr.substring(0,bl_drugPenaltyStr.length()-1);
				stokenDrugPenalty	=	new StringTokenizer((String)bl_drugPenaltyStr,"@"); //RULE_CODE#BLNG_GRP_ID#CUST_GRP_CODE#CUST_CODE#POLICY_TYPE_CODE#P_ITEM_CODE#MIN_DRG_PNLTY_AMT#MAX_DRG_PNLTY_AMT#ACTUAL_AMT@
				alTempPenaltyDtls = new ArrayList();
				while(stokenDrugPenalty.hasMoreTokens()){
					stokenTempDtls = new StringTokenizer((String)stokenDrugPenalty.nextToken(), "#");
					while(stokenTempDtls.hasMoreTokens()){
						alTempPenaltyDtls.add((String)stokenTempDtls.nextToken());
					}
				}
				hmDrugPenaltyDtls.put(stKey, alTempPenaltyDtls);

			}	//added for JD-CRF-0170.1 [IN:040204] -End

            pstmt = connection.prepareStatement("SELECT BLCORE.GET_DECIMAL_PLACE(?) decimal_place FROM dual");
			pstmt.setString(1,login_facility_id);
			rsDecimalPlace = pstmt.executeQuery();
			if(rsDecimalPlace.next())
				decimal_place = rsDecimalPlace.getInt("decimal_place");
			closeStatement( pstmt ) ;
			closeResultSet(rsDecimalPlace);

			if(decimal_place > 0)
				decimalFormatString = decimalFormatString+".";

			for(int i=1;i<=decimal_place;i++){
				decimalFormatString = decimalFormatString+"0";
			}

			if(patient_payable_amt!=null && !patient_payable_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				patient_payable_amt = dfTest.format(Double.parseDouble(patient_payable_amt));
				message.put("patnetamt" ,patient_payable_amt+"");
			}
			if(total_charge_amt!=null && !total_charge_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				total_charge_amt = dfTest.format(Double.parseDouble(total_charge_amt));
				message.put("netchargeamt" ,total_charge_amt+"");
			}

			if(grosschargeamt!=null && !grosschargeamt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				grosschargeamt = dfTest.format(Double.parseDouble(grosschargeamt));
				message.put("grosschargeamt" ,grosschargeamt+"");
			}
			message.put("BL_DECIMAL_FORMAT_STRING",decimalFormatString);
			message.put("BATCH_STRING",batch_str);
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
			closeResultSet( resultSet ) ;
			closeStatement( pstmt1 ) ;
		}
		return message;
	}

	public ArrayList getParameterValues(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList param_values		= new ArrayList(2);
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT77")) ;
			pstmt.setString(1,login_facility_id);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				param_values.add(checkForNull(resultSet.getString("DISP_CHARGE_DTL_IN_DRUG_LKP_YN")));
				param_values.add(checkForNull(resultSet.getString("DISP_PRICE_TYPE_IN_DRUG_LKP")));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
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

	public void getConsumableOrderDetails(String trx_ref_ids,String disp_stage ) { 
		Connection connection					=	null ;
		PreparedStatement pstmt					=	null ;
		ResultSet resultSet						=	null ;        
		HashMap  item_det                       =   new HashMap();
		try{
			connection		= getConnection() ;
			String sql_str  ="SELECT a.TRN_GROUP_REF,a.order_id,b.ORDER_CATALOG_CODE,b.ORDER_LINE_NUM , b.ORDER_QTY, b.ORDER_UOM,b.END_DATE_TIME ,c.LONG_DESC, a.ORD_PRACT_ID FROM or_order a,or_order_line b,mm_item_lang_vw c WHERE a.order_id=b.order_id and a.TRN_GROUP_REF in (#) and a.ORDERING_FACILITY_ID=? and a.ORDER_TYPE_CODE ='MS' and b.ORDER_CATALOG_CODE =c.item_code  and language_id=?"; //, a.ORD_PRACT_ID added for SRR20056-SCF-7373
            int index = sql_str.indexOf("#");
			StringBuffer sb = new StringBuffer(sql_str);
			sb.replace(index,index+1,trx_ref_ids);
			sql_str = sb.toString(); 
           // pstmt		    = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT172")) ;
		    pstmt		    = connection.prepareStatement( sql_str) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());

            resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				 item_det      =   new HashMap();

				 item_det.put("TRN_GROUP_REF",resultSet.getString("TRN_GROUP_REF"));
				 item_det.put("ORDER_ID",resultSet.getString("ORDER_ID"));
				 item_det.put("ORDER_LINE_NO",resultSet.getString("ORDER_LINE_NUM"));

				 item_det.put("LONG_DESC",resultSet.getString("LONG_DESC"));				 
				 item_det.put("ORDER_CATALOG_CODE",resultSet.getString("ORDER_CATALOG_CODE"));
				 item_det.put("ORDER_QTY",resultSet.getString("ORDER_QTY"));
				 item_det.put("ORDER_UOM",resultSet.getString("ORDER_UOM"));	
				 item_det.put("TRADE_CODE","");
				 item_det.put("SELECTED_YN","Y");
				 item_det.put("ALLOC_QTY","");
				 item_det.put("FROM_ORDER_YN","Y");
				 item_det.put("SELECTED_FROM_DISP_DAT_YN","N");
				 item_det.put("ORD_PRACT_ID",resultSet.getString("ORD_PRACT_ID")); //added for SRR20056-SCF-7373
				 cons_item_det.add(item_det);
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
	}

	public void loadItemDetail(String item_code, String trade_code, String trade_name, String bl_install_yn){
        Connection connection           = null ;
		PreparedStatement pstmt_item    = null ;
        ResultSet resultSet_item        = null ; 
		String sql_query_item			= "";
		HashMap  item_det               =   new HashMap();
        try{
			 connection = getConnection() ;
			//sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT2");
			sql_query_item = "SELECT ord_cat.order_catalog_code item_code, mm.long_desc, mm.gen_uom_code uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE language_id = ? AND uom_code = mm.gen_uom_code) uom_desc, ord_cat.order_type_code, ord_cat.order_category, ord_cat.CONSENT_REQD_YN, ord_cat.BILL_YN FROM or_order_catalog ord_cat, st_item st, mm_item_lang_vw mm, mm_trade_name_for_item mtr WHERE medical_item_yn = 'Y' AND drug_item_yn = 'N' AND st.item_code = mm.item_code AND mm.language_id = ? AND ord_cat.order_catalog_code = mm.item_code AND ord_cat.order_category = 'PH' AND st.item_code = mtr.item_code(+) AND ord_cat.order_catalog_code = ? and NVL(mtr.trade_id,'X') = DECODE(?,NULL,NVL (mtr.trade_id, 'X'),?) AND st.item_code = mtr.item_code(+)";
			pstmt_item				= connection.prepareStatement(sql_query_item) ;
			pstmt_item.setString(1,getLanguageId());
			pstmt_item.setString(2,getLanguageId()); 
			pstmt_item.setString(3,item_code);
			pstmt_item.setString(4,trade_code);
			pstmt_item.setString(5,trade_code);
			resultSet_item			= pstmt_item.executeQuery();
			while(resultSet_item!=null && resultSet_item.next()) {
				item_det      =   new HashMap(); 
				item_det.put("TRN_GROUP_REF","");
				item_det.put("ORDER_ID","");
				item_det.put("ORDER_LINE_NO","");
				item_det.put("LONG_DESC",resultSet_item.getString("long_desc"));				 
				item_det.put("ORDER_CATALOG_CODE",item_code);
				item_det.put("ORDER_QTY","");
				item_det.put("ORDER_UOM",resultSet_item.getString("UOM_CODE"));
				item_det.put("TRADE_CODE",trade_code);
				item_det.put("SELECTED_YN","Y");
				item_det.put("ALLOC_QTY","");
				item_det.put("FROM_ORDER_YN","Y");
				item_det.put("SELECTED_FROM_DISP_DAT_YN","N");
				item_det.put("ORD_PRACT_ID",""); //added for SRR20056-SCF-7373
				cons_item_det.add(item_det);
			}
			closeResultSet( resultSet_item ) ;
			closeStatement( pstmt_item ) ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet( resultSet_item ) ;
			    closeStatement( pstmt_item ) ;
				closeConnection( connection );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public void getDispensedConsumableOrderDetails(String order_ids,String disp_locn_code ) { 
		Connection connection					=	null ;
		PreparedStatement pstmt					=	null ;
		ResultSet resultSet						=	null ;  
		PreparedStatement pstmt1				=	null ;
		ResultSet resultSet1					=	null ;  
		PreparedStatement pstmt2				=	null ;
		ResultSet resultSet2					=	null ;  
		HashMap  item_det                       =   new HashMap();
		HashMap batch_det                       =   new HashMap();
		String order_id="";
		String order_line_no="";
        StringBuffer disp_trn_seq_nos   = new StringBuffer();
 
		try{
			connection		= getConnection() ;
            String sql_str3="select DISP_TRN_SEQ_NO  from ph_disp_hdr_tmp where  order_id in(#) and facility_id=? and disp_locn_code=?" ;

            int index1 = sql_str3.indexOf("#");
			StringBuffer sb1 = new StringBuffer(sql_str3);
			sb1.replace(index1,index1+1,order_ids);
			sql_str3 = sb1.toString(); 

			 pstmt1		    = connection.prepareStatement( sql_str3) ;
			 pstmt1.setString(1,login_facility_id);
			 pstmt1.setString(2,disp_locn_code);
			 resultSet1	= pstmt1.executeQuery() ;
			 while( resultSet1.next()){
				 if(disp_trn_seq_nos.length()!=0){
					  disp_trn_seq_nos.append(",");
				 }
				 disp_trn_seq_nos.append("'").append(resultSet1.getString("DISP_TRN_SEQ_NO")).append("'");
			 }
			 closeResultSet( resultSet1 ) ;
			 closeStatement( pstmt1 ) ;

            if(disp_trn_seq_nos.length()>0){
				String sql_str  ="SELECT a.DISP_TRN_SEQ_NO,b.order_id,a.doc_no doc_no ,b.ORDER_LINE_NO,b.ORDER_CONS_CODE,b.disp_no disp_no ,b.STATUS,b.SRL_NO SRL_NO,b.DISP_UOM_CODE DISP_UOM_CODE,c.SRL_NO_BATCH,d.long_desc  long_desc,c.BATCH_ID BATCH_ID, TO_CHAR(c.EXPIRY_DATE,   'DD/MM/RRRR') EXPIRY_DATE, c.TRADE_ID TRADE_ID, c.DISP_QTY DISP_QTY, c.DISP_QTY_UOM, c.BIN_LOCATION_CODE BIN_LOCATION_CODE,c.store_code store_code,  (SELECT short_name FROM am_trade_name_lang_vw WHERE trade_id = c.trade_id AND language_id = 'en') trade_name,(F.QTY_ON_HAND-F.COMMITTED_QTY) AVL_QTY FROM ph_disp_hdr_tmp a ,ph_disp_cons_dtl b ,ph_disp_cons_batch c,mm_item_lang_vw d,am_trade_name_lang_vw e, ST_ITEM_BATCH f WHERE a.facility_id = ? AND  a.disp_locn_code = ? AND A. DISP_TRN_SEQ_NO IN (#) AND B.DISP_TRN_SEQ_NO =A.DISP_TRN_SEQ_NO AND C.FACILITY_ID = B.FACILITY_ID AND C.DISP_NO = B.DISP_NO AND C.SRL_NO = B.SRL_NO AND d.item_code = B.ORDER_CONS_CODE AND  D.language_id =?   AND f.STORE_CODE = C.STORE_CODE AND f.ITEM_CODE = C.CONS_CODE  AND f.BATCH_ID = C.BATCH_ID AND f.BIN_LOCATION_CODE = C.BIN_LOCATION_CODE  AND f.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE and b.status <> 'DL' GROUP BY a.DISP_TRN_SEQ_NO,b.order_id,a.doc_no,b.ORDER_LINE_NO,b.ORDER_CONS_CODE,b.disp_no, b.STATUS,b.SRL_NO,b.DISP_UOM_CODE,c.SRL_NO_BATCH,d.long_desc ,c.BATCH_ID, c.EXPIRY_DATE,  c.TRADE_ID, c.DISP_QTY, c.DISP_QTY_UOM, c.BIN_LOCATION_CODE,c.store_code, (f.qty_on_hand - f.committed_qty)  ";		

				String sql_str_2 ="select ORDER_QTY, ORD_PRACT_ID from or_order_line where order_id=? and ORDER_LINE_NUM =?"; //, ORD_PRACT_ID added for SRR20056-SCF-7373
				pstmt2		    = connection.prepareStatement( sql_str_2) ;

				int index = sql_str.indexOf("#");
				StringBuffer sb = new StringBuffer(sql_str);
				sb.replace(index,index+1,disp_trn_seq_nos.toString());
				sql_str = sb.toString(); 

				pstmt		    = connection.prepareStatement( sql_str) ;
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,disp_locn_code);
				pstmt.setString(3,getLanguageId());

				resultSet	= pstmt.executeQuery() ;
				while(resultSet!=null && resultSet.next()){
					 item_det      =   new HashMap();
					 batch_det     =   new HashMap();

					order_id =resultSet.getString("order_id");
					order_line_no =resultSet.getString("ORDER_LINE_NO");
					 
					pstmt2.setString(1,order_id);
					pstmt2.setString(2,order_line_no);
					resultSet2	= pstmt2.executeQuery() ;
					if(resultSet2!=null && resultSet2.next()){
						item_det.put("ORDER_QTY",resultSet2.getString("ORDER_QTY"));
						item_det.put("ORD_PRACT_ID",resultSet.getString("ORD_PRACT_ID")); //added for SRR20056-SCF-7373
					}
					else{
						item_det.put("ORDER_QTY","");
						item_det.put("ORD_PRACT_ID",""); //added for SRR20056-SCF-7373
					}

					item_det.put("DISP_NO",resultSet.getString("disp_no"));
					item_det.put("ORDER_ID",order_id);
					item_det.put("ORDER_LINE_NO",order_line_no);
					item_det.put("ORDER_CATALOG_CODE",resultSet.getString("ORDER_CONS_CODE"));
					item_det.put("ORDER_STATUS",resultSet.getString("STATUS"));				
					item_det.put("DISP_SRL_NO",resultSet.getString("SRL_NO"));
					item_det.put("ORDER_UOM",resultSet.getString("DISP_UOM_CODE"));
					item_det.put("TRADE_CODE",resultSet.getString("TRADE_ID"));
					item_det.put("BATCH_SRL_NO",resultSet.getString("SRL_NO_BATCH"));
					item_det.put("LONG_DESC",resultSet.getString("long_desc"));
					item_det.put("SELECTED_YN","Y");
					item_det.put("ALLOC_QTY",resultSet.getString("DISP_QTY"));
					item_det.put("FROM_ORDER_YN","N");
					item_det.put("DOC_NO",resultSet.getString("doc_no"));
					item_det.put("SELECTED_FROM_DISP_DAT_YN","Y");
					batch_det.put("BATCH_ID",resultSet.getString("BATCH_ID"));
					batch_det.put("EXPIRY_DATE",resultSet.getString("EXPIRY_DATE"));
					batch_det.put("ITEM_CODE",resultSet.getString("ORDER_CONS_CODE"));				
					batch_det.put("TRADE_ID",resultSet.getString("TRADE_ID"));
					batch_det.put("BIN_LOCN_CODE",resultSet.getString("BIN_LOCATION_CODE"));
					batch_det.put("AVAIL_QTY",resultSet.getString("AVL_QTY"));
					batch_det.put("TRADE_DESC",checkForNull(resultSet.getString("trade_name")));
					batch_det.put("STORE_CODE",resultSet.getString("store_code"));
					item_det.put("BATCH_DET",batch_det);    
					cons_item_det.add(item_det);
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
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt2 ) ;
				closeConnection( connection ); 
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
	}

	public String getSMLOcalLanguageID(){
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		String language_id			        = "";

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "select LANGUAGE_ID from sm_language where PRIMARY_LANG_YN ='N' and EFF_STATUS='E' and rownum<2") ;			
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				language_id = checkForNull(resultSet.getString("LANGUAGE_ID"));
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
		return language_id;
   }
/*code added for variable uom*/
	public ArrayList loadStockUnit(String item_code){
		
		ArrayList stock_unit	= new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		
		try{
			connection			= getConnection() ;
			pstmt = connection.prepareStatement( "select  EQVL_UOM_CODE uom_code,SHORT_DESC, PH_calculate_equl_val(a.ITEM_CODE,a.UOM_CODE,a.EQVL_UOM_CODE)EQVL_VALUE,(eqvl_value / eqvl_uom_qty) ACT_EQVL_VALUE from MM_ITEM_UOM_DEFN a, am_uom_lang_vw b where ITEM_CODE =? and a.EFF_STATUS = 'E'  and a.EQVL_UOM_CODE =b.uom_code and b.LANGUAGE_ID=?" ) ;
			//pstmt = connection.prepareStatement( "select  a.uom_code uom_code,SHORT_DESC, PH_calculate_equl_val(a.ITEM_CODE,a.UOM_CODE,a.EQVL_UOM_CODE)EQVL_VALUE,(eqvl_value / eqvl_uom_qty) ACT_EQVL_VALUE from MM_ITEM_UOM_DEFN a, am_uom_lang_vw b where ITEM_CODE =? and a.EFF_STATUS = 'E'  and a.uom_code =b.uom_code and b.LANGUAGE_ID=?" ) ;
			pstmt.setString(1,item_code);
			pstmt.setString(2,getLanguageId());
			
			resultSet			= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				stock_unit.add(checkForNull(resultSet.getString( "uom_code" )));
				stock_unit.add(checkForNull(resultSet.getString( "SHORT_DESC" )));
				stock_unit.add(checkForNull(resultSet.getString( "EQVL_VALUE" )));
				stock_unit.add(checkForNull(resultSet.getString( "ACT_EQVL_VALUE" )));
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
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return stock_unit;
	}

	public HashMap getStoreDfltIssueUOMAndBaseUOM (String store_code,String drug_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		HashMap def_issue_uoms	= new HashMap();
		try {
            connection	= getConnection() ;
          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			pstmt		= connection.prepareStatement( "SELECT DEF_ISSUE_UOM,GEN_UOM_CODE, ALLOW_DECIMALS_YN FROM ST_ITEM_STORE a, mm_item b, st_item c WHERE STOCK_ITEM_YN = 'Y' AND a.STORE_CODE = ? AND a.ITEM_CODE = ? AND a.EFF_STATUS = 'E'and b.EFF_STATUS='E' and a.item_code =b.item_code and a.item_code =c.item_code") ;
			pstmt.setString(1,store_code);
			pstmt.setString(2,drug_code);
            resultSet	= pstmt.executeQuery() ;
			
			if (resultSet.next()){
				def_issue_uoms.put("DEF_ISSUE_UOM",	checkForNull(resultSet.getString("DEF_ISSUE_UOM")));				
				def_issue_uoms.put("BASE_UOM",	checkForNull(resultSet.getString("GEN_UOM_CODE")));
				def_issue_uoms.put("ALLOW_DECIMALS_YN",	checkForNull(resultSet.getString("ALLOW_DECIMALS_YN")));
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
		return def_issue_uoms;
	}

 /*public int  lcm(int frm_tmp, int to_tmp) {
	int lowest = frm_tmp < to_tmp ? frm_tmp : to_tmp;
	int hcd = 1;
	for (int i = lowest; i > 1; i--) {
		if (frm_tmp % i == 0 && to_tmp % i == 0) {
			hcd = i;
			break;
		}
	}
	int lcm = (frm_tmp * to_tmp) / hcd;
	return lcm;
}*/

	public double lcm(double frm_tmp, double to_tmp) {
		double lowest = frm_tmp < to_tmp ? frm_tmp : to_tmp;
		double hcd = 1;
		for (double i = lowest; i > 1; i--) {
			if (frm_tmp % i == 0 && to_tmp % i == 0) {
				hcd = i;
				break;
			}
		}
		double lcm = (frm_tmp * to_tmp) / hcd;
		return lcm;
	}

	public double getEqulValue (String item_code,String uom_code,String equl_uom_code){
		if(uom_code!=null && equl_uom_code!=null && uom_code.equals(equl_uom_code)){
			return 1;
		}
		else{
			Connection connection	= null;
			PreparedStatement pstmt	= null;
			ResultSet resultSet		= null;	
			double eqvl_value			= 0;

			try {
				connection	= getConnection() ;
			  //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
				//pstmt		= connection.prepareStatement( "select (eqvl_value / eqvl_uom_qty) EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=? and EFF_STATUS = 'E' ") ;
				pstmt		= connection.prepareStatement( "select PH_calculate_equl_val(ITEM_CODE,UOM_CODE,EQVL_UOM_CODE) EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=? and EFF_STATUS = 'E' ") ;

				pstmt.setString(1,item_code);
				pstmt.setString(2,uom_code);
				pstmt.setString(3,equl_uom_code);
				resultSet	= pstmt.executeQuery() ;
				
				if (resultSet.next()){
					eqvl_value = resultSet.getDouble("EQVL_VALUE");		
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
	}

	public String getUOMDesc (String uom_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String short_desc		= "";
		try {
            connection	= getConnection() ;
          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			pstmt		= connection.prepareStatement( "select SHORT_DESC from am_uom_lang_vw where UOM_CODE=? and  LANGUAGE_ID=?") ;
			pstmt.setString(1,uom_code);
			pstmt.setString(2,getLanguageId());
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return short_desc;
	}

	public ArrayList getSlidingScaleTemplateDetails(String Order_Id,String Order_line_num){
		Connection connection			= null;
        PreparedStatement pstmt			= null;      		
		ResultSet resultSet				= null;
		String remarks = "";
		ArrayList slidingScaleDetails	= new ArrayList();		
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("select A.TEMPLATE_ID, A.SRL_NO, A.RANGE_FROM, A.RANGE_TO, A.ADMIN_UNITS, B.RANGE_UOM_CODE, B.ADMIN_UNITS_UOM_CODE, A.REMARKS,B.TEMPLATE_DESC from OR_ORDER_LINE_PH_SLD_SCALE A, ph_sliding_scale_tmpl B where A.TEMPLATE_ID = B.TEMPLATE_ID and A.order_id=? and A.order_line_num=? order by a.srl_no");
			pstmt.setString(1,Order_Id);			
			pstmt.setString(2,Order_line_num);			
			resultSet	= pstmt.executeQuery() ;
			while (resultSet !=null && resultSet.next()){
				
				slidingScaleDetails.add(resultSet.getString("TEMPLATE_ID"));
				slidingScaleDetails.add(resultSet.getString("SRL_NO"));
				slidingScaleDetails.add(resultSet.getString("RANGE_FROM"));
				slidingScaleDetails.add(resultSet.getString("RANGE_TO"));
				slidingScaleDetails.add(resultSet.getString("ADMIN_UNITS"));
				slidingScaleDetails.add(resultSet.getString("RANGE_UOM_CODE"));
				slidingScaleDetails.add(resultSet.getString("ADMIN_UNITS_UOM_CODE"));				
				remarks = resultSet.getString("REMARKS");
				if(remarks !=null || !remarks.equals(""))
					slidingScaleDetails.add(java.net.URLEncoder.encode(remarks,"UTF-8"));	
				else
					slidingScaleDetails.add("");	
				slidingScaleDetails.add(resultSet.getString("TEMPLATE_DESC"));				
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
			catch(Exception ex){
				ex.printStackTrace() ;			
			}
		}
		return slidingScaleDetails;
	}

/*=======ends here===========*/

	public ArrayList getPPNItems(String sCodeOrDesc, String sName, String sSearchType){
		Connection			oConnection				= null;
        PreparedStatement	oPreparedStmt			= null;      		
		ResultSet			oResultSet				= null;
		ArrayList			alPPNItemDetails		= null;
		StringBuffer		sbItemIds				= new StringBuffer(" ('");
		HashMap				hmPPNItemValues			= null;
		StringBuffer		sbCriteriaConditions	= new StringBuffer("");
		ArrayList			alItemCodes				= new ArrayList();	

		try {

            oConnection	= getConnection() ;
			oPreparedStmt		= oConnection.prepareStatement("select TPN_REGIMEN_CODE from PH_TPN_REGIMEN where STANDARD_REGIMEN_YN ='Y' and PPN_YN = 'Y'");
			oResultSet	= oPreparedStmt.executeQuery() ;			
			while(oResultSet!=null && oResultSet.next()){
				sbItemIds.append(oResultSet.getString("TPN_REGIMEN_CODE")+"','");
			}

			sbItemIds = sbItemIds.delete(sbItemIds.length()-2,sbItemIds.length());
			sbItemIds.append(") ");
			if(sbItemIds.length()>3){ // To confirm some items are available
				alPPNItemDetails = new ArrayList();

				if(sName!=null && !sName.trim().equals("")){
					// This block is used to frame the PPNRegimen Codes
					if(sCodeOrDesc.equals("C"))
						sbCriteriaConditions.append(" and upper(ITEM_CODE) like ");
					else 
						sbCriteriaConditions.append(" and upper(ITEM_DESC) like ");
					
					//This condition used to set the criteria values
					if(sSearchType.equals("S"))
						sbCriteriaConditions.append(" upper('"+sName+"%') ");
					else
						sbCriteriaConditions.append("upper('%"+sName+"%') ");

				}
				String sSQL =   "SELECT ITEM_CODE, ITEM_DESC, A.STORE_CODE, STORE_DESC, TRADE_ID_APPLICABLE_YN, BATCH_ID, TO_DATE(expiry_date) exp_date, TO_CHAR (expiry_date, 'dd/mm/yyyy') EXPIRY_DATE, BIN_LOCATION_CODE, BIN_DESC, TRADE_ID, TRADE_NAME, UOM_CODE, UOM_DESC, QTY_ON_HAND, NOD, MANUFACTURER_ID, MANUFACTURER_NAME, AVAIL_QTY, EXPIRY_YN, BATCH_STATUS FROM st_batch_search_lang_view a, mm_store_lang_vw b WHERE item_code in # AND a.store_code =? AND avail_qty > 0 AND expiry_yn = 'Y' AND expiry_date <= TRUNC (SYSDATE) +  99999 AND suspended_yn = 'N' AND ((USE_AFTER_EXPIRY_YN ='N' and SYSDATE < expiry_date) or (USE_AFTER_EXPIRY_YN ='Y')) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? AND a.store_code = b.store_code AND b.facility_id = ?  $ AND b.language_id = a.language_id ORDER BY EXP_DATE ASC, a.item_desc".replace("#",sbItemIds.toString()).replace("$",sbCriteriaConditions.toString());
				oPreparedStmt		= oConnection.prepareStatement(sSQL);

				oPreparedStmt.setString(1,disp_bean.getDispLocnCode().trim());			
				oPreparedStmt.setString(2,getLanguageId());			
				oPreparedStmt.setString(3,getLanguageId());			
				oPreparedStmt.setString(4,getLanguageId());			
				oPreparedStmt.setString(5,login_facility_id);			
			
				oResultSet	= oPreparedStmt.executeQuery() ;
				while (oResultSet !=null && oResultSet.next()){		
					String sItemCode = oResultSet.getString("ITEM_CODE");
					if(!alItemCodes.contains(sItemCode)){
						alItemCodes.add(sItemCode);
						hmPPNItemValues = new HashMap();
						hmPPNItemValues.put("ItemCode",sItemCode);
						hmPPNItemValues.put("ItemDesc",oResultSet.getString("ITEM_DESC"));
						hmPPNItemValues.put("AvailQty",oResultSet.getString("AVAIL_QTY"));
						hmPPNItemValues.put("BatchId",oResultSet.getString("BATCH_ID"));
						hmPPNItemValues.put("TradeId",oResultSet.getString("TRADE_ID"));
						hmPPNItemValues.put("ManufacturerId",oResultSet.getString("MANUFACTURER_ID"));
						hmPPNItemValues.put("UOMCode",oResultSet.getString("UOM_CODE"));
						hmPPNItemValues.put("ExpiryDate",oResultSet.getString("EXPIRY_DATE"));
						hmPPNItemValues.put("BinLocation",oResultSet.getString("BIN_LOCATION_CODE"));
						hmPPNItemValues.put("ORD_PRACT_ID",""); //added for SRR20056-SCF-7373
						alPPNItemDetails.add(hmPPNItemValues);
					}
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oPreparedStmt ) ;			
				closeConnection( oConnection ); 
			}
			catch(Exception ex){
				ex.printStackTrace() ;			
			}
		}
		return alPPNItemDetails;
	}

	public HashMap getPrintOptions(String sPatientClass){

		Connection connection   = null;
        PreparedStatement pstmt   = null;       
		ResultSet resultSet    = null;
		HashMap hmPrintOptions   = new HashMap(); 
		String sFillStage    = disp_bean.getFillList()==null?"":disp_bean.getFillList();
		String sDispStage    = disp_bean.getDispStage().trim();

		try {
			connection = getConnection() ;
			pstmt  = connection.prepareStatement("SELECT REPORT_ID, PRINT_STATUS FROM ph_disp_locn_prn_option WHERE facility_id = ? AND disp_locn_code = ?  AND patient_class = ? AND disp_stage = ? AND print_status <> 'NR' AND eff_status = 'E' ");

			//if(sFillStage.equals("AF") || sFillStage.equals("DF") )
			if(sFillStage.equals("AF") )
				sDispStage = sFillStage;
			if(sFillStage.equals("DF") )
				sDispStage = "D";
			if(sFillStage.equals("DWF") )
				sDispStage = "DF";

			//System.out.println("=login_facility_id===="+login_facility_id+"==disp_bean.getDispLocnCode()===="+disp_bean.getDispLocnCode()+"=sPatientClass===="+sPatientClass+"===sDispStage===="+sDispStage);
			pstmt.setString(1,login_facility_id.trim());  
			pstmt.setString(2,disp_bean.getDispLocnCode().trim());  
			pstmt.setString(3,sPatientClass.trim());  
			pstmt.setString(4,sDispStage);  
			resultSet = pstmt.executeQuery() ;
			if(resultSet !=null){
				while (resultSet.next()){
					hmPrintOptions.put(resultSet.getString("REPORT_ID"),resultSet.getString("PRINT_STATUS"));
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
			catch(Exception ex){
				ex.printStackTrace() ;  
			}
		}
		//System.out.println("==hmPrintOptions===="+hmPrintOptions);
		return hmPrintOptions;
	}

	public void updateNextCollDateInFillAllocate(ArrayList alBMSOrderIds,String sNextCollectionDate, String bmsReasonCode){

		try{
			HashMap tabData	= new HashMap();
			HashMap sqlMap  = new HashMap();

			tabData.put( "properties", getProperties() );
			tabData.put("BMSOrderIds",alBMSOrderIds);
			tabData.put("NextCollectionDate",sNextCollectionDate);
			tabData.put("bmsReasonCode",bmsReasonCode);
			tabData.put("updateNextCollDate","true");
			tabData.put( "facility_id", login_facility_id.trim() );
			tabData.put( "login_at_ws_no", login_at_ws_no.trim());
			tabData.put( "login_by_id", login_by_id.trim());
				
			sqlMap.put("SQL_ORDER_LINE_PH_NEXT_COL_DATE_UPDATE","UPDATE OR_ORDER_LINE_PH SET NEXT_COLLECTION_DATE=TO_DATE(?,'DD/MM/YYYY'),BMS_REASON_CODE=?, MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=? WHERE ORDER_ID=? AND ORDER_LINE_NUM =?");

           Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_DISP_MEDICATION" ),DispMedicationHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
			(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void updateDTLValues(){
		String sDispStage = disp_bean.getDispStage();
		try	{
			HashMap tabData	= new HashMap();
			HashMap sqlMap  = new HashMap();

			tabData.put("properties", getProperties() );
			tabData.put("updateDTLValues", "yes" );
			tabData.put("editLables",editLabel);
			tabData.put("orderLineData",disp_bean.getAlOrderLineDataForEditLables());
			tabData.put("facility_id", login_facility_id.trim() );
			tabData.put("login_at_ws_no", login_at_ws_no.trim());
			tabData.put("login_by_id", login_by_id.trim());
			tabData.put("editableLabel",getEditableLabel());//added for Bru-HIMS-CRF-414 [IN:045554]
			tabData.put("allow_edit_disp_label", disp_bean.getAllowEditDispLabel());//added for Bru-HIMS-CRF-414 [IN:045554]
			tabData.put("editableLabelLangId", disp_bean.getEditableLabelLangId());//added for Bru-HIMS-CRF-414 [IN:045554]
			
			if(sDispStage!=null && (sDispStage.equals("F")||sDispStage.equals("A"))){
				sqlMap.put("SQL_PH_DISP_DTL_TMP_UPDATE","update ph_disp_dtl_tmp set LABEL_CAU_INSTRN1_ENG =? , LABEL_CAU_INSTRN2_ENG=? , LABEL_SPL_INSTRN1_ENG=? , LABEL_SPL_INSTRN2_ENG=? , LABEL_PAT_INSTRN1_ENG=? , LABEL_CAU_INSTRN1_LOC=? , LABEL_CAU_INSTRN2_LOC=? , LABEL_SPL_INSTRN1_LOC=? , LABEL_SPL_INSTRN2_LOC=? , LABEL_PAT_INSTRN1_LOC=? , PRES_REMARK_CODE = ?,DRUG_INDICATION=?, MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=? where facility_id = ? AND order_id = ? AND ORDER_LINE_NO =? AND DISP_DRUG_CODE =?"); // AND DISP_DRUG_CODE  added for ML-BRU-SCF-0179 [IN:032578] //Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]
			}
			else{
				sqlMap.put("SQL_PH_DISP_DTL_UPDATE","update ph_disp_dtl set LABEL_CAU_INSTRN1_ENG =? , LABEL_CAU_INSTRN2_ENG=? , LABEL_SPL_INSTRN1_ENG=? , LABEL_SPL_INSTRN2_ENG=? , LABEL_PAT_INSTRN1_ENG=? , LABEL_CAU_INSTRN1_LOC=? , LABEL_CAU_INSTRN2_LOC=? , LABEL_SPL_INSTRN1_LOC=? , LABEL_SPL_INSTRN2_LOC=? , LABEL_PAT_INSTRN1_LOC=? , PRES_REMARK_CODE = ?, DRUG_INDICATION=?, MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=? where facility_id = ? AND order_id = ? AND ORDER_LINE_NO =? AND DISP_DRUG_CODE =?"); // AND DISP_DRUG_CODE added for ML-BRU-SCF-0179 [IN:032578]  //Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]
			}
			if(disp_bean.getAllowEditDispLabel().equals("Y")){// if block Added for Bru-HIMS-CRF-414 [IN:045554]
				sqlMap.put("SQL_PH_DISP_LABEL_UPDATE", PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_UPDATE"));
				sqlMap.put("SQL_PH_DISP_LABEL_INSERT", PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_INSERT"));
				if(sDispStage!=null && (sDispStage.equals("F")||sDispStage.equals("A")))
					sqlMap.put("SQL_PH_DISP_LABEL_SELECT_DISP_DTL", PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_SELECT_DISP_DTL_TMP"));
				else
					sqlMap.put("SQL_PH_DISP_LABEL_SELECT_DISP_DTL", PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_SELECT_DISP_DTL"));
				sqlMap.put("SQL_PH_DISP_LABEL_SELECT_COUNT", PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_SELECT_COUNT"));
				sqlMap.put("SQL_PH_DISP_LABEL_DELETE", PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_DELETE"));
				sqlMap.put("SQL_PH_DISP_LABEL_DTL_TMP_PREV_INSERT", PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_DTL_TMP_PREV_INSERT"));
			}
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_DISP_MEDICATION" ),DispMedicationHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
			(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void setEditDispLabelAfterDisp(String sFacilityId){
		String PH_EDIT_LBL_PARAM = "select EDIT_DISP_LABEL_AFTER_DEL from ph_facility_param where facility_id = ?";
		Connection oConnection			    = null;
		ResultSet oResultSet				= null;
		PreparedStatement oPrepStatement	= null;
		boolean bEditLblParam				= false;
		String sDispLabelParam				= "";
		try{
			oConnection	= getConnection() ;
			oPrepStatement	= oConnection.prepareStatement(PH_EDIT_LBL_PARAM);

			oPrepStatement.setString(1,sFacilityId);
			oResultSet	= oPrepStatement.executeQuery();
			if(oResultSet!=null && oResultSet.next()){
				sDispLabelParam	= oResultSet.getString("EDIT_DISP_LABEL_AFTER_DEL");
				if(sDispLabelParam.equals("Y"))
					bEditLblParam = true;
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oPrepStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ){
				e.printStackTrace() ;
			}
		}
		this.bEditDispLabelAfterDisp=bEditLblParam;
	}

	public void setBDecimalAllowedParamYN() {
		Connection oConnection		    = null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		boolean bDecimalAllowed			= false;
		try {
			oConnection	= getConnection() ;
			oStatement	= oConnection.createStatement();
			oResultSet	= oStatement.executeQuery("select DISP_DECIMAL_DTLS_YN,NO_OF_DECIMALS from st_acc_entity_param");

			if(oResultSet!=null && oResultSet.next()){
				bDecimalAllowed = oResultSet.getString("DISP_DECIMAL_DTLS_YN")!=null?(oResultSet.getString("DISP_DECIMAL_DTLS_YN").equals("Y")?true:false):false;
				iNoOfDecimals   = oResultSet.getString("NO_OF_DECIMALS")==null?0:Integer.parseInt(oResultSet.getString("NO_OF_DECIMALS"));
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ) {
				e.printStackTrace() ;
			}
		}
		bDecimalAllowedParamYN = bDecimalAllowed;
	}

	public boolean getDecimalAllowedYN(String sItemCode) {
		if(bDecimalAllowedParamYN){
			Connection oConnection		    = null;
			ResultSet oResultSet			= null;
			Statement oStatement			= null;
			boolean bDecimalAllowed			= false;
			try {
				oConnection	= getConnection() ;
				oStatement	= oConnection.createStatement();
				oResultSet	= oStatement.executeQuery("select ALLOW_DECIMALS_YN from st_item where item_code ='"+sItemCode+"'");
				if(oResultSet!=null && oResultSet.next()){
					bDecimalAllowed = oResultSet.getString("ALLOW_DECIMALS_YN")!=null?(oResultSet.getString("ALLOW_DECIMALS_YN").equals("Y")?true:false):false;
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
				catch ( Exception e ) {
					e.printStackTrace() ;
				}
			}
			return bDecimalAllowed;
		}
		else
			return false;
	}

	/*public void setNoOfDecimals() 
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
	}*/
	public String getDispDrugAuthYN(Set stDrugCodes) {
		Connection oConnection		    = null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		StringBuffer sbQuery			= new StringBuffer("SELECT SUM (CASE WHEN disp_auth_reqd_yn = 'Y' THEN 1 ELSE 0 END) AUTH_YN FROM ph_drug WHERE drug_code IN ( ");
		int iNoOfDrugsWithAuth			= 0;
		Iterator iteDrugCodes = stDrugCodes.iterator();
		while(iteDrugCodes.hasNext()){
			sbQuery.append("'").append(iteDrugCodes.next()).append("',");
		}
		sbQuery.replace(sbQuery.length()-1,sbQuery.length(),")");

		try{
			oConnection	= getConnection() ;
			oStatement	= oConnection.createStatement();
			oResultSet	= oStatement.executeQuery(sbQuery.toString());

			if(oResultSet!=null && oResultSet.next()){
				iNoOfDrugsWithAuth = oResultSet.getString("AUTH_YN")==null?0:Integer.parseInt(oResultSet.getString("AUTH_YN"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ) {
				e.printStackTrace() ;
			}
		}
		return iNoOfDrugsWithAuth > 0?"Y":"N";
	}

	public ArrayList setIssueUOMValuesLevelTwo(String sOrderId, String sOrderLineNo, String sItemCode){
		Connection oConnection					= null;
		ResultSet oResultSet					= null;
		PreparedStatement oPrepStatement		= null;
		//StringBuffer sbQuery					= new StringBuffer("SELECT a.item_code, a.eqvl_uom_code UOM_CODE, b.short_desc UOM_DESC,( a.eqvl_value / a.eqvl_uom_qty) CONVERTED_EQUAL, ( c.eqvl_value / c.eqvl_uom_qty) DEFAULT_EQUAL, ISSUE_UOM_CODE , DISP_QTY, ISSUE_QTY FROM mm_item_uom_defn a,am_uom_lang_vw b, mm_item_uom_defn c, ph_drug d, ph_disp_dtl_tmp e, mm_item f WHERE c.item_code = a.item_code AND c.item_code = d.drug_code AND c.eqvl_uom_code = d.stock_uom AND f.gen_uom_code = c.uom_code AND a.EFF_STATUS = 'E' and a.eqvl_uom_code = b.uom_code AND f.item_code = a.item_code AND order_id = ? AND order_line_no = ?   AND a.eqvl_uom_code IN (e.DISP_UOM_CODE, e.ISSUE_UOM_CODE) AND a.item_code = ? AND b.language_id = ? ");
		StringBuffer sbQuery					= new StringBuffer("SELECT a.item_code, a.eqvl_uom_code UOM_CODE, b.short_desc UOM_DESC,PH_calculate_equl_val(a.ITEM_CODE,a.UOM_CODE,a.EQVL_UOM_CODE) CONVERTED_EQUAL, PH_calculate_equl_val(c.ITEM_CODE,c.UOM_CODE,c.EQVL_UOM_CODE) DEFAULT_EQUAL, ISSUE_UOM_CODE , DISP_QTY, ISSUE_QTY, e.DISP_UOM_CODE FROM mm_item_uom_defn a,am_uom_lang_vw b, mm_item_uom_defn c, ph_drug d, ph_disp_dtl_tmp e, mm_item f WHERE c.item_code = a.item_code AND c.item_code = d.drug_code AND c.eqvl_uom_code = d.stock_uom AND f.gen_uom_code = c.uom_code AND a.EFF_STATUS = 'E' and a.eqvl_uom_code = b.uom_code AND f.item_code = a.item_code AND order_id = ? AND order_line_no = ?   AND a.eqvl_uom_code IN (e.DISP_UOM_CODE, e.ISSUE_UOM_CODE) AND a.item_code = ? AND b.language_id = ? "); 
		ArrayList alValues						=  new ArrayList();
		HashMap hmUOMValues						=  null;

		try{
			oConnection	= getConnection() ;
			oPrepStatement	= oConnection.prepareStatement(sbQuery.toString());
			oPrepStatement.setString(1,sOrderId);
			oPrepStatement.setString(2,sOrderLineNo);
			oPrepStatement.setString(3,sItemCode);
			oPrepStatement.setString(4,getLanguageId());

            oResultSet	= oPrepStatement.executeQuery() ;
			
			if(oResultSet!=null){
				while(oResultSet.next()){
					hmUOMValues	=  new HashMap();
					hmUOMValues.put("UOM_CODE",checkForNull(oResultSet.getString("UOM_CODE")));
					hmUOMValues.put("UOM_DESC",checkForNull(oResultSet.getString("UOM_DESC")));
					hmUOMValues.put("CONVERTED_EQUAL",checkForNull(oResultSet.getString("CONVERTED_EQUAL")));
					hmUOMValues.put("DEFAULT_EQUAL",checkForNull(oResultSet.getString("DEFAULT_EQUAL")));
					hmUOMValues.put("DISP_QTY",checkForNull(oResultSet.getString("DISP_QTY")));
					hmUOMValues.put("ISSUE_QTY",checkForNull(oResultSet.getString("ISSUE_QTY")));
					hmUOMValues.put("DISP_UOM_CODE",checkForNull(oResultSet.getString("DISP_UOM_CODE")));
					hmUOMValues.put("ISSUE_UOM_CODE",checkForNull(oResultSet.getString("ISSUE_UOM_CODE")));
					alValues.add(hmUOMValues);
				}
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oPrepStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ){
				e.printStackTrace() ;
			}
		}
		return alValues;
	}

	public String getLocalInstr(String instr,String lang_id){
		Connection oConnection			    = null;
		ResultSet oResultSet				= null;
		PreparedStatement oPrepStatement	= null;
		String sLabelTextID					= instr;
		String sLocalLabelText				= "";
		try{
			oConnection	= getConnection() ;
			//oPrepStatement	= oConnection.prepareStatement("SELECT LABEL_TEXT_ID,LABEL_TEXT_1, LANGUAGE_ID FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_1= ? AND LANGUAGE_ID = 'en'");
			/*oPrepStatement	= oConnection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_EDIT_LABEL_TEXT_ID_SELECT"));

			oPrepStatement.setString(1,instr);
			oResultSet	= oPrepStatement.executeQuery();

			if(oResultSet!=null && oResultSet.next())
			{
				sLabelTextID	= oResultSet.getString("LABEL_TEXT_ID");
			}
			else
			{
			 sLocalLabelText = instr;
			 return sLocalLabelText;
			}


			closeResultSet( oResultSet ) ;
			closeStatement( oPrepStatement ) ;
			*/ 
			//oPrepStatement	= oConnection.prepareStatement("SELECT LABEL_TEXT_ID,LABEL_TEXT_1, LANGUAGE_ID FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_ID= ? AND LANGUAGE_ID = ?");
			oPrepStatement	= oConnection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_EDIT_LABEL_TEXT_SELECT"));

			oPrepStatement.setString(1,sLabelTextID);
			oPrepStatement.setString(2,lang_id);
			oResultSet	= oPrepStatement.executeQuery();

			if(oResultSet!=null && oResultSet.next()){
				sLocalLabelText	= oResultSet.getString("LABEL_TEXT_1");
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oPrepStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ){
				e.printStackTrace() ;
			}
		}
		return sLocalLabelText;
	}


	public boolean checkMedicalItemStock(){
		ArrayList alConsumables = getConsumableDetails();

		Connection oConnection			    = null;
		ResultSet oResultSet				= null;
		PreparedStatement oPrepStatement	= null;
		//String sLabelTextID					= "";  Removed for IN063877
		//String sLocalLabelText				= "";  Removed for IN063877
		HashMap hmConsDetails				= new HashMap();
		HashMap hmbatchDetails				= new HashMap();
		Double dQty							= 0.0;
		boolean bAvailable					= true;

		try{
			oConnection	= getConnection() ;
			oPrepStatement	= oConnection.prepareStatement("SELECT (qty_on_hand - committed_qty) AVAILABLE_QTY FROM st_item_batch a WHERE item_code = ? AND store_code = ? AND batch_id = ? AND to_char(expiry_date_or_receipt_date,'DD/mm/YYYY') = ? AND bin_location_code = ?");
			
			for(int i=0;i<alConsumables.size();i++){
				hmConsDetails = (HashMap) alConsumables.get(i);
				hmbatchDetails = (HashMap) hmConsDetails.get("BATCH_DET");

				oPrepStatement.setString(1,hmbatchDetails.get("ITEM_CODE")==null?"":hmbatchDetails.get("ITEM_CODE").toString());
				oPrepStatement.setString(2,hmbatchDetails.get("STORE_CODE")==null?"":hmbatchDetails.get("STORE_CODE").toString());
				oPrepStatement.setString(3,hmbatchDetails.get("BATCH_ID")==null?"":hmbatchDetails.get("BATCH_ID").toString());
				oPrepStatement.setString(4,hmbatchDetails.get("EXPIRY_DATE")==null?"":hmbatchDetails.get("EXPIRY_DATE").toString());
				oPrepStatement.setString(5,hmbatchDetails.get("BIN_LOCN_CODE")==null?"":hmbatchDetails.get("BIN_LOCN_CODE").toString());

				oResultSet	= oPrepStatement.executeQuery();
				if(oResultSet!=null ){
					dQty = Double.parseDouble(oResultSet.getString("AVAILABLE_QTY"));
					if((dQty - Double.parseDouble(hmConsDetails.get("ALLOC_QTY").toString())) < 0){
						bAvailable = false;
						break;
					}
				}
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oPrepStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ){
				e.printStackTrace() ;
			}
		}
		return bAvailable;
	}

	public String getStrengthUOM(String sDrugCode){
		Connection oConnection					= null;
		ResultSet oResultSet					= null;
		PreparedStatement oPrepStatement		= null;
		String sStrengthUOM						= "";

		try {
			oConnection	= getConnection() ;
			oPrepStatement	= oConnection.prepareStatement("select STRENGTH_UOM from ph_drug where drug_code =?");
			oPrepStatement.setString(1,sDrugCode);
            oResultSet	= oPrepStatement.executeQuery() ;
			
			if(oResultSet!=null && oResultSet.next()){
				sStrengthUOM = oResultSet.getString("STRENGTH_UOM");
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oPrepStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ){
				e.printStackTrace() ;
			}
		}
		return sStrengthUOM;
	}

	public double getEquvlValue1(String item_code){
		Connection oConnection					= null;
		ResultSet oResultSet					= null;
		PreparedStatement oPrepStatement		= null;
		double equvl_value						= 1;

		try{
			oConnection	= getConnection() ;
			oPrepStatement	= oConnection.prepareStatement("select nvl((eqvl_value / eqvl_uom_qty),'1' )EQVL_VALUE from  MM_ITEM_UOM_DEFN a,ph_drug b where a.item_code=b.drug_code and a.EQVL_UOM_CODE=b.stock_uom and  a.ITEM_CODE=?  and EFF_STATUS = 'E'");
			oPrepStatement.setString(1,item_code);
            oResultSet	= oPrepStatement.executeQuery() ;
			if(oResultSet!=null && oResultSet.next()){
				equvl_value = oResultSet.getDouble("EQVL_VALUE");
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oPrepStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ){
				e.printStackTrace() ;
			}
		}
		return equvl_value;
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
		return billable_item_yn;
	}

	public String getNonMFRfluidRemarks(String orderId,String orderLineNum){
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		String fluidRemark="";
		try{
			connection=getConnection();
			pstmt=connection.prepareStatement("SELECT MFR_REMARKS FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=? AND MFR_YN='N'");
			pstmt.setString(1,orderId);
			pstmt.setString(2,orderLineNum);
			resultSet=pstmt.executeQuery();
			if(resultSet.next()){
				fluidRemark=resultSet.getString("MFR_REMARKS")==null?"":resultSet.getString("MFR_REMARKS");
			}			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet( resultSet) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return fluidRemark;
	}

	public String getDispTRNSeqNo(String Disp_no){
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;	
		String disp_trn_seq_no="";
		try{
			connection=getConnection();
			pstmt=connection.prepareStatement("select ph_disp_cons_dtl.DISP_TRN_SEQ_NO  DISP_TRN_SEQ_NO from ph_disp_cons_dtl  where DISP_TRN_SEQ_NO =(select DISP_TRN_SEQ_NO from ph_disp_hdr_tmp where disp_tmp_no =?)");
			pstmt.setString(1,Disp_no);			
			resultSet=pstmt.executeQuery();
			if(resultSet.next()){
				disp_trn_seq_no=resultSet.getString("DISP_TRN_SEQ_NO")==null?"":resultSet.getString("DISP_TRN_SEQ_NO");
			}			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet( resultSet) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return disp_trn_seq_no;
	}

	public int getCertificateReimburseCount (String disp_no_from,String disp_no_to ,String stage)throws Exception	{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rs		        = null;
		int cnt			            = 0;
		try {
			connection	= getConnection() ;
			if(stage.equals("A")||stage.equals("F")){
			   pstmt = connection.prepareStatement("select count(*)cnt from ph_disp_hdr_tmp where DISP_TMP_NO between ? and ? and CERT_REIMB_NO is not null");
			}else{
				pstmt = connection.prepareStatement("select count(*)cnt from ph_disp_hdr where DISP_NO between ? and ? and CERT_REIMB_NO is not null");
			}

			pstmt.setString(1,disp_no_from);			
			pstmt.setString(2,disp_no_to);			
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				cnt = rs.getInt("cnt");
			}			

			}catch ( Exception e ) {
				e.printStackTrace() ;
			}
			finally {
				closeResultSet( rs) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
			}
		return cnt;
	}
	//Added for SKR-SCF-280 ICN 29433 -Start
	public ArrayList getDispQty(String order_id, String disp_no,String stage){
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rs		        = null;
		//int cnt			            = 0;  Removed for IN063877
		String sql="";
		ArrayList alDispQtyVal = new ArrayList();
		try {
			connection	= getConnection() ;

			if(stage.equals("F") || stage.equals("A") ){
				//pstmt = connection.prepareStatement("select DISP_QTY from ph_disp_dtl_tmp where order_id =? and DISP_TMP_NO=?");
				/*pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISPMEDN_FILLED_DISPQTY_SELECT"));
				pstmt.setString(1,order_id);			
				pstmt.setString(2,disp_no);	*/	
				sql = PhRepository.getPhKeyValue("SQL_PH_DISPMEDN_FILLED_DISPQTY_SELECT");
			}
			if(stage.equals("D")){
				//pstmt = connection.prepareStatement("select DISP_QTY from ph_disp_dtl where order_id =? and DISP_NO=?");
				/*pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISPMEDN_DELEVERED_DISPQTY_SELECT"));
				pstmt.setString(1,order_id);			
				pstmt.setString(2,disp_no);	*/	
				sql = PhRepository.getPhKeyValue("SQL_PH_DISPMEDN_DELEVERED_DISPQTY_SELECT");
			}
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,order_id);			
			pstmt.setString(2,disp_no);		
			rs = pstmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					alDispQtyVal.add(checkForNull(rs.getString("DISP_QTY")));
				}			
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( rs) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
			}
			catch( Exception e1){
				e1.printStackTrace() ;
			}
		}
		return alDispQtyVal;
	}
	//Added for SKR-SCF-280 ICN 29433 -End
	//Added for  JD-CRF-0009
	public ArrayList getBMSReasons(String locale){
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rs		        = null;
	//	int cnt			            = 0;  Removed for IN063877
		ArrayList alBMSReasons = new ArrayList();
		if(locale == null || locale.equals(""))
			locale = getLanguageId();
		try {
			connection	= getConnection() ;

			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISPMEDN_BMS_REASONS_SELECT"));
			pstmt.setString(1,locale);			
			rs = pstmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					alBMSReasons.add(rs.getString("reason_code"));
					alBMSReasons.add(rs.getString("reason_desc"));
				}			
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( rs) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
			}
			catch( Exception e1){
				e1.printStackTrace() ;
			}
		}
		return alBMSReasons;
	}

	//Added for JD-CRF-0009 -End
	public String getPrintNoOfCopies(String drugCode)throws Exception{
	
	    Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rs		        = null;
		String qtyBasedPrint			= "";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("select PRINT_LABEL_BASED_ON_QTY_YN from ph_drug where drug_code=?");
			pstmt.setString(1,drugCode);			
			//pstmt.setString(2,drugName);			
			rs = pstmt.executeQuery();
			if(rs.next()){
				qtyBasedPrint = rs.getString("PRINT_LABEL_BASED_ON_QTY_YN");
			}			
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rs) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return qtyBasedPrint;
	}

	public String getOrderIdForDisp(String disp_tmp_no,String stage)throws Exception{
	
	    Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rs		        = null;
		String orderId			= "";
		ArrayList disp_stage			=disp_bean.getDispMedStages();//added for SKR-SCF-0611 [IN:034816] . Getting Disp Stages.
		String delivery_applicable = disp_bean.getDeliveryApplicable();//checkDeliveryApplicability
		try {
			connection	= getConnection() ;
			//if(stage.equals("F")||stage.equals("A") ){
			//if(((String)disp_stage.get(disp_stage.size()-1)).equals(stage) && !delivery_applicable.equals("Y")){
			if(stage.equals("D") || stage.equals("AS") || stage.equals("DF")||(disp_stage.get(disp_stage.size()-1).equals(stage) && !delivery_applicable.equals("Y"))) {// added for SKR-SCF-0611 [IN:034816]
				pstmt = connection.prepareStatement("select ORDER_ID from ph_disp_dtl where disp_no = ?");
			}
			else
				pstmt = connection.prepareStatement("select ORDER_ID from ph_disp_dtl_tmp where disp_tmp_no = ?");
			
			pstmt.setString(1,disp_tmp_no);			
			//pstmt.setString(2,drugName);			
			rs = pstmt.executeQuery();
			if(rs.next()){
				orderId = rs.getString("ORDER_ID");
			}			
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rs) ; 
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return orderId;
	}

	public String getDispQuantity(String drug_tmp_no,String order_id,String order_line_no,String stage,String alt_yn,String drug_code)throws Exception{//alt_yn and drug_code added for ML-BRU-SCF-1714
	
	    Connection connection		=   null;
        PreparedStatement pstmt		=   null;
		PreparedStatement pstmt_taper_select		=   null;
		PreparedStatement pstmt_qty_select	=   null;
        ResultSet rs		        =   null;
		ResultSet rs_taper		        =   null;
		ResultSet rs_qty		        =   null;
		String dispQty		    	=   "";
		String taper_order_id = "";
		String taper_order_line_no="";
		//ArrayList  chkOrderDispList = new ArrayList(); //Commented for common-icn-0048
		String sqlAppend = "";//ML-BRU-SCF-1714
		int i=1;//ML-BRU-SCF-1714
		try {
			connection	= getConnection() ;
			if(stage.equals("F") || stage.equals("A") ){
				if(alt_yn.equals("Y")) //ML-BRU-SCF-1714
				sqlAppend = " and DISP_DRUG_CODE = ?";

			 	pstmt = connection.prepareStatement("select DISP_QTY from ph_disp_dtl_tmp where disp_tmp_no =? and order_id=? and order_line_no=? "+sqlAppend+"  and facility_id=?");
			}
			else{
				if(alt_yn.equals("Y")) //ML-BRU-SCF-1714
				 sqlAppend = " and DISP_DRUG_CODE = ?";

			    pstmt = connection.prepareStatement("select DISP_QTY from ph_disp_dtl where disp_no =? and order_id=? and order_line_no=? "+sqlAppend+" and facility_id=?");
			}
			pstmt.setString(i++,drug_tmp_no);			
			pstmt.setString(i++,order_id);	
			pstmt.setString(i++,order_line_no);	
			if(alt_yn.equals("Y")) //ML-BRU-SCF-1714
				pstmt.setString(i++,drug_code);	

            pstmt.setString(i++,login_facility_id);	
			rs = pstmt.executeQuery();
			if(rs.next()){
				dispQty = rs.getString("DISP_QTY");
			}			
			if(dispQty.equals("0")){//newly added for CRF-0074 - start		
				pstmt_taper_select = connection.prepareStatement("select TAPER_ORDER_ID,TAPER_ORDER_LINE_NUM from or_order_line_ph where order_id=? and ORDER_LINE_NUM=?");
				pstmt_taper_select.setString(1,order_id);			
				pstmt_taper_select.setString(2,order_line_no);	
				rs_taper = pstmt_taper_select.executeQuery();
				if(rs_taper!=null && rs_taper.next()){
					taper_order_id = rs_taper.getString("TAPER_ORDER_ID");
					taper_order_line_no = rs_taper.getString("TAPER_ORDER_LINE_NUM");
					if(stage.equals("F") || stage.equals("A") ){
						pstmt_qty_select = connection.prepareStatement("select DISP_QTY from ph_disp_dtl_tmp where  order_id=? and order_line_no=? and facility_id=?");
					}
					else{
						pstmt_qty_select = connection.prepareStatement("select DISP_QTY from ph_disp_dtl where  order_id=? and order_line_no=? and facility_id=?");
					}
		
					pstmt_qty_select.setString(1,taper_order_id);	
					pstmt_qty_select.setString(2,taper_order_line_no);	
					pstmt_qty_select.setString(3,login_facility_id);			
					rs_qty = pstmt_qty_select.executeQuery();
					if(rs_qty!=null && rs_qty.next()){
						dispQty = rs_qty.getString("DISP_QTY");
					}
					if(Integer.parseInt(dispQty)>0){
						dispQty = "1";
					}
				}
			}
//newly added for CRF-0074 - end
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rs) ;
			closeResultSet( rs_taper );
			closeResultSet( rs_qty );
			closeStatement( pstmt ) ;
			closeStatement( pstmt_taper_select );
			closeStatement(	pstmt_qty_select );
			closeConnection( connection ); 
		}
		return dispQty;
	}
	// Code Added For FD-Bru-HIMS-CRF-074 Start
	public ArrayList getLangNameAndId(String langID){
        Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		ArrayList landNameAndId			    = new ArrayList();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "select LANGUAGE_ID,SHORT_NAME from sm_language where LANGUAGE_ID =?") ;
            pstmt.setString(1,langID);			
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				landNameAndId.add(checkForNull(resultSet.getString("LANGUAGE_ID")));
				landNameAndId.add(checkForNull(resultSet.getString("SHORT_NAME")));
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
		return landNameAndId;
   }

   public String getLangId(String shortName){
        Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		String langId			    ="";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "select LANGUAGE_ID from sm_language where SHORT_NAME =?") ;
            pstmt.setString(1,shortName);			
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				langId = checkForNull(resultSet.getString("LANGUAGE_ID"));
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
		return langId;
   }
	//Code Added For FD-Bru-HIMS-CRF-074 End
	//Added  for ICN-31165-Start
	public String getTPNDispQuantity(String order_id,String order_line_no,String stage)throws Exception{
	
	    Connection connection		=   null;
        PreparedStatement pstmt		=   null;
        ResultSet rs		        =   null;
		String dispQty		    	=   "0";
			try {
				connection	= getConnection() ;
				boolean siteTpn = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","TPN_MF_LABEL");// added for ML-MMOH-CRF-0468
				if(stage.equals("F") || stage.equals("A") ){
					pstmt = connection.prepareStatement("select DISP_QTY from ph_disp_dtl_tmp a, or_order b  where  a.order_id=? and a.order_line_no=? and a.facility_id=? and a.order_id=b.order_id and B.IV_PREP_YN in ('7','8') ");
				}
				
				else{
					 if(siteTpn){
						pstmt = connection.prepareStatement("select QTY_VOLUME from PH_TPN_WORKSHEET_HDR a, or_order b  where  a.order_id=?  and a.facility_id=? and a.order_id=b.order_id and B.IV_PREP_YN in ('7','8')");
					}
					 else pstmt = connection.prepareStatement("select DISP_QTY from ph_disp_dtl a, or_order b  where  a.order_id=? and a.order_line_no=? and a.facility_id=? and a.order_id=b.order_id and B.IV_PREP_YN in ('7','8')");
				
				}
					
				
				if(stage.equals("F") || stage.equals("A") ) {
					pstmt.setString(1,order_id);
					pstmt.setString(2,order_line_no);
					pstmt.setString(3,login_facility_id);	
				}
				else{
					if(siteTpn){
						pstmt.setString(1,order_id);
						//pstmt.setString(2,order_line_no);
						pstmt.setString(2,login_facility_id);	
					}
					else{
						pstmt.setString(1,order_id);
						pstmt.setString(2,order_line_no);
						pstmt.setString(3,login_facility_id);	
					}
				}
						
				rs = pstmt.executeQuery();
				if(rs.next()){
					if(siteTpn){
						dispQty = rs.getString("QTY_VOLUME");
					}
					else
					{
						dispQty = rs.getString("DISP_QTY");
					}
					
				}
			}
			catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rs) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return dispQty;
	}//Added  for ICN-31165-End

	//Added for Bru-HIMS-CRF-142 [IN:030195] - Start 	
	public ArrayList getStrNamesDispLocn(String disp_locn_code)	{

		Connection connection	=  null ;
		PreparedStatement pstmt =  null ;
		ResultSet resultSet		=  null ;
		ArrayList str_names		=  new ArrayList();
		String sql_str			=	null;
		try{
			connection			= getConnection() ;
			sql_str				= "SELECT B.STORAGE_BIN_CODE STORAGE_CODE, B.STORAGE_NAME STORAGE_NAME FROM PH_DISP_LOCN A, PH_STORAGE_BIN_LOCN B WHERE A.DISP_LOCN_CODE = B.DISP_LOCN_CODE AND A.FACILITY_ID = B.FACILITY_ID AND A.STORAGE_LOCN_APPL_YN = 'Y' AND B.DISP_LOCN_CODE = ?  AND B.FACILITY_ID = ? AND B.EFF_STATUS = 'E'";

			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,disp_locn_code);
			pstmt.setString(2,login_facility_id);

			resultSet	= pstmt.executeQuery();

			while (resultSet.next()){
				str_names.add(checkForNull(resultSet.getString("STORAGE_CODE")));
				str_names.add(checkForNull(resultSet.getString("STORAGE_NAME")));
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
			}catch(Exception es){ es.printStackTrace();
			}
		}
	
		return str_names;
	}

	public void setStorageLocn(String patient_id,String locn_code,String str_locn,String curr_stage,String token_series,String patient_arvd,String delivery_bin_yn,String encounter_id){//Added patient_id and encounter_id for TH-KW-CRF-0020.9
		Connection connection	=  null ;
		PreparedStatement pstmt =  null ;
		PreparedStatement pstmt_select =  null ;//Added for TH-KW-CRF-0020.9
		PreparedStatement pstmt_delete =  null ;//Added for TH-KW-CRF-0020.9
		PreparedStatement pstmt_insert =  null ;//Added for TH-KW-CRF-0020.9
		ResultSet resultSet		=  null ;//Added for TH-KW-CRF-0020.9
		Iterator token_num_iterator = token_vals.keySet().iterator();
		String sql_str ="";
		String sql_str1 ="";
		String insert_str = "";//Added for TH-KW-CRF-0020.9
		String delete_str = "";//Added for TH-KW-CRF-0020.9
		String select_str = "";//Added for TH-KW-CRF-0020.9
        String tokn_num = "";
		int bin_count = 0;
		//ArrayList orders  =new ArrayList(); COMMON-ICN-0310
		try{
			connection			= getConnection() ;
			if(delivery_bin_yn.equals("Y")){//Adding start for TH-KW-CRF-0020.9
        try{
            select_str = "SELECT COUNT(*) BIN_COUNT FROM PH_DISP_BIN_LOCATION WHERE PATIENT_ID =? AND ENCOUNTER_ID =? AND DISP_LOCN_CODE =? ";
            delete_str = "DELETE  PH_DISP_BIN_LOCATION WHERE PATIENT_ID =? AND ENCOUNTER_ID =? AND DISP_LOCN_CODE =? ";          
		    insert_str	 = "INSERT INTO PH_DISP_BIN_LOCATION (FACILITY_ID,DISP_LOCN_CODE,PATIENT_ID,ENCOUNTER_ID,STORAGE_BIN_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
      
             System.err.println("patient_id@@==="+patient_id+"encounter_id=="+encounter_id+"locn_code=="+locn_code+"str_locn=="+str_locn);
            
              pstmt_select              = connection.prepareStatement(select_str) ;
			  pstmt_select.setString(1,patient_id);
			  pstmt_select.setString(2,encounter_id);
			  pstmt_select.setString(3,locn_code);
			  resultSet	= pstmt_select.executeQuery();

			      if(resultSet.next()){
						bin_count = resultSet.getInt("BIN_COUNT");
					}
				   closeResultSet( resultSet ) ;
                   closeStatement( pstmt_select ) ;
             if(bin_count>0){
				 pstmt_delete              = connection.prepareStatement(delete_str) ;
				       pstmt_delete.setString(1,patient_id);
			           pstmt_delete.setString(2,encounter_id);
			           pstmt_delete.setString(3,locn_code);
					   pstmt_delete.executeUpdate();
			 }
			  pstmt_insert				= connection.prepareStatement(insert_str) ;

				   pstmt_insert.setString(1,login_facility_id);
				   pstmt_insert.setString(2,locn_code);
				   pstmt_insert.setString(3,patient_id);
				   pstmt_insert.setString(4,encounter_id);
				   pstmt_insert.setString(5,str_locn);
				   pstmt_insert.setString(6,login_by_id);
				   pstmt_insert.setString(7,login_at_ws_no);
				   pstmt_insert.setString(8,login_facility_id);
				   pstmt_insert.setString(9,login_by_id);
				   pstmt_insert.setString(10,login_at_ws_no);
				   pstmt_insert.setString(11,login_facility_id);
			       pstmt_insert.executeUpdate();

				}
				catch(Exception alExp){
					alExp.printStackTrace();			  
				}

			}else{//Adding end for TH-KW-CRF-0020.9
                                            
			sql_str				= "UPDATE PH_DISP_QUEUE SET STORAGE_BIN_CODE=? WHERE FACILITY_ID=? AND DISP_LOCN_CODE=? AND QUEUE_DATE=TRUNC(SYSDATE) AND	TOKEN_SERIES_CODE=? AND TOKEN_SERIAL_NO=? AND QUEUE_SHIFT='*ALL'";
			pstmt				= connection.prepareStatement(sql_str) ;
			String[] tokenCode_num ; // added HSA-SCF-0081 [IN:050227]
			if(!curr_stage.equals("D")){
				try{
					while( token_num_iterator.hasNext() ){			
						tokn_num = (String)token_vals.get(token_num_iterator.next()); //added for HSA-SCF-0081 [IN:050227]
						tokenCode_num = tokn_num.split("_"); // added for HSA-SCF-0081 [IN:050227]
						pstmt.setString(1,str_locn);
						pstmt.setString(2,login_facility_id);
						pstmt.setString(3,locn_code);
						pstmt.setString(4,tokenCode_num[0]); //changed from disp_bean.getTokenSeriesCode() to tokenCode_num[0] for  HSA-SCF-0081 [IN:050227]
						pstmt.setString(5,tokenCode_num[1]);//changed from tokn_num to tokenCode_num[1] for  HSA-SCF-0081 [IN:050227]
						pstmt.addBatch();
					}
				
					int[] result	=pstmt.executeBatch();
					for (int i=0;i<result.length ;i++ ){
						if(result[i]<0  && result[i] != -2 ){
							pstmt.cancel();
							connection.rollback();
						}		
					}
				}
				catch(Exception alExp){
					alExp.printStackTrace();			  
				}
			}
			else if(curr_stage.equals("D")){
				try{
					sql_str1  ="UPDATE PH_DISP_QUEUE SET STORAGE_BIN_CODE=? WHERE FACILITY_ID=? AND DISP_LOCN_CODE=? AND QUEUE_DATE=TRUNC(SYSDATE) AND TOKEN_SERIES_CODE=?  AND token_serial_no = ? AND  QUEUE_SHIFT='*ALL' AND PATIENT_ID = ?";

					if(patient_arvd.equals("green"))
						sql_str1 ="UPDATE PH_DISP_QUEUE SET STORAGE_BIN_CODE=?,CALL_FOR_SERVING_TIME = SYSDATE WHERE FACILITY_ID=? AND DISP_LOCN_CODE=? AND QUEUE_DATE=TRUNC(SYSDATE) AND TOKEN_SERIES_CODE=? AND token_serial_no = ? AND QUEUE_SHIFT='*ALL' AND PATIENT_ID = ?";  

					pstmt				= connection.prepareStatement(sql_str1) ;
					while( token_num_iterator.hasNext() ){
						tokn_num = (String)token_vals.get(token_num_iterator.next()); //added for  HSA-SCF-0081 [IN:050227]
						tokenCode_num = tokn_num.split("_"); //added for  HSA-SCF-0081 [IN:050227]
						pstmt.setString(1,str_locn);
						pstmt.setString(2,login_facility_id);
						pstmt.setString(3,locn_code);
						pstmt.setString(4,tokenCode_num[0]); //changed from tokn_num to tokenCode_num[0] for  HSA-SCF-0081 [IN:050227]
						pstmt.setString(5,tokenCode_num[1]); //changed from tokn_num to tokenCode_num[1] for  HSA-SCF-0081 [IN:050227]
						pstmt.setString(6,patient_id);
						pstmt.executeUpdate();
					}
				}
				catch(Exception dlExp){
					dlExp.printStackTrace();			  
				}	
			}
		 }
		}
		catch(Exception stExp){
			stExp.printStackTrace();
		}
		finally {
			try{
				connection.commit();
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;//Added for TH-KW-CRF-0020.9
				closeStatement( pstmt_select ) ;//Added for TH-KW-CRF-0020.9
				closeStatement( pstmt_delete ) ;//Added for TH-KW-CRF-0020.9
				closeStatement( pstmt_insert ) ;//Added for TH-KW-CRF-0020.9
				closeConnection( connection );
			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}
	}

	public String getStorageLocation(String disp_locn_code,String token_series,String patient_id){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String str_locn			= "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( "SELECT DISTINCT STORAGE_BIN_CODE FROM PH_DISP_QUEUE WHERE FACILITY_ID=? AND DISP_LOCN_CODE=? AND QUEUE_DATE=TRUNC(SYSDATE) AND TOKEN_SERIES_CODE=? AND QUEUE_SHIFT='*ALL' AND PATIENT_ID = ?") ;

			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,disp_locn_code);
			pstmt.setString(3,token_series);
			pstmt.setString(4,patient_id);
			
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				str_locn	=	checkForNull(resultSet.getString("STORAGE_BIN_CODE"));		
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
		return str_locn;
	}
	//Added for Bru-HIMS-CRF-142 [IN:030195] - eND 	
	public String validateUserAuthPIN(String User_ID,String PIN,String call_from,String disp_locn_code,String disp_category) throws Exception{
		Connection connection	= null;
        PreparedStatement pstmt	= null;//pstmt1	= null;  Removed for IN063877
        ResultSet resultSet		= null;//resultSet1		= null; Removed for IN063877
		String result= "0", stageCondition= "";
		String sqlForMARUserPIN="", sqlForDispensingUserPIN="";

		try {
		
			if(!call_from.equals("MAR") && call_from.equals("DD"))
				sqlForDispensingUserPIN ="SELECT  1 RESULT FROM sm_appl_user a, am_practitioner b WHERE A.APPL_USER_ID = B.PRACTITIONER_ID and   b.pract_type IN ('NS', 'MD', 'DN', 'PH') AND (A.PIN_NO IS NOT NULL OR A.PIN_NO <> '') AND UPPER (a.appl_user_id) = UPPER (?) AND APP_PASSWORD.DECRYPT(a.PIN_NO)=? ";   // added null check to pin_no for CRF-PH- RUT-CRF-0035 [IN029926]
			else{			
				sqlForDispensingUserPIN="SELECT 1 RESULT FROM sm_appl_user a, ph_disp_rights b WHERE b.facility_id = ? AND b.disp_locn_code = ?  and a.eff_status = 'E' and A.APPL_USER_ID = B.APPL_USER_ID  AND (A.PIN_NO IS NOT NULL OR A.PIN_NO <> '') AND ( (a.eff_date_from IS NULL AND a.eff_date_to IS NULL) OR (TRUNC (a.eff_date_from) <= TRUNC (SYSDATE) AND a.eff_date_to IS NULL ) OR (TRUNC (a.eff_date_to) >= TRUNC (SYSDATE) AND a.eff_date_from IS NULL ) OR ( TRUNC (SYSDATE) BETWEEN TRUNC (a.eff_date_from)   AND TRUNC (a.eff_date_to) AND a.eff_date_from IS NOT NULL AND a.eff_date_to IS NOT NULL ) ) AND UPPER (a.appl_user_id) = UPPER (?) AND APP_PASSWORD.DECRYPT(a.PIN_NO)=?";  // removed a.language_id for CRF-PH- RUT-CRF-0035/04 [IN038477]
				
				if(call_from.equals("A")){
					stageCondition =" and B.ALLOCATE_YN='Y' ";
				}
				else if(call_from.equals("V")){
					if(disp_category.equals("IP") || disp_category.equals("I"))
						stageCondition =" and B.IP_VERIFY_YN='Y' ";
					else
						stageCondition =" and B.VERIFY_YN='Y' ";
				}
				else if(call_from.equals("F") ||  call_from.equals("IPFA")){
					if(disp_category.equals("IP") || disp_category.equals("I") || call_from.equals("IPFA"))
						stageCondition =" and B.IP_ALLOCATE_YN='Y' ";
					else
						stageCondition =" and B.FILL_YN='Y' ";
				}
				else if(call_from.equals("D")){
					stageCondition =" and B.DELIVER_YN='Y' ";
					if(disp_category.equals("IP")  || disp_category.equals("I") )
						stageCondition =" and B.IP_DELIVER_YN='Y' ";
					else
						stageCondition =" and B.DELIVER_YN='Y' ";
				}
				else if(call_from.equals("AS") || call_from.equals("DD")){

					if(disp_category.equals("OP") || disp_category.equals("O") )
						stageCondition =" and B.ALLOCATE_YN='Y' and B.DELIVER_YN='Y' ";
					else if(disp_category.equals("IP")  || disp_category.equals("I") )
						stageCondition =" and B.IP_ALLOCATE_YN='Y' and B.IP_DELIVER_YN='Y' ";
				}	
				sqlForDispensingUserPIN+=stageCondition;
			}
            connection	= getConnection() ;

			if(call_from.equals("MAR")){
				sqlForMARUserPIN="select 1 RESULT from sm_appl_user where eff_status='E' and ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and upper(appl_user_id)=upper(?) AND APP_PASSWORD.DECRYPT(PIN_NO)=?";
					pstmt	= connection.prepareStatement(sqlForMARUserPIN);
					//pstmt.setString(1,getLanguageId());
					pstmt.setString(1,User_ID);
					pstmt.setString(2,PIN);
					resultSet	= pstmt.executeQuery() ;
					if(resultSet.next()){
						result = resultSet.getString("RESULT");
					}
			}
			else{
				pstmt	= connection.prepareStatement(sqlForDispensingUserPIN);
				if(call_from.equals("DD") ){
					pstmt.setString(1,User_ID);
					pstmt.setString(2,PIN);
				}
				else{
					pstmt.setString(1,login_facility_id);
					pstmt.setString(2,disp_locn_code);
					//pstmt.setString(3,getLanguageId());
					pstmt.setString(3,User_ID);
					pstmt.setString(4,PIN);
				}
				resultSet	= pstmt.executeQuery() ;
				if(resultSet.next()){
					result = resultSet.getString("RESULT");
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
		}
		return result;
	}
	
	public String getUserAuthPINYN(String facility_id,String disp_locn_code) throws Exception{ 
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String userAuthPINYN= "N";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("SELECT DISP_AUTH_REQD_YN FROM PH_DISP_LOCN WHERE FACILITY_ID=? AND DISP_LOCN_CODE=?") ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,disp_locn_code);
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				userAuthPINYN = checkForNull(resultSet.getString("DISP_AUTH_REQD_YN"),"N");
				setUserAuthPINRequiredYN(userAuthPINYN);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
		}
		return userAuthPINYN;
	}
	
	public String getAuthUserName(String user_id) throws Exception{
	Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String authUserName= "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE APPL_USER_ID=? AND LANGUAGE_ID=?") ;
			pstmt.setString(1,user_id);
			pstmt.setString(2,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				authUserName = checkForNull(resultSet.getString("APPL_USER_NAME"),"");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		return authUserName;
	}
	// RUT-CRF-0035 [IN029926] PIN Authentication

	public ArrayList getDefLangForLabel(String patient_class){ //Added for MMS-QH-CRF-0069 [IN:037977]
        Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		ArrayList alDefLangDtl			    = new ArrayList();
		try {
            connection	= getConnection() ;
			if(patient_class.equals("OP"))
	            pstmt		= connection.prepareStatement( "select LANGUAGE_ID,SHORT_NAME from sm_language where LANGUAGE_ID in(select DFLT_LANG_FOR_DISP_LABEL from ph_facility_param where facility_id=?)") ;
			else
	            pstmt		= connection.prepareStatement( "select LANGUAGE_ID,SHORT_NAME from sm_language where LANGUAGE_ID in(select DFLT_LANG_FOR_DISP_LABEL_IP from ph_facility_param where facility_id=?)") ;
            pstmt.setString(1,login_facility_id);			
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				alDefLangDtl.add(checkForNull(resultSet.getString("LANGUAGE_ID")));
				alDefLangDtl.add(checkForNull(resultSet.getString("SHORT_NAME")));
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
		return alDefLangDtl;
   }

	public float getDrugPenaltyAmount(){ //added for JD-CRF-0170.1 [IN:040204]
		ArrayList alPenaltyDtls = null; //rule_code#hdr_lvl_min_amt#hdr_lvl_max_amt#blng_serv_code#serv_item_code#dtl_lvl_min_amt#dtl_lvl_max_amt#addlchargeamount@  --count = 8
		ArrayList alPenaltyAmtDtls = null;    //[MIN_YN,MIN_DRG_PNLTY_AMT,MAX_YN,MAX_DRG_PNLTY_AMT,ACTUAL_AMT]
		ArrayList alHdrPenaltyAmtDtls = null; //[MIN_YN,MIN_DRG_PNLTY_AMT,MAX_YN,MAX_DRG_PNLTY_AMT,ACTUAL_AMT]
		ArrayList alKeyList = null;
		HashMap hmItemPenaltyCharges = new HashMap();
		HashMap hmHdrPenaltyCharges = new HashMap();
		float ftMinPenalty=0, ftMaxPenalty=0, ftActPenalty=0,ftATmpctPenalty=0, ftHdrMinPenalty=0, ftHdrMaxPenalty=0;
		String hdrMinYn="", hdrMaxYn="", itemMinYn="", itemMaxYn="";
		String stKey, item_code, RuleCode="";
		StringTokenizer stzItemRule=null;
		try{

			if(hmDrugPenaltyDtls!=null && hmDrugPenaltyDtls.size()>0){
				alKeyList = new ArrayList(hmDrugPenaltyDtls.keySet());
				for(int i=0; i<alKeyList.size(); i++){
					stKey = (String)alKeyList.get(i); //order_id+"~"+order_line_no+"~"+item_code;
					alPenaltyDtls = (ArrayList)hmDrugPenaltyDtls.get(stKey);
					if(alPenaltyDtls!=null && alPenaltyDtls.size()>0){
						for(int j=0;j<alPenaltyDtls.size();j+=12){
							RuleCode=(String)alPenaltyDtls.get(j);
							if(alPenaltyDtls.get(j+1) == null || ((String)alPenaltyDtls.get(j+1)).equals("")){
								ftHdrMinPenalty = 0;
								hdrMinYn = "N";
							}
							else{
								ftHdrMinPenalty =Float.parseFloat((String)alPenaltyDtls.get(j+1));
								hdrMinYn = "Y";
							}
							if(alPenaltyDtls.get(j+2) == null || ((String)alPenaltyDtls.get(j+2)).equals("")){
								ftHdrMaxPenalty = 0;
								hdrMaxYn = "N";
							}
							else{
								ftHdrMaxPenalty =Float.parseFloat((String)alPenaltyDtls.get(j+2));
								hdrMaxYn = "Y";
							}
							item_code =(String)alPenaltyDtls.get(j+4);
							if(alPenaltyDtls.get(j+5) == null || ((String)alPenaltyDtls.get(j+5)).equals("")){
								ftMinPenalty = 0;
								itemMinYn = "N";
							}
							else{
								ftMinPenalty =Float.parseFloat((String)alPenaltyDtls.get(j+5));
								itemMinYn = "Y";
							}
							if(alPenaltyDtls.get(j+6) == null || ((String)alPenaltyDtls.get(j+6)).equals("")){
								ftMaxPenalty = 0;
								itemMaxYn = "N";
							}
							else{
								ftMaxPenalty =Float.parseFloat((String)alPenaltyDtls.get(j+6));
								itemMaxYn="Y";
							}
							ftActPenalty =Float.parseFloat((String)alPenaltyDtls.get(j+7));
							if(hmItemPenaltyCharges.containsKey(item_code+"~"+RuleCode)){
								alPenaltyAmtDtls = (ArrayList)hmItemPenaltyCharges.get(item_code+"~"+RuleCode);
								ftATmpctPenalty = (Float)alPenaltyAmtDtls.get(4)+ftActPenalty;
								if(itemMaxYn.equals("Y") && ftATmpctPenalty >ftMaxPenalty){
									ftATmpctPenalty=ftMaxPenalty;
								}
								else if(itemMinYn.equals("Y") && ftATmpctPenalty < ftMinPenalty){
									ftATmpctPenalty=ftMinPenalty;
								}
								alPenaltyAmtDtls.set(2,ftATmpctPenalty);
							}
							else{
								alPenaltyAmtDtls = new ArrayList();
								alPenaltyAmtDtls.add(itemMinYn);
								alPenaltyAmtDtls.add(ftMinPenalty);
								alPenaltyAmtDtls.add(itemMaxYn);
								alPenaltyAmtDtls.add(ftMaxPenalty);
								if(itemMaxYn.equals("Y") && ftActPenalty >ftMaxPenalty){
									ftActPenalty=ftMaxPenalty;
								}
								else if(itemMinYn.equals("Y") && ftActPenalty < ftMinPenalty){
									ftActPenalty=ftMinPenalty;
								}
								alPenaltyAmtDtls.add(ftActPenalty);
								ftActPenalty=0;
								alHdrPenaltyAmtDtls = new ArrayList();
								alHdrPenaltyAmtDtls.add(hdrMinYn);
								alHdrPenaltyAmtDtls.add(ftHdrMinPenalty);
								alHdrPenaltyAmtDtls.add(hdrMaxYn);
								alHdrPenaltyAmtDtls.add(ftHdrMaxPenalty);
								alHdrPenaltyAmtDtls.add(ftActPenalty);
								hmHdrPenaltyCharges.put(RuleCode,alHdrPenaltyAmtDtls);
							}
							hmItemPenaltyCharges.put(item_code+"~"+RuleCode,alPenaltyAmtDtls);
						}
					}
				}			
				if(hmItemPenaltyCharges!=null && hmItemPenaltyCharges.size()>0){
					alKeyList = new ArrayList(hmItemPenaltyCharges.keySet());
					for(int i=0; i<alKeyList.size(); i++){
						stKey = (String)alKeyList.get(i);
						stzItemRule	=	new StringTokenizer(stKey,"~");
						while(stzItemRule.hasMoreTokens()){
							item_code = (String)stzItemRule.nextToken();
							RuleCode = (String)stzItemRule.nextToken();
						}		
						alPenaltyAmtDtls = (ArrayList)hmItemPenaltyCharges.get(stKey);
						if(alPenaltyAmtDtls!=null && alPenaltyAmtDtls.size()==5){
							ftATmpctPenalty = (Float)alPenaltyAmtDtls.get(4);
							alHdrPenaltyAmtDtls = (ArrayList)hmHdrPenaltyCharges.get(RuleCode);
							if(alHdrPenaltyAmtDtls!=null && alHdrPenaltyAmtDtls.size()>1){
								ftATmpctPenalty = ftATmpctPenalty+(Float)alHdrPenaltyAmtDtls.get(4);
								alHdrPenaltyAmtDtls.set(4, ftATmpctPenalty);
							}
						}
					}
				}

				if(hmHdrPenaltyCharges!=null && hmHdrPenaltyCharges.size()>0){
					alKeyList = new ArrayList(hmHdrPenaltyCharges.keySet());
					ftActPenalty=0;
					for(int i=0; i<alKeyList.size(); i++){
						stKey = (String)alKeyList.get(i);
						alHdrPenaltyAmtDtls = (ArrayList)hmHdrPenaltyCharges.get(stKey);
						if(alHdrPenaltyAmtDtls!=null && alHdrPenaltyAmtDtls.size()>0){
							hdrMinYn = (String)alHdrPenaltyAmtDtls.get(0);
							ftHdrMinPenalty = (Float)alHdrPenaltyAmtDtls.get(1);
							hdrMaxYn = (String)alHdrPenaltyAmtDtls.get(2);
							ftHdrMaxPenalty = (Float)alHdrPenaltyAmtDtls.get(3);
							if(alHdrPenaltyAmtDtls!=null && alHdrPenaltyAmtDtls.size()>1){
								hdrMinYn = (String)alHdrPenaltyAmtDtls.get(0);
								ftHdrMinPenalty = (Float)alHdrPenaltyAmtDtls.get(1);
								hdrMaxYn = (String)alHdrPenaltyAmtDtls.get(2);
								ftHdrMaxPenalty = (Float)alHdrPenaltyAmtDtls.get(3);
							}
							ftATmpctPenalty = (Float)alHdrPenaltyAmtDtls.get(4);
							if(hdrMaxYn.equals("Y") && ftATmpctPenalty >ftHdrMaxPenalty){
								ftATmpctPenalty=ftHdrMaxPenalty;
							}
							else if(hdrMinYn.equals("Y") && ftATmpctPenalty < ftHdrMinPenalty){
								ftATmpctPenalty=ftHdrMinPenalty;
							}
							ftActPenalty+=ftATmpctPenalty;
						}
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ftActPenalty;
	}
	
	public HashMap getHomeMdnChk(String patient_class,String disp_locn_code,String disp_stage, String print_seq_no){//Added for RUT-CRF-0061 [IN:029599] 
		Connection connection   = null;
        PreparedStatement pstmt   = null;       
		ResultSet resultSet    = null;
		HashMap hme_med_ind   = new HashMap();
		HashMap report_option   = new HashMap();
//		boolean printOption = false;  Removed for IN063877
		String print_Status = "";// defPrintOrtn="";  Removed for IN063877
		int taperCount = 0;
		try {
			connection = getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_HOME_MEDN_SHEET_REPORT_PRINT_OPTION")) ;
			pstmt.setString(1,login_facility_id.trim());  
			pstmt.setString(2,patient_class.trim());
			pstmt.setString(3,disp_stage.trim());
			pstmt.setString(4,disp_locn_code.trim());
			resultSet = pstmt.executeQuery() ;
			if(resultSet !=null){
				while (resultSet.next()){
					print_Status = checkForNull(resultSet.getString("PRINT_STATUS"));
					if(!print_Status.equals("NR") && !print_Status.equals("NP"))//Added 'NP' for RUT-CRF-0061[IN46535]
						report_option.put(resultSet.getString("REPORT_ID"),print_Status);
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;  
			if(report_option.size()>0){
				if(disp_stage.equals("D") || disp_stage.equals("AS"))
					pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_HOME_MEDN_SHEET_REPORT_TYPE")) ;
				else
					pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_HOME_MEDN_SHEET_REPORT_TYPE_TMP")) ;
				pstmt.setString(1,print_seq_no);  
				pstmt.setString(2,login_facility_id.trim());
				resultSet = pstmt.executeQuery() ;
				if(resultSet !=null){
					while (resultSet.next()){
						if(resultSet.getString("MED_TYPE_IND").equals("I")){
							hme_med_ind.put("Include",resultSet.getString("MED_TYPE_IND"));
						}
						else if(resultSet.getString("MED_TYPE_IND").equals("S")){
							hme_med_ind.put("Separate",resultSet.getString("MED_TYPE_IND"));
						}
						else if(resultSet.getString("MED_TYPE_IND").equals("O")){
							hme_med_ind.put("Only",resultSet.getString("MED_TYPE_IND"));
						}	
					}
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;  
				if(disp_stage.equals("D") || disp_stage.equals("AS"))
					pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_HOME_MEDN_SHEET_REPORT_TAPER")) ;
				else
					pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_HOME_MEDN_SHEET_REPORT_TAPER_TMP")) ;
				pstmt.setString(1,print_seq_no);  
				pstmt.setString(2,login_facility_id.trim());
				resultSet = pstmt.executeQuery() ;
				if(resultSet !=null){
					while (resultSet.next()){
						taperCount = resultSet.getInt("TAPER_COUNT");
						if(taperCount>1){
							hme_med_ind.put("Taper","Y");
							break;
						}
					}
				}
				if(hme_med_ind.size()>0)
					hme_med_ind.put("REPORT_OPTION", report_option);
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
			catch(Exception ex){
				ex.printStackTrace() ;  
			}
		}
		return hme_med_ind;
	}	//Added for RUT-CRF-0061 - End

	public boolean getRefillOrderYN(String disp_stage, String print_seq_no){//Added for  RUT-SCF-0295 [IN:043115]
		Connection connection   = null;
        PreparedStatement pstmt   = null;       
		ResultSet resultSet    = null;
		int refill_count = 0;
		try {
			connection = getConnection() ;
			if(disp_stage.equals("D") || disp_stage.equals("AS"))
				pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_SHEET_PRINT_FOR_REFILL")) ;
			else
				pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_SHEET_PRINT_FOR_REFILL_TMP")) ;
			pstmt.setString(1,print_seq_no);  
			pstmt.setString(2,login_facility_id.trim());
			resultSet = pstmt.executeQuery() ;
			resultSet = pstmt.executeQuery() ;
			if(resultSet !=null && resultSet.next()){
				refill_count = resultSet.getInt("REFILL_COUNT");
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;  
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
			catch(Exception ex){
				ex.printStackTrace() ;  
			}
		}
		if(refill_count>0)
			return true;
		else
			return false;
	}

	public void setSTEntityData() throws Exception{ // Added for AAKH-SCF-0113 [IN:048937]
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		String  st_no_of_decimals = "0", st_disp_decimal_dtls_yn = "N";
		try{
			connection = getConnection() ;
			pstmt		= connection.prepareStatement("SELECT NO_OF_DECIMALS, DISP_DECIMAL_DTLS_YN FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = 'ZZ'");
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null){
				if(resultSet.next()){
					st_no_of_decimals = checkForNull(resultSet.getString("NO_OF_DECIMALS"));		
					st_disp_decimal_dtls_yn = checkForNull(resultSet.getString("DISP_DECIMAL_DTLS_YN"));
				}
			}  
			setSt_no_of_decimals(st_no_of_decimals);
			setSt_disp_decimal_dtls_yn(st_disp_decimal_dtls_yn);
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

	public void getDispEditableLabeldetails(String order_id,String order_line_num,String pres_drug_code, String drug_code, String labelLangId, String disp_stage, String dispNos){ // disp_stage Added for ML-BRU-SCF-1521[IN:053157] //dispNos ML-BRU-SCF-1521.1 [IN:055331]
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null,rs=null;	//rs added for EMR #2913
		String cau_instructions	="", spl_instructions	="", how_to_take_text	="", drug_yn="";
		StringBuilder instructions = new StringBuilder();
		boolean bResultAvailable = false,remarks_flag = false;
		ArrayList edit_recs	= new ArrayList();
		try {
			connection	= getConnection() ;
		  	//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_DTL_TMP_SELECT")) ;  // commented for ML-BRU-SCF-1637 [IN057986] 
		    if(dispNos==null || dispNos.equals("") ) // if else condition added for ML-BRU-SCF-1635 [IN:056404]
		        pstmt		= connection.prepareStatement("SELECT lbl.PRES_DRUG_CODE, lbl.DISP_DRUG_CODE, lbl.disp_qty, lbl.DISP_UOM_CODE, lbl.dosage_dtl, lbl.no_of_copies, lbl.instruction, (select drug_yn from ph_drug where drug_code = DISP.DISP_DRUG_CODE) drug_yn FROM ph_disp_label lbl, ph_disp_dtl_tmp disp WHERE lbl.facility_id = DISP.FACILITY_ID AND lbl.disp_no = DISP.DISP_TMP_NO AND lbl.srl_no = disp.DTL_SERIAL_NUM AND DISP.ORDER_ID=? and DISP.ORDER_LINE_NO=? and disp.DISP_DRUG_CODE=? and lbl.language_id = ?"); // Added for ML-BRU-SCF-1637 [IN057986]
			else
	            pstmt		= connection.prepareStatement("SELECT lbl.PRES_DRUG_CODE, lbl.DISP_DRUG_CODE, lbl.disp_qty, lbl.DISP_UOM_CODE, lbl.dosage_dtl, lbl.no_of_copies, lbl.instruction, (select drug_yn from ph_drug where drug_code = DISP.DISP_DRUG_CODE) drug_yn FROM ph_disp_label lbl, ph_disp_dtl_tmp disp WHERE lbl.facility_id = DISP.FACILITY_ID AND lbl.disp_no = DISP.DISP_TMP_NO AND lbl.srl_no = disp.DTL_SERIAL_NUM AND DISP.ORDER_ID=? and DISP.ORDER_LINE_NO=? and disp.DISP_DRUG_CODE=? and lbl.language_id = ? and DISP.DISP_TMP_NO in ("+dispNos +")"); // Added for ML-BRU-SCF-1637 [IN057986]
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			pstmt.setString(3,drug_code);
			pstmt.setString(4,labelLangId);
		    // pstmt.setString(5,dispNos);//added for ML-BRU-SCF-1521.1 [IN:055331]  // commented for ML-BRU-SCF-1637 [IN057986]
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				bResultAvailable = true;
			}
			else if(disp_stage.equals("D") || disp_stage.equals("AS")){// if(disp_stage.equals("D")) Added for ML-BRU-SCF-1521[IN:053157] and disp_stage.equals("AS") added for Ml-BRU-SCF-1944
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(dispNos==null || dispNos.equals("") ) // if else condition added for ML-BRU-SCF-1635 [IN:056404]
				   pstmt		= connection.prepareStatement("SELECT lbl.PRES_DRUG_CODE, lbl.DISP_DRUG_CODE, lbl.disp_qty, lbl.DISP_UOM_CODE, lbl.dosage_dtl, lbl.no_of_copies, lbl.instruction, (select drug_yn from ph_drug where drug_code = DISP.DISP_DRUG_CODE) drug_yn FROM ph_disp_label lbl, ph_disp_dtl disp WHERE lbl.facility_id = DISP.FACILITY_ID AND lbl.disp_no = DISP.DISP_NO AND lbl.srl_no = disp.SRL_NO AND DISP.ORDER_ID=? and DISP.ORDER_LINE_NO=? and disp.DISP_DRUG_CODE=? and lbl.language_id = ?") ; 
				else
                   pstmt		= connection.prepareStatement("SELECT lbl.PRES_DRUG_CODE, lbl.DISP_DRUG_CODE, lbl.disp_qty, lbl.DISP_UOM_CODE, lbl.dosage_dtl, lbl.no_of_copies, lbl.instruction, (select drug_yn from ph_drug where drug_code = DISP.DISP_DRUG_CODE) drug_yn FROM ph_disp_label lbl, ph_disp_dtl disp WHERE lbl.facility_id = DISP.FACILITY_ID AND lbl.disp_no = DISP.DISP_NO AND lbl.srl_no = disp.SRL_NO AND DISP.ORDER_ID=? and DISP.ORDER_LINE_NO=? and disp.DISP_DRUG_CODE=? and lbl.language_id = ? and DISP.DISP_NO in ("+dispNos +")") ;
				   //pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_DTL_SELECT")) ; // commented for ML-BRU-SCF-1635 [IN:056404]
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_num);
				pstmt.setString(3,drug_code);  
				pstmt.setString(4,labelLangId);
		  		//	pstmt.setString(5,dispNos); //added for ML-BRU-SCF-1521.1 [IN:055331]    // commented for ML-BRU-SCF-1635 [IN:056404]
				resultSet	= pstmt.executeQuery() ;
				if(resultSet.next()){
					bResultAvailable = true;
				}
			}			
			if(bResultAvailable){
				edit_recs.add(checkForNull(resultSet.getString("PRES_DRUG_CODE")));//0
				edit_recs.add(checkForNull(resultSet.getString("DISP_DRUG_CODE")));
				edit_recs.add(checkForNull(resultSet.getString("DISP_QTY")));
				edit_recs.add(checkForNull(resultSet.getString("DISP_UOM_CODE")));
				edit_recs.add(checkForNull(resultSet.getString("DOSAGE_DTL")));
				edit_recs.add(checkForNull(resultSet.getString("NO_OF_COPIES"))); //5
				edit_recs.add(checkForNull(resultSet.getString("INSTRUCTION")));
				edit_recs.add(checkForNull(resultSet.getString("DRUG_YN"))); //7 added for ML-BRU-SCF-1524 [IN:053164]
			}
			else{
				remarks_flag = true;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				/*if(!labelLangId.equals("en"))
					pstmt		= connection.prepareStatement(" SELECT  HOW_TO_TAKE_TEXT_LOCAL HOW_TO_TAKE_TEXT, (SELECT  LABEL_TEXT_1  FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE  LABEL_TEXT_ID = A.CAUTION_LABEL_TEXT_ID_1  AND  LABEL_TEXT_TYPE ='C' AND LANGUAGE_ID = (SELECT LANGUAGE_ID FROM SM_LANGUAGE WHERE EFF_STATUS = 'E' AND PRIMARY_LANG_YN = 'N' AND ROWNUM < 2)) LABEL_CAU_INSTRN, (SELECT  LABEL_TEXT_1  FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE  LABEL_TEXT_ID= A.SPL_INSTR_LABEL_TEXT_ID AND  LABEL_TEXT_TYPE ='S' AND LANGUAGE_ID = ( SELECT LANGUAGE_ID FROM SM_LANGUAGE WHERE EFF_STATUS = 'E' AND PRIMARY_LANG_YN = 'N' AND ROWNUM < 2) ) LABEL_SPL_INSTRN FROM PH_DRUG A WHERE DRUG_CODE = ? ");				
				else*/
					pstmt		= connection.prepareStatement(" SELECT HOW_TO_TAKE_TEXT, (SELECT  LABEL_TEXT_1  FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE  LABEL_TEXT_ID = A.CAUTION_LABEL_TEXT_ID_1  AND LABEL_TEXT_TYPE ='C' AND LANGUAGE_ID =?) LABEL_CAU_INSTRN, (SELECT  LABEL_TEXT_1  FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE  LABEL_TEXT_ID= A.SPL_INSTR_LABEL_TEXT_ID AND  LABEL_TEXT_TYPE ='S' AND LANGUAGE_ID =? ) LABEL_SPL_INSTRN, drug_yn FROM ph_drug_lang_vw A WHERE DRUG_CODE = ? and language_id = ? ");	//	drug_yn added for ML-BRU-SCF-1524 [IN:053164]		
				pstmt.setString(1,labelLangId); 
				pstmt.setString(2,labelLangId); 
				pstmt.setString(3,drug_code); 
				pstmt.setString(4,labelLangId); 
				resultSet	= pstmt.executeQuery() ;
				instructions.delete(0, instructions.length());
				if(resultSet!=null && resultSet.next()){
					how_to_take_text	=checkForNull(resultSet.getString("HOW_TO_TAKE_TEXT"));
					cau_instructions	=checkForNull(resultSet.getString("LABEL_CAU_INSTRN"));
					spl_instructions	=checkForNull(resultSet.getString("LABEL_SPL_INSTRN"));
					drug_yn	=checkForNull(resultSet.getString("DRUG_YN")); // added for ML-BRU-SCF-1524 [IN:053164]	
					if(!how_to_take_text.equals(""))
						instructions.append(how_to_take_text);
					if(!cau_instructions.equals("")){
						if(instructions.length()>0)
							instructions.append(" "+cau_instructions);
						else
							instructions.append(cau_instructions);
					}
					if(!spl_instructions.equals("")){
						if(instructions.length()>0)
							instructions.append(" "+spl_instructions);
						else
							instructions.append(spl_instructions);
					}
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				pstmt		= connection.prepareStatement( "select ph_dosage_details(?,?,?,?,?,?) dosage_dtl from dual") ; 
				pstmt.setString(1,login_facility_id);  
				pstmt.setString(2,labelLangId);
				pstmt.setString(3,pres_drug_code);  
				pstmt.setString(4,drug_code);
				pstmt.setString(5,order_id);
				pstmt.setString(6,order_line_num);
				resultSet	= pstmt.executeQuery() ;
				edit_recs.add(pres_drug_code); //presDrug
				edit_recs.add(drug_code); //dispDrug
				if(resultSet!=null && resultSet.next()){
					pstmt		= connection.prepareStatement("select disp_qty,disp_uom_code from ph_disp_dtl_tmp where order_id =? and order_line_no =?") ; 
					pstmt.setString(1,order_id);
					pstmt.setString(2,order_line_num);
					rs = pstmt.executeQuery();
					if(rs.next()){// if else added for EMR #2913
						edit_recs.add(checkForNull(rs.getString("disp_qty")));
						edit_recs.add(checkForNull(rs.getString("disp_uom_code")));
					}
					else{
						edit_recs.add(""); //dispQty
						edit_recs.add(""); //dispUOM
					}
					edit_recs.add(checkForNull(resultSet.getString("DOSAGE_DTL")));
				}
				else{
					edit_recs.add(""); //dispQty
					edit_recs.add(""); //dispUOM
					edit_recs.add(""); //dosageDtl
				}
				edit_recs.add("");//noOfCopies
				if(instructions.length()>270)
					edit_recs.add((instructions.toString()).substring(0,270));
				else
					edit_recs.add(instructions.toString());
				edit_recs.add(drug_yn); //7 added for ML-BRU-SCF-1524 [IN:053164]
			}
			this.setEditableLabel( edit_recs, order_id+"_"+drug_code+"_"+order_line_num+"_"+labelLangId);
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
	}

	public String getDefaultBmsCollDispLoc(String disp_locn_code) throws Exception{ //Added for HSA-CRF-0113 [IN:048166] 
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		String nextBmsDispLocn = "";
		try{
			connection = getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_LOCN_BMS_DEFAULT_SELECT"));
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2, disp_locn_code);
			
			
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null){
				if(resultSet.next()){
					nextBmsDispLocn = resultSet.getString("DEFAULT_BMS_LOCATION");
				}
				setDefaultBmsDispLoc(nextBmsDispLocn);
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
		return nextBmsDispLocn;
	}
	public String getMednReturn(String disp_locn_code){ //added for MMS-QH-CRF-0201 [IN:052255]
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	medn_rtn		=	"" ;

		try{
			String sql="select accept_medn_rtn_yn from ph_disp_rights where facility_id=? and appl_user_id=? and disp_locn_code = ?";
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(sql) ;
			
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,login_by_id);
			pstmt.setString(3,disp_locn_code);
			
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ){
					medn_rtn = checkForNull(resultSet.getString("accept_medn_rtn_yn"));
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
		return medn_rtn;	
	}
	
	public String getAllowAmendDtlYN(String order_id, String order_line_no) {   // Start - code added for JD-CRF-0198 [IN058599]
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String allow_amend_yn= "";
		String line_status		=	"";
		
		try {   
			    connection	= getConnection() ;
				pstmt		=	connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT57A"));
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_no);
				resultSet	= pstmt.executeQuery() ;
				
				if (resultSet!=null && resultSet.next()){
					line_status	=	checkForNull(resultSet.getString("ORDER_LINE_STATUS"));	
					if(!line_status.equals("OS") && !line_status.equals("VF") && !line_status.equals("RG") && !line_status.equals("UC")) { 
						allow_amend_yn	=	"N";
					}
					else {
						allow_amend_yn	=	"Y";
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
				es.printStackTrace();
			}
		}
		return allow_amend_yn;

	}   // End - code added for JD-CRF-0198 [IN058599]
//added for GHL-CRF-453 - start
	public void updatePrintValue(ArrayList alOrderIds){

		try{
			HashMap tabData	= new HashMap();
			HashMap sqlMap  = new HashMap();

			tabData.put( "properties", getProperties() );
			tabData.put("alOrderIds",alOrderIds);
			tabData.put("PRINT_YN","true");
			tabData.put( "facility_id", login_facility_id.trim() );
			tabData.put( "login_at_ws_no", login_at_ws_no.trim());
			tabData.put( "login_by_id", login_by_id.trim());
			System.err.println("DispMedicationAllStages.java=====updatePrintValue===9119====alOrderIds=====>"+alOrderIds);	
			sqlMap.put("SQL_ORDER_LINE_PH_PRINT_YN_UPDATE","UPDATE OR_ORDER_LINE_PH SET PRINT_VALUE=?, MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=? WHERE ORDER_ID=? AND ORDER_LINE_NUM =?");

           Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_DISP_MEDICATION" ),DispMedicationHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
			(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//added for GHL-CRF-453 - end
	// Added for ML-MMOH-CRF-0468 start
	public HashMap getDB_DrugDetailTpnStandard(String order_id,String order_line_no,String drug_code) throws Exception {
		
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		//ResultSet resultSet_1	= null; //Commented for common-icn-0048

		//String disp_drug_code		=	""; //Commented for common-icn-0048
		
		String batch_id				=	"";
		//String expiry_date			=	""; //Commented for common-icn-0048
		String disp_qty				=	"";
		String disp_qty_uom			=	"";
		String trade_id				=	"";
		HashMap	drug_detail			=	new HashMap();
		//HashMap alt_detail			=	new HashMap(); //Commented for common-icn-0048
		ArrayList multi_drug_detail	=	new ArrayList();
		ArrayList gen_drug_detail	=	new ArrayList();
		ArrayList unique_drugs		=	new ArrayList();
		try {
            connection	= getConnection() ;
					
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT45")) ;
			//pstmt		= connection.prepareStatement("SELECT a.DISP_ITEM_CODE,a.batch_id1,TO_CHAR (a.EXPIRY_DATE1, 'DD/MM/YYYY') expiry_date,a.BATCH1_QTY,disp_qty_uom, a.order_id, a.order_line_num, b.bin_location_code,b.trade_id, c.gen_uom_code,J.SHORT_NAME,ph_get_uom_display (?, h.order_uom, ?) pres_qty_uom_disp FROM ph_tpn_worksheet_dtl a, st_item_batch b, mm_item c,am_trade_name_lang_vw j,or_order_line_ph g,or_order_line h WHERE a.disp_locn = b.store_code AND a.disp_item_code = b.item_code AND b.item_code = c.item_code AND a.batch_id1 = b.batch_id AND a.expiry_date1 = b.expiry_date_or_receipt_date AND a.bin_location_code1 = b.bin_location_code AND a.order_id = ? AND  a.order_line_num = ? AND g.trade_code = j.trade_id and a.order_id=g.order_id and a.order_id=h.order_id and a.ORDER_LINE_NUM=g.ORDER_LINE_NUM and a.ORDER_LINE_NUM=h.ORDER_LINE_NUM and g.order_id=h.order_id and g.ORDER_LINE_NUM=g.ORDER_LINE_NUM and j.language_id= ? ORDER BY order_id, order_line_num") ; 
            pstmt		= connection.prepareStatement("SELECT a.DISP_ITEM_CODE, a.BATCH_ID1, TO_CHAR (a.EXPIRY_DATE1, 'DD/MM/YYYY') expiry_date, BATCH1_QTY,disp_qty_uom, order_id, order_line_num, b.bin_location_code,b.trade_id, c.gen_uom_code FROM PH_TPN_WORKSHEET_DTL a, st_item_batch b, mm_item c WHERE a.DISP_LOCN = b.store_code AND a.DISP_ITEM_CODE = b.item_code AND b.item_code = c.item_code AND a.BATCH_ID1 = b.batch_id AND a.EXPIRY_DATE1 = b.expiry_date_or_receipt_date AND a.BIN_LOCATION_CODE1 = b.bin_location_code AND order_id = ? AND order_line_num = ? ORDER BY order_id, order_line_num") ;
            pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
            resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
	             drug_code			=	checkForNull(resultSet.getString("DISP_ITEM_CODE"));
					 trade_id			=	checkForNull(resultSet.getString("TRADE_ID"));
					 batch_id			=	checkForNull(resultSet.getString("BATCH_ID1"));
					 disp_qty			=	checkForNull(resultSet.getString("BATCH1_QTY"));
					 disp_qty_uom		=	checkForNull(resultSet.getString("DISP_QTY_UOM"));
				if(multi_drug_detail.size() > 1) {			
					if(!unique_drugs.contains(drug_code)) {
						gen_drug_detail	=	new ArrayList();
						unique_drugs.add(drug_code);

						gen_drug_detail.add(trade_id);	//0
						gen_drug_detail.add(batch_id);	//1
						gen_drug_detail.add(disp_qty);	//2
						gen_drug_detail.add(disp_qty_uom);	//3
						
						//alt_detail.put(drug_code,gen_drug_detail);
					}
					else {
						gen_drug_detail.add(trade_id);	//0
						gen_drug_detail.add(batch_id);	//1
						gen_drug_detail.add(disp_qty);	//2
						gen_drug_detail.add(disp_qty_uom);	//3
						//alt_detail.put(drug_code,gen_drug_detail);
					}
				} 
				else {
					gen_drug_detail.add(trade_id);	//0
					gen_drug_detail.add(batch_id);	//1
					gen_drug_detail.add(disp_qty);	//2
					gen_drug_detail.add(disp_qty_uom);	//3
				}
			}
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			drug_detail.put(order_id+order_line_no+drug_code,gen_drug_detail);
			

		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}

		return drug_detail;
	}
	// Added for ML-MMOH-CRF-0468 end
	public ArrayList getDispNoAndSrlNo(String drug_code,String order_id,String order_line_no, String dispStage){ // Added for TTMWM-SCF-0184 -Start
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		ArrayList dispNoAndSrlNos = new ArrayList();
		String sql = "";
		if(dispStage.equalsIgnoreCase("D")){
			sql   = "select disp_no, srl_no from (SELECT disp_no, srl_no FROM ph_disp_dtl WHERE order_id = ? AND order_line_no = ? AND disp_drug_code = ? AND facility_id = ? order by disp_no desc) where rownum =1";
		}
		else
		{
			sql   = "SELECT disp_tmp_no disp_no, dtl_serial_num srl_no FROM ph_disp_dtl_tmp WHERE order_id = ? AND order_line_no = ? AND disp_drug_code = ? and facility_id=?";
		}
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, order_id);
			pstm.setString(2, order_line_no);
			pstm.setString(3, drug_code);
			pstm.setString(4, login_facility_id);
			resultSet = pstm.executeQuery();
			
			if(resultSet!=null && resultSet.next()){
				dispNoAndSrlNos.add(resultSet.getString("disp_no")==null?"":resultSet.getString("disp_no"));
				dispNoAndSrlNos.add(resultSet.getString("srl_no")==null?"":resultSet.getString("srl_no"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet(resultSet);
				closeStatement(pstm);
				closeConnection(conn);
			}
			catch (Exception es) {
				es.printStackTrace();
			}
		}
		return dispNoAndSrlNos;
		
	} // Added for TTMWM-SCF-0184 -End
	
	public void setDispUom(String patient_id,String order_id,String order_line_no,String qty_uom){ // Added for ML-BRU-SCF-1799 - Start
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_det	=	(HashMap)order.get(order_line_no);
						drug_det.put("stock_disp_uom",""+qty_uom);
				}
        }
	   }
	} // Added for ML-BRU-SCF-1799 - End
	
	public void setAlternateDrugQtyForCharge(String patient_id,String order_id,String order_line_no, String alt_drug_code,String alt_qty) { // Added for ML-BRU-SCF-1803 - Start
		
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_record	=	(HashMap)order.get(order_line_no);
					if(drug_record.containsKey("alt_drug_det"))	{
						HashMap drug_det	=	(HashMap)drug_record.get("alt_drug_det");
						/*if(drug_record.containsKey("alt_drug_det"))	{
							HashMap drug_det	=	(HashMap)drug_record.get("alt_drug_det");
							drug_det.put(alt_drug_code+order_id+order_line_no,alt_qty);
						}*/ //Modified This code with below conditions
						
						if(drug_record.containsKey("alt_drug_det"))	{ //Added for COMMON-ICN-0170 start
							double temp_alt_qty = 0;
							if(drug_det.containsKey(alt_drug_code+order_id+order_line_no)){
								temp_alt_qty = Double.parseDouble(alt_qty) + Double.parseDouble((String) drug_det.get(alt_drug_code+order_id+order_line_no));
								drug_det.put(alt_drug_code+order_id+order_line_no,Double.toString(temp_alt_qty));
							}
							else{
								drug_det.put(alt_drug_code+order_id+order_line_no,alt_qty);
							}//Added for COMMON-ICN-0170 end
						}
					}
				}
			}
		}
	}
	
public String getAlternateDrugQtyForCharge(String patient_id,String order_id,String order_line_no, String alt_drug_code) {
		String alt_qty = "0";
		if(patient_det.containsKey(patient_id))	{
			HashMap prescription	=	(HashMap)patient_det.get(patient_id);
			if(prescription.containsKey(order_id))	{
				HashMap order	=	(HashMap)prescription.get(order_id);
				if(order.containsKey(order_line_no))	{
					HashMap drug_record	=	(HashMap)order.get(order_line_no);
					if(drug_record.containsKey("alt_drug_det"))	{
						HashMap drug_det	=	(HashMap)drug_record.get("alt_drug_det");
					 if(drug_det.containsKey(alt_drug_code+order_id+order_line_no))
						alt_qty = (String) drug_det.get(alt_drug_code+order_id+order_line_no)==null?"0":(String) drug_det.get(alt_drug_code+order_id+order_line_no);
					}
				}
			}
		}
		return alt_qty;
	} // Added for ML-BRU-SCF-1803 - End
  public ArrayList getInstructionsSTD(String drug_code,String order_id,String order_line_no){ // //added for ML-MMOH-CRF-1089 - Start
	Connection connection		= null;
    PreparedStatement pstmt		= null;
	PreparedStatement pstmt1	= null;
	PreparedStatement pstmt_int	= null;
    ResultSet resultSet			= null;	
	ArrayList instructions_res 	= new ArrayList();
	ArrayList instructions		= new ArrayList();
	ArrayList	temp            = new ArrayList();
	ArrayList  lang_ids         = new ArrayList();
	String sTemptext = "";
	//boolean siteTpn		= true; //Commented for common-icn-0048
	
	
	try {
        connection	= getConnection() ;
		pstmt		= connection.prepareStatement("SELECT distinct label_cau_instrn1_eng, label_spl_instrn1_eng, label_pat_instrn1_eng,label_cau_instrn1_loc, label_spl_instrn1_loc,label_pat_instrn1_loc FROM PH_TPN_STANDARD_REGIMEN WHERE order_id = ? AND ORDER_LINE_NUM = ? AND TPN_REGIMEN_CODE = ?");  //  C.ORDER_CATALOG_CODE=? AND -removed for ML-SCF-0300 [34012]
		//pstmt.setString(1,drug_code);
		
		pstmt.setString(1,order_id);
		pstmt.setString(2,order_line_no);
		pstmt.setString(3,drug_code);
		//pstmt.setString(5,getLanguageId());
        resultSet	= pstmt.executeQuery() ;
		while (resultSet.next()){
			instructions_res.add(checkForNull((String)resultSet.getString("LABEL_CAU_INSTRN1_ENG")));	
			instructions_res.add(checkForNull((String)resultSet.getString("LABEL_SPL_INSTRN1_ENG")));	
			sTemptext =java.net.URLEncoder.encode(checkForNull((String)resultSet.getString("LABEL_PAT_INSTRN1_ENG")),"UTF-8"); 
			instructions_res.add(sTemptext);
		}
		
		closeStatement(pstmt);
		closeResultSet(resultSet);
		//String tempString ="XX";
		if(instructions_res.size() > 0){	
			//pstmt_int		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDI_EDIT_INT_RESULTS")) ;
			pstmt_int		= connection.prepareStatement("SELECT LABEL_TEXT_1, language_id FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_ID=? /*and rownum<3*/ and ordby < 3 ");
			for(int i=0;i<2;i++){					
				if( (!((((String)instructions_res.get(i))==null) || (((String)instructions_res.get(i)).equals(""))))){
				    resultSet		= null;
					pstmt_int.setString(1,(String)instructions_res.get(i));
					//pstmt_int.setString(2,getLanguageId());
					resultSet	= pstmt_int.executeQuery() ;
					temp			= new ArrayList();
					lang_ids        = new ArrayList();
					while (resultSet.next()){							
						temp.add((String)instructions_res.get(i));	//added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
						sTemptext =java.net.URLEncoder.encode(checkForNull((String)resultSet.getString("LABEL_TEXT_1")),"UTF-8"); 
						temp.add(sTemptext);	
						temp.add((String)resultSet.getString("language_id"));	
						lang_ids.add(resultSet.getString("language_id"));
					}
					instructions.add(temp);
				}
				else{
					temp = new ArrayList();
                    instructions.add(temp);
				}              
				//tempString = (String)instructions_res.get(i);
			}
            closeStatement(pstmt);
		    closeResultSet(resultSet);
			temp = new ArrayList();
			pstmt_int		= connection.prepareStatement("select label_pat_instrn1_eng from PH_TPN_STANDARD_REGIMEN where TPN_REGIMEN_CODE =? ");
			if(lang_ids.size() == 0){	
				lang_ids.add(getLanguageId());
                 pstmt1 =connection.prepareStatement("select language_id  from sm_language where  eff_status='E'  and PRIMARY_LANG_YN ='N' order by seq_no");
                 resultSet	= pstmt1.executeQuery() ;
				 if(resultSet.next()){
					lang_ids.add((String)resultSet.getString("language_id"));
			    }
			}
			for(int i=0;i<lang_ids.size();i++){
				resultSet		= null;
				pstmt_int.setString(1,drug_code);
				//pstmt_int.setString(2,(String)lang_ids.get(i));
				resultSet	= pstmt_int.executeQuery() ;
				while (resultSet.next()){							
					sTemptext =java.net.URLEncoder.encode(checkForNull((String)resultSet.getString("LABEL_PAT_INSTRN1_ENG")),"UTF-8"); 
					temp.add(sTemptext);
					temp.add((String)lang_ids.get(i));
				}
			}
			//temp.add(instructions_res.get(2));
			//temp.add(instructions_res.get(5));
		   instructions.add(temp);
		}
	}
	catch ( Exception e ) {
		e.printStackTrace() ;			
	}
	finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt_int ) ;
			closeStatement( pstmt1 );
			closeConnection( connection ); 
		}
		catch(Exception es){
			es.printStackTrace();
		}
	}
	return instructions;
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
			// For Order Type
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
//added for ghl-crf-0548 start
	public LinkedHashMap getStockAlternateMedicalItem(String store_code,String qty_reqd, String eff_expiry, String generic_id, String drug,String strength_val,String form_code_medical_item) throws Exception {
		Connection connection			=   null;
        PreparedStatement pstmt			=   null;
        ResultSet resultSet				=   null;
        PreparedStatement pstmt1			=   null;
        ResultSet resultSet1				=   null;
		String drug_code				=	"";
		String drug_desc				=	"";
		String strength_value			=	"";
		String strength_uom				=	"";
		String form_code				=	"";
		String form_desc				=	"";
		String item_code				=	"";
		String item_desc				=	"";
		String avail_qty				=	"";
		String prev_drug_code			=	"";
		String external_product_id		=	"";
		String stock_uom				= "";  
		HashMap	drug_detail				=	new HashMap();
		LinkedHashMap alt_drugs				=	new LinkedHashMap(); 
		ArrayList item_detail			=	new ArrayList();
		ArrayList qty_detail			=	new ArrayList();
		String item_tech_code="";
		try {
            connection	= getConnection() ;
            pstmt1	= connection.prepareStatement("select ITEM_TECH_CODE from mm_item_lang_vw where item_code=? AND language_id= ?") ;
            
            pstmt1.setString(1,drug);
            pstmt1.setString(2,getLanguageId());
            
            resultSet1	= pstmt1.executeQuery() ;
            while(resultSet1.next()){
            	item_tech_code				=	resultSet1.getString("ITEM_TECH_CODE");
            }
          //  pstmt		= connection.prepareStatement("SELECT   a.drug_code, a.generic_id, a.drug_desc,ph_get_ext_prod_drug_code (a.drug_code, 'RP') external_product_id,a.strength_value, a.strength_uom, c.short_desc, a.form_code,a.route_code, M.item_code,M.short_desc item_description,ph_ret_stock_avail_status (A.DRUG_CODE,'RPAEPH','8','Y','26/10/2018','N',NULL) available_qty,a.stock_uom FROM ph_drug_lang_vw a,am_uom_lang_vw c,mm_item_lang_vw M WHERE  m.ITEM_TECH_CODE='NIDDLETECH' and A.drug_code =m.item_code AND a.language_id = c.language_id AND a.language_id = 'en' AND a.stock_uom = c.uom_code AND M.eff_status = 'E' AND M.language_id = 'en' ORDER BY TO_NUMBER (NVL (available_qty, 0)) DESC, a.drug_desc");
	        
	     
            pstmt		= connection.prepareStatement ("SELECT   a.drug_code, a.generic_id, a.drug_desc,ph_get_ext_prod_drug_code (a.drug_code, ?) external_product_id,a.strength_value, a.strength_uom, c.short_desc, a.form_code,a.route_code, M.item_code,M.short_desc item_description,ph_ret_stock_avail_status (A.DRUG_CODE,?,?,'Y',?,'N',NULL) available_qty,a.stock_uom FROM ph_drug_lang_vw a,am_uom_lang_vw c,mm_item_lang_vw M WHERE  m.ITEM_TECH_CODE=?and A.drug_code =m.item_code AND a.language_id = c.language_id AND a.language_id = ? AND a.stock_uom = c.uom_code AND M.eff_status = 'E' AND M.language_id = ? and  A.drug_code <> ? ORDER BY TO_NUMBER (NVL (available_qty, 0)) DESC, a.drug_desc");//Removed based on data from site for GHL-ICN-0035 a.generic_id ='MEDICALITEM' AND and a.form_code='*MD*' and a.ROUTE_code='*MD*' 
            
            pstmt.setString(1,login_facility_id);
            pstmt.setString(2,store_code);
			pstmt.setString(3,qty_reqd);
			pstmt.setString(4,eff_expiry);
			pstmt.setString(5,item_tech_code);//item_tech_code
			pstmt.setString(6,getLanguageId());
			pstmt.setString(7,getLanguageId());
			pstmt.setString(8,drug);
			

            resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				drug_code				=	resultSet.getString("DRUG_CODE");
				//if(!drug.equals(drug_code)){
						drug_desc				=	resultSet.getString("DRUG_DESC");
						strength_value			=	"";//checkForNull(resultSet.getString("STRENGTH_VALUE"));
						strength_uom			=	"";checkForNull(resultSet.getString("STRENGTH_UOM"));
						form_code				=	checkForNull(resultSet.getString("FORM_CODE"));
						form_desc				=	"";//checkForNull(resultSet.getString("FORM_DESC"));
						item_code				=	checkForNull(resultSet.getString("ITEM_CODE"));
						item_desc				=	checkForNull(resultSet.getString("ITEM_DESCRIPTION"));
						avail_qty				=	checkForNull(resultSet.getString("AVAILABLE_QTY"));
						external_product_id		=	checkForNull(resultSet.getString("EXTERNAL_PRODUCT_ID"));
						stock_uom				=   checkForNull(resultSet.getString("STOCK_UOM"));  //newly added for ML-BRU-SCF-0179 [IN:032578]
					if(!avail_qty.equals("")) {
						if(!drug_code.equals(prev_drug_code)) {
							drug_detail		=	new HashMap();
							item_detail		=	new ArrayList();
							qty_detail		=	new ArrayList();

							item_detail.add(item_code);
							item_detail.add(item_desc);
							qty_detail.add(avail_qty);

							drug_detail.put("DRUG_CODE",drug_code);
							drug_detail.put("DRUG_DESC",drug_desc);
							drug_detail.put("STRENGTH_VALUE",strength_value);
							drug_detail.put("STRENGTH_UOM",stock_uom);
							drug_detail.put("FORM_CODE",form_code);
							drug_detail.put("FORM_DESC",form_desc);
							drug_detail.put("ITEM",item_detail);
							drug_detail.put("AVAIL_QTY",qty_detail);
							drug_detail.put("EXTERNAL_PRODUCT_ID",external_product_id);
							drug_detail.put("STOCK_UOM",stock_uom);   //newly added for ML-BRU-SCF-0179 [IN:032578]
							prev_drug_code	=	drug_code;
						}
						else {
							item_detail.add(item_code);
							item_detail.add(item_desc);
							qty_detail.add(avail_qty);

							drug_detail.put("AVAIL_QTY",qty_detail);
							drug_detail.put("ITEM",item_detail);
						}
						alt_drugs.put(drug_code,drug_detail);
					}
				//}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return alt_drugs;
	}
	
	public String checkMedicalItemYN(String drug_code) throws Exception {//HashMap changed to LinkedHashMap for MMS-DM-CRF-0009 [IN:054440]
		Connection connection			=   null;
        PreparedStatement pstmt			=   null;
        ResultSet resultSet				=   null;
       String medical_item_yn				=	"";
       String drug_item_yn  ="";
       String medical_applicable  ="";
      // int count=0; //Commented for common-icn-0048
		
		try {
            connection	= getConnection() ;
            pstmt	= connection.prepareStatement("SELECT  MEDICAL_ITEM_YN,DRUG_ITEM_YN FROM ST_ITEM WHERE item_code  = ?") ;
            
            pstmt.setString(1,drug_code);
            resultSet	= pstmt.executeQuery() ;
            while(resultSet.next()){
            	medical_item_yn				=	resultSet.getString("MEDICAL_ITEM_YN");
            	drug_item_yn				=resultSet.getString("DRUG_ITEM_YN");
            }
          
           if(medical_item_yn.equals("Y")&& drug_item_yn.equals("N")){
        	   medical_applicable="Y";
           	}
           else{
        	   medical_applicable="N";
           }
            resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return medical_applicable;
	}
	public int altDrugsAvelibleYN(String drug_code) throws Exception {//HashMap changed to LinkedHashMap for MMS-DM-CRF-0009 [IN:054440]
		Connection connection			=   null;
        PreparedStatement pstmt			=   null;
        ResultSet resultSet				=   null;
       String allow_alternate_yn		=	"N";
       int count=0;       
		
		try {
			connection	= getConnection() ;
            pstmt	= connection.prepareStatement("SELECT ALLOW_ALT_FOR_MEDICAL_ITEM_YN FROM PH_FACILITY_PARAM WHERE FACILITY_ID= ?") ;
            
            pstmt.setString(1,login_facility_id);
            resultSet	= pstmt.executeQuery() ;
			
           //while(resultSet.next()){
			if(resultSet!=null && resultSet.next()){
            	allow_alternate_yn=checkForNull(resultSet.getString("ALLOW_ALT_FOR_MEDICAL_ITEM_YN"));
            }
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;			
			
			if(allow_alternate_yn.equals("Y")){
				pstmt	= connection.prepareStatement("select count(*) count FROM mm_item_lang_vw where  item_tech_code  =( select item_tech_code from mm_item where item_code= ?) AND LANGUAGE_ID=?") ;

				pstmt.setString(1,drug_code);
				pstmt.setString(2,getLanguageId());
				resultSet	= pstmt.executeQuery() ;
				//while(resultSet.next()){
				if(resultSet!=null && resultSet.next()){
					count				=	Integer.parseInt(resultSet.getString("COUNT"));				
				}
			}
        
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return count;
	}
			//added for ghl-crf-0548 end
			
//GHL-CRF-0549 - start
public ArrayList validateForStock(String patient_class){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList stock_params	=	new ArrayList();
		String consider_stock		=	null;
		String allow_without_stock  =	null;
		String disp_charge_dtl_in_drug_lkp_yn = "";
		String disp_price_type_in_drug_lkp = "";
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

	public String getAllowAlternateYN(String order_id, String order_line_no,String iv_prep_yn) {   // code added for GHL-CRF-549 -Start 
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String allow_alternate_yn= "N";

		
		try {   
			if(iv_prep_yn==null)
				iv_prep_yn = "";
			    connection	= getConnection() ;
				if(iv_prep_yn.equals("")){
				pstmt		=	connection.prepareStatement("SELECT ALLOW_ALTERNATE_YN FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_no);
				resultSet	= pstmt.executeQuery() ;
				
				if (resultSet!=null && resultSet.next()){
					allow_alternate_yn	=	checkForNull(resultSet.getString("ALLOW_ALTERNATE_YN"));	
				}
				}else{
					pstmt		=	connection.prepareStatement("SELECT count(*) cunt FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ALLOW_ALTERNATE_YN = 'Y'");
					pstmt.setString(1,order_id);
					resultSet	= pstmt.executeQuery() ;
					if (resultSet!=null && resultSet.next()){
						int cunt = resultSet.getInt("cunt");	

						if(cunt>0)
							allow_alternate_yn = "Y";
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
				es.printStackTrace();
			}
		}
		return allow_alternate_yn;

	}  
	public String getItemTypeApp(String patient_id){
	
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
		String episode_type = "";
		String patient_class = "";
		try {
			connection			= getConnection();
			encounter_id= disp_bean.getEncounterID();
			patient_class = getEncounterPatientClass(encounter_id,patient_id);
			if(patient_class.equals("I"))
				episode_type="I";				
			else if(patient_class.equals("O"))
				episode_type="O";
			else if(patient_class.equals("E"))
				episode_type="E";
			else if(patient_class.equals("D"))
				episode_type="D";
						

				if(encounter_id.length()<=0) 
				{
					episode_id =""; 
					visit_id ="";
				}
				else{
					episode_id =encounter_id.substring(0,(encounter_id.length()-4));  
					visit_id =encounter_id.substring(encounter_id.length()-4);        
				}

				if(episode_type.equals("I") || episode_type.equals("D"))
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
			}

			setBillingGrpId(blg_grp_id);//GHL-CRF-0618
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
	public String getUnitPrice(String patient_class,String item_code,String patient_id,String disp_price_type_in_drug_lkp){
	
		Connection connection	= null;
		CallableStatement cstmt = null ;
		//PreparedStatement pstmt = null; //Commented for common-icn-0048
		//ResultSet resultSet		= null; //Commented for common-icn-0048
		String encounter_id = "";
		String episode_id  ="";
		String visit_id	   ="";
		String episode_type = "";
		String unit_price = "";
		String error_code = "";
		String error_text = "";
		String sys_message_id = "";
		//String decimalFormatString =""  ; //Commented for common-icn-0048


			try{
				connection			= getConnection();
				encounter_id= disp_bean.getEncounterID();
System.err.println("DispMedicationAllStages.java========encounter_id=====9699==>"+encounter_id+"=patient_id==>"+patient_id);
			patient_class = getEncounterPatientClass(encounter_id,patient_id); //added for GHL-CRF-0549
			if(patient_class.equals("I"))
				episode_type="I";				
			else if(patient_class.equals("O"))
				episode_type="O";
			else if(patient_class.equals("E"))
				episode_type="E";
			else if(patient_class.equals("D"))
				episode_type="D";

				if(encounter_id.length()<=0)  
				{
					episode_id ="";
					visit_id ="";
				}
				else{
					episode_id =encounter_id.substring(0,(encounter_id.length()-4));  
					visit_id =encounter_id.substring(encounter_id.length()-4);        
					} 

					if(episode_type.equals("I") || episode_type.equals("D")) //GHL-CRF-0549
					episode_id = encounter_id;


					cstmt=connection.prepareCall("{call  BL_PROC_ITEM_VALIDATIONS_MP.BL_GET_ITEM_DETAILS_MM (?,?,?,?,?,TO_DATE(to_char(sysdate,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); 
						cstmt.setString( 1, login_facility_id);
						cstmt.setString( 2, episode_type); //'O'-Outpatient,'E'-Emergency ,'D'-Daycare,'I'-Inpatient,'R'-External
						cstmt.setString( 3, item_code);
						cstmt.setString( 4, ""); 
						cstmt.setString( 5, ""); 
						cstmt.registerOutParameter(6, Types.VARCHAR );	
						cstmt.registerOutParameter(7, Types.VARCHAR );	
						cstmt.registerOutParameter(8, Types.VARCHAR );	
						cstmt.registerOutParameter(9, Types.VARCHAR ); 
						cstmt.registerOutParameter(10, Types.NUMERIC );
						cstmt.registerOutParameter(11, Types.NUMERIC );
						cstmt.registerOutParameter(12, Types.NUMERIC );
						cstmt.registerOutParameter(13, Types.VARCHAR );
						cstmt.registerOutParameter(14, Types.VARCHAR );
						cstmt.registerOutParameter(15, Types.VARCHAR );
						cstmt.registerOutParameter(16, Types.VARCHAR );
						cstmt.setString( 17, patient_id); 
						cstmt.setString( 18, episode_id);  
						cstmt.setString( 19, visit_id);  
						cstmt.execute() ;


							
							unit_price		= cstmt.getString(11);
							error_code		= cstmt.getString(14);
							sys_message_id	= cstmt.getString(15) == null ? "" : cstmt.getString(15);
							error_text		= cstmt.getString(16);
							closeStatement( cstmt );
System.err.println("DispMedicationAllStages.java=======sys_message_id=======9758===>"+sys_message_id);
								if (sys_message_id.equals("BL9647")){
									sys_message_id = "";
									error_code  =null;
									error_text=null;
								}
System.err.println("DispMedicationAllStages.java====unit_price==9764===>"+unit_price+"==error_code==>"+error_code+"==sys_message_id==>"+sys_message_id+"==error_text==>"+error_text+"==disp_price_type_in_drug_lkp===>"+disp_price_type_in_drug_lkp);
							if(disp_price_type_in_drug_lkp.equals("P") &&(error_code ==null  && error_text==null && sys_message_id.equals("") )){
								 episode_id = ""; 
								 visit_id	= ""; 
								if(encounter_id!= null && !encounter_id.equals("")){
									episode_id = encounter_id;
									if(episode_type.equals("O")||episode_type.equals("E")){
										episode_id = encounter_id.substring(0,(encounter_id.length()-4));
										visit_id = encounter_id.substring(encounter_id.length()-4);
									}
								}

								cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(to_char(sysdate,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
								cstmt.setString( 1, login_facility_id);
								cstmt.setString( 2, "PH");	
								cstmt.setString( 3, "");	
								cstmt.setString( 4, "");	
								cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
								cstmt.setString( 6, patient_id); 
								cstmt.setString( 7, episode_id);  
								cstmt.setString( 8, visit_id);  
								cstmt.setString( 9, ""); 
								cstmt.setString( 10, "");
								cstmt.setString( 11, "SAL"); 
								cstmt.registerOutParameter(12, Types.VARCHAR ); 
								cstmt.registerOutParameter(13, Types.VARCHAR ); 
								cstmt.registerOutParameter(14, Types.VARCHAR ); 
								cstmt.registerOutParameter(15, Types.VARCHAR ); 
								cstmt.setString( 16, item_code);  
								cstmt.registerOutParameter(17, Types.VARCHAR ); 
								cstmt.registerOutParameter(18, Types.VARCHAR ); 
								cstmt.setString( 19, "S");  
								cstmt.registerOutParameter(20, Types.VARCHAR ); 
								cstmt.setString( 21,"1" );  
								cstmt.setString( 22, "");  
								cstmt.registerOutParameter(23, Types.NUMERIC ); 

								cstmt.setString( 24,"" );  
								cstmt.setString( 25, ""); 
								cstmt.setString( 26,"" ); 
								cstmt.setString( 27, ""); 
								cstmt.setString( 28,"" ); 

								cstmt.registerOutParameter(29, Types.NUMERIC ); 
								cstmt.registerOutParameter(30, Types.NUMERIC ); 
								cstmt.registerOutParameter(31, Types.NUMERIC ); 
								cstmt.registerOutParameter(32, Types.NUMERIC ); 
								cstmt.registerOutParameter(33, Types.NUMERIC ); 
								cstmt.registerOutParameter(34, Types.NUMERIC ); 
								cstmt.registerOutParameter(35, Types.NUMERIC ); 
								cstmt.registerOutParameter(36, Types.NUMERIC ); 
								cstmt.registerOutParameter(37, Types.NUMERIC ); 
								cstmt.registerOutParameter(38, Types.NUMERIC ); 
								cstmt.registerOutParameter(39, Types.NUMERIC ); 
								cstmt.registerOutParameter(40, Types.NUMERIC ); 
								cstmt.registerOutParameter(41, Types.NUMERIC ); 
								cstmt.registerOutParameter(42, Types.NUMERIC ); 
								cstmt.registerOutParameter(43, Types.VARCHAR ); 
								cstmt.registerOutParameter(44, Types.NUMERIC ); 
								cstmt.registerOutParameter(45, Types.VARCHAR ); 
								cstmt.registerOutParameter(46, Types.VARCHAR ); 

								cstmt.setString( 47,"" );  
								cstmt.setString( 48, "");  
								
								cstmt.registerOutParameter(49, Types.VARCHAR ); 
								cstmt.registerOutParameter(50, Types.VARCHAR ); 
								cstmt.registerOutParameter(51, Types.VARCHAR ); 
								cstmt.registerOutParameter(52, Types.VARCHAR ); 
								cstmt.setString( 53,"" );  
								cstmt.setString( 54, "");  
								cstmt.registerOutParameter(55, Types.VARCHAR ); 
								cstmt.registerOutParameter(56, Types.VARCHAR ); 
								cstmt.registerOutParameter(57, Types.VARCHAR ); 

								cstmt.execute() ;
								unit_price		= cstmt.getString(39);
								error_code		= cstmt.getString(55);
								sys_message_id	= cstmt.getString(56);
								error_text		= cstmt.getString(57);
//								System.err.println("=22===unit_price===="+unit_price+"==error_code===="+error_code+"==sys_message_id===="+sys_message_id+"==error_text===="+error_text);
							}
						}catch(Exception e){
							error_text = "Error in Proc";
							unit_price = "";
							e.printStackTrace();
						}
						finally{
							try{
								closeStatement( cstmt ) ;
								closeConnection( connection ); 
							}catch(Exception e){
							e.printStackTrace();
							}
						}
						/*if(unit_price!=null && !unit_price.equals("")){
							
							DecimalFormat df = new DecimalFormat(decimalFormatString);
							unit_price = df.format(Double.parseDouble(unit_price));
						}*/
				return unit_price;
		}
	
//GHL-CRF-0549 - end
			
//added for IN070605 start
	public String approvalSetting(String patient_class){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//ArrayList approval_setting	=	new ArrayList(); //Commented for common-icn-0048
		String revw_aprrove_applicable_yn = "";
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT  REVW_APRROVE_APPLICABLE_FOR_IP,REVW_APRROVE_APPLICABLE_FOR_OP FROM ph_facility_param WHERE FACILITY_ID=?");
			pstmt.setString(1,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
				if(patient_class.equals("IP")) {
				revw_aprrove_applicable_yn  = resultSet.getString("REVW_APRROVE_APPLICABLE_FOR_IP")==null?"":resultSet.getString("REVW_APRROVE_APPLICABLE_FOR_IP");
				}
				else{
				revw_aprrove_applicable_yn  = resultSet.getString("REVW_APRROVE_APPLICABLE_FOR_OP")==null?"":resultSet.getString("REVW_APRROVE_APPLICABLE_FOR_OP");
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
		return revw_aprrove_applicable_yn;
	}
	public void updateReviewDetails(String login_user,String calling_func,String order_id,String order_line_no,String allergy_cnt,String alergy_details,String dosage_details,String duplicate_details,String intaraction_details){
		
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		String sql="update or_order_line_ph set alergy_details=?,dosage_details=?,duplicate_details=?,intaraction_details=?,reviewed_by=?,reviewed_date=sysdate where order_id=? and ORDER_LINE_NUM=?";
		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement(sql.trim()) ;
			pstmt.setString(1,alergy_details);
			pstmt.setString(2,dosage_details);
			pstmt.setString(3,duplicate_details);
			pstmt.setString(4,intaraction_details);
			
			pstmt.setString(5,login_by_id.trim());
			pstmt.setString(6,order_id);
			pstmt.setString(7,order_line_no);
			pstmt.executeUpdate(); 
									
		}catch(Exception e){
				e.printStackTrace();
		}
 	    finally {
			try{
				connection.commit();
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();
			}
		}
				
	}
	public ArrayList getReviewDetails(String order_id,String order_line_no){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList ReviewDetails	=	new ArrayList();
		String sql="select alergy_details,dosage_details,duplicate_details,intaraction_details,(SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = reviewed_by) reviewed_by,to_char( reviewed_date, 'DD/MM/YYYY HH24:MI' )reviewed_date FROM OR_ORDER_LINE_PH where order_id = ? AND ORDER_LINE_NUM = ?  ";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(sql.trim());
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			//pstmt.setString(1,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
				
				ReviewDetails.add(resultSet.getString("REVIEWED_BY")==null?"":resultSet.getString("REVIEWED_BY"));
				ReviewDetails.add(resultSet.getString("REVIEWED_DATE")==null?"":resultSet.getString("REVIEWED_DATE"));
				ReviewDetails.add(resultSet.getString("ALERGY_DETAILS")==null?"":resultSet.getString("ALERGY_DETAILS"));
				ReviewDetails.add(resultSet.getString("DOSAGE_DETAILS")==null?"":resultSet.getString("DOSAGE_DETAILS"));
				ReviewDetails.add(resultSet.getString("DUPLICATE_DETAILS")==null?"":resultSet.getString("DUPLICATE_DETAILS"));
				ReviewDetails.add(resultSet.getString("INTARACTION_DETAILS")==null?"":resultSet.getString("INTARACTION_DETAILS"));
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
		return ReviewDetails;
	}
	//added for IN070605 end
//added for MMS-KH-CRF-0029 - start
	public HashMap getDrugLabFoodInteraction(String order_id,String order_line_no){
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;
		HashMap drug_lab_food_interaction = new HashMap();
		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement("SELECT LAB_INTERACT_OVERRIDE_REASON, FOOD_INTERACT_OVERRIDE_REASON,DISEASE_INTER_OVERRIDE_REASON from OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");//DISEASE_INTER_OVERRIDE_REASON Added for MMS-DM-CRF-0229
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					drug_lab_food_interaction.put("LAB_INTERACT_OVERRIDE_REASON",resultSet.getString("LAB_INTERACT_OVERRIDE_REASON"));
					drug_lab_food_interaction.put("FOOD_INTERACT_OVERRIDE_REASON",resultSet.getString("FOOD_INTERACT_OVERRIDE_REASON"));
					drug_lab_food_interaction.put("DISEASE_INTER_OVERRIDE_REASON",resultSet.getString("DISEASE_INTER_OVERRIDE_REASON"));
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
		return drug_lab_food_interaction;
	}
//added for MMS-KH-CRF-0029 - end
//added for AAKH-CRF-0117 - start
public String getApprovalNoApplicableForPatientClass(String patient_class){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//ArrayList approval_setting	=	new ArrayList(); //Commented for common-icn-0048
		String approval_no_applicable_yn = "";
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT  APPROVAL_NO_APPL_IP,APPROVAL_NO_APPL_OP FROM ph_facility_param WHERE FACILITY_ID=?");
			pstmt.setString(1,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
				if(patient_class.equals("IP")) {
				approval_no_applicable_yn  = resultSet.getString("APPROVAL_NO_APPL_IP")==null?"":resultSet.getString("APPROVAL_NO_APPL_IP");
				}
				else{
				approval_no_applicable_yn  = resultSet.getString("APPROVAL_NO_APPL_OP")==null?"":resultSet.getString("APPROVAL_NO_APPL_OP");
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
		return approval_no_applicable_yn;
	}
	//added for AAKH-CRF-0117 - end
	//added for for NMC-JD-SCF-0047 start
	public String getOrderstatus(String order_id,String order_line_num) throws Exception{
		
		Connection connection = null ;
	    PreparedStatement pstmt = null ;
	    ResultSet resultSet = null;
	   // String sql=null; //Commented for common-icn-0048
	    String order_line_status=null;
	   
	    try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement("select ORDER_LINE_STATUS from or_order_line where order_id=?  and ORDER_LINE_NUM=?" ) ;
			
		    pstmt.setString(1,order_id.trim());
			pstmt.setString(2,order_line_num.trim());
			resultSet = pstmt.executeQuery() ;
	        while ( resultSet != null && resultSet.next() ) {
	        	order_line_status = checkForNull(resultSet.getString("ORDER_LINE_STATUS"));

	        }
	    }
		catch ( Exception e ) {

	        e.printStackTrace() ;
	        throw e ;
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
		return order_line_status;
	}//ADDED for NMC-JD-SCF-0047 end
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
		return formulary_code+"~"+blng_grp_type;
	}

	public HashMap getFormularyBillingGrpCodeDtl(String formulary_code,String blng_grp_id){ //blng_grp_id added for GHL-SCF-1527
	
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String item_code="";
		String preference="";
		String item_type_value = "";	
		HashMap preferenceItem = new HashMap();

		try {
			connection			= getConnection();
		
		pstmt = connection.prepareStatement("SELECT item_code, preference,ITEM_TYPE FROM ph_formulary_blng_grp a, ph_formulary_blng_grp_dtl b WHERE a.formulary_code = b.formulary_code and a.blng_grp_type = b.blng_grp_type  AND a.formulary_code = ? AND a.facility_id = ? AND BLNG_GRP_ID=? AND eff_status = 'E'");
		//blng_grp_id added for GHL-SCF-1527
		pstmt.setString(1,formulary_code);
		pstmt.setString(2,login_facility_id);
		pstmt.setString(3,blng_grp_id);
		resultSet = pstmt.executeQuery() ;
							
			while(resultSet!=null && resultSet.next()){					
				
				item_code = resultSet.getString("ITEM_CODE");	
				preference = resultSet.getString("PREFERENCE");	
				item_type_value  = resultSet.getString("ITEM_TYPE");	
				if(item_code==null)
					item_code="";
				if(preference==null)
					preference = "";
				if(!item_code.equals(""))
					preferenceItem.put(item_code,preference);

				if(!item_code.equals("")){
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
	//MMS-KH-CRF-0030
	public String getItemForBarcode(String barcode_id){
	
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String item_code="";
		String avail_qty = "";


		try {
			connection			= getConnection();
		pstmt = connection.prepareStatement("SELECT item_code,NVL (qty_on_hand, 0) - NVL (committed_qty, 0) avail_qty FROM st_item_batch where barcode_id = ?");
		pstmt.setString(1,barcode_id);
		resultSet = pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){					
				item_code = resultSet.getString("ITEM_CODE")==null?"":resultSet.getString("ITEM_CODE");	
				avail_qty = resultSet.getString("avail_qty")==null?"0":resultSet.getString("avail_qty");
				
				item_code = item_code+"~"+avail_qty;
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
		return item_code;
	}

	public ArrayList getBatchDetailsForBarcode(String barcode_id){
	
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;

		String item_code="";
		String batch_id="";
		String expire_Date = "";
		String trade_id = "";
		String bin_location_code = "";
		String avail_qty = "";
		ArrayList altBatchDetails = new ArrayList();

		try {
		//	System.err.println("DispMedicationAllStages.java===getBatchDetailsForBarcode======barcode_id====>"+barcode_id);
			connection			= getConnection();
		pstmt = connection.prepareStatement("SELECT item_code,batch_id,TO_CHAR (expiry_date_or_receipt_date, 'DD/MM/YYYY') expiry_date,TRADE_ID,BIN_LOCATION_CODE, (NVL (qty_on_hand, 0) - NVL (committed_qty, 0)) avail_qty FROM st_item_batch where barcode_id = ?");
		pstmt.setString(1,barcode_id);
		resultSet = pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){					
				item_code = resultSet.getString("ITEM_CODE")==null?"":resultSet.getString("ITEM_CODE");	
				batch_id  = resultSet.getString("batch_id")==null?"":resultSet.getString("batch_id");
				expire_Date = resultSet.getString("expiry_date")==null?"":resultSet.getString("expiry_date");	
				trade_id  = resultSet.getString("TRADE_ID")==null?"":resultSet.getString("TRADE_ID");
				bin_location_code = resultSet.getString("BIN_LOCATION_CODE")==null?"":resultSet.getString("BIN_LOCATION_CODE");
				avail_qty = resultSet.getString("avail_qty")==null?"":resultSet.getString("avail_qty");
				
				altBatchDetails.add(item_code);
				altBatchDetails.add(batch_id);
				altBatchDetails.add(expire_Date);
				altBatchDetails.add(trade_id);
				altBatchDetails.add(bin_location_code);
				altBatchDetails.add(avail_qty);

				
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
		return altBatchDetails;
	}
////MMS-KH-CRF-0030 - end
public void getRefillOrder(String facility_id){
		Connection connection   = null;
        PreparedStatement pstmt   = null;       
		ResultSet resultSet    = null;
		String refill_order = "";
		ArrayList disp_nos = getDispNos();
		String dispstr  ="";
		String temp_disp_no ="";
		try {

			connection = getConnection() ;
			for(int i=0;i<disp_nos.size();i++){
                 temp_disp_no = (String)disp_nos.get(i);
//                System.err.println("dispstrPINSIDE@@@@===="+dispstr+"temp_disp_no==="+temp_disp_no);	
				if(dispstr.equals(""))
					dispstr =temp_disp_no ;
				else
                    dispstr = dispstr+'$'+temp_disp_no;
			}
			
//		System.err.println("dispstr@@@@===="+dispstr);	
				pstmt		= connection.prepareStatement( "SELECT PH_GET_REFILL_ORDER (?,?)REFILL_ORDER FROM DUAL") ;
			
			pstmt.setString(1,facility_id);  
			pstmt.setString(2,dispstr);  
			
			resultSet = pstmt.executeQuery() ;
			//resultSet = pstmt.executeQuery() ;
			if(resultSet !=null && resultSet.next()){
				refill_order= resultSet.getString("REFILL_ORDER")==null?"":resultSet.getString("REFILL_ORDER"); //Modified for MOHE-CRF-0074
			}
//			System.err.println("refill_order@@==="+refill_order);
			setRefillOrderStr(refill_order);
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;  
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
			catch(Exception ex){
				ex.printStackTrace() ;  
			}
		}
		
		
		

		
	}

//SKR-SCF-1647 
		public String getItemUseAfterExpiry(String itemCode){
			
			Connection connection	= null;
			PreparedStatement pstmt = null;
			ResultSet resultSet		= null;
			//String item_code="";  COMMON-ICN-0310
			String use_after_expiry = "";
 
			try {
				connection			= getConnection();
			pstmt = connection.prepareStatement("SELECT USE_AFTER_EXPIRY_YN from ST_ITEM where ITEM_CODE = ?");
			pstmt.setString(1,itemCode);
			resultSet = pstmt.executeQuery() ;
				if(resultSet!=null && resultSet.next()){					
					use_after_expiry = resultSet.getString("USE_AFTER_EXPIRY_YN")==null?"0":resultSet.getString("USE_AFTER_EXPIRY_YN");
					System.out.println("use_after_expiry: "+use_after_expiry);
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
			return use_after_expiry;
		}
//added for aakh-crf-0140 start
public String getAbueRemarks(String order_id,String order_line_no){
	Connection connection			= null ;
	PreparedStatement pstmt			= null ;
	ResultSet resultSet				= null ;
	String abuse_remarks	= "";
	try{
		connection = getConnection() ;
		pstmt			= connection.prepareStatement("SELECT ABUSE_DRUG_OVERRIDE_REASON FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?") ;
		pstmt.setString(1,order_id);
		pstmt.setString(2,order_line_no);
		resultSet		= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next()){				
			abuse_remarks= checkForNull(resultSet.getString("ABUSE_DRUG_OVERRIDE_REASON"));
		}
	}
	catch ( Exception e ) {
		System.err.println("===order_id====>"+order_id+" ====order_line_no="+order_line_no);
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
	return abuse_remarks;
}
//added for aakh-crf-0140 end
//added for jd-crf-0220
	public String getdrugIntaractions(String orig_order_id,String orig_order_line_no){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String Sql              =   "";
		String drug_indication="";
		try{
			connection	= getConnection() ;

			Sql         = "SELECT DRUG_INDICATION FROM OR_ORDER_LINE_PH  OLPH  WHERE  OLPH.order_id= ? and OLPH.ORDER_LINE_NUM=?";
			pstmt		= connection.prepareStatement( Sql );
			
			pstmt.setString(1,orig_order_id);
			pstmt.setString(2,orig_order_line_no);
			
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				drug_indication=checkForNull(resultSet.getString("DRUG_INDICATION"));
					
					
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
		return drug_indication;	
	}public void setInsuranceStatus(String key,String values){//Addins start for TH-KW-CRF-0012
		insuranceStatus.put(key,values);
	}
  public HashMap getInsuranceStatus(){
		return insuranceStatus;
	}
	public void setIuranceStatus(String patient_id,String episode_id,String visit_id,String patient_class ){
		CallableStatement callableStatement =   null;
		Connection connection				=   null;
		ResultSet resultSet		= null;	
		Array facilityArray						=	null;
		Array moduleArray						=	null;
		Array orderArray						=	null;
		Array orderLineArray					=	null;
		Array statusArray						=	null;
		String order_id                         ="";
		String order_line_no                = "";
		String status                           ="";
		 String insurance_status_desc ="";
		 String [] temp_order;
		 String order ="";
		 try{
		  connection = getConnection();
		  if(patient_class.equals("I") || patient_class.equals("D")){ //added for th-kw-crf-0012
			 visit_id=null;
		  }
		callableStatement	= connection.prepareCall("{ call blinstransactions.get_approval_status_encounter(?,?,?,?,?,?,?,?,?,?,?) }"); 
					 System.err.println("DispMedication All Stages login_facility_id=="+login_facility_id+"patient_id=="+patient_id+"patient_class"+patient_class+"episode_id=="+episode_id+"visit_id=="+visit_id);
					callableStatement.setString(1, login_facility_id);
					callableStatement.setString(2, patient_id);
					callableStatement.setString(3, patient_class);
					callableStatement.setString(4, episode_id);
					callableStatement.setString(5, visit_id);
					callableStatement.registerOutParameter(6, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");  
			        callableStatement.registerOutParameter(7, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			        callableStatement.registerOutParameter(8, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
        			callableStatement.registerOutParameter(9, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
		        	callableStatement.registerOutParameter(10, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1");
					callableStatement.registerOutParameter(11, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
					callableStatement.execute();
					 facilityArray						=	callableStatement.getArray (6); 
		             moduleArray						=	callableStatement.getArray (7); 
		             orderArray						    =	callableStatement.getArray (8); 
		             orderLineArray					    =	callableStatement.getArray (9); 
		             statusArray						=	callableStatement.getArray (10); 
					Object[] facilityValues                 =   (Object[]) facilityArray.getArray(); 
					Object[] moduleValues                   =   (Object[]) moduleArray.getArray(); 
					Object[] orderValues                    =   (Object[]) orderArray.getArray(); 
					Object[] oderLineValues                 =   (Object[]) orderLineArray.getArray(); 
					Object[] statusValues                   =   (Object[]) statusArray.getArray();

				if(facilityValues!=null)
	               {
	            	 for (int i=0; i < facilityValues.length; i++)                 
		              {
						 String module_id = (String)moduleValues[i];
						 System.err.println("module_id@@==="+module_id);
						 insurance_status_desc ="";
						 if(module_id.equals("PH")){
							 order = (String)orderValues[i];
							 System.err.println("order @@==="+order);
							 temp_order  = order.split("-");
							 order_id = temp_order[1];
							 order_line_no = String.valueOf(oderLineValues[i]);
							 status = (String)statusValues[i];
							 System.err.println("order_line_no @@==="+order_line_no+"status@@==="+status);
							
							if(status.equals("P"))
								insurance_status_desc = "Pending";
							else if(status.equals("A"))
								insurance_status_desc = "Approved";
							else if(status.equals("R"))
								insurance_status_desc = "Rejected";
							else if(status.equals("H"))
								insurance_status_desc = "Hold";
							else if(status.equals("C"))
								insurance_status_desc = "Clarification";
							else if(status.equals("S"))
								insurance_status_desc = "Sent to Insurance";
							else if(status.equals("PR"))
								insurance_status_desc = "Partially Rejected";
									 System.err.println("order_id=="+order_id+"order_line_no=="+order_line_no+"insurance_status_desc==="+insurance_status_desc);
							 setInsuranceStatus(order_id+order_line_no,insurance_status_desc);

						 }
					  }
				   }
					
					}
	  catch (Exception e) {
		e.printStackTrace();
	  }
	  finally{
		  try{				
				closeResultSet( resultSet ) ;
				closeConnection( connection );				
			}
			catch(Exception e){
				e.printStackTrace();
			}		   
	  }
	}//Adding end for TH-KW-CRF-0012

public String getBinLocation(String patient_id,String encounter_id,String disp_locn_code){
	
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String str_locn="";


		try {
			connection			= getConnection();

		String sql_str				= "SELECT B.STORAGE_NAME STORAGE_NAME FROM PH_DISP_BIN_LOCATION A, PH_STORAGE_BIN_LOCN B WHERE A.DISP_LOCN_CODE = B.DISP_LOCN_CODE AND A.FACILITY_ID = B.FACILITY_ID AND A.DISP_LOCN_CODE =B.DISP_LOCN_CODE AND A.STORAGE_BIN_CODE =B.STORAGE_BIN_CODE AND A.DISP_LOCN_CODE = ?  AND A.FACILITY_ID = ? AND A.PATIENT_ID=? AND A.ENCOUNTER_ID =? AND B.EFF_STATUS = 'E'";
		pstmt = connection.prepareStatement(sql_str);
		pstmt.setString(1,disp_locn_code);
		pstmt.setString(2,login_facility_id);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,encounter_id);
		resultSet = pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){					
				str_locn = resultSet.getString("STORAGE_NAME")==null?"":resultSet.getString("STORAGE_NAME");	
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
		return str_locn;
	}
//added for //added for skr-scf-1720
	public void InsertPrintCountFill(String disp_no,String disp_srl_no,String noOfPrints){
		System.out.println("SispmedicationAllstagesbean InsertPrintCountFill");
		System.out.println("SispmedicationAllstagesbean disp_no"+disp_no);
		System.out.println("SispmedicationAllstagesbean disp_srl_no"+disp_srl_no);
		System.out.println("SispmedicationAllstagesbean disp_srl_no"+noOfPrints);
		
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		int resultSet		=	0 ;        
		String Sql              =   "";
		
		try{
			connection	= getConnection() ;

			Sql         = "update ph_disp_dtl_tmp  set NOOFLABELS=? where DISP_TMP_NO=? and DTL_SERIAL_NUM=?  and FACILITY_ID=?";
			pstmt		= connection.prepareStatement( Sql );
			pstmt.setString(1,noOfPrints);
			pstmt.setString(2,disp_no);
			pstmt.setString(3,disp_srl_no);
			pstmt.setString(4,login_facility_id);
			
			resultSet	= pstmt.executeUpdate();
			System.out.println("SispmedicationAllstagesbean resultSet"+resultSet);
				
			for (int i=0;i<resultSet;i++ ){
				if(resultSet<0  && resultSet != -2 ){
					pstmt.cancel();
					connection.rollback();
				}		
			}
						
		}
		catch(Exception e){
			e.printStackTrace();
		}
	    finally {
			try{
				connection.commit();
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();			
			}
		}
	}
	public void InsertPrintCountDeliver(String disp_no,String disp_srl_no,String noOfPrints){
		System.out.println("SispmedicationAllstagesbean InsertPrintCountDeliver");
		System.out.println("SispmedicationAllstagesbean disp_no"+disp_no);
		System.out.println("SispmedicationAllstagesbean disp_srl_no"+disp_srl_no);
		System.out.println("SispmedicationAllstagesbean disp_srl_no"+noOfPrints);
		
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		int resultSet		=	0 ;        
		String Sql              =   "";
	
		try{
			connection	= getConnection() ;

			Sql         = "update ph_disp_dtl set NOOFLABELS=?  where DISP_NO=? and SRL_NO=? and FACILITY_ID=?";
			pstmt		= connection.prepareStatement( Sql );
			pstmt.setString(1,noOfPrints);
			pstmt.setString(2,disp_no);
			pstmt.setString(3,disp_srl_no);
			pstmt.setString(4,login_facility_id);
			
			resultSet	= pstmt.executeUpdate();

			System.out.println("SispmedicationAllstagesbean resultSet"+resultSet);	
			for (int i=0;i<resultSet;i++ ){
				if(resultSet<0  && resultSet != -2 ){
					pstmt.cancel();
					connection.rollback();
				}		
			}
						
		}
		catch(Exception e){
			e.printStackTrace();
		}
	    finally {
			try{
				connection.commit();
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();			
			}
		}
	
	}

	public String getfillPrints(String disp_no,String disp_srl_no,String facility_id){ 
		System.out.println("SispmedicationAllstagesbean getfillPrints");
		System.out.println("SispmedicationAllstagesbean disp_no"+disp_no);
		System.out.println("SispmedicationAllstagesbean disp_srl_no"+disp_srl_no);
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;  
		String Sql              =   "";
		String NOOFLABELS="";
		try{
			connection	= getConnection() ;

			Sql         = "SELECT NOOFLABELS FROM ph_disp_dtl_tmp   where DISP_TMP_NO=? and DTL_SERIAL_NUM=? and FACILITY_ID=? UNION SELECT NOOFLABELS FROM ph_disp_dtl   where DISP_NO=? and SRL_NO=? and FACILITY_ID=? ";
			pstmt		= connection.prepareStatement( Sql );
			
			pstmt.setString(1,disp_no);
			pstmt.setString(2,disp_srl_no);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,disp_no);
			
			pstmt.setString(5,disp_srl_no);
			pstmt.setString(6,facility_id);
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				NOOFLABELS=checkForNull(resultSet.getString("NOOFLABELS"));
					
					
			}			
			System.out.println("SispmedicationAllstagesbean NOOFLABELS"+NOOFLABELS);
			
		
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
		return NOOFLABELS;	
	}
	//added for skr-scf-1720 end


	}  // //added for ML-MMOH-CRF-1089 - End