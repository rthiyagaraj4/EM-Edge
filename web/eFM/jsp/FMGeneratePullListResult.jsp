<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	23/06/2002
	Module/Function	:	FM/Generate Pull List
	Function		:	 
-->

<%@ page  import="java.util.*, java.sql.*, webbeans.eCommon.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%


	String facility_id="";
	String sys_date="", sysdate="", user_id="";
	String pull_list_gen_by_gender = "";
	Connection con	=	null;
	Statement stmt	=	null;
	ResultSet rs	=	null;

	String sql = "";

	String fs_locn_code = request.getParameter("fs_locn_code");
	if(fs_locn_code == null || fs_locn_code.equals("null"))fs_locn_code="";
	String appl_user1 = request.getParameter("appl_user");
	if(appl_user1 == null || appl_user1.equals("null"))appl_user1="";
	String customer_id = "";
	try
	{
		con			=	ConnectionManager.getConnection(request);
		
		Boolean isStartAndEndTimeAvailable 	 = CommonBean.isSiteSpecific(con, "FM","PULLING_LIST_START_END_TIME");/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014*/
		System.err.println("isStartAndEndTimeAvailable==>"+isStartAndEndTimeAvailable);
		facility_id	=	(String)session.getValue("facility_id");
		user_id		=	(String)session.getValue("login_user");
		stmt		=	con.createStatement();
		
		String sql_site = "select customer_id from sm_site_param where site_id = 'DS'";

		rs			=	stmt.executeQuery(sql_site);
		if(rs!=null && rs.next()) {
			customer_id =checkForNull(rs.getString("customer_id"));			
		}		
		if(rs != null)		rs.close();
		String sys_date_query="Select pull_list_gen_by_gender, to_char(sysdate+nvl(NO_DAYS_CHECK_APPT_INQUIRY,0), 'dd/mm/YYYY'), to_char(sysdate, 'dd/mm/YYYY') from fm_parameter where facility_id = '"+facility_id+"'";

		rs			=	stmt.executeQuery(sys_date_query);
		if(rs.next())
		{
			pull_list_gen_by_gender = rs.getString(1);
			sys_date	=	rs.getString(2);
			sysdate		=	rs.getString(3);
		}
		sys_date=DateUtils.convertDate(sys_date,"DMY","en",localeName);
		if(rs != null)		rs.close();
%> 
<html>
	<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMPractitionerComponent.js'></script>
	<script language='javascript' src='../../eFM/js/FMGeneratePullList.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 19th 2014 Start-->
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

	<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 19th 2014 End-->
</head>
<body onLoad="FocusFirstElement();chng_appt_date(document.forms[0].print_pull_list_type);" onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='GenaratePulingListForm' id='GenaratePulingListForm' >
<table cellpadding='3' cellspacing='0' width='100%' border='0' align='center'>
<tr><td colspan='4'>&nbsp;</td></tr> 
	<tr>
		<td class='label' width="25%"><fmt:message key="eFM.PullingListType.label" bundle="${fm_labels}"/></td>
		<td  width="25%" class='fields'><select name=print_pull_list_type onChange='chng_appt_date(this)'  >
		<option value='M'><fmt:message key="Common.main.label" bundle="${common_labels}"/></option>
		<option value='S'><fmt:message key="eFM.Supplementary.label" bundle="${fm_labels}"/></option>
		<!-- <option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> -->
		</select> </td>
		<td width='25%'>&nbsp;</td>
		<td width='25%'>&nbsp;</td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='fm_appt_date' id='fm_appt_date' size='10'  maxlength='10' OnBlur='if(validDateObj(this,"DMY","<%=localeName%>")){
	 valChkDate(sysdate,this,sys_date);}' value='<%=sys_date%>'  ><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('fm_appt_date');" id="calend">	<img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<td class='label' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name=p_gender >
			<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		</select><input type='hidden' name='to_appt_date_disp' id='to_appt_date_disp' size='10' maxlength='10' value='<%=sys_date%>' OnBlur='validDateObj(this,"DMY",localeName)' disabled><input type='hidden' name='to_appt_date' id='to_appt_date' value=''></td>
	</tr>
	<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 19th 2014 Start-->
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
	<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 19th 2014 End-->
	<tr>
			<td></td>
			<td class='querydata'><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td>
			<td></td>
			<td class='querydata' ><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='fields'><%
		 //sql = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type where sys_user_def_ind = 'S' and locn_type in ('C','E','Y') order by 2";
		 sql = "SELECT   Locn_Type,ShOrt_Desc, Care_Locn_Type_Ind FROM     am_care_locn_type_lang_vw WHERE    sys_User_def_Ind = 'S' AND Locn_Type IN ('C','E','Y') AND LANGUAGE_ID='"+localeName+"' ORDER BY 2";
		 rs = stmt.executeQuery(sql);
 %>
		 <SELECT name='p_location_type1' id='p_location_type1'  onchange="changeVal(this);"> <!--onChange="javascript:populatePractitioner()"-->
		 <option value='' style='align:center'>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------
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
		<td colspan='2' class='label'></td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="fm_clinic_code" id="fm_clinic_code" size="4" maxlength="4" onblur='if(this.value != ""){search(locn, fm_clinic_code,facility_id)}' disabled><input type='button' name='locn' id='locn' value='?' class='button'  onclick='search(this, fm_clinic_code,facility_id)' disabled></td>
		<td class='label'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/> </td>
		<td class='fields'><input type="text" name="to_clinic_code" id="to_clinic_code" size="4" maxlength="4" disabled onblur='if(this.value != ""){search(locn1, to_clinic_code,facility_id)}'><input type='button' name='locn1' id='locn1' value='?' class='button'  onclick='search(this, to_clinic_code,facility_id)' disabled></td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<SELECT name='p_resource_class1' id='p_resource_class1' id='res' onchange='practValidate(this);getResource(this)' onblur='//resourceOnBlur();'>
				<OPTION value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------
				<OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
				<OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
				<OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
				<OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
            </SELECT>
		</td>
		<td colspan='2' class='label'></td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
		<td class='fields'><SELECT name='fm_pract_type' id='fm_pract_type' onClick='//checkpract()' onChange='enablepr(this);//validateTbs();'>
          <OPTION value='' >------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------
        </SELECT></td>
		<td class='label'><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
		<td  class='fields'><SELECT name='to_pract_type' id='to_pract_type' onClick='//checkpract()' onChange='enablepr1(this);'>
          <OPTION value='' >------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------
        </SELECT></td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="fm_pract_id" id="fm_pract_id" disabled onblur ="onblurcheck(this,fm_pract_id)" size="15" maxlength="15" ><input type='button' name='pract_id' id='pract_id' value='?' class='button' disabled onclick="callPractSearch(this,fm_pract_id)"></td>
		<td class='label'><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="to_pract_id" id="to_pract_id" disabled onblur="onblurcheck(this,to_pract_id)" size="15" maxlength="15"><input type='button' name='pract_id1' id='pract_id1' disabled value='?' class='button' onclick='callPractSearch(this, to_pract_id)'></td>
	</tr>
		<tr><td colspan='4' class = 'BLANKWHITEROW'> </td></tr>
	<tr>
		<td class='label'><fmt:message key="eFM.PrintPullingList.label" bundle="${fm_labels}"/></td>
		<td class='fields'><input type='checkbox' name='gen_report' id='gen_report' value='N' onClick="EnableDisableBox(this,'G')" ></td>
		<td class='label' ><fmt:message key="eFM.PrintTracerCard.label" bundle="${fm_labels}"/></td>
		<td class='fields'><input type='checkbox' name='gen_tracer' id='gen_tracer' value='N' onClick="EnableDisableBox(this,'P')" >
		</td>
	</tr>
	<%
		if(!customer_id.equals("SRR")) {%>
		<tr>
		<td class='label'><fmt:message key="eFM.PrintTelNoinPullingList.label" bundle="${fm_labels}"/></td>
		<td class='fields'><input type='checkbox' name='print_tel_no' id='print_tel_no' value='N' onClick="EnableDisableBox(this,'T')" disabled></td>
		<td  class='label'><fmt:message key="eFM.PrintBarCode.label" bundle="${fm_labels}"/></td>
		<td class='fields'><input type='checkbox' name='print_bar_code' id='print_bar_code' value='N' onClick="assignvalue(this)" disabled></td>
		</tr>		
	<%}%>
		</table>
	<table cellpadding='0' cellspacing='0' width='100%' align='center' border='0'>
		<tr>
			<td class='label' width='25%'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td><td class='fields' width='25%'>&nbsp;
				<select name=order_by_pull_list onChange='chng_appt_date(this)' disabled >
					<option value='T'><fmt:message key="Common.TerminalDigit.label" bundle="${common_labels}"/></option>
					<option value='A'><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			<td class='fields' id='ordID' width='25%'>
				<select name='p_order_term' id='p_order_term'>
					<option value='asc' selected><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
					<option value='desc'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		<tr><td colspan='2'>&nbsp;<td></tr>
				<tr>
		<td  class='label' width='25%'><fmt:message key="eFM.PrintPatientFileRequestSlip.label" bundle="${fm_labels}"/></td>
		<td class='fields'>&nbsp;<input type='checkbox'   name='print_req_slip' id='print_req_slip' checked  value='Y'></td>
		<td class='fields' width='25%'>&nbsp;</td>
		<td class='fields' width='25%'>&nbsp;</td>
		</tr>
		</table>
		<table cellpadding='0' cellspacing='0' width='90%' align='center' border='0'>
		<tr><td colspan='2'>&nbsp;<td></tr>
		<tr>
		<td class='button' align="right" ><input type='button' class='button' name='generate' id='generate' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Generate.label","common_labels")%>' onClick='generateFunc();'></td>
		</tr>
		<tr><td colspan='4'>&nbsp;<td></tr>
	</table>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='fs_locn_code' id='fs_locn_code' value='<%=fs_locn_code%>'>
	<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
	<input type='hidden' name='sysdate' id='sysdate' value='<%=sysdate%>'>
	<input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=appl_user1%>'>
	<input type='hidden' name='pull_list_gen_by_gender' id='pull_list_gen_by_gender' value='<%=pull_list_gen_by_gender%>'>
	<input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''>
	<input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS" value=''>
     <input type="hidden" name="print_req_slip1" id="print_req_slip1" value=''>
     <input type='hidden' name='isStartAndEndTimeAvailable' id='isStartAndEndTimeAvailable' value='<%=isStartAndEndTimeAvailable%>' ><!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 19th 2014-->
	</form>
</body>
</html>
	
<%
	if(rs != null)		rs.close();
	if(stmt != null)stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>

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

