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
	String sql ="";
	String sql2		= "";
	String sql3		= "";
   String access_all = "";
	String sys_date = "",ReportName="";
	String file_type_yn ="";
	String patient_id_length = "";
	String ReqrepName="";
	String Reportvalue="";
	int count=0;


	ReportName = request.getParameter("ReportName");
    Reportvalue = request.getParameter("ReportName");
	String p_check_fcy				= request.getParameter("p_print_enter_fcy");
	String p_selected_fcy			= request.getParameter("selected_fcy");
	String disabled_selected_fcy	= request.getParameter("disabled_selected_fcy");
	String p_chosen_fcy				= request.getParameter("p_chosen_fcy");
	String reset_mode				= request.getParameter("reset_mode");
	String IPReqrepName="";
	if(p_check_fcy == null) p_check_fcy = "N";
	if(p_selected_fcy == null) p_selected_fcy = "";
	if(disabled_selected_fcy == null) disabled_selected_fcy = "";
	if(reset_mode==null) reset_mode="";
	if(ReportName == null) ReportName = "";
	if(Reportvalue == null) Reportvalue = "";
	if(p_chosen_fcy == null)
	{
	    p_chosen_fcy = "L";
    	p_selected_fcy = "YN";
	   disabled_selected_fcy ="disabled";
	}
		
   	
	if (ReportName.equals("FMBPULST1"))
	{
        IPReqrepName=ReportName;
		ReportName="FMBPULST";
	}
	if (ReportName.equals("OP")||ReportName.equals("IP")||ReportName.equals("RE"))
	{
        ReqrepName=ReportName;
		ReportName="FMFLRQSL";
	}
	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		user_id		=	(String)session.getValue("login_user");
		stmt		=	con.createStatement();
		String fm_param_query="";
        String p_appl_user_name = "";
		sql3 = "select FILE_TYPE_APPL_YN,patient_id_length from mp_param " ;

		rs = stmt.executeQuery(sql3);

		while (rs.next())
		{			
		file_type_yn		 = rs.getString("FILE_TYPE_APPL_YN");
		patient_id_length		 = rs.getString("patient_id_length");
		}
	if(stmt!=null)	stmt.close();
	if(rs!=null)	rs.close();
	
	stmt		=	con.createStatement();
	sql =  "select appl_user_name from sm_appl_user_lang_vw where appl_user_id = '"+user_id+"' and language_id='"+localeName+"'" ;

	rs  = stmt.executeQuery(sql);

	while (rs.next()) {
		p_appl_user_name	= rs.getString("appl_user_name");
	}
	if(rs!=null)	rs.close();
	
		if (ReportName.equals("FMBMRPLA")||ReportName.equals("FMBPULST")||ReportName.equals("FMBATRCD") || ReqrepName.equals("OP"))
			fm_param_query="select user_security_yn, to_char(SYSDATE+NVL(NO_DAYS_CHECK_APPT_INQUIRY,1),'DD/MM/YYYY') SYDATE from fm_parameter where facility_id='"+facility_id+"'";
		else if 
		   (ReportName.equals("FMBISSCD") || ReqrepName.equals("RE"))
			fm_param_query="select user_security_yn, to_char(SYSDATE,'DD/MM/YYYY') SYDATE from fm_parameter where facility_id='"+facility_id+"'";
		else
			fm_param_query="select user_security_yn, to_char(SYSDATE+NVL(NO_DAYS_CHECK_BOOK_INQUIRY,1),'DD/MM/YYYY') SYDATE from fm_parameter where facility_id='"+facility_id+"'";
		String sm_user_query="SELECT appl_user_id, appl_user_name from sm_appl_user where  appl_user_id = '"+user_id+"' order by 2";

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
		if(stmt != null)	stmt.close();
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
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMInternalReportReprint.js'></script>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eFM/js/FMRepRequestFileList.js'></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>

	<form name='OnlineReportReprintForm' id='OnlineReportReprintForm' action='../../servlet/eFM.FMInternalReportReprintServlet' method='post' target='messageFrame'>
		<%if(Reportvalue.equals("RE")){%>
	  <table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<%}else{%>
	<table    cellpadding='3' cellspacing='0' border='0' width='90%' align='center'>
	<%}%>
	<tr><td class='label' colspan='4'>&nbsp;</td></tr>		
		<TR>
	<%if (ReportName.equals("FMBISSCD") || ReqrepName.equals("RE") )
		{
		if(ReportName.equals("FMBISSCD")){
		%>
			<TD width='25%' class= 'label' nowrap><fmt:message key="eFM.DestFSLocationIdentity.label" bundle="${fm_labels}"/></TD>
			<%}if(ReqrepName.equals("RE")){%>
		   <TD width='25%' class= 'label' nowrap><fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></TD>
		<%}%>
		<TD width='25%' class='fields' ><select name="FS_LOCN_ID" id="FS_LOCN_ID"  onChange="PopulateData(this.value)">
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
			<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			<option value="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
			<option value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
			<option value="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
			<option value="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></option>
		</select>
	</TD>
	<%if(!ReqrepName.equals("RE")){%>
		<td class='label' width='25%'></td>
	<td class='label' width='25%'></td>
</TR>
		<%}	}
		%>
		<%if(!ReqrepName.equals("RE")){%>
		<tr>
		<%}%>
		<td class='label' width='25%'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
		<td class='fields' width='25%'><%if(ReqrepName.equals("RE")){%><select name='fs_locn_code' id='fs_locn_code'  onChange="PopulateIdentity(this)"><%}else{%><select name='fs_locn_code' id='fs_locn_code'  onChange=''><%}%><option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------</option>
		<%if (!(ReportName.equals("FMBISSCD")) && (!ReqrepName.equals("RE")) )
		{%>
		<%
			if(stmt != null) stmt=null;
			stmt =	con.createStatement();
			rs = stmt.executeQuery(fs_locn_query);
			
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
		}
		%>
		</select><%if(!ReqrepName.equals("RE")){%><img align='center' src='../../eCommon/images/mandatory.gif'></img><%}%></td>
		<td class='label' width='25%'>&nbsp;</td>
		<td class='label' width='25%'>&nbsp;</td>
	</tr>
 <%if(ReqrepName.equals("RE")){
		%>
<tr>
	<td class= 'label' width='25%'><fmt:message key="eFM.Requesting.label" bundle="${fm_labels}"/>&nbsp;<font id='id1'></font></td>
	<td  class='fields' width='25%' >
		<input type=text size=30 maxlength=30 name='requesting' id='requesting' disabled onblur="chksearch_id();"><input type='button' class='button' name='requesting_btn' id='requesting_btn' value='?' disabled  onClick="search_id(requesting_btn,requesting);" onkeypress="search_id(requesting_btn,requesting);"></img><input type='hidden' name='requesting_code' id='requesting_code'> 
	</td>
<td  class='fields' width='25%' >
</tr>

<%}%>

