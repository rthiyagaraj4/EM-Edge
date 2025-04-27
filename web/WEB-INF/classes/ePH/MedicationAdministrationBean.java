/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.* ;
//import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;

import ePH.MedicationAdministrationFT.*;

public class MedicationAdministrationBean extends PhAdapter implements Serializable {
	
	protected ArrayList DrugDoseTimeDetails		= new ArrayList();
	protected ArrayList DrugAdminDetails		= new ArrayList();
	protected ArrayList newDrugDetails			= new ArrayList();
	protected ArrayList selDrugCodes			= new ArrayList();
	protected HashMap NONIVDrugDetails			= new HashMap();
	protected HashMap NEWNONIVDrugDetails		= new HashMap();
	protected HashMap IVDrugDetails				= new HashMap();
	protected HashMap ALTDrugDetails			= new HashMap();
	private HashMap drug_remarks				= new HashMap();

	protected String nursing_unit				="";
//	protected String admin_due_date				="";
	protected String encounter_id				="";
	protected String bed_no						="";
	protected String patient_id					="";
	protected String medn_admin_reqd_yn			="";
	protected String mar_disp_held_disc_orders_yn	="";
	protected String totalTaperQtyDisplay	="";//Added for  RUT-CRF-0088 [IN:036978]
	protected String MAR_skip_pat_butn_disp_yn = "Y";//added for SKR-SCF-1033 [IN:051790]
	protected String allow_mar_share_drug_yn = "N";//added for HSA-CRF-0090 [IN:041241] - start
	protected String Mar_Admin_Dtl_Cont_Norc_Mand="";//added for SKR-SCF-1043[051891]
	protected String allow_auto_disp_alt_drug_mar = "N";//Added for Bru-HIMS-CRF-399 [IN:043767]
	private   String sys_date_with_out_time		= "";
	
	private	  HashMap reason_codes				= null;
	private	  HashMap reason_codes1				= null;//ADDED FOR MMS-KH-CRF-0010
	private	  HashMap	adrDetails				=	new HashMap();
	private	  ArrayList disp_dtls				= new ArrayList();
	private HashMap adrReason			=	new HashMap();
	private ArrayList all_dtls			=	new ArrayList();
	String locale = "";
	private HashMap hmShcMARDtls = null;
	private String  early_or_late_admin_yn = "N"; // Added for GLH-CRF-0482
	private String  ward_ack_mar_required_yn = "N"; // Added for MMS-KH-CRF-0014 [IN:067953] - Start
	public String getWardAckMarRequiredYn() {
		return ward_ack_mar_required_yn;
	}
	public void setWardAckMarRequiredYn(String ward_ack_mar_required_yn) {
		this.ward_ack_mar_required_yn = ward_ack_mar_required_yn;
	} // Added for MMS-KH-CRF-0014 [IN:067953] - End
	// Added for MMS-KH-SCF-0056 start
	private String  verf_reqd_bef_med_admin = "N"; 
	public String getverfreqdbefmedAdmin() {
		return verf_reqd_bef_med_admin;
	}
	public void setverfreqdbefmedAdmin(String verf_reqd_bef_med_admin_yn) {
		this.verf_reqd_bef_med_admin = verf_reqd_bef_med_admin_yn;
	}
	// Added for MMS-KH-SCF-0056 end
	public void setSchMARParams(HashMap hmShcMARDtlsTmp){
		this.hmShcMARDtls = hmShcMARDtlsTmp;
	}
	
	public HashMap getSchMARParams(){
		if(this.hmShcMARDtls ==null)
			setSchMARParams();
		return this.hmShcMARDtls;
	}

	public String getEarlyOrLateAdminYn() { // Added for GLH-CRF-0482 - Start
		return early_or_late_admin_yn;
	}

	public void setEarlyOrLateAdminYn(String early_or_late_admin_yn) {
		this.early_or_late_admin_yn = early_or_late_admin_yn;
	} // Added for GLH-CRF-0482 - End

