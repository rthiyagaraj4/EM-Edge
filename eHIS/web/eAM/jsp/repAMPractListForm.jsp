<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*,org.json.simple.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<html>
<HEAD>
<TITLE></TITLE>
<%
          String sStyle =
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
    
	String nat_id_prompt="";
	JSONArray p_practitioner_type=null;
	JSONArray p_primary_speciality=null;
	Connection con =null;
 try
	{

	con=ConnectionManager.getConnection(request);

    p_practitioner_type=eAM.AMCommonBean.getPractitionerType(con); 

    p_primary_speciality=eAM.AMCommonBean.getPrimarySpeciality(con); 

	nat_id_prompt=eAM.AMCommonBean.getNationalIDPrompt(con); 
	if(nat_id_prompt.equals("")) nat_id_prompt=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src="../js/repResetRunPractlist.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<%
     request.setCharacterEncoding("UTF-8");
	String p_module_id		= "AM" ;
	String p_report_id		= "AMPRALST" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()' onload='FocusFirstElement()'>
<form name="repAMPractListForm" id="repAMPractListForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
				<table width='80%' align='center' valign='top' border='0'>
                <tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class='columnheader' colspan='3'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
				</tr>
				</table>
                <table width='70%' cellPadding="2" cellSpacing="0"  align='center' border='0'>
                <tr>
                    <td width="33%"></td>
                    <td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
                    <td class="querydata" width="20%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
                </tr>
				<tr>
				    <td align='right' width='30%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_practitioner_id' id='p_fm_practitioner_id' size="15" maxlength="15" align="center" onblur='if(this.value !="") searchCode(fm_practitioner,this)'><input type='button' name='fm_practitioner' id='fm_practitioner' value='?' class='button' onclick='searchCode(this,p_fm_practitioner_id)'>
					</td>
						<td width='40%'> <input type=text  name='p_to_practitioner_id' id='p_to_practitioner_id' size="15" maxlength="15" align="center" onblur='if(this.value !="") searchCode(to_practitioner,this)'><input type='button' name='to_practitioner' id='to_practitioner' value='?' class='button' onclick='searchCode(this,p_to_practitioner_id)'>
					</td>					
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
                    <td class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
                    <td width='20%'>
					<select name='p_practitioner_type' id='p_practitioner_type'> 
						<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
						<% for(int i=0;i<p_practitioner_type.size();i++){
							JSONObject jsonObj = (JSONObject) p_practitioner_type.get(i);
						%>
							<option value="<%= jsonObj.get("pract_type")%>"><%= jsonObj.get("Desc_Userdef")%></option>
						<% } %>
					</select>
					</td>
                </tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='20%' class="label"><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/></td>
					<td width='20%'>
					<select name='p_primary_speciality' id='p_primary_speciality'> 
						<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
						<% for(int i=0;i<p_primary_speciality.size();i++){
							JSONObject jsonObj = (JSONObject) p_primary_speciality.get(i);
						%>
							<option value="<%= jsonObj.get("speciality_code")%>"><%= jsonObj.get("short_desc")%></option>
						<% } %>
					</select>
					</td>
                </tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
				     <td align='right' width='20%' class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/> &nbsp;</td>
				     <td width='20%'><select name="p_enabled" id="p_enabled">
				<option value="B">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
				<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
				</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='15%' class="label"><%= nat_id_prompt %>&nbsp;</td>
					<td  width='10%' align="left" nowrap>
						<select name='p_nat_id' id='p_nat_id' onchange="checkVal(this,p_nat_id_value);"> 
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
						<input type="text" name="p_nat_id_value" id="p_nat_id_value" disabled size=15 maxlength=20>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
	            <td  class='label' width="6%" ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/>&nbsp;</td>
				<td  width='20%' align="left" nowrap><select name='p_mobile_no' id='p_mobile_no' onchange="checkVal(this,p_mobile_no_value);">
				<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
				<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
				<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
				</select>
				<input type="text" name="p_mobile_no_value" id="p_mobile_no_value" disabled size=15 maxlength=20>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
				<td class="label"><fmt:message key="eAM.FacilityAccess.label" bundle="${am_labels}"/></td>
	                <td  width='20%' align="left"><select name='p_all_facility_access' id='p_all_facility_access'>
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
					<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				    <option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
				    </select>
				</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
                <tr>
					<td  class='label' ><fmt:message key="eAM.WithRepFacility.label" bundle="${am_labels}"/></td>
	                <td  width='5%' align="left"><select name='p_rep_facility' id='p_rep_facility' onchange="RepFacilityVal(this,rep_facility1,p_rep_facility_value);">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
					<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				    <option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<input type=text  name='p_rep_facility_value' id='p_rep_facility_value' size="15" maxlength="15" align="center" onblur='if(this.value !="") searchCode(rep_facility1,this)' disabled><input type='button' name='rep_facility1' id='rep_facility1' value='?' class='button' onclick='searchCode(this,p_rep_facility_value)' disabled>
					</td>	
					</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
				    <td  class='label' ><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
                    <td  width='20%' align="left"><select name='p_group_by' id='p_group_by'>
				    <option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
				    <option value="1"><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/></option>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
                <td  class='label' ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class='fields'  width='10%'>
                    <select name='p_order_by' id='p_order_by'>
					<option value="1"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>
					<option value="2"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>
					</select></td>
				</tr>
				</table>
				<br>
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
           
</form>
</body>
</html>
<%
}catch(Exception e){
	//out.println(e);
	e.printStackTrace();
	}
finally { 
	ConnectionManager.returnConnection(con,request);
}
%>