<tr>
<%
	if(ReportName.equals("FMBMRPLA")||ReportName.equals("FMBPULST")||ReportName.equals("FMBATRCD") ||ReqrepName.equals("OP"))
		{
			%>
		<td class='label' ><fmt:message key="Common.AppointmentDate.label" bundle="${common_labels}"/></td>
<%}else if 
	(ReportName.equals("FMBISSCD"))
		{%>
		<td class='label' ><fmt:message key="Common.IssueDate.label" bundle="${common_labels}"/></td>
<%}else if(ReqrepName.equals("RE")) {%>
		<td class='label'><fmt:message key="eFM.RequiredOnDate.label" bundle="${fm_labels}"/></td>
<%}else {%>
	<td class='label' ><fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/></td>
<%} %>
		
			
			<td class='fields' ><input type='text' id="appt_date" name='appt_date' id='appt_date' value='<%=sys_date%>' size='10' maxlength='10' tabindex=1 onBlur='validDateObj(this,"DMY","<%=localeName%>");'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('appt_date');"></img><img align='center' src='../../eCommon/images/mandatory.gif'></img></td> 
		<%if (ReportName.equals("FMBISSCD"))
		{%>
			<td class='label' colspan='2'>&nbsp;</td>
		<%}else if(!ReqrepName.equals("RE")){%>
		<td class='label'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td  class='fields'><select name=p_gender tabindex=2>
			<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
		</select></td>
		</tr>
<tr>
				<td class='label' >&nbsp;</td>
				<td class='querydata' ><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td>
				<td  class='label' >&nbsp;</td>
				<td class='querydata' ><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
	<%} if(ReqrepName.equals("RE")){
			%>
	 </tr><tr>	<TD class= 'label'><fmt:message key="Common.name.label" bundle="${common_labels}"/></TD>
	<TD class='fields' >
	<input type=text size=30 maxlength=30 name='req_name1' id='req_name1' value=""><input type='hidden' size=40 maxlength=30 name=req_name value=""><input type='button' name='searchcode' id='searchcode' value='?' class='button' onClick="searchCode(req_name,'<%=facility_id%>')">
	</TD>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
			<%}%>	
		</tr>
		<tr>
