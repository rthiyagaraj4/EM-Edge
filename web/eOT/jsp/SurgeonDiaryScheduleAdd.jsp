<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String locale = (String)session.getAttribute("LOCALE");
String facility_id=(String) session.getAttribute("facility_id");

%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/SurgeonDiarySchedule.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>


<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>


<SCRIPT LANGUAGE="JavaScript">
function validate_time_table(){
var frmObj=document.forms[0];
var timetablesql = "SELECT DECODE(A.day_code, 0, B.day_no, A.day_code) day_code,     B.day_of_week FROM ot_diary_timetable A, sm_day_of_week B WHERE A.operating_facility_id = '"+frmObj.facilityid.value+"'    AND A.resource_id = '"+frmObj.surgeon_code.value+"' AND A.oper_room_code ='"+frmObj.theatre_code.value +"' AND A.day_code = DECODE(A.day_code, '0', A.day_code, B.day_no)";      

var dtuptosql = "select to_char(max(booking_date), 'dd/mm/yyyy') from OT_DIARY_SCHEDULE WHERE OPERATING_FACILITY_ID = '"+frmObj.facilityid.value+"' AND team_doctor_code = '"+frmObj.surgeon_code.value+"' and oper_room_code = '"+frmObj.theatre_code.value+"' ";
}
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

</head>

<body  class='CONTENT' onKeyDown="lockKey()">
<form name="SurgeonDiaryScheduleForm" id="SurgeonDiaryScheduleForm"  onload='FocusFirstElement()'  action="../../servlet/eOT.SurgeonDiaryScheduleServlet" method="post" target="messageFrame"> 
<%

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
  String mode=request.getParameter("mode");
 
//String disable_flag="";
//String sun_yn="";
String mon_yn="";
String tue_yn="";
String wed_yn="";
String thu_yn="";
String fri_yn="";
String sat_yn="";
String diary_gen_upto="";
String from_date="";
String sql="";
String diary_sched_for_surg_reqd_yn="";
int total_records=0;

	try{
		con=ConnectionManager.getConnection(request);
		sql="Select count(*) as total_records_existing from AT_PARAM";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
	    rs.next();		
		total_records=rs.getInt(1);
		
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		stmt=con.prepareStatement("SELECT NVL(DIARY_SCHED_FOR_SURG_REQD_YN,'N') DIARY_SCHED_FOR_SURG_REQD_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ?");
		stmt.setString(1,facility_id);
		rs=stmt.executeQuery();
	    while(rs.next()){		
			diary_sched_for_surg_reqd_yn=rs.getString("DIARY_SCHED_FOR_SURG_REQD_YN");
		}
	}catch(Exception e){
		e.printStackTrace();
		//out.println(sql);
		//out.println("65:Exception is "+e);
	}finally{
		try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
			//out.println(sql);
			//out.println("74:Exception is "+e);
		}		
	}

%>
<br><br>
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
 
	<%
		if(diary_sched_for_surg_reqd_yn.equals("Y")){
	%>
			<tr>
				<td class='label' nowrap>
				<fmt:message key="eOT.GenerateBy.Label" bundle="${ot_labels}"/>
				</td>
				<td>
					<select name="generate_by" id="generate_by" onchange="enaDisTxtBox();">
						<option value="BT"><fmt:message key="eOT.TheatreAndSurgeon.Label" bundle="${ot_labels}"/></option>
						<option value="TH"><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></option>
						<option value="SG"><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></option>
					</select>&nbsp;&nbsp;
				</td>
			</tr>
	<%}else{%>
			<!-- commented by bala on 22/10/2007 for diary schedule change -->
			<!--<input type='hidden' name="generate_by" id="generate_by"  value="OT"> -->
			<input type='hidden' name="generate_by" id="generate_by"  value="BT"> 
	<%
		}
	%>
   
 <tr> 
	<td class='label' nowrap>
	<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' nowrap>
	<input type='text' name='theatre_desc' id='theatre_desc' size='30' value="" onBlur="if(this.value!='')searchLkp('T', theatre_code , theatre_desc);"> 
		<input type='hidden' name="theatre_code" id="theatre_code"  value=""> 
		<input type='button' class='button' value='?' name='thtrlkp' id='thtrlkp' onClick="searchLkp('T', theatre_code , theatre_desc);">
	</td>	
</tr> 

	<%
		if(diary_sched_for_surg_reqd_yn.equals("Y")){
	%>
		<tr> 
			<td class='label' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td>
			<td lass='fields' nowrap><input type='text' name='surgeon_desc' id='surgeon_desc' size='30' value="" onBlur="if(this.value!='')searchLkp('D', surgeon_code,surgeon_desc);"> 
			<input type='hidden' name='surgeon_code' id='surgeon_code'  value="" > 
			<input type='button' class='button' value='?' name='notetypelkp' id='notetypelkp' onClick="searchLkp('D', surgeon_code,surgeon_desc);" >
			</td>
		</tr>  
	<%
		}else{
	%>
			<input type='hidden' name='surgeon_code' id='surgeon_code'  value="*ALL" > 
			<input type='hidden' name='surgeon_desc' id='surgeon_desc'  value="" > 
	<%
		}
	%>
