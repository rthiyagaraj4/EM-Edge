<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/10/2017      GHL-SCF-1161     Prathyusha  P      Exploring a new responsibility: STAFF SCHEDULING. Not functioning properly.[IN063635]
---------------------------------------------------------------------------------------------------------------
 -->
<%@ page language="java" contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eOR.Common.*" %>

<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/MstCodeCommon.js'></script>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language="javascript" src="../js/Workplace.js"></script>
</head>
<body onMouseDown="" onKeyDown="lockKey()">
	 <%
		Vector week_vector = new Vector();
		String week_day_str = "";
		StringTokenizer week_day_tokenizer = null;
		String mode = request.getParameter("mode");
		String readOnly="";
		String disable="";
		String selected="";

    	Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement stmt = null;
		ResultSet rs=null;

		PreparedStatement pstmt1=null;
		ResultSet rset=null;

		Vector locn_vector = new Vector();
		String query="";
		try
		{
		//query = "select locn_type,short_desc from am_care_locn_type order by short_desc";
		query = "select locn_type,short_desc from am_care_locn_type_lang_vw where language_id like ? order by short_desc";
		stmt = conn.prepareStatement(query);
		stmt.setString(1,locale);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			locn_vector.add(rs.getString("locn_type"));
			locn_vector.add(rs.getString("short_desc"));
		}
		}
		catch(Exception exp)
		{
            out.println(exp.toString());
		}
		finally
		{
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
		}
%>
<form name=frm_workplace method='POST' action='../../servlet/eRS.WorkplaceServlet'
		target='messageFrame' >
