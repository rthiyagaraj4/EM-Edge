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
	<script src="../../eCommon/js/messages.js"></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/DateUtils.js"></script>
	<script src="../js/repMorbMortStatForm.js"></script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBMRMOT" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");
	//String locale = (String)session.getAttribute("LOCALE");


	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet rset = null;

%>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="changerepIPMrbnMor()">
<center>
	<form name="repMorbMortStat" id="repMorbMortStat" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
			<!-- To Populate Facility List -->
			<tr>
				<td class="label">&nbsp;</td>
				<Td class="label">&nbsp;</td>
			</tr>
			<tr>
			<td  class="label" align="right"><fmt:message key="Common.facility.label" bundle="${common_labels}"/> </td>
			<td colspan ="3"><select name='P_facilityid' id='P_facilityid'>  <!-- onChange='onChangeFacilityId()' -->
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
				}
				finally{
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
				<td align="center" width="25%">&nbsp;</td>
				<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td class="querydata" width="20%">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
				<td align='right' width='10%' class="label"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.month.label" bundle="${common_labels}"/></td>
				<td class="fields" width='30%'><input type="text" id='regnagenatstatfrom'  name="p_fr_visit_date" id="p_fr_visit_date" size="7" maxlength="7" onblur="if(validDateObj(this,'MY',localeName)){chkWithSysDt(this);}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatfrom','mm/y', null);"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				
				<td class="fields" width='30%'><input type="text" id='regnagenatstatto' name="p_to_visit_date" id="p_to_visit_date" size="7" maxlength="7" onblur="if(validDateObj(this,'MY',localeName)){chkWithSysDt(this);}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatto','mm/y', null);"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
					<td colspan=4>&nbsp;</td>
			</tr>
			<tr>
				<td  class="label" align="right"><fmt:message key="eIP.agerange.label" bundle="${ip_labels}"/></td>
				<td align="left"  colspan="3">
					<select name="p_range_id" id="p_range_id" >
					<option value='' >&nbsp;------------<fmt:message key="Common.Select.label" bundle="${common_labels}"/>------------&nbsp;</option>
					<%
						try{
							pstmt 	= con.prepareStatement( "select range_id, long_desc from am_summ_range where range_type='A' and  trunc(sysdate) between nvl(trunc(eff_date_from),trunc(sysdate)) and nvl(trunc(eff_date_to),trunc(sysdate)) and eff_status ='E' order by 2");
					      	rs = pstmt.executeQuery() ;
							if( rs != null ){
								while( rs.next() ){
									String range_id 	= rs.getString( "range_id" ) ;
									String long_desc 	= rs.getString( "long_desc" ) ;
									out.println( "<option value='"+range_id+"' >"+long_desc+"</option>") ;
								}
					      	}
						}catch(Exception e) { }
						finally{
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
					<td colspan=4>&nbsp;</td>
			</tr>

			<tr>
					<td align='right' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td><SELECT name="p_report_type" id="p_report_type" onChange='changerepIPMrbnMor()'>
						 <option value="MR"><fmt:message key="eIP.morbidity&mortality.label" bundle="${common_labels}"/></option>
						 <option value="DBN"><fmt:message key="eIP.deathsbynationality.label" bundle="${common_labels}"/></option>
						 <option value="ECD"><fmt:message key="eIP.externalcauseofdeath.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
						 <td >&nbsp; </td>
						 <td>&nbsp;</td>
			</tr>

            <tr>
				 <td colspan=4>&nbsp;</td>
			</tr> 
			<tr>
					<td align='right' id='MY1'class="label"></td>
					<td align='left' id='MY'>&nbsp;&nbsp;</td><td align='left' id='MY2' >
				</tr>
				<tr>
					<td colspan=4>&nbsp;</td>
				</tr>
		<!-- <tr id='tab_label'>
				<td align="right" class="label" width="40%">
					Tab List No From
				</td>

				<td align="left" width="17%">
					&nbsp;&nbsp;<input type="text" name="p_tab_list_fr" id="p_tab_list_fr" size="15" maxlength="20" ><input type='button' name='tab_list' id='tab_list' value='?' class='button' onclick='searchCode(this, p_tab_list_fr)'>&nbsp;
				
				</td>
				<td align="left" width="3%" class="label">
					&nbsp;&nbsp;To&nbsp;&nbsp;
				</td>
				<td align="left" width="40%">
					<input type="text" name="p_tab_list_to" id="p_tab_list_to" size="15" maxlength="20" ><input type='button' name='tab_list' id='tab_list' value='?' class='button' onclick='searchCode(this, p_tab_list_to)'>&nbsp;
				
				</td>
			</tr>
				<tr>
				 <td colspan=4>&nbsp;</td>
				 </tr> -->
		<!-- <tr>
				<td align="right" class="label" width="40%">
					ICD code From
				</td>

				<td align="left" width="17%">
					&nbsp;&nbsp;<input type="text" name="ICD_code_fm" id="ICD_code_fm" size="15" maxlength="20" ><input type='button' name='ICD_code' id='ICD_code' value='?' class='button' onclick='searchCode(this, ICD_code_fm)'>&nbsp;
				
				</td>
				<td align="left" width="3%" class="label">
					&nbsp;&nbsp;To&nbsp;&nbsp;
				</td>
				<td align="left" width="40%">
					<input type="text" name="ICD_code_to" id="ICD_code_to" size="15" maxlength="20" ><input type='button' name='ICD_code' id='ICD_code' value='?' class='button' onclick='searchCode(this, ICD_code_to)'>&nbsp;
				
				</td>
			</tr>
				<tr>
				 <td colspan=4>&nbsp;</td>
				 </tr> -->
</table>
	</td>
</tr>
</table>
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

