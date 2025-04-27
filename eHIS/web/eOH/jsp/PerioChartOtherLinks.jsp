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
	//String sql = "";
	String q1_sno = "";
	String q2_sno = "";
	String disabled = "";
	String params = request.getQueryString();
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter("encounter_id")) ;
	String episode_id = checkForNull(request.getParameter("episode_id")) ;
	String patient_class = checkForNull(request.getParameter("patient_class")) ;
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String header_tab = checkForNull(request.getParameter("header_tab"));
	String show_new_active_yn = checkForNull(request.getParameter("show_new_active_yn"));
	//String chart_hdr_insert_yn = checkForNull(request.getParameter("chart_hdr_insert_yn"));

	String perio_chart = checkForNull(request.getParameter("perio_chart"));
	String perio_arch = checkForNull(request.getParameter("perio_arch"));
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	String speciality_code = checkForNull(request.getParameter("speciality_code"));
	String location_code = checkForNull(request.getParameter("location_code"));
	String location_type = checkForNull(request.getParameter("location_type"));
	String episode_type = checkForNull(request.getParameter("episode_type"));
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
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eOH/js/PerioChart.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<!-- <fmt:message key="eOH.ConditionType.Label" bundle="${oh_labels}"/> -->
<%
try{
	con=ConnectionManager.getConnection(request);
%>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form name="perioChartOtherLinks" id="perioChartOtherLinks" method="post" target="messageFrame">

			<table width="100%" border="0" cellspacing="0" cellpadding="1">
				<tr>
					<td valign="top"><table width="100%" border="0" cellspacing="1" cellpadding="1">
						<tr>
							<td><table width="100%" border="0" >
								<tr>
								<th align="left"><fmt:message key='eOH.OtherLinks.Label' bundle='${oh_labels}'/></th>
								<th align="right" width="10%"><img name="OTHER_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenuOther('menuOTHER',this);" <%=disabled%>/></th>
								</tr>
							</table></td>
						</tr>
						<tr>
						<div id="menuExpand2 style='visibility:hidden;display:none'">
							<td id="menuOTHER" style='display:none'>
							</td>
						</div>
						</tr>
					</table></td>

				</tr>
			</table>

		<input type = "hidden" name= "locale" value = "<%=locale%>">
		<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
		<input type = "hidden" name= "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
		<input type = "hidden" name= "tooth_numbering_system" value = "<%=tooth_numbering_system%>">
		<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
		<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
		<input type = "hidden" name= "episode_id" value = "<%=episode_id%>">
		<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">
		<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
		<input type = "hidden" name= "header_tab" value = "<%=header_tab%>">
		<input type = "hidden" name= "perio_chart" value = "<%=perio_chart%>">
		<input type = "hidden" name= "show_new_active_yn" value = "<%=show_new_active_yn%>">
		<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
		<input type = "hidden" name= "chart_hdr_insert_yn" value = "">
		<input type = "hidden" name= "speciality_code" value = "<%=speciality_code%>">
		<input type = "hidden" name= "location_code" value = "<%=location_code%>">
		<input type = "hidden" name= "location_type" value = "<%=location_type%>">
		<input type = "hidden" name= "episode_type" value = "<%=episode_type%>">
		<input type = "hidden" name= "params" value = "<%=params%>">

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

