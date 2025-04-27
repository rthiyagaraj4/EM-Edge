<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%
	request.setCharacterEncoding("UTF-8");	
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBDLAST" ;
	String CurrentDate = "";
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String p_resp_id			=	(String) session.getValue("responsibility_id");

	Connection	con		=	ConnectionManager.getConnection(request);
	Statement	stmt			=	null;
	Statement	stmt1			=	null;
	ResultSet	rset			=	null;
	ResultSet	rset1			=	null;
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

	 function validate_date(obj) {
				if(obj.value!=''){

					if(isBeforeNow(obj.value,"DMY",localeName))
						return true;
					else {
						alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
						obj.select();
						obj.focus();
						return false ;
					}
				}
  }

</script>
</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<br>
<br>
<form name="RepDailyAnnualStatistics" id="RepDailyAnnualStatistics" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<table width='80%' align='center' valign='top'>
		<th align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
 </th>
	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
					<td  class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;</td>
					<td colspan ="4" > 
							<select name='p_for_facility_id' id='p_for_facility_id' >
						<%
							try
							{
							stmt=con.createStatement();
							String fid;
							String fname;
							String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name,to_char(sysdate,'dd/mm/yyyy') CurrentDate from dual union select u.facility_id facility_id, p.facility_name facility_name,to_char(sysdate,'dd/mm/yyyy')CurrentDate from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";					
							rset=stmt.executeQuery(sql1);
							if(rset!=null)
							{
							   while(rset.next())
							   {
								fid=rset.getString("facility_id");
								fname=rset.getString("facility_name");
								CurrentDate=rset.getString("CurrentDate");
								if(fid.equals("All"))
								out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
								else
								out.println("<option value='"+fid+ "' >"+fname+"</option>");
							   }
							}
							}catch(Exception e)
							{
								out.println(e);
							}
							finally 
							{ 
								if(rset != null)    rset.close();
								if(stmt != null)    stmt.close();
								if(rset1 != null)    rset1.close();
								if(stmt1 != null)    stmt1.close();
								ConnectionManager.returnConnection(con,request);
							}

						%>	
						</select>
					</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.statistics.label" bundle="${common_labels}"/> <fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					<td width='30%' class="fields" ><input type=text  name='p_trn_date' id='p_trn_date' id="p_trn_date" 
					onblur = "if(validDateObj(this,'DMY',localeName))validate_date(this)" size="10" maxlength="10" align="center" ><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_trn_date');">
						<img align='center' src='../../eMP/images/mandatory.gif'>
						
					</td>
					<td width='40%'>&nbsp;</td>
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
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%= p_resp_id %>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%= CurrentDate %>">

</form>
<script>
	document.forms[0].p_for_facility_id.focus()
</script>
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

