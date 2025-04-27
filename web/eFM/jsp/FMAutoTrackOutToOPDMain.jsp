<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		Connection conn = ConnectionManager.getConnection(request);
		String facility_id = (String) session.getValue("facility_id");
		String user_id = (String) session.getValue("login_user");
		String userSecurity  = request.getParameter("userSecurity")==null?"N":request.getParameter("userSecurity");
		String access_all  = request.getParameter("access_all")==null?"N":request.getParameter("access_all");
		Boolean isStartAndEndTimeAvailable 	 = CommonBean.isSiteSpecific(conn, "FM","PULLING_LIST_START_END_TIME");/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014*/
		System.err.println("isStartAndEndTimeAvailable==>"+isStartAndEndTimeAvailable);
%>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>
 
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMAutoTrackOutToOPD.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start-->
	<script language='javascript'>
		function isValidTime(Obj) {
			var Value	= Obj.value;
			if(Value!=""){
				if(!(/^([0-1]?[0-9]|2[0-3]):([0-5][0-9])(:[0-5][0-9])?$/).test(Value) || Value.length!=5){
					var errors= getMessage("INVALID_TIME_FMT","SM");
					alert(errors);
					Obj.value='';
					Obj.focus();
				}
			}
			if(document.forms[0].end_time.value!="" && document.forms[0].start_time.value!=""){
				ChkTimeValidation(Obj);
			}
			
		}
		
		function ChkTimeValidation(Obj){
			var Todaydate = new Date(); 
			var Formatteddate = Todaydate.getDate() +"/" + Todaydate.getMonth() +"/" + Todaydate.getYear();
			var time1 = Formatteddate + " " + document.forms[0].start_time.value;
			var time2 = Formatteddate + " " + document.forms[0].end_time.value;
			var StartTime = new Date(time1);
			var EndTime = new Date(time2);
			var TimeDiff = EndTime.getTime() - StartTime.getTime();
			if(TimeDiff <= 0) {
				var message=getMessage("ED_TIME_LESS_EQL_ST_TIME","OA")+" "+document.forms[0].start_time.value;; 
				alert(message);
				document.forms[0].end_time.value="";
				document.forms[0].end_time.focus();
			}
		}
	
		function ChkTimeInput(fld, e){
		    var strCheck = ':0123456789';
			var whichCode = (window.Event) ? e.which : e.keyCode;
			if (whichCode == 13) return true; 
			var key = String.fromCharCode(whichCode);
			if (strCheck.indexOf(key) == -1) return false;
			if(key == ":" && fld.value.indexOf(key) != -1) return false;
		}
	
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End-->
</head>
<body OnMouseDown='CodeArrest()' onLoad="document.AutoTrackToOPD_Form.iss_locn_code_cmb.focus();" onKeyDown = 'lockKey();'>
<form name='AutoTrackToOPD_Form' id='AutoTrackToOPD_Form' action='../../servlet/eFM.FMAutoTrackOutToOPDServlet' method='post' target='messageFrame'>
	<table border='0' cellpadding='3' cellspacing='0' width='97%' align='center'>
	<td colspan='4' class='columnheader'><fmt:message key="eFM.AutoTrackouttoOPD.label" bundle="${fm_labels}"/></td>
