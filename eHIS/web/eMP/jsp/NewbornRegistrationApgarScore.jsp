<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.HashMap,java.util.Properties, java.util.ArrayList, java.text.SimpleDateFormat, com.ehis.util.*, webbeans.eCommon.ConnectionManager,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
<%
Properties p		= (java.util.Properties) session.getValue("jdbc");
request.setCharacterEncoding("UTF-8");
HashMap hashMap	= new HashMap();
Connection con	= null;

String q_apgar_score_in_5_mins	= "",q_apgar_score_in_10_mins	= "", q_apgar_score	="",heart_rate_in_1_min	="",
	   breathing_in_1_min	="",grimace_in_1_min	="",activity_in_1_min	="",appearance_in_1_min	="",heart_rate_in_5_min	="",
	   breathing_in_5_min	="",grimace_in_5_min	="",activity_in_5_min	="",appearance_in_5_min	="",heart_rate_in_10_min	="",
	   breathing_in_10_min	="",grimace_in_10_min	="",activity_in_10_min	="",appearance_in_10_min	="";

String heart_rate_in_1_min_1 ="",  heart_rate_in_1_min_2 ="",  heart_rate_in_1_min_3 ="",  heart_rate_in_1_min_4 ="",  heart_rate_in_5_min_1 ="",  heart_rate_in_5_min_2 ="",  heart_rate_in_5_min_3 ="",  heart_rate_in_5_min_4 ="",  heart_rate_in_10_min_1 ="",  heart_rate_in_10_min_2 ="",  heart_rate_in_10_min_3 ="",  heart_rate_in_10_min_4 ="",  breathing_in_1_min_1 ="",  breathing_in_1_min_2 ="",  breathing_in_1_min_3 ="",  
breathing_in_1_min_4 ="",  breathing_in_5_min_1 ="",  breathing_in_5_min_2 ="",  breathing_in_5_min_3 ="",  breathing_in_5_min_4 ="",
breathing_in_10_min_1 ="",  breathing_in_10_min_2 ="",  breathing_in_10_min_3 ="",  breathing_in_10_min_4 ="",  grimace_in_1_min_1 ="",
grimace_in_1_min_2 ="",  grimace_in_1_min_3 ="",  grimace_in_1_min_4 ="",  grimace_in_5_min_1 ="",  grimace_in_5_min_2 ="",  grimace_in_5_min_3 ="",  grimace_in_5_min_4 ="",  grimace_in_10_min_1 ="",  grimace_in_10_min_2 ="",  grimace_in_10_min_3 ="",  grimace_in_10_min_4 ="",  activity_in_1_min_1 ="",  activity_in_1_min_2 ="",  activity_in_1_min_3 ="",  activity_in_1_min_4 ="",  activity_in_5_min_1 ="",  activity_in_5_min_2 ="",  activity_in_5_min_3 ="",  activity_in_5_min_4 ="",  activity_in_10_min_1 ="",  activity_in_10_min_2 ="",  activity_in_10_min_3 ="",  activity_in_10_min_4 ="",  appearance_in_1_min_1 ="",  appearance_in_1_min_2 ="",  appearance_in_1_min_3 ="",  appearance_in_1_min_4 ="",  appearance_in_5_min_1 ="",  appearance_in_5_min_2 ="",
appearance_in_5_min_3 ="",  appearance_in_5_min_4 ="",  appearance_in_10_min_1 ="",  appearance_in_10_min_2 ="",  appearance_in_10_min_3 ="",  appearance_in_10_min_4 ="";

String function_id			= checkForNull(request.getParameter("function_id_apgarScore"));

