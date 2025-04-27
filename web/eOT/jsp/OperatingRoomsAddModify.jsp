<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/OperatingRooms.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String oper_room_code = request.getParameter("oper_room_code")==null?"":request.getParameter( "oper_room_code" );
String chk_checked="";
String chk_value="Y";
String over_booking_checked="";
String over_booking_value="N";
String chargable_room_chkd="";
String chargable_room_value="N";
String disable_flag="";
String theatre_type="";
String theatre_desc="";
String oper_room_seq="";
String wd_start_time="";
String wd_end_time="";
String hd_start_time="";
String hd_end_time="";
String long_desc="";
String short_desc="";
String restrict_by_splty_yn="";
String over_booking_allowed_yn="";
String chargable_room="";
String dflt_room_code="";
String dflt_room_desc="";
String service_code="";
String service_desc="";
String no_of_overbookings="";//Added by lakshmi against MO-CRF-20058
//System.out.println("no_of_overbookings::::"+no_of_overbookings);//lakshmi
String sql="";
String oper_room_code_disable="";
String facility_id=(String) session.getAttribute("facility_id");
StringBuffer oper_room_code_from_DB=new StringBuffer();
StringBuffer oper_room_seq_from_DB=new StringBuffer();
String sqlForUnitTime="SELECT TO_CHAR(UNIT_OT_TIME, 'HH24:MI'),CHARGE_OPERATING_ROOM_YN FROM   OT_PARAM_FOR_FACILITY  WHERE  OPERATING_FACILITY_ID = ?";
String unit_ot_time="";
String oper_room_chk_yn="";
//CRF-004 Authorize Slots for Booking - Rajesh V 
String sqlFacilityChk = "select NVL(SCHEDULE_RESTRICT_YN,'N') facility from OT_PARAM where rownum = 1";
String otParam = "";
//CRF-004 Authorize Slots for Booking - Rajesh V 
	try{
		con=ConnectionManager.getConnection(request);
		stmt=con.prepareStatement(sqlForUnitTime);
		stmt.setString(1,facility_id);
		rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				unit_ot_time=rs.getString(1);
				oper_room_chk_yn=CommonBean.checkForNull(rs.getString(2));
			}
		//CRF-004 Authorize Slots for Booking - Rajesh V 
		stmt = null;
		rs = null;
		stmt=con.prepareStatement(sqlFacilityChk);
		rs=stmt.executeQuery();
		if(rs !=null && rs.next())
		{
			otParam=checkForNull(rs.getString("facility"));		
		}
		//CRF-004 Authorize Slots for Booking - Rajesh V 
	 }catch(Exception e){
		e.printStackTrace();
		//out.println("Exception is "+e);
	}finally{
		try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){e.printStackTrace();}
   }



