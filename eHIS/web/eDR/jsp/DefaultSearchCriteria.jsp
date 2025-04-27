<!DOCTYPE html>
<!-- Developed By :  P.Sudhakaran -->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eDR/js/DefaultSearchCriteria.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String locale=(String)session.getAttribute("LOCALE");
	Connection con				= null;
	java.sql.Statement	stmt	= null;
	ResultSet rs				= null;

	String str						= "";
	String name_loc_lang_yn			= "";
	String first_name 				= "";
	String second_name 				= "";
	String third_name 				= "";
	String family_name 				= "";
	String names_sndx_type			= "";
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
	String first_name_reqd_yn		= "";
	String second_name_reqd_yn		= "";
	String third_name_reqd_yn		= "";
	String family_name_reqd_yn		= "";
	String p_sndx_n_selected		= "";
	String p_sndx_g_selected		= "";
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
	String p_other_alt_id_type		= "";
	String selected_val				= "";
	String names_in_oth_lang_yn		= "";
	String alt_id_type				= "";
	String short_desc				= "";
	//String str1						= "";
	String mysql					= "";
	String first_name_avail			= "N";
	String second_name_avail		= "N";	
	String third_name_avail			= "N";
	String family_name_avail		= "N";
	String area_name_avail			= "N"; 
	String short_desc11				= "N";
	String short_desc22				= "N";
	String short_desc33				= "N";
	String short_desc44				= "N";

	StringBuffer mysqlbuff = new StringBuffer();
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		str	= "";
		str = "SELECT * FROM dr_def_search_criteria";
		rs	= stmt.executeQuery(str);
		if(rs!= null && rs.next())
		{
			name_loc_lang_yn	= rs.getString("name_loc_lang_yn");
			first_name 			= rs.getString("first_name_yn");
			short1 				= rs.getString("ALT_ID1_NO_YN");
			short2 				= rs.getString("ALT_ID2_NO_YN");
			short3 				= rs.getString("ALT_ID3_NO_YN");
			short4 				= rs.getString("ALT_ID4_NO_YN");
			second_name 		= rs.getString("second_name_yn");
			third_name 			= rs.getString("third_name_yn");
			family_name 		= rs.getString("family_name_yn");
			names_sndx_type		= rs.getString("names_sndx_type");
			nationality_code	= rs.getString("nationality_code_yn");
			sex 				= rs.getString("sex_yn");
			day_of_birth 		= rs.getString("day_of_birth_yn");
			month_of_birth 		= rs.getString("month_of_birth_yn");
			year_of_birth 		= rs.getString("year_of_birth_yn");
			res_area_code 		= rs.getString("res_area_code_yn");
			contact1_no 		= rs.getString("contact1_no_yn");
			contact2_no			= rs.getString("contact2_no_yn");
			search_type 		= rs.getString("search_type");
			p_other_alt_id_type	= rs.getString("other_alt_id_type") == null?"":rs.getString("other_alt_id_type");
			
			mode 	= "update";
		}
		else
		{
			mode = "insert";
		}

		if(rs!= null) rs.close();		
		if(name_loc_lang_yn != null && name_loc_lang_yn.equals("Y")) {
			name_loc_lang_yn_chk	= "checked";
			disbl					= "disabled";
		}

		if(first_name != null && first_name.equals("Y"))  first_name_chk = "checked";
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

	
		str	= "";	 
		str	= "SELECT first_name_accept_yn, second_name_accept_yn, third_name_accept_yn, family_name_accept_yn, nvl(first_name_prompt,'First Name')first_name_prompt, nvl(second_name_prompt,'Second Name')second_name_prompt,nvl(third_name_prompt,'Third Name')third_name_prompt,nvl(family_name_prompt,'Family Name')family_name_prompt , dflt_sndx_type, first_name_reqd_yn, second_name_reqd_yn, third_name_reqd_yn, family_name_reqd_yn, res_area_prompt, mp_get_desc.mp_alternate_id_type (alt_id1_type,'"+locale+"', 1) short_desc1,mp_get_desc.mp_alternate_id_type (alt_id2_type, '"+locale+"', 1) short_desc2,mp_get_desc.mp_alternate_id_type (alt_id3_type,'"+locale+"', 1) short_desc3,       mp_get_desc.mp_alternate_id_type (alt_id4_type, '"+locale+"', 1) short_desc4, ALT_ID1_TYPE, ALT_ID2_TYPE, ALT_ID3_TYPE, ALT_ID4_TYPE, names_in_oth_lang_yn FROM mp_param_lang_vw a,sm_site_param_lang_vw b  where a.language_id='"+locale+"' and b.language_id='"+locale+"'";
		
		rs	= stmt.executeQuery(str);
		if(rs != null)
		{
			if(rs.next())
			{
				 first_name_init		= rs.getString("first_name_accept_yn");
				 second_name_init		= rs.getString("second_name_accept_yn");
				 third_name_init		= rs.getString("third_name_accept_yn");
				 family_name_init		= rs.getString("family_name_accept_yn");
				 first_name_prompt		= rs.getString("first_name_prompt");
				 second_name_prompt		= rs.getString("second_name_prompt");
				 third_name_prompt		= rs.getString("third_name_prompt");
				 family_name_prompt		= rs.getString("family_name_prompt");
				 dflt_sndx_type			= rs.getString("dflt_sndx_type");
				 area_type				= rs.getString("res_area_prompt");
				 first_name_reqd_yn		= rs.getString("first_name_reqd_yn");
				 second_name_reqd_yn	= rs.getString("second_name_reqd_yn");
				 third_name_reqd_yn		= rs.getString("third_name_reqd_yn");
				 family_name_reqd_yn	= rs.getString("family_name_reqd_yn");
				 alt1					= rs.getString("ALT_ID1_TYPE");
				 alt2					= rs.getString("ALT_ID2_TYPE");
				 alt3					= rs.getString("ALT_ID3_TYPE");
				 alt4					= rs.getString("ALT_ID4_TYPE");
				 names_in_oth_lang_yn	= rs.getString("names_in_oth_lang_yn");
				 short_desc1 = rs.getString("short_desc1") == null?"":rs.getString("short_desc1"); 
				 short_desc2 = rs.getString("short_desc2") == null?"":rs.getString("short_desc2"); 
				 short_desc3 = rs.getString("short_desc3") == null?"":rs.getString("short_desc3"); 
				 short_desc4 = rs.getString("short_desc4") == null?"":rs.getString("short_desc4"); 
			}
		} if(rs!= null) rs.close();

          
		   
		if(dflt_sndx_type == null) dflt_sndx_type="";
		if(first_name_reqd_yn == null) first_name_reqd_yn="N";
		if(second_name_reqd_yn == null) second_name_reqd_yn="N";
		if(third_name_reqd_yn == null) third_name_reqd_yn="N";
		if(family_name_reqd_yn == null) family_name_reqd_yn="N";
		if(names_in_oth_lang_yn == null || names_in_oth_lang_yn.equals("null")) names_in_oth_lang_yn ="";

		//****** added by meghanath on 20/11/2004 ******//

		//mysql = "SELECT alt_id_type,short_desc short_desc FROM mp_alternate_id_type WHERE alt_id_type NOT IN (select alt_id1_type FROM mp_param UNION SELECT NVL(alt_id2_type,1) FROM mp_param UNION SELECT NVL(alt_id3_type,2) FROM mp_param UNION SELECT nvl(alt_id4_type,3) FROM mp_param) AND eff_status='E' order by 2";

		mysql = "SELECT alt_id_type, long_desc  FROM mp_alternate_id_type_LANG_VW WHERE alt_id_type NOT IN (SELECT alt_id1_type FROM mp_param UNION SELECT NVL(alt_id2_type,1) FROM mp_param UNION SELECT NVL(alt_id3_type,2) FROM mp_param UNION SELECT NVL(alt_id4_type,3) FROM mp_param) AND eff_status='E' AND LANGUAGE_ID='"+locale+"' ORDER BY 2";
	
		rs   = stmt.executeQuery(mysql);
		while(rs != null && rs.next())
		{
			alt_id_type	= rs.getString("alt_id_type");
			short_desc  = rs.getString("long_desc");

			if(alt_id_type == null || alt_id_type.equals("null")) alt_id_type = "";
			if(short_desc == null || short_desc.equals("null")) short_desc = "";

			if(alt_id_type.equals(p_other_alt_id_type)) { selected_val = "selected"; }
			else { selected_val = ""; }

			mysqlbuff.append("<option value='"+alt_id_type+"' "+selected_val+">"+short_desc+"</option>");
		} if(rs!= null) rs.close();

		//********************* end of addition ********************// 
