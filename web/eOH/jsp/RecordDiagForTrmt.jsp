<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
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
	StringBuffer strBuffer = new StringBuffer();

	String facility_id = (String)session.getValue("facility_id") ;
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
	String ind_chart_line_num = checkForNull(request.getParameter("ind_chart_line_num"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String practitioner_id = checkForNull(request.getParameter("practitioner_id"));
	String trmt_code = checkForNull(request.getParameter("trmt_code"));
	String totalselected = checkForNull(request.getParameter("totalselected"));
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String site_type = checkForNull(request.getParameter("site_type"));
	String area_param = checkForNull(request.getParameter("area_param"));
	String thrng_nos_ref = checkForNull(request.getParameter("thrng_nos_ref"));
	String baseline_chart_yn = checkForNull(request.getParameter("baseline_chart_yn"));//Added by Sridevi Joshi on 5/31/2010 for IN021668		
	String date_diff_flag = checkForNull(request.getParameter("date_diff_flag"));//Added by Sridevi Joshi on 5/31/2010 for IN021668		

	//Diagnosis Params
	String term_code = checkForNull(request.getParameter("term_code"));
	String accuracy = checkForNull(request.getParameter("accuracy"));
	String onset_date = checkForNull(request.getParameter("onset_date"));
	String term_code_desc = checkForNull(request.getParameter("term_code_desc"));
	String mode = checkForNull(request.getParameter("mode"));


	String from = checkForNull(request.getParameter( "from" )) ;
	String to =   checkForNull(request.getParameter( "to" ) ) ;
	int start = ( from.equals("") )?1:Integer.parseInt(from);
	int end =  ( to.equals("") )?7:Integer.parseInt(to);

	String link_already_exists_yn = "";
	String term_set_id = "";
	String occur_srl_no = "";
	String accuracy_short_desc = "";
	String diag_status = "";
	String pract_type = "";

	String status_disabled =  checkForNull(request.getParameter("status_disabled"));
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;			
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}
	if(!other_chart_facility_id.equals(facility_id)|| baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/31/2010 for IN021668		
		status_disabled = "disabled";	
	}
	
	try{
		con=ConnectionManager.getConnection(request);
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eOH/js/RecordDiagForTrmt.js'></script>
		<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onload="assignDBValue('<%=term_code%>','<%=accuracy%>','<%=onset_date%>','<%=term_code_desc%>','<%=mode%>');" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form>
			<table align='center' cellpadding='3' cellspacing='0' border='0' width='100%'>
				<tr>
					<td width="25%" class='CAGROUPHEADING' colspan='4'><fmt:message key="eOH.LinkDiagnosis.Label" bundle="${oh_labels}"/></td> 
				</tr>
				<%
					if(!mode.equals("modify")){
				%>
					<tr>
						<td width="25%" class='label'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td> 
						<td width="25%" class='label' id='diagnosis_options'>
							<select name='diag_select' id='diag_select' onchange='showDiagDetails(this);' <%=status_disabled%>>
								<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
							<%
								int i=1;

								if(pstmt != null) pstmt.close();
								if(rs != null) rs.close();

								pstmt=con.prepareStatement("SELECT PRACT_TYPE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = ?");
								pstmt.setString(1,practitioner_id);
								rs = pstmt.executeQuery();
								while(rs.next()){
									pract_type = rs.getString("PRACT_TYPE");
								}

								if(pstmt != null) pstmt.close();
								if(rs != null) rs.close();

								
								//pstmt=con.prepareStatement("SELECT E.ENC_STAGE,A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE,A.CURR_ACCURACY_CODE,A.CURR_ACCURACY_IND , C.NOTIFIABLE_YN,C.SHORT_DESC,C.LONG_DESC TERM_CODE_DESC, (SELECT SHORT_DESC FROM MR_ACCURACY WHERE ACCURACY_CODE =A.CURR_ACCURACY_CODE ) ACCURACY_SHORT_DESC,DECODE(A.CURR_NATURE,'A','ACTUAL','P','POTENTIAL','W','WELLNESS') NATURE , TO_CHAR (A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE , DECODE(A.CURR_STATUS,'A','ACTIVE','R','RESOLVED','X','REVOKED','E','IN ERROR') STATUS  ,A.CURR_PRIORITY PRIORITY ,NVL((SELECT 'Y' FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID   AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO  AND FACILITY_ID=? AND ENCOUNTER_ID=?  AND ROWNUM=1 ),'N')CURR_ENC_YN,A.OCCUR_SRL_NO,NVL((SELECT 'Y' FROM PR_SUPPORT_DIAGNOSIS WHERE PATIENT_ID =A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID  AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ROWNUM=1 ),'N') SUPPORT_EXISIST_YN_YN FROM PR_DIAGNOSIS A , MR_TERM_SET B , MR_TERM_CODE C, PR_DIAGNOSIS_ENC_DTL E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID=E.PATIENT_ID  AND A.TERM_SET_ID=E.TERM_SET_ID  AND A.OCCUR_SRL_NO=E.OCCUR_SRL_NO  AND A.TERM_CODE =E.TERM_CODE  AND A.ONSET_FACILITY_ID=E.FACILITY_ID AND A.ONSET_ENCOUNTER_ID=E.ENCOUNTER_ID AND EXISTS (SELECT  1 FROM MR_TERM_SET_FOR_FACILITY WHERE FACILITY_ID=? AND TERM_SET_ID=A.TERM_SET_ID ) AND EXISTS (   SELECT 1 FROM  MR_TERM_SET_FOR_PRACT_TYPE WHERE PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID  ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_SPECIALTY WHERE SPECIALTY_CODE IN (SELECT SPECIALTY_CODE  FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?) AND TERM_SET_ID=A.TERM_SET_ID   ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_PRACT IB WHERE PRACTITIONER_ID=? AND TERM_SET_ID=A.TERM_SET_ID  OR NOT EXISTS ( SELECT 1 FROM MR_TERM_SET_FOR_PRACT  WHERE PRACTITIONER_ID=IB.PRACTITIONER_ID  ))AND (A.CURR_STATUS= 'A' OR EXISTS (SELECT 1 FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID  AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A. TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND FACILITY_ID=? AND ENCOUNTER_ID=? AND ROWNUM=1 )) AND B.TERM_SET_ID(+) = A.TERM_SET_ID AND C.TERM_SET_ID(+) =A.TERM_SET_ID  AND C.TERM_CODE(+)=A.TERM_CODE ORDER BY TERM_SET_ID , ONSET_DATE DESC");
								if(oh_chart_level.equals("E")){
									pstmt=con.prepareStatement("SELECT E.ENC_STAGE,A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE,A.CURR_ACCURACY_CODE,A.CURR_ACCURACY_IND , C.NOTIFIABLE_YN,C.SHORT_DESC,C.LONG_DESC TERM_CODE_DESC, (SELECT SHORT_DESC FROM MR_ACCURACY WHERE ACCURACY_CODE =A.CURR_ACCURACY_CODE ) ACCURACY_SHORT_DESC,DECODE(A.CURR_NATURE,'A','ACTUAL','P','POTENTIAL','W','WELLNESS') NATURE , TO_CHAR (A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE , DECODE(A.CURR_STATUS,'A','ACTIVE','R','RESOLVED','X','REVOKED','E','IN ERROR') STATUS, A.CURR_PRIORITY PRIORITY ,NVL((SELECT 'Y' FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID   AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ENCOUNTER_ID=?  AND ROWNUM=1 ),'N')CURR_ENC_YN,A.OCCUR_SRL_NO,NVL((SELECT 'Y' FROM PR_SUPPORT_DIAGNOSIS WHERE PATIENT_ID =A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID  AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ROWNUM=1 ),'N') SUPPORT_EXISIST_YN_YN, (SELECT 'Y' FROM OH_RESTORATIVE_CHART_DIAG OH WHERE OH.PATIENT_ID=E.PATIENT_ID AND OH.TERM_SET_ID=E.TERM_SET_ID AND OH.TERM_CODE=E.TERM_CODE AND OH.TRMT_CHART_NUM=? AND OH.TRMT_CHART_LINE_NUM=? AND OH.TRMT_CODE=?) LINK_ALREADY_EXISTS_YN FROM PR_DIAGNOSIS A , MR_TERM_SET B , MR_TERM_CODE C, PR_DIAGNOSIS_ENC_DTL E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID=E.PATIENT_ID  AND A.TERM_SET_ID=E.TERM_SET_ID  AND A.OCCUR_SRL_NO=E.OCCUR_SRL_NO  AND A.TERM_CODE =E.TERM_CODE  AND A.ONSET_FACILITY_ID=E.FACILITY_ID AND A.ONSET_ENCOUNTER_ID=E.ENCOUNTER_ID AND EXISTS (SELECT  1 FROM MR_TERM_SET_FOR_FACILITY WHERE TERM_SET_ID=A.TERM_SET_ID ) AND EXISTS (   SELECT 1 FROM  MR_TERM_SET_FOR_PRACT_TYPE WHERE PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID  ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_SPECIALTY WHERE SPECIALTY_CODE IN (SELECT SPECIALTY_CODE  FROM PR_ENCOUNTER WHERE  ENCOUNTER_ID=?) AND TERM_SET_ID=A.TERM_SET_ID   ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_PRACT IB WHERE PRACTITIONER_ID=? AND TERM_SET_ID=A.TERM_SET_ID  OR NOT EXISTS ( SELECT 1 FROM MR_TERM_SET_FOR_PRACT  WHERE PRACTITIONER_ID=IB.PRACTITIONER_ID  ))AND (A.CURR_STATUS= 'A' OR EXISTS (SELECT 1 FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID  AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A. TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ENCOUNTER_ID=? AND ROWNUM=1 )) AND B.TERM_SET_ID(+) = A.TERM_SET_ID AND C.TERM_SET_ID(+) =A.TERM_SET_ID  AND C.TERM_CODE(+)=A.TERM_CODE ORDER BY TERM_SET_ID , ONSET_DATE DESC");						
							//	pstmt.setString(1,facility_id);
								pstmt.setString(1,encounter_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,chart_line_num);
								pstmt.setString(4,trmt_code);
								pstmt.setString(5,patient_id);
								//pstmt.setString(6,facility_id);
								pstmt.setString(6,pract_type);
								//pstmt.setString(8,facility_id);
								pstmt.setString(7,encounter_id);
								pstmt.setString(8,practitioner_id);
								//pstmt.setString(11,facility_id);
								pstmt.setString(9,encounter_id);
								rs = pstmt.executeQuery();
								}else{
								pstmt=con.prepareStatement("SELECT E.ENC_STAGE,A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE,A.CURR_ACCURACY_CODE,A.CURR_ACCURACY_IND , C.NOTIFIABLE_YN,C.SHORT_DESC,C.LONG_DESC TERM_CODE_DESC, (SELECT SHORT_DESC FROM MR_ACCURACY WHERE ACCURACY_CODE =A.CURR_ACCURACY_CODE ) ACCURACY_SHORT_DESC,DECODE(A.CURR_NATURE,'A','ACTUAL','P','POTENTIAL','W','WELLNESS') NATURE , TO_CHAR (A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE , DECODE(A.CURR_STATUS,'A','ACTIVE','R','RESOLVED','X','REVOKED','E','IN ERROR') STATUS, A.CURR_PRIORITY PRIORITY ,NVL((SELECT 'Y' FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID   AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO  AND FACILITY_ID=? AND ENCOUNTER_ID=?  AND ROWNUM=1 ),'N')CURR_ENC_YN,A.OCCUR_SRL_NO,NVL((SELECT 'Y' FROM PR_SUPPORT_DIAGNOSIS WHERE PATIENT_ID =A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID  AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ROWNUM=1 ),'N') SUPPORT_EXISIST_YN_YN, (SELECT 'Y' FROM OH_RESTORATIVE_CHART_DIAG OH WHERE OH.OPERATING_FACILITY_ID = E.FACILITY_ID AND OH.PATIENT_ID=E.PATIENT_ID AND OH.TERM_SET_ID=E.TERM_SET_ID AND OH.TERM_CODE=E.TERM_CODE AND OH.TRMT_CHART_NUM=? AND OH.TRMT_CHART_LINE_NUM=? AND OH.TRMT_CODE=?) LINK_ALREADY_EXISTS_YN FROM PR_DIAGNOSIS A , MR_TERM_SET B , MR_TERM_CODE C, PR_DIAGNOSIS_ENC_DTL E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID=E.PATIENT_ID  AND A.TERM_SET_ID=E.TERM_SET_ID  AND A.OCCUR_SRL_NO=E.OCCUR_SRL_NO  AND A.TERM_CODE =E.TERM_CODE  AND A.ONSET_FACILITY_ID=E.FACILITY_ID AND A.ONSET_ENCOUNTER_ID=E.ENCOUNTER_ID AND EXISTS (SELECT  1 FROM MR_TERM_SET_FOR_FACILITY WHERE FACILITY_ID=? AND TERM_SET_ID=A.TERM_SET_ID ) AND EXISTS (   SELECT 1 FROM  MR_TERM_SET_FOR_PRACT_TYPE WHERE PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID  ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_SPECIALTY WHERE SPECIALTY_CODE IN (SELECT SPECIALTY_CODE  FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?) AND TERM_SET_ID=A.TERM_SET_ID   ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_PRACT IB WHERE PRACTITIONER_ID=? AND TERM_SET_ID=A.TERM_SET_ID  OR NOT EXISTS ( SELECT 1 FROM MR_TERM_SET_FOR_PRACT  WHERE PRACTITIONER_ID=IB.PRACTITIONER_ID  ))AND (A.CURR_STATUS= 'A' OR EXISTS (SELECT 1 FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID  AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A. TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND FACILITY_ID=? AND ENCOUNTER_ID=? AND ROWNUM=1 )) AND B.TERM_SET_ID(+) = A.TERM_SET_ID AND C.TERM_SET_ID(+) =A.TERM_SET_ID  AND C.TERM_CODE(+)=A.TERM_CODE ORDER BY TERM_SET_ID , ONSET_DATE DESC");
						
								pstmt.setString(1,facility_id);
								pstmt.setString(2,encounter_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,chart_line_num);
								pstmt.setString(5,trmt_code);
								pstmt.setString(6,patient_id);
								pstmt.setString(7,facility_id);
								pstmt.setString(8,pract_type);
								pstmt.setString(9,facility_id);
								pstmt.setString(10,encounter_id);
								pstmt.setString(11,practitioner_id);
								pstmt.setString(12,facility_id);
								pstmt.setString(13,encounter_id);
								//pstmt=con.prepareStatement("SELECT E.ENC_STAGE,A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE,A.CURR_ACCURACY_CODE,A.CURR_ACCURACY_IND , C.NOTIFIABLE_YN,C.SHORT_DESC,C.LONG_DESC TERM_CODE_DESC, (SELECT SHORT_DESC FROM MR_ACCURACY WHERE ACCURACY_CODE =A.CURR_ACCURACY_CODE ) ACCURACY_SHORT_DESC,DECODE(A.CURR_NATURE,'A','ACTUAL','P','POTENTIAL','W','WELLNESS') NATURE , TO_CHAR (A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE , DECODE(A.CURR_STATUS,'A','ACTIVE','R','RESOLVED','X','REVOKED','E','IN ERROR') STATUS, A.CURR_PRIORITY PRIORITY ,NVL((SELECT 'Y' FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID   AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO  AND FACILITY_ID=? AND ENCOUNTER_ID=?  AND ROWNUM=1 ),'N')CURR_ENC_YN,A.OCCUR_SRL_NO,NVL((SELECT 'Y' FROM PR_SUPPORT_DIAGNOSIS WHERE PATIENT_ID =A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID  AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ROWNUM=1 ),'N') SUPPORT_EXISIST_YN_YN, (SELECT 'Y' FROM OH_RESTORATIVE_CHART_DIAG OH WHERE OH.OPERATING_FACILITY_ID = E.FACILITY_ID AND OH.PATIENT_ID=E.PATIENT_ID AND OH.TERM_SET_ID=E.TERM_SET_ID AND OH.TERM_CODE=E.TERM_CODE AND OH.TRMT_CHART_NUM=? AND OH.TRMT_CHART_LINE_NUM=? AND OH.TRMT_CODE=?) LINK_ALREADY_EXISTS_YN FROM PR_DIAGNOSIS A , MR_TERM_SET B , MR_TERM_CODE C, PR_DIAGNOSIS_ENC_DTL E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID=E.PATIENT_ID  AND A.TERM_SET_ID=E.TERM_SET_ID  AND A.OCCUR_SRL_NO=E.OCCUR_SRL_NO  AND A.TERM_CODE =E.TERM_CODE  AND A.ONSET_FACILITY_ID=E.FACILITY_ID AND A.ONSET_ENCOUNTER_ID=E.ENCOUNTER_ID AND EXISTS (SELECT  1 FROM MR_TERM_SET_FOR_FACILITY WHERE FACILITY_ID=? AND TERM_SET_ID=A.TERM_SET_ID ) AND EXISTS (   SELECT 1 FROM  MR_TERM_SET_FOR_PRACT_TYPE WHERE PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID  ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_SPECIALTY WHERE SPECIALTY_CODE IN (SELECT SPECIALTY_CODE  FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?) AND TERM_SET_ID=A.TERM_SET_ID   ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_PRACT IB WHERE PRACTITIONER_ID=? AND TERM_SET_ID=A.TERM_SET_ID  OR NOT EXISTS ( SELECT 1 FROM MR_TERM_SET_FOR_PRACT  WHERE PRACTITIONER_ID=IB.PRACTITIONER_ID  ))AND (A.CURR_STATUS= 'A' OR EXISTS (SELECT 1 FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID  AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A. TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND FACILITY_ID=? AND ENCOUNTER_ID=? AND ROWNUM=1 )) AND B.TERM_SET_ID(+) = A.TERM_SET_ID AND C.TERM_SET_ID(+) =A.TERM_SET_ID  AND C.TERM_CODE(+)=A.TERM_CODE ORDER BY TERM_SET_ID , ONSET_DATE DESC");
								/*pstmt.setString(1,other_chart_facility_id);
								pstmt.setString(2,encounter_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,chart_line_num);
								pstmt.setString(5,trmt_code);
								pstmt.setString(6,patient_id);
								//pstmt.setString(7,facility_id);
								pstmt.setString(7,other_chart_facility_id);
								pstmt.setString(8,pract_type);
								//pstmt.setString(9,facility_id);
								pstmt.setString(9,other_chart_facility_id);
								pstmt.setString(10,encounter_id);
								pstmt.setString(11,practitioner_id);
								//pstmt.setString(12,facility_id);
								pstmt.setString(12,other_chart_facility_id);
								pstmt.setString(13,encounter_id); */
								rs = pstmt.executeQuery();
								}
								if ( start != 1 )
								for( int j=1; j<start; i++,j++ )
									rs.next() ;
								String classValue= " ";
								while ( rs.next() && i<=end  ){
									if ( i % 2 == 0 )
										classValue = "QRYEVEN" ;
									else
										classValue = "QRYODD" ;

									link_already_exists_yn = checkForNull(rs.getString("LINK_ALREADY_EXISTS_YN"));
									term_set_id = checkForNull(rs.getString("TERM_SET_ID"));
									occur_srl_no = checkForNull(rs.getString("OCCUR_SRL_NO"));
									term_code = checkForNull(rs.getString("TERM_CODE"));
									term_code_desc = checkForNull(rs.getString("TERM_CODE_DESC"));
									accuracy_short_desc = checkForNull(rs.getString("ACCURACY_SHORT_DESC"));
									diag_status = checkForNull(rs.getString("STATUS"));
									onset_date = checkForNull(rs.getString("ONSET_DATE"));
									if(!link_already_exists_yn.equals("Y")){
									%>
										<option value='<%=term_code%>##<%=accuracy_short_desc%>##<%=onset_date%>##<%=term_set_id%>##<%=occur_srl_no%>##<%=diag_status%>'><%=term_code_desc%></option>
									<%
									}
									if(totalselected!=null && totalselected.length()>0){
										String tokens[] = totalselected.split(",");
										for(int p = 0;p<tokens.length;p++){
											if(Integer.parseInt(tokens[p])==i)
												strBuffer.append("<script>assingListItemValue("+tokens[p]+");</script>");
										}
									}
									
									
									i++;
								}

							%>
							</select>
						</td>
						<td width="25%">&nbsp;&nbsp;</td>
						<td width="25%">&nbsp;&nbsp;</td>
					</tr>
				<%
				}
				%>
				<tr>
					<td id="diag_details" colspan='4'></td>
				</tr>
			</table>
			
			<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
			<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
			<input type="hidden" name="start" id="start" value="<%=start%>" >
			<input type="hidden" name="end" id="end" value="<%=end%>" >

			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>" >
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>" >
			<input type="hidden" name="chart_num" id="chart_num" value="<%=chart_num%>" >
			<input type="hidden" name="chart_line_num" id="chart_line_num" value="<%=chart_line_num%>" >
			<input type="hidden" name="ind_chart_line_num" id="ind_chart_line_num" value="<%=ind_chart_line_num%>" >
			<input type="hidden" name="trmt_code" id="trmt_code" value="<%=trmt_code%>" >
			<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>" >
			<input type="hidden" name="totalselected" id="totalselected" value="<%=totalselected%>" > 
			<input type="hidden" name="permanent_deciduous_flag" id="permanent_deciduous_flag" value="<%=permanent_deciduous_flag%>" > 
			<input type="hidden" name="tooth_numbering_system" id="tooth_numbering_system" value="<%=tooth_numbering_system%>" > 
			<input type="hidden" name="site_type" id="site_type" value="<%=site_type%>" > 
			<input type="hidden" name="area_param" id="area_param" value="<%=area_param%>" > 
			<input type="hidden" name="thrng_nos_ref" id="thrng_nos_ref" value="<%=thrng_nos_ref%>" > 
			<input type="hidden" name="oh_chart_level" id="oh_chart_level" value="<%=oh_chart_level%>" > 
			<input type="hidden" name="other_chart_facility_id" id="other_chart_facility_id" value="<%=other_chart_facility_id%>" > 
			<input type="hidden" name="baseline_chart_yn" id="baseline_chart_yn" value="<%=baseline_chart_yn%>" > 
			<input type="hidden" name="date_diff_flag" id="date_diff_flag" value="<%=date_diff_flag%>" > 
		</form>
	</body>
</html>
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


