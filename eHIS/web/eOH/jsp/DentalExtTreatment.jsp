<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>

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
String disabled1 = "";

String facility_id = (String)session.getValue("facility_id") ;
String patient_id = request.getParameter( "patient_id" ) ;
String ca_practitioner_id = (String)session.getValue("ca_practitioner_id") ;	  
String encounter_id = request.getParameter( "encounter_id" ) ;
String patient_class = request.getParameter( "patient_class" ) ;
String episode_id = checkForNull(request.getParameter("episode_id")) ;
String episode_type = checkForNull(request.getParameter("episode_type")) ;
String visit_id = checkForNull(request.getParameter("visit_id")) ;
String location_code = checkForNull(request.getParameter("location_code")) ;
String location_type = checkForNull(request.getParameter("location_type")) ;
//String tab_name = request.getParameter( "tab_name" ) ;

String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
String mixed_dentition_YN = checkForNull(request.getParameter("mixed_dentition_YN"));
//String tooth_no = checkForNull(request.getParameter("ToothNumber"));
String ref_tooth_no = checkForNull(request.getParameter("ref_tooth_no"));

String code = checkForNull(request.getParameter("code"));
String site = checkForNull(request.getParameter("site"));
String type = checkForNull(request.getParameter("type"));
String cat_code = checkForNull(request.getParameter("cat_code"));
String arch_quad = checkForNull(request.getParameter("arch_quad"));
String thrng_nos = checkForNull(request.getParameter("thrng_nos"));
String performed_date = checkForNull(request.getParameter("performed_date"));
//performed_date = com.ehis.util.DateUtils.convertDate(performed_date,"DMY","en",locale);
String status = checkForNull(request.getParameter("status"));
String trmt_location = checkForNull(request.getParameter("trmt_location"));
String outcome = checkForNull(request.getParameter("outcome"));
String surface = checkForNull(request.getParameter("surface"));
String remarks = checkForNull(request.getParameter("remarks"));
String ext_trmt_status = checkForNull(request.getParameter("ext_trmt_status"));
String selected_first_thno = checkForNull(request.getParameter( "selected_first_thno" )) ;//added by parul on 311008

//added by Sridevi Joshi on 16122008 when rebuilding MD-D logic
String flag = checkForNull(request.getParameter( "flag" )) ;

//newly added from dentalcondition.jsp
String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
String chart_type = checkForNull(request.getParameter( "chart_type" )) ;
String header_tab = request.getParameter( "header_tab" ) ;
String show_new_active_yn = checkForNull(request.getParameter( "show_new_active_yn" )) ;
String thrng_nos_ref = checkForNull(request.getParameter( "thrng_nos_ref" )) ;
String called_from_viewchart_yn = checkForNull(request.getParameter( "called_from_viewchart_yn" )) ;
String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String other_facilitychart_yn = checkForNull(request.getParameter( "other_facilitychart_yn" )) ; //added by parul  for other facility chart CRF#0423
String remarks_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
String cancel_reason_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CancelReason.label","or_labels");
//String failure_reason_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CancelReason.label","or_labels");
String cusp_tip_code = checkForNull(request.getParameter( "cusp_tip_code" )) ;
  //Added by Sharon Crasta on 9/17/2009 for IN009739(SRR20056-CRF-0457)
String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
String maxila_area = checkForNull(request.getParameter( "maxila_area" )) ;
String maxila_parts = checkForNull(request.getParameter( "maxila_parts" )) ;
String maxila_sub_parts = checkForNull(request.getParameter( "maxila_sub_parts" )) ;
String failure_reason = checkForNull(request.getParameter( "failure_reason" )) ;
if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
	other_chart_facility_id=facility_id;
}

