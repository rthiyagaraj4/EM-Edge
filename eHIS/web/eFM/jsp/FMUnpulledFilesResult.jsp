<!DOCTYPE html>
<%@ page import="java.util.*, java.sql.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String facility_id="", user_id="", fs_locn_code="", fs_locn_desc="", user_security_yn="";
	String appl_user_name="";
	Connection con	=	null;
	Statement stmt	=	null;
	ResultSet rs	=	null;

	Statement stmt2	=	null;
	ResultSet rs2	=	null;
	String sql2		= "";
	String function_id		= "";
	String access_all = "";
	String fm_strt = "";
	String to_strt = "";
	String sys_date = "",ReportName="FMBUNPFL";

	ReportName = request.getParameter("ReportName");
	function_id = request.getParameter("function_id");


	if (ReportName==null)ReportName="";

	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		user_id		=	(String)session.getValue("login_user");
		stmt		=	con.createStatement();

		String fm_param_query="select user_security_yn, to_char(SYSDATE+1,'DD/MM/YYYY') SYDATE from fm_parameter where facility_id='"+facility_id+"'";

		String sm_user_query="SELECT appl_user_id, appl_user_name from sm_appl_user_lang_vw where  appl_user_id = '"+user_id+"' and language_id='"+localeName+"' order by 2";

		rs = stmt.executeQuery(sm_user_query);

		if(rs.next())
		{
			appl_user_name  = rs.getString("appl_user_name");
		}
		if(rs != null)		rs.close();

		if(appl_user_name==null)appl_user_name="";

		rs = stmt.executeQuery(fm_param_query);
		if(rs.next())
		{
			user_security_yn = rs.getString("user_security_yn");
			sys_date		 = rs.getString("SYDATE");
		}
		sys_date=DateUtils.convertDate(sys_date,"DMY","en",localeName);
		if(rs != null)		rs.close();
		if(user_security_yn == null || user_security_yn.equals("null"))user_security_yn="N";

		String fs_locn_query = "";
		if(user_security_yn.equals("Y"))
		{
			stmt2 = con.createStatement();
			sql2 = "select 1 rec_cnt from fm_user_access_rights where appl_user_id='"+user_id+"' and facility_id='"+facility_id+"' and fs_locn_code='*ALL' ";

			rs2 = stmt2.executeQuery(sql2);
			while(rs2.next())
			{
				access_all = rs2.getString("rec_cnt");
			}

			if (access_all.equals("1"))
			{
				fs_locn_query="SELECT fs_locn_code, short_desc fs_locn_desc FROM fm_storage_locn_lang_vw WHERE facility_id = '"+facility_id+"' AND eff_status='E' AND PERMANENT_FILE_AREA_YN = 'Y' and language_id='"+localeName+"' Order by 2";
			}
			else
			{
				//fs_locn_query="SELECT fs_locn_code, fs_locn_short_desc fs_locn_desc FROM fm_user_access_rights_vw WHERE facility_id = '"+facility_id+"' AND appl_user_id='"+user_id+"'  AND TRACK_OUT_TO_OPD='Y' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
				fs_locn_query="SELECT a.fs_locn_code, LONG_DESC fs_locn_desc  FROM   fm_user_access_rights a,FM_STORAGE_LOCN_lang_vw b  WHERE a.facility_id = '"+facility_id+"' AND appl_user_id='"+user_id+"' and  A.FACILITY_ID=b.FACILITY_ID(+) AND  A.FS_LOCN_CODE=b.FS_LOCN_CODE(+)  AND TRACK_OUT_TO_OPD_YN='Y'   AND PERMANENT_FILE_AREA_YN = 'Y' and b.language_id='"+localeName+"' Order by 2";
			}
		}
		else
		{
			fs_locn_query="SELECT fs_locn_code, short_desc fs_locn_desc FROM fm_storage_locn_lang_vw WHERE facility_id = '"+facility_id+"' AND eff_status='E' AND PERMANENT_FILE_AREA_YN = 'Y' and language_id='"+localeName+"' Order by 2";
		}
	%>
