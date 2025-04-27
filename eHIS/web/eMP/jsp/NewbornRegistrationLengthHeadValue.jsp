<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.HashMap,java.util.Properties, java.util.ArrayList, java.text.SimpleDateFormat, com.ehis.util.*, webbeans.eCommon.ConnectionManager,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
Properties p		= (java.util.Properties) session.getValue("jdbc");
Connection con	= null;
HashMap hashMap					= new HashMap();
ArrayList array_list			= new ArrayList();
String new_function_id			= checkForNull(request.getParameter("new_function_id"));
String function_id			= checkForNull(request.getParameter("function_id"));
String hij_appl_YN			= checkForNull(request.getParameter("hij_appl_YN"));
String q_no_of_birth1			= checkForNull(request.getParameter("q_no_of_birth"));
int q_no_of_birth			= Integer.parseInt(q_no_of_birth1);
String MC_Dtls_YN			= checkForNull(request.getParameter("MC_Dtls_YN"));
String ca_no_of_births			= checkForNull(request.getParameter("ca_no_of_births"));
String q_birth_order			= checkForNull(request.getParameter("q_birth_order"));
String dis_all_mother_dtls			= checkForNull(request.getParameter("dis_all_mother_dtls"));
String ca_delivery_type			= checkForNull(request.getParameter("ca_delivery_type"));
String nb_mother_dtls_update_yn			= checkForNull(request.getParameter("nb_mother_dtls_update_yn"));
String finalizeYN			= checkForNull(request.getParameter("finalizeYN")); 
String motherid			= checkForNull(request.getParameter("motherid")); 
String flag1			= checkForNull(request.getParameter("flag")); 
int flag			= Integer.parseInt(flag1);
String BDVallnew = "" , cd1 = "" , cd2 = "" , birth_date = "" , current_date = "" , dofbirthdis = "" , dofbirthvalue = "" , birth_time = "" ,multidisabled 	= "", multibirthvalue = "N", multi_check = "";
try{
con = ConnectionManager.getConnection(request);	
hashMap	= eMP.NewbornDetails.getNewbornData(motherid, con, p);
%>
<table width="100%" border = '0'>
				<tr>
					<td class='label'  width='15%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					<td class='fields' width="15%"><select name="new_born_sex" id="new_born_sex" onChange="getNewBornRegnValues(this.name),getRelationShip(this)">
					<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
	                <option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
		            <option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
			        <option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
					</select><img align=center src='../../eCommon/images/mandatory.gif' id='new_born_sex_MandImg'></img></select>
					<%	
							if(!new_function_id.equals("REGISTER_NEWBORN")){%>
						<script>
							document.forms[0].new_born_sex.value = "<%=checkForNull((String)hashMap.get("q_nb_sex"))%>";
							document.forms[0].new_born_sex.disabled = true;
						</script>
					<%}%>
					</td>
					<td class='label' width="15%"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
					<td class='fields' width="15%">
					  <%   
						if ( new_function_id.equals("REGISTER_NEWBORN") || new_function_id.equals("MAINTAIN_BIRTH") )
						{
							if ( new_function_id.equals("REGISTER_NEWBORN")  )
							{
								BDVallnew=cd1+"*"+cd2;
								birth_date=current_date;
								dofbirthdis="";
							}
							else
							{
								dofbirthdis="disabled";
								BDVallnew = cd1+"*"+ cd2;
								dofbirthvalue=(checkForNull((String) hashMap.get("q_date_of_birth")));	
								if(dofbirthvalue!=null || !dofbirthvalue.equals("")) {
									StringTokenizer st_date = new StringTokenizer(dofbirthvalue," ");
									if(st_date.hasMoreTokens()) {
										birth_date = st_date.nextToken();
										birth_time = st_date.nextToken();
									}									
								}
							}
					}
					if(!dofbirthvalue.equals(""))
						dofbirthvalue=DateUtils.convertDate(dofbirthvalue,"DMYHM","en",localeName);				
					if(!birth_date.equals(""))
						birth_date=DateUtils.convertDate(birth_date,"DMY","en",localeName);				
					%>
					<input id="dateofbirth" type='text' name='birth_date' id='birth_date' size='8' maxlength='10' <%=dofbirthdis%> value='<%=birth_date%>' onkeypress="return Valid_DT(event)" onblur="validateDate(this);calc_hij(this);" ><img src='../../eCommon/images/CommonCalendar.gif' name='nb_calander'  onClick="document.forms[0].birth_date.select();return showCalendar('dateofbirth','','','');" >
					<img align=center src='../../eCommon/images/mandatory.gif'></img></td>
					<td class='label'  width='15%'>
					<fmt:message key="eMP.Birth.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/>
					</td>
					<td class='fields' width="15%"><input type='text' name='birth_time' id='birth_time' size='5' maxlength='5' <%=dofbirthdis%> value='<%=birth_time%>' onkeypress="return Valid_TM(event)" onblur="validateTime(this)"><img align='center' src='../../eCommon/images/mandatory.gif'>
					<input type = 'hidden' name = 'date_of_birth' value = '<%=dofbirthvalue%>'> 
				    <input type='hidden' name='hij_appl_YN' id='hij_appl_YN' value='<%=hij_appl_YN%>'>
					<input type='hidden' name='invalid_dob' id='invalid_dob' value='N'>
					<input type='hidden' name='date_of_birth_hjiri' id='date_of_birth_hjiri' value="<%=checkForNull((String )hashMap.get("hijri_birth_date"))%>">
					<%if(hij_appl_YN.equals("Y")){ %> 
					&nbsp;<img id='imgdateofbirth_hj' src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].date_of_birth_hj.select();return showCalendar_hj('dateofbirth_hj','','','');"  <%=dofbirthdis%>><input type='text' name='date_of_birth_hj' id='date_of_birth_hj' id='dateofbirth_hj' maxlength='10' size='8' onblur='convertToGD(this);' value="<%=checkForNull((String )hashMap.get("hijri_birth_date"))%>" <%=dofbirthdis%>><fmt:message key="eMP.Hijri.label" bundle="${mp_labels}"/>
				    <script>calc_hij(document.NewbornRegistration_form.birth_date);</script><%}%>
					</td>
					</tr>
					<tr>
		<td class='label'  ><fmt:message key="eMP.MultipleBirth.label" bundle="${mp_labels}"/></td>
		<td class='fields' >
		<%  
		if(function_id.equals("REGISTER_NEWBORN")){
			 if(flag==1)
			 {
				 multi_check="checked";
				 multibirthvalue="Y";
				 multidisabled="disabled";
			 }
		}else{
			 if(checkForNull((String) hashMap.get("q_multiple_birth_yn")).equals("Y")) {
				 multibirthvalue="Y";
				 multi_check="checked";
			   }
			  multidisabled="disabled";
		   }
			if(function_id.equals("REGISTER_NEWBORN")){
				if(q_no_of_birth==0)
					q_no_of_birth=1;
				if(MC_Dtls_YN.equals("Y") && !ca_no_of_births.equals("")){
					q_no_of_birth=Integer.parseInt(ca_no_of_births);
					if(q_no_of_birth > 1){
						multi_check="checked";
					}
				}
			}
		%>
	   <input type="checkbox" name="multiple_birth_yn" id="multiple_birth_yn" onClick='enableBirthField(this);' value='<%=multibirthvalue%>' <%=multi_check%> <%=multidisabled%> <%if(MC_Dtls_YN.equals("Y")){%>disabled<%}%>></td>
		<td class='label'  ><fmt:message key="Common.NoofBirths.label" bundle="${common_labels}"/></td>
		<%if(function_id.equals("REGISTER_NEWBORN")){
			String noofbirthvisibible="visibility:hidden";
			if(flag==1)
			{
				noofbirthvisibible="visibility:visible";
			}
			%>
			<td class='fields'  >
			<input type="text" name="noOfBirths" id="noOfBirths"  value='<%=q_no_of_birth%>' maxlength=1 size=1 onBlur="makeValidString(this);getNewBornRegnValues(this.name); setNum(this); return allowValidNumber(this,'event',1,0);" disabled>
			<font id='img1'><img align=center src='../../eCommon/images/mandatory.gif' style='<%=noofbirthvisibible%>'></font>
		  </td>
		  <input type="hidden" name="birth_order" id="birth_order" value='<%=q_birth_order%>'>
		  <%}else{%>
			<td class='querydata'><%=(String) hashMap.get("q_no_of_birth")%><input type="hidden" name="noOfBirths" id="noOfBirths" value="<%=(String) hashMap.get("q_no_of_birth")%>"></td>
			<input type="hidden" name="birth_order" id="birth_order" value='<%=(String) hashMap.get("q_birth_order")%>'>
			<%}%>
			<td class='label'><fmt:message key="eMP.DeliveryType.label" bundle="${mp_labels}"/></td>
				<td><select name="nod_type" id="nod_type" onChange='enDisCompls(this.value,"Y")'<%=dis_all_mother_dtls%> <%if((!ca_delivery_type.equals("")) && (!nb_mother_dtls_update_yn.equals("Y")) ||(finalizeYN.equals("Y"))&&(ca_no_of_births.equals(""))){%>disabled<%}%>>
				<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------
				<%
				array_list = eMP.NewbornDetails.getNodeTypeShortDesc(con,p);
				for(int i=0;i<array_list.size();i+=3) {
					if(ca_delivery_type.equals((String)array_list.get(i))){
						out.println("<option value=\""+(String)array_list.get(i)+"$"+(String)array_list.get(i+2)+"\" selected>"+(String) array_list.get(i+1)+"</option>");
					}else{
						out.println("<option value=\""+(String)array_list.get(i)+"$"+(String)array_list.get(i+2)+"\">"+(String) array_list.get(i+1)+"</option>");
					} 				
				}
				%>
				</select><img align=center src='../../eCommon/images/mandatory.gif' id='DeliveryTypeMandImg'></img>
			    <%if(!function_id.equals("REGISTER_NEWBORN")){%>
			     <script>
					<%
						if((!checkForNull((String) hashMap.get("q_nod_type")).equals("")) && (!checkForNull((String) hashMap.get("q_delivery_indicator")).equals(""))){
					%>
						document.forms[0].nod_type.value="<%=checkForNull((String) hashMap.get("q_nod_type"))%>"+"$"+"<%=checkForNull((String) hashMap.get("q_delivery_indicator"))%>";
					<%}%>
				</script>
				<%}%>	
			</td>
			</tr>
			</table>
<%}catch(Exception e){e.printStackTrace();
}finally{if(con!=null) ConnectionManager.returnConnection(con,request);} %>
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

