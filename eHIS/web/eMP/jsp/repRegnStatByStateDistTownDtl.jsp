<!DOCTYPE html>
<%@ page import ="java.sql.*, webbeans.eCommon.*, java.util.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
%>
<html>
<HEAD>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBSTSDT" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String)session.getValue("responsibility_id");
    Connection con = null;
	Statement stmt = null;
	ResultSet rset = null;

%>
<script>
async function searchCode(obj,target,state)
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
	if(obj.name=="region")
	{
		tit=getLabel('eMP.Regioncode.label','MP');
		sql="select region_code, short_desc from mp_region";
		search_code="region_code";
		search_desc= "short_desc";
	}
	else if(obj.name=="area")
	{
	    tit=getLabel('Common.AreaCode.label','common');
	    if (state.value!='')
		   sql="select RES_AREA_CODE, long_desc short_desc  from mp_res_area where region_code = '"+state.value+"' ";
	    else
           sql="select RES_AREA_CODE, long_desc short_desc from mp_res_area"; 
		   search_code="RES_AREA_CODE";
		   search_desc= "short_desc";
	 }
	 else if(obj.name=="town")
	 {
	 	  tit=getLabel('Common.TownCode.label','common');
		  if (state.value!='')
		 	sql="select res_town_code,long_desc from mp_res_town where res_area_code = '"+state.value+"' ";
		  else
			sql="select res_town_code,long_desc from mp_res_town";
		  search_code="res_town_code";
		  search_desc= "short_desc";
	 }
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+escape(sql)+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
	if (!(retVal == null))
	{
		target.value=retVal;
	}
	else
		target.focus();
	}
</script>
</HEAD>
<BODY onLoad="Focusing('p_fm_regndate')" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repregion" id="repregion" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
<td class='columnheader'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </td>
<tr>
	<td width="100%" class="Border" align='center'>
	<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
	<tr>
		<td >&nbsp;</td>
		<td > </td>
		<td > </td>
	</tr>
	<tr>
		<td align="right" width='30%'class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/> </td>
		<td width ='20%'> &nbsp&nbsp<select name='P_facility_id' id='P_facility_id'>
		<%
		try
		{
			con = ConnectionManager.getConnection(request);
			stmt=con.createStatement();
			String fid;
			String fname;
			String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2 ";			
			rset=stmt.executeQuery(sql1);
			if(rset!=null)
			{
			   while(rset.next())
			   {
					fid=rset.getString("facility_id");
					fname=rset.getString("facility_name");
					if(fid.equals("All"))
						out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
					else
                        out.println("<option value='"+fid+ "' >"+fname+"</option>");
				}
			}
		}
		catch(Exception e)
		{
			//out.println(e);
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null) stmt.close();
			if(rset!=null) rset.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		%>
	</select>
	</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
    <tr>
		<td align="right"  width='30%' class="label"><fmt:message key="eMP.RegnDateFrom.label" bundle="${mp_labels}"/> </td>
		<td width ='20%'>&nbsp;&nbsp;<input type="text" id='regdatefrom' name="p_fm_regndate" id="p_fm_regndate" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regdatefrom');">
		</td>
		<td class="label"> <fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;&nbsp;<input type="text" id='regdateto' name="p_to_regndate" id="p_to_regndate" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regdateto');">
		</td>
	 </tr>
	 <tr>
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
	 </tr>
	 <tr> 
		<td align='right' width='30%' class="label"><fmt:message key="eMP.StateCodeFrom.label" bundle="${mp_labels}"/> </td>
		<td width='20%'>&nbsp;&nbsp;<input type=text  name='p_fm_region_code' id='p_fm_region_code' size="6" maxlength="6" align="center"><input type='button' name='region' id='region' value='?' class='button' onclick='searchCode(this, p_fm_region_code, this)'>
		</td>
		<td class="label"> <fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;&nbsp;<input type=text  name='p_to_region_code' id='p_to_region_code' size="6" axlength="6" align="center"><input type='button' name='region' id='region' value='?' class='button' onclick='searchCode(this, p_to_region_code, this)'>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
	</tr> 
	<tr> 
		<td align='right' width='30%' class="label"><fmt:message key="eMP.DistrictCodeFrom.label" bundle="${mp_labels}"/></td>
		<td width='20%'>&nbsp;&nbsp;<input type=text  name='p_fm_area_code' id='p_fm_area_code' size="6" maxlength="6" align="center"><input type='button' name='area' id='area' value='?' class='button' onclick='searchCode(this, p_fm_area_code,p_fm_region_code)'>
		</td>
		<td class="label"> <fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;&nbsp;<input type=text  name='p_to_area_code' id='p_to_area_code' size="6" maxlength="6" align="center"><input type='button' name='area' id='area' value='?' class='button' onclick='searchCode(this, p_to_area_code,p_to_region_code)'>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
	</tr> 
	<tr> 
		<td align='right' width='30%' class="label"><fmt:message key="eMP.TownCodeFrom.label" bundle="${mp_labels}"/> </td>
		<td width='20%'>&nbsp;&nbsp;<input type=text  name='p_fm_town_code' id='p_fm_town_code' size="6" maxlength="6" align="center"><input type='button' name='town' id='town' value='?' class='button' onclick='searchCode(this, p_fm_town_code,p_fm_area_code)'>
		</td>
		<td class="label"> <fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;&nbsp;<input type=text  name='p_to_town_code' id='p_to_town_code' size="6" maxlength="6" align="center"><input type='button' name='town' id='town' value='?' class='button' onclick='searchCode(this, p_to_town_code,p_to_area_code)'>
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
	<input type="hidden" name="p_module_id" id="p_module_id" value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"	value="<%= p_resp_id %>">
</form>
</BODY>
</HTML>


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

