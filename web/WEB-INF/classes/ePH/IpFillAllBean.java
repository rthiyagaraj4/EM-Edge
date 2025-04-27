/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.IPFillAll.*; 

public class IpFillAllBean extends PhAdapter implements Serializable {

	private String disp_locn_code	= "";
	private String dcode1	        = "";
	private String Ipdsnyn       	= "";
	private Hashtable recordSet		= new Hashtable();
	private ArrayList ipFillList	= new ArrayList();
	private ArrayList seq_num_list	= new ArrayList();
	private HashMap	fillListDtl		= new HashMap();
	private ArrayList Records       = new ArrayList();
	private ArrayList Patientinsertlist  = new ArrayList();
	private ArrayList unalloc_druglist   = new ArrayList();
	//private ArrayList SeqInserthdrlist = new ArrayList();
	private HashMap dispuoms		= new HashMap();
	private String PrintOption       	= "";
	private String authUserId				= "";  //RUT-CRF-0035 [IN029926]
	private String userAuthPINReqYN		= "N";  //RUT-CRF-0035 [IN029926]
	private ArrayList selectedReportsIds	= new ArrayList(); //code added for SKR-SCF-0765[IN037730] 
	protected HashMap hmAltDrugRemarks		= new HashMap(); //Added for Bru-HIMS-CRF-082 [IN:029948]
	protected String alt_drug_remarks_ind = "N"; //Added for Bru-HIMS-CRF-082 [IN:029948]
	protected String disp_alt_drug_yn = "N"; //Added for MMS ADHOC 	
	private String display_dosage_details = "N"; //Added for MMS-DM-CRF-0011 [IN:055302]
	public IpFillAllBean(){
		try{
			doCommon() ;
		}
		catch(Exception e) {	
			e.printStackTrace() ;
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception{
	}

	public void clear(){
		super.clear() ;
		this.disp_locn_code	= "";
		this.fillListDtl	     = new HashMap();
		this.ipFillList		     = new ArrayList();
		this.Patientinsertlist	 = new ArrayList();
		//this.SeqInserthdrlist	 = new ArrayList();
		this.dispuoms		     = new HashMap();
		this.PrintOption="";
		if(hmAltDrugRemarks!=null)// Added For Bru-HIMS-CRF-082 [IN:029948]
			hmAltDrugRemarks.clear();
	}

	/* Function specific methods start */
	public String getPrintOption(){
		return PrintOption;
	}
	
	public void setDispAlternate(String disp_alt_drug_yn){ //Added for MMS ADHOC  -start
		this.disp_alt_drug_yn		= disp_alt_drug_yn;
	}
	public String getDispAlternate(){
		return disp_alt_drug_yn;
	} //Added for MMS ADHOC  - end
	
	public void setIpFillList(ArrayList ipFillList){
		this.ipFillList		= ipFillList;
	}
	public String getDisplayDosageDetails(){ //Added for MMS-DM-CRF-0011 [IN:055302] -start
		return this.display_dosage_details;
	} 
	public void setDisplayDosageDetails(String display_dosage_details){ 
		this.display_dosage_details = display_dosage_details;
	} ////Added for MMS-DM-CRF-0011 [IN:055302] - end
	public ArrayList getIpFillList(){
		return ipFillList;
	}
	 
    public void setPatientList(ArrayList seq_num_list){
		this.seq_num_list		= seq_num_list;
	}
	public ArrayList getPatientList(){
		return seq_num_list;
	}
	
	 public void setPatientinsertlist(ArrayList Patientinsertlist){
		this.Patientinsertlist		= Patientinsertlist;
	}
	public ArrayList getPatientinsertlist(){
		return Patientinsertlist;
	}

	/*public void setSeqInserthdrlist(ArrayList SeqInserthdrlist){
		this.SeqInserthdrlist		= SeqInserthdrlist;
	}
	public ArrayList getSeqInserthdrlist(){
		return SeqInserthdrlist;
	}*/
	  
	public void setIpseqnum(String Ipdsnyn){
		this.Ipdsnyn		= Ipdsnyn;
	}
	public String getIpseqnum(){
		return Ipdsnyn;
	}
	  
	   	
	public void setDispUoms(HashMap dispuoms){
		this.dispuoms		= dispuoms;
	}
	public HashMap getDispUoms(){
		return dispuoms;
	}
   	
	public void setFillListDtl(HashMap fill_list_dtl){
		this.fillListDtl=fill_list_dtl;
	}

	public HashMap getFillListDtl(){
		return fillListDtl;
	}
	
	public String getLoggedInFacility(){
		return login_facility_id;
	}
	public void setDispenseLocation(String dcode){
		this.disp_locn_code=dcode;
	}

	public void setDispLocation(String dcode1){
		//System.err.println("dcode1----set---->"+dcode1);
		this.dcode1=dcode1;
	}

	public String getDispLocation(){
		//System.err.println("dcode1----get---->"+dcode1);
		return this.dcode1;
	}
	/*public String getDailySeqNum(){
		return dailySeqNum;
	}
	public void setDailySeqNum(String dailySeqNum){
		this.dailySeqNum=dailySeqNum;
	}*/

	public void setUnAllocDrugList(ArrayList unalloc_druglist){
		this.unalloc_druglist		= unalloc_druglist;
	}
	public ArrayList getUnAllocDrugList(){
		return unalloc_druglist;
	}
	
	public void setCheckdRecords(ArrayList selectedRecords){
		this.Records		= selectedRecords;
		
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
//Added for Bru-HIMS-CRF-082 [IN:029948]-start
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
	public String getAltDrugRemarksInd(){ 
		return this.alt_drug_remarks_ind;
	}
	public void setAltDrugRemarksInd(String alt_drug_remarks_ind){ 
		this.alt_drug_remarks_ind = alt_drug_remarks_ind;
	}
	//Added for Bru-HIMS-CRF-082 [IN:029948]-end
	
	//RUT-CRF-0035 [IN029926] -- end
	public ArrayList getSelectedReportsIds(){/* code added for SKR-SCF-0765[IN037730] -- Start */
		return this.selectedReportsIds;
	}
	public void setSelectedReportsIds(ArrayList selectedReportsIds){
		this.selectedReportsIds=selectedReportsIds;
	}	/* code added for SKR-SCF-0765[IN037730] -- End */
	
	public int validatePharmacist() {
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		int valid				= 0;
		String practype			= null;
		try {
			connection = getConnection() ;
			//this query returns the practioner type
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PHARM_SELECT" )) ;
			pstmt.setString(1,login_by_id);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				practype=resultSet.getString("PRACT_TYPE");
				if (practype.equals("PH")){
					valid=1;
				}else {
					valid=0;
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			return 0;
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) { es.printStackTrace(); }
		}
		return valid;
	}

	public String getEndTime(String fromdate,String fillperiod,String fillperiodunit){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		String enddatetime		= "";
		try {
			connection = getConnection() ;
			//this query calculates end date on change of fill period for routine fill
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ENDTIME_SELECT" )) ;
			pstmt.setString(1,fromdate);
			pstmt.setString(2,fillperiodunit);
			pstmt.setString(3,fillperiod);
			pstmt.setString(4,fillperiod);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				enddatetime=resultSet.getString("ENDDATE");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			return "0";
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) { es.printStackTrace(); }

		}
		return enddatetime;
	}
	
	public HashMap getStartTime(String disp_locn_code,String fillperiod,String schedule_start){
		
		//String locale			= getLanguageId()==null?"en":getLanguageId();
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		HashMap result			= new HashMap();
		//boolean flag			= false;
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_SELECT36" )) ;
			/*pstmt = connection.prepareStatement("SELECT TO_CHAR(B.FILL_INT_END_DATE_TIME, 'DD/MM/YYYY HH24:MI') STARTDATE, TO_CHAR(A.FILL_INT_END_DATE_TIME,'DD/MM/YYYY HH24:MI') FILL_INT_END_DATE_TIME,TO_CHAR(A.SCHEDULE_START,'DD/MM/YYYY HH24:MI') SCHEDULE_START FROM PH_FILL_PROCESS_PARAM A, PH_LAST_FILL_INT_DTL B  WHERE A.PROC_TYPE='I'  AND A.fill_proc_id = B.LAST_FILL_PROC_ID AND B.FILL_INT_END_DATE_TIME <  A.FILL_INT_END_DATE_TIME AND B.FACILITY_ID=? AND B.FILL_INT_END_DATE_TIME>=SYSDATE") ;
			pstmt.setString(1,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			while (resultSet!=null && resultSet.next()) {
				flag			= true;
				result.put("STARTDATE",resultSet.getString("STARTDATE"));
				result.put("FILL_INT_END_DATE_TIME",resultSet.getString("FILL_INT_END_DATE_TIME"));
				result.put("SCHEDULE_START",resultSet.getString("SCHEDULE_START"));
			}
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
			    System.err.println("flag----->"+flag);
			    System.err.println("schedule_start---->"+schedule_start);
				System.err.println("schedule_start--->"+schedule_start);
				System.err.println("login_facility_id---->"+login_facility_id);
				System.err.println("disp_locn_code---->"+disp_locn_code);
				System.err.println("schedule_start--->"+schedule_start);
				System.err.println("fillperiod---->"+fillperiod);
				System.err.println("login_facility_id----->"+login_facility_id);
				System.err.println("disp_locn_code------->"+disp_locn_code); */
			//if(!flag){

				/*=================================================================================================*/
				/*======PMG20089-CRF-0675 to default the start time for Incremental IP Fill Process --23-Jan-2010-- shyampriya ====*/
				String sql ="";
				pstmt = connection.prepareStatement("SELECT DFLT_IP_FILL_INCR_START_WITH FROM PH_FACILITY_PARAM WHERE FACILITY_ID =?");
				pstmt.setString(1,login_facility_id);
				resultSet = pstmt.executeQuery() ;
				if(resultSet!=null && resultSet.next()){
					if(resultSet.getString("DFLT_IP_FILL_INCR_START_WITH").equals("S"))
						sql="SELECT ( TO_CHAR (TO_DATE (?, 'DD/MM/YYYY hh24:mi'),   'DD/MM/YYYY') || ' '|| TO_CHAR (sysdate, 'HH24:MI'))START_DATE,(SELECT    TO_CHAR (TO_DATE (?, 'DD/MM/YYYY hh24:mi'),'DD/MM/YYYY') || ' ' || TO_CHAR (ip_fill_dflt_start_time, 'HH24:MI') FROM ph_disp_locn WHERE facility_id = ? AND disp_locn_code = ?) schedule_start, (SELECT TO_CHAR(TO_DATE (?, 'DD/MM/YYYY hh24:mi') + ?, 'DD/MM/YYYY') || ' ' || TO_CHAR (ip_fill_dflt_start_time, 'HH24:MI') FROM ph_disp_locn WHERE facility_id = ? AND disp_locn_code = ?)  fill_int_end_date_time FROM DUAL";
				
					else if(resultSet.getString("DFLT_IP_FILL_INCR_START_WITH").equals("T"))
						sql = "SELECT ( TO_CHAR (TO_DATE (?, 'DD/MM/YYYY hh24:mi'),   'DD/MM/YYYY')  || ' ' || '00:01')START_DATE, (SELECT TO_CHAR (TO_DATE (?, 'DD/MM/YYYY hh24:mi'),'DD/MM/YYYY') || ' ' || TO_CHAR (ip_fill_dflt_start_time, 'HH24:MI') FROM ph_disp_locn WHERE facility_id = ? AND disp_locn_code = ?) schedule_start, (SELECT  TO_CHAR(TO_DATE (?, 'DD/MM/YYYY hh24:mi') + ?, 'DD/MM/YYYY') || ' ' || TO_CHAR (ip_fill_dflt_start_time, 'HH24:MI') FROM ph_disp_locn WHERE facility_id = ? AND disp_locn_code = ?)fill_int_end_date_time FROM DUAL";
				}

				/*=================================================================================================*/
				pstmt = connection.prepareStatement(sql) ;
			//	pstmt = connection.prepareStatement("SELECT ( TO_CHAR (TO_DATE (?, 'DD/MM/YYYY hh24:mi'),   'DD/MM/YYYY')               || ' '               || TO_CHAR (sysdate, 'HH24:MI'))START_DATE,      (SELECT    TO_CHAR (TO_DATE (?, 'DD/MM/YYYY hh24:mi'),'DD/MM/YYYY') || ' ' || TO_CHAR (ip_fill_dflt_start_time, 'HH24:MI') FROM ph_disp_locn WHERE facility_id = ? AND disp_locn_code = ?) schedule_start, (SELECT    TO_CHAR(TO_DATE (?, 'DD/MM/YYYY hh24:mi') + ?,                 'DD/MM/YYYY') || ' ' || TO_CHAR (ip_fill_dflt_start_time, 'HH24:MI') FROM ph_disp_locn WHERE facility_id = ? AND disp_locn_code = ?)                                               fill_int_end_date_time FROM DUAL") ;
				pstmt.setString(1,schedule_start);
				pstmt.setString(2,schedule_start);
				pstmt.setString(3,login_facility_id);
				pstmt.setString(4,disp_locn_code);
				pstmt.setString(5,schedule_start);
				pstmt.setString(6,fillperiod);
				pstmt.setString(7,login_facility_id);
				pstmt.setString(8,disp_locn_code);
				
				resultSet = pstmt.executeQuery() ;
				if(resultSet!=null && resultSet.next()){
					result.put("STARTDATE",resultSet.getString("START_DATE"));
					result.put("FILL_INT_END_DATE_TIME",resultSet.getString("FILL_INT_END_DATE_TIME"));
					result.put("SCHEDULE_START",resultSet.getString("SCHEDULE_START"));
				}
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
			//}
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

	public int checkDispRight() {
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		int valid				= 0;
		String practype			= null;
		try {
			connection = getConnection() ;
			//this query checks if the practioner has fill right
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHT" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.disp_locn_code);
			pstmt.setString(3,login_by_id);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				practype=resultSet.getString("FILL_YN");
				if (practype.equals("Y")) {
					valid=1;
				}
				else {
					valid=0;
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			return 0;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) { es.printStackTrace(); }
		}
		return valid;
	}

	public int allocateSetup() {
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		int valid				= 0;
		String practype			= null;
		try {
			connection = getConnection() ;
			//this query checks if the practioner has fill right
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALLOCATE_SETUP" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.disp_locn_code);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				practype=resultSet.getString("IP_FILL_ALLOCATE_BATHCES_YN");
				if ((practype!=null)&&(practype.equals("Y"))) {
					valid=1;
				}
				else {
					valid=0;
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			return 0;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) { es.printStackTrace(); }
		}
		return valid;
	}

	public ArrayList getDispenseLocation() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISPLOCN_SELECT" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,login_at_ws_no);
			pstmt.setString(3,login_by_id);
			pstmt.setString(4,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result.add(resultSet.getString("DISP_LOCN_CODE"));
				result.add(resultSet.getString("DISP_DESC"));
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
			}catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return result;
	}

	public ArrayList getOrderingFacilityId(String p_user_name) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//System.err.println("p_user_name----->"+p_user_name);
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
			}catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		//System.err.println("result--from bean--->"+result);
		return result;
	}

