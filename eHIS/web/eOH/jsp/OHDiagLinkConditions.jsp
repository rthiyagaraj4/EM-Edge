<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,java.util.*,eOH.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	Connection con=null;
	PreparedStatement pstmt_date=null;
	PreparedStatement pstmt=null;
	ResultSet rs_date=null;
	ResultSet rs=null;

	String facility_id = "";
	String encounter_id = "";
	String chart_num = "";
	String link_already_exists_yn = "N";
	String link_disable = "";

	String locale = (String)session.getAttribute("LOCALE"); 
	String login_user = (String)session.getAttribute("login_user"); 

	String patient_id = checkForNull(request.getParameter("patient_id"));
	String term_set_id = checkForNull(request.getParameter("term_set_id"));
	String term_code = checkForNull(request.getParameter("term_code"));
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String accession_num = checkForNull(request.getParameter("accession_num"));
	RecordSet OHDiagLinkConditionOBJ	=	(webbeans.eCommon.RecordSet)session.getAttribute("OHDiagLinkConditionOBJ");
	
	StringTokenizer accession_num_token = new StringTokenizer(accession_num,"||");
	while(accession_num_token.hasMoreTokens()){
		facility_id		=accession_num_token.nextToken();
		encounter_id	=accession_num_token.nextToken();
		chart_num	=accession_num_token.nextToken();
	}
	
	String site_type = "";
	String area = "";
	String surface_code = "";
	String surface_desc = "";
	String condition_type = "";
	String chart_line_num = "";
	String condition_code = "";
	String chart_number	  = "";
	String code			  = "";
	int record_count = 0;
	int row_count = 0;
	String classValue = "";
	String chkAttribute = "";
	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	String oh_chart_level = "";
	//



	try{
		con=ConnectionManager.getConnection(request);

		if(tooth_numbering_system.equals("")){
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			pstmt=con.prepareStatement("SELECT PREF_NUMBERING_SYSTEM FROM OH_USER_PREFERENCES WHERE APPL_USER_ID = ?");
			pstmt.setString(1,login_user);
			rs=pstmt.executeQuery();
			while(rs.next()){
				tooth_numbering_system = checkForNull(rs.getString("PREF_NUMBERING_SYSTEM"));
			}
		}

		if(tooth_numbering_system.equals("")){
			//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()){
				oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(oh_chart_level.equals("E")){
			   pstmt=con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM");
			}else{//End
			   pstmt=con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
				pstmt.setString(1,facility_id);
			}
			rs=pstmt.executeQuery();
			while(rs.next()){
				tooth_numbering_system = checkForNull(rs.getString("TOOTH_NUMBERING_SYSTEM"));
			}
		}

	%>
		<html>
			<head>
				<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
				<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
				<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
				<script src="../../eCommon/js/common.js" language="javascript"></script>
				<script src="../../eOH/js/OHDiagLinkConditions.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			</head>
			<body onload='checkAllRecord()' OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
				<form name='oh_diag_link_condition' id='oh_diag_link_condition' action='../../eOH/jsp/OHDiagLinkConditionsValidation.jsp' method='post' >

					<table align='center' cellpadding='3' cellspacing='0' border='1' width='100%'>
						
						<%
		
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
						
							//pstmt=con.prepareStatement("SELECT A.CHART_NUM,A.CHART_LINE_NUM, A.CONDITION_TYPE, A.CONDITION_CODE, A.SURFACE_CODE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, A.TREATMENT_CONDITION_DATE,  B.CONDITION_DESC, (SELECT 'Y' FROM OH_DIAG_COND_LINK L WHERE L.PATIENT_ID = A.PATIENT_ID AND L.TERM_SET_ID=? AND L.TERM_CODE=? AND L.CHART_NUM=A.CHART_NUM AND L.CHART_LINE_NUM=A.CHART_LINE_NUM) LINK_ALREADY_EXISTS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_CONDITION_LANG_VW B WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE IS NOT NULL AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ? AND NVL(A.STATUS,'X') <> 'E' AND NVL(COND_CLOSED_YN,'N') = 'N' ORDER BY A.CONDITION_TYPE");

							//pstmt=con.prepareStatement("SELECT A.CHART_NUM,A.CHART_LINE_NUM, A.CONDITION_TYPE, A.CONDITION_CODE, A.SURFACE_CODE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1')  QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, A.TREATMENT_CONDITION_DATE,  B.CONDITION_DESC, 'N' LINK_ALREADY_EXISTS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_CONDITION_LANG_VW B WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM  in (select chart_num from OH_RESTORATIVE_CHART_HDR where OPERATING_FACILITY_ID = ? and patient_id = ? and CHART_STATUS = 'A') AND TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE IS NOT NULL AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ? AND NVL(A.STATUS,'X') <> 'E' AND (A.CHART_NUM, A.CHART_LINE_NUM, A.CONDITION_CODE) NOT IN (SELECT CHART_NUM, CHART_LINE_NUM, CONDITION_CODE FROM OH_DIAG_COND_LINK WHERE PATIENT_ID = ?) UNION SELECT A.CHART_NUM,A.CHART_LINE_NUM, A.CONDITION_TYPE, A.CONDITION_CODE, A.SURFACE_CODE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, A.TREATMENT_CONDITION_DATE,  B.CONDITION_DESC, 'Y' LINK_ALREADY_EXISTS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_CONDITION_LANG_VW B, OH_DIAG_COND_LINK L WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID= ? AND L.PATIENT_ID = A.PATIENT_ID AND L.TERM_SET_ID= ? AND L.TERM_CODE = ? AND L.OCCUR_SRL_NO = 1 AND L.CHART_NUM = A.CHART_NUM AND L.CHART_LINE_NUM = A.CHART_LINE_NUM AND A.TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE IS NOT NULL AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ? AND NVL(A.STATUS,'X') <> 'E' ORDER BY CONDITION_TYPE ");
							pstmt=con.prepareStatement("SELECT A.CHART_NUM,A.CHART_LINE_NUM, A.CONDITION_TYPE, A.CONDITION_CODE, A.SURFACE_CODE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1')  QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, A.TREATMENT_CONDITION_DATE,  B.CONDITION_DESC, 'N' LINK_ALREADY_EXISTS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_CONDITION_LANG_VW B WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM  in (select chart_num from OH_RESTORATIVE_CHART_HDR where OPERATING_FACILITY_ID = ? and patient_id = ? and CHART_STATUS = 'A') AND TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE IS NOT NULL AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ? AND NVL(A.STATUS,'X') <> 'E' AND (A.CHART_NUM, A.CHART_LINE_NUM, A.CONDITION_CODE) NOT IN (SELECT CHART_NUM, CHART_LINE_NUM, CONDITION_CODE FROM OH_DIAG_COND_LINK WHERE PATIENT_ID = ?) UNION SELECT A.CHART_NUM,A.CHART_LINE_NUM, A.CONDITION_TYPE, A.CONDITION_CODE, A.SURFACE_CODE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, A.TREATMENT_CONDITION_DATE,  B.CONDITION_DESC, 'Y' LINK_ALREADY_EXISTS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_CONDITION_LANG_VW B, OH_DIAG_COND_LINK L WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID= ? AND L.PATIENT_ID = A.PATIENT_ID AND L.TERM_SET_ID= ? AND L.TERM_CODE = ? AND L.CHART_NUM = A.CHART_NUM AND L.CHART_LINE_NUM = A.CHART_LINE_NUM AND A.TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE IS NOT NULL AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ? AND NVL(A.STATUS,'X') <> 'E' ORDER BY CONDITION_TYPE ");
							
							//IN THE ABOVE QUERY ROWNUM = 1 IS TAKEN INSTEAD OF PERMANENT_DECIDUOUS FOR QUADRANT_DESC....THIS IS BCOZ QUANDRANT_SNO IS SAME FOR BOTH PERMANENT AND DECIDUOUS CONDITIONS..SINCE WE ARE CONSIDERING ONLY DESC WE CAN USE THIS CONDITION....
							pstmt.setString(1,locale);
							pstmt.setString(2,locale);
							pstmt.setString(3,tooth_numbering_system);
							pstmt.setString(4,locale);
							pstmt.setString(5,tooth_numbering_system);
							pstmt.setString(6,locale);
							pstmt.setString(7,tooth_numbering_system);
							pstmt.setString(8,locale);
							pstmt.setString(9,facility_id);
							pstmt.setString(10,patient_id);
							pstmt.setString(11,facility_id);
							pstmt.setString(12,patient_id);
							pstmt.setString(13,locale);
							pstmt.setString(14,patient_id);

							pstmt.setString(15,locale);
							pstmt.setString(16,locale);
							pstmt.setString(17,tooth_numbering_system);
							pstmt.setString(18,locale);
							pstmt.setString(19,tooth_numbering_system);
							pstmt.setString(20,locale);
							pstmt.setString(21,tooth_numbering_system);
							pstmt.setString(22,locale);
							pstmt.setString(23,facility_id);
							pstmt.setString(24,patient_id);
							pstmt.setString(25,term_set_id);
							pstmt.setString(26,term_code);
							pstmt.setString(27,locale);
							
							rs=pstmt.executeQuery();
							record_count = 0;
							while(rs.next()){
								
								record_count++;
								row_count++;
								condition_type = checkForNull(rs.getString("CONDITION_TYPE"));
								chart_number = checkForNull(rs.getString("CHART_NUM"));
								chart_line_num = checkForNull(rs.getString("CHART_LINE_NUM"));
								condition_code = checkForNull(rs.getString("CONDITION_CODE"));
								surface_code = checkForNull(rs.getString("SURFACE_CODE"));
								site_type = checkForNull(rs.getString("SITE_TYPE"));
								
								if(site_type.equals("ARCH")){
									area = checkForNull(rs.getString("ARCH_DESC"));
								}
								else if(site_type.equals("QUAD")){
									area = checkForNull(rs.getString("QUADRANT_DESC"));
								}
								else{
									area = checkForNull(rs.getString("TOOTH_NO"));
								}
								
								surface_desc = checkForNull(rs.getString("SURFACE_NAME"));

								code = chart_number + "||" +chart_line_num+ "||"+ condition_code;

								link_already_exists_yn = checkForNull(rs.getString("LINK_ALREADY_EXISTS_YN"),"N");

								link_disable="";
								if(link_already_exists_yn.equals("Y")){
									chkAttribute="CHECKED";
									link_disable="disabled";
								}else{
									if(OHDiagLinkConditionOBJ!=null && OHDiagLinkConditionOBJ.containsObject(code)) 
									{
										chkAttribute = "CHECKED";							
									}
									else
									{
										chkAttribute="";							
									}
								}

								if ( row_count % 2 == 0 )
                                         classValue = "QRYEVEN" ;
								else
				                    	classValue = "QRYODD" ;
								
						%>
								<tr>
									<td width="15%" align='left' class="<%=classValue%>"><%=checkForNull(rs.getString("CONDITION_TYPE_DESC"))%></td>
									<td width="15%" align='left' class="<%=classValue%>"><%=checkForNull(rs.getString("CONDITION_DESC"))%></td>
									<td width="15%" align='left' class="<%=classValue%>"><%=checkForNull(rs.getString("SITE_TYPE_DESC"))%></td>
									<td width="15%" align='left' class="<%=classValue%>"><%=area%></td>
									<%
										if(surface_code.equals("")){
									%>
											<td width="15%" align='left' class="<%=classValue%>">&nbsp;</td>
									<%
										}else{
									%>
											<td width="15%" align='left' class="<%=classValue%>"><%=surface_desc%></td>
									<%
										}
									%>
									<td width="15%" align='left' class="<%=classValue%>">
										<input type='checkbox' name='link_condition_<%=record_count%>' id='link_condition_<%=record_count%>' <%=chkAttribute%> <%=link_disable%>>
										<input type='hidden' name='link_code_chk<%=record_count%>' id='link_code_chk<%=record_count%>' value="N">
										<input type='hidden' name='link_code<%=record_count%>' id='link_code<%=record_count%>' value="<%=code%>">
									</td>
									
								</tr>
								
								<input type='hidden' name='chart_line_num_<%=record_count%>' id='chart_line_num_<%=record_count%>' value='<%=chart_line_num%>'>
								<input type='hidden' name='condition_type_<%=record_count%>' id='condition_type_<%=record_count%>' value='<%=condition_type%>'>
								<input type='hidden' name='site_type_<%=record_count%>' id='site_type_<%=record_count%>' value='<%=site_type%>'>
								<input type='hidden' name='area_<%=record_count%>' id='area_<%=record_count%>' value='<%=area%>'>
								<input type='hidden' name='condition_code_<%=record_count%>' id='condition_code_<%=record_count%>' value='<%=condition_code%>'>
								<input type='hidden' name='surface_code_<%=record_count%>' id='surface_code_<%=record_count%>' value='<%=surface_code%>'>
						<%
							}
						%>
						<tr>
							<td width="15%" colspan="6" class="button"><input type='button' class="button" name='record' id='record' value='<fmt:message key="Common.Accept.label" bundle="${common_labels}"/>' onclick='recordLink(this)'>&nbsp;
							<input type='button' class="button" name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick='window.close()'></td>
						</tr>
					</table>
					<input type='hidden' name='record_count' id='record_count' value='<%=record_count%>'>
					<input type='hidden' name='chart_num' id='chart_num' value='<%=chart_num%>'>
					<input type='hidden' name='click_mode' id='click_mode' value=''>
					<!--Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)-->
					<input type='hidden' name='oh_chart_level' id='oh_chart_level' value='<%=oh_chart_level%>'>
				</form>				
			</body>
		</html>
	<%
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			if(rs!=null) rs.close();
			if(rs_date!=null) rs_date.close();
			if(pstmt!=null) pstmt.close();
			if(pstmt_date!=null) pstmt_date.close();
			if(con!=null) 
				ConnectionManager.returnConnection(con,request);
		   }catch(Exception es){es.printStackTrace();}
	}
	%>

