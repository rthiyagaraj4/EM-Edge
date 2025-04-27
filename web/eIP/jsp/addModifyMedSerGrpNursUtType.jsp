<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		
		<script src='../js/MedSerGrpNursUtType.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>

		</script>
		<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
		<%
			request.setCharacterEncoding("UTF-8"); 
			//MMS-ME-SCF-0096 vulnerability Issue
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff"); 
			//MMS-ME-SCF-0096 vulnerability Issue
			Connection con	= null;
			Statement stmt	= null;
			ResultSet rs	= null;

			String facility_id = (String)session.getValue("facility_id");
			
			String med_ser_grp_code = request.getParameter("med_ser_grp_code");

			String fn_val					= "insert";
			String med_ser_grp_desc			= "";
			String nursing_unit_type_code	= "";
			String nursing_unit_type_desc	= "";

		try{
			con = ConnectionManager.getConnection(request);	
			stmt=con.createStatement();
			if(med_ser_grp_code!=null)
			{
				fn_val="modify";
				nursing_unit_type_code = request.getParameter("nursing_unit_type_code");
				StringBuffer modify_sql = new StringBuffer();
				modify_sql.append("select * from Ip_med_ser_grp_nurs_ut_type_vw where "); 
				modify_sql.append("MED_SER_GRP_CODE='"+med_ser_grp_code+"' and ");
				modify_sql.append("facility_id='"+facility_id+"' and  nursing_unit_type_code='"+nursing_unit_type_code+"'");
				rs=stmt.executeQuery(modify_sql.toString());

				while(rs!=null && rs.next())
				{
					 med_ser_grp_code = rs.getString("MED_SER_GRP_CODE");
					 med_ser_grp_desc = rs.getString("MED_SER_GRP_SHORT_DESC");
					 nursing_unit_type_code =rs.getString("nursing_unit_type_code");
					 nursing_unit_type_desc =rs.getString("nursing_unit_type_short_desc");
				}
				if(rs !=null) rs.close(); if(stmt != null) stmt.close();
			}
		%>

		<script>
		</script>
	</head>

	<%if(fn_val.equals("insert")){%>
		  <body onLoad='focusTxt()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%}else{%><body onMouseDown="CodeArrest()" onKeyDown="lockKey()" ><%}%>

		<form name='MedSerGrpNursUtType_Form' id='MedSerGrpNursUtType_Form' method='post' action='../../servlet/eIP.MedSerGrpNursUtTypeServlet' target='messageFrame'>
			<table cellspacing=0 cellpadding=0 align='center' width='100%' height='100%'  border='0'>
				<tr>
					<td height='100%' width='70%' align='middle' class='white'>
					<table cellspacing=0 cellpadding=0 align='center' width='70%' border='0'>
						<tr><td colspan='4'>&nbsp;</td></tr>
						
							<tr>
								<td  class='label' align='right'><fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
								<td>
								<%
								if(fn_val.equals("insert"))
								{
									StringBuffer sql = new StringBuffer();
									sql.append("select short_desc, MED_SER_GRP_CODE from ip_medical_service_group where ");
									sql.append(" facility_id='"+facility_id+"' and eff_status='E' ");
									sql.append(" order by short_desc");
									stmt = con.createStatement();
									rs = stmt.executeQuery(sql.toString());
									%>
									<select name='med_ser_grp_code' id='med_ser_grp_code'>
										<option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
										<%
											while(rs!=null && rs.next())
											{
												out.print("<option value='"+rs.getString(2)+"'>"+rs.getString(1)+"</option>");
											}
											if(rs !=null) rs.close(); if(stmt != null) stmt.close();
												
										%>
								  </select><%
								}
								else
								{
									out.print("<input type='text' name='med_ser_grp_desc' id='med_ser_grp_desc' value=\""+med_ser_grp_desc+"\" readonly>");
									out.print("<input type='hidden' name='med_ser_grp_code' id='med_ser_grp_code' value=\""+med_ser_grp_code+"\">");
								}
							%><img src='../../eCommon/images/mandatory.gif'align='center'></img>
						</td>
					</tr>

							<tr><td colspan='4'>&nbsp</td></tr>
							
							<tr>
								<td  class='label' align='right'><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
								<td>
										<%
											if(fn_val.equals("insert"))
											{	StringBuffer sql = new StringBuffer();
												sql.append("select short_desc, nursing_unit_type_code  from ip_nursing_unit_type where ");
												sql.append("  eff_status='E'  ");
												sql.append(" order by short_desc");
												stmt=con.createStatement();
												rs=stmt.executeQuery(sql.toString());
												%>
													<select name='nursing_unit_type_code' id='nursing_unit_type_code'>
														<option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
														<%
																if(rs!=null)
																{
																	while(rs.next())
																	{
																		out.print("<option value='"+rs.getString(2)+"'>"+rs.getString(1)+"</option>");
																	}
																}
																if(rs !=null) rs.close(); 
																if(stmt != null) stmt.close();
															%>
													</select><%
											}
											else
											{
												out.print("<input type='text' name='nursing_unit_type_desc' id='nursing_unit_type_desc' value=\""+nursing_unit_type_desc+"\" readonly>");
												out.print("<input type='hidden' name='nursing_unit_type_code' id='nursing_unit_type_code' value=\""+nursing_unit_type_code+"\">");
											}
										%><img src='../../eCommon/images/mandatory.gif'align='center'></img>
								</td>
							</tr>
							<tr><td colspan='4'>&nbsp</td></tr>
						</table>
					</td>
				</tr>
			</table>
			<input type='hidden' name='function_name' id='function_name' value="<%=fn_val%>">
		</form>
<%
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	}catch(Exception e) {
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

