/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.StringTokenizer;

import ePH.Common.PhAdapter;
import ePH.Common.PhRepository;
import eST.Common.StSales;

public class ReissueMedBean extends PhAdapter implements Serializable {
	private ArrayList DispDetails		= new ArrayList();
	private LinkedHashMap drug				= new LinkedHashMap();//Changed to HashMap for Bru-HIMS-CRF-405[IN:044830]  //HashMap changed to LinkedHashMap for [IN:049860]
	private HashMap batch				= new HashMap(); //ArrayList changed to HashMap for [IN:049860]
	private String disp_locn_details	= "";
	private String 	password			= "";
	private String today_date			= "";
	//private String today_date_time	= "";
	private String user_name			= "";
	private String PatientClass			= "";
	private String doc_type				= "";
	private String disp_locn_code		= "";
	private String disp_locn_desc		= "";
	private String new_disp_no			= "";
	private String billing_details		= "";
	String bl_interface_yn				= "N"; 
	public ArrayList print_data			= new ArrayList();
	private HashMap insertRecords		= new HashMap();
	private String token_series_desc	="";
	private String  disp_cash_coll_stage = "";
	private String  disp_cash_coll_stage_op = "";	//added for SRR20056-SCF-7639 ICN027720
	private String token_series_code    ="";
	private String orderingfacilityid   = "";
	private HashMap approvalNo = new HashMap(); //AAKH-CRF-0117
	private HashMap newApprovalNo = new HashMap();//AAKH-CRF-0117
	
	public ReissueMedBean() {
		try {
			doCommon() ;
		}catch(Exception e) {e.printStackTrace();}
	}
	private void doCommon() throws Exception{}
	public void clear() {
		disp_locn_details = "";
		insertRecords = new HashMap();
		billing_details="";
		super.clear() ;
		approvalNo = new HashMap(); //AAKH-CRF-0117
		newApprovalNo = new HashMap(); //AAKH-CRF-0117
	}
	public void setUserName(String user_name){
		this.user_name = user_name;
	}
	public String getUserName(){
		return user_name;
	}
	public void setDispLocnDetails(String disp_locn_details){
		this.disp_locn_details = disp_locn_details;
	}
	public String getDispLocnDetails(){
		return 	disp_locn_details;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}

	public String getTokenSeriesdesc(){
		return token_series_desc;
	}

	public String getTodaysDate(){
		return this.today_date;
	}

	public void setPatientClass(String PatientClass){
		this.PatientClass = PatientClass;
	}

	public String getPatientClass(){
		return PatientClass;
	}
	public void setDocType(String doc_type){
	this.doc_type=doc_type;	
	}
	public String getDocType(){
	return doc_type;
	}
	public void setDispLocnCode(String displocncode){
			this.disp_locn_code=displocncode;
	}
	public String getDispLocnCode(){
			return disp_locn_code;
	}
	public void setDispLocnDesc(String displocndesc){
			this.disp_locn_desc=displocndesc;
	}
	
	public String getDispLocnDesc(){
			return disp_locn_desc;
	}
		public void setNewDispNo(String dispNo){
			this.new_disp_no=dispNo;
	}
	
	public String getNewDispNo(){
			return new_disp_no;
	}
	public void setApprovalNo(String order_id,String order_line_no,String disp_no,String approval_no){ //AAKH-CRF-0117 -start
		this.approvalNo.put(order_id+order_line_no+disp_no,approval_no);
	}
	public HashMap getApprovalNo(){
	   return approvalNo;
	}
	public void setNewApprovalNo(String order_id,String order_line_no,String disp_no,String approval_no){
		this.newApprovalNo.put(order_id+order_line_no+disp_no,approval_no);
	}
	public HashMap getNewApprovalNo(){
	   return newApprovalNo;
	} //AAKH-CRF-0117 -end
	public void setBLInterfaceYN(String bl_interface_yn){/*code added for billing imterface oN 4/22/2006====start======*/
			this.bl_interface_yn = bl_interface_yn;
	}
	public String getBLInterfaceYN(){
			return bl_interface_yn;
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
	} /*code added for billing imterface oN 4/22/2006====End======*/
	
	public void setDispCashCollStageOP(String disp_cash_coll_stage_op){//added for SRR20056-SCF-7639 ICN027720 - start
		this.disp_cash_coll_stage_op = disp_cash_coll_stage_op;
	}
	public String getDispCashCollStageOP(){
		return 	disp_cash_coll_stage_op;
	}//added for SRR20056-SCF-7639 ICN027720 - END
	
	public void setTokenSeriesCode(String token_series_code){
		this.token_series_code = token_series_code;
	}
	public String getTokenSeriesCode(){
		return 	token_series_code;
	}

	public void setOrderingFacilityID(String orderingfacilityid) {
		this.orderingfacilityid	=	orderingfacilityid;
	}

	public String getOrderingFacilityID() {
		return this.orderingfacilityid;
	}

	public void setprint_data(ArrayList print_data){
		this.print_data = print_data;
	}
	public ArrayList getprint_data(){
		return 	print_data;
	}

