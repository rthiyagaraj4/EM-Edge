<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
String sStyle					=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<HEAD>
<TITLE></TITLE>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eIP/js/Rep2BookingTypeStatistics.js" language='javascript'></script>
<html>

</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown='lockKey()' onload="changeBookingDate();">
<%
	String p_module_id			= "IP" ;
	String p_report_id			= "IPBKTYST" ;
	String CurrentDate			= "";
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name			= (String) session.getValue( "login_user" ) ;
	String p_resp_id			= (String) session.getValue("responsibility_id");
	String locale				= (String)session.getAttribute("LOCALE");
	Connection	con				= ConnectionManager.getConnection(request);
	Statement	stmt			=	null;
	Statement	stmt1			=	null;
	ResultSet	rset			=	null;
	ResultSet	rset1			=	null;
%>




<br>
<br>
<form name="RepBookingTypeStatistics" id="RepBookingTypeStatistics" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<table width='80%' align='center' valign='top'>
		<th align='left' colspan="3"> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>

		<td width="100%" class="Border" >
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<tr>
					<td  class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td colspan ="4"  class='fields'> 
							<select name='p_all_facility_id' id='p_all_facility_id' >
						<%
							try
							{
							stmt=con.createStatement();
							String fid;
							String fname;
							
							String all_access = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");

							String sql1 = "select 'All' facility_id, '"+all_access+"' facility_name,to_char(sysdate,'dd/mm/yyyy') CurrentDate from dual union select u.facility_id facility_id, p.facility_name facility_name,to_char(sysdate,'dd/mm/yyyy')CurrentDate from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"'  and p.language_id='"+locale+"'  and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2";
						
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
								e.printStackTrace();
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
					<Td>&nbsp;</td>
				</tr>
				<tr>
				<td  class="label" width="25%"><fmt:message key="Common.report.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td class="fields" width="25%">
					<SELECT name="p_report_type" id="p_report_type" onchange="changeBookingDate();">
						 <option value="D" selected><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
						 <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
					 </SELECT>
				</td>
				 </tr>
	            <tr>
					 <td colspan=4>&nbsp;</td>
				</tr>

				<tr>
					<td  width="30%">&nbsp;</td>
					<td class="label" width="30%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="label" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				
				<tr>
					<td  class="label" id='label'></td>
					<td	 align="left"  id='dtfrm'></td>
					<td  align="left"  id='dtto'></td>
				</tr>
			 <tr>
					 <td colspan=4>&nbsp;</td>
				</tr>
				<tr>
					<td class='label' ><fmt:message key="Common.booking.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
					<td class="fields" width="25%">
					<SELECT name="p_booking_ind" id="p_booking_ind">
						 <option value="A" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						 <option value="I"><fmt:message key="eIP.IntraHospitalBooking.label" bundle="${ip_labels}"/></option>
						 <option value="E"><fmt:message key="eIP.ExternalHospitalBooking.label" bundle="${ip_labels}"/></option>
						 <option value="N"><fmt:message key="Common.New.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.booking.label" bundle="${common_labels}"/></option>
					 </SELECT>
				</td>
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
	<input type="hidden" name="locale" id="locale"			value="<%= locale %>">

</form>
<script>
	document.forms[0].p_all_facility_id.focus()
</script>
</BODY>
</HTML>

