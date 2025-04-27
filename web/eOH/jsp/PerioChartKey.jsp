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
	
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter("encounter_id")) ;
	String patient_class = checkForNull(request.getParameter("patient_class")) ;
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String header_tab = checkForNull(request.getParameter("header_tab"));
	String show_new_active_yn = checkForNull(request.getParameter("show_new_active_yn"));

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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<!-- <fmt:message key="eOH.ConditionType.Label" bundle="${oh_labels}"/> -->
<%
try{
	con=ConnectionManager.getConnection(request);
%>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form name="perioChartRecordForm" id="perioChartRecordForm" action="../../servlet/eOH.PerioChartServlet" method="post" target="messageFrame">
		<table width="100%" cellpadding =2 cellspacing=0 border=0>
			<tr>
				<td class='CAGROUPHEADING' nowrap colspan="5" style="text-align:center"><fmt:message key="eOH.KeyToCharting.Label" bundle="${oh_labels}"/></td>
			</tr>
			<tr>
				<td class="columnHeader" nowrap><font size="1"><fmt:message key="Common.Component.label" bundle="${common_labels}"/></font></td>
				<td class="columnHeader" nowrap><font size="1"><fmt:message key="eOH.MinMax.Label" bundle="${oh_labels}"/></font></td>
				<!-- <td class="columnHeader"><font size="1">-</font></td>
				<td class="columnHeader"><font size="1">Max</font></td>
				<td class="columnHeader"><font size="1">(Red If <=)</font></td> -->
			</tr>
			 <%
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				pstmt=con.prepareStatement("SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, A.SEQUENCE_NO, A.MIN_VALUE, A.MAX_VALUE, A.CUT_OFF, B.SURFACES_APPL_YN, B.FORMULA_YN FROM  OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERIODONTAL_CHART_COMP B WHERE A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE ORDER BY B.SURFACES_APPL_YN, A.SEQUENCE_NO");
				pstmt.setString(1,perio_chart);
				rs=pstmt.executeQuery();
				int count = 0;	
				int surfaces_appl_count = 0;
				int surfaces_not_appl_count = 0;
				String appl_surface = "";
				String formula_yn = "";
				while(rs.next()){
					appl_surface = rs.getString("SURFACES_APPL_YN");
					//out.println("appl_surface :=="+appl_surface);
					if(rs.getString("SURFACES_APPL_YN").equals("N")){
			%>
						<tr>
			<%
							if(rs.getString("COMPONENT_CODE").equals("MITH")){
			%>
								<td class="label" nowrap><img src='../../eOH/images/MissingTeeth.gif' />&nbsp;&nbsp;<%=rs.getString("COMPONENT_SHORT_DESC_USER_DEF")%>:</td>
			<%
							}
							else if(rs.getString("COMPONENT_CODE").equals("LOC")){
			%>
								<td class="label" nowrap><img src='../../eOH/images/LOC.gif' />&nbsp;&nbsp;<%=rs.getString("COMPONENT_SHORT_DESC_USER_DEF")%>:</td>
			<%
							}
							else if(rs.getString("COMPONENT_CODE").equals("FUIN")){
			%>
								<td class="label" nowrap><img src='../../eOH/images/Furc1.gif' />&nbsp;<img src='../../eOH/images/Furc2.gif' />&nbsp;<img src='../../eOH/images/Furc3.gif' />&nbsp;&nbsp;<%=rs.getString("COMPONENT_SHORT_DESC_USER_DEF")%>:</td>
			<%
							}
							else{
			%>
								<td class="label" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=rs.getString("COMPONENT_SHORT_DESC_USER_DEF")%>:</td>
			<%
							}
			%> 
							<!-- <td class="label"><img src='../../eOH/images/MissingTeeth.gif' />&nbsp;&nbsp;<%=rs.getString("COMPONENT_SHORT_DESC_USER_DEF")%>:</td> -->
							<td class="label" nowrap><%=rs.getString("MIN_VALUE")%>&nbsp;-&nbsp;<%=rs.getString("MAX_VALUE")%>&nbsp;(<font color="red"><%=rs.getString("CUT_OFF")%></font>)</td>
						<!-- 	<td class="label">-</td>
							<td class="label"><%//=rs.getString("MAX_VALUE")%></td>
							<td class="label">(<font color="red"><%//=rs.getString("CUT_OFF")%></font>)</td> -->
							
						</tr>
			<%
						surfaces_appl_count++;
					}
			
					if(rs.getString("SURFACES_APPL_YN").equals("Y")){

						formula_yn = checkForNull(rs.getString("FORMULA_YN"));
						
						if(surfaces_not_appl_count == 0){
			%>
							<tr><td style="background-color:white"></tr></td>
			<%
						}
			%>
						<tr>
			<%
							if(formula_yn.equals("Y")){
			%>
								<td class="label" nowrap><img src='../../eOH/images/Formula.gif' />&nbsp;&nbsp;<%=rs.getString("COMPONENT_SHORT_DESC_USER_DEF")%>:</td>
			<%
							}
							else{
			%>
								<td class="label" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=rs.getString("COMPONENT_SHORT_DESC_USER_DEF")%>:</td>
			<%
							}
			%>
							<td class="label" nowrap><%=rs.getString("MIN_VALUE")%>&nbsp;-&nbsp;<%=rs.getString("MAX_VALUE")%>&nbsp;(<font color="red"><%=rs.getString("CUT_OFF")%></font>)</td>
						</tr>
			<%
					surfaces_not_appl_count++;
					}
						count++;
				}
			%>
		</table>
		
		<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
		<input type = "hidden" name= "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
		<input type = "hidden" name= "tooth_numbering_system" value = "<%=tooth_numbering_system%>">
		<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
		<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
		<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">
		<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
		<input type = "hidden" name= "header_tab" value = "<%=header_tab%>">
		<input type = "hidden" name= "perio_chart" value = "<%=perio_chart%>">
		<input type = "hidden" name= "show_new_active_yn" value = "<%=show_new_active_yn%>">
		<input type = "hidden" name= "chart_hdr_insert_yn" value = "">

		<input type = "hidden" name= "min_val" value = "">
		<input type = "hidden" name= "max_val" value = "">
		 <input type = "hidden" name= "surfaces_appl" value = ""> 
		
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

