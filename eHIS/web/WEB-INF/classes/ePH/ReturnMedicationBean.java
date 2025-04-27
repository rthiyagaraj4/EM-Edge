/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
09/05/2017      GHL-SCF-1193  IN064097  SOFIA       RTN_MED_NO is empty when encounterID not there  
01/09/2017      GHL-SCF-1234   65133              	 Drugs are not showing in RETURN MEDICATION screen. 
07/09/2017      ICN   			65168       				Drugs are not showing in RETURN MEDICATION screen. 
29/01/2018     Aissist id 	  974547(KDAH-SCF-0467)            Return Medication Search is slow  when ward return check box is checked.
14/10/2019     IN071554       Prathyusha 						KDAH-SCF-0601
22/11/2019     IN071683				prathyusha									AMRI-SCF-0596  
22/11/2019     IN071532       Prathyusha            SKR-SCF-1277
27/11/2019		IN071648			Shazana hasan			     	TBMC-SCF-0105
12/06/2019    IN071201       prathyusha perugupalli  GHL-SCF-1448
2/1/2020		IN072062		Shazana Hasan					TBMC-SCF-0105.1
2/3/2020		INO72415  		Shazana hasan					TBMC-SCF-0161
4/1/2021		10576			Shazana					MMS-DM-CRF-0174.4 
07/01/2021      TFS-12069	     Prabha         SKR-SCF-1551
03/02/2021      TFS-13523	     Manickavasagam J         MOHE-CRF-0060
05/03/2021      TFS-14216	     Manickavasagam J         SKR-SCF-1574
---------------------------------------------------------------------------------------------------------------
*/
package ePH ;
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.ReturnMedication.*;
import javax.servlet.* ;
import javax.servlet.http.*;
import java.text.SimpleDateFormat; //Added for MOHE-CRF-0167

public class ReturnMedicationBean extends PhAdapter implements Serializable {

//	protected String remarks		= "";
//	protected String disp_locn_code	= "";
//	protected String drugcodes		= "";
	protected String user_name		= "";
	protected String password		= "";
	protected String st_doc_type	= "";
	protected String curr_date		= "";
	protected String encounter_id	= "";
	protected String disp_locn_code = "";
	protected ArrayList  billing_details= null ;	//billing_details type changed  from String to ArrayList  for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
	protected String disp_cash_coll_stage = "";
	protected String token_series_code = "";
	protected String issue_uom_by	   = "";
	protected String FormStore	       = "";
	protected String eff_status	       = "";
	protected String orderingfacilityid= "";
	protected String Login_disp_locn_code= "";
	protected String rtn_medn_no       = "";
	protected String patCat       = "";
	private Hashtable recordSet		   = new Hashtable();
	protected String Facility_Flag = "";//Bru-HIMS-CRF-091 & SPIR-IN029957 -- Added Facility_Flag for MutiFacility
	protected String getTradeName_Flag		= "";//AMS-SCF-0190-IN038440.
	protected String dispTranSeqNo = "";
	protected String directDispTranSeqNo = "";
	protected String retn_Medn_Num = "";//Added for GHL-SCF-1193
	//Added for GHL-CRF-0413.8 start
	ArrayList newBarcodeArry = new ArrayList();
	boolean flag_empty=false;
	
	public boolean isFlag_empty() {
		return flag_empty;
	}

	public void setFlag_empty(boolean flag_empty) {
		this.flag_empty = flag_empty;
	}
	//Added for GHL-CRF-0413.8 end

	
	public void setNewBarcodeArry(ArrayList BarcodeArry){
		this.newBarcodeArry =BarcodeArry;
	}
   public ArrayList getNewBarcodeArry(){
	   return newBarcodeArry;
   }
	//HashMap barcode_data	=	new HashMap();
	public ReturnMedicationBean(){
		//Constructor
		try{
			doCommon() ;
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
		this.disp_locn_code	= "";
		this.encounter_id	= "";
		this.billing_details = null;
		this.eff_status="";
		this.rtn_medn_no = "";
		this.st_doc_type="";
		if(this.recordSet !=null)
			this.recordSet.clear();
	}

	/* Over-ridden Adapter methods endS here */
	/* Function specific methods start */

	public String getLoggedInFacility(){
		return login_facility_id;
	}
	
	private String getStockDocType() {
		return this.st_doc_type;
	}

	public String getRtn_medn_no() {
		return this.rtn_medn_no;
	}
	//Added for GHL-SCF-1193 Start
	public String getRetnMednNo() {
		return this.retn_Medn_Num;
	}
	
	public void setRetnMednNo(String retn_Medn_Num) {
		this.retn_Medn_Num = retn_Medn_Num;
	}
	
	public void clearRetnMednNo(){
		this.retn_Medn_Num = "";
	}//Added for GHL-SCF-1193 End

	private void setCurrDate(String curr_date) {
		this.curr_date	=	curr_date;
	}

	private void setEncounter(String encounter_id) {
		this.encounter_id	=	encounter_id;
	}

	private String getEncounter() {
		return this.encounter_id;
	}

	private String getCurrDate() {
		return this.curr_date;
	}

	public void setDispLocnCode(String displocncode){
			this.disp_locn_code=displocncode;
	}
	public String getDispLocnCode(){
			return disp_locn_code;
	}

	public void setLoginDispLocnCode(String Login_disp_locn_code){
			this.Login_disp_locn_code=Login_disp_locn_code;
	}
	public String getLoginDispLocnCode(){
			return Login_disp_locn_code;
	}

	public void setBLDetails(ArrayList billing_details){
		this.billing_details = billing_details;
	}
	public ArrayList getBLDetails(){
		return 	billing_details;
	}

	public void setDispCashCollStage(String disp_cash_coll_stage){
		this.disp_cash_coll_stage = disp_cash_coll_stage;
	}
	public String getDispCashCollStage(){
		return 	this.disp_cash_coll_stage;
	}
	public void setTokenSeriesCode(String token_series_code){
		this.token_series_code = token_series_code;
	}
	public String getTokenSeriesCode(){
		return 	token_series_code;
	}

	public void setFromStore(String FormStore) {
		this.FormStore	=	FormStore;
	}

	public String getFromStore() {
		return this.FormStore;
	}

	public void setOrderingFacilityID(String orderingfacilityid) {
		this.orderingfacilityid	=	orderingfacilityid;
	}

	public String getOrderingFacilityID() {
		return this.orderingfacilityid;
	}
	
	public void setEffstatus(String eff_status) {
		this.eff_status	=	eff_status;
	}

	public String getEffstatus() {
		return this.eff_status;
	}

	public void setPatientCategory(String patCat) {
		this.patCat	=	patCat;
	}

	public String getPatientCategory() {
		return this.patCat;
	}
	//Bru-HIMS-CRF-091 & SPIR-IN029957 -- Added Getter/Setter for Facility_Flag.
	public void setFacility_Flag(String Facility_Flag){
		 this.Facility_Flag=Facility_Flag;
	}
	
	public String getFacility_Flag(){
		return this.Facility_Flag;
	}
	
	//Added for  AMS-SCF-0190 IN038440 - start
	public void setTradeName_Flag(String TradeName_Flag){
		this.getTradeName_Flag=TradeName_Flag;
	}
	
	public String getTradeName_Flag(){
		return this.getTradeName_Flag;
	}
	//Added for  AMS-SCF-0190 IN038440 - end
	public String getDispTranSeqNo() {//added for MMS-QH-CRF-0201 [IN:052255] 
		return dispTranSeqNo;
	}


	public void setDispTranSeqNo(String dispTranSeqNo) {//added for MMS-QH-CRF-0201 [IN:052255] 
		this.dispTranSeqNo = dispTranSeqNo;
	}
	

	public String getDirectDispTranSeqNo() {//added for MMS-QH-CRF-0201 [IN:052255] 
		return directDispTranSeqNo;
	}


	public void setDirectDispTranSeqNo(String directDispTranSeqNo) {//added for MMS-QH-CRF-0201 [IN:052255] 
		this.directDispTranSeqNo = directDispTranSeqNo;
	} 
	public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed 
		recordSet is nothing but a hashtable containing all form values
		
		*/
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		this.recordSet = recordSet;
	}

	public void setStockDocType(String patient_class) {
		Connection conn								= null;
		PreparedStatement pstmt_st_doc_type			=	null;
		ResultSet resSet							=	null;
		
		try {
			conn				=	getConnection();
			pstmt_st_doc_type	= conn.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT56") ) ;

			if(patient_class.equals("I")) {
				pstmt_st_doc_type.setString(1,"RTIP");
			}
			else {
				pstmt_st_doc_type.setString(1,"RTOP");
			}
			pstmt_st_doc_type.setString(2,login_facility_id);
			pstmt_st_doc_type.setString(3,login_facility_id);
			resSet				= pstmt_st_doc_type.executeQuery() ;
			if(resSet.next() && resSet!=null ) {
				st_doc_type	=	(String)resSet.getString("ST_DOC_TYPE_CODE");
			}
			//setStockDocType(st_doc_type);
		}
		catch(Exception e){
				e.printStackTrace();
		}
		finally{	
			try {
				closeConnection( conn );
				closeResultSet( resSet ) ;
				closeStatement( pstmt_st_doc_type ) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		//return st_doc_type;
	}

	public HashMap modify() {

	//	HashMap result	=	new HashMap();
		HashMap tabData	=	new HashMap();
		HashMap sqlMap	=	new HashMap();
		HashMap map		=	new HashMap();
		ArrayList datarr	=	null;
		HashMap hmHeader	=	new HashMap();
		HashMap hmHeader_dtls	=	new HashMap(); // added forSRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
		HashMap BaseAndIssueUOMQty =new HashMap();
		//  variables for Stock component
		ArrayList tot_values	=	new ArrayList();
		HashMap insertDetailGrp	=	new HashMap(); // added forSRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
		HashMap insertExpGrp	=	new HashMap(); // added forSRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
		ArrayList insertDetail	=	new ArrayList();
		ArrayList insertExp		=	new ArrayList();
		HashMap hmDetail		=	null;
		HashMap hmExp			=	null;
		HashMap hmhdrDtlKeyMap	=	new HashMap();
		HashMap hmDtlGrp	=	new HashMap();
		HashMap hmExpGrp	=	new HashMap();
		ArrayList dtlKeyList	=	new ArrayList();
		ArrayList tmpInsertExp = null;
		ArrayList EncList      =new ArrayList();//Added for KDAH-SCF-0452
		ArrayList EncListGroup      =new ArrayList();//Added for KDAH-SCF-0452
		List hdrKeyList =null;
		String enc_patient_class ="";
		String enc_id            ="";
		String previousEncId	 ="";
		String hdrKey            ="";
		String dtlKey            ="";
        Connection connection		        = null ;  
		PreparedStatement pstmt_select1		= null;
		ResultSet rset						= null;
		String bl_interface_yn				= "";
		boolean retMedRestrStage = false; // Added for GHL-CRF-0412.3
		String eff_status=(String)recordSet.get("eff_status");
		String totalRows1=CommonBean.checkForNull((String)recordSet.get("totalRows1"));
		float tot_item_qty=0;
		float mm_trn_qty=0;
		String take_home_yn="";// added for skr-scf-0591
		String dis_charge_ind="";// added for skr-scf-0591
		String orig_enc_patient_class ="";//Added for KDAH-SCF-0452
		//Adding start for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508 
		PreparedStatement pstmt_blflag     = null ;
		ResultSet resultSet_blflag        = null ;
		String bl_result="";
        String bl_recal_flag="N";
		//Adding end for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508 

		tabData.put("flag","test flag");
		tabData.put("result",new Boolean(false));
		tabData.put("message","message");
	    tabData.put("FACILITY_ID",login_facility_id);
	    tabData.put("EFF_STATUS",eff_status);
	    tabData.put("Rej_Qty_Value", (String)recordSet.get("rej_qty")); // Added for GHL-SCF-790 [IN:046481]
		tabData.put( "PROPERTIES", getProperties() );
		tabData.put( "REMARKS", CommonBean.checkForNull((String)recordSet.get("remarks")));		
		tabData.put( "login_by_id", login_by_id.trim() );
		tabData.put( "login_at_ws_no",login_at_ws_no.trim());
		tabData.put("Facility_Flag",getFacility_Flag());//Bru-HIMS-CRF-091 & SPIR-IN029957 -- Mapped Facility_Flag to EJB.
		String rows=CommonBean.checkForNull((String)recordSet.get("totalrows"));
		//added  for ghl-scf-1448 start
		String dispNo="";
		 String binLocnCode="";
		 String storeCode ="";
		 String orderId ="";
		 String itemCode="";
		 String expieryDate="";
		 String batchId ="";
		 String retDocNo="";
		 String retDocLineNo="";
		 String patientId="";
		//added  for ghl-scf-1448 start
		if(!rows.equals("")){
			tabData.put( "TOTALROWS", rows);
		}
		else if(rows.equals("")){
			tabData.put( "TOTALROWS", totalRows1);
		}
		tabData.put( "LANGUAGEID",getLanguageId());		
		tabData.put( "TOKEN_SERIES_CODE",this.getTokenSeriesCode());
		tabData.put( "DISP_LOCN_CODE",this.getDispLocnCode());
		tabData.put( "PATIENT_ID",(String)recordSet.get("patientid"));
		tabData.put( "DISP_CASH_COLL_STAGE",getDispCashCollStage());
		tabData.put( "Ordering_facility_id",this.orderingfacilityid.trim());
		tabData.put( "Login_disp_locn_code",this.Login_disp_locn_code.trim());
		ArrayList alSalBinLocationCode = null; //added for KDAH-SCF-0252 [IN:050489]
        try{
			/*enc_id =this.getEncounter();
			if(enc_id.equals("")||enc_id.equals("11111")){
				 enc_id ="";
				 enc_patient_class="R";	
			}
			else{
				enc_patient_class       =   getEncounterPatientClass(encounter_id);
			}*/
			//tabData.put( "ENCOUNTER_ID",this.getEncounter());
			//tabData.put( "ENCOUNTER_ID",enc_id);
			enc_patient_class = getPatientCategory();
			bl_interface_yn  =   checkforbillinginterface(enc_patient_class); // enc_patient_class added for SRR20056-SCF-7639 ICN027720
			tabData.put( "PATIENT_CLASS",enc_patient_class);

			connection			= getConnection() ;
			pstmt_select1	    = connection.prepareStatement(PhRepository.getPhKeyValue( "SQL_PH_RET_MEDN_SELECT12"));
			int selectedRows = 0; // Added for GHL-CRF-0413.8
			String disp_bill_stage = "";//KAUH-SCF-0320
			
			int ward_ret_req_qty= 0; //Added for GHL-CRF-0627
			int ward_ret_req_qty_new= 0; //Added for GHL-CRF-0627
			String ward_ret_qty ="";  //Added for GHL-CRF-0627
			if(eff_status.equals("E")){
				int totalRows2=Integer.parseInt(totalRows1);
				int count1 =0;
				HashMap hmWardRetDetails = new HashMap();
				HashMap hmWardRetExpDetails = new HashMap();
				HashMap hmTmpExp =null;
				//Added for  AMS-SCF-0038 [IN:030868] -Start
				ArrayList alWardRetDetails = null;
				String wardRetKey ="", tmpwardRetKey="";
				boolean recUpdate = false, wardRetKeyFound=false; // wardRetKeyFound added for KDAH-SCF-0252 [IN:050489]
				int accptQty=0, tmpAccptQty=0;
				String sAccptQty="",  stmpAccptQty="";
				//Added for  AMS-SCF-0038 [IN:030868] -End
				for (int i=1;i<=totalRows2;i++ ){
					bl_recal_flag="N";//Added for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508 
					disp_bill_stage = "";//KAUH-SCF-0320
					disp_bill_stage=getDispLocnBillStage((String)recordSet.get("store_code"+i),(String)recordSet.get("dispno"+i),login_facility_id);//KAUH-SCF-0320
					if(recordSet.get("barcodeFlag").toString().equals("Y") ){ // If, else condition added for GHL-CRF-0413.8 , if condition for GHL-CRF-0413.8 and else for existing functionality  - Start
						 datarr	=	new ArrayList();  //modified for GHL-CRF-0627
					 if(recordSet.get("check_name"+i).toString().equals("Y")){
						 selectedRows++; 
						wardRetKeyFound = false; 
						
						if(!recordSet.get("AcceptedQty"+i).toString().equals("0"))
							recUpdate = true;
						else
							recUpdate = false;	
						enc_id = (String)recordSet.get("encounter_id"+i);
						if(enc_id.equals("")||enc_id.equals("11111")){
							 enc_id ="";
							 enc_patient_class="R";
						}
					
						if(!previousEncId.equals(enc_id)){
							if(bl_interface_yn.equals("Y")){
								try{
								getBillingUpdateLock(connection, login_facility_id, (String)tabData.get("PATIENT_ID"), enc_id);
								}catch(Exception e){
									map.put( "result", new Boolean( false ) ) ;	
									map.put( "message", e.getMessage() ) ;
									throw new Exception();
									
								}
								
							}
						}
						//Adding start for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508 
						 if(EncList.size()>0 && EncList.contains(enc_id) ){
							 bl_recal_flag="Y";
						 }else{
							 bl_recal_flag="N";
						 }
							if( bl_recal_flag.equals("N")){
					                pstmt_blflag = connection.prepareStatement("SELECT BL_CHK_PKG_PAT_RECALC_YN(?,?,?,?,?) RESULT_FLAG from dual");
									pstmt_blflag.setString(1,"PH");
									pstmt_blflag.setString(2,login_facility_id);
									pstmt_blflag.setString(3,(String)recordSet.get("patientid"));
									pstmt_blflag.setString(4,(String)recordSet.get("doc_type"+i));
									pstmt_blflag.setString(5,(String)recordSet.get("doc_no"+i)); //drug_class
									
									resultSet_blflag = pstmt_blflag.executeQuery() ;
												
									if(resultSet_blflag!=null && resultSet_blflag.next()){
										bl_result =resultSet_blflag.getString("RESULT_FLAG");
										
									}
                               if(bl_result.equals("Y")){
								   bl_recal_flag="Y";
									   EncList.add(enc_id);
									   orig_enc_patient_class  = getEncounterPatientClass(enc_id, (String)recordSet.get("patientid"));
									   if(EncListGroup.size()>0){
											String curr_enc=(String)EncListGroup.get(0);
											String visit_id="";
											String episode_id="";
											if(!orig_enc_patient_class.equals("I") && !orig_enc_patient_class.equals("D")){
												if (!enc_id.equals("") && !enc_id.equals(null)) {
													episode_id = enc_id.substring(0, (enc_id.length() - 4)); 
													visit_id = enc_id.substring(enc_id.length() - 4); 
												}
												}else{
													episode_id = enc_id;
													visit_id = "";
												}
											  EncListGroup.clear();
											  EncListGroup.add(curr_enc+"#"+orig_enc_patient_class+"~"+episode_id+"~"+visit_id);
										}else{
											String visit_id="";
											String episode_id="";
											if(!orig_enc_patient_class.equals("I") && !orig_enc_patient_class.equals("D")){
												if (!enc_id.equals("") && !enc_id.equals(null)) {
													episode_id = enc_id.substring(0, (enc_id.length() - 4)); 
													visit_id = enc_id.substring(enc_id.length() - 4); 
												}
												}else{
													episode_id = enc_id;
													visit_id = "";
												}
											   EncListGroup.add(orig_enc_patient_class+"~"+episode_id+"~"+visit_id);
											}
										
								}
							}
						 }
									closeStatement(pstmt_blflag);
									closeResultSet(resultSet_blflag);
								//Adding end for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508 
						previousEncId = enc_id;
						tabData.put( "PATIENT_CLASS",enc_patient_class);
						hdrKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i) ;
						dtlKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i)+recordSet.get("sal_doc_srlno"+i) ;

						 if((((String)recordSet.get("acknow_ledg"+i)).equals("A"))||(((String)recordSet.get("acknow_ledg"+i)).equals("R")) ){
							//datarr	=	new ArrayList();
						

							
							//added  for ghl-scf-1448 start
							  dispNo=(String)recordSet.get("dispno"+i);
							  binLocnCode=(String)recordSet.get("bin_location_code"+i);
							  storeCode =(String)recordSet.get("store_code"+i);
							  orderId =(String)recordSet.get("order_id"+i);
							  itemCode=(String)recordSet.get("item_code"+i);
							  expieryDate=(String)recordSet.get("expiry_date"+i);
							  batchId =(String)recordSet.get("batch_id"+i);
							  retDocNo=(String)recordSet.get("ret_doc_no"+i);
							  retDocLineNo=(String)recordSet.get("ret_doc_line_no"+i);
							  patientId=(String)recordSet.get("patientid");
							 String result = "";
							 //String result		=getretunableqty( dispNo, binLocnCode,storeCode,orderId,itemCode,expieryDate,batchId ,retDocNo,retDocLineNo,patientId);
							//added  for ghl-scf-1448 END and commented for KDAH-SCF-0635 and AMRI-SCF-0617 and ML-MMOH-SCF-1274.1 
							 datarr.add((String)recordSet.get("dispno"+i));
							datarr.add((String)recordSet.get("bin_location_code"+i));
							datarr.add((String)recordSet.get("srlno"+i));
							datarr.add((String)recordSet.get("srlnobatch"+i));
							datarr.add((String)recordSet.get("actualReturn"+i));
							datarr.add((String)recordSet.get("item_code"+i));
							datarr.add((String)recordSet.get("acknow_ledg"+i));
							datarr.add((String)recordSet.get("remarks_desc"+i));
							datarr.add((String)recordSet.get("return_reason_code"+i));
							datarr.add((String)recordSet.get("ret_doc_no"+i));
							datarr.add((String)recordSet.get("ret_doc_line_no"+i));
							datarr.add((String)recordSet.get("store_code"+i));
							datarr.add((String)recordSet.get("AcceptedQty"+i));
							datarr.add((String)recordSet.get("RejectedQty"+i));
							datarr.add((String)recordSet.get("BalanceQty"+i));

							datarr.add((String)recordSet.get("batch_id"+i));
							datarr.add((String)recordSet.get("expiry_date"+i));
							datarr.add((String)recordSet.get("disp_qty"+i));
							datarr.add((String)recordSet.get("uom_code"+i));
							datarr.add((String)recordSet.get("modified_date"+i)); 
							datarr.add(hdrKey); 
							datarr.add(dtlKey); 
							datarr.add((String)recordSet.get("order_id"+i)); //Added for GHL-SCF-1084
						    datarr.add((String)recordSet.get("order_line_no"+i)); //Added for GHL-SCF-1084
						    datarr.add(result);//added  for ghl-scf-1448 
						}

						if(recordSet.get("acknow_ledg"+i).toString().equals("P") && ( !recordSet.get("AcceptedQty"+i).toString().equals("0") || !recordSet.get("RejectedQty"+i).toString().equals("0"))){
							//datarr	=	new ArrayList();
							//added  for ghl-scf-1448 start
							  dispNo=(String)recordSet.get("dispno"+i);
							  binLocnCode=(String)recordSet.get("bin_location_code"+i);
							  storeCode =(String)recordSet.get("store_code"+i);
							  orderId =(String)recordSet.get("order_id"+i);
							  itemCode=(String)recordSet.get("item_code"+i);
							  expieryDate=(String)recordSet.get("expiry_date"+i);
							  batchId =(String)recordSet.get("batch_id"+i);
							  retDocNo=(String)recordSet.get("ret_doc_no"+i);
							  retDocLineNo=(String)recordSet.get("ret_doc_line_no"+i);
							  patientId=(String)recordSet.get("patientid");
							 
							 String result = "";
//							 String result		=getretunableqty( dispNo, binLocnCode,storeCode,orderId,itemCode,expieryDate,batchId ,retDocNo,retDocLineNo,patientId);
							//added  for ghl-scf-1448 END and commented for KDAH-SCF-0635 and AMRI-SCF-0617 and ML-MMOH-SCF-1274.1
							
							datarr.add((String)recordSet.get("dispno"+i));
							datarr.add((String)recordSet.get("bin_location_code"+i));
							datarr.add((String)recordSet.get("srlno"+i));
							datarr.add((String)recordSet.get("srlnobatch"+i));
							datarr.add((String)recordSet.get("actualReturn"+i));
							datarr.add((String)recordSet.get("item_code"+i));
							datarr.add((String)recordSet.get("acknow_ledg"+i));
							datarr.add((String)recordSet.get("remarks_desc"+i));
							datarr.add((String)recordSet.get("return_reason_code"+i));
							datarr.add((String)recordSet.get("ret_doc_no"+i));
							datarr.add((String)recordSet.get("ret_doc_line_no"+i));
							datarr.add((String)recordSet.get("store_code"+i));
							datarr.add((String)recordSet.get("AcceptedQty"+i));
							datarr.add((String)recordSet.get("RejectedQty"+i));
							datarr.add((String)recordSet.get("BalanceQty"+i));
							
							datarr.add((String)recordSet.get("batch_id"+i));
							datarr.add((String)recordSet.get("expiry_date"+i));
							datarr.add((String)recordSet.get("disp_qty"+i));
							datarr.add((String)recordSet.get("uom_code"+i));
							datarr.add((String)recordSet.get("modified_date"+i)); 
							datarr.add(hdrKey); 
							datarr.add(dtlKey); 
							datarr.add((String)recordSet.get("order_id"+i)); //Added for GHL-SCF-1084
						    datarr.add((String)recordSet.get("order_line_no"+i)); //Added for GHL-SCF-1084
						    datarr.add(result);//added  for ghl-scf-1448 
						}
						
						if(recUpdate){
							wardRetKey = (String)recordSet.get("dispno"+i)+"_"+(String)recordSet.get("srlno"+i)+"_"+(String)recordSet.get("bin_location_code"+i)+"_"+(String)recordSet.get("batch_id"+i)+"_"+(String)recordSet.get("expiry_date"+i); //(String)recordSet.get("srlnobatch"+i)+"_"+ //added for KDAH-SCF-0252 [IN:050489]//batch_id added for AMRI-SCF-0414 [IN:058529] and AMRI-SCF-0378 [IN:055710] // (String)recordSet.get("expiry_date"+i) Added for AMRI-SCF-0538
							sAccptQty= (String)recordSet.get("AcceptedQty"+i);
							if(sAccptQty ==null || sAccptQty.equals(""))
								sAccptQty = "0";
							accptQty= Integer.parseInt(sAccptQty);
							
							ward_ret_qty=(String)recordSet.get("returnable"+i);  //Added for GHL-CRF-0627
							if(ward_ret_qty ==null || ward_ret_qty.equals(""))
								ward_ret_qty = "0";
							ward_ret_req_qty= Integer.parseInt(ward_ret_qty);
							
							if(hmWardRetDetails.containsKey(wardRetKey)){
								alWardRetDetails = (ArrayList)hmWardRetDetails.get(wardRetKey);
								stmpAccptQty= (String)alWardRetDetails.get(12);
								if(stmpAccptQty ==null || stmpAccptQty.equals(""))
									stmpAccptQty = "0";
								tmpAccptQty= Integer.parseInt(stmpAccptQty)+accptQty;
								alWardRetDetails.set(12,tmpAccptQty+"");
								ward_ret_req_qty_new=ward_ret_req_qty_new+ward_ret_req_qty;  //Added for GHL-CRF-0627
								alWardRetDetails.set(25,ward_ret_req_qty_new);   //Added for GHL-CRF-0627
							}
							else{
								ward_ret_req_qty_new=ward_ret_req_qty;   //Added for GHL-CRF-0627
								datarr.add(ward_ret_req_qty_new);   //Added for GHL-CRF-0627
								alWardRetDetails = new ArrayList(datarr);
							}
							hmWardRetDetails.put(wardRetKey, alWardRetDetails);
						}		
			System.err.println("datarr==1030==>" + datarr);
						tabData.put("RECORD"+selectedRows,datarr); 
						count1++;
						if(eff_status.equals("E")&&(((String)recordSet.get("acknow_ledg"+i)).equals("A"))||(((String)recordSet.get("acknow_ledg"+i)).equals("P"))) {
						 // Header Detail
							if(hmHeader.size()==0 || !hmHeader.containsKey(hdrKey)){ 
								hmHeader_dtls	=	new HashMap();
								hmHeader_dtls.put("facility_id",login_facility_id);
								hmHeader_dtls.put("doc_type_code",this.getStockDocType());   
								hmHeader_dtls.put("sal_doc_type_code",(String)recordSet.get("doc_type"+i));//Added for KDAH-SCF-0452
								hmHeader_dtls.put("sales_doc_no",(String)recordSet.get("doc_no"+i));
								hmHeader_dtls.put("doc_date",getCurrDate());
								hmHeader_dtls.put("doc_ref","");
								hmHeader_dtls.put("store_code",(String)recordSet.get("store_code"+i));
								hmHeader_dtls.put("patient_id",(String)recordSet.get("patientid"));
								hmHeader_dtls.put("encounter_id",enc_id);
								hmHeader_dtls.put("finalized_yn","Y");
								hmHeader_dtls.put("gl_interfaced_yn","N");
								hmHeader_dtls.put("trn_type","SRT");
								hmHeader_dtls.put("remarks","");				
								hmHeader_dtls.put("item_class_code","");
								hmHeader_dtls.put("module_id","PH");
								tabData.put( "STORE_CODE",(String)recordSet.get("store_code"+i));	   
									hmHeader_dtls.put("billable_trn_yn",bl_interface_yn);
									hmHeader_dtls.put("sal_trn_type",enc_patient_class);
								dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);
								if(dis_charge_ind.equals("D"))
									take_home_yn="Y";
								else
									take_home_yn="N";
								hmHeader_dtls.put("take_home_yn",take_home_yn);	
								hmHeader.put(hdrKey, hmHeader_dtls); 
							}
							// Item Detail
							if(hmDtlGrp.size()==0 || !hmDtlGrp.containsKey(dtlKey)){ 
								hmDetail		=	new HashMap();
								
								hmDetail.put("dtlKey",dtlKey);
								hmDetail.put("facility_id",login_facility_id);
								hmDetail.put("doc_type_code",this.getStockDocType());  
								hmDetail.put("sales_doc_no",(String)recordSet.get("doc_no"+i));
								hmDetail.put("item_code", (String)recordSet.get("item_code"+i));
								hmDetail.put("stock_item_yn","Y");   
								BaseAndIssueUOMQty=(HashMap)getBaseAndIssueUOMQty((String)recordSet.get("item_code"+i),  (String)recordSet.get("store_code"+i), (String)recordSet.get("actualReturn"+i),  (String)recordSet.get("uom_code"+i));
								hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY"));
								hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
								hmDetail.put("uom_code",CommonBean.checkForNull((String)recordSet.get("uom_code"+i))); 
								hmDetail.put("remarks","");
								hmDetail.put("sales_doc_type_code",(String)recordSet.get("doc_type"+i));
								hmDetail.put("sal_doc_no",(String)recordSet.get("doc_no"+i)); 
								hmDetail.put("sal_doc_srl_no",(String)recordSet.get("sal_doc_srlno"+i)); 
								hmDetail.put("sal_facility_id",login_facility_id);
								hmDetail.put("FACILITY_STR_FOR_BL",login_facility_id+"|"+(String)tabData.get( "FACILITY_ID" ));
								hmDetail.put("disp_bill_stage",disp_bill_stage); //added for KAUH-SCF-0320
								dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);
								if(dis_charge_ind.equals("D"))
									take_home_yn="Y";
								else
									take_home_yn="N";
								hmDetail.put("take_home_yn",take_home_yn);
				 
								if(bl_interface_yn.equals("Y") && datarr!=null && datarr.size()>0){
									pstmt_select1.setString(1,(String)datarr.get(0));
									pstmt_select1.setString(2,(String)datarr.get(2));
									pstmt_select1.setString(3,(String)tabData.get( "FACILITY_ID" ));
									rset	=	pstmt_select1.executeQuery();
									if(rset.next()){
										hmDetail.put("p_overridden_excl_incl_ind",checkForNull(rset.getString("BL_INCL_EXCL_OVERRIDE_VALUE")));
										hmDetail.put("p_overridden_action_reason",checkForNull(rset.getString("BL_INCL_EXCL_OVERRIDE_REASON")));
									} 
									closeResultSet( rset );				
								}
								hmDtlGrp.put(dtlKey, hmDetail);
								if(hmhdrDtlKeyMap.size()==0 || !hmhdrDtlKeyMap.containsKey(hdrKey)){
									dtlKeyList = new ArrayList();
									dtlKeyList.add(dtlKey);
									hmhdrDtlKeyMap.put(hdrKey, dtlKeyList);
								}
								else{
									dtlKeyList = new ArrayList((ArrayList)hmhdrDtlKeyMap.get(hdrKey));
									dtlKeyList.add(dtlKey);
									hmhdrDtlKeyMap.put(hdrKey, dtlKeyList);
								}
							}
							else{
								hmDetail = (HashMap)hmDtlGrp.get(dtlKey);
								BaseAndIssueUOMQty=(HashMap)getBaseAndIssueUOMQty((String)recordSet.get("item_code"+i),  (String)recordSet.get("store_code"+i), (String)recordSet.get("actualReturn"+i),  (String)recordSet.get("uom_code"+i));
								tot_item_qty = Float.parseFloat(hmDetail.get("item_qty")==null?"0":(String)hmDetail.get("item_qty"));
								mm_trn_qty = Float.parseFloat(hmDetail.get("mm_trn_qty")==null?"0":(String)hmDetail.get("mm_trn_qty"));
								tot_item_qty += Float.parseFloat((BaseAndIssueUOMQty.get("ISSUE_QTY")==null?"0":(String)BaseAndIssueUOMQty.get("ISSUE_QTY")));
								mm_trn_qty += Float.parseFloat((BaseAndIssueUOMQty.get("BASE_QTY")==null?"0":(String)BaseAndIssueUOMQty.get("BASE_QTY")));
								hmDetail.put("item_qty",tot_item_qty+"");
								hmDetail.put("mm_trn_qty", mm_trn_qty+"");
								hmDtlGrp.put(dtlKey, hmDetail);
							}
							accptQty =0;
							if(hmWardRetExpDetails.containsKey(wardRetKey)){
								hmExp = new HashMap((HashMap)hmWardRetExpDetails.get(wardRetKey));
								accptQty = Integer.parseInt((String)hmExp.get("ret_item_qty"));
								alSalBinLocationCode = (ArrayList)hmExp.get("sal_bin_location_code");
							}
							else{
								hmExp			=	new HashMap();
								alSalBinLocationCode = new ArrayList();
							}
							alSalBinLocationCode.add((String)recordSet.get("sal_bin_location_code"+i));
							alSalBinLocationCode.add((String)BaseAndIssueUOMQty.get("BASE_QTY"));
							hmExp.put("facility_id",login_facility_id);
							hmExp.put("doc_type_code",this.getStockDocType());
							hmExp.put("sales_doc_no",(String)recordSet.get("doc_no"+i));
							hmExp.put("store_code", (String)recordSet.get("store_code"+i));
							hmExp.put("item_code", (String)recordSet.get("item_code"+i));
							hmExp.put("batch_id",(String)recordSet.get("batch_id"+i));
							hmExp.put("trade_id",(String)recordSet.get("trade_id"+i));
							hmExp.put("sal_bin_location_code",alSalBinLocationCode); 
							hmExp.put("bin_location_code",(String)recordSet.get("bin_location_code"+i));
							hmExp.put("expiry_date_or_receipt_date",(String)recordSet.get("expiry_date"+i));
							accptQty +=Integer.parseInt((String)BaseAndIssueUOMQty.get("BASE_QTY"));
							hmExp.put("ret_item_qty",accptQty+"");
							hmExp.put("sal_doc_type_code",(String)recordSet.get("doc_type"+i));
							hmExp.put("sal_doc_no",(String)recordSet.get("doc_no"+i));
							hmExp.put("sal_doc_srl_no",(String)recordSet.get("sal_doc_srlno"+i));  
							hmExp.put("WARDRETKEY",wardRetKey); 
							hmWardRetExpDetails.put(wardRetKey,hmExp); 
							hmExp.put("sal_facility_id",login_facility_id);
							
							dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);
							if(dis_charge_ind.equals("D"))
								take_home_yn="Y";
							else
								take_home_yn="N";
							hmDetail.put("take_home_yn",take_home_yn);	
							if(hmExpGrp.size()==0 || !hmExpGrp.containsKey(dtlKey)){
								insertExp = new ArrayList();
								insertExp.add(hmExp);
								hmExpGrp.put(dtlKey, insertExp);
							}
							else{
								insertExp = new ArrayList((ArrayList)hmExpGrp.get(dtlKey));
								int expindx=0;
								for(expindx=0; expindx < insertExp.size(); expindx++){
									hmTmpExp =(HashMap)insertExp.get(expindx);
									tmpwardRetKey =(String)hmTmpExp.get("WARDRETKEY");
									if(wardRetKey.equals(tmpwardRetKey)){
										wardRetKeyFound = true; 
										break;
									}
								}
								if(wardRetKeyFound)
									insertExp.set(expindx, hmExp);
								else
									insertExp.add(hmExp);
									
								hmExpGrp.put(dtlKey, insertExp);
								wardRetKeyFound = false;
							}
						} //END IF 
				//	}
				 }
				else{
					datarr	=	new ArrayList();
					wardRetKeyFound = false; //added for KDAH-SCF-0252 [IN:050489]
					
					if(!recordSet.get("AcceptedQty"+i).toString().equals("0"))//Added for  AMS-SCF-0038 [IN:030868] -Start
						recUpdate = true;
					else
						recUpdate = false;	//Added AMS-SCF-0038 [IN:030868] - End
					enc_id = (String)recordSet.get("encounter_id"+i); // added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 //moved from down for AMRI-SCF-0376 [IN:055578] -start
					if(enc_id.equals("")||enc_id.equals("11111")){
						 enc_id ="";
						 enc_patient_class="R";
					}
				
					if(!previousEncId.equals(enc_id)){
						if(bl_interface_yn.equals("Y")){// added for KDAH-SCF-0322
							try{
							getBillingUpdateLock(connection, login_facility_id, (String)tabData.get("PATIENT_ID"), enc_id);
							}catch(Exception e){
								map.put( "result", new Boolean( false ) ) ;	
								map.put( "message", e.getMessage() ) ;
								throw new Exception();
								
							}
							
						}
					}
					//Adding start for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508 
						if(EncList.size()>0 && EncList.contains(enc_id) ){
							 bl_recal_flag="Y";
						 }else{
							 bl_recal_flag="N";
						 }
							if( bl_recal_flag.equals("N")){
					                pstmt_blflag = connection.prepareStatement("SELECT BL_CHK_PKG_PAT_RECALC_YN(?,?,?,?,?) RESULT_FLAG from dual");
									pstmt_blflag.setString(1,"PH");
									pstmt_blflag.setString(2,login_facility_id);
									pstmt_blflag.setString(3,(String)recordSet.get("patientid"));
									pstmt_blflag.setString(4,(String)recordSet.get("doc_type"+i));
									pstmt_blflag.setString(5,(String)recordSet.get("doc_no"+i)); //drug_class
									
									resultSet_blflag = pstmt_blflag.executeQuery() ;
												
									if(resultSet_blflag!=null && resultSet_blflag.next()){
										bl_result =resultSet_blflag.getString("RESULT_FLAG");
										
									}
                               if(bl_result.equals("Y")){
								   bl_recal_flag="Y";
									   EncList.add(enc_id);
									   orig_enc_patient_class  = getEncounterPatientClass(enc_id, (String)recordSet.get("patientid"));
									   if(EncListGroup.size()>0){
											String curr_enc=(String)EncListGroup.get(0);
											String visit_id="";
											String episode_id="";
											if(!orig_enc_patient_class.equals("I") && !orig_enc_patient_class.equals("D")){
												if (!enc_id.equals("") && !enc_id.equals(null)) {
													episode_id = enc_id.substring(0, (enc_id.length() - 4)); 
													visit_id = enc_id.substring(enc_id.length() - 4); 
												}
												}else{
													episode_id = enc_id;
													visit_id = "";
												}
											  EncListGroup.clear();
											  EncListGroup.add(curr_enc+"#"+orig_enc_patient_class+"~"+episode_id+"~"+visit_id);
										}else{
											String visit_id="";
											String episode_id="";
											if(!orig_enc_patient_class.equals("I") && !orig_enc_patient_class.equals("D")){
												if (!enc_id.equals("") && !enc_id.equals(null)) {
													episode_id = enc_id.substring(0, (enc_id.length() - 4)); 
													visit_id = enc_id.substring(enc_id.length() - 4); 
												}
												}else{
													episode_id = enc_id;
													visit_id = "";
												}
											   EncListGroup.add(orig_enc_patient_class+"~"+episode_id+"~"+visit_id);
											}
										
								}
						 }
									closeStatement(pstmt_blflag);
									closeResultSet(resultSet_blflag);
									//Adding end for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508 
					 
					previousEncId = enc_id;
					tabData.put( "PATIENT_CLASS",enc_patient_class);
					hdrKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i) ;
					dtlKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i)+recordSet.get("sal_doc_srlno"+i) ;//moved from down for AMRI-SCF-0376 [IN:055578] -end