if(mode.equals("modify")){
	try{
		con=ConnectionManager.getConnection(request);
		//sql="SELECT A.OPER_ROOM_CODE, A.LONG_DESC, A.SHORT_DESC,A.THEATRE_TYPE,B.SHORT_DESC,to_char(A.WD_START_TIME,'HH24:MI'),to_char(A.WD_END_TIME,'HH24:MI'),to_char(A.HD_START_TIME,'HH24:MI'),to_char(A.HD_END_TIME,'HH24:MI'),nvl(A.RESTRICT_BY_SPLTY_YN,'N'),A.OPER_ROOM_SEQ,A.SERVICE_CODE,C.LONG_DESC FROM OT_OPER_ROOM A,AM_CARE_LOCN_TYPE B, AM_SERVICE C WHERE A.OPER_ROOM_CODE=? AND A.THEATRE_TYPE=B.LOCN_TYPE(+) AND A.SERVICE_CODE=C.SERVICE_CODE(+)";

//		sql="SELECT A.OPER_ROOM_CODE, A.LONG_DESC, A.SHORT_DESC,A.THEATRE_TYPE,B.SHORT_DESC,to_char(A.WD_START_TIME,'HH24:MI'),to_char(A.WD_END_TIME,'HH24:MI'),to_char(A.HD_START_TIME,'HH24:MI'),to_char(A.HD_END_TIME,'HH24:MI'),nvl(A.RESTRICT_BY_SPLTY_YN,'N'),A.OPER_ROOM_SEQ,A.SERVICE_CODE,C.LONG_DESC,NVL(OVER_BOOKING_ALLOWED_YN,'N') OVER_BOOKING_ALLOWED_YN,CHARGABLE_YN,DFLT_RECOVERY_ROOM_CODE FROM OT_OPER_ROOM_LANG_VW A,AM_CARE_LOCN_TYPE_LANG_VW B, AM_SERVICE_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"' AND A.LANGUAGE_ID='"+locale+"' AND A.OPER_ROOM_CODE=? AND A.THEATRE_TYPE=B.LOCN_TYPE(+) AND A.SERVICE_CODE=C.SERVICE_CODE(+)";
		/*sql="SELECT A.OPER_ROOM_CODE, A.LONG_DESC, A.SHORT_DESC,A.THEATRE_TYPE,B.SHORT_DESC,to_char(A.WD_START_TIME,'HH24:MI'),to_char(A.WD_END_TIME,'HH24:MI'),to_char(A.HD_START_TIME,'HH24:MI'),to_char(A.HD_END_TIME,'HH24:MI'),nvl(A.RESTRICT_BY_SPLTY_YN,'N'),A.OPER_ROOM_SEQ,A.SERVICE_CODE,C.LONG_DESC,NVL(OVER_BOOKING_ALLOWED_YN,'N') OVER_BOOKING_ALLOWED_YN,A.CHARGEABLE_YN,A.DFLT_RECOVERY_ROOM_CODE,GET_DESC('"+locale+"','OT_RECOVERY_ROOM_LANG_VW','RECOVERY_ROOM_DESC','RECOVERY_ROOM_CODE',A.DFLT_RECOVERY_ROOM_CODE) RECOVERY_ROOM_DESC FROM OT_OPER_ROOM_LANG_VW A,AM_CARE_LOCN_TYPE_LANG_VW B, AM_SERVICE_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"' AND A.LANGUAGE_ID='"+locale+"' AND A.OPER_ROOM_CODE=? AND A.THEATRE_TYPE=B.LOCN_TYPE(+) AND A.SERVICE_CODE=C.SERVICE_CODE(+)";*/

		sql="SELECT A.OPER_ROOM_CODE, A.LONG_DESC, A.SHORT_DESC,A.THEATRE_TYPE,B.SHORT_DESC SHORTDESC,to_char(A.WD_START_TIME,'HH24:MI'),to_char(A.WD_END_TIME,'HH24:MI'),to_char(A.HD_START_TIME,'HH24:MI'),to_char(A.HD_END_TIME,'HH24:MI'),nvl(A.RESTRICT_BY_SPLTY_YN,'N'),A.OPER_ROOM_SEQ,A.SERVICE_CODE,C.LONG_DESC LONGDESC,NVL(OVER_BOOKING_ALLOWED_YN,'N') OVER_BOOKING_ALLOWED_YN,A.CHARGEABLE_YN,A.DFLT_RECOVERY_ROOM_CODE,GET_DESC(?,'OT_RECOVERY_ROOM_LANG_VW','RECOVERY_ROOM_DESC','RECOVERY_ROOM_CODE',A.DFLT_RECOVERY_ROOM_CODE) RECOVERY_ROOM_DESC,A.OVER_BOOK_COUNT FROM OT_OPER_ROOM_LANG_VW A,AM_CARE_LOCN_TYPE_LANG_VW B, AM_SERVICE_LANG_VW C WHERE C.LANGUAGE_ID= ? AND B.LANGUAGE_ID= ? AND A.LANGUAGE_ID= ? AND A.OPER_ROOM_CODE=? AND A.THEATRE_TYPE=B.LOCN_TYPE(+) AND A.SERVICE_CODE=C.SERVICE_CODE(+)";//Modified by lakshmi against MO-CRF-20058//WCH Issue

		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,locale);
		stmt.setString(3,locale);
		stmt.setString(4,locale);
		stmt.setString(5,oper_room_code);
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()){
			long_desc=checkForNull(rs.getString(2));
			short_desc=checkForNull(rs.getString(3));
			theatre_type=checkForNull(rs.getString(4));
			theatre_desc=checkForNull(rs.getString(5));
			wd_start_time=checkForNull(rs.getString(6));
			wd_end_time=checkForNull(rs.getString(7));
            hd_start_time=checkForNull(rs.getString(8));
            hd_end_time=checkForNull(rs.getString(9));
            restrict_by_splty_yn=checkForNull(rs.getString(10));
			oper_room_seq=checkForNull(rs.getString(11));
            service_code=checkForNull(rs.getString(12));
			service_desc=checkForNull(rs.getString(13));
			over_booking_allowed_yn=checkForNull(rs.getString(14));
			chargable_room=checkForNull(rs.getString(15));
			dflt_room_code=checkForNull(rs.getString(16));
			dflt_room_desc=checkForNull(rs.getString(17));
			no_of_overbookings=checkForNull(rs.getString(18));//Added by lakshmi against MO-CRF-20058
		}
 	 	if(restrict_by_splty_yn.equals("Y")){
			chk_checked="checked";
			chk_value="Y";
		}else{
			chk_checked="";
			chk_value="N";
		}	 
		if(over_booking_allowed_yn.equals("Y")){//Sanjay
			over_booking_checked="checked";
			over_booking_value="Y";
		}else{
			over_booking_checked="";
			over_booking_value="N";
		}	
		 if(chargable_room.equals("Y")){
			chargable_room_chkd="checked";
			chargable_room_value="Y";
		}else{
			chargable_room_chkd="";
			chargable_room_value="N";
		}	 
		oper_room_code_disable="disabled";	
		}catch(Exception e){
			e.printStackTrace();
			//out.println("Exception is "+e);
		}finally{
			try{
				if(stmt!=null) stmt.close();
				if(rs!=null)rs.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception e){e.printStackTrace();}
				
		}
}
%>
<form name="OperationRooms_form" id="OperationRooms_form"  onload='FocusFirstElement()' action="../../servlet/eOT.OperationRoomServlet" method='post' target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3  width='70%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
	<%
	Statement stm=null;
	String curr_date="";

	try{
		con=ConnectionManager.getConnection(request);
		stm=con.createStatement();
		rs=stm.executeQuery("select '01'||to_char(sysdate,'/mm/yyyy') from dual");
		if(rs!=null && rs.next())
		{
			curr_date=rs.getString(1);
		}
	}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stm!=null) stm.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
		%>
