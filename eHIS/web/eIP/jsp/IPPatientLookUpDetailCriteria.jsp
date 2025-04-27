<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
			String call_function	= request.getParameter("call_function");
				if(call_function == null) call_function= "";
			
			// code added to get the facility id from session
			// this is needed for ABM sub module in IP module
			// facility id is needed for patient search function
			String facility_id=(String) session.getValue("facility_id");
				
	 		Connection con = null;
			Statement stmt1 = null;
	 		Statement stmt2 = null;
	 		Statement stmt3 = null;

	 		ResultSet rs1 = null;
	 		ResultSet rs2 = null;
	 		ResultSet rs3 = null;

			//Added by Arthi on 31-Jan-2022 for GHL-CRF-0643
	        Boolean isPatIdMandAppl =  false;

			try
			{
			con = ConnectionManager.getConnection(request);
			stmt1 = con.createStatement();
	 		stmt2 = con.createStatement();
	 		stmt3 = con.createStatement();
              
            //Added by Arthi on 31-Jan-2022 for GHL-CRF-0643
		    isPatIdMandAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "MAKE_PAT_ID_MAND");

			String Patient_Id_Length =request.getParameter("patient_id_length");
			//Added by kumar on 18/03/2003 for Malaysia Enhancements
			String pat_name_as_multipart_yn = "";
			/*Wednesday, April 28, 2010 , commented for PE since values not used */
			/*
			sql = "Select First_Name_Accept_Yn, First_Name_Order, First_Name_Prompt, Second_Name_Accept_Yn, Second_Name_Order, Second_Name_Prompt, Third_Name_Accept_Yn, Third_Name_Order, Third_Name_Prompt, Family_Name_Accept_Yn, Family_Name_Order, Family_Name_Prompt , name_suffix_accept_yn, name_prefix_accept_yn, name_suffix_prompt, name_prefix_prompt, first_name_reqd_yn, second_name_reqd_yn, third_name_reqd_yn, family_name_reqd_yn, name_suffix_reqd_yn, name_prefix_reqd_yn, patient_id_length, pat_name_as_multipart_yn, dflt_sndx_type  from mp_param" ;

			rs1 = stmt1.executeQuery(sql);
			if (rs1 != null)
			{
				while(rs1.next())
				{
					First_Name_Accept_Yn = checkForNull(rs1.getString(1));
					First_Name_Order = rs1.getInt(2);
					First_Name_Prompt = checkForNull(rs1.getString(3));
					Second_Name_Accept_Yn = checkForNull(rs1.getString(4));
					Second_Name_Order = rs1.getInt(5);
					Second_Name_Prompt = checkForNull(rs1.getString(6));
					Third_Name_Accept_Yn = checkForNull(rs1.getString(7));
					Third_Name_Order = rs1.getInt(8);
					Third_Name_Prompt = checkForNull(rs1.getString(9));
					Family_Name_Accept_Yn = checkForNull(rs1.getString(10));
					Family_Name_Order = rs1.getInt(11);
					Family_Name_Prompt = checkForNull(rs1.getString(12));

					Name_Suffix_Accept_Yn = checkForNull(rs1.getString(13));
					Name_Prefix_Accept_Yn = checkForNull(rs1.getString(14));
					Name_Suffix_Prompt = checkForNull(rs1.getString(15));
					Name_Prefix_Prompt = checkForNull(rs1.getString(16));


					First_Name_Reqd_Yn = checkForNull(rs1.getString(17));
					Second_Name_Reqd_Yn = checkForNull(rs1.getString(18));
					Third_Name_Reqd_Yn = checkForNull(rs1.getString(19));
					Family_Name_Reqd_Yn = checkForNull(rs1.getString(20));
					Name_Suffix_Reqd_Yn = checkForNull(rs1.getString(21));
					Name_Prefix_Reqd_Yn = checkForNull(rs1.getString(22));
					Patient_Id_Length = checkForNull(rs1.getString(23));
					pat_name_as_multipart_yn = checkForNull(rs1.getString(24));				
					if (pat_name_as_multipart_yn.equals("N"))
						family_name_length = "40";
					else
						family_name_length = "15";
					
					dflt_sndx_type = checkForNull(rs1.getString(25));

				}
				if(rs1!=null)	 rs1.close();
				if(stmt1!=null)	 stmt1.close();
			}
			*/
			/**/
		%>

		<script>
	
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
				var val = obj.value.toUpperCase();			
				obj.value = val;	
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
					var patientid=await PatientSearch('','','','','','','Y','','','OTHER');
				
					if(patientid != null)
                    	document.getElementById('patient_id').value = patientid;
                }else if(val == 'GBMP'){
                	// code added for GBM module - patient search
                	// in GBM module has more functionalities
                	var patientId=await PatientSearch('','','','','','','Y','','','OTHER');
                	// code modified to check if patient id obtained is valid
        		    // and then search patient search functionality is performed
                    if(patientId){
                    	document.getElementById('patient_id').value = patientId;
                    	var facIdComp = document.getElementById("facId");
                    	if(facIdComp){
                    		var facId = facIdComp.value;
                    		//alert(facId);
                    		performPatientSearch(patientId,facId);
                    	}else{
                    		//alert('Unable to highlight selected patient. Internal system error.');
                    	}
                    }else{
                    	//alert('Unable to retrieve selected patient id. Internal system error.');
                    }
                }
            }

		</script>

		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>