					 if((((String)recordSet.get("acknow_ledg"+i)).equals("A"))||(((String)recordSet.get("acknow_ledg"+i)).equals("R")) ){
						//datarr	=	new ArrayList();
					
						//added  for ghl-scf-1448 start
						  dispNo=(String)recordSet.get("dispno"+i);
						  binLocnCode=(String)recordSet.get("bin_location_code"+i);
						  storeCode =(String)recordSet.get("store_code"+i);
						  orderId =(String)recordSet.get("order_id"+i);
						  itemCode=(String)recordSet.get("item_code"+i);
						  expieryDate=(String)recordSet.get("expiry_date"+i);
						  batchId =(String)recordSet.get("batch_id"+i);
						  retDocNo=(String)recordSet.get("ret_doc_no"+i);
						  retDocLineNo=(String)recordSet.get("ret_doc_line_no"+i);
						  patientId=(String)recordSet.get("patientid");
						 
						 String result = "";
//						 String result		=getretunableqty( dispNo, binLocnCode,storeCode,orderId,itemCode,expieryDate,batchId ,retDocNo,retDocLineNo,patientId);
						//added  for ghl-scf-1448 END and commented for KDAH-SCF-0635 and AMRI-SCF-0617 and ML-MMOH-SCF-1274.1
						
						 
						 datarr.add((String)recordSet.get("dispno"+i));
						datarr.add((String)recordSet.get("bin_location_code"+i));
						datarr.add((String)recordSet.get("srlno"+i));
						datarr.add((String)recordSet.get("srlnobatch"+i));
						datarr.add((String)recordSet.get("actualReturn"+i));
						datarr.add((String)recordSet.get("item_code"+i));
						datarr.add((String)recordSet.get("acknow_ledg"+i));
						datarr.add((String)recordSet.get("remarks_desc"+i));
						datarr.add((String)recordSet.get("return_reason_code"+i));
						datarr.add((String)recordSet.get("ret_doc_no"+i));
						datarr.add((String)recordSet.get("ret_doc_line_no"+i));
						datarr.add((String)recordSet.get("store_code"+i));
						datarr.add((String)recordSet.get("AcceptedQty"+i));
						datarr.add((String)recordSet.get("RejectedQty"+i));
						datarr.add((String)recordSet.get("BalanceQty"+i));

						datarr.add((String)recordSet.get("batch_id"+i));
						datarr.add((String)recordSet.get("expiry_date"+i));
						datarr.add((String)recordSet.get("disp_qty"+i));
						datarr.add((String)recordSet.get("uom_code"+i));
						datarr.add((String)recordSet.get("modified_date"+i)); //added for SKR-SCF-0393 [IN:030939] //19
						datarr.add(hdrKey); //added for AMRI-SCF-0376 [IN:055578] //20
						datarr.add(dtlKey); //added for AMRI-SCF-0376 [IN:055578] //21
						datarr.add((String)recordSet.get("order_id"+i)); //Added for GHL-SCF-1084
						datarr.add((String)recordSet.get("order_line_no"+i)); //Added for GHL-SCF-1084
						datarr.add(result);//added  for ghl-scf-1448 
					}

					if(recordSet.get("acknow_ledg"+i).toString().equals("P") && ( !recordSet.get("AcceptedQty"+i).toString().equals("0") || !recordSet.get("RejectedQty"+i).toString().equals("0"))){
						//datarr	=	new ArrayList();
					
						//added  for ghl-scf-1448 start
						  dispNo=(String)recordSet.get("dispno"+i);
						  binLocnCode=(String)recordSet.get("bin_location_code"+i);
						  storeCode =(String)recordSet.get("store_code"+i);
						  orderId =(String)recordSet.get("order_id"+i);
						  itemCode=(String)recordSet.get("item_code"+i);
						  expieryDate=(String)recordSet.get("expiry_date"+i);
						  batchId =(String)recordSet.get("batch_id"+i);
						  retDocNo=(String)recordSet.get("ret_doc_no"+i);
						  retDocLineNo=(String)recordSet.get("ret_doc_line_no"+i);
						  patientId=(String)recordSet.get("patientid");
						  
						  String result = "";
						 
//						 String result		=getretunableqty( dispNo, binLocnCode,storeCode,orderId,itemCode,expieryDate,batchId ,retDocNo,retDocLineNo,patientId);
						//added  for ghl-scf-1448 END and commented for KDAH-SCF-0635 and AMRI-SCF-0617 and ML-MMOH-SCF-1274.1
						
						datarr.add((String)recordSet.get("dispno"+i));
						datarr.add((String)recordSet.get("bin_location_code"+i));
						datarr.add((String)recordSet.get("srlno"+i));
						datarr.add((String)recordSet.get("srlnobatch"+i));
						datarr.add((String)recordSet.get("actualReturn"+i));
						datarr.add((String)recordSet.get("item_code"+i));
						datarr.add((String)recordSet.get("acknow_ledg"+i));
						datarr.add((String)recordSet.get("remarks_desc"+i));
						datarr.add((String)recordSet.get("return_reason_code"+i));
						datarr.add((String)recordSet.get("ret_doc_no"+i));
						datarr.add((String)recordSet.get("ret_doc_line_no"+i));
						datarr.add((String)recordSet.get("store_code"+i));
						datarr.add((String)recordSet.get("AcceptedQty"+i));
						datarr.add((String)recordSet.get("RejectedQty"+i));
						datarr.add((String)recordSet.get("BalanceQty"+i));
						
						datarr.add((String)recordSet.get("batch_id"+i));
						datarr.add((String)recordSet.get("expiry_date"+i));
						datarr.add((String)recordSet.get("disp_qty"+i));
						datarr.add((String)recordSet.get("uom_code"+i));
						datarr.add((String)recordSet.get("modified_date"+i)); //added for SKR-SCF-0393 [IN:030939]
						datarr.add(hdrKey); //added for AMRI-SCF-0376 [IN:055578] //20
						datarr.add(dtlKey); //added for AMRI-SCF-0376 [IN:055578] //21
						datarr.add((String)recordSet.get("order_id"+i)); //Added for GHL-SCF-1084
						datarr.add((String)recordSet.get("order_line_no"+i)); //Added for GHL-SCF-1084
						datarr.add(result);//added  for ghl-scf-1448 
					}
					
					if(recUpdate){//Added for AMS-SCF-0038 [IN:030868] -Start
						wardRetKey = (String)recordSet.get("dispno"+i)+"_"+(String)recordSet.get("srlno"+i)+"_"+(String)recordSet.get("bin_location_code"+i)+"_"+(String)recordSet.get("batch_id"+i)+"_"+(String)recordSet.get("expiry_date"+i); //(String)recordSet.get("srlnobatch"+i)+"_"+ //added for KDAH-SCF-0252 [IN:050489]//batch_id added for AMRI-SCF-0414 [IN:058529] and AMRI-SCF-0378 [IN:055710] // +"_"+(String)recordSet.get("expiry_date"+i) Added for AMRI-SCF-0538
						sAccptQty= (String)recordSet.get("AcceptedQty"+i);
						if(sAccptQty ==null || sAccptQty.equals(""))
							sAccptQty = "0";
						accptQty= Integer.parseInt(sAccptQty);
						ward_ret_qty=(String)recordSet.get("returnable"+i);  //Added for GHL-CRF-0627
						if(ward_ret_qty ==null || ward_ret_qty.equals(""))
							ward_ret_qty = "0";
						ward_ret_req_qty= Integer.parseInt(ward_ret_qty);
						
						if(hmWardRetDetails.containsKey(wardRetKey)){
							alWardRetDetails = (ArrayList)hmWardRetDetails.get(wardRetKey);
							stmpAccptQty= (String)alWardRetDetails.get(12);
							if(stmpAccptQty ==null || stmpAccptQty.equals(""))
								stmpAccptQty = "0";
							tmpAccptQty= Integer.parseInt(stmpAccptQty)+accptQty;
							alWardRetDetails.set(12,tmpAccptQty+"");
							ward_ret_req_qty_new=ward_ret_req_qty_new+ward_ret_req_qty;  //Added for GHL-CRF-0627
							alWardRetDetails.set(25,ward_ret_req_qty_new);   //Added for GHL-CRF-0627
						}
						else{
							ward_ret_req_qty_new=ward_ret_req_qty;   //Added for GHL-CRF-0627
							datarr.add(ward_ret_req_qty_new);   //Added for GHL-CRF-0627
							alWardRetDetails = new ArrayList(datarr);
						}
						hmWardRetDetails.put(wardRetKey, alWardRetDetails);
					}		//Added for AMS-SCF-0038 [IN:030868] -End
System.err.println("datarr==1030==>" + datarr);
					tabData.put("RECORD"+i,datarr);
					count1++;
					/*enc_id = (String)recordSet.get("encounter_id"+i); // added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
					if(enc_id.equals("")||enc_id.equals("11111")){
						 enc_id ="";
						 enc_patient_class="R";
					}
					tabData.put( "PATIENT_CLASS",enc_patient_class);
					hdrKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i) ;
					dtlKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i)+recordSet.get("sal_doc_srlno"+i) ;*///move to above for AMRI-SCF-0376 [IN:055578]
					if(eff_status.equals("E")&&(((String)recordSet.get("acknow_ledg"+i)).equals("A"))||(((String)recordSet.get("acknow_ledg"+i)).equals("P"))) {
					 // Header Detail
						if(hmHeader.size()==0 || !hmHeader.containsKey(hdrKey)){ // ||!hmHeader.containsKey(hdrKey) added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
							hmHeader_dtls	=	new HashMap();
							hmHeader_dtls.put("facility_id",login_facility_id);
							hmHeader_dtls.put("doc_type_code",this.getStockDocType()); //uncommented to get return doc type 
							hmHeader_dtls.put("sal_doc_type_code",(String)recordSet.get("doc_type"+i)); //Uncommented  for KDAH-SCF-0452
							hmHeader_dtls.put("sales_doc_no",(String)recordSet.get("doc_no"+i));
							hmHeader_dtls.put("doc_date",getCurrDate());
							hmHeader_dtls.put("doc_ref","");
							hmHeader_dtls.put("store_code",(String)recordSet.get("store_code"+i));
							hmHeader_dtls.put("patient_id",(String)recordSet.get("patientid"));
							//hmHeader.put("encounter_id",this.getEncounter());
							hmHeader_dtls.put("encounter_id",enc_id);
							hmHeader_dtls.put("finalized_yn","Y");
							hmHeader_dtls.put("gl_interfaced_yn","N");
							hmHeader_dtls.put("trn_type","SRT");
							hmHeader_dtls.put("remarks","");				
							hmHeader_dtls.put("item_class_code","");
							hmHeader_dtls.put("module_id","PH");
							tabData.put( "STORE_CODE",(String)recordSet.get("store_code"+i));	   
						  // if(bl_interface_yn.equals("Y")){
								hmHeader_dtls.put("billable_trn_yn",bl_interface_yn);
								hmHeader_dtls.put("sal_trn_type",enc_patient_class);
						  // }
							dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);//added for [IN:045323] MMS BETA ADHOC Testing -start
							if(dis_charge_ind.equals("D"))
								take_home_yn="Y";
							else
								take_home_yn="N";
							hmHeader_dtls.put("take_home_yn",take_home_yn);	//added for [IN:045323] MMS BETA ADHOC Testing -end
							hmHeader.put(hdrKey, hmHeader_dtls); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
						}
						// Item Detail
						if(hmDtlGrp.size()==0 || !hmDtlGrp.containsKey(dtlKey)){ // ||!hmHeader.containsKey(hdrKey) added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
							hmDetail		=	new HashMap();
							//insertDetail	=	new ArrayList();
							hmDetail.put("dtlKey",dtlKey); //added for AMRI-SCF-0376 [IN:055578]
							hmDetail.put("facility_id",login_facility_id);
							hmDetail.put("doc_type_code",this.getStockDocType()); // (String)recordSet.get("doc_type"+i) 
							hmDetail.put("sales_doc_no",(String)recordSet.get("doc_no"+i));
							//hmDetail.put("doc_srl_no",(String)recordSet.get("srlnobatch"+i));
							//hmDetail.put("doc_srl_no",count1+"");
							hmDetail.put("item_code", (String)recordSet.get("item_code"+i));
							hmDetail.put("stock_item_yn","Y");   
							BaseAndIssueUOMQty=(HashMap)getBaseAndIssueUOMQty((String)recordSet.get("item_code"+i),  (String)recordSet.get("store_code"+i), (String)recordSet.get("actualReturn"+i),  (String)recordSet.get("uom_code"+i));
							hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY"));
							hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
							//hmDetail.put("item_qty",(String)recordSet.get("actualReturn"+i));
							hmDetail.put("uom_code",CommonBean.checkForNull((String)recordSet.get("uom_code"+i))); 
							hmDetail.put("remarks","");
							hmDetail.put("sales_doc_type_code",(String)recordSet.get("doc_type"+i));
							hmDetail.put("sal_doc_no",(String)recordSet.get("doc_no"+i)); 
							hmDetail.put("sal_doc_srl_no",(String)recordSet.get("sal_doc_srlno"+i)); 
							hmDetail.put("sal_facility_id",login_facility_id);//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Setting Sale Facility to EJB.
							hmDetail.put("FACILITY_STR_FOR_BL",login_facility_id+"|"+(String)tabData.get( "FACILITY_ID" )); //this.orderingfacilityid.trim() changed to login_facility_id
							hmDetail.put("disp_bill_stage",disp_bill_stage); //added for KAUH-SCF-0320
							dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);// added for skr-scf-0591
							if(dis_charge_ind.equals("D"))
								take_home_yn="Y";
							else
								take_home_yn="N";
							hmDetail.put("take_home_yn",take_home_yn);	// addeding end for skr-scf-0591
			 
