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
	String ind_chart_line_num = checkForNull(request.getParameter("ind_chart_line_num"));//Indivisual chart_line_num of a tooth in case of Tooth Range
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String trmt_code = checkForNull(request.getParameter("trmt_code"));
	String diag_label = checkForNull(request.getParameter("diag_label"));
	diag_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.LinkedDiagnosis.Label","oh_labels")+'('+diag_label+')';
	
	try{
		con=ConnectionManager.getConnection(request);
%>

<html>
	<head>
	<!-- eOH.LinkedDiagnosis.Label -->
		<title><%=diag_label%></title>
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
			<table align='center' cellpadding='4' cellspacing='' border='1' width='98%'>
					<tr>
						<td width="20%" class='columnHeaderCenter' nowrap><fmt:message key="Common.DiagnosisDate.label" bundle="${common_labels}"/></td>  
						<td width="20%" class='columnHeaderCenter' nowrap><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td> 
						<td width="20%" class='columnHeaderCenter' nowrap><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
						<td width="20%" class='columnHeaderCenter' nowrap><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
						<td width="20%" class='columnHeaderCenter' nowrap><fmt:message key="Common.TermCodeDescription.label" bundle="${common_labels}"/></td>
					</tr>
			<!-- </table>
			<table align='center' cellpadding='4' cellspacing='' border='1' width='98%'> -->
				
				<%
						int i=1;

						if(pstmt != null) pstmt.close();
						if(rs != null) rs.close();
						pstmt=con.prepareStatement("SELECT A.TERM_SET_ID, A.OCCUR_SRL_NO, A.TERM_CODE, A.TRMT_CHART_NUM, A.TRMT_CHART_LINE_NUM, A.TRMT_CODE, TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') DIAG_DATE,(SELECT C.LONG_DESC FROM MR_TERM_CODE C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND C.TERM_CODE = A.TERM_CODE) TERM_CODE_DESC,(SELECT SHORT_DESC FROM MR_ACCURACY, PR_DIAGNOSIS K WHERE ACCURACY_CODE =K.CURR_ACCURACY_CODE AND K.TERM_SET_ID = A.TERM_SET_ID AND K.TERM_CODE = A.TERM_CODE AND K.PATIENT_ID = A.PATIENT_ID AND A.OCCUR_SRL_NO=K.OCCUR_SRL_NO) ACCURACY_SHORT_DESC, (SELECT TO_CHAR (D.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE FROM PR_DIAGNOSIS D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ONSET_FACILITY_ID = A.OPERATING_FACILITY_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND D.OCCUR_SRL_NO = A.OCCUR_SRL_NO) ONSET_DATE FROM OH_RESTORATIVE_CHART_DIAG A, OH_RESTORATIVE_CHART_DTL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.TRMT_CODE = B.TRMT_CODE AND A.TRMT_CHART_NUM = B.CHART_NUM AND A.TRMT_CHART_LINE_NUM = B.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND A.TRMT_CHART_NUM = ? AND A.TRMT_CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND NVL(B.COND_CLOSED_YN,'N') = 'N' ORDER BY A.TERM_CODE ");

						pstmt.setString(1,facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,chart_num);
						pstmt.setString(4,ind_chart_line_num);//Indivisual chart_line_num of a tooth in case of Tooth Range
						pstmt.setString(5,trmt_code);
						rs = pstmt.executeQuery();

						while(rs.next()){
				%>
							<tr>
								<td width="20%" ><%=checkForNull(rs.getString("DIAG_DATE"))%></td>
								<td width="20%" ><%=checkForNull(rs.getString("ONSET_DATE"))%></td>
								<td width="20%" ><%=checkForNull(rs.getString("TERM_SET_ID"))%></td>
								<td width="20%" ><%=checkForNull(rs.getString("TERM_CODE"))%></td>
								<td width="20%"><%=checkForNull(rs.getString("TERM_CODE_DESC"))%></td>
							</tr>
				<%
							i++;
						}
				%>
				<tr>
					<td colspan='5' class='button'>
						<input type='button' class='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick='window.close();'>
					</td>
				</tr>

			</table>

			<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
			
			
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


