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
	
	String disabled = "";
	String params					= request.getQueryString();
	String tooth_numbering_system	= checkForNull(request.getParameter("tooth_numbering_system"));
	String upper_arch_desc			= checkForNull(request.getParameter("upper_arch_desc"));
	String lower_arch_desc			= checkForNull(request.getParameter("lower_arch_desc"));
	String Q1_id					= checkForNull(request.getParameter("Q1_id"));
	String Q2_id					= checkForNull(request.getParameter("Q2_id"));
	String Q3_id					= checkForNull(request.getParameter("Q3_id"));
	String Q4_id					= checkForNull(request.getParameter("Q4_id"));
	String Q1_desc					= checkForNull(request.getParameter("Q1_desc"));
	String Q2_desc					= checkForNull(request.getParameter("Q2_desc"));
	String Q3_desc					= checkForNull(request.getParameter("Q3_desc"));
	String Q4_desc					= checkForNull(request.getParameter("Q4_desc"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String mixed_dentition_YN        = checkForNull(request.getParameter("mixed_dentition_YN"));
	String date_diff_flag        = checkForNull(request.getParameter("date_diff_flag"));
	String chart_num        = checkForNull(request.getParameter("chart_num"));
	String ca_practitioner_id = (String)session.getValue("ca_practitioner_id") ;
	String option_id = checkForNull(request.getParameter("option_id"));
	String sex = checkForNull(request.getParameter("Sex"));
	String dob = checkForNull(request.getParameter("Dob"));
	String bed_num = checkForNull(request.getParameter("bed_num"));
	String room_num = checkForNull(request.getParameter("room_num"));
	String visit_adm_date = checkForNull(request.getParameter("visit_adm_date"));
	String called_from = checkForNull(request.getParameter("called_from"));

	//String patient_id = "SD00000085";//request.getParameter( "patient_id" ) ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter( "encounter_id" )) ;
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_class = checkForNull(request.getParameter("patient_class"));
	String speciality_code = checkForNull(request.getParameter("speciality_code"));
	String location_code = checkForNull(request.getParameter("location_code"));
	String chart_type = checkForNull(request.getParameter( "chart_type" )) ;
	String episode_type = checkForNull(request.getParameter( "episode_type" )) ;
	String header_tab = checkForNull(request.getParameter( "header_tab" )) ;
	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;

String visit_id = checkForNull(request.getParameter( "visit_id" )) ; String source_code = checkForNull(request.getParameter( "location_code" )) ; String source_type = checkForNull(request.getParameter( "location_type" )) ; //String enterprise_specific_flag = checkForNull(request.getParameter( "enterprise_specific_flag" )) ;//added by parul for Enterprise Specific Chart Applicable

	//out.println("enterprise_specific_flag:"+enterprise_specific_flag);

	String record_gingival_status_yn_param = checkForNull(request.getParameter( "record_gingival_status_yn_param" )) ;
	// added by parul  for other facility chart CRF#0423
	String other_facilitychart_yn = checkForNull(request.getParameter( "other_facilitychart_yn" )) ;
	String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
	String other_facility_yn = checkForNull(request.getParameter( "other_facility_yn" )) ;
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	 }

	//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
	String dflt_mixed_dentition_chart = checkForNull(request.getParameter( "dflt_mixed_dentition_chart" )) ;
	
	if(date_diff_flag.equals("disable")){
		disabled = "disabled";
	}
	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Used to disable the chart once the APP-OH000153 message is displayed and on cancel.
	String chart_disable_from_main = checkForNull(request.getParameter( "chart_disable_from_main" )) ;
	//End
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//String sql = "";
	//String trmt_cond_date = "";
	//String cond_trmt_type = "";
	String gingival_recording_by = "";

	String gs_dflt_tooth_no_s1 = "";
	String gs_dflt_tooth_no_s2 = "";
	String gs_dflt_tooth_no_s3 = "";
	String gs_dflt_tooth_no_s4 = "";
	String gs_dflt_tooth_no_s5 = "";
	String gs_dflt_tooth_no_s6 = "";

	String gs_dflt_tooth_no_q1 = "";
	String gs_dflt_tooth_no_q2 = "";
	String gs_dflt_tooth_no_q3 = "";
	String gs_dflt_tooth_no_q4 = "";

	
	//ArrayList arrList = new ArrayList();


try{
	con = ConnectionManager.getConnection(request);

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	if(oh_chart_level.equals("E")){
		pstmt = con.prepareStatement("SELECT GINGIVAL_RECORDING_BY,GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4,GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM");
	}else{//End
		pstmt = con.prepareStatement("SELECT GINGIVAL_RECORDING_BY,GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4,GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
		//pstmt.setString(1,facility_id);
		pstmt.setString(1,other_chart_facility_id);
	}
	rs = pstmt.executeQuery();
	while (rs != null && rs.next()){
		gingival_recording_by = checkForNull(rs.getString("GINGIVAL_RECORDING_BY"));
		gs_dflt_tooth_no_q1 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q1"));
		gs_dflt_tooth_no_q2 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q2"));
		gs_dflt_tooth_no_q3 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q3"));
		gs_dflt_tooth_no_q4 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q4"));

		gs_dflt_tooth_no_s1 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S1"));
		gs_dflt_tooth_no_s2 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S2"));
		gs_dflt_tooth_no_s3 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S3"));
		gs_dflt_tooth_no_s4 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S4"));
		gs_dflt_tooth_no_s5 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S5"));
		gs_dflt_tooth_no_s6 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S6"));
	}

%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eOH/js/OHCondDentalChartViewDetails.js'></script>
		<script language='javascript' src='../../eOH/js/OHCommon.js'></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form name="condViewDetailsForm" id="condViewDetailsForm">
			<table width="100%" border="0" cellspacing="0" cellpadding="1">
				
				<tr>
					<td valign="top"><table width="100%" border="0" cellspacing="1" cellpadding="1">
						<tr>
							<td><table width="100%" border="0" >
								<tr>
								<th align="left"><fmt:message key='eOH.Conditions.Label' bundle='${oh_labels}'/></th>
								<th align="right" width="10%"><img name="DC_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuDC',this);" /></th>
								</tr>
							</table></td>
						</tr>
						<tr>
						<div id="menuExpand1 style='visibility:hidden;display:none'">
							<td id="menuDC" style='display:none'>
							</td>
						</div>
						</tr>
						<tr>
							<td><table width="100%" border="0" >
								<tr>
									<th align="left"><fmt:message key='eOH.ExtTreatments.Label' bundle='${oh_labels}'/></th>
									<th align="right" width="10%"><img name="ET_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuET',this);" /></th>
								</tr>
							</table></td>
						</tr>
						<tr>
						<div id="menuExpand2 style='visibility:hidden;display:none'">
							<td id="menuET" style='display:none'>
							</td>
						</div>
						</tr>
						<%
						//	if(record_gingival_status_yn_param.equals("Y") && (permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N"))){
							if(record_gingival_status_yn_param.equals("Y")){
						%>
						<tr>
							<td><table width="100%" border="0" >
								<tr>
									<th align="left"><fmt:message key='eOH.GingivalStatus.Label' bundle='${oh_labels}'/></th>
									<th align="right" width="10%"><img name="GS_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuGS',this);" /></th>
								</tr>
							</table></td>
						</tr>

						<%
							}
						%>
						<tr>
						<div id="menuExpand4 style='visibility:hidden;display:none'">
							<td id="menuGS" style='display:none'>
							</td>
						</div>
						</tr>
				 	  <%
						 //  if (permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
					  %> 
						<tr>
							<td><table width="100%" border="0" >
								<tr>
									<th align="left" >
									<fmt:message key="Common.Summary.label" bundle="${common_labels}"/></th>
									<th align="right" width="10%"><img name="GS_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuSummary',this);" /></th>
								</tr>
							</table></td>
						</tr>
						 <%
						//	}
						%> 
						<tr>
						<div id="menuExpand1 style='visibility:hidden;display:none'">
							<td id="menuSummary" style='display:none'>
							</td>
						</div>
						</tr>
						<tr>
							<td><table width="100%" border="0" >
								<tr>
									<th align="left"><fmt:message key='eOH.BaselineCharts.Label' bundle='${oh_labels}'/></th>
									<th align="right" width="10%"><img name="BC_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuBC',this);" /></th>
								</tr>
							</table></td>
						</tr>
						<tr>
						<div id="menuExpand3 style='visibility:hidden;display:none'">
							<td id="menuBC" style='display:none'>
							</td>
						</div>
						</tr>
						<!-- added by parul for Enterprise Specific Chart Applicable -->
						<%
                             if (oh_chart_level.equals("F")){							
						%>
								<tr>
									<td><table width="100%" border="0" >
										<tr>
											<th align="left"><fmt:message key='eOH.OtherFacilityCharts.Label' bundle='${oh_labels}'/></th>
											<th align="right" width="10%"><img name="FC_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuFC',this);" /></th>
										</tr>
									</table></td>
								</tr>
						<%
							}
						%>
								<tr>
								<div id="menuExpand3 style='visibility:hidden;display:none'">
									<td id="menuFC" style='display:none'>
									</td>
								</div>
								</tr>
						
						<!-- <tr>
							<td><table width="100%" border="0" >
								<tr>
									<th align="left"><fmt:message key='eOH.GingivalStatus.Label' bundle='${oh_labels}'/>Marked Error Conditions</th>
									<th align="right" width="10%"><img name="ME_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuME',this);" /></th>
								</tr>
							</table></td>
						</tr>
						<tr>
						<div id="menuExpand5 style='visibility:hidden;display:none'">
							<td id="menuME" style='display:none'>
							</td>
						</div>
						</tr> -->
						
						<!--
						<tr>
							<td><table width="100%" border="0" >
								<tr>
									<th align="left" ><fmt:message key='Common.ClinicalNotes.label' bundle='${common_labels}'/></th>
									<th align="right" width="10%"><img name="CN_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuCN',this);" /></th>
								</tr>
							</table></td>
						</tr>
						<tr>
						<div id="menuExpand4 style='visibility:hidden;display:none'">
							<td id="menuCN" style='display:none'>
							</td>
						</div>
						</tr>
						-->
						<% if(!called_from.equals("OT")){%>
						<tr>
							<td><table width="100%" border="0" >
								<tr>
									<th align="left"><fmt:message key='eOH.OtherLinks.Label' bundle='${oh_labels}'/></th>
									<th align="right"  width="10%"><img name="OL_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuOL',this);" /></th>
								</tr>
							</table></td>
						</tr>
						<tr>
						<div id="menuExpand5 style='visibility:hidden;display:none'">
							<td id="menuOL" style='display:none'>
							</td>
						</div>
						</tr>
						<% } %>
					</table></td>
				</tr>
            </table>

			<input type = "hidden" name= "params" value = "<%=params%>">
			<input type = "hidden" name= "locale" value = "<%=locale%>">
			<input type = "hidden" name= "tooth_numbering_system" value = "<%=tooth_numbering_system%>">
			<input type = "hidden" name= "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
			<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
			<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
			<input type = "hidden" name= "episode_id" value = '<%=checkForNull(request.getParameter("episode_id"))%>'>
			<input type = "hidden" name= "episode_type" value = '<%=episode_type%>'>
			<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">

			<input type = "hidden" name= "visit_id" value = "<%=visit_id%>">
			<input type = "hidden" name= "source_code" value = "<%=source_code%>">
			<input type = "hidden" name= "source_type" value = "<%=source_type%>">
			

			<input type = "hidden" name= "upper_arch_desc" value = "<%=upper_arch_desc%>">
			<input type = "hidden" name= "lower_arch_desc" value = "<%=lower_arch_desc%>">
			<input type = "hidden" name= "Q1_id" value = "<%=Q1_id%>">
			<input type = "hidden" name= "Q2_id" value = "<%=Q2_id%>">
			<input type = "hidden" name= "Q3_id" value = "<%=Q3_id%>">
			<input type = "hidden" name= "Q4_id" value = "<%=Q4_id%>">
			<input type = "hidden" name= "Q1_desc" value = "<%=Q1_desc%>">
			<input type = "hidden" name= "Q2_desc" value = "<%=Q2_desc%>">
			<input type = "hidden" name= "Q3_desc" value = "<%=Q3_desc%>">
			<input type = "hidden" name= "Q4_desc" value = "<%=Q4_desc%>">
			<input type = "hidden" name= 'mixed_dentition_YN' value=<%=mixed_dentition_YN%> >
			<input type = "hidden" name= 'chart_type' value=<%=chart_type%> >
			<input type = "hidden" name= 'header_tab' value=<%=header_tab%> >
			<input type = "hidden" name= 'facility_id' value=<%=facility_id%> >
			<input type = "hidden" name= 'baseline_chart_yn' value=<%=baseline_chart_yn%> >
			<input type = "hidden" name= 'chart_num' value='<%=checkForNull(request.getParameter("new_chart_num"))%>' >
			<input type = "hidden" name= 'ca_practitioner_id' value='<%=ca_practitioner_id%>' >
			<input type = "hidden" name= 'option_id' value='<%=option_id%>' >
			<input type = "hidden" name= 'called_from' value='<%=called_from%>' >
			
			<input type = "hidden" name= 'chart_line_num' value='<%=checkForNull(request.getParameter("chart_line_num"))%>' >
			<input type = "hidden" name= 'perio_chart' value='<%=checkForNull(request.getParameter("perio_chart"))%>' >
			<input type = "hidden" name= 'perio_arch' value='<%=checkForNull(request.getParameter("perio_arch"))%>' >
			<input type = "hidden" name= "RD_Normal_yn" value = ""> 
            <input type="hidden" name="quadrant_sno" id="quadrant_sno" value='<%=checkForNull(request.getParameter("quadrant_sno"))%>' >
            <input type="hidden" name="cur_chart_num" id="cur_chart_num" value='<%=chart_num%>' >
            <input type="hidden" name="speciality_code" id="speciality_code" value='<%=speciality_code%>' >
            <input type="hidden" name="location_code" id="location_code" value='<%=location_code%>' >
            <input type="hidden" name="record_gingival_status_yn_param" id="record_gingival_status_yn_param" value='<%=record_gingival_status_yn_param%>' >
			<!--  added by parul  for other facility chart CRF#0423 -->
            <input type="hidden" name="other_facilitychart_yn" id="other_facilitychart_yn" value='<%=other_facilitychart_yn%>' >
            <input type="hidden" name="other_chart_facility_id" id="other_chart_facility_id" value='<%=other_chart_facility_id%>' >
            <input type="hidden" name="oh_chart_level" id="oh_chart_level" value='<%=oh_chart_level%>' >
            <input type="hidden" name="other_facility_yn" id="other_facility_yn" value='<%=other_facility_yn%>' >
			
            <input type="hidden" name="date_diff_flag" id="date_diff_flag" value='<%=date_diff_flag%>' >

            <input type="hidden" name="gingival_recording_by" id="gingival_recording_by" value='<%=gingival_recording_by%>' >
			<input type="hidden" name="gs_dflt_tooth_no_s1" id="gs_dflt_tooth_no_s1" value="<%=gs_dflt_tooth_no_s1%>">
			<input type="hidden" name="gs_dflt_tooth_no_s2" id="gs_dflt_tooth_no_s2" value="<%=gs_dflt_tooth_no_s2%>">
			<input type="hidden" name="gs_dflt_tooth_no_s3" id="gs_dflt_tooth_no_s3" value="<%=gs_dflt_tooth_no_s3%>">
			<input type="hidden" name="gs_dflt_tooth_no_s4" id="gs_dflt_tooth_no_s4" value="<%=gs_dflt_tooth_no_s4%>">
			<input type="hidden" name="gs_dflt_tooth_no_s5" id="gs_dflt_tooth_no_s5" value="<%=gs_dflt_tooth_no_s5%>">
			<input type="hidden" name="gs_dflt_tooth_no_s6" id="gs_dflt_tooth_no_s6" value="<%=gs_dflt_tooth_no_s6%>">

			<input type="hidden" name="gs_dflt_tooth_no_q1" id="gs_dflt_tooth_no_q1" value="<%=gs_dflt_tooth_no_q1%>">
			<input type="hidden" name="gs_dflt_tooth_no_q2" id="gs_dflt_tooth_no_q2" value="<%=gs_dflt_tooth_no_q2%>">
			<input type="hidden" name="gs_dflt_tooth_no_q3" id="gs_dflt_tooth_no_q3" value="<%=gs_dflt_tooth_no_q3%>">
			<input type="hidden" name="gs_dflt_tooth_no_q4" id="gs_dflt_tooth_no_q4" value="<%=gs_dflt_tooth_no_q4%>">
			<!--Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782-->
			<input type="hidden" name="dflt_mixed_dentition_chart" id="dflt_mixed_dentition_chart" value="<%=dflt_mixed_dentition_chart%>">
			<!-- Added by Sharon Crasta on 1/11/2010 for IN017822-->
			<input type="hidden" name="chart_disable_from_main" id="chart_disable_from_main" value="<%=chart_disable_from_main%>">

			<!-- Parameters for Diagnosis function -->
			<input type="hidden" name="sex" id="sex" value='<%=sex%>' >
			<input type="hidden" name="dob" id="dob" value='<%=dob%>' >
			<input type="hidden" name="bed_num" id="bed_num" value='<%=bed_num%>' >
			<input type="hidden" name="room_num" id="room_num" value='<%=room_num%>' >
			<input type="hidden" name="visit_adm_date" id="visit_adm_date" value='<%=visit_adm_date%>' >
			
		</form>
		<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>	
	</div>
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

