<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String p_module_id		= "MR" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	Connection	con		=	null;
	String p_resp_id			=	(String) session.getValue("responsibility_id");
	String p_report_id			=	"MRBPD207";
	Statement stmt;
	ResultSet rset;
%>
<html>	 
<HEAD>
<TITLE></TITLE>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/CommonCalendar.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../js/repPD207.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad="mychange()">
<br>
<br>
<form name="RepPD207Form" id="RepPD207Form" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> Report Criteria
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='70%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align="left" class="label" > Facility &nbsp;</td>
					<td colspan ="3"> 
							<select name='p_all_facility_id' id='p_all_facility_id' >
						<%
							String fid="";
							String fname="";
							String sql1="";
							try
							{
								con		=	ConnectionManager.getConnection(request);
							 stmt=con.createStatement();
							 sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";					
							rset=stmt.executeQuery(sql1);
							if(rset!=null)
							{
							   while(rset.next())
							   {
								fid=rset.getString("facility_id");
								fname=rset.getString("facility_name");
								if(fid.equals("All"))
								{
								}
								else
								{
									out.println("<option value='"+fid+ "'  >"+fname+"</option>");
								}
							   }
							}
							if(rset!=null)rset.close();
							if(stmt!=null)stmt.close();
							}catch(Exception e)
							{
								//out.println(e);
								e.printStackTrace();
							}
							finally { 
									ConnectionManager.returnConnection(con,request);
									}


						%> <tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>		
				<tr>
					<td align='left' width='30%' class="label">Report Type&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_report_type" id="p_report_type" onchange='mychange()'>
						 <option value="M">Month</option>
						 <option value="Y">Year</option>
						 </SELECT>
					</td>
					 <td colspan ='3'> 
				</tr>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;&nbsp;</td>
					<td width='25%'  ></td>
					<td colspan ='3'></td>
					<td colspan ='3'></td>
				</tr>
				<tr>
						<td align='left' id='MY1'class="label"> &nbsp; &nbsp;</td>
						<td align='left' id='MY' > &nbsp; </td><td> </td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  ></td>
					<td colspan ='3'></td>
					
				</tr>
					
					</td>
					<td colspan ='2'>
				</tr>
		</table>
	</td>
</tr>
</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id" 		value="<%=p_resp_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
	<input type="hidden" name="p_date_fmt" id="p_date_fmt"	value="">
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

