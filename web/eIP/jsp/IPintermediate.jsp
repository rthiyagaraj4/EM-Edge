<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection conn=null;
	conn=ConnectionManager.getConnection(request); 
	PreparedStatement pstmt=null;
	ResultSet rs=null;

try{
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String action			=	(String) hash.get("action")==null?"":(String) hash.get("action");
	String facilityID				= (String)session.getAttribute("facility_id");
	/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
	String  Practsql = (String) hash.get("sql")==null?"":(String) hash.get("sql");
	Practsql = java.net.URLDecoder.decode(Practsql,"UTF-8");
	/*Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362*/
	String  method_name = (String) hash.get("method_name")==null?"":(String) hash.get("method_name");
	/*Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362*/
	/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
	String open_to_all_prac_for_clinic_yn="";
	String open_to_all_pract_yn="";
	/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
	/*Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362*/
	String encounter_id=(String) hash.get("encounter_id")==null?"":(String) hash.get("encounter_id");
	/*Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362*/
	
	/*Added by Thamizh selvi on 13th Apr 2017 for GDOH-CRF-0124 Start*/	
	webbeans.op.PatientData patdata = new webbeans.op.PatientData();
	patdata.setFacility_id(facilityID);
	/*End*/

	if(action.equals("validate_admision_discharge_date_time")){
		String patientId			= (String) hash.get("patientId");
		String dateTime				= (String) hash.get("dateTime");
		String flag					= (String) hash.get("flag");
		String req_encounterid		= "";
	
		if(flag.equals("D")){
			req_encounterid			= (String) hash.get("encounter_id");
		}
		
		String encounterId			= "";

	
	
		String sql1="select IP_VALIDATE_INPATIENT(?,?,?,?,?) encounterId from dual";
		pstmt = conn.prepareStatement(sql1);
		pstmt.setString(1,patientId);
		pstmt.setString(2,facilityID);
		pstmt.setString(3,dateTime);
		pstmt.setString(4,flag);
		pstmt.setString(5,req_encounterid);
		rs = pstmt.executeQuery();
		if(rs!=null && rs.next()){
			encounterId		= (rs.getString("encounterId")==null || rs.getString("encounterId")=="")?"" : rs.getString("encounterId");
		}
		if(pstmt != null) pstmt.close();
		if(rs  != null) rs.close();
			System.err.println("encounterId==>"+encounterId);
		out.print(encounterId);

	}else if(action.equals("isDownTimePatient")){
		String patientId			= (String) hash.get("patientId");
		boolean downtimePatient = CommonBean.isDownTimePatient(conn,patientId);

		out.print(downtimePatient);
	}else if(action.equals("chkForm60OrPanCardAvail")){/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] Start*/
		String patientId			= (String) hash.get("patientId");
		String returnValue			= "N";
		HashMap ResultParamHashMap	= new HashMap();
		HashMap sqlColumns = new HashMap();
		sqlColumns.put("FORM_60_YN","S");
		sqlColumns.put("ALT_ID3_NO","S");
		sqlColumns.put("CITIZEN_YN","S");
		String whereClause	= "where PATIENT_ID='"+patientId+"'";
		System.err.println("whereClause==>"+whereClause);
		ResultParamHashMap  = CommonBean.getParamDetails(sqlColumns,whereClause,"MP_PATIENT",conn);
		String citizenYN	= (String) ResultParamHashMap.get("CITIZEN_YN");
		String form60YN		= (String) ResultParamHashMap.get("FORM_60_YN");
		String panCard		= (String) ResultParamHashMap.get("ALT_ID3_NO");

		panCard		 = (panCard==null || panCard.equals("")?"":panCard);
		form60YN	 = (form60YN==null || form60YN.equals("")?"N":form60YN);
		citizenYN	 = (citizenYN==null || citizenYN.equals("")?"N":citizenYN);
			


		//if(panCard.equals("") && form60YN.equals("N") && citizenYN.equals("Y")){
		if(panCard.equals("") && form60YN.equals("N")){//Modified by Dharma on Aug 1st 2016 against KDAH-SCF-0358 [IN:060809]
			returnValue		= "Y";
		}
		sqlColumns.clear();
		ResultParamHashMap.clear();
		System.err.println("returnValue==>"+returnValue);
		out.print(returnValue);
	}