%>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
	<form name='DefaultSearchCriteria' id='DefaultSearchCriteria' action='../../servlet/eDR.DefaultSearchCriteriaServlet' method='post' target='messageFrame'>
		<input type=hidden name='short_desc11' id='short_desc11' value='<%=short_desc11%>'>
		<input type=hidden name='short_desc22' id='short_desc22' value='<%=short_desc22%>'>
		<input type=hidden name='short_desc33' id='short_desc33' value='<%=short_desc33%>'>
		<input type=hidden name='short_desc44' id='short_desc44' value='<%=short_desc44%>'>
		<input type=hidden name='first_name_prompt' id='first_name_prompt' value='<%=first_name_prompt%>'>
		<input type=hidden name='second_name_prompt' id='second_name_prompt' value='<%=second_name_prompt%>'>
		<input type=hidden name='third_name_prompt' id='third_name_prompt' value='<%=third_name_prompt%>'>
		<input type=hidden name='family_name_prompt' id='family_name_prompt' value='<%=family_name_prompt%>'>
		<input type=hidden name='first_name_init' id='first_name_init' value='<%=first_name_init%>'>
		<input type=hidden name='second_name_init' id='second_name_init' value='<%=second_name_init%>'>
		<input type=hidden name='third_name_init' id='third_name_init' value='<%=third_name_init%>'>
		<input type=hidden name='family_name_init' id='family_name_init' value='<%=family_name_init%>'>
		<input type=hidden name='first_name_avail' id='first_name_avail' value='<%=first_name_avail%>'>
		<input type=hidden name='second_name_avail' id='second_name_avail' value='<%=second_name_avail%>'>
		<input type=hidden name='third_name_avail' id='third_name_avail' value='<%=third_name_avail%>'>
		<input type=hidden name='family_name_avail' id='family_name_avail' value='<%=family_name_avail%>'>
		<input type=hidden name='area_name_avail' id='area_name_avail' value='<%=area_name_avail%>'>
		<input type ='hidden' name ='first_name_reqd_yn' value='<%=first_name_reqd_yn%>'>
		<input type ='hidden' name ='second_name_reqd_yn' value='<%=second_name_reqd_yn%>'>
		<input type ='hidden' name ='third_name_reqd_yn' value='<%=third_name_reqd_yn%>'>
		<input type ='hidden' name ='family_name_reqd_yn' value='<%=family_name_reqd_yn%>'>

		<br><br><br>

