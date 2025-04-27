<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%

	request.setCharacterEncoding("UTF-8");
    Connection con =null;
	String facility_id = (String) session.getValue("facility_id");
	String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");

try 
{
    con=ConnectionManager.getConnection(request);
%>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<SCRIPT LANGUAGE="JavaScript">

async function searchCode(obj,target)
{
	var retVal = 	new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var facilityid = "<%=facility_id%>";
	var tit="";
	if(obj.name=="spec")
	{
		tit=getLabel("Common.speciality.label","Common");
		sql="select speciality_code,short_Desc from am_speciality";
		search_code=" speciality_code";
		search_desc= "short_desc";
	}	
	if(obj.name=="nurse")
	{
		tit=getLabel("Common.nursingUnit.label","Common");
		sql="select nursing_unit_code,short_Desc from ip_nursing_unit";
		search_code=" nursing_unit_code";
		search_desc= "short_desc";
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

</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="DeathRegister" id="DeathRegister" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='80%' cellpadding="3" cellspacing="0"  align='center'>
<tr>
<th class="COLUMNHEADER" colspan='3' align="left"> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
</tr>
<tr>
	<td class='label' colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td class="label" width="30%" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td class='fields' width='30%'><select name='facilityid' id='facilityid'>
		<%
			Statement stmt	= null;
			ResultSet rset	= null;
			try
			{
			String fid;
			String fname;
			String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ user_id+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+resp_id+"') order by 2 ";					
			stmt=con.createStatement();
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

			}catch(Exception e){/* out.println(e); */ e.printStackTrace();}
			finally
			{
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				ConnectionManager.returnConnection(con,request);
			}
			%>
		</select>
	</td>
	<td class='label' width='40%'>&nbsp;</td>
</tr>
<tr>
	<td class='label'>&nbsp;</td>
	<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>
<tr>
		<td class="label"><fmt:message key="eMR.DeathDate.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type='text' id='deathfrom' name='date_from' id='date_from' size='10' onBlur='CheckDate(this)'
		 maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('deathfrom');"/></td>

		<td class='fields'><input type='text' id='deathto' name='date_to' id='date_to' size='10' onBlur='CheckDate(this)' maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('deathto');"/></td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_care_code" id="p_fm_care_code" size="4" maxlength="4" ><input type='button' name='nurse' id='nurse' value='?' class='button' onclick='searchCode(this, p_fm_care_code)'>
	</td>
	<td class='fields'><input type="text" name="p_to_care_code" id="p_to_care_code" size="4" maxlength="4"><input type='button' name='nurse' id='nurse' value='?' class='button' onclick='searchCode(this, p_to_care_code)'>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" ><input type='button' name='spec' id='spec' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
	</td>
	<td class='fields'><input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4"><input type='button' name='spec' id='spec' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
	</td>
</tr>
<tr><td class='label' colspan='3'>&nbsp;</td></tr>
</table>
<input type="hidden" name="p_module_id" id="p_module_id" 	value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="MRRDTHRG">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
</form>
</body>
</html>
<%
} catch(Exception e) { /*  out.println("in else "+e); */ e.printStackTrace();}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>