	public boolean validateThePassword()throws Exception{
		setTodaysDate();

		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		try{
			connection	= getConnection() ;
		    pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT27") ) ;
			pstmt.setString(1,login_by_id.trim());
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				if((resultSet.getString("PASSWORD")).equalsIgnoreCase(getPassword().trim())){
					return true;
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

		return false;
	} //check password

	public ArrayList checkToProceed(String facility_id,String function_identity){
		ArrayList result		= new ArrayList();
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
        try {
            connection = getConnection() ;
			boolean proceed			= false;
			String disp_locn_code	= "";

			//To get the user name based on the login_id
			closeStatement( pstmt ) ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT31") ) ;
			pstmt.setString(1,login_by_id.trim());
			pstmt.setString(2,getLanguageId());
            resultSet = pstmt.executeQuery() ;
            if ( resultSet.next() ) {
				setUserName(resultSet.getString("APPL_USER_NAME"));
			}
			//CHECK WHETHER LOGGED-IN USER IS PHARMACIST OR NOT.
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
            pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT1") ) ;
			pstmt.setString(1,login_by_id.trim());
            resultSet = pstmt.executeQuery() ;

            if ( resultSet.next() ) {
				proceed	= true ;
			}
			else {
				result.add("NO DISPLAY-1");
				return result;
			}
			//CHECK WHETHER LOGGED-IN WORKSTATION NO. MAPS WITH THE WS_NO IN PH_WS_NO_FOR_DISP_LOCN
			if (proceed) {
				proceed = false ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT3") ) ;
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,login_at_ws_no.trim());
				resultSet = pstmt.executeQuery() ;

				if (resultSet.next()) {
					disp_locn_code = disp_locn_code + " AND (A.DISP_LOCN_CODE = '" + resultSet.getString("DISP_LOCN_CODE") + "' OR ";
					while ( resultSet.next() ) {
						disp_locn_code = disp_locn_code + "A.DISP_LOCN_CODE = '";
						disp_locn_code = disp_locn_code + resultSet.getString("DISP_LOCN_CODE") + "' OR ";
					}
					disp_locn_code = disp_locn_code.substring(0, disp_locn_code.length()-4);
					disp_locn_code = disp_locn_code + ") ORDER BY 1";
					proceed = true ;
				}
				else {
					result.add("NO DISPLAY-3");
					return result;
				}

				if (proceed) {
					proceed = false ;
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT54") + disp_locn_code ) ;
					disp_locn_code = "";
					pstmt.setString(1,facility_id.trim());
					pstmt.setString(2,login_by_id.trim());
					pstmt.setString(3,getLanguageId());
					resultSet = pstmt.executeQuery() ;
					while ( resultSet.next() ) {
						disp_locn_code = disp_locn_code + resultSet.getString("DISP_LOCN_CODE") + ",";
						disp_locn_code = disp_locn_code + resultSet.getString("SHORT_DESC") + ",";
					}
					result.add(disp_locn_code);
				}
				else {
					result.add("NO DISPLAY-4");
					return result;
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
			catch(Exception es) { es.printStackTrace();}
		}
		return result;
	}

	public HashMap getInitData(String disp_locn){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		HashMap map=new HashMap();
		ArrayList result=new ArrayList();
		ArrayList result1=new ArrayList();
        try {
            connection = getConnection() ;
			//	To get the dispense locations associated with the user
			String sql=PhRepository.getPhKeyValue("SQL_PH_REISSUE_MEDICATION_SELECT1");
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			pstmt= connection.prepareStatement(  sql) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,login_by_id.trim());
			pstmt.setString(3,getLanguageId());
			resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("SHORT_DESC"));
				result.add(resultSet.getString("DISP_LOCN_CODE"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			resultSet=null;
			sql=PhRepository.getPhKeyValue("SQL_PH_RULE_BY_PATCL_SELECT2");
			pstmt= connection.prepareStatement( sql) ;
			pstmt.setString(1,getLanguageId());
            resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result1.add(resultSet.getString("PATIENT_CLASS"));
				result1.add(resultSet.getString("SHORT_DESC"));
			}
			map.put("DISP",result);
			map.put("PATIENT",result1);
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
		return map;
	}//end of function getInitData

	public ArrayList getDispDetails(){
		return DispDetails;
	}
	//	To get the dispense details
	public void setDispDetails(String dispCode, String DispDate, String DrugCode,String OrderId,String OrderDate,String PatientClass,String OrderLocation,String PatientId){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList result=new ArrayList();
		try {
            connection = getConnection() ;
			String sql=PhRepository.getPhKeyValue("SQL_PH_REISSUE_MEDICATION_SELECT2");
			pstmt= connection.prepareStatement(  sql) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,dispCode);
			pstmt.setString(3,dispCode);
			pstmt.setString(4,DispDate);
			pstmt.setString(5,DispDate);
			pstmt.setString(6,DrugCode);
			pstmt.setString(7,DrugCode);
			pstmt.setString(8,OrderId);
			pstmt.setString(9,OrderId);
			pstmt.setString(10,OrderDate);
			pstmt.setString(11,OrderDate);
			pstmt.setString(12,PatientClass);
			pstmt.setString(13,PatientClass);
			pstmt.setString(14,OrderLocation);
			pstmt.setString(15,OrderLocation);
			pstmt.setString(16,PatientId);
			pstmt.setString(17,PatientId);
			pstmt.setString(18,getLanguageId());
			resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("DISP_NO"));
				result.add(resultSet.getString("DISP_DATE_TIME"));
				result.add(resultSet.getString("ADDED_BY_ID"));
				result.add(resultSet.getString("DRUG_DESC"));
				result.add(resultSet.getString("DISP_QTY"));
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
		DispDetails = result;
	}//END OF METHOD SET DISP DETAILS

	public HashMap getReissueResult(String DrugCode, String disp_from, String disp_to, String patientid){
		Connection connection		= null;
        PreparedStatement pstmt		= null;
		PreparedStatement pstmt1	= null;
        ResultSet resultSet			= null;
		ResultSet resultSet1		=	null;
		String dispense_no			=	"";
		int max_reissuable_qty =0;
		HashMap map=new HashMap();
		ArrayList result=new ArrayList();
		ArrayList result1=new ArrayList();
        try {
            connection = getConnection() ;
			//	To get the Reissue reasons
			//String sql=PhRepository.getPhKeyValue("SQL_PH_REISSUE_MEDICATION_SELECT4");
			pstmt= connection.prepareStatement(  PhRepository.getPhKeyValue("SQL_PH_REISSUE_MEDICATION_SELECT4")) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) { 
				result.add(resultSet.getString("REASON_CODE"));
				result.add(resultSet.getString("REASON_DESC"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt1 ) ;
			resultSet=null;
			//sql		= PhRepository.getPhKeyValue("SQL_PH_REISSUE_MEDICATION_SELECT5");
			//sql ="SELECT A.ORDER_ID,A.ORDER_LINE_NO,A.DISP_DRUG_CODE,B.DISP_AGAINST_DAMAGE_YN,  B.DRUG_DESC,  SUM(NVL(A.RETURNED_QTY,0)-Decode(A.REISSUE_REASON_CODE,NULL,0,A.DISP_QTY))  MAX_REISSUABLE_QTY,  A.ITEM_CODE,A.DISP_UOM_CODE,E.PATIENT_CLASS, D.UNIT_COST,A.ADDED_BY_ID,  A.DISP_LOCN_CODE,F.SHORT_DESC,F.IP_FILL_PRD_AHEAD,F.IP_FILL_PRD_UNIT,  G.PATIENT_NAME,DECODE(G.SEX,  'M',  'Male',  'F',  'Female',  'U',  'Unknown')SEX,  GET_AGE(G.DATE_OF_BIRTH) AGE   FROM  PH_DISP_DTL A , PH_DRUG B, AM_UOM C, MM_ITEM D,OR_ORDER E,  PH_DISP_LOCN F,MP_PATIENT G    WHERE  G.PATIENT_ID=E.PATIENT_ID AND   A.FACILITY_ID = E.ORDERING_FACILITY_ID AND A.FACILITY_ID = F.FACILITY_ID AND    A.DISP_LOCN_CODE = F.DISP_LOCN_CODE AND A.DISP_DRUG_CODE=B.DRUG_CODE AND    A.DISP_UOM_CODE = C.UOM_CODE  AND  A.ORDER_ID=E.ORDER_ID AND B.DRUG_CODE=D.ITEM_CODE AND   B.DISP_AGAINST_DAMAGE_YN='Y' AND  A.FACILITY_ID=? AND    E.PATIENT_ID=? AND  (A.ADDED_DATE) BETWEEN TO_DATE(?,'DD/MM/YYYY') AND    TO_DATE(?,'DD/MM/YYYY')+.99999 AND   A.DISP_DRUG_CODE = NVL(?,A.DISP_DRUG_CODE)    GROUP BY A.ORDER_ID,A.ORDER_LINE_NO,A.DISP_DRUG_CODE, B.DISP_AGAINST_DAMAGE_YN, B.DRUG_DESC,     C.SHORT_DESC, A.ITEM_CODE, A.DISP_UOM_CODE, E.PATIENT_CLASS, D.UNIT_COST,     A.ADDED_BY_ID, A.DISP_LOCN_CODE, F.SHORT_DESC, F.IP_FILL_PRD_AHEAD,     F.IP_FILL_PRD_UNIT, G.PATIENT_NAME, G.SEX, G.DATE_OF_BIRTH    ORDER BY A.ORDER_ID,A.ORDER_LINE_NO";

			pstmt1	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_REISSUE_MEDICATION_SELECT13"));
			pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REISSUE_MEDICATION_SELECT5")) ;   
			//AND trunc(h.end_date_time) >= trunc(sysdate) added for ML-BRU-SCF-0189 [IN032619] Issue 2	
	        // a.disp_locn_code = ? , e.ordering_facility_id = ?  AND a.facility_id = ? commended for FD-BRU-CRF-092	// and e.patient_class commented for ML-BRU-SCF-0510 [IN:035786]	  
			  
			pstmt.setString(1,getLanguageId()); //Added by sandhya regarding incident :25728===05/JAN/2011
			//pstmt.setString(2,this.orderingfacilityid);
			//pstmt.setString(3,login_facility_id);
			pstmt.setString(2,patientid.trim());			
			pstmt.setString(3,disp_from.trim());
			pstmt.setString(4,disp_to.trim());
			pstmt.setString(5,DrugCode);		
			pstmt.setString(6,getLanguageId());
			//pstmt.setString(7,getPatientClass()); //commented for ML-BRU-SCF-0510 [IN:035786]
			//pstmt.setString(10,getDispLocnCode());
			pstmt.setString(7,patientid.trim()); //changed index from 8 to 7 for ML-BRU-SCF-0510 [IN:035786]
			resultSet = pstmt.executeQuery() ;
			while ( resultSet.next() ) {
				max_reissuable_qty= Integer.parseInt(resultSet.getString("MAX_REISSUABLE_QTY"));
				if(max_reissuable_qty > 0){
					result1.add(resultSet.getString("SHORT_DESC"));//0
					result1.add(resultSet.getString("DISP_LOCN_CODE"));

					pstmt1.setString(1,resultSet.getString("ORDER_ID"));
					resultSet1	=	pstmt1.executeQuery();
					while(resultSet1.next()) {
						dispense_no	=	resultSet1.getString("DISP_NO");
					}
					closeResultSet( resultSet1 ) ;

					result1.add(dispense_no);

					result1.add("");
					result1.add(resultSet.getString("ADDED_BY_ID"));
					result1.add(resultSet.getString("patient_name") + "," + resultSet.getString("SEX") + "," + resultSet.getString("AGE"));//5
					result1.add(resultSet.getString("DISP_DRUG_CODE"));
					result1.add(resultSet.getString("DRUG_DESC"));
					result1.add(resultSet.getString("MAX_REISSUABLE_QTY"));
					result1.add(resultSet.getString("DISP_LOCN_CODE"));
					result1.add(resultSet.getString("ITEM_CODE"));//10
					result1.add(resultSet.getString("DISP_AGAINST_DAMAGE_YN"));
					result1.add(resultSet.getString("ORDER_ID"));
					result1.add(resultSet.getString("ORDER_LINE_NO"));
					result1.add("");
					result1.add(resultSet.getString("DISP_UOM_CODE"));//15
					result1.add(resultSet.getString("PATIENT_CLASS"));
					result1.add(resultSet.getString("IP_FILL_PRD_AHEAD"));
					result1.add(resultSet.getString("IP_FILL_PRD_UNIT"));
					result1.add(resultSet.getString("UNIT_COST"));
					result1.add(resultSet.getString("ENCOUNTER_ID"));//20
					result1.add(resultSet.getString("DISCHARGE_IND"));
					result1.add(resultSet.getString("ORDERING_FACILITY_ID")); // Added for FD-BRU-CRF-092
					result1.add(resultSet.getString("FACILITY_NAME")); // Added for FD-BRU-CRF-092
					result1.add(resultSet.getString("REISSUE_TYPE_IND"));//Added for Bru-HIMS-CRF-405[IN 044830]
					result1.add(resultSet.getString("REISSUE_COUNT_BY_IND"));//25//Added for Bru-HIMS-CRF-405[IN 044830]
					result1.add(resultSet.getString("REISSUE_COUNT"));//Added for Bru-HIMS-CRF-405[IN 044830]
					result1.add(checkForNull(resultSet.getString("LABEL_CAU_INSTRN1_ENG")));//Added for [IN:052983] start
					result1.add(checkForNull(resultSet.getString("LABEL_CAU_INSTRN2_ENG")));
					result1.add(checkForNull(resultSet.getString("LABEL_SPL_INSTRN1_ENG")));
					result1.add(checkForNull(resultSet.getString("LABEL_SPL_INSTRN2_ENG")));//30
					result1.add(checkForNull(resultSet.getString("LABEL_PAT_INSTRN1_ENG")));
					result1.add(checkForNull(resultSet.getString("LABEL_CAU_INSTRN1_LOC")));
					result1.add(checkForNull(resultSet.getString("LABEL_CAU_INSTRN2_LOC")));
					result1.add(checkForNull(resultSet.getString("LABEL_SPL_INSTRN1_LOC")));
					result1.add(checkForNull(resultSet.getString("LABEL_SPL_INSTRN2_LOC")));//35
					result1.add(checkForNull(resultSet.getString("LABEL_PAT_INSTRN1_LOC")));//Added for [IN:052983] end
				}
			}

			map.put("REASON",result);
			map.put("DETAIL",result1);
		}
		catch ( Exception e ) {
			result.add(e.toString());
			e.printStackTrace() ;
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

		return map;
	}//end of function getReissueResult

	public ArrayList getBatchDetails(String dispno, String drugcode, String srlno ) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList result1=new ArrayList();
        try {
            connection = getConnection() ;
			//	To get the Reissue reasons
			String sql=PhRepository.getPhKeyValue("SQL_PH_REISSUE_MEDICATION_SELECT6");
			pstmt= connection.prepareStatement(  sql) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,dispno);
			pstmt.setString(3,srlno);
			pstmt.setString(4,drugcode);
			pstmt.setString(5,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while ( resultSet.next() ) {
				result1.add(resultSet.getString("EXPIRY_DATE"));
				result1.add(resultSet.getString("BATCH_ID"));
				result1.add(resultSet.getString("TRADE_NAME"));
				result1.add(resultSet.getString("MANU_NAME"));
				result1.add(resultSet.getString("BIN_LOCATION_CODE"));
				result1.add(resultSet.getString("AVL_QTY"));
			}
		}
		catch ( Exception e ) {
			result1.add(e.toString());
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
		return result1;
	}//end of function getReissueResult

	public void setAll(Hashtable recordSet) {
		if(recordSet.containsKey("mode")){
			setMode((String)recordSet.get("mode")) ;
		}
	}

	public void setData(LinkedHashMap drug, HashMap batch){//Changed to HashMap for Bru-HIMS-CRF-405[IN:044830]  //HashMap, ArrayList changed to LinkedHapMap & HashMap for [IN:049860]
		this.drug = drug;
		this.batch = batch;

	}//end of function storedata

	public LinkedHashMap getDrug(){//Changed to HashMap for Bru-HIMS-CRF-405[IN:044830]  //HashMap changed to LinkedHashMap for [IN:049860]
		return this.drug;
	}

	public HashMap getBatch(){ //ArrayList changed to HashMap for [IN:049860]
		return this.batch;
	}
	public void clearDrugData(){
		this.drug = null;
		this.batch = null;
	
	}

	public HashMap insert(){
		HashMap map		= new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		HashMap sqlMap	=new HashMap();
		HashMap tabData = new HashMap() ;
		

		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet selData		= null;
		PreparedStatement pstmt1= null;
		ResultSet selData1		= null;
		try {
			connection		= getConnection() ;
			String dispno	= "";
			pstmt1			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT33")) ;
			/*selData1 =  pstmt.executeQuery() ;
			while(selData1.next())
			dispno = selData1.getString("NEXTVAL");
			setNewDispNo(dispno);
			dispno = (Integer.parseInt(dispno)) + "";
			closeResultSet( selData ) ;
			closeStatement( pstmt ) ;*/
			selData		= null;
			pstmt		= null;
			//String sql  = PhRepository.getPhKeyValue("SQL_PH_REISSUE_MEDICATION_SELECT9");
			pstmt		= connection.prepareStatement("SELECT FACILITY_ID, DISP_NO, TO_CHAR(DISP_DATE_TIME,'dd/mm/yyyy hh24:mi')DISP_DATE_TIME, DISP_LOCN_CODE, ORDER_ID, TO_CHAR(ORD_DATE_TIME,'dd/mm/yyyy hh24:mi')ORD_DATE_TIME, PATIENT_ID, ENCOUNTER_ID, PATIENT_CLASS, LOCN_TYPE, LOCN_CODE, ROOM_TYPE, ROOM_NO, BED_NO, BED_CLASS, BED_TYPE, SPECIALITY_CODE, ATTEND_PRACTITIONER_ID, PRES_PHYSICIAN_ID, DISPENSED_BY, TO_CHAR(DISPENSED_DATE_TIME,'dd/mm/yyyy hh24:mi')DISPENSED_DATE_TIME, AUTHORIZED_BY, TO_CHAR(DISP_AUTHORIZED_DATE_TIME,'dd/mm/yyyy hh24:mi')DISP_AUTHORIZED_DATE_TIME, DELIVERED_YN, DELIVERED_BY, TO_CHAR(DELIVERED_DATE_TIME,'dd/mm/yyyy hh24:mi')DELIVERED_DATE_TIME, COLLECTED_BY, RECEIVED_YN, RECEIVED_BY, TO_CHAR(RECEIVED_DATE_TIME,'dd/mm/yyyy hh24:mi')RECEIVED_DATE_TIME, REF_DISP_NO_FOR_REISSUE, DISP_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID  FROM ph_disp_hdr WHERE /*FACILITY_ID=? AND */ DISP_NO=?") ;
			ArrayList updateData			 = new ArrayList();
			//String order_id				 = "";
			String patient_id				 = "";
			String patient_class			 = "";
			String locn_code				 = "";
			String encounter_id				 = ""; 
			HashMap disp_no_for_order_id     = new HashMap();
			String old_disp_no				 = "";
			ArrayList insertData             = new ArrayList() ;
			ArrayList headerData             = new ArrayList() ;
			ArrayList temp_update_data		 = new ArrayList() ;
			ArrayList tempkey		 = new ArrayList() ;//Added for Bru-HIMS-CRF-405[IN:044830]
			ArrayList arrtemp		 = new ArrayList() ;//Added for Bru-HIMS-CRF-405[IN:044830]
			Hashtable new_disp_no_for_order_id =	new Hashtable();
			String token_series_code		 = "";
			if (getPatientClass().equals("OP")|| getPatientClass().equals("EM")){
				token_series_code			 =  this.token_series_code;	
			}
			String token_no					 = "";
			String bl_interface_yn			 =   checkforbillinginterface();

			/* if(drug.size()>0){
				selData1 =  pstmt1.executeQuery() ;
				while(selData1.next())
					dispno = selData1.getString("NEXTVAL");
				setNewDispNo(dispno);
				dispno = (Integer.parseInt(dispno)) + "";
			}*/
			if(drug!=null && drug.size()>0){//Added for Bru-HIMS-CRF-405[IN:044830]
			    Set <String>keyset=drug.keySet();
			    for (String itemKey : keyset) {
			    	tempkey.add(itemKey);
			    }
			}

			for(int i=0;i<drug.size();i++){
				//pstmt.setString(1,login_facility_id);
				arrtemp = (ArrayList)(drug.get(tempkey.get(i)));//Added for Bru-HIMS-CRF-405[IN:044830]
				old_disp_no = ((String)arrtemp.get(0)).trim();//Changed for Bru-HIMS-CRF-405[IN:044830]
				pstmt.setString(1,old_disp_no);
				selData     = pstmt.executeQuery() ;

				insertData             = new ArrayList() ;
				temp_update_data	   = new ArrayList() ;

				//pstmt1= connection.prepareStatement(sqlsel) ;
				selData1 =  pstmt1.executeQuery() ;

				while(selData1.next())
					dispno = selData1.getString("NEXTVAL");
				setNewDispNo(dispno);
				dispno = (Integer.parseInt(dispno)) + "";
				while ( selData.next() ) {
					temp_update_data.add(dispno);
					temp_update_data.add("Reissued"); 
					temp_update_data.add(old_disp_no.trim());
					temp_update_data.add(login_facility_id);

					insertData.add(login_facility_id);
					insertData.add(dispno);
					//	insertData.add(selData.getString("DISP_LOCN_CODE"));
					insertData.add(getDispLocnCode()); // Added for FD-BRU-CRF-092
					insertData.add(selData.getString("ORDER_ID"));
					disp_no_for_order_id.put(old_disp_no,selData.getString("ORDER_ID"));
					new_disp_no_for_order_id.put(selData.getString("ORDER_ID"),dispno);
					//	order_id = selData.getString("ORDER_ID");
					insertData.add(selData.getString("ORD_DATE_TIME"));
					insertData.add(selData.getString("PATIENT_ID"));
					patient_id = selData.getString("PATIENT_ID");
					insertData.add(selData.getString("ENCOUNTER_ID"));
					encounter_id  = selData.getString("ENCOUNTER_ID");
					patient_class = selData.getString("PATIENT_CLASS");
					insertData.add(patient_class);                          
					insertData.add(selData.getString("LOCN_TYPE"));
					locn_code     = selData.getString("LOCN_CODE");
					insertData.add(locn_code);
					insertData.add(selData.getString("ROOM_TYPE"));
					insertData.add(selData.getString("ROOM_NO"));
					insertData.add(selData.getString("BED_NO"));
					insertData.add(selData.getString("BED_CLASS"));
					insertData.add(selData.getString("BED_TYPE"));
					insertData.add(selData.getString("SPECIALITY_CODE"));
					insertData.add(selData.getString("ATTEND_PRACTITIONER_ID"));
					insertData.add(selData.getString("PRES_PHYSICIAN_ID"));
					insertData.add(login_by_id);
					insertData.add(selData.getString("AUTHORIZED_BY"));
					insertData.add(selData.getString("DISP_AUTHORIZED_DATE_TIME"));
					insertData.add(selData.getString("DELIVERED_YN"));
					insertData.add(selData.getString("DELIVERED_BY"));
					insertData.add(selData.getString("DELIVERED_DATE_TIME"));
					insertData.add(selData.getString("COLLECTED_BY"));
					insertData.add(selData.getString("RECEIVED_YN"));
					insertData.add(selData.getString("RECEIVED_BY"));
					insertData.add(selData.getString("RECEIVED_DATE_TIME"));
					insertData.add(selData.getString("DISP_NO") );
					insertData.add(selData.getString("DISP_REMARKS"));
					insertData.add(login_by_id);
					insertData.add(login_at_ws_no);
					insertData.add(login_facility_id);
					insertData.add(login_by_id);
					insertData.add(login_at_ws_no);
					insertData.add(login_facility_id);
					insertData.add("P");
					insertData.add("");
				}

				headerData.add(insertData);
				updateData.add(temp_update_data);
				closeResultSet( selData1 ) ;//3/21/2021
			}
            closeResultSet( selData ) ;
			closeResultSet( selData1 ) ;
	
			ArrayList insertDataDtl = new ArrayList();
			ArrayList temp = null;
			ArrayList insertData1 = null;
			String pres_drug_code = ""; //ML-BRU-SCF-1888
			String orderId = "";   //AAKH-CRF-0117
			String orderLineNum = ""; //AAKH-CRF-0117
			String approval_no = "";//AAKH-CRF-0117
			String dispNo	   = "";//AAKH-CRF-0117
			for(int i=0; i< drug.size(); i++){
				insertData1 = new ArrayList() ;
				temp = (ArrayList)drug.get(tempkey.get(i));//Changed for Bru-HIMS-CRF-405[IN:044830]
				 
				insertData1.add(login_facility_id);
				insertData1.add((String)new_disp_no_for_order_id.get((String)disp_no_for_order_id.get(temp.get(0))));
				insertData1.add((i+1)+"");
				insertData1.add((String)disp_no_for_order_id.get(temp.get(0)));
				insertData1.add(temp.get(7));
				pres_drug_code = getPresDrugCode(connection,(String)disp_no_for_order_id.get((String)temp.get(0)),(String)temp.get(7),(String)temp.get(4)); //ML-BRU-SCF-1888
				if(pres_drug_code!=null && !pres_drug_code.equals(""))
					insertData1.add(pres_drug_code);
				else
					insertData1.add(temp.get(4));
				
				 orderId		= (String) disp_no_for_order_id.get(temp.get(0).toString()); //AAKH-CRF-0117
				 orderLineNum = (String) temp.get(7);//AAKH-CRF-0117 

				insertData1.add(login_facility_id);
				//insertData1.add(temp.get(8));
				insertData1.add(getDispLocnCode());// Added for FD-BRU-CRF-092
				insertData1.add(getDispLocnCode()); //Added for FD-BRU-CRF-092
				//insertData1.add(temp.get(6));
				insertData1.add(temp.get(4));				
				insertData1.add(temp.get(5));
				insertData1.add(temp.get(9));
				insertData1.add(temp.get(2));
				insertData1.add(temp.get(9));
				insertData1.add("");
				insertData1.add(temp.get(1));
				insertData1.add(login_by_id);
				insertData1.add(login_at_ws_no);
				insertData1.add(login_facility_id);
				insertData1.add(login_by_id);
				insertData1.add(login_at_ws_no);
				insertData1.add(login_facility_id);
				insertData1.add("");//Added for [IN:052983] start
				insertData1.add("");
				insertData1.add(checkForNull((String)temp.get(14)));
				insertData1.add(checkForNull((String)temp.get(15)));
				insertData1.add(checkForNull((String)temp.get(16)));
				insertData1.add(checkForNull((String)temp.get(17)));
				insertData1.add(checkForNull((String)temp.get(18)));
				insertData1.add(checkForNull((String)temp.get(19)));
				insertData1.add(checkForNull((String)temp.get(20)));
				insertData1.add(checkForNull((String)temp.get(21)));
				insertData1.add(checkForNull((String)temp.get(22)));
				insertData1.add(checkForNull((String)temp.get(23)));//Added for [IN:052983] end
				if(approvalNo!=null && approvalNo.size()>0){ //AAKH-CRF-0117 - start
						approval_no = (String)approvalNo.get(orderId+orderLineNum+(String)temp.get(0));
				}
				if(approval_no==null)
					approval_no = "";
				dispNo=(String)new_disp_no_for_order_id.get((String)disp_no_for_order_id.get(temp.get(0)));
				setNewApprovalNo(orderId,orderLineNum,dispNo,approval_no); //AAKH-CRF-0117 - end
 				insertDataDtl.add(insertData1);
				this. print_data.add((String)new_disp_no_for_order_id.get((String)disp_no_for_order_id.get(temp.get(0))));
				this.print_data.add((i+1)+"");
				this.print_data.add(locn_code);
				this.print_data.add(patient_id);
				this.print_data.add(patient_class);
				this.print_data.add(login_facility_id);
				this.print_data.add(login_by_id);
				this.print_data.add((String)disp_no_for_order_id.get(temp.get(0)));
			}

			ArrayList insertDataBatch = new ArrayList();
			int srlno = 0;
			ArrayList insertData2 = null;
			StringTokenizer STbatchids = null;
			StringTokenizer STexpdate  = null;
			StringTokenizer STlocncode = null;
			StringTokenizer STtradeid  = null;
			StringTokenizer STqty      = null;
			String batchUOM = ""; //Added for HSA-SCF-0221
			int srlbno        = 0;
			ArrayList temp_1 = null;
			HashMap BaseAndIssueUOMQty = null;
			for(int i=0; i< drug.size(); i++){
				insertData2      = new ArrayList() ;
				temp             = (ArrayList)batch.get(tempkey.get(i)); //get(i) changed to tempkey.get(i) for [IN:049860]
				STbatchids = new StringTokenizer((String)temp.get(0),"~");
				STexpdate  = new StringTokenizer((String)temp.get(1),"~");
				STlocncode = new StringTokenizer((String)temp.get(2),"~");
				STtradeid  = new StringTokenizer((String)temp.get(3),"~");
				STqty      = new StringTokenizer((String)temp.get(4),"~");
				batchUOM = (String)temp.get(5); //Added for HSA-SCF-0221
				srlbno        = 0;
				temp_1  = (ArrayList)drug.get(tempkey.get(i));//Changed for Bru-HIMS-CRF-405[IN:044830]
				srlno             = srlno + 1;
				while (STbatchids.hasMoreElements()){
					srlbno = srlbno +1;
					insertData2.add(login_facility_id);
					insertData2.add((String)new_disp_no_for_order_id.get((String)disp_no_for_order_id.get(temp_1.get(0))));
					insertData2.add(srlno+"");
					insertData2.add(srlbno+"");
					insertData2.add(temp_1.get(8));//Changed for Bru-HIMS-CRF-405[IN:044830]
					//insertData2.add(((ArrayList)drug.get(i)).get(6));
					insertData2.add(getDispLocnCode());//Added for FD-BRU-CRF-092
					insertData2.add(temp_1.get(4));//Changed for Bru-HIMS-CRF-405[IN:044830]
					insertData2.add(temp_1.get(5));//Changed for Bru-HIMS-CRF-405[IN:044830]
					insertData2.add(STbatchids.nextToken());
					insertData2.add(STexpdate.nextToken());
					//insertData2.add(STqty.nextToken());
					BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection, (String)(temp_1.get(5)), (String)(temp_1.get(6)), STqty.nextToken(),  (String) (temp_1.get(9)) );
					insertData2.add((String)BaseAndIssueUOMQty.get("BASE_QTY")); 
					insertData2.add("");
					insertData2.add(login_by_id);
					insertData2.add(login_at_ws_no);
					insertData2.add(login_facility_id);
					insertData2.add(login_by_id);
					insertData2.add(login_at_ws_no);
					insertData2.add(login_facility_id);
					insertData2.add(STlocncode.nextToken());
					insertData2.add(STtradeid.nextToken());
					//insertData2.add(temp_1.get(9));//ADDED DISP_QTY_UOM VALUE FOR PH_DISP_DRUG_BATCH TABLE INSERTION //Commented for HSA-SCF-0221
					insertData2.add(batchUOM);//Added for HSA-SCF-0221
				}
				insertDataBatch.add(insertData2);
			}

			tabData.put("hdr", headerData);
			tabData.put("dtl", insertDataDtl);
			tabData.put("batch", insertDataBatch);
			tabData.put("uhdr", updateData);
			tabData.put("LanguageId",getLanguageId());
			tabData.put( "Ordering_facility_id",this.orderingfacilityid);
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_INSERT1", PhRepository.getPhKeyValue( "SQL_PH_DISP_MEDICATION_HRD_INSERT1" ) );
			sqlMap.put("SQL_PH_REISSUE_MEDICATION_UPDATE_HDR", PhRepository.getPhKeyValue( "SQL_PH_REISSUE_MEDICATION_UPDATE_HDR" ) );
			//sqlMap.put("SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT", PhRepository.getPhKeyValue( "SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT" ) );
			sqlMap.put("SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT","INSERT INTO PH_DISP_DTL (FACILITY_ID, DISP_NO, SRL_NO, ORDER_ID, ORDER_LINE_NO, PRES_DRUG_CODE, ORDERING_FACILITY_ID, DISP_LOCN_CODE, STORE_CODE, DISP_DRUG_CODE, ITEM_CODE, STK_UOM_CODE, DISP_QTY, DISP_UOM_CODE, RETURNED_QTY, REISSUE_REASON_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, FILL_REMARKS_CODE, FILL_TASK_FINDING , LABEL_CAU_INSTRN1_ENG, LABEL_CAU_INSTRN2_ENG, LABEL_SPL_INSTRN1_ENG, LABEL_SPL_INSTRN2_ENG, LABEL_PAT_INSTRN1_ENG, LABEL_CAU_INSTRN1_LOC, LABEL_CAU_INSTRN2_LOC, LABEL_SPL_INSTRN1_LOC, LABEL_SPL_INSTRN2_LOC, LABEL_PAT_INSTRN1_LOC, DELIVERY_REMARKS_CODE, DELIVERY_TASK_FINDING, ALLOCATE_REMARKS_CODE, ALLOCATE_TASK_FINDING, BL_INCL_EXCL_OVERRIDE_VALUE, BL_INCL_EXCL_OVERRIDE_REASON, PRES_REMARK_CODE, DOC_SRL_NO, DSN_REFERENCE,APPROVAL_NO)  VALUES ( ?,?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?,?, SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");//modified for AAKH-CRF-0117 

			sqlMap.put("SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT", PhRepository.getPhKeyValue( "SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT" ) );
			sqlMap.put("SQL_PH_REISSUE_MEDICATION_UPDATE1",PhRepository.getPhKeyValue( "SQL_PH_REISSUE_MEDICATION_UPDATE1"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_BL_SELECT2",PhRepository.getPhKeyValue( "SQL_PH_DISP_MEDICATION_BL_SELECT2"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_BL_SELECT1",PhRepository.getPhKeyValue( "SQL_PH_DISP_MEDICATION_BL_SELECT1"));
			
			if(!token_series_code.equals("")){
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES",PhRepository.getPhKeyValue( "SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES"));
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_SELECT15",PhRepository.getPhKeyValue( "SQL_PH_REG_PRESCRIPTIONS_SELECT15"));
				//sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE",PhRepository.getPhKeyValue( "SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE"));
				//sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_SELECT14",PhRepository.getPhKeyValue( "SQL_PH_REG_PRESCRIPTIONS_SELECT14"));
				//sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_UPDATE_DISP_QUEUE_SUMM",PhRepository.getPhKeyValue( "SQL_PH_REG_PRESCRIPTIONS_UPDATE_DISP_QUEUE_SUMM"));
				//sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE_SUMM",PhRepository.getPhKeyValue( "SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE_SUMM"));
				//sqlMap.put("SQL_PH_PRESCRIPTION_SELECT43B",PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_SELECT43B"));
				//sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_INSERT_ORD_FOR_DISP_QUEUE",PhRepository.getPhKeyValue( "SQL_PH_REG_PRESCRIPTIONS_INSERT_ORD_FOR_DISP_QUEUE"));
			}
			//**********************token**************************
			if (drug.size()>0 && !token_series_code.equals("") ){
				HashMap common_det  =  new HashMap(); 
				 common_det.put("LOGIN_AT_WS_NO",login_at_ws_no);
				 common_det.put("LOGIN_FACILITY_ID",login_facility_id);
				 common_det.put("LOGIN_BY_ID",login_by_id);
				 common_det.put("LOGIN_AT_WS_NO",login_at_ws_no);
				 common_det.put("LOGIN_FACILITY_ID",login_facility_id);
				 token_no = InsertTokenDetails( connection,tabData, sqlMap,common_det,disp_locn_code,token_series_code, patient_id, encounter_id,new_disp_no_for_order_id);
			}
				
			//****************stock****************
			String patientclass ="";
			String doctype = getStDocType(getPatientClass());
			if (getPatientClass() == "IP")
					patientclass = "I";
			else
					patientclass = "O";

			HashMap hmHeader = new HashMap();
			HashMap hmCommon = new HashMap();
			hmHeader.put("facility_id",login_facility_id);
			hmHeader.put("doc_type_code",doctype);
			hmHeader.put("doc_no","");
			hmHeader.put("doc_date",getTodaysDate());
			hmHeader.put("doc_ref","");
			//hmHeader.put("store_code",((ArrayList)drug.get(0)).get(6));
			hmHeader.put("store_code",getDispLocnCode());
			hmHeader.put("authorized_by_id","");
			hmHeader.put("cancelled_by_id","");
			hmHeader.put("cancelled_remarks","");
			hmHeader.put("finalized_yn","Y");
			hmHeader.put("gl_interfaced_yn","N");
			hmHeader.put("trn_type","SAL");
			hmHeader.put("add_qty_sal_yn","N");
			hmHeader.put("patient_id",patient_id);
			hmHeader.put("encounter_id",encounter_id);
			hmHeader.put("sal_trn_type",getEncounterPatientClass(encounter_id, patient_id)); //patient_id added for [IN:035667] 
			hmHeader.put("remarks","");
			hmHeader.put("item_class_code","");
			hmHeader.put("module_id","PH");
			hmHeader.put("token_series_code",token_series_code);
			hmHeader.put("token_serial_no",token_no);

			hmCommon.put("login_by_id",login_by_id);
			hmCommon.put("login_at_ws_no",login_by_id);
			hmCommon.put("login_facility_id",login_facility_id);
			
			HashMap hmData    = new HashMap();
			hmData.put("HDR_DATA",hmHeader);
			hmData.put("COMMON_DATA",hmCommon);
			String cost_value = "";
			String itemqty    = "";
			String unitcost   = "";

			HashMap hmDetail	   = new HashMap();
			ArrayList insertDetail = new ArrayList();
			HashMap hmExp	       = null;
			ArrayList InsertExp    = new ArrayList();
			String order_id        = "";
			String order_line_no   = "";
			String bl_override_excl_incl_ind         ="";
			String bl_incl_excl_override_reason_code ="";
			ArrayList temp1    = null;//AAKH-CRF-0117
			ArrayList alTmp		        = new ArrayList();
			HashMap hmDocSrlNo	        = new HashMap();
			String doc_srl_no = "";
			StringTokenizer STQty      = null;	
			HashMap newAppNo = getNewApprovalNo(); //AAKH-CRF-0117
			for(int d = 0; d<drug.size(); d++){
				doc_srl_no = (d+1)+"";
				temp = (ArrayList)batch.get(tempkey.get(d)); //get(d) changed to tempkey.get(d) for [IN:049860]
				temp1 = (ArrayList)drug.get(tempkey.get(d));//AAKH-CRF-0117
				arrtemp = (ArrayList)drug.get(tempkey.get(d));//Added for Bru-HIMS-CRF-405[IN:044830]
				STbatchids = new StringTokenizer((String)temp.get(0),"~");
				STexpdate  = new StringTokenizer((String)temp.get(1),"~");
				STlocncode = new StringTokenizer((String)temp.get(2),"~");
				STtradeid  = new StringTokenizer((String)temp.get(3),"~");
				STQty      = new StringTokenizer((String)temp.get(4),"~");
				orderId		= (String)temp1.get(13); //AAKH-CRF-0117 - start
				orderLineNum = (String) temp1.get(7);//AAKH-CRF-0117 
				dispNo=(String)new_disp_no_for_order_id.get((String)disp_no_for_order_id.get(temp1.get(0)));
				if(newAppNo!=null && newAppNo.size()>0)
						approval_no = (String)newAppNo.get(orderId+orderLineNum+dispNo);

					if(approval_no==null)
						approval_no = ""; //AAKH-CRF-0117 - end
				hmDetail   =  new HashMap();
				itemqty    = (String)(arrtemp.get(2));//Changed for Bru-HIMS-CRF-405[IN:044830]
				unitcost   = getItemCost( (String)(arrtemp.get(5)) , (String) (arrtemp.get(6)), itemqty , (String)(arrtemp.get(11)) );//Changed for Bru-HIMS-CRF-405[IN:044830]
				//cost_value	  =	Math.round(Integer.parseInt(itemqty) * Double.parseDouble(unitcost)*1000)+"";
				//cost_value	  = (Double.parseDouble(cost_value)/1000)+"";
				//float unitval = Float.parseFloat(cost_value);
				bl_override_excl_incl_ind         ="";
				bl_incl_excl_override_reason_code ="";
				order_id                          =(String)disp_no_for_order_id.get((String)(arrtemp.get(0))); //Changed for Bru-HIMS-CRF-405[IN:044830]           

				if(bl_interface_yn.equals("Y")){
					order_id      = (String)disp_no_for_order_id.get((String)(arrtemp.get(0)));//Changed for Bru-HIMS-CRF-405[IN:044830]
					order_line_no = (String)(arrtemp.get(7));//Changed for Bru-HIMS-CRF-405[IN:044830]
					pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT162"));
					pstmt.setString(1,order_id);
					pstmt.setString(2,order_line_no);
					selData	= pstmt.executeQuery() ;
					if(selData.next()){
						bl_override_excl_incl_ind         = checkForNull(selData.getString("BL_INCL_EXCL_OVERRIDE_VALUE"));
						bl_incl_excl_override_reason_code = checkForNull(selData.getString("BL_INCL_EXCL_OVERRIDE_REASON"));							
					}
					hmDetail.put("p_overridden_excl_incl_ind",bl_override_excl_incl_ind);
					hmDetail.put("p_overridden_action_reason",bl_incl_excl_override_reason_code);
				}
				closeResultSet( selData ) ;
				hmDetail.put("doc_srl_no",doc_srl_no);
				hmDetail.put("item_code",(arrtemp.get(5)));//Changed for Bru-HIMS-CRF-405[IN:044830]
				hmDetail.put("sal_category","");
				hmDetail.put("hcp_issue_factor","");
				BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection, (String)(arrtemp.get(5)),  (String)(arrtemp.get(6)), itemqty,  (String)(arrtemp.get(9)) );//Changed for Bru-HIMS-CRF-405[IN:044830]
				hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY"));
				hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
				cost_value	=	Math.round(Double.parseDouble((String)BaseAndIssueUOMQty.get("ISSUE_QTY")) * Double.parseDouble(unitcost)*1000)+"";
				cost_value	=   (Double.parseDouble(cost_value)/1000)+"";  
				//hmDetail.put("item_qty", itemqty); //"3");//
				//hmDetail.put("item_sal_value",(unitval+""));//"4.5");//
				//hmDetail.put("item_cost_value",(unitval+""));//"4.5");//
				hmDetail.put("next_due_date","");
				hmDetail.put("stock_item_yn","Y");
				hmDetail.put("remarks","");
				hmDetail.put("item_unit_cost",unitcost);//"1.5");//					
				hmDetail.put("item_sal_value",unitcost);//"4.5");//Changed from cost_value to item_cost for MMS-SCF-0275 [IN:047212]
				hmDetail.put("item_cost_value",unitcost);//"4.5");//Changed from cost_value to item_cost for MMS-SCF-0275 [IN:047212]
				hmDetail.put("item_unit_price",unitcost);//"1.5");//
				hmDetail.put("uom_code",(arrtemp.get(9)));//Changed for Bru-HIMS-CRF-405[IN:044830]
				hmDetail.put("mode","1");
				hmDetail.put("take_home_yn",getDischargeYN(order_id)); // For Discharge Indicator
				hmDetail.put("FACILITY_STR_FOR_BL",(String)(arrtemp.get(12))+"|"+login_facility_id); //Disp_facility_id//Changed for Bru-HIMS-CRF-405[IN:044830]
				hmDetail.put("approval_no",approval_no);//AAKH-CRF-0117
				insertDetail.add(hmDetail);
				//HashMap hmExp	=	null;
				//ArrayList InsertExp = new ArrayList();
				while(STbatchids.hasMoreElements()){
					hmExp =new HashMap();
					hmExp.put("doc_srl_no",doc_srl_no);
					//hmExp.put("store_code",((ArrayList)drug.get(0)).get(6));//"PHAR");//
					hmExp.put("store_code",getDispLocnCode()); // added for FD-BRU-CRF-092
					hmExp.put("item_code",(arrtemp.get(5)));//"BUSCO");//
					hmExp.put("batch_id",STbatchids.nextToken());//"ee45");//
					hmExp.put("bin_location_code",STlocncode.nextToken());//"CSB1");//
					hmExp.put("expiry_date_or_receipt_date",STexpdate.nextToken());//"31/12/2003");//
					hmExp.put("trade_id",STtradeid.nextToken());//"ALCIPRO");//
				   //done for 551.3 CRF
					
				   BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection, (String)(arrtemp.get(5)), (String)(arrtemp.get(6)), STQty.nextToken(),  (String) (arrtemp.get(9)) );
					hmExp.put("sal_item_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));

					//hmExp.put("sal_item_qty",STQty.nextToken());//"3");//
					hmExp.put("ret_item_qty","0");
					InsertExp.add(hmExp);
				}
				alTmp        = (ArrayList)drug.get(tempkey.get(d));						
				String sOrderId		= (String) disp_no_for_order_id.get(alTmp.get(0).toString());
				String sOrderLineNo = (String) alTmp.get(7);
				String sItemCode	= (String) alTmp.get(5);
				hmDocSrlNo.put(sOrderId+"$"+sOrderLineNo+"$"+sItemCode,doc_srl_no);
			}//for 

			if(drug.size()>0){
				HashMap stock_dtls = new HashMap();
			
				stock_dtls.put("InsertDetail",insertDetail);
				stock_dtls.put("InsertExp",InsertExp);
				HashMap tabdata1 = new HashMap();
				tabdata1.put("patient_id",patient_id);
				tabdata1.put("encounter_id",encounter_id);
				tabdata1.put("patient_class",patientclass);
				tabdata1.put("login_by_id",login_by_id);
				tabdata1.put("login_at_ws_no",login_at_ws_no);
				tabdata1.put("facility_id",login_facility_id);
				//tabdata1.put("store_code",((ArrayList)drug.get(0)).get(6));
				tabdata1.put("store_code",getDispLocnCode()); // Added for FD-BRU-CRF-092
				tabdata1.put("doct_ype",doctype);
				tabdata1.put("disp_no",dispno);
				tabdata1.put("LanguageId",getLanguageId());
				tabdata1.put( "Ordering_facility_id",this.orderingfacilityid);
				map = updateStock(tabdata1,stock_dtls,connection,sqlMap,token_series_code,token_no);
				tabData.put("doc_no",(String)map.get("doc_no"));
				tabData.put("doc_type_code",(String)map.get("doc_type_code"));
				tabData.put("disp_no",dispno);
				tabData.put("facility_id",login_facility_id);
				tabData.put("token_serial_no",token_no);
				tabData.put("token_series_code",token_series_code);					
				tabData.put("facility_id",login_facility_id);
				//tabData.put("store_code",((ArrayList)drug.get(0)).get(6));
				tabData.put("store_code",getDispLocnCode()); // added for FD-BRU-CRF-092
				tabData.put("patient_class",patient_class);
			}
			tabData.put("HmDocSrlNo",hmDocSrlNo);

			if( ((Boolean) map.get( "result")).booleanValue() ){
				map=null;
				map=localInsert(tabData,sqlMap,connection ); 
			  //if(bl_interface_yn.equals("Y") && !getPatientClass().equals("IP")&& !getPatientClass().equals("DC")&&disp_cash_coll_stage.equals("D")){ //if condition Edited as bellow for SRR20056-SCF-7639 ICN027720
				String tmpdisp_cash_coll_stage = "";
				if(getPatientClass().equals("IP")&& getPatientClass().equals("DC"))
					tmpdisp_cash_coll_stage = getDispCashCollStage();
				else 
					tmpdisp_cash_coll_stage = getDispCashCollStageOP();

				if(bl_interface_yn.equals("Y") && tmpdisp_cash_coll_stage.equals("D")){ 
					String bl_det=getBillingDetails(connection,this.orderingfacilityid,(String)(arrtemp.get(6)),(String)tabData.get("doc_type_code"),(String)tabData.get("doc_no"),login_by_id,login_at_ws_no,patient_id,encounter_id);
					setBLDetails(bl_det);
				}
				if( ((Boolean) map.get( "result")).booleanValue() ){
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"PH") ) ;
				map.put("flag",token_no);
					connection.commit();
				}
				else{
					connection.rollback();
					map.put("result",new Boolean( false ));    
					map.put( "message", (String)map.get("message") ) ;
				}
			} 
			else {
				 connection.rollback();
				 map.put( "message", (String)map.get("message") ) ;
				 map.put("result",new Boolean( false ));
			}
		}
		catch (Exception e) {
			e.printStackTrace() ;
			try{
				 connection.rollback();
				 map.put( "message", (String)map.get("message") ) ;
				 map.put("result",new Boolean( false )); 
			 }
			 catch (Exception ee) {
				  ee.printStackTrace() ;
			}
		}
		finally {
			try {
				closeResultSet( selData ) ;
				closeStatement( pstmt ) ;
				closeResultSet( selData1 ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return map;
	}

	public String InsertTokenDetails(Connection connection,HashMap tabData ,HashMap sqlMap,HashMap common_det,String disp_locn_code,String token_series_code,String patient_id,String encounter_id,Hashtable new_disp_no_for_order_id){
       // PreparedStatement pstmt_update=null,pstmt_insert = null,pstmt_select=null;
		PreparedStatement	pstmt_update3 = null; 
	    //ResultSet resultSet         = null ;
		String next_token_series_no = "";
        String login_by_id				=(String) common_det.get("LOGIN_BY_ID");
		String login_at_ws_no			=(String) common_det.get("LOGIN_AT_WS_NO");
		String login_facility_id		=(String) common_det.get("LOGIN_FACILITY_ID");
		try{
		    next_token_series_no = getNextTokenSeriesNo(connection, sqlMap,login_facility_id,disp_locn_code,token_series_code,(String)tabData.get("LanguageId") );
			//Update Token Series...
			pstmt_update3 = connection.prepareStatement( (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES") ) ;
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
			pstmt = connection.prepareStatement( (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_SELECT15" ) );
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
			}catch(Exception es){es.printStackTrace();
			}
		}
		return next_token_series_no;
	}


	public HashMap updateStock(HashMap tabData,HashMap stock_dtls,Connection connection,HashMap sqlMap,String token_series_code,String token_no) throws Exception {
		HashMap map	= null;
		//	Stock Insertion starts
		HashMap hmHeader		=	new HashMap();
		HashMap hmCommon		=	new HashMap();
		HashMap hmData			=	new HashMap();
		ArrayList language_data =  new ArrayList();
		ArrayList insertDetail	=	(ArrayList)stock_dtls.get("InsertDetail");
		ArrayList insertExp		=	(ArrayList)stock_dtls.get("InsertExp");
		String LanguageId		=  (String)tabData.get("LanguageId");
		//PreparedStatement pstmt_update_disp_hdr_tmp	=	null;
		hmHeader.put("facility_id",login_facility_id);
		hmHeader.put("doc_type_code",tabData.get("doct_ype"));
		hmHeader.put("doc_no","");
		hmHeader.put("doc_date",getTodaysDate());
		hmHeader.put("doc_ref","");
		//hmHeader.put("store_code",tabData.get("store_code"));
        hmHeader.put("store_code",getDispLocnCode()); // added for FD-BRU-CRF-092
		hmHeader.put("cancelled_by_id","");
		hmHeader.put("cancelled_remarks","");
		hmHeader.put("finalized_yn","Y");
		hmHeader.put("gl_interfaced_yn","N");
		hmHeader.put("trn_type","SAL");
		hmHeader.put("add_qty_sal_yn","N");
		hmHeader.put("patient_id",(String)tabData.get("patient_id"));
		hmHeader.put("encounter_id",(String)tabData.get("encounter_id"));
		
		hmHeader.put("remarks","");
		hmHeader.put("item_class_code","");
		hmHeader.put("module_id","PH");
		hmHeader.put("barcode_2d_applicable_yn","N"); //Added for 51029
        if(!token_series_code.equals("")&& !token_no.equals("")){
			hmHeader.put("token_series_code",token_series_code);
			hmHeader.put("token_serial_no",token_no);
		}
        //===============code added for BL interface on 4/22/2006==================
		PreparedStatement pstmt_select	=	null;
		ResultSet resultSet			    = null;	
		String bl_interface_yn			="N";
		try {
			pstmt_select			= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_BL_SELECT2") ) ;
			pstmt_select.setString(1, (String)tabData.get("facility_id"));
			resultSet				= pstmt_select.executeQuery();
			if (resultSet.next() ) {
				bl_interface_yn=resultSet.getString("BL_INTERFACE_YN");
				if(bl_interface_yn==null){
					bl_interface_yn="N";
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
			  closeResultSet( resultSet ) ;
			  closeStatement( pstmt_select ) ;
			}
			catch ( Exception es ){
                es.printStackTrace() ;
			}	
		}
		hmHeader.put("billable_trn_yn",bl_interface_yn);//billable_trn_yn
		//	if(bl_interface_yn.equals("Y"))	{
		PreparedStatement pstmtPC	= null;
		ResultSet resultSetPC		= null;
		String patient_class_PC		= "";
		//String stmtPC				= "";	
		try {
			//stmtPC		= "SELECT DECODE(PATIENT_CLASS, 'IP','I','DC','I','OP','O','EM','O') ENC_PATIENT_CLASS FROM PR_ENCOUNTER WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ? ";
			//	pstmtPC		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_BL_SELECT1") ) ;
			pstmtPC		= connection.prepareStatement("SELECT DECODE(PATIENT_CLASS, 'IP','I','DC','D','OP','O','EM','E','XT','R') ENC_PATIENT_CLASS FROM PR_ENCOUNTER WHERE /* FACILITY_ID = ? AND */ ENCOUNTER_ID = ?"); // FACILITY_ID = ? removed for  FD-BRU-CRF-092
		
			//pstmtPC.setString(1,(String)tabData.get("Ordering_facility_id")); commended for FD-BRU-CRF-092
			pstmtPC.setString(1,(String)tabData.get("encounter_id"));
			resultSetPC	= pstmtPC.executeQuery() ;
			if(resultSetPC.next()){
				patient_class_PC = resultSetPC.getString("ENC_PATIENT_CLASS");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSetPC ) ;
				closeStatement( pstmtPC ) ;
			}
			catch(Exception es){
				 es.printStackTrace() ;
			}
		}
		if(patient_class_PC.equals("") && ((String)tabData.get("encounter_id")).equals("11111")){ //added for ML-BRU-SCF-0510 [IN:035786]
			patient_class_PC="R";
		}
		hmHeader.put("sal_trn_type",patient_class_PC);
		hmHeader.put("authorized_by_id",(String)tabData.get("login_by_id"));

		//	}else{		
		//		hmHeader.put("sal_trn_type",(String)tabData.get("patient_class"));
		//		hmHeader.put("authorized_by_id","");
		//	}

		//=========BL related interface coding ends here====================
		hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
		hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
		hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));
		//hmCommon.put("FACILITY_STR_FOR_BL",(String)tabData.get("Ordering_facility_id")+"|"+(String)tabData.get( "facility_id" ));
        
		language_data.add(LanguageId);
        
		hmData.put("HDR_DATA",hmHeader);
		hmData.put("COMMON_DATA",hmCommon);
		hmData.put("LANGUAGE_DATA",language_data);
		try{
			if(insertDetail.size()!=0) {
				hmData.put("DTL_DATA",insertDetail);
				hmData.put("DTL_EXP_DATA",insertExp);
				StSales	stSales		=	new  StSales();
				map	=	stSales.insertSales(connection,hmData);
				if( ((Boolean) map.get( "result")).booleanValue()){
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"PH")) ;
				} 
				else {
					String msg_id=(String)map.get("msgid");	
					if(msg_id.equals("BATCH_RECORD_NOT_FOUND")||msg_id.equals("NEGATIVE_STOCK")||msg_id.equals("SUSPENDED_BATCH")||msg_id.equals("INSUFFICIENT_BATCH_QTY")){	   
						map.put( "message", getMessage(getLanguageId(),msg_id,"PH") ) ;
					}
					else{
						msg_id= (String)map.get("msgid");
						msg_id = msg_id.replace("javax.ejb.EJBException:","");
						map.put( "message", msg_id ) ;
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		return(map);
	}

	private String getBillingDetails(Connection connection,String login_facility_id,String Store_code,String doc_type_code,String doc_no,String login_by_id,String login_at_ws_no,String patient_id ,String encounter_id ){
		// p_charge_amt=checkForNull((String)hmDetail_Bill_YN.get("gross_charge_amt"),"99999");
		HashMap message_bill  =   new HashMap();
		String p_charge_amt   =   "99999";
		String msg            =   "";
		String	hmResult	=	"";
		CallableStatement callableStatement = null;
		StringBuffer gross_charge_display_str  = new StringBuffer();
		String sal_trn_type ="";
		try{
			sal_trn_type=getEncounterPatientClass(encounter_id, patient_id); //patient_id added for [IN:035667] 

			//System.err.println("@@REissue getBillingDetails login_facility_id"+login_facility_id+"=====Store_code=" +Store_code+"=====doc_type_code=" + doc_type_code+"=====doc_no=" + doc_no+"=====login_by_id=" + login_by_id+"=====login_at_ws_no=" + login_at_ws_no+"=====patient_id=" + patient_id +"=====encounter_id=" + encounter_id+"==sal_trn_type===="+sal_trn_type);	 
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
			callableStatement.setString(19, login_facility_id);//added for MOHE-CRF-0060
			callableStatement.registerOutParameter(18, Types.VARCHAR);
			callableStatement.execute();

			/*message_bill.put("l_slmt_reqd_yn" , checkForNull((String)callableStatement.getString(10)));
			message_bill.put("l_bill_doc_type" , checkForNull((String)callableStatement.getString(11)));
			message_bill.put("l_bill_doc_num" , checkForNull((String)callableStatement.getString(12)));
			message_bill.put("v_blng_group_id" , checkForNull((String)callableStatement.getString(13)));
			message_bill.put("error_id" , checkForNull((String)callableStatement.getString(14)));
			message_bill.put("error_id_txt" , checkForNull((String)callableStatement.getString(15)));*/
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
				System.err.println("@@REissue getBillingDetails login_facility_id"+login_facility_id+"=====Store_code=" +Store_code+"=====doc_type_code=" + doc_type_code+"=====doc_no=" + doc_no+"=====login_by_id=" + login_by_id+"=====login_at_ws_no=" + login_at_ws_no+"=====patient_id=" + patient_id +"=====encounter_id=" + encounter_id+"==sal_trn_type===="+sal_trn_type);	 
				System.err.println("error message=" + msg);
				throw new Exception(msg +"  -   doc_no:" + doc_no);
			}		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			callableStatement = null;	
			try{
			  closeStatement( callableStatement );
			}catch(Exception e){
			  e.printStackTrace();
			}
		}
	   /* hmResult.put("l_bill_doc_num",(String)message_bill.get("l_bill_doc_num"));
		hmResult.put("l_bill_doc_type",(String)message_bill.get("l_bill_doc_type"));
		hmResult.put("l_slmt_reqd_yn",(String)message_bill.get("l_slmt_reqd_yn"));
		hmResult.put("v_blng_group_id",(String)message_bill.get("v_blng_group_id")); */
 
		// gross_charge_display_str.append((String)message_bill.get("l_bill_doc_num")).append(",").append((String)message_bill.get("l_bill_doc_type")).append(",").append((String)message_bill.get("v_blng_group_id")).append(",").append((String)message_bill.get("error_id_txt"));
	   gross_charge_display_str.append((String)message_bill.get("l_bill_doc_num")).append(",").append((String)message_bill.get("l_bill_doc_type")).append(",").append((String)message_bill.get("v_blng_group_id")).append(",").append((String)message_bill.get("p_call_disc_function_yn")).append(",").append((String)message_bill.get("l_slmt_reqd_yn")).append(",").append(doc_type_code+"-"+doc_no).append(",").append(patient_id).append(",").append(encounter_id).append(",").append(sal_trn_type).append(",").append((String)message_bill.get("error_id_txt"));
	 
		hmResult = gross_charge_display_str.toString();
		return hmResult;	
	}

	private HashMap localInsert( HashMap tabData , HashMap sqlMap ,Connection connection) {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "RECORD_INSERTED" ) ;
		int I1 = 0;
		int I2 = 0;
		int I3 = 0;
		int I4 = 0;

		PreparedStatement pstmt_insert1	= null ;
		PreparedStatement pstmt_insert2	= null ;
		PreparedStatement pstmt_insert3	= null ;
		PreparedStatement pstmt_update	= null ;
		PreparedStatement pstmt_update_disp_hdr_tmp	=	null;

		boolean continue_flag    = false;
		ArrayList hdrData        = (ArrayList)tabData.get("hdr");
		ArrayList updateData     = (ArrayList)tabData.get("uhdr");
		ArrayList dtlData        = (ArrayList)tabData.get("dtl");
		ArrayList batchData      = (ArrayList)tabData.get("batch");		
		ArrayList temp = null;
		String val="";
		try {
			// String token_serial_no   = (String)tabData.get("token_serial_no")==null?"":(String)tabData.get("token_serial_no");
			// String token_series_code = (String)tabData.get("token_series_code")==null?"":(String)tabData.get("token_series_code");
			String patient_class_loc     = (String)tabData.get("patient_class");
			String daily_seq_no      = "";
			if(patient_class_loc.equals("IP")){
	   		     daily_seq_no      = getSeqNumber(connection, (String)tabData.get("facility_id"),(String)tabData.get("store_code"));
			}

			pstmt_insert1=connection.prepareStatement((String) sqlMap.get( "SQL_PH_DISP_MEDICATION_HRD_INSERT1"));
			for(int i=0;i< hdrData.size();i++){
				temp = (ArrayList)hdrData.get(i) ;
				for(int j=0;j<temp.size();){
					val = (String)temp.get(j);
					pstmt_insert1.setString(++j,val);					
				}
				 pstmt_insert1.setString(39,(String)tabData.get("doc_type_code"));
				 pstmt_insert1.setString(40,(String)tabData.get("doc_no"));
				 pstmt_insert1.setString(41,(String)tabData.get("token_series_code"));
				 pstmt_insert1.setString(42,(String)tabData.get("token_serial_no"));
				 pstmt_insert1.setString(43,"RI");
				 pstmt_insert1.setString(44,daily_seq_no);
				I1 =pstmt_insert1.executeUpdate();
			}
			closeStatement( pstmt_insert1 ) ;
			//	pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQL_PH_REISSUE_MEDICATION_UPDATE_HDR"));
        	pstmt_update=connection.prepareStatement("UPDATE PH_DISP_HDR SET REF_DISP_NO_FOR_REISSUE=? , DISP_REMARKS=? WHERE DISP_NO=?");//  Facilty Id removed for FD-BRU-CRF-092
			for(int i=0;i< updateData.size(); i++){
				 temp = (ArrayList)updateData.get(i) ;
                  pstmt_update.setString(1,(String)temp.get(0));
				  pstmt_update.setString(2,(String)temp.get(1));
				 // pstmt_update.setString(3,(String)tabData.get("doc_type_code"));
				 // pstmt_update.setString(4,(String)tabData.get("doc_no"));
				  pstmt_update.setString(3,(String)temp.get(2));
				//  pstmt_update.setString(4,(String)temp.get(3)); // commented for FD-BRU-CRF-092

				 /*for(int j=0;j<temp.size();){
					String val = ((String)temp.get(j)).trim();
					pstmt_update.setString(j+1,val);
					if(j==1){
                       pstmt_update.setString(j+2,(String)tabData.get("doc_type_code"));
					   pstmt_update.setString(j+3,(String)tabData.get("doc_no"));
					}
				 }*/
				 I4=pstmt_update.executeUpdate();
			}

			I1 = I1 + I4;
			if ( I1<2 ) 
				connection.rollback();
			else 					
					continue_flag = true ;
			closeStatement( pstmt_update ) ;
			if (continue_flag) {
				continue_flag=false;
				I2 = 0;
				pstmt_insert2=connection.prepareStatement((String) sqlMap.get( "SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT"));

				HashMap hmDocSrlNo = tabData.get("HmDocSrlNo") == null? new HashMap():(HashMap)tabData.get("HmDocSrlNo");
			
				String sOrderId			="";
				String sOrderLineNo		="";
				String sItemCode		="";
				String sDocSrlNo		="";
				String disp_no			= ""; //AAKH-CRF-0117
				String approval_no      = ""; //AAKH-CRF-0117
				ArrayList alTmp			= new ArrayList();
				for(int i=0;i< dtlData.size();i++){
					int j=0;
					alTmp = (ArrayList)dtlData.get(i);
					approval_no = "";//AAKH-CRF-0117 
					for(j=0; j< alTmp.size();j++){
						sOrderId		= (String) alTmp.get(3);
						sOrderLineNo	= (String) alTmp.get(4);
						sItemCode		= (String) alTmp.get(10);
						disp_no			= (String) alTmp.get(1); //AAKH-CRF-0117
						sDocSrlNo		= hmDocSrlNo.get(sOrderId+"$"+sOrderLineNo+"$"+sItemCode) == null ?"":(String)hmDocSrlNo.get(sOrderId+"$"+sOrderLineNo+"$"+sItemCode);
						pstmt_insert2.setString(j+1,(String)alTmp.get(j));
					}
					pstmt_insert2.setString(++j,"");
					pstmt_insert2.setString(++j,"");
					pstmt_insert2.setString(++j,"");
					pstmt_insert2.setString(++j,"");
					pstmt_insert2.setString(++j,"");
					pstmt_insert2.setString(++j,"");
					pstmt_insert2.setString(++j,"");
					pstmt_insert2.setString(++j,sDocSrlNo);
					if(!daily_seq_no.equals("")){
					    pstmt_insert2.setString(++j,i+1+"/"+dtlData.size());
					}
					else{
						pstmt_insert2.setString(++j,"");
					}
					//AAKH-CRF-0117 - start
					if(newApprovalNo!=null && newApprovalNo.size()>0)
						approval_no = (String)newApprovalNo.get(sOrderId+sOrderLineNo+disp_no);

					if(approval_no==null)
						approval_no = "";
			 		 
						 
						pstmt_insert2.setString(++j,approval_no); 
						//AAKH-CRF-0117 - end
					I2 = I2+pstmt_insert2.executeUpdate();		
				}
				if ( I2<1 ) 
					connection.rollback();
				else 
					continue_flag = true ;
				closeStatement( pstmt_insert2 ) ;
				if (continue_flag) {
					pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT"));			
					for(int i=0;i< batchData.size();i++){
						for(int j=0; j< ((ArrayList)batchData.get(i)).size();j+=21){//INCREMENTED FROM 20 TO 21 FOR ADDING DISP_QTY_UOM COLUMN
							pstmt_insert3.setString(1,(String)((ArrayList)batchData.get(i)).get(j));
							pstmt_insert3.setString(2,(String)((ArrayList)batchData.get(i)).get(j+1));
							pstmt_insert3.setString(3,(String)((ArrayList)batchData.get(i)).get(j+2));
							pstmt_insert3.setString(4,(String)((ArrayList)batchData.get(i)).get(j+3));
							pstmt_insert3.setString(5,(String)((ArrayList)batchData.get(i)).get(j+4));
							pstmt_insert3.setString(6,(String)((ArrayList)batchData.get(i)).get(j+5));
							pstmt_insert3.setString(7,(String)((ArrayList)batchData.get(i)).get(j+6));
							pstmt_insert3.setString(8,(String)((ArrayList)batchData.get(i)).get(j+7));
							pstmt_insert3.setString(9,(String)((ArrayList)batchData.get(i)).get(j+8));
							pstmt_insert3.setString(10,(String)((ArrayList)batchData.get(i)).get(j+9));
							pstmt_insert3.setString(11,(String)((ArrayList)batchData.get(i)).get(j+10));
							pstmt_insert3.setString(12,(String)((ArrayList)batchData.get(i)).get(j+11));
							pstmt_insert3.setString(13,(String)((ArrayList)batchData.get(i)).get(j+12));
							pstmt_insert3.setString(14,(String)((ArrayList)batchData.get(i)).get(j+13));
							pstmt_insert3.setString(15,(String)((ArrayList)batchData.get(i)).get(j+14));
							pstmt_insert3.setString(16,(String)((ArrayList)batchData.get(i)).get(j+15));
							pstmt_insert3.setString(17,(String)((ArrayList)batchData.get(i)).get(j+16));
							pstmt_insert3.setString(18,(String)((ArrayList)batchData.get(i)).get(j+17));
							pstmt_insert3.setString(19,(String)((ArrayList)batchData.get(i)).get(j+18));
							pstmt_insert3.setString(20,(String)((ArrayList)batchData.get(i)).get(j+19));
							pstmt_insert3.setString(21,(String)((ArrayList)batchData.get(i)).get(j+20));//CHANGED BATCHDATA.GET(I)).GET(J+19) TO BATCHDATA.GET(I)).GET(J+20) FOR ADDING DISP_QTY_UOM COLUMN 
							I3 = I3+pstmt_insert3.executeUpdate();		
						}
					}
				}
				if ( I3<1 ) 
				connection.rollback();
			}
			closeStatement( pstmt_insert3 ) ;
			//****************Update Drug Profile Starts***********
			pstmt_update	=	null;
			pstmt_update	=	connection.prepareStatement((String) sqlMap.get( "SQL_PH_REISSUE_MEDICATION_UPDATE1"));
			
			for(int p=0;p< dtlData.size();p++){
			 int q=0;
				//for(q=0; q< ((ArrayList)dtlData.get(p)).size();q+=22){	
                     for(q=0; q< ((ArrayList)dtlData.get(p)).size();q+=35){		//	Add for ML-BRU-SCF-1696 and for BSP-SCF-0006 for TF[5474]	and IN061759	

					pstmt_update.setString(1,(String)((ArrayList)dtlData.get(p)).get(12));
					pstmt_update.setString(2,(String)((ArrayList)dtlData.get(p)).get(15));
					pstmt_update.setString(3,(String)((ArrayList)dtlData.get(p)).get(3));
					pstmt_update.setString(4,(String)((ArrayList)dtlData.get(p)).get(4));
					pstmt_update.executeUpdate();
				}
				
			}
			closeStatement( pstmt_update ) ;
			//***************Update Drug Profile Ends**************

			/*closeStatement( pstmt_update_disp_hdr_tmp ) ;
			pstmt_update_disp_hdr_tmp		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_UPDATE") ) ;
			pstmt_update_disp_hdr_tmp.setString(1,(String)tabData.get("doc_type_code"));
			pstmt_update_disp_hdr_tmp.setString(2,(String)tabData.get("doc_no"));  
			pstmt_update_disp_hdr_tmp.setString(3,(String)tabData.get("disp_no"));
			pstmt_update_disp_hdr_tmp.setString(4,(String)tabData.get("facility_id"));
			pstmt_update_disp_hdr_tmp.executeUpdate();
			*/
		}
		catch (Exception e) {
			e.printStackTrace() ;
			//failure and so
			map.put( "result", new Boolean( false) ) ;
			map.put( "msgid", "Error During Insertion "+e) ;
			try{
				connection.rollback();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		}
		finally{	
			try {
				closeStatement( pstmt_update_disp_hdr_tmp ) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return map;
	}

	public String getStDocType(String patient_class){
		Connection connection			= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resSet = null ;
		String st_doc_type = "";
		try{
			connection = getConnection();
			pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT56") ) ;
			if(patient_class.equals("IP")) {
				pstmt.setString(1,"DIIP");
			}
			else {
				pstmt.setString(1,"DIOP");
			}
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,login_facility_id);
			resSet				= pstmt.executeQuery() ;
			
			if(resSet.next()) {
				st_doc_type	=	(String)resSet.getString("ST_DOC_TYPE_CODE");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return st_doc_type;
	}//end of getSTDocType

	public void setTodaysDate(){
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		try{
			connection	= getConnection() ;
		    pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT25") ) ;
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				this.today_date	=	resultSet.getString("TODAY");

			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
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
	}//end of todays date

	public String getItemCost(String item_code,String store_code, String qty_reqd,String eff_date) throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		CallableStatement cstmt = null ;
		String item_cost		=	"";
		if(eff_date == null)
			eff_date="";
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

	public ArrayList getReissuedRecords(String order_id, String ord_line_no){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList() ;
		String disp_qty			=	"";
		String drug_desc		=	"";
		String disp_date		=	"";
		String disp_no			=	"";
		String qty_uom			=	"";//Modified for Issuee 11510
		String reason_desc		=	"";
		String orderingfacilityid = "";// Added for FD-BRU-CRF-092
//		String Language_Id = "";// Added for FD-BRU-CRF-092   Removed for IN063877
		String DispLoc = "";
		String FacilityName = "", DispLoc_desc="";
		String approval_no = ""; //AAKH-CRF-0117
		try{
			connection			= getConnection() ;
			//Modified for Issuee 11510
			//pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REISSUE_MEDICATION_SELECT11") ) ;
			pstmt				= connection.prepareStatement("SELECT SUM(B.DISP_QTY) DISP_QTY,A.DISP_NO,TO_CHAR(A.DISPENSED_DATE_TIME,'DD/MM/YYYY HH24:MI') DISP_DATE,B.DISP_DRUG_CODE,C.DRUG_DESC,B.DISP_UOM_CODE,D.REASON_DESC,B.DISP_LOCN_CODE,B.ORDERING_FACILITY_ID, (select facility_name from sm_facility_param_lang_vw          where facility_id =b.ordering_facility_id and language_id = ?) facility_name, (select short_desc  from ph_disp_locn_lang_vw where disp_locn_code =B.DISP_LOCN_CODE and language_id = ?) disp_locn_desc,approval_no FROM PH_DISP_HDR A,PH_DISP_DTL B,PH_DRUG_LANG_VW C,PH_MEDN_TRN_REASON D WHERE B.ORDER_ID=? AND B.ORDER_LINE_NO=? AND D.APPL_TRN_TYPE='R' AND D.REASON_CODE=B.REISSUE_REASON_CODE  AND B.REISSUE_REASON_CODE IS NOT NULL AND B.DISP_DRUG_CODE=C.DRUG_CODE AND B.DISP_NO=A.DISP_NO AND A.FACILITY_ID=B.FACILITY_ID AND C.LANGUAGE_ID = ? GROUP BY B.DISP_QTY,A.DISP_NO,A.DISPENSED_DATE_TIME,B.DISP_DRUG_CODE,C.DRUG_DESC,B.DISP_UOM_CODE,D.REASON_DESC,B.DISP_LOCN_CODE,B.ORDERING_FACILITY_ID,approval_no ORDER BY DISP_NO") ;
			//approval_no added for AAKH-CRF-0117
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,order_id);
			pstmt.setString(4,ord_line_no);
			pstmt.setString(5,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				drug_desc		=	checkForNull(resultSet.getString("DRUG_DESC"));
				disp_qty		=	checkForNull(resultSet.getString("DISP_QTY"));
				disp_no			=	checkForNull(resultSet.getString("DISP_NO"));
				disp_date		=	checkForNull(resultSet.getString("DISP_DATE"));	
				qty_uom			=	checkForNull(resultSet.getString("DISP_UOM_CODE"));//Modified for Issuee 11510
				reason_desc		=	checkForNull(resultSet.getString("REASON_DESC"));					
				DispLoc		=	checkForNull(resultSet.getString("DISP_LOCN_CODE"));
			    orderingfacilityid = checkForNull(resultSet.getString("ORDERING_FACILITY_ID"));
			    FacilityName = checkForNull(resultSet.getString("FACILITY_NAME"));
			    DispLoc_desc = checkForNull(resultSet.getString("DISP_LOCN_DESC"));
				approval_no  = checkForNull(resultSet.getString("approval_no")); //AAKH-CRF-0117
			// Added for FD-BRU-CRF-092
				records.add(drug_desc);
				records.add(disp_qty);
				records.add(disp_no);
				records.add(disp_date);
				records.add(qty_uom);//Modified for Issuee 11510
				records.add(reason_desc);
                records.add(DispLoc_desc); // Added for FD-BRU-CRF-092
				records.add(FacilityName); // Added for FD-BRU-CRF-092
				records.add(approval_no);//AAKH-CRF-0117
			}				
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return pat_txt_length;	
	}

	// sysdate-7 for defaulting from date
	public String getFromDate(){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	from_date		=	null ;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REISSUE_MEDICATION_SELECT14") ) ;
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				from_date	=	checkForNull(resultSet.getString("FRM_DATE"));
			}			
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch(Exception e){
			from_date	=e.toString();
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
		return from_date;	
	}

	public String checkforbillinginterface()throws Exception{
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet			    = null;	
		String bl_interface_yn					= "N";
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

	public String getEncounterPatientClass(String encounter_id, String patient_id) throws Exception{ //patient_id added for [IN:035667] 
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String patient_class	= "";
		try {
            connection	= getConnection() ;
		//	pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1")) ;
            pstmt		= connection.prepareStatement("SELECT DECODE(PATIENT_CLASS, 'IP','I','DC','D','OP','O','EM','E','XT','R') ENC_PATIENT_CLASS FROM PR_ENCOUNTER WHERE /* FACILITY_ID = ? AND */ ENCOUNTER_ID = ? and patient_id = ?") ;// Added for FD-BRU-CRF-092 //and patient_id = ? added for [IN:035667] 
			//pstmt.setString(1,this.orderingfacilityid); // commented for FD-BRU-CRF-092
			pstmt.setString(1,encounter_id);
			pstmt.setString(2,patient_id); //added for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription
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

	public String getOrdertype(String order_id) throws Exception{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String iv_prep_yn	= "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_MFCTR_SELECT4")) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				iv_prep_yn = checkForNull(resultSet.getString("IV_PREP_YN"));
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

	public String getDischargeYN(String order_id){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String sDischargeYN		= "N";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( "select decode(DISCHARGE_IND,'D','Y','N') DISCHARGE_IND from or_order where order_id =?") ;
			pstmt.setString(1,order_id);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				sDischargeYN = resultSet.getString("DISCHARGE_IND");				
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
		return sDischargeYN;
	}
    
	public HashMap callItemChargeDtls(String patient_id,String encounter_id,String item_code,int item_qty,String batch_str,String sysdate,String store_code,String order_id,String order_line_no,String dischargeIND,String ordering_facility_id,String dispNo)throws Exception{//[IN035994] Added new parameter DispNo
		Connection connection				= null;
		CallableStatement callableStatement = null;
		HashMap message						= new HashMap();
        ResultSet resultSet					= null;
		String total_charge_amt				="";
		String patient_payable_amt			="";
		String grosschargeamt				="";
		PreparedStatement pstmt				= null;
		ResultSet rsDecimalPlace			= null;
		int decimal_place					= 0;
		String decimalFormatString			= "#0";
		String bl_override_excl_incl_ind	=""	;
		String bl_incl_excl_override_reason_code="";
		String doc_no						="";   
		String doc_type						="";  
		String doc_srl_no					="";
		//[IN035994] Assigning patient class using DispNo parameter - Start
		String sal_trn_type					= getEncounterPatientClass(encounter_id, patient_id); //uncommented for ML-BRU-SCF-1155 [IN:045202]
		ArrayList pat_enct_dtl				= getOrderPatientClass(dispNo);
		//String sal_trn_type				= pat_enct_dtl.get(0).toString(); //Commented for ML-BRU-SCF-1155 [IN:045202]
		if(encounter_id==null || encounter_id.equals("")){
		    encounter_id					= pat_enct_dtl.get(1).toString();
		    if(encounter_id.equals("11111")){
			    sal_trn_type= "R";
			}
		}
		//[IN035994] Assigning patient class using DispNo parameter - End
		try{
			//SQL_PH_DISP_MEDICATION_SELECT162
			connection = getConnection();   
		   
		    pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT162"));
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				bl_override_excl_incl_ind         = checkForNull(resultSet.getString("BL_INCL_EXCL_OVERRIDE_VALUE"));
				bl_incl_excl_override_reason_code = checkForNull(resultSet.getString("BL_INCL_EXCL_OVERRIDE_REASON"));
			}
			callableStatement	= connection.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, ordering_facility_id +"|"+login_facility_id); // this.orderingfacilityid replaced with ordering_facility_id  Added for FD-BRU-CRF-092
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
			callableStatement.setString(45, dischargeIND);
			callableStatement.registerOutParameter(46, Types.VARCHAR); //added for JD-CRF-0170.1 [IN:040204]
			callableStatement.setString(47,order_id); //added for CRF-0126.1
			callableStatement.setString(48, order_line_no);//added for CRF-0126.1
System.err.println("ReissueMedBean.java==2069====order_id======>"+order_id+"==order_line_no==>"+order_line_no);
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
			patient_payable_amt   = callableStatement.getString(25);
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
			//closeStatement( pstmt1 ) ;
			closeStatement( pstmt ) ;
			closeResultSet(rsDecimalPlace);
		}
		return message;
	}	//BL interface ends here 

	public void getTokenSeries() {
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
    	token_series_code	        =   "";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT73A") ) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.getDispLocnCode());
			pstmt.setString(3,login_at_ws_no);
			pstmt.setString(4,getLanguageId());
			resultSet	= pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next() ) {
				token_series_desc  =   checkForNull(resultSet.getString("DESCRIPTION"));
				//disp_cash_coll_stage  =   checkForNull(resultSet.getString("DISP_CASH_COLL_STAGE"));
				setDispCashCollStage(checkForNull(resultSet.getString("DISP_CASH_COLL_STAGE")));
				setDispCashCollStageOP(checkForNull(resultSet.getString("DISP_CASH_COLL_STAGE_OP")));
				
				if(getDispCashCollStageOP().equals("D")|| getDispCashCollStageOP().equals("X")){
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
				//sql.append(" AND b.IP_REISSUE_MED_YN='Y'");
				sql.append(" AND b.IP_REISSUE_MED_YN='Y' ORDER BY A.short_desc"); //Added Order by A.short_desc for incident num:26056
			}
			else if (Category.equals("O")){
				//sql.append(" AND b.OP_REISSUE_MED_YN='Y'");
				sql.append(" AND b.OP_REISSUE_MED_YN='Y' ORDER BY A.short_desc"); //incident num:26056 on 24/jan/2011
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
				es.printStackTrace() ;
			}
		}
		return result;
	}

	//code added on 4/5/2004
	public void setInsertRecords(String key,String value){
		insertRecords.put(key,value);
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
				}catch(Exception es){es.printStackTrace();}
		}
		return def_issue_uoms;
	}


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
		double eqvl_value			= 1;
		try {
            connection	= getConnection() ;
          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			//pstmt		= connection.prepareStatement( "select EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;//changed for 553.1
			pstmt		= connection.prepareStatement( "select PH_calculate_equl_val(ITEM_CODE,UOM_CODE,EQVL_UOM_CODE) EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=? ") ;

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
			base_qty   =	Double.parseDouble(disp_qty)*(base_to_disp_uom_equl_value);
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
		double eqvl_value		= 1;
		try {
          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			if(uom_code.equals(equl_uom_code)){
				eqvl_value			= 1;
			}
			else{
				pstmt		= connection.prepareStatement( "select eqvl_value/eqvl_uom_qty EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;
				pstmt.setString(1,item_code);
				pstmt.setString(2,uom_code);
				pstmt.setString(3,equl_uom_code);
				resultSet	= pstmt.executeQuery() ;
				
				if (resultSet.next()){
					eqvl_value = resultSet.getDouble("EQVL_VALUE") <= 0 ? 1:resultSet.getDouble("EQVL_VALUE");	
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
				}catch(Exception es){
					es.printStackTrace();
				}
		}
		return eqvl_value;
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

	public String getSeqNumber(Connection connection, String sFacilityId,String sStoreCode)throws Exception{
		CallableStatement oCalStatement	= null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		int iDailySeqNo					= 0;
		try{
			oStatement	= connection.createStatement();
			oResultSet	= oStatement.executeQuery("SELECT DECODE(ip_dsn_yn,null,'N',ip_dsn_yn) ip_dsn_yn FROM ph_facility_param WHERE facility_id = '"+sFacilityId+"'");
			if(oResultSet!=null && oResultSet.next()){
				if(oResultSet.getString("IP_DSN_YN").equals("Y")){
					oCalStatement=connection.prepareCall("{call PH_GET_DISP_DLY_SEQ_NO(?,?,?)}");
					oCalStatement.setString(1, sFacilityId.trim());
					oCalStatement.setString(2, sStoreCode.trim());
					oCalStatement.registerOutParameter(3,Types.VARCHAR);
					oCalStatement.execute();
					iDailySeqNo = oCalStatement.getInt(3);
				}
			}
		}
		catch ( Exception e ) 	{
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( oResultSet ) ;
			closeStatement( oStatement ) ;
			closeStatement( oCalStatement ) ;
		}
		 if(iDailySeqNo == 0)
			 return "";
		 else
			 return iDailySeqNo+"";		
	}

	public void setBillingParams(){//added for SRR20056-SCF-7639 ICN027720 -start
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
	    try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT155") ) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,this.getDispLocnCode());
            resultSet = pstmt.executeQuery() ;
            if ( resultSet.next() ) {
				setDispCashCollStage(checkForNull(resultSet.getString("DISP_CASH_COLL_STAGE")));
				setDispCashCollStageOP(checkForNull(resultSet.getString("DISP_CASH_COLL_STAGE_OP")));
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
			catch(Exception es) { es.printStackTrace();}
		}
	}

	public ArrayList getFacilityandDisp_locn(){// Added for FD-BRU-CRF-092
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList FacilityandDisp =		new ArrayList();
		try {
	   		connection = getConnection() ;
			pstmt			 = connection.prepareStatement("select a.SHORT_DESC SHORT_DESC ,b.facility_name facility_name from PH_DISP_LOCN a,sm_facility_param_lang_vw b where a.store_code =? and b.facility_id =? and b.language_id =? ") ;
			pstmt.setString(1,getDispLocnCode());
			pstmt.setString(2,this.orderingfacilityid);
			pstmt.setString(3,getLanguageId());
			resultSet   = pstmt.executeQuery() ;
			while (resultSet.next()) {
				 FacilityandDisp.add(resultSet.getString("SHORT_DESC"));
				 FacilityandDisp.add(resultSet.getString("FACILITY_NAME"));
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
		return FacilityandDisp;
	}	//added for SRR20056-SCF-7639 ICN027720 -END
	
	public ArrayList getOrderPatientClass(String dispNo) throws Exception{//[IN035994] Adding new method to get patient class without encounter_id.- Start
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String patient_class	= "";
		String encounter_id = "";
		ArrayList pat_enct_dtl = new ArrayList();
		try {
		    connection	= getConnection() ;
		    pstmt		= connection.prepareStatement("SELECT DECODE(PATIENT_CLASS, 'IP','I','DC','D','OP','O','EM','E','XT','R') ORDER_PATIENT_CLASS,ENCOUNTER_ID FROM PH_DISP_HDR WHERE DISP_NO=?") ;
			pstmt.setString(1,dispNo);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				patient_class = checkForNull(resultSet.getString("ORDER_PATIENT_CLASS"));
				pat_enct_dtl.add(patient_class);
				encounter_id  = checkForNull(resultSet.getString("ENCOUNTER_ID"));
				pat_enct_dtl.add(encounter_id);
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
		return pat_enct_dtl;
	}
	//[IN035994] Adding new method to get patient class without encounter_id.- End
//ML-BRU-SCF-1888 - start
	public String getPresDrugCode(Connection connection,String order_id,String order_line_no,String disp_drug_code)throws Exception{
		
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String pres_drug_code	= "";
		try {
		    pstmt		= connection.prepareStatement("select pres_drug_code from ph_disp_dtl where order_id=? and order_line_no=? and disp_drug_code=? AND ROWNUM<=1") ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			pstmt.setString(3,disp_drug_code);

			resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){
				pres_drug_code = checkForNull(resultSet.getString("pres_drug_code"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		
		}

		return pres_drug_code;
	}
//ML-BRU-SCF-1888 - end

public String getApprovalNoApplicableForPatientClass(String patient_class){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//ArrayList approval_setting	=	new ArrayList(); //commented for common-icn-0048
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
	} //AAKH-CRF-0117 - end

}//end of class file
