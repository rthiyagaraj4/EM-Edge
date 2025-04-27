<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");	
%>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<script src="../js/repYrRegnAgeStat.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script>
function validateYear(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'YY',localeName)==false)
				{
				alert(getMessage("INVALID_YEAR_FMT", "SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}
</script>
<%
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBPERGS" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");

	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	ResultSet rset = null;

%>

<center>
	<form name="repYrRegnAgeStat" id="repYrRegnAgeStat" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->
		<table border="0" width="60%" cellpadding='3' cellspacing='0' align='center'>

			<tr>
				<td width='25%'>&nbsp;</td>
				<td width='25%'>&nbsp;</td>
				<td width='15%'>&nbsp;</td>
				<td width='35%'>&nbsp;</td>
			</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='P_facilityid' id='P_facilityid'> <!-- onChange='onChangeFacilityId()'> -->
				<%
					try
					{
					con = ConnectionManager.getConnection(request);
					String fid;
					String fname;
					String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2 ";					
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
					}catch(Exception e)
					{
						
					}

					finally
						{
							try
							{	
							if (rset != null) rset.close();
							if (pstmt != null) pstmt.close();
							}
							catch(Exception e) { }
							

						}
%>
				</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
			<tr>
				<td class="label" ><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/></td>
				<td class='fields'  colspan="3"><select name="p_age_range_code" id="p_age_range_code" >
					<option value='' >-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
					<%
						try
						{
							pstmt 	= con.prepareStatement( "select range_id, long_desc from am_summ_range_lang_vw where range_type='A' and language_id='"+localeName+"' and  trunc(sysdate) between nvl(trunc(eff_date_from),trunc(sysdate)) and nvl(trunc(eff_date_to),trunc(sysdate)) and eff_status ='E' order by 2");

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
				<td class="label" ><fmt:message key="eMP.RegnYearFrom.label" bundle="${mp_labels}"/></td>
				<td class='fields' ><input type="text" name="p_fm_date" id="p_fm_date" size="4" maxlength="4" onBlur="validateYear(this);"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_to_date" id="p_to_date" size="4" maxlength="4" onBlur="validateYear(this);"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>

		<br>

		<input type="hidden" name="p_dtype" id="p_dtype"			value="Y">
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_fm_regndate" id="p_fm_regndate" >
		<input type="hidden" name="p_to_regndate" id="p_to_regndate" >
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
	</form>

</center>


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

