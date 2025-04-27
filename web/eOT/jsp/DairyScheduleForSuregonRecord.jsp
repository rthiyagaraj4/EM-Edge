<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eOT/js/DairyScheduleForSuregon.js'></script>
<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="spltyEnaDis();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="DiaryScheduleForSurgeonForm" id="DiaryScheduleForSurgeonForm"  >
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>'>
<%
String restrict_by_splty_yn=request.getParameter("restrict_by_splty_yn");
String locale = (String)session.getAttribute("LOCALE"); 
request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String oper_room = checkForNull(request.getParameter("oper_room_code"));
String oper_room_cde[]=oper_room.split("@@");
String oper_room_code=oper_room_cde[0];
String facility_id=(String) session.getAttribute("facility_id");
String all_days_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllDays.label","common_labels");
String all_days="";
String code1="";
String status1="";
String val="";
String day_code="";
//String speciality_desc=""; 
//String speciality_code="";
//String day_code="";
//String day_desc="";
//String start_time="";
//String end_time="";
String sql="";
String unit_ot_time="";
String sqlForUnitTime="SELECT TO_CHAR(unit_ot_time, 'hh24:mi') FROM   ot_param_for_facility  WHERE  operating_facility_id = ?"; 

//Modified against 046233
//sql="SELECT A.RESOURCE_ID RESOURCE_ID, A.SPECIALITY_CODE,B.SHORT_DESC,A.DAY_CODE,DECODE(A.DAY_CODE,0,'"+all_days_title+"', (SELECT DAY_OF_WEEK FROM  OT_DAY_OF_WEEK  X WHERE  NVL(DAY_STATUS, '$') <> 'S' AND X.DAY_CODE = A.DAY_CODE)) DAY_OF_WEEK, TO_CHAR(A.FROM_TIME,'HH24:MI'), TO_CHAR(A.TO_TIME,'HH24:MI'),NVL(A.FIRST_WEEK_YN,'N'),NVL(A.SECOND_WEEK_YN,'N'), NVL(A.THIRD_WEEK_YN,'N'), NVL(A.FOURTH_WEEK_YN,'N'), NVL(A.FIFTH_WEEK_YN,'N'),A.SCHEDULE_TYPE, D.SHORT_NAME, DECODE(A.DAY_CODE,0,'W',(SELECT DAY_STATUS FROM  OT_DAY_OF_WEEK  X WHERE  NVL(DAY_STATUS, '$') <> 'S' AND X.DAY_CODE = A.DAY_CODE)) DAY_STATUS,  NVL(AVAILABLE_SLOTS,0) AVAILABLE_SLOTS, PERMISSIBLE_SLOTS FROM OT_DIARY_TIMETABLE A, (SELECT LANGUAGE_ID, SPECIALITY_CODE, SHORT_DESC FROM AM_SPECIALITY_LANG_VW UNION SELECT LANGUAGE_ID, '*ALL', NVL(short_desc, 'All Specialities') FROM am_speciality_lang_vw Where language_id='"+locale+"' and speciality_code = '*ALL') B, (SELECT PRACTITIONER_ID, SHORT_NAME FROM AM_PRACTITIONER UNION SELECT '*ALL' PRACTITIONER_ID, '*All Surgeons' SHORT_NAME FROM DUAL)D WHERE B.LANGUAGE_ID='"+locale+"' AND A.SPECIALITY_CODE= B.SPECIALITY_CODE AND A.OPERATING_FACILITY_ID=? AND A.OPER_ROOM_CODE =? AND A.RESOURCE_ID = D.PRACTITIONER_ID ORDER BY 2";

