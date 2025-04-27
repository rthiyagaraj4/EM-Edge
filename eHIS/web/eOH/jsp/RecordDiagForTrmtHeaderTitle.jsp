<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuffer strBuffer = new StringBuffer();
	String linked_diag_label =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.LinkedDiagnosisForTreatment.Label","oh_labels");
	String area_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.area.label","common_labels");

	String facility_id = (String)session.getValue("facility_id") ;
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
	String ind_chart_line_num = checkForNull(request.getParameter("ind_chart_line_num"));//Indivisual chart_line_num of a tooth in case of Tooth Range
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String practitioner_id = checkForNull(request.getParameter("practitioner_id"));
	String trmt_code = checkForNull(request.getParameter("trmt_code"));
	String display_tooth_no = checkForNull(request.getParameter("display_tooth_no"));
	String tooth_count = checkForNull(request.getParameter("tooth_count"));
	String surface_desc = checkForNull(request.getParameter("surface_desc"));
	String site_type = checkForNull(request.getParameter("site_type"));
	String site_type_desc = checkForNull(request.getParameter("site_type_desc"));
	String super_tooth_ref = checkForNull(request.getParameter("super_tooth_ref"));// Added by Sridevi Joshi on 2/24/2010 for IN010894 
	String area_desc = checkForNull(request.getParameter("area_desc"));
	String tooth_no=checkForNull(request.getParameter("tooth_no"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String trmt_desc = "";


	if(site_type.equals("")){
		site_type_desc = "";
	}

	try{
		con=ConnectionManager.getConnection(request);

		if(super_tooth_ref.equals("RD")){
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			pstmt = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH WHERE TOOTH_NO = ?) AND NUMBERING_SYSTEM = ?");
			pstmt.setString(1,tooth_no);
			pstmt.setString(2,tooth_numbering_system);
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				area_desc = checkForNull(rs.getString("NS_TOOTH_NO"));
			}
		}
		else if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !site_type.equals("MAXFS")){ //Added by Sridevi Joshi on 2/24/2010 for IN010894 
			area_desc = super_tooth_ref+"["+area_desc+"]";
		}

