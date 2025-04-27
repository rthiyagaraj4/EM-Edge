/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//saved on 08/11/2005
package ePH;
import java.io.*;
import java.util.*;
import java.sql.*;
//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
import javax.servlet.*;
import javax.servlet.http.*;
import ePH.Common.*;
import eCommon.Common.*;
import ePH.IVPrescription.*;
import oracle.sql.*;
import eOR.*;

public class PrescriptionTDMBean extends PhAdapter implements Serializable{
	protected String m_strPatientId		= null;
	protected String m_strOrderId		= null;
	protected String m_strOrderLineNum	= null;
	protected String m_strGender		= null;
	protected String m_strAge			= null;
	protected String m_strAgeUnit		= null;
	protected String m_strAgeGroupCode	= null;
	protected String patient_class		= "";
    protected String actual_patient_class		= "";//Added for AMS-SCF-0424 and ML-MMOH-SCF-0500
	protected String location_code		= "";
	protected String location_type		= "";
	protected String pract_id			= "";
	protected String encounter_id		= "";
	protected String priority			= "";
	protected String drug_desc			= "";	
	protected String drug_code			= "";	
	protected String ord_date			= "";	
	protected String reason				= "";	
	protected String smoking_yn			= "";	
	protected String alcohol_yn			= "";	
	protected String pregnant_yn		= "";	
	protected String clinical_comments	= "";			
	protected String mode_value	= "";		
	protected String err_msg ="";
	protected String locale ="";
	protected ArrayList tdm_dtl			= new ArrayList();
	protected ArrayList update_date_time	= new ArrayList();

	protected Hashtable m_htAgeGroupData = new Hashtable();

	public PrescriptionTDMBean(){
	}
	
	public void clear() 	{
		super.clear();
		m_strPatientId		= null;
		m_strOrderId		= null;
		m_strOrderLineNum	= null;
		m_strGender			= null;
		m_strAge			= null;
		m_strAgeUnit		= null;
		m_strAgeGroupCode	= null;
		patient_class		= "";  
		location_code		= "";  
		location_type		= "";  
		pract_id			= "";  
		encounter_id		= "";
		priority			= "";
		drug_desc			= "";
		drug_code			= "";
		ord_date			= "";
		reason				= "";
		smoking_yn			= "";
		alcohol_yn			= "";
		pregnant_yn			= "";
		clinical_comments	= "";
		tdm_dtl				= new ArrayList();
		actual_patient_class="";//Added for AMS-SCF-0424 and ML-MMOH-SCF-0500
	}

	public void setLanguageId(String locale){
	  this.locale=locale;
	}

    public String getLanguageId(){
		return this.locale;
	}

	public void setComments(String clinical_comments) {
		this.clinical_comments	=	clinical_comments;
	}

	public String getComments(){
		return this.clinical_comments;
	}
	public void setModeValue(String mode_value) {
		this.mode_value	=	mode_value;
	}

	public String getModeValue(){
		return this.mode_value;
	}

	public void setOrderDate(String order_date) {
		this.ord_date	=	order_date;
	}

	public String getOrderDate() {
		return this.ord_date;
	}

	public void setDrugCode(String drug_code) {
		this.drug_code	=	drug_code;
	}

	public String getDrugCode(){
		return this.drug_code;
	}


	public void setDrugDesc(String drug_desc) {
		this.drug_desc	=	drug_desc;
	}

	public String getDrugDesc(){
		return this.drug_desc;
	}

	public void setEncounter(String encounter_id) {
		this.encounter_id	=	encounter_id;
	}

	public String getEncounter(){
		return this.encounter_id;
	}

	public void setPriority(String priority) {
		this.priority	=	priority;
	}

	public String getPriority() {
		return this.priority;
	}


	public void setAgeGroupCode(String strAgeGCode){
		this.m_strAgeGroupCode = strAgeGCode;
	}
	public String getAgeGroupCode(){
		return this.m_strAgeGroupCode;
	}

	public void setPatientAge(String strAge){
		this.m_strAge = strAge;
	}
	public String getPatientAge(){
		return this.m_strAge;
	}

	public void setAgeUnit(String strAgeUnit){
		this.m_strAgeUnit = strAgeUnit;
	}
	public String getAgeUnit(){
		return this.m_strAgeUnit;
	}

	public void setPatientSex(String strSex){
		this.m_strGender = strSex;
	}
	public String getPatientSex(){
		return this.m_strGender;
	}

	public void setOrderId(String strOrderIdIn)	{
		this.m_strOrderId = strOrderIdIn;
	}	

	public void setOrderLineNum(String strOrderLineNumIn)	{
		this.m_strOrderLineNum = strOrderLineNumIn;
	}

	public String getOrderId(){
		return this.m_strOrderId;
	}

	public String getOrderLineNum(){
		return this.m_strOrderLineNum;
	}
	
	public void setPatientId(String strPatientIdIn){
			this.m_strPatientId = strPatientIdIn;
	}
	
	public String getPatientId(){
		return this.m_strPatientId;
	}
	
	public void setPatientClass(String patient_class) {
		this.patient_class	=	patient_class;
	}

	public String getPatientClass() {
		return this.patient_class;
	}
//Adding start for AMS-SCF-0424 and ML-MMOH-SCF-0500
	public void setActualPatientClass(String actual_patient_class) {
		this.actual_patient_class	=	actual_patient_class;
	}

	public String getActualPatientClass() {
		return this.actual_patient_class;
	}
//Adding end  for AMS-SCF-0424 and ML-MMOH-SCF-0500

	public void setLocationCode(String location_code) {
		this.location_code	=	location_code;
	}
	
	public String getLocationCode() {
		return this.location_code;
	}


	public void setLocationType(String location_type) {
		this.location_type	=	location_type;
	}

	public String getLocationType() {
		return this.location_type;
	}

	public void setPractId(String pract_id){
		this.pract_id	=	pract_id;
	}

	public String getPractId(){
		return this.pract_id;
	}
	
	public void setReason(String reason) {
		this.reason	=	reason;
	}

	public String getReason() {
		return this.reason;
	}

	public void setSmokingYN(String smoking_yn){
		this.smoking_yn	=	smoking_yn;
	}

	public String getSmokingYN(){
		return this.smoking_yn;
	}

	public void setAlcoholYN(String alcohol_yn) {
		this.alcohol_yn	=	alcohol_yn;
	}

	public String getAlcoholYN(){
		return this.alcohol_yn;
	}

	public void setPregnantYN(String pregnant_yn) {
		this.pregnant_yn	=	pregnant_yn;
	}

	public String getPregnantYN(){
		return this.pregnant_yn;
	}

