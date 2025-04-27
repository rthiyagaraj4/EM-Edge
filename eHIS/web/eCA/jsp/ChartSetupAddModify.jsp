<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History			Name			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------
?             100				?												created
12/01/2016	  IN057209			prathyusha										Intake And Output Chart Shift Total master set up	
14/01/2016	  IN058876			Raja											Added  unchkSummYN() to onclick function to hide and unhide[IN057209]
21/01/2019      IN067541        Sivabagyam M       21/01/2019       Ramesh G        ML-MMOH-CRF-1159
26/06/2020	  IN072777		  	Durga Natarajan	   26/06/2020		Ramesh G	AAKH-CRF-0097.2
--------------------------------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ChartAddmodify.label" bundle="${ca_labels}"/></title>
		<script src='../../eCA/js/ChartSetup.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	</head>
	<%
	Connection con = null;
	String disable_chartID = "";
	String sql = "";
	String long_desc = "";
	String short_desc = "";
	String eff_status = "";
	String thirdParty_vitals_appl_YN = "";//IN072777
	String vitalSignChk = "";//IN072777
	String day_summary_req_yn = "";
	// IN057209 start
	String day_start_time = "07:00";
	
	String  day_end_time= "06:59";
	String shift_summary_req_yn = "Y";
	// IN057209 end
	String summary_req_yn = "";
	
	String chk_day_summ_enabled = "checked";
	//IN057209 start
     String chk_shift_summ_enabled = "checked";
	String chk_eff_status = "checked";
	
	String shift_one_start_time="07:00";
	String shift_two_start_time="15:00";
	String shift_three_start_time="23:00";
	String shift_one_end_time="14:59";
	String shift_two_end_time="22:59";
	String shift_three_end_time="06:59";
	//IN057209 end
	String chk_summ_reqd = "checked";
	String disableTextBox = "";
	String disableCheckBox = "";
	String disableFromTime = "";
	String change_at_trans = "";
	//String chk_change_at_trans = "";
	String disable_list = "";
	String fixed_select = "";
	String variable_select = "";
	String chart_type = "";
	String chart_desc = "";
	String past_rec_scope_days = "3";
	String sql1 = "";
	String sql2 = "";
	String variableForIO = " disableConfig(this) ";
	String configDisable = "";

	StringTokenizer str_tok_start_time = null;
	StringTokenizer str2_start = null;
	StringTokenizer str_tok_end_time = null;
	StringTokenizer str2_end = null;
	//edited 12/31/2015 start
	StringTokenizer shift_one_tok_start_time = null;
	StringTokenizer shift_one_start = null;
	StringTokenizer shift_one_tok_end_time = null;
	StringTokenizer shift_one_end = null;
	
	StringTokenizer shift_two_tok_start_time = null;
	StringTokenizer shift_two_start = null;
	StringTokenizer shift_two_tok_end_time = null;
	StringTokenizer shift_two_end = null;

		
	StringTokenizer shift_three_tok_start_time = null;
	StringTokenizer shift_three_start = null;
	StringTokenizer shift_three_tok_end_time = null;
	StringTokenizer shift_three_end = null;
	String no_of_shifts="3";
	String shift_duration="8";
	
	//edited 12/31/2015 end


	PreparedStatement pstmtmodify = null;
	ResultSet rsmodify = null;

	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String chart_id = request.getParameter("chart_id")==null?"":request.getParameter("chart_id");

	if(mode=="insert" || mode.equals("insert")){
		chart_id = "";
		mode = "insert";
		variableForIO = " disableConfig(this) ";
	}
	else{
		mode = "modify";
		variableForIO = " disableConfig(this) ";
	}

	try{
		con = ConnectionManager.getConnection(request);

		if(mode.equals("insert")){
			chart_id = "";
		}
		else{
			mode = "modify";
			disable_chartID = "readOnly";
			//disable_list = " disabled ";

 //edited 12/31/2015 
 //IN057209  modified start 
            //sql = "select long_desc, short_desc, eff_status, summary_req_yn, day_summary_req_yn, day_start_time, day_end_time , /*Define_modifiable_at_trn_yn*/ config_type, spl_chart_type,past_rec_scope_days  from ca_chart where chart_id = ?";
			//IN072777 Start. 
			//sql = "select long_desc, short_desc, eff_status, summary_req_yn, day_summary_req_yn, day_start_time, day_end_time, shift_summary_req_yn, /*Define_modifiable_at_trn_yn*/ config_type, spl_chart_type,past_rec_scope_days,shift1_start_time,shift2_start_time,shift3_start_time,shift1_end_time,shift2_end_time,shift3_end_time,no_of_shifts,shift_duration  from ca_chart where chart_id = ?";
			sql = "select long_desc, short_desc, eff_status, summary_req_yn, day_summary_req_yn, day_start_time, day_end_time, shift_summary_req_yn, /*Define_modifiable_at_trn_yn*/ config_type, spl_chart_type,past_rec_scope_days,shift1_start_time,shift2_start_time,shift3_start_time,shift1_end_time,shift2_end_time,shift3_end_time,no_of_shifts,shift_duration,thirdparty_vitals_appl_yn  from ca_chart where chart_id = ?";//IN072777
			//IN072777 End.
			//IN057209 end
			pstmtmodify = con.prepareStatement(sql);
			pstmtmodify.setString(1,chart_id);
			rsmodify = pstmtmodify.executeQuery();

			if(rsmodify!=null){
				while(rsmodify.next()){
					long_desc = rsmodify.getString("long_desc")==null?"":rsmodify.getString("long_desc");
					short_desc = rsmodify.getString("short_desc")==null?"":rsmodify.getString("short_desc");
					eff_status = rsmodify.getString("eff_status")==null?"":rsmodify.getString("eff_status");
					summary_req_yn = rsmodify.getString("summary_req_yn")==null?"":rsmodify.getString("summary_req_yn");
					day_summary_req_yn = rsmodify.getString("day_summary_req_yn")==null?"":rsmodify.getString("day_summary_req_yn");
					day_start_time = rsmodify.getString("day_start_time")==null?"":rsmodify.getString("day_start_time");
					
					day_end_time = rsmodify.getString("day_end_time")==null?"":rsmodify.getString("day_end_time");
					//IN057209 start
					shift_summary_req_yn = rsmodify.getString("shift_summary_req_yn")==null?"":rsmodify.getString("shift_summary_req_yn");
					no_of_shifts = rsmodify.getString("no_of_shifts")==null?"":rsmodify.getString("no_of_shifts");
					shift_duration = rsmodify.getString("shift_duration")==null?"":rsmodify.getString("shift_duration");
					//IN057209 end
					System.out.println(shift_summary_req_yn+"  initial in jsp shift_summary_req_yn");
					// edited IN057209 start
					shift_one_start_time = rsmodify.getString("shift1_start_time")==null?"":rsmodify.getString("shift1_start_time");
					shift_two_start_time = rsmodify.getString("shift2_start_time")==null?"":rsmodify.getString("shift2_start_time");
					shift_three_start_time = rsmodify.getString("shift3_start_time")==null?"":rsmodify.getString("shift3_start_time");
					shift_one_end_time = rsmodify.getString("shift1_end_time")==null?"":rsmodify.getString("shift1_end_time");
					shift_two_end_time = rsmodify.getString("shift2_end_time")==null?"":rsmodify.getString("shift2_end_time");
					shift_three_end_time = rsmodify.getString("shift3_end_time")==null?"":rsmodify.getString("shift3_end_time");
					//edited 12/31/2015 end
				   //IN057209 end
					//change_at_trans = rsmodify.getString("Define_modifiable_at_trn_yn")==null?"":rsmodify.getString("Define_modifiable_at_trn_yn");
					change_at_trans = rsmodify.getString("config_type")==null?"":rsmodify.getString("config_type");
					chart_type = rsmodify.getString("spl_chart_type")==null?"":rsmodify.getString("spl_chart_type");
					past_rec_scope_days = rsmodify.getString("past_rec_scope_days")==null?"":rsmodify.getString("past_rec_scope_days");
					thirdParty_vitals_appl_YN = rsmodify.getString("thirdparty_vitals_appl_yn")==null?"N":rsmodify.getString("thirdparty_vitals_appl_yn");//IN072777

					//change_at_trans = rsmodify.getString("CONFIG_TYPE")==null?"":rsmodify.getString("CONFIG_TYPE");

					if(change_at_trans.equals("")) change_at_trans = "Y";
					
					if(summary_req_yn.equals("Y") || summary_req_yn.equals("y")){
						chk_summ_reqd = "checked";
					}
					else{
						chk_summ_reqd = "";
					}
					
					if(day_summary_req_yn.equals("Y")||day_summary_req_yn.equals("y")){
						chk_day_summ_enabled = "checked";
					}
					else{
						chk_day_summ_enabled = "";
						disableFromTime = " readOnly ";
					}
					//IN057209 start
					//edited on 12/31/2015 start
					if(shift_summary_req_yn.equals("Y") || shift_summary_req_yn.equals("y")){
						chk_shift_summ_enabled = "checked";
						
					}
					
					else{
						chk_shift_summ_enabled = "";	
					
						}
						if(no_of_shifts.equals("")){
						no_of_shifts="3";
						}
						if(shift_duration.equals("")){
						shift_duration="8";
						}
					//IN057209 end
					//IN072777 starts
						if(thirdParty_vitals_appl_YN.equals("Y"))
							vitalSignChk="checked";
						else 
							vitalSignChk="";
					//IN072777 ends
					//edited on 12/31/2015  end
					if(eff_status.equals("E") || eff_status.equals("e")){
						chk_eff_status = "checked";
					}
					else{
						chk_eff_status = "";
						disableTextBox = " readOnly ";
						disableCheckBox = " disabled ";
						disable_list = " disabled ";
					}		

					if(change_at_trans.equals("N") || change_at_trans.equals("n")){
						fixed_select = "selected";
						variable_select = "";
					}
					else{
						variable_select = "selected";
						fixed_select = "";
					}
							if(chart_type.equals("IO"))
					{
						configDisable = " disabled ";
					}

					if(summary_req_yn.equals("N") || summary_req_yn.equals("n")){
						
					}

					str_tok_start_time = new StringTokenizer(day_start_time," ");
					//String str1 = "";
					String str2 = "";
					String hr = "";
					String min = "";
					while(str_tok_start_time.hasMoreTokens()){
						//str1 = str_tok_start_time.nextToken();
						str_tok_start_time.nextToken();
						str2 = str_tok_start_time.nextToken();
						str2_start = new StringTokenizer(str2,":");
						hr = str2_start.nextToken();
						min = str2_start.nextToken();
					}
					day_start_time = hr+":"+min;

					str_tok_end_time = new StringTokenizer(day_end_time," ");
					//String str3 = "";
					String str4 = "";
					String hr1 = "";
					String min1 = "";
					while(str_tok_end_time.hasMoreTokens()){
						//str3 = str_tok_end_time.nextToken();
						str_tok_end_time.nextToken();
						str4 = str_tok_end_time.nextToken();
						str2_end = new StringTokenizer(str4,":");
						hr1 = str2_end.nextToken();
						min1 = str2_end.nextToken();
					}
					day_end_time = hr1+":"+min1;
					//IN057209 start

					if(shift_one_start_time.equals("")){
						shift_one_start_time = "";
					}
					else{
					shift_one_tok_start_time = new StringTokenizer(shift_one_start_time," ");
					
					String shiftOneStart = "";
					String shiftOneStartHr = "";
					String shiftOneStartMin = "";
					while(shift_one_tok_start_time.hasMoreTokens()){
						shift_one_tok_start_time.nextToken();
						shiftOneStart= shift_one_tok_start_time.nextToken();
						shift_one_start = new StringTokenizer(shiftOneStart,":");
						shiftOneStartHr = shift_one_start.nextToken();
						shiftOneStartMin = shift_one_start.nextToken();
					}
					shift_one_start_time = shiftOneStartHr+":"+shiftOneStartMin;	
					
					}
					if(shift_one_end_time.equals("")){
						shift_one_end_time="";
					}
					else{
						
					
				shift_one_tok_end_time = new StringTokenizer(shift_one_end_time," ");
					
					String shiftOneEnd = "";
					String shiftOneEndHr = "";
					String shiftOneEndMin = "";
					while(shift_one_tok_end_time.hasMoreTokens()){
						shift_one_tok_end_time.nextToken();
						shiftOneEnd= shift_one_tok_end_time.nextToken();
						shift_one_end = new StringTokenizer(shiftOneEnd,":");
						shiftOneEndHr = shift_one_end.nextToken();
						shiftOneEndMin = shift_one_end.nextToken();
					}
					shift_one_end_time = shiftOneEndHr+":"+shiftOneEndMin;	
					}
					if(shift_two_start_time.equals("")){
						shift_two_start_time="";
					}
					else{
									
					
			   shift_two_tok_start_time = new StringTokenizer(shift_two_start_time," ");
					
					String shiftTwoStart = "";
					String shiftTwoStartHr = "";
					String shiftTwoStartMin = "";
					while(shift_two_tok_start_time.hasMoreTokens()){
						shift_two_tok_start_time.nextToken();
						shiftTwoStart= shift_two_tok_start_time.nextToken();
						shift_two_start = new StringTokenizer(shiftTwoStart,":");
						shiftTwoStartHr = shift_two_start.nextToken();
						shiftTwoStartMin = shift_two_start.nextToken();
					}
					shift_two_start_time = shiftTwoStartHr+":"+shiftTwoStartMin;	
					}
					
				if(shift_two_end_time.equals("")){
					shift_two_end_time="";	
					}
					else{
									
					
				shift_two_tok_end_time = new StringTokenizer(shift_two_end_time," ");
					
					String shiftTwoEnd = "";
					String shiftTwoEndHr = "";
					String shiftTwoEndMin = "";
					while(shift_two_tok_end_time.hasMoreTokens()){
						shift_two_tok_end_time.nextToken();
						shiftTwoEnd= shift_two_tok_end_time.nextToken();
						shift_two_end = new StringTokenizer(shiftTwoEnd,":");
						shiftTwoEndHr = shift_two_end.nextToken();
						shiftTwoEndMin = shift_two_end.nextToken();
					}
					shift_two_end_time = shiftTwoEndHr+":"+shiftTwoEndMin;	
					}
				
				if(shift_three_start_time.equals("")){
					shift_three_start_time="";
				}
				else{
					
				
					shift_three_tok_start_time = new StringTokenizer(shift_three_start_time," ");
						
						String shiftThreeStart = "";
						String shiftThreeStartHr = "";
						String shiftThreeStartMin = "";
						while(shift_three_tok_start_time.hasMoreTokens()){
							shift_three_tok_start_time.nextToken();
							shiftThreeStart= shift_three_tok_start_time.nextToken();
							shift_three_start = new StringTokenizer(shiftThreeStart,":");
							shiftThreeStartHr = shift_three_start.nextToken();
							shiftThreeStartMin = shift_three_start.nextToken();
						}
						shift_three_start_time = shiftThreeStartHr+":"+shiftThreeStartMin;	
						
				}
				if(shift_three_end_time.equals("")){
					shift_three_end_time="";
				}
				else{
					
				
					shift_three_tok_end_time = new StringTokenizer(shift_three_end_time," ");
						
						String shiftThreeEnd = "";
						String shiftThreeEndHr = "";
						String shiftThreeEndMin = "";
						while(shift_three_tok_end_time.hasMoreTokens()){
							shift_three_tok_end_time.nextToken();
							shiftThreeEnd= shift_three_tok_end_time.nextToken();
							shift_three_end = new StringTokenizer(shiftThreeEnd,":");
							shiftThreeEndHr = shift_three_end.nextToken();
							shiftThreeEndMin = shift_three_end.nextToken();
						}
						shift_three_end_time = shiftThreeEndHr+":"+shiftThreeEndMin;
				}
				
				//IN057209 end
					
					
					
					
					
					
									}
					
				
			}

		}
		if(rsmodify!=null) rsmodify.close();
		if(pstmtmodify!=null) pstmtmodify.close();
	}//end of try 
	catch(Exception e){
		//out.println("Exception in try of ChartSetupAddModify.jsp"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
/*	finally{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}*/
	%>

	<body   OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
		<form name='AddModifyChartSetupForm' id='AddModifyChartSetupForm' action='ChartSetupServlet' method='post'>
		<br><br><br><br><br><br>
			<table width='75%' border='0' cellspacing=0 cellpadding='3' align=center>
				<tr>
					<td width='40%' class='label' ><fmt:message key="eCA.ChartCode.label" bundle="${ca_labels}"/></td>
					<td width='60%' class='fields'><INPUT TYPE="text" name="chart_code" id="chart_code" size='8' value='<%=chart_id%>' maxlength = '4' onkeypress='return CheckForSpecChars(event)' <%=disable_chartID%>><img SRC="../../eCommon/images/mandatory.gif"></td>
				</tr> 
				<tr>
					<td width='40%' class='label' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
					<td width='60%' class='fields' ><INPUT TYPE="text" name="long_desc" id="long_desc" size='40' value='<%=long_desc%>' maxlength='40' <%=disableTextBox%> <%if(mode.equals("modify")){%>onclick='resetMsgFrame()'<%}
					%>><img SRC="../../eCommon/images/mandatory.gif"></td>
				</tr> 
				<tr>
					<td width='40%' class='label' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
					<td width='60%' class='fields'><INPUT TYPE="text" name="short_desc" id="short_desc" size='30' value='<%=short_desc%>' maxlength ='30' <%=disableTextBox%> <%if(mode.equals("modify")){%>onclick='resetMsgFrame()'<%}%>><img SRC="../../eCommon/images/mandatory.gif"></td>
				</tr> 
				<tr>
				<td width = '40%' class ='label'><fmt:message key="Common.Chart.label" bundle="${common_labels}"/> <fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td width ='40%' class= 'fields'>
				<%
				try{
					sql1 = "Select SPL_CHART_TYPE , SPL_CHART_TYPE_DESC From CA_SPL_CHART_TYPE where eff_status='E' Order by SPL_CHART_TYPE_DESC";
					sql2 = "Select SPL_CHART_TYPE_DESC From CA_SPL_CHART_TYPE where eff_status='E' AND SPL_CHART_TYPE = ?";

					PreparedStatement ps = null;
					ResultSet rs = null;

					if(mode.equals("insert"))
					{
						ps = con.prepareStatement(sql1);
						rs = ps.executeQuery();
					
						if(rs!=null)
						{
							chart_type = "";
							chart_desc = ""; 
						%>
							<SELECT name = "chart_type" id = "chart_type" onchange='<%=variableForIO%>' >
							<option value = ''><fmt:message key="Common.generic.label" bundle="${common_labels}"/> <fmt:message key="Common.Chart.label" bundle="${common_labels}"/></option>
						<%
						while(rs.next())
							{
							chart_type = rs.getString("SPL_CHART_TYPE") == null?"":rs.getString("SPL_CHART_TYPE") ;
							chart_desc = rs.getString("SPL_CHART_TYPE_DESC")==null?"":rs.getString("SPL_CHART_TYPE_DESC");
						
							%><option value = <%=chart_type%>><%=chart_desc%></option>	<%
							}
						}
						}
						else
						{
							String disChtType = "";
							ps = con.prepareStatement(sql2);
							ps.setString(1,chart_type);
							rs = ps.executeQuery();
							chart_desc = "";
							if(chart_type.equals("IO")) disChtType = "disabled ";
							else disChtType = "";
							chart_desc = "";
							if(rs!=null){
							if(rs.next())
								chart_desc = rs.getString("SPL_CHART_TYPE_DESC")==null?"":rs.getString("SPL_CHART_TYPE_DESC");
							}
						if(chart_desc.equals("") || chart_desc==null)
						{
							ps = con.prepareStatement(sql1);
							rs = ps.executeQuery();
						%>
							<SELECT name = "chart_type" id = "chart_type" <%=disChtType%> onchange='<%=variableForIO%>' >
							<option value = ''><fmt:message key="Common.generic.label" bundle="${common_labels}"/> <fmt:message key="Common.Chart.label" bundle="${common_labels}"/></option>
						<%
							if(rs!=null){
							chart_type = "";
							chart_desc = ""; 
						while(rs.next())
							{
							chart_type = rs.getString("SPL_CHART_TYPE") == null?"":rs.getString("SPL_CHART_TYPE") ;
							chart_desc = rs.getString("SPL_CHART_TYPE_DESC")==null?"":rs.getString("SPL_CHART_TYPE_DESC");
						
	 
							%><option value = <%=chart_type%>><%=chart_desc%></option>	<%
								}
							

							}
							}
							else
								{
						%>
								
							<SELECT name="chart_type" id="chart_type" disabled>
							<option value = '' >------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
							<option value = <%=chart_type%> selected ><%=chart_desc%></option> 
						<%	
								
							} 
						}
						if(rs != null)rs.close();
						if(ps != null)ps.close();

						}catch(Exception e){
								//out.println("Exception in try of ChartSetupAddModify.jsp"+e.toString());//COMMON-ICN-0181
								e.printStackTrace();//COMMON-ICN-0181
						}
						finally{
								if(con!=null) ConnectionManager.returnConnection(con,request);
							}
				%>
				</SELECT></td>
				</tr>
				<tr>
					<td width='40%' class='label' ><fmt:message key="eCA.SummaryRequired.label" bundle="${ca_labels}"/></td>
					<td width='60%' class='fields'><INPUT TYPE="checkbox" name="Summ_required" id="Summ_required" <%=chk_summ_reqd%> <%=disableCheckBox%> value='N' <%if(mode.equals("modify")){%>onclick="DisableControls();unchkSummYN();resetMsgFrame();reverseSelSummYN('<%=chart_id%>')"<%}else{%> onclick='DisableControls();unchkSummYN()' <%}%>> &nbsp;<fmt:message key="eCA.Configuration.label" bundle="${ca_labels}"/>&nbsp;<SELECT name="change_at_trans" id="change_at_trans" <%=disable_list%> <%if(mode.equals("modify")){%> onchange = "resetMsgFrame()"<%}%> <%=configDisable%>> 
															<option value = 'Y' <%=variable_select%>><fmt:message key="Common.Variable.label" bundle="${common_labels}"/></option> 
															<option value = 'N' <%=fixed_select%>><fmt:message key="Common.Fixed.label" bundle="${common_labels}"/></option>
														</SELECT>
					</td>  <!--ML-MMOH-CRF-0368/01(IN057209)- Linked Inc #[058876] -->
				</tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="eCA.SummaryBy.label" bundle="${ca_labels}"/></td>
					<td width='60%' class='fields'> <INPUT TYPE="checkbox" name="Summ_required_day" id="Summ_required_day" id="Summ_required_day" onclick='disableFromText();unchkSummYN()'<%=chk_day_summ_enabled%> value='Y' <%=disableCheckBox%> <%if(mode.equals("modify")){%>onclick='disableFromText();resetMsgFrame();unchkSummYN()'<%}%>><fmt:message key="Common.day.label" bundle="${common_labels}"/></td>
				</tr> 
				<tr>
					<td width='40%' class='label' ><fmt:message key="eCA.DaySummaryPeriodFrom.label" bundle="${ca_labels}"/></td>
					<td width='60%' class='fields'>
						<INPUT TYPE="text" name="day_summ_from" id="day_summ_from" size='6' value='<%=day_start_time%>' <%=disableTextBox%> onblur='chkValidityOfTime(this)' maxlength='5' onkeypress='return CheckForNumsAndColon(event)' <%=disableFromTime%> <%if(mode.equals("modify")){%>onclick='resetMsgFrame()'<%}%>>
						&nbsp;&nbsp;To &nbsp;
						<INPUT TYPE="text" name="day_summ_to" id="day_summ_to" size='6' readonly value='<%=day_end_time%>' onselect="this.selectionStart = this.selectionEnd;">
				</tr>
				<!-- <tr>
					<td width='40%' class='label' style='display:none'><fmt:message key="eCA.DaySummaryPeriodFrom.label" bundle="${ca_labels}"/></td>
					<td width='60%' class='fields' style='display:none'><INPUT TYPE="text" name="day_summ_from" id="day_summ_from" size='6' value='<%=day_start_time%>' <%=disableTextBox%> onblur='chkValidityOfTime(this)' maxlength='5' onkeypress='return CheckForNumsAndColon(event)' <%=disableFromTime%> <%if(mode.equals("modify")){%>onclick='resetMsgFrame()'<%}%>>&nbsp;&nbsp;To &nbsp;<INPUT TYPE="text" name="day_summ_to" id="day_summ_to" size='6' readonly value='<%=day_end_time%>'>
				</tr> -->
				<tr>
					<td width='40%' class='label'><fmt:message key="eCA.PastRecordsScope.label" bundle="${ca_labels}"/></td>
					<td width='60%' class='fields'><INPUT TYPE="text" name="past_rec_scope_days" id="past_rec_scope_days" size='2' maxlength='2' value='<%=past_rec_scope_days%>' <%=disableTextBox%> onkeypress='return allowValidNumber(this, event,2,0)' onblur="return checkForMinus(this)" <%if(mode.equals("modify")){%>onclick='resetMsgFrame()'<%}%>><label id='labelScope' class='label'><fmt:message key="Common.days.label" bundle="${common_labels}"/></label><img SRC="../../eCommon/images/mandatory.gif"></td>
				</tr>
				<tr>
					<td width='40%' class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<td width='60%' class='fields'><INPUT TYPE="checkbox" name="enabled" id="enabled"  <%=chk_eff_status%> value='<%=eff_status%>' <%if(mode.equals("modify")){%>onclick='resetMsgFrame()'<%}%>></td>
				</tr>
				<!-- IN057209 start -->
				<!-- Edited on 12/31/2015 -->
				<tr id="ShiftSummaryRequiredIdCheck" name="ShiftSummaryRequiredIdCheck">
					<td width='40%' class='label' ><fmt:message key="eCA.ShiftSummaryRequired.label" bundle="${ca_labels}"/></td>
					<td width='60%' class='fields'><INPUT TYPE="checkbox" name="shift_summary_required" id="shift_summary_required"  <%=chk_shift_summ_enabled%> value='<%=shift_summary_req_yn%>'  onclick="shiftSummaryRequiredChanged()"></td>
				</tr>
				
				<tr id='shift_count' name='shift_count'>
					<td width='40%' class='label' ><fmt:message key="eCA.NumberOfShifts.label" bundle="${ca_labels}"/></td>
					<td width='60%' class='fields'><INPUT TYPE="text" name="no_of_shifts" id="no_of_shifts" size='12' value='<%=no_of_shifts%>' maxlength = '1' onblur='return validateShiftNo(this)' ><img SRC="../../eCommon/images/mandatory.gif"></td>
				</tr> 
				
				<tr id='shift_duration' name='shift_duration'>
					<td width='40%' class='label'   ><fmt:message key="eCA.ShiftDuration.label" bundle="${ca_labels}"/></td>
					<td width='60%' class='fields'><INPUT TYPE="text" name="shift_hours" id="shift_hours" size='12' value='<%=shift_duration %>' maxlength = '2' onblur='return calculateShiftTimes(this)'  ><img SRC="../../eCommon/images/mandatory.gif"></td>
				</tr>
				<tr id="ShiftSummaryRequiredId" name="ShiftSummaryRequiredId">					
					<td width='100%' colspan="2">
						<table width='100%' border='0' cellspacing=0 cellpadding='2' align=center>
							 <tr>
							 <!-- <td width='40%' class='label' ><fmt:message key="eCA.ShiftOne.label" bundle="${ca_labels}"/></td>--><!--IN067541 -->
								<td width='40%' class='label' ><fmt:message key="eCA.AMShift.label" bundle="${ca_labels}"/></td><!--IN067541 -->
								<td width='60%' class='fields' >
									<input TYPE="text"  name="shift_one_summ_from" id="shift_one_summ_from" size='6' value='<%=day_start_time%>' onselect="this.selectionStart = this.selectionEnd;" readonly  maxlength='5'>
									&nbsp;&nbsp;To &nbsp;
									<input TYPE="text" id="shift1SummTo" name="shift_one_summ_to" id="shift_one_summ_to" size='6' readonly value='<%=shift_one_end_time%>' onselect="this.selectionStart = this.selectionEnd;" maxlength='5'>      
								</td>							
							</tr>
							<tr>
							<!-- <td width='40%' class='label' ><fmt:message key="eCA.ShiftTwo.label" bundle="${ca_labels}"/></td>--><!--IN067541 -->
								<td width='40%' class='label' ><fmt:message key="eCA.PMShift.label" bundle="${ca_labels}"/></td><!--IN067541 -->
								<td width='60%' class='fields'><INPUT TYPE="text"  name="shift_two_summ_from" id="shift_two_summ_from" size='6'  value='<%=shift_two_start_time%>' onselect="this.selectionStart = this.selectionEnd;" readonly  maxlength='5' >&nbsp;&nbsp;To &nbsp;<INPUT TYPE="text" id="shift2SummTo" name="shift_two_summ_to" id="shift_two_summ_to" size='6' readonly onselect="this.selectionStart = this.selectionEnd;" value='<%=shift_two_end_time%>'   maxlength='5' >
						
						</td>
							</tr>
							<tr>
								<!-- <td width='40%' class='label' ><fmt:message key="eCA.ShiftThree.label" bundle="${ca_labels}"/></td>--><!--IN067541 -->
								<td width='40%' class='label' ><fmt:message key="eCA.ONShift.label" bundle="${ca_labels}"/></td><!--IN067541 -->
								<td width='60%' class='fields'><INPUT TYPE="text"  name="shift_three_summ_from" id="shift_three_summ_from" size='6' value='<%=shift_three_start_time%>' onselect="this.selectionStart = this.selectionEnd;" readonly  maxlength='5' >&nbsp;&nbsp;To &nbsp;<INPUT TYPE="text" id="shift3SummTo" name="shift_three_summ_to" id="shift_three_summ_to" size='6' readonly value='<%=shift_three_end_time%>' onselect="this.selectionStart = this.selectionEnd;" maxlength='5' >
								

						</td>
							</tr>
						</table>
						
					</td>
				</tr>
				<!-- IN057209 end -->
				
				<!-- Edited on 12/31/2015 -->
				<!-- IN072777 starts -->
						<tr id="vital_signID" >
							<td width='40%' class='label' ><fmt:message key="eCA.applicableInterfacedData.label" bundle="${ca_labels}"/></td>
							<td width='60%' class='fields'><INPUT TYPE="checkbox" name="thirdParty_vitals_appl_YN" id="thirdParty_vitals_appl_YN" <%=vitalSignChk%> value='<%=thirdParty_vitals_appl_YN%>' onclick ="checkVitalSign(this)" <%if(mode.equals("modify")){%>onclick='resetMsgFrame()'<%}%>></td>
						</tr>
				<!-- IN072777 ends -->
			</table>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'></input>
			<input type='hidden' name='summ_req_yn' id='summ_req_yn' value='<%=summary_req_yn%>'></input>
			</form>
	</body>
	<script>
	//IN057209 start
	if('N'=='<%=day_summary_req_yn%>'){
		
		document.getElementById("ShiftSummaryRequiredIdCheck").style.display = 'none';
		document.getElementById("ShiftSummaryRequiredId").style.display = 'none';
		document.getElementById("shift_count").style.display = 'none';
		document.getElementById("shift_duration").style.display = 'none';
		}		
	if('N'=='<%=shift_summary_req_yn%>'){
			document.getElementById("ShiftSummaryRequiredId").style.display = 'none';
			document.getElementById("shift_count").style.display = 'none';
			document.getElementById("shift_duration").style.display = 'none';
		}else{
			document.getElementById("ShiftSummaryRequiredId").style.display = '';
			document.getElementById("shift_count").style.display = '';
			document.getElementById("shift_duration").style.display = '';
			
			}
		
	//IN057209 end
	//IN072777 starts
	if(document.AddModifyChartSetupForm.chart_type.value==''){
		document.getElementById("vital_signID").style.display = '';
	}else if (document.AddModifyChartSetupForm.chart_type.value!='')
		{
		document.getElementById("vital_signID").style.display = 'none';
		}
	//IN072777 ends
          
	</script>
</html>