/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] End*/	
	else if(action.equals("getRegDateTime")){
		String patientId			= (String) hash.get("patientId");
		String reg_date_time		= CommonBean.getRegistrationDateTime(conn,patientId);
		System.err.println("reg_date_time==>"+reg_date_time);
		out.print(reg_date_time);
	}

	/*Added by Thamizh selvi on 13th Apr 2017 for GDOH-CRF-0124 Start*/	
	else if(action.equals("validatePatId")){
		String patientId			= (String) hash.get("patientId");
		String chkst=patdata.CheckStatus(conn,patientId);
		if(chkst.equals("INVALID_PATIENT"))
			out.println(chkst);
		else
			out.println();
	}
	/*End*/

	/*Added by Thamizh selvi on 4th May 2017 for GDOH-CRF-0124 Start*/
	else if(action.equals("validateFrCanclTrf")){
		String enc			= (String) hash.get("enc");
		String facilityId	= (String) hash.get("facilityId");
		String frmNursCode	= (String) hash.get("frmNursCode");
		String frmRoomNo	= (String) hash.get("frmRoomNo");
		String frmBedNo		= (String) hash.get("frmBedNo");
		String validate		= eIP.IPCancelTransferBean.validateForCancelTrf(conn,enc,facilityId,frmNursCode,frmRoomNo,frmBedNo);
		out.println(validate);
	}
	/*End*/
	
	/*Added by Ashwini on 23-05-2018 for ML-MMOH-CRF-1074*/
	else if(action.equals("validateBedNo")){
		String dischrg_bed_no		= (String) hash.get("dischrg_bed_no");
		String nursing_unit_code	= (String) hash.get("nursing_unit_code");
		String facility_id			= (String) hash.get("facility_id");
		String eff_status			= eIP.IPCommonBean.getIPBedsEffStatus(conn,dischrg_bed_no,nursing_unit_code,facility_id);
		out.println(eff_status);
	}
	/*End ML-MMOH-CRF-1074*/

	/*Added by Ashwini on 15-Nov-2022 for ML-MMOH-CRF-1613*/
	else if(action.equals("insertSyProgParam")){
		
		CallableStatement call_stmt = null;
		String report = "";
		String server = "";
		String app_server_ip = "";

		String facility_id	= (String) hash.get("facility_id");
		String episode_id	= (String) hash.get("episode_id");
		String session_id	= (String) hash.get("session_id");
		int sessionId		= Integer.parseInt(session_id);
		String pgm_date		= (String) hash.get("pgm_date");

		String report_ssl_yn = (String) session.getValue( "report_ssl_yn" ) ;
		String reportServer	= (String) session.getValue( "report_server" ) ;
		String userid = (String) session.getValue( "report_connect_string" ) ;
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String ws_no = (String) p.getProperty( "client_ip_address" )  ;

		String inserted_yn = eIP.IPCommonBean.insertSyProgParam(conn,facility_id,episode_id,sessionId,pgm_date);

		if(inserted_yn.equals("Y")){
			try{
				call_stmt = conn.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" ) ;
				call_stmt.setString( 1,	"BL" ) ;
				call_stmt.setString( 2,	"BLR0018B" ) ;
				call_stmt.setString( 3,	"" ) ;
				call_stmt.setString( 4,	"" ) ;
				call_stmt.setString( 5,	facility_id ) ;
				call_stmt.setString( 6,	ws_no ) ;
				call_stmt.setString( 7,	"V" ) ;
				call_stmt.registerOutParameter( 8,  Types.VARCHAR ) ;
				call_stmt.registerOutParameter( 9,  Types.VARCHAR ) ;
				call_stmt.registerOutParameter( 10, Types.VARCHAR ) ;
				call_stmt.registerOutParameter( 11, Types.VARCHAR ) ;
				call_stmt.registerOutParameter( 12, Types.VARCHAR ) ;
				call_stmt.registerOutParameter( 13, Types.VARCHAR ) ;
				call_stmt.registerOutParameter( 14, Types.VARCHAR ) ;
				call_stmt.registerOutParameter( 15, Types.VARCHAR ) ;
				call_stmt.registerOutParameter( 16, Types.VARCHAR ) ;
				call_stmt.registerOutParameter( 17, Types.VARCHAR ) ;
				call_stmt.execute() ;
				
				report	= call_stmt.getString( 8 ) ;
				server	= call_stmt.getString( 9 ) ;
				app_server_ip = call_stmt.getString( 16 ) ;

				if (report_ssl_yn==null) report_ssl_yn="";

				if(report_ssl_yn.equals("Y")){
					reportServer = "https://" + app_server_ip + reportServer +  "?server=" + server +  "+report=" + report +  "+userid=" + userid;
				}else{
					reportServer = "http://" + app_server_ip + reportServer +  "?server=" + server +  "+report=" + report +  "+userid=" + userid;
				}

				if(call_stmt != null) call_stmt.close();

			}catch(Exception e) {
				//out.println(e.toString());
				e.printStackTrace();
			}
		}
		
		out.println(reportServer);
	}
	/*End ML-MMOH-CRF-1613*/

	/* START Added by Sangeetha for KDAH-CRF-0347 on 13/apr/17 */
	else if(action.equals("PanCardAvailCheck")){
		String patientId			= (String) hash.get("patientId");
		String returnValue			= "Y";
		HashMap ResultParamHashMap	= new HashMap();
		HashMap sqlColumns = new HashMap();
		
		sqlColumns.put("ALT_ID3_NO","S");
		
		String whereClause	= "where PATIENT_ID='"+patientId+"'";
		ResultParamHashMap  = CommonBean.getParamDetails(sqlColumns,whereClause,"MP_PATIENT",conn);
		
		String panCard		= (String) ResultParamHashMap.get("ALT_ID3_NO");
		panCard		 = (panCard==null || panCard.equals("")?"":panCard);
		
		if(panCard.equals("")){
			returnValue		= "N";
		}
		sqlColumns.clear();
		ResultParamHashMap.clear();
		out.print(returnValue);
	}

	else if(action.equals("validatePatIdStatus")){
		String patientId			= (String) hash.get("patientId");
		String chkst=patdata.CheckStatus(conn,patientId);
		if(!chkst.equals(""))
			out.println(chkst);
		else
			out.println();
	}
	/* END KDAH-CRF-0347 */

	//SRART Added by Sangeetha on  23/05/17 for GDOH-CRF-0151
	else if(action.equals("chkforVacantNormalBed")){
		String nursing_unit_code	= (String) hash.get("nursing_unit_code");
		String bed_no				= (String) hash.get("bed_no");
		String facility_id			= (String) hash.get("facility_id");
		String Bedcode			= (String) hash.get("Bedcode");
		String bed_type			= (String) hash.get("bed_type");
		
		
		String vacant_yn		    = eIP.IPCommonBean.isVacantBedAvailable(conn,facility_id,bed_no,nursing_unit_code,Bedcode,bed_type);

		out.print(vacant_yn);
	}
	//END Added by Sangeetha on  23/05/17 for GDOH-CRF-0151

	/*Added by Ashwini on 18-Apr-2018 for GHL-CRF-0505*/
	else if (action.equals("validateAadharCardNo"))
	{
		String aadhar_card_no	= (String) hash.get("aadhar_card_no");
		int AadharCardNoCnt		= eIP.IPCommonBean.getAltIdNo4Cnt(conn,aadhar_card_no);	
		out.println(AadharCardNoCnt);
	} 
	/*End GHL-CRF-0505*/

	/*Added by Mujafar on 22-Aug-17 for ML-MMOH-CRF-0704 START*/
	else if(action.equals("calCollectDate"))
	{
		 
		
		String appl_col_date = (String) hash.get("appl_col_date");
		
		String appl_type_val = (String) hash.get("appl_type_val");
		String appl_col_flag = (String) hash.get("appl_col_flag");
		
		
		
		String retVal="",retVal_err = "";
		 CallableStatement cstmt = null;
		 
		 try
		 {
		 cstmt = conn.prepareCall("{ call mr_holiday_return_date(?,?,?,?,?) }");
			cstmt.setString(1,appl_col_date);
			cstmt.setString(2,appl_type_val);
			cstmt.setString(3,appl_col_flag);
			cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			cstmt.execute();
		retVal = cstmt.getString(4);
		retVal_err = cstmt.getString(5);
		
		
		
		if (retVal==null) retVal = "";	
		if (retVal_err==null) retVal_err = "";	
		if(!retVal_err.equals(""))
		{
			out.println(retVal_err);
		}
		else
		{
			out.println(retVal);
		}
		 if(cstmt != null) cstmt.close();
		 }
		catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally {
		
		 ConnectionManager.returnConnection(conn,request);
	}
	
		
	}
	else if(action.equals("getSystemDateTime"))
	{ // added by mujafar for MMS-MD-SCF-0096
		String adm_date_chk_days = (String) hash.get("adm_date_chk_days");
		String adm_date_chk_days_type = (String) hash.get("adm_date_chk_days_type");
		String sysDateTime = eIP.IPCommonBean.getSystemDateTime(conn,adm_date_chk_days_type,adm_date_chk_days);
		out.println(sysDateTime);	
	}

	else if(action.equals("setSqlStringValue"))
	{ 	
		String setSqlStringValue = (String) hash.get("sqlstring_querykey"); 
		
		session.setAttribute("SQLSTRING_QUERYKEY",setSqlStringValue);
	}

	else if (action.equals("isHoliday"))
	{ 
		
		String appl_col_date = (String) hash.get("appl_col_date");
		
		String appl_type_val = (String) hash.get("appl_type_val");
		String appl_col_flag = (String) hash.get("appl_col_flag");
		
		
		
		String retVal="",retVal_err = "";
		 CallableStatement cstmt = null;
		 
		 try
		 {
		 cstmt = conn.prepareCall("{ call mr_holiday_return_date(?,?,?,?,?) }");
			cstmt.setString(1,appl_col_date);
			cstmt.setString(2,appl_type_val);
			cstmt.setString(3,appl_col_flag);
			cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			cstmt.execute();
		retVal = cstmt.getString(4);
		retVal_err = cstmt.getString(5);
		
		
		
		if (retVal==null) retVal = "";	
		if (retVal_err==null) retVal_err = "";	
		if(!retVal_err.equals(""))
		{
			out.println(retVal_err);
		}
		else
		{
			out.println(retVal);
		}
		 if(cstmt != null) cstmt.close();
		 }
		catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally {
		
		 ConnectionManager.returnConnection(conn,request);
	}
		
	}/*Added by Mujafar on 22-Aug-17 for ML-MMOH-CRF-0704 END*/
	/* Added by Ajay Hatwate for MO-CRF-20190.1 */
	else if(action.equals("checkActiveMedication"))
	{
		String patient_id = (String) hash.get("patient_id"); 
		String patient_class = (String) hash.get("patient_class"); 
		//System.err.println("Print Debug ipIntermediate " + patient_id);
		pstmt = conn.prepareStatement("SELECT count(distinct a.orig_order_id)			    FROM ph_patient_drug_profile a,		         ph_drug_lang_vw c,		         am_frequency_lang_vw h,		         or_order_line o,		         or_order q,		         or_order_status_code_lang_vw r,		         or_order_line_ph s,		         ph_route k,		         pr_encounter p		   WHERE q.order_id = o.order_id		     AND a.patient_id = ?		     AND p.patient_class = ?		     AND (q.discharge_ind IS NULL OR q.discharge_ind = 'N')		     AND a.drug_code = c.drug_code		     AND h.freq_code = a.freq_code		     AND a.orig_order_id = o.order_id		     AND a.orig_order_line_no = o.order_line_num		     AND o.order_line_status = r.order_status_code		     AND k.route_code = a.route_code		     AND o.order_id = s.order_id		     AND o.order_line_num = s.order_line_num		     AND c.drug_yn = 'Y'		     AND p.encounter_id(+) = a.encounter_id		     AND p.facility_id(+) = a.orig_facility_id		     AND SYSDATE BETWEEN a.start_date AND a.end_date		     AND a.cancel_yn = 'N'		     AND a.stop_yn = 'N'		     AND a.on_hold_date_time IS NULL		     AND a.discont_date_time IS NULL		     AND o.order_line_status NOT IN		                                   ('PO', 'PQ', 'PS', 'CN', 'HD', 'HC', 'DC')");
		pstmt.setString(1, patient_id);
		pstmt.setString(2, patient_class);
		rs  = pstmt.executeQuery();
		while (rs != null && rs.next()) {
		//System.out.println(rs.getInt(1) + "rs.getInt(1) ");	
		 out.println(rs.getInt(1));
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	/*  End of MO-CRf-20190.1  */
	
	/*Added by Ashwini on 06-May-2024 for ML-MMOH-CRF-2125*/
	else if(action.equals("disp_service_for_speciality_yn")){

		String en_disp_lnkd_serv_to_spec_yn = "";
		
		String sql = "SELECT en_disp_lnkd_serv_to_spec_yn FROM ip_param WHERE facility_id = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,facilityID);

		rs = pstmt.executeQuery();

		if(rs!=null && rs.next()){
			en_disp_lnkd_serv_to_spec_yn = (rs.getString("en_disp_lnkd_serv_to_spec_yn")==null || rs.getString("en_disp_lnkd_serv_to_spec_yn")=="")?"N" : rs.getString("en_disp_lnkd_serv_to_spec_yn");
		}

		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

		out.print(en_disp_lnkd_serv_to_spec_yn);
	}
	
	/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
	else if(action.equals("getDiagClassCDUDCount")){
		
		String patient_id = (String) hash.get("patient_id"); 
		String enc_id = (String) hash.get("encounter_id");
		String facility_id = (String) hash.get("facility_id");

		String DiagClassCDUDCount = "";
		String both_pri_sec_count = "";
		String pri_count = "";
		String sec_count = "";
		
		String sql = " SELECT CASE WHEN COUNT(DISTINCT diag_class_code) = 2 THEN COUNT(*) ELSE NULL END AS both_pri_sec_count, CASE WHEN SUM(CASE WHEN diag_class_code = (SELECT primary_diag_class FROM mr_parameter) THEN 1 ELSE 0 END) > 0 THEN SUM(CASE WHEN diag_class_code = (SELECT primary_diag_class FROM mr_parameter) THEN 1 ELSE 0 END) ELSE NULL END AS pri_count, CASE WHEN SUM(CASE WHEN diag_class_code = (SELECT secondary_diag_class FROM mr_parameter) THEN 1 ELSE 0 END) > 0 THEN SUM(CASE WHEN diag_class_code = (SELECT secondary_diag_class FROM mr_parameter) THEN 1 ELSE 0 END) ELSE NULL END AS sec_count FROM pr_diagnosis_enc_dtl WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND status != 'E' AND diag_class_code IN ( (SELECT primary_diag_class FROM mr_parameter), (SELECT secondary_diag_class FROM mr_parameter) ) ";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,enc_id);
		pstmt.setString(3,facility_id);

		rs = pstmt.executeQuery();

		if(rs!=null && rs.next()){

			both_pri_sec_count = (rs.getString("both_pri_sec_count")==null || rs.getString("both_pri_sec_count")=="")?"" : rs.getString("both_pri_sec_count");

			pri_count = (rs.getString("pri_count")==null || rs.getString("pri_count")=="")?"" : rs.getString("pri_count");

			sec_count = (rs.getString("sec_count")==null || rs.getString("sec_count")=="")?"" : rs.getString("sec_count");
		}

		DiagClassCDUDCount = both_pri_sec_count + "~" + pri_count + "~" + sec_count;

		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

		out.print(DiagClassCDUDCount);
	}

	else if(action.equals("getLinkedYn")){
		
		String patient_id = (String) hash.get("patient_id"); 
		String enc_id = (String) hash.get("encounter_id");
		String facility_id = (String) hash.get("facility_id");

		String linked_yn = "";
		
		String sql = " SELECT CASE WHEN MAX (CASE WHEN link_diag_pri_sec_yn = 'Y' THEN 1 ELSE 0 END) = 1 THEN 'Y' ELSE '' END AS linked_yn FROM pr_diagnosis_enc_dtl WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND status != 'E' ";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,enc_id);
		pstmt.setString(3,facility_id);

		rs = pstmt.executeQuery();

		if(rs!=null && rs.next()){

			linked_yn = (rs.getString("linked_yn")==null || rs.getString("linked_yn")=="")?"" : rs.getString("linked_yn");
		}

		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

		out.print(linked_yn);
	}
	/*End ML-MMOH-CRF-1742*/