try{
	con = ConnectionManager.getConnection(request);	
	String motherid	= checkForNull(request.getParameter("mother_id"));//mother Patient ID
	String invoked_from	= checkForNull(request.getParameter("invoked_from"));
	String regnStatus	= checkForNull(request.getParameter("regnStatus"));
	hashMap	= eMP.NewbornDetails.getNewbornData(motherid, con, p);//this line added for this incident [54168]
	Boolean isRegNewbornApplicable = CommonBean.isSiteSpecific(con, "MP","REG_NEWBORN_FOR_IP");
	
					String outcome_dis = "", outcome_disalbed = "";
					if(!function_id.equals("REGISTER_NEWBORN")) {
						outcome_dis = (String) hashMap.get("q_outcome")==null?"":(String)hashMap.get("q_outcome");
						if(((String)hashMap.get("q_bba_yn")).equals("I")){
					}else{
						outcome_disalbed="disabled";
					}
					} 						
					
					if(outcome_dis.equals("S") || (invoked_from.equals("details_page")&&regnStatus.equals("F"))){
						outcome_disalbed="disabled";
					}
					if(isRegNewbornApplicable && outcome_dis.equals("L")){ outcome_disalbed=""; }
					%>

<tr>
					<td class='label'  ><fmt:message key="Common.ApgarScore.label" bundle="${common_labels}"/><span id = 'apgar_dtls_link' ><input type='button' class='button' value="+" name="apgar_dtls_name" id="apgar_dtls_name" onClick='javascript:apgarLink(this)'></span></td>
					<td  class='fields'>
						<input type="text" name="apgar_score" id="apgar_score" maxlength=2 size=2  <%=outcome_disalbed%> readonly><span class='label'><fmt:message key="eMP.in1Min.label" bundle="${mp_labels}"/></span><font id='apg'><img align=center src='../../eCommon/images/mandatory.gif' id='apgar_score_MandImg'></img></font>
					</td>
					<td>
						<input type="text" name="apgar_score_five_min" id="apgar_score_five_min" maxlength=2 size=2  <%=outcome_disalbed%> readonly><span class='label'><fmt:message key="eMP.in5Min.label" bundle="${mp_labels}"/></span><img align = 'center' id = 'APGAR_SCORE_IN_5_MINS_YN_IMG' src='../../eCommon/images/mandatory.gif' style='visibility:hidden'></img>
					</td>
					<td>
						<input type="text" name="apgar_score_ten_min" id="apgar_score_ten_min" maxlength=2 size=2  <%=outcome_disalbed%> readonly><span class='label'><fmt:message key="eMP.in10Min.label" bundle="${mp_labels}"/></span>
						<img align = 'center' id = 'APGAR_SCORE_IN_10_MINS_YN_IMG' src='../../eCommon/images/mandatory.gif' style='visibility:hidden'></img>
					<input type = 'hidden' name = 'apgar5_visibility' id = 'apgar5_visibility' value = 'N'>
					<input type = 'hidden' name = 'apgar10_visibility' id = 'apgar10_visibility' value = 'N'>					
					<% if(!function_id.equals("REGISTER_NEWBORN")){
							q_apgar_score_in_5_mins		= (String) hashMap.get("q_apgar_score_in_5_mins");
							q_apgar_score_in_10_mins	= (String) hashMap.get("q_apgar_score_in_10_mins");
							q_apgar_score				= (String) hashMap.get("q_apgar_score");
							heart_rate_in_1_min			= checkForNull((String)hashMap.get("heart_rate_in_1_min"));
							breathing_in_1_min			= checkForNull((String)hashMap.get("breathing_in_1_min"));
							grimace_in_1_min			= checkForNull((String)hashMap.get("grimace_in_1_min"));
							activity_in_1_min			= checkForNull((String)hashMap.get("activity_in_1_min"));
							appearance_in_1_min			= checkForNull((String)hashMap.get("appearance_in_1_min"));
							heart_rate_in_5_min			= checkForNull((String)hashMap.get("heart_rate_in_5_min"));
							breathing_in_5_min			= checkForNull((String)hashMap.get("breathing_in_5_min"));
							grimace_in_5_min			= checkForNull((String)hashMap.get("grimace_in_5_min"));
							activity_in_5_min			= checkForNull((String)hashMap.get("activity_in_5_min"));
							appearance_in_5_min			= checkForNull((String)hashMap.get("appearance_in_5_min"));
							heart_rate_in_10_min		= checkForNull((String)hashMap.get("heart_rate_in_10_min"));
							breathing_in_10_min			= checkForNull((String)hashMap.get("breathing_in_10_min"));
							grimace_in_10_min			= checkForNull((String)hashMap.get("grimace_in_10_min"));
							activity_in_10_min			= checkForNull((String)hashMap.get("activity_in_10_min"));
							appearance_in_10_min		= checkForNull((String)hashMap.get("appearance_in_10_min"));
							if(heart_rate_in_1_min.equals("")){
								heart_rate_in_1_min_1="selected";
							}else if(heart_rate_in_1_min.equals("0")){
								heart_rate_in_1_min_2="selected";
							}else if(heart_rate_in_1_min.equals("1")){
								heart_rate_in_1_min_3="selected";
							}else if(heart_rate_in_1_min.equals("2")){
								heart_rate_in_1_min_4="selected";
							}
							if(heart_rate_in_5_min.equals("")){
								heart_rate_in_5_min_1="selected";
							}else if(heart_rate_in_5_min.equals("0")){
								heart_rate_in_5_min_2="selected";
							}else if(heart_rate_in_5_min.equals("1")){
								heart_rate_in_5_min_3="selected";
							}else if(heart_rate_in_5_min.equals("2")){
								heart_rate_in_5_min_4="selected";
							}
							if(heart_rate_in_10_min.equals("")){
								heart_rate_in_10_min_1="selected";
							}else if(heart_rate_in_10_min.equals("0")){
								heart_rate_in_10_min_2="selected";
							}else if(heart_rate_in_10_min.equals("1")){
								heart_rate_in_10_min_3="selected";
							}else if(heart_rate_in_10_min.equals("2")){
								heart_rate_in_10_min_4="selected";
							}
							if(breathing_in_1_min.equals("")){
								breathing_in_1_min_1="selected";
							}else if(breathing_in_1_min.equals("0")){
								breathing_in_1_min_2="selected";
							}else if(breathing_in_1_min.equals("1")){
								breathing_in_1_min_3="selected";
							}else if(breathing_in_1_min.equals("2")){
								breathing_in_1_min_4="selected";
							}
							if(breathing_in_5_min.equals("")){
								breathing_in_5_min_1="selected";
							}else if(breathing_in_5_min.equals("0")){
								breathing_in_5_min_2="selected";
							}else if(breathing_in_5_min.equals("1")){
								breathing_in_5_min_3="selected";
							}else if(breathing_in_5_min.equals("2")){
								breathing_in_5_min_4="selected";
							}
							if(breathing_in_10_min.equals("")){
								breathing_in_10_min_1="selected";
							}else if(breathing_in_10_min.equals("0")){
								breathing_in_10_min_2="selected";
							}else if(breathing_in_10_min.equals("1")){
								breathing_in_10_min_3="selected";
							}else if(breathing_in_10_min.equals("2")){
								breathing_in_10_min_4="selected";
							}
							if(grimace_in_1_min.equals("")){
								grimace_in_1_min_1="selected";
							}else if(grimace_in_1_min.equals("0")){
								grimace_in_1_min_2="selected";
							}else if(grimace_in_1_min.equals("1")){
								grimace_in_1_min_3="selected";
							}else if(grimace_in_1_min.equals("2")){
								grimace_in_1_min_4="selected";
							}
							if(grimace_in_5_min.equals("")){
								grimace_in_5_min_1="selected";
							}else if(grimace_in_5_min.equals("0")){
								grimace_in_5_min_2="selected";
							}else if(grimace_in_5_min.equals("1")){
								grimace_in_5_min_3="selected";
							}else if(grimace_in_5_min.equals("2")){
								grimace_in_5_min_4="selected";
							}
							if(grimace_in_10_min.equals("")){
								grimace_in_10_min_1="selected";
							}else if(grimace_in_10_min.equals("0")){
								grimace_in_10_min_2="selected";
							}else if(grimace_in_10_min.equals("1")){
								grimace_in_10_min_3="selected";
							}else if(grimace_in_10_min.equals("2")){
								grimace_in_10_min_4="selected";
							}
							if(activity_in_1_min.equals("")){
								activity_in_1_min_1="selected";
							}else if(activity_in_1_min.equals("0")){
								activity_in_1_min_2="selected";
							}else if(activity_in_1_min.equals("1")){
								activity_in_1_min_3="selected";
							}else if(activity_in_1_min.equals("2")){
								activity_in_1_min_4="selected";
							}
							if(activity_in_5_min.equals("")){
								activity_in_5_min_1="selected";
							}else if(activity_in_5_min.equals("0")){
								activity_in_5_min_2="selected";
							}else if(activity_in_5_min.equals("1")){
								activity_in_5_min_3="selected";
							}else if(activity_in_5_min.equals("2")){
								activity_in_5_min_4="selected";
							}
							if(activity_in_10_min.equals("")){
								activity_in_10_min_1="selected";
							}else if(activity_in_10_min.equals("0")){
								activity_in_10_min_2="selected";
							}else if(activity_in_10_min.equals("1")){
								activity_in_10_min_3="selected";
							}else if(activity_in_10_min.equals("2")){
								activity_in_10_min_4="selected";
							}
							if(appearance_in_1_min.equals("")){
								appearance_in_1_min_1="selected";
							}else if(appearance_in_1_min.equals("0")){
								appearance_in_1_min_2="selected";
							}else if(appearance_in_1_min.equals("1")){
								appearance_in_1_min_3="selected";
							}else if(appearance_in_1_min.equals("2")){
								appearance_in_1_min_4="selected";
							}
							if(appearance_in_5_min.equals("")){
								appearance_in_5_min_1="selected";
							}else if(appearance_in_5_min.equals("0")){
								appearance_in_5_min_2="selected";
							}else if(appearance_in_5_min.equals("1")){
								appearance_in_5_min_3="selected";
							}else if(appearance_in_5_min.equals("2")){
								appearance_in_5_min_4="selected";
							}
							if(appearance_in_10_min.equals("")){
								appearance_in_10_min_1="selected";
							}else if(appearance_in_10_min.equals("0")){
								appearance_in_10_min_2="selected";
							}else if(appearance_in_10_min.equals("1")){
								appearance_in_10_min_3="selected";
							}else if(appearance_in_10_min.equals("2")){
								appearance_in_10_min_4="selected";
							}
							
							
							String dis = "";
							if(((String) hashMap.get("q_outcome")).equals("S")||!((String) hashMap.get("q_bba_yn")).equals("I")) { 
								dis							= "disabled";
								if(!isRegNewbornApplicable){
									q_apgar_score				= "";
									q_apgar_score_in_5_mins		= "";
									q_apgar_score_in_10_mins	= "";
								}
							} %>
							 <script> 
								document.forms[0].apgar_score.value='<%=q_apgar_score%>';
								document.forms[0].apgar_score_five_min.value='<%=q_apgar_score_in_5_mins%>';
								document.forms[0].apgar_score_ten_min.value='<%=q_apgar_score_in_10_mins%>';
							 </script>
					<%}
					%>
					</td>
				</tr>
					<tbody id='apgarDivID' style="visibility:hidden;display:none">
							<tr><td class='label'><fmt:message key="eMP.Activity.label" bundle="${mp_labels}"/></td><td><input type='text' readonly name='activity_in_1_min' id='activity_in_1_min' value='<%=activity_in_1_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='activity_in_1_min_sel' id='activity_in_1_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=activity_in_1_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=activity_in_1_min_2%>><fmt:message key="eMP.Absent.label" bundle="${mp_labels}"/></option><option value='1' <%=activity_in_1_min_3%>><fmt:message key="eMP.Armslegsextended.label" bundle="${mp_labels}"/></option><option value='2' <%=activity_in_1_min_4%>><fmt:message key="eMP.Activemovementwithflexedarmslegs.label" bundle="${mp_labels}"/></option></select></td><td><input type='text' readonly name='activity_in_5_min' id='activity_in_5_min' value='<%=activity_in_5_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='activity_in_5_min_sel' id='activity_in_5_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=activity_in_5_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=activity_in_5_min_2%>><fmt:message key="eMP.Absent.label" bundle="${mp_labels}"/></option><option value='1' <%=activity_in_5_min_3%>><fmt:message key="eMP.Armslegsextended.label" bundle="${mp_labels}"/></option><option value='2' <%=activity_in_5_min_4%>><fmt:message key="eMP.Activemovementwithflexedarmslegs.label" bundle="${mp_labels}"/></option></select></td><td><input type='text' readonly name='activity_in_10_min' id='activity_in_10_min' value='<%=activity_in_10_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='activity_in_10_min_sel' id='activity_in_10_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=activity_in_10_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=activity_in_10_min_2%>><fmt:message key="eMP.Absent.label" bundle="${mp_labels}"/></option><option value='1' <%=activity_in_10_min_3%>><fmt:message key="eMP.Armslegsextended.label" bundle="${mp_labels}"/></option><option value='2' <%=activity_in_10_min_4%>><fmt:message key="eMP.Activemovementwithflexedarmslegs.label" bundle="${mp_labels}"/></option></select></td></tr>
							<tr><td class='label'><fmt:message key="eMP.Pulse.label" bundle="${mp_labels}"/></td><td><input type='text' readonly name='heart_rate_in_1_min' id='heart_rate_in_1_min' value='<%=heart_rate_in_1_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='heart_rate_in_1_min_sel' id='heart_rate_in_1_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=heart_rate_in_1_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=heart_rate_in_1_min_2%>><fmt:message key="eMP.Absent.label" bundle="${mp_labels}"/></option><option value='1' <%=heart_rate_in_1_min_3%>><fmt:message key="eMP.Below100bpm.label" bundle="${mp_labels}"/></option><option value='2' <%=heart_rate_in_1_min_4%>><fmt:message key="eMP.Above100bpm.label" bundle="${mp_labels}"/></option></select></td><td><input type='text' readonly name='heart_rate_in_5_min' id='heart_rate_in_5_min' value='<%=heart_rate_in_5_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='heart_rate_in_5_min_sel' id='heart_rate_in_5_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=heart_rate_in_5_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=heart_rate_in_5_min_2%>><fmt:message key="eMP.Absent.label" bundle="${mp_labels}"/></option><option value='1' <%=heart_rate_in_5_min_3%>><fmt:message key="eMP.Below100bpm.label" bundle="${mp_labels}"/></option><option value='2' <%=heart_rate_in_5_min_4%>><fmt:message key="eMP.Above100bpm.label" bundle="${mp_labels}"/></option></select></td><td><input type='text' readonly name='heart_rate_in_10_min' id='heart_rate_in_10_min' value='<%=heart_rate_in_10_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='heart_rate_in_10_min_sel' id='heart_rate_in_10_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=heart_rate_in_10_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=heart_rate_in_10_min_2%>><fmt:message key="eMP.Absent.label" bundle="${mp_labels}"/></option><option value='1' <%=heart_rate_in_10_min_3%>><fmt:message key="eMP.Below100bpm.label" bundle="${mp_labels}"/></option><option value='2' <%=heart_rate_in_10_min_4%>><fmt:message key="eMP.Above100bpm.label" bundle="${mp_labels}"/></option></select></td></tr>
							<tr><td class='label'><fmt:message key="eMP.Grimace.label" bundle="${mp_labels}"/></td><td><input type='text' readonly name='grimace_in_1_min' id='grimace_in_1_min' value='<%=grimace_in_1_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='grimace_in_1_min_sel' id='grimace_in_1_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=grimace_in_1_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=grimace_in_1_min_2%>><fmt:message key="eMP.NoResponse.label" bundle="${mp_labels}"/></option><option value='1' <%=grimace_in_1_min_3%>><fmt:message key="eMP.Facialgrimace.label" bundle="${mp_labels}"/></option><option value='2' <%=grimace_in_1_min_4%>><fmt:message key="eMP.Sneezecoughpullsaway.label" bundle="${mp_labels}"/></option></select></td><td><input type='text' readonly name='grimace_in_5_min' id='grimace_in_5_min' value='<%=grimace_in_5_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='grimace_in_5_min_sel' id='grimace_in_5_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=grimace_in_5_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=grimace_in_5_min_2%>><fmt:message key="eMP.NoResponse.label" bundle="${mp_labels}"/></option><option value='1' <%=grimace_in_5_min_3%>><fmt:message key="eMP.Facialgrimace.label" bundle="${mp_labels}"/></option><option value='2' <%=grimace_in_5_min_4%>><fmt:message key="eMP.Sneezecoughpullsaway.label" bundle="${mp_labels}"/></option></select></td><td><input type='text' readonly name='grimace_in_10_min' id='grimace_in_10_min' value='<%=grimace_in_10_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='grimace_in_10_min_sel' id='grimace_in_10_min_sel'  onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=grimace_in_10_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=grimace_in_10_min_2%>><fmt:message key="eMP.NoResponse.label" bundle="${mp_labels}"/></option><option value='1' <%=grimace_in_10_min_3%>><fmt:message key="eMP.Facialgrimace.label" bundle="${mp_labels}"/></option><option value='2' <%=grimace_in_10_min_4%>><fmt:message key="eMP.Sneezecoughpullsaway.label" bundle="${mp_labels}"/></option></select></td></tr>
							<tr><td class='label'><fmt:message key="eMP.Appearance.label" bundle="${mp_labels}"/></td><td><input type='text' readonly name='appearance_in_1_min' id='appearance_in_1_min' value='<%=appearance_in_1_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='appearance_in_1_min_sel' id='appearance_in_1_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=appearance_in_1_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=appearance_in_1_min_2%>><fmt:message key="eMP.Blue-graypaleallover.label" bundle="${mp_labels}"/></option><option value='1' <%=appearance_in_1_min_3%>><fmt:message key="eMP.Pinkbodyandblueextremities.label" bundle="${mp_labels}"/></option><option value='2' <%=appearance_in_1_min_4%>><fmt:message key="eMP.Normaloverentirebody-completelypink.label" bundle="${mp_labels}"/></option></select></td><td><input type='text' readonly name='appearance_in_5_min' id='appearance_in_5_min' value='<%=appearance_in_5_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='appearance_in_5_min_sel' id='appearance_in_5_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=appearance_in_5_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=appearance_in_5_min_2%>><fmt:message key="eMP.Blue-graypaleallover.label" bundle="${mp_labels}"/></option><option value='1' <%=appearance_in_5_min_3%>><fmt:message key="eMP.Pinkbodyandblueextremities.label" bundle="${mp_labels}"/></option><option value='2' <%=appearance_in_5_min_4%>><fmt:message key="eMP.Normaloverentirebody-completelypink.label" bundle="${mp_labels}"/></option></select></td><td><input type='text' readonly name='appearance_in_10_min' id='appearance_in_10_min' value='<%=appearance_in_10_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='appearance_in_10_min_sel' id='appearance_in_10_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=appearance_in_10_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=appearance_in_10_min_2%>><fmt:message key="eMP.Blue-graypaleallover.label" bundle="${mp_labels}"/></option><option value='1' <%=appearance_in_10_min_3%>><fmt:message key="eMP.Pinkbodyandblueextremities.label" bundle="${mp_labels}"/></option><option value='2' <%=appearance_in_10_min_4%>><fmt:message key="eMP.Normaloverentirebody-completelypink.label" bundle="${mp_labels}"/></option></select></td></tr>
							<tr><td class='label'><fmt:message key="eMP.Respiration.label" bundle="${mp_labels}"/></td><td><input type='text' readonly name='breathing_in_1_min' id='breathing_in_1_min' value='<%=breathing_in_1_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='breathing_in_1_min_sel' id='breathing_in_1_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=breathing_in_1_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=breathing_in_1_min_2%>><fmt:message key="eMP.Absent.label" bundle="${mp_labels}"/></option><option value='1' <%=breathing_in_1_min_3%>><fmt:message key="eMP.Slowirregular.label" bundle="${mp_labels}"/></option><option value='2' <%=breathing_in_1_min_4%>><fmt:message key="eMP.GoodCrying.label" bundle="${mp_labels}"/></option></select></td><td><input type='text' readonly name='breathing_in_5_min' id='breathing_in_5_min' value='<%=breathing_in_5_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='breathing_in_5_min_sel' id='breathing_in_5_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=breathing_in_5_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=breathing_in_5_min_2%>><fmt:message key="eMP.Absent.label" bundle="${mp_labels}"/></option><option value='1' <%=breathing_in_5_min_3%>><fmt:message key="eMP.Slowirregular.label" bundle="${mp_labels}"/></option><option value='2' <%=breathing_in_5_min_4%>><fmt:message key="eMP.GoodCrying.label" bundle="${mp_labels}"/></option></select></td><td><input type='text' readonly name='breathing_in_10_min' id='breathing_in_10_min' value='<%=breathing_in_10_min%>' maxlength=1 size=1 style="width:15px">&nbsp;<select name='breathing_in_10_min_sel' id='breathing_in_10_min_sel' onchange="apgarSelect(this)" <%=outcome_disalbed%>><option value='' <%=breathing_in_10_min_1%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<option value='0' <%=breathing_in_10_min_2%>><fmt:message key="eMP.Absent.label" bundle="${mp_labels}"/></option><option value='1' <%=breathing_in_10_min_3%>><fmt:message key="eMP.Slowirregular.label" bundle="${mp_labels}"/></option><option value='2' <%=breathing_in_10_min_4%>><fmt:message key="eMP.GoodCrying.label" bundle="${mp_labels}"/></option></select></td></tr>
					</tbody>
					
<%
	}
	catch(Exception e)
	{
		out.println("Exception in main"+e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	} 
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

