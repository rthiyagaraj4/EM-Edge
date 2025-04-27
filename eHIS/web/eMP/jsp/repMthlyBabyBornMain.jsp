<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");

	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
	<script src="../../eCommon/js/messages.js"></script>
	<script src="../../eCommon/js/common.js" language="JavaScript"></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script src="../js/repMthlyBabyBorn.js"></script>

<%
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBMOTBB" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");

	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	ResultSet rset = null;

%>
<body onKeyDown = 'lockKey()'>
<BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->
<center>
	<form name="repMthlyBabyBorn" id="repMthlyBabyBorn" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
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
					String fid;
					String fname;
					con = ConnectionManager.getConnection(request);
					String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";					
					pstmt=con.prepareStatement(sql1);

					rset=pstmt.executeQuery(sql1);
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
					if (pstmt != null) pstmt.close();
					}catch(Exception e) { }
					finally
						{
							try
							{
							if (pstmt != null) pstmt.close();
							if (rset != null) rset.close();
							}
							catch(Exception e)
							{
							}

						}
				
 %>
				</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

<tr>
			<td class="label" ><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/></td>
				<td class='fields' colspan="3">	<select name="p_range_id" id="p_range_id" >
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


		<tr>

				<td class="label" ><fmt:message key="Common.month.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>


				<td class="fields"><input type="text" id='dlyregnagefrom' name="p_fr_birth_date" id="p_fr_birth_date" size="7" maxlength="7" onBlur="validDateObj(this,'MY',localeName)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dlyregnagefrom','mm/y',null);"><img src='../../eCommon/images/mandatory.gif'></img>

				</td>
				<td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class="fields"><input type="text" id='dlyregnageto' name="p_to_birth_date" id="p_to_birth_date" size="7" maxlength="7" onBlur="validDateObj(this,'MY',localeName)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dlyregnageto','mm/y',null);"><img src='../../eCommon/images/mandatory.gif'></img>

				</td>
			</tr>


		</table>

		<br>

		<input type="hidden" name="p_dtype" id="p_dtype"			value="D">
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
	</form>

</center>
</body>


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