/*Added by Rameswar on 07-Jan-16 for GDOH-CRF-081*/

		  if (method_name.equals("searchPrac")){
		  pstmt = conn.prepareStatement(Practsql);
		rs  = pstmt.executeQuery();
	
		while (rs != null && rs.next()) {		
		open_to_all_prac_for_clinic_yn= rs.getString("open_to_all_prac_for_clinic_yn");
		open_to_all_pract_yn =rs.getString("open_to_all_pract_yn");			
	}
	
	out.println(open_to_all_prac_for_clinic_yn+"$"+open_to_all_pract_yn);
	
		if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	}
	if (method_name.equals("Queue_Status")){
		  pstmt = conn.prepareStatement("select queue_status from op_patient_queue where  encounter_id='"+encounter_id+"'");
		  rs  = pstmt.executeQuery();
	
		while (rs != null && rs.next()) {		
		 out.println(rs.getString("queue_status"));
		}
	}
/*Added by Rameswar on 07-Jan-16 for GDOH-CRF-081*/
	
/*Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362*/
if (method_name.equals("record_referral_note")){
		  pstmt = conn.prepareStatement("Select patient_class from pr_encounter where encounter_id='"+encounter_id+"'");
		  rs  = pstmt.executeQuery();
	
		while (rs != null && rs.next()) {		
		 out.println(rs.getString("patient_class"));
		}
	
	
	
		if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	}
/*Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362*/

if(rs != null) rs.close();
if(pstmt != null) pstmt.close();
}catch(Exception e) { 
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%>          
            
            
