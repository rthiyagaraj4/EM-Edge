<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
	Developed on   	   :  22/02/2002
	ReDeveloped on	   :  22/02/2002
	Module Name 	   :  eHIS/eDR
	Function Name	   :  
	Function ID        :  
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*" %>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<script language='javascript' src='../../eDR/js/MergeDuplicatePatient.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<!-- <script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	<script>
	function EnbDsbChkbox()
	{
		if(document.getElementById('other_alt_id_type').value == '')
		{
			document.getElementById('other_alt_id_chk').checked = '';
			document.getElementById('other_alt_id_chk').disabled = true;
		}
		else
		{
			document.getElementById('other_alt_id_chk').disabled = false;
			document.getElementById('other_alt_id_chk').checked = '';
		}
	}
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown ="lockKey()">
<%
	Connection con				= null;
	java.sql.Statement stmt	= null;
	ResultSet rs				= null;

	
	String str							= "";
	String first_name 					= "";
	String second_name 					= "";
	String third_name 					= "";
	String family_name 					= "";
	String nationality_code				= "";
	String sex 							= "";
	String res_area_code 				= "";
	String contact1_no 					= "";
	String contact2_no					= "";
	String first_name_init				= "";  
	String second_name_init				= "";
	String third_name_init				= "";
	String family_name_init				= "";
	String first_name_prompt			= "";	
	String second_name_prompt			= "";	
	String third_name_prompt			= "";	
	String family_name_prompt			= "";
	String dflt_sndx_type				= "";
	String area_type					= "";
	String name_in_loc_lang				= "";
	String hit_limit					= "";
	String date_of_birth				= "";
	String generic_sndx_first			= "";	           
	String generic_sndx_second			= "";	           
	String generic_sndx_third			= "";	           
	String generic_sndx_family			= "";	           
	String generic_sndx_first_second	= "";	     
	String generic_sndx_first_family	= "";	      
	String ethnic_sndx_first			= "";	              
	String ethnic_sndx_second			= "";	            
	String ethnic_sndx_third			= "";	             
	String ethnic_sndx_family			= "";	            
	String ethnic_sndx_first_second		= "";	       
	String ethnic_sndx_first_family		= "";
	String first_name_loc_lang			= "";
	String second_name_loc_lang			= "";
	String third_name_loc_lang			= "";
	String family_name_loc_lang			= "";
	String check_dr_param	= "";
	String check_user_rights	= "";
	String sel_gen						= "";
	String deceased_yn					= "";
	String search_all					= "";
	String nationality_desc				= "";
	String res_area_desc				= "";
	String gender						= "";
	String names_in_oth_lang_yn			= "";
	String alt_id_type					= "";
	String short_desc					= "";
	String mysql						= "";
	String select_value					= "";
	String first_name_avail				= "N";
	String second_name_avail			= "N";	
	String third_name_avail				= "N";
	String family_name_avail			= "N";
	String area_name_avail				= "N"; 
	String record_avail					= "N";
    String locale=(String)session.getAttribute("LOCALE");
	Properties p		= (Properties) session.getValue("jdbc");
	String addedById	= p.getProperty("login_user");
	StringBuffer mysqlbuff = new StringBuffer();

	String patient_id		= request.getParameter("patient_id");

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		
		str="";
		str="SELECT first_name_accept_yn, second_name_accept_yn, third_name_accept_yn, family_name_accept_yn, NVL(first_name_prompt,'First Name') first_name_prompt,NVL(second_name_prompt,'Second Name') second_name_prompt ,NVL(third_name_prompt,'Third Name') third_name_prompt , NVL(family_name_prompt,'Family Name') family_name_prompt , dflt_sndx_type, res_area_prompt,search_threshold_records, names_in_oth_lang_yn FROM mp_param_lang_vw a, sm_site_param_lang_vw b WHERE a.language_id = '"+locale+"' AND b.language_id = '"+locale+"'";
		
		rs	    =stmt.executeQuery(str);
		if(rs!=null)
		{
			if(rs.next())
			{

				first_name_init			=rs.getString("first_name_accept_yn");
				second_name_init		=rs.getString("second_name_accept_yn");
				third_name_init			=rs.getString("third_name_accept_yn");
				family_name_init		=rs.getString("family_name_accept_yn");
				first_name_prompt		=rs.getString("first_name_prompt");
				second_name_prompt		=rs.getString("second_name_prompt");
				third_name_prompt		=rs.getString("third_name_prompt");
				family_name_prompt		=rs.getString("family_name_prompt");
				dflt_sndx_type			=rs.getString("dflt_sndx_type");
				area_type				=rs.getString("res_area_prompt");
				hit_limit				=rs.getString("search_threshold_records");	 	
				names_in_oth_lang_yn	=rs.getString("names_in_oth_lang_yn");

				
			}
		
			if(dflt_sndx_type !=null && dflt_sndx_type.equals("G")) sel_gen="selected";
			if(names_in_oth_lang_yn == null || names_in_oth_lang_yn.equals("null")) 						names_in_oth_lang_yn="";

		} if(rs != null) rs.close();

		if(hit_limit==null) hit_limit="";
		
		String str_mp="";
		
		str_mp=	"SELECT  a.*, a.sex gender, TO_CHAR(a.date_of_birth, 'dd/mm/yyyy')date_of_birth_for, mp_get_desc.MP_RES_AREA(a.res_area_code,'"+locale+"',1) res_area_desc, mp_get_desc.MP_Country(a.nationality_code,'"+locale+"',3) nationality_desc FROM mp_patient a WHERE  patient_id = '"+patient_id+"'";
		
		//str_mp="SELECT a.*, decode(a.sex,'F','Female','M','Male','Unknown') gender, to_char(a.date_of_birth,'dd/mm/yyyy')date_of_birth_for, res.short_desc res_area_desc, cntry.long_desc nationality_desc FROM mp_patient a, mp_country cntry, mp_res_area res WHERE patient_id = '"+patient_id+"' AND a.res_area_code = res.res_area_code(+) AND a.nationality_code = cntry.country_code(+)";

		rs	= stmt.executeQuery(str_mp);
		if(rs != null)
		{
			if(rs.next())
			{
				record_avail="Y";

				first_name					= rs.getString("first_name");
				second_name					= rs.getString("second_name");
				third_name					= rs.getString("third_name");
				family_name					= rs.getString("family_name");
				nationality_code			= rs.getString("nationality_code");
				sex							= rs.getString("sex");
				gender						= rs.getString("gender");

			if(gender.equals("M"))					gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(gender.equals("F"))						  							gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else if(gender.equals("U"))						  							gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

				date_of_birth				= rs.getString("date_of_birth_for");
				date_of_birth=DateUtils.convertDate(date_of_birth,"DMY","en",locale);
				contact1_no					= rs.getString("contact1_no");
				res_area_code				= rs.getString("res_area_code");
				contact2_no					= rs.getString("contact2_no");
				name_in_loc_lang			= rs.getString("patient_name_loc_lang");
				generic_sndx_first			= rs.getString("generic_sndx_first");	 
				generic_sndx_second			= rs.getString("generic_sndx_second");
				generic_sndx_third			= rs.getString("generic_sndx_third");	 
				generic_sndx_family			= rs.getString("generic_sndx_family");
				generic_sndx_first_second	= rs.getString("generic_sndx_first_second");
				generic_sndx_first_family	= rs.getString("generic_sndx_first_family");
				ethnic_sndx_first			= rs.getString("ethnic_sndx_first");
				ethnic_sndx_second			= rs.getString("ethnic_sndx_second");
				ethnic_sndx_third			= rs.getString("ethnic_sndx_third");
				ethnic_sndx_family			= rs.getString("ethnic_sndx_family");
				ethnic_sndx_first_second	= rs.getString("ethnic_sndx_first_second");
				ethnic_sndx_first_family	= rs.getString("ethnic_sndx_first_family");
				first_name_loc_lang			= rs.getString("first_name_loc_lang");
				second_name_loc_lang		= rs.getString("second_name_loc_lang");
				third_name_loc_lang			= rs.getString("third_name_loc_lang");
				family_name_loc_lang		= rs.getString("family_name_loc_lang");
				deceased_yn					= rs.getString("deceased_yn");
				nationality_desc			= rs.getString("nationality_desc");
				res_area_desc				= rs.getString("res_area_desc");

				if(nationality_desc==null) nationality_desc = "";
				if(res_area_desc==null) res_area_desc = "";
			}
		} if(rs != null) rs.close();
		
		if(name_in_loc_lang ==null) name_in_loc_lang="";
		if(first_name ==null) first_name="";
		if(second_name ==null) second_name="";
		if(third_name ==null) third_name="";
		if(family_name ==null) family_name="";
		if(nationality_code ==null) nationality_code="";
		if(sex ==null) sex="";
		if(date_of_birth ==null) date_of_birth="";
		if(contact1_no ==null) contact1_no="";
		if(res_area_code ==null) res_area_code="";
		if(contact2_no ==null) contact2_no="";
		if(name_in_loc_lang ==null) name_in_loc_lang="";
		if(generic_sndx_first ==null) generic_sndx_first="";
		if(generic_sndx_second ==null) generic_sndx_second="";
		if(generic_sndx_third ==null) generic_sndx_third="";
		if(generic_sndx_family ==null) generic_sndx_family="";
		if(generic_sndx_first_second ==null) generic_sndx_first_second="";
		if(generic_sndx_first_family ==null) generic_sndx_first_family="";
		if(ethnic_sndx_first ==null) ethnic_sndx_first="";
		if(ethnic_sndx_second ==null) ethnic_sndx_second="";
		if(ethnic_sndx_third ==null) ethnic_sndx_third="";
		if(ethnic_sndx_family ==null) ethnic_sndx_family="";
		if(ethnic_sndx_first_second ==null) ethnic_sndx_first_second="";
		if(ethnic_sndx_first_family ==null) ethnic_sndx_first_family="";
		if(first_name_loc_lang ==null) first_name_loc_lang="";
		if(second_name_loc_lang ==null) second_name_loc_lang="";
		if(third_name_loc_lang ==null) third_name_loc_lang="";
		if(family_name_loc_lang ==null) family_name_loc_lang="";

		String str_dr = "SELECT search_across_facility_yn FROM dr_param"; 	
	
		rs = stmt.executeQuery(str_dr);
		if(rs!=null)
		{
			if(rs.next())
			{
				check_dr_param = rs.getString("search_across_facility_yn")==null?"":rs.getString("search_across_facility_yn");				 			
			} 
		} if(rs != null) rs.close();
	
		String str_user_rights = "SELECT search_privilege_level FROM dr_user_rights WHERE appl_user_id = '"+addedById+"' "; 
		
		rs = stmt.executeQuery(str_user_rights);
		if(rs!=null)
		{
			if(rs.next())
			{
				check_user_rights = rs.getString("search_privilege_level")==null?"":rs.getString("search_privilege_level"); 							
			} 
		} if(rs != null) rs.close(); 
		
		if(check_dr_param.equals("Y") && check_user_rights.equals("A"))
		{
			search_all="checked";
			%>
			<script>
				errors = getMessage("SEARCH_ALL_FACILITY","DR");
				parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			</script>
			<%
		}
		
		if(record_avail.equals("N"))
		{
			if(patient_id.equals("")){%>
				<script>
				errors = getMessage("SHD_NOT_BE_BLANK","DR");
		parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			</script>
				<%} else {%>
			<script>
				errors = getMessage("NO_RECORD","DR");
				parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			</script>
			<%}
		}
		else
		{
			if(deceased_yn !=null && deceased_yn.equals("Y")){
			%>
			<script>
				errors = getMessage("DECEASED_PATIENT","DR");
				parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			</script>
			<%
		}
		else
		{ 
			%>
			<form name='Search_criteria_form' id='Search_criteria_form' action='../../servlet/eDR.MergeDuplicateForPatientServlet' method='post' target='messageFrame'>
			<input type='hidden' name='first_name_avail' id='first_name_avail' value='<%=first_name_avail%>'>
			<input type='hidden' name='second_name_avail' id='second_name_avail' value='<%=second_name_avail%>'>
			<input type='hidden' name='third_name_avail' id='third_name_avail' value='<%=third_name_avail%>'>
			<input type='hidden' name='family_name_avail' id='family_name_avail' value='<%=family_name_avail%>'>
			<input type='hidden' name='area_name_avail' id='area_name_avail' value='<%=area_name_avail%>'>
			<input type='hidden' name='generic_sndx_first' id='generic_sndx_first' value='<%=generic_sndx_first%>'>
			<input type='hidden' name='generic_sndx_second' id='generic_sndx_second' value='<%=generic_sndx_second%>'>
			<input type='hidden' name='generic_sndx_third' id='generic_sndx_third' value='<%=generic_sndx_third%>'>
			<input type='hidden' name='generic_sndx_family' id='generic_sndx_family' value='<%=generic_sndx_family%>'>
			<input type='hidden' name='generic_sndx_first_second' id='generic_sndx_first_second' value='<%=generic_sndx_first_second%>'>
			<input type='hidden' name='generic_sndx_first_family' id='generic_sndx_first_family' value='<%=generic_sndx_first_family%>'>
			<input type='hidden' name='ethnic_sndx_first' id='ethnic_sndx_first' value='<%=ethnic_sndx_first%>'>
			<input type='hidden' name='ethnic_sndx_second' id='ethnic_sndx_second' value='<%=ethnic_sndx_second%>'>
			<input type='hidden' name='ethnic_sndx_third' id='ethnic_sndx_third' value='<%=ethnic_sndx_third%>'>
			<input type='hidden' name='ethnic_sndx_family' id='ethnic_sndx_family' value='<%=ethnic_sndx_family%>'>
			<input type='hidden' name='ethnic_sndx_first_second' id='ethnic_sndx_first_second' value='<%=ethnic_sndx_first_second%>'>
			<input type='hidden' name='ethnic_sndx_first_family' id='ethnic_sndx_first_family' value='<%=ethnic_sndx_first_family%>'>
			<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' value='<%=first_name_loc_lang%>'>
			<input type='hidden' name='second_name_loc_lang' id='second_name_loc_lang' value='<%=second_name_loc_lang%>'>
			<input type='hidden' name='third_name_loc_lang' id='third_name_loc_lang' value='<%=third_name_loc_lang%>'>
			<input type='hidden' name='family_name_loc_lang' id='family_name_loc_lang' value='<%=family_name_loc_lang%>'>
			<input type='hidden' name='all_facil' id='all_facil' value=''>

			
	<table border='0' cellpadding='0' cellspacing='0' width='100%' >
					
		<tr><th class='columnheader' colspan='4' style="text-align:left;"><fmt:message key="eDR.DuplicateSearchCriteria.label" bundle="${dr_labels}"/></th></tr>
		<tr><td class='label' colspan='4'>&nbsp;</td></tr>
	</table>

	<table border='0' cellpadding='1' cellspacing='0' width='100%' >				
		<tr>
			
				<%if(names_in_oth_lang_yn.equals("Y")){%>
						
			<td  width='25%' class='label' nowrap ><fmt:message key="eDR.NameinLocalLanguage.label" bundle="${dr_labels}"/></td>
						
			<td class='fields' width='25%'><input type='checkbox' name='name_loc_lang_yn' id='name_loc_lang_yn'  value='' align='left' onClick="disable_soundex()"></td>
						
					<%}else{%>
				
			<td class='label' colspan='2' width='50%'>&nbsp;</td>
						
					<%}%>
					
			<td  width='25%' class='label' nowrap ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
						
			<td class='fields' width='25%'><input type='text' name='nationality_desc' id='nationality_desc' size='20' value='<%=nationality_desc%>' readonly><input type='hidden' name='nationality' id='nationality' value='<%=nationality_code%>'>
			<input type='checkbox' name='nationality_chk' id='nationality_chk'  disabled checked value='' align='left' ></td>	
		</tr>
				
		<tr>
					
					<%	if(first_name_prompt != null && !(first_name_prompt.equals("")) && first_name_init != null && first_name_init.equals("Y"))
					{
							%>
							
					<script>
							document.getElementById('first_name_avail').value='Y';
					</script>
							
					<td  width='25%'  class='label'  nowrap  ><%=first_name_prompt%></td>
						
					<td class='fields' width='25%'><input type='text' name='first_name' id='first_name' size='20' maxlength='20' value='<%=first_name%>' readonly><input type='checkbox' name='first_name_chk' id='first_name_chk'  value=''></td>
							
							<%}else{%>
						
					<td colspan='2' width='50%'></td>
						<%
							}
					
						%>
							
					<%	if(second_name_prompt != null && !(second_name_prompt.equals("")) && second_name_init != null && second_name_init.equals("Y"))
							{
						%>	
							<script>
							document.getElementById('second_name_avail').value='Y';
							</script>
				
					<td  width='25%'   class='label'  nowrap ><%=second_name_prompt%></td>
						
					<td class='fields' width='25%'><input type='text' name='second_name' id='second_name' size='20' maxlength='20' value='<%=second_name%>' readonly><input type='checkbox' name='second_name_chk' id='second_name_chk' value='' ></td>
						
							<%}else{%>
					<td class='label' colspan='2' width='50%'></td>
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
					           document.getElementById('third_name_avail').value='Y';
							</script>
							
						<td  width='25%' class='label'  nowrap ><%=third_name_prompt%></td>
							
						<td class='fields' width='25%'><input type='text' name='third_name' id='third_name' size='20' maxlength='20' value='<%=third_name%>' readonly ><input type='checkbox' name='third_name_chk' id='third_name_chk'  value='' align='left' ></td>
					
						<%} else { %>
								<td class='label' colspan='2' width='50%'></td>							
						<%  } 

						
							

						if(family_name_prompt != null && !(family_name_prompt.equals("")) && family_name_init != null && family_name_init.equals("Y"))
							{
								%>
								<script>
									document.getElementById('family_name_avail').value='Y';
								</script>
							
							<td  width='25%'   class='label'  nowrap ><%=family_name_prompt%></td>								
							<td class='fields' width='25%'><input type='text' name='family_name' id='family_name' size='20' maxlength='20' value='<%=family_name%>' readonly><input type='checkbox' name='family_name_chk' id='family_name_chk'  value='' align='left' ></td>
							
								<%}else{ %>
								
							<td colspan='2' width='50%'></td>

							<%
							}
							%>

			</tr>
			<tr>						
					<td  width='25%' class='label' nowrap ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
						
					<td  class='fields' width='25%'><input type='text' name='gender' id='gender' size='20' value='<%=gender%>' readonly><input type='hidden' name='sex' id='sex' value='<%=sex%>'><input type='checkbox' name='sex_chk' id='sex_chk'  value='' align='left' ></td>		
					
					<%
					if(check_dr_param.equals("Y") && check_user_rights.equals("A")) {
					%>
					<script>
						document.getElementById('all_facil').value='Y';
					</script>
							
					<td  width='25%' class='label' nowrap ><fmt:message key="eDR.SearchinallFacilities.label" bundle="${dr_labels}"/></td>
							
					<td  width='25%'><input type='checkbox' name='search_all_chk' id='search_all_chk'  value='' align='left' <%=search_all%> ></td>

					<%
					} else {
					%>
						<td colspan='2' width='50%'><input type=hidden name='' id='' value=''></td>
					<%}%>
			</tr>
			
			<tr>							
					<td  width='25%'  class='label'  nowrap><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></td>
							
					<td class='fields' width='25%'><input type='text' name='dob' id='dob' size='20' maxlength='10' value='<%=date_of_birth%>' readonly ><input type='checkbox' name='dob_chk' id='dob_chk'  value='' align='left' onclick="active_by();"></td>
							
					<td  width='25%'  class='label' nowrap ><fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
							
					<td class='fields' width="25%"><Select name="by_date" id="by_date" disabled>						
					<Option value="Y" Selected><fmt:message key="Common.year.label" bundle="${common_labels}"/>
					<Option value="MY"><fmt:message key="Common.month.label" bundle="${common_labels}"/>& <fmt:message key="Common.year.label" bundle="${common_labels}"/>
					<Option value="D"><fmt:message key="Common.date.label" bundle="${common_labels}"/></Select>
					</td>
			</tr>
						
			<tr>
						 <%
							String contact1_no_prompt = "";
							String contact2_no_prompt = "";

							String csql = "SELECT short_desc,contact_mode FROM mp_contact_mode_lang_vw WHERE contact_mode IN ('PRN','ORN') AND EFF_STATUS ='E' and language_id='"+locale+"' ORDER BY contact_mode desc";
							rs = stmt.executeQuery(csql);
							if (rs.next())
							{
								contact1_no_prompt = rs.getString(1);
							}
							%>
							<td  width='25%' class='label' nowrap><%=contact1_no_prompt%></td>
							<td class='fields' width='25%'><input type='text' name='contact1_no' id='contact1_no' size='20' maxlength='18' value='<%=contact1_no%>' readonly><input type='checkbox' name='contact1_no_chk' id='contact1_no_chk'  value=''></td>
							<%
							if (rs.next())
							{
								contact2_no_prompt = rs.getString(1);
							} if(rs != null) rs.close();
							%>
							
							<td  width='25%' class='label' nowrap><%=contact2_no_prompt%></td>
							
							<td class='fields' width='25%'><input type='text' name='contact2_no' id='contact2_no' size='20' maxlength='18' value='<%=contact2_no%>' readonly><input type='checkbox' name='contact2_no_chk' id='contact2_no_chk' value=''></td>
				</tr>
						
				<tr>
							
							<% if(area_type != null && !(area_type.equals(""))) { %>
								<script>
									document.forms[0].area_name_avail.value='Y';
								</script>
									
							<td  width='25%' class='label'  nowrap><%=area_type%></td>
									
							<td class='fields' width='25%'><input type='text' name='area_type_desc' id='area_type_desc' size='20' value='<%=res_area_desc%>' readonly><input type='hidden' name='area_type' id='area_type' value='<%=res_area_code%>'><input type='checkbox' name='area_chk' id='area_chk'  value='' align='left'></td>
							<%
								}else{
							%>
							<td class='label' colspan='2' width='50%'></td>
							<%
								}
							%>
								
							<td  width='25%' class='label' nowrap><fmt:message key="Common.soundex.label" bundle="${common_labels}"/></td>
								
							<td  class='fields' width='25%'><Select name="names_sndx_type" id="names_sndx_type">
								<Option value="N" selected ><fmt:message key="Common.none.label" bundle="${common_labels}"/>
							
							<%	if(dflt_sndx_type !=null && dflt_sndx_type.equals("E")) { %>	
									
								<Option value="E"  ><fmt:message key="Common.Ethnic.label" bundle="${common_labels}"/>
							<% } else if(dflt_sndx_type !=null && dflt_sndx_type.equals("G")) { %>
									
								<Option value="G" <%=sel_gen%> ><fmt:message key="Common.generic.label" bundle="${common_labels}"/>
							<% } %>
							</Select>
							</td>
				</tr>
						
				<tr>
							<%
							//****** abbed by meghanath on 24/11/2004 ******//
							mysql = "SELECT alt_id_type,long_desc  FROM mp_alternate_id_type_lang_vw WHERE alt_id_type NOT IN (select alt_id1_type FROM mp_param UNION SELECT NVL(alt_id2_type,1) FROM mp_param UNION SELECT NVL(alt_id3_type,2) FROM mp_param UNION SELECT nvl(alt_id4_type,3) FROM mp_param) and language_id='"+locale+"' AND eff_status='E' order by 2";
							
							rs   = stmt.executeQuery(mysql);
							while(rs != null && rs.next())
							{
								alt_id_type = rs.getString("alt_id_type");
								short_desc = rs.getString("long_desc");
								if(alt_id_type == null || alt_id_type.equals("null")) alt_id_type = "";
								if(short_desc == null || short_desc.equals("null")) short_desc = "";
								
								mysqlbuff.append("<option value='"+alt_id_type+"' "+select_value+">"+short_desc+"</option>");
							} if(rs != null) rs.close();
							%>
						<td class='label' width='25%' ><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></td>
							
						<td class='fields' width='25%'><select name='other_alt_id_type' id='other_alt_id_type' onChange='EnbDsbChkbox();'>
						<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><%=mysqlbuff.toString()%></select>
						<input type='checkbox' name='other_alt_id_chk' id='other_alt_id_chk'  value='' align='left' disabled>
						</td>
						<td colspan='2' width='50%'>&nbsp;</td>							
						<!-- //********************* end ********************// -->
				</tr>
		</table>
					
		<table border='0' cellpadding='0' cellspacing='0' width='100%' >						
				
				<tr><td class='label' colspan='4' width='100%'>&nbsp;</td></tr>
						
				<tr>							
							<td colspan='2' class='fields' width='50%'>
							<input type='button' name='accept' id='accept' class='button' value='<fmt:message key="Common.Accept.label" bundle="${common_labels}"/>' disabled onclick='invoke_access();'><input type='button' name='identify' id='identify' class='button' value='<fmt:message key="eDR.IdentifyDuplicate.label" bundle="${dr_labels}"/>' disabled onclick='invoke_identify();'><input type='button' class='BUTTON' value='<fmt:message key="eDR.StartNow.label" bundle="${dr_labels}"/>' name='start_now' disabled onClick='start_nowClick();' ><input type='button' class='BUTTON' value='<fmt:message key="eDR.StartLater.label" bundle="${dr_labels}"/>' disabled name='start_later' onClick='later_Click();' ></td>

							<td class='label' width='25%' colspan='1'><fmt:message key="Common.date.label" bundle="${common_labels}"/>&<fmt:message key="Common.time.label" bundle="${common_labels}"/></td>	

							<td class='fields' width='25%' colspan='1'>
							<input type='text' size='20' disabled name='start_later_time' id='start_later_time'  id="startlater" value='' onBlur="validDateObj(this,'DMYHM','<%=localeName%>');" ><input type='image' id="datepicker" disabled  name="calendertime" id="calendertime"  src='../../eCommon/images/CommonCalendar.gif'  onClick="document.getElementById('start_later_time').focus(); return showCalendar('startlater',null,'hh:mm');"><!-- <input type='button' name='identify' id='identify' class='button' value='Identify Dup' disabled onclick='invoke_identify()';></input> --><!-- <input type='button' name='merge' id='merge' class='button' value='Merge Dup' disabled onclick='invoke_merge()';></input> --></td>											
				</tr>	
				<tr><td class='label' colspan='4' width='100%'>&nbsp;</td></tr>
				<tr>
					<td colspan='3' width='75%'>&nbsp;</td>
					<td class='button' width='25%' colspan='1'>
							<!-- <input type='button' name='previous' id='previous' class='button' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' onClick="call_previous('1','10');" disabled><input type='button' name='next' id='next' class='button' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick="call_next('1','10');" disabled> --><input type='button' name='search' id='search' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="bulid_query();"></input>
					</td>	
				</tr>	
				<tr><td class='label' colspan='4' width='100%'>&nbsp;</td></tr>
		</table>
					<input type=hidden name='final_query' id='final_query' value=''>
					<input type=hidden name='count_record' id='count_record' value=''>
					<input type=hidden name='p_p_line' id='p_p_line' value=''>
					<input type=hidden name='day_of_birth_yn' id='day_of_birth_yn' value=''>
					<input type=hidden name='month_of_birth_yn' id='month_of_birth_yn' value=''>
					<input type=hidden name='year_of_birth_yn' id='year_of_birth_yn' value=''>
					<input type=hidden name='patient_id_for' id='patient_id_for' value=''>
					<input type=hidden name='name_loc_lang_ser' id='name_loc_lang_ser' value=''>
					<input type=hidden name='first_name_ser' id='first_name_ser' value=''>
					<input type=hidden name='second_name_ser' id='second_name_ser' value=''>
					<input type=hidden name='third_name_ser' id='third_name_ser' value=''>
					<input type=hidden name='family_name_ser' id='family_name_ser' value=''>
					<input type=hidden name='names_sndx_ser' id='names_sndx_ser' value=''>
					<input type=hidden name='nationality_ser' id='nationality_ser' value=''>
					<input type=hidden name='sex_ser' id='sex_ser' value=''>
					<input type=hidden name='area_ser' id='area_ser' value=''>
					<input type=hidden name='contact1_no_ser' id='contact1_no_ser' value=''>
					<input type=hidden name='contact2_no_ser' id='contact2_no_ser' value=''>
					<input type=hidden name='search_all_ser' id='search_all_ser' value=''>
					<input type ='hidden' name ='names_in_oth_lang_yn' value='<%=names_in_oth_lang_yn%>'>
					<input type=hidden name ='process_start' value=''>
					<input type=hidden name ='modal' value='Y'>
					<input type=hidden name ='p_line1' value='Y'>
				</form>
				<%
			}
		}

		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception :"+e);
	}
	finally
	{
		
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