</tr>

	<td class=label>
		<fmt:message key="eOT.TheatreType.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="theatre_desc" id="theatre_desc" value="<%=theatre_desc%>" size=20 maxlength=20
		onBlur="if(this.value!='')callTheatreType(theatre_type,theatre_desc);">
		<input type="hidden" name="theatre_type" id="theatre_type" value="<%=theatre_type%>">
		<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callTheatreType(theatre_type,theatre_desc);">
	     <img src='../../eCommon/images/mandatory.gif'>
	</td> 
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="oper_room_code" id="oper_room_code" value="<%=oper_room_code%>"  size=6 maxlength=6  onkeypress="return CheckForSpecChars(event)" onBlur="ChangeUpperCase(this);checkOperRoomDup(oper_room_code);" <%=oper_room_code_disable%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>"   size='30' maxlength='30'>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>"   size='15' maxlength='15' <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eOT.TheatreSequenceNo.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="oper_room_seq" id="oper_room_seq" value="<%=oper_room_seq%>"   size='3' maxlength='3'  onkeypress=' validatePositiveNumber(oper_room_seq);'>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="eOT.RestrictBySpecialityYN.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type="checkbox" name="restrict_by_splty_yn" id="restrict_by_splty_yn"  onClick='setCheckValueRestrictbySpltyYn(this);' value="<%=chk_value%>" <%=chk_checked%> ><!-- //changed for 43429-->
	</td>
	