	public ArrayList getCurrentTime() {
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		ArrayList time          = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_CURRTIME_SELECT" )) ;
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				time.add(resultSet.getString("currenthrs"));
				time.add(resultSet.getString("currentmis"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
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
		return time;
	}

	public ArrayList getFillPeriods() {
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		PreparedStatement pstmt1= null ;
		ResultSet resultSet		= null ;
		ResultSet resultSet1	= null ;
		ArrayList facilities	= new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_FILLPERIOD_SELECT" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.disp_locn_code);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				facilities.add(resultSet.getString("IP_FILL_PRD_AHEAD"));
				facilities.add(resultSet.getString("IP_FILL_EXCL_PRD_BEHIND"));
				facilities.add(resultSet.getString("SCHEDULE_START_TIME"));
				facilities.add(resultSet.getString("CDATE"));
				facilities.add(resultSet.getString("CMONTH"));
				facilities.add(resultSet.getString("CYEAR"));
				facilities.add(resultSet.getString("CHOURS"));
				facilities.add(resultSet.getString("CMINUTES"));
				facilities.add(resultSet.getString("IP_FILL_PRD_UNIT"));
				facilities.add(resultSet.getString("IP_FILL_ALLOCATE_BATHCES_YN"));
				facilities.add(resultSet.getString("ROUTINE_START_DATE"));
				facilities.add(resultSet.getString("ROUTINE_END_DATE"));
				pstmt1		= connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_FILLPERIOD_SELECT1" )) ;
				pstmt1.setString(1,login_facility_id);
				pstmt1.setString(2,this.disp_locn_code);
				pstmt1.setString(3,resultSet.getString("SCHEDULE_START_TIME"));
				resultSet1 = pstmt1.executeQuery() ;
				if (resultSet1.next()){
					facilities.add(resultSet1.getString("INC_START_DATE"));
					facilities.add(resultSet.getString("ROUTINE_END_DATE"));
					facilities.add("Y");
				} 
				else {
					facilities.add(resultSet.getString("INC_START_DATE"));
					facilities.add(resultSet.getString("ROUTINE_END_DATE"));
					facilities.add("N");
				}
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
			}
		}
		catch ( Exception e ) {
			facilities.add(e.toString());
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return facilities;
	}

	// added by suri
 	public ArrayList getIpFillList(String fill_int_start_date_time,String fill_int_end_date_time,String Proc_Type,String intermittent,String disp_locn_code,String nursing_unit_or_locn,String compound_drug_ind,String Building_Code,String Building_Code_to,String Floor_Code,String Nursing_Unit_From, String Nursing_Unit_To, String order_by_for_list,String locale,String OrderingFacility_code,String ip_fill_excl_prd_behind,String ip_excl_intermittent_fill,String ip_prn_drugs,String ip_medical_items) throws Exception{

		Connection connection	    = null;
        PreparedStatement pstmt	    = null;
        ResultSet resultSet		    = null;
		ArrayList ip_fill_list		= new ArrayList();
		HashMap	  ip_fill_order		= new HashMap();
		StringBuffer sbSQL = new StringBuffer();//added for MMS-DM-CRF-0011 [IN:055302]
		try {
            connection	= getConnection() ;
			//pstmt		=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_DETAILS_SELECT"));
			//Modified query by naveen==IP_NURSING_UNIT.SHORT_DESC==26256
		
           // and disp_multi_strength_yn='Y' REMOVED  FOR GHL-CRF-0548  
            	 sbSQL.append(" SELECT iv_prep_yn,( e.ORDER_QTY - e.BMS_QTY) || ' ' ||PH_GET_UOM_DISPLAY(e.PERFORMING_FACILITY_ID,e.ORDER_UOM, ?) Tot_Disp_Qty, ph_display_stock_unit_all(e.PERFORMING_FACILITY_ID, ?, e.Order_id, e.ordeR_line_num, e.order_Catalog_code,?,?,?, NUll, e.start_Date_time, e.end_Date_Time, e.durn_type, e.durn_value, e.order_line_Status, e.order_qty, e.ORDER_UOM,(SELECT freq_nature FROM am_frequency WHERE freq_code = e.freq_code) , ?,?,?,?,?,?,?,?,?,e.iv_prep_yn,?,?,?,e.next_fill_date, e.fill_proc_id, e.bms_qty, e.sliding_scale_yn) Disp_qty, nvl(decode(?,'en',Mp_patient.patient_Name,Mp_patient.PATIENT_NAME_LOC_LANG),Mp_patient.patient_Name) patient_Name ,Get_Age(Mp_patient.date_of_birth) date_of_birth ,Mp_patient.sex,Mp_patient.patient_id, ip_open_encounter.BED_NUM Patient_Details, e.order_Catalog_code order_Catalog_code,g.DRUG_DESC Drug_Name , e.ORDER_QTY, e.ORDER_UOM, e.ORDER_ID, IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE SOURCE_CODE, ORDERING_FACILITY_ID, TO_CHAR(e.ORD_DATE_TIME, 'DD/MM/YYYY HH24:MI') ORD_DATE_TIME, MP_PATIENT.PATIENT_ID, e.ENCOUNTER_ID, e.ORD_PRACT_ID, e.order_line_status, e.start_Date_Time, TO_CHAR(e.end_date_Time, 'DD/MM/YYYY HH24:MI') end_date_Time, e.DURN_VALUE, e.DURN_TYPE, IP_NURSING_UNIT.SHORT_DESC NURSING_UNIT_DESC, e.ordeR_line_num ORDER_LINE_NUM, e.PATIENT_CLASS PATIENT_CLASS, e.SOURCE_TYPE SOURCE_TYPE, IP_OPEN_ENCOUNTER.ROOM_NUM ROOM_NUM, IP_OPEN_ENCOUNTER.BED_NUM BED_NUM,IP_OPEN_ENCOUNTER.BED_CLASS_CODE BED_CLASS_CODE, IP_OPEN_ENCOUNTER.BED_TYPE_CODE BED_TYPE_CODE, IP_OPEN_ENCOUNTER.SPECIALTY_CODE SPECIALTY_CODE,IP_OPEN_ENCOUNTER.ATTEND_PRACTITIONER_ID ATTEND_PRACTITIONER_ID,PERFORMING_FACILITY_ID,(case when (STRENGTH_VALUE>0 and disp_alt_form_yn='Y'  and npb_drug_yn='N') then 'Y' else 'N' end) disp_alt_symbol ");
                       
            if(getDisplayDosageDetails().equals("Y")) 			//Splitted query with if-else condition for MMS-DM-CRF-0011 [IN:055302]
				sbSQL.append(", (SELECT DECODE (g.drug_yn, 'N', '', DECODE (iv_prep_yn, '6', ( (RTRIM (RTRIM (TO_CHAR (o.qty_value, '999999990.999999' ), '0' ), '.' ) ) || ' ' || am_get_desc.am_uom (o.qty_unit, ?, '2') || DECODE (olph.split_dose_yn, 'Y', '(Divided), ', ', ' ) || f.freq_desc || ', ' || o.DURN_VALUE || ' ' || am_get_desc.am_duration_type (o.durn_type, ?, '1' ) ), ( DECODE (olph.sliding_scale_yn, 'Y', 'Sliding Scale', (RTRIM (RTRIM (TO_CHAR (o.qty_value, '999999990.999999' ), '0' ), '.' ) ) || ' ' || am_get_desc.am_uom (o.qty_unit, ?, '2') ) || DECODE (olph.split_dose_yn, 'Y', '(Divided), ', ', ' ) || f.freq_desc || ', ' || o.DURN_VALUE || ' ' || am_get_desc.am_duration_type (o.durn_type, ?, '1' ) ) ) ) FROM or_order_line o, or_order_line_ph olph, am_frequency_lang_vw f WHERE o.order_id = e.order_id AND o.order_line_num = e.order_line_num AND o.order_id = olph.order_id AND o.order_line_num = olph.order_line_num AND o.freq_code = f.freq_code AND f.language_id = ?) dosage_details ");
			//,'DD' added for MMS-KH-CRF-0014
            sbSQL.append(" FROM MP_PATIENT, IP_OPEN_ENCOUNTER, ph_order_work_list E ,IP_NURSING_UNIT_lang_vw IP_NURSING_UNIT ,ph_drug_lang_vw g,ph_disp_locn h WHERE ph_disp_locn_appl_yn (e.orig_performing_deptloc_code,?, e.source_type, e.source_code, e.added_facility_id, e.performing_facility_id, e.performing_deptloc_code, g.drug_class, g.drug_code, e.order_type_code, e.patient_class, e.priority, e.discharge_ind, DECODE (g.drug_yn, 'Y', 'D', 'N', 'M'),e.iv_prep_yn,e.ORIG_PERFORMING_DEPTLOC_CODE, e.order_id, NULL, e.patient_id, e.encounter_id) = 'Y' AND h.disp_locn_code = performing_deptloc_code AND h.facility_id = e.PERFORMING_FACILITY_ID AND e.PATIENT_CLASS = 'IP' AND TRUNC(E.END_DATE_TIME) >=TRUNC(SYSDATE) AND IP_OPEN_ENCOUNTER.FACILITY_ID = IP_NURSING_UNIT.FACILITY_ID AND IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE = IP_NURSING_UNIT.NURSING_UNIT_CODE AND (E.START_DATE_TIME BETWEEN To_date(? ,'DD/MM/YYYY HH24:MI') AND To_date(?,'DD/MM/YYYY HH24:MI') OR E.END_DATE_TIME BETWEEN To_date(? ,'DD/MM/YYYY HH24:MI') AND To_date(?,'DD/MM/YYYY HH24:MI') OR To_date(? ,'DD/MM/YYYY HH24:MI') BETWEEN E.START_DATE_TIME AND E.END_DATE_TIME OR To_date(?,'DD/MM/YYYY HH24:MI') BETWEEN E.START_DATE_TIME AND E.END_DATE_TIME ) AND e.ENCOUNTER_ID=IP_OPEN_ENCOUNTER.ENCOUNTER_ID AND e.ORDERING_FACILITY_ID=IP_OPEN_ENCOUNTER.FACILITY_ID AND e.ORDERING_FACILITY_ID=? AND e.PATIENT_ID=MP_PATIENT.PATIENT_ID AND MP_PATIENT.DECEASED_YN='N' AND e.ORDER_TYPE_CODE IN (SELECT ORDER_TYPE_CODE FROM PH_ORDER_TYPE_FOR_DRUG_CLASS WHERE DRUG_CLASS <> 'N') AND e.PRIORITY= 'R' AND ((? = 'N' AND IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) OR (? = 'L' AND IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE IN (SELECT NURSING_UNIT_CODE FROM IP_NURSING_UNIT_LOCATION WHERE FACILITY_ID = ? AND BLDNG_CODE between NVL(?,'!') AND NVL(?,'~') AND FLOOR_CODE = nvl(?,FLOOR_CODE )))) AND ( ( ? ='B' AND (IV_PREP_YN IN ('1','3','5','9') OR IV_PREP_YN IS NULL)) OR (? ='Y' AND IV_PREP_YN IN ('1','3','5','9')) OR(? ='N' AND IV_PREP_YN IS NULL)) AND ( (?='R' AND e.ORD_DATE_TIME<( To_date(?,'DD/MM/YYYY HH24:MI')-(1/24*?)) and( ip_verf_yn = 'Y' AND e.order_status IN ('VF', 'DP','DD') OR ip_verf_yn = 'N' AND e.order_status IN ('OS', 'VF', 'DP','DD') ) ) OR(? = 'I' and ( ip_verf_yn = 'Y' AND e.order_status IN ('VF') OR ip_verf_yn = 'N' AND e.order_status IN ('OS'))) ) AND e.ord_date_time between sysdate-100 and sysdate AND EXISTS (SELECT 'Y' FROM am_frequency WHERE freq_code = e.freq_code AND freq_nature IN ('F','I',?,?,'C')) AND g.drug_yn = DECODE(?,'M','N','D','Y',g.drug_yn) /*AND EXISTS (Select 'Y' from or_order_line_ph where order_id = e.order_id and order_line_num = e.order_line_num AND ( (TRUNC(NEXT_FILL_DATE)>=TRUNC(To_Date(?,'DD/MM/YYYY HH24:MI'))) OR (NEXT_FILL_DATE IS NULL)))*/ and e.order_Catalog_code = g.drug_code AND 'Y' = DECODE(g.drug_yn,'N','Y',DECODE(?,'Y',calc_dosg_by_freq_durn_yn,'Y')) and g.language_id =? and IP_NURSING_UNIT.language_id=? and g.IN_FORMULARY_YN !='N' and (e.next_fill_date is null or e.next_fill_date <= to_date (?,'DD/MM/YYYY HH24:MI')) AND 1=ph_check_order_qualify_ipfill(e.ORDER_ID, e.ORDER_LINE_NUM, E.FREQ_CODE, e.DURN_TYPE, e.DURN_VALUE,?,?,iv_prep_yn,g.drug_yn) AND ph_ipfill_zero_qty_yn(e.order_id, e.order_line_num,e.FREQ_CODE, e.iv_prep_yn, g.drug_yn, g.drug_code, ?,?    )='Y' Order By IP_NURSING_UNIT.SHORT_DESC, decode(?,'B',NVL(IP_OPEN_ENCOUNTER.bed_NUM,e.patient_id),e.patient_id),nvl(iv_prep_yn,'-1'),e.order_id,e.order_line_num");
			pstmt   =connection.prepareStatement(sbSQL.toString() );
			int i=1	;
			pstmt.setString(i++,locale);
			pstmt.setString(i++,disp_locn_code);		    		         //16 
			pstmt.setString(i++,fill_int_start_date_time);          		 //1    	 
			pstmt.setString(i++,fill_int_end_date_time);            		 //2    	 
			pstmt.setString(i++,Proc_Type);				    		 		 //3    	 
			pstmt.setString(i++,"N");					    		 		 //4    	 
																			        	 
			pstmt.setString(i++,nursing_unit_or_locn);						 //5    	 
			pstmt.setString(i++,Nursing_Unit_From);							 //6    	 
			pstmt.setString(i++,Nursing_Unit_To);							 //7    	 
			pstmt.setString(i++,Building_Code);								 //8    	 
			pstmt.setString(i++,Building_Code_to);							 //9    	 
			pstmt.setString(i++,Floor_Code);								 //10    	 
			pstmt.setString(i++,checkForNull(ip_fill_excl_prd_behind));	     //11        
			pstmt.setString(i++,compound_drug_ind);					         //12        
			pstmt.setString(i++,ip_medical_items);					         //13         
			pstmt.setString(i++,ip_excl_intermittent_fill);					 //14  
			pstmt.setString(i++,ip_prn_drugs);					             //15  
			pstmt.setString(i++,locale);
			if(getDisplayDosageDetails().equals("Y")){ //if block Added for MMS-DM-CRF-0011 [IN:055302]
				pstmt.setString(i++,locale);
				pstmt.setString(i++,locale);
				pstmt.setString(i++,locale);
				pstmt.setString(i++,locale);
				pstmt.setString(i++,locale);
			}
			pstmt.setString(i++,disp_locn_code);		    		         //16        
			pstmt.setString(i++,fill_int_start_date_time);  				 //17   	 
			pstmt.setString(i++,fill_int_end_date_time);    				 //18   	 
			pstmt.setString(i++,fill_int_start_date_time);  		 		 //19   	 
			pstmt.setString(i++,fill_int_end_date_time);    		 		 //20   	 
			pstmt.setString(i++,fill_int_start_date_time);					 //21   	 
			pstmt.setString(i++,fill_int_end_date_time);					 //22   	 
			pstmt.setString(i++,OrderingFacility_code);	    				 //23   	 
			pstmt.setString(i++,nursing_unit_or_locn);						 //24   	 
			pstmt.setString(i++,Nursing_Unit_From);							 //25   	 
			pstmt.setString(i++,Nursing_Unit_To);							 //26   	 
			pstmt.setString(i++,nursing_unit_or_locn);						 //27   	 
			pstmt.setString(i++,OrderingFacility_code);						 //28   	 
			
			pstmt.setString(i++,Building_Code);								 //29   	 
			pstmt.setString(i++,Building_Code_to);							 //30   	 
			pstmt.setString(i++,Floor_Code);								 //31   	 

			pstmt.setString(i++,compound_drug_ind);							 //32   	 
			pstmt.setString(i++,compound_drug_ind);							 //33   	 
			pstmt.setString(i++,compound_drug_ind);							 //34   	 
			pstmt.setString(i++,Proc_Type);									 //35   	 
			pstmt.setString(i++,fill_int_start_date_time);			         //36        
			pstmt.setString(i++,checkForNull(ip_fill_excl_prd_behind));	 	 //37   	 
			pstmt.setString(i++,Proc_Type);							     	 //38   	 
			pstmt.setString(i++,ip_prn_drugs);			     	             //39
			pstmt.setString(i++,ip_medical_items);			     	         //40
			pstmt.setString(i++,ip_medical_items);			     	         //41
			//pstmt.setString(i++,fill_int_start_date_time);			     	 
			pstmt.setString(i++,ip_excl_intermittent_fill);					 //42 
			pstmt.setString(i++,locale);							     	 //43   	 
		    pstmt.setString(i++,locale);							     	 //44   	 
			pstmt.setString(i++,fill_int_start_date_time);			     	 //45   
			pstmt.setString(i++,fill_int_start_date_time);					 //46 start date time added by bshankar
			pstmt.setString(i++,fill_int_end_date_time);					 //47 fill end date time added by bshankar
			pstmt.setString(i++,fill_int_start_date_time);  				 //48 - MMS shedule time between effective_start and 
			pstmt.setString(i++,fill_int_end_date_time);    				 //49 -MMS  shedule time between effective_start and 
			pstmt.setString(i++,order_by_for_list);					   		 //50

		
			/*System.err.println("fill_int_start_date_time--Bean--->"+fill_int_start_date_time);
			System.err.println("fill_int_end_date_time---Bean>"+fill_int_end_date_time);
			System.err.println("Proc_Type---Bean-->"+Proc_Type+ "N");
			System.err.println("nursing_unit_or_locn--Bean--->"+nursing_unit_or_locn);
			System.err.println("Nursing_Unit_From----->"+Nursing_Unit_From);
			System.err.println("Nursing_Unit_To----->"+Nursing_Unit_To);
			System.err.println("Building_Code---->"+Building_Code);
			System.err.println("Building_Code_to---->"+Building_Code_to);
			System.err.println("Floor_Code---->"+Floor_Code);
			System.err.println("ip_fill_excl_prd_behind---->"+ip_fill_excl_prd_behind);
			System.err.println("compound_drug_ind----->"+compound_drug_ind+" \n ip_medical_items----->"+ip_medical_items);
			System.err.println("ip_excl_intermittent_fill----->"+ip_excl_intermittent_fill+" \n ip_prn_drugs----->"+ip_prn_drugs);
			System.err.println("disp_locn_code----->"+disp_locn_code);
			System.err.println(" fill_int_start_date_time--->"+fill_int_start_date_time);
			System.err.println("fill_int_end_date_time--->"+fill_int_end_date_time);
			System.err.println(" fill_int_start_date_time----->"+fill_int_start_date_time);
			System.err.println(" fill_int_end_date_time----->"+fill_int_end_date_time);
			System.err.println(" fill_int_start_date_time---->"+fill_int_start_date_time);
			System.err.println("fill_int_end_date_time---->"+fill_int_end_date_time);
			System.err.println(" OrderingFacility_code---->"+OrderingFacility_code);
			System.err.println("nursing_unit_or_locn----->"+nursing_unit_or_locn);
			System.err.println("Nursing_Unit_From----->"+Nursing_Unit_From);
			System.err.println("Nursing_Unit_To----->"+Nursing_Unit_To);
			System.err.println("nursing_unit_or_locn--->"+nursing_unit_or_locn);
			System.err.println("OrderingFacility_code--->"+OrderingFacility_code);
			System.err.println("Building_Code---->"+Building_Code);
			System.err.println("Building_Code_to---->"+Building_Code_to);
			System.err.println("Floor_Code---->"+Floor_Code);
			System.err.println("compound_drug_ind----->"+compound_drug_ind);
			System.err.println("compound_drug_ind---->"+compound_drug_ind);
			System.err.println("compound_drug_ind---->"+compound_drug_ind);
			System.err.println("Proc_Type---->"+Proc_Type);
			System.err.println("fill_int_start_date_time---->"+fill_int_start_date_time);
			System.err.println("ip_fill_excl_prd_behind---->"+ip_fill_excl_prd_behind);
			System.err.println("Proc_Type---->"+Proc_Type);
			System.err.println("ip_prn_drugs----->"+ip_prn_drugs);
			System.err.println("ip_medical_items----->"+ip_medical_items);
			System.err.println("ip_medical_items----->"+ip_medical_items);
			System.err.println("fill_int_start_date_time---->"+fill_int_start_date_time);
			System.err.println("ip_excl_intermittent_fill----->"+ip_excl_intermittent_fill);
			System.err.println("locale--->"+locale);
			System.err.println("order_by_for_list--->"+order_by_for_list);
			System.err.println("641 order_by_for_list--->"+order_by_for_list); // bshankar*/
			
	   		resultSet	= pstmt.executeQuery() ;
		//System.err.println("ip_fill_list----------resultSet->"+resultSet);
			if (resultSet!=null){
		//System.err.println("resultSet--------not null--->"+ip_fill_list);
				while(resultSet.next()){
		//System.err.println("While result set--->"+ip_fill_list);
					ip_fill_order	= new HashMap();
					ip_fill_order.put("iv_prep_yn",checkForNull(resultSet.getString("iv_prep_yn")));
					ip_fill_order.put("Tot_Disp_Qty",checkForNull(resultSet.getString("Tot_Disp_Qty")));
					ip_fill_order.put("Disp_qty",checkForNull(resultSet.getString("Disp_qty")));
					ip_fill_order.put("Patient_Details",checkForNull(resultSet.getString("Patient_Details")));
					ip_fill_order.put("patient_Name",checkForNull(resultSet.getString("patient_Name")));
					ip_fill_order.put("date_of_birth",checkForNull(resultSet.getString("date_of_birth")));
					ip_fill_order.put("sex",checkForNull(resultSet.getString("sex")));
					ip_fill_order.put("patient_id",checkForNull(resultSet.getString("patient_id")));
				   	ip_fill_order.put("Drug_Code",checkForNull(resultSet.getString("order_Catalog_code")));
					ip_fill_order.put("Drug_Name",checkForNull(resultSet.getString("Drug_Name")));
					ip_fill_order.put("ORDER_QTY",checkForNull(resultSet.getString("ORDER_QTY")));
					ip_fill_order.put("ORDER_UOM",checkForNull(resultSet.getString("ORDER_UOM")));
					ip_fill_order.put("ORDER_ID",checkForNull(resultSet.getString("ORDER_ID")));
					ip_fill_order.put("SOURCE_CODE",checkForNull(resultSet.getString("SOURCE_CODE")));
				    ip_fill_order.put("ORDERING_FACILITY_ID",checkForNull(resultSet.getString("ORDERING_FACILITY_ID")));
					ip_fill_order.put("ORD_DATE_TIME",checkForNull(resultSet.getString("ORD_DATE_TIME")));
					ip_fill_order.put("PATIENT_ID",checkForNull(resultSet.getString("PATIENT_ID")));
					ip_fill_order.put("ENCOUNTER_ID",checkForNull(resultSet.getString("ENCOUNTER_ID")));
					ip_fill_order.put("ORD_PRACT_ID",checkForNull(resultSet.getString("ORD_PRACT_ID")));
					ip_fill_order.put("order_line_status",checkForNull(resultSet.getString("order_line_status")));
					ip_fill_order.put("start_Date_Time",checkForNull(resultSet.getString("start_Date_Time")));
					ip_fill_order.put("end_date_Time",checkForNull(resultSet.getString("end_date_Time")));
					ip_fill_order.put("DURN_VALUE",checkForNull(resultSet.getString("DURN_VALUE")));
					ip_fill_order.put("DURN_TYPE",checkForNull(resultSet.getString("DURN_TYPE")));
					ip_fill_order.put("NURSING_UNIT_DESC",checkForNull(resultSet.getString("NURSING_UNIT_DESC")));
					ip_fill_order.put("ORDER_LINE_NUM",checkForNull(resultSet.getString("ORDER_LINE_NUM")));
					ip_fill_order.put("PATIENT_CLASS",checkForNull(resultSet.getString("PATIENT_CLASS")));
					ip_fill_order.put("SOURCE_TYPE",checkForNull(resultSet.getString("SOURCE_TYPE")));
					ip_fill_order.put("ROOM_NUM",checkForNull(resultSet.getString("ROOM_NUM")));
					ip_fill_order.put("BED_NUM",checkForNull(resultSet.getString("BED_NUM")));
					ip_fill_order.put("BED_CLASS_CODE",checkForNull(resultSet.getString("BED_CLASS_CODE")));
					ip_fill_order.put("BED_TYPE_CODE",checkForNull(resultSet.getString("BED_TYPE_CODE")));
					ip_fill_order.put("SPECIALTY_CODE",checkForNull(resultSet.getString("SPECIALTY_CODE")));
			        ip_fill_order.put("ATTEND_PRACTITIONER_ID",checkForNull(resultSet.getString("ATTEND_PRACTITIONER_ID")));
			        ip_fill_order.put("PERFORMING_FACILITY_ID",checkForNull(resultSet.getString("PERFORMING_FACILITY_ID")));
				    ip_fill_order.put("disp_alt_symbol",checkForNull(resultSet.getString("disp_alt_symbol")));
				    if(getDisplayDosageDetails().equals("Y")) //added for MMS-DM-CRF-0011 [IN:055302]
				    	ip_fill_order.put("DOSAGE_DETAILS",checkForNull(resultSet.getString("DOSAGE_DETAILS")));
					ip_fill_list.add(ip_fill_order);
				}
			}
		}
		catch ( Exception e ) {												
			e.printStackTrace() ;
			System.err.println("696: exceptionip_fill_list----------->"+ip_fill_list);
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		sbSQL.setLength(0);
		this.ipFillList = ip_fill_list;
		//System.err.println("ip_fill_list----------->"+ip_fill_list);
		return ip_fill_list;
	}
	public ArrayList getBuildingList() {
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		ArrayList facilities    = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TRANS_BUILDING_SELECT" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.disp_locn_code);
			pstmt.setString(3,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				facilities.add(resultSet.getString("BLDNG_CODE"));
				facilities.add(resultSet.getString("SHORT_DESC"));
			}
		}
		catch ( Exception e ) {
			facilities.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				facilities.add(es.toString());
			}
		}
		return facilities;
	}

