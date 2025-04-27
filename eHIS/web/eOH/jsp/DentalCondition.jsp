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
	String disabled = "";											  
	//String disabled1 = "";

	String params = request.getQueryString();
	String facility_id = (String)session.getValue("facility_id") ;
	String ca_practitioner_id = (String)session.getValue("ca_practitioner_id") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter("encounter_id")) ;
	String patient_class = checkForNull(request.getParameter("patient_class")) ;
	String mixed_dentition_YN = checkForNull(request.getParameter("mixed_dentition_YN")) ;

	String episode_id = checkForNull(request.getParameter("episode_id")) ;
	String episode_type = checkForNull(request.getParameter("episode_type")) ;
	String visit_id = checkForNull(request.getParameter("visit_id")) ;
	String location_code = checkForNull(request.getParameter("location_code")) ;
	String location_type = checkForNull(request.getParameter("location_type")) ;

	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String ref_tooth_no = checkForNull(request.getParameter("ref_tooth_no"));
	String code = checkForNull(request.getParameter("code"));
	String site = checkForNull(request.getParameter("site"));
	String type = checkForNull(request.getParameter("type"));
	String arch_quad = checkForNull(request.getParameter("arch_quad"));
	String thrng_nos = checkForNull(request.getParameter("thrng_nos"));
	String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
	String chart_type = checkForNull(request.getParameter( "chart_type" )) ;
	String header_tab = request.getParameter( "header_tab" ) ;
	String show_new_active_yn = checkForNull(request.getParameter( "show_new_active_yn" )) ;
	String thrng_nos_ref = checkForNull(request.getParameter( "thrng_nos_ref" )) ;
	String called_from_viewchart_yn = checkForNull(request.getParameter( "called_from_viewchart_yn" )) ;
	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
	String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
	String surface = checkForNull(request.getParameter( "surface" )) ;

	String flag = checkForNull(request.getParameter( "flag" )) ;
	String selected_first_thno = checkForNull(request.getParameter( "selected_first_thno" )) ;
	String addNewChart_yn = checkForNull(request.getParameter( "addNewChart_yn" )) ;
	String date_diff_flag = checkForNull(request.getParameter( "date_diff_flag" )) ;
	String cusp_tip_code = checkForNull(request.getParameter( "cusp_tip_code" )) ;
	String maxila_area = checkForNull(request.getParameter( "maxila_area" )) ;
	String maxila_parts = checkForNull(request.getParameter( "maxila_parts" )) ;
	String maxila_sub_parts = checkForNull(request.getParameter( "maxila_sub_parts" )) ;

	String add_new_yn = checkForNull(request.getParameter( "add_new_yn" )) ;
	String other_facilitychart_yn = checkForNull(request.getParameter( "other_facilitychart_yn" )) ; //added by parul  for other facility chart CRF#0423
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ; //added by parul  for other facility chart CRF#0423
	//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field .
	String remarks = checkForNull(request.getParameter( "remarks" )) ;
	String remarks_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Used to disable the chart once the APP-OH000153 message is displayed and on cancel.
	String chart_disable_from_main = checkForNull(request.getParameter( "chart_disable_from_main" )) ;
	
	//if(baseline_chart_yn .equals("Y") || date_diff_flag.equals("disable") || other_facilitychart_yn.equals("N")) { //added by parul  for other facility chart CRF#0423
	if(baseline_chart_yn .equals("Y") || date_diff_flag.equals("disable") || other_facilitychart_yn.equals("N") || chart_disable_from_main.equals("Y")) { //added by parul  for other facility chart CRF#0423
		disabled = "disabled";
	}
	//End
		
	if(baseline_chart_yn.equals("N")  && other_facilitychart_yn.equals("Y")) { //added by parul  for other facility chart CRF#0423
		disabled = "disabled";
	}

  	String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}
	//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
	String dentist_comments = checkForNull(request.getParameter( "dentist_comments" )) ;

	String flag1 = checkForNull(request.getParameter( "flag1" )) ;//Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages
	String super_key_num = checkForNull(request.getParameter( "super_key_num" )) ;//Added by Sridevi Joshi on 1/20/2010 for SUPRTH chnages CRF-481(IN010894)

	//out.println("flag1:==="+flag1);
	//out.println("flag:==="+flag);
	//out.println("super_key_num:==="+super_key_num);
	
	/*
	Parameters Meanings/Descripts
		thrng_nos: is display value(Ex: 18,17,16....)
		thrng_nos_ref: is internal no (Ex:1,2,3,4 .....)
		arch_quad: arch or quad description
		code: condition_code
		type: Condition_type
		site: site_type
		show_new_active_yn: Used in Mixed Dentition Case, whether to show new active chart or not
	*/
