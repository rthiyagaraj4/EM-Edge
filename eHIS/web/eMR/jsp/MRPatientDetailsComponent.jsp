<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*"  contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<script language='javascript' src="../../eMR/js/MedRecRequest.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> 
	<script>
	function assignValue(obj)
	{
		if(obj.checked == true)
			obj.value = "th";
		else
			obj.value = "en";
	}
	</script>
</head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sql;
		Connection con = ConnectionManager.getConnection(request);
		Statement stmt1 = con.createStatement();
		Statement stmt2 = con.createStatement();
		Statement stmt3 = con.createStatement();
	
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		String request_type = request.getParameter("request_type");
	
		try
		{
		String First_Name_Accept_Yn ="";
		int First_Name_Order=0;
		String First_Name_Prompt ="";
		String Second_Name_Accept_Yn ="";
		int Second_Name_Order =0;
		String Second_Name_Prompt ="";
		String Third_Name_Accept_Yn ="";
		int Third_Name_Order =0;
		String Third_Name_Prompt ="";
		String Family_Name_Accept_Yn ="";
		int Family_Name_Order =0;
		String Family_Name_Prompt ="";
		String Name_Suffix_Accept_Yn ="";
		String Name_Suffix_Prompt ="";
		String Name_Prefix_Accept_Yn = "";
		String Name_Prefix_Prompt = "";

		String First_Name_Reqd_Yn ="";
		String Second_Name_Reqd_Yn ="";
		String Third_Name_Reqd_Yn ="";
		String Family_Name_Reqd_Yn ="";
		String Name_Suffix_Reqd_Yn ="";
		String Name_Prefix_Reqd_Yn ="";
		String patient_id_length="";
		//Added by kumar on 17/03/2003 for Malaysia Enhancements
		String pat_name_as_multipart_yn = "";
		String family_name_length = "";
		String dflt_sndx_type = "";
		//End 
		sql = "";

		sql = "Select First_Name_Accept_Yn, First_Name_Order, First_Name_Prompt, Second_Name_Accept_Yn, Second_Name_Order, Second_Name_Prompt, Third_Name_Accept_Yn, Third_Name_Order, Third_Name_Prompt, Family_Name_Accept_Yn, Family_Name_Order, Family_Name_Prompt , name_suffix_accept_yn, name_prefix_accept_yn, name_suffix_prompt, name_prefix_prompt, first_name_reqd_yn, second_name_reqd_yn, third_name_reqd_yn, family_name_reqd_yn, name_suffix_reqd_yn, name_prefix_reqd_yn,patient_id_length, pat_name_as_multipart_yn, dflt_sndx_type from mp_param" ;

		rs1 = stmt1.executeQuery(sql);
		if (rs1 != null)
		{
			while(rs1.next())
			{
				First_Name_Accept_Yn = rs1.getString(1);
				First_Name_Order = rs1.getInt(2);
				First_Name_Prompt = rs1.getString(3);
				Second_Name_Accept_Yn = rs1.getString(4);
				Second_Name_Order = rs1.getInt(5);
				Second_Name_Prompt = rs1.getString(6);
				Third_Name_Accept_Yn = rs1.getString(7);
				Third_Name_Order = rs1.getInt(8);
				Third_Name_Prompt = rs1.getString(9);
				Family_Name_Accept_Yn = rs1.getString(10);
				Family_Name_Order = rs1.getInt(11);
				Family_Name_Prompt = rs1.getString(12);

				Name_Suffix_Accept_Yn = rs1.getString(13);
				Name_Prefix_Accept_Yn = rs1.getString(14);
				Name_Suffix_Prompt = rs1.getString(15);
				Name_Prefix_Prompt = rs1.getString(16);

				First_Name_Reqd_Yn = rs1.getString(17);
				Second_Name_Reqd_Yn = rs1.getString(18);
				Third_Name_Reqd_Yn = rs1.getString(19);
				Family_Name_Reqd_Yn = rs1.getString(20);
				Name_Suffix_Reqd_Yn = rs1.getString(21);
				Name_Prefix_Reqd_Yn = rs1.getString(22);
				patient_id_length	= rs1.getString(23);
				pat_name_as_multipart_yn = rs1.getString(24);				
				if (pat_name_as_multipart_yn.equals("N"))
					family_name_length = "40";
				else
					family_name_length = "15";
				dflt_sndx_type = rs1.getString(25);
				if (dflt_sndx_type == null) dflt_sndx_type  ="";
			}
		}
		stmt1.close();
		rs1.close();
	%>

	

	<table cellspacing=0 cellpadding=1 align='center' width='100%' border='0'>
		<tr>
			<td class='label' width="24%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td width="26%" class='fields'>&nbsp;&nbsp;&nbsp;<input type='text' maxlength='<%=patient_id_length%>' size='20' name='PatientId' id = "PatientId" size='<%=patient_id_length%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this)'>
			<input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')" >
			</input><img src='../../eCommon/images/mandatory.gif' id='img1' style='visibility:hidden'></img></td>				
			
			<!--Modified by Ashwini on 25-Feb-2019 for MO-CRF-20149-->
			<td class='label' width="25%" ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='gender' id='gender'>
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
					<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
					<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				</select></td>	
		</tr>

<%		if(request_type.equals("MB"))
		{	%>
			<tr>
				<td class='label' width ='24%'><fmt:message key="eMP.SearchNameWithLocalLang.label" bundle="${mp_labels}"/></td>
				<td class='fields' width ='26%' ><input type='checkbox' name='loc_lang' id='loc_lang' value='th' checked onclick='assignValue(this)'></td>
				<td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
			</tr>
	<%	}	%>


<!-- 		<tr>
			<td  class='label' >Soundex</td>
			<td class='fields'><select name='soundex' id='soundex' onChange="enableSearchby(this)">
					<%if (dflt_sndx_type.equals("G")) {%>
						<option value=''>--Select--</option>
						<option value='G' selected>Generic</option>
						<option value='E'>Ethnic</option>
					<%}else if (dflt_sndx_type.equals("E")){%>
						<option value=''>--Select--</option>
						<option value='G'>Generic</option>		
						<option value='E' selected>Ethnic</option>
					<%}
					  else {%>
						<option value='' selected>--Select--</option>
						<option value='G'>Generic</option>		
						<option value='E'>Ethnic</option>
					<%}%>				
				</select></td>
			  <td class='label'>&nbsp;</td>
			  <td class='label'>&nbsp;</td>
		</tr> -->
		<input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value="<%=pat_name_as_multipart_yn%>">
<%	if(request_type.equals("MB"))
		{	%>
	</table>
	<table border="0" cellpadding="1" cellspacing="0" width="100%">
		<tr align='left'>
			<%
				if ( Name_Prefix_Accept_Yn.equals("Y") )
				{
					out.println("<td  class='label'><p align='left'>"+Name_Prefix_Prompt+"</p></td>");
				}

				if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {

						out.println("<td  class='label'>"+ First_Name_Prompt + "</td>");
				}
				else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
					out.println("<td  class='label'>" + Second_Name_Prompt + "</td>");
				}
				else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
					out.println("<td  class='label'>" + Third_Name_Prompt + "</td>");
				}
				else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
					out.println("<td  class='label'>" + Family_Name_Prompt + "</td>");
				}
				if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
					out.println("<td  class='label'>"+ First_Name_Prompt + "</td>");
				}
				else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
					out.println("<td  class='label'>" + Second_Name_Prompt + "</td>");
				}
				else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
					out.println("<td  class='label'>" + Third_Name_Prompt + "</td>");
				}
				else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
					out.println("<td  class='label'>" + Family_Name_Prompt + "</td>");
				}

				if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
					out.println("<td  class='label'>"+ First_Name_Prompt + "</td>");
				}
				else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
					out.println("<td  class='label'>" + Second_Name_Prompt + "</td>");
				}
				else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
						if(Third_Name_Prompt==null)
							Third_Name_Prompt = "&nbsp";
					out.println("<td  class='label'>" + Third_Name_Prompt + "</td>");
				}
				else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
					out.println("<td  class='label'>" + Family_Name_Prompt + "</td>");
				}

				if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
					out.println("<td  class='label'>"+ First_Name_Prompt + "</td>");
				}
				else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
					out.println("<td  class='label'>" + Second_Name_Prompt + "</td>");
				}
				else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
						if(Third_Name_Prompt==null)
							Third_Name_Prompt = "&nbsp";
						out.println("<td  class='label'>" + Third_Name_Prompt + "</td>");
				}
				else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
					if(Family_Name_Prompt==null)
						Family_Name_Prompt = "&nbsp";
					out.println("<td  class='label'><p align='left'>" + Family_Name_Prompt + "</p></td>");
				}

				if ( Name_Suffix_Accept_Yn.equals("Y") )
					out.println("<td  class='label'>"+Name_Suffix_Prompt+"</td>");

				%>
				</tr>
				<tr>

				<%
				if ( Name_Prefix_Accept_Yn.equals("Y") )
				{
					
					out.println("<td class='fields'><Select name='name_prefix' id='name_prefix' tabIndex='14'>");
					%>
					<Option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%
					sql="Select Name_Prefix from Mp_Name_Prefix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1";
					rs2 = stmt2.executeQuery(sql);
					if (rs2 != null)
					{
						while( rs2.next() ) {
							out.println("<Option value=\"" + rs2.getString("Name_Prefix") + "\">" + rs2.getString("Name_Prefix")+"</option>");
							
						}
					}
					stmt2.close();
					rs2.close();

					out.println("</Select>");
					if (Name_Prefix_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='N'></input>");
					}

				out.println("</td>");
				}

				if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 )
				{
						out.println("<td class='fields' ><input type='text' name='first_name' id='first_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");

					if (First_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name=\"first_name_reqd_yn\" id=\"first_name_reqd_yn\" value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
					}
					out.println("</td>");
				}
				else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 )
				{
					out.println("<td class='fields' ><input type='text' name='second_name' id='second_name' maxlength='15' size='15'  onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");

					if (Second_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
					}

					out.println("</td>");
				}
				else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )
				{
					out.println("<td class='fields'><input type='text' name='third_name' id='third_name' maxlength='15' size='15'  onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");


					if (Third_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
					}

					out.println("</td>");
				}
				else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 )
				{
					
					out.println("<td class='fields' ><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");
					if (pat_name_as_multipart_yn.equals("N"))
					{ %>
					<select name='searchby' id='searchby' disabled><option value=''  selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option></select>
					<%}


					if ( Family_Name_Reqd_Yn.equals("Y") )
					{
						out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
					}

					out.println("</td>");
				}

				if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 )
				{
					out.println("<td class='fields'><input type='text' name='first_name' id='first_name' maxlength='15' size='15'  tabIndex='16' onBlur=\"makeValidQueryCriteria(this);\">");

					if (First_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
					}
					out.println("</td>");
				}
				else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 )
				{
					out.println("<td class='fields'><input type='text' name='second_name' id='second_name' maxlength='15' size='15'  onBlur=\"makeValidQueryCriteria(this);\" tabIndex='16'>");

					if (Second_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
					}
					out.println("</td>");
				}
				else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )
				{
					out.println("<td class='fields'><input type='text' name='third_name' id='third_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='16'>");

					if (Third_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
					}


					out.println("</td>");
				}
				else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 )
				{
					
					out.println("<td class='fields'><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='16'>");
					if (pat_name_as_multipart_yn.equals("N"))
					{	%>
					
						<select name='searchby' id='searchby'  disabled><option value=''  selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option></select>
				<%	}

					if (Family_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
					}
					out.println("</td>");
				}

				if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 )
				{
					out.println("<td class='fields'><input type='text' name='first_name' id='first_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");

					if (First_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
					}

					out.println("</td>");
				}
				else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 )
				{
					out.println("<td class='fields'><input type='text' name='second_name' id='second_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");

					if (Second_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
					}
					out.println("</td>");
				}
				else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )
				{
					out.println("<td class='fields'><input type='text' name='third_name' id='third_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");

					if (Third_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
					}


					out.println("</td>");
				}
				else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 )
				{
					
					out.println("<td class='fields'><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");
					if (pat_name_as_multipart_yn.equals("N"))
					{ %>
						<select name='searchby' id='searchby' disabled><option value=''  selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option></select>
<%					}

					if (Family_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
					}
					out.println("</td>");
				}

				if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 )
				{
					out.println("<td class='fields' ><input type='text' name='first_name' id='first_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='18'>");

					if (First_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
					}
					out.println("</td>");
				}
				else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 )
				{
					out.println("<td class='fields'><input type='text' name='second_name' id='second_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='18'>");

					if (Second_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
					}


					out.println("</td>");
				}
				else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )
				{
					out.println("<td class='fields'><input type='text' name='third_name' id='third_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='18'>");

					if (Third_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
					}

					out.println("</td>");
				}
				else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 )
				{
					
					out.println("<td class='fields'><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='18'>");
					if (pat_name_as_multipart_yn.equals("N"))
					{ %>
						<select name='searchby' id='searchby'  disabled><option value=''  selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option></select>
					<%}

					if (Family_Name_Reqd_Yn.equals("Y")  )
					{
						out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
					}
					out.println("</td>");
				}

				if ( Name_Suffix_Accept_Yn.equals("Y") )
				{
					
					out.println("<td class='fields'><Select name='name_suffix' id='name_suffix' tabIndex='19'>");
					%>
					<Option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%
					sql="Select Name_Suffix from Mp_Name_Suffix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1";
					rs3 = stmt3.executeQuery(sql);
					if(rs3 != null ) 
					{
						while(rs3.next()) 
						{
							out.println("<Option value=\"" + rs3.getString("name_suffix") + "\">" + rs3.getString("Name_Suffix")+"</option>");
						}
					}
					stmt3.close();
					rs3.close();

					if (Name_Suffix_Reqd_Yn.equals("Y")  )
					{
						out.println("</select><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='Y'></input>");
					}
					else
					{
						out.println("</select><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='N'></input>");
					}

					out.println("</td>");
				}

					if(rs1!=null)	 rs1.close();
					if(rs2!=null)	 rs1.close();
					if(rs3!=null)	 rs3.close();				

					if(stmt1!=null)	 stmt1.close();
					if(stmt2!=null)	 stmt2.close();
					if(stmt3!=null)	 stmt3.close();
				
				%>
			</tr>
	</table>
<%	}
	}catch(Exception e)
	{
		//out.println("Exception @ try "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(rs1 != null)rs1.close();
			if(rs2 != null)rs2.close();
			if(rs3 != null)rs3.close();

			if(stmt1 != null)stmt1.close();
			if(stmt2 != null)stmt2.close();
			if(stmt3 != null)stmt3.close();

			}

		catch(Exception e)
		{
			//out.println("Exception @ finally"+e.toString());
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);
		}
			%>
<script>
//	enableSearchby(document.forms[0].soundex);
</script>
	</html>

