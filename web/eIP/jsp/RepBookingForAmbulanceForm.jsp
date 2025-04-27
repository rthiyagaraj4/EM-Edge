<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.* " %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBBKAMB" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				sql="select speciality_code, short_desc from am_speciality ";
				search_code="speciality_code";
				search_desc= "short_desc";
			}

			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%= p_facility_id%>` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}

			if(obj.name=="nationality")
			{
				tit=getLabel('Common.nationality.label','common')
				sql="select COUNTRY_CODE, LONG_DESC from MP_COUNTRY ";
				search_code="COUNTRY_CODE";
				search_desc= "LONG_DESC";
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

	function dateVal( obj )
	{
		if(obj.value !="")
		{
			if(!doDateTimeChk(obj))
			{
				obj.focus()
				alert(parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME","SM"))
			}
		}
	}
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name="BkgListForAmbulance" id="BkgListForAmbulance" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =  null;
    Statement stmt = null;
    ResultSet rset = null;

	StringBuffer sql = new StringBuffer();
    sql.append("Select TO_CHAR(SYSDATE,'DD/MM/rrrr') From DUAL " );
	String StrVal = "";

    try
    {
		con  =  ConnectionManager.getConnection(request);
		stmt = con.createStatement(); 
		rset = stmt.executeQuery(sql.toString());

		if(rset.next())
		{
			StrVal = rset.getString(1); 
		}
	 }
	 catch(Exception e){/* out.println(e); */ e.printStackTrace();}
	 finally
	 {
		try{
		if(rset != null)    rset.close();
		if(stmt != null)    stmt.close();
		}
		catch(Exception e)
		 {/* out.println("Exception in tryCatch : "+ e.toString()); */ e.printStackTrace();}
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
%>
<br>
<br>
<table width='80%' align='center' valign='top'>
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td align="center" width="30%">&nbsp;</td>
					<td class="querydata" width="30%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>

				<tr>
						<td align='right' width='30%' class="label" nowrap><fmt:message key="eIP.AmbulanceReqdDateTime.label" bundle="${ip_labels}"/>   &nbsp;</td>
						<td width='30%'>
							<input type=text  name='p_fm_ambl_date_time' id='p_fm_ambl_date_time' size="16" maxlength="16" align="center" onBlur='dateVal(this)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_ambl_date_time' id='p_to_ambl_date_time' size="16" maxlength="16" align="center" onBlur='dateVal(this)'>
						</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>								

				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="eIP.PreferredAdmissionDate.label" bundle="${ip_labels}"/>&nbsp;</td>
						<td width='30%'  >
							<input type=text  name='p_fm_pref_date' id='p_fm_pref_date' size="10" maxlength="10" align="center" onblur='CheckDate(this)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_pref_date' id='p_to_pref_date' size="10" maxlength="10" align="center" onblur='CheckDate(this)'>
						</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>	
				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text  name='p_fm_specialty_code' id='p_fm_specialty_code' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_specialty_code' id='p_to_specialty_code' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
						<td align='right' width='30%' class="label">Nationality Code &nbsp;</td>
						<td width='30%'  >
							<input type=text  name='p_fm_nationality_code' id='p_fm_nationality_code' size="4" maxlength="4" align="center"><input type='button' name='nationality' id='nationality' value='?' class='button' onclick='searchCode(this, p_fm_nationality_code)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_nationality_code' id='p_to_nationality_code' size="4" maxlength="4" align="center"><input type='button' name='nationality' id='nationality' value='?' class='button' onclick='searchCode(this, p_to_nationality_code)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label">
						<fmt:message key="Common.priority.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='30%' align="left">
						<select name='p_priority' id='p_priority'>							
							<option value=''>&nbsp;------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------&nbsp;
							<option value='N'><fmt:message key="Common.nonurgent.label" bundle="${common_labels}"/>
							<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	    value="<%= p_user_name %>">
	<input type="hidden" name="sys_date" id="sys_date"	    value="<%= StrVal %>">
</form>
</BODY>
</HTML>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

