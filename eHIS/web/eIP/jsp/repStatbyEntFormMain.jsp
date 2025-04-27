<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
	<script src="../../eCommon/js/common.js" language="JavaScript"></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/DateUtils.js"></script>
	<script src="../js/repStatbyEntForm.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	request.setCharacterEncoding("UTF-8");
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBSTBEN" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");
	//String locale = (String)session.getAttribute("LOCALE");


	Connection con = null;
	PreparedStatement pstmt = null;
	//ResultSet rs = null;
	ResultSet rset = null;

%>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<center>
	<form name="repStatbyEnt" id="repStatbyEnt" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->
	<table cellpadding='0' cellspacing='0' align='center' border="0" width="70%" >
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	</table>
		<table cellpadding='0' cellspacing='0' align='center' border="0" width="70%">
			<tr>
				<td width='20%'>&nbsp;</td>
				<td width='20%'>&nbsp;</td>
				<td width='4%'>&nbsp;</td>
				<td width='16%'>&nbsp;</td>
			</tr>
			<tr>
				<td  class="label" width="25%"> <fmt:message key="Common.facility.label" bundle="${common_labels}"/> </td>
				<td> 
					<select name='p_facilityid' id='p_facilityid'> 
					<%
						try{
							String fid;
							String fname;
							con = ConnectionManager.getConnection(request);
							String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";					
							pstmt=con.prepareStatement(sql1);
							rset= pstmt.executeQuery(sql1);
							if(rset!=null){
								   while(rset.next()){
										fid=rset.getString("facility_id");
										fname=rset.getString("facility_name");
										if(fid.equals("All"))
										out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
										else
										out.println("<option value='"+fid+ "' >"+fname+"</option>");
								   }
							}

						}catch(Exception e){

							
							e.printStackTrace();
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
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				 <td colspan=4>&nbsp;</td>
			</tr>
			<tr>
				<td  class="label" width="25%"><fmt:message key="Common.report.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td class="fields" width="25%">
					<SELECT name="p_report_type" id="p_report_type">
						 <option value="ADM"><fmt:message key="Common.Admitted.label" bundle="${common_labels}"/></option>
						 <option value="DIS"><fmt:message key="Common.discharged.label" bundle="${common_labels}"/></option>
						 <option value="DTH">Death</option>
					 </SELECT>
				</td>
				 <td >&nbsp; </td>
				 <td>&nbsp;</td>
				</tr>
	            <tr>
					 <td colspan=4>&nbsp;</td>
				</tr> 
				<tr>
					<td align="center" width="25%">&nbsp;</td>
					<td class="querydata" width="25%">&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="25%">&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td  class="label" width="25%"><fmt:message key="Common.month.label" bundle="${common_labels}"/></td>
					<td align="left" width="25%">
						<input type="text" id='regndatestatfrom'  name="p_fr_trn_date" id="p_fr_trn_date" size="7" maxlength="7" onBlur="if(validDateObj(this,'MY',localeName)){chkWithSysDt(this);}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regndatestatfrom', 'mm/y', null);"><img src='../../eCommon/images/mandatory.gif'></img>
					</td>
					<td align="left" width="25%">
						<input type="text"  name="p_to_trn_date" id="p_to_trn_date" size="7" maxlength="7" onBlur="if(validDateObj(this,'MY',localeName)){chkWithSysDt(this);}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_trn_date', 'mm/y', null);"><img src='../../eCommon/images/mandatory.gif'></img>
					</td>
			</tr>
			<tr>
				 <td colspan=4>&nbsp;</td>
			</tr>
			<tr>
				<td  class="label" width="25%"> <fmt:message key="Common.Organization.label" bundle="${common_labels}"/></td>
				<td align="left" width="25%">
					<input type="text" name="p_fr_org_id" id="p_fr_org_id" size="15" maxlength="20" ><input type='button' name='organization' id='organization' value='?' class='button' onclick='searchCode(this, p_fr_org_id)'>&nbsp;		
				</td>
				<td align="left" width="40%">
					<input type="text" name="p_to_org_id" id="p_to_org_id" size="15" maxlength="20" ><input type='button' name='organization' id='organization' value='?' class='button' onclick='searchCode(this, p_to_org_id)'>&nbsp;		
				</td>
			</tr>
			<tr>
				<td colspan=4>&nbsp;</td>
			</tr>
		</table>
		<br>
			<input type="hidden" name="p_dtype" id="p_dtype"	value="M">
			<input type="hidden" name="p_fm_regndate" id="p_fm_regndate">
			<input type="hidden" name="p_to_regndate" id="p_to_regndate">
			<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
			<input type="hidden" name="p_module_id" id="p_module_id" value="<%= p_module_id %>">
			<input type="hidden" name="p_report_id" id="p_report_id"  value="<%= p_report_id %>"> 
			<input type="hidden" name="p_user_name" id="p_user_name" value="<%= p_user_name %>">
			<input type="hidden" name="p_resp_id" id="p_resp_id"  value="<%= p_resp_id %>">
			</form>
		</center>
	</body>
</html>

<%!	
	private String checkForNull(String inputString){
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