//Modified against IN048952
sql="SELECT A.RESOURCE_ID RESOURCE_ID, A.SPECIALITY_CODE,B.SHORT_DESC,A.DAY_CODE,DECODE(A.DAY_CODE,0,?, (SELECT DAY_OF_WEEK FROM  OT_DAY_OF_WEEK  X WHERE  NVL(DAY_STATUS, '$') <> 'S' AND X.DAY_CODE = A.DAY_CODE)) DAY_OF_WEEK, TO_CHAR(A.FROM_TIME,'HH24:MI'), TO_CHAR(A.TO_TIME,'HH24:MI'),NVL(A.FIRST_WEEK_YN,'N'),NVL(A.SECOND_WEEK_YN,'N'), NVL(A.THIRD_WEEK_YN,'N'), NVL(A.FOURTH_WEEK_YN,'N'), NVL(A.FIFTH_WEEK_YN,'N'),A.SCHEDULE_TYPE, D.SHORT_NAME, DECODE(A.DAY_CODE,0,'W',(SELECT DAY_STATUS FROM  OT_DAY_OF_WEEK  X WHERE  NVL(DAY_STATUS, '$') <> 'S' AND X.DAY_CODE = A.DAY_CODE)) DAY_STATUS,  NVL(AVAILABLE_SLOTS,0) AVAILABLE_SLOTS, PERMISSIBLE_SLOTS FROM OT_DIARY_TIMETABLE A, (SELECT LANGUAGE_ID, SPECIALITY_CODE, SHORT_DESC FROM AM_SPECIALITY_LANG_VW UNION SELECT LANGUAGE_ID, '*ALL', 'All Specialities' FROM sm_language Where language_id=?) B, (SELECT PRACTITIONER_ID, SHORT_NAME FROM AM_PRACTITIONER UNION SELECT '*ALL' PRACTITIONER_ID, '*All Surgeons' SHORT_NAME FROM DUAL)D WHERE B.LANGUAGE_ID=? AND A.SPECIALITY_CODE= B.SPECIALITY_CODE AND upper(b.short_desc) != '*ALL' AND A.OPERATING_FACILITY_ID=? AND A.OPER_ROOM_CODE =? AND A.RESOURCE_ID = D.PRACTITIONER_ID ORDER BY 2";
String otParam = "";
//CRF-004 Authorize Slots for Booking - Rajesh V
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
PreparedStatement stmt1=null;
ResultSet rs1=null;
String wd_start_time = "";
String wd_end_time = "";
String hd_start_time = "";
String hd_end_time = "";
String args = "";
String menu_change_flag="";
try{
	String sql_1 = "SELECT TO_CHAR(WD_START_TIME, 'HH24:MI') WD_START_TIME, TO_CHAR(WD_END_TIME, 'HH24:MI') WD_END_TIME, TO_CHAR(HD_START_TIME, 'HH24:MI') HD_START_TIME, TO_CHAR(HD_END_TIME, 'HH24:MI') HD_END_TIME FROM OT_OPER_ROOM WHERE  OPERATING_FACILITY_ID = ? AND OPER_ROOM_CODE = ?";
	con=ConnectionManager.getConnection(request);
	stmt=con.prepareStatement(sql_1);
    stmt.setString(1,facility_id);
	stmt.setString(2,oper_room_code);
	rs=stmt.executeQuery();
	while(rs.next()){		
		wd_start_time = rs.getString("WD_START_TIME");
		wd_end_time = rs.getString("WD_END_TIME");
		hd_start_time = rs.getString("HD_START_TIME");
		hd_end_time = rs.getString("HD_END_TIME");
	}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	
	//CRF-004 Authorize Slots for Booking - Rajesh V
	String sqlFacilityChk = "select NVL(SCHEDULE_RESTRICT_YN,'N') facility from OT_PARAM where rownum = 1";
	stmt=con.prepareStatement(sqlFacilityChk);
	rs=stmt.executeQuery();
	if(rs !=null && rs.next())
	{
		otParam=checkForNull(rs.getString("facility"));		
	}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	//CRF-004 Authorize Slots for Booking - Rajesh V
	//Newly Added By rajesh on 22/10 for defaulting all surgeons....,

	String sql_surgeon_yn="select DIARY_SCHED_FOR_SURG_REQD_YN from ot_param_for_facility where OPERATING_FACILITY_ID=?";
	stmt=con.prepareStatement(sql_surgeon_yn);
	stmt.setString(1,facility_id);
	rs=stmt.executeQuery();
	while (rs.next()){
		menu_change_flag=rs.getString(1);	
	}

	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();

	stmt1=con.prepareStatement(sqlForUnitTime);
	stmt1.setString(1,facility_id);
	rs1=stmt1.executeQuery();
	if(rs1.next()){
        unit_ot_time=rs1.getString(1);
	}
	if(stmt1!=null)stmt.close();
	if(rs1!=null)rs1.close();
	stmt=con.prepareStatement(sql);
	stmt.setString(1,all_days_title);
	stmt.setString(2,locale);
	stmt.setString(3,locale);
	stmt.setString(4,facility_id);
	stmt.setString(5,oper_room_code);
	rs=stmt.executeQuery();
	int index=0;
	while(rs.next()){
		index++;
		//CRF-004 Authorize Slots for Booking - Rajesh V
		if("Y".equalsIgnoreCase(otParam)){
		args = rs.getString(1)+"##"+rs.getString(2)+"##"+rs.getString(3)+"##"+rs.getString(4)+"@@"+rs.getString(15)+"##"+rs.getString(5)+"##"+rs.getString(6)+"##"+rs.getString(7)+"##"+rs.getString(8)+rs.getString(9)+rs.getString(10)+rs.getString(11)+rs.getString(12)+"##"+rs.getString(13)+"##"+rs.getString(14)+"##L"+"##"+rs.getString(16)+"##"+rs.getString(17);
		System.err.println("IF args.... ===> "+args);
		}
		else{
		args = rs.getString(1)+"##"+rs.getString(2)+"##"+rs.getString(3)+"##"+rs.getString(4)+"@@"+rs.getString(15)+"##"+rs.getString(5)+"##"+rs.getString(6)+"##"+rs.getString(7)+"##"+rs.getString(8)+rs.getString(9)+rs.getString(10)+rs.getString(11)+rs.getString(12)+"##"+rs.getString(13)+"##"+rs.getString(14)+"##L";
		System.err.println("ELSE args.... ===> "+args);
		}
		//CRF-004 Authorize Slots for Booking - Rajesh V
		out.println("<script>loadDBRows('"+args+"')</script>");
	}
	out.println("<script>refresh()</script>");

	
}catch(Exception e){
	e.printStackTrace();
	//System.err.println("Error in DairyScheduleForSuregonRecord.jsp"+e.getMessage());
}finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		
		if(con!=null) 
		ConnectionManager.returnConnection(con,request);
	}catch(Exception e){e.printStackTrace();}
}
%>
<table border='0' cellspacing='0' cellpadding='3' width='100%'  >

