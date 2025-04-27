<!DOCTYPE html>
<%@ page  import="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt = null;
	//PreparedStatement stmt = null;
	ResultSet rst1 = null;
	ResultSet rst2 = null;
	ResultSet rst = null;

	//ResultSet rs = null;

	String facility_id      = (String) session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter( "func_mode" );

	try{
		con = ConnectionManager.getConnection();
		if(func_mode.equalsIgnoreCase("populateConditionDateType")){	
			String chart_status = "";
			String super_key_num = "";
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_numbering_system = checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String mixed_dentition_YN = checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			//commented and added by parul on 29/04/2010 for IN021055
			//String asondate = checkForNull(request.getParameter( "asondate" )) ;
			String asondate = com.ehis.util.DateUtils.convertDate(checkForNull(request.getParameter("asondate")),"DMY",locale,"en");  

			String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;

			if(baseline_chart_yn.equals("Y")){
				chart_status = "C";
			}
			else{
				chart_status = "A";
			}
			String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;	
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			String sql				= "";		
			String date = "";
			//String type = "";
			String PD_flag = "";
			String type_desc = "";
			//String site_type ="";
			String arch_desc = "";
			String quad_desc = "";
			String arch_quad = "";
			String condition_type = "";
			String deciduous_yn = "";
			String supernumerary_yn = "";
			String display_tooth_no = "";
			String cusp_tip_code = "";
			String remarks = "";
			String super_tooth_no = "";
			String retained_tooth_no = "";
			String condition_code = "";
			String organ_code="";
			String sub_organ_code="";
			String intraoral_extraoral="";
			StringBuffer date_type = new StringBuffer();
			StringBuffer chart_dtls = new StringBuffer();
			String[] tooth_range_arr = null;
			//A.SUPER_TOOTH_NO,A.retained_tooth_no added in query by parul on 11/12/2009 for super changes.

			if(oh_chart_level.equals("E")){
				if(baseline_chart_yn.equals("Y")){
					sql = " SELECT  A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.REMARKS, A.CUSP_TIP_CODE,A.CONDITION_TYPE,(SELECT CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW CTV WHERE CTV.LANGUAGE_ID = ? AND CTV.CONDITION_TYPE = A.CONDITION_TYPE) CONDITION_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM,C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE ,C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID=? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO,(SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID=? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.SURFACE_CODE,A.CONDITION_TYPE, A.CONDITION_CODE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND TREATMENT_CONDITION='C' AND C.CHART_STATUS = 'C' AND NVL(STATUS,'X') NOT IN ('E','Z') AND A.CHART_NUM = ? AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";

					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale); // For OH_CONDITION_TYPE_LANG_VW
					pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
					pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
					pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
					pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
					pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
					pstmt.setString(7,patient_id);
					pstmt.setString(8,chart_num);
				}
				else{
					//Commented by Sharon Crasta on 3/30/2010 for IN018302
					//Changed logic considering asOnDate.
					//sql = "SELECT A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.REMARKS, A.CUSP_TIP_CODE,A.CONDITION_TYPE,(SELECT CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW CTV WHERE CTV.LANGUAGE_ID = ? AND CTV.CONDITION_TYPE = A.CONDITION_TYPE) CONDITION_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM,C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE ,C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID=? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO,(SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID=? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.SURFACE_CODE,A.CONDITION_TYPE, A.CONDITION_CODE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND TREATMENT_CONDITION='C' AND C.CHART_STATUS = 'A'  AND TRUNC(A.TREATMENT_CONDITION_DATE) <= TO_DATE(?,'DD/MM/YYYY') AND NVL(STATUS,'X') NOT IN ('E','Z') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					sql = "SELECT A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.REMARKS, A.CUSP_TIP_CODE,A.CONDITION_TYPE,(SELECT CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW CTV WHERE CTV.LANGUAGE_ID = ? AND CTV.CONDITION_TYPE = A.CONDITION_TYPE) CONDITION_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM,C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE ,C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID=? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO,(SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID=? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.SURFACE_CODE,A.CONDITION_TYPE, A.CONDITION_CODE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND TREATMENT_CONDITION='C' AND A.CHART_NUM = (SELECT MAX (CHART_NUM) FROM OH_RESTORATIVE_CHART_HDR  WHERE PATIENT_ID = ? AND TO_DATE (?, 'DD/MM/YYYY') BETWEEN TRUNC (CHART_DATE) AND TRUNC(NVL (CHART_CLOSE_DATE,SYSDATE))) AND TRUNC(A.TREATMENT_CONDITION_DATE) <= TO_DATE(?,'DD/MM/YYYY') AND NVL(STATUS,'X') NOT IN ('E','Z') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale); // For OH_CONDITION_TYPE_LANG_VW
					pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
					pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
					pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
					pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
					pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
					pstmt.setString(7,patient_id);
					//Added by Sharon Crasta on 3/30/2010 for IN018302 - Incorportaing chart_num for asOnDate Logic too.
					pstmt.setString(8,patient_id);
					pstmt.setString(9,asondate);
					//End
					pstmt.setString(10,asondate);
				}
			}
			else{
				if(baseline_chart_yn.equals("Y")){
					/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT_LANG_VW */
					//sql = "SELECT A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.CUSP_TIP_CODE,A.CONDITION_TYPE,(SELECT CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW CTV WHERE CTV.LANGUAGE_ID = ? AND CTV.CONDITION_TYPE = A.CONDITION_TYPE) CONDITION_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM,C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE ,C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID=? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO,(SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID=? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO AND G.PERMANENT_DECIDUOUS=?) QUADRANT_DESC, A.SURFACE_CODE,A.CONDITION_TYPE, A.CONDITION_CODE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND TREATMENT_CONDITION='C' AND C.CHART_STATUS = 'C' AND NVL(STATUS,'X') NOT IN ('E','Z') AND A.CHART_NUM = ? AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					sql = "SELECT A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.REMARKS, A.CUSP_TIP_CODE,A.CONDITION_TYPE,(SELECT CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW CTV WHERE CTV.LANGUAGE_ID = ? AND CTV.CONDITION_TYPE = A.CONDITION_TYPE) CONDITION_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM,C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE ,C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID=? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO,(SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID=? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.SURFACE_CODE,A.CONDITION_TYPE, A.CONDITION_CODE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND TREATMENT_CONDITION='C' AND C.CHART_STATUS = 'C' AND NVL(STATUS,'X') NOT IN ('E','Z') AND A.CHART_NUM = ? AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";

					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale); // For OH_CONDITION_TYPE_LANG_VW
					pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
					pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
					pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
					pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
					pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
					//pstmt.setString(7,permanent_deciduous_flag); // For OH_QUADRANT_LANG_VW
					//pstmt.setString(7,facility_id);
					pstmt.setString(7,other_chart_facility_id);
					pstmt.setString(8,patient_id);
					//pstmt.setString(10,asondate);
					pstmt.setString(9,chart_num);
				}
				else{
					/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT_LANG_VW */
					//sql = "SELECT A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.CUSP_TIP_CODE,A.CONDITION_TYPE,(SELECT CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW CTV WHERE CTV.LANGUAGE_ID = ? AND CTV.CONDITION_TYPE = A.CONDITION_TYPE) CONDITION_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM,C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE ,C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID=? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO,(SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID=? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO AND G.PERMANENT_DECIDUOUS=?) QUADRANT_DESC, A.SURFACE_CODE,A.CONDITION_TYPE, A.CONDITION_CODE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND TREATMENT_CONDITION='C' AND C.CHART_STATUS = 'A'  AND TRUNC(A.TREATMENT_CONDITION_DATE) <= TO_DATE(?,'DD/MM/YYYY') AND NVL(STATUS,'X') NOT IN ('E','Z') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";

					//sql = "SELECT A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.REMARKS, A.CUSP_TIP_CODE,A.CONDITION_TYPE,(SELECT CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW CTV WHERE CTV.LANGUAGE_ID = ? AND CTV.CONDITION_TYPE = A.CONDITION_TYPE) CONDITION_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM,C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE ,C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID=? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO,(SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID=? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.SURFACE_CODE,A.CONDITION_TYPE, A.CONDITION_CODE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN ,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND TREATMENT_CONDITION='C' AND C.CHART_STATUS = 'A'  AND TRUNC(A.TREATMENT_CONDITION_DATE) <= TO_DATE(?,'DD/MM/YYYY') AND NVL(STATUS,'X') NOT IN ('E','Z') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					sql = "SELECT A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.REMARKS, A.CUSP_TIP_CODE,A.CONDITION_TYPE,(SELECT CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW CTV WHERE CTV.LANGUAGE_ID = ? AND CTV.CONDITION_TYPE = A.CONDITION_TYPE) CONDITION_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM,C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE ,C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID=? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO,(SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID=? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.SURFACE_CODE,A.CONDITION_TYPE, A.CONDITION_CODE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN ,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND TREATMENT_CONDITION='C' AND A.CHART_NUM = (SELECT MAX (CHART_NUM) FROM OH_RESTORATIVE_CHART_HDR  WHERE PATIENT_ID = ? AND TO_DATE (?, 'DD/MM/YYYY') BETWEEN TRUNC (CHART_DATE) AND TRUNC(NVL (CHART_CLOSE_DATE,SYSDATE)))  AND TRUNC(A.TREATMENT_CONDITION_DATE) <= TO_DATE(?,'DD/MM/YYYY') AND NVL(STATUS,'X') NOT IN ('E','Z') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale); // For OH_CONDITION_TYPE_LANG_VW
					pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
					pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
					pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
					pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
					pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
					//pstmt.setString(7,permanent_deciduous_flag); // For OH_QUADRANT_LANG_VW
					//pstmt.setString(7,facility_id);
					pstmt.setString(7,other_chart_facility_id);
					pstmt.setString(8,patient_id);
					//pstmt.setString(10,chart_status);
					//Added by Sharon Crasta on 3/30/2010 for IN018302 - Incorportaing chart_num for asOnDate Logic too.
					pstmt.setString(9,patient_id);
					pstmt.setString(10,asondate);
					//End
					pstmt.setString(11,asondate);
				}
			}

				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					chart_dtls.setLength(0);
					// The below order should not be changed, as it is being used in the js file.
					type_desc = rst.getString("CONDITION_TYPE_DESC");		//  1
					date = rst.getString("TREATMENT_CONDITION_DATE");		//  2
					arch_desc = rst.getString("ARCH_DESC");		//  3
					quad_desc = rst.getString("QUADRANT_DESC");		//  4
					condition_type = rst.getString("CONDITION_TYPE");
					deciduous_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
					supernumerary_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
					cusp_tip_code = checkForNull(rst.getString("CUSP_TIP_CODE"));
					remarks = checkForNull(rst.getString("REMARKS"));
					super_tooth_no = checkForNull(rst.getString("SUPER_TOOTH_NO"));
					retained_tooth_no = checkForNull(rst.getString("RETAINED_TOOTH_NO"));
					condition_code = checkForNull(rst.getString("CONDITION_CODE"));
					super_key_num = checkForNull(rst.getString("SUPER_KEY_NUM"));
					intraoral_extraoral = checkForNull(rst.getString("INTRAORAL_EXTRAORAL"));
					organ_code = checkForNull(rst.getString("ORGAN_CODE"));
					sub_organ_code = checkForNull(rst.getString("SUB_ORGAN_CODE"));
				
					// The below order should not be changed, as it is being used in the js file.
					chart_dtls.append(rst.getString("CHART_NUM")+":");		//  5
					chart_dtls.append(rst.getString("CHART_LINE_NUM")+":"); //  6
					chart_dtls.append(rst.getString("CHART_STATUS")+":");	//  7
					chart_dtls.append(rst.getString("CHART_DATE")+":");		//  8
					chart_dtls.append(rst.getString("SITE_TYPE")+":");		//  9
					chart_dtls.append(rst.getString("TOOTH_NO")+":");		//  10
					chart_dtls.append(rst.getString("NS_TOOTH_NO")+":");	//  11
					chart_dtls.append(rst.getString("ARCH_SNO")+":");		// 12
					chart_dtls.append(rst.getString("QUADRANT_SNO")+":");	// 13
					chart_dtls.append(rst.getString("SURFACE_CODE")+":");	// 14
					chart_dtls.append(rst.getString("CONDITION_TYPE")+":");	// 15
					chart_dtls.append(rst.getString("CONDITION_CODE")+":");		// 16
					chart_dtls.append(rst.getString("TOOTH_RANGE")+":");		// 17 added by Sridevi Joshi
										
					String thrang_ref = "";
					String thrng_nos = checkForNull(rst.getString("TOOTH_RANGE"));
					if(!thrng_nos.equals(null) && !thrng_nos.equals("") && thrng_nos.indexOf(",") != -1){
						tooth_range_arr = thrng_nos.split(",");
						//String[] temp_arr = null;
						
						//2$$5,3$$6
						String str="";
						int ind = 0;
						int z=0;
						for(int i=0;i<tooth_range_arr.length;i++){
							str = tooth_range_arr[i];
							ind = str.indexOf("$$");
							str = str.substring(ind+2,str.length());
							pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM=? AND TOOTH_NO=?");
							pstmt1.setString(1,tooth_numbering_system);
							pstmt1.setString(2,str);
							rst1 = pstmt1.executeQuery();
							
							while(rst1!= null && rst1.next()){
								if(z==0){
									thrang_ref = rst1.getString("NS_TOOTH_NO");
								}
								else{
									thrang_ref = thrang_ref+","+rst1.getString("NS_TOOTH_NO");
								}
								z++;
							}
						}
					}
					chart_dtls.append(thrang_ref+":"); // 17 added by Sridevi Joshi
					chart_dtls.append(rst.getString("CLINICAL_GROUP_CODE")+":");		// 18 added by Sridevi Joshi
					/* These fields are added here by Sridevi Joshi on 4/26/2010 for PE from above after TOOTH_RANGE value */
					chart_dtls.append(rst.getString("INTRAORAL_EXTRAORAL")+":");		// 19 added by Sridevi Joshi
					chart_dtls.append(rst.getString("ORGAN_CODE")+":");		// 20 added by Sridevi Joshi
					chart_dtls.append(rst.getString("SUB_ORGAN_CODE"));		// 21 added by Sridevi Joshi
					if(rst.getString("SITE_TYPE").equals("ARCH")){
						arch_quad = arch_desc;
					}
					else if(rst.getString("SITE_TYPE").equals("QUAD")){
						arch_quad = quad_desc;
					}

					//if(deciduous_yn.equals("D") || deciduous_yn.equals("R")){
						if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
							PD_flag = "P";
						}
						else{
							PD_flag = "D";
						}
						//String th_temp = rst.getString("TOOTH_NO");
						//pstmt1 = con.prepareStatement("SELECT A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
						pstmt2 = con.prepareStatement("SELECT A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)");
						pstmt2.setString(1,tooth_numbering_system);
						pstmt2.setString(2,rst.getString("TOOTH_NO"));
						//pstmt1.setString(3,PD_flag);
						rst2 = pstmt2.executeQuery();
						while(rst2!= null && rst2.next()){
							display_tooth_no = rst2.getString("NS_TOOTH_NO");
						}

						
					//}
					//date_type.append(date+"##"+type_desc+"##"+rst.getString("NS_TOOTH_NO")+"##"+chart_dtls+"##"+arch_quad+"##"+display_tooth_no+"##"+deciduous_yn+"##"+supernumerary_yn+"##"+cusp_tip_code+"##"+remarks); 
					date_type.append(date+"OH_SEP_1"+type_desc+"OH_SEP_1"+rst.getString("NS_TOOTH_NO")+"OH_SEP_1"+chart_dtls+"OH_SEP_1"+arch_quad+"OH_SEP_1"+display_tooth_no+"OH_SEP_1"+deciduous_yn+"OH_SEP_1"+supernumerary_yn+"OH_SEP_1"+cusp_tip_code+"OH_SEP_1"+remarks+"OH_SEP_1"+rst.getString("TOOTH_NO") +"OH_SEP_1"+super_tooth_no+"OH_SEP_1"+retained_tooth_no+"OH_SEP_1"+condition_code+"OH_SEP_1"+super_key_num+"OH_SEP_1"+sub_organ_code+"OH_SEP_1"+intraoral_extraoral+"OH_SEP_1"+"OH_SEP_1"+organ_code+"OH_SEP_1"+thrang_ref+"OH_SEP_1"); 
					//date_type.append("~");
					date_type.append("OH_SEP_2");

				}
				if(rst!=null)rst.close();
				if(rst1!=null)rst1.close();
				if(rst2!=null)rst2.close();
				if(pstmt!=null)pstmt.close();
				if(pstmt1!=null)pstmt1.close();
				if(pstmt2!=null)pstmt2.close();
				out.println(date_type);
		
		}else if(func_mode.equalsIgnoreCase("populateBaseLineChart")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_status = checkForNull(request.getParameter( "chart_status" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			//String facility_id1 = checkForNull(request.getParameter( "facility_id" )) ;
			String sql				= "";		
			String chart_date = "";
			String chart_num = "";
			String clinical_group_code = "";
			String chart_type = "";
			//Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
			String chart_close_date = "";
			//String chart_close_date = "";
			StringBuffer date_type = new StringBuffer();
			//StringBuffer chart_dtls = new StringBuffer();
			if(oh_chart_level.equals("E")){
				//Commented and Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
				//Added chart close date
				//sql = "SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE, CHART_NUM, CHART_TYPE, CLINICAL_GROUP_CODE  FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = ? ORDER BY CHART_NUM DESC";
				sql = "SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE, CHART_NUM, CHART_TYPE, CLINICAL_GROUP_CODE,  TO_CHAR(CHART_CLOSE_DATE,'DD/MM/YYYY') CHART_CLOSE_DATE FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = ? ORDER BY CHART_NUM DESC";
				//
				//	sql = "SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE, CHART_NUM, CHART_TYPE, CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID!= ? AND PATIENT_ID = ? AND CHART_STATUS = ? ORDER BY CHART_NUM DESC";
				pstmt = con.prepareStatement(sql);
				//pstmt.setString(1,facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_status);
			}else{
				//sql = "SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE, CHART_NUM, CHART_TYPE, CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID= ? AND PATIENT_ID = ? AND CHART_STATUS = ? ORDER BY CHART_NUM DESC";
				//Commented and Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
				//Added chart close date
				//sql = "SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE, CHART_NUM, CHART_TYPE, CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = ? ORDER BY CHART_NUM DESC";
				sql = "SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE, CHART_NUM, CHART_TYPE, CLINICAL_GROUP_CODE,  TO_CHAR(CHART_CLOSE_DATE,'DD/MM/YYYY') CHART_CLOSE_DATE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = ? ORDER BY CHART_NUM DESC";
				//
				//sql="SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE, CHART_NUM, CHART_TYPE, CLINICAL_GROUP_CODE ,TO_CHAR(CHART_CLOSE_DATE,'DD/MM/YYYY')CHART_CLOSE_DATE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID= ? AND PATIENT_ID = ? AND CHART_STATUS = ? ORDER BY CHART_NUM DESC";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_status);

			}
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					//chart_dtls.setLength(0);
					// The below order should not be changed, as it is being used in the js file.
					chart_date = rst.getString("CHART_DATE");		//  1
					chart_num = rst.getString("CHART_NUM");
					chart_type = rst.getString("CHART_TYPE");	//  2
					clinical_group_code = rst.getString("CLINICAL_GROUP_CODE");		//  3
					//Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
					chart_close_date = rst.getString("CHART_CLOSE_DATE");		//  3
						//  3
				//	chart_close_date = rst.getString("CHART_CLOSE_DATE");		//  3
					// The below order should not be changed, as it is being used in the js file.
					
					//Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
					//date_type.append(chart_date+"##"+chart_num+"##"+clinical_group_code+"##"+chart_type);
					date_type.append(chart_date+"##"+chart_num+"##"+clinical_group_code+"##"+chart_type+"##"+chart_close_date);
					//date_type.append(chart_date+"##"+chart_num+"##"+clinical_group_code+"##"+chart_type+"##"+chart_close_date); 
					date_type.append("~");
				}
				out.println(date_type);
		}
		else if(func_mode.equalsIgnoreCase("populateExtTreatments")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_numbering_system = checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			//String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			//commented and added by parul on 29/04/2010 for IN021055
			//String asondate = checkForNull(request.getParameter( "asondate" )) ;
			String asondate = com.ehis.util.DateUtils.convertDate(checkForNull(request.getParameter("asondate")),"DMY",locale,"en");  

			String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;

			String sql				= "";		
			String date = "";
			String maxila_tooth = "";
			//String type = "";
			String type_desc = "";
			String arch_desc = "";
			String quad_desc = "";
			String arch_quad = "";
			String remarks = "";
			String status = "";
			String site_type  = "";
			String cusp_tip_code  = "";
			String chart_line_num  = "";
			String str_chart_line_num="";
			String mixed_dent_deciduous_yn="";
			String supernumerary_yn="";
			String display_tooth_no="";
			StringBuffer date_type = new StringBuffer();
			StringBuffer chart_dtls = new StringBuffer();
			String[] tooth_range_arr = null;
			String intraoral_extraoral = "";
			String sub_organ_code_1 = "";
			String super_tooth_no = "";
			String retained_tooth_no = "";
			String super_key_num = "";
			String failure_remarks = "";

			int maxRecord=0;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			if (oh_chart_level.equals("E")){
				if(baseline_chart_yn.equals("Y")){
					sql = "SELECT A.FAILURE_REMARKS,A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.CUSP_TIP_CODE,A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.SURFACE_CODE, A.TRMT_CODE, A.SURFACE_CODE, A.LOCATION, A.STATUS, A.TREATMENTS_OUTCOME, A.MIXED_DENT_DECIDUOUS_YN, A.SUPERNUMERARY_YN , A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'E' AND C.CHART_STATUS = 'C' AND NVL(STATUS,'X') != 'E' AND A.CHART_NUM = ? AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC"; 
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale); // For OH_TRTMT_CATEGORY_TYPE_LANG_VW
					pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
					pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
					pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
					pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
					pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
					pstmt.setString(7,patient_id);
					pstmt.setString(8,chart_num);
				}
				else{
					sql = "SELECT A.FAILURE_REMARKS,A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.REMARKS,A.CUSP_TIP_CODE,A.STATUS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.SURFACE_CODE, A.TRMT_CODE, A.SURFACE_CODE, A.LOCATION, A.STATUS, A.TREATMENTS_OUTCOME, A.MIXED_DENT_DECIDUOUS_YN, A.SUPERNUMERARY_YN , A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'E' AND A.CHART_NUM = (SELECT MAX (CHART_NUM) FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND TO_DATE (?, 'DD/MM/YYYY') BETWEEN TRUNC (CHART_DATE) AND TRUNC (NVL (CHART_CLOSE_DATE, SYSDATE))) AND TRUNC(A.TREATMENT_CONDITION_DATE) <= TO_DATE(?,'DD/MM/YYYY') AND NVL(STATUS,'X') != 'E' AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC"; 
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale); // For OH_TRTMT_CATEGORY_TYPE_LANG_VW
					pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
					pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
					pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
					pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
					pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
					pstmt.setString(7,patient_id);
					//Added by Sharon Crasta on 3/30/2010 for IN018302
					pstmt.setString(8,patient_id);
					pstmt.setString(9,asondate);
					//End
					pstmt.setString(10,asondate);
				}
			}else{
				if(baseline_chart_yn.equals("Y")){
					sql = "SELECT A.FAILURE_REMARKS,A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS,A.CUSP_TIP_CODE, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.SURFACE_CODE, A.TRMT_CODE, A.SURFACE_CODE, A.LOCATION, A.STATUS, A.TREATMENTS_OUTCOME, A.MIXED_DENT_DECIDUOUS_YN, A.SUPERNUMERARY_YN, A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'E' AND C.CHART_STATUS = 'C' AND NVL(STATUS,'X') != 'E' AND A.CHART_NUM = ? AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC"; 
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale); // For OH_TRTMT_CATEGORY_TYPE_LANG_VW
					pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
					pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
					pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
					pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
					pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
					pstmt.setString(7,other_chart_facility_id);
					pstmt.setString(8,patient_id);
					pstmt.setString(9,chart_num);
				}
				else{
					sql = "SELECT A.FAILURE_REMARKS,A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.REMARKS,A.CUSP_TIP_CODE, A.STATUS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.SURFACE_CODE, A.TRMT_CODE, A.SURFACE_CODE, A.LOCATION, A.STATUS, A.TREATMENTS_OUTCOME, A.MIXED_DENT_DECIDUOUS_YN, A.SUPERNUMERARY_YN ,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'E' AND A.CHART_NUM =	(SELECT MAX (CHART_NUM) FROM OH_RESTORATIVE_CHART_HDR     WHERE PATIENT_ID = ? AND TO_DATE (?, 'DD/MM/YYYY') BETWEEN TRUNC (CHART_DATE)                    AND TRUNC (NVL (CHART_CLOSE_DATE, SYSDATE))) AND TRUNC(A.TREATMENT_CONDITION_DATE) <= TO_DATE(?,'DD/MM/YYYY') AND NVL(STATUS,'X') != 'E' AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC"; 
					
					pstmt = con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					pstmt.setString(1,locale); // For OH_TRTMT_CATEGORY_TYPE_LANG_VW
					pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
					pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
					pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
					pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
					pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
					pstmt.setString(7,other_chart_facility_id);
					pstmt.setString(8,patient_id);
					//Added by Sharon Crasta on 3/30/2010 for IN018302
					pstmt.setString(9,patient_id);
					pstmt.setString(10,asondate);
					//End
					pstmt.setString(11,asondate);
				}
			}

			rst = pstmt.executeQuery();
			maxRecord = rst.getRow();
			while(rst!= null && rst.next()){
				chart_dtls.setLength(0);

				// The below order should not be changed, as it is being used in the js file.
				type_desc = rst.getString("TRMT_CATEGORY_TYPE_DESC");		//  1
				date = rst.getString("TREATMENT_CONDITION_DATE");		//  2
				arch_desc = rst.getString("ARCH_DESC");		//  3
				quad_desc = rst.getString("QUADRANT_DESC");		//  4
				remarks = rst.getString("REMARKS");		//  4
				cusp_tip_code = checkForNull(rst.getString("CUSP_TIP_CODE"));//added by parul on 24/08/2009 for crf#0483 
				site_type = checkForNull(rst.getString("SITE_TYPE"));
				chart_line_num = rst.getString("CHART_LINE_NUM");
				status = rst.getString("STATUS");
				mixed_dent_deciduous_yn = rst.getString("MIXED_DENT_DECIDUOUS_YN");
				supernumerary_yn = rst.getString("SUPERNUMERARY_YN");
				sub_organ_code_1 = rst.getString("SUB_ORGAN_CODE");
				super_tooth_no = rst.getString("SUPER_TOOTH_NO");
				retained_tooth_no = rst.getString("RETAINED_TOOTH_NO");
				super_key_num = checkForNull(rst.getString("SUPER_KEY_NUM"));
				failure_remarks = checkForNull(rst.getString("FAILURE_REMARKS"));

				if(site_type.equals("THRNG") || ((site_type.equals("MAXFS") && (sub_organ_code_1!=("") && sub_organ_code_1!=(null) && sub_organ_code_1!=("null"))) && (sub_organ_code_1.equals("TNGAB") || sub_organ_code_1.equals("TNGGM") || sub_organ_code_1.equals("TNGAG") || sub_organ_code_1.equals("TNGGAM") || sub_organ_code_1.equals("TNGMF")))){//TNGAB,TNGGM,TNGAG,TNGGAM,TNGMF
					chart_dtls.append(rst.getString("CHART_NUM")+":");		//  5
					chart_dtls.append(rst.getString("CHART_LINE_NUM")+":"); //  6
					chart_dtls.append(rst.getString("CHART_STATUS")+":");	//  7
					chart_dtls.append(rst.getString("CHART_DATE")+":");		//  8
					chart_dtls.append(checkForNull(rst.getString("SITE_TYPE"))+":");		//  9
					chart_dtls.append(checkForNull(rst.getString("TOOTH_NO"))+":");		//  10
					chart_dtls.append(rst.getString("NS_TOOTH_NO")+":");	//  11
					chart_dtls.append(rst.getString("ARCH_SNO")+":");		// 12
					chart_dtls.append(rst.getString("QUADRANT_SNO")+":");	// 13
					chart_dtls.append(rst.getString("SURFACE_CODE")+":");	// 14
					chart_dtls.append(rst.getString("TRMT_CATEGORY_TYPE")+":");	// 15
					chart_dtls.append(rst.getString("TRMT_CODE")+":");		// 16
					chart_dtls.append(rst.getString("TOOTH_RANGE")+":");		// 17 added by Sridevi Joshi

					String thrang_ref = "";
					String str1="";
					String str2="";
					String thrng_nos = checkForNull(rst.getString("TOOTH_RANGE"));
					if(!thrng_nos.equals(null) && !thrng_nos.equals("") && thrng_nos.indexOf(",") != -1){
						tooth_range_arr = thrng_nos.split(",");
						String str="";
						int ind = 0;
						int z=0;
						int m=0;
						ind = thrng_nos.indexOf("$$");
						str_chart_line_num = thrng_nos.substring(0,ind);
						for(int i=0;i<tooth_range_arr.length;i++){	
							str = tooth_range_arr[i];//1$$1
							ind = str.indexOf("$$");
							str = str.substring(ind+2,str.length());
							pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM=? AND TOOTH_NO=?");
							pstmt1.setString(1,tooth_numbering_system);
							pstmt1.setString(2,str);
							rst1 = pstmt1.executeQuery();
							while(rst1!= null && rst1.next()){
								if(z==0){
									thrang_ref = rst1.getString("NS_TOOTH_NO");
									str1=str;
									
								}
								else{
									thrang_ref = thrang_ref+","+rst1.getString("NS_TOOTH_NO");
									str2=str;
								}
								z++;
							}
							maxila_tooth=str1+","+str2;
							pstmt2 = con.prepareStatement("SELECT A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)");
							pstmt2.setString(1,tooth_numbering_system);
							pstmt2.setString(2,str);
							rst2 = pstmt2.executeQuery();
							while(rst2!= null && rst2.next()){
								if(m==0){
									display_tooth_no = rst2.getString("NS_TOOTH_NO");
								}
								else{
									display_tooth_no = display_tooth_no+","+rst2.getString("NS_TOOTH_NO");;
								}
								m++;
							}

							if(rst2!=null)rst2.close();
							if(pstmt2!=null)pstmt2.close();
							if(rst1!=null)rst1.close();
							if(pstmt1!=null)pstmt1.close();
						}
					}

					chart_dtls.append(thrang_ref+":"); // 18 added by Sridevi Joshi
					chart_dtls.append(rst.getString("CLINICAL_GROUP_CODE")+":");		// 19 added by Sridevi Joshi
					chart_dtls.append(rst.getString("SURFACE_CODE")+":");		// 20 added by Sridevi Joshi
					chart_dtls.append(rst.getString("LOCATION")+":");		// 21 added by Sridevi Joshi
					chart_dtls.append(rst.getString("STATUS")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("TREATMENTS_OUTCOME")+":");		// 23 added by Sridevi Joshi
					chart_dtls.append(rst.getString("INTRAORAL_EXTRAORAL")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("ORGAN_CODE")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("SUB_ORGAN_CODE"));		// 23 added by Sridevi Joshi
					if(site_type.equals("ARCH")){
						arch_quad = arch_desc;
					}
					else if(site_type.equals("QUAD")){
						arch_quad = quad_desc;
					}
					else if(site_type.equals("MAXFS")){
						arch_quad = intraoral_extraoral;
					}else{
					    arch_quad = "NA";
					}
					if(!str_chart_line_num.equals(chart_line_num)){
						continue;
					}
					else{	
						date_type.append(date+"OH_SEP_1"+type_desc+"OH_SEP_1"+rst.getString("NS_TOOTH_NO")+"OH_SEP_1"+chart_dtls+"OH_SEP_1"+arch_quad+"OH_SEP_1"+remarks+"OH_SEP_1"+thrang_ref+"OH_SEP_1"+site_type+"OH_SEP_1"+status+"OH_SEP_1"+mixed_dent_deciduous_yn+"OH_SEP_1"+display_tooth_no+"OH_SEP_1"+supernumerary_yn+"OH_SEP_1"+cusp_tip_code+"OH_SEP_1"+sub_organ_code_1+"OH_SEP_1"+maxila_tooth+"OH_SEP_1"+super_tooth_no+"OH_SEP_1"+retained_tooth_no+"OH_SEP_1"+super_key_num+"OH_SEP_1"+failure_remarks); 

						date_type.append("OH_SEP_2");
						
					}
					
				}
				else{
					chart_dtls.append(rst.getString("CHART_NUM")+":");		//  5
					chart_dtls.append(rst.getString("CHART_LINE_NUM")+":"); //  6
					chart_dtls.append(rst.getString("CHART_STATUS")+":");	//  7
					chart_dtls.append(rst.getString("CHART_DATE")+":");		//  8
					chart_dtls.append(checkForNull(rst.getString("SITE_TYPE"))+":");		//  9
					chart_dtls.append(checkForNull(rst.getString("TOOTH_NO"))+":");		//  10
					chart_dtls.append(rst.getString("NS_TOOTH_NO")+":");	//  11
					chart_dtls.append(rst.getString("ARCH_SNO")+":");		// 12
					chart_dtls.append(rst.getString("QUADRANT_SNO")+":");	// 13
					chart_dtls.append(rst.getString("SURFACE_CODE")+":");	// 14
					chart_dtls.append(rst.getString("TRMT_CATEGORY_TYPE")+":");	// 15
					chart_dtls.append(rst.getString("TRMT_CODE")+":");		// 16
					chart_dtls.append(rst.getString("TOOTH_RANGE")+":");		// 17 added by Sridevi Joshi

					String thrang_ref = "";
					String thrng_nos = checkForNull(rst.getString("TOOTH_RANGE"));
					if(!thrng_nos.equals(null) && !thrng_nos.equals("") && thrng_nos.indexOf(",") != -1){
						tooth_range_arr = thrng_nos.split(",");
						String str="";
						int ind = 0;
						int z=0;
						for(int i=0;i<tooth_range_arr.length;i++){
							str = tooth_range_arr[i];
							ind = str.indexOf("$$");
							str = str.substring(ind+2,str.length());
							pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM=? AND TOOTH_NO=?");
							pstmt1.setString(1,tooth_numbering_system);
							pstmt1.setString(2,str);
							rst1 = pstmt1.executeQuery();
							
							while(rst1!= null && rst1.next()){
								if(z==0){
									thrang_ref = rst1.getString("NS_TOOTH_NO");
								}
								else{
									thrang_ref = thrang_ref+","+rst1.getString("NS_TOOTH_NO");
								}
								z++;
							}
						}
					}

					pstmt2 = con.prepareStatement("SELECT A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)");
					pstmt2.setString(1,tooth_numbering_system);
					pstmt2.setString(2,rst.getString("TOOTH_NO"));
					rst2 = pstmt2.executeQuery();
					while(rst2!= null && rst2.next()){
						display_tooth_no = rst2.getString("NS_TOOTH_NO");
					}

					chart_dtls.append(thrang_ref+":"); // 18 added by Sridevi Joshi
					chart_dtls.append(rst.getString("CLINICAL_GROUP_CODE")+":");		// 19 added by Sridevi Joshi
					chart_dtls.append(rst.getString("SURFACE_CODE")+":");		// 20 added by Sridevi Joshi
					chart_dtls.append(rst.getString("LOCATION")+":");		// 21 added by Sridevi Joshi
					chart_dtls.append(rst.getString("STATUS")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("TREATMENTS_OUTCOME")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("INTRAORAL_EXTRAORAL")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("ORGAN_CODE")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("SUB_ORGAN_CODE")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("SUPERNUMERARY_YN"));		// 23 added by Sridevi Joshi
					site_type = checkForNull(rst.getString("SITE_TYPE"));
					if(site_type.equals("ARCH")){
						arch_quad = arch_desc;
					}
					else if(site_type.equals("QUAD")){
						arch_quad = quad_desc;
					}
					else if(site_type.equals("MAXFS")){
						//arch_quad = "NA";
						arch_quad = intraoral_extraoral;
					}else{
					    arch_quad = "NA";
					}						
					date_type.append(date+"OH_SEP_1"+type_desc+"OH_SEP_1"+rst.getString("NS_TOOTH_NO")+"OH_SEP_1"+chart_dtls+"OH_SEP_1"+arch_quad+"OH_SEP_1"+remarks+"OH_SEP_1"+thrang_ref+"OH_SEP_1"+site_type+"OH_SEP_1"+status+"OH_SEP_1"+mixed_dent_deciduous_yn+"OH_SEP_1"+display_tooth_no+"OH_SEP_1"+supernumerary_yn+"OH_SEP_1"+cusp_tip_code+"OH_SEP_1"+rst.getString("TOOTH_NO")+"OH_SEP_1"+sub_organ_code_1+"OH_SEP_1"+super_tooth_no+"OH_SEP_1"+retained_tooth_no+"OH_SEP_1"+super_key_num+"OH_SEP_1"+failure_remarks); 

					date_type.append("OH_SEP_2");
				}

				if(rst1!=null)rst1.close();
				if(rst2!=null)rst2.close();
				if(pstmt1!=null)pstmt1.close();
			}
			out.println(date_type);
		}
		else if(func_mode.equalsIgnoreCase("populateGingivalStatus")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_numbering_system = checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			//String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			//String asondate = checkForNull(request.getParameter( "asondate" )) ;
			String gingival_recording_by = checkForNull(request.getParameter( "gingival_recording_by" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			//Commented by Sharon Crasta on 4/1/2009 for CRF #0423
			//String chart_num = "";
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String sextant_quad_sno = "";
			String tooth_no = "";
			String val_tooth_no = "";
			String sextant_quad_id = "";
			String gingival_status_code = "";
			String gs_date = "";
			String clinical_group_code = "";
			//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
			String mapped_tooth_no = "";
			String status_GS = "";
			//
			StringBuffer gs_buffer = new StringBuffer();
			if (other_chart_facility_id.equals("")|| other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
			}
			
			//pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.QUADRANT_SNO,(SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,A.CONDITION_TYPE,(SELECT CTV.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW CTV WHERE CTV.LANGUAGE_ID = ? AND CTV.CONDITION_TYPE = A.CONDITION_TYPE) CONDITION_TYPE_DESC,A.GINGIVAL_STATUS_CODE,TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND C.CHART_STATUS = 'A' AND TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY')<= ? AND NVL(A.STATUS,'X') != 'E'");
			//pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.QUADRANT_SNO,(SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,A.CONDITION_TYPE,(SELECT CTV.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW CTV WHERE CTV.LANGUAGE_ID = ? AND CTV.CONDITION_TYPE = A.CONDITION_TYPE) CONDITION_TYPE_DESC,A.GINGIVAL_STATUS_CODE,TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND C.CHART_STATUS = 'A'  AND NVL(A.STATUS,'X') != 'E'");
			//pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.QUADRANT_SNO,(SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,A.GINGIVAL_STATUS_CODE,TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND C.CHART_STATUS = 'A'  AND NVL(A.STATUS,'X') != 'E'");
			if(gingival_recording_by.equals("Q")){
				/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT */
				//pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.QUADRANT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT D.QUADRANT_ID FROM OH_QUADRANT D WHERE D.QUADRANT_SNO = A.QUADRANT_SNO AND D.NUMBERING_SYSTEM=? AND D.PERMANENT_DECIDUOUS =?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID =? AND C.CHART_STATUS = 'A' AND A.QUADRANT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E'");
				if (oh_chart_level.equals("E")){
					//pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.QUADRANT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT D.QUADRANT_ID FROM OH_QUADRANT D WHERE D.QUADRANT_SNO = A.QUADRANT_SNO AND D.NUMBERING_SYSTEM=?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE  A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.PATIENT_ID =? AND C.CHART_STATUS = 'A' AND A.QUADRANT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E'");
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.QUADRANT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT D.QUADRANT_ID FROM OH_QUADRANT D WHERE D.QUADRANT_SNO = A.QUADRANT_SNO AND D.NUMBERING_SYSTEM=?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE  A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.PATIENT_ID =? AND A.CHART_NUM =? AND A.QUADRANT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E'");
					pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.QUADRANT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT B.MAPPED_TOOTH_NO FROM OH_TOOTH B WHERE A.TOOTH_NO = B.TOOTH_NO) MAPPED_TOOTH_NO,(SELECT D.QUADRANT_ID FROM OH_QUADRANT D WHERE D.QUADRANT_SNO = A.QUADRANT_SNO AND D.NUMBERING_SYSTEM=?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE, A.STATUS FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE  A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.PATIENT_ID =? AND A.CHART_NUM =? AND A.QUADRANT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E' AND NVL(A.STATUS,'X') != 'Y'");

					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,tooth_numbering_system);
					//pstmt.setString(3,"P");
					//pstmt.setString(3,facility_id);
					pstmt.setString(3,patient_id);
					pstmt.setString(4,chart_num);
				}else{
				
					//pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.QUADRANT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT D.QUADRANT_ID FROM OH_QUADRANT D WHERE D.QUADRANT_SNO = A.QUADRANT_SNO AND D.NUMBERING_SYSTEM=?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID =? AND C.CHART_STATUS = 'A' AND A.QUADRANT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E'");
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.QUADRANT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT D.QUADRANT_ID FROM OH_QUADRANT D WHERE D.QUADRANT_SNO = A.QUADRANT_SNO AND D.NUMBERING_SYSTEM=?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID =? AND A.CHART_NUM =? AND A.QUADRANT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E'");
					pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.QUADRANT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT B.MAPPED_TOOTH_NO FROM OH_TOOTH B WHERE A.TOOTH_NO = B.TOOTH_NO) MAPPED_TOOTH_NO,(SELECT D.QUADRANT_ID FROM OH_QUADRANT D WHERE D.QUADRANT_SNO = A.QUADRANT_SNO AND D.NUMBERING_SYSTEM=?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE, A.STATUS FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID =? AND A.CHART_NUM =? AND A.QUADRANT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E' AND NVL(A.STATUS,'X') != 'Y' ");

					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,tooth_numbering_system);
					//pstmt.setString(3,"P");
					pstmt.setString(3,other_chart_facility_id);
					pstmt.setString(4,patient_id);
					pstmt.setString(5,chart_num);
				
				
				}
			}
			else{
				if (oh_chart_level.equals("E")){
					//pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.SEXTENT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT D.SEXTANT_ID FROM OH_SEXTANT D WHERE D.SEXTANT_SNO = A.SEXTENT_SNO AND D.NUMBERING_SYSTEM=?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE  A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.PATIENT_ID =? AND C.CHART_STATUS = 'A' AND A.SEXTENT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E'");
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.SEXTENT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT D.SEXTANT_ID FROM OH_SEXTANT D WHERE D.SEXTANT_SNO = A.SEXTENT_SNO AND D.NUMBERING_SYSTEM=?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE  A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.PATIENT_ID =? AND A.CHART_NUM =? AND A.SEXTENT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E'");
					pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.SEXTENT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT B.MAPPED_TOOTH_NO FROM OH_TOOTH B WHERE A.TOOTH_NO = B.TOOTH_NO) MAPPED_TOOTH_NO,(SELECT D.SEXTANT_ID FROM OH_SEXTANT D WHERE D.SEXTANT_SNO = A.SEXTENT_SNO AND D.NUMBERING_SYSTEM=?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE, A.STATUS FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE  A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.PATIENT_ID =? AND A.CHART_NUM =? AND A.SEXTENT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E' AND NVL(A.STATUS,'X') != 'Y'");

					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,tooth_numbering_system);
					//pstmt.setString(3,facility_id);
					pstmt.setString(3,patient_id);
					pstmt.setString(4,chart_num);		
				}else{
				    //pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.SEXTENT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT D.SEXTANT_ID FROM OH_SEXTANT D WHERE D.SEXTANT_SNO = A.SEXTENT_SNO AND D.NUMBERING_SYSTEM=?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID =? AND C.CHART_STATUS = 'A' AND A.SEXTENT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E'");
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
				    //pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.SEXTENT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT D.SEXTANT_ID FROM OH_SEXTANT D WHERE D.SEXTANT_SNO = A.SEXTENT_SNO AND D.NUMBERING_SYSTEM=?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID =? AND A.CHART_NUM =? AND A.SEXTENT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E'");
				    pstmt = con.prepareStatement("SELECT A.CHART_NUM, A.TOOTH_NO, A.SEXTENT_SNO SEXTANT_QUAD_SNO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM =? AND A.TOOTH_NO = B.TOOTH_NO) NS_TOOTH_NO,(SELECT B.MAPPED_TOOTH_NO FROM OH_TOOTH B WHERE A.TOOTH_NO = B.TOOTH_NO) MAPPED_TOOTH_NO,(SELECT D.SEXTANT_ID FROM OH_SEXTANT D WHERE D.SEXTANT_SNO = A.SEXTENT_SNO AND D.NUMBERING_SYSTEM=?) SEXTANT_QUAD_ID, A.GINGIVAL_STATUS_CODE, TO_CHAR (A.MODIFIED_DATE,'DD/MM/YYYY') GS_DATE, C.CLINICAL_GROUP_CODE, A.STATUS FROM OH_RESTORATIVE_CHART_GING_STS A,OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID =? AND A.CHART_NUM =? AND A.SEXTENT_SNO IS NOT NULL AND NVL(A.STATUS,'X') != 'E' AND NVL(A.STATUS,'X') != 'Y'");

					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,tooth_numbering_system);
					pstmt.setString(3,other_chart_facility_id);
					pstmt.setString(4,patient_id);
					pstmt.setString(5,chart_num);
								
				}
			}
			
			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				chart_num = rst.getString("CHART_NUM");		
				sextant_quad_sno = rst.getString("SEXTANT_QUAD_SNO");	
				tooth_no = rst.getString("NS_TOOTH_NO");		
				val_tooth_no = rst.getString("TOOTH_NO");		
				sextant_quad_id = rst.getString("SEXTANT_QUAD_ID");		
				
				gingival_status_code = checkForNull(rst.getString("GINGIVAL_STATUS_CODE"));
				gs_date = checkForNull(rst.getString("GS_DATE"));
				clinical_group_code = checkForNull(rst.getString("CLINICAL_GROUP_CODE"));
				//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)				
				mapped_tooth_no = checkForNull(rst.getString("MAPPED_TOOTH_NO"));
				status_GS = checkForNull(rst.getString("STATUS"));
				//	//gs_buffer.append(chart_num+"##"+quadrant_sno+"##"+tooth_no+"##"+condition_type+"##"+gingival_status_code+"##"+clinical_group_code+"##"+gs_date+"##"+condition_type_desc+"##"+val_tooth_no); 

				//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)	//gs_buffer.append(chart_num+"##"+sextant_quad_sno+"##"+tooth_no+"##"+gingival_status_code+"##"+clinical_group_code+"##"+gs_date+"##"+val_tooth_no+"##"+sextant_quad_id); 
				gs_buffer.append(chart_num+"##"+sextant_quad_sno+"##"+tooth_no+"##"+gingival_status_code+"##"+clinical_group_code+"##"+gs_date+"##"+val_tooth_no+"##"+sextant_quad_id+"##"+mapped_tooth_no+"##"+status_GS); 
				gs_buffer.append("~");
			}
			
			out.println(gs_buffer);
		}else if(func_mode.equalsIgnoreCase("populateOrderCatalog")){	
			String task_code = checkForNull(request.getParameter( "task_code" )) ;
			String order_catalog_bill_yn = "";
			
			pstmt = con.prepareStatement("SELECT BILL_YN FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OH_TASKS WHERE TASK_CODE = ?)");
			pstmt.setString(1,task_code);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				order_catalog_bill_yn = checkForNull(rst.getString("BILL_YN"));	
			}
			out.println(order_catalog_bill_yn);
		}else if(func_mode.equalsIgnoreCase("populateFacilityChart")){	////added by parul  for other facility chart CRF#0423
			String facility_name = "";
			String facility = "";
		    StringBuffer facility_buffer = new StringBuffer();

			pstmt = con.prepareStatement("SELECT A.FACILITY_ID,(SELECT B.FACILITY_NAME FROM SM_FACILITY_PARAM B WHERE B.FACILITY_ID=A.FACILITY_ID) FACILITY_NAME FROM OH_PARAM_FOR_FACILITY A WHERE A.FACILITY_ID!=?");
			pstmt.setString(1,facility_id);
			rst = pstmt.executeQuery();
			while (rst != null && rst.next()){
				facility = checkForNull(rst.getString("FACILITY_ID"));
				facility_name = checkForNull(rst.getString("FACILITY_NAME"));
				facility_buffer.append(facility_name+"##"+ facility);
				facility_buffer.append("~");
			}
					out.println(facility_buffer);

		}
		else if(func_mode.equalsIgnoreCase("populateOtherBaseLineChart")){	 //added by parul  for other facility chart CRF#0423
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_status = checkForNull(request.getParameter( "chart_status" )) ;
			String facility_id1 = checkForNull(request.getParameter( "facility_id" )) ;
			String sql				= "";		
			String chart_date = "";
			String chart_num = "";
			String clinical_group_code = "";
			String chart_type = "";
			StringBuffer date_type = new StringBuffer();			
			sql = "SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE, CHART_NUM, CHART_TYPE, CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID= ? AND PATIENT_ID = ? AND CHART_STATUS = ? ORDER BY CHART_NUM DESC";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facility_id1);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_status);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					// The below order should not be changed, as it is being used in the js file.
					chart_date = rst.getString("CHART_DATE");		//  1
					chart_num = rst.getString("CHART_NUM");		//  2
					clinical_group_code = rst.getString("CLINICAL_GROUP_CODE");		//  3
					chart_type = rst.getString("CHART_TYPE");		//  3
					// The below order should not be changed, as it is being used in the js file.
					date_type.append(chart_date+"##"+chart_num+"##"+clinical_group_code+"##"+chart_type); 
					date_type.append("~");
				}
				out.println(date_type);		
		}
		else if(func_mode.equalsIgnoreCase("checkGSRecorded")){	 //Added by Sridevi Joshi on 1/19/2010 for IN010939(SRR20056-CRF-0490). To check wether GS is recorded for the Chart 
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_level = checkForNull(request.getParameter( "chart_level" )) ;
			int GS_count = 0;
			
			if(chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT COUNT(*) GS_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y'");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					GS_count = Integer.parseInt(checkForNull(rst.getString("GS_COUNT")));		
				}
			}
			else{
				pstmt = con.prepareStatement("SELECT COUNT(*) GS_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y'");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					GS_count = Integer.parseInt(checkForNull(rst.getString("GS_COUNT")));		
				}
			}
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			out.println(GS_count);		
		}
		else if(func_mode.equalsIgnoreCase("checkPerioRecorded")){	 //Added by Sridevi Joshi on 1/19/2010 for IN010939(SRR20056-CRF-0490). To check wether Perio Chart is recorded
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_level = checkForNull(request.getParameter( "chart_level" )) ;
			int perio_count = 0;
			
			if(chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT COUNT(*) PERIO_COUNT FROM OH_PERIODONTAL_CHART_SUMMARY WHERE PATIENT_ID = ?");
				pstmt.setString(1,patient_id);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					perio_count = Integer.parseInt(checkForNull(rst.getString("PERIO_COUNT")));		
				}
			}
			else{
				pstmt = con.prepareStatement("SELECT COUNT(*) PERIO_COUNT FROM OH_PERIODONTAL_CHART_SUMMARY WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ?");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					perio_count = Integer.parseInt(checkForNull(rst.getString("PERIO_COUNT")));		
				}
			}
			out.println(perio_count);		
		}else if(func_mode.equalsIgnoreCase("CheckChartStatus")){		//added by parul on 25/05/2010 for IN022086
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String max_count="";
			String sql="" ;
			//sql = "SELECT COUNT(*) AS MAX_COUNT FROM OH_RESTORATIVE_CHART_DTL  WHERE PATIENT_ID =? AND CHART_NUM=? AND STATUS NOT IN ('CD','E')";
			sql = "SELECT COUNT(*) AS MAX_COUNT FROM OH_RESTORATIVE_CHART_DTL  WHERE PATIENT_ID =? AND CHART_NUM=? AND (STATUS <> 'E' AND STATUS <> (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60') OR STATUS IS NULL) AND TREATMENT_CONDITION = 'T'AND TREATMENT_INT_EXT = 'I'";
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			rst = pstmt.executeQuery();
			while(rst.next()){
				max_count =checkForNull(rst.getString("MAX_COUNT"));
			}
			out.println(max_count);
		}
		
		
		/*
		else if(func_mode.equalsIgnoreCase("populateMarkErrorConds")){	
			String chart_status = "";
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_numbering_system = checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String mixed_dentition_YN = checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String asondate = checkForNull(request.getParameter( "asondate" )) ;
			String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String sql				= "";		
			String date = "";
			String type = "";
			String PD_flag = "";
			String type_desc = "";
			//String site_type ="";
			String arch_desc = "";
			String quad_desc = "";
			String arch_quad = "";
			String condition_type = "";
			String deciduous_yn = "";
			String supernumerary_yn = "";
			String display_tooth_no = "";
			String cusp_tip_code = "";
			StringBuffer date_type = new StringBuffer();
			StringBuffer chart_dtls = new StringBuffer();
			String[] tooth_range_arr = null;
			
				sql = "SELECT TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.CUSP_TIP_CODE,A.CONDITION_TYPE,(SELECT CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW CTV WHERE CTV.LANGUAGE_ID = ? AND CTV.CONDITION_TYPE = A.CONDITION_TYPE) CONDITION_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM,C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE ,C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID=? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO,(SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID=? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO AND G.PERMANENT_DECIDUOUS=?) QUADRANT_DESC, A.SURFACE_CODE,A.CONDITION_TYPE, A.CONDITION_CODE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND C.CHART_STATUS = 'A' AND TRUNC(A.TREATMENT_CONDITION_DATE) <= TO_DATE(?,'DD/MM/YYYY') AND NVL(STATUS,'X') = 'E' ORDER BY CHART_LINE_NUM DESC";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale); // For OH_CONDITION_TYPE_LANG_VW
				pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
				pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
				pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
				pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
				pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
				pstmt.setString(7,permanent_deciduous_flag); // For OH_QUADRANT_LANG_VW
				pstmt.setString(8,facility_id);
				pstmt.setString(9,patient_id);
				pstmt.setString(10,asondate);
				
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					chart_dtls.setLength(0);
					// The below order should not be changed, as it is being used in the js file.
					type_desc = rst.getString("CONDITION_TYPE_DESC");		//  1
					date = rst.getString("TREATMENT_CONDITION_DATE");		//  2
					arch_desc = rst.getString("ARCH_DESC");		//  3
					quad_desc = rst.getString("QUADRANT_DESC");		//  4
					condition_type = rst.getString("CONDITION_TYPE");
					deciduous_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
					supernumerary_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
					cusp_tip_code = checkForNull(rst.getString("CUSP_TIP_CODE"));
					//tooth_no = rst.getString("TOOTH_NO");
					//type = rst.getString("CONDITION_TREATMENT_TYPE");
					// The below order should not be changed, as it is being used in the js file.
					chart_dtls.append(rst.getString("CHART_NUM")+":");		//  5
					chart_dtls.append(rst.getString("CHART_LINE_NUM")+":"); //  6
					chart_dtls.append(rst.getString("CHART_STATUS")+":");	//  7
					chart_dtls.append(rst.getString("CHART_DATE")+":");		//  8
					chart_dtls.append(rst.getString("SITE_TYPE")+":");		//  9
					chart_dtls.append(rst.getString("TOOTH_NO")+":");		//  10
					chart_dtls.append(rst.getString("NS_TOOTH_NO")+":");	//  11
					chart_dtls.append(rst.getString("ARCH_SNO")+":");		// 12
					chart_dtls.append(rst.getString("QUADRANT_SNO")+":");	// 13
					chart_dtls.append(rst.getString("SURFACE_CODE")+":");	// 14
					chart_dtls.append(rst.getString("CONDITION_TYPE")+":");	// 15
					chart_dtls.append(rst.getString("CONDITION_CODE")+":");		// 15
					chart_dtls.append(rst.getString("TOOTH_RANGE")+":");		// 16 added by Sridevi Joshi
					
					String thrang_ref = "";
					String thrng_nos = checkForNull(rst.getString("TOOTH_RANGE"));
					if(!thrng_nos.equals(null) && !thrng_nos.equals("") && thrng_nos.indexOf(",") != -1){
						tooth_range_arr = thrng_nos.split(",");
						String[] temp_arr = null;
						
						//2$$5,3$$6
						String str="";
						int ind = 0;
						int z=0;
						for(int i=0;i<tooth_range_arr.length;i++){
							str = tooth_range_arr[i];
							ind = str.indexOf("$$");
							str = str.substring(ind+2,str.length());
							pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM=? AND TOOTH_NO=?");
							pstmt1.setString(1,tooth_numbering_system);
							pstmt1.setString(2,str);
							rst1 = pstmt1.executeQuery();
							
							while(rst1!= null && rst1.next()){
								if(z==0){
									thrang_ref = rst1.getString("NS_TOOTH_NO");
								}
								else{
									thrang_ref = thrang_ref+","+rst1.getString("NS_TOOTH_NO");
								}
								z++;
							}
						}
					}
					chart_dtls.append(thrang_ref+":"); // 17 added by Sridevi Joshi
					chart_dtls.append(rst.getString("CLINICAL_GROUP_CODE"));		// 18 added by Sridevi Joshi
					if(rst.getString("SITE_TYPE").equals("ARCH")){
						arch_quad = arch_desc;
					}
					else if(rst.getString("SITE_TYPE").equals("QUAD")){
						arch_quad = quad_desc;
					}

					if(deciduous_yn.equals("D") || deciduous_yn.equals("R")){
						if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
							PD_flag = "P";
						}
						else{
							PD_flag = "D";
						}
						pstmt1 = con.prepareStatement("SELECT A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							pstmt1.setString(1,tooth_numbering_system);
							pstmt1.setString(2,rst.getString("TOOTH_NO"));
							pstmt1.setString(3,PD_flag);
							rst1 = pstmt1.executeQuery();
							while(rst1!= null && rst1.next()){
								display_tooth_no = rst1.getString("NS_TOOTH_NO");
							}
					}
					
					date_type.append(date+"##"+type_desc+"##"+rst.getString("NS_TOOTH_NO")+"##"+chart_dtls+"##"+arch_quad+"##"+display_tooth_no+"##"+deciduous_yn+"##"+supernumerary_yn+"##"+cusp_tip_code); 
					date_type.append("~");
				}
				
				out.println(date_type);
		}*/
	}catch(Exception e){
		System.err.println("Err Msg from ChartViewValidation.jsp "+e);
		System.err.println("func_mode== "+func_mode);
	}
	finally{
		if(rst!=null) rst.close();
		if(rst1!=null) rst1.close();
		if(rst2!=null) rst2.close();
		if(pstmt!=null)pstmt.close();
		if(pstmt1!=null)pstmt1.close();
		if(pstmt2!=null)pstmt2.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>

	
