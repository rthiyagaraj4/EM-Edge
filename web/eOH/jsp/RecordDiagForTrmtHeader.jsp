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
	String term_code = "";
	String onset_date = "";
	String accuracy = "";
	String term_code_desc = "";
	String term_set_id = "";
	String occur_srl_no = "";

	String facility_id = (String)session.getValue("facility_id") ;
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
	String ind_chart_line_num = checkForNull(request.getParameter("ind_chart_line_num"));//Indivisual chart_line_num of a tooth in case of Tooth Range
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String practitioner_id = checkForNull(request.getParameter("practitioner_id"));
	String trmt_code = checkForNull(request.getParameter("trmt_code"));
	String tooth_no = checkForNull(request.getParameter("tooth_no"));
	String tooth_count = checkForNull(request.getParameter("tooth_count"));

	String status_disabled =  checkForNull(request.getParameter("status_disabled"));
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;			
	String baseline_chart_yn  = checkForNull(request.getParameter( "baseline_chart_yn" )) ;	//Added by Sridevi Joshi on 5/31/2010 for IN021668		
	String date_diff_flag  = checkForNull(request.getParameter( "date_diff_flag" )) ;	//Added by Sridevi Joshi on 5/31/2010 for IN021668		

	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}
	if(!other_chart_facility_id.equals(facility_id) || baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/31/2010 for IN021668		
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
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form>
			<table align='center' cellpadding='4' cellspacing='' border='1' width='98%'>
				
				<%
						int i=1;
						if(pstmt != null) pstmt.close();
						if(rs != null) rs.close();
						//pstmt=con.prepareStatement("SELECT A.DIAG_CODE,A.TRMT_CODE, A.CHART_LINE_NUM, DECODE(B.SITE_TYPE,'TOOTH',TOOTH_NO,'THRNG',TOOTH_NO,'ARCH',ARCH_SNO,'QUAD',QUADRANT_SNO) AREA,(SELECT C.LONG_DESC FROM MR_TERM_CODE C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND C.TERM_CODE = A.DIAG_CODE ) DIAG_DESC,(SELECT TO_CHAR (D.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE FROM PR_DIAGNOSIS D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ONSET_FACILITY_ID = A.OPERATING_FACILITY_ID AND D.ONSET_ENCOUNTER_ID = A.ENCOUNTER_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.DIAG_CODE AND D.OCCUR_SRL_NO = A.OCCUR_SRL_NO) ONSET_DATE FROM OH_RESTORATIVE_CHART_DIAG A, OH_RESTORATIVE_CHART_DTL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.TRMT_CODE = B.TRMT_CODE AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND A.CHART_NUM = ? ORDER BY A.DIAG_CODE");
						//pstmt=con.prepareStatement("SELECT A.DIAG_CODE,A.TRMT_CODE, (SELECT C.TRMT_DESC FROM OH_TREATMENT C WHERE C.TRMT_CODE = A.TRMT_CODE) TRMT_DESC, TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') DIAG_DATE, A.CHART_LINE_NUM, (SELECT C.LONG_DESC FROM MR_TERM_CODE C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND C.TERM_CODE = A.DIAG_CODE ) DIAG_DESC,(SELECT TO_CHAR (D.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE FROM PR_DIAGNOSIS D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ONSET_FACILITY_ID = A.OPERATING_FACILITY_ID AND D.ONSET_ENCOUNTER_ID = A.ENCOUNTER_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.DIAG_CODE AND D.OCCUR_SRL_NO = A.OCCUR_SRL_NO) ONSET_DATE FROM OH_RESTORATIVE_CHART_DIAG A, OH_RESTORATIVE_CHART_DTL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.TRMT_CODE = B.TRMT_CODE AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? ORDER BY A.DIAG_CODE");
						if(oh_chart_level.equals("E")){
						pstmt=con.prepareStatement("SELECT A.TERM_SET_ID, A.OCCUR_SRL_NO, A.TERM_CODE, A.TRMT_CHART_NUM, A.TRMT_CHART_LINE_NUM, A.TRMT_CODE, TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') DIAG_DATE,(SELECT C.LONG_DESC FROM MR_TERM_CODE C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND C.TERM_CODE = A.TERM_CODE) TERM_CODE_DESC,(SELECT SHORT_DESC FROM MR_ACCURACY, PR_DIAGNOSIS K WHERE ACCURACY_CODE =K.CURR_ACCURACY_CODE AND K.TERM_SET_ID = A.TERM_SET_ID AND K.TERM_CODE = A.TERM_CODE AND K.PATIENT_ID = A.PATIENT_ID AND A.OCCUR_SRL_NO=K.OCCUR_SRL_NO) ACCURACY_SHORT_DESC, (SELECT TO_CHAR (D.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE FROM PR_DIAGNOSIS D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND D.OCCUR_SRL_NO = A.OCCUR_SRL_NO) ONSET_DATE FROM OH_RESTORATIVE_CHART_DIAG A, OH_RESTORATIVE_CHART_DTL B WHERE A.PATIENT_ID = B.PATIENT_ID AND A.TRMT_CODE = B.TRMT_CODE AND A.TRMT_CHART_NUM = B.CHART_NUM AND A.TRMT_CHART_LINE_NUM = B.CHART_LINE_NUM  AND A.PATIENT_ID = ?  AND A.TRMT_CHART_NUM = ? AND A.TRMT_CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND NVL(B.COND_CLOSED_YN,'N') = 'N' ORDER BY A.TERM_CODE ");

						//pstmt.setString(1,facility_id);
						pstmt.setString(1,patient_id);
						pstmt.setString(2,chart_num);
						pstmt.setString(3,ind_chart_line_num);//Indivisual chart_line_num of a tooth in case of Tooth Range
						pstmt.setString(4,trmt_code);
						rs = pstmt.executeQuery();
						}else{
						pstmt=con.prepareStatement("SELECT A.TERM_SET_ID, A.OCCUR_SRL_NO, A.TERM_CODE, A.TRMT_CHART_NUM, A.TRMT_CHART_LINE_NUM, A.TRMT_CODE, TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') DIAG_DATE,(SELECT C.LONG_DESC FROM MR_TERM_CODE C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND C.TERM_CODE = A.TERM_CODE) TERM_CODE_DESC,(SELECT SHORT_DESC FROM MR_ACCURACY, PR_DIAGNOSIS K WHERE ACCURACY_CODE =K.CURR_ACCURACY_CODE AND K.TERM_SET_ID = A.TERM_SET_ID AND K.TERM_CODE = A.TERM_CODE AND K.PATIENT_ID = A.PATIENT_ID AND A.OCCUR_SRL_NO=K.OCCUR_SRL_NO) ACCURACY_SHORT_DESC, (SELECT TO_CHAR (D.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE FROM PR_DIAGNOSIS D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ONSET_FACILITY_ID = A.OPERATING_FACILITY_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND D.OCCUR_SRL_NO = A.OCCUR_SRL_NO) ONSET_DATE FROM OH_RESTORATIVE_CHART_DIAG A, OH_RESTORATIVE_CHART_DTL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.TRMT_CODE = B.TRMT_CODE AND A.TRMT_CHART_NUM = B.CHART_NUM AND A.TRMT_CHART_LINE_NUM = B.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND A.TRMT_CHART_NUM = ? AND A.TRMT_CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND NVL(B.COND_CLOSED_YN,'N') = 'N' ORDER BY A.TERM_CODE ");

						pstmt.setString(1,other_chart_facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,chart_num);
						pstmt.setString(4,ind_chart_line_num);//Indivisual chart_line_num of a tooth in case of Tooth Range
						pstmt.setString(5,trmt_code);
						rs = pstmt.executeQuery();
						
						
						}
						/*
						if ( start != 1 ){
							for( int j=1; j<start; i++,j++ ){
								rs.next() ;
							}
						}
						*/
				
						
						//while(rs.next() && i<=end ){
						while(rs.next()){
							
							term_code = checkForNull(rs.getString("TERM_CODE"));
							onset_date = checkForNull(rs.getString("ONSET_DATE"));
							accuracy = checkForNull(rs.getString("ACCURACY_SHORT_DESC"));
							term_code_desc = checkForNull(rs.getString("TERM_CODE_DESC"));
							term_set_id = checkForNull(rs.getString("TERM_SET_ID"));
							occur_srl_no = checkForNull(rs.getString("OCCUR_SRL_NO"));
				%>
							<tr>
								<td width="20%" ><%=checkForNull(rs.getString("DIAG_DATE"))%></td>
								<td width="20%" ><%=checkForNull(rs.getString("ONSET_DATE"))%></td>
								<td width="20%" ><%=checkForNull(rs.getString("TERM_SET_ID"))%></td>
								<td width="20%"><a href="javascript:showDiagAndLinkedCond('<%=term_code%>','<%=accuracy%>','<%=onset_date%>','<%=term_code_desc%>','<%=term_set_id%>','<%=occur_srl_no%>');"><%=checkForNull(rs.getString("TERM_CODE"))%></a></td>
								<td width="20%"><%=checkForNull(rs.getString("TERM_CODE_DESC"))%></td>
								<td width="20%" >&nbsp;&nbsp;<input type="checkbox" name="chk_select<%=i%>" id="chk_select<%=i%>" diag_code='<%=checkForNull(rs.getString("TERM_CODE"))%>' term_set_id='<%=checkForNull(rs.getString("TERM_SET_ID"))%>' trmt_code='<%=checkForNull(rs.getString("TRMT_CODE"))%>' diag_chart_line_num = '<%=checkForNull(rs.getString("TRMT_CHART_LINE_NUM"))%>' onclick='validateDeleteCheckBox(this);' <%=status_disabled%>>&nbsp;&nbsp;</td>
								<!-- <td width="20%" >&nbsp;&nbsp;<input type="checkbox" name="chk_select<%=i%>" id="chk_select<%=i%>" diag_code='<%=checkForNull(rs.getString("TERM_CODE"))%>' trmt_code='<%=checkForNull(rs.getString("TRMT_CODE"))%>' diag_chart_line_num = '<%=checkForNull(rs.getString("TRMT_CHART_LINE_NUM"))%>' onclick='validateDeleteCheckBox(this);'>&nbsp;&nbsp;</td> -->
				<%				/*
								if(totalSelected!=null && totalSelected.length()>0){
									String tokens[] = totalSelected.split(",");
									for(int p = 0;p<tokens.length;p++){
										if(Integer.parseInt(tokens[p])==i){
											out.println("<script>assignDeleteListValue("+tokens[p]+");</script>");
										}
									}
								}
								*/
				%>
							</tr>
				<%
							i++;
						}
				%>

				<tr>
					<td class="button" colspan="6"><input type="button" class="button" name="record" id="record" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' onclick="deleteOptions();" <%=status_disabled%>></td>
				</tr>
				
			</table>

			<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
			<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
			<!-- <input type="hidden" name="start" id="start" value="<%//=start%>" > -->
			<!-- <input type="hidden" name="end" id="end" value="<%//=end%>" > -->

			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>" >
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>" >
			<input type="hidden" name="chart_num" id="chart_num" value="<%=chart_num%>" >
			<input type="hidden" name="chart_line_num" id="chart_line_num" value="<%=chart_line_num%>" >
			<input type="hidden" name="ind_chart_line_num" id="ind_chart_line_num" value="<%=ind_chart_line_num%>" >
			<input type="hidden" name="trmt_code" id="trmt_code" value="<%=trmt_code%>" >
			<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>" >
			<input type="hidden" name="tooth_no" id="tooth_no" value="<%=tooth_no%>" >
			<input type="hidden" name="tooth_count" id="tooth_count" value="<%=tooth_count%>" >
			<input type="hidden" name="other_chart_facility_id" id="other_chart_facility_id" value="<%=other_chart_facility_id%>" >
			<input type="hidden" name="oh_chart_level" id="oh_chart_level" value="<%=oh_chart_level%>" >
			
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