	public void setAll( Hashtable recordSet ) {
		/* 	This function also is called by the controller when apply is pressed
			recordSet is nothing but a hashtable containing all form values	*/
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		this.recordSet = recordSet;
	}

	public ArrayList getFloorList(String BldngCode) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList facilities = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TRANS_FLOOR_SELECT" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,BldngCode);
			pstmt.setString(3,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				facilities.add(resultSet.getString("FLOOR_CODE"));
				facilities.add(resultSet.getString("SHORT_DESC"));
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
		return facilities;
	}

	public String getCashCollectionStage(String disp_location_code){
		String disp_cash_coll_stage	="";
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT155") ) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,disp_location_code);
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				disp_cash_coll_stage=resultSet.getString("DISP_CASH_COLL_STAGE");// DISP_BILL_STAGE changed to DISP_CASH_COLL_STAGE for SRR20056-SCF-7639 ICN027720
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
            catch(Exception es) { es.printStackTrace();}
        }
		return disp_cash_coll_stage;
	}

	public String getDispBillingStage(String disp_locn_code){
		String disp_bill_stage	="";
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT155") ) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,disp_locn_code);
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				disp_bill_stage=resultSet.getString("DISP_BILL_STAGE");
			}
		}
        catch ( Exception e ) {
            System.err.println( "getDispBillingStage  : getFunctRollID:Error loading values from database" ) ;
            e.printStackTrace() ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return disp_bill_stage;
	}

	public String getBLInterfaceYN(){
		String bl_interface_yn	= "";
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT2") ) ;
			pstmt.setString(1,login_facility_id.trim());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				bl_interface_yn=resultSet.getString("BL_INTERFACE_YN");
			}
		}
        catch ( Exception e ) {
            System.err.println( "getBLInterfaceYN:Error loading values from database" ) ;
            e.printStackTrace() ;
           
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return bl_interface_yn;
	}

	 public HashMap insert() {
		if("Y".equals(getUserAuthPINRequiredYN()))  // Added for RUT-CRF-0035 [IN029926] - Based on this flag, the User ID Captured with PIN will be updated
			login_by_id=getAuthUserID();
		//HashMap result = new HashMap();
		HashMap tabData= new HashMap();
		HashMap sqlMap = new HashMap();
		HashMap recordSet = this.fillListDtl;

		tabData.put("flag","465759855");
		tabData.put("result",new Boolean(true));
		tabData.put("iv_drug_ind",recordSet.get("iv_drug_ind").toString());
		tabData.put("compound_drug_ind",recordSet.get("compound_drug_ind").toString());
		
		tabData.put("ip_excl_intermittent_fill",recordSet.get("ip_excl_intermittent_fill").toString());
		tabData.put("nursing_unit_or_locn",recordSet.get("nursing_unit_or_locn").toString());
		tabData.put("Nursing_Unit_From",recordSet.get("Nursing_Unit_From_Code").toString());
		tabData.put("Nursing_Unit_To",recordSet.get("Nursing_Unit_To_Code").toString());
		
		tabData.put("Building_Code_from",recordSet.get("Building_Code").toString());
		tabData.put("Building_Code_to",recordSet.get("Building_Code_to").toString());
		tabData.put("Floor_Code",recordSet.get("Floor_Code").toString());
		
		tabData.put("Proc_Type",recordSet.get("Proc_Type").toString());
		tabData.put("schedule_start",(com.ehis.util.DateUtils.convertDate(recordSet.get("schedule_start").toString(),"DMYHM",getLanguageId(),"en")).toString());
		tabData.put("Ip_Fill_Prd_Ahead",recordSet.get("Ip_Fill_Prd_Ahead").toString());
		tabData.put("ip_fill_prd_unit",recordSet.get("Fill_Period_Unit").toString());
		tabData.put("ip_fill_excl_prd_behind",recordSet.get("ip_fill_excl_prd_behind").toString());	
		tabData.put("order_by_for_list",recordSet.get("order_by_for_list").toString());
		tabData.put("login_facility_id",login_facility_id);
		tabData.put("disp_locn_code",recordSet.get("disp_locn_code").toString());
		tabData.put("user_id",login_by_id);
		tabData.put("fill_int_start_date_time",(com.ehis.util.DateUtils.convertDate(recordSet.get("fill_int_start_date_time").toString(),"DMYHM",getLanguageId(),"en")));
		tabData.put("fill_int_end_date_time",(com.ehis.util.DateUtils.convertDate(recordSet.get("fill_int_end_date_time").toString(),"DMYHM",getLanguageId(),"en")));
		tabData.put("cut_off_limit_for_new_ord",recordSet.get("cut_off_limit_for_new_ord").toString());
		tabData.put("login_at_ws_no",login_at_ws_no);
		tabData.put("message","ddd");
		tabData.put( "properties", getProperties() );
		tabData.put( "login_by_id", login_by_id );
		tabData.put( "facility_id", login_facility_id );
		tabData.put( "mode",getMode());
		tabData.put("LanguageId",recordSet.get("locale").toString());
		tabData.put("CashCollectionStage",getCashCollectionStage(recordSet.get("disp_locn_code").toString()));
		tabData.put("BL_INTERFACE_YN", getBLInterfaceYN());
		tabData.put("DispBillingStage",getDispBillingStage(recordSet.get("disp_locn_code").toString()));
		tabData.put("ipFillList",this.ipFillList);
		tabData.put("selectedRecords",this.Records);
		tabData.put("Patientinsertlist",this.Patientinsertlist);
	  	tabData.put("Ipseqnum",getIpseqnum());
		tabData.put("DISPUOMS",this.dispuoms);
		tabData.put("ALTDRUGREMARKS",getAltDrugRemarks());//Added for Bru-HIMS-CRF-082 [IN:029948]

		try{
			sqlMap.put("SQL_PH_FILLPARAM_INSERT",PhRepository.getPhKeyValue( "SQL_PH_FILLPARAM_INSERT"));
			sqlMap.put("SQL_PH_FILLPARAM_SEQUENCE",PhRepository.getPhKeyValue( "SQL_PH_FILLPARAM_SEQUENCE"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT56",PhRepository.getPhKeyValue( "SQL_PH_DISP_MEDICATION_SELECT56"));
			sqlMap.put("SQL_PH_FILL_PROCESS_SELECT2",PhRepository.getPhKeyValue( "SQL_PH_FILL_PROCESS_SELECT2"));
			sqlMap.put("SQL_PH_FILL_PROCESS_SELECT3",PhRepository.getPhKeyValue( "SQL_PH_FILL_PROCESS_SELECT3"));
			sqlMap.put("SQL_PH_FILL_PROCESS_SELECT4",PhRepository.getPhKeyValue( "SQL_PH_FILL_PROCESS_SELECT4"));
			sqlMap.put("SQL_PH_FILL_PROCESS_SELECT5",PhRepository.getPhKeyValue( "SQL_PH_FILL_PROCESS_SELECT5"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE",PhRepository.getPhKeyValue( "SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE"));
			sqlMap.put("SQL_PH_DISP_DTL_TMP_IP_UPDATE",PhRepository.getPhKeyValue( "SQL_PH_DISP_DTL_TMP_IP_UPDATE"));
			sqlMap.put("SQL_PH_DISP_BATCH_TMP_IP_UPDATE",PhRepository.getPhKeyValue( "SQL_PH_DISP_BATCH_TMP_IP_UPDATE"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT1",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT1"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT2",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT2"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT3",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT3"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT4",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT4"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT5",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT5"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT6",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT6"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT7",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT7"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT8",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT8"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT9",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT9"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT10",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT10"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT11",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT11"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT12",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT12"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT13",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT13"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT14",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT14"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT15",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT15"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT16",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT16"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT17",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT17"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT18",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT18"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT19",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT19"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT20",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT20"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT21",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT21")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT22",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT22")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT23",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT23")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT24",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT24")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT25",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT25")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT26",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT26")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT27",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT27")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT28",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT28")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT29",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT29")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT30",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT30"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT31",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT31"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT32",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT32"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT33",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT33"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT34",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT34"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT38",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT38"));			
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_A"		,PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_A"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_INSERT_LAST_FILL_INT_DTL",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_INSERT_LAST_FILL_INT_DTL"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_A"			,PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_A"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_LAST_FILL_INT_DTL",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_LAST_FILL_INT_DTL"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_INSERT_HDR_TMP","INSERT INTO PH_DISP_HDR_TMP (DISP_TMP_NO, FACILITY_ID, DISP_LOCN_CODE,ORDER_ID, RECORD_DATE_TIME, FILL_PROC_ID,ORDERING_FACILITY_ID, ORD_DATE_TIME, PATIENT_ID, ENCOUNTER_ID, PATIENT_CLASS, LOCN_TYPE, LOCN_CODE, ROOM_TYPE, ROOM_NO, BED_NO, BED_CLASS, BED_TYPE, SPECIALITY_CODE, ATTEND_PRACTITIONER_ID, PRES_PHYSICIAN_ID, DISPENSED_BY, DISPENSED_DATE_TIME,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)VALUES(?,?,?,?,SYSDATE,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,SYSDATE,?,?,?,SYSDATE,?,?)");
		//	sqlMap.put("SQL_PH_IP_FILL_PROCESS_INSERT_HDR_TMP",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_INSERT_HDR_TMP"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_INSERT_DTL_TMP",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_INSERT_DTL_TMP"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_DTL_TMP",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_DTL_TMP"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_PH",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_PH"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_UPDATE"    ,PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_UPDATE"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_EQVL_VALUE"    ,PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_EQVL_VALUE"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_CAL_NO_OF_DAYS" ,PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_CAL_NO_OF_DAYS"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT64"    ,PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT64"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT22A"    ,PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT22A"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT141"    ,PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT141"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_BL_SELECT1"    ,PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_DRUG_PROFILE"    ,PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_DRUG_PROFILE"));
		}
		catch (Exception e) {
			e.printStackTrace() ;
		}
		HashMap map=new HashMap();
		try {
			 Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_IP_FILL_ALL" ),IPFillAllHome.class,getLocalEJB());
			 Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);
			 Object argArray[] =new Object[2];
			 argArray[0]= tabData;
			 argArray[1]=sqlMap;

			 Class  paramArray[] = new Class[2];
			 paramArray[0]= tabData.getClass();
			 paramArray[1] = sqlMap.getClass();
					
			// map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			//(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		   
			map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if(((String)map.get("msgid")).equals("RECORD_NOT_INSERTED_FILL")){
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"PH")) ;
				map.put( "flag", (String)map.get("flag") ) ;
				System.err.println("inside 912");
			}
			else if(((String)map.get("msgid")).equals("PH_DOC_TYPE_SETTINGS_NOT_AVAIL")){
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"PH")) ;
				System.err.println("inside 916");
			}
			else if(((String)map.get("msgid")).equals("")){
				map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED_FILL","PH")) ;
				System.err.println("inside 919");
			}
			else if(!((String)map.get("msgid")).equals("")){
				map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED_FILL","PH")+getMessage(getLanguageId(),"WITH_ERRORS","PH")+ (String)map.get("msgid") ) ;
				// map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED_FILL","PH")+"..."  ) ;
				System.err.println("inside 922");
				System.err.println((String)map.get("msgid"));
			}
			/*if( ((Boolean) map.get( "result" )).booleanValue() ){
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"PH") ) ;
				System.err.println("in side if condition");				 
			    }
			else{
				if(!((String)map.get("msgid")).equals("RECORD_NOT_INSERTED_FILL")){
				map.put( "message", (String)map.get("msgid") ) ;
				map.put( "flag", (String)map.get("flag") ) ;
					System.err.println("inside 878");
				}else if(((String)map.get("msgid")).equals("PH_DOC_TYPE_SETTINGS_NOT_AVAIL")){
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"PH")) ;
					System.err.println("inside 882");
				}
			 }*/
		 }
		 catch (Exception e){
			e.printStackTrace();
		 }
		//System.err.println("map----from bean---928--->"+map);
		return map;
	}

	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

	public HashMap getNextEffStartDateEndDate(String start_date_time){
		HashMap		eff_dates	= new HashMap();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		//String eff_start_date   = "";
		//String eff_end_date     = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_SELECT35" )) ;
			resultSet = pstmt.executeQuery() ;
			
			while (resultSet!=null && resultSet.next()) {
				if(resultSet.getInt("COUNT")>0){
					eff_dates.put("EFF_START_DATE",resultSet.getString("EFF_START_DATE"));
					eff_dates.put("EFF_END_DATE"  ,resultSet.getString("EFF_END_DATE"));
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
				es.printStackTrace() ;
			}
		}
		return eff_dates;
	}

    public HashMap getEffStartDateEndDate(String start_date_time){
		HashMap		eff_dates	= new HashMap();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_SELECT35" )) ;
			pstmt = connection.prepareStatement("select to_char(sysdate,'DD/MM/YYYY HH24:MI') EFF_START_DATE from dual") ;
			resultSet = pstmt.executeQuery() ;
			while (resultSet!=null && resultSet.next()) {
				eff_dates.put("EFF_START_DATE",resultSet.getString("EFF_START_DATE"));
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
		return eff_dates;
	}
	
	 public HashMap getPrescribeEndDate(String start_date_time,String MaxDurnForIpPres){
		HashMap		eff_dates	= new HashMap();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_SELECT35" )) ;
			pstmt = connection.prepareStatement("SELECT  TO_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')+?,'DD/MM/YYYY HH24:MI') EFF_END_DATE FROM DUAL") ;
			pstmt.setString(1,start_date_time);
			pstmt.setString(2,MaxDurnForIpPres);
			resultSet = pstmt.executeQuery() ;
			while (resultSet!=null && resultSet.next()) {
				eff_dates.put("EFF_END_DATE",resultSet.getString("EFF_END_DATE"));
				
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
		return eff_dates;
	}

   public HashMap getPrescribeEndDate1(String MaxDurnForIpPres,String facility_id,String DispenseLocation){
		HashMap		eff_dates	= new HashMap();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_SELECT35" )) ;
			pstmt = connection.prepareStatement("SELECT TO_CHAR (SYSDATE+?, 'DD/MM/YYYY') || ' ' || TO_CHAR (ip_fill_dflt_start_time, 'HH24:MI') schedule_start_time FROM ph_disp_locn WHERE facility_id = ? AND disp_locn_code = ?") ;
			pstmt.setString(1,MaxDurnForIpPres);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,DispenseLocation);
			resultSet = pstmt.executeQuery() ;
			while (resultSet!=null && resultSet.next()) {
				eff_dates.put("schedule_start_time",resultSet.getString("schedule_start_time"));
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
		return eff_dates;
	}

	public HashMap getNextRoutineEffStartDateEndDate(String start_date_time,String fill_period,String disp_locn_code,String schedule_start,boolean flag){
		
		HashMap		eff_dates	= new HashMap();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		try {
			connection = getConnection() ;
			
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36D")) ;
			pstmt		= connection.prepareStatement("SELECT NVL(?,TO_CHAR(SYSDATE,'DD/MM/YYYY'))||' '||(SELECT TO_CHAR(IP_FILL_DFLT_START_TIME,'HH24:MI') FROM PH_DISP_LOCN WHERE FACILITY_ID=? AND DISP_LOCN_CODE=? ) START_DATE FROM DUAL") ;
			
			pstmt.setString(1,schedule_start);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,disp_locn_code);
			
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				start_date_time = resultSet.getString("START_DATE");
			}	
			closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
			
			if(flag){
				pstmt = connection.prepareStatement("select 1 from dual where to_date(?,'dd/mm/yyyy hh24:mi') > sysdate");
				
				pstmt.setString(1,start_date_time.substring(0,16));
				resultSet	= pstmt.executeQuery() ;

				if (resultSet!=null && resultSet.next()){
					if(fill_period != null) {
						Integer i = new Integer(fill_period);
						Integer j = new Integer((i.intValue()-24));
						fill_period = j.toString();
					}
				}	
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;

			}
			/* System.err.println("start_date_time---1-1229Bean->"+start_date_time);
			 System.err.println("start_date_time---2 1230-BEan->"+start_date_time.substring(0,10));
			 System.err.println("start_date_time---3-BEan-1231>"+start_date_time.substring(0,16));*/

			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_SELECT35A" )) ;
			pstmt = connection.prepareStatement("SELECT TO_CHAR(TO_DATE((NVL(?,TO_CHAR(SYSDATE,'DD/mm/yyyy'))) ||' '|| TO_CHAR(TO_DATE(?,'dd/mm/yyyy hh24:mi'),'hh24:mi'),'DD/MM/YYYY HH24:MI')+(?/24),'dd/mm/yyyy hh24:MI') EFF_END_DATE FROM DUAL") ;
			
			pstmt.setString(1,start_date_time.substring(0,10));
			pstmt.setString(2,start_date_time.substring(0,16));
			pstmt.setString(3,fill_period);

			resultSet = pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()) {
				eff_dates.put("EFF_START_DATE",start_date_time);
				eff_dates.put("EFF_END_DATE"  ,resultSet.getString("EFF_END_DATE"));
			}
			closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
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
		return eff_dates;
	}
	
	public HashMap getNextRoutineEffStartDateEndDate(String start_date_time,String fill_period,String disp_locn_code,String schedule_start){
		return getNextRoutineEffStartDateEndDate(start_date_time,fill_period,disp_locn_code,schedule_start,false);
	}

	public String compareDates(String from_date_time) throws Exception{
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		String result		      = from_date_time;
		String today			  = ""; 
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36B"));
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				today   = resultSet.getString("TODAY");
			}
			closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;

            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36C")) ;
			pstmt.setString(1,from_date_time);
			pstmt.setString(2,today);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				if(resultSet.getInt("VAL")<0){
					 pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36D")) ;
					 pstmt.setString(1,login_facility_id);
					 pstmt.setString(2,disp_locn_code);
					 resultSet	= pstmt.executeQuery() ;
					 if (resultSet!=null && resultSet.next()){
						 result = resultSet.getString("START_DATE");
					 }		
				}
			}	
			closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;

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
	
	public boolean isGreaterThanSysdate(String date_time) throws Exception{
		
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		boolean result			  = false; 
		String today			  = "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36B"));
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				today   = resultSet.getString("TODAY");
			}
			closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36C")) ;
			pstmt.setString(1,date_time);
			pstmt.setString(2,today);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				if(resultSet.getInt("VAL")>=0){
					result	= true;
				}
			}
			closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
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

	public String getSysDateTime() throws Exception{
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		String today			  = "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36B"));
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				today   = resultSet.getString("TODAY");
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return today;
	}

 //added by suri
  public ArrayList getFillListAltDrugs(String disp_locn_code,int ord_drug_qty,String fill_int_end_date_time,String ord_drug_code,String locale) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList fl_alt_drugs = new ArrayList();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_ALT_DRUGS_SELECT" )) ;
			//pstmt = connection.prepareStatement("SELECT   A.DRUG_CODE CODE,   A.DRUG_DESC || '  (AVAIL QTY  :' || PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',TO_DATE(?,'DD/MM/YYYY'),'N',NULL ) || ')'  DESCRIPTION FROM PH_DRUG A, PH_DRUG B, AM_UOM C, PH_INVENTORY_ITEM_FOR_DRUG F WHERE    A.GENERIC_ID=B.GENERIC_ID AND   A.ROUTE_CODE=B.ROUTE_CODE AND   (( B.DISP_ALT_FORM_YN='N' AND B.FORM_CODE=A.FORM_CODE ) OR  B.DISP_ALT_FORM_YN='Y') AND A.STRENGTH_UOM=C.UOM_CODE AND    EXISTS (SELECT COUNT(*) FROM  AM_UOM_EQVL WHERE (UOM_CODE=A.STRENGTH_UOM AND   EQVL_UOM_CODE=B.STRENGTH_UOM) OR   (UOM_CODE=B.STRENGTH_UOM AND   EQVL_UOM_CODE=A.STRENGTH_UOM) ) AND   A.STRENGTH_VALUE<>0 AND   A.DRUG_CODE=F.DRUG_CODE(+) AND   A.GENERIC_ID=(SELECT GENERIC_ID FROM PH_DRUG WHERE DRUG_CODE = ?) AND   B.DRUG_CODE=? AND  A.DISP_MULTI_STRENGTH_YN='Y' AND  PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',TO_DATE(?,'DD/MM/YYYY'),'N',NULL )  >  ?") ;
			//pstmt = connection.prepareStatement("SELECT   A.DRUG_CODE CODE,   A.DRUG_DESC || '  (AVAIL QTY  :' || PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',TO_DATE(?,'DD/MM/YYYY'),'N',NULL ) || ')'  DESCRIPTION FROM PH_DRUG_lang_vw A, PH_DRUG_lang_vw B, AM_UOM C, PH_INVENTORY_ITEM_FOR_DRUG F WHERE    A.GENERIC_ID=B.GENERIC_ID AND   A.ROUTE_CODE=B.ROUTE_CODE AND   (( B.DISP_ALT_FORM_YN='N' AND B.FORM_CODE=A.FORM_CODE ) OR  B.DISP_ALT_FORM_YN='Y') AND A.STRENGTH_UOM=C.UOM_CODE AND    EXISTS (SELECT COUNT(*) FROM  AM_UOM_EQVL WHERE (UOM_CODE=A.STRENGTH_UOM AND   EQVL_UOM_CODE=B.STRENGTH_UOM) OR   (UOM_CODE=B.STRENGTH_UOM AND   EQVL_UOM_CODE=A.STRENGTH_UOM) ) AND   A.STRENGTH_VALUE<>0 AND   A.DRUG_CODE=F.DRUG_CODE(+) AND   A.GENERIC_ID=(SELECT GENERIC_ID FROM PH_DRUG WHERE DRUG_CODE = ?) AND   B.DRUG_CODE=? AND  A.DISP_MULTI_STRENGTH_YN='Y' AND a.language_id= b.language_id and a.language_id=? and PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',TO_DATE(?,'DD/MM/YYYY'),'N',NULL )  >  ?") ;