	public MedicationAdministrationBean() {
        try {
            doCommon();
        }
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setEncounterId(String EncounterId){
		encounter_id=EncounterId;
	}
	public void setBedNo(String BedNo){
		bed_no=BedNo;
	}
	public void setPatientId(String PatientId){
		patient_id=PatientId;
	}
	public void setNursingUnit(String nursingUnit){
		nursing_unit=nursingUnit;
	}
	/*public void setAdminDueDate(String adminDueDate){
		admin_due_date = adminDueDate;
	}*/
	public void setselDrugCodes(String details){
		if(selDrugCodes.size()==0){
			this.selDrugCodes.add(details.trim());
		}
		else{
			if(!(selDrugCodes.contains(details.trim()))){
				this.selDrugCodes.add(details.trim());
			}
		}
	}
	public ArrayList getselDrugCodes(){
		return this.selDrugCodes;
	}

	public void cancelSelDrugCodes(String sel_schedule_time){

		for (int i=0;i<selDrugCodes.size() ; i++){
			if(((String)selDrugCodes.get(i)).equals(sel_schedule_time)){
				selDrugCodes.remove(i);
				selDrugCodes.trimToSize();
				break;
			}
		}	
	}
	public boolean validateDrugRemarks(String drug_code,String row_no){
		if(drug_remarks.containsKey(drug_code+"$"+row_no)){
			return true;
		}else{
			return false;
		}
	}
	public void saveRemarksForDrug(String row_no,String drug_code,ArrayList remarks){
		drug_remarks.put(drug_code+"$"+row_no,remarks);
	}
	public HashMap getRemarksForDrug(){
		return drug_remarks;
	}
	public ArrayList getRemarksForDrug(String drug_code,String row_no){
		return ((ArrayList)drug_remarks.get(drug_code+"$"+row_no));
	}

	public void setNONIVDrugDetails(ArrayList details,String time){
		this.NONIVDrugDetails.put(time,details);
	}
	public void setNEWNONIVDrugDetails(ArrayList details,String time){
		this.NEWNONIVDrugDetails.put(time,details);
	}
	public void setIVDrugDetails(ArrayList details,String time){
		this.IVDrugDetails.put(time,details);
	}
	public void setALTDrugDetails(HashMap details,String time){
		this.ALTDrugDetails.put(time,details);
	}
	public void clearDrugDetails(){
		 NONIVDrugDetails			= new HashMap();
		 IVDrugDetails				= new HashMap();
		 ALTDrugDetails			    = new HashMap();
		 selDrugCodes			    = new ArrayList();
	}
	
	public HashMap getNONIVDrugDetails(){
		return this.NONIVDrugDetails;
	}
	public HashMap getNEWNONIVDrugDetails(){
		return this.NEWNONIVDrugDetails;
	}
	public HashMap getALTDrugDetails(){
		return this.ALTDrugDetails;
	}
	public HashMap getIVDrugDetails(){
		return this.IVDrugDetails;
	}
	public ArrayList getDrugAdminDetails(){
		return this.DrugAdminDetails;
	}
	public void setDrugDoseTimeDetails(ArrayList details){
		this.DrugDoseTimeDetails=details;
	}
	public ArrayList getDrugDoseTimeDetails(){
		return this.DrugDoseTimeDetails;
	}
	public void setnewDrugDetails(HashMap details){
		newDrugDetails.add(details);
	}
	public ArrayList getnewDrugDetails(){
		return this.newDrugDetails;
	}
	
	public void setDispDtls(ArrayList disp_dtls){
		this.disp_dtls = disp_dtls;
	}
	
	public ArrayList getDispDtls(){
		return this.disp_dtls;
	}
	public String getTotalTaperQtyDisplay() {  //Added for  RUT-CRF-0088 [IN:036978] -Start
		return this.totalTaperQtyDisplay;
	}
	public void setTotalTaperQtyDisplay(String totalTaperQtyDisplay) {
		this.totalTaperQtyDisplay = totalTaperQtyDisplay;
	}  //Added for  RUT-CRF-0088 [IN:036978] -end
	public String getMARSkipPatButnDisp() {  //Added for  SKR-SCF-1033 [IN:051790] -Start
		return this.MAR_skip_pat_butn_disp_yn;
	}
	public void setMARSkipPatButnDisp(String MAR_skip_pat_butn_disp_yn) {
		this.MAR_skip_pat_butn_disp_yn = MAR_skip_pat_butn_disp_yn;
	}  //Added for  SKR-SCF-1033 [IN:051790] -end

	public String getMednAdminReqdYN(){ ////added for [IN:043283]- Start
		return this.medn_admin_reqd_yn;
	}
	public void setMednAdminReqdYN(String medn_admin_reqd_yn){
		this.medn_admin_reqd_yn=medn_admin_reqd_yn;
	}
	public String  getMarDispHeldDiscOrdersYN(){
		return this.mar_disp_held_disc_orders_yn;
	}
	public void setMarDispHeldDiscOrdersYN(String mar_disp_held_disc_orders_yn){
		this.mar_disp_held_disc_orders_yn=mar_disp_held_disc_orders_yn;
	} //added for [IN:043283] - End

	public String  getAllowMARShareDrug(){
		return this.allow_mar_share_drug_yn;
	}	
	public void setAllowMARShareDrug(String allow_mar_share_drug_yn){
		this.allow_mar_share_drug_yn=allow_mar_share_drug_yn;
	} //added for HSA-CRF-0090 [IN:041241] - End	

	public String getMar_Admin_Dtl_Cont_Norc_Mand() {  //added for SKR-SCF-1043[051891] start
		return this.Mar_Admin_Dtl_Cont_Norc_Mand;
	}
	public void setMar_Admin_Dtl_Cont_Norc_Mand(String Mar_Admin_Dtl_Cont_Norc_Mand) {
		this.Mar_Admin_Dtl_Cont_Norc_Mand = Mar_Admin_Dtl_Cont_Norc_Mand;
	} //added for SKR-SCF-1043[051891] end
	public String getAllow_auto_disp_alt_drug_mar() {//Added for Bru-HIMS-CRF-399 [IN:043767] start
		return allow_auto_disp_alt_drug_mar;
	}
	public void setAllow_auto_disp_alt_drug_mar(String allow_auto_disp_alt_drug_mar) {
		this.allow_auto_disp_alt_drug_mar = allow_auto_disp_alt_drug_mar;
	}//Added for Bru-HIMS-CRF-399 [IN:043767] end
	public void clear(){
		super.clear();
		drug_remarks            = new HashMap();
		DrugDoseTimeDetails		= new ArrayList();
		newDrugDetails			= new ArrayList();
		IVDrugDetails			= new HashMap();
		NONIVDrugDetails		= new HashMap();
		DrugAdminDetails		= new ArrayList();
		selDrugCodes			= new ArrayList();

		nursing_unit				="";
//		admin_due_date				="";
		encounter_id				="";
		bed_no						="";
		patient_id					="";
		reason_codes				= null;
		reason_codes1				= null;//ADDED FOR MMS-KH-CRF-0010
		adrDetails					= new HashMap();
	}

	private void doCommon() throws Exception {
	}

	// check for medn_admin_reqd_yn
	public String fetchParamFacilityValues(String facility_id) throws Exception { //Method modified to get parameter for facility values 
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  medn_admin_reqd_yn  = "", mar_disp_held_disc_orders_yn="";
		// allow_mar_share_drug_yn="";  Removed for IN063877
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT1"));
			pstmt.setString(1,facility_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ){
				medn_admin_reqd_yn =checkForNull( resultSet.getString("MED_ADMIN_REQD_YN"));
				mar_disp_held_disc_orders_yn =checkForNull(resultSet.getString("MAR_DISP_HELD_DISC_ORDERS_YN"),"N"); ////added for [IN:043283]
				setAllowMARShareDrug(checkForNull(resultSet.getString("ALLOW_MAR_SHARE_DRUG_YN"),"N")); //added for HSA-CRF-0090 [IN:041241] 
				setAllow_auto_disp_alt_drug_mar(checkForNull(resultSet.getString("ALLOW_AUTO_DISP_ALT_DRUG_MAR"),"N"));//Added for Bru-HIMS-CRF-399 [IN:043767]
				setEarlyOrLateAdminYn(checkForNull(resultSet.getString("EARLY_OR_LATE_ADMIN_YN"),"N")); // Added for GHL-CRF-0482
				setWardAckMarRequiredYn(checkForNull(resultSet.getString("WARD_ACK_MAR_REQUIRED_YN"),"N")); // Added for MMS-KH-CRF-0014 [IN:067953]
				setverfreqdbefmedAdmin(checkForNull(resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN"),"N")); // Added for MMS-KH-SCF-0056
				
			}
			setMednAdminReqdYN(medn_admin_reqd_yn); 
			setMarDispHeldDiscOrdersYN(mar_disp_held_disc_orders_yn); ////added for [IN:043283]

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			pstmt		= connection.prepareStatement( "SELECT CRIT_FIELD_ID, CRIT_FIELD_VAL  FROM PH_DISP_MEDN_DFLT WHERE FACILITY_ID = DECODE (?, FACILITY_ID, FACILITY_ID, '*A')   AND CRIT_FIELD_ID IN(  'TOTALTAPERQTY', 'MAR_SKIP_PAT_BUTN_DISP', 'MAR_ADMIN_DTL_CONT_NORC_MAND') ") ;
			pstmt.setString(1,login_facility_id.trim());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null){
				while( resultSet.next()){
					if(resultSet.getString("CRIT_FIELD_ID").equals("TOTALTAPERQTY"))
						setTotalTaperQtyDisplay(checkForNull(resultSet.getString("CRIT_FIELD_VAL"),"N"));
					else if(resultSet.getString("CRIT_FIELD_ID").equals("MAR_SKIP_PAT_BUTN_DISP")) //Added for  SKR-SCF-1033 [IN:051790] 
						setMARSkipPatButnDisp(checkForNull(resultSet.getString("CRIT_FIELD_VAL"),"Y"));
					else if(resultSet.getString("CRIT_FIELD_ID").equals("MAR_ADMIN_DTL_CONT_NORC_MAND")) //Added for  SKR-SCF-1033 [IN:051790] 
						setMar_Admin_Dtl_Cont_Norc_Mand(checkForNull(resultSet.getString("CRIT_FIELD_VAL"),"N"));
				}
			}
		}
		catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return medn_admin_reqd_yn;
	}	
	public String chkAllowmedadminwoordyn(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  allow_med_admin_wo_ord_yn = "";
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT1A"));
			pstmt.setString(1,facility_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ){
				allow_med_admin_wo_ord_yn =(String) resultSet.getString("ALLOW_MED_ADMIN_WO_ORD_YN")==null ? "N":resultSet.getString("ALLOW_MED_ADMIN_WO_ORD_YN");
			}
		}
		catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return allow_med_admin_wo_ord_yn;
	}	
	public HashMap populateNursingUnit(String facility_id,String user_id,String called_from){
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		HashMap  NursingUnitValues  = new HashMap();
		ArrayList nursing_unit_code	= new ArrayList();
		ArrayList nursing_unit_desc	= new ArrayList();
		locale = getLanguageId()==null?"en":getLanguageId();
		try{
			connection	= getConnection();
			if(called_from!=null && called_from.equals("PH")){
				pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT2")+"?");
			}else{
				pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT2A"));
			}
			pstmt.setString(1,facility_id);
			pstmt.setString(2,user_id);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,locale);
			resultSet	= pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() ){
				if(called_from!=null && called_from.equals("PH")){
					 nursing_unit_code.add((String) resultSet.getString("NURSING_UNIT_CODE"));
					 nursing_unit_desc.add((String) resultSet.getString("SHORT_DESC"));
				}else{
					 nursing_unit_code.add((String) resultSet.getString("CLINIC_CODE"));
					 nursing_unit_desc.add((String) resultSet.getString("SHORT_DESC"));
				}
			}
		}catch ( Exception e )	{
			 nursing_unit_code.add(e.toString());
			System.err.println( "Error in ePH@Medication@populateNursingUnit : " ) ;
			e.printStackTrace() ;
		} finally {
		  try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}catch(Exception es){nursing_unit_code.add(es.toString());
			System.err.println( "Error in ePH@Medication@populateNursingUnit : " ) ;
			es.printStackTrace() ;}
		}
		NursingUnitValues.put("code",(ArrayList)nursing_unit_code);
		NursingUnitValues.put("desc",(ArrayList)nursing_unit_desc);
		return NursingUnitValues;
	}

	public HashMap getdateValues(){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		HashMap dateValues			= new HashMap();
		locale = getLanguageId();
		String sys_date="", back_date="";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT3");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date	= (String)resultSet.getString("SYS_DATE");
				back_date	= (String)resultSet.getString("BACK_DATE_TIME");
				if(!locale.equals("en")){
					sys_date	= com.ehis.util.DateUtils.convertDate(sys_date, "DMY","en",locale);
					back_date	= com.ehis.util.DateUtils.convertDate(back_date, "DMY","en",locale);
				}
				dateValues.put("sys_date",sys_date);
				dateValues.put("back_date",back_date);
			}
		}
		catch ( Exception e ) {
			dateValues.put("error",toString());
			System.err.println( "Error ePH@Medication@sys_date  :"+e ) ;
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				dateValues.put("error",toString());
				System.err.println( "Error ePH@Medication@sys_date  :"+es ) ;
				es.printStackTrace() ;
			}
		}
		return dateValues;
	}
	public ArrayList populatePatientBedDetails(String facil_id,String admin_date,String nursing_unit_code){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		ArrayList patientDetails	= new ArrayList();		
		try{
			connection				= getConnection() ;
//this Parameters for this SQL are not correct, may this SQL has changed......
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT4");
			pstmt					= connection.prepareStatement(str_qry) ;
			pstmt.setString(1,facil_id);
			pstmt.setString(2,admin_date);
			pstmt.setString(3,nursing_unit_code);
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				HashMap patientBedDetails	= new HashMap();	
				patientBedDetails.put("ENCOUNTER_ID",(String)resultSet.getString("ENCOUNTER_ID"));
				patientBedDetails.put("ASSIGN_BED_NUM",(String)resultSet.getString("ASSIGN_BED_NUM"));
				patientBedDetails.put("PATIENT_NAME",(String)resultSet.getString("PATIENT_NAME"));						
				patientBedDetails.put("PATIENT_ID",(String)resultSet.getString("PATIENT_ID"));
				patientDetails.add(patientBedDetails);
			}
		}catch ( Exception e ) {
			System.err.println( "Error ePH@Medication@populatePatientBedDetails  :"+e ) ;
			e.printStackTrace() ;
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){System.err.println( "Error ePH@Medication@populatePatientBedDetails  :"+es ) ;
			es.printStackTrace() ;}
		}
		return patientDetails;
	}

	public String getPatientLine(String patient_id){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String patientLine			= "";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT2");
			pstmt					= connection.prepareStatement(str_qry) ;
			pstmt.setString(1,patient_id);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				patientLine+=(String)resultSet.getString("PATIENT_NAME");
				patientLine+="  ,"+(String)resultSet.getString("AGE");
				patientLine+="  ,"+(String)resultSet.getString("GENDER");
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error ePH@Medication@getPatientLine  :"+e ) ;
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				System.err.println( "Error ePH@Medication@getPatientLine  :"+es ) ;
				es.printStackTrace() ;
			}
		}
		return patientLine;
	}
	public HashMap populateScheduleDetails(String facil_id,String encounter_id,String admin_date,String administration_status,String hold_discontinue_yn,String admin_from_date,String admin_to_date,String from_time,String to_time,String compare_date){
		Connection connection       = null ;
		CallableStatement cstmt     = null ;
		ResultSet resultSet         = null ;
		HashMap scheduleDetails		= new HashMap();
		try{
			connection				= getConnection() ;
			cstmt=connection.prepareCall("{call Ph_Medn_Admin_Timingsnew(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, facil_id);
			cstmt.setString( 2, encounter_id);
			cstmt.setString( 3, administration_status); 
			cstmt.setString( 4, hold_discontinue_yn);
			cstmt.registerOutParameter(5, Types.INTEGER );
			cstmt.registerOutParameter(6, Types.VARCHAR );
			cstmt.registerOutParameter(7, Types.VARCHAR );
			cstmt.registerOutParameter(8, Types.VARCHAR );
			cstmt.registerOutParameter(9, Types.VARCHAR );
			cstmt.registerOutParameter(10,Types.VARCHAR );
			cstmt.registerOutParameter(11,Types.VARCHAR );
			cstmt.setString( 12, admin_from_date);
			cstmt.setString( 13, admin_to_date);
			cstmt.setString( 14, from_time);
			cstmt.setString( 15, to_time);
			cstmt.setString( 16, compare_date);
						
			cstmt.execute() ;
			scheduleDetails.put("COL_COUNT",cstmt.getString( 5 ));
			scheduleDetails.put("COL_TIMINGS",cstmt.getString( 6 ));
			scheduleDetails.put("DIS_YN",cstmt.getString( 7 ));
			scheduleDetails.put("HOLD_YN",cstmt.getString( 8 ));
			scheduleDetails.put("NO_DATE",cstmt.getString( 9));
			scheduleDetails.put("DATE_DETAILS",cstmt.getString( 10));
			scheduleDetails.put("SCH_DETAILS",cstmt.getString( 11 ));
			DrugAdminDetails.add(scheduleDetails);		
		}catch ( Exception e ) {
			scheduleDetails.put("ERROR",e);

			e.printStackTrace() ;
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}catch(Exception es){scheduleDetails.put("ERROR",es);

			es.printStackTrace() ;}
		}

		return scheduleDetails;
	}
	public HashMap populateRoute(String form_code){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		HashMap Routedetails		= new HashMap();
		ArrayList route_code		= new ArrayList();
		ArrayList route_desc		= new ArrayList();
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT10");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,form_code);
			resultSet			= pstmt.executeQuery();		
			while(resultSet!=null && resultSet.next()){
				route_code.add(resultSet.getString("ROUTE_CODE"));
				route_desc.add(resultSet.getString("ROUTE_DESC"));
			}
			Routedetails.put("route_code",route_code);
			Routedetails.put("route_desc",route_desc);
		 }catch ( Exception e ) {
			System.err.println( "Error MedicationAdminstration@RoutePopulation :"+e ) ;
			e.printStackTrace() ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){System.err.println( "Error MedicationAdminstration@RoutePopulation :"+es ) ;
			es.printStackTrace() ;}
		}
		return Routedetails;
	}
	public String getFormCode(String drug_code){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		String form_code			= "";
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT11");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drug_code);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				form_code = (String) resultSet.getString("FORM_CODE");
			}
		}catch ( Exception e ) {
			System.err.println( "Error MedicationAdminstration@form_code :"+e ) ;
			e.printStackTrace() ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){System.err.println( "Error MedicationAdminstration@form_code :"+es ) ;
			es.printStackTrace() ;}
		}
		return form_code;
	}
	public HashMap populateFrequencyValues(){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		HashMap frequency			= new HashMap();
		ArrayList FreqCode			= new ArrayList();
		ArrayList FreqDesc			= new ArrayList();
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT12");
			pstmt				= null;
			resultSet			= null;
			pstmt				= connection.prepareStatement(sql_query) ;
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				FreqCode.add(resultSet.getString("FREQ_CODE"));
				FreqDesc.add(resultSet.getString("FREQ_DESC"));
			}
			frequency.put("FreqCode",FreqCode);
			frequency.put("FreqDesc",FreqDesc);
		 }catch ( Exception e ) {
			frequency.put("error",e);
			System.err.println( "Error MedicationAdminstration@frequency  :"+e ) ;
			e.printStackTrace() ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){frequency.put("error",es);
			System.err.println( "Error MedicationAdminstration@frequency  :"+es ) ;
			es.printStackTrace() ;}
	  }
	  return frequency;
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
			
		}catch ( Exception e ) {
			System.err.println( e ) ;
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
				}catch(Exception es){System.err.println( es ) ;
			es.printStackTrace() ;			}
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
			System.err.println( e ) ;
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
					adrDtl.put("AGNST_SCHD",checkForNull(resultSet.getString("AGAINST_SCHDOSE_DATE_TIME")));
					adrDtl.put("ADR_REASON",checkForNull(resultSet.getString("ADR_REASON_CODE")));
					adrDtl.put("ADR_REMARKS",checkForNull(resultSet.getString("ADR_REMARKS")));
					adrDtl.put("ADR_RECORDED",checkForNull(resultSet.getString("ADR_RECORDED_DATE_TIME")));
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
		}else{
			adr_recs.add("");
			adr_recs.add("");
			adr_recs.add("");
			adr_recs.add("");
			adr_recs.add("");
		}		
		return adr_recs;
	}



	public Hashtable loadQtyDetails(String form_code){

		Hashtable	qty_values  = new Hashtable();
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
			pstmt.setString(2,form_code);
			pstmt.setString(3,form_code);
			pstmt.setString(4,form_code);
			pstmt.setString(5,form_code);
			pstmt.setString(6,form_code);
			pstmt.setString(7,form_code);
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				uom_code	=	resultSet.getString("UOM_CODE");
				uom_desc	=	resultSet.getString("SHORT_DESC");
				dflt_uom_yn =	resultSet.getString("qty_uom_yn");
				if(dflt_uom_yn.equals("Y")){
					qty_values.put("dflt_code",uom_code);
				}
				qty_values.put(uom_code,uom_desc);
			}
		}catch(Exception e){
			qty_values.put("Exception",e.toString());
		}
		 finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){ 
				qty_values.put("Exception",es.toString());
			}
		}
		return qty_values;
	}
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
				sys_date=resultSet.getString(1);
				sys_date_with_out_time	= resultSet.getString("SYS_DATE");
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
		return sys_date;
	}

	public String getSysDateWithoutTime(){
		return this.sys_date_with_out_time;
	}

	public boolean validateExpiry(String expiry_date){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		boolean is_expired			= false;
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT13")) ;
			pstmt.setString(1,expiry_date);
			pstmt.setString(2,sys_date_with_out_time);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				if(resultSet.getInt("NUM")<0){
					is_expired = true;
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
		return is_expired;

	}
	public String validateAdminDate(String admin_date,String facility_id){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String allowable			= "";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT12");
			pstmt					= connection.prepareStatement(str_qry) ;
			pstmt.setString(1,admin_date);
			pstmt.setString(2,facility_id);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				allowable=resultSet.getString(1);
			}
		}
		catch ( Exception e ) {
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
		return allowable;
	}


	public void setReasonCodes(){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		reason_codes				= new HashMap();
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_REASON_CODES")) ;
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				reason_codes.put(resultSet.getString("REASON_CODE"),resultSet.getString("REASON_DESC"));
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
	}
	
	public void setAdimnReasonCodes(){//added for mms-kh-crf-0010
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		reason_codes1				= new HashMap();//ADDED FOR MMS-KH-CRF-0010
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement("SELECT REASON_CODE, REASON_DESC FROM PH_MEDN_TRN_REASON WHERE APPL_TRN_TYPE='MR' AND EFF_STATUS='E'") ;
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				reason_codes1.put(resultSet.getString("REASON_CODE"),resultSet.getString("REASON_DESC"));
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
	}
	
	public HashMap getReasonCodes(){
		return this.reason_codes;
	}
	public HashMap getAdimnReasonCodes(){//added for mms-kh-crf-0010
		return this.reason_codes1;
	}
	
	

	public void setAll( Hashtable recordSet ) {
		this.mode =(String)recordSet.get("mode");
	}
	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in insert.." ) ;
		map.put( "flag", "0" ) ;				
