<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%!
	String encode(String data){	  
		String outDat = "";
		byte byteData[] = data.getBytes();
		for (int i=0; i<byteData.length; i++){
			outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
		}
		return(outDat);
   }
  %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String imgUrl="";
if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/BlockSlotsBySpeciality.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eOT/js/Hashtable.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad='getLabels();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="BlockSlotsBySpecialityRecordForm" id="BlockSlotsBySpecialityRecordForm"  onload='FocusFirstElement()'>
<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>">
<%
String mode=request.getParameter("update_mode_yn");
String disable_flag="";
if (mode.equals("modify"))
{
mode="U";
disable_flag="disabled";
}
else 
{
mode="I";
disable_flag="";
}

//String speciality_desc=""; 
String oper_room_code = request.getParameter("oper_room_code")==null?"":request.getParameter("oper_room_code");
String wd_start_time=request.getParameter("wd_start_time")==null?"":request.getParameter("wd_start_time");
String wd_end_time=request.getParameter("wd_end_time")==null?"":request.getParameter("wd_end_time");
String hd_start_time=request.getParameter("hd_start_time")==null?"":request.getParameter("hd_start_time");
String hd_end_time=request.getParameter("hd_end_time")==null?"":request.getParameter("hd_end_time");
String facility_id=(String) session.getAttribute("facility_id");
//String speciality_code="";
//String day_code="";
//String day_desc="";
//String start_time="";
//String end_time="";
String sql="";
//StringBuffer splty_code=new StringBuffer();
//StringBuffer dy_code=new StringBuffer();
//StringBuffer st_time=new StringBuffer();
//StringBuffer en_time=new StringBuffer();
String unit_ot_time="";
String sqlForUnitTime="SELECT TO_CHAR(unit_ot_time, 'hh24:mi') FROM   ot_param_for_facility  WHERE  operating_facility_id = ?"; 
sql="SELECT A.SPECIALITY_CODE,B.SHORT_DESC,A.DAY_CODE,INITCAP(C.DAY_OF_WEEK),TO_CHAR(A.START_TIME_DATE,'HH24:MI'), TO_CHAR(A.END_TIME_DATE,'HH24:MI'),  NVL(A.FIRST_WEEK_YN,'N'), NVL(A.SECOND_WEEK_YN,'N'), NVL(A.THIRD_WEEK_YN,'N'), NVL(A.FOURTH_WEEK_YN,'N'), NVL(A.FIFTH_WEEK_YN,'N'),A.SCHEDULE_TYPE FROM OT_SPECIALITY_TIME_TABLE A, AM_SPECIALITY_LANG_VW B, (SELECT DAY_CODE, DAY_OF_WEEK FROM SY_DAY_OF_WEEK UNION SELECT '0', 'All Days' FROM DUAL) C WHERE B.LANGUAGE_ID= ? AND A.SPECIALITY_CODE= B.SPECIALITY_CODE AND A.DAY_CODE=C.DAY_CODE AND A.OPERATING_FACILITY_ID=? AND A.OPER_ROOM_CODE =? ORDER BY 2";

String sql2="select day_status from  SY_DAY_OF_WEEK where day_code =?  ";
String day_status="W";
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
PreparedStatement stmt1=null;
ResultSet rs1=null;
PreparedStatement stmt2=null;
ResultSet rs2=null;
try
{
	con=ConnectionManager.getConnection(request);
	stmt=con.prepareStatement(sql);
    stmt.setString(1,locale);
    stmt.setString(2,facility_id);
	stmt.setString(3,oper_room_code);
	rs=stmt.executeQuery();
	int index=0;
	while(rs.next())
	{
		index++;
		if(!"0".equals(rs.getString(3))){
        stmt2=con.prepareStatement(sql2);
		stmt2.setString(1,rs.getString(3));
		rs2=stmt2.executeQuery();
		if(rs2.next()){
		day_status=rs2.getString(1);
		}
		}
		out.println("<script>loadDBRows('"+rs.getString(1)+"','"+java.net.URLEncoder.encode(rs.getString(2),"UTF-8")+"','"+rs.getString(3)+"','"+rs.getString(4)+"','"+rs.getString(5)+"','"+rs.getString(6)+"','"+rs.getString(12)+"','"+rs.getString(7)+"','"+rs.getString(8)+"','"+rs.getString(9)+"','"+rs.getString(10)+"','"+rs.getString(11)+"','"+index+"','"+day_status+"','L');</script>");
		out.println("<script>loadWeek('"+rs.getString(1)+rs.getString(3)+"','"+rs.getString(7)+rs.getString(8)+rs.getString(9)+rs.getString(10)+rs.getString(11)+"');</script>");

	}
		out.println("<script>refresh()</script>");
	
	
	stmt1=con.prepareStatement(sqlForUnitTime);
	stmt1.setString(1,facility_id);
	rs1=stmt1.executeQuery();
	if(rs1!=null && rs1.next()){
        unit_ot_time=rs1.getString(1);
		}
%>
<table border=0 cellspacing=0 cellpadding=3 width='100%'  >
<tr>
	<td width='25%' class="label">
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' align="left">
	<input type="text" name="speciality_desc" id="speciality_desc" value="" size=15 maxlength=15 onBlur="if(this.value!='')callSpecialitycode(speciality_code,speciality_desc); else speciality_code.value=''">
	<input type="hidden" name="speciality_code" id="speciality_code" value="">
	<input type="button" class="button" name="generic_search_for_speciality" id="generic_search_for_speciality" value="?"  onclick='callSpecialitycode(speciality_code,speciality_desc);' >
	<img src='../../eCommon/images/mandatory.gif'></td>

	<td width='25%' class="label">
	<fmt:message key="Common.day.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class="fields">
<!-- 	<input type="text" name="day" id="day" value="" size=10 maxlength=10 onBlur="if(this.value!='')callDaycode()">
	<input type="hidden" name="day_code" id="day_code" value="">
	<input type="hidden" name="day_status" id="day_status" value="">
	<input type="hidden" class="button" name="generic_search_for_day" id="generic_search_for_day" value="?" onclick='callDaycode()'> -->
	<input type="hidden" name="day_code" id="day_code" value="">
	<input type="hidden" name="day_status" id="day_status" value="">
	<select name="day" id="day" onchange="assignDayStatus(this);">
		<option value=''>
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		</option>
	<%
		//sql="SELECT 'All Days' description1,'0' code1,'W' status1 FROM   dual  UNION  SELECT day_of_week description2,day_code code2,day_status status2 FROM ot_day_of_week  WHERE  NVL(day_status, '$') <> 'S' ";
		sql="SELECT 'All Days' description1,'0' code1,'W' status1 FROM   dual  UNION  SELECT initcap(day_of_week) description2,day_code code2,day_status status2 FROM ot_day_of_week  WHERE  NVL(day_status, '$') <> 'S' ORDER BY 2";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		String all_days="";
		String code1="";
		String status1="";
		String val="";
		while(rs!=null && rs.next()){
			 all_days=rs.getString(1);
			 code1=rs.getString(2)+"@@"+rs.getString(3);
			 status1=rs.getString(3);
			 val=rs.getString(1)+"---("+rs.getString(3)+")";
    %>	
             <option value="<%=code1%>" ><%=val%></option>
    <%  }
	}catch(Exception e)
{
	e.printStackTrace();
	//System.err.println("Error in Block Slots By Speciality Record.jsp"+e.getMessage());
}finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) 
		ConnectionManager.returnConnection(con,request);
	}catch(Exception e){e.printStackTrace();}
}
%>
    %>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'>	
	</td>
