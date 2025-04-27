
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
	<script language="javascript" src="../../eOA/js/TransferCancelAppointment.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>
	<%
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css'  href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null;
	//Statement stmt2   	= null ;
	PreparedStatement pstmt =null;
	ResultSet rSet   	= null;
	//boolean allow_inside=true;
	String fac_id    	= (String) session.getValue( "facility_id" ) ;	
	String Alt_Id1 = "" ;
   	String Alt_Id2 = "" ;
        String Alt_Id3 = "" ;
    String Alt_Id4 = "" ;
	
	int nat_id_length =0;
	int alt_id1_length =0;
    int alt_id2_length =0;
    int alt_id3_length =0;
    int alt_id4_length =0;
	
	String accept_national_id_no_yn = "N";
	String ext_system_interface_yn="";
	String nat_data_source_id="";
	String nat_id_check_digit_id="";
	String nat_id_accept_alphanumeric_yn = "N";
	String nat_id_prompt ="";
	

	String called_for=request.getParameter("called_for");
	if(called_for==null) called_for="";
	String function_id=request.getParameter("function_id");
	if(function_id ==null) function_id="";
	String functionid=request.getParameter("functionid");
	if(functionid ==null) functionid="";
	String locale=(String)session.getAttribute("LOCALE");
	String pat_name_as_multipart_yn = "";
	String pat_name_length = "";
	String oper_stn_id=request.getParameter("oper_stn_id");
	String currentdate=request.getParameter("currentdate");
	String canc_appt_yn=request.getParameter("canc_appt_yn");
	if(canc_appt_yn.equals("") ) canc_appt_yn="N";
	String tfr_appt_yn=request.getParameter("tfr_appt_yn");
	if(tfr_appt_yn.equals("") ) tfr_appt_yn="N";
	String sysdate1="";
	/*Below Line Added for this CRF [Bru-HIMS-CRF-0166]*/
	String resch=request.getParameter("resch")==null?"":request.getParameter("resch");