<%	
if(mode.equals("1"))	
{
	PreparedStatement pstmt = null ;
	ResultSet resultSet		= null;
	try{
		//Added for GHL-SCF-1161 start
	String facility_id = (String)session.getAttribute("facility_id");
	
	   int	count =0;
		pstmt = conn.prepareStatement("select count(*) as count from rs_parameter where facility_id=?");
		pstmt.setString(1,facility_id);
		
		resultSet = pstmt.executeQuery() ;
		while ( resultSet != null && resultSet.next() ) {
		count = resultSet.getInt("COUNT") ;
		  
		}
		System.out.println("count"+count); 
		if(count>0){//If else condtions added for GHL-SCF-1161
			//Added for GHL-SCF-1161 end
%>
	
		<br>
		<table border='0' cellpadding='0' cellspacing='0' align='center' width="90%">
			<tr>
				<td colspan="2">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="40%"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp</td>
				<td align="left" class="label" width="60%">
				<select name="locn_type" id="locn_type" onchange="">
				<option value="" selected>&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
				<%
					for(int i=0;i<locn_vector.size();i+=2){
				%>
					<option value='<%= (String)locn_vector.get(i)%>'><%= (String)locn_vector.get(i+1)%></option>
				<%
					}
				%>
				</select>				
				</td>
			</tr>			
			<tr>
				<td align="right" class="label" width="40%"><fmt:message key="eRS.WorkplaceCode.label" bundle="${rs_labels}"/></td>
				<td align="left" class="label" width="60%">
				<input type=text name="workplace_code" id="workplace_code" size=10 maxlength=10>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>			
			<tr>
				
				<td align="right" class="label" width="40%"><fmt:message key="eRS.WorkplaceDescription.label" bundle="${rs_labels}"/>&nbsp</td>
				<td align="left" class="label" width="60%">
				<input type=text name="workplace_desc" id="workplace_desc" size=30 maxlength=30>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>
			<tr>
				<th  align='center' colspan="2"><fmt:message key="eRS.OperatingHours.label" bundle="${rs_labels}"/></th>				
			</tr>
			<tr>
				<td align="right" class="label" width="40%"> &nbsp;</td>
				<td class="label" width="60%" align=left><fmt:message key="eRS.From(hh:mi).label" bundle="${rs_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.To(hh:mi).label" bundle="${rs_labels}"/>&nbsp;</td>			
			</tr>
			<tr>
				<td align="right" class="label" width="40%">
				<fmt:message key="eRS.WorkingDays.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td align="left" class="label" width="60%">
					<input type=text size=2 maxlength=2 name='wday_from_hh' id='wday_from_hh' onblur='CheckForHours(this)'  onKeyPress='return  allowValidNumber(this,event,2,0);'>:
					<input type=text size=2 maxlength=2 name='wday_from_mm' id='wday_from_mm' onblur='CheckForMinutes(this)'  onKeyPress='return  allowValidNumber(this,event,2,0);'>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type=text size=2 maxlength=2 name='wday_to_hh' id='wday_to_hh' onblur='CheckForHours(this)'  onKeyPress='return  allowValidNumber(this,event,2,0);'>:
					<input type=text size=2 maxlength=2 name='wday_to_mm' id='wday_to_mm' onblur='CheckForMinutes(this);'  onKeyPress='return  allowValidNumber(this,event,2,0);'>
				</td>
			</tr>
			<tr>
				<td align="right" class="label" width="40%">
				<fmt:message key="eRS.Non-WorkingDays.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td align="left" class="label" width="60%">
					<input type=text size=2 maxlength=2 name='nwday_from_hh' id='nwday_from_hh' onblur='CheckForHours(this)' onKeyPress='return  allowValidNumber(this,event,2,0);'>:
					<input type=text size=2 maxlength=2 name='nwday_from_mm' id='nwday_from_mm' onblur='CheckForMinutes(this)' onKeyPress='return  allowValidNumber(this,event,2,0);'>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type=text size=2 maxlength=2 name='nwday_to_hh' id='nwday_to_hh' onblur='CheckForHours(this)'  onKeyPress='return  allowValidNumber(this,event,2,0);'>:
					<input type=text size=2 maxlength=2 name='nwday_to_mm' id='nwday_to_mm' onblur='CheckForMinutes(this);'  onKeyPress='return  allowValidNumber(this,event,2,0);'>
				</td>
			</tr>
			<tr>
				<td align="right" class="label" width="40%">
				<fmt:message key="eRS.Holidays.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td align="left" class="label" width="60%">
					<input type=text size=2 maxlength=2 name='hday_from_hh' id='hday_from_hh' onblur='CheckForHours(this)'  onKeyPress='return  allowValidNumber(this,event,2,0);'>:
					<input type=text size=2 maxlength=2 name='hday_from_mm' id='hday_from_mm' onblur='CheckForMinutes(this)' onKeyPress='return  allowValidNumber(this,event,2,0);'>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type=text size=2 maxlength=2 name='hday_to_hh' id='hday_to_hh' onblur='CheckForHours(this)'  onKeyPress='return  allowValidNumber(this,event,2,0);'>:
					<input type=text size=2 maxlength=2 name='hday_to_mm' id='hday_to_mm' onblur='CheckForMinutes(this);'  onKeyPress='return  allowValidNumber(this,event,2,0);'>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">&nbsp</td>
			</tr>
			<tr>
				<td class='label' align='right'><fmt:message key="eRS.StaffUtilizationReviewOption.label" bundle="${rs_labels}"/>&nbsp; </td>
				<td class='label' align='left'>
				<select name='staff_util' id='staff_util' onchange=''>
					<option value=''> &nbsp; --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- &nbsp;</option>
					<option value='FD'><fmt:message key="eRS.DependencyBasedFTE.label" bundle="${rs_labels}"/></option>
					<option value='FT'><fmt:message key="eRS.FTE.label" bundle="${rs_labels}"/></option>
					<option value='SB'><fmt:message key="eRS.StafftoBedRatio.label" bundle="${rs_labels}"/></option>
					<option value='SP'><fmt:message key="eRS.StafftoPatientRatio.label" bundle="${rs_labels}"/></option>
				</select>
				</td>
			</tr>
	
			<tr>
				<td class='label' align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/> &nbsp;</td>
				<td align='left'><input type=checkbox name='eff_status' id='eff_status' checked>
				</td>
			</tr>
		</table>		
		
	<%
}
		//Added for GHL-SCF-1161 start
		else{
			%><script type="text/javascript">alert(getMessage("PARAMETER_SETUP_MISSING","RS"));history.go(-1);</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<%	
		}
		
}	catch(Exception exp_facility){
			out.println(exp_facility.toString());
		}
			finally{
			if(pstmt!=null) pstmt.close();
			if(resultSet!=null) resultSet.close();
		}
	//Added for GHL-SCF-1161 end
}
	else
	{
		// when mode is update

    	StringBuffer week_day_buffer = new StringBuffer();

		String workplace_code = request.getParameter("workplace_code");
		String sql_update="";

		try
		{
		//sql_update="select workplace_desc,locn_type,staff_util_review_opt,eff_status, TO_CHAR(working_day_start_time,'hh24:mi') working_day_start_time, TO_CHAR(working_day_end_time,'hh24:mi') working_day_end_time, TO_CHAR(nonworking_day_start_time,'hh24:mi') nonworking_day_start_time, TO_CHAR(nonworking_day_end_time,'hh24:mi') nonworking_day_end_time, TO_CHAR(holiday_start_time,'hh24:mi') holiday_start_time, TO_CHAR(holiday_end_time,'hh24:mi') holiday_end_time,week_1_day_1,week_1_day_2,week_1_day_3,week_1_day_4,week_1_day_5,week_1_day_6,week_1_day_7,week_2_day_1,week_2_day_2,week_2_day_3,week_2_day_4,week_2_day_5,week_2_day_6,week_2_day_7,week_3_day_1,week_3_day_2,week_3_day_3,week_3_day_4,week_3_day_5,week_3_day_6,week_3_day_7,week_4_day_1,week_4_day_2,week_4_day_3,week_4_day_4,week_4_day_5,week_4_day_6,week_4_day_7,week_5_day_1,week_5_day_2,week_5_day_3,week_5_day_4,week_5_day_5,week_5_day_6,week_5_day_7 from rs_workplace a where workplace_code=?";
		sql_update="SELECT workplace_desc,locn_type,staff_util_review_opt,eff_status, TO_CHAR(working_day_start_time,'hh24:mi') working_day_start_time, TO_CHAR(working_day_end_time,'hh24:mi') working_day_end_time, TO_CHAR(nonworking_day_start_time,'hh24:mi') nonworking_day_start_time, TO_CHAR(nonworking_day_end_time,'hh24:mi') nonworking_day_end_time, TO_CHAR(holiday_start_time,'hh24:mi') holiday_start_time, TO_CHAR(holiday_end_time,'hh24:mi') holiday_end_time,week_1_day_1,week_1_day_2,week_1_day_3,week_1_day_4,week_1_day_5,week_1_day_6,week_1_day_7,week_2_day_1,week_2_day_2,week_2_day_3,week_2_day_4,week_2_day_5,week_2_day_6,week_2_day_7,week_3_day_1,week_3_day_2,week_3_day_3,week_3_day_4,week_3_day_5,week_3_day_6,week_3_day_7,week_4_day_1,week_4_day_2,week_4_day_3,week_4_day_4,week_4_day_5,week_4_day_6,week_4_day_7,week_5_day_1,week_5_day_2,week_5_day_3,week_5_day_4,week_5_day_5,week_5_day_6,week_5_day_7 FROM rs_workplace_lang_vw a WHERE workplace_code=? and language_id = ?";

		pstmt1=conn.prepareStatement(sql_update);
		pstmt1.setString(1,workplace_code);
		pstmt1.setString(2,locale);
		rset=pstmt1.executeQuery();

     	String workplace_desc = "";
		String locn_type = "";
		String staff_util = "";
		String eff_status = "";
		String working_day_start_time = "";
		String working_day_end_time = "";
		String nonworking_day_start_time = "";
		String nonworking_day_end_time = "";
		String holiday_start_time = "";
		String holiday_end_time = "";


	if(rset!=null)
	{
	  while(rset.next())
	  {
   	workplace_desc = rset.getString("workplace_desc")==null ? "":rset.getString("workplace_desc");
	locn_type = rset.getString("locn_type")==null ? "":rset.getString("locn_type");
	if(locn_type.equals("")) locn_type ="&nbsp;";
	staff_util =rset.getString("staff_util_review_opt")==null ? "":rset.getString("staff_util_review_opt");
	eff_status = rset.getString("eff_status")==null ? "":rset.getString("eff_status");
	working_day_start_time = rset.getString("working_day_start_time")==null ? "": com.ehis.util.DateUtils.convertDate(rset.getString("working_day_start_time"),"HM","en",locale);
	working_day_end_time = rset.getString("working_day_end_time")==null ? "": com.ehis.util.DateUtils.convertDate(rset.getString("working_day_end_time"),"HM","en",locale);
	nonworking_day_start_time = rset.getString("nonworking_day_start_time")==null ? "": com.ehis.util.DateUtils.convertDate(rset.getString("nonworking_day_start_time"),"HM","en",locale);
	nonworking_day_end_time = rset.getString("nonworking_day_end_time")==null ? "": com.ehis.util.DateUtils.convertDate(rset.getString("nonworking_day_end_time"),"HM","en",locale);
	holiday_start_time = rset.getString("holiday_start_time")==null ? "": com.ehis.util.DateUtils.convertDate(rset.getString("holiday_start_time"),"HM","en",locale);
	holiday_end_time = rset.getString("holiday_end_time")==null ? "": com.ehis.util.DateUtils.convertDate(rset.getString("holiday_end_time"),"HM","en",locale);

	week_day_buffer.append(rset.getString("WEEK_1_DAY_1")==null ? "" : rset.getString("WEEK_1_DAY_1"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_1_DAY_2")==null ? "" : rset.getString("WEEK_1_DAY_2"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_1_DAY_3")==null ? "" : rset.getString("WEEK_1_DAY_3"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_1_DAY_4")==null ? "" : rset.getString("WEEK_1_DAY_4"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_1_DAY_5")==null ? "" : rset.getString("WEEK_1_DAY_5"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_1_DAY_6")==null ? "" : rset.getString("WEEK_1_DAY_6"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_1_DAY_7")==null ? "" : rset.getString("WEEK_1_DAY_7"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_2_DAY_1")==null ? "" : rset.getString("WEEK_2_DAY_1"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_2_DAY_2")==null ? "" : rset.getString("WEEK_2_DAY_2"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_2_DAY_3")==null ? "" : rset.getString("WEEK_2_DAY_3"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_2_DAY_4")==null ? "" : rset.getString("WEEK_2_DAY_4"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_2_DAY_5")==null ? "" : rset.getString("WEEK_2_DAY_5"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_2_DAY_6")==null ? "" : rset.getString("WEEK_2_DAY_6"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_2_DAY_7")==null ? "" : rset.getString("WEEK_2_DAY_7"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_3_DAY_1")==null ? "" : rset.getString("WEEK_3_DAY_1"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_3_DAY_2")==null ? "" : rset.getString("WEEK_3_DAY_2"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_3_DAY_3")==null ? "" : rset.getString("WEEK_3_DAY_3"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_3_DAY_4")==null ? "" : rset.getString("WEEK_3_DAY_4"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_3_DAY_5")==null ? "" : rset.getString("WEEK_3_DAY_5"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_3_DAY_6")==null ? "" : rset.getString("WEEK_3_DAY_6"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_3_DAY_7")==null ? "" : rset.getString("WEEK_3_DAY_7"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_4_DAY_1")==null ? "" : rset.getString("WEEK_4_DAY_1"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_4_DAY_2")==null ? "" : rset.getString("WEEK_4_DAY_2"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_4_DAY_3")==null ? "" : rset.getString("WEEK_4_DAY_3"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_4_DAY_4")==null ? "" : rset.getString("WEEK_4_DAY_4"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_4_DAY_5")==null ? "" : rset.getString("WEEK_4_DAY_5"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_4_DAY_6")==null ? "" : rset.getString("WEEK_4_DAY_6"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_4_DAY_7")==null ? "" : rset.getString("WEEK_4_DAY_7"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_5_DAY_1")==null ? "" : rset.getString("WEEK_5_DAY_1"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_5_DAY_2")==null ? "" : rset.getString("WEEK_5_DAY_2"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_5_DAY_3")==null ? "" : rset.getString("WEEK_5_DAY_3"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_5_DAY_4")==null ? "" : rset.getString("WEEK_5_DAY_4"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_5_DAY_5")==null ? "" : rset.getString("WEEK_5_DAY_5"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_5_DAY_6")==null ? "" : rset.getString("WEEK_5_DAY_6"));
	week_day_buffer.append(",");
	week_day_buffer.append(rset.getString("WEEK_5_DAY_7")==null ? "" : rset.getString("WEEK_5_DAY_7"));
			}
		}

		String working_day_start_hh = "";
		String working_day_start_mm = "";
		String working_day_end_hh = "";
		String working_day_end_mm = "";
		String nonworking_day_start_hh = "";
		String nonworking_day_start_mm = "";
		String nonworking_day_end_hh = "";
		String nonworking_day_end_mm = "";
		String holiday_start_hh = "";
		String holiday_start_mm = "";
		String holiday_end_hh = "";
		String holiday_end_mm = "";

		if(!working_day_start_time.equals("")){
			working_day_start_hh	=	working_day_start_time.substring(0,2);
			working_day_start_mm	=	working_day_start_time.substring(3);
		}
		
		if(!working_day_end_time.equals("")){
			working_day_end_hh	=	working_day_end_time.substring(0,2);
			working_day_end_mm	=	working_day_end_time.substring(3);
		}
		
		if(!nonworking_day_start_time.equals("")){
			nonworking_day_start_hh	=	nonworking_day_start_time.substring(0,2);
			nonworking_day_start_mm	=	nonworking_day_start_time.substring(3);
		}
		
		if(!nonworking_day_end_time.equals("")){
			nonworking_day_end_hh	=	nonworking_day_end_time.substring(0,2);
			nonworking_day_end_mm	=	nonworking_day_end_time.substring(3);
		}
		
		if(!holiday_start_time.equals("")){
			holiday_start_hh	=	holiday_start_time.substring(0,2);
			holiday_start_mm	=	holiday_start_time.substring(3);
		}
		
		if(!holiday_end_time.equals("")){
			holiday_end_hh	=	holiday_end_time.substring(0,2);
			holiday_end_mm	=	holiday_end_time.substring(3);
		}
		
		String week_day_buffer1 = week_day_buffer.toString();		
		week_day_tokenizer = new StringTokenizer(week_day_buffer1,",");
		if(eff_status.equals("D")){
			readOnly="readOnly";
			disable="disabled";
		}
		else{
			readOnly="";
			disable="";
		}
%>
		<br>
		<table border='0' cellpadding='0' cellspacing='0' align='center' width="90%">
			<tr>
				<td colspan="2">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="40%"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/> &nbsp</td>
				<td align="left" class="label" width="60%">
				<select name="locn_type" id="locn_type" onchange="" <%=disable%>>
					<option value=""> &nbsp&nbsp--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
				<%
					for(int i=0;i<locn_vector.size();i+=2){
						selected=locn_type.equals((String)locn_vector.get(i))?"selected":"";
				%>
					<option value='<%= (String)locn_vector.get(i)%>' <%=selected%>><%= (String)locn_vector.get(i+1)%></option>
				<%
					}
				%>
				</select>				
				</td>
			</tr>			
			<tr>
				<td align="right" class="label" width="40%"><fmt:message key="eRS.WorkplaceCode.label" bundle="${rs_labels}"/> &nbsp</td>
				<td align="left" class="label" width="60%">
				<input type=text name="workplace_code" id="workplace_code" size=15 maxlength=15 value='<%= workplace_code %>' readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>			
			<tr>
				<td align="right" class="label" width="40%"><fmt:message key="eRS.WorkplaceDescription.label" bundle="${rs_labels}"/> &nbsp</td>
				<td align="left" class="label" width="60%">
				<input type=text name="workplace_desc" id="workplace_desc" size=30 maxlength=30 value='<%= workplace_desc %>' <%=readOnly%>>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>
			<tr>
				<td class='label' align='center'><b><fmt:message key="eRS.OperatingHours.label" bundle="${rs_labels}"/></b></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td class="label"><fmt:message key="eRS.From(hh:mi).label" bundle="${rs_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.To(hh:mi).label" bundle="${rs_labels}"/>&nbsp;</img>
				</td>			
			</tr>
			<tr>
				<td align="right" class="label" width="40%">
				<fmt:message key="eRS.WorkingDays.label" bundle="${rs_labels}"/> &nbsp;</td>
				<td align="left" class="label" width="60%">
					<input type=text size=2 maxlength=2 name='wday_from_hh' id='wday_from_hh' value='<%= working_day_start_hh%>' <%=readOnly%> onKeyPress='return  allowValidNumber(this,event,2,0);'> : 
					<input type=text size=2 maxlength=2 name='wday_from_mm' id='wday_from_mm' value='<%= working_day_start_mm%>' <%=readOnly%> onKeyPress='return  allowValidNumber(this,event,2,0);'>
					&nbsp;&nbsp;
					<input type=text size=2 maxlength=2 name='wday_to_hh' id='wday_to_hh' value='<%= working_day_end_hh%>' <%=readOnly%> onKeyPress='return  allowValidNumber(this,event,2,0);'> : 
					<input type=text size=2 maxlength=2 name='wday_to_mm' id='wday_to_mm' value='<%= working_day_end_mm%>' <%=readOnly%> onKeyPress='return  allowValidNumber(this,event,2,0);'>
				</td>
			</tr>
			<tr>
				<td align="right" class="label" width="40%">
				<fmt:message key="eRS.Non-WorkingDays.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td align="left" class="label" width="60%">
					<input type=text size=2 maxlength=2 name='nwday_from_hh' id='nwday_from_hh' value='<%= nonworking_day_start_hh%>' <%=readOnly%> onKeyPress='return  allowValidNumber(this,event,2,0);'> : 
					<input type=text size=2 maxlength=2 name='nwday_from_mm' id='nwday_from_mm' value='<%= nonworking_day_start_mm%>' <%=readOnly%> onKeyPress='return  allowValidNumber(this,event,2,0);'>
					&nbsp;&nbsp;
					<input type=text size=2 maxlength=2 name='nwday_to_hh' id='nwday_to_hh' value='<%= nonworking_day_end_hh%>' <%=readOnly%> onKeyPress='return  allowValidNumber(this,event,2,0);'> : 
					<input type=text size=2 maxlength=2 name='nwday_to_mm' id='nwday_to_mm' value='<%= nonworking_day_end_mm%>' <%=readOnly%> onKeyPress='return  allowValidNumber(this,event,2,0);'>
				</td>
			</tr>
			<tr>
				<td align="right" class="label" width="40%">
				<fmt:message key="eRS.Holidays.label" bundle="${rs_labels}"/> &nbsp;</td>
				<td align="left" class="label" width="60%">
					<input type=text size=2 maxlength=2 name='hday_from_hh' id='hday_from_hh' value='<%= holiday_start_hh%>' <%=readOnly%> onKeyPress='return  allowValidNumber(this,event,2,0);'> : 
					<input type=text size=2 maxlength=2 name='hday_from_mm' id='hday_from_mm' value='<%= holiday_start_mm%>' <%=readOnly%> onKeyPress='return  allowValidNumber(this,event,2,0);'>
					&nbsp;&nbsp;
					<input type=text size=2 maxlength=2 name='hday_to_hh' id='hday_to_hh' value='<%= holiday_end_hh%>' <%=readOnly%> onKeyPress='return  allowValidNumber(this,event,2,0);'> : 
					<input type=text size=2 maxlength=2 name='hday_to_mm' id='hday_to_mm' value='<%= holiday_end_mm%>' <%=readOnly%> onKeyPress='return  allowValidNumber(this,event,2,0);'>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">&nbsp</td>
			</tr>
			<tr>
				<td class='label' align='right'><fmt:message key="eRS.StaffUtilizationReviewOption.label" bundle="${rs_labels}"/> &nbsp; </td>
				<td class='label' align='left'>
				<select name='hstaff_util' id='hstaff_util' onchange='' <%=disable%>>
					<option value='' > &nbsp; --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- &nbsp;</option>
<% selected=staff_util.equals("SB")?"selected":""; %>
					<option value='SB' <%=selected%>><fmt:message key="eRS.StafftoBedRatio.label" bundle="${rs_labels}"/></option>
<% selected=staff_util.equals("SP")?"selected":""; %>
					<option value='SP' <%=selected%>><fmt:message key="eRS.StafftoPatientRatio.label" bundle="${rs_labels}"/></option>
<% selected=staff_util.equals("FT")?"selected":""; %>
					<option value='FT' <%=selected%>><fmt:message key="eRS.FTE.label" bundle="${rs_labels}"/></option>
<% selected=staff_util.equals("FD")?"selected":""; %>
					<option value='FD'<%=selected%>><fmt:message key="eRS.DependencyBasedFTE.label" bundle="${rs_labels}"/></option>
				</select>
				</td>
			</tr>
	<input type='hidden' name='staff_util' id='staff_util' value=<%=staff_util%>>
			<tr>
				<td class='label' align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;</td>
				<%
				if(eff_status.equals("E")){
				%>
				<td align='left'><input type=checkbox name='eff_status' id='eff_status' checked>
				<% }
				else {
				%>
				<td align='left'><input type=checkbox name='eff_status' id='eff_status'>
				<%
				}
				%>
				</td>
			</tr>
		</table>		
	<%
	 }
		catch(Exception exp)
		{
			out.println(exp.toString());
		}
		finally
		{
          if(rset!=null) rset.close();
		  if(pstmt1!=null) pstmt1.close();
		}
	}
%>
<%
	String facility_id = (String)session.getAttribute("facility_id");
	int num = 0;
	char ch;
	int week_count = 0;
	String week_basis = "";
	String week_day = "0W";
	String query_week_days="";
	try{
		query_week_days = "select initcap ( substr ( day_of_week , 1 , 3 ) ) day_of_week from sm_day_of_week order by day_no";
		stmt = conn.prepareStatement(query_week_days);
		rs = stmt.executeQuery();
		while(rs.next()){
			week_vector.add(rs.getString("day_of_week"));
		}
	}
	catch(Exception exp){
		out.println(exp.toString());
	}
	finally{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
%>
	<table border='0' cellpadding='0' cellspacing='0' align='center' width="90%">
			<tr>
				<td colspan="2">&nbsp</td>
			</tr>
<%
try
{
	String queryWork = "select work_cycle_basis from rs_parameter where facility_id in (select facility_id from  rs_parameter where facility_id = ?  union select facility_id from rs_parameter   where facility_id = '*A' and not exists (select facility_id from rs_parameter where facility_id = ?))";

	String cntQuery = "select count(*) from rs_parameter  where facility_id in (select facility_id from  rs_parameter where facility_id = ?  union select facility_id from rs_parameter   where facility_id = '*A' and not exists (select facility_id from rs_parameter where facility_id = ?))";

	int count=0;

	try{
		stmt = conn.prepareStatement(cntQuery);
		stmt.setString(1,facility_id);
		stmt.setString(2,facility_id);
		
		rs = stmt.executeQuery();
		while(rs.next()){
			count = rs.getInt(1);
		}
	}
	catch(Exception exp)
	{
		out.println(exp.toString());
	}
	finally
	{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	if(count > 0)	{
		try{
			stmt = conn.prepareStatement(queryWork);
			stmt.setString(1,facility_id);
			stmt.setString(2,facility_id);
			rs = stmt.executeQuery();
			while(rs.next()){
				week_day = rs.getString("work_cycle_basis");
			}
		}
		catch(Exception exp){
				out.println(exp.toString());
		}
		finally{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
		}
	}	
	num = Integer.parseInt(week_day.substring(0,1));
	ch = week_day.charAt(1);

	if(ch == 'M'){
		week_count = 5;
		week_basis = "Monthly";
	}
	else{
		week_count = num;
		week_basis = String.valueOf(num) + " Weekly";
	}
%>
	<tr>
		<th width="60%"> &nbsp;<fmt:message key="eRS.OperatingDaysApplicabilityfortheWorkCycle.label" bundle="${rs_labels}"/></th>
		<th width="40%" align='left' >  <%= week_basis %> </th>
	</tr>
	</table>
	<table border='0' cellpadding='0' cellspacing='0' align='center' width="90%">
	<tr>
		<td colspan="8">&nbsp</td>
	</tr>
	<tr>
		<td width="30%"></td>
		<%
			for(int i=0;i<week_vector.size();i++){
				out.print("<td class='label' width='10%'><b>"+(String)week_vector.get(i)+"</b></td>"); 
			}
		%>	
	</tr>	
	<tr>
		<td class='label' width="30%" align='center'><b> <fmt:message key="Common.Default.label" bundle="${common_labels}"/></b></td>
		<td width="10%">
			<select name='def_mon' id='def_mon' onchange='makeDef(this)' <%=disable%>>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
		<td width="10%">
			<select name='def_tue' id='def_tue' onchange='makeDef(this)' <%=disable%>>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
		<td width="10%"> 
			<select name='def_wed' id='def_wed' onchange='makeDef(this)' <%=disable%>>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
		<td width="10%">
			<select name='def_thu' id='def_thu' onchange='makeDef(this)' <%=disable%>>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
		<td width="10%">
			<select name='def_fri' id='def_fri' onchange='makeDef(this)' <%=disable%>>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
		<td width="10%">
			<select name='def_sat' id='def_sat' onchange='makeDef(this)' <%=disable%>>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
		<td width="10%">
			<select name='def_sun' id='def_sun' onchange='makeDef(this)' <%=disable%>>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
	</tr>

<%
	
	if(mode.equals("2"))	{
			for(int j=1;j<=week_count;j++){
			%>
			<tr>		
				<td class='label' width="30%" align='center'><b><fmt:message key= "Common.Week.label" bundle="${common_labels}"/> <%= j %> </b></td>
			<%
				for(int k=1;k<=7;k++){
					week_day_str = week_day_tokenizer.nextToken();
					%>
					<td>
						<select name="week_<%=j%>_day_<%=k%>" id="week_<%=j%>_day_<%=k%>" <%=disable%> onchange='changeopdays(this, mweek_<%=j%>_day_<%=k%>)'>
<% selected=week_day_str.equals("W")?"selected":""; %>
							<option value='W' <%=selected%>><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
<% selected=week_day_str.equals("N")?"selected":""; %>
							<option value='N' <%=selected%>><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
<% selected=week_day_str.equals("H")?"selected":""; %>
							<option value='H' <%=selected%>><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
						</select>
					</td>
					<input type='hidden' name="mweek_<%=j%>_day_<%=k%>" id="mweek_<%=j%>_day_<%=k%>" value='<%=week_day_str%>'>
					<%
				}
			}
		}
		else	{
			for(int j=1;j<=week_count;j++){
			%>
		<tr>		
			<td class='label' width="30%" align='center'><b> <fmt:message key="Common.Week.label" bundle="${common_labels}"/><%= j %> </b></td>
		<%
			for(int k=1;k<=7;k++)
			{
		%>
			<td>
				<select name="week_<%=j%>_day_<%=k%>" id="week_<%=j%>_day_<%=k%>" <%=disable%>>
					<option value='W' ><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
					<option value='N' ><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
					<option value='H' ><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
				</select>
			</td>
		<%
			}
		  }
		}	
		%>
		</tr>

			<tr>
				<td colspan="8">&nbsp</td>
			</tr>
		<%
	
}catch(Exception e){
	out.println(e);
	out.println(e.getMessage());
	e.printStackTrace();
}
finally {
	  try
	  {
	  if (stmt != null) stmt.close();
	  if (rs != null)   rs.close();

	  if(rset!=null) rset.close();
	  if(pstmt1!=null) pstmt1.close();
	  ConnectionManager.returnConnection(conn,request);
	  }
	  catch(Exception exp)
	  {
		  out.println(exp.toString());
	  }
	}
%>
<input type='hidden' name='mode' id='mode' value='<%= mode %>'>
<input type='hidden' name='noOfWeeks' id='noOfWeeks' value='<%= num %>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%= facility_id %>'>
<input type='hidden' name='work_cycle_basis' id='work_cycle_basis' value='<%= week_day %>'>
</form>
</body>
</html>