//Commented and Added by Sharon Crasta on 1/11/2010 for IN017822
//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
String chart_disable_from_main = checkForNull(request.getParameter( "chart_disable_from_main" )) ;
//if(baseline_chart_yn .equals("Y")){
//Added date_diff_flag by Sharon Crasta on 3/30/2010 for IN018302
String date_diff_flag = checkForNull(request.getParameter( "date_diff_flag" )) ;
//if(baseline_chart_yn .equals("Y") || chart_disable_from_main.equals("Y")){	//End
if(baseline_chart_yn .equals("Y") || date_diff_flag.equals("disable") || chart_disable_from_main.equals("Y")){	//End
	disabled = "disabled";
}

if(baseline_chart_yn.equals("N") && other_facilitychart_yn.equals("Y")) { //added by parul  for other facility chart CRF#0423
		disabled1 = "disabled";
	}
//Added by Sharon Crasta on 2/24/2010 for SRR20056-CRF-0475(IN010868)
String pontic_tooth_values = checkForNull(request.getParameter( "pontic_tooth_values" )) ;
//End


String sysdate = "";

String flag1 = checkForNull(request.getParameter( "flag1" )) ;//Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages
String super_key_num = checkForNull(request.getParameter( "super_key_num" )) ;//Added by Sridevi Joshi on 1/25/2010 for SUPRTH chnages IN010894

//out.println("flag1:==="+flag1);
//out.println("flag:==="+flag);
//out.println("super_key_num:==="+super_key_num);


%>