%>
<%
	try{
		con = ConnectionManager.getConnection(request);
		
		Boolean isSearchDurLimitAppl =eCommon.Common.CommonBean.isSiteSpecific(con, "OA","OPPTMNT_DUR_LIMIT");//Added by Shanmukh on 15th-MAY-2018 for ML-MMOH-CRF-1134  
		//stmt2	= con.createStatement();
		/*String str="select to_char(sysdate+2,'dd/mm/yyyy') sysdate1 from dual";

		rs=stmt2.executeQuery(str);
		if(rs!=null){
		if(rs.next()){
		sysdate1 =rs.getString("sysdate1");

		}
		}*/
		
		//if(allow_inside){
			if(called_for.equals("")){
	
				if( tfr_appt_yn.equals("N") || canc_appt_yn.equals("N")){%>
					<script>alert(getMessage('NO_TRFR_APPT_OPER','OA'));
					parent.frames[0].document.location.href='../../eCommon/jsp/home.jsp?called_from=CA';
					</script>
				<%
				}
			}else{
				tfr_appt_yn =request.getParameter("book_appt_yn"); 
				 if(tfr_appt_yn.equals("")){
					 tfr_appt_yn="N";
				 }
				if(tfr_appt_yn.equals("N")){%>
					<script>alert(getMessage('SCH_NOT_ALLOW','OA'));
						parent.frames[0].document.location.href='../../eCommon/jsp/home.jsp';
					</script>
				<%}
			}
		int pat_id_len=0;
		pstmt=con.prepareStatement("Select Patient_Id_Length,Nat_Id_Length,alt_id1_length, pat_name_as_multipart_yn,(select to_char(sysdate+2,'dd/mm/yyyy') from dual)sysdate1 from mp_param where module_id='MP'");
		rSet=pstmt.executeQuery();
		if( rSet !=null && rSet.next()){
			pat_id_len=rSet.getInt("Patient_Id_Length");	
			pat_name_as_multipart_yn = rSet.getString("pat_name_as_multipart_yn");
			sysdate1 =rSet.getString("sysdate1"); 
			sysdate1=DateUtils.convertDate(sysdate1,"DMY","en",locale);
		}

		if (pat_name_as_multipart_yn.equals("N")){
			//pat_name_size = "58";
			pat_name_length = "60";
		}else{
			//pat_name_size = "40";
			pat_name_length = "40";
		}
		
		/*Query For Other Alt ID Type Drop Down*/

		String Qry_For_AltType = "SELECT alt_id_type,nvl((select desc1_value from SM_OTH_LANG_DATA_SKEY where table_id ='MP_ALTERNATE_ID_TYPE' and language_id =? and pk_value=mp_alternate_id_type.alt_id_type),SHORT_DESC) SHORT_DESC FROM mp_alternate_id_type WHERE alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM where module_id='MP'  UNION SELECT NVL(alt_id2_type,1) FROM MP_PARAM where module_id='MP'  UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM where module_id='MP') and eff_status='E' order by 2";

		try{
		String Qry_For_Slct_Flds="SELECT param.alt_id1_pat_sch_exact_yn,param.alt_id2_pat_sch_exact_yn,param.alt_id3_pat_sch_exact_yn,param.alt_id4_pat_sch_exact_yn,NVL (param.nat_id_prompt, 'National ID No') nat_id_prompt,param.nat_data_source_id, param.nat_id_check_digit_id,param.patient_id_length, param.nat_id_length, param.family_no_link_yn,param.family_no_prompt, param.first_name_accept_yn,param.first_name_order, param.first_name_prompt,param.second_name_accept_yn, param.second_name_order,param.second_name_prompt, param.third_name_accept_yn,param.third_name_order, param.third_name_prompt,param.family_name_accept_yn, param.family_name_order,param.family_name_prompt, first_name_loc_lang_prompt,second_name_loc_lang_prompt, third_name_loc_lang_prompt,family_name_loc_lang_prompt, param.alt_id1_accept_alphanumeric_yn,param.alt_id1_type,mp_get_desc.mp_alternate_id_type(param.alt_id1_type,param.language_id,'1') alt_id1_desc,param.alt_id2_type,mp_get_desc.mp_alternate_id_type(param.alt_id2_type,param.language_id,'1') alt_id2_desc,param.alt_id3_type,mp_get_desc.mp_alternate_id_type(param.alt_id3_type,param.language_id,'1') alt_id3_desc,param.alt_id4_type,mp_get_desc.mp_alternate_id_type(param.alt_id4_type,param.language_id,'1') alt_id4_desc,param.alt_id1_length,param.alt_id2_length, param.alt_id3_length, param.alt_id4_length,param.addl_field1_prompt, param.addl_field1_length,param.addl_field2_prompt, param.addl_field2_length, addl_field3_prompt,addl_field3_length, param.addl_field4_prompt, param.addl_field4_length,param.addl_field5_prompt, param.addl_field5_length,param.accept_national_id_no_yn, param.nat_id_accept_alphanumeric_yn,param.ext_system_interface_yn, param.accept_oth_alt_id_yn,names_in_oth_lang_yn,name_dervn_logic FROM   mp_param_lang_vw param WHERE  param.module_id = 'MP' AND param.language_id = ?";		
		
		pstmt = con.prepareStatement(Qry_For_Slct_Flds);
		pstmt.setString(1,locale);
		rSet = pstmt.executeQuery();
         if (rSet !=null){
        if (rSet.next())
        {
		Alt_Id1 = rSet.getString("alt_id1_desc")==null?"Alt ID No":rSet.getString("alt_id1_desc");
        Alt_Id2 = rSet.getString("alt_id2_desc")==null?"":rSet.getString("alt_id2_desc");
        Alt_Id3 = rSet.getString("alt_id3_desc")==null?"":rSet.getString("alt_id3_desc");
        Alt_Id4 = rSet.getString("alt_id4_desc")==null?"":rSet.getString("alt_id4_desc");
											
        alt_id1_length = rSet.getInt("alt_id1_length");
        alt_id2_length = rSet.getInt("alt_id2_length");
        alt_id3_length = rSet.getInt("alt_id3_length");
        alt_id4_length = rSet.getInt("alt_id4_length");
		nat_id_length = rSet.getInt("Nat_Id_Length");
		
		accept_national_id_no_yn = rSet.getString("accept_national_id_no_yn");
		if (accept_national_id_no_yn==null) accept_national_id_no_yn = "N";
		
		ext_system_interface_yn = rSet.getString("ext_system_interface_yn");
		
		nat_data_source_id = rSet.getString("nat_data_source_id");
		
		nat_id_check_digit_id = rSet.getString("nat_id_check_digit_id");
		
		nat_id_accept_alphanumeric_yn = rSet.getString("nat_id_accept_alphanumeric_yn");
		if (nat_id_accept_alphanumeric_yn==null) nat_id_accept_alphanumeric_yn = "N";
		
		 nat_id_prompt = rSet.getString("Nat_Id_Prompt");
         if (nat_id_prompt==null) nat_id_prompt = "";
		
        }
        }
		}catch(Exception e) { out.println(e.toString());}
         finally
        {
        if (pstmt != null) pstmt.close();
        if (rSet != null) rSet.close();
        }


%>

</head>
<body OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()' onload='disableFields()'>
<form name="QueryApptForPatient" id="QueryApptForPatient">
<table width='100%' cellspacing='1' cellpadding='1' border='0'>
<%if(function_id.equals("") && !called_for.equals("Link")) {%>
<tr>
<td  class=label  nowrap width='22%'><fmt:message key="eOA.SearchWith.label" bundle="${oa_labels}"/></td>
			
			<td class='fields' nowrap width='25%' colspan='3'><select name='sel_with' id='sel_with'  onchange ="CheckMandatory(this)">
			<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
			<option value='W'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
			</select><img  src="../../eCommon/images/mandatory.gif" align='center'></img>
</tr>
<%}%>
<tr>
	<td nowrap class=label ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>

	<td class='fields'>
			<select name='b_loc1' id='b_loc1' onchange='populatepract(this)' nowrap>
			<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>

				<%
					if(pstmt!=null)	pstmt.close();					
					if(rSet!=null) rSet.close();
					//pstmt=con.prepareStatement("select locn_type, short_desc, CARE_LOCN_TYPE_IND from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') and language_id = ? order by short_desc");
					pstmt=con.prepareStatement("select locn_type, am_get_desc.am_care_locn_type(locn_type,?,2) short_desc, CARE_LOCN_TYPE_IND from am_care_locn_type where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') order by short_desc");
					pstmt.setString(1,locale);
				rSet=pstmt.executeQuery();
				while(rSet!=null && rSet.next()) {
				%>
					<option value='<%=rSet.getString("CARE_LOCN_TYPE_IND")%>'><%=rSet.getString("short_desc")%>
				<%}%>		
			</select>

	<td nowrap class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

	<td class='fields'>
	<input type='text' name='b_loc_val' id='b_loc_val' value='' onblur='ena_loc_lookup(this);' size=22 maxlength=30 ><input type='button' value='?' onclick='open_loc_lookup();' class='button' name='b_loc_search' id='b_loc_search'>
	<input type="hidden" name="b_loc" id="b_loc" value="">
	<!--<select name='b_loc' id='b_loc' onChange = 'enablepract(this)' >
			<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
			</select>-->
	</td>
</tr>		

<tr id='resource_part'><jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from_page" value= "transfer_cancel" />
					<jsp:param name ="function_id" value= "<%=function_id%>" /></jsp:include>
<%if(function_id.equals("")) {%>
<tr>
		<td  class='Label' nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>

        <td class='fields' >
         <input type='text' name='b_appt_ref_no' id='b_appt_ref_no' size='8' maxlength='8' value=''></input>
        </td>

		<td  nowrap class=label ><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>

		<td  class=fields nowrap>
		<input type='text'  name='b_from_date' id='b_from_date' size='8' maxlength='10' Onblur='validate_date_from(this,b_to_date);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].b_from_date.select();return showCalendar('b_from_date');" tabindex=-1>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text'  name='b_to_date' id='b_to_date' size='8' maxlength='10' Onblur='validate_date_to(this,b_from_date);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].b_to_date.select();return showCalendar('b_to_date');" tabindex=-1><img id='dategif' src="../../eCommon/images/mandatory.gif"  align='center'></img>
</tr>
<%}else{%>
<tr>
		<td  class='Label' nowrap><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></td>

        <td class='fields'>
				<input type='text' name='reason_code_cancel' id='reason_code_cancel' value='' onblur='if(this.value !="") reasonlookup()' size=30 maxlength=30 ><input type='button' value='?' onclick='reasonlookup();' class='button' name='reasonclick' id='reasonclick'><img src='../../eCommon/images/mandatory.gif'></img>
				<input type='hidden' name='reason_for_cancellation' id='reason_for_cancellation' value=''></td>

		<td  nowrap class=label ><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>

		<td  class=fields nowrap>
		<input type='text'  name='b_from_date' id='b_from_date' size='8' maxlength='10' Onblur='validate_date_from(this,b_to_date);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].b_from_date.select();return showCalendar('b_from_date');" tabindex=-1>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text'  name='b_to_date' id='b_to_date' size='8' maxlength='10' Onblur='validate_date_to(this,b_from_date);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].b_to_date.select();return showCalendar('b_to_date');" tabindex=-1><img src="../../eCommon/images/mandatory.gif"     align='center'></img>
</tr>
<%}%>
<%if(function_id.equals("")) {%>
<tr>
		<td class=label  nowrap width='24%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			
		<td class='fields' width='24%'><input type='text' name='b_patient_id' id='b_patient_id' size='<%=pat_id_len%>' maxlength='<%=pat_id_len%>' onBlur="ChangeUpperCase(this);" ><input type='button' name="search" id="search" value="?" onClick="patqry()" class='button'><img  id='patientMan' align='center'  src="../../eCommon/images/mandatory.gif" style="visibility:hidden"></img></td>

		<td class=label  nowrap width='24%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>

		<td class='fields'><input type='text' name='b_patient_name' id='b_patient_name' size='50' maxlength='<%=pat_name_length%>'></td>	
</tr>
<tr>									
		<td nowrap align='left' class="label" nowrap><%=nat_id_prompt%></td>
		
		<td align="left" width="15%"><input type="text" name="National_Id_No" size="<%=nat_id_length%>" maxlength="<%=nat_id_length%>" 
		onkeypress="return"	onBlur='makeValidQueryCriteria(this);validateID(this,"<%=nat_id_check_digit_id%>");check_clear();' tabindex=1>
		</td>
			
		<td  width='25%' class="label"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/> </td>
							
		<td  width='25%' class="fields"><input type="text" name="Dob" size="11" id='dateofbirth' onBlur="validDateObj(this,'DMY',localeName)" maxlength="10" ><img style="cursor='hand'" name='dobCal' src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms(0).Dob.select(); return showCalendar('dateofbirth',null,null,true);" >
								
		&nbsp;&nbsp;<Select name="By" ><Option value="D" Selected><fmt:message key="Common.date.label" bundle="${common_labels}"/><Option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></Select></td> 
		
</tr>
<tr>
		<%if(!Alt_Id1.equals("")){%>							 
		<td  width='25%' class="label"><%=Alt_Id1%></td>
		<td  width='25%' class="fields" ><input type="text" name="Alt_Id1_No" size="25" maxlength="<%=alt_id1_length%>" value='' onKeyPress='return CheckForSpeclChars(event,"Alt_Id1")'onFocus="MoveFocus(2)" onBlur="makeValidQueryCriteria(this);AdnvcenableSuffix()"  ><input type="hidden" name="Expiry_Date1" size="8" maxlength="10"  onFocus="MoveFocus(1)">
		<input type="hidden" name="newborn_suffix" size='1' onKeyPress="return allowValidNumber(this,event,2,0);" onBlur="makeValidQueryCriteria(this);"
								maxlength='2'  disabled></td>
        <%}%>
		<%if(!Alt_Id2.equals("")){%>   
		<!--below code change done for SRR20056-SCF-12671-->
		<td  width='25%' class="label"><%=Alt_Id2%></td>
		<td  width='25%' class="fields"><input type="text" name="Alt_Id2_No" size="25" maxlength="<%=alt_id2_length%>" value='' onKeyPress='return altID234Validations(event)' onBlur="makeValidQueryCriteria(this)" onFocus="MoveFocus(2)" ><input type="hidden" name="Expiry_Date2" size="8" maxlength="10"  onFocus="MoveFocus(1)"></td>
		<%}%>
</tr>
<tr>
		<%if(!Alt_Id3.equals("")){%>   
		<!--below code change done for SRR20056-SCF-12671-->
		<td  width='25%' class="label"><%=Alt_Id3%></td>
		<td  width='25%' class="fields"><input type="text" name="Alt_Id3_No" size="25" value='' maxlength="<%=alt_id3_length%>" onKeyPress='return altID234Validations(event)' onBlur="makeValidQueryCriteria(this)" onFocus="MoveFocus(2)" ><input type="hidden" name="Expiry_Date3" size="8" maxlength="10"  onFocus="MoveFocus(1)"></td>
		<%}%>
		<%if(!Alt_Id4.equals("")){%>
		<!--below code change done for SRR20056-SCF-12671-->
		<td  width='25%' class="label"><%=Alt_Id4%></td>
							
		<td  width='25%' class="fields"><input type="text" name="Alt_Id4_No" size="25" maxlength="<%=alt_id4_length%>" value='' onKeyPress='return altID234Validations(event)' onBlur="makeValidQueryCriteria(this)" onFocus="MoveFocus(2)" ><input type="hidden" name="Expiry_Date4" size="8" maxlength="10"  onFocus="MoveFocus(1)" ></td>
		<%}%>
</tr>
<tr>
<td  width='25%' class="label" ><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></td>
								
								<td  width='25%' class="fields" ><select onchange='enableOtherAltId(this.value)' name='other_alt_id' ><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----

								<%
									
									pstmt = con.prepareStatement(Qry_For_AltType);
									pstmt.setString(1,locale);
									rSet = pstmt.executeQuery();	
									
									if(rSet != null){
										while (rSet.next()){          
											out.println ( "<Option value=\""+rSet.getString("alt_id_type")+"\" >"+rSet.getString("SHORT_DESC")+"</Option>" ) ;
										}
									}	
								%>
								</select></td>
								
								<td  class=label  width='25%'><fmt:message key="eMP.OtherAltNo.label" bundle="${mp_labels}"/></td>
								<td class=fields  width='25%'>
								<!--<input type ='text' name = 'other_alt_Id_no' value="" size='25' maxlength='20' disabled onKeyPress="return CheckForSpecChars(event)">-->
								<input type ='text' name = 'other_alt_Id_no' value="" size='25' maxlength='20' disabled>
								
								</td>
</tr>

<%if(function_id.equals("") && !called_for.equals("Link")) {%>

<tr>

		<td  nowrap class=label ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		
		<td  class=fields nowrap>
			<select name='b_gender' id='b_gender'>
			<option value=''>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --
			<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
			<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
			</select>
		</td>
			

		<td  nowrap class=label ><fmt:message key="Common.dayofweek.label" bundle="${common_labels}"/></td>

			<td  class='fields' nowrap>
			<select name='day_of_week' id='day_of_week'>
			<option value=''>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --
			<option value='Mon'><fmt:message key="Common.mon.label" bundle="${common_labels}"/>
			<option value='Tue'><fmt:message key="Common.tue.label" bundle="${common_labels}"/>
			<option value='Wed'><fmt:message key="Common.wed.label" bundle="${common_labels}"/>
			<option value='Thu'><fmt:message key="Common.thu.label" bundle="${common_labels}"/>
			<option value='Fri'><fmt:message key="Common.fri.label" bundle="${common_labels}"/>
			<option value='Sat'><fmt:message key="Common.sat.label" bundle="${common_labels}"/>
			<option value='Sun'><fmt:message key="Common.sun.label" bundle="${common_labels}"/>
			</select>
			</td>
			

</tr>
	<tr>		
	<td  nowrap class=label ><fmt:message key="eOA.Displayunidenpract.label" bundle="${oa_labels}"/></td>
		
		<td  class=fields nowrap>
		<input type="checkbox" name='not_iden_pract' id='not_iden_pract' value="" onclick='chk_not_iden_pract_value(this);'>
		</td>
	<td  class='fields' nowrap>
	<td class='button' colspan='2' align="right"><input type="button" class='button' name="select" id="select" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick="callResult()"><input type="button" class='button' name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearAll()"></td>
	</tr>
	<%}else {%>
<tr>

		<td  nowrap class=label ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		
		<td  class=fields nowrap>
			<select name='b_gender' id='b_gender'>
			<option value=''>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --
			<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
			<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
			</select>
		</td>
			
		<td  class='fields' nowrap>
		<td class='button' colspan='2' align='right'><input type="button" class='button' name="select" id="select" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick="callResult()"><input type="button" class='button' name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearAll()"></td>
</tr>
	<%}%>
<%}else {%>		


<tr>
	<td class='button' colspan='4' align='right'><input type="button" class='button' name="select" id="select" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick="callResult()"><input type="button" class='button' name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearAll()"></td>
</tr>
<%}%>
	       
</table>
<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'></input>
<input type='hidden' name='sysdate1' id='sysdate1' value='<%=sysdate1%>'></input>
<input type='hidden' name='oper_stn' id='oper_stn' value='<%=oper_stn_id%>'>
<input type='hidden' name='called_for' id='called_for' value='<%=called_for%>'>
<input type='hidden' name='fac_id' id='fac_id' value='<%=fac_id%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
<input type='hidden' name='functionid' id='functionid' value='<%=functionid%>'>
<input type='hidden' name='Alt_Id1' value='<%=Alt_Id1%>'>
<input type='hidden' name='Alt_Id2' value='<%=Alt_Id2%>'>
<input type='hidden' name='Alt_Id3' value='<%=Alt_Id3%>'>
<input type='hidden' name='Alt_Id4' value='<%=Alt_Id4%>'>
<input type='hidden' name='from' id='from' value=''>
<input type='hidden' name='to' id='to' value=''>
<%/*Below Line Added for this CRF [Bru-HIMS-CRF-0166]*/ %>
<input type='hidden' name='resch' id='resch' value='<%=resch%>'>
<input type='hidden' name='isSearchDurLimitAppl' id='isSearchDurLimitAppl' value='<%=isSearchDurLimitAppl%>'><!--Added by Shanmukh on 15th-MAY-2018 for ML-MMOH-CRF-1134 -->
<input type="hidden" name="nat_id_accept_alphanumeric_yn" value="<%=nat_id_accept_alphanumeric_yn%>">


</form>
<%
//}
	if(pstmt !=null) pstmt.close();
	if(rSet !=null) rSet.close();

}catch(Exception es){
	es.printStackTrace();
}
finally { 
	if(con!=null) ConnectionManager.returnConnection(con,request);
}		
%>
</body>
<script>
if(document.forms[0].function_id.value =="")
{
	document.forms[0].b_patient_id.focus();
}
</script>
</html>

