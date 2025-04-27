<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%

	Connection con 				= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs				=null;
	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String pat_name_as_multipart_yn	= "";
	String first_name_length 	= "";
	String second_name_length 	= "";
	String third_name_length 	= "";
	String family_name_length 	= "";
	String file_type_appl_yn 	= "";
	String errFlag				= "";
%>

	<html>
	<head>	
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>	
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eOA/js/PatientGroup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name="GroupSearchCriteria" id="GroupSearchCriteria" id="GroupSearchCriteria">
	<table cellpadding='1' cellspacing='1' width='100%' border='0'>
		<tr>
		<td class = 'label'  width = '10%' nowrap><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></td>
					<td width='10%' class='fields'>
						<input type="hidden" name="group_id" id="group_id" >
						<input type="hidden" name="min_patient" id="min_patient" id="min_patient" >
						<input type="hidden" name="max_patient" id="max_patient" id="max_patient" >	
						<input type="hidden" name="Existing_Group_Members" id="Existing_Group_Members" id="Existing_Group_Members" >
						<input type="hidden" name="group_location_id" id="group_location_id" id="group_location_id" >
						<input type="text" name="group_name" id="group_name" id="group_name" onblur='if(this.value!=""){callgroupname(this,document.forms[0].group_name,"insert")}else{clearValues("insert","document");}'><input type="button" name="group_name_lookup" id="group_name_lookup" value="?" class="button" onclick="callgroupname(this,document.forms[0].group_name,'insert')"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td>
		<td width='80%'  id="TdLocationResult"></td>
		</tr>
		<tr></tr>
		<tr></tr>
			
	</table>
	<%
		con = ConnectionManager.getConnection(request);
		String Qry_For_Param="SELECT   pat_name_as_multipart_yn, first_name_length, second_name_length,third_name_length,family_name_length FROM mp_param where module_id='MP'";
		pstmt = con.prepareStatement(Qry_For_Param);
	    rs=pstmt.executeQuery();
	   if(rs.next()){
			pat_name_as_multipart_yn	= checkForNull(rs.getString("pat_name_as_multipart_yn"));
			first_name_length 			= rs.getString("first_name_length");
			second_name_length			= rs.getString("second_name_length");
			third_name_length 			= rs.getString("third_name_length");
			family_name_length 			= rs.getString("family_name_length");
	    }else{
	        errFlag = "Y";
	        out.println("<script>alert(getMessage('MP_PARAM_NOT_FOUND','MP'));</script>");
	        out.println("<script>parent.window.close();</script>");         
	    }
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		String firstRowElement="";
		String firstRowCompleted ="";
	    String family_no_link_yn 			= "";
	    String family_no_prompt				= ""; 
	    String first_name_accept_yn 		= "";
	    int first_name_order				= 0;
	    String first_name_prompt 			= "";
	    String second_name_accept_yn 		= "";
	    int second_name_order				= 0;
	    String second_name_prompt 			= "";
	    String third_name_accept_yn			= "";
	    int third_name_order 				= 0;
	    String third_name_prompt 			= "";
	    String family_name_accept_yn 		= ""; 
	    int family_name_order 				= 0;
	    String family_name_prompt			= "";
	    int patient_id_length				= 0;
		String family_name_loc_lang_prompt	= "";
		String first_name_loc_lang_prompt	= "";
		String second_name_loc_lang_prompt	= "";
		String third_name_loc_lang_prompt	= "";
		String first_name_reqd_yn="";
		String second_name_reqd_yn="";
		String third_name_reqd_yn="";
		String family_name_reqd_yn="";
		
		 
		 
		 
		 try{
			 String Qry_For_Slct_Flds="SELECT param.family_no_link_yn,param.family_no_prompt,param.first_name_order, param.first_name_prompt,param.first_name_accept_yn,param.second_name_accept_yn, param.second_name_order,param.second_name_prompt, param.third_name_accept_yn,param.third_name_order, param.third_name_prompt,param.family_name_accept_yn, param.family_name_order,param.family_name_prompt, first_name_loc_lang_prompt,second_name_loc_lang_prompt, third_name_loc_lang_prompt,family_name_loc_lang_prompt, param.first_name_reqd_yn, param.second_name_reqd_yn, param.third_name_reqd_yn, param.family_name_reqd_yn  FROM   mp_param_lang_vw param WHERE  param.module_id = 'MP' AND param.language_id = ?";
			 pstmt = con.prepareStatement(Qry_For_Slct_Flds);
			 pstmt.setString(1,locale);
			 rs = pstmt.executeQuery();
             if (rs !=null){
                   if (rs.next()){
                      
	                 family_no_link_yn =rs.getString("family_no_link_yn")== null ?  "N" : rs.getString("family_no_link_yn");
	                 family_no_prompt =rs.getString("family_no_prompt")== null ? "Head of the Family" : rs.getString("family_no_prompt");
	              	
	                 first_name_accept_yn = rs.getString("first_name_accept_yn")==null ? "N" : rs.getString("first_name_accept_yn");
	                 first_name_order = rs.getInt("first_name_order");
	                 first_name_prompt = rs.getString("first_name_prompt")==null ? "First Name" : rs.getString("first_name_prompt");
	                
	                 second_name_accept_yn = rs.getString("second_name_accept_yn")==null ? "N" : rs.getString("second_name_accept_yn");
	                 second_name_order = rs.getInt("second_name_order");
	                 second_name_prompt = rs.getString("second_name_prompt")==null ? "Second Name" : rs.getString("second_name_prompt");
	                
	                 third_name_accept_yn = rs.getString("third_name_accept_yn")==null ? "N" : rs.getString("third_name_accept_yn");
	                 third_name_order = rs.getInt("third_name_order");
	                 third_name_prompt = rs.getString("third_name_prompt")==null ? "Third Name" : rs.getString("third_name_prompt");

					 first_name_loc_lang_prompt=checkForNull(rs.getString("first_name_loc_lang_prompt"));
					 second_name_loc_lang_prompt=checkForNull(rs.getString("second_name_loc_lang_prompt"));
					 third_name_loc_lang_prompt=checkForNull(rs.getString("third_name_loc_lang_prompt"));
					 family_name_loc_lang_prompt=checkForNull(rs.getString("family_name_loc_lang_prompt"));

                	 family_name_accept_yn = rs.getString("family_name_accept_yn")==null ? "N" : rs.getString("family_name_accept_yn");
                 	 family_name_order = rs.getInt("family_name_order");
                 	 
                 	first_name_reqd_yn=rs.getString("first_name_reqd_yn")==null ? "N" : rs.getString("first_name_reqd_yn");
                 	second_name_reqd_yn=rs.getString("second_name_reqd_yn")==null ? "N" : rs.getString("second_name_reqd_yn");
                 	third_name_reqd_yn=rs.getString("third_name_reqd_yn")==null ? "N" : rs.getString("third_name_reqd_yn");
                 	family_name_reqd_yn=rs.getString("family_name_reqd_yn")==null ? "N" : rs.getString("family_name_reqd_yn");
                 	 
              
					 if(pat_name_as_multipart_yn.equals("N")){
						family_name_order = 4;
					 }
					 family_name_prompt = rs.getString("family_name_prompt")==null ? "Family Name" : rs.getString("family_name_prompt");
                   }
               }
           }catch(Exception e) { 
			//out.println(e.toString());
			e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
			}
           finally
           {
               if (pstmt != null) pstmt.close();
               if (rs != null) rs.close();
               if(con!=null) ConnectionManager.returnConnection(con,request);
           }


		
	%>
	<div id="PatientSearchContainer" style="display:none;">
			 <table border="0" cellpadding="0" cellspacing="0" width="100%">
	              <tr>
	              	<td width='100%' class="BORDER" valign=top>
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
						
							<tr>
							<%
									
						
							if(pat_name_as_multipart_yn.equals("Y")){  
                                if ( first_name_accept_yn.equals("Y") && first_name_order ==1 ) {
                                	out.println("<td   width='25%' class='label'>" + first_name_prompt + "</td>");
                                    out.println("<td   width='25%' class='fields'><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'>");
									if(first_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");

									firstRowElement="Y";
                                }
                                else if ( second_name_accept_yn.equals("Y") && second_name_order ==1 ) {
                                    out.println("<td  width='25%' class='label'>" + second_name_prompt + "</td>");
                                    out.println("<td   width='25%' class='fields' ><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
									if(second_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
									firstRowElement="Y";
                                }
                                else if ( third_name_accept_yn.equals("Y") && third_name_order ==1 ) {
                                    out.println("<td   width='25%' class='label'>" + third_name_prompt + "</td>");
                                    out.println("<td    width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='15' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
									if(third_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
									firstRowElement="Y";
                                }
                                else if ( family_name_accept_yn.equals("Y") && family_name_order ==1 ) {
                                    out.println("<td   width='25%' class='label'>" + family_name_prompt + "</td>");
                                    out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
									if(family_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
									firstRowElement="Y";
                                }
                                if ( first_name_accept_yn.equals("Y") && first_name_order ==0 ) {
                                out.println("<input type='hidden' name='First_Name' id='First_Name' >");
                            }
                            else if ( second_name_accept_yn.equals("Y") && second_name_order ==0 ) {
                                out.println("<input type='hidden' name='Second_Name' id='Second_Name' >");
                            }
                            else if ( third_name_accept_yn.equals("Y") && third_name_order ==0 ) {
                                out.println("<input type='hidden' name='Third_Name' id='Third_Name' >");
                            }
                            else if ( family_name_accept_yn.equals("Y") && family_name_order ==0 ) {
                                out.println("<input type='hidden' name='Family_Name' id='Family_Name' >");
                                }
								 if ( first_name_accept_yn.equals("Y") && first_name_order ==2 ) {
                                    out.println("<td  width='25%' class='label'>" + first_name_prompt + "</td>");
                                    out.println("<td  width='25%' class='fields' ><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\">");
									if(first_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
									if(firstRowElement.equals("Y")){
										firstRowCompleted="Y";
									}else{
										firstRowElement="Y";
									}
                                }
                                else if ( second_name_accept_yn.equals("Y") && second_name_order ==2 ) {
                                    out.println("<td  width='25%' class='label'>" + second_name_prompt + "</td>");
                                    out.println("<td  width='25%' class='fields' ><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\">");
									if(second_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
									if(firstRowElement.equals("Y")){
										firstRowCompleted="Y";
									}else{
										firstRowElement="Y";
									}
                                }
                                else if ( third_name_accept_yn.equals("Y") && third_name_order ==2 ) {
                                    out.println("<td  width='25%' class='label'>" + third_name_prompt + "</td>");
                                    out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
									if(third_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
									if(firstRowElement.equals("Y")){
										firstRowCompleted="Y";
									}else{
										firstRowElement="Y";
									}
                                }
                                else if ( family_name_accept_yn.equals("Y") && family_name_order ==2 ) {
                                    out.println("<td   width='25%' class='label'>" + family_name_prompt + "</td>");
                                    out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\">");
									if(family_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
									if(firstRowElement.equals("Y")){
										firstRowCompleted="Y";
									}else{
										firstRowElement="Y";
									}
                                }
                               

								if ( first_name_accept_yn.equals("Y") && first_name_order ==3 ) {
									if(firstRowCompleted.equals("Y")){
										out.println("</tr><tr>");
									}
                                    out.println("<td   width='25%' class='label'>" + first_name_prompt + "</td>");
                                    out.println("<td   width='25%' class='fields'><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
									if(first_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");

									if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
										firstRowCompleted="Y";
									}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
										firstRowCompleted="N";
									}
                                }
                                else if ( second_name_accept_yn.equals("Y") && second_name_order ==3 ) {
									if(firstRowCompleted.equals("Y")){
										out.println("</tr><tr>");
									}
                                    out.println("<td  width='25%'  class='label'>" + second_name_prompt + "</td>");
                                    out.println("<td   width='25%' class='fields'><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\">");
									if(second_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");

									if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
										firstRowCompleted="Y";
									}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
										firstRowCompleted="N";
									}
                                }
                                else if ( third_name_accept_yn.equals("Y") && third_name_order ==3 ) {
									if(firstRowCompleted.equals("Y")){
										out.println("</tr><tr>");
									}
                                    out.println("<td  width='25%' class='label'>" + third_name_prompt + "</td>");
                                    out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
									if(third_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
									if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
										firstRowCompleted="Y";
									}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
										firstRowCompleted="N";
									}
                                }
                                else if ( family_name_accept_yn.equals("Y") && family_name_order ==3 ) {
									if(firstRowCompleted.equals("Y")){
										out.println("</tr><tr>");
									}
                                    out.println("<td   width='25%' class='label'>" + family_name_prompt + "</td>");
                                    out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
									if(family_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
									if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
										firstRowCompleted="Y";
									}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
										firstRowCompleted="N";
									}
                                }
                     
                                if ( first_name_accept_yn.equals("Y") && first_name_order ==4 ) {
									if(firstRowCompleted.equals("Y")){
										out.println("</tr><tr>");
									}
                                    out.println("<td  width='25%' class='label'>" + first_name_prompt + "</td>");
                                    out.println("<td   width='25%' class='fields' ><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
									if(first_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
                                }
                                else if ( second_name_accept_yn.equals("Y") && second_name_order ==4 ) {
									if(firstRowCompleted.equals("Y")){
										out.println("</tr><tr>");
									}
                                    out.println("<td  width='25%' class='label'>" + second_name_prompt + "</td>");
                                    out.println("<td   width='25%' class='fields'><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
									if(second_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
                                }
                                else if ( third_name_accept_yn.equals("Y") && third_name_order ==4 ) {
									if(firstRowCompleted.equals("Y")){
										out.println("</tr><tr>");
									}
                                    out.println("<td  width='25%' class='label'>" + third_name_prompt + "</td>");
                                    out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
									if(third_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
                                }
                               else
								  if ( family_name_accept_yn.equals("Y") && family_name_order ==4) {
								   if(firstRowCompleted.equals("Y")){
										out.println("</tr><tr>");
									}
                                    out.println("<td   width='25%' class='label'>" + family_name_prompt + "</td>");
                                    out.println("<td  width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
									if(family_name_reqd_yn.equals("Y")){
										out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("</td>");
									
							   }
							      else {
                                    out.println("<td   class='label'>&nbsp;</td>");
                                    out.println("<td   class='label'>&nbsp;</td>");
                                }
							}
							
							if (pat_name_as_multipart_yn.equals("N"))	
							{			out.println("<td nowrap  width='25%' class='label'>" + family_name_prompt + "</td>");
										out.println("<td  nowrap class='fields' width='25%'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);EnableSearchBy(this);'     style=\"text-align:left\">");
										if(family_name_reqd_yn.equals("Y")){
											out.println("<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
										}
										String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
										String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
										String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
										out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C'>"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
								}
									else
									out.println("</td>");
							%>
						
								</tr>
							<tr style="margin-top:5px;">
								<td  width='25%' class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
								<td  width='25%' class="fields"><Select name="Sex" id="Sex"><Option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option><Option value="M" ><fmt:message key="Common.male.label" bundle="${common_labels}"/></option><Option value="F" ><fmt:message key="Common.female.label" bundle="${common_labels}"/></option><option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option></Select><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
							
								<td  width='25%' class="label"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/> </td>
								<td  width='25%' class="fields"><input type="text" name="Dob" id="Dob" size="11"  onBlur="validDateObj(this,'DMY',localeName)" maxlength="10" ><img style="cursor='hand'" name='dobCal' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('Dob',null,null,true);" >
								&nbsp;&nbsp;</td>
							</tr> 
							<tr>
							 	<td  class='label' ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
                 			   	<td class='fields'><input type='text' name='MobileNo' id='MobileNo' maxlength='20' size='25'  onblur='makeValidString(this);' ></td>
								<td class='button' colspan='1' width='25%' align="right" ><input type="button" class='button' name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callSearchResult()"><input type="button" class='button' name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearAll()" sgtyle="float:right;!important"></td>
							</tr>
							<tr>
								
							</tr>
						</table>
					</td>
	              </tr>
	          </table>
	          
	   	</div>   
	   	<input type="hidden" name="first_name_reqd_yn" id="first_name_reqd_yn" value ="<%=first_name_reqd_yn%>"/>
		<input type="hidden" name="second_name_reqd_yn" id="second_name_reqd_yn" value ="<%=second_name_reqd_yn%>"/>
		<input type="hidden" name="third_name_reqd_yn" id="third_name_reqd_yn" value ="<%=third_name_reqd_yn%>"/>
		<input type="hidden" name="family_name_reqd_yn" id="family_name_reqd_yn" value ="<%=family_name_reqd_yn%>"/>   
		<input type="hidden" name="first_name_prompt" id="first_name_prompt" value ="<%=first_name_prompt%>"/>
		<input type="hidden" name="second_name_prompt" id="second_name_prompt" value ="<%=second_name_prompt%>"/>
		<input type="hidden" name="third_name_prompt" id="third_name_prompt" value ="<%=third_name_prompt%>"/>
		<input type="hidden" name="family_name_prompt" id="family_name_prompt" value ="<%=family_name_prompt%>"/>
	</form> 

<script>


function clearAll(){
	/*$('[name="First_Name"]').val('');
	$('[name="Second_Name"]').val('');
	$('[name="Third_Name"]').val('');
	$('[name="Family_Name"]').val('');
	$('[name="Dob"]').val('');
	$('[name="Sex"]').val('');
	$('[name="MobileNo"]').val('');*/
	parent.frames[2].location.href ="../../eCommon/html/blank.html";
}

function callSearchResult(){
	var First_Name = "";
	var error="";
	if(document.forms[0].First_Name){
		First_Name= document.forms[0].First_Name.value;
		if(document.forms[0].first_name_reqd_yn.value=='Y' && First_Name==""){
			error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$',document.forms[0].first_name_prompt.value);
			alert(error);
			return false;
		}

	}
	var Second_Name = "";
	if(document.forms[0].Second_Name){
		Second_Name= document.forms[0].Second_Name.value;
		if(document.forms[0].second_name_reqd_yn.value=='Y' && Second_Name==""){
			error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$',document.forms[0].second_name_prompt.value);
			alert(error);
			return false;
		}
	}
	var Third_Name = "";
	if(document.forms[0].Third_Name){
		Third_Name= document.forms[0].Third_Name.value;
		if(document.forms[0].third_name_reqd_yn.value=='Y' && Third_Name==""){
			error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$',document.forms[0].third_name_prompt.value);
			alert(error);
			return false;
		}
	}
	var Family_Name = "";
	if(document.forms[0].Family_Name){
		Family_Name= document.forms[0].Family_Name.value;
		if(document.forms[0].family_name_reqd_yn.value=='Y' && Family_Name==""){
			error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$',document.forms[0].family_name_prompt.value);
			alert(error);
			return false;
		}
	}

	var Dob = document.forms[0].Dob.value;
	var Sex = document.forms[0].Sex.value;
	if(Sex==""){
		error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("Common.gender.label","Common"));
		alert(error);
		return false;
		
	}
	
	
	var MobileNo	= document.forms[0].MobileNo.value;
	var GroupId	= document.forms[0].group_id.value;
	var Existing_Group_Members	= document.forms[0].Existing_Group_Members.value;
	var group_location_id	= document.forms[0].group_location_id.value;
	var max_patient	= document.forms[0].max_patient.value;

	
	/*if(First_Name=="" && Second_Name=="" && Third_Name=="" && Family_Name=="" && Dob=="" && Sex=="A" && MobileNo==""){
		alert(getMessage("ATLEAST_ONE_SELECTED", "common"));
		return;
	}*/
		parent.frames[2].location.href = "../../eOA/jsp/PatientGroupResult.jsp?First_Name="+First_Name+"&Second_Name="+Second_Name+"&Third_Name="+Third_Name+"&Family_Name="+Family_Name+"&Dob="+Dob+"&Sex="+Sex+"&MobileNo="+MobileNo+"&GroupId="+GroupId+"&Existing_Group_Members="+Existing_Group_Members+"&group_location_id="+group_location_id+"&max_patient="+max_patient+"&mode=insert";
}
function ChangeInitCase(obj){
	
  var name=obj.value;
  var spltval = name.split(" ") ;
  var temp_name = ""
 for(var i=0;i<spltval.length;i++) {
  var length= obj.value.length;
  var letter = spltval[i].substring(0,length-(length-1));
  var rest = spltval[i].substring(1,length);
  letter=letter.toUpperCase();
  rest=rest.toLowerCase();
  var  namenow= letter.concat(rest);
  temp_name+= namenow+" ";
 }
 obj.value= temp_name.substring(0,temp_name.length-1);

}
</script>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</body>
</html>

