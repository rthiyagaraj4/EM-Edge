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
4/12/2019	IN071721	    Shazana											SKR-SCF-1290
30/08/2020      IN073503        Manickavasagam J      SKR-SCF-1397
15/09/2020		IN:073832	        Manickavasagam J			     SKR-SCF-1421
29/11/2020		TFS:8023	        Manickavasagam J			     SKR-SCF-1487
31/01/2021		TFS:12662	        Manickavasagam J			     MMS-KH-CRF-0039
22/02/2021		TFS:9596	        Manickavasagam J			     ML-MMOH-SCF-1674
21/12/2021		TFS-26100           Prabha							 MMS-MD-SCF-0179
11/05/2023      43323           SREENADH.M               RAMESH.G    NMC-JD-CRF-0186
--------------------------------------------------------------------------------------------------------------------
*/ 
package ePH;
import java.io.Serializable ;       
import java.util.* ;
import java.sql.* ; 
import java.io.* ; 
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.MedicationAdministrationFT.*;
import java.text.SimpleDateFormat; //Added for MOHE-CRF-0167

public class MedicationAdministrationFTBean extends PhAdapter implements Serializable {
	
	private HashMap drug_remarks		= new HashMap();
	private HashMap stock_srl			= new HashMap();
	private	HashMap	adrDetails			= new HashMap();
	private HashMap adrReason			= new HashMap();
	private HashMap pres_mode			= new HashMap();
	private String	current_date_time	= "";
	private String	store_code			= "";
	private String	current_time		= "";
	private String	rec_admin_within_hrs= "";
	private String	future_time			= "";
	private String  today_date		    = "";	
	private String	today_date_time	    = "";
			String	locale				= "";
	private String	patient_class	    = "";
	private String	function_t			= "";
	private Hashtable batch_id_details	= new Hashtable();	
			Hashtable admin_drug_details= new Hashtable();	
	private ArrayList non_iv			= new ArrayList();
	private ArrayList iv				= new ArrayList();
	private ArrayList all_dtls			= new ArrayList();	
	private ArrayList OrderLineData		= new ArrayList();
	private ArrayList all_remarks		= new ArrayList();
	private ArrayList taperedRowNums	= new ArrayList();   //Added for RUT-CRF-0088 [IN036978]
	private String authUserId		= "";  //RUT-CRF-0035 [IN029926]
	public String userAuthPINReqYN	= "";  //RUT-CRF-0035 [IN029926]
	private HashMap hmDrugDetails = null;
	private HashMap hmAddedTaperSch = null;
	private HashMap alternateDrug  = new HashMap();//PMG2017-MMS-CRF-0002
	private HashMap patientClassForOrder = new HashMap();//GHL-CRF-0458
	private HashMap adminQty = new HashMap();//GHL-CRF-0458.1
	private HashMap barcodeMap = new HashMap();//GHL-CRF-509
	private HashMap	barcodeAvailableForItem = new HashMap();//GHL-CRF-509
	private HashMap patientDOB = new HashMap();//added for ARYU-SCF-023
	private HashMap batchIdforOrders = new HashMap();//GHL-CRF-0482
	private HashMap orderIDListForSameDrug = new HashMap();//GHL-CRF-0482
	private	HashMap manualBarcodeRemarks = new HashMap(); //Added for MMS-DM-CRF-0157.2

	private HashMap splitDoseYN = new HashMap();//Ml-MMOH-SCF-1439
	private  String	iv_prep_yn			= ""; //added for MMS-MD-SCF-0179
	
	public MedicationAdministrationFTBean() {
		 try {
			doCommon();
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
	}

/* Over-ridden Adapter methods start here */
	public void clear(){
		super.clear() ;
		all_remarks  =new ArrayList();
		batch_id_details =  new Hashtable();
		drug_remarks = new HashMap();
		adrDetails				=	new HashMap();
		adrReason				=	new HashMap();		
		non_iv					=   new ArrayList();
		function_t              ="";
		hmDrugDetails = null;
		hmAddedTaperSch = null;
		alternateDrug   = new HashMap();//PMG2017-MMS-CRF-0002
		patientClassForOrder = new HashMap();//GHL-CRF-0458
		adminQty = new HashMap();//GHL-CRF-0458.1
		barcodeMap = new HashMap();//GHL-CRF-509
		barcodeAvailableForItem = new HashMap();//GHL-CRF-509
		batchIdforOrders = new HashMap();//GHL-CRF-0482
		orderIDListForSameDrug = new HashMap();//GHL-CRF-0482
		splitDoseYN   = new HashMap();//ML-MMOH-SCF-1439
		manualBarcodeRemarks   =new HashMap();//Added for MMS-DM-CRF-0157.1
	}
	private void doCommon() throws Exception {
	}
/* Over-ridden Adapter methods start here */

	public boolean validateDrugRemarks(String drug_code,String row_no){
		if(drug_remarks.containsKey(drug_code+"$"+row_no)){
			return true;
		}
		else{
			return false;
		}
	}
	public HashMap getAddedTaperSch(){
		return this.hmAddedTaperSch;
	}
	public String getAddedTaperSch(String key){
		if(this.hmAddedTaperSch==null || !this.hmAddedTaperSch.containsKey(key))
			return "N";
		else
			return "Y";
	}

	public void setAddedTaperSch(HashMap hmAddedTaperSch){
		this.hmAddedTaperSch=hmAddedTaperSch;
	}

	public HashMap getDrugDetails(){
		return this.hmDrugDetails;
	}
//added forPMG2017-MMS-CRF-0002
	public void setAlternateDrugMAR(String order_id,String order_line_no,ArrayList multi_drugs){
			this.alternateDrug.put(order_id+""+order_line_no,multi_drugs);
	}

	public ArrayList getAlternateDrugMAR(String order_id,String order_line_no){
			return (ArrayList)alternateDrug.get(order_id+""+order_line_no);
	}
//added for PMG2017-MMS-CRF-0002

	//added for GHL-CRF-0458- start
	public void setOrderPatientClass(String order_id,String patient_class){
		this.patientClassForOrder.put(order_id,patient_class);
	}
	public String getOrderPatientClass(String order_id){
		return (String)patientClassForOrder.get(order_id);
	}
	//added for GHL-CRF-0458- end
	//added for GHL-CRF-509
	public void setBarcodeForItem(String order_id,String order_line_no,String barcode_avail_yn){
		this.barcodeMap.put(order_id+order_line_no,barcode_avail_yn);
	}
	public HashMap getBatchDetailsForItem(){
		return this.barcodeMap;
	}

	public HashMap getBarcodeAvailableForItem(){
		return this.barcodeAvailableForItem;
	}
	//added for GHL-CRF-509
	//added for ARYU-SCF-023 - start
	public void setPatientDOB(String patient_id,String dob){
		this.patientDOB.put(patient_id,dob);
	}
	public String getPatientDOB(String patient_id){
		return (String)patientDOB.get(patient_id);
	}
	//added for ARYU-SCF-023 - end
	public HashMap getBatchIdForOrders(){ //GHL-CRF-0482
	
		return batchIdforOrders;
	}
	//GHL-CRF-0482 - start
	public void setOrderIdListForSameDrug(HashMap orderIDList){
		this.orderIDListForSameDrug = orderIDList;
	}

	public HashMap getOrderIdListForSameDrug(){
	
	return orderIDListForSameDrug;
	}
//GHL-CRF-0482 - end
		
	public void clearDrugDetails(){
		this.hmDrugDetails = null;;
	}

	public void setDrugDetails(HashMap hmDrugDetails){
		this.hmDrugDetails=hmDrugDetails;
	}

	public String getFunctionT(){
		if(function_t==null){
			function_t="";
		}
		return this.function_t;
	}

	public void setFunctionT(String function_t){
		this.function_t = function_t;
	}
	public String getCurrentTime(){
		return this.current_time;
	}	//pres_mode

	public ArrayList getNonIvDetails(){
		return this.non_iv;
	}

	public void setNonIvDetails(ArrayList non_iv){
		this.non_iv=non_iv;
	}
	public String getPatientClass(){
		if(patient_class==null){
			patient_class="";
		}
		return this.patient_class;
	}

	public void setPatientClass(String patient_class){
		this.patient_class = patient_class;
	}

	public HashMap getPresMode(){
		return this.pres_mode;
	}

	public void setPresMode(HashMap pres_mode){
		this.pres_mode=pres_mode;
	}
	//ML-MMOH-SCF-1439 - start
public HashMap getSplitDoseYN(){
		return this.splitDoseYN;
	}

public void setSplitDoseYN(HashMap splitDoseYN){
		this.splitDoseYN=splitDoseYN;
	}
//ML-MMOH-SCF-1439 - end
//GHL-CRF-0458.1 - start
	public HashMap getAdminQty(){
		return this.adminQty;
	}

	public void setAdminQty(String order_id,String order_line_no,String drug_code,String qty){
		this.adminQty.put(order_id+order_line_no+drug_code,qty);
	}
//GHL-CRF-0458.1 - end
	public ArrayList getIvDetails(){
		return this.iv;
	}

	public void setIvDetails(ArrayList iv){
		this.iv=iv;
	}

	public void setOrderLineData(ArrayList orderLineData){
		this.OrderLineData=orderLineData;
	}

	public ArrayList getOrderLineData(){
		return this.OrderLineData;
	}
	public String getTodaysDateTime(){
		return this.today_date_time;
	}
	public String getTodaysDate(){
		return this.today_date ;
	}

	public String getUserAuthPINRequiredYN(){ //Added for RUT-CRF-0035 [IN029926] -start
		return this.userAuthPINReqYN;
	}

	public void setUserAuthPINRequiredYN(String userAuthPINReqYN){
		this.userAuthPINReqYN=userAuthPINReqYN;
	}
	
	public String getAuthUserID(){
		if(this.authUserId == null || this.authUserId.equals(""))
			return login_by_id;
		else
			return this.authUserId;
	}
	
	public HashMap getDrugDetails_Added(){   //Added for RUT-CRF-0088 [IN036978] --begin
		return this.hmDrugDetails;
	}

	public void setDrugDetails_Added(HashMap hmDrugDetails){
		this.hmDrugDetails=hmDrugDetails;
	}
	
	public ArrayList getTaperedRowNum(){
		return this.taperedRowNums;	
	}

	public void setTaperedRowNum(int taperedRowNums){
		this.taperedRowNums.add(taperedRowNums);
	}  //Added for RUT-CRF-0088 [IN036978] -- end
	//Added for MMS-DM-CRF-0157.1

	public void setManualBarcodeRemarks(HashMap barCodeRemakrs){
		manualBarcodeRemarks=barCodeRemakrs;
	}
	public HashMap getManualBarcodeRemarks()
	{
		return manualBarcodeRemarks;
	}
//Adding end for MMS-DM-CRF-0157.1
	

	public void setAuthUserID(String authUserId){
		this.authUserId=authUserId;
	}	//Added for RUT-CRF-0035 [IN029926] -end
	
	//added for MMS-MD-SCF-0179
	public String getIvprepYN() {
		return iv_prep_yn;
	}

	public void setIvprepYN(String iv_prep_yn) {
		this.iv_prep_yn = iv_prep_yn;
	}
	//added for MMS-MD-SCF-0179
	
	public String getFromDateTime(String current_time){
		String from_date_time	= "";
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		locale = getLanguageId();
		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT_FROM_DATE")) ;
			pstmt.setString(1,current_time);
			pstmt.setString(2,login_facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				from_date_time = resultSet.getString("FROM_DATE");
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
			}catch(Exception es){es.printStackTrace() ;}
		}
		if(!locale.equals("en"))
			from_date_time = com.ehis.util.DateUtils.convertDate(from_date_time, "DMYHM","en",locale);
		return from_date_time;
	}
	
	public String getAdiminWindowToDateTime(String current_time){
		String AdiminWindowToDateTime	= "";
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		locale = getLanguageId();
		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement("SELECT  TO_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')+((SELECT nvl(REC_ADMIN_AHEAD_PRD/decode(REC_ADMIN_AHEAD_TYPE,'H',24,'M',24*60),0) FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?)),'DD/MM/YYYY HH24:MI') TO_DATE FROM DUAL") ;
			pstmt.setString(1,current_time);
			pstmt.setString(2,login_facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				AdiminWindowToDateTime = resultSet.getString("TO_DATE");
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
			}catch(Exception es){es.printStackTrace() ;}
		}
		if(!locale.equals("en"))
			AdiminWindowToDateTime = com.ehis.util.DateUtils.convertDate(AdiminWindowToDateTime, "DMYHM","en",locale);
		return AdiminWindowToDateTime;
	}
	//Added for TTM-SCF-0171-907901 Start
	public String getAdminBackLogTime(String curr_time)
	{
		String AdminBackLogTime = "";
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		locale = getLanguageId();
		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement("SELECT TO_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')-((SELECT nvl(REC_ADMIN_AHEAD_PRD/decode(REC_ADMIN_AHEAD_TYPE,'H',24,'M',24*60),0) FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?)),'DD/MM/YYYY HH24:MI') TO_DATE FROM DUAL") ;
			pstmt.setString(1,curr_time);
			pstmt.setString(2,login_facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				AdminBackLogTime = resultSet.getString("TO_DATE");
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
			}catch(Exception es){es.printStackTrace() ;}
		}
		/*if(!locale.equals("en")) 
			AdminBackLogTime = com.ehis.util.DateUtils.convertDate(AdminBackLogTime, "DMYHM","en",locale);*/ // commented for TTM-SCF-0185-974750 [IN:066489]
		return AdminBackLogTime;
	}//Added for TTM-SCF-0171-907901 END
	public String getStoreCode(){
		if(store_code==null){
			store_code="";
		}
		return this.store_code;
	}

	public void setStoreCode(String store_code){
		this.store_code = store_code;
	}

	public ArrayList getAdminRoute(){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		locale = getLanguageId();
		ArrayList AdminRoute = new ArrayList();
		try{
			connection = getConnection() ;
			pstmt		= connection.prepareStatement("SELECT ROUTE_CODE route_code , ROUTE_DESC route_desc FROM PH_ROUTE_LANG_VW where EFF_STATUS='E' and language_id=? order by route_desc");
			pstmt.setString(1,locale);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null){
				while(resultSet.next())
				{
				AdminRoute.add(resultSet.getString("route_code"));
				AdminRoute.add(resultSet.getString("route_desc"));
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
		return AdminRoute;
	}
	public ArrayList getAdminRoute(String categ_code){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		locale = getLanguageId();
		ArrayList AdminRoute = new ArrayList();
		if(categ_code.equals("")){
			AdminRoute =getAdminRoute();
		}
		else{
			try{
				connection = getConnection() ;
				pstmt		= connection.prepareStatement("Select a.route_code, b.route_desc from ph_admin_route_catg_dtl a, ph_route_lang_vw b where a.admin_route_catg_code = ? and a.route_code = b.route_code and b.EFF_STATUS='E' and b.language_id = ? order by b.route_desc");
				pstmt.setString(1,categ_code);
				pstmt.setString(2,locale);
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null){
					while(resultSet.next()){
						AdminRoute.add(resultSet.getString("route_code"));
						AdminRoute.add(resultSet.getString("route_desc"));
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
		}
		return AdminRoute;
	}
	public ArrayList getAdminRouteCategory(){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		locale = getLanguageId();
		ArrayList AdminRouteCategory = new ArrayList();
		try{
			connection = getConnection() ;			
			pstmt		= connection.prepareStatement("Select ADMIN_ROUTE_CATG_CODE, ADMIN_ROUTE_CATG_DESC from ph_admin_route_catg_lang_vw where language_id = ? and EFF_STATUS='E' order by ADMIN_ROUTE_CATG_DESC ");
			pstmt.setString(1,locale);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null){
				while(resultSet.next()){
					AdminRouteCategory.add(resultSet.getString("ADMIN_ROUTE_CATG_CODE"));
					AdminRouteCategory.add(resultSet.getString("ADMIN_ROUTE_CATG_DESC"));
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
		return AdminRouteCategory;
	}
	public String getToDateTime(String current_time){
		String to_date_time	= "";
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		locale = getLanguageId();
		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT_TO_DATE")) ;
			pstmt.setString(1,current_time);
			pstmt.setString(2,login_facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				to_date_time = resultSet.getString("TO_DATE");
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
		if(!locale.equals("en"))
			to_date_time = com.ehis.util.DateUtils.convertDate(to_date_time, "DMYHM","en",locale);
		return to_date_time;
	}

	public ArrayList getPatientDetails(String nursing_unit,String admin_from_date,String admin_to_date,String hold_discontinue_yn,String administration_status,String mode,String order_type,String to_time,String from_time,String called_from,String from_bed_no,String to_bed_no,String patient_class,String rou_admin,String admin_rout_categ) throws Exception{ 

		if(nursing_unit==null) nursing_unit="";
		ArrayList patient_details = new ArrayList();
		Connection connection	  = null ;
        PreparedStatement pstmt   = null ;
        ResultSet resultSet       = null;
		String appendString	      = "";
		String appendString2	  = "";
		String patient_class1="";
		locale = getLanguageId()==null?"en":getLanguageId();
		if(patient_class.equals("IP") || patient_class.equals("DC")  )
		patient_class1="I";
		else
		patient_class1="O";
		setPatientClass(patient_class1);

        try {
			connection = getConnection() ;
			if(order_type !=null && order_type.equals("Rx")){
				appendString = " AND F.IV_PREP_YN IS NULL ";
			}
		/*	else if(order_type !=null && order_type.equals("IVRx")){
				appendString = " AND F.IV_PREP_YN IS NOT NULL ";
			} 
			else if(order_type !=null && order_type.equals("COMP")){
				appendString = " AND F.IV_PREP_YN ='6' ";
			} */
			else if(order_type !=null && order_type.equals("IVRx")){
				appendString = "AND F.IV_PREP_YN IN ('1','2','3','4','5') ";
			} 
			else if(order_type !=null && order_type.equals("COMP")){
				appendString = " AND F.IV_PREP_YN = '6' ";
			}
			else if(order_type !=null && order_type.equals("STAT")){
				appendString = "AND G.FREQ_NATURE = 'O' ";
			}
			else if(order_type !=null && order_type.equals("PRN")){  
				appendString = "AND G.FREQ_NATURE = 'P' ";
			}
			else if(order_type !=null && order_type.equals("CYTO")){  
				appendString = " AND F.IV_PREP_YN IN ('0','9') ";
			} else if(order_type !=null && order_type.equals("TPN")){  
				appendString = " AND F.IV_PREP_YN IN ('7','8') ";
			} 
		/*	else if(order_type !=null && order_type.equals("A")){  
				appendString = " AND (F.IV_PREP_YN IS NULL OR F.IV_PREP_YN IN (0,1,2,3,4,5,6,9)) ";
			}*/

			String strQuery = "";
			String adminstatus="";
			if(administration_status.equals("DUE"))
			{
				adminstatus= " AND (ADMIN_RECORDED_YN='N' OR ADMIN_RECORDED_YN IS NULL) ";
			}	
			else if(administration_status.equals("DOA")){  // else if condition added for GHL-CRF-0458 - Start
				adminstatus= " AND (ADMIN_RECORDED_YN='Y') ";
			} // else if condition added for GHL-CRF-0458 - End
			if(!mode.equals("NOTIME")){
				 strQuery = "";
				if(hold_discontinue_yn.equals("N")){
					if(called_from!=null && called_from.equals("PH")){ 
//						strQuery = PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT1A");
						strQuery ="SELECT DISTINCT  A.ENCOUNTER_ID, A.ASSIGN_BED_NUM ASSIGN_BED_NUM,decode(ph_number_yn(A.ASSIGN_BED_NUM),'Y',to_number(A.ASSIGN_BED_NUM),1000+ascii(A.ASSIGN_BED_NUM)) n_bed_no, nvl( decode(?,'en',C.PATIENT_NAME, PATIENT_NAME_LOC_LANG),PATIENT_NAME) PATIENT_NAME ,  A.PATIENT_ID,  GET_AGE(C.DATE_OF_BIRTH) AGE,  C.NATIONALITY_CODE,DECODE(C.SEX,  'M',  'male',  'F',  'female',  'unknown') GENDER,  (SELECT SHORT_NAME FROM   MP_COUNTRY_LANG_VW MP_COUNTRY WHERE   COUNTRY_CODE=C.NATIONALITY_CODE AND LANGUAGE_ID = ?) NATIONALITY, TO_CHAR(C.DATE_OF_BIRTH,'DD/MM/YYYY') DOB FROM         PR_ENCOUNTER A,  MP_PATIENT C ,  PH_MEDN_ADMIN D ,OR_ORDER_LINE E  ,OR_ORDER F,AM_FREQUENCY_LANG_VW G,PH_PATIENT_DRUG_PROFILE I WHERE  E.ORDER_ID=D.ORDER_ID AND E.ORDER_LINE_NUM=D.ORDER_LINE_NUM AND I.ORIG_ORDER_ID=F.ORDER_ID AND I.ORIG_ORDER_LINE_NO=E.ORDER_LINE_NUM AND I.ORIG_ORDER_ID=E.ORDER_ID AND F.ORDER_ID = E.ORDER_ID AND E.FREQ_CODE=G.FREQ_CODE AND  A.FACILITY_ID=? AND C.PATIENT_ID=A.PATIENT_ID AND D.PATIENT_ID=C.PATIENT_ID AND D.ENCOUNTER_ID=A.ENCOUNTER_ID AND D.FACILITY_ID=A.FACILITY_ID AND A.ASSIGN_CARE_LOCN_CODE=?  AND D.SCH_DATE_TIME>=I.START_DATE AND SYSDATE <= I.end_date  + ((SELECT NVL (rec_admin_within_hrs, 1) FROM ph_facility_param WHERE facility_id = '"+login_facility_id+"') / 24)  AND E.HOLD_DATE_TIME IS NULL  AND e. disc_date_time IS NULL AND (( ? in ('IP','DC')  AND DECODE (ph_number_yn (a.assign_bed_num), 'Y', TO_NUMBER (a.assign_bed_num),  1000 + ASCII (a.assign_bed_num)  ) BETWEEN DECODE (ph_number_yn (?), 'Y', TO_NUMBER (?),  1000 + ASCII (?)  )  AND DECODE (ph_number_yn (?),  'Y', TO_NUMBER (?), 1000 + ASCII (?) ))OR(? in ('OP','EM'))) AND G.LANGUAGE_ID = ?";
							//TO_CHAR(C.DATE_OF_BIRTH,'DD/MM/YYYY') DOB added for ARYU-SCF-023
					}
					else{
//						strQuery = PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT1AA");
						strQuery = "SELECT   /*+ FIRST_ROWS */  DISTINCT  A.ENCOUNTER_ID,  '' ASSIGN_BED_NUM, '' n_bed_no, nvl( decode(?,'en',C.PATIENT_NAME, PATIENT_NAME_LOC_LANG),PATIENT_NAME) PATIENT_NAME,  A.PATIENT_ID,  Get_Age(C.DATE_OF_BIRTH) AGE,  C.NATIONALITY_CODE,DECODE(C.SEX,  'M',  'male',  'F',  'female',  'unknown') GENDER,  (SELECT SHORT_NAME FROM   MP_COUNTRY_LANG_VW MP_COUNTRY WHERE    COUNTRY_CODE=C.NATIONALITY_CODE AND LANGUAGE_ID = ? ) NATIONALITY, TO_CHAR(C.DATE_OF_BIRTH,'DD/MM/YYYY') DOB FROM  PR_ENCOUNTER A,OP_CLINIC_LANG_VW B,MP_PATIENT C ,  PH_MEDN_ADMIN D ,OR_ORDER_LINE E  ,OR_ORDER F ,AM_FREQUENCY_LANG_VW G,PH_PATIENT_DRUG_PROFILE I    WHERE   I.ORIG_ORDER_ID=F.ORDER_ID AND I.ORIG_ORDER_LINE_NO=E.ORDER_LINE_NUM AND I.ORIG_ORDER_ID=E.ORDER_ID AND	E.FREQ_CODE=G.FREQ_CODE AND  F.ORDER_ID = E.ORDER_ID AND   E.ORDER_LINE_NUM=D.ORDER_LINE_NUM AND  E.ORDER_ID=D.ORDER_ID   AND   C.PATIENT_ID=A.PATIENT_ID   AND  D.ENCOUNTER_ID=A.ENCOUNTER_ID  AND  D.FACILITY_ID=A.FACILITY_ID    AND   B.CLINIC_CODE=a.ASSIGN_CARE_LOCN_CODE AND B.FACILITY_ID=? AND   B.CLINIC_CODE=?  AND   d.sch_date_time>=e.ord_date_time AND   SYSDATE <= e.end_date  + ((SELECT NVL (rec_admin_within_hrs, 1) FROM ph_facility_param WHERE facility_id = '"+login_facility_id+"') / 24) and e.hold_date_time IS NULL  and   e. disc_date_time IS NULL  AND (( ? in ('IP','DC')  AND DECODE (ph_number_yn (a.assign_bed_num), 'Y', TO_NUMBER (a.assign_bed_num),  1000 + ASCII (a.assign_bed_num)  ) BETWEEN DECODE (ph_number_yn (?), 'Y', TO_NUMBER (?),  1000 + ASCII (?)  )  AND DECODE (ph_number_yn (?),  'Y', TO_NUMBER (?), 1000 + ASCII (?) ))OR(? in ('OP','EM'))) AND B.LANGUAGE_ID = G.LANGUAGE_ID AND B.LANGUAGE_ID = ?";
					//TO_CHAR(C.DATE_OF_BIRTH,'DD/MM/YYYY') DOB added for ARYU-SCF-023
					}
				}
				else{
					if(called_from!=null && called_from.equals("PH")){ 
//						strQuery = PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT1");
						strQuery ="SELECT DISTINCT  A.ENCOUNTER_ID,   A.ASSIGN_BED_NUM ASSIGN_BED_NUM,decode(ph_number_yn(A.ASSIGN_BED_NUM),'Y',to_number(A.ASSIGN_BED_NUM),1000+ascii(A.ASSIGN_BED_NUM)) n_bed_no, nvl( decode(?,'en',C.PATIENT_NAME, PATIENT_NAME_LOC_LANG),PATIENT_NAME) PATIENT_NAME, A.PATIENT_ID,   GET_AGE(C.DATE_OF_BIRTH) AGE, C.NATIONALITY_CODE,DECODE(C.SEX,   'M',   'male',   'F',   'female',   'unknown') GENDER,   (SELECT SHORT_NAME FROM    MP_COUNTRY_LANG_VW MP_COUNTRY 	WHERE    COUNTRY_CODE=C.NATIONALITY_CODE AND LANGUAGE_ID = ?) NATIONALITY ,TO_CHAR(C.DATE_OF_BIRTH,'DD/MM/YYYY') DOB FROM   PR_ENCOUNTER  A,  MP_PATIENT C ,  PH_MEDN_ADMIN D ,OR_ORDER_LINE E ,OR_ORDER F,AM_FREQUENCY_LANG_VW G,PH_PATIENT_DRUG_PROFILE I  WHERE  	   E.ORDER_ID=D.ORDER_ID   AND    E.ORDER_LINE_NUM=D.ORDER_LINE_NUM and	   I.ORIG_ORDER_ID=F.ORDER_ID AND    I.ORIG_ORDER_LINE_NO=E.ORDER_LINE_NUM AND    I.ORIG_ORDER_ID=E.ORDER_ID AND    F.ORDER_ID=E.ORDER_ID AND    E.FREQ_CODE=G.FREQ_CODE AND       A.FACILITY_ID=?  AND    C.PATIENT_ID=A.PATIENT_ID and	   d.patient_id=c.patient_id   AND    D.ENCOUNTER_ID=A.ENCOUNTER_ID  AND    D.FACILITY_ID=A.FACILITY_ID    AND    A.ASSIGN_CARE_LOCN_CODE=? AND    SYSDATE <= i.end_date  + ((SELECT NVL (rec_admin_within_hrs, 1) FROM ph_facility_param WHERE facility_id = '"+login_facility_id+"') / 24) AND    E.CAN_DATE_TIME IS NULL AND    (( ? in ('IP','DC')  AND DECODE (ph_number_yn (a.assign_bed_num), 'Y', TO_NUMBER (a.assign_bed_num),  1000 + ASCII (a.assign_bed_num)  ) BETWEEN DECODE (ph_number_yn (?), 'Y', TO_NUMBER (?),  1000 + ASCII (?)  )  AND DECODE (ph_number_yn (?),  'Y', TO_NUMBER (?), 1000 + ASCII (?) ))OR(? in ('OP','EM'))) AND G.LANGUAGE_ID = ?";
						//TO_CHAR(C.DATE_OF_BIRTH,'DD/MM/YYYY') DOB added for ARYU-SCF-023
					}
					else{
//						strQuery = PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT1AAA");
						strQuery = "SELECT   /*+ FIRST_ROWS */  DISTINCT  A.ENCOUNTER_ID,  '' ASSIGN_BED_NUM,  null n_bed_no, nvl( decode(?,'en',C.PATIENT_NAME, PATIENT_NAME_LOC_LANG),PATIENT_NAME) PATIENT_NAME,  A.PATIENT_ID,  GET_AGE(C.DATE_OF_BIRTH) AGE,  C.NATIONALITY_CODE,DECODE(C.SEX,  'M',  'male',  'F',  'female',  'unknown') GENDER,  (SELECT SHORT_NAME FROM   MP_COUNTRY_LANG_VW MP_COUNTRY WHERE   COUNTRY_CODE=C.NATIONALITY_CODE AND LANGUAGE_ID = ?) NATIONALITY,TO_CHAR(C.DATE_OF_BIRTH,'DD/MM/YYYY') DOB    FROM         OP_CLINIC_LANG_VW B,  PR_ENCOUNTER  A,  MP_PATIENT C ,  PH_MEDN_ADMIN D ,OR_ORDER_LINE E ,OR_ORDER F,AM_FREQUENCY_LANG_VW G,PH_PATIENT_DRUG_PROFILE I  WHERE I.ORIG_ORDER_ID=F.ORDER_ID AND I.ORIG_ORDER_LINE_NO=E.ORDER_LINE_NUM AND I.ORIG_ORDER_ID=E.ORDER_ID AND E.FREQ_CODE=G.FREQ_CODE AND F.ORDER_ID=E.ORDER_ID AND  E.ORDER_LINE_NUM=D.ORDER_LINE_NUM AND  E.ORDER_ID=D.ORDER_ID   AND  B.FACILITY_ID=A.FACILITY_ID AND  B.FACILITY_ID=?   AND  C.PATIENT_ID=A.PATIENT_ID   AND  D.FACILITY_ID=A.FACILITY_ID    AND  B.CLINIC_CODE = A.ASSIGN_CARE_LOCN_CODE AND  B.CLINIC_CODE=?  AND    d.sch_date_time>=e.ord_date_time AND SYSDATE <= e.end_date  + ((SELECT NVL (rec_admin_within_hrs, 1) FROM ph_facility_param WHERE facility_id = '"+login_facility_id+"') / 24) AND    (( ? in ('IP','DC')  AND DECODE (ph_number_yn (a.assign_bed_num), 'Y', TO_NUMBER (a.assign_bed_num),  1000 + ASCII (a.assign_bed_num)  ) BETWEEN DECODE (ph_number_yn (?), 'Y', TO_NUMBER (?),  1000 + ASCII (?)  )  AND DECODE (ph_number_yn (?),  'Y', TO_NUMBER (?), 1000 + ASCII (?) ))OR(? in ('OP','EM'))) AND B.LANGUAGE_ID = G.LANGUAGE_ID AND B.LANGUAGE_ID = ?";
				//,TO_CHAR(C.DATE_OF_BIRTH,'DD/MM/YYYY') DOB  added for ARYU-SCF-023
					}
				}
				if(appendString==null)appendString="";
										
				appendString = appendString + " AND   ( TO_DATE( TO_CHAR(SCH_DATE_TIME,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') BETWEEN  TO_DATE(?,'DD/mm/yyyy hh24:mi') AND TO_DATE(?,'DD/mm/yyyy hh24:mi') OR (G.FREQ_NATURE='P'  AND e.START_DATE_TIME<TO_DATE('"+to_time+"','DD/mm/yyyy hh24:mi')  AND (E.ORDER_QTY-NVL(I.TOT_ADMINISTERED_QTY,0))>0 ) )"+adminstatus; // AND e.START_DATE_TIME<TO_DATE('"+to_time+"','DD/mm/yyyy hh24:mi') for IN26572 --18/02/2011
			}
			else{
				strQuery = "";
				if(hold_discontinue_yn.equals("N")){
					if(called_from!=null && called_from.equals("PH")){ 
						strQuery = PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT8A");
					}
					else{
						strQuery = PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT8AA");
					}
				}
				else{
					if(called_from!=null && called_from.equals("PH")){ 
						strQuery = PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT8");
					}
					else{
						strQuery = PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT8AAA");
					}
				}
				if(appendString==null)
					appendString="";

				
				appendString = appendString + " AND  ( TO_DATE( TO_CHAR(SCH_DATE_TIME,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') BETWEEN  TO_DATE(?,'DD/mm/yyyy hh24:mi') AND TO_DATE(?,'DD/mm/yyyy hh24:mi') OR (G.FREQ_NATURE='P'  AND e.START_DATE_TIME<TO_DATE('"+to_time+"','DD/mm/yyyy hh24:mi')  AND (E.ORDER_QTY-NVL(I.TOT_ADMINISTERED_QTY,0))>0 ) )"+adminstatus; // added  AND e.START_DATE_TIME<TO_DATE('"+to_time+"','DD/mm/yyyy hh24:mi') for IN26572 --18/02/2011
			}
		
			if(!rou_admin.equals(" ")&&!rou_admin.equals("")){
				appendString2=" and E.ROUTE_CODE='"+rou_admin.trim()+"'";
			}
			else if(!admin_rout_categ.equals(" ")&&!admin_rout_categ.equals("")){
				ArrayList admRoutes=getAdminRoute(admin_rout_categ.trim());
				String aString="";
				for(int index=0;index<admRoutes.size();index+=2)
				{
					aString=aString+"'"+admRoutes.get(index)+"',";
				}
				if(!aString.equals(""))
					aString=aString.substring(0,(aString.length()-1));
				else
					aString="''";
				appendString2=" and E.ROUTE_CODE IN("+aString+")";
			}
			if(patient_class.equals("IP")||patient_class.equals("DC")){
					appendString2 = appendString2 +" and ASSIGN_CARE_LOCN_TYPE ='N'  and a.adt_status in ('00', '01') ";
			}
			else if(patient_class.equals("OP")||patient_class.equals("EM")){
					appendString2 = appendString2 +" and ASSIGN_CARE_LOCN_TYPE IN('C','E') and visit_status < '07' ";
			}

			appendString = appendString + "  order by n_bed_no, ASSIGN_BED_NUM";
			pstmt = connection.prepareStatement( strQuery+appendString2+appendString ); 
//System.err.println("=======MARSQL=============>"+strQuery+appendString2+appendString);
//System.err.println("=======PARAMS=====locale========>"+locale+" login_facility_id="+login_facility_id+" nursing_unit="+nursing_unit+" patient_class=?"+patient_class+" from_bed_no="+from_bed_no+" to_bed_no="+to_bed_no+" from_time="+from_time+" to_time="+to_time);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,login_facility_id);
			pstmt.setString(4,nursing_unit);			
			pstmt.setString(5,patient_class);			
			pstmt.setString(6,from_bed_no);
			pstmt.setString(7,from_bed_no);
			pstmt.setString(8,from_bed_no);
			pstmt.setString(9,to_bed_no);
			pstmt.setString(10,to_bed_no);
			pstmt.setString(11,to_bed_no);           
		    pstmt.setString(12,patient_class);
			pstmt.setString(13,locale);
			pstmt.setString(14,from_time);
			pstmt.setString(15,to_time);

			resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next() ) {
				patient_details.add(resultSet.getString("ASSIGN_BED_NUM"));
				patient_details.add(resultSet.getString("PATIENT_ID"));
				patient_details.add(resultSet.getString("PATIENT_NAME"));
				patient_details.add(resultSet.getString("GENDER"));
				patient_details.add(resultSet.getString("AGE"));
				patient_details.add(resultSet.getString("NATIONALITY"));
				patient_details.add(resultSet.getString("ENCOUNTER_ID"));
				setPatientDOB(resultSet.getString("PATIENT_ID"),resultSet.getString("DOB"));//added for ARYU-SCF-023

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
		return patient_details;
	}

	public HashMap getDrugDetails(String encounter_id,String admin_from_date,String admin_to_date,String hold_discontinue_yn,String administration_status,String order_type,String to_time,String from_time, String display_order_by,String route_admin,String admin_rout_categ) throws Exception{
		HashMap drug_details						= new HashMap();
		HashMap prescribe_mode						= new HashMap();
		HashMap split_dose_YN						= new HashMap(); //ML-MMOH-SCF-1439
		ArrayList iv_drug_details					= new ArrayList();
		ArrayList non_iv_drug_details				= new ArrayList();
				
		Connection connection						= null;
        PreparedStatement pstmt						= null;
		PreparedStatement pstmt_select				= null;
		PreparedStatement pstmt_select_drug_count	= null;
		PreparedStatement pstmt_ext_drug_code		= null;
		PreparedStatement pstmt_route_code			= null;
        ResultSet resultSet							= null;
		ResultSet resultSet_1						= null;
		ResultSet resultSet_drug_count				= null;
		ResultSet resultSet_ext_drug_code			= null;
		ResultSet resultSet_route_code				= null;		
		String appendString							="";
		String strQuery								="";
		String iv_prep_yn							="";
		String prn_remarks							="";
		String Slidingscale_remarks					="";
		String action_seq_num						="";
		String order_line_seq_num					="";
		String ext_prod_id							="";
		String drugCode								="";
		String str_date								="";
		String order_id								="";
		String drug_count							="1";
		String imageFileURL							="";
		String order_line_num						="";
		String trade_code							="";
		String route_code							="";
		String route_desc							="";
		String display_order_str					="";
		String route_color							="";  //Code Added For RUT CRF - 0034 
		locale = getLanguageId()==null?"en":getLanguageId();
		DrugTradeImageBean Imagebean = new DrugTradeImageBean();

		if(display_order_by.equals("D")){
			display_order_str = "drug_desc"+"||D.ORDER_ID||to_char(a.sch_date_time,'yyyymmddhh24:mi')||to_char(D.ORDER_LINE_NUM)";
		}
		else if(display_order_by.equals("F")){
			if(order_type.equals("TPN"))
				display_order_str = "D.ORDER_ID||to_char(a.sch_date_time,'yyyymmddhh24:mi')||to_char(D.ORDER_LINE_NUM)";
			else
				display_order_str = "form_desc||D.ORDER_ID||to_char(a.sch_date_time,'yyyymmddhh24:mi')||to_char(D.ORDER_LINE_NUM)";			
		}
		else if(display_order_by.equals("R")){
			display_order_str = "D.ORDER_ID||to_char(a.sch_date_time,'yyyymmddhh24:mi')||to_char(D.ORDER_LINE_NUM)";
		}
		else { 
			display_order_str = "to_char(a.sch_date_time,'yyyymmddhh24:mi') ||D.ORDER_ID||to_char(D.ORDER_LINE_NUM)";
		}		

	   try{
			connection = getConnection() ;
			try {
				if(order_type.equals("TPN")){
					//strQuery =PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_TPN_SELECT2");
					strQuery ="SELECT a.CANCEL_RECORDED_YN,a.order_id, a.order_line_num, e.iv_prep_yn, a.admin_recorded_by username, a.admin_authorized_by authorized_by, a.admin_remarks, a.non_admin_remarks, a.admin_recorded_yn, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN (   f.admin_drug_code || ':' || (SELECT long_name FROM ph_tpn_regimen_lang_vw ph_tpn_regimen WHERE tpn_regimen_code = f.admin_drug_code AND language_id = ?) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) WHEN a.ord_drug_code = 'FINAL PRODUCT' and nvl(administered_yn,'N') = 'Y' then 'FINAL PRODUCT:'||((SELECT mfg_unit FROM ph_tpn_worksheet_hdr WHERE tpn_worksheet_id = (SELECT DISTINCT tpn_worksheet_id FROM ph_tpn_worksheet_dtl WHERE order_id = (SELECT DISTINCT order_id FROM ph_medn_admin WHERE order_id = a.order_id and order_line_num = a.order_line_num and nvl(administered_yn,'N' ) = 'Y'))) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code) END ) administereddrug,  a.dosage_seq_no, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY HH24:MI') sch_date_time, a.admin_recorded_yn, a.administered_yn, a.verify_reqd_yn, a.verification_status, a.medn_admin_status, NVL (a.iv_admin_yn, 'N') iv_admin_yn, DECODE (d.disc_date_time, NULL, 'N', 'Y') discontinued, DECODE (d.hold_date_time, NULL, 'N', 'Y') held, a.patient_id, a.pract_id, a.order_id, d.qty_value, d.qty_unit, d.freq_code,  NVL ((SELECT disp_drug_code FROM ph_disp_dtl WHERE ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND ROWNUM < 2), (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.long_name ELSE 'FINAL PRODUCT' END ) ) drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.tpn_regimen_code ELSE 'FINAL PRODUCT' END ) pres_drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT long_name FROM ph_tpn_regimen_lang_vw  ph_tpn_regimen, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_tpn_regimen.tpn_regimen_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2), b.long_name ) ELSE (SELECT mfg_unit FROM ph_tpn_worksheet_hdr HDR WHERE order_id = a.order_id AND ROWNUM<2) END ) drug_desc, Decode(ADMINISTERED_YN,'N', (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT long_name FROM ph_tpn_regimen_lang_vw  ph_tpn_regimen, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_tpn_regimen.tpn_regimen_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2), b.long_name ) ELSE (SELECT mfg_unit FROM ph_tpn_worksheet_hdr HDR WHERE order_id = a.order_id AND ROWNUM<2) END )) dispensed_drug_desc, NVL (f.admin_dosage_qty, sch_dosage_qty) qty,  am_get_desc.am_uom(a.sch_dosage_uom_code,?,2) short_desc, a.iv_ingrediants, a.sch_infusion_rate, am_get_desc.am_uom(a.sch_infusion_vol_str_unit, ? , 2 ) sch_infusion_vol_str_unit_desc, sch_infusion_vol_str_unit, a.sch_infusion_per_unit, a.sch_infusion_period, a.sch_infusion_period_unit, TO_CHAR (a.admin_date_time, 'DD/MM/YYYY HH24:MI') admin_date_time, TO_CHAR (a.modified_date, 'DD/MM/YYYY HH24:MI') modified_date, b.drug_class, b.item_code itemcode, TO_CHAR (d.end_date_time, 'DD/MM/YYYY HH24:MI') end_date_time, f.batch_id, TO_CHAR (f.expiry_date, 'DD/MM/YYYY') expiry_date, f.item_code, f.trade_id tradeid, am_get_desc.AM_TRADE_NAME(f.trade_id,?,2) tradename, h.freq_nature,  TO_CHAR (a.against_schdose_date_time, 'DD/MM/YYYY HH24:MI' ) against_schdose_date_time, a.adr_reason_code, a.adr_remarks, TO_CHAR (a.adr_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) adr_recorded_date_time, a.adr_recorded_by, i.prescribed_mode,d.route_code, b.PRES_CATG_CODE , am_get_desc.am_uom(d.qty_unit,?,2) schedule_uom_desc,a.sch_dosage_uom_code sch_dosage_uom_code,o.PATIENT_BROUGHT_MEDICATION_YN,o.SLIDING_SCALE_YN sliding_scale_yn,a.MEDN_BROUGHT_BY_PATIENT_YN,o.DOSAGE_TYPE, i.DOSAGE, i.DOSAGE_UOM_CODE, am_get_desc.am_uom(i.dosage_uom_code,?,2) dosage_uom_desc,A.ADMN_DOSE_CHNG_REMARKS,e.PERFORMING_DEPTLOC_CODE,b.PRES_BASE_UNIT, i.DISPENSED_DRUGS, b.pres_base_uom, e.ORD_PRACT_ID,(SELECT drug_code FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code<>ph_disp_dtl.pres_drug_code and ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2 ) disp_drug_code,e.patient_class,O.PLACED_FROM_VERBAL_ORDER,e.order_status,o.SPLIT_DOSE_YN FROM ph_medn_admin a, ph_tpn_regimen_lang_vw b, or_order_line d, or_order e, ph_medn_admin_dtl f, am_frequency h, ph_patient_drug_profile i, or_order_line_ph o WHERE h.freq_code = d.freq_code AND f.encounter_id(+) = a.encounter_id AND f.order_id(+) = a.order_id AND f.facility_id(+) = a.facility_id AND f.ord_drug_code(+) = a.ord_drug_code AND a.dosage_seq_no = f.dosage_seq_no(+) AND f.sch_date_time(+) = a.sch_date_time AND e.order_id = d.order_id AND o.order_id = d.order_id AND o.order_line_num = d.order_line_num AND i.orig_order_id = d.order_id AND i.orig_order_line_no = d.order_line_num AND e.order_id = i.orig_order_id AND a.ord_drug_code = b.tpn_regimen_code(+) AND a.order_id = d.order_id AND a.order_line_num = d.order_line_num AND a.facility_id =? AND a.encounter_id =? AND a.sch_date_time >= d.START_DATE_TIME AND SYSDATE <= d.end_date_time AND d.can_date_time IS NULL AND e.iv_prep_yn IN ('7','8') AND b.language_id(+) = ? and d.ORDER_LINE_STATUS not in ('PO', 'PS') "; //and d.ORDER_LINE_STATUS not in ('PO', 'PS')  added for ML-MMOH-SCF-0321 [IN:058617]e.order_status added for GHL-CRF-0482
					//e.patient_class added for GHL-CRF-0458 and e.order_status added for GHL-CRF-048 and o.SPLIT_DOSE_YN added for ML-MMOH-SCF-1439

				}
				else{
					//strQuery = PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT2");	53hello				
					strQuery = "SELECT /*+ INDEX(d or_order_line_pk*/ a.order_id,a.CANCEL_RECORDED_YN, a.order_line_num, e.iv_prep_yn, a.admin_recorded_by username, a.admin_authorized_by authorized_by, a.admin_remarks, a.non_admin_remarks, a.admin_recorded_yn, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN ( f.admin_drug_code || ':' || (SELECT drug_desc FROM ph_drug_lang_vw ph_drug WHERE drug_code = f.admin_drug_code AND language_id = ?) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) WHEN a.ord_drug_code = 'FINAL PRODUCT' AND NVL (administered_yn, 'N') = 'Y' THEN 'FINAL PRODUCT:' || ( (SELECT mfg_unit FROM ph_worksheet_hdr WHERE order_id = a.order_id AND ROWNUM<2 ) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) END ) administereddrug, a.dosage_seq_no, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY HH24:MI') sch_date_time, a.administered_yn, a.verify_reqd_yn, a.verification_status, a.medn_admin_status, NVL (a.iv_admin_yn, 'N') iv_admin_yn, DECODE (d.disc_date_time, NULL, 'N', 'Y') discontinued, DECODE (d.hold_date_time, NULL, 'N', 'Y') held, a.patient_id, a.pract_id, a.order_id, d.qty_value, d.qty_unit, d.freq_code, NVL ((SELECT disp_drug_code FROM ph_disp_dtl WHERE ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND ROWNUM < 2), (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.drug_code ELSE 'FINAL PRODUCT' END ) ) drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.drug_code ELSE 'FINAL PRODUCT' END ) pres_drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT drug_desc FROM ph_drug_lang_vw ph_drug WHERE drug_code = a.ord_drug_code AND language_id = ? AND ROWNUM < 2), b.drug_desc ) ELSE (SELECT mfg_unit FROM ph_worksheet_hdr WHERE order_id = a.order_id AND ROWNUM < 2) END ) drug_desc, DECODE (administered_yn, 'N',(CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN (SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code <> ph_disp_dtl.pres_drug_code AND ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2) ELSE (SELECT mfg_unit FROM ph_worksheet_hdr WHERE order_id = a.order_id AND ROWNUM < 2) END ) ) dispensed_drug_desc, NVL (f.admin_dosage_qty, sch_dosage_qty) qty, am_get_desc.am_uom(a.sch_dosage_uom_code,?,2) short_desc, b.disp_multi_strength_yn, a.iv_ingrediants, a.sch_infusion_rate, am_get_desc.am_uom(a.sch_infusion_vol_str_unit, ? , 2 ) sch_infusion_vol_str_unit_desc ,sch_infusion_vol_str_unit , a.sch_infusion_per_unit, a.sch_infusion_period, a.sch_infusion_period_unit, TO_CHAR (a.admin_date_time, 'DD/MM/YYYY HH24:MI') admin_date_time, TO_CHAR (a.modified_date, 'DD/MM/YYYY HH24:MI') modified_date, b.drug_class, b.item_code itemcode, TO_CHAR (d.end_date_time, 'DD/MM/YYYY HH24:MI') end_date_time, f.batch_id, TO_CHAR (f.expiry_date, 'DD/MM/YYYY') expiry_date, f.item_code, f.trade_id tradeid, am_get_desc.AM_TRADE_NAME(f.trade_id,?,2) tradename, h.freq_nature, TO_CHAR (a.against_schdose_date_time, 'DD/MM/YYYY HH24:MI' ) against_schdose_date_time, a.adr_reason_code, a.adr_remarks, TO_CHAR (a.adr_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) adr_recorded_date_time, a.adr_recorded_by, i.prescribed_mode,B.MEDN_ADMN_DTL_REQD_YN, i.PRN_REMARKS, i.SLIDING_SCALE_REMARKS, k.order_line_seq_num,d.route_code, b.PRES_CATG_CODE,am_get_desc.am_uom(d.qty_unit,?,2) schedule_uom_desc, a.sch_dosage_uom_code sch_dosage_uom_code,ph_get_desc.PH_FORM(b.form_code,?,1) form_desc,o.PATIENT_BROUGHT_MEDICATION_YN ,o.SLIDING_SCALE_YN sliding_scale_yn,b.STRENGTH_VALUE,a.SCH_STRENGTH,a.SCH_STRENGTH_UOM, am_get_desc.am_uom(a.sch_strength_uom,?,2) sch_strength_uom_desc,a.MEDN_BROUGHT_BY_PATIENT_YN,o.DOSAGE_TYPE, i.DOSAGE, i.DOSAGE_UOM_CODE, am_get_desc.am_uom(i.dosage_uom_code,?,2) dosage_uom_desc,b.CONTENT_IN_PRES_BASE_UOM,A.ADMN_DOSE_CHNG_REMARKS, ca_get_vaccine_sche_details(a.patient_id,NVL ((SELECT disp_drug_code FROM ph_disp_dtl WHERE ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND ROWNUM < 2),(CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.drug_code ELSE 'FINAL PRODUCT' END)),b.language_id) VACC_CATEGORY_LINK,o.MFR_YN, a.FLOW_STATUS,a.COMPLETED_DURN_IN_MINS,a.COMPLETED_VOLUME, TO_CHAR (a.HOLD_DATE_TIME, 'DD/MM/YYYY HH24:MI') HOLD_DATE_TIME, a.HOLD_DURN_IN_MINS,TO_CHAR (a.RESUME_DATE_TIME, 'DD/MM/YYYY HH24:MI') RESUME_DATE_TIME, TO_CHAR (a.ACT_START_DATE_TIME, 'DD/MM/YYYY HH24:MI') ACT_START_DATE_TIME, TO_CHAR (a.ACT_END_DATE_TIME, 'DD/MM/YYYY HH24:MI') ACT_END_DATE_TIME,o.MFR_REMARKS,e.PERFORMING_DEPTLOC_CODE,b.pres_base_uom, e.ORD_PRACT_ID,B.GENERIC_ID, i.DISPENSED_DRUGS,(SELECT drug_code FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code<>ph_disp_dtl.pres_drug_code and ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2 ) disp_drug_code,e.patient_class,O.PLACED_FROM_VERBAL_ORDER,e.order_status, PATIENT_STOCK_REQUIRED,PATIENT_STOCK_COMPLETED,i.PATIENT_STOCK_YN,o.SPLIT_DOSE_YN   FROM ph_medn_admin a, ph_drug_lang_vw b, or_order_line d, or_order e, ph_medn_admin_dtl f, am_frequency h, ph_patient_drug_profile i,  or_order_line_field_values k, or_order_line_ph o WHERE h.freq_code = d.freq_code AND f.encounter_id(+) = a.encounter_id AND f.facility_id(+) = a.facility_id AND f.ord_drug_code(+) = a.ord_drug_code  AND a.dosage_seq_no = f.dosage_seq_no(+) AND f.sch_date_time(+) = a.sch_date_time AND f.order_id(+) = a.order_id AND e.order_id = d.order_id AND i.orig_order_id = d.order_id AND o.order_id = d.order_id AND o.order_line_num = d.order_line_num AND i.orig_order_line_no = d.order_line_num AND e.order_id = i.orig_order_id AND a.ord_drug_code = b.drug_code(+) AND a.order_id = d.order_id AND a.order_line_num = d.order_line_num AND a.order_id = k.order_id(+) and a.order_line_num = k.order_line_num(+) and k.order_line_seq_num(+) = 1 AND a.facility_id = ? AND a.encounter_id = ? AND a.sch_date_time >= d.START_DATE_TIME AND d.can_date_time IS NULL AND b.language_id(+)=?  and d.ORDER_LINE_STATUS not in ('PO', 'PS','PQ') "; //and d.ORDER_LINE_STATUS not in ('PO', 'PS')  added for ML-MMOH-SCF-0321 [IN:058617] and and o.SPLIT_DOSE_YN added for ML-MMOH-SCF-1439 //Added ORDER_LINE_STATUS not in ('PO', 'PS','PQ') 'PQ' for ML-MMOH-CRF-1823-US008
					//e.patient_class added for GHL-CRF-0458 and e.order_status, PATIENT_STOCK_REQUIRED,PATIENT_STOCK_COMPLETED,i.PATIENT_STOCK_YN  added for GHL-CRF-0482
				}

			  // added am_get_desc.am_uom(a.sch_infusion_vol_str_unit, ? , 2 ) sch_infusion_vol_str_unit instead of sch_infusion_vol_str_unit for the incident no skr-scf-0075 by chandrashekar raju.A

	//replace 4/24 with ((select nvl(REC_ADMIN_WITHIN_HRS,1) from ph_facility_param where facility_id ='"+login_facility_id+"')/24) in all the below conditions for IN23993 --10/11/2010-- priya

				if(order_type !=null && order_type.equals("Rx")){
					appendString = "AND SYSDATE<=D.END_DATE_TIME+((select nvl(REC_ADMIN_WITHIN_HRS,1) from ph_facility_param where facility_id ='"+login_facility_id+"')/24) AND E.IV_PREP_YN IS NULL ";
				} 
				else if(order_type !=null && order_type.equals("IVRx")){
					appendString = "AND SYSDATE<=D.END_DATE_TIME+((select nvl(REC_ADMIN_WITHIN_HRS,1) from ph_facility_param where facility_id ='"+login_facility_id+"')/24) AND E.IV_PREP_YN IN ('1','2','3','4','5') ";
				} 
				else if(order_type !=null && order_type.equals("COMP")){
					appendString = "AND SYSDATE<=D.END_DATE_TIME+((select nvl(REC_ADMIN_WITHIN_HRS,1) from ph_facility_param where facility_id ='"+login_facility_id+"')/24) AND E.IV_PREP_YN = '6' ";
				}
				else if(order_type !=null && order_type.equals("STAT")){
					appendString = "AND SYSDATE<=D.END_DATE_TIME+((select nvl(REC_ADMIN_WITHIN_HRS,1) from ph_facility_param where facility_id ='"+login_facility_id+"')/24) AND H.FREQ_NATURE = 'O' ";
				}
				else if(order_type !=null && order_type.equals("PRN")){  
					appendString = "and d.start_date_time <  TO_DATE('"+to_time+"','DD/MM/YYYY HH24:MI') AND SYSDATE<=D.END_DATE_TIME+((select nvl(REC_ADMIN_WITHIN_HRS,1) from ph_facility_param where facility_id ='"+login_facility_id+"')/24) AND H.FREQ_NATURE = 'P' "; // added and d.start_date_time <  TO_DATE('"+to_time+"','DD/MM/YYYY HH24:MI') for IN26572 --18/02/2011
				}
				else if(order_type !=null && order_type.equals("CYTO")){  
					appendString = " AND SYSDATE<=D.END_DATE_TIME+((select nvl(REC_ADMIN_WITHIN_HRS,1) from ph_facility_param where facility_id ='"+login_facility_id+"')/24) AND E.IV_PREP_YN IN ('0','9') ";
				} 
				else if(order_type !=null && order_type.equals("A")){  
					appendString = " AND SYSDATE<=D.END_DATE_TIME+((select nvl(REC_ADMIN_WITHIN_HRS,1) from ph_facility_param where facility_id ='"+login_facility_id+"')/24) AND (E.IV_PREP_YN IS NULL OR E.IV_PREP_YN IN ('0','1','2','3','4','5','6','9')) ";
				}
				
				if(administration_status!=null && (administration_status.equals("OVERDUE") || administration_status.equals("DUE"))){
					appendString = appendString + "AND  ( (A.SCH_DATE_TIME BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND TO_DATE(?,'DD/MM/YYYY HH24:MI') AND (ADMIN_RECORDED_YN='N' OR ADMIN_RECORDED_YN IS NULL)) OR (H.FREQ_NATURE='P' and d.start_date_time <  TO_DATE('"+to_time+"','DD/MM/YYYY HH24:MI') AND (D.ORDER_QTY-NVL(I.TOT_ADMINISTERED_QTY,0))>0 )) "; // added and d.start_date_time <  TO_DATE('"+to_time+"','DD/MM/YYYY HH24:MI') for IN26572 --18/02/2011
				} 
				else if(administration_status!=null && administration_status.equals("ALL")) {
					appendString = appendString + "AND ( (A.SCH_DATE_TIME BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND TO_DATE(?,'DD/MM/YYYY HH24:MI')) OR (H.FREQ_NATURE='P'  and d.start_date_time <  TO_DATE('"+to_time+"','DD/MM/YYYY HH24:MI') AND (D.ORDER_QTY-NVL(I.TOT_ADMINISTERED_QTY,0))>0 ) ) "; //added and d.start_date_time <  TO_DATE('"+to_time+"','DD/MM/YYYY HH24:MI') for IN26572 --18/02/2011
				}
				else if(administration_status!=null && administration_status.equals("DOA")){ // else if condition added for GHL-CRF-0458 - Start
					appendString = appendString + "AND  ( (A.SCH_DATE_TIME BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND TO_DATE(?,'DD/MM/YYYY HH24:MI') AND (ADMIN_RECORDED_YN='Y')) OR (H.FREQ_NATURE='P' and d.start_date_time <  TO_DATE('"+to_time+"','DD/MM/YYYY HH24:MI') AND (D.ORDER_QTY-NVL(I.TOT_ADMINISTERED_QTY,0))>0 )) "; // added and d.start_date_time <  TO_DATE('"+to_time+"','DD/MM/YYYY HH24:MI') for IN26572 --18/02/2011
				} // else if condition added for GHL-CRF-0458 - End
				if(!order_type.equals("TPN")){
					if(!route_admin.equals("")){
						appendString = appendString+"AND d.route_code ='"+route_admin+"' ";
					}
					else if(!admin_rout_categ.equals("")){
						ArrayList admRoutes=getAdminRoute(admin_rout_categ.trim());
						String aString="";
						for(int index=0;index<admRoutes.size();index+=2){
							aString=aString+"'"+admRoutes.get(index)+"',";
						}
						if(!aString.equals(""))
							aString=aString.substring(0,(aString.length()-1));
						else
							aString="''";
						appendString=appendString+" and d.ROUTE_CODE IN("+aString+")";					
					}
				}
				if(appendString==null)
					appendString="";
				if(hold_discontinue_yn.equals("N")){
					appendString = appendString + "AND d.HOLD_DATE_TIME IS NULL AND DISC_DATE_TIME IS NULL AND CAN_DATE_TIME IS NULL";	
				}			
				String order_by_str= " ORDER BY E.IV_PREP_YN, DECODE(E.IV_PREP_YN,'1',to_char(a.sch_date_time,'yyyymmddhh24:mi')||D.ORDER_ID||to_char(D.ORDER_LINE_NUM),'3',to_char(a.sch_date_time,'yyyymmddhh24:mi')||D.ORDER_ID||to_char(D.ORDER_LINE_NUM),'9',to_char(a.sch_date_time,'yyyymmddhh24:mi')||D.ORDER_ID||to_char(D.ORDER_LINE_NUM), "+display_order_str+"), a.DOSAGE_SEQ_NO";

				strQuery = strQuery + appendString + order_by_str;
				pstmt_select = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT12") ) ; 
				pstmt_select_drug_count = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT_DRUGS_COUNT") ) ;
				int i=0;
				System.out.println("---MedicationAdministrationFTBean.java-----------strQuery-------------->"+strQuery);
				pstmt = connection.prepareStatement( strQuery ) ;
				pstmt.setString(++i,locale );
				pstmt.setString(++i,locale );
				pstmt.setString(++i,locale );
				pstmt.setString(++i,locale );
				pstmt.setString(++i,locale );
				pstmt.setString(++i,locale );
				pstmt.setString(++i,locale );
				pstmt.setString(++i,locale );
				pstmt.setString(++i,locale );
				System.out.println("		------------>"+locale);
				System.out.println("		------------>"+locale);
				System.out.println("		------------>"+locale);
				System.out.println("		------------>"+locale);
				System.out.println("		------------>"+locale);
				System.out.println("		------------>"+locale);
				System.out.println("		------------>"+locale);
				System.out.println("		------------>"+locale);
				System.out.println("		------------>"+locale);
				if(!order_type.equals("TPN")){				
					pstmt.setString(++i,locale );
					pstmt.setString(++i,locale );
					pstmt.setString(++i,login_facility_id);
					pstmt.setString(++i,encounter_id.trim());			
					pstmt.setString(++i,locale );
					pstmt.setString(++i,from_time );
					pstmt.setString(++i,to_time );
					System.out.println("		------------>"+locale);
					System.out.println("		------------>"+locale);
					System.out.println("		------------>"+login_facility_id);
					System.out.println("		------------>"+encounter_id.trim());
					System.out.println("		------------>"+locale);
					System.out.println("		------------>"+from_time);
					System.out.println("		------------>"+to_time);
				}
				else{
					pstmt.setString(++i,login_facility_id);
					pstmt.setString(++i,encounter_id.trim());			
					pstmt.setString(++i,locale );
					pstmt.setString(++i,from_time );
					pstmt.setString(++i,to_time );
					System.out.println("		------------>"+login_facility_id);
					System.out.println("		------------>"+encounter_id.trim());
					System.out.println("		------------>"+locale);
					System.out.println("		------------>"+from_time);
					System.out.println("		------------>"+to_time);
				}	
				
				try{
					resultSet = pstmt.executeQuery() ;
				}
				catch(Exception e){
					e.printStackTrace();
				}

				while ( resultSet != null && resultSet.next() ) {
					drug_count = "1";
					ext_prod_id = "";
					iv_prep_yn =resultSet.getString("IV_PREP_YN")==null?"":resultSet.getString("IV_PREP_YN");
					route_code =resultSet.getString("route_code")==null?"":resultSet.getString("route_code");
					setOrderPatientClass(checkForNull(resultSet.getString("ORDER_ID")),resultSet.getString("patient_class"));//GHL-CRF-0458
					if(!route_code.equals("")){
						pstmt_route_code =connection.prepareStatement("SELECT ROUTE_DESC,ROUTE_COLOR FROM PH_ROUTE_LANG_VW WHERE LANGUAGE_ID=? AND ROUTE_CODE=? ");
						pstmt_route_code.setString(1,locale);
						pstmt_route_code.setString(2,route_code);
						resultSet_route_code=pstmt_route_code.executeQuery();
						if(resultSet_route_code!=null && resultSet_route_code.next()){
							route_desc = resultSet_route_code.getString("ROUTE_DESC")==null ? "":resultSet_route_code.getString("ROUTE_DESC");
							route_color = resultSet_route_code.getString("ROUTE_COLOR")==null ? "":resultSet_route_code.getString("ROUTE_COLOR"); // Chnages For CRF - 0034
						}
						try{
							if(!order_type.equals("A")){
								closeResultSet( resultSet_route_code ) ;
								closeStatement( pstmt_route_code ) ;
							}
						}
						catch(Exception es){
							es.printStackTrace() ;
						}
					}

					if(!order_type.equals("TPN")&& !iv_prep_yn.equals("6")){
						drugCode = resultSet.getString("DRUG_CODE");
						pstmt_ext_drug_code				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_EXT_PRODUCT_ID")) ;
						pstmt_ext_drug_code.setString(1,drugCode);
						pstmt_ext_drug_code.setString(2,login_facility_id);
						resultSet_ext_drug_code			= pstmt_ext_drug_code.executeQuery();
						if(resultSet_ext_drug_code!=null && resultSet_ext_drug_code.next()){
							ext_prod_id = resultSet_ext_drug_code.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet_ext_drug_code.getString("EXTERNAL_PRODUCT_ID");
						}
						try{
							closeResultSet( resultSet_ext_drug_code ) ;
							closeStatement( pstmt_ext_drug_code ) ;
						}catch(Exception es){
							es.printStackTrace() ;
						}
					}
					if(iv_prep_yn.equals("")||iv_prep_yn.equals("1")||iv_prep_yn.equals("3")||iv_prep_yn.equals("5")||iv_prep_yn.equals("9")){
						
						order_id = resultSet.getString("ORDER_ID");
						order_line_num = resultSet.getString("ORDER_LINE_NUM");
						drugCode = resultSet.getString("DRUG_CODE");					
						pstmt_ext_drug_code				= connection.prepareStatement("SELECT trade_code from or_order_line_ph where order_id=? and order_line_num = ?") ;
						pstmt_ext_drug_code.setString(1,order_id);
						pstmt_ext_drug_code.setString(2,order_line_num);
						resultSet_ext_drug_code			= pstmt_ext_drug_code.executeQuery();
						if(resultSet_ext_drug_code!=null && resultSet_ext_drug_code.next()){
							trade_code = resultSet_ext_drug_code.getString("TRADE_CODE")==null ? "":resultSet_ext_drug_code.getString("TRADE_CODE");
						}
						try{
							closeResultSet( resultSet_ext_drug_code ) ;
							closeStatement( pstmt_ext_drug_code ) ;
						}catch(Exception es){
							es.printStackTrace() ;
						}
						imageFileURL = Imagebean.getImagePath(drugCode,trade_code,connection);
					}
					else
						imageFileURL = "";
					if(iv_prep_yn.equals("")||iv_prep_yn.equals("0")||iv_prep_yn.equals("6")||iv_prep_yn.equals("7")||iv_prep_yn.equals("8")||iv_prep_yn.equals("9")){
						non_iv_drug_details.add(resultSet.getString("DRUG_CODE"));//1
						non_iv_drug_details.add(resultSet.getString("DRUG_DESC"));//2
						non_iv_drug_details.add(resultSet.getString("QTY"));//3
						non_iv_drug_details.add(resultSet.getString("SHORT_DESC"));	//4				
						non_iv_drug_details.add(resultSet.getString("BATCH_ID"));//5
						str_date= resultSet.getString("EXPIRY_DATE");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
						}
						non_iv_drug_details.add(str_date); //6
						non_iv_drug_details.add(resultSet.getString("TRADENAME"));//7
						non_iv_drug_details.add(resultSet.getString("ITEMCODE"));//8
						if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8")){
							non_iv_drug_details.add("");//9
						}
						else{
							non_iv_drug_details.add(resultSet.getString("DISP_MULTI_STRENGTH_YN"));//9
						}
						non_iv_drug_details.add(resultSet.getString("ADMIN_RECORDED_YN"));//10
						non_iv_drug_details.add(resultSet.getString("VERIFY_REQD_YN"));//11
						non_iv_drug_details.add(resultSet.getString("VERIFICATION_STATUS"));//12
						non_iv_drug_details.add(resultSet.getString("MEDN_ADMIN_STATUS"));//13
						non_iv_drug_details.add(resultSet.getString("ORDER_ID"));	//14				
						non_iv_drug_details.add(resultSet.getString("ORDER_LINE_NUM"));	//15				
						non_iv_drug_details.add(resultSet.getString("PATIENT_ID"));//16

						str_date= resultSet.getString("SCH_DATE_TIME");
						if(iv_prep_yn.equals("9")){
							order_id = resultSet.getString("ORDER_ID");
							pstmt_select_drug_count.setString(1,order_id);
							pstmt_select_drug_count.setString(2,str_date);
							resultSet_drug_count = pstmt_select_drug_count.executeQuery();
							if(resultSet_drug_count!=null && resultSet_drug_count.next())
								drug_count = resultSet_drug_count.getString("NO_OF_DRUGS");
							closeResultSet(resultSet_drug_count);
						}
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						non_iv_drug_details.add(str_date); //17
						//non_iv_drug_details.add(resultSet.getString("SCH_DATE_TIME"));
						non_iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//18
						non_iv_drug_details.add(resultSet.getString("TRADEID"));//19
						non_iv_drug_details.add(resultSet.getString("DISCONTINUED"));//20
						non_iv_drug_details.add(resultSet.getString("HELD"));		//21			
						non_iv_drug_details.add(resultSet.getString("ADMINISTERED_YN"));//22
						non_iv_drug_details.add(resultSet.getString("ADMIN_RECORDED_YN"));//23
						String administered="";
						administered = resultSet.getString("ADMINISTERED_YN");
						
						if(administered==null)administered="";
						if(administered.equals("N")){
							non_iv_drug_details.add(resultSet.getString("NON_ADMIN_REMARKS"));//24
						}
						else if(administered.equals("Y")){
							non_iv_drug_details.add(resultSet.getString("ADMIN_REMARKS"));//24
						}
						else{
							non_iv_drug_details.add("");//24
						}
						non_iv_drug_details.add(resultSet.getString("ADMINISTEREDDRUG"));		//25	
						non_iv_drug_details.add(resultSet.getString("USERNAME"));//26

						str_date= resultSet.getString("ADMIN_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						non_iv_drug_details.add(str_date);//27
						//non_iv_drug_details.add(resultSet.getString("ADMIN_DATE_TIME"));

						/*str_date= resultSet.getString("MODIFIED_DATE");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						non_iv_drug_details.add(str_date);//28*/

						non_iv_drug_details.add(resultSet.getString("MODIFIED_DATE")); //28
						non_iv_drug_details.add(resultSet.getString("PRES_DRUG_CODE"));//29
					
						pstmt_select.setString(1,resultSet.getString("ORDER_ID"));
						resultSet_1	=	pstmt_select.executeQuery();
						
						if(resultSet_1!=null && resultSet_1.next()){
							non_iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//30
						} 
						else {
							non_iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//30
						}
						try{
							closeResultSet( resultSet_1 ) ;
						}
						catch(Exception e){
							e.printStackTrace();
						}

						non_iv_drug_details.add(resultSet.getString("DRUG_CLASS"));//31
						non_iv_drug_details.add(resultSet.getString("AUTHORIZED_BY"));//32
						
						str_date= resultSet.getString("END_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						non_iv_drug_details.add(str_date);//33

						//non_iv_drug_details.add(resultSet.getString("END_DATE_TIME"));
						non_iv_drug_details.add(resultSet.getString("FREQ_CODE"));//34
						non_iv_drug_details.add(resultSet.getString("FREQ_NATURE"));//35
						non_iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//36
						non_iv_drug_details.add(resultSet.getString("PRACT_ID"));//37
						
						str_date= resultSet.getString("AGAINST_SCHDOSE_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						non_iv_drug_details.add(str_date);//38

						//non_iv_drug_details.add(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
						non_iv_drug_details.add(resultSet.getString("ADR_REASON_CODE"));//39
						non_iv_drug_details.add(resultSet.getString("ADR_REMARKS"));//40
						
						str_date= resultSet.getString("ADR_RECORDED_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						non_iv_drug_details.add(str_date);//41

						//non_iv_drug_details.add(resultSet.getString("ADR_RECORDED_DATE_TIME"));
						non_iv_drug_details.add(resultSet.getString("ADR_RECORDED_BY"));//42
						non_iv_drug_details.add(resultSet.getString("QTY_VALUE"));//43
						non_iv_drug_details.add(resultSet.getString("QTY_UNIT"));//44
						non_iv_drug_details.add(resultSet.getString("IV_PREP_YN"));//45

						if(order_type.equals("TPN")){
							non_iv_drug_details.add("N");//46
							 non_iv_drug_details.add("");//47
							 non_iv_drug_details.add("");//48
							 non_iv_drug_details.add("");//49
							 non_iv_drug_details.add("");//50
							 non_iv_drug_details.add("");//51
							 non_iv_drug_details.add("");//52
							 non_iv_drug_details.add("");//53

						}
						else{
						   non_iv_drug_details.add(resultSet.getString("MEDN_ADMN_DTL_REQD_YN"));//46

							prn_remarks				=resultSet.getString("PRN_REMARKS")==null?"":resultSet.getString("PRN_REMARKS");
							Slidingscale_remarks	=resultSet.getString("SLIDING_SCALE_REMARKS")==null?"":resultSet.getString("SLIDING_SCALE_REMARKS");
							action_seq_num			="1";
							order_line_seq_num		=resultSet.getString("order_line_seq_num")==null?"":resultSet.getString("order_line_seq_num");
							non_iv_drug_details.add(prn_remarks);//47
							non_iv_drug_details.add(Slidingscale_remarks);//48
							non_iv_drug_details.add(action_seq_num);//49
							non_iv_drug_details.add(order_line_seq_num);//50
							non_iv_drug_details.add(ext_prod_id);//51
							non_iv_drug_details.add(trade_code);//52
							non_iv_drug_details.add(imageFileURL);//53
						}
						non_iv_drug_details.add(resultSet.getString("IV_INGREDIANTS"));//54					
						non_iv_drug_details.add(route_desc);//55
						non_iv_drug_details.add(resultSet.getString("PRES_CATG_CODE"));//56
						non_iv_drug_details.add(resultSet.getString("schedule_uom_desc"));//57 
						non_iv_drug_details.add(resultSet.getString("sch_dosage_uom_code"));//58
						
						non_iv_drug_details.add(resultSet.getString("PATIENT_BROUGHT_MEDICATION_YN")==null?"N":resultSet.getString("PATIENT_BROUGHT_MEDICATION_YN"));//59
						non_iv_drug_details.add(resultSet.getString("SLIDING_SCALE_YN")==null?"N":resultSet.getString("SLIDING_SCALE_YN"));//60
						if(!order_type.equals("TPN")){						
							non_iv_drug_details.add(resultSet.getString("STRENGTH_VALUE")==null?"":resultSet.getString("STRENGTH_VALUE"));//61
							non_iv_drug_details.add(resultSet.getString("SCH_STRENGTH")==null?"":resultSet.getString("SCH_STRENGTH"));//62
						}
						else{						
							non_iv_drug_details.add("");//61
							non_iv_drug_details.add("");//62						
						}
						non_iv_drug_details.add(resultSet.getString("MEDN_BROUGHT_BY_PATIENT_YN")==null?"N":resultSet.getString("MEDN_BROUGHT_BY_PATIENT_YN"));//63
						non_iv_drug_details.add(resultSet.getString("DOSAGE_TYPE")==null?"Q":resultSet.getString("DOSAGE_TYPE"));//64 53hello
						non_iv_drug_details.add(resultSet.getString("DOSAGE")==null?"":resultSet.getString("DOSAGE"));//65
						non_iv_drug_details.add(resultSet.getString("DOSAGE_UOM_CODE")==null?"":resultSet.getString("DOSAGE_UOM_CODE"));//66
						non_iv_drug_details.add(resultSet.getString("DOSAGE_UOM_DESC")==null?"":resultSet.getString("DOSAGE_UOM_DESC"));//67
						if(!order_type.equals("TPN")){
							non_iv_drug_details.add(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null?"1":resultSet.getString("CONTENT_IN_PRES_BASE_UOM"));//68
							non_iv_drug_details.add(resultSet.getString("SCH_STRENGTH_UOM")==null?"":resultSet.getString("SCH_STRENGTH_UOM"));//69
							non_iv_drug_details.add(resultSet.getString("SCH_STRENGTH_UOM_DESC")==null?"":resultSet.getString("SCH_STRENGTH_UOM_DESC"));//70
							
							non_iv_drug_details.add(resultSet.getString("ADMN_DOSE_CHNG_REMARKS")==null?"":resultSet.getString("ADMN_DOSE_CHNG_REMARKS")); //71
						}
						else{
							non_iv_drug_details.add("");//68	
							non_iv_drug_details.add("");//69	
							non_iv_drug_details.add("");//70	
							non_iv_drug_details.add(resultSet.getString("ADMN_DOSE_CHNG_REMARKS")==null?"":resultSet.getString("ADMN_DOSE_CHNG_REMARKS")); //71
						}
						non_iv_drug_details.add(drug_count);  //72  drug count for Oncology Direct Order
						if(!order_type.equals("TPN")){
							non_iv_drug_details.add(resultSet.getString("VACC_CATEGORY_LINK"));//73 linked vaccine schedule
						}
						else{
							non_iv_drug_details.add("");//73 linked vaccine schedule  
						}
						non_iv_drug_details.add(resultSet.getString("PERFORMING_DEPTLOC_CODE"));//74
						non_iv_drug_details.add(resultSet.getString("PRES_BASE_UOM"));//75

						prescribe_mode.put(resultSet.getString("ORDER_ID")+resultSet.getString("ORDER_LINE_NUM"),resultSet.getString("PRESCRIBED_MODE"));
						non_iv_drug_details.add(route_color);//76 route color Check RUT -CRF - 0034
						non_iv_drug_details.add(resultSet.getString("ORD_PRACT_ID")==null?"":resultSet.getString("ORD_PRACT_ID"));//77  Prescribing pract id //Added for [IN:040149]
						non_iv_drug_details.add(chkfortapering(order_id, drugCode, (String)resultSet.getString("PATIENT_ID"))); // 78   //Added for RUT-CRF-0088 [IN036978]
						if(!order_type.equals("TPN")){// Added for RUT-CRF-0065.1 [IN:43255]
							non_iv_drug_details.add(resultSet.getString("GENERIC_ID"));//79 
						}
						else{// Added for RUT-CRF-0065.1 [IN:43255]
							non_iv_drug_details.add("");//79  
						}
						non_iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUG_DESC")));//71 - Alternate disp
						non_iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUGS"))); //72
						non_iv_drug_details.add(checkForNull(resultSet.getString("DISP_DRUG_CODE"))); //73 Anitha
						non_iv_drug_details.add(resultSet.getString("MFR_YN")==null?"N":resultSet.getString("MFR_YN"));//ML-MMOH-CRF-1014
						non_iv_drug_details.add(resultSet.getString("MFR_REMARKS")==null?"":resultSet.getString("MFR_REMARKS")); 
						non_iv_drug_details.add(resultSet.getString("PLACED_FROM_VERBAL_ORDER"));//added for ghl-crf-0509
						non_iv_drug_details.add(resultSet.getString("ORDER_STATUS"));//added for GHL-CRF-0482
						if(iv_prep_yn.equals("")){
							non_iv_drug_details.add(resultSet.getString("PATIENT_STOCK_REQUIRED"));//added for GHL-CRF-0482
							non_iv_drug_details.add(resultSet.getString("PATIENT_STOCK_COMPLETED"));//added for GHL-CRF-0482
							non_iv_drug_details.add(resultSet.getString("PATIENT_STOCK_YN"));//added for GHL-CRF-0482
							
						}
						else{
							non_iv_drug_details.add("N");//added for GHL-CRF-0482
							non_iv_drug_details.add("N");//added for GHL-CRF-0482
							non_iv_drug_details.add("N");//added for GHL-CRF-0482
						}
						
						non_iv_drug_details.add(checkForNull(resultSet.getString("CANCEL_RECORDED_YN")));//ADDED FOR JD-CRF-0200
						split_dose_YN.put(resultSet.getString("ORDER_ID")+resultSet.getString("ORDER_LINE_NUM"),resultSet.getString("SPLIT_DOSE_YN"));//ML-MMOH-SCF-1439
					}
					else{
						if( (resultSet.getString("IV_PREP_YN").equals("2") || resultSet.getString("IV_PREP_YN").equals("4"))) {
							if(resultSet.getString("ORDER_LINE_NUM").equals("1")) {
								iv_drug_details.add(resultSet.getString("IV_INGREDIANTS"));//1
								iv_drug_details.add(resultSet.getString("SCH_INFUSION_RATE"));//2
								iv_drug_details.add(resultSet.getString("SCH_INFUSION_VOL_STR_UNIT"));//3  -- here the short_desc from am_uom will be displayed
								iv_drug_details.add(resultSet.getString("SCH_INFUSION_PER_UNIT"));//4
								iv_drug_details.add(resultSet.getString("BATCH_ID"));//5
						
								str_date= resultSet.getString("EXPIRY_DATE");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
								}
								iv_drug_details.add(str_date);//6

								//iv_drug_details.add(resultSet.getString("EXPIRY_DATE"));
								iv_drug_details.add(resultSet.getString("TRADEID"));//7
								iv_drug_details.add(resultSet.getString("TRADENAME"));//8
								iv_drug_details.add(resultSet.getString("ITEMCODE"));//9
								iv_drug_details.add(resultSet.getString("PATIENT_ID"));//10
								iv_drug_details.add(resultSet.getString("DRUG_CODE"));//11
								iv_drug_details.add(resultSet.getString("DRUG_DESC"));//12
						
								str_date= resultSet.getString("SCH_DATE_TIME");
								order_id = resultSet.getString("ORDER_ID");
								pstmt_select_drug_count.setString(1,order_id);
								pstmt_select_drug_count.setString(2,str_date);
								resultSet_drug_count = pstmt_select_drug_count.executeQuery();
								if(resultSet_drug_count!=null && resultSet_drug_count.next())
									drug_count = resultSet_drug_count.getString("NO_OF_DRUGS");

								closeResultSet(resultSet_drug_count);

								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								iv_drug_details.add(str_date);//13

								//iv_drug_details.add(resultSet.getString("SCH_DATE_TIME"));
								iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//14
								iv_drug_details.add(order_id);	//15

								iv_drug_details.add(resultSet.getString("ORDER_LINE_NUM"));//16
								iv_drug_details.add(resultSet.getString("QTY"));//17
								iv_drug_details.add(resultSet.getString("SHORT_DESC"));	//18
								iv_drug_details.add(resultSet.getString("DISCONTINUED"));//19
								iv_drug_details.add(resultSet.getString("HELD"));	//20
								iv_drug_details.add(resultSet.getString("SCH_INFUSION_PERIOD"));	//21
								iv_drug_details.add(resultSet.getString("SCH_INFUSION_PERIOD_UNIT"));	//22
								iv_drug_details.add(resultSet.getString("ADMINISTERED_YN"));//23
								iv_drug_details.add(resultSet.getString("ADMIN_RECORDED_YN"));//24
								String administered = resultSet.getString("ADMINISTERED_YN");

								if(administered==null)
									administered="";
								if(administered.equals("N")){
									iv_drug_details.add(resultSet.getString("NON_ADMIN_REMARKS"));//25
								}
								else if(administered.equals("Y")){
									iv_drug_details.add(resultSet.getString("ADMIN_REMARKS"));//25
								}
								else{
									iv_drug_details.add("");//25
								}
								iv_drug_details.add(resultSet.getString("ADMINISTEREDDRUG"));	//26
								iv_drug_details.add(resultSet.getString("USERNAME"));//27
						
								str_date= resultSet.getString("ADMIN_DATE_TIME");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								iv_drug_details.add(str_date);//28

								//iv_drug_details.add(resultSet.getString("ADMIN_DATE_TIME"));
						
								/*str_date= resultSet.getString("MODIFIED_DATE");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								iv_drug_details.add(str_date);//29*/

								iv_drug_details.add(resultSet.getString("MODIFIED_DATE"));//29
								iv_drug_details.add(resultSet.getString("PRES_DRUG_CODE"));//30
								
								pstmt_select.setString(1,resultSet.getString("ORDER_ID"));
								resultSet_1	=	pstmt_select.executeQuery();
								
								if(resultSet_1!=null && resultSet_1.next()){
									iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//31
								} 
								else {
									iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//31
								}
								try{
									closeResultSet( resultSet_1 ) ;
								}
								catch(Exception e){
									e.printStackTrace();
								}
								iv_drug_details.add(resultSet.getString("DRUG_CLASS"));//32
								iv_drug_details.add(resultSet.getString("AUTHORIZED_BY"));//33
						
								str_date= resultSet.getString("END_DATE_TIME");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								iv_drug_details.add(str_date);//34

								//iv_drug_details.add(resultSet.getString("END_DATE_TIME"));
								iv_drug_details.add(resultSet.getString("FREQ_CODE"));//35
								iv_drug_details.add(resultSet.getString("FREQ_NATURE"));//36
								iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//37
								iv_drug_details.add(resultSet.getString("PRACT_ID"));//38
						
								str_date= resultSet.getString("AGAINST_SCHDOSE_DATE_TIME");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								iv_drug_details.add(str_date);//39

								//iv_drug_details.add(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
								iv_drug_details.add(resultSet.getString("ADR_REASON_CODE"));  //40        
								iv_drug_details.add(resultSet.getString("ADR_REMARKS")); //41             
						
								str_date= resultSet.getString("ADR_RECORDED_DATE_TIME");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								iv_drug_details.add(str_date);//42

								//iv_drug_details.add(resultSet.getString("ADR_RECORDED_DATE_TIME"));   
								iv_drug_details.add(resultSet.getString("ADR_RECORDED_BY"));    //43
								iv_drug_details.add(resultSet.getString("IV_PREP_YN"));//44
								iv_drug_details.add(ext_prod_id);//45
								iv_drug_details.add(drug_count);//46
								iv_drug_details.add(trade_code);//47
								iv_drug_details.add(imageFileURL);//48
								iv_drug_details.add(route_desc);//49
								iv_drug_details.add(resultSet.getString("PRES_CATG_CODE"));//50
								iv_drug_details.add(resultSet.getString("schedule_uom_desc"));//51
								iv_drug_details.add(resultSet.getString("sch_dosage_uom_code"));//52		
								iv_drug_details.add(resultSet.getString("ADMN_DOSE_CHNG_REMARKS")==null?"":resultSet.getString("ADMN_DOSE_CHNG_REMARKS")); //53
								iv_drug_details.add(""); //54 linked vaccine schedule
								iv_drug_details.add(resultSet.getString("MFR_YN")); //55 MultiFlowRateYN
								iv_drug_details.add(resultSet.getString("FLOW_STATUS")); //56 this is for single FlowRate
								iv_drug_details.add(resultSet.getString("HOLD_DATE_TIME")); //57 this is for single FlowRate in iv
								iv_drug_details.add(resultSet.getString("HOLD_DURN_IN_MINS")); //58 this is for single FlowRate in iv
								iv_drug_details.add(resultSet.getString("RESUME_DATE_TIME")); //59 this is for single FlowRate in iv
								iv_drug_details.add(resultSet.getString("ACT_START_DATE_TIME")); //60 this is for single FlowRate in iv
								iv_drug_details.add(resultSet.getString("ACT_END_DATE_TIME")); //61 this is for single FlowRate in iv
								iv_drug_details.add(resultSet.getString("DOSAGE_TYPE")); //62 
								iv_drug_details.add(resultSet.getString("MFR_REMARKS")); //63 MFR REMARKS CAPTURED WHILE ORDERING TIME 	
								iv_drug_details.add(resultSet.getString("COMPLETED_DURN_IN_MINS")); //64 if you change flow rate in mid of Single Flow Rate previous flow rate's duration will be captured
								iv_drug_details.add(resultSet.getString("COMPLETED_VOLUME")); //65 if you change flow rate in mid of Single Flow Rate previous flow rate's completed volume will be captured
								iv_drug_details.add(resultSet.getString("PERFORMING_DEPTLOC_CODE")); //66
								iv_drug_details.add(resultSet.getString("sch_infusion_vol_str_unit_desc")); //67 - sch_infusion_vol_str_unit desc 
								iv_drug_details.add(route_color);// 68 added for Route Color RUT- CRF - 0034
								iv_drug_details.add(resultSet.getString("ORD_PRACT_ID")); //69 - //Added for [IN:040149]
								iv_drug_details.add(resultSet.getString("GENERIC_ID")); //70 // Added for RUT-CRF-0065.1 [IN:43255]
								iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUG_DESC")));//71 - Alternate disp
								iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUGS"))); //72
								iv_drug_details.add(checkForNull(resultSet.getString("DISP_DRUG_CODE"))); //73
								iv_drug_details.add(checkForNull(resultSet.getString("CANCEL_RECORDED_YN"))); //73//ADDED FOR JD-CRF-0200

								prescribe_mode.put(resultSet.getString("ORDER_ID")+resultSet.getString("ORDER_LINE_NUM"),resultSet.getString("PRESCRIBED_MODE"));
							}
						}
						else {
							iv_drug_details.add(resultSet.getString("IV_INGREDIANTS"));//1
							iv_drug_details.add(resultSet.getString("SCH_INFUSION_RATE"));//2
							iv_drug_details.add(resultSet.getString("SCH_INFUSION_VOL_STR_UNIT"));//3  -- here the short_desc from am_uom will be displayed
							iv_drug_details.add(resultSet.getString("SCH_INFUSION_PER_UNIT"));//4					
							iv_drug_details.add(resultSet.getString("BATCH_ID"));//5
					
							str_date= resultSet.getString("EXPIRY_DATE");
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
							}
							iv_drug_details.add(str_date);//6

							//iv_drug_details.add(resultSet.getString("EXPIRY_DATE"));
							iv_drug_details.add(resultSet.getString("TRADEID"));//7
							iv_drug_details.add(resultSet.getString("TRADENAME"));//8
							iv_drug_details.add(resultSet.getString("ITEMCODE"));//9
							iv_drug_details.add(resultSet.getString("PATIENT_ID"));//10
							iv_drug_details.add(resultSet.getString("DRUG_CODE"));//11
							iv_drug_details.add(resultSet.getString("DRUG_DESC"));//12

							str_date= resultSet.getString("SCH_DATE_TIME");
							order_id = resultSet.getString("ORDER_ID");
							pstmt_select_drug_count.setString(1,order_id);
							pstmt_select_drug_count.setString(2,str_date);
							resultSet_drug_count = pstmt_select_drug_count.executeQuery();
							if(resultSet_drug_count!=null && resultSet_drug_count.next())
								drug_count = resultSet_drug_count.getString("NO_OF_DRUGS");

							closeResultSet(resultSet_drug_count);
					
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							iv_drug_details.add(str_date);//13

							//iv_drug_details.add(resultSet.getString("SCH_DATE_TIME"));
							iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//14
							iv_drug_details.add(resultSet.getString("ORDER_ID"));		//15			
							iv_drug_details.add(resultSet.getString("ORDER_LINE_NUM"));//16
							iv_drug_details.add(resultSet.getString("QTY"));//17
							iv_drug_details.add(resultSet.getString("SHORT_DESC"));//18	
							iv_drug_details.add(resultSet.getString("DISCONTINUED"));//19
							iv_drug_details.add(resultSet.getString("HELD"));	//20
							iv_drug_details.add(resultSet.getString("SCH_INFUSION_PERIOD"));	//21
							iv_drug_details.add(resultSet.getString("SCH_INFUSION_PERIOD_UNIT"));//22	
							iv_drug_details.add(resultSet.getString("ADMINISTERED_YN"));//23
							iv_drug_details.add(resultSet.getString("ADMIN_RECORDED_YN"));//24
							String administered = resultSet.getString("ADMINISTERED_YN");
							
							if(administered==null)
								administered="";
							if(administered.equals("N")){
								iv_drug_details.add(resultSet.getString("NON_ADMIN_REMARKS"));//25
							}
							else if(administered.equals("Y")){
								iv_drug_details.add(resultSet.getString("ADMIN_REMARKS"));//25
							}
							else{
								iv_drug_details.add("");//25
							}
							iv_drug_details.add(resultSet.getString("ADMINISTEREDDRUG"));	//26
							iv_drug_details.add(resultSet.getString("USERNAME"));//27
					
							str_date= resultSet.getString("ADMIN_DATE_TIME");
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							iv_drug_details.add(str_date);//28

							//iv_drug_details.add(resultSet.getString("ADMIN_DATE_TIME"));
					
							/*str_date= resultSet.getString("MODIFIED_DATE");
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							iv_drug_details.add(str_date);//29*/

							iv_drug_details.add(resultSet.getString("MODIFIED_DATE"));//29
							iv_drug_details.add(resultSet.getString("PRES_DRUG_CODE"));//30
							
							pstmt_select.setString(1,resultSet.getString("ORDER_ID"));
							resultSet_1	=	pstmt_select.executeQuery();
							
							if(resultSet_1!=null && resultSet_1.next()){
								iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//31
							}
							else {
								iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//31
							}
							try{
								closeResultSet( resultSet_1 ) ;
							}
							catch(Exception e){
								e.printStackTrace();
							}

							iv_drug_details.add(resultSet.getString("DRUG_CLASS"));//32
							iv_drug_details.add(resultSet.getString("AUTHORIZED_BY"));//33
					
							str_date= resultSet.getString("END_DATE_TIME");
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							iv_drug_details.add(str_date);//34

							//iv_drug_details.add(resultSet.getString("END_DATE_TIME"));
							iv_drug_details.add(resultSet.getString("FREQ_CODE"));//35
							iv_drug_details.add(resultSet.getString("FREQ_NATURE"));//36
							iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//37
							iv_drug_details.add(resultSet.getString("PRACT_ID"));//38
					
							str_date= resultSet.getString("AGAINST_SCHDOSE_DATE_TIME");
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							iv_drug_details.add(str_date);//39

							//iv_drug_details.add(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
							iv_drug_details.add(resultSet.getString("ADR_REASON_CODE"));          //40
							iv_drug_details.add(resultSet.getString("ADR_REMARKS"));              //41
					
							str_date= resultSet.getString("ADR_RECORDED_DATE_TIME");
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							iv_drug_details.add(str_date);//42

							//iv_drug_details.add(resultSet.getString("ADR_RECORDED_DATE_TIME"));   
							iv_drug_details.add(resultSet.getString("ADR_RECORDED_BY")); //43
							iv_drug_details.add(resultSet.getString("IV_PREP_YN"));//44
							iv_drug_details.add(ext_prod_id);//45
							iv_drug_details.add(drug_count);//46
							iv_drug_details.add(trade_code);//47
							iv_drug_details.add(imageFileURL);	//48						
							iv_drug_details.add(route_desc);	//49
							iv_drug_details.add(resultSet.getString("PRES_CATG_CODE"));//50
							iv_drug_details.add(resultSet.getString("schedule_uom_desc"));//51
							iv_drug_details.add(resultSet.getString("sch_dosage_uom_code"));//52	
							iv_drug_details.add(resultSet.getString("ADMN_DOSE_CHNG_REMARKS")==null?"":resultSet.getString("ADMN_DOSE_CHNG_REMARKS")); //53
							iv_drug_details.add(resultSet.getString("VACC_CATEGORY_LINK"));//54 linked vaccine schedule
							iv_drug_details.add(resultSet.getString("MFR_YN")); //55 MultiFlowRateYN
							iv_drug_details.add(resultSet.getString("FLOW_STATUS")); //56 this is for single FlowRate
							iv_drug_details.add(resultSet.getString("HOLD_DATE_TIME")); //57 this is for single FlowRate in iv
							iv_drug_details.add(resultSet.getString("HOLD_DURN_IN_MINS")); //58 this is for single FlowRate in iv
							iv_drug_details.add(resultSet.getString("RESUME_DATE_TIME")); //59 this is for single FlowRate in iv
							iv_drug_details.add(resultSet.getString("ACT_START_DATE_TIME")); //60 this is for single FlowRate in iv
							iv_drug_details.add(resultSet.getString("ACT_END_DATE_TIME")); //61 this is for single FlowRate in iv
							iv_drug_details.add(resultSet.getString("DOSAGE_TYPE")); //62 
							iv_drug_details.add(resultSet.getString("MFR_REMARKS")); //63 MFR REMARKS CAPTURED WHILE ORDERING TIME 
							iv_drug_details.add(resultSet.getString("COMPLETED_DURN_IN_MINS")); //64 if you change flow rate in mid of Single Flow Rate previous flow rate's duration will be captured
							iv_drug_details.add(resultSet.getString("COMPLETED_VOLUME")); //65 if you change flow rate in mid of Single Flow Rate previous flow rate's completed volume will be captured
							iv_drug_details.add(resultSet.getString("PERFORMING_DEPTLOC_CODE")); //66 
							iv_drug_details.add(resultSet.getString("sch_infusion_vol_str_unit_desc")); //67 - sch_infusion_vol_str_unit desc
							iv_drug_details.add(route_color); //68 - Added for Route Color RUT- CRF - 0034
							iv_drug_details.add(resultSet.getString("ORD_PRACT_ID")==null?"":resultSet.getString("ORD_PRACT_ID"));//69 Prescribing pract id //Added for [IN:040149]
							iv_drug_details.add(resultSet.getString("GENERIC_ID")); //70 // Added for RUT-CRF-0065.1 [IN:43255]
							iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUG_DESC")));//71 - Alternate disp
							iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUGS"))); //72
							iv_drug_details.add(checkForNull(resultSet.getString("DISP_DRUG_CODE"))); //73
							iv_drug_details.add(checkForNull(resultSet.getString("CANCEL_RECORDED_YN"))); //73//ADDED FOR JD-CRF-0200
						}
					}
				}
				setPresMode(prescribe_mode);
			}
			catch ( Exception e ) {

				e.printStackTrace() ;
				throw e ;
			} 
			finally {
				try {
					if(!(order_type !=null && order_type.equals("A"))){
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
						closeStatement( pstmt_select ) ;
						closeResultSet( resultSet_1 ) ;
					}				                
					closeStatement( pstmt_select_drug_count ) ;				
				}
				catch(Exception es) { 
					es.printStackTrace();
				}
			}
			//to include TPN orders when order type is "all"
			if(order_type !=null && order_type.equals("A")){
				try {//O.PLACED_FROM_VERBAL_ORDER added for ghl-crf-0509// CANCEL_RECORDED_YN ADDED  FOR JD-CRF-0200
					strQuery ="SELECT a.CANCEL_RECORDED_YN,a.order_id, a.order_line_num, e.iv_prep_yn, a.admin_recorded_by username, a.admin_authorized_by authorized_by, a.admin_remarks, a.non_admin_remarks, a.admin_recorded_yn, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN (   f.admin_drug_code || ':' || (SELECT long_name FROM ph_tpn_regimen_lang_vw ph_tpn_regimen WHERE tpn_regimen_code = f.admin_drug_code AND language_id = ?) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) WHEN a.ord_drug_code = 'FINAL PRODUCT' and nvl(administered_yn,'N') = 'Y' then 'FINAL PRODUCT:'||((SELECT mfg_unit FROM ph_tpn_worksheet_hdr WHERE tpn_worksheet_id = (SELECT DISTINCT tpn_worksheet_id FROM ph_tpn_worksheet_dtl WHERE order_id = (SELECT DISTINCT order_id FROM ph_medn_admin WHERE order_id = a.order_id and order_line_num = a.order_line_num and nvl(administered_yn,'N' ) = 'Y'))) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code) END ) administereddrug,       a.dosage_seq_no, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY HH24:MI') sch_date_time, a.admin_recorded_yn, a.administered_yn, a.verify_reqd_yn, a.verification_status, a.medn_admin_status, NVL (a.iv_admin_yn, 'N') iv_admin_yn, DECODE (d.disc_date_time, NULL, 'N', 'Y') discontinued, DECODE (d.hold_date_time, NULL, 'N', 'Y') held, a.patient_id, a.pract_id, a.order_id, d.qty_value, d.qty_unit, d.freq_code,  NVL ((SELECT disp_drug_code FROM ph_disp_dtl WHERE ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND ROWNUM < 2), (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.long_name ELSE 'FINAL PRODUCT' END ) ) drug_code,(CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.tpn_regimen_code ELSE 'FINAL PRODUCT' END ) pres_drug_code,(CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT long_name FROM ph_tpn_regimen_lang_vw  ph_tpn_regimen, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_tpn_regimen.tpn_regimen_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2), b.long_name ) ELSE (SELECT mfg_unit FROM ph_tpn_worksheet_hdr HDR WHERE order_id = a.order_id AND ROWNUM<2) END ) drug_desc, Decode(ADMINISTERED_YN,'N',(CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT long_name FROM ph_tpn_regimen_lang_vw  ph_tpn_regimen, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_tpn_regimen.tpn_regimen_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2), b.long_name ) ELSE (SELECT mfg_unit FROM ph_tpn_worksheet_hdr HDR WHERE order_id = a.order_id AND ROWNUM<2) END )) dispensed_drug_desc, NVL (f.admin_dosage_qty, sch_dosage_qty) qty,  am_get_desc.am_uom(a.sch_dosage_uom_code,?,2) short_desc, a.iv_ingrediants, a.sch_infusion_rate, a.sch_infusion_vol_str_unit, a.sch_infusion_per_unit, a.sch_infusion_period, a.sch_infusion_period_unit, TO_CHAR (a.admin_date_time, 'DD/MM/YYYY HH24:MI') admin_date_time, TO_CHAR (a.modified_date, 'DD/MM/YYYY HH24:MI') modified_date, b.drug_class, b.item_code itemcode, TO_CHAR (d.end_date_time, 'DD/MM/YYYY HH24:MI') end_date_time, f.batch_id, TO_CHAR (f.expiry_date, 'DD/MM/YYYY') expiry_date, f.item_code, f.trade_id tradeid, am_get_desc.AM_TRADE_NAME(f.trade_id,?,2) tradename, h.freq_nature, TO_CHAR (a.against_schdose_date_time, 'DD/MM/YYYY HH24:MI' ) against_schdose_date_time, a.adr_reason_code, a.adr_remarks, TO_CHAR (a.adr_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) adr_recorded_date_time, a.adr_recorded_by, i.prescribed_mode, d.route_code, b.PRES_CATG_CODE , am_get_desc.am_uom(d.qty_unit,?,2) schedule_uom_desc,a.sch_dosage_uom_code sch_dosage_uom_code,o.PATIENT_BROUGHT_MEDICATION_YN,o.SLIDING_SCALE_YN sliding_scale_yn,a.MEDN_BROUGHT_BY_PATIENT_YN,o.DOSAGE_TYPE, i.DOSAGE, i.DOSAGE_UOM_CODE, am_get_desc.am_uom(i.dosage_uom_code,?,2) dosage_uom_desc,A.ADMN_DOSE_CHNG_REMARKS,e.PERFORMING_DEPTLOC_CODE, b.PRES_BASE_UNIT PRES_BASE_UOM, e.ORD_PRACT_ID, i.DISPENSED_DRUGS,(SELECT drug_code FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code<>ph_disp_dtl.pres_drug_code and ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2 ) disp_drug_code,e.patient_class,o.PLACED_FROM_VERBAL_ORDER,o.MFR_YN, o.MFR_REMARKS, e.order_status,(select PATIENT_STOCK_REQUIRED from ph_drug_lang_vw where drug_code = a.ord_drug_code and language_id = ?  )PATIENT_STOCK_REQUIRED,PATIENT_STOCK_COMPLETED,i.PATIENT_STOCK_YN ,o.SPLIT_DOSE_YN  FROM ph_medn_admin a, ph_tpn_regimen_lang_vw b, or_order_line d, or_order e, ph_medn_admin_dtl f, am_frequency h, ph_patient_drug_profile i, or_order_line_ph o WHERE h.freq_code = d.freq_code AND f.encounter_id(+) = a.encounter_id AND f.order_id(+) = a.order_id AND f.facility_id(+) = a.facility_id AND f.ord_drug_code(+) = a.ord_drug_code AND a.dosage_seq_no = f.dosage_seq_no(+) AND f.sch_date_time(+) = a.sch_date_time AND e.order_id = d.order_id AND o.order_id = d.order_id AND o.order_line_num = d.order_line_num AND i.orig_order_id = d.order_id AND i.orig_order_line_no = d.order_line_num AND e.order_id = i.orig_order_id AND a.ord_drug_code = b.tpn_regimen_code(+) AND a.order_id = d.order_id AND a.order_line_num = d.order_line_num AND a.facility_id =? AND a.encounter_id =? AND a.sch_date_time >= d.START_DATE_TIME AND SYSDATE <= d.end_date_time AND d.can_date_time IS NULL AND e.iv_prep_yn IN ('7','8') AND b.language_id(+) = ?";
					//e.patient_class added for GHL-CRF-0458 and PATIENT_STOCK_REQUIRED,PATIENT_STOCK_COMPLETED,PATIENT_STOCK_YN added for GHL-CRF-0482 and o.SPLIT_DOSE_YN added for ML-MMOH-SCF-1439

					if(administration_status!=null && (administration_status.equals("OVERDUE") || administration_status.equals("DUE"))){
						appendString =" AND SYSDATE<=D.END_DATE_TIME AND  (  (A.SCH_DATE_TIME BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND TO_DATE(?,'DD/MM/YYYY HH24:MI') AND (ADMIN_RECORDED_YN='N' OR ADMIN_RECORDED_YN IS NULL)) OR (H.FREQ_NATURE='P' AND (D.ORDER_QTY-NVL(I.TOT_ADMINISTERED_QTY,0))>0 ))   "; 
					} 
					else if(administration_status!=null && administration_status.equals("ALL")) {
						appendString = " AND ( (A.SCH_DATE_TIME BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND TO_DATE(?,'DD/MM/YYYY HH24:MI')) OR (H.FREQ_NATURE='P'  AND (D.ORDER_QTY-NVL(I.TOT_ADMINISTERED_QTY,0))>0 ) ) ";
					}
					else if(administration_status!=null && administration_status.equals("DOA")){ // else if condition added for GHL-CRF-0458 - Start
						appendString =" AND SYSDATE<=D.END_DATE_TIME AND  (  (A.SCH_DATE_TIME BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND TO_DATE(?,'DD/MM/YYYY HH24:MI') AND (ADMIN_RECORDED_YN='Y')) OR (H.FREQ_NATURE='P' AND (D.ORDER_QTY-NVL(I.TOT_ADMINISTERED_QTY,0))>0 ))   ";
					} // else if condition added for GHL-CRF-0458 - End
					/*if(!route_admin.equals(""))
						appendString = appendString+" AND d.route_code ='"+route_admin+"' ";*/

					if(appendString==null)
						appendString="";

					if(hold_discontinue_yn.equals("N")){
						strQuery = strQuery + (appendString + " AND d.HOLD_DATE_TIME IS NULL AND DISC_DATE_TIME IS NULL AND CAN_DATE_TIME IS NULL ORDER BY E.IV_PREP_YN, ");	
					}
					else{
						strQuery = strQuery + (appendString +" ORDER BY E.IV_PREP_YN, ");
					}

					if(display_order_by.equals("F")){					
							display_order_str = "D.ORDER_ID||to_char(a.sch_date_time,'yyyymmddhh24:mi')||to_char(D.ORDER_LINE_NUM)";							
					}				
					String order_by_str1= " DECODE(E.IV_PREP_YN,'1',D.ORDER_ID||to_char(a.sch_date_time,'yyyymmddhh24:mi')||to_char(D.ORDER_LINE_NUM),'3',D.ORDER_ID||to_char(a.sch_date_time,'yyyymmddhh24:mi')||to_char(D.ORDER_LINE_NUM),"+display_order_str+"),  a.DOSAGE_SEQ_NO";

					strQuery = strQuery + order_by_str1;
				  /* if(display_order_by.equals("F")){
					   display_order_by="";
					   strQuery = strQuery +"D.ORDER_ID,D.ORDER_LINE_NUM";
					   
				   }else{
						strQuery = strQuery + display_order_str+" ,D.ORDER_ID,D.ORDER_LINE_NUM";
				   }*/
					int i=0;
					pstmt = connection.prepareStatement( strQuery ) ;
					pstmt.setString(++i,locale );
					pstmt.setString(++i,locale );
					pstmt.setString(++i,locale );
					pstmt.setString(++i,locale );
					pstmt.setString(++i,locale );
					pstmt.setString(++i,locale );
					pstmt.setString(++i,locale );
					pstmt.setString(++i,locale );
					pstmt.setString(++i,locale );//added for GHL-CRF-0482
					pstmt.setString(++i,login_facility_id);
					pstmt.setString(++i,encounter_id.trim());			
					pstmt.setString(++i,locale );
					pstmt.setString(++i,from_time );
					pstmt.setString(++i,to_time );
					

					try{
						resultSet = pstmt.executeQuery() ;
					}
					catch(Exception e){
						e.printStackTrace();
					}
					while ( resultSet != null && resultSet.next() ){
						route_code =resultSet.getString("route_code")==null?"":resultSet.getString("route_code");
					setOrderPatientClass(checkForNull(resultSet.getString("ORDER_ID")),resultSet.getString("patient_class"));//GHL-CRF-0458
						if(!route_code.equals("")){
							pstmt_route_code =connection.prepareStatement("SELECT ROUTE_DESC,ROUTE_COLOR FROM PH_ROUTE_LANG_VW WHERE LANGUAGE_ID=? AND ROUTE_CODE=? ");
							pstmt_route_code.setString(1,locale);
							pstmt_route_code.setString(2,route_code);
							resultSet_route_code=pstmt_route_code.executeQuery();
							if(resultSet_route_code!=null && resultSet_route_code.next()){
								route_desc = resultSet_route_code.getString("ROUTE_DESC")==null ? "":resultSet_route_code.getString("ROUTE_DESC");
								route_color = resultSet_route_code.getString("ROUTE_COLOR")==null ? "":resultSet_route_code.getString("ROUTE_COLOR");//Code ADDED FOR RUT CRF 0034
							}
							try{
								closeResultSet( resultSet_route_code ) ;
								closeStatement( pstmt_route_code ) ;
							}
							catch(Exception es){
								es.printStackTrace() ;
							}
						
						}
						iv_prep_yn =resultSet.getString("IV_PREP_YN")==null?"":resultSet.getString("IV_PREP_YN"); //added for GHL-CRF-0482
						non_iv_drug_details.add(resultSet.getString("DRUG_CODE"));//1
						non_iv_drug_details.add(resultSet.getString("DRUG_DESC"));//2
						non_iv_drug_details.add(resultSet.getString("QTY"));//3
						non_iv_drug_details.add(resultSet.getString("SHORT_DESC"));	//4				
						non_iv_drug_details.add(resultSet.getString("BATCH_ID"));//5
						str_date= resultSet.getString("EXPIRY_DATE");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
						}
						non_iv_drug_details.add(str_date); //6
						non_iv_drug_details.add(resultSet.getString("TRADENAME"));//7
						non_iv_drug_details.add(resultSet.getString("ITEMCODE"));//8
						non_iv_drug_details.add("");//9
						non_iv_drug_details.add(resultSet.getString("ADMIN_RECORDED_YN"));//10
						non_iv_drug_details.add(resultSet.getString("VERIFY_REQD_YN"));//11
						non_iv_drug_details.add(resultSet.getString("VERIFICATION_STATUS"));//12
						non_iv_drug_details.add(resultSet.getString("MEDN_ADMIN_STATUS"));//13
						non_iv_drug_details.add(resultSet.getString("ORDER_ID"));	//14				
						non_iv_drug_details.add(resultSet.getString("ORDER_LINE_NUM"));	//15				
						non_iv_drug_details.add(resultSet.getString("PATIENT_ID"));//16

						str_date= resultSet.getString("SCH_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						non_iv_drug_details.add(str_date); //17
						//non_iv_drug_details.add(resultSet.getString("SCH_DATE_TIME"));
						non_iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//18
						non_iv_drug_details.add(resultSet.getString("TRADEID"));//19
						non_iv_drug_details.add(resultSet.getString("DISCONTINUED"));//20
						non_iv_drug_details.add(resultSet.getString("HELD"));		//21			
						non_iv_drug_details.add(resultSet.getString("ADMINISTERED_YN"));//22
						non_iv_drug_details.add(resultSet.getString("ADMIN_RECORDED_YN"));//23
						String administered="";
						administered = resultSet.getString("ADMINISTERED_YN");
						
						if(administered==null)administered="";
						if(administered.equals("N")){
							non_iv_drug_details.add(resultSet.getString("NON_ADMIN_REMARKS"));//24
						}
						else if(administered.equals("Y")){
							non_iv_drug_details.add(resultSet.getString("ADMIN_REMARKS"));//24
						}
						else{
							non_iv_drug_details.add("");//24
						}
						non_iv_drug_details.add(resultSet.getString("ADMINISTEREDDRUG"));		//25	
						non_iv_drug_details.add(resultSet.getString("USERNAME"));//26

						str_date= resultSet.getString("ADMIN_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						non_iv_drug_details.add(str_date);//27
						//non_iv_drug_details.add(resultSet.getString("ADMIN_DATE_TIME"));

						/*str_date= resultSet.getString("MODIFIED_DATE");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						non_iv_drug_details.add(str_date);//28*/

						non_iv_drug_details.add(resultSet.getString("MODIFIED_DATE")); //28
						non_iv_drug_details.add(resultSet.getString("PRES_DRUG_CODE"));//29
						pstmt_select = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT12") ) ;
						pstmt_select.setString(1,resultSet.getString("ORDER_ID"));
						resultSet_1	=	pstmt_select.executeQuery();
						
						if(resultSet_1!=null && resultSet_1.next()){
							non_iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//30
						} 
						else {
							non_iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//30
						}
						closeStatement( pstmt_select ) ;	 
						closeResultSet( resultSet_1 ) ;

						non_iv_drug_details.add(resultSet.getString("DRUG_CLASS"));//31
						non_iv_drug_details.add(resultSet.getString("AUTHORIZED_BY"));//32
						
						str_date= resultSet.getString("END_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						non_iv_drug_details.add(str_date);//33

						//non_iv_drug_details.add(resultSet.getString("END_DATE_TIME"));
						non_iv_drug_details.add(resultSet.getString("FREQ_CODE"));//34
						non_iv_drug_details.add(resultSet.getString("FREQ_NATURE"));//35
						non_iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//36
						non_iv_drug_details.add(resultSet.getString("PRACT_ID"));//37
						
						str_date= resultSet.getString("AGAINST_SCHDOSE_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						non_iv_drug_details.add(str_date);//38

						//non_iv_drug_details.add(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
						non_iv_drug_details.add(resultSet.getString("ADR_REASON_CODE"));//39
						non_iv_drug_details.add(resultSet.getString("ADR_REMARKS"));//40
						
						str_date= resultSet.getString("ADR_RECORDED_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						non_iv_drug_details.add(str_date);//41

						//non_iv_drug_details.add(resultSet.getString("ADR_RECORDED_DATE_TIME"));
						non_iv_drug_details.add(resultSet.getString("ADR_RECORDED_BY"));//42
						non_iv_drug_details.add(resultSet.getString("QTY_VALUE"));//43
						non_iv_drug_details.add(resultSet.getString("QTY_UNIT"));//44
						non_iv_drug_details.add(resultSet.getString("IV_PREP_YN"));//45
						non_iv_drug_details.add("N");//46
						non_iv_drug_details.add("");//47
						non_iv_drug_details.add("");//48
						non_iv_drug_details.add("");//49
						non_iv_drug_details.add("");//50
						non_iv_drug_details.add("");//51
						non_iv_drug_details.add("");//52
						non_iv_drug_details.add("");//53
						non_iv_drug_details.add(resultSet.getString("IV_INGREDIANTS"));//54					
						non_iv_drug_details.add(route_desc);//55
						non_iv_drug_details.add(resultSet.getString("PRES_CATG_CODE"));//56					
						non_iv_drug_details.add(resultSet.getString("schedule_uom_desc"));//57				
						non_iv_drug_details.add(resultSet.getString("sch_dosage_uom_code"));//58					
						non_iv_drug_details.add(resultSet.getString("PATIENT_BROUGHT_MEDICATION_YN")==null?"N":resultSet.getString("PATIENT_BROUGHT_MEDICATION_YN"));//59					
						non_iv_drug_details.add(resultSet.getString("SLIDING_SCALE_YN")==null?"N":resultSet.getString("SLIDING_SCALE_YN"));//60					
						non_iv_drug_details.add("");//61
						non_iv_drug_details.add("");//62
						non_iv_drug_details.add(resultSet.getString("MEDN_BROUGHT_BY_PATIENT_YN")==null?"N":resultSet.getString("MEDN_BROUGHT_BY_PATIENT_YN"));//63
						non_iv_drug_details.add(resultSet.getString("DOSAGE_TYPE")==null?"Q":resultSet.getString("DOSAGE_TYPE"));//64
						non_iv_drug_details.add(resultSet.getString("DOSAGE")==null?"":resultSet.getString("DOSAGE"));//65
						non_iv_drug_details.add(resultSet.getString("DOSAGE_UOM_CODE")==null?"":resultSet.getString("DOSAGE_UOM_CODE"));//66
						non_iv_drug_details.add(resultSet.getString("DOSAGE_UOM_DESC")==null?"":resultSet.getString("DOSAGE_UOM_DESC"));//67
						non_iv_drug_details.add("");//68
						non_iv_drug_details.add("");//69	
						non_iv_drug_details.add("");//70	
							non_iv_drug_details.add(resultSet.getString("ADMN_DOSE_CHNG_REMARKS")==null?"":resultSet.getString("ADMN_DOSE_CHNG_REMARKS")); //71
						non_iv_drug_details.add("1");  //72  drug count for Oncology Direct Order
						non_iv_drug_details.add("");//73 linked vaccine schedule
						non_iv_drug_details.add(resultSet.getString("PERFORMING_DEPTLOC_CODE"));//74 
						non_iv_drug_details.add(resultSet.getString("PRES_BASE_UOM"));//75
						non_iv_drug_details.add(route_color);//76 Added FOr RUT-CRF -0034 Route COlor
						non_iv_drug_details.add(resultSet.getString("ORD_PRACT_ID")==null?"":resultSet.getString("ORD_PRACT_ID"));//77 Prescribing pract id //Added for [IN:040149]
						non_iv_drug_details.add(chkfortapering(order_id, drugCode, (String)resultSet.getString("PATIENT_ID"))); //78   //Added for RUT-CRF-0088 [IN036978]
						non_iv_drug_details.add("");//79	// Added for RUT-CRF-0065.1 [IN:43255]
						non_iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUG_DESC")));//80 - Alternate disp
						non_iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUGS"))); //81
						non_iv_drug_details.add(checkForNull(resultSet.getString("DISP_DRUG_CODE"))); //82
						non_iv_drug_details.add(resultSet.getString("MFR_YN")==null?"N":resultSet.getString("MFR_YN"));//ML-MMOH-CRF-1014
						non_iv_drug_details.add(resultSet.getString("MFR_REMARKS")==null?"":resultSet.getString("MFR_REMARKS"));
						non_iv_drug_details.add(resultSet.getString("PLACED_FROM_VERBAL_ORDER"));//added for ghl-crf-0509
						non_iv_drug_details.add(resultSet.getString("ORDER_STATUS"));//added for GHL-CRF-0482
						if(iv_prep_yn.equals("")){
						 non_iv_drug_details.add(resultSet.getString("PATIENT_STOCK_REQUIRED"));//added for GHL-CRF-0482
						 non_iv_drug_details.add(resultSet.getString("PATIENT_STOCK_COMPLETED"));//added for GHL-CRF-0482
						 non_iv_drug_details.add(resultSet.getString("PATIENT_STOCK_YN"));//added for GHL-CRF-0482
						}
						else{
						 non_iv_drug_details.add("N");//added for GHL-CRF-0482
 						 non_iv_drug_details.add("N");//added for GHL-CRF-0482
 						 non_iv_drug_details.add("N");//added for GHL-CRF-0482
						}
						 non_iv_drug_details.add(checkForNull(resultSet.getString("CANCEL_RECORDED_YN")));// CANCEL_RECORDED_YN ADDED  FOR JD-CRF-0200
						split_dose_YN.put(resultSet.getString("ORDER_ID")+resultSet.getString("ORDER_LINE_NUM"),resultSet.getString("SPLIT_DOSE_YN"));//added for ML-MMOH-SCF-1439
					}
				}
				catch ( Exception e ){
					e.printStackTrace() ;
					throw e ;
				} 
				finally {
					try {
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;					
						closeStatement( pstmt_select ) ;
					}
					catch(Exception es) { 
						es.printStackTrace();
					}
				}
			}
			setSplitDoseYN(split_dose_YN); //ML-MMOH-SCF-1439
			drug_details.put("iv_prep_yn",iv_prep_yn);
			drug_details.put("NON_IV",non_iv_drug_details);
			drug_details.put("IV",iv_drug_details);
		}
		catch( Exception e ){
			e.printStackTrace() ;
			throw e ;
		} 
		finally {
		try {
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return drug_details;
	}

	/* This method is called when a drug is administered from CA Task List function*/
	public HashMap getDrugDetails(String encounter_id,String order_id,String shedule_date_time,String drug_code,String hold_discontinue_yn,String administration_status,String order_type, String display_order_by,String route_admin,String admin_rout_categ,String test_patient_id,String empty) throws Exception{   //added String test_patient_id,String empty values for the incident IN037217 and String empty is addded because above we are using one more getDrugDetails method with same number of parameters,so for diffrenciation i added empty String.

		HashMap drug_details = new HashMap();
		ArrayList iv_drug_details = new ArrayList();
		ArrayList non_iv_drug_details = new ArrayList();
		HashMap prescribe_mode	= new HashMap();//added for ML-BRU-SCF-1596 [IN:055162] 
		HashMap split_dose_YN = new HashMap();//ML-MMOH-SCF-1439
		ResultSet resultSet_route_code	= null;
		PreparedStatement pstmt_route_code	= null ;
		String route_code = "";
		String route_desc = "";
		String route_color                ="";          // Added For RUT-CRF -0034

		Connection connection			= null;
        PreparedStatement pstmt			= null;
        ResultSet resultSet				= null;
		PreparedStatement pstmt_select	= null;
		PreparedStatement pstmt_select_drug_count	= null ;
		ResultSet resultSet_drug_count			= null;
		ResultSet resultSet_1			= null;
		String appendString				= null;
		//String appendString1				= null;
		String str_date="";
		String drug_count = "1";
		PreparedStatement pstmt_patient_class	= null ;
		PreparedStatement pstmt_ext_drug_code	= null ;
		ResultSet resultSetPC=null;
		ResultSet resultSet_ext_drug_code=null;
		String patient_class_PC=null;
		String drugCode="";
		String ext_prod_id="";
		locale = getLanguageId()==null?"en":getLanguageId();
		drugCode=drug_code;
		int i=0;
		//String cancel_recorded_yn="";// CANCEL_RECORDED_YN ADDED  FOR JD-CRF-0200 //commented for common-icn-0048
        try {
			connection = getConnection() ;
			pstmt_patient_class = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1") ) ; 
			pstmt_patient_class.setString(1,login_facility_id);
			pstmt_patient_class.setString(2,encounter_id.trim());
			pstmt_patient_class.setString(3,test_patient_id.trim());

			resultSetPC	= pstmt_patient_class.executeQuery() ;
			if(resultSetPC.next()){
				patient_class_PC = resultSetPC.getString("ENC_PATIENT_CLASS");
			}
			if(patient_class_PC.equals("I") || patient_class_PC.equals("D")){
				setPatientClass("I");
			}
			if(patient_class_PC.equals("E") || patient_class_PC.equals("O")){ 
				setPatientClass("O");
			}
			pstmt_select_drug_count = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT_DRUGS_COUNT") ) ; 
		
			if(!route_admin.equals("")){
				appendString = " AND d.route_code ='"+route_admin+"'";
				//appendString1= " AND d.route_code ='"+route_admin+"'";
			}
			else if(!admin_rout_categ.equals("")){
				ArrayList admRoutes=getAdminRoute(admin_rout_categ.trim());
				String aString="";				
				for(int index=0;index<admRoutes.size();index+=2){					
					aString=aString+"'"+admRoutes.get(index)+"',";
				}
				if(!aString.equals(""))
					aString=aString.substring(0,(aString.length()-1));
				else
					aString="''";
				appendString =" and d.ROUTE_CODE IN("+aString+")";
				//appendString1=" and d.ROUTE_CODE IN("+aString+")";				
			}
			else{
				appendString="";
				//appendString1="";
			}

			pstmt_select = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT12") ) ; 
			
			if(order_type !=null && order_type.equals("Rx")){
				appendString = appendString+" AND E.IV_PREP_YN IS NULL ORDER BY A.SCH_DATE_TIME";
			}
			else if(order_type !=null && order_type.equals("IVRx")){
				appendString = appendString+" AND E.IV_PREP_YN IS NOT NULL ORDER BY A.ORDER_ID,A.ORDER_LINE_NUM, A.SCH_DATE_TIME";
			} 
			else if(order_type !=null && order_type.equals("STAT")){
				appendString = appendString+" AND H.FREQ_NATURE = 'O' ";
			} 
			else if(order_type !=null && order_type.equals("PRN")){
				appendString = appendString+" AND H.FREQ_NATURE = 'P' ";
			}
			
			if(appendString==null)appendString=" ORDER BY A.ORDER_ID,A.ORDER_LINE_NUM ";
			String iv_prep_yn=IVType(order_id);
			if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8")){
				//pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_TPN_SELECT3"));
				pstmt = connection.prepareStatement("SELECT a.CANCEL_RECORDED_YN,a.order_id, a.order_line_num, e.iv_prep_yn,a.admin_recorded_by username, a.admin_authorized_by authorized_by,a.admin_remarks, a.non_admin_remarks,a.pract_id, a.admin_recorded_yn,f.admin_drug_code || ':'|| (SELECT long_name  FROM ph_tpn_regimen_lang_vw ph_tpn_regimen  WHERE tpn_regimen_code = f.admin_drug_code AND language_id = ?) || ':'|| f.admin_dosage_qty || ':'|| f.admin_dosage_uom_code administereddrug,a.admin_recorded_yn, a.dosage_seq_no,TO_CHAR (a.sch_date_time, 'DD/MM/YYYY HH24:MI') sch_date_time, a.iv_ingrediants,a.sch_infusion_rate, a.sch_infusion_vol_str_unit,am_get_desc.am_uom(a.sch_infusion_vol_str_unit, ? , 2 ) sch_infusion_vol_str_unit_desc, a.sch_infusion_per_unit, a.sch_infusion_period,a.sch_infusion_period_unit,a.admin_recorded_yn, a.administered_yn, a.verify_reqd_yn,a.verification_status, a.medn_admin_status,NVL (a.iv_admin_yn, 'N') iv_admin_yn,DECODE (d.disc_date_time, NULL, 'N', 'Y') discontinued,DECODE (d.hold_date_time, NULL, 'N', 'Y') held, a.patient_id,d.freq_code,d.qty_value, d.qty_unit, NVL ((SELECT disp_drug_code FROM ph_disp_dtl WHERE ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND ROWNUM < 2), b.long_name ) drug_code, b.tpn_regimen_code pres_drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT long_name FROM ph_tpn_regimen_lang_vw  ph_tpn_regimen, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_tpn_regimen.tpn_regimen_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2), b.long_name ) ELSE (SELECT mfg_unit FROM ph_tpn_worksheet_hdr HDR WHERE order_id = a.order_id AND ROWNUM<2) END ) drug_desc, Decode(ADMINISTERED_YN,'N', (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT long_name FROM ph_tpn_regimen_lang_vw  ph_tpn_regimen, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_tpn_regimen.tpn_regimen_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2), b.long_name ) ELSE (SELECT mfg_unit FROM ph_tpn_worksheet_hdr HDR WHERE order_id = a.order_id AND ROWNUM<2) END )) dispensed_drug_desc, NVL (f.admin_dosage_qty, sch_dosage_qty) qty, am_get_desc.am_uom(a.sch_dosage_uom_code,?,2) short_desc, TO_CHAR (a.admin_date_time, 'DD/MM/YYYY HH24:MI') admin_date_time,TO_CHAR (a.modified_date, 'DD/MM/YYYY HH24:MI') modified_date, b.drug_class,e.iv_prep_yn, b.item_code itemcode,TO_CHAR (d.end_date_time, 'DD/MM/YYYY HH24:MI') end_date_time, f.batch_id, TO_CHAR (f.expiry_date, 'DD/MM/YYYY') expiry_date,f.item_code, f.trade_id tradeid, am_get_desc.AM_TRADE_NAME(f.trade_id,?,2) tradename, h.freq_nature, TO_CHAR (a.against_schdose_date_time,'DD/MM/YYYY HH24:MI') against_schdose_date_time,a.adr_reason_code, a.adr_remarks,TO_CHAR (a.adr_recorded_date_time,'DD/MM/YYYY HH24:MI') adr_recorded_date_time, a.adr_recorded_by, d.route_code, b.PRES_CATG_CODE ,am_get_desc.am_uom(d.qty_unit,?,2) schedule_uom_desc,a.sch_dosage_uom_code sch_dosage_uom_code, o.PATIENT_BROUGHT_MEDICATION_YN, o.SLIDING_SCALE_YN,o.DOSAGE_TYPE, i.DOSAGE, i.DOSAGE_UOM_CODE,i.prescribed_mode, am_get_desc.am_uom(i.dosage_uom_code,?,2) dosage_uom_desc,a.ADMN_DOSE_CHNG_REMARKS.e.PERFORMING_DEPTLOC_CODE, b.PRES_BASE_UNIT PRES_BASE_UOM,i.DISPENSED_DRUGS, e.ORD_PRACT_ID,(SELECT drug_code FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code<>ph_disp_dtl.pres_drug_code and ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2 ) disp_drug_code,e.patient_class,O.PLACED_FROM_VERBAL_ORDER,e.order_status,PATIENT_STOCK_YN ,o.SPLIT_DOSE_YN  FROM ph_medn_admin a,ph_tpn_regimen_lang_vw b,or_order_line d,or_order e,ph_medn_admin_dtl f,am_frequency h,ph_patient_drug_profile i, or_order_line_ph o WHERE h.freq_code = d.freq_code   AND f.encounter_id(+) = a.encounter_id  AND f.order_id(+) = a.order_id AND f.facility_id(+) = a.facility_id AND f.ord_drug_code(+) = a.ord_drug_code   AND a.dosage_seq_no = f.dosage_seq_no(+) AND f.sch_date_time(+) = a.sch_date_time   AND e.order_id = d.order_id  AND i.orig_order_id = d.order_id   AND i.orig_order_line_no = d.order_line_num AND e.order_id = i.orig_order_id   AND a.ord_drug_code = b.tpn_regimen_code AND a.order_id = d.order_id and a.order_id = o.order_id  AND a.order_line_num = d.order_line_num and a.order_line_num = o.order_line_num   AND a.facility_id = ?   AND a.encounter_id = ? AND TO_DATE (TO_CHAR (a.sch_date_time, 'DD/MM/YYYY HH24:MI'),'DD/MM/YYYY HH24:MI') = TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND a.order_id=? AND b.tpn_regimen_code = NVL (?, b.tpn_regimen_code) AND a.sch_date_time >= d.START_DATE_TIME  AND SYSDATE <= d.end_date_time   AND d.can_date_time IS NULL  AND e.iv_prep_yn IN ('7','8') AND b.language_id = ? and d.ORDER_LINE_STATUS not in ('PO', 'PS') ");//added PRESCRIBED_MODE for ML-BRU-SCF-1596 [IN:055162] // and d.ORDER_LINE_STATUS not in ('PO', 'PS')  added for ML-MMOH-SCF-0321 [IN:058617]
				//e.patient_class added for GHL-CRF-0458 and o.SPLIT_DOSE_YN added for ML-MMOH-SCF-1439
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);	
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,login_facility_id);
				pstmt.setString(++i,encounter_id.trim());
				pstmt.setString(++i,shedule_date_time );
				pstmt.setString(++i,order_id );
				pstmt.setString(++i,drug_code);
				pstmt.setString(++i,locale);	
			}
			else{	
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT6")+appendString) ; 
				pstmt = connection.prepareStatement( "SELECT /*+ FIRST_ROWS */ A.ORDER_ID,a.CANCEL_RECORDED_YN, A.ORDER_LINE_NUM, E.IV_PREP_YN,A.ADMIN_RECORDED_BY USERNAME, A.ADMIN_AUTHORIZED_BY AUTHORIZED_BY, A.ADMIN_REMARKS, A.NON_ADMIN_REMARKS, A.PRACT_ID,A.ADMIN_RECORDED_YN, F.ADMIN_dRUG_CODE||':'||(SELECT DRUG_DESC FROM PH_DRUG_LANG_VW PH_DRUG WHERE DRUG_CODE = F.ADMIN_dRUG_CODE AND LANGUAGE_ID = ?)|| ':'||F.admin_dosage_qty||':'||F.admin_dosage_uom_code ADMINISTEREDDRUG, A.ADMIN_RECORDED_YN,  A.DOSAGE_SEQ_NO, TO_CHAR(A.SCH_DATE_TIME, 'DD/MM/YYYY HH24:MI') SCH_DATE_TIME, A.IV_INGREDIANTS,A.SCH_INFUSION_RATE,A.SCH_INFUSION_VOL_STR_UNIT, am_get_desc.am_uom(a.sch_infusion_vol_str_unit, ? , 2 ) sch_infusion_vol_str_unit_desc, A.SCH_INFUSION_PER_UNIT, A.SCH_INFUSION_PERIOD,A.SCH_INFUSION_PERIOD_UNIT, A.ADMIN_RECORDED_YN, A.ADMINISTERED_YN, A.VERIFY_REQD_YN, A.VERIFICATION_STATUS, A.MEDN_ADMIN_STATUS,  NVL(A.IV_ADMIN_YN, 'N') IV_ADMIN_YN, DECODE(D.DISC_DATE_TIME, NULL, 'N', 'Y') DISCONTINUED,  DECODE(D.HOLD_DATE_TIME, NULL, 'N', 'Y') HELD , A.PATIENT_ID, D.FREQ_CODE,D.QTY_VALUE,D.QTY_UNIT,  NVL( (SELECT DISP_DRUG_CODE FROM PH_DISP_DTL WHERE PH_DISP_DTL.ORDER_ID=A.ORDER_ID AND PH_DISP_DTL.ORDER_LINE_NO=A.ORDER_LINE_NUM AND ROWNUM<2), B.DRUG_CODE) DRUG_CODE, B.DRUG_CODE PRES_DRUG_CODE, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT drug_desc FROM ph_drug_lang_vw ph_drug WHERE drug_code = a.ord_drug_code AND language_id = ? AND ROWNUM < 2), b.drug_desc ) ELSE (SELECT mfg_unit FROM ph_worksheet_hdr WHERE order_id = a.order_id AND ROWNUM < 2) END ) drug_desc, DECODE (administered_yn, 'N',(CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN (SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code <> ph_disp_dtl.pres_drug_code AND ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2) ELSE (SELECT mfg_unit FROM ph_worksheet_hdr WHERE order_id = a.order_id AND ROWNUM < 2) END ) ) dispensed_drug_desc, NVL(F.ADMIN_DOSAGE_QTY, SCH_DOSAGE_QTY) QTY, am_get_desc.am_uom(a.sch_dosage_uom_code,?,2) short_desc, b.DISP_MULTI_STRENGTH_YN,TO_CHAR(A.ADMIN_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMIN_DATE_TIME, TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY HH24:MI') MODIFIED_DATE , B.DRUG_CLASS ,E.IV_PREP_YN ,B.ITEM_CODE ITEMCODE , TO_CHAR(D.END_DATE_TIME,'DD/MM/YYYY HH24:MI' ) END_DATE_TIME ,F.BATCH_ID , TO_CHAR(F.EXPIRY_DATE,'DD/MM/YYYY') EXPIRY_DATE, F.ITEM_CODE, F.trade_id TRADEID,am_get_desc.AM_TRADE_NAME(f.trade_id,?,2) tradename, H.FREQ_NATURE, TO_CHAR(A.AGAINST_SCHDOSE_DATE_TIME,'DD/MM/YYYY HH24:MI') AGAINST_SCHDOSE_DATE_TIME, A.ADR_REASON_CODE, A.ADR_REMARKS, TO_CHAR(A.ADR_RECORDED_DATE_TIME,'DD/MM/YYYY HH24:MI')ADR_RECORDED_DATE_TIME, A.ADR_RECORDED_BY, B.MEDN_ADMN_DTL_REQD_YN,D.ROUTE_CODE, b.PRES_CATG_CODE ,am_get_desc.am_uom(d.qty_unit,?,2) schedule_uom_desc,a.SCH_DOSAGE_UOM_CODE SCH_DOSAGE_UOM_CODE, o.PATIENT_BROUGHT_MEDICATION_YN, o.SLIDING_SCALE_YN, b.STRENGTH_VALUE, a.SCH_STRENGTH,a.SCH_STRENGTH_UOM, am_get_desc.am_uom(a.sch_strength_uom,?,2) sch_strength_uom_desc, o.DOSAGE_TYPE, i.DOSAGE, i.DOSAGE_UOM_CODE,i.prescribed_mode, am_get_desc.am_uom(i.dosage_uom_code,?,2) dosage_uom_desc,b.CONTENT_IN_PRES_BASE_UOM, a.ADMN_DOSE_CHNG_REMARKS,ca_get_vaccine_sche_details(a.patient_id,NVL((SELECT DISP_DRUG_CODE FROM PH_DISP_DTL WHERE PH_DISP_DTL.ORDER_ID=A.ORDER_ID AND PH_DISP_DTL.ORDER_LINE_NO=A.ORDER_LINE_NUM AND ROWNUM<2),B.DRUG_CODE),b.language_id) VACC_CATEGORY_LINK,o.MFR_YN,a.FLOW_STATUS,a.COMPLETED_DURN_IN_MINS,a.COMPLETED_VOLUME, TO_CHAR (a.HOLD_DATE_TIME, 'DD/MM/YYYY HH24:MI') HOLD_DATE_TIME, a.HOLD_DURN_IN_MINS,TO_CHAR (a.RESUME_DATE_TIME, 'DD/MM/YYYY HH24:MI') RESUME_DATE_TIME, TO_CHAR (a.ACT_START_DATE_TIME, 'DD/MM/YYYY HH24:MI') ACT_START_DATE_TIME, TO_CHAR (a.ACT_END_DATE_TIME, 'DD/MM/YYYY HH24:MI') ACT_END_DATE_TIME,O.MFR_REMARKS,e.PERFORMING_DEPTLOC_CODE,B.PRES_BASE_UOM,i.DISPENSED_DRUGS, e.ORD_PRACT_ID,B.GENERIC_ID,(SELECT drug_code FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code<>ph_disp_dtl.pres_drug_code and ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2 ) disp_drug_code,E.patient_class,O.PLACED_FROM_VERBAL_ORDER,e.order_status,PATIENT_STOCK_REQUIRED ,PATIENT_STOCK_COMPLETED,i.PATIENT_STOCK_YN ,o.SPLIT_DOSE_YN FROM PH_MEDN_ADMIN A,PH_DRUG_LANG_VW B,OR_ORDER_LINE D ,OR_ORDER E ,PH_MEDN_ADMIN_DTL F , AM_FREQUENCY H,PH_PATIENT_DRUG_PROFILE i, OR_ORDER_LINE_PH o WHERE H.FREQ_CODE=D.FREQ_CODE AND F.encounter_id(+)=A.ENCOUNTER_ID AND f.order_id(+) = a.order_id AND F.facility_id(+)=A.FACILITY_ID AND F.ord_drug_code(+)=A.ORD_drug_code AND A.dosage_seq_no=F.dosage_seq_no(+) AND F.sch_date_time(+)=A.SCH_DATE_TIME AND A.ORD_DRUG_CODE=B.DRUG_CODE(+) AND E.ORDER_ID = D.ORDER_ID AND A.FACILITY_ID=? AND i.ORIG_ORDER_ID = D.ORDER_ID AND D.ORDER_ID=A.ORDER_ID and o.order_id = a.order_id AND i.ORIG_ORDER_LINE_NO = D.ORDER_LINE_NUM AND D.ORDER_LINE_NUM=A.ORDER_LINE_NUM and o.ORDER_LINE_NUM=A.ORDER_LINE_NUM AND A.ENCOUNTER_ID =? AND a.sch_date_time>=d.START_DATE_TIME AND TO_DATE(TO_CHAR(A.sch_date_time,'DD/MM/YYYY HH24:MI'),'DD/MM/YYYY HH24:MI')= TO_DATE(?,'DD/MM/YYYY HH24:MI') AND A.ORDER_ID=? /*AND B.DRUG_CODE=NVL(?,B.DRUG_CODE) */ AND b.language_id(+) = ? AND SYSDATE<=D.END_DATE_TIME+((select nvl(REC_ADMIN_WITHIN_HRS,1) from ph_facility_param where facility_id =?)/24)  and d.ORDER_LINE_STATUS not in ('PO', 'PS','PQ') "+appendString) ; //added  AND SYSDATE<=D.END_DATE_TIME+((select nvl(REC_ADMIN_WITHIN_HRS,1) from ph_facility_param where facility_id =?)/24) condition for IN23993 --10/11/2010-- priya//added PRESCRIBED_MODE for ML-BRU-SCF-1596 [IN:055162]  //and d.ORDER_LINE_STATUS not in ('PO', 'PS')  added for ML-MMOH-SCF-0321 [IN:058617] //Added ORDER_LINE_STATUS not in ('PO', 'PS','PQ') 'PQ' for ML-MMOH-CRF-1823-US008
				//e.patient_class added for GHL-CRF-0458 and e.order_status,PATIENT_STOCK_REQUIRED ,PATIENT_STOCK_COMPLETED,PATIENT_STOCK_YN added for GHL-CRF-0482
				//AND B.DRUG_CODE=NVL(?,B.DRUG_CODE)  commented for MMs-KH-CRF-0017  and (+) added for MMS-KH-CRF-0017 and o.SPLIT_DOSE_YN added for ML-MMOH-SCF-1439
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);	
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,locale);
				pstmt.setString(++i,login_facility_id);
				pstmt.setString(++i,encounter_id.trim());
				pstmt.setString(++i,shedule_date_time );
				pstmt.setString(++i,order_id );
				//pstmt.setString(++i,drug_code);				//commented for MMS-KF-CRF-0017
				pstmt.setString(++i,locale);
				pstmt.setString(++i,login_facility_id);
			}
			resultSet = pstmt.executeQuery() ;
           
			while ( resultSet != null && resultSet.next() ) {
				iv_prep_yn = resultSet.getString("IV_PREP_YN");
				if(iv_prep_yn == null){
					iv_prep_yn="";
				}
				setOrderPatientClass(checkForNull(resultSet.getString("ORDER_ID")),resultSet.getString("patient_class"));//GHL-CRF-0458
				if(!order_type.equals("TPN")&& !iv_prep_yn.equals("6")){
					drugCode = resultSet.getString("DRUG_CODE");
					pstmt_ext_drug_code				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_EXT_PRODUCT_ID")) ;
					pstmt_ext_drug_code.setString(1,drugCode);
					pstmt_ext_drug_code.setString(2,login_facility_id);
					resultSet_ext_drug_code			= pstmt_ext_drug_code.executeQuery();
					if(resultSet_ext_drug_code!=null && resultSet_ext_drug_code.next()){
						ext_prod_id = resultSet_ext_drug_code.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet_ext_drug_code.getString("EXTERNAL_PRODUCT_ID");
					}
					try{
						closeResultSet( resultSet_ext_drug_code ) ;
						closeStatement( pstmt_ext_drug_code ) ;
					}catch(Exception es){
						es.printStackTrace() ;
					}
				}
				route_code =resultSet.getString("route_code")==null?"":resultSet.getString("route_code");
				
				if(!route_code.equals("")){
					pstmt_route_code =connection.prepareStatement("SELECT ROUTE_DESC,ROUTE_COLOR FROM PH_ROUTE_LANG_VW WHERE LANGUAGE_ID=? AND ROUTE_CODE=? ");
					pstmt_route_code.setString(1,locale);
					pstmt_route_code.setString(2,route_code);
					resultSet_route_code=pstmt_route_code.executeQuery();
					if(resultSet_route_code!=null && resultSet_route_code.next()){
						route_desc = resultSet_route_code.getString("ROUTE_DESC")==null ? "":resultSet_route_code.getString("ROUTE_DESC");
						route_color = resultSet_route_code.getString("ROUTE_COLOR")==null ? "":resultSet_route_code.getString("ROUTE_COLOR");//Added For RUT_CRF-0034 Route Color
					}
					try{
						closeResultSet( resultSet_route_code ) ;
						closeStatement( pstmt_route_code ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}
				}

				if(iv_prep_yn.equals("")||iv_prep_yn.equals("0")||iv_prep_yn.equals("7")||iv_prep_yn.equals("8")||iv_prep_yn.equals("9")){
					non_iv_drug_details.add(resultSet.getString("DRUG_CODE"));//1
					non_iv_drug_details.add(resultSet.getString("DRUG_DESC"));//2
					non_iv_drug_details.add(resultSet.getString("QTY"));//3
					non_iv_drug_details.add(resultSet.getString("SHORT_DESC"));//4					
					non_iv_drug_details.add(resultSet.getString("BATCH_ID"));//5
					
					str_date= resultSet.getString("EXPIRY_DATE");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
					}
					non_iv_drug_details.add(str_date);//6

					//non_iv_drug_details.add(resultSet.getString("EXPIRY_DATE")); 
					non_iv_drug_details.add(resultSet.getString("TRADENAME"));//7
					non_iv_drug_details.add(resultSet.getString("ITEMCODE"));//8
					if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8")){
						non_iv_drug_details.add("");//9
					}
					else{
						non_iv_drug_details.add(resultSet.getString("DISP_MULTI_STRENGTH_YN"));//9
					}
					non_iv_drug_details.add(resultSet.getString("ADMIN_RECORDED_YN"));//10
					non_iv_drug_details.add(resultSet.getString("VERIFY_REQD_YN"));//11
					non_iv_drug_details.add(resultSet.getString("VERIFICATION_STATUS"));//12
					non_iv_drug_details.add(resultSet.getString("MEDN_ADMIN_STATUS"));//13
					non_iv_drug_details.add(resultSet.getString("ORDER_ID"));			//14	
					non_iv_drug_details.add(resultSet.getString("ORDER_LINE_NUM"));			//15		
					non_iv_drug_details.add(resultSet.getString("PATIENT_ID"));//16
					
					str_date= resultSet.getString("SCH_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					non_iv_drug_details.add(str_date);//17
					non_iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//18
					non_iv_drug_details.add(resultSet.getString("TRADEID"));//19
					non_iv_drug_details.add(resultSet.getString("DISCONTINUED"));//20
					non_iv_drug_details.add(resultSet.getString("HELD"));	//21
					non_iv_drug_details.add(resultSet.getString("ADMINISTERED_YN"));//22
					non_iv_drug_details.add(resultSet.getString("ADMIN_RECORDED_YN"));//23
					String administered = resultSet.getString("ADMINISTERED_YN");
					
					if(administered==null)
						administered="";
					if(administered.equals("N")){
						non_iv_drug_details.add(resultSet.getString("NON_ADMIN_REMARKS"));//24
					}
					else if(administered.equals("Y")){
						non_iv_drug_details.add(resultSet.getString("ADMIN_REMARKS"));//24
					}
					else{
						non_iv_drug_details.add("");//25
					}
					non_iv_drug_details.add(resultSet.getString("ADMINISTEREDDRUG"));//25
					non_iv_drug_details.add(resultSet.getString("USERNAME"));//26
					
					str_date= resultSet.getString("ADMIN_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					non_iv_drug_details.add(str_date);//27

					//non_iv_drug_details.add(resultSet.getString("ADMIN_DATE_TIME"));
					
					/*str_date= resultSet.getString("MODIFIED_DATE");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					non_iv_drug_details.add(str_date);//28*/

					non_iv_drug_details.add(resultSet.getString("MODIFIED_DATE")); //28
					non_iv_drug_details.add(resultSet.getString("PRES_DRUG_CODE"));//29
					
					pstmt_select.setString(1,resultSet.getString("ORDER_ID"));
					resultSet_1	=	pstmt_select.executeQuery();
					
					if(resultSet_1!=null && resultSet_1.next()){
						non_iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//30
					} 
					else {
						non_iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//30
					}
					try{
						closeResultSet( resultSet_1 ) ;
					}
					catch(Exception e){
						e.printStackTrace();
					}
					non_iv_drug_details.add(resultSet.getString("DRUG_CLASS"));//31
					non_iv_drug_details.add(resultSet.getString("AUTHORIZED_BY"));//32
					
					str_date= resultSet.getString("END_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					non_iv_drug_details.add(str_date);//33

					//non_iv_drug_details.add(resultSet.getString("END_DATE_TIME"));
					non_iv_drug_details.add(resultSet.getString("FREQ_CODE"));//34
					non_iv_drug_details.add(resultSet.getString("FREQ_NATURE"));//35
					non_iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//36
					non_iv_drug_details.add(resultSet.getString("PRACT_ID"));//37
					
					str_date= resultSet.getString("AGAINST_SCHDOSE_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					non_iv_drug_details.add(str_date);//38

					//non_iv_drug_details.add(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
					non_iv_drug_details.add(resultSet.getString("ADR_REASON_CODE"));//39
					non_iv_drug_details.add(resultSet.getString("ADR_REMARKS"));//40
					
					str_date= resultSet.getString("ADR_RECORDED_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					non_iv_drug_details.add(str_date);//41

					//non_iv_drug_details.add(resultSet.getString("ADR_RECORDED_DATE_TIME"));
					non_iv_drug_details.add(resultSet.getString("ADR_RECORDED_BY"));//42
					non_iv_drug_details.add(resultSet.getString("QTY_VALUE"));//43
					non_iv_drug_details.add(resultSet.getString("QTY_UNIT"));//44
					if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8")){
					    non_iv_drug_details.add("N");//45
					}
					else{
						non_iv_drug_details.add(resultSet.getString("MEDN_ADMN_DTL_REQD_YN"));//45
						 
					}
					non_iv_drug_details.add(ext_prod_id);//46
					non_iv_drug_details.add(resultSet.getString("IV_INGREDIANTS"));//47
					non_iv_drug_details.add(route_desc);	//48
					non_iv_drug_details.add(resultSet.getString("PRES_CATG_CODE"));//49
					non_iv_drug_details.add(resultSet.getString("schedule_uom_desc"));//50				
					non_iv_drug_details.add(resultSet.getString("sch_dosage_uom_code"));//51
					non_iv_drug_details.add(resultSet.getString("SLIDING_SCALE_YN"));//52
					non_iv_drug_details.add(resultSet.getString("PATIENT_BROUGHT_MEDICATION_YN"));//53
					if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8")){
						non_iv_drug_details.add("");//54
						non_iv_drug_details.add("");//55
						non_iv_drug_details.add("");//56
						non_iv_drug_details.add("");//57
						non_iv_drug_details.add("");//58
					}
					else{
						non_iv_drug_details.add(resultSet.getString("STRENGTH_VALUE"));//54 
						non_iv_drug_details.add(resultSet.getString("SCH_STRENGTH"));//55   53hello
						non_iv_drug_details.add(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null?"1":resultSet.getString("CONTENT_IN_PRES_BASE_UOM"));//56
						non_iv_drug_details.add(resultSet.getString("SCH_STRENGTH_UOM")==null?"":resultSet.getString("SCH_STRENGTH_UOM"));//57
						non_iv_drug_details.add(resultSet.getString("SCH_STRENGTH_UOM_DESC")==null?"":resultSet.getString("SCH_STRENGTH_UOM_DESC"));//58
					}
					non_iv_drug_details.add(resultSet.getString("DOSAGE_TYPE")==null?"Q":resultSet.getString("DOSAGE_TYPE"));//59 
					non_iv_drug_details.add(resultSet.getString("DOSAGE")==null?"":resultSet.getString("DOSAGE"));//60
					non_iv_drug_details.add(resultSet.getString("DOSAGE_UOM_CODE")==null?"":resultSet.getString("DOSAGE_UOM_CODE"));//61
					non_iv_drug_details.add(resultSet.getString("DOSAGE_UOM_DESC")==null?"":resultSet.getString("DOSAGE_UOM_DESC"));//62
					non_iv_drug_details.add(resultSet.getString("ADMN_DOSE_CHNG_REMARKS")==null?"":resultSet.getString("ADMN_DOSE_CHNG_REMARKS")); //63
					if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8")){
						non_iv_drug_details.add(""); ;//64 linked vaccine schedule
					}
					else{
						non_iv_drug_details.add(resultSet.getString("VACC_CATEGORY_LINK"));//64 linked vaccine schedule
					}
					non_iv_drug_details.add(resultSet.getString("PERFORMING_DEPTLOC_CODE")); //65
					non_iv_drug_details.add(resultSet.getString("PRES_BASE_UOM"));//66
					non_iv_drug_details.add(route_color);//67 Added for ROute Color CRF - 0034
					non_iv_drug_details.add(resultSet.getString("ORD_PRACT_ID")==null?"":resultSet.getString("ORD_PRACT_ID"));//68 Prescribing pract id //Added for [IN:040149]
					if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8")){	//Added for RUT-CRF-0065.1 [IN:43255]
						non_iv_drug_details.add("");//69
					}
					else{		//Added for RUT-CRF-0065.1 [IN:43255]
						non_iv_drug_details.add(checkForNull(resultSet.getString("GENERIC_ID")));//69 
					}
					non_iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUG_DESC")));//70 - Alternate disp
					non_iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUGS"))); //71
					non_iv_drug_details.add(checkForNull(resultSet.getString("DISP_DRUG_CODE"))); //72
					non_iv_drug_details.add(resultSet.getString("MFR_YN")==null?"N":resultSet.getString("MFR_YN"));//ML-MMOH-CRF-1014
					non_iv_drug_details.add(resultSet.getString("MFR_REMARKS")==null?"":resultSet.getString("MFR_REMARKS")); //ML-MMOH-CRF-1014
					non_iv_drug_details.add(resultSet.getString("PLACED_FROM_VERBAL_ORDER")==null?"":resultSet.getString("PLACED_FROM_VERBAL_ORDER"));//ADDED FOR GHL-CRF-0509
					non_iv_drug_details.add(checkForNull(resultSet.getString("ORDER_STATUS")));//added for GHL-CRF-0482
					if(iv_prep_yn.equals("")){
						non_iv_drug_details.add(resultSet.getString("PATIENT_STOCK_REQUIRED"));//added for GHL-CRF-0482
						non_iv_drug_details.add(resultSet.getString("PATIENT_STOCK_COMPLETED"));//added for GHL-CRF-0482
						non_iv_drug_details.add(resultSet.getString("PATIENT_STOCK_YN"));//added for GHL-CRF-0482
						
					}
					else{
						non_iv_drug_details.add("N");//added for GHL-CRF-0482
						non_iv_drug_details.add("N");//added for GHL-CRF-0482
						non_iv_drug_details.add("N");//added for GHL-CRF-0482
					}
				split_dose_YN.put(resultSet.getString("ORDER_ID")+resultSet.getString("ORDER_LINE_NUM"),resultSet.getString("SPLIT_DOSE_YN"));//added for ML-MMOH-SCF-1439
				prescribe_mode.put(resultSet.getString("ORDER_ID")+resultSet.getString("ORDER_LINE_NUM"),resultSet.getString("PRESCRIBED_MODE"));//added for ML-BRU-SCF-1596 [IN:055162] 
				non_iv_drug_details.add(checkForNull(resultSet.getString("CANCEL_RECORDED_YN"))); //74// CANCEL_RECORDED_YN ADDED  FOR JD-CRF-0200
				}
				else{
					if(resultSet.getString("IV_PREP_YN").equals("2") || resultSet.getString("IV_PREP_YN").equals("4")) {
						if(resultSet.getString("ORDER_LINE_NUM").equals("1")) {
							iv_drug_details.add(resultSet.getString("IV_INGREDIANTS"));//1
							iv_drug_details.add(resultSet.getString("SCH_INFUSION_RATE"));//2
							iv_drug_details.add(resultSet.getString("SCH_INFUSION_VOL_STR_UNIT"));//3
							iv_drug_details.add(resultSet.getString("SCH_INFUSION_PER_UNIT"));//4
							iv_drug_details.add(resultSet.getString("BATCH_ID"));//5
					
							str_date= resultSet.getString("EXPIRY_DATE");
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
							}
							iv_drug_details.add(str_date);//6

							//iv_drug_details.add(resultSet.getString("EXPIRY_DATE"));
							iv_drug_details.add(resultSet.getString("TRADEID"));//7
							iv_drug_details.add(resultSet.getString("TRADENAME"));//8
							iv_drug_details.add(resultSet.getString("ITEMCODE"));//9
							iv_drug_details.add(resultSet.getString("PATIENT_ID"));//10
							iv_drug_details.add(resultSet.getString("DRUG_CODE"));//11
							iv_drug_details.add(resultSet.getString("DRUG_DESC"));//12
					
							str_date= resultSet.getString("SCH_DATE_TIME");
							order_id = resultSet.getString("ORDER_ID");
							pstmt_select_drug_count.setString(1,order_id);
							pstmt_select_drug_count.setString(2,str_date);
							resultSet_drug_count = pstmt_select_drug_count.executeQuery();
							if(resultSet_drug_count!=null && resultSet_drug_count.next())
								drug_count = resultSet_drug_count.getString("NO_OF_DRUGS");

							closeResultSet(resultSet_drug_count);
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							iv_drug_details.add(str_date);//13

							//iv_drug_details.add(resultSet.getString("SCH_DATE_TIME"));
							iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//14
							iv_drug_details.add(order_id);	//15				
							iv_drug_details.add(resultSet.getString("ORDER_LINE_NUM"));//16
							iv_drug_details.add(resultSet.getString("QTY"));//17
							iv_drug_details.add(resultSet.getString("SHORT_DESC"));	//18
							iv_drug_details.add(resultSet.getString("DISCONTINUED"));//19
							iv_drug_details.add(resultSet.getString("HELD"));	//20
							iv_drug_details.add(resultSet.getString("SCH_INFUSION_PERIOD"));	//21
							iv_drug_details.add(resultSet.getString("SCH_INFUSION_PERIOD_UNIT"));	//22
							iv_drug_details.add(resultSet.getString("ADMINISTERED_YN"));//23
							iv_drug_details.add(resultSet.getString("ADMIN_RECORDED_YN"));//24
							String administered = resultSet.getString("ADMINISTERED_YN");
							if(administered==null)
								administered="";
							if(administered.equals("N")){
								iv_drug_details.add(resultSet.getString("NON_ADMIN_REMARKS"));//25
							}
							else if(administered.equals("Y")){
								iv_drug_details.add(resultSet.getString("ADMIN_REMARKS"));//25
							}
							else{
								iv_drug_details.add("");//25
							}
							iv_drug_details.add(resultSet.getString("ADMINISTEREDDRUG"));//26	
							iv_drug_details.add(resultSet.getString("USERNAME"));//27
					
							str_date= resultSet.getString("ADMIN_DATE_TIME");
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							iv_drug_details.add(str_date);//28

							//iv_drug_details.add(resultSet.getString("ADMIN_DATE_TIME"));
					
							/*str_date= resultSet.getString("MODIFIED_DATE");
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							iv_drug_details.add(str_date);//29*/

							iv_drug_details.add(resultSet.getString("MODIFIED_DATE"));//29
							iv_drug_details.add(resultSet.getString("PRES_DRUG_CODE"));//30
							
							pstmt_select.setString(1,resultSet.getString("ORDER_ID"));
							resultSet_1	=	pstmt_select.executeQuery();
							
							if(resultSet_1!=null && resultSet_1.next()){
								iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//31
							}
							else {
								iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//31
							}
							try{
								closeResultSet( resultSet_1 ) ;
							}
							catch(Exception e){
								e.printStackTrace();
							}
							iv_drug_details.add(resultSet.getString("DRUG_CLASS"));//32
							iv_drug_details.add(resultSet.getString("AUTHORIZED_BY"));//33
					
							str_date= resultSet.getString("END_DATE_TIME");
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							iv_drug_details.add(str_date);//34

							//iv_drug_details.add(resultSet.getString("END_DATE_TIME"));
							iv_drug_details.add(resultSet.getString("FREQ_CODE"));//35
							iv_drug_details.add(resultSet.getString("FREQ_NATURE"));//36
							iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//37
							iv_drug_details.add(resultSet.getString("PRACT_ID"));//38
					
							str_date= resultSet.getString("AGAINST_SCHDOSE_DATE_TIME");
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							iv_drug_details.add(str_date);//39

							//iv_drug_details.add(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
							iv_drug_details.add(resultSet.getString("ADR_REASON_CODE")); //40         
							iv_drug_details.add(resultSet.getString("ADR_REMARKS")); //41             
					
							str_date= resultSet.getString("ADR_RECORDED_DATE_TIME");
							if(!locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							iv_drug_details.add(str_date);//42

							//iv_drug_details.add(resultSet.getString("ADR_RECORDED_DATE_TIME"));   
							iv_drug_details.add(resultSet.getString("ADR_RECORDED_BY"));  //43
							iv_drug_details.add(resultSet.getString("IV_PREP_YN"));//44
							iv_drug_details.add(ext_prod_id);//45
							iv_drug_details.add(drug_count);//46
							iv_drug_details.add("");//47
							iv_drug_details.add("");//48
							iv_drug_details.add(route_desc);	//49
							iv_drug_details.add(resultSet.getString("PRES_CATG_CODE"));//50
							iv_drug_details.add(resultSet.getString("schedule_uom_desc"));//51		
					        iv_drug_details.add(resultSet.getString("sch_dosage_uom_code"));//52	
							iv_drug_details.add(resultSet.getString("ADMN_DOSE_CHNG_REMARKS")==null?"":resultSet.getString("ADMN_DOSE_CHNG_REMARKS")); //53
							iv_drug_details.add("");//54 linked vaccine schedule
							iv_drug_details.add(resultSet.getString("MFR_YN")); //55 MultiFlowRateYN
							iv_drug_details.add(resultSet.getString("FLOW_STATUS")); //56 this is for single FlowRate
							iv_drug_details.add(resultSet.getString("HOLD_DATE_TIME")); //57 this is for single FlowRate in iv
							iv_drug_details.add(resultSet.getString("HOLD_DURN_IN_MINS")); //58 this is for single FlowRate in iv
							iv_drug_details.add(resultSet.getString("RESUME_DATE_TIME")); //59 this is for single FlowRate in iv
							iv_drug_details.add(resultSet.getString("ACT_START_DATE_TIME")); //60 this is for single FlowRate in iv
							iv_drug_details.add(resultSet.getString("ACT_END_DATE_TIME")); //61 this is for single FlowRate in iv
							iv_drug_details.add(resultSet.getString("DOSAGE_TYPE")); //62
							iv_drug_details.add(resultSet.getString("MFR_REMARKS")); //63 MFR REMARKS CAPTURED WHILE ORDERING TIME 
							iv_drug_details.add(resultSet.getString("COMPLETED_DURN_IN_MINS")); //64 if you change flow rate in mid of Single Flow Rate previous flow rate's duration will be captured
							iv_drug_details.add(resultSet.getString("COMPLETED_VOLUME")); //65 if you change flow rate in mid of Single Flow Rate previous flow rate's completed volume will be captured
							iv_drug_details.add(resultSet.getString("PERFORMING_DEPTLOC_CODE")); //66 
							iv_drug_details.add(resultSet.getString("sch_infusion_vol_str_unit_desc")); //67 - sch_infusion_vol_str_unit desc 
							iv_drug_details.add(route_color);//68 Added for ROute Color CRF - 0034
							iv_drug_details.add(resultSet.getString("ORD_PRACT_ID")==null?"":resultSet.getString("ORD_PRACT_ID"));//69 Prescribing pract id //Added for [IN:040149]
							iv_drug_details.add(checkForNull(resultSet.getString("GENERIC_ID")));//70 Added for RUT-CRF-0065.1 [IN:43255]
							iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUG_DESC")));//71 - Alternate disp
							iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUGS"))); //72
							iv_drug_details.add(checkForNull(resultSet.getString("DISP_DRUG_CODE"))); //73
							prescribe_mode.put(resultSet.getString("ORDER_ID")+resultSet.getString("ORDER_LINE_NUM"),resultSet.getString("PRESCRIBED_MODE"));//added for ML-BRU-SCF-1596 [IN:055162] 
							//cancel_recorded_yn=checkForNull(resultSet.getString("CANCEL_RECORDED_YN"));
							iv_drug_details.add(checkForNull(resultSet.getString("CANCEL_RECORDED_YN"))); //74// CANCEL_RECORDED_YN ADDED  FOR JD-CRF-0200
						}
					} 
					else {
						iv_drug_details.add(resultSet.getString("IV_INGREDIANTS"));//1
						iv_drug_details.add(resultSet.getString("SCH_INFUSION_RATE"));//2
						iv_drug_details.add(resultSet.getString("SCH_INFUSION_VOL_STR_UNIT"));//3
						iv_drug_details.add(resultSet.getString("SCH_INFUSION_PER_UNIT"));//4
						iv_drug_details.add(resultSet.getString("BATCH_ID"));//5
				
						str_date= resultSet.getString("EXPIRY_DATE");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
						}
						iv_drug_details.add(str_date);//6

						//iv_drug_details.add(resultSet.getString("EXPIRY_DATE"));
						iv_drug_details.add(resultSet.getString("TRADEID"));//7
						iv_drug_details.add(resultSet.getString("TRADENAME"));//8
						iv_drug_details.add(resultSet.getString("ITEMCODE"));//9
						iv_drug_details.add(resultSet.getString("PATIENT_ID"));//10
						iv_drug_details.add(resultSet.getString("DRUG_CODE"));//11
						iv_drug_details.add(resultSet.getString("DRUG_DESC"));//12
				
						str_date= resultSet.getString("SCH_DATE_TIME");
						order_id = resultSet.getString("ORDER_ID");
					
						pstmt_select_drug_count.setString(1,order_id);
						pstmt_select_drug_count.setString(2,str_date);
						resultSet_drug_count = pstmt_select_drug_count.executeQuery();
						if(resultSet_drug_count!=null && resultSet_drug_count.next())
							drug_count = resultSet_drug_count.getString("NO_OF_DRUGS");

						closeResultSet(resultSet_drug_count);
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						iv_drug_details.add(str_date);//13

						//iv_drug_details.add(resultSet.getString("SCH_DATE_TIME"));
						iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//14
						iv_drug_details.add(order_id);					//15
						iv_drug_details.add(resultSet.getString("ORDER_LINE_NUM"));//16
						iv_drug_details.add(resultSet.getString("QTY"));//17
						iv_drug_details.add(resultSet.getString("SHORT_DESC"));	//18
						iv_drug_details.add(resultSet.getString("DISCONTINUED"));//19
						iv_drug_details.add(resultSet.getString("HELD"));	//20
						iv_drug_details.add(resultSet.getString("SCH_INFUSION_PERIOD"));	//21
						iv_drug_details.add(resultSet.getString("SCH_INFUSION_PERIOD_UNIT"));	//22
						iv_drug_details.add(resultSet.getString("ADMINISTERED_YN"));//23
						iv_drug_details.add(resultSet.getString("ADMIN_RECORDED_YN"));//24
						String administered = resultSet.getString("ADMINISTERED_YN");

						if(administered==null)
							administered="";
						if(administered.equals("N")){
							iv_drug_details.add(resultSet.getString("NON_ADMIN_REMARKS"));//25
						}
						else if(administered.equals("Y")){
							iv_drug_details.add(resultSet.getString("ADMIN_REMARKS"));//25
						}
						else{
							iv_drug_details.add("");//25
						}
						iv_drug_details.add(resultSet.getString("ADMINISTEREDDRUG"));	//26
						iv_drug_details.add(resultSet.getString("USERNAME"));//27
				
						str_date= resultSet.getString("ADMIN_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						iv_drug_details.add(str_date);//28

						//iv_drug_details.add(resultSet.getString("ADMIN_DATE_TIME"));
				
						/*str_date= resultSet.getString("MODIFIED_DATE");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						iv_drug_details.add(str_date);//29*/

						iv_drug_details.add(resultSet.getString("MODIFIED_DATE"));//29
						iv_drug_details.add(resultSet.getString("PRES_DRUG_CODE"));//30
						
						pstmt_select.setString(1,resultSet.getString("ORDER_ID"));
						resultSet_1	=	pstmt_select.executeQuery();
						
						if(resultSet_1!=null && resultSet_1.next()){
							iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//31
						} 
						else {
							iv_drug_details.add(resultSet_1.getString("PERFORMING_DEPTLOC_CODE"));//31
						}
						iv_drug_details.add(resultSet.getString("DRUG_CLASS"));//32
						iv_drug_details.add(resultSet.getString("AUTHORIZED_BY"));//33
				
						str_date= resultSet.getString("END_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						iv_drug_details.add(str_date);//34

						//iv_drug_details.add(resultSet.getString("END_DATE_TIME"));
						iv_drug_details.add(resultSet.getString("FREQ_CODE"));//35
						iv_drug_details.add(resultSet.getString("FREQ_NATURE"));//36
						iv_drug_details.add(resultSet.getString("DOSAGE_SEQ_NO"));//37
						iv_drug_details.add(resultSet.getString("PRACT_ID"));//38
				
						str_date= resultSet.getString("AGAINST_SCHDOSE_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						iv_drug_details.add(str_date);//39

						//iv_drug_details.add(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
						iv_drug_details.add(resultSet.getString("ADR_REASON_CODE"));          //40
						iv_drug_details.add(resultSet.getString("ADR_REMARKS"));              //41
				
						str_date= resultSet.getString("ADR_RECORDED_DATE_TIME");
						if(!locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						iv_drug_details.add(str_date);//42

						//iv_drug_details.add(resultSet.getString("ADR_RECORDED_DATE_TIME"));   
						iv_drug_details.add(resultSet.getString("ADR_RECORDED_BY"));  //43
						iv_drug_details.add(resultSet.getString("IV_PREP_YN"));//44
						iv_drug_details.add(ext_prod_id);//45
						iv_drug_details.add(drug_count);//46
						iv_drug_details.add("");//47
						iv_drug_details.add("");//48
						iv_drug_details.add(route_desc);	//49
						iv_drug_details.add(resultSet.getString("PRES_CATG_CODE"));//50
						iv_drug_details.add(resultSet.getString("schedule_uom_desc"));//51		
						iv_drug_details.add(resultSet.getString("sch_dosage_uom_code"));//52
						iv_drug_details.add(resultSet.getString("ADMN_DOSE_CHNG_REMARKS")==null?"":resultSet.getString("ADMN_DOSE_CHNG_REMARKS")); //53
						iv_drug_details.add(resultSet.getString("VACC_CATEGORY_LINK"));//54 linked vaccine schedule
						iv_drug_details.add(resultSet.getString("MFR_YN")); //55 MultiFlowRateYN
						iv_drug_details.add(resultSet.getString("FLOW_STATUS")); //56 this is for single FlowRate
						iv_drug_details.add(resultSet.getString("HOLD_DATE_TIME")); //57 this is for single FlowRate in iv
						iv_drug_details.add(resultSet.getString("HOLD_DURN_IN_MINS")); //58 this is for single FlowRate in iv
						iv_drug_details.add(resultSet.getString("RESUME_DATE_TIME")); //59 this is for single FlowRate in iv
						iv_drug_details.add(resultSet.getString("ACT_START_DATE_TIME")); //60 this is for single FlowRate in iv
						iv_drug_details.add(resultSet.getString("ACT_END_DATE_TIME")); //61 this is for single FlowRate in iv
						iv_drug_details.add(resultSet.getString("DOSAGE_TYPE")); //62
						iv_drug_details.add(resultSet.getString("MFR_REMARKS")); //63 MFR REMARKS CAPTURED WHILE ORDERING TIME 
						iv_drug_details.add(resultSet.getString("COMPLETED_DURN_IN_MINS")); //64 if you change flow rate in mid of Single Flow Rate previous flow rate's duration will be captured
						iv_drug_details.add(resultSet.getString("COMPLETED_VOLUME")); //65 if you change flow rate in mid of Single Flow Rate previous flow rate's completed volume will be captured
						iv_drug_details.add(resultSet.getString("PERFORMING_DEPTLOC_CODE")); //66 
						iv_drug_details.add(resultSet.getString("sch_infusion_vol_str_unit_desc")); //67 - sch_infusion_vol_str_unit desc 
						iv_drug_details.add(route_color); //68  Added For RUT-CRF_0034 
						iv_drug_details.add(resultSet.getString("ORD_PRACT_ID")); //69 //Added for [IN:040149]
						iv_drug_details.add(checkForNull(resultSet.getString("GENERIC_ID")));//70 Added for RUT-CRF-0065.1 [IN:43255]
						iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUG_DESC")));//71 - Alternate disp
						iv_drug_details.add(checkForNull(resultSet.getString("DISPENSED_DRUGS"))); //72
						iv_drug_details.add(checkForNull(resultSet.getString("DISP_DRUG_CODE"))); //73
						iv_drug_details.add(checkForNull(resultSet.getString("CANCEL_RECORDED_YN"))); //74// CANCEL_RECORDED_YN ADDED  FOR JD-CRF-0200
						
						
					}
				}
			}  
			setSplitDoseYN(split_dose_YN); //ML-MMOH-SCF-1439
			setPresMode(prescribe_mode);//added for ML-BRU-SCF-1596 [IN:055162] 
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        } 
        finally {
            try {
                closeResultSet( resultSet ) ;
				closeResultSet( resultSet_1 ) ;
                closeStatement( pstmt ) ;
				closeStatement(pstmt_patient_class);
				closeResultSet(resultSetPC);
				closeStatement( pstmt_select ) ;
				closeStatement( pstmt_select_drug_count ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
				es.printStackTrace();
			}
        }
		drug_details.put("NON_IV",non_iv_drug_details);
		drug_details.put("IV",iv_drug_details);
		return drug_details;
	}

	//getAutoAdminValue
	public String getAutoAdminValue(String facility_id,String store_code) throws Exception{
		String auto_disp_admin = "N";
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    //pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT30") ) ;
		    pstmt = connection.prepareStatement("SELECT AUTO_DISP_AT_ADMIN_YN FROM PH_DISP_LOCN WHERE FACILITY_ID=? AND DISP_LOCN_CODE=?") ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,store_code.trim());
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				auto_disp_admin = resultSet.getString("AUTO_DISP_AT_ADMIN_YN");
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
		return auto_disp_admin;
	}

	public String validateForMultiStrength(String drug_code) throws Exception{
		String multi_strength_yn = "N";
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT3") ) ;
			pstmt.setString(1,drug_code.trim());
		
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				multi_strength_yn = resultSet.getString("DISP_MULTI_STRENGTH_YN");
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
		return multi_strength_yn;
	}

	public HashMap validateNewEntryBatchID(String drug_code,String batch_id)throws Exception{
		HashMap batch_details = new HashMap();
		Connection connection = null ;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT7") ) ;
			pstmt.setString(1,drug_code);
			resultSet = pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				String item_code = resultSet.getString("INVENTORY_ITEM_CODE");
				batch_details = validateForBatchID(item_code,batch_id);
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

		return batch_details;
	}

	public HashMap validateForBatchID(String item_code,String batch_id)throws Exception{
		HashMap batch_details = new HashMap();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		locale = getLanguageId()==null?"en":getLanguageId();
		String str_date = "";

        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT4") ) ;
			pstmt.setString(1,item_code.trim());	
			pstmt.setString(2,batch_id.trim());
			pstmt.setString(3,locale);
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				batch_details.put("EXPIRED",	resultSet.getString("EXPIRED"));
				batch_details.put("TRADE_NAME",	resultSet.getString("TRADE_NAME"));
				batch_details.put("TRADE_ID",	resultSet.getString("TRADE_ID"));
					
				str_date= resultSet.getString("EXPIRY_DATE");
				if(!locale.equals("en")){
					str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
				}

				batch_details.put("EXPIRY_DATE",str_date);
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
		return batch_details;
	}

	public void saveRemarksForDrug(String row_no,String drug_code,ArrayList remarks){
		drug_remarks.put(drug_code+"$"+row_no,remarks);
	}

	public void setRemarks( ArrayList arr_list_remarks){
		this.all_remarks=arr_list_remarks;
	}

	public ArrayList getAllRemarks(){
		return this.all_remarks;
	}

	public HashMap getRemarksForDrug(){
		return drug_remarks;
	}

	public ArrayList getRemarksForDrug(String drug_code,String row_no){
		return ((ArrayList)drug_remarks.get(drug_code+"$"+row_no));
	}

	public void setCurrentTimeAndAdminWithinHRS(){
//		String time = "";
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		locale = getLanguageId()==null?"en":getLanguageId();

        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT5") ) ;
			pstmt.setString(1,login_facility_id.trim());
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				this.current_time	=	resultSet.getString("TIME");
				this.current_date_time = resultSet.getString("DATE_TIME");
				this.rec_admin_within_hrs = resultSet.getString("REC_ADMIN_WITHIN_HRS");
				this.future_time = resultSet.getString("FUTURE_TIME");
				
				if(!locale.equals("en")){
					this.current_date_time = com.ehis.util.DateUtils.convertDate(this.current_date_time, "DMYHM","en",locale);
					this.current_time	=	com.ehis.util.DateUtils.convertDate(this.current_time, "HM","en",locale);
					//this.rec_admin_within_hrs = com.ehis.util.DateUtils.convertDate(this.rec_admin_within_hrs, "DMYHM","en",locale);
					this.future_time = com.ehis.util.DateUtils.convertDate(this.future_time, "HM","en",locale);
					
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
            catch(Exception es) {
				es.printStackTrace();
			}
        }
	}

	public ArrayList getCurrentTimeAndAdminWithinHRS(){
		ArrayList result = new ArrayList();
		result.add(current_date_time);
		result.add(rec_admin_within_hrs);
		result.add(future_time);
		
		return result;
	}	
	
	/********************* setAll  *******************************************************/
    public void setAll( Hashtable recordSet ) {
       this.mode =(String)recordSet.get("mode");
	   admin_drug_details=recordSet;
	}

	public HashMap insert(){
		String auto_admin		="";
		ArrayList dispTmp	 = new ArrayList() ;
		ArrayList non_iv	=new ArrayList();
		ArrayList iv	=new ArrayList();
		HashMap alt_iv	=new HashMap();
	   	HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in insert.." ) ;
		map.put( "flag", "0" ) ;
		locale = getLanguageId()==null?"en":getLanguageId();

		try{
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_MEDICATION_ADMINISTRATION_FT") ) ;

			home  = (MedicationAdministrationFTHome) PortableRemoteObject.narrow( object, MedicationAdministrationFTHome.class ) ;
			remote = home.create() ; */
			if("Y".equals(getUserAuthPINRequiredYN()))  // Added for RUT-CRF-0035 [IN029926] - Based on this flag, the User ID Captured with PIN will be updated
				login_by_id=getAuthUserID();
			setTodaysDate();
			HashMap drug_details = divideDrugsBasedOnProperties(admin_drug_details);
			HashMap validate_mand = validateForMandatory(drug_details);
			non_iv=getNonIvDetails();
			iv=getIvDetails();
			ArrayList non_iv_drugs=(ArrayList)drug_details.get("NON_IV_DRUGS");
			ArrayList iv_drugs=(ArrayList)drug_details.get("IV_DRUGS");
			if(non_iv_drugs.size()>0){
				for (int i=0;i<non_iv_drugs.size() ;i=i+50){//Changed 45 to 46//Replcaed 44 with 45 for HSA-CRF-0090 , code 'i=i+43' is replaced by i=i+44 for CRF-PH- RUT-CRF-0088[IN043881]  // 46 Changed to 48 for GHL-CRF-0482
					auto_admin=(String)non_iv_drugs.get(i+39);
				}
			}
			else{
				for (int i=0;i<iv_drugs.size() ;i=i+42){//Changed 40 to 41 //AAKH-CRF-0024 [IN:038260]//Replcaed 39 with 40 for HSA-CRF-0090 and changed 41 to 42 for SKR-SCF-1240
					auto_admin=(String)iv_drugs.get(i+36);
				}
			}
			if(auto_admin==null) 
				auto_admin="";
 			if(auto_admin.equals("Y")){				
				dispTmp=formDispensingDetails(non_iv_drugs,iv,alt_iv);    // Replaced from non_iv with non_iv_drugs for ML-BRU-SCF-1594
			}
			if(validate_mand.get("message") != null && !((String)validate_mand.get("message")).equals("")){
				return validate_mand;
			}
			String today = getTodaysDate(); // added for LEAP-INT-PH-SCF-14965 [IN:004059] -start
			String todayDateTime = getTodaysDateTime();
			if(!locale.equals("en")){
				today = com.ehis.util.DateUtils.convertDate(today, "DMY",locale,"en");
				todayDateTime = com.ehis.util.DateUtils.convertDate(todayDateTime, "DMY",locale,"en");
			}//added for LEAP-INT-PH-SCF-14965 [IN:004059] -end
			HashMap tabData = new HashMap() ;
			tabData.put( "ONLY_STOCK_UPDATE", "N");
			tabData.put( "properties", getProperties() );
			tabData.put( "NON_IV_DRUGS", drug_details.get("NON_IV_DRUGS") );
			tabData.put( "ALTERNATE_DRUGS", drug_details.get("ALTERNATE_DRUGS") );
			tabData.put( "NEW_NON_IV_DRUGS", drug_details.get("NEW_NON_IV_DRUGS") );
			tabData.put( "COMMON_VALUES",  drug_details.get("COMMON_VALUES"));
			tabData.put( "IV_DRUGS",  drug_details.get("IV_DRUGS"));
			tabData.put( "ADR_VALUES",  this.adrDetails);
			tabData.put( "ADR_REASON",  this.adrReason);
			tabData.put( "ADR_ALL_VALUES",  this.all_dtls);
			tabData.put( "update_remarks",this.all_remarks);
			tabData.put( "disp_stage", "D");
			tabData.put( "today",today); //getTodaysDate() changed for LEAP-INT-PH-SCF-14965 [IN:004059]
			tabData.put( "dateTime",todayDateTime);//getTodaysDateTime() changed added for LEAP-INT-PH-SCF-14965 [IN:004059]
			tabData.put( "stock_srl",this.stock_srl);
			tabData.put( "DISP_DTLS", dispTmp );
			tabData.put( "AddedTaperSch", getAddedTaperSch() );

			tabData.put( "facility_id", login_facility_id.trim() );
			tabData.put( "login_by_id", login_by_id.trim() );
			tabData.put( "login_at_ws_no",login_at_ws_no.trim());
			tabData.put( "patient_class",getPatientClass());
		
			String store_c=getStoreLocnnCode((String)admin_drug_details.get("nursing_unit") ) ;
			
			tabData.put( "disp_locn_code_MAR",store_c );
			tabData.put( "disp_locn_code",store_c );
			tabData.put( "function_from",  checkForNull((String)admin_drug_details.get("function_from")));

			//tabData.put( "disp_locn_code", (String)admin_drug_details.get("nursing_unit") );
		
			//tabData.put( "patient_class", "I" );
			//String store_c=getStoreLocnnCode((String)admin_drug_details.get("nursing_unit") ) ;
	
			tabData.put( "source_code",(String)admin_drug_details.get("nursing_unit"));
			String source_type="";
			if(getPatientClass().equals("I")|| getPatientClass().equals("D") )
				source_type="N";
			else
				source_type="C";
			
			tabData.put( "source_type",source_type);
			tabData.put( "ordering_facility_id",login_facility_id);
			tabData.put( "ord_date_time",admin_drug_details.get("non_iv_sch_date_time_1")); //it is wrong by abdul
			//tabData.put( "Auto_admin",admin_drug_details.get("Auto_Admin"));
			tabData.put( "Auto_admin",auto_admin);

			tabData.put( "patient_id", admin_drug_details.get("patient_id"));
			tabData.put( "encounter_id", admin_drug_details.get("encounter_id"));
		 	tabData.put( "store_code", (String)admin_drug_details.get("disp_locn_code"));
			//tabData.put( "store_code", store_c);
			tabData.put( "language_id", locale);
			tabData.put( "barcode_remarks",getManualBarcodeRemarks() ) ;//Added for MMS-DM-CRF-0157.1

			/***********************************************************/
			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_MEDN_ADMIN_FT_UPDATE",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_FT_UPDATE"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_UPDATE"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE"));
			
//			sqlMap.put("SQL_PH_MEDN_ADMIN_DTL_FT_INSERT",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_DTL_FT_INSERT"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_DTL_FT_INSERT","INSERT INTO PH_MEDN_ADMIN_DTL ( FACILITY_ID, ENCOUNTER_ID,  SCH_DATE_TIME,  ORD_DRUG_CODE, DOSAGE_SEQ_NO, SRL_NO,  ADMIN_DRUG_CODE, ADMIN_DOSAGE_QTY,  ADMIN_DOSAGE_UOM_CODE,  ADMIN_STRENGTH, ADMIN_STRENGTH_UNIT, ADMIN_INFUSION_RATE, ADMIN_INFUSION_VOL_STR_UNIT, ADMIN_INFUSION_PER_UNIT, ADMIN_BY,  ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,  ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,  MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, ITEM_CODE,  BATCH_ID, EXPIRY_DATE, TRADE_ID,DISP_BATCH_ID,DISP_EXPIRY_DATE,DISP_TRADE_ID, ORDER_ID,VACC_CATEGORY_LINK, ADMIN_BY_TYPE, SELF_ADMIN_BY, ADMIN_REASON_CODE,EARLY_OR_LATE_ADMIN,BATCH_ORDER_ID,BATCH_ORDER_LINE_NUM)   VALUES (  ?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'), ?,?,?,?,?,?,  ?,?,?,  ?,?,?,  ?,SYSDATE,?,  ?,?,SYSDATE,  ?, ?,?,  ?,decode(?,null,null,TO_DATE(?,'dd/mm/yyyy hh24:mi')),?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?, ?,?,?, ?,?)"); // EARLY_OR_LATE_ADMIN and BATCH_ORDER_ID,BATCH_ORDER_LINE_NUM Added for GHL-CRF-0482
			sqlMap.put("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE1",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE1"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_OR_ORDER_LINE_PH_UPDATE",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_OR_ORDER_LINE_PH_UPDATE"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_FT_INSERT",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_FT_INSERT"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_INSERT",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_INSERT"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_FT_IV_UPDATE",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_FT_IV_UPDATE"));
			sqlMap.put("SQL_PH_MED_ADMIN_FT_SELECT9",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT9"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_INSERT"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT33",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT33"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT56",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT56"));
			sqlMap.put("SQL_PH_MED_ADMIN_DOSAGE_SEQ_NO",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_DOSAGE_SEQ_NO"));
			sqlMap.put("SQL_PH_MED_ADMIN_MEDN_ADMIN_VALUES",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_MEDN_ADMIN_VALUES"));
			sqlMap.put("SQL_PH_MED_ADMIN_MEDN_ADMIN_FREQ_NATURE",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_MEDN_ADMIN_FREQ_NATURE"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_UPDATE2",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_UPDATE2"));
			sqlMap.put("SQL_PH_MED_ADMIN_FT_SELECT_DOSES",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT_DOSES"));
			sqlMap.put("SQL_PH_ADMIN_OR_ORDER_SELECT",PhRepository.getPhKeyValue("SQL_PH_ADMIN_OR_ORDER_SELECT"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_FT_INSERT1",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_FT_INSERT1"));
			sqlMap.put("SQL_PH_MED_ADMIN_FT_SELECT17",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT17"));
			sqlMap.put("SQL_PH_MED_ADMIN_FT_SELECT18",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT18"));
			sqlMap.put("SQL_PH_MED_ADMIN_FT_SELECT19",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT19"));

			sqlMap.put("SQL_PH_MEDN_ADMIN_FT_INSERT2",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_FT_INSERT2"));	
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT86",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT86"));	
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT1",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT1"));	
			sqlMap.put("SQL_PH_MED_ADMIN_FT_SELECT27",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT27"));	
			
			sqlMap.put("SQL_PH_MEDN_ADMIN_FT_IV_UPDATE1",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_FT_IV_UPDATE1"));	
            sqlMap.put("SQL_PH_DISP_MEDICATION_BL_SELECT2",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT2"));	
			sqlMap.put("SQL_PH_DISP_MEDICATION_BL_SELECT1",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1"));	
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE12",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE12"));	
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT45",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT45"));	
			sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE13A",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE13A"));	
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT137",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT137"));	
			
			sqlMap.put("SQL_PH_MED_ADMIN_ORDER_QTY_SELECT32",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_ORDER_QTY_SELECT32"));	
			sqlMap.put("SQL_PH_MED_ADMIN_OR_ORDER_LINE_STATUS_UPDATE",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_OR_ORDER_LINE_STATUS_UPDATE"));	
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT167",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT167"));
			sqlMap.put("SQL_PH_MED_ADMIN_LABEL_CAU_SELECT33",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_LABEL_CAU_SELECT33"));	
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT106",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT106"));	
			sqlMap.put("SQL_PH_DISP_MEDICATION_ORDER_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_ORDER_UPDATE"));
		
//			HashMap result = remote.insert( tabData, sqlMap ) ;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_MEDICATION_ADMINISTRATION_FT" ),MedicationAdministrationFTHome.class,getLocalEJB());
			Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] =new Object[2];
			argArray[0]= tabData;
			argArray[1]=sqlMap;

			Class  paramArray[] = new Class[2];
			paramArray[0]= tabData.getClass();
			paramArray[1] = sqlMap.getClass();
			HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put( "result", new Boolean( true ) ) ;	
		
				map.put( "message", getMessage(locale,(String) result.get( "msgid" ),"PH") ) ;
				map.put("flag","0");
			}
			else{	
				if(((String)result.get("msgid")).equals("ADMIN_BY_OTHERS")){
					map.put( "message", getMessage(locale,(String)result.get("msgid"),"PH" )) ;
				}
				else{
					map.put( "message", (String)result.get("msgid") ) ;
				}
				map.put("flag","0");
			}			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	//	map.put("result", new Boolean( true ) ) ;
		map.put("flag", "" ) ;
		return map;
	}

	public HashMap validateForMandatory(HashMap drug_details ){
		HashMap result = new HashMap();
		result.put("message","");
		locale = getLanguageId()==null?"en":getLanguageId();
		
		ArrayList non_iv   = (ArrayList)drug_details.get("NON_IV_DRUGS") ;
		HashMap alt_non_iv = new HashMap();
		if(drug_details.get("ALTERNATE_DRUGS")!= null){
			alt_non_iv = (HashMap)drug_details.get("ALTERNATE_DRUGS") ;
		}
		ArrayList iv	= (ArrayList)drug_details.get("IV_DRUGS");		
		if(non_iv!=null && non_iv.size()>0){
			for (int i=0;i<non_iv.size() ;i=i+50){//Changed 45 to 46 //Replcaed 44 with 45 for HSA-CRF-0090 //code 'i=i+43' is replaced by i=i+44 for CRF-PH- RUT-CRF-0088[IN043881] // 46 changed t0 48 for GHL-CRF-0482 
			//for (int i=0;i<non_iv.size() ;i=i+37){
				if( (non_iv.get(i+4)!=null && ((String)non_iv.get(i+4)).equals("N")) && non_iv.get(i+6)==null && non_iv.get(i+7)==null){
					result.put("message","MANDATORY_ADMIN_DETAILS");
					result.put( "result", new Boolean( false ) ) ;
					return result;
				}
				else if((non_iv.get(i+4)!=null && ((String)non_iv.get(i+4)).equals("N")) && non_iv.get(i+6)!=null && ((String)non_iv.get(i+6)).equals("") && non_iv.get(i+7)!=null && ((String)non_iv.get(i+7)).equals("")){
					result.put("message","MANDATORY_ADMIN_DETAILS");
					result.put( "result", new Boolean( false ) ) ;
					return result;
				}				
				else{
					setNonIvDetails(non_iv);
				}
			}
		}

		if(iv!=null && iv.size()>0){
			for (int i=0;i<iv.size() ;i=i+42 ){//Changed 40 to 41 //Replcaed 38 with 40 for HSA-CRF-0090//changed 29 to 35 and changed 41 to 42 for SKR-SCF-1240
			//for (int i=0;i<iv.size() ;i=i+34 ){ //changed 29 to 34
				if(iv.get(15)==null && iv.get(16)==null){
					result.put("message","MANDATORY_ADMIN_DETAILS");
					result.put( "result", new Boolean( false ) ) ;
					return result;
				}
				else if(iv.get(15)!=null && ((String)iv.get(15)).equals("") && iv.get(16)!=null && ((String)iv.get(16)).equals("") && iv.get(17)!=null && ((String)iv.get(15)).equals("Y")){
					result.put("message","MANDATORY_ADMIN_DETAILS");
					result.put( "result", new Boolean( false ) ) ;
					return result;
				}
				else{
					setIvDetails(iv);
				}
			}
		}

		if(alt_non_iv!=null && alt_non_iv.size()>0){
			Set set = alt_non_iv.keySet();
			Iterator iterator = set.iterator();
			ArrayList array_list_alt_non_iv = new ArrayList();
			while (iterator.hasNext()){
				array_list_alt_non_iv = (ArrayList)alt_non_iv.get((String)iterator.next());				
				for (int i=0;i<array_list_alt_non_iv.size() ;i=i+25 ){//Replcaed 24 with 25 for HSA-CRF-0090
					
					if(array_list_alt_non_iv.get(15)==null && array_list_alt_non_iv.get(16)==null){
						result.put("message","MANDATORY_ADMIN_DETAILS");
						result.put( "result", new Boolean( false ) ) ;
						return result;
					}
					else if(array_list_alt_non_iv.get(15)!=null && ((String)array_list_alt_non_iv.get(15)).equals("") && array_list_alt_non_iv.get(16)!=null && ((String)array_list_alt_non_iv.get(16)).equals("")){
						result.put("message","MANDATORY_ADMIN_DETAILS");
						result.put( "result", new Boolean( false ) ) ;
						return result;
					}
				}

			}
		}
		return result;
	}

	//getting system date
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
				sys_date=resultSet.getString("SYS_DATE_TIME");
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
				es.printStackTrace();
			}
        }
		
		if(!locale.equals("en")){
			sys_date = com.ehis.util.DateUtils.convertDate(sys_date, "DMYHM","en",locale);
		}
		return sys_date;
		
	}

	public String getNextSchdate(String order_id,String order_line_no,int dosage_seq_no,String schedule_date_time)throws Exception{
	
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		
		float infuse_over			= 0f;
		int durn_value				= 0;
		String infuse_over_unit	    = "";
		float tmp_infuse_over		= 0f;
		//int i						= 1;
		String start_date_time		= "";
		String next_schd_time		= "";
		locale = getLanguageId();
		// if condtion Added for SRK-SCF-1145 TF
		if(!locale.equals("en")){      // Added for RollForwarded from SRR - SRR20056-SCF-9369 [IN057079]
			schedule_date_time = com.ehis.util.DateUtils.convertDate(schedule_date_time, "DMYHM",locale,"en");
	    }
		try{
			connection				= getConnection() ;
//			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_IV_NXT_SCH_SELECT32") ; Changed A.INFUSE_OVER to A.ORIG_INFUSE_OVER issue : 25941
			String str_qry			= "SELECT A.ORIG_INFUSE_OVER INFUSE_OVER ,B.DURN_VALUE DURN_VALUE ,B.DURN_TYPE DURN_TYPE,TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE_TIME,INFUSE_OVER_UNIT FROM OR_ORDER_LINE_PH A, OR_ORDER_LINE B WHERE A.ORDER_ID=B.ORDER_ID AND A.ORDER_LINE_NUM = B.ORDER_LINE_NUM AND A.ORDER_ID =(?) AND A.ORDER_LINE_NUM ='1'" ;
			pstmt					= connection.prepareStatement(str_qry) ;
			pstmt.setString( 1, order_id);
			resultSet				= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()){
				infuse_over			= resultSet.getFloat("infuse_over");
				durn_value			= resultSet.getInt("durn_value");
				if(schedule_date_time==null || schedule_date_time==""){		//added for SCF-7528 -- start
					start_date_time	= checkForNull(resultSet.getString("start_date_time"));
				}					 //for SCF-7528 --end
				infuse_over_unit	= checkForNull(resultSet.getString("INFUSE_OVER_UNIT"));
			}
			
			tmp_infuse_over			= infuse_over;
			/*while(i < dosage_seq_no && dosage_seq_no > 1 ){
				infuse_over			+= tmp_infuse_over;
				i++;
			}*/
			closeResultSet( resultSet ) ;	
			closeStatement( pstmt ) ;
			String str_qry1					="";
			if(infuse_over_unit .equals("H")){
			    str_qry1					= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_IV_NXT_SCH_SELECT33"); 
			}
			else if(infuse_over_unit .equals("M")){
				
			    str_qry1					= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_IV_NXT_SCH_SELECT33M"); 
			}
			if(str_qry1 != ""){
				pstmt							= connection.prepareStatement(str_qry1) ;
				if(schedule_date_time==null || schedule_date_time==""){		
					pstmt.setString( 1, start_date_time);  //start_date_time
				}
				else {
				   pstmt.setString( 1, schedule_date_time);   
				}
				pstmt.setFloat( 2, infuse_over);
				
				resultSet				= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					next_schd_time		=  checkForNull(resultSet.getString("next_schd_time"));
				}	
			}
		}
		catch ( Exception e ) {
			System.err.println("===getNextSchdate order_id ===="+order_id+" order_line_no"+order_line_no+" dosage_seq_no="+dosage_seq_no+" schedule_date_time="+schedule_date_time+" next_schd_time="+next_schd_time+" infuse_over="+infuse_over+" infuse_over_unit="+infuse_over_unit+" durn_value="+durn_value+" tmp_infuse_over="+tmp_infuse_over);
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		/*if(!locale.equals("en")){
			next_schd_time = com.ehis.util.DateUtils.convertDate(next_schd_time, "DMYHM","en",locale);
			
		} */
		
		return next_schd_time;
	}

	public HashMap divideDrugsBasedOnProperties(Hashtable recordSet){
		HashMap result = new HashMap();
		ArrayList non_iv_drugs = new ArrayList();
		ArrayList newly_added_non_iv_drugs = new ArrayList();
		ArrayList iv_drugs = new ArrayList();
		String pat_id		=	"";
		String str_date="";
		locale = getLanguageId();
		try{
			HashMap commonValues = new HashMap();
			commonValues.put("language_id",locale);
			commonValues.put("facility_id",login_facility_id);
			commonValues.put("encounter_id",(String)recordSet.get("encounter_id"));
			commonValues.put("assign_bed_num",(String)recordSet.get("assign_bed_num"));
			commonValues.put("nursing_unit",(String)recordSet.get("nursing_unit"));
			commonValues.put("disp_locn_code",(String)recordSet.get("disp_locn_code"));
			commonValues.put("store_code",(String)recordSet.get("nursing_unit"));
			commonValues.put("admin_by",login_by_id);
			commonValues.put("added_by",login_by_id);
			commonValues.put("ws_no",login_at_ws_no);
			commonValues.put("disp_stage","D");

			str_date = getTodaysDate();
			if(!locale.equals("en"))
				str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY",locale,"en");

			commonValues.put( "today",str_date);
			str_date = getTodaysDateTime();

			if(!locale.equals("en"))
				str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");

			commonValues.put( "dateTime",str_date);
			commonValues.put( "stock_srl",this.stock_srl);

			commonValues.put( "login_by_id", login_by_id.trim() );
			commonValues.put( "login_at_ws_no",login_at_ws_no.trim());
			if(recordSet.get("patient_id_selected")==null || ((String)recordSet.get("patient_id_selected")).equals("")) {
				pat_id	=	(String)recordSet.get("patient_id");
			}
			else {
				pat_id	=	(String)recordSet.get("patient_id_selected");
			}
			commonValues.put("patient_id",pat_id);
			str_date = getSysdate();


			if(!locale.equals("en"))
				str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");

			if(!locale.equals("en"))// if block added for LEAP-INT-PH-SCF-14965 [IN:004059]
				commonValues.put("sysdate",com.ehis.util.DateUtils.convertDate(getSysdate(), "DMYHM",locale,"en"));
			else
				commonValues.put("sysdate", getSysdate());
			commonValues.put( "patient_class", getPatientClass());
			
			int non_iv_records = Integer.parseInt(((String)recordSet.get("non_iv_records")).trim());
			int alt_non_iv_records = Integer.parseInt(((String)recordSet.get("alt_non_iv_records")).trim());
			int iv_records=Integer.parseInt(((String)recordSet.get("iv_records")).trim());
			ArrayList remarks = null;
			String iv_Prep_YN=""; 
			String order_Line_Number="";
			String uom ="";
			int numOLN=1;
			int numOLN1=0;
			if(non_iv_records >0){
				for (int i=1;i<=non_iv_records ;i++ ){
					if(recordSet.get("chk_non_iv_select_"+i) != null && !((String)recordSet.get("chk_non_iv_select_"+i)).equals("") ){
						if(((String)recordSet.get("non_iv_status_flag_"+i)).equals("YES")){
							if(recordSet.containsKey("non_iv_drug_code_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_drug_code_"+i));	//1			
							}
							else{
								non_iv_drugs.add("");		//1		
							}
							if(recordSet.containsKey("non_iv_dosage_seq_no_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_dosage_seq_no_"+i));	//2			
							}
							else{
								non_iv_drugs.add("");	//2			
							}
							if(recordSet.containsKey("non_iv_time_"+i)){
								str_date = (String)recordSet.get("non_iv_time_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
								non_iv_drugs.add(str_date);		//3		
							}
							else{
								non_iv_drugs.add("");		//3		
							}
							if(recordSet.containsKey("non_iv_sch_date_time_"+i)){
								str_date = (String)recordSet.get("non_iv_sch_date_time_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
								non_iv_drugs.add(str_date);		//4		
							}
							else{
								non_iv_drugs.add("");	//4			
							}
							remarks = getRemarksForDrug((String)recordSet.get("non_iv_drug_code_"+i),i+"");
							if(remarks==null){
								remarks = new ArrayList();
								remarks.add("");
								remarks.add("");
								remarks.add("");
								remarks.add("");
								remarks.add("");
								remarks.add("");
								remarks.add("");
							}
							iv_Prep_YN=""; 
							order_Line_Number="";
							numOLN=1;
							numOLN1=0;
							if(recordSet.containsKey("iv_prep_yn_forNONIV"+i)){
								iv_Prep_YN=(String) recordSet.get("iv_prep_yn_forNONIV"+i);
							}
							if(recordSet.containsKey("non_iv_order_line_no_"+i)){
								order_Line_Number=(String) recordSet.get("non_iv_order_line_no_"+i);
								numOLN=Integer.parseInt(order_Line_Number);
							}
							if(iv_Prep_YN.equals("9") && numOLN >1){
								numOLN1=i-numOLN+1;
								if(recordSet.containsKey("non_iv_chk_"+numOLN1)){
									if(((String)recordSet.get("non_iv_chk_"+numOLN1)).equals("E")){
										non_iv_drugs.add("Y");//5							// ADMINISTERED_YN
										non_iv_drugs.add("Y");//6							// ADMIN_RECORDED_YN
										non_iv_drugs.add((String)remarks.get(1));//7		// ADMIN_REMARKS
										non_iv_drugs.add("");//8							// NON_ADMIN_REMARKS									
									}
									else{
										non_iv_drugs.add("N");//5							// Not ADMINISTERED_YN
										non_iv_drugs.add("Y");//6							// ADMIN_RECORDED_YN
										non_iv_drugs.add("");//7							// ADMIN_REMARKS
										non_iv_drugs.add((String)remarks.get(1));//8		// NON_ADMIN_REMARKS
									}
								}
							}
							else if(recordSet.containsKey("non_iv_chk_"+i)){
								if(((String)recordSet.get("non_iv_chk_"+i)).equals("E")){
									non_iv_drugs.add("Y");//5							// ADMINISTERED_YN
									non_iv_drugs.add("Y");//6							// ADMIN_RECORDED_YN
									non_iv_drugs.add((String)remarks.get(1));//7		// ADMIN_REMARKS
									non_iv_drugs.add("");//8							// NON_ADMIN_REMARKS									
								}
								else{
									non_iv_drugs.add("N");//5							// Not ADMINISTERED_YN
									non_iv_drugs.add("Y");//6							// ADMIN_RECORDED_YN
									non_iv_drugs.add("");//7							// ADMIN_REMARKS
									non_iv_drugs.add((String)remarks.get(1));//8		// NON_ADMIN_REMARKS
								}
							}
							if(recordSet.containsKey("non_iv_admin_qty_"+i) && !( (recordSet.get("non_iv_admin_qty_"+i)).equals("") )){
								non_iv_drugs.add(recordSet.get("non_iv_admin_qty_"+i));//9				
							}
							else{
								non_iv_drugs.add("0");//9			// replaced "" with "0" for IN24151 --12/10/2010-- priya	
							}
							if(recordSet.containsKey("non_iv_batch_id_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_batch_id_"+i));	//10			
							}
							else{
								non_iv_drugs.add("");	//10			
							}	
							if(recordSet.containsKey("non_iv_expiry_date_"+i)){
								str_date =(String) recordSet.get("non_iv_expiry_date_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY",locale,"en");
								non_iv_drugs.add(str_date);	//11			
							}
							else{
								non_iv_drugs.add("");	//11			
							}
							if(recordSet.containsKey("non_iv_trade_id_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_trade_id_"+i));	//12			
							}
							else{
								non_iv_drugs.add("");	//12			
							}
							if(recordSet.containsKey("non_iv_item_code_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_item_code_"+i));	//13			
							}
							else{
								non_iv_drugs.add("");	//13			
							}
							if(recordSet.containsKey("non_iv_admin_qty_uom_"+i)){
								uom = (String)recordSet.get("non_iv_admin_qty_uom_"+i);						
								if(uom.length()>4){
									uom=uom.substring(0,3);
								}
								non_iv_drugs.add(uom);	//14			
							}
							else{
								non_iv_drugs.add("");	//14			
							}

							if(recordSet.containsKey("non_iv_order_id_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_order_id_"+i));//15		//commonValues.put("disp_locn_code",(String)recordSet.get("disp_locn_code"+i+));	
							}
							else{
								non_iv_drugs.add("");		//15		
							}

							if(recordSet.containsKey("non_iv_order_line_no_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_order_line_no_"+i));	//16			
							}
							else{
								non_iv_drugs.add("");			//16	
							}
							non_iv_drugs.add((String)remarks.get(0));	//17			// REASON_CODE	
							non_iv_drugs.add((String)remarks.get(2));	//18			// ADMIN_BY	
							non_iv_drugs.add((String)remarks.get(3));	//19			// AUTHORISED_BY	
							
							if(recordSet.containsKey("non_iv_store_code_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_store_code_"+i));//20				
							}
							else{
								non_iv_drugs.add("");		//20		
							}
							
							if(recordSet.containsKey("non_iv_bin_code_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_bin_code_"+i));	//21			
							}
							else{
								non_iv_drugs.add("");		//21		
							}

							if(recordSet.containsKey("non_iv_trade_name_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_trade_name_"+i));//22				
							}
							else{
								non_iv_drugs.add("");				//22
							}

							if(recordSet.containsKey("non_iv_end_date_"+i)){
								str_date = (String)recordSet.get("non_iv_end_date_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
								non_iv_drugs.add(str_date);		//23		
							}
							else{
								non_iv_drugs.add("");		//23	
							}
						
							//code added for batch_id to insert into ph_medn_admin_dtl
							if(recordSet.containsKey("previous_non_iv_batch_id_"+i) && recordSet.get("previous_non_iv_batch_id_"+i)!=null ){
								non_iv_drugs.add(recordSet.get("previous_non_iv_batch_id_"+i));		//24		
							}
							else{
								non_iv_drugs.add("");				//24
							}	

							if(recordSet.containsKey("previous_non_iv_exp_date_"+i) && recordSet.get("previous_non_iv_exp_date_"+i) !=null){
								str_date = (String)recordSet.get("previous_non_iv_exp_date_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY",locale,"en");
								non_iv_drugs.add(str_date);				//25
							}
							else{
								non_iv_drugs.add("");		//25		
							}	

							if(recordSet.containsKey("previous_non_iv_trade_id_"+i) && recordSet.get("previous_non_iv_trade_id_"+i) !=null){
								non_iv_drugs.add(recordSet.get("previous_non_iv_trade_id_"+i));//26			
							}
							else{
								non_iv_drugs.add("");		//26	
							}
							if(recordSet.containsKey("Newly_administerderd_"+i)){
								non_iv_drugs.add(recordSet.get("Newly_administerderd_"+i));	//27			
							}
							else{
								non_iv_drugs.add("");			//27
							}
							// added by abdul for new CRF on 7/3/09
							if(recordSet.containsKey("non_iv_sliding_scale_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_sliding_scale_"+i));			//28
								if(((String)recordSet.get("non_iv_sliding_scale_"+i)).equals("Y")){
									if(recordSet.containsKey("non_iv_admin_qty_"+i))
										non_iv_drugs.add(recordSet.get("non_iv_admin_qty_"+i));			//29
									else
										non_iv_drugs.add("");			//29
									if(recordSet.containsKey("non_iv_admin_qty_uom_"+i))
										non_iv_drugs.add(recordSet.get("non_iv_admin_qty_uom_"+i));			//30
									else
										non_iv_drugs.add("");			//30
									if(recordSet.containsKey("non_iv_sliding_range_"+i))
										non_iv_drugs.add(recordSet.get("non_iv_sliding_range_"+i));			//31
									else
										non_iv_drugs.add("");			//31
									if(recordSet.containsKey("non_iv_range_uom_"+i))
										non_iv_drugs.add(recordSet.get("non_iv_range_uom_"+i));			//32
									else
										non_iv_drugs.add("");			//32
								}
								else{									
									non_iv_drugs.add("");			//29
									non_iv_drugs.add("");			//30
									non_iv_drugs.add("");			//31
									non_iv_drugs.add("");			//32
								}
							}
							else{
								non_iv_drugs.add("N");			//28
								non_iv_drugs.add("");			//29
								non_iv_drugs.add("");			//30
								non_iv_drugs.add("");			//31
								non_iv_drugs.add("");			//32
							}	
							if(recordSet.containsKey("non_iv_admin_qty1_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_admin_qty1_"+i));//33				
							}
							else{
								non_iv_drugs.add("");//33				
							}
							if(recordSet.containsKey("non_iv_admin_qty_uom1_"+i)){
							non_iv_drugs.add(recordSet.get("non_iv_admin_qty_uom1_"+i));//34				
							}
							else{
								non_iv_drugs.add("");//34				
							}
							if(recordSet.containsKey("pat_brought_med_"+i)){
								if(recordSet.get("pat_brought_med_"+i)==null || recordSet.get("pat_brought_med_"+i)==""){									
									non_iv_drugs.add("N");//35
								}
								else{
									non_iv_drugs.add(recordSet.get("pat_brought_med_"+i));//35				
								}											
							}
							else{
								non_iv_drugs.add("N");//35				
							}
							non_iv_drugs.add((String)remarks.get(5)); //36
							non_iv_drugs.add((String)remarks.get(6)); //37
							if(recordSet.containsKey("link_vaccine_code_"+i)){								
									non_iv_drugs.add(recordSet.get("link_vaccine_code_"+i));//38																		
							}
							else{
								non_iv_drugs.add("");//38				
							}	
							if(recordSet.containsKey("modified_date_time_"+i)){
								non_iv_drugs.add(recordSet.get("modified_date_time_"+i));//39
							}
							else{
								non_iv_drugs.add("");//39		
							}
							if(recordSet.containsKey("non_iv_Auto_Admin_"+i)){
								non_iv_drugs.add(recordSet.get("non_iv_Auto_Admin_"+i));//40
							}
							else{
								non_iv_drugs.add("");//40	
							}
							if(recordSet.containsKey("order_pract_id_"+i)){
								non_iv_drugs.add(recordSet.get("order_pract_id_"+i));//41
							}
							else{
								non_iv_drugs.add("");//41	
							}
							if(recordSet.containsKey("adminByType")){
								non_iv_drugs.add(recordSet.get("adminByType"));//42
							}
							else{
								non_iv_drugs.add("U");//42
							}
							if(recordSet.containsKey("selfAdminBy")){
								non_iv_drugs.add(recordSet.get("selfAdminBy"));//43
							}
							else{
								non_iv_drugs.add("");//43
							}
							if(recordSet.containsKey("non_iv_dosage_type_"+i)){//code added for CRF-PH- RUT-CRF-0088[IN043881] -- Start
								non_iv_drugs.add(recordSet.get("non_iv_dosage_type_"+i));//44
							}
							else{
								non_iv_drugs.add("");//44
							}//code added for CRF-PH- RUT-CRF-0088[IN043881] -- Start
						}
						if(recordSet.containsKey("non_iv_shared_drug_"+i)){//Added for HSA-CRF-0090--start
							non_iv_drugs.add(recordSet.get("non_iv_shared_drug_"+i));	//45			
						}
						else{
							non_iv_drugs.add("N");		//45		
						}//Added for HSA-CRF-0090--end
						non_iv_drugs.add(checkForNull((String)recordSet.get("non_iv_dispense_drug_code_"+i)));	//46
						non_iv_drugs.add(checkForNull((String)recordSet.get("future_or_late_"+i)));	//47 // Added for GHL-CRF-0482
						non_iv_drugs.add(checkForNull((String)recordSet.get("non_iv_patient_stock_"+i)));	//48
						non_iv_drugs.add(checkForNull((String)recordSet.get("non_iv_batch_order_id_"+i)));	//48
						non_iv_drugs.add(checkForNull((String)recordSet.get("non_iv_batch_order_line_no_"+i)));	//49
					}
				}
			}
		
			HashMap alt_drug_details = new HashMap();
			ArrayList alternate_drugs= new ArrayList();
		
			if(alt_non_iv_records>0){
				for (int i=1;i<=alt_non_iv_records ;i++ ){
					if(recordSet.get("chk_alt_non_iv_select_"+i) != null ){
						if(alt_drug_details.containsKey(recordSet.get("main_drug_code_"+i))){
							if(recordSet.containsKey("alt_drug_code_"+i)){
								alternate_drugs.add(recordSet.get("alt_drug_code_"+i));		//1		
							}
							else{
								alternate_drugs.add("");				
							}
							
							if(recordSet.containsKey("main_drug_code_"+i)){
								alternate_drugs.add(recordSet.get("main_drug_code_"+i));	//2			
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_dosage_seq_no_"+i)){
								alternate_drugs.add(recordSet.get("alt_dosage_seq_no_"+i));		//3		
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_item_code_"+i)){
								alternate_drugs.add(recordSet.get("alt_item_code_"+i));			//4	
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_order_id_"+i)){
								alternate_drugs.add(recordSet.get("alt_order_id_"+i));			//5	
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_order_line_no_"+i)){
								alternate_drugs.add(recordSet.get("alt_order_line_no_"+i));		//6	
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_admin_qty_"+i)){
								alternate_drugs.add(recordSet.get("alt_admin_qty_"+i));		    //7
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_admin_qty_uom_"+i)){								
								uom = (String)recordSet.get("alt_admin_qty_uom_"+i);     
								if(uom.length()>4){
									uom=uom.substring(0,3);
								}
								alternate_drugs.add(uom);				//8				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_schedule_date_time_"+i)){		//9			// SCHEDULED DATE/TIME
								str_date = (String)recordSet.get("alt_schedule_date_time_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
								alternate_drugs.add(str_date);				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_time_"+i)){	//10						// ADMINISTERED DATE/TIME
								str_date =(String)recordSet.get("alt_time_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
								alternate_drugs.add(str_date);				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_batch_id_"+i)){ //11
								alternate_drugs.add(recordSet.get("alt_batch_id_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_expiry_date_"+i)){ //12
								str_date = (String)recordSet.get("alt_expiry_date_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY",locale,"en");
								alternate_drugs.add(str_date);				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_trade_id_"+i)){ //13
								alternate_drugs.add(recordSet.get("alt_trade_id_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}
							
							remarks = getRemarksForDrug((String)recordSet.get("alt_drug_code_"+i),i+"");
							if(remarks==null){
								remarks = new ArrayList();
								remarks.add("");
								remarks.add("");
								remarks.add("");
								remarks.add("");
								remarks.add("");
								remarks.add("");
								remarks.add("");
							}
							if(recordSet.containsKey("alt_chk_"+i)){
								if(((String)recordSet.get("alt_chk_"+i)).equals("E")){
									alternate_drugs.add("Y");		//14			// ADMINISTERED_YN  INDEX 13
									alternate_drugs.add("Y");		//15			// ADMIN_RECORDED_YN 14
									alternate_drugs.add((String)remarks.get(1)); //16// ADMIN_REMARKS     15
									alternate_drugs.add("");		//17			// NON_ADMIN_REMARKS 16
								
								}
								else{
									alternate_drugs.add("N");						// ADMINISTERED_YN
									alternate_drugs.add("Y");						// ADMIN_RECORDED_YN
									alternate_drugs.add("");						// ADMIN_REMARKS
									alternate_drugs.add((String)remarks.get(1));	// NON_ADMIN_REMARKS
								}
							}
							alternate_drugs.add((String)remarks.get(0));		//18	// REASON_CODE	17
							alternate_drugs.add((String)remarks.get(2));				// ADMIN_BY	 18
							alternate_drugs.add((String)remarks.get(3));				// AUTHORISED_BY	19
							
							if(recordSet.containsKey("alt_store_code_"+i)){
								alternate_drugs.add(recordSet.get("alt_store_code_"+i));	//20			
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_bin_code_"+i)){
								alternate_drugs.add(recordSet.get("alt_bin_code_"+i));	//21			
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_trade_name_"+i)){
								alternate_drugs.add(recordSet.get("alt_trade_name_"+i));		//22		
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_end_date_"+i)){//23
								str_date = (String)recordSet.get("alt_end_date_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
								alternate_drugs.add(str_date);				
							}
							else{
								alternate_drugs.add("");				
							}
							if(recordSet.containsKey("order_pract_id_"+i)){ //24 
								alternate_drugs.add(recordSet.get("order_pract_id_"+i));
							}
							else{
								alternate_drugs.add("");
							}
							/*if(recordSet.containsKey("adminByType")){ //25
								alternate_drugs.add((String)recordSet.get("adminByType"));
							}
							else{
								alternate_drugs.add("U");
							}
							if(recordSet.containsKey("selfAdminBy")){
								non_iv_drugs.add(recordSet.get("selfAdminBy"));//26
							}
							else{
								non_iv_drugs.add("");//26
							}
							*/
							if(recordSet.containsKey("alt_shared_drug_"+i)){//Added for HSA-CRF-0090--start
								alternate_drugs.add(recordSet.get("alt_shared_drug_"+i));				
							}
							else{
								alternate_drugs.add("N");				
							}//Added for HSA-CRF-0090--end
							alt_drug_details.put((String)recordSet.get("main_drug_code_"+i),alternate_drugs);				
						}
						else{
							alternate_drugs = new ArrayList();
							if(recordSet.containsKey("alt_drug_code_"+i)){	//1
								alternate_drugs.add(recordSet.get("alt_drug_code_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}
								
							if(recordSet.containsKey("main_drug_code_"+i)){	//2
								alternate_drugs.add(recordSet.get("main_drug_code_"+i));				
							}else{
								alternate_drugs.add("");				
							}
							if(recordSet.containsKey("alt_dosage_seq_no_"+i)){ //3
								alternate_drugs.add(recordSet.get("alt_dosage_seq_no_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}
							if(recordSet.containsKey("alt_item_code_"+i)){ //4
								alternate_drugs.add(recordSet.get("alt_item_code_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}
							if(recordSet.containsKey("alt_order_id_"+i)){ //5
								alternate_drugs.add(recordSet.get("alt_order_id_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}
							if(recordSet.containsKey("alt_order_line_no_"+i)){ //6
								alternate_drugs.add(recordSet.get("alt_order_line_no_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}
							if(recordSet.containsKey("alt_admin_qty_"+i)){ //7
								alternate_drugs.add(recordSet.get("alt_admin_qty_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_admin_qty_uom_"+i)){ //8
								uom = (String)recordSet.get("alt_admin_qty_uom_"+i);
								if(uom.length()>4){
									uom=uom.substring(0,3);
								}
								alternate_drugs.add(uom);	
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_schedule_date_time_"+i)){		 //9		// SCHEDULED DATE/TIME
								str_date = (String)recordSet.get("alt_schedule_date_time_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
								alternate_drugs.add(str_date);				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_time_"+i)){	//10		// ADMINISTERED DATE/TIME
								str_date = (String)recordSet.get("alt_time_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
								alternate_drugs.add(str_date);				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_batch_id_"+i)){ //11
								alternate_drugs.add(recordSet.get("alt_batch_id_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_expiry_date_"+i)){ //12
								str_date = (String)recordSet.get("alt_expiry_date_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY",locale,"en");
								alternate_drugs.add(str_date);				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_trade_id_"+i)){ //13
								alternate_drugs.add(recordSet.get("alt_trade_id_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}
							
							remarks = getRemarksForDrug((String)recordSet.get("alt_drug_code_"+i),i+"");
							if(remarks==null){
								remarks = new ArrayList();
								remarks.add(""); 
								remarks.add(""); 
								remarks.add(""); 
								remarks.add(""); 
								remarks.add(""); 
								remarks.add(""); 
								remarks.add(""); 
							}
							if(recordSet.containsKey("alt_chk_"+i)){
								if(((String)recordSet.get("alt_chk_"+i)).equals("E")){
									alternate_drugs.add("Y");	//14		// ADMINISTERED_YN
									alternate_drugs.add("Y");	//15		// ADMIN_RECORDED_YN
									alternate_drugs.add((String)remarks.get(1));	//16	// ADMIN_REMARKS
									alternate_drugs.add("");	//17		// NON_ADMIN_REMARKS
									
								}
								else{
									alternate_drugs.add("N");				// ADMINISTERED_YN
									alternate_drugs.add("Y");				// ADMIN_RECORDED_YN
									alternate_drugs.add("");				// ADMIN_REMARKS
									alternate_drugs.add((String)remarks.get(1));			// NON_ADMIN_REMARKS
								}
							}
							alternate_drugs.add((String)remarks.get(0));	//18		// REASON_CODE	
							alternate_drugs.add((String)remarks.get(2));	//19		// ADMIN_BY	
							alternate_drugs.add((String)remarks.get(3));	//20		// AUTHORISED_BY	
							if(recordSet.containsKey("alt_store_code_"+i)){ //21
								alternate_drugs.add(recordSet.get("alt_store_code_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_bin_code_"+i)){ //22
									alternate_drugs.add(recordSet.get("alt_bin_code_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_trade_name_"+i)){ //23
								alternate_drugs.add(recordSet.get("alt_trade_name_"+i));				
							}
							else{
								alternate_drugs.add("");				
							}

							if(recordSet.containsKey("alt_end_date_"+i)){ //24
								str_date = (String)recordSet.get("alt_end_date_"+i);
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
								alternate_drugs.add(str_date);				
							}
							else{
								alternate_drugs.add("");				
							}
							if(recordSet.containsKey("order_pract_id_"+i)){ //25 
								alternate_drugs.add(recordSet.get("order_pract_id_"+i));
							}
							else{
								alternate_drugs.add("");
							}
							/*if(recordSet.containsKey("adminByType")){ //26 index 25
								alternate_drugs.add((String)recordSet.get("adminByType"));
							}
							else{
								alternate_drugs.add("U");
							}
							if(recordSet.containsKey("selfAdminBy")){
								non_iv_drugs.add(recordSet.get("selfAdminBy"));//26
							}
							else{
								non_iv_drugs.add("");//26
							}
							*/
							if(recordSet.containsKey("alt_shared_drug_"+i)){//Added for HSA-CRF-0090--start
								alternate_drugs.add(recordSet.get("alt_shared_drug_"+i));				
							}
							else{
								alternate_drugs.add("N");				
							}//Added for HSA-CRF-0090--end
							alt_drug_details.put((String)recordSet.get("main_drug_code_"+i),alternate_drugs);
						}
					}
				}
			}		
				
			if(iv_records>0){
				String iv_remarks_1	=	"";
				String iv_remarks_2	=	"";
				String iv_remarks_3	=	"";
				String iv_remarks_4	=	"";
				String iv_remarks_5	=   "";
				String iv_remarks_6	=	"";
				//added for for IN24144 --12/10/2010-- priya
				String iv_remarks_0	=	"";
				String iv_remarks_7	=	"";
				String iv_remarks_8	=	"";
				String	prev_order_id = "";
				String	prev_seq_no = "";
				String	prev_str_date = "";
				for (int i=0;i<=iv_records ;i++ ){// index changed from 1  to 0 for AAKH-CRF-0024 [IN:038260]
					iv_remarks_6	=	"";
					if(recordSet.get("chk_iv_select_"+i) != null && !((String)recordSet.get("chk_iv_select_"+i)).equals("")  ){
						if(recordSet.containsKey("iv_dosage_seq_no_"+i)){
							iv_drugs.add(recordSet.get("iv_dosage_seq_no_"+i));		//1		
						}
						else{
							iv_drugs.add("");				
						}
						if(recordSet.containsKey("iv_drug_code_"+i)){
							iv_drugs.add(recordSet.get("iv_drug_code_"+i));		//2		
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("iv_item_code_"+i)){
							iv_drugs.add(recordSet.get("iv_item_code_"+i));		 //3		
						}
						else{
							iv_drugs.add("");				
						}
						
						if(recordSet.containsKey("iv_order_id_"+i)){
							iv_drugs.add(recordSet.get("iv_order_id_"+i));		//4		
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("iv_order_line_no_"+i)){
							iv_drugs.add(recordSet.get("iv_order_line_no_"+i));			//5
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("iv_admin_qty_"+i)){
							iv_drugs.add(recordSet.get("iv_admin_qty_"+i));				//6
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("iv_infusion_st_time_"+i)){
//the below if condition and prev_xxx vars were added for issue 24380 so that drug's inf start dateTime wil be same as that of fluid's
//condition ((String)recordSet.get("iv_order_line_no_"+i)).equals("2") changed to !((String)recordSet.get("iv_order_line_no_"+i)).equals("1") for issue 25959 : 18 jan 2011
							
							if(((String)recordSet.get("iv_order_id_"+i)).equals(prev_order_id) && !((String)recordSet.get("iv_order_line_no_"+i)).equals("1") && ((String)recordSet.get("iv_dosage_seq_no_"+i)).equals(prev_seq_no)){
								str_date = prev_str_date;
								if(!locale.equals("en"))  // if block added for LEAP-INT-PH-SCF-14965 [IN:004059]					// added for LEAP-INT-PH-SCF-14965
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
							}
							else{
								prev_order_id = (String)recordSet.get("iv_order_id_"+i);
								prev_seq_no = (String)recordSet.get("iv_dosage_seq_no_"+i);
								prev_str_date = (String)recordSet.get("iv_infusion_st_time_"+i);
								str_date = prev_str_date;
								if(!locale.equals("en"))
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
							}
							iv_drugs.add(str_date);				//7
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("iv_flow_rate_"+i)){
							iv_drugs.add(recordSet.get("iv_flow_rate_"+i));			//8	
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("sch_infusion_vol_str_unit_"+i)){
							iv_drugs.add(recordSet.get("sch_infusion_vol_str_unit_"+i));			//9	
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("sch_infusion_per_unit_"+i)){
							iv_drugs.add(recordSet.get("sch_infusion_per_unit_"+i));				//10
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("iv_infusion_period_"+i)){
							iv_drugs.add(recordSet.get("iv_infusion_period_"+i));				 //11
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("sch_infusion_period_unit_"+i)){
							String sch_infusion_period_unit = (String)recordSet.get("sch_infusion_period_unit_"+i);													
							iv_drugs.add(sch_infusion_period_unit);			//12					
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("iv_batch_id_"+i)){
							iv_drugs.add(recordSet.get("iv_batch_id_"+i));	 //13			
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("iv_expiry_date_"+i)){
							str_date = (String)recordSet.get("iv_expiry_date_"+i);
							if(!locale.equals("en"))
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY",locale,"en");
							iv_drugs.add(str_date);				//14
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("iv_trade_id_"+i)){
							iv_drugs.add(recordSet.get("iv_trade_id_"+i));		//15		
						}
						else{
							iv_drugs.add("");				
						}

						remarks = getRemarksForDrug((String)recordSet.get("iv_drug_code_"+i),i+"");
						if(remarks==null){
							remarks = new ArrayList();
							remarks.add("");
							remarks.add("");
							remarks.add("");
							remarks.add("");
							remarks.add("");
							remarks.add("");
							remarks.add("");
						}
						if(!recordSet.containsKey("iv_chk_complete_"+i)){

							iv_drugs.add(iv_remarks_1);			// ADMIN_REMARKS      //16
							iv_drugs.add(iv_remarks_2);			// NON_ADMIN_REMARKS  //17
							iv_drugs.add(iv_remarks_3);			// ADMINISTERED_YN    //18
							iv_drugs.add(iv_remarks_4);			// ADMIN_RECORDED_YN  //19
							iv_drugs.add(iv_remarks_6);				// ADMIN_DOSE_CHNG_REASON_CODE //20
						}
						else{
							if(recordSet.containsKey("iv_chk_complete_"+i)){
								if(((String)recordSet.get("iv_chk_complete_"+i)).equals("E")){
									iv_remarks_1	= (String)remarks.get(1);
									iv_remarks_2	= "";
									iv_remarks_3	= "Y";
									iv_remarks_4	= "Y";
									iv_remarks_5    = (String)remarks.get(4);
									iv_remarks_6	= (String) remarks.get(5);
								
									iv_remarks_0	= (String)remarks.get(0);//added for for IN24144 --12/10/2010-- priya
									iv_remarks_7    = (String)remarks.get(2);
									iv_remarks_8	= (String) remarks.get(3);

									iv_drugs.add(iv_remarks_1);			    // ADMIN_REMARKS    //16
									iv_drugs.add(iv_remarks_2);				// NON_ADMIN_REMARKS//17
									iv_drugs.add(iv_remarks_3);				// ADMINISTERED_YN  //18
									iv_drugs.add(iv_remarks_4);				// ADMIN_RECORDED_YN//19								
									iv_drugs.add(iv_remarks_6);				// ADMIN_DOSE_CHNG_REASON_CODE	//20		
								}
								else{
									iv_remarks_1	= "";
									iv_remarks_2	= (String)remarks.get(1);
									iv_remarks_3	= "N";
									iv_remarks_4	= "Y";
									iv_remarks_5    = (String)remarks.get(4);
									iv_remarks_6	= (String) remarks.get(5);
							//added for for IN24144 --12/10/2010-- priya
									iv_remarks_0	= (String)remarks.get(0);
									iv_remarks_7    = (String)remarks.get(2);
									iv_remarks_8	= (String) remarks.get(3);
									iv_drugs.add(iv_remarks_1);				// ADMIN_REMARKS     //16
									iv_drugs.add(iv_remarks_2);			// NON_ADMIN_REMARKS     //17
									iv_drugs.add(iv_remarks_3);				// ADMINISTERED_YN   //18
									iv_drugs.add(iv_remarks_4);				// ADMIN_RECORDED_YN //19	
									iv_drugs.add(iv_remarks_6);				// ADMIN_DOSE_CHNG_REASON_CODE	//20	
								}
							}
						}
						if(recordSet.containsKey("iv_admin_date_time_"+i)){
							str_date = (String)recordSet.get("iv_admin_date_time_"+i);
							if(!locale.equals("en"))
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
							iv_drugs.add(str_date);    //21
						}
						else{
							iv_drugs.add("");
						}
						if(recordSet.containsKey("iv_qty_uom_"+i)){
							iv_drugs.add(recordSet.get("iv_qty_uom_"+i));  //22
						}
						else{
							iv_drugs.add("");
						}

			//			iv_drugs.add((String)remarks.get(0));				// REASON_CODE	  //23
				//		iv_drugs.add((String)remarks.get(2));				// ADMIN_BY	      //24
				//		iv_drugs.add((String)remarks.get(3));				// AUTHORISED_BY  //25	
//Replaced the above lines with below lines for IN24144 --12/10/2010-- priya (Reason for IV ingredient was going s null)
						iv_drugs.add(iv_remarks_0);				// REASON_CODE	  //23
						iv_drugs.add(iv_remarks_7);				// ADMIN_BY	      //24
						iv_drugs.add(iv_remarks_8);				// AUTHORISED_BY  //25
						
						if(recordSet.containsKey("iv_store_code_"+i)){
							iv_drugs.add(recordSet.get("iv_store_code_"+i));	//26			
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("iv_bin_code_"+i)){
							iv_drugs.add(recordSet.get("iv_bin_code_"+i));		//27		
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("iv_trade_name_"+i)){
							iv_drugs.add(recordSet.get("iv_trade_name_"+i));	//28			
						}
						else{
							iv_drugs.add("");				
						}	
						// spr#5308-next scheduled time parameter sending as end date. so it is modified as follows
						/*if(recordSet.containsKey("iv_end_date_"+i)){
							str_date = (String)recordSet.get("iv_end_date_"+i);
							if(!locale.equals("en"))
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
							iv_drugs.add(str_date);				
						}
						else{
							iv_drugs.add("");				
						}*/
						if(recordSet.containsKey("next_schd_date_"+i)){
							str_date = (String)recordSet.get("next_schd_date_"+i);	
							iv_drugs.add(str_date);//29	//added for SCF-7528//Niji
							//if(!locale.equals("en"))
							//	iv_remarks_5 = com.ehis.util.DateUtils.convertDate(iv_remarks_5, "DMYHM",locale,"en");//replaced str_date to iv_remarks_5  for SCF-7528
							//str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en");
							//iv_drugs.add(str_date);	   //29
						}
						else{
							iv_drugs.add("");				
						}
						iv_drugs.add(iv_remarks_5);// Next scheduled time 30
				
						//code added for batch_id to insert into ph_medn_admin_dtl
						if(recordSet.containsKey("previous_batch_id_"+i)){
							iv_drugs.add(recordSet.get("previous_batch_id_"+i));		//31		
						}
						else{
							iv_drugs.add("");				
						}

						if(recordSet.containsKey("previous_exp_date_"+i)){
							str_date = (String)recordSet.get("previous_exp_date_"+i);
							if(!locale.equals("en"))
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY",locale,"en");
							iv_drugs.add(str_date);				//32
						}
						else{
							iv_drugs.add("");				
						}
						if(recordSet.containsKey("previous_trade_id_"+i)){
							iv_drugs.add(recordSet.get("previous_trade_id_"+i));	//33			
						}
						else{
							iv_drugs.add("");				
						}
						if(recordSet.containsKey("IV_Newly_administerderd_"+i)){
							iv_drugs.add(recordSet.get("IV_Newly_administerderd_"+i));		//34		
						}
						else{
							iv_drugs.add("");				
						}
						if(recordSet.containsKey("iv_link_vaccine_code_"+i)){								
							iv_drugs.add(recordSet.get("iv_link_vaccine_code_"+i));//35																				
						}
						else{
							iv_drugs.add("");//35				
						}
						if(recordSet.containsKey("iv_modified_date_time_"+i)){
							iv_drugs.add(recordSet.get("iv_modified_date_time_"+i));//36
						}
						else{
							iv_drugs.add("");//36	
						}
						if(recordSet.containsKey("iv_Auto_Admin_"+i)){
							iv_drugs.add(recordSet.get("iv_Auto_Admin_"+i));//37
						}
						else{
							iv_drugs.add("");//37	
						}
						if(recordSet.containsKey("iv_order_pract_id_"+i)){
								iv_drugs.add(recordSet.get("iv_order_pract_id_"+i));//38
							}
							else{
								iv_drugs.add("");//38	
							}
						if(recordSet.containsKey("could_not_administer_"+i)){ //Added for AAKH-CRF-0024 [IN:038260] 
							iv_drugs.add(recordSet.get("could_not_administer_"+i));//38
						}
						else{
							iv_drugs.add("");//38	
						}
						if(recordSet.containsKey("iv_shared_drug_"+i)){//Added for HSA-CRF-0090--start
							iv_drugs.add(recordSet.get("iv_shared_drug_"+i));		//40		
						}
						else{
							iv_drugs.add("N");				//40
						}//Added for HSA-CRF-0090--end
						iv_drugs.add(checkForNull((String)recordSet.get("iv_dispense_drug_code_"+i)));	//41
						if(recordSet.containsKey("sch_dosage_uom_code_"+i)){//added for SKR-SCF-1240
							iv_drugs.add(recordSet.get("sch_dosage_uom_code_"+i));		//42		
						}
						else{
							iv_drugs.add("");				//42
						}
					}
				}
			}
			result.put("NON_IV_DRUGS",non_iv_drugs);
			result.put("ALTERNATE_DRUGS",alt_drug_details);
			result.put("NEW_NON_IV_DRUGS",newly_added_non_iv_drugs);
			result.put("IV_DRUGS",iv_drugs);
			result.put("COMMON_VALUES",commonValues);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList formDispensingDetails1(ArrayList non_iv,ArrayList iv,HashMap alt_non_iv) throws Exception {

		ArrayList dispensing_details = new ArrayList();
		String str_date="";
		locale = getLanguageId();
		
		if(non_iv!=null && non_iv.size()>0){
            ArrayList batch_dtls = new ArrayList();
			for (int i=0;i<non_iv.size() ;i=i+27 ){ 

				dispensing_details.add((String)non_iv.get(i+14));		// ORDER_ID
				dispensing_details.add((String)non_iv.get(i+15));		// ORDER_LINE_NO
				dispensing_details.add((String)non_iv.get(i));			// PRES_DRUG_CODE
				dispensing_details.add((String)non_iv.get(i+19));		// STORE_CODE
				dispensing_details.add((String)non_iv.get(i));			// DISP_DRUG_CODE
				dispensing_details.add((String)non_iv.get(i+8));		// DISP_QTY
				dispensing_details.add((String)non_iv.get(i+13));		// DISP_UOM_CODE
				batch_dtls = new ArrayList();
				batch_dtls.add((String)non_iv.get(i));		// drug_code
				batch_dtls.add((String)non_iv.get(i+9));	// batch_id

				str_date = (String)non_iv.get(i+10);	// expiry_date
				if(!locale.equals("en"))
					str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
				batch_dtls.add(str_date);

				batch_dtls.add((String)non_iv.get(i+8));	// disp_qty
				batch_dtls.add((String)non_iv.get(i+13));	// disp_qty_uom
				batch_dtls.add((String)non_iv.get(i+11));	// trade_id
				batch_dtls.add((String)non_iv.get(i+20));	// bin_locn_code
				batch_dtls.add(getItemCost((String)non_iv.get(i),(String)non_iv.get(i+19),(String)non_iv.get(i+8),(String)non_iv.get(i+22)));							// item_cost
				dispensing_details.add(batch_dtls);
			}
		}
        
		if(iv!=null && iv.size()>0){
	
			ArrayList batch_dtls =null;
			for (int i=0;i<iv.size() ;i=i+39 ){		
				batch_dtls = new ArrayList();
				dispensing_details.add((String)iv.get(i+3));		// ORDER_ID       
				dispensing_details.add((String)iv.get(i+4));		// ORDER_LINE_NO  
				dispensing_details.add((String)iv.get(i+1));		// PRES_DRUG_CODE 
				dispensing_details.add((String)iv.get(i+24));		// STORE_CODE     
				dispensing_details.add((String)iv.get(i+1));		// DISP_DRUG_CODE 
				dispensing_details.add((String)iv.get(i+5));		// DISP_QTY       
				dispensing_details.add((String)iv.get(i+20));		// DISP_UOM_CODE 
				batch_dtls.add((String)iv.get(i+1));	// drug_code
				batch_dtls.add((String)iv.get(i+12));	// batch_id

				str_date = (String)iv.get(i+13);	// expiry_date
				if(!locale.equals("en"))
					str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
				batch_dtls.add(str_date);

				//batch_dtls.add((String)iv.get(i+13));	// expiry_date
				batch_dtls.add((String)iv.get(i+5));	// disp_qty
				batch_dtls.add((String)iv.get(i+20));	// disp_qty_uom
				batch_dtls.add((String)iv.get(i+14));	// trade_id
				batch_dtls.add((String)iv.get(i+25));	// bin_locn_code
				batch_dtls.add(getItemCost((String)iv.get(i+1),(String)iv.get(i+24),(String)iv.get(i+5),(String)iv.get(i+27)));							// item_cost
				dispensing_details.add(batch_dtls);			
			}
		}
		return dispensing_details;
	}
	
	public ArrayList formDispensingDetails(ArrayList non_iv,ArrayList iv,HashMap alt_non_iv) throws Exception {
	
		ArrayList dispensing_details = new ArrayList();
		ArrayList DISP_QTY = new ArrayList();
		String Newly_Administered	="";
		String prev_order_id		="";
		String prev_order_id1		="";
		String prev_order_line_no	="";
		String prev_seq_no			="";//Added for Internal Issue.
		String batch_id				="";
		String prescribeMode		="";
		HashMap pressMode1			=new HashMap();
		String str_date="";
		locale = getLanguageId();

		int jj						=1;
		int temp					=0;
		int tmp_no					=1;
		float temp1					=0.0f;
		String non_iv_admin_qty		="";
		String freq_nature			="";
		String admin_id,  admin_yn; // auth_id, Removed for IN063877
		pressMode1=getPresMode();
		
		if(non_iv!=null && non_iv.size()>0){
			ArrayList batch_dtls = new ArrayList();
			for (int i=0;i<non_iv.size() ;i=i+50 ){//Changed 45 to 46 //Replcaed 44 with 45 for HSA-CRF-0090 //code 'i=i+43' is replaced by i=i+44 for CRF-PH- RUT-CRF-0088[IN043881] // 46 Cannged to 48 for GHL-CRF-0482 
				Newly_Administered=(String)non_iv.get(i+26);
				if(((String)non_iv.get(i+34)).equals("Y"))
					Newly_Administered="NO"; //if patient_brought_medication is yes
				if(Newly_Administered==null) 
					Newly_Administered="";
				if(Newly_Administered.equals("NONIV_Y")){
					freq_nature=getFrequencyNature(((String)non_iv.get(i+14)).trim(),((String)non_iv.get(i+15)).trim());
					non_iv_admin_qty=(String)non_iv.get(i+8);
					if(freq_nature!=null && freq_nature.equals("P")){
						if(non_iv_admin_qty!=null && !non_iv_admin_qty.equals(""))
							non_iv_admin_qty=(int)Math.ceil(Float.parseFloat(non_iv_admin_qty))+"";	
					}
					batch_id=non_iv.get(i+9)==null?"":(String)non_iv.get(i+9);
					admin_yn=non_iv.get(i+4)==null?"":(String)non_iv.get(i+4);
					if(!batch_id.equals("") && admin_yn.equals("Y")){							
						if(!prev_order_id.equals(((String)non_iv.get(i+14)).trim()))
							jj	=	1;
						prev_order_id=(String)non_iv.get(i+14);						
						tmp_no			=	(jj++);					
						if(!prev_order_id1.equals(((String)non_iv.get(i+14)).trim()) || !prev_order_line_no.equals(((String)non_iv.get(i+15)).trim()) || !prev_seq_no.equals(((String)non_iv.get(i+1)).trim())){//Added !prev_seq_no.equals(((String)non_iv.get(i+1) for Internal Issue.							
							prev_order_id1		=	((String)non_iv.get(i+14)).trim();
							prev_order_line_no	=	((String)non_iv.get(i+15)).trim();
							prev_seq_no 		= ((String)non_iv.get(i+1)).trim();//Added for Internal Issue.
							prescribeMode=(String)pressMode1.get(prev_order_id1+prev_order_line_no);
							if(prescribeMode==null) 
								prescribeMode="";
							if(prescribeMode==null || prescribeMode.equals(""))
								prescribeMode = getDosageType((String)non_iv.get(i+14),(String)non_iv.get(i+15));
							if((this.IVType((String)non_iv.get(i+14))).equals("7")){
								DISP_QTY= getTPNQtyUOM((String)non_iv.get(i),non_iv_admin_qty);
							}
							else{
								DISP_QTY=getQtyUOM((String)non_iv.get(i+45),non_iv_admin_qty,(String)non_iv.get(i+13),prescribeMode,(String)non_iv.get(i+14),(String)non_iv.get(i+15)); // changed from non_iv.get(i) to non_iv.get(i+45) for ML-BRU-SCF-1594
							}																												
							dispensing_details.add((String)non_iv.get(i+14));		// ORDER_ID
							dispensing_details.add((String)non_iv.get(i+15));		// ORDER_LINE_NO
							dispensing_details.add((String)non_iv.get(i));			// PRES_DRUG_CODE
							dispensing_details.add((String)non_iv.get(i+45));			// DISP_DRUG_CODE//Changed i+45 for Bru-HIMS-CRF-399 [IN:043767]
							dispensing_details.add((String)DISP_QTY.get(0));		// DISP_QTY
							dispensing_details.add((String)DISP_QTY.get(1));		// DISP_UOM_CODE
							dispensing_details.add((String)non_iv.get(i+19));			// store_code
							batch_dtls = new ArrayList();
							batch_dtls.add((String)non_iv.get(i+45));		// drug_code // Changed as DISP_DRUG_CODE for Bru-HIMS-CRF-399 [IN:043767]
							batch_dtls.add((String)non_iv.get(i+9));	// batch_id
							str_date = (String)non_iv.get(i+10);	// expiry_date
							if(!locale.equals("en"))
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
							batch_dtls.add(str_date);
							//batch_dtls.add((String)non_iv.get(i+10));	// expiry_date
							batch_dtls.add((String)DISP_QTY.get(0));		// disp_qty
							batch_dtls.add((String)DISP_QTY.get(1));		// disp_qty_uom
							batch_dtls.add("");
							batch_dtls.add((String)non_iv.get(i+11));	// trade_id
							batch_dtls.add((String)non_iv.get(i+20));	// bin_locn_code
							batch_dtls.add(getItemCost((String)non_iv.get(i),(String)non_iv.get(i+19),non_iv_admin_qty,(String)non_iv.get(i+22)));	// item_cost
							if(!stock_srl.containsKey(((String)non_iv.get(i+14)).trim()+((String)non_iv.get(i+15)).trim()))
								stock_srl.put((String)non_iv.get(i+14)+(String)non_iv.get(i+15),tmp_no+"");							
							batch_dtls.add((String)non_iv.get(i+44));//Added for HSA-CRF-0090
							dispensing_details.add(batch_dtls);
							dispensing_details.add((String)non_iv.get(i+34));
							dispensing_details.add((String)non_iv.get(i+40)); //ord_pract_id //Added for [IN:040149] -start
							if(getAuthUserID()==null || getAuthUserID().equals(""))
								admin_id=(String)non_iv.get(i+17);	//Admin id
							else
								admin_id = getAuthUserID();	//Admin id
							dispensing_details.add(getPractId(admin_id));	//Admin id
							//auth_id = (String)non_iv.get(i+18);
							dispensing_details.add((String)non_iv.get(i+18));//Authorized id //Added for [IN:040149] -End
						}
						else{
							prescribeMode=(String)pressMode1.get(prev_order_id1+prev_order_line_no);
							if(prescribeMode==null) 
								prescribeMode="";								
							if((this.IVType(prev_order_id)).equals("7")){
                                DISP_QTY=getTPNQtyUOM((String)non_iv.get(i),non_iv_admin_qty);
							}
							else{								        
								DISP_QTY=getQtyUOM((String)non_iv.get(i),non_iv_admin_qty,(String)non_iv.get(i+13),prescribeMode,prev_order_id1,prev_order_line_no);
							}														
							temp=Integer.parseInt((String)dispensing_details.get(dispensing_details.indexOf(prev_order_line_no)+3))+Integer.parseInt((String)DISP_QTY.get(0));
							dispensing_details.set(dispensing_details.indexOf(prev_order_line_no)+3,temp+"");
							batch_dtls.set(3,temp+"");								
							temp1=Float.parseFloat(getItemCost((String)non_iv.get(i),(String)non_iv.get(i+19),non_iv_admin_qty,(String)non_iv.get(i+22)));
							temp1=Float.parseFloat((String)batch_dtls.get(8))+temp1;
							batch_dtls.set(8,temp1+"");
							dispensing_details.set(dispensing_details.indexOf(prev_order_line_no)+6,batch_dtls);//5
						}												
					}
				}
			}
		}
		
		if(iv!=null && iv.size()>0){
			ArrayList batch_dtls = new ArrayList();
			for (int i=0;i<iv.size() ;i=i+42){//Replcaed 39 with 40 for HSA-CRF-0090//size increase from 38 to 39 for AAKH-CRF-0024 [IN:038260]
			//for (int i=0;i<iv.size() ;i=i+34 ){
				Newly_Administered=(String)iv.get(i+33);//c
				if(Newly_Administered==null)
					Newly_Administered="";
				if(Newly_Administered.equals("IV_Y")){
					batch_id=(String)iv.get(i+12);
					if(batch_id == null || batch_id == "" ) 
						batch_id="";
					admin_yn=iv.get(i+16)==null?"":(String)iv.get(i+16);
					if(!batch_id.equals("")&& admin_yn.equals("Y")){
						if(!prev_order_id.equals(((String)iv.get(i+3)).trim()))
							jj	=	1;
						tmp_no				=	(jj++);
						prev_order_id=(String)iv.get(i+3);
						if(!prev_order_id1.equals(((String)iv.get(i+3)).trim()) || !prev_order_line_no.equals(((String)iv.get(i+4)).trim())){
							prev_order_id1		=	((String)iv.get(i+3)).trim();
							prev_order_line_no	=	((String)iv.get(i+4)).trim();
							//prev_drug_code		=	((String)iv.get(i+1)).trim();
							prescribeMode=(String)pressMode1.get(prev_order_id1+prev_order_line_no);
							if(prescribeMode==null) 
								prescribeMode="";	
							//DISP_QTY=getQtyUOM((String)iv.get(i+1),(String)iv.get(i+5),(String)iv.get(i+20),prescribeMode);
							DISP_QTY=getQtyUOM((String)iv.get(i+1),(String)iv.get(i+5),(String)iv.get(i+8),prescribeMode,(String)iv.get(i+3),(String)iv.get(i+4));
							
							dispensing_details.add((String)iv.get(i+3));		// ORDER_ID       
							dispensing_details.add((String)iv.get(i+4));		// ORDER_LINE_NO  
							dispensing_details.add((String)iv.get(i+1));		// PRES_DRUG_CODE 

							dispensing_details.add((String)iv.get(i+1));		// DISP_DRUG_CODE 
							dispensing_details.add((String)DISP_QTY.get(0));		// DISP_QTY
							dispensing_details.add((String)DISP_QTY.get(1));		// DISP_UOM_CODE
							dispensing_details.add((String)iv.get(25));		// DISP_UOM_CODE    //c

							batch_dtls = new ArrayList();
							batch_dtls.add((String)iv.get(i+1));	// drug_code
							batch_dtls.add((String)iv.get(i+12));	// batch_id

							str_date = (String)iv.get(i+13);	// expiry_date
							if(!locale.equals("en"))
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
							batch_dtls.add(str_date);

							//batch_dtls.add((String)iv.get(i+13));	// expiry_date
							batch_dtls.add((String)DISP_QTY.get(0));		// disp_qty
							batch_dtls.add((String)DISP_QTY.get(1));		// disp_qty_uom
							batch_dtls.add("");
							batch_dtls.add((String)iv.get(i+14));	// trade_id
							batch_dtls.add((String)iv.get(i+26));	// bin_locn_code	//c
							batch_dtls.add(getItemCost((String)iv.get(i+1),(String)iv.get(i+25),(String)iv.get(i+5),(String)iv.get(i+28)));// item_cost	//c
							batch_dtls.add((String)iv.get(i+39));//Added for HSA-CRF-0090
							dispensing_details.add(batch_dtls);		
							if(stock_srl.containsKey(((String)iv.get(i+3)).trim()+((String)iv.get(i+4)).trim())){
							}
							else
								stock_srl.put((String)iv.get(i+3)+(String)iv.get(i+4),tmp_no+"");
							dispensing_details.add("N");//patientBroughtMediationYN
							dispensing_details.add((String)iv.get(37)); //ord_pract_id //Added for [IN:040149] -Start
							if(getAuthUserID()==null || getAuthUserID().equals(""))
								admin_id=(String)iv.get(i+17);	//Admin id
							else
								admin_id = getAuthUserID();	//Admin id
							dispensing_details.add(getPractId(admin_id));	//Admin id
							//auth_id = (String)iv.get(i+18);
							dispensing_details.add((String)iv.get(i+18));//Authorized id //Added for [IN:040149] - end
						}
						else {
							prescribeMode=(String)pressMode1.get(prev_order_id1+prev_order_line_no);
							if(prescribeMode==null) 
								prescribeMode="";	
							DISP_QTY=getQtyUOM((String)iv.get(i+1),(String)iv.get(i+5),(String)iv.get(i+21),prescribeMode,prev_order_id1,prev_order_line_no); //c
							
							temp=Integer.parseInt((String)dispensing_details.get(dispensing_details.indexOf(prev_order_line_no)+3))+Integer.parseInt((String)DISP_QTY.get(0));
							dispensing_details.set(dispensing_details.indexOf(prev_order_line_no)+3,temp+"");
							batch_dtls.set(3,temp+"");
							temp1=Float.parseFloat(getItemCost((String)iv.get(i+1),(String)iv.get(i+25),(String)iv.get(i+5),(String)iv.get(i+28)));	//c
							temp1=Float.parseFloat((String)batch_dtls.get(8))+temp1;
							batch_dtls.set(8,temp1+"");	
							dispensing_details.set(dispensing_details.indexOf(prev_order_line_no)+6,batch_dtls); //5
						}	
					}
				}
			}
		}
		return dispensing_details;
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
			cstmt.registerOutParameter(19 , Types.VARCHAR );
			cstmt.execute() ;

			item_cost	=	(String)(cstmt.getString(10));
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection ); 
		}	
		return item_cost;
	}

	public ArrayList getAllBatchIDS(String order_id,String order_line_no,String administred_yn)throws Exception{
		if(order_id==null)order_id="";
		if(order_line_no==null)order_line_no="";
		ArrayList result = new ArrayList();
		Connection connection = null ;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		PreparedStatement pstmt1 = null;
        ResultSet resultSet1 = null;
		locale = getLanguageId()==null?"en":getLanguageId();
		String str_date ="";
		String trade_id ="";
		String trade_name="";
		String barcode_id = "";
		String disp_drug_code = "";

		String mm_deflt_trade_id ="";
		String ward_ack_yn		 = "";//added for GHL-CRF-0458
		
		try {
			connection = getConnection() ;
			boolean barcode_2d_applicable = eCommon.Common.CommonBean.isSiteSpecific(connection, "ST","2D_BARCODE_APPLICABLE"); //added for MOHE-CRF-0167
		  //  pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT4")+"and ((b.DISP_QTY>b.RETURNED_QTY) OR (B.RETURNED_QTY IS NULL))" ) ;
			if(administred_yn.equals("N")){
				// pstmt = connection.prepareStatement( "SELECT DISTINCT a.BATCH_ID, to_char(a.EXPIRY_DATE,'dd/mm/yyyy') EXPIRY_DATE,d.trade_id,d.short_name  trade_name FROM ph_disp_hdr e,PH_DISP_DRUG_BATCH a,st_item_batch c, PH_DISP_DTL b,am_trade_name_lang_vw d WHERE e.disp_no=b.disp_no and e.DISP_TYPE!='M'and a.item_code=c.item_code AND a.store_code=c.store_code AND a.expiry_date=c.expiry_date_or_receipt_Date  AND a.batch_id=c.batch_id  AND a.facility_id=b.facility_id AND a.disp_no=b.disp_no AND a.srl_no=b.srl_no AND c.trade_id=d.trade_id(+) AND b.ORDER_ID=? AND b.ORDER_LINE_NO=? and d.language_id(+) =? and a.disp_qty<>NVL (a.returned_qty, 0)"+"and ((b.DISP_QTY>b.RETURNED_QTY) OR (B.RETURNED_QTY IS NULL))");
				pstmt = connection.prepareStatement( "SELECT DISTINCT a.BATCH_ID, to_char(a.EXPIRY_DATE,'dd/mm/yyyy') EXPIRY_DATE,d.trade_id,d.short_name trade_name,(SELECT barcode_id FROM st_sal_dtl_exp EXP WHERE EXP.doc_no = e.doc_no AND EXP.doc_srl_no = b.doc_srl_no AND EXP.item_code = a.item_code AND EXP.batch_id = a.batch_id AND EXP.expiry_date_or_receipt_date = a.expiry_date AND EXP.store_code = a.store_code AND EXP.bin_location_code = a.bin_location_code) barcode_id,B.DISP_DRUG_CODE disp_drug_code,D.MANUFACTURER_ID FROM ph_disp_hdr e,PH_DISP_DRUG_BATCH a, PH_DISP_DTL b,am_trade_name_lang_vw d WHERE e.disp_no=b.disp_no and e.DISP_TYPE!='M'  AND a.facility_id=b.facility_id AND a.disp_no=b.disp_no AND a.srl_no=b.srl_no AND a.trade_id=d.trade_id(+) AND b.ORDER_ID=? AND b.ORDER_LINE_NO=? AND e.order_id = b.order_id  and d.language_id(+) =? and a.disp_qty<>NVL (a.returned_qty, 0)"+"and ((b.DISP_QTY>b.RETURNED_QTY) OR (B.RETURNED_QTY IS NULL)) "); //Added AND e.order_id = b.order_id for KAUH10X Issue (No. 73) //removed a.ward_acknowledge Modified for MMS-MD-SCF-0179
			//(SELECT barcode_id FROM st_sal_dtl_exp EXP WHERE EXP.doc_no = e.doc_no AND EXP.item_code = a.item_code AND EXP.batch_id = a.batch_id AND EXP.expiry_date_or_receipt_date = a.expiry_date AND EXP.store_code = a.store_code AND EXP.bin_location_code = a.bin_location_code) barcode_id,B.DISP_DRUG_CODE disp_drug_code added for CRF-413.8
			//,a.WARD_ACKNOWLEDGE added for GHL-CRF-0458
			}
			else{
				// pstmt = connection.prepareStatement( "SELECT DISTINCT a.BATCH_ID, to_char(a.EXPIRY_DATE,'dd/mm/yyyy') EXPIRY_DATE,d.trade_id,d.short_name  trade_name FROM PH_DISP_DRUG_BATCH a,st_item_batch c, PH_DISP_DTL b,am_trade_name_lang_vw d WHERE  a.item_code=c.item_code AND a.store_code=c.store_code AND a.expiry_date=c.expiry_date_or_receipt_Date  AND a.batch_id=c.batch_id  AND a.facility_id=b.facility_id AND a.disp_no=b.disp_no AND a.srl_no=b.srl_no AND c.trade_id=d.trade_id(+) AND b.ORDER_ID=? AND b.ORDER_LINE_NO=? and d.language_id(+) =? and a.disp_qty<>NVL (a.returned_qty, 0)"+"and ((b.DISP_QTY>b.RETURNED_QTY) OR (B.RETURNED_QTY IS NULL))");
				pstmt = connection.prepareStatement( "SELECT DISTINCT a.BATCH_ID, to_char(a.EXPIRY_DATE,'dd/mm/yyyy') EXPIRY_DATE,d.trade_id,d.short_name  trade_name,(SELECT barcode_id FROM st_sal_dtl_exp EXP WHERE EXP.doc_no = e.doc_no AND EXP.doc_srl_no = b.doc_srl_no AND EXP.item_code = a.item_code AND EXP.batch_id = a.batch_id AND EXP.expiry_date_or_receipt_date = a.expiry_date AND EXP.store_code = a.store_code AND EXP.bin_location_code = a.bin_location_code) barcode_id,B.DISP_DRUG_CODE disp_drug_code,d.MANUFACTURER_ID FROM ph_disp_hdr e, PH_DISP_DRUG_BATCH a, PH_DISP_DTL b,am_trade_name_lang_vw d WHERE e.disp_no=b.disp_no and a.facility_id=b.facility_id AND a.disp_no=b.disp_no AND a.srl_no=b.srl_no AND a.trade_id=d.trade_id(+) AND b.ORDER_ID=? AND b.ORDER_LINE_NO=? AND e.order_id = b.order_id AND d.language_id(+) =? and a.disp_qty<>NVL (a.returned_qty, 0)"+"and ((b.DISP_QTY>b.RETURNED_QTY) OR (B.RETURNED_QTY IS NULL))");  //removed a.ward_acknowledge for MMS-MD-SCF-0179
				//(SELECT barcode_id FROM st_sal_dtl_exp EXP WHERE EXP.doc_no = e.doc_no AND EXP.item_code = a.item_code AND EXP.batch_id = a.batch_id AND EXP.expiry_date_or_receipt_date = a.expiry_date AND EXP.store_code = a.store_code AND EXP.bin_location_code = a.bin_location_code) barcode_id,B.DISP_DRUG_CODE disp_drug_code added for CRF-413.8
			//,a.WARD_ACKNOWLEDGE added for GHL-CRF-0458				
			}

            pstmt1 = connection.prepareStatement( "select DFLT_TRADE_ID from mm_parameter" ) ;
			resultSet1 = pstmt1.executeQuery();
			while ( resultSet1 != null && resultSet1.next() ) {
				mm_deflt_trade_id =resultSet1.getString("DFLT_TRADE_ID");
			}
			closeStatement( pstmt1 ) ;
			closeResultSet( resultSet1 ) ;
            
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no.trim());
			pstmt.setString(3,locale);
			resultSet = pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("BATCH_ID"));

				str_date = resultSet.getString("EXPIRY_DATE");	// expiry_date
				if(!locale.equals("en"))
					str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
				result.add(str_date);

				//result.add(resultSet.getString("EXPIRY_DATE"));

				 trade_id  = resultSet.getString("TRADE_ID");  
                 trade_name= resultSet.getString("TRADE_NAME"); 
				 disp_drug_code = resultSet.getString("disp_drug_code"); //added for CRF-413.8
				 barcode_id     = resultSet.getString("barcode_id"); //added for CRF-413.8
				 if(barcode_2d_applicable){//Adding start for MOHE-CRF-0167
					 String expiry_date =resultSet.getString("EXPIRY_DATE");
					 SimpleDateFormat inputFormat = new SimpleDateFormat("dd/mm/yyyy");
		             SimpleDateFormat outputFormat = new SimpleDateFormat("ddmmyyyy");
		             java.util.Date inputDate = inputFormat.parse(expiry_date); 
					 String temp_exp_date = outputFormat.format(inputDate);
					 barcode_id = "01"+ resultSet.getString("MANUFACTURER_ID")+"10"+resultSet.getString("BATCH_ID")+"[GS]17"+temp_exp_date;
				 }
				// ward_ack_yn	= resultSet.getString("WARD_ACKNOWLEDGE")==null?"N":resultSet.getString("WARD_ACKNOWLEDGE");  //Commented for MMS-MD-SCF-0179
			 	ward_ack_yn	=  getAcknowlegeforBarcodeYN(order_id,order_line_no,getIvprepYN()); //Added for MMS-MD-SCF-0179
				 if(trade_id==null||trade_id.equals("")){				

						trade_id  = mm_deflt_trade_id;
						trade_name=mm_deflt_trade_id;
				 }
				result.add(trade_id);
				result.add(trade_name);
				result.add(disp_drug_code);//added for CRF-413.8
				result.add(barcode_id);//added for CRF-413.8
				result.add(ward_ack_yn);//added for GHL-CRF-458
				result.add(order_id);//added for GHL-CRF-458
				result.add(order_line_no.trim());//added for GHL-CRF-458
				String details = str_date+"$"+trade_id+"$"+trade_name;
				batch_id_details.put(resultSet.getString("BATCH_ID"),details);
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
		return result;
	}

	public ArrayList getQtyUOM(String drug_code,String qty,String qtyUom,String prescribeMode,String order_id ,String order_line_no)throws Exception{
		if(drug_code==null)
			drug_code			=	"";
		if(qty==null)
			qty						=	"0";
		if(qtyUom==null)
			qtyUom				=	"";

		String STRENGTH_PER_PRES_UOM			=	"1";
		String STRENGTH_PER_VALUE_PRES_UOM		=	"1";
		String CONTENT_IN_PRES_BASE_UOM			=	"1";
		String STOCK_UOM						=	"";
		String STRENGTH_VALUE					=	"1";
		int Calc_qty							=	0;
		ArrayList result						=	new ArrayList();
		Connection connection					=	null ;
        PreparedStatement pstmt					=	null;
        ResultSet resultSet						=	null;
		String freq_nature						=	"";
		try {     
			connection = getConnection() ;
			pstmt = connection.prepareStatement("select freq_nature from am_frequency where freq_code =(select freq_code from or_order_line where order_id=? and order_line_num=?)");
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet = pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				freq_nature	=	resultSet.getString("freq_nature");
			}
			closeResultSet( resultSet ) ;
            closeStatement( pstmt ) ;

		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_STRENGTH_SELECT") ) ;
			pstmt.setString(1,drug_code);
			resultSet = pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				STRENGTH_VALUE=resultSet.getString("STRENGTH_VALUE")==null?"0":resultSet.getString("STRENGTH_VALUE");
				STRENGTH_PER_PRES_UOM=resultSet.getString("STRENGTH_PER_PRES_UOM")==null?"1":resultSet.getString("STRENGTH_PER_PRES_UOM");
				STRENGTH_PER_VALUE_PRES_UOM=resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null?"1":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM");
				CONTENT_IN_PRES_BASE_UOM=resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null?"1":resultSet.getString("CONTENT_IN_PRES_BASE_UOM");
				STOCK_UOM=resultSet.getString("STOCK_UOM");
			}
			closeResultSet( resultSet ) ;
            closeStatement( pstmt ) ;
			if(!freq_nature.equals("P")){
				if(!STRENGTH_VALUE.equals("0") && !prescribeMode.equals("Q") ){
					Calc_qty		=	(int)Math.ceil((Float.parseFloat(STRENGTH_PER_VALUE_PRES_UOM)*Float.parseFloat(qty)/Float.parseFloat(STRENGTH_PER_PRES_UOM))/Float.parseFloat(CONTENT_IN_PRES_BASE_UOM));
					qty				=	String.valueOf(Calc_qty);
					result.add(qty);
					result.add(STOCK_UOM);
				}
				else{
					if(!CONTENT_IN_PRES_BASE_UOM.equals("0")){
						Calc_qty	=	(int) Math.ceil(Float.parseFloat(qty)/Float.parseFloat(CONTENT_IN_PRES_BASE_UOM));
						qty			=	String.valueOf(Calc_qty);
					}
					result.add(qty);
					result.add(qtyUom); 
				}
			}
			else{
				result.add(qty);
				result.add(STOCK_UOM); // qtyUom changed to STOCK_UOM for ML-BRU-SCF-1726 [IN:064702]	
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
		return result;
	}

	public ArrayList getTPNQtyUOM(String drug_code,String qty)throws Exception{
		
		ArrayList result						=	new ArrayList();
		Connection connection					=	null ;
        PreparedStatement pstmt					=	null;
        ResultSet resultSet						=	null;
		try {     
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( "SELECT CEIL (?/TOTAL_VOLUME) DISP_QTY,SALE_UOM_CODE FROM PH_TPN_REGIMEN a ,ST_ITEM B WHERE A.TPN_REGIMEN_CODE =B.ITEM_CODE AND TPN_REGIMEN_CODE=?" ) ;
			
			pstmt.setString(1,qty);
			pstmt.setString(2,drug_code);
			resultSet = pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("DISP_QTY"));
			    result.add(resultSet.getString("SALE_UOM_CODE"));
			}
		}catch ( Exception e ) {
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
		return result;
	}

	public String  getStoreLocnCode(String order_id ) throws Exception{
		if(order_id==null)order_id="";
		String result = "";
		Connection connection = null ;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
//		String strItem="";
		try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ADMIN_OR_ORDER_SELECT") ) ;
			pstmt.setString(1,order_id.trim());
			resultSet = pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				result=resultSet.getString("PERFORMING_DEPTLOC_CODE");
				if(result==null)
					result="";
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
		return result;
	}

	public String  getStoreLocnnCode(String nursing_unit ) throws Exception{
		if(nursing_unit==null)nursing_unit="";
		String result = "";
		Connection connection = null ;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		String source_type="C";
			if(getPatientClass().equals("I")|| getPatientClass().equals("D") )
				source_type="N";
			else
				source_type="C";
//		String sql="select STORE_CODE FROM  PH_LOCN_FOR_STORE WHERE FACILITY_ID=? and LOCN_CODE=? AND EFF_STATUS ='E'";
		String sql="select a.store_code FROM  PH_LOCN_FOR_STORE a ,ph_disp_locn b WHERE a.STORE_CODE =b.disp_locn_code and b.EFF_STATUS='E' and a.FACILITY_ID=? and a.facility_id=b.facility_id and a.LOCN_CODE=? AND a.EFF_STATUS ='E'and a.locn_type=?";
		try {
			connection = getConnection() ;
		//    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ADMIN_OR_ORDER_SELECT") ) ;
			 pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,nursing_unit.trim());
			pstmt.setString(3,source_type);
			resultSet = pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				result=resultSet.getString("STORE_CODE");
				if(result==null)
					result="";
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

		return result;
	}

	public HashMap getAdminBatchID(String order_id,String order_line_num,String encounter_id,String sch_date_time,String ord_drug_code) throws Exception {

		Connection connection = null ;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
//		String strItem="";
		HashMap  admin_batch_id = new HashMap();
		String str_date = "";
		locale = getLanguageId();
		if(!locale.equals("en")){      // Added for RollForward from SRR - SRR20056-SCF-9369 [IN057079]
			sch_date_time = com.ehis.util.DateUtils.convertDate(sch_date_time, "DMYHM",locale,"en");
	    }
		try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_BATCH_SELECT4") ) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num.trim());
			pstmt.setString(3,ord_drug_code.trim());
			pstmt.setString(4,login_facility_id);
			pstmt.setString(5,encounter_id.trim());
			pstmt.setString(6,sch_date_time.trim());
			resultSet = pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				admin_batch_id.put("BATCH_ID",resultSet.getString("BATCH_ID"));
				admin_batch_id.put("DISP_BATCH_ID",resultSet.getString("DISP_BATCH_ID"));

				str_date = resultSet.getString("DISP_EXPIRY_DATE");	// expiry_date
				if(!locale.equals("en"))
					str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);

				admin_batch_id.put("DISP_EXPIRY_DATE",str_date);
				admin_batch_id.put("DISP_TRADE_ID", resultSet.getString("DISP_TRADE_ID"));
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
		return admin_batch_id;
	}

	public String validateForDirectAdmin(){
		String direct_admin = "";
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		try{
			connection = getConnection() ;
			String sql_query       = PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT11");
			pstmt			= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,login_facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				direct_admin = (String) resultSet.getString("ALLOW_MED_ADMIN_WO_ORD_YN");
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
		return direct_admin;
	}

	public String getBatchDetails(String batch_id){
		return (String)batch_id_details.get(batch_id);
	}

	public String getTradeNameForNewEntry(String encounter_id,String sch_date_time,String drug_code){
		String trade_name = "";
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT14")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,sch_date_time);
			pstmt.setString(4,drug_code);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				trade_name = resultSet.getString("TRADE_ID");
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
		return trade_name;
	}
	
	//SQL_PH_MED_ADMIN_REMARKS2
	//SQL_PH_MED_ADMIN_REMARKS3
	
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
		String drug_instructions        = "";
		String temp_drugremark_Label    = "";
		String temp_drugremark_desc     = "";
		PreparedStatement pstmt1		= null ;
		ResultSet resultSet1			= null ;
		locale = getLanguageId()==null?"en":getLanguageId();

		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_REMARKS3")) ;
			pstmt1			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_REMARKS4")) ;	
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				if(resultSet.getString("ORDER_LINE_FIELD_VALUE")!= null){
					temp_drugremark_desc = checkForNull(resultSet.getString("ORDER_LINE_FIELD_VALUE"));
					temp_drugremark_Label= checkForNull(resultSet.getString("ORDER_LINE_LABEL_TEXT"));
					pstmt1.setString(1,temp_drugremark_desc);
					pstmt1.setString(2,locale);
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
		return drug_instructions;
	}


	public String getFrequencyNature(String freq_code){
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;
		String freq_nature				= "";
		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT13")) ;
			pstmt.setString(1,freq_code);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
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
				es.printStackTrace() ;
			}
		}
		return freq_nature;
	}
	public String getFrequencyNature(String orderId,String orderLineNum){
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null; 
		String freq_nature		= "";
		try {     
			connection = getConnection() ;
			pstmt = connection.prepareStatement("select freq_nature from am_frequency where freq_code =(select freq_code from or_order_line where order_id=? and order_line_num=?)");
			pstmt.setString(1,orderId);
			pstmt.setString(2,orderLineNum);
			resultSet = pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				freq_nature	=	resultSet.getString("freq_nature");
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
		return freq_nature;
	}

	public String getPharmacistInstructions(String order_id,String order_line_no){
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;
		String pharmacist_instructions= "";
		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_REMARKS2")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				pharmacist_instructions = pharmacist_instructions + (checkForNull(resultSet.getString("ALLOCATE_TASK_FINDING"))+"\n");
				pharmacist_instructions = pharmacist_instructions + (checkForNull(resultSet.getString("FILL_TASK_FINDING"))+"\n");
				pharmacist_instructions = pharmacist_instructions + (checkForNull(resultSet.getString("DELIVERY_TASK_FINDING"))+"\n");
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
		return pharmacist_instructions;
	}
	
	public String getNoOfDoses(String order_id,String order_line_no){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		PreparedStatement pstmt1= null ;
		ResultSet resultSet		= null ;
		ResultSet resultSet1	= null ;
		String no_of_doses		= "1";
		int dose_unit=1;
		try{
			connection = getConnection() ;
			pstmt1			= connection.prepareStatement("SELECT INFUSE_OVER_UNIT from OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?") ;
			pstmt1.setString(1,order_id);
			pstmt1.setString(2,order_line_no);
			resultSet1	=	pstmt1.executeQuery();
			if(resultSet1!=null && resultSet1.next()){
				if(resultSet1.getString("INFUSE_OVER_UNIT") != null && (resultSet1.getString("INFUSE_OVER_UNIT").trim()).equals("M")){
					dose_unit=60;
				}
			}
					
			//pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT_DOSES")) ;
			//pstmt			= connection.prepareStatement("SELECT CEIL(TOT_INFUSION_OVER/INFUSE_OVER*?) NO_OF_DOSES FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?") ;
			
			pstmt			= connection.prepareStatement("SELECT CEIL(TOT_INFUSION_OVER/ORIG_INFUSE_OVER*?) NO_OF_DOSES FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?") ;

			pstmt.setInt(1,dose_unit);
			pstmt.setString(2,order_id);
			pstmt.setString(3,order_line_no);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				no_of_doses = checkForNull(resultSet.getString("NO_OF_DOSES"),"1");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1);
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return no_of_doses;
	}

	public HashMap getPRNDrugs(String patient_id,String encounter_id){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		HashMap prn_drugs		= new HashMap();
		locale = getLanguageId()==null?"en":getLanguageId();
		String str_date="";

		try{
			connection = getConnection() ;
			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_MEDN_ADMIN_PRN")) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,locale);
			resultSet			 = pstmt.executeQuery();
			ArrayList arr_result = new ArrayList(); 
			int index = 1;
			while(resultSet!=null && resultSet.next()){
				arr_result = new ArrayList();
				arr_result.add(resultSet.getString("ORDER_CATALOG_CODE"));
				arr_result.add(resultSet.getString("DRUG_DESC"));

				str_date = resultSet.getString("ORD_DATE_TIME");	
				if(!locale.equals("en"))
					str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);

				arr_result.add(str_date);
				arr_result.add(resultSet.getString("ADDED_BY_ID"));
				prn_drugs.put(index+"",arr_result);
				index++;
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
		return prn_drugs;
	}
	//added for SKR-SCF-1397
	public String getNoOfDoses(String order_id,String order_line_no,String iv_prep_yn,String drug_code){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		PreparedStatement pstmt1= null ;
		PreparedStatement pstmt2= null ;
		ResultSet resultSet		= null ;
		ResultSet resultSet1	= null ;

		ResultSet resultSet2	= null ;
		String no_of_doses		= "";
		String dose_value		= "";
		String content_in_pres_base_uom = "";
		String tot_infusion_over = "";
		String orig_infusion_over = "";
		int dose_unit=1;
		//float dur1 = 0.0f; //Commented for common-icn-0048
		//String duration_hr_min=""; //Commented for common-icn-0048
		String infution_over=""; 
		//String infusion_over_disp=""; //Commented for common-icn-0048
		//String infusion_over_hr_min=""; //Commented for common-icn-0048
		float duration	= 0.0f;
		float total_duration		= 0.0f;
		//float tot_qty =  0.0f; //Commented for common-icn-0048

		try{
			connection = getConnection() ;
			pstmt1			= connection.prepareStatement("SELECT INFUSE_OVER_UNIT from OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?") ;
			pstmt1.setString(1,order_id);
			pstmt1.setString(2,order_line_no);
			resultSet1	=	pstmt1.executeQuery();
			if(resultSet1!=null && resultSet1.next()) 
			{
				if(resultSet1.getString("INFUSE_OVER_UNIT") != null && (resultSet1.getString("INFUSE_OVER_UNIT").trim()).equals("M"))
				{
							dose_unit=60;
				}
			}
					
			
			pstmt			= connection.prepareStatement("SELECT CEIL(TOT_INFUSION_OVER/ORIG_INFUSE_OVER*?) NO_OF_DOSES,QTY_VALUE,TOT_INFUSION_OVER,ORIG_INFUSE_OVER  FROM OR_ORDER_LINE_PH A, OR_ORDER_LINE B WHERE A.ORDER_ID=B.ORDER_ID AND B.ORDER_CATEGORY = 'PH' AND A.ORDER_LINE_NUM=B.ORDER_LINE_NUM AND A.ORDER_ID=? AND A.ORDER_LINE_NUM=?") ;

			pstmt2	= connection.prepareStatement("SELECT CONTENT_IN_PRES_BASE_UOM FROM PH_DRUG WHERE DRUG_CODE=?");
			pstmt.setInt(1,dose_unit);
			pstmt.setString(2,order_id);
			pstmt.setString(3,order_line_no);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				no_of_doses = resultSet.getString("NO_OF_DOSES");
				dose_value  = resultSet.getString("QTY_VALUE"); 
				tot_infusion_over = resultSet.getString("TOT_INFUSION_OVER");
				orig_infusion_over = resultSet.getString("ORIG_INFUSE_OVER");

			}
			if(iv_prep_yn!=null && (iv_prep_yn.equals("5") || (iv_prep_yn.equals("1") && order_line_no.equals("1")))){ // iv_prep_yn.equals("1") added for SKR-SCF-1421
			pstmt2.setString(1,drug_code);
			resultSet2			= pstmt2.executeQuery();
			if(resultSet2!=null && resultSet2.next()){
				content_in_pres_base_uom =resultSet2.getString("CONTENT_IN_PRES_BASE_UOM"); 
			}
			duration		=		Float.parseFloat(tot_infusion_over);  
			infution_over = orig_infusion_over;
  
				
				  total_duration		= new Float(Math.ceil(((duration / (Float.parseFloat(infution_over)))*100)/100)) ;

//System.err.println("content_in_pres_base_uom====5430==>"+content_in_pres_base_uom+"==dose_value==>"+dose_value+"==total_duration===>"+total_duration);
				no_of_doses = new Float(Math.ceil( Float.parseFloat(dose_value)/ Float.parseFloat(content_in_pres_base_uom))*total_duration).intValue()+"";
				no_of_doses=(Integer.parseInt(no_of_doses)*dose_unit)+"";

//System.err.println("no_of_doses====5434==>"+no_of_doses);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1);
				closeResultSet( resultSet2);
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2 ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return no_of_doses;
	}


	//code added for Recording ADR Details
	public void clearADRDetails(String key) {
		 if(this.adrDetails.containsKey(key)) {
			 this.adrDetails.remove(key);
		 }
	}

	public void setADRDetails(String key,ArrayList values){
		adrDetails.put(key,values);
	}

	public void setADRReason(String order_id, String encounter_id,String drug, String scheduled_date,ArrayList values) {
		this.adrReason.put(login_facility_id+"_"+order_id+"_"+encounter_id+"_"+drug+"_"+scheduled_date,values);
		if(!this.all_dtls.contains(order_id+"_"+encounter_id+"_"+drug+"_"+scheduled_date)) {
			this.all_dtls.add(order_id+"_"+encounter_id+"_"+drug+"_"+scheduled_date);
			this.all_dtls.add(order_id);
			this.all_dtls.add(encounter_id);
			this.all_dtls.add(drug);
			this.all_dtls.add(scheduled_date);
		}
	}

	public HashMap getADRReason() {
		return this.adrReason;
	}

	public HashMap getADRDetails() {
		return this.adrDetails;
	}

	public ArrayList getADRDetails(String key){
		ArrayList adr_recs			=	new ArrayList();
		if(adrDetails==null)adrDetails=new HashMap();
		if(this.adrDetails.containsKey(key)) {
			adr_recs	=	(ArrayList)adrDetails.get(key);
		}
		else{
			adr_recs.add("");
			adr_recs.add("");
			adr_recs.add("");
			adr_recs.add("");
			adr_recs.add("");
		}		
		return adr_recs;
	}

	public ArrayList loadSchDate(String encounter_id,String drug_code) throws Exception{

	   	Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String	sch_date_code		=	"";
		locale = getLanguageId();
		
		ArrayList schdate		=	new ArrayList();
		try {

            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ADR_SCH_DATE")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,drug_code);
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				sch_date_code		=	resultSet.getString("sch_date_time");
				if(!locale.equals("en"))
					sch_date_code = com.ehis.util.DateUtils.convertDate(sch_date_code, "DMYHM","en",locale);

				schdate.add(sch_date_code);
				schdate.add(sch_date_code);
			}		
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			schdate.add(e);
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return schdate;
	}
	
	public void getADRDtlRecord() throws Exception{
	}

	public String getAdrRemarks(String code,String appl_trn){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String remarks			= "";
		locale = getLanguageId()==null?"en":getLanguageId();
	
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_REASON_REMARKS")) ;
			pstmt.setString(1,code);
			pstmt.setString(2,appl_trn);
			pstmt.setString(3,locale);
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
					es.printStackTrace() ;
				}
		}
		return remarks;
	}
	
	public ArrayList getReasonCode() throws Exception{

	   	Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList	code		=	new ArrayList();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MEDICATION_ADR_CODE")) ;
						
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				code.add(resultSet.getString("CODE"));
				code.add(resultSet.getString("ADR_DESC"));
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
		return code;
	}

	public HashMap getADRDetail(String encounter_id,String scheduled_date,String drug,String order_id) throws Exception{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		HashMap	adrDtl			= new HashMap();
		String str_date="";
		locale = getLanguageId();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT15")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,scheduled_date);
			pstmt.setString(4,drug);
			pstmt.setString(5,order_id);						
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				if(!checkForNull(resultSet.getString("ADR_REASON_CODE")).equals("")) {
					str_date		=	checkForNull(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
					if(!locale.equals("en"))
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);

					adrDtl.put("AGNST_SCHD",str_date);
					adrDtl.put("ADR_REASON",checkForNull(resultSet.getString("ADR_REASON_CODE")));
					adrDtl.put("ADR_REMARKS",checkForNull(resultSet.getString("ADR_REMARKS")));

					str_date		=	checkForNull(resultSet.getString("ADR_RECORDED_DATE_TIME"));
					if(!locale.equals("en"))
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);

					adrDtl.put("ADR_RECORDED",str_date);
					adrDtl.put("ADR_RECORDED_BY",checkForNull(resultSet.getString("ADR_RECORDED_BY")));	
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
		return adrDtl;
	}

	public ArrayList allreadyExistRecord(String encounter_id,String scheduled_date,String drug,String order_id) throws Exception{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String str_date="";
		locale = getLanguageId();

		ArrayList	alreadyExistValues		=	new ArrayList();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MEDICATION_ADR_DFT_VALUES")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,encounter_id);

			pstmt.setString(3,drug);
			pstmt.setString(4,order_id);						
            resultSet	= pstmt.executeQuery() ;

			while (resultSet.next()){

				str_date		=	checkForNull(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
				if(!locale.equals("en"))
					str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);

				alreadyExistValues.add(str_date);
				alreadyExistValues.add(resultSet.getString("ADR_REASON_CODE"));
				alreadyExistValues.add(resultSet.getString("ADR_REMARKS"));

				str_date		=	checkForNull(resultSet.getString("ADR_RECORDED_DATE_TIME"));
				if(!locale.equals("en"))
					str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);

				alreadyExistValues.add(str_date);
				alreadyExistValues.add(resultSet.getString("ADR_RECORDED_BY"));
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
		return alreadyExistValues;
	}

	public boolean isLessThanSysdate(String to_date_time) throws Exception{
		Connection connection	   = null;
        PreparedStatement pstmt	   = null;
        ResultSet resultSet		   = null;
		boolean	 less_than_sysdate = true;
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MEDICATION_COMPARE_DATES")) ;
			pstmt.setString(1,to_date_time);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				if(resultSet.getInt("VAL")>0){
					less_than_sysdate =false;
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
		return less_than_sysdate;
	}
	public boolean enableSelect(String sch_date_time, String admin_from,String admin_to) throws Exception{		
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		int count					=	0;
		boolean result				=	false;

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT16")) ;
			pstmt.setString(1,sch_date_time);
			pstmt.setString(2,admin_from);
			pstmt.setString(3,admin_to);
			resultSet	= pstmt.executeQuery();
			if (resultSet!=null && resultSet.next()){
				count	=	resultSet.getInt("COUNT");
			}	
			if(count > 0) {
				result	=	true;
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

	public boolean enableVerbalRx() throws Exception{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		boolean enable_rx			= false;
		int count					= 0;
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT29")) ;
			pstmt.setString(1,login_by_id);
			pstmt.setString(2,login_by_id);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				count	=	resultSet.getInt(1);
			}	
			if(count>0) {
				enable_rx	=	true;
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
		return enable_rx;
	}

	public String getPractitionerType(String pract_id) throws Exception{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		String pract_type			= "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT14")) ;
			pstmt.setString(1,pract_id);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				pract_type	=	resultSet.getString("PRACT_TYPE");
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
		return pract_type;
	}

	public ArrayList getProductName(String order_id,String order_line_num) throws Exception{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		String prod_name			= "";
		ArrayList data              = new ArrayList();
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT11")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				prod_name	=	resultSet.getString("IV_INGREDIENTS");
			}	
			if(prod_name!=null)
			{
				prod_name	=	"IV Set: "+prod_name.replace('|',',');
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			pstmt		=	null;
			resultSet	=	null;
			
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_WORKSHEET_SELECT2")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			pstmt.setString(3,login_facility_id);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				prod_name	= prod_name + "\nPrepared Product: "+resultSet.getString("MFG_UNIT");
				data.add(prod_name);
				data.add(resultSet.getString("BATCH_ID"));
				data.add(resultSet.getString("EXPIRY_DATE"));
				
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
		return data;
	}
	public ArrayList getTPNProductName(String order_id,String order_line_num) throws Exception{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		String prod_name			= "";
		ArrayList data              = new ArrayList();
		try {
            connection	= getConnection() ;
			/*pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT11")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				prod_name	=	resultSet.getString("IV_INGREDIENTS");
			}	

			prod_name	=	"IV Set: "+prod_name.replace('|',',');
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			*/
			pstmt		=	null;
			resultSet	=	null;
            pstmt		= connection.prepareStatement( "SELECT A.MFG_UNIT ,a.BATCH_ID BATCH_ID, to_char(a.EXPIRY_DATE,'dd/mm/yyyy') EXPIRY_DATE FROM PH_TPN_WORKSHEET_HDR A,PH_TPN_WORKSHEET_DTL B WHERE A.TPN_WORKSHEET_ID =B.TPN_WORKSHEET_ID AND A.FACILITY_ID = B.FACILITY_ID AND A.DISP_LOCN_CODE   = B.DISP_LOCN AND B.ORDER_ID =? AND B.ORDER_LINE_NUM =? AND A.FACILITY_ID =?") ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			pstmt.setString(3,login_facility_id);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				prod_name	= prod_name + "\nPrepared Product: "+resultSet.getString("MFG_UNIT");

				data.add(prod_name);
				data.add(resultSet.getString("BATCH_ID"));
				data.add(resultSet.getString("EXPIRY_DATE"));
				
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
		return data;
	}
	public String syscomp(String end_date_time,String order_id,String order_line_num){
	   Connection connection 	   = null;
	   PreparedStatement pstmt 	   = null;
	   ResultSet resultSet 		   = null;
       int count=0;
	   String admin_due_flag="";

 		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT5A")) ;

			pstmt.setString(1,end_date_time);
			pstmt.setString(2,order_id);
			pstmt.setString(3,order_line_num);
			resultSet	= pstmt.executeQuery() ;

			while(resultSet.next()){ 
				count=resultSet.getInt(1);	
			 }
			if( count >= 1){ 
				admin_due_flag="N";
			}
			else {
				admin_due_flag="Y";
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
		return admin_due_flag;
    }

	public void setTodaysDate(){
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		locale = getLanguageId();
		try{
			connection	= getConnection() ;
		    pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT25") ) ;
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				this.today_date	=	resultSet.getString("TODAY");
				this.today_date_time =   resultSet.getString("TODAY_DATE_TIME");

				if(!locale.equals("en")){
					this.today_date = com.ehis.util.DateUtils.convertDate(this.today_date, "DMY","en",locale);
					this.today_date_time  = com.ehis.util.DateUtils.convertDate(this.today_date_time , "DMYHM","en",locale);
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
	}

// This method gives the applicable dispense category based on dispense location code
	public String getDispCatg(String disp_locn_code){
		String disp_catg="";
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		locale = getLanguageId()==null?"en":getLanguageId();

	    try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT5") ) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
			pstmt.setString(3,locale);
            resultSet = pstmt.executeQuery() ;
            if ( resultSet.next() ) {
				setStoreCode(resultSet.getString("STORE_CODE"));
				disp_catg = resultSet.getString("DISP_LOCN_CATEGORY");
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
		return disp_catg;
	}

	public String IVType(String order_id) throws Exception{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		String iv_prep_yn			= "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT27")) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				iv_prep_yn	=	checkForNull(resultSet.getString("iv_prep_yn"));
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
		return iv_prep_yn;
	}

	public ArrayList getPatientDetail(String patient_id) throws Exception{

	   	Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList	code		=	new ArrayList();
		locale = getLanguageId()==null?"en":getLanguageId();
	//	String sql = "";
		try {
            connection	= getConnection() ;
           // pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT31")) ;
		//	sql = "SELECT A.SHORT_NAME NATIONALITY,nvl( decode(?,'en',C.PATIENT_NAME, PATIENT_NAME_LOC_LANG),PATIENT_NAME) PATIENT_NAME,DECODE(C.SEX,   'M',   'male',   'F',   'female',   'unknown') GENDER,GET_AGE(C.DATE_OF_BIRTH) AGE FROM    MP_COUNTRY_LANG_VW A,MP_PATIENT C WHERE    COUNTRY_CODE=C.NATIONALITY_CODE AND C.PATIENT_ID=?  AND A.LANGUAGE_ID = ?";
	//		pstmt		= connection.prepareStatement(sql);
			pstmt		= connection.prepareStatement("SELECT A.SHORT_NAME NATIONALITY,nvl( decode(?,'en',C.PATIENT_NAME, PATIENT_NAME_LOC_LANG),PATIENT_NAME) PATIENT_NAME,DECODE(C.SEX,   'M',   'male',   'F',   'female',   'unknown') GENDER,GET_AGE(C.DATE_OF_BIRTH) AGE,TO_CHAR(C.DATE_OF_BIRTH,'DD/MM/YYYY') DOB FROM    MP_COUNTRY_LANG_VW A,MP_PATIENT C WHERE    COUNTRY_CODE=C.NATIONALITY_CODE AND C.PATIENT_ID=?  AND A.LANGUAGE_ID = ?") ;

			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id.trim());
//			pstmt.setString(2,login_facility_id.trim());
			pstmt.setString(3,locale);
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				code.add(resultSet.getString("NATIONALITY"));
				code.add(resultSet.getString("PATIENT_NAME"));
				code.add(resultSet.getString("GENDER"));
				code.add(resultSet.getString("AGE")); 
				setPatientDOB(patient_id,resultSet.getString("DOB"));//added for ARYU-SCF-023
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
		return code;
	}

	public String getPRNInstructions(String order_id,String order_line_no)throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String prn_remarks		= "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("SELECT PRN_REMARKS FROM PH_PATIENT_DRUG_PROFILE WHERE ORIG_ORDER_ID = (?) AND ORIG_ORDER_LINE_NO = (?)");
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

	public boolean isAuthenticationRequired(String facility_id,String drug_catg){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        PreparedStatement pstmt_cat	= null;
        ResultSet resultSet		= null;
        ResultSet resultSet_cat		= null;
		String facility_lvl_auth="N";
		String drug_catg_lvl_auth="N";
		boolean fac_auth_reqd=false;
		boolean drug_catg_auth_reqd=false;
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("select drug_cat_pin_auth_reqd_yn from ph_facility_param where facility_id=?");
			pstmt.setString(1,facility_id.trim());
			resultSet	= pstmt.executeQuery() ;
			while (resultSet !=null && resultSet.next()){
				facility_lvl_auth	= resultSet.getString("drug_cat_pin_auth_reqd_yn")==null?"":resultSet.getString("drug_cat_pin_auth_reqd_yn");		
			}
			
			if(facility_lvl_auth.trim().equals("Y"))
				fac_auth_reqd=true;
			if(fac_auth_reqd && !drug_catg.trim().equals("")){
				pstmt_cat		= connection.prepareStatement("SELECT PIN_AUTH_REQD_YN FROM PH_DRUG_CATG WHERE DRUG_CATG_CODE=?");
				pstmt_cat.setString(1,drug_catg.trim());
				resultSet_cat	= pstmt_cat.executeQuery() ;
			}
			while (resultSet_cat !=null && resultSet_cat.next()){
				drug_catg_lvl_auth	= resultSet_cat.getString("PIN_AUTH_REQD_YN")==null?"":resultSet_cat.getString("PIN_AUTH_REQD_YN");		
			}
			if(drug_catg_lvl_auth.trim().equals("Y"))
				drug_catg_auth_reqd=true;
			else
				drug_catg_auth_reqd=false;
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet_cat ) ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_cat ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
			}
			catch(Exception ex){
				ex.printStackTrace() ;			
			}
		}
		return drug_catg_auth_reqd;
	}

	public String getPinNumber(){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String pin_no="";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT81"));
			pstmt.setString(1,login_by_id);
			resultSet	= pstmt.executeQuery() ;
			while (resultSet !=null && resultSet.next()){
				pin_no	= resultSet.getString("PIN_NO")==null?"":resultSet.getString("PIN_NO");		
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
		return pin_no;
	}	

	public String getPinNumber(String user_id){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String pin_no="";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT81"));
			pstmt.setString(1,user_id.trim());
			resultSet	= pstmt.executeQuery() ;
			while (resultSet !=null && resultSet.next()){
				pin_no	= resultSet.getString("PIN_NO")==null?"":resultSet.getString("PIN_NO");		
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
		return pin_no;
	}

	public String getSMUserName(String user_id){	
		Connection connection	= null;
        PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String user_name="";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT31"));
			pstmt.setString(1,user_id.trim());
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery() ;
			while (resultSet !=null && resultSet.next()){
				user_name	= resultSet.getString("APPL_USER_NAME")==null?"":resultSet.getString("APPL_USER_NAME");		
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
		return user_name;
	}

	public boolean isWitnessedbyRequiredForIV(String order_id){	
		Connection connection			= null;
        PreparedStatement pstmt			= null;        		
		ResultSet resultSet				= null;		
		boolean required				= false;
		int reqData						= 0;
		try{
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("SELECT COUNT(MEDN_ADMN_DTL_REQD_YN) MEDN_ADMN_DTL_REQD_YN FROM PH_DRUG WHERE DRUG_CODE IN(SELECT ORDER_CATALOG_CODE FROM OR_ORDER_LINE WHERE ORDER_ID = ? AND ORDER_CATEGORY='PH') AND MEDN_ADMN_DTL_REQD_YN = 'Y'");
			pstmt.setString(1,order_id.trim());
			resultSet	= pstmt.executeQuery() ;
			while (resultSet !=null && resultSet.next()){				
				reqData=resultSet.getInt("MEDN_ADMN_DTL_REQD_YN");
				if(reqData>0){
					required=true;					
				}
			}					
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try	{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;			
				closeConnection( connection ); 
			}
			catch(Exception ex)	{
				ex.printStackTrace() ;			
			}
		}
		return required;
	}

	public ArrayList getSlidingScaleTemplateDetails(String Order_Id,String Order_line_num){
		Connection connection			= null;
        PreparedStatement pstmt			= null;      		
		ResultSet resultSet				= null;
		ArrayList slidingScaleDetails	= new ArrayList();		
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("select A.TEMPLATE_ID, A.SRL_NO, A.RANGE_FROM, A.RANGE_TO, A.ADMIN_UNITS, B.RANGE_UOM_CODE, B.ADMIN_UNITS_UOM_CODE from OR_ORDER_LINE_PH_SLD_SCALE A, ph_sliding_scale_tmpl B where A.TEMPLATE_ID = B.TEMPLATE_ID and A.order_id=? and A.order_line_num=? ");
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

	public ArrayList getBalanceQuantityForPRN(String Order_Id,String Order_line_num){
		//get prescribed quantity from PH_MEDN_ADMIN where dosage_seq_no=1
		 // get CONTENT_IN_PRES_BASE_UOM, PRES_BASE_UOM
		// multiply prescribed quantity with CONTENT_IN_PRES_BASE_UOM
		//display the result in a label with pres_base_uom
		//before apply, calculate the total dispensed quantity, and minus it.
		//divide the result with CONTENT_IN_PRES_BASE_UOM and rount it and store it to PH_MEDN_ADMIN
		Connection connection			= null;
        PreparedStatement pstmt			= null;      		
		ResultSet resultSet				= null;
		ArrayList balQuantityDetails	= new ArrayList();		
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("SELECT ((NVL(A.ORDER_QTY,0)*C.CONTENT_IN_PRES_BASE_UOM)-(NVL(B.TOT_ADMINISTERED_QTY,0)+0)) BAL_QTY, C.PRES_BASE_UOM,D.SHORT_DESC PRES_BASE_UOM_DESC FROM OR_ORDER_LINE A,PH_PATIENT_DRUG_PROFILE B,PH_DRUG C, AM_UOM_LANG_VW D WHERE A.ORDER_ID=B.ORIG_ORDER_ID  AND A.ORDER_LINE_NUM=B.ORIG_ORDER_LINE_NO AND A.ORDER_ID=? AND A.ORDER_LINE_NUM=? AND A.ORDER_CATALOG_CODE = C.DRUG_CODE AND D.UOM_CODE = C.PRES_BASE_UOM AND D.language_id=? ");
			pstmt.setString(1,Order_Id);			
			pstmt.setString(2,Order_line_num);			
			pstmt.setString(3,getLanguageId());			
			resultSet	= pstmt.executeQuery() ;
			while (resultSet !=null && resultSet.next()){
				balQuantityDetails.add(resultSet.getString("BAL_QTY"));
				balQuantityDetails.add(resultSet.getString("PRES_BASE_UOM"));
				balQuantityDetails.add(resultSet.getString("PRES_BASE_UOM_DESC"));
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
		return balQuantityDetails;
	}

	public String getAdmn_chng_dose_reason_desc(String reason_code){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;
		String sql = "";
		String reason_desc ="";
		try{
			connection			= getConnection() ;
			sql ="SELECT REASON_DESC FROM PH_MEDN_TRN_REASON_LANG_VW WHERE APPL_TRN_TYPE='DM' AND REASON_CODE =? AND LANGUAGE_ID=?";

			pstmt				= connection.prepareStatement( sql) ;
			pstmt.setString(1,reason_code);
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				reason_desc	= resultSet.getString("REASON_DESC");
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
		return reason_desc;	
	}

	public int getPPNIOrderValues(String OrderId, String sPatientId){
		Connection			oConnection				= null;
        PreparedStatement	oPreparedStmt			= null;      		
		ResultSet			oResultSet				= null;
		//ArrayList			alPPNItemDetails		= null;
		//StringBuffer		sbItemIds				= new StringBuffer(" ('");
		//HashMap				hmPPNStoredValues				= null;
		//StringBuffer		sbCriteriaConditions	= new StringBuffer("");
		//ArrayList			alItemCodes				= new ArrayList();	
		int count =0;
		try {
            oConnection	= getConnection() ;
			String sSQL =   "select count(*) count from ph_ppn_orders A, PH_TPN_REGIMEN B where facility_id = ? AND order_id =? and patient_id =?  AND B.TPN_REGIMEN_CODE= A.ITEM_CODE";

			oPreparedStmt		= oConnection.prepareStatement(sSQL);
			oPreparedStmt.setString(1,login_facility_id);			
			oPreparedStmt.setString(2,OrderId);			
			oPreparedStmt.setString(3,sPatientId);			
				
			oResultSet	= oPreparedStmt.executeQuery() ;
			if(oResultSet !=null && oResultSet.next()){	
				count = oResultSet.getInt("count");			
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
			catch(Exception ex)	{
				ex.printStackTrace() ;			
			}
		}
		return count;
	}

	public ArrayList getMFRDetails(String Order_id,String Order_line_no){
		Connection oConnection				= null;
		ArrayList MFRDetails				= new ArrayList();
		PreparedStatement oPreparedStmt		= null;      		
		ResultSet oResultSet				= null;
		HashMap dtls;
		try	{  
			oConnection	= getConnection() ;
			String sqlString="SELECT SL_NO, TOT_STRENGTH, TOT_STRENGTH_UOM, INFUSE_OVER, INFUSE_OVER_UNIT, INFUSION_RATE, INFUSION_VOL_STR_UNIT,am_get_desc.am_uom(INFUSION_VOL_STR_UNIT, ? , 2 ) INFUSION_VOL_STR_UNIT_DESC, INFUSION_PER_UNIT,ADMIN_RATE_DETAIL, TO_CHAR(SCH_START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE_TIME, TO_CHAR(SCH_END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE_TIME, NVL(GAP_DURATION_IN_HRS,0) GAP_DURATION_IN_HRS,MAR_STATUS,TO_CHAR(ACT_START_DATE_TIME,'DD/MM/YYYY HH24:MI') ACT_START_DATE_TIME, TO_CHAR(ACT_END_DATE_TIME,'DD/MM/YYYY HH24:MI') ACT_END_DATE_TIME, BATCH_ID,TO_CHAR(EXPIRY_DATE,'DD/MM/YYYY') EXPIRY_DATE,NVL(HOLD_DURN_IN_MINS,0) HOLD_DURN_IN_MINS, TO_CHAR(HOLD_DATE_TIME,'DD/MM/YYYY HH24:MI') HOLD_DATE_TIME, TO_CHAR(RESUME_DATE_TIME,'DD/MM/YYYY HH24:MI') RESUME_DATE_TIME,COMPLETED_DURN_IN_MINS,COMPLETED_VOLUME FROM OR_ORDER_LINE_PH_MFR WHERE ORDER_ID=? AND ORDER_LINE_NUM=?";
			oPreparedStmt		= oConnection.prepareStatement(sqlString);
			oPreparedStmt.setString(1,getLanguageId());			
			oPreparedStmt.setString(2,Order_id);			
			oPreparedStmt.setString(3,Order_line_no);
			oResultSet	= oPreparedStmt.executeQuery() ;
			if(oResultSet !=null)	{
				while(oResultSet.next()){	
					dtls=new HashMap();
					dtls.put("SL_NO",oResultSet.getInt("sl_no")+"");
					dtls.put("TOT_STRENGTH",oResultSet.getInt("tot_strength")+"");
					dtls.put("GAP_DURATION_IN_HRS",oResultSet.getFloat("gap_duration_in_hrs")+"");
					dtls.put("HOLD_DURN_IN_MINS",oResultSet.getInt("HOLD_DURN_IN_MINS")+"");
					dtls.put("TOT_STRENGTH_UOM",oResultSet.getString("tot_strength_uom"));
					dtls.put("INFUSE_OVER",oResultSet.getFloat("infuse_over")+"");					
					dtls.put("INFUSE_OVER_UNIT",oResultSet.getString("infuse_over_unit"));
					dtls.put("INFUSION_RATE",oResultSet.getFloat("infusion_rate")+"");
					dtls.put("INFUSION_VOL_STR_UNIT",oResultSet.getString("infusion_vol_str_unit"));
					dtls.put("INFUSION_VOL_STR_UNIT_DESC",oResultSet.getString("infusion_vol_str_unit_desc"));
					dtls.put("INFUSION_PER_UNIT",oResultSet.getString("infusion_per_unit"));
					dtls.put("ADMIN_RATE_DETAIL",oResultSet.getString("admin_rate_detail"));
					dtls.put("START_DATE_TIME",oResultSet.getString("start_date_time"));
					dtls.put("END_DATE_TIME",oResultSet.getString("end_date_time"));
					dtls.put("MAR_STATUS",oResultSet.getString("mar_status"));
					dtls.put("ACT_START_DATE_TIME",oResultSet.getString("ACT_START_DATE_TIME"));
					dtls.put("ACT_END_DATE_TIME",oResultSet.getString("ACT_END_DATE_TIME"));
					dtls.put("BATCH_ID",oResultSet.getString("BATCH_ID"));
					dtls.put("EXPIRY_DATE",oResultSet.getString("EXPIRY_DATE"));
					dtls.put("HOLD_DATE_TIME",oResultSet.getString("HOLD_DATE_TIME"));					
					dtls.put("RESUME_DATE_TIME",oResultSet.getString("RESUME_DATE_TIME"));				
					dtls.put("COMPLETED_DURN_IN_MINS",oResultSet.getInt("COMPLETED_DURN_IN_MINS")+"");			
					dtls.put("COMPLETED_VOLUME",oResultSet.getFloat("COMPLETED_VOLUME")+"");
					MFRDetails.add(dtls);
				}
			}
		}
		catch (Exception execption){
			execption.printStackTrace();
		}
		finally	{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oPreparedStmt ) ;	
				closeConnection( oConnection ); 
			}
			catch(Exception ex)	{
				ex.printStackTrace();
			}
		}
		return MFRDetails;
	}	
	public boolean insertSFRDetails(HashMap dtlMap){
		boolean updated=true;
		Connection oConnection				= null;
		PreparedStatement oPreparedStmt		= null;      		
		//ResultSet oResultSet				= null;
		//String order_id						= "";
		//String SFR_Status					= "";
		String holdMinutes					= "";
		//String holdDateTime					= "";
		//String infusion_date_time			= "";
//		String infusion_end_date			= "";  Removed for IN063877
		//String resumeDateTime				= "";
		String completed_durn_in_mins		= "";
		String completed_volume				= "";
		String start_date				= "";
		//String locale			= getLanguageId()==null?"en":getLanguageId();
		try{
			oConnection	= getConnection();
			holdMinutes = (String)dtlMap.get("holdMinutes")==null?"0":(String)dtlMap.get("holdMinutes");
			completed_durn_in_mins = (String)dtlMap.get("completed_durn_in_mins")==null?"0":(String)dtlMap.get("completed_durn_in_mins");
			completed_volume = (String)dtlMap.get("completed_volume")==null?"0":(String)dtlMap.get("completed_volume");

			String sqlString="UPDATE PH_MEDN_ADMIN SET FLOW_STATUS=?, HOLD_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), HOLD_DURN_IN_MINS=?, RESUME_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ACT_START_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ACT_END_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'),COMPLETED_DURN_IN_MINS=?,COMPLETED_VOLUME=?,SCH_INFUSION_PERIOD=?,SCH_INFUSION_RATE=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=? and DOSAGE_SEQ_NO=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI')";
			oPreparedStmt		= oConnection.prepareStatement(sqlString);
			oPreparedStmt.setString(1,(String)dtlMap.get("SFR_Status"));
			oPreparedStmt.setString(2,(String)dtlMap.get("holdDateTime"));
			oPreparedStmt.setInt(3,Integer.parseInt(holdMinutes));
			oPreparedStmt.setString(4,(String)dtlMap.get("resumeDateTime"));
			start_date=(String)dtlMap.get("infusion_date_time");
			
			//Added IF-Condition  on 8/OCT/2010 for the incident num:24067 ===By Sandhya
			if(!(locale.equals("en"))){
				start_date = com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",locale,"en");
			}
			oPreparedStmt.setString(5,start_date);
			//oPreparedStmt.setString(6,(String)dtlMap.get("infusion_date_time"));
			oPreparedStmt.setString(6,(String)dtlMap.get("infusion_end_date"));
			oPreparedStmt.setInt(7,Integer.parseInt(completed_durn_in_mins));
			oPreparedStmt.setDouble(8,Double.parseDouble(completed_volume));
			oPreparedStmt.setDouble(9,Double.parseDouble((String)dtlMap.get("iv_infusion_period")));
			oPreparedStmt.setDouble(10,Double.parseDouble((String)dtlMap.get("iv_flow_rate")));//Added for SKR-SCF-0913[Inc 46556]
			oPreparedStmt.setString(11,(String)dtlMap.get("order_id"));
			oPreparedStmt.setString(12,(String)dtlMap.get("order_line_no"));
			oPreparedStmt.setString(13,(String)dtlMap.get("srl_no"));
			oPreparedStmt.setString(14,(String)dtlMap.get("iv_sch_admin_date_time"));
			
			int result = oPreparedStmt.executeUpdate();
			if(result>0){
				updated=true;
				oConnection.commit();
			}
			else{
				updated=false;
				oConnection.rollback();
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
			updated=false;
		}
		finally{
			try{
				closeStatement( oPreparedStmt ) ;	
				closeConnection( oConnection ); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return updated;
	}

	public boolean insertSFRDetailsSCH(HashMap dtlMap){
		boolean updated=true;
		Connection oConnection				= null;
		PreparedStatement oPreparedStmt		= null, pstmt_insert_medn_admin = null;     
		ResultSet rsRecExists = null;
		String holdMinutes					= "";
	//	String infusion_end_date			= "";  Removed for IN063877
		String completed_durn_in_mins		= "";
		String completed_volume				= "";
		String start_date				= "";
		String sqlString = "";
		String iv_prep_yn = dtlMap.get("iv_prep_yn")==null?"":(String)dtlMap.get("iv_prep_yn");
		int rec_count = 0;
		try{
			oConnection	= getConnection();
			if( !(iv_prep_yn).equals("3") && !(iv_prep_yn).equals("4") ) {
				sqlString="select count(*) rec_count from PH_MEDN_ADMIN WHERE ORDER_ID=? AND ORDER_LINE_NUM=? and DOSAGE_SEQ_NO=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI')";
				oPreparedStmt		= oConnection.prepareStatement(sqlString);
				oPreparedStmt.setString(1,(String)dtlMap.get("order_id"));
				oPreparedStmt.setString(2,(String)dtlMap.get("order_line_no"));
				oPreparedStmt.setString(3,(String)dtlMap.get("srl_no"));
				oPreparedStmt.setString(4,(String)dtlMap.get("iv_sch_admin_date_time")); //iv_admin_date_time
				rsRecExists =  oPreparedStmt.executeQuery() ;
				if (rsRecExists!=null && rsRecExists.next()){
					rec_count		=	rsRecExists.getInt("rec_count");				
				}
				closeResultSet( rsRecExists ) ;
				if(rec_count==0){
					pstmt_insert_medn_admin		= oConnection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_FT_INSERTSCH"));
					pstmt_insert_medn_admin.setString(1,(String)dtlMap.get("iv_sch_admin_date_time"));//NEXT SCHEDULE DATE
					pstmt_insert_medn_admin.setString(2,(String)dtlMap.get("srl_no"));//NEXT SCHEDULE DATE
					pstmt_insert_medn_admin.setString(3,login_facility_id);//FACILITY_ID					
					pstmt_insert_medn_admin.setString(4,(String)dtlMap.get("encounter_id"));//ENCOUNTER_ID		
					//pstmt_insert_medn_admin.setString(5,(String)dtlMap.get("infusion_date_time"));	//SCH_DATE_TIME
					pstmt_insert_medn_admin.setString(5,(String)dtlMap.get("iv_drug_code"));	//ORD_DRUG_CODE 1 
					pstmt_insert_medn_admin.setString(6,(String)dtlMap.get("order_id"));	//ORDER_ID 3 
					pstmt_insert_medn_admin.setString(7,(String)dtlMap.get("order_line_no"));	//ORDER_LINE_NUM 4	
					rec_count = pstmt_insert_medn_admin.executeUpdate();															
				}
			}
			String sfr_status = (String)dtlMap.get("SFR_Status");
			int result =1;
			if(!sfr_status.equals("AD")){
				if(sfr_status.equals("CH"))
					sfr_status="";
				holdMinutes = (String)dtlMap.get("holdMinutes")==null?"0":(String)dtlMap.get("holdMinutes");
				completed_durn_in_mins = (String)dtlMap.get("completed_durn_in_mins")==null?"0":(String)dtlMap.get("completed_durn_in_mins");
				completed_volume = (String)dtlMap.get("completed_volume")==null?"0":(String)dtlMap.get("completed_volume");

				sqlString="UPDATE PH_MEDN_ADMIN SET FLOW_STATUS=decode(?,null, flow_status, ?), HOLD_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), HOLD_DURN_IN_MINS=?, RESUME_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ACT_START_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ACT_END_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'),COMPLETED_DURN_IN_MINS=?,COMPLETED_VOLUME=?,SCH_INFUSION_PERIOD=?,SCH_INFUSION_RATE=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=? and DOSAGE_SEQ_NO=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI')";
				oPreparedStmt		= oConnection.prepareStatement(sqlString);
				oPreparedStmt.setString(1,sfr_status);
				oPreparedStmt.setString(2,sfr_status);
				oPreparedStmt.setString(3,(String)dtlMap.get("holdDateTime"));
				oPreparedStmt.setInt(4,Integer.parseInt(holdMinutes));
				oPreparedStmt.setString(5,(String)dtlMap.get("resumeDateTime"));
				start_date=(String)dtlMap.get("infusion_date_time");
				
				if(!(locale.equals("en"))){//Added IF-Condition  on 8/OCT/2010 for the incident num:24067 ===By Sandhya
					start_date = com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",locale,"en");
				}
				oPreparedStmt.setString(6,start_date);
				oPreparedStmt.setString(7,(String)dtlMap.get("infusion_end_date"));
				oPreparedStmt.setInt(8,Integer.parseInt(completed_durn_in_mins));
				oPreparedStmt.setDouble(9,Double.parseDouble(completed_volume));
				oPreparedStmt.setDouble(10,Double.parseDouble((String)dtlMap.get("iv_infusion_period")));
				oPreparedStmt.setDouble(11,Double.parseDouble((String)dtlMap.get("iv_flow_rate")));//Added for SKR-SCF-0913[Inc 46556]
				oPreparedStmt.setString(12,(String)dtlMap.get("order_id"));
				oPreparedStmt.setString(13,(String)dtlMap.get("order_line_no"));
				oPreparedStmt.setString(14,(String)dtlMap.get("srl_no"));
				oPreparedStmt.setString(15,(String)dtlMap.get("iv_sch_admin_date_time"));
			
				result = oPreparedStmt.executeUpdate();
			}
			if(result>0){
				updated=true;
				oConnection.commit();
			}
			else{
				updated=false;
				oConnection.rollback();
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
			updated=false;
		}
		finally{
			try{
				closeStatement( oPreparedStmt ) ;
				closeStatement(pstmt_insert_medn_admin);
				closeConnection( oConnection ); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return updated;
	}

	public boolean updateMFRDetails(ArrayList mfrDetails){
		boolean updated=true;
		Connection oConnection				= null;
		PreparedStatement oPreparedStmt		= null;      		
		//ResultSet oResultSet				= null;
		String order_id						= "";		
		try{
			oConnection	= getConnection();
			String sqlString="update or_order_line_ph_mfr set MAR_STATUS=?,ACT_START_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ACT_END_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), HOLD_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'),HOLD_DURN_IN_MINS=?, INFUSE_OVER=?,INFUSION_RATE=?,BATCH_ID=?, EXPIRY_DATE=TO_DATE(?,'DD/MM/YYYY'),RESUME_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'),COMPLETED_DURN_IN_MINS=?,COMPLETED_VOLUME=?  where order_id=? and order_line_num=? and sl_no=?";
			if(mfrDetails.size()>0){
				order_id=(String)mfrDetails.get(0);
				oPreparedStmt		= oConnection.prepareStatement(sqlString);
				HashMap dtls;
				for(int j=6;j<mfrDetails.size();j++){
					dtls=(HashMap)mfrDetails.get(j);
					oPreparedStmt.setString(1,(String)dtls.get("MARStatus"));			
					oPreparedStmt.setString(2,(String)dtls.get("infusion_date_time"));			
					oPreparedStmt.setString(3,(String)dtls.get("infusion_end_date"));			
					oPreparedStmt.setString(4,(String)dtls.get("holdDateTime"));			
					oPreparedStmt.setInt(5,Integer.parseInt(((String)dtls.get("holdMinutes")).trim()));
					oPreparedStmt.setFloat(6,Float.parseFloat(((String)dtls.get("inf_prd")).trim()));
					oPreparedStmt.setFloat(7,Float.parseFloat(((String)dtls.get("MFR_flow_rate")).trim()));
					oPreparedStmt.setString(8,(String)dtls.get("MFR_batch_id"));
					oPreparedStmt.setString(9,(String)dtls.get("MFR_exp_dt"));
					oPreparedStmt.setString(10,(String)dtls.get("resumeDateTime"));
					oPreparedStmt.setInt(11,Integer.parseInt(((String)dtls.get("completedMinutes")).trim()));
					oPreparedStmt.setFloat(12,Float.parseFloat(((String)dtls.get("completedFlow")).trim()));
					oPreparedStmt.setString(13,order_id);
					oPreparedStmt.setInt(14,1);
					oPreparedStmt.setInt(15,Integer.parseInt(((String)dtls.get("srl_no")).trim()));
					;
					oPreparedStmt.addBatch();
				}
				int result[] = oPreparedStmt.executeBatch() ;
				for (int k=0;k<result.length ;k++ ){							
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result[k]<0  && result[k] != -2 ){						
						updated=false;
						break;
					}
				}
				if(updated){
					oConnection.commit();
				}
				else{
					oConnection.rollback();
				}
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
			updated=false;
		}
		finally{
			try{
				closeStatement( oPreparedStmt ) ;
				closeConnection( oConnection ); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return updated;
	}
	private ArrayList MFRAudigLogList=new ArrayList();

	public void addMFRAudigLogList(HashMap MfrDtls){
		MFRAudigLogList.add(MfrDtls);
	}

	public void clearMFRAudigLogList(){
		MFRAudigLogList.clear();
	}

	public boolean insertMFRAuditLog(){
		boolean inserted					=true;
		Connection oConnection				= null;
		PreparedStatement oPreparedStmt		= null;      		
		//ResultSet oResultSet				= null;
		HashMap dtls;
		String  actionBy = "";
		int slno;
		try{
			oConnection	= getConnection();									
			if(MFRAudigLogList.size()>0){
				String sqlString="insert into PH_MFR_AUDIT_LOG(ORDER_ID, ORDER_LINE_NUM,SRL_NO, FLOW_RATE_SL_NO, FLOW_RATE_STATUS, ACTION_TIME, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,ORD_SRL_NO,SCHD_DATE_TIME, FLOW_RATE) values(?,?,(select count(*)+1 from PH_MFR_AUDIT_LOG where ORDER_ID=? and ORDER_LINE_NUM=?),?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,SYSDATE,?,?,1,TO_DATE(?,'DD/MM/YYYY HH24:MI'), ?)";
				oPreparedStmt		= oConnection.prepareStatement(sqlString);
				for(int jv=0;jv<MFRAudigLogList.size();jv++){
					dtls=(HashMap)MFRAudigLogList.get(jv);
					actionBy = dtls.get("actionBy")==null?"":(String)dtls.get("actionBy");
					if(actionBy.equals(""))
						actionBy = login_by_id;
					slno=Integer.parseInt((String)dtls.get("srl_no"));
					oPreparedStmt.setString(1,(String)dtls.get("order_id"));			
					oPreparedStmt.setInt(2,1);
					oPreparedStmt.setString(3,(String)dtls.get("order_id"));
					oPreparedStmt.setInt(4,1);
					oPreparedStmt.setInt(5,slno);
					oPreparedStmt.setString(6,(String)dtls.get("mfr_status"));
					oPreparedStmt.setString(7,(String)dtls.get("actionTime"));
					oPreparedStmt.setString(8,(String)dtls.get("actionRemarks"));
					oPreparedStmt.setString(9,actionBy);
					oPreparedStmt.setString(10,login_at_ws_no.trim());
					oPreparedStmt.setString(11,login_facility_id.trim());
					oPreparedStmt.setString(12,(String)dtls.get("iv_sch_admin_date_time"));
					oPreparedStmt.setString(13,(String)dtls.get("iv_flow_rate"));
					oPreparedStmt.addBatch();
				}
				int result[] = oPreparedStmt.executeBatch() ;
				for (int k=0;k<result.length ;k++ ){							
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result[k]<0  && result[k] != -2 ){						
						inserted=false;
						break;
					}
				}
				if(inserted){
					oConnection.commit();
					clearMFRAudigLogList();
				}
				else{
					oConnection.rollback();
				}
			}			
		}
		catch(Exception ee){
			System.err.println("======MFRAudigLogList========>"+MFRAudigLogList);
			ee.printStackTrace();
			inserted=false;
		}
		finally{
			try{
				closeStatement( oPreparedStmt ) ;	
				closeConnection( oConnection ); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return inserted;
	}
	
	public ArrayList getMFRAuditLogDetails(String orderId, int flow_rate_sl_no, String sch_date_time){
		Connection oConnection				= null;
		PreparedStatement oPreparedStmt		= null;      		
		ResultSet oResultSet				= null;
		ArrayList auditLogList				= new ArrayList();
		HashMap	auditLogMap;
		String appendString					="order by ACTION_TIME";
		try{
			oConnection	= getConnection();
			if(!sch_date_time.equals("FromMFR"))
				appendString ="AND SCHD_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') order by ADDED_DATE";

			String sqlString="Select ADDED_DATE,SRL_NO,FLOW_RATE_STATUS,TO_CHAR(ACTION_TIME,'DD/MM/YYYY HH24:MI') ACTION_TIME,ADDED_BY_ID,REMARKS , FLOW_RATE from PH_MFR_AUDIT_LOG where ORDER_ID=? and ORDER_LINE_NUM=? and FLOW_RATE_SL_NO=? "+appendString;

			oPreparedStmt		= oConnection.prepareStatement(sqlString);		
			oPreparedStmt.setString(1,orderId);			
			oPreparedStmt.setInt(2,1);
			oPreparedStmt.setInt(3,flow_rate_sl_no);
			if(!sch_date_time.equals("FromMFR"))
				oPreparedStmt.setString(4,sch_date_time);
			oResultSet=oPreparedStmt.executeQuery();
			if(oResultSet!=null){
				while(oResultSet.next()){
					auditLogMap=new HashMap();
					auditLogMap.put("SRL_NO",oResultSet.getInt("SRL_NO")+"");
					auditLogMap.put("ACTION",oResultSet.getString("FLOW_RATE_STATUS"));
					auditLogMap.put("ACTION_TIME",oResultSet.getString("ACTION_TIME"));
					auditLogMap.put("ACTION_BY",oResultSet.getString("ADDED_BY_ID"));
					auditLogMap.put("REMARKS",oResultSet.getString("REMARKS"));
					auditLogMap.put("FLOW_RATE",checkForNull(oResultSet.getString("FLOW_RATE")));
					auditLogList.add(auditLogMap);
				}
			}
			if(MFRAudigLogList.size()>0){
				HashMap newDetails;
				String newSrlNo="";
				String new_iv_sch_admin_date_time="";
				for(int loop=0;loop<MFRAudigLogList.size();loop++){
					newDetails=(HashMap)MFRAudigLogList.get(loop);
					newSrlNo=(String)newDetails.get("srl_no")==null?"":(String)newDetails.get("srl_no");
					new_iv_sch_admin_date_time=(String)newDetails.get("iv_sch_admin_date_time")==null?"":(String)newDetails.get("iv_sch_admin_date_time");
					if(newSrlNo.equals(flow_rate_sl_no+"") && (sch_date_time.equals("FromMFR")||new_iv_sch_admin_date_time.equals(sch_date_time))){
						auditLogMap=new HashMap();
						auditLogMap.put("SRL_NO","");
						auditLogMap.put("ACTION",(String)newDetails.get("mfr_status")==null?"":(String)newDetails.get("mfr_status"));
						auditLogMap.put("ACTION_TIME",(String)newDetails.get("actionTime")==null?"":(String)newDetails.get("actionTime"));
						auditLogMap.put("ACTION_BY",(String)newDetails.get("actionBy")==null?"":(String)newDetails.get("actionBy"));
						auditLogMap.put("REMARKS",(String)newDetails.get("actionRemarks")==null?"":(String)newDetails.get("actionRemarks"));
						
						auditLogList.add(auditLogMap);
					}
				}
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
		}
		finally{
			try{
				closeConnection( oConnection ); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return auditLogList;
	}

	public ArrayList getStatusOfMAR(String orderID, String calledFrom){
		Connection oConnection				= null;
		ArrayList MFRData					=new ArrayList();
		String MFRDetails					= "";
		boolean completed					=true;
		PreparedStatement oPreparedStmt		= null;      		
		ResultSet oResultSet				= null;
		int MFRCount=1;
		try{  
			oConnection	= getConnection() ;
			String sqlString="SELECT SL_NO,MAR_STATUS,TOT_STRENGTH, am_get_desc.am_uom(TOT_STRENGTH_UOM,?,2) TOT_STRENGTH_UOM, INFUSION_PER_UNIT FROM OR_ORDER_LINE_PH_MFR WHERE ORDER_ID=? AND ORDER_LINE_NUM=?";
			oPreparedStmt		= oConnection.prepareStatement(sqlString);
			oPreparedStmt.setString(1,getLanguageId());			
			oPreparedStmt.setString(2,orderID);			
			oPreparedStmt.setInt(3,1);
			oResultSet	= oPreparedStmt.executeQuery() ;
			String stat ="";
			StringBuffer infuseDtl = null;
			if(oResultSet !=null){
				while(oResultSet.next()){	
					stat=oResultSet.getString("mar_status");
					if(stat.equals("ST")){
						stat="STARTED";
						completed=false;
					}
					else if(stat.equals("HO")){
						stat="HOLD";
						completed=false;
					}
					else if (stat.equals("RE")){
						stat="RESUMED";
						completed=false;
					}
					else if (stat.equals("CO")){
						stat="COMPLETED";
					}
					else{
						stat="NOT STARTED";
						completed=false;
					}
					if(calledFrom.equals("SCH")){
						infuseDtl = new StringBuffer();
						infuseDtl.append(" ( "+oResultSet.getString("TOT_STRENGTH")+" "+oResultSet.getString("TOT_STRENGTH_UOM"));
						if(oResultSet.getString("INFUSION_PER_UNIT").equals("H"))
							infuseDtl.append(" / Hour ) ");
						else
							infuseDtl.append(" / Minute ) ");
						MFRDetails=MFRDetails+"Flow Rate "+oResultSet.getInt("sl_no")+"-"+infuseDtl+"-"+stat+"<br>";
					}
					else
						MFRDetails=MFRDetails+"Flow Rate "+oResultSet.getInt("sl_no")+"-"+stat+"<br>";
					MFRCount = oResultSet.getInt("sl_no");
				}
				MFRData.add(MFRDetails);
				MFRData.add(completed+"");
				MFRData.add(MFRCount+"");
			}
		}
		catch (Exception execption){
			execption.printStackTrace();
		}
		finally{
			try{
				closeConnection( oConnection ); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return MFRData;
	}

	public ArrayList getMFRAdminChartDetails(String Order_id){		
		Connection oConnection				= null;
		ArrayList MFRData					=new ArrayList();		
		PreparedStatement oPreparedStmt		= null;      		
		ResultSet oResultSet				= null;
		try{  
			oConnection	= getConnection() ;
			String sqlString="SELECT b.practitioner_name,  DECODE (c.administered_yn,'Y', c.admin_remarks,c.non_admin_remarks ) remarks FROM or_order a, am_practitioner_lang_vw b, ph_medn_admin c WHERE a.ord_pract_id = b.practitioner_id AND c.order_id = a.order_id AND a.order_id = ? AND c.order_line_num = 1 AND language_id = ?";
			oPreparedStmt		= oConnection.prepareStatement(sqlString);
			oPreparedStmt.setString(1,Order_id);			
			oPreparedStmt.setString(2,getLanguageId());			
			oResultSet	= oPreparedStmt.executeQuery() ;
			if(oResultSet !=null){
				while(oResultSet.next()){	
					MFRData.add(oResultSet.getString("practitioner_name"));
					MFRData.add(oResultSet.getString("remarks"));
				}
			}
		}
		catch (Exception execption){
			execption.printStackTrace();
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oPreparedStmt ) ;
				closeConnection(oConnection); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return MFRData;
	}

	public ArrayList formDispensingDetailsForMFR(ArrayList iv){
		ArrayList dispensing_details = new ArrayList();
		ArrayList DISP_QTY = new ArrayList();
//		String Newly_Administered	= "";
		String prev_order_id		= "";
		String prev_order_id1		= "";
		String prev_order_line_no	= "";
		String batch_id				= "";
		String prescribeMode		= "";
		String str_date				= "", admin_id;
		HashMap pressModeMap		= new HashMap();
		pressModeMap				= getPresMode();
		locale						= getLanguageId();
		int jj						= 1;
		int temp					= 0;
		int tmp_no					= 1;
		float temp1					= 0.0f;
		try{
			if(iv!=null && iv.size()>0){
				ArrayList batch_dtls;
				HashMap dtlMap;
				for (int i=0;i<iv.size() ;i++ ){
					dtlMap=(HashMap)iv.get(i);						
					batch_id=(String)dtlMap.get("batch_id");				
					if(!prev_order_id.equals(((String)dtlMap.get("order_id")).trim()))
						jj	=	1;
					tmp_no				=	(jj++);
					prev_order_id=((String)dtlMap.get("order_id")).trim();
					if(!prev_order_id1.equals(((String)dtlMap.get("order_id")).trim()) || !prev_order_line_no.equals("1")) {
						prev_order_id1		=	((String)dtlMap.get("order_id")).trim();
						prev_order_line_no	=	"1";
						prescribeMode=(String)pressModeMap.get(prev_order_id1+prev_order_line_no);
						if(prescribeMode==null) 
							prescribeMode="";								
						DISP_QTY=getQtyUOM((String)dtlMap.get("drug_code"),(String)dtlMap.get("iv_admin_qty"),(String)dtlMap.get("sch_infusion_vol_str_unit"),prescribeMode,prev_order_id1,"1");
						
						dispensing_details.add(prev_order_id1);							// ORDER_ID       
						dispensing_details.add("1");									// ORDER_LINE_NO  
						dispensing_details.add((String)dtlMap.get("drug_code"));		// PRES_DRUG_CODE 
						dispensing_details.add((String)dtlMap.get("drug_code"));		// DISP_DRUG_CODE 
						dispensing_details.add((String)DISP_QTY.get(0));				// DISP_QTY
						dispensing_details.add((String)DISP_QTY.get(1));				// DISP_UOM_CODE
						dispensing_details.add((String)dtlMap.get("iv_store_code"));	// store_code
						batch_dtls = new ArrayList();
						batch_dtls.add((String)dtlMap.get("drug_code"));				// drug_code
						batch_dtls.add((String)dtlMap.get("batch_id"));					// batch_id
						str_date = (String)dtlMap.get("iv_expiry_date");				// expiry_date
						if(!locale.equals("en"))
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
						batch_dtls.add(str_date);
						batch_dtls.add((String)DISP_QTY.get(0));		// disp_qty
						batch_dtls.add((String)DISP_QTY.get(1));		// disp_qty_uom
						batch_dtls.add("");
						batch_dtls.add((String)dtlMap.get("iv_trade_id"));	// trade_id
						batch_dtls.add((String)dtlMap.get("iv_bin_code"));	// bin_locn_code	//c
						batch_dtls.add(getItemCost((String)dtlMap.get("drug_code"),(String)dtlMap.get("iv_store_code"),(String)dtlMap.get("iv_admin_qty"),(String)dtlMap.get("next_schd_date")));							// item_cost	//c
						dispensing_details.add(batch_dtls);		
						if(!stock_srl.containsKey(prev_order_id1+"1")) {
							stock_srl.put(prev_order_id1+"1",tmp_no+"");
						}						
						dispensing_details.add("N");//patientBroughtMediationYN
						dispensing_details.add((String)iv.get(37)); //ord_pract_id //Added for [IN:040149] -Start
						if(getAuthUserID()==null || getAuthUserID().equals(""))
							admin_id=(String)iv.get(i+17);	//Admin id
						else
							admin_id = getAuthUserID();	//Admin id
						dispensing_details.add(getPractId(admin_id));	//Admin id
						//auth_id = (String)iv.get(i+18);
						dispensing_details.add((String)iv.get(i+18));//Authorized id //Added for [IN:040149] - end
					}
					else {
						prescribeMode=(String)pressModeMap.get(prev_order_id1+prev_order_line_no);
						if(prescribeMode==null) 
							prescribeMode="";	
						DISP_QTY=getQtyUOM((String)dtlMap.get("drug_code"),(String)dtlMap.get("iv_admin_qty"),(String)dtlMap.get("iv_qty_uom"),prescribeMode,prev_order_id1,"1"); 					 					
						temp=Integer.parseInt((String)dispensing_details.get(dispensing_details.indexOf(prev_order_line_no)+3))+Integer.parseInt((String)DISP_QTY.get(0));

						dispensing_details.set(dispensing_details.indexOf(prev_order_line_no)+3,temp+"");
						batch_dtls=(ArrayList)dispensing_details.get(dispensing_details.indexOf(prev_order_line_no)+6);
						batch_dtls.set(3,temp+"");
						temp1=Float.parseFloat(getItemCost((String)dtlMap.get("drug_code"),(String)dtlMap.get("iv_store_code"),(String)dtlMap.get("iv_admin_qty"),(String)dtlMap.get("next_schd_date")));	
						temp1=Float.parseFloat((String)batch_dtls.get(8))+temp1;
						batch_dtls.set(8,temp1+"");	
						dispensing_details.set(dispensing_details.indexOf(prev_order_line_no)+6,batch_dtls); //5
					}								
				}
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
		}
		return dispensing_details;
	}

	public void updateStockForMFR(ArrayList mfrDetails){	
		String order_id						= "";
		String store_code					= "";
		String drug_code					= "";
		String nxtScheduledDate				= "";
		String sch_infusion_vol_str_unit	= "";
		String batch_id						= "";
		String New_Admin					= "";
		ArrayList dispDetailsList			= new ArrayList();
		ArrayList dispDetailFormedList		= null;
		String nursing_unit					= "";
		try{			
			if(mfrDetails.size()>0){
				order_id=(String)mfrDetails.get(0);
				store_code=(String)mfrDetails.get(1);
				drug_code=(String)mfrDetails.get(2);
				nxtScheduledDate=(String)mfrDetails.get(3);
				sch_infusion_vol_str_unit=(String)mfrDetails.get(4);
				nursing_unit=(String)mfrDetails.get(5);
				HashMap dtls;
				HashMap dispDtls;
				for(int j=6;j<mfrDetails.size();j++){
					dtls=(HashMap)mfrDetails.get(j);
					dispDtls=new HashMap();
					batch_id=(String)dtls.get("MFR_batch_id")==null?"":(String)dtls.get("MFR_batch_id");
					New_Admin=(String)dtls.get("Newly_Admin");
					if(New_Admin.equals("IV_Y") && !(batch_id.equals(""))){
						dispDtls.put("drug_code",drug_code);
						dispDtls.put("order_id",order_id);
						dispDtls.put("order_line_num","1");
						dispDtls.put("iv_admin_qty",(String)dtls.get("inf_volume"));
						dispDtls.put("sch_infusion_vol_str_unit",sch_infusion_vol_str_unit);
						dispDtls.put("batch_id",batch_id);
						dispDtls.put("iv_expiry_date",(String)dtls.get("MFR_exp_dt"));
						dispDtls.put("iv_trade_id",(String)dtls.get("iv_trade_id"));
						dispDtls.put("iv_qty_uom",(String)dtls.get("tot_strength_uom"));
						dispDtls.put("iv_store_code",store_code);						
						dispDtls.put("iv_bin_code",(String)dtls.get("iv_bin_code"));
						dispDtls.put("next_schd_date",nxtScheduledDate);
						//dispDtls.put("New_Admin","IV_Y");
						dispDetailsList.add(dispDtls);
					}
				}												
			}
			if(dispDetailsList.size()>0){
				float leftOverQty=getLeftOverQuantity(order_id);
				float currentQty=0.0f;
				float balanceQty=0.0f;
				String admin_qty="0";
				HashMap tempMap=null;
				if(leftOverQty>0){					
					for(int i=0;i<dispDetailsList.size();i++){
						tempMap=(HashMap)dispDetailsList.get(i);
						admin_qty=(String)tempMap.get("iv_admin_qty");
						if(admin_qty!=null && !admin_qty.equals(""))
							currentQty=Float.parseFloat(admin_qty);
						if(currentQty>0){
							if(currentQty<=leftOverQty){
								leftOverQty=leftOverQty-currentQty;
								tempMap.put("iv_admin_qty","0");
							}
							else{
								balanceQty=currentQty-leftOverQty;
								tempMap.put("iv_admin_qty",balanceQty+"");	
								leftOverQty=0;
							}
							dispDetailsList.set(i,tempMap);							
						}
						if(leftOverQty<=0)
							break;
					}
				}
				dispDetailFormedList=formDispensingDetailsForMFR(dispDetailsList);
				String disp_qty="0"; 
				float f_disp_qty=0.0f; 
				for(int i=0;i<dispDetailFormedList.size();i=i+9){
					disp_qty=(String)dispDetailFormedList.get(i+4);
					f_disp_qty=f_disp_qty+Float.parseFloat(disp_qty);
				}
				float cont_in_pres_base_uom=1;
				admin_qty="";
				currentQty=0.0f;
				for(int i=0;i<dispDetailsList.size();i++){
					tempMap=(HashMap)dispDetailsList.get(i);					
					admin_qty=(String)tempMap.get("iv_admin_qty");					
					if(admin_qty!=null && !admin_qty.equals(""))
						currentQty=currentQty+Float.parseFloat(admin_qty);
				}
				cont_in_pres_base_uom=Float.parseFloat(getContentInPresBaseUOM(drug_code));
				boolean updatedLeftOverQuantity=false;
				if(f_disp_qty>0){
					leftOverQty=leftOverQty+(cont_in_pres_base_uom*f_disp_qty)-currentQty;
					updatedLeftOverQuantity=updateLeftOverQty(leftOverQty+"",order_id);
					String facility_id		= login_facility_id.trim();
					String locale			= getLanguageId()==null?"en":getLanguageId();
					login_by_id				= login_by_id.trim();
					login_at_ws_no			= login_at_ws_no.trim();
					String patient_class	= getPatientClass();
					String source_type		= "C";
					setTodaysDate();
					String today			= getTodaysDate();
					String disp_locn_code   = "";
					String patient_id		= "";
					String encounter_id		= "";
					String ord_date_time	= "";
					Connection connection = null ;
					PreparedStatement pstmt = null;
					ResultSet resultSet = null;
					connection = getConnection() ;
					pstmt = connection.prepareStatement("SELECT PERFORMING_DEPTLOC_CODE,TO_CHAR(ORD_DATE_TIME,'DD/MM/YYYY HH24:MI')ORD_DATE_TIME,ENCOUNTER_ID,PATIENT_ID FROM OR_ORDER where ORDER_ID=NVL(?,ORDER_ID)") ;
					pstmt.setString(1,order_id.trim());
					resultSet = pstmt.executeQuery();
					while ( resultSet != null && resultSet.next() ) {
						disp_locn_code=resultSet.getString("PERFORMING_DEPTLOC_CODE");
						patient_id=resultSet.getString("PATIENT_ID");
						encounter_id=resultSet.getString("ENCOUNTER_ID");
						ord_date_time=resultSet.getString("ORD_DATE_TIME");				
						if(disp_locn_code==null)
						disp_locn_code="";
					}						
					String Auto_Admin       = getAutoAdminValue(facility_id,disp_locn_code);
					if(!locale.equals("en"))
						today = com.ehis.util.DateUtils.convertDate(today, "DMY",locale,"en");				
					if(patient_class.equals("I")|| patient_class.equals("D") )
						source_type="N";		
				
					HashMap tabData = new HashMap();
					HashMap commonValues = new HashMap();
					HashMap sqlMap = new HashMap() ;
					commonValues.put("language_id",locale);
					commonValues.put("facility_id",facility_id);
					commonValues.put("encounter_id",encounter_id);
					commonValues.put("nursing_unit",nursing_unit);
					commonValues.put("disp_locn_code",disp_locn_code);
					commonValues.put("added_by",login_by_id);
					commonValues.put("ws_no",login_at_ws_no);
					commonValues.put("disp_stage","D");
					commonValues.put("today",today);
					commonValues.put("login_by_id", login_by_id);
					commonValues.put("login_at_ws_no",login_at_ws_no);
					commonValues.put("patient_id",patient_id);
					commonValues.put("patient_class",patient_class);

					sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT56",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT56"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT33",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT33"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_INSERT"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT"));
					sqlMap.put("SQL_PH_MED_ADMIN_LABEL_CAU_SELECT33",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_LABEL_CAU_SELECT33"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT167",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT167"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_BL_SELECT2",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT2"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_BL_SELECT1",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_UPDATE"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE12",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE12"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_UPDATE13A",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_UPDATE13A"));
					sqlMap.put("SQL_PH_PRESCRIPTION_SELECT45",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT45"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT137",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT137"));
					sqlMap.put("SQL_PH_MED_ADMIN_ORDER_QTY_SELECT32",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_ORDER_QTY_SELECT32"));
					sqlMap.put("SQL_PH_MED_ADMIN_OR_ORDER_LINE_STATUS_UPDATE",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_OR_ORDER_LINE_STATUS_UPDATE"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_ORDER_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_ORDER_UPDATE"));
					sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT106",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT106"));
					sqlMap.put("SQL_PH_ADMIN_OR_ORDER_SELECT",PhRepository.getPhKeyValue("SQL_PH_ADMIN_OR_ORDER_SELECT"));
							
					tabData.put( "COMMON_VALUES",  commonValues);
					tabData.put( "DISP_DTLS",  dispDetailFormedList);
					tabData.put( "facility_id",facility_id);
					tabData.put( "patient_class",patient_class);
					tabData.put( "source_type",source_type);
					tabData.put( "language_id",locale);
					tabData.put( "Auto_admin",Auto_Admin);
					tabData.put( "ord_date_time",ord_date_time);
					tabData.put( "patient_id",patient_id);
					tabData.put( "encounter_id",encounter_id);
					tabData.put( "properties", getProperties());
					tabData.put( "ONLY_STOCK_UPDATE", "Y");
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_MEDICATION_ADMINISTRATION_FT" ),MedicationAdministrationFTHome.class,getLocalEJB());
					Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[] =new Object[2];
					argArray[0]= tabData;
					argArray[1]= sqlMap;
					Class  paramArray[] = new Class[2];
					paramArray[0]	= tabData.getClass();
					paramArray[1]	= sqlMap.getClass();
				//	HashMap result	= (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);  Removed for IN063877
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				}
				else{
					updatedLeftOverQuantity=updateLeftOverQty(leftOverQty+"",order_id);
					//HashMap result	= null;	
				}
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
		}		
	}

	public float getLeftOverQuantity(String order_id){
		float leftOverQuantity=0;
		Connection oConnection				= null;		
		PreparedStatement oPreparedStmt		= null;      		
		ResultSet oResultSet				= null;
		try{  
			oConnection	= getConnection() ;
			String sqlString="SELECT nvl(LEFT_OVER_QTY,0)LEFT_OVER_QTY FROM or_order_line_ph_mfr where order_id= ? and rownum=1";
			oPreparedStmt		= oConnection.prepareStatement(sqlString);
			oPreparedStmt.setString(1,order_id);					
			oResultSet	= oPreparedStmt.executeQuery() ;
			if(oResultSet !=null){
				while(oResultSet.next()){	
					leftOverQuantity=Float.parseFloat(oResultSet.getString("LEFT_OVER_QTY"));			
				}
			}
		}
		catch (Exception execption){
			execption.printStackTrace();
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement(oPreparedStmt);
				closeConnection(oConnection); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return leftOverQuantity;
	}

	public String getContentInPresBaseUOM(String drug_code){
		String cont_in_pres_base_uom		="1";
		Connection oConnection				= null;		
		PreparedStatement oPreparedStmt		= null;      		
		ResultSet oResultSet				= null;
		try{  
			oConnection	= getConnection() ;
			String sqlString="SELECT CONTENT_IN_PRES_BASE_UOM FROM ph_drug WHERE DRUG_CODE=?";
			oPreparedStmt		= oConnection.prepareStatement(sqlString);
			oPreparedStmt.setString(1,drug_code);					
			oResultSet	= oPreparedStmt.executeQuery() ;
			if(oResultSet !=null){
				while(oResultSet.next()){	
					cont_in_pres_base_uom=oResultSet.getString("CONTENT_IN_PRES_BASE_UOM");	
					if(cont_in_pres_base_uom==null) 
						cont_in_pres_base_uom="0";
				}
			}
		}
		catch (Exception execption){
			execption.printStackTrace();
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement(oPreparedStmt);
				closeConnection(oConnection); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return cont_in_pres_base_uom;
	}

	public boolean updateLeftOverQty(String leftOverQty,String order_id){
		Connection oConnection				= null;		
		PreparedStatement oPreparedStmt		= null;      		
		int result							= 0;
		boolean updated						= false;
		try{  
			oConnection	= getConnection() ;
			String sqlString="UPDATE or_order_line_ph_mfr SET LEFT_OVER_QTY=? where order_id=? and rownum=1";
			oPreparedStmt		= oConnection.prepareStatement(sqlString);
			oPreparedStmt.setString(1,leftOverQty);					
			oPreparedStmt.setString(2,order_id);					
			result	= oPreparedStmt.executeUpdate() ;
			if(result>0){
				updated=true;
				oConnection.commit();
			}
		}
		catch (Exception execption){
			execption.printStackTrace();
		}
		finally{
			try{
				closeStatement(oPreparedStmt);
				closeConnection(oConnection); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return updated;
	}

	public ArrayList getAlternateDrugsEqualQuantity(String dosage, String main_drug_code,String alt_drug_code){
		String equal_value					="";
		String alt_uom_value				="";
		Connection oConnection				= null;		
		PreparedStatement oPreparedStmt		= null;      		
		PreparedStatement oPreparedStmt1	= null;      		
		ResultSet oResultSet				= null;
		ResultSet oResultSet1				= null;
		ArrayList resultArray				= new ArrayList();
		try{  
			oConnection	= getConnection() ;
			String sqlString="SELECT ph_calculate_alt_drug_dosage(?,?,?) EQUAL_VALUE FROM dual";
			oPreparedStmt		= oConnection.prepareStatement(sqlString);
			oPreparedStmt.setString(1,dosage);					
			oPreparedStmt.setString(2,main_drug_code);					
			oPreparedStmt.setString(3,alt_drug_code);					
			oResultSet	= oPreparedStmt.executeQuery();
			if(oResultSet !=null){
				while(oResultSet.next()){	
					equal_value=oResultSet.getString("EQUAL_VALUE");	
					if(equal_value==null) 
						equal_value="";
				}
			}
			String sqlString1="select am_get_desc.am_uom(pres_base_uom,?,2)pres_base_uom from ph_drug where drug_code=?";
			oPreparedStmt1		= oConnection.prepareStatement(sqlString1);
			oPreparedStmt1.setString(1,getLanguageId());					
			oPreparedStmt1.setString(2,alt_drug_code);	
			oResultSet1	= oPreparedStmt1.executeQuery();
			if(oResultSet1 !=null){
				while(oResultSet1.next()){	
					alt_uom_value=oResultSet1.getString("pres_base_uom");	
					if(alt_uom_value==null) 
						alt_uom_value="";
				}
			}
			resultArray.add(equal_value);
			resultArray.add(alt_uom_value);
			
		}
		catch (Exception execption){
			execption.printStackTrace();
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeResultSet( oResultSet1 ) ;
				closeStatement(oPreparedStmt);
				closeStatement(oPreparedStmt1);
				closeConnection(oConnection); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return resultArray;
	}

//method added for IN24768 --19/11/2010-- priya
	public String getStrengthPerValuePresUOM(String drug_code){
		String strength_per_value_pres_uom		="";
		Connection oConnection				= null;		
		PreparedStatement oPreparedStmt		= null;      		
		ResultSet oResultSet				= null;
		try{  
			oConnection	= getConnection() ;
			String sqlString="Select STRENGTH_PER_VALUE_PRES_UOM from ph_drug where drug_code = ?";
			oPreparedStmt		= oConnection.prepareStatement(sqlString);
			oPreparedStmt.setString(1,drug_code);					
			oResultSet	= oPreparedStmt.executeQuery() ;
			if(oResultSet !=null){
				while(oResultSet.next()){	
					strength_per_value_pres_uom=oResultSet.getString("STRENGTH_PER_VALUE_PRES_UOM");	
					if(strength_per_value_pres_uom==null) 
						strength_per_value_pres_uom="1";
				}
			}
		}
		catch (Exception execption){
			execption.printStackTrace();
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement(oPreparedStmt);
				closeConnection(oConnection); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return strength_per_value_pres_uom;
	}

	public int loadallergydetail(String patient_id){//getting allergy existence detail - SKR-CRF-010 --The same method is exists in PrescriptionBean_1.java also
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
		return num;
	}

	public String getCustomerID() throws Exception{
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
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsCustomerID ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return customer_id;
	}
	//getting allergy existence detail - SKR-CRF-010
//newly added for RUT-SCF-0144 [IN:033371]
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
	//added below mothod for incident NO:33194
	public ArrayList getTotQty(String patient_id,String drug_code,String admin_from_date,String admin_to_date,String order_id,String order_line_num)throws Exception{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList totQty					=new ArrayList();	
		locale = getLanguageId();
		
		try{
			connection				= getConnection() ;
			String SQL  = " SELECT a.prescribed_qty, a.tot_issued_qty, a.returned_qty, a.tot_administered_qty FROM ph_patient_drug_profile a, ph_generic_name_lang_vw b, ph_drug_lang_vw c,am_frequency_lang_vw h,or_order_line o,or_order q,or_order_status_code_lang_vw r,or_order_line_ph s,ph_route k WHERE q.order_id = o.order_id AND a.patient_id =? AND A.START_DATE BETWEEN TO_DATE(NVL (?,'01/01/1472 23:59'), 'DD/MM/YYYY hh24:mi')  AND TO_DATE(NVL (?,'31/12/5000 23:59'), 'DD/MM/YYYY hh24:mi') + 0.99999 AND a.drug_code BETWEEN NVL (?, '!') AND NVL (?, '~') AND a.generic_id = b.generic_id AND k.route_code = a.route_code AND a.drug_code = c.drug_code AND h.freq_code = a.freq_code  AND a.orig_order_id = o.order_id AND a.orig_order_line_no = o.order_line_num AND o.order_line_status = r.order_status_code  AND o.order_id = s.order_id AND o.order_line_num = s.order_line_num AND b.language_id = c.language_id  AND b.language_id = h.language_id AND b.language_id = r.language_id AND b.language_id = ? AND c.drug_yn = 'Y' and o.order_id=? and o.order_line_num=?  ";
			pstmt			= connection.prepareStatement(SQL) ;
			pstmt.setString(1,patient_id.trim());
			pstmt.setString(2,admin_from_date.trim());	
			pstmt.setString(3,admin_to_date.trim());
			pstmt.setString(4,drug_code.trim());
			pstmt.setString(5,drug_code.trim());
			pstmt.setString(6,locale);
			pstmt.setString(7,order_id);
			pstmt.setString(8,order_line_num);

			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				totQty.add(resultSet.getFloat("PRESCRIBED_QTY"));	
				totQty.add(resultSet.getFloat("TOT_ISSUED_QTY"));
				totQty.add(resultSet.getFloat("RETURNED_QTY"));
				totQty.add(resultSet.getFloat("TOT_ADMINISTERED_QTY"));
			}
		}
		catch (Exception execption)	{
			execption.printStackTrace();
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		return totQty;
	}
	public ArrayList getWardRetrunQty(String patient_id,String order_id,String disp_location,String facility_id)throws Exception{
		
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList wardQty					=new ArrayList();	
		locale = getLanguageId();
		
		try{
			connection				= getConnection() ;
			//String SQL  = " SELECT a.disp_qty,  a.disp_qty - (  NVL (a.returned_qty, 0) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no  AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch),0)  + NVL ((SELECT SUM (returned_qty)  FROM ph_ward_return_dtl WHERE disp_no = a.disp_no  AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch  AND store_acknowledge_status IS NULL),0 ) ) returnable From ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, mp_patient e, ph_disp_locn_lang_vw g, or_order_line h, am_practitioner_lang_vw i, st_item j, st_sal_hdr k WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.patient_id = e.patient_id AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no  AND e.patient_id =? AND a.facility_id =? AND c.order_id = NVL (?, c.order_id)   AND a.disp_locn_code = NVL (?, a.disp_locn_code) AND a.disp_qty <> NVL (a.returned_qty, 0)  AND a.item_code = j.item_code  AND a.store_code = g.disp_locn_code AND a.facility_id = g.facility_id AND g.language_id =? AND h.order_id = b.order_id AND h.order_line_num = b.order_line_no  AND h.disc_pract_id = i.practitioner_id(+) AND i.language_id(+) =?";
			
			//String SQL  = "SELECT a.disp_qty, a.disp_qty - (  NVL (a.returned_qty, 0) + NVL ((SELECT SUM (rej_qty)  FROM ph_ward_return_dtl WHERE disp_no = a.disp_no  AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ) + NVL ((SELECT SUM (returned_qty)  FROM ph_ward_return_dtl  WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch  AND store_acknowledge_status IS NULL),  0 ) ) returnable  FROM ph_disp_dtl c, ph_disp_hdr b, ph_disp_drug_batch a WHERE a.facility_id = c.facility_id  AND c.facility_id = b.facility_id and a.disp_no = B.DISP_NO AND a.disp_no = c.disp_no AND b.disp_no = c.disp_no AND a.srl_no = c.srl_no  AND b.patient_id=? AND a.facility_id = ? AND c.order_id = ? AND a.disp_locn_code = NVL (?, a.disp_locn_code)  AND a.disp_qty <> NVL (a.returned_qty, 0)"; 

			//String SQL  = "SELECT a.disp_qty, a.disp_qty - (  NVL (a.returned_qty, 0) + NVL ((SELECT SUM (rej_qty)  FROM ph_ward_return_dtl WHERE disp_no = a.disp_no  AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ) + NVL ((SELECT SUM (returned_qty)  FROM ph_ward_return_dtl  WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch  AND store_acknowledge_status IS NULL),  0 ) ) returnable  FROM ph_disp_dtl c, ph_disp_hdr b, ph_disp_drug_batch a WHERE a.facility_id = c.facility_id  AND c.facility_id = b.facility_id and a.disp_no = B.DISP_NO AND a.disp_no = c.disp_no AND b.disp_no = c.disp_no AND a.srl_no = c.srl_no  AND b.patient_id=? AND a.facility_id = ? AND c.order_id = ? AND a.disp_locn_code = NVL (?, a.disp_locn_code)  AND a.disp_qty <> NVL (a.returned_qty, 0)"; 

			String SQL  = "SELECT a.disp_qty, a.disp_qty - (  NVL (a.returned_qty, 0) + NVL ((SELECT SUM (rej_qty)  FROM ph_ward_return_dtl WHERE disp_no = a.disp_no  AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch and order_id=c.ORDER_ID and facility_id=a.facility_id), 0 ) + NVL ((SELECT SUM (returned_qty)  FROM ph_ward_return_dtl  WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch  and order_id=c.ORDER_ID and facility_id=a.facility_id AND store_acknowledge_status IS NULL ),  0 ) ) returnable  FROM ph_disp_dtl c, ph_disp_hdr b, ph_disp_drug_batch a WHERE a.facility_id = c.facility_id  AND c.facility_id = b.facility_id and a.disp_no = B.DISP_NO AND a.disp_no = c.disp_no AND b.disp_no = c.disp_no AND a.srl_no = c.srl_no  AND b.patient_id=? AND a.facility_id = ? AND c.order_id = ? AND a.disp_locn_code = NVL (?, a.disp_locn_code)  AND a.disp_qty <> NVL (a.returned_qty, 0)";

			//query modified for performance SKR-SCF-1487 //GHL-SCF-1705 (tuned with and order_id=c.ORDER_ID and facility_id=a.facility_id  and additionally index(
			pstmt			= connection.prepareStatement(SQL) ;
			pstmt.setString(1,patient_id.trim());
			pstmt.setString(2,facility_id);	
			pstmt.setString(3,order_id);
			pstmt.setString(4,disp_location.trim());
			//pstmt.setString(5,locale.trim()); //commented for SKR-SCF-1487
			//pstmt.setString(6,locale);       //commented for SKR-SCF-1487
System.err.println("SKR-SCF-1705 tuned MAR Batch Query ---"+SQL+"===patient_id="+patient_id+"===facility_id=="+facility_id+"==order_id="+order_id+"==disp_location=="+disp_location);
			resultSet		= pstmt.executeQuery();
System.err.println("SKR-SCF-1705 tuned MAR Batch Query After Exceution");
			if(resultSet!=null && resultSet.next()){
				wardQty.add(resultSet.getFloat("disp_qty"));	
				wardQty.add(resultSet.getFloat("returnable"));
			}
		}
		catch (Exception execption)	{
			execption.printStackTrace();
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		return wardQty;
	}

	public String getUserAuthPINYN(String facility_id) throws Exception{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String userAuthPINYN= "N";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("SELECT MAR_AUTH_REQD_YN FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?") ;
			pstmt.setString(1,facility_id);
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				userAuthPINYN = checkForNull(resultSet.getString("MAR_AUTH_REQD_YN"),"N");
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

	public String getPractId(String user_id) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String pract_id= user_id;
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("SELECT FUNC_ROLE_ID FROM sm_appl_user WHERE APPL_USER_ID=?") ;
			pstmt.setString(1,user_id);
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				pract_id = checkForNull(resultSet.getString("FUNC_ROLE_ID"),user_id);
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
			catch ( Exception e ) {
				e.printStackTrace() ;
			}
		}
		return pract_id;
	}

	public ArrayList getAllergydetail(String patient_id){//Added for SKR-CRF-0037 [IN:037656]
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList alAllergyList = new ArrayList();
		int allergyCount=0;
		try{
			connection		= getConnection() ;
			String sql_query		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT89A");

			pstmt			= connection.prepareStatement(sql_query) ;
			pstmt.setString(1, locale);
			pstmt.setString(2, locale);
			pstmt.setString(3, locale);
			pstmt.setString(4, patient_id);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null){
				while(resultSet.next()){
					if(allergyCount>3)
						break;
					alAllergyList.add(checkForNull(resultSet.getString("ALLERGEN")));
					allergyCount++;
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
		return alAllergyList;
	}

	public HashMap getDrugDetailsSchLevel(String encounter_id,String hold_discontinue_yn,String administration_status,String order_type, String adminFromDateTime, String adminToDateTime, String display_order_by,String route_admin,String admin_rout_categ,String from_date,String to_date) {
		HashMap drug_details						= new HashMap();
		HashMap prescribe_mode						= new HashMap();
//		ArrayList iv_drug_details					= new ArrayList();  Removed for IN063877
//		ArrayList non_iv_drug_details				= new ArrayList();  Removed for IN063877
		LinkedHashMap hmIVDrugDetails = new LinkedHashMap();
		LinkedHashMap hmNonIVDrugDetails = new LinkedHashMap();
		ArrayList alOrderSchDetail = new ArrayList();//MMS-KH-CRF-0017.1
		ArrayList alTmpOrderSchDetail = new ArrayList();
		Set<String> uniqueSchedules = new LinkedHashSet<String>();
		HashMap hmSchList = new HashMap();

		Connection connection						= null;
        PreparedStatement pstmt						= null;
		PreparedStatement pstmt_select_drug_count	= null;
		PreparedStatement pstmt_ext_drug_code		= null;
		//PreparedStatement pstmt_route_code			= null; //Commented for Check Style Report.
        ResultSet resultSet							= null;
		//ResultSet resultSet_1						= null;  Removed for IN063877
		ResultSet resultSet_drug_count				= null;
		ResultSet resultSet_ext_drug_code			= null;
		//ResultSet resultSet_route_code				= null;  Removed for IN063877		
		String appendString							="";
		String strQuery								="";
		String iv_prep_yn							="";
		String prn_remarks							="";
		String Slidingscale_remarks					="";
		String action_seq_num						="";
		String order_line_seq_num					="";
		String ext_prod_id							="";
		String drugCode								="";
		String str_date								="";
		String order_id								="";
		String drug_count							="1";
		String imageFileURL							="";
		String order_line_num						="";
		String trade_code							="";
		String display_order_str					="";
		String administered="", order_by_str="", orderKey="", admin_rec_date="";
		locale = getLanguageId()==null?"en":getLanguageId();
		DrugTradeImageBean Imagebean = new DrugTradeImageBean();
		ArrayList PostAdminDtls;
		HashMap tmpIVDrugFluidDtls = null;
		ArrayList tmpAlSchList = null;
		int max_dosage_seq_no = 0, dosage_seq_no=0;

		if(display_order_by.equals("D")){
			display_order_str = " decode(e.iv_prep_yn, null, drug_desc ||D.ORDER_ID|| D.ORDER_LINE_NUM, e.ORD_DATE_TIME||D.ORDER_ID||D.ORDER_LINE_NUM)";
		}
		else if(display_order_by.equals("F")){
			if(order_type.equals("TPN"))
				display_order_str = " D.ORDER_ID||D.ORDER_LINE_NUM";
			else
				display_order_str = " decode(e.iv_prep_yn, null,  form_desc||D.ORDER_ID||D.ORDER_LINE_NUM, e.ORD_DATE_TIME||D.ORDER_ID||D.ORDER_LINE_NUM)";
		}
		else { 
			display_order_str = " e.ORD_DATE_TIME||D.ORDER_ID||D.ORDER_LINE_NUM";
			//display_order_str = " e.ORD_DATE_TIME, DECODE(E.IV_PREP_YN,'1', D.ORDER_ID || to_char(a.sch_date_time,'yyyymmddhh24:mi'),'3', D.ORDER_ID || to_char(a.sch_date_time,'yyyymmddhh24:mi'),'9', D.ORDER_ID || to_char(a.sch_date_time,'yyyymmddhh24:mi'),D.ORDER_ID), D.ORDER_LINE_NUM ";
		}		

		try{//PLACED_FROM_VERBAL_ORDER added for ghl-crf-0509
			connection = getConnection() ;
			if(order_type.equals("TPN")){//could_admin_reason ADDED FOR MMS-KH-CRF-0010
				strQuery ="SELECT a.order_id,a.cancel_recorded_yn,a.order_line_num, e.iv_prep_yn, a.admin_recorded_by username, a.admin_authorized_by authorized_by, a.admin_remarks, a.non_admin_remarks, a.admin_recorded_yn, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN (   f.admin_drug_code || ':' || (SELECT long_name FROM ph_tpn_regimen_lang_vw ph_tpn_regimen WHERE tpn_regimen_code = f.admin_drug_code AND language_id = ?) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) WHEN a.ord_drug_code = 'FINAL PRODUCT' and nvl(administered_yn,'N') = 'Y' then 'FINAL PRODUCT:'||((SELECT mfg_unit FROM ph_tpn_worksheet_hdr WHERE tpn_worksheet_id = (SELECT DISTINCT tpn_worksheet_id FROM ph_tpn_worksheet_dtl WHERE order_id = (SELECT DISTINCT order_id FROM ph_medn_admin WHERE order_id = a.order_id and order_line_num = a.order_line_num and nvl(administered_yn,'N' ) = 'Y'))) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code) END ) administereddrug, a.dosage_seq_no, (select Max(dosage_seq_no) from ph_medn_admin where order_id=a.order_id and ORD_DRUG_CODE = a.ORD_DRUG_CODE and facility_id=a.facility_id and encounter_id= a.encounter_id  ) max_dosage_seq_no, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY HH24:MI') sch_date_time, a.admin_recorded_yn, a.administered_yn, a.verify_reqd_yn, a.verification_status, a.medn_admin_status, NVL (a.iv_admin_yn, 'N') iv_admin_yn, DECODE (d.disc_date_time, NULL, 'N', 'Y') discontinued, TO_CHAR (d.disc_date_time, 'DD/MM/YYYY HH24:MI') ORD_DISC_DATE_TIME, DECODE (d.hold_date_time, NULL, 'N', 'Y') held, TO_CHAR (d.HOLD_DATE_TIME, 'DD/MM/YYYY HH24:MI') ORD_HOLD_DATE_TIME, a.patient_id, a.pract_id, d.qty_value, d.qty_unit, d.freq_code, NVL ((SELECT disp_drug_code FROM ph_disp_dtl WHERE ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND ROWNUM < 2), (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.long_name ELSE 'FINAL PRODUCT' END ) ) drug_code,(CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.tpn_regimen_code ELSE 'FINAL PRODUCT' END ) pres_drug_code,(CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT long_name FROM ph_tpn_regimen_lang_vw  ph_tpn_regimen, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_tpn_regimen.tpn_regimen_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2), b.long_name ) ELSE (SELECT mfg_unit FROM ph_tpn_worksheet_hdr HDR WHERE EXISTS ( SELECT distinct tpn_worksheet_id FROM ph_tpn_worksheet_dtl b WHERE order_id = (SELECT DISTINCT order_id FROM ph_medn_admin WHERE order_id = a.order_id AND order_line_num = a.order_line_num) AND b.tpn_worksheet_id = HDR.tpn_worksheet_id)AND ROWNUM<2) END ) drug_desc, round(NVL(d.ORDER_QTY,0)-(NVL(i.TOT_ADMINISTERED_QTY,0)),4) sch_dosage_qty , NVL (f.admin_dosage_qty, sch_dosage_qty) qty,  am_get_desc.am_uom(a.sch_dosage_uom_code,?,2) short_desc, a.iv_ingrediants, a.sch_infusion_rate, am_get_desc.am_uom(a.sch_infusion_vol_str_unit, ? , 2 ) sch_infusion_vol_str_unit_desc, sch_infusion_vol_str_unit, a.sch_infusion_per_unit, a.sch_infusion_period, a.sch_infusion_period_unit, TO_CHAR (a.admin_date_time, 'DD/MM/YYYY HH24:MI') admin_date_time, TO_CHAR (a.modified_date, 'DD/MM/YYYY HH24:MI') modified_date, b.drug_class, b.item_code itemcode, TO_CHAR (d.start_date_time, 'DD/MM/YYYY HH24:MI') start_date_time, TO_CHAR (d.end_date_time, 'DD/MM/YYYY HH24:MI') end_date_time, f.batch_id, TO_CHAR (f.expiry_date, 'DD/MM/YYYY') expiry_date, f.item_code, f.trade_id tradeid, am_get_desc.AM_TRADE_NAME(f.trade_id,?,2) tradename, h.freq_nature, h.FREQ_DESC, TO_CHAR (a.against_schdose_date_time, 'DD/MM/YYYY HH24:MI' ) against_schdose_date_time, a.adr_reason_code, a.adr_remarks, TO_CHAR (a.adr_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) adr_recorded_date_time, a.adr_recorded_by, i.prescribed_mode,d.route_code, b.PRES_CATG_CODE , am_get_desc.am_uom(d.qty_unit,?,2) schedule_uom_desc,a.sch_dosage_uom_code sch_dosage_uom_code,o.PATIENT_BROUGHT_MEDICATION_YN,o.SLIDING_SCALE_YN sliding_scale_yn,a.MEDN_BROUGHT_BY_PATIENT_YN,o.DOSAGE_TYPE, i.DOSAGE, i.DOSAGE_UOM_CODE, am_get_desc.am_uom(i.dosage_uom_code,?,2) dosage_uom_desc,A.ADMN_DOSE_CHNG_REMARKS,e.PERFORMING_DEPTLOC_CODE,b.PRES_BASE_UNIT pres_base_uom, e.ORD_PRACT_ID, o.trade_code trade_code, ROUTE.ROUTE_DESC, ROUTE.ROUTE_COLOR, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY') sch_date, TO_CHAR (a.sch_date_time, 'HH24:MI') sch_time, (select 'Y' from dual where a.sch_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')) SCHCANADMIN, o.SPLIT_DOSE_YN, f.srl_no, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN (SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code <> ph_disp_dtl.pres_drug_code AND ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2) ELSE (SELECT mfg_unit FROM ph_worksheet_hdr WHERE order_id = a.order_id AND ROWNUM < 2) END ) dispensed_drug_desc, i.DISPENSED_DRUGS,(SELECT drug_code FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code<>ph_disp_dtl.pres_drug_code and ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2 ) disp_drug_code,e.patient_class,O.PLACED_FROM_VERBAL_ORDER,MFR_YN, MFR_REMARKS,(SELECT  reason_desc FROM ph_medn_trn_reason_lang_vw ph_medn_trn_reason WHERE appl_trn_type='M' and reason_code = a.NON_ADMIN_CODE AND language_id = 'en') could_admin_reason FROM ph_medn_admin a, ph_tpn_regimen_lang_vw b, or_order_line d, or_order e, ph_medn_admin_dtl f, am_frequency_lang_vw h, ph_patient_drug_profile i, or_order_line_ph o, PH_ROUTE_LANG_VW route WHERE h.freq_code = d.freq_code AND f.encounter_id(+) = a.encounter_id AND f.order_id(+) = a.order_id AND f.facility_id(+) = a.facility_id AND f.ord_drug_code(+) = a.ord_drug_code AND a.dosage_seq_no = f.dosage_seq_no(+) AND f.sch_date_time(+) = a.sch_date_time AND e.order_id = d.order_id AND o.order_id = d.order_id AND o.order_line_num = d.order_line_num AND i.orig_order_id = d.order_id AND i.orig_order_line_no = d.order_line_num AND e.order_id = i.orig_order_id AND a.ord_drug_code = b.tpn_regimen_code(+) AND a.order_id = d.order_id AND a.order_line_num = d.order_line_num AND a.facility_id =? AND a.encounter_id =? AND a.sch_date_time >= d.START_DATE_TIME AND SYSDATE <= d.end_date_time AND d.can_date_time IS NULL AND e.iv_prep_yn IN ('7','8') AND b.language_id(+) = ? AND D.ROUTE_CODE(+) = ROUTE.ROUTE_CODE and ROUTE.LANGUAGE_ID(+) = ? and h.language_id(+)=? and d.ORDER_LINE_STATUS not in ('PO', 'PS') "; //and d.ORDER_LINE_STATUS not in ('PO', 'PS')  added for ML-MMOH-SCF-0321 [IN:058617]
				////e.patient_class added for GHL-CRF-0458
			}
			else{// CANCEL_RECORDED_YN ADDED  FOR JD-CRF-0200 could_admin_reason ADDED FOR MMS-KH-CRF-0010
				strQuery = "SELECT /*+ INDEX(d or_order_line_pk*/ a.order_id,a.cancel_recorded_yn, a.order_line_num, e.iv_prep_yn, a.admin_recorded_by username, a.admin_authorized_by authorized_by, a.admin_remarks, a.non_admin_remarks, a.admin_recorded_yn, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN ( f.admin_drug_code || ':' || (SELECT drug_desc FROM ph_drug_lang_vw ph_drug WHERE drug_code = f.admin_drug_code AND language_id = ?) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) WHEN a.ord_drug_code = 'FINAL PRODUCT' AND NVL (administered_yn, 'N') = 'Y' THEN 'FINAL PRODUCT:' || ( (SELECT mfg_unit FROM ph_worksheet_hdr WHERE order_id = a.order_id AND ROWNUM<2 ) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) END ) administereddrug, a.dosage_seq_no, (select Max(dosage_seq_no) from ph_medn_admin where order_id=a.order_id and ORD_DRUG_CODE = a.ORD_DRUG_CODE and facility_id=a.facility_id and encounter_id= a.encounter_id  ) max_dosage_seq_no, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY HH24:MI') sch_date_time, a.administered_yn, a.verify_reqd_yn, a.verification_status, a.medn_admin_status, NVL (a.iv_admin_yn, 'N') iv_admin_yn, DECODE (d.disc_date_time, NULL, 'N', 'Y') discontinued,TO_CHAR (d.disc_date_time, 'DD/MM/YYYY HH24:MI') ORD_DISC_DATE_TIME, DECODE (d.hold_date_time, NULL, 'N', 'Y') held, TO_CHAR (d.HOLD_DATE_TIME, 'DD/MM/YYYY HH24:MI') ORD_HOLD_DATE_TIME,  a.patient_id, a.pract_id, d.qty_value, d.qty_unit, d.freq_code, NVL ((SELECT disp_drug_code FROM ph_disp_dtl WHERE ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND ROWNUM < 2), (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.drug_code ELSE 'FINAL PRODUCT' END ) ) drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.drug_code ELSE 'FINAL PRODUCT' END ) pres_drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT drug_desc FROM ph_drug_lang_vw ph_drug WHERE A.ORD_DRUG_CODE =  ph_drug.drug_code AND language_id = ? AND ROWNUM < 2 ), b.drug_desc ) ELSE (SELECT mfg_unit FROM ph_worksheet_hdr WHERE order_id = a.order_id AND ROWNUM<2 ) END ) drug_desc, round(NVL(d.ORDER_QTY,0)-(NVL(i.TOT_ADMINISTERED_QTY,0)),4) sch_dosage_qty, NVL (f.admin_dosage_qty, sch_dosage_qty) qty, am_get_desc.am_uom(a.sch_dosage_uom_code,?,2) short_desc, b.disp_multi_strength_yn, a.iv_ingrediants, a.sch_infusion_rate, am_get_desc.am_uom(a.sch_infusion_vol_str_unit, ? , 2 ) sch_infusion_vol_str_unit_desc ,sch_infusion_vol_str_unit , a.sch_infusion_per_unit, a.sch_infusion_period, a.sch_infusion_period_unit, TO_CHAR (a.admin_date_time, 'DD/MM/YYYY HH24:MI') admin_date_time, TO_CHAR (a.modified_date, 'DD/MM/YYYY HH24:MI') modified_date, b.drug_class, b.item_code itemcode, TO_CHAR (d.start_date_time, 'DD/MM/YYYY HH24:MI') start_date_time, TO_CHAR (d.end_date_time, 'DD/MM/YYYY HH24:MI') end_date_time, f.batch_id, TO_CHAR (f.expiry_date, 'DD/MM/YYYY') expiry_date, f.item_code, f.trade_id tradeid, am_get_desc.AM_TRADE_NAME(f.trade_id,?,2) tradename, h.freq_nature, h.FREQ_DESC , TO_CHAR (a.against_schdose_date_time, 'DD/MM/YYYY HH24:MI' ) against_schdose_date_time, a.adr_reason_code, a.adr_remarks, TO_CHAR (a.adr_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) adr_recorded_date_time, a.adr_recorded_by, i.prescribed_mode,B.MEDN_ADMN_DTL_REQD_YN, i.PRN_REMARKS, i.SLIDING_SCALE_REMARKS, k.order_line_seq_num, d.route_code, b.PRES_CATG_CODE,am_get_desc.am_uom(d.qty_unit,?,2) schedule_uom_desc, a.sch_dosage_uom_code sch_dosage_uom_code, ph_get_desc.PH_FORM(b.form_code,?,1) form_desc,o.PATIENT_BROUGHT_MEDICATION_YN ,o.SLIDING_SCALE_YN sliding_scale_yn, b.STRENGTH_VALUE, a.SCH_STRENGTH, a.SCH_STRENGTH_UOM, am_get_desc.am_uom(a.sch_strength_uom,?,2) sch_strength_uom_desc, a.MEDN_BROUGHT_BY_PATIENT_YN,o.DOSAGE_TYPE, i.DOSAGE, i.DOSAGE_UOM_CODE, am_get_desc.am_uom(i.dosage_uom_code,?,2) dosage_uom_desc,b.CONTENT_IN_PRES_BASE_UOM,A.ADMN_DOSE_CHNG_REMARKS, ca_get_vaccine_sche_details(a.patient_id,NVL ((SELECT disp_drug_code FROM ph_disp_dtl WHERE ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND ROWNUM < 2),(CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.drug_code ELSE 'FINAL PRODUCT' END)),b.language_id) VACC_CATEGORY_LINK,o.MFR_YN, a.FLOW_STATUS,a.COMPLETED_DURN_IN_MINS,a.COMPLETED_VOLUME, TO_CHAR (a.HOLD_DATE_TIME, 'DD/MM/YYYY HH24:MI') HOLD_DATE_TIME, a.HOLD_DURN_IN_MINS,TO_CHAR (a.RESUME_DATE_TIME, 'DD/MM/YYYY HH24:MI') RESUME_DATE_TIME, TO_CHAR (a.ACT_START_DATE_TIME, 'DD/MM/YYYY HH24:MI') ACT_START_DATE_TIME, TO_CHAR (a.ACT_END_DATE_TIME, 'DD/MM/YYYY HH24:MI') ACT_END_DATE_TIME,o.MFR_REMARKS,e.PERFORMING_DEPTLOC_CODE,b.pres_base_uom, e.ORD_PRACT_ID, o.trade_code trade_code, ROUTE.ROUTE_DESC, ROUTE.ROUTE_COLOR, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY') sch_date, TO_CHAR (a.sch_date_time, 'HH24:MI') sch_time , (select 'Y' from dual where a.sch_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')) SCHCANADMIN, o.SPLIT_DOSE_YN, f.srl_no, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN (SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code <> ph_disp_dtl.pres_drug_code AND ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2) ELSE (SELECT mfg_unit FROM ph_worksheet_hdr WHERE order_id = a.order_id AND ROWNUM < 2) END ) dispensed_drug_desc, i.DISPENSED_DRUGS,(SELECT drug_code FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code<>ph_disp_dtl.pres_drug_code and ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2 ) disp_drug_code,b.generic_id,e.patient_class,O.PLACED_FROM_VERBAL_ORDER,e.order_status, PATIENT_STOCK_REQUIRED,i.PATIENT_STOCK_COMPLETED,i.PATIENT_STOCK_YN,(SELECT  reason_desc FROM ph_medn_trn_reason_lang_vw ph_medn_trn_reason WHERE appl_trn_type='M' and reason_code = a.NON_ADMIN_CODE AND language_id = 'en') could_admin_reason FROM ph_medn_admin a, ph_drug_lang_vw b, or_order_line d, or_order e, ph_medn_admin_dtl f, am_frequency_lang_vw h, ph_patient_drug_profile i,  or_order_line_field_values k, or_order_line_ph o, PH_ROUTE_LANG_VW route WHERE h.freq_code = d.freq_code AND f.encounter_id(+) = a.encounter_id AND f.facility_id(+) = a.facility_id AND f.ord_drug_code(+) = a.ord_drug_code  AND a.dosage_seq_no = f.dosage_seq_no(+) AND f.sch_date_time(+) = a.sch_date_time AND f.order_id(+) = a.order_id AND e.order_id = d.order_id AND i.orig_order_id = d.order_id AND o.order_id = d.order_id AND o.order_line_num = d.order_line_num AND i.orig_order_line_no = d.order_line_num AND e.order_id = i.orig_order_id AND a.ord_drug_code = b.drug_code(+) AND a.order_id = d.order_id AND a.order_line_num = d.order_line_num AND a.order_id = k.order_id(+) and a.order_line_num = k.order_line_num(+) and k.order_line_seq_num(+) = 1 AND a.facility_id = ? AND a.encounter_id = ? AND a.sch_date_time >= d.START_DATE_TIME AND d.can_date_time IS NULL  AND b.language_id(+)=? AND D.ROUTE_CODE(+) = ROUTE.ROUTE_CODE and ROUTE.LANGUAGE_ID(+) = ? and h.language_id(+)=? and d.ORDER_LINE_STATUS not in ('PO', 'PS','PQ') "; //and d.ORDER_LINE_STATUS not in ('PO', 'PS')  added for ML-MMOH-SCF-0321 [IN:058617] //Added ORDER_LINE_STATUS not in ('PO', 'PS','PQ') 'PQ' for ML-MMOH-CRF-1823-US008 
				//e.patient_class added for GHL-CRF-0458
				//e.order_status, PATIENT_STOCK_REQUIRED,i.PATIENT_STOCK_COMPLETED,i.PATIENT_STOCK_YN added for GHL-CRF-0482
			}

			if(order_type !=null && order_type.equals("Rx")){
				appendString = " AND E.IV_PREP_YN IS NULL ";
			} 
			else if(order_type !=null && order_type.equals("IVRx")){
				appendString = " AND E.IV_PREP_YN IN ('1','2','3','4','5') ";
			} 
			else if(order_type !=null && order_type.equals("COMP")){
				appendString = " AND E.IV_PREP_YN = '6' ";
			}
			else if(order_type !=null && order_type.equals("STAT")){
				appendString = " AND H.FREQ_NATURE = 'O' ";
			}
			else if(order_type !=null && order_type.equals("PRN")){  
				//appendString = "and d.start_date_time <  TO_DATE('"+to_time+"','DD/MM/YYYY') AND SYSDATE<=D.END_DATE_TIME+((select nvl(REC_ADMIN_WITHIN_HRS,1) from ph_facility_param where facility_id ='"+login_facility_id+"')/24) AND H.FREQ_NATURE = 'P' "; 
				appendString = " AND H.FREQ_NATURE = 'P' "; 
			}
			else if(order_type !=null && order_type.equals("CYTO")){  
				appendString = "  AND E.IV_PREP_YN IN ('0','9') ";
			} 
			else if(order_type !=null && order_type.equals("A")){  
				appendString = "  AND (E.IV_PREP_YN IS NULL OR E.IV_PREP_YN IN ('0','1','2','3','4','5','6','9')) ";
			}
			
			appendString = appendString + "AND ( (trunc(a.sch_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')) OR ( ( h.freq_nature = 'P' and a.order_id not in ( select order_id from ph_medn_admin where order_id=a.order_id and order_line_num= a.order_line_num and TRUNC (sch_date_time) BETWEEN TO_DATE (?, 'DD/MM/YYYY' ) AND TO_DATE (?, 'DD/MM/YYYY' ) ) ) and H.FREQ_NATURE='P'  and TRUNC(d.end_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY'))) ";  //Added for SKR-SCF-0836 [IN:044162]
			//appendString = appendString + "AND ( (trunc(a.sch_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')) OR (H.FREQ_NATURE='P'  and TRUNC(d.start_date_time) <  TO_DATE('"+to_date+"','DD/MM/YYYY') /* AND (D.ORDER_QTY-NVL(I.TOT_ADMINISTERED_QTY,0))>0 */) ) ";  //Commneted for SKR-SCF-0836 [IN:044162]
			if(!order_type.equals("TPN")){
				if(!route_admin.equals("")){
					appendString = appendString+"AND d.route_code ='"+route_admin+"' ";
				}
				else if(!admin_rout_categ.equals("")){
					ArrayList admRoutes=getAdminRoute(admin_rout_categ.trim());
					String aString="";
					for(int index=0;index<admRoutes.size();index+=2){
						aString=aString+"'"+admRoutes.get(index)+"',";
					}
					if(!aString.equals(""))
						aString=aString.substring(0,(aString.length()-1));
					else
						aString="''";
					appendString=appendString+" and d.ROUTE_CODE IN("+aString+")";					
				}
			}

			if(!hold_discontinue_yn.equals("Y")){
				appendString = appendString + "AND d.HOLD_DATE_TIME IS NULL AND DISC_DATE_TIME IS NULL AND CAN_DATE_TIME IS NULL";	
			}			
			//order_by_str= " ORDER BY E.IV_PREP_YN, DECODE(E.IV_PREP_YN,'1',to_char(a.sch_date_time,'yyyymmddhh24:mi')||D.ORDER_ID||to_char(D.ORDER_LINE_NUM),'3',to_char(a.sch_date_time,'yyyymmddhh24:mi')||D.ORDER_ID||to_char(D.ORDER_LINE_NUM),'9',to_char(a.sch_date_time,'yyyymmddhh24:mi')||D.ORDER_ID||to_char(D.ORDER_LINE_NUM), "+display_order_str+" ),sch_time, to_date(sch_date,'dd/mm/yyyy')";
			order_by_str= " ORDER BY E.IV_PREP_YN, "+display_order_str+", decode (h.freq_nature,  'P', '', sch_time), a.DOSAGE_SEQ_NO, to_date(sch_date,'dd/mm/yyyy')"; //order by changed for AAKH-SCF-0242 [IN:058494] from a.DOSAGE_SEQ_NO, decode (h.freq_nature,  'P', '', sch_time), to_date(sch_date,'dd/mm/yyyy')
			strQuery = strQuery + appendString + order_by_str;
			pstmt_select_drug_count = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT_DRUGS_COUNT") ) ; 
			pstmt = connection.prepareStatement( strQuery ) ;
            int index=0;
			pstmt.setString(++index,locale ); //1
			pstmt.setString(++index,locale );
			pstmt.setString(++index,locale );
			pstmt.setString(++index,locale );
			pstmt.setString(++index,locale );
			pstmt.setString(++index,locale );
			pstmt.setString(++index,locale );	//7
			if(!order_type.equals("TPN")){				
				pstmt.setString(++index,locale );	//8
				pstmt.setString(++index,locale );
			}
			pstmt.setString(++index,adminFromDateTime );//8 or 10
			pstmt.setString(++index,adminToDateTime );	
			pstmt.setString(++index,locale );//12 or 14
			pstmt.setString(++index,locale );
			pstmt.setString(++index,login_facility_id);	//14 or 16
			pstmt.setString(++index,encounter_id.trim());			
			pstmt.setString(++index,locale );
			pstmt.setString(++index,locale );
			pstmt.setString(++index,locale );
			pstmt.setString(++index,from_date );//19 or 21
			pstmt.setString(++index,to_date );	
			pstmt.setString(++index,from_date );
			pstmt.setString(++index,to_date );	//22 or 24
			pstmt.setString(++index,from_date );
			pstmt.setString(++index,to_date );	//24 or 26

			resultSet = pstmt.executeQuery() ;
			pstmt_ext_drug_code				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_EXT_PRODUCT_ID")) ;
			while ( resultSet != null && resultSet.next() ) {
				alOrderSchDetail = new ArrayList();
				drug_count = "1";
				ext_prod_id = "";
				iv_prep_yn =checkForNull(resultSet.getString("IV_PREP_YN"));
				drugCode = checkForNull(resultSet.getString("DRUG_CODE"));
				order_id = checkForNull(resultSet.getString("ORDER_ID"));
				setOrderPatientClass(order_id,resultSet.getString("patient_class"));//GHL-CRF-0458
				if(!order_type.equals("TPN")&& !iv_prep_yn.equals("6")){
					pstmt_ext_drug_code.setString(1,drugCode);
					pstmt_ext_drug_code.setString(2,login_facility_id);
					resultSet_ext_drug_code			= pstmt_ext_drug_code.executeQuery();
					if(resultSet_ext_drug_code!=null && resultSet_ext_drug_code.next()){
						ext_prod_id = resultSet_ext_drug_code.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet_ext_drug_code.getString("EXTERNAL_PRODUCT_ID");
					}
					try{
						closeResultSet( resultSet_ext_drug_code ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}
				}
				if(iv_prep_yn.equals("")||iv_prep_yn.equals("1")||iv_prep_yn.equals("3")||iv_prep_yn.equals("5")||iv_prep_yn.equals("9")){
					
					trade_code = checkForNull(resultSet.getString("TRADE_CODE"));
					imageFileURL = Imagebean.getImagePath(drugCode,trade_code,connection);
				}
				else
					imageFileURL = "";
				if(iv_prep_yn.equals("")||iv_prep_yn.equals("0")||iv_prep_yn.equals("6")||iv_prep_yn.equals("7")||iv_prep_yn.equals("8")||iv_prep_yn.equals("9")){
					orderKey = resultSet.getString("ORDER_ID")+"_"+resultSet.getString("ORDER_LINE_NUM");
					alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_CODE")));//1
					alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_DESC")));//2
					alOrderSchDetail.add(checkForNull(resultSet.getString("QTY")));//3
					alOrderSchDetail.add(checkForNull(resultSet.getString("SHORT_DESC")));	//4				
					alOrderSchDetail.add(checkForNull(resultSet.getString("BATCH_ID")));//5
					str_date= resultSet.getString("EXPIRY_DATE");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
					}
					alOrderSchDetail.add(checkForNull(str_date)); //6
					alOrderSchDetail.add(checkForNull(resultSet.getString("TRADENAME")));//7
					alOrderSchDetail.add(checkForNull(resultSet.getString("ITEMCODE")));//8
					if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8")){
						alOrderSchDetail.add("");//9
					}
					else{
						alOrderSchDetail.add(checkForNull(resultSet.getString("DISP_MULTI_STRENGTH_YN")));//9
					}
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_RECORDED_YN")));//10
					alOrderSchDetail.add(checkForNull(resultSet.getString("VERIFY_REQD_YN")));//11
					alOrderSchDetail.add(checkForNull(resultSet.getString("VERIFICATION_STATUS")));//12
					alOrderSchDetail.add(checkForNull(resultSet.getString("MEDN_ADMIN_STATUS")));//13
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_ID")));	//14				
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));	//15				
					alOrderSchDetail.add(checkForNull(resultSet.getString("PATIENT_ID")));//16

					str_date= resultSet.getString("SCH_DATE_TIME");
					if(iv_prep_yn.equals("9")){
						pstmt_select_drug_count.setString(1,order_id);
						pstmt_select_drug_count.setString(2,str_date);
						resultSet_drug_count = pstmt_select_drug_count.executeQuery();
						if(resultSet_drug_count!=null && resultSet_drug_count.next())
							drug_count = resultSet_drug_count.getString("NO_OF_DRUGS");
						closeResultSet(resultSet_drug_count);
					}
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(checkForNull(str_date)); //17
					alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));//18
					alOrderSchDetail.add(checkForNull(resultSet.getString("TRADEID")));//19
					alOrderSchDetail.add(checkForNull(resultSet.getString("DISCONTINUED")));//20
					alOrderSchDetail.add(checkForNull(resultSet.getString("HELD")));		//21			
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMINISTERED_YN")));//22
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_RECORDED_YN")));//23
					administered = checkForNull(resultSet.getString("ADMINISTERED_YN"));

					if(administered.equals("N")){
						alOrderSchDetail.add(checkForNull(resultSet.getString("NON_ADMIN_REMARKS")));//24
					}
					else if(administered.equals("Y")){
						alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_REMARKS")));//24
					}
					else{
						alOrderSchDetail.add("");//24
					}
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMINISTEREDDRUG")));		//25	
					alOrderSchDetail.add(checkForNull(resultSet.getString("USERNAME")));//26

					str_date= resultSet.getString("ADMIN_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(checkForNull(str_date));//27

					alOrderSchDetail.add(checkForNull(resultSet.getString("MODIFIED_DATE"))); //28
					alOrderSchDetail.add(checkForNull(resultSet.getString("PRES_DRUG_CODE")));//29
					alOrderSchDetail.add(checkForNull(resultSet.getString("PERFORMING_DEPTLOC_CODE")));//30
				
					alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_CLASS")));//31
					alOrderSchDetail.add(checkForNull(resultSet.getString("AUTHORIZED_BY")));//32
					
					str_date= resultSet.getString("END_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(checkForNull(str_date));//33

					alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_CODE")));//34
					alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_NATURE")));//35
					alOrderSchDetail.add(checkForNull(resultSet.getString("SRL_NO"),"1"));//36
					alOrderSchDetail.add(checkForNull(resultSet.getString("PRACT_ID")));//37
					
					str_date= checkForNull(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(checkForNull(str_date));//38
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REASON_CODE")));//39
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REMARKS")));//40
					
					admin_rec_date= checkForNull(resultSet.getString("ADR_RECORDED_DATE_TIME"));
					if(!locale.equals("en")){
						admin_rec_date = com.ehis.util.DateUtils.convertDate(admin_rec_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(checkForNull(admin_rec_date));//41
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_RECORDED_BY")));//42

					if(!admin_rec_date.equals("")){
						PostAdminDtls = new ArrayList();
						PostAdminDtls.add(str_date);
						PostAdminDtls.add(checkForNull(resultSet.getString("ADR_REASON_CODE")));
						PostAdminDtls.add(admin_rec_date);
						PostAdminDtls.add(checkForNull(resultSet.getString("ADR_REMARKS")));
						PostAdminDtls.add(checkForNull(resultSet.getString("ADR_RECORDED_BY")));
						clearADRDetails(drugCode+"-"+str_date);
						setADRDetails(drugCode+"-"+str_date,PostAdminDtls);
						setADRReason(order_id,encounter_id,drugCode,str_date,PostAdminDtls);
					}

					alOrderSchDetail.add(checkForNull(resultSet.getString("QTY_VALUE")));//43
					alOrderSchDetail.add(checkForNull(resultSet.getString("QTY_UNIT")));//44
					alOrderSchDetail.add(checkForNull(resultSet.getString("IV_PREP_YN")));//45

					if(order_type.equals("TPN")){
						alOrderSchDetail.add("N");//46
						alOrderSchDetail.add("");//47
						alOrderSchDetail.add("");//48
						alOrderSchDetail.add("");//49
						alOrderSchDetail.add("");//50
						alOrderSchDetail.add("");//51
						alOrderSchDetail.add("");//52
						alOrderSchDetail.add("");//53
					}
					else{
					   alOrderSchDetail.add(checkForNull(resultSet.getString("MEDN_ADMN_DTL_REQD_YN")));//46

						prn_remarks				=resultSet.getString("PRN_REMARKS")==null?"":resultSet.getString("PRN_REMARKS");
						Slidingscale_remarks	=resultSet.getString("SLIDING_SCALE_REMARKS")==null?"":resultSet.getString("SLIDING_SCALE_REMARKS");
						action_seq_num			="1";
						order_line_seq_num		=resultSet.getString("order_line_seq_num")==null?"":resultSet.getString("order_line_seq_num");
						alOrderSchDetail.add(prn_remarks);//47
						alOrderSchDetail.add(Slidingscale_remarks);//48
						alOrderSchDetail.add(action_seq_num);//49
						alOrderSchDetail.add(order_line_seq_num);//50
						alOrderSchDetail.add(ext_prod_id);//51
						alOrderSchDetail.add(trade_code);//52
						alOrderSchDetail.add(imageFileURL);//53
					}
					alOrderSchDetail.add(checkForNull(resultSet.getString("IV_INGREDIANTS")));//54					
					alOrderSchDetail.add(checkForNull(resultSet.getString("ROUTE_DESC")));//55
					alOrderSchDetail.add(checkForNull(resultSet.getString("PRES_CATG_CODE")));//56
					alOrderSchDetail.add(checkForNull(resultSet.getString("schedule_uom_desc")));//57 
					alOrderSchDetail.add(checkForNull(resultSet.getString("sch_dosage_uom_code")));//58
					
					alOrderSchDetail.add(checkForNull(resultSet.getString("PATIENT_BROUGHT_MEDICATION_YN"),"N"));//59
					alOrderSchDetail.add(checkForNull(resultSet.getString("SLIDING_SCALE_YN"),"N"));//60
					if(!order_type.equals("TPN")){						
						alOrderSchDetail.add(checkForNull(resultSet.getString("STRENGTH_VALUE")));//61
						alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_STRENGTH")));//62
					}
					else{						
						alOrderSchDetail.add("");//61
						alOrderSchDetail.add("");//62						
					}
					alOrderSchDetail.add(checkForNull(resultSet.getString("MEDN_BROUGHT_BY_PATIENT_YN"),"N"));//63
					alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_TYPE"),"Q"));//64 53hello
					alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE")));//65
					alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_UOM_CODE")));//66
					alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_UOM_DESC")));//67
					if(!order_type.equals("TPN")){
						alOrderSchDetail.add(checkForNull(resultSet.getString("CONTENT_IN_PRES_BASE_UOM"),"1"));//68
						alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_STRENGTH_UOM"),""));//69
						alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_STRENGTH_UOM_DESC")));//70						
						alOrderSchDetail.add(checkForNull(resultSet.getString("ADMN_DOSE_CHNG_REMARKS"))); //71
					}
					else{
						alOrderSchDetail.add("");//68	
						alOrderSchDetail.add("");//69	
						alOrderSchDetail.add("");//70	
						alOrderSchDetail.add(checkForNull(resultSet.getString("ADMN_DOSE_CHNG_REMARKS"))); //71
					}
					alOrderSchDetail.add(checkForNull(drug_count));  //72  drug count for Oncology Direct Order
					if(!order_type.equals("TPN")){
						alOrderSchDetail.add(checkForNull(resultSet.getString("VACC_CATEGORY_LINK")));//73 linked vaccine schedule
					}
					else{
						alOrderSchDetail.add("");//73 linked vaccine schedule  
					}
					alOrderSchDetail.add(checkForNull(resultSet.getString("PERFORMING_DEPTLOC_CODE")));//74
					alOrderSchDetail.add(checkForNull(resultSet.getString("PRES_BASE_UOM")));//75

					prescribe_mode.put(resultSet.getString("ORDER_ID")+resultSet.getString("ORDER_LINE_NUM"),resultSet.getString("PRESCRIBED_MODE"));
					alOrderSchDetail.add(checkForNull(resultSet.getString("ROUTE_COLOR")));//76 route color Check RUT -CRF - 0034
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_PRACT_ID")));//77  Prescribing pract id //Added for [IN:040149]
					str_date= resultSet.getString("START_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date);//78
					alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_DESC")));//79
					alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_DATE")));//80
					alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_TIME")));//81
					alOrderSchDetail.add(checkForNull(resultSet.getString("SCHCANADMIN"),"N"));//82
					alOrderSchDetail.add(checkForNull(resultSet.getString("SPLIT_DOSE_YN")));//83
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_HOLD_DATE_TIME")));//84
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_DISC_DATE_TIME")));//85
					alOrderSchDetail.add(checkForNull(resultSet.getString("sch_dosage_qty")));//86
					alOrderSchDetail.add(checkForNull(resultSet.getString("DISPENSED_DRUG_DESC")));//87
					alOrderSchDetail.add(checkForNull(resultSet.getString("DISPENSED_DRUGS"))); //88
					alOrderSchDetail.add(checkForNull(resultSet.getString("DISP_DRUG_CODE"))); //89
					if(order_type.equals("TPN"))//if else //Added for Bru-HIMS-CRF-399 [IN:043767]
						alOrderSchDetail.add("");//90 
					else
						alOrderSchDetail.add(resultSet.getString("GENERIC_ID"));//90 
					alOrderSchDetail.add(resultSet.getString("MFR_YN"));//ML-MMOH-CRF-1014
					alOrderSchDetail.add(checkForNull(resultSet.getString("MFR_REMARKS"))); //ML-MMOH-CRF-1014
					alOrderSchDetail.add(checkForNull(resultSet.getString("PLACED_FROM_VERBAL_ORDER")));//added for ghl-crf-0509
					if(iv_prep_yn.equals("")){
						 alOrderSchDetail.add(resultSet.getString("PATIENT_STOCK_REQUIRED"));//added for GHL-CRF-0482
						 alOrderSchDetail.add(resultSet.getString("PATIENT_STOCK_COMPLETED"));//added for GHL-CRF-0482
						 alOrderSchDetail.add(resultSet.getString("PATIENT_STOCK_YN"));//added for GHL-CRF-0482
					}
					else{
						 alOrderSchDetail.add("N");//added for GHL-CRF-0482
 						 alOrderSchDetail.add("N");//added for GHL-CRF-0482
 						 alOrderSchDetail.add("N");//added for GHL-CRF-0482
					}
					alOrderSchDetail.add(checkForNull(resultSet.getString("CANCEL_RECORDED_YN")));// CANCEL_RECORDED_YN ADDED  FOR JD-CRF-0200
					alOrderSchDetail.add(checkForNull(resultSet.getString("could_admin_reason")));//added for mms-kh-crf-0010

					if(hmNonIVDrugDetails.containsKey(orderKey)){
						alTmpOrderSchDetail = (ArrayList)hmNonIVDrugDetails.get(orderKey);
						alTmpOrderSchDetail.add(alOrderSchDetail);
						hmNonIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
					}
					else{
						alTmpOrderSchDetail = new ArrayList();
						alTmpOrderSchDetail.add(alOrderSchDetail);
						hmNonIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
					}
					if(hmSchList.containsKey(orderKey+"SCH")){
						uniqueSchedules= (LinkedHashSet<String>)hmSchList.get(orderKey+"SCH");
						if(((String)resultSet.getString("FREQ_NATURE")).equals("P"))
							uniqueSchedules.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));
						else
							uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
						hmSchList.put(orderKey+"SCH", uniqueSchedules);
					}
					else{
						uniqueSchedules= new LinkedHashSet<String>();
						if(((String)resultSet.getString("FREQ_NATURE")).equals("P"))
							uniqueSchedules.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));
						else
							uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
						hmSchList.put(orderKey+"SCH", uniqueSchedules);
					}
//System.err.println("==orderKey=="+orderKey+"======SCH="+resultSet.getString("DOSAGE_SEQ_NO"));
//System.err.println("=====uniqueSchedules="+uniqueSchedules);
				}
				else{
					//if(resultSet.getString("DOSAGE_SEQ_NO").equals("1")){
					orderKey = resultSet.getString("ORDER_ID")+"_"+iv_prep_yn;
					//orderKey = resultSet.getString("ORDER_ID")+"_"+resultSet.getString("ORDER_LINE_NUM");
					order_line_num = resultSet.getString("ORDER_LINE_NUM");
					max_dosage_seq_no =Integer.parseInt( checkForNull(resultSet.getString("MAX_DOSAGE_SEQ_NO"), "1"));
					dosage_seq_no = Integer.parseInt( checkForNull(resultSet.getString("DOSAGE_SEQ_NO"),"1"));
					if(resultSet.getString("IV_PREP_YN").equals("2") || resultSet.getString("IV_PREP_YN").equals("3") || resultSet.getString("IV_PREP_YN").equals("4") || max_dosage_seq_no>= dosage_seq_no){ //resultSet.getString("IV_PREP_YN").equals("2") added for MMS-KH-CRF-0017
						if( ((resultSet.getString("IV_PREP_YN").equals("2") && max_dosage_seq_no>=dosage_seq_no)|| resultSet.getString("IV_PREP_YN").equals("4"))) {
							if(resultSet.getString("ORDER_LINE_NUM").equals("1")) {
								alOrderSchDetail.add(checkForNull(resultSet.getString("IV_INGREDIANTS")));//1
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_INFUSION_RATE")));//2
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_INFUSION_VOL_STR_UNIT")));//3  -- here the short_desc from am_uom will be displayed
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_INFUSION_PER_UNIT")));//4
								alOrderSchDetail.add(checkForNull(resultSet.getString("BATCH_ID")));//5
						
								str_date= resultSet.getString("EXPIRY_DATE");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
								}
								alOrderSchDetail.add(str_date);//6

								//alOrderSchDetail.add(resultSet.getString("EXPIRY_DATE"));
								alOrderSchDetail.add(checkForNull(resultSet.getString("TRADEID")));//7
								alOrderSchDetail.add(checkForNull(resultSet.getString("TRADENAME")));//8
								alOrderSchDetail.add(checkForNull(resultSet.getString("ITEMCODE")));//9
								alOrderSchDetail.add(checkForNull(resultSet.getString("PATIENT_ID")));//10
								alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_CODE")));//11
								alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_DESC")));//12
						
								str_date= resultSet.getString("SCH_DATE_TIME");
								order_id = resultSet.getString("ORDER_ID");
								pstmt_select_drug_count.setString(1,order_id);
								pstmt_select_drug_count.setString(2,str_date);
								resultSet_drug_count = pstmt_select_drug_count.executeQuery();
								if(resultSet_drug_count!=null && resultSet_drug_count.next())
									drug_count = resultSet_drug_count.getString("NO_OF_DRUGS");

								closeResultSet(resultSet_drug_count);

								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								alOrderSchDetail.add(str_date);//13

								alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));//14
								alOrderSchDetail.add(order_id);	//15

								alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));//16
								alOrderSchDetail.add(checkForNull(resultSet.getString("QTY")));//17
								alOrderSchDetail.add(checkForNull(resultSet.getString("SHORT_DESC")));	//18
								alOrderSchDetail.add(checkForNull(resultSet.getString("DISCONTINUED")));//19
								alOrderSchDetail.add(checkForNull(resultSet.getString("HELD")));	//20
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_INFUSION_PERIOD")));	//21
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_INFUSION_PERIOD_UNIT")));	//22
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADMINISTERED_YN")));//23
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_RECORDED_YN")));//24
								administered = checkForNull(resultSet.getString("ADMINISTERED_YN"));

								if(administered.equals("N")){
									alOrderSchDetail.add(checkForNull(resultSet.getString("NON_ADMIN_REMARKS")));//25
								}
								else if(administered.equals("Y")){
									alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_REMARKS")));//25
								}
								else{
									alOrderSchDetail.add("");//25
								}
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADMINISTEREDDRUG")));	//26
								alOrderSchDetail.add(checkForNull(resultSet.getString("USERNAME")));//27
						
								str_date= resultSet.getString("ADMIN_DATE_TIME");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								alOrderSchDetail.add(checkForNull(str_date));//28

								alOrderSchDetail.add(checkForNull(resultSet.getString("MODIFIED_DATE")));//29
								alOrderSchDetail.add(checkForNull(resultSet.getString("PRES_DRUG_CODE")));//30
								alOrderSchDetail.add(checkForNull(resultSet.getString("PERFORMING_DEPTLOC_CODE")));//31
								
								alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_CLASS")));//32
								alOrderSchDetail.add(checkForNull(resultSet.getString("AUTHORIZED_BY")));//33
						
								str_date= resultSet.getString("END_DATE_TIME");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								alOrderSchDetail.add(str_date);//34

								alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_CODE")));//35
								alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_NATURE")));//36
								alOrderSchDetail.add(checkForNull(resultSet.getString("SRL_NO"),"1"));//37
								alOrderSchDetail.add(checkForNull(resultSet.getString("PRACT_ID")));//38
						
								str_date= checkForNull(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								alOrderSchDetail.add(str_date);//39

								alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REASON_CODE")));  //40        
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REMARKS"))); //41             
						
								admin_rec_date= checkForNull(resultSet.getString("ADR_RECORDED_DATE_TIME"));
								if(!locale.equals("en")){
									admin_rec_date = com.ehis.util.DateUtils.convertDate(admin_rec_date, "DMYHM","en",locale);
								}
								alOrderSchDetail.add(admin_rec_date);//42
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_RECORDED_BY")));    //43
								if(!admin_rec_date.equals("")){
									PostAdminDtls = new ArrayList();
									PostAdminDtls.add(str_date);
									PostAdminDtls.add(checkForNull(resultSet.getString("ADR_REASON_CODE")));
									PostAdminDtls.add(admin_rec_date);
									PostAdminDtls.add(checkForNull(resultSet.getString("ADR_REMARKS")));
									PostAdminDtls.add(checkForNull(resultSet.getString("ADR_RECORDED_BY")));
									clearADRDetails(drugCode+"-"+str_date);
									setADRDetails(drugCode+"-"+str_date,PostAdminDtls);
									setADRReason(order_id,encounter_id,drugCode,str_date,PostAdminDtls);
								}
								alOrderSchDetail.add(checkForNull(resultSet.getString("IV_PREP_YN")));//44
								alOrderSchDetail.add(ext_prod_id);//45
								alOrderSchDetail.add(drug_count);//46
								alOrderSchDetail.add(trade_code);//47
								alOrderSchDetail.add(imageFileURL);//48
								alOrderSchDetail.add(checkForNull(resultSet.getString("ROUTE_DESC")));//49
								alOrderSchDetail.add(checkForNull(resultSet.getString("PRES_CATG_CODE")));//50
								alOrderSchDetail.add(checkForNull(resultSet.getString("schedule_uom_desc")));//51
								alOrderSchDetail.add(checkForNull(resultSet.getString("sch_dosage_uom_code")));//52		
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADMN_DOSE_CHNG_REMARKS"))); //53
								alOrderSchDetail.add(""); //54 linked vaccine schedule
								alOrderSchDetail.add(checkForNull(resultSet.getString("MFR_YN"),"N")); //55 MultiFlowRateYN
								alOrderSchDetail.add(checkForNull(resultSet.getString("FLOW_STATUS"),"NS")); //56 this is for single FlowRate
								alOrderSchDetail.add(checkForNull(resultSet.getString("HOLD_DATE_TIME"))); //57 this is for single FlowRate in iv
								alOrderSchDetail.add(checkForNull(resultSet.getString("HOLD_DURN_IN_MINS"),"0")); //58 this is for single FlowRate in iv
								alOrderSchDetail.add(checkForNull(resultSet.getString("RESUME_DATE_TIME"))); //59 this is for single FlowRate in iv
								alOrderSchDetail.add(checkForNull(resultSet.getString("ACT_START_DATE_TIME"))); //60 this is for single FlowRate in iv
								alOrderSchDetail.add(checkForNull(resultSet.getString("ACT_END_DATE_TIME"))); //61 this is for single FlowRate in iv
								alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_TYPE"))); //62 
								alOrderSchDetail.add(checkForNull(resultSet.getString("MFR_REMARKS"))); //63 MFR REMARKS CAPTURED WHILE ORDERING TIME 	
								alOrderSchDetail.add(checkForNull(resultSet.getString("COMPLETED_DURN_IN_MINS"),"0")); //64 if you change flow rate in mid of Single Flow Rate previous flow rate's duration will be captured
								alOrderSchDetail.add(checkForNull(resultSet.getString("COMPLETED_VOLUME"),"0")); //65 if you change flow rate in mid of Single Flow Rate previous flow rate's completed volume will be captured
								alOrderSchDetail.add(checkForNull(resultSet.getString("PERFORMING_DEPTLOC_CODE"))); //66
								
								alOrderSchDetail.add(checkForNull(resultSet.getString("sch_infusion_vol_str_unit_desc"))); //67 - sch_infusion_vol_str_unit desc 
								alOrderSchDetail.add(checkForNull(resultSet.getString("ROUTE_COLOR")));// 68 added for Route Color RUT- CRF - 0034
								alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_PRACT_ID"))); //69 - //Added for [IN:040149]
								prescribe_mode.put(resultSet.getString("ORDER_ID")+resultSet.getString("ORDER_LINE_NUM"),resultSet.getString("PRESCRIBED_MODE"));
								str_date= resultSet.getString("START_DATE_TIME");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								alOrderSchDetail.add(str_date);//70
								alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_DESC")));//71
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_DATE")));//72
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_TIME")));//73
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCHCANADMIN"),"N"));//74
								alOrderSchDetail.add(checkForNull(resultSet.getString("SPLIT_DOSE_YN")));//75
								alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_HOLD_DATE_TIME")));//76
								alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_DISC_DATE_TIME")));//77
								alOrderSchDetail.add(checkForNull(resultSet.getString("DISPENSED_DRUG_DESC")));//78
								alOrderSchDetail.add(checkForNull(resultSet.getString("DISPENSED_DRUGS"))); //79
								alOrderSchDetail.add(checkForNull(resultSet.getString("DISP_DRUG_CODE"))); //80
								alOrderSchDetail.add(checkForNull(resultSet.getString("CANCEL_RECORDED_YN")));// CANCEL_RECORDED_YN ADDED  FOR JD-CRF-0200
							}
							//added for MMS-KH-CRF-0017- start
						if(iv_prep_yn.equals("2")){ //added for MMS-KH-CRF-0017
							if(hmIVDrugDetails.containsKey(orderKey)){
								alTmpOrderSchDetail = (ArrayList)hmIVDrugDetails.get(orderKey);
								alTmpOrderSchDetail.add(alOrderSchDetail);
								hmIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
							}
							else{
								alTmpOrderSchDetail = new ArrayList();
								alTmpOrderSchDetail.add(alOrderSchDetail);
								hmIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
							} //added for MMS-KH-CRF-0017 - start
							}else{
								tmpIVDrugFluidDtls = new HashMap();
							if(hmIVDrugDetails.containsKey(orderKey) ){
								tmpIVDrugFluidDtls = (HashMap)hmIVDrugDetails.get(orderKey);
								if(tmpIVDrugFluidDtls.containsKey(orderKey+"_Fluid")){
									tmpAlSchList = (ArrayList)tmpIVDrugFluidDtls.get(orderKey+"_Fluid");
									tmpAlSchList.add(alOrderSchDetail);
								}
								else{
									tmpAlSchList = new ArrayList();
									tmpAlSchList.add(alOrderSchDetail);
								} //added for MMS-KH-CRF-0017 - end
							}
							else{//added for MMS-KH-CRF-0017 - start
									tmpAlSchList = new ArrayList();
									tmpAlSchList.add(alOrderSchDetail);
							}
							tmpIVDrugFluidDtls.put(orderKey+"_Fluid",tmpAlSchList);
							tmpIVDrugFluidDtls.put(orderKey+"_Drug",tmpAlSchList);
							hmIVDrugDetails.put(orderKey, tmpIVDrugFluidDtls);
							}
							
				//added for MMS-KH-CRF-0017 - end
							if(hmSchList.containsKey(orderKey+"SCH")){
								uniqueSchedules= (LinkedHashSet<String>)hmSchList.get(orderKey+"SCH");
								uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
								hmSchList.put(orderKey+"SCH", uniqueSchedules);
							}
							else{
								uniqueSchedules= new LinkedHashSet<String>();
								uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
								hmSchList.put(orderKey+"SCH", uniqueSchedules);
							}
							hmSchList.put(orderKey+"MAXSEQ", max_dosage_seq_no+"");
														//added for MMS-KH-CRF-0017- end
						}
						else {
							if(iv_prep_yn.equals("3") || max_dosage_seq_no>=dosage_seq_no){
								alOrderSchDetail.add(checkForNull(resultSet.getString("IV_INGREDIANTS")));//1
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_INFUSION_RATE")));//2
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_INFUSION_VOL_STR_UNIT")));//3  -- here the short_desc from am_uom will be displayed
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_INFUSION_PER_UNIT")));//4					
								alOrderSchDetail.add(checkForNull(resultSet.getString("BATCH_ID")));//5
						
								str_date= resultSet.getString("EXPIRY_DATE");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
								}
								alOrderSchDetail.add(str_date);//6

								//alOrderSchDetail.add(resultSet.getString("EXPIRY_DATE"));
								alOrderSchDetail.add(checkForNull(resultSet.getString("TRADEID")));//7
								alOrderSchDetail.add(checkForNull(resultSet.getString("TRADENAME")));//8
								alOrderSchDetail.add(checkForNull(resultSet.getString("ITEMCODE")));//9
								alOrderSchDetail.add(checkForNull(resultSet.getString("PATIENT_ID")));//10
								alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_CODE")));//11
								alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_DESC")));//12

								str_date= resultSet.getString("SCH_DATE_TIME");
								pstmt_select_drug_count.setString(1,order_id);
								pstmt_select_drug_count.setString(2,str_date);
								resultSet_drug_count = pstmt_select_drug_count.executeQuery();
								if(resultSet_drug_count!=null && resultSet_drug_count.next())
									drug_count = resultSet_drug_count.getString("NO_OF_DRUGS");

								closeResultSet(resultSet_drug_count);
						
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								alOrderSchDetail.add(str_date);//13

								alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));//14
								alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_ID")));		//15			
								alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));//16
								alOrderSchDetail.add(checkForNull(resultSet.getString("QTY")));//17
								alOrderSchDetail.add(checkForNull(resultSet.getString("SHORT_DESC")));//18	
								alOrderSchDetail.add(checkForNull(resultSet.getString("DISCONTINUED")));//19
								alOrderSchDetail.add(checkForNull(resultSet.getString("HELD")));	//20
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_INFUSION_PERIOD")));	//21
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_INFUSION_PERIOD_UNIT")));//22	
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADMINISTERED_YN")));//23
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_RECORDED_YN")));//24
								administered = checkForNull(resultSet.getString("ADMINISTERED_YN"));
								
								if(administered.equals("N")){
									alOrderSchDetail.add(checkForNull(resultSet.getString("NON_ADMIN_REMARKS")));//25
								}
								else if(administered.equals("Y")){
									alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_REMARKS")));//25
								}
								else{
									alOrderSchDetail.add("");//25
								}
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADMINISTEREDDRUG")));	//26
								alOrderSchDetail.add(checkForNull(resultSet.getString("USERNAME")));//27
						
								str_date= resultSet.getString("ADMIN_DATE_TIME");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								alOrderSchDetail.add(checkForNull(str_date));//28

								alOrderSchDetail.add(checkForNull(resultSet.getString("MODIFIED_DATE")));//29
								alOrderSchDetail.add(checkForNull(resultSet.getString("PRES_DRUG_CODE")));//30
								alOrderSchDetail.add(checkForNull(resultSet.getString("PERFORMING_DEPTLOC_CODE")));//31
								
								alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_CLASS")));//32
								alOrderSchDetail.add(checkForNull(resultSet.getString("AUTHORIZED_BY")));//33
						
								str_date= resultSet.getString("END_DATE_TIME");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								alOrderSchDetail.add(str_date);//34

								alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_CODE")));//35
								alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_NATURE")));//36
								alOrderSchDetail.add(checkForNull(resultSet.getString("SRL_NO"),"1"));//37
								alOrderSchDetail.add(checkForNull(resultSet.getString("PRACT_ID")));//38
						
								str_date= checkForNull(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								alOrderSchDetail.add(str_date);//39
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REASON_CODE")));          //40
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REMARKS")));              //41
								admin_rec_date= checkForNull(resultSet.getString("ADR_RECORDED_DATE_TIME"));
								if(!locale.equals("en")){
									admin_rec_date = com.ehis.util.DateUtils.convertDate(admin_rec_date, "DMYHM","en",locale);
								}
								alOrderSchDetail.add(admin_rec_date);//42
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_RECORDED_BY"))); //43
								if(!admin_rec_date.equals("")){
									PostAdminDtls = new ArrayList();
									PostAdminDtls.add(str_date);
									PostAdminDtls.add(checkForNull(resultSet.getString("ADR_REASON_CODE")));
									PostAdminDtls.add(admin_rec_date);
									PostAdminDtls.add(checkForNull(resultSet.getString("ADR_REMARKS")));
									PostAdminDtls.add(checkForNull(resultSet.getString("ADR_RECORDED_BY")));
									clearADRDetails(drugCode+"-"+str_date);
									setADRDetails(drugCode+"-"+str_date,PostAdminDtls);
									setADRReason(order_id,encounter_id,drugCode,str_date,PostAdminDtls);
								}

								alOrderSchDetail.add(checkForNull(resultSet.getString("IV_PREP_YN")));//44
								alOrderSchDetail.add(ext_prod_id);//45
								alOrderSchDetail.add(drug_count);//46
								alOrderSchDetail.add(trade_code);//47
								alOrderSchDetail.add(imageFileURL);	//48						
								alOrderSchDetail.add(checkForNull(resultSet.getString("ROUTE_DESC")));	//49
								alOrderSchDetail.add(checkForNull(resultSet.getString("PRES_CATG_CODE")));//50
								alOrderSchDetail.add(checkForNull(resultSet.getString("schedule_uom_desc")));//51
								alOrderSchDetail.add(checkForNull(resultSet.getString("sch_dosage_uom_code")));//52	
								alOrderSchDetail.add(checkForNull(resultSet.getString("ADMN_DOSE_CHNG_REMARKS"))); //53
								alOrderSchDetail.add(checkForNull(resultSet.getString("VACC_CATEGORY_LINK")));//54 linked vaccine schedule
								alOrderSchDetail.add(checkForNull(resultSet.getString("MFR_YN"))); //55 MultiFlowRateYN
								alOrderSchDetail.add(checkForNull(resultSet.getString("FLOW_STATUS"))); //56 this is for single FlowRate
								alOrderSchDetail.add(checkForNull(resultSet.getString("HOLD_DATE_TIME"))); //57 this is for single FlowRate in iv
								alOrderSchDetail.add(checkForNull(resultSet.getString("HOLD_DURN_IN_MINS"))); //58 this is for single FlowRate in iv
								alOrderSchDetail.add(checkForNull(resultSet.getString("RESUME_DATE_TIME"))); //59 this is for single FlowRate in iv
								alOrderSchDetail.add(checkForNull(resultSet.getString("ACT_START_DATE_TIME"))); //60 this is for single FlowRate in iv
								alOrderSchDetail.add(checkForNull(resultSet.getString("ACT_END_DATE_TIME"))); //61 this is for single FlowRate in iv
								alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_TYPE"))); //62 
								alOrderSchDetail.add(checkForNull(resultSet.getString("MFR_REMARKS"))); //63 MFR REMARKS CAPTURED WHILE ORDERING TIME 
								alOrderSchDetail.add(checkForNull(resultSet.getString("COMPLETED_DURN_IN_MINS"))); //64 if you change flow rate in mid of Single Flow Rate previous flow rate's duration will be captured
								alOrderSchDetail.add(checkForNull(resultSet.getString("COMPLETED_VOLUME"))); //65 if you change flow rate in mid of Single Flow Rate previous flow rate's completed volume will be captured
								alOrderSchDetail.add(checkForNull(resultSet.getString("PERFORMING_DEPTLOC_CODE"))); //66 
								alOrderSchDetail.add(checkForNull(resultSet.getString("sch_infusion_vol_str_unit_desc"))); //67 - sch_infusion_vol_str_unit desc
								alOrderSchDetail.add(checkForNull(resultSet.getString("ROUTE_COLOR"))); //68 - Added for Route Color RUT- CRF - 0034
								alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_PRACT_ID")));//69 Prescribing pract id //Added for [IN:040149]
								str_date= resultSet.getString("START_DATE_TIME");
								if(!locale.equals("en")){
									str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
								}
								alOrderSchDetail.add(str_date);//70
								alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_DESC")));//71
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_DATE")));//72
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_TIME")));//73
								alOrderSchDetail.add(checkForNull(resultSet.getString("SCHCANADMIN"),"N"));//74
								alOrderSchDetail.add(checkForNull(resultSet.getString("SPLIT_DOSE_YN")));//75
								alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_HOLD_DATE_TIME")));//76
								alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_DISC_DATE_TIME")));//77
								alOrderSchDetail.add(checkForNull(resultSet.getString("DISPENSED_DRUG_DESC")));//78
								alOrderSchDetail.add(checkForNull(resultSet.getString("DISPENSED_DRUGS"))); //79
								alOrderSchDetail.add(checkForNull(resultSet.getString("DISP_DRUG_CODE"))); //80
								alOrderSchDetail.add(checkForNull(resultSet.getString("CANCEL_RECORDED_YN")));// CANCEL_RECORDED_YN ADDED  FOR JD-CRF-0200
								alOrderSchDetail.add(checkForNull(resultSet.getString("could_admin_reason")));//added for mms-kh-crf-0010
							}
							if(iv_prep_yn.equals("3") ){
								tmpIVDrugFluidDtls = new HashMap();
								if(order_line_num.equals("1")){
									if(hmIVDrugDetails.containsKey(orderKey) ){
										tmpIVDrugFluidDtls = (HashMap)hmIVDrugDetails.get(orderKey);
										if(tmpIVDrugFluidDtls.containsKey(orderKey+"_Fluid")){
											tmpAlSchList = (ArrayList)tmpIVDrugFluidDtls.get(orderKey+"_Fluid");
											tmpAlSchList.add(alOrderSchDetail);
										}
										else{
											tmpAlSchList = new ArrayList();
											tmpAlSchList.add(alOrderSchDetail);
										}
									}
									else{
										tmpAlSchList = new ArrayList();
										tmpAlSchList.add(alOrderSchDetail);
									}
									tmpIVDrugFluidDtls.put(orderKey+"_Fluid",tmpAlSchList);
								}
								else{
									if(hmIVDrugDetails.containsKey(orderKey)){
										tmpIVDrugFluidDtls = (HashMap)hmIVDrugDetails.get(orderKey);
										if(tmpIVDrugFluidDtls.containsKey(orderKey+"_Drug")){
											tmpAlSchList = (ArrayList)tmpIVDrugFluidDtls.get(orderKey+"_Drug");
											tmpAlSchList.add(alOrderSchDetail);
										}
										else{
											tmpAlSchList = new ArrayList();
											tmpAlSchList.add(alOrderSchDetail);
										}
									}
									else{
										tmpAlSchList = new ArrayList();
										tmpAlSchList.add(alOrderSchDetail);
									}
									tmpIVDrugFluidDtls.put(orderKey+"_Drug",tmpAlSchList);
								}
								hmIVDrugDetails.put(orderKey, tmpIVDrugFluidDtls);
							}
							else{
								if(hmIVDrugDetails.containsKey(orderKey)){
									alTmpOrderSchDetail = (ArrayList)hmIVDrugDetails.get(orderKey);
									alTmpOrderSchDetail.add(alOrderSchDetail);
									hmIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
								}
								else{
									alTmpOrderSchDetail = new ArrayList();
									alTmpOrderSchDetail.add(alOrderSchDetail);
									hmIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
								}
							}
							if(hmSchList.containsKey(orderKey+"SCH")){
								uniqueSchedules= (LinkedHashSet<String>)hmSchList.get(orderKey+"SCH");
								uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
								hmSchList.put(orderKey+"SCH", uniqueSchedules);
							}
							else{
								uniqueSchedules= new LinkedHashSet<String>();
								uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
								hmSchList.put(orderKey+"SCH", uniqueSchedules);
							}
							hmSchList.put(orderKey+"MAXSEQ", max_dosage_seq_no+"");
						}
					}
				}
			}
			setPresMode(prescribe_mode);
			if(order_type.equals("A")){ //removed the comments for MMS-KH-CRF-0017.1
				strQuery ="SELECT a.order_id, a.order_line_num, e.iv_prep_yn, a.admin_recorded_by username, a.admin_authorized_by authorized_by, a.admin_remarks, a.non_admin_remarks, a.admin_recorded_yn, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN (   f.admin_drug_code || ':' || (SELECT long_name FROM ph_tpn_regimen_lang_vw ph_tpn_regimen WHERE tpn_regimen_code = f.admin_drug_code AND language_id = ?) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) WHEN a.ord_drug_code = 'FINAL PRODUCT' and nvl(administered_yn,'N') = 'Y' then 'FINAL PRODUCT:'||((SELECT mfg_unit FROM ph_tpn_worksheet_hdr WHERE tpn_worksheet_id = (SELECT DISTINCT tpn_worksheet_id FROM ph_tpn_worksheet_dtl WHERE order_id = (SELECT DISTINCT order_id FROM ph_medn_admin WHERE order_id = a.order_id and order_line_num = a.order_line_num and nvl(administered_yn,'N' ) = 'Y'))) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code) END ) administereddrug, a.dosage_seq_no, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY HH24:MI') sch_date_time, a.admin_recorded_yn, a.administered_yn, a.verify_reqd_yn, a.verification_status, a.medn_admin_status, NVL (a.iv_admin_yn, 'N') iv_admin_yn, DECODE (d.disc_date_time, NULL, 'N', 'Y') discontinued,TO_CHAR (d.disc_date_time, 'DD/MM/YYYY HH24:MI') ORD_DISC_DATE_TIME, DECODE (d.hold_date_time, NULL, 'N', 'Y') held, TO_CHAR (d.HOLD_DATE_TIME, 'DD/MM/YYYY HH24:MI') ORD_HOLD_DATE_TIME, a.patient_id, a.pract_id, d.qty_value, d.qty_unit, d.freq_code, a.order_line_num, NVL ((SELECT disp_drug_code FROM ph_disp_dtl WHERE ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND ROWNUM < 2), (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.long_name ELSE 'FINAL PRODUCT' END ) ) drug_code,(CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.tpn_regimen_code ELSE 'FINAL PRODUCT' END ) pres_drug_code,(CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT long_name FROM ph_tpn_regimen_lang_vw  ph_tpn_regimen, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_tpn_regimen.tpn_regimen_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2), b.long_name ) ELSE (SELECT mfg_unit FROM ph_tpn_worksheet_hdr HDR WHERE EXISTS ( SELECT distinct tpn_worksheet_id FROM ph_tpn_worksheet_dtl b WHERE order_id = (SELECT DISTINCT order_id FROM ph_medn_admin WHERE order_id = a.order_id AND order_line_num = a.order_line_num) AND b.tpn_worksheet_id = HDR.tpn_worksheet_id)AND ROWNUM<2) END ) drug_desc, round(NVL(d.ORDER_QTY,0)-(NVL(i.TOT_ADMINISTERED_QTY,0)),4) sch_dosage_qty, NVL (f.admin_dosage_qty, sch_dosage_qty) qty,  am_get_desc.am_uom(a.sch_dosage_uom_code,?,2) short_desc, a.iv_ingrediants, a.sch_infusion_rate, a.sch_infusion_vol_str_unit, a.sch_infusion_per_unit, a.sch_infusion_period, a.sch_infusion_period_unit, TO_CHAR (a.admin_date_time, 'DD/MM/YYYY HH24:MI') admin_date_time, TO_CHAR (a.modified_date, 'DD/MM/YYYY HH24:MI') modified_date, b.drug_class, b.item_code itemcode, TO_CHAR (d.start_date_time, 'DD/MM/YYYY HH24:MI') start_date_time, TO_CHAR (d.end_date_time, 'DD/MM/YYYY HH24:MI') end_date_time, f.batch_id, TO_CHAR (f.expiry_date, 'DD/MM/YYYY') expiry_date, f.item_code, f.trade_id tradeid, am_get_desc.AM_TRADE_NAME(f.trade_id,?,2) tradename, h.freq_nature, h.FREQ_DESC, TO_CHAR (a.against_schdose_date_time, 'DD/MM/YYYY HH24:MI' ) against_schdose_date_time, a.adr_reason_code, a.adr_remarks, TO_CHAR (a.adr_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) adr_recorded_date_time, a.adr_recorded_by, i.prescribed_mode,d.route_code, b.PRES_CATG_CODE , am_get_desc.am_uom(d.qty_unit,?,2) schedule_uom_desc,a.sch_dosage_uom_code sch_dosage_uom_code,o.PATIENT_BROUGHT_MEDICATION_YN,o.SLIDING_SCALE_YN sliding_scale_yn,a.MEDN_BROUGHT_BY_PATIENT_YN,o.DOSAGE_TYPE, i.DOSAGE, i.DOSAGE_UOM_CODE, am_get_desc.am_uom(i.dosage_uom_code,?,2) dosage_uom_desc,A.ADMN_DOSE_CHNG_REMARKS,e.PERFORMING_DEPTLOC_CODE, b.PRES_BASE_UNIT PRES_BASE_UOM, e.ORD_PRACT_ID, ROUTE.ROUTE_DESC, ROUTE.ROUTE_COLOR ,TO_CHAR (a.sch_date_time, 'DD/MM/YYYY') sch_date, TO_CHAR (a.sch_date_time, 'HH24:MI') sch_time, (select 'Y' from dual where a.sch_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')) SCHCANADMIN, o.SPLIT_DOSE_YN , f.srl_no,(CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN (SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code <> ph_disp_dtl.pres_drug_code AND ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2) ELSE (SELECT mfg_unit FROM ph_worksheet_hdr WHERE order_id = a.order_id AND ROWNUM < 2) END ) dispensed_drug_desc, i.DISPENSED_DRUGS,(SELECT drug_code FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code<>ph_disp_dtl.pres_drug_code and ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2 ) disp_drug_code,PLACED_FROM_VERBAL_ORDER FROM ph_medn_admin a, ph_tpn_regimen_lang_vw b, or_order_line d, or_order e, ph_medn_admin_dtl f, am_frequency_lang_vw h, ph_patient_drug_profile i, or_order_line_ph o, PH_ROUTE_LANG_VW route WHERE h.freq_code = d.freq_code AND f.encounter_id(+) = a.encounter_id AND f.order_id(+) = a.order_id AND f.facility_id(+) = a.facility_id AND f.ord_drug_code(+) = a.ord_drug_code AND a.dosage_seq_no = f.dosage_seq_no(+) AND f.sch_date_time(+) = a.sch_date_time AND e.order_id = d.order_id AND o.order_id = d.order_id AND o.order_line_num = d.order_line_num AND i.orig_order_id = d.order_id AND i.orig_order_line_no = d.order_line_num AND e.order_id = i.orig_order_id AND a.ord_drug_code = b.tpn_regimen_code(+) AND a.order_id = d.order_id AND a.order_line_num = d.order_line_num AND a.facility_id =? AND a.encounter_id =? AND a.sch_date_time >= d.START_DATE_TIME AND SYSDATE <= d.end_date_time AND d.can_date_time IS NULL AND e.iv_prep_yn IN ('7','8') AND b.language_id(+) = ? AND D.ROUTE_CODE(+) = ROUTE.ROUTE_CODE and ROUTE.LANGUAGE_ID(+) = ? and h.language_id(+)=?";

				appendString = " AND ( (trunc(a.sch_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')) OR (H.FREQ_NATURE='P'  and TRUNC(d.end_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY'))) ";  //Added for SKR-SCF-0836 [IN:044162]
				/*if(administration_status!=null && (administration_status.equals("OVERDUE") || administration_status.equals("DUE"))){
					appendString =" AND SYSDATE<=D.END_DATE_TIME AND (( trunc(a.sch_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND (ADMIN_RECORDED_YN='N' OR ADMIN_RECORDED_YN IS NULL)) )   "; 
				} 
				else if(administration_status!=null && administration_status.equals("ALL")) {
					appendString = " AND (( trunc(a.sch_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')) OR (H.FREQ_NATURE='P'  AND (D.ORDER_QTY-NVL(I.TOT_ADMINISTERED_QTY,0))>0 ) ) ";
				}*/ //Commented for SKR-SCF-0836 [IN:044162]
				/*if(!route_admin.equals(""))
					appendString = appendString+" AND d.route_code ='"+route_admin+"' ";*/
				 //comment removed for MMS-KH-CRF-017.1 - start
				if(appendString==null)
					appendString="";

				if(!hold_discontinue_yn.equals("Y")){
					strQuery = strQuery + (appendString + " AND d.HOLD_DATE_TIME IS NULL AND DISC_DATE_TIME IS NULL AND CAN_DATE_TIME IS NULL ORDER BY E.IV_PREP_YN, ");	
				}
				else{
					strQuery = strQuery + (appendString +" ORDER BY E.IV_PREP_YN, ");
				}

				if(display_order_by.equals("D")){
					display_order_str = "drug_desc ||D.ORDER_ID||to_char(D.ORDER_LINE_NUM)";
				}
				else if(display_order_by.equals("F")){
					display_order_str = "D.ORDER_ID||to_char(D.ORDER_LINE_NUM)";
				}
				else { 
					display_order_str = "e.ORD_DATE_TIME||D.ORDER_ID||to_char(D.ORDER_LINE_NUM)";
				}		
				//String order_by_str1= " DECODE(E.IV_PREP_YN,'1',D.ORDER_ID||to_char(a.sch_date_time,'yyyymmddhh24:mi')||to_char(D.ORDER_LINE_NUM),'3',D.ORDER_ID||to_char(a.sch_date_time,'yyyymmddhh24:mi')||to_char(D.ORDER_LINE_NUM),"+display_order_str+" ),sch_time,  to_date(sch_date,'dd/mm/yyyy')";
				order_by_str = display_order_str+" ,a.DOSAGE_SEQ_NO, decode (h.freq_nature,  'P', '', sch_time),  to_date(sch_date,'dd/mm/yyyy')";

				strQuery = strQuery + order_by_str;
				pstmt = connection.prepareStatement( strQuery ) ;
				pstmt.setString(1,locale );
				pstmt.setString(2,locale );
				pstmt.setString(3,locale );
				pstmt.setString(4,locale );
				pstmt.setString(5,locale );
				pstmt.setString(6,locale );
				pstmt.setString(7,adminFromDateTime );
				pstmt.setString(8,adminToDateTime );
				pstmt.setString(9,locale );
				pstmt.setString(10,locale );
				pstmt.setString(11,login_facility_id);
				pstmt.setString(12,encounter_id.trim());			
				pstmt.setString(13,locale );
				pstmt.setString(14,locale );
				pstmt.setString(15,locale );
				pstmt.setString(16,from_date );
				pstmt.setString(17,to_date );				
				pstmt.setString(18,from_date );
				pstmt.setString(19,to_date );				

				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ){
					alOrderSchDetail = new ArrayList();
					drugCode = checkForNull(resultSet.getString("DRUG_CODE"));
					order_id = checkForNull(resultSet.getString("ORDER_ID"));
					orderKey = order_id+"_"+resultSet.getString("ORDER_LINE_NUM");
				
					alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_CODE")));//1
					alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_DESC")));//2
					alOrderSchDetail.add(checkForNull(resultSet.getString("QTY")));//3
					alOrderSchDetail.add(checkForNull(resultSet.getString("SHORT_DESC")));	//4				
					alOrderSchDetail.add(checkForNull(resultSet.getString("BATCH_ID")));//5
					str_date= resultSet.getString("EXPIRY_DATE");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
					}
					alOrderSchDetail.add(checkForNull(str_date)); //6
					alOrderSchDetail.add(checkForNull(resultSet.getString("TRADENAME")));//7
					alOrderSchDetail.add(checkForNull(resultSet.getString("ITEMCODE")));//8
					alOrderSchDetail.add("");//9
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_RECORDED_YN")));//10
					alOrderSchDetail.add(checkForNull(resultSet.getString("VERIFY_REQD_YN")));//11
					alOrderSchDetail.add(checkForNull(resultSet.getString("VERIFICATION_STATUS")));//12
					alOrderSchDetail.add(checkForNull(resultSet.getString("MEDN_ADMIN_STATUS")));//13
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_ID")));	//14				
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));	//15				
					alOrderSchDetail.add(checkForNull(resultSet.getString("PATIENT_ID")));//16

					str_date= resultSet.getString("SCH_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date); //17
					//alOrderSchDetail.add(resultSet.getString("SCH_DATE_TIME"));
					alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));//18
					alOrderSchDetail.add(checkForNull(resultSet.getString("TRADEID")));//19
					alOrderSchDetail.add(checkForNull(resultSet.getString("DISCONTINUED")));//20
					alOrderSchDetail.add(checkForNull(resultSet.getString("HELD")));		//21			
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMINISTERED_YN")));//22
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_RECORDED_YN")));//23
					administered = checkForNull(resultSet.getString("ADMINISTERED_YN"));						

					if(administered.equals("N")){
						alOrderSchDetail.add(checkForNull(resultSet.getString("NON_ADMIN_REMARKS")));//24
					}
					else if(administered.equals("Y")){
						alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_REMARKS")));//24
					}
					else{
						alOrderSchDetail.add("");//24
					}
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMINISTEREDDRUG")));		//25	
					alOrderSchDetail.add(checkForNull(resultSet.getString("USERNAME")));//26

					str_date= resultSet.getString("ADMIN_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date);//27

					alOrderSchDetail.add(checkForNull(resultSet.getString("MODIFIED_DATE"))); //28
					alOrderSchDetail.add(checkForNull(resultSet.getString("PRES_DRUG_CODE")));//29
					alOrderSchDetail.add(checkForNull(resultSet.getString("PERFORMING_DEPTLOC_CODE")));//30

					alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_CLASS")));//31
					alOrderSchDetail.add(checkForNull(resultSet.getString("AUTHORIZED_BY")));//32
					
					str_date= resultSet.getString("END_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date);//33

					alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_CODE")));//34
					alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_NATURE")));//35
					alOrderSchDetail.add(checkForNull(resultSet.getString("SRL_NO"),"1"));//36
					alOrderSchDetail.add(checkForNull(resultSet.getString("PRACT_ID")));//37
					
					str_date= checkForNull(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date);//38
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REASON_CODE")));//39
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REMARKS")));//40
					
					admin_rec_date= checkForNull(resultSet.getString("ADR_RECORDED_DATE_TIME"));
					if(!admin_rec_date.equals("") && !locale.equals("en")){
						admin_rec_date = com.ehis.util.DateUtils.convertDate(admin_rec_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date);//41
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_RECORDED_BY")));//42
					if(!admin_rec_date.equals("")){
						PostAdminDtls = new ArrayList();
						PostAdminDtls.add(str_date);
						PostAdminDtls.add(checkForNull(resultSet.getString("ADR_REASON_CODE")));
						PostAdminDtls.add(admin_rec_date);
						PostAdminDtls.add(checkForNull(resultSet.getString("ADR_REMARKS")));
						PostAdminDtls.add(checkForNull(resultSet.getString("ADR_RECORDED_BY")));
						clearADRDetails(drugCode+"-"+str_date);
						setADRDetails(drugCode+"-"+str_date,PostAdminDtls);
						setADRReason(order_id,encounter_id,drugCode,str_date,PostAdminDtls);
					}
					alOrderSchDetail.add(checkForNull(resultSet.getString("QTY_VALUE")));//43
					alOrderSchDetail.add(checkForNull(resultSet.getString("QTY_UNIT")));//44
					alOrderSchDetail.add(checkForNull(resultSet.getString("IV_PREP_YN")));//45
					alOrderSchDetail.add("N");//46
					alOrderSchDetail.add("");//47
					alOrderSchDetail.add("");//48
					alOrderSchDetail.add("");//49
					alOrderSchDetail.add("");//50
					alOrderSchDetail.add("");//51
					alOrderSchDetail.add("");//52
					alOrderSchDetail.add("");//53
					alOrderSchDetail.add(checkForNull(resultSet.getString("IV_INGREDIANTS")));//54					
					alOrderSchDetail.add(checkForNull(resultSet.getString("ROUTE_DESC")));//55
					alOrderSchDetail.add(checkForNull(resultSet.getString("PRES_CATG_CODE")));//56					
					alOrderSchDetail.add(checkForNull(resultSet.getString("schedule_uom_desc")));//57				
					alOrderSchDetail.add(checkForNull(resultSet.getString("sch_dosage_uom_code")));//58					
					alOrderSchDetail.add(checkForNull(resultSet.getString("PATIENT_BROUGHT_MEDICATION_YN"),"N"));//59					
					alOrderSchDetail.add(checkForNull(resultSet.getString("SLIDING_SCALE_YN"),"N"));//60					
					alOrderSchDetail.add("");//61
					alOrderSchDetail.add("");//62
					alOrderSchDetail.add(checkForNull(resultSet.getString("MEDN_BROUGHT_BY_PATIENT_YN"),"N"));//63
					alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_TYPE"),"Q"));//64
					alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE")));//65
					alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_UOM_CODE")));//66
					alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_UOM_DESC")));//67
					alOrderSchDetail.add("");//68
					alOrderSchDetail.add("");//69	
					alOrderSchDetail.add("");//70	
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMN_DOSE_CHNG_REMARKS"))); //71
					alOrderSchDetail.add("1");  //72  drug count for Oncology Direct Order
					alOrderSchDetail.add("");//73 linked vaccine schedule
					alOrderSchDetail.add(checkForNull(resultSet.getString("PERFORMING_DEPTLOC_CODE")));//74 
					alOrderSchDetail.add(checkForNull(resultSet.getString("PRES_BASE_UOM")));//75
					alOrderSchDetail.add(checkForNull(resultSet.getString("ROUTE_COLOR")));//76 Added FOr RUT-CRF -0034 Route COlor
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_PRACT_ID")));//77 Prescribing pract id //Added for [IN:040149]
					str_date= resultSet.getString("START_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date);//78
					alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_DESC")));//79
					alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_DATE")));//80
					alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_TIME")));//81
					alOrderSchDetail.add(checkForNull(resultSet.getString("SCHCANADMIN"),"N"));//82
					alOrderSchDetail.add(checkForNull(resultSet.getString("SPLIT_DOSE_YN")));//83
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_HOLD_DATE_TIME")));//84
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_DISC_DATE_TIME")));//85
					alOrderSchDetail.add(checkForNull(resultSet.getString("sch_dosage_qty")));//86
					alOrderSchDetail.add(checkForNull(resultSet.getString("DISPENSED_DRUG_DESC")));//87
					alOrderSchDetail.add(checkForNull(resultSet.getString("DISPENSED_DRUGS"))); //88
					alOrderSchDetail.add(checkForNull(resultSet.getString("DISP_DRUG_CODE"))); //89
					alOrderSchDetail.add("");//90  MFR_YN,MFR_REMARKS
					alOrderSchDetail.add("N");//ML-MMOH-CRF-1014
					alOrderSchDetail.add(""); //ML-MMOH-CRF-1014
					alOrderSchDetail.add(checkForNull(resultSet.getString("PLACED_FROM_VERBAL_ORDER")));//added for ghl-crf-0509
					 alOrderSchDetail.add("N");//added for GHL-CRF-0482
					 alOrderSchDetail.add("N");//added for GHL-CRF-0482
					 alOrderSchDetail.add("N");//added for GHL-CRF-0482
					 alOrderSchDetail.add("N");
					 alOrderSchDetail.add("");
					if(hmNonIVDrugDetails.containsKey(orderKey)){
						alTmpOrderSchDetail = (ArrayList)hmNonIVDrugDetails.get(orderKey);
						alTmpOrderSchDetail.add(alOrderSchDetail);
						hmNonIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
					}
					else{
						alTmpOrderSchDetail = new ArrayList();
						alTmpOrderSchDetail.add(alOrderSchDetail);
						hmNonIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
					}
					if(hmSchList.containsKey(orderKey+"SCH")){
						uniqueSchedules= (LinkedHashSet<String>)hmSchList.get(orderKey+"SCH");
						uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
						hmSchList.put(orderKey+"SCH", uniqueSchedules);
					}
					else{
						uniqueSchedules= new LinkedHashSet<String>();
						uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
						hmSchList.put(orderKey+"SCH", uniqueSchedules);
					}
				}
			} //comment removed for MMS-KH-CRF-0017.1 - end
		}
		catch ( Exception e ){
			System.err.println("=======strQuery=====>"+strQuery);
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
		drug_details.put("iv_prep_yn",iv_prep_yn);
		drug_details.put("NON_IV",hmNonIVDrugDetails);
		drug_details.put("IV",hmIVDrugDetails);
		drug_details.put("SCHLIST",hmSchList);
		setDrugDetails(drug_details);
		return drug_details;
	}

	public HashMap getMARDetailsMonthView(String encounter_id,String hold_discontinue_yn,String administration_status,String order_type,String from_date,String to_date, String display_order_by,String route_admin,String admin_rout_categ){
		
		HashMap drug_details						= new HashMap();
//		HashMap prescribe_mode						= new HashMap();  Removed for IN063877
//		ArrayList iv_drug_details					= new ArrayList();  Removed for IN063877
//		ArrayList non_iv_drug_details				= new ArrayList();  Removed for IN063877
		LinkedHashMap hmIVDrugDetails = new LinkedHashMap();
		LinkedHashMap hmNonIVDrugDetails = new LinkedHashMap();
		ArrayList alOrderSchDetail = null;
		ArrayList alTmpOrderSchDetail = new ArrayList();
		Set<String> uniqueSchedules = new LinkedHashSet<String>();
		HashMap hmSchList = new HashMap();

		Connection connection						= null;
        PreparedStatement pstmt						= null;
		PreparedStatement pstmt_select_drug_count	= null;
		PreparedStatement pstmt_ext_drug_code		= null;
        ResultSet resultSet							= null;
		ResultSet resultSet_drug_count				= null;
		ResultSet resultSet_ext_drug_code			= null;
		String appendString							="";
		String strQuery								="";
		String iv_prep_yn							="";
		String str_date="",  order_by_str="", orderKey="", admin_rec_date="", display_order_str="";// administered=""  Removed for IN063877
		String ext_prod_id							="";
		String drugCode								="";
		String order_id								="";
		String drug_count							="1";
		locale = getLanguageId()==null?"en":getLanguageId();
		if(display_order_by.equals("D")){
			display_order_str = "drug_desc ||D.ORDER_ID||to_char(D.ORDER_LINE_NUM)";
		}
		else if(display_order_by.equals("F")){
			if(order_type.equals("TPN"))
				display_order_str = "D.ORDER_ID||to_char(D.ORDER_LINE_NUM)";
			else
				display_order_str = "form_desc||D.ORDER_ID||to_char(D.ORDER_LINE_NUM)";			
		}
		else { 
			display_order_str = "e.ORD_DATE_TIME||D.ORDER_ID||to_char(D.ORDER_LINE_NUM)";
		}		

		try{
			connection = getConnection() ;
			if(order_type.equals("TPN")){
				strQuery ="SELECT a.order_id, a.order_line_num, e.iv_prep_yn, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN ( f.admin_drug_code || ':' || (SELECT long_name FROM ph_tpn_regimen_lang_vw ph_tpn_regimen WHERE tpn_regimen_code = f.admin_drug_code AND language_id = ?) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) WHEN a.ord_drug_code = 'FINAL PRODUCT' AND NVL (administered_yn, 'N') = 'Y' THEN 'FINAL PRODUCT:' || ( (SELECT mfg_unit FROM ph_tpn_worksheet_hdr WHERE tpn_worksheet_id = (SELECT DISTINCT tpn_worksheet_id FROM ph_tpn_worksheet_dtl WHERE order_id = (SELECT DISTINCT order_id FROM ph_medn_admin WHERE order_id = a.order_id AND order_line_num = a.order_line_num AND NVL (administered_yn, 'N' ) = 'Y'))) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) END ) administereddrug, a.dosage_seq_no, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY HH24:MI') sch_date_time, a.admin_recorded_yn, a.administered_yn, DECODE (d.disc_date_time, NULL, 'N', 'Y') discontinued,TO_CHAR (d.disc_date_time, 'DD/MM/YYYY HH24:MI') ORD_DISC_DATE_TIME, DECODE (d.hold_date_time, NULL, 'N', 'Y') held, TO_CHAR (d.HOLD_DATE_TIME, 'DD/MM/YYYY HH24:MI') ORD_HOLD_DATE_TIME, a.patient_id, a.pract_id, NVL ((SELECT disp_drug_code FROM ph_disp_dtl WHERE ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND ROWNUM < 2), (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.long_name ELSE 'FINAL PRODUCT' END ) ) drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.tpn_regimen_code ELSE 'FINAL PRODUCT' END ) pres_drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT long_name FROM ph_tpn_regimen_lang_vw ph_tpn_regimen, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_tpn_regimen.tpn_regimen_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2), b.long_name ) ELSE (SELECT mfg_unit FROM ph_tpn_worksheet_hdr hdr WHERE EXISTS ( SELECT DISTINCT tpn_worksheet_id FROM ph_tpn_worksheet_dtl b WHERE order_id = (SELECT DISTINCT order_id FROM ph_medn_admin WHERE order_id = a.order_id AND order_line_num = a.order_line_num) AND b.tpn_worksheet_id = hdr.tpn_worksheet_id) AND ROWNUM < 2) END ) drug_desc, a.iv_ingrediants, TO_CHAR (d.start_date_time, 'DD/MM/YYYY HH24:MI') start_date_time, TO_CHAR (d.end_date_time, 'DD/MM/YYYY HH24:MI') end_date_time, h.freq_nature, h.freq_desc, TO_CHAR (a.against_schdose_date_time, 'DD/MM/YYYY HH24:MI' ) against_schdose_date_time, a.adr_reason_code, a.adr_remarks, TO_CHAR (a.adr_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) adr_recorded_date_time, a.adr_recorded_by, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY') sch_date, TO_CHAR (a.sch_date_time, 'HH24:MI') sch_time,o.split_dose_yn, f.srl_no FROM ph_medn_admin a, ph_tpn_regimen_lang_vw b, or_order_line d, or_order e, ph_medn_admin_dtl f, am_frequency_lang_vw h, ph_patient_drug_profile i, or_order_line_ph o WHERE h.freq_code = d.freq_code AND f.encounter_id(+) = a.encounter_id AND f.order_id(+) = a.order_id AND f.facility_id(+) = a.facility_id AND f.ord_drug_code(+) = a.ord_drug_code AND a.dosage_seq_no = f.dosage_seq_no(+) AND f.sch_date_time(+) = a.sch_date_time AND e.order_id = d.order_id AND o.order_id = d.order_id AND o.order_line_num = d.order_line_num AND i.orig_order_id = d.order_id AND i.orig_order_line_no = d.order_line_num AND e.order_id = i.orig_order_id AND a.ord_drug_code = b.tpn_regimen_code(+) AND a.order_id = d.order_id AND a.order_line_num = d.order_line_num AND a.facility_id = ? AND a.encounter_id = ? AND a.sch_date_time >= d.start_date_time AND SYSDATE <= d.end_date_time AND d.can_date_time IS NULL AND e.iv_prep_yn IN ('7', '8') AND b.language_id(+) = ? AND h.language_id(+) = ?  and d.ORDER_LINE_STATUS not in ('PO', 'PS') "; //and d.ORDER_LINE_STATUS not in ('PO', 'PS')  added for ML-MMOH-SCF-0321 [IN:058617]
			}
			else{
				strQuery = "SELECT a.order_id, a.order_line_num, e.iv_prep_yn, a.admin_recorded_yn, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN ( f.admin_drug_code || ':' || (SELECT drug_desc FROM ph_drug_lang_vw ph_drug WHERE drug_code = f.admin_drug_code AND language_id = ?) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) WHEN a.ord_drug_code = 'FINAL PRODUCT' AND NVL (administered_yn, 'N') = 'Y' THEN 'FINAL PRODUCT:' || ( (SELECT mfg_unit FROM ph_worksheet_hdr WHERE order_id = a.order_id AND ROWNUM < 2) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) END ) administereddrug, a.dosage_seq_no, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY HH24:MI') sch_date_time, a.administered_yn, DECODE (d.disc_date_time, NULL, 'N', 'Y') discontinued,TO_CHAR (d.disc_date_time, 'DD/MM/YYYY HH24:MI') ORD_DISC_DATE_TIME, DECODE (d.hold_date_time, NULL, 'N', 'Y') held, TO_CHAR (d.HOLD_DATE_TIME, 'DD/MM/YYYY HH24:MI') ORD_HOLD_DATE_TIME, a.patient_id, a.pract_id, NVL ((SELECT disp_drug_code FROM ph_disp_dtl WHERE ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND ROWNUM < 2), (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.drug_code ELSE 'FINAL PRODUCT' END ) ) drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.drug_code ELSE 'FINAL PRODUCT' END ) pres_drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2), b.drug_desc ) ELSE (SELECT mfg_unit FROM ph_worksheet_hdr WHERE order_id = a.order_id AND ROWNUM < 2) END ) drug_desc, a.iv_ingrediants, TO_CHAR (d.start_date_time, 'DD/MM/YYYY HH24:MI') start_date_time, TO_CHAR (d.end_date_time, 'DD/MM/YYYY HH24:MI') end_date_time, h.freq_nature, h.freq_desc, TO_CHAR (a.against_schdose_date_time, 'DD/MM/YYYY HH24:MI' ) against_schdose_date_time, a.adr_reason_code, a.adr_remarks, TO_CHAR (a.adr_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) adr_recorded_date_time, a.adr_recorded_by, i.prn_remarks,  TO_CHAR (a.sch_date_time, 'DD/MM/YYYY') sch_date, TO_CHAR (a.sch_date_time, 'HH24:MI') sch_time, o.split_dose_yn, f.srl_no FROM ph_medn_admin a, ph_drug_lang_vw b, or_order_line d, or_order e, ph_medn_admin_dtl f, am_frequency_lang_vw h, ph_patient_drug_profile i, or_order_line_field_values k, or_order_line_ph o WHERE h.freq_code = d.freq_code AND f.encounter_id(+) = a.encounter_id AND f.facility_id(+) = a.facility_id AND f.ord_drug_code(+) = a.ord_drug_code AND a.dosage_seq_no = f.dosage_seq_no(+) AND f.sch_date_time(+) = a.sch_date_time AND f.order_id(+) = a.order_id AND e.order_id = d.order_id AND i.orig_order_id = d.order_id AND o.order_id = d.order_id AND o.order_line_num = d.order_line_num AND i.orig_order_line_no = d.order_line_num AND e.order_id = i.orig_order_id AND a.ord_drug_code = b.drug_code(+) AND a.order_id = d.order_id AND a.order_line_num = d.order_line_num AND a.order_id = k.order_id(+) AND a.order_line_num = k.order_line_num(+) AND k.order_line_seq_num(+) = 1 AND a.facility_id = ? AND a.encounter_id = ? AND a.sch_date_time >= d.start_date_time AND d.can_date_time IS NULL AND b.language_id(+) = ? AND h.language_id(+) = ? and d.ORDER_LINE_STATUS not in ('PO', 'PS','PQ') "; //and d.ORDER_LINE_STATUS not in ('PO', 'PS')  added for ML-MMOH-SCF-0321 [IN:058617] //Added ORDER_LINE_STATUS not in ('PO', 'PS','PQ') 'PQ' for ML-MMOH-CRF-1823-US008
			}

			if(order_type !=null && order_type.equals("Rx")){
				appendString = " AND E.IV_PREP_YN IS NULL ";
			} 
			else if(order_type !=null && order_type.equals("IVRx")){
				appendString = " AND E.IV_PREP_YN IN ('1','2','3','4','5') ";
			} 
			else if(order_type !=null && order_type.equals("COMP")){
				appendString = " AND E.IV_PREP_YN = '6' ";
			}
			else if(order_type !=null && order_type.equals("STAT")){
				appendString = " AND H.FREQ_NATURE = 'O' ";
			}
			else if(order_type !=null && order_type.equals("PRN")){  
				appendString = " AND H.FREQ_NATURE = 'P' "; 
			}
			else if(order_type !=null && order_type.equals("CYTO")){  
				appendString = "  AND E.IV_PREP_YN IN ('0','9') ";
			} 
			else if(order_type !=null && order_type.equals("A")){  
				appendString = " AND (E.IV_PREP_YN IS NULL OR E.IV_PREP_YN IN ('0','1','2','3','4','5','6','9')) ";
			}
			
			//appendString = appendString + "AND ( (trunc(a.sch_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')) OR (H.FREQ_NATURE='P'  and trunc(d.start_date_time) <  TO_DATE('"+to_date+"','DD/MM/YYYY') /* AND (D.ORDER_QTY-NVL(I.TOT_ADMINISTERED_QTY,0))>0 */) ) ";  //Commented for SKR-SCF-0836 [IN:044162]
			appendString = appendString + "AND ( (trunc(a.sch_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')) OR ( ( h.freq_nature = 'P' and a.order_id not in ( select order_id from ph_medn_admin where order_id=a.order_id and order_line_num= a.order_line_num and TRUNC (sch_date_time) BETWEEN TO_DATE (?, 'DD/MM/YYYY' ) AND TO_DATE (?, 'DD/MM/YYYY' ) ) ) and H.FREQ_NATURE='P'  and TRUNC(d.end_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY'))) ";  //Added for SKR-SCF-0836 [IN:044162]

			if(!order_type.equals("TPN")){
				if(!route_admin.equals("")){
					appendString = appendString+"AND d.route_code ='"+route_admin+"' ";
				}
				else if(!admin_rout_categ.equals("")){
					ArrayList admRoutes=getAdminRoute(admin_rout_categ.trim());
					String aString="";
					for(int index=0;index<admRoutes.size();index+=2){
						aString=aString+"'"+admRoutes.get(index)+"',";
					}
					if(!aString.equals(""))
						aString=aString.substring(0,(aString.length()-1));
					else
						aString="''";
					appendString=appendString+" and d.ROUTE_CODE IN("+aString+")";					
				}
			}

			if(!hold_discontinue_yn.equals("Y")){
				appendString = appendString + "AND d.HOLD_DATE_TIME IS NULL AND DISC_DATE_TIME IS NULL AND CAN_DATE_TIME IS NULL";	
			}			
			order_by_str= " ORDER BY E.IV_PREP_YN, "+display_order_str+",a.DOSAGE_SEQ_NO, decode (h.freq_nature,  'P', '', sch_time), to_date(sch_date,'DD/MM/YYYY')";

			strQuery = strQuery + appendString + order_by_str;
			pstmt = connection.prepareStatement( strQuery ) ;
			int index=0;
			pstmt.setString(++index,locale ); //1
			pstmt.setString(++index,locale );
			pstmt.setString(++index,login_facility_id);	//3 
			pstmt.setString(++index,encounter_id.trim());			
			pstmt.setString(++index,locale );
			pstmt.setString(++index,locale );
			pstmt.setString(++index,from_date );//7
			pstmt.setString(++index,to_date );	
			pstmt.setString(++index,from_date );//9
			pstmt.setString(++index,to_date );	
			pstmt.setString(++index,from_date );//11
			pstmt.setString(++index,to_date );	

			resultSet = pstmt.executeQuery() ;
			pstmt_ext_drug_code				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_EXT_PRODUCT_ID")) ;
			pstmt_select_drug_count = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT_DRUGS_COUNT") ) ; 
			while ( resultSet != null && resultSet.next() ) {
				alOrderSchDetail = new ArrayList();
				drug_count = "1";
				ext_prod_id = "";
				iv_prep_yn =checkForNull(resultSet.getString("IV_PREP_YN"));
				drugCode = checkForNull(resultSet.getString("DRUG_CODE"));
				order_id = checkForNull(resultSet.getString("ORDER_ID"));
				
				if(!order_type.equals("TPN")&& !iv_prep_yn.equals("6")){
					pstmt_ext_drug_code.setString(1,drugCode);
					pstmt_ext_drug_code.setString(2,login_facility_id);
					resultSet_ext_drug_code			= pstmt_ext_drug_code.executeQuery();
					if(resultSet_ext_drug_code!=null && resultSet_ext_drug_code.next()){
						ext_prod_id = resultSet_ext_drug_code.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet_ext_drug_code.getString("EXTERNAL_PRODUCT_ID");
					}
					try{
						closeResultSet( resultSet_ext_drug_code ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}
				}
				orderKey = resultSet.getString("ORDER_ID")+"_"+resultSet.getString("ORDER_LINE_NUM");
				if(iv_prep_yn.equals("")||iv_prep_yn.equals("0")||iv_prep_yn.equals("6")||iv_prep_yn.equals("7")||iv_prep_yn.equals("8")||iv_prep_yn.equals("9")){
					alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_CODE")));//1
					alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_DESC")));//2
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_ID")));	//3			
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));	//4
					alOrderSchDetail.add(checkForNull(resultSet.getString("PATIENT_ID")));//5

					str_date= resultSet.getString("SCH_DATE_TIME");
					if(iv_prep_yn.equals("9")){
						pstmt_select_drug_count.setString(1,order_id);
						pstmt_select_drug_count.setString(2,str_date);
						resultSet_drug_count = pstmt_select_drug_count.executeQuery();
						if(resultSet_drug_count!=null && resultSet_drug_count.next())
							drug_count = resultSet_drug_count.getString("NO_OF_DRUGS");
						closeResultSet(resultSet_drug_count);
					}
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(checkForNull(str_date)); //6
					alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));//7
					alOrderSchDetail.add(checkForNull(resultSet.getString("DISCONTINUED")));//8
					alOrderSchDetail.add(checkForNull(resultSet.getString("HELD")));		//9			
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMINISTERED_YN")));//10
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_RECORDED_YN")));//11

					str_date= resultSet.getString("END_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(checkForNull(str_date));//12

					alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_NATURE")));//13
					alOrderSchDetail.add(checkForNull(resultSet.getString("PRACT_ID")));//14
					
					str_date= checkForNull(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(checkForNull(str_date));//15
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REASON_CODE")));//16
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REMARKS")));//17
					
					admin_rec_date= checkForNull(resultSet.getString("ADR_RECORDED_DATE_TIME"));
					if(!locale.equals("en")){
						admin_rec_date = com.ehis.util.DateUtils.convertDate(admin_rec_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(checkForNull(admin_rec_date));//18
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_RECORDED_BY")));//19

					if(order_type.equals("TPN")){
						alOrderSchDetail.add("");//20
					}
					else{
						alOrderSchDetail.add(resultSet.getString("PRN_REMARKS"));//20
					}
					alOrderSchDetail.add(resultSet.getString("PRN_REMARKS"));//21 //iv_ingts

					str_date= resultSet.getString("START_DATE_TIME");
					if(!locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date);//22
					alOrderSchDetail.add(ext_prod_id);//23
					alOrderSchDetail.add(checkForNull(drug_count));  //24 drug count for Oncology Direct Order
					alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_DATE")));//25
					alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_TIME")));//26
					alOrderSchDetail.add(checkForNull(resultSet.getString("SPLIT_DOSE_YN")));//27
					alOrderSchDetail.add(iv_prep_yn);//28
					alOrderSchDetail.add(checkForNull(resultSet.getString("SRL_NO"),"1"));//29
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_HOLD_DATE_TIME")));//30
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_DISC_DATE_TIME")));//31
					if(hmNonIVDrugDetails.containsKey(orderKey)){
						alTmpOrderSchDetail = (ArrayList)hmNonIVDrugDetails.get(orderKey);
						alTmpOrderSchDetail.add(alOrderSchDetail);
						hmNonIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
					}
					else{
						alTmpOrderSchDetail = new ArrayList();
						alTmpOrderSchDetail.add(alOrderSchDetail);
						hmNonIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
					}
					if(hmSchList.containsKey(orderKey+"SCH")){
						uniqueSchedules= (LinkedHashSet<String>)hmSchList.get(orderKey+"SCH");
						if(((String)resultSet.getString("FREQ_NATURE")).equals("P"))
							uniqueSchedules.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));
						else
							uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
					}
					else{
						uniqueSchedules= new LinkedHashSet<String>();
						if(((String)resultSet.getString("FREQ_NATURE")).equals("P"))
							uniqueSchedules.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));
						else
							uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
					}
					hmSchList.put(orderKey+"SCH", uniqueSchedules);

				}
				else{
					if( (resultSet.getString("IV_PREP_YN").equals("2") || resultSet.getString("IV_PREP_YN").equals("4"))) {
						if(resultSet.getString("ORDER_LINE_NUM").equals("1")) {
							alOrderSchDetail.add(checkForNull(resultSet.getString("IV_INGREDIANTS")));//0
							alOrderSchDetail.add(checkForNull(resultSet.getString("PATIENT_ID")));//1
							alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_CODE")));//2
							alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_DESC")));//3
					
							str_date= checkForNull(resultSet.getString("SCH_DATE_TIME"));
							order_id = resultSet.getString("ORDER_ID");
							pstmt_select_drug_count.setString(1,order_id);
							pstmt_select_drug_count.setString(2,str_date);
							resultSet_drug_count = pstmt_select_drug_count.executeQuery();
							if(resultSet_drug_count!=null && resultSet_drug_count.next())
								drug_count = resultSet_drug_count.getString("NO_OF_DRUGS");

							closeResultSet(resultSet_drug_count);

							if(!str_date.equals("") && !locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							alOrderSchDetail.add(str_date);//4

							alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));//5
							alOrderSchDetail.add(order_id);	//6

							alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));//7
							alOrderSchDetail.add(checkForNull(resultSet.getString("DISCONTINUED")));//8
							alOrderSchDetail.add(checkForNull(resultSet.getString("HELD")));	//9
							alOrderSchDetail.add(checkForNull(resultSet.getString("ADMINISTERED_YN")));//10
							alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_RECORDED_YN")));//11
					
							str_date= checkForNull(resultSet.getString("END_DATE_TIME"));
							if(!str_date.equals("") && !locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							alOrderSchDetail.add(str_date);//12

							alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_NATURE")));//13
							alOrderSchDetail.add(checkForNull(resultSet.getString("PRACT_ID")));//14
					
							str_date= checkForNull(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
							if(!str_date.equals("") && !locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							alOrderSchDetail.add(str_date);//15

							alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REASON_CODE"))); //16
							alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REMARKS")));//17
							admin_rec_date= checkForNull(resultSet.getString("ADR_RECORDED_DATE_TIME"));
							if(!admin_rec_date.equals("") && !locale.equals("en")){
								admin_rec_date = com.ehis.util.DateUtils.convertDate(admin_rec_date, "DMYHM","en",locale);
							}
							alOrderSchDetail.add(admin_rec_date);//18

							alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_RECORDED_BY"))); //19
							alOrderSchDetail.add(checkForNull(resultSet.getString("IV_PREP_YN")));//20
							alOrderSchDetail.add(ext_prod_id);//21
							alOrderSchDetail.add(drug_count);//22
							str_date= checkForNull(resultSet.getString("START_DATE_TIME"));
							if(!str_date.equals("") && !locale.equals("en")){
								str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
							}
							alOrderSchDetail.add(str_date);//23
							alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_DATE")));//24
							alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_TIME")));//25
							alOrderSchDetail.add(checkForNull(resultSet.getString("SPLIT_DOSE_YN")));//26
							alOrderSchDetail.add(checkForNull(resultSet.getString("SRL_NO"),"1"));//27
							alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_HOLD_DATE_TIME")));//28
							alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_DISC_DATE_TIME")));//29
						}
					}
					else {
						alOrderSchDetail.add(checkForNull(resultSet.getString("IV_INGREDIANTS")));//0
						alOrderSchDetail.add(checkForNull(resultSet.getString("PATIENT_ID")));//1
						alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_CODE")));//2
						alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_DESC")));//3

						str_date= checkForNull(resultSet.getString("SCH_DATE_TIME"));
						pstmt_select_drug_count.setString(1,order_id);
						pstmt_select_drug_count.setString(2,str_date);
						resultSet_drug_count = pstmt_select_drug_count.executeQuery();
						if(resultSet_drug_count!=null && resultSet_drug_count.next())
							drug_count = resultSet_drug_count.getString("NO_OF_DRUGS");

						closeResultSet(resultSet_drug_count);
				
						if(!str_date.equals("") && !locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						alOrderSchDetail.add(str_date);//4

						alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));//5
						alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_ID")));		//6			
						alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));//7
						alOrderSchDetail.add(checkForNull(resultSet.getString("DISCONTINUED")));//8
						alOrderSchDetail.add(checkForNull(resultSet.getString("HELD")));	//9
						alOrderSchDetail.add(checkForNull(resultSet.getString("ADMINISTERED_YN")));//10
						alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_RECORDED_YN")));//11
				
						str_date= checkForNull(resultSet.getString("END_DATE_TIME"));
						if(!str_date.equals("") && !locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						alOrderSchDetail.add(str_date);//12
						alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_NATURE")));//13
						alOrderSchDetail.add(checkForNull(resultSet.getString("PRACT_ID")));//14
						str_date= checkForNull(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
						if(!str_date.equals("") && !locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						alOrderSchDetail.add(str_date);//15
						alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REASON_CODE"))); //16
						alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REMARKS")));//17
						admin_rec_date= checkForNull(resultSet.getString("ADR_RECORDED_DATE_TIME"));
						if(!admin_rec_date.equals("") && !locale.equals("en")){
							admin_rec_date = com.ehis.util.DateUtils.convertDate(admin_rec_date, "DMYHM","en",locale);
						}
						alOrderSchDetail.add(admin_rec_date);//18
						alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_RECORDED_BY"))); //19
						alOrderSchDetail.add(checkForNull(resultSet.getString("IV_PREP_YN")));//20
						alOrderSchDetail.add(ext_prod_id);//21
						alOrderSchDetail.add(drug_count);//22
						str_date= checkForNull(resultSet.getString("START_DATE_TIME"));
						if(!str_date.equals("") && !locale.equals("en")){
							str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
						}
						alOrderSchDetail.add(str_date);//23
						alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_DATE")));//24
						alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_TIME")));//25
						alOrderSchDetail.add(checkForNull(resultSet.getString("SPLIT_DOSE_YN")));//26
						alOrderSchDetail.add(checkForNull(resultSet.getString("SRL_NO"),"1"));//27
						alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_HOLD_DATE_TIME")));//28
						alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_DISC_DATE_TIME")));//29
					}
					if(hmIVDrugDetails.containsKey(orderKey)){
						alTmpOrderSchDetail = (ArrayList)hmIVDrugDetails.get(orderKey);
						alTmpOrderSchDetail.add(alOrderSchDetail);
						hmIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
					}
					else{
						alTmpOrderSchDetail = new ArrayList();
						alTmpOrderSchDetail.add(alOrderSchDetail);
						hmIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
					}
					if(hmSchList.containsKey(orderKey+"SCH")){
						uniqueSchedules= (LinkedHashSet<String>)hmSchList.get(orderKey+"SCH");
						uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
						hmSchList.put(orderKey+"SCH", uniqueSchedules);
					}
					else{
						uniqueSchedules= new LinkedHashSet<String>();
						uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
						hmSchList.put(orderKey+"SCH", uniqueSchedules);
					}
				}
			}
			if(order_type.equals("A")){
				strQuery ="SELECT a.order_id, a.order_line_num, e.iv_prep_yn, a.admin_recorded_yn, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN ( f.admin_drug_code || ':' || (SELECT long_name FROM ph_tpn_regimen_lang_vw ph_tpn_regimen WHERE tpn_regimen_code = f.admin_drug_code AND language_id = ?) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) WHEN a.ord_drug_code = 'FINAL PRODUCT' AND NVL (administered_yn, 'N') = 'Y' THEN 'FINAL PRODUCT:' || ( (SELECT mfg_unit FROM ph_tpn_worksheet_hdr WHERE tpn_worksheet_id = (SELECT DISTINCT tpn_worksheet_id FROM ph_tpn_worksheet_dtl WHERE order_id = (SELECT DISTINCT order_id FROM ph_medn_admin WHERE order_id = a.order_id AND order_line_num = a.order_line_num AND NVL (administered_yn, 'N' ) = 'Y'))) || ':' || f.admin_dosage_qty || ':' || f.admin_dosage_uom_code ) END ) administereddrug, a.dosage_seq_no, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY HH24:MI') sch_date_time, a.admin_recorded_yn, DECODE (d.disc_date_time, NULL, 'N', 'Y') discontinued, TO_CHAR (d.disc_date_time, 'DD/MM/YYYY HH24:MI') ORD_DISC_DATE_TIME, DECODE (d.hold_date_time, NULL, 'N', 'Y') held, TO_CHAR (d.HOLD_DATE_TIME, 'DD/MM/YYYY HH24:MI') ORD_HOLD_DATE_TIME, a.patient_id, a.pract_id, NVL ((SELECT disp_drug_code FROM ph_disp_dtl WHERE ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND ROWNUM < 2), (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.long_name ELSE 'FINAL PRODUCT' END ) ) drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.tpn_regimen_code ELSE 'FINAL PRODUCT' END ) pres_drug_code, (CASE WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN NVL ((SELECT long_name FROM ph_tpn_regimen_lang_vw ph_tpn_regimen, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_tpn_regimen.tpn_regimen_code AND ph_disp_dtl.order_id = a.order_id AND ph_disp_dtl.order_line_no = a.order_line_num AND language_id = ? AND ROWNUM < 2), b.long_name ) ELSE (SELECT mfg_unit FROM ph_tpn_worksheet_hdr hdr WHERE EXISTS ( SELECT DISTINCT tpn_worksheet_id FROM ph_tpn_worksheet_dtl b WHERE order_id = (SELECT DISTINCT order_id FROM ph_medn_admin WHERE order_id = a.order_id AND order_line_num = a.order_line_num) AND b.tpn_worksheet_id = hdr.tpn_worksheet_id) AND ROWNUM < 2) END ) drug_desc, a.iv_ingrediants, TO_CHAR (d.start_date_time, 'DD/MM/YYYY HH24:MI') start_date_time, TO_CHAR (d.end_date_time, 'DD/MM/YYYY HH24:MI') end_date_time, h.freq_nature, TO_CHAR (a.against_schdose_date_time, 'DD/MM/YYYY HH24:MI' ) against_schdose_date_time, a.adr_reason_code, a.adr_remarks, TO_CHAR (a.adr_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) adr_recorded_date_time, a.adr_recorded_by, TO_CHAR (a.sch_date_time, 'DD/MM/YYYY') sch_date, TO_CHAR (a.sch_date_time, 'HH24:MI') sch_time, o.split_dose_yn, f.srl_no FROM ph_medn_admin a, ph_tpn_regimen_lang_vw b, or_order_line d, or_order e, ph_medn_admin_dtl f, am_frequency_lang_vw h, ph_patient_drug_profile i, or_order_line_ph o WHERE h.freq_code = d.freq_code AND f.encounter_id(+) = a.encounter_id AND f.order_id(+) = a.order_id AND f.facility_id(+) = a.facility_id AND f.ord_drug_code(+) = a.ord_drug_code AND a.dosage_seq_no = f.dosage_seq_no(+) AND f.sch_date_time(+) = a.sch_date_time AND e.order_id = d.order_id AND o.order_id = d.order_id AND o.order_line_num = d.order_line_num AND i.orig_order_id = d.order_id AND i.orig_order_line_no = d.order_line_num AND e.order_id = i.orig_order_id AND a.ord_drug_code = b.tpn_regimen_code(+) AND a.order_id = d.order_id AND a.order_line_num = d.order_line_num AND a.facility_id = ? AND a.encounter_id = ? AND a.sch_date_time >= d.start_date_time AND SYSDATE <= d.end_date_time AND d.can_date_time IS NULL AND e.iv_prep_yn IN ('7', '8') AND b.language_id(+) = ? AND h.language_id(+) = ?";

				appendString =  " AND ( (trunc(a.sch_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')) OR (H.FREQ_NATURE='P'  and TRUNC(d.end_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY'))) ";  //Added for SKR-SCF-0836 [IN:044162]

				/*if(administration_status!=null && (administration_status.equals("OVERDUE") || administration_status.equals("DUE"))){
					appendString =" AND SYSDATE<=D.END_DATE_TIME AND (( trunc(a.sch_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND (ADMIN_RECORDED_YN='N' OR ADMIN_RECORDED_YN IS NULL)) )   "; 
				} 
				else if(administration_status!=null && administration_status.equals("ALL")) {
					appendString = " AND (( trunc(a.sch_date_time) BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')) OR (H.FREQ_NATURE='P'  AND (D.ORDER_QTY-NVL(I.TOT_ADMINISTERED_QTY,0))>0 ) ) ";
				}*///Commented for SKR-SCF-0836 [IN:044162]

				if(appendString==null)
					appendString="";

				if(!hold_discontinue_yn.equals("Y")){
					strQuery = strQuery + (appendString + " AND d.HOLD_DATE_TIME IS NULL AND DISC_DATE_TIME IS NULL AND CAN_DATE_TIME IS NULL ORDER BY E.IV_PREP_YN, ");	
				}
				else{
					strQuery = strQuery + (appendString +" ORDER BY E.IV_PREP_YN, ");
				}

				if(display_order_by.equals("D")){
					display_order_str = "drug_desc ||D.ORDER_ID||to_char(D.ORDER_LINE_NUM)";
				}
				else if(display_order_by.equals("F")){
					if(order_type.equals("TPN"))
						display_order_str = "D.ORDER_ID||to_char(D.ORDER_LINE_NUM)";
					else
						display_order_str = "form_desc||D.ORDER_ID||to_char(D.ORDER_LINE_NUM)";			
				}
				else { 
					display_order_str = "e.ORD_DATE_TIME||D.ORDER_ID||to_char(D.ORDER_LINE_NUM)";
				}		
				order_by_str = display_order_str+" ,a.DOSAGE_SEQ_NO, decode (h.freq_nature,  'P', '', sch_time),  to_date(sch_date,'DD/MM/YYYY')";

				strQuery = strQuery + order_by_str;
				pstmt = connection.prepareStatement( strQuery ) ;
				pstmt.setString(1,locale );
				pstmt.setString(2,locale );
				pstmt.setString(3,login_facility_id);
				pstmt.setString(4,encounter_id.trim());			
				pstmt.setString(5,locale );
				pstmt.setString(6,locale );
				pstmt.setString(7,from_date );
				pstmt.setString(8,to_date );
				pstmt.setString(9,from_date );
				pstmt.setString(10,to_date );

				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ){
					drugCode = checkForNull(resultSet.getString("DRUG_CODE"));
					order_id = checkForNull(resultSet.getString("ORDER_ID"));
					orderKey = order_id+"_"+resultSet.getString("ORDER_LINE_NUM");
				
					alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_CODE")));//1
					alOrderSchDetail.add(checkForNull(resultSet.getString("DRUG_DESC")));//2
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_ID")));	//3				
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));	//4
					alOrderSchDetail.add(checkForNull(resultSet.getString("PATIENT_ID")));//5

					str_date= checkForNull(resultSet.getString("SCH_DATE_TIME"));
					if(!str_date.equals("") && !locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date); //6
					alOrderSchDetail.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));//7
					alOrderSchDetail.add(checkForNull(resultSet.getString("DISCONTINUED")));//8
					alOrderSchDetail.add(checkForNull(resultSet.getString("HELD")));		//9			
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMINISTERED_YN")));//10
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADMIN_RECORDED_YN")));//11
					str_date= checkForNull(resultSet.getString("END_DATE_TIME"));
					if(!str_date.equals("") && !locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date);//13

					alOrderSchDetail.add(checkForNull(resultSet.getString("FREQ_NATURE")));//13
					alOrderSchDetail.add(checkForNull(resultSet.getString("PRACT_ID")));//14
					
					str_date= checkForNull(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME"));
					if(!str_date.equals("") && !locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date);//15
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REASON_CODE")));//16
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_REMARKS")));//17
					
					admin_rec_date= checkForNull(resultSet.getString("ADR_RECORDED_DATE_TIME"));
					if(!admin_rec_date.equals("") && !locale.equals("en")){
						admin_rec_date = com.ehis.util.DateUtils.convertDate(admin_rec_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date);//18
					alOrderSchDetail.add(checkForNull(resultSet.getString("ADR_RECORDED_BY")));//19
					alOrderSchDetail.add("");//20
					alOrderSchDetail.add(checkForNull(resultSet.getString("IV_INGREDIANTS")));//21				
					str_date= checkForNull(resultSet.getString("START_DATE_TIME"));
					if(!str_date.equals("") && !locale.equals("en")){
						str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMYHM","en",locale);
					}
					alOrderSchDetail.add(str_date);//22
					alOrderSchDetail.add(checkForNull(drug_count));  //23  drug count for Oncology Direct Order
					alOrderSchDetail.add(checkForNull(""));  //24 ext_prod_id
					alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_DATE")));//25
					alOrderSchDetail.add(checkForNull(resultSet.getString("SCH_TIME")));//26
					alOrderSchDetail.add(checkForNull(resultSet.getString("SPLIT_DOSE_YN")));//27
					alOrderSchDetail.add(checkForNull(resultSet.getString("IV_PREP_YN")));//28
					alOrderSchDetail.add(checkForNull(resultSet.getString("SRL_NO"),"1"));//29
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_HOLD_DATE_TIME")));//30
					alOrderSchDetail.add(checkForNull(resultSet.getString("ORD_DISC_DATE_TIME")));//31
					if(hmNonIVDrugDetails.containsKey(orderKey)){
						alTmpOrderSchDetail = (ArrayList)hmNonIVDrugDetails.get(orderKey);
						alTmpOrderSchDetail.add(alOrderSchDetail);
						hmNonIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
					}
					else{
						alTmpOrderSchDetail = new ArrayList();
						alTmpOrderSchDetail.add(alOrderSchDetail);
						hmNonIVDrugDetails.put(orderKey, alTmpOrderSchDetail);
					}
					if(hmSchList.containsKey(orderKey+"SCH")){
						uniqueSchedules= (LinkedHashSet<String>)hmSchList.get(orderKey+"SCH");
						if(((String)resultSet.getString("FREQ_NATURE")).equals("P"))
							uniqueSchedules.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));
						else
							uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
					}
					else{
						uniqueSchedules= new LinkedHashSet<String>();
						if(((String)resultSet.getString("FREQ_NATURE")).equals("P"))
							uniqueSchedules.add(checkForNull(resultSet.getString("DOSAGE_SEQ_NO")));
						else
							uniqueSchedules.add(checkForNull(resultSet.getString("SCH_TIME")));
					}
					hmSchList.put(orderKey+"SCH", uniqueSchedules);
				}
			}
		}
		catch ( Exception e ){
			System.err.println("=======strQuery=====>"+strQuery);
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
		drug_details.put("iv_prep_yn",iv_prep_yn);
		drug_details.put("NON_IV",hmNonIVDrugDetails);
		drug_details.put("IV",hmIVDrugDetails);
		drug_details.put("SCHLIST",hmSchList);
		return drug_details;
	}

	public ArrayList getIVSchecdule(String orderID, String order_line_num,String adminFromDateTime, String adminToDateTime,String iv_prep_yn,String drug_code){ //iv_prep_yn,drug_code  parameter added for SKR-SCF-1420
		Connection oConnection				= null;
		ArrayList ivScheduleDtl				=new ArrayList();
		PreparedStatement oPreparedStmt		= null;      		
		PreparedStatement oPreparedStmtFlowStatus	= null;      		
		ResultSet oResultSet				= null;
		ResultSet oResultSetFlowStatus				= null;
		HashMap ivFlowStatus=new HashMap();
		String flowStatus = "", schCanAdmin="N", schDateTime="", ivPrevSchStatus="NS", ivPrevSchCanAdmin="N", admin_yn="", admin_rec_yn="" ;
		String no_of_dose = "";//SKR-SCF-1421
		int flow_count=0;
//		boolean blSchCanAdmin = false;Removed for IN063877
//System.err.println("getIVSchecdule====orderID="+orderID+" order_line_num="+order_line_num+" adminFromDateTime="+adminFromDateTime+" adminToDateTime="+adminToDateTime);
		try{  
			oConnection	= getConnection() ;
      //(SELECT CANCEL_RECORDED_YN FROM ph_medn_admin   WHERE order_id = ? AND order_line_num = ?  AND dosage_seq_no = a.dosage_seq_no ) CANCEL_RECORDED_YN,(SELECT to_char(SCH_DATE_TIME,'HH24:MI') FROM ph_medn_admin   WHERE order_id = ? AND order_line_num = ?  AND dosage_seq_no = a.dosage_seq_no ) act_sch_time added for jd-crf-0200
			//String sqlString="select dosage_seq_no, ( dosage_seq_no || '/' || CEIL ( tot_infusion_over / orig_infuse_over * DECODE (infuse_over_unit, 'H', 1, 'M', 60) ) ) no_of_doses, TO_CHAR ( nvl((select act_start_date_time from ph_medn_admin where order_id = ? AND order_line_num = ? and DOSAGE_SEQ_NO = a.dosage_seq_no),start_date_time) + decode(nvl((select 0 from ph_medn_admin where order_id = ? AND order_line_num = ? and DOSAGE_SEQ_NO = a.dosage_seq_no),1),0,0,DECODE (dosage_seq_no, 1, 0, ( (dosage_seq_no - 1) * DECODE (infuse_over_unit, 'H', orig_infuse_over / 24, 'M', orig_infuse_over / 24 * 60 ) ) )), 'dd/mm/yyyy' ) start_date, TO_CHAR ( nvl((select act_start_date_time from ph_medn_admin where order_id = ? AND order_line_num = ? and DOSAGE_SEQ_NO = a.dosage_seq_no),start_date_time) + decode(nvl((select 0 from ph_medn_admin where order_id = ? AND order_line_num = ? and DOSAGE_SEQ_NO = a.dosage_seq_no),1),0,0,DECODE (dosage_seq_no, 1, 0, ( (dosage_seq_no-nvl((select max(dosage_seq_no) from ph_medn_admin where order_id = ? AND order_line_num = ?),0)-1) * DECODE (infuse_over_unit, 'H', orig_infuse_over / 24, 'M', orig_infuse_over / 24 * 60 ) ) )), 'HH24:MI' ) start_time from ( select LEVEL dosage_seq_no, tot_infusion_over ,orig_infuse_over , infuse_over_unit, start_date_time, infuse_over FROM (SELECT tot_infusion_over, orig_infuse_over, infuse_over_unit, infuse_over, b.start_date_time, 'O' ord_med_level, b.end_date_time end_date_time FROM or_order_line_ph a, or_order_line b WHERE a.order_id = ? AND a.order_line_num = ? AND a.order_id = b.order_id AND a.order_line_num = b.order_line_num AND NOT EXISTS ( SELECT 'Y' FROM ph_medn_admin WHERE order_id = ? AND order_line_num = ? AND sch_date_time = TO_DATE (TO_CHAR (b.start_date_time, 'DD/MM/YYYY HH24:MI' ), 'DD/MM/YYYY HH24:MI' )) AND ROWNUM <= 1 UNION select * from (SELECT tot_infusion_over, orig_infuse_over, infuse_over_unit, infuse_over, nvl2(b.act_end_date_time,(b.act_end_date_time+1/1440),nvl( b.act_start_date_time, b.sch_date_time)) start_date_time, 'M' ord_med_level, act_end_date_time end_date_time FROM or_order_line_ph a, ph_medn_admin b WHERE a.order_id = ? AND a.order_line_num = ? AND a.order_id = b.order_id AND a.order_line_num = b.order_line_num order by b.DOSAGE_SEQ_NO desc ) where ROWNUM <= 1 ) a CONNECT BY LEVEL <= CEIL ( tot_infusion_over / orig_infuse_over * DECODE (infuse_over_unit, 'H', 1, 'M', 60) ) ORDER BY level) A ";
			String sqlString="SELECT dosage_seq_no, ( dosage_seq_no || '/' || CEIL ( tot_infusion_over / orig_infuse_over * DECODE (infuse_over_unit, 'H', 1, 'M', 60) ) ) no_of_doses, TO_CHAR ( NVL ((SELECT act_start_date_time FROM ph_medn_admin WHERE order_id = ? AND order_line_num = ? AND dosage_seq_no = a.dosage_seq_no), start_date_time ) + DECODE (NVL ((SELECT 0 FROM ph_medn_admin WHERE order_id = ? AND order_line_num = ? AND dosage_seq_no = a.dosage_seq_no), 1 ), 0, 0, DECODE (dosage_seq_no, 1, 0, ( (dosage_seq_no - 1) * DECODE (infuse_over_unit, 'H', orig_infuse_over / 24, 'M', orig_infuse_over / 24 * 60 ) ) ) ), 'dd/mm/yyyy' ) start_date, TO_CHAR ( NVL ((SELECT act_start_date_time FROM ph_medn_admin WHERE order_id = ? AND order_line_num = ? AND dosage_seq_no = a.dosage_seq_no), start_date_time ) + DECODE (NVL ((SELECT 0 FROM ph_medn_admin WHERE order_id = ? AND order_line_num = ? AND dosage_seq_no = a.dosage_seq_no), 1 ), 0, 0, DECODE (dosage_seq_no, 1, 0, ( ( dosage_seq_no - NVL ((SELECT MAX (dosage_seq_no)-1 FROM ph_medn_admin WHERE order_id = ? AND order_line_num = ?), 0 ) - 1 ) * DECODE (infuse_over_unit, 'H', orig_infuse_over / 24, 'M', orig_infuse_over / 24 * 60 ) ) ) ), 'HH24:MI' ) start_time,(SELECT CANCEL_RECORDED_YN FROM ph_medn_admin   WHERE order_id = ? AND order_line_num = ?  AND dosage_seq_no = a.dosage_seq_no ) CANCEL_RECORDED_YN,(SELECT to_char(SCH_DATE_TIME,'HH24:MI') FROM ph_medn_admin   WHERE order_id = ? AND order_line_num = ?  AND dosage_seq_no = a.dosage_seq_no ) act_sch_time FROM (SELECT LEVEL dosage_seq_no, tot_infusion_over, orig_infuse_over, infuse_over_unit, start_date_time, infuse_over FROM (SELECT tot_infusion_over, orig_infuse_over, infuse_over_unit, infuse_over, b.start_date_time, 'O' ord_med_level, b.end_date_time end_date_time FROM or_order_line_ph a, or_order_line b WHERE a.order_id = ? AND a.order_line_num = ? AND a.order_id = b.order_id AND a.order_line_num = b.order_line_num AND NOT EXISTS ( SELECT 'Y' FROM ph_medn_admin WHERE order_id = ? AND order_line_num = ? AND sch_date_time = TO_DATE (TO_CHAR (b.start_date_time, 'DD/MM/YYYY HH24:MI' ), 'DD/MM/YYYY HH24:MI' )) AND ROWNUM <= 1 UNION SELECT * FROM (SELECT tot_infusion_over, orig_infuse_over, infuse_over_unit, infuse_over, NVL2 (b.act_end_date_time, (b.act_end_date_time + 1 / 1440 ), NVL (b.act_start_date_time, b.sch_date_time ) ) start_date_time, 'M' ord_med_level, act_end_date_time end_date_time FROM or_order_line_ph a, ph_medn_admin b WHERE a.order_id = ? AND a.order_line_num = ? AND a.order_id = b.order_id AND a.order_line_num = b.order_line_num ORDER BY b.dosage_seq_no DESC) WHERE ROWNUM <= 1) a CONNECT BY LEVEL <= /*CEIL ( tot_infusion_over / orig_infuse_over * DECODE (infuse_over_unit, 'H', 1, 'M', 60) ) */ (SELECT NVL( ceil(qty_value/NVL(CONTENT_IN_PRES_BASE_UOM,0)) * CEIL (NVL( tot_infusion_over,0)  / NVL(orig_infuse_over,0)  * DECODE (infuse_over_unit, 'H', 1, 'M', 60)),0) FROM or_order_line_ph a, or_order_line b,ph_drug c  WHERE a.order_id = b.order_id  AND b.order_category = 'PH' AND a.order_line_num = b.order_line_num AND b.order_Catalog_code= c.drug_code	AND a.order_id = ? AND a.order_line_num = ? ) ORDER BY LEVEL) a ";
		//(SELECT NVL( ceil(qty_value/NVL(CONTENT_IN_PRES_BASE_UOM,0)) * CEIL (NVL( tot_infusion_over,0)  / NVL(orig_infuse_over,0)  * DECODE (infuse_over_unit, 'H', 1, 'M', 60)),0) FROM or_order_line_ph a, or_order_line b,ph_drug c  WHERE a.order_id = b.order_id  AND b.order_category = 'PH' AND a.order_line_num = b.order_line_num AND b.order_Catalog_code= c.drug_code	AND a.order_id = ? AND a.order_line_num = ? added for SKR-SCF-1420
			oPreparedStmt		= oConnection.prepareStatement(sqlString);
			int count=0;
			oPreparedStmt.setString(++count,orderID);	//1	 	
			oPreparedStmt.setString(++count,order_line_num);			
			oPreparedStmt.setString(++count,orderID);			
			oPreparedStmt.setString(++count,order_line_num);			
			oPreparedStmt.setString(++count,orderID);			
			oPreparedStmt.setString(++count,order_line_num);			
			oPreparedStmt.setString(++count,orderID);			//5
			oPreparedStmt.setString(++count,order_line_num);			
			oPreparedStmt.setString(++count,orderID);			
			oPreparedStmt.setString(++count,order_line_num);			
			oPreparedStmt.setString(++count,orderID);			//5
			oPreparedStmt.setString(++count,order_line_num);			
			oPreparedStmt.setString(++count,orderID);			
			oPreparedStmt.setString(++count,order_line_num);			
			oPreparedStmt.setString(++count,orderID);			
			oPreparedStmt.setString(++count,order_line_num);	//10		
			oPreparedStmt.setString(++count,orderID);			
			oPreparedStmt.setString(++count,order_line_num);			
			oPreparedStmt.setString(++count,orderID);			
			oPreparedStmt.setString(++count,order_line_num);			
			oPreparedStmt.setString(++count,orderID);			//SKR-SCF-1421
			oPreparedStmt.setString(++count,order_line_num);	//SKR-SCF-1421		
			oResultSet	= oPreparedStmt.executeQuery() ;
			
			sqlString ="select dosage_seq_no, flow_status, ADMINISTERED_YN, ADMIN_RECORDED_YN, (SELECT 'Y' FROM DUAL  WHERE sch_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')) schcanadmin from ph_medn_admin where order_id=? and order_line_num=? order by dosage_seq_no";
			oPreparedStmtFlowStatus		= oConnection.prepareStatement(sqlString);
			oPreparedStmtFlowStatus.setString(1,adminFromDateTime);			
			oPreparedStmtFlowStatus.setString(2,adminToDateTime);			
			oPreparedStmtFlowStatus.setString(3,orderID);			
			oPreparedStmtFlowStatus.setString(4,order_line_num);			
			oResultSetFlowStatus	= oPreparedStmtFlowStatus.executeQuery() ;
			if(oResultSetFlowStatus !=null){
				while(oResultSetFlowStatus.next()){
					admin_yn=checkForNull(oResultSetFlowStatus.getString("ADMINISTERED_YN"));
					admin_rec_yn=checkForNull(oResultSetFlowStatus.getString("ADMIN_RECORDED_YN"));
					if(admin_yn.equals("Y") && admin_rec_yn.equals("Y"))
						flowStatus = "AD";
					else
						flowStatus = checkForNull(oResultSetFlowStatus.getString("FLOW_STATUS"),"NS");
					ivFlowStatus.put(checkForNull(oResultSetFlowStatus.getString("DOSAGE_SEQ_NO")),flowStatus); 
					ivFlowStatus.put(checkForNull(oResultSetFlowStatus.getString("DOSAGE_SEQ_NO"))+"_SCHCANADMIN", checkForNull(oResultSetFlowStatus.getString("SCHCANADMIN"),"N")); 
				}
			}
			closeResultSet( oResultSetFlowStatus ) ;
			closeStatement( oPreparedStmtFlowStatus ) ;					
			//sqlString ="SELECT 'Y' SCHCANADMIN FROM DUAL  WHERE TO_DATE (?, 'DD/MM/YYYY HH24:MI') BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI') ";
			sqlString ="SELECT 'Y' schcanadmin FROM DUAL WHERE SYSDATE < = TO_DATE (?, 'DD/MM/YYYY HH24:MI') + ((SELECT NVL (rec_admin_within_hrs, 1) FROM ph_facility_param WHERE facility_id = ?) / 24) ";
			oPreparedStmtFlowStatus		= oConnection.prepareStatement(sqlString);

			if(oResultSet !=null){
				while(oResultSet.next()){
					flow_count++;
					//added for SKR-SCF-1421 - start
					if(iv_prep_yn!=null && (iv_prep_yn.equals("5") || (iv_prep_yn.equals("1") && order_line_num.equals("1")))){
					 no_of_dose = getNoOfDoses(orderID,order_line_num,iv_prep_yn,drug_code);

					 if(no_of_dose==null || no_of_dose.equals(""))
						ivScheduleDtl.add(checkForNull(oResultSet.getString("NO_OF_DOSES"))); //0 
					 else
						ivScheduleDtl.add(flow_count+"/"+no_of_dose); //0 
					 }else{
						 ivScheduleDtl.add(checkForNull(oResultSet.getString("NO_OF_DOSES"))); //0
					 }
					 //added for SKR-SCF-1421 - end
//					ivScheduleDtl.add(checkForNull(oResultSet.getString("NO_OF_DOSES"))); //0
					ivScheduleDtl.add(checkForNull(oResultSet.getString("START_DATE")));
					ivScheduleDtl.add(checkForNull(oResultSet.getString("START_TIME")));//2
					schDateTime = checkForNull(oResultSet.getString("START_DATE"))+" "+checkForNull(oResultSet.getString("START_TIME"));
					flowStatus = "NS";
					schCanAdmin="N";
					if(ivFlowStatus.containsKey(flow_count+"")){
						flowStatus = (String)ivFlowStatus.get(flow_count+"");
						schCanAdmin = (String)ivFlowStatus.get(flow_count+"_SCHCANADMIN");
						ivPrevSchStatus =flowStatus;
					//System.err.println("==B4=================flowStatus=="+flowStatus+" ivPrevSchStatus="+ivPrevSchStatus+" ivPrevSchCanAdmin="+ivPrevSchCanAdmin+" schCanAdmin="+schCanAdmin);
						if(!(flowStatus.equals("AD") || flowStatus.equals("CO"))  && schCanAdmin.equals("Y")){
							ivPrevSchCanAdmin = "Y";
							schCanAdmin="Y";
						}
						else if(flowStatus.equals("CO")){
							schCanAdmin="N";
							ivPrevSchCanAdmin = "N";
						}
					//System.err.println("===flowStatus=="+flowStatus+" ivPrevSchStatus="+ivPrevSchStatus+" ivPrevSchCanAdmin="+ivPrevSchCanAdmin+" schCanAdmin="+schCanAdmin);
					}
					else{
					//System.err.println("==B4====ELSE=============flowStatus=="+flowStatus+" ivPrevSchStatus="+ivPrevSchStatus+" ivPrevSchCanAdmin="+ivPrevSchCanAdmin+" schCanAdmin="+schCanAdmin);
						if( flowStatus.equals("NS") && ((!ivPrevSchStatus.equals("NS") && schCanAdmin.equals("N"))|| ivPrevSchStatus.equals("CO")) && ivPrevSchCanAdmin.equals("N")){
							oPreparedStmtFlowStatus.setString(1,schDateTime);			
							oPreparedStmtFlowStatus.setString(2,login_facility_id);			
							//oPreparedStmtFlowStatus.setString(2,adminFromDateTime);			
							//oPreparedStmtFlowStatus.setString(3,adminToDateTime);			
							oResultSetFlowStatus	= oPreparedStmtFlowStatus.executeQuery() ;
							if(oResultSetFlowStatus !=null && oResultSetFlowStatus.next()){
								ivPrevSchCanAdmin = checkForNull(oResultSetFlowStatus.getString("SCHCANADMIN"),"N"); 
							}
							if(ivPrevSchCanAdmin.equals("Y")){
								schCanAdmin = "Y";
							}
						}
					//System.err.println("==B4====ELSE=============flowStatus=="+flowStatus+" ivPrevSchStatus="+ivPrevSchStatus+" ivPrevSchCanAdmin="+ivPrevSchCanAdmin+" schCanAdmin="+schCanAdmin);
					}
					ivScheduleDtl.add(flowStatus);//3
					ivScheduleDtl.add(schCanAdmin);//4
					ivScheduleDtl.add(checkForNull(oResultSet.getString("DOSAGE_SEQ_NO"))); //5
					ivScheduleDtl.add(checkForNull(oResultSet.getString("CANCEL_RECORDED_YN"))); //6//ADDED FOR JD-CRF-0200
					ivScheduleDtl.add(checkForNull(oResultSet.getString("act_sch_time"))); //7//ADDED FOR JD-CRF-0200
					
				}
			}
			/*for(int i=0; i<ivScheduleDtl.size(); i+=6){
				flowStatus =(String)ivScheduleDtl.get(i+3); 
				schCanAdmin =(String)ivScheduleDtl.get(i+4); 
				if(flowStatus.equals("CO")){
					ivScheduleDtl.set(i+4, "N");
					schCanAdmin = "N";
				}
				if(!blSchCanAdmin && schCanAdmin.equals("Y") ){
					ivScheduleDtl.set(i+4, "Y");
					blSchCanAdmin = true;
				}
				else
					ivScheduleDtl.set(i+4, "N");
			}*/
		}
		catch (Exception execption){
			System.err.println("============ivScheduleDtl=>"+ivScheduleDtl);
			execption.printStackTrace();
		}
		finally{
			try{
				closeConnection( oConnection ); 
				closeResultSet( oResultSet ) ;
				closeStatement( oPreparedStmt ) ;					
				closeResultSet( oResultSetFlowStatus ) ;
				closeStatement( oPreparedStmtFlowStatus ) ;					
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return ivScheduleDtl;
	}
	
	//added for AAKH-CRF-0024 [IN:038260] Starts
	public ArrayList getNonAdminRemarks(String drug_code,String dosage_seq,String encounter_id,String order_id,String sch_date_time) throws Exception{
		Connection connection = null;
		ResultSet rsMedAdmin = null;
		StringBuilder builderSql = new StringBuilder();
		//added APPL_TRN_TYPE condition for IN043190
		builderSql.append("SELECT MA.NON_ADMIN_REMARKS , MA.NON_ADMIN_CODE,RD.REASON_DESC FROM PH_MEDN_ADMIN MA,PH_MEDN_TRN_REASON_LANG_VW RD WHERE  RD.REASON_CODE=MA.NON_ADMIN_CODE  AND  RD.APPL_TRN_TYPE = ? AND  MA.FACILITY_ID=? AND MA.ENCOUNTER_ID=? AND MA.SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') AND MA.ORD_DRUG_CODE=? AND MA.DOSAGE_SEQ_NO=? and MA.order_id=? ");
		PreparedStatement psMedAdmin = null;
		ArrayList nonAdminRemarks = new ArrayList();
		try {
			connection = getConnection();
			psMedAdmin = connection.prepareStatement(builderSql.toString());
			//Changed index and added APPL_TRN_TYPE for IN043190
			psMedAdmin.setString(1, "M");
			psMedAdmin.setString(2, login_facility_id);
			psMedAdmin.setString(3, encounter_id);
			psMedAdmin.setString(4, sch_date_time);
			psMedAdmin.setString(5, drug_code);
			psMedAdmin.setString(6, dosage_seq);
			psMedAdmin.setString(7,order_id);
			rsMedAdmin = psMedAdmin.executeQuery();
			while(rsMedAdmin.next()){			
				nonAdminRemarks.add(rsMedAdmin.getString("NON_ADMIN_REMARKS"));
				nonAdminRemarks.add(rsMedAdmin.getString("NON_ADMIN_CODE"));
				nonAdminRemarks.add(rsMedAdmin.getString("REASON_DESC"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			closeResultSet( rsMedAdmin ) ;
			closeStatement( psMedAdmin ) ;					
			closeConnection( connection );
		}
		
		return nonAdminRemarks;
		
	}//added for AAKH-CRF-0024 [IN:038260] Ends  
	
	public String chkfortapering(String order_id,String order_catalog_code, String patient_id) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String taper_YN			= "N";
		int count=0;
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT131")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,order_catalog_code);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				count	=	resultSet.getInt("TOTAL");	
			}
			if(count>1){
				taper_YN="Y";
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
		return taper_YN;
	}	

	public void addTaperSchedule(String key){		 
		HashMap  hmTempAddedTaperSch = getAddedTaperSch();
		Integer SrlNo = 0;
		if(hmTempAddedTaperSch == null)
			hmTempAddedTaperSch = new HashMap();
		if(hmTempAddedTaperSch.containsKey(key))
			SrlNo = (Integer)hmTempAddedTaperSch.get(key);
		hmTempAddedTaperSch.put(key, SrlNo+1);
		setAddedTaperSch(hmTempAddedTaperSch);
	}

	public HashMap insertSFRAdminDetailsSCH(Hashtable iv_admin_drug_details){
		String auto_admin		="";
		ArrayList dispTmp	 = new ArrayList() ;
		ArrayList iv	=new ArrayList();
	   	HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in insert.." ) ;
		map.put( "flag", "0" ) ;
		locale = getLanguageId()==null?"en":getLanguageId();

		try{
			if("Y".equals(getUserAuthPINRequiredYN()))
				login_by_id=getAuthUserID();
			setTodaysDate();
			HashMap drug_details = divideDrugsBasedOnProperties(iv_admin_drug_details);
			HashMap validate_mand = validateForMandatory(drug_details);
			iv=getIvDetails();
//			ArrayList non_iv_drugs=(ArrayList)drug_details.get("NON_IV_DRUGS");Removed for IN063877
			ArrayList iv_drugs=(ArrayList)drug_details.get("IV_DRUGS");
			for (int i=0;i<iv_drugs.size() ;i=i+42){ //Changed 40 to 41 //Replcaed 39 with 40 for HSA-CRF-0090//AAKH-CRF-0024 [IN:038260] and changed 41 to 42 for SKR-SCF-1240
				auto_admin=(String)iv_drugs.get(i+36)==null?"":(String)iv_drugs.get(i+36);
			}
 			if(auto_admin.equals("Y")){				
				dispTmp=formDispensingDetails(null,iv,null);
			}
			if(validate_mand.get("message") != null && !((String)validate_mand.get("message")).equals("")){
				return validate_mand;
			}
			String today = getTodaysDate();// added for LEAP-INT-PH-SCF-14965 [IN:004059]-end
			String todayDateTime = getTodaysDateTime();
			if(!locale.equals("en")){
				today = com.ehis.util.DateUtils.convertDate(today, "DMY",locale,"en");
				todayDateTime = com.ehis.util.DateUtils.convertDate(todayDateTime, "DMY",locale,"en");
			}// added for LEAP-INT-PH-SCF-14965 [IN:004059] -end
			HashMap tabData = new HashMap() ;
			HashMap commonValues = (HashMap) drug_details.get("COMMON_VALUES");
			commonValues.put("admin_mode","IVADMINSCH");
			tabData.put( "ONLY_STOCK_UPDATE", "N");
			tabData.put( "properties", getProperties() );
			tabData.put( "COMMON_VALUES",  commonValues);
			tabData.put( "IV_DRUGS",  drug_details.get("IV_DRUGS"));
			tabData.put( "ADR_VALUES",  this.adrDetails);
			tabData.put( "ADR_REASON",  this.adrReason);
			tabData.put( "ADR_ALL_VALUES",  this.all_dtls);
			tabData.put( "update_remarks",this.all_remarks);
			tabData.put( "disp_stage", "D");
			tabData.put( "today",today);// getTodaysDate() changed for LEAP-INT-PH-SCF-14965 [IN:004059]
			tabData.put( "dateTime",todayDateTime);//getTodaysDateTime() changed for LEAP-INT-PH-SCF-14965 [IN:004059]
			tabData.put( "stock_srl",this.stock_srl);
			tabData.put( "DISP_DTLS", dispTmp );
			tabData.put( "AddedTaperSch", getAddedTaperSch() );

			tabData.put( "facility_id", login_facility_id.trim() );
			tabData.put( "login_by_id", login_by_id.trim() );
			tabData.put( "login_at_ws_no",login_at_ws_no.trim());
			tabData.put( "patient_class",getPatientClass());
		
			String store_c=getStoreLocnnCode((String)admin_drug_details.get("nursing_unit") ) ;
			
			tabData.put( "disp_locn_code_MAR",store_c );
			tabData.put( "disp_locn_code",store_c );
			tabData.put( "source_code",(String)admin_drug_details.get("nursing_unit"));
			String source_type="";
			if(getPatientClass().equals("I")|| getPatientClass().equals("D") )
				source_type="N";
			else
				source_type="C";
			
			tabData.put( "source_type",source_type);
			tabData.put( "ordering_facility_id",login_facility_id);
			tabData.put( "ord_date_time",admin_drug_details.get("non_iv_sch_date_time_1")); //it is wrong by abdul
			tabData.put( "Auto_admin",auto_admin);

			tabData.put( "patient_id", admin_drug_details.get("patient_id"));
			tabData.put( "encounter_id", admin_drug_details.get("encounter_id"));
		 	tabData.put( "store_code", (String)admin_drug_details.get("disp_locn_code"));
			tabData.put( "language_id", locale);
			
			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_MEDN_ADMIN_DTL_FT_INSERT","INSERT INTO PH_MEDN_ADMIN_DTL ( FACILITY_ID, ENCOUNTER_ID,  SCH_DATE_TIME,  ORD_DRUG_CODE, DOSAGE_SEQ_NO, SRL_NO,  ADMIN_DRUG_CODE, ADMIN_DOSAGE_QTY,  ADMIN_DOSAGE_UOM_CODE,  ADMIN_STRENGTH, ADMIN_STRENGTH_UNIT, ADMIN_INFUSION_RATE, ADMIN_INFUSION_VOL_STR_UNIT, ADMIN_INFUSION_PER_UNIT, ADMIN_BY,  ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,  ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,  MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, ITEM_CODE,  BATCH_ID, EXPIRY_DATE, TRADE_ID,DISP_BATCH_ID,DISP_EXPIRY_DATE,DISP_TRADE_ID, ORDER_ID,VACC_CATEGORY_LINK, ADMIN_BY_TYPE, SELF_ADMIN_BY, ADMIN_REASON_CODE,EARLY_OR_LATE_ADMIN,BATCH_ORDER_ID,BATCH_ORDER_LINE_NUM)   VALUES (  ?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'), ?,?,?,?,?,?,  ?,?,?,  ?,?,?,  ?,SYSDATE,?,  ?,?,SYSDATE,  ?, ?,?,  ?,decode(?,null,null,TO_DATE(?,'dd/mm/yyyy hh24:mi')),?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?, ?, ?,?,?,?)");//BATCH_ORDER_ID,BATCH_ORDER_LINE_NUM added for GHL-CRF-0482 // EARLY_OR_LATE_ADMIN Added for AAKH-SCF-0398
		 	sqlMap.put("SQL_PH_MEDN_ADMIN_OR_ORDER_LINE_PH_UPDATE",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_OR_ORDER_LINE_PH_UPDATE"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE1",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE1"));
			//sqlMap.put("SQL_PH_MEDN_ADMIN_FT_IV_UPDATE","UPDATE PH_MEDN_ADMIN SET FLOW_STATUS='CO', ADMIN_NURSING_UNIT_CODE=?, ADMIN_BED_NO=?, ADMIN_BY = ? , ADMIN_REMARKS=?, NON_ADMIN_REMARKS=?,ADMIN_RECORDED_YN=?, ADMIN_RECORDED_DATE_TIME=SYSDATE,  ADMIN_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ADMINISTERED_YN=? ,MODIFIED_FACILITY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=? ,SCH_INFUSION_RATE=?, SCH_INFUSION_VOL_STR_UNIT=?, SCH_INFUSION_PER_UNIT=?, SCH_INFUSION_PERIOD=?, SCH_INFUSION_PERIOD_UNIT=? ,NON_ADMIN_CODE = ?,ADMIN_RECORDED_BY  = ? ,ADMIN_AUTHORIZED_BY = ?,AGAINST_SCHDOSE_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ADR_REASON_CODE=?, ADR_REMARKS=?, ADR_RECORDED_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ADR_RECORDED_BY=? WHERE   FACILITY_ID=? AND ENCOUNTER_ID=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') AND ORD_DRUG_CODE=? AND DOSAGE_SEQ_NO=? and order_id =?"); 
			//ADMIN_CODE ADDED FOR MMS-KH-CRF-0010
			sqlMap.put("SQL_PH_MEDN_ADMIN_FT_IV_UPDATE","UPDATE PH_MEDN_ADMIN SET FLOW_STATUS='AD', ADMIN_NURSING_UNIT_CODE=?, ADMIN_BED_NO=?, ADMIN_BY = ? , ADMIN_REMARKS=?, NON_ADMIN_REMARKS=?,ADMIN_RECORDED_YN=?, ADMIN_RECORDED_DATE_TIME=SYSDATE,  ADMIN_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ADMINISTERED_YN=? ,MODIFIED_FACILITY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=? ,SCH_INFUSION_RATE=?, SCH_INFUSION_VOL_STR_UNIT=?, SCH_INFUSION_PER_UNIT=?, SCH_INFUSION_PERIOD=?, SCH_INFUSION_PERIOD_UNIT=? ,ADMIN_CODE=?,NON_ADMIN_CODE = ?,ADMIN_RECORDED_BY  = ? ,ADMIN_AUTHORIZED_BY = ?,AGAINST_SCHDOSE_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ADR_REASON_CODE=?, ADR_REMARKS=?, ADR_RECORDED_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ADR_RECORDED_BY=?,ADMN_DOSE_CHNG_REMARKS=? WHERE   FACILITY_ID=? AND ENCOUNTER_ID=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') AND ORD_DRUG_CODE=? AND DOSAGE_SEQ_NO=? and order_id =?"); 
			sqlMap.put("SQL_PH_MEDN_ADMIN_FT_INSERT1",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_FT_INSERT1"));
			sqlMap.put("SQL_PH_MED_ADMIN_FT_SELECT18",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT18"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT86",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT86"));	
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT1",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT1"));	
			sqlMap.put("SQL_PH_MED_ADMIN_FT_SELECT27",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT27"));	
			sqlMap.put("SQL_PH_MEDN_ADMIN_UPDATE2",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_UPDATE2"));	

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_MEDICATION_ADMINISTRATION_FT" ),MedicationAdministrationFTHome.class,getLocalEJB());
			Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] =new Object[2];
			argArray[0]= tabData;
			argArray[1]=sqlMap;

			Class  paramArray[] = new Class[2];
			paramArray[0]= tabData.getClass();
			paramArray[1] = sqlMap.getClass();
			HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put( "result", new Boolean( true ) ) ;	
		
				map.put( "message", getMessage(locale,(String) result.get( "msgid" ),"PH") ) ;
				map.put("flag","0");
			}
			else{	
				if(((String)result.get("msgid")).equals("ADMIN_BY_OTHERS")){
					map.put( "message", getMessage(locale,(String)result.get("msgid"),"PH" )) ;
				}
				else{
					map.put( "message", (String)result.get("msgid") ) ;
				}
				map.put("flag","0");
			}			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	public boolean insertPRNDetails(HashMap dtlMap) throws Exception{
		boolean updated=true;
		Connection connection				= null;
		PreparedStatement PreparedStmt		= null,ps=null; 
		ResultSet rs						= null;
		int count =0,k=0;
		//StringBuilder sb = new StringBuilder(PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_INSERT"));
		StringBuilder sb = new StringBuilder("INSERT INTO PH_MEDN_ADMIN (FACILITY_ID,ENCOUNTER_ID,SCH_DATE_TIME,ORD_DRUG_CODE,DOSAGE_SEQ_NO,ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PRACT_ID,SCH_DOSAGE_QTY,SCH_DOSAGE_UOM_CODE,SCH_STRENGTH,SCH_STRENGTH_UOM,SCH_ROUTE_CODE,VERIFY_REQD_YN,ADMINISTERED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) SELECT FACILITY_ID,ENCOUNTER_ID,  TO_DATE ( ? || ' '|| (decode(to_date(?,'dd/mm/yyyy'), trunc(SCH_DATE_TIME),TO_CHAR ( (sch_date_time + 1 / 1440), 'HH24:MI'), '00:01')), 'DD/MM/YYYY HH24:MI') SCH_DATE_TIME,ORD_DRUG_CODE, ");
		/*if(!((String)dtlMap.get("callFrom")).equals("Admin"))
			sb.append(" DOSAGE_SEQ_NO+1, ");
		else
			sb.append(" DOSAGE_SEQ_NO, ");*/
		try{ 
			connection	= getConnection();
			if(((String)dtlMap.get("callFrom")).equals("Admin")){
				ps		= connection.prepareStatement("SELECT COUNT(1) FROM PH_MEDN_ADMIN WHERE FACILITY_ID=? AND ENCOUNTER_ID=? AND ORD_DRUG_CODE=? AND trunc(SCH_DATE_TIME) = to_date(?,'dd/mm/yyyy') AND ORDER_ID=? AND ORDER_LINE_NUM=? AND ADMIN_DATE_TIME IS NOT NULL");
				ps.setString(++k,login_facility_id);
				ps.setString(++k,(String)dtlMap.get("encounter_id"));
				ps.setString(++k,(String)dtlMap.get("drug_code"));
				ps.setString(++k,(String)dtlMap.get("sch_date_current"));
				ps.setString(++k,(String)dtlMap.get("order_id"));
				ps.setString(++k,(String)dtlMap.get("order_line_no"));
				rs = ps.executeQuery();
				if(rs.next())
					count = Integer.parseInt(rs.getString(1));
				if(count > 0){
					sb.append(" DOSAGE_SEQ_NO+1,  ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PRACT_ID, (SELECT ROUND (  NVL (a.order_qty, 0)- (NVL (b.tot_administered_qty, 0) ),4) FROM or_order_line a, ph_patient_drug_profile b WHERE a.order_id = b.orig_order_id AND a.order_line_num = b.orig_order_line_no AND a.order_id = ? AND a.order_line_num = ?) SCH_DOSAGE_QTY, SCH_DOSAGE_UOM_CODE,SCH_STRENGTH,SCH_STRENGTH_UOM,SCH_ROUTE_CODE,VERIFY_REQD_YN,'N',?,SYSDATE,?,?,?,SYSDATE,?,? FROM PH_MEDN_ADMIN WHERE FACILITY_ID =? AND ENCOUNTER_ID  =? AND ORD_DRUG_CODE =? AND ORDER_ID=? AND ORDER_LINE_NUM=?");
					sb.append(" AND nvl(ADMIN_DATE_TIME, sysdate) = nvl((SELECT MAX(ADMIN_DATE_TIME) FROM PH_MEDN_ADMIN WHERE FACILITY_ID=? AND ENCOUNTER_ID=? AND ORD_DRUG_CODE=? AND  trunc(SCH_DATE_TIME) = to_date(?,'dd/mm/yyyy') AND ORDER_ID=? AND ORDER_LINE_NUM=? ), sysdate)");
				}
				else{
					sb.append(" DOSAGE_SEQ_NO,  ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PRACT_ID, (SELECT ROUND (  NVL (a.order_qty, 0)- (NVL (b.tot_administered_qty, 0) ),4) FROM or_order_line a, ph_patient_drug_profile b WHERE a.order_id = b.orig_order_id AND a.order_line_num = b.orig_order_line_no AND a.order_id = ? AND a.order_line_num = ?) SCH_DOSAGE_QTY, SCH_DOSAGE_UOM_CODE,SCH_STRENGTH,SCH_STRENGTH_UOM,SCH_ROUTE_CODE,VERIFY_REQD_YN,'N',?,SYSDATE,?,?,?,SYSDATE,?,? FROM PH_MEDN_ADMIN WHERE FACILITY_ID =? AND ENCOUNTER_ID  =? AND ORD_DRUG_CODE =? AND ORDER_ID=? AND ORDER_LINE_NUM=?");
					sb.append(" AND nvl(ADMIN_DATE_TIME, sysdate) = nvl((SELECT MAX(ADMIN_DATE_TIME) FROM PH_MEDN_ADMIN WHERE FACILITY_ID=? AND ENCOUNTER_ID=? AND ORD_DRUG_CODE=? AND DOSAGE_SEQ_NO =? AND ORDER_ID=? AND ORDER_LINE_NUM=? ), sysdate)");
				}
			}
			else{
				sb.append("DOSAGE_SEQ_NO+1,  ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PRACT_ID, (SELECT ROUND (  NVL (a.order_qty, 0)- (NVL (b.tot_administered_qty, 0) ),4) FROM or_order_line a, ph_patient_drug_profile b WHERE a.order_id = b.orig_order_id AND a.order_line_num = b.orig_order_line_no AND a.order_id = ? AND a.order_line_num = ?) SCH_DOSAGE_QTY, SCH_DOSAGE_UOM_CODE,SCH_STRENGTH,SCH_STRENGTH_UOM,SCH_ROUTE_CODE,VERIFY_REQD_YN,'N',?,SYSDATE,?,?,?,SYSDATE,?,? FROM PH_MEDN_ADMIN WHERE FACILITY_ID =? AND ENCOUNTER_ID  =? AND ORD_DRUG_CODE =? AND ORDER_ID=? AND ORDER_LINE_NUM=?");
				sb.append(" AND nvl(ADMIN_DATE_TIME, sysdate) = nvl((SELECT MAX(ADMIN_DATE_TIME) FROM PH_MEDN_ADMIN WHERE FACILITY_ID=? AND ENCOUNTER_ID=? AND ORD_DRUG_CODE=? AND  trunc(SCH_DATE_TIME) = to_date(?,'dd/mm/yyyy') AND ORDER_ID=? AND ORDER_LINE_NUM=? ), sysdate)");
			}
			k=0;
//System.err.println("===sb===>"+sb);
//System.err.println("===values===>"+dtlMap+" login_by_id="+login_by_id+"===login_at_ws_no=="+login_at_ws_no+" login_facility_id="+login_facility_id);
			PreparedStmt		= connection.prepareStatement(sb.toString());
			//PreparedStmt.setString(++k,(String)dtlMap.get("sch_date_current"));
			PreparedStmt.setString(++k,(String)dtlMap.get("sch_date_current"));
			PreparedStmt.setString(++k,(String)dtlMap.get("sch_date_current"));
			PreparedStmt.setString(++k,(String)dtlMap.get("order_id"));
			PreparedStmt.setString(++k,(String)dtlMap.get("order_line_no"));
			PreparedStmt.setString(++k,login_by_id);
			PreparedStmt.setString(++k,login_at_ws_no);
			PreparedStmt.setString(++k,login_facility_id);
			PreparedStmt.setString(++k,login_by_id);
			PreparedStmt.setString(++k,login_at_ws_no);
			PreparedStmt.setString(++k,login_facility_id);
			PreparedStmt.setString(++k,login_facility_id);
			PreparedStmt.setString(++k,(String)dtlMap.get("encounter_id"));
			PreparedStmt.setString(++k,(String)dtlMap.get("drug_code"));
			//PreparedStmt.setString(++k,(String)dtlMap.get("dosage_seq_no"));
			PreparedStmt.setString(++k,(String)dtlMap.get("order_id"));
			PreparedStmt.setString(++k,(String)dtlMap.get("order_line_no"));
			PreparedStmt.setString(++k,login_facility_id);
			PreparedStmt.setString(++k,(String)dtlMap.get("encounter_id"));
			PreparedStmt.setString(++k,(String)dtlMap.get("drug_code"));
			if(count >0 || ((String)dtlMap.get("callFrom")).equals("AddPRN")){
				PreparedStmt.setString(++k,(String)dtlMap.get("sch_date_current"));
			}
			else{
				PreparedStmt.setString(++k,(String)dtlMap.get("dosage_seq_no"));
			}
			PreparedStmt.setString(++k,(String)dtlMap.get("order_id"));
			PreparedStmt.setString(++k,(String)dtlMap.get("order_line_no"));
			int result = PreparedStmt.executeUpdate();
//System.err.println("===result===>"+result);
			if(result>0){
				updated=true;
				connection.commit();
			}
			else{
				updated=false;
				connection.rollback();
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
			updated=false;
		}
		finally{
			try{
				if(rs!=null)
					rs.close();
				closeStatement( ps ) ;
				closeStatement( PreparedStmt ) ;	
				closeConnection( connection ); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return updated;
	}
	public boolean IsValidBatch(String batch_id,String order_id,String order_line_no,boolean site_spec_yn,String item_code,String iv_prep_yn,String patient_id) throws Exception{   // Added for AAKH-CRF-0084 [IN060429] - Start
//boolean site_spec_yn,String item_code added for PMG2017-MMS-CRF-0002
//iv_prep_yn and patient id added for MMS-KH-CRF-0017
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		PreparedStatement pstmt1		= null;//MMS-KH-CRF-0017
        ResultSet resultSet1			= null;//MMS-KH-CRF-0017
		boolean batchAvailable	    = false;
		int count					= 0;
		String sql					= "";//PMG2017-MMS-CRF-0002
		try {
            connection	= getConnection() ;
			if(site_spec_yn ){ // if condition added for PMG2017-MMS-CRF-0002
				if(item_code!=null && !item_code.equals("") && (!iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") && !iv_prep_yn.equals("2") && !iv_prep_yn.equals("4")&& !iv_prep_yn.equals("6") ) ){//iv_prep_yn added for MMS-KH-CRF-0017 and modified for 17.1
					sql =" AND  a.ITEM_CODE = ? ";
				}
			}
			if(!iv_prep_yn.equals("2") && !iv_prep_yn.equals("4")&& !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8")){ //MMS-KH-CRF-0017 and modified for MMS-KH-CRF-17.1
            pstmt		= connection.prepareStatement("select c.patient_id FROM ph_disp_drug_batch a,ph_disp_dtl b,ph_disp_hdr c,am_trade_name_lang_vw d WHERE c.disp_no = b.disp_no AND a.facility_id = b.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND a.trade_id = d.trade_id(+) AND a.batch_id = ? AND b.order_id = ? AND b.order_line_no = ? AND c.order_id = b.order_id AND d.language_id(+) = ? "+sql+" AND a.disp_qty <> NVL (a.returned_qty, 0) AND ((b.disp_qty > b.returned_qty) OR (b.returned_qty IS NULL))") ;
			pstmt.setString(1,batch_id);
			pstmt.setString(2,order_id);
			pstmt.setString(3,order_line_no);
			pstmt.setString(4,locale);
			if(site_spec_yn){ //if condition added for PMG2017-MMS-CRF-0002
				if(item_code!=null && !item_code.equals("") && (!iv_prep_yn.equals("2") && !iv_prep_yn.equals("4") && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") )  ){ //and modified for MMS-KH-CRF17.1
					pstmt.setString(5,item_code);
				}
			}
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				count++;
			} //MMS-KH-CRF-0017 -start
			}else{
				if(iv_prep_yn.equals("8")){ //added for MMS-KH-CRF-0017.1
					pstmt1		= connection.prepareStatement("select b.patient_id FROM ph_tpn_worksheet_hdr a,or_order b WHERE a.order_id=b.order_id  and b.patient_id= ? AND a.order_id = ? AND a.batch_id = ?");
				
				}else{
					pstmt1		= connection.prepareStatement("select b.patient_id FROM ph_worksheet_hdr a,ph_disp_hdr b WHERE  a.facility_id = b.facility_id AND a.order_id=b.order_id AND b.patient_id=? AND b.order_id = ? AND a.batch_id = ?");
				}
			pstmt1.setString(1,patient_id);
			pstmt1.setString(2,order_id);
			pstmt1.setString(3,batch_id);

			
			resultSet1	= pstmt1.executeQuery() ;
			if (resultSet1!=null && resultSet1.next()){
				count++;
			} //MMS-KH-CRF-0017 - end

			}
			if(count>0) {
				batchAvailable	=	true;
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
		return batchAvailable;
	} // Added for AAKH-CRF-0084 [IN060429] - End


	//added for CRF-413.8
	public String getDrugCount(String order_id){

		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String drug_count			= "1";
		try{
			connection			= getConnection() ;
			
			
			pstmt				= connection.prepareStatement("select count(*)CUNT from or_order_line_ph where order_id=?") ;	
			pstmt.setString(1,order_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				drug_count= (String)resultSet.getString("CUNT");

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
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return drug_count;

	}
	//added for PMG2017-MMS-CRF-0002
	public boolean isSiteSpecific(String moduleId, String functionalityId){ 
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


//added for GHL-CRF-0458 - start
	 public String getAcknowlegeYN(String order_id,String order_line_no,String iv_prep_yn){ //iv_prep_yn added for MMS-KH-CRF-0039

		
		PreparedStatement pstmt=null;
		ResultSet  resultSet=null;
		Connection con	= null;
		String ward_ack_yn = "";
		try{
			con		= getConnection() ;
		//added for MMS-KH-CRF-0039 - start
			if(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4") || iv_prep_yn.equals("6")){
			  pstmt   = con.prepareStatement("SELECT distinct c.ward_acknowledge FROM ph_disp_hdr a, ph_disp_dtl b, ph_worksheet_hdr c WHERE a.facility_id = b.facility_id AND a.disp_no = b.disp_no AND a.facility_id = c.facility_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_id = ? ");
	  			pstmt.setString(1,order_id);

			}else{
		//added for MMS-KH-CRF-0039 - end			
				pstmt   = con.prepareStatement("SELECT a.WARD_ACKNOWLEDGE FROM ph_disp_hdr e,PH_DISP_DRUG_BATCH a, PH_DISP_DTL b WHERE e.disp_no=b.disp_no and e.DISP_TYPE!='M'  AND a.facility_id=b.facility_id AND a.disp_no=b.disp_no AND a.srl_no=b.srl_no AND b.ORDER_ID=? AND b.ORDER_LINE_NO=? AND e.order_id = b.order_id ");
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);			
			}


			resultSet=pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
			   ward_ack_yn =resultSet.getString("WARD_ACKNOWLEDGE");
			}
			
		}catch(Exception ex){
			System.err.println("Exception "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(resultSet !=null) resultSet.close();
				closeConnection(con);
			}
			catch(Exception fe){
			}
		}

		return ward_ack_yn;
	}

//added for GHL-CRF-0458

public String validateAckQty(String order_id,String order_line_no,String item_code,String batch_id,String expiry_date,String trade_id,String patient_id,String facility_id,String encounter_id){
//added encounter_id for GHL-CRF-0482
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1= null;
		ResultSet  resultSet=null;
		ResultSet resultSet1	= null;
		Connection con	= null;
		String allow_admin_yn = "";
		String ward_ack_yn	  = "";//GHL-CRF-0458.1
		String disp_req_yn	  = "N";//GHL-CRF-0458.1
		String patient_class  = ""; //GHL-CRF-0482
		String disp_qty_uom   = "";//GHL-CRF-0482
		float total_ack_qty  = 0.0f;
		float tot_admin_qty  = 0.0f; 
		float tot_returnable = 0.0f;
		float admin_qty		 = 0.0f; 
		int   cunt			 = 0;//GHL-CRF-0458.1

		try{
			con		= getConnection() ;
			//pstmt   = con.prepareStatement("SELECT a.disp_qty total_ack_qty,WARD_ACKNOWLEDGE,c.patient_class,DISP_QTY_UOM, a.disp_qty - (  NVL (a.returned_qty, 0) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no  AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch),0)  + NVL ((SELECT SUM (returned_qty)  FROM ph_ward_return_dtl WHERE disp_no = a.disp_no  AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch  AND store_acknowledge_status IS NULL),0 ) ) returnable From ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c WHERE a.facility_id = b.facility_id  AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no  AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no  AND c.patient_id =? AND a.facility_id =? AND c.order_id =? AND b.ORDER_LINE_NO=? AND b.order_id = c.order_id  and   a.item_code =? and a.BATCH_ID =? and a.EXPIRY_DATE=to_date(?,'dd/mm/yyyy')  and a.TRADE_ID =? /*and WARD_ACKNOWLEDGE='A' */");
			pstmt   = con.prepareStatement("SELECT a.disp_qty total_ack_qty,WARD_ACKNOWLEDGE,c.patient_class,DISP_QTY_UOM, a.disp_qty - (  NVL (a.returned_qty, 0) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no  AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch and order_id=c.ORDER_ID and facility_id=a.facility_id),0)  + NVL ((SELECT SUM (returned_qty)  FROM ph_ward_return_dtl WHERE disp_no = a.disp_no  AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch  and order_id=c.ORDER_ID and facility_id=a.facility_id AND store_acknowledge_status IS NULL),0 ) ) returnable From ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c WHERE a.facility_id = b.facility_id  AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no  AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no  AND c.patient_id =? AND a.facility_id =? AND c.order_id =? AND b.ORDER_LINE_NO=? AND b.order_id = c.order_id  and   a.item_code =? and a.BATCH_ID =? and a.EXPIRY_DATE=to_date(?,'dd/mm/yyyy')  and a.TRADE_ID =? /*and WARD_ACKNOWLEDGE='A' */");
			//GHL-SCF-1705 (tuned with and order_id=c.ORDER_ID and facility_id=a.facility_id  and additionally index(
		//c.patient_class,DISP_QTY_UOM, added for GHL-CRF-0482
			//String sql2="select  sum((CASE WHEN c.DOSAGE_TYPE ='S' THEN ceil((sum(b.ADMIN_DOSAGE_QTY)/d.STRENGTH_VALUE)/d.CONTENT_IN_PRES_BASE_UOM ) ELSE ceil(sum(b.ADMIN_DOSAGE_QTY)/d.CONTENT_IN_PRES_BASE_UOM) END )) tot_admin_qty from ph_medn_admin a ,ph_medn_admin_dtl b,or_order_line_ph c ,(SELECT drug_desc drug_desc, drug_code drug_code,NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom,strength_value  FROM ph_drug_lang_vw  WHERE language_id = ? and drug_code = ? UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code,   NVL (content_in_base_unit, 1) content_in_pres_base_uom,1 strength_value FROM ph_tpn_regimen_lang_vw WHERE standard_regimen_yn = 'Y' AND language_id = ? and TPN_REGIMEN_CODE =? ) d where   a.ENCOUNTER_ID=b.ENCOUNTER_ID  and a.ORD_DRUG_CODE=b.ORD_DRUG_CODE  and a.sch_date_time = b.sch_date_time and a.order_id=b.order_id  and a.DOSAGE_SEQ_NO =b.DOSAGE_SEQ_NO and a.order_id=? and a. ORDER_LINE_NUM =?   and a.order_id =c.order_id  and a.ORDER_LINE_NUM  =c.ORDER_LINE_NUM and a.ADMIN_RECORDED_YN ='Y' and b.item_code=? and BATCH_ID =? and EXPIRY_DATE=to_date(?,'dd/mm/yyyy')  and TRADE_ID =?  and b.ADMIN_DRUG_CODE =d.drug_code  group by BATCH_ID, EXPIRY_DATE, TRADE_ID ,b.ADMIN_DOSAGE_QTY ,c.DOSAGE_TYPE,d.STRENGTH_VALUE, d.CONTENT_IN_PRES_BASE_UOM ";

			//commented the above query and modified for GHL-CRF-0482
			String sql2			= "SELECT   SUM ((CASE WHEN (SELECT dosage_type FROM or_order_line_ph WHERE order_id = b.order_id AND ROWNUM <= 1) = 'S' THEN CEIL (  ((b.admin_dosage_qty) / d.strength_value) / d.content_in_pres_base_uom ) ELSE CEIL ((b.admin_dosage_qty) / d.content_in_pres_base_uom) END ) ) tot_admin_qty  FROM ph_medn_admin_dtl b,(SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom, strength_value FROM ph_drug_lang_vw WHERE language_id = ? AND drug_code = ?) d WHERE b.encounter_id = ? AND b.batch_order_id =? AND batch_id = ? AND expiry_date = TO_DATE (?, 'dd/mm/yyyy') AND b.item_code = ? AND b.admin_drug_code = d.drug_code GROUP BY batch_id, expiry_date, trade_id, b.admin_dosage_qty, d.strength_value, d.content_in_pres_base_uom" ;	

			
			pstmt.setString(1,patient_id);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,order_id);
			pstmt.setString(4,order_line_no);
			pstmt.setString(5,item_code);
			pstmt.setString(6,batch_id);
			pstmt.setString(7,expiry_date);
			pstmt.setString(8,trade_id);

			resultSet=pstmt.executeQuery();

			while(resultSet!=null && resultSet.next()){
			   ward_ack_yn = resultSet.getString("WARD_ACKNOWLEDGE")==null?"":resultSet.getString("WARD_ACKNOWLEDGE");//added for GHL-CRF-0458.1
			   patient_class = resultSet.getString("patient_class"); //GHL-CRF-0482
			   disp_qty_uom  = resultSet.getString("DISP_QTY_UOM");//GHL-CRF-0482
				if(ward_ack_yn.equals("A") || patient_class.equals("OP")){//added for GHL-CRF-0458.1 and patient_class OP added for GHL-CRF-0482
				   total_ack_qty =total_ack_qty+resultSet.getFloat("total_ack_qty");
				   tot_returnable = tot_returnable+resultSet.getFloat("returnable");
				}else{
					cunt++;
				}
			}
//System.err.println("MedicationAdministrationFTBean.java====9729==total_ack_qty===>"+total_ack_qty+"==tot_returnable==>"+tot_returnable);
			closeResultSet( resultSet ) ;

			pstmt1= con.prepareStatement( sql2) ;
			pstmt1.setString(1,getLanguageId());
			pstmt1.setString(2,item_code);
			pstmt1.setString(3,encounter_id);
//			pstmt1.setString(4,item_code);
			pstmt1.setString(4,order_id);
			//pstmt1.setString(5,order_line_no);
			//pstmt1.setString(6,item_code);
			pstmt1.setString(5,batch_id);
			pstmt1.setString(6,expiry_date);
			pstmt1.setString(7,item_code);
//			pstmt1.setString(10,trade_id);
			
			resultSet1 = pstmt1.executeQuery() ;
			while( resultSet1!=null && resultSet1.next() ) {       //changed if loop to while for GHL-CRF-0482          
				admin_qty =resultSet1.getFloat("tot_admin_qty");
				
				tot_admin_qty = tot_admin_qty + admin_qty; //added for GHL-CRF-0482
			}
//System.err.println("MedicationAdministrationFTBean.java====9747==tot_admin_qty===>"+tot_admin_qty);
			closeResultSet( resultSet1 ) ;

			if(tot_returnable>0){
				tot_returnable = tot_returnable-tot_admin_qty;
				if(tot_returnable>0)
					allow_admin_yn = "Y";
				else
					allow_admin_yn = "N";
			}else{
				allow_admin_yn = "N";
			}

			if(allow_admin_yn.equals("N")){//added for GHL-CRF-0458.1 -start
				if(cunt>0)		
				 disp_req_yn = "N";
				else
				 disp_req_yn = "Y";
			}else
				disp_req_yn = "N";
			//added for GHL-CRF-0458.1 - end
//System.err.println("MedicationAdministrationFTBean.java====9717==total_ack_qty====>"+total_ack_qty);
			
		}catch(Exception ex){
			System.err.println("Exception "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{

				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt1 ) ;
				closeResultSet( resultSet1 ) ;
				closeConnection(con);
			}
			catch(Exception fe){
			}
		}
	//	System.err.println("MedicationAdministrationFTBean.java====9723=============>"+allow_admin_yn);
		return allow_admin_yn+"~"+disp_req_yn+"~"+String.valueOf(tot_returnable)+"~"+disp_qty_uom;//tot_returnable added for GHL-CRF-0458.1 disp_qty_uom added for GHL-CRF-0482
} //added for GHL-CRF-0458 - end
//added for MMS-DM-SCF-0513 - start
public ArrayList getDB_MultiDrugDetail(String order_id,String order_line_no) throws Exception {
	
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String disp_drug_code		=	"";
		String drug_desc			=	"";
		String form_code			=	"";
		String strength_value		=	"";
		String strength_uom			=	"";
		ArrayList multi_drug_detail	=	new ArrayList();
		try {
            connection	= getConnection() ;
			
				pstmt		= connection.prepareStatement("SELECT A.DISP_QTY,A.DISP_DRUG_CODE,A.PRES_DRUG_CODE,B.DRUG_DESC,A.DISP_UOM_CODE FORM_CODE,B.STRENGTH_VALUE,B.STRENGTH_UOM ,a.DISP_UOM_CODE FROM PH_DISP_DTL A,PH_DRUG_LANG_VW B WHERE A.PRES_DRUG_CODE<>A.DISP_DRUG_CODE AND A.ORDER_ID=? AND A.ORDER_LINE_NO=? AND A.DISP_DRUG_CODE=B.DRUG_CODE AND B.LANGUAGE_ID = ?") ;
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_no);
				pstmt.setString(3,getLanguageId());
				resultSet	= pstmt.executeQuery() ;
				while(resultSet!=null && resultSet.next()){
						
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
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}

		return multi_drug_detail;
	}

//added for MMS-DM-SCF-0513 - end

//added for BRU-CRF-399.1
public String getAltDosageDetails(String pres_drug_code,String alt_drug_code,String order_id,String order_line_no) throws Exception{
		Connection connection = null;
		PreparedStatement pstmt	= null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet resultSet		= null;
		ResultSet resultSet1	= null;
		ResultSet resultSet2	= null;
		String dosage_dtl	    = "";
		String dosage			= "";
		String pres_base_uom	= "";
		String strength_per_value_pres_uom = "";
		String drug_desc		= "";
		try {

			connection	= getConnection() ;
			

			pstmt		= connection.prepareStatement( "select ph_alt_drug_dosage_details(?,?,?,?,?,?) dosage_dtl from dual") ;//changed ph_dosage_details to ph_alt_dosage_details  for CRF-0399.1 and changed ph_alt_dosage_details to ph_alt_drug_dosage_details for regression issue.ph_alt_dosage_details is site specific function so that new function created and used
			
			pstmt.setString(1,login_facility_id);  
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,pres_drug_code);  
			pstmt.setString(4,alt_drug_code);
			pstmt.setString(5,order_id);
			pstmt.setString(6,order_line_no);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){
			  dosage_dtl= checkForNull(resultSet.getString("DOSAGE_DTL"));
				dosage = (String)dosage_dtl.split(" ")[0];
				if(dosage==null|| dosage.equals(""))
					dosage = "0";

			} 
			pstmt1		= connection.prepareStatement( "select PRES_BASE_UOM,STRENGTH_PER_VALUE_PRES_UOM,DRUG_DESC from ph_drug where drug_code=?") ; 
			pstmt1.setString(1,alt_drug_code);  
			resultSet1	= pstmt1.executeQuery() ;
			if(resultSet1!=null && resultSet1.next()){
				pres_base_uom = checkForNull(resultSet1.getString("PRES_BASE_UOM"));
				strength_per_value_pres_uom = checkForNull(resultSet1.getString("STRENGTH_PER_VALUE_PRES_UOM"));
				drug_desc					= resultSet1.getString("DRUG_DESC");
			}
			
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeResultSet( resultSet1 ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt1 ) ;
			closeResultSet( resultSet2 ) ;
			closeStatement( pstmt2 ) ;
			closeConnection( connection );
		}
		return dosage+"~"+pres_base_uom+"~"+getUomDisplay(login_facility_id,checkForNull(pres_base_uom))+"~"+strength_per_value_pres_uom+"~"+drug_desc;
	}
//added for ghl-crf-0509 start
public String locationSetUpVelibleYN(String location_code) throws Exception{
	Connection connection		= null;
    PreparedStatement pstmt		= null;
    ResultSet resultSet			= null;
	String disp_locn_ward_yn			= "";
	String sql= "";
	String location_type	="N";
	String count="";
	
	try {
        connection	= getConnection() ;
        if(getPatientClass().equals("I")|| getPatientClass().equals("D") )
        	location_type="N";
		else
			location_type="C";
        if(location_type.equals("N")){
			sql="SELECT count (*) COUNT FROM PH_LOCN_FOR_STORE X, MM_STORE_LANG_VW A, PH_DISP_LOCN_LANG_VW B, IP_NURSING_UNIT_LANG_VW C WHERE X.STORE_CODE = B.STORE_CODE AND X.FACILITY_ID = B.FACILITY_ID AND A.STORE_CODE = B.STORE_CODE AND C.FACILITY_ID = B.FACILITY_ID AND C.NURSING_UNIT_CODE = X.LOCN_CODE  AND UPPER(X.LOCN_CODE) LIKE UPPER(?) AND B.FACILITY_ID = ? AND  X.LOCN_TYPE = ? AND  B.LANGUAGE_ID = ?   AND A.LANGUAGE_ID = ? AND C.LANGUAGE_ID =? ";
			}else{
		sql="SELECT count (*) COUNT FROM PH_LOCN_FOR_STORE X, MM_STORE_LANG_VW A, PH_DISP_LOCN_LANG_VW B, OP_CLINIC_LANG_VW C WHERE   X.STORE_CODE = B.STORE_CODE AND X.FACILITY_ID = B.FACILITY_ID AND  A.STORE_CODE = B.STORE_CODE  AND C.FACILITY_ID = B.FACILITY_ID  AND C.CLINIC_CODE = X.LOCN_CODE  AND UPPER(X.LOCN_CODE) LIKE UPPER(?)  AND B.FACILITY_ID = ? AND X.LOCN_TYPE = ? AND B.LANGUAGE_ID = ? AND A.LANGUAGE_ID = ? AND C.LANGUAGE_ID = ?";
		
			}
        pstmt		= connection.prepareStatement( sql) ;
		pstmt.setString(1,location_code);
        pstmt.setString(2,login_facility_id);
        pstmt.setString(3,location_type);
        pstmt.setString(4,getLanguageId());
        pstmt.setString(5,getLanguageId());
        pstmt.setString(6,getLanguageId());
       
        resultSet	= pstmt.executeQuery() ;
		if (resultSet!=null && resultSet.next()){
			count	=	checkForNull(resultSet.getString("COUNT"));
			if(Integer.parseInt(count)>0){
				disp_locn_ward_yn="N";
			}
			else
			{
				disp_locn_ward_yn="Y";
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
	return disp_locn_ward_yn;
}


 public String checkBarcodeValid(String order_id,String order_line_no,String store_code,String item_code,String barcode_id){//GHL-CRF-509 - start
		
		PreparedStatement pstmt=null;
		ResultSet  resultSet=null;
		Connection con	= null;
		String barcode_avail_yn = "N";
//		int cunt = 0;
		String batch_id="";
		String expiry_date="";
		String bin_locn = "";
		String trade_id = "";
		try{
			con		= getConnection() ;
			pstmt   = con.prepareStatement("select batch_id,TO_CHAR (expiry_date_or_receipt_date, 'DD/MM/YYYY') expiry_date,BIN_LOCATION_CODE,TRADE_ID from st_item_batch where   item_code=? and store_code =? and  barcode_id=? AND (QTY_ON_HAND-COMMITTED_QTY)>0 AND rownum=1");
			pstmt.setString(1,item_code);
			pstmt.setString(2,store_code);
			pstmt.setString(3,barcode_id);

			resultSet=pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				batch_id = resultSet.getString("batch_id");
				expiry_date = resultSet.getString("expiry_date");
				trade_id    = resultSet.getString("TRADE_ID");
				bin_locn    = resultSet.getString("BIN_LOCATION_CODE");
			}
			if(batch_id==null)
				batch_id="";
			if(expiry_date==null)
				expiry_date= "";
System.err.println("batch_id===>"+batch_id+"===expiry_date==>"+expiry_date+"==barcodeMap===>"+barcodeMap);
			if(!batch_id.equals("") && !expiry_date.equals("")) {
				this.barcodeMap.put(order_id+order_line_no,batch_id+"~"+expiry_date+"~"+bin_locn+"~"+trade_id);
				this.barcodeAvailableForItem.put(order_id+order_line_no,"Y");
				barcode_avail_yn = "Y";
			}else{
				this.barcodeMap.put(order_id+order_line_no,"");
				this.barcodeAvailableForItem.put(order_id+order_line_no,"N");
				barcode_avail_yn="N";
			}
			
		}catch(Exception ex){
			System.err.println("Exception "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(resultSet !=null) resultSet.close();
				closeConnection(con);
			}
			catch(Exception fe){
			}
		}

		return barcode_avail_yn;
	}
	public void clearBarcodeMap(){
		barcodeMap		   = new HashMap();
		barcodeAvailableForItem = new HashMap();
	}
//added for ghl-crf-0509  - end
//GHL-CRF-0482 - start
public ArrayList getAllBatchIDSForItem(ArrayList orderList,String administred_yn)throws Exception{

		ArrayList result = new ArrayList();
		Connection connection = null ;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		PreparedStatement pstmt1 = null;
        ResultSet resultSet1 = null;
		locale = getLanguageId()==null?"en":getLanguageId();
		String str_date ="";
		String trade_id ="";
		String trade_name="";
		String barcode_id = "";
		String disp_drug_code = "";
		String order_id = "";
		String order_line_no = "";

		String mm_deflt_trade_id ="";
		String ward_ack_yn		 = "";
		String batch_id			 = "";
		String batch_id_details_value  = "";
		String batch_detail				="";
		HashMap batchDetailMap = new HashMap();
		if(order_id==null)order_id="";
		if(order_line_no==null)order_line_no="";
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( "SELECT DISTINCT a.BATCH_ID, to_char(a.EXPIRY_DATE,'dd/mm/yyyy') EXPIRY_DATE,d.trade_id,d.short_name trade_name,(SELECT barcode_id FROM st_sal_dtl_exp EXP WHERE EXP.doc_no = e.doc_no AND EXP.doc_srl_no = b.doc_srl_no AND EXP.item_code = a.item_code AND EXP.batch_id = a.batch_id AND EXP.expiry_date_or_receipt_date = a.expiry_date AND EXP.store_code = a.store_code AND EXP.bin_location_code = a.bin_location_code) barcode_id,B.DISP_DRUG_CODE disp_drug_code,a.WARD_ACKNOWLEDGE FROM ph_disp_hdr e,PH_DISP_DRUG_BATCH a, PH_DISP_DTL b,am_trade_name_lang_vw d,ph_patient_drug_profile f  WHERE e.disp_no=b.disp_no and e.DISP_TYPE!='M'  AND a.facility_id=b.facility_id AND a.disp_no=b.disp_no AND a.srl_no=b.srl_no AND a.trade_id=d.trade_id(+) AND e.patient_id=f.patient_id and e.order_id=f.orig_order_id and b.order_id=f.orig_order_id and b.ORDER_LINE_NO = f.ORIG_ORDER_LINE_NO AND b.ORDER_ID=? AND b.ORDER_LINE_NO=? AND e.order_id = b.order_id  and d.language_id(+) =? and a.disp_qty<>NVL (a.returned_qty, 0)"+"and ((b.DISP_QTY>b.RETURNED_QTY) OR (B.RETURNED_QTY IS NULL))"); 

            pstmt1 = connection.prepareStatement("select DFLT_TRADE_ID from mm_parameter") ;
			resultSet1 = pstmt1.executeQuery();

			if ( resultSet1 != null && resultSet1.next() ) {
				mm_deflt_trade_id =resultSet1.getString("DFLT_TRADE_ID");
			}
			closeStatement( pstmt1 ) ;
			closeResultSet( resultSet1 ) ;

            if(orderList!=null && orderList.size()>0){
			for(int i=0;i<orderList.size();i=i+2){
				order_id = (String)orderList.get(i);
				order_line_no = (String)orderList.get(i+1);
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no.trim());
			pstmt.setString(3,locale);
			resultSet = pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {

				batch_id_details_value = "";
				batch_detail		   = "";
				str_date = resultSet.getString("EXPIRY_DATE");
				disp_drug_code = resultSet.getString("disp_drug_code");
				batch_id = resultSet.getString("BATCH_ID")==null?"":resultSet.getString("BATCH_ID");
				if(!locale.equals("en"))
					str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
				batch_id_details_value = disp_drug_code+batch_id+str_date;
				if(!batchDetailMap.containsKey(disp_drug_code)){
						batch_detail = (String)batchDetailMap.get(disp_drug_code);
						if(batch_detail==null){
							batch_detail = "";
						}
				}

				if(batchDetailMap.size()==0 || (!batch_id_details_value.equals(batch_detail))){
				 result.add(resultSet.getString("BATCH_ID"));
				 result.add(str_date);
				 trade_id  = resultSet.getString("TRADE_ID");  
                 trade_name= resultSet.getString("TRADE_NAME"); 
				 barcode_id     = resultSet.getString("barcode_id"); 
				 ward_ack_yn	= resultSet.getString("WARD_ACKNOWLEDGE")==null?"N":resultSet.getString("WARD_ACKNOWLEDGE"); 
				 if(trade_id==null||trade_id.equals("")){				

						trade_id  = mm_deflt_trade_id;
						trade_name=mm_deflt_trade_id;
				 }
				result.add(trade_id);
				result.add(trade_name);
				result.add(disp_drug_code);
				result.add(barcode_id);
				result.add(ward_ack_yn);
				result.add(order_id);
				result.add(order_line_no.trim());
				String details = str_date+"$"+trade_id+"$"+trade_name;
				batch_id_details.put(resultSet.getString("BATCH_ID"),details);
				batchDetailMap.put(disp_drug_code,batch_id_details_value);
				}
				}
				closeResultSet(resultSet);
				this.batchIdforOrders.put(disp_drug_code,result);
			  }
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
//System.err.println("MedicationAdministrationFTBean.java===result===========10175==>"+result);
		return result;
	}

	public ArrayList getAllBatchIDSForPatientStock(String patient_id,String facility_id,String encounter_id,String drug_code){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		PreparedStatement pstmt1    = null ;
		//PreparedStatement pstmt2    = null ;
		PreparedStatement pstmt3    = null ;
		PreparedStatement pstmt4	= null ;
		ResultSet resultSet         = null ;
		ResultSet resultSet1        = null ;
		//ResultSet resultSet2        = null ;
		ResultSet resultSet3		= null ;
		ResultSet resultSet4		= null ;
		locale = getLanguageId()==null?"en":getLanguageId();
		String batch_id				= "";
		String expiry_date			= "";
		String trade_id				= "";
		String trade_name			= "";
		String order_id				= "";
		//String patient_stock_yn		= "N";
		//boolean disp_alert_flag		= false;
		//boolean entry_flag			= false;
		String disp_qty             = "";
		String tot_admin_qty		= "0";
		//String sql					= "";
		//String tot_admin_qty_for_pat_stock="0";
		//String admin_qty			= "";
		String barcode_id			= "";
		String str_date				= "";
		String mm_deflt_trade_id	= "";
		String order_line_no		= "";
		String admin_qty			= "0";
		String batch_id_details_value  = "";
		String batch_detail				="";
		HashMap batchDetailMap = new HashMap();
		ArrayList result = new ArrayList();

		try{
			connection		= getConnection() ;
			pstmt			= connection.prepareStatement("SELECT   c.order_id, batch_id, TO_CHAR (expiry_date,'DD/MM/YYYY') expiry_date,a.trade_id,d.short_name trade_name, SUM (a.disp_qty) disp_qty,ORIG_ORDER_LINE_NO  FROM ph_disp_drug_batch a,ph_disp_dtl b, ph_disp_hdr c, am_trade_name_lang_vw d,ph_patient_drug_profile f WHERE a.facility_id = b.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND b.facility_id = c.facility_id AND b.disp_no = c.disp_no AND a.trade_id = d.trade_id(+) AND c.patient_id=f.patient_id and c.order_id=f.orig_order_id and b.order_id=f.orig_order_id and b.ORDER_LINE_NO = f.ORIG_ORDER_LINE_NO AND d.language_id(+) = ? AND c.patient_id = ?  AND c.facility_id = ? AND c.encounter_id = ? AND a.drug_code = ? AND ((c.PATIENT_CLASS = 'IP' AND WARD_ACKNOWLEDGE = 'A') OR c.PATIENT_CLASS = 'OP' )  GROUP BY c.order_id, batch_id, expiry_date,a.trade_id, d.short_name, orig_order_line_no ") ;



			pstmt4 = connection.prepareStatement(" SELECT barcode_id FROM st_item_batch WHERE item_code = ? AND batch_id = ? AND expiry_date_or_receipt_date = TO_DATE (?, 'dd/mm/yyyy') and barcode_id is not null AND ROWNUM = 1" );
			
			pstmt3 = connection.prepareStatement("select DFLT_TRADE_ID from mm_parameter");
			resultSet3 = pstmt3.executeQuery();
			while(resultSet3 != null && resultSet3.next()) {
				mm_deflt_trade_id =resultSet3.getString("DFLT_TRADE_ID");
			}
			closeStatement(pstmt3) ;
			closeResultSet(resultSet3) ;

//System.err.println("PrescriptionBean_1.java====drug_code=====10396===>"+drug_code);			
			String drug_code_val = "";
			if(drug_code.indexOf("|")!=-1){
				StringTokenizer strToken = new StringTokenizer(drug_code,"|");
				int cunt_token=strToken.countTokens();
				System.err.println("StringTokenSample===10===cunt_token===>"+cunt_token);
				//String drg_code[]=new String[cunt_token];
				int cunt=0;

				while (strToken.hasMoreTokens())
				{
				if(cunt_token==cunt)
					drug_code_val = drug_code_val+"'"+strToken.nextToken()+"'";
				else
					drug_code_val = drug_code_val+",'"+strToken.nextToken()+"'";
				cunt++;
				}
			}else{
				drug_code_val = drug_code;
			}

//System.err.println("PrescriptionBean_1.java===10417======>"+drug_code+"==patient_id==>"+patient_id+"==facility_id===>"+facility_id+"==encounter_id===>"+encounter_id+"==drug_code_val===>"+drug_code_val);			
			
			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,encounter_id);
			pstmt.setString(5,drug_code_val);

			resultSet		= pstmt.executeQuery();
			while(resultSet != null && resultSet.next()) {
				order_id	= resultSet.getString("order_id");
				order_line_no = resultSet.getString("ORIG_ORDER_LINE_NO");
				batch_id	= resultSet.getString("batch_id");
				expiry_date = resultSet.getString("expiry_date");
				trade_id    = resultSet.getString("trade_id");
				disp_qty    = resultSet.getString("disp_qty")==null?"0":resultSet.getString("disp_qty");
				trade_name  = resultSet.getString("trade_name");
//System.err.println("PrescriptionBean_1.java===disp_qty=====10430===>"+disp_qty+"==order_id==>"+order_id+"==batch_id==>"+batch_id+"==expiry_date===>"+expiry_date+"==trade_id==>"+trade_id+"==trade_name===>"+trade_name);
				
				if(Float.parseFloat(disp_qty)>0){
				//pstmt1			= connection.prepareStatement("SELECT   sum((CASE WHEN c.dosage_type = 'S' THEN CEIL (  ( (b.admin_dosage_qty) / d.strength_value )/ d.content_in_pres_base_uom ) ELSE CEIL (  (b.admin_dosage_qty) / d.content_in_pres_base_uom ) END ) ) tot_admin_qty FROM ph_medn_admin a, ph_medn_admin_dtl b, or_order_line_ph c, (SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom, strength_value FROM ph_drug_lang_vw WHERE language_id = ? AND drug_code = ?) d   WHERE a.encounter_id = b.encounter_id AND a.ord_drug_code = b.ord_drug_code AND a.sch_date_time = b.sch_date_time AND a.order_id = b.order_id AND a.order_id = c.order_id AND a.dosage_seq_no = b.dosage_seq_no AND a.patient_id = ? and a.encounter_id = ? AND a.order_id = ? AND a.order_line_num = c.order_line_num AND a.admin_recorded_yn = 'Y' and batch_id = ? and expiry_date=to_date(?,'dd/mm/yyyy') AND b.item_code = ?  AND b.admin_drug_code = d.drug_code  GROUP BY batch_id, expiry_date, trade_id, b.admin_dosage_qty, c.dosage_type, d.strength_value, d.content_in_pres_base_uom") ;
				
				  pstmt1			= connection.prepareStatement("SELECT   SUM ((CASE WHEN (SELECT dosage_type FROM or_order_line_ph WHERE order_id = b.order_id AND ROWNUM <= 1) = 'S' THEN CEIL (  ((b.admin_dosage_qty) / d.strength_value) / d.content_in_pres_base_uom ) ELSE CEIL ((b.admin_dosage_qty) / d.content_in_pres_base_uom) END ) ) tot_admin_qty  FROM ph_medn_admin_dtl b,(SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom, strength_value FROM ph_drug_lang_vw WHERE language_id = ? AND drug_code = ?) d WHERE b.encounter_id = ? AND b.batch_order_id =? AND batch_id = ? AND expiry_date = TO_DATE (?, 'dd/mm/yyyy') AND b.item_code = ? AND b.admin_drug_code = d.drug_code GROUP BY batch_id, expiry_date, trade_id, b.admin_dosage_qty, d.strength_value, d.content_in_pres_base_uom");

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
//System.err.println("PrescriptionBean_1.java===tot_admin_qty=====10444===>"+tot_admin_qty);					
				if(Float.parseFloat(disp_qty)>Float.parseFloat(tot_admin_qty)){
	
				barcode_id = "";
				pstmt4.setString(1,drug_code);
				pstmt4.setString(2,batch_id);
				pstmt4.setString(3,expiry_date);
				resultSet4	= pstmt4.executeQuery();
				if(resultSet4!=null && resultSet4.next()){
					barcode_id = resultSet4.getString("barcode_id");
//System.err.println("PrescriptionBean_1.java===barcode_id=====10430======>"+barcode_id);
				}
				closeResultSet( resultSet4 ) ;
				}

				batch_id_details_value = "";
				batch_detail		   = "";
				str_date = resultSet.getString("EXPIRY_DATE");	// expiry_date
				batch_id = resultSet.getString("BATCH_ID")==null?"":resultSet.getString("BATCH_ID");
				if(!locale.equals("en"))
					str_date = com.ehis.util.DateUtils.convertDate(str_date, "DMY","en",locale);
				batch_id_details_value = drug_code+batch_id+str_date;

				if(batchDetailMap.containsKey(drug_code)){
						batch_detail = (String)batchDetailMap.get(drug_code);
						if(batch_detail==null){
							batch_detail = "";
						}
				}
				if(trade_id==null||trade_id.equals("")){				
					trade_id  = mm_deflt_trade_id;
					trade_name=mm_deflt_trade_id;
				}
				if(batchDetailMap.size()==0 || (!batch_id_details_value.equals(batch_detail))){
				result.add(resultSet.getString("BATCH_ID"));
				result.add(str_date);
				result.add(trade_id);
				result.add(trade_name);
				result.add(drug_code);
				result.add(barcode_id);
				result.add("A");
				result.add(order_id);
				result.add(order_line_no);
 
	 
				String details = str_date+"$"+trade_id+"$"+trade_name;
				batch_id_details.put(resultSet.getString("BATCH_ID"),details);
				batchDetailMap.put(drug_code,batch_id_details_value);
				}
				//}
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				}
				this.batchIdforOrders.put(drug_code,result);
			}
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
		//System.err.println("MedicationAdministrationFTBean.java===10346==result=====>"+result);
		return result;
	}
public int getDispDetailCount(String order_id,String order_line_no){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		int count					= 0;
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement("select count(*) rec_count from ph_disp_dtl WHERE ORDER_ID=? AND ORDER_LINE_NO=?") ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				count = resultSet.getInt("rec_count");			
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

//GHL-CRF-0482 - end
public boolean getDischargedStatus(String encounter_id){ // Added for KH-SCF-0010 - Start

	Connection connection       = null ;
    PreparedStatement pstmt     = null ;
    ResultSet resultSet         = null ;
	boolean discharged			= false;
	int count					= 0;
	try{
		connection				= getConnection();
		pstmt					= connection.prepareStatement("select count(*) count from pr_encounter where encounter_id = ? and FACILITY_ID= ? and ADT_STATUS = '08' and DISCHARGE_DATE_TIME IS NOT NULL") ;
		pstmt.setString(1,encounter_id);
		pstmt.setString(2,login_facility_id);
		resultSet				= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next()){
			count = resultSet.getInt("count");
		 if(count > 0){
			discharged = true;
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
	return discharged;

} // Added for KH-SCF-0010 - End
public String getMedicationAdminstrationRights(String user_id){ // Added for JD-CRF-0200 START

	Connection connection       = null ;
    PreparedStatement pstmt     = null ;
    ResultSet resultSet         = null ;
	String cancelRightsYn			= "N";
	
	try{
		connection				= getConnection();
		pstmt					= connection.prepareStatement("SELECT cancel_admin_yn FROM  MEDICATION_ADMIN_RIGHTS WHERE  user_id = ? and facility_id =?") ;
		pstmt.setString(1,user_id);
		pstmt.setString(2,login_facility_id);
		resultSet				= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next()){
			cancelRightsYn = resultSet.getString("cancel_admin_yn")==null?"N":resultSet.getString("cancel_admin_yn");
		 
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
	return cancelRightsYn;

}// Added for JD-CRF-0200 END

public ArrayList cancelAdminReasonCodeValues(){
	ArrayList	reasonCodeValues  = new ArrayList();
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet		= null ;
	locale= getLanguageId()==null?"en":getLanguageId();
	try{
		connection	= getConnection() ;
		//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT12A") ) ;
		pstmt		= connection.prepareStatement("SELECT REASON_CODE, REASON_DESC FROM PH_MEDN_TRN_REASON_LANG_VW PH_MEDN_TRN_REASON WHERE APPL_TRN_TYPE='CM'  AND EFF_STATUS ='E' AND LANGUAGE_ID = ?" ) ;
		pstmt.setString(1,locale);
	
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			reasonCodeValues.add(resultSet.getString("REASON_CODE"));
			reasonCodeValues.add(resultSet.getString("REASON_DESC"));
			
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
	return reasonCodeValues;
}
public String getUsername(String userId){
	String username="";
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet		= null ;
	locale= getLanguageId()==null?"en":getLanguageId();
	try{
		connection	= getConnection() ;
		//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT12A") ) ;
		String sqlQuery="select appl_user_name from sm_appl_user_lang_vw where APPL_USER_ID=? AND language_id = ?";
		pstmt		= connection.prepareStatement(sqlQuery) ;
		pstmt.setString(1,userId);
		pstmt.setString(2,locale);
	
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			username=checkForNull(resultSet.getString("appl_user_name"));
			
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
	return username;
}

public HashMap cancelAdmisteredDetails(String drug_code,String order_id,String order_line_num,String iv_prep_yn,String sch_date_time,String dosage_seq,String administered_qty,String patient_id,String encounter_id,String admin_date_time,String admin_by_name,String reasonCode,String strength_per_value_pres_uom){//added for jd-crf-0200 start
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "in insert.." ) ;
	map.put( "flag", "0" ) ;
	locale = getLanguageId()==null?"en":getLanguageId();
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ;
	PreparedStatement pstmt2 = null ;
	PreparedStatement pstmt3 = null ;
	PreparedStatement pstmt4 = null ;
	PreparedStatement pstmt5 = null ;
	PreparedStatement pstmt_select= null;
	PreparedStatement pstmt_select_cancel_yn_update = null;
	ArrayList result = new ArrayList();
	ResultSet resultSet4		= null ;
	ResultSet resultSet5		= null ;
	ResultSet resultSet6		= null ;
	boolean successFlag = false;
	boolean successFlag1 = false;
	boolean successFlag2 = false;
	boolean successFlag3 = false;
	//boolean successFlag4 = false; //commented for common-icn-0048
	String dosage_type="",strength_value="",freq_nature="";
	float div_value,adm_qty,diff_qty_1 = 0;
	
	String cancelUpdate="UPDATE ph_medn_admin SET  admn_dose_chng_remarks='',cancel_recorded_yn = ?,cancel_date_time = sysdate,administered_yn = 'N',ADMIN_RECORDED_YN='N', modified_facility_id = ?,modified_date = SYSDATE,modified_by_id = ?,modified_at_ws_no = ? WHERE facility_id = ?  AND sch_date_time = TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND ord_drug_code = ? AND dosage_seq_no = ? AND order_id = ? and ORDER_LINE_NUM=?  AND ENCOUNTER_ID=? AND PATIENT_ID=?";

    String cancelDelete="DELETE FROM PH_MEDN_ADMIN_DTL  WHERE facility_id = ?  AND sch_date_time = TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND ord_drug_code = ? AND dosage_seq_no = ? AND order_id = ?  AND ENCOUNTER_ID=? ";

    String cancelUpdate1="UPDATE PH_PATIENT_DRUG_PROFILE SET TOT_CANCLED_QTY=(NVL(TOT_CANCLED_QTY,0)+?),TOT_ADMINISTERED_QTY=(NVL(TOT_ADMINISTERED_QTY,0)-?),MODIFIED_DATE=SYSDATE,MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE  ORIG_ORDER_ID=? AND ORIG_ORDER_LINE_NO=? AND FACILITY_ID=? AND ENCOUNTER_ID=? AND PATIENT_ID=?";
    
    String cancelinsert="INSERT INTO PH_MEDN_CANCEL_DETAILS  (PATIENT_ID,ENCOUNTER_ID,FACILITY_ID,dosage_seq_no,order_id,ORDER_LINE_NUM,ADMIN_BY_ID,ADMIN_DATE_TIME,SCH_DATE_TIME,CANCLED_BY_ID,CANCLED_DATE_TIME,CANCLED_REASON,ADMIN_DRUG_CODE,ADMIN_DOSAGE_QTY,ADMIN_DOSAGE_UOM_CODE,ADMIN_STRENGTH,ADMIN_STRENGTH_UNIT,ORD_DRUG_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES(?,?,?,?,?,?,?,TO_DATE (?, 'DD/MM/YYYY HH24:MI'),TO_DATE (?, 'DD/MM/YYYY HH24:MI'),?,SYSDATE,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
    
    String admin_detail="select ADMIN_DRUG_CODE,ADMIN_DOSAGE_QTY,ADMIN_DOSAGE_UOM_CODE,ADMIN_STRENGTH,ADMIN_STRENGTH_UNIT,ORD_DRUG_CODE  from ph_medn_admin_dtl  WHERE facility_id = ?  AND sch_date_time = TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND ord_drug_code = ? AND dosage_seq_no = ? AND order_id = ?  AND ENCOUNTER_ID=?";
    
    String drug_detail="SELECT dosage_type, a.strength_value, (SELECT freq_nature FROM AM_FREQUENCY_LANG_VW WHERE   FREQ_CODE=c.FREQ_CODE and LANGUAGE_ID=?)freq_nature FROM or_order_line_ph a,  or_order b,or_order_line c WHERE a.order_id = ? AND a.order_id = b.order_id and a.order_id = c.order_id and b.order_id = c.order_id  and a.order_line_num = ?  and a.order_line_num = c.order_line_num";
try{
	connection = getConnection();
	
	pstmt5 = connection.prepareStatement(drug_detail);
	pstmt5.setString(1,locale);
	pstmt5.setString(2,order_id);
	pstmt5.setString(3,order_line_num);
	
	resultSet5=pstmt5.executeQuery();
	while ( resultSet5 != null && resultSet5.next() ) {
		dosage_type=resultSet5.getString("dosage_type")==null?"":resultSet5.getString("dosage_type");
		strength_value=resultSet5.getString("strength_value")==null?"":resultSet5.getString("strength_value");
		freq_nature=resultSet5.getString("freq_nature")==null?"":resultSet5.getString("freq_nature");
		}
	
	
	if(dosage_type.equals("S") && !freq_nature.equals("P") ) {
		div_value	=	Float.parseFloat(strength_value);
		if(div_value == 0)
			div_value=1;
		adm_qty	=	Float.parseFloat(administered_qty)*Float.parseFloat(strength_per_value_pres_uom)/div_value;
	}
	else {
		adm_qty	= Float.parseFloat(administered_qty);
	}
	administered_qty=""+adm_qty;
	pstmt = connection.prepareStatement(cancelUpdate);
	pstmt.setString(1,"Y");
	pstmt.setString(2,login_facility_id.trim());
	pstmt.setString(3,login_by_id.trim());
	pstmt.setString(4,login_at_ws_no.trim());
	pstmt.setString(5,login_facility_id.trim());
	pstmt.setString(6,sch_date_time);
	pstmt.setString(7,drug_code);
	pstmt.setString(8,dosage_seq);
	pstmt.setString(9,order_id);
	pstmt.setString(10,order_line_num);
	pstmt.setString(11,encounter_id);
	pstmt.setString(12,patient_id);
	
	int cnt =pstmt.executeUpdate();
	if(cnt>0){
	successFlag = true;
	}
	
	
	
	pstmt4 = connection.prepareStatement(admin_detail);
	pstmt4.setString(1,login_facility_id.trim());
	pstmt4.setString(2,sch_date_time);
	pstmt4.setString(3,drug_code);
	pstmt4.setString(4,dosage_seq);
	pstmt4.setString(5,order_id);
	pstmt4.setString(6,encounter_id);
	
	resultSet4=pstmt4.executeQuery();
	
	while ( resultSet4 != null && resultSet4.next() ) {
		result.add(resultSet4.getString("ADMIN_DRUG_CODE")==null?"":resultSet4.getString("ADMIN_DRUG_CODE"));
		result.add(resultSet4.getString("ADMIN_DOSAGE_QTY")==null?"":resultSet4.getString("ADMIN_DOSAGE_QTY"));
		result.add(resultSet4.getString("ADMIN_DOSAGE_UOM_CODE")==null?"":resultSet4.getString("ADMIN_DOSAGE_UOM_CODE"));
		result.add(resultSet4.getString("ADMIN_STRENGTH")==null?"":resultSet4.getString("ADMIN_STRENGTH"));
		result.add(resultSet4.getString("ADMIN_STRENGTH_UNIT")==null?"":resultSet4.getString("ADMIN_STRENGTH_UNIT"));
		result.add(resultSet4.getString("ORD_DRUG_CODE")==null?"":resultSet4.getString("ORD_DRUG_CODE"));
	}
	
	pstmt1 = connection.prepareStatement(cancelDelete);
	pstmt1.setString(1,login_facility_id.trim());
	pstmt1.setString(2,sch_date_time);
	pstmt1.setString(3,drug_code);
	pstmt1.setString(4,dosage_seq);
	pstmt1.setString(5,order_id);
	pstmt1.setString(6,encounter_id);
	
	int cnt1 =pstmt1.executeUpdate();
	if(cnt1>0){
	successFlag1 = true;
	}
	
	pstmt2 = connection.prepareStatement(cancelUpdate1);
	pstmt2.setString(1,administered_qty);
	pstmt2.setString(2,administered_qty);
	pstmt2.setString(3,login_by_id.trim());
	pstmt2.setString(4,login_at_ws_no.trim());
	pstmt2.setString(5,login_facility_id.trim());
	pstmt2.setString(6,order_id);
	pstmt2.setString(7,order_line_num);
	pstmt2.setString(8,login_facility_id.trim());
	pstmt2.setString(9,encounter_id);
	pstmt2.setString(10,patient_id);
	int cnt2 =pstmt2.executeUpdate();
	if(cnt2>0){
	successFlag2 = true;
	}
	
	pstmt3 = connection.prepareStatement(cancelinsert);
	pstmt3.setString(1,patient_id);
	pstmt3.setString(2,encounter_id);
	pstmt3.setString(3,login_facility_id.trim());
	pstmt3.setString(4,dosage_seq);
	pstmt3.setString(5,order_id);
	pstmt3.setString(6,order_line_num);
	pstmt3.setString(7,admin_by_name);
	pstmt3.setString(8,admin_date_time);
	pstmt3.setString(9,sch_date_time);
	pstmt3.setString(10,login_by_id.trim());
	pstmt3.setString(11,reasonCode);
	pstmt3.setString(12,(String)result.get(0));
	pstmt3.setString(13,(String)result.get(1));
	pstmt3.setString(14,(String)result.get(2));
	pstmt3.setString(15,(String)result.get(3));
	pstmt3.setString(16,(String)result.get(4));
	pstmt3.setString(17,(String)result.get(5));
	pstmt3.setString(18,login_by_id.trim());
	pstmt3.setString(19,login_at_ws_no.trim());
	pstmt3.setString(20,login_facility_id.trim());
	pstmt3.setString(21,login_by_id.trim());
	pstmt3.setString(22,login_at_ws_no.trim());
	pstmt3.setString(23,login_facility_id.trim());
	
		int cnt3 =pstmt3.executeUpdate();
	if(cnt3>0){
	successFlag3 = true;
	}
	

	if(freq_nature.equals("P")){
	pstmt_select=connection.prepareStatement( "SELECT round(NVL(A.ORDER_QTY,0)-(NVL(B.TOT_ADMINISTERED_QTY,0)),4) DIFF_QTY FROM OR_ORDER_LINE A,PH_PATIENT_DRUG_PROFILE B WHERE A.ORDER_ID=B.ORIG_ORDER_ID  AND A.ORDER_LINE_NUM=B.ORIG_ORDER_LINE_NO AND A.ORDER_ID=? AND A.ORDER_LINE_NUM=?" ) ;
	
	pstmt_select.setString(1,order_id);
	pstmt_select.setString(2,order_line_num);
	resultSet6	=	pstmt_select.executeQuery();
	if(resultSet6.next()){
		diff_qty_1	= resultSet6.getFloat("DIFF_QTY");
	}
	 pstmt_select_cancel_yn_update	=	connection.prepareStatement("UPDATE ph_medn_admin SET SCH_DOSAGE_QTY =?  WHERE ORDER_ID= ? AND ORDER_LINE_NUM=? AND ADMINISTERED_YN <>'Y'");
	 pstmt_select_cancel_yn_update.setString(1,diff_qty_1+"");
		 
	 pstmt_select_cancel_yn_update.setString(2,order_id);
	 pstmt_select_cancel_yn_update.setString(3,order_line_num);
	 pstmt_select_cancel_yn_update.executeUpdate();
	
	}

	if(successFlag && successFlag1 && successFlag2 && successFlag3){
		connection.commit();
	map.put( "result", new Boolean( true ) ) ;	
	map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED","PH") ) ;
	}
}
    catch(Exception e){
		 
		map.put( "result", new Boolean( false ) ) ; 
		map.put( "message", e.getMessage()) ;
		map.put("flag","0");
		e.printStackTrace() ;
		
		try{
			connection.rollback();
		}
		catch(Exception ee){
			ee.printStackTrace() ;
		}
	}//catch
	finally{
		try{
    closeResultSet( resultSet4 ) ;
    closeResultSet( resultSet5 ) ;
    closeResultSet( resultSet6 ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt1) ;
			closeStatement( pstmt2) ;
			closeStatement( pstmt3) ;
			closeStatement( pstmt4) ;
			closeStatement(pstmt_select);
			closeStatement(pstmt_select_cancel_yn_update);
			
			
      closeStatement( pstmt5) ;
			
			
			
			closeConnection( connection );
		}
		catch(Exception ex){
			ex.printStackTrace() ;
		}
	}//finally
	return map;
}

public ArrayList getCancilationHistoryForRX(String iv_prep_yn,String order_id,String order_line_num,String sch_date_time,String patient_id,String encounter_id,String dosage_seq){
	Connection connection	= null ;
	PreparedStatement pstmt	= null ;
	ResultSet resultSet		= null ;
	locale = getLanguageId()==null?"en":getLanguageId();
	ArrayList history = new ArrayList();
	try{
		connection = getConnection() ;
		if(iv_prep_yn.equals("") || iv_prep_yn.equals("")){
		pstmt		= connection.prepareStatement("SELECT (SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE appl_user_id = a.admin_by_id AND language_id = ?) admin_by_id,TO_CHAR(admin_date_time,'DD/MM/YYYY HH24:MI')ADMIN_DATE_TIME, TO_CHAR(cancled_date_time,'DD/MM/YYYY HH24:MI')cancled_date_time,(SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE appl_user_id = a.cancled_by_id AND language_id = ?) cancled_by_id,(SELECT reason_desc FROM ph_medn_trn_reason_lang_vw ph_medn_trn_reason WHERE appl_trn_type = 'CM' AND language_id = ? AND reason_code = a.cancled_reason) cancled_reason,TO_CHAR(sch_date_time,'DD/MM/YYYY HH24:MI')sch_date_time, admin_dosage_qty, admin_dosage_uom_code,b.ORDER_QTY,b.ORDER_UOM FROM ph_medn_cancel_details a, or_order_line b WHERE a.order_id = ? AND a.order_line_num = ? AND sch_date_time = TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND a.facility_id = ? AND a.order_id = b.order_id AND a.order_line_num = b.order_line_num   and a.PATIENT_ID=?  and a.DOSAGE_SEQ_NO=? order by cancled_date_time desc");
		
		pstmt.setString(1,locale);
		 pstmt.setString(2,locale);
		 pstmt.setString(3,locale);
		 pstmt.setString(4,order_id);
		 
		 pstmt.setString(5,order_line_num);
		 pstmt.setString(6,sch_date_time);
		 pstmt.setString(7,login_facility_id.trim());
		pstmt.setString(8,patient_id);
		pstmt.setString(9,dosage_seq);
		 
		resultSet			= pstmt.executeQuery();
		}
		else{
			pstmt		= connection.prepareStatement("SELECT (SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE appl_user_id = a.admin_by_id AND language_id = ?) admin_by_id,TO_CHAR(admin_date_time,'DD/MM/YYYY HH24:MI')ADMIN_DATE_TIME, TO_CHAR(cancled_date_time,'DD/MM/YYYY HH24:MI')cancled_date_time,(SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE appl_user_id = a.cancled_by_id AND language_id = ?) cancled_by_id,(SELECT reason_desc FROM ph_medn_trn_reason_lang_vw ph_medn_trn_reason WHERE appl_trn_type = 'CM' AND language_id = ? AND reason_code = a.cancled_reason) cancled_reason,TO_CHAR(sch_date_time,'DD/MM/YYYY HH24:MI')sch_date_time, admin_dosage_qty, admin_dosage_uom_code,b.ORDER_QTY,b.ORDER_UOM FROM ph_medn_cancel_details a, or_order_line b WHERE a.order_id = ? AND a.order_line_num = ?  AND a.facility_id = ? AND a.order_id = b.order_id AND a.order_line_num = b.order_line_num   and a.PATIENT_ID=?  and a.DOSAGE_SEQ_NO=? order by cancled_date_time desc");
			
			pstmt.setString(1,locale);
			 pstmt.setString(2,locale);
			 pstmt.setString(3,locale);
			 pstmt.setString(4,order_id);
			 
			 pstmt.setString(5,order_line_num);
			// pstmt.setString(6,sch_date_time);
			 pstmt.setString(6,login_facility_id.trim());
			pstmt.setString(7,patient_id);
			pstmt.setString(8,dosage_seq);
			 
			resultSet			= pstmt.executeQuery();
		}
			while(resultSet!=null && resultSet.next())
			{
				
				history.add(resultSet.getString("ADMIN_BY_ID")==null?"":resultSet.getString("ADMIN_BY_ID"));
				history.add(resultSet.getString("ADMIN_DATE_TIME")==null?"":resultSet.getString("ADMIN_DATE_TIME"));
				history.add(resultSet.getString("CANCLED_DATE_TIME")==null?"":resultSet.getString("CANCLED_DATE_TIME"));
				history.add(resultSet.getString("CANCLED_BY_ID")==null?"":resultSet.getString("CANCLED_BY_ID"));
				history.add(resultSet.getString("CANCLED_REASON")==null?"":resultSet.getString("CANCLED_REASON"));
				history.add(resultSet.getString("SCH_DATE_TIME")==null?"":resultSet.getString("SCH_DATE_TIME"));
				history.add(resultSet.getString("ADMIN_DOSAGE_QTY")==null?"":resultSet.getString("ADMIN_DOSAGE_QTY"));
				history.add(resultSet.getString("ADMIN_DOSAGE_UOM_CODE")==null?"":resultSet.getString("ADMIN_DOSAGE_UOM_CODE"));
				history.add(resultSet.getString("ORDER_QTY")==null?"":resultSet.getString("ORDER_QTY"));
				history.add(resultSet.getString("ORDER_UOM")==null?"":resultSet.getString("ORDER_UOM"));
				
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
	return history;
}
// Added for JD-CRF-0200 END

public HashMap cancelAdminstrationForIvRx(String drug_code,String order_id,String order_line_num,String iv_prep_yn,String sch_date_time,String dosage_seq,String administered_qty,String patient_id,String encounter_id,String admin_date_time,String admin_by_name,String reasonCode,String strength_per_value_pres_uom){
	//added for jd-crf-0200 start
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in insert.." ) ;
		map.put( "flag", "0" ) ;
		locale = getLanguageId()==null?"en":getLanguageId();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		PreparedStatement pstmt1 = null ;
		ResultSet resultSet1		= null ;
		ArrayList drugDetailList = new ArrayList();
		ArrayList adminList = new ArrayList();
		String adminedQty="";
		PreparedStatement pstmt3 = null ;
		PreparedStatement pstmt2 = null ;
		PreparedStatement pstmt4 = null ;
		PreparedStatement pstmt5 = null ;
		boolean /*updated=true,*/updated1=true,successFlag1=false; //commented updated for common-icn-0048
		
		int cancelUpdateCnt=0,cancelUpdate1Cnt=0;
		int listSize=0;
		String schDateTime="";
		
		float div_value=0,adm_qty=0;
		  
	    String drug_detail="";
	    drug_detail="SELECT dosage_type, a.strength_value,a.order_line_num,a.order_id,ORDER_CATALOG_CODE,(SELECT freq_nature FROM am_frequency_lang_vw WHERE freq_code = c.freq_code AND language_id = ?) freq_nature FROM or_order_line_ph a, or_order b, or_order_line c WHERE a.order_id = ? AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND a.order_line_num = c.order_line_num";
	    String adminDetail="SELECT TO_CHAR(sch_date_time,'DD/MM/YYYY HH24:MI')sch_date_time,admin_drug_code, admin_dosage_qty, admin_dosage_uom_code,admin_strength, admin_strength_unit, ord_drug_code,STRENGTH_PER_VALUE_PRES_UOM FROM ph_medn_admin_dtl a,ph_drug b WHERE facility_id = ? AND dosage_seq_no = ? AND order_id =  ?  and a.admin_drug_code=b.drug_code and a.ORD_DRUG_CODE=?";
	    
	    String cancelUpdate="UPDATE ph_medn_admin SET admn_dose_chng_remarks='', cancel_recorded_yn = ?,cancel_date_time = sysdate,administered_yn = '',ADMIN_RECORDED_YN='', modified_facility_id = ?,modified_date = SYSDATE,modified_by_id = ?,modified_at_ws_no = ? WHERE facility_id = ?  AND sch_date_time = TO_DATE (?, 'DD/MM/YYYY HH24:MI')  AND dosage_seq_no = ? AND order_id = ?   AND ENCOUNTER_ID=? AND PATIENT_ID=?";

	    String cancelDelete="DELETE FROM PH_MEDN_ADMIN_DTL  WHERE facility_id = ?  AND sch_date_time = TO_DATE (?, 'DD/MM/YYYY HH24:MI')  AND dosage_seq_no = ? AND order_id = ?  AND ENCOUNTER_ID=? ";

	    String cancelUpdate1="UPDATE PH_PATIENT_DRUG_PROFILE SET TOT_CANCLED_QTY=(NVL(TOT_CANCLED_QTY,0)+?),TOT_ADMINISTERED_QTY=(NVL(TOT_ADMINISTERED_QTY,0)-?),MODIFIED_DATE=SYSDATE,MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE  ORIG_ORDER_ID=? AND ORIG_ORDER_LINE_NO=? AND FACILITY_ID=? AND ENCOUNTER_ID=? AND PATIENT_ID=?";
	    
	    String cancelinsert="INSERT INTO PH_MEDN_CANCEL_DETAILS  (PATIENT_ID,ENCOUNTER_ID,FACILITY_ID,dosage_seq_no,order_id,ORDER_LINE_NUM,ADMIN_BY_ID,ADMIN_DATE_TIME,SCH_DATE_TIME,CANCLED_BY_ID,CANCLED_DATE_TIME,CANCLED_REASON,ADMIN_DRUG_CODE,ADMIN_DOSAGE_QTY,ADMIN_DOSAGE_UOM_CODE,ADMIN_STRENGTH,ADMIN_STRENGTH_UNIT,ORD_DRUG_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES(?,?,?,?,?,?,?,TO_DATE (?, 'DD/MM/YYYY HH24:MI'),TO_DATE (?, 'DD/MM/YYYY HH24:MI'),?,SYSDATE,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
	    if(iv_prep_yn.equals("5")){
	    	
	    	drug_detail="SELECT d.PRESCRIBED_MODE dosage_type, a.strength_value, a.order_line_num, a.order_id, order_catalog_code,(SELECT freq_nature FROM am_frequency_lang_vw  WHERE freq_code = c.freq_code AND language_id = ?) freq_nature FROM or_order_line_ph a, or_order b, or_order_line c,ph_patient_drug_profile d WHERE a.order_id = ? AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND a.order_id = d.orig_order_id AND b.order_id = d.orig_order_id AND c.order_id = d.orig_order_id AND a.order_line_num = c.order_line_num AND a.order_line_num = d.orig_order_line_no AND c.order_line_num = d.orig_order_line_no";
	    }
	    try{
		connection = getConnection();
		
		pstmt = connection.prepareStatement(drug_detail);
		pstmt.setString(1,locale);
		pstmt.setString(2,order_id);
		
		resultSet=pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			drugDetailList.add(resultSet.getString("dosage_type")==null?"":resultSet.getString("dosage_type"));
			drugDetailList.add(resultSet.getString("strength_value")==null?"":resultSet.getString("strength_value"));
			drugDetailList.add(resultSet.getString("freq_nature")==null?"":resultSet.getString("freq_nature"));
			drugDetailList.add(resultSet.getString("ORDER_CATALOG_CODE")==null?"":resultSet.getString("ORDER_CATALOG_CODE"));
			drugDetailList.add(resultSet.getString("order_id")==null?"":resultSet.getString("order_id"));
			drugDetailList.add(resultSet.getString("order_line_num")==null?"":resultSet.getString("order_line_num"));
			}
		System.out.println("drugDetailList"+drugDetailList);
		
		
		for(int i=0;i<drugDetailList.size();i=i+6){
		pstmt1 = connection.prepareStatement(adminDetail);
		pstmt1.setString(1,login_facility_id.trim());
		pstmt1.setString(2,dosage_seq);
		pstmt1.setString(3,order_id);
		System.out.println("drug_code"+(String)drugDetailList.get(i+3));
		pstmt1.setString(4,(String)drugDetailList.get(i+3));
		resultSet1=pstmt1.executeQuery();
		
		while ( resultSet1 != null && resultSet1.next() ) {
			
			adminList.add(resultSet1.getString("ADMIN_DRUG_CODE")==null?"":resultSet1.getString("ADMIN_DRUG_CODE"));
			adminedQty=resultSet1.getString("admin_dosage_qty")==null?"":resultSet1.getString("admin_dosage_qty");
			strength_per_value_pres_uom=resultSet1.getString("STRENGTH_PER_VALUE_PRES_UOM")==null?"1":resultSet1.getString("STRENGTH_PER_VALUE_PRES_UOM");
			
			adminList.add(adminedQty);
			adminList.add(resultSet1.getString("admin_dosage_uom_code")==null?"":resultSet1.getString("admin_dosage_uom_code"));
			adminList.add(resultSet1.getString("admin_strength")==null?"":resultSet1.getString("admin_strength"));
			adminList.add(resultSet1.getString("admin_strength_unit")==null?"":resultSet1.getString("admin_strength_unit"));
			adminList.add(resultSet1.getString("ord_drug_code")==null?"":resultSet1.getString("ord_drug_code"));
			adminList.add(strength_per_value_pres_uom);
			
			if(((String)drugDetailList.get(i)).equals("S") && !((String)drugDetailList.get(i+2)).equals("P") ) {
				div_value	=	Float.parseFloat((String)drugDetailList.get(i+1));
			
				if(div_value == 0)
					div_value=1;
				adm_qty	=	Float.parseFloat(adminedQty)*Float.parseFloat(strength_per_value_pres_uom)/div_value;
			}
			else{
				adm_qty	= Float.parseFloat(adminedQty);
			}
			adminList.add(adm_qty);
			adminList.add((String)drugDetailList.get(i+4));
			adminList.add((String)drugDetailList.get(i+5));
			adminList.add(resultSet1.getString("sch_date_time")==null?"":resultSet1.getString("sch_date_time"));
			schDateTime=resultSet1.getString("sch_date_time")==null?"":resultSet1.getString("sch_date_time");
		}
		
		 closeResultSet( resultSet1 ) ;
 		closeStatement( pstmt1 ) ;
 		listSize=listSize+1;
		}
		
		System.out.println("adminList"+adminList);
		
		
		for(int j=0;j<adminList.size();j=j+11){
			pstmt2 = connection.prepareStatement(cancelUpdate1);
			pstmt2.setString(1,""+adminList.get(j+7));
		pstmt2.setString(2,""+adminList.get(j+7));
		pstmt2.setString(3,login_by_id.trim());
		pstmt2.setString(4,login_at_ws_no.trim());
		pstmt2.setString(5,login_facility_id.trim());
		pstmt2.setString(6,(String)adminList.get(j+8));
		pstmt2.setString(7,(String)adminList.get(j+9));
		pstmt2.setString(8,login_facility_id.trim());
		pstmt2.setString(9,encounter_id);
		pstmt2.setString(10,patient_id);
		//pstmt2.addBatch();
		
		int cnt2 =pstmt2.executeUpdate();
		closeStatement( pstmt2 ) ;
		if(cnt2>0){
		cancelUpdate1Cnt=cancelUpdate1Cnt+1;
		}
		
		
		}
		
	
		pstmt3 = connection.prepareStatement(cancelinsert);


		for(int j=0;j<adminList.size();j=j+11){
							
				pstmt3.setString(1,patient_id);
				pstmt3.setString(2,encounter_id);
				pstmt3.setString(3,login_facility_id.trim());
				pstmt3.setString(4,dosage_seq);
				pstmt3.setString(5,(String)adminList.get(j+8));
				pstmt3.setString(6,(String)adminList.get(j+9));
				pstmt3.setString(7,admin_by_name);
				pstmt3.setString(8,admin_date_time);
				pstmt3.setString(9,(String)adminList.get(j+10));
				pstmt3.setString(10,login_by_id.trim());
				pstmt3.setString(11,reasonCode);
				pstmt3.setString(12,(String)adminList.get(j));
				pstmt3.setString(13,(String)adminList.get(j+1));
				pstmt3.setString(14,(String)adminList.get(j+2));
				pstmt3.setString(15,(String)adminList.get(j+3));
				pstmt3.setString(16,(String)adminList.get(j+4));
				pstmt3.setString(17,(String)adminList.get(j+5));
				pstmt3.setString(18,login_by_id.trim());
				pstmt3.setString(19,login_at_ws_no.trim());
				pstmt3.setString(20,login_facility_id.trim());
				pstmt3.setString(21,login_by_id.trim());
				pstmt3.setString(22,login_at_ws_no.trim());
				pstmt3.setString(23,login_facility_id.trim());
				
				pstmt3.addBatch();
						}
						int result1[] = pstmt3.executeBatch() ;
						for (int k=0;k<result1.length ;k++ ){							
							if(result1[k]<0  && result1[k] != -2 ){						
								updated1=false;
								break;
							}
						}
						
	            	pstmt4 = connection.prepareStatement(cancelDelete);
						pstmt4.setString(1,login_facility_id.trim());
						pstmt4.setString(2,schDateTime);
						pstmt4.setString(3,dosage_seq);
						pstmt4.setString(4,order_id);
						pstmt4.setString(5,encounter_id);
						
						int cnt1 =pstmt4.executeUpdate();
						if(cnt1>0){
						successFlag1 = true;
						}				
						for(int j=0;j<adminList.size();j=j+11){
						pstmt5 = connection.prepareStatement(cancelUpdate);
						pstmt5.setString(1,"Y");
						pstmt5.setString(2,login_facility_id.trim());
						pstmt5.setString(3,login_by_id.trim());
						pstmt5.setString(4,login_at_ws_no.trim());
						pstmt5.setString(5,login_facility_id.trim());
						pstmt5.setString(6,(String)adminList.get(j+10));
						//pstmt5.setString(7,drug_code);
						pstmt5.setString(7,dosage_seq);
						pstmt5.setString(8,order_id);
						pstmt5.setString(9,encounter_id);
						pstmt5.setString(10,patient_id);
						int cnt5 =pstmt5.executeUpdate();
						closeStatement( pstmt5 ) ;
						if(cnt5>0){
						cancelUpdateCnt=cancelUpdateCnt+1;
						}
						}
						
	if( updated1  && successFlag1 && cancelUpdate1Cnt == listSize && cancelUpdateCnt == listSize   ){
			connection.commit();
		map.put( "result", new Boolean( true ) ) ;	
		map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED","PH") ) ;
		}
						
	}
	    catch(Exception e){
			 
			map.put( "result", new Boolean( false ) ) ; 
			map.put( "message", e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
			
			try{
				connection.rollback();
			}
			catch(Exception ee){
				ee.printStackTrace() ;
			}
		}//catch
		finally{
			try{
	            closeResultSet( resultSet ) ;
	            closeResultSet( resultSet1 ) ;
	    		closeStatement( pstmt ) ;
	    		closeStatement( pstmt1 ) ;
	    		closeStatement( pstmt2 ) ;
	    		closeStatement( pstmt3 ) ;
	    		closeStatement( pstmt4 ) ;
	    		closeStatement( pstmt5 ) ;
	    		
			
				closeConnection( connection );
			}
			catch(Exception ex){
				ex.printStackTrace() ;
			}
		}//finally
		return map;

}
//added for MMS-KH-SCF-0056 start

public String getVerificationStatus(String patient_class_ord,String facility_id,String store_code,String verifiy_req_yn,String WardAckMarRequiredYn) throws Exception{
	
	Connection connection = null ;
    PreparedStatement pstmt = null ;
    ResultSet resultSet = null;
    String sql=null;
    String verification_req_yn="N";
    String verification_disp="";
	boolean pat_verification_required =isSiteSpecific("PH","VERIFY_PAT_BROUGHT_MEDN");//Added for TH-KW-CRF-0002

	//System.err.println("pat_verification_required@@===="+pat_verification_required+"verifiy_req_yn=="+verifiy_req_yn);
    try {
		connection = getConnection() ;
	    //pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT30") ) ;
		
		if( patient_class_ord.equals("IP")){
			sql="SELECT IP_VERF_YN FROM PH_DISP_LOCN WHERE FACILITY_ID=? AND DISP_LOCN_CODE=?";	
		}
		else{
			sql="SELECT DISP_VERF_STAGE FROM PH_DISP_LOCN WHERE FACILITY_ID=? AND DISP_LOCN_CODE=?";
		}
	    pstmt = connection.prepareStatement(sql.toString()) ;
		pstmt.setString(1,facility_id.trim());
		pstmt.setString(2,store_code.trim());
		resultSet = pstmt.executeQuery() ;
        while ( resultSet != null && resultSet.next() ) {
			
if( patient_class_ord.equals("IP")){
	verification_disp = checkForNull(resultSet.getString("IP_VERF_YN"));
	        if(verification_disp.equals("Y") && verifiy_req_yn.equals("Y") && WardAckMarRequiredYn.equalsIgnoreCase("N")){
    			verification_req_yn="Y";
    		}
    		else
    			verification_req_yn="N";

        	
}
        	else{
        		verification_disp = checkForNull(resultSet.getString("DISP_VERF_STAGE"));
        		if(verification_disp.equals("B") && verifiy_req_yn.equals("Y")){
        			verification_req_yn="Y";
        		}
        		else
        			verification_req_yn="N";
        	}

			 if(verifiy_req_yn.equals("Y") && pat_verification_required){//Added for TH-KW-CRF-0002
                       verification_req_yn="Y";
			 }
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
	return verification_req_yn;
}

public String getOrderstatus(String order_id,String order_line_num) throws Exception{
	
	Connection connection = null ;
    PreparedStatement pstmt = null ;
    ResultSet resultSet = null;
   // String sql=null; //commented for common-icn-0048
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
}//added for mmms-kh-scf-0056
//Adding start for MMS-DM-CRF-0170
public ArrayList getEncounterPatientClass(String facility_id,String encounter_id) throws Exception{  
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList patient_date	= new ArrayList();
		try {
            encounter_id =checkForNull(encounter_id);
			 if(encounter_id ==null || encounter_id.equals("null"))
			    encounter_id="";
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("SELECT PATIENT_ID,PATIENT_CLASS  FROM PR_ENCOUNTER WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ?") ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				patient_date.add(checkForNull(resultSet.getString("PATIENT_ID")));
				patient_date.add(checkForNull(resultSet.getString("PATIENT_CLASS")));
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
		return patient_date;
	}
	public ArrayList getScanCountReqForPatientClass(String patient_class,String function_id) throws Exception{
        Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList scanCountSetup    = new ArrayList();

		try
		{
			connection =getConnection();
			pstmt = connection.prepareStatement("SELECT SCAN_REQUIRED_YN,ALERT_REQUIRED_YN,REMARKS_REQUIRED_YN FROM PR_BARCODE_SCAN_SETUP WHERE FUNCTION_ID = ? AND PATIENT_CLASS =? ") ;
			pstmt.setString(1, function_id.trim());
			pstmt.setString(2, patient_class.trim());
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next())
			{ 
				scanCountSetup.add(resultSet.getString("SCAN_REQUIRED_YN")==null?"N":resultSet.getString("SCAN_REQUIRED_YN"));
				scanCountSetup.add(resultSet.getString("ALERT_REQUIRED_YN")==null?"N":resultSet.getString("ALERT_REQUIRED_YN"));
				scanCountSetup.add(resultSet.getString("REMARKS_REQUIRED_YN")==null?"N":resultSet.getString("REMARKS_REQUIRED_YN"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		}
		return scanCountSetup;	
		
	}
	//Adding end for MMS-DM-CRF-0170
	public String getSplitDosage(String orderid,String order_line_num,String sch_time)throws Exception{

		Connection connection = null ;
        PreparedStatement pstmt = null ;
        String sch_dosage="";
		ResultSet resultSet		= null ;
        try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT ORDER_LINE_DOSE_QTY_VALUE FROM OR_ORDER_LINE_FIELD_VALUES WHERE ORDER_ID=? AND ORDER_LINE_FIELD_MNEMONIC='SCHED_ADMIN_TIME'  AND ORDER_LINE_NUM=? AND ORDER_LINE_FIELD_VALUE=?");
		    pstmt.setString(1,orderid);
			pstmt.setString(2,order_line_num);
			pstmt.setString(3,sch_time);
			
			 
			  resultSet = pstmt.executeQuery();
			if( resultSet != null && resultSet.next() ) {
					sch_dosage=resultSet.getString("ORDER_LINE_DOSE_QTY_VALUE");
			}
        }catch ( Exception e ) {

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
		return sch_dosage;
	}


//added for SKR-SCF-1534
	public String getPRNAdminQty(String orderid,String order_line_num)throws Exception{

		Connection connection = null ;
        PreparedStatement pstmt = null ;
        String prn_qty="";
		ResultSet resultSet		= null ;
        try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT (NVL (A.ORDER_QTY, 0)) - (NVL  (B.SCH_DOSAGE_QTY, 0))  BAL_QTY FROM OR_ORDER_LINE A, PH_MEDN_ADMIN B WHERE A.ORDER_ID = B.ORDER_ID AND A.ORDER_LINE_NUM = B.ORDER_LINE_NUM  AND A.ORDER_ID = ?  AND A.ORDER_LINE_NUM = ? order by 1");
		    pstmt.setString(1,orderid);
			pstmt.setString(2,order_line_num);
			
			 
			  resultSet = pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				
					prn_qty=resultSet.getString("BAL_QTY");
				}
				
			
        }catch ( Exception e ) {

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
		return prn_qty;
	}

//added for MMS-KH-CRF-0039 - start

	public String roundDigits(String a){
		try{
			String bb = "";
			if (a.indexOf(".")==-1){
				bb=a.substring(0,a.length());
			}
			else{
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 2){
					bb=a.substring(0,a.indexOf(".")+2);
				}
				else{
					bb=a;
				}
			}
			return bb;
		}
		catch (Exception e){
			return a;
		}
	}

	public int getDialogHeight(String prn_remarks,String drug_remarks,String pres_remarks,String slidingscaleremarks , String pharma_remarks, String verificationremarks,
	String nonMfrFluidRemarks,String show_remarks,int dialog_height,int pharm_col){
		try{

				if(!prn_remarks.trim().equals(""))
					dialog_height	 += 6.5;

				if(!drug_remarks.trim().equals(""))
					dialog_height	 += 6.5;

				if(!pres_remarks.trim().equals(""))
					dialog_height	 +=6.5;

				if(!slidingscaleremarks.trim().equals(""))
					dialog_height	 +=6.5;

				if(!pharma_remarks.trim().equals(""))
					dialog_height	 += 1.6*pharm_col;

				if(!verificationremarks.trim().equals(""))
					dialog_height	 += 6.5;

				if(!nonMfrFluidRemarks.trim().equals(""))
					dialog_height	 += 7.0;

				if(show_remarks.equals("Y"))
					dialog_height	 += 13;

				if(dialog_height==18) 
					dialog_height = dialog_height-2;
				if(dialog_height==11)
					dialog_height = dialog_height-1;
				if(dialog_height==12)
					dialog_height = dialog_height-1;
				if(dialog_height>18) 
					dialog_height = dialog_height-2;

		}catch(Exception e){
			return dialog_height;
		}

		return dialog_height;
}
	public String getDrugClassInd(String drug_class){
		String drug_class_ind = "";
		try{
			if(drug_class!=null && drug_class.equals("N"))
				drug_class_ind = "background:#66FFFF";
			else if(drug_class!=null && drug_class.equals("C"))
				drug_class_ind = "background:#CCFFCC";
			else
				drug_class_ind = "";

		}catch(Exception e){
		e.printStackTrace();
		}

		return drug_class_ind;
	}
	public String getDisplayStyle(String freq_code,String discontinued,String hold,String admin_recorded_yn,String administered_yn){
	
	String displayStyle = "";
	try{

			if(freq_code!=null && freq_code.equals("STAT")) 
				displayStyle	=	"background-color:#CE00CE;";
			else if(discontinued.equals("Y"))
				displayStyle = "BACKGROUND-COLOR:red;";
			else if(hold.equals("Y"))
				displayStyle = "BACKGROUND-COLOR:yellow;";
			else if(admin_recorded_yn.equals("Y")){
				if(administered_yn.equals("N")) 
					displayStyle = "BACKGROUND-COLOR:#000000;";
				else 
					displayStyle = "BACKGROUND-COLOR:green;";
			}

	}catch(Exception e){
	 e.printStackTrace();
	}
	return displayStyle;		
	}

	public String getShowRemarks(String ext_prod_id,HashMap overridereason){
	
		String show_remarks			= "N";
		try{		
				if(ext_prod_id!=null && !ext_prod_id.equals("")){										
					if(overridereason.size()>1)
					   show_remarks="Y";
				}
				else{									
					if(overridereason.size()>0)
						   show_remarks="Y";
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return show_remarks;
	}
	
	public String getIVPBschInfusionUnit(String ivPB_sch_infusion_per_unit){
		
		try{
			if(ivPB_sch_infusion_per_unit.equals("H")){
				ivPB_sch_infusion_per_unit = "Hrs";
			}else{
				ivPB_sch_infusion_per_unit = "Mins";
			}
		}catch(Exception e){
		 e.printStackTrace();
		 return ivPB_sch_infusion_per_unit;
		}
		return ivPB_sch_infusion_per_unit;
	}
	public String getIVPBSchInfusionRate(String ivPB_sch_infusion_rate){
	
	try{
		if(ivPB_sch_infusion_rate!= null && !(ivPB_sch_infusion_rate.equals(""))){
			if(Float.parseFloat(ivPB_sch_infusion_rate) < 1.0){ 
				ivPB_sch_infusion_rate = Float.parseFloat(ivPB_sch_infusion_rate)+"";
			}
		}
	}catch(Exception e){
	  
	  return ivPB_sch_infusion_rate;
	}
	 return ivPB_sch_infusion_rate;
	}
//added for MMS-KH-CRF-0039 - end
//added for ML-BRU-SCF-2110
public String getDosageType(String order_id,String order_line_num) throws Exception{  
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String dosage_type      = "";
		try {
           
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement("select dosage_type from or_order_line_ph where order_id=? and order_line_num=?") ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){
				dosage_type = resultSet.getString("dosage_type");
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
		return dosage_type;
	}

//Added for MMS-MD-SCF-0179

public String getAcknowlegeforBarcodeYN(String order_id,String order_line_no,String iv_prep_yn){
	PreparedStatement pstmt=null;
	ResultSet  resultSet=null;
	Connection con	= null;
	ArrayList ward_ack_barcode_yn = new ArrayList();
	String ward_ack_barcode_yn_check="";
	try{
		con		= getConnection() ;
		if(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4") || iv_prep_yn.equals("6")){
		  pstmt   = con.prepareStatement("SELECT distinct c.ward_acknowledge FROM ph_disp_hdr a, ph_disp_dtl b, ph_worksheet_hdr c WHERE a.facility_id = b.facility_id AND a.disp_no = b.disp_no AND a.facility_id = c.facility_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_id = ? ");
  			pstmt.setString(1,order_id);

		}else{
			pstmt   = con.prepareStatement("SELECT a.WARD_ACKNOWLEDGE FROM ph_disp_hdr e,PH_DISP_DRUG_BATCH a, PH_DISP_DTL b WHERE e.disp_no=b.disp_no and e.DISP_TYPE!='M'  AND a.facility_id=b.facility_id AND a.disp_no=b.disp_no AND a.srl_no=b.srl_no AND b.ORDER_ID=? AND b.ORDER_LINE_NO=? AND e.order_id = b.order_id ");
		pstmt.setString(1,order_id);
		pstmt.setString(2,order_line_no);			
		}

		resultSet=pstmt.executeQuery();
		while(resultSet!=null && resultSet.next()){
			ward_ack_barcode_yn.add(resultSet.getString("WARD_ACKNOWLEDGE"));
		}
		if(ward_ack_barcode_yn.contains("A")){
			ward_ack_barcode_yn_check="A";
		}
	}catch(Exception ex){
		System.err.println("Exception "+ex.getMessage());
		ex.printStackTrace();
	}finally{
		try{
			if(pstmt !=null) pstmt.close();
			if(resultSet !=null) resultSet.close();
			closeConnection(con);
		}
		catch(Exception fe){
		}
	}
	System.err.println("ward_ack_barcode_yn==>" + ward_ack_barcode_yn);
		return ward_ack_barcode_yn_check;
  }

//Added for MMS-MD-SCF-0179

//Added for NMC-JD-CRF-0186 [43323] START
public String getUnbilledMedicateYN(String facility_id){
	Connection connection = null;
	PreparedStatement pstmt	= null ;
	ResultSet resultSet		= null ;
	String unbilledMedicateYN = "";
	try{
		connection = getConnection() ;
		pstmt			= connection.prepareStatement("SELECT MAR_DISP_UNBILLED_MED_YN FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?");
		pstmt.setString(1,facility_id);
		resultSet	= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next()){
			unbilledMedicateYN = resultSet.getString("MAR_DISP_UNBILLED_MED_YN");
		}
	}catch(Exception e){
			e.printStackTrace();
	}finally{
		try{
			if(pstmt !=null) pstmt.close();
			if(resultSet !=null) resultSet.close();
			closeConnection(connection);
		}
		catch(Exception fe){
		}
	}
	return unbilledMedicateYN;
}
public ArrayList getDetails(String facility_id,String patient_id,String encounter_id){
	ArrayList list = new ArrayList();
	Connection connection = null;
	PreparedStatement pstmt	= null ;
	ResultSet resultSet		= null ;
	try{
		connection = getConnection() ;
		pstmt			= connection.prepareStatement("SELECT CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE,OP_EPISODE_VISIT_NUM visit_id FROM pr_encounter WHERE FACILITY_ID=? AND PATIENT_ID=? AND ENCOUNTER_ID=? ") ;
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,encounter_id);
		resultSet	= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next()){
			list.add(resultSet.getString("EPISODE_TYPE"));
			list.add(resultSet.getString("visit_id"));
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(pstmt !=null) pstmt.close();
			if(resultSet !=null) resultSet.close();
			closeConnection(connection);
		}
		catch(Exception fe){
		}
	}
	return list;
}

public String getBillStatus(String facility_id,String patient_id,String episode_id, String episode_type, String visit_id, String order_id, String  order_line_num){
	String errorMsg="";
	String billStatus = "";
	Connection connection = null;
	CallableStatement callableStatement = null;
	try {
		connection=getConnection();
		callableStatement	= connection.prepareCall("{ call BL_BILL_STATUS (?,?,?,?,?,?,?,?,?) }"); 
		callableStatement.setString(1, facility_id);
		callableStatement.setString(2, patient_id);
		callableStatement.setString(3, episode_id);
		callableStatement.setString(4, episode_type);
		callableStatement.setString(5, visit_id);
		callableStatement.setString(6, order_id);
		callableStatement.setString(7, order_line_num);
		callableStatement.registerOutParameter(8, Types.VARCHAR);
		callableStatement.registerOutParameter(9, Types.VARCHAR);
		callableStatement.execute();
		billStatus = callableStatement.getString(8);
		errorMsg = callableStatement.getString(9);
		System.out.println("billStatus from MedicationAdministrationFTBean of BL_BILL_STATUS Procedure is :::: "+billStatus);
		System.out.println("ErrorMsg from MedicationAdministrationFTBean of BL_BILL_STATUS Procedure is :::: "+billStatus);
	} catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			closeStatement( callableStatement ) ;
			closeConnection(connection);
		}
		catch(Exception fe){
		}
	}
		return billStatus;
}
//Added for NMC-JD-CRF-0186 [43323] END
}