<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>					
		<tr><th class='columnheader' style="text-align:left; color: white;"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th></tr>		
</table>
<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>	
		<tr><td colspan='4'>&nbsp;</td></tr>
		<tr>
				<% if(names_in_oth_lang_yn.equals("Y")) { %>
					
			<td class='label' width='25%'><fmt:message key="eDR.NameinLocalLanguage.label" bundle="${dr_labels}"/></td>
					
			<td class='fields' width='25%'><input type='checkbox' name='name_loc_lang_yn' id='name_loc_lang_yn'  value="Y"  <%=name_loc_lang_yn_chk%> onClick="disable_soundex()"></td>
				
				<% } else { %>
				
			<td class='label' width ='50%' colspan='2'>&nbsp;</td>			
				
				<% } %>
				
			<td class='label' width='25%'><fmt:message key="eDR.SoundexAlgorithm.label" bundle="${dr_labels}"/></td>
				
				<% 
				if(names_sndx_type.equals("G")) 
				{
					p_sndx_n_selected = "";
					p_sndx_g_selected = "selected";
					
				}
				else if(names_sndx_type.equals("E"))
				{
					p_sndx_n_selected = "";
					p_sndx_g_selected = "";
					
				}
				else 
				{
					p_sndx_n_selected = "selected";
					p_sndx_g_selected = "";

				}
				if(dflt_sndx_type.equals("G"))
				{
					%>	
					
					<td class='fields' width='25%' ><select name='names_sndx_type' id='names_sndx_type' <%=disbl%>>
						<option value='N' <%=p_sndx_n_selected%>><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
						<option value='G' <%=p_sndx_g_selected%>><fmt:message key="Common.generic.label" bundle="${common_labels}"/></option>	
					</td>
					<%
					}
					else
					{
					%>	
					<td class='fields' width='25%' ><select name='names_sndx_type' id='names_sndx_type' <%=disbl%>>
						<option value='N' <%=p_sndx_n_selected%>><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
					</td>
					<%
					}
					%>	
		</tr>
			
		<tr>
				<%	
				if(first_name_prompt != null && !(first_name_prompt.equals("")) && first_name_init != null && first_name_init.equals("Y"))
				{
					%>
					<script>
						document.forms[0].first_name_avail.value='Y';
					</script>
					<%
				}
				if(first_name_prompt != null && !(first_name_prompt.equals("")) && first_name_init != null && first_name_init.equals("Y"))
				{
					%>
			<td class='label'  ><%=first_name_prompt%></td>
			<td class='Fields'  >
				<input type='checkbox' name='first_name' id='first_name' value="<%=first_name%>"  <%=first_name_chk%>></td>
				<td colspan='2' class='label'>&nbsp;</td>
					<%
				}
				else
				{
					%>
				<input type='hidden' name='first_name' id='first_name' value="N">
			<td class='label' colspan='4'>&nbsp;</td>			
					<%
				}
				%>
			</tr>
			<tr>
				<%
				if(second_name_prompt != null && !(second_name_prompt.equals("")) && second_name_init != null && second_name_init.equals("Y"))
				{
					%>
					<script>
						document.forms[0].second_name_avail.value='Y';
					</script>
					<%
				}
				if(second_name_prompt != null && !(second_name_prompt.equals("")) && second_name_init != null && second_name_init.equals("Y"))
				{
					%>
				<td class='label'  ><%=second_name_prompt%></td>
				<td class='fields' ><input type='checkbox' name='second_name' id='second_name'  value="<%=second_name%>" 		<%=second_name_chk%> >
					<%
				}
				else
				{
					%>
					<input type='hidden' name='second_name' id='second_name' value="N">
					<td colspan='2' class='label'>&nbsp;</td>
					<%
				}
				if(alt1 != null)
				{
					%>
					<script>
						document.forms[0].short_desc11.value = 'Y';
					</script>
					<% 
					}
				if(!short_desc1.equals("") && (short_desc1 != null))
				{
					%>
				<td class='label'  ><%=short_desc1%></td>
				<td class='fields' ><input type='checkbox' name='short_desc1' id='short_desc1'  value="Y"  <%=short1%> ></td>
					<% 
				}
				else
				{
					%>
				<td colspan='2' class='label'>&nbsp;</td>
					<%
				}
				%>
			</tr>
			<tr>
				<%
				if(third_name_prompt != null && !(third_name_prompt.equals("")) && third_name_init != null && third_name_init.equals("Y"))
				{
					%>	
					<script>
						document.forms[0].third_name_avail.value = 'Y';
					</script>
					<%
				}
				if(third_name_prompt != null && !(third_name_prompt.equals("")) && third_name_init != null && third_name_init.equals("Y"))
				{
					%>
				<td class='label' ><%=third_name_prompt%></td>
				<td class='fields' ><input type='checkbox' name='third_name' id='third_name'  value="<%=third_name%>"  <%=third_name_chk%> ></td>
					<%
				}
				else
				{
					%>
					<input type='hidden' name='third_name' id='third_name' value="N">
				<td colspan='2' class='label'>&nbsp;</td>
					<%
				}
				if(alt2 != null)
				{
					%>
					<script>
						document.forms[0].short_desc22.value='Y';
					</script>
					<% 
				}
				if(!short_desc2.equals("") &&  short_desc2!=null)
				{
					%>
				<td  class='label' ><%=short_desc2%></td>
				<td  class='fields' ><input type='checkbox' name='short_desc2' id='short_desc2'  value="Y"  <%=short2%> ></td>
					<%
				}
				else
				{ 
					%>
				<td colspan='2' class='label'>&nbsp;</td>
					<% 
				} 
				%>
			</tr>
			<tr>
				 
				<%	
				if(alt3 != null)
				{
					%>
					<script>
						document.forms[0].short_desc33.value='Y';
					</script>
					<% 
				}
				if(!short_desc3.equals("") && short_desc3!=null)
				{
					%>
				<td class='label' ><%=short_desc3%></td>
				<td class='fields'  ><input type='checkbox' name='short_desc3' id='short_desc3'  value="Y"  <%=short3%> ></td>
					<%
				}
				else
				{
					%>
				<td colspan='2' class='label'>&nbsp;</td>
					<% 
				}
				
				if(alt4 != null)
				{
					%>
					<script>
						document.forms[0].short_desc44.value='Y';
					</script>
					<%
				}
				if(!short_desc4.equals("") && short_desc4!=null)
				{
					%>
				<td  class='label'><%=short_desc4%></td>
				<td  class='fields'><input type='checkbox' name='short_desc4' id='short_desc4'  value="Y"  <%=short4%> ></td> 
					<%
				}
				else
				{
					%>
				<td colspan='2' class='label'>&nbsp;</td>
					<%
				}
				%>
			</tr>
			<tr>
				<%
				if(family_name_prompt != null && !(family_name_prompt.equals("")) && family_name_init != null && family_name_init.equals("Y"))
				{
					%>	
					<script>
						document.forms[0].family_name_avail.value = 'Y';
						
					</script>	
					<%
				}				 
				if(family_name_prompt != null && !(family_name_prompt.equals("")) && family_name_init != null && family_name_init.equals("Y"))
				{	
					%>
				<td class='label'><%=family_name_prompt%></td>
				<td class='fields'><input type='checkbox' name='family_name' id='family_name' value="<%=family_name%>"  <%=family_name_chk%>></td>
					<%
				}
				else
				{
					%>					
					<td colspan='2'><input type='hidden' name='family_name' id='family_name' value="N"></td>
					<%
				}
				%>
			<td class='label' ><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='other_alt_id_type' id='other_alt_id_type'>
				<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><%=mysqlbuff.toString()%></select><td>
			</tr>
			<tr><td colspan='4'>&nbsp;</td></tr>
