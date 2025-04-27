<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,eOH.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
        String locale = (String)session.getAttribute("LOCALE"); 
		String facility_id = (String)session.getValue("facility_id") ;

		String patient_id = checkForNull(request.getParameter("patient_id"));
		String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
		String site_type_param = checkForNull(request.getParameter("site_type"));
		String area_param = checkForNull(request.getParameter("area_param"));
		String thrng_nos_ref = checkForNull(request.getParameter("thrng_nos_ref"));

		String trmt_chart_num = checkForNull(request.getParameter("chart_num"));
		String trmt_chart_line_num = checkForNull(request.getParameter("chart_line_num"));
	    String term_code = checkForNull(request.getParameter("term_code"));
	    String term_set_id = checkForNull(request.getParameter("term_set_id"));
	    String occur_srl_no = checkForNull(request.getParameter("occur_srl_no"));
	    String diag_status = checkForNull(request.getParameter("diag_status"));
	    String mode = checkForNull(request.getParameter("mode"));
	    String trmt_code = checkForNull(request.getParameter("trmt_code"));
		String status_disabled =  checkForNull(request.getParameter("status_disabled"));
		String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
		String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
		String baseline_chart_yn = checkForNull(request.getParameter("baseline_chart_yn"));//Added by Sridevi Joshi on 5/31/2010 for IN021668		
		String date_diff_flag = checkForNull(request.getParameter("date_diff_flag"));//Added by Sridevi Joshi on 5/31/2010 for IN021668		

		if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
			other_chart_facility_id=facility_id;
		}
		if(!other_chart_facility_id.equals(facility_id) || baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/31/2010 for IN021668		
			status_disabled = "disabled";	
		}

		String site_type = "";
		String area = "";
		String area_desc = "";
		String surface_code = "";
		String surface_desc = "";
	    String condition_type = "";
		String condition_code = "";
		String condition_desc = "";
		String site_type_desc = "";
		int row_count = 0;
		String classValue = "";
		String close_disabled = "";
		String link_already_exists_yn = "N";
		String chk_yn = "";
		String cond_closed_yn = "";
		String close_disabled_yn = "";
		String select_disabled_yn = "";
		String chk_closed_yn = "";
		String [] thrng_nos_ref_arr = null;
		
%>

<html>
	<head>
        <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eOH/js/RecordDiagForTrmt.js'></script>
		<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</head>
