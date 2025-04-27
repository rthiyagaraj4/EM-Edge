
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 
<%
	Properties p = (java.util.Properties) session.getValue("jdbc");
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;//Added by Kamatchi S
	ResultSet rs=null;//Added by Kamatchi S
	String loginUser = checkForNull((String)session.getValue("login_user"));

try{
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String action			=	(String) hash.get("action")==null?"":(String) hash.get("action");
	String facilityID				= (String)session.getAttribute("facility_id");//Added by Kamatchi S for MO-CRF-20162
	if(action.equals("")){
		action			=	request.getParameter("action")==null?"": request.getParameter("action");
	} 

	if(action.equals("validateForm60")){
		String facilityId			= (String) hash.get("facilityId");
		String episodeId			= (String) hash.get("episodeId");
		String episodeType			= (String) hash.get("episodeType");
		String opEpisodeVisitNum	= (String) hash.get("opEpisodeVisitNum");
		String encounterId			= (String) hash.get("encounterId");
		String ackNO				= (String) hash.get("ackNO");
		String isBillGenerated		= eMP.MPForm60Bean.getIsBillGenerated(conn,facilityId,episodeId,episodeType,opEpisodeVisitNum);	
		if(isBillGenerated.equals("")){
			isBillGenerated			= "N";
		}
		
		out.println(isBillGenerated);
	}
	//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	else if (action.equals("primaryNuhdeek")){
		
		String alt_id3_no			= request.getParameter("alt_id3_no")==null?"": request.getParameter("alt_id3_no");
		String patient_id			= request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
		System.err.println("alt_id3_no-->"+alt_id3_no);

		int primaryNuhdeekCnt		= eMP.MPCommonBean.getPrimaryNuhdeek(conn,alt_id3_no,patient_id);	
		System.err.println("primaryNuhdeekCnt-->"+primaryNuhdeekCnt);
		out.println(primaryNuhdeekCnt);
	} 
	else if (action.equals("validateRegion")){
		String GST_Region			= (String) hash.get("GST_Region");
		int GSTRegionCnt		= eMP.MPCommonBean.getGSTRegionCnt(conn,GST_Region);	
		out.println(GSTRegionCnt);
	} 
	else if(action.equals("activate_pat")){
		String patientId			= request.getParameter("patientId")==null?"": request.getParameter("patientId");
		if(!patientId.equals("")){
			String delSql	= "delete from MP_INACTIVE_PATIENT where INACTIVE_PAT_ID ='"+patientId+"'";
			PreparedStatement prep =  conn.prepareStatement(delSql);
			prep.executeUpdate();
			prep.close();
			conn.commit();
		}
		out.println("success");
	}	else if (action.equals("chkInActiveNatId")){
		String national_id_no			= request.getParameter("national_id_no")==null?"": request.getParameter("national_id_no");
		int inActiveNatIdCount	= eMP.MPCommonBean.getInactiveNatIdCnt(conn,national_id_no); 
		out.println(inActiveNatIdCount);
	} 
	/*Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1*/
	else if (action.equals("validateEmpPrivilege")){
		String National_ID		= (String) hash.get("National_ID");
		String Language_ID		= (String) hash.get("Language_ID");
		String retVal			= "";
		JSONObject empJSONObj	= new JSONObject();

		empJSONObj = eMP.MPCommonBean.getEmpPrivilegeData(conn, National_ID, Language_ID);

		String national_id_no = (String)empJSONObj.get("national_id_no");
		String employee_or_family = (String)empJSONObj.get("employee_or_family");
		String name_prefix = (String)empJSONObj.get("name_prefix");
		String first_name = (String)empJSONObj.get("first_name");
		String second_name = (String)empJSONObj.get("second_name");
		String last_name = (String)empJSONObj.get("last_name");
		String ref_employee_id = (String)empJSONObj.get("ref_employee_id");
		String relationship_to_employee = (String)empJSONObj.get("relationship_to_employee");
		String relationship_to_emp_desc = (String)empJSONObj.get("relationship_to_emp_desc");
		String prefix_eff_status = (String)empJSONObj.get("prefix_eff_status");
		String alt_id_eff_status = (String)empJSONObj.get("alt_id_eff_status");
		
		retVal = national_id_no + "#" + employee_or_family + "#" + name_prefix  + "#" + first_name  + "#" + second_name  + "#" + last_name  + "#" + ref_employee_id  + "#" + relationship_to_employee + "#" + relationship_to_emp_desc + "#" + prefix_eff_status + "#" + alt_id_eff_status;

		out.println(retVal);
	}
	/*End TBMC-CRF-0010.1*/

	/*Added by Ashwini on 16-Dec-2019 for AAKH-CRF-0079.11*/
	else if (action.equals("PatDemographicDtls")){
		String patient_id		= (String) hash.get("patient_id");
		String retVal			= "";
		JSONObject empJSONObj	= new JSONObject();

		empJSONObj = eMP.MPCommonBean.getPatDemographicDtls(conn, patient_id);

		String patient_name = (String)empJSONObj.get("patient_name");
		String contact_no = (String)empJSONObj.get("contact_no");
		String date_of_birth = (String)empJSONObj.get("date_of_birth");
		String gender = (String)empJSONObj.get("gender");
		
		retVal = patient_name + "#" + contact_no + "#" + date_of_birth + "#" + gender;

		out.println(retVal);
	}
	/*End AAKH-CRF-0079.11*/
	
	/*Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551 & ML-MMOH-CRF-1551.1*/
	else if (action.equals("NBNameDervLogic")){
		String retVal = "";
		HashMap nameDervDtl =  new HashMap();

		nameDervDtl = eMP.NewbornDetails.getMPParamDtls(conn,p);

		String name_dervn_logic_nb = checkForNull((String)nameDervDtl.get("name_dervn_logic_nb"));
		String name_dervn_logic_nb_sb = checkForNull((String)nameDervDtl.get("name_dervn_logic_nb_sb"));
		
		retVal = name_dervn_logic_nb + "#" + name_dervn_logic_nb_sb;

		out.println(retVal);
	}
	/*End ML-MMOH-CRF-1551 & ML-MMOH-CRF-1551.1*/

	
	// Added for MO-CRF-20162 by KAMATCHI S
	else if (action.equals("checkStatus")){
		
		String patient_id			= request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
		webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
		patdata.setFacility_id(facilityID);
		String pat_status = patdata.CheckStatus(conn,patient_id);
		out.println(pat_status);
	} 

	/*Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187*/
	else if (action.equals("getSpecDescforLoc")){
		String location_code	= (String) hash.get("location_code");
		String location_type	= (String) hash.get("location_type");
		String facility_id		= (String) hash.get("facility_id");
		String language_id		= (String) hash.get("language_id");
		String retVal			= "";
		
		JSONObject empJSONObj = new JSONObject();
		empJSONObj = eMP.MPCommonBean.getSpecDescforLoc(conn, location_code, location_type, facility_id, language_id);

		String specialty_desc = checkForNull((String)empJSONObj.get("specialty_desc"));
		String specialty_code = checkForNull((String)empJSONObj.get("specialty_code"));

		retVal = specialty_desc + "#" + specialty_code;

		out.println(retVal);
	}

	else if (action.equals("getSpecDescforLocNurUnit")){

		String location_code	= (String) hash.get("location_code");
		String facility_id		= (String) hash.get("facility_id");
		String language_id		= (String) hash.get("language_id");
		String retVal			= "";
		
		JSONObject empJSONObj = new JSONObject();
		empJSONObj = eMP.MPCommonBean.getSpecDescforLocNurUnit(conn, location_code, facility_id, language_id);

		int noOfRecords	= (Integer)empJSONObj.get("noOfRecords");
		String specialty_desc = checkForNull((String)empJSONObj.get("specialty_desc"));
		String specialty_code = checkForNull((String)empJSONObj.get("specialty_code"));

		retVal = noOfRecords + "#" + specialty_desc + "#" + specialty_code;

		out.println(retVal);
	}
	/*End MMS-DM-CRF-0187*/
	else if (action.equals("Country")){
		 String countryCode = "";
		 String telephone_code = "";
		 countryCode			= request.getParameter("countryCode")==null?"": request.getParameter("countryCode");
		 
		 pstmt = conn.prepareStatement("select TELEPHONE_CODE from mp_country where country_code = '"+countryCode+"' and eff_status = 'E'");
		 rs  = pstmt.executeQuery();
	
		while (rs != null && rs.next()) {	
		 telephone_code = rs.getString("TELEPHONE_CODE")==null?"": rs.getString("TELEPHONE_CODE");
		 out.println(telephone_code);
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();	
	}
	/* added by Lakshmanan MO-CRF-20183.2 US002 start*/
		else if (action.equals("EmpServNo")){
		String empServNumCode	= request.getParameter("empServNumCode")==null?"": request.getParameter("empServNumCode");
		String empservno	= request.getParameter("empservno")==null?"": request.getParameter("empservno");
		String pract_id	= request.getParameter("pract_id")==null?"": request.getParameter("pract_id");
		String fieldName	= request.getParameter("fieldName")==null?"": request.getParameter("fieldName");
		String head_id	= request.getParameter("fieldName")==null?"": request.getParameter("headId");
		JSONObject empJSONObj = new JSONObject();
		empJSONObj = eMP.MPCommonBean.checkEmpServiceNo(conn, empservno, empServNumCode,pract_id,fieldName,head_id);
		out.println((String)empJSONObj.get("employee_service_no"));
	}
	/* added by Lakshmanan MO-CRF-20183.2 US002 end*/
	/*Added by Ajay Hatwate for AAKH-CRF-0179*/
	else if(action.equals("CheckAccNumbSigned")){
		
	//	PreparedStatement pstmt = null;
	//	ResultSet rs = null;
		String death_reg_form_accession_num = (String) hash.get("death_reg_form_accession_num");
		String isSigned = "N";
		String notesrecqry="SELECT 'Y' FROM CA_ENCNTR_NOTE WHERE ACCESSION_NUM=? AND EVENT_STATUS='4'";
		pstmt=conn.prepareStatement(notesrecqry);
		pstmt.setString(1,death_reg_form_accession_num);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next())	
		{
			isSigned=rs.getString(1);  //notesRecorded
		} 
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		out.println(isSigned);
	}
	else if(action.equals("isAccNumMarkedInError")){
		String death_reg_form_accession_num = (String) hash.get("death_reg_form_accession_num");
		String isMarkedInError = "N";
		String notesrecqry="SELECT 'Y' FROM CA_ENCNTR_NOTE WHERE ACCESSION_NUM=? AND EVENT_STATUS='9'";
		pstmt=conn.prepareStatement(notesrecqry);
		pstmt.setString(1,death_reg_form_accession_num);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next())	
		{
			isMarkedInError=rs.getString(1);  //note marked in error.
		} 
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		out.println(isMarkedInError);
	}
	
	else if(action.equals("chkDuplicateABHAId")){
		
	//	PreparedStatement pstmt = null;
	//	ResultSet rs = null;
		String abha_id			= request.getParameter("abha_id")==null?"": request.getParameter("abha_id");
		String patient_id			= request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
		
		Integer abha_cnt= 0;
		StringBuffer abhaIdQry			= new StringBuffer();
		abhaIdQry.append("SELECT count(*) cnt FROM MP_PATIENT WHERE MYHIX_ID=? ");

		if(!patient_id.equals(""))
		{
		abhaIdQry.append(" and patient_id!=? ");
		}
		pstmt=conn.prepareStatement(abhaIdQry.toString());
		pstmt.setString(1,abha_id);
		if(!patient_id.equals(""))
		{
		pstmt.setString(2,patient_id);
		}
		rs=pstmt.executeQuery();
		
		if(rs!=null && rs.next())	
		{
			abha_cnt=rs.getInt("cnt");   
		} 
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		out.println(abha_cnt);
	}else if(action.equals("isPractRestricted")){ //Added by Ajay Hatwate for MMS-DM-CRF-0210.1
		String patient_id = (String) hash.get("patient_id");
		String logged_user = (String) hash.get("logged_user");
		if(logged_user.equals("") || logged_user == null) logged_user = loginUser;
		String isPractRestricted = "";
		String isPatientRestricted = "";

		pstmt = conn.prepareStatement("SELECT (SELECT a.access_res_pat_yn FROM ca_access_view_restr_patient a WHERE a.practitioner_id = (SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = ?) AND a.facility_id = ? AND (   (    a.access_from_date IS NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) )) access_res_pat_yn, (SELECT restrict_reinstate_yn FROM mp_patient WHERE patient_id = ?) restrict_reinstate_yn FROM DUAL");
		pstmt.setString(1, logged_user);
		pstmt.setString(2, facilityID);
		pstmt.setString(3, patient_id);
		rs = pstmt.executeQuery() ;
		if( rs != null ) {
			if( rs.next() ) {
				isPractRestricted = checkForNull(rs.getString(1), "N");
				isPatientRestricted = checkForNull(rs.getString(2), "N");
			}
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(isPractRestricted.equals("Y") && isPatientRestricted.equals("Y")){
			out.println("N");
		}else if(isPractRestricted.equals("Y") && isPatientRestricted.equals("N")){
			out.println("N");
		}else if(isPractRestricted.equals("N") && isPatientRestricted.equals("Y")){
			out.println("Y");
		}else{
			out.println("N");
		}
	}	
	
}catch(Exception e) { 
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
            
            
