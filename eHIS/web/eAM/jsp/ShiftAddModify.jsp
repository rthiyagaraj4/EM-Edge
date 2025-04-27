<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<%
request.setCharacterEncoding("UTF-8");	
    String facility_id=(String)session.getValue("facility_id");
	String operation_type = "";
	String max_cont_work_durn = "";
	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
	conn = ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement("select max_continuous_work_duration from rs_parameter where facility_id=? ");
	pstmt.setString(1,facility_id);
	rs = pstmt.executeQuery();
	while(rs.next())
	{
		max_cont_work_durn = rs.getString(1);
	}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
	  if (pstmt != null) pstmt.close();
	  if (rs != null)   rs.close();
	  ConnectionManager.returnConnection(conn,request);
	}
	String mode = request.getParameter("mode");
	String shift_code = "";
	String short_desc = ""; 
	String long_desc = "";
	String productive_flag = "";
	String productive_flag1 = "";
	String shift_start_time = "";
	String shift_end_time = "";
	String shift_indicator = "";
	String mnemonic_key = "";
	String eff_status = "";
	String appl_for_working_days = "";
	String appl_for_nonworking_days = "";
	String appl_for_holidays = "";
	
	String appl_for_working_days_chk = "";
	String appl_for_nonworking_days_chk = "";
	String appl_for_holidays_chk = "";

	String shift_indi_hidden = "";
	
	String enabledChk = "";
	




	String startHour = "";
	String startMin = "";
	String endHour = "";
	String endMin = "";
	
	if(mode.equals("2"))
	{
		shift_code = request.getParameter("shift_code");
		short_desc = request.getParameter("short_desc");
		long_desc = request.getParameter("long_desc");
		shift_start_time = request.getParameter("shift_start_time");
		shift_end_time = request.getParameter("shift_end_time");
		shift_indicator =request.getParameter("shift_indicator");
		productive_flag = request.getParameter("productive_flag");
		mnemonic_key = request.getParameter("mnemonic_key");
		appl_for_working_days = request.getParameter("appl_for_working_days");
		appl_for_nonworking_days =request.getParameter("appl_for_nonworking_days");
		appl_for_holidays = request.getParameter("appl_for_holidays");
		eff_status = request.getParameter("eff_status");

		productive_flag1 = productive_flag;
		if(productive_flag.equals("W"))
			//productive_flag1="Working";
			productive_flag1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Working.label","common_labels");
		if(productive_flag.equals("O"))
			//productive_flag1="On Call";
			productive_flag1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OnCall.label","am_labels");
		if(shift_indicator.equalsIgnoreCase("Productive") || shift_indicator.equalsIgnoreCase("P"))
		{
			//shift_indicator = "Productive";
			shift_indicator = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Productive.label","am_labels");
			shift_indi_hidden = "P";
		}
		else
		{
			if(shift_indicator.equalsIgnoreCase("Unproductive") || shift_indicator.equalsIgnoreCase("U"))
			{
				//shift_indicator = "Unproductive";
				shift_indicator = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unproductive.label","common_labels");
				shift_indi_hidden = "U";
			}
			else
			{
				if(shift_indicator.equalsIgnoreCase("Absence") || shift_indicator.equalsIgnoreCase("A"))
				{
					shift_indicator = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Absence.label","common_labels");
					shift_indi_hidden = "A";
				}
				else
				{
					//shift_indicator = "Leave";
					shift_indicator = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Leave.label","common_labels");
					shift_indi_hidden = "L";
				}
			}
		}

		if(eff_status.equalsIgnoreCase("E"))
			enabledChk = "checked";

		if(appl_for_working_days.equalsIgnoreCase("Y"))
			appl_for_working_days_chk = "checked";
		if(appl_for_nonworking_days.equalsIgnoreCase("Y"))
			appl_for_nonworking_days_chk = "checked";
		if(appl_for_holidays.equalsIgnoreCase("Y"))
			appl_for_holidays_chk = "checked";

	
		StringTokenizer stFrom = new StringTokenizer(shift_start_time,":");
		StringTokenizer stTo   = new StringTokenizer(shift_end_time,":");

		startHour = stFrom.nextToken();
		startMin = stFrom.nextToken();
		endHour = stTo.nextToken();
		endMin = stTo.nextToken();
		
		if(productive_flag.equalsIgnoreCase("Working")||productive_flag.equalsIgnoreCase("W"))
		{
			
			productive_flag = "W";
		}
		else
		{
			productive_flag = "O";
			
		}
	}
	
