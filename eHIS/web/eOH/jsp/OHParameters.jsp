<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<html>
	<head>
	    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css' ></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eOH/js/OHParameters.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
		<body onLoad='loadParamGingivalStatus();' OnMouseDown='CodeArrest()' onKeyDown="lockKey()" > 
		<form name="OHSetupParameterForm" id="OHSetupParameterForm" method="post" target="messageFrame">

<%			
			
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql = "";
			String disabled = "";
			String chrt_level = "";
			String ext_perform_dtls_reqd_yn = "";
			int total_records=0;
			String mode=request.getParameter("mode");
	
			String tooth_numbering_system="";
			String mixed_dentition_from_age_yrs="";
			String mixed_dentition_to_age_yrs="";
			String mixed_dentition_from_age_days="";
			String mixed_dentition_to_age_days="";
			String deciduous_grace_period_days = "";
			String dflt_mixed_dentition_chart = "";
			String rest_chrt_validity_days="";
			String peri_chrt_validity_days = ""; 
			String record_gingival_status_yn = "";

		   //paramters for Permanent quadrant
			String gs_no_of_tooth_for_Q1 = "";
			String gs_no_of_tooth_for_Q2 = "";
			String gs_no_of_tooth_for_Q3 = "";
			String gs_no_of_tooth_for_Q4 = "";
			String gs_dflt_tooth_no_Q1 = "";
			String gs_dflt_tooth_no_Q2 = "";
			String gs_dflt_tooth_no_Q3 = "";
			String gs_dflt_tooth_no_Q4 = "";

			 //paramters for Deciduous quadrant
			String dec_gs_no_of_tooth_for_Q1 = "";
			String dec_gs_no_of_tooth_for_Q2 = "";
			String dec_gs_no_of_tooth_for_Q3 = "";
			String dec_gs_no_of_tooth_for_Q4 = "";
			String dec_gs_dflt_tooth_no_Q1 = "";
			String dec_gs_dflt_tooth_no_Q2 = "";
			String dec_gs_dflt_tooth_no_Q3 = "";
			String dec_gs_dflt_tooth_no_Q4 = "";

		   //paramters for Mixed Dentition quadrant
			String md_gs_no_of_tooth_for_Q1 = "";
			String md_gs_no_of_tooth_for_Q2 = "";
			String md_gs_no_of_tooth_for_Q3 = "";
			String md_gs_no_of_tooth_for_Q4 = "";
			String md_gs_dflt_tooth_no_Q1 = "";
			String md_gs_dflt_tooth_no_Q2 = "";
			String md_gs_dflt_tooth_no_Q3 = "";
			String md_gs_dflt_tooth_no_Q4 = ""; 

			 //paramters for Permanent Sextant
			String gs_no_of_tooth_for_S1= "";
			String gs_no_of_tooth_for_S2 ="";
			String gs_no_of_tooth_for_S3 ="";
			String gs_no_of_tooth_for_S4 ="";
			String gs_no_of_tooth_for_S5 ="";
			String gs_no_of_tooth_for_S6 ="";
			String gs_dflt_tooth_no_S1 = "";
			String gs_dflt_tooth_no_S2 = "";
			String gs_dflt_tooth_no_S3 = "";
			String gs_dflt_tooth_no_S4 = "";
			String gs_dflt_tooth_no_S5 = "";
			String gs_dflt_tooth_no_S6 = "";

			 //paramters for Deciduous sextant
		    String dec_gs_no_of_tooth_for_S1= "";
		    String dec_gs_no_of_tooth_for_S2= "";
		    String dec_gs_no_of_tooth_for_S3= "";
		    String dec_gs_no_of_tooth_for_S4= "";
		    String dec_gs_no_of_tooth_for_S5= "";
		    String dec_gs_no_of_tooth_for_S6= "";
			String dec_gs_dflt_tooth_no_S1 = "";
			String dec_gs_dflt_tooth_no_S2 = "";
			String dec_gs_dflt_tooth_no_S3 = "";
			String dec_gs_dflt_tooth_no_S4 = "";
			String dec_gs_dflt_tooth_no_S5 = "";
			String dec_gs_dflt_tooth_no_S6 = "";

			 //paramters for Mixed Dentition sextant
		    String md_gs_no_of_tooth_for_S1= "";
		    String md_gs_no_of_tooth_for_S2= "";
		    String md_gs_no_of_tooth_for_S3= "";
		    String md_gs_no_of_tooth_for_S4= "";
		    String md_gs_no_of_tooth_for_S5= "";
		    String md_gs_no_of_tooth_for_S6= "";
			String md_gs_dflt_tooth_no_S1 = "";
			String md_gs_dflt_tooth_no_S2 = "";
			String md_gs_dflt_tooth_no_S3 = "";
			String md_gs_dflt_tooth_no_S4 = "";
			String md_gs_dflt_tooth_no_S5 = "";
			String md_gs_dflt_tooth_no_S6 = "";

			String bl_interface_flag= "";
			String gingival_recording_by= "";
			String quadrent_flag_value= "";
			String quadrent_flag_checked= "";
			String sextant_flag_value= "Y";
			String sextant_flag_checked= "checked";
			//String sql="";
			String checked_yn = "";
			String chk_value = "";
			//String tooth_selected="";
			String interface_flag_checked="";
			String interface_flag_value="";
			String disable_radio_button="";
			//HashMap map = new HashMap();
			//String map_val = "";
			//String j="";
			//String disabled="";
			String chk_disabled="";
		//	String radio_disabled="";

			String ext_perform_yn = "";
			String ext_perform_value = "Y";
			String ext_perform_disabled="";
			   

	try{
			con=ConnectionManager.getConnection(request);
			sql=" SELECT COUNT(*) AS TOTAL_RECORDS_EXISTING FROM OH_PARAM";
			pstmt=con.prepareStatement(sql);
			//pstmt.setString(1,facility_id);
			rs=pstmt.executeQuery();
			rs.next();
			total_records=rs.getInt(1);
				
				if(total_records==1){
					   mode="modify";
					   disabled="disabled";
				}
				else{
					   mode="insert";
				}

			if(mode.equals("modify")){
				sql="SELECT * FROM OH_PARAM";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();

				while(rs!=null && rs.next()){
					chrt_level=checkForNull(rs.getString("chart_level"));
					tooth_numbering_system=checkForNull(rs.getString("tooth_numbering_system"));
					mixed_dentition_from_age_yrs=checkForNull(rs.getString("mixed_dentition_from_age_yrs"));
					mixed_dentition_to_age_yrs=checkForNull(rs.getString("mixed_dentition_to_age_yrs"));
					mixed_dentition_from_age_days=checkForNull(rs.getString("mixed_dentition_from_age_days"));			
					mixed_dentition_to_age_days=checkForNull(rs.getString("mixed_dentition_to_age_days"));
					deciduous_grace_period_days=checkForNull(rs.getString("deciduous_grace_period_days"));
					dflt_mixed_dentition_chart=checkForNull(rs.getString("dflt_mixed_dentition_chart"));
					rest_chrt_validity_days=checkForNull(rs.getString("rest_chrt_validity_days"));
					peri_chrt_validity_days=checkForNull(rs.getString("peri_chrt_validity_days"));
					record_gingival_status_yn=checkForNull(rs.getString("record_gingival_status_yn"));
					gingival_recording_by=checkForNull(rs.getString("gingival_recording_by"));
					ext_perform_dtls_reqd_yn=checkForNull(rs.getString("ext_perform_dtls_reqd_yn"));

				}
				if(record_gingival_status_yn.equals("Y")){
					checked_yn = "checked";
					chk_value = "Y";
					chk_disabled="disabled";
				}
				
				else{
					checked_yn = "";
					chk_value = "N";
                    chk_disabled="";					
				}
				if(ext_perform_dtls_reqd_yn.equals("Y")){
					ext_perform_yn = "checked";
					ext_perform_value = "Y";
					ext_perform_disabled="";
				}
				
				else{
					ext_perform_yn = "";
					ext_perform_value = "N";
                    ext_perform_disabled="";					
				}

				if(bl_interface_flag.equals("Y")){
					interface_flag_checked = "checked";
					interface_flag_value = "Y";
				}
				else{
					interface_flag_checked = "";
					interface_flag_value = "N";
				}
				if (gingival_recording_by.equals("Q")){
					quadrent_flag_checked="checked";
					quadrent_flag_value="Y";
					sextant_flag_checked="";
					sextant_flag_value="N";
				}
				else{
					sextant_flag_checked="checked";
					sextant_flag_value="Y";
					quadrent_flag_checked="";
					quadrent_flag_value="N";
				}				
				
				if (!quadrent_flag_value.equals("") && gingival_recording_by.equals("Q"))
				{
					disabled="disabled";
				}

				else if (!sextant_flag_value.equals("") && gingival_recording_by.equals("S"))
				{
					disabled="disabled";
					
				}
			}
	%>
		
		 <table border=0 cellspacing=0 cellpadding=3 width='99%' align=center>
   				<tr>
    				<td class=label ><fmt:message key="eOH.ChartLevel.Label" bundle="${oh_labels}"/></td>
    				<td align="left" colspan="5" class="label">
					<select name="chart_level1" id="chart_level1" DB_VALUE="<%=chrt_level%>" <%=disabled%> onChange="populateChart(this)">
						 <option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option> 
						<option value="E" ><fmt:message key="eOH.Enterprise.Label" bundle="${oh_labels}"/> </option>
						<option value="F"><fmt:message key="Common.facility.label" bundle="${common_labels}"/> </option>								
					</select>
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td class=label ><fmt:message key="eOH.ResultReporting.Label" bundle="${oh_labels}"/></td>
					<td class="fields" width="25%" colspan="3">
					<input type="checkbox" name="res_rep" id="res_rep" value="<%=ext_perform_value%>" <%=ext_perform_yn%>  <%=ext_perform_disabled%> onclick="setCheckValue('<%=ext_perform_value%>');">
				</td>
			</tr>
		</table> 
				<div id='ohparam' style='visibility:hidden;display:none'>

				<table border=0 cellspacing=0 cellpadding=3 width='99%' align=center>
   				<tr>
    				<td class=label ><fmt:message key="eOH.ToothNumberingSystem.Label" bundle="${oh_labels}"/></td>
    				<td align="left" colspan="5" class="label">
					 <select name="tooth_numbering_system" id="tooth_numbering_system" DB_VALUE="<%=tooth_numbering_system%>" onChange="populateParamToothNo(this)">
							<% if(tooth_numbering_system.equals("") || tooth_numbering_system.equals(null)){ %>
								<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
							<% } %>
							<option value="UNI"><fmt:message key="eOH.UniversalNumberingSystem.Label" bundle="${oh_labels}"/></option>
							<option value="FDI"><fmt:message key="eOH.FDINumberingSystem.Label" bundle="${oh_labels}"/></option>
						</select>
						
						<img src='../../eCommon/images/mandatory.gif'></img>
      				</td>
    			</tr>
				<tr>
					<td class=label ><fmt:message key="eOH.AgeRangeToDisplayMixedDentition.Label" bundle="${oh_labels}"/></td>
					<!-- Commented and Added by Sharon Crasta on 11/17/2009 for IN016376-->
					<!-- Added "return checkBackspaceKey()" to disable the backspace key-->
					<!-- <td class="label" style="text-align:left"><input type="text" name="mixed_dentition_from_age_yrs" id="mixed_dentition_from_age_yrs" value="<%=mixed_dentition_from_age_yrs%>" size="3" maxlength=3 onBlur="CheckNum(this);checkGraterFromageValidation(mixed_dentition_to_age_yrs,this);"><fmt:message key="eOH.Yrs.Label" bundle="${oh_labels}"/><img src='../../eCommon/images/mandatory.gif'></img></td> -->
					<td class="label" style="text-align:left"><input type="text" name="mixed_dentition_from_age_yrs" id="mixed_dentition_from_age_yrs" value="<%=mixed_dentition_from_age_yrs%>" size="3" maxlength=3 onKeyDown="return checkBackspaceKey();" onBlur="CheckNum(this);checkGraterFromageValidation(mixed_dentition_to_age_yrs,this);"><fmt:message key="eOH.Yrs.Label" bundle="${oh_labels}"/><img src='../../eCommon/images/mandatory.gif'></img></td>
					<!-- Commented and Added by Sharon Crasta on 11/17/2009 for IN016376-->
					<!-- Added "return checkBackspaceKey()" to disable the backspace key-->
					<!-- <td class="label" style="text-align:left"><input type="text" name="mixed_dentition_from_age_days" id="mixed_dentition_from_age_days" value="<%=mixed_dentition_from_age_days%>" size="3" maxlength=3 onBlur="CheckNum(this);checkGraterFromDaysValidation()"><fmt:message key="Common.days.label" bundle="${common_labels}"/></td> -->
					<td class="label" style="text-align:left"><input type="text" name="mixed_dentition_from_age_days" id="mixed_dentition_from_age_days" value="<%=mixed_dentition_from_age_days%>" size="3" maxlength=3  onKeyDown="return checkBackspaceKey();" onBlur="CheckNum(this);checkGraterFromDaysValidation()"><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
					<td class="label" style="text-align:left"><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
					<!-- Commented and Added by Sharon Crasta on 11/17/2009 for IN016376-->
					<!-- Added "return checkBackspaceKey()" to disable the backspace key-->
					<!-- <td class="label" style="text-align:left"><input type="text" name="mixed_dentition_to_age_yrs" id="mixed_dentition_to_age_yrs" value="<%=mixed_dentition_to_age_yrs%>" size="3" maxlength=3 onBlur="CheckNum(this);checkGraterToageValidation(mixed_dentition_from_age_yrs,this);"><fmt:message key="eOH.Yrs.Label" bundle="${oh_labels}"/><img src='../../eCommon/images/mandatory.gif'></img></td> -->
					<td class="label" style="text-align:left"><input type="text" name="mixed_dentition_to_age_yrs" id="mixed_dentition_to_age_yrs" value="<%=mixed_dentition_to_age_yrs%>" size="3" maxlength=3  onKeyDown="return checkBackspaceKey();" onBlur="CheckNum(this);checkGraterToageValidation(mixed_dentition_from_age_yrs,this);"><fmt:message key="eOH.Yrs.Label" bundle="${oh_labels}"/><img src='../../eCommon/images/mandatory.gif'></img></td>
					<!-- Commented and Added by Sharon Crasta on 11/17/2009 for IN016376-->
					<!-- Added "return checkBackspaceKey()" to disable the backspace key-->
					<!-- <td class="label" style="text-align:left"><input type="text" name="mixed_dentition_to_age_days" id="mixed_dentition_to_age_days" value="<%=mixed_dentition_to_age_days%>" size="3" maxlength=3 onBlur="CheckNum(this);checkGraterToDaysValidation()"><fmt:message key="Common.days.label" bundle="${common_labels}"/></td> -->
					<td class="label" style="text-align:left"><input type="text" name="mixed_dentition_to_age_days" id="mixed_dentition_to_age_days" value="<%=mixed_dentition_to_age_days%>" size="3" maxlength=3  onKeyDown="return checkBackspaceKey();" onBlur="CheckNum(this);checkGraterToDaysValidation()"><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class=label><fmt:message key="eOH.DeciduousGracePeriodDays.Label" bundle="${oh_labels}"/></td>
						<td class="label" style="text-align:left" colspan=5><input type="text" name="deciduous_grace_period_days" id="deciduous_grace_period_days" value="<%=deciduous_grace_period_days%>" size="3" maxlength=3 onBlur="CheckNum(this);"><fmt:message key="Common.days.label"  bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="eOH.DefaultChartToDispalyForMixedDentition.Label" bundle="${oh_labels}"/></td>
					<td align="left" colspan=5 class="label">
							<select name="dflt_mixed_dentition_chart" id="dflt_mixed_dentition_chart" DB_VALUE="<%=dflt_mixed_dentition_chart%>" onChange="populateParamMixedDentition(this)"> 
								<% if((dflt_mixed_dentition_chart.equals(""))||(dflt_mixed_dentition_chart.equals(null))){ %> 
									<option value="P" selected><fmt:message key="Common.Permanent.label" bundle="${common_labels}"/></option>
								<% }else{ %>
									<option value="P"><fmt:message key="Common.Permanent.label" bundle="${common_labels}"/></option>
								<%}%>
								<option value="D"><fmt:message key="eOH.Decedious.Label" bundle="${oh_labels}"/></option>  
								
							</select>
					</td>
				</tr>
				<tr>
					<td class=label nowrap><fmt:message key="eOH.ValidityPeriodForBaselineRestorativeChart.Label" bundle="${oh_labels}"/></td>
					<td align="left" colspan="5" class="label"><input type="text" name="rest_chrt_validity_days" id="rest_chrt_validity_days" value="<%=rest_chrt_validity_days%>" size="4" maxlength=4 onBlur="CheckNum(this)"><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class=label nowrap><fmt:message key="eOH.ValidityPeriodForPerioChart.Label" bundle="${oh_labels}"/></td>
					<td align="left" colspan="5" class="label"><input type="text" name="peri_chrt_validity_days" id="peri_chrt_validity_days" value="<%=peri_chrt_validity_days%>" size="4" maxlength=4 onBlur="CheckNum(this)"><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				</tr>
				 <tr>
					<td class=label nowrap><fmt:message key="eOH.RecordingPeriodontalConditionInDentalChartApplicable.Label" bundle="${oh_labels}"/></td>

					<td class="fields" width="25%" colspan="5" align="left"><input type="checkbox"  name="record_gingival_status_yn" id="record_gingival_status_yn" onClick='setParamCheckValue();'  value="<%=chk_value%>" <%=checked_yn%>  <%=chk_disabled%>>
					
					</td>
				</tr>
			
				<tr>
					<td class=label nowrap>
					<fmt:message key="eOH.GingivalStatusRecording.Label" bundle="${oh_labels}"/></td>
					<td class='fields' width='25%'><fmt:message key="eOH.ByQuadrant.Label" bundle="${oh_labels}"/><input type='radio' name="gingival" id="gingival" onclick='loadParamQuadDtls();checkParamRadio();' value="<%=quadrent_flag_value%>"<%=quadrent_flag_checked%> <%=disabled%><%=disable_radio_button%>></td><td class='fields' width='25%'><fmt:message key="eOH.BySextant.Label" bundle="${oh_labels}"/><input type='radio' name="gingival" id="gingival" onclick='loadParamSextantDtls();checkParamRadio();' value="<%=quadrent_flag_value%>" <%=sextant_flag_checked%> <%=disabled%> <%=disable_radio_button%>></td>
				</tr> 
				</table>
			</div>
		

					<input type="hidden" name="locale" id="locale" value=<%=locale%>>
					<input type="hidden" name="mode" id="mode" value=<%=mode%>>						
					<input type="hidden" name="chrt_level" id="chrt_level" value=<%=chrt_level%>>
					<input type="hidden" name="checked_yn" id="checked_yn" value=<%=checked_yn%>>
					<input type="hidden" name="dflt_chart" id="dflt_chart" value=<%=dflt_mixed_dentition_chart%>>
					<input type="hidden" name="gingival_recording_by" id="gingival_recording_by" value=<%=gingival_recording_by%>>  
					<input type="hidden" name="gs_no_of_tooth_for_Q1" id="gs_no_of_tooth_for_Q1" value=<%=gs_no_of_tooth_for_Q1%>>  
					<input type="hidden" name="gs_no_of_tooth_for_Q2" id="gs_no_of_tooth_for_Q2" value=<%=gs_no_of_tooth_for_Q2%>>  
					<input type="hidden" name="gs_no_of_tooth_for_Q3" id="gs_no_of_tooth_for_Q3" value=<%=gs_no_of_tooth_for_Q3%>>  
					<input type="hidden" name="gs_no_of_tooth_for_Q4" id="gs_no_of_tooth_for_Q4" value=<%=gs_no_of_tooth_for_Q4%>>  
					<input type="hidden" name="gs_dflt_tooth_no_Q1" id="gs_dflt_tooth_no_Q1" value=<%=gs_dflt_tooth_no_Q1%>>  
					<input type="hidden" name="gs_dflt_tooth_no_Q2" id="gs_dflt_tooth_no_Q2" value=<%=gs_dflt_tooth_no_Q2%>>  
					<input type="hidden" name="gs_dflt_tooth_no_Q3" id="gs_dflt_tooth_no_Q3" value=<%=gs_dflt_tooth_no_Q3%>>  
					<input type="hidden" name="gs_dflt_tooth_no_Q4" id="gs_dflt_tooth_no_Q4" value=<%=gs_dflt_tooth_no_Q4%>> 

					<input type="hidden" name="gs_no_of_tooth_for_S1" id="gs_no_of_tooth_for_S1" value=<%=gs_no_of_tooth_for_S1%>> 
					<input type="hidden" name="gs_no_of_tooth_for_S2" id="gs_no_of_tooth_for_S2" value=<%=gs_no_of_tooth_for_S2%>> 
					<input type="hidden" name="gs_no_of_tooth_for_S3" id="gs_no_of_tooth_for_S3" value=<%=gs_no_of_tooth_for_S3%>> 
					<input type="hidden" name="gs_no_of_tooth_for_S4" id="gs_no_of_tooth_for_S4" value=<%=gs_no_of_tooth_for_S4%>> 
					<input type="hidden" name="gs_no_of_tooth_for_S5" id="gs_no_of_tooth_for_S5" value=<%=gs_no_of_tooth_for_S5%>> 
					<input type="hidden" name="gs_no_of_tooth_for_S6" id="gs_no_of_tooth_for_S6" value=<%=gs_no_of_tooth_for_S6%>> 
					<input type="hidden" name="gs_dflt_tooth_no_S1" id="gs_dflt_tooth_no_S1" value=<%=gs_dflt_tooth_no_S1%>> 
					<input type="hidden" name="gs_dflt_tooth_no_S2" id="gs_dflt_tooth_no_S2" value=<%=gs_dflt_tooth_no_S2%>> 
					<input type="hidden" name="gs_dflt_tooth_no_S3" id="gs_dflt_tooth_no_S3" value=<%=gs_dflt_tooth_no_S3%>> 
					<input type="hidden" name="gs_dflt_tooth_no_S4" id="gs_dflt_tooth_no_S4" value=<%=gs_dflt_tooth_no_S4%>> 
					<input type="hidden" name="gs_dflt_tooth_no_S5" id="gs_dflt_tooth_no_S5" value=<%=gs_dflt_tooth_no_S5%>> 
					<input type="hidden" name="gs_dflt_tooth_no_S6" id="gs_dflt_tooth_no_S6" value=<%=gs_dflt_tooth_no_S6%>>  
					<input type="hidden" name="record_gingival_status_yn_hid" id="record_gingival_status_yn_hid" value=<%=record_gingival_status_yn%>>

					<input type="hidden" name="dec_gs_no_of_tooth_for_Q1" id="dec_gs_no_of_tooth_for_Q1" value=<%=dec_gs_no_of_tooth_for_Q1%>>  
					<input type="hidden" name="dec_gs_no_of_tooth_for_Q2" id="dec_gs_no_of_tooth_for_Q2" value=<%=dec_gs_no_of_tooth_for_Q2%>>  
					<input type="hidden" name="dec_gs_no_of_tooth_for_Q3" id="dec_gs_no_of_tooth_for_Q3" value=<%=dec_gs_no_of_tooth_for_Q3%>>  
					<input type="hidden" name="dec_gs_no_of_tooth_for_Q4" id="dec_gs_no_of_tooth_for_Q4" value=<%=dec_gs_no_of_tooth_for_Q4%>>  
					<input type="hidden" name="dec_gs_dflt_tooth_no_Q1" id="dec_gs_dflt_tooth_no_Q1" value=<%=dec_gs_dflt_tooth_no_Q1%>>  
					<input type="hidden" name="dec_gs_dflt_tooth_no_Q2" id="dec_gs_dflt_tooth_no_Q2" value=<%=dec_gs_dflt_tooth_no_Q2%>>  
					<input type="hidden" name="dec_gs_dflt_tooth_no_Q3" id="dec_gs_dflt_tooth_no_Q3" value=<%=dec_gs_dflt_tooth_no_Q3%>>  
					<input type="hidden" name="dec_gs_dflt_tooth_no_Q4" id="dec_gs_dflt_tooth_no_Q4" value=<%=dec_gs_dflt_tooth_no_Q4%>>  

					<input type="hidden" name="md_gs_no_of_tooth_for_Q1" id="md_gs_no_of_tooth_for_Q1" value=<%=md_gs_no_of_tooth_for_Q1%>>  
					<input type="hidden" name="md_gs_no_of_tooth_for_Q2" id="md_gs_no_of_tooth_for_Q2" value=<%=md_gs_no_of_tooth_for_Q2%>>  
					<input type="hidden" name="md_gs_no_of_tooth_for_Q3" id="md_gs_no_of_tooth_for_Q3" value=<%=md_gs_no_of_tooth_for_Q3%>>  
					<input type="hidden" name="md_gs_no_of_tooth_for_Q4" id="md_gs_no_of_tooth_for_Q4" value=<%=md_gs_no_of_tooth_for_Q4%>>  
					<input type="hidden" name="md_gs_dflt_tooth_no_Q1" id="md_gs_dflt_tooth_no_Q1" value=<%=md_gs_dflt_tooth_no_Q1%>>  
					<input type="hidden" name="md_gs_dflt_tooth_no_Q2" id="md_gs_dflt_tooth_no_Q2" value=<%=md_gs_dflt_tooth_no_Q2%>>  
					<input type="hidden" name="md_gs_dflt_tooth_no_Q3" id="md_gs_dflt_tooth_no_Q3" value=<%=md_gs_dflt_tooth_no_Q3%>>  
					<input type="hidden" name="md_gs_dflt_tooth_no_Q4" id="md_gs_dflt_tooth_no_Q4" value=<%=md_gs_dflt_tooth_no_Q4%>> 

					<input type="hidden" name="dec_gs_no_of_tooth_for_S1" id="dec_gs_no_of_tooth_for_S1" value=<%=dec_gs_no_of_tooth_for_S1%>> 
					<input type="hidden" name="dec_gs_no_of_tooth_for_S2" id="dec_gs_no_of_tooth_for_S2" value=<%=dec_gs_no_of_tooth_for_S2%>> 
					<input type="hidden" name="dec_gs_no_of_tooth_for_S3" id="dec_gs_no_of_tooth_for_S3" value=<%=dec_gs_no_of_tooth_for_S3%>> 
					<input type="hidden" name="dec_gs_no_of_tooth_for_S4" id="dec_gs_no_of_tooth_for_S4" value=<%=dec_gs_no_of_tooth_for_S4%>> 
					<input type="hidden" name="dec_gs_no_of_tooth_for_S5" id="dec_gs_no_of_tooth_for_S5" value=<%=dec_gs_no_of_tooth_for_S5%>> 
					<input type="hidden" name="dec_gs_no_of_tooth_for_S6" id="dec_gs_no_of_tooth_for_S6" value=<%=dec_gs_no_of_tooth_for_S6%>> 
					<input type="hidden" name="dec_gs_dflt_tooth_no_S1" id="dec_gs_dflt_tooth_no_S1" value=<%=dec_gs_dflt_tooth_no_S1%>> 
					<input type="hidden" name="dec_gs_dflt_tooth_no_S2" id="dec_gs_dflt_tooth_no_S2" value=<%=dec_gs_dflt_tooth_no_S2%>> 
					<input type="hidden" name="dec_gs_dflt_tooth_no_S3" id="dec_gs_dflt_tooth_no_S3" value=<%=dec_gs_dflt_tooth_no_S3%>> 
					<input type="hidden" name="dec_gs_dflt_tooth_no_S4" id="dec_gs_dflt_tooth_no_S4" value=<%=dec_gs_dflt_tooth_no_S4%>> 
					<input type="hidden" name="dec_gs_dflt_tooth_no_S5" id="dec_gs_dflt_tooth_no_S5" value=<%=dec_gs_dflt_tooth_no_S5%>> 
					<input type="hidden" name="dec_gs_dflt_tooth_no_S6" id="dec_gs_dflt_tooth_no_S6" value=<%=dec_gs_dflt_tooth_no_S6%>> 


					 <input type="hidden" name="md_gs_no_of_tooth_for_S1" id="md_gs_no_of_tooth_for_S1" value=<%=md_gs_no_of_tooth_for_S1%>> 
					 <input type="hidden" name="md_gs_no_of_tooth_for_S2" id="md_gs_no_of_tooth_for_S2" value=<%=md_gs_no_of_tooth_for_S2%>> 
					 <input type="hidden" name="md_gs_no_of_tooth_for_S3" id="md_gs_no_of_tooth_for_S3" value=<%=md_gs_no_of_tooth_for_S3%>> 
					 <input type="hidden" name="md_gs_no_of_tooth_for_S4" id="md_gs_no_of_tooth_for_S4" value=<%=md_gs_no_of_tooth_for_S4%>> 
					 <input type="hidden" name="md_gs_no_of_tooth_for_S5" id="md_gs_no_of_tooth_for_S5" value=<%=md_gs_no_of_tooth_for_S5%>> 
					 <input type="hidden" name="md_gs_no_of_tooth_for_S6" id="md_gs_no_of_tooth_for_S6" value=<%=md_gs_no_of_tooth_for_S6%>> 
					 <input type="hidden" name="md_gs_dflt_tooth_no_S1" id="md_gs_dflt_tooth_no_S1" value=<%=md_gs_dflt_tooth_no_S1%>> 
					 <input type="hidden" name="md_gs_dflt_tooth_no_S2" id="md_gs_dflt_tooth_no_S2" value=<%=md_gs_dflt_tooth_no_S2%>> 
					 <input type="hidden" name="md_gs_dflt_tooth_no_S3" id="md_gs_dflt_tooth_no_S3" value=<%=md_gs_dflt_tooth_no_S3%>> 
					 <input type="hidden" name="md_gs_dflt_tooth_no_S4" id="md_gs_dflt_tooth_no_S4" value=<%=md_gs_dflt_tooth_no_S4%>> 
					 <input type="hidden" name="md_gs_dflt_tooth_no_S5" id="md_gs_dflt_tooth_no_S5" value=<%=md_gs_dflt_tooth_no_S5%>> 
					 <input type="hidden" name="md_gs_dflt_tooth_no_S6" id="md_gs_dflt_tooth_no_S6" value=<%=md_gs_dflt_tooth_no_S6%>> 
					 <input type="hidden" name="deciduous_grace_period_days_hid" id="deciduous_grace_period_days_hid" value=<%=deciduous_grace_period_days%>> 
					 <input type="hidden" name="rest_chrt_validity_days_hid" id="rest_chrt_validity_days_hid" value=<%=rest_chrt_validity_days%>> 
					 <input type="hidden" name="peri_chrt_validity_days_hid" id="peri_chrt_validity_days_hid" value=<%=peri_chrt_validity_days%>> 

					<input type="hidden" name="gigival_recorded" id="gigival_recorded" value=""> 
					<input type="hidden" name="res_rep_temp" id="res_rep_temp" value=""> 
					<input type="hidden" name="chk_recorded" id="chk_recorded" value=""> 
					<input type="hidden" name="res_rep1" id="res_rep1" value="<%=ext_perform_dtls_reqd_yn%>"> 
					<input type="hidden" name="res_rep2" id="res_rep2" value="<%=ext_perform_value%>"> 
			</form>
		 <script>
					AssignParamDBValue('<%=gingival_recording_by%>','<%=record_gingival_status_yn%>');
					
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