<%if(ReportName.equals("FMBMRPLA")||(ReportName.equals("FMBPULST") && IPReqrepName.equals(""))||ReportName.equals("FMBATRCD") || ReqrepName.equals("OP"))
		{%>
		<td  class='label'><fmt:message key="Common.ClinicCode.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='fm_clinic_code' id='fm_clinic_code' size='4' maxlength='4' value='' onBlur="changeUpperCase(this);" onKeyPress='return CheckForSpecChars(event)' tabindex=3><input type='button' class='button' name='clinic' id='clinic' value='?'  onClick=searchCode1(fm_clinic_code,'<%=facility_id%>')></td>
		<td  class='label'><fmt:message key="Common.ClinicCode.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='to_clinic_code' id='to_clinic_code' size='4' maxlength='4' value='' onBlur="changeUpperCase(this)" onKeyPress='return CheckForSpecChars(event)' tabindex=4><input type='button' class='button' name='clinic' id='clinic' value='?'  onClick=searchCode1(to_clinic_code,'<%=facility_id%>');></td>
			<%}else if
			(ReportName.equals("FMBISSCD") || (ReqrepName.equals("RE")) )
		{
			
			%>
		<td colspan='4'></td>
			
			<%}else if(!ReqrepName.equals("RE")){%>
		<td class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='fm_nursing_unit_code' id='fm_nursing_unit_code' size='4' maxlength='4' value='' onBlur="changeUpperCase(this);" onKeyPress='return CheckForSpecChars(event)' tabindex=3><input type='button' class='button' name='clinic' id='clinic' value='?'  onClick=searchCode1(fm_nursing_unit_code,'<%=facility_id%>')></td>
		<td class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='to_nursing_unit_code' id='to_nursing_unit_code' size='4' maxlength='4' value='' onBlur="changeUpperCase(this)" onKeyPress='return CheckForSpecChars(event)' tabindex=4><input type='button' class='button' name='clinic' id='clinic' value='?'  onClick=searchCode1(to_nursing_unit_code,'<%=facility_id%>');></td>
<%		}%>
	</tr>
	<%
		if(!(ReportName.equals("FMBATRCD")||ReportName.equals("FMBATRCI")||ReportName.equals("FMBISSCD")) && !(ReqrepName.equals("RE")))
		{
	%>
	<tr>
		<td class='label'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='fm_pract_id' id='fm_pract_id' size='15' maxlength='15' value='' onBlur="changeUpperCase(this);" onKeyPress='return CheckForSpecChars(event)' tabindex=5><input type='button' class='button' name='pract_id' id='pract_id' value='?'  onClick=searchCode2(fm_pract_id,'<%=facility_id%>');></td> 
		<td class='label' ><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='to_pract_id' id='to_pract_id' size='15' maxlength='15' value='' onBlur="changeUpperCase(this)" onKeyPress='return CheckForSpecChars(event)' tabindex=6><input type='button' class='button' name='pract_id' id='pract_id' value='?'  onClick=searchCode2(to_pract_id,'<%=facility_id%>');><input type='hidden' name='subBotton' id='subBotton' class='button' value='Print' onClick=''></td>
	</tr>
	
		
		<%
		}
	%>
		
		<%
	if (ReportName.equals("FMBATRCD")||ReportName.equals("FMBATRCI")||ReportName.equals("FMBISSCD") )
		{%>
		<tr>
			<td class='label'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name=patientid size='18' maxlength='<%=patient_id_length%>' value='' onBlur="ChangeUpperCase(this);CheckPatientExists(this.value);" onKeyPress='return CheckForSpecChars(event)'><input  type=button name=search value='?' class=button onClick="callPatientSearch()" ></td>
		<td class='label' nowrap><%
		if (file_type_yn.equals("N"))
  		{
		%>
			<fmt:message key="Common.fileno.label" bundle="${common_labels}"/>
		<%
	    }else{
		%>
			<fmt:message key="Common.filetype.label" bundle="${common_labels}"/>
		<%
	    }
		%></td>
		<td id="fileid" class='fields'><input type='text' name='fileno' id='fileno' size='15' maxlength='15' value='' onKeyPress='return CheckForSpecChars(event)' onBlur="CheckFileExists(this.value)"></td>
		</tr>
		<tr>
		<td class='label'  nowrap><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
		<td id="volid" class='fields'><select name='volumeno' id='volumeno'><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option></select></td>
		<td class='label' colspan='2'></td>
		</tr>
<%	}
	%>
		
		<%
	if(ReqrepName.equals("IP") || ReqrepName.equals("OP"))
		{%>
		<tr>
			<td class='label'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name=patientid size='18' maxlength='<%=patient_id_length%>' value='' onBlur="ChangeUpperCase(this);CheckPatientExists(this.value);" onKeyPress='return CheckForSpecChars(event)'><input  type=button name=search value='?' class=button onClick="callPatientSearch()" ></td>
		<td class='label' nowrap><%
		if (file_type_yn.equals("N"))
  		{
		%>
			<fmt:message key="Common.fileno.label" bundle="${common_labels}"/>
		<%
	    }else{
		%>
			<fmt:message key="Common.filetype.label" bundle="${common_labels}"/>
		<%
	    }
		%></td>
		<td id="fileid" class='fields'><input type='text' name='fileno' id='fileno' size='15' maxlength='15' value='' onKeyPress='return CheckForSpecChars(event)' onBlur="CheckFileExists(this.value)"></td>
		</tr>
		<tr>
		<td class='label'  nowrap><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
		<td id="volid" class='fields'><select name='volumeno' id='volumeno'><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option></select></td>
		<td class='label' colspan='2'></td>
		</tr>
<%	}
	%>
	
	<%
		if (ReportName.equals("FMBMRPLA")||ReportName.equals("FMBMRPLI") || ReqrepName.equals("OP") || ReqrepName.equals("IP"))
		{
	%>
	<tr>
		<td class='label'><fmt:message key="eFM.PullingListType.label" bundle="${fm_labels}"/></td>
		<td class='fields'><select name=print_pull_list_type tabindex=7>
		<option value='M'><fmt:message key="Common.main.label" bundle="${common_labels}"/></option>
		<option value='S'><fmt:message key="eFM.Supplementary.label" bundle="${fm_labels}"/></option>
		</select> </td> 
		<td class='label' ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name=order_by_pull_list >
		<option value='T'><fmt:message key="Common.TerminalDigit.label" bundle="${common_labels}"/></option>

		<%	if(ReportName.equals("FMBMRPLI")){%>
		<option value='A'><fmt:message key="Common.booking.label" bundle="${common_labels}"/> <fmt:message key="Common.time.label" bundle="${common_labels}"/></option>
		<%}else if(ReportName.equals("FMBMRPLA")) { %>
		<option value='A'><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></option>
		<%}%>
		</select></td>
	</tr>
	<%
		if (ReqrepName.equals("OP")|| ReqrepName.equals("IP"))
		{%>
	
		<%}else{%>
	<tr>
		<td class='label' nowrap><fmt:message key="eFM.PrintTelNoinPullingList.label" bundle="${fm_labels}"/></td>
		<td class='fields'><input type='checkbox' name='print_tel_no' id='print_tel_no' value='N' onClick="EnableDisableBox_print_tel(this)" ></td>		
		<%
		if (ReportName.equals("FMBMRPLA")||ReportName.equals("FMBMRPLI"))
		{%>
		<td class='label'><fmt:message key="eFM.PrintBarCode.label" bundle="${fm_labels}"/></td>
		<td class='fields'><input type='checkbox' name='print_bar_code' id='print_bar_code' value='N' onClick="assignvalue(this)" ></td>

			<%}else{%>				
		<td class='label'  nowrap>&nbsp;</td>
		<td class='fields'><input class=button type=hidden name=print_confirmed_list value='Print Confirmed Files' onClick="PrintReport()" disabled>&nbsp;</td>
			<%}%>
	</tr>
  <%
		}
		}	
	%>
	
	<tr><td class='label' colspan='4'>&nbsp;</td></tr>
		</table>
		<script>
			if ('<%=count%>'==1)
			{
				document.forms[0].fs_locn_code.value = '<%=fs_locn_code%>';
			}
		</script> 
		
		<%if(IPReqrepName.equals("FMBPULST1")) {
		ReportName="FMBIPLST";
		}
			%>
		<input type='hidden' name='CBValStr' id='CBValStr' value=''>
		<input type='hidden' name='print_only_report' id='print_only_report' value=''>

		<input type="hidden" name="p_facility_id" id="p_facility_id"		value='<%=facility_id%>'>
		<input type="hidden" name="p_module_id" id="p_module_id" 		value='FM'>
		<input type="hidden" name="p_report_id" id="p_report_id" 		value='<%=ReportName%>'>
		<input type="hidden" name="p_repreq_id" id="p_repreq_id" 		value='<%=ReqrepName%>'>
		<input type="hidden" name="p_user_name" id="p_user_name"		    value='<%=appl_user_name%>'>
		<input type='hidden' name='validFile' id='validFile' value=''>
		<input type='hidden' name='print_req_slip1' id='print_req_slip1' value=''>
		<input type='hidden' name='file_type_code' id='file_type_code' value=''>
		<input type='hidden' name='proceed' id='proceed' value=''>
		<input type='hidden' name='pat_id' id='pat_id' value=''>
		<input type='hidden' name='file_no' id='file_no' value=''>
		<input type='hidden' name='vol_no' id='vol_no' value=''>
		<input type='hidden' name='Rep_name' id='Rep_name' value=''>
		<input type='hidden' name='req_no' id='req_no' value=''>
		<input type='hidden' name='curr_fs_locn_code' id='curr_fs_locn_code' value=''>
		<input type='hidden' name='encounter_id' id='encounter_id' value=''>
		<input type='hidden' name='req_fac_id' id='req_fac_id' value=''>
		<input type="hidden" name="file_type_yn" id="file_type_yn"		value="<%= file_type_yn %>">
		<input type="hidden" name="p_reprint_yn" id="p_reprint_yn"		value="N"><!--added @UAT-3 -->
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

