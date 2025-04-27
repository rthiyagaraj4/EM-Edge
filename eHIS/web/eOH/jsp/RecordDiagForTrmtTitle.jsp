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
	String facility_id = (String)session.getValue("facility_id") ;
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String practitioner_id = checkForNull(request.getParameter("practitioner_id"));
	String trmt_code = checkForNull(request.getParameter("trmt_code"));
	String totalselected = checkForNull(request.getParameter("totalselected"));


	String from = checkForNull(request.getParameter( "from" )) ;
	String to =   checkForNull(request.getParameter( "to" ) ) ;
	int start = ( from.equals("") )?1:Integer.parseInt(from);
	int end =  ( to.equals("") )?7:Integer.parseInt(to);
	String pract_type = "";


	
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
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form>
				<%
					int maxRecord = 0;
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
					pstmt=con.prepareStatement("SELECT E.ENC_STAGE,A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE,A.CURR_ACCURACY_CODE,A.CURR_ACCURACY_IND , C.NOTIFIABLE_YN,C.SHORT_DESC,C.LONG_DESC TERM_CODE_DESC, (SELECT SHORT_DESC FROM MR_ACCURACY WHERE ACCURACY_CODE =A.CURR_ACCURACY_CODE ) ACCURACY_SHORT_DESC,DECODE(A.CURR_NATURE,'A','ACTUAL','P','POTENTIAL','W','WELLNESS') NATURE , TO_CHAR (A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE , DECODE(A.CURR_STATUS,'A','ACTIVE','R','RESOLVED','X','REVOKED','E','IN ERROR') STATUS  ,A.CURR_PRIORITY PRIORITY ,NVL((SELECT 'Y' FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID   AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO  AND FACILITY_ID=? AND ENCOUNTER_ID=?  AND ROWNUM=1 ),'N')CURR_ENC_YN,A.OCCUR_SRL_NO,NVL((SELECT 'Y' FROM PR_SUPPORT_DIAGNOSIS WHERE PATIENT_ID =A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID  AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ROWNUM=1 ),'N') SUPPORT_EXISIST_YN_YN FROM PR_DIAGNOSIS A , MR_TERM_SET B , MR_TERM_CODE C, PR_DIAGNOSIS_ENC_DTL E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID=E.PATIENT_ID  AND A.TERM_SET_ID=E.TERM_SET_ID  AND A.OCCUR_SRL_NO=E.OCCUR_SRL_NO  AND A.TERM_CODE =E.TERM_CODE  AND A.ONSET_FACILITY_ID=E.FACILITY_ID AND A.ONSET_ENCOUNTER_ID=E.ENCOUNTER_ID AND EXISTS (SELECT  1 FROM MR_TERM_SET_FOR_FACILITY WHERE FACILITY_ID=? AND TERM_SET_ID=A.TERM_SET_ID ) AND EXISTS (   SELECT 1 FROM  MR_TERM_SET_FOR_PRACT_TYPE WHERE PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID  ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_SPECIALTY WHERE SPECIALTY_CODE IN (SELECT SPECIALTY_CODE  FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?) AND TERM_SET_ID=A.TERM_SET_ID   ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_PRACT IB WHERE PRACTITIONER_ID=? AND TERM_SET_ID=A.TERM_SET_ID  OR NOT EXISTS ( SELECT 1 FROM MR_TERM_SET_FOR_PRACT  WHERE PRACTITIONER_ID=IB.PRACTITIONER_ID  ))AND (A.CURR_STATUS= 'A' OR EXISTS (SELECT 1 FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID  AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A. TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND FACILITY_ID=? AND ENCOUNTER_ID=? AND ROWNUM=1 )) AND B.TERM_SET_ID(+) = A.TERM_SET_ID AND C.TERM_SET_ID(+) =A.TERM_SET_ID  AND C.TERM_CODE(+)=A.TERM_CODE AND A.TERM_CODE NOT IN (SELECT K.DIAG_CODE FROM OH_RESTORATIVE_CHART_DIAG K WHERE K.OPERATING_FACILITY_ID = A.CURR_FACILITY_ID AND K.PATIENT_ID = A.PATIENT_ID) ORDER BY TERM_SET_ID , ONSET_DATE DESC");
			
					pstmt.setString(1,facility_id);
					pstmt.setString(2,encounter_id);
					pstmt.setString(3,patient_id);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,pract_type);
					pstmt.setString(6,facility_id);
					pstmt.setString(7,encounter_id);
					pstmt.setString(8,practitioner_id);
					pstmt.setString(9,facility_id);
					pstmt.setString(10,encounter_id);
					rs = pstmt.executeQuery();

					int total=0;
					while(rs.next()){
						total++;
					}
					maxRecord = total;
					if(maxRecord == 0){
					}

					
				%>
				<table align='center' cellpadding='3' cellspacing='0' border='0' width='98%'>
					<tr>
						<td class='CAGROUPHEADING' width="25%" colspan="5" align="left" ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
					
						<td align="right" class='CAGROUPHEADING' width="25%">
						<%
							if ( !(start <= 1) )
							out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
						%>
							&nbsp;&nbsp;
						<%
							if ( !( (start+7) > maxRecord ) )
							out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
						%>
						</td>
					</tr>
				</table>
				<table align='center' cellpadding='3' cellspacing='0' border='1' width='98%'>
					<tr>
						<th width="20%" nowrap><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></th>
						<th width="20%" nowrap><fmt:message key="Common.DiagnosisDescription.label" bundle="${common_labels}"/></th>
						<th width="20%" nowrap><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></th>
						<th width="20%" nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
						<th width="20%" nowrap><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th>
						<th width="20%" nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					</tr>
				</table>
			<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
			<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
			<input type="hidden" name="start" id="start" value="<%=start%>" >
			<input type="hidden" name="end" id="end" value="<%=end%>" >

			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>" >
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>" >
			<input type="hidden" name="chart_num" id="chart_num" value="<%=chart_num%>" >
			<input type="hidden" name="trmt_code" id="trmt_code" value="<%=trmt_code%>" >
			<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>" >
			<input type="hidden" name="totalselected" id="totalselected" value="<%=totalselected%>" > 
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