<%if(call_function.equals("adv_bed_mgmt")){	%>
			<tr>
				<td class='label' style='background-color:#3ca0b2;color:#FFFFFF'  nowrap width = '25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>		
				<td width = '25%' class='fields' style='background-color:#3ca0b2;color:#FFFFFF'  nowrap><input type='text' maxlength='<%=Patient_Id_Length%>' size='20' name='patient_id' id='patient_id' size='<%=Patient_Id_Length%>' onkeyup="patientSrchKeyAction(event,this,'<%=facility_id%>');" onBlur="patientSrchBlurAction(this,'<%=facility_id%>');"><input type="button" class=BUTTON id="patient_search" name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('GBMP')"></td>
				<td class='label' style='background-color:#3ca0b2;color:#FFFFFF'>&nbsp;</td>
				<td class='label' style='background-color:#3ca0b2;color:#FFFFFF'>&nbsp;</td>
	
		</tr>
<%}else if(call_function.equals("TransferPatientOut")){	%>
			<tr>
				<td class='label'  nowrap width = '25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>		
				<td width = '25%' class='fields'  nowrap><input type='text' maxlength='<%=Patient_Id_Length%>' size='20' name='patient_id' id='patient_id' size='<%=Patient_Id_Length%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"></td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<!-- <td class='label'  width = '25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>

				<td  width = '25%' class='fields'  nowrap><select name='gender' id='gender'>
						<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
					</select>
				</td> -->
	
		</tr>
<%}else if(call_function.equals("QueryDischarge") || call_function.equals("AdminHist")){%>
			
		
<%if(!call_function.equals("AdminHist")) {%>
				<tr>
					<td class='label' width = '25%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td width = '25%' class='fields'><input type='text' maxlength='<%=Patient_Id_Length%>' size='20' name='patient_id' id='patient_id' size='<%=Patient_Id_Length%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"></td>				<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
				</TR>
<%}else {%>			
				<tr>	
					<td class='label' width = '25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td width = '25%' class='fields'><input type='text' maxlength='<%=Patient_Id_Length%>' size='20' name='patient_id' id='patient_id' size='<%=Patient_Id_Length%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"></td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
				</TR>
<%}%>
				
			
				<!-- <td  width = '22%' class='fields'  nowrap><select name='gender' id='gender'><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
					</select>
				</td> -->
		

<%	}else{%>
		
			<%	if(call_function.equals("QueryCancelDischarge"))
				{%>	
				<tr>
					<td class='label'  width ='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td width ='22.3%' class='fields'  ><input type='text' maxlength='<%=Patient_Id_Length%>' size='20' name='patient_id' id='patient_id' size='<%=Patient_Id_Length%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"></td>
				</tr>
			<%}
			else if(call_function.equals("ChangedAdmDtls")){%>
				<tr>
					<td class='label'  width ='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td width ='25%' class='fields'  ><input type='text' maxlength='<%=Patient_Id_Length%>' size='20' name='patient_id' id='patient_id' size='<%=Patient_Id_Length%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"></td>
					<td class='label'  width = '25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>

				<td  width = '25%' class='fields'  nowrap><select name='gender' id='gender'>
						<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
					</select>
				</td> 

				</tr>
			<%} else{ %>
			<tr>

				<td class='label'  width ='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td width ='25%' class='fields'  ><input type='text' maxlength='<%=Patient_Id_Length%>' size='20' id='patient_id' name='patient_id' size='<%=Patient_Id_Length%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')">
				
				<!--Added by Arthi on 31-Jan-2022 for GHL-CRF-0643-->
				<% if(isPatIdMandAppl){ %>
				<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='PatIdMand'></img> 
                <% } %>
				<!--End GHL-CRF-0643-->
				</td>

					<!-- sep-1-2008 enhancement of Pateient name Search -->
				<%	if(call_function.equals("IPList"))
				{%>	
			
				<td class='label' width = '25%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>

				<td class='fields' width = '25%'>
				<input type='text'  size='15' name='patient_name' id='patient_name' >
				</td>
				<%}
					else{%>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
					<%
					}%>
				<!-- sep-1-2008 enhancement of Pateient name Search end -->

				<!-- <td class='label'  width ='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>

				<td  width = '25%' class='fields'  nowrap><select name='gender' id='gender'>
						<option value=''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
					</select>
				</td> -->

			<%	if(call_function.equals("REG_NEWBORN_FOR_IP"))
				{	
					//out.println("<script>document.forms[0].gender.value='F';document.forms[0].gender.disabled=true</script>");
				}	%>
		
			</tr><%}%>
<%}%>
				</table>
			 <input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value="<%=pat_name_as_multipart_yn%>">
			 
			 <!-- hidden component to store facility id - this is needed for GBM sub module-->
			 <input type="hidden" id="facId" name="facId" id="facId" value="<%=facility_id%>">