</table>
			
<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>		
							
			<tr><th class='columnheader' style="text-align:left; color: white;"><fmt:message key="eDR.DemographicData.label" bundle="${dr_labels}"/></th></tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>		
			<tr><td colspan='4'>&nbsp;</td></tr>	
			<tr>
				<td class='label' width='25%'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><input type='checkbox' name='nationality_code' id='nationality_code'  value="Y"  <%=nationality_code_chk%> ></td>
				<td colspan='2'></td>
			</tr>			
			<tr>
				<td class='label'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='checkbox' name='sex' id='sex'  value="Y" <%=sex_chk%> >
				<td colspan='2'></TD>
			</TR>			
</table>
<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>				
			<TR>
				<TD class='label' width='145pts'><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></td>
				<td class='label' width='56pts'><fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
				<td class='fields' width='5%'><input type='checkbox' name='year_of_birth' id='year_of_birth'  value='Y' <%=year_of_birth_chk%> >
				</td>
				<td class='label' width='126pts'><fmt:message key="Common.month.label" bundle="${common_labels}"/></td>
				<td class='fields'  width='5%'><input type='checkbox' name='month_of_birth' id='month_of_birth'   value='Y' <%=month_of_birth_chk%> onClick="chk_month(this)" >
				</td>
				<td class='label' width='215pts'><fmt:message key="Common.day.label" bundle="${common_labels}"/>
				<td class='fields'><input type='checkbox' name='day_of_birth' id='day_of_birth'  value='Y' <%=day_of_birth_chk%> onClick="chk_year(this)">
				</td>
			</TR>			
