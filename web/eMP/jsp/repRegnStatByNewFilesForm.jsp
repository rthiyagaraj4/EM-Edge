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
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eMP/js/repRegnStatByNewFiles.js"></script>
<body onLoad="mychangerepMPRegnStatNew()">
<%
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBSTNFO" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");

	Connection con = null;
	PreparedStatement pstmt = null;	
	ResultSet rset = null;

%>

<center>
	<form name="repMonStatNewFiles" id="repMonStatNewFiles" action="../../eCommon/jsp/report_options.jsp" target="messageFrame" >
	<BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->
		<table cellpadding='3' cellspacing='0' width='60%' align='center'>

		<tr>
				<td width='20%'>&nbsp;</td>
				<td width='20%'>&nbsp;</td>
				<td width='4%'>&nbsp;</td>
				<td width='16%'>&nbsp;</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='P_facilityid' id='P_facilityid'>  <!-- onChange='onChangeFacilityId()' -->
				<%
				try
				{
					String fid;
					String fname;
					con = ConnectionManager.getConnection(request);
					String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  1";					
					pstmt=con.prepareStatement(sql1);
					rset= pstmt.executeQuery(sql1);
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

				}catch(Exception e){
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
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td> 
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
		 <tr>
			<td class="label" ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class='fields'><SELECT name="p_type" id="p_type" onChange="mychangerepMPRegnStatNew()">		 
						 <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
						 <td >&nbsp; </td>
						 <td>&nbsp;</td>
			</tr>

			<!-- <tr>
				<td align="right" class="label" width="40%">
					Month From
				</td>

				<td align="left" width="17%">
					&nbsp;&nbsp;<input type="text" id='regndatestatfrom'  name="P_fr_regn_date" id="P_fr_regn_date" size="7" maxlength="7" onBlur="CheckMonth(this)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regndatestatfrom', 'mm/y', null);">&nbsp;
				<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td align="left" width="3%" class="label">
					&nbsp;&nbsp;To&nbsp;&nbsp;
				</td>
				<td align="left" width="40%">
					<input type="text" id='regndatestatto' name="P_to_regn_date" id="P_to_regn_date" size="7" maxlength="7" onBlur="CheckMonth(this)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regndatestatto', 'mm/y', null);">&nbsp;
				<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr> -->
				<tr>
					<td align='right' id='MY1'class="label"></td>
					<td class='fields' id='MY'>&nbsp;&nbsp;</td><td class="label" >&nbsp;&nbsp;</td>
					<td align='left' id='MY2' >
				</tr>

			<tr>
				<td class="label" ><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></td>


				<td class='fields'>
					<input type="text" name="p_fr_org_id" id="p_fr_org_id" size="15" maxlength="20" ><input type='button' name='organization' id='organization' value='?' class='button' onclick='searchCode(this, p_fr_org_id)'>				
				</td>
				<td class="label" >&nbsp;&nbsp;</td>
				<td class='fields'>
					<input type="text" name="p_to_org_id" id="p_to_org_id" size="15" maxlength="20" ><input type='button' name='organization' id='organization' value='?' class='button' onclick='searchCode(this, p_to_org_id)'>&nbsp;				
				</td>
			</tr>

			<tr>
				<td colspan=4>&nbsp;</td>
			</tr>

		</table>

		<br>
		<input type="hidden" name="p_dtype" id="p_dtype"			value="M">
		<input type="hidden" name="p_fm_regndate" id="p_fm_regndate">
		<input type="hidden" name="p_to_regndate" id="p_to_regndate">
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

