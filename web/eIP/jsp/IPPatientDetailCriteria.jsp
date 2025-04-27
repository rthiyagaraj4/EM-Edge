<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" %>

	<%
		request.setCharacterEncoding("UTF-8");
		String sql;
		Connection con = null;
		Statement stmt1 = null;
		Statement stmt2 = null;
		Statement stmt3 = null;

		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

	try
	{
		String locale = (String)session.getAttribute("LOCALE");
		if(locale == null)
			locale	  = "";
		con = ConnectionManager.getConnection(request);
		stmt1 = con.createStatement();
		stmt2 = con.createStatement();
		stmt3 = con.createStatement();

		String function_id = request.getParameter("function_id");
			if(function_id == null)	function_id = "";
			
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

		String fam_name_ind="N"; /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/


		sql = "";

		//sql = "Select First_Name_Accept_Yn, First_Name_Order, First_Name_Prompt, Second_Name_Accept_Yn, Second_Name_Order, Second_Name_Prompt, Third_Name_Accept_Yn, Third_Name_Order, Third_Name_Prompt, Family_Name_Accept_Yn, Family_Name_Order, Family_Name_Prompt , name_suffix_accept_yn, name_prefix_accept_yn, name_suffix_prompt, name_prefix_prompt, first_name_reqd_yn, second_name_reqd_yn, third_name_reqd_yn, family_name_reqd_yn, name_suffix_reqd_yn, name_prefix_reqd_yn,patient_id_length, pat_name_as_multipart_yn, dflt_sndx_type from mp_param" ;
		/*4/22/2009  IN0010088 */
		sql = "Select NVL(first_name_accept_yn,'N') first_name_accept_yn, First_Name_Order, NVL(first_name_prompt,'First Name') first_name_prompt, NVL(second_name_accept_yn,'N') second_name_accept_yn, Second_Name_Order, NVL(second_name_prompt,'Second Name') second_name_prompt , NVL(third_name_accept_yn,'N') third_name_accept_yn, Third_Name_Order, NVL(third_name_prompt,'Third Name') third_name_prompt, NVL(family_name_accept_yn,'N') family_name_accept_yn, Family_Name_Order, NVL(family_name_prompt,'Family Name') family_name_prompt , NVL(name_suffix_accept_yn,'N') name_suffix_accept_yn, NVL(name_prefix_accept_yn,'N') name_prefix_accept_yn, NVL(name_suffix_prompt,'Name Suffix') name_suffix_prompt, NVL(name_prefix_prompt,'Name Prefix') name_prefix_prompt, NVL(first_name_reqd_yn,'N') first_name_reqd_yn, NVL(second_name_reqd_yn,'N') second_name_reqd_yn, NVL(third_name_reqd_yn,'N') third_name_reqd_yn, NVL(family_name_reqd_yn,'N') family_name_reqd_yn, NVL(name_suffix_reqd_yn,'N') name_suffix_reqd_yn, NVL(name_prefix_reqd_yn,'N') name_prefix_reqd_yn,NVL(patient_id_length,0) patient_id_length, pat_name_as_multipart_yn, dflt_sndx_type, NVL(family_name_length,0) family_name_length from mp_param" ;
		/*Modified by Rameswar on  19-04-2016 for HSA-CRF-0299*/

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
				if(Second_Name_Prompt ==null) Second_Name_Prompt="";
				Third_Name_Accept_Yn = rs1.getString(7);
				Third_Name_Order = rs1.getInt(8);
				Third_Name_Prompt = rs1.getString(9);
				if(Third_Name_Prompt ==null) Third_Name_Prompt="";
				Family_Name_Accept_Yn = rs1.getString(10);
				Family_Name_Order = rs1.getInt(11);    
				Family_Name_Prompt = rs1.getString(12);
				if(Family_Name_Prompt ==null) Family_Name_Prompt="";
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
				
				dflt_sndx_type = rs1.getString(25);
				if (dflt_sndx_type == null) dflt_sndx_type  ="";
			
				/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299- Start*/

				if(First_Name_Accept_Yn.equals("N")&&Second_Name_Accept_Yn.equals("N")&&Third_Name_Accept_Yn.equals("N")&&Family_Name_Accept_Yn.equals("Y")&&function_id.equals("BOOKING_LOOKUP")){
					family_name_length = rs1.getString(26);
					fam_name_ind ="Y";
				}else{ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299- End*/

						if (pat_name_as_multipart_yn.equals("N"))
					family_name_length = "40";
				else
					family_name_length = "15";

				}
			}
		if(rs1!=null)	 rs1.close();
		if(stmt1!=null)	 stmt1.close();
		}
	%>
