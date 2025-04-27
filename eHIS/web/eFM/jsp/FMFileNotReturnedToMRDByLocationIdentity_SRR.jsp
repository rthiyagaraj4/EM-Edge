<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%

	Connection conn			= null;
	java.sql.Statement stmt	= null;
	ResultSet rst			= null;
	ResultSet rs			= null;

	String flag="identity";
	String p_module_id		= "FM" ;
	String p_report_id		= "FMBRTMRH" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;

	String maintain_doc_or_file = "";
	String mysql = "SELECT maintain_doc_or_file FROM mp_param where module_id='MP'";
	try
	{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		rst = stmt.executeQuery(mysql);
		if(rst != null && rst.next())
		{
			maintain_doc_or_file = rst.getString("maintain_doc_or_file");
		}
%>

<html>
<HEAD>
<TITLE></TITLE>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>	

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eFM/js/FMCheck_SRR.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest();" onLoad="" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="reportFSLocationIdentity" id="reportFSLocationIdentity" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
			
			<table width='70%' align='center' cellPadding="0" cellSpacing="0">
			<tr><td class='columnheader'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td></tr>			
			</table>

			<table width='70%' cellPadding="5" cellSpacing="0"  align='center' >
			<tr>
			 	<td  width='15%'  class='label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
				<td  width='11%'  class='fields'><select name="p_from_code" id="p_from_code" >
						<option value='' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%							
					       //  String facilityid="";
                           //  String sysdate="";
						%>
						<%
							  try {
									  String sql = "select fs_locn_code,short_desc from fm_storage_locn_lang_vw  where EFF_STATUS='E' and facility_id='"+ p_facility_id + "' and PERMANENT_FILE_AREA_YN='Y' and language_id='"+localeName+"'";
										
										rs = stmt.executeQuery(sql);
									  if( rs != null )
									  {
										  while( rs.next())
										  {
											String classname = rs.getString("fs_locn_code") ;
											String classname1=rs.getString("short_desc");

							%>
							
							<option value='<%= classname %>'><%= classname1%></option>
							
							<%
									  }
							  }

							}
							catch(Exception e) { out.println(e.toString());}
							%>
					</select>
			   </td>
			   <td class="label" width="8%"><fmt:message key="Common.Identity.label" bundle="${common_labels}"/></td>
				<td class="fields" width="22%"><select name="p_to_code" id="p_to_code" >
			   <option value='' selected>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
				<option value='C' ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value='D' ><fmt:message key="Common.department.label" bundle="${common_labels}"/></option>
				<option value='N' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				<option value='E' ><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
				<option value='Y' ><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
				<option value='T' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
	            </select></td>
			</tr>			
			 
			   <tr>
               <td width='20%'  class='label' ><fmt:message key="Common.date.label" bundle="${common_labels}"/> <fmt:message key="Common.criteria.label" bundle="${common_labels}"/>
	           </td>
				<td  class='fields'><select name="p_date_criteria" id="p_date_criteria"  onchange='date_cri_link(this,"<%=flag%>");' > 

				
               <option value=' ' >----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
              <option value='I' ><fmt:message key="Common.Issue.label" bundle="${common_labels}"/> <fmt:message key="Common.date.label" bundle="${common_labels}"/> </option>
			    <option value='P' ><fmt:message key="Common.Pending.label" bundle="${common_labels}"/> <fmt:message key="Common.date.label" bundle="${common_labels}"/> </option> </select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			   </tr>
			
			<tr>
			<tbody>
				<tr>
					<td class="label" width='25%' id="test"></td>
					<td class='fields' width='27%' id="test1"></td>
					<td class='fields' id="test2"></td>
				</tr>
			</tbody>
		</tr>   

			<tr>  
			 
			 <%
			 if(maintain_doc_or_file.equals("F"))
					  {
				%>
				   		   <td class='label' width='20%' ><fmt:message key="eFM.IncludeInpatients.label" bundle="${fm_labels}"/></td>
							<td class='fields'><input type="checkbox" name="p_include_ip" id="p_include_ip" value="" ></td>
							<td class="label" colspan="2">&nbsp;</td>
				<%						
						}
						else if(maintain_doc_or_file.equals("D"))
						{
				%>
						<td class="label" colspan="4">&nbsp;</td>
				<%						
						}				
				%>		
           </tr>


			</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="maintain_doc_or_file" id="maintain_doc_or_file" value="<%= maintain_doc_or_file %>">

</form><%
	if(rs != null)  rs.close();
	if(rst  !=null) rst.close();
	if(stmt !=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception "+e.toString());
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>

</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