<%
	try{
			con=ConnectionManager.getConnection(request);
%>
  <body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
  <form name="OHDiagLinkedConditions" id="OHDiagLinkedConditions"   method="post" target="messageFrame">
      <table align='center' cellpadding='3' cellspacing='0' border='1' width='100%'>
             <%
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			   
				//pstmt=con.prepareStatement("SELECT A.CONDITION_TYPE, A.CONDITION_CODE, A.ARCH_SNO, A.QUADRANT_SNO, A.TOOTH_NO REF_TOOTH_NO, A.SURFACE_CODE, A.CHART_NUM, A.CHART_LINE_NUM, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC,(SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC,(SELECT 'Y' FROM OH_RESTORATIVE_CHART_DIAG_COND L WHERE L.PATIENT_ID = A.PATIENT_ID AND L.TERM_SET_ID = E.TERM_SET_ID AND L.TERM_CODE = E.TERM_CODE AND L.COND_CHART_NUM = A.CHART_NUM  AND L.COND_CHART_LINE_NUM = A.CHART_LINE_NUM AND L.CONDITION_CODE = A.CONDITION_CODE) LINK_ALREADY_EXISTS_YN,(SELECT COND_CLOSED_YN FROM OH_RESTORATIVE_CHART_DIAG_COND L WHERE L.PATIENT_ID = A.PATIENT_ID AND L.TERM_SET_ID = E.TERM_SET_ID AND L.TERM_CODE = E.TERM_CODE AND L.COND_CHART_NUM = A.CHART_NUM  AND L.COND_CHART_LINE_NUM = A.CHART_LINE_NUM AND L.CONDITION_CODE = A.CONDITION_CODE) COND_CLOSED_YN FROM OH_RESTORATIVE_CHART_DTL A,  OH_DIAG_COND_LINK E WHERE A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.CHART_LINE_NUM = E.CHART_LINE_NUM AND A.CONDITION_CODE = E.CONDITION_CODE AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TREATMENT_CONDITION = 'C' AND  NVL(A.STATUS,'X')!='E' AND E.TERM_CODE = ? ORDER BY A.CONDITION_TYPE");
				if(oh_chart_level.equals("E")){
					pstmt=con.prepareStatement("SELECT A.CONDITION_TYPE, A.CONDITION_CODE, A.ARCH_SNO, A.QUADRANT_SNO, A.TOOTH_NO REF_TOOTH_NO,A.SURFACE_CODE, A.CHART_NUM, A.CHART_LINE_NUM, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC, 'Y' LINK_ALREADY_EXISTS_YN, L.COND_CLOSED_YN FROM OH_DIAG_COND_LINK E, OH_RESTORATIVE_CHART_DTL A,  OH_RESTORATIVE_CHART_DIAG_COND L WHERE E.PATIENT_ID = ? AND E.TERM_SET_ID = ? AND E.TERM_CODE = ? AND E.OCCUR_SRL_NO= ? AND A.PATIENT_ID= E.PATIENT_ID AND A.CHART_NUM  = E.CHART_NUM AND A.CHART_LINE_NUM = E.CHART_LINE_NUM AND A.CHART_NUM  = ? AND A.TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE  = E.CONDITION_CODE  AND NVL(A.STATUS,'X') <>'E' AND L.PATIENT_ID = E.PATIENT_ID AND L.TERM_SET_ID = E.TERM_SET_ID AND L.TERM_CODE = E.TERM_CODE AND L.OCCUR_SRL_NO = E.OCCUR_SRL_NO AND L.COND_CHART_NUM = E.CHART_NUM  AND L.COND_CHART_LINE_NUM = E.CHART_LINE_NUM AND L.CONDITION_CODE = E.CONDITION_CODE AND L.TRMT_CHART_NUM = ? AND L.TRMT_CHART_LINE_NUM = ? AND L.TRMT_CODE = ? UNION SELECT A.CONDITION_TYPE,  A.CONDITION_CODE, A.ARCH_SNO, A.QUADRANT_SNO, A.TOOTH_NO REF_TOOTH_NO, A.SURFACE_CODE, A.CHART_NUM, A.CHART_LINE_NUM, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC, 'N' LINK_ALREADY_EXISTS_YN, 'N' COND_CLOSED_YN FROM OH_DIAG_COND_LINK E, OH_RESTORATIVE_CHART_DTL A WHERE E.PATIENT_ID  = ? AND E.TERM_SET_ID = ? AND E.TERM_CODE = ? AND E.OCCUR_SRL_NO = ?  AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.CHART_LINE_NUM = E.CHART_LINE_NUM AND A.CHART_NUM = ? AND A.TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE = E.CONDITION_CODE  AND NVL(A.STATUS,'X') <>'E' AND (E.PATIENT_ID, E.TERM_SET_ID, E.TERM_CODE, E.OCCUR_SRL_NO, E.CHART_NUM, E.CHART_LINE_NUM, E.CONDITION_CODE) NOT IN (SELECT PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, COND_CHART_NUM, COND_CHART_LINE_NUM, CONDITION_CODE FROM OH_RESTORATIVE_CHART_DIAG_COND L WHERE  L.PATIENT_ID  = E.PATIENT_ID AND L.TERM_SET_ID = E.TERM_SET_ID AND L.TERM_CODE  = E.TERM_CODE AND L.OCCUR_SRL_NO  = E.OCCUR_SRL_NO AND L.COND_CHART_NUM  = E.CHART_NUM AND L.COND_CHART_LINE_NUM= E.CHART_LINE_NUM AND L.CONDITION_CODE = E.CONDITION_CODE) ORDER BY CONDITION_TYPE");

					pstmt.setString(1,locale);//LANGUAGE_ID
					pstmt.setString(2,locale);//LANGUAGE_ID
					pstmt.setString(3,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(4,locale);//LANGUAGE_ID
					pstmt.setString(5,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(6,locale);//LANGUAGE_ID
					pstmt.setString(7,tooth_numbering_system);//LANGUAGE_ID
					pstmt.setString(8,locale);//LANGUAGE_ID
					pstmt.setString(9,locale);//LANGUAGE_ID
					pstmt.setString(10,patient_id);//PATIENT_ID
					pstmt.setString(11,term_set_id);//PATIENT_ID
					pstmt.setString(12,term_code);//CHART_NUM
					pstmt.setString(13,occur_srl_no);//CHART_NUM
					//pstmt.setString(14,facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(14,trmt_chart_num);//OPERATING_FACILITY_ID
					//pstmt.setString(15,facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(15,trmt_chart_num);//CHART_NUM
					pstmt.setString(16,trmt_chart_line_num);//CHART_NUM
					pstmt.setString(17,trmt_code);//CHART_NUM

					pstmt.setString(18,locale);//LANGUAGE_ID
					pstmt.setString(19,locale);//LANGUAGE_ID
					pstmt.setString(20,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(21,locale);//LANGUAGE_ID
					pstmt.setString(22,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(23,locale);//LANGUAGE_ID
					pstmt.setString(24,tooth_numbering_system);//LANGUAGE_ID
					pstmt.setString(25,locale);//LANGUAGE_ID
					pstmt.setString(26,locale);//LANGUAGE_ID
					pstmt.setString(27,patient_id);//PATIENT_ID
					pstmt.setString(28,term_set_id);//PATIENT_ID
					pstmt.setString(29,term_code);//CHART_NUM
					pstmt.setString(30,occur_srl_no);//CHART_NUM
				//	pstmt.setString(32,facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(31,trmt_chart_num);//OPERATING_FACILITY_ID
					
					rs=pstmt.executeQuery();
				
				}else{
					pstmt=con.prepareStatement("SELECT A.CONDITION_TYPE, A.CONDITION_CODE, A.ARCH_SNO, A.QUADRANT_SNO, A.TOOTH_NO REF_TOOTH_NO,A.SURFACE_CODE, A.CHART_NUM, A.CHART_LINE_NUM, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC, 'Y' LINK_ALREADY_EXISTS_YN, L.COND_CLOSED_YN FROM OH_DIAG_COND_LINK E, OH_RESTORATIVE_CHART_DTL A,  OH_RESTORATIVE_CHART_DIAG_COND L WHERE E.PATIENT_ID = ? AND E.TERM_SET_ID = ? AND E.TERM_CODE = ? AND E.OCCUR_SRL_NO= ? AND A.OPERATING_FACILITY_ID= ? AND A.PATIENT_ID= E.PATIENT_ID AND A.CHART_NUM  = E.CHART_NUM AND A.CHART_LINE_NUM = E.CHART_LINE_NUM AND A.CHART_NUM  = ? AND A.TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE  = E.CONDITION_CODE  AND NVL(A.STATUS,'X') <>'E' AND L.PATIENT_ID = E.PATIENT_ID AND L.TERM_SET_ID = E.TERM_SET_ID AND L.TERM_CODE = E.TERM_CODE AND L.OCCUR_SRL_NO = E.OCCUR_SRL_NO AND L.COND_CHART_NUM = E.CHART_NUM  AND L.COND_CHART_LINE_NUM = E.CHART_LINE_NUM AND L.CONDITION_CODE = E.CONDITION_CODE AND L.TRMT_CHART_NUM = ? AND L.TRMT_CHART_LINE_NUM = ? AND L.TRMT_CODE = ? UNION SELECT A.CONDITION_TYPE,  A.CONDITION_CODE, A.ARCH_SNO, A.QUADRANT_SNO, A.TOOTH_NO REF_TOOTH_NO, A.SURFACE_CODE, A.CHART_NUM, A.CHART_LINE_NUM, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC, 'N' LINK_ALREADY_EXISTS_YN, 'N' COND_CLOSED_YN FROM OH_DIAG_COND_LINK E, OH_RESTORATIVE_CHART_DTL A WHERE E.PATIENT_ID  = ? AND E.TERM_SET_ID = ? AND E.TERM_CODE = ? AND E.OCCUR_SRL_NO = ? AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.CHART_LINE_NUM = E.CHART_LINE_NUM AND A.CHART_NUM = ? AND A.TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE = E.CONDITION_CODE  AND NVL(A.STATUS,'X') <>'E' AND (E.PATIENT_ID, E.TERM_SET_ID, E.TERM_CODE, E.OCCUR_SRL_NO, E.CHART_NUM, E.CHART_LINE_NUM, E.CONDITION_CODE) NOT IN (SELECT PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, COND_CHART_NUM, COND_CHART_LINE_NUM, CONDITION_CODE FROM OH_RESTORATIVE_CHART_DIAG_COND L WHERE  L.PATIENT_ID  = E.PATIENT_ID AND L.TERM_SET_ID = E.TERM_SET_ID AND L.TERM_CODE  = E.TERM_CODE AND L.OCCUR_SRL_NO  = E.OCCUR_SRL_NO AND L.COND_CHART_NUM  = E.CHART_NUM AND L.COND_CHART_LINE_NUM= E.CHART_LINE_NUM AND L.CONDITION_CODE = E.CONDITION_CODE) ORDER BY CONDITION_TYPE");

					pstmt.setString(1,locale);//LANGUAGE_ID
					pstmt.setString(2,locale);//LANGUAGE_ID
					pstmt.setString(3,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(4,locale);//LANGUAGE_ID
					pstmt.setString(5,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(6,locale);//LANGUAGE_ID
					pstmt.setString(7,tooth_numbering_system);//LANGUAGE_ID
					pstmt.setString(8,locale);//LANGUAGE_ID
					pstmt.setString(9,locale);//LANGUAGE_ID
					pstmt.setString(10,patient_id);//PATIENT_ID
					pstmt.setString(11,term_set_id);//PATIENT_ID
					pstmt.setString(12,term_code);//CHART_NUM
					pstmt.setString(13,occur_srl_no);//CHART_NUM
					//pstmt.setString(14,facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(14,other_chart_facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(15,trmt_chart_num);//OPERATING_FACILITY_ID
					//pstmt.setString(15,facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(16,trmt_chart_num);//CHART_NUM
					pstmt.setString(17,trmt_chart_line_num);//CHART_NUM
					pstmt.setString(18,trmt_code);//CHART_NUM

					pstmt.setString(19,locale);//LANGUAGE_ID
					pstmt.setString(20,locale);//LANGUAGE_ID
					pstmt.setString(21,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(22,locale);//LANGUAGE_ID
					pstmt.setString(23,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(24,locale);//LANGUAGE_ID
					pstmt.setString(25,tooth_numbering_system);//LANGUAGE_ID
					pstmt.setString(26,locale);//LANGUAGE_ID
					pstmt.setString(27,locale);//LANGUAGE_ID
					pstmt.setString(28,patient_id);//PATIENT_ID
					pstmt.setString(29,term_set_id);//PATIENT_ID
					pstmt.setString(30,term_code);//CHART_NUM
					pstmt.setString(31,occur_srl_no);//CHART_NUM
				//	pstmt.setString(32,facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(32,other_chart_facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(33,trmt_chart_num);//OPERATING_FACILITY_ID
					
					rs=pstmt.executeQuery();
			}
				boolean found_flag = false;
				int m=0;
			
				while(rs.next()){
					row_count++;
					condition_type = checkForNull(rs.getString("CONDITION_TYPE"));
					condition_code = checkForNull(rs.getString("CONDITION_CODE"));
					condition_desc = checkForNull(rs.getString("CONDITION_DESC"));
					site_type_desc = checkForNull(rs.getString("SITE_TYPE_DESC"));
					site_type = checkForNull(rs.getString("SITE_TYPE"));
					link_already_exists_yn = checkForNull(rs.getString("LINK_ALREADY_EXISTS_YN"));
					cond_closed_yn = checkForNull(rs.getString("COND_CLOSED_YN"));
					
					if(link_already_exists_yn.equals("Y")){
						chk_yn = "checked";
						close_disabled_yn = "";
					}
					else{
						chk_yn = "";
						close_disabled_yn = "disabled";
					}

					if(cond_closed_yn.equals("Y")){
						chk_closed_yn = "checked";
						close_disabled_yn = "disabled";
						select_disabled_yn = "disabled";
					}
					else{
						chk_closed_yn = "";
						select_disabled_yn = "";
						//close_disabled_yn = "";
					}

					if(site_type.equals("ARCH")){
						area_desc = checkForNull(rs.getString("ARCH_DESC"));
						area = checkForNull(rs.getString("ARCH_SNO"));
					}
					else if(site_type.equals("QUAD")){
						area_desc = checkForNull(rs.getString("QUADRANT_DESC"));
						area = checkForNull(rs.getString("QUADRANT_SNO"));
					}
					else{
						area_desc = checkForNull(rs.getString("TOOTH_NO"));
						area = checkForNull(rs.getString("REF_TOOTH_NO"));
					}

					surface_desc = checkForNull(rs.getString("SURFACE_NAME"));
					surface_code = checkForNull(rs.getString("SURFACE_CODE"));

					if ( row_count % 2 == 0 ){
						classValue = "QRYEVEN" ;
					}else{
						classValue = "QRYODD" ;
					}
				%>

					<tr>
						<td width="15%" align='left' class="<%=classValue%>"><%=checkForNull(rs.getString("CONDITION_TYPE_DESC"))%></td>
						<td width="15%" align='left' class="<%=classValue%>"><%=condition_desc%></td>
						<td width="15%" align='left' class="<%=classValue%>"><%=site_type_desc%></td>
						<td width="15%" align='left' class="<%=classValue%>"><%=area_desc%></td>
						<%
							if(surface_desc.equals("")){
						%>
								<td width="15%" align='left' class="<%=classValue%>">&nbsp;</td>
						<%
							}else{
						%>
								<td width="15%" align='left' class="<%=classValue%>"><%=surface_desc%></td>
						<%
							}

							if(!site_type_param.equals(site_type)){
								if(site_type_param.equals("THRNG") && site_type.equals("TOOTH")){
									if(thrng_nos_ref.indexOf(",") != -1){
										thrng_nos_ref_arr = thrng_nos_ref.split(",");
										m=0;
										close_disabled = "disabled";
										found_flag = false;
										
										while(m<thrng_nos_ref_arr.length && found_flag == false){
											if(thrng_nos_ref_arr[m].equals(area)){
												close_disabled = "";
												found_flag = true;
												
											}
											m++;
										}
									}
									
								}
								else{
									close_disabled = "disabled";
								}
							}
							else{
								if(area_param.equals(area)){
									close_disabled = "";
								}
								else{
									close_disabled = "disabled";
								}
							}
						%>
						<td width="15%" align='left' class="<%=classValue%>"><input type='checkbox' name='chk_select<%=row_count%>' id='chk_select<%=row_count%>' cond_chart_num = '<%=checkForNull(rs.getString("CHART_NUM"))%>' cond_chart_line_num = '<%=checkForNull(rs.getString("CHART_LINE_NUM"))%>' cond_code = '<%=condition_code%>'  onclick="validateCheckBox(this,'<%=close_disabled%>','<%=row_count%>','<%=mode%>');" <%=chk_yn%> <%=select_disabled_yn%> <%=status_disabled%>></td>
						<td width="15%" align='left' class="<%=classValue%>"><input type='checkbox' name='close_cond<%=row_count%>' id='close_cond<%=row_count%>' cond_chart_num = '<%=checkForNull(rs.getString("CHART_NUM"))%>' cond_chart_line_num = '<%=checkForNull(rs.getString("CHART_LINE_NUM"))%>' cond_code = '<%=condition_code%>' onclick="validateCloseCondCheckBox(this,'<%=mode%>');" <%=chk_closed_yn%> <%=close_disabled%> <%=close_disabled_yn%>></td>

						<input type='hidden' name='condition_type_<%=row_count%>' id='condition_type_<%=row_count%>' value='<%=condition_type%>'>
						<input type='hidden' name='condition_code_<%=row_count%>' id='condition_code_<%=row_count%>' value='<%=condition_code%>'>
						<input type='hidden' name='site_type_<%=row_count%>' id='site_type_<%=row_count%>' value='<%=site_type%>'>
						<input type='hidden' name='area_<%=row_count%>' id='area_<%=row_count%>' value='<%=area%>'>
						<input type='hidden' name='surface_code_<%=row_count%>' id='surface_code_<%=row_count%>' value='<%=surface_code%>'>
						<input type='hidden' name='link_already_exists_yn<%=row_count%>' id='link_already_exists_yn<%=row_count%>' value='<%=link_already_exists_yn%>'>
					</tr>
			<%
				}
			%>
			</table>
			<input type='hidden' name='trmt_code' id='trmt_code' value='<%=trmt_code%>'>
			<input type='hidden' name='trmt_chart_line_num' id='trmt_chart_line_num' value='<%=trmt_chart_line_num%>'>
			<input type='hidden' name='trmt_chart_num' id='trmt_chart_num' value='<%=trmt_chart_num%>'>
			<input type='hidden' name='term_code' id='term_code' value='<%=term_code%>'>
			<input type='hidden' name='term_set_id' id='term_set_id' value='<%=term_set_id%>'>
			<input type='hidden' name='occur_srl_no' id='occur_srl_no' value='<%=occur_srl_no%>'>
			<input type='hidden' name='diag_status' id='diag_status' value='<%=diag_status%>'>
			<input type='hidden' name='row_count' id='row_count' value='<%=row_count%>'>
            
		</form>
 </body> </html>

<%
   }catch ( Exception e ) {
	           e.printStackTrace() ;
    }finally {
	        try{
		         if(rs!=null) rs.close();
		         if(pstmt!=null) pstmt.close();
		          if(con!=null) 
			            ConnectionManager.returnConnection(con,request);
	                 }catch(Exception es){es.printStackTrace();}
      }
 %>