<!-- 
					<table border="0" cellpadding="0" cellspacing="0" width='100%'>
						<tr> -->
							<%/*
								if ( Name_Prefix_Accept_Yn.equals("Y") )
								{
									out.println("<td  class='LABELLEFT'>&nbsp;&nbsp;"+Name_Prefix_Prompt+"</td>");
								}

								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) 
								{
									out.println("<td  class='LABELLEFT'>"+ First_Name_Prompt + "</td>");
								}
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
									out.println("<td  class='LABELLEFT'>" + Second_Name_Prompt + "</td>");
								}
								else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
									out.println("<td  class='LABELLEFT'>" + Third_Name_Prompt + "</td>");
								}
								else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
									out.println("<td  class='LABELLEFT'>" + Family_Name_Prompt + "</td>");
								}

								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
									out.println("<td  class='LABELLEFT'>"+ First_Name_Prompt + "</td>");
								}
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
									out.println("<td class='LABELLEFT'>" + Second_Name_Prompt + "</td>");
								}
								else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
									out.println("<td  class='LABELLEFT'>" + Third_Name_Prompt + "</td>");
								}
								else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
									out.println("<td  class='LABELLEFT'>" + Family_Name_Prompt + "</td>");
								}


								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
									out.println("<td  class='LABELLEFT'>"+ First_Name_Prompt + "</td>");
								}
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
									out.println("<td  class='LABELLEFT'>" + Second_Name_Prompt + "</td>");
								}
								else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
										if(Third_Name_Prompt==null)
											Third_Name_Prompt = "&nbsp";
									out.println("<td  class='LABELLEFT'>" + Third_Name_Prompt + "</td>");
								}
								else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
									out.println("<td  class='LABELLEFT'>" + Family_Name_Prompt + "</td>");
								}

								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
									out.println("<td  class='LABELLEFT'>"+ First_Name_Prompt + "</td>");
								}
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
									out.println("<td  class='LABELLEFT'>" + Second_Name_Prompt + "</td>");
								}
								else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
										if(Third_Name_Prompt==null)
											Third_Name_Prompt = "&nbsp";
										out.println("<td  class='LABELLEFT'>" + Third_Name_Prompt + "</td>");
								}
								else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
									if(Family_Name_Prompt==null)
										Family_Name_Prompt = "&nbsp";
									out.println("<td  class='LABELLEFT'>" + Family_Name_Prompt + "</td>");
								}


								if ( Name_Suffix_Accept_Yn.equals("Y") )
									out.println("<td  class='LABELLEFT'>"+Name_Suffix_Prompt+"</td>");

							*/	%>