</tr>
<tr>
	<td width='25%' class="label">
	<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class="fields">
	<input type="text" name="start_time" id="start_time" value=""  size='5' maxlength='5' onkeypress="return checkForSpecCharsforID(event);" onBlur="validateDuration(this);" >
	<input type="hidden" name="db_start_time" id="db_start_time" value="">
	<img src='../../eCommon/images/mandatory.gif'> (hh24:mi)
	</td>
	<td width='25%' class="label">
	<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class="fields">
	<input type="text" name="end_time" id="end_time" value=""  size='5' maxlength='5' onkeypress="return checkForSpecCharsforID(event);" onBlur="validateDuration(this);">
	<img src='../../eCommon/images/mandatory.gif'> (hh24:mi)
	</td>
</tr>
<tr>
	<td width='25%' class="label">
	<fmt:message key="eOT.ScheduleType.Label" bundle="${ot_labels}"/>
	</td>
	<td width='25%' class="fields">
		<select name="schedule_type" id="schedule_type" onchange='chkBoxEnableDisable(this);' >
		<option value='A'><fmt:message key="Common.AllWeeks.label" bundle="${common_labels}"/></option>
		<option value='S' selected><fmt:message key="eOT.SpecificWeeks.Label" bundle="${ot_labels}"/></option>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td colspan=2></td>
	</tr>

<tr>
	
	<td width='25%' class='LABELLEFT' nowrap>
			<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
			</td>
			<td width='25%' class='LABELLEFT' nowrap>
				1W<input type="checkbox" name="week1" id="week1" value="N"  onClick="setCheckValue(this)">&nbsp;&nbsp;
				2W<input type="checkbox" name="week2" id="week2" value="N"  onClick="setCheckValue(this)">&nbsp;&nbsp;
				3W<input type="checkbox" name="week3" id="week3" value="N"  onClick="setCheckValue(this)">&nbsp;&nbsp;
				4W<input type="checkbox" name="week4" id="week4" value="N"  onClick="setCheckValue(this)">&nbsp;&nbsp;
				5W<input type="checkbox" name="week5" id="week5" value="N"  onClick="setCheckValue(this)">
			</td>
<td width='25%'></td>
	<td class='button' width='25%' align='right'>		
		<!-- <input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();' > -->
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();' >
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();'  >
	</td>

		
</tr>
</table>
<!-- added by Yadav for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- end -->
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='selected_weeks' id='selected_weeks' value="">
<input type='hidden' name='oper_room_code1' id='oper_room_code1' value="<%=oper_room_code%>">
<input type='hidden' name='wd_start_time' id='wd_start_time' value="<%=wd_start_time%>">
<input type='hidden' name='wd_end_time' id='wd_end_time' value="<%=wd_end_time%>">
<input type='hidden' name='hd_start_time' id='hd_start_time' value="<%=hd_start_time%>">
<input type='hidden' name='hd_end_time' id='hd_end_time' value="<%=hd_end_time%>">
<input type='hidden' name='unit_ot_time_DB' id='unit_ot_time_DB' value="<%=unit_ot_time%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
</form>
</body>
</html>


