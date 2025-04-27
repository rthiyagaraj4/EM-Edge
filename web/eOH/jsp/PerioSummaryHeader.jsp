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
    String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));

	//Added by Sharon Crasta for CRF #0423 on 3/30/2009
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
	}

	String chart_line_date	= "";
	String chart_line_num	= "";
	String chart_code		= "";
	String chart_num		= "";
	String chart_desc		= "";
	String chart_code_str	= "";

	try{
		con=ConnectionManager.getConnection(request);
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eOH/js/OHSummary.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form name="PerioSummaryHeaderForm" id="PerioSummaryHeaderForm">
		   <table width="100%" cellpadding =4 cellspacing='1' border='1' align='center' valign='center'>
				<tr id="summary_head1">
					<td class="CAGROUPHEADING" width="100%">
						<fmt:message key="eOH.PeriodontalSummary.Label" bundle="${oh_labels}"/>
					</td>
				</tr>
			</table>				
			<table align='center' cellpadding='3' cellspacing='0' border='1' width='100%'>
				<tr>
					<td  width="25%" class='LABEL' nowrap><fmt:message key="Common.Chart.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' colspan="3">
						<select name="chart_row" id="chart_row" >
							<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
				<%	                                             
							int row_count = 0;
							String selected_option = "";
								 
							if(oh_chart_level.equals("E")){
								//sql_string="SELECT A.CHART_LINE_DATE,A.CHART_NUM,A.CHART_LINE_NUM,A.CHART_CODE,  B.CHART_DESC||'-'||A.CHART_TYPE||'-'||TO_CHAR(SM_CONVERT_DATE(A.CHART_LINE_DATE,?), 'DD/MM/YYYY')|| '-'||A.MODIFIED_BY_ID CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A,OH_PERIODONTAL_CHART_DEF_HDR B WHERE A.PATIENT_ID = ? AND A.CHART_LINE_STATUS IN ('CM','CD') AND A.CHART_CODE = B.CHART_CODE ORDER BY A.CHART_LINE_DATE DESC";
								//Added by Sridevi Joshi on 1/19/2010 for IN010939(SRR20056-CRF-0490).To Show only records which are having summary
								pstmt=con.prepareStatement("SELECT DISTINCT A.CHART_LINE_DATE,A.CHART_NUM,A.CHART_LINE_NUM,A.CHART_CODE, B.CHART_DESC||'-'||A.CHART_TYPE||'-'||TO_CHAR(SM_CONVERT_DATE(A.CHART_LINE_DATE,?), 'DD/MM/YYYY')|| '-'||A.MODIFIED_BY_ID CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A,OH_PERIODONTAL_CHART_DEF_HDR B, OH_PERIODONTAL_CHART_SUMMARY C WHERE A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE AND A.PATIENT_ID = ? AND A.CHART_LINE_STATUS IN ('CM','CD') AND A.CHART_CODE = B.CHART_CODE ORDER BY A.CHART_LINE_DATE DESC");
								pstmt.setString(1,locale);
								pstmt.setString(2,patient_id);

								rs=pstmt.executeQuery();
							}else{
								//sql_string=" SELECT A.CHART_LINE_DATE,A.CHART_NUM,A.CHART_LINE_NUM,A.CHART_CODE,  B.CHART_DESC||'-'||A.CHART_TYPE||'-'||TO_CHAR(SM_CONVERT_DATE(A.CHART_LINE_DATE,?), 'DD/MM/YYYY')|| '-'||A.MODIFIED_BY_ID CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A,OH_PERIODONTAL_CHART_DEF_HDR B WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_LINE_STATUS IN ('CM','CD') AND A.CHART_CODE = B.CHART_CODE ORDER BY A.CHART_LINE_DATE DESC";
								//Added by Sridevi Joshi on 1/19/2010 for IN010939(SRR20056-CRF-0490).To Show only records which are having summary
								pstmt=con.prepareStatement("SELECT DISTINCT A.CHART_LINE_DATE,A.CHART_NUM,A.CHART_LINE_NUM,A.CHART_CODE, B.CHART_DESC||'-'||A.CHART_TYPE||'-'||TO_CHAR(SM_CONVERT_DATE(A.CHART_LINE_DATE,?), 'DD/MM/YYYY')|| '-'||A.MODIFIED_BY_ID CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A,OH_PERIODONTAL_CHART_DEF_HDR B, OH_PERIODONTAL_CHART_SUMMARY C WHERE A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_LINE_STATUS IN ('CM','CD') AND A.CHART_CODE = B.CHART_CODE ORDER BY A.CHART_LINE_DATE DESC");
								pstmt.setString(1,locale);
								pstmt.setString(2,other_chart_facility_id);
								pstmt.setString(3,patient_id);

								rs=pstmt.executeQuery();					
							}
							while(rs.next()){
								row_count++;
								chart_line_date	= rs.getString("CHART_LINE_DATE");	
								chart_line_num	= rs.getString("CHART_LINE_NUM");	
								chart_code		= rs.getString("CHART_CODE");	
								chart_num		= rs.getString("CHART_NUM");	
								chart_desc		= rs.getString("CHART_DESC");	

								if(row_count==1){
									selected_option = "selected";
								}else{
									selected_option = "";
								}
								chart_code_str=chart_code+"##"+chart_num+"##"+chart_line_num;
				%>													
								<option value="<%=chart_code_str%>" <%=selected_option%> >
									<%=chart_desc%>
								</option>							
				<%
							}	
								   
				%>                            
						</select>
						&nbsp;
						<input type="button" class="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="callPerioChartSummary()">
					</td>				      
				</tr>
			</table> 		 
			<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">				
			<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">				
			<input type = "hidden" name= "tooth_numbering_system" value = "<%=tooth_numbering_system%>">
			<input type="hidden" name="called_from_perio_summary" id="called_from_perio_summary" value="Y">
			<input type="hidden" name="oh_chart_level" id="oh_chart_level" value="<%=oh_chart_level%>">
			<input type="hidden" name="other_chart_facility_id" id="other_chart_facility_id" value="<%=other_chart_facility_id%>">
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