<!-- 								</tr>
								<tr> -->

								<%/*
								if ( Name_Prefix_Accept_Yn.equals("Y") )
								{
										out.println("<td align='Left'>&nbsp;&nbsp;<Select name='name_prefix' id='name_prefix' tabIndex='14'>");

										out.println("<Option value=''>---&nbsp"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp---</option>");

									sql="Select Name_Prefix from Mp_Name_Prefix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1";
									rs2 = stmt2.executeQuery(sql);
									if (rs2 != null)
									{
										while( rs2.next() ) {
											out.println("<Option value=\"" + checkForNull(rs2.getString("Name_Prefix")) + "\">" + checkForNull(rs2.getString("Name_Prefix"))+"</option>");
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
										out.println("<td align='Left' ><input type='text' name='first_name' id='first_name' maxlength='15' size='15'  onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");

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
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 )
								{
									out.println("<td align='left' ><input type='text' name='second_name' id='second_name' maxlength='15' size='15'  onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");

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
									out.println("<td  align='Left'><input type='text' name='third_name' id='third_name' maxlength='15' size='15'  tabIndex='15'>");


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
									out.println("<td  align='Left'><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' tabIndex='15' onBlur=\"makeValidQueryCriteria(this);\">");
									if (pat_name_as_multipart_yn.equals("N"))
										out.println("<select name='searchby' id='searchby' disabled><option value=''  selected>--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- </option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");

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
									out.println("<td  align='Left'><input type='text' name='first_name' id='first_name' maxlength='15' size='15'  tabIndex='16' onBlur=\"makeValidQueryCriteria(this);\">");

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
									out.println("<td  align='Left'><input type='text' name='second_name' id='second_name' maxlength='15' size='15'  tabIndex='16' onBlur=\"makeValidQueryCriteria(this);\">");

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
									out.println("<td  align='Left'><input type='text' name='third_name' id='third_name' maxlength='15' size='15' tabIndex='16' onBlur=\"makeValidQueryCriteria(this);\">");

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
									out.println("<td align='Left'><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"'  size='"+family_name_length+"' tabIndex='16' onBlur=\"makeValidQueryCriteria(this);\">");
									if (pat_name_as_multipart_yn.equals("N"))
										out.println("<select name='searchby' id='searchby' disabled><option value='' selected>--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- </option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");

									if (Family_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y' ></input>");
									}
									else
									{
										out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
									}
									out.println("</td>");
								}

								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 )
								{
									out.println("<td  align='Left'><input type='text' name='first_name' id='first_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");

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
									out.println("<td  align='Left'><input type='text' name='second_name' id='second_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");

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
									out.println("<td  align='Left'><input type='text' name='third_name' id='third_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");

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
									out.println("<td  align='Left'><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");
									if (pat_name_as_multipart_yn.equals("N"))
										out.println("<select name='searchby' id='searchby' disabled><option value='' selected> --- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- </option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");

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
									out.println("<td  align='Left'><input type='text' name='first_name' id='first_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='18'>");

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
									out.println("<td  align='Left'><input type='text' name='second_name' id='second_name' maxlength='15' size='15' tabIndex='18' onBlur=\"makeValidQueryCriteria(this);\">");

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
									out.println("<td  align='Left'><input type='text' name='third_name' id='third_name' maxlength='15' size='15' tabIndex='18' onBlur=\"makeValidQueryCriteria(this);\">");

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
									out.println("<td  align='Left'><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' tabIndex='18' onBlur=\"makeValidQueryCriteria(this);\">");
									if (pat_name_as_multipart_yn.equals("N"))
										out.println("<select name='searchby' id='searchby' disabled><option value='' selected> --- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- </option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");

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
									out.println("<td  align='Left'><Select name='name_suffix' id='name_suffix' tabIndex='19'>");

									out.println("<Option value=''>&nbsp --- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- &nbsp</option>");

									sql="Select Name_Suffix from Mp_Name_Suffix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1";
									rs3 = stmt3.executeQuery(sql);
									if(rs3 != null ) {
										while(rs3.next()) {
											out.println("<Option value=\"" + checkForNull(rs3.getString("name_suffix")) + "\">" + checkForNull(rs3.getString("Name_Suffix"))+"</option>");
										}
									if(rs3!=null)	 rs3.close();
									if(stmt3!=null)	 stmt3.close();
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
								} */
			}
			catch(Exception e)
			{
				out.println(e);
			}
			finally
			{ 
								
				if(stmt1!=null)	 stmt1.close();
				if(stmt2!=null)	 stmt2.close();
				if(stmt3!=null)	 stmt3.close();

				if(rs1!=null)	 rs1.close();
				if(rs2!=null)	 rs1.close();
				if(rs3!=null)	 rs3.close();

				if(con != null)
				ConnectionManager.returnConnection(con,request);				
			}
								%>
<!-- 					</tr>
				</table>
 -->
			<script>
				//enableSearchby(document.forms[0].soundex);
			</script>




<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

