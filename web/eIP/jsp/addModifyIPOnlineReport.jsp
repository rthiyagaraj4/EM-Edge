<!DOCTYPE html>
<html>
<!-- 
	Developed By : Chitra 
	Date: 1/8/2001
	Module: IP
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../js/IPOnlineReport.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

	<%
		request.setCharacterEncoding("UTF-8");
		//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
		Connection con	= null;
		PreparedStatement pstmt = null;
		Statement 	stmt = null;
		ResultSet rset		= null ;
		String facilityId		= (String)session.getValue("facility_id");

		String fnval	= "insert";
		StringBuffer sql = new StringBuffer();
		String desc	= "", ID = "";
		String chk1	= "", chk2 = "", chk3 = "", chk4 = "", chk5 = "", chk6 = "";
		String dis = "";

		String nursingunitdesc	= "";
		String reportdesc				= "";
		
		String nursingunitcode	= request.getParameter("nursing_unit_code");
		String reportid					= request.getParameter("report_id");
		nursingunitcode="NU06";
		reportid="IPBDISSH";
		try
		{
		con =ConnectionManager.getConnection(request); 
		if(nursingunitcode!=null )
		{
				fnval="modify";
				
				pstmt=con.prepareStatement("select * from ip_online_report_vw where module_id='IP' and facility_id = ? and report_id = ? and nursing_unit_code = ? ");
				pstmt.setString(1,facilityId);
				pstmt.setString(2,reportid);
				pstmt.setString(3,nursingunitcode);
				
				rset=pstmt.executeQuery();
				
			if(rset.next())
			{
				nursingunitdesc	= rset.getString("nursing_unit_short_desc");
				reportdesc				= rset.getString("report_desc");
				if(rset.getString("print_on_booking_yn").equals("Y"))
					chk1="CHECKED";
				else
					chk1="";

				if(rset.getString("print_on_admission_yn").equals("Y"))
					chk2="CHECKED";
				else
					chk2="";


				if(rset.getString("print_on_transfer_request_yn").equals("Y"))
					chk3="CHECKED";
				else
					chk3="";
			
				if(rset.getString("print_on_conform_transfer_yn").equals("Y"))
					chk4="CHECKED";
				else
					chk4="";

				if(rset.getString("print_on_bed_assigned_yn").equals("Y"))
					chk5="CHECKED";
				else
					chk5="";

				if(rset.getString("print_on_discharge_yn").equals("Y")){
					chk6="CHECKED";
					dis = "";
				}
				else
					chk6="";
			}
			if(rset != null) rset.close(); if(pstmt != null) pstmt.close();
		}

	%>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
  	<form name='IPOnlineReport_form' id='IPOnlineReport_form' action='../../servlet/eIP.IPOnlineReportServlet' method='post' target='messageFrame'>
		 <div>
			 <center>
					
					<table cellpadding=0 cellspacing=0 width="60%" align=center>
					<tr><td colspan=2>&nbsp;</td></tr>

					<tr>
						<td align=right class=label  width="35%"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td align=left>
							<%if(fnval.equals("insert")){%>
							<select name="nursing_unit_code" id="nursing_unit_code">
								<option value=''>&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;
								<option value='*ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
								<%
										sql.append(" select short_desc,nursing_unit_code  from ip_nursing_unit where facility_id='"+facilityId+"'  and eff_status='E' order by short_desc ");
										stmt = con.createStatement();
										rset = stmt.executeQuery(sql.toString());
										while(rset.next())
										{
											desc = rset.getString("short_desc");
											ID = rset.getString("nursing_unit_code");
											out.print("<option value='"+ID+"' >"+desc+"");
										}
									if(rset != null) rset.close(); 
									if(stmt != null) stmt.close();
								%>
							</select>
							<%} else
										out.print("<input type=text size=30 readonly value='"+nursingunitdesc+"' ><input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='"+nursingunitcode+"' >");
							%>
							<img align=center src='../../eCommon/images/mandatory.gif'></img>
						</td>
					</tr>
								
					<tr>
						<td align=right class=label><fmt:message key="Common.report.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td align=left>
							<%if(fnval.equals("insert")){%>
							<select name="report_id" id="report_id" onchange="enableDisable(this.value);"><option value=''>&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;
								<%
										
										if(sql.length() > 0) sql.delete(0,sql.length());
										sql.append(" select report_id, report_desc from sm_report  where internal_request_yn = 'Y' and module_id = 'IP' ");
										stmt = con.createStatement();
										rset = stmt.executeQuery(sql.toString());
										while(rset.next())
										{
											desc = rset.getString("report_desc");
											ID = rset.getString("report_id");
											out.print("<option value='"+ID+"' >"+desc+"");
										}
										if(rset != null) rset.close(); 
										if(stmt != null) stmt.close();
								%>
							</select>
							<%
								} else
										out.print("<input type=text size=30 readonly value='"+reportdesc+"' ><input type='hidden' name='report_id' id='report_id' value='"+reportid+"' >");		
							%>
							<img align=center src='../../eCommon/images/mandatory.gif'></img>
						</td>
					</tr>

					<tr><td colspan=2>&nbsp;</td></tr>
					</table>

					<br>

					<table cellpadding=0 cellspacing=0 width="60%" align=center>
					<tr><th align=left colspan=4><fmt:message key="Common.PrintAt.label" bundle="${common_labels}"/></th></tr>

					<tr>
						 <td align=right class=label width="35%"><fmt:message key="Common.booking.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td  width="15%"><input type="checkbox" value="Y" name="print_on_booking_yn" id="print_on_booking_yn"  <%=chk1%> disabled></td> 
						<!-- <input type="hidden" value="N" name="print_on_booking_yn" id="print_on_booking_yn" > -->
						<td align=right class=label><fmt:message key="eIP.TransferConfirmation.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
						<td><input type="checkbox" value="Y" name="print_on_conform_transfer_yn" id="print_on_conform_transfer_yn" <%=chk4%>></td>						
					</tr>

					<tr>
						<td align=right class=label><fmt:message key="eIP.AdmissionWithBed.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
						<td><input type="checkbox" value="Y" name="print_on_bed_assigned_yn" id="print_on_bed_assigned_yn" <%=chk5%>></td>
						<td align=right class=label  width="30%"><fmt:message key="eIP.TransferRequest.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
						<td><input type="checkbox" value="Y" name="print_on_transfer_request_yn" id="print_on_transfer_request_yn" <%=chk3%>></td>	
					</tr>

					<tr>
						<td align=right class=label width="40%"><fmt:message key="eIP.AdmissionWithoutBed.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
						<td><input type="checkbox" value="Y" name="print_on_admission_yn" id="print_on_admission_yn" <%=chk2%>></td>
					    <td align=right class=label><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td><input type="checkbox" value="Y" <%=dis%> name="print_on_discharge_yn" <%=chk6%>></td>

					</tr>
					
					</table>
			 </center>
	     </div>
		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
   	</form>
		
	<%
		if(fnval.equals("modify"))
			out.print("<script>enableDisable('"+reportid+"')</script>");

			if( rset != null) rset.close();
			if( stmt != null) stmt.close();
			if( pstmt != null) pstmt.close();

		}catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request); 

		}
	%>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