<html>
<head>
	<title></title>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMUnpulledFileList.js'></script>	
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>

	<form name='FMUnpulledFilesMain' id='FMUnpulledFilesMain' action="../../eCommon/jsp/report_options.jsp" method='' target='messageFrame'">
		<table cellpadding='3' cellspacing='0' border='0' width='85%' align='center'>
		<tr><td colspan='4'>&nbsp;</td></tr>
		<tr>
		<td  class='label' width='25%'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
		<td class='fields' width='25%'><select name='p_src_fs_locn_code' id='p_src_fs_locn_code' onChange=''><option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------</option>
		<%
			String sqlt = "select pract_type,Desc_Userdef  from am_pract_type";
			rs	= stmt.executeQuery( sqlt) ;			
			fm_strt="<select name='fm_pract_type' id='fm_pract_type'><option value=''> -------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------";
			to_strt="<select name='to_pract_type' id='to_pract_type'><option value=''> -------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------";
			while(rs!=null&&rs.next()) 
			 {
				String practtype=rs.getString("pract_type");
				String practtypedesc=rs.getString("Desc_Userdef");
				fm_strt=fm_strt + "<option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc;
				to_strt= to_strt + "<option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc;
			 }
			fm_strt=fm_strt + "</select>";
			to_strt= to_strt + "</select>";
			if(rs != null)		rs.close();
	   	    if(stmt != null)	stmt.close();
			stmt =	con.createStatement();
			rs = stmt.executeQuery(fs_locn_query);
			int count=0;
			String selected="";
			while(rs.next())
			{
				count++;
				fs_locn_code	=	rs.getString("fs_locn_code");
				fs_locn_desc	=	rs.getString("fs_locn_desc");

				if(fs_locn_code == null)fs_locn_code="";
				if(fs_locn_desc == null)fs_locn_desc="";

				if(count==1)selected="";
				else selected="";

				out.println("<option value="+fs_locn_code+" "+selected+" >"+fs_locn_desc+"</option>");
			}
		%>
		</select><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<td  class='label' width='25%'>&nbsp;</td>
		<td class='label' width='25%'>&nbsp;</td>
	</tr>
			<tr>
		<td  class='label'><fmt:message key="eFM.PullingListType.label" bundle="${fm_labels}"/></td>
		<td class='fields'><select name=P_STATUS>
		<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value='M'><fmt:message key="Common.main.label" bundle="${common_labels}"/></option>
		<option value='S'><fmt:message key="eFM.Supplementary.label" bundle="${fm_labels}"/></option>
		</select> </td>
		<td colspan = 2></td>
			</tr>

	<tr>
	<%if(function_id.equals("FM_UNPULLED_FILES_FOR_BKG")){%>
		<td class='label' ><fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type='text' id="appt_date" name='p_booking_date' id='p_booking_date' value='<%=sys_date%>' size='10' maxlength='10' tabindex=1 onBlur='validDateObj(this,"DMY","<%=localeName%>");'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('appt_date');"><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		
		<%} else {%>
		<td class='label' ><fmt:message key="Common.AppointmentDate.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type='text' id="appt_date" name='p_appt_date' id='p_appt_date' value='<%=sys_date%>' size='10' maxlength='10' tabindex=1 onBlur='validDateObj(this,"DMY","<%=localeName%>");'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('appt_date');"><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<%}%>
		<td class='label' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='fields' ><select name=p_gender tabindex=2>
			<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
		</select></td>
		
		</tr>
	<tr>
			<td class='label'></td>
			<td class='querydata' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class='label'></td>
			<td class='querydata' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<%if(function_id.equals("FM_UNPULLED_FILES_FOR_BKG")){%>
	<tr>
		<td class='label'><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='p_fm_nursing_unit_code' id='p_fm_nursing_unit_code' size='4' maxlength='4' value='' onKeyPress='return CheckForSpecChars(event)' tabindex=3><input type='button' class='button' name='clinic' id='clinic' value='?'  onClick=searchCode1(p_fm_nursing_unit_code,'<%=facility_id%>')></td>
		<td class='label'><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='p_to_nursing_unit_code' id='p_to_nursing_unit_code' size='4' maxlength='4' value='' onKeyPress='return CheckForSpecChars(event)' tabindex=4><input type='button' class='button' name='clinic' id='clinic' value='?'  onClick=searchCode1(p_to_nursing_unit_code,'<%=facility_id%>');></td>
	</tr>
	<%} else {%>
		<td class='label'><fmt:message key="Common.ClinicCode.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='p_fm_clinic_code' id='p_fm_clinic_code' size='4' maxlength='4' value='' onKeyPress='return CheckForSpecChars(event)' tabindex=3><input type='button' class='button' name='clinic' id='clinic' value='?'  onClick=searchCode1(p_fm_clinic_code,'<%=facility_id%>')></td>
		<td class='label'><fmt:message key="Common.ClinicCode.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='p_to_clinic_code' id='p_to_clinic_code' size='4' maxlength='4' value='' onKeyPress='return CheckForSpecChars(event)' tabindex=4><input type='button' class='button' name='clinic' id='clinic' value='?'  onClick=searchCode1(p_to_clinic_code,'<%=facility_id%>');></td>
	<%}%>
		<tr>
			<td class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
			<td nowrap><%=fm_strt%></td>
			<td class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
			<td><%=to_strt%></td>
		</tr>
		<tr>
		<td class='label'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='p_fm_pract_id' id='p_fm_pract_id' size='15' maxlength='15' value='' onKeyPress='return CheckForSpecChars(event)' tabindex=5><input type='button' class='button' name='pract_id' id='pract_id' value='?'  onClick=searchCode2(p_fm_pract_id,'<%=facility_id%>');></td> 
		<td class='label' ><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='p_to_pract_id' id='p_to_pract_id' size='15' maxlength='15' value='' onKeyPress='return CheckForSpecChars(event)' tabindex=6><input type='button' class='button' name='pract_id' id='pract_id' value='?'  onClick=searchCode2(p_to_pract_id,'<%=facility_id%>');></td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="eFM.PrintTelNoinPullingList.label" bundle="${fm_labels}"/></td>
		<td class='fields'><input type='checkbox' name='print_tel_no' id='print_tel_no' value='Y' onClick="setvalue(this)" checked ><input type='hidden' name='p_print_tel_no' id='p_print_tel_no' value='Y'></td>
		<td class='label' ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name=ORDER_BY>
			<option value='T'><fmt:message key="Common.TerminalDigit.label" bundle="${common_labels}"/></option>
			<%if(function_id.equals("FM_UNPULLED_FILES_FOR_BKG")){%>
			<option value='A'><fmt:message key="Common.BookingTime.label" bundle="${common_labels}"/></option>
			<%} else {%>
			<option value='A'><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></option>
			<%}%>
			</select>
		</td>
	</tr>		
		<tr><td colspan=4>&nbsp;</td></tr>
		</table>
		<script>
			if ('<%=count%>'==1)
			{
				document.forms[0].p_src_fs_locn_code.value = '<%=fs_locn_code%>';
			}
		</script>
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value=<%=facility_id%>>
		<input type="hidden" name="p_module_id" id="p_module_id" 		value='FM'>
		<%if(function_id.equals("FM_UNPULLED_FILES_FOR_BKG")){%>
		<input type="hidden" name="p_report_id" id="p_report_id" 		value='FMBUNPFB'>
		<%} else {%>
		<input type="hidden" name="p_report_id" id="p_report_id" 		value='FMBUNPFL'>
		<%}%>
 		<input type="hidden" name="p_user_name" id="p_user_name"		    value="<%=user_id%>"> 
 		<input type="hidden" name="function_id" id="function_id"		    value="<%=function_id%>"> 
		<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
	</form>
</body>
</html>
			<%
	if(rs != null)		rs.close();
	if(stmt != null)	stmt.close();
	if(rs2 != null)		rs2.close();
	if(stmt2 != null)	stmt2.close();
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