<%
		Statement stmt=null;
		ResultSet rs=null;
		String sql = "";		
		String mysql = "";			
		
		String curr_date = "";		
		String syDate = "";	
		String curr_date_old = "";		
		String syDate_old = "";	
		String attButtStatus = "";
		String issue_user_name="";
		String value="";
		int x = 0;

	try
	{
		
		//rs = stmt.executeQuery("Select appl_user_name,to_char(SYSDATE+1,'DD/MM/YYYY') SYDATE,to_char(SYSDATE,'DD/MM/YYYY') curdate from sm_appl_user where appl_user_id = '"+user_id+"' ");

		value =(String)session.getAttribute("issue_user_name");
		syDate_old =(String)session.getAttribute("syDate");
		curr_date_old =(String)session.getAttribute("curr_date");
		
		if(value==null || value.equals("null")) value="";
		if(syDate_old==null || syDate_old.equals("null")) syDate_old="";
		if(curr_date_old==null || curr_date_old.equals("null")) curr_date_old="";
	
		if(value.equals("") || syDate_old.equals("") || curr_date_old.equals(""))
		{
		stmt =conn.createStatement();		
		
		rs = stmt.executeQuery("Select appl_user_name from sm_appl_user_lang_vw where appl_user_id = '"+user_id+"' and language_id='"+localeName+"' ");
		if(rs.next())
		{
			issue_user_name = rs.getString(1);
			
		}
		session.setAttribute("issue_user_name",issue_user_name);
		
		//syDate=DateUtils.convertDate(syDate,"DMY","en",localeName);
		if(rs!=null)	rs.close();
		//if(stmt!=null) stmt.close();

		rs = stmt.executeQuery("Select to_char(sysdate+nvl(NO_DAYS_CHECK_APPT_INQUIRY,0), 'dd/mm/YYYY') SYDATE, to_char(SYSDATE,'DD/MM/YYYY') curdate from fm_parameter where facility_id = '"+facility_id+"'");
		if(rs.next())
		{
			syDate = rs.getString(1);
			curr_date = rs.getString(2);
		}

		syDate=DateUtils.convertDate(syDate,"DMY","en",localeName);
		session.setAttribute("syDate",syDate);
		session.setAttribute("curr_date",curr_date);
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();

		}else{

     syDate=syDate_old;
    curr_date=curr_date_old;
	issue_user_name	=value;
   }
		
		if(userSecurity.equals("Y"))
		{			
			attButtStatus = "disabled";			

			if (access_all.equals("*ALL"))
			{
				//sql=" Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_STORAGE_LOCN where FACILITY_ID = '"+facility_id+"'  and EFF_STATUS = 'E' and PERMANENT_FILE_AREA_YN = 'Y' order by 2";
				sql="SELECT   FS_LOCN_CODE,fm_get_desc.fm_storage_locn (facility_id,FS_LOCN_CODE,'"+localeName+"',2 ) SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN FROM FM_STORAGE_LOCN WHERE    FACILITY_ID = '"+facility_id+"' AND PERMANENT_FILE_AREA_YN = 'Y' AND EFF_STATUS = 'E'  ORDER BY 2";
			}
			else
			{
				//sql=" Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_USER_ACCESS_RIGHTS_VW where FACILITY_ID = '"+facility_id+"' and APPL_USER_ID = '"+user_id+"' AND TRACK_OUT_TO_OPD = 'Y' AND PERMANENT_FILE_AREA_YN = 'Y' order by 2";
				sql = "SELECT"
					  +"  A.FS_LOCN_CODE"
					  +"  , ("
					  +"  CASE "
					  +"  WHEN A.FS_LOCN_CODE = '*ALL' "
					  +"  THEN"
					  +"    '*ALL' "
					  +"  ELSE B.SHORT_DESC "
					  +"  END) FS_LOCN_SHORT_DESC"
					  +"  , A.LOCN_IDENTITY"
					  +"  , A.MR_LOCN_YN "
					  +"FROM"
					  +"  FM_USER_ACCESS_RIGHTS_VW A"
					  +"  , FM_STORAGE_LOCN_LANG_VW B "
					  +"WHERE A.FACILITY_ID = B.FACILITY_ID(+) "
					  +"  AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) "
					  +"  AND A.FACILITY_ID = '"+facility_id+"' "
					  +"  AND A.APPL_USER_ID = '"+user_id+"' "
					  +"  AND A.TRACK_OUT_TO_OPD = 'Y' "
					  +"  AND A.PERMANENT_FILE_AREA_YN = 'Y' "
					  +"  AND B.LANGUAGE_ID='"+localeName+"' "
					  +"ORDER BY 2";

			}
		}
		else
		{
			//sql=" Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_STORAGE_LOCN where FACILITY_ID = '"+facility_id+"'  and EFF_STATUS = 'E' and PERMANENT_FILE_AREA_YN = 'Y'  order by 2";
			sql=" SELECT   FS_LOCN_CODE,fm_get_desc.fm_storage_locn (facility_id,FS_LOCN_CODE,'"+localeName+"',2 ) SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN FROM     FM_STORAGE_LOCN WHERE FACILITY_ID = '"+facility_id+"' AND PERMANENT_FILE_AREA_YN = 'Y' AND EFF_STATUS = 'E'  ORDER BY 2";
		}

		
%>
		<tr>
			<td class='label' width='25%'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
			<td  width='25%' class='fields'><select name='iss_locn_code_cmb' id='iss_locn_code_cmb' onBlur='refresh(this.value);' tabindex=1>
			<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option> 
<%
			stmt =conn.createStatement();
			rs = stmt.executeQuery(sql);
			String tem_val="";
			if(rs != null)
			{
			   while(rs.next())
			   {
					x++;
					String ID	= rs.getString(1);
					String desc	= rs.getString(2);
					String Iden	= rs.getString(3);
					String mrlocn = rs.getString(4);
				tem_val = ID+"|"+Iden+"|"+mrlocn;
					out.println("<option value='"+tem_val+"'>"+desc+"</option>");
			   }
			}
			if(rs!=null)	rs.close();
%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			<input type="hidden" name="" id="" value="">
			</td>
			<td class='label' width='25%'><fmt:message key="eFM.TrackedoutBy.label" bundle="${fm_labels}"/></td>
			<td class='fields' width='25%'><input type=text size=30 maxlength=60 name='issue_user_name' id='issue_user_name' readonly value='<%=issue_user_name%>'><input type=hidden size=40 maxlength=30 name='issue_user' id='issue_user' readonly value='<%=user_id%>'><input type=button name=searchcode value='?' class=button tabindex=2 onClick="searchCodeTrackedout(issue_user,'<%=facility_id%>',issue_user_name)" <%=attButtStatus%>></td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<%
		 //mysql = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type where sys_user_def_ind = 'S' and locn_type in ('C','E','Y') order by 2";
		 mysql = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and  language_id='"+localeName+"' and locn_type in ('C','E','Y') order by 2";
		 rs = stmt.executeQuery(mysql);
 %>
		<td class='fields'><SELECT name='p_location_type1' id='p_location_type1'  onchange="changeVal(this);"> 
		 <option value='' style='align:center'>------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</option>
<%
			String locn_type="";
            String short_desc="";
            while(rs.next() && rs !=null)
			{
                locn_type=rs.getString("care_locn_type_ind");
                short_desc=rs.getString("short_desc");
                out.println("<option value='"+locn_type+"'>"+short_desc);
			}
%>
		</SELECT></td>
			<td class='label' colspan='2' ></td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="eFM.FromLocationCode.label" bundle="${fm_labels}"/></td>
			<td class='fields'><input type="text" name="from_clinic" id="from_clinic" size="4" maxlength="4" onblur='if(this.value != ""){searchCode(locn, from_clinic,facility_id)}' disabled><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCode(this, from_clinic,facility_id)' disabled>
			</td>
			<td class='label' ><fmt:message key="eFM.ToLocationCode.label" bundle="${fm_labels}"/></td>
			<td class='fields'><input type="text" name="to_clinic" id="to_clinic" size="4" maxlength="4" disabled onblur='if(this.value !=""){ searchCode(locn1, to_clinic,facility_id)}'><input type='button' name='locn1' id='locn1' value='?' class='button' onclick='searchCode(this, to_clinic,facility_id)' disabled>
			</td>
       </tr>
		<tr>
			<td class='label' ><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' id='autoopddate' name='appt_date' id='appt_date' maxlength='10' size='10' value='<%=syDate%>' tabindex=5 onBlur='if(validDateObj(this,"DMY","<%=localeName%>")){ValidateOPDDate(this,"<%=curr_date%>") ;}'><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('autoopddate');"><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
			<td class='label' ><fmt:message key="eFM.PrintTracerCard.label" bundle="${fm_labels}"/></td>
			<td class='fields'><input type='checkbox' name='print_card' id='print_card' value='N' onClick="EnableDisableCheck(this)" tabindex=6>
			</td>
       </tr>
		<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start-->
		<% if(isStartAndEndTimeAvailable){%>
		<tr>
			<td class='label' ><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
			<td class='fields'><INPUT TYPE=TEXT   SIZE=5 MAXLENGTH=5 name='start_time' id='start_time'  onBlur="isValidTime(this)" onKeyPress='return(ChkTimeInput(this,event))'  ></td>
			<td class='label' ><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
			<td class='fields'><INPUT TYPE=TEXT   SIZE=5 MAXLENGTH=5 name='end_time' id='end_time'  onBlur="isValidTime(this);" onKeyPress='return(ChkTimeInput(this,event))'></td>
		</tr>
		<%}else{%>
		<input type='hidden' name='start_time' id='start_time' value=''>
		<input type='hidden' name='end_time' id='end_time' value=''>
	<%}%>
		<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End-->
		<td class='button' colspan='4' align="right"><input type='button' class='button' name='trackout' id='trackout' value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.TrackOut.label","fm_labels")%> ' tabindex=7 onClick="TrackoutFiles();">
		</td>
<%
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();	
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
<table>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='iss_locn_code' id='iss_locn_code' value=''> 
<input type='hidden' name='iss_locn_iden' id='iss_locn_iden' value=''>
<input type='hidden' name='iss_locn_mryn' id='iss_locn_mryn' value=''>
<input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''>
<input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS" value=''>

<script>
	if(<%=x%> == 1)
	{
		parent.frames[1].document.forms[0].iss_locn_code_cmb.options[1].selected = true;
	}
</script>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