							if(bl_interface_yn.equals("Y") && datarr!=null && datarr.size()>0){
								pstmt_select1.setString(1,(String)datarr.get(0));
								pstmt_select1.setString(2,(String)datarr.get(2));
								pstmt_select1.setString(3,(String)tabData.get( "FACILITY_ID" ));
								rset	=	pstmt_select1.executeQuery();
								if(rset.next()){
									hmDetail.put("p_overridden_excl_incl_ind",checkForNull(rset.getString("BL_INCL_EXCL_OVERRIDE_VALUE")));
									hmDetail.put("p_overridden_action_reason",checkForNull(rset.getString("BL_INCL_EXCL_OVERRIDE_REASON")));
								} 
								closeResultSet( rset );				
							}
							hmDtlGrp.put(dtlKey, hmDetail); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
							//dtlKeyList.add(dtlKey);
						//insertDetail.add(hmDetail);
						// added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
							/*if(hmDtlGrp.size()>0 || !hmDtlGrp.containsKey(dtlKey)){
								insertDetail = new ArrayList();
								insertDetail.add(hmDetail);
								hmDtlGrp.put(dtlKey, insertDetail);
							}
							else{
								insertDetail = new ArrayList((ArrayList)hmDtlGrp.get(dtlKey));
								insertDetail.add(hmDetail);
								hmDtlGrp.put(dtlKey, insertDetail);
							}*/
							//dtlKeyList.add(dtlKey);
							if(hmhdrDtlKeyMap.size()==0 || !hmhdrDtlKeyMap.containsKey(hdrKey)){
								dtlKeyList = new ArrayList();
								dtlKeyList.add(dtlKey);
								hmhdrDtlKeyMap.put(hdrKey, dtlKeyList);
							}
							else{
								dtlKeyList = new ArrayList((ArrayList)hmhdrDtlKeyMap.get(hdrKey));
								dtlKeyList.add(dtlKey);
								hmhdrDtlKeyMap.put(hdrKey, dtlKeyList);
							}
						}
						else{
							hmDetail = (HashMap)hmDtlGrp.get(dtlKey);
							//hmDetail = (HashMap)insertDetail.get(0);
							BaseAndIssueUOMQty=(HashMap)getBaseAndIssueUOMQty((String)recordSet.get("item_code"+i),  (String)recordSet.get("store_code"+i), (String)recordSet.get("actualReturn"+i),  (String)recordSet.get("uom_code"+i));
							tot_item_qty = Float.parseFloat(hmDetail.get("item_qty")==null?"0":(String)hmDetail.get("item_qty"));
							mm_trn_qty = Float.parseFloat(hmDetail.get("mm_trn_qty")==null?"0":(String)hmDetail.get("mm_trn_qty"));
							tot_item_qty += Float.parseFloat((BaseAndIssueUOMQty.get("ISSUE_QTY")==null?"0":(String)BaseAndIssueUOMQty.get("ISSUE_QTY")));
							mm_trn_qty += Float.parseFloat((BaseAndIssueUOMQty.get("BASE_QTY")==null?"0":(String)BaseAndIssueUOMQty.get("BASE_QTY")));
							hmDetail.put("item_qty",tot_item_qty+"");
							hmDetail.put("mm_trn_qty", mm_trn_qty+"");
							hmDtlGrp.put(dtlKey, hmDetail);
						}
						//if(hmExpGrp.size()==0 || !hmExpGrp.containsKey(dtlKey)){ // ||!hmHeader.containsKey(hdrKey) added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
						accptQty =0;
						if(hmWardRetExpDetails.containsKey(wardRetKey)){
							hmExp = new HashMap((HashMap)hmWardRetExpDetails.get(wardRetKey));
							accptQty = Integer.parseInt((String)hmExp.get("ret_item_qty"));
							alSalBinLocationCode = (ArrayList)hmExp.get("sal_bin_location_code");//added for KDAH-SCF-0252 [IN:050489]
						}
						else{
							hmExp			=	new HashMap();
							alSalBinLocationCode = new ArrayList(); //added for KDAH-SCF-0252 [IN:050489]
						}
						alSalBinLocationCode.add((String)recordSet.get("sal_bin_location_code"+i));//added for KDAH-SCF-0252 [IN:050489]
						alSalBinLocationCode.add((String)BaseAndIssueUOMQty.get("BASE_QTY"));//added for KDAH-SCF-0252 [IN:050489]
						//insertExp		=	new ArrayList();
						hmExp.put("facility_id",login_facility_id);
						hmExp.put("doc_type_code",this.getStockDocType());//(String)recordSet.get("doc_type"+i)
						hmExp.put("sales_doc_no",(String)recordSet.get("doc_no"+i));
						//hmExp.put("doc_srl_no",(String)recordSet.get("srlnobatch"+i));		
						//hmExp.put("doc_srl_no",count1+"");
						hmExp.put("store_code", (String)recordSet.get("store_code"+i));
						hmExp.put("item_code", (String)recordSet.get("item_code"+i));
						hmExp.put("batch_id",(String)recordSet.get("batch_id"+i));
						hmExp.put("trade_id",(String)recordSet.get("trade_id"+i));
						//hmExp.put("sal_bin_location_code",(String)recordSet.get("sal_bin_location_code"+i)); //Commented for KDAH-SCF-0252 [IN:050489]
						hmExp.put("sal_bin_location_code",alSalBinLocationCode); //added for KDAH-SCF-0252 [IN:050489]
						hmExp.put("bin_location_code",(String)recordSet.get("bin_location_code"+i));
						hmExp.put("expiry_date_or_receipt_date",(String)recordSet.get("expiry_date"+i));
						//BaseAndIssueUOMQty = (HashMap)getBaseAndIssueUOMQty((String)recordSet.get("item_code"+i),  (String)recordSet.get("store_code"+i), (String)recordSet.get("actualReturn"+i),  (String)recordSet.get("uom_code"+i));
						accptQty +=Integer.parseInt((String)BaseAndIssueUOMQty.get("BASE_QTY"));
						hmExp.put("ret_item_qty",accptQty+"");
						//hmExp.put("ret_item_qty",(String)recordSet.get("actualReturn"+i));
						hmExp.put("sal_doc_type_code",(String)recordSet.get("doc_type"+i));
						hmExp.put("sal_doc_no",(String)recordSet.get("doc_no"+i));
						hmExp.put("sal_doc_srl_no",(String)recordSet.get("sal_doc_srlno"+i));  //Added for SKR-SCF-0625 [35212]
						hmExp.put("WARDRETKEY",wardRetKey); //Added for AMS-SCF-0038 [IN:030868]
						hmWardRetExpDetails.put(wardRetKey,hmExp); //Added for AMS-SCF-0038 [IN:030868]
						hmExp.put("sal_facility_id",login_facility_id);//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Setting Sale Facility to EJB.
						
						dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);// added for skr-scf-0591
						if(dis_charge_ind.equals("D"))
							take_home_yn="Y";
						else
							take_home_yn="N";
						hmDetail.put("take_home_yn",take_home_yn);	// addeding end for skr-scf-0591
						//insertExp.add(hmExp);
						//hmExpGrp.put(dtlKey, hmExp); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
						//}
						if(hmExpGrp.size()==0 || !hmExpGrp.containsKey(dtlKey)){
							insertExp = new ArrayList();
							insertExp.add(hmExp);
							hmExpGrp.put(dtlKey, insertExp);
						}
						else{
							insertExp = new ArrayList((ArrayList)hmExpGrp.get(dtlKey));
							int expindx=0;
							for(expindx=0; expindx < insertExp.size(); expindx++){
								hmTmpExp =(HashMap)insertExp.get(expindx);
								//Added for  AMS-SCF-0038 [IN:030868] -Start
								tmpwardRetKey =(String)hmTmpExp.get("WARDRETKEY");
								if(wardRetKey.equals(tmpwardRetKey)){
									wardRetKeyFound = true; //added for KDAH-SCF-0252 [IN:050489]
									break;
								}//Added for  AMS-SCF-0038 [IN:030868] -End
							}
							if(wardRetKeyFound)//added for KDAH-SCF-0252 [IN:050489]
								insertExp.set(expindx, hmExp);
							else
								insertExp.add(hmExp);
								
							hmExpGrp.put(dtlKey, insertExp);
							wardRetKeyFound = false; //added for KDAH-SCF-0252 [IN:050489]
						}
					} //END IF 
				 } // If, else condition added for GHL-CRF-0413.8 , if condition for GHL-CRF-0413.8 and else for existing functionality - End
				} //END FOR LOOP
				hdrKeyList = new ArrayList(hmHeader.keySet());
				for(int encCount=0; encCount<hdrKeyList.size(); encCount++){ //ENCOUNTER BASED HEADER FOR LOOP added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
					hdrKey = (String) hdrKeyList.get(encCount);
					//insertDetail = new ArrayList();
					tmpInsertExp = new ArrayList();
					dtlKeyList = (ArrayList)hmhdrDtlKeyMap.get(hdrKey);
					for(int dtlindx=0; dtlindx < dtlKeyList.size(); dtlindx++){
						hmDetail = new HashMap();
						hmExp = new HashMap();
						hmDetail = (HashMap)hmDtlGrp.get(dtlKeyList.get(dtlindx));
						tmpInsertExp = (ArrayList)hmExpGrp.get(dtlKeyList.get(dtlindx));
						hmDetail.put("doc_srl_no",(dtlindx+1)+"");
						//hmExp.put("doc_srl_no",(dtlindx+1)+"");
					/*	for(int i=0; i < insertDetail.size();i++){
							hmDetail = new HashMap();
							hmDetail= (HashMap)insertDetail.get(i);
							hmDetail.put("doc_srl_no",(dtlindx+1)+"");
							//insertDetail.add(hmDetail);
						}*/
						for(int i=0;i< tmpInsertExp.size(); i++){
							hmExp = new HashMap();
							hmExp = (HashMap)tmpInsertExp.get(i);
							hmExp.put("doc_srl_no",(dtlindx+1)+"");
							//insertExp.set(i,hmExp);
							if(insertExpGrp.size()==0 || !insertExpGrp.containsKey(hdrKey)){
								insertExp = new ArrayList();
								insertExp.add(hmExp);
								insertExpGrp.put(hdrKey, insertExp);
							}
							else{
								insertExp = new ArrayList((ArrayList)insertExpGrp.get(hdrKey));
								insertExp.add(hmExp);
								insertExpGrp.put(hdrKey, insertExp);
							}
						}
					//}
						if(insertDetailGrp.size()==0 || !insertDetailGrp.containsKey(hdrKey)){
							insertDetail = new ArrayList();
							insertDetail.add(hmDetail);
							insertDetailGrp.put(hdrKey, insertDetail);
						}
						else{
							insertDetail = new ArrayList((ArrayList)insertDetailGrp.get(hdrKey));
							insertDetail.add(hmDetail);
							insertDetailGrp.put(hdrKey, insertDetail);
						}
					}	
				}
				tot_values.add(hmHeader);
				tot_values.add(insertDetailGrp);
				tot_values.add(insertExpGrp);
				tabData.put( "STOCK_VALS", tot_values);
				tabData.put( "WARDRETDETAILS", hmWardRetDetails);
				tabData.put( "ENCLISTGROUP", EncListGroup);//Added for KDAH-SCF-0452
			}//END IF
			if(eff_status.equals("D")){
				int totalrows=Integer.parseInt(rows);
				int count =0;
				
			/*	ArrayList retMedRestr = getDischargeStage(login_facility_id, (String)recordSet.get("encounter_id"+"1"),(String)recordSet.get("patientid"));  // Added for GHL-CRF-0412.3 -Start
					
				if(retMedRestr!=null && retMedRestr.size()>0){
					if(retMedRestr.size()>2){
		              if(retMedRestr.get(2).equals("I") && ((retMedRestr.get(0).equals("Y") || retMedRestr.get(1).equals("7"))))
	          	         retMedRestrStage=true;
	                  else if(retMedRestr.get(2).equals("P") && (retMedRestr.get(1).equals("7")))
	          	         retMedRestrStage=true;
					}
	           else if(retMedRestr.get(0).equals("08") && (retMedRestr.get(1).equals("I")|| retMedRestr.get(1).equals("P") || retMedRestr.get(1).equals("D")))
	          	  retMedRestrStage=true;	
				}*/ //commented for TBMC-SCF-0105.1
	        	 //commented for TBMC- SCF- 0105
				/*if(retMedRestrStage){
						map.put( "result", new Boolean( false ) ) ;	
						map.put( "message", getMessage(getLanguageId(),"CANNOT_RETURN","PH"));
						throw new Exception();		
				} */  // Added for GHL-CRF-0412.3 - End
				
				for (int i=1;i<=totalrows ;i++ ){
						disp_bill_stage = "";//KAUH-SCF-0320
						dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);//added for tbmc-scf-0105
						//Added for TBMC-SCF-0105.1
						ArrayList retMedRestr = getDischargeStage(login_facility_id, (String)recordSet.get("encounter_id"+i),(String)recordSet.get("patientid"));  // Added for GHL-CRF-0412.3 -Start,added i for TBMC-SCF-0105.1
						
						if(retMedRestr!=null && retMedRestr.size()>0){
							if(retMedRestr.size()>2){						
				              if(retMedRestr.get(2).equals("I") && ((retMedRestr.get(0).equals("Y") || retMedRestr.get(1).equals("7"))))
			          	         retMedRestrStage=true;
			                  else if(retMedRestr.get(2).equals("P") && (retMedRestr.get(1).equals("7")))
			          	         retMedRestrStage=true;
							}
			           else if(retMedRestr.get(0).equals("08") && (retMedRestr.get(1).equals("I")|| retMedRestr.get(1).equals("P") || retMedRestr.get(1).equals("D")))
			          	  retMedRestrStage=true;	
						} //Added for TBMC-SCF-0105.1
						
						//added for TBMC-SCF-0161
						String patientClass = getPatientCategory();
						System.out.println("patientClass: "+patientClass); 
						if(patientClass.equalsIgnoreCase("O") /*&& !dis_charge_ind.equalsIgnoreCase("D")*/ ){
							retMedRestrStage=false;
 						}
						
						
					disp_bill_stage=getDispLocnBillStage((String)recordSet.get("store_code"+i),(String)recordSet.get("dispno"+i),login_facility_id);//KAUH-SCF-0320
					if(recordSet.get("barcodeFlag").toString().equals("Y") ){ // If, else condition added for GHL-CRF-0413.8 , if condition for GHL-CRF-0413.8 and else for existing functionality  - Start
						if(recordSet.get("check_return_name"+i).toString().equals("Y") ){ // If, else condition added for GHL-CRF-0413.8 , if condition for GHL-CRF-0413.8 and else for existing functionality  - Start
							 selectedRows++; 
							enc_id = (String)recordSet.get("encounter_id"+i); // added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 //moved from down for AMRI-SCF-0376 [IN:055578]  -start
					if(enc_id.equals("")||enc_id.equals("11111")){
						 enc_id ="";
						 enc_patient_class="R";
					}
					if(!previousEncId.equals(enc_id)){
						if(bl_interface_yn.equals("Y")){// added for KDAH-SCF-0322
							try{
							getBillingUpdateLock(connection, login_facility_id, (String)tabData.get("PATIENT_ID"), enc_id);
							}catch(Exception e){
								map.put( "result", new Boolean( false ) ) ;	
								map.put( "message", e.getMessage() ) ;
								throw new Exception();
								
							}
							
						}
					}
					//Adding start for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508 
						 if(EncList.size()>0 && EncList.contains(enc_id) ){
							 bl_recal_flag="Y";
						 }else{
							 bl_recal_flag="N";
						 }
							if( bl_recal_flag.equals("N")){
							
					                pstmt_blflag = connection.prepareStatement("SELECT BL_CHK_PKG_PAT_RECALC_YN(?,?,?,?,?) RESULT_FLAG from dual");
									pstmt_blflag.setString(1,"PH");
									pstmt_blflag.setString(2,login_facility_id);
									pstmt_blflag.setString(3,(String)recordSet.get("patientid"));
									pstmt_blflag.setString(4,(String)recordSet.get("doc_type"+i));
									pstmt_blflag.setString(5,(String)recordSet.get("doc_no"+i)); //drug_class
									
									resultSet_blflag = pstmt_blflag.executeQuery() ;
												
									if(resultSet_blflag!=null && resultSet_blflag.next()){
										bl_result =resultSet_blflag.getString("RESULT_FLAG");
										
									}
                               if(bl_result.equals("Y")){
								   bl_recal_flag="Y";
									   EncList.add(enc_id);
									   orig_enc_patient_class  = getEncounterPatientClass(enc_id, (String)recordSet.get("patientid"));
									   if(EncListGroup.size()>0){
											String curr_enc=(String)EncListGroup.get(0);
											String visit_id="";
											String episode_id="";
											if(!orig_enc_patient_class.equals("I") && !orig_enc_patient_class.equals("D")){
												if (!enc_id.equals("") && !enc_id.equals(null)) {
													episode_id = enc_id.substring(0, (enc_id.length() - 4)); 
													visit_id = enc_id.substring(enc_id.length() - 4); 
												}
												}else{
													episode_id = enc_id;
													visit_id = "";
												}
											  EncListGroup.clear();
											  EncListGroup.add(curr_enc+"#"+orig_enc_patient_class+"~"+episode_id+"~"+visit_id);
										}else{
											String visit_id="";
											String episode_id="";
											if(!orig_enc_patient_class.equals("I") && !orig_enc_patient_class.equals("D")){
												if (!enc_id.equals("") && !enc_id.equals(null)) {
													episode_id = enc_id.substring(0, (enc_id.length() - 4)); 
													visit_id = enc_id.substring(enc_id.length() - 4); 
												}
												}else{
													episode_id = enc_id;
													visit_id = "";
												}
											   EncListGroup.add(orig_enc_patient_class+"~"+episode_id+"~"+visit_id);
											}
										
								}
						 }
									closeStatement(pstmt_blflag);
									closeResultSet(resultSet_blflag);
									//Adding end for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508 
						
					previousEncId = enc_id;
					tabData.put( "PATIENT_CLASS",enc_patient_class);
					hdrKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i) ;
					dtlKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i)+recordSet.get("sal_doc_srlno"+i) ; //moved from down for AMRI-SCF-0376 [IN:055578]  -end
					datarr	=	new ArrayList();
					if( !((String)recordSet.get("actualReturn"+i)).equals("") && !((String)recordSet.get("actualReturn"+i)).equals("0") ) {
						datarr.add((String)recordSet.get("dispno"+i)); //0
						datarr.add((String)recordSet.get("bin_location_code"+i));
						datarr.add((String)recordSet.get("srlno"+i));
						datarr.add((String)recordSet.get("srlnobatch"+i));
						datarr.add((String)recordSet.get("actualReturn"+i));
						datarr.add((String)recordSet.get("item_code"+i));
						datarr.add((String)recordSet.get("store_code"+i));
						
						datarr.add((String)recordSet.get("batch_id"+i));
						datarr.add((String)recordSet.get("expiry_date"+i));
						datarr.add((String)recordSet.get("disp_qty"+i));
						datarr.add((String)recordSet.get("uom_code"+i));
						datarr.add((String)recordSet.get("Sal_Facility_id"+i));//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Setting Sale Facility to EJB.
						datarr.add(hdrKey); //added for AMRI-SCF-0376 [IN:055578] //12
						datarr.add(dtlKey); //added for AMRI-SCF-0376 [IN:055578] //13
						datarr.add((String)recordSet.get("order_id"+i)); //Added for GHL-SCF-1084
						datarr.add((String)recordSet.get("order_line_no"+i)); //Added for GHL-SCF-1084
				
						tabData.put("RECORD"+selectedRows,datarr); 
						count++;
						/*enc_id = (String)recordSet.get("encounter_id"+i); // added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
						if(enc_id.equals("")||enc_id.equals("11111")){
							 enc_id ="";
							 enc_patient_class="R";
						}
						tabData.put( "PATIENT_CLASS",enc_patient_class);
						hdrKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i) ;
						dtlKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i)+recordSet.get("sal_doc_srlno"+i) ;*/
						// Header Detail
						if(hmHeader.size()==0 || !hmHeader.containsKey(hdrKey)){ // ||!hmHeader.containsKey(hdrKey) added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
							hmHeader_dtls	=	new HashMap();
							hmHeader_dtls.put("facility_id",login_facility_id);
							hmHeader_dtls.put("doc_type_code",this.getStockDocType());
							hmHeader_dtls.put("sal_doc_type_code",(String)recordSet.get("doc_type"+i));//Added for KDAH-SCF-0452
							hmHeader_dtls.put("sales_doc_no",(String)recordSet.get("doc_no"+i));
							hmHeader_dtls.put("doc_date",getCurrDate());
							hmHeader_dtls.put("doc_ref","");
							hmHeader_dtls.put("store_code",(String)recordSet.get("store_code"+i));
							hmHeader_dtls.put("patient_id",(String)recordSet.get("patientid"));
							//hmHeader_dtls.put("encounter_id",this.getEncounter());
							hmHeader_dtls.put("encounter_id",enc_id);
							hmHeader_dtls.put("finalized_yn","Y");
							hmHeader_dtls.put("gl_interfaced_yn","N");
							hmHeader_dtls.put("trn_type","SRT");
							hmHeader_dtls.put("remarks","");				
							hmHeader_dtls.put("item_class_code","");
							hmHeader_dtls.put("module_id","PH");

							tabData.put( "STORE_CODE",(String)recordSet.get("store_code"+i));	   
						   //if(bl_interface_yn.equals("Y")){
								 hmHeader_dtls.put("billable_trn_yn",bl_interface_yn);
								 hmHeader_dtls.put("sal_trn_type",enc_patient_class);
						   //}
							dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);//added for [IN:045323] MMS BETA ADHOC Testing -start
							if(dis_charge_ind.equals("D"))
								take_home_yn="Y";
							else
								take_home_yn="N";
							hmHeader_dtls.put("take_home_yn",take_home_yn);	//added for [IN:045323] MMS BETA ADHOC Testing -end
							hmHeader.put(hdrKey, hmHeader_dtls); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
						}
						// Item Detail
						if(hmDtlGrp.size()==0 || !hmDtlGrp.containsKey(dtlKey)){ // ||!hmHeader.containsKey(hdrKey) added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
							hmDetail		=	new HashMap();
							//insertDetail	=	new ArrayList();

							hmDetail.put("dtlKey",dtlKey); //added for AMRI-SCF-0376 [IN:055578]
							hmDetail.put("facility_id",login_facility_id);
							hmDetail.put("doc_type_code",this.getStockDocType()); // (String)recordSet.get("doc_type"+i)
							hmDetail.put("sales_doc_no",(String)recordSet.get("doc_no"+i));
							//hmDetail.put("doc_srl_no",(String)recordSet.get("srlnobatch"+i));
							hmDetail.put("doc_srl_no",count+"");
							hmDetail.put("item_code", (String)recordSet.get("item_code"+i));
							hmDetail.put("stock_item_yn","Y");   
							BaseAndIssueUOMQty=(HashMap)getBaseAndIssueUOMQty((String)recordSet.get("item_code"+i),  (String)recordSet.get("store_code"+i), (String)recordSet.get("actualReturn"+i),  (String)recordSet.get("uom_code"+i));
							hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY"));
							hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
							//hmDetail.put("item_qty",(String)recordSet.get("actualReturn"+i));
							hmDetail.put("uom_code",CommonBean.checkForNull((String)recordSet.get("uom_code"+i))); 
							hmDetail.put("remarks","");
							hmDetail.put("sales_doc_type_code",(String)recordSet.get("doc_type"+i));
							hmDetail.put("sal_doc_no",(String)recordSet.get("doc_no"+i)); 
							hmDetail.put("sal_doc_srl_no",(String)recordSet.get("sal_doc_srlno"+i)); 
							hmDetail.put("disp_bill_stage",disp_bill_stage);//added for KAUH-SCF-0320 
							hmDetail.put("sal_facility_id",(String)recordSet.get("Sal_Facility_id"+i));//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Setting Sale Facility to EJB.							
							dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);// added for skr-scf-0591
							if(dis_charge_ind.equals("D"))
								take_home_yn="Y";
							else
								take_home_yn="N";
							hmDetail.put("take_home_yn",take_home_yn);	// addeding end for skr-scf-0591
							if( !(getFacility_Flag().equals("Y"))){
								hmDetail.put("FACILITY_STR_FOR_BL",this.orderingfacilityid.trim()+"|"+(String)tabData.get( "FACILITY_ID" ));
							}
							else{
								hmDetail.put("FACILITY_STR_FOR_BL",(String)recordSet.get("Ord_Facility_id"+i)+"|"+(String)tabData.get( "FACILITY_ID" ));
							}
							if(bl_interface_yn.equals("Y") && datarr!=null && datarr.size()>0){
								
								pstmt_select1.setString(1,(String)datarr.get(0));
								pstmt_select1.setString(2,(String)datarr.get(2));
								pstmt_select1.setString(3,(String)tabData.get( "FACILITY_ID" ));
								rset	=	pstmt_select1.executeQuery();
								if(rset.next()){
									hmDetail.put("p_overridden_excl_incl_ind",checkForNull(rset.getString("BL_INCL_EXCL_OVERRIDE_VALUE")));
									hmDetail.put("p_overridden_action_reason",checkForNull(rset.getString("BL_INCL_EXCL_OVERRIDE_REASON")));
								} 
								closeResultSet( rset );				
							}
							hmDtlGrp.put(dtlKey, hmDetail); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
							/*if(hmDtlGrp.size()>0 || !hmDtlGrp.containsKey(dtlKey)){
								insertDetail = new ArrayList();
								insertDetail.add(hmDetail);
								hmDtlGrp.put(dtlKey, insertDetail);
							}
							else{
								insertDetail = new ArrayList((ArrayList)hmDtlGrp.get(dtlKey));
								insertDetail.add(hmDetail);
								hmDtlGrp.put(dtlKey, insertDetail);
							}*/
							//dtlKeyList.add(dtlKey);
							if(hmhdrDtlKeyMap.size()==0 || !hmhdrDtlKeyMap.containsKey(hdrKey)){
								dtlKeyList = new ArrayList();
								dtlKeyList.add(dtlKey);
								hmhdrDtlKeyMap.put(hdrKey, dtlKeyList);
							}
							else{
								dtlKeyList = new ArrayList((ArrayList)hmhdrDtlKeyMap.get(hdrKey));
								dtlKeyList.add(dtlKey);
								hmhdrDtlKeyMap.put(hdrKey, dtlKeyList);
							}
						}
						else{
							hmDetail = (HashMap)hmDtlGrp.get(dtlKey);
							//hmDetail = (HashMap)insertDetail.get(0);
							BaseAndIssueUOMQty=(HashMap)getBaseAndIssueUOMQty((String)recordSet.get("item_code"+i),  (String)recordSet.get("store_code"+i), (String)recordSet.get("actualReturn"+i),  (String)recordSet.get("uom_code"+i));
							tot_item_qty = Float.parseFloat(hmDetail.get("item_qty")==null?"0":(String)hmDetail.get("item_qty"));
							mm_trn_qty = Float.parseFloat(hmDetail.get("mm_trn_qty")==null?"0":(String)hmDetail.get("mm_trn_qty"));
							tot_item_qty += Float.parseFloat((BaseAndIssueUOMQty.get("ISSUE_QTY")==null?"0":(String)BaseAndIssueUOMQty.get("ISSUE_QTY")));
							mm_trn_qty += Float.parseFloat((BaseAndIssueUOMQty.get("BASE_QTY")==null?"0":(String)BaseAndIssueUOMQty.get("BASE_QTY")));
							hmDetail.put("item_qty",tot_item_qty+"");
							hmDetail.put("mm_trn_qty", mm_trn_qty+"");
							hmDtlGrp.put(dtlKey, hmDetail);
						}
						//hmhdrDtlKeyMap.put(hdrKey, dtlKeyList);
						//insertDetail.add(hmDetail);
						// added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
						/*if(insertDetailGrp.size()==0 || !insertDetailGrp.containsKey(dtlKey)){
							insertDetail= new ArrayList();
							insertDetail.add(hmDetail);
							insertDetailGrp.put(dtlKey,insertDetail );
						}
						else{
							insertDetail = new ArrayList((ArrayList)insertDetailGrp.get(dtlKey));
							insertDetail.add(hmDetail);
							insertDetailGrp.put(dtlKey,insertDetail);
						}*/
						// Batch Details
						//if(hmExpGrp.size()==0 || !hmExpGrp.containsKey(dtlKey)){ // ||!hmHeader.containsKey(hdrKey) added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
							hmExp			=	new HashMap();
							alSalBinLocationCode = new ArrayList();//added for KDAH-SCF-0252 [IN:050489] -start
							alSalBinLocationCode.add((String)recordSet.get("sal_bin_location_code"+i));
							alSalBinLocationCode.add((String)BaseAndIssueUOMQty.get("BASE_QTY"));//added for KDAH-SCF-0252 [IN:050489] -end
							//insertExp		=	new ArrayList();
							hmExp.put("facility_id",login_facility_id);
							hmExp.put("doc_type_code",this.getStockDocType());//(String)recordSet.get("doc_type"+i)
							hmExp.put("sales_doc_no",(String)recordSet.get("doc_no"+i));
							//hmExp.put("doc_srl_no",(String)recordSet.get("srlnobatch"+i));		
							hmExp.put("doc_srl_no",count+"");
							hmExp.put("store_code", (String)recordSet.get("store_code"+i));
							hmExp.put("item_code", (String)recordSet.get("item_code"+i));
							hmExp.put("batch_id",(String)recordSet.get("batch_id"+i));
							hmExp.put("trade_id",(String)recordSet.get("trade_id"+i));
							//hmExp.put("sal_bin_location_code",(String)recordSet.get("sal_bin_location_code"+i));//Commented for KDAH-SCF-0252 [IN:050489]
							hmExp.put("sal_bin_location_code",alSalBinLocationCode);//added for KDAH-SCF-0252 [IN:050489]
							hmExp.put("bin_location_code",(String)recordSet.get("bin_location_code"+i));
							hmExp.put("expiry_date_or_receipt_date",(String)recordSet.get("expiry_date"+i));
							BaseAndIssueUOMQty = (HashMap)getBaseAndIssueUOMQty((String)recordSet.get("item_code"+i),  (String)recordSet.get("store_code"+i), (String)recordSet.get("actualReturn"+i),  (String)recordSet.get("uom_code"+i));
							hmExp.put("ret_item_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
							//hmExp.put("ret_item_qty",(String)recordSet.get("actualReturn"+i));
							hmExp.put("sal_doc_type_code",(String)recordSet.get("doc_type"+i));
							hmExp.put("sal_doc_no",(String)recordSet.get("doc_no"+i));				
							hmExp.put("sal_doc_srl_no",(String)recordSet.get("sal_doc_srlno"+i));  //Added for SKR-SCF-0625 [35212]
							hmExp.put("sal_facility_id",(String)recordSet.get("Sal_Facility_id"+i));//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Setting Sale Facility to EJB.
							//hmExpGrp.put(dtlKey, hmExp); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
							
							dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);// added for skr-scf-0591
							if(dis_charge_ind.equals("D"))
								take_home_yn="Y";
							else
								take_home_yn="N";
							hmDetail.put("take_home_yn",take_home_yn); // addeding end for skr-scf-0591
						//}
						if(hmExpGrp.size()==0 || !hmExpGrp.containsKey(dtlKey)){
							insertExp = new ArrayList();
							insertExp.add(hmExp);
							hmExpGrp.put(dtlKey, insertExp);
						}
						else{
							insertExp = new ArrayList((ArrayList)hmExpGrp.get(dtlKey));
							insertExp.add(hmExp);
							hmExpGrp.put(dtlKey, insertExp);
						}
						//insertExp.add(hmExp);
					}
				}
				}
				else{
					enc_id = (String)recordSet.get("encounter_id"+i); // added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 //moved from down for AMRI-SCF-0376 [IN:055578]  -start
					if(enc_id.equals("")||enc_id.equals("11111")){
						 enc_id ="";
						 enc_patient_class="R";
					}
					if(!previousEncId.equals(enc_id)){
						if(bl_interface_yn.equals("Y")){// added for KDAH-SCF-0322
							try{
							getBillingUpdateLock(connection, login_facility_id, (String)tabData.get("PATIENT_ID"), enc_id);
							}catch(Exception e){
								map.put( "result", new Boolean( false ) ) ;	
								map.put( "message", e.getMessage() ) ;
								throw new Exception();
								
							}
							
						}
					}
					//Adding start for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508 
						 if(EncList.size()>0 && EncList.contains(enc_id) ){
							 bl_recal_flag="Y";
							 }else{
								 bl_recal_flag="N";
							 }
							if( bl_recal_flag.equals("N")){
							
					                pstmt_blflag = connection.prepareStatement("SELECT BL_CHK_PKG_PAT_RECALC_YN(?,?,?,?,?) RESULT_FLAG from dual");
									pstmt_blflag.setString(1,"PH");
									pstmt_blflag.setString(2,login_facility_id);
									pstmt_blflag.setString(3,(String)recordSet.get("patientid"));
									pstmt_blflag.setString(4,(String)recordSet.get("doc_type"+i));
									pstmt_blflag.setString(5,(String)recordSet.get("doc_no"+i)); 
									
									resultSet_blflag = pstmt_blflag.executeQuery() ;
												
									if(resultSet_blflag!=null && resultSet_blflag.next()){
										bl_result =resultSet_blflag.getString("RESULT_FLAG");
										
									}
                               if(bl_result.equals("Y")){
								   bl_recal_flag="Y";
									   EncList.add(enc_id);
									   orig_enc_patient_class  = getEncounterPatientClass(enc_id, (String)recordSet.get("patientid"));
									   if(EncListGroup.size()>0){
											String curr_enc=(String)EncListGroup.get(0);
											String visit_id="";
											String episode_id="";
											if(!orig_enc_patient_class.equals("I") && !orig_enc_patient_class.equals("D")){
												if (!enc_id.equals("") && !enc_id.equals(null)) {
													episode_id = enc_id.substring(0, (enc_id.length() - 4)); 
													visit_id = enc_id.substring(enc_id.length() - 4); 
												}
												}else{
													episode_id = enc_id;
													visit_id = "";
												}
											  EncListGroup.clear();
											  EncListGroup.add(curr_enc+"#"+orig_enc_patient_class+"~"+episode_id+"~"+visit_id);
										}else{
											String visit_id="";
											String episode_id="";
											if(!orig_enc_patient_class.equals("I") && !orig_enc_patient_class.equals("D")){
												if (!enc_id.equals("") && !enc_id.equals(null)) {
													episode_id = enc_id.substring(0, (enc_id.length() - 4)); 
													visit_id = enc_id.substring(enc_id.length() - 4); 
												}
												}else{
													episode_id = enc_id;
													visit_id = "";
												}
											   EncListGroup.add(orig_enc_patient_class+"~"+episode_id+"~"+visit_id);
											}
										
								}
						 }
							closeStatement(pstmt_blflag);
							closeResultSet(resultSet_blflag);
							//Adding end for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508 
					   
					previousEncId = enc_id;
					tabData.put( "PATIENT_CLASS",enc_patient_class);
					hdrKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i) ;
					dtlKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i)+recordSet.get("sal_doc_srlno"+i) ; //moved from down for AMRI-SCF-0376 [IN:055578]  -end
					datarr	=	new ArrayList();
					if( !((String)recordSet.get("actualReturn"+i)).equals("") && !((String)recordSet.get("actualReturn"+i)).equals("0") ) {
						//added for TBMC-SCF-0105 
						if( /*dis_charge_ind.equals("D")&&*/ retMedRestrStage==true  ){ //modified for TBMC-SCF-0161
							map.put( "result", new Boolean( false ) ) ;	
							map.put( "message", getMessage(getLanguageId(),"CANNOT_RETURN","PH"));
							throw new Exception();	
						}
						datarr.add((String)recordSet.get("dispno"+i)); //0
						datarr.add((String)recordSet.get("bin_location_code"+i));
						datarr.add((String)recordSet.get("srlno"+i));
						datarr.add((String)recordSet.get("srlnobatch"+i));
						datarr.add((String)recordSet.get("actualReturn"+i));
						datarr.add((String)recordSet.get("item_code"+i));
						datarr.add((String)recordSet.get("store_code"+i));
						
						datarr.add((String)recordSet.get("batch_id"+i));
						datarr.add((String)recordSet.get("expiry_date"+i));
						datarr.add((String)recordSet.get("disp_qty"+i));
						datarr.add((String)recordSet.get("uom_code"+i));
						datarr.add((String)recordSet.get("Sal_Facility_id"+i));//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Setting Sale Facility to EJB.
						datarr.add(hdrKey); //added for AMRI-SCF-0376 [IN:055578] //12
						datarr.add(dtlKey); //added for AMRI-SCF-0376 [IN:055578] //13
						datarr.add((String)recordSet.get("order_id"+i)); //Added for GHL-SCF-1084
						datarr.add((String)recordSet.get("order_line_no"+i)); //Added for GHL-SCF-1084
				
						tabData.put("RECORD"+i,datarr);
						count++;
						/*enc_id = (String)recordSet.get("encounter_id"+i); // added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
						if(enc_id.equals("")||enc_id.equals("11111")){
							 enc_id ="";
							 enc_patient_class="R";
						}
						tabData.put( "PATIENT_CLASS",enc_patient_class);
						hdrKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i) ;
						dtlKey = enc_id+recordSet.get("doc_type"+i)+recordSet.get("doc_no"+i)+recordSet.get("sal_doc_srlno"+i) ;*/
						// Header Detail
						if(hmHeader.size()==0 || !hmHeader.containsKey(hdrKey)){ // ||!hmHeader.containsKey(hdrKey) added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
							hmHeader_dtls	=	new HashMap();
							hmHeader_dtls.put("facility_id",login_facility_id);
							hmHeader_dtls.put("doc_type_code",this.getStockDocType());
							hmHeader_dtls.put("sal_doc_type_code",(String)recordSet.get("doc_type"+i));//Added for KDAH-SCF-0452
							hmHeader_dtls.put("sales_doc_no",(String)recordSet.get("doc_no"+i));
							hmHeader_dtls.put("doc_date",getCurrDate());
							hmHeader_dtls.put("doc_ref","");
							hmHeader_dtls.put("store_code",(String)recordSet.get("store_code"+i));
							hmHeader_dtls.put("patient_id",(String)recordSet.get("patientid"));
							//hmHeader_dtls.put("encounter_id",this.getEncounter());
							hmHeader_dtls.put("encounter_id",enc_id);
							hmHeader_dtls.put("finalized_yn","Y");
							hmHeader_dtls.put("gl_interfaced_yn","N");
							hmHeader_dtls.put("trn_type","SRT");
							hmHeader_dtls.put("remarks","");				
							hmHeader_dtls.put("item_class_code","");
							hmHeader_dtls.put("module_id","PH");

								tabData.put( "STORE_CODE",(String)recordSet.get("store_code"+i));	   
							   //if(bl_interface_yn.equals("Y")){
									 hmHeader_dtls.put("billable_trn_yn",bl_interface_yn);
									 hmHeader_dtls.put("sal_trn_type",enc_patient_class);
							   //}
								dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);//added for [IN:045323] MMS BETA ADHOC Testing -start
								if(dis_charge_ind.equals("D"))
									take_home_yn="Y";
								else
									take_home_yn="N";
								hmHeader_dtls.put("take_home_yn",take_home_yn);	//added for [IN:045323] MMS BETA ADHOC Testing -end
								hmHeader.put(hdrKey, hmHeader_dtls); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
							}
							// Item Detail
							if(hmDtlGrp.size()==0 || !hmDtlGrp.containsKey(dtlKey)){ // ||!hmHeader.containsKey(hdrKey) added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
								hmDetail		=	new HashMap();
								//insertDetail	=	new ArrayList();

								hmDetail.put("dtlKey",dtlKey); //added for AMRI-SCF-0376 [IN:055578]
								hmDetail.put("facility_id",login_facility_id);
								hmDetail.put("doc_type_code",this.getStockDocType()); // (String)recordSet.get("doc_type"+i)
								hmDetail.put("sales_doc_no",(String)recordSet.get("doc_no"+i));
								//hmDetail.put("doc_srl_no",(String)recordSet.get("srlnobatch"+i));
								hmDetail.put("doc_srl_no",count+"");
								hmDetail.put("item_code", (String)recordSet.get("item_code"+i));
								hmDetail.put("stock_item_yn","Y");   
								BaseAndIssueUOMQty=(HashMap)getBaseAndIssueUOMQty((String)recordSet.get("item_code"+i),  (String)recordSet.get("store_code"+i), (String)recordSet.get("actualReturn"+i),  (String)recordSet.get("uom_code"+i));
								hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY"));
								hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
								//hmDetail.put("item_qty",(String)recordSet.get("actualReturn"+i));
								hmDetail.put("uom_code",CommonBean.checkForNull((String)recordSet.get("uom_code"+i))); 
								hmDetail.put("remarks","");
								hmDetail.put("sales_doc_type_code",(String)recordSet.get("doc_type"+i));
								hmDetail.put("sal_doc_no",(String)recordSet.get("doc_no"+i)); 
								hmDetail.put("sal_doc_srl_no",(String)recordSet.get("sal_doc_srlno"+i)); 
								hmDetail.put("disp_bill_stage",disp_bill_stage); //added for KAUH-SCF-0320
								hmDetail.put("sal_facility_id",(String)recordSet.get("Sal_Facility_id"+i));//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Setting Sale Facility to EJB.							
								dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);// added for skr-scf-0591
								if(dis_charge_ind.equals("D"))
									take_home_yn="Y";
								else
									take_home_yn="N";
								hmDetail.put("take_home_yn",take_home_yn);	// addeding end for skr-scf-0591
								if( !(getFacility_Flag().equals("Y"))){
									hmDetail.put("FACILITY_STR_FOR_BL",this.orderingfacilityid.trim()+"|"+(String)tabData.get( "FACILITY_ID" ));
								}
								else{
									hmDetail.put("FACILITY_STR_FOR_BL",(String)recordSet.get("Ord_Facility_id"+i)+"|"+(String)tabData.get( "FACILITY_ID" ));
								}
								if(bl_interface_yn.equals("Y") && datarr!=null && datarr.size()>0){
									
									pstmt_select1.setString(1,(String)datarr.get(0));
									pstmt_select1.setString(2,(String)datarr.get(2));
									pstmt_select1.setString(3,(String)tabData.get( "FACILITY_ID" ));
									rset	=	pstmt_select1.executeQuery();
									if(rset.next()){
										hmDetail.put("p_overridden_excl_incl_ind",checkForNull(rset.getString("BL_INCL_EXCL_OVERRIDE_VALUE")));
										hmDetail.put("p_overridden_action_reason",checkForNull(rset.getString("BL_INCL_EXCL_OVERRIDE_REASON")));
									} 
									closeResultSet( rset );				
								}
								hmDtlGrp.put(dtlKey, hmDetail); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
								/*if(hmDtlGrp.size()>0 || !hmDtlGrp.containsKey(dtlKey)){
									insertDetail = new ArrayList();
									insertDetail.add(hmDetail);
									hmDtlGrp.put(dtlKey, insertDetail);
								}
								else{
									insertDetail = new ArrayList((ArrayList)hmDtlGrp.get(dtlKey));
									insertDetail.add(hmDetail);
									hmDtlGrp.put(dtlKey, insertDetail);
								}*/
								//dtlKeyList.add(dtlKey);
								if(hmhdrDtlKeyMap.size()==0 || !hmhdrDtlKeyMap.containsKey(hdrKey)){
									dtlKeyList = new ArrayList();
									dtlKeyList.add(dtlKey);
									hmhdrDtlKeyMap.put(hdrKey, dtlKeyList);
								}
								else{
									dtlKeyList = new ArrayList((ArrayList)hmhdrDtlKeyMap.get(hdrKey));
									dtlKeyList.add(dtlKey);
									hmhdrDtlKeyMap.put(hdrKey, dtlKeyList);
								}
							}
							else{
								hmDetail = (HashMap)hmDtlGrp.get(dtlKey);
								//hmDetail = (HashMap)insertDetail.get(0);
								BaseAndIssueUOMQty=(HashMap)getBaseAndIssueUOMQty((String)recordSet.get("item_code"+i),  (String)recordSet.get("store_code"+i), (String)recordSet.get("actualReturn"+i),  (String)recordSet.get("uom_code"+i));
								tot_item_qty = Float.parseFloat(hmDetail.get("item_qty")==null?"0":(String)hmDetail.get("item_qty"));
								mm_trn_qty = Float.parseFloat(hmDetail.get("mm_trn_qty")==null?"0":(String)hmDetail.get("mm_trn_qty"));
								tot_item_qty += Float.parseFloat((BaseAndIssueUOMQty.get("ISSUE_QTY")==null?"0":(String)BaseAndIssueUOMQty.get("ISSUE_QTY")));
								mm_trn_qty += Float.parseFloat((BaseAndIssueUOMQty.get("BASE_QTY")==null?"0":(String)BaseAndIssueUOMQty.get("BASE_QTY")));
								hmDetail.put("item_qty",tot_item_qty+"");
								hmDetail.put("mm_trn_qty", mm_trn_qty+"");
								hmDtlGrp.put(dtlKey, hmDetail);
							}
							//hmhdrDtlKeyMap.put(hdrKey, dtlKeyList);
							//insertDetail.add(hmDetail);
							// added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
							/*if(insertDetailGrp.size()==0 || !insertDetailGrp.containsKey(dtlKey)){
								insertDetail= new ArrayList();
								insertDetail.add(hmDetail);
								insertDetailGrp.put(dtlKey,insertDetail );
							}
							else{
								insertDetail = new ArrayList((ArrayList)insertDetailGrp.get(dtlKey));
								insertDetail.add(hmDetail);
								insertDetailGrp.put(dtlKey,insertDetail);
							}*/
							// Batch Details
							//if(hmExpGrp.size()==0 || !hmExpGrp.containsKey(dtlKey)){ // ||!hmHeader.containsKey(hdrKey) added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
								hmExp			=	new HashMap();
								alSalBinLocationCode = new ArrayList();//added for KDAH-SCF-0252 [IN:050489] -start
								alSalBinLocationCode.add((String)recordSet.get("sal_bin_location_code"+i));
								alSalBinLocationCode.add((String)BaseAndIssueUOMQty.get("BASE_QTY"));//added for KDAH-SCF-0252 [IN:050489] -end
								//insertExp		=	new ArrayList();
								hmExp.put("facility_id",login_facility_id);
								hmExp.put("doc_type_code",this.getStockDocType());//(String)recordSet.get("doc_type"+i)
								hmExp.put("sales_doc_no",(String)recordSet.get("doc_no"+i));
								//hmExp.put("doc_srl_no",(String)recordSet.get("srlnobatch"+i));		
								hmExp.put("doc_srl_no",count+"");
								hmExp.put("store_code", (String)recordSet.get("store_code"+i));
								hmExp.put("item_code", (String)recordSet.get("item_code"+i));
								hmExp.put("batch_id",(String)recordSet.get("batch_id"+i));
								hmExp.put("trade_id",(String)recordSet.get("trade_id"+i));
								//hmExp.put("sal_bin_location_code",(String)recordSet.get("sal_bin_location_code"+i));//Commented for KDAH-SCF-0252 [IN:050489]
								hmExp.put("sal_bin_location_code",alSalBinLocationCode);//added for KDAH-SCF-0252 [IN:050489]
								hmExp.put("bin_location_code",(String)recordSet.get("bin_location_code"+i));
								hmExp.put("expiry_date_or_receipt_date",(String)recordSet.get("expiry_date"+i));
								BaseAndIssueUOMQty = (HashMap)getBaseAndIssueUOMQty((String)recordSet.get("item_code"+i),  (String)recordSet.get("store_code"+i), (String)recordSet.get("actualReturn"+i),  (String)recordSet.get("uom_code"+i));
								hmExp.put("ret_item_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
								//hmExp.put("ret_item_qty",(String)recordSet.get("actualReturn"+i));
								hmExp.put("sal_doc_type_code",(String)recordSet.get("doc_type"+i));
								hmExp.put("sal_doc_no",(String)recordSet.get("doc_no"+i));				
								hmExp.put("sal_doc_srl_no",(String)recordSet.get("sal_doc_srlno"+i));  //Added for SKR-SCF-0625 [35212]
								hmExp.put("sal_facility_id",(String)recordSet.get("Sal_Facility_id"+i));//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Setting Sale Facility to EJB.
								//hmExpGrp.put(dtlKey, hmExp); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
								
								dis_charge_ind=(String)recordSet.get("dis_charge_ind"+i);// added for skr-scf-0591
								if(dis_charge_ind.equals("D"))
									take_home_yn="Y";
								else
									take_home_yn="N";
								hmDetail.put("take_home_yn",take_home_yn); // addeding end for skr-scf-0591
							//}
							if(hmExpGrp.size()==0 || !hmExpGrp.containsKey(dtlKey)){
								insertExp = new ArrayList();
								insertExp.add(hmExp);
								hmExpGrp.put(dtlKey, insertExp);
							}
							else{
								insertExp = new ArrayList((ArrayList)hmExpGrp.get(dtlKey));
								insertExp.add(hmExp);
								hmExpGrp.put(dtlKey, insertExp);
							}
							//insertExp.add(hmExp);
					
						}
			}
			}
				hdrKeyList = new ArrayList(hmHeader.keySet());
				for(int encCount=0; encCount<hdrKeyList.size(); encCount++){ //ENCOUNTER BASED HEADER FOR LOOP added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
					hdrKey = (String) hdrKeyList.get(encCount);
					//insertDetail = new ArrayList();
					tmpInsertExp = new ArrayList();
					dtlKeyList = (ArrayList)hmhdrDtlKeyMap.get(hdrKey);
					for(int dtlindx=0; dtlindx < dtlKeyList.size(); dtlindx++){
						hmDetail = new HashMap();
						hmExp = new HashMap();
						hmDetail = (HashMap)hmDtlGrp.get(dtlKeyList.get(dtlindx));
						tmpInsertExp = (ArrayList)hmExpGrp.get(dtlKeyList.get(dtlindx));
						hmDetail.put("doc_srl_no",(dtlindx+1)+"");
						//hmExp.put("doc_srl_no",(dtlindx+1)+"");
					/*	for(int i=0; i < insertDetail.size();i++){
							hmDetail = new HashMap();
							hmDetail= (HashMap)insertDetail.get(i);
							hmDetail.put("doc_srl_no",(dtlindx+1)+"");
							//insertDetail.add(hmDetail);
						}*/
						for(int i=0;i< tmpInsertExp.size(); i++){
							hmExp = new HashMap();
							hmExp = (HashMap)tmpInsertExp.get(i);
							hmExp= (HashMap)tmpInsertExp.get(i);
							hmExp.put("doc_srl_no",(dtlindx+1)+"");
							//insertExp.set(i,hmExp);
							if(insertExpGrp.size()==0 || !insertExpGrp.containsKey(hdrKey)){
								insertExp = new ArrayList();
								insertExp.add(hmExp);
								insertExpGrp.put(hdrKey, insertExp);
							}
							else{
								insertExp = new ArrayList((ArrayList)insertExpGrp.get(hdrKey));
								insertExp.add(hmExp);
								insertExpGrp.put(hdrKey, insertExp);
							}
						}
					//}
						if(insertDetailGrp.size()==0 || !insertDetailGrp.containsKey(hdrKey)){
							insertDetail = new ArrayList();
							insertDetail.add(hmDetail);
							insertDetailGrp.put(hdrKey, insertDetail);
						}
						else{
							insertDetail = new ArrayList((ArrayList)insertDetailGrp.get(hdrKey));
							insertDetail.add(hmDetail);
							insertDetailGrp.put(hdrKey, insertDetail);
						}
					}
				}
				tot_values.add(hmHeader);
				tot_values.add(insertDetailGrp);
				tot_values.add(insertExpGrp);
				tabData.put( "STOCK_VALS", tot_values);
				tabData.put( "ENCLISTGROUP", EncListGroup);//Added for KDAH-SCF-0452
			}//END IF
			tabData.put( "BARCODE_TOTALROWS", selectedRows); // Added for GHL-CRF-0413.8
			tabData.put( "BARCODE_FLAG", recordSet.get("barcodeFlag")); // Added for GHL-CRF-0413.8
			//sqlMap.put("SQLUPDATE1", PhRepository.getPhKeyValue( "SQL_PH_RET_MEDN_UPDATE1" ) );
			sqlMap.put("SQL_PH_RET_MEDN_GET_BAL_QTY", "SELECT  sum( RETURNED_QTY)  TOT_RTN_QTY FROM PH_DISP_DRUG_BATCH WHERE FACILITY_ID=? AND DISP_NO=? AND SRL_NO=? AND SRL_NO_BATCH=?  "); //Added for SRR-SCF20056-7701 @ Siriraj War Room UAT5
			sqlMap.put("SQLUPDATE1", "UPDATE PH_DISP_DRUG_BATCH SET RETURNED_QTY=NVL(RETURNED_QTY,0)+NVL(?,0),RTN_BIN_LOCATION_CODE=?,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ? , MODIFIED_FACILITY_ID = ? ,RET_TO_DISP_LOCN_CODE =? WHERE DISP_NO=? AND SRL_NO=? AND SRL_NO_BATCH=? AND FACILITY_ID=?");
			sqlMap.put("SQLUPDATE2", PhRepository.getPhKeyValue( "SQL_PH_RET_MEDN_UPDATE2" ) );
			sqlMap.put("SQL_PH_RET_MEDN_UPDATE3", PhRepository.getPhKeyValue( "SQL_PH_RET_MEDN_UPDATE3" ) );
			sqlMap.put("SQL_PH_RET_MEDN_INSERT1", PhRepository.getPhKeyValue( "SQL_PH_RET_MEDN_INSERT1" ) );
			sqlMap.put("SQL_PH_RET_MEDN_SELECT10", PhRepository.getPhKeyValue( "SQL_PH_RET_MEDN_SELECT10" ) );
			sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES",PhRepository.getPhKeyValue( "SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES"));
			sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_SELECT15",PhRepository.getPhKeyValue( "SQL_PH_REG_PRESCRIPTIONS_SELECT15"));
				 
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_ReturnMedication" ),ReturnMedicationHome.class,getLocalEJB());
			Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] =new Object[2];
			argArray[0]= tabData;
			argArray[1]=sqlMap;
			Class  paramArray[] = new Class[2];
			paramArray[0]= tabData.getClass();
			paramArray[1] = sqlMap.getClass();
			map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) map.get( "result")).booleanValue() )	{
				map.put( "result", new Boolean(true)) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"PH") ) ;
				map.put( "flag", (String) map.get( "flag") ) ;
				this.rtn_medn_no=(String) map.get( "rtn_medn_no");
				//Added for GHL-SCF-1193 Start
				setRetnMednNo(rtn_medn_no);
				//Added for GHL-SCF-1193 End
				if(bl_interface_yn.equals("Y")&& !enc_patient_class.equals("I")&& !enc_patient_class.equals("D")){
					setBLDetails((ArrayList) map.get( "bl_det"));
				}
			}
			else{	
				map.put( "message", (String)map.get("msgid") ) ;
			}
		}
		catch (Exception e){
			System.err.println("Error in Return medicatoin Bean tabData="+tabData+"\n recordSet="+recordSet);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( rset );				
				closeStatement( pstmt_select1 ) ;
				closeConnection( connection );	

			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map;
	 }

	public String getSysdate(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date				= "";
		try{
			connection				= getConnection() ;
			//String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			String str_qry			= "SELECT to_char(SYSDATE,'dd/mm/yyyy') SYS_DATE from dual";
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
						sys_date	=	resultSet.getString("SYS_DATE");
				}
		}catch ( Exception e ) {
				sys_date+=e.toString();
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
		return sys_date;
	}


	public void getTokenSeries(String patCat) { // Parameter patCat added for SRR20056-SCF-7639 ICN027720
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
    	token_series_code	        =   "";
		disp_cash_coll_stage        =	"";

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT73B") ) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.Login_disp_locn_code);
			pstmt.setString(3,login_at_ws_no);
			pstmt.setString(4,getLanguageId());
			resultSet	= pstmt.executeQuery();
			while( resultSet != null && resultSet.next() ) {
				//token_series_desc   =   checkForNull(resultSet.getString("DESCRIPTION"));
				token_series_code     =   checkForNull(resultSet.getString("TOKEN_SERIES_CODE"));
				if(patCat!=null && patCat.equals("O"))  //if block and else condition added for SRR20056-SCF-7639 ICN027720
					disp_cash_coll_stage  =   checkForNull(resultSet.getString("DISP_CASH_COLL_STAGE_OP"));
				else
					disp_cash_coll_stage  =   checkForNull(resultSet.getString("DISP_CASH_COLL_STAGE"));
				setDispCashCollStage(disp_cash_coll_stage);
				if(disp_cash_coll_stage.equals("D")||disp_cash_coll_stage.equals("X")){
					token_series_code ="";
				}
			}	
			setTokenSeriesCode(token_series_code);
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
	}

	private String getBillingDetails(Connection connection,String login_facility_id,String Store_code,String doc_type_code,String doc_no,String login_by_id,String login_at_ws_no,String patient_id ,String encounter_id ){
	  
              HashMap message_bill  =   new HashMap();
	     	  String p_charge_amt   =   "99999";
 
	          String msg            =   "";
              String	hmResult	=	"";
			  CallableStatement callableStatement = null;
			  StringBuffer gross_charge_display_str  = new StringBuffer();
			   String sal_trn_type ="";
		  
		  try{
			    sal_trn_type=getEncounterPatientClass(encounter_id, patient_id); //patient_id added for [IN:035667] 
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
				callableStatement.setString(17,  "N");
				callableStatement.setString(19,  login_facility_id); //added for MOHE-CRF-0060
				callableStatement.registerOutParameter(18, Types.VARCHAR);
				callableStatement.execute();

			    /*message_bill.put("l_slmt_reqd_yn" , checkForNull((String)callableStatement.getString(10)));
			    message_bill.put("l_bill_doc_type" , checkForNull((String)callableStatement.getString(11)));
			    message_bill.put("l_bill_doc_num" , checkForNull((String)callableStatement.getString(12)));
                message_bill.put("v_blng_group_id" , checkForNull((String)callableStatement.getString(13)));
			    message_bill.put("error_id" , checkForNull((String)callableStatement.getString(14)));
			    message_bill.put("error_id_txt" , checkForNull((String)callableStatement.getString(15)));
			   */
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
					throw new Exception(msg +"  -   doc_no:" + doc_no);
				}		
			}
			catch(Exception ex)	{
				ex.printStackTrace();
			}
			finally{
				try{
				closeStatement(callableStatement);
				}
				catch(Exception es){es.printStackTrace();}
			    callableStatement = null;				
		    }
		       /* hmResult.put("l_bill_doc_num",(String)message_bill.get("l_bill_doc_num"));
				hmResult.put("l_bill_doc_type",(String)message_bill.get("l_bill_doc_type"));
				hmResult.put("l_slmt_reqd_yn",(String)message_bill.get("l_slmt_reqd_yn"));
	            hmResult.put("v_blng_group_id",(String)message_bill.get("v_blng_group_id"));
		*/
	 
		//    	gross_charge_display_str.append((String)message_bill.get("l_bill_doc_num")).append(",").append((String)message_bill.get("l_bill_doc_type")).append(",").append((String)message_bill.get("v_blng_group_id")).append(",").append((String)message_bill.get("error_id_txt"));
		gross_charge_display_str.append((String)message_bill.get("l_bill_doc_num")).append(",").append((String)message_bill.get("l_bill_doc_type")).append(",").append((String)message_bill.get("v_blng_group_id")).append(",").append((String)message_bill.get("p_call_disc_function_yn")).append(",").append((String)message_bill.get("l_slmt_reqd_yn")).append(",").append(doc_type_code+"-"+doc_no).append(",").append(patient_id).append(",").append(encounter_id).append(",").append(sal_trn_type).append(",").append((String)message_bill.get("error_id_txt"));
	 
		hmResult = gross_charge_display_str.toString();

		return hmResult;	
   }

	public  String checkPharmacist(){
		//	CHECK WHETHER LOGGED-IN USER IS PHARMACIST OR NOT.
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		try{
			connection	= getConnection() ;
            pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT3") ) ;
			pstmt.setString(1,login_by_id.trim());
            resultSet = pstmt.executeQuery() ;
			if ( resultSet.next() ) {
				return "Y" ;
			}
		
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			return e.toString();
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
		return "N";
	}

	public  String checkRights(){
		//		CHECK WHETHER LOGGED-IN USER has dispense rights for ip or for op
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		try{
			connection	= getConnection() ;
            pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT9") ) ;
			pstmt.setString(1,login_by_id.trim());
            resultSet = pstmt.executeQuery() ;
			if ( resultSet.next() ) {
				return "Y" ;
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			return e.toString();
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
		return "N";
	}

	public  String checkOR(){
		//CHECK WHETHER OR MODULE IS INSTALLED OR NOT.

		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		try{
			connection	= getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT2") ) ;
			resultSet = pstmt.executeQuery() ;
			if ( resultSet.next() ) {
				return "Y" ;
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			return e.toString();
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
		return "N";
	}


	public ArrayList getDispLocn(String Category,String locale){
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		ArrayList result=new ArrayList();
	   StringBuffer sql						 = new StringBuffer();
	  
        try {
            connection = getConnection() ;
			//	To get the dispense locations associated with the user
			sql.append(PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT2"));
			if (Category.equals("I")){
				sql.append(" AND a.ip_allow_drug_return_yn='Y' and  b.IP_ACCEPT_MEDN_RTN_YN ='Y'");
			}
			else if (Category.equals("O")){
				sql.append(" AND a.allow_drug_return_yn='Y' and b.ACCEPT_MEDN_RTN_YN ='Y'");
			}
			pstmt= connection.prepareStatement(  sql.toString()) ;
			pstmt.setString(1,Category);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,login_by_id.trim());
			pstmt.setString(4,login_at_ws_no.trim());
			pstmt.setString(5,locale);

            resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("DISP_LOCN_CODE"));
				result.add(resultSet.getString("SHORT_DESC"));
			}
		}
		catch ( Exception e ) {
			result.add(e.toString());
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

	public ArrayList getUserDetails(){
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		 ArrayList result=new ArrayList();
        try {
            connection = getConnection() ;

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT1") ) ;
			pstmt.setString(1,login_by_id.trim());
            resultSet = pstmt.executeQuery() ;
            if ( resultSet.next() ) {
				this.user_name=resultSet.getString("APPL_USER_NAME");
				this.password=resultSet.getString("PASSWORD");
				result.add(this.user_name);
				result.add(this.password);
				result.add(login_by_id);
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

 	/*getting BinLocation details  */

	public ArrayList getBinDetails(String drugcodes,String displocn,String locale){       	    
   		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		HashMap records=null;
		ArrayList result=new ArrayList();
        try {
            connection = getConnection() ;

			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT1") ) ;
			pstmt = connection.prepareStatement("SELECT b.bin_location_code, b.short_desc,(CASE WHEN (a.item_code = c.item_code AND a.store_code = c.store_code AND a.bin_location_code = c.bin_location_code) THEN 'Y' ELSE 'N' END) default_yn  FROM st_item_store_bin_locn a, mm_bin_location_lang_vw b, st_item_store c WHERE a.item_code = ? AND a.store_code = ? AND a.eff_status = 'Y' AND a.store_code = b.store_code AND a.bin_location_code = b.bin_location_code AND a.item_code = c.item_code AND a.store_code = c.store_code AND b.language_id = ?") ;
			pstmt.setString(1,drugcodes.trim());
			pstmt.setString(2,displocn.trim());
			pstmt.setString(3,locale.trim());
            resultSet = pstmt.executeQuery() ;
            while (resultSet.next()) {
				records=new HashMap();
				records.put("bin_location_code",checkForNull(resultSet.getString("bin_location_code")));			
				records.put("short_desc",checkForNull(resultSet.getString("short_desc")));
				records.put("Default_YN",checkForNull(resultSet.getString("Default_YN")));
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
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList getDrugDetails(String patientid,String drugcode,String nationalid,String healthcard,String dispno,String cutoff,String orderid,String displocn,String patcat, String encounter_id, String locale,String medn_rtn_after_bill_gen, String blDocType, String blDocNo, String disploc){ //code 'String medn_rtn_after_bill_gen added for FD-JD-CRF-0178[IN039208] // String blDocType, String blDocNo added for MMS-DM-CRF-0039 [IN:055958] //disploc added for SKR-SCF-1551
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
        ResultSet resultSet1		= null; //Added for SKR-SCF-1551
		StringBuffer sbsql	= new StringBuffer(); //changed to StringBuffer MMS-DM-CRF-0039 [IN:055958] -SQL Tuning
		String sbsql1 = ""; //Added for SKR-SCF-1551
		int count = 0; //Added for SKR-SCF-1551
		PreparedStatement pstmt1	= null; //Added for SKR-SCF-1551
		String store_code = disploc; //Added for SKR-SCF-1551
		String ackWC="";//Added for GHL-CRF-0399.2
		ArrayList result=new ArrayList();
		int cnt	=	1;
		String oldpatcat = patcat;
		String ack_required = checkToProceed(login_facility_id.trim());//added for mms-kh-crf-0014
        try {
            connection = getConnection() ;
           // boolean siteAck = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","WARD_ACK"); // Added for GHL-CRF-0399.2
            
			if (getEffstatus().equals("D")) {
				//String sql=PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT5") ;
				// fix for SRR20056-SCF-7414, Incident No. 27456start
				if(patcat!=null && patcat.equalsIgnoreCase("O")){
					patcat = "'OP', 'EM', 'XT'";
				}
				else if (patcat!=null && patcat.equalsIgnoreCase("I") ){
					patcat = "'IP', 'DC'";
					if(ack_required.equals("Y")){//siteAck changed to ack_required for mms-kh-crf-0014
						ackWC="and f.ward_acknowledge = 'A'";
					}
				}
				// fix for SRR20056-SCF-7414, Incident No. 27456 end

				if(!getFacility_Flag().equals("Y")){//, mp_patient c REMOVED FOR KDAH-ICN-0007
					sbsql.append(" SELECT DISTINCT disp_drug_code, d.drug_desc,(select SHORT_NAME from am_trade_name_lang_vw where trade_id=f.trade_id and language_id=?) TRADE_NAME FROM (SELECT drug_desc drug_desc, drug_code drug_code ,content_in_pres_base_uom content_in_pres_base_uom,STOCK_UOM,PRES_BASE_UOM  FROM ph_drug_lang_vw WHERE drug_code BETWEEN NVL ('', '%%') AND NVL ('',drug_code) AND language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc,tpn_regimen_code drug_code,nvl(content_in_base_unit,1) content_in_pres_base_uom,NULL,NULL FROM ph_tpn_regimen_lang_vw   WHERE tpn_regimen_code BETWEEN NVL ('', '%%') AND NVL ('', tpn_regimen_code) and standard_regimen_yn = 'Y' and language_id = ?) d,ph_disp_dtl a, ph_disp_hdr b,ph_disp_drug_batch F, st_item y ");//drug_code BETWEEN NVL ('', '%%') AND NVL ('',drug_code) AND  added for performance tunning //,ST_ITEM Y added for ML-BRU-SCF-2236
					if(medn_rtn_after_bill_gen.equals("N")) //code added for FD-JD-CRF-0178[IN039208]
						sbsql.append(" , BL_PATIENT_CHARGES_INTERFACE g, BL_PATIENT_CHARGES_FOLIO folio");				
					
					//AND c.patient_id = b.patient_id removed for KDAH-ICN-0007
					sbsql.append(" WHERE a.facility_id = b.facility_id AND a.disp_no = b.disp_no   AND b.patient_id = ?  and b.order_id  in (select order_id from or_order where patient_id=? and NVL(iv_prep_yn,'X') not in('2','4','6','8','0') and order_category ='PH' AND ordering_facility_id = ? ) "+ackWC+" "); //(select SHORT_NAME from am_trade_name_lang_vw where trade_id=f.trade_id and language_id=?) TRADE_NAME added for  AMS-SCF-0190 IN038440 && ',BL_PATIENT_CHARGES_FOLIO' added for FD-JD-CRF-0178[IN039208]
				 
					if(oldpatcat!=null && oldpatcat.equalsIgnoreCase("O"))  // Only for outpatient cutoff date AMS-CRF-0172
						sbsql.append(" AND a.added_date >=  TO_DATE (?, 'dd/mm/yyyy hh24:mi') ");
					sbsql.append(" AND a.disp_drug_code = d.drug_code AND a.facility_id = ? AND b.order_id = NVL (?, b.order_id) AND a.disp_no = NVL (?, a.disp_no) AND a.disp_drug_code = NVL (?, a.disp_drug_code)AND a.disp_locn_code = NVL (?, a.disp_locn_code) AND  (select sum(disp_qty) from ph_disp_dtl where  order_id = a.order_id and order_line_no = a.order_line_no) > (NVL ((SELECT SUM (returned_qty) FROM ph_disp_dtl WHERE  order_id = a.order_id AND order_line_no = a.order_line_no), 0) + Ceil(NVL((select TOT_ADMINISTERED_QTY from ph_patient_drug_profile where patient_id = b.patient_id and orig_order_id = a.order_id and orig_order_line_no =a.order_line_no),0)/decode(d.content_in_pres_base_uom,1,NVL ((SELECT EQVL_VALUE FROM AM_UOM_EQVL WHERE UOM_CODE = D.PRES_BASE_UOM AND EQVL_UOM_CODE = D.STOCK_UOM),1),d.content_in_pres_base_uom ))+ NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = b.disp_no AND srl_no = f.srl_no AND srl_no_batch = f.srl_no_batch AND disp_no BETWEEN NVL ('', '%%') AND NVL ('', disp_no)), 0 ) + NVL ((SELECT SUM (returned_qty) FROM ph_ward_return_dtl WHERE  disp_no = b.disp_no and srl_no = f.srl_no AND srl_no_batch = f.srl_no_batch AND store_acknowledge_status IS NULL AND disp_no BETWEEN NVL ('', '%%') AND NVL ('', disp_no)), 0 )) ");
					
					//AND EXISTS (  SELECT * FROM ph_disp_drug_batch X, ST_ITEM Y  WHERE disp_no = a.disp_no AND ((( use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR( use_after_expiry_yn = 'N' AND EXPIRY_YN='N')) or  (USE_AFTER_EXPIRY_YN ='Y') ) AND X.ITEM_CODE =Y.ITEM_CODE  AND facility_id = a.facility_id AND srl_no = a.srl_no) // Removed this ML-BRU-SCF-2236

					sbsql.append(" AND f.disp_no = a.disp_no AND f.srl_no = a.srl_no AND f.item_code = y.item_code AND   (   (   (    y.use_after_expiry_yn = 'N' 	   AND SYSDATE < f.expiry_date ) OR (    y.use_after_expiry_yn = 'N' AND y.expiry_yn = 'N' ) ) OR (y.use_after_expiry_yn = 'Y') )"); 	//added for ML-BRU-SCF-2236 

					sbsql.append(" AND b.patient_class in (?) AND f.facility_id=a.facility_id AND f.DISP_LOCN_CODE=a.disp_locn_code AND f.disp_no=a.disp_no AND f.srl_no=a.srl_no  "); 	//a.disp_qty replaced with  (select sum(disp_qty) from ph_disp_dtl where order_id = a.order_id and order_line_no = a.order_line_no)    a.returned_qty replaced with (SELECT SUM (returned_qty) FROM ph_disp_dtl WHERE order_id = a.order_id AND order_line_no = a.order_line_no) && 'order by d.drug_desc"'code removed for FD-JD-CRF-0178[IN039208] //IN050139 sum(disp_qty) & SUM (returned_qty) calulcation changed from ph_disp_dtl to ph_disp_drug_batch//AND disp_no BETWEEN NVL ('', '%%') AND NVL ('', disp_no) added for performance tuning //  FROM ph_disp_dtl WHERE order_id = a.order_id AND order_line_no = a.order_line_no changed to 'from ph_disp_drug_batch where DISP_NO = a.DISP_NO and SRL_NO = a.SRL_NO' for ML-BRU-SCF-1880 
					//disp_no = a.DISP_NO AND removed for SKR-SCF-1241 NVL condtion added for SKR-SCF-1251 AND TBMC-SCF-0077
					//sql += " AND a.disp_drug_code = d.drug_code AND a.facility_id = ? AND b.order_id = NVL (?, b.order_id) AND a.disp_no = NVL (?, a.disp_no) AND a.disp_drug_code = NVL (?, a.disp_drug_code) AND a.disp_locn_code = NVL (?, a.disp_locn_code) AND  (select sum(disp_qty) from ph_disp_drug_batch where facility_id = a.facility_id     AND disp_no = a.disp_no AND srl_no = a.srl_no) > (NVL ((SELECT SUM (returned_qty) FROM ph_disp_drug_batch where facility_id = a.facility_id     AND disp_no = a.disp_no AND srl_no = a.srl_no), 0) + Ceil(NVL((select TOT_ADMINISTERED_QTY from ph_patient_drug_profile where patient_id = b.patient_id and orig_order_id = a.order_id and orig_order_line_no =a.order_line_no),0)/D.CONTENT_IN_PRES_BASE_UOM)+ NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = f.disp_no AND srl_no = f.srl_no AND srl_no_batch = f.srl_no_batch AND disp_no BETWEEN NVL ('', '%%') AND NVL ('', disp_no)), 0 ) + NVL ((SELECT SUM (returned_qty) FROM ph_ward_return_dtl WHERE disp_no = f.disp_no AND srl_no = f.srl_no AND srl_no_batch = f.srl_no_batch AND store_acknowledge_status IS NULL AND disp_no BETWEEN NVL ('', '%%') AND NVL ('', disp_no)), 0 )) AND EXISTS (  SELECT * FROM ph_disp_drug_batch X, ST_ITEM Y  WHERE disp_no = a.disp_no  AND (( USE_AFTER_EXPIRY_YN ='N' and SYSDATE < expiry_date) or  (USE_AFTER_EXPIRY_YN ='Y') ) AND X.ITEM_CODE =Y.ITEM_CODE  AND facility_id = a.facility_id   AND srl_no = a.srl_no) AND b.ENCOUNTER_ID =  NVL (?, b.ENCOUNTER_ID)  and b.patient_class in (?) AND f.facility_id=a.facility_id AND f.DISP_LOCN_CODE=a.disp_locn_code AND f.disp_no=a.disp_no AND f.srl_no=a.srl_no  "; 
					//disp_no = a.DISP_NO AND added for ML-BRU-SCF-1913					
						//select sum(disp_qty) from ph_disp_drug_batch to select sum(disp_qty) from ph_disp_dtl for KAUH-SCF-0322
					//disp_no = a.DISP_NO  REMOVED FOR SKR-SCF-1212
					//decode(d.content_in_pres_base_uom,1,(SELECT EQVL_VALUE FROM AM_UOM_EQVL WHERE UOM_CODE = D.PRES_BASE_UOM AND EQVL_UOM_CODE = D.STOCK_UOM)d.content_in_pres_base_uom ) added for skr-scf-1212d.content_in_pres_base_uom added for SKR-SCF-1236
					//OR( use_after_expiry_yn = 'N' AND EXPIRY_YN='N') added for SKR-SCF-1256
				}
				else if(getFacility_Flag().equals("Y")){//, mp_patient c REMOVED FOR KDAH-ICN-0007
					sbsql.append( " SELECT DISTINCT disp_drug_code, d.drug_desc,(select SHORT_NAME from am_trade_name_lang_vw where trade_id=f.trade_id and language_id=?) TRADE_NAME FROM (SELECT drug_desc drug_desc, drug_code drug_code ,content_in_pres_base_uom content_in_pres_base_uom,STOCK_UOM,PRES_BASE_UOM  FROM ph_drug_lang_vw WHERE drug_code BETWEEN NVL ('', '%%') AND NVL ('',drug_code) AND language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc,tpn_regimen_code drug_code,nvl(content_in_base_unit,1) content_in_pres_base_uom,NULL,NULL FROM ph_tpn_regimen_lang_vw   WHERE tpn_regimen_code BETWEEN NVL ('', '%%') AND NVL ('', tpn_regimen_code) and standard_regimen_yn = 'Y' and language_id = ?) d,ph_disp_dtl a, ph_disp_hdr b,ph_disp_drug_batch F, st_item y ");//drug_code BETWEEN NVL ('', '%%') AND NVL ('',drug_code)  added for performance tuning   //,ST_ITEM Y added for ML-BRU-SCF-2236
					if(medn_rtn_after_bill_gen.equals("N")) //code added for FD-JD-CRF-0178[IN039208]
						sbsql.append(", BL_PATIENT_CHARGES_INTERFACE g, BL_PATIENT_CHARGES_FOLIO folio ");
					//AND c.patient_id = b.patient_id  REMOVED FOR KDAH-ICN-0007	
					sbsql.append(" WHERE a.disp_no = b.disp_no   AND b.patient_id = ?  and b.order_id  in (select order_id from or_order where patient_id=? and NVL(iv_prep_yn,'X') not in('2','4','6','8','0') and order_category ='PH' )"+ackWC+" ");  //(select SHORT_NAME from am_trade_name_lang_vw where trade_id=f.trade_id and language_id=?) TRADE_NAME added for AMS-SCF-0190 IN038440 && ',BL_PATIENT_CHARGES_FOLIO' added for FD-JD-CRF-0178[IN039208] // "+ackWC+" added for GHL-CRF-0399.2;

					if (oldpatcat != null && oldpatcat.equalsIgnoreCase("O")) // Only for outpatient cutoff date AMS-CRF-0172
						sbsql.append(" AND a.added_date >=  TO_DATE (?, 'dd/mm/yyyy hh24:mi') ");
					sbsql.append(" AND a.disp_drug_code = d.drug_code AND b.order_id = NVL (?, b.order_id) AND a.disp_no = NVL (?, a.disp_no) AND a.disp_drug_code = NVL (?, a.disp_drug_code) AND  (select sum(disp_qty) from ph_disp_dtl where  order_id = a.order_id and order_line_no = a.order_line_no) > (NVL ((SELECT SUM (returned_qty) FROM ph_disp_dtl WHERE order_id = a.order_id AND order_line_no = a.order_line_no), 0) + Ceil(NVL((select TOT_ADMINISTERED_QTY from ph_patient_drug_profile where patient_id = b.patient_id and orig_order_id = a.order_id and orig_order_line_no =a.order_line_no),0)/decode(d.content_in_pres_base_uom,1,NVL ((SELECT EQVL_VALUE FROM AM_UOM_EQVL WHERE UOM_CODE = D.PRES_BASE_UOM AND EQVL_UOM_CODE = D.STOCK_UOM),1),d.content_in_pres_base_uom )) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = f.srl_no AND srl_no_batch = f.srl_no_batch AND disp_no BETWEEN NVL ('', '%%') AND NVL ('', disp_no)), 0 ) + NVL ((SELECT SUM (returned_qty) FROM ph_ward_return_dtl WHERE disp_no = b.disp_no AND srl_no = f.srl_no AND srl_no_batch = f.srl_no_batch AND store_acknowledge_status IS NULL AND disp_no BETWEEN NVL ('', '%%') AND NVL ('', disp_no)), 0 )) ");
					//AND EXISTS (  SELECT * FROM ph_disp_drug_batch X, ST_ITEM Y  WHERE disp_no = a.disp_no  AND (( ( use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR( use_after_expiry_yn = 'N' AND EXPIRY_YN='N')) or  (USE_AFTER_EXPIRY_YN ='Y') ) AND X.ITEM_CODE =Y.ITEM_CODE  AND srl_no = a.srl_no) ";  // Removed this ML-BRU-SCF-2236

					sbsql.append(" AND f.disp_no = a.disp_no AND f.srl_no = a.srl_no AND f.item_code = y.item_code AND   (   (   (    y.use_after_expiry_yn = 'N' 	   AND SYSDATE < f.expiry_date ) OR (    y.use_after_expiry_yn = 'N' AND y.expiry_yn = 'N' ) ) OR (y.use_after_expiry_yn = 'Y') )"); 	//added for ML-BRU-SCF-2236 

				
					sbsql.append(" and b.patient_class in (?) AND f.facility_id=a.facility_id AND f.DISP_LOCN_CODE=a.disp_locn_code AND f.disp_no=a.disp_no AND f.srl_no=a.srl_no  "); //a.disp_qty replaced with  (select sum(disp_qty) from ph_disp_dtl where order_id = a.order_id and order_line_no = a.order_line_no)   a.returned_qty replaced with (SELECT SUM (returned_qty) FROM ph_disp_dtl WHERE order_id = a.order_id AND order_line_no = a.order_line_no) && 'order by d.drug_desc"'code removed for FD-JD-CRF-0178[IN039208] //  FROM ph_disp_dtl WHERE order_id = a.order_id AND order_line_no = a.order_line_no changed to 'from ph_disp_drug_batch where DISP_NO = a.DISP_NO and SRL_NO = a.SRL_NO' for ML-BRU-SCF-1880 
					//disp_no = a.DISP_NO AND  REMOVED FOR SKR-SCF-1241 NVL condtion added for SKR-SCF-1251 AND TBMC-SCF-0077
					//sql += " AND a.disp_drug_code = d.drug_code AND b.order_id = NVL (?, b.order_id) AND a.disp_no = NVL (?, a.disp_no) AND a.disp_drug_code = NVL (?, a.disp_drug_code) AND  (select sum(disp_qty) from ph_disp_drug_batch where facility_id = a.facility_id     AND disp_no = a.disp_no AND srl_no = a.srl_no AND facility_id BETWEEN NVL ('', '%%') AND NVL ('', facility_id)) > (NVL ((SELECT SUM (returned_qty) FROM ph_disp_drug_batch where facility_id = a.facility_id     AND disp_no = a.disp_no AND srl_no = a.srl_no), 0) + Ceil(NVL((select TOT_ADMINISTERED_QTY from ph_patient_drug_profile where patient_id = b.patient_id and orig_order_id = a.order_id and orig_order_line_no =a.order_line_no),0)/D.CONTENT_IN_PRES_BASE_UOM) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = f.srl_no AND srl_no_batch = f.srl_no_batch), 0 ) + NVL ((SELECT SUM (returned_qty) FROM ph_ward_return_dtl WHERE disp_no = f.disp_no AND srl_no = f.srl_no AND srl_no_batch = f.srl_no_batch AND store_acknowledge_status IS NULL), 0 )) AND EXISTS (  SELECT * FROM ph_disp_drug_batch X, ST_ITEM Y  WHERE disp_no = a.disp_no  AND (( USE_AFTER_EXPIRY_YN ='N' and SYSDATE < expiry_date) or  (USE_AFTER_EXPIRY_YN ='Y') ) AND X.ITEM_CODE =Y.ITEM_CODE  AND srl_no = a.srl_no) AND b.ENCOUNTER_ID =  NVL (?, b.ENCOUNTER_ID)  and b.patient_class in (?) AND f.facility_id=a.facility_id AND f.DISP_LOCN_CODE=a.disp_locn_code AND f.disp_no=a.disp_no AND f.srl_no=a.srl_no  "; 
					//disp_no = a.DISP_NO AND added for ML-BRU-SCF-1913
					//DISP_NO = a.DISP_NO and removed for skr-scf-1212
					///decode(d.content_in_pres_base_uom,1,(SELECT EQVL_VALUE FROM AM_UOM_EQVL WHERE UOM_CODE = D.PRES_BASE_UOM AND EQVL_UOM_CODE = D.STOCK_UOM)d.content_in_pres_base_uom )added for skr-scf-1212d.content_in_pres_base_uom added for SKR-SCF-1236
					//OR( use_after_expiry_yn = 'N' AND EXPIRY_YN='N') added for SKR-SCF-1256
				} 
				//a.disp_qty <> NVL (a.returned_qty, 0) AND (select sum (disp_qty) from ph_disp_dtl where  order_id = a.order_id  AND order_line_no = a.order_line_no) > Ceil(NVL((select TOT_ADMINISTERED_QTY from ph_patient_drug_profile where patient_id = b.patient_id and orig_order_id = a.order_id and orig_order_line_no =a.order_line_no),0)/D.CONTENT_IN_PRES_BASE_UOM) ----REPLACED WITH---- a.disp_qty > (NVL (a.returned_qty, 0) + Ceil(NVL((select TOT_ADMINISTERED_QTY from ph_patient_drug_profile where patient_id = b.patient_id and orig_order_id = a.order_id and orig_order_line_no =a.order_line_no),0)/D.CONTENT_IN_PRES_BASE_UOM)) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = f.srl_no AND srl_no_batch = f.srl_no_batch), 0 ) + NVL ((SELECT SUM (returned_qty) FROM ph_ward_return_dtl WHERE disp_no = f.disp_no AND srl_no = f.srl_no AND srl_no_batch = f.srl_no_batch AND store_acknowledge_status IS NULL), 0 )) for SKR-SCF-0628
				//select sum(disp_qty) from ph_disp_drug_batch to select sum(disp_qty) from ph_disp_dtl for KAUH-SCF-0322 
				String sql = sbsql.toString();
				int index = sql.lastIndexOf('?');
				sql = sql.substring(0, index) + patcat + sql.substring(index + 1);	
				sbsql.delete(0, sbsql.length()); //added for SQL Tuning
				sbsql.append(sql); //added for SQL Tuning
				if(encounter_id!= null && !encounter_id.equals(""))//if condition added for SQL Tuning
					sbsql.append(" AND b.ENCOUNTER_ID = ? ");
				if(blDocType!=null && !blDocType.equals("") && blDocNo!=null && !blDocNo.equals("")) //if block added for MMS-DM-CRF-0039 [IN:055958]
					sbsql.append(" and (b.doc_type || '-'|| b.doc_no) in ( select PRIMARY_KEY_MAIN from bl_patient_charges_folio where PRIMARY_KEY_MODULE_ID = 'PH' and patient_id = ? and BILL_DOC_TYPE_CODE = ? and BILL_DOC_NUM = ?  ) ");
				if(!getDispTranSeqNo().equals(""))//added for MMS-QH-CRF-0201 [IN:052255] 
					sbsql.append("AND a.PRINT_SEQ_NO = ? ");
				else if(!getDirectDispTranSeqNo().equals(""))
					sbsql.append("AND b.DISP_TRN_SEQ_NO = ? ");
				if(medn_rtn_after_bill_gen.equals("N"))  //code added for FD-JD-CRF-0178[IN039208] --Start AND c.patient_id = g.patient_id REMOVED FOR KDAH ICN-0007
					sbsql.append(" AND a.facility_id = g.operating_facility_id AND g.OPERATING_FACILITY_ID = folio.OPERATING_FACILITY_ID AND g.TRX_DOC_REF = folio.TRX_DOC_REF AND g.TRX_DOC_REF_LINE_NUM = folio.TRX_DOC_REF_LINE_NUM AND g.PRIMARY_KEY_MODULE_ID ='PH' AND g.PRIMARY_KEY_MAIN = b.DOC_TYPE || '-'|| b.DOC_NO AND g.PRIMARY_KEY_LINE_NO like a.DOC_SRL_NO||'%' AND folio.bill_doc_type_code IS NULL AND folio.bill_doc_num IS NULL AND NVL(folio.TRX_STATUS,'X')<>'C' AND b.facility_id BETWEEN NVL ('', '%%') AND NVL ('',b.facility_id) order by d.drug_desc "); // g.PRIMARY_KEY_LINE_NO = a.DOC_SRL_NO changed to g.PRIMARY_KEY_LINE_NO like a.DOC_SRL_NO||'%' for KAUH-SCF-192 [IN:048909] //AND b.facility_id BETWEEN NVL ('', '%%') AND NVL ('',b.facility_id) added for performance tunning
				else 
					sbsql.append(" AND b.facility_id BETWEEN NVL ('', '%%') AND NVL ('',b.facility_id) order by d.drug_desc");	//code added for FD-JD-CRF-0178[IN039208] -- Start 
				pstmt = connection.prepareStatement(sbsql.toString());
				pstmt.setString(cnt, locale); // 1
				pstmt.setString(++cnt, locale); // 1
				pstmt.setString(++cnt, locale); // 2
				pstmt.setString(++cnt, patientid.trim()); // 3
				pstmt.setString(++cnt, patientid.trim()); // 4
				if(!getFacility_Flag().equals("Y")){
					pstmt.setString(++cnt, this.orderingfacilityid.trim()); // 5
				}
				// pstmt.setString(6,patcat);
				if (oldpatcat != null && oldpatcat.equalsIgnoreCase("O")) // Only for outpatient cutoff date AMS-CRF-0172 (condition based)
					pstmt.setString(++cnt, cutoff); // 6
				if(!getFacility_Flag().equals("Y")){
					pstmt.setString(++cnt, login_facility_id.trim());
				}
				pstmt.setString(++cnt, orderid.trim());
				pstmt.setString(++cnt, dispno.trim());
				pstmt.setString(++cnt, drugcode.trim());
				if(!getFacility_Flag().equals("Y")){
					pstmt.setString(++cnt, displocn.trim());
				}
				if(encounter_id!= null && !encounter_id.equals(""))//if condition added for SQL Tuning - NVL removed
	    			pstmt.setString(++cnt,encounter_id.trim());   //AMS-CRF-0172 - encounter id added
				if(blDocType!=null && !blDocType.equals("") && blDocNo!=null && !blDocNo.equals("")){//if block added for MMS-DM-CRF-0039 [IN:055958]
					pstmt.setString(++cnt, patientid.trim());
					pstmt.setString(++cnt, blDocType); 
					pstmt.setString(++cnt, blDocNo); 
				}
				if(!getDispTranSeqNo().equals(""))//added for MMS-QH-CRF-0201 [IN:052255] 
					pstmt.setString(++cnt, getDispTranSeqNo());
				else if(!getDirectDispTranSeqNo().equals(""))
					pstmt.setString(++cnt, getDirectDispTranSeqNo());
   			/*if (patcat.equals("O")){
    				pstmt.setString(10,displocn.trim());
    			}
    			else{
    			 	pstmt.setString(10,"");
    			}*/    			
                resultSet = pstmt.executeQuery() ;

                sbsql1 = "SELECT COUNT(*) FROM ST_ITEM_STORE WHERE  STORE_CODE=? AND ITEM_CODE=?  AND EFF_STATUS = 'E' "; //Added for SKR-SCF-1551
                pstmt1 = connection.prepareStatement(sbsql1); //Added for SKR-SCF-1551
                
                while ( resultSet.next() ) {
                	//Added for SKR-SCF-1551
                	 pstmt1.setString(1,store_code);
					 pstmt1.setString(2,resultSet.getString("DISP_DRUG_CODE"));
                     
                     resultSet1 = pstmt1.executeQuery() ;
                     
     				if(resultSet1!=null && resultSet1.next()){
     					count=resultSet1.getInt(1);
     				} //Added for SKR-SCF-1551
     				
                	if(count>0){
    				result.add(resultSet.getString("DISP_DRUG_CODE"));
    				result.add(resultSet.getString("DRUG_DESC"));
    				result.add(resultSet.getString("TRADE_NAME"));
    				}
					closeResultSet( resultSet1 ) ;
    				
    			}
            }//FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility - End
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			System.err.println("============sql====>"+sbsql.toString());
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ; //Added for SKR-SCF-1551
				closeStatement( pstmt1 ) ; //Added for SKR-SCF-1551
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace(); 
			}
		}
		return result;
	}


	public String getPatientIDLength(){

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
		}catch(Exception e){
				pat_txt_length	=e.toString();
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
		return pat_txt_length;	
	}

	public boolean checkReissued(String disp_no){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	reissue_reas	=	null ;
		boolean result			=	false;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT11") ) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,disp_no);
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				reissue_reas	=	checkForNull(resultSet.getString("REISSUE_REASON_CODE"));
			}		
			
			if(reissue_reas!=null && !reissue_reas.equals(""))
				result		=	true;

		}catch(Exception e){
				reissue_reas	=e.toString();
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
		return result;	
	}

	public ArrayList getBatchDetailsReport(String patient_id,String disp_no,String facility_id,String from,String to)throws Exception{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
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
		int cnt	=	1;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT7A"));
            pstmt.setString(cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,patient_id.trim() );
			//pstmt.setString(++cnt,this.getCutOff()); //Commented for AMS-SCF-0146 IN[o34475]
			pstmt.setString(++cnt,facility_id.trim());
			pstmt.setString(++cnt,"");
			pstmt.setString(++cnt,disp_no.trim());
		 	pstmt.setString(++cnt,"");

			resultSet = pstmt.executeQuery() ;
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
				if(i <= end ) {
					records.add(checkForNull(resultSet.getString("DRUG_DESC")));   
					records.add(checkForNull(resultSet.getString("BATCH_ID")));    
					records.add(checkForNull(resultSet.getString("EXPIRY_DATE"))); 
					records.add(checkForNull(resultSet.getString("DISP_NO")));     
					records.add(checkForNull(resultSet.getString("ADDED_DATE")));  
					records.add(checkForNull(resultSet.getString("srl_no")));   
					records.add(checkForNull(resultSet.getString("RTN_MEDN_NO")));   
					records.add(checkForNull(resultSet.getString("RETURNED_DATE")));   
					//records.add(checkForNull(resultSet.getString("RETURNEDQTY"))); 
				}
			}
			if( start != 1 )
					prevnextlink =prevnextlink+ "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(disp_no)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink =prevnextlink+ "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(disp_no)+"')\">Next</a>" ;
				
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;
	}
//String barcode,String barcodeFlag added for GHL-CRF-0413.8
	public ArrayList getBatchDetails(String patientid,String drugcodes,String nationalid,String healthcard,String dispno,String cutoff,String orderid,String displocn,String patcat,String toStore, String encounter_id,String FacilityFlag, String blDocType, String blDocNo,String barcode,String barcodeFlag){ //FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility . Added facilityflag for Multifacility  //String blDocType, String blDocNo added for MMS-DM-CRF-0039 [IN:055958]
		// encounter id parameter added for  AMS-CRF-0172  
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		PreparedStatement pstmt1= null;
		PreparedStatement pstmt2= null;//ADDED FOR GHL-CRF-0482
        ResultSet resultSet1	= null;
        ResultSet resultSet2	= null;
		String doc_srl_no       =""; 
		
		ArrayList result		= new ArrayList();
		HashMap bat_admin_qty  = new HashMap();
		int tot_admin_qty		=	0; 
		int returnable         =   0;
		int admin_qty		   = 0;//Added for GHL-CRF-0482
		String oldpatcat = patcat;
		String iv_prep_yn = ""; //GHL-CRF-0482
		String barcode_id = ""; //SKR-SCF-1574
		newBarcodeArry.clear();//added for SKR-SCF-1277
		try {	
			// setDispLocnCode(displocn);
			getTokenSeries(patcat); // patcat added for SRR20056-SCF-7639 ICN027720 -start
			setBillingParams(toStore, patcat); //added for SRR20056-SCF-7639 ICN027720 -start
			connection = getConnection() ;
			boolean isSite_spec_patient_stock = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","PATIENT_STOCK_REQUIRED"); // Added for GHL-CRF-0482
			//String sql=PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT7") ;
			//Modified i.SHORT_NAME as PRACTITIONER_NAME regardng incident num:26239==By sandhya==03/FEB/2011
			//String sql=" SELECT d.drug_desc,DECODE (j.use_after_expiry_yn,'Y', 'Y','N', DECODE (GREATEST (SYSDATE, expiry_date),SYSDATE, 'N','Y')) valid,c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code,a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,a.trade_id trade_id, a.disp_no,a.facility_id facility_id,a.srl_no, b.doc_srl_no, a.srl_no_batch,TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date, a.disp_qty issuedqty,b.disp_uom_code qtyuom,a.disp_qty- (  NVL (a.returned_qty, 0)+ NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch),0)+ NVL ((SELECT SUM (returned_qty)FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch AND store_acknowledge_status IS NULL),0)) returnable,NVL (  a.returned_qty+ NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch),0),0) returnedqty,c.encounter_id, b.order_id, b.order_line_no, b.issue_qty,b.issue_uom_code,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = b.issue_uom_code AND language_id = ?) short_desc,g.short_desc disp_locn_name, h.order_line_status order_line_staus,h.can_line_reason dis_cont_reason,TO_CHAR (h.disc_date_time, 'dd/mm/yyyy hh24:mi') disc_date_time,i.practitioner_name pract_name,(SELECT def_issue_uom def_issue_uom FROM st_item_store WHERE eff_status = 'E' AND item_code = a.item_code AND store_code = ?) to_store_def_issue_uom, b.facility_id RETURN_FACILITY FROM (SELECT drug_desc drug_desc, drug_code drug_code,NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom FROM ph_drug_lang_vw WHERE language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc,tpn_regimen_code drug_code, NVL (content_in_base_unit, 1) content_in_pres_base_uom FROM ph_tpn_regimen_lang_vw WHERE standard_regimen_yn = 'Y' AND language_id = ?) d,ph_disp_drug_batch a,ph_disp_dtl b,ph_disp_hdr c,mp_patient e,ph_disp_locn_lang_vw g,or_order_line h,am_practitioner_lang_vw i,st_item j,st_sal_hdr k, st_item_store s WHERE  k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.patient_id = e.patient_id AND a.store_code = s.store_code AND a.item_code = s.item_code AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND e.patient_id = ? "; //and k.FINALIZED_YN = 'Y' removed for AMS-SCF-0042 IN[30932] & SKR-SCF-0359 IN[30057] //Commented and tuned as below sql for  [IN:031364]
			//String sql=" SELECT d.drug_desc, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date, a.trade_id trade_id, a.disp_no, a.facility_id facility_id, a.srl_no, b.doc_srl_no, a.srl_no_batch, TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date, a.disp_qty issuedqty, b.disp_uom_code qtyuom, a.disp_qty - ( NVL (a.returned_qty, 0) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ) + NVL ((SELECT SUM (returned_qty) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch AND store_acknowledge_status IS NULL), 0 ) ) returnable, NVL ( a.returned_qty + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ) , 0 ) returnedqty, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = b.issue_uom_code AND language_id = ?) short_desc, (select short_desc from ph_disp_locn_lang_vw where disp_locn_code= s.store_code AND language_id = ? ) disp_locn_name, h.order_line_status order_line_staus, h.can_line_reason dis_cont_reason, TO_CHAR (h.disc_date_time, 'dd/mm/yyyy hh24:mi') disc_date_time, (SELECT def_issue_uom def_issue_uom FROM st_item_store WHERE eff_status = 'E' AND item_code = a.item_code AND store_code = ?) to_store_def_issue_uom, am_get_desc.AM_PRACTITIONER(disc_pract_id,?,1) pract_name,  b.facility_id return_facility FROM (SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom FROM ph_drug_lang_vw WHERE language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, NVL (content_in_base_unit, 1) content_in_pres_base_uom FROM ph_tpn_regimen_lang_vw WHERE standard_regimen_yn = 'Y' AND language_id = ? ) d, ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, mp_patient e, or_order_line h, st_item j, st_sal_hdr k, st_item_store s WHERE k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = a.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.patient_id = e.patient_id AND a.store_code = s.store_code AND a.item_code = s.item_code AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND e.patient_id = ?  "; //and k.FINALIZED_YN = 'Y' removed for AMS-SCF-0042 IN[30932] & SKR-SCF-0359 IN[30057]  //Added - tuned as above sql for  [IN:031364]
			//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Added b.facility_id column for Multi Facility.
		// barcode_id_app Added for ICN 73622 start
		/* Removed for ICN 73625 start	
		String barcode_id_app="";
			if(barcodeFlag.equals("Y") && !barcode.equals("")){
				barcode_id_app=",st_batch_control st ";
			}
			else{
				barcode_id_app="";
			}
			 Removed for ICN 73625 end	*/
			// String barcode_id_app=",st_batch_control st "; //Added for ICN 73622 //Commented for common-icn-0048
			//Added for ICN 73622  end
				// barcode_id_app Added for ICN 73622 start
				//(CASE WHEN (use_after_expiry_yn = 'N' AND EXPIRY_YN='N') then 'Y' WHEN greatest (sysdate, expiry_date) = sysdate then 'N'ELSE 'Y' END )) valid changed for SKR-SCF-1256
			StringBuffer	sbsql = new StringBuffer("SELECT d.drug_desc,(SELECT short_name FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?) trade_name,DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', (CASE WHEN (use_after_expiry_yn = 'N' AND expiry_yn = 'N') THEN 'Y' WHEN GREATEST (SYSDATE, expiry_date) = SYSDATE  THEN 'N' ELSE 'Y' END ) ) valid,c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code,  a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date, a.trade_id trade_id, a.disp_no, a.facility_id facility_id, a.srl_no, b.doc_srl_no, a.srl_no_batch, TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date, a.disp_qty issuedqty,b.disp_uom_code qtyuom, a.disp_qty - (  NVL (a.returned_qty, 0) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ) + NVL ((SELECT SUM (returned_qty) FROM ph_ward_return_dtl WHERE disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch  AND store_acknowledge_status IS NULL), 0 ) ) returnable, NVL (  a.returned_qty  + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl  WHERE disp_no = b.disp_no  AND srl_no = a.srl_no  AND srl_no_batch = a.srl_no_batch), 0 ), 0 ) returnedqty, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code,(SELECT short_desc  FROM am_uom_lang_vw  WHERE uom_code = b.issue_uom_code  AND language_id = ?) short_desc,(SELECT short_desc  FROM ph_disp_locn_lang_vw  WHERE disp_locn_code = c.disp_locn_code AND language_id = ?) disp_locn_name, h.order_line_status order_line_staus, h.can_line_reason dis_cont_reason, TO_CHAR (h.disc_date_time, 'dd/mm/yyyy hh24:mi') disc_date_time,(SELECT def_issue_uom def_issue_uom  FROM st_item_store WHERE eff_status = 'E' AND item_code = a.item_code AND store_code = ?) to_store_def_issue_uom,/* am_get_desc.am_practitioner (disc_pract_id, ?, 1) pract_name,*/ (SELECT long_name FROM am_practitioner_lang_vw  WHERE practitioner_id = disc_pract_id AND language_id = ?) pract_name,ord.ordering_facility_id, b.facility_id return_facility, ord.discharge_ind, '' barcode_id, a.disp_qty_uom, iv_prep_yn FROM (SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom FROM ph_drug_lang_vw  WHERE language_id = ?  UNION SELECT NVL (short_name, long_name) drug_desc,tpn_regimen_code drug_code, NVL (content_in_base_unit, 1) content_in_pres_base_uom FROM ph_tpn_regimen_lang_vw WHERE standard_regimen_yn = 'Y' AND language_id = ?) d, ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, /* mp_patient e,*/ or_order_line h, st_item j, /*st_sal_hdr k, */ st_item_store s, or_order ord WHERE h.order_id = ord.order_id  /*AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type  AND k.facility_id = a.facility_id */  AND a.facility_id = b.facility_id  AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no /* AND c.patient_id = e.patient_id */  AND a.store_code = s.store_code AND a.item_code = s.item_code AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND c.patient_id = ?  "); //and k.FINALIZED_YN = 'Y' removed for AMS-SCF-0042 IN[30932] & SKR-SCF-0359 IN[30057]  //Added - tuned as above sql for  [IN:031364] added ord.DISCHARGE_IND for skr-scf0591//disp_no = a.disp_no changed to disp_no = b.disp_no for GHL-SCF-1084 and iv_prep_yn added for GHL-CRF-0482
	//a.DISP_QTY_UOM added for ML-BRU-SCF-1842		
			if(oldpatcat!=null && oldpatcat.equalsIgnoreCase("O"))  // Only for outpatient cutoff date AMS-CRF-0172 (condition based)
				sbsql.append( " AND a.added_date >= TO_DATE (?, 'dd/mm/yyyy hh24:mi') ");
			
			if(orderid!=null && !orderid.equals("") ) 
				sbsql.append(" AND c.order_id = ? ");
			if(dispno!=null && !dispno.equals(""))
					sbsql.append(" AND a.disp_no = ? ");
			//((( use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR( use_after_expiry_yn = 'N' AND EXPIRY_YN='N')) or  (USE_AFTER_EXPIRY_YN ='Y') )modied for skr-scf-1256
			sbsql.append(" AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND((( use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR( use_after_expiry_yn = 'N' AND EXPIRY_YN='N')) or  (USE_AFTER_EXPIRY_YN ='Y') ) AND h.order_id = b.order_id AND h.order_line_num = b.order_line_no  ");
			if(encounter_id!= null && !encounter_id.equals(""))
				sbsql.append(" AND c.encounter_id = ? ");
			sbsql.append("  AND c.patient_class IN (?) ");
					
			String sql2="select  sum((CASE WHEN c.DOSAGE_TYPE ='S' THEN ceil((sum(b.ADMIN_DOSAGE_QTY)/d.STRENGTH_VALUE)/d.CONTENT_IN_PRES_BASE_UOM ) ELSE ceil(sum(b.ADMIN_DOSAGE_QTY)/d.CONTENT_IN_PRES_BASE_UOM) END )) tot_admin_qty from ph_medn_admin a ,ph_medn_admin_dtl b,or_order_line_ph c ,(SELECT drug_desc drug_desc, drug_code drug_code,NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom,strength_value  FROM ph_drug_lang_vw  WHERE language_id = ? and drug_code = ? UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code,   NVL (content_in_base_unit, 1) content_in_pres_base_uom,1 strength_value FROM ph_tpn_regimen_lang_vw WHERE standard_regimen_yn = 'Y' AND language_id = ? and TPN_REGIMEN_CODE =? ) d where   a.ENCOUNTER_ID=b.ENCOUNTER_ID AND a.facility_id = b.facility_id and a.ORD_DRUG_CODE=b.ORD_DRUG_CODE  and a.sch_date_time = b.sch_date_time and a.order_id=b.order_id  and a.DOSAGE_SEQ_NO =b.DOSAGE_SEQ_NO and a.order_id=? and a. ORDER_LINE_NUM =?   and a.order_id =c.order_id  and a.ORDER_LINE_NUM  =c.ORDER_LINE_NUM and a.ADMIN_RECORDED_YN ='Y' and b.item_code=? and BATCH_ID =?and EXPIRY_DATE=to_date(?,'dd/mm/yyyy')  and TRADE_ID =?  and b.ADMIN_DRUG_CODE =d.drug_code  group by BATCH_ID, EXPIRY_DATE, TRADE_ID ,b.ADMIN_DOSAGE_QTY ,c.DOSAGE_TYPE,d.STRENGTH_VALUE, d.CONTENT_IN_PRES_BASE_UOM ";
			//AND a.facility_id = b.facility_id added for performance
			String sql3 = "SELECT   SUM ((CASE WHEN (SELECT dosage_type FROM or_order_line_ph WHERE order_id = b.order_id AND ROWNUM <= 1) = 'S' THEN CEIL (  ((b.admin_dosage_qty) / d.strength_value) / d.content_in_pres_base_uom ) ELSE CEIL ((b.admin_dosage_qty) / d.content_in_pres_base_uom) END ) ) tot_admin_qty  FROM ph_medn_admin_dtl b,(SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom, strength_value FROM ph_drug_lang_vw WHERE language_id = ? AND drug_code = ?) d WHERE b.batch_order_id =? AND batch_id = ? AND expiry_date = TO_DATE (?, 'dd/mm/yyyy') AND b.item_code = ? AND b.admin_drug_code = d.drug_code GROUP BY batch_id, expiry_date, trade_id, b.admin_dosage_qty, d.strength_value, d.content_in_pres_base_uom"; //added for GHL-CRF-0482
		
		   String doc_srl_no_sql="select doc_srl_no from  st_sal_dtl_exp  where doc_type_code =? AND doc_no=? AND store_code = ? AND item_code = ? AND batch_id = ? and expiry_date_or_receipt_date = TO_DATE(?,'DD/MM/YYYY HH24:MI') AND bin_location_code =? AND trade_id =?";

		   pstmt1= connection.prepareStatement( sql2) ;
			//added for GHL-CRF-0482
		   if(isSite_spec_patient_stock){
	   		   pstmt2= connection.prepareStatement( sql3) ;
		   }
			
			StringTokenizer drugCodeToken = new StringTokenizer(drugcodes, ",");
			int drugcounter=drugCodeToken.countTokens();

			String appendString="";
			int tokencount=0;
			if (drugcounter==1)	{
				sbsql.append(" and  B.DISP_DRUG_CODE="+drugCodeToken.nextToken());
			}
			else{
				while (drugCodeToken.hasMoreTokens()){
					if (tokencount==0){
						appendString=appendString+" and ( B.DISP_DRUG_CODE="+drugCodeToken.nextToken()+" ";
						tokencount=1;
					}
					else{
						appendString=appendString+" or  B.DISP_DRUG_CODE="+drugCodeToken.nextToken()+" ";
					}
				}
				if(appendString.length()>0)//BSP-SCF-0089
				appendString=appendString+")";
				sbsql.append(appendString);
			}

			int cnt	=	1;
			
//		 fix for SRR20056-SCF-7414, Incident No. 27456 -start
			if (patcat.equals("O"))	{
				patcat = " 'OP', 'EM', 'XT'";
			}
			else if (patcat.equals("I")){
				patcat= " 'IP', 'DC'";
			}
			else{
				patcat = " 'XT' ";
			}
			String sql = sbsql.toString();
			int index	 =	sql.lastIndexOf('?');
			sql = sql.substring(0,index)+ patcat +sql.substring(index+1);
//		 fix for SRR20056-SCF-7414, Incident No. 27456 -end
			sbsql.delete(0, sbsql.length());
			sbsql.append(sql);
			if(blDocType!=null && !blDocType.equals("") && blDocNo!=null && !blDocNo.equals(""))//added for MMS-DM-CRF-0039 [IN:055958]
				sbsql.append(" and (c.doc_type || '-'|| c.doc_no) in ( select PRIMARY_KEY_MAIN from bl_patient_charges_folio where PRIMARY_KEY_MODULE_ID = 'PH' and patient_id = ? and BILL_DOC_TYPE_CODE = ? and BILL_DOC_NUM = ? ) ");
		//  Added for ICN 73622 start
		//	if(barcodeFlag.equals("Y") && !barcode.equals("")){ removed for ICN 73622
			//sbsql.append(" and st.item_code =a.item_code and st.batch_id=a.batch_id and st.EXPIRY_DATE_OR_RECEIPT_DATE=a.EXPIRY_DATE");
			//}Added for ICN 73622
			//  Added for ICN 73622 end
			sbsql.append(" order by d.drug_desc , a.disp_no");
          System.err.println("sbsql.toString() for ReturnMedication batch details=============="+sbsql.toString());
			pstmt = connection.prepareStatement( sbsql.toString()) ;
			pstmt.setString(cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId()); //added forAMS-SCF-0190 IN038440.
			pstmt.setString(++cnt,getLanguageId()); //added for [IN:031364] - tuned sql
			pstmt.setString(++cnt,toStore.trim());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId()); //added  for [IN:031364] - tuned sql
			pstmt.setString(++cnt,patientid.trim());

			if(oldpatcat!=null && oldpatcat.equalsIgnoreCase("O"))  // Only for outpatient cutoff date AMS-CRF-0172 (condition based)
				pstmt.setString(++cnt,cutoff);	
			
			if(orderid!=null && !orderid.equals("") )
				pstmt.setString(++cnt,orderid.trim());
			if(dispno!=null && !dispno.equals(""))
				pstmt.setString(++cnt,dispno.trim());
			
			//pstmt.setString(++cnt,getLanguageId()); //commented  for [IN:031364] - tuned sql
			//pstmt.setString(++cnt,getLanguageId());	//commented  for [IN:031364] - tuned sql
			if(encounter_id!= null && !encounter_id.equals(""))
				pstmt.setString(++cnt,encounter_id.trim());   //AMS-CRF-0172 - encounter id added
			if(blDocType!=null && !blDocType.equals("") && blDocNo!=null && !blDocNo.equals("")){ //added for MMS-DM-CRF-0039 [IN:055958]
				pstmt.setString(++cnt, patientid.trim());
				pstmt.setString(++cnt, blDocType); 
				pstmt.setString(++cnt, blDocNo); 
				
			}//Added for ICN 73622
		//  Added for ICN 73622 start
						if(barcodeFlag.equals("Y") && !barcode.equals("")){
							pstmt.setString(++cnt, barcode); 
						}
							//  Added for ICN 73622 end
			//Added for GHL-CRF-0413.8 Start
			resultSet = pstmt.executeQuery() ;
			//removed for ICN 73622
		//	if(barcodeFlag.equals("Y") && !barcode.equals("")){
	//			result=newBarcodeArry;
		//	}
			//Added for GHL-CRF-0413.8 end
			while ( resultSet.next() ) {
				result.add(resultSet.getString("DRUG_DESC"));	//1
				result.add(resultSet.getString("BATCH_ID"));
				result.add(resultSet.getString("EXPIRY_DATE"));
				result.add(resultSet.getString("DISP_NO"));
				result.add(resultSet.getString("ADDED_DATE"));	//5
				result.add(resultSet.getString("ISSUEDQTY"));
				result.add(resultSet.getString("QTYUOM"));
				result.add(resultSet.getString("RETURNEDQTY"));
				result.add(resultSet.getString("RETURNABLE"));
				result.add(resultSet.getString("SRL_NO"));	//10
				result.add(resultSet.getString("SRL_NO_BATCH"));
				result.add(resultSet.getString("VALID"));
				result.add(resultSet.getString("DOC_TYPE"));
				result.add(resultSet.getString("DOC_NO"));
				result.add(resultSet.getString("STORE_CODE"));	//15
				result.add(resultSet.getString("ITEM_CODE"));
				result.add(resultSet.getString("BIN_LOCATION_CODE"));
				//result.add(resultSet.getString("doc_srl_no"));
				
				doc_srl_no=resultSet.getString("doc_srl_no")==null?"":resultSet.getString("doc_srl_no");
				iv_prep_yn = resultSet.getString("iv_prep_yn")==null?"":resultSet.getString("iv_prep_yn"); //added for GHL-CRF-0482

				if(!doc_srl_no.equals("")){
					result.add(doc_srl_no);
				}
				else{
				
					pstmt = connection.prepareStatement( doc_srl_no_sql) ;
									
					pstmt.setString(1,resultSet.getString("DOC_TYPE")==null?"":resultSet.getString("DOC_TYPE"));
					pstmt.setString(2,resultSet.getString("DOC_NO")==null?"":resultSet.getString("DOC_NO"));
					pstmt.setString(3,resultSet.getString("STORE_CODE")==null?"":resultSet.getString("STORE_CODE"));
					pstmt.setString(4,resultSet.getString("ITEM_CODE")==null?"":resultSet.getString("ITEM_CODE"));
					pstmt.setString(5,resultSet.getString("BATCH_ID")==null?"":resultSet.getString("BATCH_ID"));
					pstmt.setString(6,resultSet.getString("EXPIRY_DATE")==null?"":resultSet.getString("EXPIRY_DATE"));
					pstmt.setString(7,resultSet.getString("BIN_LOCATION_CODE")==null?"":resultSet.getString("BIN_LOCATION_CODE"));
					pstmt.setString(8,resultSet.getString("TRADE_ID")==null?"":resultSet.getString("TRADE_ID"));
					
					resultSet2 = pstmt.executeQuery() ;
					if( resultSet2.next() ) {		
						result.add(resultSet2.getString("doc_srl_no"));
					}
					else
						result.add("");
				}				

				tot_admin_qty = 0;
				returnable    = Integer.parseInt(resultSet.getString("RETURNABLE"));
			   if(bat_admin_qty.containsKey(resultSet.getString("order_id")+resultSet.getString("order_line_no")+resultSet.getString("ITEM_CODE")+resultSet.getString("BATCH_ID")+resultSet.getString("EXPIRY_DATE")+resultSet.getString("trade_id")) ){
				 tot_admin_qty =Integer.parseInt((String)bat_admin_qty.get(resultSet.getString("order_id")+resultSet.getString("order_line_no")+resultSet.getString("ITEM_CODE")+resultSet.getString("BATCH_ID")+resultSet.getString("EXPIRY_DATE")+resultSet.getString("trade_id")));

				}
				else{
				// if condition added for GHL-CRF-0482
					if(isSite_spec_patient_stock && iv_prep_yn.equals("")){
					
						pstmt2.setString(1,getLanguageId());
						pstmt2.setString(2,resultSet.getString("ITEM_CODE"));
						pstmt2.setString(3,resultSet.getString("order_id"));
						pstmt2.setString(4,resultSet.getString("BATCH_ID"));
						pstmt2.setString(5,resultSet.getString("EXPIRY_DATE"));
						pstmt2.setString(6,resultSet.getString("ITEM_CODE"));
						resultSet1 = pstmt2.executeQuery() ;
					}else{
						pstmt1.setString(1,getLanguageId());
						pstmt1.setString(2,resultSet.getString("ITEM_CODE"));
						pstmt1.setString(3,getLanguageId());
						pstmt1.setString(4,resultSet.getString("ITEM_CODE"));
						pstmt1.setString(5,resultSet.getString("order_id"));
						pstmt1.setString(6,resultSet.getString("order_line_no"));
						pstmt1.setString(7,resultSet.getString("ITEM_CODE"));
						pstmt1.setString(8,resultSet.getString("BATCH_ID"));
						pstmt1.setString(9,resultSet.getString("EXPIRY_DATE"));
						pstmt1.setString(10,resultSet.getString("trade_id"));
						resultSet1 = pstmt1.executeQuery() ;
					}

//					resultSet1 = pstmt1.executeQuery() ;
					while ( resultSet1.next() ) {                 
//tot_admin_qty =resultSet1.getInt("tot_admin_qty");//Commented for GHL-CRF-0482
						admin_qty =resultSet1.getInt("tot_admin_qty");	//Added for GHL-CRF-0482
						tot_admin_qty = tot_admin_qty+admin_qty;//Added for GHL-CRF-0482
					}
					closeResultSet( resultSet1 ) ;
				}

				if(tot_admin_qty >0){	
					 if(returnable <tot_admin_qty){
						 result.add("N");
						 result.add("0");
						 //tot_admin_qty =0;//commented for 26175
						 tot_admin_qty =tot_admin_qty - returnable;//added for 26175

					 }
					 else{
						returnable = returnable - tot_admin_qty;
						if(returnable <0){
							 tot_admin_qty = tot_admin_qty - returnable;
							 result.add("N");
							 result.add("0");
						}
						else{
							 result.add("Y");
							 result.add(returnable+"");
							 tot_admin_qty = 0;
							 tot_admin_qty =tot_admin_qty - returnable;//added for 26175
						}
					 }     
					 bat_admin_qty.put(resultSet.getString("order_id")+resultSet.getString("order_line_no")+resultSet.getString("ITEM_CODE")+resultSet.getString("BATCH_ID")+resultSet.getString("EXPIRY_DATE")+resultSet.getString("trade_id"),tot_admin_qty+"");
				 }
				 else{

					 result.add("Y");
					 result.add(returnable+"");
				 }
				result.add(resultSet.getString("ISSUE_QTY")==null?"":resultSet.getString("ISSUE_QTY")); //21
				result.add(resultSet.getString("ISSUE_UOM_CODE")==null?"":resultSet.getString("ISSUE_UOM_CODE")); 
				result.add(resultSet.getString("SHORT_DESC")==null?"":resultSet.getString("SHORT_DESC"));
				result.add(resultSet.getString("disp_locn_name")==null?"":resultSet.getString("disp_locn_name"));
				result.add(resultSet.getString("order_line_staus")==null?"":resultSet.getString("order_line_staus"));	//25
				result.add(resultSet.getString("dis_cont_reason")==null?"":resultSet.getString("dis_cont_reason"));
				result.add(resultSet.getString("DISC_DATE_TIME")==null?"":resultSet.getString("DISC_DATE_TIME"));
				result.add(resultSet.getString("pract_name")==null?"":resultSet.getString("pract_name"));
				result.add(resultSet.getString("TO_STORE_DEF_ISSUE_UOM")==null?"":resultSet.getString("TO_STORE_DEF_ISSUE_UOM"));
				result.add(resultSet.getString("trade_id")); 			    //30
				result.add(resultSet.getString("encounter_id")==null?"":resultSet.getString("encounter_id"));			   
				//setEncounter(resultSet.getString("ENCOUNTER_ID"));
				result.add(resultSet.getString("facility_id"));
				result.add(resultSet.getString("RETURN_FACILITY"));//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Setting Return Facility.
				result.add(resultSet.getString("TRADE_NAME"));//added for AMS-SCF-0190-IN038440.
				result.add(resultSet.getString("ORDERING_FACILITY_ID"));//added for Bru-HIMS-CRF-0297 Billing CRF
				result.add(resultSet.getString("DISCHARGE_IND"));
				result.add(resultSet.getString("ORDER_ID"));//Added for GHL-SCF-1084
				result.add(resultSet.getString("ORDER_LINE_NO"));//Added for GHL-SCF-1084
				//Added for ghl-crf-0413.8 start
				if(barcodeFlag.equals("Y")){
					result.add(0);
					
					barcode_id = getBarcodeId(resultSet.getString("ITEM_CODE"),resultSet.getString("BATCH_ID"),resultSet.getString("EXPIRY_DATE"));//SKR-SCF-1574
					result.add(barcode_id);
					//result.add(resultSet.getString("BARCODE_ID"));
				}
				//Added for ghl-crf-0413.8 end
				result.add(resultSet.getString("DISP_QTY_UOM"));//added for ML-BRU-SCF-1842
			}
			
			//newBarcodeArry=result;
			if(getNewBarcodeArry().size()==0){
				setNewBarcodeArry(result);
			}
			else{
				result=getNewBarcodeArry();
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return result;
	}

	public String getBarcodeId(String item_code,String batch_id,String expiry_date){
	   Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String barcode_id		= "";
        try {
            connection = getConnection() ;

			
			pstmt = connection.prepareStatement("SELECT BARCODE_ID  FROM ST_BATCH_CONTROL WHERE ITEM_CODE = ? AND BATCH_ID=? AND EXPIRY_DATE_OR_RECEIPT_DATE=TO_DATE(?,'DD/MM/YYYY') ") ;
			pstmt.setString(1,item_code);
			pstmt.setString(2,batch_id);
			pstmt.setString(3,expiry_date);
            resultSet = pstmt.executeQuery() ;
            if ( resultSet!=null && resultSet.next() ) {
				barcode_id=resultSet.getString("BARCODE_ID");
				if (barcode_id==null)
					barcode_id = "";
				
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			return e.toString();
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
		return barcode_id;

	
	}

	//get Ward Batch details
	public ArrayList getWardBatchDetails(String patientid,String dispno,String cutoff,String orderid,String FormStore,String toStore,String Ward_Date_From,String ward_Date_To,String From_Location,String drugcode, String encounter_id,String patcat, String rej_qty){
	 //parameter "patcat" added for SRR20056-SCF-7414, Incident No. 27456
	 //encounter_id added for AMS-CRF-0172
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
        ResultSet resultSet2	= null;
		String doc_srl_no       ="",sql=""; 
		ArrayList result		= new ArrayList();
		String oldpatcat		= patcat;
		HashMap siteValues =new HashMap();//Added for MOHE-CRF-0167
		String include_exp_date_yn ="N";//Added for MOHE-CRF-0167
				
        try {	
            connection = getConnection() ;
			boolean barcode_2d_applicable = eCommon.Common.CommonBean.isSiteSpecific(connection, "ST","2D_BARCODE_APPLICABLE"); //adding start for MOHE-CRF-0167
			siteValues =eCommon.Common.CommonBean.getSiteSpecificDetails(connection, "ST","2D_BARCODE_APPLICABLE");
			if(siteValues.containsKey("key1"))
					  include_exp_date_yn =(String)siteValues.get("value1");//Adding end for MOHE-CRF-0167
			//String sql=PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT7") ;
			if(rej_qty.equals("E"))
				//sql="SELECT D.DRUG_DESC,(SELECT short_name FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?)TRADE_NAME, decode(O.USE_AFTER_EXPIRY_YN,'Y','Y','N',DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y') )valid, C.DOC_TYPE, C.DOC_NO, A.STORE_CODE, A.ITEM_CODE, A.BIN_LOCATION_CODE, A.BATCH_ID, TO_CHAR (A.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE,A.TRADE_ID TRADE_ID, A.DISP_NO, A.SRL_NO, B.DOC_SRL_NO, A.SRL_NO_BATCH,TO_CHAR (B.ADDED_DATE, 'DD/MM/YYYY') ADDED_DATE, A.DISP_QTY ISSUEDQTY, B.DISP_UOM_CODE QTYUOM,K.REJ_QTY RETURNABLE,C.ENCOUNTER_ID, B.ORDER_ID, B.ORDER_LINE_NO, B.ISSUE_QTY, B.ISSUE_UOM_CODE,N.DISCHARGE_IND,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = B.ISSUE_UOM_CODE AND LANGUAGE_ID = ?) SHORT_DESC,G.SHORT_DESC DISP_LOCN_NAME, H.ORDER_LINE_STATUS ORDER_LINE_STAUS,H.CAN_LINE_REASON DIS_CONT_REASON,TO_CHAR (H.DISC_DATE_TIME, 'DD/MM/YYYY HH24:MI') DISC_DATE_TIME,I.SHORT_NAME PRACT_NAME, (SELECT DEF_ISSUE_UOM DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE EFF_STATUS = 'E' AND ITEM_CODE = A.ITEM_CODE AND STORE_CODE = ?) TO_STORE_DEF_ISSUE_UOM,PH_GETLOCN_NAME (C.PATIENT_CLASS, C.LOCN_CODE, n.ORDERING_FACILITY_ID ,?) PH_GETLOCN_NAME,L.APPL_USER_NAME RETURNED_BY,M.REASON_DESC RETURN_REASON,K.RET_DOC_NO, K.RET_DOC_LINE_NO,J.RETURN_REASON RETURN_REASON_CODE, to_char(K.MODIFIED_DATE , 'DD/MM/YYYY HH24:MI:SSSSS') MODIFIED_DATE FROM (SELECT DRUG_DESC DRUG_DESC, DRUG_CODE DRUG_CODE,NVL (CONTENT_IN_PRES_BASE_UOM, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_DRUG_LANG_VW WHERE LANGUAGE_ID =? UNION SELECT NVL (SHORT_NAME, LONG_NAME) DRUG_DESC,TPN_REGIMEN_CODE DRUG_CODE,NVL (CONTENT_IN_BASE_UNIT, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_TPN_REGIMEN_LANG_VW WHERE STANDARD_REGIMEN_YN = 'Y' AND LANGUAGE_ID = ?) D,PH_DISP_DRUG_BATCH A,PH_DISP_DTL B,PH_DISP_HDR C,MP_PATIENT E,PH_DISP_LOCN_LANG_VW G, OR_ORDER_LINE H,AM_PRACTITIONER_LANG_VW I,PH_WARD_RETURN_HDR J,PH_WARD_RETURN_DTL K,SM_APPL_USER_LANG_VW L,PH_MEDN_TRN_REASON_LANG_VW M,OR_ORDER N ,st_item O WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DISP_NO = B.DISP_NO AND A.SRL_NO = B.SRL_NO AND C.PATIENT_ID = E.PATIENT_ID AND C.FACILITY_ID = B.FACILITY_ID AND C.DISP_NO = B.DISP_NO AND B.DISP_DRUG_CODE = D.DRUG_CODE and c.order_id =n.order_id  and n.ORDERING_FACILITY_ID  =? AND E.PATIENT_ID = ? AND C.FACILITY_ID=J.FACILITY_ID AND C.PATIENT_ID =J.PATIENT_ID AND C.DISP_NO =J.DISP_NO AND J.RET_TO_DISP_LOCN_CODE =? AND J.FACILITY_ID=K.FACILITY_ID AND J.RET_DOC_NO=K.RET_DOC_NO AND J.DISP_NO   =K.DISP_NO AND B.SRL_NO =K.SRL_NO AND A.SRL_NO_BATCH=K.SRL_NO_BATCH AND  K.REJ_QTY > 0 AND J.ADDED_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY')+.99999 AND J.FROM_LOCN_CODE =NVL(?,J.FROM_LOCN_CODE) AND J.ADDED_BY_ID =L.APPL_USER_ID AND J.RETURN_REASON=M.REASON_CODE AND M.APPL_TRN_TYPE='T'";//Commented for GHL-SCF-1084
				//sql="SELECT D.DRUG_DESC,(SELECT short_name FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?)TRADE_NAME, decode(O.USE_AFTER_EXPIRY_YN,'Y','Y','N',DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y') )valid, C.DOC_TYPE, C.DOC_NO, A.STORE_CODE, A.ITEM_CODE, A.BIN_LOCATION_CODE, A.BATCH_ID, TO_CHAR (A.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE,A.TRADE_ID TRADE_ID, A.DISP_NO, A.SRL_NO, B.DOC_SRL_NO, A.SRL_NO_BATCH,TO_CHAR (B.ADDED_DATE, 'DD/MM/YYYY') ADDED_DATE, A.DISP_QTY ISSUEDQTY, B.DISP_UOM_CODE QTYUOM,K.REJ_QTY RETURNABLE,C.ENCOUNTER_ID, B.ORDER_ID, B.ORDER_LINE_NO, B.ISSUE_QTY, B.ISSUE_UOM_CODE,N.DISCHARGE_IND,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = B.ISSUE_UOM_CODE AND LANGUAGE_ID = ?) SHORT_DESC,G.SHORT_DESC DISP_LOCN_NAME, H.ORDER_LINE_STATUS ORDER_LINE_STAUS,H.CAN_LINE_REASON DIS_CONT_REASON,TO_CHAR (H.DISC_DATE_TIME, 'DD/MM/YYYY HH24:MI') DISC_DATE_TIME,(select  short_name from am_practitioner_lang_vw where h.disc_pract_id = practitioner_id(+)   AND language_id(+) = ?) pract_name,(SELECT DEF_ISSUE_UOM DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE EFF_STATUS = 'E' AND ITEM_CODE = A.ITEM_CODE AND STORE_CODE = ?) TO_STORE_DEF_ISSUE_UOM,PH_GETLOCN_NAME (C.PATIENT_CLASS, C.LOCN_CODE, n.ORDERING_FACILITY_ID ,?) PH_GETLOCN_NAME,L.APPL_USER_NAME RETURNED_BY,M.REASON_DESC RETURN_REASON,K.RET_DOC_NO, K.RET_DOC_LINE_NO,J.RETURN_REASON RETURN_REASON_CODE, to_char(K.MODIFIED_DATE , 'DD/MM/YYYY HH24:MI:SSSSS') MODIFIED_DATE FROM (SELECT DRUG_DESC DRUG_DESC, DRUG_CODE DRUG_CODE,NVL (CONTENT_IN_PRES_BASE_UOM, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_DRUG_LANG_VW WHERE LANGUAGE_ID =?  UNION SELECT NVL (SHORT_NAME, LONG_NAME) DRUG_DESC,TPN_REGIMEN_CODE DRUG_CODE,NVL (CONTENT_IN_BASE_UNIT, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_TPN_REGIMEN_LANG_VW WHERE STANDARD_REGIMEN_YN = 'Y'  AND LANGUAGE_ID = ?) D,PH_DISP_DRUG_BATCH A,PH_DISP_DTL B,PH_DISP_HDR C,MP_PATIENT E,PH_DISP_LOCN_LANG_VW G, OR_ORDER_LINE H,PH_WARD_RETURN_HDR J,PH_WARD_RETURN_DTL K,SM_APPL_USER_LANG_VW L,PH_MEDN_TRN_REASON_LANG_VW M,OR_ORDER N ,st_item O WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DISP_NO = B.DISP_NO AND A.SRL_NO = B.SRL_NO AND C.PATIENT_ID = E.PATIENT_ID AND C.FACILITY_ID = B.FACILITY_ID AND C.DISP_NO = B.DISP_NO AND B.DISP_DRUG_CODE = D.DRUG_CODE and c.order_id =n.order_id  and n.ORDERING_FACILITY_ID  =? AND E.PATIENT_ID = ? AND C.FACILITY_ID=J.FACILITY_ID AND C.PATIENT_ID =J.PATIENT_ID AND C.DISP_NO =J.DISP_NO AND J.RET_TO_DISP_LOCN_CODE =? AND J.FACILITY_ID=K.FACILITY_ID AND J.RET_DOC_NO=K.RET_DOC_NO AND J.DISP_NO   =K.DISP_NO AND B.SRL_NO =K.SRL_NO AND A.SRL_NO_BATCH=K.SRL_NO_BATCH and h.order_id = k.order_id  AND h.order_line_num = k.order_line_no AND k.disp_no between nvl(?,'!') and nvl(?,'~') AND  K.REJ_QTY > 0 AND J.ADDED_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY')+.99999 AND J.FROM_LOCN_CODE =NVL(?,J.FROM_LOCN_CODE) and c.disp_no = k.disp_no AND J.ADDED_BY_ID =L.APPL_USER_ID AND J.RETURN_REASON=M.REASON_CODE AND M.APPL_TRN_TYPE='T'";//Added for GHL-SCF-1084
								//(CASE WHEN (use_after_expiry_yn = 'N' AND EXPIRY_YN='N') then 'Y' WHEN greatest (sysdate, expiry_date) = sysdate then 'N'ELSE 'Y' END )) valid changed for SKR-SCF-1256
				//sql="SELECT D.DRUG_DESC,(SELECT short_name FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?)TRADE_NAME, DECODE (O.use_after_expiry_yn,'Y', 'Y','N',  (CASE WHEN (O.use_after_expiry_yn = 'N' AND EXPIRY_YN='N') then 'Y' WHEN greatest (sysdate, expiry_date) = sysdate then 'N'ELSE 'Y' END )) valid, C.DOC_TYPE, C.DOC_NO, A.STORE_CODE, A.ITEM_CODE, A.BIN_LOCATION_CODE, A.BATCH_ID, TO_CHAR (A.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE,A.TRADE_ID TRADE_ID, A.DISP_NO, A.SRL_NO, B.DOC_SRL_NO, A.SRL_NO_BATCH,TO_CHAR (B.ADDED_DATE, 'DD/MM/YYYY') ADDED_DATE, A.DISP_QTY ISSUEDQTY, B.DISP_UOM_CODE QTYUOM,K.REJ_QTY RETURNABLE,C.ENCOUNTER_ID, B.ORDER_ID, B.ORDER_LINE_NO, B.ISSUE_QTY, B.ISSUE_UOM_CODE,N.DISCHARGE_IND,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = B.ISSUE_UOM_CODE AND LANGUAGE_ID = ?) SHORT_DESC,G.SHORT_DESC DISP_LOCN_NAME, H.ORDER_LINE_STATUS ORDER_LINE_STAUS,H.CAN_LINE_REASON DIS_CONT_REASON,TO_CHAR (H.DISC_DATE_TIME, 'DD/MM/YYYY HH24:MI') DISC_DATE_TIME,(select  short_name from am_practitioner_lang_vw where h.disc_pract_id = practitioner_id(+)   AND language_id(+) = ?) pract_name,(SELECT DEF_ISSUE_UOM DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE EFF_STATUS = 'E' AND ITEM_CODE = A.ITEM_CODE AND STORE_CODE = ?) TO_STORE_DEF_ISSUE_UOM,PH_GETLOCN_NAME (C.PATIENT_CLASS, C.LOCN_CODE, n.ORDERING_FACILITY_ID ,?) PH_GETLOCN_NAME,L.APPL_USER_NAME RETURNED_BY,M.REASON_DESC RETURN_REASON,K.RET_DOC_NO, K.RET_DOC_LINE_NO,J.RETURN_REASON RETURN_REASON_CODE, to_char(K.MODIFIED_DATE , 'DD/MM/YYYY HH24:MI:SSSSS') MODIFIED_DATE,(SELECT barcode_id FROM st_sal_dtl_exp WHERE facility_id = a.facility_id AND doc_no = c.doc_no AND item_code =a.item_code AND batch_id = a.batch_id AND store_code = a.store_code AND expiry_date_or_receipt_date = a.expiry_date AND bin_location_code = a.bin_location_code and doc_srl_no=b.doc_srl_no ) barcode_id,a.DISP_QTY_UOM FROM (SELECT DRUG_DESC DRUG_DESC, DRUG_CODE DRUG_CODE,NVL (CONTENT_IN_PRES_BASE_UOM, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_DRUG_LANG_VW WHERE LANGUAGE_ID =?  UNION SELECT NVL (SHORT_NAME, LONG_NAME) DRUG_DESC,TPN_REGIMEN_CODE DRUG_CODE,NVL (CONTENT_IN_BASE_UNIT, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_TPN_REGIMEN_LANG_VW WHERE STANDARD_REGIMEN_YN = 'Y'  AND LANGUAGE_ID = ?) D,PH_DISP_DRUG_BATCH A,PH_DISP_DTL B,PH_DISP_HDR C,MP_PATIENT E,PH_DISP_LOCN_LANG_VW G, OR_ORDER_LINE H,PH_WARD_RETURN_HDR J,PH_WARD_RETURN_DTL K,SM_APPL_USER_LANG_VW L,PH_MEDN_TRN_REASON_LANG_VW M,OR_ORDER N ,st_item O WHERE  A.DISP_NO = B.DISP_NO AND A.SRL_NO = B.SRL_NO  AND a.facility_id =b.facility_id  AND C.DISP_NO = B.DISP_NO AND B.DISP_DRUG_CODE = D.DRUG_CODE and c.order_id =n.order_id  and n.ORDERING_FACILITY_ID  =? AND E.PATIENT_ID = ? and n.order_category='PH' AND C.PATIENT_ID =J.PATIENT_ID AND C.DISP_NO =J.DISP_NO AND J.RET_TO_DISP_LOCN_CODE =? AND J.FACILITY_ID=K.FACILITY_ID AND J.RET_DOC_NO=K.RET_DOC_NO AND J.DISP_NO   =K.DISP_NO AND B.SRL_NO =K.SRL_NO and e.patient_id = n.patient_id AND A.SRL_NO_BATCH=K.SRL_NO_BATCH and h.order_id = k.order_id  AND h.order_line_num = k.order_line_no AND k.disp_no between nvl(?,'!') and nvl(?,'~') AND  K.REJ_QTY > 0 AND J.ADDED_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY')+.99999  and c.disp_no = k.disp_no AND J.ADDED_BY_ID =L.APPL_USER_ID AND J.RETURN_REASON=M.REASON_CODE AND M.APPL_TRN_TYPE='T'"; // a.DISP_QTY_UOM Added for ML-BRU-SCF-1880
			// a.DISP_QTY_UOM REMOVED FROM UNION IN071554 and IN071683  // 38214 -- KDAH-ICN-0029
				sql="SELECT (SELECT drug_desc drug_desc FROM ph_drug_lang_vw WHERE language_id = ? AND drug_code = b.disp_drug_code UNION SELECT NVL (short_name, long_name) drug_desc FROM ph_tpn_regimen_lang_vw  WHERE STANDARD_REGIMEN_YN = 'Y'   AND language_id = ? AND tpn_regimen_code =b.disp_drug_code ) drug_desc,(SELECT short_name FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?)TRADE_NAME,(SELECT MANUFACTURER_ID FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?) MANUFACTURER_ID, DECODE (O.use_after_expiry_yn,'Y', 'Y','N',  (CASE WHEN (O.use_after_expiry_yn = 'N' AND EXPIRY_YN='N') then 'Y' WHEN greatest (sysdate, expiry_date) = sysdate then 'N'ELSE 'Y' END )) valid, C.DOC_TYPE, C.DOC_NO, A.STORE_CODE, A.ITEM_CODE, A.BIN_LOCATION_CODE, A.BATCH_ID, TO_CHAR (A.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE,A.TRADE_ID TRADE_ID, A.DISP_NO, A.SRL_NO, B.DOC_SRL_NO, A.SRL_NO_BATCH,TO_CHAR (B.ADDED_DATE, 'DD/MM/YYYY') ADDED_DATE, A.DISP_QTY ISSUEDQTY, B.DISP_UOM_CODE QTYUOM,K.REJ_QTY RETURNABLE,C.ENCOUNTER_ID, B.ORDER_ID, B.ORDER_LINE_NO, B.ISSUE_QTY, B.ISSUE_UOM_CODE,N.DISCHARGE_IND,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = B.ISSUE_UOM_CODE AND LANGUAGE_ID = ?) SHORT_DESC,G.SHORT_DESC DISP_LOCN_NAME, H.ORDER_LINE_STATUS ORDER_LINE_STAUS,H.CAN_LINE_REASON DIS_CONT_REASON,TO_CHAR (H.DISC_DATE_TIME, 'DD/MM/YYYY HH24:MI') DISC_DATE_TIME,(select  short_name from am_practitioner_lang_vw where h.disc_pract_id = practitioner_id(+)   AND language_id(+) = ?) pract_name,(SELECT DEF_ISSUE_UOM DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE EFF_STATUS = 'E' AND ITEM_CODE = A.ITEM_CODE AND STORE_CODE = ?) TO_STORE_DEF_ISSUE_UOM,PH_GETLOCN_NAME (C.PATIENT_CLASS, C.LOCN_CODE, n.ORDERING_FACILITY_ID ,?) PH_GETLOCN_NAME,L.APPL_USER_NAME RETURNED_BY,M.REASON_DESC RETURN_REASON,K.RET_DOC_NO, K.RET_DOC_LINE_NO,J.RETURN_REASON RETURN_REASON_CODE, to_char(K.MODIFIED_DATE , 'DD/MM/YYYY HH24:MI:SSSSS') MODIFIED_DATE,(SELECT barcode_id FROM st_sal_dtl_exp WHERE facility_id = a.facility_id AND doc_no = c.doc_no AND item_code =a.item_code AND batch_id = a.batch_id AND store_code = a.store_code AND expiry_date_or_receipt_date = a.expiry_date AND bin_location_code = a.bin_location_code and doc_srl_no=b.doc_srl_no ) barcode_id,a.DISP_QTY_UOM FROM PH_DISP_DRUG_BATCH A,PH_DISP_DTL B,PH_DISP_HDR C,PH_DISP_LOCN_LANG_VW G, OR_ORDER_LINE H,PH_WARD_RETURN_HDR J,PH_WARD_RETURN_DTL K,SM_APPL_USER_LANG_VW L,PH_MEDN_TRN_REASON_LANG_VW M,OR_ORDER N ,st_item O WHERE  A.DISP_NO = B.DISP_NO AND A.SRL_NO = B.SRL_NO  AND a.facility_id =b.facility_id  AND C.DISP_NO = B.DISP_NO  and c.order_id =n.order_id  and n.ORDERING_FACILITY_ID  =? AND N.PATIENT_ID = ? and n.order_category='PH' AND C.PATIENT_ID =J.PATIENT_ID AND C.DISP_NO =J.DISP_NO AND J.RET_TO_DISP_LOCN_CODE =? AND J.FACILITY_ID=K.FACILITY_ID AND J.RET_DOC_NO=K.RET_DOC_NO AND J.DISP_NO   =K.DISP_NO AND B.SRL_NO =K.SRL_NO  AND A.SRL_NO_BATCH=K.SRL_NO_BATCH and h.order_id = k.order_id  AND h.order_line_num = k.order_line_no AND k.disp_no between nvl(?,'!') and nvl(?,'~') AND  K.REJ_QTY > 0 AND J.ADDED_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY')+.99999  and c.disp_no = k.disp_no AND J.ADDED_BY_ID =L.APPL_USER_ID AND J.RETURN_REASON=M.REASON_CODE AND M.APPL_TRN_TYPE='T'"; // a.DISP_QTY_UOM Added for ML-BRU-SCF-1880
			// a.DISP_QTY_UOM REMOVED FROM UNION IN071554 and IN071683  // 38214 -- KDAH-ICN-0029 - tuned for return medication (not used mp_patient and drug desc changed) - ravi ,(SELECT MANUFACTURER_ID FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?) MANUFACTURER_ID Added for MOFE-CRF-0167
			else
				//sql="SELECT D.DRUG_DESC,(SELECT short_name FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?)TRADE_NAME, decode(O.USE_AFTER_EXPIRY_YN,'Y','Y','N',DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y') )valid, C.DOC_TYPE, C.DOC_NO, A.STORE_CODE, A.ITEM_CODE, A.BIN_LOCATION_CODE, A.BATCH_ID, TO_CHAR (A.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE,A.TRADE_ID TRADE_ID, A.DISP_NO, A.SRL_NO, B.DOC_SRL_NO, A.SRL_NO_BATCH,TO_CHAR (B.ADDED_DATE, 'DD/MM/YYYY') ADDED_DATE, A.DISP_QTY ISSUEDQTY, B.DISP_UOM_CODE QTYUOM,NVL(K.BAL_QTY,K.RETURNED_QTY) RETURNABLE,C.ENCOUNTER_ID, B.ORDER_ID, B.ORDER_LINE_NO, B.ISSUE_QTY, B.ISSUE_UOM_CODE,N.DISCHARGE_IND,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = B.ISSUE_UOM_CODE AND LANGUAGE_ID = ?) SHORT_DESC,G.SHORT_DESC DISP_LOCN_NAME, H.ORDER_LINE_STATUS ORDER_LINE_STAUS,H.CAN_LINE_REASON DIS_CONT_REASON,TO_CHAR (H.DISC_DATE_TIME, 'DD/MM/YYYY HH24:MI') DISC_DATE_TIME,I.SHORT_NAME PRACT_NAME, (SELECT DEF_ISSUE_UOM DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE EFF_STATUS = 'E' AND ITEM_CODE = A.ITEM_CODE AND STORE_CODE = ?) TO_STORE_DEF_ISSUE_UOM,PH_GETLOCN_NAME (C.PATIENT_CLASS, C.LOCN_CODE, n.ORDERING_FACILITY_ID ,?) PH_GETLOCN_NAME,L.APPL_USER_NAME RETURNED_BY,M.REASON_DESC RETURN_REASON,K.RET_DOC_NO, K.RET_DOC_LINE_NO,J.RETURN_REASON RETURN_REASON_CODE, to_char(K.MODIFIED_DATE , 'DD/MM/YYYY HH24:MI:SSSSS') MODIFIED_DATE FROM (SELECT DRUG_DESC DRUG_DESC, DRUG_CODE DRUG_CODE,NVL (CONTENT_IN_PRES_BASE_UOM, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_DRUG_LANG_VW WHERE LANGUAGE_ID =? UNION SELECT NVL (SHORT_NAME, LONG_NAME) DRUG_DESC,TPN_REGIMEN_CODE DRUG_CODE,NVL (CONTENT_IN_BASE_UNIT, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_TPN_REGIMEN_LANG_VW WHERE STANDARD_REGIMEN_YN = 'Y' AND LANGUAGE_ID = ?) D,PH_DISP_DRUG_BATCH A,PH_DISP_DTL B,PH_DISP_HDR C,MP_PATIENT E,PH_DISP_LOCN_LANG_VW G, OR_ORDER_LINE H,AM_PRACTITIONER_LANG_VW I,PH_WARD_RETURN_HDR J,PH_WARD_RETURN_DTL K,SM_APPL_USER_LANG_VW L,PH_MEDN_TRN_REASON_LANG_VW M,OR_ORDER N ,st_item O WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DISP_NO = B.DISP_NO AND A.SRL_NO = B.SRL_NO AND C.PATIENT_ID = E.PATIENT_ID AND C.FACILITY_ID = B.FACILITY_ID AND C.DISP_NO = B.DISP_NO AND B.DISP_DRUG_CODE = D.DRUG_CODE and c.order_id =n.order_id  and n.ORDERING_FACILITY_ID  =? AND E.PATIENT_ID = ? AND C.FACILITY_ID=J.FACILITY_ID AND C.PATIENT_ID =J.PATIENT_ID AND C.DISP_NO =J.DISP_NO AND J.RET_TO_DISP_LOCN_CODE =? AND J.FACILITY_ID=K.FACILITY_ID AND J.RET_DOC_NO=K.RET_DOC_NO AND J.DISP_NO   =K.DISP_NO AND B.SRL_NO =K.SRL_NO AND A.SRL_NO_BATCH=K.SRL_NO_BATCH AND NVL(K.BAL_QTY,K.RETURNED_QTY) > 0 AND (K.STORE_ACKNOWLEDGE_STATUS ='P' OR K.STORE_ACKNOWLEDGE_STATUS IS NULL) AND J.ADDED_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY')+.99999 AND J.FROM_LOCN_CODE =NVL(?,J.FROM_LOCN_CODE) AND J.ADDED_BY_ID =L.APPL_USER_ID AND J.RETURN_REASON=M.REASON_CODE AND M.APPL_TRN_TYPE='T'";//Commented for GHL-SCF-1084
				//sql="SELECT D.DRUG_DESC,(SELECT short_name FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?)TRADE_NAME, decode(O.USE_AFTER_EXPIRY_YN,'Y','Y','N',DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y') )valid, C.DOC_TYPE, C.DOC_NO, A.STORE_CODE, A.ITEM_CODE, A.BIN_LOCATION_CODE, A.BATCH_ID, TO_CHAR (A.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE,A.TRADE_ID TRADE_ID, A.DISP_NO, A.SRL_NO, B.DOC_SRL_NO, A.SRL_NO_BATCH,TO_CHAR (B.ADDED_DATE, 'DD/MM/YYYY') ADDED_DATE, A.DISP_QTY ISSUEDQTY, B.DISP_UOM_CODE QTYUOM,NVL(K.BAL_QTY,K.RETURNED_QTY) RETURNABLE,C.ENCOUNTER_ID, B.ORDER_ID, B.ORDER_LINE_NO, B.ISSUE_QTY, B.ISSUE_UOM_CODE,N.DISCHARGE_IND,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = B.ISSUE_UOM_CODE AND LANGUAGE_ID = ?) SHORT_DESC,G.SHORT_DESC DISP_LOCN_NAME, H.ORDER_LINE_STATUS ORDER_LINE_STAUS,H.CAN_LINE_REASON DIS_CONT_REASON,TO_CHAR (H.DISC_DATE_TIME, 'DD/MM/YYYY HH24:MI') DISC_DATE_TIME,(select  short_name from am_practitioner_lang_vw where h.disc_pract_id = practitioner_id(+)   AND language_id(+) = ?) pract_name,(SELECT DEF_ISSUE_UOM DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE EFF_STATUS = 'E' AND ITEM_CODE = A.ITEM_CODE AND STORE_CODE = ?) TO_STORE_DEF_ISSUE_UOM,PH_GETLOCN_NAME (C.PATIENT_CLASS, C.LOCN_CODE, n.ORDERING_FACILITY_ID ,?) PH_GETLOCN_NAME,L.APPL_USER_NAME RETURNED_BY,M.REASON_DESC RETURN_REASON,K.RET_DOC_NO, K.RET_DOC_LINE_NO,J.RETURN_REASON RETURN_REASON_CODE, to_char(K.MODIFIED_DATE , 'DD/MM/YYYY HH24:MI:SSSSS') MODIFIED_DATE FROM (SELECT DRUG_DESC DRUG_DESC, DRUG_CODE DRUG_CODE,NVL (CONTENT_IN_PRES_BASE_UOM, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_DRUG_LANG_VW WHERE LANGUAGE_ID =?  UNION SELECT NVL (SHORT_NAME, LONG_NAME) DRUG_DESC,TPN_REGIMEN_CODE DRUG_CODE,NVL (CONTENT_IN_BASE_UNIT, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_TPN_REGIMEN_LANG_VW WHERE STANDARD_REGIMEN_YN = 'Y'  AND LANGUAGE_ID = ?) D,PH_DISP_DRUG_BATCH A,PH_DISP_DTL B,PH_DISP_HDR C,MP_PATIENT E,PH_DISP_LOCN_LANG_VW G, OR_ORDER_LINE H,PH_WARD_RETURN_HDR J,PH_WARD_RETURN_DTL K,SM_APPL_USER_LANG_VW L,PH_MEDN_TRN_REASON_LANG_VW M,OR_ORDER N ,st_item O WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DISP_NO = B.DISP_NO AND A.SRL_NO = B.SRL_NO AND C.PATIENT_ID = E.PATIENT_ID AND C.FACILITY_ID = B.FACILITY_ID AND C.DISP_NO = B.DISP_NO AND B.DISP_DRUG_CODE = D.DRUG_CODE and c.order_id =n.order_id  and n.ORDERING_FACILITY_ID  =? AND E.PATIENT_ID = ? AND C.FACILITY_ID=J.FACILITY_ID AND C.PATIENT_ID =J.PATIENT_ID AND C.DISP_NO =J.DISP_NO AND J.RET_TO_DISP_LOCN_CODE =? AND J.FACILITY_ID=K.FACILITY_ID AND J.RET_DOC_NO=K.RET_DOC_NO AND J.DISP_NO   =K.DISP_NO AND B.SRL_NO =K.SRL_NO AND A.SRL_NO_BATCH=K.SRL_NO_BATCH  and h.order_id = k.order_id  AND h.order_line_num = k.order_line_no AND k.disp_no between nvl(?,'!') and nvl(?,'~')  AND NVL(K.BAL_QTY,K.RETURNED_QTY) > 0 AND (K.STORE_ACKNOWLEDGE_STATUS ='P' OR K.STORE_ACKNOWLEDGE_STATUS IS NULL) AND J.ADDED_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY')+.99999 AND J.FROM_LOCN_CODE =NVL(?,J.FROM_LOCN_CODE) and c.disp_no = k.disp_no AND J.ADDED_BY_ID =L.APPL_USER_ID AND J.RETURN_REASON=M.REASON_CODE AND M.APPL_TRN_TYPE='T'";//added for GHL-SCF-1084
								//(CASE WHEN (use_after_expiry_yn = 'N' AND EXPIRY_YN='N') then 'Y' WHEN greatest (sysdate, expiry_date) = sysdate then 'N'ELSE 'Y' END )) valid changed for SKR-SCF-1256
				//sql="SELECT D.DRUG_DESC,(SELECT short_name FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?)TRADE_NAME, DECODE (O.use_after_expiry_yn,'Y', 'Y','N',  (CASE WHEN (O.use_after_expiry_yn = 'N' AND EXPIRY_YN='N') then 'Y' WHEN greatest (sysdate, expiry_date) = sysdate then 'N' ELSE 'Y' END ))valid, C.DOC_TYPE, C.DOC_NO, A.STORE_CODE, A.ITEM_CODE, A.BIN_LOCATION_CODE, A.BATCH_ID, TO_CHAR (A.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE,A.TRADE_ID TRADE_ID, A.DISP_NO, A.SRL_NO, B.DOC_SRL_NO, A.SRL_NO_BATCH,TO_CHAR (B.ADDED_DATE, 'DD/MM/YYYY') ADDED_DATE, A.DISP_QTY ISSUEDQTY, B.DISP_UOM_CODE QTYUOM,NVL(K.BAL_QTY,K.RETURNED_QTY) RETURNABLE,C.ENCOUNTER_ID, B.ORDER_ID, B.ORDER_LINE_NO, B.ISSUE_QTY, B.ISSUE_UOM_CODE,N.DISCHARGE_IND,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = B.ISSUE_UOM_CODE AND LANGUAGE_ID = ?) SHORT_DESC,G.SHORT_DESC DISP_LOCN_NAME, H.ORDER_LINE_STATUS ORDER_LINE_STAUS,H.CAN_LINE_REASON DIS_CONT_REASON,TO_CHAR (H.DISC_DATE_TIME, 'DD/MM/YYYY HH24:MI') DISC_DATE_TIME,(select  short_name from am_practitioner_lang_vw where h.disc_pract_id = practitioner_id(+)   AND language_id(+) = ?) pract_name,(SELECT DEF_ISSUE_UOM DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE EFF_STATUS = 'E' AND ITEM_CODE = A.ITEM_CODE AND STORE_CODE = ?) TO_STORE_DEF_ISSUE_UOM,PH_GETLOCN_NAME (C.PATIENT_CLASS, C.LOCN_CODE, n.ORDERING_FACILITY_ID ,?) PH_GETLOCN_NAME,L.APPL_USER_NAME RETURNED_BY,M.REASON_DESC RETURN_REASON,K.RET_DOC_NO, K.RET_DOC_LINE_NO,J.RETURN_REASON RETURN_REASON_CODE, to_char(K.MODIFIED_DATE , 'DD/MM/YYYY HH24:MI:SSSSS') MODIFIED_DATE,(SELECT barcode_id FROM st_sal_dtl_exp WHERE facility_id = a.facility_id AND doc_no = c.doc_no AND item_code =a.item_code AND batch_id = a.batch_id AND store_code = a.store_code AND expiry_date_or_receipt_date = a.expiry_date AND bin_location_code = a.bin_location_code and doc_srl_no=b.doc_srl_no ) barcode_id,a.DISP_QTY_UOM FROM (SELECT DRUG_DESC DRUG_DESC, DRUG_CODE DRUG_CODE,NVL (CONTENT_IN_PRES_BASE_UOM, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_DRUG_LANG_VW WHERE LANGUAGE_ID =?  UNION SELECT NVL (SHORT_NAME, LONG_NAME) DRUG_DESC,TPN_REGIMEN_CODE DRUG_CODE,NVL (CONTENT_IN_BASE_UNIT, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_TPN_REGIMEN_LANG_VW WHERE STANDARD_REGIMEN_YN = 'Y'  AND LANGUAGE_ID = ?) D,PH_DISP_DRUG_BATCH A,PH_DISP_DTL B,PH_DISP_HDR C,MP_PATIENT E,PH_DISP_LOCN_LANG_VW G, OR_ORDER_LINE H,PH_WARD_RETURN_HDR J,PH_WARD_RETURN_DTL K,SM_APPL_USER_LANG_VW L,PH_MEDN_TRN_REASON_LANG_VW M,OR_ORDER N ,st_item O WHERE   A.DISP_NO = B.DISP_NO AND A.SRL_NO = B.SRL_NO and e.patient_id = n.patient_id  AND a.facility_id =b.facility_id  AND C.DISP_NO = B.DISP_NO AND B.DISP_DRUG_CODE = D.DRUG_CODE and c.order_id =n.order_id  and n.ORDERING_FACILITY_ID  =? AND E.PATIENT_ID = ? and n.order_category='PH' AND C.PATIENT_ID =J.PATIENT_ID AND C.DISP_NO =J.DISP_NO AND J.RET_TO_DISP_LOCN_CODE =? AND J.FACILITY_ID=K.FACILITY_ID AND J.RET_DOC_NO=K.RET_DOC_NO AND J.DISP_NO   =K.DISP_NO AND B.SRL_NO =K.SRL_NO AND A.SRL_NO_BATCH=K.SRL_NO_BATCH  and h.order_id = k.order_id  AND h.order_line_num = k.order_line_no AND k.disp_no between nvl(?,'!') and nvl(?,'~')  AND NVL(K.BAL_QTY,K.RETURNED_QTY) > 0 AND (K.STORE_ACKNOWLEDGE_STATUS ='P' OR K.STORE_ACKNOWLEDGE_STATUS IS NULL) AND J.ADDED_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY')+.99999 and c.disp_no = k.disp_no AND J.ADDED_BY_ID =L.APPL_USER_ID AND J.RETURN_REASON=M.REASON_CODE AND M.APPL_TRN_TYPE='T'";
				sql="SELECT  (SELECT drug_desc drug_desc FROM ph_drug_lang_vw WHERE language_id = ? AND drug_code = b.disp_drug_code UNION SELECT NVL (short_name, long_name) drug_desc FROM ph_tpn_regimen_lang_vw  WHERE STANDARD_REGIMEN_YN = 'Y'   AND language_id = ? AND tpn_regimen_code =b.disp_drug_code ) drug_desc,(SELECT short_name FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?)TRADE_NAME,(SELECT MANUFACTURER_ID FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?) MANUFACTURER_ID, DECODE (O.use_after_expiry_yn,'Y', 'Y','N',  (CASE WHEN (O.use_after_expiry_yn = 'N' AND EXPIRY_YN='N') then 'Y' WHEN greatest (sysdate, expiry_date) = sysdate then 'N' ELSE 'Y' END ))valid, C.DOC_TYPE, C.DOC_NO, A.STORE_CODE, A.ITEM_CODE, A.BIN_LOCATION_CODE, A.BATCH_ID, TO_CHAR (A.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE,A.TRADE_ID TRADE_ID, A.DISP_NO, A.SRL_NO, B.DOC_SRL_NO, A.SRL_NO_BATCH,TO_CHAR (B.ADDED_DATE, 'DD/MM/YYYY') ADDED_DATE, A.DISP_QTY ISSUEDQTY, B.DISP_UOM_CODE QTYUOM,NVL(K.BAL_QTY,K.RETURNED_QTY) RETURNABLE,C.ENCOUNTER_ID, B.ORDER_ID, B.ORDER_LINE_NO, B.ISSUE_QTY, B.ISSUE_UOM_CODE,N.DISCHARGE_IND,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = B.ISSUE_UOM_CODE AND LANGUAGE_ID = ?) SHORT_DESC,G.SHORT_DESC DISP_LOCN_NAME, H.ORDER_LINE_STATUS ORDER_LINE_STAUS,H.CAN_LINE_REASON DIS_CONT_REASON,TO_CHAR (H.DISC_DATE_TIME, 'DD/MM/YYYY HH24:MI') DISC_DATE_TIME,(select  short_name from am_practitioner_lang_vw where h.disc_pract_id = practitioner_id(+)   AND language_id(+) = ?) pract_name,(SELECT DEF_ISSUE_UOM DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE EFF_STATUS = 'E' AND ITEM_CODE = A.ITEM_CODE AND STORE_CODE = ?) TO_STORE_DEF_ISSUE_UOM,PH_GETLOCN_NAME (C.PATIENT_CLASS, C.LOCN_CODE, n.ORDERING_FACILITY_ID ,?) PH_GETLOCN_NAME,L.APPL_USER_NAME RETURNED_BY,M.REASON_DESC RETURN_REASON,K.RET_DOC_NO, K.RET_DOC_LINE_NO,J.RETURN_REASON RETURN_REASON_CODE, to_char(K.MODIFIED_DATE , 'DD/MM/YYYY HH24:MI:SSSSS') MODIFIED_DATE,(SELECT barcode_id FROM st_sal_dtl_exp WHERE facility_id = a.facility_id AND doc_no = c.doc_no AND item_code =a.item_code AND batch_id = a.batch_id AND store_code = a.store_code AND expiry_date_or_receipt_date = a.expiry_date AND bin_location_code = a.bin_location_code and doc_srl_no=b.doc_srl_no ) barcode_id,a.DISP_QTY_UOM FROM PH_DISP_DRUG_BATCH A,PH_DISP_DTL B,PH_DISP_HDR C,PH_DISP_LOCN_LANG_VW G, OR_ORDER_LINE H,PH_WARD_RETURN_HDR J,PH_WARD_RETURN_DTL K,SM_APPL_USER_LANG_VW L,PH_MEDN_TRN_REASON_LANG_VW M,OR_ORDER N ,st_item O WHERE   A.DISP_NO = B.DISP_NO AND A.SRL_NO = B.SRL_NO AND a.facility_id =b.facility_id  AND C.DISP_NO = B.DISP_NO and c.order_id =n.order_id  and n.ORDERING_FACILITY_ID  =? AND N.PATIENT_ID = ? and n.order_category='PH' AND C.PATIENT_ID =J.PATIENT_ID AND C.DISP_NO =J.DISP_NO AND J.RET_TO_DISP_LOCN_CODE =? AND J.FACILITY_ID=K.FACILITY_ID AND J.RET_DOC_NO=K.RET_DOC_NO AND J.DISP_NO   =K.DISP_NO AND B.SRL_NO =K.SRL_NO AND A.SRL_NO_BATCH=K.SRL_NO_BATCH  and h.order_id = k.order_id  AND h.order_line_num = k.order_line_no AND k.disp_no between nvl(?,'!') and nvl(?,'~')  AND NVL(K.BAL_QTY,K.RETURNED_QTY) > 0 AND (K.STORE_ACKNOWLEDGE_STATUS ='P' OR K.STORE_ACKNOWLEDGE_STATUS IS NULL) AND J.ADDED_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY')+.99999 and c.disp_no = k.disp_no AND J.ADDED_BY_ID =L.APPL_USER_ID AND J.RETURN_REASON=M.REASON_CODE AND M.APPL_TRN_TYPE='T'";  // 38214 -- KDAH-ICN-0029 - tuned for return medication (not used mp_patient and drug desc changed) - ravi,(SELECT MANUFACTURER_ID FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?) MANUFACTURER_ID Added for MOHE-CRF-0167
				//and e.patient_id = n.patient_id added  and and c.patient_id = e.patient_id is removed for performence issue 
				if(From_Location !=null && !From_Location.equals(""))//Adding start for KDAH Performence(Aissist id 	974547)
                     sql += " AND C.LOCN_CODE =NVL(?,C.LOCN_CODE)";//Adding end for KDAH Performence (Aissist id 	974547)KDAH-SCF-0467
			if(oldpatcat!=null && oldpatcat.equalsIgnoreCase("O"))  // Only for outpatient cutoff date AMS-CRF-0172 (condition based)
				sql += "AND A.ADDED_DATE >= TO_DATE (?, 'DD/MM/YYYY HH24:MI')";
//AND A.DISP_NO = NVL (?, A.DISP_NO)  removed
			sql += "AND A.FACILITY_ID = ?  AND C.ORDER_ID = NVL (?, C.ORDER_ID) ";//modified for  ICN 65168(7190)
			//ADDED FOR ICN 65168(7190)
			if(!dispno.equals(""))
				sql += " AND A.DISP_NO = ? ";
			//((( use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR( use_after_expiry_yn = 'N' AND EXPIRY_YN='N')) or  (USE_AFTER_EXPIRY_YN ='Y') ) MODIFIED FOR SKR-SCF-1256
			//sql+="	AND A.DISP_LOCN_CODE = NVL (?, A.DISP_LOCN_CODE) AND A.DISP_QTY <> NVL (A.RETURNED_QTY, 0) and a.item_code=O.item_code AND ((( O.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR( O.use_after_expiry_yn = 'N' AND EXPIRY_YN='N')) or  (O.USE_AFTER_EXPIRY_YN ='Y') ) AND A.STORE_CODE = G.DISP_LOCN_CODE AND A.FACILITY_ID = G.FACILITY_ID AND G.LANGUAGE_ID = ? AND H.ORDER_ID = B.ORDER_ID AND H.ORDER_LINE_NUM = B.ORDER_LINE_NO AND l.language_id =? AND m.language_id =? AND  B.DISP_DRUG_CODE=NVL(?,B.DISP_DRUG_CODE) AND c.ENCOUNTER_ID = Nvl(?,c.ENCOUNTER_ID) and c.patient_class in (?) order by D.DRUG_DESC,B.ADDED_DATE";//modified for  ICN 65168(7190)
			sql+="	AND A.DISP_LOCN_CODE = NVL (?, A.DISP_LOCN_CODE) AND A.DISP_QTY <> NVL (A.RETURNED_QTY, 0) and a.item_code=O.item_code AND ((( O.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR( O.use_after_expiry_yn = 'N' AND EXPIRY_YN='N')) or  (O.USE_AFTER_EXPIRY_YN ='Y') ) AND A.STORE_CODE = G.DISP_LOCN_CODE AND A.FACILITY_ID = G.FACILITY_ID AND G.LANGUAGE_ID = ? AND H.ORDER_ID = B.ORDER_ID AND H.ORDER_LINE_NUM = B.ORDER_LINE_NO AND l.language_id =? AND m.language_id =? AND  B.DISP_DRUG_CODE=NVL(?,B.DISP_DRUG_CODE) AND c.ENCOUNTER_ID = Nvl(?,c.ENCOUNTER_ID) and c.patient_class in (?) order by DRUG_DESC,B.ADDED_DATE";//modified for  ICN 65168(7190)  // removed d.drug_desc to drug_desc // 38214 -- KDAH-ICN-0029 - tuned for return medication (not used mp_patient and drug desc changed) - ravi
//	added "and c.patient_class in (?)" in the above "String sql" for SRR20056-SCF-7414, Incident No. 27456 
				         
			String doc_srl_no_sql="select doc_srl_no from  st_sal_dtl_exp  where facility_id = ? AND doc_type_code =? AND doc_no=? AND store_code = ? AND item_code = ? AND batch_id = ? and expiry_date_or_receipt_date = TO_DATE(?,'DD/MM/YYYY HH24:MI') AND bin_location_code =? AND trade_id =?";
			
			int cnt	=	1;
//	 fix for SRR20056-SCF-7414, Incident No. 27456 -Start
			
			if (patcat.equals("O"))	{
			  patcat = " 'OP', 'EM', 'XT'";
			}
			else if (patcat.equals("I")){
               patcat= " 'IP', 'DC'";
			}
			else{
               patcat = " 'XT' ";
			}
			int index	 =	sql.lastIndexOf('?');
			sql = sql.substring(0,index)+ patcat +sql.substring(index+1);
			//	 fix for SRR20056-SCF-7414, Incident No. 27456 - end
System.err.println("===========sql ward batchdetails==>"+sql+" this.orderingfacilityid="+this.orderingfacilityid);
			pstmt = connection.prepareStatement( sql) ;
			pstmt.setString(cnt,getLanguageId()); //KDAH-ICN-0029
			pstmt.setString(++cnt,getLanguageId()); //KDAH-ICN-0029
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());//Added for MOHE-CRF-0167
			pstmt.setString(++cnt,getLanguageId()); 
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,toStore.trim());
			//pstmt.setString(++cnt,getLanguageId());
			//pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,login_facility_id);//this.orderingfacilityid);
			pstmt.setString(++cnt,patientid.trim());
			pstmt.setString(++cnt,toStore.trim());
			pstmt.setString(++cnt,dispno.trim());//Added for GHL-SCF-1084
			pstmt.setString(++cnt,dispno.trim());//Added for GHL-SCF-1084
			pstmt.setString(++cnt,Ward_Date_From.trim());
			pstmt.setString(++cnt,ward_Date_To.trim());
			if(From_Location !=null && !From_Location.equals(""))//Added if condition for KDAH Performence (Aissist id 	974547)
			pstmt.setString(++cnt,From_Location.trim());
        	
			if(oldpatcat!=null && oldpatcat.equalsIgnoreCase("O"))  // Only for outpatient cutoff date AMS-CRF-0172 (condition based)
				pstmt.setString(++cnt,cutoff);  
			
			pstmt.setString(++cnt,login_facility_id.trim());			
		  
			pstmt.setString(++cnt,orderid.trim());
			//ADDED FOR ICN 65168(7190)
			if(!dispno.equals(""))	
			  pstmt.setString(++cnt,dispno.trim());
			
			pstmt.setString(++cnt,FormStore.trim());
			pstmt.setString(++cnt,getLanguageId());
			//pstmt.setString(++cnt,getLanguageId());//removed for GHL-SCF-1084
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,drugcode.trim());
			pstmt.setString(++cnt,encounter_id.trim());   //AMS-CRF-0172  (query also encounter id added)
			
            resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("DRUG_DESC"));	      //0	 
				result.add(resultSet.getString("VALID"));	          //1
				result.add(resultSet.getString("DOC_TYPE"));          //2
				result.add(resultSet.getString("DOC_NO"));		      //3
				result.add(resultSet.getString("STORE_CODE"));	      //4
				result.add(resultSet.getString("ITEM_CODE"));	      //5
				result.add(resultSet.getString("BIN_LOCATION_CODE"));  //6
				result.add(resultSet.getString("BATCH_ID"));	   //7
				result.add(resultSet.getString("EXPIRY_DATE"));	   //8
				result.add(resultSet.getString("TRADE_ID"));	   //9
				result.add(resultSet.getString("DISP_NO"));		   //10
				result.add(resultSet.getString("SRL_NO"));		   //11
				//result.add(resultSet.getString("DOC_SRL_NO"));	   //12
				doc_srl_no=resultSet.getString("DOC_SRL_NO")==null?"":resultSet.getString("DOC_SRL_NO");
				
				if(!doc_srl_no.equals("")){
				  result.add(doc_srl_no);
				}
				else{
					pstmt = connection.prepareStatement( doc_srl_no_sql) ;
					pstmt.setString(1,login_facility_id.trim());
					pstmt.setString(2,resultSet.getString("DOC_TYPE")==null?"":resultSet.getString("DOC_TYPE"));
					pstmt.setString(3,resultSet.getString("DOC_NO")==null?"":resultSet.getString("DOC_NO"));
					pstmt.setString(4,resultSet.getString("STORE_CODE")==null?"":resultSet.getString("STORE_CODE"));
					pstmt.setString(5,resultSet.getString("ITEM_CODE")==null?"":resultSet.getString("ITEM_CODE"));
					pstmt.setString(6,resultSet.getString("BATCH_ID")==null?"":resultSet.getString("BATCH_ID"));
					pstmt.setString(7,resultSet.getString("EXPIRY_DATE")==null?"":resultSet.getString("EXPIRY_DATE"));
					pstmt.setString(8,resultSet.getString("BIN_LOCATION_CODE")==null?"":resultSet.getString("BIN_LOCATION_CODE"));
					pstmt.setString(9,resultSet.getString("TRADE_ID")==null?"":resultSet.getString("TRADE_ID"));
					
					resultSet2 = pstmt.executeQuery() ;
					if( resultSet2.next() ) {		
						  result.add(resultSet2.getString("doc_srl_no"));
				   }
				}

				result.add(resultSet.getString("SRL_NO_BATCH"));   //13
				result.add(resultSet.getString("ADDED_DATE"));	   //14
				result.add(resultSet.getString("ISSUEDQTY"));	   //15
				result.add(resultSet.getString("QTYUOM"));		   //16
				result.add(resultSet.getString("RETURNABLE"));	   //17
				result.add(resultSet.getString("ENCOUNTER_ID"));   //18
				result.add(resultSet.getString("ORDER_ID"));	   //19
				result.add(resultSet.getString("ORDER_LINE_NO"));  //20
					
				result.add(resultSet.getString("ISSUE_QTY")==null?"":resultSet.getString("ISSUE_QTY"));	//21
				result.add(resultSet.getString("ISSUE_UOM_CODE")==null?"":resultSet.getString("ISSUE_UOM_CODE"));//22
					
				//result.add(resultSet.getString("ISSUE_QTY"));	   
				//result.add(resultSet.getString("ISSUE_UOM_CODE")); 
				result.add(resultSet.getString("SHORT_DESC"));	   //23
				result.add(resultSet.getString("DISP_LOCN_NAME"));    //24
				result.add(resultSet.getString("ORDER_LINE_STAUS"));  //25
				result.add(resultSet.getString("DIS_CONT_REASON"));	  //26
				result.add(resultSet.getString("DISC_DATE_TIME"));	  //27
				result.add(resultSet.getString("PRACT_NAME"));		  //28
				result.add(resultSet.getString("TO_STORE_DEF_ISSUE_UOM")); //29
				result.add(resultSet.getString("PH_GETLOCN_NAME"));		   //30
				result.add(resultSet.getString("RETURNED_BY"));			   //31
				result.add(resultSet.getString("RETURN_REASON"));		   //32
				result.add(resultSet.getString("RET_DOC_NO"));			   //33
				result.add(resultSet.getString("RET_DOC_LINE_NO"));		   //34
				result.add(resultSet.getString("RETURN_REASON_CODE"));	   //35
				result.add(resultSet.getString("TRADE_NAME"));//AMS-SCF-0190-IN038440.Flag Based query. Added Short_name on List. //36
				result.add(resultSet.getString("DISCHARGE_IND")); //37
				result.add(resultSet.getString("MODIFIED_DATE")); //Added for SKR-SCF-0393 [IN:030939] //38
				if(barcode_2d_applicable){//Adding start for MOHE-CRF-0167
					 String expiry_date =resultSet.getString("EXPIRY_DATE");
					 String barcode_id ="";
					 SimpleDateFormat inputFormat = new SimpleDateFormat("dd/mm/yyyy");
		             SimpleDateFormat outputFormat = new SimpleDateFormat("ddmmyyyy");
		             java.util.Date inputDate = inputFormat.parse(expiry_date); 
					 String temp_exp_date = outputFormat.format(inputDate);
					 if(include_exp_date_yn.equals("Y"))
					     barcode_id = "01"+ resultSet.getString("MANUFACTURER_ID")+"10"+resultSet.getString("BATCH_ID")+"[GS]17"+temp_exp_date;
					 else
						 barcode_id = "01"+ resultSet.getString("MANUFACTURER_ID")+"10"+resultSet.getString("BATCH_ID");
					 result.add(barcode_id); 
				 }else//Adding end for MOHE-CRF-0167
				     result.add(resultSet.getString("BARCODE_ID")); //Added for GHL-CRF-0413.8 //39
				result.add(resultSet.getString("DISP_QTY_UOM"));//added for ML-BRU-SCF-1842
				//setEncounter(resultSet.getString("ENCOUNTER_ID"));
			}
        }
		catch ( Exception e ) {
			e.printStackTrace();
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return result;
	}

	public String getCutOff(){
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String cutoff			= "";
//		 ArrayList result=new ArrayList();
        try {
            connection = getConnection() ;

			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT4") ) ;
			pstmt = connection.prepareStatement("SELECT TO_CHAR (SYSDATE - NVL (max_durn_for_op_med_rtn, 0),  'dd/mm/yyyy hh24:mi') cutoff,  TO_CHAR (SYSDATE, 'dd/mm/yyyy') curr_date  FROM ph_disp_locn  WHERE facility_id = ? and DISP_LOCN_CODE=?") ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,getLoginDispLocnCode());
            resultSet = pstmt.executeQuery() ;
            if ( resultSet.next() ) {
				cutoff=resultSet.getString("CUTOFF");
				setCurrDate(resultSet.getString("CURR_DATE"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			return e.toString();
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
		return cutoff;
	}

	public ArrayList getReturnRemarks(){
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList result		= new ArrayList();
        try {
            connection = getConnection() ;

			String sql=PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT6") ;

			pstmt = connection.prepareStatement( sql) ;
			pstmt.setString(1,getLanguageId());
            resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("REASON_CODE"));
				result.add(resultSet.getString("REASON_DESC"));
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
				es.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList getPatientDetails(String patientid)
	{
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		 ArrayList result		= new ArrayList();
        try {
            connection = getConnection() ;

			String sql=PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT8") ;
			pstmt = connection.prepareStatement( sql) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patientid);
            resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("PATIENT_NAME"));
				result.add(resultSet.getString("SEX"));
				result.add(resultSet.getString("AGE"));
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
				es.printStackTrace();
			}
		}
		return result;
	}

	// This method is used to retrieve the data depending on the query criteria
	public ArrayList getMedicationReport(String patient_id,String disp_no,String facility_id,String from,String to)throws Exception{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
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
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RETMEDICATION_SELECT1") );
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_no.trim());
			pstmt.setString(3,patient_id.trim());
			pstmt.setString(4,getLanguageId());
			pstmt.setString(5,getLanguageId());
			pstmt.setString(6,getLanguageId());
 
			resultSet = pstmt.executeQuery() ;
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
				if(i <= end ) {
					records.add(checkForNull(resultSet.getString("DISP_NO")));
					records.add(checkForNull(resultSet.getString("PATIENT_ID")));
					records.add(checkForNull(resultSet.getString("DRUG_DESC")));
					records.add(checkForNull(resultSet.getString("RETURNED_QTY")));
					records.add(checkForNull(resultSet.getString("RETURNED_DATE")));
					records.add(checkForNull(resultSet.getString("SHORT_DESC")));
					records.add(checkForNull(resultSet.getString("SOURCE")));
				}
			}
			if( start != 1 )
					prevnextlink = prevnextlink+"<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(disp_no)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink =prevnextlink+ "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(disp_no)+"')\">Next</a>" ;
				
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
		return records;
	}

	public String getPatient_ID(String disp_no)throws Exception{
		String patient_id	="";
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_HDR_SELECT") ) ;
			pstmt.setString(1,disp_no);
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				patient_id=resultSet.getString("patient_id") == null ? "":resultSet.getString("patient_id");
				
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
		return patient_id;
	}

	public String checkforbillinginterface(String patient_class)throws Exception{ //patient_class paramater added for SRR20056-SCF-7639 ICN027720
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet			    = null;	
		String  bl_interface_yn			= "N";
		String  disp_bill_stage			= "N";
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

			if(bl_interface_yn.equals("Y")) {
				closeStatement( pstmt_select ) ;
				closeResultSet( resultSet ) ;
				//pstmt_select = connection.prepareStatement( "select DISP_BILL_STAGE from ph_disp_locn where DISP_LOCN_CODE=? and FACILITY_ID=?") ;
				pstmt_select = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT155")) ;
				pstmt_select.setString(1,login_facility_id); //Parameters swaped(corrected) for AMRI-SCF-10030 [IN:042435], KAUH-SCF-0172 [IN:042993],  KDAH-SCF-0191 [IN:039992]
				pstmt_select.setString(2,getLoginDispLocnCode());
				resultSet				= pstmt_select.executeQuery();
				if (resultSet.next() ) {
					if(patient_class!=null && (patient_class.equals("OP") ||  patient_class.equals("O"))) // if block and else added for SRR20056-SCF-7639 ICN027720
						disp_bill_stage=resultSet.getString("DISP_BILL_STAGE_OP");
					else
						disp_bill_stage=resultSet.getString("DISP_BILL_STAGE");
					if(disp_bill_stage.equals("X")){
						bl_interface_yn="N";
					}
				}
			}
		}catch(Exception exception){
			
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
	
	public String getEncounterPatientClass(String encounter_id, String patient_id) throws Exception{ //patient_id added for [IN:035667] 
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String patient_class	= "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1")) ;
			
			pstmt.setString(1,this.orderingfacilityid);
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
/*============================variable uom==========================*/
	public HashMap getStoreDfltIssueUOMAndBaseUOM (String drug_code,String disp_locn_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		HashMap def_issue_uoms	= new HashMap();
		try {

            connection	= getConnection() ;
          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			pstmt		= connection.prepareStatement( "SELECT DEF_ISSUE_UOM,GEN_UOM_CODE FROM ST_ITEM_STORE a, mm_item b WHERE STOCK_ITEM_YN = 'Y' AND a.STORE_CODE = ? AND a.ITEM_CODE = ? AND a.EFF_STATUS = 'E'and b.EFF_STATUS='E' and a.item_code =b.item_code") ;

			pstmt.setString(1,disp_locn_code);
			pstmt.setString(2,drug_code);

            resultSet	= pstmt.executeQuery() ;
			
			if (resultSet.next()){
				def_issue_uoms.put("DEF_ISSUE_UOM",	checkForNull(resultSet.getString("DEF_ISSUE_UOM")));				
				def_issue_uoms.put("BASE_UOM",	checkForNull(resultSet.getString("GEN_UOM_CODE")));
				
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
		return def_issue_uoms;
	}

 public int  lcm(int frm_tmp, int to_tmp) {
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
}

public int getEqulValue (String item_code,String uom_code,String equl_uom_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		int eqvl_value			= 1;
		try {

            connection	= getConnection() ;
          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			//pstmt		= connection.prepareStatement( "select EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=? AND EFF_STATUS='E' ") ;
			pstmt		= connection.prepareStatement( "select PH_calculate_equl_val(ITEM_CODE,UOM_CODE,EQVL_UOM_CODE) EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=? AND EFF_STATUS='E' ") ;

			pstmt.setString(1,item_code);
			pstmt.setString(2,uom_code);
			pstmt.setString(3,equl_uom_code);
            resultSet	= pstmt.executeQuery() ;
			
			if (resultSet.next()){
				eqvl_value = resultSet.getInt("EQVL_VALUE");				
				
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
		return eqvl_value;
	}

	public String getISSUE_UOM_BY (){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		     issue_uom_by		= "";
		try {

            connection	= getConnection() ;
          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			pstmt		= connection.prepareStatement( "select ISSUE_UOM_BY from ph_param") ;			
            resultSet	= pstmt.executeQuery() ;			
			if (resultSet.next()){
				issue_uom_by = resultSet.getString("ISSUE_UOM_BY");			
				
			}
			
		}catch ( Exception e ) {
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
		return issue_uom_by;
	}

	public ArrayList getOrderingFacilityId(String p_user_name) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISPLOCN_SELECT" )) ;
			pstmt = connection.prepareStatement("SELECT B.FACILITY_ID FACILITY_ID,B.FACILITY_NAME FACILITY_NAME FROM SM_FACILITY_FOR_USER A, SM_FACILITY_PARAM_lang_vw B WHERE A.FACILITY_ID = B.FACILITY_ID AND B.STATUS ='E' AND APPL_USER_ID = ? AND B.LANGUAGE_ID= ?") ;
			pstmt.setString(1,p_user_name);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result.add(resultSet.getString("FACILITY_ID"));
				result.add(resultSet.getString("FACILITY_NAME"));
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return result;
	}

	public String getSysDate() {
		String to_day="";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_MEDN_ADMN_DATE_SELECT5" )) ;
			
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					to_day= resultSet.getString( "today" );
				}
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
			catch(Exception es) {es.printStackTrace();}
		}
		return to_day;
	}

	private HashMap getBaseAndIssueUOMQty(  String item_code, String store_code,String disp_qty, String disp_uom){
        Connection connection	= null;
		PreparedStatement pstmt             = null ;
        ResultSet resultSet                 = null ;
		String base_uom						= "";
		String def_store_uom				= "";
		int  base_to_disp_uom_equl_value	= 0;
		int  base_to_def_uom_equl_value		= 0;
		HashMap BaseAndIssueQTYDetail		= new HashMap();
		int base_qty						= 0;
		int issue_qty						= 0;
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement("SELECT DEF_ISSUE_UOM,GEN_UOM_CODE FROM ST_ITEM_STORE a, mm_item b WHERE STOCK_ITEM_YN = 'Y' AND a.STORE_CODE = ? AND a.ITEM_CODE = ? AND a.EFF_STATUS = 'E'and b.EFF_STATUS='E' and a.item_code =b.item_code");
			pstmt.setString(1,store_code);
			pstmt.setString(2,item_code);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				base_uom		=	resultSet.getString("GEN_UOM_CODE");
				def_store_uom	=	resultSet.getString("DEF_ISSUE_UOM");
			}
			base_to_disp_uom_equl_value	=	getEqulValue ( item_code, base_uom, disp_uom);
			base_to_def_uom_equl_value	=	getEqulValue ( item_code, base_uom, def_store_uom);
			//base_qty   =	Integer.parseInt(disp_qty)*(base_to_disp_uom_equl_value);// Commented for AAKH-SCF-0118 [IN:049583]
			base_qty   =	Integer.parseInt(disp_qty);// Added for AAKH-SCF-0118 [IN:049583] & [IN:050139]
			issue_qty = base_qty;	// Added for AAKH-SCF-0118 [IN:049583] [IN:050139]
			if(!disp_uom.equals(def_store_uom) )//if Added for AAKH-SCF-0118 [IN:049583] [IN:050139]
        		issue_qty  =	base_qty/base_to_def_uom_equl_value;
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
				closeConnection( connection );
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }
		return BaseAndIssueQTYDetail;
	}

	public void setBillingParams( String displocn, String patcat){//added for SRR20056-SCF-7639 ICN027720 -start
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
	    try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT155") ) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,displocn.trim());
            resultSet = pstmt.executeQuery() ;
            if ( resultSet.next() ) {
				if(patcat!=null && patcat.equals("O")){
					setDispCashCollStage(resultSet.getString("DISP_CASH_COLL_STAGE_OP")==null?"X":resultSet.getString("DISP_CASH_COLL_STAGE_OP"));
				}
				else{
					setDispCashCollStage(resultSet.getString("DISP_CASH_COLL_STAGE")==null?"X":resultSet.getString("DISP_CASH_COLL_STAGE"));
				}
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
	}//added for SRR20056-SCF-7639 ICN027720 -End


	//Below added for AMS-CRF-0172
	public ArrayList getEncounterIdDetails( String patient_id, String pat_cat){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		ArrayList EncounterIdList = new ArrayList();
		try{
			connection = getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RETMEDICATION_ENCOUNTER_SELECT"));
			pstmt.setString(1, patient_id);
			pstmt.setString(2, pat_cat);
			pstmt.setString(3, pat_cat);
			pstmt.setString(4, login_facility_id);
			pstmt.setString(5, patient_id);
			pstmt.setString(6, pat_cat);
			pstmt.setString(7, login_facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null){
				while(resultSet.next()){
					EncounterIdList.add(resultSet.getString("ENCOUNTER_ID"));
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
		return EncounterIdList;
	}

	public String getDefaultEncounterId(String patient_id){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	default_encounter_id	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RETMEDICATION_CURRENT_ENCOUNTER_SELECT") ) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, patient_id);
			
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				default_encounter_id	=	checkForNull(resultSet.getString("ENCOUNTER_ID"));
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
		return default_encounter_id;	
	}
	// Till here AMS-CRF-0172
/*====================================================================================================================*/
	
	//FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility - Added New Method to Facility Flag for MultiFacility Functionality - Start 
	public String getEffectiveFlag(String function_id,String crit_field_id){ //AMS-SCF-0190-IN038440 Changed to Parameterized method.
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	flag	=	"" ;
		try{
			String sql="select CRIT_FIELD_VAL from PH_DISP_MEDN_DFLT WHERE FUNCTION_ID=? and FACILITY_ID = DECODE(?, FACILITY_ID, FACILITY_ID,'*A')  and CRIT_FIELD_ID=?";
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(sql) ;
			//pstmt.setString(1,"RETNMEDN");
			pstmt.setString(1,function_id);
			pstmt.setString(2,login_facility_id.trim());
			//pstmt.setString(3,"RETNMEDNMF");
			pstmt.setString(3,crit_field_id);
			
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				flag	=	checkForNull(resultSet.getString("CRIT_FIELD_VAL"));
			}	
			else{
				flag="";
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
		return flag;	
	}//FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility - Added New Method to Facility Flag for MultiFacility Functionality - Start

	public String getMednRtnBillGen(String disp_locn_code, String patient_class){ //added for JD-CRF-0178 [IN:039208]
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	medn_rtn_after_bill_gen	=	"" ;

		try{
			String sql="select IP_MEDN_RTN_AFTER_BILL_GEN , OP_MEDN_RTN_AFTER_BILL_GEN from ph_disp_rights where facility_id=? and appl_user_id=? and disp_locn_code = ?";
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(sql) ;
			
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,login_by_id);
			pstmt.setString(3,disp_locn_code);
			
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ){
				if(patient_class.equals("I"))
					medn_rtn_after_bill_gen = checkForNull(resultSet.getString("IP_MEDN_RTN_AFTER_BILL_GEN"));
				else
					medn_rtn_after_bill_gen = checkForNull(resultSet.getString("OP_MEDN_RTN_AFTER_BILL_GEN"));
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
		return medn_rtn_after_bill_gen;	
	}

	public boolean getBillGenStatus(String patient_id, String ordering_facility_id, String episode_id ){  
		boolean bill_gen_yn 	= false;
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String discharge_bill_gen_ind = "";
		try {
            connection	= getConnection() ;			
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SELECT_DISCHARGE_BILL_GEN_IND")) ;				
			pstmt.setString(1,patient_id);
			pstmt.setString(2,ordering_facility_id);
			pstmt.setString(3,episode_id);
			
            resultSet	= pstmt.executeQuery() ;			
			if (resultSet.next()){
				discharge_bill_gen_ind = checkForNull(resultSet.getString("discharge_bill_gen_ind"));
			}
			if(discharge_bill_gen_ind.equals("Y"))
				bill_gen_yn = true;				
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
		return bill_gen_yn;
	}
	private void getBillingUpdateLock(Connection connection,String login_facility_id,String patient_id ,String encounter_id ) throws Exception{//added for KDAH-SCF-0322
		  
		HashMap message_bill = new HashMap();

		String msg = "";
//		String hmResult = "";  Removed for IN063877

		String episode_id = "";
		String visit_id = "";
		CallableStatement callableStatement = null;
		String sal_trn_type = "";
		sal_trn_type = getEncounterPatientClass(encounter_id, patient_id); 
		if(!sal_trn_type.equals("I") && !sal_trn_type.equals("D")){
		if (!encounter_id.equals("") && !encounter_id.equals(null)) {
			episode_id = encounter_id.substring(0, (encounter_id.length() - 4)); 
			visit_id = encounter_id.substring(encounter_id.length() - 4); 
		}
		}else{
			episode_id = encounter_id;
			visit_id = "";
		}
		try {
			
			callableStatement = connection.prepareCall("{ call Blcommon.bl_proc_upd_lock (?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, login_facility_id);
			callableStatement.setString(2, patient_id);
			callableStatement.setString(3, sal_trn_type);
			callableStatement.setString(4, episode_id);
			callableStatement.setString(5, visit_id);
			callableStatement.registerOutParameter(6, Types.VARCHAR);
			callableStatement.registerOutParameter(7, Types.VARCHAR);
			callableStatement.registerOutParameter(8, Types.VARCHAR);
			callableStatement.execute();

			message_bill.put("error_level",
					(String) callableStatement.getString(6));
			message_bill.put("sys_message_id",
					(String) callableStatement.getString(7));
			String err_text = (String) callableStatement.getString(8) == null ? ""
					: (String) callableStatement.getString(8);
			message_bill.put("error_id_txt", err_text);

			if ((checkForNull((String) message_bill.get("error_id_txt"))) != "") {
				if("BL9945".equals((checkForNull((String) message_bill.get("sys_message_id")))) || "BL9945".equals((checkForNull((String) message_bill.get("error_level")))))
						msg =  getMessage(getLanguageId(),(String) message_bill.get( "sys_message_id"),"BL");
				throw new Exception(msg);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(msg);
		} finally {
			try {
				closeStatement(callableStatement);
			} catch (Exception es) {
				es.printStackTrace();
			}
			callableStatement = null;
		}
		
}
	
	public boolean getBillUserForCashCounter( ){  
		boolean bill_gen_yn 	= false;
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
//		String discharge_bill_gen_ind = "";  Removed for IN063877
		try {
            connection	= getConnection() ;			
			pstmt		= connection.prepareStatement("SELECT 1 FROM bl_users_for_cash_counter WHERE operating_facility_id =? AND cash_counter_user_id =? AND NVL (status, 'N') <> 'S'") ;				
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,login_by_id);
			
            resultSet	= pstmt.executeQuery() ;			
			if (resultSet.next()){
				bill_gen_yn = true;		
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
		return bill_gen_yn;
	}
	public ArrayList getDischargeStage(String facilityId, String encounterId,String patientId) {  // Added for GHL-CRF-0412.3 - Start
		ArrayList result  = 	new ArrayList();;
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
        try {
            connection = getConnection() ;

			String sql="SELECT a.pre_dis_initiate_yn, a.oth_adt_status, b.ret_medic_restr_stage FROM ip_open_encounter a,ph_facility_param b WHERE a.encounter_id =? AND a.facility_id =? AND a.patient_id =? AND a.facility_id = b.facility_id";
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1,encounterId);
			pstmt.setString(2,facilityId);
			pstmt.setString(3,patientId);
            resultSet = pstmt.executeQuery();
            while ( resultSet.next() ) {
            	result.add(resultSet.getString("PRE_DIS_INITIATE_YN")==null?"":resultSet.getString("PRE_DIS_INITIATE_YN"));
				result.add(resultSet.getString("OTH_ADT_STATUS")==null?"":resultSet.getString("OTH_ADT_STATUS"));
				result.add(resultSet.getString("RET_MEDIC_RESTR_STAGE")==null?"":resultSet.getString("RET_MEDIC_RESTR_STAGE"));
			}
            if(result.size()==0){
            	sql="select a.adt_status,b.ret_medic_restr_stage from pr_encounter a,ph_facility_param b WHERE a.encounter_id =? AND a.facility_id =? AND a.patient_id =? AND a.facility_id = b.facility_id";
            	pstmt = connection.prepareStatement(sql) ;
    			pstmt.setString(1,encounterId);
    			pstmt.setString(2,facilityId);
    			pstmt.setString(3,patientId);
                resultSet = pstmt.executeQuery();
                
                while ( resultSet.next() ) {
    				result.add(resultSet.getString("ADT_STATUS")==null?"":resultSet.getString("ADT_STATUS"));
    				result.add(resultSet.getString("RET_MEDIC_RESTR_STAGE")==null?"":resultSet.getString("RET_MEDIC_RESTR_STAGE"));
    			}
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
    }	 // Added for GHL-CRF-0412.3 - End
	public String getBarCodeflag(String facilityid,String disp_locn){ // Added for GHL-CRF-0413.8 -Start
	    Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null;
		String barcodeflg	= "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("select bar_code_scan_yn from ph_disp_locn where facility_id=? and disp_locn_code=? ");
			pstmt.setString(1,facilityid);
			pstmt.setString(2,disp_locn);
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
			    barcodeflg = resultSet.getString("bar_code_scan_yn") == null ? "N":resultSet.getString("bar_code_scan_yn");
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
			return barcodeflg;
		}
	} // Added for GHL-CRF-0413.8 -End
	//Added for GHL-CRF-0413.8 start
	public ArrayList getbatchdetailWithCodeFunction(String patientid,String drugcodes,String nationalid,String healthcard,String dispno,String cutoff,String orderid,String displocn,String patcat,String toStore, String encounter_id,String FacilityFlag, String blDocType, String blDocNo,String barcode){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		PreparedStatement pstmt1= null;
        ResultSet resultSet1	= null;
        ResultSet resultSet2	= null;
		String doc_srl_no       =""; 
		boolean flag_empty_temp=false;
		
		HashMap bat_admin_qty  = new HashMap();
		int tot_admin_qty		=	0; 
		int returnable         =   0;
		String oldpatcat = patcat;
		
		
		ArrayList result_using_barcode		= new ArrayList();
//		ArrayList tempnewBarcodeArry =new ArrayList();  Removed for IN063877
		ArrayList exsiting_records=getNewBarcodeArry();
		
		try {
System.err.println("newBarcodeArry===="+newBarcodeArry+"barcode@@@===="+barcode);
         
			getTokenSeries(patcat); // patcat added for SRR20056-SCF-7639 ICN027720 -start
			setBillingParams(toStore, patcat); //added for SRR20056-SCF-7639 ICN027720 -start
			connection = getConnection() ;
			StringBuffer	sbsql = new StringBuffer("SELECT d.drug_desc,(SELECT short_name FROM am_trade_name_lang_vw WHERE trade_id = a.trade_id AND language_id = ?) TRADE_NAME, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date, a.trade_id trade_id, a.disp_no, a.facility_id facility_id, a.srl_no, b.doc_srl_no, a.srl_no_batch, TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date, a.disp_qty issuedqty, b.disp_uom_code qtyuom, a.disp_qty - ( NVL (a.returned_qty, 0) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ) + NVL ((SELECT SUM (returned_qty) FROM ph_ward_return_dtl WHERE disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch AND store_acknowledge_status IS NULL), 0 ) ) returnable, NVL ( a.returned_qty + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ) , 0 ) returnedqty, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = b.issue_uom_code AND language_id = ?) short_desc, (select short_desc from ph_disp_locn_lang_vw where disp_locn_code= s.store_code AND language_id = ? ) disp_locn_name, h.order_line_status order_line_staus, h.can_line_reason dis_cont_reason, TO_CHAR (h.disc_date_time, 'dd/mm/yyyy hh24:mi') disc_date_time, (SELECT def_issue_uom def_issue_uom FROM st_item_store WHERE eff_status = 'E' AND item_code = a.item_code AND store_code = ?) to_store_def_issue_uom, am_get_desc.AM_PRACTITIONER(disc_pract_id,?,1) pract_name, ord.ORDERING_FACILITY_ID,  b.facility_id return_facility,ord.DISCHARGE_IND,st.barcode_id,a.disp_qty_uom FROM (SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom FROM ph_drug_lang_vw WHERE language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, NVL (content_in_base_unit, 1) content_in_pres_base_uom FROM ph_tpn_regimen_lang_vw WHERE standard_regimen_yn = 'Y' AND language_id = ? ) d, ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, mp_patient e, or_order_line h, st_item j, st_sal_hdr k, st_item_store s, or_order ord,st_batch_control st WHERE h.order_id = ord.order_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = a.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.patient_id = e.patient_id AND a.store_code = s.store_code AND a.item_code = s.item_code AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND e.patient_id = ?  "); //and k.FINALIZED_YN = 'Y' removed for AMS-SCF-0042 IN[30932] & SKR-SCF-0359 IN[30057]  //Added - tuned as above sql for  [IN:031364] added ord.DISCHARGE_IND for skr-scf0591//disp_no = a.disp_no changed to disp_no = b.disp_no for GHL-SCF-1084, a.disp_qty_uom added for MMS-DM-CRF-0174.4
			
			if(oldpatcat!=null && oldpatcat.equalsIgnoreCase("O"))  // Only for outpatient cutoff date AMS-CRF-0172 (condition based)
				sbsql.append( " AND a.added_date >= TO_DATE (?, 'dd/mm/yyyy hh24:mi') ");
			
			if(orderid!=null && !orderid.equals("") ) 
				sbsql.append(" AND c.order_id = ? ");
			if(dispno!=null && !dispno.equals(""))
					sbsql.append(" AND a.disp_no = ? ");
			//((( use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR( use_after_expiry_yn = 'N' AND EXPIRY_YN='N')) or  (USE_AFTER_EXPIRY_YN ='Y') ) modifoed for skr-scf-1256
			sbsql.append(" AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND ((( j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR( j.use_after_expiry_yn = 'N' AND EXPIRY_YN='N')) or  (j.USE_AFTER_EXPIRY_YN ='Y') )AND h.order_id = b.order_id AND h.order_line_num = b.order_line_no  ");
			if(encounter_id!= null && !encounter_id.equals(""))
				sbsql.append(" AND c.encounter_id = ? ");
			sbsql.append("  AND c.patient_class IN (?) ");
					
			String sql2="select  sum((CASE WHEN c.DOSAGE_TYPE ='S' THEN ceil((sum(b.ADMIN_DOSAGE_QTY)/d.STRENGTH_VALUE)/d.CONTENT_IN_PRES_BASE_UOM ) ELSE ceil(sum(b.ADMIN_DOSAGE_QTY)/d.CONTENT_IN_PRES_BASE_UOM) END )) tot_admin_qty from ph_medn_admin a ,ph_medn_admin_dtl b,or_order_line_ph c ,(SELECT drug_desc drug_desc, drug_code drug_code,NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom,strength_value  FROM ph_drug_lang_vw  WHERE language_id = ? and drug_code = ? UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code,   NVL (content_in_base_unit, 1) content_in_pres_base_uom,1 strength_value FROM ph_tpn_regimen_lang_vw WHERE standard_regimen_yn = 'Y' AND language_id = ? and TPN_REGIMEN_CODE =? ) d where   a.ENCOUNTER_ID=b.ENCOUNTER_ID  AND a.facility_id = b.facility_id and a.ORD_DRUG_CODE=b.ORD_DRUG_CODE  and a.sch_date_time = b.sch_date_time and a.order_id=b.order_id  and a.DOSAGE_SEQ_NO =b.DOSAGE_SEQ_NO and a.order_id=? and a. ORDER_LINE_NUM =?   and a.order_id =c.order_id  and a.ORDER_LINE_NUM  =c.ORDER_LINE_NUM and a.ADMIN_RECORDED_YN ='Y' and b.item_code=? and BATCH_ID =?and EXPIRY_DATE=to_date(?,'dd/mm/yyyy')  and TRADE_ID =?  and b.ADMIN_DRUG_CODE =d.drug_code  group by BATCH_ID, EXPIRY_DATE, TRADE_ID ,b.ADMIN_DOSAGE_QTY ,c.DOSAGE_TYPE,d.STRENGTH_VALUE, d.CONTENT_IN_PRES_BASE_UOM ";
		//AND a.facility_id = b.facility_id added for performance
		   String doc_srl_no_sql="select doc_srl_no from  st_sal_dtl_exp  where doc_type_code =? AND doc_no=? AND store_code = ? AND item_code = ? AND batch_id = ? and expiry_date_or_receipt_date = TO_DATE(?,'DD/MM/YYYY HH24:MI') AND bin_location_code =? AND trade_id =?";

		   pstmt1= connection.prepareStatement( sql2) ;
			
			//StringTokenizer drugCodeToken = new StringTokenizer(drugcodes, ","); //Commented for common-icn-0048
//			int drugcounter=drugCodeToken.countTokens();  Removed for IN063877
        
        	 sbsql.append("AND b.disp_drug_code =NVL('',b.disp_drug_code)"); 
         
             int cnt	=	1;
			
			if (patcat.equals("O"))	{
				patcat = " 'OP', 'EM', 'XT'";
			}
			else if (patcat.equals("I")){
				patcat= " 'IP', 'DC'";
			}
			else{
				patcat = " 'XT' ";
			}
			String sql = sbsql.toString();
			int index	 =	sql.lastIndexOf('?');
			sql = sql.substring(0,index)+ patcat +sql.substring(index+1);
			sbsql.delete(0, sbsql.length());
			sbsql.append(sql);
			if(blDocType!=null && !blDocType.equals("") && blDocNo!=null && !blDocNo.equals(""))//added for MMS-DM-CRF-0039 [IN:055958]
				sbsql.append(" and (c.doc_type || '-'|| c.doc_no) in ( select PRIMARY_KEY_MAIN from bl_patient_charges_folio where PRIMARY_KEY_MODULE_ID = 'PH' and patient_id = ? and BILL_DOC_TYPE_CODE = ? and BILL_DOC_NUM = ? ) ");
			HashMap BatchDetails   = new HashMap();//Adding start for MOHE-CRF-0167
	        String  gtin           = ""; 
	        String batch_id        = "";
			String expiry_date     = "";
			HashMap siteValues =new HashMap();
			String include_exp_date_yn ="N";
			boolean barcode_2d_applicable = eCommon.Common.CommonBean.isSiteSpecific(connection, "ST","2D_BARCODE_APPLICABLE"); //added for MOHE-CRF-0167

			
			if(barcode_2d_applicable && !barcode.equals("")){
				siteValues =eCommon.Common.CommonBean.getSiteSpecificDetails(connection, "ST","2D_BARCODE_APPLICABLE");	
	             BatchDetails =getBarcodedetails(barcode);
	             gtin =(String)BatchDetails.get("GTIN")==null?"":(String)BatchDetails.get("GTIN");
                 batch_id =(String)BatchDetails.get("BATCH_ID")==null?"":(String)BatchDetails.get("BATCH_ID");
				 if(siteValues.containsKey("key1"))
					  include_exp_date_yn =(String)siteValues.get("value1");
				 expiry_date = (String)BatchDetails.get("EXPIRY_DATE")==null?"":(String)BatchDetails.get("EXPIRY_DATE");

				 if(include_exp_date_yn.equals("Y")){
				 expiry_date = (String)BatchDetails.get("EXPIRY_DATE")==null?"":(String)BatchDetails.get("EXPIRY_DATE");
System.err.println("expiry_date@@@==="+expiry_date);
				 SimpleDateFormat inputFormat = new SimpleDateFormat("ddmmyyyy");
		         SimpleDateFormat outputFormat = new SimpleDateFormat("dd/mm/yyyy");
		         java.util.Date inputDate = inputFormat.parse(expiry_date); 

		         String temp_exp_date = outputFormat.format(inputDate);

				      sbsql.append(" and a.batch_id ='"+batch_id +"' and a.EXPIRY_DATE = to_date('"+temp_exp_date +"','dd/mm/yyyy')  and st.item_code =a.item_code and st.batch_id=a.batch_id and st.EXPIRY_DATE_OR_RECEIPT_DATE=a.EXPIRY_DATE ");
			   }else{
				       sbsql.append(" and a.batch_id ='"+batch_id +"' and st.item_code =a.item_code and st.batch_id=a.batch_id and st.EXPIRY_DATE_OR_RECEIPT_DATE=a.EXPIRY_DATE ");
			   }
			}else{//Adding end for MOHE-CRF-0167
				sbsql.append("and st.barcode_id=? and st.item_code =a.item_code and st.batch_id=a.batch_id and st.EXPIRY_DATE_OR_RECEIPT_DATE=a.EXPIRY_DATE");
			}
			
			sbsql.append(" order by d.drug_desc , a.disp_no");
            System.out.println("query"+sbsql);
			pstmt = connection.prepareStatement( sbsql.toString()) ;
			pstmt.setString(cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId()); //added forAMS-SCF-0190 IN038440.
			pstmt.setString(++cnt,getLanguageId()); //added for [IN:031364] - tuned sql
			pstmt.setString(++cnt,toStore.trim());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId()); 
			pstmt.setString(++cnt,patientid.trim());

			if(oldpatcat!=null && oldpatcat.equalsIgnoreCase("O")) 
				pstmt.setString(++cnt,cutoff);	
			
			if(orderid!=null && !orderid.equals("") )
				pstmt.setString(++cnt,orderid.trim());
			if(dispno!=null && !dispno.equals(""))
				pstmt.setString(++cnt,dispno.trim());
			if(encounter_id!= null && !encounter_id.equals(""))
				pstmt.setString(++cnt,encounter_id.trim());  
			if(blDocType!=null && !blDocType.equals("") && blDocNo!=null && !blDocNo.equals("")){ 
				pstmt.setString(++cnt, patientid.trim());
				pstmt.setString(++cnt, blDocType); 
				pstmt.setString(++cnt, blDocNo); 
			}
			if(!barcode_2d_applicable)//Added for MOHE-CRF-0167
			     pstmt.setString(++cnt, barcode);
			
			resultSet = pstmt.executeQuery() ;
			
			while ( resultSet.next() ) {
				
				flag_empty_temp=true;
				result_using_barcode.add(resultSet.getString("DRUG_DESC"));	//1
				result_using_barcode.add(resultSet.getString("BATCH_ID"));
				result_using_barcode.add(resultSet.getString("EXPIRY_DATE"));
				result_using_barcode.add(resultSet.getString("DISP_NO"));
				result_using_barcode.add(resultSet.getString("ADDED_DATE"));	//5
				result_using_barcode.add(resultSet.getString("ISSUEDQTY"));
				result_using_barcode.add(resultSet.getString("QTYUOM"));
				result_using_barcode.add(resultSet.getString("RETURNEDQTY"));
				result_using_barcode.add(resultSet.getString("RETURNABLE"));
				result_using_barcode.add(resultSet.getString("SRL_NO"));	//10
				result_using_barcode.add(resultSet.getString("SRL_NO_BATCH"));
				result_using_barcode.add(resultSet.getString("VALID"));
				result_using_barcode.add(resultSet.getString("DOC_TYPE"));
				result_using_barcode.add(resultSet.getString("DOC_NO"));
				result_using_barcode.add(resultSet.getString("STORE_CODE"));	//15
				result_using_barcode.add(resultSet.getString("ITEM_CODE"));
				result_using_barcode.add(resultSet.getString("BIN_LOCATION_CODE"));
				//result.add(resultSet.getString("doc_srl_no"));
				
				doc_srl_no=resultSet.getString("doc_srl_no")==null?"":resultSet.getString("doc_srl_no");

				if(!doc_srl_no.equals("")){
					result_using_barcode.add(doc_srl_no);
				}
				else{
				
					pstmt = connection.prepareStatement( doc_srl_no_sql) ;
									
					pstmt.setString(1,resultSet.getString("DOC_TYPE")==null?"":resultSet.getString("DOC_TYPE"));
					pstmt.setString(2,resultSet.getString("DOC_NO")==null?"":resultSet.getString("DOC_NO"));
					pstmt.setString(3,resultSet.getString("STORE_CODE")==null?"":resultSet.getString("STORE_CODE"));
					pstmt.setString(4,resultSet.getString("ITEM_CODE")==null?"":resultSet.getString("ITEM_CODE"));
					pstmt.setString(5,resultSet.getString("BATCH_ID")==null?"":resultSet.getString("BATCH_ID"));
					pstmt.setString(6,resultSet.getString("EXPIRY_DATE")==null?"":resultSet.getString("EXPIRY_DATE"));
					pstmt.setString(7,resultSet.getString("BIN_LOCATION_CODE")==null?"":resultSet.getString("BIN_LOCATION_CODE"));
					pstmt.setString(8,resultSet.getString("TRADE_ID")==null?"":resultSet.getString("TRADE_ID"));
					
					resultSet2 = pstmt.executeQuery() ;
					if( resultSet2.next() ) {		
						result_using_barcode.add(resultSet2.getString("doc_srl_no"));
					}
					else
						result_using_barcode.add("");
				}				

				tot_admin_qty = 0;
				returnable    = Integer.parseInt(resultSet.getString("RETURNABLE"));
			   if(bat_admin_qty.containsKey(resultSet.getString("order_id")+resultSet.getString("order_line_no")+resultSet.getString("ITEM_CODE")+resultSet.getString("BATCH_ID")+resultSet.getString("EXPIRY_DATE")+resultSet.getString("trade_id")) ){
				 tot_admin_qty =Integer.parseInt((String)bat_admin_qty.get(resultSet.getString("order_id")+resultSet.getString("order_line_no")+resultSet.getString("ITEM_CODE")+resultSet.getString("BATCH_ID")+resultSet.getString("EXPIRY_DATE")+resultSet.getString("trade_id")));

				}
				else{
					pstmt1.setString(1,getLanguageId());
					pstmt1.setString(2,resultSet.getString("ITEM_CODE"));
					pstmt1.setString(3,getLanguageId());
					pstmt1.setString(4,resultSet.getString("ITEM_CODE"));
					pstmt1.setString(5,resultSet.getString("order_id"));
					pstmt1.setString(6,resultSet.getString("order_line_no"));
					pstmt1.setString(7,resultSet.getString("ITEM_CODE"));
					pstmt1.setString(8,resultSet.getString("BATCH_ID"));
					pstmt1.setString(9,resultSet.getString("EXPIRY_DATE"));
					pstmt1.setString(10,resultSet.getString("trade_id"));

					resultSet1 = pstmt1.executeQuery() ;
					while ( resultSet1.next() ) {                 
						tot_admin_qty =resultSet1.getInt("tot_admin_qty");	
					}
					closeResultSet( resultSet1 ) ;
				}

				if(tot_admin_qty >0){	
					 if(returnable <tot_admin_qty){
						 result_using_barcode.add("N");
						 result_using_barcode.add("0");
						 //tot_admin_qty =0;//commented for 26175
						 tot_admin_qty =tot_admin_qty - returnable;//added for 26175

					 }
					 else{
						returnable = returnable - tot_admin_qty;
						if(returnable <0){
							 tot_admin_qty = tot_admin_qty - returnable;
							 result_using_barcode.add("N");
							 result_using_barcode.add("0");
						}
						else{
							result_using_barcode.add("Y");
							result_using_barcode.add(returnable+"");
							 tot_admin_qty = 0;
							 tot_admin_qty =tot_admin_qty - returnable;//added for 26175
						}
					 }     
					 bat_admin_qty.put(resultSet.getString("order_id")+resultSet.getString("order_line_no")+resultSet.getString("ITEM_CODE")+resultSet.getString("BATCH_ID")+resultSet.getString("EXPIRY_DATE")+resultSet.getString("trade_id"),tot_admin_qty+"");
				 }
				 else{

					 result_using_barcode.add("Y");
					 result_using_barcode.add(returnable+"");
				 }
				result_using_barcode.add(resultSet.getString("ISSUE_QTY")==null?"":resultSet.getString("ISSUE_QTY")); //21
				result_using_barcode.add(resultSet.getString("ISSUE_UOM_CODE")==null?"":resultSet.getString("ISSUE_UOM_CODE")); 
				result_using_barcode.add(resultSet.getString("SHORT_DESC")==null?"":resultSet.getString("SHORT_DESC"));
				result_using_barcode.add(resultSet.getString("disp_locn_name")==null?"":resultSet.getString("disp_locn_name"));
				result_using_barcode.add(resultSet.getString("order_line_staus")==null?"":resultSet.getString("order_line_staus"));	//25
				result_using_barcode.add(resultSet.getString("dis_cont_reason")==null?"":resultSet.getString("dis_cont_reason"));
				result_using_barcode.add(resultSet.getString("DISC_DATE_TIME")==null?"":resultSet.getString("DISC_DATE_TIME"));
				result_using_barcode.add(resultSet.getString("pract_name")==null?"":resultSet.getString("pract_name"));
				result_using_barcode.add(resultSet.getString("TO_STORE_DEF_ISSUE_UOM")==null?"":resultSet.getString("TO_STORE_DEF_ISSUE_UOM"));
				result_using_barcode.add(resultSet.getString("trade_id")); 			    //30
				result_using_barcode.add(resultSet.getString("encounter_id")==null?"":resultSet.getString("encounter_id"));			   
				//setEncounter(resultSet.getString("ENCOUNTER_ID"));
				result_using_barcode.add(resultSet.getString("facility_id"));
				result_using_barcode.add(resultSet.getString("RETURN_FACILITY"));//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Setting Return Facility.
				result_using_barcode.add(resultSet.getString("TRADE_NAME"));//added for AMS-SCF-0190-IN038440.
				result_using_barcode.add(resultSet.getString("ORDERING_FACILITY_ID"));//added for Bru-HIMS-CRF-0297 Billing CRF
				result_using_barcode.add(resultSet.getString("DISCHARGE_IND"));
				result_using_barcode.add(resultSet.getString("ORDER_ID"));//Added for GHL-SCF-1084
				result_using_barcode.add(resultSet.getString("ORDER_LINE_NO"));//Added for GHL-SCF-1084
				if(barcode.equals("")){
					result_using_barcode.add("");
					result_using_barcode.add("");
					
				}
				else{
					result_using_barcode.add("");
					result_using_barcode.add(barcode);
				}
				//Added FOR MMS-DM-CRF-0174.4
				result_using_barcode.add(resultSet.getString("disp_qty_uom"));//Added for MMS-DM-CRF-0174.4
			} 
			setFlag_empty(flag_empty_temp);
			System.err.println("result_using_barcode@@@===="+result_using_barcode);
			//barcode_data.put(barcode,result_using_barcode);
			
			 if(exsiting_records.size()>0){
				 if(!exsiting_records.contains(barcode)){
				 for(int k=0;k<result_using_barcode.size();k++){
				 exsiting_records.add(result_using_barcode.get(k));
				  }
				 }
			 }else{
				 exsiting_records=result_using_barcode;
			 }
			setNewBarcodeArry(exsiting_records);
			}
		
		catch ( Exception e ) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		System.out.println("result"+result_using_barcode);
		
		return exsiting_records;
		
	}
	public void clearSavedList(){
		newBarcodeArry.clear();
	}
	//Added for GHL-CRF-0413.8 END
	//ADDED FOR MMS-KH-CRF-0014 START
		public String checkToProceed(String facility_id) {
		    	String result		= "";
				Connection connection	= null;
				PreparedStatement pstmt	= null;
				ResultSet resultSet		= null;
				try {
					connection = getConnection() ;
					pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_WRD_ACK_APPLICABLE_YN") ) ;
					pstmt.setString(1,facility_id.trim());
					resultSet = pstmt.executeQuery() ;
					if ( resultSet.next() ) {
						
						result=resultSet.getString("WARD_ACK_REQUIRED_YN")==null?"N":resultSet.getString("WARD_ACK_REQUIRED_YN");
						}
						closeStatement(pstmt);
					closeResultSet(resultSet);
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
					catch(Exception es) { es.printStackTrace();
				}
					}
		
				return result;
		}
		//ADDED FOR MMS-KH-CRF-0014 END
	public String getDispLocnBillStage(String disp_locn,String disp_no,String facility_id){ // added for KAUH-SCF-0320
	    Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null;
		PreparedStatement pstmt1 = null ;
		ResultSet resultSet1		= null;
		String patient_class	= "";
		String disp_bill_stage  = "";
		String disp_bill_stage_ip  = "";
		String disp_bill_stage_op  = "";
		try {
			connection = getConnection() ;
			
			pstmt = connection.prepareStatement("select distinct patient_class,DISP_LOCN_CODE from ph_disp_hdr where  facility_id=? and disp_no=? ");

			pstmt1 = connection.prepareStatement("select disp_bill_stage_op, disp_bill_stage from ph_disp_locn where  disp_locn_code=? ");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,disp_no);
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
			    patient_class = resultSet.getString("patient_class");
				disp_locn     = resultSet.getString("DISP_LOCN_CODE");
			}

			pstmt1.setString(1,disp_locn);
			resultSet1 = pstmt1.executeQuery();
			if(resultSet1 != null && resultSet1.next()) {
			    disp_bill_stage_op = resultSet1.getString("disp_bill_stage_op")==null?"":resultSet1.getString("disp_bill_stage_op");
				disp_bill_stage_ip = resultSet1.getString("disp_bill_stage")==null?"":resultSet1.getString("disp_bill_stage");
			}


			if(patient_class.equals("IP"))
				disp_bill_stage = disp_bill_stage_ip;
			else
				disp_bill_stage = disp_bill_stage_op;
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
			return disp_bill_stage;
		}
	}
	//added  for ghl-scf-1448 start
	public String getretunableqty( String dispNo, String binLocnCode, String storeCode, String orderId, String itemCode, String expieryDate,String batchId,String retDocNo,String retDocLineNo,String patientId){
		
	
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
       
		//String doc_srl_no       =""; //Commented for common-icn-0048
		String sql="";  //modified for common-icn-0048
		String result		= "";
		
		//String From_Location="";  //Commented for common-icn-0048
		
	int cnt=1;	
        try {	
            connection = getConnection() ;
					sql="SELECT NVL (k.bal_qty, k.returned_qty) returnable FROM (SELECT drug_desc drug_desc, drug_code drug_code,NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom  FROM ph_drug_lang_vw  WHERE language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc,tpn_regimen_code drug_code, NVL (content_in_base_unit, 1)ontent_in_pres_base_uom FROM ph_tpn_regimen_lang_vw  WHERE standard_regimen_yn = 'Y' AND language_id = ?) d,ph_disp_drug_batch a,ph_disp_dtl b,ph_disp_hdr c,       mp_patient e,ph_disp_locn_lang_vw g,or_order_line h,ph_ward_return_hdr j,ph_ward_return_dtl k,sm_appl_user_lang_vw l,ph_medn_trn_reason_lang_vw m,or_order n,       st_item o WHERE a.disp_no = b.disp_no   AND a.srl_no = b.srl_no   AND e.patient_id = n.patient_id   AND a.facility_id = b.facility_id   AND c.disp_no = b.disp_no   AND b.disp_drug_code = d.drug_code   AND c.order_id = n.order_id   AND n.ordering_facility_id = ?   AND e.patient_id = ?   AND n.order_category = 'PH'   AND c.patient_id = j.patient_id   AND c.disp_no = j.disp_no   AND j.ret_to_disp_locn_code = ?   AND j.facility_id = k.facility_id   AND j.ret_doc_no = k.ret_doc_no   AND j.disp_no = k.disp_no    AND b.srl_no = k.srl_no   AND a.srl_no_batch = k.srl_no_batch   AND h.order_id = k.order_id    AND h.order_line_num = k.order_line_no   AND NVL (k.bal_qty, k.returned_qty) > 0   AND (k.store_acknowledge_status = 'P' OR k.store_acknowledge_status IS NULL       )   AND c.disp_no = k.disp_no   AND j.added_by_id = l.appl_user_id   AND j.return_reason = m.reason_code   AND m.appl_trn_type = 'T'   AND a.facility_id = ?   AND c.order_id = NVL (?, c.order_id)   AND a.disp_no = ?   AND a.disp_locn_code = NVL (?, a.disp_locn_code)   AND a.disp_qty <> NVL (a.returned_qty, 0)   AND a.item_code = o.item_code AND (((o.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (o.use_after_expiry_yn = 'N' AND expiry_yn = 'N')) OR (o.use_after_expiry_yn = 'Y'))   AND a.store_code = g.disp_locn_code   AND a.facility_id = g.facility_id AND g.language_id = ? AND h.order_id = b.order_id AND h.order_line_num = b.order_line_no AND l.language_id = ? AND m.language_id = ? AND b.disp_drug_code = NVL (?, b.disp_drug_code) AND c.encounter_id = NVL (?, c.encounter_id) AND c.patient_class IN ('IP', 'DC') AND a.disp_no = ? AND a.bin_location_code = ? AND a.batch_id = ? AND a.expiry_date = TO_DATE (?, 'DD/MM/YYYY') AND a.item_code = ? AND a.store_code = ? AND k.ret_doc_no = ? AND k.ret_doc_line_no = ?";
			
			pstmt = connection.prepareStatement( sql) ;
			pstmt.setString(cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,login_facility_id);
			pstmt.setString(++cnt,patientId.trim());
			pstmt.setString(++cnt,storeCode.trim());
			pstmt.setString(++cnt,login_facility_id);
			pstmt.setString(++cnt,orderId.trim());
			pstmt.setString(++cnt,dispNo.trim());
			pstmt.setString(++cnt,storeCode.trim());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,itemCode);
			pstmt.setString(++cnt,encounter_id.trim()); 
			pstmt.setString(++cnt,dispNo.trim());
			pstmt.setString(++cnt,binLocnCode);
			pstmt.setString(++cnt,batchId);
			pstmt.setString(++cnt,expieryDate);
			pstmt.setString(++cnt,itemCode);
			pstmt.setString(++cnt,storeCode.trim());
			pstmt.setString(++cnt,retDocNo);
			pstmt.setString(++cnt,retDocLineNo);
			  resultSet = pstmt.executeQuery() ;
			  if(resultSet != null && resultSet.next()) {
				  result = resultSet.getString("returnable")==null?"0":resultSet.getString("returnable");
					
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
	//added  for ghl-scf-1448 end
}