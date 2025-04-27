<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");

	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
	<script src="../../eCommon/js/common.js" language="JavaScript"></script>
	<script src="../../eCommon/js/messages.js"></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<Script src="../js/repMthlyOutcomeofDely.js" language="JavaScript"></Script>
 <% 
	String p_module_id	= "MP" ;
	String p_report_id	= "MPBMODLW" ;
	String p_facility_id = (String) session.getAttribute( "facility_id" ) ;
	String p_user_name	= (String) session.getAttribute( "login_user" ) ;
	String p_resp_id = (String)session.getAttribute("responsibility_id");
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	ResultSet rs = null;
%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()' onLoad="mychgrepMPMthlyOtcome()">
<center>
<form name="repMthlyOutcomeofDely" id="repMthlyOutcomeofDely" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR> 
<table cellpadding='3' cellspacing='0' width='60%' align='center'>
<tr>
	<td width='20%'>&nbsp;</td>
	<td width='20%'>&nbsp;</td>
	<td width='4%'>&nbsp;</td>
	<td width='16%'>&nbsp;</td>
</tr>
<tr>
		<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name='P_facilityid' id='P_facilityid'>
				<%
				try
				{
				con = ConnectionManager.getConnection(request);
				stmt=con.createStatement();
				String fid;
				String fname;
				StringBuffer sql1 = new StringBuffer("select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='");
				sql1.append(p_user_name);
				sql1.append("' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '");
				sql1.append(p_resp_id);
				sql1.append("') order by 2 ");					

				rset=stmt.executeQuery(sql1.toString());
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
					if (rset != null) rset.close();
					if (stmt != null) stmt.close();
				}catch(Exception e){
					out.println(e);
				}
				%>
		</select>
		</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	   <tr>
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td> 
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
	<tr>
		<td class="label" ><fmt:message key="Common.month.label" bundle="${common_labels}"/></td>

		<td class="fields"><input type="text" name="p_fr_birth_date" id="p_fr_birth_date" size="7" maxlength="7" onBlur="validDateObj(this,'MY',localeName)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_fr_birth_date','mm/y',null);"><img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td class="label">&nbsp;</td>
		<td class="fields"><input type="text" name="p_to_birth_date" id="p_to_birth_date" size="7" maxlength="7" onBlur="validDateObj(this,'MY',localeName)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_birth_date','mm/y',null);">&nbsp;
		<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>
	<tr>
		<td align='right' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></td>
		<td class="fields"><SELECT name="p_type" id="p_type" onChange="mychgrepMPMthlyOtcome()">	 <option value="D"><fmt:message key="Common.outcome.label" bundle="${common_labels}"/>&nbsp;-&nbsp;<fmt:message key="eMP.BirthWeight.label" bundle="${mp_labels}"/></option>
		 <option value="B"><fmt:message key="eMP.BornWhere.label" bundle="${mp_labels}"/></option>
		 </SELECT>
		 </td>
		 <td >&nbsp; </td>
		 <td>&nbsp;</td>
	</tr>
	<tr>
				<td align='right' id='MY1'class="label"></td>
				<td id='age_del' class="fields"  colspan="3"><select name="p_age_range_code" id="p_age_range_code" >
					<option value="">-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
					<%
						try
						{
							pstmt 	= con.prepareStatement( "select range_id, long_desc from am_summ_range where range_type='A' and  trunc(sysdate) between nvl(trunc(eff_date_from),trunc(sysdate)) and nvl(trunc(eff_date_to),trunc(sysdate)) and eff_status ='E' order by 2");

					      	rs = pstmt.executeQuery() ;

							if( rs != null )
							{
								while( rs.next() )
								{
									String range_id 	= rs.getString( "range_id" ) ;
									String long_desc 	= rs.getString( "long_desc" ) ;
									out.println( "<option value='"+range_id+"' >"+long_desc+"</option>") ;
								}
					      	}
						}catch(Exception e) { }
						finally
						{
							try
							{
							if (rs != null) rs.close();
							if (pstmt != null) pstmt.close();
							if(con!=null) ConnectionManager.returnConnection(con,request);
							}
							catch(Exception e) { }
						}
				
					%>
					</select><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
<tr><td colspan ='4'>&nbsp;</td></tr>
<!-- <tr>
	<td align="right" class="label" width="40%">Outcome </td>
	<td class='label'>&nbsp;&nbsp;<select name="outcome" id="outcome" >
					<option value='L'>Live</option>
					<option value='SF'>Still Born-Fresh</option>
					<option value='SM'>Still Born-Macerated</option>
					</select>
	</td>
	<td colspan ='2'>&nbsp;</td>
</tr>
<tr><td colspan ='4'>&nbsp;</td></tr> -->
</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
</form>
</center>
</body>
</html>

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

