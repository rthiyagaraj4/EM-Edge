/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*	Module/Function : Direct Dispensing (Transaction)*/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
29/08/2019      IN:070451           B Haribabu  29/08/2019      Manickam                 ML-MMOH-CRF-1408
06/12/2019      IN:070451           Manickavasagam                         		 MMS-KH-CRF-0029
18/02/2020		IN071362                Manickavasagam J                       AAKH-CRF-0117
06/07/2020      IN:072715          Haribabu     06/07/2020     Manickavasagam     MMS-DM-CRF-0165
20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
03/02/2021      TFS-13523	     Manickavasagam J         MOHE-CRF-0060
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
import java.text.DecimalFormat;
import java.util.regex.Pattern;//Added for MMS-DM-CRF-0174.5
import java.util.regex.Matcher;//Added for MMS-DM-CRF-0174.5

public class DirectDispensingBean extends PhAdapter implements Serializable,eOR.SceduleFreqeuncyInterface	{
	private	 String order_date				= null ; 
	private	 String OrderRemarks			= null ;
	protected String disp_locations			= "";
	protected String patient_class			= "";
	protected String practioner_id          = "";
	protected String ord_locn				= "";
	protected String enct_dtls				= "";
	protected String encounter_id           = "";
	protected String practioner_name        = "";
	protected String ord_locn_name          = "";
	protected String patient_id             = "";
	protected String displocncode           = "";
	protected String age_group				= "";
   	private int srlNo						= 0;
	protected ArrayList presDetails			= null;
	protected ArrayList copy_prescriptions	= null;
	protected ArrayList exist_orders		= new ArrayList();
	private	  HashMap scheduleFrequency		= null;
	private   HashMap Refill_Detail			= null;
	protected ArrayList orderCode			= null; 
	protected ArrayList diag_text			= null; 
	protected ArrayList groupCode			= null;
	protected HashMap prn_remarks			= null;
	protected HashMap seq_no				= null;
	protected ArrayList groupRecord			= null; 
	protected ArrayList OrderID				= null;
	protected ArrayList orderDetails		= null;
	protected ArrayList presHeader			= null;
	protected ArrayList disp_nos			= null;
	protected String billing_details        = null;
	protected String disp_cash_coll_stage   = "";
	protected String token_series_code      = "";
	protected String token_no				="";
	private String store_desc= "";
	private String store_code= "";
	protected ArrayList cons_item_det		= new ArrayList();
	protected String dflt_dir_disp_locn     ="";
	protected HashMap issueUomQty			= new HashMap();
	private HashMap schdMap					= null;
	protected ArrayList noOfPrints			    = new ArrayList(); //added For RUT-CRF-0067
	//protected HashMap prn_remarks			= null;
	private String authUserId				= "";  //RUT-CRF-0035 [IN029926]
	private String userAuthPINReqYN		= "N";  //RUT-CRF-0035 [IN029926]
	private String excludeADRAllergyAlert_yn = ""; // Added for HSA-SCF-0011 [IN:042444] start
	protected String dispTranSeqNo = "";//added for MMS-QH-CRF-0201 [IN:052255] 
	
    private String retn_disp_med_for_outstanding = "N"; //added for MMS-QH-CRF-0201 [IN:052255] 
	private String barcode_2d_applicable_yn ="N";//Addef for MMS-DM-CRF-0174.5
    protected String barcode_id			= "";  // Added for MMS-DM-CRF-0112 - Start
	public String getBarcode_id() {
		return barcode_id;
	}
	public void setBarcode_id(String barcode_id) {
		this.barcode_id = barcode_id;
	}                                         // Added for MMS-DM-CRF-0112 - End
	public String getRetnDispMedForOutStanding() { //added for MMS-QH-CRF-0201 [IN:052255] 
		return retn_disp_med_for_outstanding;
	}
	public void setRetnDispMedForOutStanding(String retn_disp_med_for_outstanding) {//added for MMS-QH-CRF-0201 [IN:052255] 
		this.retn_disp_med_for_outstanding = retn_disp_med_for_outstanding;
	}

	public String getDispTranSeqNo() {//added for MMS-QH-CRF-0201 [IN:052255] 
		return dispTranSeqNo;
	}

	public void setDispTranSeqNo(String dispTranSeqNo) { //added for MMS-QH-CRF-0201 [IN:052255] 
		this.dispTranSeqNo = dispTranSeqNo;
	}

	public String getExcludeADRAllergyAlert() {
		return excludeADRAllergyAlert_yn;
	}
	public void setExcludeADRAllergyAlert(String excludeADRAllergyAlert_yn) {
		this.excludeADRAllergyAlert_yn = excludeADRAllergyAlert_yn;
	}									// Added for HSA-SCF-0011 [IN:042444] end
	public DirectDispensingBean() {
        try {
			initialize();
			doCommon();
			int i=0;
			while (i < 12) {
				diag_text.add("");
				i++;
			}
            
        }catch(Exception e) {e.printStackTrace();}
	}

	public void initialize() {

		OrderRemarks		= "";
		presDetails			= new ArrayList();
		groupCode			= new ArrayList();
		orderCode			= new ArrayList();
		presHeader			= new ArrayList();
		scheduleFrequency	= new HashMap();
		groupRecord			= new ArrayList();
		//OrderID				= new ArrayList();
		orderDetails		= new ArrayList();
		srlNo				= 0;
		diag_text			= new ArrayList();	
		Refill_Detail		= new HashMap();
		prn_remarks	        = new HashMap();
		disp_cash_coll_stage    = "";  
		token_series_code       = "";  
		token_no				="";  
		//prn_remarks				= new HashMap();
	}	 

	/* Over-ridden Adapter methods start here */
	public void clear() {
		super.clear() ;
		disp_locations					= "";
		patient_class					= "";
		practioner_id					= "";
		ord_locn						= "";
		encounter_id					= "";
		practioner_name					= "";
		ord_locn_name					= "";
		patient_id						= "";
		enct_dtls						= "";
		diag_text						= new ArrayList();
		presHeader.clear();
		presHeader						= null ;
		disp_cash_coll_stage			= "";  
		token_series_code				= "";  
		token_no						="";  
		cons_item_det					=  new ArrayList();
		dflt_dir_disp_locn				="";
		prn_remarks						= new HashMap();
		issueUomQty.clear();//added for AAKH-SCF-0189 [IN:054663]
		barcode_id =""; // Added for MMS-DM-CRF-0112
	}

	// Set methods start from here
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

	public void setStoreCode(String store_code){
		this.store_code = store_code;
	}
	public void setStoreDesc(String store_desc){
		this.store_desc = store_desc;
	}
	public void setDispLocations(String disp_locations){
		this.disp_locations = disp_locations;
	}
	public String getDispLocations(){
		return this.disp_locations;
	}	
	public void setPatientID(String patient_id){
		this.patient_id = patient_id;
	}
	public String getPatientID(){
		return this.patient_id ;
	}
	
	public void setPatientClass(String patient_class){
		this.patient_class = patient_class;
	}

	public String getStoreCode(){
		return this.store_code ;
	}
	public String getStoreDesc(){
		return this.store_desc ;
	}
	public String getPatientClass(){
		return this.patient_class ;
	}
	public void setPractionerID(String practioner_id){
		this.practioner_id = practioner_id;
	}
	public String getPractionerID(){
		return this.practioner_id ;
	}

	public void setdflt_dir_disp_locn(String dflt_dir_disp_locn){
		this.dflt_dir_disp_locn = dflt_dir_disp_locn;
	}
	public String getdflt_dir_disp_locn(){
		return this.dflt_dir_disp_locn ;
	}

	public void setOrdLocn(String ord_locn){
		this.ord_locn = ord_locn;
	}
	public String getOrdLocn(){
		return this.ord_locn ;
	}
	public void setEncounterID(String encounter_id){
		this.encounter_id = encounter_id;
	}
	public String getEncounterID(){
		return this.encounter_id ;
	}	
	public void setPractionerName(String practioner_name){
		this.practioner_name = practioner_name;
	}
	public String getPractionerName(){
		return this.practioner_name ;
	}
	public void setOrdLocnName(String ord_locn_name){
		this.ord_locn_name = ord_locn_name;
	}
	public String getOrdLocnName(){
		return this.ord_locn_name ;
	}
	public void setDispLocnCode(String displocncode){
		this.displocncode = displocncode;
	}
	public String getDispLocnCode(){
		return this.displocncode ;
	}
	public void savePresRemarks(String remarks)	{
	this.OrderRemarks	=remarks;
	}
	//for getting the order remarks from bean
	public String getPresRemarks()	{
		return this.OrderRemarks;
	}
	public void setDiagText( ArrayList diag_text) {
	// this.diag_text	=	new ArrayList();
	this.diag_text = diag_text;
	}

	public ArrayList getDiagText() {
	return this.diag_text;
	}

     public void setBLDetails(String billing_details){
		this.billing_details = billing_details;
	}
	public String getBLDetails(){
		return 	billing_details;
	}
    public void setDispCashCollStage(String disp_cash_coll_stage){
		this.disp_cash_coll_stage = disp_cash_coll_stage;
	}
	public String getDispCashCollStage(){
		return 	disp_cash_coll_stage;
	}
	public void setTokenSeriesCode(String token_series_code){
		this.token_series_code = token_series_code;
	}
	public String getTokenSeriesCode(){
		return 	token_series_code;
	}

	public void setTokenNo(String token_no){
		this.token_no = token_no;
	}
	public String getTokenNo(){
		return 	token_no;
	}

	public void setSrlNo(int srl_no){
		this.srlNo	= srl_no;
	}
	public int getSrlNo(){
		return this.srlNo;
	}
	public void setPrescriptions(ArrayList copy_prescriptions) {
		this.copy_prescriptions	=	copy_prescriptions;
	}

	public ArrayList getPrescriptions() {
		return this.copy_prescriptions;	
	}
	public void setExitingOrders(ArrayList exist_orders) {
		this.exist_orders	=	exist_orders;
	}

	public ArrayList getExitingOrders() {
		return this.exist_orders;
	}
	public void setpresHeader(ArrayList head){
	    this.presHeader	= head;
	}
	public ArrayList getpresHeader(){
		return this.presHeader;
	}
	public ArrayList getOrderDetails() {
	    return orderDetails;
    }
    public ArrayList getOrderID() {
	    return OrderID;
    }
    public void setIssueUomQty(String key,HashMap detail) {
		this.issueUomQty.put(key,detail);
	}
	public HashMap getIssueUomQty(){
		return this.issueUomQty;
	}
    public ArrayList getConsumableDetails() {
		return this.cons_item_det;
	}
	public ArrayList getScheduleFrequencyStr(String code, String row_value){
		Object 	 scheduleFrequencyDatasObj	=  scheduleFrequency.get(code);

		if(scheduleFrequencyDatasObj == null)
			return new ArrayList();
		else
		    return (ArrayList)scheduleFrequencyDatasObj;
	}

	public void setAgeGroup(String age_group) {
		this.age_group	=	age_group;
	}

	public String getAgeGroup() {
		return this.age_group;
	}
	public void setOrderDate(String order_date)	{
		this.order_date	=	order_date;
	}

	public String getOrderDate()	{
		return this.order_date;
	}

	public void setEnctrDtlsReqd(String enct_dtls)	{
        this.enct_dtls	=	enct_dtls;
	}
	public String getEnctrDtlsReqd()	{
		return this.enct_dtls;
	}
	public void setRefillDetail(String srl_no,HashMap Refill_Detail) {
	   this.Refill_Detail.put(srl_no,Refill_Detail);
	}
	//Added for IN:069886 start
	public void removeRefillDetail(String srl_no) {
		if(this.Refill_Detail.containsKey(srl_no)){
			this.Refill_Detail.remove(srl_no);
		}
		}
		//Added for IN:069886 end
	HashMap TempBatchDetails=new HashMap();
	public void setTaperBatchDetails(ArrayList al,String code){
		TempBatchDetails.put(code,al);
	}
	public ArrayList getTaperBatchDetails(String code){
		return (ArrayList)TempBatchDetails.get(code);
	}

	public HashMap getRefillDetail(String srl_no) {
		HashMap ref_det	=	new HashMap();
		if(this.Refill_Detail.containsKey(srl_no))
			ref_det	=	(HashMap)this.Refill_Detail.get(srl_no);
		return ref_det;
    }
	
	public void  setScheduleDates(HashMap schdMap){
		this.schdMap = schdMap;	
	}

	public HashMap getScheduleDates(){
		return this.schdMap;
	}

   public ArrayList groupingOrder(String patient_class) {
		groupRecord=new ArrayList();
		if(presDetails.size()>0){
			for(int i=0; i<presDetails.size() ; i++){
				HashMap drugData=new HashMap();
				drugData=(HashMap) presDetails.get(i);
				String record_gen=(String) drugData.get("RECORD_GEN");
				
				if(!patient_class.equals("IP")){
					if(!groupRecord.contains(record_gen))
						groupRecord.add(record_gen);
				}
				else{
					groupRecord.add(record_gen);
				}
			}
		}
		return groupRecord;
	}

	public ArrayList getpresDetails(){
		return this.presDetails;
	}
	public HashMap getscheduleFrequency(){
		return this.scheduleFrequency;
	}

	public HashMap getsDispNo(){
		return this.seq_no;
	}
	public void setDispNos(ArrayList disp_nos) {
		this.disp_nos	=	disp_nos;
	}

	public ArrayList getDispNos() {
		return this.disp_nos;
	}

	public void setNoOfPrints(ArrayList noOfPrints) {//RUT-CRF-0067 -- start
		this.noOfPrints	=	noOfPrints;
	}
	public ArrayList getNoOfPrints() {
		return this.noOfPrints;
	}//RUT-CRF-0067 -- end

	public void set2DBarcodeApplicable(String barcode_2d_appl){//Adding start for MMS-DM-CRF-0174.5
         this.barcode_2d_applicable_yn=barcode_2d_appl;
	}
    public String get2DBarcodeApplicable(){
	   return this.barcode_2d_applicable_yn;
   }//Adding end for MMS-DM-CRF-0174.5

	public void getclearscheduleFrequency(String code){
		if(scheduleFrequency.containsKey(code)) {
			scheduleFrequency.remove(code);
		}
	}

	public ArrayList ordsortList() {
		if(presDetails.size()>0){
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

	public ArrayList sortList() {
		if(presDetails.size()>0){
			for(int i=0; i<presDetails.size() ; i++){
				HashMap drugData=new HashMap();
				drugData=(HashMap) presDetails.get(i);
				String drugCode=(String) drugData.get("DRUG_CODE");
				if(!groupCode.contains(drugCode))
					groupCode.add(drugCode);
			}
		}
		return groupCode;
	}

	public void addPRNRemarks(String drug_code,HashMap remarks){
		if(prn_remarks.containsKey(drug_code)){
			prn_remarks.remove(drug_code);	
		}
		prn_remarks.put(drug_code,remarks);
	}

	public HashMap getPRNRemarks(String drug_code){
		if((HashMap)prn_remarks.get(drug_code) != null)
			return (HashMap)prn_remarks.get(drug_code);
		else
			return null;
	}
	//Added Below Method for SKR-SCF-0647[Inc:35263]
	public void removePRNRemarks(String drug_code){
		if(prn_remarks.containsKey(drug_code))
				prn_remarks.remove(drug_code);
	}

	public String getDurationType(String duration_type) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String durn_desc			= "";
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT8A")) ;
			pstmt.setString(1,duration_type);
			pstmt.setString(2,getLanguageId());
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				durn_desc	=	(resultSet.getString("DURN_DESC"));
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
		return durn_desc;
	}

	public HashMap populateDateParams(String sys_date){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String future_date			="";
		String back_date			="";
		String start_date			="";
		HashMap DateParams			= new HashMap();
		String locale				= getLanguageId()==null?"en":getLanguageId();
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT8");
			pstmt				= null;
			resultSet			= null;
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,sys_date);
			pstmt.setString(2,sys_date);
		
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				future_date=resultSet.getString("FUTURE_DATE");
				back_date=resultSet.getString("BACK_DATE");
				if(!locale.equals("en")){
					future_date =com.ehis.util.DateUtils.convertDate(future_date, "DMYHM","en",locale);
					back_date = com.ehis.util.DateUtils.convertDate(back_date, "DMYHM","en",locale);
				}
			}
			DateParams.put("start_date",start_date);
			DateParams.put("future_date",future_date);
			DateParams.put("back_date",back_date);
	    }
		catch ( Exception e ) {
			DateParams.put("error",e);
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
		return DateParams;
	}

	public HashMap validateDuration(String drug_code,String patient_class){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        PreparedStatement pstmt1    = null ;
        ResultSet resultSet         = null ;
        ResultSet resultSet1        = null ;
		String sql_query			= "";
		String sql_query1			= "";
		String max_durn_op			= "";
		String max_durn_ip			= "";
		String max_durn			= "";
		HashMap durnValues			= new HashMap();
		try{
			connection = getConnection() ;
			sql_query1 ="select MAX_DURN_FOR_OP_PRES, MAX_DURN_FOR_IP_PRES from ph_param";
			pstmt1				= connection.prepareStatement(sql_query1) ;
			resultSet1			= pstmt1.executeQuery();
			while(resultSet1!=null && resultSet1.next()){
				max_durn_op=resultSet1.getString("MAX_DURN_FOR_OP_PRES");
				max_durn_ip=resultSet1.getString("MAX_DURN_FOR_IP_PRES")==null?"0":resultSet1.getString("MAX_DURN_FOR_IP_PRES");
			}
			if(patient_class.trim().equals("IP")||patient_class.trim().equals("DC"))
				max_durn=max_durn_ip;
			else
				max_durn=max_durn_op;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT20");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2,patient_class);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				durnValues.put("max_durn_value",resultSet.getString("MAX_DURN_VALUE"));
				durnValues.put("chk_for_max_durn_action",(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null?"W":resultSet.getString("CHK_FOR_MAX_DURN_ACTION")));
				durnValues.put("prompt_msg",resultSet.getString("PROMPT_MSG"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(!durnValues.containsKey("max_durn_value")) {
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,drug_code);
				pstmt.setString(2,"*A");
				resultSet			= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					durnValues.put("max_durn_value",resultSet.getString("MAX_DURN_VALUE"));
					durnValues.put("chk_for_max_durn_action",(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null?"W":resultSet.getString("CHK_FOR_MAX_DURN_ACTION")));
					durnValues.put("prompt_msg",resultSet.getString("PROMPT_MSG"));
				}
			}
			String max=(String)durnValues.get("max_durn_value");
			if(max==null||max.trim().equals("0"))
				durnValues.put("max_durn_value",max_durn);
		}
		catch ( Exception e ) {
			durnValues.put("error",e);
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
				es.printStackTrace();
			}
		}
		return durnValues;
	}

	public ArrayList genOrderID(int groupSize,String patient_class) {
		if(patient_class.trim().equals("EM")) {
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
			for(int i=0;i<groupSize;i++){
				pstmt				= null;
				resultSet			= null;
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,"PH");
				pstmt.setString(2,patient_class);
				pstmt.setString(3, login_facility_id); //thrid parameter for facility added for IN[032925]
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					OrderID.add((String)resultSet.getString("order_id"));
				}
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
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return OrderID;
	}

	//for display the ordered list
	public ArrayList getDisplayList(String groupCode) {
		ArrayList displayList=new ArrayList();
		if(presDetails.size()>0){
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

	public boolean checkSplit(ArrayList frequencyValues) {
		boolean found		=	false;
		boolean firstTime	=	true;
		String tmp			=	"";
		String admin_qty	=	null;
	//	HashMap data		=	null;   Removed for IN063877
		ArrayList dose_list	=   new ArrayList();
		if(frequencyValues!=null && frequencyValues.size()>0){	
			dose_list =  (ArrayList)frequencyValues.get(4);
			for(int n=0;n<dose_list.size();n++){
				//data	=(HashMap)frequencyValues.get(n);
				admin_qty	= ((String)dose_list.get(n)).trim();
				if(firstTime) {
					tmp			=	admin_qty;
					firstTime	=	false;
				}
				else if(!tmp.equals(admin_qty)) {
					found		=	true;
				}
			}
			/*for(int n=0;n<frequencyValues.size();n++){
				data	=(HashMap)frequencyValues.get(n);
				admin_qty	= ((String)data.get("admin_qty")).trim();

				if(firstTime) {
					tmp			=	admin_qty;
					firstTime	=	false;
				} else if(!tmp.equals(admin_qty)) {
					found		=	true;
				}
			}*/
		}
		return found;
	}

    public boolean  setScheduleFrequencyStr(Hashtable ht){
		try{
			String code 			= (String)ht.get("code");
			//String duration_type 	= (String)ht.get("durationType");
			//int repeat				= Integer.parseInt((String)ht.get("repeat"));
			//String row_value		= (String)ht.get("row_value");	
			//String start_date_time	= (String)ht.get("start_date_time");
			ArrayList scheduleFrequencyDatas	=	new ArrayList();
			scheduleFrequencyDatas	=	(ArrayList)ht.get(code);
			if (scheduleFrequencyDatas == null){
				scheduleFrequencyDatas	=	new ArrayList();
				String duration_type 	= (String)ht.get("durationType");
				int repeat        		=  Integer.parseInt(checkForNull((String)ht.get("repeat"),"0"));
				//String row_value		= (String)ht.get("row_value");  Removed for IN063877	
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
					}
					else{
						if(!ht.get("admin_day"+(j)).equals("")){
							day_list.add(ht.get("admin_day"+(j)));
						}
						else{
							day_list.add("0");
						}
					}	
					if(!duration_type.equals("D")){
						if(!ht.get("admin_day"+(j)).equals("")){
							String temp = (String)ht.get("admin_day"+(j));
							if (temp == null || temp.equals("")){
								temp = "0";
							}
							if (!temp.equals("0")){
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
			//HashMap scheduleFrequencyDatas	=	new HashMap();
			/*ArrayList day_list	= new ArrayList();
			ArrayList day_names	= new ArrayList();
			ArrayList time_list	= new ArrayList();
			ArrayList dose_list	= new ArrayList();
			String time_value	= (String)ht.get("time1");
			HashMap freq_char_list	 = new HashMap();
			freq_char_list.put("called_from","PH");
			freq_char_list.put("repeat",repeat);
			freq_char_list.put("durationType",duration_type);
			freq_char_list.put("start_date_time",start_date_time);
			freq_char_list.put("end_date_time","");
			for(int j=1 ; j <= repeat ; j++){
				if(duration_type.equals("D")){
					day_list.add("0");	
				}else{
					if(!ht.get("admin_day"+(j+1)).equals("")){
						day_list.add(ht.get("admin_day"+(j+1)));
					}
				}	
				if(!duration_type.equals("D")){
					if(!ht.get("admin_day"+(j+1)).equals("")){
						day_names.add((String)ht.get("dayDisplay"+(ht.get("admin_day"+(j+1)))));
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
			*/
			/*scheduleFrequencyDatas.put("freq_char_list",freq_char_list);
			scheduleFrequencyDatas.put("day_list",day_list);
			scheduleFrequencyDatas.put("day_names",day_names);
			scheduleFrequencyDatas.put("time_list",time_list);
			scheduleFrequencyDatas.put("dose_list",dose_list);*/

			/*for(int j=1 ; j <= repeat ; j++){
				HashMap hashMap			= new HashMap();
				hashMap.put("admin_day_or_time","H");
				hashMap.put("duration_type",duration_type);
				hashMap.put("start_time_assign","");
				hashMap.put("repeat",String.valueOf(repeat));
				hashMap.put("row_value",row_value);
				hashMap.put("admin_time",(String)ht.get("time"+j)); // Values
				hashMap.put("admin_qty",(String)ht.get("qty"+j));
				scheduleFrequencyDatas.add(hashMap);
			}*/
			scheduleFrequency.put(code,scheduleFrequencyDatas);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}	

	public ArrayList<String> getDayOfWeek(String sDate){
		String[] Days={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		ArrayList<String> dayList = new ArrayList<String>();	
		java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date d = new java.util.Date();
		try {
			if (sDate != null && !sDate.equals("")){			
				df.setLenient(false);
				d = df.parse(sDate);
			//	java.util.Calendar c=java.util.Calendar.getInstance();  Removed for IN063877		 
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
		} 
		catch(java.text.ParseException e) {
			return null;
		}
		return dayList; 
	}
	// Get methods ends here
	
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
	public void setAll(Hashtable recordSet){
		if(recordSet.get("mode") != null){
             mode = (String)recordSet.get("mode") ;
		}
	}
	
   public String setOrderID() {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String order_id			= null;
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT37"));
			pstmt.setString(1, "PH");
			pstmt.setString(2, getPatientClass());
			pstmt.setString(3, login_facility_id); //thrid parameter for facility added for IN[032925]
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				order_id	 = resultSet.getString("order_id");
//				this.orderID = order_id;
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
		return order_id;
	}

//	This method will check whether screen has to be displayed or not
  public ArrayList checkForTheDisplay()throws Exception{
		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
		PreparedStatement pstmt1 = null ;
        ResultSet resultSet = null,resultSet1=null;
		String login_by_id="";
		String login_facility_id="";
	//	String getLoginAtWsNo=""; Removed for IN063877
        try {
            connection = getConnection() ;
			login_by_id=getLoginById();
			login_facility_id=getLoginFacilityId();
			login_at_ws_no=getLoginAtWsNo();
            pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT1") ) ;
			pstmt.setString(1,login_by_id.trim());
			resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
				if(!resultSet.getString("PRACT_TYPE").equals("PH")){
					result.add("NO DISPLAY-1");
					return result;
				}
            }
			else{
				result.add("NO DISPLAY-1");
				return result;
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT2") ) ;
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
				if(resultSet.getInt("count")==0){
					result.add("NO DISPLAY-2");
					return result;
				}
            }
			else{
				result.add("NO DISPLAY-2");
				return result;
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
			String disp_locn_code="";
			String disp_locn_details="";
			//String disp_code =""; Removed for IN063877
			String disp_desc ="";
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT3") ) ;
			pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT4A") ) ;
			//pstmt2 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT5") ) ;
			pstmt1.setString(1,login_facility_id.trim());
			pstmt1.setString(2,login_facility_id.trim());
			pstmt1.setString(3,login_facility_id.trim());
			pstmt1.setString(4,login_by_id.trim());
			pstmt1.setString(5,login_at_ws_no.trim());
			pstmt1.setString(6,getLanguageId());
			resultSet1 = pstmt1.executeQuery() ;
			while(resultSet1 != null && resultSet1.next() ) {
				 disp_locn_code =resultSet1.getString("DISP_LOCN_CODE");
				 disp_desc = resultSet1.getString("SHORT_DESC");
				 disp_locn_details = disp_locn_details + (disp_locn_code + ","+disp_desc +",");
			}
			closeResultSet( resultSet1 ) ;
			if ((disp_locn_code.trim()).equals("")){
				result.add("NO DISPLAY-3");
				return result;
			}
			else{

				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT25") ) ;
				pstmt.setString(1,login_facility_id.trim());
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
					   dflt_dir_disp_locn= checkForNull(resultSet.getString("DFLT_DIR_DISP_LOCN"));
				}
				result.add(disp_locn_details);
				setDispLocations(disp_locn_details);
				return result;
			}
			//DISP_LOCN_CODE can be 1 or more.Go to the respective disp locn in PH_DISP_LOCN table and check disp_regn_reqd_yn is 'Y' or 'N'  and check the dispense rights table ....
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeResultSet( resultSet1 ) ;
                closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
				es.printStackTrace();
			}
        }
	}

	public String getPatientIDLength(){/*==============for patient id length from mp_patient==================*/
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet	= pstmt.executeQuery(); 
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
			}catch(Exception es){es.printStackTrace();
			}
		}
		return pat_txt_length;	
	}

	public String getLocationDesc(String patient_class,String locn_code)	{

		if(!patient_class.equals("IP")) {
			patient_class	=	"OP";
		}

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sql_str			=	"";
		String locn_desc		=	"";

		try{
			connection			= getConnection() ;

			if(patient_class.equals("IP"))
				sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT41");
			else if (patient_class.equals("OP") )
				sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT42");

			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,getLoginFacilityId());
			pstmt.setString(2,locn_code);
			pstmt.setString(3,getLanguageId());

			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				locn_desc	=	resultSet.getString("LONG_DESC");
			}
		}
		catch(Exception e){
			locn_desc	=e.toString();
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
		return locn_desc;
	}

	/*==================For getting sys date=================================*/
	public String getTodaysDate(){
		Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
		String today_date		=	"";

		try{
			connection	= getConnection() ;
		    pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54") ) ;
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				today_date	=	resultSet.getString("SYS_DATE_TIME");				
			}
		}
		catch(Exception e){
			e.printStackTrace();
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
		return today_date;
	}	

	public String getTodaysDate1(){
		Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
		String today_date		=	"";
		try{
			connection	= getConnection() ;
		    pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54") ) ;
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				today_date	=	resultSet.getString("SYS_DATE");				
			}
		}
		catch(Exception e){
			e.printStackTrace();
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
		return today_date;
	}	

	/*==================For getting Direct Dispencing Status==============================*/
	public String getDirDispencingStatus(){
		Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
		String dir_disp_allowed	=	"";
		String enctr_dtls_reqd	=	"N";

		try{
			connection	= getConnection() ;
		    pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_DIR_DISP_SELECT") ) ;
			pstmt.setString(1,login_facility_id.trim());

            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				dir_disp_allowed	=	resultSet.getString("DIR_DISP_ALLOWED");	
				if(dir_disp_allowed.equals("Y")){
					enctr_dtls_reqd	=	resultSet.getString("ENCTRS_DTLS_REQD_DUR_DIR_DISP");	
				}
			}
			setEnctrDtlsReqd(enctr_dtls_reqd);
			if(dir_disp_allowed==null) 
				dir_disp_allowed="N";
		}
		catch(Exception e){
			e.printStackTrace();
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
		return dir_disp_allowed;
	}	

	public ArrayList getEncounterDetails(String patient_id,String encounter_id){

		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;		
		HashMap record					= null;		
		ArrayList EncDetails		    = new ArrayList();
		
		try{
			connection = getConnection();
		
			pstmt	  = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DIR_DISP_SELECT2")) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,login_facility_id.trim());
			pstmt.setString(4,getLanguageId());
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
			   record = new HashMap();
			    record.put("ENCOUNTER_ID",resultSet.getString("ENCOUNTER_ID"));				
				record.put("PATIENT_CLASS",resultSet.getString("PATIENT_CLASS"));
				record.put("PRACTITIONER_ID",resultSet.getString("PRACTITIONER_ID"));
				record.put("LOCN_CODE",resultSet.getString("LOCN_CODE"));
				record.put("LOCN_NAME",resultSet.getString("LOCN_NAME"));				
				record.put("PRACT_NAME",resultSet.getString("PRACT_NAME"));
				record.put("VISIT_DATE_TIME",resultSet.getString("VISIT_DATE_TIME"));
				EncDetails.add(record);			   
			}       
		}
		catch(Exception e){
			EncDetails.add(e.toString());
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
		return EncDetails;
	} 

	public ArrayList getPatientDetails1(String id){
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
				records.add(resultSet.getString("DATE_OF_BIRTH"));
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

	public HashMap getPatientDetails2(String patient_id,String drug_code)	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String	patient_name	=	"";
		String	sex				=	"";
		String	age				=	"";
		String	age_in_mints	=	""; //code added for IN:042345
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
				age_in_mints	=	resultSet.getString("AGE_IN_MINTS");//code added for IN:042345
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
			pat_details.put("patient_name",patient_name);
			pat_details.put("sex",sex);
			pat_details.put("age",age);
			pat_details.put("age_in_mints",age_in_mints);//code added for IN:042345

			age	=	age.trim();
			sex	=	sex.substring(0,1);
			
			pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80A") ) ;
			pstmt.setString(1,sex);
			pstmt.setString(2,age);
			pstmt.setString(3,drug_code);
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
			setAgeGroup(age_group);
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
	//Code for setting drugDetails
	public HashMap loadDrugDetails(String priority,String take_home_medication,String locn_type,String locn_code,String facility_id, String drugCode,String patientClass,String patient_id,String sys_date,String srlNo,String drug_db_interface_yn,String drug_db_prod_id,String trade_code,String trade_name, String atc_allergy_alert_level){
		Connection connection				= null ;
        PreparedStatement pstmt				= null ;
		PreparedStatement pstmt_copy		= null ;
        ResultSet resultSet					= null ;
		ResultSet res_copy					= null ;
		CallableStatement cstmt				= null ;
		String sql_query					= "";
		String durn_value					= "";
		String durn_type					= "";
		String freq_code					= "";
		String repeat_durn_type				= "";
		String calc_dosg_by_freq_durn_yn	= "";
		String strength_value				= "";
		String qty_value					= "";
		String qty_desc_code				= "";
		String pres_base_uom				= "";
		String strength_uom					= "";
		String dosage_type					= "";
		String repeat_value					= "";
		String order_type_code				= "";
		String generic_id					= "";
		String end_date						= "";
		String item_code					= "";
		String fract_dose					= "";
		String content_in_pres_base_uom		= "";
		String strength_per_pres_uom		= "";
		String strength_per_value_pres_uom	= "";
		String form_code					= "";
		String freq_nature					= "";
		String interval_value				= "";
		String formulary					= "";
		String calc_dflt_dosage_by_htwt		= "";
		String proc_qty_value				= "";
		String external_product_id			= "";
		String locale						= getLanguageId()==null?"en":getLanguageId();
		String fract_dose_appl_yn = "";
		boolean call_external_checks		= false;
		
       // String ext_dup_theraphy_check		= "N";
		//String ext_dosage_check				= "N";	
		String wt_mand_yn = "", ht_mand_yn="";
		String default_dosage_by = "";
		String drug_indication	 = "";// Added for  ML-BRU-CRF-072[Inc:29938]
		HashMap DrugDetails			= new HashMap();
		try {
			connection = getConnection() ;
			// sql_query ="SELECT ITEM_CODE,DRUG_CODE,DRUG_DESC,STOCK_UOM_DESC,ph_get_ext_prod_drug_code(?,?)EXTERNAL_PRODUCT_ID,IN_FORMULARY_YN,GENERIC_ID,GENERIC_NAME,DRUG_CLASS,FORM_CODE,FORM_DESC,ROUTE_CODE,ROUTE_DESC,PRES_BASE_UOM,PRES_BASE_UOM_DESC,STRENGTH_VALUE,STRENGTH_UOM,STRENGTH_UOM_DESC,STRENGTH_PER_PRES_UOM,STRENGTH_PER_VALUE_PRES_UOM,PRES_CATG_CODE,TRADE_CODE,TRADE_NAME,CALC_DOSG_BY_FREQ_DURN_YN,IV_INGREDIENT_YN,IV_FLUID_YN,  INFUSE_OVER_VALUE,INFUSE_OVER_DURN_TYPE,FRACT_DOSE_ROUND_UP_YN,CONTENT_IN_PRES_BASE_UOM,PRN_DOSES_PRES_PRD_FILL,STOCK_UOM,STOCK_UOM_DESC,CALC_DEF_DOSAGE_YN,PT_COUN_REQD_YN FROM PH_DRUG_VW WHERE DRUG_CODE=? ";
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT1A");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drugCode);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,drugCode);
			pstmt.setString(4,trade_code);
			pstmt.setString(5,trade_code);
			pstmt.setString(6,getLanguageId());
			/*pstmt.setString(7,getLanguageId());
			pstmt.setString(8,getLanguageId());
			pstmt.setString(9,getLanguageId());
			pstmt.setString(10,getLanguageId());*/  //commented for ph_drug_vw_lang_vw - language issue

			resultSet			= pstmt.executeQuery();
			if(resultSet.next()) {
				DrugDetails.put("SRL_NO",srlNo);
				DrugDetails.put("TRADE_CODE",trade_code);
				DrugDetails.put("TRADE_NAME",trade_name);
				DrugDetails.put("AMEND_YN","N");
				DrugDetails.put("ALLOCATEDD_YN","N");
				DrugDetails.put("rowVal",srlNo);
				DrugDetails.put("DRUG_CODE", (resultSet.getString("DRUG_CODE")==null ? "":resultSet.getString("DRUG_CODE")) );
				DrugDetails.put("PATIENT_CLASS",patientClass);
				item_code = resultSet.getString("ITEM_CODE")==null ? "":resultSet.getString("ITEM_CODE");
                DrugDetails.put("ITEM_CODE",item_code );
				DrugDetails.put("DRUG_DESC",(resultSet.getString("DRUG_DESC")==null ? "":resultSet.getString("DRUG_DESC")) );
				DrugDetails.put("IN_FORMULARY_YN",(resultSet.getString("IN_FORMULARY_YN")==null ? "":resultSet.getString("IN_FORMULARY_YN")) );
				formulary	=	(resultSet.getString("IN_FORMULARY_YN")==null ? "":resultSet.getString("IN_FORMULARY_YN"));
				DrugDetails.put("GENERIC_ID",(resultSet.getString("GENERIC_ID")==null ? "":resultSet.getString("GENERIC_ID")) );
				generic_id = resultSet.getString("GENERIC_ID");
				DrugDetails.put("GENERIC_NAME",(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME")) );
				DrugDetails.put("DRUG_CLASS",(resultSet.getString("DRUG_CLASS")==null ? "":resultSet.getString("DRUG_CLASS")) );
				DrugDetails.put("FORM_CODE",(resultSet.getString("FORM_CODE")==null ? "":resultSet.getString("FORM_CODE")) );
				DrugDetails.put("FORM_DESC",(resultSet.getString("FORM_DESC")==null ? "":resultSet.getString("FORM_DESC")) );
				DrugDetails.put("DEFAULT_ROUTE_YN",(resultSet.getString("DEFAULT_ROUTE_YN")==null ? "":resultSet.getString("DEFAULT_ROUTE_YN")) ); //added for  RUT-SCF-0237 [IN:038115]
				DrugDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")) );
				DrugDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")) );
				DrugDetails.put("PRES_BASE_UOM",(resultSet.getString("PRES_BASE_UOM")==null ? "":resultSet.getString("PRES_BASE_UOM")) );
				DrugDetails.put("PRES_BASE_UOM_DESC",(resultSet.getString("PRES_BASE_UOM_DESC")==null ? "":resultSet.getString("PRES_BASE_UOM_DESC")) );
				DrugDetails.put("ACT_STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE")) );
				DrugDetails.put("STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE")) );
				DrugDetails.put("STRENGTH_UOM",(resultSet.getString("STRENGTH_UOM")==null ? "":resultSet.getString("STRENGTH_UOM")) );
				DrugDetails.put("STRENGTH_UOM_DESC",(resultSet.getString("STRENGTH_UOM_DESC")==null ? "":resultSet.getString("STRENGTH_UOM_DESC")) );				
				DrugDetails.put("STRENGTH_PER_PRES_UOM",(resultSet.getString("STRENGTH_PER_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_PRES_UOM")) );				
				DrugDetails.put("STRENGTH_PER_VALUE_PRES_UOM",(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")) );
				DrugDetails.put("PRES_CATG_CODE",(resultSet.getString("PRES_CATG_CODE")==null ? "":resultSet.getString("PRES_CATG_CODE")) );
				//DrugDetails.put("TRADE_CODE",(resultSet.getString("TRADE_CODE")==null ? "":resultSet.getString("TRADE_CODE")) );
				//DrugDetails.put("TRADE_NAME",(resultSet.getString("TRADE_NAME")==null ? "":resultSet.getString("TRADE_NAME")) );				
				DrugDetails.put("CALC_DOSG_BY_FREQ_DURN_YN",(resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")==null ? "":resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")) );
				//DrugDetails.put("EXTERNAL_PRODUCT_ID",(resultSet.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet.getString("EXTERNAL_PRODUCT_ID")) );				
                external_product_id =  resultSet.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet.getString("EXTERNAL_PRODUCT_ID");

                DrugDetails.put("EXTERNAL_PRODUCT_ID",external_product_id );
				DrugDetails.put("EXTERNAL_DRUG_DB_PROD_ID",drug_db_prod_id);
				fract_dose_appl_yn = resultSet.getString("FRACT_DOSE_APPL_YN")==null? "":resultSet.getString("FRACT_DOSE_APPL_YN");
				DrugDetails.put("FRACT_DOSE_APPL_YN",fract_dose_appl_yn);
				if(fract_dose_appl_yn.equals("Y")){
					DrugDetails.put("FRACT_DOSE_ROUND_UP_YN",(resultSet.getString("FRACT_DOSE_ROUND_UP_YN")==null ? "":resultSet.getString("FRACT_DOSE_ROUND_UP_YN")) );
				}
				else{
					DrugDetails.put("FRACT_DOSE_ROUND_UP_YN","N");
				}
				//DrugDetails.put("FRACT_DOSE_ROUND_UP_YN",(resultSet.getString("FRACT_DOSE_ROUND_UP_YN")==null ? "":resultSet.getString("FRACT_DOSE_ROUND_UP_YN")) );				
				DrugDetails.put("CONTENT_IN_PRES_BASE_UOM",(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null ? "":resultSet.getString("CONTENT_IN_PRES_BASE_UOM")) );
				DrugDetails.put("STOCK_UOM",(resultSet.getString("STOCK_UOM")==null ? "":resultSet.getString("STOCK_UOM")) );
				DrugDetails.put("STOCK_UOM_DESC",(resultSet.getString("STOCK_UOM_DESC")==null ? "":resultSet.getString("STOCK_UOM_DESC")) );				
				DrugDetails.put("PRN_DOSES_PRES_PRD_FILL",(resultSet.getString("PRN_DOSES_PRES_PRD_FILL")==null ? "":resultSet.getString("PRN_DOSES_PRES_PRD_FILL")));
				default_dosage_by = resultSet.getString("DEFAULT_DOSAGE_BY")==null ? "":resultSet.getString("DEFAULT_DOSAGE_BY"); //add DEFAULT_DOSAGE_BY for SKR-CRF-PHIS-003[IN028182]
				drug_indication = resultSet.getString("DRUG_INDICATION")==null ? "":resultSet.getString("DRUG_INDICATION"); //add DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]
				DrugDetails.put("DEFAULT_DOSAGE_BY",(resultSet.getString("DEFAULT_DOSAGE_BY")==null ? "":resultSet.getString("DEFAULT_DOSAGE_BY")));
				DrugDetails.put("DRUG_INDICATION",drug_indication);//add DRUG_INDICATION Added for  ML-BRU-CRF-072[Inc:29938]
				content_in_pres_base_uom	= resultSet.getString("CONTENT_IN_PRES_BASE_UOM");
				calc_dosg_by_freq_durn_yn	= resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN");
				strength_value				= resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE");
				strength_value				= strength_value.trim();
				pres_base_uom				= resultSet.getString("PRES_BASE_UOM");
				strength_uom				= resultSet.getString("STRENGTH_UOM");
				fract_dose					= (resultSet.getString("FRACT_DOSE_ROUND_UP_YN")==null ? "":resultSet.getString("FRACT_DOSE_ROUND_UP_YN"));
				strength_per_pres_uom		= (resultSet.getString("STRENGTH_PER_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_PRES_UOM"));
				strength_per_value_pres_uom	= (resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM"));
				form_code					= (resultSet.getString("FORM_CODE")==null ? "":resultSet.getString("FORM_CODE"));
				calc_dflt_dosage_by_htwt	= (resultSet.getString("CALC_DEF_DOSAGE_YN")==null ? "":resultSet.getString("CALC_DEF_DOSAGE_YN"));	
				DrugDetails.put("PT_COUN_REQD_YN", (resultSet.getString("PT_COUN_REQD_YN")==null ? "":resultSet.getString("PT_COUN_REQD_YN")));	
				DrugDetails.put("BILLABLE_ITEM_YN", (resultSet.getString("BILLABLE_ITEM_YN")==null ? "":resultSet.getString("BILLABLE_ITEM_YN")));	
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT2A");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drugCode);
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
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
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
			sql_query				= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10C");
			pstmt					= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,order_type_code);
			pstmt.setString(2,getLanguageId());
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				DrugDetails.put("ORDER_TYPE_DESC",resultSet.getString("SHORT_DESC"));
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT3A")+ " ORDER BY  PATIENT_CLASS desc";// + " ORDER BY  PATIENT_CLASS desc" added for GHL-CRF-0508
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drugCode);
			pstmt.setString(2,patientClass);
			pstmt.setString(3,getLanguageId());

			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				DrugDetails.put("ACT_PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")) );
				DrugDetails.put("ORD_AUTH_REQD_YN",(resultSet.getString("ORD_AUTH_REQD_YN")==null ? "N":resultSet.getString("ORD_AUTH_REQD_YN")) );				
				DrugDetails.put("ORD_SPL_APPR_REQD_YN",(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null ? "N":resultSet.getString("ORD_SPL_APPR_REQD_YN")) );
				DrugDetails.put("ORD_COSIGN_REQD_YN",(resultSet.getString("ORD_COSIGN_REQD_YN")==null ? "N":resultSet.getString("ORD_COSIGN_REQD_YN")) );
				DrugDetails.put("ORD_AUTH_LEVEL",(resultSet.getString("ORD_AUTH_LEVEL")==null ? "":resultSet.getString("ORD_AUTH_LEVEL")) );				
				DrugDetails.put("CHK_FOR_MAX_DURN_ACTION",(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null ? "":resultSet.getString("CHK_FOR_MAX_DURN_ACTION")) );
				DrugDetails.put("PROMPT_MSG",(resultSet.getString("PROMPT_MSG")==null ? "":resultSet.getString("PROMPT_MSG")) );
				DrugDetails.put("MAX_DURN_VALUE",(resultSet.getString("MAX_DURN_VALUE")==null ? "":resultSet.getString("MAX_DURN_VALUE")) );				
				DrugDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")) );
				DrugDetails.put("FREQ_CODE",(resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")) );
				DrugDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")) );
				DrugDetails.put("DURN_TYPE",(resultSet.getString("DURN_TYPE")==null ? "":resultSet.getString("DURN_TYPE")) );

				durn_value		= resultSet.getString("DURN_VALUE");
				freq_code		= resultSet.getString("FREQ_CODE");
				durn_type		= resultSet.getString("DURN_TYPE");
				qty_value		= resultSet.getString("QTY_VALUE");
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);

			// get the atc classification based on generic id
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT98");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,generic_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				DrugDetails.put("ATC_CLASS_LEV1_CODE",(resultSet.getString("ATC_CLASS_LEV1_CODE")==null ? "":resultSet.getString("ATC_CLASS_LEV1_CODE")) );
				DrugDetails.put("ATC_CLASS_LEV2_CODE",(resultSet.getString("ATC_CLASS_LEV2_CODE")==null ? "":resultSet.getString("ATC_CLASS_LEV2_CODE")) );
				DrugDetails.put("ATC_CLASS_LEV3_CODE",(resultSet.getString("ATC_CLASS_LEV3_CODE")==null ? "":resultSet.getString("ATC_CLASS_LEV3_CODE")) );
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);

            if(!DrugDetails.containsKey("ACT_PATIENT_CLASS")) {
				sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT3A");
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,drugCode);
				pstmt.setString(2,"*A");
				pstmt.setString(3,getLanguageId());

				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("ACT_PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")) );
					DrugDetails.put("ORD_AUTH_REQD_YN",(resultSet.getString("ORD_AUTH_REQD_YN")==null ? "N":resultSet.getString("ORD_AUTH_REQD_YN")) );
					DrugDetails.put("ORD_SPL_APPR_REQD_YN",(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null ? "N":resultSet.getString("ORD_SPL_APPR_REQD_YN")) );					
					DrugDetails.put("ORD_COSIGN_REQD_YN",(resultSet.getString("ORD_COSIGN_REQD_YN")==null ? "N":resultSet.getString("ORD_COSIGN_REQD_YN")) );
					DrugDetails.put("ORD_AUTH_LEVEL",(resultSet.getString("ORD_AUTH_LEVEL")==null ? "":resultSet.getString("ORD_AUTH_LEVEL")) );					
					DrugDetails.put("CHK_FOR_MAX_DURN_ACTION",(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null ? "":resultSet.getString("CHK_FOR_MAX_DURN_ACTION")) );
					DrugDetails.put("PROMPT_MSG",(resultSet.getString("PROMPT_MSG")==null ? "":resultSet.getString("PROMPT_MSG")) );
					DrugDetails.put("MAX_DURN_VALUE",(resultSet.getString("MAX_DURN_VALUE")==null ? "":resultSet.getString("MAX_DURN_VALUE")) );
					DrugDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")) );
					DrugDetails.put("FREQ_CODE",(resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")) );
					DrugDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")) );
					DrugDetails.put("DURN_TYPE",(resultSet.getString("DURN_TYPE")==null ? "":resultSet.getString("DURN_TYPE")) );

					durn_value		= resultSet.getString("DURN_VALUE");
					freq_code		= resultSet.getString("FREQ_CODE");
					durn_type		= resultSet.getString("DURN_TYPE");
					qty_value		= resultSet.getString("QTY_VALUE");
				}
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
			//get the standard dose based on age group

			//HashMap pat_dtls	=	getPatientDetails(patient_id);
			HashMap pat_dtls	=	 getPatientDetails2( patient_id, drugCode);
			String	age			=	(String)pat_dtls.get("age");
			String sex			=	((String)pat_dtls.get("sex"));
			String age_in_mints	=	((String)pat_dtls.get("age_in_mints"));//code added for IN:042345

			//age	=	age.replace('Y',' ');
			//age	=	age.replace('M',' ');
			age	=	age.trim();
			sex	=	sex.substring(0,1);
			
			//pstmt	= connection.prepareStatement( "SELECT AGE_GROUP_CODE FROM PH_DOSAGE_LIMIT_FOR_AGE_GROUP WHERE ((GENDER IS NULL) OR (UPPER(GENDER) = UPPER(?))) AND ? BETWEEN MIN_AGE AND MAX_AGE AND DRUG_CODE=?") ;
			pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80A")) ;
			
			pstmt.setString(1,sex);
			pstmt.setString(2,age_in_mints); // age changed to age_in_mints for ML-MMOH-CRF-0978
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
			//added to get the WEIGHT_REC_APPL_AGE_GROUP_FLAG

			//sql_query			= "select c.WT_MAND_YN from ph_drug_age_group c, am_age_group b where c.drug_code= ? and b.AGE_GROUP_CODE = c.AGE_GROUP_CODE and c.EFF_STATUS='E' and  ?  BETWEEN MIN_AGE AND MAX_AGE and ? = (case when (select count(*) from ph_drug_age_group c, am_age_group b where b.AGE_GROUP_CODE = c.AGE_GROUP_CODE  and c.EFF_STATUS='E' and b.GENDER =? and c.drug_code= ? and  ? BETWEEN decode( age_unit,'D',MIN_AGE,'M',MIN_AGE*30,'Y',MIN_AGE*365)  AND decode( age_unit_max,'D',MAX_AGE,'M',MAX_AGE*30,'Y',MAX_AGE*365))=0 then nvl(b.GENDER,?) else b.GENDER end)";
			sql_query =PhRepository.getPhKeyValue("SQL_PH_PRES_WEIGTH_CHECK_FLAG_SELECT");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drugCode);
			pstmt.setString(2,age_in_mints);//code 'age' is replaces by 'age_in_mints' for IN:042345
			pstmt.setString(3,sex);
			pstmt.setString(4,sex);
			pstmt.setString(5,drugCode);
			pstmt.setString(6,age_in_mints);//code 'age' is replaces by 'age_in_mints' for IN:042345
			pstmt.setString(7,sex);
			resultSet			= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				wt_mand_yn = resultSet.getString("WT_MAND_YN")==null?"N":resultSet.getString("WT_MAND_YN");
				ht_mand_yn = resultSet.getString("HT_MAND_YN")==null?"N":resultSet.getString("HT_MAND_YN");
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
			//  added for Bru-HIMS-CRF-079 IN[029945]  - start
			if(wt_mand_yn.equals("Y") && ht_mand_yn.equals("Y")) 
				DrugDetails.put("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG","Y");

			DrugDetails.put("WT_MAND_YN",wt_mand_yn); 
			DrugDetails.put("HT_MAND_YN",ht_mand_yn); 
			DrugDetails.put("RECOMM_DOSAGE_BY",""); // Added for ML-MMOH-CRF-0978
			//  added for Bru-HIMS-CRF-079 IN[029945] -end
			//DrugDetails.put("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG",wt_mand_yn); // commented for Bru-HIMS-CRF-079 IN[029945] 
			if(calc_dflt_dosage_by_htwt.trim().equals("Y") && !age_group.equals("")) {
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
					DrugDetails.put("RECOMM_DOSAGE_BY",(resultSet.getString("LIMIT_IND"))); // Added for ML-MMOH-CRF-0978
				} 
				else {
					DrugDetails.put("RECOMM_YN","N");
					DrugDetails.put("CALC_BY_IND","");
					DrugDetails.put("DOSAGE_STD","");
					DrugDetails.put("DOSAGE_UNIT","");
				}
			} 
			else {
				DrugDetails.put("CALC_BY_IND","");
				DrugDetails.put("RECOMM_YN","N");
				DrugDetails.put("DOSAGE_STD","");
				DrugDetails.put("DOSAGE_UNIT","");
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);
			
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT5A");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,sys_date);
			pstmt.setString(2,sys_date);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				DrugDetails.put("FUTURE_DATE",(resultSet.getString("FUTURE_DATE")) );
				DrugDetails.put("BACK_DATE",(resultSet.getString("BACK_DATE")) );
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT6A");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,freq_code);
			pstmt.setString(2,getLanguageId());
			resultSet			= pstmt.executeQuery();
			
			if(resultSet!=null && resultSet.next())	{
				DrugDetails.put("FREQ_NATURE",(resultSet.getString("FREQ_NATURE")) );
				freq_nature		=	resultSet.getString("FREQ_NATURE");
				if(resultSet.getString("FREQ_NATURE")!=null && ((resultSet.getString("FREQ_NATURE").equals("P")) || (resultSet.getString("FREQ_NATURE").equals("O")))){

					DrugDetails.put("DURN_VALUE","1");
					DrugDetails.put("REPEAT_VALUE","1");	
					DrugDetails.put("ORIG_REPEAT_VALUE","1");
					DrugDetails.put("INTERVAL_VALUE","1");
					DrugDetails.put("FREQ_VALUE",(resultSet.getString("FREQ_VALUE")) );
					DrugDetails.put("FREQ_DESC",(resultSet.getString("FREQ_DESC")) );
					DrugDetails.put("SCHEDULED_YN",(resultSet.getString("SCHEDULED_YN")) );
					DrugDetails.put("REPEAT_DURN_TYPE","D");
					repeat_durn_type=	"D";
//					schedule_yn		=	resultSet.getString("SCHEDULED_YN");
					repeat_value	=	"1";
					interval_value	=	"1";
				}
				else{
			
					DrugDetails.put("REPEAT_VALUE",(resultSet.getString("REPEAT_VALUE")) );
					DrugDetails.put("ORIG_REPEAT_VALUE",(resultSet.getString("REPEAT_VALUE")));
					DrugDetails.put("INTERVAL_VALUE",(resultSet.getString("INTERVAL_VALUE")) );
					DrugDetails.put("FREQ_VALUE",(resultSet.getString("FREQ_VALUE")) );
					DrugDetails.put("FREQ_DESC",(resultSet.getString("FREQ_DESC")) );
					DrugDetails.put("SCHEDULED_YN",(resultSet.getString("SCHEDULED_YN")) );
					DrugDetails.put("REPEAT_DURN_TYPE",(resultSet.getString("REPEAT_DURN_TYPE")) );
					repeat_durn_type =resultSet.getString("REPEAT_DURN_TYPE");
//					schedule_yn		=	resultSet.getString("SCHEDULED_YN");
					repeat_value	=	resultSet.getString("REPEAT_VALUE");
					interval_value	=	(resultSet.getString("INTERVAL_VALUE"));
					if(interval_value==null)
						interval_value	=	"";

					if(interval_value.equals("") || interval_value.equals("0")) {
						interval_value	=	"1";
					}
				}
			}
			else{
				DrugDetails.put("REPEAT_VALUE","1" );
				DrugDetails.put("ORIG_REPEAT_VALUE","1");
				DrugDetails.put("INTERVAL_VALUE","1" );
				DrugDetails.put("FREQ_VALUE","" );
				DrugDetails.put("FREQ_DESC","" );
				DrugDetails.put("SCHEDULED_YN","" );
				DrugDetails.put("REPEAT_DURN_TYPE","D" );
			}
		
			closeResultSet(resultSet);
			closeStatement(pstmt);
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7AA");
			pstmt				= connection.prepareStatement(sql_query) ;

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

		    DrugDetails.put("START_DATE",sys_date);
		
			closeResultSet(resultSet);
			closeStatement(pstmt);
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT8A");
			pstmt				= connection.prepareStatement(sql_query) ;
			if(durn_type==null || durn_type.equals("null"))
				durn_type="D";
			pstmt.setString(1,durn_type);
			pstmt.setString(2,getLanguageId());
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				DrugDetails.put("DURN_DESC",(resultSet.getString("DURN_DESC")) );
				DrugDetails.put("OR_DURN_DESC",(resultSet.getString("DURN_DESC")) );
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
			if(!default_dosage_by.equals("") && !default_dosage_by.equals(dosage_type)){
				DrugDetails.put("DOSAGE_TYPE",default_dosage_by);
				dosage_type=default_dosage_by;					
			}
			
			if( calc_dosg_by_freq_durn_yn.equals("N")) {
				   if(!DrugDetails.containsKey("QTY_VALUE")) {
					DrugDetails.put("QTY_VALUE",qty_value);
					DrugDetails.put("QTY_DESC_CODE",form_code);
					qty_desc_code=form_code;
					proc_qty_value=qty_value;
				}
			} 
			else if(strength_value==null || strength_value.equals("0") || strength_value.equals("")||  fract_dose_appl_yn.equals("N")){
				if(!DrugDetails.containsKey("QTY_VALUE")) {
					DrugDetails.put("QTY_VALUE",qty_value);
					DrugDetails.put("QTY_DESC_CODE",pres_base_uom);					
					qty_desc_code=pres_base_uom;
					proc_qty_value=qty_value;
				}
			}
			else{
				if(!DrugDetails.containsKey("QTY_VALUE")) {
					DrugDetails.put("QTY_VALUE",strength_value);
					DrugDetails.put("QTY_DESC_CODE",strength_uom);
					proc_qty_value=strength_value;
					qty_desc_code=strength_uom;
				}
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT9A");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,qty_desc_code);
			pstmt.setString(2,getLanguageId());
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				DrugDetails.put("QTY_DESC",(resultSet.getString("SHORT_DESC")) );
				DrugDetails.put("OR_QTY_DESC",(resultSet.getString("SHORT_DESC")) );
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
			String consider_stock_for_pres_yn	=	"";
			String allow_pres_without_stock_yn	=	"";
			String stock_installed				=	"";

			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT14A");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				DrugDetails.put("MED_ADMIN_REQD_YN",(resultSet.getString("MED_ADMIN_REQD_YN")==null ? "N":resultSet.getString("MED_ADMIN_REQD_YN")) );
				DrugDetails.put("REFILL_YN",(resultSet.getString("REFILL_YN")==null ? "N":resultSet.getString("REFILL_YN")) );
				DrugDetails.put("MAX_REFILLS_FOR_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_REFILLS_FOR_PRES")) );
				DrugDetails.put("MAX_DURN_FOR_REFILL_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_DURN_FOR_REFILL_PRES")) );
     			DrugDetails.put("ALLOW_DUPLICATE_DRUG",(resultSet.getString("ALLOW_DUPLICATE_DRUG")==null ? "Y":resultSet.getString("ALLOW_DUPLICATE_DRUG")) );
     			DrugDetails.put("ALLOW_DUPLICATE_DRUG_OP",(resultSet.getString("ALLOW_DUPLICATE_DRUG_OP")==null ? "Y":resultSet.getString("ALLOW_DUPLICATE_DRUG_OP")) );
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT15");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,login_facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				if(patientClass.equals("IP")) {
					DrugDetails.put("CONSIDER_STOCK_FOR_PRES_YN",(resultSet.getString("IP_CONSIDER_STOCK_PRES_YN")==null ? "Y":resultSet.getString("IP_CONSIDER_STOCK_PRES_YN")) );
					consider_stock_for_pres_yn	=	resultSet.getString("IP_CONSIDER_STOCK_PRES_YN")==null ? "Y":resultSet.getString("IP_CONSIDER_STOCK_PRES_YN");
					DrugDetails.put("ALLOW_PRES_WITHOUT_STOCK_YN",(resultSet.getString("IP_PRES_WITHOUT_STOCK_YN")==null ? "Y":resultSet.getString("IP_PRES_WITHOUT_STOCK_YN")) );
					allow_pres_without_stock_yn	= resultSet.getString("IP_PRES_WITHOUT_STOCK_YN")==null ? "Y":resultSet.getString("IP_PRES_WITHOUT_STOCK_YN");
				} 
				else {
					DrugDetails.put("CONSIDER_STOCK_FOR_PRES_YN",(resultSet.getString("CONSIDER_STOCK_FOR_PRES_YN")==null ? "Y":resultSet.getString("CONSIDER_STOCK_FOR_PRES_YN")) );
					consider_stock_for_pres_yn	=	resultSet.getString("CONSIDER_STOCK_FOR_PRES_YN")==null ? "Y":resultSet.getString("CONSIDER_STOCK_FOR_PRES_YN");
					DrugDetails.put("ALLOW_PRES_WITHOUT_STOCK_YN",(resultSet.getString("ALLOW_PRES_WITHOUT_STOCK_YN")==null ? "Y":resultSet.getString("ALLOW_PRES_WITHOUT_STOCK_YN")) );
					allow_pres_without_stock_yn	= resultSet.getString("ALLOW_PRES_WITHOUT_STOCK_YN")==null ? "Y":resultSet.getString("ALLOW_PRES_WITHOUT_STOCK_YN");
				}			
			}	

			// CHECK STOCK IS INSTALLED
			closeResultSet(resultSet);
			closeStatement(pstmt);
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT4");
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
			closeResultSet(resultSet);
			closeStatement(pstmt);
			//code for checking whether fdb checks are applicapable or not. drug_db_duptherapy_yn,drug_db_dosecheck_yn
             if(drug_db_interface_yn.equals("Y")){
				if(external_product_id.equals("")){
					call_external_checks =false;
				}
				else{
					call_external_checks =true;
				}
		     }
			 else{
				 call_external_checks =false;  
		     } 
			/* PERFORM_EXTERNAL_DATABASE_CHECKS   will indicate whether  module shiuld perform External checks(FDB)or module checks
			 external checks
			 ===============
			 1.duplicate
			 2.drug interaction
			 3.contra-indication
			 
			 internal checks
			 ===============
			 1.duplictae check
			 2.overdose check*/
			// code written to check whether fdb checks to be performed or PH module checks should be performed
			if(call_external_checks) {
				DrugDetails.put("ALLERGY_YN","N");
			}
			else{	
				String strAD_DA ="'DA', 'AD'";		// Added for HSA-SCF-0011 [IN:042444]
				if(getExcludeADRAllergyAlert().equals("Y")){ 	//Added for HSA-SCF-0011 [IN:042444]
					strAD_DA = "'DA'";}		// Added for HSA-SCF-0011 [IN:042444]
				sql_query			= "select count(*) from (SELECT   a.adv_reac_code allergy_type_code, b.long_desc allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a,  am_reaction_lang_vw b,pr_allergy_sensitivity C, PH_DRUG d, pr_adverse_event adr WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type in( "+strAD_DA+" )  AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code  AND a.patient_id = ? AND b.reaction_code(+) = a.adv_reac_code  AND b.language_id(+) =? and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO AND C.STATUS = 'A' AND( (adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')) union ALL SELECT adv_reac_code allergy_type_code, OTHERS_REACTION allergic_indications,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a ,pr_allergy_sensitivity C , PH_DRUG d, pr_adverse_event adr WHERE a.PATIENT_ID = adr.PATIENT_ID AND a.ADV_EVENT_TYPE_IND = adr.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE = adr.ADV_EVENT_TYPE and a.ALLERGEN_CODE =adr.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO = adr.ADV_EVENT_SRL_NO and a.ADV_EVENT_DTL_SRL_NO = adr.ADV_EVENT_DTL_SRL_NO AND a.adv_event_type ='DA' AND d.DRUG_CODE=? and d.GENERIC_ID=a.allergen_code AND a.patient_id = ?  AND a.adv_reac_code  ='Oth'and a.STATUS = 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO and adr.ALLERGY_ALERT_BY <> 'A' AND C.STATUS = 'A' AND ((adr.ALLERGY_ALERT_BY = 'D' and ADR.DRUG_CODE = d.drug_code) or adr.ALLERGY_ALERT_BY in ('N','G')))";// Changed for RUT-CRF-0065.1 [IN:43255]
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,drugCode);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,getLanguageId());  //Added for RUT-SCF-0191.1 [IN:037367]- start
				pstmt.setString(4,drugCode);
				pstmt.setString(5,patient_id); //Added for RUT-SCF-0191.1 [IN:037367]- end
				int rec_count=0;
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next())
					rec_count=resultSet.getInt(1);
				closeResultSet(resultSet);
				closeStatement(pstmt);

				if(rec_count>0){
					DrugDetails.put("ALLERGY_YN","Y");
				}
				else{
					DrugDetails.put("ALLERGY_YN","N");
					//Code Added for	RUT-CRF-0065 IN 29603 - Start
					String ATC_allergy="0"; ;
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
			}

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
			DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN","N");
			//call max dosage limit proc

			cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//Modified for IN:070451
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
			cstmt.setString( 17, "1");
			//Added for IN:070451 end
			cstmt.execute() ;
	
			String daily_dose	= "";
			String unit_dose	= "";
			String limit_ind	= cstmt.getString( 8 );
			String mono_graph	= "";
         
			 if(call_external_checks){
				DrugDetails.put("LIMIT_IND","Y");	
			}
			else{
				DrugDetails.put("LIMIT_IND",limit_ind);
			} 

			if(limit_ind!=null && limit_ind.equals("N")){
				daily_dose	= cstmt.getString( 6 );
				unit_dose	= cstmt.getString( 7 );
				mono_graph	= cstmt.getString( 9 );					

				DrugDetails.put("RESULT",daily_dose+" : "+unit_dose+" : "+mono_graph);
				DrugDetails.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
				DrugDetails.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );
				DrugDetails.put("MONO_GRAPH",(cstmt.getString(9)==null ? "":cstmt.getString(9)) );
				DrugDetails.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );
				DrugDetails.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );
				DrugDetails.put("DOSAGE_UNIT",(cstmt.getString(12)==null ? "":cstmt.getString(12)) );
				//Added for IN:070451 start
				DrugDetails.put("MAX_DAILY_CEELING_DOSE",(cstmt.getString(13)==null ? "":cstmt.getString(13)));
				DrugDetails.put("MIN_DAILY_CEELING_DOSE",(cstmt.getString(14)==null ? "":cstmt.getString(14)));
				DrugDetails.put("MAX_UNIT_CEELING_DOSE",(cstmt.getString(15)==null ? "":cstmt.getString(15)));
				DrugDetails.put("MIN_UNIT_CEELING_DOSE",(cstmt.getString(16)==null ? "":cstmt.getString(16)));
				//Added for IN:070451 end
			}
			else{
				DrugDetails.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );//Modified for IN:070451
				DrugDetails.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );//Modified for IN:070451
				DrugDetails.put("MONO_GRAPH",(cstmt.getString(9)==null ? "":cstmt.getString(9)));
				DrugDetails.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );//Modified for IN:070451
				DrugDetails.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );//Modified for IN:070451
				DrugDetails.put("DOSAGE_UNIT",(cstmt.getString(12)==null ? "":cstmt.getString(12)) );//Modified for IN:070451
					//Added for IN:070451 start
				DrugDetails.put("MAX_DAILY_CEELING_DOSE",(cstmt.getString(13)==null ? "":cstmt.getString(13)));
				DrugDetails.put("MIN_DAILY_CEELING_DOSE",(cstmt.getString(14)==null ? "":cstmt.getString(14)));
				DrugDetails.put("MAX_UNIT_CEELING_DOSE",(cstmt.getString(15)==null ? "":cstmt.getString(15)));
				DrugDetails.put("MIN_UNIT_CEELING_DOSE",(cstmt.getString(16)==null ? "":cstmt.getString(16)));
					//Added for IN:070451 end
			}
		   if(call_external_checks) {
				DrugDetails.put("CURRENT_RX","N");
		   }
		   else{
				// check for duplicate in previous orders(where not discontinued/hold/cancelled/stop)
				int count_rx		= 0;
				sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13C");
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,patient_id);
				pstmt.setString(2,(String)DrugDetails.get("START_DATE"));
				pstmt.setString(3,(String)DrugDetails.get("END_DATE")); // Changed for ML-BRU-SCF-0811 [IN:039394] 
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
				closeResultSet(resultSet);
				closeStatement(pstmt);

				// count > 0 means duplicate
				if(count_rx>0){
					DrugDetails.put("CURRENT_RX","Y");
				}
				else{
					DrugDetails.put("CURRENT_RX","N");
				}
			}
			ArrayList	schedule	=	(ArrayList)this.getScheduleFrequencyStr(drugCode+srlNo,"0");
            if(schedule!=null){
				if(schedule.size() > 0) {
					/* HashMap detail	=	(HashMap)schedule.get(0);
					 qty_value		=	(String)detail.get("admin_qty");
					 repeat_value		=	""+schedule.size();*/
					 ArrayList dose_list		= (ArrayList)schedule.get(4);

					 if(dose_list.size()>0){
						qty_value		= (String)dose_list.get(0);
						if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
							qty_value="1";
					 }
					 else{
						 if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
							qty_value="1";
					 }
					 repeat_value		=	""+dose_list.size();
				}
				else {
					repeat_value		=	repeat_value;
				}
			}

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
				String tmp_qty	= "";
				if( (proc_qty_value!=null && !(proc_qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
					if(!fract_dose.equals("Y")) {	
						total_qty	=((Float.parseFloat(proc_qty_value)*Integer.parseInt(durn_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom)));
						total_qty		=new Double(Math.ceil(new Double(total_qty/Float.parseFloat(content_in_pres_base_uom)).doubleValue())).floatValue();
					}
					else {
						double unit_qty		= Math.ceil(Double.parseDouble(proc_qty_value)/Double.parseDouble(strength_per_pres_uom)) * (Double.parseDouble(strength_per_value_pres_uom));			
						tmp_qty				= (Math.ceil(unit_qty /Float.parseFloat(content_in_pres_base_uom))+"");
						total_qty			= (Float.parseFloat(tmp_qty) * Float.parseFloat(durn_value) * Float.parseFloat(repeat_value));
					}
					if(freq_nature.equals("F")) {
						total_qty	=	Float.parseFloat(Math.ceil(total_qty/Integer.parseInt(interval_value))+"");
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
			//Added for IN:072715 
			DrugDetails.put("ALLERGY_REMARKS_CODE","");
			DrugDetails.put("DOSE_REMARKS_CODE","");
			DrugDetails.put("CURRENTRX_REMARKS_CODE","");
			DrugDetails.put("INTERACTION_REMARKS_CODE","");
			DrugDetails.put("FOOD_INTERACTION_REMARKS_CODE","");
			DrugDetails.put("LAB_INTERACTION_REMARKS_CODE","");
			//Added for IN:072715 
			DrugDetails.put("TAPPERED_OVER","N");
			DrugDetails.put("DFLT_QTY_UOM","");
			if(freq_nature.equals("P")) {
				DrugDetails.put("DURN_TYPE","D");
			}


			if( (!dosage_type.equals("A"))){
				DrugDetails.put("PROVIDE_TAPER","Y");
				DrugDetails.put("SCH_OVER_YN","N");
			}
			else{
				DrugDetails.put("SCH_OVER_YN","Y");
				DrugDetails.put("PROVIDE_TAPER","N");
			}

			float ext_qty=Float.parseFloat(qty_value);
			int ext_repeat_value=1;
			if((repeat_value!=null && !(repeat_value.equals("")))  ){
				ext_repeat_value=Integer.parseInt(repeat_value);
			}
			float total_qty_value=ext_qty*ext_repeat_value;
			DrugDetails.put("TOTAL_QTY_VALUE",""+total_qty_value);

			String drug_class=(String) getDrugClass(order_type_code);
			String licence=(String)(PhLicenceRights.getKey());
			DrugDetails.put("LICENCE",licence);
            String disp_code	= getDispLocnCode();   

			DrugDetails.put("TESTDATA",drugCode+" : "+facility_id+" : "+locn_type+" : "+locn_code+" : "+priority+" : "+take_home_medication+" : "+order_type_code+" : "+drug_class+" : "+patientClass);
			
			if(licence!=null && !(licence.equals("PHBASIC")) ) {
				//code added for External Prescription..
				if(formulary.equals("N")  ) {
					String append_qry	=	"";
					if(patientClass.equals("OP") || patientClass.equals("EM")) {
						if(priority.equals("R")) {
							append_qry	=" AND A.OP_DISP_LOCN_RTN_ORD=B.DISP_LOCN_CODE ";
						}
						else {
							append_qry	=" AND A.OP_DISP_LOCN_STAT_ORD=B.DISP_LOCN_CODE ";
						}
					}
					else {
						if(take_home_medication.equals("Y")) {
							append_qry	=" AND A.DISCH_MED_DISP_LOCN=B.DISP_LOCN_CODE ";
						} 
						else if(priority.equals("R")) {
							append_qry	=" AND A.IP_DISP_LOCN_RTN_ORD=B.DISP_LOCN_CODE ";
						} 
						else {
							append_qry	=" AND A.IP_DISP_LOCN_STAT_ORD=B.DISP_LOCN_CODE ";
						}						
					}

					pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT76")+append_qry) ;
					pstmt.setString(1,login_facility_id);
					pstmt.setString(2,getLanguageId());
					resultSet			= pstmt.executeQuery();

					if(resultSet!=null && resultSet.next()) {
						if(patientClass.equals("OP") || patientClass.equals("EM")) {
							if(priority.equals("R")) {
								DrugDetails.put("DISP_LOCN_CODE",resultSet.getString("OP_DISP_LOCN_RTN_ORD"));
								DrugDetails.put("DISP_LOCN_DESC",resultSet.getString("OP_RTN_DESC"));
							} 
							else {
								DrugDetails.put("DISP_LOCN_CODE",resultSet.getString("OP_DISP_LOCN_STAT_ORD"));
								DrugDetails.put("DISP_LOCN_DESC",resultSet.getString("OP_STAT_DESC"));
							}					
						}
						else {
							if(take_home_medication.equals("Y")) {
								DrugDetails.put("DISP_LOCN_CODE",resultSet.getString("DISCH_MED_DISP_LOCN"));
								DrugDetails.put("DISP_LOCN_DESC",resultSet.getString("DISCH_DESC"));
							}
							else if(priority.equals("R")) {
								DrugDetails.put("DISP_LOCN_CODE",resultSet.getString("IP_DISP_LOCN_RTN_ORD"));
								DrugDetails.put("DISP_LOCN_DESC",resultSet.getString("IP_RTN_DESC"));
							} 
							else {
								DrugDetails.put("DISP_LOCN_CODE",resultSet.getString("IP_DISP_LOCN_STAT_ORD"));
								DrugDetails.put("DISP_LOCN_DESC",resultSet.getString("IP_STAT_DESC"));
							}
						}
						DrugDetails.put("STOCK_AVAILABLE_YN","Y");
						DrugDetails.put("AVAILABLE_STOCK","5000");
					}
					closeResultSet(resultSet);
					closeStatement(pstmt);
				} 
				else  {
					//chedking stock avail
					
					DrugDetails.put("PRO_TEST",drugCode+"|"+disp_code+"|"+ String.valueOf(total_qty)+"|"+"N"+"|"+end_date+"|"+"N");
					//	if(nationalityCheck(patient_id)) {

					if(consider_stock_for_pres_yn.equals("Y") && allow_pres_without_stock_yn.equals("N") && stock_installed.equals("Y")) {
						if(item_code!=null && !(item_code.equals(""))) {
							cstmt=null;
							cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
							cstmt.setString( 1, item_code+"="+trade_code);
							cstmt.setString( 2, disp_code);
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
							DrugDetails.put("ITEM_COST",(String.valueOf(cstmt.getFloat(10))));

							//end of stock avail
						} 
						else {
							DrugDetails.put("STOCK_AVAILABLE_YN","N");
							DrugDetails.put("AVAILABLE_STOCK","0");
						}
					}
					else {
						DrugDetails.put("STOCK_AVAILABLE_YN","Y");
						DrugDetails.put("AVAILABLE_STOCK","5000");
					}
		/*			} else {
						DrugDetails.put("STOCK_AVAILABLE_YN","Y");
						DrugDetails.put("AVAILABLE_STOCK","5000");
					}*/
				}				
			} // RUT-CRF-0062 [IN029600]  Added to get Build MAR Rule -- end
			DrugDetails.put("INTR_RESTRIC_TRN", "N");//Added  for FD-RUT-CRF-0066.1 [IN036975] -start
			DrugDetails.put("INTERACTION_EXISTS", "N" );
			DrugDetails.put("DRUGINTRACTION_OVERRIDE","N");
			DrugDetails.put("INTR_ALERT", "N" );
		/*	if( !drug_db_interface_yn.equals("Y") || DrugDetails.get("EXTERNAL_PRODUCT_ID")==null || ((String)DrugDetails.get("EXTERNAL_PRODUCT_ID")).equals("") ){ //commented for MMS-KH-CRF-0029 and moved this part aftre loading the drug though validation page
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
			}// added for FD-RUT-CRF-0066.1 [IN036975] - end 
			*/
			int count  = getPhysicalinventoryitemYN( item_code, disp_code);

			if (count>0){
               DrugDetails.put("PHY_INV_ITEM_YN","Y");
			}
			else{
				DrugDetails.put("PHY_INV_ITEM_YN","N");
			}
			String date_str="";
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
			}
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
		return DrugDetails;
	}

	public void addDrugDetails(int pos,HashMap drugDetails)	{
		if(pos==999)
			this.presDetails.add(drugDetails);
		else
			this.presDetails.add(++pos,drugDetails);
	}
	public HashMap getPatientDetails(String patient_id)	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String	patient_name	= "";
		String	sex				= "";
		String	age				= "";		
		HashMap	 pat_details	= new HashMap();

		try{
		connection				= getConnection() ;
		pstmt					= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT43") ) ;
		pstmt.setString(1,getLanguageId());
		pstmt.setString(2,patient_id);
		resultSet	= pstmt.executeQuery();
		if ( resultSet != null && resultSet.next() ) {
				patient_name	= resultSet.getString("PATIENT_NAME");
				sex				= resultSet.getString("SEX");
				age				= resultSet.getString("AGE");
		}
		closeResultSet(resultSet);
		closeStatement(pstmt);
		pat_details.put("patient_name",patient_name);
		pat_details.put("sex",sex);
		pat_details.put("age",age);

			age	=	age.replace('Y',' ');
			age	=	age.replace('M',' ');
			age	=	age.trim();
			sex	=	sex.substring(0,1);			
//		pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80") ) ;
		pstmt	= connection.prepareStatement( "SELECT AGE_GROUP_CODE FROM PH_DOSAGE_LIMIT_FOR_AGE_GROUP WHERE GENDER=? AND ? BETWEEN MIN_AGE AND MAX_AGE" ) ;
		pstmt.setString(1,sex);
		pstmt.setString(2,age);
		resultSet	= pstmt.executeQuery();
		
		while(resultSet!=null && resultSet.next() ) {
			age_group	=	resultSet.getString("AGE_GROUP_CODE");
		}
		closeResultSet(resultSet);
		closeStatement(pstmt);
		setAgeGroup(age_group);
		}catch(Exception e){
				pat_details.put("error",e.toString());
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
return pat_details;
}
/*public String comp_date_time(String end_date,String order_id,String order_line_num){
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
			pstmt		=	null;
			resultSet	=	null;
			pstmt					= connection.prepareStatement(str_qry1) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				end_date	=	resultSet.getString("end_date");
				sys_date1=	resultSet.getString("curr_date");	
			}
			 if(count >=1){
					start_date = sys_date1;}
			 else 
					{start_date = end_date;}
			
               
		}catch ( Exception e ) {
				   e.printStackTrace() ;

		}finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){es.printStackTrace();}
				}
	return start_date;
	}*/
 public String getConvFactor(String strength,String qty_uom)	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sql_str			= "";
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
		closeResultSet(resultSet);
		closeStatement(pstmt);

		}catch(Exception e){
				equl_value=e.toString();
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
	return equl_value;
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
		if(resultSet!=null && resultSet.next())
				{
				drug_class = resultSet.getString("DRUG_CLASS");
				}
			closeResultSet(resultSet);
			closeStatement(pstmt);
		 }catch ( Exception e ) {
                e.printStackTrace() ;

			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){es.printStackTrace();}
              }


		return drug_class;
}
/*public boolean nationalityCheck(String patient_id) { 
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
/*public String getPRNRemarks(String drug_code)
	{
		
		if((String)prn_remarks.get(drug_code) != null)
			return (String)prn_remarks.get(drug_code);
		else
			return "";

}*/
public HashMap populateTaperDates(String end_date,String durn_value,String repeat_durn_type){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String taper_start_date		= "";
		String taper_end_date		= "";
		HashMap DateParams=new HashMap();
		try{
		connection = getConnection() ;
		sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT38");
		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,end_date);
		pstmt.setString(2,repeat_durn_type);
		pstmt.setString(3,end_date);
		pstmt.setString(4,durn_value);
		pstmt.setString(5,repeat_durn_type);
		pstmt.setString(6,end_date);
		pstmt.setString(7,durn_value);
		pstmt.setString(8,repeat_durn_type);
		pstmt.setString(9,end_date);
		pstmt.setString(10,durn_value);
		resultSet			= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next())
		{
				taper_start_date=resultSet.getString("START_DATE");
				taper_end_date=resultSet.getString("END_DATE");
		}
		closeResultSet(resultSet);
		closeStatement(pstmt);
		DateParams.put("taper_start_date",taper_start_date);
		DateParams.put("taper_end_date",taper_end_date);
	    }catch ( Exception e ) {
				DateParams.put("error",e);
                e.printStackTrace() ;
		} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){es.printStackTrace();}
              }


		return DateParams;
}
public ArrayList loadQtyDetails(String form_code){

		ArrayList	qty_values  = new ArrayList();

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String	uom_code		= "";
		String	uom_desc		= "";
		String dflt_uom_yn		= "";
		try{
		connection	= getConnection() ;
		pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT12A") ) ;

		pstmt.setString(1,form_code);
        pstmt.setString(2,getLanguageId());	
		pstmt.setString(3,form_code);
		pstmt.setString(4,form_code);
		pstmt.setString(5,form_code);
		//pstmt.setString(5,form_code);
		pstmt.setString(6,getLanguageId());	
		pstmt.setString(7,form_code);
		pstmt.setString(8,form_code);
		pstmt.setString(9,form_code);		
		pstmt.setString(10,getLanguageId());		
		resultSet	= pstmt.executeQuery();

		while ( resultSet != null && resultSet.next() ) {
			uom_code	=	resultSet.getString("UOM_CODE");
			uom_desc	=	resultSet.getString("SHORT_DESC");
			dflt_uom_yn =	resultSet.getString("QTY_UOM_YN");

			qty_values.add(uom_code);
			qty_values.add(uom_desc);
			qty_values.add(dflt_uom_yn);
		}
		closeResultSet(resultSet);
		closeStatement(pstmt);


		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){ 
				es.printStackTrace();
			}
		}
return qty_values;
}
public String populateEndDate(String freq_nature,String start_date,String durn_value,String repeat_durn_type){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String end_date				="";
		try{
		connection			= getConnection() ;		
		//sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7AA");		
		sql_query			= "SELECT TO_CHAR((CASE WHEN 'D' = ? THEN (TO_DATE(?, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?) WHEN 'W' = ? THEN (TO_DATE(?, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)*7 WHEN 'L' = ? THEN (TO_DATE(?, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)*30 WHEN 'Y' = ? THEN (TO_DATE(?, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)*365 WHEN 'H' = ? THEN (TO_DATE(?, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)/24  WHEN 'M' = ? THEN (TO_DATE(?, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)/(24*60)END), 'DD/MM/RRRR HH24:MI') END_DATE FROM DUAL";		
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
			if(resultSet!=null && resultSet.next())
			{
				end_date=resultSet.getString("END_DATE");

			}
			closeResultSet(resultSet);
			closeStatement(pstmt);

		}catch ( Exception e ) {
                e.printStackTrace() ;

			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){es.printStackTrace();}
              }
	return end_date;
}
public String getFormatId(String order_category,String order_type_code,String order_catalog_code)	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sql_str			=	"";
		String format_id		=	"";

		try{
			connection			= getConnection() ;
			sql_str				= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT46");
			pstmt				= connection.prepareStatement(sql_str) ;

			pstmt.setString(1,order_category);
			pstmt.setString(2,order_type_code);
			pstmt.setString(3,order_catalog_code);

			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
					format_id	=	resultSet.getString("FORMAT_ID");
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);

		}catch(Exception e){
				format_id	=e.toString();
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
return format_id;
}
public ArrayList getPresValues(String form_code,String route_code,String order_catalog_code)	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sql_str			=	"";
		String remarks_code			=	"";
		String remarks_desc			=	"";
		ArrayList pres_values	= new ArrayList();

		try{
			connection			= getConnection() ;
			sql_str				=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT48");
			pstmt				= connection.prepareStatement(sql_str) ;
		    pstmt.setString(1,order_catalog_code);
			pstmt.setString(2,form_code);
			pstmt.setString(3,route_code);
			pstmt.setString(4,getLanguageId());

			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
					remarks_code	=	resultSet.getString("REMARK_CODE");
					remarks_desc	=	resultSet.getString("REMARK_DESC");

					pres_values.add(remarks_code);
					pres_values.add(remarks_desc);
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);

			if(pres_values.size() == 0)	{
				sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT49");

				pstmt			= connection.prepareStatement(sql_str) ;
				pstmt.setString(1,getLanguageId());
				resultSet		= pstmt.executeQuery();
				while ( resultSet != null && resultSet.next() ) {
						remarks_code	=	resultSet.getString("REMARK_CODE");
						remarks_desc	=	resultSet.getString("REMARK_DESC");
						pres_values.add(remarks_code);
						pres_values.add(remarks_desc);
				}
				closeResultSet(resultSet);
				closeStatement(pstmt);
			}
		}catch(Exception e){
				pres_values.add(e.toString());
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
		String repeat_value			= "";
		String schedule_yn			= "";
		String repeat_durn_type		= "";
		HashMap freqValues			= new HashMap();
		try{
			connection					= getConnection() ;
			sql_query					= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT6A");
			pstmt						= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,freq_code);
			pstmt.setString(2,getLanguageId());
			resultSet					= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next())
				{
					repeat_value		= resultSet.getString("REPEAT_VALUE");
					interval_value		= resultSet.getString("INTERVAL_VALUE");
					freq_nature			= resultSet.getString("FREQ_NATURE");
					freq_value			= resultSet.getString("FREQ_VALUE");
					schedule_yn			= resultSet.getString("SCHEDULED_YN");
					repeat_durn_type	= resultSet.getString("REPEAT_DURN_TYPE");

				}
			closeResultSet(resultSet);
			closeStatement(pstmt);

			freqValues.put("freq_nature",freq_nature);
			freqValues.put("interval_value",interval_value);
			freqValues.put("repeat_value",repeat_value);
			freqValues.put("schedule_yn",schedule_yn);
			freqValues.put("repeat_durn_type",repeat_durn_type);

			if(freq_nature.equals("O")){
				freqValues.put("freq_value","1");
				freqValues.put("repeat_durn_type","D");
				freqValues.put("interval_value","1");
				freqValues.put("repeat_value","1");
			}else{
				freqValues.put("freq_value",freq_value);
			}

	    }catch ( Exception e ) {
				freqValues.put("error",e);
                e.printStackTrace() ;

			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){es.printStackTrace();}
              }
		return freqValues;
	}

	public HashMap chkMaxDosageLimit(String drugCode,String patient_id,String qty_value,String dosage_type,String repeat_value,String factor){//Modified for IN:070451
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
			dosage_dtl.put("LIMIT_IND",limit_ind);
			if(limit_ind!=null && limit_ind.equals("N")){
				dosage_dtl.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
				dosage_dtl.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );
				dosage_dtl.put("MONO_GRAPH",(cstmt.getString(9)==null ? "":cstmt.getString(9)) );
				dosage_dtl.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );
				dosage_dtl.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );
				//Added for IN:070451 start
				dosage_dtl.put("DOSAGE_UNIT",(cstmt.getString(12)==null ? "":cstmt.getString(12)) );
				dosage_dtl.put("MAX_DAILY_CEELING_DOSE",(cstmt.getString(13)==null ? "":cstmt.getString(13)));
				dosage_dtl.put("MIN_DAILY_CEELING_DOSE",(cstmt.getString(14)==null ? "":cstmt.getString(14)));
				dosage_dtl.put("MAX_UNIT_CEELING_DOSE",(cstmt.getString(15)==null ? "":cstmt.getString(15)));
				dosage_dtl.put("MIN_UNIT_CEELING_DOSE",(cstmt.getString(16)==null ? "":cstmt.getString(16)));
				//Added for IN:070451 end
			}
			else{
				dosage_dtl.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
				dosage_dtl.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );
				dosage_dtl.put("MONO_GRAPH",(cstmt.getString(9)==null ? "":cstmt.getString(9)));
				dosage_dtl.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );
				dosage_dtl.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );
				//Added for IN:070451 start
				dosage_dtl.put("DOSAGE_UNIT",(cstmt.getString(12)==null ? "":cstmt.getString(12)) );
				dosage_dtl.put("MAX_DAILY_CEELING_DOSE",(cstmt.getString(13)==null ? "":cstmt.getString(13)));
				dosage_dtl.put("MIN_DAILY_CEELING_DOSE",(cstmt.getString(14)==null ? "":cstmt.getString(14)));
				dosage_dtl.put("MAX_UNIT_CEELING_DOSE",(cstmt.getString(15)==null ? "":cstmt.getString(15)));
				dosage_dtl.put("MIN_UNIT_CEELING_DOSE",(cstmt.getString(16)==null ? "":cstmt.getString(16)));
				//Added for IN:070451 end
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

	public ArrayList checkDiagnosis(String patient_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList diagnosis			= new ArrayList();
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT78")) ;
			pstmt.setString(1,patient_id );
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				diagnosis.add(checkForNull(resultSet.getString("DIAG_CODE")));
				diagnosis.add(checkForNull(resultSet.getString("CAUSE_INDICATOR")));
				diagnosis.add(checkForNull(resultSet.getString("DIAG_CODE_SCHEME")));
				diagnosis.add(checkForNull(resultSet.getString("DIAG_DESC")));
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);

			if(diagnosis.size() > 1) {
				int i	= diagnosis.size();
				while(i<12) {
					diagnosis.add("");
					i++;
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
		return diagnosis;
	}

	public HashMap populateFrequencyValues(String drug_code,String freq_code,String mode,String patient_class){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		HashMap frequency			= new HashMap();
		ArrayList FreqCode			= new ArrayList();
		ArrayList FreqDesc			= new ArrayList();
		ArrayList FreqNature			= new ArrayList();
		try{
			connection = getConnection() ;
			boolean DirDispPrnFreqYN = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","DIR_DISP_PRN_FREQ"); // Added for [PMG2016-BSP-CRF-0001 [IN:062523]
			if(DirDispPrnFreqYN){ // if else conditions added for [PMG2016-BSP-CRF-0001 [IN:062523]   - Start
				if(mode!=null && mode.equals("taper")){  
					if(patient_class.equals("IP")) {
						sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10B_IP");
					} else {
						sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10B");
					}
				}else{
					if(patient_class.equals("IP")) {
						sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10A_IP");
					} else {
						sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10A");
					}
				}                                         	
			}                     
			else{ 
			if(mode!=null && mode.equals("taper"))
				sql_query    = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10B");
			else
				sql_query   = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10A_IP"); 
			
			} // if else conditions added for [PMG2016-BSP-CRF-0001 [IN:062523]   - End
			
			pstmt	= connection.prepareStatement(sql_query) ;

			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,login_facility_id.trim());
			pstmt.setString(3,drug_code);
			pstmt.setString(4,getLanguageId());

			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()) {
				FreqCode.add(resultSet.getString("FREQ_CODE"));
				FreqDesc.add(resultSet.getString("FREQ_DESC"));
				FreqNature.add(resultSet.getString("FREQ_NATURE"));
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
			/*following code is commented because the defualt value is loaded by previous query itself and   following code inserting frequency if the query not fetching the default frequency code. but   it lead to unexpected errors like unscheduled frequencies as being added to the list as it     was explicitly avoided in the previous query.*/

			/*sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT95");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2,getLanguageId());
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()) {
				if(!FreqCode.contains(resultSet.getString("FREQ_CODE"))) {
					FreqCode.add(resultSet.getString("FREQ_CODE"));
					FreqDesc.add(resultSet.getString("FREQ_DESC"));
				}
			}*/

			closeResultSet(resultSet);
			closeStatement(pstmt);

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
				es.printStackTrace();
			}
        }
		return frequency;
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
			closeResultSet(resultSet);
			closeStatement(pstmt);

		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                 closeResultSet( resultSet ) ;
                 closeStatement( pstmt ) ;
                 closeConnection( connection );
            }catch(Exception es){es.printStackTrace();}
        }
		return freq_nature;
	}
	public ArrayList getPatientActiveOrders(String patient_id,String patient_class,String order_date,int take_home)	{

		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String sql_str				=	"";
		String	start_date			=	"";
		String	end_date			=	"";
		String	drug_desc			=	"";
		String	strength			=	"";
		String	split_dose_prev		=	"";
		String	strength_uom_desc	=	"";
		String	form_desc			=	"";
		String	practitioner_name	=	"";
		String	facility_name		=	"";
		String	diag_text			=	"";
		String location				=	"";
		String order_id				=	"";
		String order_line_no		=	"";
		String freq_code			=	"";
		String freq_desc			=	"";
		String allergy_reason		=	"";
		String dosage_reason		=	"";
		String duplicate_reason		=	"";
		String discont_date_time	=	"";
		String perf_locn			=	"";
		String iv_prep_yn			=   "";
		String discharge_ind		=	"";
		String in_formulary_yn		=	"";
		String dosage				=	"";
		String dosage_uom_code		=	"";
		String append_qry			=	"";

		ArrayList activeOrders	= new ArrayList();
		HashMap	record			= null;


		try{
		connection			= getConnection() ;

		String license=((String)(PhLicenceRights.getKey())).trim();

		if(patient_class.equals("IP") ||take_home>0) {
			append_qry	=	" ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO";
		} else {
			append_qry	=	" AND NVL(A.TOT_ISSUED_QTY, 0)-NVL(A.RETURNED_QTY,0)!=0 ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO";
		}

		if(license.equals("PH"))
			sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT51")+append_qry;
		else
			sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT51A")+append_qry;
		//ended....
		if(order_date.equals(""))
			order_date	=	getOrderDate();

		pstmt				= connection.prepareStatement(sql_str) ;
	//	pstmt.setString(1,patient_class);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,getLanguageId());
		pstmt.setString(3,getLanguageId());
		pstmt.setString(4,getLanguageId());
		pstmt.setString(5,getLanguageId());

		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
				record	=	new HashMap();
				start_date			=	resultSet.getString("START_DATE");
				end_date			=	resultSet.getString("END_DATE");
				drug_desc			=	resultSet.getString("DRUG_DESC");
				strength			=	resultSet.getString("STRENGTH");
				split_dose_prev		=	resultSet.getString("SPLIT_DOSE_PREVIEW");
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
				discont_date_time	=	resultSet.getString("DISCONT_DATE_TIME");
				if(license.equals("PH"))
					perf_locn			=	resultSet.getString("PERF_LOCN");
				else
					perf_locn			=	"";
				iv_prep_yn			=   resultSet.getString("IV_PREP_YN");
				discharge_ind		=   resultSet.getString("DISCHARGE_IND");
				in_formulary_yn		=	resultSet.getString("IN_FORMULARY_YN");
				dosage				=	resultSet.getString("DOSAGE");
				dosage_uom_code		=	resultSet.getString("DOSAGE_UOM_CODE");

				record.put("start_date",start_date);
				record.put("end_date",end_date);
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
				record.put("iv_prep_yn",iv_prep_yn);
				record.put("freq_code",freq_code);
				record.put("freq_desc",freq_desc);
				record.put("allergy_reason",allergy_reason);
				record.put("dosage_reason",dosage_reason);
				record.put("duplicate_reason",duplicate_reason);
				record.put("discont_date_time",discont_date_time);
				record.put("perf_locn",perf_locn);
				record.put("discharge_ind",discharge_ind);
				record.put("in_formulary_yn",in_formulary_yn);
				record.put("dosage",dosage);
				record.put("dosage_uom_code",dosage_uom_code);

				activeOrders.add(record);
		}
			closeResultSet(resultSet);
			closeStatement(pstmt);
		}catch(Exception e){
			e.printStackTrace();
				activeOrders.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();
			}
		}
		return activeOrders;
	}
	public ArrayList getRoutes(String form_code)	{

		Connection connection	=  null ;
		PreparedStatement pstmt =  null ;
		ResultSet resultSet		=  null ;
		ArrayList routes		=  new ArrayList();
		String sql_str			=	"";
		try{
			connection			= getConnection() ;

			sql_str				= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT65");

			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,form_code);
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery();

			while ( resultSet != null && resultSet.next() ) {
				routes.add(checkForNull(resultSet.getString("ROUTE_CODE")));
				routes.add(checkForNull(resultSet.getString("ROUTE_DESC")));
				routes.add(checkForNull(resultSet.getString("ROUTE_COLOR")));
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);


		}catch(Exception e){
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
	
return routes;
}
public ArrayList loadStatFreqs(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		ArrayList stat_freq			= new ArrayList();
		try{
		connection		= getConnection() ;
		sql_query       = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT96");
		pstmt			= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,getLanguageId());
		resultSet			= pstmt.executeQuery();
		
		while(resultSet!=null && resultSet.next()) {
					stat_freq.add(resultSet.getString("FREQ_CODE"));
					stat_freq.add(resultSet.getString("FREQ_DESC"));				
		}
			closeResultSet(resultSet);
			closeStatement(pstmt);

		}catch ( Exception e ) {
                e.printStackTrace() ;

		} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){es.printStackTrace();}
        }


		return stat_freq;
}
public Hashtable loadDurnDesc(){

		Hashtable	durn_values  = new Hashtable();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String	durn_code		= "";
		String	durn_desc		= "";

		try{
		connection	= getConnection() ;
		pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13A") ) ;
		pstmt.setString(1,getLanguageId());
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			durn_code	=	resultSet.getString("DURN_TYPE");
			durn_desc	=	resultSet.getString("DURN_DESC");
			durn_values.put(durn_code,durn_desc);
		}
			closeResultSet(resultSet);
			closeStatement(pstmt);

		}catch(Exception e){
			durn_values.put("Exception",e.toString()); e.printStackTrace();
				}
		 finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){ durn_values.put("Exception",es.toString()); es.printStackTrace();
			}
		}
		return durn_values;
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
		pstmt.setString(3,getLanguageId());
		pstmt.setString(4,getLanguageId());
		pstmt.setString(5,getLanguageId());

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

				record.put("start_date",start_date);
				record.put("end_date",end_date);
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
			closeResultSet(resultSet);
			closeStatement(pstmt);

		}catch(Exception e){
				dupDrugs.add(e.toString()); e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){ es.printStackTrace();
			}
		}
return dupDrugs;
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
			pstmt.setString(2,getLanguageId());
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				remarks = (String)resultSet.getString("REMARK_DESC");
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
		 }catch ( Exception e ) {				
                e.printStackTrace() ;
		 }finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){ es.printStackTrace();}
		}
		return remarks.trim();
	}

public HashMap populateRefillDetail(String end_date,String durn_value,String repeat_durn_type,String refill_value){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String str_refil_startdate  = "";
		String str_refil_enddate    = "";

		ArrayList refill_start_date	= new ArrayList();
		ArrayList refill_end_date	= new ArrayList();
		HashMap RefillDetail		= new HashMap();
		String locale				= getLanguageId()==null?"en":getLanguageId();
		try{
		connection = getConnection() ;
		//Modified for IN:069886 start
		//sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT30");
		sql_query        = "SELECT TO_CHAR ((CASE  WHEN 'D' = ? AND ROWNUM = 1 THEN (TO_DATE (?, 'dd/mm/yyyy hh24:mi')) + (1 * ROWNUM * 1/1440) WHEN 'D' = ? AND ROWNUM > 1  THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + (TO_NUMBER (?)) * (ROWNUM - 1) + 0  WHEN 'W' = ? AND ROWNUM = 1   THEN (TO_DATE (?, 'dd/mm/yyyy hh24:mi')) + (1 * ROWNUM * 1/1440)  WHEN 'W' = ? AND ROWNUM > 1  THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + ((TO_NUMBER (?) * 7)) * (ROWNUM - 1) + 0 WHEN 'L' = ? AND ROWNUM = 1  THEN (TO_DATE (?, 'dd/mm/yyyy hh24:mi')) + (1 * ROWNUM * 1/1440)  WHEN 'L' = ? AND ROWNUM > 1  THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + ((TO_NUMBER (?) * 30)) * (ROWNUM - 1) + 0 WHEN 'Y' = ? AND ROWNUM = 1 THEN (TO_DATE (?, 'dd/mm/yyyy hh24:mi')) + (1 * ROWNUM * 1/1440)  WHEN 'Y' = ? AND ROWNUM > 1  THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440))  + ((TO_NUMBER (?) * 365)) * (ROWNUM - 1) + 0 WHEN 'M' = ? AND ROWNUM = 1 THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')) + (1 * ROWNUM * 1 / 1440) WHEN 'M' = ? AND ROWNUM > 1 THEN (  TO_DATE (?, 'dd/mm/yyyy hh24:mi') + (ROWNUM * 1 / 1440)) + ((TO_NUMBER (?)/(24*60))) * (ROWNUM - 1) + 0 WHEN 'H' = ? AND ROWNUM = 1 THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')) + (1 * ROWNUM * 1 / 1440) WHEN 'H' = ? AND ROWNUM > 1 THEN   (  TO_DATE (?, 'dd/mm/yyyy hh24:mi') + (ROWNUM * 1 / 1440)) + ((TO_NUMBER (?)/24)) * (ROWNUM - 1) + 0  END), 'dd/mm/yyyy hh24:mi' ) start_date,  TO_CHAR ((CASE WHEN 'D' = ?  THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + ((TO_NUMBER (?)) * ROWNUM) WHEN 'W' = ? THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + (((TO_NUMBER (?) * 7)) * ROWNUM)  WHEN 'L' = ? THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + (((TO_NUMBER (?) * 30)) * ROWNUM) WHEN 'Y' = ? THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + (((TO_NUMBER (?) * 365)) * ROWNUM) WHEN 'M' = ? THEN   (  TO_DATE (?, 'dd/mm/yyyy hh24:mi') + (ROWNUM * 1 / 1440) ) + (((TO_NUMBER (?)/(24*60))) * ROWNUM) WHEN 'H' = ? THEN   (  TO_DATE (?, 'dd/mm/yyyy hh24:mi')+ (ROWNUM * 1 / 1440))+ (((TO_NUMBER (?)/24)) * ROWNUM) END), 'dd/mm/yyyy hh24:mi') end_date  FROM sm_function  WHERE ROWNUM <= TO_NUMBER (?)";
		pstmt				= null;
		resultSet			= null;
		pstmt				= connection.prepareStatement(sql_query) ;

		pstmt.setString(1,repeat_durn_type);
		pstmt.setString(2,end_date);
		pstmt.setString(3,repeat_durn_type);
		pstmt.setString(4,end_date);
		pstmt.setString(5,durn_value);
		pstmt.setString(6,repeat_durn_type);
		pstmt.setString(7,end_date);
		pstmt.setString(8,repeat_durn_type);
		pstmt.setString(9,end_date);
		pstmt.setString(10,durn_value);
		pstmt.setString(11,repeat_durn_type);
		pstmt.setString(12,end_date);
		pstmt.setString(13,repeat_durn_type);
		pstmt.setString(14,end_date);
		pstmt.setString(15,durn_value);
		pstmt.setString(16,repeat_durn_type);
		pstmt.setString(17,end_date);
		pstmt.setString(18,repeat_durn_type);
		pstmt.setString(19,end_date);
		pstmt.setString(20,durn_value);
		pstmt.setString(21,repeat_durn_type);
		pstmt.setString(22,end_date);
		pstmt.setString(23,repeat_durn_type);
		pstmt.setString(24,end_date);
		pstmt.setString(25,durn_value);
		pstmt.setString(26,repeat_durn_type);
		pstmt.setString(27,end_date);
		pstmt.setString(28,repeat_durn_type);
		pstmt.setString(29,end_date);
		pstmt.setString(30,durn_value);
		pstmt.setString(31,repeat_durn_type);
		pstmt.setString(32,end_date);
		pstmt.setString(33,durn_value);
		pstmt.setString(34,repeat_durn_type);
		pstmt.setString(35,end_date);
		pstmt.setString(36,durn_value);
		pstmt.setString(37,repeat_durn_type);
		pstmt.setString(38,end_date);
		pstmt.setString(39,durn_value);
		pstmt.setString(40,repeat_durn_type);
		pstmt.setString(41,end_date);
		pstmt.setString(42,durn_value);
		pstmt.setString(43,repeat_durn_type);
		pstmt.setString(44,end_date);
		pstmt.setString(45,durn_value);
		pstmt.setString(46,repeat_durn_type);
		pstmt.setString(47,end_date);
		pstmt.setString(48,durn_value);
		pstmt.setString(49,refill_value);
		//Modified for IN:069886 end
		resultSet= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())
			{

				if(!locale.equals("en")){
						str_refil_startdate  = com.ehis.util.DateUtils.convertDate(str_refil_startdate, "DMYHM","en",locale);
						str_refil_enddate    =	com.ehis.util.DateUtils.convertDate(str_refil_enddate, "DMYHM","en",locale);
				}
				refill_start_date.add(resultSet.getString("START_DATE"));
				refill_end_date.add(resultSet.getString("END_DATE"));
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
		RefillDetail.put("refill_start_date",refill_start_date);
		RefillDetail.put("refill_end_date",refill_end_date);
		}catch ( Exception e ) {

			RefillDetail.put("error",e);
                e.printStackTrace() ;

			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){ es.printStackTrace();} 
              }

	return RefillDetail;
}
public HashMap populateRefillDates(String end_date,String durn_value,String repeat_durn_type,String refill_value){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String refill_start_date	= "";
		String refill_end_date	    = "";
		HashMap RefillDetail		= new HashMap();
		String locale				= getLanguageId()==null?"en":getLanguageId();

		try{
		connection = getConnection() ;
		sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT39");
		pstmt				= null;
		resultSet			= null;
		pstmt				= connection.prepareStatement(sql_query) ;

		pstmt.setString(1,repeat_durn_type);
		pstmt.setString(2,end_date);
		pstmt.setString(3,repeat_durn_type);
		pstmt.setString(4,end_date);
		pstmt.setString(5,repeat_durn_type);
		pstmt.setString(6,end_date);
		pstmt.setString(7,repeat_durn_type);
		pstmt.setString(8,end_date);
		pstmt.setString(9,durn_value);
		pstmt.setString(10,refill_value);
		pstmt.setString(11,repeat_durn_type);
		pstmt.setString(12,end_date);
		pstmt.setString(13,durn_value);
		pstmt.setString(14,refill_value);
		pstmt.setString(15,repeat_durn_type);
		pstmt.setString(16,end_date);
		pstmt.setString(17,durn_value);
		pstmt.setString(18,refill_value);
		resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())
			{
			refill_start_date=resultSet.getString("START_DATE");
			refill_end_date=resultSet.getString("END_DATE");
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);

		if(!locale.equals("en")){
				refill_start_date = com.ehis.util.DateUtils.convertDate(refill_start_date, "DMYHM","en",locale);
				refill_end_date =	com.ehis.util.DateUtils.convertDate(refill_end_date, "DMYHM","en",locale);
		}
		RefillDetail.put("refill_st_date",refill_start_date);
		RefillDetail.put("refill_en_date",refill_end_date);
		}catch ( Exception e ) {
			RefillDetail.put("error",e);
                e.printStackTrace() ;

			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){ es.printStackTrace();}
              }
	return RefillDetail;
}

public String getOrderUnit(String dosage_type, String order_qty, String drug_code) {

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String order_uom		= "";
		try{
			connection			= getConnection() ;

			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT64")) ;
			pstmt.setString(1,dosage_type);
			pstmt.setString(2,order_qty);
			pstmt.setString(3,order_qty);
			pstmt.setString(4,drug_code);
			pstmt.setString(5,getLanguageId());
			pstmt.setString(6,getLanguageId());
			pstmt.setString(7,getLanguageId());
			pstmt.setString(8,getLanguageId());
			pstmt.setString(9,getLanguageId());

			
			resultSet	= pstmt.executeQuery();

			if ( resultSet != null && resultSet.next() ) {
					order_uom	=	(String)resultSet.getString("STOCK_UOM_DESC");
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);

		}catch(Exception e){
				order_uom=e.toString(); e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){ es.printStackTrace();
			}
		}
		return order_uom;
	}

	public String getOrderQty(HashMap ext_drugData,String qty_value,String dup_repeat,String durn,String dosage,String conv_factor,boolean split_chk,String interval,String freq_nat,String stage) {

		String fract_dose						= (String)ext_drugData.get("FRACT_DOSE_ROUND_UP_YN");
		String dosage_type						= (String)ext_drugData.get("DOSAGE_TYPE");
		dosage_type								= dosage;
		String durn_value						= (String)ext_drugData.get("DURN_VALUE");
		durn_value								= durn;
		String repeat_value						= (String)ext_drugData.get("REPEAT_VALUE");
		repeat_value							= dup_repeat;
		String content_in_pres_base_uom			= (String)ext_drugData.get("CONTENT_IN_PRES_BASE_UOM");
		//String strength_value					= (String)ext_drugData.get("ACT_STRENGTH_VALUE");
		String strength_per_value_per_pres_uom	= (String)ext_drugData.get("STRENGTH_PER_VALUE_PRES_UOM");
		String strength_per_pres_uom			= (String)ext_drugData.get("STRENGTH_PER_PRES_UOM");
		String interval_value					= (String)ext_drugData.get("INTERVAL_VALUE");
		String freq_nature						= ((String)ext_drugData.get("FREQ_NATURE"))==null?"":(String)ext_drugData.get("FREQ_NATURE");
		if(stage.equals("Allocation")){
			interval_value=interval;
			freq_nature=freq_nat;
		}	
			
		String ord_qty		=	"";
		String	tmp_qty		=	"";
		if( split_chk )
			repeat_value		=	"1";
		try {
			if(dosage_type!=null && dosage_type.equals("A")){
				ord_qty	=	qty_value;
			}
			else if(dosage_type!=null && dosage_type.equals("Q")){
				if(fract_dose.equals("N")) {
					/*ord_qty		=  (Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value))*Float.parseFloat(repeat_value)* Float.parseFloat(conv_factor))+"";
					ord_qty		=	Math.ceil(Float.parseFloat(ord_qty)/(Float.parseFloat(content_in_pres_base_uom)))+"";*///commented for AAKH-SCF-0189 [IN:054663]
					if(conv_factor.contains(".")) //added for AAKH-SCF-0189 [IN:054663] -start
						ord_qty		=  (Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value))*Float.parseFloat(repeat_value)* Float.parseFloat(conv_factor))+"";
					else
						ord_qty		=  ((Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value))*Float.parseFloat(repeat_value))/ Float.parseFloat(conv_factor))+""; 
					ord_qty		=	Float.parseFloat(ord_qty)/(Float.parseFloat(content_in_pres_base_uom))+"";
					DecimalFormat dfTest = new DecimalFormat("##.####");
					ord_qty = dfTest.format(Double.parseDouble(ord_qty));
					ord_qty		=	Math.ceil(Float.parseFloat(ord_qty))+"";//AAKH-SCF-0189 [IN:054663] end
					if(ord_qty.equals("0")){
						ord_qty	=	"1";
					}
				} 
				else {
					qty_value	=   (Math.ceil((Float.parseFloat(qty_value))/(Float.parseFloat(content_in_pres_base_uom))))*(Float.parseFloat(content_in_pres_base_uom))+""; //added for AAKH-SCF-0189 [IN:054663]
					if( ((Float.parseFloat(qty_value)*Float.parseFloat(conv_factor)) < Float.parseFloat(content_in_pres_base_uom))  )  {
						tmp_qty	=	1+"";
					}
					else {
						if(Float.parseFloat(content_in_pres_base_uom)<1)//if block and else condition added for AAKH-SCF-0189 [IN:054663]
							tmp_qty	=  Math.ceil(Float.parseFloat(qty_value)/(Float.parseFloat(conv_factor)*Float.parseFloat(content_in_pres_base_uom)))+"";
						else
							tmp_qty	=  Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(conv_factor))/Float.parseFloat(content_in_pres_base_uom))+"";
					}
					 ord_qty	=  (Float.parseFloat(tmp_qty) *Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value))*Float.parseFloat(repeat_value))+"";
					 if( (Float.parseFloat(qty_value)*Float.parseFloat(conv_factor)) < Float.parseFloat(content_in_pres_base_uom)) {//added for AAKH-SCF-0189 [IN:054663]
						ord_qty	=  Math.ceil((Float.parseFloat(ord_qty) ) /Float.parseFloat(content_in_pres_base_uom))+""; 
					}
					/*if((Float.parseFloat(qty_value)*Float.parseFloat(conv_factor)) < Float.parseFloat(content_in_pres_base_uom)) {
						tmp_qty	=	1+"";
					}
					else {
						tmp_qty	=  Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(conv_factor))/Float.parseFloat(content_in_pres_base_uom))+"";
					}				
					ord_qty	=  (Float.parseFloat(tmp_qty) *Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value))*Float.parseFloat(repeat_value))+"";*///commented for AAKH-SCF-0189 [IN:054663]
				}
				ord_qty	=	String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				/*if(freq_nature.equals("F")) { //commented for AAKH-SCF-0189 [IN:054663]
					ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(ord_qty) / Integer.parseInt(interval_value)));
				}*///commented fro AAKH-SCF-0189 [IN:054663]
			}
			else if(dosage_type!=null && dosage_type.equals("S")){
				if(fract_dose.equals("N")) {			
					/*ord_qty		=((Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value))*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))/(Float.parseFloat(strength_per_pres_uom)))+"";
					ord_qty		=	String.valueOf(Math.ceil(new Double(Float.parseFloat(ord_qty)/Float.parseFloat(content_in_pres_base_uom)).doubleValue()));*///commented for AAKH-SCF-0189 [IN:054663]
					ord_qty		=(Float.parseFloat(qty_value)*Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value))*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))+"";//added for AAKH-SCF-0189 [IN:054663]
					ord_qty		=	(float)(Float.parseFloat(ord_qty)/(Float.parseFloat(strength_per_pres_uom) * Float.parseFloat(content_in_pres_base_uom)))+"";//added for AAKH-SCF-0189 [IN:054663]
				}
				else {
					/*double unit_qty	= (Double.parseDouble(qty_value)) * (Double.parseDouble(strength_per_value_per_pres_uom));	
					tmp_qty			=  ((unit_qty) * Float.parseFloat(durn_value))+"";
					ord_qty			=  (Math.ceil(Float.parseFloat(tmp_qty) /Float.parseFloat(content_in_pres_base_uom))+"");	
					
					double unit_qty	=   Double.parseDouble(qty_value);///Double.parseDouble(strength_per_pres_uom));
					if(repeat_value.equals("") || repeat_value.length()==0)
					repeat_value="1";
					tmp_qty			=   (unit_qty * Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value)) * Integer.parseInt(repeat_value))+"";
					ord_qty			=((float)  Float.parseFloat(tmp_qty)*Float.parseFloat(strength_per_value_per_pres_uom) /Float.parseFloat(content_in_pres_base_uom))+"";*/ //commented fro AAKH-SCF-0189 [IN:054663]
					float unit_qty = 1.0f;//added for AAKH-SCF-0189 [IN:054663] -start
					float unit_dose_qty =(Float.parseFloat(strength_per_value_per_pres_uom) /Float.parseFloat(strength_per_pres_uom))*Float.parseFloat(qty_value);
					if(freq_nature.equals("O") || unit_dose_qty == Float.parseFloat(content_in_pres_base_uom) || (unit_dose_qty % Float.parseFloat(content_in_pres_base_uom)) == 0)
						unit_qty	=(float) Float.parseFloat(qty_value)/Float.parseFloat(strength_per_pres_uom);	
					else
						unit_qty	=(float) Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_per_pres_uom));	
					tmp_qty			=   unit_qty *Math.ceil(Float.parseFloat(durn_value)/Float.parseFloat(interval_value)) * Integer.parseInt(repeat_value)+"";
					ord_qty			= ( Float.parseFloat(tmp_qty) *Float.parseFloat(strength_per_value_per_pres_uom))  /Float.parseFloat(content_in_pres_base_uom)+""; //added for AAKH-SCF-0189 [IN:054663]-end
				}
				ord_qty=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				/*if(freq_nature.equals("F")) {
					ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(ord_qty) / Integer.parseInt(interval_value)));
				}*/
			}
			ord_qty=String.valueOf(Math.ceil(Float.parseFloat(String.valueOf(ord_qty))));//added for AAKH-SCF-0189 [IN:054663]
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return ord_qty;
	}
	//METHOD FOR GETTING OP_DISP_PERIOD FROM PH_DISP_LOCN
	public int getopdispperiod(String dis_loc_code) throws Exception{
		
		int op_disp_period				= 0;		
        Connection connection			= null ;
        PreparedStatement pstmt			= null ;
        ResultSet resultSet				= null;

        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT114") ) ;
			
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,dis_loc_code);		
		    resultSet = pstmt.executeQuery() ;

            if ( resultSet != null && resultSet.next() ) {					
				op_disp_period=resultSet.getInt("OP_DISP_PERIOD");					
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
		return op_disp_period;
	}
//method to get store code
	public String getStoreCode(String dis_loc_code) throws Exception{
		
		String store_code				= "";		
        Connection connection			= null ;
        PreparedStatement pstmt			= null ;
        ResultSet resultSet				= null;

        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DIRECT_DISPENSING_SELECT13") ) ;
						
			pstmt.setString(1,dis_loc_code);
			pstmt.setString(2,login_facility_id.trim());

		    resultSet = pstmt.executeQuery() ;

            if ( resultSet != null && resultSet.next() ) {					
				store_code=resultSet.getString("STORE_CODE");					
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
		return store_code;
	}
	//check the stock availability
	//  item_code syntax  item_code =item+"="+trade_code;
	public HashMap chkStockAvail(String item_code,String disp_code,String total_qty,String end_date){
		Connection connection       = null ;
        CallableStatement cstmt     = null ;
        ResultSet resultSet         = null ;
//		String sql_query			= "";
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
			    e.printStackTrace() ;
			 return stockValues;
		} finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();}
        }
		return stockValues;
	}
//end of stock

public boolean checkDuplicateDrug(String patient_id, String generic_id,String start_date,String end_date,String freq_code){
		Connection connection         = null ;
        PreparedStatement pstmt       = null ;
        ResultSet resultSet           = null ;
		int count_rx				= 0;
		boolean result				=	false;
		String sql_query			=	"";
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13C")) ;
				
				sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13C");
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,patient_id);
				pstmt.setString(2,start_date);
				pstmt.setString(3,end_date);	// Changed for ML-BRU-SCF-0811 [IN:039394] 
				pstmt.setString(4,start_date);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(5,end_date);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(6,start_date);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(7,end_date);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(8,freq_code);	
				pstmt.setString(9,generic_id);
				//pstmt.setString(6,generic_id);

				resultSet			= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next())	{
						count_rx=resultSet.getInt(1);
				}

				// count > 0 means duplicate
				if(count_rx>0){
					result	=	true;
				}

		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                 closeResultSet( resultSet ) ;
                 closeStatement( pstmt ) ;
                 closeConnection( connection );
            }catch(Exception es){es.printStackTrace();}
        }
		return result;
}
public void clearCopiedDrugs(String drug_code) {
			int index	=	(this.getPrescriptions()).indexOf(drug_code);
			if(index!=-1 && this.getPrescriptions().size() >=index) {
				if(this.getPrescriptions().contains(this.getPrescriptions().get(index-1)) &&
					this.getPrescriptions().contains(drug_code) ) {
					this.getPrescriptions().remove(this.getPrescriptions().get(index-1));
					this.getPrescriptions().remove(drug_code);
				}
			}
	}
/*public ArrayList getInstructions(String drug_code)
	{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		ArrayList instructions_res 	= new ArrayList();
		ArrayList instructions		= new ArrayList();
		
		try {

            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DIR_DISP_EDIT_INSTRUCTIONS")) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2,getLanguageId());
			
			
            resultSet	= pstmt.executeQuery() ;

			while (resultSet.next()){
			instructions_res.add(checkForNull((String)resultSet.getString("CAUTION_LABEL_TEXT_ID_1")));	
			instructions_res.add(checkForNull((String)resultSet.getString("CAUTION_LABEL_TEXT_ID_2")));	
			instructions_res.add(checkForNull((String)resultSet.getString("SPL_INSTR_LABEL_TEXT_ID")));	
			instructions_res.add(checkForNull((String)resultSet.getString("SPL_INSTR_LABEL_TEXT_ID1")));	
			instructions_res.add(checkForNull((String)resultSet.getString("HOW_TO_TAKE_TEXT")));				
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);

			String tempString ="XX";
			if(instructions_res.size() > 0)
			{	
//				connection	= getConnection() ;
				PreparedStatement pstmt_int	= null;
				pstmt_int		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDI_EDIT_INT_RESULTS")) ;
				
				for(int i=0;i<4;i++)
				{					
					if( (!(((String)instructions_res.get(i)).equals(tempString))) && (!( (((String)instructions_res.get(i))=="") || ( ((String)instructions_res.get(i)).equals("")  ) )))
					
					{
						
			
						pstmt_int.setString(1,(String)instructions_res.get(i));
						pstmt_int.setString(2,getLanguageId());
						resultSet	= pstmt_int.executeQuery() ;
						while (resultSet.next()){
						ArrayList	temp = new ArrayList();
						temp.add((String)resultSet.getString("LABEL_TEXT_1"));	
						temp.add((String)resultSet.getString("LABEL_TEXT_2"));
						temp.add((String)resultSet.getString("LABEL_TEXT_1_LOC_LANG"));
						temp.add((String)resultSet.getString("LABEL_TEXT_2_LOC_LANG"));
						if(i < 2){
								temp.add(instructions_res.get(4));
						}else{
							temp.add("");
						}
						temp.set(4,instructions_res.get(4));
						
						instructions.add(temp);

						}




					}
					tempString = (String)instructions_res.get(i);
				}

				closeResultSet( resultSet ) ;
				closeStatement( pstmt_int ) ;
		}
if(instructions.size()==0){

instructions.add(instructions_res);
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

	return instructions;
	}*/
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
		/*********** Initialize the values for Caution***********/
		pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT8") ) ;
		pstmt.setString(1,getLanguageId());
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			HashMap data=new HashMap();
			data.put( "label_text_id",resultSet.getString( "label_text_id" ) ) ;
			data.put( "label_text_1",resultSet.getString( "label_text_1" ) ) ;
			data.put( "label_text_2",resultSet.getString( "label_text_2" ) ) ;
			caution.add(data);
			}
		
			closeResultSet(resultSet);
			closeStatement(pstmt);
		pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT9") ) ;
		pstmt.setString(1,getLanguageId());
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			HashMap data=new HashMap();
			data.put( "label_text_id",resultSet.getString( "label_text_id" ) ) ;
			data.put( "label_text_1",resultSet.getString( "label_text_1" ) ) ;
			spl_instruction.add(data);
			}

	
			closeResultSet(resultSet);
			closeStatement(pstmt);
		pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT9A") ) ;
		pstmt.setString(1,getLanguageId());
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			HashMap data=new HashMap();
			data.put( "label_text_id",resultSet.getString( "LABEL_TEXT_ID" ) ) ;
			data.put( "label_text_2",resultSet.getString( "LABEL_TEXT_2" ) ) ;
			spl_instruction2.add(data);
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
		} catch ( Exception e )	{
			labels.put( "erorr :",e.toString());
				try{
					e.printStackTrace() ;
					throw e ;
				}
				catch(Exception es){es.printStackTrace();
				}
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();
			}

		}
	labels.put( "caution",caution );
	labels.put( "spl_instruction",spl_instruction );
	labels.put( "spl_instruction2",spl_instruction2 );
	
	return labels;

	}

	public ArrayList getInstructions(String drug_code){
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
			pstmt		= connection.prepareStatement("SELECT B.CAUTION_LABEL_TEXT_ID_1,B.CAUTION_LABEL_TEXT_ID_2, B.SPL_INSTR_LABEL_TEXT_ID,B.SPL_INSTR_LABEL_TEXT_ID1,B.HOW_TO_TAKE_TEXT,B.HOW_TO_TAKE_TEXT_LOCAL FROM PH_DRUG B WHERE  B.DRUG_CODE=? "); 

			pstmt.setString(1,drug_code);
			//pstmt.setString(5,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				instructions_res.add(checkForNull((String)resultSet.getString("CAUTION_LABEL_TEXT_ID_1")));	
				instructions_res.add(checkForNull((String)resultSet.getString("SPL_INSTR_LABEL_TEXT_ID")));	
				sTemptext =java.net.URLEncoder.encode(checkForNull((String)resultSet.getString("HOW_TO_TAKE_TEXT")),"UTF-8"); 
				instructions_res.add(sTemptext);
				//instructions_res.add(checkForNull((String)resultSet.getString("HOW_TO_TAKE_TEXT")));
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			//String tempString ="XX";

			if(instructions_res.size() > 0){	
				//pstmt_int		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDI_EDIT_INT_RESULTS")) ;
				pstmt_int		= connection.prepareStatement("SELECT LABEL_TEXT_1, language_id FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_ID=? and rownum<3 ");
				
				for(int i=0;i<2;i++){					
					if( (!( (((String)instructions_res.get(i))==null) || (((String)instructions_res.get(i)).equals(""))))){
						
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
							//temp.add((String)resultSet.getString("LABEL_TEXT_1"));	
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
						//temp.add((String)resultSet.getString("HOW_TO_TAKE_TEXT"));
						temp.add((String)lang_ids.get(i));
					}
				}

			   //temp.add(instructions_res.get(2));
			 //  temp.add(instructions_res.get(5));
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
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return instructions;
	}


// Taken from DrugMasterBean.java
/*********** Initialize the values for Dispensing Controls TAB ***************/
	/*public HashMap loadLabels(){
		HashMap labels			  = new HashMap();		
		ArrayList caution		  = new ArrayList();
		ArrayList spl_instruction = new ArrayList();
		ArrayList spl_instruction2 = new ArrayList();

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		
		try{
			connection			= getConnection() ;
			/*********** Initialize the values for Caution**************
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
		
		/*********** Initialize the values for Special Instruction**************
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
}*/


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
			closeResultSet(resultSet);
			closeStatement(pstmt);

		}catch ( Exception e ) {
			e.printStackTrace() ;
			
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		
		return fillCode;
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
			remarks		=	checkForNull(resultSet.getString("REMARKS"));		
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
			
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
	return remarks;


	}
  public boolean taperOrders(HashMap data) {
		boolean taper_yn		=	false;

		String taper_dose		=	(String)data.get("TAPPERED_OVER");

		if(taper_dose!=null && taper_dose.equals("Y"))
			taper_yn		=	true;

		return taper_yn;
  }
  public ArrayList populateAllergyDetails(String generic_id,String patient_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		ArrayList details			= new ArrayList();
		HashMap AllergyDetails = null;
		try{
		connection			= getConnection() ;
		sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT58");
		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,generic_id);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,getLanguageId());
		pstmt.setString(4,generic_id);
		pstmt.setString(5,patient_id);
		/*pstmt.setString(6,getLanguageId());
		pstmt.setString(7,generic_id);
		pstmt.setString(8,patient_id);
		pstmt.setString(9,getLanguageId());*/
		resultSet			= pstmt.executeQuery();
		while(resultSet!=null && resultSet.next()){
			AllergyDetails		= new HashMap();	
			AllergyDetails.put("ALLERGY_TYPE_CODE",resultSet.getString("ALLERGY_TYPE_CODE"));
			AllergyDetails.put("ALLERGIC_INDICATIONS",resultSet.getString("ALLERGIC_INDICATIONS"));
			AllergyDetails.put("REAC_DATE",resultSet.getString("REAC_DATE"));
			AllergyDetails.put("ALLERGY_ALERT_BY",checkForNull(resultSet.getString("ALLERGY_ALERT_BY")));// Added for RUT-CRF-0065.1 [IN:43255]
			AllergyDetails.put("CAUSATIVE_SUBSTANCE",checkForNull(resultSet.getString("CAUSATIVE_SUBSTANCE")));// Added for RUT-CRF-0065.1 [IN:43255]
			details.add(AllergyDetails);
		}
			closeResultSet(resultSet);
			closeStatement(pstmt);

		 }catch ( Exception e ) {
			details.add("Error"+e);
			e.printStackTrace() ;

		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		  }
		return details;
	}

	public void genOrderDetails() {
		orderDetails=new ArrayList();
		HashMap drugData = null;
		if(groupRecord.size()>0) {
			ArrayList orderDetailsData=new ArrayList();
			for(int j=0; j<presDetails.size(); j++) {
				drugData=(HashMap) presDetails.get(j);
	//				String record_gen=(String) drugData.get("RECORD_GEN");
				if(taperOrders(drugData)) {
					orderDetailsData.add(drugData);
				} 
				else {
					if(existingGroup(orderDetails,drugData)) {
						//orderDetailsData.add(drugData);
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

	//for checking which reports to be printed based parameter facility setup
	public HashMap getReqdPrintReports(String disp_locn, ArrayList order_ids, String patient_class) throws Exception {
		Connection connection			=  null;
        PreparedStatement pstmt			=  null;
        ResultSet resultSet				=  null;
		String disp_sheet_yn			=	"";
		String bal_sheet_yn				=	"N";
		String label_format_yn			=	"";
		String disp_no					=	"";
		String disp_locn_disp_sheet_yn	=	"";
		String disp_locn_Disp_label_yn	=	"";
		String med_plan	=   "";
		int med_plan_count=0;
		HashMap reqd_reports			=	new HashMap();
		ArrayList disp_nos				=	new ArrayList();

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT49")) ;
			pstmt.setString(1,login_facility_id);
            resultSet	= pstmt.executeQuery() ;

			if(resultSet.next()){
				disp_sheet_yn		=	checkForNull(resultSet.getString("PRINT_DISP_SHEET_OP_YN"));
				bal_sheet_yn		=	checkForNull(resultSet.getString("PRINT_BAL_MED_SHEET_OP_YN"));
				label_format_yn		=	checkForNull(resultSet.getString("LABEL_FORMAT_OP"));
	//			ip_label_format		=	checkForNull(resultSet.getString("IP_LABEL_FORMAT"));
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);
			//Added for  ML-BRU-CRF-072[Inc:29938]--Start
			pstmt		= connection.prepareStatement( "select count(report_id) med_plan  from sm_report where report_id ='PHPRMEDPL'") ;
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				med_plan_count		=	resultSet.getInt("MED_PLAN");
			}
			if(med_plan_count>0)
				med_plan = "Y";
			else
				med_plan = "N";
			closeResultSet(resultSet);
			closeStatement(pstmt);
			//Added for  ML-BRU-CRF-072[Inc:29938] End
//code for checking Dispense location parameters
            pstmt		= connection.prepareStatement( "select DEL_DISP_SHEET_DEFAULT_YN, DEL_DISP_LABEL_DEFAULT_YN from ph_disp_locn where disp_locn_code =?") ;
			pstmt.setString(1,disp_locn);
            resultSet	= pstmt.executeQuery() ;

			if(resultSet.next()){
				disp_locn_disp_sheet_yn		=	checkForNull(resultSet.getString("DEL_DISP_SHEET_DEFAULT_YN"));
				disp_locn_Disp_label_yn		=	checkForNull(resultSet.getString("DEL_DISP_LABEL_DEFAULT_YN"));			
			}
			

			closeResultSet(resultSet);
			closeStatement(pstmt);
			if(disp_sheet_yn.equals("Y")&&disp_locn_disp_sheet_yn.equals("Y")){
				disp_sheet_yn ="Y";
			}else{
				disp_sheet_yn ="N";
			}

			pstmt		= connection.prepareStatement("SELECT disp_no FROM ph_disp_hdr WHERE  order_id=? AND disp_locn_code = ? AND TRUNC(disp_date_time)=TRUNC(SYSDATE) UNION ALL SELECT disp_no FROM ph_disp_cons_dtl WHERE disp_trn_seq_no IN (SELECT disp_trn_seq_no FROM ph_disp_hdr WHERE  order_id=? AND disp_locn_code = ? AND TRUNC(disp_date_time)=TRUNC(SYSDATE)) ORDER BY disp_no") ;	// Query changed for [IN:047652]

			for(int i=0; i<order_ids.size(); i++) {
				pstmt.setString(1,(String)order_ids.get(i));
				pstmt.setString(2,disp_locn.trim());
				pstmt.setString(3,(String)order_ids.get(i));// Added for [IN:047652]
				pstmt.setString(4,disp_locn.trim());		// Added for [IN:047652]
				resultSet	= pstmt.executeQuery() ;

				while(resultSet.next()) {
					disp_no	=	checkForNull(resultSet.getString("DISP_NO"));
				}
				
				if(!disp_no.equals("") && !disp_nos.contains(disp_no)) {
				  disp_nos.add(disp_no);
				}
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
			
	
			if(!label_format_yn.equals(""))
				label_format_yn	=	"Y";
			else
				label_format_yn	=	"N";

			
			Collections.sort(disp_nos);

			reqd_reports.put("disp_no",disp_nos);
			reqd_reports.put("disp_sheet",disp_sheet_yn);
			reqd_reports.put("bal_sheet",bal_sheet_yn);
			reqd_reports.put("label_format",label_format_yn);
			reqd_reports.put("Disp_label_yn",disp_locn_Disp_label_yn);
			reqd_reports.put("med_plan",med_plan); //Added for  ML-BRU-CRF-072[Inc:29938]
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}	
		return reqd_reports;
	}

	public HashMap insert() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		if("Y".equals(getUserAuthPINRequiredYN()))   // Added for RUT-CRF-0035 [IN029926] - Based on this flag, the User ID Captured with PIN will be updated
			login_by_id=getAuthUserID();
		ArrayList mandatory_flds	=	new ArrayList();

		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);

		HashMap tabData	= new HashMap() ;
		HashMap sqlMap		= new HashMap() ;
		HashMap sqlMap1	= new HashMap() ;

		HashMap insertRecords_2		=	null;
		ArrayList headerList			=	null;
		String locale= getLanguageId()==null?"en":getLanguageId();
		Connection connection				= null ;

		try {
		   ArrayList OrderDetails = this.getOrderDetails();
        	for(int i=0;i<OrderID.size();i++){
				headerList		=  new ArrayList();					
				headerList		= (ArrayList) OrderDetails.get(i);
				for(int j=0;j<headerList.size();j++){
					insertRecords_2= new HashMap();
					insertRecords_2=(HashMap) headerList.get(j);
					if((String)insertRecords_2.get("START_DATE") !=null){
						insertRecords_2.put("START_DATE", com.ehis.util.DateUtils.convertDate((String)insertRecords_2.get("START_DATE"), "DMYHM",locale,"en"));
					}
					if((String)insertRecords_2.get("END_DATE") !=null){
						insertRecords_2.put("END_DATE", com.ehis.util.DateUtils.convertDate((String)insertRecords_2.get("END_DATE"), "DMYHM",locale,"en"));
					}
				}
			}

			tabData.put("properties", getProperties() );
			tabData.put("OrderID",this.getOrderID());
			tabData.put("OrderDetails",this.getOrderDetails());
			tabData.put("OrderHeader",this.getpresHeader());
			tabData.put("OrderRemarks",this.OrderRemarks);		
			tabData.put("diag_text",this.diag_text);		
			tabData.put("ScheduleFreq",this.getscheduleFrequency());
			tabData.put("disp_location",this.getDispLocnCode());
			tabData.put("license",(String)(PhLicenceRights.getKey()));
			tabData.put("mandatory_flds",mandatory_flds);
			tabData.put("store_code",this.getStoreCode(displocncode));			 
			tabData.put("prn_remarks",this.prn_remarks);
			tabData.put("LanguageId",getLanguageId());
			tabData.put("BL_INTERFACE_YN",checkforbillinginterface());
			tabData.put("DISP_CASH_COLL_STAGE",disp_cash_coll_stage);

			tabData.put("TOKEN_SERIES_CODE",token_series_code);
			tabData.put("CONSUMABLES_DET", getConsumableDetails());
			tabData.put("facility_id", getLoginFacilityId());
			tabData.put( "login_by_id", login_by_id.trim() );
			tabData.put( "login_at_ws_no",login_at_ws_no.trim());
					

			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT54", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT20A", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT20A") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT19A", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT19A") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT55", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT55") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT56", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT57", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT53", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT1", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT1") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT2", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT2") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT3", "INSERT INTO or_order_line_ph (order_id, order_line_num, generic_id, form_code, trade_code, formulary_item_yn, dosage_type, split_drug_preview, tot_strength, tot_strength_uom, infuse_over, infuse_over_unit, infusion_rate, infusion_vol_str_unit, infusion_per_unit, brought_by_patient_yn, cur_drug_yn, refill_drug_yn, dispensing_loc_type, dispensing_loc, dispensing_store, ip_fill_process, ip_fill_prd_ahead, next_fill_date, last_fill_qty, dispensed_qty, bms_qty, bms_strength, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, split_dose_yn, qty_value_split_dose, qty_unit_split_dose, strength_value, strength_uom, pres_qty_value, pres_qty_uom, allergy_override_reason, dosage_limit_override_reason, duplicate_drug_override_reason, patient_brought_medication_yn, amend_reason_code, amend_reason, pat_couns_reqd_yn, pat_couns_ord_pract_id, bl_incl_excl_override_value, bl_incl_excl_override_reason, build_mar_yn, drug_indication, pregnancy_override_reason, allergy_override_reason_code,dose_limit_over_reason_code,dup_drug_override_reason_code, inter_override_reason_code,lab_inter_override_reason_code,food_intr_override_reason_code,DISEASE_INTER_REASON_CODE,DISEASE_INTER_OVERRIDE_REASON ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,? )" );// Modified for IN:072715 added allergy_override_reason_code,dose_limit_over_reason_code,dup_drug_override_reason_code, inter_override_reason_code,lab_inter_override_reason_code,food_intr_override_reason_code,,DISEASE_INTER_REASON_CODE,DISEASE_INTER_OVERRIDE_REASON Added for MMS-DM-CRF-0229
			//sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT4", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT4") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT4","INSERT INTO PH_PATIENT_DRUG_PROFILE (PATIENT_ID,SRL_NO,FACILITY_ID,ENCOUNTER_ID,PATIENT_CLASS,LOCN_TYPE,LOCN_CODE,ROOM_TYPE,ROOM_NO,BED_NO,BED_CLASS,BED_TYPE,SPECIALITY_CODE,ATTEND_PRACTITIONER_ID,PRES_PRACTITIONER_ID,DRUG_CODE,GENERIC_ID,START_DATE,END_DATE,SPLIT_YN,TAPERED_YN,STRENGTH,STRENGTH_UOM_CODE,DOSAGE,DOSAGE_UOM_CODE,SPLIT_DOSE_PREVIEW,FREQ_CODE,DURATION,PRESCRIBED_QTY,DIAG_TEXT,DRUG_REMARKS,IV_PREP_YN,INFUSE_OVER,INFUSE_OVER_UNIT,INFUSION_RATE,INFUSION_VOL_STR_UNIT,INFUSION_PER_UNIT,AMENDED_YN,AMEND_BY_ID,AMEND_DATE_TIME,CANCEL_YN,CANCEL_BY_ID,CANCEL_DATE_TIME,TRN_TYPE_IND,ORIG_FACILITY_ID,ORIG_ORDER_ID,ORIG_ORDER_LINE_NO,TOT_ISSUED_QTY,BROUGHT_BY_PATIENT_YN,ON_HOLD_DATE_TIME,ON_HOLD_BY_ID,ON_HOLD_REASON_CODE,DISCONT_DATE_TIME,DISCONT_BY_ID,DISCONT_REASON_CODE,STOP_YN,STOP_DATE_TIME,STOP_PRACTITIONER_ID,STOP_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ROUTE_CODE,ALLERGY_OVERRIDE_REASON,DOSAGE_LIMIT_OVERRIDE_REASON,IV_INGREDIENTS,DURN_TYPE,DISPENSED_DRUGS,ALTERNATE_GENERIC_ID,DISP_REMARKS,DUPLICATE_DRUG_OVERRIDE_REASON,REFILL_YN,FORM_CODE,DIAG_CODE1,DIAG_CODE1_CAUSE_IND,DIAG_CODE1_SCHEME,DIAG_CODE2,DIAG_CODE2_CAUSE_IND,DIAG_CODE2_SCHEME,DIAG_CODE3,DIAG_CODE3_CAUSE_IND,DIAG_CODE3_SCHEME,PRESCRIBED_MODE,HEIGHT,HEIGHT_UOM,WEIGHT,WEIGHT_UOM,BSA,ALLERGIC_YN,BMI,INTERACTION_OVERRIDE_REASON,CONTRAIND_OVERRIDE_REASON,DRUG_DB_PRODUCT_ID,PRN_REMARKS, PRN_REMARKS_CODE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT5", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT6", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT6") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT7", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT8", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT8") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT24A", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT24A") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT25A", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT25A") );
			/* 63 has been added for temporary working of the bean.....these values are from ph_drug and hence can be retrieved initially itself */ 
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT64", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT64") );
			sqlMap.put( "SQL_PH_RENEW_PRESCRIPTION_INSERT1",PhRepository.getPhKeyValue("SQL_PH_RENEW_PRESCRIPTION_INSERT1") );
			sqlMap.put( "SQL_PH_RENEW_PRESCRIPTION_INSERT2",PhRepository.getPhKeyValue("SQL_PH_RENEW_PRESCRIPTION_INSERT2") );
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
			sqlMap.put( "SQL_PH_SLIDING_SCALE_SELECT5",PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_SELECT5") );
	//Dispensing queries
			sqlMap1.put( "SQL_PH_DISP_MEDICATION_HRD_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_INSERT") );
			sqlMap1.put( "SQL_PH_DISP_MEDICATION_SELECT33",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT33") );
			sqlMap1.put( "SQL_PH_DISP_MEDICATION_SELECT56",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT56") );
			sqlMap1.put( "SQL_PH_DIR_DISP_EDIT_INSTRUCTIONS",PhRepository.getPhKeyValue("SQL_PH_DIR_DISP_EDIT_INSTRUCTIONS") );
			sqlMap1.put( "SQL_PH_DISP_MEDI_EDIT_INT_RESULTS",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDI_EDIT_INT_RESULTS") );
			sqlMap1.put( "SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT") );
			sqlMap1.put( "SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT") );
			sqlMap1.put( "SQL_PH_DISP_MEDICATION_HRD_UPDATE1",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_UPDATE1") );
			sqlMap1.put( "SQL_PH_DISP_MEDICATION_BL_SELECT1",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1"));

			connection			= getConnection() ;	

			HashMap result = orederinsert( connection,tabData, sqlMap ) ;
			HashMap result1 = null;
			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				 result1  = completeDispensing( connection,tabData, sqlMap1 ) ;
			}
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_PRESCRIPTION") ) ;
			home  = (PrescriptionHome) PortableRemoteObject.narrow( object, PrescriptionHome.class ) ;
			remote = home.create() ;

			HashMap result = remote.insert( tabData, sqlMap ) ;
			//HashMap result = localinsert( tabData, sqlMap ) ;
			*/
			if( ((Boolean) result1.get( "result" )).booleanValue() )	{
				map.put("flag",(String)result1.get("flag"));
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result1.get( "msgid" ),"PH") ) ;
				connection.commit();
				
			}
			else{
				map.put("flag",(String)result1.get("flag"));
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message",result1.get( "message" )) ;
				connection.rollback();
			}
			closeConnection( connection );
		}
		catch(Exception e) {
		    
			e.printStackTrace() ;
		}
		return map ;
	}

//This function will insert data into OR_ORDER,OR_ORDER_LINE,OR_ORDER_LINE_PH,OR_ORDER_COMMENT,OR_ORDER_FIELD_VALUES tables
	public HashMap orederinsert( Connection connection,HashMap tabData, HashMap sqlMap )  {
		HashMap map								= new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "EJB STARTS") ;
		map.put("msgid","INSERT");
	
		//Properties  prop						= null;
		//Connection connection					= null;
		
		ResultSet rset_clob						= null;
		ResultSet resultSet						= null;
		ResultSet resultSet_workload			= null;			
		ResultSet resultSet_trn_group_ref		= null;			
		PreparedStatement pstmt_workload		= null;
		PreparedStatement workload_insert		= null;
		PreparedStatement work_insert_month		= null;
		PreparedStatement work_insert_loc		= null;
		PreparedStatement work_insert_loc_mon	= null;
		PreparedStatement pstmt_select_trn_group_ref= null;
		PreparedStatement pstmt_insert			= null;
		PreparedStatement pstmt					= null;
		PreparedStatement pstmt_clob			= null;
		CallableStatement cstmt_insert			= null;		
		String dly_count						= "";
		String monthly_count					= "";
		String dly_count_loc					= "";
		String monthly_count_loc				= "";
		String patient_Class					= "";
		String allergic_yn						= "N";

		try {
			String login_by_id					=	"";
			String login_at_ws_no				=	"";
			String login_facility_id			=	"";
			ArrayList OrderID					= (ArrayList) tabData.get("OrderID");
			ArrayList OrderDetails				= (ArrayList) tabData.get("OrderDetails");
			ArrayList OrderHeader				= (ArrayList) tabData.get("OrderHeader");
			ArrayList diag_text					= (ArrayList) tabData.get("diag_text");
			ArrayList mandatory_flds			= (ArrayList) tabData.get("mandatory_flds");
			HashMap	ScheduleFreq				= (HashMap) tabData.get("ScheduleFreq");
					prn_remarks					= (HashMap)tabData.get("prn_remarks");	
			String disp_location				= (String)tabData.get("disp_location");
			String prn_remarks_values			= "";	

			if(mandatory_flds.size() > 1) {
				login_by_id						= (String)mandatory_flds.get(0);
				
				login_at_ws_no					= (String)mandatory_flds.get(1);
				login_facility_id				= (String)mandatory_flds.get(2);
			}
			String OrderRemarks					= (String) tabData.get("OrderRemarks");
			String sql_ph_prescription_select53= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT53");//added for AAKH-SCF-0189 [IN:054663]
			String sql_ph_prescription_select20a= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT20A");
			String sql_ph_prescription_select55	= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT55");
			String sql_ph_prescription_select56	= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT56");
			String sql_ph_prescription_select57	= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT57");
			String sql_ph_prescription_select64	= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT64");
			String sql_ph_prescription_select72	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_SELECT72");
			String sql_ph_prescription_select73 = (String) sqlMap.get("SQL_PH_PRESCRIPTION_SELECT73");
			String sql_ph_prescription_select74	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_SELECT74");
			String sql_ph_prescription_select75	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_SELECT75");
//work load queries
			String sql_ph_prescription_modify6	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY6");
			String sql_ph_prescription_modify7	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY7");
			String sql_ph_prescription_modify8	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY8");
			String sql_ph_prescription_modify9	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY9");
			String sql_ph_prescription_insert9	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_INSERT9");
			String sql_ph_prescription_insert10	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_INSERT10");
		    String sql_ph_prescription_insert11	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_INSERT11");
			String sql_ph_prescription_insert12	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_INSERT12");
//ends			
			String sql_insert_1					= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT1");
			String sql_insert_2					= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT2");
			String sql_insert_3					= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT3");
			String sql_insert_4					= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT4");
			String sql_insert_5					= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT5");
			String sql_insert_6					= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT6");
			//String sql_insert_7				    = (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT7");   Removed for IN063877
			String sql_ph_pres_trn_grp_ref_selct= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT");
			int result_insert_5					= 0;
			boolean insert_rec_1				= false;
			boolean insert_rec_2				= false;
			boolean insert_rec_3				= false;
			boolean insert_rec_4				= false;
			boolean insert_rec_5				= false;
			boolean insert_rec_6				= false;
			int seqNo							= 0;


			int srl_NO							=   0;
			String patientId					=   "";
			String facilityId					=   "";
			String patientClass					=   "";
			String locationType					=   "";
			String locationCode					=   "";
			String encounterId					=   "";
			String practId						=   "";
			String order_status					=   "";
			String height						=   "";
			String weight						=   "";
			String bsa							=   "";
			String bmi							=   "";
			String height_unit					=   "";
			String weight_unit					=   "";
			String bsa_unit						=   "";
			String drug_code					=   "";
			String perf_facility				=   "";
			String perf_sys						=   "";
			String perf_deptloc_type			=	"";
			String or_order_status				=   "";
			String header_status				=	"";
			String trn_group_ref				=	"";
			HashMap ord_line					=	new HashMap();
			HashMap order_line_det				=	new HashMap();
			HashMap orderStatusCode				=	new HashMap();
			//connection						= getConnection() ;						
			//connection.setAutoCommit(false);

			pstmt_select_trn_group_ref			= connection.prepareStatement(sql_ph_pres_trn_grp_ref_selct) ;
			resultSet_trn_group_ref				= pstmt_select_trn_group_ref.executeQuery();

			if(resultSet_trn_group_ref!=null && resultSet_trn_group_ref.next()) {
				trn_group_ref = resultSet_trn_group_ref.getString("TRN_GROUP_REF");
			}
			try {
				closeResultSet( resultSet_trn_group_ref );
				closeStatement( pstmt_select_trn_group_ref) ;
			}
			catch(Exception es) {
				es.printStackTrace();
			}


			pstmt	= connection.prepareStatement(sql_ph_prescription_select20a) ;
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				orderStatusCode.put(resultSet.getString("ORDER_STATUS_TYPE"),resultSet.getString("ORDER_STATUS_CODE"));
			}

			closeResultSet(resultSet);
			closeStatement(pstmt);
			pstmt_insert		= connection.prepareStatement(sql_insert_1) ;
			pstmt_insert.clearBatch();
			HashMap insertRecords= new HashMap();
			for (int i=0;i<OrderHeader.size() ;i++ ){
				insertRecords	=	(HashMap)OrderHeader.get(i);
				height			=	(String)insertRecords.get("HEIGHT");
				weight			=	(String)insertRecords.get("WEIGHT");
				bsa				=	(String)insertRecords.get("BSA");
				bmi				=	(String)insertRecords.get("BMI");
				bsa_unit		=	(String)insertRecords.get("BSA_UNIT");
				height_unit		=	(String)insertRecords.get("HEIGHT_UNIT");
				weight_unit		=	(String)insertRecords.get("WEIGHT_UNIT");
				locationType	=	(String)insertRecords.get("LOCN_TYPE");
				locationCode	=	(String)insertRecords.get("LOCN_CODE");
				allergic_yn		=	(String)insertRecords.get("ALLERGIC_YN");
				if(allergic_yn==null)
					allergic_yn	=	"N";
				ArrayList headerList		=  new ArrayList();
				HashMap insertRecords_9		=  new HashMap();
				headerList					=  (ArrayList) OrderDetails.get(i);
				header_status				=  "";
				or_order_status			    =  "";
				insertRecords_9				=  (HashMap) headerList.get(0);
				header_status			    =  (String)insertRecords_9.get("ORDER_STATUS");
				insertRecords_9				=  null;
				if(headerList.size()>1){
					for(int j=1;j<headerList.size();j++){
					      insertRecords_9	=  new HashMap();
					      insertRecords_9	=  (HashMap) headerList.get(j);
					      or_order_status	=  (String)insertRecords_9.get("ORDER_STATUS");  
					   if(Integer.parseInt(header_status) > Integer.parseInt(or_order_status)){
								header_status = or_order_status;
					   }
					}
				}
				pstmt_insert.setString(1,(String)insertRecords.get("ORDER_ID"));
				pstmt_insert.setString(2,(String)insertRecords.get("ORDER_TYPE_CODE"));
				pstmt_insert.setString(3,"PH");
				pstmt_insert.setString(4,"PH");
				pstmt_insert.setString(5,(String)insertRecords.get("PATIENT_ID"));
				     patientId		= (String)insertRecords.get("PATIENT_ID");	
			 
			   patientClass   =(String)insertRecords.get("PATIENT_CLASS");	
                 if(patientClass.equals("EM")){
                      patientClass  ="OP";
				 }else if(patientClass.equals("DC")){
					  patientClass  ="IP";

				 }

				pstmt_insert.setString(6,patientClass);
				   //  patientClass   =(String)insertRecords.get("PATIENT_CLASS");
				pstmt_insert.setString(7,(String)insertRecords.get("FACILITY_ID"));
				facilityId		= (String)insertRecords.get("FACILITY_ID");
				pstmt_insert.setString(8,(String)insertRecords.get("ENCOUNTER_ID"));
				encounterId		=(String)insertRecords.get("ENCOUNTER_ID");
				pstmt_insert.setString(9,(String)insertRecords.get("ENCOUNTER_ID"));
				pstmt_insert.setString(10,"");
				pstmt_insert.setString(11,(String)insertRecords.get("SOURCE_TYPE"));				
				pstmt_insert.setString(12,(String)insertRecords.get("SOURCE_CODE"));
				pstmt_insert.setString(13,(String)insertRecords.get("DISCHARGE_IND"));
				pstmt_insert.setString(14,(String)insertRecords.get("ORDER_DATE_TIME"));
				pstmt_insert.setString(15,(String)insertRecords.get("ORD_PRACT_ID"));
				practId=(String)insertRecords.get("ORD_PRACT_ID");
				pstmt_insert.setString(16,(String)insertRecords.get("PRIORITY"));
				pstmt_insert.setString(17,"N");
				pstmt_insert.setString(18,(String)insertRecords.get("ORD_AUTH_LEVEL"));
				pstmt_insert.setString(19,(String)insertRecords.get("ORD_PRACT_ID"));
				pstmt_insert.setString(20,null);
				pstmt_insert.setString(21,"N");
				pstmt_insert.setString(22,(String)insertRecords.get("ORD_APPR_BY_USER_ID"));
				pstmt_insert.setString(23,null);
				
				pstmt_insert.setString(24,"N");				
				pstmt_insert.setString(25,"");
				pstmt_insert.setString(26,"");
				pstmt_insert.setString(27,null);
				pstmt_insert.setString(28,null);
				pstmt_insert.setString(29,"N");
				pstmt_insert.setString(30,(String)insertRecords.get("CONT_ORDER_IND"));
               	perf_facility			=	(String)insertRecords.get("FACILITY_ID");
				pstmt_insert.setString(31,perf_facility);
				pstmt_insert.setString(32,perf_sys);
				pstmt_insert.setString(33,perf_deptloc_type);
				pstmt_insert.setString(34,disp_location);
				pstmt_insert.setString(35,"");
				pstmt_insert.setString(36,"N");
				pstmt_insert.setString(37,(String)insertRecords.get("CHILD_ORDER_YN"));
				pstmt_insert.setString(38,(String)insertRecords.get("PARENT_ORDER_ID"));
				pstmt_insert.setString(39,"N");
				pstmt_insert.setString(40,"");
				pstmt_insert.setString(41,"");
				pstmt_insert.setString(42,"");
				/*
					10   ---->  OUTSTANDING ORDER
				    60   ---->  COMPLETED ORDER
					55   ---->  PARTIALY DISPNSED ORDER(with BMS) 
				*/
				order_status		= header_status;

				if(order_status.equals("10")){
					order_status=(String) orderStatusCode.get("10");
				}else if(order_status.equals("56")){
					order_status= (String)orderStatusCode.get("56");
				}else if(order_status.equals("58")){
					order_status= (String)orderStatusCode.get("58");
				}
				pstmt_insert.setString(43,order_status);
				pstmt_insert.setString(44,"");
				pstmt_insert.setString(45,login_by_id);
				pstmt_insert.setString(46,login_at_ws_no);
				pstmt_insert.setString(47,login_facility_id);
				pstmt_insert.setString(48,login_by_id);
				pstmt_insert.setString(49,login_at_ws_no);
				pstmt_insert.setString(50,login_facility_id);
				pstmt_insert.setString(51,"N");
				pstmt_insert.setString(52,"");
				pstmt_insert.setString(53,null);
				pstmt_insert.setString(54,"");
				pstmt_insert.setString(55,"");
				pstmt_insert.setString(56,"");
				pstmt_insert.setString(57,"");
				pstmt_insert.setString(58,"");
				pstmt_insert.setString(59,"");
				pstmt_insert.setString(60,"");
				pstmt_insert.setString(61,trn_group_ref);
				//pstmt_insert.setString(62,""); //ML-MMOH-CRF-1823 - 43528
				pstmt_insert.addBatch();
			}

			int[] result_insert= pstmt_insert.executeBatch();
			
			for (int i=0;i<result_insert.length ;i++ ) {
				if(result_insert[i]<0  && result_insert[i] != -2 ){
					insert_rec_1=false;
					break;
				}
				else{
					insert_rec_1=true;
				}
			}
			closeStatement(pstmt_insert);
			if(insert_rec_1){
				ArrayList headerList	=	new ArrayList();
				pstmt_insert			=	connection.prepareStatement(sql_insert_2) ;
				pstmt_insert.clearBatch();
				
				HashMap tempHeader				=	null;
				String ord_date_time			=	null;
				String priority					=	null;
				String ord_pract_id				=	null;				                  
				String order_id					=	null;
				HashMap insertRecords_2			=	null;
				String sdesc					=	null;
				String dosage_type				=	null;
				String qty_value				=	null;
				float    tot_qty_value			=	0;
				String qty_unit					=	null;
				String strength_value			=	null;
				String strength_uom				=	null;
				String fract_dose				=	null;
				String in_qty_unit				=	null; 
				String in_order_qty				=	null; 
				String in_order_uom				=	null; 
				String line_status				=	null;
				String Priority                 =   null;
				String split_dose_yn_val        =   "N";
				String qty_value_1				=   null;
				float  qty_value_2				=   0;
				String freq_nature				=   "";
				pstmt	= connection.prepareStatement(sql_ph_prescription_select64) ;
			    PreparedStatement pstmt_am_uom_eqvl	= connection.prepareStatement(sql_ph_prescription_select53) ;//added for AAKH-SCF-0189 [IN:054663]
				HashMap chkValuescheduleFrequency=ScheduleFreq;
				ArrayList schedule = new ArrayList();
				String repeat_value ="", pres_base_uom="", equl_value="1", durn_value="", content_in_pres_base_uom="", strength_per_value_per_pres_uom="", strength_per_pres_uom="", tmp_qty="";
				ArrayList dose_list = null;						
				double interval_value = 1;
				float ord_qty	=	0.0f;
				float durn_value_calc			=	1;

				for(int i=0;i<OrderID.size();i++){
					headerList		=  new ArrayList();
					tempHeader		= (HashMap) OrderHeader.get(i);
					ord_date_time	= (String)tempHeader.get("ORDER_DATE_TIME");
					priority		= (String)tempHeader.get("PRIORITY");
					ord_pract_id	= (String)tempHeader.get("ORD_PRACT_ID");
					
					
					order_id		= (String) OrderID.get(i);
					headerList		= (ArrayList) OrderDetails.get(i);
					ord_line		=	new HashMap();
					for(int j=0;j<headerList.size();j++){
						insertRecords_2= new HashMap();
						insertRecords_2=(HashMap) headerList.get(j);

						pstmt_insert.setString(1,order_id);
						pstmt_insert.setString(2,""+(j+1));						
						pstmt_insert.setString(3,(String)insertRecords_2.get("DRUG_CODE"));
						ord_line.put(((String)insertRecords_2.get("DRUG_CODE")+(String)insertRecords_2.get("SRL_NO")),""+(j+1));						

						drug_code=(String)insertRecords_2.get("DRUG_CODE");		
						pstmt_insert.setString(4,(String)insertRecords_2.get("SHORT_DESC"));
						sdesc="";
						sdesc=(String)insertRecords_2.get("SHORT_DESC");
						if (sdesc!=null && !sdesc.equals("") && sdesc.length()>40){
							sdesc=sdesc.substring(0,40);
						}
						pstmt_insert.setString(5,sdesc);
						pstmt_insert.setString(6,"");
						pstmt_insert.setString(7,(String)insertRecords_2.get("ORDER_TYPE_CODE"));
						pstmt_insert.setString(8,"PH");
						pstmt_insert.setString(9,ord_date_time);
                        if( insertRecords_2.get("PRIORITY")==null){
                           Priority="R";
						}
						else{ 
							if(insertRecords_2.get("PRIORITY").equals("Routine")||insertRecords_2.get("PRIORITY").equals("R")){
                               Priority="R";
						    }
							else{
                               Priority="U";
						    }
						}
						
                        pstmt_insert.setString(10,Priority);
						if(insertRecords_2.get("ORD_AUTH_REQD_YN")==null) {
							pstmt_insert.setString(11,"N");
						} 
						else {
							pstmt_insert.setString(11,(String)insertRecords_2.get("ORD_AUTH_REQD_YN"));
						}
						pstmt_insert.setString(12,"");
						pstmt_insert.setString(13,"N");
						pstmt_insert.setString(14,"N");
						pstmt_insert.setString(15,(String)insertRecords_2.get("START_DATE"));
						pstmt_insert.setString(16,(String)insertRecords_2.get("FORM_CODE"));
						pstmt_insert.setString(17,(String)insertRecords_2.get("ROUTE_CODE"));

						dosage_type		=(String)insertRecords_2.get("DOSAGE_TYPE");
						qty_value			=(String)insertRecords_2.get("QTY_VALUE");
						qty_unit			=(String)insertRecords_2.get("QTY_DESC_CODE");
						strength_value		=(String)insertRecords_2.get("ACT_STRENGTH_VALUE");
						strength_uom		=(String)insertRecords_2.get("STRENGTH_UOM");
						freq_nature		=(String)insertRecords_2.get("FREQ_NATURE");
						fract_dose			=(String)insertRecords_2.get("FRACT_DOSE_ROUND_UP_YN");
						repeat_value		=	(String)insertRecords_2.get("REPEAT_VALUE"); //added for AAKH-SCF-0189 [IN:054663] -start
						interval_value	=	Float.parseFloat((String)insertRecords_2.get("INTERVAL_VALUE")==null?"1":(String)insertRecords_2.get("INTERVAL_VALUE"));
						pres_base_uom	=	(String)insertRecords_2.get("PRES_BASE_UOM");
						durn_value		=	(String)insertRecords_2.get("DURN_VALUE");
						content_in_pres_base_uom			=	(String)insertRecords_2.get("CONTENT_IN_PRES_BASE_UOM");
						qty_value							=	(String)insertRecords_2.get("QTY_VALUE"); //added for AAKH-SCF-0189 [IN:054663] -end
						strength_per_value_per_pres_uom		=	(String)insertRecords_2.get("STRENGTH_PER_VALUE_PRES_UOM");
						strength_per_pres_uom		=	(String)insertRecords_2.get("STRENGTH_PER_PRES_UOM");

						in_qty_unit			="";
						in_order_qty			="";
						in_order_uom			="";
						split_dose_yn_val      ="N";
						qty_value_1			="";
						if(freq_nature.equals("F") || freq_nature.equals("I"))  //added for AAKH-SCF-0189 [IN:054663]
							durn_value_calc	=	(float)Math.ceil(Float.parseFloat(durn_value)/ interval_value);
						else
							durn_value_calc = Float.parseFloat(durn_value);
						 
						chkValuescheduleFrequency=ScheduleFreq;
						schedule = new ArrayList();
						if(chkValuescheduleFrequency.size()>0){
							if(chkValuescheduleFrequency.containsKey((String)insertRecords_2.get("DRUG_CODE")+(String)insertRecords_2.get("SRL_NO")))
								schedule = (ArrayList) chkValuescheduleFrequency.get((String)insertRecords_2.get("DRUG_CODE")+(String)insertRecords_2.get("SRL_NO"));
						}
						if(insertRecords_2.containsKey("SPLIT_DOSE_YN_VAL")){
                            split_dose_yn_val=(String)insertRecords_2.get("SPLIT_DOSE_YN_VAL");
						}
						else{
							split_dose_yn_val="N";
						}
																
						if(dosage_type.equals("A")||freq_nature.equals("P")||freq_nature.equals("O")){
						  qty_value_1        =  qty_value;
						}
						if(schedule!=null && schedule.size() > 0){
							dose_list	= (ArrayList)schedule.get(4);	
						}
						if(schedule.size() > 0 && (split_dose_yn_val.equals("N")) ) {
							if(fract_dose.equals("N")) { 
								 qty_value		=	(String)dose_list.get(0);
								 if(qty_value==null || qty_value.equals("")||qty_value.equals("0"))
									qty_value="1";
								 qty_value_1    =  qty_value;	 
							}
							else{
								if(dosage_type.equals("S")){
								   qty_value		=	(String)dose_list.get(0);
								 if(qty_value==null || qty_value.equals("")||qty_value.equals("0"))
										qty_value="1";
								   qty_value_1      =   qty_value;
								   //qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";//commented for AAKH-SCF-0189 [IN:054663]
								}
								else if(dosage_type.equals("Q")){
									qty_value		=	(String)dose_list.get(0);
								 if(qty_value==null || qty_value.equals("")||qty_value.equals("0"))
										qty_value="1";
									qty_value_1     =   qty_value;
									//qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";//commented for AAKH-SCF-0189 [IN:054663]
								}  									 
								//qty_value          =   (Math.ceil(Float.parseFloat(qty_value)*dose_list.size()))+"";    //commented for AAKH-SCF-0189 [IN:054663]
								repeat_value	=	""+dose_list.size();
							}
					   }
					   else if(dose_list!=null && schedule.size() > 0 && (split_dose_yn_val.equals("Y")) ) {
							tot_qty_value       = 0;
							qty_value_2			= 0;
							if(fract_dose.equals("N")) {
								for(int tqI=0;tqI<dose_list.size();tqI++){
									repeat_value	=	"1";
									tot_qty_value	=	tot_qty_value+Float.parseFloat((String)dose_list.get(tqI));
								}
								qty_value_1        =  tot_qty_value+"";
							}
							else{
								for(int n=0; n<dose_list.size(); n++) {
									repeat_value		=	"1";
									if(dosage_type.equals("S")){
										qty_value		=	(String)dose_list.get(n);
										qty_value_1		=	Float.parseFloat(qty_value_1)+Float.parseFloat(qty_value)+"";

										qty_value       =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";
										qty_value_2     +=  (Math.ceil(Float.parseFloat(qty_value)*Float.parseFloat(strength_value)));
										qty_value       =   Float.parseFloat(qty_value)*Float.parseFloat(strength_value)+"";    
									}
									else if(dosage_type.equals("Q")){
										qty_value		=	(String)dose_list.get(n);
										qty_value_1     =   Float.parseFloat(qty_value_1)+Float.parseFloat(qty_value)+"";
										qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
										qty_value_2    +=   Float.parseFloat(qty_value);

									}  
									tot_qty_value    =  tot_qty_value+Float.parseFloat(qty_value);
								}
							}  
							qty_value          =  tot_qty_value+"";
					    }

						if((dosage_type!=null && dosage_type.equals("A")) || (freq_nature!=null && freq_nature.equals("P"))){
							if(freq_nature!=null && freq_nature.equals("P")) {
								in_qty_unit=qty_unit;
								if(insertRecords_2.get("ABSOL_QTY")==null || ((String)insertRecords_2.get("ABSOL_QTY")).equals("0")) {
									if(insertRecords_2.get("PRN_DOSES_PRES_PRD_FILL")==null || ((String)insertRecords_2.get("PRN_DOSES_PRES_PRD_FILL")).equals("0")) {
										in_order_qty	= "1";
									}
									else{
										in_order_qty	= ((String)insertRecords_2.get("PRN_DOSES_PRES_PRD_FILL"));
									}
								}
								else{
									in_order_qty	= ((String)insertRecords_2.get("ABSOL_QTY"));
								}								
								in_order_uom		=	qty_unit;
							}
							else{
								in_qty_unit=qty_unit;
								in_order_qty=(((String)insertRecords_2.get("ABSOL_QTY")==null)?"1":(String)insertRecords_2.get("ABSOL_QTY"));
								in_order_uom=qty_unit;
							}
							qty_value_1 = (String)insertRecords_2.get("QTY_VALUE")==null?"0":(String)insertRecords_2.get("QTY_VALUE");
						}  //end of logic
						else if(dosage_type!=null && dosage_type.equals("Q")){//added for AAKH-SCF-0189 [IN:054663] -end
							pstmt_am_uom_eqvl	= connection.prepareStatement(sql_ph_prescription_select53) ;
							pstmt_am_uom_eqvl.setString(1,pres_base_uom);
							pstmt_am_uom_eqvl.setString(2,qty_unit);
							pstmt_am_uom_eqvl.setString(3,pres_base_uom);
							pstmt_am_uom_eqvl.setString(4,qty_unit);
							resultSet	= pstmt_am_uom_eqvl.executeQuery();
							if ( resultSet != null && resultSet.next() )
								equl_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
							closeStatement( pstmt_am_uom_eqvl) ;
							closeResultSet( resultSet );

							in_qty_unit		=	qty_unit;
							if( (qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
								if(!fract_dose.equals("Y")) {
									ord_qty		=	Float.parseFloat(qty_value)*durn_value_calc*Integer.parseInt(repeat_value) *Float.parseFloat(equl_value);
									ord_qty		=	Float.parseFloat(Math.ceil(ord_qty/(Float.parseFloat(content_in_pres_base_uom)))+"");
									if(ord_qty==0)
										ord_qty	=	1;
								}
								else {
									qty_value		=   (Math.ceil((Float.parseFloat(qty_value))/(Float.parseFloat(content_in_pres_base_uom))))*(Float.parseFloat(content_in_pres_base_uom))+"";
									if((Float.parseFloat(qty_value)*Float.parseFloat(equl_value)) < Float.parseFloat(content_in_pres_base_uom))
										tmp_qty	=	1+"";
									else{ 
										if(Float.parseFloat(content_in_pres_base_uom)<1) 
											tmp_qty	=  Math.ceil(Float.parseFloat(qty_value)/(Float.parseFloat(equl_value)*Float.parseFloat(content_in_pres_base_uom)))+"";
										else
											tmp_qty	=  Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(equl_value))/Float.parseFloat(content_in_pres_base_uom))+"";
									}
									ord_qty	=  Float.parseFloat(tmp_qty) *durn_value_calc*Float.parseFloat(repeat_value) ;
									if((Float.parseFloat(qty_value)*Float.parseFloat(equl_value)) < Float.parseFloat(content_in_pres_base_uom)){
										ord_qty	=  Float.parseFloat(Math.ceil(ord_qty/Float.parseFloat(content_in_pres_base_uom))+"");
									}
								}
							}
							in_order_qty=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
							in_order_uom=qty_unit;
						}
						else if(dosage_type!=null && dosage_type.equals("S")){
							in_qty_unit=qty_unit;
							if( (qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){	
								if(!fract_dose.equals("Y")) {	
									ord_qty		=Float.parseFloat(qty_value)*durn_value_calc*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom);
									ord_qty		=new Double(Math.ceil(new Double(ord_qty/(Float.parseFloat(content_in_pres_base_uom)* Float.parseFloat(strength_per_pres_uom))).doubleValue())).floatValue();
								}
								else {
									double unit_qty	= 1.0;
									float unit_dose_qty =(Float.parseFloat(strength_per_value_per_pres_uom) /Float.parseFloat(strength_per_pres_uom))*Float.parseFloat(qty_value);

									if(freq_nature.equals("O") ||unit_dose_qty == Float.parseFloat(content_in_pres_base_uom) || (unit_dose_qty % Float.parseFloat(content_in_pres_base_uom)) == 0)
										unit_qty	=   Double.parseDouble(qty_value)/Double.parseDouble(strength_per_pres_uom);
									else
										unit_qty	=   Math.ceil(Double.parseDouble(qty_value)/Double.parseDouble(strength_per_pres_uom));
									tmp_qty			=   (unit_qty * durn_value_calc * Integer.parseInt(repeat_value))+"";
									ord_qty			=(float)  Float.parseFloat(tmp_qty)*Float.parseFloat(strength_per_value_per_pres_uom) /Float.parseFloat(content_in_pres_base_uom);
								}
							}
							in_order_qty=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
							in_order_uom=pres_base_uom;
						}//added for AAKH-SCF-0189 [IN:054663] -end
						String sliding_scale_yn	=	(String)insertRecords_2.get("SLIDING_SCALE_YN");
						in_qty_unit		=   qty_unit;
						if(sliding_scale_yn!=null && sliding_scale_yn.equals("Y")){
							in_qty_unit	    =	strength_uom;
						}
						pstmt_insert.setString(18,qty_value_1);
						pstmt_insert.setString(19,in_qty_unit);
						pstmt_insert.setString(20,(String)insertRecords_2.get("FREQ_CODE"));
						pstmt_insert.setString(21,(String)insertRecords_2.get("DURN_VALUE"));
						//pstmt_insert.setString(22,(String)insertRecords_2.get("DURN_TYPE"));
						pstmt_insert.setString(22,(String)insertRecords_2.get("DURN_DESC"));
						String line_display_text="";
						//line_display_text="";
						pstmt_insert.setString(23,line_display_text);
						pstmt_insert.setString(24,"");
						pstmt_insert.setString(25,null);
						pstmt_insert.setString(26,(String)insertRecords_2.get("END_DATE"));			
						pstmt_insert.setString(27,null);
						//Execute  query no 63 and get corresponding stock qty and uom
						String stkuom	=	"";					
						pstmt.setString(1,dosage_type);
						pstmt.setString(2,in_order_qty);
						pstmt.setString(3,in_order_qty);
						pstmt.setString(4,drug_code);
						pstmt.setString(5,getLanguageId());
						pstmt.setString(6,getLanguageId());
						pstmt.setString(7,getLanguageId());
						pstmt.setString(8,getLanguageId());
						pstmt.setString(9,getLanguageId());
						resultSet=pstmt.executeQuery();	
						if (resultSet.next()){							
							stkuom=(String)resultSet.getString("stock_uom");	
							if (stkuom!=null && !stkuom.equals("")){
								in_order_uom=stkuom;
							}
						}
								
						insertRecords_2.put("in_order_uom",in_order_uom);
						pstmt_insert.setString(28,in_order_qty);//(String)insertRecords_2.get("ORD_QTY")); -changed for AAKH-SCF-0189 [IN:054663]
						pstmt_insert.setString(29,in_order_uom.trim());
						ord_line.put(((String)insertRecords_2.get("DRUG_CODE")+(String)insertRecords_2.get("SRL_NO"))+"UOM",in_qty_unit);
						order_line_det.put(order_id,ord_line);
						pstmt_insert.setString(30,"N");
						pstmt_insert.setString(31,null);
						pstmt_insert.setString(32,"");
						pstmt_insert.setString(33,"N");
						pstmt_insert.setString(34,"N");
						pstmt_insert.setString(35,"N");

						if( insertRecords_2.get("NO_REFILL")!=null && (!((String)insertRecords_2.get("NO_REFILL")).equals("") )){
							pstmt_insert.setString(36,"CR");
							pstmt_insert.setString(37,"Y");
						}
						else{
							pstmt_insert.setString(36,"CO");
							pstmt_insert.setString(37,"N");
						}

						pstmt_insert.setString(38,(String)insertRecords_2.get("NO_REFILL"));
						String child_order_yn =(String)tempHeader.get("CHILD_ORDER_YN");
						pstmt_insert.setString(39,child_order_yn);
						String parent_order_id =(String)tempHeader.get("PARENT_ORDER_ID");
						pstmt_insert.setString(40,parent_order_id);
						pstmt_insert.setString(41,"");
						pstmt_insert.setString(42,"");
						pstmt_insert.setString(43,"");
						pstmt_insert.setString(44,ord_pract_id);
						pstmt_insert.setString(45,null);
						pstmt_insert.setString(46,"");
						pstmt_insert.setString(47,null);
						pstmt_insert.setString(48,"");
						pstmt_insert.setString(49,null);
						pstmt_insert.setString(50,"");
						pstmt_insert.setString(51,null);
						pstmt_insert.setString(52,"");
						pstmt_insert.setString(53,null);
						pstmt_insert.setString(54,"");
						pstmt_insert.setString(55,null);
						pstmt_insert.setString(56,"");
						pstmt_insert.setString(57,"");

						 order_status		    =(String)insertRecords_2.get("ORDER_STATUS");
						 line_status			=	"";						
						if(order_status.equals("58")){
							line_status= (String)orderStatusCode.get("58");
						}
						else if(order_status.equals("56")){
							line_status=(String) orderStatusCode.get("56");
						}
						else if(order_status.equals("10")){
							line_status=(String) orderStatusCode.get("10");
						}				

						pstmt_insert.setString(58,line_status);
						pstmt_insert.setString(59,"");
						pstmt_insert.setString(60,login_by_id);
						pstmt_insert.setString(61,login_at_ws_no);
						pstmt_insert.setString(62,login_facility_id);
						pstmt_insert.setString(63,login_by_id);
						pstmt_insert.setString(64,login_at_ws_no);
						pstmt_insert.setString(65,login_facility_id);
						pstmt_insert.setString(66,"N");
						pstmt_insert.setString(67,"");
						String ddesc="";
						ddesc=(String)insertRecords_2.get("DRUG_DESC");
						if (ddesc!=null && !ddesc.equals("") && ddesc.length()>40){
							ddesc=ddesc.substring(0,40);
						}
						pstmt_insert.setString(68,ddesc);
						pstmt_insert.setString(69,ddesc);
						pstmt_insert.setString(70,"N");
						//pstmt_insert.setString(71,"");//ML-MMOH-CRF-1823 - 43528 
						pstmt_insert.addBatch();
					}
				}
			
				int[] result_insert_2= pstmt_insert.executeBatch();
				for (int i=0;i<result_insert_2.length ;i++ ){
					if(result_insert_2[i]<0  && result_insert_2[i] != -2 ){
						insert_rec_2=false;
						break;
					}
					else{
						insert_rec_2=true;
					}
				}			
			}
			closeStatement(pstmt_insert);
			closeResultSet(resultSet);
			closeStatement(pstmt);

		   if(insert_rec_2){
				ArrayList headerList=new ArrayList();
				pstmt_insert	= connection.prepareStatement(sql_insert_3) ;
				pstmt_insert.clearBatch();
				
				String order_id=	null;
				HashMap insertRecords_3=	null;
				String dosage_type			=	null;
				String qty_value			=	null;
				String repeat_value			=	null;
				String durn_value			=	null;
				String strength_value		=	null;
				String strength_uom			=	null;
				String pres_base_uom		=	null;
				String in_tot_strength		=	null;
				String split_dose_yn_val	=   "";
				String fract_dose			=   "N";
				String pack_size			=	"";
				String bms_strength			=	"";
				String alloc_bms_qty		=	"";	
				String repeat_durn_type1	=	"";	
				String durn_desc1			=	"";	
				String tmp_durn_value		=	"";	
				float  tot_qty_value        =	0;
				float  qty_value_2			=   0;
				String in_order_uom				=	""; 
			
				for(int i=0;i<OrderID.size();i++){
					headerList=new ArrayList();
					order_id=(String) OrderID.get(i);
					headerList=(ArrayList) OrderDetails.get(i);
					for(int j=0;j<headerList.size();j++){
						insertRecords_3= new HashMap();
						insertRecords_3=(HashMap) headerList.get(j);
						pstmt_insert.setString(1,order_id);
						pstmt_insert.setString(2,""+(j+1));
						 dosage_type		=  (String)insertRecords_3.get("DOSAGE_TYPE");
						 qty_value			=  (String)insertRecords_3.get("QTY_VALUE");
						 repeat_value		=  (String)insertRecords_3.get("REPEAT_VALUE");
						 durn_value			=  (String)insertRecords_3.get("DURN_VALUE");
						 strength_value		=  (String)insertRecords_3.get("ACT_STRENGTH_VALUE");
						 strength_uom		=  (String)insertRecords_3.get("STRENGTH_UOM");
						 pres_base_uom		=  (String)insertRecords_3.get("PRES_BASE_UOM");
						 fract_dose			=  (String)insertRecords_3.get("FRACT_DOSE_ROUND_UP_YN");
						 repeat_durn_type1  =  (String)insertRecords_3.get("REPEAT_DURN_TYPE");
						 durn_desc1			=  (String)insertRecords_3.get("DURN_DESC");
						 pack_size	        =  (String)insertRecords_3.get("CONTENT_IN_PRES_BASE_UOM");
						 tmp_durn_value     =  (String)insertRecords_3.get("TMP_DURN_VALUE")==null?durn_value:(String)insertRecords_3.get("TMP_DURN_VALUE");
						if(!repeat_durn_type1.equals(durn_desc1))
							durn_value		=	tmp_durn_value;
						drug_code=(String)insertRecords_3.get("DRUG_CODE");	
						if(dosage_type.equals("A")){
                            in_order_uom= (String)insertRecords_3.get("STOCK_UOM");
						}else{
							in_order_uom= pres_base_uom;
						}
						pstmt_insert.setString(3,(String)insertRecords_3.get("GENERIC_ID"));
						pstmt_insert.setString(4,(String)insertRecords_3.get("FORM_CODE"));
						pstmt_insert.setString(5,(String)insertRecords_3.get("TRADE_CODE"));
						//pstmt_insert.setString(6,"N"); Commented for MMS-SCF-0374 [ IN 050039 ]
						pstmt_insert.setString(6,(String)insertRecords_3.get("IN_FORMULARY_YN"));//Added for MMS-SCF-0374 [ IN 050039 ]
						pstmt_insert.setString(7,(String)insertRecords_3.get("DOSAGE_TYPE"));
						pstmt_insert.setString(8,"");

					    HashMap chkValuescheduleFrequency=ScheduleFreq;
						ArrayList schedule = new ArrayList();

						if(chkValuescheduleFrequency.size()>0){
							if(chkValuescheduleFrequency.containsKey((String)insertRecords_3.get("DRUG_CODE")+(String)insertRecords_3.get("SRL_NO")))
								schedule = (ArrayList) chkValuescheduleFrequency.get((String)insertRecords_3.get("DRUG_CODE")+(String)insertRecords_3.get("SRL_NO"));
						}

						if(insertRecords_3.containsKey("SPLIT_DOSE_YN_VAL")){

						     split_dose_yn_val=(String)insertRecords_3.get("SPLIT_DOSE_YN_VAL");
							 if(split_dose_yn_val==null || split_dose_yn_val.equals("null"))
								split_dose_yn_val="N";
						}else{
							  split_dose_yn_val="N";
						}

                    if(schedule.size() > 0 && (split_dose_yn_val.equals("N")) ) {
							ArrayList dose_list	= (ArrayList)schedule.get(4);
							if(fract_dose.equals("N")) { 
								 //HashMap detail	=	(HashMap)schedule.get(0);							
								 //qty_value		=	(String)detail.get("admin_qty");
								 qty_value		=	(String)dose_list.get(0);
								 if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1";
							}else{
								  //HashMap detail	=	(HashMap)schedule.get(0);
								 if(dosage_type.equals("S")){
								   qty_value		=	(String)dose_list.get(0);
								   if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1";
								   qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";
								 }else if(dosage_type.equals("Q")){
									qty_value		=	(String)dose_list.get(0);
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1";
									qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";								
								 }  							 
								 qty_value          =   (Math.ceil(Float.parseFloat(qty_value)*dose_list.size()))+"";    
							}

                           repeat_value	=	""+dose_list.size();

					}else  if(schedule.size() > 0 && (split_dose_yn_val.equals("Y")) ) {
							ArrayList dose_list	= (ArrayList)schedule.get(4);
							tot_qty_value       = 0;
							qty_value_2			= 0;
							if(fract_dose.equals("N")) {
								String final_qty	=	"";
								//for(int n=0; n<schedule.size(); n++) {
								for(int n=0; n<dose_list.size(); n++) {
								 repeat_value		=	"1";
								 final_qty	=	(String)dose_list.get(n);
								 //HashMap  detail	=  (HashMap)schedule.get(n);
								 //tot_qty_value		=  tot_qty_value+Float.parseFloat((String)detail.get("admin_qty"));
								 if(!(final_qty.equals("")||final_qty.equals("0")||final_qty==null))
									tot_qty_value		=  tot_qty_value+Float.parseFloat((String)dose_list.get(n));
								 else
									tot_qty_value		=  tot_qty_value+1;
								}
							}else{
								//for(int n=0; n<schedule.size(); n++) {
								for(int n=0; n<dose_list.size(); n++) {
									repeat_value		=	"1";
									//HashMap  detail	=  (HashMap)schedule.get(n);
									if(dosage_type.equals("S")){
										//qty_value		=	(String)detail.get("admin_qty");
										qty_value		=	(String)dose_list.get(n);
										if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1";
										qty_value		=   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";
										qty_value_2     +=   (Math.ceil(Float.parseFloat(qty_value)*Float.parseFloat(strength_value)));									 
									}else if(dosage_type.equals("Q")){
										//qty_value		=	(String)detail.get("admin_qty");								   
										qty_value		=	(String)dose_list.get(n);								  if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1";
										qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
										qty_value_2    +=  Float.parseFloat(qty_value);
									}  							   
									tot_qty_value    =  tot_qty_value+Float.parseFloat(qty_value);
								}
							}  							  
							qty_value          =  tot_qty_value+"";
					}
			
                
				   if(split_dose_yn_val.equals("N")){
                     if(fract_dose.equals("N")) { 
						if(dosage_type.equals("S")){
                        in_tot_strength   = "";
					    in_tot_strength   =  (Float.parseFloat(qty_value)* Float.parseFloat(durn_value))*(Integer.parseInt(repeat_value))+"";
						}else if(dosage_type.equals("Q")){
                         in_tot_strength   = "";
					    in_tot_strength   =  (Float.parseFloat(qty_value)* Float.parseFloat(durn_value))*((Integer.parseInt(repeat_value))*(Float.parseFloat(strength_value)))+"";
						}
					 }else{						
                       in_tot_strength   = "";
                       in_tot_strength   =  ((Float.parseFloat(qty_value)* Float.parseFloat(durn_value))*(Float.parseFloat(strength_value)))+"";					
					 }
				   }else{
                      in_tot_strength  ="";
					  in_tot_strength  = ( (Float.parseFloat(qty_value)* Float.parseFloat(durn_value))*(Float.parseFloat(strength_value)))+"";
				   }
					
						pstmt_insert.setString(9,in_tot_strength);
						pstmt_insert.setString(10,strength_uom);
						pstmt_insert.setString(11,"");
						pstmt_insert.setString(12,"");
						pstmt_insert.setString(13,"");
						pstmt_insert.setString(14,"");
						pstmt_insert.setString(15,"");
						pstmt_insert.setString(16,"N");
						if(insertRecords_3.get("NO_REFILL")!=null && (!((String)insertRecords_3.get("NO_REFILL")).equals("") )){
							
							pstmt_insert.setString(17,"Y");
							pstmt_insert.setString(18,"Y");
						}else{
							pstmt_insert.setString(17,"N");
							pstmt_insert.setString(18,"N");
						}
						pstmt_insert.setString(19,"");
						pstmt_insert.setString(20,"");
						pstmt_insert.setString(21,"");
						pstmt_insert.setString(22,"");
						pstmt_insert.setString(23,"");
						pstmt_insert.setString(24,null);
						pstmt_insert.setString(25,"");
					
						pstmt_insert.setString(26,(String)insertRecords_3.get("TOT_ALLOC_QTY"));						
						alloc_bms_qty  = (String)insertRecords_3.get("ALLOC_BMS_QTY");
						bms_strength   = "";
					
						pstmt_insert.setString(27,alloc_bms_qty);
                 //code for calculating bms strength
						if(alloc_bms_qty!=null && !alloc_bms_qty.equals("")){
                         bms_strength = ((Float.parseFloat(alloc_bms_qty))*(Float.parseFloat(strength_value))*(Float.parseFloat(pack_size) ))+"";
						}
                 //ends
	     				pstmt_insert.setString(28,bms_strength);				
						pstmt_insert.setString(29,login_by_id);
						pstmt_insert.setString(30,login_at_ws_no);
						pstmt_insert.setString(31,login_facility_id);
						pstmt_insert.setString(32,login_by_id);
						pstmt_insert.setString(33,login_at_ws_no);
						pstmt_insert.setString(34,login_facility_id);						
                        pstmt_insert.setString(35,split_dose_yn_val); 

						if( split_dose_yn_val.equals("Y") ){	
				
							pstmt_insert.setString(36,(String)insertRecords_3.get("QTY_VALUE"));
							pstmt_insert.setString(37,(String)insertRecords_3.get("QTY_DESC_CODE"));
						}else{
							pstmt_insert.setString(36,"");
							pstmt_insert.setString(37,"");
						}
						
						pstmt_insert.setString(38,strength_value);
						pstmt_insert.setString(39,strength_uom);
						String eq_val	= "1";
						String qty_unit	= (String)insertRecords_3.get("QTY_DESC_CODE");
						String strength_value1					= (String)insertRecords_3.get("ACT_STRENGTH_VALUE");
						String strength_per_value_per_pres_uom1	= (String)insertRecords_3.get("STRENGTH_PER_VALUE_PRES_UOM");
						String strength_per_pres_uom1			= (String)insertRecords_3.get("STRENGTH_PER_PRES_UOM"); 
						String ord_qty1	= (String)insertRecords_3.get("ORD_QTY");
						eq_val			= getConvFactor(pres_base_uom,qty_unit);
						String pres_qty	= getPrescribedQty(dosage_type,eq_val,fract_dose,qty_value,repeat_value,strength_per_value_per_pres_uom1,strength_per_pres_uom1,ord_qty1,strength_value1,durn_value);
						pstmt_insert.setString(40,pres_qty);
						//pstmt_insert.setString(41,(String)insertRecords_3.get("in_order_uom"));
						pstmt_insert.setString(41,in_order_uom);
						pstmt_insert.setString(42,(String)insertRecords_3.get("ALLERGY_REMARKS"));
						pstmt_insert.setString(43,(String)insertRecords_3.get("DOSE_REMARKS"));
						pstmt_insert.setString(44,(String)insertRecords_3.get("CURRENTRX_REMARKS"));
						pstmt_insert.setString(45,"N");//BROUGHT_BY_PAT						
						pstmt_insert.setString(46,"");
						pstmt_insert.setString(47,"");
						pstmt_insert.setString(48,(String)insertRecords_3.get("PAT_COUNSELING_REQD"));
						pstmt_insert.setString(49,"");
						if(insertRecords_3.containsKey("EXCL_INCL_IND")){
							pstmt_insert.setString(50,(String)insertRecords_3.get("EXCL_INCL_IND"));
							pstmt_insert.setString(51,(String)insertRecords_3.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"));
						}else{
							pstmt_insert.setString(50,"");
							pstmt_insert.setString(51,"");
						}
						pstmt_insert.setString(52,"N"); // BUILD_MAR_YN
						pstmt_insert.setString(53,(String)insertRecords_3.get("DRUG_INDICATION")); //Newly Added   For ML-BRU-CRF-072[Inc:29938]
						pstmt_insert.setString(54,"");// RUT-CRF-0063 [IN:029601]  -PREGNANCY_OVERRIDE_REASON
						//Added for IN:072715 
						pstmt_insert.setString(55,(String)insertRecords_3.get("ALLERGY_REMARKS_CODE"));
						pstmt_insert.setString(56,(String)insertRecords_3.get("DOSE_REMARKS_CODE"));
						pstmt_insert.setString(57,(String)insertRecords_3.get("CURRENTRX_REMARKS_CODE"));
						pstmt_insert.setString(58,(String)insertRecords_3.get("INTERACTION_REMARKS_CODE"));
						pstmt_insert.setString(59,(String)insertRecords_3.get("LAB_INTERACTION_REMARKS_CODE"));
						pstmt_insert.setString(60,(String)insertRecords_3.get("FOOD_INTERACTION_REMARKS_CODE"));
						pstmt_insert.setString(61,(String)insertRecords_3.get("DISEASE_INTERACTION_REMARKS_CODE"));//Added for MMS-DM-CRF-0229
						pstmt_insert.setString(62,(String)insertRecords_3.get("DISEASE_INTERACTION_REMARKS"));//Added for MMS-DM-CRF-0229
						//Added for IN:072715 
						pstmt_insert.addBatch();
					}
				}
				int[] result_insert_3= pstmt_insert.executeBatch();
				
				for (int i=0;i<result_insert_3.length ;i++ ){
					if(result_insert_3[i]<0  && result_insert_3[i] != -2 ){
						insert_rec_3=false;
						break;
					}
					else{
					insert_rec_3=true;
					}
				}
			}
			closeStatement(pstmt_insert);

		   if(insert_rec_3){
				String action_seq_num	=	"";
				String order_id		=	null;	 
                pstmt			= connection.prepareStatement(sql_ph_prescription_select56) ;
				for (int i=0;i<OrderHeader.size() ;i++ ){
					order_id=(String) OrderID.get(i);
					pstmt.setString(1,order_id);
    				resultSet		= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()){
						action_seq_num=resultSet.getString(1);
					}
					closeResultSet(resultSet);
					pstmt_insert	= connection.prepareStatement(sql_insert_5) ;
					pstmt_insert.setString(1,order_id);
					pstmt_insert.setString(2,action_seq_num);
					pstmt_insert.setString(3,login_by_id);         			
					pstmt_insert.setString(4,login_at_ws_no);
					pstmt_insert.setString(5,login_facility_id);
					pstmt_insert.setString(6,login_by_id);
					pstmt_insert.setString(7,login_at_ws_no);
					pstmt_insert.setString(8,login_facility_id);
					result_insert_5 = pstmt_insert.executeUpdate() ;

					if(result_insert_5>0){
						String header_comments = OrderRemarks;		
						header_comments = header_comments+prn_remarks_values;						

						pstmt_clob		= connection.prepareStatement(sql_ph_prescription_select57) ;
						pstmt_clob.setString(1,order_id);
						pstmt_clob.setString(2,action_seq_num);
						rset_clob=pstmt_clob.executeQuery();

						if(rset_clob!=null){
							while(rset_clob.next()){
								Clob clb 			= (Clob) rset_clob.getClob(1);
								BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
								bw.write(header_comments,0,header_comments.length());
								bw.flush();
								bw.close();
							}
						}
						closeStatement(pstmt_clob);
						closeResultSet(rset_clob);
						insert_rec_4=true;
					}
					else{
						insert_rec_4=false;
						break;
					}
				}
				closeResultSet(resultSet);
				closeStatement(pstmt_insert);
				closeStatement(pstmt);
		   }
           if(insert_rec_4){
				if( (!(weight.equals(""))) && (!(height.equals(""))) ){
					String fld_value	=	null;
					String fld_legend	=	null;
					String fld_unit		=	null;
					String seq_no		=	null; 

					for(int j=0;j<3;j++){
						fld_value	="";
						fld_legend	="";
						fld_unit	="";
						seq_no		="";
						if(j==0){
							fld_value=height;
							fld_legend="height";
							fld_unit=height_unit;
							seq_no="1";
						}
						if(j==1){
							fld_value=weight;
							fld_legend="weight";
							fld_unit=weight_unit;
							seq_no="2";
						}
						if(j==2){
							fld_value=bsa;
							fld_legend="bsa";
							fld_unit=bsa_unit;
							seq_no="3";
						}
					
					String order_id	=	null;
					pstmt_insert		= null;
					pstmt_insert		= connection.prepareStatement(sql_insert_6) ;
					for (int i=0;i<OrderHeader.size() ;i++ ){

						order_id=(String) OrderID.get(i);

						pstmt_insert.setString(1,order_id);
						pstmt_insert.setString(2,seq_no);
						pstmt_insert.setString(3,fld_unit);
						pstmt_insert.setString(4,"N");
						pstmt_insert.setString(5,fld_legend);
						pstmt_insert.setString(6,fld_value);
						pstmt_insert.setString(7,"O");
						pstmt_insert.setString(8, login_by_id);
						pstmt_insert.setString(9, login_at_ws_no);
						pstmt_insert.setString(10,login_facility_id);
						pstmt_insert.setString(11,login_by_id);
						pstmt_insert.setString(12,login_at_ws_no);
						pstmt_insert.setString(13,login_facility_id);
						pstmt_insert.addBatch();
					}
				}
				int[] result_insert_6= pstmt_insert.executeBatch();
				for (int i=0;i<result_insert_6.length ;i++ ){
					if(result_insert_6[i]<0  && result_insert_6[i] != -2 ){
						insert_rec_5=false;
						break;
					}
					else{
						insert_rec_5=true;
					}
				}
			}
			else{
				insert_rec_5=true;
			}
		}
		closeStatement(pstmt_insert);
			if(insert_rec_5){
				pstmt			= connection.prepareStatement(sql_ph_prescription_select55) ;
				pstmt.setString(1,patientId);
				
				resultSet		= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
						srl_NO=resultSet.getInt("NEXT_SRL_NO");
				}
				closeResultSet(resultSet);
				closeStatement(pstmt);

				ArrayList headerList		=	new ArrayList();
				pstmt_insert				=	connection.prepareStatement(sql_insert_4) ;
				pstmt_insert.clearBatch();
				
				String order_id				=	null;
				HashMap insertRecords_4		=	null;
				String dosage_type			=	null;
				String qty_value			=	null;
				float    tot_qty_value      =   0;
				String qty_unit				=	null;
				String strength_value		=	null;
				String strength_uom			=	null;
				String in_strength_value	=	null;
				String in_strength_uom		=	null;
				String split_dose_preview	=	null;
				String fract_dose			=	null;
				String split_dose_yn_val	=   "N"	;
				String qty_value_1          =   null;
				float  qty_value_2			=   0;
				String perform_external_database_checks="";
				
				HashMap chkValuescheduleFrequency	= ScheduleFreq;
				ArrayList frequencyValues			= new ArrayList();
				String pres_issued_qty              = "";
				String in_order_qty					= "";
				String repeat_value					= "1";
				String strength_per_value_per_pres_uom	= "";
				String strength_per_pres_uom			=	"";
				String freq_nature ="";
				String interval_value="";
                HashMap	prn_remarks_hash =new HashMap();
				String prn_remarks_text = "";
				String prn_remarks_code = "";
            for(int i=0;i<OrderID.size();i++){
					headerList=new ArrayList();
					order_id=(String) OrderID.get(i);
					headerList=(ArrayList) OrderDetails.get(i);
					for(int j=0;j<headerList.size();j++){
						insertRecords_4= new HashMap();
						insertRecords_4=(HashMap) headerList.get(j);
						pstmt_insert.setString(1,patientId);
						 prn_remarks_hash = new HashMap();
						 prn_remarks_text = ""; 
						 prn_remarks_code = ""; 
						drug_code=(String)insertRecords_4.get("DRUG_CODE");	// added for IN26310 --16/03/2011-- priya
						//logic added on 6/6/2003
						 dosage_type	=(String)insertRecords_4.get("DOSAGE_TYPE");
						 qty_value		=(String)insertRecords_4.get("QTY_VALUE");
						 qty_unit		=(String)insertRecords_4.get("QTY_DESC_CODE");
						 strength_value	=(String)insertRecords_4.get("ACT_STRENGTH_VALUE");
						 strength_uom	=(String)insertRecords_4.get("STRENGTH_UOM");
						 fract_dose		=(String)insertRecords_4.get("FRACT_DOSE_ROUND_UP_YN");
						 freq_nature	=(String)insertRecords_4.get("FREQ_NATURE");
						 interval_value	=(String)insertRecords_4.get("INTERVAL_VALUE");
						 perform_external_database_checks	=(String)insertRecords_4.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
						 in_strength_value		="";
						 in_strength_uom		="";
						 split_dose_yn_val		="N";
						 qty_value_1            =""; 
						 
						chkValuescheduleFrequency=ScheduleFreq;
						ArrayList schedule = new ArrayList();

						if(chkValuescheduleFrequency.size()>0){
							if(chkValuescheduleFrequency.containsKey((String)insertRecords_4.get("DRUG_CODE")+(String)insertRecords_4.get("SRL_NO")))
								schedule = (ArrayList) chkValuescheduleFrequency.get((String)insertRecords_4.get("DRUG_CODE")+(String)insertRecords_4.get("SRL_NO"));
						}

						if(insertRecords_4.containsKey("SPLIT_DOSE_YN_VAL")){
							
                            split_dose_yn_val=(String)insertRecords_4.get("SPLIT_DOSE_YN_VAL");
							 if(split_dose_yn_val==null || split_dose_yn_val.equals("null"))
								split_dose_yn_val="N";
						}else{
							  split_dose_yn_val="N";
						}
				
						  if(dosage_type.equals("A") ||(freq_nature!=null && freq_nature.equals("P")) || (freq_nature!=null && freq_nature.equals("O")) )
						  {
							  qty_value_1        =  qty_value;
						  }
						 if(schedule.size() > 0 && (split_dose_yn_val.equals("N")) ) {
								ArrayList dose_list	= (ArrayList)schedule.get(4);
								if(fract_dose.equals("N")) { 
								 //HashMap detail	=	(HashMap)schedule.get(0);
								 //qty_value		=	(String)detail.get("admin_qty");
								 qty_value		=	(String)dose_list.get(0);
								 if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1";
								 qty_value_1    =  qty_value;	 
								}else{
                                  //HashMap detail	=	(HashMap)schedule.get(0);
								 if(dosage_type.equals("S")){
								   //qty_value		=	(String)detail.get("admin_qty");
								   qty_value		=	(String)dose_list.get(0);
								   if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1";
								   qty_value_1      =   qty_value;
								   qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";
								 }else if(dosage_type.equals("Q")){
									//qty_value		=	(String)detail.get("admin_qty");
									qty_value		=	(String)dose_list.get(0);
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1";
									qty_value_1     =   qty_value;
									qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
									
								 }                                   
								 qty_value          =   (Math.ceil(Float.parseFloat(qty_value)*dose_list.size()))+"";    
								}
								repeat_value		=	dose_list.size()+"";
						 }else  if(schedule.size() > 0 && (split_dose_yn_val.equals("Y")) ) {
								ArrayList dose_list	= (ArrayList)schedule.get(4);
								tot_qty_value       = 0;
								qty_value_2			= 0;
								repeat_value		=	"1";
								if(fract_dose.equals("N")) {
									String final_qty ="";
									//for(int n=0; n<schedule.size(); n++) {
									for(int n=0; n<dose_list.size(); n++) {
									  //HashMap  detail	=  (HashMap)schedule.get(n);
									  final_qty = (String)dose_list.get(n);
									  if(!(final_qty.equals("")||final_qty.equals("0")||final_qty==null))
										tot_qty_value    =  tot_qty_value+Float.parseFloat((String)dose_list.get(n));
									  else
										tot_qty_value	=	tot_qty_value+1;
                                    }
									qty_value_1        =  tot_qty_value+"";
								}else{
									//for(int n=0; n<schedule.size(); n++) {
									for(int n=0; n<dose_list.size(); n++) {
										//HashMap  detail	=  (HashMap)schedule.get(n);

										 if(dosage_type.equals("S")){
											 //qty_value		=	(String)detail.get("admin_qty");
											 qty_value		=	(String)dose_list.get(n);
											 if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1";
                                             qty_value      =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";
											 qty_value_2    +=   (Math.ceil(Float.parseFloat(qty_value)*Float.parseFloat(strength_value)));

                                             
										  }else if(dosage_type.equals("Q")){
											//qty_value		=	(String)detail.get("admin_qty");
											qty_value		=	(String)dose_list.get(n);
											 if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1";
                                            qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
											qty_value_2    +=  Float.parseFloat(qty_value);
										 }  
                                        
									   tot_qty_value    =  tot_qty_value+Float.parseFloat(qty_value);
									}
									qty_value_1        =  qty_value_2+"";
								}  								      
			                    qty_value          =  tot_qty_value+"";
							}else{
								if(freq_nature.equals("O")){
									if(fract_dose.equals("Y") && dosage_type.equals("S")){
										 qty_value      =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";	
										 
									}
								}

							}
						

                 strength_per_value_per_pres_uom	= (String)insertRecords_4.get("STRENGTH_PER_VALUE_PRES_UOM"); 
				 strength_per_pres_uom				= (String)insertRecords_4.get("STRENGTH_PER_PRES_UOM");  
				 String durn_value1					= (String)insertRecords_4.get("DURN_VALUE");
				 String tmp_durn_value1				= (String)insertRecords_4.get("TMP_DURN_VALUE")==null?durn_value1:(String)insertRecords_4.get("TMP_DURN_VALUE");
				 String durn_desc1					= (String)insertRecords_4.get("DURN_DESC");
				 String repeat_durn_type1					= (String)insertRecords_4.get("REPEAT_DURN_TYPE");
				if(!durn_desc1.equals(repeat_durn_type1))
				{
					durn_value1=tmp_durn_value1;
				}
				if(dosage_type.equals("Q")){
					String equl_value	=	"1";
					equl_value = getConvFactor((String)insertRecords_4.get("PRES_BASE_UOM"),qty_unit);
					if(fract_dose.equals("N")) { 
						in_order_qty	=	(Float.parseFloat(qty_value)*Float.parseFloat(durn_value1)*Float.parseFloat(repeat_value)*Float.parseFloat(equl_value))+"";
					}
					else{
						in_order_qty	=(Math.ceil(	Float.parseFloat(qty_value)*Float.parseFloat(durn_value1)*Float.parseFloat(repeat_value)*Float.parseFloat(equl_value)))+"";
					}
				}
				else if(dosage_type.equals("S")){
					if(fract_dose.equals("N")) { 			
						in_order_qty=((Float.parseFloat(qty_value)*Float.parseFloat(durn_value1)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))/Float.parseFloat(strength_per_pres_uom))+"";
					}
					else{
						in_order_qty=(Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(strength_value)*Float.parseFloat(durn_value1)*Float.parseFloat(strength_per_value_per_pres_uom))/Float.parseFloat(strength_per_pres_uom)))+"";
	
					}
				}
				else{
						in_order_qty=(String)insertRecords_4.get("ORD_QTY");
				}
						
				if(interval_value==null)
					interval_value		=	"1";

				if((dosage_type!=null && dosage_type.equals("A")) || (freq_nature!=null && freq_nature.equals("P"))){
					if(freq_nature!=null && freq_nature.equals("P")) {
						in_strength_value=strength_value;
						in_strength_uom=strength_uom;
						//in_order_qty =Integer.parseInt((String)insertRecords_4.get("ORD_QTY"))*Integer.parseInt((String)insertRecords_4.get("CONTENT_IN_PRES_BASE_UOM"))+"";
						//in_order_qty =new Float(Math.ceil(Float.parseFloat((String)insertRecords_4.get("ORD_QTY"))*Float.parseFloat((String)insertRecords_4.get("CONTENT_IN_PRES_BASE_UOM")))).intValue()+"";
						//Adding start for SCF-BSP-SCF-0024
						if(insertRecords_4.get("ABSOL_QTY")==null || ((String)insertRecords_4.get("ABSOL_QTY")).equals("0")) {
									if(insertRecords_4.get("PRN_DOSES_PRES_PRD_FILL")==null || ((String)insertRecords_4.get("PRN_DOSES_PRES_PRD_FILL")).equals("0")) {
										in_order_qty	= "1";
									}
									else{
										in_order_qty	= ((String)insertRecords_4.get("PRN_DOSES_PRES_PRD_FILL"));
									//	System.err.println("in_order_qty@@@@==="+in_order_qty);
									}
								}
								else{
									in_order_qty	= ((String)insertRecords_4.get("ABSOL_QTY"));
								}		//Adding end for BSP-SCF-0024	
					} 
					else {
						in_strength_value	=	strength_value;
						in_strength_uom		=	strength_uom;
						in_order_qty=(((String)insertRecords_4.get("ABSOL_QTY")==null)?"1":(String)insertRecords_4.get("ABSOL_QTY"));//Added for BSP-SCF-0024
					}
				}
				if(freq_nature.equals("P")){
				   if(prn_remarks!= null){
						prn_remarks_hash=(HashMap)prn_remarks.get(drug_code);
						if(prn_remarks_hash!= null){
							if(prn_remarks_hash.containsKey("remarks_dtl"))
								prn_remarks_text=(String)prn_remarks_hash.get("remarks_dtl")==null?"":(String)prn_remarks_hash.get("remarks_dtl");
							if(prn_remarks_hash.containsKey("remarks_code"))
								prn_remarks_code=(String)prn_remarks_hash.get("remarks_code")==null?"":(String)prn_remarks_hash.get("remarks_code");
						 }
					   }
					}
				//end of logic
					pstmt_insert.setString(2,""+(srl_NO));
					pstmt_insert.setString(3,facilityId);
					pstmt_insert.setString(4,encounterId);
					pstmt_insert.setString(5,(patientClass));
					pstmt_insert.setString(6,locationType);
					pstmt_insert.setString(7,locationCode);
					pstmt_insert.setString(8,"");
					pstmt_insert.setString(9,"");
					pstmt_insert.setString(10,"");
					pstmt_insert.setString(11,"");
					pstmt_insert.setString(12,"");
					pstmt_insert.setString(13,"");
					pstmt_insert.setString(14,practId);
					pstmt_insert.setString(15,practId);
					pstmt_insert.setString(16,(String)insertRecords_4.get("DRUG_CODE"));
					pstmt_insert.setString(17,(String)insertRecords_4.get("GENERIC_ID"));
					pstmt_insert.setString(18,(String)insertRecords_4.get("START_DATE"));
					pstmt_insert.setString(19,(String)insertRecords_4.get("END_DATE"));
					// Checking Split or Scheduled - Starts
					frequencyValues		=	new ArrayList();
					if(chkValuescheduleFrequency.size()>0){	
						if(chkValuescheduleFrequency.containsKey((String)insertRecords_4.get("DRUG_CODE")+(String)insertRecords_4.get("SRL_NO"))){
							frequencyValues = (ArrayList) chkValuescheduleFrequency.get((String)insertRecords_4.get("DRUG_CODE")+(String)insertRecords_4.get("SRL_NO"));
						}
					}
					pstmt_insert.setString(20,split_dose_yn_val);    
					if(insertRecords_4.get("TAPER_DOSE_YN")==null) {
						pstmt_insert.setString(21,"N");
					} 
					else {
						pstmt_insert.setString(21,(String)insertRecords_4.get("TAPER_DOSE_YN"));
					}
					if(strength_value!=null){
					   in_strength_value = strength_value;
					}
					else{
					   in_strength_value = ""; 
					}
					if(strength_uom!=null){
					   in_strength_uom	= strength_uom;
					}
					else{
					   in_strength_uom	= ""; 
					}
					 
					pstmt_insert.setString(22,in_strength_value);
					pstmt_insert.setString(23,in_strength_uom);
					pstmt_insert.setString(24,qty_value_1);
					pstmt_insert.setString(25,qty_unit);						
					split_dose_preview	=	"";
					frequencyValues = new ArrayList();
					if(chkValuescheduleFrequency.size()>0){
						if(chkValuescheduleFrequency.containsKey((String)insertRecords_4.get("DRUG_CODE")+(String)insertRecords_4.get("SRL_NO")))
						frequencyValues = (ArrayList) chkValuescheduleFrequency.get((String)insertRecords_4.get("DRUG_CODE")+(String)insertRecords_4.get("SRL_NO"));
					}
					if(frequencyValues.size()>0){						
						/*for(int n=0;n<frequencyValues.size();n++){
							HashMap data=new HashMap();
							data=(HashMap)frequencyValues.get(n);
							split_dose_preview= split_dose_preview + (String)data.get("admin_time");
							split_dose_preview= split_dose_preview + " = ";
							split_dose_preview= split_dose_preview + (String)data.get("admin_qty");
							split_dose_preview= split_dose_preview + " ";
							split_dose_preview= split_dose_preview + (String)insertRecords_4.get("QTY_DESC_CODE");
							split_dose_preview= split_dose_preview + " | ";
					  }*/
					ArrayList dose_list	= (ArrayList)frequencyValues.get(4);
					ArrayList time_list	= (ArrayList)frequencyValues.get(3);
					String fqty="";
					for(int n=0;n<dose_list.size();n++){
						fqty = (String)dose_list.get(n);
						if(fqty.equals("")||fqty.equals("0")||fqty==null)
							fqty="1";
						split_dose_preview= split_dose_preview + (String)time_list.get(n);
						split_dose_preview= split_dose_preview + " = ";
						split_dose_preview= split_dose_preview + fqty;
						split_dose_preview= split_dose_preview + " ";
						split_dose_preview= split_dose_preview + getUomDisplay(facilityId,(String)insertRecords_4.get("QTY_DESC_CODE"));
						split_dose_preview= split_dose_preview + " ; ";
					}
				}
						if(split_dose_preview.length()>2499 ){
								split_dose_preview=split_dose_preview.substring(0,2499);
						}
						else{
								split_dose_preview=split_dose_preview;
						}
						pstmt_insert.setString(26,split_dose_preview);
						pstmt_insert.setString(27,(String)insertRecords_4.get("FREQ_CODE"));
						//pstmt_insert.setString(28,(String)insertRecords_4.get("DURN_VALUE"));
						pstmt_insert.setString(28,(String)insertRecords_4.get("DURN_VALUE"));
						in_order_qty=Math.ceil(Float.parseFloat(in_order_qty))+"";
						pstmt_insert.setString(29,in_order_qty);
//ORD_QTY
						String diagText="";
						if(diag_text.size()>0){
							diagText=(String)diag_text.get(3)+"~"+(String)diag_text.get(7)+"~"+(String)diag_text.get(11);
						}
						pstmt_insert.setString(30,diagText);
						pstmt_insert.setString(31,"");
						pstmt_insert.setString(32,"N");
						pstmt_insert.setString(33,"");
						pstmt_insert.setString(34,"");
						pstmt_insert.setString(35,"");
						pstmt_insert.setString(36,"");
						pstmt_insert.setString(37,"");
						pstmt_insert.setString(38,"N");
						pstmt_insert.setString(39,"");
						pstmt_insert.setString(40,null);
						pstmt_insert.setString(41,"N");
						pstmt_insert.setString(42,"");
						pstmt_insert.setString(43,null);
						pstmt_insert.setString(44,"D");
						pstmt_insert.setString(45,facilityId);
						pstmt_insert.setString(46,order_id);
						pstmt_insert.setString(47,""+(j+1));	
						//pres_issued_qty =Integer.parseInt((String)insertRecords_4.get("TOT_ALLOC_QTY"))*Integer.parseInt((String)insertRecords_4.get("CONTENT_IN_PRES_BASE_UOM"))+"";
						if((dosage_type!=null && dosage_type.equals("A")) || (freq_nature!=null && freq_nature.equals("P"))){//Added if condition for BSP-SCF-0024
							pres_issued_qty =new Float(Math.ceil(Float.parseFloat((String)insertRecords_4.get("TOT_ALLOC_QTY")))).intValue()+"";
							//System.err.println("pres_issued_qty in dir bean@@======"+pres_issued_qty);
						}else{//Adding end for BSP-SCF-0024
						 pres_issued_qty =new Float(Math.ceil(Float.parseFloat((String)insertRecords_4.get("TOT_ALLOC_QTY"))*Float.parseFloat((String)insertRecords_4.get("CONTENT_IN_PRES_BASE_UOM")))).intValue()+"";
						}
						//pstmt_insert.setString(48,(String)insertRecords_4.get("TOT_ALLOC_QTY"));//TOT_ISSUED_QTY
						pstmt_insert.setString(48,pres_issued_qty);//TOT_ISSUED_QTY
						pstmt_insert.setString(49,"N");
						pstmt_insert.setString(50,null);
						pstmt_insert.setString(51,"");
						pstmt_insert.setString(52,"");
						pstmt_insert.setString(53,null);
						pstmt_insert.setString(54,"");
						pstmt_insert.setString(55,"");
						pstmt_insert.setString(56,"N");
						pstmt_insert.setString(57,null);
						pstmt_insert.setString(58,"");
						pstmt_insert.setString(59,"");
						pstmt_insert.setString(60,login_by_id);
						pstmt_insert.setString(61,login_at_ws_no);
						pstmt_insert.setString(62,login_facility_id);
						pstmt_insert.setString(63,login_by_id);
						pstmt_insert.setString(64,login_at_ws_no);
						pstmt_insert.setString(65,login_facility_id);
						pstmt_insert.setString(66,(String)insertRecords_4.get("ROUTE_CODE"));
                        if(perform_external_database_checks.equals("N")){
							pstmt_insert.setString(67,(String)insertRecords_4.get("ALLERGY_REMARKS"));
						}
						else{
							if(((String)insertRecords_4.get("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN")).equals("Y")){
							    pstmt_insert.setString(67,(String)insertRecords_4.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
							}
							else{
								 pstmt_insert.setString(67,"");
							}
						}
                        if(perform_external_database_checks.equals("N")){
							pstmt_insert.setString(68,(String)insertRecords_4.get("DOSE_REMARKS"));
						}
						else{
                           if(((String)insertRecords_4.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){ 
							     pstmt_insert.setString(68,(String)insertRecords_4.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"));
						   }
						   else{
								 pstmt_insert.setString(68,"");
							}
						}
						pstmt_insert.setString(69,"");
						if(insertRecords_4.get("DURN_TYPE")==null ||((String)insertRecords_4.get("DURN_TYPE")).equals("") ||((String)insertRecords_4.get("DURN_TYPE")).equals("null")){
							pstmt_insert.setString(70,"D");
						} 
						else{
							//pstmt_insert.setString(70,(String)insertRecords_4.get("DURN_TYPE"));
							pstmt_insert.setString(70,(String)insertRecords_4.get("DURN_DESC"));
						}
						pstmt_insert.setString(71,"");
						pstmt_insert.setString(72,"");
						pstmt_insert.setString(73,"");
						if(perform_external_database_checks.equals("N")){
							pstmt_insert.setString(74,(String)insertRecords_4.get("CURRENTRX_REMARKS"));
						}
						else{
							if(((String)insertRecords_4.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
							     pstmt_insert.setString(74,(String)insertRecords_4.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"));
							}
							else{
								 pstmt_insert.setString(74,"");
							}
						}
						if(insertRecords_4.get("NO_REFILL")!=null && !((String)insertRecords_4.get("NO_REFILL")).equals("") ) {
							pstmt_insert.setString(75,"Y");
						} 
						else {
							pstmt_insert.setString(75,"N");
						}
						
						pstmt_insert.setString(76,(String)insertRecords_4.get("FORM_CODE"));
						if(diag_text.size()>0){
							pstmt_insert.setString(77,(String)diag_text.get(0));
							pstmt_insert.setString(78,(String)diag_text.get(1));
							pstmt_insert.setString(79,(String)diag_text.get(2));
							pstmt_insert.setString(80,(String)diag_text.get(4));
							pstmt_insert.setString(81,(String)diag_text.get(5));
							pstmt_insert.setString(82,(String)diag_text.get(6));
							pstmt_insert.setString(83,(String)diag_text.get(8));
							pstmt_insert.setString(84,(String)diag_text.get(9));
							pstmt_insert.setString(85,(String)diag_text.get(10));
						}
						else{
							pstmt_insert.setString(77,"");
							pstmt_insert.setString(78,"");
							pstmt_insert.setString(79,"");
							pstmt_insert.setString(80,"");
							pstmt_insert.setString(81,"");
							pstmt_insert.setString(82,"");
							pstmt_insert.setString(83,"");
							pstmt_insert.setString(84,"");
							pstmt_insert.setString(85,"");
						}
						pstmt_insert.setString(86,(String)insertRecords_4.get("DOSAGE_TYPE"));
						pstmt_insert.setString(87,height);
						pstmt_insert.setString(88,height_unit);
						pstmt_insert.setString(89,weight);
						pstmt_insert.setString(90,weight_unit);
						pstmt_insert.setString(91,bsa);
						pstmt_insert.setString(92,allergic_yn);		
						pstmt_insert.setString(93,bmi);						
						if(((String)insertRecords_4.get("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN")).equals("Y")){
							pstmt_insert.setString(94,(String)insertRecords_4.get("EXTERNAL_INTERACTION_OVERRIDE_REASON"));	
						}
						else{
							pstmt_insert.setString(94,"");
						}

						if(((String)insertRecords_4.get("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN")).equals("Y")){
							pstmt_insert.setString(95,(String)insertRecords_4.get("EXTERNAL_CONTRA_OVERRIDE_REASON"));
						}
						else{
							pstmt_insert.setString(95,"");
						}
						pstmt_insert.setString(96,(String)insertRecords_4.get("EXTERNAL_DRUG_DB_PROD_ID"));
						pstmt_insert.setString(97,prn_remarks_text);
						pstmt_insert.setString(98,prn_remarks_code);
						pstmt_insert.addBatch();
						srl_NO++;
					}
				}
				int[] result_insert_4= pstmt_insert.executeBatch();
				
				for (int i=0;i<result_insert_4.length ;i++ ){
					if(result_insert_4[i]<0  && result_insert_4[i] != -2 ){
						insert_rec_6=false;
						break;
					}
					else{
					insert_rec_6=true;
					}
				}
			}
			closeStatement(pstmt_insert);

		//OR_ORDER_LINE_FIELD_VALUES			
		 if(insert_rec_5 ) {
				boolean freq_values_found	=	false;
				//pstmt_insert= connection.prepareStatement(sql_insert_7) ;
				pstmt_insert= connection.prepareStatement("INSERT INTO OR_ORDER_LINE_FIELD_VALUES (ORDER_ID,ORDER_LINE_NUM,ORDER_LINE_FIELD_LEVEL,ORDER_LINE_SEQ_NUM,ORDER_LINE_FIELD_MNEMONIC,ORDER_LINE_FIELD_TYPE,ORDER_LINE_LABEL_TEXT,ORDER_LINE_FIELD_VALUE,ORDER_LINE_DOSE_QTY_VALUE,ORDER_LINE_DOSE_QTY_UNIT,ACCEPT_OPTION,ORDER_LINE_FREQ_DAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)") ;
				
					HashMap insertRecords_2		=	null;
					ArrayList headerList	    =	new ArrayList();

					ArrayList frequencyValues	=	null;
					String fr_drug_code			=	null;
					String serial_no			=	null;
					String order_id				=   null;
					int jj						=   0;
					for(int i=0;i<OrderID.size();i++){
					headerList			=  new ArrayList();
					order_id			= (String) OrderID.get(i);
					headerList			= (ArrayList) OrderDetails.get(i);
					ord_line			= new HashMap();
					
					for(int j=0;j<headerList.size();j++){
						insertRecords_2	= new HashMap();
						insertRecords_2	= (HashMap) headerList.get(j);
						fr_drug_code	= (String)insertRecords_2.get("DRUG_CODE");
                        serial_no		= (String)insertRecords_2.get("SRL_NO");
						seqNo			= 200;
                        jj              = j+1;


						HashMap chkValuescheduleFrequency=ScheduleFreq;
						frequencyValues = new ArrayList();
						if(chkValuescheduleFrequency.size()>0) {
							if(chkValuescheduleFrequency.containsKey(fr_drug_code+serial_no))
								frequencyValues = (ArrayList) chkValuescheduleFrequency.get(fr_drug_code+serial_no);
						}

						
					
						if(frequencyValues.size()>0) {
							//HashMap data	=	null;
							ArrayList dose_list =	(ArrayList)frequencyValues.get(4);
							ArrayList time_list =	(ArrayList)frequencyValues.get(3);
							ArrayList day_list =	(ArrayList)frequencyValues.get(1);
							String admin_time	=	null;
							String admin_qty	=	null;
							String durn_desc	=	null;
							int days			=   0;
							//for(int n=0;n<frequencyValues.size();n++) {
							for(int n=0;n<dose_list.size();n++) {
								freq_values_found	= true;								
								seqNo				= ++seqNo;
								//data				= new HashMap();
								//data				= (HashMap)frequencyValues.get(n);
								admin_time			= (String)time_list.get(n);
								admin_qty			= (String)dose_list.get(n);
								if(admin_qty.equals("")||admin_qty.equals("0")||admin_qty==null)
									admin_qty="1";
								days				= Integer.parseInt(day_list.get(n)+"");
								durn_desc			= (String)insertRecords_2.get("QTY_DESC_CODE");
								pstmt_insert.setString(1,order_id);
								pstmt_insert.setString(2,""+(jj));
								pstmt_insert.setString(3,"S");
								pstmt_insert.setString(4,""+(seqNo));
								pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
								pstmt_insert.setString(6,"C");
								pstmt_insert.setString(7,"D");
								pstmt_insert.setString(8,admin_time);
								pstmt_insert.setString(9,admin_qty);
								pstmt_insert.setString(10,durn_desc);
								pstmt_insert.setString(11,"O");
								pstmt_insert.setInt(12,days);
								pstmt_insert.setString(13,login_by_id);
								pstmt_insert.setString(14,login_at_ws_no);
								pstmt_insert.setString(15,login_facility_id);
								pstmt_insert.setString(16,login_by_id);
								pstmt_insert.setString(17,login_at_ws_no);
								pstmt_insert.setString(18,login_facility_id);
								pstmt_insert.addBatch();
							}
						}
					}
				}

				if( freq_values_found ) {
					int[] result_insert_8= pstmt_insert.executeBatch();
					for (int i=0;i<result_insert_8.length ;i++ ){
						if(result_insert_8[i]<0  && result_insert_8[i] != -2 ){
							insert_rec_6=false;
							break;
						}
						else{
							insert_rec_6=true;
						}
					}
				} 
				else {
					insert_rec_6=true;
				}
				// }
			}
			closeStatement(pstmt_insert);
			int totalOrder	=	OrderID.size();
			int totalDrugs	=	0;
			if(totalOrder>0){
				for(int q=0; q<OrderDetails.size(); q++) {
					totalDrugs	+= ((ArrayList)OrderDetails.get(q)).size();
				}
				for (int i=0;i<OrderHeader.size() ;i++ ){
					insertRecords=(HashMap)OrderHeader.get(i);
					patient_Class=(String)insertRecords.get("PATIENT_CLASS");
				}
				
				pstmt_workload		= connection.prepareStatement(sql_ph_prescription_select72) ;
				pstmt_workload.setString(1,practId);
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,patient_Class);

				resultSet_workload  	= pstmt_workload.executeQuery() ;

				while (resultSet_workload.next()){
					dly_count		= (resultSet_workload.getString("DLYCOUNT")).trim();				
				}
				closeStatement(pstmt_workload);
				closeResultSet(resultSet_workload);

				pstmt_workload		= connection.prepareStatement(sql_ph_prescription_select73) ;
				pstmt_workload.setString(1,practId);
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,patient_Class);

				resultSet_workload  	= pstmt_workload.executeQuery() ;
				while (resultSet_workload.next()){
					monthly_count			=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
				}
				closeStatement(pstmt_workload);
				closeResultSet(resultSet_workload);	
				
				if(dly_count.equals("0")){
					workload_insert		= connection.prepareStatement(sql_ph_prescription_insert9) ;
					workload_insert.setString( 1, practId);
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
				else{
					workload_insert		= connection.prepareStatement(sql_ph_prescription_modify6) ;
					workload_insert.setString( 1,String.valueOf(totalOrder));
					workload_insert.setString( 2,String.valueOf(totalDrugs));
					workload_insert.setString( 3, login_by_id);
					workload_insert.setString( 4, login_at_ws_no);
					workload_insert.setString( 5, login_facility_id);
					workload_insert.setString( 6, practId);
					workload_insert.setString( 7, login_facility_id);
					workload_insert.setString( 8, patient_Class);
					workload_insert.executeUpdate();
				}
				closeStatement(workload_insert);
					
				if(monthly_count.equals("0")){
					work_insert_month		= connection.prepareStatement(sql_ph_prescription_insert10) ;
					work_insert_month.setString( 1, practId);
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
				else{
					work_insert_month		= connection.prepareStatement(sql_ph_prescription_modify7) ;
					work_insert_month.setString( 1,String.valueOf(totalOrder));
					work_insert_month.setString( 2,String.valueOf(totalDrugs));
					work_insert_month.setString( 3, login_by_id);
					work_insert_month.setString( 4, login_at_ws_no);
					work_insert_month.setString( 5, login_facility_id);
					work_insert_month.setString( 6, practId);
					work_insert_month.setString( 7, login_facility_id);
					work_insert_month.setString( 8, patient_Class);
					work_insert_month.executeUpdate();
				}
				closeStatement(work_insert_month);

				if(locationCode!=null&&!(locationCode.equals("")))	{	
					pstmt_workload			= connection.prepareStatement(sql_ph_prescription_select74) ;
					
					pstmt_workload.setString(1,locationType);
					pstmt_workload.setString(2,login_facility_id);
					pstmt_workload.setString(3,locationCode);
					resultSet_workload  	= pstmt_workload.executeQuery() ;

					while (resultSet_workload.next()){
						dly_count_loc	= (resultSet_workload.getString("DLYCOUNT")).trim();				
					}
					closeStatement(pstmt_workload);
					closeResultSet(resultSet_workload);

					pstmt_workload			= connection.prepareStatement(sql_ph_prescription_select75) ;
					pstmt_workload.setString(1,locationType);
					pstmt_workload.setString(2,login_facility_id);
					pstmt_workload.setString(3,locationCode);

					resultSet_workload  	= pstmt_workload.executeQuery() ;
					while (resultSet_workload.next()){
						monthly_count_loc		=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
						}
					closeStatement(pstmt_workload);
					closeResultSet(resultSet_workload);
					
					if(dly_count_loc.equals("0")){
						work_insert_loc = connection.prepareStatement(sql_ph_prescription_insert11) ;
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
					else{
						work_insert_loc = connection.prepareStatement(sql_ph_prescription_modify8) ;
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
					closeStatement(work_insert_loc);
						
					if(monthly_count_loc.equals("0")){
						work_insert_loc_mon =  connection.prepareStatement(sql_ph_prescription_insert12) ;
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
					else{
						work_insert_loc_mon =  connection.prepareStatement(sql_ph_prescription_modify9) ;
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
					closeStatement(work_insert_loc_mon);
				}
			}
			if(insert_rec_1 && insert_rec_2 && insert_rec_3 && insert_rec_4 && insert_rec_5 && insert_rec_6 ){
		        //connection.commit();			
				map.put( "result", new Boolean( true ) ) ;
				map.put("msgid","RECORD_INSERTED" ) ;
			}
			else{
				try{
					connection.rollback();
					map.put("flag","0");
				}
				catch(Exception es){
					es.printStackTrace() ;
					map.put("flag","0");
				}
			}
		
			// objects nullified after usage
			OrderID					=	null;
			OrderDetails			=	null;
			OrderHeader				=	null;
			diag_text				=	null;
			mandatory_flds			=	null;
			ScheduleFreq			=	null;
			disp_location			=	null;
			ord_line				=	null;
			orderStatusCode			=	null;
			insertRecords			=	null;
			sqlMap					=	null;

		}
		catch(Exception e){
			e.printStackTrace() ;
			try{
				connection.rollback();
				map.put("flag","0");
			}
			catch(Exception es){
				es.printStackTrace() ;
				map.put("flag","0");
			}
		}
		finally{
			try{
				closeStatement( pstmt_insert ) ;
				closeStatement( cstmt_insert ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt_clob ) ;
				closeStatement(pstmt_workload);
				closeStatement(workload_insert);		 
				closeStatement(work_insert_month);		 
				closeStatement(work_insert_loc)	;	 
				closeStatement(work_insert_loc_mon);		
				closeResultSet( resultSet_workload );
				closeResultSet( rset_clob );
				closeResultSet( resultSet );
				//closeConnection(connection );
				tabData					=	null;
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		map.put("flag","0");
		return map;
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
            }catch(Exception es){es.printStackTrace();}
        }
		return result;
	}
	// This method will give the sequence number
	public String getSequenceNo(String sql_ph_disp_medication_select33)throws Exception{
		String result = "";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null;
		try {
			//connection = getConnection(prop) ;
			connection = getConnection() ;
			pstmt = connection.prepareStatement( sql_ph_disp_medication_select33 ) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				result = resultSet.getString("NEXTVAL");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			//throw new EJBException("Error while getting sequence no");
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				//closeConnection( connection,prop );
				closeConnection( connection );
			}
			catch(Exception es) { es.printStackTrace();}
		}
		return result;
	}	


	public HashMap completeDispensing(Connection connection,HashMap tabData,HashMap sqlMap ) throws Exception{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		
		String facility_id				= "";
			   //login_by_id			= "";
			   //login_at_ws_no			= "";
		String patient_class			= "";
		String patient_id				= "";
		String login_by_id				= "";
		String login_at_ws_no			= "";
		String result_str_1             ="false";
		HashMap insertRecords			=   null;
		ArrayList OrderHeader			= (ArrayList) tabData.get("OrderHeader"); 
		ArrayList mandatory_flds		= (ArrayList) tabData.get("mandatory_flds");
		if(OrderHeader.size()>0){
			insertRecords=(HashMap)OrderHeader.get(0);
			patient_class      = (String)insertRecords.get("PATIENT_CLASS");				
			facility_id		   = (String)insertRecords.get("FACILITY_ID");
			patient_id		   = (String)insertRecords.get("PATIENT_ID");
		}
        if(patient_class.equals("EM")){
          patient_class      ="OP";
		}
		else if(patient_class.equals("DC")){
          patient_class      ="IP";
		}

		if(mandatory_flds.size() > 1) {
			login_by_id		   = (String)mandatory_flds.get(0);
			login_at_ws_no	   = (String)mandatory_flds.get(1);				
		}

		if(patient_class.equals("XT")) {
			tabData.put("encounter_id","11111");
		}	
		
		String st_doc_type									= "";
		//Connection connection								= null ;
		CallableStatement cstmtDispenseStat					= null;			
		PreparedStatement pstmt_update_order_line			= null;
		PreparedStatement pstmt_update_patient_drug_profile	= null;
		PreparedStatement pstmt_update_order				= null ;		
		HashMap	stock_srl									= new HashMap();
	    seq_no											= null;
		boolean result_str									= false;
		HashMap resultstr									= new HashMap();
		try{
			//connection = getConnection() ;				     
			// Get the Stock Doc Type 
			st_doc_type	=	getStockDocType(connection,sqlMap,patient_class,facility_id);
			if(st_doc_type.equals("")){
				  resultstr.put( "result", new Boolean( false) ) ;
				  resultstr.put("msgid",getMessage(getLanguageId(),"PH_DOC_TYPE_SETTINGS_NOT_AVAIL","PH"));	
				  throw new Exception("PH_DOC_TYPE_SETTINGS_NOT_AVAIL");
			}
			ArrayList OrderID		= (ArrayList) tabData.get("OrderID");
			ArrayList OrderDetails		= (ArrayList) tabData.get("OrderDetails");
			ArrayList headerList=null;
			int count=1, cstmtResult=0;
			cstmtDispenseStat = connection.prepareCall("{call Ph_Create_Work_Stats_Dispense(?,?,?,?,?,?,?,?,?,?,?,?)}");
			for(int i=0;i<OrderID.size();i++){
			   headerList		= (ArrayList) OrderDetails.get(i);				
			   for(int j=0;j<headerList.size();j++){				
					count=1;
					cstmtDispenseStat.setString(   count, login_by_id.trim());			// Dispenser ID
					cstmtDispenseStat.setString( ++count, facility_id.trim());			// Facility ID
					cstmtDispenseStat.setString( ++count, patient_id.trim());			// Patient ID
					cstmtDispenseStat.setString( ++count, ((String)OrderID.get(i)).trim());	// Order ID
					cstmtDispenseStat.setString( ++count, (j+1)+"");	 //Order line num
					cstmtDispenseStat.setString( ++count, "1");			// total number of orders dispensed
					cstmtDispenseStat.setInt( ++count, 0);					
					cstmtDispenseStat.setInt( ++count, 0);
					cstmtDispenseStat.setString( ++count, login_by_id.trim());			// Login ID
					cstmtDispenseStat.setString( ++count, login_at_ws_no.trim());		// Work station 
					cstmtDispenseStat.registerOutParameter(++count,Types.VARCHAR );
					cstmtDispenseStat.registerOutParameter(++count,Types.VARCHAR );
					cstmtResult = cstmtDispenseStat.executeUpdate() ;
					if(cstmtResult < 0 ){
						throw new Exception("Insert Failed");
					}
				}
			}
		
			closeStatement(cstmtDispenseStat);
			/******Work Load Status ends************************/		
			seq_no			=	insertHeader( connection,sqlMap,tabData );	
			setDispTranSeqNo(tabData.get("TRX_SEQ_NO").toString());//added for MMS-QH-CRF-0201 [IN:052255]
			if(seq_no.containsKey("result")){
				map.put( "result", new Boolean( false ) ) ;		
				map.put( "message",(String)seq_no.get("msgid") ) ;
				map.put("flag","0");
			
				result_str       =   false;
				return map;
			}
			else if(seq_no.size()>0){
			   stock_srl		=   insertDetail(connection,sqlMap,tabData,seq_no);	
			   result_str       =   true;
			}
			else{
			   result_str       =   false;
			}
			if(stock_srl.containsKey("result")){
				map.put( "result", new Boolean( false ) ) ;		
				map.put( "message",(String)stock_srl.get("msgid") ) ;
				map.put("flag","0");
			
				result_str       =   false;
				return map;
			}   
			else  if(stock_srl.size()>0){
				result_str_1= insertBatch(connection, sqlMap,tabData,seq_no);
				result_str       =   true;
			}
			else{
				 result_str       =   false;
			}	
			if(result_str==true){
				result_str= insertConsumableDeatil(connection,sqlMap,tabData);
			}
			else{
				result_str=false;
			}
			if(result_str==true){//code for inserting PH_DISP_CONS_BATCH
				result_str=insertConsumableBatch(connection,sqlMap,tabData);
			}
			else{
				result_str=false;
			}
			if(result_str_1.equals("true")){//	Stock Insertion starts
				resultstr= callStockUpdate(connection,tabData,sqlMap,st_doc_type,stock_srl,seq_no);
			}
			//else{
			 //   result_str       =   false;
			//}
			//			tabData.put("seq_no",seq_no);
			/***** Main Table Insertion Over****/	
	
			if(((Boolean) resultstr.get( "result" )).booleanValue()){
				//connection.commit();
				map.put( "result", new Boolean( result_str) ) ;
				map.put("msgid","RECORD_MODIFIED");
				map.put("flag",getTokenNo());
			}
			else{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;		
				map.put( "message", resultstr.get("msgid") ) ;
				map.put("flag","0");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			map.put( "result", new Boolean( false ) ) ;		
			map.put( "message", resultstr.get("msgid") ) ;
			map.put("flag","0");
			connection.rollback();
			return map;
		}
		finally{
			try{
				closeStatement( pstmt_update_order_line ) ;
				closeStatement( pstmt_update_patient_drug_profile ) ;
				closeStatement( pstmt_update_order );
				//closeConnection( connection );
			}catch(Exception es){
				map.put("flag",es.toString());
				es.printStackTrace();
				connection.rollback();
				map.put( "result", new Boolean( false) ) ;
				map.put("msgid",es.toString());	
				return map;
			}
		}
		return map;
	}
	private String getStockDocType(Connection conn, HashMap sqlMap,String patient_class,String facility_id) {
		String st_doc_type							=	"";
		PreparedStatement pstmt_st_doc_type			=	null;
		ResultSet resSet							=	null;
		
		try {
			pstmt_st_doc_type	= conn.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT56") ) ;

			if(patient_class.equals("I")) {
				pstmt_st_doc_type.setString(1,"DIIP");
			}
			else {
				pstmt_st_doc_type.setString(1,"DIOP");
			}
			pstmt_st_doc_type.setString(2,facility_id);
			pstmt_st_doc_type.setString(3,facility_id);

			resSet				= pstmt_st_doc_type.executeQuery() ;
			
			if(resSet.next()) {
				st_doc_type	=	(String)resSet.getString("ST_DOC_TYPE_CODE");
			}
		
		}catch(Exception e){
				e.printStackTrace();
		}finally{	
				try {
				closeResultSet( resSet ) ;
				closeStatement( pstmt_st_doc_type ) ;
				}
				catch(Exception es) { es.printStackTrace();}
		}
		return st_doc_type;
	}

	private HashMap insertHeader(Connection connection, HashMap sqlMap, HashMap tabData ) throws Exception {
		PreparedStatement pstmt_insert_disp_hrd	= null;
		String sequence_no			=	"";
		String patient_class		=  "";
		HashMap seq_no				=	new HashMap();
		String collected_by			=  "";
		String date_time			=  "";
		String Received_at			=  "";
		String practioner_id		=  "";
		String patient_id			=  "";
		String encounterId			=  "";
		String login_by_id			=  "";
		String login_at_ws_no		=  "";	
		String source_code			=  "";
		String source_type			=  "";
		String facility_id			=  "";
		String trx_seq_no			=  "";
		HashMap insertRecords		=  null;
		ArrayList OrderHeader		= (ArrayList) tabData.get("OrderHeader"); 
		ArrayList mandatory_flds	= (ArrayList) tabData.get("mandatory_flds");
		String disp_locn_code       = (String)tabData.get("disp_location");
		trx_seq_no					=  getSequenceNo("SELECT PH_DISP_TRN_SEQ.NEXTVAL FROM DUAL");
		tabData.put("TRX_SEQ_NO",trx_seq_no);//added for CRF392/02[047518]
		if(OrderHeader.size()>0){
			insertRecords=(HashMap)OrderHeader.get(0);
			patient_class		   = (String)insertRecords.get("PATIENT_CLASS");
			
			if(patient_class.equals("EM")){
			  patient_class      ="OP";
			}else if(patient_class.equals("DC")){
			  patient_class      ="IP";
			}

			patient_id		       = (String)insertRecords.get("PATIENT_ID");
			collected_by		   = (String)insertRecords.get("PATIENT_NAME");
			if(collected_by.length()>99)
				collected_by=collected_by.substring(0,99);
			date_time			   = (String)insertRecords.get("ORDER_DATE_TIME");			  
			practioner_id		   = (String)insertRecords.get("ORD_PRACT_ID");
			encounterId		       = (String)insertRecords.get("ENCOUNTER_ID");
			Received_at			   =  "P";
			facility_id			   = (String)insertRecords.get("FACILITY_ID");
			source_code			   = (String)insertRecords.get("SOURCE_CODE");
			
			if(source_code.equals("")||source_code==null){//for dispensing without encounter id based on parameter facility directdispensing rules
               source_code="DIRE";
			}
			source_type			   = (String)insertRecords.get("SOURCE_TYPE");
			if(encounterId.equals("")||encounterId==null){//for dispensing without encounter id based on parameter facility directdispensing rules
				encounterId="11111";
			}
			
		}
		if(mandatory_flds.size() > 1) {
			login_by_id			   = (String)mandatory_flds.get(0);
			
			login_at_ws_no		   = (String)mandatory_flds.get(1);				
		}

				
    try {
		//pstmt_insert_disp_hrd = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_INSERT") ) ;
		pstmt_insert_disp_hrd = connection.prepareStatement( "INSERT INTO PH_DISP_HDR ( FACILITY_ID, DISP_NO, DISP_DATE_TIME, DISP_LOCN_CODE, ORDER_ID, ORD_DATE_TIME, PATIENT_ID, ENCOUNTER_ID, PATIENT_CLASS, LOCN_TYPE, LOCN_CODE, ROOM_TYPE, ROOM_NO, BED_NO, BED_CLASS, BED_TYPE, SPECIALITY_CODE, ATTEND_PRACTITIONER_ID, PRES_PHYSICIAN_ID, DISPENSED_BY, DISPENSED_DATE_TIME, AUTHORIZED_BY, DISP_AUTHORIZED_DATE_TIME, DELIVERED_YN, DELIVERED_BY, DELIVERED_DATE_TIME, COLLECTED_BY, RECEIVED_YN, RECEIVED_BY, RECEIVED_DATE_TIME, REF_DISP_NO_FOR_REISSUE, DISP_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ,RECEIVED_AT, COUNTER_CHKD_BY,DISP_TRN_SEQ_NO)  VALUES ( ?,?,TRUNC(SYSDATE), ?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'), ?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?,SYSDATE, ?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?, TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?, ?,TO_DATE(?,'DD/MM/YYYY HH24:MI'), ?,?,?, SYSDATE,?,?, ?,SYSDATE,?, ?,?,?,? )" ) ;
		for (int i=0;i<OrderHeader.size() ;i++ ){
			insertRecords=(HashMap)OrderHeader.get(i);
			if(insertRecords.get("DELIVER_ORDER_YN").equals("Y")){
				int count = 1;
				sequence_no = getSequenceNo((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT33"));
				seq_no.put(((String)insertRecords.get("ORDER_ID")),sequence_no);
				pstmt_insert_disp_hrd.setString(count,facility_id);
				pstmt_insert_disp_hrd.setString(++count,sequence_no);
				pstmt_insert_disp_hrd.setString(++count,disp_locn_code);
				pstmt_insert_disp_hrd.setString(++count,(String)insertRecords.get("ORDER_ID"));//order_id
				pstmt_insert_disp_hrd.setString(++count,date_time);
				pstmt_insert_disp_hrd.setString(++count,patient_id);
				pstmt_insert_disp_hrd.setString(++count,encounterId);
				pstmt_insert_disp_hrd.setString(++count,patient_class);
				pstmt_insert_disp_hrd.setString(++count,source_type);
				pstmt_insert_disp_hrd.setString(++count,source_code);
				pstmt_insert_disp_hrd.setString(++count,"");
				pstmt_insert_disp_hrd.setString(++count,"");
				pstmt_insert_disp_hrd.setString(++count,"");
				pstmt_insert_disp_hrd.setString(++count,"");
				pstmt_insert_disp_hrd.setString(++count,"");
				pstmt_insert_disp_hrd.setString(++count,"");
				pstmt_insert_disp_hrd.setString(++count,practioner_id);
				pstmt_insert_disp_hrd.setString(++count,practioner_id);
				pstmt_insert_disp_hrd.setString(++count,login_by_id);
				pstmt_insert_disp_hrd.setString(++count,"");
				pstmt_insert_disp_hrd.setString(++count,"");
				pstmt_insert_disp_hrd.setString(++count,"Y");
				pstmt_insert_disp_hrd.setString(++count,login_by_id);
				pstmt_insert_disp_hrd.setString(++count,date_time);
				pstmt_insert_disp_hrd.setString(++count,collected_by);
				pstmt_insert_disp_hrd.setString(++count,"Y");
				pstmt_insert_disp_hrd.setString(++count,"");
				pstmt_insert_disp_hrd.setString(++count,date_time);
				pstmt_insert_disp_hrd.setString(++count,"Y");
				pstmt_insert_disp_hrd.setString(++count,"");
				pstmt_insert_disp_hrd.setString(++count,login_by_id);
				pstmt_insert_disp_hrd.setString(++count,login_at_ws_no);
				pstmt_insert_disp_hrd.setString(++count,facility_id);
				pstmt_insert_disp_hrd.setString(++count,login_by_id);
				pstmt_insert_disp_hrd.setString(++count,login_at_ws_no);
				pstmt_insert_disp_hrd.setString(++count,facility_id);
				pstmt_insert_disp_hrd.setString(++count,Received_at);
				pstmt_insert_disp_hrd.setString(++count,practioner_id); 
				pstmt_insert_disp_hrd.setString(++count,trx_seq_no); 
				pstmt_insert_disp_hrd.addBatch();
			}
		}
		int[] result4	=pstmt_insert_disp_hrd.executeBatch();
		for (int i=0;i<result4.length ;i++ ){
			if(result4[i]<0  && result4[i] != -2 ){
			pstmt_insert_disp_hrd.cancel();
			connection.rollback();
			
		
			}		
		}
	}catch(Exception e){
		e.printStackTrace();
		seq_no=new  HashMap();
		
		try {
			connection.rollback();
				seq_no.put( "result", new Boolean( false) ) ;
				seq_no.put("msgid",e.toString());	
				return seq_no;
		}catch(Exception es) { es.printStackTrace();}
	}finally{	
			try {
			closeStatement( pstmt_insert_disp_hrd ) ;
			}
			catch(Exception es) { es.printStackTrace();}
	}
	return seq_no;
}
	// Detail Table insert
	private HashMap insertDetail(Connection connection, HashMap sqlMap, HashMap tabData, HashMap seq_no) throws Exception{
		PreparedStatement pstmt_insert_disp_dtl	= null;
		PreparedStatement pstmt_int				= null;
		PreparedStatement pstmt					= null;
		
		int count				=	1;
	//	int jj					=	1;
	//	int tmp_no				=	1;	
		String item_code		=	"";
		String fillcode			=   "";
		String fillremarks		=   "";
		String delivery_code	=	"";
		String delivery_remarks	=	"";
		String allocate_code	=	"";
		String allocate_remarks	=	"";
		String order_id			=   "";	
		String login_by_id		=   "";
		String login_at_ws_no	=   "";
		String facility_id		=	"";		
		ResultSet resultSet		=   null;	
		HashMap insertRecords_2	=	null;
		ArrayList	headerList	=   null;
		ArrayList batchDetails	=   null;
		ArrayList stock_detail  =   null;
		HashMap drug_detail_1   =	null;
		HashMap	stock_srl		=	new HashMap();//should be deleted after stock updation
		
		try {
			pstmt					= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DIR_DISP_EDIT_INSTRUCTIONS")) ;
			pstmt_int				= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDI_EDIT_INT_RESULTS")) ;
			//pstmt_insert_disp_dtl	= connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT")) ;
			pstmt_insert_disp_dtl	= connection.prepareStatement("INSERT INTO PH_DISP_DTL (FACILITY_ID, DISP_NO, SRL_NO, ORDER_ID, ORDER_LINE_NO, PRES_DRUG_CODE, ORDERING_FACILITY_ID, DISP_LOCN_CODE, STORE_CODE, DISP_DRUG_CODE, ITEM_CODE, STK_UOM_CODE, DISP_QTY, DISP_UOM_CODE, RETURNED_QTY, REISSUE_REASON_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DOC_SRL_NO, FILL_REMARKS_CODE,FILL_TASK_FINDING ,LABEL_CAU_INSTRN1_ENG,LABEL_CAU_INSTRN2_ENG,LABEL_SPL_INSTRN1_ENG,LABEL_SPL_INSTRN2_ENG,LABEL_PAT_INSTRN1_ENG,LABEL_CAU_INSTRN1_LOC,LABEL_CAU_INSTRN2_LOC,LABEL_SPL_INSTRN1_LOC,LABEL_SPL_INSTRN2_LOC,LABEL_PAT_INSTRN1_LOC,DRUG_INDICATION,DELIVERY_REMARKS_CODE,DELIVERY_TASK_FINDING,ALLOCATE_REMARKS_CODE,ALLOCATE_TASK_FINDING,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,PRES_REMARK_CODE,ISSUE_QTY,ISSUE_UOM_CODE,APPROVAL_NO ) VALUES ( ?,?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?,?, SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");//Newly Added DRUG_INDICATION   For ML-BRU-CRF-072[Inc:29938 and approval_no added for AAKH-CRF-0117

			ArrayList OrderID			= (ArrayList) tabData.get("OrderID");
			ArrayList OrderDetails		= (ArrayList) tabData.get("OrderDetails");
			ArrayList mandatory_flds	= (ArrayList) tabData.get("mandatory_flds");
			String disp_locn_code       = (String)tabData.get("disp_location");
			ArrayList edit_result		= null;
			ArrayList instructions_res 	= new ArrayList();
			ArrayList instructions		= new ArrayList();
			String approval_no			= ""; //AAKH-CRF-0117
			if(mandatory_flds.size() > 1) {
				login_by_id			   = (String)mandatory_flds.get(0);
				
				login_at_ws_no		   = (String)mandatory_flds.get(1);	
				facility_id			   = (String)mandatory_flds.get(2);
			}
		int cunt = 0;//added for BSP-SCF-0026
			for(int i=0;i<OrderID.size();i++){
				order_id		= (String) OrderID.get(i);
				headerList		= (ArrayList) OrderDetails.get(i);
						
				for(int j=0;j<headerList.size();j++){
					insertRecords_2=(HashMap) headerList.get(j);
					approval_no    = (String)insertRecords_2.get("approval_no"); //AAKH-CRF-0117
					if(approval_no==null) //AAKH-CRF-0117
						approval_no="";
					count				=	1;
					if(insertRecords_2.get("DELIVER_ORDER_YN").equals("Y")){
						if(insertRecords_2.containsKey("DELIVERY_REMARKS")) {
							HashMap result	    = (HashMap)insertRecords_2.get("DELIVERY_REMARKS");
							delivery_code		= (String)result.get("FILLING_REASON");
							delivery_remarks	= (String)result.get("FILLING_REMARKS");
							allocate_code	    = (String)result.get("FILLING_REASON");
							allocate_remarks	= (String)result.get("FILLING_REMARKS");
						}
						else{
							delivery_code		= "";
							delivery_remarks	= "";
							allocate_code	    = "";
							allocate_remarks    = "";
						}
						//ended...

						batchDetails			= (ArrayList)insertRecords_2.get("BATCH_DETAILS");//BATCH_DETAILS
						stock_detail	        = (ArrayList) batchDetails.get(0);
						drug_detail_1			= (HashMap)stock_detail.get(0);
						item_code			    = (String)drug_detail_1.get("ITEM_CODE");
						
						pstmt_insert_disp_dtl.setString(count,facility_id);		
						pstmt_insert_disp_dtl.setString(++count,(String)seq_no.get((order_id)));//DISP_NO
						pstmt_insert_disp_dtl.setString(++count,""+(j+1));	               //SRL_NO
						pstmt_insert_disp_dtl.setString(++count,order_id);	               //ORDER_ID
						pstmt_insert_disp_dtl.setString(++count,""+(j+1));	               //ORDER_LINE_NO
						pstmt_insert_disp_dtl.setString(++count,(String)insertRecords_2.get("DRUG_CODE"));//PRES_DRUG_CODE
						pstmt_insert_disp_dtl.setString(++count,facility_id);				//ORDERING_FACILITY_ID
						pstmt_insert_disp_dtl.setString(++count,disp_locn_code);				//DISP_LOCN_CODE
						pstmt_insert_disp_dtl.setString(++count,(String)tabData.get("store_code"));	//STORE_CODE
						pstmt_insert_disp_dtl.setString(++count,(String)insertRecords_2.get("DRUG_CODE"));	//DISP_DRUG_CODE
						pstmt_insert_disp_dtl.setString(++count,item_code);							//ITEM_CODE
						pstmt_insert_disp_dtl.setString(++count,(String)insertRecords_2.get("STOCK_UOM"));//STK_UOM_CODE
						pstmt_insert_disp_dtl.setString(++count,(String)insertRecords_2.get("TOT_ALLOC_QTY"));	//DISP_QTY			
						pstmt_insert_disp_dtl.setString(++count,(String)insertRecords_2.get("STOCK_UOM"));	//DISP_UOM_CODE
						pstmt_insert_disp_dtl.setString(++count,"0");								//RETURNED_QTY
						pstmt_insert_disp_dtl.setString(++count,"");						//REISSUE_REASON_CODE
						pstmt_insert_disp_dtl.setString(++count,login_by_id);				
						pstmt_insert_disp_dtl.setString(++count,login_at_ws_no);				
						pstmt_insert_disp_dtl.setString(++count,facility_id);				
						pstmt_insert_disp_dtl.setString(++count,login_by_id);
						pstmt_insert_disp_dtl.setString(++count,login_at_ws_no);
						pstmt_insert_disp_dtl.setString(++count,facility_id);
						pstmt_insert_disp_dtl.setString(++count,(j+1)+"");
						stock_srl.put(order_id.trim()+((j+1)+""), ((j+1)+""));
						//for filling code and remarks....
						pstmt_insert_disp_dtl.setString(++count,fillcode);
						pstmt_insert_disp_dtl.setString(++count,fillremarks);
						// filling ended..

						//for inserting cautions and special instructions.....	
						edit_result		= new ArrayList();// Added for BSP-SCF-0025
						instructions_res = new ArrayList();// Added for BSP-SCF-0026
						instructions     = new ArrayList();// Added for BSP-SCF-0026
						if(insertRecords_2.containsKey("EDITLABEL")) 			
							edit_result =(ArrayList)insertRecords_2.get("EDITLABEL");
							
							if(edit_result!=null && edit_result.size()!=0){//(cunt*11) Added for BSP-SCF-0026  
								pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+0));
								pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+1));
								pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+2));
								pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+3));
								pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+4));
								pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+5));
								pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+6));
								pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+7));
								pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+8));
								pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+9));
							} 
							else {				
								pstmt.setString(1,((String)insertRecords_2.get("DRUG_CODE")).trim());
								pstmt.setString(2,getLanguageId());
								
								resultSet	= pstmt.executeQuery() ;
								
								while (resultSet.next()){
									instructions_res.add(resultSet.getString("CAUTION_LABEL_TEXT_ID_1")+"");	
									instructions_res.add(resultSet.getString("CAUTION_LABEL_TEXT_ID_2")+"");	
									instructions_res.add(resultSet.getString("SPL_INSTR_LABEL_TEXT_ID")+"");	
									instructions_res.add(resultSet.getString("SPL_INSTR_LABEL_TEXT_ID1")+"");	
									instructions_res.add(resultSet.getString("HOW_TO_TAKE_TEXT")+"");				
								}
								String tempString ="XX";
								if(instructions_res.size() > 0){			
									for(int k=0;k<4;k++){					
										if( (!(((String)instructions_res.get(k)).equals(tempString))) && (!( (((String)instructions_res.get(k))=="") || ( ((String)instructions_res.get(k)).equals("")  ) ))){
											pstmt_int.setString(1,(String)instructions_res.get(k));
											pstmt_int.setString(2,getLanguageId());
											resultSet	= pstmt_int.executeQuery() ;
											while (resultSet.next()){
												ArrayList	temp = new ArrayList();
												temp.add((String)resultSet.getString("LABEL_TEXT_1")+"");	
												temp.add((String)resultSet.getString("LABEL_TEXT_2")+"");
												temp.add((String)resultSet.getString("LABEL_TEXT_1_LOC_LANG")+"");
												temp.add((String)resultSet.getString("LABEL_TEXT_2_LOC_LANG")+"");
												if(k < 2)
													temp.add(instructions_res.get(4));
												else
													temp.add("");
												temp.set(4,instructions_res.get(4));
												instructions.add(temp);
											}
											closeResultSet(resultSet);
										}
										tempString = (String)instructions_res.get(k);
									}
								}
								if(instructions.size()==0){
									instructions.add(instructions_res);
								}
						ArrayList caution = new ArrayList();
						ArrayList special = new ArrayList();
						if(instructions.size() > 0){
							caution	= (ArrayList)instructions.get(0);		
							if((String)caution.get(0) == null || ((String)caution.get(0)!=null && ((String)caution.get(0)).equals("null"))){
								pstmt_insert_disp_dtl.setString(++count,"");
							}
							else{
								pstmt_insert_disp_dtl.setString(++count,(String)caution.get(0));
							}
							if((String)caution.get(1) == null || ((String)caution.get(1)!=null && ((String)caution.get(1)).equals("null"))){
								pstmt_insert_disp_dtl.setString(++count,"");
							}
							else{
								pstmt_insert_disp_dtl.setString(++count,(String)caution.get(1));
							}					
							if(instructions.size() > 1){
								special	= (ArrayList)instructions.get(1);
								if((String)special.get(0) == null || ((String)caution.get(0)!=null && ((String)caution.get(0)).equals("null"))){
									pstmt_insert_disp_dtl.setString(++count,"");
								}
								else{
									pstmt_insert_disp_dtl.setString(++count,(String)special.get(0));
								}
								if((String)special.get(1) == null || ((String)caution.get(1)!=null && ((String)caution.get(1)).equals("null"))){
									pstmt_insert_disp_dtl.setString(++count,"");
								}
								else{
									pstmt_insert_disp_dtl.setString(++count,(String)special.get(1));
								}
							}
							else{
								pstmt_insert_disp_dtl.setString(++count,"");
								pstmt_insert_disp_dtl.setString(++count,"");
							}
							
							if((String)caution.get(4) == null || ((String)caution.get(4)!=null && (((String)caution.get(4)).trim()).equals("null"))){
								pstmt_insert_disp_dtl.setString(++count,"");
							}
							else{
								pstmt_insert_disp_dtl.setString(++count,(String)caution.get(4));
							}
				
							if((String)caution.get(2) == null || ((String)caution.get(2)!=null && ((String)caution.get(2)).equals("null"))){
								pstmt_insert_disp_dtl.setString(++count,"");
							}
							else{
								pstmt_insert_disp_dtl.setString(++count,(String)caution.get(2));
							}
							if((String)caution.get(3) == null || ((String)caution.get(3)!=null && ((String)caution.get(3)).equals("null"))){
								pstmt_insert_disp_dtl.setString(++count,"");
							}
							else{
								pstmt_insert_disp_dtl.setString(++count,(String)caution.get(3));
							}

							if(instructions.size() > 1){
								special	= (ArrayList)instructions.get(1);
								if((String)special.get(2) == null || ((String)caution.get(2)!=null && ((String)caution.get(2)).equals("null"))){
									pstmt_insert_disp_dtl.setString(++count,"");
								}
								else{
									pstmt_insert_disp_dtl.setString(++count,(String)special.get(2));
								}
								if((String)special.get(3) ==null || ((String)caution.get(3)!=null && ((String)caution.get(3)).equals("null"))){
									pstmt_insert_disp_dtl.setString(++count,"");
								}
								else{
									pstmt_insert_disp_dtl.setString(++count,(String)special.get(3));
								}
								pstmt_insert_disp_dtl.setString(++count,"");
							}
							else{
								pstmt_insert_disp_dtl.setString(++count,"");
								pstmt_insert_disp_dtl.setString(++count,"");
								pstmt_insert_disp_dtl.setString(++count,"");
							}
						}
						else{
							pstmt_insert_disp_dtl.setString(++count,"");
							pstmt_insert_disp_dtl.setString(++count,"");
							pstmt_insert_disp_dtl.setString(++count,"");
							pstmt_insert_disp_dtl.setString(++count,"");
							pstmt_insert_disp_dtl.setString(++count,"");
							pstmt_insert_disp_dtl.setString(++count,"");
							pstmt_insert_disp_dtl.setString(++count,"");
							pstmt_insert_disp_dtl.setString(++count,"");
							pstmt_insert_disp_dtl.setString(++count,"");
							pstmt_insert_disp_dtl.setString(++count,"");
							}
						}
						pstmt_insert_disp_dtl.setString(++count,(String)insertRecords_2.get("DRUG_INDICATION"));//Added for  ML-BRU-CRF-072[Inc:29938]
						pstmt_insert_disp_dtl.setString(++count,delivery_code);
						pstmt_insert_disp_dtl.setString(++count,delivery_remarks);
						pstmt_insert_disp_dtl.setString(++count,allocate_code);
						pstmt_insert_disp_dtl.setString(++count,allocate_remarks);
						pstmt_insert_disp_dtl.setString(++count,"");
						pstmt_insert_disp_dtl.setString(++count,"");
						pstmt_insert_disp_dtl.setString(++count,"");
						pstmt_insert_disp_dtl.setString(++count,(String)insertRecords_2.get("ISSUE_UOM_QTY"));
						pstmt_insert_disp_dtl.setString(++count,(String)insertRecords_2.get("ISSUE_UOM"));
						pstmt_insert_disp_dtl.setString(++count, approval_no); //added for AAKH-CRF-0117
						//inserting cautions and special instructions..... ended......
						pstmt_insert_disp_dtl.addBatch();
					}
				}
			}
			int[] result3=pstmt_insert_disp_dtl.executeBatch();
			for (int i=0;i<result3.length ;i++ ){
				if(result3[i]<0  && result3[i] != -2 ){
					pstmt_insert_disp_dtl.cancel();
					connection.rollback();
				}		
			}
		}
		catch(Exception e){
			e.printStackTrace();
			try{
				connection.rollback();
				stock_srl		=	new HashMap();
				stock_srl.put( "result", new Boolean( false) ) ;
				stock_srl.put("msgid",e.toString());	
				return stock_srl;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		finally{	
			try {
				closeStatement( pstmt_insert_disp_dtl ) ;
				closeStatement(pstmt_int);
				closeStatement(pstmt);
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return stock_srl;
	}

	// Insert Batch Table --- Main
	private String insertBatch(Connection connection, HashMap sqlMap, HashMap tabData, HashMap seq_no) throws Exception {
		PreparedStatement pstmt_insert_disp_drug_batch	= null;
		int count				=	1;
		int jj					=	1;
		int kk                  =   0;
		String drug_code		= "";
		String batch_id			= "";
		String expiry_date		= "";
		String disp_qty			= "", disp_qty_uom="";
		String trade_id			= "";
		String bin_locn_code	= "";
		String result_str		="false";
		ArrayList batchDetails  = null;
		ArrayList headerList	= null;
		HashMap insertRecords_2 = null; 
		HashMap drug_detail_1   = null; 
		HashMap sel_batches     = null;
		ArrayList stock_detail  = null;
		String order_id			= "";
		String disp_locn_code   = "";
		String login_by_id		= "";
		String login_at_ws_no	= "";
		String facility_id		= "";

		try {		

			pstmt_insert_disp_drug_batch	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT") ) ;
			ArrayList OrderID			= (ArrayList) tabData.get("OrderID");
			ArrayList OrderDetails		= (ArrayList) tabData.get("OrderDetails");
			ArrayList mandatory_flds	= (ArrayList) tabData.get("mandatory_flds");
			disp_locn_code       = (String)tabData.get("disp_location");
			String store_code           = (String)tabData.get("store_code"); //added for AAKH-SCF-0189 [IN:054663]
			HashMap BaseAndIssueUOMQty		=	null;

			if(mandatory_flds.size() > 1) {
				login_by_id			   = (String)mandatory_flds.get(0);
				login_at_ws_no		   = (String)mandatory_flds.get(1);	
				facility_id			   = (String)mandatory_flds.get(2);
			}
			
			for(int i=0;i<OrderID.size();i++){
				headerList		=  new ArrayList();
				order_id		= (String) OrderID.get(i);
				headerList		= (ArrayList) OrderDetails.get(i);
				jj=1;

				for(int n=0;n<headerList.size();n++){
					insertRecords_2= new HashMap();
					insertRecords_2=(HashMap) headerList.get(n);
							
					if(insertRecords_2.get("DELIVER_ORDER_YN").equals("Y")){
						if(insertRecords_2.containsKey("BATCH_DETAILS")) {
							 batchDetails = (ArrayList)insertRecords_2.get("BATCH_DETAILS");
							 sel_batches  = (HashMap)insertRecords_2.get("SEL_BATCHES");
						}
						disp_qty_uom=insertRecords_2.get("ISSUE_UOM").toString();//ADDED FOR UPDATING COLUMN DISP_QTY_UOM  --STOCK_UOM -->BASE_UOM for AAKH-SCF-0189 [IN:054663]
						for (int j=0;j<batchDetails.size() ; j++){
							if(batchDetails.get(j) != null){
								stock_detail	= (ArrayList) batchDetails.get(j);
							}
							kk =0;
							for(int m=0; m<stock_detail.size(); m++ ) {
								drug_detail_1		=	(HashMap)stock_detail.get(m);
								kk = m;               
								if(sel_batches.get((m+""))!=null){
									count=1;
									drug_code		= (String)drug_detail_1.get("ITEM_CODE");
									batch_id		= (String)drug_detail_1.get("BATCH_ID");
									expiry_date		= (String)drug_detail_1.get("EXPIRY_DATE");
									disp_qty		= (String)sel_batches.get((m+""));
									trade_id		= (String)drug_detail_1.get("TRADE_ID");
									bin_locn_code	= (String)drug_detail_1.get("BIN_LOCATION_CODE");
									BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,drug_code,store_code, disp_qty,  ((String)insertRecords_2.get("STOCK_UOM")).trim()); //STOCK_UOM -- >ISSUE_UOM for AAKH-SCF-0189 [IN:054663]
									pstmt_insert_disp_drug_batch.setString(count,facility_id);	
									pstmt_insert_disp_drug_batch.setString(++count,(String)seq_no.get(order_id.trim()));
									pstmt_insert_disp_drug_batch.setString(++count,(jj)+"");
									pstmt_insert_disp_drug_batch.setString(++count,(++kk)+"");
									pstmt_insert_disp_drug_batch.setString(++count,disp_locn_code);
									pstmt_insert_disp_drug_batch.setString(++count,disp_locn_code);
									pstmt_insert_disp_drug_batch.setString(++count,drug_code.trim());
									pstmt_insert_disp_drug_batch.setString(++count,drug_code.trim());
									pstmt_insert_disp_drug_batch.setString(++count,batch_id.trim());
									pstmt_insert_disp_drug_batch.setString(++count,expiry_date.trim());
									pstmt_insert_disp_drug_batch.setString(++count,(String)BaseAndIssueUOMQty.get("BASE_QTY")); //disp_qty.trim() change for AAKH-SCF-0189 [IN:054663]
									pstmt_insert_disp_drug_batch.setString(++count,"0");
									pstmt_insert_disp_drug_batch.setString(++count,login_by_id);
									pstmt_insert_disp_drug_batch.setString(++count,login_at_ws_no);
									pstmt_insert_disp_drug_batch.setString(++count,facility_id);
									pstmt_insert_disp_drug_batch.setString(++count,login_by_id);
									pstmt_insert_disp_drug_batch.setString(++count,login_at_ws_no);
									pstmt_insert_disp_drug_batch.setString(++count,facility_id);	
									pstmt_insert_disp_drug_batch.setString(++count,bin_locn_code);	
									pstmt_insert_disp_drug_batch.setString(++count,trade_id);	
									pstmt_insert_disp_drug_batch.setString(++count,(String)insertRecords_2.get("BASE_UOM"));	//disp_qty_uom changed for AAKH-SCF-0189 [IN:054663]
									pstmt_insert_disp_drug_batch.addBatch();
								}
							}
						}
						jj++;
					}
				}
			}
			int[] result4=pstmt_insert_disp_drug_batch.executeBatch();

			for (int k=0;k<result4.length ;k++ ){
				if(result4[k]<0  && result4[k] != -2 ){
					pstmt_insert_disp_drug_batch.cancel();
					connection.rollback();
					result_str="false";
				}
				else{
					result_str="true";
				}		
			}  
		}
		catch(Exception e){
			e.printStackTrace();
			try {
				connection.rollback();
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		finally{	
			try {
				closeStatement( pstmt_insert_disp_drug_batch) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return result_str;
	}

	public HashMap callStockUpdate(Connection connection,HashMap tabData,HashMap sqlMap,String st_doc_type,HashMap stock_srl,HashMap seq_no) throws Exception{
		HashMap result          =new  HashMap();
		try {
			String item_code		=	"";
			String item_cost		=	"";
			String cost_value		=	"";
			String batch_id			=	"";
			String expiry_date		=	"";
			String bin_locn_code	=	"";
			String trade_id			=	"";
			String disp_qty			=	"";
			String docno			=	"";
			String disp_locn_code	=   "";	
			String end_date			=   "";
			int kk					=   1;

			HashMap stock_dtls		=	new HashMap();
			ArrayList insertDetail	=	new ArrayList();
			ArrayList insertExp		=	new ArrayList();
			ArrayList updateDetail	=	new ArrayList();
			ArrayList updateExp		=	new ArrayList();
			ArrayList batchDetails  =	null;
			ArrayList headerList	=	null;
			ArrayList stock_detail  =	null;
			HashMap insertRecords_2 =	null; 
			HashMap drug_detail_1   =	null; 
			HashMap sel_batches     =	null;
			HashMap BaseAndIssueUOMQty		=	new HashMap();

			ArrayList OrderID			= (ArrayList) tabData.get("OrderID");
			ArrayList OrderDetails		= (ArrayList) tabData.get("OrderDetails");
			disp_locn_code    = (String)tabData.get("disp_location");
			String store_code           = (String)tabData.get("store_code");
			String tmp_order_id="";  //MMS-DM-CRF-0126.2
			//String tmp_order_line_no="";//MMS-DM-CRF-0126.2 //commented for COMMON-ICN-0048
			String approval_no  = ""; // AAKH-CRF-0117
			String item_2d_barcode   = ""; //Added for MMS-DM-CRF-0174.5
			HashMap hmDetail = null, hmExp=null;
			for(int i=0;i<OrderID.size();i++){
				headerList		=  new ArrayList();
				headerList		= (ArrayList) OrderDetails.get(i);
				tmp_order_id		= (String) OrderID.get(i);//MMS-DM-CRF-0126.2

				for(int n=0;n<headerList.size();n++){
					insertRecords_2= new HashMap();
					batchDetails		=  new ArrayList();
					insertRecords_2=(HashMap) headerList.get(n);
					approval_no    = (String)insertRecords_2.get("approval_no");//AAKH-CRF-0117
					if(approval_no==null)
						approval_no = "";
					/*if(insertRecords_2.containsKey("BATCH_DETAILS")) {
						 batchDetails = (ArrayList)insertRecords_2.get("BATCH_DETAILS");
						 sel_batches  = (HashMap)insertRecords_2.get("SEL_BATCHES");
					}*/
					batchDetails = new ArrayList();
					if(insertRecords_2.containsKey("BATCH_DETAILS")) {
						 batchDetails = (ArrayList)insertRecords_2.get("BATCH_DETAILS");
						 sel_batches  = (HashMap)insertRecords_2.get("SEL_BATCHES");
						 end_date     = (String)insertRecords_2.get("END_DATE");
					}
					if(batchDetails.size()>0){
						item_code		   = (String)insertRecords_2.get("ITEM_CODE");
						disp_qty		   = (String)insertRecords_2.get("TOT_ALLOC_QTY");			

						// Item Detail
						hmDetail=	new HashMap();
						hmDetail.put("doc_srl_no",((kk)+""));
						//MMS-DM-CRF-0126.2
						hmDetail.put("ph_order_id",tmp_order_id);
						hmDetail.put("ph_order_line_no",""+(n+1));
						hmDetail.put("ph_function_id","IP_FILL_ALL");
						//MMS-DM-CRF-0126.2 - end
						hmDetail.put("item_code",item_code);
						hmDetail.put("sal_category","");
						hmDetail.put("hcp_issue_factor","");
						hmDetail.put("approval_no",approval_no);//AAKH-CRF-0117
						BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,item_code,store_code, disp_qty,  ((String)insertRecords_2.get("STOCK_UOM")).trim());
						hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY"));
						hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
						
						item_cost	= getItemCost(item_code,store_code,(String)BaseAndIssueUOMQty.get("ISSUE_QTY"),end_date);
						if(item_cost.equals("")){
							item_cost	=	"0";
						}
						cost_value	=	Math.round(Float.parseFloat((String)BaseAndIssueUOMQty.get("ISSUE_QTY")) * Double.parseDouble(item_cost)*1000)+"";
						cost_value	= (Double.parseDouble(cost_value)/1000)+"";
						//hmDetail.put("item_qty",(String)sel_batches.get((m+""))); // commented during variable uom
						hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY"));
						hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
						hmDetail.put("next_due_date","");
						hmDetail.put("stock_item_yn","Y");
						hmDetail.put("remarks","");
						hmDetail.put("item_unit_cost",item_cost);
						hmDetail.put("item_sal_value",item_cost); //Changed from cost_value to item_cost for MMS-SCF-0275 [IN:047212]
						hmDetail.put("item_cost_value",item_cost); //Changed from cost_value to item_cost for MMS-SCF-0275 [IN:047212]
						hmDetail.put("item_unit_price",item_cost);
						hmDetail.put("uom_code",((String)insertRecords_2.get("STOCK_UOM")).trim());
						hmDetail.put("mode","1");
						hmDetail.put("p_overridden_excl_incl_ind",(String)insertRecords_2.get("EXCL_INCL_IND"));
						hmDetail.put("p_overridden_action_reason",(String)insertRecords_2.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"));
										
						insertDetail.add(hmDetail);
					}
					for (int j=0;j<batchDetails.size() ; j++){
						if(batchDetails.get(j) != null){
							stock_detail	    =  null;  
							stock_detail	= (ArrayList) batchDetails.get(j);
						}
						for(int m=0; m<stock_detail.size(); m++ ) {
							drug_detail_1		= null;
							drug_detail_1		=	(HashMap)stock_detail.get(m);
							if(sel_batches.get((m+""))!=null){
								item_code		   = (String)drug_detail_1.get("ITEM_CODE");
								disp_qty		   = (String)sel_batches.get((m+""));			
								BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,item_code,store_code, disp_qty,  ((String)insertRecords_2.get("STOCK_UOM")).trim());

								batch_id		= (String)drug_detail_1.get("BATCH_ID");
								expiry_date		= (String)drug_detail_1.get("EXPIRY_DATE");
								trade_id		= (String)drug_detail_1.get("TRADE_ID");
								bin_locn_code	= (String)drug_detail_1.get("BIN_LOCATION_CODE");
								item_2d_barcode = (String)drug_detail_1.get("BARCODE_ID")==null?"":(String)drug_detail_1.get("BARCODE_ID");//Added for MMS-DM-CRF-0174.5
								hmExp	=	new HashMap();
								hmExp.put("doc_srl_no",((kk)+""));				
								hmExp.put("store_code",store_code);
								hmExp.put("item_code",item_code);
								hmExp.put("batch_id",batch_id);
								hmExp.put("bin_location_code",bin_locn_code);
								hmExp.put("expiry_date_or_receipt_date",expiry_date);
								hmExp.put("trade_id",trade_id);
								//hmExp.put("sal_item_qty",disp_qty);
								hmExp.put("sal_item_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
								hmExp.put("ret_item_qty","");
								hmExp.put("item_2d_barcode",item_2d_barcode);//Added for MMS-DM-CRF-0174.5
								insertExp.add(hmExp);			
							}
						}
					}
					kk++;
				}
			}

			if(tabData.containsKey("CONSUMABLES_DET")){
				HashMap cons_dtl       =   new HashMap();
				HashMap Batch_det      =   new HashMap();
				String issued_qty		 =	 "";
	 
				ArrayList  tot_consumables_det =(ArrayList)tabData.get("CONSUMABLES_DET");
				for (int h=0;h<tot_consumables_det.size() ;h++ ) { 
					hmDetail	     =	 new HashMap(); 
					cons_dtl = (HashMap)tot_consumables_det.get(h);
					if(cons_dtl.get("SELECTED_YN").equals("Y")&& !cons_dtl.get("ALLOC_QTY").equals("")){ 
						  
						Batch_det   =   (HashMap)cons_dtl.get("BATCH_DET");
						hmDetail	=	new HashMap();
						item_cost	=	(String)Batch_det.get("ITEM_COST");
						issued_qty  =   (String)cons_dtl.get("ALLOC_QTY");

						if(item_cost.equals("")) 
							item_cost	=	"0";
						cost_value	=	Math.round(Integer.parseInt(issued_qty) * Double.parseDouble(item_cost)*1000)+"";
						cost_value	=   (Double.parseDouble(cost_value)/1000)+"";
						hmDetail.put("doc_srl_no",cons_dtl.get("BATCH_SRL_NO" )); 
						//hmDetail.put("doc_srl_no",cons_dtl.get("BATCH_SRL_NO"));
						hmDetail.put("item_code",Batch_det.get("ITEM_CODE"));
						hmDetail.put("sal_category","");
						hmDetail.put("hcp_issue_factor","");
						hmDetail.put("item_qty",issued_qty);
						hmDetail.put("next_due_date","");
						hmDetail.put("stock_item_yn","Y");
						hmDetail.put("remarks","");
						hmDetail.put("item_unit_cost",item_cost);
						hmDetail.put("item_sal_value",item_cost); //Changed from cost_value to item_cost for MMS-SCF-0275 [IN:047212]
						hmDetail.put("item_cost_value",item_cost); //Changed from cost_value to item_cost for MMS-SCF-0275 [IN:047212]
						hmDetail.put("item_unit_price",item_cost);
						hmDetail.put("uom_code",((String)cons_dtl.get("ORDER_UOM")));
						hmDetail.put("mode",(String)tabData.get("mode"));
						hmDetail.put("p_overridden_excl_incl_ind","");
						hmDetail.put("p_overridden_action_reason","");
						insertDetail.add(hmDetail);

						hmExp	=	new HashMap();
						hmExp.put("doc_srl_no",cons_dtl.get("BATCH_SRL_NO"));
						hmExp.put("store_code",(String)tabData.get("store_code"));
						hmExp.put("item_code",(String)Batch_det.get("ITEM_CODE"));
						hmExp.put("batch_id",(String)Batch_det.get("BATCH_ID"));
						hmExp.put("bin_location_code",(String)Batch_det.get("BIN_LOCN_CODE"));
						hmExp.put("expiry_date_or_receipt_date",(String)Batch_det.get("EXPIRY_DATE"));
						hmExp.put("trade_id",(String)Batch_det.get("TRADE_ID"));
						hmExp.put("sal_item_qty",issued_qty);
						hmExp.put("ret_item_qty","");
						insertExp.add(hmExp);
					}
				}
			}
			stock_dtls.put("insertDetail",insertDetail);
			stock_dtls.put("updateDetail",updateDetail);
			stock_dtls.put("insertExp",insertExp);
			stock_dtls.put("updateExp",updateExp);
			result=updateStock(connection,tabData,stock_dtls,docno,st_doc_type,seq_no,OrderID,sqlMap);
		}
		catch(Exception e) {
			e.printStackTrace();
			//result.put( "result", new Boolean( false) ) ;
			//result.put("msgid",result.get("msgid"));	
			throw e;
			//return result;
		}	
		return result;
	}

	public HashMap updateStock(Connection connection,HashMap tabData, HashMap stock_dtls,String prev_doc_no,String  st_doc_type ,HashMap seq_no,ArrayList OrderID,HashMap sqlMap) throws Exception{

		HashMap hmHeader	=	new HashMap();
		HashMap hmCommon	=	new HashMap();
		HashMap hmData		=	new HashMap();
		ArrayList language_data =  new ArrayList();
		ArrayList insertDetail	=	(ArrayList)stock_dtls.get("insertDetail");
		ArrayList insertExp		=	(ArrayList)stock_dtls.get("insertExp");
        PreparedStatement pstmt_update_disp_hdr_tmp	=	null;
		String encounter_id		=	"";
		String login_by_id		=	"";
		String login_at_ws_no	=	"";
		String facility_id		=	"";
		String disp_locn_code	=   "";
		String ord_date_time	=	"";
		String patient_id		=   "";
		String patient_class	=   "";
		HashMap result          =new HashMap();
		String LanguageId		=  (String)tabData.get("LanguageId");
		String    token_no      =  "";

		ArrayList OrderHeader	= (ArrayList) tabData.get("OrderHeader");
		HashMap tempHeader		= (HashMap) OrderHeader.get(0);
		if(tempHeader.size()>0){
			ord_date_time	= (String)tempHeader.get("ORDER_DATE_TIME");
			ord_date_time   =ord_date_time.substring(0,10);
			patient_id		= (String)tempHeader.get("PATIENT_ID");
			patient_class	= (String)tempHeader.get("PATIENT_CLASS");
			if(tempHeader.get("ENCOUNTER_ID")==null ||tempHeader.get("ENCOUNTER_ID").equals("")){
			   encounter_id	=	"";
			}
			else{
			   encounter_id	= (String)tempHeader.get("ENCOUNTER_ID"); 
			}				
		}
		ArrayList mandatory_flds	= (ArrayList) tabData.get("mandatory_flds");
		disp_locn_code       = (String)tabData.get("disp_location");
		String  store_code          = (String)tabData.get("store_code");
		String bl_interface_yn		= (String)tabData.get("BL_INTERFACE_YN");
		if(mandatory_flds.size() > 1) {
			login_by_id			   = (String)mandatory_flds.get(0);
			
			login_at_ws_no		   = (String)mandatory_flds.get(1);	
			facility_id			   = (String)mandatory_flds.get(2);
		}
		
		hmHeader.put("facility_id",facility_id);
		hmHeader.put("doc_type_code",st_doc_type);
		hmHeader.put("doc_no","");
		hmHeader.put("doc_date",ord_date_time);
		hmHeader.put("doc_ref","");
		hmHeader.put("store_code",store_code);
       	hmHeader.put("billable_trn_yn",bl_interface_yn);//billable_trn_yn
		String patient_class_PC		= "";
		if(bl_interface_yn.equals("Y")){
			if(!encounter_id.equals("")){
				PreparedStatement pstmtPC	= null;
				ResultSet resultSetPC		= null;
				try {

					pstmtPC		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_BL_SELECT1") ) ;
					pstmtPC.setString(1,facility_id);
					pstmtPC.setString(2,encounter_id);
					pstmtPC.setString(3,patient_id); //added for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription
					resultSetPC	= pstmtPC.executeQuery() ;
					if(resultSetPC.next()){
						patient_class_PC = resultSetPC.getString("ENC_PATIENT_CLASS");
					}
				}
				catch ( Exception e ) {
					e.printStackTrace() ;
				}
				finally {
					closeResultSet( resultSetPC ) ;
					closeStatement( pstmtPC ) ;
				}
			}
			else{
                 patient_class_PC="R";
			}
			hmHeader.put("authorized_by_id",login_by_id);
			hmHeader.put("sal_trn_type",patient_class_PC);
		}
		else{
			hmHeader.put("authorized_by_id","");
			if(!encounter_id.equals("")){
               if(patient_class.equals("IP")){
				   patient_class  ="I";
			   }
			   else  if(patient_class.equals("OP")){
				   patient_class  ="O";
			   }
			   else  if(patient_class.equals("EM")){
				   patient_class  ="E";
			   }
			   else  if(patient_class.equals("DC")){
				   patient_class  ="D";
			   }
			   hmHeader.put("sal_trn_type",patient_class);
			}
			else{
                hmHeader.put("sal_trn_type","R");
			}
		}
		hmHeader.put("cancelled_by_id","");
		hmHeader.put("cancelled_remarks","");
		hmHeader.put("finalized_yn","Y");
		hmHeader.put("gl_interfaced_yn","N");
		hmHeader.put("take_home_yn","N");
		hmHeader.put("trn_type","SAL");
		hmHeader.put("add_qty_sal_yn","N");
		hmHeader.put("patient_id",patient_id);
		hmHeader.put("encounter_id",encounter_id);
		if(patient_class.equals("OP")||patient_class.equals("XT")||patient_class.equals("EM")){
            patient_class="O";
		}
		hmHeader.put("remarks","");
		hmHeader.put("item_class_code","");
		hmHeader.put("module_id","PH");
		hmHeader.put("barcode_2d_applicable_yn",get2DBarcodeApplicable());//Added for MMS-DM-CRF-0174.5
         
       if((patient_class_PC.equals("O")||patient_class_PC.equals("E")||patient_class_PC.equals("R"))&&!(tabData.get( "TOKEN_SERIES_CODE" ).equals(""))){  
			 token_no       =    InsertTokenDetails(connection,tabData,sqlMap,login_by_id,login_at_ws_no,facility_id);
			 hmHeader.put("token_series_code",(String)tabData.get( "TOKEN_SERIES_CODE" ));
			 hmHeader.put("token_serial_no",token_no);
		}

		hmCommon.put("login_by_id",login_by_id);
		hmCommon.put("login_at_ws_no",login_at_ws_no);
		hmCommon.put("login_facility_id",facility_id);

        language_data.add(LanguageId);

		hmData.put("HDR_DATA",hmHeader);
		hmData.put("COMMON_DATA",hmCommon);
		hmData.put("LANGUAGE_DATA",language_data);
		try{
			if(insertDetail.size()!=0){
				hmData.put("DTL_DATA",insertDetail);
				hmData.put("DTL_EXP_DATA",insertExp);

				eST.Common.StSales	stSales		=	new eST.Common.StSales();
				HashMap map							=	stSales.insertSales(connection,hmData);
				if( !(((Boolean) map.get( "result" )).booleanValue()) ){
					connection.rollback();
					result.put( "result", new Boolean( false) ) ;
					result.put("msgid",map.get("msgid"));	
					return result ;
				} 
				else{
					String docno				=	(String)map.get("doc_no");
					String doctypecode			=	(String)map.get("doc_type_code");
					String order_id		        =    "";
					for(int i=0;i<OrderID.size();i++){
						order_id		        = (String) OrderID.get(i);
						if(seq_no.containsKey(order_id)){
							pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_UPDATE1") ) ;
							pstmt_update_disp_hdr_tmp.setString(1,doctypecode );
							pstmt_update_disp_hdr_tmp.setString(2,docno);
							pstmt_update_disp_hdr_tmp.setString(3,(String)tabData.get( "TOKEN_SERIES_CODE" ) );
							pstmt_update_disp_hdr_tmp.setString(4,token_no);  
							pstmt_update_disp_hdr_tmp.setString(5,"DD");               
							pstmt_update_disp_hdr_tmp.setString(6,(String)seq_no.get(order_id));
							pstmt_update_disp_hdr_tmp.setString(7,facility_id);
							pstmt_update_disp_hdr_tmp.executeUpdate();
							closeStatement(pstmt_update_disp_hdr_tmp);
						}
					}
					if(bl_interface_yn.equals("Y") && !patient_class_PC.equals("D")){// && !patient_class_PC.equals("I") removed from if for SRR20056-SCF-7639 ICN027720
					  String  disp_cash_coll_stage   =(String)tabData.get("DISP_CASH_COLL_STAGE");
						//String  token_series_code      =(String)tabData.get("TOKEN_SERIES_CODE");
						if(disp_cash_coll_stage.equals("D")){
							String bl_det=getBillingDetails(connection,facility_id,store_code,st_doc_type,docno,login_by_id,login_at_ws_no,patient_id,encounter_id,patient_class_PC);
							setBLDetails(bl_det);
						  
						}
						setTokenNo(token_no);
					}
				}
			}
			result.put( "result", new Boolean( true) ) ;
		}
		catch(Exception e) {
			//	result.put( "result", new Boolean( false) ) ;
			//	result.put("msgid",map.get("msgid"));	
			e.printStackTrace();
			return result ;
		}
		finally{
			closeStatement(pstmt_update_disp_hdr_tmp);
		}
		return result ;
	}

	public void getTokenSeries(String patient_class) {
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
    	 token_series_code	        =   "";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT155") ) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.getDispLocnCode());
			resultSet	= pstmt.executeQuery();
            if (resultSet.next() ) {
				if(patient_class !=null &&( patient_class.equals("OP") || patient_class.equals("EM") || patient_class.equals("XT"))) // if block and else condition added for SRR20056-SCF-7639 ICN027720
					disp_cash_coll_stage  =   checkForNull(resultSet.getString("DISP_CASH_COLL_STAGE_OP"));
				else
					disp_cash_coll_stage  =   checkForNull(resultSet.getString("DISP_CASH_COLL_STAGE"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
//SELECT A.TOKEN_SERIES_CODE, B.DESCRIPTION,c.DISP_CASH_COLL_STAGE FROM PH_WS_FOR_TOKEN_SERIES A, PH_TOKEN_SERIES_LANG_VW B,ph_disp_locn c WHERE A.FACILITY_ID=? AND A.DISP_LOCN_CODE=? AND A.WS_NO=? AND A.FACILITY_ID=B.FACILITY_ID AND b.facility_id  =c.facility_id AND a.disp_locn_code=c.disp_locn_code AND c.GEN_TOKEN_UPON_DIR_DISP_YN ='Y' AND b.TOKEN_GEN_STAGE ='DD' and A.DISP_LOCN_CODE=B.DISP_LOCN_CODE AND A.TOKEN_SERIES_CODE=B.TOKEN_SERIES_CODE AND B.LANGUAGE_ID = ?
			//connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT73C") ) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.getDispLocnCode());
			pstmt.setString(3,login_at_ws_no);
			pstmt.setString(4,getLanguageId());
			resultSet	= pstmt.executeQuery();

			while( resultSet != null && resultSet.next() ) {
				//token_series_desc  =   checkForNull(resultSet.getString("DESCRIPTION"));

				//disp_cash_coll_stage  =   checkForNull(resultSet.getString("DISP_CASH_COLL_STAGE"));
				
				if(disp_cash_coll_stage.equals("D")||disp_cash_coll_stage.equals("X")){
					token_series_code  =   "";
				}
				else{
					token_series_code  =   checkForNull(resultSet.getString("TOKEN_SERIES_CODE"));	
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
		//return token_series_code;	
	}
	
	public String InsertTokenDetails(Connection connection,HashMap tabData ,HashMap sqlMap,String login_by_id,String login_at_ws_no,String login_facility_id){
	    PreparedStatement pstmt_update3 = null;
		String next_token_series_no = "";
		String disp_locn_code			=(String)tabData.get("disp_location");
        String token_series_code		=(String)tabData.get("TOKEN_SERIES_CODE");
		try{
             next_token_series_no = getNextTokenSeriesNo(connection, sqlMap,login_facility_id,disp_locn_code,token_series_code,(String)tabData.get("LanguageId") );  
			//Update Token Series...
			pstmt_update3 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES") ) ;
			pstmt_update3.setString(1,login_by_id);
			pstmt_update3.setString(2,login_at_ws_no);
			pstmt_update3.setString(3,login_facility_id);
			pstmt_update3.setString(4,login_facility_id);
			pstmt_update3.setString(5,disp_locn_code);
			pstmt_update3.setString(6,token_series_code);
			pstmt_update3.executeUpdate();
			closeStatement(pstmt_update3);
		}
		catch(Exception e){
			e.printStackTrace();
			next_token_series_no="";
		}
		finally{
			try {
				closeStatement( pstmt_update3 );
			} 
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return  next_token_series_no;
	}

	public String getNextTokenSeriesNo(Connection connection ,HashMap sqlMap,String facility_id,String disp_locn_code,String token_series_code,String language_id)throws Exception{

		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String next_token_series_no="";

		try {
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_REG_PRESCRIPTIONS_SELECT15" ) );
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
			pstmt.setString(3,token_series_code.trim());
			pstmt.setString(4,language_id.trim());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				next_token_series_no=resultSet.getString("NEXT_SERIAL_NO" ) ;
			}
			closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
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
		return next_token_series_no;
	}

	public String getItemCost(String item_code,String store_code, String qty_reqd,String eff_date) throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		CallableStatement cstmt = null ;
		String item_cost		=	"";
		try{
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

	public HashMap callinsertNextCollDate(HashMap values){
		HashMap map						 = new HashMap();
		HashMap tabData					 = new HashMap();
		HashMap sqlMap					 = new HashMap();
		HashMap result					 = new HashMap();
		try{
			tabData.put("OrderID",this.getOrderID());
			tabData.put("next_collection_date" , (String)values.get("next_collection_date"));
			tabData.put("bmsReasonCode" , (String)values.get("bmsReasonCode"));
			tabData.put("" , (String)values.get("next_collection_date"));
			//ReRtdDispLocnCode
			tabData.put("ReRtdDispLocnCode" ,(String)values.get("ReRtdDispLocnCode"));
			tabData.put("flag" ,(String)values.get("flag"));
			tabData.put("referral_facility" ,(String)values.get("referral_facility"));
			tabData.put("referral_remarks" ,(String)values.get("referral_remarks"));
			tabData.put("practioner_id" ,(String)values.get("practioner_id"));			
			tabData.put( "properties", getProperties() );
			tabData.put( "facility_id", login_facility_id.trim() );
			tabData.put( "login_at_ws_no", login_at_ws_no.trim());
			tabData.put( "login_by_id", login_by_id.trim());

			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE1",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE1"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_OR_ORDER_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_OR_ORDER_UPDATE"));			
			sqlMap.put("SQL_PH_DIR_DISP_MEDICATION_DTL_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DIR_DISP_MEDICATION_DTL_UPDATE"));			
			sqlMap.put("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_UPDATE"));	
			sqlMap.put("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_LINE_UPDATE1",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_LINE_UPDATE1"));				

			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", "in modify.." ) ;
			map.put( "flag", "0" ) ;		
		
			//DispMedicationHome   home	= null;
			//	DispMedicationRemote remote	= null;
			//	InitialContext context = new InitialContext() ;
			//	Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_DISP_MEDICATION") ) ;

			//	home  = (DispMedicationHome) PortableRemoteObject.narrow( object, DispMedicationHome.class ) ;
			//	remote = home.create() ;
			result= printdialoginsert(tabData, sqlMap);
			//result = remote.insert( tabData, sqlMap ) ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
    
	public HashMap printdialoginsert( HashMap tabData, HashMap sqlMap ) throws Exception {
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag","0");

		String query	=	(String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE1");
		String sql_2	=	(String)sqlMap.get("SQL_PH_DISP_MEDICATION_OR_ORDER_UPDATE");
		String sql_3	=	(String)sqlMap.get("SQL_PH_DIR_DISP_MEDICATION_DTL_UPDATE"); 
		String sql_4	=	(String)sqlMap.get("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_UPDATE"); 
		String sql_5	=	(String)sqlMap.get("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_LINE_UPDATE1"); 
		Connection connection							= null ;
		PreparedStatement pstmt_update_or_order_line_ph	= null;
		PreparedStatement pstmt_update_or_order	= null;
		PreparedStatement pstmt_update_ph_disp_dtl	= null;
		PreparedStatement pstmt_update_or_order_referral= null;
		PreparedStatement pstmt_update_or_order_line_referral	= null;
		boolean result=true;

		try{
			//prop				= (Properties)tabData.get( "properties" );	
			//connection = getConnection( prop ) ;
			connection			= getConnection() ;

			String flag		=	(String)tabData.get("flag");
			String order_id	=	null;
			pstmt_update_or_order_line_ph	= connection.prepareStatement(query);
			pstmt_update_or_order	= connection.prepareStatement(sql_2);
			pstmt_update_ph_disp_dtl = connection.prepareStatement(sql_3);
			pstmt_update_or_order_referral= connection.prepareStatement(sql_4);
			pstmt_update_or_order_line_referral	=connection.prepareStatement(sql_5);
			ArrayList  OrderIDs =(ArrayList)tabData.get("OrderID") ; 
			if(OrderIDs.size()>0){	
				for(int i=0; i<OrderIDs.size();i++) {
					order_id=(String)OrderIDs.get(i);
					pstmt_update_or_order_line_ph.setString(1,(String)tabData.get("next_collection_date"));
					pstmt_update_or_order_line_ph.setString(2,(String)tabData.get("bmsReasonCode"));
					pstmt_update_or_order_line_ph.setString(3,(String)tabData.get("login_by_id"));
					pstmt_update_or_order_line_ph.setString(4,(String)tabData.get("facility_id"));
					pstmt_update_or_order_line_ph.setString(5,(String)tabData.get("login_at_ws_no"));
					pstmt_update_or_order_line_ph.setString(6,order_id);
					pstmt_update_or_order_line_ph.setString(7,order_id);
					pstmt_update_or_order_line_ph.addBatch();
					if(flag.equals("C")){
						pstmt_update_or_order.setString(1,(String)tabData.get("ReRtdDispLocnCode"));
						pstmt_update_or_order.setString(2,(String)tabData.get("login_by_id"));
						pstmt_update_or_order.setString(3,(String)tabData.get("login_at_ws_no"));
						pstmt_update_or_order.setString(4,(String)tabData.get("facility_id"));
						pstmt_update_or_order.setString(5,order_id);
						pstmt_update_or_order.addBatch();

						pstmt_update_ph_disp_dtl.setString(1,(String)tabData.get("ReRtdDispLocnCode"));
						pstmt_update_ph_disp_dtl.setString(2,(String)tabData.get("facility_id"));
						pstmt_update_ph_disp_dtl.setString(3,order_id);		
						pstmt_update_ph_disp_dtl.addBatch();
					}
					if(flag.equals("E")) {

						pstmt_update_or_order_referral.setString(1,(String)tabData.get("referral_facility"));
						pstmt_update_or_order_referral.setString(2,(String)tabData.get("practioner_id"));
						pstmt_update_or_order_referral.setString(3,(String)tabData.get("referral_remarks"));
						pstmt_update_or_order_referral.setString(4,(String)tabData.get("login_by_id"));
						pstmt_update_or_order_referral.setString(5,(String)tabData.get("login_at_ws_no"));
						pstmt_update_or_order_referral.setString(6,(String)tabData.get("facility_id"));
						pstmt_update_or_order_referral.setString(7,order_id);
						pstmt_update_or_order_referral.addBatch();		

						pstmt_update_or_order_line_referral.setString(1,order_id);		
						pstmt_update_or_order_line_referral.addBatch();
					}
				}//for
				int[] result1=pstmt_update_or_order_line_ph.executeBatch();
				for (int k=0;k<result1.length ;k++ ){
					if(result1[k]<0  && result1[k] != -2 ){
						pstmt_update_or_order_line_ph.cancel();
						result=false;
						break;
					}		
				}
				if(flag.equals("C")) {// Changed from E to C for HSA-CRF-0113 [IN:048166] 
					int[] result2 = pstmt_update_or_order.executeBatch();
					int[] result3 = pstmt_update_ph_disp_dtl.executeBatch();
					for (int k=0;k<result2.length ;k++ ){
						if(result2[k]<0  && result2[k] != -2 ){
							pstmt_update_or_order.cancel();
							result=false;
							break;
						}		
					}
					for (int k=0;k<result3.length ;k++ ){
						if(result3[k]<0  && result3[k] != -2 ){
							pstmt_update_ph_disp_dtl.cancel();
							result=false;
							break;
						}		
					}
				}
				if(flag.equals("E")) {
					int[] result2 = pstmt_update_or_order_referral.executeBatch();
					int[] result3 = pstmt_update_or_order_line_referral.executeBatch();
					for (int k=0;k<result2.length ;k++ ){
						if(result2[k]<0  && result2[k] != -2 ){
							pstmt_update_or_order_referral.cancel();
							result=false;
							break;
						}		
					}
					for (int k=0;k<result3.length ;k++ ){
						if(result3[k]<0  && result3[k] != -2 ){
							pstmt_update_or_order_line_referral.cancel();
							result=false;
							break;
						}		
					}
				}
			}//if
			if(result)
				connection.commit();
			else
				connection.rollback();
		}
		catch(Exception e){
			connection.rollback();
			e.printStackTrace();
			//connection.rollback();
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			map.put("flag",e.toString());
		}
		finally{
			try{
				closeStatement( pstmt_update_or_order_line_ph );
				closeStatement( pstmt_update_or_order );
				closeStatement( pstmt_update_ph_disp_dtl );
				closeStatement( pstmt_update_or_order_referral );
				closeStatement( pstmt_update_or_order_line_referral );
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return map ;
	}

	//code starts for Billing interface
	public String checkforbillinginterface()throws Exception{
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet			    = null;	
		String bl_interface_yn			= "N";
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
		return bl_interface_yn;
	}

	public HashMap callItemChargeDtls(String patient_id,String encounter_id,String sal_trn_type,String item_code,int item_qty,String batch_str,String sysdate,String store_code,String bl_override_excl_incl_ind,String bl_override_override_reson,String dischargeIND,String start_date,String end_date)throws Exception{ //start_date and end_date added for MMS-CRF-0126.2
			
		Connection connection				= null;
		CallableStatement callableStatement = null;
		HashMap message						= new HashMap();
		String total_charge_amt				= "";
		String patient_payable_amt			= "";
		String grosschargeamt				= "";
		PreparedStatement pstmt				= null;
		ResultSet rsDecimalPlace			= null;
		int decimal_place					= 0;
		String decimalFormatString			= "##";

		try{
//System.err.println("==9243===DirectDispensing===login_facility_id=="+login_facility_id+"==patient_id====" +patient_id+"===encounter_id===" + encounter_id+"===sal_trn_type===" + sal_trn_type+"==sysdate====" + sysdate+"===item_code===" + item_code +"===store_code===" + store_code+"==item_qty===="+item_qty+"==batch_str===="+batch_str+"==bl_override_excl_incl_ind===="+bl_override_excl_incl_ind+"==bl_override_override_reson===="+bl_override_override_reson);	
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/MM/yyyy hh24:mi:ss'),to_date(?,'dd/MM/yyyy hh24:mi:ss')) }");
			callableStatement.setString(1, login_facility_id);
			callableStatement.setString(2, patient_id);
			callableStatement.setString(3, "ST");
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
			if(bl_override_excl_incl_ind.equals("")){
				callableStatement.setString(39, "");
			    callableStatement.setString(40, "");
			}
			else{
				callableStatement.setString(39, bl_override_excl_incl_ind);
			    callableStatement.setString(40, bl_override_override_reson);
			}
			callableStatement.setString(41, "N"); //Internal Adjestment
			callableStatement.setString(42, "N");//discharge indicator
			callableStatement.setString(43, "");//discharge indicator
			callableStatement.setString(44, "");//discharge indicator
			callableStatement.setString(45, dischargeIND);
			callableStatement.registerOutParameter(46, Types.VARCHAR); //added for JD-CRF-0170.1 [IN:040204]
			callableStatement.setString(47, "");//discharge indicator //MMS-DM-CRF-0126.2
			callableStatement.setString(48, "");//discharge indicator //MMS-DM-CRF-0126.2
			callableStatement.setString(49, start_date);//discharge indicator //MMS-DM-CRF-0126.2
			callableStatement.setString(50, end_date);//discharge indicator//MMS-DM-CRF-0126.2
			

			callableStatement.execute();		
			grosschargeamt			= callableStatement.getString(19);
			total_charge_amt		= callableStatement.getString(21);			
			patient_payable_amt		= callableStatement.getString(25);
			
			message.put("error_id" , checkForNull((String)callableStatement.getString(33)));
			message.put("error_msg" , checkForNull((String)callableStatement.getString(34)));
			message.put("excl_incl_ind" , checkForNull((String)callableStatement.getString(35),""));
			message.put("approval_reqd_yn" , checkForNull((String)callableStatement.getString(36),"N"));
			message.put("override_allowed_yn" , checkForNull((String)callableStatement.getString(37),""));
			message.put("pat_paid_amt" , checkForNull((String)callableStatement.getString(38)));

            pstmt = connection.prepareStatement("SELECT BLCORE.GET_DECIMAL_PLACE(?) decimal_place FROM dual");
			pstmt.setString(1,login_facility_id);
			rsDecimalPlace = pstmt.executeQuery();
			if(rsDecimalPlace.next())
				decimal_place = rsDecimalPlace.getInt("decimal_place");
			closeStatement( pstmt ) ;
			closeResultSet( rsDecimalPlace );

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
	}


	private String getBillingDetails(Connection connection,String login_facility_id,String Store_code,String doc_type_code,String doc_no,String login_by_id,String login_at_ws_no,String patient_id ,String encounter_id,String sal_trn_type ){
		HashMap message_bill  =   new HashMap();
		String p_charge_amt   =   "99999";
		String msg            =   "";
		String	hmResult	=	"";
		CallableStatement callableStatement = null;
		StringBuffer gross_charge_display_str  = new StringBuffer();
		try{

			callableStatement	= connection.prepareCall("{ call ST_BL_BILL_GEN (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, login_facility_id); 
			callableStatement.setString(2, Store_code);
			callableStatement.setString(3, doc_type_code+"-"+doc_no );
			callableStatement.setString(4, login_by_id);//login_by_id
			callableStatement.setString(5, login_at_ws_no);
			callableStatement.setFloat(6,  Float.parseFloat(p_charge_amt));
			callableStatement.setString(7, patient_id);
			callableStatement.setString(8, sal_trn_type);
			callableStatement.setString(9, encounter_id);

			callableStatement.registerOutParameter(10, Types.VARCHAR);
			callableStatement.registerOutParameter(11, Types.VARCHAR);
			callableStatement.registerOutParameter(12, Types.VARCHAR);
			callableStatement.registerOutParameter(13, Types.VARCHAR);
			callableStatement.registerOutParameter(14, Types.VARCHAR);
			callableStatement.registerOutParameter(15, Types.VARCHAR);
			callableStatement.setString(16, "PH");
			callableStatement.setString(17,  "Y");
			callableStatement.setString(19, login_facility_id); //added for MOHE-CRF-0060
			callableStatement.registerOutParameter(18, Types.VARCHAR);
			callableStatement.execute();

			message_bill.put("l_slmt_reqd_yn" , (String)callableStatement.getString(10));
			message_bill.put("l_bill_doc_type" , (String)callableStatement.getString(11));
			message_bill.put("l_bill_doc_num" , (String)callableStatement.getString(12));
			message_bill.put("v_blng_group_id" , (String)callableStatement.getString(13));
			message_bill.put("error_id" , (String)callableStatement.getString(14));
			message_bill.put("p_call_disc_function_yn" , (String)callableStatement.getString(18)==null?"N":(String)callableStatement.getString(18));
			String err_text = (String)callableStatement.getString(15)==null?"":(String)callableStatement.getString(15);			
			message_bill.put("error_id_txt" , err_text);
		   
			if((checkForNull((String)message_bill.get("error_msg"))) !=""){
				msg = (String)message_bill.get("error_id") + "  " + (String)message_bill.get("error_msg"); 
				System.err.println("error message=" + msg);
				throw new Exception(msg +"  -   doc_no:" + doc_no);
			}	
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try{
				closeStatement( callableStatement ) ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}		      
	    //gross_charge_display_str.append((String)message_bill.get("l_bill_doc_num")).append(",").append((String)message_bill.get("l_bill_doc_type")).append(",").append((String)message_bill.get("v_blng_group_id")).append(",").append((String)message_bill.get("error_id_txt"));
		gross_charge_display_str.append((String)message_bill.get("l_bill_doc_num")).append(",").append((String)message_bill.get("l_bill_doc_type")).append(",").append((String)message_bill.get("v_blng_group_id")).append(",").append((String)message_bill.get("p_call_disc_function_yn")).append(",").append((String)message_bill.get("l_slmt_reqd_yn")).append(",").append(doc_type_code+"-"+doc_no).append(",").append(patient_id).append(",").append(encounter_id).append(",").append(sal_trn_type).append(",").append((String)message_bill.get("error_id_txt"));
		hmResult = gross_charge_display_str.toString();
		return hmResult;	
	}//BL interface ends here 

	public String getBLSysDates(){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		//ArrayList fm_to_dates		= new ArrayList();
		String sys_date				=	"";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date=resultSet.getString("SYS_DATE");
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
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
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return sys_date;
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

	public String getEncounterPatientClass(String encounter_id, String patient_id) throws Exception{ //patient_id added for [IN:035667] 
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String patient_class	= "";
		try {
            encounter_id =checkForNull(encounter_id);
			if(encounter_id.equals("null")||encounter_id ==null)
			    encounter_id="";
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1")) ;
			
			pstmt.setString(1,login_facility_id.trim());
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
				es.printStackTrace();
			}
        }
		return param_values;
	}//kri

	public HashMap callItemChargeDtls(String patient_id,String encounter_id,String sal_trn_type,String item_code,int item_qty,String batch_str,String sysdate,String store_code,String bl_override_excl_incl_ind,String bl_incl_excl_override_reason_code,String order_id,String order_line_no,String disp_stage,String dischargeIND)throws Exception{
			
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
		encounter_id =checkForNull(encounter_id);
	    if(encounter_id.equals("null")||encounter_id ==null)
			encounter_id="";

		if(sal_trn_type.equals(""))
			sal_trn_type="R";
		try{
			String worksheet_yn						 = "N";
			if(disp_stage.equals("A")||disp_stage.equals("F")||disp_stage.equals("D")){
			   String ord_type						     ="" ;// disp_bean.getOrderType();
			  // disp_billing_stage=disp_bean.getDisp_Bill_Stage();
			   if(ord_type.equals("IVAA")||ord_type.equals("IVIA")||ord_type.equals("CA")||ord_type.equals("TA")||ord_type.equals("CO")){
					worksheet_yn                   ="Y";        
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
			//System.err.println("=====DirectDispensing===login_facility_id=="+login_facility_id+"==patient_id====" +patient_id+"===encounter_id===" + encounter_id+"===sal_trn_type===" + sal_trn_type+"==sysdate====" + sysdate+"===item_code===" + item_code +"===store_code===" + store_code+"==item_qty===="+item_qty+"==batch_str===="+batch_str);	 
			callableStatement	= connection.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, login_facility_id);
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
			callableStatement.setString(45, "N");
			callableStatement.registerOutParameter(46, Types.VARCHAR); //added for JD-CRF-0170.1 [IN:040204]
			callableStatement.setString(47,order_id); //MMS-DM-CRF-0126.2
			callableStatement.setString(48, order_line_no); //MMS-DM-CRF-0126.2
System.err.println("DirectDispensingBean.java===8944===order_id======>"+order_id+"==order_line_no==>"+order_line_no);

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

	private boolean insertConsumableDeatil(Connection connection, HashMap sqlMap, HashMap tabData) throws Exception {
		PreparedStatement pstmt_insert_cons_drug_dtl	= null;
		int count					=	1;
		String drug_code		    =  "";	
		boolean result              =  true;

		try {
			String status      ="DL";
			pstmt_insert_cons_drug_dtl	= connection.prepareStatement( "INSERT INTO PH_DISP_CONS_DTL  (FACILITY_ID,DISP_TRN_SEQ_NO,DISP_NO,SRL_NO,ORDERING_FACILITY_ID,ORDER_ID,ORDER_LINE_NO,DISP_LOCN_CODE,STORE_CODE,ORDER_CONS_CODE,DISP_CONS_CODE,DISP_ITEM_CODE,STK_UOM_CODE,DISP_QTY,DISP_UOM_CODE,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,DAILY_DISP_SRL_NO,STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)" ) ;

			ArrayList tot_cons_dtl = (ArrayList)tabData.get("CONSUMABLES_DET");
			HashMap  cons_dtl      =  new HashMap(); 
			//String trx_sequence_no =  "";   Removed for IN063877
			HashMap batchDetails   =  new HashMap(); 
			String sequence_no     = getSequenceNo((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT33"));

			for(int i=0;i<tot_cons_dtl.size();i++){
				cons_dtl =(HashMap)tot_cons_dtl.get(i);
			    if(cons_dtl.get("SELECTED_YN").equals("Y")&& !cons_dtl.get("ALLOC_QTY").equals("")){           
					count=1;
					batchDetails = (HashMap)cons_dtl.get("BATCH_DET");
					drug_code	 = (String)batchDetails.get("ITEM_CODE");
					
					cons_dtl.put("DISP_NO",sequence_no);
					cons_dtl.put("DISP_SRL_NO",(i+1)+"");
                    cons_dtl.put("ORDER_STATUS",status);

					pstmt_insert_cons_drug_dtl.setString(count,(String)tabData.get("facility_id"));
                    pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("TRX_SEQ_NO"));
					pstmt_insert_cons_drug_dtl.setString(++count,sequence_no);
					pstmt_insert_cons_drug_dtl.setString(++count,(i+1)+"");
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("facility_id"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)cons_dtl.get("ORDER_ID"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)cons_dtl.get("ORDER_LINE_NO")); 
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("disp_location"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("store_code"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)cons_dtl.get("ORDER_CATALOG_CODE"));
					pstmt_insert_cons_drug_dtl.setString(++count,drug_code.trim());
					pstmt_insert_cons_drug_dtl.setString(++count,drug_code.trim());
					pstmt_insert_cons_drug_dtl.setString(++count,(String)cons_dtl.get("ORDER_UOM"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)cons_dtl.get("ALLOC_QTY"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)cons_dtl.get("ORDER_UOM"));
					pstmt_insert_cons_drug_dtl.setString(++count,"");
					pstmt_insert_cons_drug_dtl.setString(++count,"");
					pstmt_insert_cons_drug_dtl.setString(++count,"");
					pstmt_insert_cons_drug_dtl.setString(++count,status);
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("facility_id"));				
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("facility_id"));
					pstmt_insert_cons_drug_dtl.addBatch();
				}
			}
			int[] result4=pstmt_insert_cons_drug_dtl.executeBatch();
			for (int k=0;k<result4.length ;k++ ){
				if(result4[k]<0  && result4[k] != -2 ){
					pstmt_insert_cons_drug_dtl.cancel();
					result=false;
					connection.rollback();
					System.err.println("Consumable Details Failed");
				}		
			}
		}
		catch(Exception e){
			e.printStackTrace();
			try {
				result=false;
				connection.rollback();
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		finally{	
			try {
				closeStatement( pstmt_insert_cons_drug_dtl) ;
				 pstmt_insert_cons_drug_dtl=null;

			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return result  ;       
	}

	private boolean insertConsumableBatch(Connection connection, HashMap sqlMap, HashMap tabData) throws Exception {
		PreparedStatement pstmt_insert_cons_drug_batch	= null;
		int count					=	1;
	//	String drug_code		    = ""; Removed for IN063877	
		boolean result=true;
		try {

			pstmt_insert_cons_drug_batch	= connection.prepareStatement( "INSERT INTO PH_DISP_CONS_BATCH(FACILITY_ID,DISP_NO,SRL_NO  ,SRL_NO_BATCH,DISP_LOCN_CODE,STORE_CODE,CONS_CODE,BATCH_ID,EXPIRY_DATE,TRADE_ID,DISP_QTY,DISP_QTY_UOM,BIN_LOCATION_CODE, LOOSE_STOCK_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
			ArrayList tot_cons_dtl = (ArrayList)tabData.get("CONSUMABLES_DET");
			HashMap  cons_dtl      =  new HashMap(); 
			HashMap batchDetails   =  new HashMap(); 
			//String trx_sequence_no =  "";  Removed for IN063877
			int batch_srl_no       = 500;   
			for(int i=0;i<tot_cons_dtl.size();i++){
				cons_dtl =(HashMap)tot_cons_dtl.get(i);
			    if(cons_dtl.get("SELECTED_YN").equals("Y")&& !cons_dtl.get("ALLOC_QTY").equals("")){           
					count=1;
					batchDetails = (HashMap)cons_dtl.get("BATCH_DET");
					cons_dtl.put("BATCH_SRL_NO",batch_srl_no+"");
					pstmt_insert_cons_drug_batch.setString(count,  (String)tabData.get("facility_id"));
                    pstmt_insert_cons_drug_batch.setString(++count,(String)cons_dtl.get("DISP_NO"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)cons_dtl.get("DISP_SRL_NO"));
					pstmt_insert_cons_drug_batch.setString(++count, batch_srl_no+"");
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("disp_location"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("store_code"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)batchDetails.get("ITEM_CODE"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)batchDetails.get("BATCH_ID"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)batchDetails.get("EXPIRY_DATE"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)batchDetails.get("TRADE_ID"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)cons_dtl.get("ALLOC_QTY"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)cons_dtl.get("ORDER_UOM"));
                    pstmt_insert_cons_drug_batch.setString(++count,(String)batchDetails.get("BIN_LOCN_CODE"));
					pstmt_insert_cons_drug_batch.setString(++count,"N");					
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("facility_id"));				
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("facility_id"));
					pstmt_insert_cons_drug_batch.addBatch();
					batch_srl_no++;
				}
			}
			int[] result4=pstmt_insert_cons_drug_batch.executeBatch();
			for (int k=0;k<result4.length ;k++ ){
				if(result4[k]<0  && result4[k] != -2 ){
					pstmt_insert_cons_drug_batch.cancel();
					result=false;
					connection.rollback();
				}		
			}
		}
		catch(Exception e){
			e.printStackTrace();
			try {
				result=false;
				connection.rollback();
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		finally{	
			try {
				closeStatement( pstmt_insert_cons_drug_batch) ;
				 pstmt_insert_cons_drug_batch=null;

			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return result;
	}

	public int getPhysicalinventoryitemYN(String drug_code,String store_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		int count					= 0;
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DIRECT_DISPENSING_SELECT14")) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2,store_code);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				count = resultSet.getInt("total");			
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

	public int getBalanceMedicationcount(String disp_no)throws Exception{
		int  count	=0;
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT153") ) ;
			pstmt.setString(1,disp_no);
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				count=resultSet.getInt("cnt") ;
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
		return count;
	}

	/*=======================================variable UOM =========================*/
	public String getIssueByUOMBy() throws Exception{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String IssueByUOMBy	= "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( "select ISSUE_UOM_BY from ph_param") ;	
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				IssueByUOMBy = checkForNull(resultSet.getString("ISSUE_UOM_BY"));
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
		return IssueByUOMBy;
	}

	public ArrayList loadStockUnit(String item_code){
		ArrayList stock_unit	= new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		try{
			connection			= getConnection() ;
			//pstmt = connection.prepareStatement( "select  EQVL_UOM_CODE uom_code,SHORT_DESC, EQVL_VALUE from MM_ITEM_UOM_DEFN a, am_uom_lang_vw b where ITEM_CODE =? and a.EQVL_UOM_CODE =b.uom_code and b.LANGUAGE_ID=?" ) ;
			pstmt = connection.prepareStatement( "select  EQVL_UOM_CODE uom_code,SHORT_DESC, PH_calculate_equl_val(a.ITEM_CODE,a.UOM_CODE,a.EQVL_UOM_CODE) EQVL_VALUE ,(eqvl_value / eqvl_uom_qty) ACT_EQVL_VALUE from MM_ITEM_UOM_DEFN a, am_uom_lang_vw b where ITEM_CODE =? and a.EQVL_UOM_CODE =b.uom_code and b.LANGUAGE_ID=?	 " ) ;
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
			pstmt		= connection.prepareStatement( "SELECT DEF_ISSUE_UOM,GEN_UOM_CODE FROM ST_ITEM_STORE a, mm_item b WHERE STOCK_ITEM_YN = 'Y' AND a.STORE_CODE = ? AND a.ITEM_CODE = ? AND a.EFF_STATUS = 'E'and b.EFF_STATUS='E' and a.item_code =b.item_code") ;
			pstmt.setString(1,store_code);
			pstmt.setString(2,drug_code);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				def_issue_uoms.put("DEF_ISSUE_UOM",	checkForNull(resultSet.getString("DEF_ISSUE_UOM")));				
				def_issue_uoms.put("BASE_UOM",	checkForNull(resultSet.getString("GEN_UOM_CODE")));
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
		return def_issue_uoms;
	}

/* public int  lcm(int frm_tmp, int to_tmp) {
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
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		double eqvl_value			= 0;
		try {
            connection	= getConnection() ;
            //pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			//pstmt		= connection.prepareStatement( "select EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;//changed for 553.1
			pstmt		= connection.prepareStatement( "select PH_calculate_equl_val(ITEM_CODE,UOM_CODE,EQVL_UOM_CODE) EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=? and EFF_STATUS = 'E'") ;

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

	public double getActualEqulValue (String item_code,String uom_code,String equl_uom_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		double eqvl_value			= 1;
		try {
            connection	= getConnection() ;
            //pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			//pstmt		= connection.prepareStatement( "select EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;//changed for 553.1
			pstmt		= connection.prepareStatement( "select (eqvl_value / eqvl_uom_qty) EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=? ") ;
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
				}catch(Exception es){es.printStackTrace();}
		}
		return short_desc;
	}

/*=======code adeed for handling variable UOM*/
   private HashMap getBaseAndIssueUOMQty(Connection connection, String item_code, String store_code,String disp_qty, String disp_uom){
        PreparedStatement pstmt             = null ;
        ResultSet resultSet                 = null ;
		String base_uom						= "";
		String def_store_uom				= "";
		double  base_to_disp_uom_equl_value	= 0;
		double  base_to_def_uom_equl_value	= 0;
		HashMap BaseAndIssueQTYDetail		= new HashMap();
		double base_qty						= 0;
		double issue_qty					= 0;
		
		try{
			pstmt					= connection.prepareStatement("SELECT DEF_ISSUE_UOM,GEN_UOM_CODE FROM ST_ITEM_STORE a, mm_item b WHERE STOCK_ITEM_YN = 'Y' AND a.STORE_CODE = ? AND a.ITEM_CODE = ? AND a.EFF_STATUS = 'E'and b.EFF_STATUS='E' and a.item_code =b.item_code");
			pstmt.setString(1,store_code);
			pstmt.setString(2,item_code);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				base_uom		=	resultSet.getString("GEN_UOM_CODE");
				def_store_uom	=	resultSet.getString("DEF_ISSUE_UOM");
			}
           base_to_disp_uom_equl_value	=	getEqulValue (connection, item_code, base_uom, disp_uom);
		   base_to_def_uom_equl_value	=	getEqulValue (connection, item_code, base_uom, def_store_uom);
		   if( base_uom.equals(disp_uom))
			   base_to_disp_uom_equl_value=1;
		   if(base_uom.equals(def_store_uom))
			   base_to_def_uom_equl_value=1;
           base_qty						=	 Double.parseDouble(disp_qty)*(base_to_disp_uom_equl_value);
		  // issue_qty					=	base_qty/base_to_def_uom_equl_value;
		   issue_qty                     =   base_qty/base_to_def_uom_equl_value;

		   BaseAndIssueQTYDetail.put("BASE_QTY",base_qty+"");
		   BaseAndIssueQTYDetail.put("ISSUE_QTY",issue_qty+"");
		}
		catch ( Exception e ) {
            e.printStackTrace() ;
		}
		finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				//closeConnection( connection );
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }

		return BaseAndIssueQTYDetail;
	}

	public double getEqulValue (Connection connection,String item_code,String uom_code,String equl_uom_code){
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		double eqvl_value			= 0;
		try {

          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			//pstmt		= connection.prepareStatement( "select EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;
			pstmt		= connection.prepareStatement( "select eqvl_value/eqvl_uom_qty EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return eqvl_value;
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

	public String getLocalInstruction(String label_id){
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		String label_text			        = "";

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "select LABEL_TEXT_1 from ph_label_text_lang_vw where LABEL_TEXT_ID =? and LANGUAGE_ID =?") ;
			
			pstmt.setString(1,label_id);
			pstmt.setString(2,getSMLOcalLanguageID());
		
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				label_text = checkForNull(resultSet.getString("LABEL_TEXT_1"));
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
		return label_text;
   }

   public String getDefaultLanguageForDispenseLabel(String patient_id) throws Exception{

		String result			= "";
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		//if(patient_class==null){patient_class="";}
		//if(!patient_class.equals("IP"))patient_class="OP";
		try {
	        connection	= getConnection() ;
          /*  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DFLT_LANG")) ;
			pstmt.setString(1,login_facility_id.trim());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				if(patient_class.equals("OP")){
					result=resultSet.getString("DFLT_LANG_FOR_DISP_LABEL");
				}else{
					result=resultSet.getString("DFLT_LANG_FOR_DISP_LABEL_IP");
				}
			}*/
			 pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DFLT_LANG1")) ;
			 pstmt.setString(1,patient_id);
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){				
				result=resultSet.getString("LOCAL_YN");				
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

	public String getPrescribedQty(String dosage_type,String equl_value,String fract_dose,String qty_value,String repeat_value,String strength_per_value_per_pres_uom, String strength_per_pres_uom,String ord_qty,String strength_value,String durn_value1){

		String in_order_qty="";		
		if(dosage_type.equals("Q")){
			if(fract_dose.equals("N")) { 
				in_order_qty	=	(Float.parseFloat(qty_value)*Float.parseFloat(durn_value1)*Float.parseFloat(repeat_value)*Float.parseFloat(equl_value))+"";
			}
			else{
				in_order_qty	=(Math.ceil(	Float.parseFloat(qty_value)*Float.parseFloat(durn_value1)*Float.parseFloat(repeat_value)*Float.parseFloat(equl_value)))+"";
			}
		}
		else if(dosage_type.equals("S")){
			if(fract_dose.equals("N")) { 			
				in_order_qty=((Float.parseFloat(qty_value)*Float.parseFloat(durn_value1)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))/Float.parseFloat(strength_per_pres_uom))+"";
			}
			else{
				in_order_qty=(Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(strength_value)*Float.parseFloat(durn_value1)*Float.parseFloat(strength_per_value_per_pres_uom))/Float.parseFloat(strength_per_pres_uom)))+"";
			}
		}
		else{				
			in_order_qty=ord_qty;
		}
		return in_order_qty;
	}
	
	public int getNoOfDecimals(){
		Connection oConnection		    = null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		int iNoOfDecimals=0;
		
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
			catch ( Exception e ) {
				e.printStackTrace() ;
			}
		}
		return iNoOfDecimals;
	}
	
	public String retunFormatedInt(String sValue,int noOfDecimals){
		String formatString="#";
		if(noOfDecimals>0){
			formatString="#.";
			for(int i=0;i<noOfDecimals;i++){
				formatString=formatString+"#";
			}
		}		
		DecimalFormat dfToInteger = new DecimalFormat(formatString);
		if(sValue != null && !sValue.equals("")){
			return dfToInteger.format(Double.parseDouble(sValue));
		}
		return "";
	}

	public ArrayList getPrnRemarkForDrug(String drugCode)throws Exception{
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		ArrayList prnRemarks = new ArrayList();
		HashMap temp = new HashMap();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "SELECT A.REASON_CODE,A.DEFAULT_REASON_YN, B.REASON_DESC, B.REMARKS FROM PH_PRN_REMARK_FOR_DRUG A, PH_MEDN_TRN_REASON_LANG_vw B WHERE A.REASON_CODE=B.REASON_CODE AND A.DRUG_CODE=? AND LANGUAGE_ID=? and b.eff_status='E'") ;
			pstmt.setString(1,drugCode);
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null){
				while(resultSet.next()){
					temp = new HashMap();
					temp.put("REASON_CODE",resultSet.getString("REASON_CODE"))	;			
					temp.put("REASON_DESC",resultSet.getString("REASON_DESC"))	;	
					temp.put("REMARKS",resultSet.getString("REMARKS"))	;	
					temp.put("DEFAULT_REASON_YN",resultSet.getString("DEFAULT_REASON_YN"))	;
					prnRemarks.add(temp);
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
		return prnRemarks;
	}

	public String getActionText(String form_code, String route_code){ //Add this method for SKR-CRF-0006[IN029561]	
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		String action_text			        = "";

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "SELECT ACTION_TEXT_LABEL FROM PH_ROUTE_FOR_FORM_LANG_VW WHERE FORM_CODE=? AND ROUTE_CODE=? and  LANGUAGE_ID=? ") ;
			
			pstmt.setString(1,form_code);
			pstmt.setString(2,route_code);
			pstmt.setString(3,getLanguageId());		

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
	
	public String getCustomerID()throws Exception	{//Add this method for RUT-CRF-0067
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
	
	public String getPatient_name(String patient_id )throws Exception	{//Add this method for RUT-CRF-0067
		Connection connection		= null;
		PreparedStatement pstmt		= null;
		ResultSet rsCustomerID		= null;
		String patient_name			= "";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("select nvl(decode(?,'en',patient_name,PATIENT_NAME_LOC_LANG),patient_name) patient_name from mp_patient where patient_id =?");
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patient_id);
			rsCustomerID = pstmt.executeQuery();
			
			if(rsCustomerID.next()){
				patient_name = rsCustomerID.getString("patient_name");
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
		return patient_name;
	}

	public String getPrintNoOfCopies(String drugCode)throws Exception{	//Add this method for RUT-CRF-0067
	
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

	//Add this method for RUT-CRF-0067
	public void updateDTLValues()throws Exception{
		PreparedStatement pstmt_update_disp_dtl	= null;
		Connection connection				= null ;
		int count				=	1;
		HashMap insertRecords_2 = null;
		String order_id="" ;	
		boolean blRecUpdated=true;
		
		try{
			connection		  = getConnection();
			pstmt_update_disp_dtl	= connection.prepareStatement("update ph_disp_dtl set LABEL_CAU_INSTRN1_ENG =? , LABEL_CAU_INSTRN2_ENG=? , LABEL_SPL_INSTRN1_ENG=? , LABEL_SPL_INSTRN2_ENG=? , LABEL_PAT_INSTRN1_ENG=? , LABEL_CAU_INSTRN1_LOC=? , LABEL_CAU_INSTRN2_LOC=? , LABEL_SPL_INSTRN1_LOC=? , LABEL_SPL_INSTRN2_LOC=? , LABEL_PAT_INSTRN1_LOC=?,DRUG_INDICATION=?,MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=? where facility_id = ? AND order_id = ? AND order_line_no=?");
			
			ArrayList	headerList	=   null;
			ArrayList OrderID =this.getOrderID();
			ArrayList OrderDetails		=this.getOrderDetails();
			ArrayList edit_result		= null;
			int cunt = 0;//Added for BSP-SCF-0025[IN062763]
			for(int i=0;i<OrderID.size();i++){
				order_id		= (String) OrderID.get(i);
				headerList		= (ArrayList) OrderDetails.get(i);
				for(int j=0;j<headerList.size();j++){
					insertRecords_2=(HashMap) headerList.get(j);
					count	=	0;
					//for updating cautions and special instructions.....	
					edit_result=new ArrayList();//Added BSP-SCF-0025 [IN062763]
					if(insertRecords_2.containsKey("EDITLABEL")) 			
						edit_result =(ArrayList)insertRecords_2.get("EDITLABEL");
						if(edit_result!=null && edit_result.size()!=0){
	//i changed to count  for BSP-SCF-0025 [IN062763]
							pstmt_update_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+0));//changed i to cunt for BSP-SCF-025
							pstmt_update_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+1));//changed i to cunt for BSP-SCF-025
							pstmt_update_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+2));//changed i to cunt for BSP-SCF-025
							pstmt_update_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+3));//changed i to cunt for BSP-SCF-025
							pstmt_update_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+4));//changed i to cunt for BSP-SCF-025
							pstmt_update_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+5));//changed i to cunt for BSP-SCF-025
							pstmt_update_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+6));//changed i to cunt for BSP-SCF-025
							pstmt_update_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+7));//changed i to cunt for BSP-SCF-025
							pstmt_update_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+8));//changed i to cunt for BSP-SCF-025
							pstmt_update_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+9));//changed i to cunt for BSP-SCF-025
							pstmt_update_disp_dtl.setString(++count,(String)edit_result.get((cunt*11)+10));//Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]
						} 
						pstmt_update_disp_dtl.setString(++count,login_by_id);
						pstmt_update_disp_dtl.setString(++count,login_facility_id);
						pstmt_update_disp_dtl.setString(++count,login_at_ws_no);
						pstmt_update_disp_dtl.setString(++count,login_facility_id);
						pstmt_update_disp_dtl.setString(++count,order_id);
						pstmt_update_disp_dtl.setString(++count,(j+1)+"");
						pstmt_update_disp_dtl.addBatch();
						cunt++;//Added  for BSP-SCF-0025 [IN062763]
				  //} 
				}
			}
			if(pstmt_update_disp_dtl != null){
				int result[] = pstmt_update_disp_dtl.executeBatch();
				for (int i=0;i<result.length ;i++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result[i]<0  && result[i] != -2 ){
						pstmt_update_disp_dtl.cancel();
						blRecUpdated = false;
					}		
				}
				if(blRecUpdated)
					connection.commit();
				else
					connection.rollback();
			} 
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			closeStatement( pstmt_update_disp_dtl ) ;
			closeConnection( connection ); 
		}
	}

	//Add this method for RUT-CRF-0067
	public ArrayList getDispSrlNO(String disp_no) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		ArrayList alt_dtls		= new ArrayList();

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement("select SRL_NO S_NO from ph_disp_dtl  where DISP_NO=? and facility_id=? and DISP_QTY>0") ;

			pstmt.setString(1,disp_no);
			pstmt.setString(2,login_facility_id);

            resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				alt_dtls.add(resultSet.getString("S_NO"));	
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
		return alt_dtls;
	}
	
	public String getUserAuthPINYN(String facility_id,String disp_locn_code) throws Exception{// RUT-CRF-0035 [IN029926] PIN Authentication  -- begin
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
	}	// RUT-CRF-0035 [IN029926] PIN Authentication  -- end

	public boolean getAllergyConfDtls(String patient_id, String encounter_id) { //added for RUT-CRF-0064.1 [IN:041799]
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		boolean pt_allergy_conf_reqd = false;
		String allergy_conf_reqd_yn = "N", allergy_conf_reqd_yn_MR="N";
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

	public ArrayList getDrugInteractionDtls(String drug_code, String form_code, String generic_id, String start_date, String end_date, String patient_id ){// added for FD-RUT-CRF-0066.1 [IN036975]- start
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
		PreparedStatement pstmt1     = null ; //MMS-KH-CRF-0029[IN070606]
		PreparedStatement pstmt2     = null ; //MMS-KH-CRF-0029[IN070606]
        String sql_query="";// MARDefaulting ="";  Removed for IN063877
		ResultSet resultSet = null;
		ResultSet resultSet1 = null; //MMS-KH-CRF-0029[IN070606]
		ResultSet resultSet2 = null; //MMS-KH-CRF-0029[IN070606]
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
		String drugCode_List="", genericId_list="", formCode_list="";
		//String drugCode_List2="", genericId_list2="";  Removed for IN063877
		boolean active_drug = false;
		try{
			String locale				= getLanguageId()==null?"en":getLanguageId(); //MMS-KH-CRF-0029[IN070606]
			connection = getConnection() ;
			 boolean CDS_FOR_CONTRAST_YN =CommonBean.isSiteSpecific(connection, "PH","CDS_FOR_CONTRAST_YN");//added for MMS-KH-CRF-0020
			  //MMS-KH-CRF-0029 - start 
				pstmt1      = connection.prepareStatement("select ds_ingredient_chk(?,?,TO_DATE (?, 'dd/mm/yyyy hh24:mi' ),TO_DATE (?, 'dd/mm/yyyy hh24:mi' ),?,?,?) food_yn from dual") ;// 2 parameter added for MMS-KH-CRF-0029
				pstmt2 = connection.prepareStatement("SELECT count(*) count from or_order a ,or_order_line b where a.order_id = b.order_id and a.order_category='LB' and a.patient_id=? and  a.encounter_id = ? /*AND  ( TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE_TIME AND  MODIFIED_DATE OR TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE_TIME AND  MODIFIED_DATE OR START_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/YYYY HH24:MI')  AND TO_DATE(?,'DD/MM/YYYY HH24:MI') OR MODIFIED_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY HH24:MI') AND TO_DATE(?,'DD/MM/YYYY HH24:MI')) */ and b.order_catalog_code = ? and b.order_line_status not in ('CD','CN','DC','HD')");
				//MMS-KH-CRF-0029 - end
			if(presDetails!=null && presDetails.size()>0){
				sql_query			= "SELECT count(*) active_drug FROM DUAL WHERE TO_DATE (?, 'dd/mm/yyyy hh24:mi') BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi' ) OR  TO_DATE (?, 'dd/mm/yyyy hh24:mi') BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi' ) OR  TO_DATE (?, 'dd/mm/yyyy hh24:mi') BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi' ) OR  TO_DATE (?, 'dd/mm/yyyy hh24:mi') BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi' )";// Changed for ML-BRU-SCF-0811 [IN:039394]
				pstmt		= connection.prepareStatement( sql_query ) ;
				String durn_value=""; //MMS-KH-CRF-0029
				String durn_type = ""; //MMS-KH-CRF-0029
				String freq_nature = "";//MMS-KH-CRF-0029
				for(int i=0;i<presDetails.size();i++){
					drugDetails		= (HashMap)presDetails.get(i);
					stDrugCode		= (String)drugDetails.get("DRUG_CODE");
					stGenericId			= (String)drugDetails.get("GENERIC_ID");		
					stFormCode			= (String)drugDetails.get("FORM_CODE");		
					//if(!stDrugCode.equals(drug_code) ){ //commeted for MMS-KH-CRF-0029[IN070606]
						stStartDate			= (String)drugDetails.get("START_DATE");
						stEndDate			= (String)drugDetails.get("END_DATE");
						if(!locale.equals("en")){
							stStartDate= com.ehis.util.DateUtils.convertDate(stStartDate, "DMYHM",locale,"en");
							stEndDate= com.ehis.util.DateUtils.convertDate(stEndDate, "DMYHM",locale,"en");
						} 
						if(end_date==null){
							durn_value		=	(String) drugDetails.get("DURN_VALUE");
							durn_type		=	(String) drugDetails.get("DURN_TYPE");
							freq_nature		=   (String) drugDetails.get("freq_nature");
							if(durn_type==null || durn_type.equals(""))
								durn_type = (String) drugDetails.get("REPEAT_DURN_TYPE");

							end_date		=	populateEndDate(freq_nature,start_date,durn_value,durn_type);
							stEndDate = end_date;
						}
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
					//}
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}

			sql_query			= "SELECT distinct(drug_code) drug_code, generic_id, form_code FROM PH_PATIENT_DRUG_PROFILE A WHERE  PATIENT_ID =? AND  ( TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE AND  END_DATE OR TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE AND  END_DATE OR START_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY HH24:MI')  AND   TO_DATE(?,'DD/MM/YYYY HH24:MI')) AND DISCONT_DATE_TIME IS NULL AND ON_HOLD_DATE_TIME IS NULL AND  CANCEL_YN='N' AND   STOP_YN='N' ";
			pstmt					= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,start_date);
			pstmt.setString(3,end_date);	
			pstmt.setString(4,start_date);
			pstmt.setString(5,end_date);	

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
			//added for mms-kh-crf-0020 start
			if(CDS_FOR_CONTRAST_YN){
			//closeStatement( pstmt ) ;
			
				sql_query			= "SELECT distinct d.PH_DRUG_CODE,generic_id, p.form_code from rd_items_consumed a,rd_request b,or_order c, rd_items d,ph_drug p,or_order_line h, rd_exams i where b.OPERATING_FACILITY_ID = c.PERFORMING_FACILITY_ID and b.order_id = c.order_id and a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and h.START_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI')AND TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND (   TO_DATE (?, 'DD/MM/YYYY HH24:MI') BETWEEN h.START_DATE_TIME AND h.END_DATE_TIME OR TO_DATE (?, 'DD/MM/YYYY HH24:MI') BETWEEN h.START_DATE_TIME AND h.END_DATE_TIME OR h.END_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI')AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')or h.END_DATE_TIME is null)  and a.REQUEST_NUM = b.REQUEST_NUM and a.item_code = d.item_code and a.STORE_TYPE = 'DR' AND B.PATIENT_ID=C.PATIENT_ID AND C.PATIENT_ID=? and d.PH_DRUG_CODE=p.DRUG_CODE and c.order_category='RD' and c.order_id=h.order_id and a.exam_code = i.exam_code and i.order_catalog_code = h.order_catalog_code";
				pstmt					= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,start_date);
			pstmt.setString(2,end_date);	
			pstmt.setString(3,start_date);
			pstmt.setString(4,end_date);
			pstmt.setString(5,start_date);
			pstmt.setString(6,end_date); 
			pstmt.setString(7,patient_id);
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
			closeStatement( pstmt ) ;
			}
			else{
				closeStatement( pstmt ) ;	
			}
			//added for mms-kh-crf-0020  END
			if(drugCodelist.length()>0){
				formCodelist.append("'*A', ");
				drugCode_List = drugCodelist.toString().substring(0, drugCodelist.length()-2);
				genericId_list = genericIdlist.toString().substring(0, genericIdlist.length()-2);
				formCode_list = formCodelist.toString().substring(0, formCodelist.length()-2);
			}
			if(drugCodelist.length()>0){

				sql_query      = "select intr_type1, intr_type2, intr_code, form_code, form_desc, intr_name, intr_severity_level, intr_signif_level, intr_prob_level, intr_restrt_yn, intr_remarks,drug_inter_type from ( select row_number() over (partition by generic_id1,generic_id2 order by intr_type1, intr_type2 ) line_srl_no, form_code, intr_type1, intr_type2, intr_code, intr_code1, generic_id1, generic_id2, form_desc, intr_name, intr_name2, intr_severity_level, intr_signif_level, intr_prob_level, intr_restrt_yn, intr_remarks,drug_inter_type from ( SELECT row_number() over (partition by intr_type1 || intr_type2 || intr_code1 || intr_code2 order by (form_code1 || FORM_CODE2) desc) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code,intr_code1 intr_code1,d1.generic_id generic_id1,d2.generic_id generic_id2, form_code2 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d2.drug_desc intr_name, d1.drug_desc intr_name2,b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks,'D' drug_inter_type  FROM ph_drug_interaction b, ph_drug_lang_vw d1, ph_drug_lang_vw d2 WHERE intr_type1 = ? AND intr_type2 = ? AND b.intr_code1 = d1.drug_code AND b.intr_code2 = d2.drug_code AND intr_code1 = ? AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND intr_code2 IN ("+drugCode_List+") AND form_code2 IN ("+formCode_list+") AND d1.language_id = ? AND d2.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT row_number() over (partition by intr_type1 || intr_type2 || intr_code1 || intr_code2 order by (form_code1 || FORM_CODE2) desc) srl_no, b.intr_type1, b.intr_type2, b.intr_code1 intr_code,intr_code2 intr_code1,d1.generic_id generic_id1,d2.generic_id generic_id2, form_code1 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code1 AND language_id = d1.language_id) ) form_desc, d1.drug_desc intr_name, d2.drug_desc intr_name2,b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks ,'D' drug_inter_type FROM ph_drug_interaction b, ph_drug_lang_vw d1, ph_drug_lang_vw d2 WHERE intr_type1 = ? AND intr_type2 = ? AND b.intr_code1 = d1.drug_code AND b.intr_code2 = d2.drug_code AND intr_code1 IN ("+drugCode_List+") AND form_code1 IN ("+formCode_list+") AND intr_code2 = ? AND form_code2 = DECODE (?, form_code2, form_code2, '*A') AND d1.language_id = ? AND d2.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT row_number() over (partition by intr_type1 || intr_type2 || intr_code1 || intr_code2 order by (form_code1 || FORM_CODE2) desc) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code,intr_code1 intr_code1,d1.generic_id generic_id1,d2.generic_id generic_id2, form_code2 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d3.drug_desc intr_name, d1.generic_name intr_name2 ,b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks,'G' drug_inter_type  FROM ph_drug_interaction b, ph_generic_name_lang_vw d1, ph_generic_name_lang_vw d2, ph_drug_lang_vw d3 WHERE intr_type1 = ? AND intr_type2 = ? AND b.intr_code1 = d1.generic_id AND b.intr_code2 = d2.generic_id and D3.GENERIC_ID = D2.GENERIC_ID and d3.drug_code in ("+drugCode_List+") AND d3.language_id=d2.language_id AND intr_code1 = ? AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND intr_code2 IN ("+genericId_list+") AND form_code2 IN ("+formCode_list+") AND d1.language_id = ? AND d2.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT row_number() over (partition by intr_type1 || intr_type2 || intr_code1 || intr_code2 order by (form_code1 || FORM_CODE2) desc) srl_no, b.intr_type1, b.intr_type2, intr_code1 intr_code,intr_code2 intr_code1,d1.generic_id generic_id1,d2.generic_id generic_id2, form_code1 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code1 AND language_id = d1.language_id) ) form_desc, d3.drug_desc intr_name,d2.generic_name intr_name2,b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks ,'G' drug_inter_type FROM ph_drug_interaction b, ph_generic_name_lang_vw d1, ph_generic_name_lang_vw d2, ph_drug_lang_vw d3 WHERE intr_type1 = ? AND intr_type2 = ? AND b.intr_code1 = d1.generic_id AND b.intr_code2 = d2.generic_id and D3.GENERIC_ID = D2.GENERIC_ID and d3.drug_code in ("+drugCode_List+") AND d3.language_id=d2.language_id AND intr_code1 IN ("+genericId_list+") AND form_code1 IN ("+formCode_list+") AND intr_code2 = ? AND form_code2 = DECODE (?, form_code2, form_code2, '*A') AND d1.language_id = ? AND d2.language_id = ? AND b.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1  || intr_type2 || intr_code1  || intr_code2 ORDER BY (   form_code1  || form_code2) DESC)  srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code,  intr_code1 intr_code1, d1.generic_id generic_id1, d2.INGREDIENT_CODE generic_id2, form_code2 form_code,  DECODE (form_code1,'*A', 'All', (SELECT form_desc  FROM ph_form_lang_vw  WHERE form_code = b.form_code2  AND language_id = d1.language_id) ) form_desc,  d2.short_desc intr_name, d1.drug_desc intr_name2, b.intr_severity_level, b.intr_signif_level,  b.intr_prob_level, intr_restrt_yn, intr_remarks,'O' drug_inter_type  FROM ph_drug_interaction b,  ph_drug_lang_vw d1,  ds_ingredient d2 WHERE intr_type1 = 'D'  AND intr_type2 = 'F'  AND b.intr_code1 = d1.drug_code  AND b.intr_code2 = d2.INGREDIENT_CODE AND intr_code1 = ?  AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND d1.language_id = ?  AND b.eff_status = 'E' UNION ALL SELECT  ROW_NUMBER () OVER (PARTITION BY    intr_type1  || intr_type2  || intr_code1 || intr_code2 ORDER BY (   form_code1  || form_code2) DESC)  srl_no,  b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1,  d2.INGREDIENT_CODE generic_id2, form_code2 form_code,  DECODE (form_code1, '*A', 'All',(SELECT form_desc  FROM ph_form_lang_vw  WHERE form_code = b.form_code2  AND language_id = d1.language_id)  ) form_desc, d2.short_desc intr_name, d1.generic_name intr_name2,  b.intr_severity_level, b.intr_signif_level, b.intr_prob_level,  intr_restrt_yn, intr_remarks,'O' drug_inter_type FROM ph_drug_interaction b, ph_generic_name_lang_vw d1,  ds_ingredient d2,  ph_drug_lang_vw d3 WHERE intr_type1 = 'G'  AND intr_type2 = 'F'  AND b.intr_code1 = d1.generic_id  AND b.intr_code2 = d2.INGREDIENT_CODE  AND d3.generic_id = d1.generic_id  AND d3.generic_id = b.intr_code1 AND d3.drug_code IN ("+drugCode_List+")  AND d3.language_id = d1.language_id  AND intr_code1 = ?  AND form_code1 = DECODE (?, form_code1, form_code1, '*A')  AND d1.language_id = ?  AND d3.language_id = ?  AND b.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1  || intr_type2  || intr_code1 || intr_code2 ORDER BY (form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code,intr_code1 intr_code1, d1.generic_id generic_id1, d2.ORDER_CATALOG_CODE generic_id2, form_code2 form_code, DECODE (form_code1, '*A', 'All', (SELECT form_desc  FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id)  ) form_desc, d2.short_desc intr_name, d1.drug_desc intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks,'L' drug_inter_type   FROM ph_drug_interaction b, ph_drug_lang_vw d1 ,or_order_catalog d2  WHERE intr_type1 = 'D' AND intr_type2 = 'L'  and d2.order_category='LB' AND b.intr_code1 = d1.drug_code   AND b.intr_code2 =  d2.order_catalog_code AND intr_code1 = ?  AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND d1.language_id = ? AND b.eff_status = 'E'   AND d2.EFF_STATUS = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1  || intr_type2  || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC)  srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1, d2.order_catalog_code generic_id2, form_code2 form_code,  DECODE (form_code1,'*A', 'All', (SELECT form_desc FROM ph_form_lang_vw  WHERE form_code = b.form_code2  AND language_id = d1.language_id)  ) form_desc, d2.short_desc intr_name, d1.generic_name intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks,'L' drug_inter_type FROM ph_drug_interaction b, ph_generic_name_lang_vw d1, or_order_catalog d2, ph_drug_lang_vw d3  WHERE intr_type1 = 'G'  AND intr_type2 = 'L'  and d2.order_category='LB' AND b.intr_code1 = d1.generic_id  AND b.intr_code2 = d2.order_catalog_code  AND d3.generic_id = d1.generic_id AND d3.generic_id = b.intr_code1  AND d3.language_id = d1.language_id   AND intr_code1 = ?  AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND d1.language_id = ?  AND d3.language_id = ?  AND b.eff_status = 'E'  AND d2.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1  || intr_type2  || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC)  srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1, d2.TERM_CODE generic_id2, form_code2 form_code,  DECODE (form_code1,'*A', 'All', (SELECT form_desc FROM ph_form_lang_vw  WHERE form_code = b.form_code2  AND language_id = d1.language_id)  ) form_desc, d2.TERM_CODE_SHORT_DESC intr_name, d1.generic_name intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks,'I' drug_inter_type  FROM ph_drug_interaction b, ph_generic_name_lang_vw d1,PR_DIAGNOSIS d2 WHERE intr_type1 = 'G' AND intr_type2 = 'I' AND b.intr_code1 = d1.generic_id AND B.TERM_SET_ID =D2.TERM_SET_ID AND b.intr_code2 = d2.TERM_CODE AND D2.PATIENT_ID =? AND D2.CURR_ENCOUNTER_ID =? AND intr_code1 = ?  AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND d1.language_id = ? AND b.eff_status = 'E'  AND d2.CURR_STATUS = 'A' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY    intr_type1  || intr_type2  || intr_code1 || intr_code2 ORDER BY (   form_code1 || form_code2) DESC)  srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.drug_desc generic_id1, d2.TERM_CODE generic_id2, form_code2 form_code,  DECODE (form_code1,'*A', 'All', (SELECT form_desc FROM ph_form_lang_vw  WHERE form_code = b.form_code2  AND language_id = d1.language_id)  ) form_desc, d2.TERM_CODE_SHORT_DESC intr_name, d1.drug_desc intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks,'I' drug_inter_type  FROM ph_drug_interaction b, ph_drug_lang_vw d1,PR_DIAGNOSIS d2 WHERE intr_type1 = 'D' AND intr_type2 = 'I' AND b.intr_code1 = d1.generic_id AND B.TERM_SET_ID =D2.TERM_SET_ID AND b.intr_code2 = d2.TERM_CODE AND D2.PATIENT_ID =? AND D2.CURR_ENCOUNTER_ID =? AND intr_code1 = ?  AND form_code1 = DECODE (?, form_code1, form_code1, '*A') AND d1.language_id = ? AND b.eff_status = 'E'  AND d2.CURR_STATUS = 'A') where srl_no = 1 ) where line_srl_no = 1" ; // IN ("+drugCode_List+") modified - FD-RUT-CRF-0066.1 [IN036975] and modified for MMS-KH-CRF-0029   
				pstmt		   = connection.prepareStatement(sql_query) ;
				//modified for MMS-KH-CRF-0029
				int count =1;
				pstmt.setString(count++,"D"); //intr_type1 
				pstmt.setString(count++, "D"); //intr_type2
				pstmt.setString(count++, drug_code); //intr_code1
				pstmt.setString(count++, form_code); //intr_code1
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,"D"); //intr_type1 
				pstmt.setString(count++, "D"); //intr_type2
				pstmt.setString(count++, drug_code); //intr_code2
				pstmt.setString(count++, form_code); //intr_code2
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,"G"); //intr_type1 
				pstmt.setString(count++, "G"); //intr_type2
				pstmt.setString(count++, generic_id); //intr_code1
				pstmt.setString(count++, form_code); //intr_code1
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,getLanguageId());
				pstmt.setString(count++,"G"); //intr_type1 
				pstmt.setString(count++, "G"); //intr_type2
				pstmt.setString(count++,generic_id); //intr_code2
				pstmt.setString(count++,form_code); //intr_code2
				pstmt.setString(count++,getLanguageId()); 
				pstmt.setString(count++,getLanguageId()); 
//Added for MMS-KH-CRF-0029 - start
				pstmt.setString(count++,drug_code); 
				pstmt.setString(count++,form_code); 
				pstmt.setString(count++,getLanguageId()); 
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
//Added for MMS-KH-CRF-0029 - end//Adding start for MMS-DM-CRF-0229
                pstmt.setString(count++,patient_id); 
				pstmt.setString(count++,getEncounterID());
				pstmt.setString(count++,generic_id); 
				pstmt.setString(count++,form_code); 
				pstmt.setString(count++,getLanguageId());

				pstmt.setString(count++,patient_id); 
				pstmt.setString(count++,getEncounterID());
				pstmt.setString(count++,drug_code); 
				pstmt.setString(count++,form_code); 
				pstmt.setString(count++,getLanguageId());//Adding end for MMS-DM-CRF-0229
				resultSet	= pstmt.executeQuery();
// MMS-KH-CRF-0029 -start			
				String intr_type2 = "";
				String food_flag_yn = "N";
				String food_code = "";
				String lab_code = "";
				String lab_flag_yn = "N";
				int lab_flag_count = 0;
				String startDate = ""; //MMS-KH-CRF-0029
				String endDate = ""; //MMS-KH-CRF-0029
				String encounter_id = getEncounterID();
				if(encounter_id==null)
					encounter_id = "";
// MMS-KH-CRF-0029 -end

				if(resultSet!= null){
					while(resultSet.next()){
						hmDrugIntrDtl = new HashMap();
						// MMS-KH-CRF-0029 -start
						 intr_type2 = resultSet.getString("INTR_TYPE2")==null?"":resultSet.getString("INTR_TYPE2");
System.err.println("DirectDispensingBean.java===10175===intr_type2====>"+intr_type2+"==login_facility_id==>"+login_facility_id+"==getLoginFacilityId()==>"+getLoginFacilityId()+"==pstmt1===>"+pstmt1+"==start_date===>"+start_date.substring(0,10)+"==end_date====>"+end_date.substring(0,10)+"==patient_id====>"+patient_id+"==encounter_id===>"+encounter_id);				 
						if(!intr_type2.equals("F") && !intr_type2.equals("L")){//modified for MMS-KH-CRF-0029 and || removed && added for TFS_ID:18760
						
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
						
						}else{
							if(intr_type2.equals("F") || intr_type2.equals("L")){
							startDate = start_date.substring(0,10); //MMS-KH-CRF-0029
							endDate   = end_date.substring(0,10); //MMS-KH-CRF-0029
								
										if(intr_type2.equals("L")){

										lab_code  = (String)resultSet.getString("intr_code")==null?"":(String)resultSet.getString("intr_code");

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
System.err.println("DirectDispensingBean.java=======patient_id====10227==>"+patient_id+"==lab_code=>"+lab_code+"==encounter_id==>"+encounter_id);
										resultSet2	= pstmt2.executeQuery();
										if(resultSet2!=null && resultSet2.next()){
											lab_flag_count = resultSet2.getInt("count");
											if(lab_flag_count>0)
												lab_flag_yn = "Y";
										}
										closeResultSet( resultSet2 ) ;
				System.err.println("DirectDispensingBean.java=======lab_flag_yn====10235==>"+lab_flag_yn);
										if(lab_flag_yn.equals("Y")){
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
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
        }
		return hmDrugIntrDtllst;		
	}//// added for FD-RUT-CRF-0066.1 [IN036975] -end
	
	public boolean toDisplayFinancialDtl(String disp_locn_code){ //code added for JD-CRF-0156[IN041737]--Start
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String finacial_detail	= "",bill_interface="";
		boolean display_financial_dtl = false;
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SELECT_FINANCE_BILL_DTL")) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,login_by_id);
			pstmt.setString(3,disp_locn_code);				
            resultSet	= pstmt.executeQuery() ;  
			if(resultSet.next()){
				finacial_detail = checkForNull(resultSet.getString("CURR_ENC_FINANCIAL_DTL_YN"));
				bill_interface = checkForNull(resultSet.getString("BL_INTERFACE_YN"));
			}
			if(finacial_detail.equals("Y") && bill_interface.equals("Y") )
				display_financial_dtl = true;
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
			catch ( Exception es ) {
				es.printStackTrace() ;
			}
		}
		return display_financial_dtl;
	}
	
	public boolean getPolicyExp(String encounter_id,String patient_class,String patient_id) {        	
		CallableStatement callableStatement = null;
		Connection connection = null;
		try{        		
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ call or_bl_patient_check (?,?,?,?,?,?) }");
			callableStatement.setString(1, login_facility_id.trim());				
			callableStatement.setString(2, encounter_id);
			callableStatement.setString(3, patient_class);
			callableStatement.registerOutParameter(4, Types.VARCHAR);
			callableStatement.registerOutParameter(5, Types.VARCHAR);
			callableStatement.setString(6, patient_id);
			callableStatement.execute();

			if(!checkForNull(callableStatement.getString(4)).equals("")){
				return false;
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		finally{
			try{
				closeStatement(callableStatement);
				closeConnection(connection);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return true;
    }   

	public ArrayList getEpisodeDetails( String patient_id, String encounter_id){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		ArrayList encounter_details = new ArrayList();
		try{
			connection = getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SELECT_ENCOUNTER_EPISODE_DTL"));
			pstmt.setString(1, patient_id);
			pstmt.setString(2, encounter_id);
			pstmt.setString(3, login_facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null){
				if(resultSet.next()){
					encounter_details.add(resultSet.getString("EPISODE_ID"));					
					encounter_details.add(resultSet.getString("PATIENT_CLASS"));				
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
		return encounter_details;
	}//code added for JD-CRF-0156[IN041737] --End

	public void getDispMednDefltValues(){	//Added for MMS-QH-CRF-0201
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String crit_field_id = "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "SELECT CRIT_FIELD_ID, CRIT_FIELD_VAL  FROM PH_DISP_MEDN_DFLT WHERE FACILITY_ID = DECODE (?, FACILITY_ID, FACILITY_ID, '*A')   AND CRIT_FIELD_ID IN( 'RETN_DISP_MED_FOR_OUTSTANDING') ") ;
			pstmt.setString(1,login_facility_id.trim());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null){
				while(resultSet.next()){
					crit_field_id = checkForNull(resultSet.getString("CRIT_FIELD_ID"));
					if(crit_field_id.equals("RETN_DISP_MED_FOR_OUTSTANDING"))
						setRetnDispMedForOutStanding(checkForNull(resultSet.getString("CRIT_FIELD_VAL"),"N"));
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
			catch ( Exception es ) {
				es.printStackTrace() ;
			}
		}
	}
	public ArrayList getSelectedDrugInfo(String drug_priv_ssn_yn,String resp_id,String drugCode,String date_of_birth,String gender,String priviligeDrugCheck,String patient_class){  // Added for MMS-DM-CRF-0112 - Start 
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		ArrayList resultArr     = new ArrayList();
		String qryAppend =" ";
		String generic_id	=	"";
        String synonym = "%";
        String route_code ="";
		String barcodeQry  ="";

		try {
			connection			= getConnection();
			int cnt	=	1;
//Adding start for MMS-DM-CRF-0174.5
		String gtinPattern = "(01\\d{14})";
        String batchPattern = "(10\\w{1,20})";
        String expiryPattern = "(17\\d{6})";

        Pattern pattern = Pattern.compile(gtinPattern + "|" + batchPattern + "|" + expiryPattern);
        Matcher matcher = pattern.matcher(drugCode);
		System.out.println("p_barcode_id@@==="+drugCode);

        String gtin = null;
        String batchNumber = null;
        String expiryDate = null;
if(barcode_2d_applicable_yn.equals("Y")){
        while (matcher.find()) {
            String match = matcher.group();
            if (match.startsWith("01")) {
                gtin = match.substring(2);
            }else if (match.startsWith("10")) {
				int endIndex = -1;
				int expIndex = match.indexOf("17");
				int batIndex = match.indexOf("10");
				int srlIndex = match.indexOf("21");
				System.out.println("expIndex@@==="+expIndex+"batIndex=="+batIndex+"srlIndex=="+srlIndex);
				if(batIndex > expIndex){
					if(batIndex < srlIndex ){
                       endIndex =match.indexOf("21");
					}
				}else{
					endIndex =match.indexOf("17");
				}
                if (endIndex == -1) {
                    endIndex = match.length();
                }
                batchNumber = match.substring(2, endIndex);
            } 
        }
     } 

         if(barcode_2d_applicable_yn.equals("Y")){
	            barcodeQry  = " and g.manufacturer_id =? and sb.batch_id =? " ;
		 }else{
			    barcodeQry  =     " AND sb.barcode_id =?";
		 }
//Adding end for MMS-DM-CRF-0174.5
			if (priviligeDrugCheck.equals("S")){
				qryAppend = " AND or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') = 'Y' ";
			}
			
			//System.err.println("batchNumber@@@ Direct disp bean======="+batchNumber+"gtin===="+gtin+"barcodeQry==="+barcodeQry+"qryAppend==="+qryAppend);
			pstmt = connection.prepareStatement("SELECT DISTINCT b.drug_code, NVL ((SELECT MAX (DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code = ph_elig.term_code AND pr_diag.patient_id = ?), NULL, 'N', 'Y' ) ) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = b.drug_code AND ph_elig.eff_status = 'E'), 'Y' ) diagnosis_found_yn, (SELECT ph_drug_appl_for_pat_age_grp (b.drug_code, ?, ? ) FROM DUAL) appl_for_age_grp_yn, or_get_priv_appl_yn (?, ?, 'OR', b.drug_code, ?, a.order_type_code, 'PH' ) priv_appl_yn FROM or_order_catalog a, ph_drug_lang_vw b, ph_form_lang_vw c, ph_route_lang_vw e, ph_trade_name_for_drug f, am_trade_name_lang_vw g, ph_generic_name_lang_vw h, or_order_catalog_by_ptcl i, ph_drug_synonym_lang snm, st_item_batch sb WHERE b.drug_yn = 'Y' AND b.discontinued_yn = 'N'" +barcodeQry+ "AND sb.item_code = b.drug_code AND a.order_category = 'PH' AND a.eff_status = 'E' AND b.drug_code = a.order_catalog_code AND c.form_code = b.form_code AND e.route_code = b.route_code AND f.drug_code(+) = b.drug_code AND f.trade_code = g.trade_id(+) AND h.generic_id = b.generic_id AND b.generic_id = NVL (?, b.generic_id) AND b.route_code = NVL (?, b.route_code) AND i.patient_class = or_patient_order_applicable (?, a.order_catalog_code) AND a.order_catalog_code = i.order_catalog_code"+qryAppend+"AND b.language_id = c.language_id AND b.language_id = e.language_id AND b.language_id = h.language_id AND f.eff_status(+) = 'E' AND g.eff_status(+) = 'E' AND b.language_id = ? AND g.language_id(+) = ? AND disp_via_pres_only_yn = 'N' AND snm.drug_code(+) = b.drug_code AND snm.eff_status(+) = 'E' AND UPPER (snm.drug_synonym_desc(+)) LIKE UPPER (?) AND snm.language_id(+) = b.language_id AND b.npb_drug_yn = 'N'");

		    System.err.println("getPatientID=="+getPatientID()+"date_of_birth=="+date_of_birth+"gender=="+gender+"practioner_id=="+practioner_id+"resp_id=="+resp_id+"drug_priv_ssn_yn==="+drug_priv_ssn_yn+"barcode_2d_applicable_yn=="+barcode_2d_applicable_yn+"gtin==="+gtin+"batchNumber=="+batchNumber+"generic_id=="+generic_id+"route_code=="+route_code+"patient_class=="+patient_class+"priviligeDrugCheck=="+priviligeDrugCheck+"drug_priv_ssn_yn=="+drug_priv_ssn_yn+"synonym=="+synonym);
		    pstmt.setString(cnt,getPatientID());
			pstmt.setString(++cnt,date_of_birth);
			pstmt.setString(++cnt,gender);
			pstmt.setString(++cnt,practioner_id);
			pstmt.setString(++cnt,resp_id.trim());
			pstmt.setString(++cnt,drug_priv_ssn_yn.trim());
			if(barcode_2d_applicable_yn.equals("Y")){
				pstmt.setString(++cnt,gtin.trim()); 
				pstmt.setString(++cnt,batchNumber.trim()); 
			}else{
			  pstmt.setString(++cnt,drugCode.trim()); 
			}
			pstmt.setString(++cnt,generic_id.trim()); 
			pstmt.setString(++cnt,route_code.trim());
			pstmt.setString(++cnt,patient_class.trim());
			if (priviligeDrugCheck.equals("S")){ //in ph_facility_param Self Privilige Selected
				pstmt.setString(++cnt,practioner_id);
				pstmt.setString(++cnt,resp_id);
				pstmt.setString(++cnt,drug_priv_ssn_yn);
			}
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,synonym);
			
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				resultArr.add(checkForNull(resultSet.getString("DRUG_CODE")));
				resultArr.add(checkForNull(resultSet.getString("DIAGNOSIS_FOUND_YN")));
				resultArr.add(checkForNull(resultSet.getString("APPL_FOR_AGE_GRP_YN")));
				resultArr.add(checkForNull(resultSet.getString("PRIV_APPL_YN")));
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
		
		return resultArr;	
	} 
	
	public String getBarCodeflg(String facilityid,String disp_locn){
	    Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null;
		String barcodeflg	= "";
		boolean barcode_2d_applicable =false;//MMS-DM-CRF-0174.5
		String barcode_2d_applicable_yn ="";//MMS-DM-CRF-0174.5

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("select bar_code_scan_yn from ph_disp_locn where facility_id=? and disp_locn_code=? ");
			pstmt.setString(1,facilityid);
			pstmt.setString(2,disp_locn);
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
			    barcodeflg = resultSet.getString("bar_code_scan_yn") == null ? "N":resultSet.getString("bar_code_scan_yn");
			}
//Adding start for MMS-DM-CRF-0174.5
			barcode_2d_applicable  = eCommon.Common.CommonBean.isSiteSpecific(connection, "ST","2D_BARCODE_APPLICABLE");
			System.err.println("barcode_2d_applicable@@@ bean==="+barcode_2d_applicable);
			if(barcode_2d_applicable)
				barcode_2d_applicable_yn="Y";
			else
				barcode_2d_applicable_yn ="N";
			set2DBarcodeApplicable(barcode_2d_applicable_yn);//Adding end for MMS-DM-CRF-0174.5
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
		return barcodeflg;
	} // Added for MMS-DM-CRF-0112 - End
	public boolean isSiteSpecific(String moduleId, String functionalityId){ // Added for ML-MMOH-CRF-0978  - Start
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
   } // Added for ML-MMOH-CRF-0978 - End
   //added for AAKH-CRF-0117 - start
public String getApprovalNoApplicableForPatientClass(String patient_class){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//ArrayList approval_setting	=	new ArrayList(); //Commented FOR COMMON-ICN-0048
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
}