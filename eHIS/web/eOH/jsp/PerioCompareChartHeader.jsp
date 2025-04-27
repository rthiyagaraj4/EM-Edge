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
	String sql = "";
	String facility_id = (String)session.getValue("facility_id") ;
	String chart_flag =  checkForNull(request.getParameter("chart_flag")) ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter("encounter_id")) ;
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
%>

<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
	<script language="javascript" src="../../eOH/js/PerioChart.js"></script>
	<script language="javascript" src="../../eOH/js/PerioCompareChart.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
try{
	con=ConnectionManager.getConnection(request);
%>
<!--<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onLoad="assignDBValue();">-->
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
	<form name="perioChartHeaderForm" id="perioChartHeaderForm" method="post" target="messageFrame">
		<table width="100%" cellpadding =4 cellspacing=0 border=0 id="myTable">
			<tr>
			<td class='label' >
			<fieldset>
			<legend class='label' nowrap><fmt:message key="eOH.Compare.Label" bundle="${oh_labels}"/></legend>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<SELECT name="chart_cmpre" id="chart_cmpre" onchange='enableChart();'><!-- eOH.2Charts.Label -->
					<option value="2" selected><fmt:message key="eOH.2Charts.Label" bundle="${oh_labels}"/></option>
					<option value="3"><fmt:message key="eOH.3Charts.Label" bundle="${oh_labels}"/></option><!-- eOH.3Charts.Label -->
				</SELECT>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT TYPE="radio" name="evaluation" id="evaluation"  value="BB" onclick="changeLabel('BB');">
						<fmt:message key="eOH.BaselineVSBaseline.Label" bundle="${oh_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
				<INPUT TYPE="radio" name="evaluation" id="evaluation"  value="BE" checked onclick="changeLabel('BE');">
						<fmt:message key="eOH.BaselineVSEvaluation.Label" bundle="${oh_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
				<INPUT TYPE="radio" name="evaluation" id="evaluation" value="EE"  onclick="changeLabel('EE');"> 
						<fmt:message key="eOH.EvaluationVSBaseline.Label" bundle="${oh_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<INPUT TYPE="checkbox" name="chkacrchart" id="chkacrchart" onclick="clearAllSelect();">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eOH.AcrossCharts.Label" bundle="${oh_labels}"/> 
			</fieldset>
			</td>	
			<td>&nbsp;</td>
			</tr>
		</table>
		<table width="100%"  cellspacing=0 border=0 id="myTable">
			<tr>
<!-- Columns Moved by rajesh for CRF 491.....on 18/01/2010 -->
		<td class='label' width='15%'>
			<fmt:message key="eOH.NumberingSystem.Label" bundle="${oh_labels}"/>
		</td>
				<td class="field" nowrap width='20%'>
					<select name="perio_numbering_system" id="perio_numbering_system">
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<%
							pstmt=con.prepareStatement("SELECT NUMBERING_SYSTEM, NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW WHERE LANGUAGE_ID = ? ORDER BY 2");
							pstmt.setString(1,locale);
							rs=pstmt.executeQuery();
							while(rs.next()){
								String DB_numbering_system = rs.getString("NUMBERING_SYSTEM");
								String DB_numbering_system_desc = rs.getString("NUMBERING_SYSTEM_DESC");
						%>
								<option value="<%=DB_numbering_system%>"><%=DB_numbering_system_desc%></option>
						<%
							}
						%>
					</select> <img src='../../eCommon/images/mandatory.gif'>
				</td>
		<td class='LABEL' width='15%'nowrap><fmt:message key="Common.Chart.label" bundle="${common_labels}"/></td>
				<td class="field" nowrap>
					<select name="perio_chart" id="perio_chart" onchange="PopulateListItem();">
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<%
		
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							sql="SELECT DISTINCT A.CHART_CODE, B.CHART_DESC FROM OH_PERIODONTAL_CHART_HDR A, OH_PERIODONTAL_CHART_DEF_HDR B WHERE A.CHART_CODE = B.CHART_CODE AND A.PATIENT_ID = ?  ORDER BY 2";
							
							pstmt=con.prepareStatement(sql);
							pstmt.setString(1,patient_id);
							rs=pstmt.executeQuery();
							while(rs.next()){
						%>
								<option value='<%=rs.getString("CHART_CODE")%>'><%=rs.getString("CHART_DESC")%></option>
						<%
							}
						%>
					</select> <img src='../../eCommon/images/mandatory.gif'>
				</td>


				<!--<td class='LABEL'  id='hide1'></td>
				<td class="field" id='hide2' ></td>-->
				<td class='LABEL' nowrap ><fmt:message key="Common.ViewBy.label" bundle="${common_labels}"/> </td>
				<td class='fields' nowrap>
				<SELECT name="quadrant" id="quadrant" >
					<option value="1" selected><fmt:message key="eOH.UpperBuccal.Label" bundle="${oh_labels}"/></option>
					<option value="2"><fmt:message key="eOH.UpperLingual.Label" bundle="${oh_labels}"/></option>
					<option value="3"><fmt:message key="eOH.LowerLingual.Label" bundle="${oh_labels}"/></option>
					<option value="4"><fmt:message key="eOH.LowerBuccal.Label" bundle="${oh_labels}"/></option>
				</SELECT>
				</td>
			</tr>
			
<tr >

			<td width='15%'class='label' nowrap  >
			<table><tr><td class='label' nowrap id='chart1' style="width:6px;height:6px;background-color:#F5BDFF">
					<fmt:message key="eOH.Baseline_Chart.Label" bundle="${oh_labels}"/>
				</td></tr></table>
			</td>
			<td class="fields" width='25%'>
			<select name="base_chart1" id="base_chart1" onchange="populateEvaluationListItem();">
				<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			</select>
			<img src='../../eCommon/images/mandatory.gif'>
		</td>
		<td class='label' nowrap  >
		<table><tr><td class='label' nowrap id='chart2' style="width:6px;height:6px;background-color:#91FFAB">
				<fmt:message key="eOH.Evaluation_Chart.Label" bundle="${oh_labels}"/>
		</td></tr></table>
		</td>
		<td width='22%'>
				<select name="eval_chart" id="eval_chart">
					<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
				</select>
				<img src='../../eCommon/images/mandatory.gif'>
			</td>	
		</td>
		<td class='label' nowrap  >
			<table><tr><td class='label' nowrap id='chart3' name='chart3'  style="visible:hidden;display:none;width:6px;height:6px;background-color:#FFBC70">
					<fmt:message key="eOH.Evaluation_Chart.Label" bundle="${oh_labels}"/>2
				</td></tr></table>
		</td>
		<td class="fields" nowrap id='chart3_value' name='chart3_value' style='visible:hidden;display:none'>
			<select name="base_chart2" id="base_chart2" >
				<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			</select>
				<img src='../../eCommon/images/mandatory.gif' >
			</td>
		</td>
			<td width='10%'>	
				<img src="../../eOH/images/Refresh.gif" alt="Refresh" onclick="refresh()"/>
			</td>
</tr>
		<input type = "hidden" name= "params" value = "<%=request.getQueryString()%>">
		<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
		<input type = "hidden" name= "chart_flag" value = "<%=chart_flag%>">
		<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
		<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
		<input type = "hidden" name= "tooth_numbering_system" value = "<%=tooth_numbering_system%>">
		<input type = "hidden" name= "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
		<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
		<input type = "hidden" name= "selected_val1" value = "">
		<input type = "hidden" name= "selected_val2" value = "">
		<input type = "hidden" name= "selected_val3" value = "">
		<input type = "hidden" name= "no_of_charts" value = "">
		
		
	</form>
	<script>
		changeNumberingSystem();
	</script>
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