<script>
	function assignValue(obj)
	{
		if(obj.checked == true)
			obj.value = "th";
		else
			obj.value = "en";
		        
	}

	function enableSearchby(obj)
	{
		if (obj.value=='')
		{
			if (document.forms[0].searchby)
			{
				document.forms[0].searchby.disabled=false;
				document.forms[0].searchby.value='S';						
			}
		}
		else
		{
			if (document.forms[0].searchby)
			{
				document.forms[0].searchby.disabled=true;
				document.forms[0].searchby.value='';
			}
		}
	}
			function validSplchars(obj)
			{				
				 var fields=new Array();
				 var names=new Array();
				 fields[0]=obj;
				 names[0]="Patient ID";									
				if(SpecialCharCheck( fields, names,'',"A",''))
					return true;
				else
				{
					obj.select();
					obj.focus();
					return false;
				}
			}

			async function showLookUp(val)
            {
                if(val == 'P')
                {
					var patientid= await PatientSearch('','','','','','','Y','','','OTHER');
					if(patientid != null)
						 document.getElementById('patient_id').value = patientid;
					else
						 document.getElementById('patient_id').value = "";
                }
            }

	</script>
<table cellspacing=0 cellpadding=0  width='100%' border='0'>
	
	<% 
	if(function_id.equals("RENEW_GATE_PASS")){%>
		<tr>

		<td class='label'  width ='25%'><fmt:message key="eIP.PersonID.label" bundle="${ip_labels}"/></td>

		<td width='25%' class='fields'><input type='text' maxlength='<%=patient_id_length%>' size='20' name='patient_id' id='patient_id' size='<%=patient_id_length%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"></td>
	<%}else if(function_id.equals("BOOKING_LOOKUP")) {%>
		<tr>

		<td class='label'  width = '25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>

		<td width='25%' class='fields'><input type='text' maxlength='<%=patient_id_length%>' size='20' name='patient_id' id='patient_id' size='<%=patient_id_length%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"></td>

	<%	}else if(function_id.equals("NO_SHOW")){	%>
		
	<tr>
		<!--
		<td class='label'  width = '30%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td width='20%' class='fields' ><input type='text' maxlength='<%=patient_id_length%>' size='20' name='patient_id' size='<%=patient_id_length%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"></td>-->
	<%	}else{	%>
		<tr>

		<td class='label'  width = '25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td width='25%' class='fields'><input type='text' maxlength='<%=patient_id_length%>' size='20' name='patient_id' id='patient_id' size='<%=patient_id_length%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"></td>
	<%}%>
		
		<input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value="<%=pat_name_as_multipart_yn%>">		
		<input type='hidden' name='fam_name_ind' id='fam_name_ind' value="<%=fam_name_ind%>">		
				
	<%
	if(function_id.equals("CONFIRM_TRANS_BOOKING") || function_id.equals("CANCEL_TRANS_BOOKING")) {%>

		<td class='label'   width ='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			
			<td  class='fields' width ='25%'><select name='gender' id='gender'>
					<option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
					<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
					<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
					<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		</tr>
		

	<%}else if(function_id.equals("BOOKING_LOOKUP")) {%>
			
			<td class='label' width ='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>

			<td  class='fields' width ='25%'><select name='gender' id='gender'>
					<option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
					<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
					<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
					<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		</tr>
	<%}else if(function_id.equals("NO_SHOW")){%>
<!--
			<td class='label' width ='30%' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td  class='fields' width ='20%' ><select name='gender' id='gender'>
					<option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
					<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
					<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
					<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				</select>
			</td>-->
			</tr>
	<%}else{%>
	<td class='label' width ='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td  class='fields' width ='25%'><select name='gender' id='gender'>
					<option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
					<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
					<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
					<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			</tr>
<%	}
	if(!function_id.equals("NO_SHOW") ) 
	{	%>
		<tr>
			<td class='label' >&nbsp;</td>
			<td class='label' >&nbsp;</td>
			<td class='label' width ='25%'><fmt:message key="eMP.SearchNameWithLocalLang.label" bundle="${mp_labels}"/></td>
			<td class='fields' width ='25%' ><input type='checkbox' name='loc_lang' id='loc_lang' value='th' checked onclick='assignValue(this)'></td>
			
		</tr>
<%	}%>