</table>
<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>		
		
			<% 
			if(area_type != null)
			{
				%>
				<TR>
					<SCRIPT>
						document.forms[0].area_name_avail.value = 'Y';
					</SCRIPT>
					<TD class='label' width='25%'><%=area_type%></TD>
					<TD class='fields' width='25%'><INPUT type='checkbox' name='res_area_code' id='res_area_code' value="Y"  <%=res_area_code_chk%>></TD>
					<td colspan='2'></TD>
				</tr>
				<%
			}
			%>
			
			<TR>
				<TD class='label' width='25%'><fmt:message key="eDR.ResTelNo.label" bundle="${dr_labels}"/></TD>
				<TD class='fields' width='25%'><INPUT type='checkbox' name='contact1_no' id='contact1_no'  value="Y"  <%=contact1_no_chk%> >
				</TD>	
				<TD class='label' width='25%'><fmt:message key="eDR.OtherContactNo.label" bundle="${dr_labels}"/></TD>
				<TD class='fields' width='25%'><INPUT type='checkbox' name='contact2_no' id='contact2_no'  value="Y"  valign='center' <%=contact2_no_chk%>>
				</TD>				
			</TR>	
			<tr><td colspan='4'>&nbsp;</td></tr>
		
</TABLE>

<TABLE border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>
			
		<TR><TH class='columnheader' style="text-align:left; color: white;"><fmt:message key="eDR.ScopeofSearch.label" bundle="${dr_labels}"/></TH></TR>