<tr>
<%
if(menu_change_flag.equals("N")){
%>
<td class="label">
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="hidden" name="surgeon_code" id="surgeon_code" value="*ALL" >
	<input type="text" name="surgeon_desc" id="surgeon_desc" size=10  value="*All Surgeons" disabled>
	<input type="button" class="button" name="generic_search_for_day" id="generic_search_for_day" value="?" disabled>
	</td>

<%}else{%>
	<td class="label">
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="hidden" name="surgeon_code" id="surgeon_code" value="" >
	<input type="text" name="surgeon_desc" id="surgeon_desc" value="" size=10 onblur="if(this.value!='')callSurgeoncode(surgeon_desc); else surgeon_code.value='' ">
	<input type="button" class="button" name="generic_search_for_day" id="generic_search_for_day" value="?" onclick='callSurgeoncode(surgeon_desc)' >
	<img src='../../eCommon/images/mandatory.gif'>
	</td>
<%}%>

	<td class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td align="left">
	<input type="hidden" name="speciality_code" id="speciality_code" value="">
	<input type="text" name="speciality_desc" id="speciality_desc" value="" size='8' 
	onBlur="if(this.value!='')callSpecialitycode(speciality_code,speciality_desc); else speciality_code.value='' ">
	<input type="button" class="button" name="generic_search_for_speciality" id="generic_search_for_speciality" value="?"  onclick='callSpecialitycode(speciality_code,speciality_desc);' ><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class="label">
	<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
	<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->
	<%if("Y".equalsIgnoreCase(otParam)){%>
	<input type="text" name="start_time" id="start_time" value=""  size='5' maxlength='5' onblur='isValidTime(this);chkTimeRange();checkUnitTime();calcSlots();' >
	<%}
	else{%>
	<input type="text" name="start_time" id="start_time" value=""  size='5' maxlength='5' onblur='isValidTime(this);' >
	<%}%>
	<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->
	<img src='../../eCommon/images/mandatory.gif'> (hh24:mi)
	</td>

	<td class="label">
	<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
	<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->
	<%if("Y".equalsIgnoreCase(otParam)){%>
	<input type="text" name="end_time" id="end_time" value=""  size='5' maxlength='5' onblur=' isValidTime(this);chkTimeRange();checkUnitTime();calcSlots();'><img src='../../eCommon/images/mandatory.gif'>(hh24:mi)
	<%}
	else{%>
	<input type="text" name="end_time" id="end_time" value=""  size='5' maxlength='5' onblur=' isValidTime(this);'><img src='../../eCommon/images/mandatory.gif'>(hh24:mi)
	<%}%>
	<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->
	</td>
