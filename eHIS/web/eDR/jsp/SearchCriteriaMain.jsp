<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,java.util.*," %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	 <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>

	<script language='javascript' src='../../eDR/js/SearchCriteriaMain.js'></script>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
    <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script> 
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	
	
	<script>
	function allowPositiveNumber() 
	{
		var key = window.event.keyCode;// allows only numbers to be entered
		if((key==13)) 
		{
				return false;
		}
	}
	</script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	
	
	String dis_but					= "";
	String str						= "";
	String str_query_param			= "";
	String check_rights				= "";
	String check_dr_param			= "";
	String name_loc_lang_yn			= "";
	String first_name 				= "";
	String second_name 				= "";
	String third_name 				= "";
	String family_name 				= "";
	String ALT1_REQD				= "";
	String ALT2_REQD				= "";
	String ALT3_REQD				= "";
	String ALT4_REQD				= "";	
	String nationality_code			= "";
	String sex 						= "";
	String day_of_birth 			= "";
	String month_of_birth 			= "";
	String year_of_birth 			= "";
	String res_area_code 			= "";
	String contact1_no 				= "";
	String contact2_no				= "";
	String search_type 				= "";
	String first_name_init			= "";  
	String second_name_init			= "";
	String third_name_init			= "";
	String family_name_init			= "";
	String first_name_prompt		= "";	
	String second_name_prompt		= "";	
	String third_name_prompt		= "";	
	String family_name_prompt		= "";
	String dflt_sndx_type			= "";
	String area_type				= "";
	String dis						= "";
	String name_loc_lang_yn_chk		= "";
	String first_name_chk 			= "";
	String second_name_chk 			= "";
	String third_name_chk 			= "";
	String family_name_chk 			= "";
	String nationality_code_chk		= "";
	String sex_chk 					= "";
	String day_of_birth_chk 		= "";
	String month_of_birth_chk 		= "";
	String year_of_birth_chk 		= "";
	String res_area_code_chk 		= "";
	String contact1_no_chk			= "";
	String contact2_no_chk			= "";
	String mode						= "";
	String disbl					= "";
	String RetString				= "";
	String sys_date					= "";
	String sys_time					= "";
	String first_name_reqd_yn		= "";
	String second_name_reqd_yn		= "";
	String third_name_reqd_yn		= "";
	String family_name_reqd_yn		= "";
	String p_order_by				= "";
	String p_order_by_p				= "";
	String p_order_by_r				= "";
	String p_order_by_f				= "";
	String p_order_by_l				= "";
	String p_proc_status			= "";
	//String str1						= "";
	String short1					= "";
	String short2					= "";
	String short3					= "";
	String short4					= "";
	String alt1						= "";
	String alt2						= "";
	String alt3						= "";
	String alt4						= "";
	String short_desc1				= "";
	String short_desc2				= "";
	String short_desc3				= "";
	String short_desc4				= "";
	String names_in_oth_lang_yn		= "";
	String alt_id_type				= "";
	String other_alt_id_type		= "";
	String short_desc				= "";
	String mysql					= "";
	String select_value				= "";
	String first_name_avail			= "N";
	String second_name_avail		= "N";	
	String third_name_avail			= "N";
	String family_name_avail		= "N";
	String area_name_avail			= "N"; 
	String short_desc11				= "N";
	String short_desc22				= "N";
	String short_desc33				= "N";
	String short_desc44				= "N";
	String ALT1_AVAIL				= "N";
	String ALT2_AVAIL				= "N";
	String ALT3_AVAIL				= "N";
	String ALT4_AVAIL				= "N";
	String locale=(String)session.getAttribute("LOCALE");
	
	//int  rec_param	= 0;

	StringBuffer mysqlbuff = new StringBuffer();

	String criteria		= request.getParameter("criteria");
	String display		= request.getParameter("display");
	String button_false	= request.getParameter("button_false");


	if(criteria == null) criteria = "prev";
	if(display == null) display = "";
	if(button_false != null && button_false.equals("Y")) dis_but = "disabled";
	else dis_but = "";
	if(display != null && display.equals("display")) dis = "disabled";

	Properties p		= (Properties) session.getValue("jdbc");
	String login_user	= p.getProperty("login_user");
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		str_query_param = "SELECT search_across_facility_yn,(select search_privilege_level FROM dr_user_rights WHERE appl_user_id = '"+login_user+"') search_privilege_level,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date, to_char(sysdate,'hh24:mi') sys_time, Check_Single_File_For_Patient FROM dr_param";
		rs    = stmt.executeQuery(str_query_param);
		
		if(rs!= null )
		{
			if(rs.next()) {			 
				check_dr_param = rs.getString("search_across_facility_yn");
				check_rights = rs.getString("search_privilege_level");
				sys_date = rs.getString("sys_date");
				sys_time = rs.getString("sys_time");
				RetString = rs.getString("Check_Single_File_For_Patient");
			} if(rs != null) rs.close();


		} else {		
			%>
			<script>
				errors = getMessage("DR_PARAM_NOT_AVAILABLE","DR") ;
				alert(errors);
			</script>
			<%
			if(display != null && display.equals("display"))
			{
				%>
				<script>
					window.close();
				</script>
				<%
			}
			else
			 {
				%>
				<script>
					parent.location.href='../../eCommon/jsp/dmenu.jsp';
				</script>
				<%
			}
		}
		
		str = "";
		if(criteria != null && criteria.equals("dflt"))
		{
			str = "SELECT * FROM dr_def_search_criteria";
		}
		else if(criteria != null && criteria.equals("prev"))
		{
			str ="SELECT * FROM dr_search_criteria";
		}
		
      
		rs	= stmt.executeQuery(str);
		if(rs!=null && rs.next())
		{
			name_loc_lang_yn	= rs.getString("name_loc_lang_yn");
			first_name 			= rs.getString("first_name_yn");
			second_name 		= rs.getString("second_name_yn");
			third_name 			= rs.getString("third_name_yn");
			family_name 		= rs.getString("family_name_yn");
			nationality_code	= rs.getString("nationality_code_yn");
			sex					= rs.getString("sex_yn");
			day_of_birth 		= rs.getString("day_of_birth_yn");
			month_of_birth 		= rs.getString("month_of_birth_yn");
			year_of_birth 		= rs.getString("year_of_birth_yn");
			res_area_code 		= rs.getString("res_area_code_yn");
			contact1_no 		= rs.getString("contact1_no_yn");
			contact2_no			= rs.getString("contact2_no_yn");
			
			search_type 		= rs.getString("search_type");
			short1 				= rs.getString("alt_id1_no_yn");
			short2 				= rs.getString("alt_id2_no_yn");
			short3 				= rs.getString("alt_id3_no_yn");
			short4 				= rs.getString("alt_id4_no_yn");
			other_alt_id_type	= rs.getString("other_alt_id_type");

			if(other_alt_id_type == null || other_alt_id_type.equals("null")) other_alt_id_type = "";
			mode  = "update";
		}
		else
		{
			mode = "insert";
		}	if(rs != null) rs.close();		
		
		str = "SELECT order_by_for_process_cycle ,proc_status FROM dr_process_ctl ";
		rs = stmt.executeQuery(str);
		while(rs.next())
		{
			p_order_by = rs.getString("order_by_for_process_cycle");
			p_proc_status = rs.getString("proc_status");
		} if(rs != null) rs.close();

		if(p_proc_status.equals("AB") || p_proc_status.equals("CS")) p_order_by = "";
		if(name_loc_lang_yn != null && name_loc_lang_yn.equals("Y")) 
		{
			name_loc_lang_yn_chk = "checked";
			disbl = "disabled";
		}

		if(first_name != null && first_name.equals("Y")) first_name_chk = "checked";
		if(second_name != null && second_name.equals("Y")) second_name_chk = "checked";
		if(third_name != null && third_name.equals("Y")) third_name_chk = "checked";
		if(family_name != null && family_name.equals("Y")) family_name_chk = "checked";
		if(nationality_code != null && nationality_code.equals("Y")) nationality_code_chk = "checked";
		if(sex != null && sex.equals("Y")) sex_chk = "checked";
		if(day_of_birth != null && day_of_birth.equals("Y")) day_of_birth_chk = "checked";
		if(month_of_birth != null && month_of_birth.equals("Y")) month_of_birth_chk = "checked";
		if(year_of_birth != null && year_of_birth.equals("Y")) year_of_birth_chk = "checked";
		if(res_area_code != null && res_area_code.equals("Y")) res_area_code_chk = "checked";
		if(contact1_no != null && contact1_no.equals("Y")) contact1_no_chk = "checked";
		if(contact2_no != null && contact2_no.equals("Y")) contact2_no_chk = "checked";
		
		if(short1!= null && short1.equals("Y")) short1 = "checked";
		if(short2!= null && short2.equals("Y")) short2 = "checked";
		if(short3!= null && short3.equals("Y")) short3 = "checked";
		if(short4!= null && short4.equals("Y")) short4 = "checked";
		if(search_type == null) search_type = "";

		str = "";
		str = "select first_name_accept_yn,second_name_accept_yn,third_name_accept_yn,family_name_accept_yn,nvl(first_name_prompt,'First Name') first_name_prompt,nvl(second_name_prompt,'Second Name') second_name_prompt,nvl(third_name_prompt,'Third Name') third_name_prompt,nvl(family_name_prompt,'Family Name') family_name_prompt,dflt_sndx_type,res_area_prompt,first_name_reqd_yn, second_name_reqd_yn,third_name_reqd_yn,family_name_reqd_yn,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"',1) short_desc,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"',1)short_desc1,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"',1)short_desc2,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"',1)short_desc3,ALT_ID1_TYPE,ALT_ID2_TYPE,ALT_ID3_TYPE,ALT_ID4_TYPE,ALT_ID1_EXP_DATE_ACCEPT_YN,ALT_ID2_EXP_DATE_ACCEPT_YN,ALT_ID3_EXP_DATE_ACCEPT_YN,ALT_ID4_EXP_DATE_ACCEPT_YN,names_in_oth_lang_yn from mp_param_lang_vw a,sm_site_param_lang_vw b where a.language_id='"+locale+"' and b.language_id='"+locale+"'";
		
		rs	= stmt.executeQuery(str);
		if(rs != null)
		{
			if(rs.next())
			{
				first_name_init			= rs.getString("first_name_accept_yn");
				second_name_init		= rs.getString("second_name_accept_yn");
				third_name_init			= rs.getString("third_name_accept_yn");
				family_name_init		= rs.getString("family_name_accept_yn");
				first_name_prompt		= rs.getString("first_name_prompt");
				second_name_prompt		= rs.getString("second_name_prompt");
				third_name_prompt		= rs.getString("third_name_prompt");
				family_name_prompt		= rs.getString("family_name_prompt");
				dflt_sndx_type			= rs.getString("dflt_sndx_type");
				area_type				= rs.getString("res_area_prompt");
				first_name_reqd_yn		= rs.getString("first_name_reqd_yn");
				second_name_reqd_yn		= rs.getString("second_name_reqd_yn");
				third_name_reqd_yn		= rs.getString("third_name_reqd_yn");
				family_name_reqd_yn		= rs.getString("family_name_reqd_yn");
				alt1					= rs.getString("alt_id1_type");
				alt2					= rs.getString("alt_id2_type");
				alt3					= rs.getString("alt_id3_type");
				alt4					= rs.getString("alt_id4_type");
				ALT1_REQD				= rs.getString("alt_id1_exp_date_accept_yn");
				ALT2_REQD				= rs.getString("alt_id2_exp_date_accept_yn");
				ALT3_REQD				= rs.getString("alt_id3_exp_date_accept_yn");
				ALT4_REQD				= rs.getString("alt_id4_exp_date_accept_yn");
				names_in_oth_lang_yn	= rs.getString("names_in_oth_lang_yn");
				if(names_in_oth_lang_yn == null || names_in_oth_lang_yn.equals("null"))names_in_oth_lang_yn = "";
				short_desc1 = rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
				short_desc2=rs.getString("SHORT_DESC1")==null?"":rs.getString("SHORT_DESC1");
				short_desc3=rs.getString("SHORT_DESC2")==null?"":rs.getString("SHORT_DESC2");
				short_desc4=rs.getString("SHORT_DESC3")==null?"":rs.getString("SHORT_DESC3");			 
				 ALT1_AVAIL = "Y";
				 ALT2_AVAIL = "Y";
				 ALT3_AVAIL = "Y";
				 ALT4_AVAIL = "Y";
			}
		} if(rs != null) rs.close();

		if(ALT1_REQD == null) ALT1_REQD = "N";
		if(ALT2_REQD == null) ALT2_REQD = "N";
		if(ALT3_REQD == null) ALT3_REQD = "N";
		if(ALT4_REQD == null) ALT4_REQD = "N";
		if(first_name_reqd_yn == null) first_name_reqd_yn = "N";
		if(second_name_reqd_yn == null) second_name_reqd_yn = "N";
		if(third_name_reqd_yn == null) third_name_reqd_yn = "N";
		if(family_name_reqd_yn == null) family_name_reqd_yn = "N";
		if(dflt_sndx_type == null) dflt_sndx_type = "";
		
		//****** added by meghanath on 20/11/2004 ******//

		mysql = "SELECT alt_id_type,long_desc FROM mp_alternate_id_type_lang_vw WHERE alt_id_type NOT IN (select alt_id1_type FROM mp_param UNION SELECT NVL(alt_id2_type,1) FROM mp_param UNION SELECT NVL(alt_id3_type,2) FROM mp_param UNION SELECT nvl(alt_id4_type,3) FROM mp_param) AND eff_status='E' and language_id='"+locale+"' order by 2";
	
		rs   = stmt.executeQuery(mysql);
		while(rs != null && rs.next())
		{
			alt_id_type = rs.getString("alt_id_type");
			short_desc = rs.getString("long_desc");

			if(alt_id_type == null || alt_id_type.equals("null")) alt_id_type = "";
			if(short_desc == null || short_desc.equals("null")) short_desc = "";

			if(alt_id_type.equals(other_alt_id_type)) select_value = "selected";
			else select_value = "";

			mysqlbuff.append("<option value='"+alt_id_type+"' "+select_value+">"+short_desc+"</option>");
		} if(rs != null) rs.close();

		 //********************* end ********************// 
	
