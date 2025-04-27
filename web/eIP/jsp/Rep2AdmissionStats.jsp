<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
	<script src="../../eCommon/js/common.js" language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>

<SCRIPT LANGUAGE="JavaScript">
async function searchCode(obj,target,Ar_installed)
{
var retVal = 	new String();
//var dialogHeight= "28" ;
//var dialogWidth	= "43" ;
var dialogTop = "10px" ;
var dialogHeight= "400px" ;
var dialogWidth="900px";
var status = "no";
var arguments	= "" ;
var sql="";
var search_code="";
var search_desc="";
var tit="";
if(obj.name=="cost")
{
	tit=getLabel('eIP.CostCenter.label','IP')
	sql="select dept_code, short_desc from am_dept";
	search_code="dept_code";
	search_desc= "short_desc";
}
else if(obj.name=="section")
{
	tit=getLabel('Common.Section.label','common')
	sql="select section_code, short_desc from am_dept_section";
	search_code="section_code";
	search_desc= "short_desc";
}
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

if (!(retVal == null))
	target.value=retVal;
else
	target.focus();
}
</SCRIPT>
<%
	request.setCharacterEncoding("UTF-8"); 
	Connection				con		=	null;
	ResultSet				rset	=	null ;
	Statement				stmt	=	null ;

	String p_module_id		= "IP" ;
	String p_report_id		= "IPBCSWST" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String) session.getValue("responsibility_id");
%>
<html>
<center>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name="Rep2AdmnStat" id="Rep2AdmnStat" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR>
<table width='80%' align='center' valign='top'>
<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" class="Border" align='center'>
		<table width='100%' cellPadding="0" cellSpacing="0" align='center'  >
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>	
	<!-- To Populate Facility List -->
	<tr>
		<td align="left" class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
		<td colspan ="3"> 
				<select name='p_for_facility_id' id='p_for_facility_id'>
			<%
				try
				{
					con		=	ConnectionManager.getConnection(request);
				stmt=con.createStatement();
				String fid;
				String fname;
				String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";					
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
				if(rset!=null)rset.close();
				if(stmt!=null)stmt.close();
				}
				catch(Exception e)
				{
					out.println(e);
					e.printStackTrace();
				}
				finally 
				{ 
					ConnectionManager.returnConnection(con,request);
				}
			%>	
			</select>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td >&nbsp;</td>
		<td class="label" ><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td  width='40%' class="label" align='left' nowrap><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  width='20%' align='left'>
		       <input type=text id="p_date_from" name='p_fr_date' id='p_fr_date' size="10" maxlength="10" onblur='CheckDate(this)' ><img src ='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_from');"/>
		</td>
		<td  width='40%' align='left'>
		       <input type=text id="p_date_to"  name='p_to_date' id='p_to_date' size="10" maxlength="10" onblur='CheckDate(this)'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_to');"/>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
<tr>
<td width='40%' class="label" align='left' nowrap><fmt:message key="eIP.CostCenter.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
<td  width='20%' align='left'><input type="text" name="p_fm_cost_wise" id="p_fm_cost_wise" size="6" maxlength="6"><input type='button' name='cost' id='cost' value='?' class='button' onclick="searchCode(this, p_fm_cost_wise,'N')"></td>
<td  width='40%' align='left'><input type="text" name="p_to_cost_wise" id="p_to_cost_wise" size="6" maxlength="6"><input type='button' name='cost' id='cost' value='?' class='button' onclick="searchCode(this, p_to_cost_wise,'N')">
</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr>
<td width='40%' class="label" align='left' nowrap><fmt:message key="Common.Section.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td  width='20%' align='left'><input type="text" name="p_fm_section_wise" id="p_fm_section_wise" size="6" maxlength="6"><input type='button' name='section' id='section' value='?' class='button' onclick="searchCode(this, p_fm_section_wise,'N')"></td>
<td  width='40%' align='left'><input type="text" name="p_to_section_wise" id="p_to_section_wise" size="6" maxlength="6"><input type='button' name='section' id='section' value='?' class='button' onclick="searchCode(this, p_to_section_wise,'N')"></td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
</table>
</td>
</tr>
</table>
	<br>
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
</form>
</body>
</center>
</html>

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