//			pstmt = connection.prepareStatement("SELECT   A.DRUG_CODE CODE,   A.DRUG_DESC || '  (AVAIL QTY  :' || PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',?,'N',NULL ) || ')'  DESCRIPTION FROM PH_DRUG_lang_vw A, PH_DRUG_lang_vw B, AM_UOM C, PH_INVENTORY_ITEM_FOR_DRUG F WHERE    A.GENERIC_ID=B.GENERIC_ID AND   A.ROUTE_CODE=B.ROUTE_CODE AND   (( B.DISP_ALT_FORM_YN='N' AND B.FORM_CODE=A.FORM_CODE ) OR  B.DISP_ALT_FORM_YN='Y') AND A.STRENGTH_UOM=C.UOM_CODE AND  ( EXISTS (SELECT 'Y' FROM AM_UOM_EQVL WHERE UOM_CODE = a.strength_uom AND EQVL_UOM_CODE = b.strength_uom union SELECT 'Y' FROM AM_UOM_EQVL WHERE UOM_CODE = b.strength_uom AND EQVL_UOM_CODE = a.strength_uom )  or a.strength_uom = b.strength_uom) AND   A.STRENGTH_VALUE >0 AND   A.DRUG_CODE=F.DRUG_CODE(+) AND   A.DRUG_CODE <> ? AND  A.NPB_DRUG_YN <> 'Y' AND B.DRUG_CODE=? AND A.CALC_DOSG_BY_FREQ_DURN_YN =B.CALC_DOSG_BY_FREQ_DURN_YN AND A.DISP_MULTI_STRENGTH_YN='Y' and a.disp_alt_form_yn='Y' AND a.language_id= b.language_id and a.language_id=? and a.DISCONTINUED_YN='N' and PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',?,'N',NULL )  >  ? "); //added AND  A.NPB_DRUG_YN <> 'Y' for Bru-HIMS-CRF-070  && TO_DATE(?,'DD/MM/YYYY') removed from PH_RET_STOCK_AVAIL_STATUS and it replaced by '?'  for IN047266
		//A.DISP_MULTI_STRENGTH_YN='Y' REMOVED FOR GHL-CRF-0548	 
			
			pstmt = connection.prepareStatement("SELECT   A.DRUG_CODE CODE,   A.DRUG_DESC || '  (AVAIL QTY  :' || PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',?,'N',NULL ) || ')'  DESCRIPTION FROM PH_DRUG_lang_vw A, PH_DRUG_lang_vw B, AM_UOM C, PH_INVENTORY_ITEM_FOR_DRUG F WHERE    A.GENERIC_ID=B.GENERIC_ID AND   A.ROUTE_CODE=B.ROUTE_CODE AND   (( B.DISP_ALT_FORM_YN='N' AND B.FORM_CODE=A.FORM_CODE ) OR  B.DISP_ALT_FORM_YN='Y') AND A.STRENGTH_UOM=C.UOM_CODE AND  ( EXISTS (SELECT 'Y' FROM AM_UOM_EQVL WHERE UOM_CODE = a.strength_uom AND EQVL_UOM_CODE = b.strength_uom union SELECT 'Y' FROM AM_UOM_EQVL WHERE UOM_CODE = b.strength_uom AND EQVL_UOM_CODE = a.strength_uom )  or a.strength_uom = b.strength_uom) AND   A.STRENGTH_VALUE >0 AND   A.DRUG_CODE=F.DRUG_CODE(+) AND   A.DRUG_CODE <> ? AND  A.NPB_DRUG_YN <> 'Y' AND B.DRUG_CODE=? AND A.CALC_DOSG_BY_FREQ_DURN_YN =B.CALC_DOSG_BY_FREQ_DURN_YN and a.disp_alt_form_yn='Y' AND a.language_id= b.language_id and a.language_id=? and a.DISCONTINUED_YN='N' and PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',?,'N',NULL )  >  ? "); //added AND  A.NPB_DRUG_YN <> 'Y' for Bru-HIMS-CRF-070  && TO_DATE(?,'DD/MM/YYYY') removed from PH_RET_STOCK_AVAIL_STATUS and it replaced by '?'  for IN047266
			
			pstmt.setString(1,disp_locn_code);
			pstmt.setInt(2,ord_drug_qty);
			pstmt.setString(3,fill_int_end_date_time);
			pstmt.setString(4,ord_drug_code);
			pstmt.setString(5,ord_drug_code);
			pstmt.setString(6,locale);
			pstmt.setString(7,disp_locn_code);
			pstmt.setInt(8,ord_drug_qty);
			pstmt.setString(9,fill_int_end_date_time);
			pstmt.setInt(10,ord_drug_qty);

		/*	System.err.println("disp_locn_code---------->"+disp_locn_code);
			System.err.println("ord_drug_qty---------->"+ord_drug_qty);
			System.err.println("fill_int_end_date_time---------->"+fill_int_end_date_time);
			System.err.println("ord_drug_code---------->"+ord_drug_code);
			System.err.println("ord_drug_code---------->"+ord_drug_code);
*/
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				fl_alt_drugs.add(resultSet.getString("CODE"));
				fl_alt_drugs.add(resultSet.getString("DESCRIPTION"));