%>
		<form name='DuplicateSearchCriteria' id='DuplicateSearchCriteria' action='../../servlet/eDR.SearchDuplicateServlet' method='post' target='messageFrame'>
		<input type=hidden name='short_desc11' id='short_desc11' value='<%=short_desc11%>'>
		<input type=hidden name='short_desc22' id='short_desc22' value='<%=short_desc22%>'>
		<input type=hidden name='short_desc33' id='short_desc33' value='<%=short_desc33%>'>
		<input type=hidden name='short_desc44' id='short_desc44' value='<%=short_desc44%>'>
		<input type=hidden name='first_name_avail' id='first_name_avail' value='<%=first_name_avail%>'>
		<input type=hidden name='second_name_avail' id='second_name_avail' value='<%=second_name_avail%>'>
		<input type=hidden name='third_name_avail' id='third_name_avail' value='<%=third_name_avail%>'>
		<input type=hidden name='family_name_avail' id='family_name_avail' value='<%=family_name_avail%>'>
		<input type=hidden name='area_name_avail' id='area_name_avail' value='<%=area_name_avail%>'>
		<input type=hidden name='alt1_avail' id='alt1_avail' value='<%=ALT1_AVAIL%>'>
		<input type=hidden name='alt2_avail' id='alt2_avail' value='<%=ALT2_AVAIL%>'>
		<input type=hidden name='alt3_avail' id='alt3_avail' value='<%=ALT3_AVAIL%>'>
		<input type=hidden name='alt4_avail' id='alt4_avail' value='<%=ALT4_AVAIL%>'>
		<input type ='hidden' name ='day_of_birth1' id ='day_of_birth1' value=''>
		<input type ='hidden' name ='month_of_birth1' id='month_of_birth1' value=''>	
		<input type ='hidden' name ='year_of_birth1' id='year_of_birth1' value=''>
		<input type ='hidden' name ='first_name_reqd_yn' value='<%=first_name_reqd_yn%>'>
		<input type ='hidden' name ='second_name_reqd_yn' value='<%=second_name_reqd_yn%>'>
		<input type ='hidden' name ='third_name_reqd_yn' value='<%=third_name_reqd_yn%>'>
		<input type ='hidden' name ='family_name_reqd_yn' value='<%=family_name_reqd_yn%>'>
		<input type=hidden name='first_name_prompt' id='first_name_prompt' value='<%=first_name_prompt%>'>
		<input type=hidden name='second_name_prompt' id='second_name_prompt' value='<%=second_name_prompt%>'>
		<input type=hidden name='third_name_prompt' id='third_name_prompt' value='<%=third_name_prompt%>'>
		<input type=hidden name='family_name_prompt' id='family_name_prompt' value='<%=family_name_prompt%>'>
		<input type=hidden name='first_name_init' id='first_name_init' value='<%=first_name_init%>'>
		<input type=hidden name='second_name_init' id='second_name_init' value='<%=second_name_init%>'>
		<input type=hidden name='third_name_init' id='third_name_init' value='<%=third_name_init%>'>
		<input type=hidden name='family_name_init' id='family_name_init' value='<%=family_name_init%>'>

		<%
		 if(!display.equals("display"))
		{
			%>
			<table border=0 cellspacing=0 width='90%' cellpadding='0' align ='center'>
				<td colspan='4' class='white'></td>
				<tr>
					<td class='white' align='right'><input type='button' class='BUTTON' value='<fmt:message key="eDR.AuditData.label" bundle="${dr_labels}"/>' name='audit_data' onclick='call_audit()';>&nbsp;<input type='button' class='BUTTON' value='<fmt:message key="eDR.DefaultCriteria.label" bundle="${dr_labels}"/>' name='default_criteria' onclick='call_dflt_criteria()';  <%=dis_but%> >&nbsp;<input type='button' class='BUTTON' value='<fmt:message key="eDR.PreviousCriteria.label" bundle="${dr_labels}"/>' name='previous_criteria' onclick='call_previous_criteria()'; <%=dis_but%> ></td>
				</tr>
				<tr>
					<td class='white' nowrap colspan='4'></td></tr><tr><td class='white' nowrap colspan='4'></td></tr><tr><td class='white' nowrap colspan='4'></td></tr><tr><td class='white' nowrap colspan='4'></td></tr><tr><td class='white' nowrap colspan='4'></td>
				</tr>
			</table>
			<%
		}
		%>
		<table border='0' cellpadding='0' cellspacing='0' width='90%' align ='center'>
			<tr>
				<td colspan='4'  class='CAGROUP_HEADING'><b><font size='2'><fmt:message key="eDR.CriteriaforCurrentSearch.label" bundle="${dr_labels}"/></font></b></td>
			</tr> 
			<tr><td colspan='4'>&nbsp;</td></tr>		
			<tr>
			<tr><th class='columnheader' colspan='4' style="text-align:left;"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th></tr>
			 <tr><td colspan='4'>&nbsp;</td></tr>		
			<tr>
			<% if(names_in_oth_lang_yn.equals("Y")) { %>
				<td  width='20%'   class='label'  nowrap ><fmt:message key="eDR.NameinLocalLanguage.label" bundle="${dr_labels}"/></td>

				<td  width='30%' class='fields'><input type='checkbox' name='name_loc_lang_yn' id='name_loc_lang_yn'  value="Y" align='left' <%=name_loc_lang_yn_chk%>  <%=dis%>  onClick="disable_soundex()"></td>

			<% } else { %>

				<td colspan='2' class='label'>&nbsp;</td>
					
			<%}%>

				<td  width='20%' class='label'  nowrap ><fmt:message key="eDR.SoundexAlgorithm.label" bundle="${dr_labels}"/></td>

			<% if(dflt_sndx_type.equals("G")) { %>		
				<td width='30%' class='fields' >
					<select name='names_sndx_type' id='names_sndx_type' <%=disbl%> <%=dis%> >
						<option value='N' selected><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
						<option value='G'><fmt:message key="Common.generic.label" bundle="${common_labels}"/></option>
					</select>
				</td>
			<% } else if(dflt_sndx_type.equals("E")) { %>
				<td width='30%' class='fields' >
					<select name='names_sndx_type' id='names_sndx_type' <%=disbl%> <%=dis%> >
						<option value='N' selected ><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
						<option value='E'><fmt:message key="Common.Ethnic.label" bundle="${common_labels}"/></option>
					</select>
				</td>
			<% } else { %>	
				<td width='30%' class='fields' >
					<select name='names_sndx_type' id='names_sndx_type' <%=disbl%> <%=dis%> >
						<option value='N' selected ><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
					</select>
				</td>
			<% } %>	
			</tr>
			 <tr>			
				<%	
				if(alt1 != null && short_desc1 != null && !short_desc1.equals("") && ALT1_REQD != null && ALT1_REQD.equals("Y"))
				{
					%>
					<script>
						document.getElementById("short_desc11").value = 'Y';
					</script>
					<% 
				}
				if(!short_desc1.equals("") && short_desc1 != null)
				{
					%>
					<td  width='20%' class='label'  nowrap ><%=short_desc1%></td>
					<td  width='30%' class='fields' ><input type='checkbox' name='short_desc1' id='short_desc1'  value="Y" align='left' <%=short1%> <%=dis%> ></td>
					<% 
				}
				else
				{ 
					%>
					<td colspan='2'></td>
					<input type='hidden' name='short_desc1' id='short_desc1' value = 'N'>
					<%
				}
				%>
				<td colspan='2'>&nbsp;</td>
			</tr>

			<tr>
			<%	
			if(first_name_prompt != null && !(first_name_prompt.equals("")) && first_name_init != null && first_name_init.equals("Y"))
			{
				%>
				<script>
					document.getElementById("first_name_avail").value = 'Y';
				</script>
				<%
			}
			if(first_name_prompt != null && !(first_name_prompt.equals("")) && first_name_init != null && first_name_init.equals("Y"))
			{
				%>
				<td  width='20%' class='label'  nowrap  ><%=first_name_prompt%></td>
				<td  width='30%' class='fields' ><input type='checkbox' name='first_name' id='first_name' value="Y" align='left' <%=first_name_chk%> <%=dis%> ></td>
				<%
			}
			else
			{
				%>
				<input type='hidden' name='first_name' id='first_name' value="N">
				<td class='label'colspan='2'>&nbsp;</td>
				<%
			} 
			if(alt2 != null && short_desc2!=null && !short_desc2.equals("") && ALT2_REQD !=null && ALT2_REQD.equals("Y") )
			{
				%>
				<script>
					document.getElementById("short_desc22").value='Y';
				</script>
				<% 
			}
			if(!short_desc2.equals("") && short_desc2 != null)
			{
				%>
				<td  width='20%'   class='label'  nowrap ><%=short_desc2%></td>
				<td  width='30%' class='fields'><input type='checkbox' name='short_desc2' id='short_desc2'  value="Y" align='left' <%=short2%> <%=dis%>></td>
				<%
			}
			else
			{
				%>
				<td colspan='2'>&nbsp;</td>
				<input type=hidden name=short_desc2 value='N'>
				<% 
			}
			%>
			</TR>	
			<TR>	
			<%
			if(second_name_prompt != null && !(second_name_prompt.equals("")) && second_name_init != null && second_name_init.equals("Y"))
			{
				%>
				<script>
					document.getElementById("second_name_avail").value='Y';
				</script>
				<%
			}
			if(second_name_prompt != null && !(second_name_prompt.equals("")) && second_name_init != null && second_name_init.equals("Y"))
			{
				%>
				<td  width='20%'   class='label'  nowrap  ><%=second_name_prompt%></td>
				<td  width='30%' class='fields' ><input type='checkbox' name='second_name' id='second_name'  value="Y" align='left' <%=second_name_chk%> <%=dis%> ></td>
				<%
			}
			else
			{
				%>
				<input type='hidden' name='second_name' id='second_name' value="N">
				<td class='label' colspan='2'>&nbsp;</td>
				<%
			}
			if(alt3 != null && short_desc3!=null && !short_desc3.equals("") && ALT3_REQD !=null && ALT3_REQD.equals("Y") )
			{
				%>
				<script>
					document.getElementById("short_desc33").value='Y';
				</script>
				<%
			}
			if(!short_desc3.equals("") && short_desc3!=null)
			{	%>
				<td  width='20%'   class='label'  nowrap ><%=short_desc3%></td>
				<td  width='5%' class='fields' ><input type='checkbox' name='short_desc3' id='short_desc3'  value="Y" align='left' <%=short3%> <%=dis%>></td>
				<%
			}
			else
			{ 
				%>
				<td colspan='2'>&nbsp;</td>
				<input type=hidden name=short_desc3 value='N'>
				<%
			}
			%>
			</TR>	
			<TR>	
			<%
			if(third_name_prompt != null && !(third_name_prompt.equals("")) && third_name_init != null && third_name_init.equals("Y"))
			{
				%>	
				<script>
					document.getElementById("third_name_avail").value = 'Y';
				</script>
				<%
			}
			if(third_name_prompt != null && !(third_name_prompt.equals("")) && third_name_init != null && third_name_init.equals("Y"))
			{
				%>
				<td  width='20%'   class='label'  nowrap ><%=third_name_prompt%></td>
				<td  width='30%' class='fields' ><input type='checkbox' name='third_name' id='third_name'  value="Y" align='left' <%=third_name_chk%> <%=dis%> ></td>
				<%
			}
			else
			{
				%>
				<input type='hidden' name='third_name' id='third_name' value="N">
				<td class='label' colspan='2'>&nbsp;</td>
				<%
			}
			if(alt4 != null && short_desc4!=null && !short_desc4.equals("") && ALT4_REQD !=null && ALT4_REQD.equals("Y") )
			{
				%>
				<script>
					document.getElementById("short_desc44").value = 'Y';
				</script>
				<%
			}
			if(!short_desc4.equals("") && short_desc4 != null)
			{
				%>
				<td  width='20%'   class='label'  nowrap ><%=short_desc4%></td>
				<td  width='30%' class='fields' ><input type='checkbox' name='short_desc4' id='short_desc4'  value="Y" align='left' <%=short4%>  <%=dis%>></td>
				<% 
			}
			else
			{
				%>
				<td colspan='2'>&nbsp;</td>
				<input type=hidden name=short_desc4 value='N'>
				<% 
			}
			%>
			</TR>	
			<TR>
			<%
			if(family_name_prompt != null && !(family_name_prompt.equals("")) && family_name_init != null && family_name_init.equals("Y"))
			{
				%>	
				<script>
					document.getElementById("family_name_avail").value='Y';
				</script>
				<td  width='20%'   class='label'  nowrap  ><%=family_name_prompt%></td>
				<td  width='30%' class='fields' ><input type='checkbox' name='family_name' id='family_name' value="Y" align='left' <%=family_name_chk%> <%=dis%> ></td>
				<%
			}
			else
			{
				%>
				<input type='hidden' name='family_name' id='family_name' value="N">
				<td colspan='2'>&nbsp;</td>
				<%
			}
			%>
				<td class='label' width='20%' ><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>

				<td class='fields' width='30%'><select name='other_alt_id_type' id='other_alt_id_type' <%=dis%>>
				<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><%=mysqlbuff.toString()%></select><td>

			</tr>			
			<tr><td colspan='4'>&nbsp;</td></tr>		
			<tr><th class='columnheader' colspan='4' style="text-align:left;" ><fmt:message key="eDR.DemographicData.label" bundle="${dr_labels}"/></th></tr>
			<tr><td colspan='4'>&nbsp;</td></tr>		
			<tr>
				<td  width='20%' class='label'  nowrap  ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
				<td  width='30%' class='fields'><input type='checkbox' name='nationality_code' id='nationality_code'  value="Y" align='left' <%=nationality_code_chk%> <%=dis%> ></td>
				<td colspan='2'></td>
			</tr>
			<tr>
				<td width='20%' class='label' nowrap ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
				<td width='30%' class='fields'><input type='checkbox' name='sex' id='sex' value="Y" align='left' <%=sex_chk%> <%=dis%>></td>
				<td colspan='2'></td>
			</tr>			  
			<tr>
			</table>
		<table border='0' cellpadding='0' cellspacing='0' width='90%' align ='center'>
				<td width='10%' class='label'  nowrap ><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></td><td class='label' width='10%'><fmt:message key="Common.year.label" bundle="${common_labels}"/></td><td class='fields' width='10%'><input type='checkbox' name='year_of_birth' id='year_of_birth'  value="Y" align='left' <%=year_of_birth_chk%><%=dis%>></td><td class='label' width='10%'><fmt:message key="Common.month.label" bundle="${common_labels}"/></td><td class='fields'  width='10%'><input type='checkbox' name='month_of_birth' id='month_of_birth'  value="Y" align='left' <%=month_of_birth_chk%> onClick="chk_month(this)" <%=dis%>></td>	<td class='label' width='19%'><fmt:message key="Common.day.label" bundle="${common_labels}"/></td><td class='label' width='31%'><input type='checkbox' name='day_of_birth' id='day_of_birth'  value="Y" align='left' <%=day_of_birth_chk%> onClick="chk_year(this)"<%=dis%>></td></tr>		 
			</table>
		<table border='0' cellpadding='0' cellspacing='0' width='90%' align ='center'>
		<% if(area_type != null) { %>
				<tr>
					<script>
						document.getElementById("area_name_avail").value='Y';
					</script>
					<td  width='20%'   class='label'  nowrap  ><%=area_type%></td>
					<td  width='30%' class='fields'><input type='checkbox' name='res_area_code' id='res_area_code'  value="Y" align='left' <%=res_area_code_chk%> <%=dis%>></td>
					<td colspan='2'></td>
				</tr>
				<%
			}
			%>
			<tr>
				<td  width='20%' class='label'  nowrap ><fmt:message key="eDR.ResTelNo.label" bundle="${dr_labels}"/></td>
                
				<td width='30%' class='fields' nowrap width='26%'><input type='checkbox' name='contact1_no' id='contact1_no'  value="Y" align='left' <%=contact1_no_chk%> <%=dis%> ></td>	

				<td  width='20%' class='label' nowrap valign='center' ><fmt:message key="eDR.OtherContactNo.label" bundle="${dr_labels}"/></td>

				<td width='30%' class='fields' nowrap ><input type='checkbox' name='contact2_no' id='contact2_no'  value="Y" align='left' valign='center' <%=contact2_no_chk%> <%=dis%>></td>              
 </tr>
		
		</table>
		<table border='0' cellpadding='3' cellspacing='0' width='90%' align ='center'>
		<tr><td colspan='4'>&nbsp;</td></tr>		
			<tr><th class='columnheader' colspan='4' style="text-align:left;"><fmt:message key="eDR.ScopeofSearch.label" bundle="${dr_labels}"/></th></tr>
			<tr><td colspan='4'>&nbsp;</td></tr>		
		<tr>
			<td  width='20%' class='label' ><fmt:message key="eDR.SearchType.label" bundle="${dr_labels}"/></td>
			<td width='30%' class='fields'>
			<select name='search_type' id='search_type' <%=dis%> >
			<%
			
			if(check_dr_param.equals("N"))
			{
				%>
				<option value='L' selected ><fmt:message key="Common.LoggedinFacility.label" bundle="${common_labels}"/></option>
				<%
			}else if (check_dr_param.equals("Y"))
			{
					out.println("check_rights:" +check_rights);
				if (check_rights.equals("A"))
				{
					%>
					<option value='A'  selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value='L' ><fmt:message key="Common.LoggedinFacility.label" bundle="${common_labels}"/></option>
					<%
				}else if (check_rights.equals("L"))
				{
					%>
					<option value='L' selected ><fmt:message key="Common.LoggedinFacility.label" bundle="${common_labels}"/></option>
					<%   
				}
			}
			%>
			</select><img src="../../eCommon/images/mandatory.gif" ></img></td>
			<td  width='20%' class='label' ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>

			<td width='30%' class='fields'><select name='order_by' id='order_by' <%=dis%> >
			<%
			if(p_order_by.equals("P"))
			{
				p_order_by_p = "selected";
				p_order_by_r = "";
				p_order_by_f = "";
				p_order_by_l = "";
			}
			else if (p_order_by.equals("R"))
			{
				p_order_by_p = "";
				p_order_by_r = "selected";
				p_order_by_f = "";
				p_order_by_l = "";
			}
			else if (p_order_by.equals("F"))
			{
				p_order_by_p = "";
				p_order_by_r = "";
				p_order_by_f = "selected";
				p_order_by_l = "";
			}
			else if (p_order_by.equals("L"))
			{
				p_order_by_p = "";
				p_order_by_r = "";
				p_order_by_f = "";
				p_order_by_l = "selected";
			}
			%>
			<option value='P' <%=p_order_by_p%>><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
			<option value='R' <%=p_order_by_r%>><fmt:message key="Common.RegnDate.label" bundle="${common_labels}"/></option>
			<%
			if(RetString !=null && RetString.equals("T"))
			{
				%>
				<option value='L' <%=p_order_by_l%>><fmt:message key="eDR.FileLocation.label" bundle="${dr_labels}"/></option>
				<option value='F' <%=p_order_by_f%>><fmt:message key="Common.fileno.label" bundle="${common_labels}"/></option>
				<%
			}
			%>
			</td>
			</tr>
			<input type='hidden' name='mode' id='mode' value=<%=mode%>>
		</table>

		<script>
			<% if(!search_type.equals("")) 
			{ 
				%>
				document.getElementById("search_type").value='<%=search_type%>';
				<% 
			} 
			%>
		</script>

		<% 
		if(display !=null && display.equals("display")) 
		{
			%>
			<table border='0' cellpadding='0' cellspacing='0' width='90%' align ='center'>
				<tr><td class='label' nowrap colspan='4'></td></tr>
				<tr><td class='label' nowrap colspan='4'></td></tr>
				<tr><td class='label' nowrap colspan='4'></td></tr>
				<tr><td class='label' nowrap colspan='4'></td></tr>
				<tr><td class='label' nowrap colspan='4'></td></tr>
				<tr><td class='label' nowrap colspan='4'></td></tr>
				<tr><td class='label' nowrap colspan='4'></td></tr>
				<tr><td class='label' ><p align='right'><input type='button' class='BUTTON' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' name='close' onClick='modal_close()' ></p></td></tr>
				<%
		} 
		else 
		{ 
			%>
			<table border=' 0' cellpadding='3' cellspacing='0' width='90%' align ='center'>
			  <tr><td colspan='4'>&nbsp;</td></tr>	

				<tr><th class='columnheader' colspan='4' style="text-align:left;"><fmt:message key="Common.ActionType.label" bundle="${common_labels}"/></th></tr>
				 <tr><td colspan='4'>&nbsp;</td></tr>	
			 	<tr>					
					<% if(button_false !=null && button_false.equals("Y")) { %>
						<td class=label>&nbsp;</td>
						<td class=label>&nbsp;</td>
					
					<% } else { %>
					 
		      <td  width='20%' class='label' ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
			 <td width='30%' class='fields'>
			 <input type='text' size='16' name='start_later_time' id='start_later_time' maxLength='16' onBlur='chkFromToTime2(this);' value=''  ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('start_later_time', null, 'hh:mm' );" style='cursor:pointer'></img></td>

					<% } %>

					<td class='button'><center><input type='button' class='BUTTON' value='<fmt:message key="eDR.StartNow.label" bundle="${dr_labels}"/>' name='start_now' i='start_now' onClick='start_process(this)'; <%=dis_but%>>
					<input type='button' class='BUTTON' value='<fmt:message key="eDR.StartLater.label" bundle="${dr_labels}"/>' name='start_later' id='start_later' onClick='start_process(this);' <%=dis_but%>></td>

				</tr>
				 
			</table>
			<input type=hidden value='' name='process_start' id='process_start'>
			<input type=hidden value='<%=sys_date%>' name='sys_date' id='sys_date'>
			<input type=hidden value='<%=sys_time%>' name='sys_time' id='sys_time' >
			<input type=hidden value='<%=button_false%>' name='button_false' >
			<input type ='hidden' name ='names_in_oth_lang_yn' value='<%=names_in_oth_lang_yn%>'>
			<%
		}
		%>
		<SCRIPT>
			chk_year_month();
			document.getElementById("day_of_birth1").value   = document.getElementById("day_of_birth").value;
			document.getElementById("month_of_birth1").value = document.getElementById("month_of_birth").value;
			document.getElementById("year_of_birth1").value  = document.getElementById("year_of_birth").value;
		</SCRIPT>
		<%
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</form>
</html>