</table>
	
				<table cellspacing=0 cellpadding=0  width='100%' border='0'>
					<tr>
						<%
							if ( Name_Prefix_Accept_Yn.equals("Y") )
							{
								out.println("<td class='label'>"+Name_Prefix_Prompt+"</td>");
							}
							if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {

									out.println("<td  class='label'>"+ First_Name_Prompt + "</td>");
							}
							else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
								out.println("<td  class='label'>" + Second_Name_Prompt + "</td>");
							}
							else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
								out.println("<td   class='label'>" + Third_Name_Prompt + "</td>");
							}
							else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 && fam_name_ind.equals("Y")) {
							   //Above condition added for this incident [61325] 
								out.println("<td  class='label'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + Family_Name_Prompt + "</td>");
							}
							else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 && fam_name_ind.equals("N")) {
								out.println("<td  class='label'>" + Family_Name_Prompt + "</td>");
								//End this incident [61325] 
							}
							
							if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
								out.println("<td  class='label'>"+ First_Name_Prompt + "</td>");
							}
							else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
								out.println("<td  class='label'>" + Second_Name_Prompt + "</td>");
							}
							else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
								out.println("<td   class='label'>" + Third_Name_Prompt + "</td>");
							}
							else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 && fam_name_ind.equals("Y") ) {
							//Above condtion added for this incident [61325] 
								out.println("<td  class='label'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + Family_Name_Prompt + "</td>");
							}
							else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 && fam_name_ind.equals("N")) {
								out.println("<td  class='label'>" + Family_Name_Prompt + "</td>");
								//Above condtion added for this incident [61325] 
							}

							if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
								out.println("<td  class='label'>"+ First_Name_Prompt + "</td>");
							}
							else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
								out.println("<td  class='label'>" + Second_Name_Prompt + "</td>");
							}
							else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
							//		if(Third_Name_Prompt==null)	Third_Name_Prompt = "&nbsp";
								out.println("<td   class='label'>" + Third_Name_Prompt + "</td>");
							}
							else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 && fam_name_ind.equals("Y")) {
							//Above condtion added for this incident [61325] 
								out.println("<td  class='label'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + Family_Name_Prompt + "</td>");
							}
							else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 && fam_name_ind.equals("N")) {
								out.println("<td  class='label'>" + Family_Name_Prompt + "</td>");
								//Above condtion added for this incident [61325] 
							}


							if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
								out.println("<td  class='label'>"+ First_Name_Prompt + "</td>");
							}
							else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
								out.println("<td  class='label'>" + Second_Name_Prompt + "</td>");
							}
							else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
								//	if(Third_Name_Prompt==null) Third_Name_Prompt = "&nbsp";
									out.println("<td  class='label'>" + Third_Name_Prompt + "</td>");
							}
							else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4  && fam_name_ind.equals("Y")) {
							  //Above condtion added for this incident [61325] 
								if(Family_Name_Prompt==null)
									Family_Name_Prompt = "&nbsp";
								out.println("<td  class='label'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + Family_Name_Prompt + "</td>");
							}
							else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4  && fam_name_ind.equals("N")) {
								if(Family_Name_Prompt==null)
									Family_Name_Prompt = "&nbsp";
								out.println("<td  class='label'>" + Family_Name_Prompt + "</td>");
								//Above condtion added for this incident [61325] 
							}


							if ( Name_Suffix_Accept_Yn.equals("Y") )
								out.println("<td  class='label'>"+Name_Suffix_Prompt+"</td>");

							%>
							</tr>
							<tr>

							<%
							if ( Name_Prefix_Accept_Yn.equals("Y") )
							{
									out.println("<td class='fields'  >&nbsp;<Select name='name_prefix' id='name_prefix' tabIndex='14'>");

										out.println("<Option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------</option>");

								sql="Select decode('"+locale+"', 'en', Name_Prefix, name_prefix_loc_lang) Name_Prefix from Mp_Name_Prefix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1";
								rs2 = stmt2.executeQuery(sql);
								
								
								if (rs2 != null)
								{
									while( rs2.next() ) {
																			
										
										out.println("<Option value=\"" + rs2.getString("Name_Prefix") + "\">" + rs2.getString("Name_Prefix")+"</option>");
										
									}
								if(rs2!=null)	 rs2.close();
								if(stmt2!=null)	 stmt2.close();
								}
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
									out.println("<td  ><input type='text' name='first_name' id='first_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");

								if (First_Name_Reqd_Yn.equals("Y")  )
								{
									out.println("<input type='hidden' name=\"first_name_reqd_yn\" value='Y'></input>");
								}
								else
								{
									out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
								}
								out.println("</td>");
							}
							else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 )
							{
								out.println("<td  ><input type='text' name='second_name' id='second_name' maxlength='15' size='15'  onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");

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
								out.println("<td  ><input type='text' name='third_name' id='third_name' maxlength='15' size='15'  onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");


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
							{	/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
                               //Below line added for this incident [61325] 
							    if(fam_name_ind =="Y"){
								   out.println("<td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");
								}else{
								   out.println("<td ><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");
								}
								//End Senthil

								if(First_Name_Accept_Yn.equals("N")&&Second_Name_Accept_Yn.equals("N")&&Third_Name_Accept_Yn.equals("N")&&Family_Name_Accept_Yn.equals("Y")&&function_id.equals("BOOKING_LOOKUP")){
								out.println("<select name='searchby' id='searchby' ><option value=''  selected>---&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp;---</option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");
								}else{
								if (pat_name_as_multipart_yn.equals("N"))
									out.println("<select name='searchby' id='searchby' disabled><option value=''  selected>---&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp;---</option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");
									}

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
								out.println("<td  ><input type='text' name='first_name' id='first_name' maxlength='15' size='15'  tabIndex='16' onBlur=\"makeValidQueryCriteria(this);\">");

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
								out.println("<td  ><input type='text' name='second_name' id='second_name' maxlength='15' size='15'  onBlur=\"makeValidQueryCriteria(this);\" tabIndex='16'>");

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
								out.println("<td  ><input type='text' name='third_name' id='third_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='16'>");

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
							{	/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
                                //Below line Added for this incident [61325] 
							    if(fam_name_ind =="Y"){
								out.println("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='16'>");
								}else{
								 out.println("<td  ><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='16'>");
								}
								//End Senthil
								if(First_Name_Accept_Yn.equals("N")&&Second_Name_Accept_Yn.equals("N")&&Third_Name_Accept_Yn.equals("N")&&Family_Name_Accept_Yn.equals("Y")&&function_id.equals("BOOKING_LOOKUP")){
								out.println("<select name='searchby' id='searchby' ><option value=''  selected>---&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp;---</option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");
								}else{
								if (pat_name_as_multipart_yn.equals("N"))
									out.println("<select name='searchby' id='searchby'  disabled><option value=''  selected>---&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp;---</option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");
									}
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
								out.println("<td  ><input type='text' name='first_name' id='first_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");

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
								out.println("<td  ><input type='text' name='second_name' id='second_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");

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
								out.println("<td  ><input type='text' name='third_name' id='third_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");

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
							{	/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
                                //Below line added for this incident [61325] 
								if(fam_name_ind =="Y"){
								out.println("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");
								}else{
								out.println("<td  ><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");
								}
								//End Senthil								
								
								if(First_Name_Accept_Yn.equals("N")&&Second_Name_Accept_Yn.equals("N")&&Third_Name_Accept_Yn.equals("N")&&Family_Name_Accept_Yn.equals("Y")&&function_id.equals("BOOKING_LOOKUP")){
								out.println("<select name='searchby' id='searchby' ><option value=''  selected>---&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp;---</option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");
								}else{
								if (pat_name_as_multipart_yn.equals("N"))
									out.println("<select name='searchby' id='searchby' disabled><option value=''  selected>---&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp;---</option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");
									}
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
								out.println("<td  ><input type='text' name='first_name' id='first_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='18'>");

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
								out.println("<td  ><input type='text' name='second_name' id='second_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='18'>");

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
								out.println("<td  ><input type='text' name='third_name' id='third_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='18'>");

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
							{	/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
                                
								//Below line added for this incident [61325] 
								if(fam_name_ind =="Y"){
								out.println("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='18'>");
								}else{
								out.println("<td  ><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='18'>");
								}
								//End this incident [61325] 
								
								if(First_Name_Accept_Yn.equals("N")&&Second_Name_Accept_Yn.equals("N")&&Third_Name_Accept_Yn.equals("N")&&Family_Name_Accept_Yn.equals("Y")&&function_id.equals("BOOKING_LOOKUP")){
								out.println("<select name='searchby' id='searchby' ><option value=''  selected>---&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp;---</option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");
								}else{
								if (pat_name_as_multipart_yn.equals("N"))
									out.println("<select name='searchby' id='searchby'  disabled><option value=''  selected>---&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp;---</option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");
									}
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
							out.println("<td  ><Select name='name_suffix' id='name_suffix' tabIndex='19'>");

									out.println("<Option value=''>---&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp;---</option>");

								sql="Select decode('"+locale+"', 'en', Name_Suffix, Name_Suffix_loc_lang) Name_Suffix from Mp_Name_Suffix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1";
								rs3 = stmt3.executeQuery(sql);
								
								if(rs3 != null ) {
									while(rs3.next()) {
										
										
										out.println("<Option value=\"" + rs3.getString("name_suffix") + "\">" + rs3.getString("Name_Suffix")+"</option>");
										
									}
								if(rs3!=null ) rs3.close();
								if(stmt3!=null) stmt3.close();
								}

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
							
							if(stmt1!=null)	 stmt1.close();
							if(stmt2!=null)	 stmt2.close();
							if(stmt3!=null)	 stmt3.close();
							if(rs1!=null)	 rs1.close();
							if(rs2!=null)	 rs1.close();
							if(rs3!=null)	 rs3.close();
						%>
				</tr>
			</table>
		
		<%
		}catch(Exception e)
		{
			out.println(e);
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
			%>
<script>
	//enableSearchby(document.forms[0].soundex);
</script>