/*
	String from = checkForNull(request.getParameter( "from" )) ;
	String to =   checkForNull(request.getParameter( "to" ) ) ;
	int start = ( from.equals("") )?1:Integer.parseInt(from);
	int end =  ( to.equals("") )?7:Integer.parseInt(to);
	*/

		
	
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
						int i=1;
						if(pstmt != null) pstmt.close();
						if(rs != null) rs.close();
						pstmt=con.prepareStatement("SELECT TRMT_DESC FROM OH_TREATMENT  WHERE TRMT_CODE = ?");
						pstmt.setString(1,trmt_code);
						rs = pstmt.executeQuery();
						while(rs.next()){
							trmt_desc = rs.getString("TRMT_DESC");
						}

						if(pstmt != null) pstmt.close();
						if(rs != null) rs.close();
						//pstmt=con.prepareStatement("SELECT A.DIAG_CODE,A.TRMT_CODE, (SELECT C.TRMT_DESC FROM OH_TREATMENT C WHERE C.TRMT_CODE = A.TRMT_CODE) TRMT_DESC, TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') DIAG_DATE, A.CHART_LINE_NUM, (SELECT C.LONG_DESC FROM MR_TERM_CODE C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND C.TERM_CODE = A.DIAG_CODE ) DIAG_DESC,(SELECT TO_CHAR (D.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE FROM PR_DIAGNOSIS D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ONSET_FACILITY_ID = A.OPERATING_FACILITY_ID AND D.ONSET_ENCOUNTER_ID = A.ENCOUNTER_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.DIAG_CODE AND D.OCCUR_SRL_NO = A.OCCUR_SRL_NO) ONSET_DATE FROM OH_RESTORATIVE_CHART_DIAG A, OH_RESTORATIVE_CHART_DTL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.TRMT_CODE = B.TRMT_CODE AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? ORDER BY A.DIAG_CODE");
						pstmt=con.prepareStatement("SELECT A.TERM_SET_ID, A.TERM_CODE, TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') DIAG_DATE,(SELECT C.LONG_DESC FROM MR_TERM_CODE C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND C.TERM_CODE = A.TERM_CODE) TERM_CODE_DESC,(SELECT TO_CHAR (D.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE FROM PR_DIAGNOSIS D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ONSET_FACILITY_ID = A.OPERATING_FACILITY_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND D.OCCUR_SRL_NO = A.OCCUR_SRL_NO) ONSET_DATE FROM OH_RESTORATIVE_CHART_DIAG A, OH_RESTORATIVE_CHART_DTL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.TRMT_CODE = B.TRMT_CODE AND A.TRMT_CHART_NUM = B.CHART_NUM AND A.TRMT_CHART_LINE_NUM = B.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND A.TRMT_CHART_NUM = ? AND A.TRMT_CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND NVL(B.COND_CLOSED_YN,'N') = 'N' ORDER BY A.TERM_CODE ");

						pstmt.setString(1,facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,chart_num);
						pstmt.setString(4,ind_chart_line_num);//Indivisual chart_line_num of a tooth in case of Tooth Range
						pstmt.setString(5,trmt_code);
						rs = pstmt.executeQuery();
						int total=0;
						while(rs.next()){
							total++;
						}

						maxRecord = total;
						if(maxRecord == 0){
							//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
						}

						String[] linked_diag_label_arr = linked_diag_label.split("##");

				%>
				<table align='center' cellpadding='4' cellspacing='' border='0' width='98%'>
					<tr>
					<%
					if(site_type.equals("ARCH") || site_type.equals("QUAD")){
					%>
						<td class='CAGROUPHEADING' align="left" width="80%"><%=linked_diag_label_arr[0]%><%=trmt_desc%>,&nbsp;<%=area_desc%></td>
					<%
					}
					else if(site_type.equals("MAXFS")){
					%>
						<td class='CAGROUPHEADING' align="left" width="80%"><%=linked_diag_label_arr[0]%><%=trmt_desc%>,&nbsp;<%=area_legend%>&nbsp;<%=area_desc%></td>
					<%
					}
					else{
						if(display_tooth_no.equals("")){
							%>
							<td class='CAGROUPHEADING' align="left" width="80%"><%=linked_diag_label_arr[0]%><%=trmt_desc%></td>
							<%
						}
						else{
							%>
							<!-- <td class='CAGROUPHEADING' align="left" width="80%"><%//=linked_diag_label_arr[0]%><%//=trmt_desc%><%//=linked_diag_label_arr[1]%> <%//=tooth_no%></td> -->
							<!-- Added by Sridevi Joshi on 2/24/2010 for IN010894 -->
							<td class='CAGROUPHEADING' align="left" width="80%"><%=linked_diag_label_arr[0]%><%=trmt_desc%><%=linked_diag_label_arr[1]%> <%=area_desc%></td>
							<%
						}
					}
					%>
					
						<td align="right" class='CAGROUPHEADING' width="20%">

						<%
							/*
							int p=1;
							for(int k=1;k<=maxRecord;k+=7){
								if(maxRecord > 1){
									out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='showRecords("+k+");'>"+p+"</font>");
								}
								p++;
							}
							*/

							
						%>
						</td>
					</tr>
				</table>
				<table align='center' cellpadding='4' cellspacing='' border='0' width='98%'>
					<tr>
						<td class='label' width="25%" nowrap><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<%=trmt_desc%></td>
						<td class='label' width="25%"><fmt:message key="Common.Site.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<%=site_type_desc%></td>
						<td class='label' width="25%"><fmt:message key="Common.area.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<%=area_desc%></td>
						<td class='label' width="25%"><fmt:message key="eOH.Surface.Label" bundle="${oh_labels}"/>:&nbsp;&nbsp;<%=surface_desc%></td>
						
					</tr>
				</table>
				<br>
				<table align='center' cellpadding='4' cellspacing='' border='1' width='98%'>
					<tr>
						<th width="20%" nowrap><fmt:message key="Common.DiagnosisDate.label" bundle="${common_labels}"/></th>  
						<th width="20%" nowrap><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th> 
						<th width="20%" nowrap><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></th>
						<th width="20%" nowrap><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></th>
						<th width="20%" ><fmt:message key="Common.TermCodeDescription.label" bundle="${common_labels}"/></th>
						<th width="20%" nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					</tr>
				</table>

			<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
			<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
			<!-- <input type="hidden" name="start" id="start" value="<%//=start%>" >
			<input type="hidden" name="end" id="end" value="<%//=end%>" > -->

			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>" >
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>" >
			<input type="hidden" name="chart_num" id="chart_num" value="<%=chart_num%>" >
			<input type="hidden" name="chart_line_num" id="chart_line_num" value="<%=chart_line_num%>" >
			<input type="hidden" name="ind_chart_line_num" id="ind_chart_line_num" value="<%=ind_chart_line_num%>" >
			<input type="hidden" name="trmt_code" id="trmt_code" value="<%=trmt_code%>" >
			<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>" >
			<input type="hidden" name="tooth_no" id="tooth_no" value="<%=display_tooth_no%>" >
			<input type="hidden" name="tooth_count" id="tooth_count" value="<%=tooth_count%>" >
			
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


