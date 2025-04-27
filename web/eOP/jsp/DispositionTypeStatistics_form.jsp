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
	String p_report_id		= "OPDISTYP" ;
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
<script src="../../eOP/js/DispositionTypeStat.js" language="javascript"></script>
<script src='../../eOP/js/OPPractitionerComponent.js'  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY OnMouseDown="CodeArrest()"onload = 'FocusFirstElement()' onKeyDown ='lockKey()'>
<form name="DispositionTypeStatistics_form" id="DispositionTypeStatistics_form"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =null;
    Statement stmt = null;
    ResultSet rset = null;
	String sql1 = "" ;
	String sql = "" ;
	String fid="";
	String fname="";	
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
<table align='center' border='0' width='75%' cellpadding='2' cellspacing='0'>
<tr>
	<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
<tr>
<tr>
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
        }catch(Exception e){out.println(e);}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
%>
</select>
</td>
</tr>
<tr>
	<td  class='label' width="25%" >&nbsp;</td>
	<td  width="25%" class='querydata' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class='querydata' width="25%" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>	
</tr>
<tr>
	<td class="label" width="25%"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%"><input type=text  name='p_fm_date1' id='p_fm_date1' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this);chkFormat(this);};'><img name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_fm_date1.select();return showCalendar('p_fm_date1');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
	</td>	<input type='hidden' name='p_fm_date' id='p_fm_date' value=''/>
	<td class='fields' width="25%"><input type=text  name='p_to_date1' id='p_to_date1' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this);chkFormat(this);};'><img name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_to_date1.select();return showCalendar('p_to_date1');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
	</td>	<input type='hidden' name='p_to_date' id='p_to_date' value=''/>
</tr>
<tr>
	<td class="label" width="25%"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%"><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" onBlur='searchCode(fromspecialty,this)'><input type='button' name='fromspecialty' id='fromspecialty' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'></td>
	<td class='fields' width="25%"><input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4" onBlur='searchCode(tospecialty,this)'><input type='button' name='tospecialty' id='tospecialty' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'></td>
</tr>
<tr>
	<td class="label" width="25%"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%"><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'></td>
	<td class='fields' width="25%"><input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'></td>
</tr>
<tr>
	<td class="label" width="25%"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%"><input type="text" name="p_fm_service_code" id="p_fm_service_code" size="4" maxlength="4" onBlur='searchCode(fromservice,this)'><input type='button' name='fromservice' id='fromservice' value='?' class='button' onclick='searchCode(this, p_fm_service_code)'></td>
	<td class='fields' width="25%"><input type="text" name="p_to_service_code" id="p_to_service_code" size="4" maxlength="4" onBlur='searchCode(toservice,this)'><input type='button' name='toservice' id='toservice' value='?' class='button' onclick='searchCode(this, p_to_service_code)'></td>
</tr>
<tr>
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
	<td class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>	
	<td class='fields'><input type="text" name="p_fm_pract_id" id="p_fm_pract_id" size="15" maxlength="15" onBlur='searchCode(pract_id1,this)'><input type='button' name='pract_id1' id='pract_id1' value='?' class='button' onclick='searchCode(this, p_fm_pract_id)'></td>		
	<td class='fields'><input type="text" name="p_to_pract_id" id="p_to_pract_id" size="15" maxlength="15" onBlur='searchCode(pract_id2,this)'><input type='button' name='pract_id2' id='pract_id2' value='?' class='button' onclick='searchCode(this, p_to_pract_id)'></td>
</tr>
<tr>
   <td class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
   <td class='fields'><select name='p_patient_class' id='p_patient_class'>
   <option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
   <option value='OP'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>
   <option value='EM'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
   <option value='IP'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
   <option value='DC'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/> 

</tr>
</table>
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