<%
try{
	con=ConnectionManager.getConnection(request);

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	sql = "SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') SYSTEMDATE FROM DUAL";
	pstmt=con.prepareStatement(sql);
	rs=pstmt.executeQuery();
	while(rs.next()){
		sysdate = rs.getString("SYSTEMDATE");
	}
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
  	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
	<script language="javascript" src="../../eOH/js/DentalExternalTreatment.js"></script>
	<script language="javascript" src="../../eOH/js/GetImages.js"></script>
	<script language="javascript" src="../../eOH/js/FillImages.js"></script>
	<script language="javascript" src="../../eOH/js/DrawShapes.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>

<body onload="setValuesFromMenu('<%=type%>','<%=site%>','<%=code%>','<%=arch_quad%>','<%=thrng_nos%>','<%=ref_tooth_no%>','<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>','<%=performed_date%>','<%=status%>','<%=trmt_location%>','<%=outcome%>','<%=surface%>','<%=flag%>','<%=cusp_tip_code%>','<%=maxila_area%>','<%=maxila_parts%>','<%=maxila_sub_parts%>','<%=failure_reason%>');" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form name="OHExtTreatmentForm" id="OHExtTreatmentForm" action="../../servlet/eOH.OHDentalChartServletNew" method="post" target="messageFrame">
		<table width="100%" cellpadding =4 cellspacing=0>
			<tr>
				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
				<td width="25%" class="field" nowrap>
					<!-- <select name="oh_category" id="oh_category" onChange="populateSiteOptions(this);populateTreatments(this);populateConditionCode(this);checkForMaxilla(this);"<%=disabled%>>  -->
					<!-- commented by parul on 7/21/2009 for IN012683,When u select trmt cataegory for range and before record if u change trmt cataegory area leaged and value should be refresh-->
					  <select name="oh_category" id="oh_category" onChange="populateSiteOptions(this);populateTreatments(this);checkForMaxilla(this);getAreaLegendFromPage(this);populateAreaFromPage(this,'<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>');getSurfaceLegend(this);getSurfaceLegendFromPage(this);populateSurfaces(this);enableDisableSurfaceFromPage(this)"<%=disabled%>>  
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						 <%
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								sql="SELECT TRMT_CATEGORY_TYPE, TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW WHERE LANGUAGE_ID = ? AND SPLTY_MODULE_ID = ? ORDER BY 2";
								pstmt=con.prepareStatement(sql);
								pstmt.setString(1,locale);
								pstmt.setString(2,"OH");
								rs=pstmt.executeQuery();
								while(rs.next()){
						%>
									<option value='<%=rs.getString("TRMT_CATEGORY_TYPE")%>'><%=rs.getString("TRMT_CATEGORY_TYPE_DESC")%></option>
						<%
								}
						%>
					</select>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.Site.label" bundle="${common_labels}"/></td>
				<td width="25%" class="field" nowrap>
					<select name="oh_site" id="oh_site" onChange="getAreaLegendFromPage(this);populateAreaFromPage(this,'<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>');enableDisableSurface(this);getSurfaceLegendFromPage(this);populateSurfacesFromPage(this);" <%=disabled%>>
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
					<img id='SiteMandatory' src='../../eCommon/images/mandatory.gif'>
				</td>
				
			</tr>
			<tr>
				<td width="25%" class='LABEL' nowrap id="change_area"></td>
				<td width="25%" id="area_field" <%=disabled%>></td>

				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td width="25%" class="field">
					<select name="oh_status" id="oh_status" <%=disabled%> onchange="showCancelForReasonLink(this);" <%=disabled1%>>
					<%
						//Commented and Added by Sharon Crasta on 2/16/2010 for SRR20056-CRF-0475(IN010868)
						//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
						if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && outcome.equals("F")){
						 //End
					%>
					
							<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
							<option value="C"><fmt:message key="Common.complete.label" bundle="${common_labels}"/></option>
							<option value="I"><fmt:message key="Common.incomplete.label" bundle="${common_labels}"/></option>
							<option value="E" selected><fmt:message key="Common.MarkError.label" bundle="${common_labels}"/></option>
					<%
						}else{
					%>
							<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
							<option value="C"><fmt:message key="Common.complete.label" bundle="${common_labels}"/></option>
							<option value="I"><fmt:message key="Common.incomplete.label" bundle="${common_labels}"/></option>
					<%
					
						}
					%>
					</select>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				
			</tr>
			<tr>
				<td width="20%" class='LABEL' nowrap><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/></td>
				<td width="30%" class="field" nowrap>
					<!-- <select name="oh_treatment" id="oh_treatment" onChange='populateSurfaces(this);' <%=disabled%> nowrap> -->
					<select name="oh_treatment" id="oh_treatment"  onChange='chkTreatment(this);populateConditionCode(document.forms[0].oh_category,this);' <%=disabled%> nowrap>
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td width="25%" class="field">
					<input type="text" name="oh_location" id="oh_location" value="" size=10 maxlength="100" <%=disabled1%> onkeypress="return CheckForOHSpecChars(event);" <%=disabled%>>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>
			<tr>
			<!-- commented by parul on 19/01/2010 for  SRR-CRF20056-0442-->
				<!--  <td width="25%" class='LABEL' nowrap id="change_surface"><fmt:message key="eOH.Surface.Label" bundle="${oh_labels}"/></td>
				<td width="25%" class="field" id="surface_field">
					<select name="oh_surface" id="oh_surface" onChange="populateCuspTip(this);"<%=disabled%>>
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
					<IMG id='MandatorySurface' style='visibility:hidden' name='MandatorySurface' border="0" src='../../eCommon/images/mandatory.gif'>
				</td>  -->
					<!-- added by parul SRR-CRF20056-0442 on 19/01/2010-->

				<td width="20%" class='LABEL' nowrap  id="change_surface"><fmt:message key="eOH.Surface.Label" bundle="${oh_labels}"/></td>
				<td width="25%" class="field" id='surface_field'>
					<select name="oh_surface" id="oh_surface" size=3 multiple onChange="populateCuspTip(this);"<%=disabled%>>
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
					<IMG id='MandatorySurface' style='visibility:hidden' name='MandatorySurface' border="0" src='../../eCommon/images/mandatory.gif'> 

				<td width="20%" class='LABEL' nowrap><fmt:message key="eOH.CuspTip.Label" bundle="${oh_labels}"/></td>
				<td width="25%" class="field" id='cusp_field'>
					<select name="oh_cusp_tip" id="oh_cusp_tip"  size=3 multiple <%=disabled%>>
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
								
				</td>
			</tr>
			<tr>
				<td width="25%" nowrap class='LABEL' nowrap><fmt:message key="Common.PerformedDate.label" bundle="${common_labels}"/></td>
				<td width="25%" class="field" <%=disabled%>>
					<input type="text" name="oh_performed_date" id="oh_performed_date" value="" size=10 <%=disabled%>  onKeyPress = "NumberCheck(this);" onBlur='checkDateNotGraterThanSysDate(this)'>
					<input type='image' src='../../eCommon/images/CommonCalendar.gif' <%=disabled%> onClick="return callCalender(this,'oh_performed_date');" ><img src='../../eCommon/images/mandatory.gif'>
				</td>
			<!-- </tr> -->
			<!-- <tr> -->
				<td width="25%" class='LABEL' nowrap ><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td>
				<td width="25%" class="field">
					<select name="oh_outcome" id="oh_outcome" onChange="chkForFailureReason(this);" <%=disabled%> <%=disabled1%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<option value="S"><fmt:message key="Common.Success.label" bundle="${common_labels}"/></option>
						<option value="F"><fmt:message key="Common.Failure.label" bundle="${common_labels}"/></option>
					</select>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				</tr>
				<tr >
					<td width="20%" class='LABEL' nowrap  id="change_reason" style='visibility:hidden' > failure reason</td>
					<td width="25%" class="field" id='reason_field' style='visibility:hidden' >
				</tr>
				<tr>
				<td id ="maxillaTrmt" nowrap>
				
					<!-- <a href=\"javascript:showOperRemarks('<%=remarks_title%>')\"><%=remarks_title%></a> --><!-- <img src='../../eCommon/images/mandatory.gif'>"; -->
					<%
						if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
					%>
							<font color="blue"><a onclick="showOperRemarks('<%=remarks_title%>')" style="cursor:pointer"><%=remarks_title%></a><IMG id='MandatoryRemarks' style='visibility:hidden' name='MandatoryRemarks' border="0" src='../../eCommon/images/mandatory.gif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="cancelReason" onclick="showReasonForCancel('<%=cancel_reason_title%>')" style="cursor:pointer;visibility:hidden"><%=cancel_reason_title%></a><IMG id='MandatoryRemarks' style='visibility:hidden' name='MandatoryCancelReason' border="0" src='../../eCommon/images/mandatory.gif'></font>
							
					<%
						}
						else{
					%>
							<!-- commented and added by parul on 12/02/2010 for CRF-477 & 496 -->
							<font color="blue"><a onclick="showOperRemarks('<%=remarks_title%>')" style="cursor:pointer"><%=remarks_title%></a></font><IMG id='MandatoryRemarks' style='visibility:hidden' name='MandatoryRemarks' border="0" src='../../eCommon/images/mandatory.gif'> 
					<%
						}
					%>
				<td id='failure_id'></td>
							
				</td>
				<td width="25%" class="button" colspan="4">
					<input type="button" class="button" name="save" id="save" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' <%=disabled1%> onclick ="actionToServlet();" <%=disabled%>>&nbsp;					
					<input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>'  <%=disabled1%> onclick="ET_Tab_Reset_button(document.forms[0])" <%=disabled%>>
				</td>
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
		<input type = "hidden" name= "tab_name" value = "ET">
		<input type="hidden" name='show_new_active_yn' id='show_new_active_yn' value=<%=show_new_active_yn%> >
		<input type="hidden" name='chart_hdr_insert_yn' id='chart_hdr_insert_yn' value="" >
		<input type="hidden" name='thrng_nos_ref' id='thrng_nos_ref' value="<%=thrng_nos_ref%>" >
		<input type="hidden" name='thrng_nos' id='thrng_nos' value="<%=thrng_nos%>" >
		<input type="hidden" name='called_from_viewchart_yn' id='called_from_viewchart_yn' value="<%=called_from_viewchart_yn%>" >
		<input type="hidden" name='chart_line_num' id='chart_line_num' value="<%=chart_line_num%>" >
		<input type="hidden" name='cat_code' id='cat_code' value="<%=cat_code%>" >
		<input type="hidden" name='clinical_group_code' id='clinical_group_code' value="" >
		<input type = "hidden" name= "clinical_group_hid" value = ""> 
		<input type = "hidden" name= "remarks" value = "<%=remarks%>"> 
		<input type = "hidden" name= "ext_trmt_status" value = "<%=ext_trmt_status%>"> 
		<input type = "hidden" name= "reasonforcancel" value = "">
		<input type="hidden" name="called_from_viewchart_gingival" id="called_from_viewchart_gingival" value="N" >
		<input type = "hidden" name= "selected_first_thno" value = "<%=selected_first_thno%>"> 
		<input type = "hidden" name= "RD_Normal_yn" value = "<%=flag%>"> 
		<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>"> 
		<input type = "hidden" name= "other_facilitychart_yn" value = "<%=other_facilitychart_yn%>"> 
		<input type = "hidden" name= "surface_hid" value = "<%=surface%>"> 


		<!-- These variables are used in the developing Menu -->
		<input type="hidden" name="function_id_list" id="function_id_list" value="">		
		<input type="hidden" name="function_name_list" id="function_name_list" value="">		
		<input type="hidden" name="function_type_list" id="function_type_list" value="">
		<input type="hidden" name="function_type_desc_list" id="function_type_desc_list" value="">
		<input type="hidden" name="function_cat_code_list" id="function_cat_code_list" value="">


		<!-- These are for the disabled fields. Take the values from these fields in the servlet to insert into database -->
		<input type = "hidden" name= "category" value = "">
		<input type = "hidden" name= "site" value = "">
		<input type = "hidden" name= "area" value = "">
		<input type = "hidden" name= "treatment" value = "">
		<input type = "hidden" name= "locale" value = "<%=locale%>">
		<!--  written by parul on 14/08/2009 for CRF#0483 -->
        <input type="hidden" name='cusptip_ref' id='cusptip_ref' value="" >
		<input type = "hidden" name= "cusp_tip_code_hid" value = "<%=cusp_tip_code%>"> 
		<!-- Added by Sharon Crasta on 9/17/2009 for IN009739(SRR20056-CRF-0457)-->
		<input type = "hidden" name= "other_chart_facility_id" value = "<%=other_chart_facility_id%>">

		<!-- Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages -->
		 <input type="hidden" name='super_tooth_ref' id='super_tooth_ref' value="<%=flag1%>" >
		 <!-- Added by Sharon Crasta on 1/11/2010 for IN017822-->
		<input type="hidden" name='chart_disable_from_main' id='chart_disable_from_main' value="<%=chart_disable_from_main%>" >

		<!-- added by parul for SRR-CRF20056-0442 on 19/01/2010-->
		<input type="hidden" name='surface_ref' id='surface_ref' value="" >

		<!-- added by Sridevi Joshi for SRR-CRF20056-0481 on 1/25/2010-->
		<input type="hidden" name='super_key_num' id='super_key_num' value="<%=super_key_num%>" >
		<input type="hidden" name='ref_tooth_no' id='ref_tooth_no' value="<%=ref_tooth_no%>" >

		<!-- Added by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0498(IN010982)-->
		<input type="hidden" name='arch_quad' id='arch_quad' value="<%=arch_quad%>" >
		<!-- Added by Sharon Crasta on 2/16/2010 for SRR20056-CRF-0475(IN010868)-->
		<input type="hidden" name='outcome' id='outcome' value="<%=outcome%>" >
		<input type="hidden" name='pontic_tooth_values' id='pontic_tooth_values' value="<%=pontic_tooth_values%>" >

		<input type="hidden" name='sub_parts' id='sub_parts' value="<%=maxila_sub_parts%>" >

		<!-- Added by Sridevi Joshi on 8/20/2010 for IN023363 -->
		<input type="hidden" name='oh_surface_hid' id='oh_surface_hid' value="" >
			
	</form>

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