//System.err.println("==fl_alt_drugs====="+fl_alt_drugs);
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
		return fl_alt_drugs;
	}
	
	public int getMaxDurnForIPPres()throws Exception{
		Connection connection	    = null;
        PreparedStatement pstmt	    = null;
        ResultSet resultSet		    = null;
		int max_durn_for_ip_pres	= 1;
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT37"));
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				max_durn_for_ip_pres   = resultSet.getInt("MAX_DURN_FOR_IP_PRES");
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
		return max_durn_for_ip_pres;		
	}

	public String getAltDrugBtchDtls(String disp_locn_code,String alt_drug_code,String fill_int_start_date_time,String fill_int_end_date_time,String order_id,String order_line_num,String Proc_Type,String drug_code,String iv_prep_yn,String nursing_unit_or_locn,String Nursing_Unit_From,String Nursing_Unit_To,String Building_Code,String Building_Code_to,String Floor_Code,String ip_fill_excl_prd_behind,String compound_drug_ind,String ip_medical_items,String ip_excl_intermittent_fill,String ip_prn_drugs) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String alt_drg_btch_dtls  = "";
		String alternate  ="A";
		
		//System.err.println("login_facility_id --bean--> "+login_facility_id+" disp_locn_code --bean--> "+disp_locn_code +" alt_drug_code --bean--> "+alt_drug_code+" fill_int_start_date_time --bean--> "+fill_int_start_date_time+" fill_int_end_date_time --bean--> "+fill_int_end_date_time+" Proc_Type --bean--> "+Proc_Type+" alternate --bean--> "+alternate+" nursing_unit_or_locn --bean--> "+nursing_unit_or_locn+" Nursing_Unit_From --bean---> "+Nursing_Unit_From+" Nursing_Unit_To --bean---> "+Nursing_Unit_To+" Building_Code --bean----> "+Building_Code+" Building_Code_to -bean---> "+Building_Code_to+" Floor_Code ---bean---> "+Floor_Code+" ip_fill_excl_prd_behind --bean-->"+ip_fill_excl_prd_behind+" compound_drug_ind --bean--->"+compound_drug_ind+" iv_prep_yn --bean-- >"+iv_prep_yn+" ip_medical_items --bean--->"+ip_medical_items+" ip_excl_intermittent_fill ---bean--> "+ip_excl_intermittent_fill+" ip_prn_drugs --bean--> "+ip_prn_drugs+" order_id --bean--> "+order_id+" order_line_num --bean-- >"+order_line_num+" drug_code --bean-- "+drug_code); 

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_SELECT40" )) ;

			//pstmt = connection.prepareStatement("SELECT ph_display_stock_unit_all(?,	?,	e.Order_id,	e.ordeR_line_num,?,?,?,?,	NUll,	e.start_Date_time,	e.end_Date_Time,	e.durn_type,	e.durn_value, 	e.order_line_Status, 	e.order_qty,	e.ORDER_UOM,(SELECT freq_nature FROM am_frequency WHERE freq_code = e.freq_code) ,	?,?,?,?,?,?,?,?,?,?,?,?,?) Disp_qty FROM OR_ORDER_LINE E WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ?") ;
			pstmt = connection.prepareStatement("SELECT ph_display_stock_unit_all(?,?,e.Order_id,e.ordeR_line_num,?,?,?,?,	NUll,	e.start_Date_time,	e.end_Date_Time-1/1440,	e.durn_type, e.durn_value, e.order_line_Status, e.order_qty,	e.ORDER_UOM,(SELECT freq_nature FROM am_frequency WHERE freq_code = e.freq_code) ,	?,?,?,?,?,?,?,?,?,?,?,?,?,e.next_fill_date, e.fill_proc_id, e.bms_qty, e.sliding_scale_yn) Disp_qty FROM ph_order_work_list e WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ?") ;
           
   			/*Note: Comments by bshankar added on 26th Nov 2010.  e.end_Date_Time is changed to e.end_Date_Time-1/1440 in the above query, while passing the argument to ph_display_stock_unit_all function.
			It is assumed that if there is a dosage which fall on the end_date_time, it should not be considered. Example:
			Take a drug very 8 hours for 3 days starting from 26/11/2010 07:00. In this case, the system calculates the end date time as 29/11/2010 07:00. The number of doses for this prescription is 9 and not 10 as the last dose which is same as end date time (29/11/2010 07:00) should not be considered. Hence the end_date_time to the function is passed as 1 minute less than end_date_time. i.e e.end_Date_Time-1/1440. 			
			The end_date_time will work for normal cases. It will not work for the Alternate Drug case at the time of Fill Process.This is required in case an Alternate Drug is changed during the Fill Process.
			*/
			if(alt_drug_code.equals(drug_code)) {
				alternate ="N";
			} 
	 	    int i=1;
			pstmt.setString(i++,login_facility_id);	                          //1
			pstmt.setString(i++,disp_locn_code);							  //2
			pstmt.setString(i++,alt_drug_code);								  //3
			pstmt.setString(i++,fill_int_start_date_time);          		  //4
			pstmt.setString(i++,fill_int_end_date_time);            		  //5
			pstmt.setString(i++,Proc_Type);				    		 		  //6
			pstmt.setString(i++,alternate);			    		 		 	  //7
    		pstmt.setString(i++,nursing_unit_or_locn);						  //8
			pstmt.setString(i++,Nursing_Unit_From);							  //9
			pstmt.setString(i++,Nursing_Unit_To);							  //10
			pstmt.setString(i++,Building_Code);								  //11
			pstmt.setString(i++,Building_Code_to);							  //12
			pstmt.setString(i++,Floor_Code);								  //13
			pstmt.setString(i++,checkForNull(ip_fill_excl_prd_behind));	      //14
			pstmt.setString(i++,compound_drug_ind);					          //15
			pstmt.setString(i++,iv_prep_yn);								  //16
			pstmt.setString(i++,ip_medical_items);					          //17
			pstmt.setString(i++,ip_excl_intermittent_fill);					  //18
			pstmt.setString(i++,ip_prn_drugs);								  //19
			pstmt.setString(i++,order_id);									  //20
			pstmt.setString(i++,order_line_num);							  //21

			/*pstmt.setString(1,login_facility_id);
			pstmt.setString(2,disp_locn_code);
			pstmt.setString(3,alt_drug_code);
			pstmt.setString(4,fill_int_start_date_time);
			pstmt.setString(5,fill_int_end_date_time);
			pstmt.setString(6,Proc_Type);
			pstmt.setString(7,alternate);
			pstmt.setString(8,order_id);
			pstmt.setString(9,"1");	

			 System.err.println("login_facility_id----->"+login_facility_id);
			 System.err.println("disp_locn_code----->"+disp_locn_code);
			 System.err.println("alt_drug_code----->"+alt_drug_code);
			 System.err.println("fill_int_start_date_time----->"+fill_int_start_date_time);
			 System.err.println("fill_int_end_date_time----->"+fill_int_end_date_time);
			 System.err.println("Proc_Type----->"+Proc_Type);
			 System.err.println("alternate----->"+alternate);
			 System.err.println("order_id----->"+order_id);	*/
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				alt_drg_btch_dtls  = resultSet.getString("DISP_QTY"); 
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
			}catch(Exception es) { es.printStackTrace(); }
		}
		System.err.println("alt_drg_btch_dtls-------->"+alt_drg_btch_dtls);
		return alt_drg_btch_dtls;
	}

	public ArrayList getIVLegends() {
        Connection connection       = null ;
        PreparedStatement pstmt     = null ;
		ResultSet rset              = null ;

		ArrayList legends=new ArrayList();

		try{
			connection=getConnection();

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_CHART_SUMM_CURR_MEDNS_SELECT3") );
			rset=pstmt.executeQuery();
			
			if(rset!=null){
				while(rset.next()){
					legends.add(rset.getString("IV_DRUG_FLUID_CONTINUOUS_LG"));
					legends.add(rset.getString("IV_DRUG_FLUID_INTERMITTENT_LG"));
					legends.add(rset.getString("IV_WITHOUT_ADDITIVES_LG"));
				}
			}
		}
		catch ( Exception e ) {
				e.printStackTrace() ;
		}
		finally {
			 try {
				closeResultSet( rset ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			 }
			 catch(Exception es){
				System.out.println("Exception"+es.toString());
			 }
		}
		return legends;
	}

	public ArrayList getTradeAndBinName(String store_code,String batch_id,String expiry_date,String bin_location_code,String item_code,String trade_id,String locale) {
        Connection connection       = null ;
        PreparedStatement pstmt     = null ;
		ResultSet rset              = null ;

		ArrayList TradeAndBinName=new ArrayList();

		try{
			connection=getConnection();
			pstmt = connection.prepareStatement("select item_code,trade_name, bin_desc from st_batch_search_lang_view where store_code=? and batch_id = ? and to_char(expiry_date,'dd/mm/yyyy') = ? and bin_location_code = ? and item_code=? and lang1 = ? and lang2 = ?");
			/*System.err.println("store_code--->"+store_code);
			System.err.println("batch_id--->"+batch_id);
			System.err.println("expiry_date--->"+expiry_date);
			System.err.println("bin_location_code--->"+bin_location_code);
			System.err.println("item_code--->"+item_code);
			System.err.println("trade_id--->"+trade_id);
			System.err.println("locale--->"+locale);*/

			pstmt.setString(1,store_code);
			pstmt.setString(2,batch_id);
			pstmt.setString(3,expiry_date);
			pstmt.setString(4,bin_location_code);
			pstmt.setString(5,item_code);
			//pstmt.setString(6,trade_id);
			pstmt.setString(6,locale);
			pstmt.setString(7,locale);
			rset=pstmt.executeQuery();
			//System.err.println("rset--->"+rset);
			if(rset!=null){
				while(rset.next()){
					TradeAndBinName.add(rset.getString("item_code"));
					TradeAndBinName.add(rset.getString("trade_name"));
					TradeAndBinName.add(rset.getString("bin_desc"));
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			 try{
				closeResultSet( rset ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			 }
			 catch(Exception es) {
				es.printStackTrace() ;
			 }
		}
			//System.err.println("TradeAndBinName--->"+TradeAndBinName);
		return TradeAndBinName;
	}

	/*public int getSeqNumber(String facility_id,String store_code)throws Exception{
		Connection connection	    = null;
		CallableStatement cstmt =null;
		ResultSet resultSet		    = null;
		int Seq_num=0;
		try {
                connection	= getConnection() ;
			    cstmt=connection.prepareCall("{call PH_GET_DISP_DLY_SEQ_NO(?,?,?)}");
			    cstmt.setString(1, facility_id.trim());
				cstmt.setString(2, store_code.trim());
				cstmt.registerOutParameter(3,Types.VARCHAR);
				System.err.println("login_user---1--->"+login_user);
				System.err.println("patient_id---1--->"+patient_id);
				System.err.println("disp_locn_code---1--->"+disp_locn_code);
				System.err.println("disp_stage---1--->"+disp_stage);
				System.err.println("login_user---1--->"+login_user);
				System.err.println("login_at_ws_no---1--->"+login_at_ws_no);
				cstmt.execute();
				Seq_num = cstmt.getInt(3);
				connection.commit();

		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection ); 
		}
		 System.err.println("Seq_num---getSeqNumber()---->"+Seq_num);
		return Seq_num;		
	}
   */
	public String getAltStockUOM(String drug_code)throws Exception{
		Connection connection	    = null;
        PreparedStatement pstmt	    = null;
        ResultSet resultSet		    = null;
		String Stock_uom			= "";
		try {
            connection	= getConnection() ;
			//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT37"));
			pstmt		= connection.prepareStatement("SELECT STOCK_UOM FROM PH_DRUG WHERE DRUG_CODE =?");
			
            pstmt.setString(1,drug_code);

			resultSet	= pstmt.executeQuery() ;

			if (resultSet!=null && resultSet.next()){
				Stock_uom   = resultSet.getString("STOCK_UOM");
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
		return Stock_uom;		
	}

	public String getIpdsnyn(String facility_id)throws Exception{
		Connection connection	    = null;
        PreparedStatement pstmt	    = null;
        ResultSet resultSet		    = null;
		String ip_dsn_yn			= "";
		try {
            connection	= getConnection() ;
			//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT37"));
			pstmt		= connection.prepareStatement("SELECT DECODE(ip_dsn_yn,null,'N',ip_dsn_yn) ip_dsn_yn FROM ph_facility_param WHERE facility_id=?");
            pstmt.setString(1,facility_id);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				ip_dsn_yn   = resultSet.getString("ip_dsn_yn");
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
		return ip_dsn_yn;		
	}
  
	public String getMaxDurnForIpPres(String locale)throws Exception{
		Connection connection	    = null;
        PreparedStatement pstmt	    = null;
        ResultSet resultSet		    = null;
		String MaxDurnForIpPres			= "";
		try {
            connection	= getConnection() ;
			//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT37"));
			pstmt		= connection.prepareStatement("SELECT max_durn_for_ip_pres FROM ph_param_lang_vw WHERE MODULE_ID='PH' AND LANGUAGE_ID = ?");
            pstmt.setString(1,locale);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				MaxDurnForIpPres   = resultSet.getString("max_durn_for_ip_pres");
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
		return MaxDurnForIpPres;		
	}

	 public String getSysdate(){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String to_date			="";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("select to_char(sysdate,'DD/MM/YYYY') TO_DATE from dual") ;
			resultSet = pstmt.executeQuery() ;
			while (resultSet!=null && resultSet.next()) {
			 	to_date=resultSet.getString("TO_DATE");
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
		return to_date;
	}

	public HashMap getIpFillOnlineReport(String facility_id,String disp_locn_code)throws Exception{
		Connection connection	    = null;
        PreparedStatement pstmt	    = null;
        ResultSet resultSet		    = null;
		HashMap onlineReport		= new HashMap();
		try {
            connection	= getConnection() ;
			//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT37"));
			pstmt		= connection.prepareStatement("SELECT REPORT_ID, PRINT_STATUS FROM PH_DISP_LOCN_PRN_OPTION WHERE FACILITY_ID = ? AND DISP_LOCN_CODE = ? AND DISP_STAGE = 'FP' AND PATIENT_CLASS = 'IP' AND EFF_STATUS = 'E' AND PRINT_STATUS <> 'NR' ");
			
            pstmt.setString(1,facility_id);
            pstmt.setString(2,disp_locn_code);

			resultSet	= pstmt.executeQuery() ;

			while(resultSet!=null && resultSet.next()){
				onlineReport.put(resultSet.getString("REPORT_ID"),resultSet.getString("PRINT_STATUS"));
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
		 
		return onlineReport;		
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

   public void  InsertUnallocDrugDetails()throws Exception{
      Connection connection		        = null;
      PreparedStatement pstmt_insert	= null;
      PreparedStatement pstmt_delete	= null;
	  try {
            connection	= getConnection() ;
            pstmt_delete      = connection.prepareStatement("delete PH_UNALLOCATED_DRUGS_TMP where ADDED_AT_WS_NO=?");
			pstmt_delete.setString(1,login_at_ws_no);
			pstmt_delete.executeUpdate();
			pstmt_insert      = connection.prepareStatement("insert into PH_UNALLOCATED_DRUGS_TMP ( FACILITY_ID,PROC_TYPE, NURSING_UNIT_CODE, PATIENT_ID, ITEM_CODE, UNALLOCATED_QTY, UOM_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID) values(?,?,?,?,?,?,?,?,sysdate,?,?)");
             for (int i=0;i<unalloc_druglist.size() ;i=i+8 ){ //changed i=i+6 tp i=i+8 for SRR20056-SCF-7499
				  pstmt_insert.setString(1,login_facility_id);
				  pstmt_insert.setString(2,(String)unalloc_druglist.get(i));
				  pstmt_insert.setString(3,(String)unalloc_druglist.get(i+1));
				  pstmt_insert.setString(4,(String)unalloc_druglist.get(i+2));
				  pstmt_insert.setString(5,(String)unalloc_druglist.get(i+3));
				  pstmt_insert.setString(6,(String)unalloc_druglist.get(i+4));
				  pstmt_insert.setString(7,(String)unalloc_druglist.get(i+5));
				  pstmt_insert.setString(8,login_by_id);
				  pstmt_insert.setString(9,login_at_ws_no);
				  pstmt_insert.setString(10,login_facility_id);
				  pstmt_insert.addBatch();
			 }  
			//int[] result_insert= pstmt_insert.executeBatch(); //commented for unused variable result_insert -checkstyle rep
			pstmt_insert.executeBatch();
			try {
				closeStatement( pstmt_insert) ;				
			}
			catch(Exception es) {
				es.printStackTrace();
			}
			connection.commit();
		}
		catch ( Exception e ) {
				e.printStackTrace() ;
		}
		finally {
			closeStatement( pstmt_insert ) ;
			closeStatement( pstmt_delete ) ;
			closeConnection( connection ); 
		}
	}

	//Added getAltDrugDesc method for gettingalt-drug des in thai language===By Naveen for incident num:25181 on Nov/23/2010
	public String getAltDrugDesc(String drug_code)throws Exception	{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rs		= null;
		String drug_desc			= "";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("SELECT drug_desc FROM ph_drug_lang_vw WHERE drug_code = ? AND LANGUAGE_ID =?");

			pstmt.setString(1,drug_code);
			pstmt.setString(2,getLanguageId());
			rs = pstmt.executeQuery();
			if(rs.next()){
				drug_desc = rs.getString("drug_desc")==null?"":rs.getString("drug_desc");
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
		return drug_desc;
	}

	public int getCertificateReimburseCount (String fill_proc_id)throws Exception	{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rs		        = null;
		int cnt			            = 0;
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("select count(*)cnt from ph_disp_hdr_tmp where fill_proc_id =? and CERT_REIMB_NO is not null and facility_id =?");

			pstmt.setString(1,fill_proc_id);
			pstmt.setString(2,login_facility_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = rs.getInt("cnt");
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
		return cnt;
	}

	public int getFillRecorfCount (String fill_proc_id)throws Exception	{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rs		        = null;
		int cnt			            = 0;
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("select count(*)cnt from ph_disp_hdr_tmp where fill_proc_id =?  and facility_id =?");

			pstmt.setString(1,fill_proc_id);
			pstmt.setString(2,login_facility_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = rs.getInt("cnt");
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
		return cnt;
	}
	/* added for SRR20056-CRF-0663 --Start*/

	public String getDispDfltDisplay(String sdisp_locn_code )throws Exception	{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rsDfltDisplayDtl		= null;
	//	String sfunction_id 	= null;  Removed for IN063877
		String sDftDispDtl 	= null;

		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("SELECT PH_GET_DISP_DFLT_DISPLAY(?,?,?,?,?) DFLT_DISPLAY FROM dual");

			pstmt.setString(1,"IP_FILL_PROCESS");
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,login_by_id);
			pstmt.setString(4,sdisp_locn_code);
			pstmt.setString(5,"IP");
			rsDfltDisplayDtl = pstmt.executeQuery();
			
			if(rsDfltDisplayDtl.next()){
				sDftDispDtl = rsDfltDisplayDtl.getString("DFLT_DISPLAY");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsDfltDisplayDtl ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return sDftDispDtl;
	}
	/* added for SRR20056-CRF-0663 --End*/
	/* added for SRR20056-CRF-0612 --start*/
	public void setPrintOption(String DispLocnCode) throws Exception{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rsPrintOption		= null;
		String sPrintOption = "";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("SELECT PRINT_STATUS from PH_DISP_LOCN_PRN_OPTION WHERE DISP_LOCN_CODE =? and FACILITY_ID=? and REPORT_ID='FILL_LIST_UNALLOCATED' and DISP_STAGE='FP' and PATIENT_CLASS='IP' and EFF_STATUS='E'");
			pstmt.setString(1,DispLocnCode);
			pstmt.setString(2,login_facility_id);
			rsPrintOption = pstmt.executeQuery();
			if(rsPrintOption.next()){
				sPrintOption = rsPrintOption.getString("PRINT_STATUS");
			}
		}
		catch ( Exception e ) {
				e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsPrintOption ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		this.PrintOption		= sPrintOption;
	}
	/* added for SRR20056-CRF-0612 --end*/

	// RUT-CRF-0035 [IN029926] PIN Authentication  -- begin
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

	public void setFacilityParamValues(){	//added for Bru-HIMS-CRF-082 [IN:029948]
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String Alt_drug_remarks_ind	= "N", disp_multi_strength_yn="N", disp_alt_form_yn="N";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( "select ALT_DRUG_REMARKS_IND FROM ph_facility_param where facility_id =?") ;
			pstmt.setString(1,login_facility_id.trim());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				Alt_drug_remarks_ind = checkForNull(resultSet.getString("ALT_DRUG_REMARKS_IND"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			pstmt		= connection.prepareStatement( "select DISP_ALT_FORM_YN, DISP_MULTI_STRENGTH_YN FROM ph_param") ;
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				disp_alt_form_yn = checkForNull(resultSet.getString("DISP_ALT_FORM_YN"));
				disp_multi_strength_yn = checkForNull(resultSet.getString("DISP_MULTI_STRENGTH_YN"));
			}
			if(disp_alt_form_yn.equals("Y") && disp_multi_strength_yn.equals("Y"))
				setDispAlternate("Y");
			else
				setDispAlternate("N");
			setAltDrugRemarksInd(Alt_drug_remarks_ind);
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

	public ArrayList getDispNumbers(String disp_locn,ArrayList order_ids){	//code added for SKR-SCF-0765[IN037730]	--Start
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		int disp_no	= 0	;
		ArrayList disp_nos	= new ArrayList()	;
		try{
            connection	= getConnection() ;  
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT50A" )) ;	
			
			for(int i=0; i<order_ids.size(); i++) {
				pstmt.setString(1,(String)order_ids.get(i));							
				pstmt.setString(2,disp_locn);
				pstmt.setString(3,login_facility_id);
				resultSet	= pstmt.executeQuery() ;
				if(resultSet.next()){				
					disp_no	=	resultSet.getInt("DISP_TMP_NO");
					disp_nos.add(disp_no);				
				}
				closeResultSet( resultSet ) ; //common-icn-0029
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
		return disp_nos;
	}  //code added for SKR-SCF-0765[IN037730]--End

	public void getIPFillDefltValues(){ // added for MMS-DM-CRF-0011 [IN:055302]	
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "select CRIT_FIELD_VAL from PH_DISP_MEDN_DFLT where FUNCTION_ID = 'IP_FILL_PROCESS' and CRIT_FIELD_ID = 'DISP_DOSE_DTL'");
			resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){
				setDisplayDosageDetails(checkForNull(resultSet.getString("CRIT_FIELD_VAL"),"N"));
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
}
