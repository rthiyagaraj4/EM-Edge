<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	String p_user_name		= (String) session.getValue( "login_user" );
	String p_resp_id		= (String)session.getValue("responsibility_id");
	String locale=(String)session.getAttribute("LOCALE");	
	String p_language_id						= (String)session.getAttribute("LOCALE");
	String p_report_id		= "OPRFINST" ;
	String p_module_id		= "OP" ;
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null) || (session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eOP/js/ReferredInPatientStatistics.js" language="javascript"></script>
<script src='../../eOP/js/OPPractitionerComponent.js'  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY OnMouseDown="CodeArrest()"onload = 'FocusFirstElement()' onKeyDown ='lockKey()'>
<form name="ReferredInReport" id="ReferredInReport"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =null;
    Statement stmt = null;
    ResultSet rset = null;
	String sql1 = "" ;
	String sql = "" ;
	String fid="";
	String fname="";	
	String sql_hcare="";
	String hcare_code="";
	String hcare_short_desc="";
	StringBuffer StrVal =new StringBuffer();
	try
    {
	con  =  ConnectionManager.getConnection(request);  
	stmt = con.createStatement();    
	sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E' and language_id='"+locale+"' order by 2" ;
	rset = stmt.executeQuery(sql);
	StrVal.setLength(0);  
		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append( "<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
		}
	if(rset != null) rset.close();
	if(stmt != null) stmt.close();
%>
<table align='center' border='0' width='80%' cellpadding='2' cellspacing='0'>
<tr>
	<th align='left' colspan='3'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
<tr>
</table>
<table align='center' border='0' width='90%' cellpadding='2' cellspacing='0'>
<tr>
    <td width='5%'>&nbsp;</td>
	<td class="label" nowrap width='25%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td colspan='2' class='fields' width='25%'><select name='P_facilityid' id='P_facilityid'>
	<%	
		 sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"' and p.language_id='"+locale+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";

			stmt = con.createStatement() ;
			rset=stmt.executeQuery(sql1);
			if(rset!=null)
			{
			   while(rset.next())
			   {
					fid=rset.getString("facility_id");
					fname=rset.getString("facility_name");
					if(fid.equals("All"))
						out.println("<option value='"+fid+"' selected>"+fname+"</option>");
					else
					    out.println("<option value='"+fid+"'>"+fname+"</option>");
			   }
			}
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
      
%>
</td>
<td width='25%'>&nbsp;</td>
</tr>
<tr>
	<td width='5%'>&nbsp;</td>
	<td  class='label' width="25%" >&nbsp;</td>
	<td  width="25%" class='querydata' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class='querydata' width="25%" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>	
</tr>
<tr>
	<td width='5%'>&nbsp;</td>
	<td class="label" width="25%"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%"><input type=text  name='p_fm_date' id='p_fm_date' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_fm_date.select();return showCalendar('p_fm_date');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
	</td>	
	<td class='fields' width="25%"><input type=text  name='p_to_date' id='p_to_date' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_to_date.select();return showCalendar('p_to_date');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td width='5%'>&nbsp;</td>
	<td  class='label' width="25%"><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
	<td width="25%">
	<select name='p_priority_zone' id='p_priority_zone' >
	<option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
	<option value='ELEC'><fmt:message key="Common.elective.label" bundle="${common_labels}"/>
	<option value='SEMI'><fmt:message key="Common.semiemergency.label" bundle="${common_labels}"/>
	<option value='EMER'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
	</select></td>
	<td width='25%'>&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr>	
	<td class='label' colspan='4'><b><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></b>	
</tr>
<tr>
	<td width='5%'>&nbsp;</td>
	<td class="label" width="25%"><fmt:message key="Common.referraltype.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%">
	<select name='p_referral_type' id='p_referral_type' onchange='getval3(this)'>	
	<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
	<option value='L'><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/></option>
	<option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
	<option value='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
	</td>
	<td width='25%'>&nbsp;</td>
</tr>
<tr>
<tr>
	<td width='5%'>&nbsp;</td>
	<td class='label' width="25%"><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%">	
	<select name='p_hcare_type' id='p_hcare_type' onchange='getval3(this)' >
	<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
	<%		
		sql_hcare="SELECT hcare_setting_type_code,short_desc FROM AM_HCARE_SETTING_TYPE_LANG_VW  WHERE eff_status='E' and  language_id='"+locale+"' ORDER BY 2";								
		stmt = con.createStatement() ;
		rset=stmt.executeQuery(sql_hcare);
		if(rset!=null)
			{
			   while(rset.next())
			   {										
					hcare_code=rset.getString("hcare_setting_type_code");
					hcare_short_desc=rset.getString("short_desc");
					out.println("<option value='"+hcare_code+"'>"+hcare_short_desc+"</option>");
			   }
			}
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
			%>			
		</td>
		<td width='25%'>&nbsp;</td>
</tr>
<tr>
	<td width='5%'>&nbsp;</td>
	<td class='label' width="25%"><fmt:message key="Common.referralsource.label" bundle="${common_labels}"/></td>

	<td  class='fields' width="25%"><input type='text' name='p_fm_ref_source' id='p_fm_ref_source' size='25' maxlength="25" onBlur ='clear_ref(this);' value=""><input type='button' class='button' name='referralfrm' id='referralfrm' value='?' onClick="referralSourceLookup(this)"></td>
	<input type='hidden' name='referral_source_lkp_bkup_text_frm' id='referral_source_lkp_bkup_text_frm' size='15' maxlength="15" value="">
	<input type='hidden' name='referral_source_lkp_id_frm' id='referral_source_lkp_id_frm' size='15' maxlength="15" value="">
	<input type='hidden' name='p_fm_ref_source_code' id='p_fm_ref_source_code' size='15' maxlength="15" value="">
	
	<td  class='fields' width="25%"><input type='text' name='p_to_ref_source' id='p_to_ref_source' size='25' maxlength="25" onBlur ='clear_ref(this);' value=""><input type='button' class='button' name='referralto' id='referralto' value='?' onClick="referralSourceLookup(this)"></td>
	<input type='hidden' name='referral_source_lkp_bkup_text_to' id='referral_source_lkp_bkup_text_to' size='15' maxlength="15" value="">
	<input type='hidden' name='referral_source_lkp_id_to' id='referral_source_lkp_id_to' size='15' maxlength="15" value="">
	<input type='hidden' name='p_to_ref_source_code' id='p_to_ref_source_code' size='15' maxlength="15" value="">
</tr>
<tr>
	<td width='5%'>&nbsp;</td>
	<td class="label" width="25%"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%"><input type="text" name="p_fm_specialty_code_reffrm" id="p_fm_specialty_code_reffrm" size="4" maxlength="4" onBlur='searchCode(fromspecialty_reffrm,this)'><input type='button' name='fromspecialty_reffrm' id='fromspecialty_reffrm' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code_reffrm)'></td>
	<td class='fields' width="25%"><input type="text" name="p_to_specialty_code_reffrm" id="p_to_specialty_code_reffrm" size="4" maxlength="4" onBlur='searchCode(tospecialty_reffrm,this)'><input type='button' name='tospecialty_reffrm' id='tospecialty_reffrm' value='?' class='button' onclick='searchCode(this, p_to_specialty_code_reffrm)'></td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr>	
	<td class='label' colspan='4'><b><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></b>	
</tr>
<tr>
	<td width='5%'>&nbsp;</td>
	<td class="label" width="25%"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%"><input type="text" name="p_fm_specialty_code_refto" id="p_fm_specialty_code_refto" size="4" maxlength="4" onBlur='searchCode(fromspecialty_refto,this)'><input type='button' name='fromspecialty_refto' id='fromspecialty_refto' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code_refto)'></td>
	<td class='fields' width="25%"><input type="text" name="p_to_specialty_code_refto" id="p_to_specialty_code_refto" size="4" maxlength="4" onBlur='searchCode(tospecialty_refto,this)'><input type='button' name='tospecialty_refto' id='tospecialty_refto' value='?' class='button' onclick='searchCode(this, p_to_specialty_code_refto)'></td>
</tr>
<tr>
	<td width='5%'>&nbsp;</td>
	<td class="label" width="25%"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%">
	<select name='p_location_type' id='p_location_type' onchange="document.forms[0].p_fm_locn_code.value='';document.forms[0].p_to_locn_code.value='';">
	<option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
	<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
	<option value='Y'><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/>
	<option value='E'><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/>
	<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
	</select></td>
	<td width='25%'>&nbsp;</td>
</tr>
<tr>
	<td width='5%'>&nbsp;</td>
	<td class="label" width="25%"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%"><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'></td>
	<td class='fields' width="25%"><input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'></td>
</tr>
<tr>
	 <td width='5%'>&nbsp;</td>
     <td class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
     <td class='fields'><select name="p_fm_pract_type" id="p_fm_pract_type" onchange="document.forms[0].p_fm_pract_id.value='';">
	 <option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
	 <%=StrVal.toString()%>
	</select></td>
	<td class='fields'><select name="p_to_pract_type" id="p_to_pract_type" onchange="document.forms[0].p_to_pract_id.value='';">
	<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 	bundle="${common_labels}"/> --------&nbsp;</option>
	<%=StrVal.toString()%>
    </select></td>
</tr>
<tr>
	<td width='5%'>&nbsp;</td>
	<td class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>	
	<td class='fields'><input type="text" name="p_fm_pract_id" id="p_fm_pract_id" size="15" maxlength="15" onBlur='searchCode(pract_id1,this)'><input type='button' name='pract_id1' id='pract_id1' value='?' class='button' onclick='searchCode(this, p_fm_pract_id)'></td>		
	<td class='fields'><input type="text" name="p_to_pract_id" id="p_to_pract_id" size="15" maxlength="15" onBlur='searchCode(pract_id2,this)'><input type='button' name='pract_id2' id='pract_id2' value='?' class='button' onclick='searchCode(this, p_to_pract_id)'></td>
</tr>
</table>  
<%}catch(Exception e){out.println(e);}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}%>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=p_facility_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"	 value="<%=p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%= p_resp_id %>">
<input type="hidden" name='locale' id='locale'				value="<%=locale%>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_language_id" id="p_language_id"		value="<%= p_language_id %>">


</form>
</body>
</html>