</tr>
<tr>
	<td class=label nowrap>
		<fmt:message key="eOT.OverBookingAllowedYN.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields" nowrap>
		<!-- added by Sanjay STARTS here for enabling Count as mandatory only when Over Booked Y/N checkbox is Checked against MO-CRF-20058 -->
		<input type="checkbox" name="over_booking_allowed_yn" id="over_booking_allowed_yn" onClick='setCheckValue(this);checkCount(this);' value="<%=over_booking_value%>" <%=over_booking_checked%>>
	</td>
<!--Added by lakshmi against MO-CRF-20058 starts here -->
	<td class=label nowrap>
		<fmt:message key="Common.count.label" bundle="${common_labels}"/>
	</td>	
	<!-- added by Sanjay STARTS here for enabling Count as mandatory only when Over Booked Y/N checkbox is Checked against MO-CRF-20058 -->	
	<%	
	//if (no_of_overbookings.length() > 0 ) {
		//out.println("over_booking_value:" + over_booking_value + ":");//Sanjay
		if (over_booking_value.equals("Y")) {

	%>
		<td class="fields">
			<!--
			<input type="text" name="No_Of_Overbookings" id="No_Of_Overbookings" value="<%=no_of_overbookings%>"  size='3' maxlength='3' onkeypress= 'validatePositiveNumber1(this);'><img id="count_check" src='../../eCommon/images/mandatory.gif'></img>
			-->
			<input type="text" name="No_Of_Overbookings" id="No_Of_Overbookings" value="<%=no_of_overbookings%>"  size='3' maxlength='3' onblur = 'validatePositiveNumber1(this);'><img id="count_check" src='../../eCommon/images/mandatory.gif'></img>
		</td>	
		
	<%
	} 
	else {
	%>
		<td class="fields">
			<input type="text" name="No_Of_Overbookings" id="No_Of_Overbookings" value="<%=no_of_overbookings%>"  size='3' maxlength='3'  onblur=' validatePositiveNumber1(this);' disabled><img id="count_check" src='../../eCommon/images/mandatory.gif' style='visibility:hidden'></img>		
		</td>
	<%
	}
	%>
<!--Added by lakshmi against MO-CRF-20058 ends here -->
	
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.service.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
	<input type="text" name="service_desc" id="service_desc"  size=30  value="<%=service_desc%>"
	onBlur="if(this.value!='')callService(service_code,service_desc);">
	<input type="hidden" name="service_code" id="service_code" value="<%=service_code%>">
	<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callService(service_code,service_desc);">
     <img src='../../eCommon/images/mandatory.gif'></td> 
</tr>
 <tr>
	<td class=label>
		<fmt:message key="eOT.WorkingDayStartTime.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="wd_start_time" id="wd_start_time" value="<%=wd_start_time%>" onkeypress="return checkForSpecCharsforID(event);" size='5' maxlength='5'  onblur="isValidTimeFormat(this); if(this.value!='')checkExixtingAppWS(this);">
		<img src='../../eCommon/images/mandatory.gif'> (hh24:mi)
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="wd_end_time" id="wd_end_time" value="<%=wd_end_time%>" onkeypress="return checkForSpecCharsforID(event);" size='5'  maxlength='5' onblur="isValidTimeFormat(this); if(this.value!='')checkExixtingAppWE(this);" >
		<img src='../../eCommon/images/mandatory.gif'> (hh24:mi)
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eOT.HolidayStartTime.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="hd_start_time" id="hd_start_time" value="<%=hd_start_time%>" onkeypress="return checkForSpecCharsforID(event);" size='5' maxlength='5' onblur="isValidTimeFormat(this); if(this.value!='')checkExixtingAppHS(this);" >
		<img src='../../eCommon/images/mandatory.gif'> (hh24:mi)
	</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="hd_end_time" id="hd_end_time" value="<%=hd_end_time%>" onkeypress="return checkForSpecCharsforID(event);" size='5' maxlength='5' onblur="isValidTimeFormat(this); if(this.value!='')checkExixtingAppHE(this);" >
		<img src='../../eCommon/images/mandatory.gif'> (hh24:mi)
	</td>