	public void setAll(Hashtable recordSet) {
		String open_tdm_order_value="";
		String flag="";
		try {

			if(recordSet.containsKey("mode")){
				setMode(((String)recordSet.get("mode")).trim()) ;
			}

			if(recordSet.containsKey("patient_class"))	{
				setPatientClass(((String)recordSet.get("patient_class")).trim()) ;
			}

			if(recordSet.containsKey("actual_patient_class"))	{//Adding start for AMS-SCF-0424 and ML-MMOH-SCF-0500
				setActualPatientClass(((String)recordSet.get("actual_patient_class")).trim()) ;
			}//Adding end  for AMS-SCF-0424 and ML-MMOH-SCF-0500

			if(recordSet.containsKey("location_code"))	{
				setLocationCode(((String)recordSet.get("location_code")).trim()) ;
			}

			if(recordSet.containsKey("location_type"))	{
				setLocationType(((String)recordSet.get("location_type")).trim()) ;
			}
			
			if(recordSet.containsKey("pract_id")){
				setPractId(((String)recordSet.get("pract_id")).trim()) ;
			}

			if(recordSet.containsKey("encounter_id")){
				setEncounter(((String)recordSet.get("encounter_id")).trim()) ;
			}

			if(recordSet.containsKey("priority")){
				setPriority(((String)recordSet.get("priority")).trim()) ;
			}
			
			if(recordSet.containsKey("drug_code")){
				setDrugCode(((String)recordSet.get("drug_code")).trim()) ;
			}

			if(recordSet.containsKey("drug_desc")){
				setDrugDesc(((String)recordSet.get("drug_desc")).trim()) ;
			}
			
			if(recordSet.containsKey("reason")){
				setReason(((String)recordSet.get("reason")).trim()) ;
			}

			if(recordSet.containsKey("smoking_yn")){
				setSmokingYN(((String)recordSet.get("smoking_yn")).trim()) ;
			}

			if(recordSet.containsKey("alcohol_yn")){
				setAlcoholYN(((String)recordSet.get("alcohol_yn")).trim()) ;
			}
			
			if(recordSet.containsKey("pregnant_yn")){
				setPregnantYN(((String)recordSet.get("pregnant_yn")).trim()) ;
			}

			if(recordSet.containsKey("clinical_comments")) {
				setComments(((String)recordSet.get("clinical_comments")) );
			}

			if(recordSet.containsKey("flag")) {
				 flag=((String)recordSet.get("flag"));
			}
			 
			if(recordSet.containsKey("mode_value")) {
				setModeValue(((String)recordSet.get("mode_value")) );
			}
			
			int row_cnt	=	0;

			if(recordSet.containsKey("row_cnt")){
				row_cnt	=	Integer.parseInt(((String)recordSet.get("row_cnt")).trim()) ;
			}
			// System.err.println("row_cnt---bean------>"+row_cnt);

			update_date_time				= new ArrayList();
			tdm_dtl				= new ArrayList();
			// This will check if any OPEN_TDM_ORDER_ID is there,if value is there value wiil beassigned to open_tdm_order_value.
		if(flag.equals("D")){

			for(int i1=1; i1<=row_cnt; i1++) {
				if(((String)recordSet.get("peak_option_yn_"+i1)).equals("Y")){
					if(!((String)recordSet.get("enable_checkP"+i1)).equals("")){
					open_tdm_order_value=((String)recordSet.get("open_tdm_order_id"+i1)).trim();
					}
				}
				if(((String)recordSet.get("trough_option_yn_"+i1)).equals("Y")){
					if(!((String)recordSet.get("enable_checkT"+i1)).equals(""))
					{
					open_tdm_order_value=((String)recordSet.get("open_tdm_order_id"+i1)).trim();
					}
				}
				if(((String)recordSet.get("random_option_yn_"+i1)).equals("Y")){
					if(!((String)recordSet.get("enable_checkR"+i1)).equals(""))
					{
					open_tdm_order_value=((String)recordSet.get("open_tdm_order_id"+i1)).trim();
					}
				}
				if(((String)recordSet.get("extended_option_yn_"+i1)).equals("Y")){
					if(!((String)recordSet.get("enable_checkE"+i1)).equals("")){
					open_tdm_order_value=((String)recordSet.get("open_tdm_order_id"+i1)).trim();
					}
				}
			}

			for(int i=1; i<=row_cnt; i++) {
				if(((String)recordSet.get("peak_option_yn_"+i)).equals("Y")){
					if(((String)recordSet.get("enable_checkP"+i)).equals("")){
						if(recordSet.containsKey("sch_date_time4"+i) && (recordSet.containsKey("samp_type41_"+i)) && (recordSet.containsKey("lab_test4_"+i)) && (recordSet.containsKey("samp_type42_"+i)) &&  (recordSet.containsKey("samp_type43_"+i)) ) {
							if(!((String)recordSet.get("lab_test4_"+i)).equals("")){
								tdm_dtl.add( ((String)recordSet.get("sch_date_time4"+i)).trim() );
								tdm_dtl.add( ((String)recordSet.get("lab_test4_"+i)).trim() );				
								tdm_dtl.add( ((String)recordSet.get("samp_type41_"+i)).trim() );				
								tdm_dtl.add( ((String)recordSet.get("samp_type42_"+i)).trim() );				
								tdm_dtl.add( ((String)recordSet.get("samp_type43_"+i)).trim() );			
								tdm_dtl.add( ((String)recordSet.get("when_doseAB1_"+i)).trim() );			
								tdm_dtl.add(CommonBean.checkForNull(open_tdm_order_value));	
								
								update_date_time.add(updatedateandtime((String)recordSet.get("sch_date_time4"+i),(String)recordSet.get("when_doseAB1_"+i),(String)recordSet.get("samp_type42_"+i),(String)recordSet.get("samp_type43_"+i)));
							}
						}
					}

				}

				if(((String)recordSet.get("trough_option_yn_"+i)).equals("Y")){
					if(((String)recordSet.get("enable_checkT"+i)).equals("")){
						if(recordSet.containsKey("sch_date_time1"+i) && (recordSet.containsKey("samp_type11_"+i)) && (recordSet.containsKey("lab_test1_"+i)) && (recordSet.containsKey("samp_type5_"+i)) &&  (recordSet.containsKey("samp_type6_"+i)) ) {
							if(!((String)recordSet.get("lab_test1_"+i)).equals("")){
								tdm_dtl.add( ((String)recordSet.get("sch_date_time1"+i)).trim() );
								tdm_dtl.add( ((String)recordSet.get("lab_test1_"+i)).trim() );				
								tdm_dtl.add( ((String)recordSet.get("samp_type11_"+i)).trim() );				
								tdm_dtl.add( ((String)recordSet.get("samp_type5_"+i)).trim() );				
								tdm_dtl.add( ((String)recordSet.get("samp_type6_"+i)).trim() );
								tdm_dtl.add( ((String)recordSet.get("when_doseAB0_"+i)).trim() );
								tdm_dtl.add(CommonBean.checkForNull(open_tdm_order_value));	
								
								update_date_time.add(updatedateandtime((String)recordSet.get("sch_date_time1"+i),(String)recordSet.get("when_doseAB0_"+i),(String)recordSet.get("samp_type5_"+i),(String)recordSet.get("samp_type6_"+i)));
							}
						}
					}
				}

				if(((String)recordSet.get("random_option_yn_"+i)).equals("Y")){
					if(((String)recordSet.get("enable_checkR"+i)).equals("")){
						if(recordSet.containsKey("sch_date_time2"+i) && (recordSet.containsKey("samp_type21_"+i)) && (recordSet.containsKey("lab_test2_"+i)) && (recordSet.containsKey("samp_type8_"+i)) &&  (recordSet.containsKey("samp_type9_"+i)) ) {
							if(!((String)recordSet.get("lab_test2_"+i)).equals("")){
								tdm_dtl.add( ((String)recordSet.get("sch_date_time2"+i)).trim() );
								tdm_dtl.add( ((String)recordSet.get("lab_test2_"+i)).trim() );				
								tdm_dtl.add( ((String)recordSet.get("samp_type21_"+i)).trim() );				
								tdm_dtl.add( ((String)recordSet.get("samp_type8_"+i)).trim() );				
								tdm_dtl.add( ((String)recordSet.get("samp_type9_"+i)).trim() );
								tdm_dtl.add( ((String)recordSet.get("when_doseAB2_"+i)).trim() );
								tdm_dtl.add(CommonBean.checkForNull(open_tdm_order_value));	
								
								update_date_time.add(updatedateandtime((String)recordSet.get("sch_date_time2"+i),(String)recordSet.get("when_doseAB2_"+i),(String)recordSet.get("samp_type8_"+i),(String)recordSet.get("samp_type9_"+i)));
							}

						}
					}
				}

				if(((String)recordSet.get("extended_option_yn_"+i)).equals("Y")){
					if(((String)recordSet.get("enable_checkE"+i)).equals("")){
						if(recordSet.containsKey("sch_date_time3"+i) && (recordSet.containsKey("samp_type31_"+i)) && (recordSet.containsKey("lab_test3_"+i)) && (recordSet.containsKey("samp_type12_"+i)) &&  (recordSet.containsKey("samp_type13_"+i)) ) {
							if(!((String)recordSet.get("lab_test3_"+i)).equals("")){
								tdm_dtl.add( ((String)recordSet.get("sch_date_time3"+i)).trim() );
								tdm_dtl.add( ((String)recordSet.get("lab_test3_"+i)).trim() );				
								tdm_dtl.add( ((String)recordSet.get("samp_type31_"+i)).trim() );				
								tdm_dtl.add( ((String)recordSet.get("samp_type12_"+i)).trim() );				
								tdm_dtl.add( ((String)recordSet.get("samp_type13_"+i)).trim() );	
								tdm_dtl.add( ((String)recordSet.get("when_doseAB3_"+i)).trim() );	
								tdm_dtl.add(CommonBean.checkForNull(open_tdm_order_value));	
								
								update_date_time.add(updatedateandtime((String)recordSet.get("sch_date_time3"+i),(String)recordSet.get("when_doseAB3_"+i),(String)recordSet.get("samp_type12_"+i),(String)recordSet.get("samp_type13_"+i)));
							   }
						   }
				       }
				    }

			   }
		  }
		  else{
			  for(int i=1; i<=row_cnt; i++) {
				if(recordSet.containsKey("samp_type1_"+i) && (recordSet.containsKey("samp_type2_"+i)) && (recordSet.containsKey("samp_type3_"+i)) && (recordSet.containsKey("lab_test_"+i)) && (recordSet.containsKey("sch_date_time"+i))) {
					if(!((String)recordSet.get("lab_test_"+i)).equals("")){
						tdm_dtl.add( ((String)recordSet.get("sch_date_time"+i)).trim() );				
						tdm_dtl.add( ((String)recordSet.get("lab_test_"+i)).trim() );				
						tdm_dtl.add( ((String)recordSet.get("samp_type1_"+i)).trim() );
						tdm_dtl.add( ((String)recordSet.get("samp_type2_"+i)).trim() );				
						tdm_dtl.add( ((String)recordSet.get("samp_type3_"+i)).trim() );				
						tdm_dtl.add("");			
						tdm_dtl.add("");			
						update_date_time.add(updatedateandtime((String)recordSet.get("sch_date_time"+i),"",(String)recordSet.get("samp_type2_"+i),(String)recordSet.get("samp_type3_"+i)));
				      }
				   }
	            }
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap modify(){
		HashMap hmReturn = new HashMap();

		return hmReturn;
	}

	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		map.put( "flag", "test") ;		

		HashMap tabData	=	new HashMap();
		HashMap sqlMap	=	new HashMap();
		try{

			tabData.put("order_id",genOrderID(patient_class));
			tabData.put("patient_id",m_strPatientId.trim());
			tabData.put("patient_class",patient_class.trim());		
			tabData.put("encounter_id",encounter_id);
			tabData.put("location_code",location_code);
			tabData.put("location_type",location_type);
			tabData.put("sys_date",getSysdate());
			tabData.put("getLanguageId",getLanguageId());
			tabData.put("pract_id",pract_id);
			tabData.put("old_order_id",this.getOrderId());
			tabData.put("old_line_no",this.getOrderLineNum());
			tabData.put("login_at_ws_no",login_at_ws_no);
			tabData.put("login_by_id",login_by_id);	
			tabData.put("login_facility_id",login_facility_id);	
			
			tabData.put("priority",priority);	
			tabData.put("drug_desc",drug_desc);	
			tabData.put("drug_code",drug_code);	
			tabData.put("ord_date",ord_date);
			tabData.put("reason",reason);
			tabData.put("smoking_yn",smoking_yn);
			tabData.put("alcohol_yn",alcohol_yn);
			tabData.put("pregnant_yn",pregnant_yn);
			tabData.put("tdm_dtl",tdm_dtl);
			tabData.put("clinical_comments",clinical_comments);	

			sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT1",PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT1"));
			//sqlMap.put("SQL_PH_IVPRESCRIPTION_INSERT1",PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT1"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT2",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT2"));
			sqlMap.put("SQL_PH_TDM_PRES_INSERT1",PhRepository.getPhKeyValue("SQL_PH_TDM_PRES_INSERT1"));
			sqlMap.put("SQL_PH_TDM_PRES_INSERT2",PhRepository.getPhKeyValue("SQL_PH_TDM_PRES_INSERT2"));
			sqlMap.put("SQL_PH_TDM_PRES_SELECT3",PhRepository.getPhKeyValue("SQL_PH_TDM_PRES_SELECT3"));
			sqlMap.put("SQL_PH_TDM_PRES_SELECT4",PhRepository.getPhKeyValue("SQL_PH_TDM_PRES_SELECT4"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT57",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57"));
			sqlMap.put("SQL_PH_PRESCRIPTION_INSERT5",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5"));
			sqlMap.put("SQL_PH_PRESCRIPTION_SELECT56",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56"));
			sqlMap.put("SQL_PH_TDM_PRES_SELECT5",PhRepository.getPhKeyValue("SQL_PH_TDM_PRES_SELECT5"));
			//System.err.println(" tdm_dtl----------->"+tdm_dtl);
			map	=	localInsert(tabData, sqlMap);
	
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}

		return map;
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
						sys_date=resultSet.getString(1);
				}
		}
		catch ( Exception e ) {
				sys_date+=e.toString();
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
		return sys_date;
	}

	public HashMap localInsert(HashMap tabData, HashMap sqlMap) {

		HashMap map = new HashMap() ;
		PreparedStatement pstmt_insert			= null;
		PreparedStatement pstmt_clob			= null;
		PreparedStatement pstmt_select			= null;
		ResultSet resultSet						= null;
		Connection connection					= null;
		CallableStatement cstmt					= null ;
		String verify_yn							= "";
		String tdm_order_open_close_yn_1="N";
		String tdm_order_open_close_yn_value="";
		String tdm_order_open_close_yn_2="N";
		String order_status					= "";
		String episode_id						= "";
		String episode_num					= "";
		String regn_reqd_yn					= "";
		String ord_auth_reqd_yn			= "N";
		String order_id							= null;
		String sql_ph_prescription_select57		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT57");
		String sql_insert_5						= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT5");
		String sql_ph_prescription_select56		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT56");
		//String SQL_PH_TDM_PRES_SELECT5			= (String) sqlMap.get( "SQL_PH_TDM_PRES_SELECT5");
		
		int count	=	0;
		int result1 =0;
		boolean result	=	true;
		try {		
			connection	= getConnection();
			for(int i=0,j=0; i<tdm_dtl.size() && j<update_date_time.size(); i+=7,j++){
				if(!(CommonBean.checkForNull((String)tdm_dtl.get(i+6))).equals("")){
					tdm_order_open_close_yn_1="Y";
					tdm_order_open_close_yn_value=(String)tdm_dtl.get(i+6);
				}
				else{
					tdm_order_open_close_yn_2="N";
				}
			}
			String order_line_no	= null;
			int result_tdm_dtl=0;
			if(tdm_order_open_close_yn_1.equals("Y")){
				for(int i=0,j=0; i<tdm_dtl.size() && j<update_date_time.size(); i+=7,j++) {
					//String sql_String="INSERT INTO OR_ORDER_LINE_TDM_DTL(ORDER_ID, ORDER_LINE_NUM, SCH_DOSE_DATE_TIME,ORDER_CATALOG_CODE, SAMPLING_TYPE, SAMPLING_DURN,SAMPLING_DURN_TYPE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,SAMPLING_TIME_IND) VALUES(?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
					pstmt_insert	= connection.prepareStatement((String)sqlMap.get("SQL_PH_TDM_PRES_INSERT2"));
					//(String)sqlMap.get("SQL_PH_TDM_PRES_INSERT2")
					count			= 0;
					//order_id=(String)tabData.get("old_order_id");//commented by naveen to insert TDM order_id instead of parent ORDER_ID according to instructions given by sheelvanth
					// order_id=(String)tabData.get("order_id");
					//	if(order_id.equals("")||order_id==null)
						//{
						 // order_id=(String)tabData.get("order_id");
					//	}
					order_line_no=(String)tabData.get("old_line_no");
					if(order_line_no.equals("")||order_line_no==null)
					  order_line_no="1";
					pstmt_insert.setString(++count, tdm_order_open_close_yn_value);
					pstmt_insert.setString(++count, order_line_no);
					pstmt_insert.setString(++count, (String)tdm_dtl.get(i)); 
					pstmt_insert.setString(++count, (String)tdm_dtl.get(i+1)); 
					pstmt_insert.setString(++count, (String)tdm_dtl.get(i+2)); 
					pstmt_insert.setString(++count, (String)tdm_dtl.get(i+3)); 
					pstmt_insert.setString(++count, (String)tdm_dtl.get(i+4)); 
					pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
					pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
					pstmt_insert.setString(++count, (String)tabData.get("login_facility_id"));
					pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
					pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
					pstmt_insert.setString(++count, (String)tabData.get("login_facility_id"));
					pstmt_insert.setString(++count, (String)tdm_dtl.get(i+5));
					//pstmt_insert.addBatch();
					result_tdm_dtl = pstmt_insert.executeUpdate() ;
					if(result_tdm_dtl<=0) 
						result	=	false; 
	 
					cstmt=connection.prepareCall("{call OR_TDM_ORDER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					//for(int i=0,j=0; i<tdm_dtl.size() && j<update_date_time.size(); i+=6,j++) {
					cstmt.setString( 1, (String)update_date_time.get(j));
					cstmt.setString( 2, (String)tdm_dtl.get(i+1));
					cstmt.setString( 3, "OR");
					cstmt.setString( 4, (String)tabData.get("login_facility_id"));
					cstmt.setString( 5, (String)tabData.get("patient_id"));
					cstmt.setString( 6, getActualPatientClass());//Added for AMS-SCF-0424 and ML-MMOH-SCF-0500 and removed tabdat.get("patient_calss")
					cstmt.setString( 7, (String)tabData.get("encounter_id"));
					cstmt.setString( 8, episode_id);
					cstmt.setString( 9, episode_num);
					cstmt.setString( 10, (String)tabData.get("location_type"));
					cstmt.setString( 11, (String)tabData.get("location_code"));
					cstmt.setString( 12, (String)tabData.get("pract_id"));
					cstmt.setString( 13, (String)tabData.get("login_by_id"));
					cstmt.setString( 14, (String)tabData.get("login_at_ws_no"));
					cstmt.setString( 15, "N");
					cstmt.setString( 16, tdm_order_open_close_yn_value);
					cstmt.setString(17, (String)tabData.get("clinical_comments") ); // Added on 4/21/2006 by Ram to pass clinical_comments
					cstmt.registerOutParameter(18, Types.VARCHAR );
					cstmt.execute() ;
					String err_msg	=	checkForNull(cstmt.getString( 18 ));
	
	//System.err.println("err_msg---665--->"+err_msg);
					if(!err_msg.equals("")){
						throw new Exception(err_msg);
					}
					 //}
					closeStatement( cstmt ) ;
					closeStatement( pstmt_insert ) ;
				}
			}
			else{
				//connection	= getConnection();
				// find the order status

				pstmt_select	=	connection.prepareStatement((String)sqlMap.get("SQL_PH_TDM_PRES_SELECT3"));
				pstmt_select.setString(1,(String)tabData.get("login_facility_id"));
				resultSet	=	pstmt_select.executeQuery();

				if(resultSet!=null && resultSet.next()){
					verify_yn	=	resultSet.getString("VERIFY_TDM_ORDER_YN");
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_select ) ;

				if(verify_yn!=null && verify_yn.equals("N")) {
					pstmt_select	=	connection.prepareStatement((String)sqlMap.get("SQL_PH_TDM_PRES_SELECT4"));
					resultSet	=	pstmt_select.executeQuery();
					if(resultSet!=null && resultSet.next()){
						regn_reqd_yn	= resultSet.getString("REGN_REQD_YN");
					}
					closeResultSet( resultSet ) ;
				   closeStatement( pstmt_select ) ;
					if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y")) {
						order_status	=	"RG";
					} 
				}
				else {
					order_status	=	"PO";
					ord_auth_reqd_yn ="Y";
				}
				if(order_status.equals("")){
					order_status	=	"OS";
				}
				pstmt_select	=	connection.prepareStatement((String)sqlMap.get("SQL_PH_TDM_PRES_SELECT5"));
				pstmt_select.setString(1,(String)tabData.get("encounter_id"));
				pstmt_select.setString(2,(String)tabData.get("login_facility_id"));
				resultSet	=	pstmt_select.executeQuery();
				if(resultSet!=null && resultSet.next()){
					episode_id	= resultSet.getString("EPISODE_ID");
					episode_num = resultSet.getString("OP_EPISODE_VISIT_NUM");
				}	
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_select ) ;

				try{
						//Insert into OR_ORDER
						//pstmt_insert	= connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT1"));
						pstmt_insert	= connection.prepareStatement("INSERT INTO OR_ORDER (ORDER_ID, ORDER_TYPE_CODE, ORDER_CATEGORY, CONTR_SYS_ID, PATIENT_ID, PATIENT_CLASS, ORDERING_FACILITY_ID, ENCOUNTER_ID, EPISODE_ID, EPISODE_VISIT_NUM, SOURCE_TYPE, SOURCE_CODE, DISCHARGE_IND, ORD_DATE_TIME, ORD_PRACT_ID, PRIORITY, ORD_AUTH_REQD_YN, ORD_AUTH_LEVEL, ORD_AUTH_BY_PRACT_ID, ORD_AUTH_DATE_TIME, ORD_APPR_REQD_YN, ORD_APPR_BY_USER_ID, ORD_APPR_DATE_TIME, ORD_COSIGN_REQD_YN, ORD_COSIGN_LEVEL, ORD_COSIGN_BY_PRACT_ID, ORD_COSIGN_DATE_TIME, ORD_PRINT_DATE_TIME, BILL_YN, CONT_ORDER_IND, PERFORMING_FACILITY_ID, PERFORMING_SYS_ID, PERFORMING_DEPTLOC_TYPE, PERFORMING_DEPTLOC_CODE, PERFORMING_PRACT_ID, RESULT_AUTH_REQD_YN, CHILD_ORDER_YN, PARENT_ORDER_ID, ORDER_SET_YN, ORDER_SET_ID, IV_PREP_YN, ORDER_FIELDS_DISPLAY_TEXT, ORDER_STATUS, RESULT_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, ORD_CONSENT_REQD_YN, ORD_CONSENT_BY_ID, ORD_CONSENT_BY_DATE_TIME, CAN_REASON, TRN_GROUP_REF) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), ?, ?, ?, ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), ?, ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), to_date(?, 'dd/mm/yyyy hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), ?,?)");
						pstmt_insert.setString(++count, (String)tabData.get("order_id"));				// ORDER_ID
						pstmt_insert.setString(++count, "TDM");											// ORDER_TYPE_CODE
						pstmt_insert.setString(++count, "PH");											//ORDER_CATEGORY
						pstmt_insert.setString(++count, "PH");											//CONTR_SYS_ID
						pstmt_insert.setString(++count, (String)tabData.get("patient_id"));				//PATIENT_ID
						pstmt_insert.setString(++count, (String)tabData.get("patient_class"));			//PATIENT_CLASS
						pstmt_insert.setString(++count, (String)tabData.get("login_facility_id"));		//ORDERING_FACILITY_ID
						pstmt_insert.setString(++count, (String)tabData.get("encounter_id"));			//ENCOUNTER_ID
						pstmt_insert.setString(++count, episode_id);									//EPISODE_ID
						pstmt_insert.setString(++count, episode_num);									//EPISODE_VISIT_NUM
						pstmt_insert.setString(++count, (String)tabData.get("location_type"));			//SOURCE_TYPE
						pstmt_insert.setString(++count, (String)tabData.get("location_code"));			//SOURCE_CODE
						pstmt_insert.setString(++count, "");											//DISCHARGE_IND
						pstmt_insert.setString(++count, (String)tabData.get("sys_date"));				//ORD_DATE_TIME
						pstmt_insert.setString(++count,(String)tabData.get("pract_id"));				//ORD_PRACT_ID
						pstmt_insert.setString(++count, "R");											//PRIORITY
						pstmt_insert.setString(++count,ord_auth_reqd_yn);											//ORD_AUTH_REQD_YN
						pstmt_insert.setString(++count, "");											//ORD_AUTH_LEVEL
						pstmt_insert.setString(++count, (String)tabData.get("pract_id"));				//ORD_AUTH_BY_PRACT_ID
						pstmt_insert.setString(++count, (String)tabData.get("sys_date"));				//ORD_AUTH_DATE_TIME
						pstmt_insert.setString(++count, "N");											//ORD_APPR_REQD_YN
						pstmt_insert.setString(++count, "");											//ORD_APPR_BY_USER_ID
						pstmt_insert.setString(++count, null);											//ORD_APPR_DATE_TIME
						pstmt_insert.setString(++count, "N");											//ORD_COSIGN_REQD_YN
						pstmt_insert.setString(++count, "");											//ORD_COSIGN_LEVEL
						pstmt_insert.setString(++count, "");											//ORD_COSIGN_BY_PRACT_ID
						pstmt_insert.setString(++count, null);											//ORD_COSIGN_DATE_TIME
						pstmt_insert.setString(++count, null);											//ORD_PRINT_DATE_TIME
						pstmt_insert.setString(++count, "N");											//BILL_YN
						pstmt_insert.setString(++count, "CO");											//CONT_ORDER_IND
						pstmt_insert.setString(++count, (String)tabData.get("login_facility_id"));		//PERFORMING_FACILITY_ID
						pstmt_insert.setString(++count, "PH");											//PERFORMING_SYS_ID
						pstmt_insert.setString(++count, "");											//PERFORMING_DEPTLOC_TYPE
						pstmt_insert.setString(++count, "");											//PERFORMING_DEPTLOC_CODE
						pstmt_insert.setString(++count, "");											//PERFORMING_PRACT_ID
						pstmt_insert.setString(++count, "N");											//RESULT_AUTH_REQD_YN
						pstmt_insert.setString(++count, "Y");											//CHILD_ORDER_YN

						order_id=(String)tabData.get("old_order_id");
						if(order_id.equals("")||order_id==null){
						  order_id=(String)tabData.get("order_id");
						}
						pstmt_insert.setString(++count, order_id);										//PARENT_ORDER_ID
						pstmt_insert.setString(++count, "N");											//ORDER_SET_YN
						pstmt_insert.setString(++count, "");											//ORDER_SET_ID
						pstmt_insert.setString(++count, "");											//IV_PREP_YN (continuous)
						pstmt_insert.setString(++count, "");											//ORDER_FIELDS_DISPLAY_TEXT
						pstmt_insert.setString(++count, order_status);									//ORDER_STATUS
						pstmt_insert.setString(++count, "");											//RESULT_STATUS
						pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));			//ADDED_BY_ID
						pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));			//ADDED_AT_WS_NO
						pstmt_insert.setString(++count, (String)tabData.get("login_facility_id"));		//ADDED_FACILITY_ID
						pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));			//MODIFIED_BY_ID
						pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));			//MODIFIED_AT_WS_NO
						pstmt_insert.setString(++count, (String)tabData.get("login_facility_id"));		//MODIFIED_FACILITY_ID
						pstmt_insert.setString(++count, "N");											//ORD_CONSENT_REQD_YN
						pstmt_insert.setString(++count, "");											//ORD_CONSENT_BY_ID
						pstmt_insert.setString(++count, null);											//ORD_CONSENT_BY_DATE_TIME
						pstmt_insert.setString(++count, "");											//CAN_REASON
						pstmt_insert.setString(++count, "");											//CAN_REASON
						result1	=	pstmt_insert.executeUpdate();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					closeStatement( pstmt_insert ) ;

					// OR_ORDER_LINE 
					String short_desc	=	"";
					drug_desc			=	(String)tabData.get("drug_desc");
					drug_desc			=	"TDM detail for "+drug_desc;
					//pstmt_insert		=	null;
					pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT2"));
					if( (drug_desc).length() > 39) {
						short_desc	=	(drug_desc).substring(0,39);
					} else {
						short_desc	=	drug_desc;
					}
					pstmt_insert.setString(1, (String)tabData.get("order_id"));
					pstmt_insert.setString(2, "1");
					pstmt_insert.setString(3, (String)tabData.get("drug_code"));
					pstmt_insert.setString(4, short_desc);
					pstmt_insert.setString(5, short_desc);
					pstmt_insert.setString(6, "A");
					pstmt_insert.setString(7, "TDM");
					pstmt_insert.setString(8, "PH");
					pstmt_insert.setString(9, (String)tabData.get("sys_date") );
					pstmt_insert.setString(10, "R");
					pstmt_insert.setString(11, ord_auth_reqd_yn);
					pstmt_insert.setString(12, "");
					pstmt_insert.setString(13, "N");
					pstmt_insert.setString(14, "N");
					pstmt_insert.setString(15,(String)tabData.get("sys_date") );
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
					pstmt_insert.setString(33, "Y");
					pstmt_insert.setString(34, "N");
					pstmt_insert.setString(35, "N");
					pstmt_insert.setString(36, "CO");
					pstmt_insert.setString(37, "N");
					pstmt_insert.setString(38, "");
					pstmt_insert.setString(39, "Y");
					order_id=(String)tabData.get("old_order_id");
					if(order_id==null||order_id.equals("")){
					  order_id=(String)tabData.get("order_id");

					}
					pstmt_insert.setString(40, order_id);
					pstmt_insert.setString(41, "1");
					pstmt_insert.setString(42, "");
					pstmt_insert.setString(43, "");
					pstmt_insert.setString(44, (String)tabData.get("pract_id"));
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
					pstmt_insert.setString(58, order_status); // line status
					pstmt_insert.setString(59, "");
					pstmt_insert.setString(60, (String)tabData.get("login_by_id"));
					pstmt_insert.setString(61, (String)tabData.get("login_at_ws_no"));
					pstmt_insert.setString(62, (String)tabData.get("login_facility_id"));
					pstmt_insert.setString(63, (String)tabData.get("login_by_id"));
					pstmt_insert.setString(64, (String)tabData.get("login_at_ws_no"));
					pstmt_insert.setString(65, (String)tabData.get("login_facility_id"));
					pstmt_insert.setString(66, "N");
					pstmt_insert.setString(67, "");
					pstmt_insert.setString(68, short_desc);
					pstmt_insert.setString(69, short_desc);
					pstmt_insert.setString(70, "N");
					result1	=	pstmt_insert.executeUpdate();
					closeStatement( pstmt_insert ) ;
 
					if(result1<=0) {
						result	=	false;
					}

					// OR_ORDER_LINE_TDM
					count				 = 0;
					//pstmt_insert		 = null;
					pstmt_insert		 = connection.prepareStatement((String)sqlMap.get("SQL_PH_TDM_PRES_INSERT1"));
					order_id=(String)tabData.get("order_id");
					//order_id=(String)tabData.get("old_order_id");//commented by naveen to insert TDM order_id insted of parent ORDER_ID
					if(order_id.equals("")||order_id==null){
					  order_id=(String)tabData.get("order_id");
					}
					order_line_no=(String)tabData.get("old_line_no");
					if(order_line_no.equals("")||order_line_no==null){
					  order_line_no="1";
					}

					pstmt_insert.setString(++count,  order_id );
					pstmt_insert.setString(++count, order_line_no);
					pstmt_insert.setString(++count, (String)tabData.get("reason"));
					pstmt_insert.setString(++count, (String)tabData.get("smoking_yn"));
					pstmt_insert.setString(++count, (String)tabData.get("alcohol_yn"));
					pstmt_insert.setString(++count, (String)tabData.get("pregnant_yn"));
					pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
					pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
					pstmt_insert.setString(++count, (String)tabData.get("login_facility_id"));
					pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
					pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
					pstmt_insert.setString(++count, (String)tabData.get("login_facility_id"));
					pstmt_insert.setString(++count, (String)tabData.get("clinical_comments"));
					result1	=	pstmt_insert.executeUpdate();
					closeStatement( pstmt_insert ) ;

					//OR_ORDER_LINE_TDM_DTL
					count			=	0;
					pstmt_insert	= connection.prepareStatement((String)sqlMap.get("SQL_PH_TDM_PRES_INSERT2"));
					for(int i=0; i<tdm_dtl.size(); i+=7) {
						count			= 0;
						order_id		= null;
						order_line_no	= null;
						//order_id=(String)tabData.get("old_order_id");//commented by naveen to insert TDM order_id instead of parent ORDER_ID according to instructions given by sheelvanth
						 order_id=(String)tabData.get("order_id");
						if(order_id.equals("")||order_id==null){
						  order_id=(String)tabData.get("order_id");
						}
						order_line_no=(String)tabData.get("old_line_no");
						 
						if(order_line_no.equals("")||order_line_no==null){
						  order_line_no="1";
						}
						
						pstmt_insert.setString(++count, order_id);
						pstmt_insert.setString(++count, order_line_no);
						pstmt_insert.setString(++count, (String)tdm_dtl.get(i)); 
						pstmt_insert.setString(++count, (String)tdm_dtl.get(i+1)); 
						pstmt_insert.setString(++count, (String)tdm_dtl.get(i+2)); 
						pstmt_insert.setString(++count, (String)tdm_dtl.get(i+3)); 
						pstmt_insert.setString(++count, (String)tdm_dtl.get(i+4)); 
						pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
						pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
						pstmt_insert.setString(++count, (String)tabData.get("login_facility_id"));
						pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
						pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
						pstmt_insert.setString(++count, (String)tabData.get("login_facility_id"));
						pstmt_insert.setString(++count, (String)tdm_dtl.get(i+5));
						pstmt_insert.addBatch();
					}
				   int[] result_insert= pstmt_insert.executeBatch();
					 //System.err.println("result_insert---OR_ORDER_LINE_TDM_DTL--->"+result_insert.length);
					for (int i=0;i<result_insert.length ;i++ ){
					if(result_insert[i]<0  && result_insert[i] != -2 ){
						result	=	false;
					}
				}
				// or procedure
				cstmt=connection.prepareCall("{call OR_TDM_ORDER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				for(int i=0,j=0; i<tdm_dtl.size() && j<update_date_time.size(); i+=7,j++) {
				cstmt.setString( 1, (String)update_date_time.get(j));
				cstmt.setString( 2, (String)tdm_dtl.get(i+1));
				cstmt.setString( 3, "OR");
				cstmt.setString( 4, (String)tabData.get("login_facility_id"));
				cstmt.setString( 5, (String)tabData.get("patient_id"));
				cstmt.setString( 6, getActualPatientClass());//Added for AMS-SCF-0424 and ML-MMOH-SCF-0500
				//cstmt.setString( 6, (String)tabData.get("patient_class"));//commented for AMS-SCF-0424 and ML-MMOH-SCF-0500

				cstmt.setString( 7, (String)tabData.get("encounter_id"));
				cstmt.setString( 8, episode_id);
				cstmt.setInt( 9, Integer.parseInt(checkForNull(episode_num,"0")));
				cstmt.setString( 10, (String)tabData.get("location_type"));
				cstmt.setString( 11, (String)tabData.get("location_code"));
				cstmt.setString( 12, (String)tabData.get("pract_id"));
				cstmt.setString( 13, (String)tabData.get("login_by_id"));
				cstmt.setString( 14, (String)tabData.get("login_at_ws_no"));
				cstmt.setString( 15, "N");
				cstmt.setString( 16, (String)tabData.get("order_id"));

				cstmt.setString(17, (String)tabData.get("clinical_comments") ); // Added on 4/21/2006 by Ram to pass clinical_comments
				cstmt.registerOutParameter(18, Types.VARCHAR );
				cstmt.execute() ;
				err_msg	=	checkForNull(cstmt.getString( 18 ));
				if(!err_msg.equals(""))
					throw new Exception(err_msg);
				}
				closeStatement( cstmt ) ;

				String action_seq_num	=	"";
				order_id=(String)tabData.get("order_id");

				pstmt_select			= connection.prepareStatement(sql_ph_prescription_select56) ;
				pstmt_select.setString(1,(String)tabData.get("order_id"));

				resultSet		= pstmt_select.executeQuery();
				if(resultSet!=null && resultSet.next()){
					action_seq_num	=resultSet.getString(1);
				}
				closeStatement( pstmt_insert ) ;
				closeResultSet( resultSet ) ;

				//pstmt_insert=null;
				//String login_by_id=(String)tabData.get("login_by_id");
				//String login_at_ws_no=(String)tabData.get("login_at_ws_no");
				//String login_facility_id=(String)tabData.get("login_facility_id");
				pstmt_insert		= connection.prepareStatement(sql_insert_5) ;
				pstmt_insert.setString(1,(String)tabData.get("order_id"));
				pstmt_insert.setString(2,action_seq_num);
				pstmt_insert.setString(3,(String)tabData.get("login_by_id"));         			
				pstmt_insert.setString(4,(String)tabData.get("login_at_ws_no"));
				pstmt_insert.setString(5,(String)tabData.get("login_facility_id"));
				pstmt_insert.setString(6,(String)tabData.get("login_by_id"));
				pstmt_insert.setString(7,(String)tabData.get("login_at_ws_no"));
				pstmt_insert.setString(8,(String)tabData.get("login_facility_id"));
				result1 = pstmt_insert.executeUpdate() ;

				if(result1>0){
					pstmt_clob		= connection.prepareStatement(sql_ph_prescription_select57) ;
					pstmt_clob.setString(1,(String)tabData.get("order_id"));
					pstmt_clob.setString(2,action_seq_num);
					resultSet		=	pstmt_clob.executeQuery();
					if(resultSet!=null){
						Clob clb = null;
						BufferedWriter bw  = null;
						while(resultSet.next()){
							clb 	= (Clob) resultSet.getClob(1);
							bw 	= new BufferedWriter(clb.setCharacterStream(0));
							bw.write((String)tabData.get("clinical_comments"),0,((String)tabData.get("clinical_comments")).length());
							bw.flush();
							bw.close();
						}
					}
					closeResultSet( resultSet );
				}
			}
			connection.commit();
			String getLanguageId=(String)tabData.get("getLanguageId");
			map.put( "result", new Boolean( true ) ) ;
			//map.put("message",getMessage("RECORD_INSERTED")) ;
			map.put( "message", getMessage(getLanguageId,"RECORD_INSERTED","PH") ) ;
			map.put("flag","");

		} 
		catch(Exception e) {
			e.printStackTrace();
			try {
				
				map.put( "result", new Boolean( false ) ) ;
				if(!err_msg.equals("")) 
					map.put("message",err_msg) ;
				else
					map.put("message","exception" ) ;
				map.put("flag","");
				connection.rollback();
			}
			catch (Exception ee) {
				if(!err_msg.equals(""))
					map.put("message",err_msg) ;
				else 
					map.put("message", ee.getMessage());
				ee.printStackTrace();
			}
			if(!err_msg.equals("")) 
				map.put("message",err_msg) ;
			else 
				map.put("message", e.getMessage());
		}
		finally {
			try{
			closeStatement(pstmt_insert);
			closeStatement(pstmt_select);
			closeStatement(pstmt_clob);
			closeConnection( connection );
			closeResultSet( resultSet ) ;

			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}


	// Getting the Drug Profile
	public void setPatientDetails(){
		String	strQuery			= "";
		String	strPatientName		= "" ;
		String	strSex				= "";
		String	strAge				= "";
		Connection conTDM			= null ;
		PreparedStatement pstTDM    = null ;
		ResultSet rsTDM		        = null ;		


		try{
			strQuery = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT43");
			conTDM = getConnection() ;

			pstTDM			= conTDM.prepareStatement(strQuery) ;
			pstTDM.setString(1,getLanguageId());
			pstTDM.setString(2,getPatientId().trim());
			
			rsTDM			= pstTDM.executeQuery();

			if ( rsTDM != null && rsTDM.next() ){
				strPatientName	=	rsTDM.getString("PATIENT_NAME");
				strSex			=	rsTDM.getString("SEX");
				strAge			=	rsTDM.getString("AGE");

				if(strSex != null && strSex.equals("Female") )
					strSex ="F";
				else if(strSex.equals("Male") )
					strSex = "M";
				else
					strSex ="U";

				int nIdx = 0;
				nIdx = strAge.indexOf("Y");
				
				if(nIdx >= 0){
					setAgeUnit("Y");
					strAge = strAge.substring(0,nIdx);	
				}
				else if (nIdx < 0){
					nIdx = strAge.indexOf("M");

					if(nIdx >= 0){
						setAgeUnit("M");
						strAge = strAge.substring(0,nIdx);	
					}
					else if(nIdx < 0){
						nIdx = strAge.indexOf("D");
						
						if(nIdx >= 0){
							setAgeUnit("D");
							strAge = strAge.substring(0,nIdx);	
						}
					}
				}			
			}
		
			setPatientSex(strSex);
			setPatientAge(strAge);
		}
		catch (Exception eDP){
			eDP.printStackTrace();
		}
		finally{
			try{
				closeResultSet(rsTDM);
				closeStatement(pstTDM);
				closeConnection(conTDM);
			}
			catch (Exception e){
				e.printStackTrace() ;
			}
		}
	}
	
	public void getLabTests1(String strDrugCode){
		Connection conTDM			= null ;
		PreparedStatement pstTDM    = null ;
		ResultSet rsTDM		        = null ;
		String strQuery						= "";
		ArrayList alTemp ; 
		String steady_state_durn="";
		String steady_state_durn_type="";

		try{
			
			strQuery = PhRepository.getPhKeyValue("SQL_PH_TDM_PRES_SELECT1");
			conTDM = getConnection() ;
			pstTDM			= conTDM.prepareStatement(strQuery) ;
			pstTDM.setString(1,strDrugCode);
			pstTDM.setString(2,getPatientId().trim());
			
			rsTDM			= pstTDM.executeQuery();
			while (rsTDM.next()){ 
				alTemp= new ArrayList();
				setAgeGroupCode(rsTDM.getString("AGE_GROUP_CODE"));
				alTemp.add(rsTDM.getString("SAMPLING_TIME") );
				alTemp.add(rsTDM.getString("SAMPLING_TIME_DURN_TYPE") );
				steady_state_durn=(String.valueOf(rsTDM.getInt("STEADY_STATE_DURN")));
				steady_state_durn_type=rsTDM.getString("STEADY_STATE_DURN_TYPE");
				m_htAgeGroupData.put(rsTDM.getString("SAMPLING_TYPE"),alTemp);		
			}
			m_htAgeGroupData.put("steady_state_durn",steady_state_durn);
			m_htAgeGroupData.put("steady_state_durn_type",steady_state_durn_type);
		}
		catch (Exception eDP){
			eDP.printStackTrace();
		}
		finally{
			try{
				closeResultSet(rsTDM);
				closeStatement(pstTDM);
				closeConnection(conTDM);
			}
			catch (Exception e){
				e.printStackTrace() ;
			}
		}
	}

	public Hashtable getLabTests2(String strDrugCode,String strSamplingType){
		Connection conTDM			= null ;
		PreparedStatement pstTDM    = null ;
		ResultSet rsTDM		        = null ;
		String strQuery						= "";
		Hashtable htLabTests				= new Hashtable();

		try{
			strQuery = PhRepository.getPhKeyValue("SQL_PH_TDM_PRES_SELECT2");
			conTDM	= getConnection() ;

			//System.err.println("strSamplingType------------>"+strSamplingType);
			//System.err.println("getAgeGroupCode------------>"+getAgeGroupCode());
			pstTDM	 = conTDM.prepareStatement(strQuery) ;
			pstTDM.setString(1,strDrugCode);
			pstTDM.setString(2,getAgeGroupCode().trim());
			pstTDM.setString(3,strSamplingType);
			pstTDM.setString(4,getLanguageId());
			rsTDM			= pstTDM.executeQuery();
			while (rsTDM.next()){
				htLabTests.put(checkForNull((String)rsTDM.getString("ORDER_CATALOG_CODE")),checkForNull((String)rsTDM.getString("SHORT_DESC")));

			}
		}
		catch (Exception eDP){
			eDP.printStackTrace();
		}
		finally{
			try{
				closeResultSet(rsTDM);
				closeStatement(pstTDM);
				closeConnection(conTDM);
			}
			catch (Exception e){

				e.printStackTrace();
			}
		}
		//System.err.println("htLabTests-----getLabTests2()--->"+htLabTests);
		return htLabTests;
	}

	public ArrayList getDrugDuration(String strSampType){
		ArrayList alDrugDur = new ArrayList();
		try{
			alDrugDur = (ArrayList) m_htAgeGroupData.get(strSampType);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return alDrugDur;
	}

	public ArrayList getSampleTypeDescription(String drug_sampling_type_code){
		Connection conTDM			= null ;
		PreparedStatement pstTDM    = null ;
		ResultSet rsTDM		        = null ;
		String strQuery						= "";
		ArrayList alsampletype					= new ArrayList();

		try{
			strQuery = PhRepository.getPhKeyValue("SQL_PH_TDM_SAMPLE_TYPE_SELECT1");
			conTDM = getConnection() ;
			pstTDM			= conTDM.prepareStatement(strQuery) ;
			pstTDM.setString(1,drug_sampling_type_code);

			rsTDM			= pstTDM.executeQuery();
			while( rsTDM.next() ){
				alsampletype.add(rsTDM.getString("sampling_type"));
			}
		}
		catch (Exception eDP){
			eDP.printStackTrace();
		}
		finally{
			try{
				closeResultSet(rsTDM);
				closeStatement(pstTDM);
				closeConnection(conTDM);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		//System.err.println("alsampletype---------------->"+alsampletype);
		return alsampletype;
	}

	public ArrayList getDrugProfile(){
		Connection conTDM			= null ;
		PreparedStatement pstTDM    = null ;
		ResultSet rsTDM		        = null ;
		String strQuery						= "";
		ArrayList alDrugPro					= new ArrayList();

		try{
			//strQuery = PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT_DRUG_PROFILE");
			strQuery = "SELECT B.DRUG_CODE,B.ORIG_ORDER_ID,B.ORIG_ORDER_LINE_NO,A.DRUG_DESC, B.PRES_PRACTITIONER_ID,D.FORM_DESC,C.FREQ_DESC,TO_CHAR(B.START_DATE,'DD/MM/YYYY HH24:MI') START_DATE,TO_CHAR(B.END_DATE,'DD/MM/YYYY HH24:MI') END_DATE,NVL(DECODE( B.PATIENT_CLASS,  'IP',  F.LONG_DESC,  'EA',  F.LONG_DESC,  E.LONG_DESC ),'') LOCATION,NVL((select 'Y' ||'|' ||order_id || '|'|| b.orig_order_line_no from or_order where patient_id = b.patient_id and order_type_code = 'TDM' and ORDER_Category = 'PH' and patient_class = 'IP' and parent_order_id = b.orig_order_id and rownum <=1),'N') CHKEXISTENCE,rt.route_desc, rt.route_color FROM PH_DRUG_LANG_VW A, PH_PATIENT_DRUG_PROFILE B, AM_FREQUENCY_LANG_VW C, PH_FORM_LANG_VW D, OP_CLINIC_LANG_VW E,IP_NURSING_UNIT_LANG_VW F, ph_route_lang_vw rt WHERE B.PATIENT_ID = ? AND A.DRUG_CODE=B.DRUG_CODE AND B.FORM_CODE=D.FORM_CODE AND A.APPL_TO_TDM_YN='Y' AND B.FREQ_CODE=C.FREQ_CODE AND B.LOCN_CODE=E.CLINIC_CODE(+) AND B.LOCN_CODE=F.NURSING_UNIT_CODE(+) AND B.FACILITY_ID=E.FACILITY_ID (+) AND B.FACILITY_ID = F.FACILITY_ID (+) AND  B.END_DATE > SYSDATE AND B.CANCEL_DATE_TIME IS NULL AND B.DISCONT_DATE_TIME IS  NULL AND B.ON_HOLD_DATE_TIME IS  NULL AND A.LANGUAGE_ID = C.LANGUAGE_ID AND A.LANGUAGE_ID = D.LANGUAGE_ID AND A.LANGUAGE_ID = ? AND E.LANGUAGE_ID(+) = ? AND F.LANGUAGE_ID(+) = ? AND rt.route_code = b.route_code AND rt.language_id =? ORDER BY B.ORIG_ORDER_ID,B.ORIG_ORDER_LINE_NO";// added B.ROUTE_CODE for CRF RUT-CRF-0034.1[IN:037389]-start

			conTDM = getConnection() ;

			pstTDM			= conTDM.prepareStatement(strQuery) ;
			pstTDM.setString(1,getPatientId());
			pstTDM.setString(2,getLanguageId());
			pstTDM.setString(3,getLanguageId());
			pstTDM.setString(4,getLanguageId());
			pstTDM.setString(5,getLanguageId());

			rsTDM			= pstTDM.executeQuery();

			while( rsTDM.next() ){
				alDrugPro.add(rsTDM.getString("DRUG_DESC")); //0
				alDrugPro.add(rsTDM.getString("FORM_DESC"));
				alDrugPro.add(rsTDM.getString("FREQ_DESC"));
				alDrugPro.add(rsTDM.getString("START_DATE"));
				alDrugPro.add(rsTDM.getString("END_DATE"));
				alDrugPro.add(rsTDM.getString("PRES_PRACTITIONER_ID"));
				alDrugPro.add(rsTDM.getString("LOCATION"));
				alDrugPro.add(rsTDM.getString("ORIG_ORDER_ID"));
				alDrugPro.add(rsTDM.getString("ORIG_ORDER_LINE_NO"));
				alDrugPro.add(rsTDM.getString("DRUG_CODE"));
				alDrugPro.add(rsTDM.getString("CHKEXISTENCE"));
    			alDrugPro.add(rsTDM.getString("route_desc"));
				alDrugPro.add(checkForNull(rsTDM.getString("route_color")));// 12 added  for CRF RUT-CRF-0034.1[IN:037389]
			}
		}
		catch (Exception eDP){
			eDP.printStackTrace();
		}
		finally{
			try{
				closeResultSet(rsTDM);
				closeStatement(pstTDM);
				closeConnection(conTDM);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		return alDrugPro;
	}

	// Getting the Details of a Particular Order No and the Line Number
	public ArrayList getOrderDetails(){
		
		Connection conTDM			= null ;
		PreparedStatement pstTDM    = null ;
		ResultSet rsTDM		        = null ;
		PreparedStatement pstTDM1    = null ;
		ResultSet rsTDM1		        = null ; 
		String strQuery				= "";
		ArrayList alOrdDetl			= new ArrayList();
		ArrayList steady_state_values			= new ArrayList();
		try{
			conTDM = getConnection() ;
			String strQuery1 = PhRepository.getPhKeyValue("SQL_PH_TDM_PRES_SELECT1");
			pstTDM1			= conTDM.prepareStatement(strQuery1) ;
			
			pstTDM1.setString(1,getDrugCode());
			pstTDM1.setString(2,getPatientId().trim());
			
			rsTDM1			= pstTDM1.executeQuery();
			while (rsTDM1.next()){ 
				steady_state_values.add((String.valueOf(rsTDM1.getInt("STEADY_STATE_DURN"))));
				steady_state_values.add(rsTDM1.getString("STEADY_STATE_DURN_TYPE"));
			}
			//strQuery = PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT_ORDER_DTLS");
 			if(steady_state_values.size()!=0){
			strQuery = "SELECT TO_CHAR(SCH_DATE_TIME,'DD/MM/YYYY') SCH_DATE,TO_CHAR(SCH_DATE_TIME,'HH24:MI') SCH_TIME,TO_CHAR(SCH_DATE_TIME,'DD/MM/YYYY hh24:mi') SCH_DATE_TIME, SCH_DOSAGE_QTY || '  ' || SCH_DOSAGE_UOM_CODE  DOSAGE,(SELECT DISTINCT B.ORDER_ID   FROM OR_ORDER_LINE_TDM_DTL B, OR_ORDER C, OR_ORDER_STATUS_CODE D   WHERE C.ORDER_CATEGORY = 'PH'   AND C.ORDER_TYPE_CODE = 'TDM'   AND C.PARENT_ORDER_ID = A.ORDER_ID  AND C.ORDER_ID = B.ORDER_ID  AND B.ORDER_LINE_NUM = A.ORDER_LINE_NUM   AND B.SCH_DOSE_DATE_TIME = A.SCH_DATE_TIME   AND D.ORDER_STATUS_CODE = C.ORDER_STATUS       AND D.ORDER_STATUS_TYPE <= 10)  OPEN_TDM_ORDER_ID ,TO_CHAR (sch_date_time, 'YYYYMMDDhh24mi') sch_date_time1     FROM    PH_MEDN_ADMIN A   WHERE  PATIENT_ID=?  AND  A.ORDER_ID=?  AND  ORDER_LINE_NUM=?  AND   SCH_DATE_TIME > (SELECT MIN(SCH_DATE_TIME) - DECODE(?,'D',(?),'H',(?/24),'M',(?/(24*60)))    FROM  PH_MEDN_ADMIN   WHERE  PATIENT_ID=?   AND  ORDER_ID=?  AND  ORDER_LINE_NUM=? )  ORDER BY 6 ";//changed from -DECODE(?,'D',(?),'H',(?/24),'M',(?/(24*60))) as +DECODE(?,'D',(?),'H',(?/24),'M',(?/(24*60))) for HSA-SCF-0153[IN052141]
			pstTDM			= conTDM.prepareStatement(strQuery) ;
			pstTDM.setString(1,getPatientId().trim());
			pstTDM.setString(2,getOrderId().trim());
			pstTDM.setString(3,getOrderLineNum().trim());
			pstTDM.setString(4,(String)steady_state_values.get(1));
			pstTDM.setInt(5,Integer.parseInt((String)steady_state_values.get(0)));
			pstTDM.setInt(6,Integer.parseInt((String)steady_state_values.get(0)));
			pstTDM.setInt(7,Integer.parseInt((String)steady_state_values.get(0)));
			pstTDM.setString(8,getPatientId().trim());
			pstTDM.setString(9,getOrderId().trim());
			pstTDM.setString(10,getOrderLineNum().trim());
			
			rsTDM			= pstTDM.executeQuery();
			while( rsTDM.next() ){
				alOrdDetl.add( rsTDM.getString("SCH_DATE") );
				alOrdDetl.add( rsTDM.getString("SCH_TIME") );
				alOrdDetl.add( rsTDM.getString("DOSAGE") );
				alOrdDetl.add( rsTDM.getString("SCH_DATE_TIME") );
				alOrdDetl.add( rsTDM.getString("OPEN_TDM_ORDER_ID") );
			  }//end while
			} // if
		}
		catch (Exception eOrdDet){
			eOrdDet.printStackTrace();
		}
		finally{
			try{
				closeResultSet(rsTDM1);
				closeResultSet(rsTDM);
				closeStatement(pstTDM);
				closeStatement(pstTDM1);//common-icn-0029
				closeConnection(conTDM);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}

		//System.err.println("alOrdDetl-----getOrderDetails()-first method--------->"+alOrdDetl);
		return alOrdDetl;
	}

	// Getting the Lab Test
  public Hashtable getLabTest(){
		Connection conTDM			= null ;
		PreparedStatement pstTDM    = null ;
		ResultSet rsTDM		        = null ;
		String strQuery						= "";

		Hashtable htLabTest = new Hashtable();
		try{
			strQuery = PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT_REASON");
			conTDM = getConnection() ;

			pstTDM			= conTDM.prepareStatement(strQuery) ;
			pstTDM.setString(1,getLanguageId());
			rsTDM			= pstTDM.executeQuery();

			while( rsTDM.next() ){
				htLabTest.put( rsTDM.getString("REASON_CODE"), rsTDM.getString("REASON_DESC"));
			}
		}
		catch (Exception eTDMReason){
			eTDMReason.printStackTrace();
		}
		finally{
			try{
				closeResultSet(rsTDM);
				closeStatement(pstTDM);
				closeConnection(conTDM);
			}
			catch (Exception e){
				e.printStackTrace() ;
			}
		}
		return htLabTest;
	}

	// Getting the Reason Codes
	public Hashtable getReasonCodes(){
		Connection conTDM			= null ;
		PreparedStatement pstTDM    = null ;
		ResultSet rsTDM		        = null ;
		String strQuery				= "";
		Hashtable  hmReason			= new Hashtable();

		try{
			strQuery = PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT_REASON");
			conTDM = getConnection() ;

			pstTDM			= conTDM.prepareStatement(strQuery) ;
			pstTDM.setString(1,getLanguageId());
			rsTDM			= pstTDM.executeQuery();
			while( rsTDM.next() ){
				hmReason.put( rsTDM.getString("REASON_CODE"), rsTDM.getString("REASON_DESC"));
			}
		}
		catch (Exception eTDMReason){
			eTDMReason.printStackTrace();
		}
		finally{
			try{
				closeResultSet(rsTDM);
				closeStatement(pstTDM);
				closeConnection(conTDM);
			}
			catch (Exception e){
				e.printStackTrace() ;
			}
		}
		return hmReason;
	}

	public String genOrderID(String patient_class) {
		if(!patient_class.trim().equals("IP") && patient_class.trim().equals("EM")) {
			patient_class = "OP";
		}

		String order_id				= "";
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT37");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,"PH");
			pstmt.setString(2,patient_class);
			pstmt.setString(3, login_facility_id); //thrid parameter for facility added for IN[032925]
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				order_id	=((String)resultSet.getString("order_id"));
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
		return order_id;
	}

	public String chkExistence(String patient_id,String order_id,String drug_code) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String existence="N";
	 	try{
			connection = getConnection() ;
			//sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT99");
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_TDM_PRESCRIPTION_SELECT_EXISTENCE");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,order_id);
			pstmt.setString(3,drug_code);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				existence="Y"+"|"+checkForNull((String)resultSet.getString("ORDER_ID"))+"|"+checkForNull((String)resultSet.getString("ORDER_LINE_NUM"));
			}
			else
				existence="N";
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
		return existence;
	}

	public ArrayList getOrderDetails(String order_id,String order_line_num) {
	    ArrayList record=new ArrayList();
		HashMap order_details       = null; 
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT_ORDER_DTLS1");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,getLanguageId());
			//pstmt.setString(2,order_line_num);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())	{
				order_details=new HashMap(); 
				order_details.put("SCH_DATE_TIME",checkForNull((String)resultSet.getString("SCH_DATE_TIME")));
				order_details.put("SCH_DOSE_DATE",checkForNull((String)resultSet.getString("SCH_DOSE_DATE")));
				order_details.put("SCH_DOSE_TIME",checkForNull((String)resultSet.getString("SCH_DOSE_TIME")));
				order_details.put("ORDER_CATALOG_CODE",checkForNull((String)resultSet.getString("ORDER_CATALOG_CODE")));
				order_details.put("SAMPLING_TYPE",checkForNull((String)resultSet.getString("SAMPLING_TYPE")));
				order_details.put("SAMPLING_DURN",checkForNull((String)resultSet.getString("SAMPLING_DURN")));
				order_details.put("SAMPLING_DURN_TYPE",checkForNull((String)resultSet.getString("SAMPLING_DURN_TYPE")));
				order_details.put("ORDER_CATALOG_DESC",checkForNull((String)resultSet.getString("ORDER_CATALOG_DESC")));
				order_details.put("SAMPLING_INDICATOR",checkForNull((String)resultSet.getString("SAMPLING_INDICATOR")));
				record.add(order_details);
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
		//System.err.println("record-----getOrderDetails()-second method--------->"+record);
		return record;
	}

	public HashMap getRemarksDetails(String order_id,String order_line_num) {
		HashMap remarks_details=new HashMap(); 
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT_ORDER_DTLS2");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			resultSet			= pstmt.executeQuery(); 
			if(resultSet!=null && resultSet.next())	{
				remarks_details.put("REASON_FOR_REQ_CODE",checkForNull((String)resultSet.getString("REASON_FOR_REQ_CODE")));
				remarks_details.put("REMARKS",checkForNull((String)resultSet.getString("REMARKS")));
				remarks_details.put("SMOKER_YN",checkForNull((String)resultSet.getString("SMOKER_YN")));
				remarks_details.put("ALCOHLIC_YN",checkForNull((String)resultSet.getString("ALCOHLIC_YN")));
				remarks_details.put("PREGNANT_YN",checkForNull((String)resultSet.getString("PREGNANT_YN")));
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
		return remarks_details;
	}

	public ArrayList getSchDosage(String order_id,String order_line_num,String date) {
	    ArrayList record=new ArrayList();
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT_ORDER_DTLS2B");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			pstmt.setString(3,date);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())	{
				record.add(checkForNull((String)resultSet.getString("SCH_DOSAGE_QTY")));
				record.add(checkForNull((String)resultSet.getString("SCH_DOSAGE_UOM_CODE")));
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
		return record;
	}

	public ArrayList getpoisionousdrug(String form_code,String generic_id){
	    Connection conTDM			= null ;
		PreparedStatement pstTDM    = null ;
		ResultSet rsTDM		        = null ;
		String strQuery				= "";
		ArrayList alDrugPro			= new ArrayList();
		String append				="";
		int i						=1;
		try{
			
			if(form_code!=null && !form_code.equals("")){
               append="  AND A.FORM_CODE=? ";
			}
			if(generic_id!=null && !generic_id.equals("")){
               append = append + "  AND A.GENERIC_ID=? ";
			}
            append = append +"  ORDER BY DRUG_DESC ";
			strQuery = PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT_POISINOUS_DRUG");

			conTDM = getConnection() ;

			pstTDM			= conTDM.prepareStatement(strQuery+" "+append) ;
			pstTDM.setString(i++,getLanguageId());
			if(form_code!=null && !form_code.equals("")){
               pstTDM.setString(i,form_code);
			   i++;
			}
			if(generic_id!=null && !generic_id.equals("")){
               pstTDM.setString(i,generic_id);			   
			}				

			rsTDM			= pstTDM.executeQuery();

			while( rsTDM.next() )			{
			    alDrugPro.add(rsTDM.getString("DRUG_CODE")); //0
				alDrugPro.add(rsTDM.getString("DRUG_DESC"));
				alDrugPro.add(rsTDM.getString("FORM_DESC"));
				alDrugPro.add(checkForNull(rsTDM.getString("ROUTE_DESC")));				
			    alDrugPro.add(checkForNull(rsTDM.getString("ROUTE_COLOR")));// 4 added for CRF RUT-CRF-0034.1[IN:037389]
			}
		}
		catch (Exception eDP){
			eDP.printStackTrace();
		}
		finally{
			try{
				closeResultSet(rsTDM);
				closeStatement(pstTDM);
				closeConnection(conTDM);
			}
			catch (Exception e){
                e.printStackTrace() ;
			}
		}
		return alDrugPro;
	}

	public String getsysdate() {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";	
		String sysdate              = "";
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT_SELECT1");
			pstmt				= connection.prepareStatement(sql_query) ;
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				sysdate=resultSet.getString("syadte");
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
		return sysdate;
	}

	public String updatedateandtime(String sch_date_time,String when_dosage,String samp_2,String samp_3) {

		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";	
		String start_date_time              = "";
		int samp_21=0;
		try{
			connection = getConnection() ;
			if(when_dosage.equals("B")){
			 samp_21=Integer.parseInt(samp_2)*(-1);
			}
			else{
			 samp_21=Integer.parseInt(samp_2);

			}
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_TDM_ENDDATE_PEAK_RANDOM");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,samp_3);
			pstmt.setString(2,sch_date_time);
			pstmt.setInt(3,samp_21);
			pstmt.setString(4,samp_3);
			pstmt.setString(5,sch_date_time);
			pstmt.setInt(6,samp_21);
			pstmt.setString(7,samp_3);
			pstmt.setString(8,sch_date_time);
			pstmt.setInt(9,samp_21);
			
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				start_date_time=resultSet.getString("START_DATE_TIME");
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
		return start_date_time;
	 }

	public String getTDMOrderId(String org_order_id) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";	
		ArrayList arr_orders=new ArrayList();
		//int samp_21=0;
		try{
			connection = getConnection() ;
			
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT_ORDER_DATE_TIME");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,org_order_id);
			
			
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())	{
				arr_orders.add(resultSet.getString("ORDER_ID"));
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
		//System.err.println("arr_orders-------->"+arr_orders);
		return (String)arr_orders.get(0);
	}

	public ArrayList  getGenericNames(){
		Connection connection       = null ;
	    PreparedStatement pstmt     = null ;
	    ResultSet resultSet         = null ;
	    ArrayList GenericNames	    = new ArrayList();
		try{
			connection 	= getConnection() ;
			String SQL_PH_TDM_SELECT_GENERIC="select  distinct a.GENERIC_ID ,b.GENERIC_NAME from ph_drug a ,ph_generic_name_lang_vw b where a.GENERIC_ID =b.GENERIC_ID and a.APPL_TO_TDM_YN ='Y' and b.language_id=?";
			//pstmt	   	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT_GENERIC")) ;
			pstmt	   	= connection.prepareStatement(SQL_PH_TDM_SELECT_GENERIC) ;
			pstmt.setString(1,getLanguageId());
			resultSet   = pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				String record[] = new String[2];
				record[0] = (resultSet.getString("GENERIC_ID")==null ? "":resultSet.getString("GENERIC_ID")) ;
				record[1] = (resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME"));
				GenericNames.add(record) ;
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
		return GenericNames;
	}

	 public ArrayList  getFormDesc(){
		Connection connection       = null ;
	    PreparedStatement pstmt     = null ;
	    ResultSet resultSet         = null ;
	    ArrayList FormCode	    = new ArrayList();
		try{
			connection 	= getConnection() ;
			pstmt	   	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT_FORM")) ;
			pstmt.setString(1,getLanguageId());
			resultSet   = pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				String record[] = new String[2];
				record[0] = (resultSet.getString("FORM_CODE")==null ?  "":resultSet.getString("FORM_CODE")) ;
				record[1] = (resultSet.getString("FORM_DESC")==null ? "":resultSet.getString("FORM_DESC"));
				FormCode.add(record) ;
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
		return FormCode;
	}
}