</tr>
<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->
<%if("Y".equalsIgnoreCase(otParam)){%>
<tr>
	<td class="label">
	<fmt:message key="eOT.TotalSlots.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
	<input type="text" name="total_Slots" id="total_Slots" value=""  size='4' disabled >
	</td>

	<td class="label">
	<fmt:message key="eOT.PermissibleSlots.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
	<input type="text" name="restricted_Slots" id="restricted_Slots" value=""  size='4' maxlength='4' onblur='checkResSlotsNumber("restricted_Slots");'><img src='../../eCommon/images/mandatory.gif'>&nbsp;&nbsp;Slots	
	</td>
</tr>
<%}%>
<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->
<tr>
	<td class="label">
	<fmt:message key="eOT.ScheduleType.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<select name="schedule_type" id="schedule_type" onchange='chkBoxEnableDisable(this);' >
		<option value='A'><fmt:message key="Common.AllWeeks.label" bundle="${common_labels}"/></option>
		<option value='S' selected><fmt:message key="eOT.SpecificWeeks.Label" bundle="${ot_labels}"/></option>
		</select>
	</td>

	<td class="label">
	<fmt:message key="Common.day.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
	<input type="hidden" name="day_code" id="day_code" value="">
	<input type="hidden" name="day_status" id="day_status" value="">
	<select name="days" id="days" onchange="assignDayStatus(this);">

<%
	try{
        con=ConnectionManager.getConnection(request);
		sql="SELECT 'ALL DAYS' DESCRIPTION1,'0' CODE1,'W' STATUS1 FROM   DUAL  UNION  SELECT INITCAP(DAY_OF_WEEK) DESCRIPTION2,DAY_CODE CODE2,DAY_STATUS STATUS2 FROM  OT_DAY_OF_WEEK  WHERE  NVL(DAY_STATUS, '$') <> 'S' ORDER BY 2";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()){
			 all_days=rs.getString(1);
			 day_code=rs.getString(2);
			 code1=rs.getString(2)+"@@"+rs.getString(3);
			 status1=rs.getString(3);
			 val=rs.getString(1)+"---("+rs.getString(3)+")";
 %>	
             <option value="<%=code1%>" ><%=val%></option>
 <%  }
	}catch(Exception e){e.printStackTrace();}
	finally{
		try{
		 if(rs!=null) rs.close();
		 if(stmt!=null) stmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){e.printStackTrace();}
     }
 %>
	<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class='LABELLEFT' nowrap>
			<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
	</td>
	<td class='LABELLEFT' nowrap>
				1W<input type="checkbox" name="week1" id="week1" value="N"  onClick="setCheckValue(this)">&nbsp;&nbsp;
				2W<input type="checkbox" name="week2" id="week2" value="N"  onClick="setCheckValue(this)">&nbsp;&nbsp;
				3W<input type="checkbox" name="week3" id="week3" value="N"  onClick="setCheckValue(this)">&nbsp;&nbsp;
				4W<input type="checkbox" name="week4" id="week4" value="N"  onClick="setCheckValue(this)">&nbsp;&nbsp;
				5W<input type="checkbox" name="week5" id="week5" value="N"  onClick="setCheckValue(this)">
	</td>

    <td class='button' colspan="2" nowrap width='20%'>		
		<input type='button' name='select' id='select' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();spltyEnaDis()'   >
		<input type='button' name='cancel' id='cancel' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();spltyEnaDis()'  >
	</td>

		
</tr>
</table>
	<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>

<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='selected_weeks' id='selected_weeks' value="">
<input type='hidden' name='oper_room_code1' id='oper_room_code1' value="<%=oper_room_code%>">
<input type='hidden' name='theatre_code' id='theatre_code' value="<%=oper_room_code%>">
<input type='hidden' name='unit_ot_time_DB' id='unit_ot_time_DB' value="<%=unit_ot_time%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='wd_start_time' id='wd_start_time' value="<%=wd_start_time%>">
<input type='hidden' name='wd_end_time' id='wd_end_time' value="<%=wd_end_time%>">
<input type='hidden' name='hd_start_time' id='hd_start_time' value="<%=hd_start_time%>">
<input type='hidden' name='hd_end_time' id='hd_end_time' value="<%=hd_end_time%>">
<input type='hidden' name='menu_change_flag' id='menu_change_flag' value="<%=menu_change_flag%>">
<input type='hidden' name='restrict_by_splty_yn' id='restrict_by_splty_yn' value="<%=restrict_by_splty_yn%>">
<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->
<input type='hidden' name='ot_Param' id='ot_Param' value='<%=otParam%>'>
<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->
</form>
</body>
</html>