<tr>
  <td class="COLUMNHEADERCENTER"><fmt:message key="Common.dayofweek.label" bundle="${common_labels}"/></td>
  <td class="COLUMNHEADERCENTER"></td>

</tr>
 <tr>
 <!-- Changes Done for getting day of week from DB - Rajesh -->
 <%
 	String[] day_week = new String[7];
 	try{
 		con=ConnectionManager.getConnection(request);
		sql="select initcap(substr(day_of_week,1,3)) day_of_week from ot_day_of_week order by day_code";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		int i_day = 0;
		while(rs.next()){
			day_week[i_day] = rs.getString("day_of_week");
			i_day++;
		}
 	}
 	catch(Exception e){
		e.printStackTrace();
		//out.println("Exception is "+e);
	}finally{
		try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
			//out.println("Exception is "+e);
		}		
	}
	
 %>
   	<td class='label' nowrap colspan="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=day_week[6]%> &nbsp;&nbsp; <%=day_week[0]%> &nbsp;&nbsp;  <%=day_week[1]%>&nbsp;&nbsp;   <%=day_week[2]%>  &nbsp;&nbsp; <%=day_week[3]%> &nbsp;&nbsp;  <%=day_week[4]%>&nbsp;&nbsp;   <%=day_week[5]%> </td>	  	 
 <!-- Changes Done for getting day of week from DB - Rajesh -->
</tr>

<tr>
	<td class='fields' nowrap colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type='checkbox' name='sun' id='sun'  value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp; 
	<input type='checkbox' name='mon' id='mon'  value="<%=mon_yn%>" disabled>&nbsp;&nbsp;&nbsp;&nbsp; 
	<input type='checkbox' name='tue' id='tue'  value="<%=tue_yn%>" disabled>&nbsp;&nbsp;&nbsp; 
	<input type='checkbox' name='wed' id='wed'  value="<%=wed_yn%>" disabled>&nbsp;&nbsp;&nbsp; 
	<input type='checkbox' name='thu' id='thu'  value="<%=thu_yn%>" disabled> &nbsp;
	<input type='checkbox' name='fri' id='fri'  value="<%=fri_yn%>" disabled>&nbsp;&nbsp;
	<input type='checkbox' name='sat' id='sat'  value="<%=sat_yn%>" disabled>&nbsp;&nbsp;&nbsp; 
	</td>
</tr> 

	<%
		if(diary_sched_for_surg_reqd_yn.equals("Y")){
	%>
		<tr>
			 <td  class='label' nowrap><fmt:message key="eOT.DiaryGeneratedupto.Label" bundle="${ot_labels}"/> </td>
			 <td align='left' nowrap>
			 &nbsp;<input type='text' name='diary_gen_upto' id='diary_gen_upto' size='12'  value="<%=diary_gen_upto%>" readonly> 
			 </td>
		</tr> 
	<%
		}else{
	%>
		<input type='hidden' name='diary_gen_upto' id='diary_gen_upto'  value="" disabled>&nbsp;&nbsp;&nbsp; 
	<%
		}
	%>

<!--

 <tr>
	 <td  class='label' nowrap><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/> </td>
	 <td lass='fields' nowrap>
	 &nbsp;<input type='text' name='from_date' id='from_date' size='12'  value="<%=from_date%>" >&nbsp; <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('from_date');" > &nbsp;<img src='../../eCommon/images/mandatory.gif'></img> 
	 </td>
</tr>
	-->
<tr>
	 <td  class='label' nowrap><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/> </td>
	 <td lass='fields' nowrap>
	 &nbsp;<input type='text' name='from_date' id='from_date' size='8' maxlength ='10'  value="<%=from_date%>" onBlur="CheckDate(this);" >&nbsp; <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('from_date');" > &nbsp;<img src='../../eCommon/images/mandatory.gif'></img> 
	 </td>
</tr>


<tr>
	 <td  class='label' nowrap><fmt:message key="Common.todate.label" bundle="${common_labels}"/> </td>
	 <td lass='fields' nowrap>
	 &nbsp;<input type='text' name='to_date' id='to_date' size='8' maxlength ='10' value="" onBlur="CheckDate(this);" >&nbsp; <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('to_date');"> &nbsp;<img src='../../eCommon/images/mandatory.gif'></img> 
	 </td>
</tr> 
   
<tr>
  <td> </td> <td > <input type="button" class="button" name="generate" id="generate" value="Generate" onclick="callGenerate()" > </td> 
</tr>

</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name='facilityid' id='facilityid'  value='<%=facility_id%>'>
<input type=hidden name='curr_date' id='curr_date'   value=''> 
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>' >	
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='diary_sched_for_surg_reqd_yn' id='diary_sched_for_surg_reqd_yn' value="<%=diary_sched_for_surg_reqd_yn%>">

</form>
</body>
</html>