%>
	<html>
     <head>
      	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		
		<script language='javascript' src='../../eRS/js/RSMessages.js' ></script>
		<script src='../js/Shift.js' language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		function disradio(mode)
	{
		if(mode!='1')
		{
			document.forms[0].productive_flag.disabled=true;
		}

	}
	</script>
	 </head>
	 <body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="shift_frm" id="shift_frm" action="../../servlet/eAM.ShiftServlet" method="post" target="messageFrame">
		<%
			if(mode.equals("1"))
			{
				operation_type = "insert";
		%>
			<br>
			<!--<br>
			<br>
			<br>-->
			<table border='0' cellpadding='2' cellspacing='0' align='center' width="90%">
			
			<tr>
				<td class="label" width="30%"> <fmt:message key="Common.ShiftIndicator.label" bundle="${common_labels}"/> &nbsp</td>
				<td class='fields' colspan="3">
				<select name="shift_indicator" id="shift_indicator" onchange="showShiftIndicatorType(this)">
					<option value="" selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---  </option>
					<option value="P"><fmt:message key="eAM.Productive.label" bundle="${am_labels}"/></option>
					<option value="U"><fmt:message key="Common.Unproductive.label" bundle="${common_labels}"/></option>
				</select>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				<label class='label' id='show_shift_radio'></label>	
				</td>
					
			</tr>
			
			<tr>
				<td class="label" width="30%"><fmt:message key="eAM.ShiftID.label" bundle="${am_labels}"/> &nbsp</td>
				<td class="fields" width="40%">
				<input type=text name="shift_code" id="shift_code" size=4 maxlength=4 onKeyPress="return CheckForSpecChars(event)" OnBlur='ChangeUpperCase(this)' >
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td><td>&nbsp;</td><td>&nbsp;</td>
			</tr>
			
			<tr>
				<td class="label" width="30%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> &nbsp</td>
				<td class="fields" width="40%">
				<input type=text name="short_desc" id="short_desc" size=15 maxlength=15 >
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td><td>&nbsp;</td><td>&nbsp;</td>
			</tr>
			
			<tr>
				<td class="label" width="30%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/> &nbsp</td>
				<td class="fields" width="40%">
				<input type=text name="long_desc" id="long_desc" size=30 maxlength=30 >
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td><td>&nbsp;</td><td>&nbsp;</td>
			</tr>
			
			<tr> 
				<td class="label" width="30%"><div align='bottom'><fmt:message key="eAM.ShiftTimings.label" bundle="${am_labels}"/>(hh:mi) &nbsp</div></td>
				<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
					<td>&nbsp;</td>
				<td class='fields' >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
					
				</tr>
					<tr><td>&nbsp;</td>
				<td class='fields'>
				<input type=text size=1 name='starthour' id='starthour' maxlength=2 align='right' onblur='CheckNum(this);CheckForHours(this);' onKeyPress="return allowPositiveNumber();"> :
				<input type=text size=1 name='startmin' id='startmin' maxlength=2 align='right' onblur='CheckNum(this);CheckForMinutes(this);'
				onKeyPress="return allowPositiveNumber()">&nbsp<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td><td><label class='label' id='show_from_mandatory'></label></td>
				
				<td class='fields'><input type=text size=1 name='endhour' id='endhour' maxlength=2 
				align='right' onblur='CheckNum(this);CheckForHours(this);' onKeyPress="return allowPositiveNumber()"> : 
				<input type=text size=1 name='endmin' id='endmin' maxlength=2 
				align='right'  onblur='CheckNum(this);CheckForMinutes(this);' onKeyPress="return allowPositiveNumber()">
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>
		
			<tr>
				<td class="label" width="30%"><fmt:message key="eAM.MnemonicforShiftID.label" bundle="${am_labels}"/> &nbsp</td>
				<td width="40%" class='fields'>
				<input type=text name="mnemonic_key" id="mnemonic_key" size=1 maxlength=1 onKeyPress='return  CheckForSpecChars1(event);'>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td><td>&nbsp;</td><td>&nbsp;</td>
			</tr>
			<tr>
			<td colspan="4">&nbsp</td>
			</tr>
			<tr>
				<th colspan="4" align='left'><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/>&nbsp<img src='../../eCommon/images/mandatory.gif'align='center'></img></th>
				
			</tr>
			<tr>
			<td colspan="4">&nbsp</td>
			</tr>


			<tr>
				<td class="label" colspan="0">
				 <fmt:message key="Common.WorkingDays.label" bundle="${common_labels}"/></td>
				 <td class='fields'><input type=checkbox name='appl_for_working_days' id='appl_for_working_days' onclick="checkActiveApplicable(this)"></td>
				 <td colspan="3">&nbsp</td>
			</tr>
			
			<tr>
				 <td class="label" width="30%"><fmt:message key="Common.Non-WorkingDays.label" bundle="${common_labels}"/></td><td class='fields' width="40%"><input type=checkbox name='appl_for_nonworking_days' id='appl_for_nonworking_days'
				 onclick="checkActiveApplicable(this)"></td>
				 <td colspan="3">&nbsp</td>
              </tr>
			 
				 <tr>
				  <td class="label" width="30%"><fmt:message key="Common.Holidays.label" bundle="${common_labels}"/></td><td class='fields' width="40%"><input type=checkbox name='appl_for_holidays' id='appl_for_holidays'
				 onclick="checkActiveApplicable(this)">&nbsp&nbsp
				</td><td class='label' colspan='2'>  </td>
			</tr>
			
			<tr>
				<td class="label" width="30%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/> &nbsp</td>
				<td class='fields' width="40%">
				<input type=checkbox name="eff_status" id="eff_status" onclick="checkActive(this)" value="E" checked>
				</td><td>&nbsp;</td><td>&nbsp;</td>
			</tr>
			
			</table>
			<input type=hidden name='appl_chk' id='appl_chk' value="">
		<%
			}
		else
		{
			operation_type = "modify";
		%>
			<br>
			<table border='0' cellpadding='2' cellspacing='0' align='center' width="90%">
			<tr>
				<td colspan="5">&nbsp</td>
			</tr>
			<%
			if(shift_indicator.equalsIgnoreCase("Productive"))
			{
			%>
			<tr>
				<td class="label" width="20%"> <fmt:message key="Common.ShiftIndicator.label" bundle="${common_labels}"/> &nbsp</td>
				<td class='fields' colspan="3">
				<input type=text name='shift_indicator1' id='shift_indicator1' value='<%= shift_indicator %>' readOnly>
				<input type=hidden name='shift_indicator' id='shift_indicator' value='<%= shift_indi_hidden %>'>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				&nbsp;&nbsp;<b><%=productive_flag1%></b>
				</td>
			</tr>
			<%
			}
			else
			{
			%>
			<tr>
				<td class="label" width="20%"> <fmt:message key="Common.ShiftIndicator.label" bundle="${common_labels}"/> &nbsp</td>
				<td class='fields' colspan="3">
				<input type=text name='shift_indicator1' id='shift_indicator1' value='<%= shift_indicator %>' readOnly>
				<input type=hidden name='shift_indicator' id='shift_indicator' value='<%= shift_indi_hidden %>'>	
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				
					<label class='label' id='show_shift_radio'></label>	
				
				</td>
			</tr>
			<%
			}
			%>
			
			<tr>
				<td class="label" width="20%"><fmt:message key="eAM.ShiftID.label" bundle="${am_labels}"/> &nbsp</td>
				<td class='fields' width="40%">
			
				<input type=text name="shift_code" id="shift_code" size=4 maxlength=4 value='<%= shift_code %>' readOnly>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td><td>&nbsp;</td><td>&nbsp;</td>
			</tr>
			
			<tr>
				<td class="label" width="20%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> &nbsp</td>
				<td class='fields' width="40%">
			<%
			if(eff_status.equalsIgnoreCase("E"))
			{
			%>
				<input type=text name="short_desc" id="short_desc" size=15 maxlength=15 value='<%= short_desc%>'>
			<%
			}else{	
			%>
				<input type=text name="short_desc" id="short_desc" size=15 maxlength=15 value='<%= short_desc%>' readOnly>
			<%
			}
			%>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td><td>&nbsp;</td><td>&nbsp;</td>
			</tr>
			
			<tr>
				<td class="label" width="20%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/> &nbsp</td>
				<td class='fields' width="40%">
			<%
			if(eff_status.equalsIgnoreCase("E"))
			{
			%>
				<input type=text name="long_desc" id="long_desc" size=30 maxlength=30 value='<%= long_desc %>'>
			<%
			}else{
			%>
				<input type=text name="long_desc" id="long_desc" size=30 maxlength=30 value='<%= long_desc %>' readOnly>
			<%
			}	
			%>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td><td>&nbsp;</td><td>&nbsp;</td>
			</tr>
			
			<%
			if(eff_status.equalsIgnoreCase("E"))
			{
				if(shift_indicator.equalsIgnoreCase("Productive") || shift_indicator.equalsIgnoreCase("Unproductive"))
				{

			%>  
			<tr>
				<td class="label" width="30%"><div align='bottom'><fmt:message key="eAM.ShiftTimings.label" bundle="${am_labels}"/>(hh:mi) &nbsp</div></td>
				<td class="fields"><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
					
				<td class="fields"><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td><td>&nbsp;</td>
				</tr><tr><td>&nbsp;</td><td class='fields'>
				<input type=text size=2 name='starthour' id='starthour' maxlength=2 align='right' 
				value='<%= startHour %>' onblur='CheckForHours(this); CheckNum(this); ' onKeyPress='return  allowValidNumber(this,event,2,0);'> :
				<input type=text size=2 name='startmin' id='startmin' maxlength=2 align='right'
				value='<%= startMin %>' onblur='CheckForMinutes(this); CheckNum(this); ' onKeyPress='return  allowValidNumber(this,event,2,0); '>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				&nbsp&nbsp&nbsp
				</td><td class='fields'>
				<input type=text size=2 name='endhour' id='endhour' maxlength=2 align='right'
				value='<%= endHour %>' onblur='CheckForHours(this); CheckNum(this);' onKeyPress='return  allowValidNumber(this,event,2,0);'> :
				<input type=text size=2 name='endmin' id='endmin' maxlength=2 align='right' 
				value='<%= endMin %>' 
onblur='CheckForMinutes(this); CheckNum(this);' onKeyPress='return  allowValidNumber(this,event,2,0); '>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td><td>&nbsp;</td>
			</tr>
			<%
				}
				else
				{

			%>
		
				<tr>
				<td class="label" width="30%"><div align='bottom'><fmt:message key="eAM.ShiftTimings.label" bundle="${am_labels}"/>(hh:mi) &nbsp</div></td>
				<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
					
				<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td><td>&nbsp;</td>
				</tr><tr><td>&nbsp;</td><td class='fields'>
				<input type=text size=2 name='starthour' id='starthour' maxlength=2 align='right' 
				value='<%= startHour %>' onblur='CheckForHours(this); CheckNum(this);' onKeyPress='return  allowValidNumber(this,event,2,0); '> :
				<input type=text size=2 name='startmin' id='startmin' maxlength=2 align='right'
				value='<%= startMin %>' onblur='CheckForMinutes(this); CheckNum(this); ' onKeyPress='return  allowValidNumber(this,event,2,0); '>
				&nbsp&nbsp&nbsp
				</td><td class='fields'>
				<input type=text size=2 name='endhour' id='endhour' maxlength=2 align='right'
				value='<%= endHour %>' onblur='CheckForHours(this); CheckNum(this);' onKeyPress='return  allowValidNumber(this,event,2,0); '> :
				<input type=text size=2 name='endmin' id='endmin' maxlength=2 align='right' 
				value='<%= endMin %>'  
onblur='CheckForMinutes(this); CheckNum(this); ' onKeyPress='return  allowValidNumber(this,event,2,0); '><td>&nbsp;</td>
				</td>
			</tr>
			<%		
				}
			}else{	
				if(shift_indicator.equalsIgnoreCase("Productive") || shift_indicator.equalsIgnoreCase("Unproductive"))
				{

			%>
			<tr>
				<td class="label" width="30%"><div align='bottom'><fmt:message key="eAM.ShiftTimings.label" bundle="${am_labels}"/>(hh:mi) &nbsp</div></td>
				<td  class="fields">&nbsp;&nbsp;<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
					
				<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
					<td>&nbsp;</td>
				</tr>
				<tr><td>&nbsp;</td><td class='fields'>
				<input type=text size=2 name='starthour' id='starthour' maxlength=2 align='right' 
				value='<%= startHour %>' readOnly> :
				<input type=text size=2 name='startmin' id='startmin' maxlength=2 align='right'
				value='<%= startMin %>' readOnly>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				&nbsp&nbsp&nbsp
				</td><td class='fields'>
				<input type=text size=2 name='endhour' id='endhour' maxlength=2 align='right'
				value='<%= endHour %>' readOnly> :
				<input type=text size=2 name='endmin' id='endmin' maxlength=2 align='right' 
				value='<%= endMin %>' readOnly>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
					<td>&nbsp;</td>
			</tr>	
			<%
				}
				else
				{

			%>
				<tr>
				<td class="label" width="30%"><div align='bottom'><fmt:message key="eAM.ShiftTimings.label" bundle="${am_labels}"/>(hh:mi) &nbsp</div></td>
				<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
				<td class="fields">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
				<td>&nbsp;</td>
				</tr>
				<tr><td>&nbsp;</td><td class='fields'>
				<input type=text size=2 name='starthour' id='starthour' maxlength=2 align='right' 
				value='<%= startHour %>' readOnly> :
				<input type=text size=2 name='startmin' id='startmin' maxlength=2 align='right'
				value='<%= startMin %>' readOnly>
				&nbsp&nbsp&nbsp
				</td><td class='fields'>
				<input type=text size=2 name='endhour' id='endhour' maxlength=2 align='right'
				value='<%= endHour %>' readOnly> :
				<input type=text size=2 name='endmin' id='endmin' maxlength=2 align='right' 
				value='<%= endMin %>' readOnly>
				</td><td>&nbsp;</td>
			</tr>	
			<%
				}
			}
			%>
			
			<%
			if(eff_status.equalsIgnoreCase("E"))
			{
			%>
			<tr>
				<td class="label" width="20%"><fmt:message key="eAM.MnemonicforShiftID.label" bundle="${am_labels}"/> &nbsp</td>
				<td class='fields' width="40%">
				<input type=text name="mnemonic_key" id="mnemonic_key" size=1 maxlength=1 onKeyPress="return CheckForSpecChars1(event)" value='<%= mnemonic_key %>'>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td><td>&nbsp;</td><td>&nbsp;</td>
			</tr>

			<%
			}else{
			%>
							
			<tr>
				<td class="label" width="20%"><fmt:message key="eAM.MnemonicforShiftID.label" bundle="${am_labels}"/> &nbsp</td>
				<td class='fields' width="40%">
				<input type=text name="mnemonic_key" id="mnemonic_key" size=1 maxlength=1 onKeyPress="return CheckForSpecChars1(event)" value='<%= mnemonic_key %>' readOnly>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td><td>&nbsp;</td><td>&nbsp;</td>
			</tr>
			<%
			}
			%>	
			<tr>
			<td colspan="4">&nbsp</td>
			</tr>
			<tr>
				<th colspan="4" align='left'><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/>&nbsp<img src='../../eCommon/images/mandatory.gif'align='center'></img></th>
				
			</tr>
			<tr>
			<td colspan="4">&nbsp</td>
			</tr>
			
			<%
				
		
			if(eff_status.equalsIgnoreCase("E"))
			{
			%>
			<%
				if(shift_indicator.equalsIgnoreCase("Productive") || shift_indicator.equalsIgnoreCase("Unproductive"))
				{
			%>
			<tr>
				
				<td class="label" colspan="0">
				 <fmt:message key="Common.WorkingDays.label" bundle="${common_labels}"/><td class='fields'><input type=checkbox name='appl_for_working_days' id='appl_for_working_days' onclick="checkActiveApplicable(this)" <%=appl_for_working_days_chk%> 
					 value='<%=appl_for_working_days %>'></td>
					 <td colspan="3">&nbsp</td>
			</tr>
			<tr>

				<td class="label" width="30%"><fmt:message key="Common.Non-WorkingDays.label" bundle="${common_labels}"/></td><td class='fields' width="40%"><input type=checkbox name='appl_for_nonworking_days' id='appl_for_nonworking_days' onclick="checkActiveApplicable(this)" <%=appl_for_nonworking_days_chk%> value= '<%=appl_for_nonworking_days%>'></td>
				<td colspan="3">&nbsp</td>
             <tr>
				 <td class="label" width="30%"><fmt:message key="Common.Holidays.label" bundle="${common_labels}"/></td><td class='fields' width="40%"> <input type=checkbox name='appl_for_holidays' id='appl_for_holidays' onclick="checkActiveApplicable(this)" <%=appl_for_holidays_chk%>  
					 value='<%= appl_for_holidays%>'>
				</td><td colspan="2">&nbsp</td>
			</tr>
			<%
				}
				else
				{
					
			%>
				<tr>
			
				<td class="label" colspan="0">
				 <fmt:message key="Common.WorkingDays.label" bundle="${common_labels}"/><td class='fields'><input type=checkbox name='appl_for_working_days' id='appl_for_working_days' disabled ></td>
				 <td colspan="3">&nbsp</td>
				 </tr>
				 <tr>
				 <td class="label" width="30%"><fmt:message key="Common.Non-WorkingDays.label" bundle="${common_labels}"/></td><td class='fields' width="40%"><input type=checkbox name='appl_for_nonworking_days' id='appl_for_nonworking_days' disabled ></td>
				 <td colspan="3">&nbsp</td>
				</tr>
				<tr>
				    <td class="label" width="30%"><fmt:message key="Common.Holidays.label" bundle="${common_labels}"/></td><td class='fields' width="40%"><input type=checkbox name='appl_for_holidays' id='appl_for_holidays'  disabled 
					 ></td>
				</td><td colspan="2">&nbsp</td>
			</tr>
			<%
				}
			}else
			{%>
			
				 <tr>
			
				<td class="label" colspan="0">
				 <fmt:message key="Common.WorkingDays.label" bundle="${common_labels}"/><td class='fields'><input type=checkbox name='appl_for_working_days' id='appl_for_working_days' <%=appl_for_working_days_chk%> disabled ></td>
				 <td colspan="3">&nbsp</td>
				 </tr>
				 <tr>
				
               <td class="label" width="30%"><fmt:message key="Common.Non-WorkingDays.label" bundle="${common_labels}"/></td><td class='fields' width="40%"><input type=checkbox name='appl_for_nonworking_days' id='appl_for_nonworking_days' <%=appl_for_nonworking_days_chk%> disabled ></td>
			    <td colspan="3">&nbsp</td>
               </tr>
              <tr>

				  <td class="label" width="30%"><fmt:message key="Common.Holidays.label" bundle="${common_labels}"/></td><td class='fields' width="40%"><input type=checkbox name='appl_for_holidays' id='appl_for_holidays' <%=appl_for_holidays_chk%>   disabled>
				</td>
					<td colspan="2">&nbsp</td>
			 </tr> <%}%>
		    
			 <tr>
				<td class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/> </td>
				<td class='fields' ><input type=checkbox name="eff_status" id="eff_status" onclick="checkActive(this)" <%=enabledChk%> value="">
				</td>
					<td colspan='2'></td>
			 </tr>
			
			</table>
		<input type=hidden name='appl_chk' id='appl_chk' value="">
		
		<%
		}
		%>
			<input type=hidden name='productive_flagChk' id='productive_flagChk' value='<%=productive_flag1%>'>
			<input type=hidden name='productive_flag1' id='productive_flag1' value='<%=productive_flag%>'>
			<input type=hidden name="operation_type" id="operation_type" value="<%= operation_type %>">
			<input type='hidden' name='max_cont_work_durn' id='max_cont_work_durn' value = '<%= max_cont_work_durn %>'>
		</form>
	 </body>
	 </html>