%>

<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
	<script language="javascript" src="../../eOH/js/DentalCondition.js"></script>
	<script language="javascript" src="../../eOH/js/OHDentalChart.js"></script>
	<script src="../../eOH/js/DrawShapes.js" language="javascript"></script>
	<script src="../../eOH/js/FillImages.js" language="javascript"></script>
	<script src="../../eOH/js/GetImages.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<%
try{
	con=ConnectionManager.getConnection(request);
%>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<!-- <body onLoad= "setValuesFromMenu('<%=type%>','<%=site%>','<%=code%>','<%=arch_quad%>','<%=thrng_nos%>','<%=ref_tooth_no%>','<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>','<%=surface%>','<%=flag%>','<%=cusp_tip_code%>');"OnMouseDown='CodeArrest()' onKeyDown="lockKey()"> -->
	<form name="OHConditionForm" id="OHConditionForm" action="../../servlet/eOH.OHDentalChartServletNew" method="post" target="messageFrame">
		<table width="100%" cellpadding =4 cellspacing=0>
			<tr>
				<td width="20%" class='LABEL' nowrap><fmt:message key="eOH.ConditionType.Label" bundle="${oh_labels}"/></td>
				<td width="25%" class="field">
						<select name="oh_condition_type" id="oh_condition_type" onChange='populateSiteOptions(this);populateDentalcondition(this);clearArea("conditionType");' <%=disabled%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						 <%
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								sql="SELECT CONDITION_TYPE, CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW WHERE LANGUAGE_ID=? AND SPLTY_MODULE_ID = ? ORDER BY 2";
								pstmt=con.prepareStatement(sql);
								pstmt.setString(1,locale);
								pstmt.setString(2,"OH");
								rs=pstmt.executeQuery();
								
								while(rs.next()){
									if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
										if(!rs.getString("CONDITION_TYPE").equals("DECITH")){
						%>
											<option value='<%=rs.getString("CONDITION_TYPE")%>'><%=rs.getString("CONDITION_TYPE_DESC")%></option>
						<%
										}
									}
									else if(mixed_dentition_YN.equals("N")){
										if(permanent_deciduous_flag.equals("D")){
											if(!rs.getString("CONDITION_TYPE").equals("DECITH") && !rs.getString("CONDITION_TYPE").equals("RTDESTH")){
						%>
												<option value='<%=rs.getString("CONDITION_TYPE")%>'><%=rs.getString("CONDITION_TYPE_DESC")%></option>
						<%
											}
										}
										else if(permanent_deciduous_flag.equals("P")){
											if(!rs.getString("CONDITION_TYPE").equals("DECITH")){
						%>
												<option value='<%=rs.getString("CONDITION_TYPE")%>'><%=rs.getString("CONDITION_TYPE_DESC")%></option>
						<%
											}
										}
									}
									else{
						%>
											<option value='<%=rs.getString("CONDITION_TYPE")%>'><%=rs.getString("CONDITION_TYPE_DESC")%></option>
						<%
									}
								}
						%>
					</select> 
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td width="20%" class='LABEL' nowrap ><fmt:message key="Common.Site.label" bundle="${common_labels}"/></td>
				<td width="25%" class="field" nowrap>
					<select name="oh_site" id="oh_site" onchange="getAreaLegendFromPage(this);populateAreaFromPage(this,'<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>','<%=ref_tooth_no%>');enableDisableSurface(this,'<%=type%>');enableDisableCuspTip(this);clearArea('site');getSurfaceLegendFromPage(this);populateSurfacesFromPage(this);" <%=disabled%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
					<img src='../../eCommon/images/mandatory.gif' >
				</td>
			</tr>
			<!-- <tr>
				<td colspan = '4'><a href='javascript:retieveHistory();'>History</a></td>
			</tr> -->
			<!-- <tr>
				<td colspan = '4'><a href='javascript:window.open("OHDiagLinkedConditionsFrame.jsp")'>Diag Details</a></td>
			</tr> -->
			<!-- <tr>
				<td colspan = '4'><a href='javascript:tempDiagDetail();'>Diag Details</a></td>
			</tr> -->
			<tr>
				<td width="20%" class='LABEL' nowrap id="change_area"></td>
				<td width="25%" class="field" id="area_field" <%=disabled%>></td>
				<td width="20%" class='LABEL' nowrap><fmt:message key="eOH.DentalCondition.Label" bundle="${oh_labels}"/></td>
				<td width="30%" class="field" nowrap>
					<select name="oh_dental_condition" id="oh_dental_condition" <%=disabled%>>
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
					<img src='../../eCommon/images/mandatory.gif' >
				</td>
			</tr>
			<tr>
			<!-- commented by parul on 11/09/08 -->
				<!--  <td width="20%" class='LABEL' nowrap><fmt:message key="eOH.Surface.Label" bundle="${oh_labels}"/></td>
				<td width="25%" class="field">
					<select name="oh_surface" id="oh_surface" onChange="populateCuspTip(this);" <%=disabled%>>
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
					<IMG id='MandatorySurface' style='visibility:hidden' name='MandatorySurface' border="0" src='../../eCommon/images/mandatory.gif'>
				</td>    -->

				<!--    added  by SRR-CRF20056-0442 on 12/01/2010-->
			 <td width="20%" class='LABEL' nowrap id="change_surface"><fmt:message key="eOH.Surface.Label" bundle="${oh_labels}"/></td>
				<td width="25%" class="field" id='surface_field'>
					<select name="oh_surface" id="oh_surface" size=3 multiple onChange="populateCuspTip(this);"<%=disabled%>>
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
					<IMG id='MandatorySurface' style='visibility:hidden' name='MandatorySurface' border="0" src='../../eCommon/images/mandatory.gif'> 
				<!-- multiple option added by parul on 14/08/2009 for CRF#483 -->
				<td width="20%" class='LABEL' nowrap><fmt:message key="eOH.CuspTip.Label" bundle="${oh_labels}"/></td>
				<td width="25%" class="field" id='cusp_field'>
					<select name="oh_cusp_tip" id="oh_cusp_tip"  size=3 multiple <%=disabled%>>
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
								
				</td>
			</tr>
			<tr>
			<%
				if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
			%>
			<%
							
			%>
				<td width="25%" class='LABEL' nowrap id="status_legend"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td width="25%" class="field" id="status_show_yn">
					<select name="oh_status" id="oh_status" <%=disabled%>>
						<option value="E"><fmt:message key="Common.MarkError.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<!--Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field .-->
				<td width="25%">
					<font color="blue"><a onclick="showOperRemarks('<%=remarks_title%>','<%=locale%>')" style="cursor:pointer"><%=remarks_title%></a></font><IMG id='MandatoryRemarks' style='visibility:hidden' name='MandatoryRemarks' border="0" src='../../eCommon/images/mandatory.gif'>
				</td>
				<!-- -->
				<td width="25%" colspan="2" class="button">
					<input type="button" class="button" name="save" id="save" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'  onclick ="actionToServlet()" <%=disabled%> >&nbsp;
					<input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>'  onclick="DC_Tab_Reset(document.forms[0])" <%=disabled%>>
				</td>
			
			<%
				}else {
			%>

				<input type="hidden" name='oh_status' id='oh_status' value="" >
				<td width="25%">
					<font color="blue"><a onclick="showOperRemarks('<%=remarks_title%>','<%=locale%>')" style="cursor:pointer"><%=remarks_title%></a></font><IMG id='MandatoryRemarks' style='visibility:hidden' name='MandatoryRemarks' border="0" src='../../eCommon/images/mandatory.gif'>
				</td>
				<td width="25%" class='LABEL' colspan="2"></td>
				<td width="25%" colspan="2" class="button">
					<input type="button" class="button" name="save" id="save" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'  onclick ="actionToServlet()" <%=disabled%>>&nbsp;
					<!-- Commented by Sharon Crasta on 7/27/2009 for Print Preview-->
				<!-- 	<input type="button" class="button" name="Print Chart" id="Print Chart" value='Print Preview' onclick="printOverview();"> -->
					<input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>'  onclick="DC_Tab_Reset_button(document.forms[0])" <%=disabled%>>
					<!-- <input type="button" class="button" name="Print" id="Print" value='Print' onclick="framePrint(parent.parent.conditionDentalChartDetails);"> -->
					
				</td>


			<%
				}
			%>
			</tr>
		</table>
		<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
		<input type = "hidden" name= "ca_practitioner_id" value = "<%=ca_practitioner_id%>">
		<input type = "hidden" name= "episode_id" value = "<%=episode_id%>">
		<input type = "hidden" name= "episode_type" value = "<%=episode_type%>">
		<input type = "hidden" name= "visit_id" value = "<%=visit_id%>">
		<input type = "hidden" name= "location_code" value = "<%=location_code%>">
		<input type = "hidden" name= "location_type" value = "<%=location_type%>">
		<input type = "hidden" name= "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
		<input type = "hidden" name= "mixed_dentition_YN" value = "<%=mixed_dentition_YN%>">

		<input type = "hidden" name= "tooth_numbering_system" value = "<%=tooth_numbering_system%>">
		<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
		<input type = "hidden" name= "chart_type" value = "<%=chart_type%>">
		<input type = "hidden" name='header_tab' id='header_tab' value=<%=header_tab%> >
		<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
		<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
		<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">
		<input type = "hidden" name= "tab_name" value = "DC">
		<input type="hidden" name='show_new_active_yn' id='show_new_active_yn' value=<%=show_new_active_yn%> >
		<input type="hidden" name='chart_hdr_insert_yn' id='chart_hdr_insert_yn' value="" >
		<input type="hidden" name='thrng_nos_ref' id='thrng_nos_ref' value="<%=thrng_nos_ref%>" >
		<input type="hidden" name='thrng_nos' id='thrng_nos' value="<%=thrng_nos%>" >
		<input type="hidden" name='called_from_viewchart_yn' id='called_from_viewchart_yn' value="<%=called_from_viewchart_yn%>" >
		<input type="hidden" name='chart_line_num' id='chart_line_num' value="<%=chart_line_num%>" >
		<input type="hidden" name='clinical_group_code' id='clinical_group_code' value="" >
		<input type = "hidden" name= "clinical_group_hid" value = ""> 
		<input type = "hidden" name= "surface_hid" value = "<%=surface%>"> 
		<input type = "hidden" name= "decith_yn" value = ""> 
		<input type = "hidden" name= "params" value = ""> 
		<input type = "hidden" name= "ca_params" value = "<%=params%>"> 
		<input type = "hidden" name= "RD_Normal_yn" value = "<%=flag%>"> 
		<input type = "hidden" name= "selected_first_thno" value = "<%=selected_first_thno%>"> 
		<input type = "hidden" name= "addNewChart_yn" value = "<%=addNewChart_yn%>"> 
		<input type = "hidden" name= "date_diff_flag" value = "<%=date_diff_flag%>"> 
		<input type="hidden" name="called_from_viewchart_gingival" id="called_from_viewchart_gingival" value="N" > 
		<input type="hidden" name="add_new_yn" id="add_new_yn" value="<%=add_new_yn%>" >
		<!--Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks -->
		<input type = "hidden" name= "remarks" value = "<%=remarks%>">
		<input type = "hidden" name= "other_facilitychart_yn" value = "<%=other_facilitychart_yn%>">
		<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
		<input type = "hidden" name= "other_chart_facility_id" value = "<%=other_chart_facility_id%>">
		<!-- Added by Sharon Crasta on 1/11/2010 for IN017822-->
		<input type="hidden" name='chart_disable_from_main' id='chart_disable_from_main' value="<%=chart_disable_from_main%>" >
		<!-- -->
						

		<!-- These variables are used in the developing Menu -->
		<input type="hidden" name="function_id_list" id="function_id_list" value="">		
		<input type="hidden" name="function_name_list" id="function_name_list" value="">		
		<input type="hidden" name="function_type_list" id="function_type_list" value="">
		<input type="hidden" name="function_type_desc_list" id="function_type_desc_list" value="">
		<input type="hidden" name="function_cat_code_list" id="function_cat_code_list" value="">


		<!-- These are for the disabled fields. Take the values from these fields in the servlet to insert into database -->
		<input type = "hidden" name= "condition_type" value = "">
		<input type = "hidden" name= "site" value = "">
		<input type = "hidden" name= "area" value = "">
		<input type = "hidden" name= "dental_condition" value = "">

		<!--  written by parul on 14/08/2009 for CRF#0483 -->
        <input type="hidden" name='cusptip_ref' id='cusptip_ref' value="" >
		 <input type = "hidden" name= "cusp_tip_code_hid" value = "<%=cusp_tip_code%>">
		<!-- Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700--> 
		 <input type="hidden" name='dentist_comments' id='dentist_comments' value="<%=dentist_comments%>" >

		 <!-- Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages -->
		 <input type="hidden" name='super_tooth_ref' id='super_tooth_ref' value="<%=flag1%>" >
		 <input type="hidden" name='ref_tooth_no' id='ref_tooth_no' value="<%=ref_tooth_no%>" >
		 <input type="hidden" name='super_key_num' id='super_key_num' value="<%=super_key_num%>" >

		<!-- added by parul for SRR-CRF20056-0442 on 12/01/2010-->
		<input type="hidden" name='surface_ref' id='surface_ref' value="" >
		

	</form>
	
	<script>
		setValuesFromMenu('<%=type%>','<%=site%>','<%=code%>','<%=arch_quad%>','<%=thrng_nos%>','<%=ref_tooth_no%>','<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>','<%=surface%>','<%=flag%>','<%=cusp_tip_code%>','<%=maxila_area%>','<%=maxila_parts%>','<%=maxila_sub_parts%>');
	</script>
<%//}%>
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

