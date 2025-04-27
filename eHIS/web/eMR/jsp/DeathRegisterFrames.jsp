<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap,eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
	<head>
		<title> <fmt:message key="eMR.MaintainDeathRegister.label" bundle="${mr_labels}"/></title>
		<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String facility_id					= checkForNull((String) session.getValue( "facility_id" ));
String patient_id				=	checkForNull(request.getParameter("patient_id"));
String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
String locn_code				=	checkForNull(request.getParameter("Locn_Code"));
String gender	 					=	checkForNull(request.getParameter("Sex"));
String dob							=	checkForNull(	request.getParameter("Dob"));
String speciality_code		=	checkForNull(request.getParameter("speciality_code"));
String episode_id				=	checkForNull(request.getParameter("episode_id"));
String practitioner_id			=	checkForNull(request.getParameter("practitioner_id"));
String practitioner_type	=	checkForNull(request.getParameter("practitioner_type"));
String patient_class			=	checkForNull(request.getParameter("patient_class"));
String call_from					=	checkForNull(request.getParameter("call_from"));
String episode_type			=	checkForNull(request.getParameter("episode_type"));
//String mode						=	checkForNull(request.getParameter("mode"));
String finalize_yn				=	checkForNull(request.getParameter("finalize_yn"));
String visit_adm_date		=	checkForNull(request.getParameter("visit_adm_date"));

Boolean isDeceasedDiagClassDeathRegAppl = false;
String auto_fin_death_reg_appl_yn = "N";
String primary_diag_class = "";
String secondary_diag_class = "";
String both_pri_sec_count = "";
String pri_count = "";
String sec_count = "";
String linked_yn = "";
String auto_fin_death_reg_yn = "N";

String frame_rows			=	"7%,19%,37%,34%,3%,3%";

session.removeAttribute("combined_map");
session.removeAttribute("diag_dates_map");

	
	if(call_from.equals("VIEW_DEATH_REG")){
		frame_rows="7%,20%,37%,34%,0%,4%";
	}

try{
	conn = ConnectionManager.getConnection(request);

	isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DECEASED_DIAG_CLASS_DEATH_REG");
	
	/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
	if(isDeceasedDiagClassDeathRegAppl){

		String MRSql = "select auto_fin_death_reg_appl_yn, primary_diag_class, secondary_diag_class from mr_parameter";

		pstmt = conn.prepareStatement(MRSql);
		rs = pstmt.executeQuery();

		if(rs!=null && rs.next()){
			auto_fin_death_reg_appl_yn = checkForNull(rs.getString("auto_fin_death_reg_appl_yn"),"N");
			primary_diag_class = checkForNull(rs.getString("primary_diag_class"));
			secondary_diag_class = checkForNull(rs.getString("secondary_diag_class"));
		}

		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();

		if(auto_fin_death_reg_appl_yn.equals("Y") && (!primary_diag_class.equals("") || !secondary_diag_class.equals(""))){
			
			String cntSql = "SELECT CASE WHEN COUNT(DISTINCT diag_class_code) = 2 THEN COUNT(*) ELSE NULL END AS both_pri_sec_count, CASE WHEN SUM(CASE WHEN diag_class_code = (SELECT primary_diag_class FROM mr_parameter) THEN 1 ELSE 0 END) > 0 THEN SUM(CASE WHEN diag_class_code = (SELECT primary_diag_class FROM mr_parameter) THEN 1 ELSE 0 END) ELSE NULL END AS pri_count, CASE WHEN SUM(CASE WHEN diag_class_code = (SELECT secondary_diag_class FROM mr_parameter) THEN 1 ELSE 0 END) > 0 THEN SUM(CASE WHEN diag_class_code = (SELECT secondary_diag_class FROM mr_parameter) THEN 1 ELSE 0 END) ELSE NULL END AS sec_count FROM pr_diagnosis_enc_dtl WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND status != 'E' AND diag_class_code IN ( (SELECT primary_diag_class FROM mr_parameter), (SELECT secondary_diag_class FROM mr_parameter) )";

			pstmt = conn.prepareStatement(cntSql);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,facility_id);

			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

				both_pri_sec_count = (rs.getString("both_pri_sec_count")==null || rs.getString("both_pri_sec_count")=="")?"" : rs.getString("both_pri_sec_count");

				pri_count = (rs.getString("pri_count")==null || rs.getString("pri_count")=="")?"" : rs.getString("pri_count");

				sec_count = (rs.getString("sec_count")==null || rs.getString("sec_count")=="")?"" : rs.getString("sec_count");
			}

			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();

			String linksql = " SELECT CASE WHEN MAX (CASE WHEN link_diag_pri_sec_yn = 'Y' THEN 1 ELSE 0 END) = 1 THEN 'Y' ELSE '' END AS linked_yn FROM pr_diagnosis_enc_dtl WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND status != 'E' ";
		
			pstmt = conn.prepareStatement(linksql);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,facility_id);

			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

				linked_yn = (rs.getString("linked_yn")==null || rs.getString("linked_yn")=="")?"" : rs.getString("linked_yn");
			}

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			if(!primary_diag_class.equals("") && !secondary_diag_class.equals(""))
			{
				if(!both_pri_sec_count.equals("") || linked_yn.equals("Y")){
					auto_fin_death_reg_yn = "Y";
				}
			}else if(!primary_diag_class.equals("") && secondary_diag_class.equals(""))
			{
				if(!pri_count.equals("")){
					auto_fin_death_reg_yn = "Y";
				}
			}else if(primary_diag_class.equals("") && !secondary_diag_class.equals(""))
			{
				if(!sec_count.equals("")){
					auto_fin_death_reg_yn = "Y";
				}
			}
		}

		if(auto_fin_death_reg_yn.equals("Y")){

			String UpdateSql = "UPDATE mr_death_register_hdr SET finalize_yn = 'Y' WHERE patient_id = ? AND encounter_id = ? AND facility_id = ?";

			pstmt = conn.prepareStatement(UpdateSql);
			pstmt.setString (1,patient_id);
			pstmt.setString (2,encounter_id);
			pstmt.setString (3,facility_id);
			int count = pstmt.executeUpdate();

			if(count > 0){
				finalize_yn = "Y";
				conn.commit(); 
			}else{
				conn.rollback();
			}

			if(pstmt!=null)pstmt.close();
		}
	}
	/*End ML-MMOH-CRF-1742*/
