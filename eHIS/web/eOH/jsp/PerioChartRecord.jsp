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
	String q1_sno = "";
	String q2_sno = "";
	String disabled = "";
	String facility_name = "";
	
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter("encounter_id")) ;
	String patient_class = checkForNull(request.getParameter("patient_class")) ;
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
	String cur_chart_num = checkForNull(request.getParameter("cur_chart_num"));
	String header_tab = checkForNull(request.getParameter("header_tab"));
	String show_new_active_yn = checkForNull(request.getParameter("show_new_active_yn"));
	String insert_new_EC_yn = checkForNull(request.getParameter("insert_new_EC_yn"));
	String baseline_closed_yn = checkForNull(request.getParameter("baseline_closed_yn"));
	String baseline_active_yn = checkForNull(request.getParameter("baseline_active_yn"));
	String disable_record = checkForNull(request.getParameter("disable_record"));

	String episode_type = checkForNull(request.getParameter("episode_type"));
	String episode_id = checkForNull(request.getParameter("episode_id"));
	String visit_id = checkForNull(request.getParameter("visit_id"));
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));

	if(baseline_closed_yn.equals("Y") || disable_record.equals("Y") ||other_facilitychart_yn.equals("Y")){
		disabled = "disabled";
	}


	String perio_chart = checkForNull(request.getParameter("perio_chart"));
	String perio_arch = checkForNull(request.getParameter("perio_arch"));
	if(!perio_arch.equals("")){
		if(perio_arch.equals("U")){
			q1_sno = "1";
			q2_sno = "2";
		}
		else if(perio_arch.equals("L")){
			q1_sno = "3";
			q2_sno = "4";
		}
	}

%>

<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOH/js/PerioChart.js"></script>
<!--  	<script language="javascript" src="../../eOH/js/PerioChartDataEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 -->
 <script>
 function retValueCheck(){
	var val = actionToServlet();
	alert(val)
	if(val == false){
		document.getElementById("perioChartTableComp").focus();
	}
 }
 </script>
</head>
<%
try{
	con=ConnectionManager.getConnection(request);

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	pstmt = con.prepareStatement("SELECT FACILITY_NAME  FROM SM_FACILITY_PARAM WHERE FACILITY_ID =?");
	pstmt.setString(1,facility_id);			
	rs = pstmt.executeQuery();
	while(rs!= null && rs.next()){
		facility_name = checkForNull(rs.getString("FACILITY_NAME"));
	}
%>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form name="perioChartRecordForm" id="perioChartRecordForm" action="../../servlet/eOH.PerioChartServlet" method="post" target="messageFrame">
		<table id="perioChartTable" width="100%" cellpadding =2 cellspacing=0>
			<tr>
				<td width="25%" class='label' nowrap><fmt:message key="eOH.ToothNo.Label" bundle="${oh_labels}"/></td>
				<td width="25%" class='field' nowrap>
					<select name="perio_tooth" id="perio_tooth" onChange="clearComponent();" <%=disabled%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						 <%
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							pstmt = con.prepareStatement("SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND A.PERMANENT_DECIDUOUS = 'P' AND B.QUADRANT_SNO IN (?,?) ORDER BY B.QUADRANT_SNO,A.TOOTH_NO");
							pstmt.setString(1,tooth_numbering_system);
							pstmt.setString(2,q1_sno);
							pstmt.setString(3,q2_sno);
							rs=pstmt.executeQuery();
								
							while(rs.next()){
						%>
								<option value="<%=rs.getString("TOOTH_NO")%>"><%=rs.getString("DISPLAY_TOOTH_NO")%></option>
						<%
							}
						%>
					</select><img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>
			</table>
			<table id="perioChartTableComp" width="100%" cellpadding =2 cellspacing=0>
			<tr>
				<td width="25%" class='label' nowrap><fmt:message key="Common.Components.label" bundle="${common_labels}"/></td>
				<td width="25%" class='field' nowrap>
					<select name="perio_comp" id="perio_comp" onchange="populatePerioSurfaces(this);" <%=disabled%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						 <%
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							if(!perio_chart.equals("")){
								pstmt=con.prepareStatement("SELECT DISTINCT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF COMPONENT_DESC FROM OH_PERIODONTAL_CHART_DEF_DTL A , OH_PERIODONTAL_CHART_COMP B WHERE B.COMPONENT_CODE = A.COMPONENT_CODE AND A.CHART_CODE=? AND B.FORMULA_YN = 'N' ORDER BY 2");
								pstmt.setString(1,perio_chart);
								rs=pstmt.executeQuery();
									
								while(rs.next()){
							%>
									<option value="<%=rs.getString("COMPONENT_CODE")%>"><%=rs.getString("COMPONENT_DESC")%></option>
							<%
								}
							}
						%>
					</select><img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>
		</table>
		<table width="100%" cellpadding =1 cellspacing=0>
			<tr>
				<td id="tooth_surface1"></td>
			</tr>
			<tr>
				<td id="tooth_surface2"></td>
			</tr>
			<tr>
				<td width="25%" colspan="2" class="button" <%=disabled%>>
					<input type="button" class="button" name="save" id="save" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick ="actionToServlet()">&nbsp;
					<input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onclick="reset_record()">
				</td>
			</tr>
		</table>
		
		<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
		<input type = "hidden" name= "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
		<input type = "hidden" name= "tooth_numbering_system" value = "<%=tooth_numbering_system%>">
		<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
		<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
		<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">
		<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
		<input type = "hidden" name= "cur_chart_num" value = "<%=cur_chart_num%>">
		<input type = "hidden" name= "header_tab" value = "<%=header_tab%>">
		<input type = "hidden" name= "perio_chart" value = "<%=perio_chart%>">
		<input type = "hidden" name= "show_new_active_yn" value = "<%=show_new_active_yn%>">
		<input type = "hidden" name= "chart_hdr_insert_yn" value = "">
		<input type = "hidden" name= "insert_new_EC_yn" value = "<%=insert_new_EC_yn%>">
		<input type = "hidden" name= "mode" value = "">
		<input type = "hidden" name= "baseline_active_yn" value = "<%=baseline_active_yn%>">
		<input type = "hidden" name= "baseline_closed_yn" value = "<%=baseline_closed_yn%>">
		<input type = "hidden" name= "chart_line_num" value = "<%=chart_line_num%>">
		<input type = "hidden" name= "disable_record" value = "<%=disable_record%>">
		<input type = "hidden" name= "episode_type" value = "<%=episode_type%>">
		<input type = "hidden" name= "episode_id" value = "<%=episode_id%>">
		<input type = "hidden" name= "visit_id" value = "<%=visit_id%>">
		<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
		<input type = "hidden" name= "q1_sno" value = "<%=q1_sno%>">
		<input type = "hidden" name= "q2_sno" value = "<%=q2_sno%>">
		<input type = "hidden" name= "facility_name" value = "<%=facility_name%>">

		<input type = "hidden" name= "min_val" value = "">
		<input type = "hidden" name= "max_val" value = "">
		<input type = "hidden" name= "surfaces_appl" value = "">
		<input type = "hidden" name= "DB_insert_yn" value = "">
		
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