</table>
<TABLE border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>	
		<tr><td colspan='4'>&nbsp;</td></tr>
		<TR>
				<TD class='label' width='25%'><fmt:message key="eDR.SearchType.label" bundle="${dr_labels}"/></td>	
				<TD class='fields' colspan='3'><SELECT name='search_type' id='search_type'>
				<OPTION value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
				<OPTION value='L' selected ><fmt:message key="Common.LoggedinFacility.label" bundle="${common_labels}"/></OPTION><INPUT type='hidden' name='mode' id='mode' value='<%=mode%>'></td>			
		</TR>	
		<tr><td colspan='4'>&nbsp;</td></tr>			
</TABLE>
		
			<SCRIPT>
			<%
			if(!search_type.equals("")) 
			{ 
				%>
				document.forms[0].search_type.value='<%=search_type%>';
				<%
			} 
			%>
			chk_year_month();
		</SCRIPT>

		<input type ='hidden' name ='day_of_birth1' value=''>
		<input type ='hidden' name ='month_of_birth1' value=''>
		<input type ='hidden' name ='year_of_birth1' value=''>
		<input type ='hidden' name ='names_in_oth_lang_yn' value='<%=names_in_oth_lang_yn%>'>
		
		<SCRIPT>
			document.forms[0].day_of_birth1.value   = document.forms[0].day_of_birth.value;
			document.forms[0].month_of_birth1.value = document.forms[0].month_of_birth.value;
			document.forms[0].year_of_birth1.value  = document.forms[0].year_of_birth.value;
		</SCRIPT>
	</form>
	<%
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception in DefaultSearchCriteria :"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
</body>
</html>

