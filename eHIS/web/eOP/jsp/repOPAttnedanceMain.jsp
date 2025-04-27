<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
request.setCharacterEncoding("UTF-8"); 
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eOP/js/repOPAttnedance.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>


<%
	String p_module_id		= "OP" ;
	String p_report_id		= "OPREGATT" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");

	Connection con = null;
	PreparedStatement pstmt = null;	
	ResultSet rset = null;

%>

<center>
	<form name="repOPAttnedance" id="repOPAttnedance" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR><BR><BR><BR><BR><BR><!--BR><BR><BR><BR><BR><BR><BR><BR-->
		<table width='60%' align='center' cellpadding='0' cellspacing='0'>
		<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
		</table>
		<table cellpadding='2' cellspacing='0' align='center' border="0" width="60%">	
		<tr><td colspan='4'>&nbsp;</td></tr> 
		<tr>
			<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan='3'><select name='P_facilityid' id='P_facilityid'>  <!-- onChange='onChangeFacilityId()' -->
				<%
				try
				{
					String fid;
					String fname;
					con = ConnectionManager.getConnection(request);
					//String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";	
					
					String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"' and p.language_id='"+localeName+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";	

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
							if(con!=null) ConnectionManager.returnConnection(con,request);
							}
							catch(Exception e) { }
							

						}
				
%>
				</select>
			</td>			
		</tr>        
		
				<tr>
			<td width='33%'>&nbsp;</td>
			<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>

			<tr>
				<td class="label" width='26%'><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></td>
				<td class='fields' width='32%'><input type="text" id='attvisitdatefrom'  name="P_fr_visit_date" id="P_fr_visit_date" size="10" maxlength="10" onBlur="if(validDateObj(this,'DMY',localeName)){chkWithSysDt(this);}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('attvisitdatefrom', null);"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td class='fields'><input type="text" id='attvisitdateto' name="P_to_visit_date" id="P_to_visit_date" size="10" maxlength="10" onBlur="if(validDateObj(this,'DMY',localeName)){chkWithSysDt(this);}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('attvisitdateto', null);"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td class="label">
					<fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>

				<td class='fields'><input type="text" name="p_fr_clinic_code" id="p_fr_clinic_code" size="15" maxlength="20" onblur="getTablistData(document.forms[0].clinic,this)" ><input type='button' name='clinic' id='clinic' value='?' class='button' onclick='searchCode(this, p_fr_clinic_code)'>				
				</td>
				<td class='fields'><input type="text" name="p_to_clinic_code" id="p_to_clinic_code" size="15" maxlength="20" onblur="getTablistData(document.forms[0].clinic,this)" ><input type='button' name='clinic' id='clinic' value='?' class='button' onclick='searchCode(this, p_to_clinic_code)'></td>
			</tr>
		</table>

		<br>
		<input type="hidden" name="p_dtype" id="p_dtype"			value="M">		
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
		<input type="hidden" name="locale" id="locale"			value="<%= localeName %>">

         <input type="hidden" name="p_from_clinic_code" id="p_from_clinic_code"			value="">
		<input type="hidden" name="p_too_clinic_code" id="p_too_clinic_code"			value="">

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>


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