</tr>
<!--CRF-004 Authorize Slots for Booking - Rajesh V  -->
<%if("Y".equalsIgnoreCase(otParam)){%>
<tr>
	<td class=label>
		<fmt:message key="eOT.UserToOverride.Label" bundle="${ot_labels}"/>
	</td>
	<td class=label>
		<a href="javascript:restrictSlots();"><fmt:message key="eOT.SelectUser.Label" bundle="${ot_labels}"/></a>
	</td>
</tr>
<tr>
<tr/>
<%}%>
<!--CRF-004 Authorize Slots for Booking - Rajesh V  -->
<tr>
<%if(oper_room_chk_yn.equals("Y")){%>
	<td class=label>
		<fmt:message key="eOT.ChargableRoom.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type="checkbox" name="chargable_room" id="chargable_room" onClick='setCheckValueChargableRoom(this);' value="<%=chargable_room_value%>" <%=chargable_room_chkd%>><!-- //changed for 43429-->
	</td>
	<%}else{
	%>
		<td class=label >
		<fmt:message key="eOT.ChargableRoom.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type="checkbox" name="chargable_room" id="chargable_room" onClick='setCheckValueChargableRoom(this);' value="<%=chargable_room_value%>" <%=chargable_room_chkd%> disabled><!-- //changed for 43429-->
	</td>
	<%}%>
</tr>
<tr>
	<td class=label>
		<fmt:message key="eOT.DefaultRecoveryRoom.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type="hidden" name="rec_room_code" id="rec_room_code" value="<%=dflt_room_code%>">
		<input type="text" name="rec_room_desc" id="rec_room_desc" value="<%=dflt_room_desc%>" size=20 maxlength=20
		onBlur="if(this.value!='')callRecoveryRoom(rec_room_code,rec_room_desc); else rec_room_code.value='' ">

		<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callRecoveryRoom(rec_room_code,rec_room_desc);">
	     
	</td>
</tr>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='oper_room_code1' id='oper_room_code1' value="<%=oper_room_code%>">
<input type="hidden" name='long_desc1' id='long_desc1' value="<%=long_desc%>">
<input type="hidden" name='short_desc1' id='short_desc1' value="<%=short_desc%>">
<input type="hidden" name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type="hidden" name='wd_start_time1' id='wd_start_time1' value="<%=wd_start_time%>">
<input type="hidden" name='wd_end_time1' id='wd_end_time1' value="<%=wd_end_time%>">
<input type="hidden" name='hd_start_time1' id='hd_start_time1' value="<%=hd_start_time%>">
<input type="hidden" name='hd_end_time1' id='hd_end_time1' value="<%=hd_end_time%>">
<input type="hidden" name='rec_room_code1' id='rec_room_code1' value="<%=dflt_room_code%>">
<input type="hidden" name='oper_room_seq1' id='oper_room_seq1' value="<%=oper_room_seq%>">
<input type="hidden" name='curr_date' id='curr_date' value="<%=curr_date%>">
<input type="hidden" name='oper_room_code_from_DB' id='oper_room_code_from_DB' value="<%=oper_room_code_from_DB%>">
<input type="hidden" name='oper_room_seq_from_DB' id='oper_room_seq_from_DB' value="<%=oper_room_seq_from_DB%>">
<input type='hidden' name='unit_ot_time' id='unit_ot_time' value="<%=unit_ot_time%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='no_of_overbookings1' id='no_of_overbookings1' value="<%=no_of_overbookings%>"><!--Added by lakshmi against MO-CRF-20058-->
<!--CRF-004 Authorize Slots for Booking - Rajesh V -->
<input type='hidden' name='childWinParams' id='childWinParams' value="">
<!--CRF-004 Authorize Slots for Booking - Rajesh V -->
</form>
</body>
</html>