//		MedicationAdministrationFTHome   home=null;
//		MedicationAdministrationFTRemote remote=null;
		locale = getLanguageId()==null?"en":getLanguageId();
		try{
			HashMap commonValues = new HashMap();
			commonValues.put("facility_id",login_facility_id);
			commonValues.put("encounter_id",encounter_id);
			commonValues.put("assign_bed_num",bed_no);
			commonValues.put("nursing_unit",nursing_unit);
			commonValues.put("patient_id",patient_id);
			commonValues.put("admin_by",login_by_id);
			commonValues.put("added_by",login_by_id);
			commonValues.put("ws_no",login_at_ws_no);
			commonValues.put("admin_mode","MS");

/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_MEDICATION_ADMINISTRATION_FT") ) ;

			home  = (MedicationAdministrationFTHome) PortableRemoteObject.narrow( object, MedicationAdministrationFTHome.class ) ;
			remote = home.create() ; */

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "NON_IV_DRUGS", NONIVDrugDetails );
			tabData.put( "ALTERNATE_DRUGS", ALTDrugDetails );
			tabData.put( "NEW_NON_IV_DRUGS", NEWNONIVDrugDetails );
			tabData.put( "COMMON_VALUES",  commonValues);
			tabData.put( "IV_DRUGS",  IVDrugDetails);
			tabData.put( "TIME_DETAILS",getselDrugCodes());
			tabData.put( "DISP_DTLS",getDispDtls());

			tabData.put( "ADR_VALUES",  this.adrDetails);
			tabData.put( "ADR_REASON",  this.adrReason);
			tabData.put( "ADR_ALL_VALUES",  this.all_dtls);
			tabData.put( "language_id", locale);
			
			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_MEDN_ADMIN_FT_UPDATE",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_FT_UPDATE"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_DTL_FT_INSERT",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_DTL_FT_INSERT"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE"));
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
			sqlMap.put("SQL_PH_MEDN_ADMIN_FT_INSERT1",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_FT_INSERT1"));
			sqlMap.put("SQL_PH_MED_ADMIN_FT_SELECT17",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT17"));
			sqlMap.put("SQL_PH_MED_ADMIN_FT_SELECT18",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT18"));
			sqlMap.put("SQL_PH_MED_ADMIN_FT_SELECT19",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT19"));

			sqlMap.put("SQL_PH_MEDN_ADMIN_FT_INSERT2",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_FT_INSERT2"));	
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT86",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT86"));	
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT1",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT1"));	
			sqlMap.put("SQL_PH_MED_ADMIN_FT_SELECT27",PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT27"));	
		
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_MEDICATION_ADMINISTRATION_FT" ),MedicationAdministrationFTHome.class,getLocalEJB());

			Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] =new Object[2];
			argArray[0]= tabData;
			argArray[1]=sqlMap;

			Class  paramArray[] = new Class[2];
			paramArray[0]= tabData.getClass();
			paramArray[1] = sqlMap.getClass();

			HashMap  result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put( "result", new Boolean( true ) ) ;		
				map.put( "message", getMessage((String) result.get( "msgid" )) ) ;
				map.put("flag","0");
			}
			else{				
				map.put( "result", new Boolean( false ) ) ;		
				map.put( "message", result.get("msgid") ) ;
				map.put("flag","0");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	public String getReasonDesc(String trn_type,String reason_code){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	result		    =	"";
		locale = getLanguageId()==null?"en":getLanguageId();

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT4") ) ;
			pstmt.setString(1,trn_type);
			pstmt.setString(2,reason_code);
			pstmt.setString(3,locale);
		
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				result = resultSet.getString("REASON_DESC");
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
			System.err.println( "Error  :"+es ) ;
			es.printStackTrace() ;}
		}
		return result;	
	}

	public ArrayList loadCodes(String trn_check) throws Exception{

	   	Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String reason_code		=	"";
		String reason_desc		=	"";
//		String sys_date			=	"";
		ArrayList codeList		=	new ArrayList();
		locale = getLanguageId()==null?"en":getLanguageId();
		
		try {

            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_IP_FILL_REMARKS_SELECT6A")) ;
			pstmt.setString(1,trn_check);
			pstmt.setString(2,locale);
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
			reason_code		=	resultSet.getString("REASON_CODE");
			reason_desc		=	resultSet.getString("REASON_DESC");
			codeList.add(reason_code);
			codeList.add(reason_desc);
			}

			

		}catch ( Exception e ) {
			System.err.println( e ) ;
			e.printStackTrace() ;
			
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		
		return codeList;
	}

	public boolean compareDates(String from_date_time,String to_date_time) throws Exception{
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		boolean	 is_less		  = false;
		if(!locale.equals("en")){      // Added for RollForwarded from SRR - SRR20056-SCF-9369 [IN057079]
			from_date_time = com.ehis.util.DateUtils.convertDate(from_date_time, "DMYHM",locale,"en");
			to_date_time = com.ehis.util.DateUtils.convertDate(to_date_time, "DMYHM",locale,"en");
	    }
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MEDICATION_COMPARE_DATES_A")) ;
			pstmt.setString(1,from_date_time);
			pstmt.setString(2,to_date_time);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				if(resultSet.getInt("DATEVALUE")==1){
					is_less =true;
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
		return is_less;
	}


	public boolean validateDateAgainstAdminDate(String date_time,String admin_from_date_time,String admin_to_date_time) throws Exception{
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		boolean	 result		      = false;
		try {
            connection	= getConnection() ;
			if(!locale.equals("en")){ // if block added for LEAP-INT-PH-SCF-14965 [IN:004059]
				date_time =com.ehis.util.DateUtils.convertDate(date_time,"DMYHM",locale,"en");
				admin_from_date_time =com.ehis.util.DateUtils.convertDate(admin_from_date_time,"DMYHM",locale,"en");
				admin_to_date_time =com.ehis.util.DateUtils.convertDate(admin_to_date_time,"DMYHM",locale,"en");
			}
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MEDICATION_COMPARE_DATES_B")) ;
			pstmt.setString(1,date_time);
			pstmt.setString(2,admin_from_date_time);
			pstmt.setString(3,admin_to_date_time);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				if(resultSet.getInt("COUNT")>0){
					result =true;
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
		}
		catch(Exception e){
			pat_txt_length	=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){	
				pat_txt_length	=es.toString();
			}
		}
		return pat_txt_length;	
	}

	public ArrayList getRecord(String encounter_id,String from_time,String to_time){
	    String to_date1=to_time;
		String from_date1=from_time;
		String id=encounter_id;
		Connection connection 		= null;
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;
		PreparedStatement pstmt3 	= null;
		PreparedStatement pstmt4 	= null;
		PreparedStatement pstmt5    = null;
		PreparedStatement pstmt6    = null;
		ResultSet resultSet1 		= null;
		ResultSet resultSet2 		= null;
		ResultSet resultSet3 		= null;
		ResultSet resultSet4 		= null;
		ResultSet resultSet5 		= null;
		ResultSet resultSet6 		= null;
		String te_date="";
		String temp_drug_code="";
		String temp_drug_strength="";
		String temp_drug_desc="";
		String order_id="";
		String tt_time="";
		String tt_qty="";
		String t_date="";
		String query1="";
		String query2="";
		String query3="";
		String query4="";
		String query5="";
		String query6="";
		String admin_recorded_yn="";
		String admin_recorded_date_time="";
		String administered_yn="";
		String administered_yn1="";
		String admin_recorded_yn1="";
		String admin_date_time="";
		String admin_not_recorded_flag="N";
		String admin_due_flag="N";
		String adr_remarks="";
		String adr_recorded_date_time="";
		String adr_recorded_by="";
        String adr_reson_code=" ";
		String adr_detail_flag="N";
		String pract_type="";
		String added_by_id="";
		String order_id1="";
		String drug_class="";
		String order_line_num="";
		String order_line_num1="";
		String dr_code="";
		String temp_order_id="";
		String time_temp="";
		String times="";
		String freq_nature = "";
		int r=0;
		HashMap hm1=null;
		HashMap hm2=null;
		HashMap hm3=null;
		ArrayList patient_details = new ArrayList();
		ArrayList al_times=null;
		ArrayList al1 = null;
		ArrayList al2 = null;
		ArrayList temp_al=null;
		ArrayList dates=new ArrayList();
		String dosage_seq_no=""; //Added for PMG2014-CRF-0026 [IN:052701]
 		try{
			connection	= getConnection();
			query1=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT20")+" and sch_date_time  BETWEEN TO_DATE(?,'dd/mm/yyyy HH24:MI')  AND TO_DATE(?,'dd/mm/yyyy HH24:MI') order by sch_date";
			pstmt1		= connection.prepareStatement(query1); 
			pstmt1.setString(1,id);
			pstmt1.setString(2,from_date1);
			pstmt1.setString(3,to_date1);
			resultSet1	= pstmt1.executeQuery() ;
			while( resultSet1 != null && resultSet1.next() ){  
				te_date=resultSet1.getString(1);
				dates.add(te_date);
			}
			closeResultSet(resultSet1);
			// declaration stmts starts here
			query2	=	PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT21A");
			pstmt2	= connection.prepareStatement(query2);

			query3=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT22A");
			pstmt3		= connection.prepareStatement(query3); 
			
			query4=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT23")+"and encounter_id=?";
			pstmt4 = connection.prepareStatement(query4); 

			query6=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT14");
			pstmt6		= connection.prepareStatement(query6);
			query5=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT25");
			pstmt5		= connection.prepareStatement(query5);
			// declaration stmts ends here
			for(int i=0;i<dates.size();i++){
				te_date=(String)dates.get(i);
				pstmt2.setString( 1,te_date );
				pstmt2.setString(2,id);
				resultSet2	= pstmt2.executeQuery();
				al_times=new ArrayList();
				time_temp="";
				while( resultSet2 != null && resultSet2.next() ){
					times=(String)resultSet2.getString(1);
					freq_nature=checkForNull((String)resultSet2.getString("FREQ_NATURE"), "");
					if(!times.equals(time_temp) || freq_nature.equals("P")){ 
						  time_temp=times;
						  al_times.add(times);
					}
					else{
						continue;
					}
				}
				
				hm3=new HashMap();
				hm3.put("dates",te_date);
				hm3.put("times",al_times);
				pstmt3.setString( 1, te_date);
				pstmt3.setString(2,id);
				resultSet3	= pstmt3.executeQuery();
				al2=new ArrayList();
				temp_order_id="";
				dr_code="";
				while( resultSet3 != null && resultSet3.next() ){
					order_id1="";
					hm2=new HashMap();
					temp_drug_code=(String)resultSet3.getString(1);
					temp_drug_strength=(String)resultSet3.getString(2);
					temp_drug_desc=(String)resultSet3.getString(3);
					order_id1=(String)resultSet3.getString(4);
					drug_class=(String)resultSet3.getString(6);
					administered_yn1=checkForNull((String)resultSet3.getString(7),"");
					admin_recorded_yn1=checkForNull((String)resultSet3.getString(8),"");
					order_line_num1=checkForNull((String)resultSet3.getString(10), "");
					if((temp_order_id.equals(order_id1)) && (temp_drug_code.equals(dr_code)))
						continue;
					temp_order_id=order_id1;
					dr_code=temp_drug_code;
					hm2.put("drug_code",temp_drug_code);
					hm2.put("drug_desc",temp_drug_desc);
					hm2.put("order_id",order_id1);
					hm2.put("drug_strength",temp_drug_strength);
					hm2.put("drug_class",drug_class);
					hm2.put("administered_yn",administered_yn1);
					hm2.put("admin_recorded_yn",admin_recorded_yn1);
					hm2.put("order_line_num",order_line_num1);
					
					pstmt4.setString( 1,temp_drug_code);
					pstmt4.setString( 2,te_date); 
					pstmt4.setString( 3,order_id1); 
					pstmt4.setString( 4,id);
					resultSet4	= pstmt4.executeQuery();
					al1=new ArrayList();
					while( resultSet4 != null && resultSet4.next() ){
						tt_time=resultSet4.getString(1);
						tt_qty=resultSet4.getString(2);
						admin_recorded_yn=checkForNull(resultSet4.getString(3), "");
						admin_recorded_date_time=checkForNull(resultSet4.getString(4), "");
						administered_yn=checkForNull(resultSet4.getString(5), "");
						order_id=resultSet4.getString(6);
						adr_detail_flag="N";

						adr_remarks=checkForNull(resultSet4.getString(7),"");
						adr_recorded_date_time=checkForNull(resultSet4.getString(8),"");
						adr_recorded_by=checkForNull(resultSet4.getString(9),"");
						adr_reson_code=checkForNull(resultSet4.getString(10),"");
						added_by_id=checkForNull(resultSet4.getString(11),"");
						order_line_num=resultSet4.getString(12);
						dosage_seq_no=checkForNull(resultSet4.getString("DOSAGE_SEQ_NO"),""); //Added for PMG2014-CRF-0026 [IN:052701]
						
						pstmt6.setString( 1,added_by_id);
						resultSet6	= pstmt6.executeQuery();
						pract_type="";
						while( resultSet6 != null && resultSet6.next() ){
							 pract_type=resultSet6.getString(1);
						}
						
						if(adr_remarks != null && adr_recorded_date_time != null && adr_recorded_by != null)
							adr_detail_flag="Y";
						else
							adr_detail_flag="N";

						t_date="";
						admin_date_time=te_date;
						t_date=admin_date_time+" "+tt_time;
						
						pstmt5.setString( 1,t_date );
						resultSet5	= pstmt5.executeQuery();
						r=0;
						admin_due_flag="N";
						admin_not_recorded_flag="N";
						while( resultSet5 != null && resultSet5.next() ){
							 r=resultSet5.getInt(1);
						}
						if( r >= 1)
							admin_due_flag="N";
						else
							admin_due_flag="Y";
						
						if(admin_due_flag.equals("N") && !administered_yn.equals("Y") && !admin_recorded_yn.equals("Y"))
							admin_not_recorded_flag="Y";
						else
							admin_not_recorded_flag="N";
													
						hm1=new HashMap();
						hm1.put("time",tt_time);
						hm1.put("qty",tt_qty);
						hm1.put("admin_recorded_yn",admin_recorded_yn);
						hm1.put("admin_recorded_date_time",admin_recorded_date_time);
						hm1.put("administered_yn",administered_yn);
						hm1.put("admin_date_time",admin_date_time);
						hm1.put("order_id",order_id);
						hm1.put("admin_due_flag",admin_due_flag);
						hm1.put("admin_not_recorded_flag",admin_not_recorded_flag);
						hm1.put("adr_detail_flag",adr_detail_flag);
						hm1.put("adr_remarks",adr_remarks);
						hm1.put("adr_recorded_date_time",adr_recorded_date_time);
						hm1.put("adr_recorded_by",adr_recorded_by);
						hm1.put("adr_reson_code",adr_reson_code);
						hm1.put("pract_type",pract_type);
						hm1.put("order_line_num",order_line_num);
						hm1.put("DOSAGE_SEQ_NO",dosage_seq_no); //Added for PMG2014-CRF-0026 [IN:052701]
						al1.add(hm1);
					}
					temp_al=new ArrayList();
					temp_al=reformat(al_times,al1);
					hm2.put("qty",temp_al);
					al2.add(hm2);
				}	
				hm3.put("desc_qty",al2);
				patient_details.add(hm3);
			}
			closeResultSet(resultSet2);
			closeResultSet(resultSet3) ;
			closeResultSet(resultSet4);
			closeResultSet(resultSet5);
			closeResultSet(resultSet6);
		}
		catch ( Exception e )	{
			patient_details.add(e.toString());
			e.printStackTrace() ;
		}
		finally {
			try{
				closeStatement(pstmt1);
				closeStatement(pstmt2);
				closeStatement(pstmt3);
				closeStatement(pstmt4);
				closeStatement(pstmt5);
				closeStatement(pstmt6);
				closeConnection(connection);
			}
			catch(Exception es){
				patient_details.add(es.toString());
			es.printStackTrace() ;
			}
		}
		return patient_details;
	}


	public static ArrayList reformat(ArrayList all_times,ArrayList sch_times){
		ArrayList sch_qty=new ArrayList();
		HashMap hm=new HashMap();
		HashMap hm1=null;
		String temp1="";
		String temp2="";
		String temp3="";
		String admin_recorded_yn="";
		String admin_recorded_date_time="";
		String administered_yn="";
		String admin_date_time="";
		String order_id="";
		String admin_not_recorded_flag="N";
		String admin_due_flag="N";
		String adr_detail_flag="N";
		String adr_remarks="";
		String adr_recorded_date_time="";
		String adr_recorded_by="";
		String adr_reson_code=" ";
		String pract_type="";
		String order_line_num="";
		String time="";
		String dosage_seq_no = ""; //Added for PMG2014-CRF-0026 [IN:052701]
		int sch=sch_times.size();
		int all=all_times.size();
		if(all == sch){
			for(int i=0;i<sch;i++){
				hm1=new HashMap();
				hm=(HashMap)sch_times.get(i);
				hm1.put("order_id",(String)hm.get("order_id"));
				hm1.put("admin_recorded_yn",(String)hm.get("admin_recorded_yn"));
				hm1.put("admin_recorded_date_time",(String)hm.get("admin_recorded_date_time"));
				hm1.put("administered_yn",(String)hm.get("administered_yn"));
				hm1.put("admin_date_time",(String)hm.get("admin_date_time"));
				hm1.put("f_qty",(String)hm.get("qty"));
				hm1.put("admin_due_flag",(String)hm.get("admin_due_flag"));
				hm1.put("admin_not_recorded_flag",(String)hm.get("admin_not_recorded_flag"));
				hm1.put("adr_detail_flag",(String)hm.get("adr_detail_flag"));
				hm1.put("adr_remarks",(String)hm.get("adr_remarks"));
				hm1.put("adr_recorded_date_time",(String)hm.get("adr_recorded_date_time"));
				hm1.put("adr_recorded_by",(String)hm.get("adr_recorded_by"));
				hm1.put("adr_reson_code",(String)hm.get("adr_reson_code"));
				hm1.put("pract_type",(String)hm.get(" pract_type"));
				hm1.put("order_line_num",(String)hm.get("order_line_num"));
				hm1.put("time",(String)hm.get("time"));
				hm1.put("DOSAGE_SEQ_NO",(String)hm.get("DOSAGE_SEQ_NO")); //Added for PMG2014-CRF-0026 [IN:052701]
				sch_qty.add(hm1);
			}
		}
		else{
			for(int i=0;i<all;i++){
				hm1=new HashMap();
				temp1=(String)all_times.get(i);
				for(int j=0;j<sch;j++){
					hm=(HashMap)sch_times.get(j);
					temp2=(String)hm.get("time");
									 
					if(temp2.equals(temp1)){
						temp3=(String)hm.get("qty");
						admin_recorded_yn=(String)hm.get("admin_recorded_yn");
						admin_recorded_date_time=(String)hm.get("admin_recorded_date_time");
						administered_yn=(String)hm.get("administered_yn");
						admin_date_time=(String)hm.get("admin_date_time");
						order_id=(String)hm.get("order_id");
						admin_due_flag=(String)hm.get("admin_due_flag");
						adr_detail_flag=(String)hm.get("adr_detail_flag");
						adr_remarks=(String)hm.get("adr_remarks");
						adr_recorded_date_time=(String)hm.get("adr_recorded_date_time");
						adr_recorded_by=(String)hm.get("adr_recorded_by");
						adr_reson_code=(String)hm.get("adr_reson_code");
						pract_type=(String)hm.get("pract_type");
						order_line_num=(String)hm.get("order_line_num");
						time=(String)hm.get("time");
						dosage_seq_no=(String)hm.get("DOSAGE_SEQ_NO"); //Added for PMG2014-CRF-0026 [IN:052701]

						break;
					}
					if(j==(sch-1) && !temp2.equals(temp1)){
						temp3="";
						admin_recorded_yn="";
						admin_recorded_date_time="";
						administered_yn="";
						admin_date_time="";
						order_id="";
						admin_not_recorded_flag="N";
						admin_due_flag="N";
						adr_detail_flag="N";
						adr_remarks="";
						adr_recorded_date_time="";
						adr_recorded_by="";
						adr_reson_code="";
						pract_type="";
						order_line_num="";
						time="";
						dosage_seq_no = ""; //Added for PMG2014-CRF-0026 [IN:052701]
					}
			    }
				hm1.put("order_id",order_id);
				hm1.put("admin_recorded_yn",admin_recorded_yn);
				hm1.put("admin_recorded_date_time",admin_recorded_date_time);
				hm1.put("administered_yn",administered_yn);
				hm1.put("admin_date_time",admin_date_time);
				hm1.put("f_qty",temp3);
				hm1.put("admin_due_flag",admin_due_flag);
				hm1.put("admin_not_recorded_flag",admin_not_recorded_flag);
				hm1.put("adr_detail_flag",adr_detail_flag);
				hm1.put("adr_remarks",adr_remarks);
				hm1.put("adr_recorded_date_time",adr_recorded_date_time);
				hm1.put("adr_recorded_by",adr_recorded_by);
				hm1.put("adr_reson_code",adr_reson_code);
				hm1.put("pract_type",pract_type);
				hm1.put("order_line_num",order_line_num);
				hm1.put("time",time);
				hm1.put("DOSAGE_SEQ_NO",dosage_seq_no); //Added for PMG2014-CRF-0026 [IN:052701]
				sch_qty.add(hm1);
			}
		}
		return sch_qty;  
	}

	public  String  callfrequency(String order_id1,String order_line_num1){
	
		Connection connection 	   = null;
		PreparedStatement pstmt 	   = null;
		ResultSet resultSet 		   = null;
		String freq_nature="";
		try{
			connection	= getConnection();
			pstmt	        = connection.prepareStatement("SELECT B.FREQ_NATURE FROM OR_ORDER_LINE A, AM_FREQUENCY B WHERE A.FREQ_CODE=B.FREQ_CODE AND A.ORDER_ID=? AND A.ORDER_LINE_NUM=?") ;
			pstmt.setString(1,order_id1);
			pstmt.setString(2,order_line_num1);
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){ 
				freq_nature=(String)resultSet.getString("FREQ_NATURE");							 
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
			es.printStackTrace() ;}
		}
		return freq_nature;
	}
	public String checkIVOrder(String order_id){
	    Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;
		String iv_prep_yn="";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT27") ) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				iv_prep_yn	= resultSet.getString(1);
				if(iv_prep_yn == null){iv_prep_yn="";}
			}						
		}
		catch(Exception e){
				iv_prep_yn=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){	
				iv_prep_yn=es.toString();
			}
		}
		return iv_prep_yn;
	}

	public String gethold_discontinue(String order_id,String order_line_num){
	    Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;
		String order_line_status="";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT28") ) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				order_line_status= resultSet.getString(1);
				if(order_line_status == null){order_line_status="";}
			}						
		}
		catch(Exception e){
			order_line_status=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){	
				order_line_status=es.toString();
			}
		}
		return order_line_status;	
	}

	public  ArrayList getBedNos(String nursing_unit_code,String facility_id){
	   Connection connection 	   = null;
	   PreparedStatement pstmt 	   = null;
	   ResultSet resultSet 		   = null;
	   ArrayList bedlist           = new ArrayList();
	   String bed_no="";
	   try{
			connection	= getConnection();
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_IP_BED__SELECT1") ) ;
			pstmt.setString(1,nursing_unit_code);
			pstmt.setString(2,facility_id);
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){ 
				bed_no=(String)resultSet.getString("BED_NO");
				bedlist.add(bed_no);
			}        
		}
		catch ( Exception e ){
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
		return bedlist;
	}

	public void setSchMARParams(){ //Added for SKR-CRF-0037 [IN:037656]
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		HashMap hmShcMARDtlsTmp= new HashMap();
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SELECT_SHC_MAR_PARAM_VALUES")) ; 
			pstmt.setString(1,login_facility_id);
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){				  
				hmShcMARDtlsTmp.put("MAR_SCH_LEVEL_YN", checkForNull(resultSet.getString("MAR_SCH_LEVEL_YN")));
				hmShcMARDtlsTmp.put("FROM_DATE", checkForNull(resultSet.getString("START_DATE")));
				hmShcMARDtlsTmp.put("TO_DATE", checkForNull(resultSet.getString("END_DATE")));
				hmShcMARDtlsTmp.put("MAR_START_IND", checkForNull(resultSet.getString("MAR_START_IND")));
				hmShcMARDtlsTmp.put("MAR_WEEK_DAY_START", checkForNull(resultSet.getString("MAR_WEEK_DAY_START")));
				hmShcMARDtlsTmp.put("MAR_PAST_DAY", checkForNull(resultSet.getString("MAR_PAST_DAY")));
				hmShcMARDtlsTmp.put("MAR_FUTURE_DAY", checkForNull(resultSet.getString("MAR_FUTURE_DAY")));
				hmShcMARDtlsTmp.put("MAR_DISC_DOSE_YN", checkForNull(resultSet.getString("MAR_DISC_DOSE_YN")));
				hmShcMARDtlsTmp.put("MAR_DEFAULT_ORDER_BY", checkForNull(resultSet.getString("MAR_DEFAULT_ORDER_BY")));
				hmShcMARDtlsTmp.put("MAR_IV_COMPL_DT_IND", checkForNull(resultSet.getString("MAR_IV_COMPL_DT_IND")));
				hmShcMARDtlsTmp.put("MONTH_START", checkForNull(resultSet.getString("MONTH_START")));
				hmShcMARDtlsTmp.put("MONTH_END", checkForNull(resultSet.getString("MONTH_END")));
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
		setSchMARParams(hmShcMARDtlsTmp);		
	}

	public ArrayList getDateDayList(String from_date, String todate, String viewBy){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList altDateDayList = new ArrayList();
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SELECT_SHC_MAR_DATE_DAY_DTLS")) ; 
			pstmt.setString(1,from_date);
			pstmt.setString(2,from_date);
			pstmt.setString(3,from_date);
			pstmt.setString(4,todate);
			pstmt.setString(5,from_date);
            resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null){
				while(resultSet.next()){		
					if(viewBy.equals("M")){
						altDateDayList.add( checkForNull(resultSet.getString("DT")).trim());
						altDateDayList.add( checkForNull(resultSet.getString("DAY_MONTH")).trim());
					}
					else{
						altDateDayList.add( checkForNull(resultSet.getString("DT")).trim());
						altDateDayList.add( checkForNull(resultSet.getString("DAY_WEEK")).trim());
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
			catch ( Exception e ) {
				e.printStackTrace() ;
			}
		}
		return altDateDayList;
	}

	public String[] getNavigateDateRange(String from_date, String todate, String viewBy, String navigation ){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String[] dateRange = new String[2];

		try {
            connection	= getConnection() ;
			if(navigation.equals("P")){
				if(viewBy.equals("M")){
					pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SELECT_NAVI_PREV_DATE_RAGE_MONTH")) ; 
					pstmt.setString(1,from_date);
					pstmt.setString(2,from_date);
				}
				else if(viewBy.equals("W")){
					pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SELECT_NAVI_PREV_DATE_RAGE_WEEK")) ; 
					pstmt.setString(1,from_date);
					pstmt.setString(2,todate);
					pstmt.setString(3,from_date);
					pstmt.setString(4,from_date);
				}
			}
			else{
				if(viewBy.equals("M")){
					pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SELECT_NAVI_NEXT_DATE_RAGE_MONTH")) ; 
					pstmt.setString(1,todate);
					pstmt.setString(2,todate);
				}
				else if(viewBy.equals("W")){
					pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SELECT_NAVI_NEXT_DATE_RAGE_WEEK")) ; 
					pstmt.setString(1,todate);
					pstmt.setString(2,todate);
					pstmt.setString(3,todate);
					pstmt.setString(4,from_date);
				}
			}
            resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null){
				while(resultSet.next()){		
					dateRange[0]= checkForNull(resultSet.getString("FROMDATE")).trim();
					dateRange[1] = checkForNull(resultSet.getString("TODATE")).trim();
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
			catch ( Exception e ) {
				e.printStackTrace() ;
			}
		}
		return dateRange;
	}

	public ArrayList loadReason(String trnType) throws Exception{
	   	Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList reason		=	new ArrayList();
		try {

            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_IP_FILL_REMARKS_SELECT6A")) ;
			pstmt.setString(1,trnType);
			pstmt.setString(2,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				reason.add(checkForNull(resultSet.getString("REASON_CODE")));
				reason.add(checkForNull(resultSet.getString("REASON_DESC")));
				reason.add(checkForNull(resultSet.getString("REMARKS")));
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
		return reason;
	}

	public HashMap updatePostAdminDetails( ){

	   	HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in insert.." ) ;
		map.put( "flag", "0" ) ;
		locale = getLanguageId()==null?"en":getLanguageId();
		//Connection connection				  = null;  Removed for IN063877
	//	PreparedStatement pstmt_update             = null ;  Removed for IN063877
		
		try{
			HashMap commonValues = new HashMap();
			commonValues.put("facility_id",login_facility_id);
			commonValues.put("admin_by",login_by_id);
			commonValues.put("added_by",login_by_id);
			commonValues.put("ws_no",login_at_ws_no);
			commonValues.put("admin_mode","POSTADMINDTLS");

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "COMMON_VALUES",  commonValues);
			tabData.put( "ADR_VALUES",  this.adrDetails);
			tabData.put( "ADR_REASON",  this.adrReason);
			tabData.put( "ADR_ALL_VALUES",  this.all_dtls);
			tabData.put( "updateADRDetails",  "Y");
		
			tabData.put( "language_id", locale);

			HashMap sqlMap = new HashMap() ;
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
		map.put("flag", "" ) ;
		return map;
	}

	public HashMap recordCouldNotAdmin( ArrayList notAdminDtls){

	   	HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in insert.." ) ;
		map.put( "flag", "0" ) ;
		locale = getLanguageId()==null?"en":getLanguageId();
	//	Connection connection				  = null;  Removed for IN063877
	//	PreparedStatement pstmt_update             = null ;  Removed for IN063877
		
		try{
			HashMap commonValues = new HashMap();
			commonValues.put("facility_id",login_facility_id);
			commonValues.put("admin_by",login_by_id);
			commonValues.put("added_by",login_by_id);
			commonValues.put("ws_no",login_at_ws_no);
			commonValues.put("admin_mode","CDNOTADMIN");

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "COMMON_VALUES",  commonValues);
			tabData.put( "NOTADMINDTLS",  notAdminDtls);
		
			tabData.put( "language_id", locale);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN_AUDIT",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN_AUDIT"));
			sqlMap.put("SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN_AUDIT_INSERT",PhRepository.getPhKeyValue("SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN_AUDIT_INSERT"));
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
		map.put("flag", "" ) ;
		return map;
	}

	public HashMap recordDiscontinue( ArrayList discontDtls){

	   	HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in insert.." ) ;
		map.put( "flag", "0" ) ;
		locale = getLanguageId()==null?"en":getLanguageId();
	//	Connection connection				  = null;  Removed for IN063877
	//	PreparedStatement pstmt_update             = null ;  Removed for IN063877
		
		try{
			HashMap commonValues = new HashMap();
			commonValues.put("facility_id",login_facility_id);
			commonValues.put("admin_by",login_by_id);
			commonValues.put("added_by",login_by_id);
			commonValues.put("ws_no",login_at_ws_no);
			commonValues.put("admin_mode","DISCONT");

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "COMMON_VALUES",  commonValues);
			tabData.put( "DISCONT_DETAILS",  discontDtls);
		
			tabData.put( "language_id", locale);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_ORDER_LINE_UPDATE_DISCONT",PhRepository.getPhKeyValue("SQL_PH_ORDER_LINE_UPDATE_DISCONT"));
			sqlMap.put("SQL_PH_PATIENT_DRUG_PROFILE_UPDATE_DISCONT",PhRepository.getPhKeyValue("SQL_PH_PATIENT_DRUG_PROFILE_UPDATE_DISCONT"));
			
			sqlMap.put("SQL_PH_ORDER_UPDATE_DISCONT",PhRepository.getPhKeyValue("SQL_PH_ORDER_UPDATE_DISCONT"));//Added for SKR-SCF-0902 [IN:044632] Starts
			sqlMap.put("SQL_OR_ORDER_STATUS_SELECT",PhRepository.getPhKeyValue("SQL_OR_ORDER_STATUS_SELECT"));
			sqlMap.put("SQL_PH_ORDER_UPDATE_HDR",PhRepository.getPhKeyValue("SQL_PH_ORDER_UPDATE_HDR"));//Added for SKR-SCF-0902 [IN:044632] Ends
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
		map.put("flag", "" ) ;
		return map;
	}

	public HashMap recordHold( ArrayList holdDetails){
	   	HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in insert.." ) ;
		map.put( "flag", "0" ) ;
		locale = getLanguageId()==null?"en":getLanguageId();
		//Connection connection				  = null; //Commented for common-icn-0048
		//PreparedStatement pstmt_update             = null ; //Commented for common-icn-0048
		
		try{
			HashMap commonValues = new HashMap();
			commonValues.put("facility_id",login_facility_id);
			commonValues.put("admin_by",login_by_id);
			commonValues.put("added_by",login_by_id);
			commonValues.put("ws_no",login_at_ws_no);
			commonValues.put("admin_mode","HOLD");

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "COMMON_VALUES",  commonValues);
			tabData.put( "HOLD_DETAILS",  holdDetails);
		
			tabData.put( "language_id", locale);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_ORDER_LINE_UPDATE_HOLD",PhRepository.getPhKeyValue("SQL_PH_ORDER_LINE_UPDATE_HOLD"));
			sqlMap.put("SQL_PH_PATIENT_DRUG_PROFILE_UPDATE_HOLD",PhRepository.getPhKeyValue("SQL_PH_PATIENT_DRUG_PROFILE_UPDATE_HOLD"));
			//SKR-SCF-0840 Starts
			sqlMap.put("SQL_PH_ORDER_UPDATE_DISCONT",PhRepository.getPhKeyValue("SQL_PH_ORDER_UPDATE_DISCONT"));
			sqlMap.put("SQL_OR_ORDER_STATUS_SELECT",PhRepository.getPhKeyValue("SQL_OR_ORDER_STATUS_SELECT"));
			sqlMap.put("SQL_PH_ORDER_UPDATE_HDR",PhRepository.getPhKeyValue("SQL_PH_ORDER_UPDATE_HDR"));
			sqlMap.put("SQL_PH_UPDATE_PREV_ORDER_STATUS",PhRepository.getPhKeyValue("SQL_PH_UPDATE_PREV_ORDER_STATUS"));
			//SKR-SCF-0840 Ends
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
		map.put("flag", "" ) ;
		return map;
	}
}