%>
</html>
		<iframe name='pline' id='pline' 	src="../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>" frameborder="0" scrolling="NO"/ style='height:7vh;width:99vw'></iframe>
				<iframe name='DR_HeaderDtl_Frame' id='DR_HeaderDtl_Frame' frameborder='0' noresize scrolling='AUTO' style='height:18vh;width:99vw' src="../../eMR/jsp/AddModifyDeathRegisterHeaderDtls.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&locn_code=<%=locn_code%>&gender=<%=gender%>&dob=<%=dob%>&speciality_code=<%=speciality_code%>&episode_id=<%=episode_id%> &practitioner_id=<%=practitioner_id%>&practitioner_type=<%=practitioner_type%>&patient_class=<%=patient_class%>&call_from=<%=call_from%>&episode_type=<%=episode_type%>&finalize_yn=<%=finalize_yn%>&visit_adm_date=<%=visit_adm_date%>"/></iframe>
				<iframe name='DR_DiagnosisDtl_Frame' id='DR_DiagnosisDtl_Frame' frameborder='0' noresize scrolling='NO' style='height:37vh;width:99vw' src="../../eMR/jsp/AddModifyDeathRegisterDiagnosisDtls.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&locn_code=<%=locn_code%>&gender=<%=gender%>&dob=<%=dob%>&speciality_code=<%=speciality_code%>&episode_id=<%=episode_id%> &practitioner_id=<%=practitioner_id%>&practitioner_type=<%=practitioner_type%>&patient_class=<%=patient_class%>&call_from=<%=call_from%>&episode_type=<%=episode_type%>&finalize_yn=<%=finalize_yn%>&visit_adm_date=<%=visit_adm_date%>"/></iframe>
				<iframe name='DR_OtherDtl_Frame' id='DR_OtherDtl_Frame' frameborder='0' noresize scrolling='AUTO' style='height:29vh;width:99vw' src="../../eMR/jsp/AddModifyDeathRegisterOthersDtls.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&locn_code=<%=locn_code%>&gender=<%=gender%>&dob=<%=dob%>&speciality_code=<%=speciality_code%>&episode_id=<%=episode_id%> &practitioner_id=<%=practitioner_id%>&practitioner_type=<%=practitioner_type%>&patient_class=<%=patient_class%>&call_from=<%=call_from%>&episode_type=<%=episode_type%>&finalize_yn=<%=finalize_yn%>&visit_adm_date=<%=visit_adm_date%>"></iframe>
				<iframe name='DR_Button_Frame' id='DR_Button_Frame'  src="../../eMR/jsp/AddModifyDeathRegisterButtons.jsp?finalize_yn=<%=finalize_yn%>&call_from=<%=call_from%>" frameborder='0' noresize scrolling='NO' style='height:3vh;width:99vw'></iframe>
				<iframe name='DR_Message_Frame' id='DR_Message_Frame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='NO' style='height:3vh;width:99vw'></iframe>
		

<%
}catch(Exception ex){
	ex.printStackTrace();
	conn.rollback();
}finally{
	ConnectionManager.returnConnection(conn,request);
}
%>

<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

