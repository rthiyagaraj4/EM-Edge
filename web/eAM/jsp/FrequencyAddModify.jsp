<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

 <%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*, eAM.*, eCommon.XSSRequestWrapper, eCommon.Common.*" %>
<html>

	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eAM/js/Frequency.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>
		
		function valid_dat(Obj)
		{
			if ((Obj.value=="0")||(Obj.value=="00")||(Obj.value=="000"))
			{
				alert(getMessage("INVALID_POSITIVE_NUMBER","Common"));
				Obj.focus();
			}
		}
		</script>
	</head>
  <body onKeyDown = 'lockKey()' OnMouseDown="CodeArrest();">
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String mode=request.getParameter("mode") ;
	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	ResultSet rs		= null;
	Statement stmt = null;
	PreparedStatement pstmt1 = null;
	String checked		= "";
	String red="";
	String dis="";
	conlCon = ConnectionManager.getConnection(request);
	StringBuffer sqlQry = new StringBuffer();
	StringBuffer result = new StringBuffer();
	String dura_type = "";
	String  dura_desc    = "";
	String freq_code="";
	String freq_desc1="";
	String freq_desc2="";
	String freq_desc="";
	String freq_desc_loc_lang="";
	String freq_nature="";
	String eff_status="";
	String scheduled_yn="";
	String start_time_assign="";
	String start_time_round="";
	String repeat_value="";
	String interval_value="";
	String repeat_durn_type="";
	String interval_durn_type="";
	String interval_modify_disabled="";
	String max_no_of_cycle="";
	freq_code=request.getParameter("freq_code");

	try
	{
	if(mode.equals("insert"))
	{
		sqlQry.append("select durn_type,durn_desc from am_duration_type ");
		pstmt = conlCon.prepareStatement( sqlQry.toString());
		rslRst = pstmt.executeQuery();

		if(rslRst.next())
		{
			do
			{
				dura_type=rslRst.getString("durn_type"); 
				dura_desc=rslRst.getString("durn_desc");
				result.append("<option value="+dura_type+">"+dura_desc+"</option>");
			}while(rslRst.next());
				out.println("<input type='hidden' name='mode' id='mode' value='update'>");
		}
		else
		{
			out.println("<input type='hidden' name='mode' id='mode' value='insert'>");
		}
%>
 <form name="frequency_form" id="frequency_form" method='post' target="messageFrame" action='../../servlet/eAM.FrequencyServlet'>
 <br><br><br>

 <table cellpadding=0 cellspacing=0 width="100%"  align="center" cols='3' >
	<tr>
		<td colspan="3" class="label">&nbsp;</td>
	</tr>
	<tr>
		<td class="label" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type="text" name="code" id="code" value="" size="4" maxlength="4" onBlur="ChangeUpperCase( this );"    onKeyPress="return CheckForSpecChars(event);">&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
		</td>
		<td class="label" colspan=''>&nbsp;</td>
	</tr>
	<tr>
		 <td colspan="3" class="label">&nbsp;</td>
	</tr>
	<tr>
		<td class="label"> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='fields'>
	    <input type="text" name="freq_desc" id="freq_desc" value=""  size="60" maxLength="60" onBlur="makeValidString( this );" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
		</td>
		<td class="label" colspan=''>&nbsp;</td>
	</tr>
	<tr>
			<td colspan="3" class="label">&nbsp;</td>
		</tr>	
	<tr>				  
		<td class="label"><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;1</td>
		<td class='fields'>
	    <input type="text" name="freq_desc1" id="freq_desc1" value=""  size="60" maxLength="40" onBlur="makeValidString( this );">
		</td>
		<td class="label" colspan=''>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3" class="label">&nbsp;</td>
		</tr>	
	<tr>
		<td class="label"><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;2</td>
		<td class='fields'>
	    <input type="text" name="freq_desc2" id="freq_desc2" value=""  size="60" maxLength="40" onBlur="makeValidString( this );">
		</td>
		<td class="label" colspan=''>&nbsp;</td>
	</tr>

	<tr>
		 <td colspan="3" class="label">&nbsp;</td>
	</tr>
	<!--<tr>
		<td class="label" nowrap><fmt:message key="eSM.LocalLanguage.label" bundle="${sm_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type="text" name="freq_desc_loc_lang" id="freq_desc_loc_lang" value=""  size="60" maxLength="60" onBlur="makeValidString( this );" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
		</td>
		<td class="label" colspan=''>&nbsp;</td>
	</tr>-->
	<tr>
		<td colspan="3" class="label">&nbsp;</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<select name="freq_nature" id="freq_nature" onChange="setEvery1(this);" value='' >
			<option value='I'><fmt:message key="eAM.Interval.label" bundle="${am_labels}"/></option>
			<option value='F' selected><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></option>
			<option value='Y'><fmt:message key="eAM.Cycle.label" bundle="${am_labels}"/>&nbsp;<fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></option> <!-- Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2-->
			<option value='P'><fmt:message key="Common.PRN.label" bundle="${common_labels}"/></option>
			<option value='O'><fmt:message key="eAM.OneTime.label" bundle="${am_labels}"/></option>
			<option value='C'><fmt:message key="Common.Continuous.label" bundle="${common_labels}"/></option>
		</select>
			<input type='hidden' name=freq_nature1 value = "">
			<img src="../../eCommon/images/mandatory.gif"></img></td>
		<td class="label" colspan=''>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3" class="label">&nbsp;</td>
	</tr>
	
	<!--  Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2-->
	<tr>
	<td class='label'>&nbsp;</td>
	<td id=tab_max class='fields'>&nbsp;</td>
	<td colspan="3" class="label">&nbsp;</td>
	</tr>

	<tr>
		<td id=tab1 class='label'>&nbsp;</td>
		<td class='fields' nowrap  id=tab2 ><input type='text' name="repeat" id="repeat" size='3' onkeypress="return CheckForNumber(event);"  onBlur="CheckNum(this);return valid_dat(this);" maxlength=3 style="text-align:right"><img src="../../eCommon/images/mandatory.gif"></img> <fmt:message key="eAM.RepeatsPer.label" bundle="${am_labels}"/>&nbsp<select name="repeatC" id="repeatC" onChange='setInterval(this)' ><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option><option value='M'><fmt:message key="Common.Minute.label" bundle="${common_labels}"/>(s)</option><option value='H'><fmt:message key="Common.hours.label" bundle="${common_labels}"/>(s)</option><option value='D'><fmt:message key="Common.day.label" bundle="${common_labels}"/>(s)</option><option value='W'><fmt:message key="Common.Week.label" bundle="${common_labels}"/>(s)</option><option value='L'><fmt:message key="Common.month.label" bundle="${common_labels}"/>(s)</option></select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
		<td nowrap class='fields' id=tab3>&nbsp;<fmt:message key="Common.Every.label" bundle="${common_labels}"/><input type='text' name="every" id="every" size='6' onkeypress="return CheckForNumber(event);" onBlur="CheckNum(this);return valid_dat(this);" maxlength=6 style="text-align:right" >&nbsp;<input type=text name="everyC" id="everyC" disabled onChange='setInterval(this)' size=8 maxlength=8><img src='../../eCommon/images/mandatory.gif'></img></td>
	</tr>
	<tr>
		<td class="label" colspan='3'>&nbsp;</td>
	</tr>
	<tr>
		<td class="label"  ><fmt:message key="eAM.Scheduled.label" bundle="${am_labels}"/>&nbsp;</td>
		<td class='fields'>
		<input type='checkbox' name='checkit' id='checkit' onClick="setStart1Time(this);" checked >
		<input type='hidden' name='scheduled' id='scheduled' value=''  onClick="setStartTime(this);" class=label >&nbsp;&nbsp;&nbsp;	
		<input type='hidden' name='scheduled1' id='scheduled1' value='' onClick="setStartTime(this);" tabIndex='1050' class=label>
		</td>
		<td class="label"  align='left'>
		</td>
	</tr>
	<tr>
		<td class="label" colspan='3'>&nbsp;</td>
	</tr>
	<tr id='TimeAssign'>
		<td class="label"><fmt:message key="eAM.StartTimeAssignment.label" bundle="${am_labels}"/></td>
		<td  class='fields'><select name="start_time_assign" id="start_time_assign" onChange='setSchedule(this);' >
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
			<option value='N' selected><fmt:message key="Common.next.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="eAM.Closest.label" bundle="${am_labels}"/></option>
		</select>
		</td>
		<td class="label">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3" class="label">&nbsp;</td>
	</tr>
	<tr id='RoundTo'>
		<td class="label"><fmt:message key="eAM.RoundTo.label" bundle="${am_labels}"/></td>
		<td class='fields' id="roundID">
		<select name="round_to" id="round_to" >
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
			
		</select>
		</td>
		<td class="label" colspan=''>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" colspan='3'>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type='checkbox' name='enable' id='enable' value='E' checked class=label>
		</td>
		<td class="label" colspan=''>&nbsp;</td>
	</tr>
	<tr>
	 	<td class="label" colspan='3'>&nbsp;</td>
	</tr>
</table>
 	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="function_id" id="function_id" value="Frequency">
	<input type='hidden' name='scheduled_yn' id='scheduled_yn' value="Y">  
	<input type="hidden" name="start_time_assign_temp" id="start_time_assign_temp" value="">
	</form>
   <script>
		document.frequency_form.code.focus() ;
	</script>

<%
	}//Insert Mode ends here 
	else
	{
		//readOnly="";
		//interval_modify_disabled="";
		try{
		// Modified by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2
		String sql = "SELECT FREQ_DESC, print_desc_1, print_desc_2, Decode(freq_nature, 'I', 'Interval', 'F', 'Frequency', 'P', 'PRN', 'C', 'Continuous', 'O', 'One Time', 'Y', 'Cycle Frequency') AS FREQ_NATURE, EFF_STATUS, SCHEDULED_YN, START_TIME_ASSIGN, START_TIME_ROUND, REPEAT_VALUE, INTERVAL_VALUE, REPEAT_DURN_TYPE, INTERVAL_DURN_TYPE, MAX_NO_OF_CYCLE FROM AM_FREQUENCY WHERE FREQ_CODE = :freq_code";
		
		//stmt = conlCon.createStatement();
		//rs = stmt.executeQuery(sql);
		
		pstmt1   = conlCon.prepareStatement(sql);
		pstmt1.setString	(	1,	freq_code		);
		rs		 = pstmt1.executeQuery();
		
		if(rs !=null && rs.next()) {
		freq_desc=rs.getString("freq_desc");
		freq_desc1=rs.getString("print_desc_1");
		freq_desc2=rs.getString("print_desc_2");
		if(freq_desc1 == null) freq_desc1="";
		if(freq_desc2 == null) freq_desc2="";

		//freq_desc_loc_lang=rs.getString("freq_desc_loc_lang");
		freq_nature=rs.getString("freq_nature");
		eff_status=rs.getString("eff_status");
		if (eff_status.equals("D"))
		{
			red = "readonly";
			dis = "disabled";
		}
		scheduled_yn=rs.getString("scheduled_yn");
		start_time_assign=rs.getString("start_time_assign");
		if(start_time_assign == null) start_time_assign="";
		start_time_round=rs.getString("start_time_round");
		if(start_time_round == null) start_time_round="";
		repeat_value=rs.getString("repeat_value");
		if(repeat_value == null) repeat_value="";
		interval_value=rs.getString("interval_value");
		if(interval_value == null) interval_value="";
		repeat_durn_type=rs.getString("repeat_durn_type");
		if(repeat_durn_type == null) repeat_durn_type="";
		interval_durn_type=rs.getString("interval_durn_type");
		if(interval_durn_type == null) interval_durn_type="";
		max_no_of_cycle=rs.getString("MAX_NO_OF_CYCLE"); //Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2 
		if(max_no_of_cycle == null) max_no_of_cycle="";
			}
		
		}catch(Exception e){
			//out.println(e.toString());
			e.printStackTrace();
		}
		if(freq_nature.equals("Continous"))
			freq_nature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continuous.label","common_labels");
		if(!freq_nature.equals("Frequency"))
		{
			interval_modify_disabled = "disabled";
		}
		if(repeat_durn_type.equals("M"))
		{
			interval_modify_disabled="disabled";
		}
	
%>
<form name='frequency_form' id='frequency_form' method='post'  target="messageFrame" action='../../servlet/eAM.FrequencyServlet'>
<br><br><br>
	<table border='0' cellpadding=0 cellspacing=0 width="100%"   align="center" cols='3' >
		<tr>
			<td class='label' colspan='3'>&nbsp;</td>
		</tr>
		<tr>
			<td  class="label" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class="fields" >&nbsp;&nbsp;
			<input type="text" name="code" id="code"  size="4" maxlength="4" readOnly value="<%=freq_code%>">&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
			</td>
			<td class="label" colspan=''>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3" class="label">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label"> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class="fields" >&nbsp;&nbsp;
			<input type="text" name="freq_desc" id="freq_desc"   size="60" maxLength="60"  value="<%=freq_desc%>" <%=red%>>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
			</td>
			<td class="label" colspan=''>&nbsp;</td>
		</tr>

		<tr>
			<td colspan="3" class="label">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;1</td>
			<td class="fields" >&nbsp;&nbsp;
			<input type="text" name="freq_desc1" id="freq_desc1"   size="60" maxLength="40"  value="<%=freq_desc1%>" <%=red%>>
			</td>
			<td class="label" colspan=''>&nbsp;</td>
		</tr>


		<tr>
			<td colspan="3" class="label">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;2</td>
			<td class="fields" >&nbsp;&nbsp;
			<input type="text" name="freq_desc2" id="freq_desc2"   size="60" maxLength="40"  value="<%=freq_desc2%>" <%=red%>>
			</td>
			<td class="label" colspan=''>&nbsp;</td>
		</tr>





		<tr>
			<td colspan="3" class="label">&nbsp;</td>
		</tr>
		<!--<tr>
			<td  class="label"><fmt:message key="eSM.LocalLanguage.label" bundle="${sm_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class="fields" >&nbsp;&nbsp;
			<input type="text" name="freq_desc_loc_lang" id="freq_desc_loc_lang"   size="60" maxLength="60"  value="<%=freq_desc_loc_lang%>" <%=red%>>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
			</td>
			<td class="label" colspan=''>&nbsp;</td>
		</tr>-->
		<tr>
			<td colspan="3" class="label">&nbsp;</td>
		</tr>	
		<tr>
			<td class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
			<td class='fields'>&nbsp;&nbsp;
<%
	if(freq_nature.equals("One Time"))
	{
		freq_nature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OneTime.label","am_labels");
	}
%>
		   <input type="text" name="freq_nature1" id="freq_nature1"   size="20" maxLength="20"  value='<%=freq_nature%>' readOnly>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
<%
	if(freq_nature.equals("Frequency"))
	{
%>
		<input type="hidden" name="freq_nature" id="freq_nature"   size="20" maxLength="20"  value='F' >
<%
	}
	else if(freq_nature.equals("Interval"))
	{
%>
		<input type="hidden" name="freq_nature" id="freq_nature"   size="20" maxLength="20"  value='I' >
<%
	}
	else if(freq_nature.equals("PRN"))
	{
%>
		<input type="hidden" name="freq_nature" id="freq_nature"   size="20" maxLength="20"  value='P'>
<%
	}
	else if(freq_nature.equals("Continuous"))
	{
%>
  		<input type="hidden" name="freq_nature" id="freq_nature"   size="20" maxLength="20"  value='C'>
<%
	}
	//Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2
	else if(freq_nature.equals("Cycle Frequency"))
	{
%>
  		<input type="hidden" name="freq_nature" id="freq_nature"   size="20" maxLength="20"  value='Y'>
<%
	}
	else
	{
%>
		<input type="hidden" name="freq_nature" id="freq_nature"   size="20" maxLength="20"  value='O'>
<%
	}
%>
		</td>
		<td class="label" colspan=''>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3" class="label">&nbsp;</td>
	</tr>
<% 
	if(freq_nature.equalsIgnoreCase("Frequency"))
	{
%>
	<tr>
<%
	String repeatVal="";	  
	if(repeat_durn_type.equals("H"))
	{
		repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels");
	}
	else if(repeat_durn_type.equals("M"))
	{
		repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute.label","common_labels");
	}
	else if(repeat_durn_type.equals("D"))
	{
		repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
	}
	else if(repeat_durn_type.equals("W"))
	{
		repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");
	}
    else
	{
		repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
	}
 %>	
		<td class="label"></td>

		<td  nowrap class='fields'>&nbsp;&nbsp;
		<input type="text" name="repeat" id="repeat"   size="6" maxLength="6"  readOnly value='<%=repeat_value%>' style="text-align:right">&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
		<fmt:message key="eAM.RepeatsPer.label" bundle="${am_labels}"/><input type="hidden" name="repeatC" id="repeatC"   value='<%=repeat_durn_type%>'>
		<input type=text  maxLength="6" size='6'  name='repeatC1' id='repeatC1' readOnly value='<%=repeatVal%>'><img src="../../eCommon/images/mandatory.gif"></td>
		<td class="fields" colspan='' nowrap><fmt:message key="Common.Every.label" bundle="${common_labels}"/>
		<input type="text" name="every" id="every"   size="6" maxLength="6"  readOnly value='<%=interval_value%>' style="text-align:right" >&nbsp;&nbsp;<input type=text size='6' maxLength="6"   name='everyC1' id='everyC1' <%=interval_modify_disabled%> <%=dis%> readOnly value='<%=repeatVal%>' ><img src="../../eCommon/images/mandatory.gif"></img><input type=hidden name='everyC' id='everyC' value=<%=interval_durn_type%> >
		</td>
	</tr>
<%
	}
	else if(freq_nature.equalsIgnoreCase("Interval"))
	{
		String repeatVal="";	  
		interval_modify_disabled="disabled";
		if(repeat_durn_type.equals("H"))
		{
			repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels");
		}
		else if(repeat_durn_type.equals("M"))
		{
			repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute.label","common_labels");
		}
		else if(repeat_durn_type.equals("D"))
		{
			repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
		}
		else if(repeat_durn_type.equals("W"))
		{
			repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");
		}
  		else
		{
			repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
		}
%>
	<tr>
		<td  class="label"><fmt:message key="Common.Every.label" bundle="${common_labels}"/></td>
		<td class="fields" nowrap>&nbsp;&nbsp;&nbsp;<input type="text" name="every" id="every"   size="6" maxLength="6"  readOnly value='<%=interval_value%>' style="text-align:right">&nbsp;&nbsp;<input type=text name='everyC1' id='everyC1' readOnly  value="<%=repeatVal%>"><img src="../../eCommon/images/mandatory.gif"></img><input type=hidden name='everyC' id='everyC'  readOnly  value="<%=interval_durn_type%>"> 
		<input type=hidden name=repeat value='1'>
		<input type=hidden name=repeatC value='1'>
		</td>
		<td class="label">&nbsp;</td>
	</tr>
<%
	}
  //Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2 - START
  else if(freq_nature.equalsIgnoreCase("Cycle Frequency"))
	{

	String repeatVal="";	  
	if(repeat_durn_type.equals("D"))
	{
		repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
	}
	else if(repeat_durn_type.equals("W"))
	{
		repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");
	}
    else
	{
		repeatVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
	}
 %>	
		
	<tr>
		<td class='label'>&nbsp;</td>
		<td id=tab_max class='fields'>&nbsp;&nbsp;
		<input type='text' maxlength=6 name='MaxCycle' id='MaxCycle' readOnly value='<%=max_no_of_cycle%>' size='6' style='text-align:right'><img src='../../eCommon/images/mandatory.gif'></img>&nbsp;<fmt:message key="eAM.MaxCycle.label" bundle="${am_labels}"/></td>
	</tr>
	<tr><td class='label'>&nbsp;</td></tr>
	<tr>
		<td class='label'>&nbsp;</td>
		<td  nowrap class='fields'>&nbsp;&nbsp;
		<input type="text" name="repeat" id="repeat"   size="6" maxLength="6"  readOnly value='<%=repeat_value%>' style="text-align:right">&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
		<fmt:message key="eAM.RepeatsPer.label" bundle="${am_labels}"/><input type="hidden" name="repeatC" id="repeatC"   value='<%=repeat_durn_type%>'>
		<input type=text  maxLength="6" size='6'  name='repeatC1' id='repeatC1' readOnly value='<%=repeatVal%>'><img src="../../eCommon/images/mandatory.gif"></td>
		
	</tr>

<%
	} //Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2 - END
	else{}
%>
	<tr>
		<td colspan="3" class="label">&nbsp;</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="eAM.Scheduled.label" bundle="${am_labels}"/>&nbsp;</td>
		<td class='fields'>&nbsp;&nbsp;		
<%  
	if(scheduled_yn.equals("Y"))
	{
%>	
		<input type ="checkbox" name='scheduled' id='scheduled' value="Y" disabled checked >
	
<%
	}
	else
	{
%>
		<input type ="checkbox" name='scheduled' id='scheduled' value="Y" disabled >
		
<%	
		interval_modify_disabled="disabled";
		
	}
%>
		</td>
		<td class="label">
		</td>
	</tr>
	<tr>
		<td colspan="3" class="label">&nbsp;</td>
	</tr>

	<tr <% if(freq_nature.equalsIgnoreCase("Cycle Frequency")){%> style="visibility:hidden" <%}%>> <!-- Added by Sangeetha on 3rd Jul 2017 for ML-MMOH-CRF-0345.2 -->
		<td class="label" ><fmt:message key="eAM.StartTimeAssignment.label" bundle="${am_labels}"/></td>
		<td class="fields" >&nbsp;&nbsp;&nbsp;
		<select name="start_time_assign" id="start_time_assign" <%=interval_modify_disabled%> <%=dis%>>
		<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
<% 
	if((freq_nature.equals("Frequency") && scheduled_yn.equals("N"))||!(freq_nature.equals("Frequency")))
	{ 
		if(start_time_assign.equals("T"))
		{
%>
			<option value='T' selected  ><fmt:message key="eAM.CurrentTime.label" bundle="${am_labels}"/></option>
			<option value='N' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="eAM.Closest.label" bundle="${am_labels}"/></option>
		</select>
<%
		}
		else if(start_time_assign.equals("N"))
		{
%>
			<option value='T'  ><fmt:message key="eAM.CurrentTime.label" bundle="${am_labels}"/></option>
			<option value='N' selected ><fmt:message key="Common.next.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="eAM.Closest.label" bundle="${am_labels}"/></option>
			</select>
<%
		}
		else if(start_time_assign.equals("P"))
		{
%>
			<option value='T'  ><fmt:message key="eAM.CurrentTime.label" bundle="${am_labels}"/></option>
			<option value='N' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></option>
			<option value='P' selected><fmt:message key="Common.previous.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="eAM.Closest.label" bundle="${am_labels}"/></option>
			</select>
<%
		}
		else if(start_time_assign.equals("C"))
		{
%>
			<option value='T'  ><fmt:message key="eAM.CurrentTime.label" bundle="${am_labels}"/></option>
			<option value='N' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></option>
			<option value='C' selected><fmt:message key="eAM.Closest.label" bundle="${am_labels}"/></option>
			</select>
<%	
		}
		else
		{	
%>
			<option value='T'  selected><fmt:message key="eAM.CurrentTime.label" bundle="${am_labels}"/></option>
			<option value='N' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="eAM.Closest.label" bundle="${am_labels}"/></option>
	
			</select>
<%
		}
	}
	else
	{
		 if(start_time_assign.equals("N"))
		{
%>
			<option value='N' selected ><fmt:message key="Common.next.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="eAM.Closest.label" bundle="${am_labels}"/></option>
				</select>
<%
		}
		else if(start_time_assign.equals("P"))
		{
%>
			<option value='N' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></option>
			<option value='P' selected><fmt:message key="Common.previous.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="eAM.Closest.label" bundle="${am_labels}"/></option>
				</select>
<%
		}
		else if(start_time_assign.equals("C"))
		{
%>
			<option value='N' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></option>
			<option value='C' selected><fmt:message key="eAM.Closest.label" bundle="${am_labels}"/></option>
			</select>
<%
		}
		else
		{	
%>
			<option value='N' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="eAM.Closest.label" bundle="${am_labels}"/></option>
			</select>
<%
		}	
	}
	
%>
		</td><td class="label">&nbsp;</td></tr>
	<tr>
		<td colspan="3" class="label">&nbsp;</td></tr>
	<tr <% if(freq_nature.equalsIgnoreCase("Cycle Frequency")){%> style="visibility:hidden" <%}%>> <!-- Added by Sangeetha on 3rd Jul 2017 for ML-MMOH-CRF-0345.2-->
		<td class="label"><fmt:message key="eAM.RoundTo.label" bundle="${am_labels}"/></td>
<%
	if(start_time_round.equals("S"))
	{
%>
		<td class='fields'>&nbsp;&nbsp;
		<select name="round_to" id="round_to" <%=interval_modify_disabled%> <%=dis%>>
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
			<option value='M'><fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='FM'>5th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='TM'>10th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='QH'><fmt:message key="eAM.QuarterHour.label" bundle="${am_labels}"/></option>
			<option value='H'><fmt:message key="eAM.Hour.label" bundle="${am_labels}"/></option>
		</select>
		</td>
<%
	}
	else if(start_time_round.equals("M"))
	{
%>
		<td class='fields'  >&nbsp;&nbsp;
		<select name="round_to" id="round_to" <%=interval_modify_disabled%> <%=dis%>>
				<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
				<option value='M' selected><fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
				<option value='FM'>5th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
				<option value='TM'>10th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
				<option value='QH'><fmt:message key="eAM.QuarterHour.label" bundle="${am_labels}"/></option>
				<option value='H'><fmt:message key="eAM.Hour.label" bundle="${am_labels}"/></option>
		</select>
		</td>
<%	}
	else if(start_time_round.equals("FM"))
	{
%>
		<td class='fields'  >&nbsp;&nbsp;
		<select name="round_to" id="round_to" <%=interval_modify_disabled%> <%=dis%>>
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
			<option value='M'><fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='FM' selected>5th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='TM'>10th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='QH'><fmt:message key="eAM.QuarterHour.label" bundle="${am_labels}"/></option>
			<option value='H'><fmt:message key="eAM.Hour.label" bundle="${am_labels}"/></option>
		</select>
		</td>
<%
	}
	else if (start_time_round.equals("TM"))
	{
%>	
		<td class='fields'  >&nbsp;&nbsp;
		<select name="round_to" id="round_to" <%=interval_modify_disabled%> <%=dis%>>
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
			<option value='M'><fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='FM'>5th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='TM' selected>10th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='QH'><fmt:message key="eAM.QuarterHour.label" bundle="${am_labels}"/></option>
			<option value='H'><fmt:message key="eAM.Hour.label" bundle="${am_labels}"/></option>
		</select>
		</td>
<%
	}
	else if(start_time_round.equals("QH"))
	{
%>
		<td class='fields'  >&nbsp;&nbsp;
		<select name="round_to" id="round_to" <%=interval_modify_disabled%> <%=dis%>>
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
			<option value='M'><fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='FM'>5th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='TM'>10th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='QH' selected><fmt:message key="eAM.QuarterHour.label" bundle="${am_labels}"/></option>
			<option value='H'><fmt:message key="eAM.Hour.label" bundle="${am_labels}"/></option>
		</select>
		</td>
<%
	}
	else if(start_time_round.equals("H"))
	{
%>
		<td class='fields'  >&nbsp;&nbsp;
		<select name="round_to" id="round_to" <%=interval_modify_disabled%> <%=dis%>>
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
			<option value='M'><fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='FM'>5th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='TM'>10th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='QH'><fmt:message key="eAM.QuarterHour.label" bundle="${am_labels}"/></option>
			<option value='H' selected><fmt:message key="eAM.Hour.label" bundle="${am_labels}"/></option>
		</select>
		</td>
<%
	}
	else
	{
%>
		<td class='fields'  >&nbsp;&nbsp;
		<select name="round_to" id="round_to" <%=interval_modify_disabled%> <%=dis%>>
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
			<option value='M'><fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='FM'>5th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='TM'>10th <fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
			<option value='QH'><fmt:message key="eAM.QuarterHour.label" bundle="${am_labels}"/></option>
			<option value='H'><fmt:message key="eAM.Hour.label" bundle="${am_labels}"/></option>
		</select>
		</td>
<%
	}
%>
		<td class="label" colspan=''>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" colspan='3'>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class="fields">&nbsp;&nbsp;
<%
	 checked="";
	if(eff_status.equals("E"))
	{
		checked="Checked";
	}
	else{}
%>
		<input value='E'  type='checkbox'  name='enable' id='enable' <%=checked%> >
		</td><td class="label" colspan=''>&nbsp;</td></tr>
	<tr>
		<td class="label" colspan='3'>&nbsp;</td></tr>
</table>

<%
	String str="";
	if(scheduled_yn.equals("Y"))
		str="Y";
	else
		str="N";
%>
		<input type="hidden" name="mode" id="mode" value="modify">
		<input type="hidden" name="function_id" id="function_id" value="Frequency">
		<input type="hidden" name="scheduled_yn" id="scheduled_yn" value="<%=str%>">
</form>
<%
		if(rs != null) rs.close();
		if(rslRst != null) rslRst.close();	
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(pstmt1 != null) pstmt1.close();
		
	}
}catch(Exception e) {
	//out.println("main try"+e);
	e.printStackTrace();
}
finally
{
	
	ConnectionManager.returnConnection(conlCon,request);
}

%>
</body>
</html>

